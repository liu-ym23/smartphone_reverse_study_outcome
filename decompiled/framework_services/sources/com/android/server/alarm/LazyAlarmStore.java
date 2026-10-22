package com.android.server.alarm;

import android.util.IndentingPrintWriter;
import android.util.proto.ProtoOutputStream;
import com.android.internal.util.jobs.StatLogger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public class LazyAlarmStore implements AlarmStore {
    private static final long ALARM_DEADLINE_SLOP = 500;
    static final String TAG = null;
    private static final Comparator<Alarm> sDecreasingTimeOrder = null;
    private final ArrayList<Alarm> mAlarms;
    private Runnable mOnAlarmClockRemoved;
    final StatLogger mStatLogger;

    interface Stats {
        public static final int GET_COUNT = 2;
        public static final int GET_NEXT_DELIVERY_TIME = 0;
        public static final int GET_NEXT_WAKEUP_DELIVERY_TIME = 1;
    }

    public LazyAlarmStore() {
        this.mAlarms = new ArrayList();
        this.mStatLogger = new StatLogger(TAG + " stats", new String[]{"GET_NEXT_DELIVERY_TIME", "GET_NEXT_WAKEUP_DELIVERY_TIME", "GET_COUNT"});
    }

    static {
        TAG = LazyAlarmStore.class.getSimpleName();
        sDecreasingTimeOrder = Comparator.comparingLong(new LazyAlarmStore$$ExternalSyntheticLambda0()).reversed();
    }

    @Override // com.android.server.alarm.AlarmStore
    public void add(Alarm a) {
        int index = Collections.binarySearch(this.mAlarms, a, sDecreasingTimeOrder);
        if (index >= 0) goto L5;
        index = (0 - index) - 1;
    L5:
        this.mAlarms.add(index, a);
    }

    @Override // com.android.server.alarm.AlarmStore
    public void addAll(ArrayList<Alarm> alarms) {
        if (alarms != null) goto L4;
        return;
    L4:
        this.mAlarms.addAll(alarms);
        Collections.sort(this.mAlarms, sDecreasingTimeOrder);
    }

    @Override // com.android.server.alarm.AlarmStore
    public ArrayList<Alarm> remove(Predicate<Alarm> whichAlarms) {
        ArrayList<Alarm> removedAlarms = new ArrayList();
        int i = this.mAlarms.size() - 1;
    L3:
        if (i < 0) goto L14;
        if (whichAlarms.test(this.mAlarms.get(i)) == false) goto L12;
        Alarm removed = this.mAlarms.remove(i);
        if (removed.alarmClock != null) goto L9;
    L11:
        removedAlarms.add(removed);
        goto L12
    L9:
        if (this.mOnAlarmClockRemoved == null) goto L11;
        this.mOnAlarmClockRemoved.run();
    L12:
        i = i - 1;
        goto L3
    L14:
        return removedAlarms;
    }

    @Override // com.android.server.alarm.AlarmStore
    public void setAlarmClockRemovalListener(Runnable listener) {
        this.mOnAlarmClockRemoved = listener;
    }

    @Override // com.android.server.alarm.AlarmStore
    public Alarm getNextWakeFromIdleAlarm() {
        int i = this.mAlarms.size() - 1;
    L3:
        if (i < 0) goto L8;
        Alarm alarm = this.mAlarms.get(i);
        if ((alarm.flags & 2) != 0) goto L6;
        i = i - 1;
        goto L3
    L6:
        return alarm;
    L8:
        return null;
    }

    @Override // com.android.server.alarm.AlarmStore
    public int size() {
        return this.mAlarms.size();
    }

    @Override // com.android.server.alarm.AlarmStore
    public long getNextWakeupDeliveryTime() {
        long start = this.mStatLogger.getTime();
        long nextWakeup = 0;
        int i = this.mAlarms.size() - 1;
    L3:
        if (i < 0) goto L15;
        Alarm a = this.mAlarms.get(i);
        if (a.wakeup == false) goto L14;
        if (nextWakeup != 0) goto L11;
        nextWakeup = a.getMaxWhenElapsed();
        goto L14
    L11:
        if (a.getWhenElapsed() > nextWakeup) goto L15;
        nextWakeup = Math.min(nextWakeup, a.getMaxWhenElapsed());
    L14:
        i = i - 1;
    L15:
        this.mStatLogger.logDurationStat(1, start);
        return nextWakeup;
    }

    @Override // com.android.server.alarm.AlarmStore
    public long getNextDeliveryTime() {
        long start = this.mStatLogger.getTime();
        int n = this.mAlarms.size();
        if (n != 0) goto L6;
        return 0;
    L6:
        long nextDelivery = this.mAlarms.get(n - 1).getMaxWhenElapsed();
        int i = n - 2;
    L7:
        if (i < 0) goto L12;
        Alarm a = this.mAlarms.get(i);
        if (a.getWhenElapsed() > nextDelivery) goto L12;
        nextDelivery = Math.min(nextDelivery, a.getMaxWhenElapsed());
        i = i - 1;
    L12:
        this.mStatLogger.logDurationStat(0, start);
        return nextDelivery;
    }

    @Override // com.android.server.alarm.AlarmStore
    public ArrayList<Alarm> removePendingAlarms(long nowElapsed) {
        ArrayList<Alarm> pending = new ArrayList();
        boolean sendWakeups = false;
        boolean standalonesOnly = false;
        int i = this.mAlarms.size() - 1;
    L3:
        if (i < 0) goto L18;
        Alarm alarm = this.mAlarms.get(i);
        if (alarm.getWhenElapsed() > nowElapsed) goto L18;
        this.mAlarms.remove(i);
        pending.add(alarm);
        if (alarm.wakeup == false) goto L15;
        if ((alarm.flags & 1) == 0) goto L12;
    L13:
        sendWakeups = true;
        goto L15
    L12:
        if (alarm.getMaxWhenElapsed() <= (500 + nowElapsed)) goto L13;
    L15:
        if ((alarm.flags & 1) == 0) goto L17;
        standalonesOnly = true;
    L17:
        i = i - 1;
    L18:
        ArrayList<Alarm> toSend = new ArrayList();
        int i2 = pending.size() - 1;
    L19:
        if (i2 < 0) goto L31;
        Alarm pendingAlarm = pending.get(i2);
        if (sendWakeups == false) goto L23;
    L25:
        if (standalonesOnly == true) goto L27;
    L29:
        pending.remove(i2);
        toSend.add(pendingAlarm);
    L30:
        i2 = i2 - 1;
        goto L19
    L27:
        if ((pendingAlarm.flags & 1) != 0) goto L29;
    L23:
        if (pendingAlarm.wakeup == false) goto L25;
    L31:
        addAll(pending);
        return toSend;
    }

    @Override // com.android.server.alarm.AlarmStore
    public boolean updateAlarmDeliveries(AlarmStore.AlarmDeliveryCalculator deliveryCalculator) {
        boolean changed = false;
        Iterator<Alarm> r1 = this.mAlarms.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Alarm alarm = r1.next();
        changed = changed | deliveryCalculator.updateAlarmDelivery(alarm);
        goto L4
    L6:
        if (changed == false) goto L8;
        Collections.sort(this.mAlarms, sDecreasingTimeOrder);
    L8:
        return changed;
    }

    @Override // com.android.server.alarm.AlarmStore
    public ArrayList<Alarm> asList() {
        ArrayList<Alarm> copy = new ArrayList(this.mAlarms);
        Collections.reverse(copy);
        return copy;
    }

    @Override // com.android.server.alarm.AlarmStore
    public void dump(IndentingPrintWriter ipw, long nowElapsed, SimpleDateFormat sdf) {
        ipw.println(this.mAlarms.size() + " pending alarms: ");
        ipw.increaseIndent();
        AlarmManagerService.dumpAlarmList(ipw, this.mAlarms, nowElapsed, sdf);
        ipw.decreaseIndent();
        this.mStatLogger.dump(ipw);
    }

    @Override // com.android.server.alarm.AlarmStore
    public void dumpProto(ProtoOutputStream pos, long nowElapsed) {
        Iterator<Alarm> r0 = this.mAlarms.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Alarm a = r0.next();
        a.dumpDebug(pos, 2246267895850L, nowElapsed);
        goto L4
    }

    @Override // com.android.server.alarm.AlarmStore
    public String getName() {
        return TAG;
    }

    @Override // com.android.server.alarm.AlarmStore
    public int getCount(Predicate<Alarm> condition) {
        long start = this.mStatLogger.getTime();
        int count = 0;
        Iterator<Alarm> r3 = this.mAlarms.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        Alarm a = r3.next();
        if (condition.test(a) == false) goto L4;
        count = count + 1;
        goto L4
    L9:
        this.mStatLogger.logDurationStat(2, start);
        return count;
    }
}
