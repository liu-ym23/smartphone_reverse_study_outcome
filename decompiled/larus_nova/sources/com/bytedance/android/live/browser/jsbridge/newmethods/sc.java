package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.browser.jsbridge.base.ShowAnchorColumnPosterDialogResultModel;
import com.bytedance.android.livesdk.config.setting.NewBroadcastSharedConfig;
import com.bytedance.android.livesdkapi.model.AnchorColumnPosterInfo;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import w20.ve;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "showAnchorColumnPosterDialog")
public final class sc extends w20.n6<ve, ShowAnchorColumnPosterDialogResultModel> {
    public sc() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        ve r112 = (ve) r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r100 = r112.c();
        if (r100 != null) goto L5;
        String r101 = "";
    L6:
        String r102 = r112.b();
        if (r102 != null) goto L9;
        String r103 = "";
    L10:
        String r104 = r112.a();
        if (r104 != null) goto L13;
        String r105 = "";
    L14:
        String r106 = r112.g();
        if (r106 != null) goto L17;
        String r107 = "";
    L18:
        String r108 = r112.f();
        if (r108 != null) goto L21;
        String r109 = "";
    L22:
        String r113 = r112.e();
        if (r113 != null) goto L25;
        String r114 = "";
    L26:
        String r115 = r112.d();
        if (r115 != null) goto L29;
        r115 = "";
    L29:
        AnchorColumnPosterInfo r116 = new AnchorColumnPosterInfo(r101, r103, r105, r107, r109, r114, r115);
        if (NewBroadcastSharedConfig.a().booleanValue() == false) goto L34;
        f00.a.C5839a r117 = f00.a.f474945b;
        g00.c r118 = (g00.c) com.bytedance.android.scope.m.f163449e.d(r117, g00.c.class);
        if (r118 == null) goto L35;
        r118.openPosterGenerateDialog(r111.getContext(), r116);
    L35:
        finishWithSuccess();
        return;
    L34:
        ((IBroadcastService) va1.b.a.f553922a.a(IBroadcastService.class)).openPosterGenerateDialog(r111.getContext(), r116);
        goto L35
    L25:
        r114 = r113;
        goto L26
    L21:
        r109 = r108;
        goto L22
    L17:
        r107 = r106;
        goto L18
    L13:
        r105 = r104;
        goto L14
    L9:
        r103 = r102;
        goto L10
    L5:
        r101 = r100;
        goto L6
    }
}
