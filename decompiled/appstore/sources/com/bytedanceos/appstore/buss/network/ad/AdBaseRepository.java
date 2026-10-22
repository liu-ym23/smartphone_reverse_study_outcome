package com.bytedanceos.appstore.buss.network.ad;

import com.bytedanceos.appstore.buss.utilities.o;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.d0;
import retrofit2.Response;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AdBaseRepository {
    public AdBaseRepository() {
    }

    public final Object a(Response r10, Continuation r11) {
        return d0.e(new AdBaseRepository$executeAdResponse$2(com.bytedanceos.appstore.buss.network.factory.a.f8808a.b(r10), null), r11);
    }

    public final Object b(Function1 r10, Continuation r11) {
        if ((r11 instanceof AdBaseRepository$safeCall$1) == false) goto L7;
        AdBaseRepository$safeCall$1 r12 = (AdBaseRepository$safeCall$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L17;
        if (r16 != 1) goto L16;
        kotlin.c.b(r14);     // Catch: Throwable -> L13
    L21:
        return (d) r14;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        kotlin.c.b(r14);
        r12.label = 1;     // Catch: Throwable -> L13
        r14 = r10.invoke(r12);     // Catch: Throwable -> L13
        if (r14 != r15) goto L21;
        return r15;
    L13:
        th = move-exception;
        return o.a(th);
    L7:
        r12 = new AdBaseRepository$safeCall$1(this, r11);
        goto L8
    }
}
