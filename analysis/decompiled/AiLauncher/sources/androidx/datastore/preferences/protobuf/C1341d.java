package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1341d {

    /* renamed from: a, reason: collision with root package name */
    public static final Class<?> f13530a = a("libcore.io.Memory");

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f13531b;

    static {
        f13531b = a("org.robolectric.Robolectric") != null;
    }

    public static <T> Class<T> a(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class<?> b() {
        return f13530a;
    }

    public static boolean c() {
        return (f13530a == null || f13531b) ? false : true;
    }
}
