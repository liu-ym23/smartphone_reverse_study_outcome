package com.byted.cast.common.network;

import com.byted.cast.common.ContextManager;
import com.byted.cast.common.NetworkUtil;

/* JADX INFO: loaded from: classes39.dex */
public class NetworkMonitor implements Comparable<NetworkMonitor> {
    public static final int PRIORITY_DEFAULT = 100;
    public static final int PRIORITY_SERVER_PROXY = 200;
    public static final int PRIORITY_SINK_QR_PIN = 300;
    private ContextManager.CastContext mCastContext;
    private int mMonitorType;
    private INetworkChangeListener mNetworkChangeLis;
    private int mPriority;

    public interface INetworkChangeListener {
        void onAvailable(NetworkUtil.NetworkType r100, NetworkUtil.NetworkType r101);

        void onLost(NetworkUtil.NetworkType r100);
    }

    public NetworkMonitor() {
    }

    public int hashCode() {
        ContextManager.CastContext r100 = this.mCastContext;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode() << (this.mMonitorType + 16);
    }

    public ContextManager.CastContext getCastContext() {
        return this.mCastContext;
    }

    public int getMonitorType() {
        return this.mMonitorType;
    }

    public INetworkChangeListener getNetworkChangeListener() {
        return this.mNetworkChangeLis;
    }

    public void start() {
        NetworkManager.appendMonitor(this);
    }

    public void stop() {
        NetworkManager.removeMonitor(this);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(NetworkMonitor r100) {
        return Integer.compare(this.mPriority, r100.mPriority);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof NetworkMonitor) == true) goto L5;
        return false;
    L5:
        NetworkMonitor r101 = (NetworkMonitor) r100;
        if (this.mCastContext == null) goto L8;
    L9:
        ContextManager.CastContext r102 = this.mCastContext;
        if (r102 == null) goto L15;
        if (r102.equals(r101.getCastContext()) == true) goto L15;
    L13:
        return false;
    L15:
        if (this.mMonitorType == r101.getMonitorType()) goto L17;
        return false;
    L17:
        INetworkChangeListener r103 = this.mNetworkChangeLis;
        if (r103 != null) goto L20;
        return false;
    L20:
        if (r103.equals(r101.getNetworkChangeListener()) == false) goto L24;
        return true;
    L24:
        return false;
    L8:
        if (r101.getCastContext() != null) goto L13;
        goto L9
    }

    public void setCastContext(ContextManager.CastContext r100) {
        this.mCastContext = r100;
    }

    public void setMonitorType(int r100) {
        this.mMonitorType = r100;
    }

    public void setNetworkChangeLis(INetworkChangeListener r100) {
        this.mNetworkChangeLis = r100;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(NetworkMonitor r100) {
        return compareTo2(r100);
    }

    public NetworkMonitor(ContextManager.CastContext r100, int r101, INetworkChangeListener r102) {
        this(r100, r101, 100, r102);
    }

    public NetworkMonitor(ContextManager.CastContext r100, int r101, int r102, INetworkChangeListener r103) {
        this.mCastContext = r100;
        this.mMonitorType = r101;
        this.mNetworkChangeLis = r103;
        this.mPriority = r102;
    }
}
