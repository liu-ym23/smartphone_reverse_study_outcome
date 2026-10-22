package r2;

import java.util.HashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: e, reason: collision with root package name */
    public static final String f11719e = h2.j.f("WorkTimer");

    /* renamed from: a, reason: collision with root package name */
    public final androidx.lifecycle.b f11720a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f11721b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f11722c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final Object f11723d = new Object();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a {
        void a(q2.k kVar);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final r f11724a;

        /* renamed from: b, reason: collision with root package name */
        public final q2.k f11725b;

        public b(r rVar, q2.k kVar) {
            this.f11724a = rVar;
            this.f11725b = kVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (this.f11724a.f11723d) {
                try {
                    if (((b) this.f11724a.f11721b.remove(this.f11725b)) != null) {
                        a aVar = (a) this.f11724a.f11722c.remove(this.f11725b);
                        if (aVar != null) {
                            aVar.a(this.f11725b);
                        }
                    } else {
                        h2.j.d().a("WrkTimerRunnable", "Timer with " + this.f11725b + " is already marked as complete.");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public r(androidx.lifecycle.b bVar) {
        this.f11720a = bVar;
    }

    public final void a(q2.k kVar) {
        synchronized (this.f11723d) {
            try {
                if (((b) this.f11721b.remove(kVar)) != null) {
                    h2.j.d().a(f11719e, "Stopping timer for " + kVar);
                    this.f11722c.remove(kVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
