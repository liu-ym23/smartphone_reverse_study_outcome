package android.media.alwayson.service;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.alwayson.AlwaysOnCaptureAudioFormat;
import android.media.alwayson.AlwaysOnCaptureCallbacks;
import android.media.alwayson.AlwaysOnCaptureConfig;
import android.media.steposmanager.AlwaysOnRecordSceneInfo;
import android.media.steposmanager.AlwaysOnRecordSceneSegment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Slog;
import android.util.StepOSDateTimeUrlHelper;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
final class ManagedCapturePipeline {
    private static final int DEFAULT_PERIOD_FRAMES = 1024;
    private static final int DEFAULT_READ_BYTES = 2048;
    private static final int DEFAULT_SAMPLE_RATE = 16000;
    private static final String HAL_VENDOR_TAG = "VX_OEM_REC_ALWAYS_ON";
    private static final int MAX_PENDING_PCM_FRAMES = 20;
    private static final int MSG_PCM = 1;
    private static final String TAG = "AlwaysOnManagedPipeline";
    private int mAudioSessionId;
    private Handler mCallbackHandler;
    private AlwaysOnCaptureCallbacks mCallbacks;
    private final Context mContext;
    private long mLastPendingDropLogUptimeMs;
    private boolean mLoggedFirstPcm;
    private Handler mPcmDispatchHandler;
    private volatile boolean mPcmDispatchStopped;
    private byte[] mReadBuffer;
    private Handler mReadHandler;
    private HandlerThread mReadThread;
    private AudioRecord mRecord;
    private volatile boolean mRunning;
    private final Object mStateLock = new Object();
    private final AtomicInteger mPendingPcmCount = new AtomicInteger();

    ManagedCapturePipeline(Context context) {
        this.mContext = context;
    }

