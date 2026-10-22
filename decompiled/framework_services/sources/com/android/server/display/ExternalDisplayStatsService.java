package com.android.server.display;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioPlaybackConfiguration;
import android.os.Handler;
import android.os.PowerManager;
import android.util.Slog;
import android.util.SparseIntArray;
import android.view.DisplayInfo;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.display.utils.DebugUtils;
import com.android.server.job.controllers.JobStatus;
import java.util.Iterator;
import java.util.List;
import java.util.function.BooleanSupplier;

/* JADX INFO: loaded from: classes2.dex */
public final class ExternalDisplayStatsService {
    private static final int AUDIO_SINK_CHANGED = 10;
    private static final int CONNECTED_STATE = 2;
    private static final boolean DEBUG = false;
    private static final int DISABLED_STATE = 3;
    private static final int DISCONNECTED_STATE = 1;
    private static final int ERROR_CABLE_NOT_CAPABLE_DISPLAYPORT = 13;
    private static final int ERROR_DISPLAYPORT_LINK_FAILED = 12;
    private static final int ERROR_HOTPLUG_CONNECTION = 11;
    private static final int EXTENDED_STATE = 6;
    private static final int INVALID_DISPLAYS_COUNT = -1;
    private static final int KEYGUARD = 4;
    private static final int MIRRORING_STATE = 5;
    private static final int PRESENTATION_ENDED = 9;
    private static final int PRESENTATION_WHILE_EXTENDED = 8;
    private static final int PRESENTATION_WHILE_MIRRORING = 7;
    private static final String TAG = "ExternalDisplayStatsService";
    private final AudioManager.AudioPlaybackCallback mAudioPlaybackCallback;
    private final SparseIntArray mExternalDisplayStates;
    private final Injector mInjector;
    private int mInteractiveExternalDisplays;
    private final BroadcastReceiver mInteractivityReceiver;
    private boolean mIsExternalDisplayUsedForAudio;
    private boolean mIsInitialized;

    /* JADX INFO: renamed from: com.android.server.display.ExternalDisplayStatsService$1, reason: invalid class name */
    class AnonymousClass1 extends AudioManager.AudioPlaybackCallback {
        private final Runnable mLogStateAfterAudioSinkDisabled;
        private final Runnable mLogStateAfterAudioSinkEnabled;
        final /* synthetic */ ExternalDisplayStatsService this$0;

        /* JADX INFO: renamed from: $r8$lambda$Cj-EJU6YsGBJ9rKOhbSxbmOtcW8, reason: not valid java name */
        public static /* synthetic */ void m3814$r8$lambda$CjEJU6YsGBJ9rKOhbSxbmOtcW8(AnonymousClass1 r0) {
            r0.lambda$$1();
        }

        /* JADX INFO: renamed from: $r8$lambda$tcwJoo-_exI5c_sLDvuHlIXb8y0, reason: not valid java name */
        public static /* synthetic */ void m3815$r8$lambda$tcwJoo_exI5c_sLDvuHlIXb8y0(AnonymousClass1 r0) {
            r0.lambda$$0();
        }

        AnonymousClass1(ExternalDisplayStatsService this$0) {
            this.this$0 = this$0;
            this.mLogStateAfterAudioSinkEnabled = new ExternalDisplayStatsService$1$$ExternalSyntheticLambda0(this);
            this.mLogStateAfterAudioSinkDisabled = new ExternalDisplayStatsService$1$$ExternalSyntheticLambda1(this);
        }

        private /* synthetic */ void lambda$$0() {
            ExternalDisplayStatsService.m3812$$Nest$mlogStateAfterAudioSinkChanged(this.this$0, true);
        }

        private /* synthetic */ void lambda$$1() {
            ExternalDisplayStatsService.m3812$$Nest$mlogStateAfterAudioSinkChanged(this.this$0, false);
        }

