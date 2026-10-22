package com.android.server.am;

import android.os.DebugSmtEx;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IUidMonitorSmt {
    public static final boolean UID_MONITOR_CONTROL = true;

    public static class UidCpuUsage {
        public HashMap<Integer, Long> acctFreqTableBg;
        public HashMap<Integer, Long> acctFreqTableBgLastTime;
        public HashMap<Integer, Long> acctFreqTableBgScreenOn;
        public HashMap<Integer, Long> acctFreqTableBgScreenOnLastTime;
        public long acctUsageBg;
        public long acctUsageBgLastTime;
        public long acctUsageBgScreenOn;
        public long acctUsageBgScreenOnLastTime;
        public long acctUsageScreenOn;
        public long acctUsageScreenOnLastTime;
        public long cpuUsageByNow;
        public long fgCpuUsage;
        public HashMap<Integer, Long> freqPoints;
        public int uid;

        public UidCpuUsage() {
            this.fgCpuUsage = 0;
            this.cpuUsageByNow = 0;
            this.acctUsageBg = 0;
            this.acctUsageBgLastTime = 0;
            this.acctUsageBgScreenOn = 0;
            this.acctUsageBgScreenOnLastTime = 0;
            this.acctUsageScreenOn = 0;
            this.acctUsageScreenOnLastTime = 0;
            this.freqPoints = new HashMap();
            this.acctFreqTableBg = new HashMap();
            this.acctFreqTableBgLastTime = new HashMap();
            this.acctFreqTableBgScreenOn = new HashMap();
            this.acctFreqTableBgScreenOnLastTime = new HashMap();
        }

        public String toString() {
            return this.uid + "|" + this.cpuUsageByNow + "|" + this.fgCpuUsage + "|" + this.acctUsageBg + "|" + this.acctUsageBgLastTime + "|" + this.acctUsageBgScreenOn + "|" + this.acctUsageBgScreenOnLastTime + "|" + this.acctUsageScreenOn + "|" + this.acctUsageScreenOnLastTime;
        }
    }

    default void onActiveUidAdded(int uid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void onActiveUidRemoved(int uid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void updateForeground(int prevUid, int nextUid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void reportBackgroundUidUsage() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default long getUidFgUsageTime(int uid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default long getUidTotalUsageTime(int uid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default void updateCpuBusyData(boolean cpuLastBusy) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default HashMap getCurrentUidCpuUsage() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return new HashMap();
    }

    default long getIdleCpuUsageUpNow() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default long getTotalCpuUsageUpNow() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default long getTotalUidCpuUsageUpNow() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default void updateScreenOnCpuUsageByUid() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void updateScreenOffCpuUsageByUid() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void computeUidIOForSysevent() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default List getCurrentUidCpuUsageInOrder(int count) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }
}
