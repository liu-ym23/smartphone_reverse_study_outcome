package com.android.server.biometrics.sensors.fingerprint.aidl.udfpsdecouple;

import android.app.ActivityManagerInternal;
import android.content.Context;
import android.hardware.biometrics.fingerprint.PointerContext;
import android.os.Binder;
import android.os.PowerManager;
import android.os.UEventObserver;
import android.util.Slog;
import com.android.server.LocalServices;
import com.android.server.biometrics.sensors.SensorList;
import com.android.server.biometrics.sensors.fingerprint.aidl.FingerprintProvider;
import com.android.server.biometrics.sensors.fingerprint.aidl.Sensor;
import com.android.server.wm.WindowManagerInternal;

/* JADX INFO: loaded from: classes.dex */
public class UdfpsDecoupleController {
    private static final String TAG = "UdfpsDecoupleController";
    private static final String TP_AOD_AREAMEET_DOWN = "aod_areameet_down";
    private static final String TP_AREAMEET_DOWN = "areameet_down";
    private static final String TP_AREAMEET_UP = "areameet_up";
    private static final String TP_POWER_STATUS = "TP_POWER_STATUS";
    private static final String TP_POWER_STATUS_AOD = "3";
    private static final String TP_POWER_STATUS_OFF = "1";
    private static final String TP_POWER_STATUS_ON = "2";
    private static final int TP_TOUCH_AOD_DOWN_PARAM = 2;
    private static final int TP_TOUCH_DOWN_UP_CMD = 10;
    private static final int TP_TOUCH_OFF_DOWN_PARAM = 3;
    private static final int TP_TOUCH_ON_DOWN_PARAM = 1;
    private static final int TP_TOUCH_UP_PARAM = 0;
    private static final String TP_WAKEUP_EVENT_NEW_PATH = "MODALIAS=platform:zte_touch";
    private static final String TP_WAKEUP_EVENT_PATH = "MODALIAS=platform:synaptics_tcm";
    private static final int UDFPS_TYPE_SENSOR_ID_NOT_FOUND = -404;
    private static final String VALUE_SINGLETAP_FALSE = "false";
    private static final String VALUE_SINGLETAP_TRUE = "true";
    private static final PointerContext sPointerContext = null;
    private ActivityManagerInternal mAmInternal;
    private final Context mContext;
    private final FingerprintProvider mFingerprintProvider;
    private final SensorList<Sensor> mFingerprintSensors;
    private Binder mFpPerfBinder;
    private PowerManager mPowerManager;
    private final int mSensorId;
    private final UEventObserver mTPWakeupObserver;
    private WindowManagerInternal mWmInternal;

