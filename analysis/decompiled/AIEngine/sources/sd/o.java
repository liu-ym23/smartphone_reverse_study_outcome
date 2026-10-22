package sd;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class o extends f0 {

    /* renamed from: e, reason: collision with root package name */
    public f0 f11962e;

    public o(f0 delegate) {
        kotlin.jvm.internal.g.f(delegate, "delegate");
        this.f11962e = delegate;
    }

    @Override // sd.f0
    public final f0 a() {
        return this.f11962e.a();
    }

    @Override // sd.f0
    public final f0 b() {
        return this.f11962e.b();
    }

    @Override // sd.f0
    public final long c() {
        return this.f11962e.c();
    }

    @Override // sd.f0
    public final f0 d(long j10) {
        return this.f11962e.d(j10);
    }

    @Override // sd.f0
    public final boolean e() {
        return this.f11962e.e();
    }

    @Override // sd.f0
    public final void f() throws InterruptedIOException {
        this.f11962e.f();
    }

    @Override // sd.f0
    public final f0 g(long j10, TimeUnit unit) {
        kotlin.jvm.internal.g.f(unit, "unit");
        return this.f11962e.g(j10, unit);
    }

    @Override // sd.f0
    public final long h() {
        return this.f11962e.h();
    }
}
