package com.android.server.wearable;

import android.companion.AssociationInfo;
import android.companion.AssociationRequest;
import android.companion.CompanionDeviceManager;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.util.Slog;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
final class WearableSensingSecureChannel {
    private static final String CDM_ASSOCIATION_DISPLAY_NAME = "PlaceholderDisplayNameFromWSM";
    private static final int READ_BUFFER_SIZE = 8192;
    private static final String TAG = null;
    private Integer mAssociationId;
    private boolean mClosed;
    private final CompanionDeviceManager mCompanionDeviceManager;
    private final SoftShutdownExecutor mLightWeightExecutor;
    private final InputStream mLocalIn;
    private final OutputStream mLocalOut;
    private final Object mLock;
    private final SoftShutdownExecutor mMessageFromWearableExecutor;
    private final SoftShutdownExecutor mMessageToWearableExecutor;
    private final BiConsumer<Integer, byte[]> mOnMessageReceivedListener;
    private final Consumer<List<AssociationInfo>> mOnTransportsChangedListener;
    private final ParcelFileDescriptor mRemoteFd;
    private final SecureTransportListener mSecureTransportListener;
    private final AtomicBoolean mTransportAvailable;
    private final ParcelFileDescriptor mUnderlyingTransport;

    interface SecureTransportListener {
        void onError();

        void onSecureTransportAvailable(ParcelFileDescriptor r1);
    }

    private static class SoftShutdownExecutor implements Executor {
        private final ExecutorService mExecutorService;

        SoftShutdownExecutor(ExecutorService executorService) {
            this.mExecutorService = executorService;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.mExecutorService.execute(runnable);     // Catch: RejectedExecutionException -> L4
            return;
        L5:
            Slog.d(WearableSensingSecureChannel.m9580$$Nest$sfgetTAG(), "Received new runnable after shutdown. Ignoring.");
        }

        void shutdown() {
            this.mExecutorService.shutdown();
        }
    }

