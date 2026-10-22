package c0;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f21897a;

    public final int a() {
        return this.f21897a.decrementAndGet();
    }

    public final int b() {
        return this.f21897a.get();
    }

    public b(int r100) {
        this.f21897a = new AtomicInteger(r100);
    }

    public final void c(int r100) {
        this.f21897a.set(r100);
    }
}
