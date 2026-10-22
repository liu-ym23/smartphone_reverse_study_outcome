#version 300 es
precision highp float;

in vec2 v_texCoord;

uniform sampler2D u_blur_texture;
uniform vec2 in_blurOffset;
out vec4 fragColor;

void main () {
    vec4 color = texture(u_blur_texture, v_texCoord);
    color += texture(u_blur_texture, v_texCoord + vec2(+in_blurOffset.x, +in_blurOffset.y));
    color += texture(u_blur_texture, v_texCoord + vec2(+in_blurOffset.x, -in_blurOffset.y));
    color += texture(u_blur_texture, v_texCoord + vec2(-in_blurOffset.x, -in_blurOffset.y));
    color += texture(u_blur_texture, v_texCoord + vec2(-in_blurOffset.x, +in_blurOffset.y));
    fragColor = vec4(color.rgb * 0.2, 1.0);
}