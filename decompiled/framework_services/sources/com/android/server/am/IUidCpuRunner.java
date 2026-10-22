package com.android.server.am;

import android.os.DebugSmtEx;
import android.os.Handler;
import bytedanceos.os.UidCpuTrackerBase;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public interface IUidCpuRunner extends ActivityManagerServiceSysMoEx.CpuStateProvider, ActivityManagerServiceSmtBase.UidCpuUsageProvider {
    default void setProcessFreezer(boolean isFreezeOn, ActivityManagerService service) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void notifyForeground(ProcessRecord prev, ProcessRecord next) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void onUidRemoved(int uid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void onUidAdded(int uid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default int getCpuBusyCount() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default int removeUids(ArrayList<Integer> uids, boolean killVisible, boolean killVideoGame, int killNumber) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default void start() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void registerBackupModeReceiver() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void cleanBadBgApps(Handler h) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default UidCpuTrackerBase getUidCpuTracker() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return new UidCpuTrackerBase();
    }

    default IUIDDownloadInfo getUIDDownloadInfo(int uid) {
        return new AnonymousClass1(this);
    }

    default void writeUidCpurunnerKillReason() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void updateThreshold(int threshold) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void dumpUidCpuUsage(PrintWriter pw) {
    }

    default boolean isCpuBusy() {
        return false;
    }
}
