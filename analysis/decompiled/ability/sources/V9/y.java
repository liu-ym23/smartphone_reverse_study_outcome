package V9;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class y {
    public static final x d = new x();

    /* renamed from: a, reason: collision with root package name */
    public boolean f1428a;
    public long b;
    public long c;

    public y a() {
        this.f1428a = false;
        return this;
    }

    public y b() {
        this.c = 0L;
        return this;
    }

    public long c() {
        if (this.f1428a) {
            return this.b;
        }
        throw new IllegalStateException("No deadline");
    }

    public y d(long j5) {
        this.f1428a = true;
        this.b = j5;
        return this;
    }

    public boolean e() {
        return this.f1428a;
    }

    public void f() throws InterruptedIOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.f1428a && this.b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public y g(long j5) {
        TimeUnit unit = TimeUnit.MILLISECONDS;
        kotlin.jvm.internal.k.f(unit, "unit");
        if (j5 < 0) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.p(j5, "timeout < 0: ").toString());
        }
        this.c = unit.toNanos(j5);
        return this;
    }
}