    /* JADX INFO: renamed from: -$$Nest$fgetmFingerprintProvider, reason: not valid java name */
    static /* bridge */ /* synthetic */ FingerprintProvider m2738$$Nest$fgetmFingerprintProvider(UdfpsDecoupleController r0) {
        return r0.mFingerprintProvider;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFingerprintSensors, reason: not valid java name */
    static /* bridge */ /* synthetic */ SensorList m2739$$Nest$fgetmFingerprintSensors(UdfpsDecoupleController r0) {
        return r0.mFingerprintSensors;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSensorId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2740$$Nest$fgetmSensorId(UdfpsDecoupleController r0) {
        return r0.mSensorId;
    }

    /* JADX INFO: renamed from: -$$Nest$misFingerprintTp, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2741$$Nest$misFingerprintTp(UdfpsDecoupleController r0, String r1) {
        return r0.isFingerprintTp(r1);
    }

    static {
        sPointerContext = new PointerContext();
        sPointerContext.x = 0.0f;
        sPointerContext.y = 0.0f;
        sPointerContext.minor = 0.0f;
        sPointerContext.major = 0.0f;
    }

    public UdfpsDecoupleController(Context context, FingerprintProvider fingerprintProvider, SensorList<Sensor> fpSensors) {
        this.mFpPerfBinder = new Binder();
        this.mTPWakeupObserver = new AnonymousClass1(this);
        this.mContext = context;
        this.mFingerprintProvider = fingerprintProvider;
        this.mFingerprintSensors = fpSensors;
        this.mSensorId = getUdfpsTypeSensorId();
        if (this.mSensorId == UDFPS_TYPE_SENSOR_ID_NOT_FOUND) goto L11;
        this.mPowerManager = (PowerManager) this.mContext.getSystemService(PowerManager.class);     // Catch: Exception -> L6
        this.mWmInternal = (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class);     // Catch: Exception -> L6
        this.mAmInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);     // Catch: Exception -> L6
        this.mTPWakeupObserver.startObserving(TP_WAKEUP_EVENT_NEW_PATH);     // Catch: Exception -> L6
        this.mTPWakeupObserver.startObserving(TP_WAKEUP_EVENT_PATH);     // Catch: Exception -> L6
        Slog.i(TAG, "mTPWakeupObserver start");     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "mTPWakeupObserver start error! e=" + e);
        return;
    }

    private int getUdfpsTypeSensorId() {
        int i = 0;
    L16:
    L9:
        e = move-exception;
        Slog.e(TAG, "getUdfpsTypeSensorId: exp!", e);
        return UDFPS_TYPE_SENSOR_ID_NOT_FOUND;
    L4:
        if (i >= this.mFingerprintSensors.size()) goto L20;
        if (this.mFingerprintSensors.valueAt(i).getSensorProperties().isAnyUdfpsType() == true) goto L7;
        i = i + 1;
        goto L16
    L7:
        Slog.i(TAG, "getUdfpsTypeSensorId " + this.mFingerprintSensors.keyAt(i));     // Catch: Exception -> L9
        return this.mFingerprintSensors.keyAt(i);
    L20:
        return UDFPS_TYPE_SENSOR_ID_NOT_FOUND;
    }

    private boolean hasCurrentClient() {
        if (this.mFingerprintSensors.get(this.mSensorId).getScheduler().getCurrentClient() == null) goto L12;
        return true;
    L12:
        return false;
    L7:
        e = move-exception;
        Slog.e(TAG, "hasCurrentClient: exp!", e);
        return false;
    }

    private long getCurrentClientRequestId() {
        return this.mFingerprintSensors.get(this.mSensorId).getScheduler().getCurrentClient().getRequestId();
    L4:
        e = move-exception;
        Slog.e(TAG, "getCurrentClientRequestId: exp!", e);
        return -1;
    }

    private boolean isFingerprintTp(String event) {
        if (hasCurrentClient() == true) goto L36;
        return false;
    L36:
    L10:
        e = move-exception;
        Slog.e(TAG, "isFingerprintTp: exp!", e);
    L34:
        Slog.i(TAG, "isFingerprintTp: F [" + event + "] power is interactive and fingerprint icon not shown");
        return false;
    L7:
        if (TP_AOD_AREAMEET_DOWN.equals(event) == false) goto L13;
        Slog.i(TAG, "isFingerprintTp: T [" + event + "] aod");     // Catch: Exception -> L10
        return true;
    L13:
        if (this.mPowerManager != null) goto L15;
    L17:
        boolean isPowerInteractive = false;
    L19:
        if (isPowerInteractive == true) goto L23;
        Slog.i(TAG, "isFingerprintTp: T [" + event + "] power not interactive");     // Catch: Exception -> L10
        return true;
    L23:
        if (this.mWmInternal != null) goto L25;
    L27:
        boolean isFpIconShown = false;
    L29:
        if (isFpIconShown == false) goto L34;
        Slog.i(TAG, "isFingerprintTp: T [" + event + "] icon shown");     // Catch: Exception -> L10
        return true;
    L25:
        if (this.mWmInternal.isFingerprintSensorIconShowing() == false) goto L27;
        isFpIconShown = true;
        goto L29
    L15:
        if (this.mPowerManager.isInteractive() == false) goto L17;
        isPowerInteractive = true;
        goto L19
    }
}
