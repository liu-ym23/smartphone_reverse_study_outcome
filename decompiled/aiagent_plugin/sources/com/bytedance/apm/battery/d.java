package com.bytedance.apm.battery;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.crash.dumper.Scraps;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: BatteryTemperatureCollector.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends com.bytedance.apm.perf.a {
    private static final String TAG = "TemperatureCollector";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PluginBroadcastReceiver f4277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IntentFilter f4278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4280d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f4281e;
    private int f;
    private long h;
    private List<com.bytedance.apm.b.a> i;

    /* JADX INFO: compiled from: BatteryTemperatureCollector.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f4287a = null;

        static /* synthetic */ d a() {
            return f4287a;
        }

        static {
            f4287a = new d();
        }
    }

    @Override // com.bytedance.apm.perf.a
    public boolean c() {
        return false;
    }

    @Override // com.bytedance.apm.perf.a
    public long d() {
        return 0;
    }

    static /* synthetic */ long a(d r2) {
        return r2.h;
    }

    static /* synthetic */ long a(d r0, long r1) {
        r0.h = r1;
        return r1;
    }

    static /* synthetic */ int b(d r0) {
        return r0.f;
    }

    static /* synthetic */ boolean c(d r0) {
        return r0.f4280d;
    }

    static /* synthetic */ boolean d(d r0) {
        return r0.f4281e;
    }

    static /* synthetic */ List e(d r0) {
        return r0.i;
    }

    public static d a() {
        return a.a();
    }

    public d() {
        this.f4280d = false;
        this.f = 60;
        this.g = Scraps.BATTERY;
    }

    public void a(boolean r1) {
        this.f4281e = r1;
        j();
    }

    @Override // com.bytedance.apm.perf.a
    public void a(JSONObject r4) {
        super.a(r4);
        boolean r1 = false;
        if (r4.optInt("temperature_enable_upload", 0) != 1) goto L5;
        r1 = true;
    L5:
        this.f4280d = r1;
        this.f = r4.optInt("temperature_upload_interval", 60);
        if (this.f4280d == false) goto L8;
        return;
    L8:
        if (this.f4281e == true) goto L12;
        ActivityLifeObserver.getInstance().unregister(this);
        h();
        return;
    }

    @Override // com.bytedance.apm.perf.a
    public void b() {
        this.f4277a = new AnonymousClass1(this);
        this.f4278b = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        g();
    }

    private void g() {
        if (this.f4279c == false) goto L8;
        return;
    L8:
        ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.f4277a, this.f4278b, "com.obric.aiagent.plugin");     // Catch: Exception -> L7
        this.f4279c = true;     // Catch: Exception -> L7
        return;
    }

    private void h() {
        if (this.f4279c == true) goto L8;
        return;
    L8:
        ZeusTransformUtils.unregisterReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.f4277a, "com.obric.aiagent.plugin");     // Catch: Exception -> L7
        this.f4279c = false;     // Catch: Exception -> L7
        return;
    }

    @Override // com.bytedance.apm.perf.a, com.bytedance.services.apm.api.d
    public void onBackground(Activity r3) {
        super.onBackground((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin"));
        h();
    }

    @Override // com.bytedance.apm.perf.a, com.bytedance.services.apm.api.d
    public void onFront(Activity r3) {
        super.onFront((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin"));
        g();
    }
}
