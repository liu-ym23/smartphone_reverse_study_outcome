package com.android.server.voiceinteraction;

import android.app.AppOpsManager;
import android.app.compat.CompatChanges;
import android.attention.AttentionManagerInternal;
import android.content.Context;
import android.content.PermissionChecker;
import android.hardware.soundtrigger.SoundTrigger;
import android.media.AudioFormat;
import android.media.permission.Identity;
import android.media.permission.PermissionUtil;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.PersistableBundle;
import android.os.RemoteException;
import android.os.SharedMemory;
import android.service.voice.HotwordDetectedResult;
import android.service.voice.HotwordDetectionService;
import android.service.voice.HotwordDetectionServiceFailure;
import android.service.voice.HotwordDetector;
import android.service.voice.HotwordRejectedResult;
import android.service.voice.IDspHotwordDetectionCallback;
import android.service.voice.IMicrophoneHotwordDetectionVoiceInteractionCallback;
import android.service.voice.ISandboxedDetectionService;
import android.service.voice.VisualQueryDetectionServiceFailure;
import android.service.voice.VoiceInteractionManagerInternal;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Slog;
import com.android.internal.app.IHotwordRecognitionStatusCallback;
import com.android.internal.infra.AndroidFuture;
import com.android.server.LocalServices;
import com.android.server.policy.AppOpsPolicy;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
abstract class DetectorSession {
    static final boolean DEBUG = false;
    private static final long EXTERNAL_HOTWORD_CLEANUP_MILLIS = 2000;
    private static final int EXTERNAL_SOURCE_DETECT_SECURITY_EXCEPTION = 13;
    private static final String HOTWORD_DETECTION_OP_MESSAGE = "Providing hotword detection result to VoiceInteractionService";
    private static final int HOTWORD_EVENT_TYPE_DETECTION = 1;
    private static final int HOTWORD_EVENT_TYPE_REJECTION = 2;
    private static final int HOTWORD_EVENT_TYPE_TRAINING_DATA = 3;
    private static final Duration MAX_UPDATE_TIMEOUT_DURATION = null;
    private static final long MAX_UPDATE_TIMEOUT_MILLIS = 30000;
    private static final int METRICS_CALLBACK_ON_STATUS_REPORTED_EXCEPTION = 14;
    private static final int METRICS_EXTERNAL_SOURCE_DETECTED = 11;
    private static final int METRICS_EXTERNAL_SOURCE_REJECTED = 12;
    private static final int METRICS_INIT_CALLBACK_STATE_ERROR = 1;
    private static final int METRICS_INIT_CALLBACK_STATE_SUCCESS = 0;
    private static final int METRICS_INIT_UNKNOWN_NO_VALUE = 2;
    private static final int METRICS_INIT_UNKNOWN_OVER_MAX_CUSTOM_VALUE = 3;
    private static final int METRICS_INIT_UNKNOWN_TIMEOUT = 4;
    static final int METRICS_KEYPHRASE_TRIGGERED_DETECT_SECURITY_EXCEPTION = 8;
    static final int METRICS_KEYPHRASE_TRIGGERED_DETECT_UNEXPECTED_CALLBACK = 7;
    static final int METRICS_KEYPHRASE_TRIGGERED_REJECT_UNEXPECTED_CALLBACK = 9;
    static final int ONDETECTED_GOT_SECURITY_EXCEPTION = 5;
    static final int ONDETECTED_STREAM_COPY_ERROR = 6;
    private static final String TAG = "DetectorSession";
    final AppOpsManager mAppOpsManager;
    AttentionManagerInternal mAttentionManagerInternal;
    private final Executor mAudioCopyExecutor;
    final IHotwordRecognitionStatusCallback mCallback;
    final Context mContext;
    ParcelFileDescriptor mCurrentAudioSink;
    boolean mDebugHotwordLogging;
    private boolean mDestroyed;
    final HotwordAudioStreamCopier mHotwordAudioStreamCopier;
    private boolean mInitialized;
    final Object mLock;
    boolean mPerformingExternalSourceHotwordDetection;
    final AttentionManagerInternal.ProximityUpdateCallbackInternal mProximityCallbackInternal;
    private double mProximityMeters;
    HotwordDetectionConnection.ServiceConnection mRemoteDetectionService;
    VoiceInteractionManagerServiceImpl.DetectorRemoteExceptionListener mRemoteExceptionListener;
    final ScheduledExecutorService mScheduledExecutorService;
    final IBinder mToken;
    final AtomicBoolean mUpdateStateAfterStartFinished;
    final int mUserId;
    final int mVoiceInteractionServiceUid;
    final Identity mVoiceInteractorIdentity;

