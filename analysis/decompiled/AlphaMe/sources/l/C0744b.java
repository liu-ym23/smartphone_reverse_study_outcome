package l;

import android.os.Handler;
import android.os.Looper;
import f1.AbstractC0557a;

/* renamed from: l.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0744b extends AbstractC0557a {

    /* renamed from: j, reason: collision with root package name */
    public static volatile C0744b f13413j;

    /* renamed from: k, reason: collision with root package name */
    public static final ExecutorC0743a f13414k = new ExecutorC0743a(1);

    /* renamed from: i, reason: collision with root package name */
    public final C0746d f13415i = new C0746d();

    public static C0744b g0() {
        if (f13413j != null) {
            return f13413j;
        }
        synchronized (C0744b.class) {
            try {
                if (f13413j == null) {
                    f13413j = new C0744b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f13413j;
    }

    public final boolean h0() {
        this.f13415i.getClass();
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public final void i0(Runnable runnable) {
        C0746d c0746d = this.f13415i;
        if (c0746d.f13420k == null) {
            synchronized (c0746d.f13418i) {
                try {
                    if (c0746d.f13420k == null) {
                        c0746d.f13420k = Handler.createAsync(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        c0746d.f13420k.post(runnable);
    }
}
