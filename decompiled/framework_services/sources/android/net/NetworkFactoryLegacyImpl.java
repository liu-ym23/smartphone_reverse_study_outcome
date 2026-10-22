package android.net;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class NetworkFactoryLegacyImpl extends Handler implements NetworkFactoryShim {
    public static final int CMD_CANCEL_REQUEST = 2;
    public static final int CMD_REQUEST_NETWORK = 1;
    private static final int CMD_SET_FILTER = 4;
    private static final int CMD_SET_SCORE = 3;
    private static final boolean DBG = true;
    private static final boolean VDBG = false;
    NetworkCapabilities mCapabilityFilter;
    final Context mContext;
    private final Map<NetworkRequest, NetworkRequestInfo> mNetworkRequests;
    final NetworkFactory mParent;
    NetworkProvider mProvider;
    private int mScore;

    private static class NetworkRequestInfo {
        public int providerId;
        public final NetworkRequest request;
        public boolean requested;
        public int score;

        NetworkRequestInfo(NetworkRequest request, int score, int providerId) {
            this.request = request;
            this.score = score;
            this.requested = false;
            this.providerId = providerId;
        }

        public String toString() {
            return "{" + this.request + ", score=" + this.score + ", requested=" + this.requested + "}";
        }
    }

    public static /* synthetic */ void $r8$lambda$MFnRVaGmVUyCHePwisH_3PUZ0EI(NetworkFactoryLegacyImpl r0) {
        r0.evalRequests();
    }

    public static /* synthetic */ void $r8$lambda$yX_lr0ff1mR8YM0wCRapZxVEBCI(NetworkFactoryLegacyImpl r0, NetworkRequest r1) {
        r0.lambda$releaseRequestAsUnfulfillableByAnyFactory$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleRemoveRequest, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m26$$Nest$mhandleRemoveRequest(NetworkFactoryLegacyImpl r0, NetworkRequest r1) {
        r0.handleRemoveRequest(r1);
    }

    NetworkFactoryLegacyImpl(NetworkFactory parent, Looper looper, Context context, NetworkCapabilities filter) {
        super(looper);
        this.mNetworkRequests = new LinkedHashMap();
        this.mProvider = null;
        this.mParent = parent;
        this.mContext = context;
        this.mCapabilityFilter = filter;
    }

    public void register(final String logTag) {
        if (this.mProvider != null) goto L7;
        this.mParent.log("Registering NetworkFactory");
        final Context r1 = this.mContext;
        final Looper r2 = getLooper();
        this.mProvider = new AnonymousClass1(this, r1, r2, logTag);
        ((ConnectivityManager) this.mContext.getSystemService("connectivity")).registerNetworkProvider(this.mProvider);
        return;
    L7:
        throw new IllegalStateException("A NetworkFactory must only be registered once");
    }

    @Override // android.net.NetworkFactoryShim
    public void terminate() {
        if (this.mProvider == null) goto L7;
        this.mParent.log("Unregistering NetworkFactory");
        ((ConnectivityManager) this.mContext.getSystemService("connectivity")).unregisterNetworkProvider(this.mProvider);
        removeCallbacksAndMessages(null);
        return;
    L7:
        throw new IllegalStateException("This NetworkFactory was never registered");
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        switch(msg.what) {
            case 1: goto L8;
            case 2: goto L7;
            case 3: goto L6;
            case 4: goto L5;
            default: goto L13;
        };
    L5:
        handleSetFilter((NetworkCapabilities) msg.obj);
        return;
    L6:
        handleSetScore(msg.arg1);
        return;
    L7:
        handleRemoveRequest((NetworkRequest) msg.obj);
        return;
    L8:
        handleAddRequest((NetworkRequest) msg.obj, msg.arg1, msg.arg2);
        return;
    }

    protected void handleAddRequest(NetworkRequest request, int score, int servingProviderId) {
        NetworkRequestInfo n = this.mNetworkRequests.get(request);
        if (n != null) goto L5;
        this.mParent.log("got request " + request + " with score " + score + " and providerId " + servingProviderId);
        n = new NetworkRequestInfo(request, score, servingProviderId);
        this.mNetworkRequests.put(n.request, n);
    L6:
        evalRequest(n);
        return;
    L5:
        n.score = score;
        n.providerId = servingProviderId;
        goto L6
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

    private void handleSetScore(int score) {
        this.mScore = score;
        evalRequests();
    }

    private void handleSetFilter(NetworkCapabilities netCap) {
        this.mCapabilityFilter = netCap;
        evalRequests();
    }

    public boolean acceptRequest(NetworkRequest request) {
        return this.mParent.acceptRequest(request);
    }

    private void evalRequest(NetworkRequestInfo n) {
        if (shouldNeedNetworkFor(n) == false) goto L6;
        this.mParent.needNetworkFor(n.request);
        n.requested = true;
        return;
    L6:
        if (shouldReleaseNetworkFor(n) == false) goto L10;
        this.mParent.releaseNetworkFor(n.request);
        n.requested = false;
        return;
    }

    private boolean shouldNeedNetworkFor(NetworkRequestInfo n) {
        if (n.requested == false) goto L5;
    L13:
        return false;
    L5:
        if (n.score < this.mScore) goto L9;
        if (n.providerId != this.mProvider.getProviderId()) goto L13;
    L9:
        if (n.request.canBeSatisfiedBy(this.mCapabilityFilter) == false) goto L13;
        if (acceptRequest(n.request) == false) goto L13;
        return true;
    }

    private boolean shouldReleaseNetworkFor(NetworkRequestInfo n) {
        if (n.requested == true) goto L5;
    L13:
        return false;
    L5:
        if (n.score <= this.mScore) goto L9;
        if (n.providerId == this.mProvider.getProviderId()) goto L9;
    L12:
        return true;
    L9:
        if (n.request.canBeSatisfiedBy(this.mCapabilityFilter) == false) goto L12;
        if (acceptRequest(n.request) == true) goto L13;
        goto L12
    }

    private void evalRequests() {
        Iterator<NetworkRequestInfo> r0 = this.mNetworkRequests.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        NetworkRequestInfo n = r0.next();
        evalRequest(n);
        goto L4
    }

    public void reevaluateAllRequests() {
        post(new NetworkFactoryLegacyImpl$$ExternalSyntheticLambda1(this));
    }

    @Override // android.net.NetworkFactoryShim
    public void releaseRequestAsUnfulfillableByAnyFactory(final NetworkRequest r) {
        post(new NetworkFactoryLegacyImpl$$ExternalSyntheticLambda0(this, r));
    }

    private /* synthetic */ void lambda$releaseRequestAsUnfulfillableByAnyFactory$0(NetworkRequest r) {
        this.mParent.log("releaseRequestAsUnfulfillableByAnyFactory: " + r);
        NetworkProvider provider = this.mProvider;
        if (provider != null) goto L6;
        this.mParent.log("Ignoring attempt to release unregistered request as unfulfillable");
        return;
    L6:
        provider.declareNetworkRequestUnfulfillable(r);
    }

    public void setScoreFilter(int score) {
        sendMessage(obtainMessage(3, score, 0));
    }

    public void setScoreFilter(NetworkScore score) {
        setScoreFilter(score.getLegacyInt());
    }

    public void setCapabilityFilter(NetworkCapabilities netCap) {
        sendMessage(obtainMessage(4, new NetworkCapabilities(netCap)));
    }

    public int getRequestCount() {
        return this.mNetworkRequests.size();
    }

    @Override // android.net.NetworkFactoryShim
    public int getSerialNumber() {
        return this.mProvider.getProviderId();
    }

    @Override // android.net.NetworkFactoryShim
    public NetworkProvider getProvider() {
        return this.mProvider;
    }

    public void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
        writer.println(toString());
        Iterator<NetworkRequestInfo> r0 = this.mNetworkRequests.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        NetworkRequestInfo n = r0.next();
        writer.println("  " + n);
        goto L4
    }

    @Override // android.os.Handler
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
