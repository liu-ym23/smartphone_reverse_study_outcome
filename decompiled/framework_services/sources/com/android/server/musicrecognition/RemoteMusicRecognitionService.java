package com.android.server.musicrecognition;

import android.content.ComponentName;
import android.content.Context;
import android.media.AudioFormat;
import android.media.musicrecognition.IMusicRecognitionService;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.android.internal.infra.AbstractMultiplePendingRequestsRemoteService;
import com.android.internal.infra.AbstractRemoteService;
import java.util.concurrent.CompletableFuture;

/* JADX INFO: loaded from: classes2.dex */
public class RemoteMusicRecognitionService extends AbstractMultiplePendingRequestsRemoteService<RemoteMusicRecognitionService, IMusicRecognitionService> {
    private static final long TIMEOUT_IDLE_BIND_MILLIS = 40000;
    private final MusicRecognitionManagerPerUserService.MusicRecognitionServiceCallback mServerCallback;

    interface Callbacks extends AbstractRemoteService.VultureCallback<RemoteMusicRecognitionService> {
    }

    public static /* synthetic */ void $r8$lambda$S16PJcyF8rFnTbNbCxszt1Klyqs(RemoteMusicRecognitionService r0, ParcelFileDescriptor r1, AudioFormat r2, IMusicRecognitionService r3) {
        r0.lambda$onAudioStreamStarted$0(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$ZgapEfils6br_bqos5FLqYRQxEw(RemoteMusicRecognitionService r0, CompletableFuture r1, IMusicRecognitionService r2) {
        r0.lambda$getAttributionTag$1(r1, r2);
    }

    /* JADX INFO: renamed from: getServiceInterface, reason: collision with other method in class */
    protected /* bridge */ /* synthetic */ IInterface m5927getServiceInterface(IBinder r1) {
        return getServiceInterface(r1);
    }

    public RemoteMusicRecognitionService(Context context, ComponentName serviceName, int userId, MusicRecognitionManagerPerUserService perUserService, MusicRecognitionManagerPerUserService.MusicRecognitionServiceCallback callback, boolean bindInstantServiceAllowed, boolean verbose) {
        Handler r6 = context.getMainThreadHandler();
        if (bindInstantServiceAllowed == false) goto L5;
        int r0 = 4194304;
    L6:
        super(context, "android.service.musicrecognition.MUSIC_RECOGNITION", serviceName, userId, perUserService, r6, r0 | 4096, verbose, 1);
        this.mServerCallback = callback;
        return;
    L5:
        r0 = 0;
        goto L6
    }

    protected IMusicRecognitionService getServiceInterface(IBinder service) {
        return IMusicRecognitionService.Stub.asInterface(service);
    }

    protected long getTimeoutIdleBindMillis() {
        return TIMEOUT_IDLE_BIND_MILLIS;
    }

    MusicRecognitionManagerPerUserService.MusicRecognitionServiceCallback getServerCallback() {
        return this.mServerCallback;
    }

    public void onAudioStreamStarted(final ParcelFileDescriptor fd, final AudioFormat audioFormat) {
        scheduleAsyncRequest(new RemoteMusicRecognitionService$$ExternalSyntheticLambda0(this, fd, audioFormat));
    }

    private /* synthetic */ void lambda$onAudioStreamStarted$0(ParcelFileDescriptor fd, AudioFormat audioFormat, IMusicRecognitionService binder) throws RemoteException {
        binder.onAudioStreamStarted(fd, audioFormat, this.mServerCallback);
    }

    public CompletableFuture<String> getAttributionTag() {
        final CompletableFuture<String> attributionTagFuture = new CompletableFuture();
        scheduleAsyncRequest(new RemoteMusicRecognitionService$$ExternalSyntheticLambda1(this, attributionTagFuture));
        return attributionTagFuture;
    }

    private /* synthetic */ void lambda$getAttributionTag$1(final CompletableFuture attributionTagFuture, IMusicRecognitionService binder) throws RemoteException {
        binder.getAttributionTag(new AnonymousClass1(this, attributionTagFuture));
    }
}
