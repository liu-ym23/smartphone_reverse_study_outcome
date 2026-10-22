package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;", "", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;)Z", "isActiveMatchingOrder", "foundation_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.z, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3328z {
    public static final boolean a(DidiCardModel didiCardModel) {
        kotlin.jvm.internal.p.i(didiCardModel, "<this>");
        if (didiCardModel.getStatus() != 2 || !didiCardModel.getActiveMatching()) {
            return false;
        }
        String orderNo = didiCardModel.getOrderNo();
        if (orderNo != null && !La.H.x0(orderNo)) {
            return true;
        }
        String platformOrderId = didiCardModel.getPlatformOrderId();
        return (platformOrderId == null || La.H.x0(platformOrderId)) ? false : true;
    }
}
