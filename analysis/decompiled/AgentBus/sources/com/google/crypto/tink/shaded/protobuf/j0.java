package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes.dex */
public final class j0 implements o0 {

    /* renamed from: a, reason: collision with root package name */
    public o0[] f2230a;

    @Override // com.google.crypto.tink.shaded.protobuf.o0
    public final z0 a(Class cls) {
        for (o0 o0Var : this.f2230a) {
            if (o0Var.b(cls)) {
                return o0Var.a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.o0
    public final boolean b(Class cls) {
        for (o0 o0Var : this.f2230a) {
            if (o0Var.b(cls)) {
                return true;
            }
        }
        return false;
    }
}
