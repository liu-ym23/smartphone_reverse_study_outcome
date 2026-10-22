package com.android.server.usage;

import android.app.ActivityManager;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Slog;
import android.util.TimeUtils;
import com.android.internal.util.IndentingPrintWriter;
import com.android.internal.util.RingBuffer;
import java.util.function.IntFunction;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
public class BroadcastResponseStatsLogger {
    private static final int MAX_LOG_SIZE = 0;
    private final LogBuffer mBroadcastEventsBuffer;
    private final Object mLock;
    private final LogBuffer mNotificationEventsBuffer;

    private static final class BroadcastEvent implements Data {
        public long idForResponseEvent;
        public int sourceUid;
        public String targetPackage;
        public int targetUidProcessState;
        public int targetUserId;
        public long timestampMs;

        /* synthetic */ BroadcastEvent(BroadcastResponseStatsLoggerIA r1) {
            this();
        }

        private BroadcastEvent() {
        }

        @Override // com.android.server.usage.BroadcastResponseStatsLogger.Data
        public void reset() {
            this.targetPackage = null;
        }

        public String toString() {
            return BroadcastResponseStatsLogger.m9094$$Nest$smgetBroadcastDispatchEventLog(this.sourceUid, this.targetPackage, this.targetUserId, this.idForResponseEvent, this.timestampMs, this.targetUidProcessState);
        }
    }

    private interface Data {
        void reset();
    }

    private static final class LogBuffer<T extends Data> extends RingBuffer<T> {
        LogBuffer(Supplier<T> newItem, IntFunction<T[]> newBacking, int capacity) {
            super(newItem, newBacking, capacity);
        }

        void logBroadcastDispatchEvent(int sourceUid, String targetPackage, UserHandle targetUser, long idForResponseEvent, long timeStampMs, int targetUidProcessState) {
            Data data = (Data) getNextSlot();
            if (data != null) goto L5;
            return;
        L5:
            data.reset();
            BroadcastEvent event = (BroadcastEvent) data;
            event.sourceUid = sourceUid;
            event.targetUserId = targetUser.getIdentifier();
            event.targetUidProcessState = targetUidProcessState;
            event.targetPackage = targetPackage;
            event.idForResponseEvent = idForResponseEvent;
            event.timestampMs = timeStampMs;
        }

        void logNotificationEvent(int type, String packageName, UserHandle user, long timestampMs) {
            Data data = (Data) getNextSlot();
            if (data != null) goto L5;
            return;
        L5:
            data.reset();
            NotificationEvent event = (NotificationEvent) data;
            event.type = type;
            event.packageName = packageName;
            event.userId = user.getIdentifier();
            event.timestampMs = timestampMs;
        }

        public void reverseDump(IndentingPrintWriter pw) {
            Data[] allData = (Data[]) toArray();
            int i = allData.length - 1;
        L3:
            if (i < 0) goto L10;
            if (allData[i] == null) goto L8;
            pw.println(getContent(allData[i]));
        L8:
            i = i - 1;
            goto L3
        }

        public String getContent(Data data) {
            return data.toString();
        }
    }

    private static final class NotificationEvent implements Data {
        public String packageName;
        public long timestampMs;
        public int type;
        public int userId;

        /* synthetic */ NotificationEvent(BroadcastResponseStatsLoggerIA r1) {
            this();
        }

        private NotificationEvent() {
        }

        @Override // com.android.server.usage.BroadcastResponseStatsLogger.Data
        public void reset() {
            this.packageName = null;
        }

