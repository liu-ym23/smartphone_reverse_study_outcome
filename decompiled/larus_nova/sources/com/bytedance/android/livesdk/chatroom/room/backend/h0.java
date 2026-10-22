package com.bytedance.android.livesdk.chatroom.room.backend;

import android.os.Bundle;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livesdk.message.model.lk;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class h0 implements is2.b {
    public h0() {
    }

    @Override // is2.b
    public final boolean a() {
        return true;
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
        return "backend_room_rank";
    }

    @Override // is2.b
    public final boolean enable() {
        a50.a r100 = LiveInfraSettingKeys.LIVE_ROOM_BACKEND_BUSINESS_SWITCH.getValue();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.j() != true) goto L7;
        return true;
    }

    @Override // is2.b
    public final Class<?> getModelClass() {
        return lk.class;
    }

    @Override // is2.b
    public final JSONObject g(Bundle r100, is2.a r101) {
        JSONObject r102 = new JSONObject();
        BaseMonitor.add(r102, "open", true);
        BaseMonitor.add(r102, "biz_data_type", 2);
        return r102;
    }
}
