package ob;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class r extends m0 {

    /* renamed from: e, reason: collision with root package name */
    public m0 f8024e;

    public r(m0 m0Var) {
        q7.k.e(m0Var, "delegate");
        this.f8024e = m0Var;
    }

    @Override // ob.m0
    public final m0 a() {
        return this.f8024e.a();
    }

    @Override // ob.m0
    public final m0 b() {
        return this.f8024e.b();
    }

    @Override // ob.m0
    public final long c() {
        return this.f8024e.c();
    }

    @Override // ob.m0
    public final m0 d(long j2) {
        return this.f8024e.d(j2);
    }

    @Override // ob.m0
    public final boolean e() {
        return this.f8024e.e();
    }

    @Override // ob.m0
    public final void f() throws InterruptedIOException {
        this.f8024e.f();
    }

    @Override // ob.m0
    public final m0 g(long j2, TimeUnit timeUnit) {
        q7.k.e(timeUnit, "unit");
        return this.f8024e.g(j2, timeUnit);
    }

    @Override // ob.m0
    public final long h() {
        return this.f8024e.h();
    }
}
