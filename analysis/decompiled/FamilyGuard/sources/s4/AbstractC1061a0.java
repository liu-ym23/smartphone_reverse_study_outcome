package s4;

import W3.C0395f;

/* renamed from: s4.a0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1061a0 extends AbstractC1056E {

    /* renamed from: c, reason: collision with root package name */
    private long f20330c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f20331d;

    /* renamed from: e, reason: collision with root package name */
    private C0395f<U<?>> f20332e;

    public static /* synthetic */ void j0(AbstractC1061a0 abstractC1061a0, boolean z5, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
        }
        if ((i5 & 1) != 0) {
            z5 = false;
        }
        abstractC1061a0.h0(z5);
    }

    private final long k0(boolean z5) {
        return z5 ? 4294967296L : 1L;
    }

    public static /* synthetic */ void o0(AbstractC1061a0 abstractC1061a0, boolean z5, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i5 & 1) != 0) {
            z5 = false;
        }
        abstractC1061a0.n0(z5);
    }

    public final void h0(boolean z5) {
        long jK0 = this.f20330c - k0(z5);
        this.f20330c = jK0;
        if (jK0 <= 0 && this.f20331d) {
            shutdown();
        }
    }

    public final void l0(U<?> u5) {
        C0395f<U<?>> c0395f = this.f20332e;
        if (c0395f == null) {
            c0395f = new C0395f<>();
            this.f20332e = c0395f;
        }
        c0395f.addLast(u5);
    }

    protected long m0() {
        C0395f<U<?>> c0395f = this.f20332e;
        return (c0395f == null || c0395f.isEmpty()) ? Long.MAX_VALUE : 0L;
    }

    public final void n0(boolean z5) {
        this.f20330c += k0(z5);
        if (z5) {
            return;
        }
        this.f20331d = true;
    }

    public final boolean p0() {
        return this.f20330c >= k0(true);
    }

    public final boolean s0() {
        C0395f<U<?>> c0395f = this.f20332e;
        if (c0395f != null) {
            return c0395f.isEmpty();
        }
        return true;
    }

    public void shutdown() {
    }

    public long u0() {
        return !w0() ? Long.MAX_VALUE : 0L;
    }

    public final boolean w0() {
        U<?> uS;
        C0395f<U<?>> c0395f = this.f20332e;
        if (c0395f == null || (uS = c0395f.s()) == null) {
            return false;
        }
        uS.run();
        return true;
    }

    public boolean z0() {
        return false;
    }
}
