package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
final class O {

    /* renamed from: a, reason: collision with root package name */
    private static final M f9954a = c();

    /* renamed from: b, reason: collision with root package name */
    private static final M f9955b = new N();

    static M a() {
        return f9954a;
    }

    static M b() {
        return f9955b;
    }

    private static M c() {
        try {
            return (M) Class.forName("androidx.datastore.preferences.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
