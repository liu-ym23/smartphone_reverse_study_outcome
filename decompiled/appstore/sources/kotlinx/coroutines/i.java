package kotlinx.coroutines;

import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class i {
    public static final Object a(CoroutineContext r10, Function2 r11) {
        Thread r12 = Thread.currentThread();
        ContinuationInterceptor r13 = (ContinuationInterceptor) r10.get(ContinuationInterceptor.Key);
        if (r13 != null) goto L5;
        q0 r14 = z1.f21774a.b();
        CoroutineContext r15 = CoroutineContextKt.e(y0.f21772a, r10.plus(r14));
    L18:
        f r16 = new f(r15, r12, r14);
        r16.q0(CoroutineStart.DEFAULT, r16, r11);
        return r16.r0();
    L5:
        q0 r17 = null;
        if ((r13 instanceof q0) == false) goto L8;
        q0 r18 = (q0) r13;
    L9:
        if (r18 != null) goto L11;
    L16:
        r14 = z1.f21774a.a();
    L17:
        r15 = CoroutineContextKt.e(y0.f21772a, r10);
        goto L18
    L11:
        if (r18.p() == false) goto L13;
        r17 = r18;
    L13:
        if (r17 == null) goto L16;
        r14 = r17;
        goto L17
    L8:
        r18 = null;
        goto L9
    }

    public static /* synthetic */ Object b(CoroutineContext r10, Function2 r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = EmptyCoroutineContext.INSTANCE;
    L6:
        return h.e(r10, r11);
    }
}
