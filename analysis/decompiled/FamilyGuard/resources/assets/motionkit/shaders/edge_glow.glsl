#version 300 es
precision highp float;

uniform float iTime;
uniform vec2 iResolution;
uniform float glowIntensity;
uniform float glowWidth;
uniform vec4 glowColor;

out vec4 fragColor;

void main() {
    vec2 uv = gl_FragCoord.xy / iResolution;

    float edgeDist = min(min(uv.x, 1.0 - uv.x), min(uv.y, 1.0 - uv.y));

    float width = glowWidth > 0.0 ? glowWidth : 0.08;
    float intensity = glowIntensity > 0.0 ? glowIntensity : 1.5;

    float glow = smoothstep(width, 0.0, edgeDist);
    glow *= intensity;

    float pulse = 0.8 + 0.2 * sin(iTime * 3.0);
    glow *= pulse;

    float wave = sin(uv.x * 20.0 + iTime * 4.0) * 0.3 +
                 sin(uv.y * 15.0 - iTime * 3.0) * 0.2;
    glow += glow * wave * 0.3;

    vec4 color = glowColor.a > 0.0 ?
        glowColor :
        vec4(0.2, 0.6, 1.0, 1.0);

    fragColor = vec4(color.rgb * glow, glow * color.a);
}
