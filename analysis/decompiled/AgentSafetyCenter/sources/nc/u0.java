package nc;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u0 extends oc.d {

    /* renamed from: a, reason: collision with root package name */
    public AtomicReference f8934a;

    @Override // oc.d
    public final boolean a(oc.b bVar) {
        AtomicReference atomicReference = this.f8934a;
        if (atomicReference.get() != null) {
            return false;
        }
        atomicReference.set(k0.f8872b);
        return true;
    }

    @Override // oc.d
    public final nb.c[] b(oc.b bVar) {
        this.f8934a.set(null);
        return oc.c.f9366a;
    }
}
