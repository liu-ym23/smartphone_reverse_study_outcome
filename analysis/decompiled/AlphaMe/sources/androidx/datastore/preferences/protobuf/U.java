package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public abstract class U {

    /* renamed from: a, reason: collision with root package name */
    public static final T f3439a;

    /* renamed from: b, reason: collision with root package name */
    public static final T f3440b;

    static {
        T t4;
        try {
            t4 = (T) Class.forName("androidx.datastore.preferences.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            t4 = null;
        }
        f3439a = t4;
        f3440b = new T();
    }
}
