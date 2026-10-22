package com.android.server;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.os.UEventObserver;
import android.provider.Settings;
import android.util.Slog;
import com.android.server.statusbar.StatusBarManagerInternal;
import vendor.bytedance.hardware.health.IChargingCtrl;

/* JADX INFO: loaded from: classes.dex */
public class BatteryServiceSmtEx {
    private static final String CHARGING_CTRL_SERVICE = "vendor.bytedance.hardware.health.IChargingCtrl/default";
    private static final boolean DEBUG = false;
    protected static final long MAX_LOW_VOLTAGE_DURATION = 60000;
    protected static final int MIN_BATTERY_VOLTAGE = 3200;
    private static final int MSG_DISABLE_REVERSE = 99;
    private static final String REVERSE_ENABLE = "Obric_reverse_charging_enable";
    private static final String REVERSE_STATE = "Obric_reverse_charging_state";
    private static final int REVERSE_STATE_IDLE = 0;
    private static final String TAG = null;
    private final BatteryService mBatteryService;
    private IChargingCtrl mChargingCtrl;
    private final Handler mHandler;
    private long mLastReportTime;
    protected long mLowVoltageStartTime;
    private boolean mReverseEnable;
    private StatusBarManagerInternal mStatusBarManagerInternal;

    /* JADX INFO: renamed from: -$$Nest$fgetmBatteryService, reason: not valid java name */
    static /* bridge */ /* synthetic */ BatteryService m108$$Nest$fgetmBatteryService(BatteryServiceSmtEx r0) {
        return r0.mBatteryService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m109$$Nest$fgetmHandler(BatteryServiceSmtEx r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmReverseEnable, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m110$$Nest$fgetmReverseEnable(BatteryServiceSmtEx r0) {
        return r0.mReverseEnable;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStatusBarManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ StatusBarManagerInternal m111$$Nest$fgetmStatusBarManagerInternal(BatteryServiceSmtEx r0) {
        return r0.mStatusBarManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmReverseEnable, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m112$$Nest$fputmReverseEnable(BatteryServiceSmtEx r0, boolean r1) {
        r0.mReverseEnable = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmStatusBarManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m113$$Nest$fputmStatusBarManagerInternal(BatteryServiceSmtEx r0, StatusBarManagerInternal r1) {
        r0.mStatusBarManagerInternal = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateReverseSetting, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m114$$Nest$mupdateReverseSetting(BatteryServiceSmtEx r0, boolean r1) {
        r0.updateReverseSetting(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateReverseStateSetting, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m115$$Nest$mupdateReverseStateSetting(BatteryServiceSmtEx r0, int r1) {
        r0.updateReverseStateSetting(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m116$$Nest$sfgetTAG() {
        return TAG;
    }

    static {
        TAG = BatteryServiceSmtEx.class.getSimpleName();
    }

    public BatteryServiceSmtEx(BatteryService batteryService) {
        this.mLowVoltageStartTime = -1;
        this.mLastReportTime = -1;
        this.mReverseEnable = false;
        final Looper r1 = Looper.getMainLooper();
        this.mHandler = new AnonymousClass1(this, r1);
        this.mBatteryService = batteryService;
        UEventObserver wirelessChargerObserver = new AnonymousClass2(this);
        wirelessChargerObserver.startObserving("wipower=detect");
    }

    protected void shutdownIfLowVoltageLocked() {
        if (this.mBatteryService.mHealthInfo.batteryVoltageMillivolts < MIN_BATTERY_VOLTAGE) goto L5;
        this.mLowVoltageStartTime = -1;
        return;
    L5:
        if (this.mLowVoltageStartTime >= 0) goto L8;
        this.mLowVoltageStartTime = SystemClock.elapsedRealtime();
        return;
    L8:
        if ((SystemClock.elapsedRealtime() - this.mLowVoltageStartTime) <= 60000) goto L13;
        this.mBatteryService.mHandler.post(new AnonymousClass3(this));
        return;
    }

    protected void sendBatteryDrainIntent() {
        if (this.mBatteryService.mHealthInfo.batteryLevel < this.mBatteryService.mLastBroadcastBatteryLevel) goto L5;
        return;
    L5:
        if (this.mBatteryService.mHealthInfo.batteryStatus != 3) goto L9;
        final Intent intent = new Intent("android.intent.action.BATTERY_LEVEL_DRAIN");
        intent.addFlags(603979776);
        intent.putExtra("level", this.mBatteryService.mHealthInfo.batteryLevel);
        this.mBatteryService.mHandler.post(new AnonymousClass4(this, intent));
        return;
    }

    protected void setChargeDockApproach() {
        if ((SystemClock.elapsedRealtime() - this.mLastReportTime) <= 500) goto L6;
        this.mLastReportTime = SystemClock.elapsedRealtime();
        final Intent intent = new Intent("com.bytedanceos.chargedock_approach");
        this.mBatteryService.mHandler.post(new AnonymousClass5(this, intent));
        return;
    }

    protected void setWirelessReverseEnable(boolean enable) {
        if (this.mChargingCtrl != null) goto L20;
        IBinder binder = ServiceManager.getService(CHARGING_CTRL_SERVICE);
        if (binder != null) goto L8;
        Slog.d(TAG, "setWirelessReverseEnable CHARGING_CTRL_SERVICEBinder is null");
        return;
    L8:
        this.mChargingCtrl = IChargingCtrl.Stub.asInterface(binder);
    L20:
        this.mChargingCtrl.setWirelessReverseEnable(enable);     // Catch: Throwable -> L17
        monitor-enter(this);     // Catch: Throwable -> L17
        this.mReverseEnable = enable;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17 Throwable -> L17
    L17:
        e = move-exception;
        Slog.w(TAG, "fail to setWirelessReverseEnable to chargingCtrlService" + e);
    }

    public void registerReverseObserver() {
        setWirelessReverseEnable(false);
        updateReverseSetting(false);
        updateReverseStateSetting(0);
        registerReverseStateCallback();
        final ContentResolver resolver = this.mBatteryService.mContext.getContentResolver();
        final Handler r3 = this.mHandler;
        ContentObserver obs = new AnonymousClass6(this, r3, resolver);
        resolver.registerContentObserver(Settings.System.getUriFor(REVERSE_ENABLE), false, obs, -1);
    }

    private void registerReverseStateCallback() {
        if (this.mChargingCtrl != null) goto L10;
        return;
    L10:
        this.mChargingCtrl.setWirelessReverseNotifierCallback(new AnonymousClass7(this));     // Catch: RemoteException -> L7
        return;
    L8:
        Slog.w(TAG, "fail to setWirelessReverseEnable to chargingCtrlService");
    }

    private void updateReverseSetting(boolean r3) {
        Settings.System.putInt(this.mBatteryService.mContext.getContentResolver(), REVERSE_ENABLE, r3 ? 1 : 0);
    }

    private void updateReverseStateSetting(int state) {
        ContentResolver resolver = this.mBatteryService.mContext.getContentResolver();
        Settings.System.putInt(resolver, REVERSE_STATE, state);
        Slog.d(TAG, "updateReverseStateSetting state:" + state);
    }
}
