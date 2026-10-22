package com.android.server;

import android.accounts.AccountManager;
import android.accounts.OnAccountsUpdateListener;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Binder;
import android.os.ITradeInMode;
import android.os.SystemProperties;
import android.provider.Settings;
import android.service.persistentdata.PersistentDataBlockManager;
import android.util.Slog;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/* JADX INFO: loaded from: classes.dex */
public final class TradeInModeService extends SystemService {
    private static final String TAG = "TradeInModeService";
    private static final String TIM_PROP = "persist.adb.tradeinmode";
    private static final int TIM_STATE_DISABLED = -1;
    private static final int TIM_STATE_EVALUATION_MODE = 2;
    private static final int TIM_STATE_FOYER = 1;
    private static final int TIM_STATE_UNSET = 0;
    private static final String TIM_TEST_PROP = "persist.adb.test_tradeinmode";
    private static final String WIPE_INDICATOR_FILE = "/metadata/tradeinmode/wipe";
    private AccountManager mAccountManager;
    private OnAccountsUpdateListener mAccountsListener;
    private ConnectivityManager mConnectivityManager;
    private final Context mContext;
    private ConnectivityManager.NetworkCallback mNetworkCallback;
    private TradeInMode mTradeInMode;

    private final class SettingsObserver extends ContentObserver {
        final /* synthetic */ TradeInModeService this$0;

        SettingsObserver(TradeInModeService r1) {
            this.this$0 = r1;
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            if (TradeInModeService.m419$$Nest$mgetTradeInModeState(this.this$0) == 1) goto L5;
            return;
        L5:
            if (TradeInModeService.m422$$Nest$misDeviceSetup(this.this$0) == false) goto L9;
            TradeInModeService.m431$$Nest$mstopTradeInMode(this.this$0);
            return;
        }
    }

    private final class TradeInMode extends ITradeInMode.Stub {
        final /* synthetic */ TradeInModeService this$0;

        /* synthetic */ TradeInMode(TradeInModeService r1, TradeInModeServiceIA r2) {
            this(r1);
        }

        private TradeInMode(TradeInModeService r1) {
            this.this$0 = r1;
        }

        public boolean start() {
            TradeInModeService.m417$$Nest$fgetmContext(this.this$0).enforceCallingOrSelfPermission("android.permission.ENTER_TRADE_IN_MODE", "Cannot enter trade-in mode foyer");
            int state = TradeInModeService.m419$$Nest$mgetTradeInModeState(this.this$0);
            if (state != 1) goto L6;
            return true;
        L6:
            if (state == 0) goto L10;
            Slog.e(TradeInModeService.TAG, "Cannot enter trade-in mode in state: " + state);
            return false;
        L10:
            if (TradeInModeService.m422$$Nest$misDeviceSetup(this.this$0) == false) goto L14;
            Slog.i(TradeInModeService.TAG, "Not starting trade-in mode, device is setup.");
            return false;
        L14:
            if (TradeInModeService.m421$$Nest$misDebuggable(this.this$0) == false) goto L20;
            if (TradeInModeService.m423$$Nest$misForceEnabledForTesting(this.this$0) == true) goto L23;
            Slog.e(TradeInModeService.TAG, "Not starting trade-in mode, device is debuggable.");
            return false;
        L23:
            long callingId = Binder.clearCallingIdentity();
            TradeInModeService.m430$$Nest$mstartTradeInMode(this.this$0);     // Catch: Throwable -> L27
            Binder.restoreCallingIdentity(callingId);
            return true;
        L27:
            th = move-exception;
            Binder.restoreCallingIdentity(callingId);
            throw th;
        L20:
            if (TradeInModeService.m420$$Nest$misAdbEnabled(this.this$0) == false) goto L23;
            Slog.e(TradeInModeService.TAG, "Not starting trade-in mode, adb is already enabled.");
            return false;
        }

