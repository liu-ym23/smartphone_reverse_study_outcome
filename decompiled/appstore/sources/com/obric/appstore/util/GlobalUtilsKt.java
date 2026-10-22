package com.obric.appstore.util;

import android.os.SystemClock;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class GlobalUtilsKt {
    public static final Object a(long r10, Function0 r11, Continuation r12) {
        if ((r12 instanceof GlobalUtilsKt$delayExec$1) == false) goto L7;
        GlobalUtilsKt$delayExec$1 r13 = (GlobalUtilsKt$delayExec$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = kotlin.coroutines.intrinsics.a.d();
        int r17 = r13.label;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        Object r18 = r13.L$0;
        kotlin.c.b(r15);
    L21:
        return r18;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r15);
        long r19 = SystemClock.elapsedRealtime();
        Object r110 = r11.invoke();
        Pair r111 = new Pair(tf.a.d(SystemClock.elapsedRealtime() - r19), r110);
        long r20 = ((Number) r111.component1()).longValue();
        Object r112 = r111.component2();
        if (r20 >= r10) goto L22;
        r13.L$0 = r112;
        r13.label = 1;
        if (DelayKt.b(r10 - r20, r13) != r16) goto L19;
        return r16;
    L19:
        r18 = r112;
        goto L21
    L22:
        return r112;
    L7:
        r13 = new GlobalUtilsKt$delayExec$1(r12);
        goto L8
    }

    public static final int b(String r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return Integer.parseInt(r10);
    }

    public static /* synthetic */ int c(String r10, int r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        return b(r10, r11);
    }

    public static final long d(String r10, long r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        Result.a r12 = Result.Companion;     // Catch: Throwable -> L5
        Object r13 = Result.m35constructorimpl(Long.valueOf(Long.parseLong(r10)));     // Catch: Throwable -> L5
    L8:
        if (Result.m41isFailureimpl(r13) == false) goto L10;
        r13 = null;
    L10:
        Long r14 = (Long) r13;
        if (r14 != null) goto L13;
        return r11;
    L13:
        return r14.longValue();
    L5:
        th = move-exception;
        Result.a r15 = Result.Companion;
        r13 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L8
    }

    public static /* synthetic */ long e(String r10, long r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        return d(r10, r11);
    }
}
