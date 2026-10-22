package ia;

import java.util.concurrent.locks.LockSupport;

/* loaded from: classes.dex */
public final class f extends a {

    /* renamed from: i, reason: collision with root package name */
    public final Thread f4954i;

    /* renamed from: j, reason: collision with root package name */
    public final x0 f4955j;

    public f(g7.l lVar, Thread thread, x0 x0Var) {
        super(lVar, true);
        this.f4954i = thread;
        this.f4955j = x0Var;
    }

    @Override // ia.o1
    public final void w(Object obj) {
        Thread threadCurrentThread = Thread.currentThread();
        Thread thread = this.f4954i;
        if (q7.k.a(threadCurrentThread, thread)) {
            return;
        }
        LockSupport.unpark(thread);
    }
}
