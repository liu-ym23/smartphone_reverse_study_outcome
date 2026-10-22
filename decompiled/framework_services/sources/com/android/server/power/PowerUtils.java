package com.android.server.power;

import android.content.Context;
import android.provider.Settings;
import android.util.Slog;
import com.android.server.utils.VintfHalManager;
import vendor.bytedance.hardware.health.IChargingCtrl;

/* JADX INFO: loaded from: classes3.dex */
public class PowerUtils {
    public static final String SETTINGS_FACTORY_CQR_DONE = "factory.cqr.done";
    private static final String TAG = "PowerUtils";

    public PowerUtils() {
    }

    public static void checkShipMode(Context context) {
        if (Settings.Secure.getIntForUser(context.getContentResolver(), "user_setup_complete", 0, -2) == 0) goto L5;
        boolean isSetupComplete = true;
    L7:
        if (Settings.Global.getInt(context.getContentResolver(), SETTINGS_FACTORY_CQR_DONE, 0) != 1) goto L9;
        boolean isFactoryCqrDone = true;
    L10:
        Slog.d(TAG, "checkShipMode isSetupComplete=" + isSetupComplete + " isFactoryCqrDone=" + isFactoryCqrDone);
        if (isSetupComplete == false) goto L13;
        return;
    L13:
        if (isFactoryCqrDone == true) goto L15;
        return;
    L15:
        Settings.Global.putInt(context.getContentResolver(), SETTINGS_FACTORY_CQR_DONE, 0);
        IChargingCtrl chargingCtrlHal = VintfHalManager.getChargeHal();
        if (chargingCtrlHal == null) goto L24;
        chargingCtrlHal.setShipModeEnable(true);     // Catch: Throwable -> L19
        return;
    L19:
        e = move-exception;
        Slog.e(TAG, "Failed setShipModeEnable", e);
        return;
    L24:
        return;
    L9:
        isFactoryCqrDone = false;
        goto L10
    L5:
        isSetupComplete = false;
        goto L7
    }

    public static void setPowerOffMode() {
        IChargingCtrl chargingCtrlHal = VintfHalManager.getChargeHal();
        if (chargingCtrlHal == null) goto L11;
        Slog.d(TAG, "setPowerOffMode true");     // Catch: Throwable -> L6
        chargingCtrlHal.setShutdown(true);     // Catch: Throwable -> L6
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "Failed setShipModeEnable", e);
        return;
    }
}
