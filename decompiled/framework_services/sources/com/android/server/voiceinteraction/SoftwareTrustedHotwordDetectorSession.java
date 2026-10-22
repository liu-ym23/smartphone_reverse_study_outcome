package com.android.server.voiceinteraction;

import android.content.Context;
import android.media.AudioFormat;
import android.media.permission.Identity;
import android.os.IBinder;
import android.os.RemoteException;
import android.service.voice.IDspHotwordDetectionCallback;
import android.service.voice.IMicrophoneHotwordDetectionVoiceInteractionCallback;
import android.service.voice.ISandboxedDetectionService;
import android.util.Slog;
import com.android.internal.app.IHotwordRecognitionStatusCallback;
import java.io.PrintWriter;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes3.dex */
final class SoftwareTrustedHotwordDetectorSession extends DetectorSession {
    private static final String TAG = "SoftwareTrustedHotwordDetectorSession";
    private boolean mPerformingSoftwareHotwordDetection;
    private IMicrophoneHotwordDetectionVoiceInteractionCallback mSoftwareCallback;

    public static /* synthetic */ void $r8$lambda$3kOOUMTw0HJZSRjQEk2N46UoTc0(IDspHotwordDetectionCallback r0, ISandboxedDetectionService r1) {
        lambda$startListeningFromMicLocked$0(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPerformingSoftwareHotwordDetection, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9398$$Nest$fgetmPerformingSoftwareHotwordDetection(SoftwareTrustedHotwordDetectorSession r0) {
        return r0.mPerformingSoftwareHotwordDetection;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSoftwareCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ IMicrophoneHotwordDetectionVoiceInteractionCallback m9399$$Nest$fgetmSoftwareCallback(SoftwareTrustedHotwordDetectorSession r0) {
        return r0.mSoftwareCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmPerformingSoftwareHotwordDetection, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9400$$Nest$fputmPerformingSoftwareHotwordDetection(SoftwareTrustedHotwordDetectorSession r0, boolean r1) {
        r0.mPerformingSoftwareHotwordDetection = r1;
    }

    SoftwareTrustedHotwordDetectorSession(HotwordDetectionConnection.ServiceConnection remoteHotwordDetectionService, Object lock, Context context, IBinder token, IHotwordRecognitionStatusCallback callback, int voiceInteractionServiceUid, Identity voiceInteractorIdentity, ScheduledExecutorService scheduledExecutorService, boolean logging, VoiceInteractionManagerServiceImpl.DetectorRemoteExceptionListener listener, int userId) {
        super(remoteHotwordDetectionService, lock, context, token, callback, voiceInteractionServiceUid, voiceInteractorIdentity, scheduledExecutorService, logging, listener, userId);
    }

    void startListeningFromMicLocked(AudioFormat audioFormat, IMicrophoneHotwordDetectionVoiceInteractionCallback callback) {
        this.mSoftwareCallback = callback;
        if (this.mPerformingSoftwareHotwordDetection == false) goto L6;
        Slog.i(TAG, "Hotword validation is already in progress, ignoring.");
        return;
    L6:
        this.mPerformingSoftwareHotwordDetection = true;
        startListeningFromMicLocked();
    }

    private void startListeningFromMicLocked() {
        final IDspHotwordDetectionCallback.Stub r0 = new AnonymousClass1(this);
        this.mRemoteDetectionService.run(new SoftwareTrustedHotwordDetectorSession$$ExternalSyntheticLambda1(r0));
        HotwordMetricsLogger.writeDetectorEvent(2, 9, this.mVoiceInteractionServiceUid);
    }

    private static /* synthetic */ void lambda$startListeningFromMicLocked$0(IDspHotwordDetectionCallback internalCallback, ISandboxedDetectionService service) throws Exception {
        service.detectFromMicrophoneSource(null, 1, null, null, internalCallback);
    }

    void stopListeningFromMicLocked() {
        if (this.mPerformingSoftwareHotwordDetection == true) goto L6;
        Slog.i(TAG, "Hotword detection is not running");
        return;
    L6:
        this.mPerformingSoftwareHotwordDetection = false;
        this.mRemoteDetectionService.run(new SoftwareTrustedHotwordDetectorSession$$ExternalSyntheticLambda0());
        closeExternalAudioStreamLocked("stopping requested");
    }

    @Override // com.android.server.voiceinteraction.DetectorSession
    void informRestartProcessLocked() {
        Slog.v(TAG, "informRestartProcessLocked");
        this.mUpdateStateAfterStartFinished.set(false);
        this.mCallback.onProcessRestarted();     // Catch: RemoteException -> L5
    L8:
        if (this.mPerformingSoftwareHotwordDetection == false) goto L10;
        Slog.i(TAG, "Process restarted: calling startRecognition() again");
        startListeningFromMicLocked();
    L10:
        this.mPerformingExternalSourceHotwordDetection = false;
        closeExternalAudioStreamLocked("process restarted");
        return;
    L5:
        e = move-exception;
        Slog.w(TAG, "Failed to communicate #onProcessRestarted", e);
        HotwordMetricsLogger.writeDetectorEvent(2, 18, this.mVoiceInteractionServiceUid);
        notifyOnDetectorRemoteException();
        goto L8
    }

    @Override // com.android.server.voiceinteraction.DetectorSession
    public void dumpLocked(String prefix, PrintWriter pw) {
        super.dumpLocked(prefix, pw);
        pw.print(prefix);
        pw.print("mPerformingSoftwareHotwordDetection=");
        pw.println(this.mPerformingSoftwareHotwordDetection);
    }
}
