package V9;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class l extends y {
    public y e;

    public l(y delegate) {
        kotlin.jvm.internal.k.f(delegate, "delegate");
        this.e = delegate;
    }

    @Override // V9.y
    public final y a() {
        return this.e.a();
    }

    @Override // V9.y
    public final y b() {
        return this.e.b();
    }

    @Override // V9.y
    public final long c() {
        return this.e.c();
    }

    @Override // V9.y
    public final y d(long j5) {
        return this.e.d(j5);
    }

    @Override // V9.y
    public final boolean e() {
        return this.e.e();
    }

    @Override // V9.y
    public final void f() throws InterruptedIOException {
        this.e.f();
    }

    @Override // V9.y
    public final y g(long j5) {
        TimeUnit unit = TimeUnit.MILLISECONDS;
        kotlin.jvm.internal.k.f(unit, "unit");
        return this.e.g(j5);
    }
}
