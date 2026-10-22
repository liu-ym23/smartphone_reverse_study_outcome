package androidx.datastore.preferences.protobuf;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Class<?> f1798a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f1799b;

    static {
        Class<?> cls;
        Class<?> cls2 = null;
        try {
            cls = Class.forName("libcore.io.Memory");
        } catch (Throwable unused) {
            cls = null;
        }
        f1798a = cls;
        try {
            cls2 = Class.forName("org.robolectric.Robolectric");
        } catch (Throwable unused2) {
        }
        f1799b = cls2 != null;
    }

    public static boolean a() {
        return (f1798a == null || f1799b) ? false : true;
    }
}
