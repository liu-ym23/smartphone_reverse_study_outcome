package com.bytedanceos.appstore.buss.network.cms;

import com.bytedanceos.appstore.buss.network.factory.a;
import com.bytedanceos.appstore.buss.network.g;
import com.bytedanceos.appstore.buss.utilities.o;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.d0;
import retrofit2.Response;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CmsBaseRepository {
    public CmsBaseRepository() {
    }

    public static /* synthetic */ Object b(CmsBaseRepository r10, Response r11, Function3 r12, Function3 r13, Continuation r14, int r15, Object r16) {
        if (r16 != null) goto L12;
        if ((r15 & 2) == 0) goto L7;
        r12 = null;
    L7:
        if ((r15 & 4) == 0) goto L10;
        r13 = null;
    L10:
        return r10.a(r11, r12, r13, r14);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: executeCmsResponse");
    }

    public final Object a(Response r10, Function3 r11, Function3 r12, Continuation r13) {
        return d0.e(new CmsBaseRepository$executeCmsResponse$2(a.f8808a.d(r10), r11, r12, null), r13);
    }

    public final Object c(Function1 r10, Continuation r11) {
        if ((r11 instanceof CmsBaseRepository$safeCall$1) == false) goto L7;
        CmsBaseRepository$safeCall$1 r12 = (CmsBaseRepository$safeCall$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L17;
        if (r16 != 1) goto L16;
        c.b(r14);     // Catch: Throwable -> L13
    L21:
        return (g) r14;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        c.b(r14);
        r12.label = 1;     // Catch: Throwable -> L13
        r14 = r10.invoke(r12);     // Catch: Throwable -> L13
        if (r14 != r15) goto L21;
        return r15;
    L13:
        th = move-exception;
        return o.b(th);
    L7:
        r12 = new CmsBaseRepository$safeCall$1(this, r11);
        goto L8
    }
}
