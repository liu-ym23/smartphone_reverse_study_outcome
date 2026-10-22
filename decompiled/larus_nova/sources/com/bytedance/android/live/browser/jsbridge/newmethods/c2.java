package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "closeAnchorStatusCenterPanel")
public final class c2 extends w20.v<JsonObject, JsonObject> {
    public c2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        RoomContext r102 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r102 == null) goto L10;
        com.bytedance.live.datacontext.j<nz.f> r103 = r102.getAnchorStatusPanelViewModel();
        if (r103 == null) goto L11;
        nz.f r104 = r103.getValue();
        if (r104 == null) goto L12;
        r104.a();
        return;
    L12:
        return;
    L11:
        return;
    }
}
