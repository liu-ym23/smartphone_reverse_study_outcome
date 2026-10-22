package com.bytedance.android.livesdk.chatroom.vs.gesture;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import vr1.s;

/* JADX INFO: loaded from: classes8.dex */
public final class VSGestureViewManagerHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ko1.c f117687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static g f117688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Function0<Integer> f117689c;

    public static void b() {
        f117688b = null;
        f117687a = null;
        VSGestureViewManagerHelper$release$1 r100 = VSGestureViewManagerHelper$release$1.INSTANCE;
        VSGestureViewManagerHelper$release$2 r101 = VSGestureViewManagerHelper$release$2.INSTANCE;
    }

    static {
        VSGestureViewManagerHelper$resetButtonRightFunc$1 r100 = VSGestureViewManagerHelper$resetButtonRightFunc$1.INSTANCE;
        VSGestureViewManagerHelper$toolbarLeftFunc$1 r101 = VSGestureViewManagerHelper$toolbarLeftFunc$1.INSTANCE;
    }

    public static void c(Function0 r100) {
        if (r100 != null) goto L4;
        VSGestureViewManagerHelper$setResetButtonRightFun$1 r101 = VSGestureViewManagerHelper$setResetButtonRightFun$1.INSTANCE;
        return;
    L4:
        f117689c = r100;
    }

    public static ko1.c a(DataCenter r100, Context r101, View r102, ViewGroup r103, m r110) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "targetView");
        Intrinsics.checkNotNullParameter(r103, "viewGroup");
        if (f117687a != null) goto L11;
        f117688b = new g(r100, r102, r110);
        if (r.d().isSaas() == false) goto L7;
        ko1.c r104 = new VSGestureViewManagerHelper$createSaasGestureManager$1(r102, r103, r101, r102, r103);
    L8:
        f117687a = r104;
        if (r104 == null) goto L11;
        r104.a();
        goto L11
    L7:
        s r105 = r.p();
        g r111 = f117688b;
        Intrinsics.checkNotNull(r111);
        r104 = r105.g(r101, r102, r103, r111);
    L11:
        g r106 = f117688b;
        if (r106 == null) goto L15;
        r106.f117737d = 0L;
    L15:
        return f117687a;
    }
}
