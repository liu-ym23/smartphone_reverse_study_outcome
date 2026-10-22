package androidx.lifecycle;

import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class p0 {

    /* renamed from: a, reason: collision with root package name */
    public final c3.a f1019a = new c3.a();

    public final void a() {
        c3.a aVar = this.f1019a;
        if (aVar == null || aVar.f1894d) {
            return;
        }
        aVar.f1894d = true;
        synchronized (aVar.f1891a) {
            try {
                Iterator it = aVar.f1892b.values().iterator();
                while (it.hasNext()) {
                    c3.a.a((AutoCloseable) it.next());
                }
                Iterator it2 = aVar.f1893c.iterator();
                while (it2.hasNext()) {
                    c3.a.a((AutoCloseable) it2.next());
                }
                aVar.f1893c.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
