#version 300 es
precision highp float;

uniform vec2  iResolution;
uniform float iTime;
uniform float u_originX;
uniform float u_originY;
// 设计师可调的两个混色（RGB，0~1）：蓝默认 1975FF、橙默认 FF5500
uniform vec3  u_blendColor1;
uniform vec3  u_blendColor2;

out vec4 fragColor;

// 三次贝塞尔缓动（牛顿迭代解参数）
float cubicBezier(float x, float x1, float y1, float x2, float y2) {
    x = clamp(x, 0.0, 1.0);
    float u = x;
    for (int i = 0; i < 6; i++) {
        float v = 1.0 - u;
        float bx  = 3.0 * v * v * u * x1 + 3.0 * v * u * u * x2 + u * u * u;
        float dbx = 3.0 * v * v * x1 + 6.0 * v * u * (x2 - x1) + 3.0 * u * u * (1.0 - x2);
        u -= (bx - x) / max(dbx, 1e-4);
        u = clamp(u, 0.0, 1.0);
    }
    float v = 1.0 - u;
    return 3.0 * v * v * u * y1 + 3.0 * v * u * u * y2 + u * u * u;
}

float track(float tms, float delay, float dur, float x1, float y1, float x2, float y2) {
    float p = clamp((tms - delay) / dur, 0.0, 1.0);
    return cubicBezier(p, x1, y1, x2, y2);
}

// 柔和高斯色云：中心 c(uv 空间)、sigma(uv 空间软半径)。返回 [0,1] 强度，边缘自然衰减到 0。
float blob(vec2 uv, vec2 c, float sigma) {
    vec2 d = uv - c;
    return exp(-dot(d, d) / (2.0 * sigma * sigma));
}

