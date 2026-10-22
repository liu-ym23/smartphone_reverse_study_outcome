package com.ttnet.org.chromium.net;

import android.net.TrafficStats;
import android.os.Process;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes4.dex */
@JNINamespace("net::android::traffic_stats")
public class AndroidTrafficStats {
    @CalledByNative
    private static long getCurrentUidRxBytes() {
        long r10 = TrafficStats.getUidRxBytes(Process.myUid());
        if (r10 != (-1)) goto L7;
        return 0;
    L7:
        return r10;
    }

    @CalledByNative
    private static long getCurrentUidTxBytes() {
        long r10 = TrafficStats.getUidTxBytes(Process.myUid());
        if (r10 != (-1)) goto L7;
        return 0;
    L7:
        return r10;
    }

    @CalledByNative
    private static long getTotalRxBytes() {
        long r10 = TrafficStats.getTotalRxBytes();
        if (r10 != (-1)) goto L7;
        return 0;
    L7:
        return r10;
    }

    @CalledByNative
    private static long getTotalTxBytes() {
        long r10 = TrafficStats.getTotalTxBytes();
        if (r10 != (-1)) goto L7;
        return 0;
    L7:
        return r10;
    }
}
