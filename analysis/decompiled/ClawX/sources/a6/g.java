package a6;

import java.util.concurrent.locks.LockSupport;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g extends a {
    public final Thread d;

    /* renamed from: e, reason: collision with root package name */
    public final a1 f161e;

    public g(f5.h hVar, Thread thread, a1 a1Var) {
        super(hVar, true);
        this.d = thread;
        this.f161e = a1Var;
    }

    @Override // a6.p1
    public final void q(Object obj) {
        Thread threadCurrentThread = Thread.currentThread();
        Thread thread = this.d;
        if (kotlin.jvm.internal.p.a(threadCurrentThread, thread)) {
            return;
        }
        LockSupport.unpark(thread);
    }
}
