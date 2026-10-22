package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.StreamBottomOffsetResultModel;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "streamBottomOffset")
public final class dd extends w20.v6<JsonObject, StreamBottomOffsetResultModel> {
    public dd() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        StreamBottomOffsetResultModel r102 = new StreamBottomOffsetResultModel();
        r102.a(StreamBottomOffsetResultModel.Code.Success);
        StreamBottomOffsetResultModel.a r103 = new StreamBottomOffsetResultModel.a();
        RoomContext.a r104 = RoomContext.Companion;
        Long r105 = null;
        RoomContext r106 = RoomContext.a.c(r104, null, 0, 3);
        if (r106 == null) goto L10;
        com.bytedance.live.datacontext.m<Long> r107 = r106.getVsHybridPanelFirstFrameHeight();
        if (r107 == null) goto L10;
        Long r108 = r107.getValue();
        if (r108 == null) goto L10;
        r105 = r108;
    L15:
        if (r105 != null) goto L18;
        r105 = 200L;
    L18:
        r103.a(r105);
        Unit r109 = Unit.INSTANCE;
        r102.b(r103);
        finishWithResult(r102);
        return;
    L10:
        RoomContext r110 = RoomContext.a.c(r104, null, 0, 3);
        if (r110 == null) goto L15;
        com.bytedance.live.datacontext.m<Long> r111 = r110.getVsHybridPanelHeight();
        if (r111 == null) goto L15;
        r105 = r111.getValue();
        goto L15
    }
}
