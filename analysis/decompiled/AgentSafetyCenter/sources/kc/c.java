package kc;

import java.util.concurrent.locks.LockSupport;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends a {

    /* renamed from: h, reason: collision with root package name */
    public Thread f7418h;

    @Override // kc.e1
    public final void p(Object obj) {
        Thread threadCurrentThread = Thread.currentThread();
        Thread thread = this.f7418h;
        if (yb.k.a(threadCurrentThread, thread)) {
            return;
        }
        LockSupport.unpark(thread);
    }
}
