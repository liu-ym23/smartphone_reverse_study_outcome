package com.android.server.voiceinteraction;

import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.ContentCaptureOptions;
import android.content.Context;
import android.content.Intent;
import android.hardware.soundtrigger.IRecognitionStatusCallback;
import android.hardware.soundtrigger.SoundTrigger;
import android.media.AudioFormat;
import android.media.AudioManagerInternal;
import android.media.permission.Identity;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.ParcelFileDescriptor;
import android.os.PersistableBundle;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SharedMemory;
import android.os.SystemProperties;
import android.provider.DeviceConfig;
import android.service.voice.HotwordDetectionServiceFailure;
import android.service.voice.IMicrophoneHotwordDetectionVoiceInteractionCallback;
import android.service.voice.ISandboxedDetectionService;
import android.service.voice.IVisualQueryDetectionVoiceInteractionCallback;
import android.service.voice.SoundTriggerFailure;
import android.service.voice.VisualQueryDetectionServiceFailure;
import android.service.voice.VoiceInteractionManagerInternal;
import android.speech.IRecognitionServiceManager;
import android.util.Slog;
import android.util.SparseArray;
import android.view.contentcapture.IContentCaptureManager;
import com.android.internal.app.IHotwordRecognitionStatusCallback;
import com.android.internal.app.IVisualQueryDetectionAttentionListener;
import com.android.internal.app.IVoiceInteractionAccessibilitySettingsListener;
import com.android.internal.infra.ServiceConnector;
import com.android.server.LocalServices;
import com.android.server.pm.permission.PermissionManagerServiceInternal;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
final class HotwordDetectionConnection {
    static final boolean DEBUG = false;
    private static final int DETECTION_SERVICE_TYPE_HOTWORD = 1;
    private static final int DETECTION_SERVICE_TYPE_VISUAL_QUERY = 2;
    public static final long ENFORCE_HOTWORD_PHRASE_ID = 215066299;
    private static final String KEY_RESTART_PERIOD_IN_SECONDS = "restart_period_in_seconds";
    private static final int MAX_ISOLATED_PROCESS_NUMBER = 10;
    private static final long RESET_DEBUG_HOTWORD_LOGGING_TIMEOUT_MILLIS = 3600000;
    private static final boolean SYSPROP_VISUAL_QUERY_SERVICE_ENABLED = false;
    private static final String TAG = "HotwordDetectionConnection";
    final AccessibilitySettingsListener mAccessibilitySettingsListener;
    private IBinder mAudioFlinger;
    private final IBinder.DeathRecipient mAudioServerDeathRecipient;
    private final ScheduledFuture<?> mCancellationTaskFuture;
    final Context mContext;
    private boolean mDebugHotwordLogging;
    private ScheduledFuture<?> mDebugHotwordLoggingTimeoutFuture;
    private final SparseArray<DetectorSession> mDetectorSessions;
    private int mDetectorType;
    final ComponentName mHotwordDetectionComponentName;
    private final ServiceConnectionFactory mHotwordDetectionServiceConnectionFactory;
    private IHotwordRecognitionStatusCallback mHotwordRecognitionCallback;
    volatile VoiceInteractionManagerInternal.HotwordDetectionServiceIdentity mIdentity;
    private Instant mLastRestartInstant;
    final Object mLock;
    private final AppOpsManager.OnOpChangedListener mOnOpChangedListener;
    private final int mReStartPeriodSeconds;
    private VoiceInteractionManagerServiceImpl.DetectorRemoteExceptionListener mRemoteExceptionListener;
    private ServiceConnection mRemoteHotwordDetectionService;
    private ServiceConnection mRemoteVisualQueryDetectionService;
    private int mRestartCount;
    private final ScheduledThreadPoolExecutor mScheduledExecutorService;
    final int mUserId;
    final ComponentName mVisualQueryDetectionComponentName;
    private final ServiceConnectionFactory mVisualQueryDetectionServiceConnectionFactory;
    final int mVoiceInteractionServiceUid;
    private final Identity mVoiceInteractorIdentity;

    /* JADX INFO: renamed from: com.android.server.voiceinteraction.HotwordDetectionConnection$2, reason: invalid class name */
    class AnonymousClass2 extends ISandboxedDetectionService.IPingMe.Stub {
        final /* synthetic */ HotwordDetectionConnection this$0;

        /* JADX INFO: renamed from: $r8$lambda$tDt4agSFzWhaz3YoyFZU-ou-wlI, reason: not valid java name */
        public static /* synthetic */ int m9397$r8$lambda$tDt4agSFzWhaz3YoyFZUouwlI(int r0) {
            return lambda$onPing$0(r0);
        }

        AnonymousClass2(HotwordDetectionConnection this$0) {
            this.this$0 = this$0;
        }

        public void onPing() throws RemoteException {
            Slog.d(HotwordDetectionConnection.TAG, "updating hotword UID " + Binder.getCallingUid());
            final int uid = Binder.getCallingUid();
            ((PermissionManagerServiceInternal) LocalServices.getService(PermissionManagerServiceInternal.class)).setHotwordDetectionServiceProvider(new HotwordDetectionConnection$2$$ExternalSyntheticLambda0(uid));
            this.this$0.mIdentity = new VoiceInteractionManagerInternal.HotwordDetectionServiceIdentity(uid, this.this$0.mVoiceInteractionServiceUid);
            HotwordDetectionConnection.m9387$$Nest$maddServiceUidForAudioPolicy(this.this$0, uid, this.this$0.mVoiceInteractionServiceUid);
        }

        private static /* synthetic */ int lambda$onPing$0(int uid) {
            return uid;
        }
    }

    private final class AccessibilitySettingsListener extends IVoiceInteractionAccessibilitySettingsListener.Stub {
        final /* synthetic */ HotwordDetectionConnection this$0;

        /* synthetic */ AccessibilitySettingsListener(HotwordDetectionConnection r1, HotwordDetectionConnectionIA r2) {
            this(r1);
        }

        private AccessibilitySettingsListener(HotwordDetectionConnection r1) {
            this.this$0 = r1;
        }

