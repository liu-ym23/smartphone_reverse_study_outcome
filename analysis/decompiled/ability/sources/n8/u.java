package n8;

import java.lang.reflect.Type;
import java.util.Iterator;
import x8.InterfaceC2121d;

/* loaded from: classes4.dex */
public abstract class u implements InterfaceC2121d {
    @Override // x8.InterfaceC2119b
    public d a(G8.c fqName) {
        Object next;
        kotlin.jvm.internal.k.f(fqName, "fqName");
        Iterator it = getAnnotations().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (kotlin.jvm.internal.k.b(AbstractC1744c.a(M.a.Z(M.a.V(((d) next).f5356a))).a(), fqName)) {
                break;
            }
        }
        return (d) next;
    }

    public abstract Type b();

    public final boolean equals(Object obj) {
        return (obj instanceof u) && kotlin.jvm.internal.k.b(b(), ((u) obj).b());
    }

    public final int hashCode() {
        return b().hashCode();
    }

    public final String toString() {
        return getClass().getName() + ": " + b();
    }
}
