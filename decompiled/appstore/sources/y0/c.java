package y0;

import android.app.Activity;
import com.bytedance.apm.battery.util.BatteryUtils;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.thread.AsyncEventManager;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends v1.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f25930h = 10;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f25931g;

    static {
    }

    public c() {
        this.f24971e = "battery";
    }

    @Override // v1.a
    public void b(JSONObject r10) {
        boolean r11 = false;
        if (r10.optInt(SlardarSettingsConsts.PERF_BATTERY_ENERGY_ENABLE_UPLOAD, 0) != 1) goto L5;
        r11 = true;
    L5:
        this.f25931g = r11;
    }

    @Override // v1.a
    public boolean e() {
        return this.f25931g;
    }

    @Override // v1.a
    public void h() {
        super.h();
        if (this.f25931g == true) goto L5;
        return;
    L5:
        if (d() == false) goto L8;
        return;
    L8:
        if (BatteryUtils.e(w0.c.g()) == false) goto L10;
        return;
    L10:
        float r10 = ff.b.b(w0.c.g());
        if (r10 >= f25930h) goto L16;
        return;
    L16:
        JSONObject r11 = new JSONObject();     // Catch: JSONException -> L15
        r11.put(PerfConsts.KEY_TIMING_CURRENT, r10);     // Catch: JSONException -> L15
        JSONObject r12 = new JSONObject();     // Catch: JSONException -> L15
        r12.put("scene", ActivityLifeObserver.getInstance().getTopActivityClassName());     // Catch: JSONException -> L15
        j(new m1.e("battery", "", r11, r12, null));     // Catch: JSONException -> L15
        return;
    }

    @Override // v1.a
    public long m() {
        return 300000;
    }

    @Override // v1.a, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onBackground(Activity r10) {
        super.onBackground(r10);
        AsyncEventManager.e().removeTimeTask(this);
    }

    @Override // v1.a, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r10) {
        super.onFront(r10);
        if (this.f25931g == false) goto L6;
        AsyncEventManager.e().addTimeTask(this);
        return;
    }
}
