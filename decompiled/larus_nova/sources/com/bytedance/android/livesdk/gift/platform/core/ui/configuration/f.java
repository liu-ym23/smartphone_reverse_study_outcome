package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import com.bytedance.android.live.browser.jsbridge.base.RevenueRequestStickerEffectStatusResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import w20.o5;

/* JADX INFO: loaded from: classes9.dex */
public final class f extends o5<JsonObject, RevenueRequestStickerEffectStatusResultModel> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public f() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        final GiftEffectCloseRequestMethod$invoke$1 r102 = new GiftEffectCloseRequestMethod$invoke$1(this);
        final GiftEffectCloseRequestMethod$invoke$2 r103 = new GiftEffectCloseRequestMethod$invoke$2(this);
        i12.e r104 = i12.o.b();
        if (r104 == null) goto L5;
        Object r105 = com.bytedance.android.scope.m.f163449e.d(r104, d.class);
    L6:
        d r106 = (d) r105;
        if (r106 == null) goto L10;
        d.a(r106, new GiftEffectCloseRequestMethod$invoke$3(r102), new GiftEffectCloseRequestMethod$invoke$4(r103), null, 4);
        return;
    L10:
        return;
    L5:
        r105 = null;
        goto L6
    }
}
