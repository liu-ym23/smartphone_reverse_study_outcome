package com.bytedance.android.live.profit.redpacket.model;

import android.os.Bundle;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.revenue.common.b0;
import com.bytedance.android.scope.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements is2.b, o {
    public d() {
    }

    @Override // is2.b
    public final /* synthetic */ boolean a() {
        return false;
    }

    @Override // is2.b
    public final boolean c() {
        return true;
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
        return "webcast_luckybox_box_list";
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // is2.b
    public final boolean enable() {
        if (LiveInfraSettingKeys.LIVE_ROOM_BACKEND_BUSINESS_SWITCH.getValue().g() == true) goto L5;
    L7:
        return false;
    L5:
        if (b0.b().b0() != 0) goto L7;
        return true;
    }

    @Override // is2.b
    public final Class<?> getModelClass() {
        return b.class;
    }

    @Override // is2.b
    public final JSONObject g(Bundle r100, is2.a r101) {
        JSONObject r102 = new JSONObject();
        BaseMonitor.add(r102, "open", true);
        BaseMonitor.add(r102, "biz_data_type", 2);
        return r102;
    }
}
