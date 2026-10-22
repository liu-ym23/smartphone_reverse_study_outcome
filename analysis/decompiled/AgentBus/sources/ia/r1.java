package ia;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class r1 extends g7.a implements g1 {

    /* renamed from: g, reason: collision with root package name */
    public static final r1 f4998g = new r1(z.f5027g);

    @Override // ia.g1
    public final CancellationException E() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // ia.g1
    public final /* synthetic */ boolean a(Throwable th) {
        return false;
    }

    @Override // ia.g1
    public final boolean b() {
        return true;
    }

    @Override // ia.g1
    public final void d(CancellationException cancellationException) {
    }

    @Override // ia.g1
    public final p0 i(boolean z4, boolean z10, p7.k kVar) {
        return s1.f5001f;
    }

    @Override // ia.g1
    public final p q(o1 o1Var) {
        return s1.f5001f;
    }

    @Override // ia.g1
    public final Object s(i7.c cVar) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // ia.g1
    public final boolean start() {
        return false;
    }

    @Override // ia.g1
    public final p0 t(p7.k kVar) {
        return s1.f5001f;
    }

    public final String toString() {
        return "NonCancellable";
    }
}
