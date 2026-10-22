package com.bef.effectsdk.game;

import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes39.dex */
public class RenderTextureUtils {
    private static float[] flipY_uvArray = null;
    public static final String renderFS = "precision highp float;\n\nuniform sampler2D uTexture;\nvarying vec2 textureCoord;\nvoid main() {\n    gl_FragColor = texture2D(uTexture, textureCoord);\n}\n";
    public static final String renderVS = "attribute vec2 attUV;\nattribute vec2 attPosition;\nvarying vec2 textureCoord;\nuniform mat4 mvpMatrix;\n\nvoid main() {\n    gl_Position  = mvpMatrix * vec4(attPosition, 0.,1.);\n    textureCoord = attUV;\n}\n";
    private static float[] uvArray;
    private static float[] vertexArray;

    public RenderTextureUtils() {
    }

    static {
        vertexArray = new float[]{-1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f};
        uvArray = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        flipY_uvArray = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    }

    public static FloatBuffer getFlipY_uvBuffer() {
        return getFloatBuffer(flipY_uvArray);
    }

    public static FloatBuffer getUVBuffer() {
        return getFloatBuffer(uvArray);
    }

    public static FloatBuffer getVertexBuffer() {
        return getFloatBuffer(vertexArray);
    }

    public static FloatBuffer getFloatBuffer(float[] r100) {
        FloatBuffer r101 = ByteBuffer.allocateDirect(r100.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r100);
        r101.position(0);
        return r101;
    }

    public static int generateBlankTexture(int r110, int r111) {
        FloatBuffer r100 = ByteBuffer.allocateDirect((r110 * r111) * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        r100.put(0.0f);
        r100.position(0);
        int[] r112 = new int[1];
        GLES20.glGenTextures(1, r112, 0);
        GLES20.glBindTexture(3553, r112[0]);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glTexImage2D(3553, 0, 6408, r110, r111, 0, 6408, 5121, r100);
        GLES20.glBindTexture(3553, 0);
        return r112[0];
    }

    public static FloatBuffer getUVBufferWithParams(float r100, float r101, float r102, float r103) {
        return getFloatBuffer(new float[]{r100, r102, r101, r102, r100, r103, r101, r103});
    }

    public static FloatBuffer getVertexBufferWithParams(float r100, float r101, float r102, float r103) {
        return getFloatBuffer(new float[]{r100, r102, r101, r102, r100, r103, r101, r103});
    }
}
