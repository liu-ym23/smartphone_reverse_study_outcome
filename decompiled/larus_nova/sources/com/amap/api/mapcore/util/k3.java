package com.amap.api.mapcore.util;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

/* JADX INFO: loaded from: classes28.dex */
public class k3 extends h3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f27469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f27470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f27471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected int f27472d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f27473e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f27474f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int[] f27475g;

    private int[] a(int r110, boolean r111) {
        if (r110 == 3) goto L5;
        if (r111 == false) goto L10;
        return new int[]{12324, this.f27469a, 12323, this.f27470b, 12322, this.f27471c, 12338, 1, 12344};
    L10:
        return new int[]{12324, this.f27469a, 12323, this.f27470b, 12322, this.f27471c, 12344};
    L5:
        return new int[]{12324, this.f27469a, 12323, this.f27470b, 12322, this.f27471c, 12321, this.f27472d, 12325, this.f27473e, 12326, this.f27474f, 12338, r111 ? 1 : 0, 12352, 64, 12344};
    }

    @Override // com.amap.api.mapcore.util.h3, android.opengl.GLSurfaceView.EGLConfigChooser, com.amap.api.mapcore.util.y.f
    public EGLConfig chooseConfig(EGL10 r110, EGLDisplay r111) {
        m3 r100 = a(r110, r111);
        if (r100 == null) goto L15;
        int[] r101 = r100.f27534a;
        if (r101 == null) goto L20;
        int[] r102 = r100.f27535b;
        int r103 = r102[0];
        EGLConfig[] r104 = new EGLConfig[r103];
        r110.eglChooseConfig(r111, r101, r104, r103, r102);
        EGLConfig r105 = a(r110, r111, r104);
        if (r105 != null) goto L17;
        this.f27469a = 8;
        this.f27470b = 8;
        this.f27471c = 8;
        m3 r106 = a(r110, r111);
        if (r106 == null) goto L18;
        int[] r107 = r106.f27534a;
        if (r107 == null) goto L19;
        int[] r108 = r106.f27535b;
        int r109 = r108[0];
        EGLConfig[] r112 = new EGLConfig[r109];
        r110.eglChooseConfig(r111, r107, r112, r109, r108);
        return a(r110, r111, r112);
    L19:
        return r105;
    L18:
        return r105;
    L17:
        return r105;
    L20:
        return null;
    L15:
        return null;
    }

    private m3 a(EGL10 r110, EGLDisplay r111) {
        m3 r100 = new m3(null);
        int[] r101 = a(3, true);
        r100.f27534a = r101;
        r110.eglChooseConfig(r111, r101, null, 0, r100.f27535b);
        if (r100.f27535b[0] > 0) goto L7;
        int[] r102 = a(3, false);
        r100.f27534a = r102;
        r110.eglChooseConfig(r111, r102, null, 0, r100.f27535b);
        if (r100.f27535b[0] > 0) goto L7;
        return null;
    L7:
        return r100;
    }

    public EGLConfig a(EGL10 r110, EGLDisplay r111, EGLConfig[] r112) {
        int r100 = r112.length;
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L43;
        EGLConfig r102 = r112[r101];
        if (r110.eglGetConfigAttrib(r111, r102, 12325, this.f27475g) == false) goto L7;
        int r103 = this.f27475g[0];
    L9:
        if (r110.eglGetConfigAttrib(r111, r102, 12326, this.f27475g) == false) goto L11;
        int r104 = this.f27475g[0];
    L13:
        if (r103 < this.f27473e) goto L42;
        if (r104 < this.f27474f) goto L42;
        if (r110.eglGetConfigAttrib(r111, r102, 12324, this.f27475g) == false) goto L20;
        int r105 = this.f27475g[0];
    L22:
        if (r110.eglGetConfigAttrib(r111, r102, 12323, this.f27475g) == false) goto L24;
        int r106 = this.f27475g[0];
    L26:
        if (r110.eglGetConfigAttrib(r111, r102, 12322, this.f27475g) == false) goto L28;
        int r107 = this.f27475g[0];
    L30:
        if (r110.eglGetConfigAttrib(r111, r102, 12321, this.f27475g) == false) goto L32;
        int r108 = this.f27475g[0];
    L34:
        if (r105 != this.f27469a) goto L42;
        if (r106 != this.f27470b) goto L42;
        if (r107 != this.f27471c) goto L42;
        if (r108 != this.f27472d) goto L42;
        return r102;
    L32:
        r108 = 0;
        goto L34
    L28:
        r107 = 0;
        goto L30
    L24:
        r106 = 0;
        goto L26
    L20:
        r105 = 0;
    L42:
        r101 = r101 + 1;
        goto L3
    L11:
        r104 = 0;
        goto L13
    L7:
        r103 = 0;
        goto L9
    L43:
        return null;
    }

    public k3(int r100, int r101, int r102, int r103, int r104, int r105) {
        this.f27475g = new int[1];
        this.f27469a = r100;
        this.f27470b = r101;
        this.f27471c = r102;
        this.f27472d = r103;
        this.f27473e = r104;
        this.f27474f = r105;
    }
}
