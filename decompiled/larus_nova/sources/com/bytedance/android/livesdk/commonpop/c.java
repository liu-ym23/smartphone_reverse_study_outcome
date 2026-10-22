package com.bytedance.android.livesdk.commonpop;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c extends com.bytedance.ies.web.jsbridge2.g<Object, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonPopupMessageWidget f119725a;

    public c(CommonPopupMessageWidget r100) {
        this.f119725a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        CommonPopupMessageWidget r102 = this.f119725a;
        int r103 = CommonPopupMessageWidget.f119708g;
        r102.wq();
        return null;
    }
}
