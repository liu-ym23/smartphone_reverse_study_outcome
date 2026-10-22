package sd;

import sd.x;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final t f11959a;

    /* renamed from: b, reason: collision with root package name */
    public static final okio.internal.a f11960b;

    static {
        t tVar;
        try {
            Class.forName("java.nio.file.Files");
            tVar = new u();
        } catch (ClassNotFoundException unused) {
            tVar = new t();
        }
        f11959a = tVar;
        String str = x.f11981b;
        String property = System.getProperty("java.io.tmpdir");
        kotlin.jvm.internal.g.e(property, "getProperty(...)");
        x.a.a(property);
        ClassLoader classLoader = okio.internal.a.class.getClassLoader();
        kotlin.jvm.internal.g.e(classLoader, "getClassLoader(...)");
        f11960b = new okio.internal.a(classLoader);
    }

    public abstract k a(x xVar);

    public abstract j b(x xVar);

    public abstract e0 c(x xVar);
}
