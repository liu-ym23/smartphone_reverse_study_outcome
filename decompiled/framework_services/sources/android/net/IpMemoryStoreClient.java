package android.net;

import android.content.Context;
import android.net.ipmemorystore.Blob;
import android.net.ipmemorystore.NetworkAttributes;
import android.net.ipmemorystore.OnBlobRetrievedListener;
import android.net.ipmemorystore.OnDeleteStatusListener;
import android.net.ipmemorystore.OnL2KeyResponseListener;
import android.net.ipmemorystore.OnNetworkAttributesRetrievedListener;
import android.net.ipmemorystore.OnNetworkEventCountRetrievedListener;
import android.net.ipmemorystore.OnSameL3NetworkResponseListener;
import android.net.ipmemorystore.OnStatusListener;
import android.net.ipmemorystore.Status;
import android.os.RemoteException;
import android.util.Log;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public abstract class IpMemoryStoreClient {
    private static final String TAG = null;
    private final Context mContext;

    @FunctionalInterface
    private interface ThrowingRunnable {
        void run() throws RemoteException;
    }

    /* JADX INFO: renamed from: $r8$lambda$-agmG3QnCnTGjpVGuNCsN8Zf7Ko, reason: not valid java name */
    public static /* synthetic */ void m5$r8$lambda$agmG3QnCnTGjpVGuNCsN8Zf7Ko(OnNetworkAttributesRetrievedListener r0) {
        lambda$retrieveNetworkAttributes$14(r0);
    }

    public static /* synthetic */ void $r8$lambda$3NXT457T82CtcVsg8GobBtlPKQ4(IpMemoryStoreClient r0, String r1, String r2, OnSameL3NetworkResponseListener r3, IIpMemoryStore r4) {
        r0.lambda$isSameNetwork$10(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$4j3dNF67o6NAOGYtmRLAylaDeoE(OnDeleteStatusListener r0) {
        lambda$delete$20(r0);
    }

    public static /* synthetic */ void $r8$lambda$A1dJWBt0zGMwIg94ZNfwEJPFkqQ(IpMemoryStoreClient r0, String r1, OnNetworkAttributesRetrievedListener r2, IIpMemoryStore r3) {
        r0.lambda$retrieveNetworkAttributes$13(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$CVFuVz16jcHPC8U-Sx6-K762Gvc, reason: not valid java name */
    public static /* synthetic */ void m6$r8$lambda$CVFuVz16jcHPC8USx6K762Gvc(OnSameL3NetworkResponseListener r0) {
        lambda$isSameNetwork$11(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$EqiuXKS_kMkqzw8-ZS1i2veSvM8, reason: not valid java name */
    public static /* synthetic */ void m7$r8$lambda$EqiuXKS_kMkqzw8ZS1i2veSvM8(OnL2KeyResponseListener r0) {
        lambda$findL2Key$8(r0);
    }

    public static /* synthetic */ void $r8$lambda$F4PDL_SdP2inoqkygo2e8UmmOOk(IIpMemoryStore r0, NetworkAttributes r1, OnL2KeyResponseListener r2) {
        lambda$findL2Key$6(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$FtdNBOd4lhXUNlGtVAFL2R3nqEc(IpMemoryStoreClient r0, String r1, NetworkAttributes r2, OnStatusListener r3, IIpMemoryStore r4) {
        r0.lambda$storeNetworkAttributes$1(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$Gtfbn8H-Hmv1h-JCbed5WTdnnEM, reason: not valid java name */
    public static /* synthetic */ void m8$r8$lambda$Gtfbn8HHmv1hJCbed5WTdnnEM(IIpMemoryStore r0, String r1, String r2, OnSameL3NetworkResponseListener r3) {
        lambda$isSameNetwork$9(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$HNYtD8BPOyUv7tcyyeuKiVvlE9o(IpMemoryStoreClient r0, String r1, boolean r2, OnDeleteStatusListener r3, IIpMemoryStore r4) {
        r0.lambda$delete$19(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$Lwi-UV2KJSgpGNur1LVnGMVszhA, reason: not valid java name */
    public static /* synthetic */ void m9$r8$lambda$LwiUV2KJSgpGNur1LVnGMVszhA(IIpMemoryStore r0, String r1, String r2, String r3, OnBlobRetrievedListener r4) {
        lambda$retrieveBlob$15(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$M8u7jyyYWsGpRh7kG9dUg0fqBSY(OnDeleteStatusListener r0) {
        lambda$deleteCluster$23(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$PYxMl-8VTNMxiGLoTuj7FUrL7Ss, reason: not valid java name */
    public static /* synthetic */ void m10$r8$lambda$PYxMl8VTNMxiGLoTuj7FUrL7Ss(IIpMemoryStore r0) {
        lambda$factoryReset$24(r0);
    }

    public static /* synthetic */ void $r8$lambda$SfabcXRuWB5I60P_0BL0YEqo97E(IpMemoryStoreClient r0, IIpMemoryStore r1) {
        r0.lambda$factoryReset$25(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$U6AxfDXBAs4ISSIivSALg-8kfCw, reason: not valid java name */
    public static /* synthetic */ void m11$r8$lambda$U6AxfDXBAs4ISSIivSALg8kfCw(IpMemoryStoreClient r0, String r1, boolean r2, OnDeleteStatusListener r3, IIpMemoryStore r4) {
        r0.lambda$deleteCluster$22(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$WvHZ-Vs5bUuhBEW_zmyd8lOPYGQ, reason: not valid java name */
    public static /* synthetic */ void m12$r8$lambda$WvHZVs5bUuhBEW_zmyd8lOPYGQ(OnStatusListener r0) {
        lambda$storeBlob$5(r0);
    }

    public static /* synthetic */ void $r8$lambda$XYZsuAt7vHRidyIn_z64I1F9I0g(IpMemoryStoreClient r0, String r1, long[] r2, int[] r3, OnNetworkEventCountRetrievedListener r4, IIpMemoryStore r5) {
        r0.lambda$retrieveNetworkEventCount$27(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$ZmYKgDCCOgRrpoQcjfpEnx8avws(IpMemoryStoreClient r0, String r1, long r2, long r4, int r6, OnStatusListener r7, IIpMemoryStore r8) {
        r0.lambda$storeNetworkEvent$30(r1, r2, r4, r6, r7, r8);
    }

    /* JADX INFO: renamed from: $r8$lambda$dglMsU1c29thjop9O2HnPUSy4-0, reason: not valid java name */
    public static /* synthetic */ void m13$r8$lambda$dglMsU1c29thjop9O2HnPUSy40(IpMemoryStoreClient r0, String r1, String r2, String r3, OnBlobRetrievedListener r4, IIpMemoryStore r5) {
        r0.lambda$retrieveBlob$16(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: $r8$lambda$gKa5xDJhUAOR6d9F-d-TV7ZaWow, reason: not valid java name */
    public static /* synthetic */ void m14$r8$lambda$gKa5xDJhUAOR6d9FdTV7ZaWow(IIpMemoryStore r0, String r1, long[] r2, int[] r3, OnNetworkEventCountRetrievedListener r4) {
        lambda$retrieveNetworkEventCount$26(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$gzljqXXPBsYa9XLZEzQWqEbOr-0, reason: not valid java name */
    public static /* synthetic */ void m15$r8$lambda$gzljqXXPBsYa9XLZEzQWqEbOr0(OnStatusListener r0) {
        lambda$storeNetworkAttributes$2(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$h6bbP-SfaTFo7Ff09F-yXftwhEc, reason: not valid java name */
    public static /* synthetic */ void m16$r8$lambda$h6bbPSfaTFo7Ff09FyXftwhEc(OnStatusListener r0) {
        lambda$storeNetworkEvent$31(r0);
    }

    public static /* synthetic */ void $r8$lambda$hICnBCSsnrXREBHQ8OnhnN1ZUjs(IIpMemoryStore r0, String r1, long r2, long r4, int r6, OnStatusListener r7) {
        lambda$storeNetworkEvent$29(r0, r1, r2, r4, r6, r7);
    }

    public static /* synthetic */ void $r8$lambda$kQgPvbRYTAs7OHCT5VWHVYBvR5s(IIpMemoryStore r0, String r1, boolean r2, OnDeleteStatusListener r3) {
        lambda$delete$18(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$kw0C-x-oOTHnTWTYjF33o57o8-Q, reason: not valid java name */
    public static /* synthetic */ void m17$r8$lambda$kw0CxoOTHnTWTYjF33o57o8Q(IIpMemoryStore r0, String r1, boolean r2, OnDeleteStatusListener r3) {
        lambda$deleteCluster$21(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$m-MiiJpkUlbFj594pow56N1SWac, reason: not valid java name */
    public static /* synthetic */ void m18$r8$lambda$mMiiJpkUlbFj594pow56N1SWac(IpMemoryStoreClient r0, NetworkAttributes r1, OnL2KeyResponseListener r2, IIpMemoryStore r3) {
        r0.lambda$findL2Key$7(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$oxBl3Mx7RwhlNwWErUzS1J8-yoM, reason: not valid java name */
    public static /* synthetic */ void m19$r8$lambda$oxBl3Mx7RwhlNwWErUzS1J8yoM(IpMemoryStoreClient r0, String r1, String r2, String r3, Blob r4, OnStatusListener r5, IIpMemoryStore r6) {
        r0.lambda$storeBlob$4(r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void $r8$lambda$rmld3gkm9_RMJEplNWL6IUwOKUc(OnNetworkEventCountRetrievedListener r0) {
        lambda$retrieveNetworkEventCount$28(r0);
    }

    public static /* synthetic */ void $r8$lambda$rscP1A28INZB0xb8E8vEaCkPx1g(IIpMemoryStore r0, String r1, OnNetworkAttributesRetrievedListener r2) {
        lambda$retrieveNetworkAttributes$12(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$tPwd2hc2Euvwob2T0xc07lBBUjs(IIpMemoryStore r0, String r1, NetworkAttributes r2, OnStatusListener r3) {
        lambda$storeNetworkAttributes$0(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$vk0Nh2Qc67PGCXFRrO6ttafnr-w, reason: not valid java name */
    public static /* synthetic */ void m20$r8$lambda$vk0Nh2Qc67PGCXFRrO6ttafnrw(OnBlobRetrievedListener r0) {
        lambda$retrieveBlob$17(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$wCeBxaSvb8AFpavF-NMYTPzmdok, reason: not valid java name */
    public static /* synthetic */ void m21$r8$lambda$wCeBxaSvb8AFpavFNMYTPzmdok(IIpMemoryStore r0, String r1, String r2, String r3, Blob r4, OnStatusListener r5) {
        lambda$storeBlob$3(r0, r1, r2, r3, r4, r5);
    }

    protected abstract void runWhenServiceReady(Consumer<IIpMemoryStore> r1) throws ExecutionException;

    static {
        TAG = IpMemoryStoreClient.class.getSimpleName();
    }

    public IpMemoryStoreClient(Context context) {
        if (context == null) goto L7;
        this.mContext = context;
        return;
    L7:
        throw new IllegalArgumentException("missing context");
    }

    private void ignoringRemoteException(ThrowingRunnable r) {
        ignoringRemoteException("Failed to execute remote procedure call", r);
    }

    private void ignoringRemoteException(String message, ThrowingRunnable r) {
        r.run();     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, message, e);
    }

    private /* synthetic */ void lambda$storeNetworkAttributes$1(final String l2Key, final NetworkAttributes attributes, final OnStatusListener listener, final IIpMemoryStore service) {
        ignoringRemoteException(new IpMemoryStoreClient$$ExternalSyntheticLambda15(service, l2Key, attributes, listener));
    }

    public void storeNetworkAttributes(final String l2Key, final NetworkAttributes attributes, final OnStatusListener listener) {
        runWhenServiceReady(new IpMemoryStoreClient$$ExternalSyntheticLambda0(this, l2Key, attributes, listener));     // Catch: ExecutionException -> L4
        return;
    L5:
        if (listener != null) goto L7;
        return;
    L7:
        ignoringRemoteException("Error storing network attributes", new IpMemoryStoreClient$$ExternalSyntheticLambda1(listener));
    }

    private static /* synthetic */ void lambda$storeNetworkAttributes$0(IIpMemoryStore service, String l2Key, NetworkAttributes attributes, OnStatusListener listener) throws RemoteException {
        service.storeNetworkAttributes(l2Key, attributes.toParcelable(), OnStatusListener.toAIDL(listener));
    }

    private static /* synthetic */ void lambda$storeNetworkAttributes$2(OnStatusListener listener) throws RemoteException {
        listener.onComplete(new Status(-5));
    }

    private /* synthetic */ void lambda$storeBlob$4(final String l2Key, final String clientId, final String name, final Blob data, final OnStatusListener listener, final IIpMemoryStore service) {
        ignoringRemoteException(new IpMemoryStoreClient$$ExternalSyntheticLambda23(service, l2Key, clientId, name, data, listener));
    }

    public void storeBlob(final String l2Key, final String clientId, final String name, final Blob data, OnStatusListener listener) {
        final OnStatusListener listener2 = listener;
        runWhenServiceReady(new IpMemoryStoreClient$$ExternalSyntheticLambda21(this, l2Key, clientId, name, data, listener2));     // Catch: ExecutionException -> L6
        return;
    L10:
        if (listener2 != null) goto L12;
        return;
    L12:
        ignoringRemoteException("Error storing blob", new IpMemoryStoreClient$$ExternalSyntheticLambda22(listener2));
        return;
    L9:
        listener2 = listener;
        goto L10
    }

    private static /* synthetic */ void lambda$storeBlob$3(IIpMemoryStore service, String l2Key, String clientId, String name, Blob data, OnStatusListener listener) throws RemoteException {
        service.storeBlob(l2Key, clientId, name, data, OnStatusListener.toAIDL(listener));
    }

    private static /* synthetic */ void lambda$storeBlob$5(OnStatusListener listener) throws RemoteException {
        listener.onComplete(new Status(-5));
    }

    private /* synthetic */ void lambda$findL2Key$7(final NetworkAttributes attributes, final OnL2KeyResponseListener listener, final IIpMemoryStore service) {
        ignoringRemoteException(new IpMemoryStoreClient$$ExternalSyntheticLambda12(service, attributes, listener));
    }

    public void findL2Key(final NetworkAttributes attributes, final OnL2KeyResponseListener listener) {
        runWhenServiceReady(new IpMemoryStoreClient$$ExternalSyntheticLambda26(this, attributes, listener));     // Catch: ExecutionException -> L4
        return;
    L5:
        ignoringRemoteException("Error finding L2 Key", new IpMemoryStoreClient$$ExternalSyntheticLambda27(listener));
    }

    private static /* synthetic */ void lambda$findL2Key$6(IIpMemoryStore service, NetworkAttributes attributes, OnL2KeyResponseListener listener) throws RemoteException {
        service.findL2Key(attributes.toParcelable(), OnL2KeyResponseListener.toAIDL(listener));
    }

    private static /* synthetic */ void lambda$findL2Key$8(OnL2KeyResponseListener listener) throws RemoteException {
        listener.onL2KeyResponse(new Status(-5), null);
    }

    private /* synthetic */ void lambda$isSameNetwork$10(final String l2Key1, final String l2Key2, final OnSameL3NetworkResponseListener listener, final IIpMemoryStore service) {
        ignoringRemoteException(new IpMemoryStoreClient$$ExternalSyntheticLambda19(service, l2Key1, l2Key2, listener));
    }

    public void isSameNetwork(final String l2Key1, final String l2Key2, final OnSameL3NetworkResponseListener listener) {
        runWhenServiceReady(new IpMemoryStoreClient$$ExternalSyntheticLambda6(this, l2Key1, l2Key2, listener));     // Catch: ExecutionException -> L4
        return;
    L5:
        ignoringRemoteException("Error checking for network sameness", new IpMemoryStoreClient$$ExternalSyntheticLambda7(listener));
    }

    private static /* synthetic */ void lambda$isSameNetwork$9(IIpMemoryStore service, String l2Key1, String l2Key2, OnSameL3NetworkResponseListener listener) throws RemoteException {
        service.isSameNetwork(l2Key1, l2Key2, OnSameL3NetworkResponseListener.toAIDL(listener));
    }

    private static /* synthetic */ void lambda$isSameNetwork$11(OnSameL3NetworkResponseListener listener) throws RemoteException {
        listener.onSameL3NetworkResponse(new Status(-5), null);
    }

    private /* synthetic */ void lambda$retrieveNetworkAttributes$13(final String l2Key, final OnNetworkAttributesRetrievedListener listener, final IIpMemoryStore service) {
        ignoringRemoteException(new IpMemoryStoreClient$$ExternalSyntheticLambda8(service, l2Key, listener));
    }

    public void retrieveNetworkAttributes(final String l2Key, final OnNetworkAttributesRetrievedListener listener) {
        runWhenServiceReady(new IpMemoryStoreClient$$ExternalSyntheticLambda30(this, l2Key, listener));     // Catch: ExecutionException -> L4
        return;
    L5:
        ignoringRemoteException("Error retrieving network attributes", new IpMemoryStoreClient$$ExternalSyntheticLambda31(listener));
    }

    private static /* synthetic */ void lambda$retrieveNetworkAttributes$12(IIpMemoryStore service, String l2Key, OnNetworkAttributesRetrievedListener listener) throws RemoteException {
        service.retrieveNetworkAttributes(l2Key, OnNetworkAttributesRetrievedListener.toAIDL(listener));
    }

    private static /* synthetic */ void lambda$retrieveNetworkAttributes$14(OnNetworkAttributesRetrievedListener listener) throws RemoteException {
        listener.onNetworkAttributesRetrieved(new Status(-5), null, null);
    }

    private /* synthetic */ void lambda$retrieveBlob$16(final String l2Key, final String clientId, final String name, final OnBlobRetrievedListener listener, final IIpMemoryStore service) {
        ignoringRemoteException(new IpMemoryStoreClient$$ExternalSyntheticLambda16(service, l2Key, clientId, name, listener));
    }

    public void retrieveBlob(final String l2Key, final String clientId, final String name, OnBlobRetrievedListener listener) {
        final OnBlobRetrievedListener listener2 = listener;
        runWhenServiceReady(new IpMemoryStoreClient$$ExternalSyntheticLambda9(this, l2Key, clientId, name, listener2));     // Catch: ExecutionException -> L6
        return;
    L10:
        ignoringRemoteException("Error retrieving blob", new IpMemoryStoreClient$$ExternalSyntheticLambda10(listener2));
        return;
    L9:
        listener2 = listener;
        goto L10
    }

    private static /* synthetic */ void lambda$retrieveBlob$15(IIpMemoryStore service, String l2Key, String clientId, String name, OnBlobRetrievedListener listener) throws RemoteException {
        service.retrieveBlob(l2Key, clientId, name, OnBlobRetrievedListener.toAIDL(listener));
    }

    private static /* synthetic */ void lambda$retrieveBlob$17(OnBlobRetrievedListener listener) throws RemoteException {
        listener.onBlobRetrieved(new Status(-5), null, null, null);
    }

    private /* synthetic */ void lambda$delete$19(final String l2Key, final boolean needWipe, final OnDeleteStatusListener listener, final IIpMemoryStore service) {
        ignoringRemoteException(new IpMemoryStoreClient$$ExternalSyntheticLambda13(service, l2Key, needWipe, listener));
    }

    public void delete(final String l2Key, final boolean needWipe, final OnDeleteStatusListener listener) {
        runWhenServiceReady(new IpMemoryStoreClient$$ExternalSyntheticLambda4(this, l2Key, needWipe, listener));     // Catch: ExecutionException -> L4
        return;
    L5:
        if (listener != null) goto L7;
        return;
    L7:
        ignoringRemoteException("Error deleting from the memory store", new IpMemoryStoreClient$$ExternalSyntheticLambda5(listener));
    }

    private static /* synthetic */ void lambda$delete$18(IIpMemoryStore service, String l2Key, boolean needWipe, OnDeleteStatusListener listener) throws RemoteException {
        service.delete(l2Key, needWipe, OnDeleteStatusListener.toAIDL(listener));
    }

    private static /* synthetic */ void lambda$delete$20(OnDeleteStatusListener listener) throws RemoteException {
        listener.onComplete(new Status(-5), 0);
    }

    private /* synthetic */ void lambda$deleteCluster$22(final String cluster, final boolean needWipe, final OnDeleteStatusListener listener, final IIpMemoryStore service) {
        ignoringRemoteException(new IpMemoryStoreClient$$ExternalSyntheticLambda20(service, cluster, needWipe, listener));
    }

    public void deleteCluster(final String cluster, final boolean needWipe, final OnDeleteStatusListener listener) {
        runWhenServiceReady(new IpMemoryStoreClient$$ExternalSyntheticLambda28(this, cluster, needWipe, listener));     // Catch: ExecutionException -> L4
        return;
    L5:
        if (listener != null) goto L7;
        return;
    L7:
        ignoringRemoteException("Error deleting from the memory store", new IpMemoryStoreClient$$ExternalSyntheticLambda29(listener));
    }

    private static /* synthetic */ void lambda$deleteCluster$21(IIpMemoryStore service, String cluster, boolean needWipe, OnDeleteStatusListener listener) throws RemoteException {
        service.deleteCluster(cluster, needWipe, OnDeleteStatusListener.toAIDL(listener));
    }

    private static /* synthetic */ void lambda$deleteCluster$23(OnDeleteStatusListener listener) throws RemoteException {
        listener.onComplete(new Status(-5), 0);
    }

    private /* synthetic */ void lambda$factoryReset$25(final IIpMemoryStore service) {
        ignoringRemoteException(new IpMemoryStoreClient$$ExternalSyntheticLambda17(service));
    }

    public void factoryReset() {
        runWhenServiceReady(new IpMemoryStoreClient$$ExternalSyntheticLambda14(this));     // Catch: ExecutionException -> L4
        return;
    L4:
        m = move-exception;
        Log.e(TAG, "Error executing factory reset", m);
    }

    private static /* synthetic */ void lambda$factoryReset$24(IIpMemoryStore service) throws RemoteException {
        service.factoryReset();
    }

    private /* synthetic */ void lambda$retrieveNetworkEventCount$27(final String cluster, final long[] sinceTimes, final int[] eventTypes, final OnNetworkEventCountRetrievedListener listener, final IIpMemoryStore service) {
        ignoringRemoteException(new IpMemoryStoreClient$$ExternalSyntheticLambda18(service, cluster, sinceTimes, eventTypes, listener));
    }

    public void retrieveNetworkEventCount(final String cluster, final long[] sinceTimes, final int[] eventTypes, OnNetworkEventCountRetrievedListener listener) {
        final OnNetworkEventCountRetrievedListener listener2 = listener;
        runWhenServiceReady(new IpMemoryStoreClient$$ExternalSyntheticLambda24(this, cluster, sinceTimes, eventTypes, listener2));     // Catch: ExecutionException -> L6
        return;
    L10:
        ignoringRemoteException("Error retrieving network event count", new IpMemoryStoreClient$$ExternalSyntheticLambda25(listener2));
        return;
    L9:
        listener2 = listener;
        goto L10
    }

    private static /* synthetic */ void lambda$retrieveNetworkEventCount$26(IIpMemoryStore service, String cluster, long[] sinceTimes, int[] eventTypes, OnNetworkEventCountRetrievedListener listener) throws RemoteException {
        service.retrieveNetworkEventCount(cluster, sinceTimes, eventTypes, OnNetworkEventCountRetrievedListener.toAIDL(listener));
    }

    private static /* synthetic */ void lambda$retrieveNetworkEventCount$28(OnNetworkEventCountRetrievedListener listener) throws RemoteException {
        listener.onNetworkEventCountRetrieved(new Status(-5), new int[0]);
    }

    private /* synthetic */ void lambda$storeNetworkEvent$30(final String cluster, final long timestamp, final long expiry, final int eventType, final OnStatusListener listener, final IIpMemoryStore service) {
        ignoringRemoteException(new IpMemoryStoreClient$$ExternalSyntheticLambda11(service, cluster, timestamp, expiry, eventType, listener));
    }

    public void storeNetworkEvent(final String cluster, final long timestamp, final long expiry, final int eventType, OnStatusListener listener) {
        final OnStatusListener r8 = listener;
        runWhenServiceReady(new IpMemoryStoreClient$$ExternalSyntheticLambda2(this, cluster, timestamp, expiry, eventType, r8));     // Catch: ExecutionException -> L6
        return;
    L10:
        if (r8 != null) goto L12;
        return;
    L12:
        ignoringRemoteException("Error storing network event", new IpMemoryStoreClient$$ExternalSyntheticLambda3(r8));
        return;
    L9:
        r8 = listener;
        goto L10
    }

    private static /* synthetic */ void lambda$storeNetworkEvent$29(IIpMemoryStore service, String cluster, long timestamp, long expiry, int eventType, OnStatusListener listener) throws RemoteException {
        service.storeNetworkEvent(cluster, timestamp, expiry, eventType, OnStatusListener.toAIDL(listener));
    }

    private static /* synthetic */ void lambda$storeNetworkEvent$31(OnStatusListener listener) throws RemoteException {
        listener.onComplete(new Status(-5));
    }
}
