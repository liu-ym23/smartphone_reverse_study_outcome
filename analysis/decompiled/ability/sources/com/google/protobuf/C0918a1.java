package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;

/* renamed from: com.google.protobuf.a1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0918a1 implements V1 {
    public static final C0918a1 b = new C0918a1(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2907a;

    public /* synthetic */ C0918a1(int i) {
        this.f2907a = i;
    }

    @Override // com.google.protobuf.V1
    public final boolean isSupported(Class cls) {
        switch (this.f2907a) {
            case 0:
                return GeneratedMessageLite.class.isAssignableFrom(cls);
            default:
                return false;
        }
    }

    @Override // com.google.protobuf.V1
    public final U1 messageInfoFor(Class cls) {
        switch (this.f2907a) {
            case 0:
                if (!GeneratedMessageLite.class.isAssignableFrom(cls)) {
                    throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
                }
                try {
                    return (U1) GeneratedMessageLite.s(cls.asSubclass(GeneratedMessageLite.class)).r(GeneratedMessageLite.MethodToInvoke.c);
                } catch (Exception e) {
                    throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
                }
            default:
                throw new IllegalStateException("This should never be called.");
        }
    }
}
