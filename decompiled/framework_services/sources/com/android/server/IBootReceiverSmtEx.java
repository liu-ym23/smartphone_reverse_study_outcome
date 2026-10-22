package com.android.server;

import android.content.Context;
import android.os.DebugSmtEx;
import android.os.DropBoxManager;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public interface IBootReceiverSmtEx {
    default void logBootEvents(Context ctx, HashMap<String, Long> timestamps, String headers) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default boolean addMoreInfoToNativeCrash(DropBoxManager db, String tag, String headers, String fileContents, String filename, int maxSize, String footers) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default int adjustDropboxFileContentSize(File file) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return -1;
    }

    default void addLogToRestart(String headers, int max, String ellipsis) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default boolean checkIfCrashBelongsCurVer(File file) throws IOException {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return true;
    }

    default String addLogcatToFooters() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return "";
    }

    default void addSystemKilledToDropBox(DropBoxManager db) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
