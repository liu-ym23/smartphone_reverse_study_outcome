package com.android.server.am;

import android.os.DebugSmtEx;
import bytedanceos.os.SimpleCpuTracker;

/* JADX INFO: loaded from: classes.dex */
public interface CpuStatsServiceInternal {

    public interface CpuStatsHistoryObserver {
        default void onCpuStatsHistory(CpuStatsServiceInternal stats) {
            DebugSmtEx.printDefaultFunInfo(getClass());
        }
    }

    default void addCpuStatsHistoryObserver(CpuStatsHistoryObserver b) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default long getCurrentIndex() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default SimpleCpuTracker.CpuStatsInfo getIndex(long index) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }
}
