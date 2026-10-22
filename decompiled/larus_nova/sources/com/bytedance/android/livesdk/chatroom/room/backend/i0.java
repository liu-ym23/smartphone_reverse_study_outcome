package com.bytedance.android.livesdk.chatroom.room.backend;

import android.os.Bundle;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.config.aj;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class i0 implements is2.b {
    public i0() {
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
        return "backend_screencast_setting_request";
    }

    @Override // is2.b
    public final boolean enable() {
        SettingKey<a50.a> r100 = LiveInfraSettingKeys.LIVE_ROOM_BACKEND_BUSINESS_SWITCH;
        if (r100 == null) goto L9;
        a50.a r101 = r100.getValue();
        if (r101 == null) goto L9;
        if (r101.l() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // is2.b
    public final Class<?> getModelClass() {
        return String.class;
    }

    @Override // is2.b
    public final JSONObject g(Bundle r100, is2.a r101) {
        JSONObject r102 = new JSONObject();
        BaseMonitor.add(r102, "support_barrage", aj.f119796a.getValue().booleanValue());
        BaseMonitor.add(r102, "open", true);
        BaseMonitor.add(r102, "biz_data_type", 1);
        return r102;
    }
}
