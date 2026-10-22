package com.android.server.voiceinteraction;

import android.content.Context;
import android.hardware.soundtrigger.SoundTrigger;
import android.media.permission.Identity;
import android.os.IBinder;
import android.os.RemoteException;
import android.service.voice.HotwordDetectionServiceFailure;
import android.service.voice.HotwordRejectedResult;
import android.service.voice.IDspHotwordDetectionCallback;
import android.service.voice.ISandboxedDetectionService;
import android.util.Slog;
import com.android.internal.app.IHotwordRecognitionStatusCallback;
import java.io.PrintWriter;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class DspTrustedHotwordDetectorSession extends DetectorSession {
    private static final long MAX_VALIDATION_TIMEOUT_MILLIS = 4000;
    private static final String TAG = "DspTrustedHotwordDetectorSession";
    private static final long VALIDATION_TIMEOUT_MILLIS = 3000;
    private ScheduledFuture<?> mCancellationKeyPhraseDetectionFuture;
    private HotwordRejectedResult mLastHotwordRejectedResult;
    private boolean mValidatingDspTrigger;

    public static /* synthetic */ void $r8$lambda$mQ1wdKCVVNz_0VTKlczxfkoXcfo(DspTrustedHotwordDetectorSession r0, AtomicBoolean r1, IHotwordRecognitionStatusCallback r2) {
        r0.lambda$detectFromDspSourceLocked$0(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$wAEfPcQ0ko_cyC62dddSdT9ghzo(DspTrustedHotwordDetectorSession r0, AtomicBoolean r1, IHotwordRecognitionStatusCallback r2, SoundTrigger.KeyphraseRecognitionEvent r3, IDspHotwordDetectionCallback r4, ISandboxedDetectionService r5) {
        r0.lambda$detectFromDspSourceLocked$1(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCancellationKeyPhraseDetectionFuture, reason: not valid java name */
    static /* bridge */ /* synthetic */ ScheduledFuture m9365$$Nest$fgetmCancellationKeyPhraseDetectionFuture(DspTrustedHotwordDetectorSession r0) {
        return r0.mCancellationKeyPhraseDetectionFuture;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLastHotwordRejectedResult, reason: not valid java name */
    static /* bridge */ /* synthetic */ HotwordRejectedResult m9366$$Nest$fgetmLastHotwordRejectedResult(DspTrustedHotwordDetectorSession r0) {
        return r0.mLastHotwordRejectedResult;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmValidatingDspTrigger, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9367$$Nest$fgetmValidatingDspTrigger(DspTrustedHotwordDetectorSession r0) {
        return r0.mValidatingDspTrigger;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLastHotwordRejectedResult, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9368$$Nest$fputmLastHotwordRejectedResult(DspTrustedHotwordDetectorSession r0, HotwordRejectedResult r1) {
        r0.mLastHotwordRejectedResult = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmValidatingDspTrigger, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9369$$Nest$fputmValidatingDspTrigger(DspTrustedHotwordDetectorSession r0, boolean r1) {
        r0.mValidatingDspTrigger = r1;
    }

    DspTrustedHotwordDetectorSession(HotwordDetectionConnection.ServiceConnection remoteHotwordDetectionService, Object lock, Context context, IBinder token, IHotwordRecognitionStatusCallback callback, int voiceInteractionServiceUid, Identity voiceInteractorIdentity, ScheduledExecutorService scheduledExecutorService, boolean logging, VoiceInteractionManagerServiceImpl.DetectorRemoteExceptionListener listener, int userId) {
        super(remoteHotwordDetectionService, lock, context, token, callback, voiceInteractionServiceUid, voiceInteractorIdentity, scheduledExecutorService, logging, listener, userId);
        this.mValidatingDspTrigger = false;
        this.mLastHotwordRejectedResult = null;
    }

    void detectFromDspSourceLocked(final SoundTrigger.KeyphraseRecognitionEvent recognitionEvent, final IHotwordRecognitionStatusCallback externalCallback) {
        final AtomicBoolean timeoutDetected = new AtomicBoolean(false);
        final IDspHotwordDetectionCallback.Stub r7 = new AnonymousClass1(this, timeoutDetected, recognitionEvent, externalCallback);
        this.mValidatingDspTrigger = true;
        this.mLastHotwordRejectedResult = null;
        this.mRemoteDetectionService.run(new DspTrustedHotwordDetectorSession$$ExternalSyntheticLambda0(this, timeoutDetected, externalCallback, recognitionEvent, r7));
    }

    private /* synthetic */ void lambda$detectFromDspSourceLocked$1(final AtomicBoolean timeoutDetected, final IHotwordRecognitionStatusCallback externalCallback, SoundTrigger.KeyphraseRecognitionEvent recognitionEvent, IDspHotwordDetectionCallback internalCallback, ISandboxedDetectionService service) throws Exception {
        this.mCancellationKeyPhraseDetectionFuture = this.mScheduledExecutorService.schedule(new DspTrustedHotwordDetectorSession$$ExternalSyntheticLambda1(this, timeoutDetected, externalCallback), MAX_VALIDATION_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
        service.detectFromDspSource(recognitionEvent, recognitionEvent.getCaptureFormat(), 3000, internalCallback);
    }

    private /* synthetic */ void lambda$detectFromDspSourceLocked$0(AtomicBoolean timeoutDetected, IHotwordRecognitionStatusCallback externalCallback) {
        timeoutDetected.set(true);
        Slog.w(TAG, "Timed out on #detectFromDspSource");
        HotwordMetricsLogger.writeKeyphraseTriggerEvent(1, 2, this.mVoiceInteractionServiceUid);
        externalCallback.onHotwordDetectionServiceFailure(new HotwordDetectionServiceFailure(4, "Timeout to response to the detection result."));     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        Slog.w(TAG, "Failed to report onError status: ", e);
        HotwordMetricsLogger.writeDetectorEvent(1, 15, this.mVoiceInteractionServiceUid);
        notifyOnDetectorRemoteException();
    }

    @Override // com.android.server.voiceinteraction.DetectorSession
    void informRestartProcessLocked() {
        Slog.v(TAG, "informRestartProcessLocked");
        if (this.mValidatingDspTrigger == true) goto L18;
    L9:
        this.mUpdateStateAfterStartFinished.set(false);
        this.mCallback.onProcessRestarted();     // Catch: RemoteException -> L12
    L14:
        this.mPerformingExternalSourceHotwordDetection = false;
        closeExternalAudioStreamLocked("process restarted");
        return;
    L12:
        e = move-exception;
        Slog.w(TAG, "Failed to communicate #onProcessRestarted", e);
        HotwordMetricsLogger.writeDetectorEvent(1, 18, this.mVoiceInteractionServiceUid);
        notifyOnDetectorRemoteException();
        goto L14
    L18:
        this.mCallback.onRejected(new HotwordRejectedResult.Builder().build());     // Catch: RemoteException -> L6
        HotwordMetricsLogger.writeKeyphraseTriggerEvent(1, 10, this.mVoiceInteractionServiceUid);     // Catch: RemoteException -> L6
    L8:
        this.mValidatingDspTrigger = false;
    L7:
        Slog.w(TAG, "Failed to call #rejected");
        HotwordMetricsLogger.writeDetectorEvent(1, 16, this.mVoiceInteractionServiceUid);
        notifyOnDetectorRemoteException();
        goto L8
    }

    @Override // com.android.server.voiceinteraction.DetectorSession
    public void dumpLocked(String prefix, PrintWriter pw) {
        super.dumpLocked(prefix, pw);
        pw.print(prefix);
        pw.print("mValidatingDspTrigger=");
        pw.println(this.mValidatingDspTrigger);
    }
}
