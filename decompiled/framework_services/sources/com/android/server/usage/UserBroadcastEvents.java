package com.android.server.usage;

import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.LongArrayQueue;
import android.util.TimeUtils;
import com.android.internal.util.IndentingPrintWriter;

/* JADX INFO: loaded from: classes3.dex */
class UserBroadcastEvents {
    private ArrayMap<String, ArraySet<BroadcastEvent>> mBroadcastEvents;

    UserBroadcastEvents() {
        this.mBroadcastEvents = new ArrayMap();
    }

    ArraySet<BroadcastEvent> getBroadcastEvents(String packageName) {
        return this.mBroadcastEvents.get(packageName);
    }

    ArraySet<BroadcastEvent> getOrCreateBroadcastEvents(String packageName) {
        ArraySet<BroadcastEvent> broadcastEvents = this.mBroadcastEvents.get(packageName);
        if (broadcastEvents != null) goto L6;
        ArraySet<BroadcastEvent> broadcastEvents2 = new ArraySet();
        this.mBroadcastEvents.put(packageName, broadcastEvents2);
        return broadcastEvents2;
    L6:
        return broadcastEvents;
    }

    void onPackageRemoved(String packageName) {
        this.mBroadcastEvents.remove(packageName);
    }

    void onUidRemoved(int uid) {
        clear(uid);
    }

    void clear(int uid) {
        int i = this.mBroadcastEvents.size() - 1;
    L3:
        if (i < 0) goto L12;
        ArraySet<BroadcastEvent> broadcastEvents = this.mBroadcastEvents.valueAt(i);
        int j = broadcastEvents.size() - 1;
    L5:
        if (j < 0) goto L10;
        if (broadcastEvents.valueAt(j).getSourceUid() != uid) goto L9;
        broadcastEvents.removeAt(j);
    L9:
        j = j - 1;
        goto L5
    L10:
        i = i - 1;
        goto L3
    }

    void dump(IndentingPrintWriter ipw) {
        int i = 0;
    L4:
        if (i >= this.mBroadcastEvents.size()) goto L20;
        String packageName = this.mBroadcastEvents.keyAt(i);
        ArraySet<BroadcastEvent> broadcastEvents = this.mBroadcastEvents.valueAt(i);
        ipw.println(packageName + ":");
        ipw.increaseIndent();
        if (broadcastEvents.size() != 0) goto L8;
        ipw.println("<empty>");
    L18:
        ipw.decreaseIndent();
        i = i + 1;
        goto L4
    L8:
        int j = 0;
    L10:
        if (j >= broadcastEvents.size()) goto L18;
        BroadcastEvent broadcastEvent = broadcastEvents.valueAt(j);
        ipw.println(broadcastEvent);
        ipw.increaseIndent();
        LongArrayQueue timestampsMs = broadcastEvent.getTimestampsMs();
        int timestampIdx = 0;
    L13:
        if (timestampIdx >= timestampsMs.size()) goto L17;
        if (timestampIdx <= 0) goto L16;
        ipw.print(',');
    L16:
        long timestampMs = timestampsMs.get(timestampIdx);
        TimeUtils.formatDuration(timestampMs, ipw);
        timestampIdx = timestampIdx + 1;
        goto L13
    L17:
        ipw.println();
        ipw.decreaseIndent();
        j = j + 1;
        goto L10
    }
}
