package g2;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import k2.r1;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class l {
    static {
        d2.a[] aVarArr = {new d2.a(y1.j.class, 2)};
        HashMap map = new HashMap();
        d2.a aVar = aVarArr[0];
        Class cls = aVar.f1783a;
        if (map.containsKey(cls)) {
            throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls.getCanonicalName());
        }
        map.put(cls, aVar);
        Class cls2 = aVarArr[0].f1783a;
        Collections.unmodifiableMap(map);
        int i8 = r1.CONFIG_NAME_FIELD_NUMBER;
        try {
            a();
        } catch (GeneralSecurityException e9) {
            throw new ExceptionInInitializerError(e9);
        }
    }

    public static void a() {
        y1.n.h(p.f2949c);
        y1.n.h(h.f2935a);
        y1.n.f(new b(), true);
        f2.l lVar = k.f2941a;
        f2.j jVar = f2.j.f2563b;
        jVar.e(k.f2941a);
        jVar.d(k.f2942b);
        jVar.c(k.f2943c);
        jVar.b(k.d);
        f2.i iVar = f2.i.f2561b;
        iVar.b(b.f2915f);
        if (c2.a.a()) {
            return;
        }
        y1.n.f(new b(k2.b.class, new d2.a[]{new d2.a(y1.j.class, 1)}), true);
        jVar.e(e.f2932a);
        jVar.d(e.f2933b);
        jVar.c(e.f2934c);
        jVar.b(e.d);
        iVar.b(b.f2914e);
    }
}
