package n3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f8730a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f8731b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f8732c = new HashMap();

    public m(Runnable runnable) {
        this.f8730a = runnable;
    }

    public final void a() {
        Iterator it = this.f8731b.iterator();
        while (it.hasNext()) {
            androidx.fragment.app.v vVar = ((androidx.fragment.app.p) ((n) it.next())).f1297a;
            if (vVar.f1320q >= 1) {
                Iterator it2 = vVar.f1307c.c().iterator();
                while (it2.hasNext()) {
                    if (it2.next() != null) {
                        od.f.j();
                        return;
                    }
                }
            }
        }
    }

    public final void b() {
        Iterator it = this.f8731b.iterator();
        while (it.hasNext()) {
            androidx.fragment.app.v vVar = ((androidx.fragment.app.p) ((n) it.next())).f1297a;
            if (vVar.f1320q >= 1) {
                Iterator it2 = vVar.f1307c.c().iterator();
                while (it2.hasNext()) {
                    if (it2.next() != null) {
                        od.f.j();
                        return;
                    }
                }
            }
        }
    }

    public final void c() {
        Iterator it = this.f8731b.iterator();
        while (it.hasNext()) {
            androidx.fragment.app.v vVar = ((androidx.fragment.app.p) ((n) it.next())).f1297a;
            if (vVar.f1320q >= 1) {
                Iterator it2 = vVar.f1307c.c().iterator();
                while (it2.hasNext()) {
                    if (it2.next() != null) {
                        od.f.j();
                        return;
                    }
                }
            }
        }
    }

    public final void d(n nVar) {
        this.f8731b.remove(nVar);
        l lVar = (l) this.f8732c.remove(nVar);
        if (lVar != null) {
            lVar.f8727a.c(lVar.f8728b);
            lVar.f8728b = null;
        }
        this.f8730a.run();
    }
}
