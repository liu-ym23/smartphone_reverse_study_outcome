package com.android.server;

import android.os.DebugSmtEx;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ISmartAnaly {
    default void AnalysisFlock(String packagename) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default boolean checkFileLock(String packagename) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default List<Integer> AnalysisFlock() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }
}
