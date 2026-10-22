package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class j {
    public static final Deferred a(CoroutineScope r10, CoroutineContext r11, CoroutineStart r12, Function2 r13) {
        CoroutineContext r14 = CoroutineContextKt.e(r10, r11);
        if (r12.isLazy() == false) goto L5;
        h0 r15 = new m1(r14, r13);
    L6:
        r15.q0(r12, r15, r13);
        return r15;
    L5:
        r15 = new h0(r14, true);
        goto L6
    }

    public static /* synthetic */ Deferred b(CoroutineScope r10, CoroutineContext r11, CoroutineStart r12, Function2 r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = EmptyCoroutineContext.INSTANCE;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = CoroutineStart.DEFAULT;
    L9:
        return h.a(r10, r11, r12, r13);
    }

    public static final Job c(CoroutineScope r10, CoroutineContext r11, CoroutineStart r12, Function2 r13) {
        CoroutineContext r14 = CoroutineContextKt.e(r10, r11);
        if (r12.isLazy() == false) goto L5;
        a r15 = new n1(r14, r13);
    L6:
        r15.q0(r12, r15, r13);
        return r15;
    L5:
        r15 = new v1(r14, true);
        goto L6
    }

    public static /* synthetic */ Job d(CoroutineScope r10, CoroutineContext r11, CoroutineStart r12, Function2 r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = EmptyCoroutineContext.INSTANCE;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = CoroutineStart.DEFAULT;
    L9:
        return h.c(r10, r11, r12, r13);
    }

    public static final Object e(CoroutineContext r10, Function2 r11, Continuation r12) {
        CoroutineContext r13 = r12.getContext();
        CoroutineContext r14 = CoroutineContextKt.d(r13, r10);
        h1.h(r14);
        if (r14 != r13) goto L5;
        kotlinx.coroutines.internal.x r15 = new kotlinx.coroutines.internal.x(r14, r12);
        Object r16 = cg.b.c(r15, r15, r11);
    L15:
        if (r16 != kotlin.coroutines.intrinsics.a.d()) goto L17;
        tf.d.c(r12);
    L17:
        return r16;
    L5:
        ContinuationInterceptor.b r17 = ContinuationInterceptor.Key;
        if (kotlin.jvm.internal.q.b(r14.get(r17), r13.get(r17)) == false) goto L13;
        d2 r18 = new d2(r14, r12);
        CoroutineContext r19 = r18.getContext();
        Object r20 = ThreadContextKt.c(r19, null);
        Object r21 = cg.b.c(r18, r18, r11);     // Catch: Throwable -> L10
        ThreadContextKt.a(r19, r20);
        r16 = r21;
    L10:
        th = move-exception;
        ThreadContextKt.a(r19, r20);
        throw th;
    L13:
        i0 r22 = new i0(r14, r12);
        cg.a.e(r11, r22, r22, null, 4, null);
        r16 = r22.r0();
        goto L15
    }
}
