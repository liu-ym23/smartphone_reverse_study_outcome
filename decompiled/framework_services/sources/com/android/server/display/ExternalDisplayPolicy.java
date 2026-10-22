package com.android.server.display;

import android.os.Build;
import android.os.Handler;
import android.os.IThermalEventListener;
import android.os.IThermalService;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.os.Temperature;
import android.util.Slog;
import com.android.server.display.feature.DisplayManagerFlags;
import com.android.server.display.notifications.DisplayNotificationManager;
import com.android.server.display.utils.DebugUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class ExternalDisplayPolicy {
    private static final boolean DEBUG = false;
    static final String ENABLE_ON_CONNECT = "persist.sys.display.enable_on_connect.external";
    private static final String TAG = "ExternalDisplayPolicy";
    private final Set<Integer> mDisplayIdsWaitingForBootCompletion;
    private final DisplayNotificationManager mDisplayNotificationManager;
    private final ExternalDisplayStatsService mExternalDisplayStatsService;
    private final DisplayManagerFlags mFlags;
    private final Handler mHandler;
    private final Injector mInjector;
    private boolean mIsBootCompleted;
    private final LogicalDisplayMapper mLogicalDisplayMapper;
    private volatile int mStatus;
    private final DisplayManagerService.SyncRoot mSyncRoot;

    interface Injector {
        DisplayNotificationManager getDisplayNotificationManager();

        ExternalDisplayStatsService getExternalDisplayStatsService();

        DisplayManagerFlags getFlags();

        Handler getHandler();

        LogicalDisplayMapper getLogicalDisplayMapper();

        DisplayManagerService.SyncRoot getSyncRoot();

        IThermalService getThermalService();

        void sendExternalDisplayEventLocked(LogicalDisplay r1, int r2);
    }

    private final class SkinThermalStatusObserver extends IThermalEventListener.Stub {
        final /* synthetic */ ExternalDisplayPolicy this$0;

        /* synthetic */ SkinThermalStatusObserver(ExternalDisplayPolicy r1, ExternalDisplayPolicyIA r2) {
            this(r1);
        }

        private SkinThermalStatusObserver(ExternalDisplayPolicy r1) {
            this.this$0 = r1;
        }

        public void notifyThrottling(Temperature temp) {
            int newStatus = temp.getStatus();
            int previousStatus = ExternalDisplayPolicy.m3801$$Nest$fgetmStatus(this.this$0);
            ExternalDisplayPolicy.m3802$$Nest$fputmStatus(this.this$0, newStatus);
            if (4 <= previousStatus) goto L7;
            if (4 > newStatus) goto L8;
            ExternalDisplayPolicy.m3803$$Nest$mdisableExternalDisplays(this.this$0);
            return;
        L8:
            return;
        }
    }

    public static /* synthetic */ void $r8$lambda$2e524ye28McdF74rNJXrAjDbcko(ExternalDisplayPolicy r0, LogicalDisplay r1) {
        r0.disableExternalDisplayLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStatus, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m3801$$Nest$fgetmStatus(ExternalDisplayPolicy r0) {
        return r0.mStatus;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmStatus, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3802$$Nest$fputmStatus(ExternalDisplayPolicy r0, int r1) {
        r0.mStatus = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mdisableExternalDisplays, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3803$$Nest$mdisableExternalDisplays(ExternalDisplayPolicy r0) {
        r0.disableExternalDisplays();
    }

    static {
        DEBUG = DebugUtils.isDebuggable(TAG);
    }

    static boolean isExternalDisplayLocked(LogicalDisplay logicalDisplay) {
        if (logicalDisplay.getDisplayInfoLocked().type != 2) goto L5;
        return true;
    L5:
        return false;
    }

    ExternalDisplayPolicy(Injector injector) {
        this.mStatus = 0;
        this.mDisplayIdsWaitingForBootCompletion = new HashSet();
        this.mInjector = injector;
        this.mLogicalDisplayMapper = this.mInjector.getLogicalDisplayMapper();
        this.mSyncRoot = this.mInjector.getSyncRoot();
        this.mFlags = this.mInjector.getFlags();
        this.mDisplayNotificationManager = this.mInjector.getDisplayNotificationManager();
        this.mHandler = this.mInjector.getHandler();
        this.mExternalDisplayStatsService = this.mInjector.getExternalDisplayStatsService();
    }

    void onBootCompleted() {
        DisplayManagerService.SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        this.mIsBootCompleted = true;     // Catch: Throwable -> L11
        Iterator<Integer> r1 = this.mDisplayIdsWaitingForBootCompletion.iterator();     // Catch: Throwable -> L11
    L7:
        if (r1.hasNext() == false) goto L15;
        Integer displayId = r1.next();     // Catch: Throwable -> L11
        LogicalDisplay logicalDisplay = this.mLogicalDisplayMapper.getDisplayLocked(displayId.intValue());     // Catch: Throwable -> L11
        if (logicalDisplay == null) goto L7;
        handleExternalDisplayConnectedLocked(logicalDisplay);     // Catch: Throwable -> L11
        goto L7
    L15:
        if (this.mDisplayIdsWaitingForBootCompletion.isEmpty() == true) goto L17;
        this.mLogicalDisplayMapper.updateLogicalDisplaysLocked();     // Catch: Throwable -> L11
    L17:
        this.mDisplayIdsWaitingForBootCompletion.clear();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        if (this.mFlags.isConnectedDisplayErrorHandlingEnabled() == true) goto L26;
        if (DEBUG == false) goto L36;
        Slog.d(TAG, "ConnectedDisplayErrorHandlingEnabled is not enabled on your device: cannot register thermal listener.");
        return;
    L36:
        return;
    L26:
        if (registerThermalServiceListener(new SkinThermalStatusObserver(this, null)) == true) goto L37;
        Slog.e(TAG, "Failed to register thermal listener");
        return;
    L37:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    void setExternalDisplayEnabledLocked(LogicalDisplay logicalDisplay, boolean enabled) {
        if (isExternalDisplayLocked(logicalDisplay) == true) goto L6;
        Slog.e(TAG, "setExternalDisplayEnabledLocked called for non external display");
        return;
    L6:
        if (enabled == true) goto L8;
    L11:
        this.mLogicalDisplayMapper.setDisplayEnabledLocked(logicalDisplay, enabled);
        return;
    L8:
        if (isExternalDisplayAllowed() == true) goto L11;
        Slog.w(TAG, "setExternalDisplayEnabledLocked: External display can not be enabled because it is currently not allowed.");
        Handler r0 = this.mHandler;
        DisplayNotificationManager r1 = this.mDisplayNotificationManager;
        r1.getClass();
        r0.post(new ExternalDisplayPolicy$$ExternalSyntheticLambda0(r1));
    }

    void handleExternalDisplayConnectedLocked(LogicalDisplay logicalDisplay) {
        if (isExternalDisplayLocked(logicalDisplay) == true) goto L7;
        Slog.e(TAG, "handleExternalDisplayConnectedLocked called for non-external display");
        return;
    L7:
        if (this.mIsBootCompleted == true) goto L10;
        this.mDisplayIdsWaitingForBootCompletion.add(Integer.valueOf(logicalDisplay.getDisplayIdLocked()));
        return;
    L10:
        this.mExternalDisplayStatsService.onDisplayConnected(logicalDisplay);
        if (Build.IS_ENG == true) goto L15;
        if (Build.IS_USERDEBUG == true) goto L15;
    L17:
        if (this.mFlags.isDisplayContentModeManagementEnabled() == true) goto L19;
    L21:
        this.mLogicalDisplayMapper.setEnabledLocked(logicalDisplay, false);
        if (isExternalDisplayAllowed() == true) goto L25;
        Slog.w(TAG, "handleExternalDisplayConnectedLocked: External display can not be used because it is currently not allowed.");
        Handler r0 = this.mHandler;
        DisplayNotificationManager r1 = this.mDisplayNotificationManager;
        r1.getClass();
        r0.post(new ExternalDisplayPolicy$$ExternalSyntheticLambda0(r1));
        return;
    L25:
        this.mInjector.sendExternalDisplayEventLocked(logicalDisplay, 6);
        if (DEBUG == false) goto L31;
        Slog.d(TAG, "handleExternalDisplayConnectedLocked complete displayId=" + logicalDisplay.getDisplayIdLocked());
        return;
    L31:
        return;
    L19:
        if (logicalDisplay.canHostTasksLocked() == false) goto L21;
    L29:
        Slog.w(TAG, "External display is enabled by default, bypassing user consent.");
        this.mInjector.sendExternalDisplayEventLocked(logicalDisplay, 6);
        return;
    L15:
        if (SystemProperties.getBoolean(ENABLE_ON_CONNECT, false) == true) goto L29;
        goto L29
    }

    void handleLogicalDisplayDisconnectedLocked(LogicalDisplay logicalDisplay) {
        int displayId = logicalDisplay.getDisplayIdLocked();
        if (this.mDisplayIdsWaitingForBootCompletion.remove(Integer.valueOf(displayId)) == false) goto L5;
        return;
    L5:
        this.mExternalDisplayStatsService.onDisplayDisconnected(displayId);
    }

    void handleLogicalDisplayAddedLocked(LogicalDisplay logicalDisplay) {
        if (isExternalDisplayLocked(logicalDisplay) == true) goto L5;
        return;
    L5:
        this.mExternalDisplayStatsService.onDisplayAdded(logicalDisplay.getDisplayIdLocked());
    }

    void onPresentation(int displayId, boolean isShown) {
        DisplayManagerService.SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        LogicalDisplay logicalDisplay = this.mLogicalDisplayMapper.getDisplayLocked(displayId);     // Catch: Throwable -> L14
        if (logicalDisplay == null) goto L16;
        if (isExternalDisplayLocked(logicalDisplay) == false) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L14
        if (isShown == false) goto L12;
        this.mExternalDisplayStatsService.onPresentationWindowAdded(displayId);
        return;
    L12:
        this.mExternalDisplayStatsService.onPresentationWindowRemoved(displayId);
        return;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private void disableExternalDisplayLocked(LogicalDisplay logicalDisplay) {
        if (isExternalDisplayLocked(logicalDisplay) == true) goto L6;
        return;
    L6:
        if (this.mFlags.isConnectedDisplayErrorHandlingEnabled() == true) goto L12;
        if (DEBUG == false) goto L24;
        Slog.d(TAG, "disableExternalDisplayLocked shouldn't be called when the error handling flag is off");
        return;
    L24:
        return;
    L12:
        if (logicalDisplay.isEnabledLocked() == true) goto L18;
        if (DEBUG == false) goto L25;
        Slog.d(TAG, "disableExternalDisplayLocked is not allowed: displayId=" + logicalDisplay.getDisplayIdLocked() + " isEnabledLocked=false");
        return;
    L25:
        return;
    L18:
        if (isExternalDisplayAllowed() == true) goto L20;
        Slog.w(TAG, "External display is currently not allowed and is getting disabled.");
        Handler r0 = this.mHandler;
        DisplayNotificationManager r2 = this.mDisplayNotificationManager;
        r2.getClass();
        r0.post(new ExternalDisplayPolicy$$ExternalSyntheticLambda0(r2));
    L20:
        this.mLogicalDisplayMapper.setDisplayEnabledLocked(logicalDisplay, false);
        this.mExternalDisplayStatsService.onDisplayDisabled(logicalDisplay.getDisplayIdLocked());
        if (DEBUG == false) goto L26;
        Slog.d(TAG, "disableExternalDisplayLocked complete displayId=" + logicalDisplay.getDisplayIdLocked());
        return;
    }

    boolean isExternalDisplayAllowed() {
        if (this.mStatus >= 4) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean registerThermalServiceListener(IThermalEventListener.Stub listener) {
        IThermalService thermalService = this.mInjector.getThermalService();
        if (thermalService != null) goto L16;
        Slog.w(TAG, "Could not observe thermal status. Service not available");
        return false;
    L16:
        thermalService.registerThermalEventListenerWithType(listener, 3);     // Catch: RemoteException -> L13
        if (DEBUG == false) goto L18;
        Slog.d(TAG, "registerThermalServiceListener complete.");
        return true;
    L18:
        return true;
    L13:
        e = move-exception;
        Slog.e(TAG, "Failed to register thermal status listener", e);
        return false;
    }

    private void disableExternalDisplays() {
        DisplayManagerService.SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        this.mLogicalDisplayMapper.forEachLocked(new ExternalDisplayPolicy$$ExternalSyntheticLambda1(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    boolean isDisplayReadyForMirroring(int displayId) {
        if (this.mFlags.isWaitingConfirmationBeforeMirroringEnabled() == false) goto L5;
        DisplayManagerService.SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L11:
        if (this.mIsBootCompleted == false) goto L13;
        LogicalDisplay logicalDisplay = this.mLogicalDisplayMapper.getDisplayLocked(displayId);     // Catch: Throwable -> L15
        if (logicalDisplay != null) goto L27;
        if (DEBUG == false) goto L24;
        Slog.d(TAG, "isDisplayReadyForMirroring: mirroring is not confirmed - logicalDisplay is null");     // Catch: Throwable -> L15
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return false;
    L27:
        if (isExternalDisplayLocked(logicalDisplay) == true) goto L34;
        if (DEBUG == false) goto L31;
        Slog.d(TAG, "isDisplayReadyForMirroring: mirroring is not confirmed - logicalDisplay" + logicalDisplay.getDisplayIdLocked() + " type is " + logicalDisplay.getDisplayInfoLocked().type);     // Catch: Throwable -> L15
    L31:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return false;
    L34:
        if (logicalDisplay.isEnabledLocked() == false) goto L36;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return true;
    L36:
        if (DEBUG == false) goto L38;
        Slog.d(TAG, "isDisplayReadyForMirroring: mirroring is not confirmed - logicalDisplay is disabled");     // Catch: Throwable -> L15
    L38:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return false;
    L13:
        if (DEBUG == false) goto L17;
        Slog.d(TAG, "isDisplayReadyForMirroring: mirroring is not confirmed - boot is in progress");     // Catch: Throwable -> L15
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return false;
    L5:
        if (DEBUG == false) goto L7;
        Slog.d(TAG, "isDisplayReadyForMirroring: mirroring CONFIRMED -  flag 'waiting for confirmation before mirroring' is disabled");
    L7:
        return true;
    }
}
