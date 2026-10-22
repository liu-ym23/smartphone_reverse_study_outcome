package android.net;

import android.net.dhcp.DhcpServingParamsParcel;
import android.net.dhcp.IDhcpServerCallbacks;
import android.net.ip.IIpClientCallbacks;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.util.Log;
import android.util.Slog;
import com.android.server.job.controllers.JobStatus;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class NetworkStackClient {
    private static final int NETWORKSTACK_TIMEOUT_MS = 10000;
    private static final String TAG = null;
    private static NetworkStackClient sInstance;
    private INetworkStackConnector mConnector;
    private final Dependencies mDependencies;
    private final ArrayList<NetworkStackCallback> mPendingNetStackRequests;
    private volatile boolean mWasSystemServerInitialized;

    protected interface Dependencies {
        void addToServiceManager(IBinder r1);

        void checkCallerUid();

        ConnectivityModuleConnector getConnectivityModuleConnector();
    }

    private static class DependenciesImpl implements Dependencies {
        /* synthetic */ DependenciesImpl(NetworkStackClientIA r1) {
            this();
        }

        private DependenciesImpl() {
        }

        @Override // android.net.NetworkStackClient.Dependencies
        public void addToServiceManager(IBinder service) {
            ServiceManager.addService("network_stack", service, false, 6);
        }

        @Override // android.net.NetworkStackClient.Dependencies
        public void checkCallerUid() {
            int caller = Binder.getCallingUid();
            if (caller != 1000) goto L5;
            return;
        L5:
            if (caller != 1073) goto L7;
            return;
        L7:
            if (UserHandle.getAppId(caller) != 1002) goto L10;
            return;
        L10:
            throw new SecurityException("Only the system server should try to bind to the network stack.");
        }

        @Override // android.net.NetworkStackClient.Dependencies
        public ConnectivityModuleConnector getConnectivityModuleConnector() {
            return ConnectivityModuleConnector.getInstance();
        }
    }

    private interface NetworkStackCallback {
        void onNetworkStackConnected(INetworkStackConnector r1);
    }

    private class NetworkStackConnection implements ConnectivityModuleConnector.ModuleServiceCallback {
        final /* synthetic */ NetworkStackClient this$0;

        /* synthetic */ NetworkStackConnection(NetworkStackClient r1, NetworkStackClientIA r2) {
            this(r1);
        }

        private NetworkStackConnection(NetworkStackClient r1) {
            this.this$0 = r1;
        }

        @Override // android.net.ConnectivityModuleConnector.ModuleServiceCallback
        public void onModuleServiceConnected(IBinder service) {
            NetworkStackClient.m28$$Nest$mlogi(this.this$0, "Network stack service connected");
            NetworkStackClient.m29$$Nest$mregisterNetworkStackService(this.this$0, service);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$Ba_AsipTQQ-hKyLsGAPLnsXM-L0, reason: not valid java name */
    public static /* synthetic */ void m27$r8$lambda$Ba_AsipTQQhKyLsGAPLnsXML0(String r0, DhcpServingParamsParcel r1, IDhcpServerCallbacks r2, INetworkStackConnector r3) {
        lambda$makeDhcpServer$0(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$GmFOZAoaRNbtlKNkgJ53jvx1I8E(String r0, IIpClientCallbacks r1, INetworkStackConnector r2) {
        lambda$makeIpClient$1(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$dN_4LBakF3RMC4PJoPi4VjtiKz0(IIpMemoryStoreCallbacks r0, INetworkStackConnector r1) {
        lambda$fetchIpMemoryStore$3(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$lTpfm7adJOl_gEmKBPGYh1wEYsk(Network r0, String r1, INetworkMonitorCallbacks r2, INetworkStackConnector r3) {
        lambda$makeNetworkMonitor$2(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mlogi, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m28$$Nest$mlogi(NetworkStackClient r0, String r1) {
        r0.logi(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mregisterNetworkStackService, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m29$$Nest$mregisterNetworkStackService(NetworkStackClient r0, IBinder r1) {
        r0.registerNetworkStackService(r1);
    }

    static {
        TAG = NetworkStackClient.class.getSimpleName();
    }

    protected NetworkStackClient(Dependencies dependencies) {
        this.mPendingNetStackRequests = new ArrayList();
        this.mWasSystemServerInitialized = false;
        this.mDependencies = dependencies;
    }

    private NetworkStackClient() {
        this(new DependenciesImpl(null));
    }

    public static synchronized NetworkStackClient getInstance() {
        monitor-enter(NetworkStackClient.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L9;
        sInstance = new NetworkStackClient();     // Catch: Throwable -> L7
    L9:
        NetworkStackClient r1 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(NetworkStackClient.class);
        return r1;
    }

    public void makeDhcpServer(final String ifName, final DhcpServingParamsParcel params, final IDhcpServerCallbacks cb) {
        requestConnector(new NetworkStackClient$$ExternalSyntheticLambda3(ifName, params, cb));
    }

    private static /* synthetic */ void lambda$makeDhcpServer$0(String ifName, DhcpServingParamsParcel params, IDhcpServerCallbacks cb, INetworkStackConnector connector) {
        connector.makeDhcpServer(ifName, params, cb);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        e.rethrowFromSystemServer();
    }

    public void makeIpClient(final String ifName, final IIpClientCallbacks cb) {
        requestConnector(new NetworkStackClient$$ExternalSyntheticLambda0(ifName, cb));
    }

    private static /* synthetic */ void lambda$makeIpClient$1(String ifName, IIpClientCallbacks cb, INetworkStackConnector connector) {
        connector.makeIpClient(ifName, cb);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        e.rethrowFromSystemServer();
    }

    public void makeNetworkMonitor(final Network network, final String name, final INetworkMonitorCallbacks cb) {
        requestConnector(new NetworkStackClient$$ExternalSyntheticLambda1(network, name, cb));
    }

    private static /* synthetic */ void lambda$makeNetworkMonitor$2(Network network, String name, INetworkMonitorCallbacks cb, INetworkStackConnector connector) {
        connector.makeNetworkMonitor(network, name, cb);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        e.rethrowFromSystemServer();
    }

    public void fetchIpMemoryStore(final IIpMemoryStoreCallbacks cb) {
        requestConnector(new NetworkStackClient$$ExternalSyntheticLambda2(cb));
    }

    private static /* synthetic */ void lambda$fetchIpMemoryStore$3(IIpMemoryStoreCallbacks cb, INetworkStackConnector connector) {
        connector.fetchIpMemoryStore(cb);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        e.rethrowFromSystemServer();
    }

    private void registerNetworkStackService(IBinder service) {
        INetworkStackConnector connector = INetworkStackConnector.Stub.asInterface(service);
        this.mDependencies.addToServiceManager(service);
        log("Network stack service registered");
        ArrayList<NetworkStackCallback> r1 = this.mPendingNetStackRequests;
        monitor-enter(r1);
        ArrayList<NetworkStackCallback> requests = new ArrayList(this.mPendingNetStackRequests);     // Catch: Throwable -> L11
        this.mPendingNetStackRequests.clear();     // Catch: Throwable -> L11
        this.mConnector = connector;     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        Iterator<NetworkStackCallback> r2 = requests.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        NetworkStackCallback r = r2.next();
        r.onNetworkStackConnected(connector);
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void init() {
        log("Network stack init");
        this.mWasSystemServerInitialized = true;
    }

    public void start() {
        this.mDependencies.getConnectivityModuleConnector().startModuleService(INetworkStackConnector.class.getName(), "android.permission.MAINLINE_NETWORK_STACK", new NetworkStackConnection(this, null));
        log("Network stack service start requested");
    }

    private void log(String message) {
        Log.d(TAG, message);
    }

    private void logWtf(String message, Throwable e) {
        Slog.wtf(TAG, message);
        Log.e(TAG, message, e);
    }

    private void loge(String message, Throwable e) {
        Log.e(TAG, message, e);
    }

    private void logi(String message) {
        Log.i(TAG, message);
    }

    private INetworkStackConnector getRemoteConnector() {
        long before = System.currentTimeMillis();     // Catch: InterruptedException -> L10
    L4:
        IBinder connector = ServiceManager.getService("network_stack");     // Catch: InterruptedException -> L10
        if (connector != null) goto L13;
        Thread.sleep(20);     // Catch: InterruptedException -> L10
        if ((System.currentTimeMillis() - before) <= JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY) goto L4;
        loge("Timeout waiting for NetworkStack connector", null);     // Catch: InterruptedException -> L10
        return null;
    L13:
        return INetworkStackConnector.Stub.asInterface(connector);
    L10:
        e = move-exception;
        loge("Error waiting for NetworkStack connector", e);
        return null;
    }

    private void requestConnector(NetworkStackCallback request) {
        this.mDependencies.checkCallerUid();
        if (this.mWasSystemServerInitialized == true) goto L13;
        INetworkStackConnector connector = getRemoteConnector();
        ArrayList<NetworkStackCallback> r1 = this.mPendingNetStackRequests;
        monitor-enter(r1);
        this.mConnector = connector;     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        request.onNetworkStackConnected(connector);
        return;
    L10:
        th = move-exception;
        throw th;
    L13:
        ArrayList<NetworkStackCallback> r0 = this.mPendingNetStackRequests;
        monitor-enter(r0);
        INetworkStackConnector connector2 = this.mConnector;     // Catch: Throwable -> L20
        if (connector2 != null) goto L22;
        this.mPendingNetStackRequests.add(request);     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L20
        request.onNetworkStackConnected(connector2);
        return;
    L20:
        th = move-exception;
        throw th;
    }
}
