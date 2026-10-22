package androidx.datastore.preferences.protobuf;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s implements l0 {

    /* renamed from: b, reason: collision with root package name */
    public static final s f1193b = new s(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1194a;

    public /* synthetic */ s(int i) {
        this.f1194a = i;
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public final boolean isSupported(Class cls) {
        switch (this.f1194a) {
            case 0:
                return v.class.isAssignableFrom(cls);
            default:
                return false;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public final v0 messageInfoFor(Class cls) {
        switch (this.f1194a) {
            case 0:
                if (v.class.isAssignableFrom(cls)) {
                    try {
                        return (v0) v.d(cls.asSubclass(v.class)).c(3);
                    } catch (Exception e10) {
                        od.f.g("Unable to get message info for ".concat(cls.getName()), e10);
                    }
                } else {
                    g5.f.s("Unsupported message type: ".concat(cls.getName()));
                }
                return null;
            default:
                throw new IllegalStateException("This should never be called.");
        }
    }
}
