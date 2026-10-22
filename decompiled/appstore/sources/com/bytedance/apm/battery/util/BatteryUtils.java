package com.bytedance.apm.battery.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BatteryUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List f6361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f6362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f6363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static b f6364d;

    public interface ChargeListener {
        void onChange(boolean r10);
    }

    public static /* synthetic */ class a {
    }

    public static class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r10, Intent r11) {
            String r12 = r11.getAction();
            if ("android.intent.action.ACTION_POWER_CONNECTED".equals(r12) == false) goto L9;
            BatteryUtils.b(true);
            Iterator r13 = BatteryUtils.c().iterator();
        L6:
            if (r13.hasNext() == false) goto L17;
            ((ChargeListener) r13.next()).onChange(BatteryUtils.a());
            goto L6
        L17:
            return;
        L9:
            if ("android.intent.action.ACTION_POWER_DISCONNECTED".equals(r12) == false) goto L14;
            BatteryUtils.b(false);
            Iterator r14 = BatteryUtils.c().iterator();
        L12:
            if (r14.hasNext() == false) goto L18;
            ((ChargeListener) r14.next()).onChange(BatteryUtils.a());
            goto L12
        L18:
            return;
        }

        public /* synthetic */ b(a r10) {
            this();
        }
    }

    static {
        f6361a = new ArrayList();
        f6362b = false;
    }

    public static /* synthetic */ boolean a() {
        return f6363c;
    }

    public static /* synthetic */ boolean b(boolean r10) {
        f6363c = r10;
        return r10;
    }

    public static /* synthetic */ List c() {
        return f6361a;
    }

    public static boolean d(Context r10, ChargeListener r11) {
        if (r11 == null) goto L9;
        f6361a.add(r11);
        if (f6362b == true) goto L7;
        f(r10);
        f6362b = true;
    L7:
        return f6363c;
    L9:
        throw new IllegalArgumentException("chargeListener can't be null");
    }

    public static boolean e(Context r10) {
        if (f6362b == true) goto L5;
        Intent r11 = r10.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (r11 == null) goto L15;
        int r12 = r11.getIntExtra("status", -1);
        if (r12 != 2) goto L11;
        return true;
    L11:
        if (r12 == 5) goto L17;
        return false;
    L17:
        return true;
    L15:
        return true;
    L5:
        return f6363c;
    }

    public static void f(Context r10) {
        IntentFilter r11 = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");     // Catch: Throwable -> L4
        r11.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");     // Catch: Throwable -> L4
        b r12 = new b(null);     // Catch: Throwable -> L4
        f6364d = r12;     // Catch: Throwable -> L4
        r10.registerReceiver(r12, r11);     // Catch: Throwable -> L4
        f6363c = e(r10);     // Catch: Throwable -> L4
        return;
    L4:
        f6363c = true;
    }

    public static void g(Context r10, ChargeListener r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        f6361a.remove(r11);
        if (f6361a.isEmpty() == false) goto L12;
        r10.unregisterReceiver(f6364d);     // Catch: Throwable -> L9
    L7:
        f6362b = false;
        return;
    }
}