        public boolean enterEvaluationMode() {
            TradeInModeService.m417$$Nest$fgetmContext(this.this$0).enforceCallingOrSelfPermission("android.permission.ENTER_TRADE_IN_MODE", "Cannot enter trade-in evaluation mode");
            int state = TradeInModeService.m419$$Nest$mgetTradeInModeState(this.this$0);
            if (state == 1) goto L7;
            Slog.e(TradeInModeService.TAG, "Cannot enter evaluation mode in state: " + state);
            return false;
        L7:
            if (TradeInModeService.m424$$Nest$misFrpActive(this.this$0) == false) goto L11;
            Slog.e(TradeInModeService.TAG, "Cannot enter evaluation mode, FRP lock is present.");
            return false;
        L11:
            if (TradeInModeService.m429$$Nest$mscheduleTradeInModeWipe(this.this$0) == true) goto L13;
            return false;
        L13:
            long callingId = Binder.clearCallingIdentity();
            TradeInModeService.m427$$Nest$mremoveNetworkWatch(this.this$0);     // Catch: Throwable -> L17
            TradeInModeService.m426$$Nest$mremoveAccountsWatch(this.this$0);     // Catch: Throwable -> L17
            Binder.restoreCallingIdentity(callingId);
            SystemProperties.set(TradeInModeService.TIM_PROP, Integer.toString(2));
            TradeInModeService.m428$$Nest$mrestartAdbd(this.this$0);
            return true;
        L17:
            th = move-exception;
            Binder.restoreCallingIdentity(callingId);
            throw th;
        }

        public boolean isEvaluationModeAllowed() {
            TradeInModeService.m417$$Nest$fgetmContext(this.this$0).enforceCallingOrSelfPermission("android.permission.ENTER_TRADE_IN_MODE", "Cannot test for trade-in evaluation mode allowed");
            return !TradeInModeService.m424$$Nest$misFrpActive(this.this$0);
        }

        public void scheduleWipeForTesting() {
            enforceTestingPermissions();
            TradeInModeService.m429$$Nest$mscheduleTradeInModeWipe(this.this$0);
        }

        public void startTesting() {
            enforceTestingPermissions();
            TradeInModeService.m418$$Nest$menterTestMode(this.this$0);
        }

        public void stopTesting() {
            enforceTestingPermissions();
            if (TradeInModeService.m423$$Nest$misForceEnabledForTesting(this.this$0) == false) goto L12;
            long callingId = Binder.clearCallingIdentity();
            TradeInModeService.m425$$Nest$mleaveTestMode(this.this$0);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(callingId);
            return;
        L8:
            th = move-exception;
            Binder.restoreCallingIdentity(callingId);
            throw th;
        L12:
            throw new IllegalStateException("testing must have been started");
        }

        public boolean isTesting() {
            enforceTestingPermissions();
            return TradeInModeService.m423$$Nest$misForceEnabledForTesting(this.this$0);
        }

