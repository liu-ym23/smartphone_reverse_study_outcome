package m9;

import java.util.concurrent.locks.LockSupport;

/* renamed from: m9.f, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1713f extends AbstractC1708a {
    public final Thread d;
    public final AbstractC1701T e;

    public C1713f(H7.h hVar, Thread thread, AbstractC1701T abstractC1701T) {
        super(hVar, true);
        this.d = thread;
        this.e = abstractC1701T;
    }

    @Override // kotlinx.coroutines.c
    public final void x(Object obj) {
        Thread threadCurrentThread = Thread.currentThread();
        Thread thread = this.d;
        if (kotlin.jvm.internal.k.b(threadCurrentThread, thread)) {
            return;
        }
        LockSupport.unpark(thread);
    }
}
