package com.android.server.am;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface IMemoryStrategy {
    default void backtraceDoneInform(String ProcessName, int pid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void executeMemoryStrategyPss(String name, int pid, long pss, int oomAdj) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void executeMemoryStrategyRss(String name, int pid, long rss, int oomAdj) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void setSoundProcessMemoryStrategy(boolean flag) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void enterIdleStateInform(boolean flag) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
