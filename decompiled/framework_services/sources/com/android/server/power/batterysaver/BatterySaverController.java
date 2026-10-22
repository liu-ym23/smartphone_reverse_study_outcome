package com.android.server.power.batterysaver;

import android.R;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManagerInternal;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.os.BatterySaverPolicyConfig;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManagerInternal;
import android.os.UserHandle;
import android.provider.Settings;
import android.util.Slog;
import com.android.server.EventLogTags;
import com.android.server.LocalServices;
import java.util.ArrayList;
import java.util.Optional;

/* JADX INFO: loaded from: classes3.dex */
public class BatterySaverController implements BatterySaverPolicy.BatterySaverPolicyListener {
    static final boolean DEBUG = true;
    public static final int REASON_ADAPTIVE_DYNAMIC_POWER_SAVINGS_CHANGED = 11;
    public static final int REASON_DYNAMIC_POWER_SAVINGS_AUTOMATIC_OFF = 10;
    public static final int REASON_DYNAMIC_POWER_SAVINGS_AUTOMATIC_ON = 9;
    public static final int REASON_FULL_CHARGING = 14;
    public static final int REASON_FULL_POWER_SAVINGS_CHANGED = 13;
    public static final int REASON_INTERACTIVE_CHANGED = 5;
    public static final int REASON_MANUAL_OFF = 3;
    public static final int REASON_MANUAL_ON = 2;
    public static final int REASON_PERCENTAGE_AUTOMATIC_OFF = 1;
    public static final int REASON_PERCENTAGE_AUTOMATIC_ON = 0;
    public static final int REASON_PLUGGED_IN = 7;
    public static final int REASON_POLICY_CHANGED = 6;
    public static final int REASON_SETTING_CHANGED = 8;
    public static final int REASON_STICKY_RESTORE = 4;
    public static final int REASON_TIMEOUT = 12;
    static final String TAG = "BatterySaverController";
    private boolean mAdaptiveEnabledRaw;
    private boolean mAdaptivePreviouslyEnabled;
    private final BatterySaverPolicy mBatterySaverPolicy;
    private final BatterySavingStats mBatterySavingStats;
    private final Context mContext;
    private boolean mFullEnabledRaw;
    private boolean mFullPreviouslyEnabled;
    private final MyHandler mHandler;
    private boolean mIsInteractive;
    private boolean mIsPluggedIn;
    private final ArrayList<PowerManagerInternal.LowPowerModeListener> mListeners;
    private final Object mLock;
    private PowerManager mPowerManager;
    private Optional<String> mPowerSaveModeChangedListenerPackage;
    private final BroadcastReceiver mReceiver;

    private class MyHandler extends Handler {
        private static final int ARG_DONT_SEND_BROADCAST = 0;
        private static final int ARG_SEND_BROADCAST = 1;
        private static final int MSG_STATE_CHANGED = 1;
        private static final int MSG_SYSTEM_READY = 2;
        final /* synthetic */ BatterySaverController this$0;

        public MyHandler(BatterySaverController r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
        }

        void postStateChanged(boolean sendBroadcast, int reason) {
            if (sendBroadcast == false) goto L5;
            int r1 = 1;
        L6:
            obtainMessage(1, r1, reason).sendToTarget();
            return;
        L5:
            r1 = 0;
            goto L6
        }

