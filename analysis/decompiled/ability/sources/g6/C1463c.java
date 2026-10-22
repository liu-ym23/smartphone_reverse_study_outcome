package g6;

import I4.l;
import android.os.Handler;
import android.view.Surface;
import f6.AbstractC1436a;
import h6.C1490b;
import h6.RunnableC1489a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.k;

/* renamed from: g6.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1463c {

    /* renamed from: a, reason: collision with root package name */
    public final C1490b f4486a;
    public boolean b;

    public C1463c(int i, int i6) {
        this.f4486a = new C1490b(i, i6);
    }

    public final Surface a(Surface externalSurface) {
        k.f(externalSurface, "externalSurface");
        C1490b c1490b = this.f4486a;
        synchronized (c1490b) {
            if (!c1490b.g) {
                c1490b.g = true;
                c1490b.c.start();
                Handler handler = new Handler(c1490b.c.getLooper());
                c1490b.d = handler;
                handler.post(new RunnableC1489a(c1490b, 1));
                try {
                    c1490b.e.await();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
                if (!c1490b.f) {
                    AbstractC1436a.b("DebugOverlayEgl", "EGL setup failed; intermediateSurface may be unusable", true);
                }
            }
        }
        this.f4486a.e(externalSurface);
        Surface surface = this.f4486a.p;
        if (surface == null) {
            k.n("_intermediateSurface");
            throw null;
        }
        AbstractC1436a.d("DebugOverlayCompositor", "attach: external=" + externalSurface + ", intermediate=" + surface, true);
        Surface surface2 = this.f4486a.p;
        if (surface2 != null) {
            return surface2;
        }
        k.n("_intermediateSurface");
        throw null;
    }

    public final void b() throws InterruptedException {
        if (this.b) {
            return;
        }
        C1490b c1490b = this.f4486a;
        if (!c1490b.g) {
            AbstractC1436a.e("DebugOverlayFlow", "setExternalSurfaceSync: thread not started, drop", true);
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AbstractC1436a.d("DebugOverlayFlow", "setExternalSurfaceSync(begin): surface=null valid=null", true);
        Handler handler = c1490b.d;
        if (handler == null) {
            k.n("handler");
            throw null;
        }
        handler.post(new l(19, c1490b, countDownLatch));
        try {
            AbstractC1436a.d("DebugOverlayFlow", "setExternalSurfaceSync(end): completed=" + countDownLatch.await(500L, TimeUnit.MILLISECONDS), true);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            AbstractC1436a.e("DebugOverlayFlow", "setExternalSurfaceSync interrupted", true);
        }
    }

    public final void c() {
        if (this.b) {
            return;
        }
        this.b = true;
        AbstractC1436a.d("DebugOverlayCompositor", "release", true);
        C1490b c1490b = this.f4486a;
        AbstractC1436a.d("DebugOverlayFlow", "shutdown: started=" + c1490b.g, true);
        if (!c1490b.g) {
            c1490b.c.quitSafely();
            return;
        }
        Handler handler = c1490b.d;
        if (handler == null) {
            k.n("handler");
            throw null;
        }
        handler.post(new RunnableC1489a(c1490b, 0));
        c1490b.c.quitSafely();
    }
}
