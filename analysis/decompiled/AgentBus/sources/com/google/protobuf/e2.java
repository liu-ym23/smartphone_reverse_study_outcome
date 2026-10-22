package com.google.protobuf;

/* loaded from: classes.dex */
public final class e2 implements e3 {

    /* renamed from: b, reason: collision with root package name */
    public static final e2 f2343b = new e2(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2344a;

    public /* synthetic */ e2(int i2) {
        this.f2344a = i2;
    }

    @Override // com.google.protobuf.e3
    public final s3 a(Class cls) {
        switch (this.f2344a) {
            case 0:
                if (!i2.class.isAssignableFrom(cls)) {
                    throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
                }
                try {
                    return (s3) i2.e(cls.asSubclass(i2.class)).d(3, null);
                } catch (Exception e10) {
                    throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e10);
                }
            default:
                throw new IllegalStateException("This should never be called.");
        }
    }

    @Override // com.google.protobuf.e3
    public final boolean b(Class cls) {
        switch (this.f2344a) {
            case 0:
                return i2.class.isAssignableFrom(cls);
            default:
                return false;
        }
    }
}
