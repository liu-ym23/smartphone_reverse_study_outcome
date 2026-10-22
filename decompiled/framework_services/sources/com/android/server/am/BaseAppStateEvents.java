package com.android.server.am;

import android.os.SystemClock;
import android.os.UserHandle;
import com.android.server.slice.SliceClientPermissions;
import java.io.PrintWriter;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
abstract class BaseAppStateEvents<E> {
    static final boolean DEBUG_BASE_APP_STATE_EVENTS = false;
    final LinkedList<E>[] mEvents;
    int mExemptReason;
    final MaxTrackingDurationConfig mMaxTrackingDurationConfig;
    final String mPackageName;
    final String mTag;
    final int mUid;

    interface Factory<T extends BaseAppStateEvents> {
        T createAppStateEvents(int r1, String r2);

        T createAppStateEvents(T r1);
    }

    interface MaxTrackingDurationConfig {
        long getMaxTrackingDuration();
    }

    abstract LinkedList<E> add(LinkedList<E> r1, LinkedList<E> r2);

    abstract int getTotalEventsSince(long r1, long r3, int r5);

    abstract void trimEvents(long r1, int r3);

    BaseAppStateEvents(int uid, String packageName, int numOfEventTypes, String tag, MaxTrackingDurationConfig maxTrackingDurationConfig) {
        this.mExemptReason = -1;
        this.mUid = uid;
        this.mPackageName = packageName;
        this.mTag = tag;
        this.mMaxTrackingDurationConfig = maxTrackingDurationConfig;
        this.mEvents = new LinkedList[numOfEventTypes];
    }

    BaseAppStateEvents(BaseAppStateEvents other) {
        this.mExemptReason = -1;
        this.mUid = other.mUid;
        this.mPackageName = other.mPackageName;
        this.mTag = other.mTag;
        this.mMaxTrackingDurationConfig = other.mMaxTrackingDurationConfig;
        this.mEvents = new LinkedList[other.mEvents.length];
        int i = 0;
    L4:
        if (i >= this.mEvents.length) goto L10;
        if (other.mEvents[i] == null) goto L8;
        this.mEvents[i] = new LinkedList(other.mEvents[i]);
    L8:
        i = i + 1;
        goto L4
    }

    void addEvent(E event, long now, int index) {
        if (this.mEvents[index] != null) goto L5;
        this.mEvents[index] = new LinkedList();
    L5:
        LinkedList<E> events = this.mEvents[index];
        events.add(event);
        trimEvents(getEarliest(now), index);
    }

    void trim(long earliest) {
        int i = 0;
    L4:
        if (i >= this.mEvents.length) goto L7;
        trimEvents(earliest, i);
        i = i + 1;
        goto L4
    }

    boolean isEmpty() {
        int i = 0;
    L4:
        if (i >= this.mEvents.length) goto L12;
        if (this.mEvents[i] == null) goto L11;
        if (this.mEvents[i].isEmpty() == true) goto L11;
        return false;
    L11:
        i = i + 1;
        goto L4
    L12:
        return true;
    }

    boolean isEmpty(int index) {
        if (this.mEvents[index] != null) goto L5;
    L8:
        return true;
    L5:
        if (this.mEvents[index].isEmpty() == true) goto L8;
        return false;
    }

    void add(BaseAppStateEvents other) {
        if (this.mEvents.length == other.mEvents.length) goto L5;
        return;
    L5:
        int i = 0;
    L7:
        if (i >= this.mEvents.length) goto L10;
        this.mEvents[i] = add(this.mEvents[i], other.mEvents[i]);
        i = i + 1;
        goto L7
    }

    LinkedList<E> getRawEvents(int index) {
        return this.mEvents[index];
    }

    int getTotalEvents(long now, int index) {
        return getTotalEventsSince(getEarliest(0), now, index);
    }

    long getEarliest(long now) {
        return Math.max(0, now - this.mMaxTrackingDurationConfig.getMaxTrackingDuration());
    }

    void dump(PrintWriter pw, String prefix, long nowElapsed) {
        int i = 0;
    L4:
        if (i >= this.mEvents.length) goto L11;
        if (this.mEvents[i] == null) goto L9;
        pw.print(prefix);
        pw.print(formatEventTypeLabel(i));
        pw.println(formatEventSummary(nowElapsed, i));
    L9:
        i = i + 1;
        goto L4
    }

    String formatEventSummary(long now, int index) {
        return Integer.toString(getTotalEvents(now, index));
    }

    String formatEventTypeLabel(int index) {
        return Integer.toString(index) + ":";
    }

    public String toString() {
        return this.mPackageName + SliceClientPermissions.SliceAuthority.DELIMITER + UserHandle.formatUid(this.mUid) + " totalEvents[0]=" + formatEventSummary(SystemClock.elapsedRealtime(), 0);
    }
}
