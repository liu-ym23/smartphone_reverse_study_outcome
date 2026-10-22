package com.android.server.musicrecognition;

import android.app.AppGlobals;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.media.AudioRecord;
import android.media.MediaMetadata;
import android.media.musicrecognition.IMusicRecognitionManagerCallback;
import android.media.musicrecognition.IMusicRecognitionServiceCallback;
import android.media.musicrecognition.RecognitionRequest;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Pair;
import android.util.Slog;
import com.android.server.infra.AbstractPerUserSystemService;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.concurrent.CompletableFuture;

/* JADX INFO: loaded from: classes2.dex */
public final class MusicRecognitionManagerPerUserService extends AbstractPerUserSystemService<MusicRecognitionManagerPerUserService, MusicRecognitionManagerService> implements RemoteMusicRecognitionService.Callbacks {
    private static final int BYTES_PER_SAMPLE = 2;
    private static final String KEY_MUSIC_RECOGNITION_SERVICE_ATTRIBUTION_TAG = "android.media.musicrecognition.attributiontag";
    private static final int MAX_STREAMING_SECONDS = 24;
    private static final String MUSIC_RECOGNITION_MANAGER_ATTRIBUTION_TAG = "MusicRecognitionManagerService";
    private static final String TAG = null;
    private final AppOpsManager mAppOpsManager;
    private final String mAttributionMessage;
    private CompletableFuture<String> mAttributionTagFuture;
    private RemoteMusicRecognitionService mRemoteService;
    private ServiceInfo mServiceInfo;

    final class MusicRecognitionServiceCallback extends IMusicRecognitionServiceCallback.Stub {
        private final IMusicRecognitionManagerCallback mClientCallback;
        final /* synthetic */ MusicRecognitionManagerPerUserService this$0;

        /* JADX INFO: renamed from: -$$Nest$mgetClientCallback, reason: not valid java name */
        static /* bridge */ /* synthetic */ IMusicRecognitionManagerCallback m5924$$Nest$mgetClientCallback(MusicRecognitionServiceCallback r0) {
            return r0.getClientCallback();
        }

        /* synthetic */ MusicRecognitionServiceCallback(MusicRecognitionManagerPerUserService r1, IMusicRecognitionManagerCallback r2, MusicRecognitionManagerPerUserServiceIA r3) {
            this(r1, r2);
        }

        private MusicRecognitionServiceCallback(MusicRecognitionManagerPerUserService this$0, IMusicRecognitionManagerCallback clientCallback) {
            this.this$0 = this$0;
            this.mClientCallback = clientCallback;
        }

        public void onRecognitionSucceeded(MediaMetadata result, Bundle extras) {
            MusicRecognitionManagerPerUserService.m5923$$Nest$smsanitizeBundle(extras);     // Catch: RemoteException -> L4
            this.mClientCallback.onRecognitionSucceeded(result, extras);     // Catch: RemoteException -> L4
        L5:
            MusicRecognitionManagerPerUserService.m5922$$Nest$mdestroyService(this.this$0);
        }

        public void onRecognitionFailed(int failureCode) {
            this.mClientCallback.onRecognitionFailed(failureCode);     // Catch: RemoteException -> L4
        L5:
            MusicRecognitionManagerPerUserService.m5922$$Nest$mdestroyService(this.this$0);
        }

        private IMusicRecognitionManagerCallback getClientCallback() {
            return this.mClientCallback;
        }
    }

