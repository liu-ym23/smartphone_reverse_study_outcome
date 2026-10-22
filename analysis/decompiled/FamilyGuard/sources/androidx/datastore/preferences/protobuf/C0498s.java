package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0498s {

    /* renamed from: a, reason: collision with root package name */
    private static final AbstractC0497q<?> f10119a = new r();

    /* renamed from: b, reason: collision with root package name */
    private static final AbstractC0497q<?> f10120b = c();

    static AbstractC0497q<?> a() {
        AbstractC0497q<?> abstractC0497q = f10120b;
        if (abstractC0497q != null) {
            return abstractC0497q;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static AbstractC0497q<?> b() {
        return f10119a;
    }

    private static AbstractC0497q<?> c() {
        try {
            return (AbstractC0497q) Class.forName("androidx.datastore.preferences.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
