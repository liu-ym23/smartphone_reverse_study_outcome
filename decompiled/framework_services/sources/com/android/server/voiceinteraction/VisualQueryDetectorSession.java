package com.android.server.voiceinteraction;

import android.content.Context;
import android.media.AudioFormat;
import android.media.permission.Identity;
import android.os.Binder;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.PersistableBundle;
import android.os.RemoteException;
import android.provider.Settings;
import android.service.voice.IDetectorSessionVisualQueryDetectionCallback;
import android.service.voice.IMicrophoneHotwordDetectionVoiceInteractionCallback;
import android.service.voice.ISandboxedDetectionService;
import android.service.voice.IVisualQueryDetectionVoiceInteractionCallback;
import android.util.Slog;
import com.android.internal.app.IHotwordRecognitionStatusCallback;
import com.android.internal.app.IVisualQueryDetectionAttentionListener;
import java.io.PrintWriter;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes3.dex */
final class VisualQueryDetectorSession extends DetectorSession {
    private static final String TAG = "VisualQueryDetectorSession";
    private static final String VISUAL_QUERY_DETECTION_AUDIO_OP_MESSAGE = "Providing query detection result from VisualQueryDetectionService to VoiceInteractionService";
    private static final String VISUAL_QUERY_DETECTION_CAMERA_OP_MESSAGE = "Providing query detection result from VisualQueryDetectionService to VoiceInteractionService";
    private IVisualQueryDetectionAttentionListener mAttentionListener;
    private boolean mEgressingData;
    private boolean mEnableAccessibilityDataEgress;
    private boolean mQueryStreaming;

    public static /* synthetic */ void $r8$lambda$1rW2CDRKCdK6zJC905YkoB1kmdg(VisualQueryDetectorSession r0, String r1, String r2, int r3) {
        r0.lambda$enforcePermissionsForVisualQueryDelivery$1(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$9Ul23vhk-2iKjg8J9GwYHMZ4I-8, reason: not valid java name */
    public static /* synthetic */ void m9403$r8$lambda$9Ul23vhk2iKjg8J9GwYHMZ4I8(IDetectorSessionVisualQueryDetectionCallback r0, ISandboxedDetectionService r1) {
        lambda$startPerceivingLocked$0(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAttentionListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ IVisualQueryDetectionAttentionListener m9404$$Nest$fgetmAttentionListener(VisualQueryDetectorSession r0) {
        return r0.mAttentionListener;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEgressingData, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9405$$Nest$fgetmEgressingData(VisualQueryDetectorSession r0) {
        return r0.mEgressingData;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEnableAccessibilityDataEgress, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9406$$Nest$fgetmEnableAccessibilityDataEgress(VisualQueryDetectorSession r0) {
        return r0.mEnableAccessibilityDataEgress;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmQueryStreaming, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9407$$Nest$fgetmQueryStreaming(VisualQueryDetectorSession r0) {
        return r0.mQueryStreaming;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmEgressingData, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9408$$Nest$fputmEgressingData(VisualQueryDetectorSession r0, boolean r1) {
        r0.mEgressingData = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmQueryStreaming, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9409$$Nest$fputmQueryStreaming(VisualQueryDetectorSession r0, boolean r1) {
        r0.mQueryStreaming = r1;
    }

    VisualQueryDetectorSession(HotwordDetectionConnection.ServiceConnection remoteService, Object lock, Context context, IBinder token, IHotwordRecognitionStatusCallback callback, int voiceInteractionServiceUid, Identity voiceInteractorIdentity, ScheduledExecutorService scheduledExecutorService, boolean logging, VoiceInteractionManagerServiceImpl.DetectorRemoteExceptionListener listener, int userId) {
        super(remoteService, lock, context, token, callback, voiceInteractionServiceUid, voiceInteractorIdentity, scheduledExecutorService, logging, listener, userId);
        boolean r0 = false;
        this.mEgressingData = false;
        this.mQueryStreaming = false;
        this.mAttentionListener = null;
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "visual_query_accessibility_detection_enabled", 0, this.mUserId) != 1) goto L5;
        r0 = true;
    L5:
        this.mEnableAccessibilityDataEgress = r0;
    }

    @Override // com.android.server.voiceinteraction.DetectorSession
    void informRestartProcessLocked() {
        Slog.v(TAG, "informRestartProcessLocked");
        this.mUpdateStateAfterStartFinished.set(false);
        this.mCallback.onProcessRestarted();     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        Slog.w(TAG, "Failed to communicate #onProcessRestarted", e);
        notifyOnDetectorRemoteException();
    }

    void setVisualQueryDetectionAttentionListenerLocked(IVisualQueryDetectionAttentionListener listener) {
        this.mAttentionListener = listener;
    }

    boolean startPerceivingLocked(final IVisualQueryDetectionVoiceInteractionCallback callback) {
        final IDetectorSessionVisualQueryDetectionCallback.Stub r0 = new AnonymousClass1(this, callback);
        return this.mRemoteDetectionService.run(new VisualQueryDetectorSession$$ExternalSyntheticLambda1(r0));
    }

    private static /* synthetic */ void lambda$startPerceivingLocked$0(IDetectorSessionVisualQueryDetectionCallback internalCallback, ISandboxedDetectionService service) throws Exception {
        service.detectWithVisualSignals(internalCallback);
    }

    boolean stopPerceivingLocked() {
        return this.mRemoteDetectionService.run(new SoftwareTrustedHotwordDetectorSession$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.voiceinteraction.DetectorSession
    void startListeningFromExternalSourceLocked(ParcelFileDescriptor audioStream, AudioFormat audioFormat, PersistableBundle options, IMicrophoneHotwordDetectionVoiceInteractionCallback callback) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("HotwordDetectionService method should not be called from VisualQueryDetectorSession.");
    }

    void updateAccessibilityEgressStateLocked(boolean enable) {
        this.mEnableAccessibilityDataEgress = enable;
    }

    void enforcePermissionsForVisualQueryDelivery(final String permission, final int op, final String msg) {
        Binder.withCleanCallingIdentity(new VisualQueryDetectorSession$$ExternalSyntheticLambda0(this, permission, msg, op));
    }

    private /* synthetic */ void lambda$enforcePermissionsForVisualQueryDelivery$1(String permission, String msg, int op) throws Exception {
        Object r1 = this.mLock;
        monitor-enter(r1);
        DetectorSession.enforcePermissionForDataDelivery(this.mContext, this.mVoiceInteractorIdentity, permission, msg);     // Catch: Throwable -> L11
        this.mAppOpsManager.noteOpNoThrow(op, this.mVoiceInteractorIdentity.uid, this.mVoiceInteractorIdentity.packageName, this.mVoiceInteractorIdentity.attributionTag, msg);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r11 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r11;
    L9:
        th = move-exception;
        r11 = th;
        goto L13
    }

    @Override // com.android.server.voiceinteraction.DetectorSession
    public void dumpLocked(String prefix, PrintWriter pw) {
        super.dumpLocked(prefix, pw);
        pw.print(prefix);
    }
}
