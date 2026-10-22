package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public final class H {

    /* renamed from: a, reason: collision with root package name */
    public static final F f13457a = c();

    /* renamed from: b, reason: collision with root package name */
    public static final F f13458b = new G();

    public static F a() {
        return f13457a;
    }

    public static F b() {
        return f13458b;
    }

    public static F c() {
        try {
            return (F) Class.forName("androidx.datastore.preferences.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
