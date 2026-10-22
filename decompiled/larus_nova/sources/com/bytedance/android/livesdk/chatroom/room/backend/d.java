package com.bytedance.android.livesdk.chatroom.room.backend;

import android.os.Bundle;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements is2.b {
    @Override // is2.b
    public final /* synthetic */ boolean a() {
        return false;
    }

    @Override // is2.b
    public final boolean c() {
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
        return "backend_room_strategy_request";
    }

    @Override // is2.b
    public final boolean enable() {
        return LiveInfraSettingKeys.LIVE_ROOM_BACKEND_BUSINESS_SWITCH.getValue().k();
    }

    public d() {
    }

    @Override // is2.b
    public final Class<?> getModelClass() {
        return com.bytedance.android.livesdk.dynamicstrategy.api.entity.v.class;
    }

    @Override // is2.b
    public final JSONObject g(Bundle r100, is2.a r101) {
        JSONObject r102 = new JSONObject();
        BaseMonitor.add(r102, "open", true);
        return r102;
    }
}
