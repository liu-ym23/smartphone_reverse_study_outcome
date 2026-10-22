package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.ShareItemResultModel;
import com.bytedance.android.livesdk.interactivity.api.ICommentService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import w20.re;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "shareItem")
public final class mc extends w20.j6<re, ShareItemResultModel> {
    public mc() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r110) {
        re r101 = (re) r100;
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r102 = r101.b();
        if (r102 != null) goto L5;
        String r103 = "";
    L6:
        String r104 = r101.c();
        if (r104 != null) goto L9;
        String r105 = "";
    L10:
        w22.a r111 = new w22.a(r103, r105, r101.a(), r101.d(), null, 16);
        ICommentService r106 = (ICommentService) jc1.k.f(ICommentService.class);
        if (r106 == null) goto L14;
        r106.startInteractivityShare(r111, new lc(this));
        return;
    L14:
        return;
    L9:
        r105 = r104;
        goto L10
    L5:
        r103 = r102;
        goto L6
    }
}
