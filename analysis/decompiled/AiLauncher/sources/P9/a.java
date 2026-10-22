package P9;

import N9.o;
import N9.q;
import N9.s;
import java.util.Collection;
import kotlin.jvm.internal.p;

/* loaded from: classes5.dex */
public final class a {
    public static final b a(N9.d dVar, f type) {
        p.i(dVar, "<this>");
        p.i(type, "type");
        return (b) g(dVar.h(), type);
    }

    public static final c b(N9.g gVar, f type) {
        p.i(gVar, "<this>");
        p.i(type, "type");
        return (c) g(gVar.b(), type);
    }

    public static final g c(N9.n nVar, f type) {
        p.i(nVar, "<this>");
        p.i(type, "type");
        return (g) g(nVar.d(), type);
    }

    public static final h d(o oVar, f type) {
        p.i(oVar, "<this>");
        p.i(type, "type");
        return (h) g(oVar.f(), type);
    }

    public static final j e(q qVar, f type) {
        p.i(qVar, "<this>");
        p.i(type, "type");
        return (j) g(qVar.c(), type);
    }

    public static final k f(s sVar, f type) {
        p.i(sVar, "<this>");
        p.i(type, "type");
        return (k) g(sVar.a(), type);
    }

    public static final <N extends e> N g(Collection<? extends N> collection, f fVar) {
        N n10 = null;
        for (N n11 : collection) {
            if (p.d(n11.getType(), fVar)) {
                if (n10 != null) {
                    throw new IllegalStateException("Multiple extensions handle the same extension type: " + fVar);
                }
                n10 = n11;
            }
        }
        if (n10 != null) {
            return n10;
        }
        throw new IllegalStateException("No extensions handle the extension type: " + fVar);
    }
}
