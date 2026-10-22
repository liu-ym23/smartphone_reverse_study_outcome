package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1357u implements J {

    /* renamed from: a, reason: collision with root package name */
    public static final C1357u f13638a = new C1357u();

    public static C1357u a() {
        return f13638a;
    }

    @Override // androidx.datastore.preferences.protobuf.J
    public boolean isSupported(Class<?> cls) {
        return GeneratedMessageLite.class.isAssignableFrom(cls);
    }

    @Override // androidx.datastore.preferences.protobuf.J
    public I messageInfoFor(Class<?> cls) {
        if (!GeneratedMessageLite.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        try {
            return (I) GeneratedMessageLite.q(cls.asSubclass(GeneratedMessageLite.class)).i();
        } catch (Exception e10) {
            throw new RuntimeException("Unable to get message info for " + cls.getName(), e10);
        }
    }
}
