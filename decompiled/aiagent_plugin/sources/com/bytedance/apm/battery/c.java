package com.bytedance.apm.battery;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.crash.dumper.Scraps;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: BatteryEnergyTimerCollector.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends com.bytedance.apm.perf.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f4264a = 10;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f4265b;

    static {
    }

    @Override // com.bytedance.apm.perf.a
    public long d() {
        return 300000;
    }

    public c() {
        this.g = Scraps.BATTERY;
    }

    @Override // com.bytedance.apm.perf.a
    public void a(JSONObject r5) {
        boolean r1 = true;
        if (Build.VERSION.SDK_INT >= 21) goto L5;
    L7:
        r1 = false;
    L8:
        this.f4265b = r1;
        return;
    L5:
        if (r5.optInt("energy_enable", 0) != 1) goto L7;
        goto L7
    }

    @Override // com.bytedance.apm.perf.a
    public void e() {
        super.e();
        if (this.f4265b == true) goto L5;
        return;
    L5:
        if (n() == false) goto L8;
        return;
    L8:
        if (com.bytedance.apm.battery.e.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == false) goto L10;
        return;
    L10:
        float r0 = com.ss.thor.b.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        if (r0 >= f4264a) goto L16;
        return;
    L16:
        JSONObject r5 = new JSONObject();     // Catch: JSONException -> L15
        r5.put("timing_current", r0);     // Catch: JSONException -> L15
        JSONObject r6 = new JSONObject();     // Catch: JSONException -> L15
        r6.put(DBHelper.BATTERY_COL_SCENE, ActivityLifeObserver.getInstance().getTopActivityClassName());     // Catch: JSONException -> L15
        a(new com.bytedance.apm.d.b.e(Scraps.BATTERY, "", r5, r6, null));     // Catch: JSONException -> L15
        return;
    }

    @Override // com.bytedance.apm.perf.a, com.bytedance.services.apm.api.d
    public void onBackground(Activity r3) {
        super.onBackground((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin"));
        com.bytedance.apm.thread.b.a().b(this);
    }

    @Override // com.bytedance.apm.perf.a, com.bytedance.services.apm.api.d
    public void onFront(Activity r3) {
        super.onFront((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin"));
        if (this.f4265b == false) goto L6;
        com.bytedance.apm.thread.b.a().a(this);
        return;
    }

    @Override // com.bytedance.apm.perf.a
    public boolean c() {
        return this.f4265b;
    }
}