    public static /* synthetic */ void $r8$lambda$BqIi1eJf1e3M2h2CTbOeHhhNMS4(MusicRecognitionManagerPerUserService r0, RecognitionRequest r1, IMusicRecognitionManagerCallback r2, ParcelFileDescriptor r3, String r4) {
        r0.lambda$beginRecognitionLocked$0(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mdestroyService, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5922$$Nest$mdestroyService(MusicRecognitionManagerPerUserService r0) {
        r0.destroyService();
    }

    /* JADX INFO: renamed from: -$$Nest$smsanitizeBundle, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5923$$Nest$smsanitizeBundle(Bundle r0) {
        sanitizeBundle(r0);
    }

    public /* bridge */ /* synthetic */ void onServiceDied(Object r1) {
        onServiceDied((RemoteMusicRecognitionService) r1);
    }

    static {
        TAG = MusicRecognitionManagerPerUserService.class.getSimpleName();
    }

    MusicRecognitionManagerPerUserService(MusicRecognitionManagerService primary, Object lock, int userId) {
        super(primary, lock, userId);
        this.mAppOpsManager = (AppOpsManager) getContext().createAttributionContext(MUSIC_RECOGNITION_MANAGER_ATTRIBUTION_TAG).getSystemService(AppOpsManager.class);
        this.mAttributionMessage = String.format("MusicRecognitionManager.invokedByUid.%s", new Object[]{Integer.valueOf(userId)});
        this.mAttributionTagFuture = null;
        this.mServiceInfo = null;
    }

    @Override // com.android.server.infra.AbstractPerUserSystemService
    protected ServiceInfo newServiceInfoLocked(ComponentName serviceComponent) throws PackageManager.NameNotFoundException {
        ServiceInfo si = AppGlobals.getPackageManager().getServiceInfo(serviceComponent, 128, this.mUserId);     // Catch: RemoteException -> L8
        if ("android.permission.BIND_MUSIC_RECOGNITION_SERVICE".equals(si.permission) == false) goto L6;
        return si;
    L6:
        Slog.w(TAG, "MusicRecognitionService from '" + si.packageName + "' does not require permission android.permission.BIND_MUSIC_RECOGNITION_SERVICE");
        throw new SecurityException("Service does not require permission android.permission.BIND_MUSIC_RECOGNITION_SERVICE");
    L10:
        throw new PackageManager.NameNotFoundException("Could not get service for " + serviceComponent);
    }

    private RemoteMusicRecognitionService ensureRemoteServiceLocked(IMusicRecognitionManagerCallback clientCallback) {
        if (this.mRemoteService != null) goto L15;
        String serviceName = getComponentNameLocked();
        MusicRecognitionManagerPerUserServiceIA r0 = null;
        if (serviceName == null) goto L7;
        ComponentName serviceComponent = ComponentName.unflattenFromString(serviceName);
        MusicRecognitionManagerPerUserService r8 = this;
        r8.mRemoteService = new RemoteMusicRecognitionService(getContext(), serviceComponent, this.mUserId, r8, new MusicRecognitionServiceCallback(this, clientCallback, r0), ((MusicRecognitionManagerService) this.mMaster).isBindInstantServiceAllowed(), ((MusicRecognitionManagerService) this.mMaster).verbose);
        r8.mServiceInfo = getContext().getPackageManager().getServiceInfo(r8.mRemoteService.getComponentName(), 128);     // Catch: PackageManager.NameNotFoundException -> L13
        r8.mAttributionTagFuture = r8.mRemoteService.getAttributionTag();     // Catch: PackageManager.NameNotFoundException -> L13
        Slog.i(TAG, "Remote service bound: " + r8.mRemoteService.getComponentName());     // Catch: PackageManager.NameNotFoundException -> L13
    L17:
        return r8.mRemoteService;
    L13:
        e = move-exception;
        Slog.e(TAG, "Service was not found.", e);
        goto L17
    L7:
        if (((MusicRecognitionManagerService) this.mMaster).verbose == false) goto L9;
        Slog.v(TAG, "ensureRemoteServiceLocked(): not set");
    L9:
        return null;
    L15:
        r8 = this;
        goto L17
    }

    public void beginRecognitionLocked(final RecognitionRequest recognitionRequest, IBinder callback) {
        final IMusicRecognitionManagerCallback clientCallback = IMusicRecognitionManagerCallback.Stub.asInterface(callback);
        this.mRemoteService = ensureRemoteServiceLocked(clientCallback);
        if (this.mRemoteService == null) goto L20;
        Pair<ParcelFileDescriptor, ParcelFileDescriptor> clientPipe = createPipe();
        if (clientPipe == null) goto L18;
        final ParcelFileDescriptor audioSink = (ParcelFileDescriptor) clientPipe.second;
        ParcelFileDescriptor clientRead = (ParcelFileDescriptor) clientPipe.first;
        this.mAttributionTagFuture.thenAcceptAsync(new MusicRecognitionManagerPerUserService$$ExternalSyntheticLambda0(this, recognitionRequest, clientCallback, audioSink), ((MusicRecognitionManagerService) this.mMaster).mExecutorService);
        this.mRemoteService.onAudioStreamStarted(clientRead, recognitionRequest.getAudioFormat());
        return;
    L18:
        clientCallback.onRecognitionFailed(7);     // Catch: RemoteException -> L14
        return;
    L15:
        return;
    L20:
        clientCallback.onRecognitionFailed(3);     // Catch: RemoteException -> L7
        return;
    }

    private /* synthetic */ void lambda$beginRecognitionLocked$0(RecognitionRequest recognitionRequest, IMusicRecognitionManagerCallback clientCallback, ParcelFileDescriptor audioSink, String tag) {
        streamAudio(tag, recognitionRequest, clientCallback, audioSink);
    }

    private void streamAudio(String attributionTag, RecognitionRequest recognitionRequest, IMusicRecognitionManagerCallback clientCallback, ParcelFileDescriptor audioSink) {
        int maxAudioLengthSeconds = Math.min(recognitionRequest.getMaxAudioLengthSeconds(), 24);
        if (maxAudioLengthSeconds > 0) goto L52;
        Slog.i(TAG, "No audio requested. Closing stream.");
        audioSink.close();     // Catch: RemoteException -> L7 IOException -> L9
        clientCallback.onAudioStreamClosed();     // Catch: RemoteException -> L7 IOException -> L9
        return;
    L9:
        e = move-exception;
        Slog.e(TAG, "Problem closing stream.", e);
        return;
    L66:
        return;
    L52:
        startRecordAudioOp(attributionTag);     // Catch: SecurityException -> L43
        AudioRecord audioRecord = createAudioRecord(recognitionRequest, maxAudioLengthSeconds);
        OutputStream fos = new ParcelFileDescriptor.AutoCloseOutputStream(audioSink);     // Catch: Throwable -> L22 IOException -> L24
        streamAudio(recognitionRequest, maxAudioLengthSeconds, audioRecord, fos);     // Catch: Throwable -> L26
        fos.close();     // Catch: Throwable -> L22 IOException -> L24
        audioRecord.release();
        finishRecordAudioOp(attributionTag);
        clientCallback.onAudioStreamClosed();     // Catch: RemoteException -> L20
    L57:
        return;
    L26:
        th = move-exception;
        fos.close();     // Catch: Throwable -> L29
    L31:
        throw th;     // Catch: Throwable -> L22 IOException -> L24
    L29:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L22 IOException -> L24
    L24:
        e = move-exception;
        Slog.e(TAG, "Audio streaming stopped.", e);     // Catch: Throwable -> L22
        audioRecord.release();
        finishRecordAudioOp(attributionTag);
        clientCallback.onAudioStreamClosed();     // Catch: RemoteException -> L20
    L67:
        return;
    L22:
        th = move-exception;
        audioRecord.release();
        finishRecordAudioOp(attributionTag);
        clientCallback.onAudioStreamClosed();     // Catch: RemoteException -> L41
    L42:
        throw th;
    L43:
        e = move-exception;
        Slog.e(TAG, "RECORD_AUDIO op not permitted on behalf of " + this.mServiceInfo.getComponentName(), e);
        clientCallback.onRecognitionFailed(7);     // Catch: RemoteException -> L47
        return;
    }

    private void streamAudio(RecognitionRequest recognitionRequest, int maxAudioLengthSeconds, AudioRecord audioRecord, OutputStream outputStream) throws IOException {
        int halfSecondBufferSize = audioRecord.getBufferSizeInFrames() / maxAudioLengthSeconds;
        byte[] byteBuffer = new byte[halfSecondBufferSize];
        int bytesRead = 0;
        int totalBytesRead = 0;
        int ignoreBytes = recognitionRequest.getIgnoreBeginningFrames() * 2;
        audioRecord.startRecording();
    L3:
        if (bytesRead < 0) goto L16;
        if (totalBytesRead >= (audioRecord.getBufferSizeInFrames() * 2)) goto L16;
        if (this.mRemoteService == null) goto L16;
        bytesRead = audioRecord.read(byteBuffer, 0, byteBuffer.length);
        if (bytesRead <= 0) goto L3;
        totalBytesRead = totalBytesRead + bytesRead;
        if (ignoreBytes > 0) goto L12;
        outputStream.write(byteBuffer);
        goto L3
    L12:
        ignoreBytes = ignoreBytes - bytesRead;
        if (ignoreBytes >= 0) goto L3;
        outputStream.write(byteBuffer, bytesRead + ignoreBytes, -ignoreBytes);
    L16:
        Slog.i(TAG, String.format("Streamed %s bytes from audio record", new Object[]{Integer.valueOf(totalBytesRead)}));
    }

    public void onServiceDied(RemoteMusicRecognitionService service) {
        MusicRecognitionServiceCallback.m5924$$Nest$mgetClientCallback(service.getServerCallback()).onRecognitionFailed(5);     // Catch: RemoteException -> L4
    L5:
        Slog.w(TAG, "remote service died: " + service);
        destroyService();
    }

    private void destroyService() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mRemoteService == null) goto L9;
        this.mRemoteService.destroy();     // Catch: Throwable -> L7
        this.mRemoteService = null;     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private void startRecordAudioOp(String attributionTag) {
        AppOpsManager r0 = this.mAppOpsManager;
        String r1 = AppOpsManager.permissionToOp("android.permission.RECORD_AUDIO");
        r1.getClass();
        int status = r0.startProxyOp(r1, this.mServiceInfo.applicationInfo.uid, this.mServiceInfo.packageName, attributionTag, this.mAttributionMessage);
        if (status != 0) goto L7;
        Slog.i(TAG, String.format("Starting audio streaming. Attributing to %s (%d) with tag '%s'", new Object[]{this.mServiceInfo.packageName, Integer.valueOf(this.mServiceInfo.applicationInfo.uid), attributionTag}));
        return;
    L7:
        throw new SecurityException(String.format("Failed to obtain RECORD_AUDIO permission (status: %d) for receiving service: %s", new Object[]{Integer.valueOf(status), this.mServiceInfo.getComponentName()}));
    }

    private void finishRecordAudioOp(String attributionTag) {
        AppOpsManager r0 = this.mAppOpsManager;
        String r1 = AppOpsManager.permissionToOp("android.permission.RECORD_AUDIO");
        r1.getClass();
        r0.finishProxyOp(r1, this.mServiceInfo.applicationInfo.uid, this.mServiceInfo.packageName, attributionTag);
    }

    private static AudioRecord createAudioRecord(RecognitionRequest recognitionRequest, int maxAudioLengthSeconds) {
        int sampleRate = recognitionRequest.getAudioFormat().getSampleRate();
        int bufferSize = getBufferSizeInBytes(sampleRate, maxAudioLengthSeconds);
        return new AudioRecord(recognitionRequest.getAudioAttributes(), recognitionRequest.getAudioFormat(), bufferSize, recognitionRequest.getCaptureSession());
    }

    private static int getBufferSizeInBytes(int sampleRate, int bufferLengthSeconds) {
        return (sampleRate * 2) * bufferLengthSeconds;
    }

    private static Pair<ParcelFileDescriptor, ParcelFileDescriptor> createPipe() {
        ParcelFileDescriptor[] fileDescriptors = ParcelFileDescriptor.createPipe();     // Catch: IOException -> L17
        if (fileDescriptors.length == 2) goto L9;
        Slog.e(TAG, "Failed to create audio stream pipe, unexpected number of file descriptors");
        return null;
    L9:
        if (fileDescriptors[0].getFileDescriptor().valid() == true) goto L11;
    L15:
        Slog.e(TAG, "Failed to create audio stream pipe, didn't receive a pair of valid file descriptors.");
        return null;
    L11:
        if (fileDescriptors[1].getFileDescriptor().valid() == false) goto L15;
        return Pair.create(fileDescriptors[0], fileDescriptors[1]);
    L17:
        e = move-exception;
        Slog.e(TAG, "Failed to create audio stream pipe", e);
        return null;
    }

    private static void sanitizeBundle(Bundle bundle) {
        if (bundle != null) goto L4;
        return;
    L4:
        Iterator<String> r0 = bundle.keySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L16;
        String key = r0.next();
        Object o = bundle.get(key);
        if ((o instanceof Bundle) == true) goto L9;
        if ((o instanceof IBinder) == true) goto L14;
        if ((o instanceof ParcelFileDescriptor) == false) goto L6;
    L14:
        bundle.remove(key);
        goto L6
    L9:
        sanitizeBundle((Bundle) o);
        goto L6
    }
}
