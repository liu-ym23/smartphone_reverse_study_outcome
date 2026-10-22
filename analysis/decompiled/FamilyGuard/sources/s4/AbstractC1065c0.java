package s4;

import java.util.concurrent.locks.LockSupport;
import s4.AbstractC1063b0;

/* renamed from: s4.c0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1065c0 extends AbstractC1061a0 {
    protected abstract Thread A0();

    protected void B0(long j5, AbstractC1063b0.b bVar) {
        N.f20317i.P0(j5, bVar);
    }

    protected final void C0() {
        Thread threadA0 = A0();
        if (Thread.currentThread() != threadA0) {
            C1064c.a();
            LockSupport.unpark(threadA0);
        }
    }
}
