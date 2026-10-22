package com.byted.cast.sdk.gl;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Size;
import com.byted.cast.common.Logger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes43.dex */
public class FullFrameRect {
    private static final float[] FULL_RECTANGLE_COORDS = null;
    private static final float[] FULL_RECTANGLE_TEX_COORDS = null;
    private static final String TAG = "FullFrameRect";
    private FloatBuffer FULL_RECTANGLE_BUF;
    private FloatBuffer FULL_RECTANGLE_TEX_BUF;
    private float[] mvpMatrix;
    private Texture2DProgram program;
    private boolean useCamera;

    static {
        FULL_RECTANGLE_COORDS = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        FULL_RECTANGLE_TEX_COORDS = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    }

    public int createTextureObject() {
        return this.program.createTextureObject();
    }

    public FullFrameRect(Texture2DProgram r100) {
        this.mvpMatrix = new float[16];
        this.useCamera = true;
        this.FULL_RECTANGLE_BUF = createFloatBuffer(FULL_RECTANGLE_COORDS);
        this.FULL_RECTANGLE_TEX_BUF = createFloatBuffer(FULL_RECTANGLE_TEX_COORDS);
        this.program = r100;
    }

    private static FloatBuffer createFloatBuffer(float[] r100) {
        ByteBuffer r101 = ByteBuffer.allocateDirect(r100.length * 4);
        r101.order(ByteOrder.nativeOrder());
        FloatBuffer r102 = r101.asFloatBuffer();
        r102.put(r100);
        r102.position(0);
        return r102;
    }

    public void changeProgram(Texture2DProgram r100) {
        this.program.release();
        this.program = r100;
    }

    public void release(boolean r100) {
        if (r100 == false) goto L5;
        this.program.release();
        return;
    }

    public void setUseCamera(boolean r100) {
        this.useCamera = r100;
        Logger.i(TAG, "setUseCamera:" + r100);
    }

    public void drawFrame(int r110, float[] r111) {
        this.program.draw(this.mvpMatrix, this.FULL_RECTANGLE_BUF, 0, 4, 2, 8, r111, this.FULL_RECTANGLE_TEX_BUF, r110, 8);
    }

    public void setMVPMatrixAndViewPort(float r110, Size r111) {
        Matrix.setIdentityM(this.mvpMatrix, 0);
        if (this.useCamera == false) goto L13;
        StringBuilder r100 = new StringBuilder("setMVPMatrixAndViewPort, rotateM:");
        if (r110 != 0.0f) goto L7;
        float r101 = 270.0f;
    L8:
        r100.append(r101);
        Logger.i(TAG, r100.toString());
        float[] r102 = this.mvpMatrix;
        if (r110 != 0.0f) goto L11;
        float r103 = 270.0f;
    L12:
        Matrix.rotateM(r102, 0, r103, 0.0f, 0.0f, -1.0f);
    L14:
        GLES20.glViewport(0, 0, r111.getWidth(), r111.getHeight());
        return;
    L11:
        r103 = r110 - 90.0f;
        goto L12
    L7:
        r101 = r110 - 90.0f;
        goto L8
    L13:
        Logger.i(TAG, "setMVPMatrixAndViewPort, rotateM: 0");
        Matrix.rotateM(this.mvpMatrix, 0, 0.0f, 0.0f, 0.0f, -1.0f);
        goto L14
    }
}
