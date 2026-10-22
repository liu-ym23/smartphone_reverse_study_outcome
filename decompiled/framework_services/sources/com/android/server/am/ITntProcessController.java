package com.android.server.am;

import android.os.DebugSmtEx;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public interface ITntProcessController {
    default void shutDownSaveTntProcessMessage() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void updateTntProcessMessage() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void removeTntProcess(String processName) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void recordTntProcessVisible(ProcessRecord app) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void recordTntProcessInvisible(ProcessRecord app) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void recordKillTntProcess(ProcessRecord app) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void dump(PrintWriter pw) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default int getTntProcessFraction(String processName) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }
}
