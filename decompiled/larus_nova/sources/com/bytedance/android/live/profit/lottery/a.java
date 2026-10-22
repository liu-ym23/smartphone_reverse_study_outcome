package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.browser.jsbridge.base.DismissLotteryIconResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import w20.r8;

/* JADX INFO: loaded from: classes47.dex */
public final class a extends w20.l0<r8, DismissLotteryIconResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.live.datacontext.k<Object> f88037a;

    public a(com.bytedance.live.datacontext.k r100) {
        Intrinsics.checkNotNullParameter(r100, "onSubmit");
        this.f88037a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        r8 r102 = (r8) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f88037a.post(r102);
        finishWithSuccess();
    }
}
