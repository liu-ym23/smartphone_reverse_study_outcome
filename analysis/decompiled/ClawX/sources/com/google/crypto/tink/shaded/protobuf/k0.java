package com.google.crypto.tink.shaded.protobuf;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class k0 implements p0 {

    /* renamed from: a, reason: collision with root package name */
    public p0[] f1484a;

    @Override // com.google.crypto.tink.shaded.protobuf.p0
    public final a1 a(Class cls) {
        for (p0 p0Var : this.f1484a) {
            if (p0Var.b(cls)) {
                return p0Var.a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.p0
    public final boolean b(Class cls) {
        for (p0 p0Var : this.f1484a) {
            if (p0Var.b(cls)) {
                return true;
            }
        }
        return false;
    }
}
