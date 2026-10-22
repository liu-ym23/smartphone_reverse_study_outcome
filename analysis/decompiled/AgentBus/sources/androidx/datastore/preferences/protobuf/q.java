package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    public static final p f917a = new p();

    /* renamed from: b, reason: collision with root package name */
    public static final p f918b;

    static {
        p pVar = null;
        try {
            pVar = (p) Class.forName("androidx.datastore.preferences.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        f918b = pVar;
    }
}
