package com.android.server.wearable;

import android.R;
import android.app.AppGlobals;
import android.app.wearable.IWearableSensingCallback;
import android.companion.CompanionDeviceManager;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.PersistableBundle;
import android.os.RemoteCallback;
import android.os.RemoteException;
import android.os.SharedMemory;
import android.service.voice.HotwordAudioStream;
import android.service.voice.VoiceInteractionManagerInternal;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import com.android.internal.infra.AndroidFuture;
import com.android.server.LocalServices;
import com.android.server.infra.AbstractPerUserSystemService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class WearableSensingManagerPerUserService extends AbstractPerUserSystemService<WearableSensingManagerPerUserService, WearableSensingManagerService> {
    private static final String TAG = null;
    private ComponentName mComponentName;
    private final int mMaxNumberOfConcurrentConnections;
    private final AtomicInteger mNextConnectionId;
    private final PackageManagerInternal mPackageManagerInternal;
    RemoteWearableSensingService mRemoteService;
    private WearableSensingSecureChannel mSecureChannel;
    private final Object mSecureChannelLock;
    private final Map<Integer, WearableSensingSecureChannel> mSecureChannelMap;
    private VoiceInteractionManagerInternal mVoiceInteractionManagerInternal;

    /* JADX INFO: renamed from: com.android.server.wearable.WearableSensingManagerPerUserService$4, reason: invalid class name */
    class AnonymousClass4 extends IWearableSensingCallback.Stub {
        final /* synthetic */ IWearableSensingCallback val$callbackFromAppProcess;

        /* JADX INFO: renamed from: $r8$lambda$I-Pr8xf87PXPhJ3a4Fuh72piyfQ, reason: not valid java name */
        public static /* synthetic */ void m9566$r8$lambda$IPr8xf87PXPhJ3a4Fuh72piyfQ(String r0, AndroidFuture r1, ParcelFileDescriptor r2, Throwable r3) {
            lambda$openFile$0(r0, r1, r2, r3);
        }

        AnonymousClass4(WearableSensingManagerPerUserService this$0, IWearableSensingCallback r2) {
            this.val$callbackFromAppProcess = r2;
        }

        public void openFile(final String filename, final AndroidFuture<ParcelFileDescriptor> futureFromWearableSensingService) throws RemoteException {
            AndroidFuture<ParcelFileDescriptor> futureFromSystemServer = new AndroidFuture().whenComplete(new WearableSensingManagerPerUserService$4$$ExternalSyntheticLambda0(filename, futureFromWearableSensingService));
            this.val$callbackFromAppProcess.openFile(filename, futureFromSystemServer);
        }

        private static /* synthetic */ void lambda$openFile$0(String filename, AndroidFuture futureFromWearableSensingService, ParcelFileDescriptor pfdFromApp, Throwable throwable) {
            if (throwable == null) goto L6;
            Slog.e(WearableSensingManagerPerUserService.m9564$$Nest$sfgetTAG(), "Error when reading file " + filename, throwable);
            futureFromWearableSensingService.complete(null);
            return;
        L6:
            if (pfdFromApp != null) goto L10;
            futureFromWearableSensingService.complete(null);
            return;
        L10:
            if (WearableSensingManagerPerUserService.m9565$$Nest$smisReadOnly(pfdFromApp) == false) goto L12;
            futureFromWearableSensingService.complete(pfdFromApp);
            return;
        L12:
            Slog.w(WearableSensingManagerPerUserService.m9564$$Nest$sfgetTAG(), "Received writable ParcelFileDescriptor from app process. To prevent arbitrary data egress, sending null to WearableSensingService instead.");
            futureFromWearableSensingService.complete(null);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$B3jMR-K2riKQ_EJvprMyZE51n3w, reason: not valid java name */
    public static /* synthetic */ void m9556$r8$lambda$B3jMRK2riKQ_EJvprMyZE51n3w(WearableSensingManagerPerUserService r0, ComponentName r1, Bundle r2) {
        r0.lambda$createWearableHotwordCallback$1(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$Blq_rVHlvU0wp6gY3n797gYVMqo(WearableSensingManagerPerUserService r0, int r1, RemoteCallback r2, Bundle r3) {
        r0.lambda$wrapCallbackWithSecureChannelMapCleanUp$0(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSecureChannel, reason: not valid java name */
    static /* bridge */ /* synthetic */ WearableSensingSecureChannel m9557$$Nest$fgetmSecureChannel(WearableSensingManagerPerUserService r0) {
        return r0.mSecureChannel;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSecureChannelLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m9558$$Nest$fgetmSecureChannelLock(WearableSensingManagerPerUserService r0) {
        return r0.mSecureChannelLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSecureChannelMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m9559$$Nest$fgetmSecureChannelMap(WearableSensingManagerPerUserService r0) {
        return r0.mSecureChannelMap;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmSecureChannel, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9560$$Nest$fputmSecureChannel(WearableSensingManagerPerUserService r0, WearableSensingSecureChannel r1) {
        r0.mSecureChannel = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mensureRemoteServiceInitiated, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9561$$Nest$mensureRemoteServiceInitiated(WearableSensingManagerPerUserService r0) {
        r0.ensureRemoteServiceInitiated();
    }

    /* JADX INFO: renamed from: -$$Nest$monValidatedByHotwordDetectionService, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9562$$Nest$monValidatedByHotwordDetectionService(WearableSensingManagerPerUserService r0) {
        r0.onValidatedByHotwordDetectionService();
    }

    /* JADX INFO: renamed from: -$$Nest$mstopActiveHotwordAudio, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9563$$Nest$mstopActiveHotwordAudio(WearableSensingManagerPerUserService r0) {
        r0.stopActiveHotwordAudio();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m9564$$Nest$sfgetTAG() {
        return TAG;
    }

    /* JADX INFO: renamed from: -$$Nest$smisReadOnly, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9565$$Nest$smisReadOnly(ParcelFileDescriptor r0) {
        return isReadOnly(r0);
    }

    static {
        TAG = WearableSensingManagerPerUserService.class.getSimpleName();
    }

    WearableSensingManagerPerUserService(WearableSensingManagerService master, Object lock, int userId) {
        super(master, lock, userId);
        this.mSecureChannelLock = new Object();
        this.mSecureChannelMap = new HashMap();
        this.mNextConnectionId = new AtomicInteger(1);
        this.mPackageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        this.mMaxNumberOfConcurrentConnections = getContext().getResources().getInteger(R.integer.config_motionPredictionOffsetNanos);
    }

    public static void notifyStatusCallback(RemoteCallback statusCallback, int statusCode) {
        Bundle bundle = new Bundle();
        bundle.putInt("android.app.wearable.WearableSensingStatusBundleKey", statusCode);
        statusCallback.sendResult(bundle);
    }

    void destroyLocked() {
        Slog.d(TAG, "Trying to cancel the remote request. Reason: Service destroyed.");
        if (this.mRemoteService == null) goto L12;
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mRemoteService.unbind();     // Catch: Throwable -> L9
        this.mRemoteService = null;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L12:
        Object r1 = this.mSecureChannelLock;
        monitor-enter(r1);
    L17:
        th = move-exception;
        throw th;
    L15:
        if (this.mSecureChannel == null) goto L19;
        this.mSecureChannel.close();     // Catch: Throwable -> L17
    L19:
        monitor-exit(r1);     // Catch: Throwable -> L17
    }

    private void ensureRemoteServiceInitiated() {
        if (this.mRemoteService != null) goto L6;
        this.mRemoteService = new RemoteWearableSensingService(getContext(), this.mComponentName, getUserId());
        return;
    }

    private boolean ensureVoiceInteractionManagerInternalInitiated() {
        if (this.mVoiceInteractionManagerInternal != null) goto L6;
        this.mVoiceInteractionManagerInternal = (VoiceInteractionManagerInternal) LocalServices.getService(VoiceInteractionManagerInternal.class);
    L6:
        if (this.mVoiceInteractionManagerInternal == null) goto L8;
        return true;
    L8:
        return false;
    }

    ComponentName getComponentName() {
        return this.mComponentName;
    }

    boolean setUpServiceIfNeeded() {
        if (this.mComponentName != null) goto L6;
        this.mComponentName = updateServiceInfoLocked();
    L6:
        if (this.mComponentName != null) goto L15;
        return false;
    L15:
        ServiceInfo serviceInfo = AppGlobals.getPackageManager().getServiceInfo(this.mComponentName, 0, this.mUserId);     // Catch: RemoteException -> L12
        if (serviceInfo == null) goto L17;
        return true;
    L17:
        return false;
    L13:
        Slog.w(TAG, "RemoteException while setting up service");
        return false;
    }

    @Override // com.android.server.infra.AbstractPerUserSystemService
    protected ServiceInfo newServiceInfoLocked(ComponentName serviceComponent) throws PackageManager.NameNotFoundException {
        ServiceInfo serviceInfo = AppGlobals.getPackageManager().getServiceInfo(serviceComponent, 0, this.mUserId);     // Catch: RemoteException -> L10
        if (serviceInfo == null) goto L13;
        String permission = serviceInfo.permission;     // Catch: RemoteException -> L10
        if ("android.permission.BIND_WEARABLE_SENSING_SERVICE".equals(permission) == true) goto L13;
        throw new SecurityException(String.format("Service %s requires %s permission. Found %s permission", new Object[]{serviceInfo.getComponentName(), "android.permission.BIND_WEARABLE_SENSING_SERVICE", serviceInfo.permission}));     // Catch: RemoteException -> L10
    L13:
        return serviceInfo;
    L15:
        throw new PackageManager.NameNotFoundException("Could not get service for " + serviceComponent);
    }

    @Override // com.android.server.infra.AbstractPerUserSystemService
    protected void dumpLocked(String prefix, PrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        super.dumpLocked(prefix, pw);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        if (this.mRemoteService == null) goto L15;
        this.mRemoteService.dump("", new IndentingPrintWriter(pw, "  "));
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public int getAvailableConnectionCount() {
        Map<Integer, WearableSensingSecureChannel> r0 = this.mSecureChannelMap;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mSecureChannelMap.size() <= this.mMaxNumberOfConcurrentConnections) goto L12;
        Slog.e(TAG, "mMaxNumberOfConcurrentConnections exceeded. This should not be possible!");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return 0;
    L12:
        int r1 = this.mMaxNumberOfConcurrentConnections - this.mSecureChannelMap.size();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    }

    public void onProvideConnection(ParcelFileDescriptor wearableConnection, IWearableSensingCallback wearableSensingCallback, final RemoteCallback statusCallback) {
        Slog.i(TAG, "onProvideConnection in per user service.");
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (setUpServiceIfNeeded() == true) goto L11;
        Slog.w(TAG, "Detection service is not available at this moment.");     // Catch: Throwable -> L9
        notifyStatusCallback(statusCallback, 3);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        final IWearableSensingCallback wrappedWearableSensingCallback = wrapWearableSensingCallback(wearableSensingCallback);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        Object r2 = this.mSecureChannelLock;
        monitor-enter(r2);
    L19:
        th = move-exception;
        throw th;
    L16:
        if (this.mSecureChannel == null) goto L31;
        this.mSecureChannel.close();     // Catch: Throwable -> L19
    L31:
        final AtomicReference<WearableSensingSecureChannel> currentSecureChannelRef = new AtomicReference();     // Catch: Throwable -> L19 IOException -> L23
        this.mSecureChannel = WearableSensingSecureChannel.create((CompanionDeviceManager) getContext().getSystemService(CompanionDeviceManager.class), wearableConnection, new AnonymousClass1(this, wrappedWearableSensingCallback, statusCallback, currentSecureChannelRef));     // Catch: Throwable -> L19 IOException -> L23
        currentSecureChannelRef.set(this.mSecureChannel);     // Catch: Throwable -> L19 IOException -> L23
    L25:
        monitor-exit(r2);     // Catch: Throwable -> L19
        return;
    L23:
        ex = move-exception;
        Slog.e(TAG, "Unable to create the secure channel.", ex);     // Catch: Throwable -> L19
        notifyStatusCallback(statusCallback, 7);     // Catch: Throwable -> L19
        goto L25
    }

    public int onProvideConcurrentConnection(ParcelFileDescriptor wearableConnection, final PersistableBundle metadata, final IWearableSensingCallback wearableSensingCallback, RemoteCallback statusCallback) {
        Slog.i(TAG, "onProvideConcurrentConnection in per user service.");
        Object r1 = this.mLock;
        monitor-enter(r1);
    L53:
        th = th;
    L67:
        monitor-exit(r1);     // Catch: Throwable -> L57
        throw th;
    L57:
        th = th;
        goto L67
    L6:
        if (setUpServiceIfNeeded() == false) goto L73;
        monitor-exit(r1);     // Catch: Throwable -> L53
        boolean isConcurrentConnectionLimitReached = false;
        Map<Integer, WearableSensingSecureChannel> r3 = this.mSecureChannelMap;
        monitor-enter(r3);
    L47:
        th = th;
    L61:
        throw th;
    L51:
        th = th;
        goto L61
    L16:
        if (this.mSecureChannelMap.size() < this.mMaxNumberOfConcurrentConnections) goto L18;
        isConcurrentConnectionLimitReached = true;
    L18:
        monitor-exit(r3);     // Catch: Throwable -> L47
        if (isConcurrentConnectionLimitReached == false) goto L23;
        Slog.i(TAG, "Rejecting connection because max concurrent connections limit has been reached.");
        notifyStatusCallback(statusCallback, 9);
        return -1;
    L23:
        final int connectionId = this.mNextConnectionId.getAndIncrement();
        final RemoteCallback wrappedStatusCallback = wrapCallbackWithSecureChannelMapCleanUp(statusCallback, connectionId);
        CompanionDeviceManager r4 = (CompanionDeviceManager) getContext().getSystemService(CompanionDeviceManager.class);     // Catch: IOException -> L43
        WearableSensingSecureChannel secureChannel = WearableSensingSecureChannel.create(r4, wearableConnection, new AnonymousClass2(this, metadata, wearableSensingCallback, wrappedStatusCallback, connectionId));     // Catch: IOException -> L41
        Map<Integer, WearableSensingSecureChannel> r13 = this.mSecureChannelMap;
        monitor-enter(r13);
    L38:
        th = move-exception;
        throw th;
    L30:
        if (this.mSecureChannelMap.size() < this.mMaxNumberOfConcurrentConnections) goto L32;
        isConcurrentConnectionLimitReached = true;
    L33:
        monitor-exit(r13);     // Catch: Throwable -> L38
        if (isConcurrentConnectionLimitReached == false) goto L37;
        Slog.i(TAG, "Rejecting connection because max concurrent connections limit has been reached.");
        notifyStatusCallback(statusCallback, 9);
        secureChannel.close();
        return -1;
    L37:
        return connectionId;
    L32:
        this.mSecureChannelMap.put(Integer.valueOf(connectionId), secureChannel);     // Catch: Throwable -> L38
    L41:
        e = move-exception;
        IOException ex = e;
    L45:
        Slog.e(TAG, "Unable to create the secure channel.", ex);
        notifyStatusCallback(statusCallback, 7);
        return -1;
    L43:
        e = move-exception;
        ex = e;
        goto L45
    L73:
        Slog.w(TAG, "Detection service is not available at this moment.");     // Catch: Throwable -> L10
        notifyStatusCallback(statusCallback, 3);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        return -1;
    L10:
        th = th;
        goto L67
    }

    private RemoteCallback wrapCallbackWithSecureChannelMapCleanUp(final RemoteCallback statusCallback, final int connectionId) {
        return new RemoteCallback(new WearableSensingManagerPerUserService$$ExternalSyntheticLambda1(this, connectionId, statusCallback));
    }

    private /* synthetic */ void lambda$wrapCallbackWithSecureChannelMapCleanUp$0(int connectionId, RemoteCallback statusCallback, Bundle result) {
        int status = result.getInt("android.app.wearable.WearableSensingStatusBundleKey");
        if (status == 1) goto L5;
        removeConnection(connectionId);
    L5:
        statusCallback.sendResult(result);
    }

    public boolean removeConnection(int connectionId) {
        Map<Integer, WearableSensingSecureChannel> r0 = this.mSecureChannelMap;
        monitor-enter(r0);
        WearableSensingSecureChannel removedChannel = this.mSecureChannelMap.remove(Integer.valueOf(connectionId));     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        if (removedChannel == null) goto L9;
        removedChannel.close();
        return true;
    L9:
        return false;
    L11:
        th = move-exception;
        throw th;
    }

    public void removeAllConnections() {
        Map<Integer, WearableSensingSecureChannel> r0 = this.mSecureChannelMap;
        monitor-enter(r0);
        List<WearableSensingSecureChannel> allChannels = new ArrayList(this.mSecureChannelMap.values());     // Catch: Throwable -> L11
        this.mSecureChannelMap.clear();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        Iterator<WearableSensingSecureChannel> r1 = allChannels.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        WearableSensingSecureChannel channel = r1.next();
        channel.close();
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void onProvideReadOnlyParcelFileDescriptor(ParcelFileDescriptor parcelFileDescriptor, PersistableBundle metadata, RemoteCallback statusCallback) {
        if (isReadOnly(parcelFileDescriptor) == false) goto L19;
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (setUpServiceIfNeeded() == true) goto L13;
        Slog.w(TAG, "Detection service is not available at this moment.");     // Catch: Throwable -> L11
        notifyStatusCallback(statusCallback, 3);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L13:
        Slog.i(TAG, "calling over to remote servvice.");     // Catch: Throwable -> L11
        ensureRemoteServiceInitiated();     // Catch: Throwable -> L11
        this.mRemoteService.provideReadOnlyParcelFileDescriptor(parcelFileDescriptor, metadata, statusCallback);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L19:
        throw new IllegalArgumentException("Provided ParcelFileDescriptor is not read-only.");
    }

    public void onProvideDataStream(ParcelFileDescriptor parcelFileDescriptor, IWearableSensingCallback wearableSensingCallback, RemoteCallback statusCallback) {
        Slog.i(TAG, "onProvideDataStream in per user service. Is data stream read-only? " + isReadOnly(parcelFileDescriptor));
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (setUpServiceIfNeeded() == true) goto L11;
        Slog.w(TAG, "Detection service is not available at this moment.");     // Catch: Throwable -> L9
        notifyStatusCallback(statusCallback, 3);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        Slog.i(TAG, "calling over to remote servvice.");     // Catch: Throwable -> L9
        ensureRemoteServiceInitiated();     // Catch: Throwable -> L9
        this.mRemoteService.provideDataStream(parcelFileDescriptor, wrapWearableSensingCallback(wearableSensingCallback), statusCallback);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    public void onProvidedData(PersistableBundle data, SharedMemory sharedMemory, RemoteCallback callback) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (setUpServiceIfNeeded() == true) goto L11;
        Slog.w(TAG, "Detection service is not available at this moment.");     // Catch: Throwable -> L9
        notifyStatusCallback(callback, 3);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        ensureRemoteServiceInitiated();     // Catch: Throwable -> L9
        if (sharedMemory == null) goto L14;
        sharedMemory.setProtect(OsConstants.PROT_READ);     // Catch: Throwable -> L9
    L14:
        this.mRemoteService.provideData(data, sharedMemory, callback);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    public void onRegisterDataRequestObserver(int dataType, RemoteCallback dataRequestObserver, int dataRequestObserverId, String packageName, RemoteCallback statusCallback) {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L16:
        th = th;
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L16
        throw th;
    L18:
        th = th;
        goto L20
    L5:
        if (setUpServiceIfNeeded() == false) goto L22;
        ensureRemoteServiceInitiated();     // Catch: Throwable -> L18
        this.mRemoteService.registerDataRequestObserver(dataType, dataRequestObserver, dataRequestObserverId, packageName, statusCallback);     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        return;
    L22:
        Slog.w(TAG, "Detection service is not available at this moment.");     // Catch: Throwable -> L9
        notifyStatusCallback(statusCallback, 3);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = th;
        goto L20
    }

    public void onUnregisterDataRequestObserver(int dataType, int dataRequestObserverId, String packageName, RemoteCallback statusCallback) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (setUpServiceIfNeeded() == true) goto L11;
        Slog.w(TAG, "Detection service is not available at this moment.");     // Catch: Throwable -> L9
        notifyStatusCallback(statusCallback, 3);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        ensureRemoteServiceInitiated();     // Catch: Throwable -> L9
        this.mRemoteService.unregisterDataRequestObserver(dataType, dataRequestObserverId, packageName, statusCallback);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    public void onStartHotwordRecognition(ComponentName targetVisComponentName, RemoteCallback statusCallback) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (setUpServiceIfNeeded() == true) goto L12;
        Slog.w(TAG, "Detection service is not available at this moment.");     // Catch: Throwable -> L9
        notifyStatusCallback(statusCallback, 3);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L12:
        if (ensureVoiceInteractionManagerInternalInitiated() == true) goto L16;
        Slog.w(TAG, "Voice interaction manager is not available at this moment.");     // Catch: Throwable -> L9
        notifyStatusCallback(statusCallback, 3);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L16:
        ensureRemoteServiceInitiated();     // Catch: Throwable -> L9
        this.mRemoteService.startHotwordRecognition(createWearableHotwordCallback(targetVisComponentName), statusCallback);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    public void onStopHotwordRecognition(RemoteCallback statusCallback) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (setUpServiceIfNeeded() == true) goto L11;
        Slog.w(TAG, "Detection service is not available at this moment.");     // Catch: Throwable -> L9
        notifyStatusCallback(statusCallback, 3);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        ensureRemoteServiceInitiated();     // Catch: Throwable -> L9
        this.mRemoteService.stopHotwordRecognition(statusCallback);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    private void onValidatedByHotwordDetectionService() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (setUpServiceIfNeeded() == true) goto L11;
        Slog.w(TAG, "Wearable sensing service is not available at this moment.");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        ensureRemoteServiceInitiated();     // Catch: Throwable -> L9
        this.mRemoteService.onValidatedByHotwordDetectionService();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    private void stopActiveHotwordAudio() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (setUpServiceIfNeeded() == true) goto L11;
        Slog.w(TAG, "Wearable sensing service is not available at this moment.");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        ensureRemoteServiceInitiated();     // Catch: Throwable -> L9
        this.mRemoteService.stopActiveHotwordAudio();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    private RemoteCallback createWearableHotwordCallback(final ComponentName targetVisComponentName) {
        return new RemoteCallback(new WearableSensingManagerPerUserService$$ExternalSyntheticLambda0(this, targetVisComponentName));
    }

    private /* synthetic */ void lambda$createWearableHotwordCallback$1(ComponentName targetVisComponentName, Bundle result) {
        HotwordAudioStream hotwordAudioStream = (HotwordAudioStream) result.getParcelable("android.app.wearable.HotwordAudioStreamBundleKey", HotwordAudioStream.class);
        if (hotwordAudioStream != null) goto L6;
        Slog.w(TAG, "No hotword audio stream received, unable to process hotword.");
        return;
    L6:
        long identity = Binder.clearCallingIdentity();
        this.mVoiceInteractionManagerInternal.startListeningFromWearable(hotwordAudioStream.getAudioStreamParcelFileDescriptor(), hotwordAudioStream.getAudioFormat(), hotwordAudioStream.getMetadata(), targetVisComponentName, getUserId(), createHotwordDetectionCallback());     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(identity);
        return;
    L12:
        th = move-exception;
        Throwable r12 = th;
    L16:
        Binder.restoreCallingIdentity(identity);
        throw r12;
    L14:
        th = move-exception;
        r12 = th;
        goto L16
    }

    private VoiceInteractionManagerInternal.WearableHotwordDetectionCallback createHotwordDetectionCallback() {
        return new AnonymousClass3(this);
    }

    private IWearableSensingCallback wrapWearableSensingCallback(IWearableSensingCallback callbackFromAppProcess) {
        if (callbackFromAppProcess != null) goto L6;
        return null;
    L6:
        if (this.mComponentName != null) goto L10;
        Slog.w(TAG, "Cannot create WearableSensingCallback because mComponentName is null.");
        return null;
    L10:
        if (Binder.getCallingUid() == this.mPackageManagerInternal.getPackageUid(this.mComponentName.getPackageName(), 0, this.mUserId)) goto L14;
        Slog.d(TAG, "Caller does not belong to the package that provides the WearableSensingService implementation. Do not forward WearableSensingCallback to WearableSensingService.");
        return null;
    L14:
        return new AnonymousClass4(this, callbackFromAppProcess);
    }

    private static boolean isReadOnly(ParcelFileDescriptor parcelFileDescriptor) {
        int readMode = Os.fcntlInt(parcelFileDescriptor.getFileDescriptor(), OsConstants.F_GETFL, 0) & OsConstants.O_ACCMODE;     // Catch: ErrnoException -> L7
        if (readMode != OsConstants.O_RDONLY) goto L12;
        return true;
    L12:
        return false;
    L7:
        ex = move-exception;
        Slog.w(TAG, "Error encountered when trying to determine if the parcelFileDescriptor is read-only. Treating it as not read-only", ex);
        return false;
    }
}
