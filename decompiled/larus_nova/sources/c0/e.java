package c0;

import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantLock f21900a;

    public final void a() {
        this.f21900a.lock();
    }

    public final void b() {
        this.f21900a.unlock();
    }

    public e() {
        this.f21900a = new ReentrantLock();
    }
}
