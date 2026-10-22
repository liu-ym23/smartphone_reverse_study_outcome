package com.mdisdk.gles;

import D7.N;
import android.content.Context;
import android.content.res.Resources;
import android.opengl.GLES20;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.base.ALog;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0005J\u0016\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nJ\u001e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/mdisdk/gles/GL30Tools;", "", AppAgent.CONSTRUCT, "()V", "TAG", "", "getStringFromRaw", "context", "Landroid/content/Context;", "resourceId", "", "loadShader", "shaderType", "sourceCode", "linkProgram", "vertexShaderId", "fragmentShaderId", "vertexShaderResId", "fragmentShaderResId", "createFloatBuffer", "Ljava/nio/FloatBuffer;", "floatArray", "", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GL30Tools {
    public static final GL30Tools INSTANCE = new GL30Tools();
    private static final String TAG = "LShaderTools";

    private GL30Tools() {
    }

    public final FloatBuffer createFloatBuffer(float[] floatArray) {
        k.f(floatArray, "floatArray");
        FloatBuffer floatBufferPut = ByteBuffer.allocateDirect(floatArray.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(floatArray);
        floatBufferPut.flip();
        return floatBufferPut;
    }

    public final String getStringFromRaw(Context context, int resourceId) throws Resources.NotFoundException {
        k.f(context, "context");
        try {
            InputStream inputStreamOpenRawResource = context.getResources().openRawResource(resourceId);
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStreamOpenRawResource);
                try {
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    try {
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                String string = sb.toString();
                                bufferedReader.close();
                                inputStreamReader.close();
                                N.t(inputStreamOpenRawResource, null);
                                return string;
                            }
                            sb.append(line);
                            sb.append("\n");
                        }
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } catch (Exception e) {
            ALog.e$default(TAG, "Error reading raw resource: " + e, null, 4, null);
            return "";
        }
    }

    public final int linkProgram(int vertexShaderId, int fragmentShaderId) {
        int iGlCreateProgram = GLES20.glCreateProgram();
        if (iGlCreateProgram == 0) {
            return 0;
        }
        GLES20.glAttachShader(iGlCreateProgram, vertexShaderId);
        GLES20.glAttachShader(iGlCreateProgram, fragmentShaderId);
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 0) {
            ALog.e$default(TAG, B7.a.k("linkProgram error:", GLES20.glGetProgramInfoLog(iGlCreateProgram)), null, 4, null);
            GLES20.glDeleteProgram(iGlCreateProgram);
            return 0;
        }
        if (vertexShaderId != 0) {
            GLES20.glDeleteShader(vertexShaderId);
        }
        if (fragmentShaderId != 0) {
            GLES20.glDeleteShader(fragmentShaderId);
        }
        return iGlCreateProgram;
    }

    public final int loadShader(int shaderType, String sourceCode) {
        k.f(sourceCode, "sourceCode");
        int iGlCreateShader = GLES20.glCreateShader(shaderType);
        if (iGlCreateShader == 0) {
            return 0;
        }
        GLES20.glShaderSource(iGlCreateShader, sourceCode);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] == 1) {
            return iGlCreateShader;
        }
        ALog.e$default(TAG, B7.a.k("loadShader error:", GLES20.glGetShaderInfoLog(iGlCreateShader)), null, 4, null);
        GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    public final int linkProgram(Context context, int vertexShaderResId, int fragmentShaderResId) {
        k.f(context, "context");
        return linkProgram(loadShader(35633, getStringFromRaw(context, vertexShaderResId)), loadShader(35632, getStringFromRaw(context, fragmentShaderResId)));
    }
}
