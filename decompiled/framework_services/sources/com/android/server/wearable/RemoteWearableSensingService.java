package com.android.server.wearable;

import android.app.wearable.IWearableSensingCallback;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.ParcelFileDescriptor;
import android.os.PersistableBundle;
import android.os.RemoteCallback;
import android.os.SharedMemory;
import android.service.wearable.IWearableSensingService;
import android.util.Slog;
import com.android.internal.infra.ServiceConnector;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
final class RemoteWearableSensingService extends ServiceConnector.Impl<IWearableSensingService> {
    private static final boolean DEBUG = false;
    private static final String TAG = null;
    private SecureWearableConnectionContext mNextSecureConnectionContext;
    private final Object mSecureConnectionLock;
    private boolean mSecureConnectionProvided;

    private static class SecureWearableConnectionContext {
        final ParcelFileDescriptor mSecureConnection;
        final RemoteCallback mStatusCallback;
        final IWearableSensingCallback mWearableSensingCallback;

        SecureWearableConnectionContext(ParcelFileDescriptor secureWearableConnection, IWearableSensingCallback wearableSensingCallback, RemoteCallback statusCallback) {
            this.mSecureConnection = secureWearableConnection;
            this.mWearableSensingCallback = wearableSensingCallback;
            this.mStatusCallback = statusCallback;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$1-5N0F0gjbEyxZ71J0m6Ti3Yz90, reason: not valid java name */
    public static /* synthetic */ void m9552$r8$lambda$15N0F0gjbEyxZ71J0m6Ti3Yz90(RemoteCallback r0, IWearableSensingService r1) {
        lambda$stopHotwordRecognition$9(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$8I0GSJ00qILGEu1XsdNxj3TYsao(int r0, int r1, String r2, RemoteCallback r3, IWearableSensingService r4) {
        lambda$unregisterDataRequestObserver$7(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$8c3n810BH_gtljb6ELo12NLhJ7w(PersistableBundle r0, SharedMemory r1, RemoteCallback r2, IWearableSensingService r3) {
        lambda$provideData$5(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$FOJMvCXjNFzAxksOivDb6nut1Qg(int r0, RemoteCallback r1, int r2, String r3, RemoteCallback r4, IWearableSensingService r5) {
        lambda$registerDataRequestObserver$6(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$JGI7a4LvA6VDYnAsT1asKB5LTkw(RemoteCallback r0, RemoteCallback r1, IWearableSensingService r2) {
        lambda$startHotwordRecognition$8(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$MiuQfNw-o53mOy1qCkCT5ZjfD08, reason: not valid java name */
    public static /* synthetic */ void m9553$r8$lambda$MiuQfNwo53mOy1qCkCT5ZjfD08(IWearableSensingService r0) {
        lambda$stopActiveHotwordAudio$11(r0);
    }

    public static /* synthetic */ void $r8$lambda$RXZ3KXCBmWnqPr0JoOteGvyMrpU(ParcelFileDescriptor r0, IWearableSensingCallback r1, RemoteCallback r2, IWearableSensingService r3) {
        lambda$provideSecureConnectionInternal$1(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$TyR0tJRPhWbTNWryMYZs5ea5DcE(ParcelFileDescriptor r0, PersistableBundle r1, IWearableSensingCallback r2, RemoteCallback r3, IWearableSensingService r4) {
        lambda$provideConcurrentSecureConnection$0(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$iWw9lUnp_MLghsRZDTVKqT87wls(IWearableSensingService r0) {
        lambda$onValidatedByHotwordDetectionService$10(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$pomFs-RkrjlLI6miJ4MdXm_qa2A, reason: not valid java name */
    public static /* synthetic */ void m9554$r8$lambda$pomFsRkrjlLI6miJ4MdXm_qa2A(ParcelFileDescriptor r0, PersistableBundle r1, RemoteCallback r2, IWearableSensingService r3) {
        lambda$provideReadOnlyParcelFileDescriptor$3(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$t98-uh6zOVD85TjB6aI1ADNlRU8, reason: not valid java name */
    public static /* synthetic */ void m9555$r8$lambda$t98uh6zOVD85TjB6aI1ADNlRU8(ParcelFileDescriptor r0, IWearableSensingCallback r1, RemoteCallback r2, IWearableSensingService r3) {
        lambda$provideDataStream$4(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$z7O_VcqmQMfnLLhOA8QO8FJ2wqI(IWearableSensingService r0) {
        lambda$killWearableSensingServiceProcess$2(r0);
    }

    static {
        TAG = RemoteWearableSensingService.class.getSimpleName();
    }

    RemoteWearableSensingService(Context context, ComponentName serviceName, int userId) {
        super(context, new Intent("android.service.wearable.WearableSensingService").setComponent(serviceName), 67112960, userId, new com.android.server.ambientcontext.RemoteWearableSensingService$$ExternalSyntheticLambda1());
        this.mSecureConnectionLock = new Object();
        this.mSecureConnectionProvided = false;
        connect();
    }

    protected long getAutoDisconnectTimeoutMs() {
        return -1;
    }

    public void provideSecureConnection(ParcelFileDescriptor secureWearableConnection, IWearableSensingCallback wearableSensingCallback, RemoteCallback statusCallback) {
        Object r0 = this.mSecureConnectionLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mNextSecureConnectionContext == null) goto L12;
        Slog.i(TAG, "A new wearable connection is provided before the process restart triggered by the previous connection is complete. Discarding the previous connection.");     // Catch: Throwable -> L9
        WearableSensingManagerPerUserService.notifyStatusCallback(this.mNextSecureConnectionContext.mStatusCallback, 7);     // Catch: Throwable -> L9
        this.mNextSecureConnectionContext = new SecureWearableConnectionContext(secureWearableConnection, wearableSensingCallback, statusCallback);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L12:
        if (this.mSecureConnectionProvided == true) goto L16;
        provideSecureConnectionInternal(secureWearableConnection, wearableSensingCallback, statusCallback);     // Catch: Throwable -> L9
        this.mSecureConnectionProvided = true;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L16:
        this.mNextSecureConnectionContext = new SecureWearableConnectionContext(secureWearableConnection, wearableSensingCallback, statusCallback);     // Catch: Throwable -> L9
        killWearableSensingServiceProcess();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    public void provideConcurrentSecureConnection(final ParcelFileDescriptor secureWearableConnection, final PersistableBundle metadata, final IWearableSensingCallback wearableSensingCallback, final RemoteCallback statusCallback) {
        post(new RemoteWearableSensingService$$ExternalSyntheticLambda4(secureWearableConnection, metadata, wearableSensingCallback, statusCallback));
    }

    private static /* synthetic */ void lambda$provideConcurrentSecureConnection$0(ParcelFileDescriptor secureWearableConnection, PersistableBundle metadata, IWearableSensingCallback wearableSensingCallback, RemoteCallback statusCallback, IWearableSensingService service) throws Exception {
        service.provideConcurrentSecureConnection(secureWearableConnection, metadata, wearableSensingCallback, statusCallback);
        secureWearableConnection.close();     // Catch: IOException -> L5
        return;
    L5:
        ex = move-exception;
        Slog.w(TAG, "Unable to close the local parcelFileDescriptor.", ex);
    }

    private void provideSecureConnectionInternal(final ParcelFileDescriptor secureWearableConnection, final IWearableSensingCallback wearableSensingCallback, final RemoteCallback statusCallback) {
        Slog.d(TAG, "Providing secure wearable connection.");
        post(new RemoteWearableSensingService$$ExternalSyntheticLambda5(secureWearableConnection, wearableSensingCallback, statusCallback));
    }

    private static /* synthetic */ void lambda$provideSecureConnectionInternal$1(ParcelFileDescriptor secureWearableConnection, IWearableSensingCallback wearableSensingCallback, RemoteCallback statusCallback, IWearableSensingService service) throws Exception {
        service.provideSecureConnection(secureWearableConnection, wearableSensingCallback, statusCallback);
        secureWearableConnection.close();     // Catch: IOException -> L5
        return;
    L5:
        ex = move-exception;
        Slog.w(TAG, "Unable to close the local parcelFileDescriptor.", ex);
    }

    public void binderDied() {
        super.binderDied();
        Object r0 = this.mSecureConnectionLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mNextSecureConnectionContext == null) goto L9;
        provideSecureConnectionInternal(this.mNextSecureConnectionContext.mSecureConnection, this.mNextSecureConnectionContext.mWearableSensingCallback, this.mNextSecureConnectionContext.mStatusCallback);     // Catch: Throwable -> L7
        this.mNextSecureConnectionContext = null;     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        this.mSecureConnectionProvided = false;     // Catch: Throwable -> L7
        Slog.w(TAG, "Binder died but there is no secure wearable connection to provide.");     // Catch: Throwable -> L7
        goto L10
    }

    private static /* synthetic */ void lambda$killWearableSensingServiceProcess$2(IWearableSensingService service) throws Exception {
        service.killProcess();
    }

    public void killWearableSensingServiceProcess() {
        post(new RemoteWearableSensingService$$ExternalSyntheticLambda0());
    }

    public void provideReadOnlyParcelFileDescriptor(final ParcelFileDescriptor parcelFileDescriptor, final PersistableBundle metadata, final RemoteCallback callback) {
        post(new RemoteWearableSensingService$$ExternalSyntheticLambda8(parcelFileDescriptor, metadata, callback));
    }

    private static /* synthetic */ void lambda$provideReadOnlyParcelFileDescriptor$3(ParcelFileDescriptor parcelFileDescriptor, PersistableBundle metadata, RemoteCallback callback, IWearableSensingService service) throws Exception {
        service.provideReadOnlyParcelFileDescriptor(parcelFileDescriptor, metadata, callback);
        parcelFileDescriptor.close();     // Catch: IOException -> L5
        return;
    L5:
        ex = move-exception;
        Slog.w(TAG, "Unable to close the local parcelFileDescriptor.", ex);
    }

    public void provideDataStream(final ParcelFileDescriptor parcelFileDescriptor, final IWearableSensingCallback wearableSensingCallback, final RemoteCallback callback) {
        post(new RemoteWearableSensingService$$ExternalSyntheticLambda3(parcelFileDescriptor, wearableSensingCallback, callback));
    }

    private static /* synthetic */ void lambda$provideDataStream$4(ParcelFileDescriptor parcelFileDescriptor, IWearableSensingCallback wearableSensingCallback, RemoteCallback callback, IWearableSensingService service) throws Exception {
        service.provideDataStream(parcelFileDescriptor, wearableSensingCallback, callback);
        parcelFileDescriptor.close();     // Catch: IOException -> L5
        return;
    L5:
        ex = move-exception;
        Slog.w(TAG, "Unable to close the local parcelFileDescriptor.", ex);
    }

    private static /* synthetic */ void lambda$provideData$5(PersistableBundle data, SharedMemory sharedMemory, RemoteCallback callback, IWearableSensingService service) throws Exception {
        service.provideData(data, sharedMemory, callback);
    }

    public void provideData(final PersistableBundle data, final SharedMemory sharedMemory, final RemoteCallback callback) {
        post(new RemoteWearableSensingService$$ExternalSyntheticLambda10(data, sharedMemory, callback));
    }

    public void registerDataRequestObserver(final int dataType, final RemoteCallback dataRequestCallback, final int dataRequestObserverId, final String packageName, final RemoteCallback statusCallback) {
        post(new RemoteWearableSensingService$$ExternalSyntheticLambda6(dataType, dataRequestCallback, dataRequestObserverId, packageName, statusCallback));
    }

    private static /* synthetic */ void lambda$registerDataRequestObserver$6(int dataType, RemoteCallback dataRequestCallback, int dataRequestObserverId, String packageName, RemoteCallback statusCallback, IWearableSensingService service) throws Exception {
        service.registerDataRequestObserver(dataType, dataRequestCallback, dataRequestObserverId, packageName, statusCallback);
    }

    public void unregisterDataRequestObserver(final int dataType, final int dataRequestObserverId, final String packageName, final RemoteCallback statusCallback) {
        post(new RemoteWearableSensingService$$ExternalSyntheticLambda11(dataType, dataRequestObserverId, packageName, statusCallback));
    }

    private static /* synthetic */ void lambda$unregisterDataRequestObserver$7(int dataType, int dataRequestObserverId, String packageName, RemoteCallback statusCallback, IWearableSensingService service) throws Exception {
        service.unregisterDataRequestObserver(dataType, dataRequestObserverId, packageName, statusCallback);
    }

    public void startHotwordRecognition(final RemoteCallback wearableHotwordCallback, final RemoteCallback statusCallback) {
        post(new RemoteWearableSensingService$$ExternalSyntheticLambda2(wearableHotwordCallback, statusCallback));
    }

    private static /* synthetic */ void lambda$startHotwordRecognition$8(RemoteCallback wearableHotwordCallback, RemoteCallback statusCallback, IWearableSensingService service) throws Exception {
        service.startHotwordRecognition(wearableHotwordCallback, statusCallback);
    }

    private static /* synthetic */ void lambda$stopHotwordRecognition$9(RemoteCallback statusCallback, IWearableSensingService service) throws Exception {
        service.stopHotwordRecognition(statusCallback);
    }

    public void stopHotwordRecognition(final RemoteCallback statusCallback) {
        post(new RemoteWearableSensingService$$ExternalSyntheticLambda7(statusCallback));
    }

    private static /* synthetic */ void lambda$onValidatedByHotwordDetectionService$10(IWearableSensingService service) throws Exception {
        service.onValidatedByHotwordDetectionService();
    }

    public void onValidatedByHotwordDetectionService() {
        post(new RemoteWearableSensingService$$ExternalSyntheticLambda1());
    }

    private static /* synthetic */ void lambda$stopActiveHotwordAudio$11(IWearableSensingService service) throws Exception {
        service.stopActiveHotwordAudio();
    }

    public void stopActiveHotwordAudio() {
        post(new RemoteWearableSensingService$$ExternalSyntheticLambda9());
    }
}
