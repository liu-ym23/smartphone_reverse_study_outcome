package com.baidu.xclient.gdid.j;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes39.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EGL10 f33627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public EGLDisplay f33628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public EGLConfig f33629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public EGLSurface f33630d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public EGLContext f33631e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public GL10 f33632f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f33633g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f33634h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f33635i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f33636j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f33637k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f33638l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f33639m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f33640n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public EGLContext f33641o;

    public e() {
        this.f33633g = 1;
        this.f33635i = 8;
        this.f33636j = 8;
        this.f33637k = 8;
        this.f33638l = 8;
        this.f33639m = 16;
        this.f33640n = 4;
        this.f33641o = EGL10.EGL_NO_CONTEXT;
    }

    public final EGLSurface a(int[] r100) {
        int r101 = this.f33633g;
        if (r101 == 2) goto L11;
        if (r101 == 3) goto L9;
        return this.f33627a.eglCreatePbufferSurface(this.f33628b, this.f33629c, r100);
    L9:
        return this.f33627a.eglCreateWindowSurface(this.f33628b, this.f33629c, this.f33634h, r100);
    L11:
        return this.f33627a.eglCreatePixmapSurface(this.f33628b, this.f33629c, this.f33634h, r100);
    }

    public void a() {
        EGL10 r100 = this.f33627a;
        EGLDisplay r101 = this.f33628b;
        EGLSurface r102 = this.f33630d;
        r100.eglMakeCurrent(r101, r102, r102, this.f33631e);
        this.f33632f = (GL10) this.f33631e.getGL();
    }

    public boolean a(int r110, int r111) {
        int[] r100 = {12324, this.f33635i, 12323, this.f33636j, 12322, this.f33637k, 12321, this.f33638l, 12325, this.f33639m, 12352, this.f33640n, 12344};
        EGL10 r101 = (EGL10) EGLContext.getEGL();
        this.f33627a = r101;
        EGLDisplay r102 = r101.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.f33628b = r102;
        this.f33627a.eglInitialize(r102, new int[2]);
        int[] r112 = new int[1];
        this.f33627a.eglChooseConfig(this.f33628b, r100, null, 0, r112);
        int r103 = r112[0];
        if (r103 != 0) goto L5;
        return false;
    L5:
        EGLConfig[] r104 = new EGLConfig[r103];
        this.f33627a.eglChooseConfig(this.f33628b, r100, r104, r103, r112);
        this.f33629c = r104[0];
        this.f33630d = a(new int[]{12375, r110, 12374, r111, 12344});
        this.f33631e = this.f33627a.eglCreateContext(this.f33628b, this.f33629c, this.f33641o, new int[]{12440, 2, 12344});
        a();
        return true;
    }

    public void b() {
        EGL10 r100 = this.f33627a;
        EGLDisplay r101 = this.f33628b;
        EGLSurface r102 = EGL10.EGL_NO_SURFACE;
        r100.eglMakeCurrent(r101, r102, r102, EGL10.EGL_NO_CONTEXT);
        this.f33627a.eglDestroySurface(this.f33628b, this.f33630d);
        this.f33627a.eglDestroyContext(this.f33628b, this.f33631e);
        this.f33627a.eglTerminate(this.f33628b);
    }
}
