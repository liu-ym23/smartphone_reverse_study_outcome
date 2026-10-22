package q5;

import g5.u;
import h5.d0;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final h5.d f10086c;

    /* renamed from: f, reason: collision with root package name */
    public final h5.j f10087f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f10088g;

    /* renamed from: h, reason: collision with root package name */
    public final int f10089h;

    public g(h5.d dVar, h5.j jVar, boolean z10, int i) {
        dVar.getClass();
        jVar.getClass();
        this.f10086c = dVar;
        this.f10087f = jVar;
        this.f10088g = z10;
        this.f10089h = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zD;
        d0 d0VarB;
        boolean z10 = this.f10088g;
        h5.d dVar = this.f10086c;
        h5.j jVar = this.f10087f;
        if (z10) {
            int i = this.f10089h;
            dVar.getClass();
            String str = jVar.f5348a.f9734a;
            synchronized (dVar.f5324j) {
                d0VarB = dVar.b(str);
            }
            zD = h5.d.d(str, d0VarB, i);
        } else {
            int i3 = this.f10089h;
            dVar.getClass();
            String str2 = jVar.f5348a.f9734a;
            synchronized (dVar.f5324j) {
                try {
                    if (dVar.f5320e.get(str2) != null) {
                        u.d().a(h5.d.f5315k, "Ignored stopWork. WorkerWrapper " + str2 + " is in foreground");
                    } else {
                        Set set = (Set) dVar.f5322g.get(str2);
                        if (set != null && set.contains(jVar)) {
                            zD = h5.d.d(str2, dVar.b(str2), i3);
                        }
                    }
                    zD = false;
                } finally {
                }
            }
        }
        u.d().a(u.f("StopWorkRunnable"), "StopWorkRunnable for " + this.f10087f.f5348a.f9734a + "; Processor.stopWork = " + zD);
    }
}
