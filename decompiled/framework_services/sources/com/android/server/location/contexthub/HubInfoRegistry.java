package com.android.server.location.contexthub;

import android.content.Context;
import android.hardware.contexthub.HubEndpointInfo;
import android.hardware.contexthub.HubServiceInfo;
import android.hardware.contexthub.IContextHubEndpointDiscoveryCallback;
import android.hardware.location.HubInfo;
import android.os.Binder;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.os.WorkSource;
import android.util.ArrayMap;
import android.util.IndentingPrintWriter;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
class HubInfoRegistry implements ContextHubHalEndpointCallback.IEndpointLifecycleCallback {
    private static final String TAG = "HubInfoRegistry";
    private static final long WAKELOCK_TIMEOUT_MILLIS = 5000;
    private final Object mCallbackLock;
    private final IContextHubWrapper mContextHubWrapper;
    private final List<DiscoveryCallback> mEndpointDiscoveryCallbacks;
    private final ArrayMap<HubEndpointInfo.HubEndpointIdentifier, HubEndpointInfo> mHubEndpointInfos;
    private List<HubInfo> mHubsInfo;
    private final Object mLock;
    private final PowerManager.WakeLock mWakeLock;

    private static class DiscoveryCallback implements IBinder.DeathRecipient {
        private final AtomicBoolean mBinderDied;
        private final IContextHubEndpointDiscoveryCallback mCallback;
        private final Optional<Long> mEndpointId;
        private final HubInfoRegistry mHubInfoRegistry;
        private final Optional<String> mServiceDescriptor;

        /* JADX INFO: renamed from: -$$Nest$fgetmCallback, reason: not valid java name */
        static /* bridge */ /* synthetic */ IContextHubEndpointDiscoveryCallback m5205$$Nest$fgetmCallback(DiscoveryCallback r0) {
            return r0.mCallback;
        }

        DiscoveryCallback(HubInfoRegistry registry, IContextHubEndpointDiscoveryCallback callback, long endpointId) throws RemoteException {
            this.mBinderDied = new AtomicBoolean(false);
            this.mHubInfoRegistry = registry;
            this.mCallback = callback;
            this.mEndpointId = Optional.of(Long.valueOf(endpointId));
            this.mServiceDescriptor = Optional.empty();
            attachDeathRecipient();
        }

        DiscoveryCallback(HubInfoRegistry registry, IContextHubEndpointDiscoveryCallback callback, String serviceDescriptor) throws RemoteException {
            this.mBinderDied = new AtomicBoolean(false);
            this.mHubInfoRegistry = registry;
            this.mCallback = callback;
            this.mEndpointId = Optional.empty();
            this.mServiceDescriptor = Optional.of(serviceDescriptor);
            attachDeathRecipient();
        }

        public IContextHubEndpointDiscoveryCallback getCallback() {
            return this.mCallback;
        }

        public boolean isMatch(HubEndpointInfo info) {
            if (this.mBinderDied.get() == false) goto L7;
            Log.w(HubInfoRegistry.TAG, "Callback died, isMatch returning false");
            return false;
        L7:
            if (this.mEndpointId.isPresent() == false) goto L13;
            if (this.mEndpointId.get().longValue() == info.getIdentifier().getEndpoint()) goto L11;
            return false;
        L11:
            return true;
        L13:
            if (this.mServiceDescriptor.isPresent() == false) goto L21;
            Iterator r0 = info.getServiceInfoCollection().iterator();
        L16:
            if (r0.hasNext() == false) goto L21;
            HubServiceInfo serviceInfo = (HubServiceInfo) r0.next();
            if (this.mServiceDescriptor.get().equals(serviceInfo.getServiceDescriptor()) == false) goto L16;
            return true;
        L21:
            return false;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Log.d(HubInfoRegistry.TAG, "Binder died for discovery callback");
            this.mBinderDied.set(true);
            this.mHubInfoRegistry.unregisterEndpointDiscoveryCallback(this.mCallback);
        }

