package com.byted.cast.sdk.gl.grafika;

import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes43.dex */
public class GlUtil {
    public static final float[] IDENTITY_MATRIX = null;
    private static final int SIZEOF_FLOAT = 4;
    public static final String TAG = "Grafika";

    private GlUtil() {
    }

    static {
        float[] r100 = new float[16];
        IDENTITY_MATRIX = r100;
        Matrix.setIdentityM(r100, 0);
    }

    public static void logVersionInfo() {
        GLES20.glGetString(7936);
        GLES20.glGetString(7937);
        GLES20.glGetString(7938);
    }

    public static void checkGlError(String r100) {
        int r101 = GLES20.glGetError();
        if (r101 != 0) goto L6;
        return;
    L6:
        throw new RuntimeException(r100 + ": glError 0x" + Integer.toHexString(r101));
    }

    public static FloatBuffer createFloatBuffer(float[] r100) {
        ByteBuffer r101 = ByteBuffer.allocateDirect(r100.length * 4);
        r101.order(ByteOrder.nativeOrder());
        FloatBuffer r102 = r101.asFloatBuffer();
        r102.put(r100);
        r102.position(0);
        return r102;
    }

    public static void checkLocation(int r100, String r101) {
        if (r100 < 0) goto L5;
        return;
    L5:
        throw new RuntimeException("Unable to locate '" + r101 + "' in program");
    }

    public static int createProgram(String r100, String r101) {
        int r102 = loadShader(35633, r100);
        if (r102 != 0) goto L5;
        return 0;
    L5:
        int r103 = loadShader(35632, r101);
        if (r103 != 0) goto L8;
        return 0;
    L8:
        int r104 = GLES20.glCreateProgram();
        checkGlError("glCreateProgram");
        GLES20.glAttachShader(r104, r102);
        checkGlError("glAttachShader");
        GLES20.glAttachShader(r104, r103);
        checkGlError("glAttachShader");
        GLES20.glLinkProgram(r104);
        int[] r105 = new int[1];
        GLES20.glGetProgramiv(r104, 35714, r105, 0);
        if (r105[0] == 1) goto L12;
        GLES20.glGetProgramInfoLog(r104);
        GLES20.glDeleteProgram(r104);
        return 0;
    L12:
        return r104;
    }

    public static int loadShader(int r100, String r101) {
        int r102 = GLES20.glCreateShader(r100);
        checkGlError("glCreateShader type=" + r100);
        GLES20.glShaderSource(r102, r101);
        GLES20.glCompileShader(r102);
        int[] r103 = new int[1];
        GLES20.glGetShaderiv(r102, 35713, r103, 0);
        if (r103[0] != 0) goto L6;
        GLES20.glGetShaderInfoLog(r102);
        GLES20.glDeleteShader(r102);
        return 0;
    L6:
        return r102;
    }

    public static int createImageTexture(ByteBuffer r110, int r111, int r112, int r113) {
        int[] r100 = new int[1];
        GLES20.glGenTextures(1, r100, 0);
        int r101 = r100[0];
        checkGlError("glGenTextures");
        GLES20.glBindTexture(3553, r101);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        checkGlError("loadImageTexture");
        GLES20.glTexImage2D(3553, 0, r113, r111, r112, 0, r113, 5121, r110);
        checkGlError("loadImageTexture");
        return r101;
    }
}
