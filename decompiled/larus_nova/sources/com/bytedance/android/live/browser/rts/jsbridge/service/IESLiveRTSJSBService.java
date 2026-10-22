package com.bytedance.android.live.browser.rts.jsbridge.service;

import android.content.Context;
import com.bytedance.android.live.browser.rts.jsbridge.api.IIESLiveRTSJSBService;
import com.ss.android.lark.utils.statistics.PerfLog;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/browser/rts/jsbridge/service/IESLiveRTSJSBService;", "Lcom/bytedance/android/live/browser/rts/jsbridge/service/IIESLiveRTSJSBServiceInner;", "()V", "getJsbHybridServiceInstance", "Lcom/bytedance/android/live/browser/rts/jsbridge/api/IIESLiveRTSJSBService;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class IESLiveRTSJSBService extends IIESLiveRTSJSBServiceInner {
    /* JADX WARN: Multi-variable type inference failed */
    public IESLiveRTSJSBService() {
        super(null, 1, 0 == true ? 1 : 0);
        k.l(IIESLiveRTSJSBService.class, this);
    }

    @Override // com.bytedance.android.live.browser.rts.jsbridge.service.IIESLiveRTSJSBServiceInner
    public IIESLiveRTSJSBService getJsbHybridServiceInstance(Object r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((r100 instanceof Context) == true) goto L6;
        r100 = null;
    L6:
        return new IIESLiveRTSJSBServiceInner((Context) r100);
    }
}
