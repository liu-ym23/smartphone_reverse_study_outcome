package com.android.ttcjpaysdk.ttcjpayapi;

import android.app.Activity;
import android.content.Intent;
import com.bytedance.caijing.sdk.infra.base.api.plugin.PlugInWXPayService;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import ve4.a;

/* JADX INFO: loaded from: classes39.dex */
public class TTCJPayWXUtils {
    public TTCJPayWXUtils() {
    }

    public static boolean isFromTTCJPay() {
        a.f554342a.getClass();
        return ((PlugInWXPayService) a.a(PlugInWXPayService.class)).isFromCJPay();
    }

    public static void handleIntent(Intent r100, IWXAPIEventHandler r101) {
        a.f554342a.getClass();
        Object r102 = ((PlugInWXPayService) a.a(PlugInWXPayService.class)).getCurrentSessionApi();
        if ((r102 instanceof IWXAPI) == false) goto L6;
        ((IWXAPI) r102).handleIntent(r100, r101);
        return;
    }

    public static void handleResp(Activity r100, BaseResp r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r101.getType() != 5) goto L12;
        a.f554342a.getClass();
        PlugInWXPayService r102 = (PlugInWXPayService) a.a(PlugInWXPayService.class);
        Object r103 = r102.currentSession();
        if ((r101 instanceof PayResp) == false) goto L9;
        r103 = r102.getWxSession(((PayResp) r101).prepayId);
    L9:
        if (r103 == null) goto L13;
        r102.notifyResult(r103, String.valueOf(r101.errCode));
        return;
    L13:
        return;
    }
}
