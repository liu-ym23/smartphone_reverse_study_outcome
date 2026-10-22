package com.android.server.am;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface IProcExtraInfoOpt {
    public static final int GET_PROC_LASTWORD = 25002;
    public static final int SET_PROC_LASTWORD = 25001;

    default void setLastWord(int pid, String word) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default String getLastWordOfPid(int pid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return "";
    }
}