        private void enforceTestingPermissions() {
            TradeInModeService.m417$$Nest$fgetmContext(this.this$0).enforceCallingOrSelfPermission("android.permission.ENTER_TRADE_IN_MODE", "Caller must have ENTER_TRADE_IN_MODE permission");
            if (TradeInModeService.m421$$Nest$misDebuggable(this.this$0) == false) goto L6;
            return;
        L6:
            throw new SecurityException("ro.debuggable must be set to 1");
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m417$$Nest$fgetmContext(TradeInModeService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$menterTestMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m418$$Nest$menterTestMode(TradeInModeService r0) {
        r0.enterTestMode();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetTradeInModeState, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m419$$Nest$mgetTradeInModeState(TradeInModeService r0) {
        return r0.getTradeInModeState();
    }

    /* JADX INFO: renamed from: -$$Nest$misAdbEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m420$$Nest$misAdbEnabled(TradeInModeService r0) {
        return r0.isAdbEnabled();
    }

    /* JADX INFO: renamed from: -$$Nest$misDebuggable, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m421$$Nest$misDebuggable(TradeInModeService r0) {
        return r0.isDebuggable();
    }

    /* JADX INFO: renamed from: -$$Nest$misDeviceSetup, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m422$$Nest$misDeviceSetup(TradeInModeService r0) {
        return r0.isDeviceSetup();
    }

    /* JADX INFO: renamed from: -$$Nest$misForceEnabledForTesting, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m423$$Nest$misForceEnabledForTesting(TradeInModeService r0) {
        return r0.isForceEnabledForTesting();
    }

    /* JADX INFO: renamed from: -$$Nest$misFrpActive, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m424$$Nest$misFrpActive(TradeInModeService r0) {
        return r0.isFrpActive();
    }

    /* JADX INFO: renamed from: -$$Nest$mleaveTestMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m425$$Nest$mleaveTestMode(TradeInModeService r0) {
        r0.leaveTestMode();
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveAccountsWatch, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m426$$Nest$mremoveAccountsWatch(TradeInModeService r0) {
        r0.removeAccountsWatch();
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveNetworkWatch, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m427$$Nest$mremoveNetworkWatch(TradeInModeService r0) {
        r0.removeNetworkWatch();
    }

    /* JADX INFO: renamed from: -$$Nest$mrestartAdbd, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m428$$Nest$mrestartAdbd(TradeInModeService r0) {
        r0.restartAdbd();
    }

    /* JADX INFO: renamed from: -$$Nest$mscheduleTradeInModeWipe, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m429$$Nest$mscheduleTradeInModeWipe(TradeInModeService r0) {
        return r0.scheduleTradeInModeWipe();
    }

    /* JADX INFO: renamed from: -$$Nest$mstartTradeInMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m430$$Nest$mstartTradeInMode(TradeInModeService r0) {
        r0.startTradeInMode();
    }

    /* JADX INFO: renamed from: -$$Nest$mstopTradeInMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m431$$Nest$mstopTradeInMode(TradeInModeService r0) {
        r0.stopTradeInMode();
    }

    public TradeInModeService(Context context) {
        super(context);
        this.mNetworkCallback = null;
        this.mAccountsListener = null;
        this.mContext = context;
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        this.mTradeInMode = new TradeInMode(this, null);
        publishBinderService("tradeinmode", this.mTradeInMode);
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 500) goto L26;
        int state = getTradeInModeState();
        if (isAdbEnabled() == false) goto L15;
        if (isDebuggable() == true) goto L15;
        if (isDeviceSetup() == true) goto L15;
        if (state != (-1)) goto L15;
        Slog.i(TAG, "Resetting trade-in mode state.");
        SystemProperties.set(TIM_PROP, "");
        ContentResolver cr = this.mContext.getContentResolver();
        Settings.Global.putInt(cr, "adb_enabled", 0);
        return;
    L15:
        if (state == 1) goto L17;
        return;
    L17:
        if (isDeviceSetup() == false) goto L20;
        stopTradeInMode();
        return;
    L20:
        if (isDebuggable() == true) goto L22;
    L24:
        watchForSetupCompletion();
        watchForNetworkChange();
        watchForAccountsCreated();
        return;
    L22:
        if (isForceEnabledForTesting() == true) goto L24;
        leaveTestMode();
        return;
    }

    private void startTradeInMode() {
        Slog.i(TAG, "Enabling trade-in mode.");
        SystemProperties.set(TIM_PROP, Integer.toString(1));
        setAdbEnabled(true);
        watchForSetupCompletion();
        watchForNetworkChange();
        watchForAccountsCreated();
    }

    private void stopTradeInMode() {
        Slog.i(TAG, "Stopping trade-in mode.");
        SystemProperties.set(TIM_PROP, Integer.toString(-1));
        removeNetworkWatch();
        removeAccountsWatch();
        if (isForceEnabledForTesting() == false) goto L5;
        restartAdbd();
        return;
    L5:
        setAdbEnabled(false);
    }

    private void enterTestMode() {
        SystemProperties.set(TIM_TEST_PROP, "1");
        SystemProperties.set(TIM_PROP, Integer.toString(1));
    }

    private void leaveTestMode() {
        if (getTradeInModeState() != 1) goto L5;
        stopTradeInMode();
    L5:
        SystemProperties.set(TIM_TEST_PROP, "");
        SystemProperties.set(TIM_PROP, "");
        Files.deleteIfExists(Paths.get(WIPE_INDICATOR_FILE, new String[0]));     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        Slog.e(TAG, "Failed to remove wipe indicator", e);
    }

    private boolean scheduleTradeInModeWipe() {
        FileWriter fw = new FileWriter(WIPE_INDICATOR_FILE, StandardCharsets.US_ASCII);     // Catch: IOException -> L7
        fw.write("0");     // Catch: Throwable -> L9
        fw.close();     // Catch: IOException -> L7
        return true;
    L9:
        th = move-exception;
        fw.close();     // Catch: Throwable -> L12
    L14:
        throw th;     // Catch: IOException -> L7
    L12:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L7
    L7:
        e = move-exception;
        Slog.e(TAG, "Failed to write /metadata/tradeinmode/wipe", e);
        return false;
    }

    private void restartAdbd() {
        SystemProperties.set("ctl.restart", "adbd");
    }

    private void setAdbEnabled(boolean r3) {
        Settings.Global.putInt(this.mContext.getContentResolver(), "adb_enabled", r3 ? 1 : 0);
    }

    private int getTradeInModeState() {
        return SystemProperties.getInt(TIM_PROP, 0);
    }

    private boolean isDebuggable() {
        if (SystemProperties.getInt("ro.debuggable", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private boolean isForceEnabledForTesting() {
        if (isDebuggable() == true) goto L5;
        return false;
    L5:
        if (SystemProperties.getInt(TIM_TEST_PROP, 0) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean isAdbEnabled() {
        ContentResolver cr = this.mContext.getContentResolver();
        if (Settings.Global.getInt(cr, "adb_enabled", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private boolean isFrpActive() {
        PersistentDataBlockManager pdb = (PersistentDataBlockManager) this.mContext.getSystemService(PersistentDataBlockManager.class);     // Catch: Exception -> L8
        if (pdb != null) goto L6;
        return false;
    L6:
        return pdb.isFactoryResetProtectionActive();
    L8:
        e = move-exception;
        Slog.e(TAG, "Could not read PDB", e);
        return false;
    }

    private boolean isDeviceSetup() {
        ContentResolver cr = this.mContext.getContentResolver();
        if (Settings.Secure.getIntForUser(cr, "user_setup_complete", 0) == 0) goto L10;
        return true;
    L10:
        if (Settings.Global.getInt(cr, "device_provisioned", 0) == 0) goto L12;
        return true;
    L12:
        return false;
    L7:
        e = move-exception;
        Slog.e(TAG, "Could not find USER_SETUP_COMPLETE setting", e);
        goto L10
    }

    private void watchForSetupCompletion() {
        Uri userSetupComplete = Settings.Secure.getUriFor("user_setup_complete");
        Uri deviceProvisioned = Settings.Global.getUriFor("device_provisioned");
        ContentResolver cr = this.mContext.getContentResolver();
        SettingsObserver observer = new SettingsObserver(this);
        cr.registerContentObserver(userSetupComplete, false, observer);
        cr.registerContentObserver(deviceProvisioned, false, observer);
    }

    private void watchForNetworkChange() {
        this.mConnectivityManager = (ConnectivityManager) this.mContext.getSystemService(ConnectivityManager.class);
        NetworkRequest networkRequest = new NetworkRequest.Builder().addCapability(12).addTransportType(1).addTransportType(0).build();
        this.mNetworkCallback = new AnonymousClass1(this);
        this.mConnectivityManager.registerNetworkCallback(networkRequest, this.mNetworkCallback);
    }

    private void removeNetworkWatch() {
        if (this.mNetworkCallback == null) goto L6;
        this.mConnectivityManager.unregisterNetworkCallback(this.mNetworkCallback);
        this.mNetworkCallback = null;
        return;
    }

    private void watchForAccountsCreated() {
        this.mAccountManager = (AccountManager) this.mContext.getSystemService(AccountManager.class);
        this.mAccountsListener = new AnonymousClass2(this);
        this.mAccountManager.addOnAccountsUpdatedListener(this.mAccountsListener, null, false);
    }

    private void removeAccountsWatch() {
        if (this.mAccountsListener == null) goto L6;
        this.mAccountManager.removeOnAccountsUpdatedListener(this.mAccountsListener);
        this.mAccountsListener = null;
        return;
    }
}
