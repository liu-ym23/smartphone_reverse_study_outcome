package au0;

import android.os.Bundle;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.profit.dress.i;
import com.bytedance.android.scope.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements is2.b, o {
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
        return "/webcast/dress/list/";
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // is2.b
    public final boolean enable() {
        return LiveInfraSettingKeys.LIVE_ROOM_BACKEND_BUSINESS_SWITCH.getValue().c();
    }

    @Override // is2.b
    public final Class<?> getModelClass() {
        return b.class;
    }

    @Override // is2.b
    public final JSONObject g(Bundle r100, is2.a r101) {
        JSONObject r102 = new JSONObject();
        BaseMonitor.add(r102, "open", true);
        BaseMonitor.add(r102, "biz_data_type", 1);
        iz0.a r103 = i.f87115a;
        BaseMonitor.add(r102, "version", i.f87117c);
        return r102;
    }
}
