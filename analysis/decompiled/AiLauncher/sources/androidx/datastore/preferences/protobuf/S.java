package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public final class S {

    /* renamed from: a, reason: collision with root package name */
    public static final P f13485a = c();

    /* renamed from: b, reason: collision with root package name */
    public static final P f13486b = new Q();

    public static P a() {
        return f13485a;
    }

    public static P b() {
        return f13486b;
    }

    public static P c() {
        try {
            return (P) Class.forName("androidx.datastore.preferences.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
