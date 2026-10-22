package P0;

import D9.l;
import F.i;
import H4.o;
import R0.c;
import g1.AbstractC1451a;
import k1.AbstractC1620b;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final l f1059a;
    public static final boolean b;

    static {
        l lVar = new l(1000);
        f1059a = lVar;
        b = true;
        lVar.d = new i();
    }

    public static void a(R0.a aVar) {
        f1059a.a(aVar);
        if (AbstractC1451a.f4467a) {
            o.f("APM-CommonEvent", "cached CommonEvent:" + aVar);
        }
        synchronized (a.class) {
            if (AbstractC1620b.a(Q0.a.class) != null) {
                throw new ClassCastException();
            }
        }
    }

    public static void b(c cVar) {
        if (AbstractC1451a.f4467a) {
            o.f("APM-CommonEvent", "trace_data:" + cVar.b());
        }
        N0.a.a(cVar);
    }
}
