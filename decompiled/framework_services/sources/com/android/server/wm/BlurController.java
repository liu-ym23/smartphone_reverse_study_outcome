package com.android.server.wm;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.PowerManager;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.provider.Settings;
import android.view.CrossWindowBlurListeners;
import android.view.ICrossWindowBlurEnabledListener;
import android.view.TunnelModeEnabledListener;
import com.android.server.SystemServerInitThreadPool$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes3.dex */
final class BlurController {
    private boolean mBlurDisabledSetting;
    private volatile boolean mBlurEnabled;
    private final RemoteCallbackList<ICrossWindowBlurEnabledListener> mBlurEnabledListeners;
    private final Context mContext;
    private boolean mCriticalThermalStatus;
    private boolean mInPowerSaveMode;
    private final Object mLock;
    private boolean mTunnelModeEnabled;
    private TunnelModeEnabledListener mTunnelModeListener;

    public static /* synthetic */ void $r8$lambda$d37IvBCG5pB02WzIgDv5RCisrMc(BlurController r0, int r1) {
        r0.lambda$new$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fputmBlurDisabledSetting, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9844$$Nest$fputmBlurDisabledSetting(BlurController r0, boolean r1) {
        r0.mBlurDisabledSetting = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmInPowerSaveMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9845$$Nest$fputmInPowerSaveMode(BlurController r0, boolean r1) {
        r0.mInPowerSaveMode = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmTunnelModeEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9846$$Nest$fputmTunnelModeEnabled(BlurController r0, boolean r1) {
        r0.mTunnelModeEnabled = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetBlurDisabledSetting, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9847$$Nest$mgetBlurDisabledSetting(BlurController r0) {
        return r0.getBlurDisabledSetting();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateBlurEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9848$$Nest$mupdateBlurEnabled(BlurController r0) {
        r0.updateBlurEnabled();
    }

    BlurController(Context context, final PowerManager powerManager) {
        this.mBlurEnabledListeners = new RemoteCallbackList();
        this.mLock = new Object();
        boolean r0 = false;
        this.mTunnelModeEnabled = false;
        final SystemServerInitThreadPool$$ExternalSyntheticLambda0 r2 = new SystemServerInitThreadPool$$ExternalSyntheticLambda0();
        this.mTunnelModeListener = new AnonymousClass1(this, r2);
        this.mContext = context;
        IntentFilter filter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        filter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
        final Handler r3 = null;
        context.registerReceiverForAllUsers(new AnonymousClass2(this, powerManager), filter, null, null);
        this.mInPowerSaveMode = powerManager.isPowerSaveMode();
        context.getContentResolver().registerContentObserver(Settings.Global.getUriFor("disable_window_blurs"), false, new AnonymousClass3(this, r3));
        this.mBlurDisabledSetting = getBlurDisabledSetting();
        powerManager.addThermalStatusListener(new BlurController$$ExternalSyntheticLambda0(this));
        if (powerManager.getCurrentThermalStatus() < 4) goto L5;
        r0 = true;
    L5:
        this.mCriticalThermalStatus = r0;
        TunnelModeEnabledListener.register(this.mTunnelModeListener);
        updateBlurEnabled();
    }

    private /* synthetic */ void lambda$new$0(int status) {
        if (status < 4) goto L5;
        boolean r0 = true;
    L6:
        this.mCriticalThermalStatus = r0;
        updateBlurEnabled();
        return;
    L5:
        r0 = false;
        goto L6
    }

    boolean registerCrossWindowBlurEnabledListener(ICrossWindowBlurEnabledListener listener) {
        if (listener != null) goto L5;
        return false;
    L5:
        this.mBlurEnabledListeners.register(listener);
        return getBlurEnabled();
    }

    void unregisterCrossWindowBlurEnabledListener(ICrossWindowBlurEnabledListener listener) {
        if (listener != null) goto L4;
        return;
    L4:
        this.mBlurEnabledListeners.unregister(listener);
    }

    boolean getBlurEnabled() {
        return this.mBlurEnabled;
    }

    private void updateBlurEnabled() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (CrossWindowBlurListeners.CROSS_WINDOW_BLUR_SUPPORTED == true) goto L7;
    L17:
        boolean newEnabled = false;
    L19:
        if (this.mBlurEnabled != newEnabled) goto L22;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L22:
        this.mBlurEnabled = newEnabled;     // Catch: Throwable -> L15
        notifyBlurEnabledChangedLocked(newEnabled);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L7:
        if (this.mBlurDisabledSetting == true) goto L17;
        if (this.mInPowerSaveMode == true) goto L17;
        if (this.mTunnelModeEnabled == true) goto L17;
        if (this.mCriticalThermalStatus == true) goto L17;
        newEnabled = true;
        goto L19
    }

    private void notifyBlurEnabledChangedLocked(boolean enabled) {
        int i = this.mBlurEnabledListeners.beginBroadcast();
    L3:
        if (i <= 0) goto L9;
        i = i - 1;
        ICrossWindowBlurEnabledListener listener = this.mBlurEnabledListeners.getBroadcastItem(i);
        listener.onCrossWindowBlurEnabledChanged(enabled);     // Catch: RemoteException -> L7
        goto L3
    L9:
        this.mBlurEnabledListeners.finishBroadcast();
    }

    private boolean getBlurDisabledSetting() {
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "disable_window_blurs", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }
}
