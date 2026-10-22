package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes4.dex */
public abstract class s0 extends q0 {
    public s0() {
    }

    public abstract Thread q();

    public void r(long r10, r0.c r11) {
        f0.f21422i.B(r10, r11);
    }

    public final void s() {
        Thread r10 = q();
        if (Thread.currentThread() == r10) goto L6;
        c.a();
        LockSupport.unpark(r10);
        return;
    }
}
