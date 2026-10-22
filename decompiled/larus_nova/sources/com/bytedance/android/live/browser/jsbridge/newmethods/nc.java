package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.browser.jsbridge.base.ShareTicketResultModel;
import com.bytedance.android.live.room.api.IMatchShareService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import w20.te;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "shareTicket")
public final class nc extends w20.l6<te, ShareTicketResultModel> {

    public static final class a {
    }

    static {
    }

    public nc() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        te r102 = (te) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Context r103 = r101.getContext();
        if ((r103 instanceof Activity) == true) goto L5;
        r103 = null;
    L5:
        Activity r104 = (Activity) r103;
        if (r104 == null) goto L24;
        IMatchShareService r105 = (IMatchShareService) jc1.k.f(IMatchShareService.class);
        if (r105 == null) goto L24;
        Boolean r106 = r102.c();
        if (r106 == null) goto L12;
        boolean r107 = r106.booleanValue();
    L13:
        String r108 = r102.a();
        if (r108 != null) goto L16;
        r108 = "";
    L16:
        String r109 = r102.d();
        if (r109 != null) goto L19;
        r109 = "";
    L19:
        String r110 = r102.b();
        if (r110 != null) goto L22;
        String r111 = "";
    L23:
        r105.launchMatchTicketShare(r104, r107, r108, r109, r111);
        goto L24
    L22:
        r111 = r110;
        goto L23
    L12:
        r107 = false;
    L24:
        finishWithSuccess();
    }
}
