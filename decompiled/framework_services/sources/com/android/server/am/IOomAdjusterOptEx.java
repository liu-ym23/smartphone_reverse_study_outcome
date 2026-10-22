package com.android.server.am;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface IOomAdjusterOptEx {
    default void computeOomAdjLocked(OomAdjuster host, ProcessRecord app, boolean report, ProcessRecord TOP_APP, boolean connectedWithTop, boolean connectedWithSystemServer) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void setLowMemState(boolean state) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void kernelCachedLowMemState() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default long getmDailyOOMCount() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default void setmDailyOOMCount(long count) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default int getmNumCachedProcs() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default void setmNumCachedProcs(int count) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default long getmJudgeLowMemTime() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default boolean isKernelCachedKillEnable() {
        return false;
    }

    default void setmJudgeLowMemTime(long time) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default int getJAGDE_LOW_MEM_STATE_TIME() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default int getSET_HIGH_PRIORITY_TIME_OUT() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default void applyOomAdjLocked(ProcessRecord app, long now) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void setAppProcState(ProcessRecord app, int procState) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default int processListGroup2ProcessGroup(int curSchedGroup, int processGroup) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default void updateDataIfNeeded(int type, String pkg) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default int computeOomAdjForPrefetch(ProcessRecord app, int schedGroup) {
        return -1;
    }

    default void schedOptTopApp(boolean topApp, ProcessRecord app, int renderThreadTid, int[] commonPoolTids) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