        @Override // android.media.AudioManager.AudioPlaybackCallback
        public void onPlaybackConfigChanged(List<AudioPlaybackConfiguration> configs) {
            super.onPlaybackConfigChanged(configs);
            scheduleAudioSinkChange(isExternalDisplayUsedForAudio(configs));
        }

        private boolean isExternalDisplayUsedForAudio(List<AudioPlaybackConfiguration> configs) {
            Iterator<AudioPlaybackConfiguration> r0 = configs.iterator();
        L4:
            if (r0.hasNext() == false) goto L26;
            AudioPlaybackConfiguration config = r0.next();
            AudioDeviceInfo info = config.getAudioDeviceInfo();
            if (config.isActive() == false) goto L22;
            if (info == null) goto L22;
            if (info.isSink() == false) goto L22;
            if (info.getType() == 9) goto L17;
            if (info.getType() == 10) goto L17;
            if (info.getType() != 11) goto L22;
        L17:
            if (ExternalDisplayStatsService.m3813$$Nest$sfgetDEBUG() == false) goto L38;
            Slog.d(ExternalDisplayStatsService.TAG, "isExternalDisplayUsedForAudio: use " + info.getProductName() + " isActive=" + config.isActive() + " isSink=" + info.isSink() + " type=" + info.getType());
            return true;
        L38:
            return true;
        L22:
            if (ExternalDisplayStatsService.m3813$$Nest$sfgetDEBUG() == false) goto L4;
            if (info == null) goto L4;
            Slog.d(ExternalDisplayStatsService.TAG, "isExternalDisplayUsedForAudio: drop " + info.getProductName() + " isActive=" + config.isActive() + " isSink=" + info.isSink() + " type=" + info.getType());
            goto L4
        L26:
            return false;
        }

        private void scheduleAudioSinkChange(boolean isAudioOnExternalDisplay) {
            if (ExternalDisplayStatsService.m3813$$Nest$sfgetDEBUG() == false) goto L5;
            Slog.d(ExternalDisplayStatsService.TAG, "scheduleAudioSinkChange: mIsExternalDisplayUsedForAudio=" + ExternalDisplayStatsService.m3808$$Nest$fgetmIsExternalDisplayUsedForAudio(this.this$0) + " isAudioOnExternalDisplay=" + isAudioOnExternalDisplay);
        L5:
            ExternalDisplayStatsService.m3806$$Nest$fgetmInjector(this.this$0).getHandler().removeCallbacks(this.mLogStateAfterAudioSinkEnabled);
            ExternalDisplayStatsService.m3806$$Nest$fgetmInjector(this.this$0).getHandler().removeCallbacks(this.mLogStateAfterAudioSinkDisabled);
            if (isAudioOnExternalDisplay == false) goto L8;
            Runnable callback = this.mLogStateAfterAudioSinkEnabled;
        L10:
            if (isAudioOnExternalDisplay == false) goto L12;
            ExternalDisplayStatsService.m3806$$Nest$fgetmInjector(this.this$0).getHandler().postDelayed(callback, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
            return;
        L12:
            ExternalDisplayStatsService.m3806$$Nest$fgetmInjector(this.this$0).getHandler().post(callback);
            return;
        L8:
            callback = this.mLogStateAfterAudioSinkDisabled;
            goto L10
        }
    }

    static class Injector {
        private AudioManager mAudioManager;
        private final Context mContext;
        private final Handler mHandler;
        private final BooleanSupplier mIsExtendedDisplayEnabled;
        private PowerManager mPowerManager;

        Injector(Context context, Handler handler, BooleanSupplier isExtendedDisplayEnabled) {
            this.mContext = context;
            this.mHandler = handler;
            this.mIsExtendedDisplayEnabled = isExtendedDisplayEnabled;
        }

        boolean isExtendedDisplayEnabled() {
            return this.mIsExtendedDisplayEnabled.getAsBoolean();
        }

        void registerInteractivityReceiver(BroadcastReceiver interactivityReceiver, IntentFilter filter) {
            this.mContext.registerReceiver(interactivityReceiver, filter, null, this.mHandler, 4);
        }

