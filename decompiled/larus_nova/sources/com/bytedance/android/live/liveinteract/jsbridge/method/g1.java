package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.SendJoinMatrixInvitationResultModel;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import w20.fe;
import w20.z5;

/* JADX INFO: loaded from: classes46.dex */
@XBridgeMethod(biz = "webcast", name = "sendJoinMatrixInvitation")
public final class g1 extends z5<fe, SendJoinMatrixInvitationResultModel> {
    public g1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        fe r102 = (fe) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.c();
        String r104 = "";
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        String r105 = r102.a();
        if (r105 != null) goto L8;
        r105 = "";
    L8:
        String r106 = r102.b();
        if (r106 == null) goto L12;
        r104 = r106;
    L12:
        ((IMiddlewareHostAction) jc1.k.n(IMiddlewareHostAction.class)).sendLiveMatrixInvitation(r103, r104, r105, new f1(this));
    }
}
