package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.SendGiftPlayerEventResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import w20.de;
import w20.x5;

/* JADX INFO: loaded from: classes46.dex */
public final class i0 extends x5<de, SendGiftPlayerEventResultModel> {
    public i0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        de r102 = (de) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.getType();
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        JsonObject r104 = r102.a();
        ALogger.i("MultiLinkSendGiftPlayerEventMethod", "sendGiftPlayerEvent: " + r103 + ", " + r104);
        com.bytedance.android.live.liveinteract.animation.universalwidget.a.f71316f0.getClass();
        com.bytedance.android.live.liveinteract.animation.universalwidget.a r105 = com.bytedance.android.live.liveinteract.animation.universalwidget.a.C1150a.a();
        if (r104 == null) goto L9;
        if (r105 == null) goto L9;
        r105.Le(r103, r104, new h0(this));
        return;
    L9:
        finishWithFailure();
    }
}
