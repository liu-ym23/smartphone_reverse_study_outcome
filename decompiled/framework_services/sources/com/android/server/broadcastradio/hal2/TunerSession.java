package com.android.server.broadcastradio.hal2;

import android.graphics.Bitmap;
import android.hardware.broadcastradio.V2_0.ConfigFlag;
import android.hardware.broadcastradio.V2_0.ITunerSession;
import android.hardware.broadcastradio.V2_0.ProgramListChunk;
import android.hardware.radio.ITuner;
import android.hardware.radio.ITunerCallback;
import android.hardware.radio.ProgramList;
import android.hardware.radio.ProgramSelector;
import android.hardware.radio.RadioManager;
import android.net.INetd;
import android.os.RemoteException;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.MutableBoolean;
import android.util.MutableInt;
import com.android.server.UiModeManagerService;
import com.android.server.broadcastradio.RadioEventLogger;
import com.android.server.broadcastradio.RadioServiceUserController;
import com.android.server.utils.Slogf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class TunerSession extends ITuner.Stub {
    private static final String TAG = "BcRadio2Srv.session";
    private static final int TUNER_EVENT_LOGGER_QUEUE_SIZE = 25;
    final ITunerCallback mCallback;
    private RadioManager.BandConfig mDummyConfig;
    private final RadioEventLogger mEventLogger;
    private final ITunerSession mHwSession;
    private boolean mIsClosed;
    private boolean mIsMuted;
    private final Object mLock;
    private final RadioModule mModule;
    private ProgramInfoCache mProgramInfoCache;
    private final RadioServiceUserController mUserController;
    final int mUserId;

    public static /* synthetic */ void $r8$lambda$32HyT637mUFXYhXqQmwK1vi2lhc(RadioManager.BandConfig r0, ITunerCallback r1) {
        lambda$setConfiguration$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$R7hFKT2u1zS0hB99go57D3DzA_U(ITunerCallback r0) {
        lambda$startBackgroundScan$1(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$c--upVp1FJJb1PlFIL1p6tslYtE, reason: not valid java name */
    public static /* synthetic */ void m2847$r8$lambda$cupVp1FJJb1PlFIL1p6tslYtE(MutableInt r0, MutableBoolean r1, int r2, boolean r3) {
        lambda$isConfigFlagSet$2(r0, r1, r2, r3);
    }

    public static /* synthetic */ ArrayList $r8$lambda$nW3DtDUdEMMGaFUnNLuDT7YotH0(TunerSession r0, Map r1) {
        return r0.lambda$setParameters$3(r1);
    }

    public static /* synthetic */ ArrayList $r8$lambda$xirdvsyqNHa1wixy2_cdrMxtECE(TunerSession r0, List r1) {
        return r0.lambda$getParameters$4(r1);
    }

    TunerSession(RadioModule module, ITunerSession hwSession, ITunerCallback callback, RadioServiceUserController userController) {
        this.mLock = new Object();
        this.mIsClosed = false;
        this.mIsMuted = false;
        this.mProgramInfoCache = null;
        this.mDummyConfig = null;
        module.getClass();
        this.mModule = module;
        hwSession.getClass();
        this.mHwSession = hwSession;
        callback.getClass();
        this.mCallback = callback;
        userController.getClass();
        this.mUserController = userController;
        this.mUserId = this.mUserController.getCallingUserId();
        this.mEventLogger = new RadioEventLogger(TAG, 25);
    }

    public void close() {
        this.mEventLogger.logRadioEvent("Close", new Object[0]);
        close(null);
    }

    public void close(Integer error) {
        this.mEventLogger.logRadioEvent("Close on error %d", new Object[]{error});
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsClosed == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mIsClosed = true;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        if (error != null) goto L22;
    L17:
        this.mModule.onTunerSessionClosed(this);
        return;
    L22:
        this.mCallback.onError(error.intValue());     // Catch: RemoteException -> L15
    L15:
        ex = move-exception;
        Slogf.w(TAG, "mCallback.onError() failed: ", ex);
        goto L17
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
        Slogf.w(TAG, "Cannot set configuration for HAL 2.0 client from non-current user");
        return;
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosedLocked();     // Catch: Throwable -> L12
        config.getClass();     // Catch: Throwable -> L12
        this.mDummyConfig = config;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        Slogf.i(TAG, "Ignoring setConfiguration - not applicable for broadcastradio HAL 2.0");
        this.mModule.fanoutAidlCallback(new TunerSession$$ExternalSyntheticLambda4(config));
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$setConfiguration$0(RadioManager.BandConfig config, ITunerCallback cb) throws RemoteException {
        cb.onConfigurationChanged(config);
    }

    public RadioManager.BandConfig getConfiguration() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosedLocked();     // Catch: Throwable -> L7
        RadioManager.BandConfig r1 = this.mDummyConfig;     // Catch: Throwable -> L7
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
        Slogf.w(TAG, "Mute via RadioService is not implemented - please handle it via app");
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
        RadioEventLogger r0 = this.mEventLogger;
        if (directionDown == false) goto L5;
        String r2 = INetd.IF_STATE_DOWN;
    L6:
        if (skipSubChannel == false) goto L8;
        String r3 = UiModeManagerService.Shell.NIGHT_MODE_STR_YES;
    L9:
        r0.logRadioEvent("Step with direction %s, skipSubChannel?  %s", new Object[]{r2, r3});
        if (this.mUserController.isCurrentOrSystemUser() == true) goto L13;
        Slogf.w(TAG, "Cannot step on HAL 2.0 client from non-current user");
        return;
    L13:
        Object r1 = this.mLock;
        monitor-enter(r1);
        checkNotClosedLocked();     // Catch: Throwable -> L22
        ITunerSession r4 = this.mHwSession;     // Catch: Throwable -> L22
        if (directionDown == true) goto L18;
        boolean r5 = true;
    L19:
        int halResult = r4.step(r5);     // Catch: Throwable -> L22
        Convert.throwOnError("step", halResult);     // Catch: Throwable -> L22
        monitor-exit(r1);     // Catch: Throwable -> L22
        return;
    L18:
        r5 = false;
    L22:
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
        RadioEventLogger r0 = this.mEventLogger;
        if (directionDown == false) goto L5;
        String r2 = INetd.IF_STATE_DOWN;
    L6:
        if (skipSubChannel == false) goto L8;
        String r3 = UiModeManagerService.Shell.NIGHT_MODE_STR_YES;
    L9:
        r0.logRadioEvent("Seek with direction %s, skipSubChannel? %s", new Object[]{r2, r3});
        if (this.mUserController.isCurrentOrSystemUser() == true) goto L13;
        Slogf.w(TAG, "Cannot scan on HAL 2.0 client from non-current user");
        return;
    L13:
        Object r1 = this.mLock;
        monitor-enter(r1);
        checkNotClosedLocked();     // Catch: Throwable -> L22
        ITunerSession r4 = this.mHwSession;     // Catch: Throwable -> L22
        if (directionDown == true) goto L18;
        boolean r5 = true;
    L19:
        int halResult = r4.scan(r5, skipSubChannel);     // Catch: Throwable -> L22
        Convert.throwOnError("step", halResult);     // Catch: Throwable -> L22
        monitor-exit(r1);     // Catch: Throwable -> L22
        return;
    L18:
        r5 = false;
    L22:
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
        this.mEventLogger.logRadioEvent("Tune with selector %s", new Object[]{selector});
        if (this.mUserController.isCurrentOrSystemUser() == true) goto L6;
        Slogf.w(TAG, "Cannot tune on HAL 2.0 client from non-current user");
        return;
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosedLocked();     // Catch: Throwable -> L11
        int halResult = this.mHwSession.tune(Convert.programSelectorToHal(selector));     // Catch: Throwable -> L11
        Convert.throwOnError("tune", halResult);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void cancel() {
        Slogf.i(TAG, "Cancel");
        if (this.mUserController.isCurrentOrSystemUser() == true) goto L6;
        Slogf.w(TAG, "Cannot cancel on HAL 2.0 client from non-current user");
        return;
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosedLocked();     // Catch: Throwable -> L11
        final ITunerSession r1 = this.mHwSession;     // Catch: Throwable -> L11
        r1.getClass();     // Catch: Throwable -> L11
        Utils.maybeRethrow(new TunerSession$$ExternalSyntheticLambda5(r1));     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void cancelAnnouncement() {
        Slogf.w(TAG, "Announcements control doesn't involve cancelling at the HAL level in HAL 2.0");
    }

    public Bitmap getImage(int id) {
        this.mEventLogger.logRadioEvent("Get image for %d", new Object[]{Integer.valueOf(id)});
        return this.mModule.getImage(id);
    }

    public boolean startBackgroundScan() {
        Slogf.w(TAG, "Explicit background scan trigger is not supported with HAL 2.0");
        if (this.mUserController.isCurrentOrSystemUser() == true) goto L6;
        Slogf.w(TAG, "Cannot start background scan on HAL 2.0 client from non-current user");
        return false;
    L6:
        this.mModule.fanoutAidlCallback(new TunerSession$$ExternalSyntheticLambda1());
        return true;
    }

    private static /* synthetic */ void lambda$startBackgroundScan$1(ITunerCallback cb) throws RemoteException {
        cb.onBackgroundScanComplete();
    }

    public void startProgramListUpdates(ProgramList.Filter filter) {
        this.mEventLogger.logRadioEvent("start programList updates %s", new Object[]{filter});
        if (this.mUserController.isCurrentOrSystemUser() == true) goto L6;
        Slogf.w(TAG, "Cannot start program list updates on HAL 2.0 client from non-current user");
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
        Object r1 = this.mLock;
        monitor-enter(r1);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mProgramInfoCache != null) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L10:
        List<ProgramList.Chunk> clientUpdateChunks = this.mProgramInfoCache.filterAndApplyChunk(mergedChunk);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        dispatchClientUpdateChunks(clientUpdateChunks);
    }

    void updateProgramInfoFromHalCache(ProgramInfoCache halCache) {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mProgramInfoCache != null) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L10:
        List<ProgramList.Chunk> clientUpdateChunks = this.mProgramInfoCache.filterAndUpdateFrom(halCache, true);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        dispatchClientUpdateChunks(clientUpdateChunks);
    }

    private void dispatchClientUpdateChunks(List<ProgramList.Chunk> chunks) {
        if (chunks != null) goto L4;
        return;
    L4:
        Iterator<ProgramList.Chunk> r0 = chunks.iterator();
    L6:
        if (r0.hasNext() == false) goto L13;
        ProgramList.Chunk chunk = r0.next();
        this.mCallback.onProgramListUpdated(chunk);     // Catch: RemoteException -> L10
    L10:
        ex = move-exception;
        Slogf.w(TAG, "mCallback.onProgramListUpdated() failed: ", ex);
        goto L6
    }

    public void stopProgramListUpdates() throws RemoteException {
        this.mEventLogger.logRadioEvent("Stop programList updates", new Object[0]);
        if (this.mUserController.isCurrentOrSystemUser() == true) goto L6;
        Slogf.w(TAG, "Cannot stop program list updates on HAL 2.0 client from non-current user");
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
        this.mEventLogger.logRadioEvent("Is ConfigFlagSet for %s", new Object[]{ConfigFlag.toString(flag)});
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosedLocked();     // Catch: Throwable -> L9
        final MutableInt halResult = new MutableInt(1);     // Catch: Throwable -> L9
        final MutableBoolean flagState = new MutableBoolean(false);     // Catch: Throwable -> L9
        this.mHwSession.isConfigFlagSet(flag, new TunerSession$$ExternalSyntheticLambda0(halResult, flagState));     // Catch: Throwable -> L9 RemoteException -> L11
        Convert.throwOnError("isConfigFlagSet", halResult.value);     // Catch: Throwable -> L9
        boolean r3 = flagState.value;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L11:
        ex = move-exception;
        throw new RuntimeException("Failed to check flag " + ConfigFlag.toString(flag), ex);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$isConfigFlagSet$2(MutableInt halResult, MutableBoolean flagState, int result, boolean value) {
        halResult.value = result;
        flagState.value = value;
    }

    public void setConfigFlag(int flag, boolean value) throws RemoteException {
        this.mEventLogger.logRadioEvent("Set ConfigFlag  %s = %b", new Object[]{ConfigFlag.toString(flag), Boolean.valueOf(value)});
        if (this.mUserController.isCurrentOrSystemUser() == true) goto L6;
        Slogf.w(TAG, "Cannot set config flag for HAL 2.0 client from non-current user");
        return;
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosedLocked();     // Catch: Throwable -> L11
        int halResult = this.mHwSession.setConfigFlag(flag, value);     // Catch: Throwable -> L11
        Convert.throwOnError("setConfigFlag", halResult);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public Map<String, String> setParameters(final Map<String, String> parameters) {
        if (this.mUserController.isCurrentOrSystemUser() == true) goto L6;
        Slogf.w(TAG, "Cannot set parameters for HAL 2.0 client from non-current user");
        return new ArrayMap();
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosedLocked();     // Catch: Throwable -> L11
        Map<String, String> r1 = Convert.vendorInfoFromHal((List) Utils.maybeRethrow(new TunerSession$$ExternalSyntheticLambda2(this, parameters)));     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L11:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ ArrayList lambda$setParameters$3(Map parameters) throws RemoteException {
        return this.mHwSession.setParameters(Convert.vendorInfoToHal(parameters));
    }

    public Map<String, String> getParameters(final List<String> keys) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosedLocked();     // Catch: Throwable -> L7
        Map<String, String> r1 = Convert.vendorInfoFromHal((List) Utils.maybeRethrow(new TunerSession$$ExternalSyntheticLambda3(this, keys)));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ ArrayList lambda$getParameters$4(List keys) throws RemoteException {
        return this.mHwSession.getParameters(Convert.listToArrayList(keys));
    }

    void dumpInfo(IndentingPrintWriter pw) {
        pw.printf("TunerSession\n", new Object[0]);
        pw.increaseIndent();
        pw.printf("HIDL HAL Session: %s\n", new Object[]{this.mHwSession});
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
        pw.printf("Config: %s\n", new Object[]{this.mDummyConfig});     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        pw.printf("Tuner session events:\n", new Object[0]);
        pw.increaseIndent();
        this.mEventLogger.dump(pw);
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