        void unregisterInteractivityReceiver(BroadcastReceiver interactivityReceiver) {
            this.mContext.unregisterReceiver(interactivityReceiver);
        }

        void registerAudioPlaybackCallback(AudioManager.AudioPlaybackCallback audioPlaybackCallback) {
            if (this.mAudioManager != null) goto L6;
            this.mAudioManager = (AudioManager) this.mContext.getSystemService(AudioManager.class);
        L6:
            if (this.mAudioManager == null) goto L9;
            this.mAudioManager.registerAudioPlaybackCallback(audioPlaybackCallback, this.mHandler);
            return;
        }

        void unregisterAudioPlaybackCallback(AudioManager.AudioPlaybackCallback audioPlaybackCallback) {
            if (this.mAudioManager != null) goto L6;
            this.mAudioManager = (AudioManager) this.mContext.getSystemService(AudioManager.class);
        L6:
            if (this.mAudioManager == null) goto L9;
            this.mAudioManager.unregisterAudioPlaybackCallback(audioPlaybackCallback);
            return;
        }

        boolean isInteractive(int displayId) {
            if (this.mPowerManager != null) goto L6;
            this.mPowerManager = (PowerManager) this.mContext.getSystemService(PowerManager.class);
        L6:
            if (this.mPowerManager != null) goto L8;
        L11:
            return true;
        L8:
            if (this.mPowerManager.isInteractive(displayId) == true) goto L11;
            return false;
        }

        Handler getHandler() {
            return this.mHandler;
        }

