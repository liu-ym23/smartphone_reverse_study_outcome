package com.android.server.alarm;

import android.app.AlarmManager;
import android.app.IAlarmListener;
import android.app.PendingIntent;
import android.os.Binder;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.WorkSource;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import android.util.TimeUtils;
import android.util.proto.ProtoOutputStream;
import com.android.server.voiceinteraction.DatabaseHelper;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
class Alarm {
    public static final int APP_STANDBY_POLICY_INDEX = 1;
    public static final int BATTERY_SAVER_POLICY_INDEX = 3;
    public static final int DEVICE_IDLE_POLICY_INDEX = 2;
    static final int EXACT_ALLOW_REASON_ALLOW_LIST = 1;
    static final int EXACT_ALLOW_REASON_COMPAT = 2;
    static final int EXACT_ALLOW_REASON_LISTENER = 4;
    static final int EXACT_ALLOW_REASON_NOT_APPLICABLE = -1;
    static final int EXACT_ALLOW_REASON_PERMISSION = 0;
    static final int EXACT_ALLOW_REASON_POLICY_PERMISSION = 3;
    static final int EXACT_ALLOW_REASON_PRIORITIZED = 5;
    public static final int NUM_POLICIES = 5;
    public static final int POWER_SAVER_POLICY_INDEX = 4;
    public static final int REQUESTER_POLICY_INDEX = 0;
    public final AlarmManager.AlarmClockInfo alarmClock;
    public int count;
    public final int creatorUid;
    public int exactAllowReason;
    public final int flags;
    public HeartbeatStats.HeartbeatInfo hbInfo;
    public final IAlarmListener listener;
    public final String listenerTag;
    public Bundle mIdleOptions;
    private long mMaxWhenElapsed;
    private long[] mPolicyWhenElapsed;
    public boolean mUsingReserveQuota;
    private long mWhenElapsed;
    public final PendingIntent operation;
    public final long origWhen;
    public final String packageName;
    public int priorityClass;
    public final String processName;
    public final long repeatInterval;
    public final String sourcePackage;
    public final String statsTag;
    public final int type;
    public final int uid;
    public final boolean wakeup;
    public final long windowLength;
    public final WorkSource workSource;

    static class Snapshot {
        final long[] mPolicyWhenElapsed;
        final String mTag;
        final int mType;

        Snapshot(Alarm a) {
            this.mType = a.type;
            this.mTag = a.statsTag;
            this.mPolicyWhenElapsed = Arrays.copyOf(Alarm.m982$$Nest$fgetmPolicyWhenElapsed(a), 5);
        }

