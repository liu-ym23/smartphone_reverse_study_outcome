package asb;

import android.os.BatteryManager;
import com.bytedance.crash.dumper.Scraps;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.e;
import com.ss.android.lark.monitor.i;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class d extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BatteryManager f16186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, a> f16187b;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f16188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f16189b;

        public a() {
            this.f16189b = System.currentTimeMillis();
        }
    }

    @Override // com.ss.android.lark.monitor.d
    public final void onAppFrontStateChanged(boolean r100) {
    }

    @Override // com.ss.android.lark.monitor.e
    public final void pauseScene(String r100) {
    }

    public d(i r100) {
        super(r100);
        this.f16187b = new ConcurrentHashMap();
        this.f16186a = (BatteryManager) this.mMetricsConfig.f432397a.getSystemService("batterymanager");
    }

    @Override // com.ss.android.lark.monitor.e
    public final void startScene(final String r100) {
        if (this.f16187b.containsKey(r100) == false) goto L6;
        return;
    L6:
        if (this.f16186a == null) goto L9;
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new b(this, r100));
        return;
    }

    @Override // com.ss.android.lark.monitor.e
    public final void stopScene(final String r100, final JSONObject r101) {
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new asb.a(this, r100, r101));
    }

    public static /* synthetic */ void a(d r100, a r101, String r110, long r111, JSONObject r112) {
        int r102 = r100.f16186a.getIntProperty(4);
        int r103 = r101.f16188a - r102;
        if (r103 > 0) goto L13;
    L11:
        Log.i("ScenePerfMonitor", "End Scene:" + r110 + ",current battery is " + r102 + " usedBattery:" + r103 + " Span:" + r111);
        return;
    L13:
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L9
        r104.put("scene", r110);     // Catch: Throwable -> L9
        r104.put(Scraps.BATTERY, r103);     // Catch: Throwable -> L9
        r104.put("span", r111);     // Catch: Throwable -> L9
        double r105 = r103 / (r111 / 60.0f);     // Catch: Throwable -> L9
        if (r105 <= 0.4d) goto L7;
        r104.put("costException", true);     // Catch: Throwable -> L9
    L7:
        r104.put("batterySpeed", r105);     // Catch: Throwable -> L9
        r104.put("isCharging", ds3.a.c(r100.mMetricsConfig.f432397a));     // Catch: Throwable -> L9
        r104.put("uiMode", r100.mMetricsConfig.f432397a.getResources().getConfiguration().uiMode & 48);     // Catch: Throwable -> L9
        r104.put("remainBattery", r102);     // Catch: Throwable -> L9
        isb.a.a(r104, r112);     // Catch: Throwable -> L9
        isb.a.c("scene_battery_info", r104);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Log.e("ScenePerfMonitor", th);
        goto L11
    }
}
