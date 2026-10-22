package ob;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class m0 {

    /* renamed from: d, reason: collision with root package name */
    public static final l0 f8007d = new l0();

    /* renamed from: a, reason: collision with root package name */
    public boolean f8008a;

    /* renamed from: b, reason: collision with root package name */
    public long f8009b;

    /* renamed from: c, reason: collision with root package name */
    public long f8010c;

    public m0 a() {
        this.f8008a = false;
        return this;
    }

    public m0 b() {
        this.f8010c = 0L;
        return this;
    }

    public long c() {
        if (this.f8008a) {
            return this.f8009b;
        }
        throw new IllegalStateException("No deadline");
    }

    public m0 d(long j2) {
        this.f8008a = true;
        this.f8009b = j2;
        return this;
    }

    public boolean e() {
        return this.f8008a;
    }

    public void f() throws InterruptedIOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.f8008a && this.f8009b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public m0 g(long j2, TimeUnit timeUnit) {
        q7.k.e(timeUnit, "unit");
        if (j2 < 0) {
            throw new IllegalArgumentException(a1.a.h("timeout < 0: ", j2).toString());
        }
        this.f8010c = timeUnit.toNanos(j2);
        return this;
    }

    public long h() {
        return this.f8010c;
    }
}
