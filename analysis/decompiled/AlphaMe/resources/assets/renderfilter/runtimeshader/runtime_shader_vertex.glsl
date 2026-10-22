#version 300 es

in vec3 a_position;
in vec2 a_texCoord0;
uniform mat4 u_projectionViewMatrix;
out vec2 v_TextureCoord;

void main() {
    gl_Position = u_projectionViewMatrix * vec4(a_position, 1.0);
    v_TextureCoord = a_texCoord0;
}