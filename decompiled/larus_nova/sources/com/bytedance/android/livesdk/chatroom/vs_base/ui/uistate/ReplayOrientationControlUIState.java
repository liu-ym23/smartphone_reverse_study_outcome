package com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate;

import android.content.Context;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.videoshop.context.VideoContext;
import io.reactivex.Observable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class ReplayOrientationControlUIState extends ir1.c {
    @Override // ir1.c
    public final void n() {
    }

    public ReplayOrientationControlUIState() {
    }

    public final void o(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = fr1.a.f478488a;
        if (l() == false) goto L5;
        int r102 = 1;
    L6:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        VideoContext r103 = VideoContext.n0(r100);
        if (r103 == null) goto L9;
        r103.H0(r102);
    L9:
        fr1.a.b(b(), r100, l());
        return;
    L5:
        r102 = e5.a();
        goto L6
    }

    public static void p(Context r100, Boolean r101, DataCenter r102, final Function1 r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 != null) goto L5;
        r101 = Boolean.valueOf(!VideoContext.n0(r100).s0());
    L5:
        int r104 = fr1.a.f478488a;
        fr1.a.a(!r101.booleanValue() ? 1 : 0, 1);
        if (r103 == null) goto L17;
        ReplayDataContext.Companion.getClass();
        ReplayDataContext r105 = ReplayDataContext.a.b(r102);
        if (r105 == null) goto L18;
        com.bytedance.live.datacontext.m<Boolean> r106 = r105.isPortrait();
        if (r106 == null) goto L19;
        Observable<Boolean> r107 = r106.a();
        if (r107 == null) goto L20;
        Observable<Boolean> r108 = r107.take(1);
        if (r108 == null) goto L21;
        RxUtilKt.n(r108, new ReplayOrientationControlUIState$onUserClick$1(r103));
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }
}
