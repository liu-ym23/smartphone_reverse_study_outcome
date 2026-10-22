package com.bytedance.android.live.openplatform.impl.minigameanchor.cast;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f85141a;

    public b(a r100) {
        this.f85141a = r100;
    }

    public final void a() {
        a r100 = this.f85141a;     // Catch: Exception -> L15
        EGL10 r101 = r100.f85136e;     // Catch: Exception -> L15
        if (r101 == null) goto L5;
        EGLDisplay r102 = r100.f85137f;     // Catch: Exception -> L15
        EGLSurface r103 = EGL10.EGL_NO_SURFACE;     // Catch: Exception -> L15
        r101.eglMakeCurrent(r102, r103, r103, EGL10.EGL_NO_CONTEXT);     // Catch: Exception -> L15
    L5:
        a r104 = this.f85141a;     // Catch: Exception -> L15
        EGL10 r105 = r104.f85136e;     // Catch: Exception -> L15
        if (r105 == null) goto L8;
        r105.eglDestroySurface(r104.f85137f, r104.f85139h);     // Catch: Exception -> L15
    L8:
        a r106 = this.f85141a;     // Catch: Exception -> L15
        EGL10 r107 = r106.f85136e;     // Catch: Exception -> L15
        if (r107 == null) goto L11;
        r107.eglDestroyContext(r106.f85137f, r106.f85138g);     // Catch: Exception -> L15
    L11:
        a r108 = this.f85141a;     // Catch: Exception -> L15
        EGL10 r109 = r108.f85136e;     // Catch: Exception -> L15
        if (r109 == null) goto L17;
        r109.eglTerminate(r108.f85137f);     // Catch: Exception -> L15
    L17:
        a r110 = this.f85141a;
        r110.f85138g = EGL10.EGL_NO_CONTEXT;
        r110.f85139h = EGL10.EGL_NO_SURFACE;
        r110.f85137f = EGL10.EGL_NO_DISPLAY;
        r110.f85136e = null;
        r110.getClass();
        Handler r111 = this.f85141a.f85133b;
        if (r111 == null) goto L22;
        Looper r112 = r111.getLooper();
        if (r112 == null) goto L22;
        ThreadMethodProxy.quitSafely(r112);
    L22:
        this.f85141a.f85133b = null;
        return;
    L15:
        e = move-exception;
        int r113 = qo0.a.f534145a;
        qo0.a.b(this.f85141a.f85132a, "stopRender exception", e);
        goto L17
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
