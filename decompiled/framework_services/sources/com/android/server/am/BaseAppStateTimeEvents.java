package com.android.server.am;

import com.android.server.am.BaseAppStateTimeEvents.BaseTimeEvent;
import com.android.server.am.compaction.CompactionStatsManager;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
class BaseAppStateTimeEvents<T extends BaseTimeEvent> extends BaseAppStateEvents<T> {

    static class BaseTimeEvent implements Cloneable {
        long mTimestamp;

        BaseTimeEvent(long timestamp) {
            this.mTimestamp = timestamp;
        }

        BaseTimeEvent(BaseTimeEvent other) {
            this.mTimestamp = other.mTimestamp;
        }

        void trimTo(long timestamp) {
            this.mTimestamp = timestamp;
        }

        long getTimestamp() {
            return this.mTimestamp;
        }

        public Object clone() {
            return new BaseTimeEvent(this);
        }

        public boolean equals(Object other) {
            if (other != null) goto L6;
            return false;
        L6:
            if (other.getClass() == BaseTimeEvent.class) goto L9;
            return false;
        L9:
            if (((BaseTimeEvent) other).mTimestamp != this.mTimestamp) goto L12;
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            return Long.hashCode(this.mTimestamp);
        }
    }

    BaseAppStateTimeEvents(int uid, String packageName, int numOfEventTypes, String tag, BaseAppStateEvents.MaxTrackingDurationConfig maxTrackingDurationConfig) {
        super(uid, packageName, numOfEventTypes, tag, maxTrackingDurationConfig);
    }

    BaseAppStateTimeEvents(BaseAppStateTimeEvents other) {
        super(other);
    }

    @Override // com.android.server.am.BaseAppStateEvents
    LinkedList<T> add(LinkedList<T> r14, LinkedList<T> r15) {
        if (r15 != null) goto L4;
    L39:
        return r14;
    L4:
        if (r15.size() == 0) goto L39;
        if (r14 == null) goto L38;
        if (r14.size() == 0) goto L38;
        Iterator<T> r0 = r14.iterator();
        Iterator<T> r1 = r15.iterator();
        T r2 = r0.next();
        T r3 = r1.next();
        CompactionStatsManager.AnonymousClass2 r4 = (LinkedList<T>) new LinkedList();
        long r5 = r2.getTimestamp();
        long r7 = r3.getTimestamp();
    L11:
        long r9 = Long.MAX_VALUE;
        if (r5 != Long.MAX_VALUE) goto L18;
        if (r7 != Long.MAX_VALUE) goto L18;
        return r4;
    L18:
        if (r5 == r7) goto L19;
        if (r5 < r7) goto L29;
        r4.add((BaseTimeEvent) r3.clone());
        if (r1.hasNext() == false) goto L36;
        T r10 = r1.next();
        r3 = r10;
        r9 = r10.getTimestamp();
    L36:
        r7 = r9;
        goto L11
    L29:
        r4.add((BaseTimeEvent) r2.clone());
        if (r0.hasNext() == false) goto L32;
        T r11 = r0.next();
        r2 = r11;
        r9 = r11.getTimestamp();
    L32:
        r5 = r9;
        goto L11
    L19:
        r4.add((BaseTimeEvent) r2.clone());
        if (r0.hasNext() == false) goto L22;
        T r12 = r0.next();
        r2 = r12;
        long r13 = r12.getTimestamp();
    L23:
        r5 = r13;
        if (r1.hasNext() == false) goto L26;
        T r16 = r1.next();
        r3 = r16;
        r9 = r16.getTimestamp();
    L26:
        r7 = r9;
        goto L11
    L22:
        r13 = Long.MAX_VALUE;
    L38:
        return (LinkedList) r15.clone();
    }

    @Override // com.android.server.am.BaseAppStateEvents
    int getTotalEventsSince(long since, long now, int index) {
        LinkedList r0 = this.mEvents[index];
        if (r0 != null) goto L5;
        return 0;
    L5:
        if (r0.size() == 0) goto L22;
        int count = 0;
        Iterator r2 = r0.iterator();
    L9:
        if (r2.hasNext() == false) goto L14;
        if (((BaseTimeEvent) r2.next()).getTimestamp() < since) goto L9;
        count = count + 1;
        goto L9
    L14:
        return count;
    L22:
        return 0;
    }

    @Override // com.android.server.am.BaseAppStateEvents
    void trimEvents(long earliest, int index) {
        LinkedList r0 = this.mEvents[index];
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.size() <= 0) goto L11;
        if (((BaseTimeEvent) r0.peek()).getTimestamp() >= earliest) goto L9;
        r0.pop();
        goto L6
    L9:
        return;
    }
}
