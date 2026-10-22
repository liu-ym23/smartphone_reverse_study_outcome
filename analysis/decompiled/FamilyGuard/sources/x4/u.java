package x4;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import s4.x0;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public static final u f23887a;

    /* renamed from: b, reason: collision with root package name */
    public static final x0 f23888b;

    static {
        u uVar = new u();
        f23887a = uVar;
        C1295G.f("kotlinx.coroutines.fast.service.loader", true);
        f23888b = uVar.a();
    }

    private u() {
    }

    private final x0 a() {
        Object next;
        x0 x0VarE;
        try {
            List listG = q4.e.g(q4.e.c(ServiceLoader.load(t.class, t.class.getClassLoader()).iterator()));
            Iterator it = listG.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int iC = ((t) next).c();
                    do {
                        Object next2 = it.next();
                        int iC2 = ((t) next2).c();
                        if (iC < iC2) {
                            next = next2;
                            iC = iC2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            t tVar = (t) next;
            if (tVar != null && (x0VarE = v.e(tVar, listG)) != null) {
                return x0VarE;
            }
            v.b(null, null, 3, null);
            return null;
        } catch (Throwable th) {
            v.b(th, null, 2, null);
            return null;
        }
    }
}
