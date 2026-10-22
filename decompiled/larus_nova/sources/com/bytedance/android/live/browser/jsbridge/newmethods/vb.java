package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "sendPublicScreenTextMessage")
public final class vb extends t<wb, SendPublicScreenTextMessageResultModel> {
    public vb() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        final wb r102 = (wb) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (com.bytedance.android.livesdk.interactivity.api.publicscreen.m.a(null) != null) goto L5;
        finishWithFailure();
    L5:
        com.bytedance.android.livesdk.chatroom.o r103 = com.bytedance.android.livesdk.chatroom.utils.o3.f();
        if (r103 == null) goto L10;
        Boolean r104 = r103.isMatchRoom();
        if (r104 == null) goto L10;
        final boolean r105 = r104.booleanValue();
    L11:
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.l> r106 = com.bytedance.android.livesdk.interactivity.api.publicscreen.m.a(null);
        if (r106 == null) goto L15;
        r106.c(new SendPublicScreenTextMessageMethod$invoke$1(this, r102, r105));
        return;
    L15:
        return;
    L10:
        r105 = false;
        goto L11
    }
}
