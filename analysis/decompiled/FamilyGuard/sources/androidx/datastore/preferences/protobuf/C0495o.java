package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0495o {

    /* renamed from: a, reason: collision with root package name */
    static final Class<?> f10098a = c();

    public static C0496p a() {
        if (f10098a != null) {
            try {
                return b("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return C0496p.f10102e;
    }

    private static final C0496p b(String str) {
        return (C0496p) f10098a.getDeclaredMethod(str, null).invoke(null, null);
    }

    static Class<?> c() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