        void dump(IndentingPrintWriter pw, long nowElapsed) {
            pw.print(DatabaseHelper.SoundModelContract.KEY_TYPE, Alarm.typeToString(this.mType));
            pw.print("tag", this.mTag);
            pw.println();
            pw.print("policyWhenElapsed:");
            int i = 0;
        L4:
            if (i >= 5) goto L6;
            pw.print(" " + Alarm.policyIndexToString(i) + "=");
            TimeUtils.formatDuration(this.mPolicyWhenElapsed[i], nowElapsed, pw);
            i = i + 1;
            goto L4
        L6:
            pw.println();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPolicyWhenElapsed, reason: not valid java name */
    static /* bridge */ /* synthetic */ long[] m982$$Nest$fgetmPolicyWhenElapsed(Alarm r0) {
        return r0.mPolicyWhenElapsed;
    }

    Alarm(int type, long when, long requestedWhenElapsed, long windowLength, long interval, PendingIntent op, IAlarmListener rec, String listenerTag, WorkSource ws, int flags, AlarmManager.AlarmClockInfo info, int uid, String pkgName, Bundle idleOptions, int exactAllowReason, String procName) {
        this.type = type;
        this.origWhen = when;
        if (type == 2) goto L7;
        if (type == 0) goto L7;
        boolean r10 = false;
    L8:
        this.wakeup = r10;
        this.mPolicyWhenElapsed = new long[5];
        this.mPolicyWhenElapsed[0] = requestedWhenElapsed;
        this.mWhenElapsed = requestedWhenElapsed;
        this.windowLength = windowLength;
        this.mMaxWhenElapsed = AlarmManagerService.addClampPositive(requestedWhenElapsed, windowLength);
        this.repeatInterval = interval;
        this.operation = op;
        this.listener = rec;
        this.listenerTag = listenerTag;
        this.statsTag = makeTag(op, listenerTag, type);
        this.workSource = ws;
        this.alarmClock = info;
        this.uid = uid;
        this.packageName = pkgName;
        this.mIdleOptions = idleOptions;
        this.exactAllowReason = exactAllowReason;
        if (this.operation == null) goto L11;
        String r1 = this.operation.getCreatorPackage();
    L12:
        this.sourcePackage = r1;
        this.processName = procName;
        this.flags = checkHeartBeat(flags);
        if (this.operation == null) goto L15;
        int r2 = this.operation.getCreatorUid();
    L16:
        this.creatorUid = r2;
        this.mUsingReserveQuota = false;
        this.priorityClass = 2;
        return;
    L15:
        r2 = this.uid;
        goto L16
    L11:
        r1 = this.packageName;
    L7:
        r10 = true;
        goto L8
    }

    public static String makeTag(PendingIntent pi, String tag, int type) {
        if (type == 2) goto L7;
        if (type == 0) goto L7;
        String alarmString = "*alarm*:";
    L9:
        if (HeartbeatStats.sEnabled == true) goto L14;
        if (pi == null) goto L13;
        return pi.getTag(alarmString);
    L13:
        return alarmString + tag;
    L14:
        if (pi == null) goto L20;
        long ident = Binder.clearCallingIdentity();
        String action = pi.getIntent().getAction();
        String ret = HeartbeatStats.filterAction(action);
        if (ret != null) goto L18;
        ret = pi.getTag(alarmString);
    L18:
        Binder.restoreCallingIdentity(ident);
        return ret;
    L20:
        return alarmString + tag;
    L7:
        alarmString = "*walarm*:";
        goto L9
    }

    public boolean matches(PendingIntent pi, IAlarmListener rec) {
        if (this.operation != null) goto L11;
        if (rec != null) goto L7;
    L9:
        return false;
    L7:
        if (this.listener.asBinder().equals(rec.asBinder()) == false) goto L9;
        return true;
    L11:
        return this.operation.equals(pi);
    }

    public boolean matches(String packageName) {
        return packageName.equals(this.sourcePackage);
    }

    long getPolicyElapsed(int policyIndex) {
        return this.mPolicyWhenElapsed[policyIndex];
    }

    public long getRequestedElapsed() {
        return this.mPolicyWhenElapsed[0];
    }

    public long getWhenElapsed() {
        return this.mWhenElapsed;
    }

    public long getMaxWhenElapsed() {
        return this.mMaxWhenElapsed;
    }

    public boolean setPolicyElapsed(int policyIndex, long policyElapsed) {
        this.mPolicyWhenElapsed[policyIndex] = policyElapsed;
        if (HeartbeatStats.sEnabled == false) goto L8;
        if (HeartbeatStats.DEBUG_HEARTBEAT_V == false) goto L8;
        Slog.i("AlarmManager", "setPolicyElapsed: " + policyIndexToString(policyIndex) + ", policyElapsed: " + policyElapsed + ", now: " + SystemClock.elapsedRealtime());
    L8:
        return updateWhenElapsed();
    }

    public long calHeartBeatElapsed(boolean isPending) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (isPending == false) goto L11;
        long heartBeatElapsed = this.mPolicyWhenElapsed[4];
        if (heartBeatElapsed == 0) goto L9;
        if ((heartBeatElapsed - elapsedRealtime) < 259200000) goto L9;
        return heartBeatElapsed;
    L9:
        return elapsedRealtime + 31536000000L;
    L11:
        if (this.hbInfo == null) goto L20;
        long heartBeatInterval = this.hbInfo.getHeartbeatInterval();
        if (heartBeatInterval <= 0) goto L20;
        if (this.mPolicyWhenElapsed[0] >= (Long.MAX_VALUE - heartBeatInterval)) goto L20;
        long cnt = (this.mPolicyWhenElapsed[0] + (heartBeatInterval / 2)) / heartBeatInterval;
        long heartBeatElapsed2 = cnt * heartBeatInterval;
        if (heartBeatElapsed2 < elapsedRealtime) goto L19;
        return heartBeatElapsed2;
    L19:
        return heartBeatElapsed2 + heartBeatInterval;
    L20:
        return 0;
    }

