package com.stepos.common.drawble;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/common/drawble/ShadeBlurEntity;", "", "()V", "runtimeShader", "", "getRuntimeShader", "()Ljava/lang/String;", "StepOSCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ShadeBlurEntity {
    public static final ShadeBlurEntity INSTANCE = new ShadeBlurEntity();
    private static final String runtimeShader = "uniform shader image;\nuniform float2 size;\nuniform float radius;\nuniform float glowRadius;\nuniform float glowIntensity;\nlayout(color) uniform float4 rectColor;\nuniform shader glowColors;\nuniform float time;\nuniform float inner;\n\n// 添加随机函数\nfloat random(vec2 coords) {\n    return fract(sin(dot(coords, vec2(12.9898, 78.233))) * 43758.5453);\n}\n\nfloat roundedRectSDF(vec2 position, vec2 box, float radius) {\n    vec2 q = abs(position) - box + vec2(radius);\n    return length(max(q, 0.0)) + min(max(q.x, q.y), 0.0) - radius;\n}\n\nvec4 main(vec2 fragCoord) {\n    vec2 center = size / 2.0;\n    vec2 pos = fragCoord - center;\n\n    float dist = roundedRectSDF(pos, size/2.0, radius);\n    float inside = step(dist, 0.0);\n    dist = dist * inner;\n    float hasGlow = step(dist, 0.0);\n\n    // 内发光效果 + 抖动\n    float normalizedDist = max(0.0, -dist) / glowRadius;\n    float dynamicGlowIntensity = glowIntensity * (0.9 + 0.1 * sin(2.0 * 3.14159 * fract(time * 0.25)));\n\n    // 添加抖动效果\n    const float NOISE_GRANULARITY = 0.5/255.0; // 噪点粒度\n    vec2 noiseCoord = fragCoord + time * 10.0; // 添加时间因子使噪点随时间变化\n    float noise = mix(-NOISE_GRANULARITY, NOISE_GRANULARITY, random(noiseCoord));\n\n    // 在发光计算中加入抖动\n    float glow = (1.0 / (1.0 + 8.0 * normalizedDist)) * dynamicGlowIntensity * hasGlow;\n    glow += noise * glow; // 只在有发光的地方添加噪点\n    glow = clamp(glow, 0.0, 1.0); // 确保值在有效范围内\n\n    // 矩形基础颜色\n    vec4 baseColor = mix(vec4(0.0), rectColor, inside);\n\n    float deg = atan(pos.y, pos.x);\n    if (deg < 0.0) {\n        deg += 2.0 * 3.14159;\n    }\n    deg = deg / (2.0 * 3.14159);\n    deg = fract(deg + time * 0.2);\n    vec4 glowColor = glowColors.eval(vec2(deg * 1024.0, 0.0));\n\n    // 在最终颜色混合时也添加细微抖动\n    float finalNoise = noise * 0.5; // 减小噪点强度\n    vec4 finalColor = mix(baseColor, glowColor, glow + finalNoise);\n    \n    return finalColor;\n}\n";

    private ShadeBlurEntity() {
    }

    public final String getRuntimeShader() {
        return runtimeShader;
    }
}
