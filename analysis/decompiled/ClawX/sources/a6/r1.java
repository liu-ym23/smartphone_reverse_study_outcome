package a6;

import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class r1 extends f5.a implements h1 {

    /* renamed from: b, reason: collision with root package name */
    public static final r1 f212b = new r1(c0.f143b);

    @Override // a6.h1
    public final s0 A(p5.l lVar) {
        return s1.f213a;
    }

    @Override // a6.h1
    public final boolean a() {
        return true;
    }

    @Override // a6.h1
    public final boolean isCancelled() {
        return false;
    }

    @Override // a6.h1
    public final Object j(h5.c cVar) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // a6.h1
    public final p l(p1 p1Var) {
        return s1.f213a;
    }

    @Override // a6.h1
    public final s0 n(boolean z, boolean z2, p5.l lVar) {
        return s1.f213a;
    }

    @Override // a6.h1
    public final boolean start() {
        return false;
    }

    public final String toString() {
        return "NonCancellable";
    }

    @Override // a6.h1
    public final CancellationException v() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // a6.h1
    public final void e(CancellationException cancellationException) {
    }
}