    private boolean updateWhenElapsed() {
        long oldWhenElapsed = this.mWhenElapsed;
        long oldMaxWhenElapsed = this.mMaxWhenElapsed;
        if (this.mPolicyWhenElapsed[4] == 0) goto L24;
        this.mWhenElapsed = this.mPolicyWhenElapsed[4];
        this.mMaxWhenElapsed = this.mPolicyWhenElapsed[4];
        if (HeartbeatStats.sEnabled == false) goto L18;
        if (HeartbeatStats.DEBUG_HEARTBEAT_V == false) goto L18;
        StringBuilder r5 = new StringBuilder();
        r5.append("updateWhenElapsed windowLen: ");
        r5.append(this.windowLength);
        r5.append(", requester: ");
        r5.append(this.mPolicyWhenElapsed[0]);
        r5.append(", old[");
        r5.append(oldWhenElapsed);
        r5.append(", ");
        r5.append(oldMaxWhenElapsed);
        r5.append("] new[");
        r5.append(this.mWhenElapsed);
        r5.append(", ");
        r5.append(this.mMaxWhenElapsed);
        r5.append("] ");
        if (oldWhenElapsed == this.mWhenElapsed) goto L11;
        boolean r6 = true;
    L12:
        r5.append(r6);
        r5.append(", ");
        if (oldMaxWhenElapsed == this.mMaxWhenElapsed) goto L15;
        boolean r7 = true;
    L16:
        r5.append(r7);
        Slog.i("AlarmManager", r5.toString());
        goto L18
    L15:
        r7 = false;
        goto L16
    L11:
        r6 = false;
    L18:
        if (oldWhenElapsed == this.mWhenElapsed) goto L20;
        return true;
    L20:
        if (oldMaxWhenElapsed == this.mMaxWhenElapsed) goto L23;
        return true;
    L23:
        return false;
    L24:
        this.mWhenElapsed = 0;
        int i = 0;
    L26:
        if (i >= 5) goto L28;
        int i2 = i;
        this.mWhenElapsed = Math.max(this.mWhenElapsed, this.mPolicyWhenElapsed[i2]);
        i = i2 + 1;
        goto L26
    L28:
        long maxRequestedElapsed = AlarmManagerService.addClampPositive(this.mPolicyWhenElapsed[0], this.windowLength);
        this.mMaxWhenElapsed = Math.max(maxRequestedElapsed, this.mWhenElapsed);
        if (HeartbeatStats.sEnabled == false) goto L42;
        if (HeartbeatStats.DEBUG_HEARTBEAT_V == false) goto L42;
        StringBuilder r9 = new StringBuilder();
        r9.append("updateWhenElapsed windowLen: ");
        long maxRequestedElapsed2 = this.windowLength;
        r9.append(maxRequestedElapsed2);
        r9.append(", requester: ");
        r9.append(this.mPolicyWhenElapsed[0]);
        r9.append(", old[");
        r9.append(oldWhenElapsed);
        r9.append(", ");
        r9.append(oldMaxWhenElapsed);
        r9.append("] new[");
        r9.append(this.mWhenElapsed);
        r9.append(", ");
        r9.append(this.mMaxWhenElapsed);
        r9.append("] ");
        if (oldWhenElapsed == this.mWhenElapsed) goto L35;
        boolean r8 = true;
    L36:
        r9.append(r8);
        r9.append(", ");
        if (oldMaxWhenElapsed == this.mMaxWhenElapsed) goto L39;
        boolean r10 = true;
    L40:
        r9.append(r10);
        Slog.i("AlarmManager", r9.toString());
        goto L42
    L39:
        r10 = false;
        goto L40
    L35:
        r8 = false;
    L42:
        long maxRequestedElapsed3 = this.mWhenElapsed;
        if (oldWhenElapsed == maxRequestedElapsed3) goto L45;
        return true;
    L45:
        if (oldMaxWhenElapsed == this.mMaxWhenElapsed) goto L48;
        return true;
    L48:
        return false;
    }

