package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.SelectGiftDynamicCardResultModel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickLynxSeriesCard;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class pb extends w20.s5<w20.vd, SelectGiftDynamicCardResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.scope.j f63608a;

    public pb(com.bytedance.android.scope.j r100) {
        this.f63608a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.vd r102 = (w20.vd) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        JsonObject r103 = r102.a();
        if (r103 == null) goto L7;
        JsonElement r104 = r103.get("giftId");
        if (r104 == null) goto L7;
        long r105 = r104.getAsLong();
    L9:
        if (r105 > 0) goto L12;
        finishWithFailure(new Throwable("giftId is " + r105));
        return;
    L12:
        if (this.f63608a == null) goto L18;
        uz1.a r106 = com.bytedance.android.livesdk.gift.platform.core.utils.b0.a();
        if (r106 == null) goto L19;
        r106.a(new ClickLynxSeriesCard(r105));
        return;
    L19:
        return;
    L18:
        return;
    L7:
        r105 = -1;
        goto L9
    }
}
