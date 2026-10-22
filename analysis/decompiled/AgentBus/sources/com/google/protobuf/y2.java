package com.google.protobuf;

/* loaded from: classes.dex */
public final class y2 implements e3 {

    /* renamed from: a, reason: collision with root package name */
    public e3[] f2635a;

    @Override // com.google.protobuf.e3
    public final s3 a(Class cls) {
        for (e3 e3Var : this.f2635a) {
            if (e3Var.b(cls)) {
                return e3Var.a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.protobuf.e3
    public final boolean b(Class cls) {
        for (e3 e3Var : this.f2635a) {
            if (e3Var.b(cls)) {
                return true;
            }
        }
        return false;
    }
}