    int checkHeartBeat(int _flags) {
        if (HeartbeatStats.sEnabled == true) goto L6;
        return _flags;
    L6:
        if (this.alarmClock == null) goto L8;
        return _flags;
    L8:
        this.hbInfo = AlarmManagerService.sHeartbeatStats.getHeartbeatInfo(this);
        if (this.hbInfo != null) goto L12;
        return _flags;
    L12:
        if (HeartbeatStats.DEBUG_HEARTBEAT_V == false) goto L15;
        Slog.v("HeartbeatStats", "adjust for heartbeat, hbInfo=" + this.hbInfo + ", this=" + this);
    L15:
        if ((_flags & 1) == 0) goto L17;
        int _flags2 = _flags & (-2);
    L18:
        long heartBeatInterval = this.hbInfo.getHeartbeatInterval();
        long origInterval = this.mMaxWhenElapsed - this.mWhenElapsed;
        if (heartBeatInterval <= origInterval) goto L36;
        long oldWhenElapsed = this.mWhenElapsed;
        long oldMaxWhenElapsed = this.mMaxWhenElapsed;
        long smartHeatbeatTime = calHeartBeatElapsed(false);
        if (smartHeatbeatTime == 0) goto L40;
        this.mWhenElapsed = smartHeatbeatTime;
        this.mMaxWhenElapsed = smartHeatbeatTime;
        this.mPolicyWhenElapsed[4] = smartHeatbeatTime;
        if (HeartbeatStats.DEBUG_HEARTBEAT_V == false) goto L40;
        StringBuilder r13 = new StringBuilder();
        r13.append("checkHeartBeat windowLen: ");
        r13.append(this.windowLength);
        r13.append(", requester: ");
        r13.append(this.mPolicyWhenElapsed[0]);
        r13.append(", old[");
        r13.append(oldWhenElapsed);
        r13.append(", ");
        r13.append(oldMaxWhenElapsed);
        r13.append("] new[");
        r13.append(this.mWhenElapsed);
        r13.append(", ");
        r13.append(this.mMaxWhenElapsed);
        r13.append("] ");
        if (oldWhenElapsed == this.mWhenElapsed) goto L27;
        boolean r10 = true;
    L28:
        r13.append(r10);
        r13.append(", ");
        if (oldMaxWhenElapsed == this.mMaxWhenElapsed) goto L31;
        boolean r11 = true;
    L32:
        r13.append(r11);
        Slog.i("AlarmManager", r13.toString());
        goto L40
    L31:
        r11 = false;
        goto L32
    L27:
        r10 = false;
    L40:
        return _flags2;
    L36:
        boolean updated = this.hbInfo.updateStep(origInterval);
        if (HeartbeatStats.DEBUG_HEARTBEAT_V == false) goto L40;
        if (updated == false) goto L40;
        Slog.v("HeartbeatStats", "adjust init heartbeat, hbInfo=" + this.hbInfo + ", origInterval=" + origInterval + ", this=" + this);
        goto L40
    L17:
        _flags2 = _flags;
        goto L18
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("Alarm{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" type ");
        sb.append(this.type);
        sb.append(" origWhen ");
        sb.append(this.origWhen);
        sb.append(" whenElapsed [");
        sb.append(getWhenElapsed());
        if (HeartbeatStats.sEnabled == false) goto L12;
        sb.append(", ");
        sb.append(getMaxWhenElapsed());
        sb.append(", ");
        sb.append(getMaxWhenElapsed() - getWhenElapsed());
        sb.append("] windowLen ");
        sb.append(this.windowLength);
        sb.append(" cnt ");
        sb.append(this.count);
        sb.append(" repeat ");
        sb.append(this.repeatInterval);
        sb.append(" hasHb ");
        boolean r2 = false;
        if (this.hbInfo == null) goto L7;
        boolean r1 = true;
    L8:
        sb.append(r1);
        sb.append(" hasPi ");
        if (this.operation == null) goto L11;
        r2 = true;
    L11:
        sb.append(r2);
        sb.append(" flags:0x");
        sb.append(Integer.toHexString(this.flags));
        sb.append(" tag ");
        sb.append(this.statsTag);
        sb.append(" procName ");
        sb.append(this.processName);
        goto L12
    L7:
        r1 = false;
    L12:
        sb.append(" ");
        sb.append(this.sourcePackage);
        sb.append('}');
        return sb.toString();
    }

    static String policyIndexToString(int index) {
        switch(index) {
            case 0: goto L13;
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L7;
            case 4: goto L5;
            default: goto L4;
        };
    L5:
        return "power_saver";
    L7:
        return "battery_saver";
    L9:
        return "device_idle";
    L11:
        return "app_standby";
    L13:
        return "requester";
    L4:
        return "--unknown(" + index + ")--";
    }

    private static String exactReasonToString(int reason) {
        switch(reason) {
            case -1: goto L17;
            case 0: goto L15;
            case 1: goto L13;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L7;
            case 5: goto L5;
            default: goto L3;
        };
    L3:
        return "--unknown--";
    L5:
        return "prioritized";
    L7:
        return "listener";
    L9:
        return "policy_permission";
    L11:
        return "compat";
    L13:
        return "allow-listed";
    L15:
        return "permission";
    L17:
        return "N/A";
    }

    public static String typeToString(int type) {
        switch(type) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L3;
        };
    L3:
        return "--unknown--";
    L5:
        return "ELAPSED";
    L7:
        return "ELAPSED_WAKEUP";
    L9:
        return "RTC";
    L11:
        return "RTC_WAKEUP";
    }

