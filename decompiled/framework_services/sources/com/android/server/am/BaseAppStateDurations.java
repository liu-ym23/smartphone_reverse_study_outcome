package com.android.server.am;

import android.os.SystemClock;
import android.os.UserHandle;
import android.util.TimeUtils;
import com.android.server.am.BaseAppStateTimeEvents.BaseTimeEvent;
import com.android.server.am.compaction.CompactionStatsManager;
import com.android.server.slice.SliceClientPermissions;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
abstract class BaseAppStateDurations<T extends BaseAppStateTimeEvents.BaseTimeEvent> extends BaseAppStateTimeEvents<T> {
    static final boolean DEBUG_BASE_APP_STATE_DURATIONS = false;

    BaseAppStateDurations(int uid, String packageName, int numOfEventTypes, String tag, BaseAppStateEvents.MaxTrackingDurationConfig maxTrackingDurationConfig) {
        super(uid, packageName, numOfEventTypes, tag, maxTrackingDurationConfig);
    }

    BaseAppStateDurations(BaseAppStateDurations other) {
        super(other);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void addEvent(boolean start, T event, int index) {
        if (this.mEvents[index] != null) goto L5;
        this.mEvents[index] = new LinkedList();
    L5:
        LinkedList r0 = this.mEvents[index];
        r0.size();
        boolean active = isActive(index);
        if (start == active) goto L8;
        r0.add(event);
    L8:
        trimEvents(getEarliest(event.getTimestamp()), index);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.android.server.am.BaseAppStateTimeEvents, com.android.server.am.BaseAppStateEvents
    void trimEvents(long earliest, int index) {
        trimEvents(earliest, this.mEvents[index]);
    }

    void trimEvents(long earliest, LinkedList<T> events) {
        if (events != null) goto L5;
        return;
    L5:
        if (events.size() <= 1) goto L15;
        T current = events.peek();
        if (current.getTimestamp() >= earliest) goto L8;
        if (events.get(1).getTimestamp() > earliest) goto L11;
        events.pop();
        events.pop();
        goto L5
    L11:
        events.get(0).trimTo(earliest);
        return;
    L8:
        return;
    L15:
        if (events.size() != 1) goto L21;
        events.get(0).trimTo(Math.max(earliest, events.peek().getTimestamp()));
        return;
    }

    @Override // com.android.server.am.BaseAppStateTimeEvents, com.android.server.am.BaseAppStateEvents
    LinkedList<T> add(LinkedList<T> r21, LinkedList<T> r22) {
        if (r22 != null) goto L4;
    L67:
        return r21;
    L4:
        if (r22.size() == 0) goto L67;
        if (r21 == null) goto L66;
        if (r21.size() == 0) goto L66;
        Iterator<T> r0 = r21.iterator();
        Iterator<T> r1 = r22.iterator();
        T r2 = r0.next();
        T r3 = r1.next();
        CompactionStatsManager.AnonymousClass2 r4 = (LinkedList<T>) new LinkedList();
        boolean r5 = false;
        boolean r6 = false;
        long r7 = r2.getTimestamp();
        long r9 = r3.getTimestamp();
    L11:
        long r11 = Long.MAX_VALUE;
        if (r7 == Long.MAX_VALUE) goto L14;
    L17:
        boolean r13 = true;
        if (r5 == true) goto L22;
        if (r6 == true) goto L22;
        boolean r15 = false;
    L24:
        if (r7 != r9) goto L41;
        T r16 = r2;
        if (r5 == true) goto L28;
        boolean r17 = true;
    L29:
        if (r6 == true) goto L31;
        boolean r8 = true;
    L33:
        if (r0.hasNext() == false) goto L35;
        T r10 = r0.next();
        r2 = r10;
        long r18 = r10.getTimestamp();
    L37:
        if (r1.hasNext() == false) goto L39;
        T r12 = r1.next();
        r3 = r12;
        r11 = r12.getTimestamp();
    L39:
        r6 = r8;
        r9 = r11;
        r5 = r17;
        r7 = r18;
    L58:
        if (r5 == true) goto L62;
        if (r6 == true) goto L62;
        r13 = false;
    L62:
        if (r15 == r13) goto L11;
        r4.add((BaseAppStateTimeEvents.BaseTimeEvent) r16.clone());
        goto L11
    L35:
        r18 = Long.MAX_VALUE;
        goto L37
    L31:
        r8 = false;
        goto L33
    L28:
        r17 = false;
        goto L29
    L41:
        if (r7 >= r9) goto L50;
        r16 = r2;
        if (r5 == true) goto L45;
        boolean r19 = true;
    L47:
        if (r0.hasNext() == false) goto L49;
        T r14 = r0.next();
        r2 = r14;
        r11 = r14.getTimestamp();
    L49:
        r7 = r11;
        r5 = r19;
        goto L58
    L45:
        r19 = false;
        goto L47
    L50:
        r16 = r3;
        if (r6 == true) goto L53;
        boolean r110 = true;
    L55:
        if (r1.hasNext() == false) goto L57;
        T r20 = r1.next();
        r3 = r20;
        r11 = r20.getTimestamp();
    L57:
        r9 = r11;
        r6 = r110;
        goto L58
    L53:
        r110 = false;
    L22:
        r15 = true;
        goto L24
    L14:
        if (r9 != Long.MAX_VALUE) goto L17;
        return r4;
    L66:
        return (LinkedList) r22.clone();
    }

    /* JADX WARN: Multi-variable type inference failed */
    void subtract(BaseAppStateDurations otherDurations, int thisIndex, int otherIndex) {
        if (this.mEvents.length > thisIndex) goto L5;
        return;
    L5:
        if (this.mEvents[thisIndex] != null) goto L7;
        return;
    L7:
        if (otherDurations.mEvents.length > otherIndex) goto L9;
        return;
    L9:
        if (otherDurations.mEvents[otherIndex] == null) goto L16;
        this.mEvents[thisIndex] = subtract(this.mEvents[thisIndex], otherDurations.mEvents[otherIndex]);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void subtract(BaseAppStateDurations otherDurations, int otherIndex) {
        if (otherDurations.mEvents.length > otherIndex) goto L5;
        return;
    L5:
        if (otherDurations.mEvents[otherIndex] == null) goto L20;
        int i = 0;
    L9:
        if (i >= this.mEvents.length) goto L15;
        if (this.mEvents[i] == null) goto L13;
        this.mEvents[i] = subtract(this.mEvents[i], otherDurations.mEvents[otherIndex]);
    L13:
        i = i + 1;
        goto L9
    L15:
        return;
    }

    LinkedList<T> subtract(LinkedList<T> r21, LinkedList<T> r22) {
        if (r22 != null) goto L4;
    L62:
        return r21;
    L4:
        if (r22.size() == 0) goto L62;
        if (r21 == null) goto L62;
        if (r21.size() == 0) goto L62;
        Iterator<T> r0 = r21.iterator();
        Iterator<T> r1 = r22.iterator();
        T r2 = r0.next();
        T r3 = r1.next();
        CompactionStatsManager.AnonymousClass2 r4 = (LinkedList<T>) new LinkedList();
        boolean r5 = false;
        boolean r6 = false;
        long r7 = r2.getTimestamp();
        long r9 = r3.getTimestamp();
    L10:
        long r11 = Long.MAX_VALUE;
        if (r7 == Long.MAX_VALUE) goto L13;
    L16:
        boolean r13 = false;
        if (r5 == false) goto L20;
        if (r6 == true) goto L20;
        boolean r15 = true;
    L22:
        if (r7 != r9) goto L39;
        T r16 = r2;
        if (r5 == true) goto L26;
        boolean r17 = true;
    L27:
        if (r6 == true) goto L29;
        boolean r8 = true;
    L31:
        if (r0.hasNext() == false) goto L33;
        T r10 = r0.next();
        r2 = r10;
        long r18 = r10.getTimestamp();
    L35:
        if (r1.hasNext() == false) goto L37;
        T r12 = r1.next();
        r3 = r12;
        r11 = r12.getTimestamp();
    L37:
        r6 = r8;
        r9 = r11;
        r5 = r17;
        r7 = r18;
    L56:
        if (r5 == false) goto L59;
        if (r6 == true) goto L59;
        r13 = true;
    L59:
        if (r15 == r13) goto L10;
        r4.add((BaseAppStateTimeEvents.BaseTimeEvent) r16.clone());
        goto L10
    L33:
        r18 = Long.MAX_VALUE;
        goto L35
    L29:
        r8 = false;
        goto L31
    L26:
        r17 = false;
        goto L27
    L39:
        if (r7 >= r9) goto L48;
        r16 = r2;
        if (r5 == true) goto L43;
        boolean r19 = true;
    L45:
        if (r0.hasNext() == false) goto L47;
        T r14 = r0.next();
        r2 = r14;
        r11 = r14.getTimestamp();
    L47:
        r7 = r11;
        r5 = r19;
        goto L56
    L43:
        r19 = false;
        goto L45
    L48:
        r16 = r3;
        if (r6 == true) goto L51;
        boolean r110 = true;
    L53:
        if (r1.hasNext() == false) goto L55;
        T r20 = r1.next();
        r3 = r20;
        r11 = r20.getTimestamp();
    L55:
        r9 = r11;
        r6 = r110;
        goto L56
    L51:
        r110 = false;
    L20:
        r15 = false;
        goto L22
    L13:
        if (r9 != Long.MAX_VALUE) goto L16;
        return r4;
    }

    long getTotalDurations(long now, int index) {
        return getTotalDurationsSince(getEarliest(0), now, index);
    }

    long getTotalDurationsSince(long since, long now, int index) {
        LinkedList r3 = this.mEvents[index];
        if (r3 != null) goto L5;
    L24:
        return 0;
    L5:
        if (r3.size() == 0) goto L24;
        boolean active = true;
        long last = 0;
        long duration = 0;
        Iterator r11 = r3.iterator();
    L8:
        boolean r13 = true;
        if (r11.hasNext() == false) goto L21;
        BaseAppStateTimeEvents.BaseTimeEvent r12 = (BaseAppStateTimeEvents.BaseTimeEvent) r11.next();
        if (r12.getTimestamp() < since) goto L15;
        if (active == true) goto L15;
        duration = duration + Math.max(0, r12.getTimestamp() - Math.max(last, since));
    L16:
        if (active == false) goto L19;
        r13 = false;
    L19:
        active = r13;
    L15:
        last = r12.getTimestamp();
        goto L16
    L21:
        if ((r3.size() & 1) == 1) goto L23;
        return duration;
    L23:
        return duration + Math.max(0, now - Math.max(last, since));
    }

    boolean isActive(int index) {
        if (this.mEvents[index] != null) goto L5;
    L7:
        return false;
    L5:
        if ((this.mEvents[index].size() & 1) != 1) goto L7;
        return true;
    }

    @Override // com.android.server.am.BaseAppStateEvents
    String formatEventSummary(long now, int index) {
        return TimeUtils.formatDuration(getTotalDurations(now, index));
    }

    @Override // com.android.server.am.BaseAppStateEvents
    public String toString() {
        return this.mPackageName + SliceClientPermissions.SliceAuthority.DELIMITER + UserHandle.formatUid(this.mUid) + " isActive[0]=" + isActive(0) + " totalDurations[0]=" + getTotalDurations(SystemClock.elapsedRealtime(), 0);
    }
}
