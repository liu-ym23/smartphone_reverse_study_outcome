#version 300 es
precision highp float;

uniform sampler2D u_texture;
uniform float u_alpha;
uniform vec4 u_colorFilter;
uniform bool u_has_corner;
uniform float u_saturation;
uniform float u_corner_radius;
uniform vec2 u_crop_center;
in vec2 v_CropCoord;
in vec2 v_TextureCoord;
out vec4 fragColor;

const vec3 saturationWeighting = vec3(0.2125, 0.7154, 0.0721);

vec3 changeSaturation(vec3 base, float strength) {
    float luminance = dot(base, saturationWeighting);
    vec3 greyScaleColor = vec3(luminance);
    return mix(greyScaleColor, base, strength);
}

vec3 blendNormal(vec3 base, vec3 blend, float opacity) {
    return (blend * opacity + base * (1.0 - opacity));
}

float applyCornerRadius(vec2 cropCoords) {
    vec2 position = cropCoords - u_crop_center;
    // Scale down the dist vector here, as otherwise large corner
    // radii can cause floating point issues when computing the norm
    vec2 dist = (abs(position) - u_crop_center + vec2(u_corner_radius)) / 16.0;
    // Once we've found the norm, then scale back up.
    float plane = length(max(dist, vec2(0.0))) * 16.0;
    return 1.0 - clamp(plane - u_corner_radius, 0.0, 1.0);
}

void main() {
    float alpha = u_alpha;
    if (u_has_corner) {
        alpha *= applyCornerRadius(v_CropCoord);
    }
    vec3 finalColor = texture(u_texture, v_TextureCoord).rgb;
    finalColor = blendNormal(finalColor, u_colorFilter.rgb, u_colorFilter.a);
    finalColor = changeSaturation(finalColor, u_saturation);
    fragColor = vec4(finalColor * alpha, alpha);
}