        private void attachDeathRecipient() throws RemoteException {
            this.mCallback.asBinder().linkToDeath(this, 0);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$7-F02yP-nYvSK3Y5lp-W2N5HyHY, reason: not valid java name */
    public static /* synthetic */ void m5203$r8$lambda$7F02yPnYvSK3Y5lpW2N5HyHY(HubInfoRegistry r0) {
        r0.lambda$acquireWakeLock$2();
    }

    public static /* synthetic */ void $r8$lambda$QBoBT60ZQptf3kjxWZuPTaT2sc8(byte r0, IContextHubEndpointDiscoveryCallback r1, HubEndpointInfo[] r2) {
        lambda$onEndpointStopped$1(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$Qrk1k42BYvbl0zwgh5utalM0iRo(HubInfoRegistry r0) {
        r0.lambda$releaseWakeLock$3();
    }

    /* JADX INFO: renamed from: $r8$lambda$j4LJXTw6edBTK-za5okcRmvtqwc, reason: not valid java name */
    public static /* synthetic */ void m5204$r8$lambda$j4LJXTw6edBTKza5okcRmvtqwc(IContextHubEndpointDiscoveryCallback r0, HubEndpointInfo[] r1) {
        lambda$onEndpointStarted$0(r0, r1);
    }

    HubInfoRegistry(Context context, IContextHubWrapper contextHubWrapper) throws InstantiationException {
        this.mLock = new Object();
        this.mHubEndpointInfos = new ArrayMap();
        this.mEndpointDiscoveryCallbacks = new ArrayList();
        this.mCallbackLock = new Object();
        this.mContextHubWrapper = contextHubWrapper;
        refreshCachedHubs();     // Catch: UnsupportedOperationException -> L10
        refreshCachedEndpoints();     // Catch: UnsupportedOperationException -> L10
        PowerManager powerManager = (PowerManager) context.getSystemService(PowerManager.class);
        if (powerManager == null) goto L8;
        this.mWakeLock = powerManager.newWakeLock(1, TAG);
        this.mWakeLock.setWorkSource(new WorkSource(Process.myUid(), context.getPackageName()));
        this.mWakeLock.setReferenceCounted(true);
        return;
    L8:
        Log.e(TAG, "PowerManager was null");
        throw new InstantiationError("PowerManager was null");
    L10:
        e = move-exception;
        Log.e(TAG, "Failed to update hub and endpoint cache", e);
        throw new InstantiationException("Failed to update hub and endpoint cache");
    }

    List<HubInfo> getHubs() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<HubInfo> r1 = this.mHubsInfo;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void refreshCachedHubs() {
        List<HubInfo> hubInfos = this.mContextHubWrapper.getHubs();     // Catch: RemoteException -> L4
    L6:
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mHubsInfo = hubInfos;     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L4:
        e = move-exception;
        Log.e(TAG, "RemoteException while getting Hub info", e);
        hubInfos = Collections.emptyList();
        goto L6
    }

    private void refreshCachedEndpoints() {
        List<HubEndpointInfo> endpointInfos = this.mContextHubWrapper.getEndpoints();     // Catch: RemoteException -> L4
    L6:
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mHubEndpointInfos.clear();     // Catch: Throwable -> L12
        Iterator<HubEndpointInfo> r2 = endpointInfos.iterator();     // Catch: Throwable -> L12
    L10:
        if (r2.hasNext() == false) goto L14;
        HubEndpointInfo endpointInfo = r2.next();     // Catch: Throwable -> L12
        this.mHubEndpointInfos.put(endpointInfo.getIdentifier(), endpointInfo);     // Catch: Throwable -> L12
        goto L10
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L4:
        e = move-exception;
        Log.e(TAG, "RemoteException while getting Hub info", e);
        endpointInfos = Collections.emptyList();
        goto L6
    }

    public HubEndpointInfo getEndpointInfo(HubEndpointInfo.HubEndpointIdentifier id) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        HubEndpointInfo r1 = this.mHubEndpointInfos.get(id);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void onHalRestart() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        refreshCachedHubs();     // Catch: Throwable -> L7
        refreshCachedEndpoints();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.location.contexthub.ContextHubHalEndpointCallback.IEndpointLifecycleCallback
    public void onEndpointStarted(HubEndpointInfo[] endpointInfos) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = endpointInfos.length;     // Catch: Throwable -> L7
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L9;
        HubEndpointInfo endpointInfo = endpointInfos[r2];     // Catch: Throwable -> L7
        this.mHubEndpointInfos.remove(endpointInfo.getIdentifier());     // Catch: Throwable -> L7
        this.mHubEndpointInfos.put(endpointInfo.getIdentifier(), endpointInfo);     // Catch: Throwable -> L7
        r2 = r2 + 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        invokeForMatchingEndpoints(endpointInfos, new HubInfoRegistry$$ExternalSyntheticLambda1());
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$onEndpointStarted$0(IContextHubEndpointDiscoveryCallback cb, HubEndpointInfo[] infoList) {
        cb.onEndpointsStarted(infoList);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "Exception while calling onEndpointsStarted", e);
    }

    @Override // com.android.server.location.contexthub.ContextHubHalEndpointCallback.IEndpointLifecycleCallback
    public void onEndpointStopped(HubEndpointInfo.HubEndpointIdentifier[] endpointIds, final byte reason) {
        ArrayList<HubEndpointInfo> removedInfoList = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        int r2 = endpointIds.length;     // Catch: Throwable -> L9
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L12;
        HubEndpointInfo.HubEndpointIdentifier endpointId = endpointIds[r3];     // Catch: Throwable -> L9
        HubEndpointInfo info = this.mHubEndpointInfos.remove(endpointId);     // Catch: Throwable -> L9
        if (info == null) goto L11;
        removedInfoList.add(info);     // Catch: Throwable -> L9
    L11:
        r3 = r3 + 1;     // Catch: Throwable -> L9
        goto L5
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L9
        invokeForMatchingEndpoints((HubEndpointInfo[]) removedInfoList.toArray(new HubEndpointInfo[removedInfoList.size()]), new HubInfoRegistry$$ExternalSyntheticLambda0(reason));
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$onEndpointStopped$1(byte reason, IContextHubEndpointDiscoveryCallback cb, HubEndpointInfo[] infoList) {
        cb.onEndpointsStopped(infoList, ContextHubServiceUtil.toAppHubEndpointReason(reason));     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "Exception while calling onEndpointsStopped", e);
    }

    public List<HubEndpointInfo> findEndpoints(long endpointIdQuery) {
        List<HubEndpointInfo> searchResult = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        Iterator<HubEndpointInfo.HubEndpointIdentifier> r2 = this.mHubEndpointInfos.keySet().iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L13;
        HubEndpointInfo.HubEndpointIdentifier endpointId = r2.next();     // Catch: Throwable -> L10
        if (endpointId.getEndpoint() != endpointIdQuery) goto L6;
        searchResult.add(this.mHubEndpointInfos.get(endpointId));     // Catch: Throwable -> L10
        goto L6
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return searchResult;
    L10:
        th = move-exception;
        throw th;
    }

    public List<HubEndpointInfo> findEndpointsWithService(String serviceDescriptor) {
        List<HubEndpointInfo> searchResult = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        Iterator<HubEndpointInfo> r2 = this.mHubEndpointInfos.values().iterator();     // Catch: Throwable -> L13
    L6:
        if (r2.hasNext() == false) goto L17;
        HubEndpointInfo endpointInfo = r2.next();     // Catch: Throwable -> L13
        Iterator r4 = endpointInfo.getServiceInfoCollection().iterator();     // Catch: Throwable -> L13
    L9:
        if (r4.hasNext() == false) goto L6;
        HubServiceInfo serviceInfo = (HubServiceInfo) r4.next();     // Catch: Throwable -> L13
        if (serviceDescriptor.equals(serviceInfo.getServiceDescriptor()) == false) goto L9;
        searchResult.add(endpointInfo);     // Catch: Throwable -> L13
        goto L9
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return searchResult;
    L13:
        th = move-exception;
        throw th;
    }

    void registerEndpointDiscoveryCallback(long endpointId, IContextHubEndpointDiscoveryCallback callback) {
        callback.getClass();
        Object r0 = this.mCallbackLock;
        monitor-enter(r0);
        checkCallbackAlreadyRegistered(callback);     // Catch: Throwable -> L7
        this.mEndpointDiscoveryCallbacks.add(new DiscoveryCallback(this, callback, endpointId));     // Catch: Throwable -> L7 RemoteException -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        e = move-exception;
        Log.e(TAG, "RemoteException while adding discovery callback", e);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    void registerEndpointDiscoveryCallback(String serviceDescriptor, IContextHubEndpointDiscoveryCallback callback) {
        callback.getClass();
        Object r0 = this.mCallbackLock;
        monitor-enter(r0);
        checkCallbackAlreadyRegistered(callback);     // Catch: Throwable -> L7
        this.mEndpointDiscoveryCallbacks.add(new DiscoveryCallback(this, callback, serviceDescriptor));     // Catch: Throwable -> L7 RemoteException -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        e = move-exception;
        Log.e(TAG, "RemoteException while adding discovery callback", e);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    void unregisterEndpointDiscoveryCallback(IContextHubEndpointDiscoveryCallback callback) {
        callback.getClass();
        Object r0 = this.mCallbackLock;
        monitor-enter(r0);
        Iterator<DiscoveryCallback> iterator = this.mEndpointDiscoveryCallbacks.iterator();     // Catch: Throwable -> L10
    L6:
        if (iterator.hasNext() == false) goto L12;
        if (iterator.next().getCallback().asBinder() != callback.asBinder()) goto L6;
        iterator.remove();     // Catch: Throwable -> L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    void onDiscoveryCallbackFinished() {
        releaseWakeLock();
    }

    private void checkCallbackAlreadyRegistered(IContextHubEndpointDiscoveryCallback callback) {
        Object r0 = this.mCallbackLock;
        monitor-enter(r0);
        Iterator<DiscoveryCallback> r1 = this.mEndpointDiscoveryCallbacks.iterator();     // Catch: Throwable -> L12
    L6:
        if (r1.hasNext() == false) goto L14;
        DiscoveryCallback discoveryCallback = r1.next();     // Catch: Throwable -> L12
        if (DiscoveryCallback.m5205$$Nest$fgetmCallback(discoveryCallback).asBinder() != callback.asBinder()) goto L6;
        throw new IllegalArgumentException("Callback is already registered");     // Catch: Throwable -> L12
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private void invokeForMatchingEndpoints(HubEndpointInfo[] endpointInfos, BiConsumer<IContextHubEndpointDiscoveryCallback, HubEndpointInfo[]> consumer) {
        Object r0 = this.mCallbackLock;
        monitor-enter(r0);
        Iterator<DiscoveryCallback> iterator = this.mEndpointDiscoveryCallbacks.iterator();     // Catch: Throwable -> L12
    L6:
        if (iterator.hasNext() == false) goto L17;
        DiscoveryCallback discoveryCallback = iterator.next();     // Catch: Throwable -> L12
        ArrayList<HubEndpointInfo> infoList = new ArrayList();     // Catch: Throwable -> L12
        int r4 = endpointInfos.length;     // Catch: Throwable -> L12
        int r5 = 0;
    L8:
        if (r5 >= r4) goto L15;
        HubEndpointInfo endpointInfo = endpointInfos[r5];     // Catch: Throwable -> L12
        if (discoveryCallback.isMatch(endpointInfo) == false) goto L14;
        infoList.add(endpointInfo);     // Catch: Throwable -> L12
    L14:
        r5 = r5 + 1;     // Catch: Throwable -> L12
        goto L8
    L15:
        acquireWakeLock();     // Catch: Throwable -> L12
        consumer.accept(discoveryCallback.getCallback(), (HubEndpointInfo[]) infoList.toArray(new HubEndpointInfo[infoList.size()]));     // Catch: Throwable -> L12
        goto L6
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private void acquireWakeLock() {
        Binder.withCleanCallingIdentity(new HubInfoRegistry$$ExternalSyntheticLambda2(this));
    }

    private /* synthetic */ void lambda$acquireWakeLock$2() throws Exception {
        this.mWakeLock.acquire(WAKELOCK_TIMEOUT_MILLIS);
    }

    private void releaseWakeLock() {
        Binder.withCleanCallingIdentity(new HubInfoRegistry$$ExternalSyntheticLambda3(this));
    }

    private /* synthetic */ void lambda$releaseWakeLock$3() throws Exception {
        if (this.mWakeLock.isHeld() == false) goto L11;
        this.mWakeLock.release();     // Catch: RuntimeException -> L6
        return;
    L6:
        e = move-exception;
        Log.e(TAG, "Releasing the wakelock fails - ", e);
        return;
    }

    void dump(IndentingPrintWriter ipw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        dumpLocked(ipw);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void dumpLocked(IndentingPrintWriter ipw) {
        ipw.println(TAG);
        ipw.increaseIndent();
        ipw.println("Hubs");
        Iterator<HubInfo> r0 = this.mHubsInfo.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        HubInfo hubInfo = r0.next();
        ipw.println(hubInfo);
        goto L4
    L6:
        ipw.decreaseIndent();
        ipw.println();
        ipw.increaseIndent();
        ipw.println("Endpoints");
        Iterator<HubEndpointInfo> r1 = this.mHubEndpointInfos.values().iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        HubEndpointInfo endpointInfo = r1.next();
        ipw.println(endpointInfo);
        goto L8
    L10:
        ipw.decreaseIndent();
        ipw.println();
    }
}
