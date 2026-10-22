package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.d2;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.z1;

/* JADX INFO: loaded from: classes4.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f21600a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b0 f21601b = null;

    static {
        f21600a = new b0("UNDEFINED");
        f21601b = new b0("REUSABLE_CLAIMED");
    }

    public static final /* synthetic */ b0 a() {
        return f21600a;
    }

    public static final void b(Continuation r10, Object r11, Function1 r12) {
        if ((r10 instanceof i) == false) goto L42;
        i r13 = (i) r10;
        Object r14 = kotlinx.coroutines.z.b(r11, r12);
        if (r13.f21594d.c(r13.getContext()) == false) goto L7;
        r13.f21596f = r14;
        r13.f21631c = 1;
        r13.f21594d.a(r13.getContext(), r13);
        return;
    L7:
        q0 r15 = z1.f21774a.b();
        if (r15.l() == false) goto L10;
        r13.f21596f = r14;
        r13.f21631c = 1;
        r15.h(r13);
        return;
    L10:
        r15.j(true);
        Job r16 = (Job) r13.getContext().get(Job.Key);     // Catch: Throwable -> L16
        if (r16 != null) goto L14;
    L18:
        Continuation r17 = r13.f21595e;     // Catch: Throwable -> L16
        Object r18 = r13.f21597g;     // Catch: Throwable -> L16
        CoroutineContext r19 = r17.getContext();     // Catch: Throwable -> L16
        Object r20 = ThreadContextKt.c(r19, r18);     // Catch: Throwable -> L16
        if (r20 == ThreadContextKt.f21572a) goto L22;
        d2 r21 = CoroutineContextKt.g(r17, r19, r20);     // Catch: Throwable -> L16
    L45:
        r13.f21595e.resumeWith(r11);     // Catch: Throwable -> L31
        Unit r22 = Unit.f21064a;     // Catch: Throwable -> L31
        if (r21 != null) goto L26;
    L27:
        ThreadContextKt.a(r19, r20);     // Catch: Throwable -> L16
    L29:
        if (r15.o() == true) goto L29;
    L30:
        r15.e(true);
        return;
    L26:
        if (r21.r0() == false) goto L29;
    L31:
        th = move-exception;
        if (r21 != null) goto L34;
    L35:
        ThreadContextKt.a(r19, r20);     // Catch: Throwable -> L16
    L36:
        throw th;     // Catch: Throwable -> L16
    L34:
        if (r21.r0() == false) goto L36;
    L22:
        r21 = null;
        goto L45
    L14:
        if (r16.isActive() == true) goto L18;
        CancellationException r23 = r16.getCancellationException();     // Catch: Throwable -> L16
        r13.a(r14, r23);     // Catch: Throwable -> L16
        Result.a r24 = Result.Companion;     // Catch: Throwable -> L16
        r13.resumeWith(Result.m35constructorimpl(kotlin.c.a(r23)));     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r13.e(th, null);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        r15.e(true);
        throw th;
    L42:
        r10.resumeWith(r11);
    }

    public static /* synthetic */ void c(Continuation r10, Object r11, Function1 r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = null;
    L5:
        b(r10, r11, r12);
    }

    public static final boolean d(i r10) {
        Unit r11 = Unit.f21064a;
        q0 r12 = z1.f21774a.b();
        if (r12.m() == false) goto L6;
        return false;
    L6:
        if (r12.l() == false) goto L8;
        r10.f21596f = r11;
        r10.f21631c = 1;
        r12.h(r10);
        return true;
    L8:
        r12.j(true);
        r10.run();     // Catch: Throwable -> L13
    L10:
        if (r12.o() == true) goto L10;
    L12:
        r12.e(true);
        return false;
    L13:
        th = move-exception;
        r10.e(th, null);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r12.e(true);
        throw th;
    }
}
