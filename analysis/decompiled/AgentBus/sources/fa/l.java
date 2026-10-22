package fa;

import b0.a2;
import d7.q;
import d7.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class l extends m {
    public static j o0(Iterator it) {
        q7.k.e(it, "<this>");
        return new a(new q(2, it));
    }

    public static int p0(j jVar) {
        Iterator it = jVar.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            it.next();
            i2++;
            if (i2 < 0) {
                throw new ArithmeticException("Count overflow has happened.");
            }
        }
        return i2;
    }

    public static j q0(j jVar, int i2) {
        if (i2 >= 0) {
            return i2 == 0 ? jVar : jVar instanceof c ? ((c) jVar).a(i2) : new b(jVar, i2);
        }
        throw new IllegalArgumentException(a1.a.f(i2, "Requested element count ", " is less than zero.").toString());
    }

    public static final g r0(j jVar) {
        c6.d dVar = new c6.d(13);
        if (!(jVar instanceof p)) {
            return new g(jVar, new c6.d(14), dVar);
        }
        p pVar = (p) jVar;
        return new g(pVar.f3642a, pVar.f3643b, dVar);
    }

    public static j s0(Object obj, p7.k kVar) {
        return obj == null ? d.f3617a : new i(new a2(5, obj), kVar);
    }

    public static p t0(j jVar, p7.k kVar) {
        q7.k.e(kVar, "transform");
        return new p(jVar, kVar);
    }

    public static f u0(j jVar, p7.k kVar) {
        return new f(new p(jVar, kVar), false, new c6.d(15));
    }

    public static List v0(j jVar) {
        Iterator it = jVar.iterator();
        if (!it.hasNext()) {
            return z.f2978f;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return a.a.S(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
