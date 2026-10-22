package androidx.datastore.preferences.protobuf;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e0 implements l0 {

    /* renamed from: a, reason: collision with root package name */
    public l0[] f1104a;

    @Override // androidx.datastore.preferences.protobuf.l0
    public final boolean isSupported(Class cls) {
        for (l0 l0Var : this.f1104a) {
            if (l0Var.isSupported(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public final v0 messageInfoFor(Class cls) {
        for (l0 l0Var : this.f1104a) {
            if (l0Var.isSupported(cls)) {
                return l0Var.messageInfoFor(cls);
            }
        }
        g5.f.o("No factory is available for message type: ".concat(cls.getName()));
        return null;
    }
}
