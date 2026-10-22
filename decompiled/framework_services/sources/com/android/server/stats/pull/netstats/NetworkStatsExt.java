package com.android.server.stats.pull.netstats;

import android.net.NetworkStats;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkStatsExt {
    public final boolean isTypeProxy;
    public final int oemManaged;
    public final int ratType;
    public final boolean slicedByFgbg;
    public final boolean slicedByMetered;
    public final boolean slicedByTag;
    public final NetworkStats stats;
    public final SubInfo subInfo;
    public final int[] transports;

    public NetworkStatsExt(NetworkStats stats, int[] transports, boolean slicedByFgbg) {
        this(stats, transports, slicedByFgbg, false, false, 0, null, -1, false);
    }

    public NetworkStatsExt(NetworkStats stats, int[] transports, boolean slicedByFgbg, boolean slicedByTag, boolean slicedByMetered, int ratType, SubInfo subInfo, int oemManaged, boolean isTypeProxy) {
        this.stats = stats;
        this.transports = Arrays.copyOf(transports, transports.length);
        Arrays.sort(this.transports);
        this.slicedByFgbg = slicedByFgbg;
        this.slicedByTag = slicedByTag;
        this.slicedByMetered = slicedByMetered;
        this.ratType = ratType;
        this.subInfo = subInfo;
        this.oemManaged = oemManaged;
        this.isTypeProxy = isTypeProxy;
    }

    public boolean hasSameSlicing(NetworkStatsExt other) {
        if (Arrays.equals(this.transports, other.transports) == true) goto L5;
    L19:
        return false;
    L5:
        if (this.slicedByFgbg != other.slicedByFgbg) goto L19;
        if (this.slicedByTag != other.slicedByTag) goto L19;
        if (this.slicedByMetered != other.slicedByMetered) goto L19;
        if (this.ratType != other.ratType) goto L19;
        if (Objects.equals(this.subInfo, other.subInfo) == false) goto L19;
        if (this.oemManaged != other.oemManaged) goto L19;
        if (this.isTypeProxy != other.isTypeProxy) goto L19;
        return true;
    }
}
