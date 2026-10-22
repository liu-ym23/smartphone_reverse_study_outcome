package com.android.server.connectivity;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import android.net.ConnectivityMetricsEvent;
import android.net.metrics.ApfProgramEvent;
import android.net.metrics.ApfStats;
import android.net.metrics.ConnectStats;
import android.net.metrics.DefaultNetworkEvent;
import android.net.metrics.DhcpClientEvent;
import android.net.metrics.DhcpErrorEvent;
import android.net.metrics.DnsEvent;
import android.net.metrics.IpManagerEvent;
import android.net.metrics.IpReachabilityEvent;
import android.net.metrics.NetworkEvent;
import android.net.metrics.RaEvent;
import android.net.metrics.ValidationProbeEvent;
import android.net.metrics.WakeupStats;
import android.os.Parcelable;
import android.util.SparseIntArray;
import com.android.server.connectivity.metrics.nano.IpConnectivityLogClass;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class IpConnectivityEventBuilder {
    private static final int[] IFNAME_LINKLAYERS = null;
    private static final String[] IFNAME_PREFIXES = null;
    private static final int KNOWN_PREFIX = 7;
    private static final SparseIntArray TRANSPORT_LINKLAYER_MAP = null;

    private IpConnectivityEventBuilder() {
    }

    public static byte[] serialize(int dropped, List<IpConnectivityLogClass.IpConnectivityEvent> events) throws IOException {
        IpConnectivityLogClass.IpConnectivityLog log = new IpConnectivityLogClass.IpConnectivityLog();
        log.events = (IpConnectivityLogClass.IpConnectivityEvent[]) events.toArray(new IpConnectivityLogClass.IpConnectivityEvent[events.size()]);
        log.droppedEvents = dropped;
        if (log.events.length > 0) goto L5;
        if (dropped > 0) goto L5;
    L7:
        return IpConnectivityLogClass.IpConnectivityLog.toByteArray(log);
    L5:
        log.version = 2;
        goto L7
    }

    public static List<IpConnectivityLogClass.IpConnectivityEvent> toProto(List<ConnectivityMetricsEvent> eventsIn) {
        ArrayList<IpConnectivityLogClass.IpConnectivityEvent> eventsOut = new ArrayList(eventsIn.size());
        Iterator<ConnectivityMetricsEvent> r1 = eventsIn.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        ConnectivityMetricsEvent in = r1.next();
        IpConnectivityLogClass.IpConnectivityEvent out = toProto(in);
        if (out == null) goto L4;
        eventsOut.add(out);
        goto L4
    L9:
        return eventsOut;
    }

    public static IpConnectivityLogClass.IpConnectivityEvent toProto(ConnectivityMetricsEvent ev) {
        IpConnectivityLogClass.IpConnectivityEvent out = buildEvent(ev.netId, ev.transports, ev.ifname);
        out.timeMs = ev.timestamp;
        if (setEvent(out, ev.data) == true) goto L6;
        return null;
    L6:
        return out;
    }

    public static IpConnectivityLogClass.IpConnectivityEvent toProto(ConnectStats in) {
        IpConnectivityLogClass.ConnectStatistics stats = new IpConnectivityLogClass.ConnectStatistics();
        stats.connectCount = in.connectCount;
        stats.connectBlockingCount = in.connectBlockingCount;
        stats.ipv6AddrCount = in.ipv6ConnectCount;
        stats.latenciesMs = in.latencies.toArray();
        stats.errnosCounters = toPairArray(in.errnos);
        IpConnectivityLogClass.IpConnectivityEvent out = buildEvent(in.netId, in.transports, null);
        out.setConnectStatistics(stats);
        return out;
    }

    public static IpConnectivityLogClass.IpConnectivityEvent toProto(DnsEvent in) {
        IpConnectivityLogClass.DNSLookupBatch dnsLookupBatch = new IpConnectivityLogClass.DNSLookupBatch();
        in.resize(in.eventCount);
        dnsLookupBatch.eventTypes = bytesToInts(in.eventTypes);
        dnsLookupBatch.returnCodes = bytesToInts(in.returnCodes);
        dnsLookupBatch.latenciesMs = in.latenciesMs;
        IpConnectivityLogClass.IpConnectivityEvent out = buildEvent(in.netId, in.transports, null);
        out.setDnsLookupBatch(dnsLookupBatch);
        return out;
    }

    public static IpConnectivityLogClass.IpConnectivityEvent toProto(WakeupStats in) {
        IpConnectivityLogClass.WakeupStats wakeupStats = new IpConnectivityLogClass.WakeupStats();
        in.updateDuration();
        wakeupStats.durationSec = in.durationSec;
        wakeupStats.totalWakeups = in.totalWakeups;
        wakeupStats.rootWakeups = in.rootWakeups;
        wakeupStats.systemWakeups = in.systemWakeups;
        wakeupStats.nonApplicationWakeups = in.nonApplicationWakeups;
        wakeupStats.applicationWakeups = in.applicationWakeups;
        wakeupStats.noUidWakeups = in.noUidWakeups;
        wakeupStats.l2UnicastCount = in.l2UnicastCount;
        wakeupStats.l2MulticastCount = in.l2MulticastCount;
        wakeupStats.l2BroadcastCount = in.l2BroadcastCount;
        wakeupStats.ethertypeCounts = toPairArray(in.ethertypes);
        wakeupStats.ipNextHeaderCounts = toPairArray(in.ipNextHeaders);
        IpConnectivityLogClass.IpConnectivityEvent out = buildEvent(0, 0, in.iface);
        out.setWakeupStats(wakeupStats);
        return out;
    }

    public static IpConnectivityLogClass.IpConnectivityEvent toProto(DefaultNetworkEvent in) {
        IpConnectivityLogClass.DefaultNetworkEvent ev = new IpConnectivityLogClass.DefaultNetworkEvent();
        ev.finalScore = in.finalScore;
        ev.initialScore = in.initialScore;
        ev.ipSupport = ipSupportOf(in);
        ev.defaultNetworkDurationMs = in.durationMs;
        ev.validationDurationMs = in.validatedMs;
        ev.previousDefaultNetworkLinkLayer = transportsToLinkLayer(in.previousTransports);
        IpConnectivityLogClass.IpConnectivityEvent out = buildEvent(in.netId, in.transports, null);
        if (in.transports != 0) goto L5;
        out.linkLayer = 5;
    L5:
        out.setDefaultNetworkEvent(ev);
        return out;
    }

    private static IpConnectivityLogClass.IpConnectivityEvent buildEvent(int netId, long transports, String ifname) {
        IpConnectivityLogClass.IpConnectivityEvent ev = new IpConnectivityLogClass.IpConnectivityEvent();
        ev.networkId = netId;
        ev.transports = transports;
        if (ifname == null) goto L5;
        ev.ifName = ifname;
    L5:
        inferLinkLayer(ev);
        return ev;
    }

    private static boolean setEvent(IpConnectivityLogClass.IpConnectivityEvent out, Parcelable in) {
        if ((in instanceof DhcpErrorEvent) == false) goto L7;
        setDhcpErrorEvent(out, (DhcpErrorEvent) in);
        return true;
    L7:
        if ((in instanceof DhcpClientEvent) == false) goto L11;
        setDhcpClientEvent(out, (DhcpClientEvent) in);
        return true;
    L11:
        if ((in instanceof IpManagerEvent) == false) goto L15;
        setIpManagerEvent(out, (IpManagerEvent) in);
        return true;
    L15:
        if ((in instanceof IpReachabilityEvent) == false) goto L19;
        setIpReachabilityEvent(out, (IpReachabilityEvent) in);
        return true;
    L19:
        if ((in instanceof NetworkEvent) == false) goto L23;
        setNetworkEvent(out, (NetworkEvent) in);
        return true;
    L23:
        if ((in instanceof ValidationProbeEvent) == false) goto L27;
        setValidationProbeEvent(out, (ValidationProbeEvent) in);
        return true;
    L27:
        if ((in instanceof ApfProgramEvent) == false) goto L31;
        setApfProgramEvent(out, (ApfProgramEvent) in);
        return true;
    L31:
        if ((in instanceof ApfStats) == false) goto L35;
        setApfStats(out, (ApfStats) in);
        return true;
    L35:
        if ((in instanceof RaEvent) == false) goto L38;
        setRaEvent(out, (RaEvent) in);
        return true;
    L38:
        return false;
    }

    private static void setDhcpErrorEvent(IpConnectivityLogClass.IpConnectivityEvent out, DhcpErrorEvent in) {
        IpConnectivityLogClass.DHCPEvent dhcpEvent = new IpConnectivityLogClass.DHCPEvent();
        dhcpEvent.setErrorCode(in.errorCode);
        out.setDhcpEvent(dhcpEvent);
    }

    private static void setDhcpClientEvent(IpConnectivityLogClass.IpConnectivityEvent out, DhcpClientEvent in) {
        IpConnectivityLogClass.DHCPEvent dhcpEvent = new IpConnectivityLogClass.DHCPEvent();
        dhcpEvent.setStateTransition(in.msg);
        dhcpEvent.durationMs = in.durationMs;
        out.setDhcpEvent(dhcpEvent);
    }

    private static void setIpManagerEvent(IpConnectivityLogClass.IpConnectivityEvent out, IpManagerEvent in) {
        IpConnectivityLogClass.IpProvisioningEvent ipProvisioningEvent = new IpConnectivityLogClass.IpProvisioningEvent();
        ipProvisioningEvent.eventType = in.eventType;
        ipProvisioningEvent.latencyMs = (int) in.durationMs;
        out.setIpProvisioningEvent(ipProvisioningEvent);
    }

    private static void setIpReachabilityEvent(IpConnectivityLogClass.IpConnectivityEvent out, IpReachabilityEvent in) {
        IpConnectivityLogClass.IpReachabilityEvent ipReachabilityEvent = new IpConnectivityLogClass.IpReachabilityEvent();
        ipReachabilityEvent.eventType = in.eventType;
        out.setIpReachabilityEvent(ipReachabilityEvent);
    }

    private static void setNetworkEvent(IpConnectivityLogClass.IpConnectivityEvent out, NetworkEvent in) {
        IpConnectivityLogClass.NetworkEvent networkEvent = new IpConnectivityLogClass.NetworkEvent();
        networkEvent.eventType = in.eventType;
        networkEvent.latencyMs = (int) in.durationMs;
        out.setNetworkEvent(networkEvent);
    }

    private static void setValidationProbeEvent(IpConnectivityLogClass.IpConnectivityEvent out, ValidationProbeEvent in) {
        IpConnectivityLogClass.ValidationProbeEvent validationProbeEvent = new IpConnectivityLogClass.ValidationProbeEvent();
        validationProbeEvent.latencyMs = (int) in.durationMs;
        validationProbeEvent.probeType = in.probeType;
        validationProbeEvent.probeResult = in.returnCode;
        out.setValidationProbeEvent(validationProbeEvent);
    }

    private static void setApfProgramEvent(IpConnectivityLogClass.IpConnectivityEvent out, ApfProgramEvent in) {
        IpConnectivityLogClass.ApfProgramEvent apfProgramEvent = new IpConnectivityLogClass.ApfProgramEvent();
        apfProgramEvent.lifetime = in.lifetime;
        apfProgramEvent.effectiveLifetime = in.actualLifetime;
        apfProgramEvent.filteredRas = in.filteredRas;
        apfProgramEvent.currentRas = in.currentRas;
        apfProgramEvent.programLength = in.programLength;
        if (isBitSet(in.flags, 0) == false) goto L6;
        apfProgramEvent.dropMulticast = true;
    L6:
        if (isBitSet(in.flags, 1) == false) goto L8;
        apfProgramEvent.hasIpv4Addr = true;
    L8:
        out.setApfProgramEvent(apfProgramEvent);
    }

    private static void setApfStats(IpConnectivityLogClass.IpConnectivityEvent out, ApfStats in) {
        IpConnectivityLogClass.ApfStatistics apfStatistics = new IpConnectivityLogClass.ApfStatistics();
        apfStatistics.durationMs = in.durationMs;
        apfStatistics.receivedRas = in.receivedRas;
        apfStatistics.matchingRas = in.matchingRas;
        apfStatistics.droppedRas = in.droppedRas;
        apfStatistics.zeroLifetimeRas = in.zeroLifetimeRas;
        apfStatistics.parseErrors = in.parseErrors;
        apfStatistics.programUpdates = in.programUpdates;
        apfStatistics.programUpdatesAll = in.programUpdatesAll;
        apfStatistics.programUpdatesAllowingMulticast = in.programUpdatesAllowingMulticast;
        apfStatistics.maxProgramSize = in.maxProgramSize;
        out.setApfStatistics(apfStatistics);
    }

    private static void setRaEvent(IpConnectivityLogClass.IpConnectivityEvent out, RaEvent in) {
        IpConnectivityLogClass.RaEvent raEvent = new IpConnectivityLogClass.RaEvent();
        raEvent.routerLifetime = in.routerLifetime;
        raEvent.prefixValidLifetime = in.prefixValidLifetime;
        raEvent.prefixPreferredLifetime = in.prefixPreferredLifetime;
        raEvent.routeInfoLifetime = in.routeInfoLifetime;
        raEvent.rdnssLifetime = in.rdnssLifetime;
        raEvent.dnsslLifetime = in.dnsslLifetime;
        out.setRaEvent(raEvent);
    }

    private static int[] bytesToInts(byte[] in) {
        int[] out = new int[in.length];
        int i = 0;
    L4:
        if (i >= in.length) goto L7;
        out[i] = in[i] & CecDeviceType.INACTIVE;
        i = i + 1;
        goto L4
    L7:
        return out;
    }

    private static IpConnectivityLogClass.Pair[] toPairArray(SparseIntArray counts) {
        int s = counts.size();
        IpConnectivityLogClass.Pair[] pairs = new IpConnectivityLogClass.Pair[s];
        int i = 0;
    L3:
        if (i >= s) goto L6;
        IpConnectivityLogClass.Pair p = new IpConnectivityLogClass.Pair();
        p.key = counts.keyAt(i);
        p.value = counts.valueAt(i);
        pairs[i] = p;
        i = i + 1;
        goto L3
    L6:
        return pairs;
    }

    private static int ipSupportOf(DefaultNetworkEvent in) {
        if (in.ipv4 == false) goto L9;
        if (in.ipv6 == false) goto L9;
        return 3;
    L9:
        if (in.ipv6 == false) goto L13;
        return 2;
    L13:
        if (in.ipv4 == false) goto L16;
        return 1;
    L16:
        return 0;
    }

    private static boolean isBitSet(int flags, int bit) {
        if (((1 << bit) & flags) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    private static void inferLinkLayer(IpConnectivityLogClass.IpConnectivityEvent ev) {
        int linkLayer = 0;
        if (ev.transports == 0) goto L6;
        linkLayer = transportsToLinkLayer(ev.transports);
    L8:
        if (linkLayer != 0) goto L10;
        return;
    L10:
        ev.linkLayer = linkLayer;
        ev.ifName = "";
        return;
    L6:
        if (ev.ifName == null) goto L8;
        linkLayer = ifnameToLinkLayer(ev.ifName);
        goto L8
    }

    private static int transportsToLinkLayer(long transports) {
        switch(Long.bitCount(transports)) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        return 6;
    L6:
        int t = Long.numberOfTrailingZeros(transports);
        return TRANSPORT_LINKLAYER_MAP.get(t, 0);
    L8:
        return 0;
    }

    static {
        TRANSPORT_LINKLAYER_MAP = new SparseIntArray();
        TRANSPORT_LINKLAYER_MAP.append(0, 2);
        TRANSPORT_LINKLAYER_MAP.append(1, 4);
        TRANSPORT_LINKLAYER_MAP.append(2, 1);
        TRANSPORT_LINKLAYER_MAP.append(3, 3);
        TRANSPORT_LINKLAYER_MAP.append(4, 0);
        TRANSPORT_LINKLAYER_MAP.append(5, 8);
        TRANSPORT_LINKLAYER_MAP.append(6, 9);
        IFNAME_PREFIXES = new String[7];
        IFNAME_LINKLAYERS = new int[7];
        IFNAME_PREFIXES[0] = "rmnet";
        IFNAME_LINKLAYERS[0] = 2;
        IFNAME_PREFIXES[1] = "wlan";
        IFNAME_LINKLAYERS[1] = 4;
        IFNAME_PREFIXES[2] = "bt-pan";
        IFNAME_LINKLAYERS[2] = 1;
        IFNAME_PREFIXES[3] = "p2p";
        IFNAME_LINKLAYERS[3] = 7;
        IFNAME_PREFIXES[4] = "aware";
        IFNAME_LINKLAYERS[4] = 8;
        IFNAME_PREFIXES[5] = "eth";
        IFNAME_LINKLAYERS[5] = 3;
        IFNAME_PREFIXES[6] = "wpan";
        IFNAME_LINKLAYERS[6] = 9;
    }

    private static int ifnameToLinkLayer(String ifname) {
        int i = 0;
    L4:
        if (i >= 7) goto L10;
        String pattern = IFNAME_PREFIXES[i];
        if (ifname.startsWith(pattern) == true) goto L8;
        i = i + 1;
        goto L4
    L8:
        return IFNAME_LINKLAYERS[i];
    L10:
        return 0;
    }
}
