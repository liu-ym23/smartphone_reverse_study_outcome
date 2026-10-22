package com.android.server.connectivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.INetdEventCallback;
import android.net.MacAddress;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.metrics.ConnectStats;
import android.net.metrics.DnsEvent;
import android.net.metrics.INetdEventListener;
import android.net.metrics.NetworkMetrics;
import android.net.metrics.WakeupEvent;
import android.net.metrics.WakeupStats;
import android.os.BatteryStatsInternal;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.ArrayMap;
import android.util.Log;
import android.util.SparseArray;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.BitUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.RingBuffer;
import com.android.internal.util.TokenBucket;
import com.android.net.module.util.BaseNetdEventListener;
import com.android.server.LocalServices;
import com.android.server.connectivity.metrics.nano.IpConnectivityLogClass;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes.dex */
public class NetdEventListenerService extends BaseNetdEventListener {
    private static final int[] ALLOWED_CALLBACK_TYPES = null;
    private static final int CONNECT_LATENCY_BURST_LIMIT = 5000;
    private static final int CONNECT_LATENCY_FILL_RATE = 15000;
    private static final boolean DBG = false;
    private static final int METRICS_SNAPSHOT_BUFFER_SIZE = 48;
    private static final long METRICS_SNAPSHOT_SPAN_MS = 300000;
    public static final String SERVICE_NAME = "netd_listener";
    private static final String TAG = null;
    static final int WAKEUP_EVENT_BUFFER_LENGTH = 1024;
    static final String WAKEUP_EVENT_PREFIX_DELIM = ":";
    final TransportForNetIdNetworkCallback mCallback;
    private final ConnectivityManager mCm;
    private final TokenBucket mConnectTb;
    private long mLastSnapshot;
    private INetdEventCallback[] mNetdEventCallbackList;
    private final SparseArray<NetworkMetrics> mNetworkMetrics;
    private final RingBuffer<NetworkMetricsSnapshot> mNetworkMetricsSnapshots;
    private final RingBuffer<WakeupEvent> mWakeupEvents;
    private final ArrayMap<String, WakeupStats> mWakeupStats;

    static class NetworkMetricsSnapshot {
        public List<NetworkMetrics.Summary> stats;
        public long timeMs;

        NetworkMetricsSnapshot() {
            this.stats = new ArrayList();
        }

        static NetworkMetricsSnapshot collect(long timeMs, SparseArray<NetworkMetrics> networkMetrics) {
            NetworkMetricsSnapshot snapshot = new NetworkMetricsSnapshot();
            snapshot.timeMs = timeMs;
            int i = 0;
        L4:
            if (i >= networkMetrics.size()) goto L10;
            NetworkMetrics.Summary s = networkMetrics.valueAt(i).getPendingStats();
            if (s == null) goto L8;
            snapshot.stats.add(s);
        L8:
            i = i + 1;
            goto L4
        L10:
            return snapshot;
        }

        public String toString() {
            StringJoiner j = new StringJoiner(", ");
            Iterator<NetworkMetrics.Summary> r1 = this.stats.iterator();
        L4:
            if (r1.hasNext() == false) goto L7;
            NetworkMetrics.Summary s = r1.next();
            j.add(s.toString());
            goto L4
        L7:
            return String.format("%tT.%tL: %s", new Object[]{Long.valueOf(this.timeMs), Long.valueOf(this.timeMs), j.toString()});
        }
    }

    private class TransportForNetIdNetworkCallback extends ConnectivityManager.NetworkCallback {
        private final SparseArray<NetworkCapabilities> mCapabilities;

        /* synthetic */ TransportForNetIdNetworkCallback(NetdEventListenerService r1, NetdEventListenerServiceIA r2) {
            this(r1);
        }

