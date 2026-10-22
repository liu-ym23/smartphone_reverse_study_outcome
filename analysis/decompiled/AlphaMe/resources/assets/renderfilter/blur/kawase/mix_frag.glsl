#version 300 es
precision highp float;

in vec2 v_texCoord;

uniform sampler2D u_blur_texture;
uniform sampler2D u_origin_texture;
uniform float u_mixFactor;
out vec4 fragColor;

void main () {
    vec3 originColor = texture(u_origin_texture, v_texCoord).rgb;
    vec3 blurColorColor = texture(u_blur_texture, v_texCoord).rgb;
    fragColor = vec4(mix(originColor, blurColorColor, u_mixFactor), 1.0);
}