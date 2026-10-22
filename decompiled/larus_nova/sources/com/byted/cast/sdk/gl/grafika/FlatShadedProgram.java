package com.byted.cast.sdk.gl.grafika;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes43.dex */
public class FlatShadedProgram {
    private static final String FRAGMENT_SHADER = "precision mediump float;uniform vec4 uColor;void main() {    gl_FragColor = uColor;}";
    private static final String TAG = "Grafika";
    private static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;attribute vec4 aPosition;void main() {    gl_Position = uMVPMatrix * aPosition;}";
    private int mProgramHandle;
    private int maPositionLoc;
    private int muColorLoc;
    private int muMVPMatrixLoc;

    public void release() {
        GLES20.glDeleteProgram(this.mProgramHandle);
        this.mProgramHandle = -1;
    }

    public FlatShadedProgram() {
        this.mProgramHandle = -1;
        this.muColorLoc = -1;
        this.muMVPMatrixLoc = -1;
        this.maPositionLoc = -1;
        int r100 = GlUtil.createProgram(VERTEX_SHADER, FRAGMENT_SHADER);
        this.mProgramHandle = r100;
        if (r100 == 0) goto L7;
        int r101 = GLES20.glGetAttribLocation(r100, "aPosition");
        this.maPositionLoc = r101;
        GlUtil.checkLocation(r101, "aPosition");
        int r102 = GLES20.glGetUniformLocation(this.mProgramHandle, "uMVPMatrix");
        this.muMVPMatrixLoc = r102;
        GlUtil.checkLocation(r102, "uMVPMatrix");
        int r103 = GLES20.glGetUniformLocation(this.mProgramHandle, "uColor");
        this.muColorLoc = r103;
        GlUtil.checkLocation(r103, "uColor");
        return;
    L7:
        throw new RuntimeException("Unable to create program");
    }

    public void draw(float[] r110, float[] r111, FloatBuffer r112, int r113, int r114, int r115, int r116) {
        GlUtil.checkGlError("draw start");
        GLES20.glUseProgram(this.mProgramHandle);
        GlUtil.checkGlError("glUseProgram");
        GLES20.glUniformMatrix4fv(this.muMVPMatrixLoc, 1, false, r110, 0);
        GlUtil.checkGlError("glUniformMatrix4fv");
        GLES20.glUniform4fv(this.muColorLoc, 1, r111, 0);
        GlUtil.checkGlError("glUniform4fv ");
        GLES20.glEnableVertexAttribArray(this.maPositionLoc);
        GlUtil.checkGlError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.maPositionLoc, r115, 5126, false, r116, r112);
        GlUtil.checkGlError("glVertexAttribPointer");
        GLES20.glDrawArrays(5, r113, r114);
        GlUtil.checkGlError("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.maPositionLoc);
        GLES20.glUseProgram(0);
    }
}
