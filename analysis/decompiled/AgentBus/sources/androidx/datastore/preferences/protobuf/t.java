package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public final class t implements o0 {

    /* renamed from: b, reason: collision with root package name */
    public static final t f954b = new t(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f955a;

    public /* synthetic */ t(int i2) {
        this.f955a = i2;
    }

    @Override // androidx.datastore.preferences.protobuf.o0
    public final y0 a(Class cls) {
        switch (this.f955a) {
            case 0:
                if (!w.class.isAssignableFrom(cls)) {
                    throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
                }
                try {
                    return (y0) w.d(cls.asSubclass(w.class)).c(3);
                } catch (Exception e10) {
                    throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e10);
                }
            default:
                throw new IllegalStateException("This should never be called.");
        }
    }

    @Override // androidx.datastore.preferences.protobuf.o0
    public final boolean b(Class cls) {
        switch (this.f955a) {
            case 0:
                return w.class.isAssignableFrom(cls);
            default:
                return false;
        }
    }
}
