package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.OpenMultiPosterSharePanelResultModel;
import com.bytedance.android.live.room.api.IMatchShareService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openMultiPosterSharePanel")
public final class h9 extends w20.n4<w20.mc, OpenMultiPosterSharePanelResultModel> {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public h9() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.mc r102 = (w20.mc) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        List<String> r103 = r102.d();
        if (r103 == null) goto L18;
        IMatchShareService r104 = (IMatchShareService) jc1.k.f(IMatchShareService.class);
        if (r104 == null) goto L18;
        Boolean r105 = r102.a();
        if (r105 == null) goto L9;
        boolean r106 = r105.booleanValue();
    L10:
        List<String> r107 = CollectionsKt.toMutableList(r103);
        String r108 = r102.b();
        String r109 = "";
        if (r108 != null) goto L13;
        r108 = "";
    L13:
        String r110 = r102.c();
        if (r110 == null) goto L17;
        r109 = r110;
    L17:
        r104.launchVsMultiPosterShare(r106, r107, r108, r109);
        goto L18
    L9:
        r106 = false;
    L18:
        finishWithSuccess();
    }
}
