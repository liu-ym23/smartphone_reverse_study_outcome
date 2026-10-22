package com.android.server.am;

import android.content.pm.PackageManagerInternal;
import android.util.Slog;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;

/* JADX INFO: loaded from: classes.dex */
public class KillingStatsUtils {
    private static final String TAG = "KillingStatsUtils";

    public KillingStatsUtils() {
    }

    public static String getNameForUid(int uid) {
        PackageManagerInternal pm = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        String name = null;
        if (pm == null) goto L5;
        name = pm.getNameForUid(uid);
    L5:
        if (name != null) goto L9;
        return "unknown";
    L9:
        return name;
    }

    public static String buildAmKillingEventItem(String name, int uid, int pid, int adj, int procState, String reason) {
        boolean isMainProcess = resolveIsMainProcess(uid, pid, name);
        Slog.i(TAG, "am kill main-process check proc=" + name + " uid=" + uid + " pid=" + pid + " adj=" + adj + " procState=" + procState + " reason=" + reason + " isMainProcess=" + isMainProcess);
        SysOptBridge.getFactory().getProcLifeStats().onProcStopEvent(uid, pid, reason);
        SysOptBridge.getFactory().getAppRecordManagerService().processDie(uid, pid, reason);
        return "{0|" + name + '|' + uid + '|' + adj + '|' + procState + '|' + reason + '|' + System.currentTimeMillis() + '|' + isMainProcess + '}';
    }

    public static String buildLmkdKillingEventItem(String name, int uid, int pid, int adj, String reason) {
        boolean isMainProcess = resolveIsMainProcess(uid, pid, name);
        Slog.i(TAG, "lmkd kill main-process check proc=" + name + " uid=" + uid + " pid=" + pid + " adj=" + adj + " reason=" + reason + " isMainProcess=" + isMainProcess);
        SysOptBridge.getFactory().getProcLifeStats().onProcStopEvent(uid, pid, reason);
        SysOptBridge.getFactory().getAppRecordManagerService().processDie(uid, pid, reason);
        SysOptBridge.getFactory().getProcessGuardService().tryDumpMeminfo(name, uid, pid, adj, reason);
        return "{1|" + name + '|' + uid + '|' + adj + '|' + reason + '|' + System.currentTimeMillis() + '|' + isMainProcess + '}';
    }

    private static boolean resolveIsMainProcess(int uid, int pid, String procName) {
        return SysOptBridge.getFactory().getAppRecordManagerService().isMainProcess(uid, pid, procName);
    L4:
        t = move-exception;
        Slog.w(TAG, "resolveIsMainProcess failed, uid=" + uid + ", pid=" + pid + ", proc=" + procName, t);
        return false;
    }

    public static String buildOtherKillingEventItem(String name, int uid, int pid, String reason) {
        boolean isMainProcess = resolveIsMainProcess(uid, pid, name);
        Slog.i(TAG, "other kill main-process check proc=" + name + " uid=" + uid + " pid=" + pid + " reason=" + reason + " isMainProcess=" + isMainProcess);
        SysOptBridge.getFactory().getProcLifeStats().onProcStopEvent(uid, pid, reason);
        SysOptBridge.getFactory().getAppRecordManagerService().processDie(uid, pid, reason);
        return "{2|" + name + '|' + uid + '|' + reason + '|' + System.currentTimeMillis() + '|' + isMainProcess + '}';
    }
}
