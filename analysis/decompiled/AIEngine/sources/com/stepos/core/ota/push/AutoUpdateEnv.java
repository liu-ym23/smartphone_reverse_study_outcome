package com.stepos.core.ota.push;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.BatteryManager;
import android.os.PowerManager;
import android.os.StatFs;
import com.tonyodev.fetch2core.server.FileResponse;
import dc.h;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AutoUpdateEnv {
    public static final AutoUpdateEnv INSTANCE = new AutoUpdateEnv();
    public static final long MIN_FREE_BYTES = 2147483648L;
    private static final String PROP_TEST_BATTERY = "debug.aiengine.testbat";
    private static final String PROP_TEST_CHARGING = "debug.aiengine.testcharging";

    private AutoUpdateEnv() {
    }

    private final int readIntProp(String str, int i10) {
        Object objA;
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getMethod("getInt", String.class, Integer.TYPE).invoke(null, str, Integer.valueOf(i10));
            g.d(objInvoke, "null cannot be cast to non-null type kotlin.Int");
            objA = (Integer) objInvoke;
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Object objValueOf = Integer.valueOf(i10);
        if (objA instanceof Result.Failure) {
            objA = objValueOf;
        }
        return ((Number) objA).intValue();
    }

    private final Integer testBatteryOverride() {
        Integer numValueOf = Integer.valueOf(readIntProp(PROP_TEST_BATTERY, -1));
        int iIntValue = numValueOf.intValue();
        if (iIntValue < 0 || iIntValue >= 101) {
            return null;
        }
        return numValueOf;
    }

    private final Boolean testChargingOverride() {
        int intProp = readIntProp(PROP_TEST_CHARGING, -1);
        if (intProp == 0) {
            return Boolean.FALSE;
        }
        if (intProp != 1) {
            return null;
        }
        return Boolean.TRUE;
    }

    public final int batteryPct(Context ctx) {
        g.f(ctx, "ctx");
        Integer numTestBatteryOverride = testBatteryOverride();
        if (numTestBatteryOverride != null) {
            return numTestBatteryOverride.intValue();
        }
        Object systemService = ctx.getSystemService("batterymanager");
        BatteryManager batteryManager = systemService instanceof BatteryManager ? (BatteryManager) systemService : null;
        if (batteryManager == null) {
            return 0;
        }
        return h.a0(batteryManager.getIntProperty(4), 0, 100);
    }

    public final long freeBytes(Context ctx) {
        Object objA;
        g.f(ctx, "ctx");
        try {
            objA = Long.valueOf(new StatFs(ctx.getFilesDir().getAbsolutePath()).getAvailableBytes());
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = 0L;
        }
        return ((Number) objA).longValue();
    }

    public final boolean hasEnoughSpace(Context ctx) {
        g.f(ctx, "ctx");
        return freeBytes(ctx) >= MIN_FREE_BYTES;
    }

    public final boolean isCharging(Context ctx) {
        Object objA;
        g.f(ctx, "ctx");
        Boolean boolTestChargingOverride = testChargingOverride();
        if (boolTestChargingOverride != null) {
            return boolTestChargingOverride.booleanValue();
        }
        try {
            objA = ctx.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        Intent intent = (Intent) objA;
        if (intent != null) {
            return AutoUpdateEnvKt.isChargingState(intent.getIntExtra("plugged", 0), intent.getIntExtra(FileResponse.FIELD_STATUS, 1));
        }
        Object systemService = ctx.getSystemService("batterymanager");
        BatteryManager batteryManager = systemService instanceof BatteryManager ? (BatteryManager) systemService : null;
        return batteryManager != null && batteryManager.isCharging();
    }

    public final boolean isScreenOff(Context ctx) {
        g.f(ctx, "ctx");
        Object systemService = ctx.getSystemService("power");
        if ((systemService instanceof PowerManager ? (PowerManager) systemService : null) == null) {
            return false;
        }
        return !r0.isInteractive();
    }

    public final boolean isWifiValidated(Context ctx) {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        g.f(ctx, "ctx");
        Object systemService = ctx.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        return connectivityManager != null && (activeNetwork = connectivityManager.getActiveNetwork()) != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null && networkCapabilities.hasTransport(1) && networkCapabilities.hasCapability(12) && networkCapabilities.hasCapability(16);
    }
}
