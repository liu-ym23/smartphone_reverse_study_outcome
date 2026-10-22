package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f834a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f835b;

    static {
        Class<?> cls;
        Class<?> cls2 = null;
        try {
            cls = Class.forName("libcore.io.Memory");
        } catch (Throwable unused) {
            cls = null;
        }
        f834a = cls;
        try {
            cls2 = Class.forName("org.robolectric.Robolectric");
        } catch (Throwable unused2) {
        }
        f835b = cls2 != null;
    }

    public static boolean a() {
        return (f834a == null || f835b) ? false : true;
    }
}
