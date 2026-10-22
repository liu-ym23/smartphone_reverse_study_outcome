package com.bytedance.apm.battery.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import com.GlobalProxyLancet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BatteryUtils {
    private static List<ChargeListener> chargeListeners;
    private static boolean hasRegisterReceiver;
    private static boolean isCharging;
    private static PowerConnectionReceiver powerConnectionReceiver;
    static BatteryManager sBatteryManager;

    /* JADX INFO: renamed from: com.bytedance.apm.battery.util.BatteryUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public interface ChargeListener {
        void onChange(boolean r1);
    }

    private static class PowerConnectionReceiver extends BroadcastReceiver {
        private PowerConnectionReceiver() {
        }

        /* synthetic */ PowerConnectionReceiver(AnonymousClass1 r1) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            String r0 = r2.getAction();
            if ("android.intent.action.ACTION_POWER_CONNECTED".equals(r0) == false) goto L9;
            BatteryUtils.access$102(true);
            Iterator r3 = BatteryUtils.access$200().iterator();
        L6:
            if (r3.hasNext() == false) goto L17;
            ((ChargeListener) r3.next()).onChange(BatteryUtils.access$100());
            goto L6
        L17:
            return;
        L9:
            if ("android.intent.action.ACTION_POWER_DISCONNECTED".equals(r0) == false) goto L14;
            BatteryUtils.access$102(false);
            Iterator r4 = BatteryUtils.access$200().iterator();
        L12:
            if (r4.hasNext() == false) goto L18;
            ((ChargeListener) r4.next()).onChange(BatteryUtils.access$100());
            goto L12
        L18:
            return;
        }
    }

    public BatteryUtils() {
    }

    static /* synthetic */ boolean access$100() {
        return isCharging;
    }

    static /* synthetic */ boolean access$102(boolean r0) {
        isCharging = r0;
        return r0;
    }

    static /* synthetic */ List access$200() {
        return chargeListeners;
    }

    static {
        chargeListeners = new ArrayList();
        hasRegisterReceiver = false;
    }

    private static void ensureManager(Context r1) {
        sBatteryManager = (BatteryManager) r1.getSystemService("batterymanager");
    }

    public static long getCurrentNow(Context r2) {
        ensureManager(r2);
        return sBatteryManager.getLongProperty(2);
    }

    public static boolean isCharging(Context r3) {
        if (hasRegisterReceiver == true) goto L5;
        Intent r4 = GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r3, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (r4 == null) goto L15;
        int r5 = r4.getIntExtra("status", -1);
        if (r5 != 2) goto L11;
        return true;
    L11:
        if (r5 == 5) goto L17;
        return false;
    L17:
        return true;
    L15:
        return true;
    L5:
        return isCharging;
    }

    public static boolean addChargeListener(Context r1, ChargeListener r2) {
        if (r2 == null) goto L9;
        chargeListeners.add(r2);
        if (hasRegisterReceiver == true) goto L7;
        registerBatteryReceiver(r1);
        hasRegisterReceiver = true;
    L7:
        return isCharging;
    L9:
        throw new IllegalArgumentException("chargeListener can't be null");
    }

    public static void removeListener(Context r1, ChargeListener r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        chargeListeners.remove(r2);
        if (chargeListeners.isEmpty() == false) goto L12;
        r1.unregisterReceiver(powerConnectionReceiver);     // Catch: Throwable -> L9
    L7:
        hasRegisterReceiver = false;
        return;
    }

    private static void registerBatteryReceiver(Context r3) {
        IntentFilter r0 = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");     // Catch: Throwable -> L4
        r0.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");     // Catch: Throwable -> L4
        PowerConnectionReceiver r1 = new PowerConnectionReceiver(null);     // Catch: Throwable -> L4
        powerConnectionReceiver = r1;     // Catch: Throwable -> L4
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r3, r1, r0);     // Catch: Throwable -> L4
        isCharging = isCharging(r3);     // Catch: Throwable -> L4
        return;
    L4:
        isCharging = true;
    }
}
