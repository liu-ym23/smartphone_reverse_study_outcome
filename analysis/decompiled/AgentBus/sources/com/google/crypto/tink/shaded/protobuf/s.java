package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes.dex */
public final class s implements o0 {

    /* renamed from: b, reason: collision with root package name */
    public static final s f2281b = new s(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2282a;

    public /* synthetic */ s(int i2) {
        this.f2282a = i2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.o0
    public final z0 a(Class cls) {
        switch (this.f2282a) {
            case 0:
                if (!v.class.isAssignableFrom(cls)) {
                    throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
                }
                try {
                    return (z0) v.i(cls.asSubclass(v.class)).h(3);
                } catch (Exception e10) {
                    throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e10);
                }
            default:
                throw new IllegalStateException("This should never be called.");
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.o0
    public final boolean b(Class cls) {
        switch (this.f2282a) {
            case 0:
                return v.class.isAssignableFrom(cls);
            default:
                return false;
        }
    }
}
