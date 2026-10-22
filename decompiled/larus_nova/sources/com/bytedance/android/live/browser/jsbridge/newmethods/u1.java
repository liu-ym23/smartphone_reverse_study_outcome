package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.CheckAnchorEffectInUsedResultModel;
import com.bytedance.android.livesdkapi.eventbus.CheckAnchorStickerStatusEvent;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "checkAnchorEffectInUsed")
public final class u1 extends w20.r<w20.a8, CheckAnchorEffectInUsedResultModel> {
    public u1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.a8 r102 = (w20.a8) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.b();
        if (Intrinsics.areEqual(r103, com.bytedance.android.live.effect.api.d0.f66755e) == false) goto L5;
    L8:
        String r104 = com.bytedance.android.live.effect.api.d0.f66753c;
    L9:
        String r105 = "";
        if (r104 != null) goto L12;
        r104 = "";
    L12:
        xs2.b r106 = xs2.b.a();
        String r107 = r102.a();
        if (r107 == null) goto L16;
        r105 = r107;
    L16:
        r106.post(new CheckAnchorStickerStatusEvent(r105, r104, new t1(this)));
        return;
    L5:
        if (Intrinsics.areEqual(r103, com.bytedance.android.live.effect.api.d0.f66756f) == true) goto L8;
        r104 = r102.b();
        goto L9
    }
}