    public static /* synthetic */ void $r8$lambda$559WS3gaiFnRFy3miioUQSPcA9g(WearableSensingSecureChannel r0, int r1, byte[] r2) {
        r0.onMessageReceived(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$YrHIBGaUY5-Cvpo8dku47unJd88, reason: not valid java name */
    public static /* synthetic */ void m9577$r8$lambda$YrHIBGaUY5Cvpo8dku47unJd88(WearableSensingSecureChannel r0) {
        r0.lambda$onTransportAvailable$1();
    }

    public static /* synthetic */ void $r8$lambda$hH2G6TouiROpvJ_1ufD97vY6Zu0(WearableSensingSecureChannel r0, List r1) {
        r0.onTransportsChanged(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$mQ04zdXFJOXafuHjYL6IU1ngmm8(WearableSensingSecureChannel r0, AssociationInfo r1) {
        return r0.lambda$onTransportsChanged$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monAssociationCreated, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9578$$Nest$monAssociationCreated(WearableSensingSecureChannel r0, int r1) {
        r0.onAssociationCreated(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monError, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9579$$Nest$monError(WearableSensingSecureChannel r0) {
        r0.onError();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m9580$$Nest$sfgetTAG() {
        return TAG;
    }

    static {
        TAG = WearableSensingSecureChannel.class.getSimpleName();
    }

    static WearableSensingSecureChannel create(CompanionDeviceManager companionDeviceManager, ParcelFileDescriptor underlyingTransport, SecureTransportListener secureTransportListener) throws IOException {
        companionDeviceManager.getClass();
        underlyingTransport.getClass();
        secureTransportListener.getClass();
        ParcelFileDescriptor[] pair = ParcelFileDescriptor.createSocketPair();
        WearableSensingSecureChannel channel = new WearableSensingSecureChannel(companionDeviceManager, underlyingTransport, secureTransportListener, pair[0], pair[1]);
        channel.initialize();
        return channel;
    }

    private WearableSensingSecureChannel(CompanionDeviceManager companionDeviceManager, ParcelFileDescriptor underlyingTransport, SecureTransportListener secureTransportListener, ParcelFileDescriptor remoteFd, ParcelFileDescriptor localFd) {
        this.mLock = new Object();
        this.mMessageFromWearableExecutor = new SoftShutdownExecutor(Executors.newSingleThreadExecutor());
        this.mMessageToWearableExecutor = new SoftShutdownExecutor(Executors.newSingleThreadExecutor());
        this.mLightWeightExecutor = new SoftShutdownExecutor(Executors.newSingleThreadExecutor());
        this.mTransportAvailable = new AtomicBoolean(false);
        this.mOnTransportsChangedListener = new WearableSensingSecureChannel$$ExternalSyntheticLambda1(this);
        this.mOnMessageReceivedListener = new WearableSensingSecureChannel$$ExternalSyntheticLambda2(this);
        this.mClosed = false;
        this.mAssociationId = null;
        this.mCompanionDeviceManager = companionDeviceManager;
        this.mUnderlyingTransport = underlyingTransport;
        this.mSecureTransportListener = secureTransportListener;
        this.mRemoteFd = remoteFd;
        this.mLocalIn = new ParcelFileDescriptor.AutoCloseInputStream(localFd);
        this.mLocalOut = new ParcelFileDescriptor.AutoCloseOutputStream(localFd);
    }

    private void initialize() {
        long originalCallingIdentity = Binder.clearCallingIdentity();
        Slog.d(TAG, "Requesting CDM association.");     // Catch: Throwable -> L6
        this.mCompanionDeviceManager.associate(new AssociationRequest.Builder().setDisplayName(CDM_ASSOCIATION_DISPLAY_NAME).setSelfManaged(true).setDeviceProfile("android.companion.COMPANION_DEVICE_WEARABLE_SENSING").build(), this.mLightWeightExecutor, new AnonymousClass1(this));     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(originalCallingIdentity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(originalCallingIdentity);
        throw th;
    }

    private void onAssociationCreated(int associationId) {
        Slog.i(TAG, "CDM association created.");
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mClosed == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mAssociationId = Integer.valueOf(associationId);     // Catch: Throwable -> L8
        this.mCompanionDeviceManager.addOnMessageReceivedListener(this.mMessageFromWearableExecutor, 1131446919, this.mOnMessageReceivedListener);     // Catch: Throwable -> L8
        this.mCompanionDeviceManager.addOnTransportsChangedListener(this.mLightWeightExecutor, this.mOnTransportsChangedListener);     // Catch: Throwable -> L8
        this.mCompanionDeviceManager.attachSystemDataTransport(associationId, new ParcelFileDescriptor.AutoCloseInputStream(this.mUnderlyingTransport), new ParcelFileDescriptor.AutoCloseOutputStream(this.mUnderlyingTransport), 1);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void onTransportsChanged(List<AssociationInfo> associationInfos) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mClosed == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        if (this.mAssociationId != null) goto L15;
        Slog.e(TAG, "mAssociationId is null when transport changed");     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L8
        boolean transportAvailable = associationInfos.stream().anyMatch(new WearableSensingSecureChannel$$ExternalSyntheticLambda0(this));
        if (transportAvailable == true) goto L19;
    L21:
        if (transportAvailable == false) goto L23;
        return;
    L23:
        if (this.mTransportAvailable.compareAndSet(true, false) == false) goto L31;
        Slog.i(TAG, "CDM transport is detached. This is not recoverable.");
        onError();
        return;
    L31:
        return;
    L19:
        if (this.mTransportAvailable.compareAndSet(false, true) == false) goto L21;
        onTransportAvailable();
    }

    private /* synthetic */ boolean lambda$onTransportsChanged$0(AssociationInfo info) {
        if (info.getId() != this.mAssociationId.intValue()) goto L5;
        return true;
    L5:
        return false;
    }

    private void onTransportAvailable() {
        Slog.i(TAG, "Transport available");
        this.mMessageToWearableExecutor.execute(new WearableSensingSecureChannel$$ExternalSyntheticLambda3(this));
        this.mSecureTransportListener.onSecureTransportAvailable(this.mRemoteFd);
    }

    private /* synthetic */ void lambda$onTransportAvailable$1() {
        int[] associationIdsToSendMessageTo = {this.mAssociationId.intValue()};
        byte[] buffer = new byte[8192];
    L13:
        int readLen = this.mLocalIn.read(buffer);     // Catch: IOException -> L7
        if (readLen == (-1)) goto L9;
        byte[] data = new byte[readLen];     // Catch: IOException -> L7
        System.arraycopy(buffer, 0, data, 0, readLen);     // Catch: IOException -> L7
        Slog.v(TAG, "Sending message to wearable");     // Catch: IOException -> L7
        this.mCompanionDeviceManager.sendMessage(1132755335, data, associationIdsToSendMessageTo);     // Catch: IOException -> L7
    L9:
        Slog.i(TAG, "Reached EOF when reading from remote stream. Reporting this as an error.");
        onError();
        return;
    L11:
        Slog.i(TAG, "IOException while reading from remote stream.");
        onError();
    }

    private void onMessageReceived(int associationIdForMessage, byte[] data) {
        if (associationIdForMessage != this.mAssociationId.intValue()) goto L9;
        Slog.v(TAG, "Received message from wearable.");
        this.mLocalOut.write(data);     // Catch: IOException -> L7
        this.mLocalOut.flush();     // Catch: IOException -> L7
        return;
    L8:
        Slog.i(TAG, "IOException when writing to remote stream. Closing the secure channel.");
        onError();
        return;
    L9:
        Slog.v(TAG, "Received CDM message of type MESSAGE_ONEWAY_FROM_WEARABLE, but it is for another association. Ignoring the message.");
    }

    private void onError() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mClosed == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mSecureTransportListener.onError();
        close();
    }

    void close() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mClosed == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        Slog.i(TAG, "Closing WearableSensingSecureChannel.");     // Catch: Throwable -> L8
        this.mClosed = true;     // Catch: Throwable -> L8
        if (this.mAssociationId == null) goto L33;
        long originalCallingIdentity = Binder.clearCallingIdentity();     // Catch: Throwable -> L8
        this.mCompanionDeviceManager.removeOnTransportsChangedListener(this.mOnTransportsChangedListener);     // Catch: Throwable -> L15
        this.mCompanionDeviceManager.removeOnMessageReceivedListener(1131446919, this.mOnMessageReceivedListener);     // Catch: Throwable -> L15
        this.mCompanionDeviceManager.detachSystemDataTransport(this.mAssociationId.intValue());     // Catch: Throwable -> L15
        this.mCompanionDeviceManager.disassociate(this.mAssociationId.intValue());     // Catch: Throwable -> L15
        Binder.restoreCallingIdentity(originalCallingIdentity);     // Catch: Throwable -> L8
        goto L33
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(originalCallingIdentity);     // Catch: Throwable -> L8
        throw th;     // Catch: Throwable -> L8
    L33:
        this.mLocalIn.close();     // Catch: Throwable -> L8 IOException -> L20
    L31:
        this.mLocalOut.close();     // Catch: Throwable -> L8 IOException -> L24
    L26:
        this.mMessageFromWearableExecutor.shutdown();     // Catch: Throwable -> L8
        this.mMessageToWearableExecutor.shutdown();     // Catch: Throwable -> L8
        this.mLightWeightExecutor.shutdown();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L24:
        ex = move-exception;
        Slog.e(TAG, "Encountered IOException when closing local output stream.", ex);     // Catch: Throwable -> L8
        goto L26
    L20:
        ex = move-exception;
        Slog.e(TAG, "Encountered IOException when closing local input stream.", ex);     // Catch: Throwable -> L8
        goto L31
    }
}
