package c7;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class x {
    public static final w d = new w();

    /* renamed from: a, reason: collision with root package name */
    public boolean f1198a;

    /* renamed from: b, reason: collision with root package name */
    public long f1199b;

    /* renamed from: c, reason: collision with root package name */
    public long f1200c;

    public x a() {
        this.f1198a = false;
        return this;
    }

    public x b() {
        this.f1200c = 0L;
        return this;
    }

    public long c() {
        if (this.f1198a) {
            return this.f1199b;
        }
        throw new IllegalStateException("No deadline");
    }

    public x d(long j4) {
        this.f1198a = true;
        this.f1199b = j4;
        return this;
    }

    public boolean e() {
        return this.f1198a;
    }

    public void f() throws InterruptedIOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.f1198a && this.f1199b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public x g(long j4, TimeUnit unit) {
        kotlin.jvm.internal.p.e(unit, "unit");
        if (j4 < 0) {
            throw new IllegalArgumentException(a8.b.l(j4, "timeout < 0: ").toString());
        }
        this.f1200c = unit.toNanos(j4);
        return this;
    }

    public long h() {
        return this.f1200c;
    }
}
