package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public final class h0 implements o0 {

    /* renamed from: a, reason: collision with root package name */
    public o0[] f868a;

    @Override // androidx.datastore.preferences.protobuf.o0
    public final y0 a(Class cls) {
        for (o0 o0Var : this.f868a) {
            if (o0Var.b(cls)) {
                return o0Var.a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // androidx.datastore.preferences.protobuf.o0
    public final boolean b(Class cls) {
        for (o0 o0Var : this.f868a) {
            if (o0Var.b(cls)) {
                return true;
            }
        }
        return false;
    }
}