    public void dump(IndentingPrintWriter ipw, long nowELAPSED, SimpleDateFormat sdf) {
        boolean isRtc = true;
        if (this.type != 1) goto L5;
    L8:
        ipw.print("tag=");
        ipw.println(this.statsTag);
        ipw.print("type=");
        ipw.print(typeToString(this.type));
        ipw.print(" origWhen=");
        if (isRtc == false) goto L11;
        ipw.print(sdf.format(new Date(this.origWhen)));
    L12:
        ipw.print(" window=");
        TimeUtils.formatDuration(this.windowLength, ipw);
        if (this.exactAllowReason == (-1)) goto L15;
        ipw.print(" exactAllowReason=");
        ipw.print(exactReasonToString(this.exactAllowReason));
    L15:
        ipw.print(" repeatInterval=");
        ipw.print(this.repeatInterval);
        ipw.print(" count=");
        ipw.print(this.count);
        ipw.print(" flags=0x");
        ipw.println(Integer.toHexString(this.flags));
        ipw.print("policyWhenElapsed:");
        int i = 0;
    L17:
        if (i >= 5) goto L19;
        ipw.print(" " + policyIndexToString(i) + "=");
        TimeUtils.formatDuration(this.mPolicyWhenElapsed[i], nowELAPSED, ipw);
        i = i + 1;
        goto L17
    L19:
        ipw.println();
        ipw.print("whenElapsed=");
        TimeUtils.formatDuration(getWhenElapsed(), nowELAPSED, ipw);
        ipw.print(" maxWhenElapsed=");
        TimeUtils.formatDuration(this.mMaxWhenElapsed, nowELAPSED, ipw);
        if (this.mUsingReserveQuota == false) goto L22;
        ipw.print(" usingReserveQuota=true");
    L22:
        ipw.println();
        if (this.alarmClock == null) goto L26;
        ipw.println("Alarm clock:");
        ipw.print("  triggerTime=");
        ipw.println(sdf.format(new Date(this.alarmClock.getTriggerTime())));
        ipw.print("  showIntent=");
        ipw.println(this.alarmClock.getShowIntent());
    L26:
        if (this.operation == null) goto L29;
        ipw.print("operation=");
        ipw.println(this.operation);
    L29:
        if (this.listener == null) goto L32;
        ipw.print("listener=");
        ipw.println(this.listener.asBinder());
    L32:
        if (this.mIdleOptions == null) goto L36;
        ipw.print("idle-options=");
        ipw.println(this.mIdleOptions.toString());
        return;
    L36:
        return;
    L11:
        TimeUtils.formatDuration(this.origWhen, nowELAPSED, ipw);
        goto L12
    L5:
        if (this.type == 0) goto L8;
        isRtc = false;
        goto L8
    }

    public void dumpDebug(ProtoOutputStream proto, long fieldId, long nowElapsed) {
        long token = proto.start(fieldId);
        proto.write(1138166333441L, this.statsTag);
        proto.write(1159641169922L, this.type);
        proto.write(1112396529667L, getWhenElapsed() - nowElapsed);
        proto.write(1112396529668L, this.windowLength);
        proto.write(1112396529669L, this.repeatInterval);
        proto.write(1120986464262L, this.count);
        proto.write(1120986464263L, this.flags);
        if (this.alarmClock == null) goto L6;
        this.alarmClock.dumpDebug(proto, 1146756268040L);
    L6:
        if (this.operation == null) goto L9;
        this.operation.dumpDebug(proto, 1146756268041L);
    L9:
        if (this.listener == null) goto L11;
        proto.write(1138166333450L, this.listener.asBinder().toString());
    L11:
        proto.end(token);
    }
}