        public void postSystemReady() {
            obtainMessage(2, 0, 0).sendToTarget();
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L5;
                default: goto L11;
            };
        L5:
            BatterySaverController r0 = this.this$0;
            boolean r2 = true;
            if (msg.arg1 == 1) goto L9;
            r2 = false;
        L9:
            r0.handleBatterySaverStateChanged(r2, msg.arg2);
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ MyHandler m7622$$Nest$fgetmHandler(BatterySaverController r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m7623$$Nest$fgetmLock(BatterySaverController r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsPluggedIn, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7624$$Nest$fputmIsPluggedIn(BatterySaverController r0, boolean r1) {
        r0.mIsPluggedIn = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$misPolicyEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7625$$Nest$misPolicyEnabled(BatterySaverController r0) {
        return r0.isPolicyEnabled();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateBatterySavingStats, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7626$$Nest$mupdateBatterySavingStats(BatterySaverController r0) {
        r0.updateBatterySavingStats();
    }

    static String reasonToString(int reason) {
        switch(reason) {
            case 0: goto L31;
            case 1: goto L29;
            case 2: goto L27;
            case 3: goto L25;
            case 4: goto L23;
            case 5: goto L21;
            case 6: goto L19;
            case 7: goto L17;
            case 8: goto L15;
            case 9: goto L13;
            case 10: goto L11;
            case 11: goto L9;
            case 12: goto L7;
            case 13: goto L5;
            default: goto L4;
        };
    L5:
        return "Full Power Savings changed";
    L7:
        return "timeout";
    L9:
        return "Adaptive Power Savings changed";
    L11:
        return "Dynamic Warning Auto OFF";
    L13:
        return "Dynamic Warning Auto ON";
    L15:
        return "Setting changed";
    L17:
        return "Plugged in";
    L19:
        return "Policy changed";
    L21:
        return "Interactivity changed";
    L23:
        return "Sticky restore";
    L25:
        return "Manual OFF";
    L27:
        return "Manual ON";
    L29:
        return "Percentage Auto OFF";
    L31:
        return "Percentage Auto ON";
    L4:
        return "Unknown reason: " + reason;
    }

    public BatterySaverController(Object lock, Context context, Looper looper, BatterySaverPolicy policy, BatterySavingStats batterySavingStats) {
        this.mListeners = new ArrayList();
        this.mReceiver = new AnonymousClass1(this);
        this.mLock = lock;
        this.mContext = context;
        this.mHandler = new MyHandler(this, looper);
        this.mBatterySaverPolicy = policy;
        this.mBatterySaverPolicy.addListener(this);
        this.mBatterySavingStats = batterySavingStats;
        PowerManager.invalidatePowerSaveModeCaches();
    }

    public void addListener(PowerManagerInternal.LowPowerModeListener listener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mListeners.add(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void systemReady() {
        IntentFilter filter = new IntentFilter("android.intent.action.SCREEN_ON");
        filter.addAction("android.intent.action.SCREEN_OFF");
        filter.addAction("android.intent.action.BATTERY_CHANGED");
        filter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
        filter.addAction("android.os.action.LIGHT_DEVICE_IDLE_MODE_CHANGED");
        this.mContext.registerReceiver(this.mReceiver, filter);
        this.mHandler.postSystemReady();
    }

    private PowerManager getPowerManager() {
        if (this.mPowerManager != null) goto L6;
        PowerManager r0 = (PowerManager) this.mContext.getSystemService(PowerManager.class);
        r0.getClass();
        this.mPowerManager = r0;
    L6:
        return this.mPowerManager;
    }

    @Override // com.android.server.power.batterysaver.BatterySaverPolicy.BatterySaverPolicyListener
    public void onBatterySaverPolicyChanged(BatterySaverPolicy policy) {
        if (isPolicyEnabled() == true) goto L5;
        return;
    L5:
        this.mHandler.postStateChanged(true, 6);
    }

    public void enableBatterySaver(boolean enable, int reason) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (getFullEnabledLocked() != enable) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        setFullEnabledLocked(enable);     // Catch: Throwable -> L8
        if (updatePolicyLevelLocked() == false) goto L13;
        this.mHandler.postStateChanged(true, reason);     // Catch: Throwable -> L8
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private boolean updatePolicyLevelLocked() {
        if (getFullEnabledLocked() == false) goto L7;
        return this.mBatterySaverPolicy.setPolicyLevel(2);
    L7:
        if (getAdaptiveEnabledLocked() == false) goto L11;
        return this.mBatterySaverPolicy.setPolicyLevel(1);
    L11:
        return this.mBatterySaverPolicy.setPolicyLevel(0);
    }

    BatterySaverPolicyConfig getPolicyLocked(int policyLevel) {
        return this.mBatterySaverPolicy.getPolicyLocked(policyLevel).toConfig();
    }

    public boolean isEnabled() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (getFullEnabledLocked() == false) goto L7;
    L14:
        boolean r1 = true;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L7:
        if (getAdaptiveEnabledLocked() == true) goto L9;
    L13:
        r1 = false;
        goto L15
    L9:
        if (this.mBatterySaverPolicy.shouldAdvertiseIsEnabled() == false) goto L13;
        goto L13
    }

    private boolean isPolicyEnabled() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (getFullEnabledLocked() == true) goto L12;
        if (getAdaptiveEnabledLocked() == true) goto L12;
        boolean r1 = false;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L12:
        r1 = true;
        goto L13
    }

    boolean isFullEnabled() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = getFullEnabledLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean setFullPolicyLocked(BatterySaverPolicyConfig config, int reason) {
        return setFullPolicyLocked(BatterySaverPolicy.Policy.fromConfig(config), reason);
    }

    boolean setFullPolicyLocked(BatterySaverPolicy.Policy policy, int reason) {
        if (this.mBatterySaverPolicy.setFullPolicyLocked(policy) == false) goto L6;
        this.mHandler.postStateChanged(true, reason);
        return true;
    L6:
        return false;
    }

    boolean isAdaptiveEnabled() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = getAdaptiveEnabledLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean setAdaptivePolicyLocked(BatterySaverPolicyConfig config, int reason) {
        return setAdaptivePolicyLocked(BatterySaverPolicy.Policy.fromConfig(config), reason);
    }

    boolean setAdaptivePolicyLocked(BatterySaverPolicy.Policy policy, int reason) {
        if (this.mBatterySaverPolicy.setAdaptivePolicyLocked(policy) == false) goto L6;
        this.mHandler.postStateChanged(true, reason);
        return true;
    L6:
        return false;
    }

    boolean resetAdaptivePolicyLocked(int reason) {
        if (this.mBatterySaverPolicy.resetAdaptivePolicyLocked() == false) goto L6;
        this.mHandler.postStateChanged(true, reason);
        return true;
    L6:
        return false;
    }

    boolean setAdaptivePolicyEnabledLocked(boolean enabled, int reason) {
        if (getAdaptiveEnabledLocked() != enabled) goto L5;
        return false;
    L5:
        setAdaptiveEnabledLocked(enabled);
        if (updatePolicyLevelLocked() == false) goto L9;
        this.mHandler.postStateChanged(true, reason);
        return true;
    L9:
        return false;
    }

    public boolean isInteractive() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mIsInteractive;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public BatterySaverPolicy getBatterySaverPolicy() {
        return this.mBatterySaverPolicy;
    }

    public boolean isLaunchBoostDisabled() {
        if (isPolicyEnabled() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mBatterySaverPolicy.isLaunchBoostDisabled() == false) goto L7;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void handleBatterySaverStateChanged(boolean r12, int r13) {
        boolean r5 = getPowerManager().isInteractive();
        Object r8 = this.mLock;
        monitor-enter(r8);
    L52:
        th = th;
    L56:
        monitor-exit(r8);     // Catch: Throwable -> L52
        throw th;
    L54:
        th = th;
        goto L56
    L5:
        boolean r9 = true;
        int r10 = 0;
        if (getFullEnabledLocked() == false) goto L60;
    L13:
        Object[] r0 = true;
    L16:
        if (this.mFullPreviouslyEnabled == false) goto L18;
        int r1 = 1;
    L20:
        if (this.mAdaptivePreviouslyEnabled == false) goto L22;
        int r2 = 1;
    L24:
        if (getFullEnabledLocked() == false) goto L26;
        int r3 = 1;
    L27:
        boolean r4 = getAdaptiveEnabledLocked();     // Catch: Throwable -> L54
        if (r0 == false) goto L31;
        String r6 = this.mBatterySaverPolicy.toEventLogString();     // Catch: Throwable -> L11
    L33:
        EventLogTags.writeBatterySaverMode(r1, r2, r3, r4 ? 1 : 0, r5 ? 1 : 0, r6, r13);     // Catch: Throwable -> L52
        this.mFullPreviouslyEnabled = getFullEnabledLocked();     // Catch: Throwable -> L52
        this.mAdaptivePreviouslyEnabled = getAdaptiveEnabledLocked();     // Catch: Throwable -> L52
        PowerManagerInternal.LowPowerModeListener[] r14 = (PowerManagerInternal.LowPowerModeListener[]) this.mListeners.toArray(new PowerManagerInternal.LowPowerModeListener[0]);     // Catch: Throwable -> L52
        this.mIsInteractive = r5;     // Catch: Throwable -> L52
        monitor-exit(r8);     // Catch: Throwable -> L52
        PowerManagerInternal r7 = (PowerManagerInternal) LocalServices.getService(PowerManagerInternal.class);
        if (r7 == null) goto L38;
        r7.setPowerMode(1, isEnabled());
    L38:
        updateBatterySavingStats();
        if (r12 == false) goto L51;
        Slog.i(TAG, "Sending broadcasts for mode: " + isEnabled());
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "feature_phone_mode", 0) != 0) goto L44;
        r9 = false;
    L44:
        Intent r11 = new Intent("android.os.action.POWER_SAVE_MODE_CHANGED");
        r11.putExtra("feature_phone_mode", r9);
        r11.addFlags(128);
        r11.addFlags(1073741824);
        this.mContext.sendBroadcastAsUser(r11, UserHandle.ALL);
        if (getPowerSaveModeChangedListenerPackage().isPresent() == false) goto L47;
        this.mContext.sendBroadcastAsUser(new Intent("android.os.action.POWER_SAVE_MODE_CHANGED").setPackage(getPowerSaveModeChangedListenerPackage().get()).addFlags(AudioFormat.EVRCB), UserHandle.ALL);
    L47:
        Intent r15 = new Intent("android.os.action.POWER_SAVE_MODE_CHANGED_INTERNAL");
        r15.addFlags(1073741824);
        this.mContext.sendBroadcastAsUser(r15, UserHandle.ALL, "android.permission.DEVICE_POWER");
        int r16 = r14.length;
    L49:
        if (r10 >= r16) goto L63;
        PowerManagerInternal.LowPowerModeListener r17 = r14[r10];
        r17.onLowPowerModeChanged(this.mBatterySaverPolicy.getBatterySaverPolicy(r17.getServiceType()));
        r10 = r10 + 1;
        goto L49
    L63:
        return;
    L51:
        return;
    L11:
        th = th;
        goto L56
    L31:
        r6 = "";
        goto L33
    L26:
        r3 = 0;
        goto L27
    L22:
        r2 = 0;
        goto L24
    L18:
        r1 = 0;
        goto L20
    L60:
        if (getAdaptiveEnabledLocked() == true) goto L13;
        r0 = false;
        goto L16
    }

    private Optional<String> getPowerSaveModeChangedListenerPackage() {
        if (this.mPowerSaveModeChangedListenerPackage != null) goto L10;
        String configPowerSaveModeChangedListenerPackage = this.mContext.getString(R.string.config_vendorColorModesRestoreHint);
        if (((PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class)).isSystemPackage(configPowerSaveModeChangedListenerPackage) == false) goto L7;
        Optional<String> r1 = Optional.of(configPowerSaveModeChangedListenerPackage);
    L8:
        this.mPowerSaveModeChangedListenerPackage = r1;
        goto L10
    L7:
        r1 = Optional.empty();
    L10:
        return this.mPowerSaveModeChangedListenerPackage;
    }

    private void updateBatterySavingStats() {
        PowerManager pm = getPowerManager();
        if (pm != null) goto L6;
        Slog.wtf(TAG, "PowerManager not initialized");
        return;
    L6:
        boolean isInteractive = pm.isInteractive();
        int r3 = 2;
        int r4 = 0;
        if (pm.isDeviceIdleMode() == false) goto L10;
        int dozeMode = 2;
    L13:
        Object r6 = this.mLock;
        monitor-enter(r6);
        BatterySavingStats r7 = this.mBatterySavingStats;     // Catch: Throwable -> L31
        if (getFullEnabledLocked() == false) goto L19;
        r3 = 1;
    L22:
        if (isInteractive == false) goto L24;
        int r8 = 1;
    L26:
        if (this.mIsPluggedIn == false) goto L28;
        r4 = 1;
    L28:
        r7.transitionState(r3, r8, dozeMode, r4);     // Catch: Throwable -> L31
        monitor-exit(r6);     // Catch: Throwable -> L31
        return;
    L24:
        r8 = 0;
        goto L26
    L19:
        if (getAdaptiveEnabledLocked() == true) goto L22;
        r3 = 0;
    L31:
        th = move-exception;
        throw th;
    L10:
        if (pm.isLightDeviceIdleMode() == false) goto L12;
        dozeMode = 1;
        goto L13
    L12:
        dozeMode = 0;
        goto L13
    }

    private void setFullEnabledLocked(boolean value) {
        if (this.mFullEnabledRaw != value) goto L5;
        return;
    L5:
        PowerManager.invalidatePowerSaveModeCaches();
        this.mFullEnabledRaw = value;
    }

    private boolean getFullEnabledLocked() {
        return this.mFullEnabledRaw;
    }

    private void setAdaptiveEnabledLocked(boolean value) {
        if (this.mAdaptiveEnabledRaw != value) goto L5;
        return;
    L5:
        PowerManager.invalidatePowerSaveModeCaches();
        this.mAdaptiveEnabledRaw = value;
    }

    private boolean getAdaptiveEnabledLocked() {
        return this.mAdaptiveEnabledRaw;
    }
}
