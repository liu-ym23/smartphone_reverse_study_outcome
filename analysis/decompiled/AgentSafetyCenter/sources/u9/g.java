package u9;

import java.util.HashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final d f14265a;

    static {
        d dVar = new d();
        dVar.f14261a = new HashMap();
        f14265a = dVar;
    }

    public static e a(Object obj) {
        d dVar = f14265a;
        dVar.getClass();
        Class<?> cls = obj.getClass();
        return dVar.a(cls.getClassLoader(), cls.getName());
    }

    public static e b(String str) {
        d dVar = f14265a;
        dVar.getClass();
        return dVar.a(d.class.getClassLoader(), str);
    }
}
