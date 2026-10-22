package com.android.server.am;

import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
class BaseAppStateTimeSlotEvents extends BaseAppStateEvents<Integer> {
    static final boolean DEBUG_BASE_APP_TIME_SLOT_EVENTS = false;
    long[] mCurSlotStartTime;
    final long mTimeSlotSize;

    BaseAppStateTimeSlotEvents(int uid, String packageName, int numOfEventTypes, long timeslotSize, String tag, BaseAppStateEvents.MaxTrackingDurationConfig maxTrackingDurationConfig) {
        super(uid, packageName, numOfEventTypes, tag, maxTrackingDurationConfig);
        this.mTimeSlotSize = timeslotSize;
        this.mCurSlotStartTime = new long[numOfEventTypes];
    }

    BaseAppStateTimeSlotEvents(BaseAppStateTimeSlotEvents other) {
        super(other);
        this.mTimeSlotSize = other.mTimeSlotSize;
        this.mCurSlotStartTime = new long[other.mCurSlotStartTime.length];
        int i = 0;
    L4:
        if (i >= this.mCurSlotStartTime.length) goto L7;
        this.mCurSlotStartTime[i] = other.mCurSlotStartTime[i];
        i = i + 1;
        goto L4
    }

    @Override // com.android.server.am.BaseAppStateEvents
    LinkedList<Integer> add(LinkedList<Integer> events, LinkedList<Integer> otherEvents) {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.android.server.am.BaseAppStateEvents
    void add(BaseAppStateEvents otherObj) {
        if (otherObj != null) goto L5;
        return;
    L5:
        if ((otherObj instanceof BaseAppStateTimeSlotEvents) == false) goto L57;
        BaseAppStateTimeSlotEvents other = (BaseAppStateTimeSlotEvents) otherObj;
        if (this.mEvents.length == other.mEvents.length) goto L10;
        return;
    L10:
        int i = 0;
    L12:
        if (i >= this.mEvents.length) goto L46;
        LinkedList r4 = other.mEvents[i];
        if (r4 == null) goto L44;
        if (r4.size() == 0) goto L44;
        LinkedList r5 = this.mEvents[i];
        if (r5 == null) goto L43;
        if (r5.size() == 0) goto L43;
        LinkedList<Integer> dest = new LinkedList();
        Iterator<Integer> itl = r5.iterator();
        Iterator<Integer> itr = r4.iterator();
        long maxl = this.mCurSlotStartTime[i];
        long maxr = other.mCurSlotStartTime[i];
        long minl = maxl - (this.mTimeSlotSize * ((long) (r5.size() - 1)));
        long minr = maxr - (((long) (r4.size() - 1)) * this.mTimeSlotSize);
        long latest = Math.max(maxl, maxr);
        long earliest = Math.min(minl, minr);
        long start = earliest;
    L25:
        if (start > latest) goto L38;
        int r24 = 0;
        if (start >= minl) goto L29;
    L31:
        int r15 = 0;
    L33:
        if (start < minr) goto L37;
        if (start > maxr) goto L37;
        r24 = itr.next().intValue();
    L37:
        dest.add(Integer.valueOf(r15 + r24));
        start = start + this.mTimeSlotSize;
        r5 = r5;
        dest = dest;
        goto L25
    L29:
        if (start > maxl) goto L31;
        r15 = itl.next().intValue();
        goto L33
    L38:
        this.mEvents[i] = dest;
        if (maxl >= maxr) goto L41;
        this.mCurSlotStartTime[i] = other.mCurSlotStartTime[i];
    L41:
        trimEvents(getEarliest(this.mCurSlotStartTime[i]), i);
    L43:
        this.mEvents[i] = new LinkedList(r4);
        this.mCurSlotStartTime[i] = other.mCurSlotStartTime[i];
    L44:
        i = i + 1;
        goto L12
    L46:
        return;
    }

    @Override // com.android.server.am.BaseAppStateEvents
    int getTotalEventsSince(long since, long now, int index) {
        LinkedList r0 = this.mEvents[index];
        if (r0 == null) goto L21;
        if (r0.size() == 0) goto L21;
        long start = getSlotStartTime(since);
        if (start <= this.mCurSlotStartTime[index]) goto L10;
        return 0;
    L10:
        long end = Math.min(getSlotStartTime(now), this.mCurSlotStartTime[index]);
        Iterator<Integer> it = r0.descendingIterator();
        int count = 0;
        long time = this.mCurSlotStartTime[index];
    L12:
        if (time < start) goto L19;
        if (it.hasNext() == false) goto L19;
        int val = it.next().intValue();
        if (time > end) goto L18;
        count = count + val;
    L18:
        time = time - this.mTimeSlotSize;
    L19:
        return count;
    L21:
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void addEvent(long now, int index) {
        long slot = getSlotStartTime(now);
        LinkedList r2 = this.mEvents[index];
        if (r2 != null) goto L6;
        r2 = new LinkedList();
        this.mEvents[index] = r2;
    L6:
        if (r2.size() != 0) goto L8;
        r2.add(1);
    L13:
        this.mCurSlotStartTime[index] = slot;
        trimEvents(getEarliest(now), index);
        return;
    L8:
        long start = this.mCurSlotStartTime[index];
    L10:
        if (start >= slot) goto L12;
        r2.add(0);
        start = start + this.mTimeSlotSize;
        goto L10
    L12:
        r2.offerLast(Integer.valueOf(((Integer) r2.pollLast()).intValue() + 1));
        goto L13
    }

    @Override // com.android.server.am.BaseAppStateEvents
    void trimEvents(long earliest, int index) {
        LinkedList r0 = this.mEvents[index];
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() == 0) goto L18;
        long slot = getSlotStartTime(earliest);
        long time = this.mCurSlotStartTime[index] - (this.mTimeSlotSize * ((long) (r0.size() - 1)));
    L9:
        if (time >= slot) goto L13;
        if (r0.size() <= 0) goto L17;
        r0.pop();
        time = time + this.mTimeSlotSize;
        goto L9
    L17:
        return;
    L13:
        return;
    }

    long getSlotStartTime(long timestamp) {
        return timestamp - (timestamp % this.mTimeSlotSize);
    }

    long getCurrentSlotStartTime(int index) {
        return this.mCurSlotStartTime[index];
    }
}
