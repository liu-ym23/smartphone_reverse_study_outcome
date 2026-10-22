package kotlinx.coroutines;

import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: classes4.dex */
public final class d2 extends kotlinx.coroutines.internal.x {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ThreadLocal f21373e;
    private volatile boolean threadLocalIsSet;

    public d2(CoroutineContext r10, Continuation r11) {
        e2 r12 = e2.f21419a;
        if (r10.get(r12) != null) goto L5;
        CoroutineContext r13 = r10.plus(r12);
    L6:
        super(r13, r11);
        this.f21373e = new ThreadLocal();
        if ((r11.getContext().get(ContinuationInterceptor.Key) instanceof CoroutineDispatcher) == true) goto L10;
        Object r14 = ThreadContextKt.c(r10, null);
        ThreadContextKt.a(r10, r14);
        s0(r10, r14);
        return;
    L10:
        return;
    L5:
        r13 = r10;
        goto L6
    }

    @Override // kotlinx.coroutines.internal.x, kotlinx.coroutines.a
    public void n0(Object r10) {
        if (this.threadLocalIsSet == false) goto L8;
        Pair r11 = (Pair) this.f21373e.get();
        if (r11 == null) goto L7;
        ThreadContextKt.a((CoroutineContext) r11.component1(), r11.component2());
    L7:
        this.f21373e.remove();
    L8:
        Object r12 = z.a(r10, this.f21628d);
        Continuation r13 = this.f21628d;
        CoroutineContext r14 = r13.getContext();
        d2 r15 = null;
        Object r16 = ThreadContextKt.c(r14, null);
        if (r16 == ThreadContextKt.f21572a) goto L23;
        r15 = CoroutineContextKt.g(r13, r14, r16);
    L23:
        this.f21628d.resumeWith(r12);     // Catch: Throwable -> L17
        Unit r17 = Unit.f21064a;     // Catch: Throwable -> L17
        if (r15 != null) goto L14;
    L15:
        ThreadContextKt.a(r14, r16);
        return;
    L14:
        if (r15.r0() == true) goto L15;
        return;
    L17:
        th = move-exception;
        if (r15 != null) goto L20;
    L21:
        ThreadContextKt.a(r14, r16);
    L22:
        throw th;
    L20:
        if (r15.r0() == false) goto L22;
        goto L21
    }

    public final boolean r0() {
        if (this.threadLocalIsSet == true) goto L5;
    L7:
        boolean r10 = false;
    L8:
        this.f21373e.remove();
        return !r10;
    L5:
        if (this.f21373e.get() != null) goto L7;
        r10 = true;
        goto L8
    }

    public final void s0(CoroutineContext r10, Object r11) {
        this.threadLocalIsSet = true;
        this.f21373e.set(kotlin.d.a(r10, r11));
    }
}
