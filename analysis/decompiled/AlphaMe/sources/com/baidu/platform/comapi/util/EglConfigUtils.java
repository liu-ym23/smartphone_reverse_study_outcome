package com.baidu.platform.comapi.util;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* loaded from: classes.dex */
public class EglConfigUtils {
    public static boolean isSupport24DepthSize() {
        try {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            egl10.eglInitialize(eGLDisplayEglGetDisplay, new int[2]);
            EGLConfig[] eGLConfigArr = new EGLConfig[100];
            egl10.eglGetConfigs(eGLDisplayEglGetDisplay, eGLConfigArr, 100, new int[100]);
            int[] iArr = new int[4];
            for (int i4 = 0; i4 < 100; i4++) {
                int[] iArr2 = new int[1];
                EGLConfig eGLConfig = eGLConfigArr[i4];
                if (eGLConfig == null) {
                    break;
                }
                egl10.eglGetConfigAttrib(eGLDisplayEglGetDisplay, eGLConfig, 12324, iArr2);
                iArr[0] = iArr2[0];
                egl10.eglGetConfigAttrib(eGLDisplayEglGetDisplay, eGLConfigArr[i4], 12323, iArr2);
                iArr[1] = iArr2[0];
                egl10.eglGetConfigAttrib(eGLDisplayEglGetDisplay, eGLConfigArr[i4], 12322, iArr2);
                iArr[2] = iArr2[0];
                egl10.eglGetConfigAttrib(eGLDisplayEglGetDisplay, eGLConfigArr[i4], 12325, iArr2);
                int i5 = iArr2[0];
                iArr[3] = i5;
                int i6 = iArr[0];
                if ((i6 == 5 && iArr[1] == 6 && iArr[2] == 5 && i5 == 24) || (i6 == 8 && iArr[1] == 8 && iArr[2] == 8 && i5 == 24)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean isSupportConfig(int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        egl10.eglInitialize(eGLDisplayEglGetDisplay, new int[2]);
        int[] iArr = new int[1];
        return egl10.eglChooseConfig(eGLDisplayEglGetDisplay, new int[]{12324, i4, 12323, i5, 12322, i6, 12321, i7, 12325, i8, 12326, i9, 12338, i10, 12337, i11, 12344}, new EGLConfig[100], 100, iArr) && iArr[0] > 0;
    }
}
