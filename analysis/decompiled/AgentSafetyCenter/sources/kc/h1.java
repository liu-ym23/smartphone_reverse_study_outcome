package kc;

import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h1 extends nb.a implements x0 {

    /* renamed from: c, reason: collision with root package name */
    public static final h1 f7440c = new h1(w0.f7498c);

    @Override // kc.x0
    public final j A(e1 e1Var) {
        return i1.f7443c;
    }

    @Override // kc.x0
    public final g0 H(boolean z10, boolean z11, androidx.room.d dVar) {
        return i1.f7443c;
    }

    @Override // kc.x0
    public final boolean d() {
        return true;
    }

    @Override // kc.x0
    public final g0 g(xb.l lVar) {
        return i1.f7443c;
    }

    @Override // kc.x0
    public final Object i(pb.c cVar) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // kc.x0
    public final boolean isCancelled() {
        return false;
    }

    @Override // kc.x0
    public final CancellationException o() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // kc.x0
    public final boolean start() {
        return false;
    }

    public final String toString() {
        return "NonCancellable";
    }

    @Override // kc.x0
    public final void e(CancellationException cancellationException) {
    }
}
