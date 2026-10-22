package hb;

import android.os.Handler;
import android.os.HandlerThread;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final Object f9395a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public boolean f9396b;

    /* renamed from: c, reason: collision with root package name */
    public int f9397c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f9398d;

    public g() {
        HandlerThread handlerThread = new HandlerThread("ota_model_download");
        handlerThread.start();
        this.f9398d = new Handler(handlerThread.getLooper());
    }

    public final void a() {
        synchronized (this.f9395a) {
            if (!this.f9396b) {
                this.f9396b = true;
                try {
                    this.f9398d.removeCallbacksAndMessages(null);
                    this.f9398d.getLooper().quit();
                } catch (Exception unused) {
                }
            }
            n nVar = n.f10413a;
        }
    }

    public final void b(zb.a<n> aVar) {
        synchronized (this.f9395a) {
            try {
                if (!this.f9396b) {
                    this.f9398d.post(new com.stepos.core.common.telemetry.c(1, aVar));
                }
                n nVar = n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(long j10, Runnable runnable) {
        kotlin.jvm.internal.g.f(runnable, "runnable");
        synchronized (this.f9395a) {
            try {
                if (!this.f9396b) {
                    this.f9398d.postDelayed(runnable, j10);
                }
                n nVar = n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(Runnable runnable) {
        kotlin.jvm.internal.g.f(runnable, "runnable");
        synchronized (this.f9395a) {
            try {
                if (!this.f9396b) {
                    this.f9398d.removeCallbacks(runnable);
                }
                n nVar = n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!g.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        kotlin.jvm.internal.g.d(obj, "null cannot be cast to non-null type com.tonyodev.fetch2core.HandlerWrapper");
        return true;
    }

    public final int hashCode() {
        return 1480892513;
    }
}