    Handler start(final AlwaysOnCaptureConfig config, final AlwaysOnCaptureCallbacks callbacks, final Handler callbackHandler) {
        Handler readHandler;
        synchronized (this.mStateLock) {
            if (this.mReadHandler != null) {
                readHandler = this.mReadHandler;
            } else {
                HandlerThread readThread = new HandlerThread("AlwaysOnCaptureRead");
                readThread.start();
                Handler readHandler2 = new Handler(readThread.getLooper());
                this.mReadThread = readThread;
                this.mReadHandler = readHandler2;
                readHandler = readHandler2;
            }
        }
        readHandler.post(new Runnable() { // from class: android.media.alwayson.service.ManagedCapturePipeline$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() throws UnsupportedOperationException, IllegalStateException {
                this.f$0.lambda$start$0(config, callbacks, callbackHandler);
            }
        });
        return readHandler;
    }

    void stop(final int reason) throws IllegalStateException {
        Handler readHandler;
        AudioRecord record;
        synchronized (this.mStateLock) {
            readHandler = this.mReadHandler;
            this.mRunning = false;
            record = this.mRecord;
        }
        if (record != null) {
            try {
                record.stop();
            } catch (IllegalStateException e) {
            }
        }
        if (readHandler == null) {
            return;
        }
        if (readHandler.getLooper() == Looper.myLooper()) {
            lambda$stop$1(reason);
        } else {
            readHandler.post(new Runnable() { // from class: android.media.alwayson.service.ManagedCapturePipeline$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() throws IllegalStateException {
                    this.f$0.lambda$stop$1(reason);
                }
            });
        }
    }

    boolean isRunning() {
        boolean z;
        synchronized (this.mStateLock) {
            z = this.mRunning;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startOnReadThread, reason: merged with bridge method [inline-methods] */
    public void lambda$start$0(AlwaysOnCaptureConfig config, AlwaysOnCaptureCallbacks callbacks, Handler callbackHandler) throws UnsupportedOperationException, IllegalStateException {
        int readBufferSize;
        if (this.mRunning) {
            Slog.d(TAG, "start ignored: pipeline already running sessionId=" + config.sessionId);
            return;
        }
        this.mCallbacks = callbacks;
        this.mCallbackHandler = callbackHandler;
        AudioRecord record = createManagedAudioRecord(config);
        if (record == null) {
            Slog.w(TAG, "AudioRecord create failed sessionId=" + config.sessionId);
            lambda$stop$1(9);
            return;
        }
        if (record.getState() != 1) {
            Slog.w(TAG, "AudioRecord not initialized sessionId=" + config.sessionId);
            safeRelease(record);
            lambda$stop$1(9);
            return;
        }
        if (config.bufferSizeInBytes > 0) {
            readBufferSize = Math.min(config.bufferSizeInBytes, 4096);
        } else {
            readBufferSize = 2048;
        }
        this.mPcmDispatchStopped = false;
        this.mPendingPcmCount.set(0);
        this.mLoggedFirstPcm = false;
        if (callbackHandler != null) {
            this.mPcmDispatchHandler = new Handler(callbackHandler.getLooper()) { // from class: android.media.alwayson.service.ManagedCapturePipeline.1
                @Override // android.os.Handler
                public void handleMessage(Message msg) {
                    if (msg.what == 1) {
                        ManagedCapturePipeline.this.deliverPcmMessage((PcmChunk) msg.obj);
                    }
                }
            };
        }
        this.mRecord = record;
        this.mReadBuffer = new byte[readBufferSize];
        try {
            record.startRecording();
            AlwaysOnCaptureAudioFormat captureFormat = AlwaysOnCaptureAudioFormat.fromAudioRecord(record);
            this.mAudioSessionId = captureFormat.audioSessionId;
            this.mRunning = true;
            Slog.i(TAG, "Pipeline started sessionId=" + config.sessionId + " trigger=" + config.captureTrigger + " rate=" + captureFormat.sampleRate + " session=" + captureFormat.audioSessionId);
            dispatchStarted(captureFormat);
            postReadOnce();
        } catch (RuntimeException e) {
            Slog.w(TAG, "Failed to start always-on AudioRecord", e);
            lambda$stop$1(9);
        }
    }

    private AudioRecord createManagedAudioRecord(AlwaysOnCaptureConfig config) throws UnsupportedOperationException {
        int sampleRate = config.sampleRate > 0 ? config.sampleRate : DEFAULT_SAMPLE_RATE;
        int channelMask = config.channelMask != 0 ? config.channelMask : 16;
        int encoding = config.encoding != 0 ? config.encoding : 2;
        int minBuffer = AudioRecord.getMinBufferSize(sampleRate, channelMask, encoding);
        int bufferSize = config.bufferSizeInBytes > 0 ? config.bufferSizeInBytes : Math.max(minBuffer, 4096);
        AudioFormat format = new AudioFormat.Builder().setSampleRate(sampleRate).setChannelMask(channelMask).setEncoding(encoding).build();
        AudioAttributes attributes = new AudioAttributes.Builder().setCapturePreset(2001).addTag(HAL_VENDOR_TAG).build();
        Slog.i(TAG, "Creating AudioRecord sessionId=" + config.sessionId + " source=2001 tag=" + HAL_VENDOR_TAG + " rate=" + sampleRate + " bufferSize=" + bufferSize);
        try {
            AudioRecord record = new AudioRecord.Builder().setContext(this.mContext).setAudioAttributes(attributes).setAudioFormat(format).setBufferSizeInBytes(bufferSize).build();
            pinToBuiltinMic(record, config.sessionId);
            return record;
        } catch (RuntimeException e) {
            Slog.e(TAG, "AudioRecord build failed sessionId=" + config.sessionId + " source=2001 tag=" + HAL_VENDOR_TAG, e);
            return null;
        }
    }

    private void pinToBuiltinMic(AudioRecord record, int sessionId) {
        AudioDeviceInfo builtinMic = findBuiltinMic();
        if (builtinMic == null) {
            Slog.w(TAG, "No TYPE_BUILTIN_MIC; cannot pin sessionId=" + sessionId);
        } else {
            boolean pinned = record.setPreferredDevice(builtinMic);
            Slog.i(TAG, (pinned ? "Pinned" : "Failed to pin") + " AudioRecord to builtin mic sessionId=" + sessionId + " " + describeDevice(builtinMic));
        }
    }

    private AudioDeviceInfo findBuiltinMic() {
        AudioManager am = (AudioManager) this.mContext.getSystemService(AudioManager.class);
        if (am == null) {
            return null;
        }
        AudioDeviceInfo[] devices = am.getDevices(1);
        for (AudioDeviceInfo device : devices) {
            if (device.getType() == 15) {
                return device;
            }
        }
        return null;
    }

    private static String describeDevice(AudioDeviceInfo device) {
        if (device == null) {
            return "device=none";
        }
        return "type=" + device.getType() + " id=" + device.getId() + " name=" + ((Object) device.getProductName());
    }

    private void postReadOnce() {
        Handler h;
        synchronized (this.mStateLock) {
            h = this.mReadHandler;
        }
        if (h != null) {
            h.post(new Runnable() { // from class: android.media.alwayson.service.ManagedCapturePipeline$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() throws IllegalStateException {
                    this.f$0.readOnceOnReadThread();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readOnceOnReadThread() throws IllegalStateException {
        if (!this.mRunning) {
            return;
        }
        AudioRecord record = this.mRecord;
        byte[] buffer = this.mReadBuffer;
        if (record == null || buffer == null) {
            return;
        }
        try {
            int size = record.read(buffer, 0, buffer.length, 0);
            if (size > 0) {
                if (!this.mLoggedFirstPcm) {
                    this.mLoggedFirstPcm = true;
                    Slog.i(TAG, "First PCM frame size=" + size);
                }
                dispatchPcmCallback(buffer, size, SystemClock.elapsedRealtimeNanos());
            } else if (size < 0) {
                Slog.w(TAG, "Always-on AudioRecord read error: " + size);
                lambda$stop$1(2);
                return;
            }
            if (this.mRunning) {
                postReadOnce();
            }
        } catch (RuntimeException e) {
            Slog.w(TAG, "Always-on AudioRecord read failed", e);
            lambda$stop$1(2);
        }
    }

    private void dispatchStarted(final AlwaysOnCaptureAudioFormat format) {
        final AlwaysOnCaptureCallbacks callbacks = this.mCallbacks;
        if (callbacks == null) {
            return;
        }
        runOnCallbackHandler(new Runnable() { // from class: android.media.alwayson.service.ManagedCapturePipeline$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                callbacks.onCapturePipelineStarted(format);
            }
        });
    }

    private void dispatchPcmCallback(byte[] buffer, int size, long timestampNanos) {
        AlwaysOnCaptureCallbacks callbacks = this.mCallbacks;
        if (callbacks == null) {
            return;
        }
        Handler dispatchHandler = this.mPcmDispatchHandler;
        if (dispatchHandler == null) {
            callbacks.onPcmAvailable(buffer, size, timestampNanos);
            return;
        }
        if (this.mPendingPcmCount.get() >= 20) {
            logPendingDropIfNeeded();
            return;
        }
        byte[] copy = Arrays.copyOf(buffer, size);
        this.mPendingPcmCount.incrementAndGet();
        Message msg = dispatchHandler.obtainMessage(1, new PcmChunk(copy, size, timestampNanos));
        dispatchHandler.sendMessage(msg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deliverPcmMessage(PcmChunk chunk) {
        AlwaysOnCaptureCallbacks callbacks;
        if (this.mPcmDispatchStopped) {
            return;
        }
        releasePendingPcmCount();
        if (chunk != null && (callbacks = this.mCallbacks) != null) {
            callbacks.onPcmAvailable(chunk.buffer, chunk.size, chunk.timestampNanos);
        }
    }

    private void releasePendingPcmCount() {
        int remaining = this.mPendingPcmCount.decrementAndGet();
        if (remaining < 0) {
            this.mPendingPcmCount.compareAndSet(remaining, 0);
        }
    }

    private void logPendingDropIfNeeded() {
        long now = SystemClock.uptimeMillis();
        if (now - this.mLastPendingDropLogUptimeMs < 1000) {
            return;
        }
        this.mLastPendingDropLogUptimeMs = now;
        Slog.w(TAG, "Dropping newest PCM frame because callback queue is full");
    }

    private void clearPendingPcm() {
        this.mPcmDispatchStopped = true;
        Handler dispatchHandler = this.mPcmDispatchHandler;
        if (dispatchHandler != null) {
            dispatchHandler.removeMessages(1);
        }
        this.mPendingPcmCount.set(0);
    }

    private void dispatchStopping(final int reason) {
        final AlwaysOnCaptureCallbacks callbacks = this.mCallbacks;
        if (callbacks == null) {
            return;
        }
        runOnCallbackHandler(new Runnable() { // from class: android.media.alwayson.service.ManagedCapturePipeline$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                callbacks.onCapturePipelineStopping(reason);
            }
        });
    }

    void deliverSceneChanged(final AlwaysOnRecordSceneInfo scene) {
        postSceneCallback(new Runnable() { // from class: android.media.alwayson.service.ManagedCapturePipeline$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deliverSceneChanged$4(scene);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deliverSceneChanged$4(AlwaysOnRecordSceneInfo scene) {
        AlwaysOnCaptureCallbacks callbacks = this.mCallbacks;
        if (callbacks != null) {
            Slog.i(TAG, "deliver onSceneChanged tag=" + scene.sceneTag + StepOSDateTimeUrlHelper.BACKSLASH_STRING + scene.sceneSubTag);
            callbacks.onSceneChanged(scene);
        }
    }

    void deliverSceneSegmentClosed(final AlwaysOnRecordSceneSegment segment) {
        postSceneCallback(new Runnable() { // from class: android.media.alwayson.service.ManagedCapturePipeline$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deliverSceneSegmentClosed$5(segment);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deliverSceneSegmentClosed$5(AlwaysOnRecordSceneSegment segment) {
        AlwaysOnCaptureCallbacks callbacks = this.mCallbacks;
        if (callbacks != null) {
            Slog.i(TAG, "deliver onSceneSegmentClosed tag=" + segment.sceneTag + StepOSDateTimeUrlHelper.BACKSLASH_STRING + segment.sceneSubTag);
            callbacks.onSceneSegmentClosed(segment);
        }
    }

    private void postSceneCallback(Runnable action) {
        if (!this.mRunning) {
            Slog.i(TAG, "drop scene callback: pipeline not running");
            return;
        }
        Handler sceneHandler = this.mCallbackHandler != null ? this.mCallbackHandler : this.mReadHandler;
        if (sceneHandler == null) {
            Slog.i(TAG, "drop scene callback: no handler");
        } else if (sceneHandler.getLooper().isCurrentThread()) {
            action.run();
        } else {
            sceneHandler.post(action);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: stopOnReadThread, reason: merged with bridge method [inline-methods] */
    public void lambda$stop$1(int reason) throws IllegalStateException {
        if (!this.mRunning && this.mRecord == null && this.mReadThread == null) {
            return;
        }
        this.mRunning = false;
        Slog.i(TAG, "Pipeline stopping reason=" + reason);
        AudioRecord record = this.mRecord;
        if (record != null) {
            try {
                record.stop();
            } catch (IllegalStateException e) {
            }
        }
        dispatchStopping(reason);
        this.mAudioSessionId = 0;
        clearPendingPcm();
        if (record != null) {
            safeRelease(record);
        }
        cleanupThreadStateOnReadThread();
    }

    private void cleanupThreadStateOnReadThread() {
        HandlerThread readThread = this.mReadThread;
        this.mRecord = null;
        this.mReadThread = null;
        this.mReadHandler = null;
        this.mReadBuffer = null;
        this.mCallbacks = null;
        this.mCallbackHandler = null;
        this.mPcmDispatchHandler = null;
        if (readThread != null) {
            readThread.quitSafely();
        }
    }

    private void runOnCallbackHandler(Runnable runnable) {
        Handler handler = this.mCallbackHandler;
        if (handler == null || handler.getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }

    private static void safeRelease(AudioRecord record) {
        try {
            record.release();
        } catch (RuntimeException e) {
            Slog.w(TAG, "Failed to release always-on AudioRecord", e);
        }
    }

    private static final class PcmChunk {
        final byte[] buffer;
        final int size;
        final long timestampNanos;

        PcmChunk(byte[] buffer, int size, long timestampNanos) {
            this.buffer = buffer;
            this.size = size;
            this.timestampNanos = timestampNanos;
        }
    }
}
