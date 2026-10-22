package com.bytedance.android.livesdk.chatroom.room.backend;

import android.os.Bundle;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.MorePanelInfoData;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import kotlin.Unit;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class e0 implements is2.b {
    public e0() {
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
        return "backend_more_panel_request";
    }

    @Override // is2.b
    public final boolean enable() {
        a50.a r100 = LiveInfraSettingKeys.LIVE_ROOM_BACKEND_BUSINESS_SWITCH.getValue();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.h() != true) goto L7;
        return true;
    }

    @Override // is2.b
    public final Class<?> getModelClass() {
        return MorePanelInfoData.class;
    }

    @Override // is2.b
    public final JSONObject g(Bundle r100, is2.a r101) {
        JSONObject r102 = new JSONObject();
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        r104.put("permission", false);
        Unit r105 = Unit.INSTANCE;
        r103.put("union_live", r104);
        JSONObject r106 = new JSONObject();
        r106.put("permission", false);
        r103.put("linkmic_game", r106);
        if (r100 == null) goto L9;
        String r107 = r100.getString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_DISTRIBUTION_SCENE);
        if (r107 == null) goto L9;
        if ((!StringsKt.isBlank(r107)) == false) goto L9;
        r103.put(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_DISTRIBUTION_SCENE, r107);
    L9:
        BaseMonitor.add(r102, "common_params", r103.toString());
        BaseMonitor.add(r102, "biz_data_type", 1);
        BaseMonitor.add(r102, "occasion", 1);
        BaseMonitor.add(r102, "open", true);
        return r102;
    }
}
