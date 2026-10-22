package f2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import k2.w0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public final Class f2555a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f2556b;

    /* renamed from: c, reason: collision with root package name */
    public final Class f2557c;

    public e(Class cls, d2.a... aVarArr) {
        this.f2555a = cls;
        HashMap map = new HashMap();
        for (d2.a aVar : aVarArr) {
            Class cls2 = aVar.f1783a;
            if (map.containsKey(cls2)) {
                throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls2.getCanonicalName());
            }
            map.put(cls2, aVar);
        }
        if (aVarArr.length > 0) {
            this.f2557c = aVarArr[0].f1783a;
        } else {
            this.f2557c = Void.class;
        }
        this.f2556b = Collections.unmodifiableMap(map);
    }

    public int a() {
        return 1;
    }

    public abstract String b();

    public final Object c(com.google.crypto.tink.shaded.protobuf.a aVar, Class cls) {
        d2.a aVar2 = (d2.a) this.f2556b.get(cls);
        if (aVar2 != null) {
            return aVar2.a(aVar);
        }
        throw new IllegalArgumentException("Requested primitive class " + cls.getCanonicalName() + " not supported.");
    }

    public abstract d d();

    public abstract w0 e();

    public abstract com.google.crypto.tink.shaded.protobuf.a f(com.google.crypto.tink.shaded.protobuf.i iVar);

    public abstract void g(com.google.crypto.tink.shaded.protobuf.a aVar);
}
