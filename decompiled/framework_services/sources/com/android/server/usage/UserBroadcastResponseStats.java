package com.android.server.usage;

import android.app.usage.BroadcastResponseStats;
import android.util.ArrayMap;
import com.android.internal.util.IndentingPrintWriter;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class UserBroadcastResponseStats {
    private ArrayMap<BroadcastEvent, BroadcastResponseStats> mResponseStats;

    UserBroadcastResponseStats() {
        this.mResponseStats = new ArrayMap();
    }

    BroadcastResponseStats getBroadcastResponseStats(BroadcastEvent broadcastEvent) {
        return this.mResponseStats.get(broadcastEvent);
    }

    BroadcastResponseStats getOrCreateBroadcastResponseStats(BroadcastEvent broadcastEvent) {
        BroadcastResponseStats responseStats = this.mResponseStats.get(broadcastEvent);
        if (responseStats != null) goto L6;
        BroadcastResponseStats responseStats2 = new BroadcastResponseStats(broadcastEvent.getTargetPackage(), broadcastEvent.getIdForResponseEvent());
        this.mResponseStats.put(broadcastEvent, responseStats2);
        return responseStats2;
    L6:
        return responseStats;
    }

    void populateAllBroadcastResponseStats(List<BroadcastResponseStats> broadcastResponseStatsList, String packageName, long id) {
        int i = this.mResponseStats.size() - 1;
    L3:
        if (i < 0) goto L16;
        BroadcastEvent broadcastEvent = this.mResponseStats.keyAt(i);
        if (id != 0) goto L7;
    L9:
        if (packageName != null) goto L11;
    L13:
        broadcastResponseStatsList.add(this.mResponseStats.valueAt(i));
    L14:
        i = i - 1;
        goto L3
    L11:
        if (packageName.equals(broadcastEvent.getTargetPackage()) == true) goto L13;
    L7:
        if (id == broadcastEvent.getIdForResponseEvent()) goto L9;
    }

    void clearBroadcastResponseStats(String packageName, long id) {
        int i = this.mResponseStats.size() - 1;
    L3:
        if (i < 0) goto L16;
        BroadcastEvent broadcastEvent = this.mResponseStats.keyAt(i);
        if (id != 0) goto L7;
    L9:
        if (packageName != null) goto L11;
    L13:
        this.mResponseStats.removeAt(i);
    L14:
        i = i - 1;
        goto L3
    L11:
        if (packageName.equals(broadcastEvent.getTargetPackage()) == true) goto L13;
    L7:
        if (id == broadcastEvent.getIdForResponseEvent()) goto L9;
    }

    void onPackageRemoved(String packageName) {
        int i = this.mResponseStats.size() - 1;
    L3:
        if (i < 0) goto L9;
        if (this.mResponseStats.keyAt(i).getTargetPackage().equals(packageName) == false) goto L7;
        this.mResponseStats.removeAt(i);
    L7:
        i = i - 1;
        goto L3
    }

    void dump(IndentingPrintWriter ipw) {
        int i = 0;
    L4:
        if (i >= this.mResponseStats.size()) goto L7;
        BroadcastEvent broadcastEvent = this.mResponseStats.keyAt(i);
        BroadcastResponseStats responseStats = this.mResponseStats.valueAt(i);
        ipw.print(broadcastEvent);
        ipw.print(" -> ");
        ipw.println(responseStats);
        i = i + 1;
        goto L4
    }
}
