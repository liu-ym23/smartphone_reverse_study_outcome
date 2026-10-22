package com.android.server.am;

import android.os.DebugSmtEx;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public interface IFreezeStats {
    default void startRecording(FreezeEvent freezeEvent) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void endRecording(FreezeEvent freezeEvent) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default int getWeightedAvgScore(String procName) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default String getProcessName() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return "";
    }

    default FreezeEvent getCurrentFreezeEvent() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }

    default long getCurrentFreezeDurationMs() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return -1;
    }

    default void reportProcLifeState(int uid, int pid, String processName, boolean create) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void reportProcessFreezeError(FreezeErrorData data) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void dumpFreezeStats(PrintWriter pw) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
