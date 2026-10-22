package com.android.net.module.util;

import android.net.metrics.INetdEventListener;

/* JADX INFO: loaded from: classes.dex */
public class BaseNetdEventListener extends INetdEventListener.Stub {
    public BaseNetdEventListener() {
    }

    @Override // android.net.metrics.INetdEventListener
    public void onDnsEvent(int netId, int eventType, int returnCode, int latencyMs, String hostname, String[] ipAddresses, int ipAddressesCount, int uid) {
    }

    @Override // android.net.metrics.INetdEventListener
    public void onPrivateDnsValidationEvent(int netId, String ipAddress, String hostname, boolean validated) {
    }

    @Override // android.net.metrics.INetdEventListener
    public void onConnectEvent(int netId, int error, int latencyMs, String ipAddr, int port, int uid) {
    }

    @Override // android.net.metrics.INetdEventListener
    public void onWakeupEvent(String prefix, int uid, int ethertype, int ipNextHeader, byte[] dstHw, String srcIp, String dstIp, int srcPort, int dstPort, long timestampNs) {
    }

    @Override // android.net.metrics.INetdEventListener
    public void onTcpSocketStatsEvent(int[] networkIds, int[] sentPackets, int[] lostPackets, int[] rttUs, int[] sentAckDiffMs) {
    }

    @Override // android.net.metrics.INetdEventListener
    public void onNat64PrefixEvent(int netId, boolean added, String prefixString, int prefixLength) {
    }

    @Override // android.net.metrics.INetdEventListener
    public int getInterfaceVersion() {
        return 1;
    }

    @Override // android.net.metrics.INetdEventListener
    public String getInterfaceHash() {
        return INetdEventListener.HASH;
    }
}
