package b4;

import f4.d2;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import m.x;

/* loaded from: classes.dex */
public abstract class o {
    static {
        c[] cVarArr = {new c(t3.j.class, 1)};
        HashMap map = new HashMap();
        c cVar = cVarArr[0];
        Class cls = cVar.f1487a;
        if (map.containsKey(cls)) {
            throw new IllegalArgumentException(x.j(cls, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
        }
        map.put(cls, cVar);
        Class cls2 = cVarArr[0].f1487a;
        Collections.unmodifiableMap(map);
        int i2 = d2.CONFIG_NAME_FIELD_NUMBER;
        try {
            a();
        } catch (GeneralSecurityException e10) {
            throw new ExceptionInInitializerError(e10);
        }
    }

    public static void a() {
        t3.n.g(s.f1531c);
        t3.n.g(k.f1515a);
        t3.n.e(new e(), true);
        a4.l lVar = n.f1522a;
        a4.j jVar = a4.j.f182b;
        jVar.e(n.f1522a);
        jVar.d(n.f1523b);
        jVar.c(n.f1524c);
        jVar.b(n.f1525d);
        a4.i iVar = a4.i.f180b;
        iVar.b(e.f1491g);
        if (x3.a.a()) {
            return;
        }
        t3.n.e(new e(f4.b.class, new c[]{new c(t3.j.class, 0)}), true);
        jVar.e(h.f1511a);
        jVar.d(h.f1512b);
        jVar.c(h.f1513c);
        jVar.b(h.f1514d);
        iVar.b(e.f1490f);
    }
}