        public void onAccessibilityDetectionChanged(boolean enable) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            VisualQueryDetectorSession session = HotwordDetectionConnection.m9389$$Nest$mgetVisualQueryDetectorSessionLocked(this.this$0);     // Catch: Throwable -> L7
            if (session == null) goto L9;
            session.updateAccessibilityEgressStateLocked(enable);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    class ServiceConnection extends ServiceConnector.Impl<ISandboxedDetectionService> {
        private static final HandlerThread mHandler = null;
        private final int mBindingFlags;
        private final int mDetectionServiceType;
        private final int mInstanceNumber;
        private final Intent mIntent;
        private boolean mIsBound;
        private boolean mIsLoggedFirstConnect;
        private final Object mLock;
        private boolean mRespectServiceConnectionStatusChanged;
        final /* synthetic */ HotwordDetectionConnection this$0;

        public static /* synthetic */ void $r8$lambda$E52jDMeAIM1fqsgeezf_xP2TouE(ServiceConnection r0, DetectorSession r1) {
            r0.reportBinderDiedLocked(r1);
        }

        public static /* synthetic */ void $r8$lambda$soeRIWrLUaITqTFZZ9ww9BHBGAM(ServiceConnection r0, DetectorSession r1) {
            r0.reportBindServiceFailureLocked(r1);
        }

        protected /* bridge */ /* synthetic */ void onServiceConnectionStatusChanged(IInterface r1, boolean r2) {
            onServiceConnectionStatusChanged((ISandboxedDetectionService) r1, r2);
        }

        static {
            mHandler = new HandlerThread("Sandbox detection connector");
            mHandler.start();
        }

        ServiceConnection(HotwordDetectionConnection this$0, Context context, Intent serviceIntent, int bindingFlags, int userId, Function<IBinder, ISandboxedDetectionService> binderAsInterface, int instanceNumber, int detectionServiceType) {
            this.this$0 = this$0;
            super(context, serviceIntent, bindingFlags, userId, binderAsInterface);
            this.mLock = new Object();
            this.mRespectServiceConnectionStatusChanged = true;
            this.mIsBound = false;
            this.mIsLoggedFirstConnect = false;
            this.mIntent = serviceIntent;
            this.mBindingFlags = bindingFlags;
            this.mInstanceNumber = instanceNumber;
            this.mDetectionServiceType = detectionServiceType;
        }

        protected void onServiceConnectionStatusChanged(ISandboxedDetectionService service, boolean connected) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mRespectServiceConnectionStatusChanged == true) goto L11;
            Slog.v(HotwordDetectionConnection.TAG, "Ignored onServiceConnectionStatusChanged event");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L11:
            this.mIsBound = connected;     // Catch: Throwable -> L9
            if (connected == true) goto L17;
            if (this.mDetectionServiceType == 2) goto L21;
            HotwordMetricsLogger.writeDetectorEvent(HotwordDetectionConnection.m9383$$Nest$fgetmDetectorType(this.this$0), 7, this.this$0.mVoiceInteractionServiceUid);     // Catch: Throwable -> L9
        L21:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L17:
            if (this.mIsLoggedFirstConnect == true) goto L21;
            this.mIsLoggedFirstConnect = true;     // Catch: Throwable -> L9
            if (this.mDetectionServiceType == 2) goto L21;
            HotwordMetricsLogger.writeDetectorEvent(HotwordDetectionConnection.m9383$$Nest$fgetmDetectorType(this.this$0), 2, this.this$0.mVoiceInteractionServiceUid);     // Catch: Throwable -> L9
            goto L21
        }

        protected Handler getJobHandler() {
            return mHandler.getThreadHandler();
        }

        protected long getAutoDisconnectTimeoutMs() {
            return -1;
        }

