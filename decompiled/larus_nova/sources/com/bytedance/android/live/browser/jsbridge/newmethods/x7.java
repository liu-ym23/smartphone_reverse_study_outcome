package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.LiveUpdateNotifyGiftMessageChannelResultModel;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.updateNotifyGiftMessageChannel")
public final class x7 extends w20.s3<w20.mb, LiveUpdateNotifyGiftMessageChannelResultModel> {
    public x7() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.mb r102 = (w20.mb) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Boolean r103 = r102.a();
        if (r103 == null) goto L5;
        boolean r104 = r103.booleanValue();
    L6:
        RoomContext r105 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r105 == null) goto L11;
        com.bytedance.live.datacontext.m<Boolean> r106 = r105.getGiftMessageChannelStatus();
        if (r106 == null) goto L11;
        r106.setValue(Boolean.valueOf(r104));
    L11:
        finishWithSuccess();
        return;
    L5:
        r104 = false;
        goto L6
    }
}
