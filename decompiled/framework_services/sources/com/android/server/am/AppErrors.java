package com.android.server.am;

import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.AnrController;
import android.app.ApplicationErrorReport;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.VersionedPackage;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.EventLog;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.TimeUtils;
import android.util.Utils;
import android.util.proto.ProtoOutputStream;
import com.android.internal.app.ProcessMap;
import com.android.internal.logging.MetricsLogger;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.LocalServices;
import com.android.server.PackageWatchdog;
import com.android.server.pm.UserManagerInternal;
import com.android.server.usage.AppStandbyInternal;
import com.android.server.wm.WindowProcessController;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class AppErrors {
    private static final String TAG = "ActivityManager";
    private ArraySet<String> mAppsNotReportingCrashes;
    private final Object mBadProcessLock;
    private volatile ProcessMap<BadProcessInfo> mBadProcesses;
    private final Context mContext;
    private final PackageWatchdog mPackageWatchdog;
    private final ActivityManagerGlobalLock mProcLock;
    private final ProcessMap<Pair<Long, Integer>> mProcessCrashCounts;
    private final ProcessMap<Long> mProcessCrashShowDialogTimes;
    private final ProcessMap<Long> mProcessCrashTimes;
    private final ProcessMap<Long> mProcessCrashTimesPersistent;
    private final ActivityManagerService mService;

    static final class BadProcessInfo {
        final String longMsg;
        final String shortMsg;
        final String stack;
        final long time;

        BadProcessInfo(long time, String shortMsg, String longMsg, String stack) {
            this.time = time;
            this.shortMsg = shortMsg;
            this.longMsg = longMsg;
            this.stack = stack;
        }
    }

    public static /* synthetic */ void $r8$lambda$tahYgIQkTlfUILZTTqiIS49S4Gc(AppErrors r0, ProcessRecord r1) {
        r0.lambda$scheduleAppCrashLocked$0(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$w69pU-431_pyGi3C_XWfp6yr4Mg, reason: not valid java name */
    public static /* synthetic */ void m1289$r8$lambda$w69pU431_pyGi3C_XWfp6yr4Mg(AppErrors r0, ApplicationErrorReport.CrashInfo r1, String r2, int r3, ProcessRecord r4, String r5, String r6, String r7, int r8) {
        r0.lambda$handleAppCrashInActivityController$1(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    AppErrors(Context context, ActivityManagerService service, PackageWatchdog watchdog) {
        this.mProcessCrashTimes = new ProcessMap();
        this.mProcessCrashTimesPersistent = new ProcessMap();
        this.mProcessCrashShowDialogTimes = new ProcessMap();
        this.mProcessCrashCounts = new ProcessMap();
        this.mBadProcesses = new ProcessMap();
        this.mBadProcessLock = new Object();
        context.assertRuntimeOverlayThemable();
        this.mService = service;
        this.mProcLock = service.mProcLock;
        this.mContext = context;
        this.mPackageWatchdog = watchdog;
    }

    public void resetState() {
        Slog.i(TAG, "Resetting AppErrors");
        Object r0 = this.mBadProcessLock;
        monitor-enter(r0);
        this.mAppsNotReportingCrashes.clear();     // Catch: Throwable -> L7
        this.mProcessCrashTimes.clear();     // Catch: Throwable -> L7
        this.mProcessCrashTimesPersistent.clear();     // Catch: Throwable -> L7
        this.mProcessCrashShowDialogTimes.clear();     // Catch: Throwable -> L7
        this.mProcessCrashCounts.clear();     // Catch: Throwable -> L7
        this.mBadProcesses = new ProcessMap();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void dumpDebugLPr(ProtoOutputStream proto, long fieldId, String dumpPackage) {
        AppErrors r1 = this;
        String r3 = dumpPackage;
        ProcessMap<BadProcessInfo> badProcesses = r1.mBadProcesses;
        if (r1.mProcessCrashTimes.getMap().isEmpty() == true) goto L5;
    L7:
        long token = proto.start(fieldId);
        long now = SystemClock.uptimeMillis();
        proto.write(1112396529665L, now);
        if (badProcesses.getMap().isEmpty() == true) goto L26;
        ArrayMap<String, SparseArray<BadProcessInfo>> pmap = badProcesses.getMap();
        int processCount = pmap.size();
        int ip = 0;
    L10:
        if (ip >= processCount) goto L26;
        long btoken = proto.start(2246267895811L);
        String pname = pmap.keyAt(ip);
        SparseArray<BadProcessInfo> uids = pmap.valueAt(ip);
        int uidCount = uids.size();
        long now2 = now;
        proto.write(1138166333441L, pname);
        int i = 0;
    L12:
        if (i >= uidCount) goto L23;
        int puid = uids.keyAt(i);
        ArrayMap<String, SparseArray<BadProcessInfo>> pmap2 = pmap;
        ProcessRecord r = (ProcessRecord) r1.mService.getProcessNamesLOSP().get(pname, puid);
        if (r3 == null) goto L21;
        if (r == null) goto L22;
        if (r.getPkgList().containsKey(r3) == true) goto L21;
    L22:
        i = i + 1;
        pmap = pmap2;
        ip = ip;
        pname = pname;
        uids = uids;
        uidCount = uidCount;
    L21:
        BadProcessInfo info = uids.valueAt(i);
        long etoken = proto.start(2246267895810L);
        proto.write(1120986464257L, puid);
        proto.write(1112396529666L, info.time);
        proto.write(1138166333443L, info.shortMsg);
        proto.write(1138166333444L, info.longMsg);
        proto.write(1138166333445L, info.stack);
        proto.end(etoken);
        goto L22
    L23:
        proto.end(btoken);
        ip = ip + 1;
        now = now2;
    L26:
        Object r7 = r1.mBadProcessLock;
        monitor-enter(r7);
    L52:
        th = th;
    L60:
        monitor-exit(r7);     // Catch: Throwable -> L50
        throw th;
    L29:
        if (r1.mProcessCrashTimes.getMap().isEmpty() == true) goto L57;
        ArrayMap<String, SparseArray<Long>> pmap3 = r1.mProcessCrashTimes.getMap();     // Catch: Throwable -> L52
        int procCount = pmap3.size();     // Catch: Throwable -> L52
        int ip2 = 0;
    L31:
        if (ip2 >= procCount) goto L57;
        long ctoken = proto.start(2246267895810L);     // Catch: Throwable -> L52
        String pname2 = pmap3.keyAt(ip2);     // Catch: Throwable -> L52
        SparseArray<Long> uids2 = pmap3.valueAt(ip2);     // Catch: Throwable -> L52
        int uidCount2 = uids2.size();     // Catch: Throwable -> L52
        int procCount2 = procCount;
        int ip3 = ip2;
        proto.write(1138166333441L, pname2);     // Catch: Throwable -> L52
        int i2 = 0;
    L33:
        if (i2 >= uidCount2) goto L54;
        int puid2 = uids2.keyAt(i2);     // Catch: Throwable -> L52
        ArrayMap<String, SparseArray<Long>> pmap4 = pmap3;
        ProcessRecord r2 = (ProcessRecord) r1.mService.getProcessNamesLOSP().get(pname2, puid2);     // Catch: Throwable -> L52
        if (r3 == null) goto L46;
        if (r2 == null) goto L66;
        if (r2.getPkgList().containsKey(r3) == true) goto L46;
    L41:
        th = th;
    L66:
        i2 = i2 + 1;     // Catch: Throwable -> L50
        r1 = this;
        r3 = dumpPackage;
        badProcesses = badProcesses;
        pmap3 = pmap4;
    L50:
        th = th;
    L46:
        long etoken2 = proto.start(2246267895810L);     // Catch: Throwable -> L52
        proto.write(1120986464257L, puid2);     // Catch: Throwable -> L52
        proto.write(1112396529666L, uids2.valueAt(i2).longValue());     // Catch: Throwable -> L50
        proto.end(etoken2);     // Catch: Throwable -> L50
        goto L66
    L54:
        proto.end(ctoken);     // Catch: Throwable -> L50
        ip2 = ip3 + 1;     // Catch: Throwable -> L50
        r1 = this;
        r3 = dumpPackage;
        procCount = procCount2;
        badProcesses = badProcesses;
        pmap3 = pmap3;
    L57:
        monitor-exit(r7);     // Catch: Throwable -> L50
        proto.end(token);
        return;
    L5:
        if (badProcesses.getMap().isEmpty() == false) goto L7;
    }

    boolean dumpLPr(FileDescriptor fd, PrintWriter pw, boolean needSep, String dumpPackage) {
        AppErrors r1 = this;
        String r3 = dumpPackage;
        long now = SystemClock.uptimeMillis();
        Object r6 = r1.mBadProcessLock;
        monitor-enter(r6);
    L40:
        th = th;
    L103:
        monitor-exit(r6);     // Catch: Throwable -> L34
        throw th;
    L5:
        if (r1.mProcessCrashTimes.getMap().isEmpty() == true) goto L42;
        boolean printed = false;
        ArrayMap<String, SparseArray<Long>> pmap = r1.mProcessCrashTimes.getMap();     // Catch: Throwable -> L40
        int processCount = pmap.size();     // Catch: Throwable -> L40
        int ip = 0;
        boolean needSep2 = needSep;
    L8:
        if (ip >= processCount) goto L39;
        String pname = pmap.keyAt(ip);     // Catch: Throwable -> L36
        SparseArray<Long> uids = pmap.valueAt(ip);     // Catch: Throwable -> L36
        int uidCount = uids.size();     // Catch: Throwable -> L36
        int i = 0;
    L10:
        if (i >= uidCount) goto L38;
        int puid = uids.keyAt(i);     // Catch: Throwable -> L36
        boolean printed2 = printed;
        ProcessRecord r = (ProcessRecord) r1.mService.getProcessNamesLOSP().get(pname, puid);     // Catch: Throwable -> L36
        if (r3 == null) goto L23;
        if (r == null) goto L21;
        if (r.getPkgList().containsKey(r3) == true) goto L23;
    L18:
        th = th;
    L21:
        long now2 = now;
        printed = printed2;
    L107:
        i = i + 1;     // Catch: Throwable -> L34
        now = now2;
    L34:
        th = th;
    L23:
        if (printed2 == true) goto L28;
        if (needSep2 == false) goto L26;
        pw.println();     // Catch: Throwable -> L18
    L26:
        needSep2 = true;
        pw.println("  Time since processes crashed:");     // Catch: Throwable -> L18
        boolean printed3 = true;
    L29:
        boolean printed4 = printed3;
        pw.print("    Process ");     // Catch: Throwable -> L36
        pw.print(pname);     // Catch: Throwable -> L36
        pw.print(" uid ");     // Catch: Throwable -> L36
        pw.print(puid);     // Catch: Throwable -> L36
        pw.print(": last crashed ");     // Catch: Throwable -> L36
        now2 = now;
        TimeUtils.formatDuration(now2 - uids.valueAt(i).longValue(), pw);     // Catch: Throwable -> L34
        pw.println(" ago");     // Catch: Throwable -> L34
        printed = printed4;
        goto L107
    L28:
        printed3 = printed2;
        goto L29
    L38:
        ip = ip + 1;     // Catch: Throwable -> L34
    L36:
        th = th;
        goto L103
    L39:
        long now3 = now;
    L44:
        if (r1.mProcessCrashCounts.getMap().isEmpty() == true) goto L63;
        boolean printed5 = false;
        ArrayMap<String, SparseArray<Pair<Long, Integer>>> pmap2 = r1.mProcessCrashCounts.getMap();     // Catch: Throwable -> L34
        int processCount2 = pmap2.size();     // Catch: Throwable -> L34
        int ip2 = 0;
    L46:
        if (ip2 >= processCount2) goto L63;
        String pname2 = pmap2.keyAt(ip2);     // Catch: Throwable -> L34
        SparseArray<Pair<Long, Integer>> uids2 = pmap2.valueAt(ip2);     // Catch: Throwable -> L34
        int uidCount2 = uids2.size();     // Catch: Throwable -> L34
        int i2 = 0;
    L48:
        if (i2 >= uidCount2) goto L61;
        int puid2 = uids2.keyAt(i2);     // Catch: Throwable -> L34
        ProcessRecord r2 = (ProcessRecord) r1.mService.getProcessNamesLOSP().get(pname2, puid2);     // Catch: Throwable -> L34
        if (r3 == null) goto L55;
        if (r2 == null) goto L60;
        if (r2.getPkgList().containsKey(r3) == true) goto L55;
    L60:
        i2 = i2 + 1;     // Catch: Throwable -> L34
        pmap2 = pmap2;
        processCount2 = processCount2;
    L55:
        if (printed5 == true) goto L59;
        if (needSep2 == false) goto L58;
        pw.println();     // Catch: Throwable -> L34
    L58:
        needSep2 = true;
        pw.println("  First time processes crashed and counts:");     // Catch: Throwable -> L34
        printed5 = true;
    L59:
        pw.print("    Process ");     // Catch: Throwable -> L34
        pw.print(pname2);     // Catch: Throwable -> L34
        pw.print(" uid ");     // Catch: Throwable -> L34
        pw.print(puid2);     // Catch: Throwable -> L34
        pw.print(": first crashed ");     // Catch: Throwable -> L34
        TimeUtils.formatDuration(now3 - ((Long) uids2.valueAt(i2).first).longValue(), pw);     // Catch: Throwable -> L34
        pw.print(" ago; crashes since then: ");     // Catch: Throwable -> L34
        pw.println(uids2.valueAt(i2).second);     // Catch: Throwable -> L34
        goto L60
    L61:
        ip2 = ip2 + 1;     // Catch: Throwable -> L34
    L63:
        monitor-exit(r6);     // Catch: Throwable -> L34
        ProcessMap<BadProcessInfo> badProcesses = r1.mBadProcesses;
        if (badProcesses.getMap().isEmpty() == true) goto L102;
        boolean printed6 = false;
        ArrayMap<String, SparseArray<BadProcessInfo>> pmap3 = badProcesses.getMap();
        int processCount3 = pmap3.size();
        int ip3 = 0;
    L67:
        if (ip3 >= processCount3) goto L102;
        String pname3 = pmap3.keyAt(ip3);
        SparseArray<BadProcessInfo> uids3 = pmap3.valueAt(ip3);
        int uidCount3 = uids3.size();
        int i3 = 0;
    L69:
        if (i3 >= uidCount3) goto L99;
        int puid3 = uids3.keyAt(i3);
        ProcessRecord r4 = (ProcessRecord) r1.mService.getProcessNamesLOSP().get(pname3, puid3);
        if (r3 == null) goto L76;
        if (r4 != null) goto L74;
    L75:
        ProcessMap<BadProcessInfo> badProcesses2 = badProcesses;
    L98:
        i3 = i3 + 1;
        r1 = this;
        r3 = dumpPackage;
        badProcesses = badProcesses2;
        goto L69
    L74:
        if (r4.getPkgList().containsKey(r3) == false) goto L75;
    L76:
        if (printed6 == true) goto L80;
        if (needSep2 == false) goto L79;
        pw.println();
    L79:
        needSep2 = true;
        pw.println("  Bad processes:");
        printed6 = true;
    L80:
        BadProcessInfo info = uids3.valueAt(i3);
        badProcesses2 = badProcesses;
        pw.print("    Bad process ");
        pw.print(pname3);
        pw.print(" uid ");
        pw.print(puid3);
        pw.print(": crashed at time ");
        pw.println(info.time);
        if (info.shortMsg == null) goto L84;
        pw.print("      Short msg: ");
        pw.println(info.shortMsg);
    L84:
        if (info.longMsg == null) goto L87;
        pw.print("      Long msg: ");
        pw.println(info.longMsg);
    L87:
        if (info.stack == null) goto L98;
        pw.println("      Stack:");
        int lastPos = 0;
        int pos = 0;
    L90:
        if (pos >= info.stack.length()) goto L96;
        int pos2 = pos;
        if (info.stack.charAt(pos) != '\n') goto L94;
        pw.print("        ");
        pw.write(info.stack, lastPos, pos2 - lastPos);
        pw.println();
        lastPos = pos2 + 1;
    L94:
        pos = pos2 + 1;
        goto L90
    L96:
        if (lastPos >= info.stack.length()) goto L98;
        pw.print("        ");
        pw.write(info.stack, lastPos, info.stack.length() - lastPos);
        pw.println();
        goto L98
    L99:
        ip3 = ip3 + 1;
        r1 = this;
        r3 = dumpPackage;
    L102:
        return needSep2;
    L42:
        now3 = now;
        needSep2 = needSep;
        goto L44
    }

    boolean isBadProcess(String processName, int uid) {
        if (this.mBadProcesses.get(processName, uid) == null) goto L5;
        return true;
    L5:
        return false;
    }

    void clearBadProcess(String processName, int uid) {
        Object r0 = this.mBadProcessLock;
        monitor-enter(r0);
        ProcessMap<BadProcessInfo> badProcesses = new ProcessMap();     // Catch: Throwable -> L7
        badProcesses.putAll(this.mBadProcesses);     // Catch: Throwable -> L7
        badProcesses.remove(processName, uid);     // Catch: Throwable -> L7
        this.mBadProcesses = badProcesses;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void clearBadProcessForUser(String processName, int userId) {
        Object r0 = this.mBadProcessLock;
        monitor-enter(r0);
        ProcessMap<BadProcessInfo> badProcesses = new ProcessMap();     // Catch: Throwable -> L8
        badProcesses.putAll(this.mBadProcesses);     // Catch: Throwable -> L8
        SparseArray<BadProcessInfo> uids = badProcesses.get(processName);     // Catch: Throwable -> L8
        if (uids != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        int i = uids.size() - 1;     // Catch: Throwable -> L8
    L11:
        if (i < 0) goto L18;
        int uid = uids.keyAt(i);     // Catch: Throwable -> L8
        if (userId != (-1)) goto L15;
    L16:
        badProcesses.remove(processName, uid);     // Catch: Throwable -> L8
    L17:
        i = i - 1;     // Catch: Throwable -> L8
        goto L11
    L15:
        if (userId != UserHandle.getUserId(uid)) goto L17;
    L18:
        this.mBadProcesses = badProcesses;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void markBadProcess(String processName, int uid, BadProcessInfo info) {
        Object r0 = this.mBadProcessLock;
        monitor-enter(r0);
        ProcessMap<BadProcessInfo> badProcesses = new ProcessMap();     // Catch: Throwable -> L7
        badProcesses.putAll(this.mBadProcesses);     // Catch: Throwable -> L7
        badProcesses.put(processName, uid, info);     // Catch: Throwable -> L7
        this.mBadProcesses = badProcesses;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void resetProcessCrashTime(String processName, int uid) {
        Object r0 = this.mBadProcessLock;
        monitor-enter(r0);
        this.mProcessCrashTimes.remove(processName, uid);     // Catch: Throwable -> L7
        this.mProcessCrashCounts.remove(processName, uid);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void resetProcessCrashTime(boolean resetEntireUser, int appId, int userId) {
        Object r0 = this.mBadProcessLock;
        monitor-enter(r0);
        ArrayMap<String, SparseArray<Long>> pTimeMap = this.mProcessCrashTimes.getMap();     // Catch: Throwable -> L9
        int ip = pTimeMap.size() - 1;     // Catch: Throwable -> L9
    L5:
        if (ip < 0) goto L12;
        SparseArray<Long> ba = pTimeMap.valueAt(ip);     // Catch: Throwable -> L9
        resetProcessCrashMapLBp(ba, resetEntireUser, appId, userId);     // Catch: Throwable -> L9
        if (ba.size() != 0) goto L11;
        pTimeMap.removeAt(ip);     // Catch: Throwable -> L9
    L11:
        ip = ip - 1;     // Catch: Throwable -> L9
        goto L5
    L12:
        ArrayMap<String, SparseArray<Pair<Long, Integer>>> pCountMap = this.mProcessCrashCounts.getMap();     // Catch: Throwable -> L9
        int ip2 = pCountMap.size() - 1;     // Catch: Throwable -> L9
    L13:
        if (ip2 < 0) goto L19;
        SparseArray<Pair<Long, Integer>> ba2 = pCountMap.valueAt(ip2);     // Catch: Throwable -> L9
        resetProcessCrashMapLBp(ba2, resetEntireUser, appId, userId);     // Catch: Throwable -> L9
        if (ba2.size() != 0) goto L17;
        pCountMap.removeAt(ip2);     // Catch: Throwable -> L9
    L17:
        ip2 = ip2 - 1;     // Catch: Throwable -> L9
        goto L13
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void resetProcessCrashMapLBp(SparseArray<?> ba, boolean resetEntireUser, int appId, int userId) {
        int i = ba.size() - 1;
    L3:
        if (i < 0) goto L21;
        boolean remove = false;
        int entUid = ba.keyAt(i);
        if (resetEntireUser == true) goto L15;
        if (userId != (-1)) goto L12;
        if (UserHandle.getAppId(entUid) != appId) goto L17;
        remove = true;
    L17:
        if (remove == false) goto L19;
        ba.removeAt(i);
    L19:
        i = i - 1;
        goto L3
    L12:
        if (entUid != UserHandle.getUid(userId, appId)) goto L17;
        remove = true;
        goto L17
    L15:
        if (UserHandle.getUserId(entUid) != userId) goto L17;
        remove = true;
        goto L17
    }

    void loadAppsNotReportingCrashesFromConfig(String appsNotReportingCrashesConfig) {
        if (appsNotReportingCrashesConfig == null) goto L13;
        String[] split = appsNotReportingCrashesConfig.split(",");
        if (split.length <= 0) goto L16;
        Object r1 = this.mBadProcessLock;
        monitor-enter(r1);
        this.mAppsNotReportingCrashes = new ArraySet();     // Catch: Throwable -> L10
        Collections.addAll(this.mAppsNotReportingCrashes, split);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    L16:
        return;
    }

    int killAppAtUserRequestLocked(ProcessRecord app) {
        ErrorDialogController controller = app.mErrorState.getDialogController();
        int clientPid = app.getPid();
        ActivityManagerGlobalLock r6 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r6);
        if (controller.hasDebugWaitingDialog() == false) goto L7;
        int reasonCode = 13;
        int subReason = 1;
    L33:
        ProcessErrorStateRecord errState = app.mErrorState;     // Catch: Throwable -> L20
        boolean isNotResponding = errState.isNotResponding();     // Catch: Throwable -> L20
        controller.clearAllErrorDialogs();     // Catch: Throwable -> L20
        killAppImmediateLSP(app, reasonCode, subReason, "user-terminated", "user request after error");     // Catch: Throwable -> L18
        monitor-exit(r6);     // Catch: Throwable -> L18
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        if (isNotResponding == false) goto L16;
        if (clientPid <= 0) goto L39;
        return clientPid;
    L39:
        return -1;
    L16:
        return -1;
    L18:
        th = move-exception;
        Throwable r14 = th;
    L31:
        monitor-exit(r6);     // Catch: Throwable -> L27
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw r14;
    L27:
        th = move-exception;
        r14 = th;
    L20:
        th = move-exception;
        r14 = th;
        goto L31
    L7:
        reasonCode = 6;
        subReason = 0;
    L22:
        th = move-exception;
        r14 = th;
        goto L31
    }

    private void killAppImmediateLSP(ProcessRecord app, int reasonCode, int subReason, String reason, String killReason) {
        ProcessErrorStateRecord errState = app.mErrorState;
        errState.setCrashing(false);
        errState.setCrashingReport(null);
        errState.setNotResponding(false);
        errState.setNotRespondingReport(null);
        int pid = errState.mApp.getPid();
        if (pid <= 0) goto L19;
        if (pid == ActivityManagerService.MY_PID) goto L19;
        Object r3 = this.mBadProcessLock;
        monitor-enter(r3);
        handleAppCrashLSPB(app, reason, null, null, null, null);     // Catch: Throwable -> L12
        monitor-exit(r3);     // Catch: Throwable -> L12
        app.killLocked(killReason, reasonCode, subReason, true);
        return;
    L12:
        th = th;
    L22:
        throw th;
    L16:
        th = th;
    }

    void scheduleAppCrashLocked(int uid, int initialPid, String packageName, int userId, String message, boolean force, int exceptionTypeId, Bundle extras) {
        ProcessRecord proc = null;
        ActivityManagerService.PidMap r1 = this.mService.mPidsSelfLocked;
        monitor-enter(r1);
        int i = 0;
    L44:
    L12:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mService.mPidsSelfLocked.size()) goto L24;
        ProcessRecord p = this.mService.mPidsSelfLocked.valueAt(i);     // Catch: Throwable -> L12
        if (uid < 0) goto L15;
        if (p.uid == uid) goto L15;
    L23:
        i = i + 1;     // Catch: Throwable -> L12
    L15:
        if (p.getPid() == initialPid) goto L16;
        if (p.getPkgList().containsKey(packageName) == false) goto L23;
        if (userId >= 0) goto L21;
    L22:
        proc = p;
        goto L23
    L21:
        if (p.userId != userId) goto L23;
    L16:
        proc = p;
    L24:
        monitor-exit(r1);     // Catch: Throwable -> L12
        if (proc != null) goto L29;
        Slog.w(TAG, "crashApplication: nothing for uid=" + uid + " initialPid=" + initialPid + " packageName=" + packageName + " userId=" + userId);
        return;
    L29:
        if (exceptionTypeId != 5) goto L38;
        String[] packages = proc.getPackageList();
        int i2 = 0;
    L32:
        if (i2 >= packages.length) goto L38;
        if (this.mService.mPackageManagerInt.isPackageStateProtected(packages[i2], proc.userId) == true) goto L35;
        i2 = i2 + 1;
        goto L32
    L35:
        Slog.w(TAG, "crashApplication: Can not crash protected package " + packages[i2]);
        return;
    L38:
        this.mService.mOomAdjuster.mCachedAppOptimizer.unfreezeProcess(initialPid, 12);
        proc.scheduleCrashLocked(message, exceptionTypeId, extras);
        if (force == false) goto L54;
        final ProcessRecord p2 = proc;
        this.mService.mHandler.postDelayed(new AppErrors$$ExternalSyntheticLambda0(this, p2), 5000);
        return;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    private /* synthetic */ void lambda$scheduleAppCrashLocked$0(ProcessRecord p) {
        ActivityManagerService r1 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        ActivityManagerGlobalLock r2 = this.mProcLock;     // Catch: Throwable -> L23
        ActivityManagerService.boostPriorityForProcLockedSection();     // Catch: Throwable -> L23
        monitor-enter(r2);     // Catch: Throwable -> L23
        killAppImmediateLSP(p, 13, 14, "forced", "killed for invalid state");     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L16
        ActivityManagerService.resetPriorityAfterProcLockedSection();     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L16:
        th = move-exception;
        monitor-exit(r2);     // Catch: Throwable -> L16
        ActivityManagerService.resetPriorityAfterProcLockedSection();     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L23:
        th = move-exception;
        Throwable r10 = th;
    L25:
        monitor-exit(r1);     // Catch: Throwable -> L14
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw r10;
    L14:
        th = move-exception;
        r10 = th;
        goto L25
    }

    void sendRecoverableCrashToAppExitInfo(ProcessRecord r, ApplicationErrorReport.CrashInfo crashInfo) {
        if (r == null) goto L17;
        if (crashInfo != null) goto L5;
        return;
    L5:
        if ("Native crash".equals(crashInfo.exceptionClassName) == false) goto L21;
        ActivityManagerService r0 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mService.mProcessList.noteAppRecoverableCrash(r);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L13:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L21:
        return;
    }

    void crashApplication(ProcessRecord r, ApplicationErrorReport.CrashInfo crashInfo) {
        int callingPid = Binder.getCallingPid();
        int callingUid = Binder.getCallingUid();
        long origId = Binder.clearCallingIdentity();
        this.mService.mWindowManager.getObricExt().reportError(r.getWindowProcessController(), 2);     // Catch: Throwable -> L6
        crashApplicationInner(r, crashInfo, callingPid, callingUid);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(origId);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    private void crashApplicationInner(ProcessRecord r, ApplicationErrorReport.CrashInfo crashInfo, int callingPid, int callingUid) {
        ProcessRecord r2 = r;
        long timeMillis = System.currentTimeMillis();
        String shortMsg = crashInfo.exceptionClassName;
        String longMsg = crashInfo.exceptionMessage;
        String stackTrace = crashInfo.stackTrace;
        if (shortMsg == null) goto L6;
        if (longMsg == null) goto L6;
        String longMsg2 = shortMsg + ": " + longMsg;
    L10:
        if (r2 == null) goto L24;
        this.mPackageWatchdog.notifyPackageFailure(r2.getPackageListWithVersionCode(), 3);
        ActivityManagerService r9 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r9);
        ProcessList r0 = this.mService.mProcessList;     // Catch: Throwable -> L20
        if ("Native crash".equals(crashInfo.exceptionClassName) == false) goto L16;
        int r10 = 5;
    L17:
        r0.noteAppKill(r2, r10, 0, "crash");     // Catch: Throwable -> L20
        monitor-exit(r9);     // Catch: Throwable -> L20
        ActivityManagerService.resetPriorityAfterLockedSection();
        goto L24
    L16:
        r10 = 4;
    L20:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L24:
        if (r2 == null) goto L26;
        int r1 = r2.getWindowProcessController().computeRelaunchReason();
    L27:
        int relaunchReason = r1;
        AppErrorResult result = new AppErrorResult();
        if (r2 != null) goto L30;
    L34:
        boolean isUiThread = false;
    L35:
        ActivityManagerService r15 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r15);
        String longMsg3 = longMsg2;
        if (handleAppCrashInActivityController(r2, crashInfo, shortMsg, longMsg3, stackTrace, timeMillis, callingPid, callingUid) == false) goto L47;
        monitor-exit(r15);     // Catch: Throwable -> L44
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L47:
        if (relaunchReason != 2) goto L51;
        monitor-exit(r15);     // Catch: Throwable -> L44
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L51:
        if (r2 != null) goto L53;
    L57:
        if (r2 == null) goto L183;
        this.mService.mBatteryStatsService.noteProcessCrash(r2.processName, r2.uid);     // Catch: Throwable -> L44
    L183:
        AppErrorDialog.Data data = new AppErrorDialog.Data();     // Catch: Throwable -> L155
        data.result = result;     // Catch: Throwable -> L155
        data.proc = r2;     // Catch: Throwable -> L155
        if (r2 == null) goto L158;
        if (makeAppCrashingLocked(r2, shortMsg, longMsg3, stackTrace, data) == false) goto L158;
        if (isUiThread == false) goto L72;
        Slog.i(TAG, "android.ui crash, don't show error dialog!");     // Catch: Throwable -> L70
        monitor-exit(r15);     // Catch: Throwable -> L70
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L72:
        Message msg = Message.obtain();     // Catch: Throwable -> L70
        msg.what = 1;     // Catch: Throwable -> L70
        int taskId = data.taskId;     // Catch: Throwable -> L70
        msg.obj = data;     // Catch: Throwable -> L70
        this.mService.mUiHandler.sendMessage(msg);     // Catch: Throwable -> L70
        monitor-exit(r15);     // Catch: Throwable -> L70
        ActivityManagerService.resetPriorityAfterLockedSection();
        int res = result.get();
        Intent appErrorIntent = null;
        MetricsLogger.action(this.mContext, FrameworkStatsLog.APP_BACKGROUND_RESTRICTIONS_INFO__EXEMPTION_REASON__REASON_SHELL, res);
        if (res != 6) goto L77;
    L80:
        int res2 = 1;
    L81:
        switch(res2) {
            case 1: goto L123;
            case 2: goto L114;
            case 3: goto L92;
            case 4: goto L147;
            case 5: goto L84;
            case 6: goto L147;
            case 7: goto L147;
            case 8: goto L83;
            default: goto L147;
        };
    L83:
        appErrorIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        appErrorIntent.setData(Uri.parse("package:" + r2.info.packageName));
        appErrorIntent.addFlags(268435456);
        goto L147
    L84:
        Object r3 = this.mBadProcessLock;
        monitor-enter(r3);
        stopReportingCrashesLBp(r);     // Catch: Throwable -> L89
        monitor-exit(r3);     // Catch: Throwable -> L89
    L89:
        th = move-exception;
        throw th;
    L92:
        ActivityManagerService r11 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r11);
        ActivityManagerService r19 = r11;
        this.mService.mProcessList.removeProcessLocked(r, false, true, 4, "crash");     // Catch: Throwable -> L107
        r2 = r;
        monitor-exit(r19);     // Catch: Throwable -> L105
        ActivityManagerService.resetPriorityAfterLockedSection();
        if (taskId == (-1)) goto L147;
        this.mService.startActivityFromRecents(taskId, ActivityOptions.makeBasic().toBundle());     // Catch: IllegalArgumentException -> L103
    L103:
        e = move-exception;
        Slog.e(TAG, "Could not restart taskId=" + taskId, e);
    L107:
        th = th;
    L111:
        monitor-exit(r19);     // Catch: Throwable -> L105
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L105:
        th = th;
    L109:
        th = th;
        r19 = r11;
        goto L111
    L114:
        ActivityManagerGlobalLock r4 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r4);
        appErrorIntent = createAppErrorIntentLOSP(r2, timeMillis, crashInfo);     // Catch: Throwable -> L119
        monitor-exit(r4);     // Catch: Throwable -> L119
        ActivityManagerService.resetPriorityAfterProcLockedSection();
    L119:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    L123:
        long orig = Binder.clearCallingIdentity();
        this.mService.mAtmInternal.onHandleAppCrash(r2.getWindowProcessController());     // Catch: Throwable -> L135
        if (r2.isPersistent() == true) goto L146;
        ActivityManagerService r5 = this.mService;     // Catch: Throwable -> L135
        ActivityManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L135
        monitor-enter(r5);     // Catch: Throwable -> L135
        ActivityManagerService r21 = r5;
        this.mService.mProcessList.removeProcessLocked(r, false, false, 4, "crash");     // Catch: Throwable -> L139
        r2 = r;
        monitor-exit(r21);     // Catch: Throwable -> L137
        ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L135
        this.mService.mAtmInternal.resumeTopActivities(false);     // Catch: Throwable -> L135
    L139:
        th = th;
    L143:
        monitor-exit(r21);     // Catch: Throwable -> L137
        ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L135
        throw th;     // Catch: Throwable -> L135
    L141:
        th = th;
        r21 = r5;
    L137:
        th = th;
    L146:
        Binder.restoreCallingIdentity(orig);
    L135:
        th = move-exception;
        Binder.restoreCallingIdentity(orig);
        throw th;
    L147:
        if (appErrorIntent == null) goto L191;
        this.mContext.startActivityAsUser(appErrorIntent, new UserHandle(r2.userId));     // Catch: ActivityNotFoundException -> L150
        return;
    L150:
        e = move-exception;
        Slog.w(TAG, "bug report receiver dissappeared", e);
        return;
    L191:
        return;
    L77:
        if (res == 7) goto L80;
        res2 = res;
    L158:
        monitor-exit(r15);     // Catch: Throwable -> L70
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L155:
        th = th;
    L163:
        monitor-exit(r15);     // Catch: Throwable -> L70
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L53:
        if (r2.getActiveInstrumentation() == null) goto L57;
        monitor-exit(r15);     // Catch: Throwable -> L44
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L44:
        th = th;
    L70:
        th = th;
    L161:
        th = th;
        goto L163
    L30:
        if (r2.getPid() != ActivityManagerService.MY_PID) goto L34;
        if ("android.ui".equals(Thread.currentThread().getName()) == false) goto L34;
        isUiThread = true;
        goto L35
    L26:
        r1 = 0;
    L6:
        if (shortMsg == null) goto L8;
        longMsg2 = shortMsg;
        goto L10
    L8:
        longMsg2 = longMsg;
        goto L10
    }

    private boolean handleAppCrashInActivityController(final ProcessRecord r, final ApplicationErrorReport.CrashInfo crashInfo, final String shortMsg, final String longMsg, final String stackTrace, long timeMillis, int callingPid, int callingUid) {
        if (r == null) goto L4;
        String r0 = r.processName;
    L5:
        final String name = r0;
        if (r == null) goto L8;
        int pid = r.getPid();
    L9:
        if (r == null) goto L11;
        final int uid = r.info.uid;
    L12:
        final int pid2 = pid;
        return this.mService.mAtmInternal.handleAppCrashInActivityController(name, pid2, shortMsg, longMsg, timeMillis, crashInfo.stackTrace, new AppErrors$$ExternalSyntheticLambda1(this, crashInfo, name, pid2, r, shortMsg, longMsg, stackTrace, uid));
    L11:
        uid = callingUid;
        goto L12
    L8:
        pid = callingPid;
        goto L9
    L4:
        r0 = null;
        goto L5
    }

    private /* synthetic */ void lambda$handleAppCrashInActivityController$1(ApplicationErrorReport.CrashInfo crashInfo, String name, int pid, ProcessRecord r, String shortMsg, String longMsg, String stackTrace, int uid) {
        if (Build.IS_DEBUGGABLE == true) goto L5;
    L7:
        Slog.w(TAG, "Force-killing crashed app " + name + " at watcher's request");
        if (r != null) goto L10;
        r.getSmtEx().killedReason = "app-crash";
        this.mService.getSmtEx().reportKillingEvent(KillingStatsUtils.buildOtherKillingEventItem(KillingStatsUtils.getNameForUid(uid), uid, pid, "app-crash"));
        Process.killProcess(pid);
        ProcessList.killProcessGroup(uid, pid);
        this.mService.mProcessList.noteAppKill(pid, uid, 4, 0, "crash");
        return;
    L10:
        if (makeAppCrashingLocked(r, shortMsg, longMsg, stackTrace, null) == true) goto L15;
        r.killLocked("crash", 4, true);
        return;
    L15:
        return;
    L5:
        if ("Native crash".equals(crashInfo.exceptionClassName) == false) goto L7;
        Slog.w(TAG, "Skip killing native crashed app " + name + "(" + pid + ") during testing");
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    private boolean makeAppCrashingLocked(ProcessRecord app, String shortMsg, String longMsg, String stackTrace, AppErrorDialog.Data data) {
        ActivityManagerGlobalLock r1 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r1);
        ProcessErrorStateRecord errState = app.mErrorState;     // Catch: Throwable -> L29
        errState.setCrashing(true);     // Catch: Throwable -> L29
        errState.setCrashingReport(generateProcessError(app, 1, null, shortMsg, longMsg, stackTrace));     // Catch: Throwable -> L25
        errState.startAppProblemLSP();     // Catch: Throwable -> L25
        app.getWindowProcessController().stopFreezingActivities();     // Catch: Throwable -> L25
        Object r11 = this.mBadProcessLock;     // Catch: Throwable -> L25
        monitor-enter(r11);     // Catch: Throwable -> L25
        boolean r12 = handleAppCrashLSPB(app, "force-crash", shortMsg, longMsg, stackTrace, data);     // Catch: Throwable -> L19
        monitor-exit(r11);     // Catch: Throwable -> L19
        monitor-exit(r1);     // Catch: Throwable -> L17
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return r12;
    L19:
        th = move-exception;
        monitor-exit(r11);     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L17
    L25:
        th = move-exception;
        Throwable r13 = th;
    L31:
        monitor-exit(r1);     // Catch: Throwable -> L17
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw r13;
    L27:
        th = move-exception;
        r13 = th;
    L17:
        th = move-exception;
        r13 = th;
    L29:
        th = move-exception;
        r13 = th;
        goto L31
    }

    ActivityManager.ProcessErrorStateInfo generateProcessError(ProcessRecord app, int condition, String activity, String shortMsg, String longMsg, String stackTrace) {
        ActivityManager.ProcessErrorStateInfo report = new ActivityManager.ProcessErrorStateInfo();
        report.condition = condition;
        report.processName = app.processName;
        report.pid = app.getPid();
        report.uid = app.info.uid;
        report.tag = activity;
        report.shortMsg = shortMsg;
        report.longMsg = longMsg;
        report.stackTrace = stackTrace;
        return report;
    }

    Intent createAppErrorIntentLOSP(ProcessRecord r, long timeMillis, ApplicationErrorReport.CrashInfo crashInfo) {
        ApplicationErrorReport report = createAppErrorReportLOSP(r, timeMillis, crashInfo);
        if (report != null) goto L6;
        return null;
    L6:
        Intent result = new Intent("android.intent.action.APP_ERROR");
        result.setComponent(r.mErrorState.getErrorReportReceiver());
        result.putExtra("android.intent.extra.BUG_REPORT", report);
        result.addFlags(268435456);
        return result;
    }

    private ApplicationErrorReport createAppErrorReportLOSP(ProcessRecord r, long timeMillis, ApplicationErrorReport.CrashInfo crashInfo) {
        ProcessErrorStateRecord errState = r.mErrorState;
        if (errState.getErrorReportReceiver() != null) goto L6;
        return null;
    L6:
        if (errState.isCrashing() == false) goto L8;
    L12:
        ApplicationErrorReport report = new ApplicationErrorReport();
        report.packageName = r.info.packageName;
        report.installerPackageName = errState.getErrorReportReceiver().getPackageName();
        report.processName = r.processName;
        report.time = timeMillis;
        if ((r.info.flags & 1) == 0) goto L15;
        boolean r3 = true;
    L16:
        report.systemApp = r3;
        if (errState.isCrashing() == false) goto L19;
    L27:
        report.type = 1;
        report.crashInfo = crashInfo;
    L28:
        return report;
    L19:
        if (errState.isForceCrashReport() == true) goto L27;
        if (errState.isNotResponding() == false) goto L28;
        ActivityManager.ProcessErrorStateInfo anrReport = errState.getNotRespondingReport();
        if (anrReport != null) goto L26;
        return null;
    L26:
        report.type = 2;
        report.anrInfo = new ApplicationErrorReport.AnrInfo();
        report.anrInfo.activity = anrReport.tag;
        report.anrInfo.cause = anrReport.shortMsg;
        report.anrInfo.info = anrReport.longMsg;
        goto L28
    L15:
        r3 = false;
        goto L16
    L8:
        if (errState.isNotResponding() == true) goto L12;
        if (errState.isForceCrashReport() == true) goto L12;
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean handleAppCrashLSPB(ProcessRecord r27, String r28, String r29, String r30, String r31, AppErrorDialog.Data r32) {
        long r9 = SystemClock.uptimeMillis();
        String r14 = r27.processName;
        int r15 = r27.uid;
        int r1 = r27.userId;
        boolean r3 = r27.isolated;
        boolean r16 = r27.isPersistent();
        WindowProcessController r4 = r27.getWindowProcessController();
        ProcessErrorStateRecord r5 = r27.mErrorState;
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "anr_show_background", 0, getVisibleUserId(r1)) == 0) goto L5;
        boolean r6 = true;
    L6:
        boolean r17 = r6;
        if (r27.isolated == true) goto L9;
        Long r18 = (Long) this.mProcessCrashTimes.get(r14, r15);
        Long r19 = (Long) this.mProcessCrashTimesPersistent.get(r14, r15);
    L10:
        boolean r7 = r27.mServices.incServiceCrashCountLocked(r9);
        if (r18 != null) goto L13;
    L15:
        boolean r11 = false;
    L16:
        boolean r20 = r11;
        if (r20 == false) goto L19;
        boolean r10 = true;
    L32:
        StringBuilder r8 = new StringBuilder();
        r8.append("Process ");
        r8.append(r14);
        r8.append(" has crashed too many times, killing! Reason: ");
        if (r20 == false) goto L35;
        String r12 = "crashed quickly";
    L36:
        r8.append(r12);
        Slog.w(TAG, r8.toString());
        EventLog.writeEvent(EventLogTags.AM_PROCESS_CRASHED_TOO_MUCH, new Object[]{Integer.valueOf(r1), r14, Integer.valueOf(r15)});
        this.mService.mAtmInternal.onHandleAppCrash(r4);
        if (r16 == true) goto L52;
        EventLog.writeEvent(EventLogTags.AM_PROC_BAD, new Object[]{Integer.valueOf(r1), Integer.valueOf(r15), r14});
        if (r3 == true) goto L41;
        long r13 = r9;
        markBadProcess(r14, r27.uid, new BadProcessInfo(r13, r29, r30, r31));
        this.mProcessCrashTimes.remove(r14, r27.uid);
        this.mProcessCrashCounts.remove(r14, r27.uid);
    L42:
        r5.setBad(true);
        r27.setRemoved(true);
        AppStandbyInternal r21 = (AppStandbyInternal) LocalServices.getService(AppStandbyInternal.class);
        if (r21 != null) goto L45;
    L49:
        boolean r22 = r7;
        boolean r23 = true;
        this.mService.mProcessList.removeProcessLocked(r27, false, r22, 4, "crash");
        boolean r24 = false;
        this.mService.mAtmInternal.resumeTopActivities(false);
        if (r17 == true) goto L53;
        return false;
    L53:
        this.mService.mAtmInternal.resumeTopActivities(r24);
        boolean r25 = r23;
    L54:
        if (r32 == null) goto L58;
        if (r22 == false) goto L58;
        r32.isRestartableForService = r25;
    L58:
        if (r4.isHomeProcess() == true) goto L60;
    L64:
        if (r3 == true) goto L67;
        this.mProcessCrashTimes.put(r14, r15, Long.valueOf(r13));
        this.mProcessCrashTimesPersistent.put(r14, r15, Long.valueOf(r13));
        updateProcessCrashCountLBp(r14, r15, r13);
    L67:
        if (r5.getCrashHandler() == null) goto L69;
        this.mService.mHandler.post(r5.getCrashHandler());
    L69:
        return r25;
    L60:
        if (r4.hasActivities() == false) goto L64;
        if ((r27.info.flags & r25) != 0) goto L64;
        r4.clearPackagePreferredForHomeActivities();
        goto L64
    L45:
        if (r27.info == null) goto L47;
        String r110 = r27.info.packageName;
    L48:
        r21.restrictApp(r110, r1, 4);
        goto L49
    L47:
        r110 = r14;
        goto L48
    L41:
        r13 = r9;
        goto L42
    L52:
        r3 = r3;
        r22 = r7;
        r23 = r10;
        r13 = r9;
        r24 = false;
        goto L53
    L35:
        r12 = "over process crash limit";
        goto L36
    L19:
        if (isProcOverCrashLimitLBp(r27, r9) == false) goto L21;
        r10 = true;
        goto L32
    L21:
        int r111 = this.mService.mAtmInternal.finishTopCrashedActivities(r4, r28);
        if (r32 == null) goto L24;
        r32.taskId = r111;
    L24:
        if (r32 == null) goto L30;
        if (r19 == null) goto L30;
        if (r9 >= (r19.longValue() + ((long) ActivityManagerConstants.MIN_CRASH_INTERVAL))) goto L29;
        r32.repeating = true;
        r3 = r3;
        r4 = r4;
        r5 = r5;
        r22 = r7;
        r25 = 1;
        r13 = r9;
        goto L54
    L29:
        r3 = r3;
        r4 = r4;
        r5 = r5;
        r22 = r7;
        r25 = 1;
        r13 = r9;
    L30:
        r3 = r3;
        r4 = r4;
        r5 = r5;
        r22 = r7;
        r25 = 1;
        r13 = r9;
        goto L54
    L13:
        if (r9 >= (r18.longValue() + ((long) ActivityManagerConstants.MIN_CRASH_INTERVAL))) goto L15;
        r11 = true;
        goto L16
    L9:
        r18 = null;
        r19 = null;
        goto L10
    L5:
        r6 = false;
        goto L6
    }

    private void updateProcessCrashCountLBp(String processName, int uid, long now) {
        Pair<Long, Integer> count = (Pair) this.mProcessCrashCounts.get(processName, uid);
        if (count != null) goto L5;
    L8:
        Pair<Long, Integer> count2 = new Pair(Long.valueOf(now), 1);
    L9:
        this.mProcessCrashCounts.put(processName, uid, count2);
        return;
    L5:
        if ((((Long) count.first).longValue() + ActivityManagerConstants.PROCESS_CRASH_COUNT_RESET_INTERVAL) < now) goto L8;
        count2 = new Pair((Long) count.first, Integer.valueOf(((Integer) count.second).intValue() + 1));
        goto L9
    }

    private boolean isProcOverCrashLimitLBp(ProcessRecord app, long now) {
        Pair<Long, Integer> crashCount = (Pair) this.mProcessCrashCounts.get(app.processName, app.uid);
        if (app.isolated == true) goto L10;
        if (crashCount == null) goto L10;
        if (now >= (((Long) crashCount.first).longValue() + ActivityManagerConstants.PROCESS_CRASH_COUNT_RESET_INTERVAL)) goto L10;
        if (((Integer) crashCount.second).intValue() < ActivityManagerConstants.PROCESS_CRASH_COUNT_LIMIT) goto L10;
        return true;
    L10:
        return false;
    }

    void handleShowAppErrorUi(Message msg) {
        AppErrorDialog.Data data = (AppErrorDialog.Data) msg.obj;
        ActivityManagerGlobalLock r4 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r4);
        ProcessRecord proc = data.proc;     // Catch: Throwable -> L10
        AppErrorResult res = data.result;     // Catch: Throwable -> L10
        if (proc != null) goto L12;
        Slog.e(TAG, "handleShowAppErrorUi: proc is null");     // Catch: Throwable -> L10
        monitor-exit(r4);     // Catch: Throwable -> L10
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return;
    L12:
        ProcessErrorStateRecord errState = proc.mErrorState;     // Catch: Throwable -> L10
        int userId = proc.userId;     // Catch: Throwable -> L10
        if (errState.getDialogController().hasCrashDialogs() == false) goto L21;
        Slog.e(TAG, "App already has crash dialog: " + proc);     // Catch: Throwable -> L10
        if (res == null) goto L17;
        res.set(AppErrorDialog.ALREADY_SHOWING);     // Catch: Throwable -> L10
    L17:
        monitor-exit(r4);     // Catch: Throwable -> L10
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return;
    L21:
        if (UserHandle.getAppId(proc.uid) >= 10000) goto L23;
    L25:
        boolean isBackground = false;
    L26:
        int[] r9 = this.mService.mUserController.getCurrentProfileIds();     // Catch: Throwable -> L10
        int r12 = r9.length;     // Catch: Throwable -> L10
        boolean isBackground2 = isBackground;
        int r0 = 0;
    L27:
        if (r0 >= r12) goto L33;
        int profileId = r9[r0];     // Catch: Throwable -> L10
        if (userId == profileId) goto L31;
        boolean r15 = true;
    L32:
        isBackground2 = isBackground2 & r15;     // Catch: Throwable -> L10
        r0 = r0 + 1;     // Catch: Throwable -> L10
        goto L27
    L31:
        r15 = false;
        goto L32
    L33:
        int visibleUserId = getVisibleUserId(userId);     // Catch: Throwable -> L10
        boolean isVisibleUser = ((UserManagerInternal) LocalServices.getService(UserManagerInternal.class)).isVisibleBackgroundFullUser(visibleUserId);     // Catch: Throwable -> L10
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "anr_show_background", 0, visibleUserId) == 0) goto L36;
        boolean r1 = true;
    L37:
        boolean showBackground = r1;
        if (isBackground2 == false) goto L47;
        if (showBackground == true) goto L47;
        if (isVisibleUser == true) goto L47;
        Slog.w(TAG, "Skipping crash dialog of " + proc + ": background");     // Catch: Throwable -> L10
        if (res == null) goto L44;
        res.set(AppErrorDialog.BACKGROUND_USER);     // Catch: Throwable -> L10
    L44:
        monitor-exit(r4);     // Catch: Throwable -> L10
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return;
    L47:
        Long crashShowErrorTime = null;
        Object r10 = this.mBadProcessLock;     // Catch: Throwable -> L10
        monitor-enter(r10);     // Catch: Throwable -> L10
    L118:
        th = th;
    L120:
        monitor-exit(r10);     // Catch: Throwable -> L107
        throw th;     // Catch: Throwable -> L10
    L51:
        if (proc.isolated == true) goto L57;
        crashShowErrorTime = (Long) this.mProcessCrashShowDialogTimes.get(proc.processName, proc.uid);     // Catch: Throwable -> L54
    L54:
        th = th;
    L57:
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "show_first_crash_dialog", 0) == 0) goto L59;
        boolean showFirstCrash = true;
    L60:
    L82:
        th = th;
        goto L120
    L63:
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "show_first_crash_dialog_dev_option", 0, visibleUserId) == 0) goto L65;
        boolean showFirstCrashDevOption = true;
    L66:
        String packageName = proc.info.packageName;     // Catch: Throwable -> L82
        boolean isXtsPkg = Utils.isXtsPkg(packageName);     // Catch: Throwable -> L82
        if (this.mAppsNotReportingCrashes != null) goto L128;
        boolean showFirstCrashDevOption2 = showFirstCrashDevOption;
    L74:
        boolean showFirstCrashDevOption3 = false;
    L76:
        long now = SystemClock.uptimeMillis();     // Catch: Throwable -> L82
        if (crashShowErrorTime == null) goto L84;
        boolean showFirstCrash2 = showFirstCrash;
        if (now >= (crashShowErrorTime.longValue() + ((long) ActivityManagerConstants.MIN_CRASH_INTERVAL))) goto L85;
        boolean shouldThottle = true;
    L87:
        ContentResolver r7 = this.mContext.getContentResolver();     // Catch: Throwable -> L107
        if (Build.IS_USER == false) goto L90;
        int r2 = 0;
    L91:
        boolean shouldThottle2 = shouldThottle;
        if (Settings.Secure.getIntForUser(r7, "allow_show_crash_dialog", r2, this.mService.mUserController.getCurrentUserId()) == 0) goto L94;
        boolean allowShowCrashDialog = true;
    L95:
        if (allowShowCrashDialog == true) goto L98;
        if (isXtsPkg == true) goto L98;
    L112:
        if (res == null) goto L114;
        res.set(AppErrorDialog.CANT_SHOW);     // Catch: Throwable -> L107
    L114:
        monitor-exit(r10);     // Catch: Throwable -> L107
        monitor-exit(r4);     // Catch: Throwable -> L10
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return;
    L98:
        if (this.mService.mAtmInternal.canShowErrorDialogs(visibleUserId) == true) goto L100;
        if (showBackground == false) goto L112;
    L100:
        if (showFirstCrashDevOption3 == true) goto L112;
        if (shouldThottle2 == true) goto L112;
        if (showFirstCrash2 == true) goto L109;
        if (showFirstCrashDevOption2 == true) goto L109;
        if (data.repeating == false) goto L112;
    L109:
        Slog.i(TAG, "Showing crash dialog for package " + packageName + " u" + userId);     // Catch: Throwable -> L107
        errState.getDialogController().showCrashDialogs(data);     // Catch: Throwable -> L107
        if (proc.isolated == true) goto L114;
        this.mProcessCrashShowDialogTimes.put(proc.processName, proc.uid, Long.valueOf(now));     // Catch: Throwable -> L107
        goto L114
    L94:
        allowShowCrashDialog = false;
        goto L95
    L90:
        r2 = 1;
    L85:
        shouldThottle = false;
        goto L87
    L84:
        showFirstCrash2 = showFirstCrash;
        goto L85
    L128:
        showFirstCrashDevOption2 = showFirstCrashDevOption;
        if (this.mAppsNotReportingCrashes.contains(proc.info.packageName) == false) goto L74;
        showFirstCrashDevOption3 = true;
    L71:
        th = th;
        goto L120
    L65:
        showFirstCrashDevOption = false;
        goto L66
    L59:
        showFirstCrash = false;
    L107:
        th = th;
        goto L120
    L36:
        r1 = false;
        goto L37
    L23:
        if (proc.getPid() == ActivityManagerService.MY_PID) goto L25;
        isBackground = true;
    L10:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    }

    private void stopReportingCrashesLBp(ProcessRecord proc) {
        if (this.mAppsNotReportingCrashes != null) goto L5;
        this.mAppsNotReportingCrashes = new ArraySet();
    L5:
        this.mAppsNotReportingCrashes.add(proc.info.packageName);
    }

    void handleShowAnrUi(Message msg) {
        List<VersionedPackage> packageList = null;
        boolean doKill = false;
        AppNotRespondingDialog.Data data = (AppNotRespondingDialog.Data) msg.obj;
        ProcessRecord proc = data.proc;
        if (proc != null) goto L6;
        Slog.e(TAG, "handleShowAnrUi: proc is null");
        return;
    L6:
        ActivityManagerGlobalLock r7 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r7);
        ProcessErrorStateRecord errState = proc.mErrorState;     // Catch: Throwable -> L42
        errState.setAnrData(data);     // Catch: Throwable -> L42
        if (proc.isPersistent() == true) goto L16;
    L12:
        th = th;
    L53:
        monitor-exit(r7);     // Catch: Throwable -> L12
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    L11:
        packageList = proc.getPackageListWithVersionCode();     // Catch: Throwable -> L12
    L16:
        if (errState.getDialogController().hasAnrDialogs() == false) goto L21;
        Slog.e(TAG, "App already has anr dialog: " + proc);     // Catch: Throwable -> L12
        MetricsLogger.action(this.mContext, FrameworkStatsLog.APP_BACKGROUND_RESTRICTIONS_INFO__EXEMPTION_REASON__REASON_MEDIA_SESSION_CALLBACK, -2);     // Catch: Throwable -> L12
        monitor-exit(r7);     // Catch: Throwable -> L12
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return;
    L21:
        int visibleUserId = getVisibleUserId(proc.userId);     // Catch: Throwable -> L42
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "anr_show_background", 0, visibleUserId) == 0) goto L24;
        boolean showBackground = true;
    L26:
        if (this.mService.mAtmInternal.canShowErrorDialogs(visibleUserId) == true) goto L31;
        if (showBackground == true) goto L31;
        MetricsLogger.action(this.mContext, FrameworkStatsLog.APP_BACKGROUND_RESTRICTIONS_INFO__EXEMPTION_REASON__REASON_MEDIA_SESSION_CALLBACK, -1);     // Catch: Throwable -> L12
        boolean doKill2 = true;
    L46:
        monitor-exit(r7);     // Catch: Throwable -> L12
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        if (doKill2 == false) goto L50;
        this.mService.killAppAtUsersRequest(proc);
    L50:
        if (packageList == null) goto L62;
        this.mPackageWatchdog.notifyPackageFailure(packageList, 4);
        return;
    L62:
        return;
    L31:
        AnrController anrController = errState.getDialogController().getAnrController();     // Catch: Throwable -> L42
        if (anrController != null) goto L35;
        errState.getDialogController().showAnrDialogs(data);     // Catch: Throwable -> L12
        doKill = doKill;
    L45:
        doKill2 = doKill;
        goto L46
    L35:
        String packageName = proc.info.packageName;     // Catch: Throwable -> L42
        int uid = proc.info.uid;     // Catch: Throwable -> L42
        boolean showDialog = anrController.onAnrDelayCompleted(packageName, uid);     // Catch: Throwable -> L42
        if (showDialog == false) goto L44;
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L42
        r15.append("ANR delay completed. Showing ANR dialog for package: ");     // Catch: Throwable -> L40
        r15.append(packageName);     // Catch: Throwable -> L40
        Slog.d(TAG, r15.toString());     // Catch: Throwable -> L40
        errState.getDialogController().showAnrDialogs(data);     // Catch: Throwable -> L40
    L58:
        goto L45
    L44:
        Slog.d(TAG, "ANR delay completed. Cancelling ANR dialog for package: " + packageName);     // Catch: Throwable -> L40
        errState.setNotResponding(false);     // Catch: Throwable -> L40
        errState.setNotRespondingReport(null);     // Catch: Throwable -> L40
        errState.getDialogController().clearAnrDialogs();     // Catch: Throwable -> L40
    L40:
        th = th;
        goto L53
    L24:
        showBackground = false;
    L42:
        th = th;
        goto L53
    }

    void handleDismissAnrDialogs(ProcessRecord proc) {
        ActivityManagerGlobalLock r0 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r0);
        ProcessErrorStateRecord errState = proc.mErrorState;     // Catch: Throwable -> L7
        if (errState.getDialogController().hasAnrDialogs() == false) goto L10;
        errState.setNotResponding(false);     // Catch: Throwable -> L7
        errState.setNotRespondingReport(null);     // Catch: Throwable -> L7
        errState.getDialogController().clearAnrDialogs();     // Catch: Throwable -> L7
    L15:
        this.mService.mUiHandler.removeMessages(2, errState.getAnrData());     // Catch: Throwable -> L7
        proc.mErrorState.setAnrData(null);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return;
    L10:
        if (this.mService.mUiHandler.hasMessages(2, errState.getAnrData()) == false) goto L15;
        Slog.d(TAG, "handleDismissAnrDialogs:isNotResponding=" + errState.isNotResponding() + ",proc=" + proc);     // Catch: Throwable -> L7
        if (errState.isNotResponding() == false) goto L14;
        errState.setNotResponding(false);     // Catch: Throwable -> L7
    L14:
        errState.setNotRespondingReport(null);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    }

    private int getVisibleUserId(int appUserId) {
        if (UserManager.isVisibleBackgroundUsersEnabled() == false) goto L5;
        return appUserId;
    L5:
        return this.mService.mUserController.getCurrentUserId();
    }
}