        public void binderDied() {
            super.binderDied();
            Slog.w(HotwordDetectionConnection.TAG, "binderDied mDetectionServiceType = " + this.mDetectionServiceType);
            Object r0 = this.mLock;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mRespectServiceConnectionStatusChanged == true) goto L11;
            Slog.v(HotwordDetectionConnection.TAG, "Ignored #binderDied event");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
            Object r1 = this.this$0.mLock;
            monitor-enter(r1);
            HotwordDetectionConnection.m9390$$Nest$mrunForEachDetectorSessionLocked(this.this$0, new HotwordDetectionConnection$ServiceConnection$$ExternalSyntheticLambda1(this));     // Catch: Throwable -> L20
            monitor-exit(r1);     // Catch: Throwable -> L20
            if (this.mDetectionServiceType == 2) goto L28;
            HotwordMetricsLogger.writeKeyphraseTriggerEvent(HotwordDetectionConnection.m9383$$Nest$fgetmDetectorType(this.this$0), 4, this.this$0.mVoiceInteractionServiceUid);
            return;
        L28:
            return;
        L20:
            th = move-exception;
            throw th;
        }

        protected boolean bindService(android.content.ServiceConnection serviceConnection) {
        L27:
            e = e;
        L30:
            if (this.mDetectionServiceType == 2) goto L32;
            HotwordMetricsLogger.writeDetectorEvent(HotwordDetectionConnection.m9383$$Nest$fgetmDetectorType(this.this$0), 3, this.this$0.mVoiceInteractionServiceUid);
        L32:
            Slog.wtf(HotwordDetectionConnection.TAG, "Can't bind to the hotword detection service!", e);
            return false;
        L4:
            if (this.mDetectionServiceType != 2) goto L34;
        L9:
            boolean bindResult = ((ServiceConnector.Impl) this).mContext.bindIsolatedService(this.mIntent, 67108865 | this.mBindingFlags, "hotword_detector_" + this.mInstanceNumber, ((ServiceConnector.Impl) this).mExecutor, serviceConnection);     // Catch: IllegalArgumentException -> L21
            if (bindResult == true) goto L26;
            Slog.w(HotwordDetectionConnection.TAG, "bindService failure mDetectionServiceType = " + this.mDetectionServiceType);     // Catch: IllegalArgumentException -> L21
            Object r3 = this.this$0.mLock;     // Catch: IllegalArgumentException -> L21
            monitor-enter(r3);     // Catch: IllegalArgumentException -> L21
            HotwordDetectionConnection.m9390$$Nest$mrunForEachDetectorSessionLocked(this.this$0, new HotwordDetectionConnection$ServiceConnection$$ExternalSyntheticLambda0(this));     // Catch: Throwable -> L23
            monitor-exit(r3);     // Catch: Throwable -> L23
        L18:
            if (this.mDetectionServiceType == 2) goto L26;
            HotwordMetricsLogger.writeDetectorEvent(HotwordDetectionConnection.m9383$$Nest$fgetmDetectorType(this.this$0), 3, this.this$0.mVoiceInteractionServiceUid);     // Catch: IllegalArgumentException -> L21
        L23:
            th = move-exception;
            throw th;     // Catch: IllegalArgumentException -> L21
        L26:
            return bindResult;
        L21:
            e = e;
            goto L30
        L34:
            HotwordMetricsLogger.writeDetectorEvent(HotwordDetectionConnection.m9383$$Nest$fgetmDetectorType(this.this$0), 1, this.this$0.mVoiceInteractionServiceUid);     // Catch: IllegalArgumentException -> L7
        L7:
            e = e;
            goto L30
        }

        boolean isBound() {
            Object r0 = this.mLock;
            monitor-enter(r0);
            boolean r1 = this.mIsBound;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        void ignoreConnectionStatusEvents() {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mRespectServiceConnectionStatusChanged = false;     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        private void reportBinderDiedLocked(DetectorSession detectorSession) {
            if (this.mDetectionServiceType != 1) goto L10;
            if ((detectorSession instanceof DspTrustedHotwordDetectorSession) == false) goto L7;
        L8:
            detectorSession.reportErrorLocked(new HotwordDetectionServiceFailure(2, "Detection service is dead."));
            return;
        L7:
            if ((detectorSession instanceof SoftwareTrustedHotwordDetectorSession) == true) goto L8;
        L10:
            if (this.mDetectionServiceType == 2) goto L12;
        L14:
            detectorSession.reportErrorLocked("Detection service is dead with unknown detection service type.");
            return;
        L12:
            if ((detectorSession instanceof VisualQueryDetectorSession) == false) goto L14;
            detectorSession.reportErrorLocked(new VisualQueryDetectionServiceFailure(2, "Detection service is dead."));
        }

        private void reportBindServiceFailureLocked(DetectorSession detectorSession) {
            if (this.mDetectionServiceType != 1) goto L10;
            if ((detectorSession instanceof DspTrustedHotwordDetectorSession) == false) goto L7;
        L8:
            detectorSession.reportErrorLocked(new HotwordDetectionServiceFailure(1, "Bind detection service failure."));
            return;
        L7:
            if ((detectorSession instanceof SoftwareTrustedHotwordDetectorSession) == true) goto L8;
        L10:
            if (this.mDetectionServiceType == 2) goto L12;
        L14:
            detectorSession.reportErrorLocked("Bind detection service failure with unknown detection service type.");
            return;
        L12:
            if ((detectorSession instanceof VisualQueryDetectorSession) == false) goto L14;
            detectorSession.reportErrorLocked(new VisualQueryDetectionServiceFailure(1, "Bind detection service failure."));
        }
    }

    private class ServiceConnectionFactory {
        private final int mBindingFlags;
        private final int mDetectionServiceType;
        private final Intent mIntent;
        final /* synthetic */ HotwordDetectionConnection this$0;

        ServiceConnectionFactory(HotwordDetectionConnection r3, Intent intent, boolean bindInstantServiceAllowed, int detectionServiceType) {
            this.this$0 = r3;
            this.mIntent = intent;
            this.mDetectionServiceType = detectionServiceType;
            if (bindInstantServiceAllowed == false) goto L5;
            int flags = 4194304;
        L7:
            if (HotwordDetectionConnection.m9393$$Nest$sfgetSYSPROP_VISUAL_QUERY_SERVICE_ENABLED() == true) goto L9;
        L13:
            this.mBindingFlags = flags;
            return;
        L9:
            if (r3.mVisualQueryDetectionComponentName == null) goto L13;
            if (r3.mHotwordDetectionComponentName == null) goto L13;
            flags = flags | 8192;
            goto L13
        L5:
            flags = 0;
            goto L7
        }

        ServiceConnection createLocked() {
            ServiceConnection connection = new ServiceConnection(this.this$0, this.this$0.mContext, this.mIntent, this.mBindingFlags, this.this$0.mUserId, new HotwordDetectionConnection$ServiceConnectionFactory$$ExternalSyntheticLambda0(), HotwordDetectionConnection.m9385$$Nest$fgetmRestartCount(this.this$0) % 10, this.mDetectionServiceType);
            connection.connect();
            HotwordDetectionConnection.m9394$$Nest$smupdateAudioFlinger(connection, HotwordDetectionConnection.m9382$$Nest$fgetmAudioFlinger(this.this$0));
            HotwordDetectionConnection.m9395$$Nest$smupdateContentCaptureManager(connection);
            HotwordDetectionConnection.m9396$$Nest$smupdateSpeechService(connection);
            HotwordDetectionConnection.m9391$$Nest$mupdateServiceIdentity(this.this$0, connection);
            HotwordDetectionConnection.m9392$$Nest$mupdateStorageService(this.this$0, connection);
            return connection;
        }
    }

    static final class SoundTriggerCallback extends IRecognitionStatusCallback.Stub {
        private final Context mContext;
        private final IHotwordRecognitionStatusCallback mExternalCallback;
        private final HotwordDetectionConnection mHotwordDetectionConnection;
        private final Identity mVoiceInteractorIdentity;

        SoundTriggerCallback(Context context, IHotwordRecognitionStatusCallback callback, HotwordDetectionConnection connection, Identity voiceInteractorIdentity) {
            this.mContext = context;
            this.mHotwordDetectionConnection = connection;
            this.mExternalCallback = callback;
            this.mVoiceInteractorIdentity = voiceInteractorIdentity;
        }

        public void onKeyphraseDetected(SoundTrigger.KeyphraseRecognitionEvent recognitionEvent) throws RemoteException {
            if (this.mHotwordDetectionConnection == null) goto L5;
            boolean useHotwordDetectionService = true;
        L6:
            if (useHotwordDetectionService == false) goto L8;
            HotwordMetricsLogger.writeKeyphraseTriggerEvent(1, 0, this.mVoiceInteractorIdentity.uid);
            HotwordDetectionConnection.m9388$$Nest$mdetectFromDspSource(this.mHotwordDetectionConnection, recognitionEvent, this.mExternalCallback);
            return;
        L8:
            int result = ((AppOpsManager) this.mContext.getSystemService(AppOpsManager.class)).noteOpNoThrow(102, this.mVoiceInteractorIdentity.uid, this.mVoiceInteractorIdentity.packageName, this.mVoiceInteractorIdentity.attributionTag, "Non-HDS keyphrase recognition to VoiceInteractionService");
            if (result == 0) goto L11;
            Slog.w(HotwordDetectionConnection.TAG, "onKeyphraseDetected suppressed, permission check returned: " + result);
            this.mExternalCallback.onRecognitionPaused();
            return;
        L11:
            HotwordMetricsLogger.writeKeyphraseTriggerEvent(0, 0, this.mVoiceInteractorIdentity.uid);
            this.mExternalCallback.onKeyphraseDetected(recognitionEvent, null);
            return;
        L5:
            useHotwordDetectionService = false;
            goto L6
        }

        public void onGenericSoundTriggerDetected(SoundTrigger.GenericRecognitionEvent recognitionEvent) throws RemoteException {
            this.mExternalCallback.onGenericSoundTriggerDetected(recognitionEvent);
        }

        public void onPreempted() throws RemoteException {
            this.mExternalCallback.onSoundTriggerFailure(new SoundTriggerFailure(3, "Unexpected startRecognition on already started ST session"));
        }

        public void onModuleDied() throws RemoteException {
            this.mExternalCallback.onSoundTriggerFailure(new SoundTriggerFailure(1, "STHAL died"));
        }

        public void onResumeFailed(int status) throws RemoteException {
            this.mExternalCallback.onSoundTriggerFailure(new SoundTriggerFailure(2, "STService recognition resume failed with: " + status));
        }

        public void onPauseFailed(int status) throws RemoteException {
            this.mExternalCallback.onSoundTriggerFailure(new SoundTriggerFailure(2, "STService recognition pause failed with: " + status));
        }

        public void onRecognitionPaused() throws RemoteException {
            this.mExternalCallback.onRecognitionPaused();
        }

        public void onRecognitionResumed() throws RemoteException {
            this.mExternalCallback.onRecognitionResumed();
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$3dvVF2wJqmuLUVQkxTv-KV92Z8o, reason: not valid java name */
    public static /* synthetic */ void m9379$r8$lambda$3dvVF2wJqmuLUVQkxTvKV92Z8o(HotwordDetectionConnection r0, ISandboxedDetectionService r1) {
        r0.lambda$updateServiceIdentity$11(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$6adhHw1nf2g-BOLIgN7WESE9aOs, reason: not valid java name */
    public static /* synthetic */ void m9380$r8$lambda$6adhHw1nf2gBOLIgN7WESE9aOs(HotwordDetectionConnection r0) {
        r0.audioServerDied();
    }

    public static /* synthetic */ void $r8$lambda$HagB46oS5tk_bpUymch2aajSzEA(DetectorSession r0) {
        lambda$cancelLocked$1(r0);
    }

    public static /* synthetic */ void $r8$lambda$IoB1SIw1NBueTt33_sBQWnmQAiw(DetectorSession r0) {
        lambda$safelyShutdownHotwordDetectionOnVoiceActivationDisabledLocked$6(r0);
    }

    public static /* synthetic */ void $r8$lambda$JBANd7j37Gc1njGvWffcbybD8uU(IContentCaptureManager r0, ISandboxedDetectionService r1) {
        lambda$updateContentCaptureManager$9(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$JWFsPRsQ78pTXKDC7FqiIW2PcdY(DetectorSession r0) {
        lambda$setDebugHotwordLoggingLocked$3(r0);
    }

    public static /* synthetic */ void $r8$lambda$Qc5m5301Sp77BQp7o30OG5ZjslA(String r0, PrintWriter r1, DetectorSession r2) {
        lambda$dump$7(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$TENNtXprD8crRV9NqFHjmHp0Qmg(HotwordDetectionConnection r0, ISandboxedDetectionService r1) {
        r0.lambda$updateStorageService$12(r1);
    }

    public static /* synthetic */ void $r8$lambda$V6iI2V9fosj42MtGZoEM72DNDrw(HotwordDetectionConnection r0, DetectorSession r1) {
        r0.lambda$restartProcessLocked$5(r1);
    }

    public static /* synthetic */ void $r8$lambda$Xe6MIz_ON0zsbVBqnJ0QGOr1MpU(IRecognitionServiceManager r0, ISandboxedDetectionService r1) {
        lambda$updateSpeechService$10(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$_oYC96nyQKYyGMh8oYOGWkjXmac(HotwordDetectionConnection r0) {
        r0.lambda$setDebugHotwordLoggingLocked$4();
    }

    public static /* synthetic */ void $r8$lambda$sEJQWqihWiR1T4i1rAJfrMI36U8(boolean r0, DetectorSession r1) {
        lambda$setDebugHotwordLoggingLocked$2(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$tm-lhAXPaBtKF2vFPQpeW6jvfOg, reason: not valid java name */
    public static /* synthetic */ void m9381$r8$lambda$tmlhAXPaBtKF2vFPQpeW6jvfOg(HotwordDetectionConnection r0) {
        r0.lambda$new$0();
    }

    public static /* synthetic */ void $r8$lambda$uLn_NYQmZE6VHjpTxmC7yEbplQE(IBinder r0, ISandboxedDetectionService r1) {
        lambda$updateAudioFlinger$8(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAudioFlinger, reason: not valid java name */
    static /* bridge */ /* synthetic */ IBinder m9382$$Nest$fgetmAudioFlinger(HotwordDetectionConnection r0) {
        return r0.mAudioFlinger;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDetectorType, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9383$$Nest$fgetmDetectorType(HotwordDetectionConnection r0) {
        return r0.mDetectorType;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHotwordRecognitionCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ IHotwordRecognitionStatusCallback m9384$$Nest$fgetmHotwordRecognitionCallback(HotwordDetectionConnection r0) {
        return r0.mHotwordRecognitionCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRestartCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9385$$Nest$fgetmRestartCount(HotwordDetectionConnection r0) {
        return r0.mRestartCount;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVoiceInteractorIdentity, reason: not valid java name */
    static /* bridge */ /* synthetic */ Identity m9386$$Nest$fgetmVoiceInteractorIdentity(HotwordDetectionConnection r0) {
        return r0.mVoiceInteractorIdentity;
    }

    /* JADX INFO: renamed from: -$$Nest$maddServiceUidForAudioPolicy, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9387$$Nest$maddServiceUidForAudioPolicy(HotwordDetectionConnection r0, int r1, int r2) {
        r0.addServiceUidForAudioPolicy(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mdetectFromDspSource, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9388$$Nest$mdetectFromDspSource(HotwordDetectionConnection r0, SoundTrigger.KeyphraseRecognitionEvent r1, IHotwordRecognitionStatusCallback r2) {
        r0.detectFromDspSource(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetVisualQueryDetectorSessionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ VisualQueryDetectorSession m9389$$Nest$mgetVisualQueryDetectorSessionLocked(HotwordDetectionConnection r0) {
        return r0.getVisualQueryDetectorSessionLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mrunForEachDetectorSessionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9390$$Nest$mrunForEachDetectorSessionLocked(HotwordDetectionConnection r0, Consumer r1) {
        r0.runForEachDetectorSessionLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateServiceIdentity, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9391$$Nest$mupdateServiceIdentity(HotwordDetectionConnection r0, ServiceConnection r1) {
        r0.updateServiceIdentity(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateStorageService, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9392$$Nest$mupdateStorageService(HotwordDetectionConnection r0, ServiceConnection r1) {
        r0.updateStorageService(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetSYSPROP_VISUAL_QUERY_SERVICE_ENABLED, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9393$$Nest$sfgetSYSPROP_VISUAL_QUERY_SERVICE_ENABLED() {
        return SYSPROP_VISUAL_QUERY_SERVICE_ENABLED;
    }

    /* JADX INFO: renamed from: -$$Nest$smupdateAudioFlinger, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9394$$Nest$smupdateAudioFlinger(ServiceConnection r0, IBinder r1) {
        updateAudioFlinger(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smupdateContentCaptureManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9395$$Nest$smupdateContentCaptureManager(ServiceConnection r0) {
        updateContentCaptureManager(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smupdateSpeechService, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9396$$Nest$smupdateSpeechService(ServiceConnection r0) {
        updateSpeechService(r0);
    }

    static {
        SYSPROP_VISUAL_QUERY_SERVICE_ENABLED = SystemProperties.getBoolean("ro.hotword.visual_query_service_enabled", false);
    }

    HotwordDetectionConnection(Object lock, Context context, int voiceInteractionServiceUid, Identity voiceInteractorIdentity, ComponentName hotwordDetectionServiceName, ComponentName visualQueryDetectionServiceName, int userId, boolean bindInstantServiceAllowed, int detectorType, VoiceInteractionManagerServiceImpl.DetectorRemoteExceptionListener listener) {
        this.mScheduledExecutorService = new ScheduledThreadPoolExecutor(1);
        this.mAudioServerDeathRecipient = new HotwordDetectionConnection$$ExternalSyntheticLambda9(this);
        this.mDebugHotwordLoggingTimeoutFuture = null;
        this.mRestartCount = 0;
        this.mDebugHotwordLogging = false;
        this.mDetectorSessions = new SparseArray();
        this.mOnOpChangedListener = new AnonymousClass1(this);
        this.mLock = lock;
        this.mContext = context;
        this.mVoiceInteractionServiceUid = voiceInteractionServiceUid;
        this.mVoiceInteractorIdentity = voiceInteractorIdentity;
        this.mHotwordDetectionComponentName = hotwordDetectionServiceName;
        this.mVisualQueryDetectionComponentName = visualQueryDetectionServiceName;
        this.mUserId = userId;
        this.mDetectorType = detectorType;
        this.mRemoteExceptionListener = listener;
        this.mReStartPeriodSeconds = DeviceConfig.getInt("voice_interaction", KEY_RESTART_PERIOD_IN_SECONDS, 0);
        this.mAccessibilitySettingsListener = new AccessibilitySettingsListener(this, null);
        Intent hotwordDetectionServiceIntent = new Intent("android.service.voice.HotwordDetectionService");
        hotwordDetectionServiceIntent.setComponent(this.mHotwordDetectionComponentName);
        Intent visualQueryDetectionServiceIntent = new Intent("android.service.voice.VisualQueryDetectionService");
        visualQueryDetectionServiceIntent.setComponent(this.mVisualQueryDetectionComponentName);
        initAudioFlinger();
        this.mHotwordDetectionServiceConnectionFactory = new ServiceConnectionFactory(this, hotwordDetectionServiceIntent, bindInstantServiceAllowed, 1);
        this.mVisualQueryDetectionServiceConnectionFactory = new ServiceConnectionFactory(this, visualQueryDetectionServiceIntent, bindInstantServiceAllowed, 2);
        this.mLastRestartInstant = Instant.now();
        AppOpsManager appOpsManager = (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);
        appOpsManager.startWatchingMode(136, this.mVoiceInteractorIdentity.packageName, this.mOnOpChangedListener);
        if (this.mReStartPeriodSeconds > 0) goto L5;
        this.mCancellationTaskFuture = null;
        return;
    L5:
        this.mScheduledExecutorService.setRemoveOnCancelPolicy(true);
        this.mCancellationTaskFuture = this.mScheduledExecutorService.scheduleAtFixedRate(new HotwordDetectionConnection$$ExternalSyntheticLambda10(this), this.mReStartPeriodSeconds, this.mReStartPeriodSeconds, TimeUnit.SECONDS);
    }

    private /* synthetic */ void lambda$new$0() {
        Slog.v(TAG, "Time to restart the process, TTL has passed");
        Object r0 = this.mLock;
        monitor-enter(r0);
        restartProcessLocked();     // Catch: Throwable -> L7
        if (this.mDetectorType == 3) goto L9;
        HotwordMetricsLogger.writeServiceRestartEvent(this.mDetectorType, 2, this.mVoiceInteractionServiceUid);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void initAudioFlinger() {
        IBinder audioFlinger = ServiceManager.waitForService("media.audio_flinger");
        if (audioFlinger != null) goto L12;
        setAudioFlinger(null);
        throw new IllegalStateException("Service media.audio_flinger wasn't found.");
    L12:
        audioFlinger.linkToDeath(this.mAudioServerDeathRecipient, 0);     // Catch: RemoteException -> L7
        setAudioFlinger(audioFlinger);
        return;
    L7:
        e = move-exception;
        Slog.w(TAG, "Audio server died before we registered a DeathRecipient; retrying init.", e);
        initAudioFlinger();
    }

    private void setAudioFlinger(IBinder audioFlinger) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mAudioFlinger = audioFlinger;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void audioServerDied() {
        Slog.w(TAG, "Audio server died; restarting the HotwordDetectionService.");
        initAudioFlinger();
        Object r0 = this.mLock;
        monitor-enter(r0);
        restartProcessLocked();     // Catch: Throwable -> L7
        if (this.mDetectorType == 3) goto L9;
        HotwordMetricsLogger.writeServiceRestartEvent(this.mDetectorType, 1, this.mVoiceInteractionServiceUid);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void cancelLocked() {
        Slog.v(TAG, "cancelLocked");
        clearDebugHotwordLoggingTimeoutLocked();
        this.mRemoteExceptionListener = null;
        runForEachDetectorSessionLocked(new HotwordDetectionConnection$$ExternalSyntheticLambda2());
        this.mDetectorSessions.clear();
        this.mDebugHotwordLogging = false;
        unbindVisualQueryDetectionService();
        unbindHotwordDetectionService();
        if (this.mCancellationTaskFuture == null) goto L6;
        this.mCancellationTaskFuture.cancel(true);
    L6:
        if (this.mAudioFlinger == null) goto L8;
        this.mAudioFlinger.unlinkToDeath(this.mAudioServerDeathRecipient, 0);
        this.mAudioFlinger = null;
    L8:
        AppOpsManager appOpsManager = (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);
        appOpsManager.stopWatchingMode(this.mOnOpChangedListener);
    }

    private static /* synthetic */ void lambda$cancelLocked$1(DetectorSession session) {
        session.destroyLocked();
    }

    private void unbindVisualQueryDetectionService() {
        if (this.mRemoteVisualQueryDetectionService == null) goto L5;
        this.mRemoteVisualQueryDetectionService.unbind();
        this.mRemoteVisualQueryDetectionService = null;
    L5:
        resetDetectionProcessIdentityIfEmptyLocked();
    }

    private void unbindHotwordDetectionService() {
        if (this.mRemoteHotwordDetectionService == null) goto L5;
        this.mRemoteHotwordDetectionService.unbind();
        this.mRemoteHotwordDetectionService = null;
    L5:
        resetDetectionProcessIdentityIfEmptyLocked();
    }

    private void resetDetectionProcessIdentityIfEmptyLocked() {
        if (this.mRemoteHotwordDetectionService == null) goto L5;
        return;
    L5:
        if (this.mRemoteVisualQueryDetectionService != null) goto L12;
        ((PermissionManagerServiceInternal) LocalServices.getService(PermissionManagerServiceInternal.class)).setHotwordDetectionServiceProvider(null);
        if (this.mIdentity == null) goto L9;
        removeServiceUidForAudioPolicy(this.mIdentity.getIsolatedUid());
    L9:
        this.mIdentity = null;
        return;
    }

    void updateStateLocked(PersistableBundle options, SharedMemory sharedMemory, IBinder token) {
        DetectorSession session = getDetectorSessionByTokenLocked(token);
        if (session != null) goto L6;
        Slog.v(TAG, "Not found the detector by token");
        return;
    L6:
        session.updateStateLocked(options, sharedMemory, this.mLastRestartInstant);
    }

    void startListeningFromMicLocked(AudioFormat audioFormat, IMicrophoneHotwordDetectionVoiceInteractionCallback callback) {
        SoftwareTrustedHotwordDetectorSession session = getSoftwareTrustedHotwordDetectorSessionLocked();
        if (session != null) goto L5;
        return;
    L5:
        session.startListeningFromMicLocked(audioFormat, callback);
    }

    public void setVisualQueryDetectionAttentionListenerLocked(IVisualQueryDetectionAttentionListener listener) {
        VisualQueryDetectorSession session = getVisualQueryDetectorSessionLocked();
        if (session != null) goto L5;
        return;
    L5:
        session.setVisualQueryDetectionAttentionListenerLocked(listener);
    }

    boolean startPerceivingLocked(IVisualQueryDetectionVoiceInteractionCallback callback) {
        VisualQueryDetectorSession session = getVisualQueryDetectorSessionLocked();
        if (session != null) goto L7;
        return false;
    L7:
        return session.startPerceivingLocked(callback);
    }

    boolean stopPerceivingLocked() {
        VisualQueryDetectorSession session = getVisualQueryDetectorSessionLocked();
        if (session != null) goto L7;
        return false;
    L7:
        return session.stopPerceivingLocked();
    }

    public void startListeningFromExternalSourceLocked(ParcelFileDescriptor audioStream, AudioFormat audioFormat, PersistableBundle options, IBinder token, IMicrophoneHotwordDetectionVoiceInteractionCallback callback) {
        DetectorSession session = getDetectorSessionByTokenLocked(token);
        if (session != null) goto L6;
        Slog.v(TAG, "Not found the detector by token");
        return;
    L6:
        session.startListeningFromExternalSourceLocked(audioStream, audioFormat, options, callback);
    }

    public void startListeningFromWearableLocked(ParcelFileDescriptor audioStream, AudioFormat audioFormat, PersistableBundle options, VoiceInteractionManagerInternal.WearableHotwordDetectionCallback callback) {
        DetectorSession trustedSession = getDspTrustedHotwordDetectorSessionLocked();
        if (trustedSession != null) goto L6;
        callback.onError("Unable to start listening from wearable because the trusted hotword detection session is not available.");
        return;
    L6:
        trustedSession.startListeningFromWearableLocked(audioStream, audioFormat, options, callback);
    }

    void stopListeningFromMicLocked() {
        SoftwareTrustedHotwordDetectorSession session = getSoftwareTrustedHotwordDetectorSessionLocked();
        if (session != null) goto L5;
        return;
    L5:
        session.stopListeningFromMicLocked();
    }

    void triggerHardwareRecognitionEventForTestLocked(SoundTrigger.KeyphraseRecognitionEvent event, IHotwordRecognitionStatusCallback callback) {
        detectFromDspSource(event, callback);
    }

    private void detectFromDspSource(SoundTrigger.KeyphraseRecognitionEvent recognitionEvent, IHotwordRecognitionStatusCallback externalCallback) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DspTrustedHotwordDetectorSession session = getDspTrustedHotwordDetectorSessionLocked();     // Catch: Throwable -> L12
        if (session == null) goto L14;
        if (session.isSameCallback(externalCallback) == false) goto L14;
        session.detectFromDspSourceLocked(recognitionEvent, externalCallback);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L14:
        Slog.v(TAG, "Not found the Dsp detector by callback");     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    void forceRestart() {
        Slog.v(TAG, "Requested to restart the service internally. Performing the restart");
        Object r0 = this.mLock;
        monitor-enter(r0);
        restartProcessLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void setDebugHotwordLoggingLocked(final boolean logging) {
        Slog.v(TAG, "setDebugHotwordLoggingLocked: " + logging);
        clearDebugHotwordLoggingTimeoutLocked();
        this.mDebugHotwordLogging = logging;
        runForEachDetectorSessionLocked(new HotwordDetectionConnection$$ExternalSyntheticLambda4(logging));
        if (logging == false) goto L6;
        this.mDebugHotwordLoggingTimeoutFuture = this.mScheduledExecutorService.schedule(new HotwordDetectionConnection$$ExternalSyntheticLambda5(this), 3600000, TimeUnit.MILLISECONDS);
        return;
    }

    private static /* synthetic */ void lambda$setDebugHotwordLoggingLocked$2(boolean logging, DetectorSession session) {
        session.setDebugHotwordLoggingLocked(logging);
    }

    private /* synthetic */ void lambda$setDebugHotwordLoggingLocked$4() {
        Slog.v(TAG, "Timeout to reset mDebugHotwordLogging to false");
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mDebugHotwordLogging = false;     // Catch: Throwable -> L8
        runForEachDetectorSessionLocked(new HotwordDetectionConnection$$ExternalSyntheticLambda3());     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$setDebugHotwordLoggingLocked$3(DetectorSession session) {
        session.setDebugHotwordLoggingLocked(false);
    }

    void setDetectorType(int detectorType) {
        this.mDetectorType = detectorType;
    }

    private void clearDebugHotwordLoggingTimeoutLocked() {
        if (this.mDebugHotwordLoggingTimeoutFuture == null) goto L6;
        this.mDebugHotwordLoggingTimeoutFuture.cancel(true);
        this.mDebugHotwordLoggingTimeoutFuture = null;
        return;
    }

    private void restartProcessLocked() {
        Slog.v(TAG, "Restarting hotword detection process");
        ServiceConnection oldHotwordConnection = this.mRemoteHotwordDetectionService;
        ServiceConnection oldVisualQueryDetectionConnection = this.mRemoteVisualQueryDetectionService;
        VoiceInteractionManagerInternal.HotwordDetectionServiceIdentity previousIdentity = this.mIdentity;
        this.mLastRestartInstant = Instant.now();
        this.mRestartCount++;
        if (oldHotwordConnection == null) goto L5;
        this.mRemoteHotwordDetectionService = this.mHotwordDetectionServiceConnectionFactory.createLocked();
    L5:
        if (oldVisualQueryDetectionConnection == null) goto L7;
        this.mRemoteVisualQueryDetectionService = this.mVisualQueryDetectionServiceConnectionFactory.createLocked();
    L7:
        Slog.v(TAG, "Started the new process, dispatching processRestarted to detector");
        runForEachDetectorSessionLocked(new HotwordDetectionConnection$$ExternalSyntheticLambda0(this));
        if (oldHotwordConnection == null) goto L10;
        oldHotwordConnection.ignoreConnectionStatusEvents();
        oldHotwordConnection.unbind();
    L10:
        if (oldVisualQueryDetectionConnection == null) goto L12;
        oldVisualQueryDetectionConnection.ignoreConnectionStatusEvents();
        oldVisualQueryDetectionConnection.unbind();
    L12:
        if (previousIdentity == null) goto L15;
        removeServiceUidForAudioPolicy(previousIdentity.getIsolatedUid());
        return;
    }

    private /* synthetic */ void lambda$restartProcessLocked$5(DetectorSession session) {
        if ((session instanceof VisualQueryDetectorSession) == false) goto L5;
        ServiceConnection newRemoteService = this.mRemoteVisualQueryDetectionService;
    L6:
        session.updateRemoteSandboxedDetectionServiceLocked(newRemoteService);
        session.informRestartProcessLocked();
        return;
    L5:
        newRemoteService = this.mRemoteHotwordDetectionService;
        goto L6
    }

    void safelyShutdownHotwordDetectionOnVoiceActivationDisabledLocked() {
        Slog.v(TAG, "safelyShutdownHotwordDetectionOnVoiceActivationDisabled");
        clearDebugHotwordLoggingTimeoutLocked();     // Catch: Exception -> L6
        this.mRemoteExceptionListener = null;     // Catch: Exception -> L6
        runForEachDetectorSessionLocked(new HotwordDetectionConnection$$ExternalSyntheticLambda13());     // Catch: Exception -> L6
        this.mDetectorSessions.delete(1);     // Catch: Exception -> L6
        this.mDetectorSessions.delete(2);     // Catch: Exception -> L6
        this.mDebugHotwordLogging = false;     // Catch: Exception -> L6
        unbindHotwordDetectionService();     // Catch: Exception -> L6
        if (this.mCancellationTaskFuture == null) goto L9;
        this.mCancellationTaskFuture.cancel(true);     // Catch: Exception -> L6
    L9:
        if (this.mAudioFlinger == null) goto L17;
        this.mAudioFlinger.unlinkToDeath(this.mAudioServerDeathRecipient, 0);     // Catch: Exception -> L6
        this.mAudioFlinger = null;     // Catch: Exception -> L6
        return;
    L17:
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "Swallowing error while shutting down hotword detection.Error message: " + e.getMessage());
    }

    private static /* synthetic */ void lambda$safelyShutdownHotwordDetectionOnVoiceActivationDisabledLocked$6(DetectorSession session) {
        if ((session instanceof VisualQueryDetectorSession) == true) goto L6;
        session.reportErrorLocked(new HotwordDetectionServiceFailure(10, "Shutdown hotword detection service on voice activation op disabled!"));
        session.destroyLocked();
        return;
    }

    public void dump(final String prefix, final PrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.print(prefix);     // Catch: Throwable -> L9
        pw.print("mReStartPeriodSeconds=");     // Catch: Throwable -> L9
        pw.println(this.mReStartPeriodSeconds);     // Catch: Throwable -> L9
        pw.print(prefix);     // Catch: Throwable -> L9
        pw.print("bound for HotwordDetectionService=");     // Catch: Throwable -> L9
        boolean r2 = false;
        if (this.mRemoteHotwordDetectionService != null) goto L7;
    L11:
        boolean r1 = false;
    L12:
        pw.println(r1);     // Catch: Throwable -> L9
        pw.print(prefix);     // Catch: Throwable -> L9
        pw.print("bound for VisualQueryDetectionService=");     // Catch: Throwable -> L9
        if (this.mRemoteVisualQueryDetectionService != null) goto L15;
    L20:
        pw.println(r2);     // Catch: Throwable -> L9
        pw.print(prefix);     // Catch: Throwable -> L9
        pw.print("mRestartCount=");     // Catch: Throwable -> L9
        pw.println(this.mRestartCount);     // Catch: Throwable -> L9
        pw.print(prefix);     // Catch: Throwable -> L9
        pw.print("mLastRestartInstant=");     // Catch: Throwable -> L9
        pw.println(this.mLastRestartInstant);     // Catch: Throwable -> L9
        pw.print(prefix);     // Catch: Throwable -> L9
        pw.println("DetectorSession(s):");     // Catch: Throwable -> L9
        pw.print(prefix);     // Catch: Throwable -> L9
        pw.print("Num of DetectorSession(s)=");     // Catch: Throwable -> L9
        pw.println(this.mDetectorSessions.size());     // Catch: Throwable -> L9
        runForEachDetectorSessionLocked(new HotwordDetectionConnection$$ExternalSyntheticLambda11(prefix, pw));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L15:
        if (this.mRemoteHotwordDetectionService == null) goto L20;
        if (this.mRemoteHotwordDetectionService.isBound() == false) goto L20;
        r2 = true;
        goto L20
    L7:
        if (this.mRemoteHotwordDetectionService.isBound() == false) goto L11;
        r1 = true;
    L9:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$dump$7(String prefix, PrintWriter pw, DetectorSession session) {
        session.dumpLocked(prefix, pw);
    }

    void createDetectorLocked(PersistableBundle options, SharedMemory sharedMemory, IBinder token, IHotwordRecognitionStatusCallback callback, int detectorType) {
        DetectorSession removeSession = this.mDetectorSessions.get(detectorType);
        if (removeSession == null) goto L6;
        removeSession.destroyLocked();
        this.mDetectorSessions.remove(detectorType);
    L6:
        if (detectorType != 1) goto L12;
        if (this.mRemoteHotwordDetectionService != null) goto L10;
        this.mRemoteHotwordDetectionService = this.mHotwordDetectionServiceConnectionFactory.createLocked();
    L10:
        DetectorSession session = new DspTrustedHotwordDetectorSession(this.mRemoteHotwordDetectionService, this.mLock, this.mContext, token, callback, this.mVoiceInteractionServiceUid, this.mVoiceInteractorIdentity, this.mScheduledExecutorService, this.mDebugHotwordLogging, this.mRemoteExceptionListener, this.mUserId);
    L21:
        this.mHotwordRecognitionCallback = callback;
        this.mDetectorSessions.put(detectorType, session);
        session.initialize(options, sharedMemory);
        return;
    L12:
        if (detectorType != 3) goto L18;
        if (this.mRemoteVisualQueryDetectionService != null) goto L16;
        this.mRemoteVisualQueryDetectionService = this.mVisualQueryDetectionServiceConnectionFactory.createLocked();
    L16:
        session = new VisualQueryDetectorSession(this.mRemoteVisualQueryDetectionService, this.mLock, this.mContext, token, callback, this.mVoiceInteractionServiceUid, this.mVoiceInteractorIdentity, this.mScheduledExecutorService, this.mDebugHotwordLogging, this.mRemoteExceptionListener, this.mUserId);
        goto L21
    L18:
        if (this.mRemoteHotwordDetectionService != null) goto L20;
        this.mRemoteHotwordDetectionService = this.mHotwordDetectionServiceConnectionFactory.createLocked();
    L20:
        session = new SoftwareTrustedHotwordDetectorSession(this.mRemoteHotwordDetectionService, this.mLock, this.mContext, token, callback, this.mVoiceInteractionServiceUid, this.mVoiceInteractorIdentity, this.mScheduledExecutorService, this.mDebugHotwordLogging, this.mRemoteExceptionListener, this.mUserId);
        goto L21
    }

    void destroyDetectorLocked(IBinder token) {
        DetectorSession session = getDetectorSessionByTokenLocked(token);
        if (session != null) goto L5;
        return;
    L5:
        session.destroyLocked();
        int index = this.mDetectorSessions.indexOfValue(session);
        if (index < 0) goto L26;
        boolean allHotwordDetectionServiceSessionsRemoved = true;
        if (index > (this.mDetectorSessions.size() - 1)) goto L28;
        this.mDetectorSessions.removeAt(index);
        if ((session instanceof VisualQueryDetectorSession) == false) goto L14;
        unbindVisualQueryDetectionService();
    L14:
        if (this.mDetectorSessions.size() != 0) goto L16;
    L23:
        if (allHotwordDetectionServiceSessionsRemoved == false) goto L27;
        unbindHotwordDetectionService();
        return;
    L27:
        return;
    L16:
        if (this.mDetectorSessions.size() == 1) goto L18;
    L20:
        allHotwordDetectionServiceSessionsRemoved = false;
        goto L23
    L18:
        if ((this.mDetectorSessions.get(0) instanceof VisualQueryDetectorSession) == false) goto L20;
    L28:
        return;
    }

    private DetectorSession getDetectorSessionByTokenLocked(IBinder token) {
        if (token != null) goto L5;
        return null;
    L5:
        int i = 0;
    L7:
        if (i >= this.mDetectorSessions.size()) goto L15;
        DetectorSession session = this.mDetectorSessions.valueAt(i);
        if (session.isDestroyed() == true) goto L13;
        if (session.isSameToken(token) == false) goto L13;
        return session;
    L13:
        i = i + 1;
        goto L7
    L15:
        return null;
    }

    private DspTrustedHotwordDetectorSession getDspTrustedHotwordDetectorSessionLocked() {
        DetectorSession session = this.mDetectorSessions.get(1);
        if (session != null) goto L5;
    L9:
        Slog.v(TAG, "Not found the Dsp detector");
        return null;
    L5:
        if (session.isDestroyed() == true) goto L9;
        return (DspTrustedHotwordDetectorSession) session;
    }

    private SoftwareTrustedHotwordDetectorSession getSoftwareTrustedHotwordDetectorSessionLocked() {
        DetectorSession session = this.mDetectorSessions.get(2);
        if (session != null) goto L5;
    L9:
        Slog.v(TAG, "Not found the software detector");
        return null;
    L5:
        if (session.isDestroyed() == true) goto L9;
        return (SoftwareTrustedHotwordDetectorSession) session;
    }

    private VisualQueryDetectorSession getVisualQueryDetectorSessionLocked() {
        DetectorSession session = this.mDetectorSessions.get(3);
        if (session != null) goto L5;
    L9:
        Slog.v(TAG, "Not found the visual query detector");
        return null;
    L5:
        if (session.isDestroyed() == true) goto L9;
        return (VisualQueryDetectorSession) session;
    }

    private void runForEachDetectorSessionLocked(Consumer<DetectorSession> action) {
        int i = 0;
    L4:
        if (i >= this.mDetectorSessions.size()) goto L7;
        DetectorSession session = this.mDetectorSessions.valueAt(i);
        action.accept(session);
        i = i + 1;
        goto L4
    }

    private static /* synthetic */ void lambda$updateAudioFlinger$8(IBinder audioFlinger, ISandboxedDetectionService service) throws Exception {
        service.updateAudioFlinger(audioFlinger);
    }

    private static void updateAudioFlinger(ServiceConnection connection, final IBinder audioFlinger) {
        connection.run(new HotwordDetectionConnection$$ExternalSyntheticLambda8(audioFlinger));
    }

    private static void updateContentCaptureManager(ServiceConnection connection) {
        IBinder b = ServiceManager.getService("content_capture");
        final IContentCaptureManager binderService = IContentCaptureManager.Stub.asInterface(b);
        connection.run(new HotwordDetectionConnection$$ExternalSyntheticLambda1(binderService));
    }

    private static /* synthetic */ void lambda$updateContentCaptureManager$9(IContentCaptureManager binderService, ISandboxedDetectionService service) throws Exception {
        service.updateContentCaptureManager(binderService, new ContentCaptureOptions(null));
    }

    private static void updateSpeechService(ServiceConnection connection) {
        IBinder b = ServiceManager.getService("speech_recognition");
        final IRecognitionServiceManager binderService = IRecognitionServiceManager.Stub.asInterface(b);
        connection.run(new HotwordDetectionConnection$$ExternalSyntheticLambda12(binderService));
    }

    private static /* synthetic */ void lambda$updateSpeechService$10(IRecognitionServiceManager binderService, ISandboxedDetectionService service) throws Exception {
        service.updateRecognitionServiceManager(binderService);
    }

    private /* synthetic */ void lambda$updateServiceIdentity$11(ISandboxedDetectionService service) throws Exception {
        service.ping(new AnonymousClass2(this));
    }

    private void updateServiceIdentity(ServiceConnection connection) {
        connection.run(new HotwordDetectionConnection$$ExternalSyntheticLambda7(this));
    }

    private void updateStorageService(ServiceConnection connection) {
        connection.run(new HotwordDetectionConnection$$ExternalSyntheticLambda6(this));
    }

    private /* synthetic */ void lambda$updateStorageService$12(ISandboxedDetectionService service) throws Exception {
        service.registerRemoteStorageService(new AnonymousClass3(this));
    }

    private void addServiceUidForAudioPolicy(int isolatedUid, int owningUid) {
        AudioManagerInternal audioManager = (AudioManagerInternal) LocalServices.getService(AudioManagerInternal.class);
        if (audioManager == null) goto L6;
        audioManager.addAssistantServiceUid(isolatedUid, owningUid);
        return;
    }

    private void removeServiceUidForAudioPolicy(int uid) {
        AudioManagerInternal audioManager = (AudioManagerInternal) LocalServices.getService(AudioManagerInternal.class);
        if (audioManager == null) goto L6;
        audioManager.removeAssistantServiceUid(uid);
        return;
    }
}
