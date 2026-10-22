package com.obric.appstore.buss.repo;

import com.bytedanceos.common.toolbox.j;
import com.obric.appstore.network.c;
import com.obric.appstore.network.g;
import com.obric.appstore.util.t;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.d0;
import retrofit2.Response;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseRepository {
    public BaseRepository() {
    }

    public final Object a(Response r10, Continuation r11) {
        j.a("BaseRepository executeAssistantResponse createAssistant start");
        return d0.e(new BaseRepository$executeResponse$2(c.f10963a.a(r10), null), r11);
    }

    public final Object b(Function1 r10, Continuation r11) {
        if ((r11 instanceof BaseRepository$safeCall$1) == false) goto L7;
        BaseRepository$safeCall$1 r12 = (BaseRepository$safeCall$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L17;
        if (r16 != 1) goto L16;
        kotlin.c.b(r14);     // Catch: Throwable -> L13
    L21:
        return (g) r14;
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
        return t.a(th);
    L7:
        r12 = new BaseRepository$safeCall$1(this, r11);
        goto L8
    }

    public final Object c(Function2 r10, Continuation r11) {
        if ((r11 instanceof BaseRepository$safeCallWithCache$1) == false) goto L7;
        BaseRepository$safeCallWithCache$1 r12 = (BaseRepository$safeCallWithCache$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L20;
        if (r16 == 1) goto L15;
        if (r16 != 2) goto L14;
        kotlin.c.b(r14);
    L29:
        return r14;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r10 = (Function2) r12.L$1;
        BaseRepository this = (BaseRepository) r12.L$0;
        kotlin.c.b(r14);     // Catch: Throwable -> L18
    L24:
        return (g) r14;
    L20:
        kotlin.c.b(r14);
        Boolean r17 = tf.a.a(false);     // Catch: Throwable -> L18
        r12.L$0 = this;     // Catch: Throwable -> L18
        r12.L$1 = r10;     // Catch: Throwable -> L18
        r12.label = 1;     // Catch: Throwable -> L18
        r14 = r10.mo0invoke(r17, r12);     // Catch: Throwable -> L18
        if (r14 != r15) goto L24;
        return r15;
    L18:
        th = move-exception;
        j.b("safeCallWithCache " + kotlin.a.b(th));
        BaseRepository$safeCallWithCache$2 r18 = new BaseRepository$safeCallWithCache$2(r10, null);
        r12.L$0 = null;
        r12.L$1 = null;
        r12.label = 2;
        r14 = this.b(r18, r12);
        if (r14 != r15) goto L29;
        return r15;
    L7:
        r12 = new BaseRepository$safeCallWithCache$1(this, r11);
        goto L8
    }
}
