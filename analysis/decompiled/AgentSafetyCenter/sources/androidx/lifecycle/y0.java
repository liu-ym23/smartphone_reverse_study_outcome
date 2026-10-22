package androidx.lifecycle;

import java.lang.invoke.VarHandle;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class y0 {

    /* renamed from: a, reason: collision with root package name */
    public final j4.c f1454a;

    public y0() {
        j4.c cVar = new j4.c();
        cVar.f6554a = new j4.b();
        cVar.f6555b = new LinkedHashMap();
        cVar.f6556c = new LinkedHashSet();
        VarHandle.storeStoreFence();
        this.f1454a = cVar;
    }

    public final void a(String str, AutoCloseable autoCloseable) {
        AutoCloseable autoCloseable2;
        j4.c cVar = this.f1454a;
        if (cVar != null) {
            if (cVar.f6557d) {
                j4.c.a(autoCloseable);
                return;
            }
            synchronized (cVar.f6554a) {
                autoCloseable2 = (AutoCloseable) cVar.f6555b.put(str, autoCloseable);
            }
            j4.c.a(autoCloseable2);
        }
    }

    public final void b() {
        j4.c cVar = this.f1454a;
        if (cVar != null && !cVar.f6557d) {
            cVar.f6557d = true;
            synchronized (cVar.f6554a) {
                try {
                    Iterator it = cVar.f6555b.values().iterator();
                    while (it.hasNext()) {
                        j4.c.a((AutoCloseable) it.next());
                    }
                    Iterator it2 = cVar.f6556c.iterator();
                    while (it2.hasNext()) {
                        j4.c.a((AutoCloseable) it2.next());
                    }
                    cVar.f6556c.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        d();
    }

    public final AutoCloseable c(String str) {
        AutoCloseable autoCloseable;
        j4.c cVar = this.f1454a;
        if (cVar == null) {
            return null;
        }
        synchronized (cVar.f6554a) {
            autoCloseable = (AutoCloseable) cVar.f6555b.get(str);
        }
        return autoCloseable;
    }

    public void d() {
    }
}
