package androidx.lifecycle;

import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class q0 {

    /* renamed from: a, reason: collision with root package name */
    public final r1.a f2302a = new r1.a();

    public final void a() {
        r1.a aVar = this.f2302a;
        if (aVar != null && !aVar.f11684d) {
            aVar.f11684d = true;
            synchronized (aVar.f11681a) {
                try {
                    Iterator it = aVar.f11682b.values().iterator();
                    while (it.hasNext()) {
                        r1.a.a((AutoCloseable) it.next());
                    }
                    Iterator it2 = aVar.f11683c.iterator();
                    while (it2.hasNext()) {
                        r1.a.a((AutoCloseable) it2.next());
                    }
                    aVar.f11683c.clear();
                    lb.n nVar = lb.n.f10413a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        b();
    }

    public void b() {
    }
}
