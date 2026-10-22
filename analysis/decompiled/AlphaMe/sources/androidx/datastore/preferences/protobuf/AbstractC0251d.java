package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0251d {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f3465a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f3466b;

    static {
        Class<?> cls;
        Class<?> cls2 = null;
        try {
            cls = Class.forName("libcore.io.Memory");
        } catch (Throwable unused) {
            cls = null;
        }
        f3465a = cls;
        try {
            cls2 = Class.forName("org.robolectric.Robolectric");
        } catch (Throwable unused2) {
        }
        f3466b = cls2 != null;
    }

    public static boolean a() {
        return (f3465a == null || f3466b) ? false : true;
    }
}
