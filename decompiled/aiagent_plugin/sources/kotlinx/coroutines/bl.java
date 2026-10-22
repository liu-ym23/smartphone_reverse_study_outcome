package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: EventLoop.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class bl extends bj {
    public abstract Thread a();

    public bl() {
    }

    public final void k() {
        Thread r1 = a();
        if (Thread.currentThread() == r1) goto L11;
        b r0 = c.a();
        if (r0 == null) goto L7;
        r0.a(r1);
        d.x r2 = d.x.f38692a;
    L8:
        if (r2 != null) goto L12;
        LockSupport.unpark(r1);
        return;
    L12:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public void a(long r1, bk.c r3) {
        as.f38861a.b(r1, r3);
    }
}
