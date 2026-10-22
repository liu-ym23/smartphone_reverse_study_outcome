package com.byted.cast.sdk.gl;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes43.dex */
public class Texture2DProgram {
    private static final String FRAGMENT_SHADER_EXT = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    private static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";
    private int aPositionLoc;
    private int aTextureCoordLoc;
    private int programHandle;
    private int uMVPMatrixLoc;
    private int uTexMatrixLoc;

    public int createTextureObject() {
        int[] r100 = new int[1];
        GLES20.glGenTextures(1, r100, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, r100[0]);
        GlUtils.checkGlError("glBindTexture mTextureID");
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        GlUtils.checkGlError("glTexParameter");
        return r100[0];
    }

    public void release() {
        GLES20.glDeleteProgram(this.programHandle);
    }

    public Texture2DProgram() throws Exception {
        int r100 = createProgram(VERTEX_SHADER, FRAGMENT_SHADER_EXT);
        this.programHandle = r100;
        if (r100 == 0) goto L7;
        int r101 = GLES20.glGetAttribLocation(r100, "aPosition");
        this.aPositionLoc = r101;
        checkLocation(r101, "aPosition");
        int r102 = GLES20.glGetAttribLocation(this.programHandle, "aTextureCoord");
        this.aTextureCoordLoc = r102;
        checkLocation(r102, "aTextureCoord");
        int r103 = GLES20.glGetUniformLocation(this.programHandle, "uMVPMatrix");
        this.uMVPMatrixLoc = r103;
        checkLocation(r103, "uMVPMatrix");
        int r104 = GLES20.glGetUniformLocation(this.programHandle, "uTexMatrix");
        this.uTexMatrixLoc = r104;
        checkLocation(r104, "uTexMatrix");
        return;
    L7:
        throw new RuntimeException("Unable to create program");
    }

    private void checkLocation(int r100, String r101) {
        if (r100 < 0) goto L5;
        return;
    L5:
        throw new RuntimeException("Unable to locate '" + r101 + "' in program");
    }

    private int createProgram(String r100, String r101) throws Exception {
        int r102 = loadShader(35633, r100);
        if (r102 != 0) goto L5;
        return 0;
    L5:
        int r103 = loadShader(35632, r101);
        if (r103 != 0) goto L8;
        return 0;
    L8:
        int r104 = GLES20.glCreateProgram();
        GlUtils.checkGlError("glCreateProgram");
        if (r104 == 0) goto L16;
        GLES20.glAttachShader(r104, r102);
        GlUtils.checkGlError("glAttachShader");
        GLES20.glAttachShader(r104, r103);
        GlUtils.checkGlError("glAttachShader");
        GLES20.glLinkProgram(r104);
        int[] r105 = new int[1];
        GLES20.glGetProgramiv(r104, 35714, r105, 0);
        if (r105[0] != 1) goto L13;
        return r104;
    L13:
        String r106 = GLES20.glGetProgramInfoLog(r104);
        GLES20.glDeleteProgram(r104);
        throw new Exception("Could not link program: " + r106);
    L16:
        throw new Exception("Could not create program");
    }

    private int loadShader(int r100, String r101) throws Exception {
        int r102 = GLES20.glCreateShader(r100);
        GlUtils.checkGlError("glCreateShader type=" + r100);
        GLES20.glShaderSource(r102, r101);
        GLES20.glCompileShader(r102);
        int[] r103 = new int[1];
        GLES20.glGetShaderiv(r102, 35713, r103, 0);
        if (r103[0] == 0) goto L5;
        return r102;
    L5:
        String r104 = GLES20.glGetShaderInfoLog(r102);
        GLES20.glDeleteShader(r102);
        throw new Exception("Could not compile shader " + r100 + ": " + r104);
    }

    public void draw(float[] r110, FloatBuffer r111, int r112, int r113, int r114, int r115, float[] r116, FloatBuffer r210, int r211, int r212) {
        GlUtils.checkGlError("draw start");
        GLES20.glUseProgram(this.programHandle);
        GlUtils.checkGlError("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, r211);
        GLES20.glUniformMatrix4fv(this.uMVPMatrixLoc, 1, false, r110, 0);
        GlUtils.checkGlError("glUniformMatrix4fv");
        GLES20.glUniformMatrix4fv(this.uTexMatrixLoc, 1, false, r116, 0);
        GlUtils.checkGlError("glUniformMatrix4fv");
        GLES20.glEnableVertexAttribArray(this.aPositionLoc);
        GlUtils.checkGlError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.aPositionLoc, r114, 5126, false, r115, r111);
        GlUtils.checkGlError("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.aTextureCoordLoc);
        GlUtils.checkGlError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.aTextureCoordLoc, 2, 5126, false, r212, r210);
        GlUtils.checkGlError("glVertexAttribPointer");
        GLES20.glDrawArrays(5, r112, r113);
        GlUtils.checkGlError("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.aPositionLoc);
        GLES20.glDisableVertexAttribArray(this.aTextureCoordLoc);
        GLES20.glBindTexture(36197, 0);
        GLES20.glUseProgram(0);
    }
}
