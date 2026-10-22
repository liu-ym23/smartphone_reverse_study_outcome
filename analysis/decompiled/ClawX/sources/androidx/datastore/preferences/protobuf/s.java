package androidx.datastore.preferences.protobuf;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class s implements k0 {

    /* renamed from: b, reason: collision with root package name */
    public static final s f562b = new s(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f563a;

    public /* synthetic */ s(int i8) {
        this.f563a = i8;
    }

    @Override // androidx.datastore.preferences.protobuf.k0
    public final t0 a(Class cls) {
        switch (this.f563a) {
            case 0:
                if (!v.class.isAssignableFrom(cls)) {
                    throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
                }
                try {
                    return (t0) v.d(cls.asSubclass(v.class)).c(3);
                } catch (Exception e9) {
                    throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e9);
                }
            default:
                throw new IllegalStateException("This should never be called.");
        }
    }

    @Override // androidx.datastore.preferences.protobuf.k0
    public final boolean b(Class cls) {
        switch (this.f563a) {
            case 0:
                return v.class.isAssignableFrom(cls);
            default:
                return false;
        }
    }
}
