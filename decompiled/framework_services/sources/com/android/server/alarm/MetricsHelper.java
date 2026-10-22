package com.android.server.alarm;

import android.app.ActivityManager;
import android.app.StatsManager;
import android.content.Context;
import android.os.SystemClock;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.jobs.ConcurrentUtils;
import java.util.List;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
class MetricsHelper {
    private final Context mContext;
    private final Object mLock;

    /* JADX INFO: renamed from: $r8$lambda$-APFzMgZ2OP73GrvFugmJhm4wys, reason: not valid java name */
    public static /* synthetic */ boolean m1046$r8$lambda$APFzMgZ2OP73GrvFugmJhm4wys(Alarm r0) {
        return lambda$registerPuller$10(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$1GoER9qkxWf1P5FzYapvM_RxbOk(Alarm r0) {
        return lambda$registerPuller$11(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$4y91Y8420ZQA3DG9whZj5wxswbk(long r0, Alarm r2) {
        return lambda$registerPuller$8(r0, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$DZKOH7e7jnNUbAvIFuGWW6CbwSg(Alarm r0) {
        return lambda$registerPuller$7(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$DZvMFB7IntTkM0QsHfBpPSnjx8A(Alarm r0) {
        return lambda$registerPuller$9(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$HENNyH9_nyhcjjlGijG4NuYqp-U, reason: not valid java name */
    public static /* synthetic */ boolean m1047$r8$lambda$HENNyH9_nyhcjjlGijG4NuYqpU(Alarm r0) {
        return lambda$registerPuller$4(r0);
    }

    public static /* synthetic */ int $r8$lambda$Jl4RmvHh53TkP7OmznigXDAlQIc(MetricsHelper r0, Supplier r1, int r2, List r3) {
        return r0.lambda$registerPuller$12(r1, r2, r3);
    }

    public static /* synthetic */ boolean $r8$lambda$KFVaejq7HIrOkrCzotXn7RWgAPI(Alarm r0) {
        return lambda$registerPuller$5(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$RUEzFdpyx6ll9-R9YWn7CDmqV6I, reason: not valid java name */
    public static /* synthetic */ boolean m1048$r8$lambda$RUEzFdpyx6ll9R9YWn7CDmqV6I(Alarm r0) {
        return lambda$registerPuller$2(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$VT9P0MxgEOOoFbwVgJ_Jd-rWWZE, reason: not valid java name */
    public static /* synthetic */ boolean m1049$r8$lambda$VT9P0MxgEOOoFbwVgJ_JdrWWZE(Alarm r0) {
        return lambda$registerPuller$0(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$_y7lA7cWhlb0R6DVJOMnVZd28q4(Alarm r0) {
        return lambda$registerPuller$1(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$xd3B0E1dkSLJejeNxnn2_In4gqo(Alarm r0) {
        return lambda$registerPuller$3(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$xknziif3X5qpXmfS8_07ivDyDHU(Alarm r0) {
        return lambda$registerPuller$6(r0);
    }

    MetricsHelper(Context context, Object lock) {
        this.mContext = context;
        this.mLock = lock;
    }

    void registerPuller(final Supplier<AlarmStore> alarmStoreSupplier) {
        StatsManager statsManager = (StatsManager) this.mContext.getSystemService(StatsManager.class);
        statsManager.setPullAtomCallback(FrameworkStatsLog.PENDING_ALARM_INFO, null, ConcurrentUtils.DIRECT_EXECUTOR, new MetricsHelper$$ExternalSyntheticLambda0(this, alarmStoreSupplier));
    }

    private /* synthetic */ int lambda$registerPuller$12(Supplier alarmStoreSupplier, int atomTag, List data) {
        if (atomTag != 10106) goto L27;
        final long now = SystemClock.elapsedRealtime();
        Object r4 = this.mLock;
        monitor-enter(r4);
        AlarmStore alarmStore = (AlarmStore) alarmStoreSupplier.get();     // Catch: Throwable -> L22
        Object r18 = r4;
        data.add(FrameworkStatsLog.buildStatsEvent(atomTag, alarmStore.size(), alarmStore.getCount(new MetricsHelper$$ExternalSyntheticLambda1()), alarmStore.getCount(new MetricsHelper$$ExternalSyntheticLambda4()), alarmStore.getCount(new MetricsHelper$$ExternalSyntheticLambda5()), alarmStore.getCount(new MetricsHelper$$ExternalSyntheticLambda6()), alarmStore.getCount(new MetricsHelper$$ExternalSyntheticLambda7()), alarmStore.getCount(new MetricsHelper$$ExternalSyntheticLambda8()), alarmStore.getCount(new MetricsHelper$$ExternalSyntheticLambda9()), alarmStore.getCount(new MetricsHelper$$ExternalSyntheticLambda10()), alarmStore.getCount(new MetricsHelper$$ExternalSyntheticLambda11(now)), alarmStore.getCount(new MetricsHelper$$ExternalSyntheticLambda12()), alarmStore.getCount(new MetricsHelper$$ExternalSyntheticLambda2()), alarmStore.getCount(new MetricsHelper$$ExternalSyntheticLambda3())));     // Catch: Throwable -> L15
        monitor-exit(r18);     // Catch: Throwable -> L15
        return 0;
    L17:
        th = th;
    L24:
        monitor-exit(r18);     // Catch: Throwable -> L15
        throw th;
    L19:
        th = th;
    L21:
        r18 = r4;
    L15:
        th = th;
    L22:
        th = th;
        goto L21
    L27:
        throw new UnsupportedOperationException("Unknown tag" + atomTag);
    }

    private static /* synthetic */ boolean lambda$registerPuller$0(Alarm a) {
        if (a.windowLength != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static /* synthetic */ boolean lambda$registerPuller$1(Alarm a) {
        return a.wakeup;
    }

    private static /* synthetic */ boolean lambda$registerPuller$2(Alarm a) {
        if ((a.flags & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static /* synthetic */ boolean lambda$registerPuller$3(Alarm a) {
        if ((a.flags & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static /* synthetic */ boolean lambda$registerPuller$4(Alarm a) {
        if (a.operation != null) goto L5;
    L7:
        return false;
    L5:
        if (a.operation.isForegroundService() == false) goto L7;
        return true;
    }

    private static /* synthetic */ boolean lambda$registerPuller$5(Alarm a) {
        if (a.operation != null) goto L5;
    L7:
        return false;
    L5:
        if (a.operation.isActivity() == false) goto L7;
        return true;
    }

    private static /* synthetic */ boolean lambda$registerPuller$6(Alarm a) {
        if (a.operation != null) goto L5;
    L7:
        return false;
    L5:
        if (a.operation.isService() == false) goto L7;
        return true;
    }

    private static /* synthetic */ boolean lambda$registerPuller$7(Alarm a) {
        if (a.listener == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static /* synthetic */ boolean lambda$registerPuller$8(long now, Alarm a) {
        if (a.getRequestedElapsed() <= (31536000000L + now)) goto L5;
        return true;
    L5:
        return false;
    }

    private static /* synthetic */ boolean lambda$registerPuller$9(Alarm a) {
        if (a.repeatInterval == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static /* synthetic */ boolean lambda$registerPuller$10(Alarm a) {
        if (a.alarmClock == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static /* synthetic */ boolean lambda$registerPuller$11(Alarm a) {
        return AlarmManagerService.isRtc(a.type);
    }

    private static int reasonToStatsReason(int reasonCode) {
        switch(reasonCode) {
            case 0: goto L15;
            case 1: goto L13;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L7;
            case 5: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 6;
    L7:
        return 5;
    L9:
        return 4;
    L11:
        return 3;
    L13:
        return 2;
    L15:
        return 1;
    }

    static void pushAlarmScheduled(Alarm a, int callerProcState) {
        int r1 = a.uid;
        boolean r2 = false;
        if (a.windowLength != 0) goto L6;
        r2 = true;
    L6:
        boolean r6 = true;
        boolean r3 = a.wakeup;
        if ((a.flags & 4) == 0) goto L9;
        boolean r4 = true;
    L11:
        if (a.alarmClock == null) goto L13;
        boolean r5 = true;
    L15:
        if (a.repeatInterval != 0) goto L18;
        r6 = false;
    L18:
        FrameworkStatsLog.write(FrameworkStatsLog.ALARM_SCHEDULED, r1, r2, r3, r4, r5, r6, reasonToStatsReason(a.exactAllowReason), AlarmManagerService.isRtc(a.type), ActivityManager.processStateAmToProto(callerProcState));
        return;
    L13:
        r5 = r2;
        goto L15
    L9:
        r4 = r2;
        goto L11
    }

    static void pushAlarmBatchDelivered(int numAlarms, int wakeups, int[] uids, int[] alarmsPerUid, int[] wakeupAlarmsPerUid) {
        FrameworkStatsLog.write(FrameworkStatsLog.ALARM_BATCH_DELIVERED, numAlarms, wakeups, uids, alarmsPerUid, wakeupAlarmsPerUid);
    }
}
