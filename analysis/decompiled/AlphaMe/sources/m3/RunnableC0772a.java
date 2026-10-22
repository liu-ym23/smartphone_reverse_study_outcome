package m3;

import java.util.logging.Level;

/* renamed from: m3.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC0772a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final i f13587a = new i();

    /* renamed from: b, reason: collision with root package name */
    public final e f13588b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f13589c;

    public RunnableC0772a(e eVar) {
        this.f13588b = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        while (true) {
            try {
                try {
                    j jVarD = this.f13587a.d();
                    if (jVarD == null) {
                        synchronized (this) {
                            jVarD = this.f13587a.b();
                            if (jVarD == null) {
                                this.f13589c = false;
                                this.f13589c = false;
                                return;
                            }
                        }
                    }
                    this.f13588b.d(jVarD);
                } catch (InterruptedException e4) {
                    this.f13588b.f13613p.d(Level.WARNING, Thread.currentThread().getName() + " was interruppted", e4);
                    this.f13589c = false;
                    return;
                }
            } catch (Throwable th) {
                this.f13589c = false;
                throw th;
            }
        }
    }
}
