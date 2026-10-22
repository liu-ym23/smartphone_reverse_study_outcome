package com.android.server.am;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface IUIDDownloadInfo {
    default long getStartTime() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default void setStartTime(long startTime) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default long getBytes() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default void setBytes(long bytes) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default boolean isDownloadorUPload() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default void setDownloadorUPload(boolean downloadorUPload) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default boolean getDownloadorUPload() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }
}