        private TransportForNetIdNetworkCallback(NetdEventListenerService r1) {
            this.mCapabilities = new SparseArray();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities nc) {
            SparseArray<NetworkCapabilities> r0 = this.mCapabilities;
            monitor-enter(r0);
            this.mCapabilities.put(network.getNetId(), nc);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            SparseArray<NetworkCapabilities> r0 = this.mCapabilities;
            monitor-enter(r0);
            this.mCapabilities.remove(network.getNetId());     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public NetworkCapabilities getNetworkCapabilities(int netId) {
            SparseArray<NetworkCapabilities> r0 = this.mCapabilities;
            monitor-enter(r0);
            NetworkCapabilities r1 = this.mCapabilities.get(netId);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static {
        TAG = NetdEventListenerService.class.getSimpleName();
        ALLOWED_CALLBACK_TYPES = new int[]{0, 1, 2};
    }

    public synchronized boolean addNetdEventCallback(int callerType, INetdEventCallback callback) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (isValidCallerType(callerType) == true) goto L11;
        Log.e(TAG, "Invalid caller type: " + callerType);     // Catch: Throwable -> L9
        monitor-exit(this);
        return false;
    L11:
        this.mNetdEventCallbackList[callerType] = callback;     // Catch: Throwable -> L9
        monitor-exit(this);
        return true;
    }

    public synchronized boolean removeNetdEventCallback(int callerType) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (isValidCallerType(callerType) == true) goto L11;
        Log.e(TAG, "Invalid caller type: " + callerType);     // Catch: Throwable -> L9
        monitor-exit(this);
        return false;
    L11:
        this.mNetdEventCallbackList[callerType] = null;     // Catch: Throwable -> L9
        monitor-exit(this);
        return true;
    }

