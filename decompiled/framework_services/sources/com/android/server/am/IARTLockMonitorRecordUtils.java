package com.android.server.am;

import android.os.DebugSmtEx;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public interface IARTLockMonitorRecordUtils {
    default void dumpProcARTLockRecordsToFile(String procName, File file, boolean needAllThreads) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
