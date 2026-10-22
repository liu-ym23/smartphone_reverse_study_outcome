package com.baidu.platform.comapi.util;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* JADX INFO: loaded from: classes39.dex */
public class EglConfigUtils {
    public static boolean isSupport24DepthSize() {
        EGL10 r100 = (EGL10) EGLContext.getEGL();     // Catch: Exception -> L24
        EGLDisplay r101 = r100.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);     // Catch: Exception -> L24
        r100.eglInitialize(r101, new int[2]);     // Catch: Exception -> L24
        EGLConfig[] r102 = new EGLConfig[100];     // Catch: Exception -> L24
        r100.eglGetConfigs(r101, r102, 100, new int[100]);     // Catch: Exception -> L24
        int[] r103 = new int[4];     // Catch: Exception -> L24
        int r104 = 0;
    L4:
        if (r104 >= 100) goto L23;
        int[] r105 = new int[1];     // Catch: Exception -> L24
        EGLConfig r110 = r102[r104];     // Catch: Exception -> L24
        if (r110 == null) goto L23;
        r100.eglGetConfigAttrib(r101, r110, 12324, r105);     // Catch: Exception -> L24
        r103[0] = r105[0];     // Catch: Exception -> L24
        r100.eglGetConfigAttrib(r101, r102[r104], 12323, r105);     // Catch: Exception -> L24
        r103[1] = r105[0];     // Catch: Exception -> L24
        r100.eglGetConfigAttrib(r101, r102[r104], 12322, r105);     // Catch: Exception -> L24
        r103[2] = r105[0];     // Catch: Exception -> L24
        r100.eglGetConfigAttrib(r101, r102[r104], 12325, r105);     // Catch: Exception -> L24
        int r106 = r105[0];     // Catch: Exception -> L24
        r103[3] = r106;     // Catch: Exception -> L24
        int r111 = r103[0];     // Catch: Exception -> L24
        if (r111 != 5) goto L15;
        if (r103[1] != 6) goto L15;
        if (r103[2] != 5) goto L15;
        if (r106 != 24) goto L15;
    L21:
        return true;
    L15:
        if (r111 != 8) goto L22;
        if (r103[1] != 8) goto L22;
        if (r103[2] != 8) goto L22;
        if (r106 == 24) goto L21;
    L22:
        r104 = r104 + 1;
    L23:
        return false;
    }

    public EglConfigUtils() {
    }

    public static boolean isSupportConfig(int r100, int r110, int r111, int r112, int r113, int r114, int r115, int r116) {
        EGL10 r101 = (EGL10) EGLContext.getEGL();
        EGLDisplay r102 = r101.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        r101.eglInitialize(r102, new int[2]);
        int[] r103 = new int[1];
        if (r101.eglChooseConfig(r102, new int[]{12324, r100, 12323, r110, 12322, r111, 12321, r112, 12325, r113, 12326, r114, 12338, r115, 12337, r116, 12344}, new EGLConfig[100], 100, r103) == true) goto L5;
    L7:
        return false;
    L5:
        if (r103[0] <= 0) goto L7;
        return true;
    }
}
