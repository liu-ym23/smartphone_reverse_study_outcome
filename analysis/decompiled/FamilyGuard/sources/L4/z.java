package L4;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    private boolean f3990a;

    /* renamed from: b, reason: collision with root package name */
    private long f3991b;

    /* renamed from: c, reason: collision with root package name */
    private long f3992c;

    /* renamed from: e, reason: collision with root package name */
    public static final b f3989e = new b(null);

    /* renamed from: d, reason: collision with root package name */
    public static final z f3988d = new a();

    public static final class a extends z {
        a() {
        }

        @Override // L4.z
        public z d(long j5) {
            return this;
        }

        @Override // L4.z
        public void f() {
        }

        @Override // L4.z
        public z g(long j5, TimeUnit timeUnit) {
            j4.k.h(timeUnit, "unit");
            return this;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(j4.g gVar) {
            this();
        }
    }

    public z a() {
        this.f3990a = false;
        return this;
    }

    public z b() {
        this.f3992c = 0L;
        return this;
    }

    public long c() {
        if (this.f3990a) {
            return this.f3991b;
        }
        throw new IllegalStateException("No deadline");
    }

    public z d(long j5) {
        this.f3990a = true;
        this.f3991b = j5;
        return this;
    }

    public boolean e() {
        return this.f3990a;
    }

    public void f() throws InterruptedIOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.f3990a && this.f3991b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public z g(long j5, TimeUnit timeUnit) {
        j4.k.h(timeUnit, "unit");
        if (j5 >= 0) {
            this.f3992c = timeUnit.toNanos(j5);
            return this;
        }
        throw new IllegalArgumentException(("timeout < 0: " + j5).toString());
    }

    public long h() {
        return this.f3992c;
    }
}
