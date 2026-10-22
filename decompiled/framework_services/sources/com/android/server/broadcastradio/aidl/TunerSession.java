package com.android.server.broadcastradio.aidl;

import android.graphics.Bitmap;
import android.hardware.broadcastradio.ConfigFlag$$;
import android.hardware.broadcastradio.IBroadcastRadio;
import android.hardware.broadcastradio.ProgramListChunk;
import android.hardware.radio.ITuner;
import android.hardware.radio.ITunerCallback;
import android.hardware.radio.ProgramList;
import android.hardware.radio.ProgramSelector;
import android.hardware.radio.RadioManager;
import android.net.INetd;
import android.os.Binder;
import android.os.RemoteException;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import com.android.server.UiModeManagerService;
import com.android.server.broadcastradio.RadioEventLogger;
import com.android.server.broadcastradio.RadioServiceUserController;
import com.android.server.utils.Slogf;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class TunerSession extends ITuner.Stub {
    private static final String TAG = "BcRadioAidlSrv.session";
    private static final int TUNER_EVENT_LOGGER_QUEUE_SIZE = 25;
    final ITunerCallback mCallback;
    private boolean mIsClosed;
    private boolean mIsMuted;
    private final Object mLock;
    private final RadioEventLogger mLogger;
    private final RadioModule mModule;
    private RadioManager.BandConfig mPlaceHolderConfig;
    private ProgramInfoCache mProgramInfoCache;
    private final IBroadcastRadio mService;
    private final int mUid;
    private final RadioServiceUserController mUserController;
    final int mUserId;

    public static /* synthetic */ void $r8$lambda$CIUKhrpSA7HPy1Rs0PJCplnlDFI(ITunerCallback r0, int r1) {
        lambda$startBackgroundScan$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$LlRb_mmthzoz62ea7FJI-33v0jw, reason: not valid java name */
    public static /* synthetic */ void m2815$r8$lambda$LlRb_mmthzoz62ea7FJI33v0jw(RadioManager.BandConfig r0, ITunerCallback r1, int r2) {
        lambda$setConfiguration$0(r0, r1, r2);
    }

    TunerSession(RadioModule radioModule, IBroadcastRadio service, ITunerCallback callback, RadioServiceUserController userController) {
        this.mLock = new Object();
        radioModule.getClass();
        this.mModule = radioModule;
        service.getClass();
        this.mService = service;
        callback.getClass();
        this.mCallback = callback;
        userController.getClass();
        this.mUserController = userController;
        this.mUserId = this.mUserController.getCallingUserId();
        this.mUid = Binder.getCallingUid();
        this.mLogger = new RadioEventLogger(TAG, 25);
    }

    public void close() {
        this.mLogger.logRadioEvent("Close tuner", new Object[0]);
        close(null);
    }

    public void close(Integer error) {
        if (error != null) goto L4;
        this.mLogger.logRadioEvent("Close tuner session on error null", new Object[0]);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L8:
        if (this.mIsClosed == false) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L13:
        this.mIsClosed = true;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        if (error != null) goto L25;
    L20:
        this.mModule.onTunerSessionClosed(this);
        return;
    L25:
        this.mCallback.onError(error.intValue());     // Catch: RemoteException -> L18
    L18:
        ex = move-exception;
        Slogf.w(TAG, ex, "mCallback.onError(%s) failed", new Object[]{error});
        goto L20
    L4:
        this.mLogger.logRadioEvent("Close tuner session on error %d", new Object[]{error});
        goto L5
    }

    public boolean isClosed() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mIsClosed;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void checkNotClosedLocked() {
        if (this.mIsClosed == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("Tuner is closed, no further operations are allowed");
    }

    public void setConfiguration(final RadioManager.BandConfig config) {
        if (this.mUserController.isCurrentOrSystemUser() == true) goto L6;
        Slogf.w(TAG, "Cannot set configuration for AIDL HAL client from non-current user");
        return;
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosedLocked();     // Catch: Throwable -> L12
        config.getClass();     // Catch: Throwable -> L12
        this.mPlaceHolderConfig = config;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        Slogf.i(TAG, "Ignoring setConfiguration - not applicable for broadcastradio HAL AIDL");
        this.mModule.fanoutAidlCallback(new TunerSession$$ExternalSyntheticLambda1(config));
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$setConfiguration$0(RadioManager.BandConfig config, ITunerCallback cb, int mUid) throws RemoteException {
        cb.onConfigurationChanged(config);
    }

    public RadioManager.BandConfig getConfiguration() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosedLocked();     // Catch: Throwable -> L7
        RadioManager.BandConfig r1 = this.mPlaceHolderConfig;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void setMuted(boolean mute) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosedLocked();     // Catch: Throwable -> L8
        if (this.mIsMuted != mute) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mIsMuted = mute;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        Slogf.w(TAG, "Mute %b via RadioService is not implemented - please handle it via app", new Object[]{Boolean.valueOf(mute)});
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean isMuted() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosedLocked();     // Catch: Throwable -> L7
        boolean r1 = this.mIsMuted;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void step(boolean directionDown, boolean skipSubChannel) throws RemoteException {
        RadioEventLogger r0 = this.mLogger;
        if (directionDown == false) goto L5;
        String r2 = INetd.IF_STATE_DOWN;
    L6:
        if (skipSubChannel == false) goto L8;
        String r3 = UiModeManagerService.Shell.NIGHT_MODE_STR_YES;
    L9:
        r0.logRadioEvent("Step with direction %s, skipSubChannel?  %s", new Object[]{r2, r3});
        if (this.mUserController.isCurrentOrSystemUser() == true) goto L13;
        Slogf.w(TAG, "Cannot step on AIDL HAL client from non-current user");
        return;
    L13:
        Object r1 = this.mLock;
        monitor-enter(r1);
        checkNotClosedLocked();     // Catch: Throwable -> L23
        IBroadcastRadio r4 = this.mService;     // Catch: Throwable -> L23 RuntimeException -> L25
        if (directionDown == true) goto L19;
        boolean r5 = true;
    L20:
        r4.step(r5);     // Catch: Throwable -> L23 RuntimeException -> L25
        monitor-exit(r1);     // Catch: Throwable -> L23
        return;
    L19:
        r5 = false;
    L25:
        ex = move-exception;
        throw ConversionUtils.throwOnError(ex, "step");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    L8:
        r3 = UiModeManagerService.Shell.NIGHT_MODE_STR_NO;
        goto L9
    L5:
        r2 = INetd.IF_STATE_UP;
        goto L6
    }

    public void seek(boolean directionDown, boolean skipSubChannel) throws RemoteException {
        RadioEventLogger r0 = this.mLogger;
        if (directionDown == false) goto L5;
        String r2 = INetd.IF_STATE_DOWN;
    L6:
        if (skipSubChannel == false) goto L8;
        String r3 = UiModeManagerService.Shell.NIGHT_MODE_STR_YES;
    L9:
        r0.logRadioEvent("Seek with direction %s, skipSubChannel? %s", new Object[]{r2, r3});
        if (this.mUserController.isCurrentOrSystemUser() == true) goto L13;
        Slogf.w(TAG, "Cannot scan on AIDL HAL client from non-current user");
        return;
    L13:
        Object r1 = this.mLock;
        monitor-enter(r1);
        checkNotClosedLocked();     // Catch: Throwable -> L23
        IBroadcastRadio r4 = this.mService;     // Catch: Throwable -> L23 RuntimeException -> L25
        if (directionDown == true) goto L19;
        boolean r5 = true;
    L20:
        r4.seek(r5, skipSubChannel);     // Catch: Throwable -> L23 RuntimeException -> L25
        monitor-exit(r1);     // Catch: Throwable -> L23
        return;
    L19:
        r5 = false;
    L25:
        ex = move-exception;
        throw ConversionUtils.throwOnError(ex, "seek");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    L8:
        r3 = UiModeManagerService.Shell.NIGHT_MODE_STR_NO;
        goto L9
    L5:
        r2 = INetd.IF_STATE_UP;
        goto L6
    }

    public void tune(ProgramSelector selector) throws RemoteException {
        this.mLogger.logRadioEvent("Tune with selector %s", new Object[]{selector});
        if (this.mUserController.isCurrentOrSystemUser() == true) goto L6;
        Slogf.w(TAG, "Cannot tune on AIDL HAL client from non-current user");
        return;
    L6:
        android.hardware.broadcastradio.ProgramSelector hwSel = ConversionUtils.programSelectorToHalProgramSelector(selector);
        if (hwSel == null) goto L22;
        Object r1 = this.mLock;
        monitor-enter(r1);
        checkNotClosedLocked();     // Catch: Throwable -> L14
        this.mService.tune(hwSel);     // Catch: Throwable -> L14 RuntimeException -> L16
        monitor-exit(r1);     // Catch: Throwable -> L14
        return;
    L16:
        ex = move-exception;
        throw ConversionUtils.throwOnError(ex, "tune");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    L22:
        throw new IllegalArgumentException("tune: INVALID_ARGUMENTS for program selector");
    }

    public void cancel() {
        Slogf.i(TAG, "Cancel");
        if (this.mUserController.isCurrentOrSystemUser() == true) goto L6;
        Slogf.w(TAG, "Cannot cancel on AIDL HAL client from non-current user");
        return;
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosedLocked();     // Catch: Throwable -> L12
        this.mService.cancel();     // Catch: Throwable -> L12 RemoteException -> L14
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L14:
        ex = move-exception;
        Slogf.e(TAG, "Failed to cancel tuner session");     // Catch: Throwable -> L12
        throw ex.rethrowFromSystemServer();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public void cancelAnnouncement() {
        Slogf.w(TAG, "Announcements control doesn't involve cancelling at the HAL level in AIDL");
    }

    public Bitmap getImage(int id) {
        this.mLogger.logRadioEvent("Get image for %d", new Object[]{Integer.valueOf(id)});
        return this.mModule.getImage(id);
    }

    public boolean startBackgroundScan() {
        Slogf.w(TAG, "Explicit background scan trigger is not supported with HAL AIDL");
        if (this.mUserController.isCurrentOrSystemUser() == true) goto L6;
        Slogf.w(TAG, "Cannot start background scan on AIDL HAL client from non-current user");
        return false;
    L6:
        this.mModule.fanoutAidlCallback(new TunerSession$$ExternalSyntheticLambda0());
        return true;
    }

    private static /* synthetic */ void lambda$startBackgroundScan$1(ITunerCallback cb, int mUid) throws RemoteException {
        cb.onBackgroundScanComplete();
    }

    public void startProgramListUpdates(ProgramList.Filter filter) throws RemoteException {
        this.mLogger.logRadioEvent("Start programList updates %s", new Object[]{filter});
        if (this.mUserController.isCurrentOrSystemUser() == true) goto L6;
        Slogf.w(TAG, "Cannot start program list updates on AIDL HAL client from non-current user");
        return;
    L6:
        if (filter != null) goto L8;
        filter = new ProgramList.Filter(new ArraySet(), new ArraySet(), true, false);
    L8:
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosedLocked();     // Catch: Throwable -> L14
        this.mProgramInfoCache = new ProgramInfoCache(filter);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        this.mModule.onTunerSessionProgramListFilterChanged(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    int getUid() {
        return this.mUid;
    }

    ProgramList.Filter getProgramListFilter() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mProgramInfoCache != null) goto L7;
        ProgramList.Filter r1 = null;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = this.mProgramInfoCache.getFilter();     // Catch: Throwable -> L10
        goto L8
    }

    void onMergedProgramListUpdateFromHal(ProgramListChunk mergedChunk) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mProgramInfoCache != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        List<ProgramList.Chunk> clientUpdateChunks = this.mProgramInfoCache.filterAndApplyChunk(mergedChunk);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        dispatchClientUpdateChunks(clientUpdateChunks);
    }

    void updateProgramInfoFromHalCache(ProgramInfoCache halCache) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mProgramInfoCache != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        List<ProgramList.Chunk> clientUpdateChunks = this.mProgramInfoCache.filterAndUpdateFromInternal(halCache, true);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        dispatchClientUpdateChunks(clientUpdateChunks);
    }

    private void dispatchClientUpdateChunks(List<ProgramList.Chunk> chunks) {
        if (chunks != null) goto L4;
        return;
    L4:
        int i = 0;
    L6:
        if (i >= chunks.size()) goto L17;
        if (ConversionUtils.isAtLeastU(getUid()) == true) goto L12;
        ProgramList.Chunk downgradedChunk = ConversionUtils.convertChunkToTargetSdkVersion(chunks.get(i), getUid());     // Catch: RemoteException -> L10
        this.mCallback.onProgramListUpdated(downgradedChunk);     // Catch: RemoteException -> L10
    L15:
        i = i + 1;
        goto L6
    L12:
        this.mCallback.onProgramListUpdated(chunks.get(i));     // Catch: RemoteException -> L10
    L10:
        ex = move-exception;
        Slogf.w(TAG, ex, "mCallback.onProgramListUpdated() failed", new Object[0]);
        goto L15
    }

    public void stopProgramListUpdates() throws RemoteException {
        this.mLogger.logRadioEvent("Stop programList updates", new Object[0]);
        if (this.mUserController.isCurrentOrSystemUser() == true) goto L6;
        Slogf.w(TAG, "Cannot stop program list updates on AIDL HAL client from non-current user");
        return;
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosedLocked();     // Catch: Throwable -> L12
        this.mProgramInfoCache = null;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        this.mModule.onTunerSessionProgramListFilterChanged(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public boolean isConfigFlagSupported(int flag) {
        isConfigFlagSet(flag);     // Catch: Throwable -> L5
        return true;
    L6:
        return false;
    }

    public boolean isConfigFlagSet(int flag) {
        this.mLogger.logRadioEvent("is ConfigFlag %s set? ", new Object[]{ConfigFlag$$.toString(flag)});
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosedLocked();     // Catch: Throwable -> L8
        boolean r1 = this.mService.isConfigFlagSet(flag);     // Catch: Throwable -> L8 RemoteException -> L10 RuntimeException -> L12
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r1;
    L10:
        ex = move-exception;
        throw new RuntimeException("Failed to check flag " + ConfigFlag$$.toString(flag), ex);     // Catch: Throwable -> L8
    L12:
        ex = move-exception;
        throw ConversionUtils.throwOnError(ex, "isConfigFlagSet");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public void setConfigFlag(int flag, boolean value) throws RemoteException {
        this.mLogger.logRadioEvent("set ConfigFlag %s to %b ", new Object[]{ConfigFlag$$.toString(flag), Boolean.valueOf(value)});
        if (this.mUserController.isCurrentOrSystemUser() == true) goto L6;
        Slogf.w(TAG, "Cannot set config flag for AIDL HAL client from non-current user");
        return;
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosedLocked();     // Catch: Throwable -> L12
        this.mService.setConfigFlag(flag, value);     // Catch: Throwable -> L12 RuntimeException -> L14
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L14:
        ex = move-exception;
        throw ConversionUtils.throwOnError(ex, "setConfigFlag");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public Map<String, String> setParameters(Map<String, String> parameters) {
        this.mLogger.logRadioEvent("Set parameters ", new Object[0]);
        if (this.mUserController.isCurrentOrSystemUser() == true) goto L6;
        Slogf.w(TAG, "Cannot set parameters for AIDL HAL client from non-current user");
        return new ArrayMap();
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosedLocked();     // Catch: Throwable -> L12
        Map<String, String> r1 = ConversionUtils.vendorInfoFromHalVendorKeyValues(this.mService.setParameters(ConversionUtils.vendorInfoToHalVendorKeyValues(parameters)));     // Catch: Throwable -> L12 RemoteException -> L14
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r1;
    L14:
        ex = move-exception;
        throw ex.rethrowFromSystemServer();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public Map<String, String> getParameters(List<String> keys) {
        this.mLogger.logRadioEvent("Get parameters ", new Object[0]);
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosedLocked();     // Catch: Throwable -> L8
        Map<String, String> r1 = ConversionUtils.vendorInfoFromHalVendorKeyValues(this.mService.getParameters((String[]) keys.toArray(new String[0])));     // Catch: Throwable -> L8 RemoteException -> L10
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r1;
    L10:
        ex = move-exception;
        throw ex.rethrowFromSystemServer();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    void dumpInfo(IndentingPrintWriter pw) {
        pw.printf("TunerSession\n", new Object[0]);
        pw.increaseIndent();
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsClosed == false) goto L9;
        String r3 = "Yes";
    L10:
        pw.printf("Is session closed? %s\n", new Object[]{r3});     // Catch: Throwable -> L7
        if (this.mIsMuted == false) goto L13;
        String r4 = "Yes";
    L14:
        pw.printf("Is muted? %s\n", new Object[]{r4});     // Catch: Throwable -> L7
        pw.printf("ProgramInfoCache: %s\n", new Object[]{this.mProgramInfoCache});     // Catch: Throwable -> L7
        pw.printf("Config: %s\n", new Object[]{this.mPlaceHolderConfig});     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        pw.printf("Tuner session events:\n", new Object[0]);
        pw.increaseIndent();
        this.mLogger.dump(pw);
        pw.decreaseIndent();
        pw.decreaseIndent();
        return;
    L13:
        r4 = "No";
        goto L14
    L9:
        r3 = "No";
        goto L10
    }
}
