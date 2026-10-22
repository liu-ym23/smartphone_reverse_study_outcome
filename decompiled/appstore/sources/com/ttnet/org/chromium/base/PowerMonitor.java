package com.ttnet.org.chromium.base;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.text.TextUtils;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes4.dex */
@JNINamespace("base::android")
public class PowerMonitor implements TTLifeCycleMonitor.AppStateListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static PowerMonitor f18288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static TTLifeCycleMonitor f18289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static AppStateReceiver f18290d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f18291e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f18292f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f18293g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f18294h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f18295i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static long f18296j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static long f18297k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f18298l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f18299a;

    public static class AppStateReceiver extends BroadcastReceiver {
        public AppStateReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r10, Intent r11) {
            long r12 = System.currentTimeMillis();
            String r13 = r11.getAction();
            if (r13.equals(PowerMonitor.a()) == false) goto L5;
        L14:
            long r14 = r12 - PowerMonitor.c();
            PowerMonitor.d(r12);
            if (r14 <= 10000) goto L21;
            l.b().onResume();
            return;
        L21:
            return;
        L5:
            if (r13.equals(PowerMonitor.b()) == true) goto L14;
            if (r13.equals(PowerMonitor.e()) == false) goto L10;
        L11:
            long r15 = r12 - PowerMonitor.g();
            PowerMonitor.h(r12);
            if (r15 <= 10000) goto L19;
            l.b().onSuspend();
            return;
        L19:
            return;
        L10:
            if (r13.equals(PowerMonitor.f()) == true) goto L11;
        }
    }

    public interface Natives {
        void onBatteryChargingChanged();

        void onInstantResume();

        void onInstantSuspend();

        void onResume();

        void onSuspend();
    }

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r10, Intent r11) {
            PowerMonitor.i(r11.getAction().equals("android.intent.action.ACTION_POWER_DISCONNECTED"));
        }
    }

    static {
        f18289c = new TTLifeCycleMonitor();
    }

    public PowerMonitor() {
    }

    public static /* synthetic */ String a() {
        return f18291e;
    }

    public static /* synthetic */ String b() {
        return f18293g;
    }

    public static /* synthetic */ long c() {
        return f18296j;
    }

    public static /* synthetic */ long d(long r10) {
        f18296j = r10;
        return r10;
    }

    public static /* synthetic */ String e() {
        return f18292f;
    }

    public static /* synthetic */ String f() {
        return f18294h;
    }

    public static /* synthetic */ long g() {
        return f18297k;
    }

    @CalledByNative
    private static int getRemainingBatteryCapacity() {
        if (f18288b != null) goto L6;
        j();
    L6:
        return k();
    }

    public static /* synthetic */ long h(long r10) {
        f18297k = r10;
        return r10;
    }

    public static /* synthetic */ void i(boolean r10) {
        l(r10);
    }

    @CalledByNative
    private static boolean isBatteryPower() {
        if (f18288b != null) goto L6;
        j();
    L6:
        return f18288b.f18299a;
    }

    public static void j() {
        if (f18288b == null) goto L5;
        return;
    L5:
        Context r10 = e.d();
        f18288b = new PowerMonitor();
        Intent r11 = r10.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (r11 == null) goto L11;
        boolean r12 = false;
        if (r11.getIntExtra("plugged", 0) != 0) goto L10;
        r12 = true;
    L10:
        l(r12);
    L11:
        IntentFilter r13 = new IntentFilter();
        r13.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        r13.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        r10.registerReceiver(new a(), r13);
        f18295i = r10.getPackageName();
        f18292f = f18295i + ".cronet.APP_BACKGROUND";
        f18291e = f18295i + ".cronet.APP_FOREGROUND";
        f18294h = f18295i + ".wschannel.APP_BACKGROUND";
        f18293g = f18295i + ".wschannel.APP_FOREGROUND";
        if (p.c(r10) == true) goto L18;
        if (f18298l == true) goto L18;
        f18290d = new AppStateReceiver();
        IntentFilter r14 = new IntentFilter();
        r14.addAction(f18292f);
        r14.addAction(f18291e);
        r14.addAction(f18294h);
        r14.addAction(f18293g);
        r10.registerReceiver(f18290d, r14);
        return;
    L18:
        if ((r10 instanceof Application) == false) goto L22;
        f18289c.f(f18288b);
        ((Application) r10).registerActivityLifecycleCallbacks(f18289c);
        return;
    }

    public static int k() {
        return ((BatteryManager) e.d().getSystemService("batterymanager")).getIntProperty(1);
    }

    public static void l(boolean r10) {
        f18288b.f18299a = r10;
        l.b().onBatteryChargingChanged();
    }

    public static void m(boolean r10) {
        f18298l = r10;
    }

    @Override // com.ttnet.org.chromium.base.TTLifeCycleMonitor.AppStateListener
    public void onEnterToBackground() {
        Context r10 = e.d();
        if (p.c(r10) == false) goto L8;
        Intent r11 = new Intent();
        r11.setAction(f18292f);
        if (TextUtils.isEmpty(f18295i) == true) goto L7;
        r11.setPackage(f18295i);
    L7:
        r10.sendBroadcast(r11);
    L8:
        l.b().onSuspend();
    }

    @Override // com.ttnet.org.chromium.base.TTLifeCycleMonitor.AppStateListener
    public void onEnterToForeground() {
        Context r10 = e.d();
        if (p.c(r10) == false) goto L8;
        Intent r11 = new Intent();
        r11.setAction(f18291e);
        if (TextUtils.isEmpty(f18295i) == true) goto L7;
        r11.setPackage(f18295i);
    L7:
        r10.sendBroadcast(r11);
    L8:
        l.b().onResume();
    }

    @Override // com.ttnet.org.chromium.base.TTLifeCycleMonitor.AppStateListener
    public void onInstantEnterToBackground() {
        l.b().onInstantSuspend();
    }

    @Override // com.ttnet.org.chromium.base.TTLifeCycleMonitor.AppStateListener
    public void onInstantEnterToForeground() {
        l.b().onInstantResume();
    }
}
