package by1;

import android.os.Bundle;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livesdk.gift.model.z0;
import com.bytedance.android.scope.o;
import is2.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements b, o {
    public a() {
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
        return "webcast_gift_group_show_users";
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // is2.b
    public final boolean enable() {
        return LiveInfraSettingKeys.LIVE_ROOM_BACKEND_BUSINESS_SWITCH.getValue().d();
    }

    @Override // is2.b
    public final Class<?> getModelClass() {
        return z0.class;
    }

    @Override // is2.b
    public final JSONObject g(Bundle r100, is2.a r101) {
        JSONObject r102 = new JSONObject();
        BaseMonitor.add(r102, "open", true);
        BaseMonitor.add(r102, "biz_data_type", "pb");
        BaseMonitor.add(r102, "source", 2);
        return r102;
    }
}
