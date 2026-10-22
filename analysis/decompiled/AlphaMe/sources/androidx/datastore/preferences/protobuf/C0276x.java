package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0276x implements W {

    /* renamed from: a, reason: collision with root package name */
    public static final C0276x f3550a = new C0276x();

    @Override // androidx.datastore.preferences.protobuf.W
    public final V a(Class cls) {
        if (!A.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (V) A.e(cls.asSubclass(A.class)).d(3);
        } catch (Exception e4) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e4);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.W
    public final boolean b(Class cls) {
        return A.class.isAssignableFrom(cls);
    }
}
