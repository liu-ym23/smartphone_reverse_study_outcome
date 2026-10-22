package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.scheduling.TaskContext;

/* JADX INFO: loaded from: classes4.dex */
public abstract class j0 extends dg.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21631c;

    public j0(int r10) {
        this.f21631c = r10;
    }

    public abstract void a(Object r10, Throwable r11);

    public abstract Continuation b();

    public Throwable c(Object r10) {
        if ((r10 instanceof w) == false) goto L5;
        w r11 = (w) r10;
    L6:
        if (r11 != null) goto L8;
        return null;
    L8:
        return r11.f21768a;
    L5:
        r11 = null;
        goto L6
    }

    public Object d(Object r10) {
        return r10;
    }

    public final void e(Throwable r10, Throwable r11) {
        if (r10 != null) goto L5;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r10 == null) goto L8;
        if (r11 == null) goto L8;
        kotlin.a.a(r10, r11);
    L8:
        if (r10 != null) goto L10;
        r10 = r11;
    L10:
        kotlin.jvm.internal.q.d(r10);
        a0.a(b().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", r10));
    }

    public abstract Object f();

    @Override // java.lang.Runnable
    public final void run() {
        TaskContext r10 = this.f19208b;
        Continuation r11 = b();     // Catch: Throwable -> L7
        kotlin.jvm.internal.q.e(r11, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");     // Catch: Throwable -> L7
        kotlinx.coroutines.internal.i r12 = (kotlinx.coroutines.internal.i) r11;     // Catch: Throwable -> L7
        Continuation r13 = r12.f21595e;     // Catch: Throwable -> L7
        Object r14 = r12.f21597g;     // Catch: Throwable -> L7
        CoroutineContext r15 = r13.getContext();     // Catch: Throwable -> L7
        Object r16 = ThreadContextKt.c(r15, r14);     // Catch: Throwable -> L7
        if (r16 == ThreadContextKt.f21572a) goto L9;
        d2 r17 = CoroutineContextKt.g(r13, r15, r16);     // Catch: Throwable -> L7
    L49:
        CoroutineContext r18 = r13.getContext();     // Catch: Throwable -> L15
        Object r19 = f();     // Catch: Throwable -> L15
        Throwable r20 = c(r19);     // Catch: Throwable -> L15
        if (r20 == null) goto L13;
    L17:
        Job r21 = null;
    L18:
        if (r21 != null) goto L20;
    L22:
        if (r20 == null) goto L24;
        Result.a r22 = Result.Companion;     // Catch: Throwable -> L15
        r13.resumeWith(Result.m35constructorimpl(kotlin.c.a(r20)));     // Catch: Throwable -> L15
    L25:
        Unit r23 = Unit.f21064a;     // Catch: Throwable -> L15
        if (r17 != null) goto L28;
    L29:
        ThreadContextKt.a(r15, r16);     // Catch: Throwable -> L7
    L51:
        r10.afterTask();     // Catch: Throwable -> L32
        Object r24 = Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L32
    L34:
        e(null, Result.m38exceptionOrNullimpl(r24));
        return;
    L32:
        th = move-exception;
        Result.a r25 = Result.Companion;
        r24 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L34
    L28:
        if (r17.r0() == false) goto L51;
    L24:
        Result.a r26 = Result.Companion;     // Catch: Throwable -> L15
        r13.resumeWith(Result.m35constructorimpl(d(r19)));     // Catch: Throwable -> L15
        goto L25
    L20:
        if (r21.isActive() == true) goto L22;
        CancellationException r27 = r21.getCancellationException();     // Catch: Throwable -> L15
        a(r19, r27);     // Catch: Throwable -> L15
        Result.a r28 = Result.Companion;     // Catch: Throwable -> L15
        r13.resumeWith(Result.m35constructorimpl(kotlin.c.a(r27)));     // Catch: Throwable -> L15
        goto L25
    L13:
        if (k0.b(this.f21631c) == false) goto L17;
        r21 = (Job) r18.get(Job.Key);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        if (r17 != null) goto L37;
    L38:
        ThreadContextKt.a(r15, r16);     // Catch: Throwable -> L7
    L39:
        throw th;     // Catch: Throwable -> L7
    L37:
        if (r17.r0() == false) goto L39;
    L9:
        r17 = null;
    L7:
        th = move-exception;
        Result.a r29 = Result.Companion;     // Catch: Throwable -> L42
        r10.afterTask();     // Catch: Throwable -> L42
        Object r30 = Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L42
    L44:
        e(th, Result.m38exceptionOrNullimpl(r30));
        return;
    L42:
        th = move-exception;
        Result.a r31 = Result.Companion;
        r30 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L44
    }
}
