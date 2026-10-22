package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public final class O implements W {

    /* renamed from: a, reason: collision with root package name */
    public W[] f3431a;

    @Override // androidx.datastore.preferences.protobuf.W
    public final V a(Class cls) {
        for (W w4 : this.f3431a) {
            if (w4.b(cls)) {
                return w4.a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // androidx.datastore.preferences.protobuf.W
    public final boolean b(Class cls) {
        for (W w4 : this.f3431a) {
            if (w4.b(cls)) {
                return true;
            }
        }
        return false;
    }
}
