package d2;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import k2.f0;
import k2.r1;
import y1.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f1786a = 0;

    static {
        int i8 = 0;
        a[] aVarArr = {new a(y1.c.class, 0)};
        HashMap map = new HashMap();
        a aVar = aVarArr[0];
        Class cls = aVar.f1783a;
        if (map.containsKey(cls)) {
            throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls.getCanonicalName());
        }
        map.put(cls, aVar);
        Class cls2 = aVarArr[0].f1783a;
        Collections.unmodifiableMap(map);
        int i9 = r1.CONFIG_NAME_FIELD_NUMBER;
        try {
            n.h(f.f1791b);
            if (c2.a.a()) {
                return;
            }
            n.f(new c(f0.class, new a[]{new a(y1.c.class, 0)}, i8), true);
        } catch (GeneralSecurityException e9) {
            throw new ExceptionInInitializerError(e9);
        }
    }
}
