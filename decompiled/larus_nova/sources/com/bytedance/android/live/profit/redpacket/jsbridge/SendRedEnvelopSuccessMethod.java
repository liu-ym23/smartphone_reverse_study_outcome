package com.bytedance.android.live.profit.redpacket.jsbridge;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.g;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import jc1.k;

/* JADX INFO: loaded from: classes47.dex */
@XBridgeMethod(biz = "webcast", name = "sendRedEnvelopSuccess")
public class SendRedEnvelopSuccessMethod extends g<Params, Object> {
    private static final String TAG = "SendRedEnvelopSuccessMe";

    public static final class Params {

        @SerializedName("delay_time")
        String delayTime;

        @SerializedName("envelope_diamond")
        String envelopeDiamond;

        @SerializedName("envelope_id")
        String envelopeId;

        @SerializedName("envelope_type")
        String envelopeType;

        @SerializedName("left_diamond")
        String leftDiamond;

        public Params() {
        }
    }

    public SendRedEnvelopSuccessMethod() {
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public Object invoke2(Params r100, CallContext r101) throws Exception {
        ((IRechargeService) k.f(IRechargeService.class)).rechargeCenter().setAvailableDiamonds(CastIntegerProtector.parseInt(r100.leftDiamond));     // Catch: Exception -> L4
    L6:
        ((com.bytedance.android.livesdk.revenue.service.user.a) com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.user.a.class)).markAsOutOfDate(true);
        return null;
    L4:
        e = move-exception;
        ALogger.e(TAG, e);
        goto L6
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public /* bridge */ /* synthetic */ Object invoke(Params r100, CallContext r101) throws Exception {
        return invoke2(r100, r101);
    }
}
