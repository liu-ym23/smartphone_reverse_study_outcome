package com.android.server.stats.pull.netstats;

import android.net.NetworkStats;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkStatsUtils {
    public NetworkStatsUtils() {
    }

    public static NetworkStats fromPublicNetworkStats(android.app.usage.NetworkStats publiceNetworkStats) {
        ArrayList<NetworkStats.Entry> entries = new ArrayList();
    L4:
        if (publiceNetworkStats.hasNextBucket() == false) goto L6;
        android.app.usage.NetworkStats.Bucket bucket = new android.app.usage.NetworkStats.Bucket();
        publiceNetworkStats.getNextBucket(bucket);
        entries.add(fromBucket(bucket));
        goto L4
    L6:
        NetworkStats stats = new NetworkStats(0, 1);
        if (isAddEntriesSupported() == true) goto L13;
        Iterator<NetworkStats.Entry> r2 = entries.iterator();
    L11:
        if (r2.hasNext() == false) goto L16;
        NetworkStats.Entry entry = r2.next();
        stats = stats.addEntry(entry);
        goto L11
    L16:
        return stats;
    L13:
        return stats.addEntries(entries);
    }

    public static NetworkStats.Entry fromBucket(android.app.usage.NetworkStats.Bucket bucket) {
        return new NetworkStats.Entry(null, bucket.getUid(), convertBucketState(bucket.getState()), convertBucketTag(bucket.getTag()), convertBucketMetered(bucket.getMetered()), convertBucketRoaming(bucket.getRoaming()), convertBucketDefaultNetworkStatus(bucket.getDefaultNetworkStatus()), bucket.getRxBytes(), bucket.getRxPackets(), bucket.getTxBytes(), bucket.getTxPackets(), 0);
    }

    private static int convertBucketState(int networkStatsSet) {
        switch(networkStatsSet) {
            case -1: goto L8;
            case 0: goto L4;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L4:
        return 0;
    L5:
        return 1;
    L7:
        return 0;
    L8:
        return -1;
    }

    private static int convertBucketTag(int tag) {
        switch(tag) {
            case 0: goto L4;
            default: goto L3;
        };
    L3:
        return tag;
    L4:
        return 0;
    }

    private static int convertBucketMetered(int metered) {
        switch(metered) {
            case -1: goto L8;
            case 0: goto L4;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L4:
        return 0;
    L5:
        return 1;
    L7:
        return 0;
    L8:
        return -1;
    }

    private static int convertBucketRoaming(int roaming) {
        switch(roaming) {
            case -1: goto L8;
            case 0: goto L4;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L4:
        return 0;
    L5:
        return 1;
    L7:
        return 0;
    L8:
        return -1;
    }

    private static int convertBucketDefaultNetworkStatus(int defaultNetworkStatus) {
        switch(defaultNetworkStatus) {
            case -1: goto L8;
            case 0: goto L4;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L4:
        return 0;
    L5:
        return 1;
    L7:
        return 0;
    L8:
        return -1;
    }

    public static boolean isAddEntriesSupported() {
        return true;
    }
}
