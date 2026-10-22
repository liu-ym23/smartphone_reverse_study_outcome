package com.android.server.connectivity;

import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.metrics.DefaultNetworkEvent;
import android.os.SystemClock;
import com.android.internal.util.BitUtils;
import com.android.internal.util.RingBuffer;
import com.android.server.connectivity.metrics.nano.IpConnectivityLogClass;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DefaultNetworkMetrics {
    private static final int ROLLING_LOG_SIZE = 64;
    public final long creationTimeMs;
    private DefaultNetworkEvent mCurrentDefaultNetwork;
    private final List<DefaultNetworkEvent> mEvents;
    private final RingBuffer<DefaultNetworkEvent> mEventsLog;
    private boolean mIsCurrentlyValid;
    private int mLastTransports;
    private long mLastValidationTimeMs;

    public DefaultNetworkMetrics() {
        this.creationTimeMs = SystemClock.elapsedRealtime();
        this.mEvents = new ArrayList();
        this.mEventsLog = new RingBuffer(DefaultNetworkEvent.class, 64);
        newDefaultNetwork(this.creationTimeMs, null, 0, false, null, null);
    }

    public synchronized void listEvents(PrintWriter pw) {
        monitor-enter(this);
        pw.println("default network events:");     // Catch: Throwable -> L6
        long localTimeMs = System.currentTimeMillis();     // Catch: Throwable -> L6
        long timeMs = SystemClock.elapsedRealtime();     // Catch: Throwable -> L6
        DefaultNetworkEvent[] r4 = (DefaultNetworkEvent[]) this.mEventsLog.toArray();     // Catch: Throwable -> L6
        int r5 = r4.length;     // Catch: Throwable -> L6
        int r6 = 0;
    L4:
        if (r6 >= r5) goto L8;
        DefaultNetworkEvent ev = r4[r6];     // Catch: Throwable -> L6
        printEvent(localTimeMs, pw, ev);     // Catch: Throwable -> L6
        r6 = r6 + 1;     // Catch: Throwable -> L6
        goto L4
    L8:
        this.mCurrentDefaultNetwork.updateDuration(timeMs);     // Catch: Throwable -> L6
        if (this.mIsCurrentlyValid == false) goto L11;
        updateValidationTime(timeMs);     // Catch: Throwable -> L6
        this.mLastValidationTimeMs = timeMs;     // Catch: Throwable -> L6
    L11:
        printEvent(localTimeMs, pw, this.mCurrentDefaultNetwork);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized List<IpConnectivityLogClass.IpConnectivityEvent> listEventsAsProto() {
        monitor-enter(this);
        List<IpConnectivityLogClass.IpConnectivityEvent> list = new ArrayList();     // Catch: Throwable -> L7
        DefaultNetworkEvent[] r1 = (DefaultNetworkEvent[]) this.mEventsLog.toArray();     // Catch: Throwable -> L7
        int r2 = r1.length;     // Catch: Throwable -> L7
        int r3 = 0;
    L4:
        if (r3 >= r2) goto L9;
        DefaultNetworkEvent ev = r1[r3];     // Catch: Throwable -> L7
        list.add(IpConnectivityEventBuilder.toProto(ev));     // Catch: Throwable -> L7
        r3 = r3 + 1;
        goto L4
    L9:
        monitor-exit(this);
        return list;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void flushEvents(List<IpConnectivityLogClass.IpConnectivityEvent> out) {
        monitor-enter(this);
        Iterator<DefaultNetworkEvent> r0 = this.mEvents.iterator();     // Catch: Throwable -> L7
    L5:
        if (r0.hasNext() == false) goto L9;
        DefaultNetworkEvent ev = r0.next();     // Catch: Throwable -> L7
        out.add(IpConnectivityEventBuilder.toProto(ev));     // Catch: Throwable -> L7
        goto L5
    L9:
        this.mEvents.clear();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void logDefaultNetworkValidity(long timeMs, boolean isValid) {
        monitor-enter(this);
        if (isValid == false) goto L17;
    L9:
        if (isValid == true) goto L11;
    L15:
        monitor-exit(this);
        return;
    L11:
        if (this.mIsCurrentlyValid == true) goto L15;
        this.mIsCurrentlyValid = true;     // Catch: Throwable -> L7
        this.mLastValidationTimeMs = timeMs;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    L17:
        if (this.mIsCurrentlyValid == false) goto L9;
        this.mIsCurrentlyValid = false;     // Catch: Throwable -> L7
        updateValidationTime(timeMs);     // Catch: Throwable -> L7
        goto L9
    }

    private void updateValidationTime(long timeMs) {
        this.mCurrentDefaultNetwork.validatedMs += timeMs - this.mLastValidationTimeMs;
    }

    public synchronized void logDefaultNetworkEvent(long timeMs, Network defaultNetwork, int score, boolean validated, LinkProperties lp, NetworkCapabilities nc, Network previousDefaultNetwork, int previousScore, LinkProperties previousLp, NetworkCapabilities previousNc) {
        monitor-enter(this);
        logCurrentDefaultNetwork(timeMs, previousDefaultNetwork, previousScore, previousLp, previousNc);     // Catch: Throwable -> L7
        newDefaultNetwork(timeMs, defaultNetwork, score, validated, lp, nc);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void logCurrentDefaultNetwork(long timeMs, Network network, int score, LinkProperties lp, NetworkCapabilities nc) {
        if (this.mIsCurrentlyValid == false) goto L5;
        updateValidationTime(timeMs);
    L5:
        DefaultNetworkEvent ev = this.mCurrentDefaultNetwork;
        ev.updateDuration(timeMs);
        ev.previousTransports = this.mLastTransports;
        if (network == null) goto L9;
        fillLinkInfo(ev, network, lp, nc);
        ev.finalScore = score;
    L9:
        if (ev.transports == 0) goto L11;
        this.mLastTransports = ev.transports;
    L11:
        this.mEvents.add(ev);
        this.mEventsLog.append(ev);
    }

    private void newDefaultNetwork(long timeMs, Network network, int score, boolean validated, LinkProperties lp, NetworkCapabilities nc) {
        DefaultNetworkEvent ev = new DefaultNetworkEvent(timeMs);
        ev.durationMs = timeMs;
        if (network == null) goto L7;
        fillLinkInfo(ev, network, lp, nc);
        ev.initialScore = score;
        if (validated == false) goto L8;
        this.mIsCurrentlyValid = true;
        this.mLastValidationTimeMs = timeMs;
    L8:
        this.mCurrentDefaultNetwork = ev;
        return;
    L7:
        this.mIsCurrentlyValid = false;
        goto L8
    }

    private static void fillLinkInfo(DefaultNetworkEvent ev, Network network, LinkProperties lp, NetworkCapabilities nc) {
        ev.netId = network.getNetId();
        ev.transports = (int) (((long) ev.transports) | BitUtils.packBits(nc.getTransportTypes()));
        boolean r0 = ev.ipv4;
        boolean r2 = false;
        if (lp.hasIpv4Address() == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        ev.ipv4 = r0 | r1;
        boolean r3 = ev.ipv6;
        if (lp.hasGlobalIpv6Address() == true) goto L11;
    L13:
        ev.ipv6 = r3 | r2;
        return;
    L11:
        if (lp.hasIpv6DefaultRoute() == false) goto L13;
        r2 = true;
        goto L13
    L5:
        if (lp.hasIpv4DefaultRoute() == false) goto L7;
        r1 = true;
        goto L8
    }

    private static void printEvent(long localTimeMs, PrintWriter pw, DefaultNetworkEvent ev) {
        long localCreationTimeMs = localTimeMs - ev.durationMs;
        pw.println(String.format("%tT.%tL: %s", new Object[]{Long.valueOf(localCreationTimeMs), Long.valueOf(localCreationTimeMs), ev}));
    }
}
