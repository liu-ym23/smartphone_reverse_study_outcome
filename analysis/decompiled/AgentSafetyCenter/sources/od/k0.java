package od;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class k0 {

    /* renamed from: d, reason: collision with root package name */
    public static final j0 f9455d = new j0();

    /* renamed from: a, reason: collision with root package name */
    public boolean f9456a;

    /* renamed from: b, reason: collision with root package name */
    public long f9457b;

    /* renamed from: c, reason: collision with root package name */
    public long f9458c;

    public k0 a() {
        this.f9456a = false;
        return this;
    }

    public k0 b() {
        this.f9458c = 0L;
        return this;
    }

    public long c() {
        if (this.f9456a) {
            return this.f9457b;
        }
        f.e("No deadline");
        return 0L;
    }

    public k0 d(long j10) {
        this.f9456a = true;
        this.f9457b = j10;
        return this;
    }

    public boolean e() {
        return this.f9456a;
    }

    public void f() throws InterruptedIOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.f9456a && this.f9457b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public k0 g(long j10) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeUnit.getClass();
        if (j10 >= 0) {
            this.f9458c = timeUnit.toNanos(j10);
            return this;
        }
        f.c(k0.a.m("timeout < 0: ", j10));
        return null;
    }
}