    private static boolean isValidCallerType(int callerType) {
        int i = 0;
    L4:
        if (i >= ALLOWED_CALLBACK_TYPES.length) goto L10;
        if (callerType == ALLOWED_CALLBACK_TYPES[i]) goto L7;
        i = i + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public NetdEventListenerService(Context context) {
        this((ConnectivityManager) context.getSystemService(ConnectivityManager.class));
    }

    public NetdEventListenerService(ConnectivityManager cm) {
        this.mNetworkMetrics = new SparseArray();
        this.mNetworkMetricsSnapshots = new RingBuffer(NetworkMetricsSnapshot.class, 48);
        this.mLastSnapshot = 0;
        this.mWakeupStats = new ArrayMap();
        this.mWakeupEvents = new RingBuffer(WakeupEvent.class, 1024);
        this.mConnectTb = new TokenBucket(15000, 5000);
        this.mCallback = new TransportForNetIdNetworkCallback(this, null);
        this.mNetdEventCallbackList = new INetdEventCallback[ALLOWED_CALLBACK_TYPES.length];
        this.mCm = cm;
        this.mCm.registerNetworkCallback(new NetworkRequest.Builder().clearCapabilities().build(), this.mCallback);
    }

    private static long projectSnapshotTime(long timeMs) {
        return (timeMs / 300000) * 300000;
    }

    private NetworkMetrics getMetricsForNetwork(long timeMs, int netId) {
        NetworkMetrics metrics = this.mNetworkMetrics.get(netId);
        NetworkCapabilities nc = this.mCallback.getNetworkCapabilities(netId);
        if (nc == null) goto L5;
        long transports = BitUtils.packBits(nc.getTransportTypes());
    L6:
        if (metrics == null) goto L11;
        if (nc == null) goto L11;
        if (metrics.transports == transports) goto L11;
        boolean forceCollect = true;
    L12:
        collectPendingMetricsSnapshot(timeMs, forceCollect);
        if (metrics == null) goto L15;
        if (forceCollect == true) goto L15;
        return metrics;
    L15:
        NetworkMetrics metrics2 = new NetworkMetrics(netId, transports, this.mConnectTb);
        this.mNetworkMetrics.put(netId, metrics2);
        return metrics2;
    L11:
        forceCollect = false;
        goto L12
    L5:
        transports = 0;
        goto L6
    }

    private NetworkMetricsSnapshot[] getNetworkMetricsSnapshots() {
        collectPendingMetricsSnapshot(System.currentTimeMillis(), false);
        return (NetworkMetricsSnapshot[]) this.mNetworkMetricsSnapshots.toArray();
    }

    private void collectPendingMetricsSnapshot(long timeMs, boolean forceCollect) {
        if (forceCollect == false) goto L4;
    L6:
        this.mLastSnapshot = projectSnapshotTime(timeMs);
        NetworkMetricsSnapshot snapshot = NetworkMetricsSnapshot.collect(this.mLastSnapshot, this.mNetworkMetrics);
        if (snapshot.stats.isEmpty() == false) goto L9;
        return;
    L9:
        this.mNetworkMetricsSnapshots.append(snapshot);
        return;
    L4:
        if (Math.abs(timeMs - this.mLastSnapshot) > 300000) goto L6;
    }

    @Override // com.android.net.module.util.BaseNetdEventListener, android.net.metrics.INetdEventListener
    public synchronized void onDnsEvent(int netId, int eventType, int returnCode, int latencyMs, String hostname, String[] ipAddresses, int ipAddressesCount, int uid) {
        monitor-enter(this);
        long timestamp = System.currentTimeMillis();     // Catch: Throwable -> L10
        int r4 = eventType;
        int r5 = returnCode;
        getMetricsForNetwork(timestamp, netId).addDnsResult(r4, r5, latencyMs);     // Catch: Throwable -> L10
        INetdEventCallback[] r0 = this.mNetdEventCallbackList;     // Catch: Throwable -> L10
        int r12 = r0.length;     // Catch: Throwable -> L10
        int r13 = 0;
    L4:
        if (r13 >= r12) goto L16;
        INetdEventCallback callback = r0[r13];     // Catch: Throwable -> L10
        if (callback == null) goto L15;
        callback.onDnsEvent(netId, r4, r5, hostname, ipAddresses, ipAddressesCount, timestamp, uid);     // Catch: Throwable -> L10 RemoteException -> L12
    L12:
        e = move-exception;
        throw e.rethrowFromSystemServer();     // Catch: Throwable -> L10
    L15:
        r13 = r13 + 1;
        r4 = eventType;
        r5 = returnCode;
        goto L4
    L16:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.android.net.module.util.BaseNetdEventListener, android.net.metrics.INetdEventListener
    public synchronized void onNat64PrefixEvent(int netId, boolean added, String prefixString, int prefixLength) {
        monitor-enter(this);
        INetdEventCallback[] r0 = this.mNetdEventCallbackList;     // Catch: Throwable -> L9
        int r1 = r0.length;     // Catch: Throwable -> L9
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L15;
        INetdEventCallback callback = r0[r2];     // Catch: Throwable -> L9
        if (callback == null) goto L14;
        callback.onNat64PrefixEvent(netId, added, prefixString, prefixLength);     // Catch: Throwable -> L9 RemoteException -> L11
    L11:
        e = move-exception;
        throw e.rethrowFromSystemServer();     // Catch: Throwable -> L9
    L14:
        r2 = r2 + 1;
        goto L4
    L15:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.net.module.util.BaseNetdEventListener, android.net.metrics.INetdEventListener
    public synchronized void onPrivateDnsValidationEvent(int netId, String ipAddress, String hostname, boolean validated) {
        monitor-enter(this);
        INetdEventCallback[] r0 = this.mNetdEventCallbackList;     // Catch: Throwable -> L9
        int r1 = r0.length;     // Catch: Throwable -> L9
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L15;
        INetdEventCallback callback = r0[r2];     // Catch: Throwable -> L9
        if (callback == null) goto L14;
        callback.onPrivateDnsValidationEvent(netId, ipAddress, hostname, validated);     // Catch: Throwable -> L9 RemoteException -> L11
    L11:
        e = move-exception;
        throw e.rethrowFromSystemServer();     // Catch: Throwable -> L9
    L14:
        r2 = r2 + 1;
        goto L4
    L15:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.net.module.util.BaseNetdEventListener, android.net.metrics.INetdEventListener
    public synchronized void onConnectEvent(int netId, int error, int latencyMs, String ipAddr, int port, int uid) {
        monitor-enter(this);
        long timestamp = System.currentTimeMillis();     // Catch: Throwable -> L10
        getMetricsForNetwork(timestamp, netId).addConnectResult(error, latencyMs, ipAddr);     // Catch: Throwable -> L10
        INetdEventCallback[] r0 = this.mNetdEventCallbackList;     // Catch: Throwable -> L10
        int r1 = r0.length;     // Catch: Throwable -> L10
        int r8 = 0;
    L4:
        if (r8 >= r1) goto L18;
        INetdEventCallback callback = r0[r8];     // Catch: Throwable -> L10
        if (callback == null) goto L16;
        String ipAddr2 = ipAddr;
        int port2 = port;
        int uid2 = uid;
        callback.onConnectEvent(ipAddr2, port2, timestamp, uid2);     // Catch: Throwable -> L10 RemoteException -> L12
    L17:
        r8 = r8 + 1;
        ipAddr = ipAddr2;
        port = port2;
        uid = uid2;
    L12:
        e = move-exception;
        throw e.rethrowFromSystemServer();     // Catch: Throwable -> L10
    L16:
        ipAddr2 = ipAddr;
        port2 = port;
        uid2 = uid;
        goto L17
    L18:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private boolean hasWifiTransport(Network network) {
        NetworkCapabilities nc = this.mCm.getNetworkCapabilities(network);
        return nc.hasTransport(1);
    }

    @Override // com.android.net.module.util.BaseNetdEventListener, android.net.metrics.INetdEventListener
    public synchronized void onWakeupEvent(String prefix, int uid, int ethertype, int ipNextHeader, byte[] dstHw, String srcIp, String dstIp, int srcPort, int dstPort, long timestampNs) {
        monitor-enter(this);
        String[] prefixParts = prefix.split(WAKEUP_EVENT_PREFIX_DELIM);     // Catch: Throwable -> L11
        if (prefixParts.length != 2) goto L27;
        long netHandle = Long.parseLong(prefixParts[0]);     // Catch: Throwable -> L11
        Network network = Network.fromNetworkHandle(netHandle);     // Catch: Throwable -> L11
        WakeupEvent event = new WakeupEvent();     // Catch: Throwable -> L11
        event.iface = prefixParts[1];     // Catch: Throwable -> L11
        event.uid = uid;     // Catch: Throwable -> L11
        event.ethertype = ethertype;     // Catch: Throwable -> L11
        if (ArrayUtils.isEmpty(dstHw) == true) goto L9;
        event.dstHwAddr = MacAddress.fromBytes(dstHw);     // Catch: Throwable -> L11
    L15:
        event.srcIp = srcIp;     // Catch: Throwable -> L11
        event.dstIp = dstIp;     // Catch: Throwable -> L11
        event.ipNextHeader = ipNextHeader;     // Catch: Throwable -> L11
        event.srcPort = srcPort;     // Catch: Throwable -> L11
        event.dstPort = dstPort;     // Catch: Throwable -> L11
        if (timestampNs <= 0) goto L18;
        event.timestampMs = timestampNs / 1000000;     // Catch: Throwable -> L11
    L19:
        addWakeupEvent(event);     // Catch: Throwable -> L11
        BatteryStatsInternal bsi = (BatteryStatsInternal) LocalServices.getService(BatteryStatsInternal.class);     // Catch: Throwable -> L11
        if (bsi == null) goto L22;
        long elapsedMs = (SystemClock.elapsedRealtime() + event.timestampMs) - System.currentTimeMillis();     // Catch: Throwable -> L11
        bsi.noteCpuWakingNetworkPacket(network, elapsedMs, event.uid);     // Catch: Throwable -> L11
    L22:
        String dstMac = String.valueOf(event.dstHwAddr);     // Catch: Throwable -> L11
        FrameworkStatsLog.write(44, uid, event.iface, ethertype, dstMac, srcIp, dstIp, ipNextHeader, srcPort, dstPort);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L18:
        event.timestampMs = System.currentTimeMillis();     // Catch: Throwable -> L11
        goto L19
    L9:
        if (hasWifiTransport(network) == false) goto L13;
        Log.e(TAG, "Empty mac address on WiFi transport, network: " + network);     // Catch: Throwable -> L11
    L13:
        event.dstHwAddr = null;     // Catch: Throwable -> L11
        goto L15
    L27:
        throw new IllegalArgumentException("Prefix " + prefix + " required in format <nethandle>:<interface>");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.android.net.module.util.BaseNetdEventListener, android.net.metrics.INetdEventListener
    public synchronized void onTcpSocketStatsEvent(int[] networkIds, int[] sentPackets, int[] lostPackets, int[] rttsUs, int[] sentAckDiffsMs) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (networkIds.length == sentPackets.length) goto L6;
    L22:
        Log.e(TAG, "Mismatched lengths of TCP socket stats data arrays");     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L6:
        if (networkIds.length != lostPackets.length) goto L22;
        if (networkIds.length != rttsUs.length) goto L22;
        if (networkIds.length != sentAckDiffsMs.length) goto L22;
        long timestamp = System.currentTimeMillis();     // Catch: Throwable -> L17
        int i = 0;
    L14:
        if (i >= networkIds.length) goto L20;
        int netId = networkIds[i];     // Catch: Throwable -> L17
        int sent = sentPackets[i];     // Catch: Throwable -> L17
        int lost = lostPackets[i];     // Catch: Throwable -> L17
        int rttUs = rttsUs[i];     // Catch: Throwable -> L17
        int sentAckDiffMs = sentAckDiffsMs[i];     // Catch: Throwable -> L17
        getMetricsForNetwork(timestamp, netId).addTcpStatsResult(sent, lost, rttUs, sentAckDiffMs);     // Catch: Throwable -> L17
        i = i + 1;
        goto L14
    L20:
        monitor-exit(this);
    }

    @Override // com.android.net.module.util.BaseNetdEventListener, android.net.metrics.INetdEventListener
    public int getInterfaceVersion() {
        return 1;
    }

    @Override // com.android.net.module.util.BaseNetdEventListener, android.net.metrics.INetdEventListener
    public String getInterfaceHash() {
        return INetdEventListener.HASH;
    }

    private void addWakeupEvent(WakeupEvent event) {
        String iface = event.iface;
        this.mWakeupEvents.append(event);
        WakeupStats stats = this.mWakeupStats.get(iface);
        if (stats != null) goto L5;
        stats = new WakeupStats(iface);
        this.mWakeupStats.put(iface, stats);
    L5:
        stats.countEvent(event);
    }

    public synchronized void flushStatistics(List<IpConnectivityLogClass.IpConnectivityEvent> events) {
        monitor-enter(this);
        int i = 0;
    L30:
    L11:
        th = move-exception;
        throw th;
    L5:
        if (i >= this.mNetworkMetrics.size()) goto L13;
        ConnectStats stats = this.mNetworkMetrics.valueAt(i).connectMetrics;     // Catch: Throwable -> L11
        if (stats.eventCount == 0) goto L10;
        events.add(IpConnectivityEventBuilder.toProto(stats));     // Catch: Throwable -> L11
    L10:
        i = i + 1;     // Catch: Throwable -> L11
        goto L30
    L13:
        int i2 = 0;
    L15:
        if (i2 >= this.mNetworkMetrics.size()) goto L21;
        DnsEvent ev = this.mNetworkMetrics.valueAt(i2).dnsMetrics;     // Catch: Throwable -> L11
        if (ev.eventCount == 0) goto L20;
        events.add(IpConnectivityEventBuilder.toProto(ev));     // Catch: Throwable -> L11
    L20:
        i2 = i2 + 1;     // Catch: Throwable -> L11
        goto L15
    L21:
        int i3 = 0;
    L23:
        if (i3 >= this.mWakeupStats.size()) goto L25;
        events.add(IpConnectivityEventBuilder.toProto(this.mWakeupStats.valueAt(i3)));     // Catch: Throwable -> L11
        i3 = i3 + 1;     // Catch: Throwable -> L11
        goto L23
    L25:
        this.mNetworkMetrics.clear();     // Catch: Throwable -> L11
        this.mWakeupStats.clear();     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public synchronized void list(PrintWriter pw) {
        monitor-enter(this);
        pw.println("dns/connect events:");     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= this.mNetworkMetrics.size()) goto L9;
        pw.println(this.mNetworkMetrics.valueAt(i).connectMetrics);     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        int i2 = 0;
    L11:
        if (i2 >= this.mNetworkMetrics.size()) goto L13;
        pw.println(this.mNetworkMetrics.valueAt(i2).dnsMetrics);     // Catch: Throwable -> L7
        i2 = i2 + 1;     // Catch: Throwable -> L7
        goto L11
    L13:
        pw.println("");     // Catch: Throwable -> L7
        pw.println("network statistics:");     // Catch: Throwable -> L7
        NetworkMetricsSnapshot[] r0 = getNetworkMetricsSnapshots();     // Catch: Throwable -> L7
        int r1 = r0.length;     // Catch: Throwable -> L7
        int r2 = 0;
        int r3 = 0;
    L14:
        if (r3 >= r1) goto L16;
        NetworkMetricsSnapshot s = r0[r3];     // Catch: Throwable -> L7
        pw.println(s);     // Catch: Throwable -> L7
        r3 = r3 + 1;     // Catch: Throwable -> L7
        goto L14
    L16:
        pw.println("");     // Catch: Throwable -> L7
        pw.println("packet wakeup events:");     // Catch: Throwable -> L7
        int i3 = 0;
    L18:
        if (i3 >= this.mWakeupStats.size()) goto L20;
        pw.println(this.mWakeupStats.valueAt(i3));     // Catch: Throwable -> L7
        i3 = i3 + 1;     // Catch: Throwable -> L7
        goto L18
    L20:
        WakeupEvent[] r4 = (WakeupEvent[]) this.mWakeupEvents.toArray();     // Catch: Throwable -> L7
        int r5 = r4.length;     // Catch: Throwable -> L7
    L21:
        if (r2 >= r5) goto L24;
        WakeupEvent wakeup = r4[r2];     // Catch: Throwable -> L7
        pw.println(wakeup);     // Catch: Throwable -> L7
        r2 = r2 + 1;
        goto L21
    L24:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized List<IpConnectivityLogClass.IpConnectivityEvent> listAsProtos() {
        monitor-enter(this);
        List<IpConnectivityLogClass.IpConnectivityEvent> list = new ArrayList();     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= this.mNetworkMetrics.size()) goto L9;
        list.add(IpConnectivityEventBuilder.toProto(this.mNetworkMetrics.valueAt(i).connectMetrics));     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        int i2 = 0;
    L11:
        if (i2 >= this.mNetworkMetrics.size()) goto L13;
        list.add(IpConnectivityEventBuilder.toProto(this.mNetworkMetrics.valueAt(i2).dnsMetrics));     // Catch: Throwable -> L7
        i2 = i2 + 1;     // Catch: Throwable -> L7
        goto L11
    L13:
        int i3 = 0;
    L14:
        if (i3 >= this.mWakeupStats.size()) goto L19;
        list.add(IpConnectivityEventBuilder.toProto(this.mWakeupStats.valueAt(i3)));     // Catch: Throwable -> L7
        i3 = i3 + 1;
        goto L14
    L19:
        monitor-exit(this);
        return list;
    L7:
        th = move-exception;
        throw th;
    }
}