        void writeLog(int externalDisplayStateChanged, int event, int numberOfDisplays, boolean isExternalDisplayUsedForAudio) {
            FrameworkStatsLog.write(externalDisplayStateChanged, event, numberOfDisplays, isExternalDisplayUsedForAudio);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$1YlsIaeL_CilqVk2xL8I-SmC8Jg, reason: not valid java name */
    public static /* synthetic */ void m3804$r8$lambda$1YlsIaeL_CilqVk2xL8ISmC8Jg(ExternalDisplayStatsService r0) {
        r0.lambda$scheduleInit$0();
    }

    public static /* synthetic */ void $r8$lambda$fxGax_dOEBi69D6qqHWSjsuI5zA(ExternalDisplayStatsService r0) {
        r0.lambda$scheduleDeinit$1();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExternalDisplayStates, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseIntArray m3805$$Nest$fgetmExternalDisplayStates(ExternalDisplayStatsService r0) {
        return r0.mExternalDisplayStates;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInjector, reason: not valid java name */
    static /* bridge */ /* synthetic */ Injector m3806$$Nest$fgetmInjector(ExternalDisplayStatsService r0) {
        return r0.mInjector;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInteractiveExternalDisplays, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m3807$$Nest$fgetmInteractiveExternalDisplays(ExternalDisplayStatsService r0) {
        return r0.mInteractiveExternalDisplays;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsExternalDisplayUsedForAudio, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3808$$Nest$fgetmIsExternalDisplayUsedForAudio(ExternalDisplayStatsService r0) {
        return r0.mIsExternalDisplayUsedForAudio;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmInteractiveExternalDisplays, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3809$$Nest$fputmInteractiveExternalDisplays(ExternalDisplayStatsService r0, int r1) {
        r0.mInteractiveExternalDisplays = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mlogExternalDisplayIdleEnded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3810$$Nest$mlogExternalDisplayIdleEnded(ExternalDisplayStatsService r0) {
        r0.logExternalDisplayIdleEnded();
    }

    /* JADX INFO: renamed from: -$$Nest$mlogExternalDisplayIdleStarted, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3811$$Nest$mlogExternalDisplayIdleStarted(ExternalDisplayStatsService r0) {
        r0.logExternalDisplayIdleStarted();
    }

    /* JADX INFO: renamed from: -$$Nest$mlogStateAfterAudioSinkChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3812$$Nest$mlogStateAfterAudioSinkChanged(ExternalDisplayStatsService r0, boolean r1) {
        r0.logStateAfterAudioSinkChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3813$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    static {
        DEBUG = DebugUtils.isDebuggable(TAG);
    }

    ExternalDisplayStatsService(Context context, Handler handler, BooleanSupplier isExtendedDisplayEnabled) {
        this(new Injector(context, handler, isExtendedDisplayEnabled));
    }

    ExternalDisplayStatsService(Injector injector) {
        this.mExternalDisplayStates = new SparseIntArray();
        this.mAudioPlaybackCallback = new AnonymousClass1(this);
        this.mInteractivityReceiver = new AnonymousClass2(this);
        this.mInjector = injector;
    }

    public void onHotplugConnectionError() {
        logExternalDisplayError(11);
    }

    public void onDisplayPortLinkTrainingFailure() {
        logExternalDisplayError(12);
    }

    public void onCableNotCapableDisplayPort() {
        logExternalDisplayError(13);
    }

    void onDisplayConnected(LogicalDisplay display) {
        DisplayInfo displayInfo = display.getDisplayInfoLocked();
        if (displayInfo != null) goto L5;
        return;
    L5:
        if (displayInfo.type != 2) goto L10;
        logStateConnected(display.getDisplayIdLocked());
        return;
    }

    void onDisplayAdded(int displayId) {
        if (this.mInjector.isExtendedDisplayEnabled() == false) goto L5;
        logStateExtended(displayId);
        return;
    L5:
        logStateMirroring(displayId);
    }

    void onDisplayDisabled(int displayId) {
        logStateDisabled(displayId);
    }

    void onDisplayDisconnected(int displayId) {
        logStateDisconnected(displayId);
    }

    void onPresentationWindowAdded(int displayId) {
        logExternalDisplayPresentationStarted(displayId);
    }

    void onPresentationWindowRemoved(int displayId) {
        logExternalDisplayPresentationEnded(displayId);
    }

    boolean isInteractiveExternalDisplays() {
        if (this.mInteractiveExternalDisplays == 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isExternalDisplayUsedForAudio() {
        return this.mIsExternalDisplayUsedForAudio;
    }

    private void logExternalDisplayError(int errorType) {
        SparseIntArray r0 = this.mExternalDisplayStates;
        monitor-enter(r0);
        int countOfExternalDisplays = this.mExternalDisplayStates.size();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        this.mInjector.writeLog(FrameworkStatsLog.EXTERNAL_DISPLAY_STATE_CHANGED, errorType, countOfExternalDisplays, this.mIsExternalDisplayUsedForAudio);
        if (DEBUG == false) goto L15;
        Slog.d(TAG, "logExternalDisplayError countOfExternalDisplays=" + countOfExternalDisplays + " errorType=" + errorType + " mIsExternalDisplayUsedForAudio=" + this.mIsExternalDisplayUsedForAudio);
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void scheduleInit() {
        this.mInjector.getHandler().post(new ExternalDisplayStatsService$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ void lambda$scheduleInit$0() {
        if (this.mIsInitialized == false) goto L6;
        Slog.e(TAG, "scheduleInit is called but already initialized");
        return;
    L6:
        this.mIsInitialized = true;
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.SCREEN_OFF");
        filter.addAction("android.intent.action.SCREEN_ON");
        this.mInteractiveExternalDisplays = -1;
        this.mIsExternalDisplayUsedForAudio = false;
        this.mInjector.registerInteractivityReceiver(this.mInteractivityReceiver, filter);
        this.mInjector.registerAudioPlaybackCallback(this.mAudioPlaybackCallback);
    }

    private void scheduleDeinit() {
        this.mInjector.getHandler().post(new ExternalDisplayStatsService$$ExternalSyntheticLambda1(this));
    }

    private /* synthetic */ void lambda$scheduleDeinit$1() {
        if (this.mIsInitialized == true) goto L6;
        Slog.e(TAG, "scheduleDeinit is called but never initialized");
        return;
    L6:
        this.mIsInitialized = false;
        this.mInjector.unregisterInteractivityReceiver(this.mInteractivityReceiver);
        this.mInjector.unregisterAudioPlaybackCallback(this.mAudioPlaybackCallback);
    }

    private void logStateConnected(int displayId) {
        SparseIntArray r0 = this.mExternalDisplayStates;
        monitor-enter(r0);
        int state = this.mExternalDisplayStates.get(displayId, 1);     // Catch: Throwable -> L8
        if (state == 1) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mExternalDisplayStates.put(displayId, 2);     // Catch: Throwable -> L8
        int countOfExternalDisplays = this.mExternalDisplayStates.size();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        if (countOfExternalDisplays != 1) goto L14;
        scheduleInit();
    L14:
        this.mInjector.writeLog(FrameworkStatsLog.EXTERNAL_DISPLAY_STATE_CHANGED, 2, countOfExternalDisplays, this.mIsExternalDisplayUsedForAudio);
        if (DEBUG == false) goto L21;
        Slog.d(TAG, "logStateConnected displayId=" + displayId + " countOfExternalDisplays=" + countOfExternalDisplays + " currentState=" + state + " state=2 mIsExternalDisplayUsedForAudio=" + this.mIsExternalDisplayUsedForAudio);
        return;
    L21:
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void logStateDisconnected(int displayId) {
        SparseIntArray r0 = this.mExternalDisplayStates;
        monitor-enter(r0);
        int state = this.mExternalDisplayStates.get(displayId, 1);     // Catch: Throwable -> L9
        if (state == 1) goto L7;
        int countOfExternalDisplays = this.mExternalDisplayStates.size();     // Catch: Throwable -> L9
        this.mExternalDisplayStates.delete(displayId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        this.mInjector.writeLog(FrameworkStatsLog.EXTERNAL_DISPLAY_STATE_CHANGED, 1, countOfExternalDisplays, this.mIsExternalDisplayUsedForAudio);
        if (DEBUG == false) goto L18;
        Slog.d(TAG, "logStateDisconnected displayId=" + displayId + " countOfExternalDisplays=" + countOfExternalDisplays + " currentState=" + state + " state=1 mIsExternalDisplayUsedForAudio=" + this.mIsExternalDisplayUsedForAudio);
    L18:
        if (countOfExternalDisplays != 1) goto L24;
        scheduleDeinit();
        return;
    L24:
        return;
    L7:
        if (DEBUG == false) goto L11;
        Slog.d(TAG, "logStateDisconnected displayId=" + displayId + " already disconnected");     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void logStateMirroring(int displayId) {
        SparseIntArray r0 = this.mExternalDisplayStates;
        monitor-enter(r0);
        int state = this.mExternalDisplayStates.get(displayId, 1);     // Catch: Throwable -> L18
        if (state == 1) goto L24;
        if (state == 5) goto L24;
        int i = 0;
    L11:
        if (i >= this.mExternalDisplayStates.size()) goto L22;
        if (this.mExternalDisplayStates.keyAt(i) != displayId) goto L20;
        this.mExternalDisplayStates.put(displayId, 5);     // Catch: Throwable -> L18
        this.mInjector.writeLog(FrameworkStatsLog.EXTERNAL_DISPLAY_STATE_CHANGED, 5, i + 1, this.mIsExternalDisplayUsedForAudio);     // Catch: Throwable -> L18
        if (DEBUG == false) goto L20;
        Slog.d(TAG, "logStateMirroring displayId=" + displayId + " countOfExternalDisplays=" + (i + 1) + " currentState=" + state + " state=5 mIsExternalDisplayUsedForAudio=" + this.mIsExternalDisplayUsedForAudio);     // Catch: Throwable -> L18
    L20:
        i = i + 1;     // Catch: Throwable -> L18
        goto L11
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    private void logStateExtended(int displayId) {
        SparseIntArray r0 = this.mExternalDisplayStates;
        monitor-enter(r0);
        int state = this.mExternalDisplayStates.get(displayId, 1);     // Catch: Throwable -> L18
        if (state == 1) goto L24;
        if (state == 6) goto L24;
        int i = 0;
    L11:
        if (i >= this.mExternalDisplayStates.size()) goto L22;
        if (this.mExternalDisplayStates.keyAt(i) != displayId) goto L20;
        this.mExternalDisplayStates.put(displayId, 6);     // Catch: Throwable -> L18
        this.mInjector.writeLog(FrameworkStatsLog.EXTERNAL_DISPLAY_STATE_CHANGED, 6, i + 1, this.mIsExternalDisplayUsedForAudio);     // Catch: Throwable -> L18
        if (DEBUG == false) goto L20;
        Slog.d(TAG, "logStateExtended displayId=" + displayId + " countOfExternalDisplays=" + (i + 1) + " currentState=" + state + " state=6 mIsExternalDisplayUsedForAudio=" + this.mIsExternalDisplayUsedForAudio);     // Catch: Throwable -> L18
    L20:
        i = i + 1;     // Catch: Throwable -> L18
        goto L11
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    private void logStateDisabled(int displayId) {
        SparseIntArray r0 = this.mExternalDisplayStates;
        monitor-enter(r0);
        int state = this.mExternalDisplayStates.get(displayId, 1);     // Catch: Throwable -> L18
        if (state == 1) goto L24;
        if (state == 3) goto L24;
        int i = 0;
    L11:
        if (i >= this.mExternalDisplayStates.size()) goto L22;
        if (this.mExternalDisplayStates.keyAt(i) != displayId) goto L20;
        this.mExternalDisplayStates.put(displayId, 3);     // Catch: Throwable -> L18
        this.mInjector.writeLog(FrameworkStatsLog.EXTERNAL_DISPLAY_STATE_CHANGED, 3, i + 1, this.mIsExternalDisplayUsedForAudio);     // Catch: Throwable -> L18
        if (DEBUG == false) goto L20;
        Slog.d(TAG, "logStateDisabled displayId=" + displayId + " countOfExternalDisplays=" + (i + 1) + " currentState=" + state + " state=3 mIsExternalDisplayUsedForAudio=" + this.mIsExternalDisplayUsedForAudio);     // Catch: Throwable -> L18
    L20:
        i = i + 1;     // Catch: Throwable -> L18
        goto L11
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    private void logExternalDisplayPresentationStarted(int displayId) {
        SparseIntArray r0 = this.mExternalDisplayStates;
        monitor-enter(r0);
        int state = this.mExternalDisplayStates.get(displayId, 1);     // Catch: Throwable -> L8
        if (state != 1) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        int countOfExternalDisplays = this.mExternalDisplayStates.size();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        if (this.mInjector.isExtendedDisplayEnabled() == false) goto L15;
        int newState = 8;
    L16:
        this.mInjector.writeLog(FrameworkStatsLog.EXTERNAL_DISPLAY_STATE_CHANGED, newState, countOfExternalDisplays, this.mIsExternalDisplayUsedForAudio);
        if (DEBUG == false) goto L23;
        Slog.d(TAG, "logExternalDisplayPresentationStarted state=" + state + " newState=" + newState + " mIsExternalDisplayUsedForAudio=" + this.mIsExternalDisplayUsedForAudio);
        return;
    L23:
        return;
    L15:
        newState = 7;
    L8:
        th = move-exception;
        throw th;
    }

    private void logExternalDisplayPresentationEnded(int displayId) {
        SparseIntArray r0 = this.mExternalDisplayStates;
        monitor-enter(r0);
        int state = this.mExternalDisplayStates.get(displayId, 1);     // Catch: Throwable -> L8
        if (state != 1) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        int countOfExternalDisplays = this.mExternalDisplayStates.size();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mInjector.writeLog(FrameworkStatsLog.EXTERNAL_DISPLAY_STATE_CHANGED, 9, countOfExternalDisplays, this.mIsExternalDisplayUsedForAudio);
        if (DEBUG == false) goto L19;
        Slog.d(TAG, "logExternalDisplayPresentationEnded state=" + state + " countOfExternalDisplays=" + countOfExternalDisplays + " mIsExternalDisplayUsedForAudio=" + this.mIsExternalDisplayUsedForAudio);
        return;
    L19:
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void logExternalDisplayIdleStarted() {
        SparseIntArray r0 = this.mExternalDisplayStates;
        monitor-enter(r0);
        int i = 0;
    L22:
    L14:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mExternalDisplayStates.size()) goto L18;
        int displayId = this.mExternalDisplayStates.keyAt(i);     // Catch: Throwable -> L14
        int state = this.mExternalDisplayStates.get(displayId, 1);     // Catch: Throwable -> L14
        if (state == 1) goto L16;
        if (state == 2) goto L16;
        this.mInjector.writeLog(FrameworkStatsLog.EXTERNAL_DISPLAY_STATE_CHANGED, 4, i + 1, this.mIsExternalDisplayUsedForAudio);     // Catch: Throwable -> L14
        if (DEBUG == false) goto L16;
        Slog.d(TAG, "logExternalDisplayIdleStarted displayId=" + displayId + " currentState=" + state + " countOfExternalDisplays=" + (i + 1) + " state=4 mIsExternalDisplayUsedForAudio=" + this.mIsExternalDisplayUsedForAudio);     // Catch: Throwable -> L14
    L16:
        i = i + 1;     // Catch: Throwable -> L14
        goto L22
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L14
    }

    private void logExternalDisplayIdleEnded() {
        SparseIntArray r0 = this.mExternalDisplayStates;
        monitor-enter(r0);
        int i = 0;
    L25:
    L15:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mExternalDisplayStates.size()) goto L21;
        int displayId = this.mExternalDisplayStates.keyAt(i);     // Catch: Throwable -> L15
        int state = this.mExternalDisplayStates.get(displayId, 1);     // Catch: Throwable -> L15
        if (state == 1) goto L18;
        if (state == 2) goto L18;
        this.mInjector.writeLog(FrameworkStatsLog.EXTERNAL_DISPLAY_STATE_CHANGED, state, i + 1, this.mIsExternalDisplayUsedForAudio);     // Catch: Throwable -> L15
        if (DEBUG == false) goto L17;
        Slog.d(TAG, "logExternalDisplayIdleEnded displayId=" + displayId + " state=" + state + " countOfExternalDisplays=" + (i + 1) + " mIsExternalDisplayUsedForAudio=" + this.mIsExternalDisplayUsedForAudio);     // Catch: Throwable -> L15
    L17:
        i = i + 1;     // Catch: Throwable -> L15
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L15
    }

    private void logStateAfterAudioSinkChanged(boolean enabled) {
        if (this.mIsExternalDisplayUsedForAudio != enabled) goto L5;
        return;
    L5:
        this.mIsExternalDisplayUsedForAudio = enabled;
        SparseIntArray r0 = this.mExternalDisplayStates;
        monitor-enter(r0);
        int countOfExternalDisplays = this.mExternalDisplayStates.size();     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        this.mInjector.writeLog(FrameworkStatsLog.EXTERNAL_DISPLAY_STATE_CHANGED, 10, countOfExternalDisplays, this.mIsExternalDisplayUsedForAudio);
        if (DEBUG == false) goto L18;
        Slog.d(TAG, "logStateAfterAudioSinkChanged countOfExternalDisplays)=" + countOfExternalDisplays + " mIsExternalDisplayUsedForAudio=" + this.mIsExternalDisplayUsedForAudio);
        return;
    L18:
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
