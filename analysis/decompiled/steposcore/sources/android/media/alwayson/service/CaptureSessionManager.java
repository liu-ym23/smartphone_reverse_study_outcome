package android.media.alwayson.service;

import android.media.alwayson.AlwaysOnCaptureCallbacks;
import android.media.alwayson.AlwaysOnCaptureConfig;
import android.media.alwayson.AlwaysOnPreRollFetchResult;
import android.media.steposmanager.AlwaysOnRecordSceneInfo;
import android.media.steposmanager.AlwaysOnRecordSceneSegment;
import android.os.Handler;
import android.os.SharedMemory;
import android.system.ErrnoException;
import android.util.Slog;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
final class CaptureSessionManager {
    private static final String TAG = "AlwaysOnCaptureSession";
    private AlwaysOnCaptureConfig mCurrentConfig;
    private AlwaysOnPreRollSnapshot mListenSnapshot;
    private final ManagedCapturePipeline mManagedPipeline;
    private final AlwaysOnVoiceClientService mService;

    CaptureSessionManager(AlwaysOnVoiceClientService service) {
        this.mService = service;
        this.mManagedPipeline = new ManagedCapturePipeline(service);
    }

    void onCaptureRequest(AlwaysOnCaptureConfig config, AlwaysOnPreRollFetchResult preRollResult) {
        this.mCurrentConfig = config;
        AlwaysOnPreRollSnapshot preRoll = buildPreRollSnapshot(preRollResult);
        Slog.i(TAG, "onCaptureRequest sessionId=" + config.sessionId + " trigger=" + config.captureTrigger + " preRollBytes=" + (preRoll != null ? preRoll.sizeInBytes : 0));
        this.mService.dispatchStartAlwaysOnCapture(config, preRoll);
    }

    void onCaptureUpdate(AlwaysOnCaptureConfig config) {
        this.mCurrentConfig = config;
        Slog.i(TAG, "onCaptureUpdate sessionId=" + config.sessionId + " trigger=" + config.captureTrigger);
        this.mService.dispatchUpdateAlwaysOnCapture(config);
    }

    void onCaptureStop(int scope, int reason, String callerTag) {
        Slog.i(TAG, "onCaptureStop scope=" + scope + " reason=" + reason + " callerTag=" + callerTag);
        if (scope == 4 || scope == 3) {
            this.mCurrentConfig = null;
        } else if (this.mCurrentConfig != null && this.mCurrentConfig.captureTrigger == triggerFor(scope)) {
            this.mCurrentConfig = null;
        }
        stopManagedAlwaysOnCapture(reason);
        this.mService.dispatchStopAlwaysOnCapture(reason);
    }

    void onSceneChanged(AlwaysOnRecordSceneInfo scene) {
        this.mManagedPipeline.deliverSceneChanged(scene);
    }

    void onSceneSegmentClosed(AlwaysOnRecordSceneSegment segment) {
        this.mManagedPipeline.deliverSceneSegmentClosed(segment);
    }

    Handler startManagedAlwaysOnCapture(AlwaysOnCaptureConfig config, AlwaysOnCaptureCallbacks callbacks, Handler callbackHandler) {
        Handler readHandler = this.mManagedPipeline.start(config, callbacks, callbackHandler);
        if (readHandler != null) {
            this.mCurrentConfig = config;
        }
        return readHandler;
    }

    void stopManagedAlwaysOnCapture(int reason) {
        this.mManagedPipeline.stop(reason);
    }

    boolean startManagedPreRollListen(AlwaysOnCaptureConfig listenConfig) {
        this.mListenSnapshot = null;
        return false;
    }

    void stopManagedPreRollListen() {
        this.mListenSnapshot = null;
    }

    AlwaysOnPreRollSnapshot peekPreRollSnapshot() {
        return this.mListenSnapshot;
    }

    void destroy() {
        this.mManagedPipeline.stop(4);
        this.mCurrentConfig = null;
    }

    private AlwaysOnPreRollSnapshot buildPreRollSnapshot(AlwaysOnPreRollFetchResult result) {
        if (result == null || result.sharedMemory == null || result.sizeInBytes <= 0 || result.format == null) {
            closeQuietly(result);
            return null;
        }
        SharedMemory sharedMemory = result.sharedMemory;
        ByteBuffer mapped = null;
        try {
            try {
                mapped = sharedMemory.mapReadOnly();
                int size = Math.min(result.sizeInBytes, mapped.remaining());
                byte[] pcm = new byte[size];
                mapped.get(pcm);
                AlwaysOnPreRollSnapshot alwaysOnPreRollSnapshot = new AlwaysOnPreRollSnapshot(pcm, size, result.startTimeNanos, result.endTimeNanos, result.format, result.sceneSegments);
                if (mapped != null) {
                    SharedMemory.unmap(mapped);
                }
                closeQuietly(result);
                return alwaysOnPreRollSnapshot;
            } catch (ErrnoException e) {
                Slog.w(TAG, "Failed to map PreRoll shared memory", e);
                if (mapped != null) {
                    SharedMemory.unmap(mapped);
                }
                closeQuietly(result);
                return null;
            }
        } catch (Throwable th) {
            if (mapped != null) {
                SharedMemory.unmap(mapped);
            }
            closeQuietly(result);
            throw th;
        }
    }

    private static int triggerFor(int scope) {
        if (scope == 1) {
            return 1;
        }
        if (scope == 2) {
            return 2;
        }
        return 3;
    }

    private static void closeQuietly(AlwaysOnPreRollFetchResult result) {
        if (result != null) {
            result.close();
        }
    }
}
