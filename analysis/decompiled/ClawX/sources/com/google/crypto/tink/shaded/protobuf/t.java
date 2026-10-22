package com.google.crypto.tink.shaded.protobuf;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class t implements p0 {

    /* renamed from: b, reason: collision with root package name */
    public static final t f1531b = new t(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1532a;

    public /* synthetic */ t(int i8) {
        this.f1532a = i8;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.p0
    public final a1 a(Class cls) {
        switch (this.f1532a) {
            case 0:
                if (!w.class.isAssignableFrom(cls)) {
                    throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
                }
                try {
                    return (a1) w.j(cls.asSubclass(w.class)).i(3);
                } catch (Exception e9) {
                    throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e9);
                }
            default:
                throw new IllegalStateException("This should never be called.");
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.p0
    public final boolean b(Class cls) {
        switch (this.f1532a) {
            case 0:
                return w.class.isAssignableFrom(cls);
            default:
                return false;
        }
    }
}
