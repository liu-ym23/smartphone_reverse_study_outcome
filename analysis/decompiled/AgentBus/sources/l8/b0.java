package l8;

import java.lang.reflect.Type;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class b0 implements v8.d {
    @Override // v8.b
    public e a(e9.c cVar) {
        Object next;
        q7.k.e(cVar, "fqName");
        Iterator it = getAnnotations().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (d.a(nb.i.t(nb.i.p(((e) next).f5865a))).b().equals(cVar)) {
                break;
            }
        }
        return (e) next;
    }

    public abstract Type b();

    public final boolean equals(Object obj) {
        return (obj instanceof b0) && q7.k.a(b(), ((b0) obj).b());
    }

    public final int hashCode() {
        return b().hashCode();
    }

    public final String toString() {
        return getClass().getName() + ": " + b();
    }
}
