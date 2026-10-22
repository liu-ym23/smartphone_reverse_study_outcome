package com.bytedance.android.livesdk.chatroom.room.backend;

import android.os.Bundle;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.room.api.messagewindow.service.IMiddlewareMsgWindowService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements is2.b {
    public b() {
    }

    @Override // is2.b
    public final /* synthetic */ boolean a() {
        return false;
    }

    @Override // is2.b
    public final /* synthetic */ boolean c() {
        return false;
    }

    @Override // is2.b
    public final void d() {
    }

    @Override // is2.b
    public final /* synthetic */ boolean f() {
        return false;
    }

    @Override // is2.b
    public final String getPath() {
        return "backend_cardinfo_request";
    }

    @Override // is2.b
    public final boolean enable() {
        a50.a r100 = LiveInfraSettingKeys.LIVE_ROOM_BACKEND_BUSINESS_SWITCH.getValue();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.b() != true) goto L7;
        return true;
    }

    @Override // is2.b
    public final Class<?> getModelClass() {
        return ((IMiddlewareMsgWindowService) jc1.k.n(IMiddlewareMsgWindowService.class)).getBackendModelClass();
    }

    @Override // is2.b
    public final JSONObject g(Bundle r100, is2.a r101) {
        JSONObject r102 = new JSONObject();
        BaseMonitor.add(r102, "open", true);
        BaseMonitor.add(r102, "biz_data_type", 1);
        BaseMonitor.add(r102, "action_source", 1);
        JSONObject r103 = new JSONObject();
        if (r100 == null) goto L7;
        String r104 = r100.getString(ILiveRoomPlayFragmentConstant.EXTRA_REQUEST_ID);
        if (r104 == null) goto L7;
        r103.put("request_id", r104);
    L7:
        BaseMonitor.add(r102, "enter_schema_params", r103.toString());
        return r102;
    }
}
