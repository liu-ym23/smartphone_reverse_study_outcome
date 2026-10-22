package bc2;

import com.bytedance.android.live.base.BaseServices;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livehostapi.platform.IHostMonitor;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import vlc.g;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements g {
    public e() {
    }

    @Override // vlc.g
    public final void b(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        SettingKey<Boolean> r102 = LiveTracingMonitor.f64909a;
        IHostMonitor r103 = (IHostMonitor) BaseServices.as(IHostMonitor.class);
        if (r103 == null) goto L6;
        r103.ensureNotReachHere(r101, r100);
        return;
    }

    @Override // vlc.g
    public final void d(long r110, JSONObject r111, JSONObject r112, JSONObject r113) {
        String r100 = "uplink_status_all";
        Intrinsics.checkNotNullParameter("uplink_status_all", "serviceName");
        if (StringsKt.startsWith$default("uplink_status_all", "ttlive", false, 2, null) == true) goto L6;
        r100 = "ttlive_uplink_status_all";
    L6:
        LiveTracingMonitor.k(r100, LiveTracingMonitor.EventModule.LIVE_MESSAGE, r110, r111, r112, r113);
    }

    @Override // vlc.g
    public final void e(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        if (StringsKt.startsWith$default(r100, "ttlive", false, 2, null) == true) goto L6;
        r100 = "ttlive_" + r100;
    L6:
        LiveTracingMonitor.EventModule r104 = LiveTracingMonitor.EventModule.LIVE_MESSAGE;
        if (r102 != null) goto L9;
        r102 = new JSONObject();
    L9:
        if (r103 != null) goto L11;
        r103 = new JSONObject();
    L11:
        LiveTracingMonitor.f(r100, r104, r101, r102, r103);
    }
}
