package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0503x implements Q {

    /* renamed from: a, reason: collision with root package name */
    private static final C0503x f10262a = new C0503x();

    private C0503x() {
    }

    public static C0503x c() {
        return f10262a;
    }

    @Override // androidx.datastore.preferences.protobuf.Q
    public P a(Class<?> cls) {
        if (!AbstractC0504y.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        try {
            return (P) AbstractC0504y.y(cls.asSubclass(AbstractC0504y.class)).q();
        } catch (Exception e6) {
            throw new RuntimeException("Unable to get message info for " + cls.getName(), e6);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Q
    public boolean b(Class<?> cls) {
        return AbstractC0504y.class.isAssignableFrom(cls);
    }
}
