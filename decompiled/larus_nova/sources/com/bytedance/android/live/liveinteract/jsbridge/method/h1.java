package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.SendQuickInteractResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import w20.c6;
import w20.ie;

/* JADX INFO: loaded from: classes46.dex */
@XBridgeMethod(biz = "webcast", name = "sendQuickInteract")
public final class h1 extends c6<ie, SendQuickInteractResultModel> {
    public h1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        ie r102 = (ie) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        final SendQuickInteractResultModel r103 = new SendQuickInteractResultModel();
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.f79516r0.getClass();
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b r104 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C1237b.a();
        if (r104 == null) goto L17;
        String r105 = r102.c();
        if (r105 != null) goto L7;
        r105 = "";
    L7:
        String r106 = r102.a();
        if (r106 == null) goto L10;
        long r107 = CastLongProtector.parseLong(r106);
    L11:
        String r108 = r102.b();
        if (r108 != null) goto L14;
        String r109 = "";
    L15:
        String r110 = r105;
        r104.aj(r110, r107, r109, new SendQuickInteractMethod$invoke$1(this, r103));
        return;
    L14:
        r109 = r108;
        goto L15
    L10:
        r107 = 0;
        goto L11
    }
}
