package android.net;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
class NetworkFactoryImpl extends NetworkFactoryLegacyImpl {
    private static final int CMD_CANCEL_REQUEST = 2;
    private static final int CMD_LISTEN_TO_ALL_REQUESTS = 6;
    private static final int CMD_OFFER_NETWORK = 5;
    private static final int CMD_REQUEST_NETWORK = 1;
    private static final int CMD_SET_FILTER = 4;
    private static final int CMD_SET_SCORE = 3;
    private static final boolean DBG = true;
    private static final NetworkScore INVINCIBLE_SCORE = null;
    private static final boolean VDBG = false;
    private final Executor mExecutor;
    private final Map<NetworkRequest, NetworkRequestInfo> mNetworkRequests;
    private final NetworkProvider.NetworkOfferCallback mRequestCallback;
    private NetworkScore mScore;

    private static class NetworkRequestInfo {
        public final NetworkRequest request;
        public boolean requested;

        NetworkRequestInfo(NetworkRequest request) {
            this.request = request;
            this.requested = false;
        }

        public String toString() {
            return "{" + this.request + ", requested=" + this.requested + "}";
        }
    }

    public static /* synthetic */ void $r8$lambda$gco469I383HoexMSXOHYvcsWJ0M(NetworkFactoryImpl r0, Runnable r1) {
        r0.lambda$new$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleAddRequest, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m24$$Nest$mhandleAddRequest(NetworkFactoryImpl r0, NetworkRequest r1) {
        r0.handleAddRequest(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleRemoveRequest, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m25$$Nest$mhandleRemoveRequest(NetworkFactoryImpl r0, NetworkRequest r1) {
        r0.handleRemoveRequest(r1);
    }

    static {
        INVINCIBLE_SCORE = new NetworkScore.Builder().setLegacyInt(1000).build();
    }

    private /* synthetic */ void lambda$new$0(Runnable command) {
        post(command);
    }

    NetworkFactoryImpl(NetworkFactory parent, Looper looper, Context context, NetworkCapabilities filter) {
        if (filter == null) goto L4;
        NetworkCapabilities r0 = filter;
    L5:
        super(parent, looper, context, r0);
        this.mNetworkRequests = new LinkedHashMap();
        this.mScore = new NetworkScore.Builder().setLegacyInt(0).build();
        this.mRequestCallback = new AnonymousClass1(this);
        this.mExecutor = new NetworkFactoryImpl$$ExternalSyntheticLambda0(this);
        return;
    L4:
        r0 = NetworkCapabilities.Builder.withoutDefaultCapabilities().build();
        goto L5
    }

    @Override // android.net.NetworkFactoryLegacyImpl, android.net.NetworkFactoryShim
    public void register(String logTag) {
        register(logTag, false);
    }

    @Override // android.net.NetworkFactoryShim
    public void registerIgnoringScore(String logTag) {
        register(logTag, true);
    }

    private void register(final String logTag, boolean listenToAllRequests) {
        if (this.mProvider != null) goto L10;
        this.mParent.log("Registering NetworkFactory");
        final Context r1 = this.mContext;
        final Looper r2 = getLooper();
        this.mProvider = new AnonymousClass2(this, r1, r2, logTag);
        ((ConnectivityManager) this.mContext.getSystemService("connectivity")).registerNetworkProvider(this.mProvider);
        if (listenToAllRequests == false) goto L7;
        sendMessage(obtainMessage(6));
        return;
    L7:
        sendMessage(obtainMessage(5));
        return;
    L10:
        throw new IllegalStateException("A NetworkFactory must only be registered once");
    }

    private void handleOfferNetwork(NetworkScore score) {
        this.mProvider.registerNetworkOffer(score, this.mCapabilityFilter, this.mExecutor, this.mRequestCallback);
    }

    @Override // android.net.NetworkFactoryLegacyImpl, android.os.Handler
    public void handleMessage(Message msg) {
        switch(msg.what) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L17;
        };
    L5:
        handleOfferNetwork(INVINCIBLE_SCORE);
        return;
    L6:
        handleOfferNetwork(this.mScore);
        return;
    L7:
        handleSetFilter((NetworkCapabilities) msg.obj);
        return;
    L8:
        handleSetScore((NetworkScore) msg.obj);
        return;
    L9:
        handleRemoveRequest((NetworkRequest) msg.obj);
        return;
    L10:
        handleAddRequest((NetworkRequest) msg.obj);
        return;
    }

    private void handleAddRequest(NetworkRequest request) {
        NetworkRequestInfo n = this.mNetworkRequests.get(request);
        if (n != null) goto L6;
        this.mParent.log("got request " + request);
        n = new NetworkRequestInfo(request);
        this.mNetworkRequests.put(n.request, n);
    L6:
        if (this.mParent.acceptRequest(request) == false) goto L9;
        n.requested = true;
        this.mParent.needNetworkFor(request);
        return;
    }

    private void handleRemoveRequest(NetworkRequest request) {
        NetworkRequestInfo n = this.mNetworkRequests.get(request);
        if (n == null) goto L8;
        this.mNetworkRequests.remove(request);
        if (n.requested == false) goto L9;
        this.mParent.releaseNetworkFor(n.request);
        return;
    L9:
        return;
    }

    private void handleSetScore(NetworkScore score) {
        if (this.mScore.equals(score) == false) goto L5;
        return;
    L5:
        this.mScore = score;
        this.mParent.reevaluateAllRequests();
    }

    private void handleSetFilter(NetworkCapabilities netCap) {
        if (netCap.equals(this.mCapabilityFilter) == false) goto L5;
        return;
    L5:
        this.mCapabilityFilter = netCap;
        this.mParent.reevaluateAllRequests();
    }

    @Override // android.net.NetworkFactoryLegacyImpl, android.net.NetworkFactoryShim
    public final void reevaluateAllRequests() {
        if (this.mProvider != null) goto L5;
        return;
    L5:
        this.mProvider.registerNetworkOffer(this.mScore, this.mCapabilityFilter, this.mExecutor, this.mRequestCallback);
    }

    @Override // android.net.NetworkFactoryLegacyImpl, android.net.NetworkFactoryShim
    @Deprecated
    public void setScoreFilter(int score) {
        setScoreFilter(new NetworkScore.Builder().setLegacyInt(score).build());
    }

    @Override // android.net.NetworkFactoryLegacyImpl, android.net.NetworkFactoryShim
    public void setScoreFilter(NetworkScore score) {
        sendMessage(obtainMessage(3, score));
    }

    @Override // android.net.NetworkFactoryLegacyImpl, android.net.NetworkFactoryShim
    public void setCapabilityFilter(NetworkCapabilities netCap) {
        sendMessage(obtainMessage(4, new NetworkCapabilities(netCap)));
    }

    @Override // android.net.NetworkFactoryLegacyImpl, android.net.NetworkFactoryShim
    public int getRequestCount() {
        return this.mNetworkRequests.size();
    }

    @Override // android.net.NetworkFactoryLegacyImpl, android.net.NetworkFactoryShim
    public void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
        writer.println(toString());
        Iterator<NetworkRequestInfo> r0 = this.mNetworkRequests.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        NetworkRequestInfo n = r0.next();
        writer.println("  " + n);
        goto L4
    }

    @Override // android.net.NetworkFactoryLegacyImpl, android.os.Handler
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("providerId=");
        if (this.mProvider == null) goto L5;
        Object r1 = Integer.valueOf(this.mProvider.getProviderId());
    L6:
        r0.append(r1);
        r0.append(", ScoreFilter=");
        r0.append(this.mScore);
        r0.append(", Filter=");
        r0.append(this.mCapabilityFilter);
        r0.append(", requests=");
        r0.append(this.mNetworkRequests.size());
        return r0.toString();
    L5:
        r1 = "null";
        goto L6
    }
}
