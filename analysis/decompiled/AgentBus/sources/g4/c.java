package g4;

import f4.d0;
import f4.d2;
import f4.l;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import m.x;
import t3.n;
import t3.o;

/* loaded from: classes.dex */
public abstract class c {
    static {
        b4.c[] cVarArr = {new b4.c(o.class, 2)};
        HashMap map = new HashMap();
        for (b4.c cVar : cVarArr) {
            Class cls = cVar.f1487a;
            Class cls2 = cVar.f1487a;
            if (map.containsKey(cls)) {
                throw new IllegalArgumentException(x.j(cls2, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
            }
            map.put(cls2, cVar);
        }
        if (cVarArr.length > 0) {
            Class cls3 = cVarArr[0].f1487a;
        }
        Collections.unmodifiableMap(map);
        b4.c[] cVarArr2 = {new b4.c(o.class, 3)};
        HashMap map2 = new HashMap();
        for (b4.c cVar2 : cVarArr2) {
            Class cls4 = cVar2.f1487a;
            Class cls5 = cVar2.f1487a;
            if (map2.containsKey(cls4)) {
                throw new IllegalArgumentException(x.j(cls5, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
            }
            map2.put(cls5, cVar2);
        }
        if (cVarArr2.length > 0) {
            Class cls6 = cVarArr2[0].f1487a;
        }
        Collections.unmodifiableMap(map2);
        int i2 = d2.CONFIG_NAME_FIELD_NUMBER;
        try {
            a();
        } catch (GeneralSecurityException e10) {
            throw new ExceptionInInitializerError(e10);
        }
    }

    public static void a() {
        n.g(e.f3845a);
        if (x3.a.a()) {
            return;
        }
        n.e(new a(l.class, new b4.c[]{new b4.c(o.class, 2)}, 0), true);
        n.e(new a(d0.class, new b4.c[]{new b4.c(o.class, 3)}, 1), true);
    }
}
