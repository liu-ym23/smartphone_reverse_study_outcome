package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes4.dex */
public final class f extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Thread f21420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q0 f21421e;

    public f(CoroutineContext r10, Thread r11, q0 r12) {
        super(r10, true, true);
        this.f21420d = r11;
        this.f21421e = r12;
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean I() {
        return true;
    }

    @Override // kotlinx.coroutines.JobSupport
    public void h(Object r10) {
        if (kotlin.jvm.internal.q.b(Thread.currentThread(), this.f21420d) == true) goto L6;
        Thread r11 = this.f21420d;
        c.a();
        LockSupport.unpark(r11);
        return;
    }

    public final Object r0() {
        c.a();
        q0 r10 = this.f21421e;     // Catch: Throwable -> L7
        w r11 = null;
        if (r10 == null) goto L40;
        q0.k(r10, false, 1, null);     // Catch: Throwable -> L7
    L40:
    L14:
        th = move-exception;
        q0 r12 = this.f21421e;     // Catch: Throwable -> L7
        if (r12 == null) goto L36;
        q0.f(r12, false, 1, null);     // Catch: Throwable -> L7
    L36:
        throw th;     // Catch: Throwable -> L7
    L10:
        if (Thread.interrupted() == true) goto L31;
        q0 r13 = this.f21421e;     // Catch: Throwable -> L14
        if (r13 == null) goto L16;
        long r14 = r13.n();     // Catch: Throwable -> L14
    L18:
        if (isCompleted() == true) goto L21;
        c.a();     // Catch: Throwable -> L14
        LockSupport.parkNanos(this, r14);     // Catch: Throwable -> L14
        goto L40
    L21:
        q0 r15 = this.f21421e;     // Catch: Throwable -> L7
        if (r15 == null) goto L24;
        q0.f(r15, false, 1, null);     // Catch: Throwable -> L7
    L24:
        c.a();
        Object r16 = l1.h(E());
        if ((r16 instanceof w) == false) goto L27;
        r11 = (w) r16;
    L27:
        if (r11 != null) goto L30;
        return r16;
    L30:
        throw r11.f21768a;
    L16:
        r14 = Long.MAX_VALUE;
        goto L18
    L31:
        InterruptedException r17 = new InterruptedException();     // Catch: Throwable -> L14
        k(r17);     // Catch: Throwable -> L14
        throw r17;     // Catch: Throwable -> L14
    L7:
        th = move-exception;
        c.a();
        throw th;
    }
}
