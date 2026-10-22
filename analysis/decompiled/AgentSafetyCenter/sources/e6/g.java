package e6;

import androidx.lifecycle.w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends androidx.lifecycle.q {

    /* renamed from: b, reason: collision with root package name */
    public static final g f3528b = new g();

    /* renamed from: c, reason: collision with root package name */
    public static final f f3529c = new f();

    @Override // androidx.lifecycle.q
    public final void a(w wVar) {
        if (!(wVar instanceof androidx.lifecycle.f)) {
            throw new IllegalArgumentException((wVar + " must implement androidx.lifecycle.DefaultLifecycleObserver.").toString());
        }
        androidx.lifecycle.f fVar = (androidx.lifecycle.f) wVar;
        f fVar2 = f3529c;
        fVar2.getClass();
        fVar.o(fVar2);
        fVar.d(fVar2);
    }

    @Override // androidx.lifecycle.q
    public final androidx.lifecycle.p b() {
        return androidx.lifecycle.p.i;
    }

    public final String toString() {
        return "coil.request.GlobalLifecycle";
    }

    @Override // androidx.lifecycle.q
    public final void c(w wVar) {
    }
}
