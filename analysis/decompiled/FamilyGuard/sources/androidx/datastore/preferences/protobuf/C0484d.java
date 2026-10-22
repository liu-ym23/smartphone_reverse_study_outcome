package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0484d {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f9986a = a("libcore.io.Memory");

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f9987b;

    static {
        f9987b = a("org.robolectric.Robolectric") != null;
    }

    private static <T> Class<T> a(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static Class<?> b() {
        return f9986a;
    }

    static boolean c() {
        return (f9986a == null || f9987b) ? false : true;
    }
}
