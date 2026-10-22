package android.net.networkstack;

import android.net.IIpMemoryStoreCallbacks;
import android.net.INetworkMonitorCallbacks;
import android.net.INetworkStackConnector;
import android.net.Network;
import android.net.dhcp.DhcpServingParamsParcel;
import android.net.dhcp.IDhcpServerCallbacks;
import android.net.ip.IIpClientCallbacks;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public abstract class NetworkStackClientBase {
    private INetworkStackConnector mConnector;
    private final ArrayList<Consumer<INetworkStackConnector>> mPendingNetStackRequests;

    /* JADX INFO: renamed from: $r8$lambda$48w_f5bE_-SHUizoPUm5Nk7I_rQ, reason: not valid java name */
    public static /* synthetic */ void m37$r8$lambda$48w_f5bE_SHUizoPUm5Nk7I_rQ(String r0, IIpClientCallbacks r1, INetworkStackConnector r2) {
        lambda$makeIpClient$1(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$W7vPNax4FJkXUNCRAsG5q0i5siM(String r0, DhcpServingParamsParcel r1, IDhcpServerCallbacks r2, INetworkStackConnector r3) {
        lambda$makeDhcpServer$0(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$o36wiYmu4CK8lia6L1FfocOrHHc(IIpMemoryStoreCallbacks r0, INetworkStackConnector r1) {
        lambda$fetchIpMemoryStore$3(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$o_PdOWRUuao3JqvKE8gTlhXzpWQ(Network r0, String r1, INetworkMonitorCallbacks r2, INetworkStackConnector r3) {
        lambda$makeNetworkMonitor$2(r0, r1, r2, r3);
    }

    public NetworkStackClientBase() {
        this.mPendingNetStackRequests = new ArrayList();
    }

    public void makeDhcpServer(final String ifName, final DhcpServingParamsParcel params, final IDhcpServerCallbacks cb) {
        requestConnector(new NetworkStackClientBase$$ExternalSyntheticLambda0(ifName, params, cb));
    }

    private static /* synthetic */ void lambda$makeDhcpServer$0(String ifName, DhcpServingParamsParcel params, IDhcpServerCallbacks cb, INetworkStackConnector connector) {
        connector.makeDhcpServer(ifName, params, cb);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        throw new IllegalStateException("Could not create DhcpServer", e);
    }

    public void makeIpClient(final String ifName, final IIpClientCallbacks cb) {
        requestConnector(new NetworkStackClientBase$$ExternalSyntheticLambda2(ifName, cb));
    }

    private static /* synthetic */ void lambda$makeIpClient$1(String ifName, IIpClientCallbacks cb, INetworkStackConnector connector) {
        connector.makeIpClient(ifName, cb);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        throw new IllegalStateException("Could not create IpClient", e);
    }

    public void makeNetworkMonitor(final Network network, final String name, final INetworkMonitorCallbacks cb) {
        requestConnector(new NetworkStackClientBase$$ExternalSyntheticLambda3(network, name, cb));
    }

    private static /* synthetic */ void lambda$makeNetworkMonitor$2(Network network, String name, INetworkMonitorCallbacks cb, INetworkStackConnector connector) {
        connector.makeNetworkMonitor(network, name, cb);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        throw new IllegalStateException("Could not create NetworkMonitor", e);
    }

    public void fetchIpMemoryStore(final IIpMemoryStoreCallbacks cb) {
        requestConnector(new NetworkStackClientBase$$ExternalSyntheticLambda1(cb));
    }

    private static /* synthetic */ void lambda$fetchIpMemoryStore$3(IIpMemoryStoreCallbacks cb, INetworkStackConnector connector) {
        connector.fetchIpMemoryStore(cb);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        throw new IllegalStateException("Could not fetch IpMemoryStore", e);
    }

    protected void requestConnector(Consumer<INetworkStackConnector> request) {
        ArrayList<Consumer<INetworkStackConnector>> r0 = this.mPendingNetStackRequests;
        monitor-enter(r0);
        INetworkStackConnector connector = this.mConnector;     // Catch: Throwable -> L9
        if (connector != null) goto L11;
        this.mPendingNetStackRequests.add(request);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        request.accept(connector);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    protected void onNetworkStackConnected(INetworkStackConnector connector) {
    L2:
        ArrayList<Consumer<INetworkStackConnector>> r0 = this.mPendingNetStackRequests;
        monitor-enter(r0);
        ArrayList<Consumer<INetworkStackConnector>> requests = new ArrayList(this.mPendingNetStackRequests);     // Catch: Throwable -> L23
        this.mPendingNetStackRequests.clear();     // Catch: Throwable -> L23
        monitor-exit(r0);     // Catch: Throwable -> L23
        Iterator<Consumer<INetworkStackConnector>> r1 = requests.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        Consumer<INetworkStackConnector> consumer = r1.next();
        consumer.accept(connector);
        goto L8
    L10:
        ArrayList<Consumer<INetworkStackConnector>> r2 = this.mPendingNetStackRequests;
        monitor-enter(r2);
    L17:
        th = move-exception;
        throw th;
    L13:
        if (this.mPendingNetStackRequests.size() == 0) goto L14;
        monitor-exit(r2);     // Catch: Throwable -> L17
        goto L2
    L14:
        this.mConnector = connector;     // Catch: Throwable -> L17
        monitor-exit(r2);     // Catch: Throwable -> L17
        return;
    L23:
        th = move-exception;
        throw th;
    }

    protected void onNetworkStackDisconnected() {
        this.mConnector = null;
    }

    protected int getQueueLength() {
        ArrayList<Consumer<INetworkStackConnector>> r0 = this.mPendingNetStackRequests;
        monitor-enter(r0);
        int r1 = this.mPendingNetStackRequests.size();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
