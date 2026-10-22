package sd;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class f0 {

    /* renamed from: d, reason: collision with root package name */
    public static final a f11935d = new a();

    /* renamed from: a, reason: collision with root package name */
    public boolean f11936a;

    /* renamed from: b, reason: collision with root package name */
    public long f11937b;

    /* renamed from: c, reason: collision with root package name */
    public long f11938c;

    public f0 a() {
        this.f11936a = false;
        return this;
    }

    public f0 b() {
        this.f11938c = 0L;
        return this;
    }

    public long c() {
        if (this.f11936a) {
            return this.f11937b;
        }
        throw new IllegalStateException("No deadline");
    }

    public f0 d(long j10) {
        this.f11936a = true;
        this.f11937b = j10;
        return this;
    }

    public boolean e() {
        return this.f11936a;
    }

    public void f() throws InterruptedIOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.f11936a && this.f11937b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public f0 g(long j10, TimeUnit unit) {
        kotlin.jvm.internal.g.f(unit, "unit");
        if (j10 < 0) {
            throw new IllegalArgumentException(com.stepos.core.ota.d.f(j10, "timeout < 0: ").toString());
        }
        this.f11938c = unit.toNanos(j10);
        return this;
    }

    public long h() {
        return this.f11938c;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends f0 {
        @Override // sd.f0
        public final f0 g(long j10, TimeUnit unit) {
            kotlin.jvm.internal.g.f(unit, "unit");
            return this;
        }

        @Override // sd.f0
        public final void f() {
        }

        @Override // sd.f0
        public final f0 d(long j10) {
            return this;
        }
    }
}
