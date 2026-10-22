package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.GetCurrentCameraIdResultModel;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getCurrentCameraId")
public final class c4 extends w20.f1<JsonObject, GetCurrentCameraIdResultModel> {
    public c4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Long r102 = null;
        long r103 = 0;
        RoomContext r104 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r104 == null) goto L9;
        com.bytedance.live.datacontext.m<Long> r105 = r104.getCameraId();
        if (r105 == null) goto L9;
        Long r106 = r105.getValue();
        if (r106 == null) goto L9;
        long r107 = r106.longValue();
    L11:
        if (r107 <= 0) goto L28;
        if (r104 == null) goto L16;
        com.bytedance.live.datacontext.m<Long> r108 = r104.getCameraId();
        if (r108 == null) goto L16;
        Long r109 = r108.getValue();
    L17:
        if (r104 == null) goto L25;
        com.bytedance.live.datacontext.m<Room> r110 = r104.getRoom();
        if (r110 == null) goto L25;
        Room r111 = r110.getValue();
        if (r111 == null) goto L25;
        EpisodeExtraInfo r112 = r111.getEpisodeComponentData();
        if (r112 == null) goto L25;
        r102 = Long.valueOf(r112.getDefaultCameraId());
    L25:
        boolean r113 = Intrinsics.areEqual(r109, r102);
        boolean r114 = true;
        if ((!r113) == false) goto L28;
    L29:
        if (r114 == false) goto L36;
        if (r104 == null) goto L36;
        com.bytedance.live.datacontext.m<Long> r115 = r104.getCameraId();
        if (r115 == null) goto L36;
        Long r116 = r115.getValue();
        if (r116 == null) goto L36;
        r103 = r116.longValue();
    L36:
        GetCurrentCameraIdResultModel r117 = new GetCurrentCameraIdResultModel();
        r117.a(GetCurrentCameraIdResultModel.Code.Success);
        GetCurrentCameraIdResultModel.a r118 = new GetCurrentCameraIdResultModel.a();
        r118.a(String.valueOf(r103));
        Unit r119 = Unit.INSTANCE;
        r117.b(r118);
        finishWithResult(r117);
        return;
    L16:
        r109 = null;
    L28:
        r114 = false;
    L9:
        r107 = 0;
        goto L11
    }
}
