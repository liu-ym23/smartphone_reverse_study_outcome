package com.baidu.xclient.gdid.j;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public EGL10 f9538a;

    /* renamed from: b, reason: collision with root package name */
    public EGLDisplay f9539b;

    /* renamed from: c, reason: collision with root package name */
    public EGLConfig f9540c;

    /* renamed from: d, reason: collision with root package name */
    public EGLSurface f9541d;

    /* renamed from: e, reason: collision with root package name */
    public EGLContext f9542e;

    /* renamed from: f, reason: collision with root package name */
    public GL10 f9543f;

    /* renamed from: h, reason: collision with root package name */
    public Object f9545h;

    /* renamed from: g, reason: collision with root package name */
    public int f9544g = 1;

    /* renamed from: i, reason: collision with root package name */
    public int f9546i = 8;

    /* renamed from: j, reason: collision with root package name */
    public int f9547j = 8;

    /* renamed from: k, reason: collision with root package name */
    public int f9548k = 8;

    /* renamed from: l, reason: collision with root package name */
    public int f9549l = 8;

    /* renamed from: m, reason: collision with root package name */
    public int f9550m = 16;

    /* renamed from: n, reason: collision with root package name */
    public int f9551n = 4;

    /* renamed from: o, reason: collision with root package name */
    public EGLContext f9552o = EGL10.EGL_NO_CONTEXT;

    public final EGLSurface a(int[] iArr) {
        int i4 = this.f9544g;
        return i4 != 2 ? i4 != 3 ? this.f9538a.eglCreatePbufferSurface(this.f9539b, this.f9540c, iArr) : this.f9538a.eglCreateWindowSurface(this.f9539b, this.f9540c, this.f9545h, iArr) : this.f9538a.eglCreatePixmapSurface(this.f9539b, this.f9540c, this.f9545h, iArr);
    }

    public void b() {
        EGL10 egl10 = this.f9538a;
        EGLDisplay eGLDisplay = this.f9539b;
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        this.f9538a.eglDestroySurface(this.f9539b, this.f9541d);
        this.f9538a.eglDestroyContext(this.f9539b, this.f9542e);
        this.f9538a.eglTerminate(this.f9539b);
    }

    public void a() {
        EGL10 egl10 = this.f9538a;
        EGLDisplay eGLDisplay = this.f9539b;
        EGLSurface eGLSurface = this.f9541d;
        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f9542e);
        this.f9543f = (GL10) this.f9542e.getGL();
    }

    public boolean a(int i4, int i5) {
        int[] iArr = {12324, this.f9546i, 12323, this.f9547j, 12322, this.f9548k, 12321, this.f9549l, 12325, this.f9550m, 12352, this.f9551n, 12344};
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.f9538a = egl10;
        EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.f9539b = eGLDisplayEglGetDisplay;
        this.f9538a.eglInitialize(eGLDisplayEglGetDisplay, new int[2]);
        int[] iArr2 = new int[1];
        this.f9538a.eglChooseConfig(this.f9539b, iArr, null, 0, iArr2);
        int i6 = iArr2[0];
        if (i6 == 0) {
            return false;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[i6];
        this.f9538a.eglChooseConfig(this.f9539b, iArr, eGLConfigArr, i6, iArr2);
        this.f9540c = eGLConfigArr[0];
        this.f9541d = a(new int[]{12375, i4, 12374, i5, 12344});
        this.f9542e = this.f9538a.eglCreateContext(this.f9539b, this.f9540c, this.f9552o, new int[]{12440, 2, 12344});
        a();
        return true;
    }
}
