package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1350m {

    /* renamed from: a, reason: collision with root package name */
    public static final Class<?> f13618a = c();

    public static C1351n a() {
        if (f13618a != null) {
            try {
                return b("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return C1351n.f13622e;
    }

    public static final C1351n b(String str) throws Exception {
        return (C1351n) f13618a.getDeclaredMethod(str, null).invoke(null, null);
    }

    public static Class<?> c() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
