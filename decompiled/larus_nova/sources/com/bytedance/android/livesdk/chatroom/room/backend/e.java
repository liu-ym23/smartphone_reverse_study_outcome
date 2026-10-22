package com.bytedance.android.livesdk.chatroom.room.backend;

import android.os.Bundle;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.livesdk.n5;
import com.bytedance.android.livesdk.o5;
import com.bytedance.android.livesdkapi.model.GameIntroduceCardResponseV2;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class e implements is2.b {
    public e() {
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
    public final boolean f() {
        return true;
    }

    @Override // is2.b
    public final String getPath() {
        return "webcast_gamecp_introduce_card";
    }

    @Override // is2.b
    public final boolean enable() {
        if (o5.f154128a.getValue().booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (n5.f153997a.getValue().booleanValue() == false) goto L7;
        return true;
    }

    @Override // is2.b
    public final Class<?> getModelClass() {
        return GameIntroduceCardResponseV2.class;
    }

    @Override // is2.b
    public final JSONObject g(Bundle r100, is2.a r101) {
        JSONObject r102 = new JSONObject();
        BaseMonitor.add(r102, "open", enable());
        BaseMonitor.add(r102, "biz_data_type", 1);
        return r102;
    }
}
