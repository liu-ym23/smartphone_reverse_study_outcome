package kotlin.jvm.internal;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final j f10086a;

    /* renamed from: b, reason: collision with root package name */
    public static final ec.c[] f10087b;

    static {
        j jVar = null;
        try {
            jVar = (j) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (jVar == null) {
            jVar = new j();
        }
        f10086a = jVar;
        f10087b = new ec.c[0];
    }

    public static c a(Class cls) {
        f10086a.getClass();
        return new c(cls);
    }
}