    /* JADX INFO: renamed from: com.android.server.voiceinteraction.DetectorSession$3, reason: invalid class name */
    class AnonymousClass3 extends IDspHotwordDetectionCallback.Stub {
        final /* synthetic */ DetectorSession this$0;
        final /* synthetic */ InputStream val$audioSource;
        final /* synthetic */ IMicrophoneHotwordDetectionVoiceInteractionCallback val$callback;
        final /* synthetic */ ParcelFileDescriptor val$serviceAudioSink;
        final /* synthetic */ boolean val$shouldCheckPermissionsAndAppOpsOnDetected;
        final /* synthetic */ boolean val$shouldCloseAudioStreamWithDelayOnDetect;

        public static /* synthetic */ void $r8$lambda$9dnL8v0HUaGmotfzgJiBvoeQ1JE(ParcelFileDescriptor r0, InputStream r1) {
            lambda$onRejected$0(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$mZKyEsfTI7o0TcutMcIgxm29kL4(ParcelFileDescriptor r0, InputStream r1) {
            lambda$onDetected$1(r0, r1);
        }

        AnonymousClass3(DetectorSession this$0, ParcelFileDescriptor r2, InputStream r3, IMicrophoneHotwordDetectionVoiceInteractionCallback r4, boolean r5, boolean r6) {
            this.this$0 = this$0;
            this.val$serviceAudioSink = r2;
            this.val$audioSource = r3;
            this.val$callback = r4;
            this.val$shouldCloseAudioStreamWithDelayOnDetect = r5;
            this.val$shouldCheckPermissionsAndAppOpsOnDetected = r6;
        }

        public void onRejected(HotwordRejectedResult result) throws RemoteException {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            this.this$0.mPerformingExternalSourceHotwordDetection = false;     // Catch: Throwable -> L10
            HotwordMetricsLogger.writeDetectorEvent(DetectorSession.m9362$$Nest$mgetDetectorType(this.this$0), 12, this.this$0.mVoiceInteractionServiceUid);     // Catch: Throwable -> L10
            ScheduledExecutorService r1 = this.this$0.mScheduledExecutorService;     // Catch: Throwable -> L10
            final ParcelFileDescriptor r2 = this.val$serviceAudioSink;     // Catch: Throwable -> L10
            final InputStream r3 = this.val$audioSource;     // Catch: Throwable -> L10
            r1.schedule(new DetectorSession$3$$ExternalSyntheticLambda1(r2, r3), 2000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
            this.val$callback.onRejected(result);     // Catch: Throwable -> L10 RemoteException -> L14
            if (result == null) goto L12;
            Slog.i(DetectorSession.TAG, "Egressed 'hotword rejected result' from hotword trusted process");     // Catch: Throwable -> L10
            if (this.this$0.mDebugHotwordLogging == false) goto L12;
            Slog.i(DetectorSession.TAG, "Egressed detected result: " + result);     // Catch: Throwable -> L10
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L14:
            e = move-exception;
            this.this$0.notifyOnDetectorRemoteException();     // Catch: Throwable -> L10
            throw e;     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$onRejected$0(ParcelFileDescriptor serviceAudioSink, InputStream audioSource) {
            DetectorSession.m9363$$Nest$smbestEffortClose(new Closeable[]{serviceAudioSink, audioSource});
        }

        public void onDetected(HotwordDetectedResult triggerResult) throws RemoteException {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            this.this$0.mPerformingExternalSourceHotwordDetection = false;     // Catch: Throwable -> L7
            HotwordMetricsLogger.writeDetectorEvent(DetectorSession.m9362$$Nest$mgetDetectorType(this.this$0), 11, this.this$0.mVoiceInteractionServiceUid);     // Catch: Throwable -> L7
            if (this.val$shouldCloseAudioStreamWithDelayOnDetect == false) goto L10;
            ScheduledExecutorService r1 = this.this$0.mScheduledExecutorService;     // Catch: Throwable -> L7
            final ParcelFileDescriptor r2 = this.val$serviceAudioSink;     // Catch: Throwable -> L7
            final InputStream r3 = this.val$audioSource;     // Catch: Throwable -> L7
            r1.schedule(new DetectorSession$3$$ExternalSyntheticLambda0(r2, r3), 2000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L7
        L10:
            if (this.val$shouldCheckPermissionsAndAppOpsOnDetected == true) goto L50;
        L44:
            HotwordDetectedResult newResult = this.this$0.mHotwordAudioStreamCopier.startCopyingAudioStreams(triggerResult, this.val$shouldCheckPermissionsAndAppOpsOnDetected);     // Catch: Throwable -> L7 IOException -> L31
        L46:
            this.val$callback.onDetected(newResult, null, null);     // Catch: Throwable -> L7 RemoteException -> L28
            Slog.i(DetectorSession.TAG, "Egressed " + HotwordDetectedResult.getUsageSize(newResult) + " bits from hotword trusted process");     // Catch: Throwable -> L7
            if (this.this$0.mDebugHotwordLogging == false) goto L26;
            Slog.i(DetectorSession.TAG, "Egressed detected result: " + newResult);     // Catch: Throwable -> L7
        L26:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L28:
            e = move-exception;
            this.this$0.notifyOnDetectorRemoteException();     // Catch: Throwable -> L7
            throw e;     // Catch: Throwable -> L7
        L31:
            e = move-exception;
            Slog.w(DetectorSession.TAG, "Ignoring #onDetected due to a IOException", e);     // Catch: Throwable -> L7
            this.val$callback.onHotwordDetectionServiceFailure(new HotwordDetectionServiceFailure(6, "Copy audio stream failure."));     // Catch: Throwable -> L7 RemoteException -> L36
        L35:
            return;
        L36:
            e1 = move-exception;
            this.this$0.notifyOnDetectorRemoteException();     // Catch: Throwable -> L7
            throw e1;     // Catch: Throwable -> L7
        L50:
            this.this$0.enforcePermissionsForDataDelivery();     // Catch: Throwable -> L7 SecurityException -> L13
        L13:
            e = move-exception;
            Slog.w(DetectorSession.TAG, "Ignoring #onDetected due to a SecurityException", e);     // Catch: Throwable -> L7
            HotwordMetricsLogger.writeDetectorEvent(DetectorSession.m9362$$Nest$mgetDetectorType(this.this$0), 13, this.this$0.mVoiceInteractionServiceUid);     // Catch: Throwable -> L7
            this.val$callback.onHotwordDetectionServiceFailure(new HotwordDetectionServiceFailure(5, "Security exception occurs in #onDetected method"));     // Catch: Throwable -> L7 RemoteException -> L18
        L17:
            return;
        L18:
            e1 = move-exception;
            this.this$0.notifyOnDetectorRemoteException();     // Catch: Throwable -> L7
            throw e1;     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$onDetected$1(ParcelFileDescriptor serviceAudioSink, InputStream audioSource) {
            DetectorSession.m9363$$Nest$smbestEffortClose(new Closeable[]{serviceAudioSink, audioSource});
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$4CWF-DI6LatVdWTm_g5kTFijDrA, reason: not valid java name */
    public static /* synthetic */ void m9358$r8$lambda$4CWFDI6LatVdWTm_g5kTFijDrA(PersistableBundle r0, SharedMemory r1, ISandboxedDetectionService r2) {
        lambda$updateStateLocked$2(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$4HsTJIPK7mS2lQO8RbfQMB0aez4(DetectorSession r0, Void r1, Throwable r2) {
        r0.lambda$updateStateAfterProcessStartLocked$1(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$DFqYuzGsLBGJu7UvFr8QyDz09HE(DetectorSession r0, InputStream r1, ParcelFileDescriptor r2, IMicrophoneHotwordDetectionVoiceInteractionCallback r3) {
        r0.lambda$handleExternalSourceHotwordDetectionLocked$3(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$Os1ijwSaN4K6hSXoPerUbHh-Dn4, reason: not valid java name */
    public static /* synthetic */ CompletableFuture m9359$r8$lambda$Os1ijwSaN4K6hSXoPerUbHhDn4(DetectorSession r0, PersistableBundle r1, SharedMemory r2, ISandboxedDetectionService r3) {
        return r0.lambda$updateStateAfterProcessStartLocked$0(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$Rfc-XP1Kqr92DO4HmSLrC1q9AME, reason: not valid java name */
    public static /* synthetic */ void m9360$r8$lambda$RfcXP1Kqr92DO4HmSLrC1q9AME(DetectorSession r0, PersistableBundle r1, boolean r2, ParcelFileDescriptor r3, AudioFormat r4, ParcelFileDescriptor r5, InputStream r6, IMicrophoneHotwordDetectionVoiceInteractionCallback r7, boolean r8, ISandboxedDetectionService r9) {
        r0.lambda$handleExternalSourceHotwordDetectionLocked$4(r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ void $r8$lambda$l64tJQQsNJ90c_rdFfH9XJUWobY(DetectorSession r0, double r1) {
        r0.setProximityValue(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$sbSE-XWKbF4MRHpMk_X7S3FVqEc, reason: not valid java name */
    public static /* synthetic */ void m9361$r8$lambda$sbSEXWKbF4MRHpMk_X7S3FVqEc(DetectorSession r0) {
        r0.lambda$enforcePermissionsForDataDelivery$5();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetDetectorType, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9362$$Nest$mgetDetectorType(DetectorSession r0) {
        return r0.getDetectorType();
    }

    /* JADX INFO: renamed from: -$$Nest$smbestEffortClose, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9363$$Nest$smbestEffortClose(Closeable[] r0) {
        bestEffortClose(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetInitStatusAndMetricsResult, reason: not valid java name */
    static /* bridge */ /* synthetic */ Pair m9364$$Nest$smgetInitStatusAndMetricsResult(Bundle r0) {
        return getInitStatusAndMetricsResult(r0);
    }

    abstract void informRestartProcessLocked();

    static {
        MAX_UPDATE_TIMEOUT_DURATION = Duration.ofMillis(30000);
    }

    DetectorSession(HotwordDetectionConnection.ServiceConnection remoteDetectionService, Object lock, Context context, IBinder token, IHotwordRecognitionStatusCallback callback, int voiceInteractionServiceUid, Identity voiceInteractorIdentity, ScheduledExecutorService scheduledExecutorService, boolean logging, VoiceInteractionManagerServiceImpl.DetectorRemoteExceptionListener listener, int userId) {
        this.mAudioCopyExecutor = Executors.newCachedThreadPool();
        this.mUpdateStateAfterStartFinished = new AtomicBoolean(false);
        this.mAttentionManagerInternal = null;
        this.mProximityCallbackInternal = new DetectorSession$$ExternalSyntheticLambda0(this);
        this.mDebugHotwordLogging = false;
        this.mProximityMeters = -1.0d;
        this.mInitialized = false;
        this.mDestroyed = false;
        this.mRemoteExceptionListener = listener;
        this.mRemoteDetectionService = remoteDetectionService;
        this.mLock = lock;
        this.mContext = context;
        this.mToken = token;
        this.mUserId = userId;
        this.mCallback = callback;
        this.mVoiceInteractionServiceUid = voiceInteractionServiceUid;
        this.mVoiceInteractorIdentity = voiceInteractorIdentity;
        this.mAppOpsManager = (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);
        if (getDetectorType() == 3) goto L5;
        this.mHotwordAudioStreamCopier = new HotwordAudioStreamCopier(this.mAppOpsManager, getDetectorType(), this.mVoiceInteractorIdentity.uid, this.mVoiceInteractorIdentity.packageName, this.mVoiceInteractorIdentity.attributionTag);
    L6:
        this.mScheduledExecutorService = scheduledExecutorService;
        this.mDebugHotwordLogging = logging;
        this.mAttentionManagerInternal = (AttentionManagerInternal) LocalServices.getService(AttentionManagerInternal.class);
        if (this.mAttentionManagerInternal != null) goto L9;
        return;
    L9:
        if (this.mAttentionManagerInternal.isProximitySupported() == false) goto L13;
        this.mAttentionManagerInternal.onStartProximityUpdates(this.mProximityCallbackInternal);
        return;
    L13:
        return;
    L5:
        this.mHotwordAudioStreamCopier = null;
        goto L6
    }

    void notifyOnDetectorRemoteException() {
        Slog.d(TAG, "notifyOnDetectorRemoteException: mRemoteExceptionListener=" + this.mRemoteExceptionListener);
        if (this.mRemoteExceptionListener == null) goto L6;
        this.mRemoteExceptionListener.onDetectorRemoteException(this.mToken, getDetectorType());
        return;
    }

    private void updateStateAfterProcessStartLocked(final PersistableBundle options, final SharedMemory sharedMemory) {
        AndroidFuture<Void> voidFuture = this.mRemoteDetectionService.postAsync(new DetectorSession$$ExternalSyntheticLambda1(this, options, sharedMemory)).whenComplete(new DetectorSession$$ExternalSyntheticLambda2(this));
        if (voidFuture != null) goto L6;
        Slog.w(TAG, "Failed to create AndroidFuture");
        return;
    }

    private /* synthetic */ CompletableFuture lambda$updateStateAfterProcessStartLocked$0(PersistableBundle options, SharedMemory sharedMemory, ISandboxedDetectionService service) throws Exception {
        final AndroidFuture<Void> future = new AndroidFuture();
        service.updateState(options, sharedMemory, new AnonymousClass1(this, future));     // Catch: RemoteException -> L7
        if (getDetectorType() == 3) goto L14;
        HotwordMetricsLogger.writeDetectorEvent(getDetectorType(), 4, this.mVoiceInteractionServiceUid);     // Catch: RemoteException -> L7
    L14:
        return future.orTimeout(30000, TimeUnit.MILLISECONDS);
    L7:
        e = move-exception;
        Slog.w(TAG, "Failed to updateState for HotwordDetectionService", e);
        if (getDetectorType() == 3) goto L14;
        HotwordMetricsLogger.writeDetectorEvent(getDetectorType(), 19, this.mVoiceInteractionServiceUid);
        goto L14
    }

    private /* synthetic */ void lambda$updateStateAfterProcessStartLocked$1(Void res, Throwable err) {
        if ((err instanceof TimeoutException) == false) goto L19;
        Slog.w(TAG, "updateState timed out");
        if (this.mUpdateStateAfterStartFinished.getAndSet(true) == false) goto L22;
        return;
    L22:
        this.mCallback.onStatusReported(100);     // Catch: RemoteException -> L12
        if (getDetectorType() == 3) goto L25;
        HotwordMetricsLogger.writeServiceInitResultEvent(getDetectorType(), 4, this.mVoiceInteractionServiceUid);     // Catch: RemoteException -> L12
        return;
    L25:
        return;
    L12:
        e = move-exception;
        Slog.w(TAG, "Failed to report initialization status UNKNOWN", e);
        if (getDetectorType() == 3) goto L18;
        HotwordMetricsLogger.writeDetectorEvent(getDetectorType(), 14, this.mVoiceInteractionServiceUid);
    L18:
        notifyOnDetectorRemoteException();
        return;
    L19:
        if (err == null) goto L24;
        Slog.w(TAG, "Failed to update state: " + err);
        return;
    }

    private static Pair<Integer, Integer> getInitStatusAndMetricsResult(Bundle bundle) {
        int r0 = 2;
        if (bundle == null) goto L5;
        int status = bundle.getInt("initialization_status", 100);
        if (status > HotwordDetectionService.getMaxCustomInitializationStatus()) goto L9;
        if (status != 0) goto L16;
        int metricsResult = 0;
    L18:
        return new Pair(Integer.valueOf(status), Integer.valueOf(metricsResult));
    L16:
        metricsResult = 1;
        goto L18
    L9:
        if (status == 100) goto L13;
        r0 = 3;
    L13:
        return new Pair(100, Integer.valueOf(r0));
    L5:
        return new Pair(100, 2);
    }

    void updateStateLocked(final PersistableBundle options, final SharedMemory sharedMemory, Instant lastRestartInstant) {
        if (getDetectorType() == 3) goto L6;
        HotwordMetricsLogger.writeDetectorEvent(getDetectorType(), 8, this.mVoiceInteractionServiceUid);
    L6:
        if (this.mUpdateStateAfterStartFinished.get() == false) goto L8;
    L10:
        this.mRemoteDetectionService.run(new DetectorSession$$ExternalSyntheticLambda6(options, sharedMemory));
        return;
    L8:
        if (Instant.now().minus(MAX_UPDATE_TIMEOUT_DURATION).isBefore(lastRestartInstant) == false) goto L10;
        Slog.v(TAG, "call updateStateAfterProcessStartLocked");
        updateStateAfterProcessStartLocked(options, sharedMemory);
    }

    private static /* synthetic */ void lambda$updateStateLocked$2(PersistableBundle options, SharedMemory sharedMemory, ISandboxedDetectionService service) throws Exception {
        service.updateState(options, sharedMemory, null);
    }

    void startListeningFromExternalSourceLocked(ParcelFileDescriptor audioStream, AudioFormat audioFormat, PersistableBundle options, IMicrophoneHotwordDetectionVoiceInteractionCallback callback) {
        handleExternalSourceHotwordDetectionLocked(audioStream, audioFormat, options, callback, true, true);
    }

    void startListeningFromWearableLocked(ParcelFileDescriptor audioStream, AudioFormat audioFormat, PersistableBundle options, final VoiceInteractionManagerInternal.WearableHotwordDetectionCallback wearableCallback) {
        IMicrophoneHotwordDetectionVoiceInteractionCallback voiceInteractionCallback = new AnonymousClass2(this, wearableCallback);
        handleExternalSourceHotwordDetectionLocked(audioStream, audioFormat, options, voiceInteractionCallback, false, false);
    }

    private void handleExternalSourceHotwordDetectionLocked(ParcelFileDescriptor audioStream, final AudioFormat audioFormat, final PersistableBundle options, final IMicrophoneHotwordDetectionVoiceInteractionCallback callback, final boolean shouldCloseAudioStreamWithDelayOnDetect, final boolean shouldCheckPermissionsAndAppOpsOnDetected) {
        if (this.mPerformingExternalSourceHotwordDetection == false) goto L6;
        Slog.i(TAG, "Hotword validation is already in progress for external source.");
        return;
    L6:
        final InputStream audioSource = new ParcelFileDescriptor.AutoCloseInputStream(audioStream);
        Pair<ParcelFileDescriptor, ParcelFileDescriptor> clientPipe = createPipe();
        if (clientPipe != null) goto L9;
        return;
    L9:
        final ParcelFileDescriptor serviceAudioSink = (ParcelFileDescriptor) clientPipe.second;
        final ParcelFileDescriptor serviceAudioSource = (ParcelFileDescriptor) clientPipe.first;
        this.mCurrentAudioSink = serviceAudioSink;
        this.mPerformingExternalSourceHotwordDetection = true;
        this.mAudioCopyExecutor.execute(new DetectorSession$$ExternalSyntheticLambda3(this, audioSource, serviceAudioSink, callback));
        this.mRemoteDetectionService.run(new DetectorSession$$ExternalSyntheticLambda4(this, options, shouldCloseAudioStreamWithDelayOnDetect, serviceAudioSource, audioFormat, serviceAudioSink, audioSource, callback, shouldCheckPermissionsAndAppOpsOnDetected));
        HotwordMetricsLogger.writeDetectorEvent(getDetectorType(), 10, this.mVoiceInteractionServiceUid);
    }

    private /* synthetic */ void lambda$handleExternalSourceHotwordDetectionLocked$3(InputStream audioSource, ParcelFileDescriptor serviceAudioSink, IMicrophoneHotwordDetectionVoiceInteractionCallback callback) {
        OutputStream fos = new ParcelFileDescriptor.AutoCloseOutputStream(serviceAudioSink);     // Catch: Throwable -> L23
        byte[] buffer = new byte[1024];     // Catch: Throwable -> L25
    L6:
        int bytesRead = audioSource.read(buffer, 0, 1024);     // Catch: Throwable -> L25
        if (bytesRead < 0) goto L8;
        fos.write(buffer, 0, bytesRead);     // Catch: Throwable -> L25
        goto L6
    L8:
        Slog.i(TAG, "Reached end of stream for external hotword");     // Catch: Throwable -> L25
        fos.close();     // Catch: Throwable -> L23
        audioSource.close();     // Catch: Throwable -> L19 IOException -> L21
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPerformingExternalSourceHotwordDetection = false;     // Catch: Throwable -> L16
        closeExternalAudioStreamLocked("start external source");     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
    L56:
        return;
    L16:
        th = move-exception;
        throw th;
    L25:
        th = move-exception;
        fos.close();     // Catch: Throwable -> L31
    L33:
        throw th;     // Catch: Throwable -> L23
    L31:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        if (audioSource != null) goto L78;
    L40:
        throw th;     // Catch: Throwable -> L19 IOException -> L21
    L78:
        audioSource.close();     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L19 IOException -> L21
    L21:
        e = move-exception;
        Slog.w(TAG, "Failed supplying audio data to validator", e);     // Catch: Throwable -> L19
        callback.onHotwordDetectionServiceFailure(new HotwordDetectionServiceFailure(3, "Copy audio data failure for external source detection."));     // Catch: Throwable -> L19 RemoteException -> L46
    L52:
        monitor-enter(this.mLock);
        this.mPerformingExternalSourceHotwordDetection = false;     // Catch: Throwable -> L57
        closeExternalAudioStreamLocked("start external source");     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        throw th;
    L46:
        ex = move-exception;
        Slog.w(TAG, "Failed to report onHotwordDetectionServiceFailure status: " + ex);     // Catch: Throwable -> L19
        if (getDetectorType() == 3) goto L50;
        HotwordMetricsLogger.writeDetectorEvent(getDetectorType(), 15, this.mVoiceInteractionServiceUid);     // Catch: Throwable -> L19
    L50:
        notifyOnDetectorRemoteException();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        monitor-enter(this.mLock);
        this.mPerformingExternalSourceHotwordDetection = false;     // Catch: Throwable -> L65
        closeExternalAudioStreamLocked("start external source");     // Catch: Throwable -> L65
        throw th;
    L65:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$handleExternalSourceHotwordDetectionLocked$4(PersistableBundle options, boolean shouldCloseAudioStreamWithDelayOnDetect, ParcelFileDescriptor serviceAudioSource, AudioFormat audioFormat, ParcelFileDescriptor serviceAudioSink, InputStream audioSource, IMicrophoneHotwordDetectionVoiceInteractionCallback callback, boolean shouldCheckPermissionsAndAppOpsOnDetected, ISandboxedDetectionService service) throws Exception {
        if (options != null) goto L5;
        PersistableBundle optionsToSend = new PersistableBundle();
        PersistableBundle optionsToSend2 = optionsToSend;
    L6:
        optionsToSend2.putBoolean("android.service.voice.HotwordDetectionService.KEY_SYSTEM_WILL_CLOSE_AUDIO_STREAM_AFTER_CALLBACK", shouldCloseAudioStreamWithDelayOnDetect);
        service.detectFromMicrophoneSource(serviceAudioSource, 2, audioFormat, optionsToSend2, new AnonymousClass3(this, serviceAudioSink, audioSource, callback, shouldCloseAudioStreamWithDelayOnDetect, shouldCheckPermissionsAndAppOpsOnDetected));
        bestEffortClose(serviceAudioSource);
        return;
    L5:
        optionsToSend2 = options;
        goto L6
    }

    void initialize(PersistableBundle options, SharedMemory sharedMemory) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mInitialized == true) goto L14;
        if (this.mDestroyed == true) goto L14;
        updateStateAfterProcessStartLocked(options, sharedMemory);     // Catch: Throwable -> L12
        this.mInitialized = true;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    void destroyLocked() {
        this.mDestroyed = true;
        this.mDebugHotwordLogging = false;
        this.mRemoteDetectionService = null;
        this.mRemoteExceptionListener = null;
        if (this.mAttentionManagerInternal == null) goto L6;
        this.mAttentionManagerInternal.onStopProximityUpdates(this.mProximityCallbackInternal);
        return;
    }

    void setDebugHotwordLoggingLocked(boolean logging) {
        Slog.v(TAG, "setDebugHotwordLoggingLocked: " + logging);
        this.mDebugHotwordLogging = logging;
    }

    void updateRemoteSandboxedDetectionServiceLocked(HotwordDetectionConnection.ServiceConnection remoteDetectionService) {
        this.mRemoteDetectionService = remoteDetectionService;
    }

    private void reportErrorGetRemoteException() {
        if (getDetectorType() == 3) goto L5;
        HotwordMetricsLogger.writeDetectorEvent(getDetectorType(), 15, this.mVoiceInteractionServiceUid);
    L5:
        notifyOnDetectorRemoteException();
    }

    void reportErrorLocked(HotwordDetectionServiceFailure hotwordDetectionServiceFailure) {
        this.mCallback.onHotwordDetectionServiceFailure(hotwordDetectionServiceFailure);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(TAG, "Failed to call onHotwordDetectionServiceFailure: " + e);
        reportErrorGetRemoteException();
    }

    void reportErrorLocked(VisualQueryDetectionServiceFailure visualQueryDetectionServiceFailure) {
        this.mCallback.onVisualQueryDetectionServiceFailure(visualQueryDetectionServiceFailure);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(TAG, "Failed to call onVisualQueryDetectionServiceFailure: " + e);
        reportErrorGetRemoteException();
    }

    void reportErrorLocked(String errorMessage) {
        this.mCallback.onUnknownFailure(errorMessage);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(TAG, "Failed to call onUnknownFailure: " + e);
        reportErrorGetRemoteException();
    }

    boolean isSameCallback(IHotwordRecognitionStatusCallback callback) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (callback != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L10:
        boolean r1 = this.mCallback.asBinder().equals(callback.asBinder());     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r1;
    L8:
        th = move-exception;
        throw th;
    }

    boolean isSameToken(IBinder token) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = false;
        if (token != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L11:
        if (this.mToken != token) goto L13;
        r1 = true;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r1;
    L8:
        th = move-exception;
        throw th;
    }

    boolean isDestroyed() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mDestroyed;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private static Pair<ParcelFileDescriptor, ParcelFileDescriptor> createPipe() {
        ParcelFileDescriptor[] fileDescriptors = ParcelFileDescriptor.createPipe();     // Catch: IOException -> L5
        return Pair.create(fileDescriptors[0], fileDescriptors[1]);
    L5:
        e = move-exception;
        Slog.e(TAG, "Failed to create audio stream pipe", e);
        return null;
    }

    void saveProximityValueToBundle(HotwordDetectedResult result) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (result != null) goto L14;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L14:
        if (this.mProximityMeters == (-1.0d)) goto L10;
        result.setProximity(this.mProximityMeters);     // Catch: Throwable -> L8
        goto L10
    }

    private void setProximityValue(double proximityMeters) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mProximityMeters = proximityMeters;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void closeExternalAudioStreamLocked(String reason) {
        if (this.mCurrentAudioSink == null) goto L6;
        Slog.i(TAG, "Closing external audio stream to hotword detector: " + reason);
        bestEffortClose(this.mCurrentAudioSink);
        this.mCurrentAudioSink = null;
        return;
    }

    private static void bestEffortClose(Closeable... closeables) {
        int r0 = closeables.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Closeable closeable = closeables[r1];
        bestEffortClose(closeable);
        r1 = r1 + 1;
        goto L3
    }

    private static void bestEffortClose(Closeable closeable) {
        closeable.close();     // Catch: IOException -> L4
        return;
    }

    void enforcePermissionsForDataDelivery() {
        Binder.withCleanCallingIdentity(new DetectorSession$$ExternalSyntheticLambda5(this));
    }

    private /* synthetic */ void lambda$enforcePermissionsForDataDelivery$5() throws Exception {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (AppOpsPolicy.isHotwordDetectionServiceRequired(this.mContext.getPackageManager()) == false) goto L19;
        int result = PermissionChecker.checkPermissionForPreflight(this.mContext, "android.permission.RECORD_AUDIO", -1, this.mVoiceInteractorIdentity.uid, this.mVoiceInteractorIdentity.packageName);     // Catch: Throwable -> L14
        if (result != 0) goto L18;
        int opMode = this.mAppOpsManager.unsafeCheckOpNoThrow(AppOpsManager.opToPublicName(AppOpsPolicy.getVoiceActivationOp()), this.mVoiceInteractorIdentity.uid, this.mVoiceInteractorIdentity.packageName);     // Catch: Throwable -> L14
        if (opMode == 3) goto L16;
        if (opMode == 0) goto L16;
        throw new SecurityException("The app op OP_RECEIVE_SANDBOX_TRIGGER_AUDIO is denied for identity" + this.mVoiceInteractorIdentity);     // Catch: Throwable -> L14
    L16:
        this.mAppOpsManager.noteOpNoThrow(AppOpsPolicy.getVoiceActivationOp(), this.mVoiceInteractorIdentity.uid, this.mVoiceInteractorIdentity.packageName, this.mVoiceInteractorIdentity.attributionTag, HOTWORD_DETECTION_OP_MESSAGE);     // Catch: Throwable -> L14
    L20:
        enforcePermissionForDataDelivery(this.mContext, this.mVoiceInteractorIdentity, "android.permission.CAPTURE_AUDIO_HOTWORD", HOTWORD_DETECTION_OP_MESSAGE);     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        return;
    L18:
        throw new SecurityException("Failed to obtain permission RECORD_AUDIO for identity " + this.mVoiceInteractorIdentity);     // Catch: Throwable -> L14
    L19:
        enforcePermissionForDataDelivery(this.mContext, this.mVoiceInteractorIdentity, "android.permission.RECORD_AUDIO", HOTWORD_DETECTION_OP_MESSAGE);     // Catch: Throwable -> L14
        goto L20
    }

    protected static void enforcePermissionForDataDelivery(Context context, Identity identity, String permission, String reason) {
        int status = PermissionUtil.checkPermissionForDataDelivery(context, identity, permission, reason);
        if (status != 0) goto L6;
        return;
    L6:
        throw new SecurityException(TextUtils.formatSimple("Failed to obtain permission %s for identity %s", new Object[]{permission, identity}));
    }

    void enforceExtraKeyphraseIdNotLeaked(HotwordDetectedResult result, SoundTrigger.KeyphraseRecognitionEvent recognitionEvent) {
        if (CompatChanges.isChangeEnabled(HotwordDetectionConnection.ENFORCE_HOTWORD_PHRASE_ID, this.mVoiceInteractionServiceUid) == true) goto L5;
        return;
    L5:
        SoundTrigger.KeyphraseRecognitionExtra[] r0 = recognitionEvent.keyphraseExtras;
        int r1 = r0.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L12;
        SoundTrigger.KeyphraseRecognitionExtra keyphrase = r0[r2];
        if (keyphrase.getKeyphraseId() == result.getHotwordPhraseId()) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return;
    L12:
        throw new SecurityException("Ignoring #onDetected due to trusted service sharing a keyphrase ID which the DSP did not detect");
    }

    private int getDetectorType() {
        if ((this instanceof DspTrustedHotwordDetectorSession) == false) goto L7;
        return 1;
    L7:
        if ((this instanceof SoftwareTrustedHotwordDetectorSession) == false) goto L11;
        return 2;
    L11:
        if ((this instanceof VisualQueryDetectorSession) == false) goto L14;
        return 3;
    L14:
        Slog.v(TAG, "Unexpected detector type");
        return -1;
    }

    public void dumpLocked(String prefix, PrintWriter pw) {
        pw.print(prefix);
        pw.print("mCallback=");
        pw.println(this.mCallback);
        pw.print(prefix);
        pw.print("mUpdateStateAfterStartFinished=");
        pw.println(this.mUpdateStateAfterStartFinished);
        pw.print(prefix);
        pw.print("mInitialized=");
        pw.println(this.mInitialized);
        pw.print(prefix);
        pw.print("mDestroyed=");
        pw.println(this.mDestroyed);
        pw.print(prefix);
        pw.print("DetectorType=");
        pw.println(HotwordDetector.detectorTypeToString(getDetectorType()));
        pw.print(prefix);
        pw.print("mPerformingExternalSourceHotwordDetection=");
        pw.println(this.mPerformingExternalSourceHotwordDetection);
    }
}