        public String toString() {
            return BroadcastResponseStatsLogger.m9095$$Nest$smgetNotificationEventLog(this.type, this.packageName, this.userId, this.timestampMs);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$A-r2wcV2w4QjqlPjHFaij6oV5bQ, reason: not valid java name */
    public static /* synthetic */ BroadcastEvent m9092$r8$lambda$Ar2wcV2w4QjqlPjHFaij6oV5bQ() {
        return new BroadcastEvent(null);
    }

    public static /* synthetic */ Object $r8$lambda$W1F85tjQJ7p6e3fOCAIRsqTjcl4(int r0) {
        return lambda$new$0(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$lW8VT65-e47HoACtwf8YZwpc8Xs, reason: not valid java name */
    public static /* synthetic */ NotificationEvent m9093$r8$lambda$lW8VT65e47HoACtwf8YZwpc8Xs() {
        return new NotificationEvent(null);
    }

    public static /* synthetic */ Object $r8$lambda$wkyHpYbAHm1Dorsn7ksUN7TwqCk(int r0) {
        return lambda$new$1(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetBroadcastDispatchEventLog, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m9094$$Nest$smgetBroadcastDispatchEventLog(int r0, String r1, int r2, long r3, long r5, int r7) {
        return getBroadcastDispatchEventLog(r0, r1, r2, r3, r5, r7);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetNotificationEventLog, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m9095$$Nest$smgetNotificationEventLog(int r0, String r1, int r2, long r3) {
        return getNotificationEventLog(r0, r1, r2, r3);
    }

    public BroadcastResponseStatsLogger() {
        this.mLock = new Object();
        this.mBroadcastEventsBuffer = new LogBuffer(new BroadcastResponseStatsLogger$$ExternalSyntheticLambda0(), new BroadcastResponseStatsLogger$$ExternalSyntheticLambda1(), MAX_LOG_SIZE);
        this.mNotificationEventsBuffer = new LogBuffer(new BroadcastResponseStatsLogger$$ExternalSyntheticLambda2(), new BroadcastResponseStatsLogger$$ExternalSyntheticLambda3(), MAX_LOG_SIZE);
    }

    static {
        if (ActivityManager.isLowRamDeviceStatic() == false) goto L5;
        int r0 = 20;
    L6:
        MAX_LOG_SIZE = r0;
        return;
    L5:
        r0 = 50;
        goto L6
    }

    private static /* synthetic */ Object lambda$new$0(int x$0) {
        return new BroadcastEvent[x$0];
    }

    private static /* synthetic */ Object lambda$new$1(int x$0) {
        return new NotificationEvent[x$0];
    }

    void logBroadcastDispatchEvent(int sourceUid, String targetPackage, UserHandle targetUser, long idForResponseEvent, long timeStampMs, int targetUidProcessState) {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (UsageStatsService.DEBUG_RESPONSE_STATS == false) goto L9;
        Slog.d("ResponseStatsTracker", getBroadcastDispatchEventLog(sourceUid, targetPackage, targetUser.getIdentifier(), idForResponseEvent, timeStampMs, targetUidProcessState));     // Catch: Throwable -> L7
    L9:
        this.mBroadcastEventsBuffer.logBroadcastDispatchEvent(sourceUid, targetPackage, targetUser, idForResponseEvent, timeStampMs, targetUidProcessState);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
    }

    void logNotificationEvent(int event, String packageName, UserHandle user, long timestampMs) {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L15:
        th = th;
    L19:
        monitor-exit(r1);     // Catch: Throwable -> L15
        throw th;
    L17:
        th = th;
        goto L19
    L5:
        if (UsageStatsService.DEBUG_RESPONSE_STATS == true) goto L21;
    L10:
        this.mNotificationEventsBuffer.logNotificationEvent(event, packageName, user, timestampMs);     // Catch: Throwable -> L15
        monitor-exit(r1);     // Catch: Throwable -> L15
        return;
    L21:
        Slog.d("ResponseStatsTracker", getNotificationEventLog(event, packageName, user.getIdentifier(), timestampMs));     // Catch: Throwable -> L8
    L8:
        th = th;
        goto L19
    }

    void dumpLogs(IndentingPrintWriter ipw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ipw.println("Broadcast events (most recent first):");     // Catch: Throwable -> L7
        ipw.increaseIndent();     // Catch: Throwable -> L7
        this.mBroadcastEventsBuffer.reverseDump(ipw);     // Catch: Throwable -> L7
        ipw.decreaseIndent();     // Catch: Throwable -> L7
        ipw.println();     // Catch: Throwable -> L7
        ipw.println("Notification events (most recent first):");     // Catch: Throwable -> L7
        ipw.increaseIndent();     // Catch: Throwable -> L7
        this.mNotificationEventsBuffer.reverseDump(ipw);     // Catch: Throwable -> L7
        ipw.decreaseIndent();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static String getBroadcastDispatchEventLog(int sourceUid, String targetPackage, int targetUserId, long idForResponseEvent, long timestampMs, int targetUidProcState) {
        return TextUtils.formatSimple("broadcast:%s; srcUid=%d, tgtPkg=%s, tgtUsr=%d, id=%d, state=%s", new Object[]{TimeUtils.formatDuration(timestampMs), Integer.valueOf(sourceUid), targetPackage, Integer.valueOf(targetUserId), Long.valueOf(idForResponseEvent), ActivityManager.procStateToString(targetUidProcState)});
    }

    private static String getNotificationEventLog(int event, String packageName, int userId, long timestampMs) {
        return TextUtils.formatSimple("notification:%s; event=<%s>, pkg=%s, usr=%d", new Object[]{TimeUtils.formatDuration(timestampMs), notificationEventToString(event), packageName, Integer.valueOf(userId)});
    }

    private static String notificationEventToString(int event) {
        switch(event) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        return "cancelled";
    L7:
        return "updated";
    L9:
        return "posted";
    L4:
        return String.valueOf(event);
    }
}
