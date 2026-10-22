package com.byted.cast.sdk.gl;

import android.opengl.EGL14;
import android.opengl.GLES20;

/* JADX INFO: loaded from: classes43.dex */
class GlUtils {
    public GlUtils() {
    }

    public static void checkEglError(String r100) {
        int r101 = EGL14.eglGetError();
        if (r101 != 12288) goto L6;
        return;
    L6:
        throw new RuntimeException(r100 + ": EGL error: 0x" + Integer.toHexString(r101));
    }

    public static void checkGlError(String r100) {
        int r101 = GLES20.glGetError();
        if (r101 == 1285) goto L11;
        if (r101 == 0) goto L9;
        if (r101 != 1285) goto L8;
        return;
    L8:
        throw new RuntimeException(r100 + ": glError 0x" + Integer.toHexString(r101));
    L9:
        return;
    L11:
        throw new RuntimeException(r100 + " error: GL_OUT_OF_MEMORY");
    }
}