// 椭圆羽化遮罩动画 GLSL ES 版本（循环周期 583ms）。与 mesh.agsl 同步。
void main() {
    // 对齐 AGSL 左上原点
    vec2 fragCoord = vec2(gl_FragCoord.x, iResolution.y - gl_FragCoord.y);
    vec2 uv = fragCoord / iResolution;
    float t = iTime;

    const float DW = 1170.0;
    const float DH = 2530.0;
    const float CYCLE_MS = 583.0;

    float tms = fract(t * (1000.0 / CYCLE_MS)) * CYCLE_MS;

    float expandE = track(tms, 147.0, 436.0, 0.30, 0.00, 1.00, 1.00);

    // 尺寸：椭圆宽度 301→1354，高度 116→2585，按设计画布归一化
    float sizeE = expandE;
    float diaX = mix(301.0, 1354.0, sizeE);
    float diaY = mix(116.0, 2585.0, sizeE);
    float rx = (diaX * 0.5) / DW;
    float ry = (diaY * 0.5) / DH;
    float exitScale = mix(1.0, 2.5, expandE);
    rx *= exitScale;
    ry *= exitScale;

    // 位置：X 水平居中；Y 从屏幕底部 2179 上移到屏幕中心 1265(=DH/2)
    float posE = expandE;
    float cx = u_originX;
    float cy = mix(2179.0 / DH, 1265.0 / DH, posE);
    vec2 center = vec2(cx, cy);

    float ease = sizeE;

    // 透明度三段（连续）
    float op1 = track(tms,  50.0,  97.0, 0.18, 0.18, 0.56, 0.68) * 0.30;
    float op2 = mix(0.30, 0.60, track(tms, 147.0, 194.0, 0.38, 0.58, 0.84, 1.00));
    float op3 = mix(0.60, 0.00, track(tms, 341.0, 242.0, 0.17, 0.00, 0.83, 1.00));
    float opacity;
    if (tms < 147.0) {
        opacity = op1;
    } else if (tms < 341.0) {
        opacity = op2;
    } else {
        opacity = op3;
    }

    vec2 p = uv - center;
    float angle = atan(p.y, p.x);

    float s2 = sin(angle * 2.0 + t * 0.55);
    float s3 = sin(angle * 3.0 + t * 0.41 + 1.70);
    float s4 = sin(angle * 4.0 + t * 0.78 + 3.00);
    float s6 = sin(angle * 6.0 + t * 0.62 + 0.80);

    float outerWa = ease * 0.10;
    float outerWarp = 1.0 + outerWa * (s2 + 0.75 * s3 + 0.55 * s4 + 0.30 * s6);
    float outerD = length(vec2(p.x / max(rx, 0.001), p.y / max(ry, 0.001))) / max(outerWarp, 0.5);
    float outerMask = 1.0 - smoothstep(0.60, 1.10, outerD);

    float innerScale = 0.62;
    float innerWa = ease * 0.13;
    float innerWarp = 1.0 + innerWa * (s2 + 0.65 * s3);
    float innerD = length(vec2(p.x / max(rx * innerScale, 0.001), p.y / max(ry * innerScale, 0.001))) / max(innerWarp, 0.5);
    float innerMask = smoothstep(0.68, 1.05, innerD);

    float mask = outerMask * innerMask * opacity;

    // ── 两色大色云(蓝 2833FF + 橙 FF9137)：橙偏上、蓝偏下，各 2 团柔和高斯云中心无规则环绕 ──
    // 同色两团取 max(不自叠成过曝)，蓝/橙之间才 add → 仅中间交界一条带变粉白，避免大片全白。
    vec3 cBlue   = u_blendColor1;   // 2833FF（可由 uniform 调整）
    vec3 cOrange = u_blendColor2;   // FF9137（可由 uniform 调整）

    // 四个云团：蓝×2、橙×2，开局四角交错(蓝=左上/右下，橙=右上/左下)。
    // 每团一套独特的频率指纹(跨度 0.13~0.52、互不相同)→ 位置、大小都各自随机、不同步。
    // 游走项用 sin(t*f)(t=0 为 0) → 开局精确落在四角；主项符号按"绕中心切向"→ 不往中间靠拢。
    vec2 cB1 = vec2(0.30 + 0.21 * sin(t * 0.46) - 0.08 * sin(t * 0.73),
                    0.30 - 0.18 * sin(t * 0.38) + 0.09 * sin(t * 0.21));   // 蓝1：左上
    vec2 cB2 = vec2(0.70 - 0.19 * sin(t * 0.57) + 0.08 * sin(t * 0.25),
                    0.70 + 0.20 * sin(t * 0.43) - 0.09 * sin(t * 0.69));   // 蓝2：右下
    vec2 cO1 = vec2(0.70 + 0.20 * sin(t * 0.41) - 0.08 * sin(t * 0.64),
                    0.30 + 0.19 * sin(t * 0.53) - 0.09 * sin(t * 0.29));   // 橙1：右上
    vec2 cO2 = vec2(0.30 - 0.21 * sin(t * 0.49) + 0.08 * sin(t * 0.22),
                    0.70 - 0.18 * sin(t * 0.63) + 0.09 * sin(t * 0.39));   // 橙2：左下
    // 大小：直径稳定在半屏宽左右(uv 屏宽=1，核心直径≈2*sigma → sigma≈0.25 即半屏宽)，
    // 各团用不同频率做小幅随机起伏(±~0.045 ≈ 直径 ±0.09 屏宽 ≈ ±100px)，互不同步。
    float sB1 = 0.25 + 0.030 * sin(t * 0.19) + 0.015 * sin(t * 0.44 + 1.20);
    float sB2 = 0.25 + 0.028 * cos(t * 0.37 + 0.60) + 0.017 * sin(t * 0.13 + 2.00);
    float sO1 = 0.25 + 0.030 * sin(t * 0.50 + 1.50) + 0.015 * cos(t * 0.24 + 0.30);
    float sO2 = 0.25 + 0.028 * cos(t * 0.22 + 0.30) + 0.017 * sin(t * 0.40 + 1.80);

    // 同色两团用 screen 融合(1-(1-a)(1-b))：平滑合并成一个连贯块、无中缝，且强度封顶 1 不过曝
    float b1 = blob(uv, cB1, sB1);
    float b2 = blob(uv, cB2, sB2);
    float o1 = blob(uv, cO1, sO1);
    float o2 = blob(uv, cO2, sO2);
    float wB = 1.0 - (1.0 - b1) * (1.0 - b2);
    float wO = 1.0 - (1.0 - o1) * (1.0 - o2);

    // 蓝/橙之间 add：纯色区只有一色，只有两云交叠的窄带相加成粉白
    vec3 bg = cBlue * wB + cOrange * wO;
    bg = clamp(bg, 0.0, 1.0);

    // 合成：alpha = 椭圆遮罩 mask（含透明度时间线）→ 仅遮罩区域可见、按动画淡入淡出。预乘 alpha。
    float a = clamp(mask, 0.0, 1.0);
    fragColor = vec4(bg * a, a);
}
