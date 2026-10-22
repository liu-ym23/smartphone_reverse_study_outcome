package com.obric.autogui.platforms.obric.e.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.thermal.AOThermalLevel;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: BatteryThermalMonitorStrategy.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C0796a f30112a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f30113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f30114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f30115d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f30116e;

    /* JADX INFO: renamed from: com.obric.autogui.platforms.obric.e.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BatteryThermalMonitorStrategy.kt */
    private static final class C0796a {
        public /* synthetic */ C0796a(h r1) {
            this();
        }

        private C0796a() {
        }
    }

    /* JADX INFO: compiled from: BatteryThermalMonitorStrategy.kt */
    public static final class b extends PluginBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f30117a;

        b(a r1) {
            this.f30117a = r1;
        }

        public void onReceive(Context r3, Intent r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            a.a(this.f30117a, r4, "battery broadcast");
        }
    }

    static {
        f30112a = new C0796a(null);
    }

    public a(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        o.e(r4, "thermalLevelEmitter");
        this.f30113b = r4;
        this.f30114c = "BatteryThermalMonitor";
        this.f30115d = "O-P-BatteryThermal";
        this.f30116e = new b(this);
    }

    public static final /* synthetic */ void a(a r0, Intent r1, String r2) {
        r0.a(r1, r2);
    }

    @Override // com.obric.autogui.platforms.obric.e.a.f
    public String a() {
        return this.f30114c;
    }

    @Override // com.obric.autogui.platforms.obric.e.a.f
    public void a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        Intent r6 = c(r5);     // Catch: Throwable -> L5
        Loog.INSTANCE.i(this.f30115d, "init: battery temperature receiver registered");     // Catch: Throwable -> L5
        a(r6, "init");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Loog.INSTANCE.e(this.f30115d, "init: register battery receiver failed", th);
    }

    @Override // com.obric.autogui.platforms.obric.e.a.f
    public void b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        a(d(r4), "reset");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Loog.INSTANCE.e(this.f30115d, "reset: read battery temperature failed", th);
    }

    private final void a(Intent r3, String r4) {
        if (r3 == null) goto L4;
        String r0 = r3.getAction();
    L6:
        if (o.a(r0, "android.intent.action.BATTERY_CHANGED") == true) goto L9;
        Loog.INSTANCE.w(this.f30115d, "handleBatteryTemperatureIntent: invalid intent, source=" + r4);
        return;
    L9:
        int r5 = r3.getIntExtra("temperature", Integer.MIN_VALUE);
        if (r5 != Integer.MIN_VALUE) goto L13;
        Loog.INSTANCE.w(this.f30115d, "handleBatteryTemperatureIntent: temperature missing, source=" + r4);
        return;
    L13:
        a(r5, r4);
        return;
    L4:
        r0 = null;
        goto L6
    }

    private final void a(int r7, String r8) {
        if (r7 < 460) goto L5;
        AOThermalLevel r0 = AOThermalLevel.LEVEL_CRITICAL;
    L6:
        Loog.INSTANCE.i(this.f30115d, new StringBuilder().append("onBatteryTemperatureUpdated: source=").append(r8).append(", batteryTemp=").append(r7 / 10.0f).append("C, threshold=").append(46.0f).append("C, mappedLevel=").append(r0).toString());
        this.f30113b.a(r0);
        return;
    L5:
        r0 = AOThermalLevel.LEVEL_LIGHT;
        goto L6
    }

    private final Intent c(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        IntentFilter r0 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        if (Build.VERSION.SDK_INT < 33) goto L6;
        return ZeusTransformUtils.registerReceiver(r6, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this.f30116e, PluginBroadcastReceiver.class, "com.obric.aiagent.plugin"), r0, 4, "com.obric.aiagent.plugin");
    L6:
        return ZeusTransformUtils.registerReceiver(r6, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this.f30116e, PluginBroadcastReceiver.class, "com.obric.aiagent.plugin"), r0, "com.obric.aiagent.plugin");
    }

    private final Intent d(Context r3) {
        return ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), "com.obric.aiagent.plugin");
    }
}
