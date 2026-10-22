package com.google.protobuf;

/* loaded from: classes3.dex */
public final class E1 implements V1 {

    /* renamed from: a, reason: collision with root package name */
    public V1[] f2827a;

    @Override // com.google.protobuf.V1
    public final boolean isSupported(Class cls) {
        for (V1 v12 : this.f2827a) {
            if (v12.isSupported(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.protobuf.V1
    public final U1 messageInfoFor(Class cls) {
        for (V1 v12 : this.f2827a) {
            if (v12.isSupported(cls)) {
                return v12.messageInfoFor(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }
}
