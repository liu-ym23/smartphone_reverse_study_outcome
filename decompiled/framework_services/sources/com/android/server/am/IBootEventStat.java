package com.android.server.am;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface IBootEventStat {
    default void writeEvent(String event, long value) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void setBootType(int bootType) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void setDataPackagesCount(int num) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void setSystemPackagesCount(int num) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void saveFile() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void release() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
