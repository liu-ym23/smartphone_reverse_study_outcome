package android.media.alwayson.service;

import android.app.Service;
import android.content.Intent;
import android.media.alwayson.AlwaysOnCaptureCallbacks;
import android.media.alwayson.AlwaysOnCaptureConfig;
import android.media.alwayson.AlwaysOnPreRollFetchResult;
import android.media.alwayson.service.IAlwaysOnVoiceClient;
import android.media.steposmanager.AlwaysOnRecordSceneInfo;
import android.media.steposmanager.AlwaysOnRecordSceneSegment;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import android.util.Slog;
import android.util.StepOSDateTimeUrlHelper;

/* loaded from: classes.dex */
public abstract class AlwaysOnVoiceClientService extends Service {
    public static final String SERVICE_INTERFACE = "android.service.voice.AlwaysOnVoiceClientService";
    private static final String TAG = "AlwaysOnVoiceClient";
    private final IAlwaysOnVoiceClient.Stub mBinder = new IAlwaysOnVoiceClient.Stub() { // from class: android.media.alwayson.service.AlwaysOnVoiceClientService.1
        @Override // android.media.alwayson.service.IAlwaysOnVoiceClient
        public void onCaptureRequest(AlwaysOnCaptureConfig config, AlwaysOnPreRollFetchResult preRoll) {
            AlwaysOnVoiceClientService.enforceSystemUid();
            Slog.i(AlwaysOnVoiceClientService.TAG, "binder onCaptureRequest sessionId=" + config.sessionId + " trigger=" + config.captureTrigger);
            AlwaysOnVoiceClientService.this.requireSessionManager().onCaptureRequest(config, preRoll);
        }

        @Override // android.media.alwayson.service.IAlwaysOnVoiceClient
        public void onCaptureUpdate(AlwaysOnCaptureConfig config) {
            AlwaysOnVoiceClientService.enforceSystemUid();
            Slog.i(AlwaysOnVoiceClientService.TAG, "binder onCaptureUpdate sessionId=" + config.sessionId);
            AlwaysOnVoiceClientService.this.requireSessionManager().onCaptureUpdate(config);
        }

        @Override // android.media.alwayson.service.IAlwaysOnVoiceClient
        public void onCaptureStop(int stopScope, int reason, String optionalCallerTag) {
            AlwaysOnVoiceClientService.enforceSystemUid();
            Slog.i(AlwaysOnVoiceClientService.TAG, "binder onCaptureStop scope=" + stopScope + " reason=" + reason + " callerTag=" + optionalCallerTag);
            AlwaysOnVoiceClientService.this.requireSessionManager().onCaptureStop(stopScope, reason, optionalCallerTag);
        }

        @Override // android.media.alwayson.service.IAlwaysOnVoiceClient
        public void onReady() {
        }

        @Override // android.media.alwayson.service.IAlwaysOnVoiceClient
        public void onVoiceActivity() {
        }

        @Override // android.media.alwayson.service.IAlwaysOnVoiceClient
        public void onSceneChanged(AlwaysOnRecordSceneInfo scene) {
            AlwaysOnVoiceClientService.enforceSystemUid();
            Slog.i(AlwaysOnVoiceClientService.TAG, "binder onSceneChanged tag=" + scene.sceneTag + StepOSDateTimeUrlHelper.BACKSLASH_STRING + scene.sceneSubTag);
            AlwaysOnVoiceClientService.this.requireSessionManager().onSceneChanged(scene);
        }

        @Override // android.media.alwayson.service.IAlwaysOnVoiceClient
        public void onSceneSegmentClosed(AlwaysOnRecordSceneSegment segment) {
            AlwaysOnVoiceClientService.enforceSystemUid();
            Slog.i(AlwaysOnVoiceClientService.TAG, "binder onSceneSegmentClosed tag=" + segment.sceneTag + StepOSDateTimeUrlHelper.BACKSLASH_STRING + segment.sceneSubTag);
            AlwaysOnVoiceClientService.this.requireSessionManager().onSceneSegmentClosed(segment);
        }
    };
    private CaptureSessionManager mCaptureSessionManager;

    protected abstract void onStartAlwaysOnCapture(AlwaysOnCaptureConfig alwaysOnCaptureConfig, AlwaysOnPreRollSnapshot alwaysOnPreRollSnapshot);

    protected abstract void onStopAlwaysOnCapture(int i);

    protected void onUpdateAlwaysOnCapture(AlwaysOnCaptureConfig config) {
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mCaptureSessionManager = new CaptureSessionManager(this);
        Slog.i(TAG, "onCreate " + getClass().getSimpleName());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        enforceSystemUid();
        Slog.i(TAG, "onBind " + getClass().getSimpleName() + " intent=" + intent);
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onDestroy() {
        Slog.i(TAG, "onDestroy " + getClass().getSimpleName());
        if (this.mCaptureSessionManager != null) {
            this.mCaptureSessionManager.destroy();
        }
        super.onDestroy();
    }

    public final Handler startManagedAlwaysOnCapture(AlwaysOnCaptureConfig config, AlwaysOnCaptureCallbacks callbacks) {
        return startManagedAlwaysOnCapture(config, callbacks, null);
    }

    public final Handler startManagedAlwaysOnCapture(AlwaysOnCaptureConfig config, AlwaysOnCaptureCallbacks callbacks, Handler callbackHandler) {
        return requireSessionManager().startManagedAlwaysOnCapture(config, callbacks, callbackHandler);
    }

    public final void stopManagedAlwaysOnCapture(int reason) {
        requireSessionManager().stopManagedAlwaysOnCapture(reason);
    }

    public final boolean startManagedPreRollListen(AlwaysOnCaptureConfig listenConfig) {
        return requireSessionManager().startManagedPreRollListen(listenConfig);
    }

    public final void stopManagedPreRollListen() {
        requireSessionManager().stopManagedPreRollListen();
    }

    public final AlwaysOnPreRollSnapshot peekPreRollSnapshot() {
        return requireSessionManager().peekPreRollSnapshot();
    }

    final void dispatchStartAlwaysOnCapture(AlwaysOnCaptureConfig config, AlwaysOnPreRollSnapshot preRoll) {
        onStartAlwaysOnCapture(config, preRoll);
    }

    final void dispatchUpdateAlwaysOnCapture(AlwaysOnCaptureConfig config) {
        onUpdateAlwaysOnCapture(config);
    }

    final void dispatchStopAlwaysOnCapture(int reason) {
        onStopAlwaysOnCapture(reason);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CaptureSessionManager requireSessionManager() {
        if (this.mCaptureSessionManager == null) {
            throw new IllegalStateException("AlwaysOnVoiceClientService is not created");
        }
        return this.mCaptureSessionManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void enforceSystemUid() {
        int uid = Binder.getCallingUid();
        if (uid != 1000 && uid != Process.myUid()) {
            throw new SecurityException("Only system_server may bind AlwaysOnVoiceClientService");
        }
    }
}
