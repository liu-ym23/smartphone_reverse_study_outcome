#version 300 es

in vec3 a_position;
in vec2 a_texCoord0;

uniform mat4 u_projectionViewMatrix;
uniform mat4 u_modelMatrix;
uniform mat3 u_texture_transform;
uniform vec2 u_left_top;
out vec2 v_TextureCoord;
out vec2 v_CropCoord;

void main() {
    vec4 position = u_modelMatrix * vec4(a_position, 1.0);
    gl_Position = u_projectionViewMatrix * position;
    v_TextureCoord = (u_texture_transform * vec3(a_texCoord0, 1.0)).xy;
    v_CropCoord = position.xy - u_left_top;
}