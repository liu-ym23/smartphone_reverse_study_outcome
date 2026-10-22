package L4;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class k extends z {

    /* renamed from: f, reason: collision with root package name */
    private z f3949f;

    public k(z zVar) {
        j4.k.h(zVar, "delegate");
        this.f3949f = zVar;
    }

    @Override // L4.z
    public z a() {
        return this.f3949f.a();
    }

    @Override // L4.z
    public z b() {
        return this.f3949f.b();
    }

    @Override // L4.z
    public long c() {
        return this.f3949f.c();
    }

    @Override // L4.z
    public z d(long j5) {
        return this.f3949f.d(j5);
    }

    @Override // L4.z
    public boolean e() {
        return this.f3949f.e();
    }

    @Override // L4.z
    public void f() throws InterruptedIOException {
        this.f3949f.f();
    }

    @Override // L4.z
    public z g(long j5, TimeUnit timeUnit) {
        j4.k.h(timeUnit, "unit");
        return this.f3949f.g(j5, timeUnit);
    }

    public final z i() {
        return this.f3949f;
    }

    public final k j(z zVar) {
        j4.k.h(zVar, "delegate");
        this.f3949f = zVar;
        return this;
    }
}
