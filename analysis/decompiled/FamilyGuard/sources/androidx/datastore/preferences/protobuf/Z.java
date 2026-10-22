package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
final class Z {

    /* renamed from: a, reason: collision with root package name */
    private static final X f9979a = c();

    /* renamed from: b, reason: collision with root package name */
    private static final X f9980b = new Y();

    static X a() {
        return f9979a;
    }

    static X b() {
        return f9980b;
    }

    private static X c() {
        try {
            return (X) Class.forName("androidx.datastore.preferences.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
