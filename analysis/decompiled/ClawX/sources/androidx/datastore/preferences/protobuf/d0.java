package androidx.datastore.preferences.protobuf;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d0 implements k0 {

    /* renamed from: a, reason: collision with root package name */
    public k0[] f463a;

    @Override // androidx.datastore.preferences.protobuf.k0
    public final t0 a(Class cls) {
        for (k0 k0Var : this.f463a) {
            if (k0Var.b(cls)) {
                return k0Var.a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // androidx.datastore.preferences.protobuf.k0
    public final boolean b(Class cls) {
        for (k0 k0Var : this.f463a) {
            if (k0Var.b(cls)) {
                return true;
            }
        }
        return false;
    }
}
