package y3;

import f4.d2;
import f4.r0;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import m.x;
import t3.n;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f11546a = 0;

    static {
        b4.c[] cVarArr = {new b4.c(t3.c.class, 13)};
        HashMap map = new HashMap();
        b4.c cVar = cVarArr[0];
        Class cls = cVar.f1487a;
        if (map.containsKey(cls)) {
            throw new IllegalArgumentException(x.j(cls, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
        }
        map.put(cls, cVar);
        Class cls2 = cVarArr[0].f1487a;
        Collections.unmodifiableMap(map);
        int i2 = d2.CONFIG_NAME_FIELD_NUMBER;
        try {
            n.g(c.f11551b);
            if (x3.a.a()) {
                return;
            }
            n.e(new g4.a(r0.class, new b4.c[]{new b4.c(t3.c.class, 13)}, 10), true);
        } catch (GeneralSecurityException e10) {
            throw new ExceptionInInitializerError(e10);
        }
    }
}
