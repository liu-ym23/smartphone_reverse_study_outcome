package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1354q {

    /* renamed from: a, reason: collision with root package name */
    public static final AbstractC1352o<?> f13627a = new C1353p();

    /* renamed from: b, reason: collision with root package name */
    public static final AbstractC1352o<?> f13628b = c();

    public static AbstractC1352o<?> a() {
        AbstractC1352o<?> abstractC1352o = f13628b;
        if (abstractC1352o != null) {
            return abstractC1352o;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static AbstractC1352o<?> b() {
        return f13627a;
    }

    public static AbstractC1352o<?> c() {
        try {
            return (AbstractC1352o) Class.forName("androidx.datastore.preferences.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
