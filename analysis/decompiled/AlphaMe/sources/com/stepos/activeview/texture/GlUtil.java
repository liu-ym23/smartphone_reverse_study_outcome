package com.stepos.activeview.texture;

import B0.g;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.stepos.alphame.awareness.AwarenessDataItem;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: classes.dex */
public class GlUtil {
    public static final float[] IDENTITY_MATRIX;
    private static final int SIZEOF_FLOAT = 4;
    public static final String TAG = "Grafika";

    static {
        float[] fArr = new float[16];
        IDENTITY_MATRIX = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    private GlUtil() {
    }

    public static void checkGlError(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError == 0) {
            return;
        }
        StringBuilder sbV = g.v(str, ": glError 0x");
        sbV.append(Integer.toHexString(iGlGetError));
        String string = sbV.toString();
        Log.e(TAG, string);
        throw new RuntimeException(string);
    }

    public static void checkLocation(int i4, String str) {
        if (i4 < 0) {
            throw new RuntimeException(g.n("Unable to locate '", str, "' in program"));
        }
    }

    public static FloatBuffer createFloatBuffer(float[] fArr) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr);
        floatBufferAsFloatBuffer.position(0);
        return floatBufferAsFloatBuffer;
    }

    public static int createImageTexture(ByteBuffer byteBuffer, int i4, int i5, int i6) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i7 = iArr[0];
        checkGlError("glGenTextures");
        GLES20.glBindTexture(3553, i7);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, BmLocated.HALF_RIGHT_BOTTOM, 9729);
        checkGlError("loadImageTexture");
        GLES20.glTexImage2D(3553, 0, i6, i4, i5, 0, i6, 5121, byteBuffer);
        checkGlError("loadImageTexture");
        return i7;
    }

    public static int createProgram(String str, String str2) {
        int iLoadShader;
        int iLoadShader2 = loadShader(35633, str);
        if (iLoadShader2 == 0 || (iLoadShader = loadShader(35632, str2)) == 0) {
            return 0;
        }
        int iGlCreateProgram = GLES20.glCreateProgram();
        checkGlError("glCreateProgram");
        if (iGlCreateProgram == 0) {
            Log.e(TAG, "Could not create program");
        }
        GLES20.glAttachShader(iGlCreateProgram, iLoadShader2);
        checkGlError("glAttachShader");
        GLES20.glAttachShader(iGlCreateProgram, iLoadShader);
        checkGlError("glAttachShader");
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return iGlCreateProgram;
        }
        Log.e(TAG, "Could not link program: ");
        Log.e(TAG, GLES20.glGetProgramInfoLog(iGlCreateProgram));
        GLES20.glDeleteProgram(iGlCreateProgram);
        return 0;
    }

    public static int loadShader(int i4, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i4);
        checkGlError("glCreateShader type=" + i4);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        Log.e(TAG, "Could not compile shader " + i4 + AwarenessDataItem.USERID_SPLITTER);
        StringBuilder sb = new StringBuilder(AwarenessDataItem.PERMISSION_SPLITTER);
        sb.append(GLES20.glGetShaderInfoLog(iGlCreateShader));
        Log.e(TAG, sb.toString());
        GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    public static void logVersionInfo() {
        Log.i(TAG, "vendor  : " + GLES20.glGetString(7936));
        Log.i(TAG, "renderer: " + GLES20.glGetString(7937));
        Log.i(TAG, "version : " + GLES20.glGetString(7938));
    }
}
