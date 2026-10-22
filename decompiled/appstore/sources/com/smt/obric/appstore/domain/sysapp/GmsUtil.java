package com.smt.obric.appstore.domain.sysapp;

import android.content.Context;
import java.util.Set;
import kotlin.collections.r0;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes4.dex */
public final class GmsUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final GmsUtil f18070a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f18071b = null;

    static {
        f18070a = new GmsUtil();
        f18071b = r0.i(new String[]{"com.lbt.gms", "com.android.vending"});
    }

    public GmsUtil() {
    }

    public final Object a(Context r10, Continuation r11) {
        if ((r11 instanceof GmsUtil$getGmsServiceEnabled$1) == false) goto L7;
        GmsUtil$getGmsServiceEnabled$1 r12 = (GmsUtil$getGmsServiceEnabled$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        boolean r17 = true;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        kotlin.c.b(r14);
    L18:
        if (((Number) r14).intValue() == 1) goto L22;
        r17 = false;
    L22:
        return tf.a.a(r17);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r14);
        CoroutineDispatcher r18 = l0.b();
        GmsUtil$getGmsServiceEnabled$2 r19 = new GmsUtil$getGmsServiceEnabled$2(r10, null);
        r12.label = 1;
        r14 = h.g(r18, r19, r12);
        if (r14 != r15) goto L18;
        return r15;
    L7:
        r12 = new GmsUtil$getGmsServiceEnabled$1(this, r11);
        goto L8
    }

    public final Set b() {
        return f18071b;
    }
}
