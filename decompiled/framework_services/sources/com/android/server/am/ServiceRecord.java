package com.android.server.am;

import android.app.BackgroundStartPrivileges;
import android.app.IApplicationThread;
import android.app.Notification;
import android.app.compat.CompatChanges;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.IBinder;
import android.os.PowerExemptionManager;
import android.os.SystemClock;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.Slog;
import android.util.TimeUtils;
import android.util.proto.ProtoOutputStream;
import android.util.proto.ProtoUtils;
import com.android.internal.app.procstats.ServiceState;
import com.android.internal.util.Preconditions;
import com.android.server.uri.NeededUriGrants;
import com.android.server.uri.UriPermissionOwner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class ServiceRecord extends Binder implements ComponentName.WithComponentName {
    static final int MAX_DELIVERY_COUNT = 3;
    static final int MAX_DONE_EXECUTING_COUNT = 6;
    private static final String TAG = "ActivityManager";
    static final long USE_NEW_BFSL_LOGIC = 311208749;
    static final long USE_NEW_WIU_LOGIC_FOR_CAPABILITIES = 313677553;
    static final long USE_NEW_WIU_LOGIC_FOR_START = 311208629;
    boolean allowlistManager;
    final ActivityManagerService ams;
    ProcessRecord app;
    ApplicationInfo appInfo;
    final ArrayMap<Intent.FilterComparison, IntentBindRecord> bindings;
    boolean callStart;
    public final ArrayMap<IBinder, ArrayList<ConnectionRecord>> connections;
    int crashCount;
    final long createRealTime;
    boolean createdFromFg;
    final String definingPackageName;
    final int definingUid;
    boolean delayed;
    boolean delayedStop;
    final ArrayList<StartItem> deliveredStarts;
    long destroyTime;
    boolean destroying;
    boolean executeFg;
    int executeNesting;
    long executingStart;
    final boolean exported;
    long fgDisplayTime;
    boolean fgRequired;
    boolean fgWaiting;
    int foregroundId;
    Notification foregroundNoti;
    int foregroundServiceType;
    boolean inSharedIsolatedProcess;
    final ComponentName instanceName;
    final Intent.FilterComparison intent;
    boolean isForeground;
    boolean isNotAppComponentUsage;
    final boolean isSdkSandbox;
    ProcessRecord isolationHostProc;
    long lastActivity;
    private int lastStartId;
    long lastTopAlmostPerceptibleBindRequestUptimeMs;
    int mAdjSeq;
    int mAllowStartForegroundAtEntering;
    int mAllowStart_byBindings;
    int mAllowStart_inBindService;
    int mAllowStart_noBinding;
    boolean mAllowUiJobScheduling;
    boolean mAllowWhileInUsePermissionInFgsAtEntering;
    int mAllowWiu_byBindings;
    int mAllowWiu_inBindService;
    int mAllowWiu_noBinding;
    private ProcessRecord mAppForAllowingBgActivityStartsByStart;
    private ArrayList<BackgroundStartPrivileges> mBackgroundStartPrivilegesByStart;
    private BackgroundStartPrivileges mBackgroundStartPrivilegesByStartMerged;
    private Runnable mCleanUpAllowBgActivityStartsByStartCallback;
    long mEarliestRestartTime;
    ForegroundServiceDelegation mFgsDelegation;
    long mFgsEnterTime;
    long mFgsExitTime;
    boolean mFgsHasNotificationPermission;
    boolean mFgsNotificationDeferred;
    boolean mFgsNotificationShown;
    boolean mFgsNotificationWasDeferred;
    String mInfoAllowStartForeground;
    ActivityManagerService.FgsTempAllowListItem mInfoTempFgsAllowListReason;
    private boolean mIsAllowedBgActivityStartsByBinding;
    boolean mIsFgsDelegate;
    boolean mKeepWarming;
    boolean mLoggedInfoAllowStartForeground;
    int mProcessStateOnRequest;
    ApplicationInfo mRecentCallerApplicationInfo;
    String mRecentCallingPackage;
    int mRecentCallingUid;
    long mRestartSchedulingTime;
    private ShortFgsInfo mShortFgsInfo;
    int mStartForegroundCount;
    final ComponentName name;
    long nextRestartTime;
    final String packageName;
    int pendingConnectionGroup;
    int pendingConnectionImportance;
    final ArrayList<StartItem> pendingStarts;
    final String permission;
    final String processName;
    int restartCount;
    long restartDelay;
    long restartTime;
    ServiceState restartTracker;
    final Runnable restarter;
    final String sdkSandboxClientAppPackage;
    final int sdkSandboxClientAppUid;
    final ServiceInfo serviceInfo;
    final String shortInstanceName;
    int startCommandResult;
    boolean startRequested;
    long startingBgTimeout;
    boolean stopIfKilled;
    String stringName;
    boolean systemRequestedFgToBg;
    int totalRestartCount;
    ServiceState tracker;
    final int userId;

    class ShortFgsInfo {
        private int mStartForegroundCount;
        private int mStartId;
        private final long mStartTime;
        final /* synthetic */ ServiceRecord this$0;

        ShortFgsInfo(ServiceRecord this$0, long startTime) {
            this.this$0 = this$0;
            this.mStartTime = startTime;
            update();
        }

        public void update() {
            this.mStartForegroundCount = this.this$0.mStartForegroundCount;
            this.mStartId = this.this$0.getLastStartId();
        }

        long getStartTime() {
            return this.mStartTime;
        }

        int getStartForegroundCount() {
            return this.mStartForegroundCount;
        }

        int getStartId() {
            return this.mStartId;
        }

        boolean isCurrent() {
            if (this.mStartForegroundCount != this.this$0.mStartForegroundCount) goto L5;
            return true;
        L5:
            return false;
        }

        long getTimeoutTime() {
            return this.mStartTime + this.this$0.ams.mConstants.mShortFgsTimeoutDuration;
        }

        long getProcStateDemoteTime() {
            return (this.mStartTime + this.this$0.ams.mConstants.mShortFgsTimeoutDuration) + this.this$0.ams.mConstants.mShortFgsProcStateExtraWaitDuration;
        }

        long getAnrTime() {
            return (this.mStartTime + this.this$0.ams.mConstants.mShortFgsTimeoutDuration) + this.this$0.ams.mConstants.mShortFgsAnrExtraWaitDuration;
        }

        String getDescription() {
            return "sfc=" + this.mStartForegroundCount + " sid=" + this.mStartId + " stime=" + this.mStartTime + " tt=" + getTimeoutTime() + " dt=" + getProcStateDemoteTime() + " at=" + getAnrTime();
        }
    }

    static class StartItem {
        final int callingId;
        long deliveredTime;
        int deliveryCount;
        int doneExecutingCount;
        final int id;
        final Intent intent;
        final String mCallingPackageName;
        final String mCallingProcessName;
        final int mCallingProcessState;
        final NeededUriGrants neededGrants;
        final ServiceRecord sr;
        String stringName;
        final boolean taskRemoved;
        UriPermissionOwner uriPermissions;

        StartItem(ServiceRecord _sr, boolean _taskRemoved, int _id, Intent _intent, NeededUriGrants _neededGrants, int _callingId, String callingProcessName, String callingPackageName, int callingProcessState) {
            this.sr = _sr;
            this.taskRemoved = _taskRemoved;
            this.id = _id;
            this.intent = _intent;
            this.neededGrants = _neededGrants;
            this.callingId = _callingId;
            this.mCallingProcessName = callingProcessName;
            this.mCallingPackageName = callingPackageName;
            this.mCallingProcessState = callingProcessState;
        }

        UriPermissionOwner getUriPermissionsLocked() {
            if (this.uriPermissions != null) goto L6;
            this.uriPermissions = new UriPermissionOwner(this.sr.ams.mUgmInternal, this);
        L6:
            return this.uriPermissions;
        }

        void removeUriPermissionsLocked() {
            if (this.uriPermissions == null) goto L6;
            this.uriPermissions.removeUriPermissions();
            this.uriPermissions = null;
            return;
        }

        public void dumpDebug(ProtoOutputStream proto, long fieldId, long now) {
            long token = proto.start(fieldId);
            proto.write(1120986464257L, this.id);
            ProtoUtils.toDuration(proto, 1146756268034L, this.deliveredTime, now);
            proto.write(1120986464259L, this.deliveryCount);
            proto.write(1120986464260L, this.doneExecutingCount);
            if (this.intent == null) goto L6;
            this.intent.dumpDebug(proto, 1146756268037L, true, true, true, false);
        L6:
            if (this.neededGrants == null) goto L9;
            this.neededGrants.dumpDebug(proto, 1146756268038L);
        L9:
            if (this.uriPermissions == null) goto L11;
            this.uriPermissions.dumpDebug(proto, 1146756268039L);
        L11:
            proto.end(token);
        }

        public String toString() {
            if (this.stringName != null) goto L5;
            StringBuilder sb = new StringBuilder(128);
            sb.append("ServiceRecord{");
            sb.append(Integer.toHexString(System.identityHashCode(this.sr)));
            sb.append(' ');
            sb.append(this.sr.shortInstanceName);
            sb.append(" StartItem ");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" id=");
            sb.append(this.id);
            sb.append('}');
            String r1 = sb.toString();
            this.stringName = r1;
            return r1;
        L5:
            return this.stringName;
        }
    }

    static class TimeLimitedFgsInfo {
        private long mFirstFgsStartRealtime;
        private long mFirstFgsStartUptime;
        private long mLastFgsStartTime;
        private int mNumParallelServices;
        private long mTimeLimitExceededAt;
        private long mTotalRuntime;

        TimeLimitedFgsInfo() {
            this.mTimeLimitExceededAt = Long.MIN_VALUE;
            this.mTotalRuntime = 0;
            this.mNumParallelServices = 0;
        }

        public void noteFgsFgsStart(long startTime) {
            this.mNumParallelServices++;
            if (this.mNumParallelServices != 1) goto L5;
            this.mFirstFgsStartUptime = startTime;
            this.mFirstFgsStartRealtime = SystemClock.elapsedRealtime();
        L5:
            this.mLastFgsStartTime = startTime;
        }

        public long getFirstFgsStartUptime() {
            return this.mFirstFgsStartUptime;
        }

        public long getFirstFgsStartRealtime() {
            return this.mFirstFgsStartRealtime;
        }

        public long getLastFgsStartTime() {
            return this.mLastFgsStartTime;
        }

        public void decNumParallelServices() {
            if (this.mNumParallelServices <= 0) goto L6;
            this.mNumParallelServices--;
        L6:
            if (this.mNumParallelServices != 0) goto L9;
            this.mLastFgsStartTime = 0;
            return;
        }

        public void updateTotalRuntime(long nowUptime) {
            this.mTotalRuntime += nowUptime - this.mLastFgsStartTime;
            this.mLastFgsStartTime = nowUptime;
        }

        public long getTotalRuntime() {
            return this.mTotalRuntime;
        }

        public void setTimeLimitExceededAt(long timeLimitExceededAt) {
            this.mTimeLimitExceededAt = timeLimitExceededAt;
        }

        public long getTimeLimitExceededAt() {
            return this.mTimeLimitExceededAt;
        }

        public void reset() {
            this.mNumParallelServices = 0;
            this.mFirstFgsStartUptime = 0;
            this.mFirstFgsStartRealtime = 0;
            this.mLastFgsStartTime = 0;
            this.mTotalRuntime = 0;
            this.mTimeLimitExceededAt = Long.MIN_VALUE;
        }
    }

    public static /* synthetic */ void $r8$lambda$KzqVHAivc5a2BQvDWrhUmMueE4I(ServiceRecord r0) {
        r0.lambda$allowBgActivityStartsOnServiceStart$0();
    }

    /* JADX INFO: renamed from: -$$Nest$msignalForegroundServiceNotification, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1580$$Nest$msignalForegroundServiceNotification(ServiceRecord r0, String r1, int r2, int r3, boolean r4) {
        r0.signalForegroundServiceNotification(r1, r2, r3, r4);
    }

    private boolean useNewWiuLogic_forStart() {
        return CompatChanges.isChangeEnabled(USE_NEW_WIU_LOGIC_FOR_START, this.appInfo.uid);
    }

    private boolean useNewWiuLogic_forCapabilities() {
        return CompatChanges.isChangeEnabled(USE_NEW_WIU_LOGIC_FOR_CAPABILITIES, this.appInfo.uid);
    }

    private boolean useNewBfslLogic() {
        return CompatChanges.isChangeEnabled(USE_NEW_BFSL_LOGIC, this.appInfo.uid);
    }

    private int getFgsAllowWiu_legacy() {
        return reasonOr(this.mAllowWiu_noBinding, this.mAllowWiu_inBindService);
    }

    private int getFgsAllowWiu_new() {
        return reasonOr(this.mAllowWiu_noBinding, this.mAllowWiu_byBindings);
    }

    int getFgsAllowWiu_forStart() {
        if (useNewWiuLogic_forStart() == false) goto L7;
        return getFgsAllowWiu_new();
    L7:
        return getFgsAllowWiu_legacy();
    }

    int getFgsAllowWiu_forCapabilities() {
        if (useNewWiuLogic_forCapabilities() == false) goto L7;
        return getFgsAllowWiu_new();
    L7:
        return getFgsAllowWiu_forStart();
    }

    boolean isFgsAllowedWiu_forStart() {
        if (getFgsAllowWiu_forStart() == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isFgsAllowedWiu_forCapabilities() {
        if (getFgsAllowWiu_forCapabilities() == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private int getFgsAllowStart_legacy() {
        return reasonOr(this.mAllowStart_noBinding, this.mAllowStart_inBindService, this.mAllowStart_byBindings);
    }

    private int getFgsAllowStart_new() {
        return reasonOr(this.mAllowStart_noBinding, this.mAllowStart_byBindings);
    }

    int getFgsAllowStart() {
        if (useNewBfslLogic() == false) goto L7;
        return getFgsAllowStart_new();
    L7:
        return getFgsAllowStart_legacy();
    }

    boolean isFgsAllowedStart() {
        if (getFgsAllowStart() == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    void clearFgsAllowWiu() {
        this.mAllowWiu_noBinding = -1;
        this.mAllowWiu_inBindService = -1;
        this.mAllowWiu_byBindings = -1;
    }

    void clearFgsAllowStart() {
        this.mAllowStart_noBinding = -1;
        this.mAllowStart_inBindService = -1;
        this.mAllowStart_byBindings = -1;
    }

    static int reasonOr(int first, int second) {
        if (first == (-1)) goto L6;
        return first;
    L6:
        return second;
    }

    static int reasonOr(int first, int second, int third) {
        if (first == (-1)) goto L6;
        return first;
    L6:
        return reasonOr(second, third);
    }

    boolean allowedChanged(int legacyCode, int newCode) {
        if (legacyCode != (-1)) goto L5;
        boolean r3 = true;
    L6:
        if (newCode != (-1)) goto L8;
        boolean r2 = true;
    L9:
        if (r3 != r2) goto L11;
        return false;
    L11:
        return true;
    L8:
        r2 = false;
        goto L9
    L5:
        r3 = false;
        goto L6
    }

    private String getFgsInfoForWtf() {
        return " cmp: " + getComponentName().toShortString() + " sdk: " + this.appInfo.targetSdkVersion;
    }

    void maybeLogFgsLogicChange() {
        int wiuLegacy = getFgsAllowWiu_legacy();
        int wiuNew = getFgsAllowWiu_new();
        int startLegacy = getFgsAllowStart_legacy();
        int startNew = getFgsAllowStart_new();
        boolean wiuChanged = allowedChanged(wiuLegacy, wiuNew);
        boolean startChanged = allowedChanged(startLegacy, startNew);
        if (wiuChanged == true) goto L6;
        if (startChanged == true) goto L6;
        return;
    L6:
        StringBuilder r6 = new StringBuilder();
        r6.append("FGS logic changed:");
        String r7 = "";
        if (wiuChanged == false) goto L9;
        String r8 = " [WIU changed]";
    L10:
        r6.append(r8);
        if (startChanged == false) goto L13;
        r7 = " [BFSL changed]";
    L13:
        r6.append(r7);
        r6.append(" Orig WIU:");
        r6.append(PowerExemptionManager.reasonCodeToString(wiuLegacy));
        r6.append(" New WIU:");
        r6.append(PowerExemptionManager.reasonCodeToString(wiuNew));
        r6.append(" Orig BFSL:");
        r6.append(PowerExemptionManager.reasonCodeToString(startLegacy));
        r6.append(" New BFSL:");
        r6.append(PowerExemptionManager.reasonCodeToString(startNew));
        r6.append(getFgsInfoForWtf());
        String message = r6.toString();
        Slog.wtf(TAG, message);
        return;
    L9:
        r8 = "";
        goto L10
    }

    void dumpStartList(PrintWriter pw, String prefix, List<StartItem> list, long now) {
        int N = list.size();
        int i = 0;
    L3:
        if (i >= N) goto L25;
        StartItem si = list.get(i);
        pw.print(prefix);
        pw.print("#");
        pw.print(i);
        pw.print(" id=");
        pw.print(si.id);
        if (now == 0) goto L8;
        pw.print(" dur=");
        TimeUtils.formatDuration(si.deliveredTime, now, pw);
    L8:
        if (si.deliveryCount == 0) goto L11;
        pw.print(" dc=");
        pw.print(si.deliveryCount);
    L11:
        if (si.doneExecutingCount == 0) goto L13;
        pw.print(" dxc=");
        pw.print(si.doneExecutingCount);
    L13:
        pw.println("");
        pw.print(prefix);
        pw.print("  intent=");
        if (si.intent == null) goto L16;
        pw.println(si.intent.toString());
    L18:
        if (si.neededGrants == null) goto L21;
        pw.print(prefix);
        pw.print("  neededGrants=");
        pw.println(si.neededGrants);
    L21:
        if (si.uriPermissions == null) goto L23;
        si.uriPermissions.dump(pw, prefix);
    L23:
        i = i + 1;
        goto L3
    L16:
        pw.println("null");
        goto L18
    }

    void dumpDebug(ProtoOutputStream proto, long fieldId) {
        ProtoOutputStream r1 = proto;
        long token = proto.start(fieldId);
        r1.write(1138166333441L, this.shortInstanceName);
        if (this.app == null) goto L5;
        boolean r2 = true;
    L6:
        r1.write(1133871366146L, r2);
        if (this.app == null) goto L10;
        r1.write(1120986464259L, this.app.getPid());
    L10:
        if (this.intent == null) goto L13;
        this.intent.getIntent().dumpDebug(r1, 1146756268036L, false, true, false, false);
        r1 = r1;
    L13:
        r1.write(1138166333445L, this.packageName);
        r1.write(1138166333446L, this.processName);
        r1.write(1138166333447L, this.permission);
        long now = SystemClock.uptimeMillis();
        long nowReal = SystemClock.elapsedRealtime();
        if (this.appInfo == null) goto L20;
        long appInfoToken = r1.start(1146756268040L);
        r1.write(1138166333441L, this.appInfo.sourceDir);
        if (Objects.equals(this.appInfo.sourceDir, this.appInfo.publicSourceDir) == true) goto L18;
        r1.write(1138166333442L, this.appInfo.publicSourceDir);
    L18:
        r1.write(1138166333443L, this.appInfo.dataDir);
        r1.write(1120986464260L, this.appInfo.targetSdkVersion);
        r1.end(appInfoToken);
    L20:
        if (this.app == null) goto L23;
        this.app.dumpDebug(r1, 1146756268041L);
    L23:
        if (this.isolationHostProc == null) goto L25;
        this.isolationHostProc.dumpDebug(r1, 1146756268042L);
    L25:
        r1.write(1133871366155L, this.allowlistManager);
        r1.write(1133871366156L, this.delayed);
        if (this.isForeground == false) goto L28;
    L29:
        long fgToken = r1.start(1146756268045L);
        r1.write(1120986464257L, this.foregroundId);
        this.foregroundNoti.dumpDebug(r1, 1146756268034L);
        r1.write(1120986464259L, this.foregroundServiceType);
        r1.end(fgToken);
    L30:
        ProtoUtils.toDuration(r1, 1146756268046L, this.createRealTime, nowReal);
        ProtoOutputStream r3 = proto;
        long now2 = now;
        ProtoUtils.toDuration(r3, 1146756268047L, this.startingBgTimeout, now2);
        ProtoUtils.toDuration(r3, 1146756268048L, this.lastActivity, now2);
        ProtoUtils.toDuration(r3, 1146756268049L, this.restartTime, now2);
        r3.write(1133871366162L, this.createdFromFg);
        r3.write(1133871366171L, isFgsAllowedWiu_forCapabilities());
        if (this.startRequested == false) goto L33;
    L36:
        long startToken = r3.start(1146756268051L);
        r3.write(1133871366145L, this.startRequested);
        r3.write(1133871366146L, this.delayedStop);
        r3.write(1133871366147L, this.stopIfKilled);
        r3.write(1120986464261L, this.lastStartId);
        r3.write(1120986464262L, this.startCommandResult);
        r3.end(startToken);
    L38:
        if (this.executeNesting == 0) goto L41;
        long executNestingToken = r3.start(1146756268052L);
        r3.write(1120986464257L, this.executeNesting);
        r3.write(1133871366146L, this.executeFg);
        ProtoUtils.toDuration(r3, 1146756268035L, this.executingStart, now2);
        r3.end(executNestingToken);
    L41:
        if (this.destroying == false) goto L43;
    L44:
        ProtoUtils.toDuration(r3, 1146756268053L, this.destroyTime, now2);
    L46:
        if (this.crashCount == 0) goto L48;
    L53:
        long crashToken = r3.start(1146756268054L);
        r3.write(1120986464257L, this.restartCount);
        ProtoUtils.toDuration(r3, 1146756268034L, this.nextRestartTime - this.mRestartSchedulingTime, now2);
        r3 = proto;
        ProtoUtils.toDuration(r3, 1146756268035L, this.nextRestartTime, now2);
        r3.write(1120986464260L, this.crashCount);
        r3.end(crashToken);
    L55:
        if (this.deliveredStarts.size() <= 0) goto L60;
        int N = this.deliveredStarts.size();
        int i = 0;
    L57:
        if (i >= N) goto L60;
        long now3 = now2;
        this.deliveredStarts.get(i).dumpDebug(r3, 2246267895831L, now3);
        now2 = now3;
        i = i + 1;
        r3 = proto;
    L60:
        if (this.pendingStarts.size() <= 0) goto L67;
        int N2 = this.pendingStarts.size();
        int i2 = 0;
    L62:
        if (i2 >= N2) goto L67;
        long now4 = now2;
        this.pendingStarts.get(i2).dumpDebug(proto, 2246267895832L, now4);
        now2 = now4;
        i2 = i2 + 1;
    L67:
        if (this.bindings.size() <= 0) goto L72;
        int N3 = this.bindings.size();
        int i3 = 0;
    L69:
        if (i3 >= N3) goto L72;
        IntentBindRecord b = this.bindings.valueAt(i3);
        b.dumpDebug(proto, 2246267895833L);
        i3 = i3 + 1;
    L72:
        if (this.connections.size() <= 0) goto L81;
        int N4 = this.connections.size();
        int conni = 0;
    L74:
        if (conni >= N4) goto L81;
        ArrayList<ConnectionRecord> c = this.connections.valueAt(conni);
        int i4 = 0;
    L77:
        if (i4 >= c.size()) goto L79;
        c.get(i4).dumpDebug(proto, 2246267895834L);
        i4 = i4 + 1;
        goto L77
    L79:
        conni = conni + 1;
    L81:
        if (this.mShortFgsInfo != null) goto L83;
    L85:
        proto.end(token);
        return;
    L83:
        if (this.mShortFgsInfo.isCurrent() == false) goto L85;
        long shortFgsToken = proto.start(1146756268060L);
        proto.write(1112396529665L, this.mShortFgsInfo.getStartTime());
        proto.write(1120986464259L, this.mShortFgsInfo.getStartId());
        proto.write(1112396529668L, this.mShortFgsInfo.getTimeoutTime());
        proto.write(1112396529669L, this.mShortFgsInfo.getProcStateDemoteTime());
        proto.write(1112396529670L, this.mShortFgsInfo.getAnrTime());
        proto.end(shortFgsToken);
        goto L85
    L48:
        if (this.restartCount != 0) goto L53;
        if ((this.nextRestartTime - this.mRestartSchedulingTime) != 0) goto L53;
        if (this.nextRestartTime == 0) goto L55;
    L43:
        if (this.destroyTime == 0) goto L46;
    L33:
        if (this.delayedStop == true) goto L36;
        if (this.lastStartId == 0) goto L38;
    L28:
        if (this.foregroundId == 0) goto L30;
    L5:
        r2 = false;
        goto L6
    }

    void dumpReasonCode(PrintWriter pw, String prefix, String fieldName, int code) {
        pw.print(prefix);
        pw.print(fieldName);
        pw.print("=");
        pw.println(PowerExemptionManager.reasonCodeToString(code));
    }

    void dump(PrintWriter pw, String prefix) {
        pw.print(prefix);
        pw.print("intent={");
        pw.print(this.intent.getIntent().toShortString(false, true, false, false));
        pw.println('}');
        pw.print(prefix);
        pw.print("packageName=");
        pw.println(this.packageName);
        pw.print(prefix);
        pw.print("processName=");
        pw.println(this.processName);
        pw.print(prefix);
        pw.print("targetSdkVersion=");
        pw.println(this.appInfo.targetSdkVersion);
        if (this.permission == null) goto L5;
        pw.print(prefix);
        pw.print("permission=");
        pw.println(this.permission);
    L5:
        long now = SystemClock.uptimeMillis();
        long nowReal = SystemClock.elapsedRealtime();
        if (this.appInfo == null) goto L11;
        pw.print(prefix);
        pw.print("baseDir=");
        pw.println(this.appInfo.sourceDir);
        if (Objects.equals(this.appInfo.sourceDir, this.appInfo.publicSourceDir) == true) goto L10;
        pw.print(prefix);
        pw.print("resDir=");
        pw.println(this.appInfo.publicSourceDir);
    L10:
        pw.print(prefix);
        pw.print("dataDir=");
        pw.println(this.appInfo.dataDir);
    L11:
        pw.print(prefix);
        pw.print("app=");
        pw.println(this.app);
        if (this.isolationHostProc == null) goto L15;
        pw.print(prefix);
        pw.print("isolationHostProc=");
        pw.println(this.isolationHostProc);
    L15:
        if (this.allowlistManager == false) goto L18;
        pw.print(prefix);
        pw.print("allowlistManager=");
        pw.println(this.allowlistManager);
    L18:
        if (this.mIsAllowedBgActivityStartsByBinding == false) goto L21;
        pw.print(prefix);
        pw.print("mIsAllowedBgActivityStartsByBinding=");
        pw.println(this.mIsAllowedBgActivityStartsByBinding);
    L21:
        if (this.mBackgroundStartPrivilegesByStartMerged.allowsAny() == false) goto L23;
        pw.print(prefix);
        pw.print("mIsAllowedBgActivityStartsByStart=");
        pw.println(this.mBackgroundStartPrivilegesByStartMerged);
    L23:
        pw.print(prefix);
        pw.print("useNewWiuLogic_forCapabilities()=");
        pw.println(useNewWiuLogic_forCapabilities());
        pw.print(prefix);
        pw.print("useNewWiuLogic_forStart()=");
        pw.println(useNewWiuLogic_forStart());
        pw.print(prefix);
        pw.print("useNewBfslLogic()=");
        pw.println(useNewBfslLogic());
        dumpReasonCode(pw, prefix, "mAllowWiu_noBinding", this.mAllowWiu_noBinding);
        dumpReasonCode(pw, prefix, "mAllowWiu_inBindService", this.mAllowWiu_inBindService);
        dumpReasonCode(pw, prefix, "mAllowWiu_byBindings", this.mAllowWiu_byBindings);
        dumpReasonCode(pw, prefix, "getFgsAllowWiu_legacy", getFgsAllowWiu_legacy());
        dumpReasonCode(pw, prefix, "getFgsAllowWiu_new", getFgsAllowWiu_new());
        dumpReasonCode(pw, prefix, "getFgsAllowWiu_forStart", getFgsAllowWiu_forStart());
        dumpReasonCode(pw, prefix, "getFgsAllowWiu_forCapabilities", getFgsAllowWiu_forCapabilities());
        pw.print(prefix);
        pw.print("allowUiJobScheduling=");
        pw.println(this.mAllowUiJobScheduling);
        pw.print(prefix);
        pw.print("recentCallingPackage=");
        pw.println(this.mRecentCallingPackage);
        pw.print(prefix);
        pw.print("recentCallingUid=");
        pw.println(this.mRecentCallingUid);
        dumpReasonCode(pw, prefix, "mAllowStart_noBinding", this.mAllowStart_noBinding);
        dumpReasonCode(pw, prefix, "mAllowStart_inBindService", this.mAllowStart_inBindService);
        dumpReasonCode(pw, prefix, "mAllowStart_byBindings", this.mAllowStart_byBindings);
        dumpReasonCode(pw, prefix, "getFgsAllowStart_legacy", getFgsAllowStart_legacy());
        dumpReasonCode(pw, prefix, "getFgsAllowStart_new", getFgsAllowStart_new());
        dumpReasonCode(pw, prefix, "getFgsAllowStart", getFgsAllowStart());
        pw.print(prefix);
        pw.print("startForegroundCount=");
        pw.println(this.mStartForegroundCount);
        pw.print(prefix);
        pw.print("infoAllowStartForeground=");
        pw.println(this.mInfoAllowStartForeground);
        if (this.delayed == false) goto L27;
        pw.print(prefix);
        pw.print("delayed=");
        pw.println(this.delayed);
    L27:
        if (this.isForeground == false) goto L29;
    L30:
        pw.print(prefix);
        pw.print("isForeground=");
        pw.print(this.isForeground);
        pw.print(" foregroundId=");
        pw.print(this.foregroundId);
        pw.printf(" types=0x%08X", new Object[]{Integer.valueOf(this.foregroundServiceType)});
        pw.print(" foregroundNoti=");
        pw.println(this.foregroundNoti);
        if (isShortFgs() == true) goto L33;
    L36:
        if (this.mIsFgsDelegate == false) goto L38;
        pw.print(prefix);
        pw.print("isFgsDelegate=");
        pw.println(this.mIsFgsDelegate);
    L38:
        pw.print(prefix);
        pw.print("createTime=");
        TimeUtils.formatDuration(this.createRealTime, nowReal, pw);
        pw.print(" startingBgTimeout=");
        TimeUtils.formatDuration(this.startingBgTimeout, now, pw);
        pw.println();
        pw.print(prefix);
        pw.print("lastActivity=");
        TimeUtils.formatDuration(this.lastActivity, now, pw);
        pw.print(" restartTime=");
        TimeUtils.formatDuration(this.restartTime, now, pw);
        pw.print(" createdFromFg=");
        pw.println(this.createdFromFg);
        if (this.pendingConnectionGroup == 0) goto L42;
        pw.print(prefix);
        pw.print(" pendingConnectionGroup=");
        pw.print(this.pendingConnectionGroup);
        pw.print(" Importance=");
        pw.println(this.pendingConnectionImportance);
    L42:
        if (this.startRequested == false) goto L44;
    L47:
        pw.print(prefix);
        pw.print("startRequested=");
        pw.print(this.startRequested);
        pw.print(" delayedStop=");
        pw.print(this.delayedStop);
        pw.print(" stopIfKilled=");
        pw.print(this.stopIfKilled);
        pw.print(" callStart=");
        pw.print(this.callStart);
        pw.print(" lastStartId=");
        pw.println(this.lastStartId);
        pw.print(" startCommandResult=");
        pw.println(this.startCommandResult);
    L49:
        if (this.executeNesting == 0) goto L52;
        pw.print(prefix);
        pw.print("executeNesting=");
        pw.print(this.executeNesting);
        pw.print(" executeFg=");
        pw.print(this.executeFg);
        pw.print(" executingStart=");
        TimeUtils.formatDuration(this.executingStart, now, pw);
        pw.println();
    L52:
        if (this.destroying == false) goto L54;
    L55:
        pw.print(prefix);
        pw.print("destroying=");
        pw.print(this.destroying);
        pw.print(" destroyTime=");
        TimeUtils.formatDuration(this.destroyTime, now, pw);
        pw.println();
    L57:
        if (this.crashCount == 0) goto L59;
    L64:
        pw.print(prefix);
        pw.print("restartCount=");
        pw.print(this.restartCount);
        pw.print(" restartDelay=");
        TimeUtils.formatDuration(this.nextRestartTime - this.mRestartSchedulingTime, now, pw);
        pw.print(" nextRestartTime=");
        TimeUtils.formatDuration(this.nextRestartTime, now, pw);
        pw.print(" crashCount=");
        pw.println(this.crashCount);
    L66:
        if (this.deliveredStarts.size() <= 0) goto L70;
        pw.print(prefix);
        pw.println("Delivered Starts:");
        dumpStartList(pw, prefix, this.deliveredStarts, now);
    L70:
        if (this.pendingStarts.size() <= 0) goto L72;
        pw.print(prefix);
        pw.println("Pending Starts:");
        String r2 = prefix;
        dumpStartList(pw, r2, this.pendingStarts, 0);
    L74:
        if (this.bindings.size() <= 0) goto L83;
        pw.print(prefix);
        pw.println("Bindings:");
        int i = 0;
    L77:
        if (i >= this.bindings.size()) goto L83;
        IntentBindRecord b = this.bindings.valueAt(i);
        pw.print(prefix);
        pw.print("* IntentBindRecord{");
        pw.print(Integer.toHexString(System.identityHashCode(b)));
        if ((b.collectFlags() & 1) == 0) goto L81;
        pw.append(" CREATE");
    L81:
        pw.println("}:");
        b.dumpInService(pw, r2 + "  ");
        i = i + 1;
    L83:
        if (this.connections.size() <= 0) goto L92;
        pw.print(prefix);
        pw.println("All Connections:");
        int conni = 0;
    L86:
        if (conni >= this.connections.size()) goto L98;
        ArrayList<ConnectionRecord> c = this.connections.valueAt(conni);
        int i2 = 0;
    L89:
        if (i2 >= c.size()) goto L91;
        pw.print(prefix);
        pw.print("  ");
        pw.println(c.get(i2));
        i2 = i2 + 1;
        goto L89
    L91:
        conni = conni + 1;
        goto L86
    L98:
        return;
    L92:
        return;
    L72:
        r2 = prefix;
        goto L74
    L59:
        if (this.restartCount != 0) goto L64;
        if ((this.nextRestartTime - this.mRestartSchedulingTime) != 0) goto L64;
        if (this.nextRestartTime == 0) goto L66;
    L54:
        if (this.destroyTime == 0) goto L57;
    L44:
        if (this.delayedStop == true) goto L47;
        if (this.lastStartId == 0) goto L49;
    L33:
        if (this.mShortFgsInfo == null) goto L36;
        pw.print(prefix);
        pw.print("isShortFgs=true");
        pw.print(" startId=");
        pw.print(this.mShortFgsInfo.getStartId());
        pw.print(" startForegroundCount=");
        pw.print(this.mShortFgsInfo.getStartForegroundCount());
        pw.print(" startTime=");
        TimeUtils.formatDuration(this.mShortFgsInfo.getStartTime(), now, pw);
        pw.print(" timeout=");
        TimeUtils.formatDuration(this.mShortFgsInfo.getTimeoutTime(), now, pw);
        pw.print(" demoteTime=");
        TimeUtils.formatDuration(this.mShortFgsInfo.getProcStateDemoteTime(), now, pw);
        pw.print(" anrTime=");
        TimeUtils.formatDuration(this.mShortFgsInfo.getAnrTime(), now, pw);
        pw.println();
        goto L36
    L29:
        if (this.foregroundId == 0) goto L36;
        goto L30
    }

    private ServiceRecord(ActivityManagerService ams) {
        this.bindings = new ArrayMap();
        this.connections = new ArrayMap();
        this.mBackgroundStartPrivilegesByStart = new ArrayList();
        this.mBackgroundStartPrivilegesByStartMerged = BackgroundStartPrivileges.NONE;
        this.mAllowWiu_noBinding = -1;
        this.mFgsEnterTime = 0;
        this.mFgsExitTime = 0;
        this.mAllowStart_noBinding = -1;
        this.mAllowStartForegroundAtEntering = -1;
        this.mAllowWiu_inBindService = -1;
        this.mAllowWiu_byBindings = -1;
        this.mAllowStart_inBindService = -1;
        this.mAllowStart_byBindings = -1;
        this.deliveredStarts = new ArrayList();
        this.pendingStarts = new ArrayList();
        this.ams = ams;
        this.name = null;
        this.instanceName = null;
        this.shortInstanceName = null;
        this.definingPackageName = null;
        this.definingUid = 0;
        this.intent = null;
        this.serviceInfo = null;
        this.userId = 0;
        this.packageName = null;
        this.processName = null;
        this.permission = null;
        this.exported = false;
        this.restarter = null;
        this.createRealTime = 0;
        this.isSdkSandbox = false;
        this.sdkSandboxClientAppUid = 0;
        this.sdkSandboxClientAppPackage = null;
        this.inSharedIsolatedProcess = false;
    }

    public static ServiceRecord newEmptyInstanceForTest(ActivityManagerService ams) {
        return new ServiceRecord(ams);
    }

    ServiceRecord(ActivityManagerService ams, ComponentName name, ComponentName instanceName, String definingPackageName, int definingUid, Intent.FilterComparison intent, ServiceInfo sInfo, boolean callerIsFg, Runnable restarter) {
        this(ams, name, instanceName, definingPackageName, definingUid, intent, sInfo, callerIsFg, restarter, sInfo.processName, -1, null, false);
    }

    ServiceRecord(ActivityManagerService ams, ComponentName name, ComponentName instanceName, String definingPackageName, int definingUid, Intent.FilterComparison intent, ServiceInfo sInfo, boolean callerIsFg, Runnable restarter, String processName, int sdkSandboxClientAppUid, String sdkSandboxClientAppPackage, boolean inSharedIsolatedProcess) {
        this.bindings = new ArrayMap();
        this.connections = new ArrayMap();
        this.mBackgroundStartPrivilegesByStart = new ArrayList();
        this.mBackgroundStartPrivilegesByStartMerged = BackgroundStartPrivileges.NONE;
        this.mAllowWiu_noBinding = -1;
        this.mFgsEnterTime = 0;
        this.mFgsExitTime = 0;
        this.mAllowStart_noBinding = -1;
        this.mAllowStartForegroundAtEntering = -1;
        this.mAllowWiu_inBindService = -1;
        this.mAllowWiu_byBindings = -1;
        this.mAllowStart_inBindService = -1;
        this.mAllowStart_byBindings = -1;
        this.deliveredStarts = new ArrayList();
        this.pendingStarts = new ArrayList();
        this.ams = ams;
        this.name = name;
        this.instanceName = instanceName;
        this.shortInstanceName = instanceName.flattenToShortString();
        this.definingPackageName = definingPackageName;
        this.definingUid = definingUid;
        this.intent = intent;
        this.serviceInfo = sInfo;
        this.appInfo = sInfo.applicationInfo;
        this.packageName = sInfo.applicationInfo.packageName;
        if (sdkSandboxClientAppUid == (-1)) goto L5;
        boolean r2 = true;
    L6:
        this.isSdkSandbox = r2;
        this.sdkSandboxClientAppUid = sdkSandboxClientAppUid;
        this.sdkSandboxClientAppPackage = sdkSandboxClientAppPackage;
        this.inSharedIsolatedProcess = inSharedIsolatedProcess;
        this.processName = processName;
        this.permission = sInfo.permission;
        this.exported = sInfo.exported;
        this.restarter = restarter;
        this.createRealTime = SystemClock.elapsedRealtime();
        this.lastActivity = SystemClock.uptimeMillis();
        this.userId = UserHandle.getUserId(this.appInfo.uid);
        this.createdFromFg = callerIsFg;
        updateKeepWarmLocked();
        updateFgsHasNotificationPermission();
        SysMonitorSvcBridge.getFactory().getAnrMonitor().notifyObjectCreate(this);
        return;
    L5:
        r2 = false;
        goto L6
    }

    public ServiceState getTracker() {
        if (this.tracker == null) goto L7;
        return this.tracker;
    L7:
        if ((this.serviceInfo.applicationInfo.flags & 8) != 0) goto L12;
        this.tracker = this.ams.mProcessStats.getServiceState(this.serviceInfo.packageName, this.serviceInfo.applicationInfo.uid, this.serviceInfo.applicationInfo.longVersionCode, this.serviceInfo.processName, this.serviceInfo.name);
        if (this.tracker == null) goto L12;
        this.tracker.applyNewOwner(this);
    L12:
        return this.tracker;
    }

    public void forceClearTracker() {
        if (this.tracker == null) goto L6;
        this.tracker.clearCurrentOwner(this, true);
        this.tracker = null;
        return;
    }

    public void makeRestarting(int memFactor, long now) {
        if (this.restartTracker == null) goto L5;
    L10:
        this.restartTracker.setRestarting(true, memFactor, now);
        return;
    L5:
        if ((this.serviceInfo.applicationInfo.flags & 8) != 0) goto L8;
        this.restartTracker = this.ams.mProcessStats.getServiceState(this.serviceInfo.packageName, this.serviceInfo.applicationInfo.uid, this.serviceInfo.applicationInfo.longVersionCode, this.serviceInfo.processName, this.serviceInfo.name);
    L8:
        if (this.restartTracker != null) goto L10;
    }

    public void setProcess(ProcessRecord proc, IApplicationThread thread, int pid, UidRecord uidRecord) {
        if (proc == null) goto L17;
        if (this.mAppForAllowingBgActivityStartsByStart == null) goto L9;
        if (this.mAppForAllowingBgActivityStartsByStart == proc) goto L9;
        this.mAppForAllowingBgActivityStartsByStart.removeBackgroundStartPrivileges(this);
        this.ams.mHandler.removeCallbacks(this.mCleanUpAllowBgActivityStartsByStartCallback);
    L9:
        if (this.mBackgroundStartPrivilegesByStartMerged.allowsAny() == false) goto L11;
        ProcessRecord r0 = proc;
    L12:
        this.mAppForAllowingBgActivityStartsByStart = r0;
        BackgroundStartPrivileges backgroundStartPrivileges = getBackgroundStartPrivilegesWithExclusiveToken();
        if (backgroundStartPrivileges.allowsAny() == false) goto L15;
        proc.addOrUpdateBackgroundStartPrivileges(this, backgroundStartPrivileges);
        goto L17
    L15:
        proc.removeBackgroundStartPrivileges(this);
        goto L17
    L11:
        r0 = null;
    L17:
        if (this.app != null) goto L19;
    L24:
        this.ams.mProcessStateController.setHostProcess(this, proc);
        updateProcessStateOnRequest();
        if (this.pendingConnectionGroup <= 0) goto L28;
        if (proc == null) goto L28;
        ProcessServiceRecord psr = proc.mServices;
        psr.setConnectionService(this);
        psr.setConnectionGroup(this.pendingConnectionGroup);
        psr.setConnectionImportance(this.pendingConnectionImportance);
        this.pendingConnectionImportance = 0;
        this.pendingConnectionGroup = 0;
    L28:
        int conni = this.connections.size() - 1;
    L29:
        if (conni < 0) goto L40;
        ArrayList<ConnectionRecord> cr = this.connections.valueAt(conni);
        int i = 0;
    L32:
        if (i >= cr.size()) goto L38;
        ConnectionRecord conn = cr.get(i);
        if (proc == null) goto L36;
        conn.startAssociationIfNeeded();
    L37:
        i = i + 1;
        goto L32
    L36:
        conn.stopAssociation();
        goto L37
    L38:
        conni = conni - 1;
        goto L29
    L40:
        if (proc == null) goto L47;
        proc.mServices.updateBoundClientUids();
        proc.mServices.updateHostingComonentTypeForBindingsLocked();
        return;
    L47:
        return;
    L19:
        if (this.app == proc) goto L24;
        if (this.mBackgroundStartPrivilegesByStartMerged.allowsNothing() == false) goto L23;
        this.app.removeBackgroundStartPrivileges(this);
    L23:
        this.app.mServices.updateBoundClientUids();
        this.app.mServices.updateHostingComonentTypeForBindingsLocked();
        goto L24
    }

    void updateProcessStateOnRequest() {
        if (this.app != null) goto L5;
    L9:
        int r0 = 20;
    L10:
        this.mProcessStateOnRequest = r0;
        return;
    L5:
        if (this.app.getThread() == null) goto L9;
        if (this.app.isKilled() == true) goto L9;
        r0 = this.app.mState.getCurProcState();
        goto L10
    }

    ArrayMap<IBinder, ArrayList<ConnectionRecord>> getConnections() {
        return this.connections;
    }

    void addConnection(IBinder binder, ConnectionRecord c) {
        ArrayList<ConnectionRecord> clist = this.connections.get(binder);
        if (clist != null) goto L5;
        clist = new ArrayList();
        this.connections.put(binder, clist);
    L5:
        clist.add(c);
        if (this.app == null) goto L9;
        this.app.mServices.addBoundClientUid(c.clientUid, c.clientPackageName, c.getFlags());
        this.app.mProfile.addHostingComponentType(512);
        return;
    }

    void removeConnection(IBinder binder) {
        this.connections.remove(binder);
        if (this.app == null) goto L6;
        this.app.mServices.updateBoundClientUids();
        this.app.mServices.updateHostingComonentTypeForBindingsLocked();
        return;
    }

    boolean canStopIfKilled(boolean isStartCanceled) {
        if (isShortFgs() == false) goto L6;
        return true;
    L6:
        if (this.startRequested == true) goto L8;
    L13:
        return false;
    L8:
        if (this.stopIfKilled == true) goto L11;
        if (isStartCanceled == false) goto L13;
    L11:
        if (this.pendingStarts.isEmpty() == false) goto L13;
        return true;
    }

    void updateIsAllowedBgActivityStartsByBinding() {
        boolean isAllowedByBinding = false;
        int conni = this.connections.size() - 1;
    L3:
        if (conni < 0) goto L14;
        ArrayList<ConnectionRecord> cr = this.connections.valueAt(conni);
        int i = 0;
    L6:
        if (i >= cr.size()) goto L11;
        if (cr.get(i).hasFlag(1048576) == true) goto L9;
        i = i + 1;
        goto L6
    L9:
        isAllowedByBinding = true;
    L11:
        if (isAllowedByBinding == true) goto L14;
        conni = conni - 1;
    L14:
        setAllowedBgActivityStartsByBinding(isAllowedByBinding);
    }

    void setAllowedBgActivityStartsByBinding(boolean newValue) {
        this.mIsAllowedBgActivityStartsByBinding = newValue;
        updateParentProcessBgActivityStartsToken();
    }

    void allowBgActivityStartsOnServiceStart(BackgroundStartPrivileges backgroundStartPrivileges) {
        Preconditions.checkArgument(backgroundStartPrivileges.allowsAny());
        this.mBackgroundStartPrivilegesByStart.add(backgroundStartPrivileges);
        setAllowedBgActivityStartsByStart(backgroundStartPrivileges.merge(this.mBackgroundStartPrivilegesByStartMerged));
        if (this.app == null) goto L6;
        this.mAppForAllowingBgActivityStartsByStart = this.app;
    L6:
        if (this.mCleanUpAllowBgActivityStartsByStartCallback != null) goto L8;
        this.mCleanUpAllowBgActivityStartsByStartCallback = new ServiceRecord$$ExternalSyntheticLambda0(this);
    L8:
        this.ams.mHandler.postDelayed(this.mCleanUpAllowBgActivityStartsByStartCallback, this.ams.mConstants.SERVICE_BG_ACTIVITY_START_TIMEOUT);
    }

    private /* synthetic */ void lambda$allowBgActivityStartsOnServiceStart$0() {
        ActivityManagerService r0 = this.ams;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mBackgroundStartPrivilegesByStart.remove(0);     // Catch: Throwable -> L11
        if (this.mBackgroundStartPrivilegesByStart.isEmpty() == true) goto L15;
        this.mBackgroundStartPrivilegesByStartMerged = BackgroundStartPrivileges.merge(this.mBackgroundStartPrivilegesByStart);     // Catch: Throwable -> L11
        if (this.mBackgroundStartPrivilegesByStartMerged.allowsAny() == true) goto L9;
        Slog.wtf(TAG, "Service callback to revoke bg activity starts by service start triggered but mBackgroundStartPrivilegesByStartMerged = " + this.mBackgroundStartPrivilegesByStartMerged + ". This should never happen.");     // Catch: Throwable -> L11
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L11
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L9:
        if (this.mAppForAllowingBgActivityStartsByStart == null) goto L21;
        this.mAppForAllowingBgActivityStartsByStart.addOrUpdateBackgroundStartPrivileges(this, getBackgroundStartPrivilegesWithExclusiveToken());     // Catch: Throwable -> L11
        goto L21
    L15:
        if (this.app != this.mAppForAllowingBgActivityStartsByStart) goto L18;
        setAllowedBgActivityStartsByStart(BackgroundStartPrivileges.NONE);     // Catch: Throwable -> L11
    L20:
        this.mAppForAllowingBgActivityStartsByStart = null;     // Catch: Throwable -> L11
        goto L21
    L18:
        if (this.mAppForAllowingBgActivityStartsByStart == null) goto L20;
        this.mAppForAllowingBgActivityStartsByStart.removeBackgroundStartPrivileges(this);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    void updateAllowUiJobScheduling(boolean allowUiJobScheduling) {
        if (this.mAllowUiJobScheduling != allowUiJobScheduling) goto L5;
        return;
    L5:
        this.mAllowUiJobScheduling = allowUiJobScheduling;
    }

    private void setAllowedBgActivityStartsByStart(BackgroundStartPrivileges newValue) {
        if (this.mBackgroundStartPrivilegesByStartMerged != newValue) goto L5;
        return;
    L5:
        this.mBackgroundStartPrivilegesByStartMerged = newValue;
        updateParentProcessBgActivityStartsToken();
    }

    private void updateParentProcessBgActivityStartsToken() {
        if (this.app != null) goto L5;
        return;
    L5:
        BackgroundStartPrivileges backgroundStartPrivileges = getBackgroundStartPrivilegesWithExclusiveToken();
        if (backgroundStartPrivileges.allowsAny() == false) goto L8;
        this.app.addOrUpdateBackgroundStartPrivileges(this, backgroundStartPrivileges);
        return;
    L8:
        this.app.removeBackgroundStartPrivileges(this);
    }

    private BackgroundStartPrivileges getBackgroundStartPrivilegesWithExclusiveToken() {
        if (this.mIsAllowedBgActivityStartsByBinding == false) goto L7;
        return BackgroundStartPrivileges.ALLOW_BAL;
    L7:
        if (this.mBackgroundStartPrivilegesByStart.isEmpty() == false) goto L11;
        return BackgroundStartPrivileges.NONE;
    L11:
        return this.mBackgroundStartPrivilegesByStartMerged;
    }

    void updateKeepWarmLocked() {
        if (this.ams.mConstants.KEEP_WARMING_SERVICES.contains(this.name) == true) goto L5;
    L11:
        boolean r0 = false;
    L12:
        this.mKeepWarming = r0;
        return;
    L5:
        if (this.ams.mUserController.getCurrentUserId() != this.userId) goto L7;
    L10:
        r0 = true;
        goto L12
    L7:
        if (this.ams.mUserController.isCurrentProfile(this.userId) == true) goto L10;
        if (this.ams.isSingleton(this.processName, this.appInfo, this.instanceName.getClassName(), this.serviceInfo.flags) == false) goto L11;
        goto L10
    }

    public AppBindRecord retrieveAppBindingLocked(Intent intent, ProcessRecord app, ProcessRecord attributedApp) {
        Intent.FilterComparison filter = new Intent.FilterComparison(intent);
        IntentBindRecord i = this.bindings.get(filter);
        if (i != null) goto L5;
        i = new IntentBindRecord(this, filter);
        this.bindings.put(filter, i);
    L5:
        AppBindRecord a = i.apps.get(app);
        if (a == null) goto L8;
        return a;
    L8:
        AppBindRecord a2 = new AppBindRecord(this, i, app, attributedApp);
        i.apps.put(app, a2);
        return a2;
    }

    public boolean hasAutoCreateConnections() {
        int conni = this.connections.size() - 1;
    L3:
        if (conni < 0) goto L12;
        ArrayList<ConnectionRecord> cr = this.connections.valueAt(conni);
        int i = 0;
    L6:
        if (i >= cr.size()) goto L11;
        if (cr.get(i).hasFlag(1) == true) goto L9;
        i = i + 1;
        goto L6
    L9:
        return true;
    L11:
        conni = conni - 1;
        goto L3
    L12:
        return false;
    }

    public void updateAllowlistManager() {
        this.allowlistManager = false;
        int conni = this.connections.size() - 1;
    L3:
        if (conni < 0) goto L14;
        ArrayList<ConnectionRecord> cr = this.connections.valueAt(conni);
        int i = 0;
    L6:
        if (i >= cr.size()) goto L12;
        if (cr.get(i).hasFlag(16777216) == true) goto L9;
        i = i + 1;
        goto L6
    L9:
        this.allowlistManager = true;
        return;
    L12:
        conni = conni - 1;
        goto L3
    }

    public void resetRestartCounter() {
        this.restartCount = 0;
        this.restartDelay = 0;
        this.restartTime = 0;
        this.mEarliestRestartTime = 0;
        this.mRestartSchedulingTime = 0;
    }

    public StartItem findDeliveredStart(int id, boolean taskRemoved, boolean remove) {
        int N = this.deliveredStarts.size();
        int i = 0;
    L3:
        if (i >= N) goto L12;
        StartItem si = this.deliveredStarts.get(i);
        if (si.id != id) goto L11;
        if (si.taskRemoved != taskRemoved) goto L11;
        if (remove == false) goto L10;
        this.deliveredStarts.remove(i);
    L10:
        return si;
    L11:
        i = i + 1;
        goto L3
    L12:
        return null;
    }

    public int getLastStartId() {
        return this.lastStartId;
    }

    public int makeNextStartId() {
        this.lastStartId++;
        if (this.lastStartId >= 1) goto L6;
        this.lastStartId = 1;
    L6:
        return this.lastStartId;
    }

    private void updateFgsHasNotificationPermission() {
        final String localPackageName = this.packageName;
        final int appUid = this.appInfo.uid;
        this.ams.mHandler.post(new AnonymousClass1(this, localPackageName, appUid));
    }

    public void postNotification(final boolean byForegroundService) {
        if (this.isForeground == false) goto L13;
        if (this.foregroundNoti == null) goto L13;
        if (this.app == null) goto L13;
        final int appUid = this.appInfo.uid;
        final int appPid = this.app.getPid();
        final String localPackageName = this.packageName;
        final int localForegroundId = this.foregroundId;
        final Notification _foregroundNoti = this.foregroundNoti;
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L11;
        Slog.d(TAG, "Posting notification " + _foregroundNoti + " for foreground service " + this);
    L11:
        this.ams.mHandler.post(new AnonymousClass2(this, localPackageName, appUid, _foregroundNoti, appPid, localForegroundId, byForegroundService, this));
        return;
    }

    public void cancelNotification() {
        final String localPackageName = this.packageName;
        final int localForegroundId = this.foregroundId;
        final int appUid = this.appInfo.uid;
        if (this.app == null) goto L6;
        int r0 = this.app.getPid();
    L5:
        final int appPid = r0;
        this.ams.mHandler.post(new AnonymousClass3(this, localPackageName, appUid, appPid, localForegroundId));
        return;
    L6:
        r0 = 0;
        goto L5
    }

    private void signalForegroundServiceNotification(String packageName, int uid, int foregroundId, boolean canceling) {
        ActivityManagerService r0 = this.ams;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        int i = this.ams.mForegroundServiceStateListeners.size() - 1;     // Catch: Throwable -> L7
    L5:
        if (i < 0) goto L10;
        this.ams.mForegroundServiceStateListeners.get(i).onForegroundServiceNotificationUpdated(packageName, this.appInfo.uid, foregroundId, canceling);     // Catch: Throwable -> L7
        i = i - 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L7:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void stripForegroundServiceFlagFromNotification() {
        final int localForegroundId = this.foregroundId;
        final int localUserId = this.userId;
        final String localPackageName = this.packageName;
        this.ams.mHandler.post(new AnonymousClass4(this, localPackageName, localForegroundId, localUserId));
    }

    public void clearDeliveredStartsLocked() {
        int i = this.deliveredStarts.size() - 1;
    L3:
        if (i < 0) goto L5;
        this.deliveredStarts.get(i).removeUriPermissionsLocked();
        i = i - 1;
        goto L3
    L5:
        this.deliveredStarts.clear();
    }

    public String toString() {
        if (this.stringName != null) goto L5;
        StringBuilder sb = new StringBuilder(128);
        sb.append("ServiceRecord{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" u");
        sb.append(this.userId);
        sb.append(' ');
        sb.append(this.shortInstanceName);
        if (this.mRecentCallingPackage == null) goto L9;
        sb.append(" c:");
        sb.append(this.mRecentCallingPackage);
    L9:
        sb.append('}');
        String r1 = sb.toString();
        this.stringName = r1;
        return r1;
    L5:
        return this.stringName;
    }

    public ComponentName getComponentName() {
        return this.name;
    }

    public boolean isShortFgs() {
        if (this.startRequested == true) goto L5;
    L9:
        return false;
    L5:
        if (this.isForeground == false) goto L9;
        if (this.foregroundServiceType != 2048) goto L9;
        return true;
    }

    public ShortFgsInfo getShortFgsInfo() {
        if (isShortFgs() == true) goto L7;
        return null;
    L7:
        return this.mShortFgsInfo;
    }

    public void setShortFgsInfo(long uptimeNow) {
        this.mShortFgsInfo = new ShortFgsInfo(this, uptimeNow);
    }

    public boolean hasShortFgsInfo() {
        if (this.mShortFgsInfo == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void clearShortFgsInfo() {
        this.mShortFgsInfo = null;
    }

    private boolean shouldTriggerShortFgsTimedEvent(long targetTime, long nowUptime) {
        if (isAppAlive() == true) goto L6;
        return false;
    L6:
        if (this.startRequested == true) goto L8;
    L18:
        return false;
    L8:
        if (isShortFgs() == false) goto L18;
        if (this.mShortFgsInfo == null) goto L18;
        if (this.mShortFgsInfo.isCurrent() == false) goto L18;
        if (targetTime > nowUptime) goto L19;
        return true;
    L19:
        return false;
    }

    public boolean shouldTriggerShortFgsTimeout(long nowUptime) {
        if (this.mShortFgsInfo != null) goto L5;
        long r0 = 0;
    L7:
        return shouldTriggerShortFgsTimedEvent(r0, nowUptime);
    L5:
        r0 = this.mShortFgsInfo.getTimeoutTime();
        goto L7
    }

    public boolean shouldDemoteShortFgsProcState(long nowUptime) {
        if (this.mShortFgsInfo != null) goto L5;
        long r0 = 0;
    L7:
        return shouldTriggerShortFgsTimedEvent(r0, nowUptime);
    L5:
        r0 = this.mShortFgsInfo.getProcStateDemoteTime();
        goto L7
    }

    public boolean shouldTriggerShortFgsAnr(long nowUptime) {
        if (this.mShortFgsInfo != null) goto L5;
        long r0 = 0;
    L7:
        return shouldTriggerShortFgsTimedEvent(r0, nowUptime);
    L5:
        r0 = this.mShortFgsInfo.getAnrTime();
        goto L7
    }

    public String getShortFgsTimedEventDescription(long nowUptime) {
        StringBuilder r0 = new StringBuilder();
        r0.append("aa=");
        r0.append(isAppAlive());
        r0.append(" sreq=");
        r0.append(this.startRequested);
        r0.append(" isfg=");
        r0.append(this.isForeground);
        r0.append(" type=");
        r0.append(Integer.toHexString(this.foregroundServiceType));
        r0.append(" sfc=");
        r0.append(this.mStartForegroundCount);
        r0.append(" now=");
        r0.append(nowUptime);
        r0.append(" ");
        if (this.mShortFgsInfo != null) goto L5;
        String r1 = "";
    L6:
        r0.append(r1);
        return r0.toString();
    L5:
        r1 = this.mShortFgsInfo.getDescription();
        goto L6
    }

    public TimeLimitedFgsInfo createTimeLimitedFgsInfo() {
        return new TimeLimitedFgsInfo();
    }

    public boolean isFgsTimeLimited() {
        if (this.startRequested == true) goto L5;
    L9:
        return false;
    L5:
        if (this.isForeground == false) goto L9;
        if (this.ams.mServices.getTimeLimitedFgsType(this.foregroundServiceType) == 0) goto L9;
        return true;
    }

    private boolean isAppAlive() {
        if (this.app != null) goto L6;
        return false;
    L6:
        if (this.app.getThread() != null) goto L8;
    L14:
        return false;
    L8:
        if (this.app.isKilled() == true) goto L14;
        if (this.app.isKilledByAm() == true) goto L14;
        return true;
    }

    boolean wasOomAdjUpdated() {
        if (this.app != null) goto L5;
    L7:
        return false;
    L5:
        if (this.app.mState.getAdjSeq() <= this.mAdjSeq) goto L7;
        return true;
    }

    void updateOomAdjSeq() {
        if (this.app == null) goto L6;
        this.mAdjSeq = this.app.mState.getAdjSeq();
        return;
    }
}
