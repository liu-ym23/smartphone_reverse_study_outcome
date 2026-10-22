package com.ttnet.org.chromium.base;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class PowerMonitor implements TTLifeCycleMonitor.a {
    private static final String TAG = "PowerMonitor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f37652a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static PowerMonitor f37653b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static TTLifeCycleMonitor f37654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static a f37655e;
    private static String f;
    private static String g;
    private static String h;
    private static String i;
    private static String j;
    private static long k;
    private static long l;
    private static boolean m;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f37656c;

    public static class a extends PluginBroadcastReceiver {
        public a() {
        }

        public void onReceive(Context r6, Intent r7) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
            long r8 = System.currentTimeMillis();
            String r9 = r7.getAction();
            if (r9.equals(PowerMonitor.f()) == false) goto L5;
        L14:
            long r3 = r8 - PowerMonitor.h();
            PowerMonitor.a(r8);
            if (r3 <= 10000) goto L21;
            p.f().c();
            return;
        L21:
            return;
        L5:
            if (r9.equals(PowerMonitor.g()) == true) goto L14;
            if (r9.equals(PowerMonitor.i()) == false) goto L10;
        L11:
            long r4 = r8 - PowerMonitor.k();
            PowerMonitor.b(r8);
            if (r4 <= 10000) goto L19;
            p.f().b();
            return;
        L19:
            return;
        L10:
            if (r9.equals(PowerMonitor.j()) == true) goto L11;
        }
    }

    interface b {
        void a();

        void a(int r1);

        void b();

        void c();

        void d();

        void e();
    }

    static /* synthetic */ long a(long r0) {
        k = r0;
        return r0;
    }

    static /* synthetic */ long b(long r0) {
        l = r0;
        return r0;
    }

    static /* synthetic */ void b(boolean r0) {
        c(r0);
    }

    static /* synthetic */ String f() {
        return f;
    }

    static /* synthetic */ String g() {
        return h;
    }

    static /* synthetic */ long h() {
        return k;
    }

    static /* synthetic */ String i() {
        return g;
    }

    static /* synthetic */ String j() {
        return i;
    }

    static /* synthetic */ long k() {
        return l;
    }

    static {
        f37654d = new TTLifeCycleMonitor();
    }

    public static void a(boolean r0) {
        m = r0;
    }

    @Override // com.ttnet.org.chromium.base.TTLifeCycleMonitor.a
    public void a() {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (t.a(r2) == false) goto L11;
        Intent r0 = new Intent();
        r0.setAction(f);
        if (TextUtils.isEmpty(j) == true) goto L13;
        r0.setPackage(j);
    L13:
        r2.sendBroadcast(r0);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    L11:
        p.f().c();
    }

    @Override // com.ttnet.org.chromium.base.TTLifeCycleMonitor.a
    public void b() {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (t.a(r2) == false) goto L11;
        Intent r0 = new Intent();
        r0.setAction(g);
        if (TextUtils.isEmpty(j) == true) goto L13;
        r0.setPackage(j);
    L13:
        r2.sendBroadcast(r0);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    L11:
        p.f().b();
    }

    @Override // com.ttnet.org.chromium.base.TTLifeCycleMonitor.a
    public void c() {
        p.f().e();
    }

    @Override // com.ttnet.org.chromium.base.TTLifeCycleMonitor.a
    public void d() {
        p.f().d();
    }

    public static void e() {
        if (f37653b == null) goto L5;
        return;
    L5:
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        f37653b = new PowerMonitor();
        Intent r2 = d.a(r0, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (r2 == null) goto L11;
        boolean r4 = false;
        if (r2.getIntExtra("plugged", 0) != 0) goto L10;
        r4 = true;
    L10:
        c(r4);
    L11:
        IntentFilter r3 = new IntentFilter();
        r3.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        r3.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        d.a(r0, new AnonymousClass1(), r3);
        j = r0.getPackageName();
        g = j + ".cronet.APP_BACKGROUND";
        f = j + ".cronet.APP_FOREGROUND";
        i = j + ".wschannel.APP_BACKGROUND";
        h = j + ".wschannel.APP_FOREGROUND";
        if (t.a(r0) == true) goto L18;
        if (m == true) goto L18;
        f37655e = new a();
        IntentFilter r1 = new IntentFilter();
        r1.addAction(g);
        r1.addAction(f);
        r1.addAction(i);
        r1.addAction(h);
        d.a(r0, f37655e, r1);
        return;
    L18:
        if (ZeusTransformUtils.instanceOf(r0, Application.class) == false) goto L22;
        Application r5 = (Application) ZeusTransformUtils.preCheckCast(r0, Application.class, "com.obric.aiagent.plugin");
        f37654d.setAppStateChangedListener(f37653b);
        r5.registerActivityLifecycleCallbacks(f37654d);
        return;
    }

    private PowerMonitor() {
    }

    private static void c(boolean r1) {
        if (f37652a == false) goto L5;
    L9:
        f37653b.f37656c = r1;
        p.f().a();
        return;
    L5:
        if (f37653b != null) goto L9;
        throw new AssertionError();
    }

    private static boolean isBatteryPower() {
        if (f37653b != null) goto L6;
        e();
    L6:
        return f37653b.f37656c;
    }

    private static int getRemainingBatteryCapacity() {
        if (Build.VERSION.SDK_INT >= 21) goto L7;
        return 0;
    L7:
        if (f37653b != null) goto L10;
        e();
    L10:
        return l();
    }

    private static int l() {
        return ((BatteryManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("batterymanager"), BatteryManager.class, "com.obric.aiagent.plugin")).getIntProperty(1);
    }

    private static int getCurrentThermalStatus() {
        if (Build.VERSION.SDK_INT >= 29) goto L6;
        return -1;
    L6:
        if (f37653b != null) goto L8;
        e();
    L8:
        PowerManager r0 = (PowerManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("power"), PowerManager.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L12;
        return -1;
    L12:
        return com.ttnet.org.chromium.base.compat.e.a(r0);
    }
}
