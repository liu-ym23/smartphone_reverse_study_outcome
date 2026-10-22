package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.OpenLiveMicroAppResultModel;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openLiveMicroApp")
public final class v8 extends w20.m4<w20.lc, OpenLiveMicroAppResultModel> {
    public v8() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.lc r102 = (w20.lc) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        RoomContext r103 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r103 == null) goto L9;
        com.bytedance.live.datacontext.i<Boolean> r104 = r103.isAnchor();
        if (r104 == null) goto L9;
        Boolean r105 = r104.getValue();
        if (r105 == null) goto L9;
        boolean r106 = r105.booleanValue();
    L10:
        String r107 = "";
        if (r106 == false) goto L17;
        IOpenPlatformAnchorService r108 = (IOpenPlatformAnchorService) jc1.k.n(IOpenPlatformAnchorService.class);
        String r109 = r102.b();
        if (r109 == null) goto L16;
        r107 = r109;
    L16:
        r108.openLiveMicroApp(r107, r102.a());
    L22:
        finishWithSuccess();
        return;
    L17:
        IOpenPlatformAudienceService r110 = (IOpenPlatformAudienceService) jc1.k.n(IOpenPlatformAudienceService.class);
        String r111 = r102.b();
        if (r111 == null) goto L21;
        r107 = r111;
    L21:
        r110.openLiveMicroApp(r107, r102.a());
    L9:
        r106 = true;
        goto L10
    }
}
