package com.obric.performance.power.monitor.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: BatteryMonitor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f36945a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f36946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static C1009a f36947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List<b> f36948d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static float f36949e;
    private static boolean f;
    private static float g;
    private static int h;

    /* JADX INFO: renamed from: com.obric.performance.power.monitor.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BatteryMonitor.kt */
    public static final class C1009a extends PluginBroadcastReceiver {
        public C1009a() {
        }

        public void onReceive(Context r2, Intent r3) {
            o.e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "context");
            o.e(r3, MemorySourceLinkType.INTENT);
            ILogDepend.Companion.d("PowerMonitor", "BatteryMonitor onReceive");
            a.a(a.f36945a, r3);
        }
    }

    /* JADX INFO: compiled from: BatteryMonitor.kt */
    public interface b {
        void a(boolean r1);
    }

    private a() {
    }

    public static final /* synthetic */ void a(a r0, Intent r1) {
        r0.a(r1);
    }

    static {
        f36945a = new a();
        f36948d = Collections.synchronizedList((List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin"));
    }

    public final float a() {
        return f36949e;
    }

    public final boolean b() {
        return f;
    }

    public final float c() {
        return g;
    }

    public final int d() {
        return h;
    }

    public final synchronized void a(b r3) {
        monitor-enter(this);
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        if (r4 == null) goto L11;
        List<b> r0 = f36948d;     // Catch: Throwable -> L13
        if (r0.contains(r4) == true) goto L11;
        r4.a(f);     // Catch: Throwable -> L13
        r0.add(r4);     // Catch: Throwable -> L13
        ILogDepend.Companion.d("PowerMonitor", "BatteryMonitor registerChargeCallback");     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L11:
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(b r3) {
        monitor-enter(this);
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        if (r4 == null) goto L11;
        List<b> r0 = f36948d;     // Catch: Throwable -> L13
        if (r0.contains(r4) == false) goto L11;
        r0.remove(r4);     // Catch: Throwable -> L13
        ILogDepend.Companion.d("PowerMonitor", "BatteryMonitor unregisterChargeCallback");     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L11:
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void a(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r8, "context");
    L13:
        th = move-exception;
        a("PowerMonitor", "BatteryMonitor registerBatteryReceiver", th);
        return;
    L4:
        if (f36947c == null) goto L6;
        return;
    L6:
        if (f36946b != null) goto L18;
        f36946b = r8;     // Catch: Throwable -> L13
        ILogDepend.Companion.d("PowerMonitor", "BatteryMonitor registerBatteryReceiver");     // Catch: Throwable -> L13
        f36947c = new C1009a();     // Catch: Throwable -> L13
        IntentFilter r2 = new IntentFilter("android.intent.action.BATTERY_CHANGED");     // Catch: Throwable -> L13
        Intent r9 = ZeusTransformUtils.registerReceiver(r8, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(f36947c, PluginBroadcastReceiver.class, "com.obric.aiagent.plugin"), r2, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        if (r9 == null) goto L19;
        a(r9);     // Catch: Throwable -> L13
        return;
    L19:
        return;
    }

    public final void e() {
        if (f36947c == null) goto L9;
        ILogDepend.Companion.d("PowerMonitor", "BatteryMonitor unregisterBatteryReceiver");
        Context r3 = f36946b;
        if (r3 == null) goto L7;
        ZeusTransformUtils.unregisterReceiver(r3, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(f36947c, PluginBroadcastReceiver.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    L7:
        f36947c = null;
        f36946b = null;
        return;
    }

    private final void a(Intent r7) {
        h = b(r7);
        f36949e = 100 * (r7.getIntExtra("level", -1) / r7.getIntExtra("scale", -1));
        int r6 = r7.getIntExtra("status", -1);
        if (r6 != 2) goto L5;
    L8:
        boolean r8 = true;
    L10:
        if (f == r8) goto L23;
        List<b> r1 = f36948d;
        o.c(r1, "chargeCallbackList");
        monitor-enter(r1);
        o.c(r1, "chargeCallbackList");     // Catch: Throwable -> L20
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L20
    L15:
        if (r2.hasNext() == false) goto L17;
        ((b) ZeusTransformUtils.preCheckCast(r2.next(), b.class, "com.obric.aiagent.plugin")).a(r8);     // Catch: Throwable -> L20
        goto L15
    L17:
        x r3 = x.f38692a;     // Catch: Throwable -> L20
        monitor-exit(r1);
    L20:
        th = move-exception;
        throw th;
    L23:
        f = r8;
        ILogDepend.Companion.d("PowerMonitor", "BatteryMonitor resetValue: cap=" + f36949e + ", charger=" + f);
        g = r7.getIntExtra("temperature", 0) / 10.0f;
        return;
    L5:
        if (r6 == 5) goto L8;
        r8 = false;
        goto L10
    }

    private final int b(Intent r3) {
        String r0 = null;
        Object r2 = BatteryManager.class.getField("EXTRA_CHARGE_COUNTER").get(null);     // Catch: Throwable -> L6
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L8;
        r0 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
    L8:
        if (r0 != null) goto L11;
        return -1;
    L11:
        return r3.getIntExtra(r0, -1);
    L6:
        r0 = "android.os.extra.CHARGE_COUNTER";
        goto L8
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
