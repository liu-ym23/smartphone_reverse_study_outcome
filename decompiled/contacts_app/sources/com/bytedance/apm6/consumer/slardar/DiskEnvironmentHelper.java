package com.bytedance.apm6.consumer.slardar;

import com.android.contacts.common.SimContactsConstants;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class DiskEnvironmentHelper {
    private static final String CHILD_PROCESS_PERSISTENT_DIR_NAME = "child_process_persistent";
    private static final String FLUSH_DIR_NAME = "flush";
    private static final String PERSISTENT_DIR_NAME = "persistent";
    private static final String WORKING_DIR_NAME = "apm6";
    private static File sFlushDirectory;
    private static File sPersistentDirectory;
    private static File sPersistentFile;
    private static File sWorkingDirectory;

    public DiskEnvironmentHelper() {
    }

    public static synchronized File getWorkingDirectory() {
        monitor-enter(DiskEnvironmentHelper.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (sWorkingDirectory != null) goto L9;
        File r1 = new File(ApmContext.getContext().getFilesDir(), WORKING_DIR_NAME);     // Catch: Throwable -> L12
        sWorkingDirectory = r1;     // Catch: Throwable -> L12
        if (r1.exists() == true) goto L9;
        sWorkingDirectory.mkdirs();     // Catch: Throwable -> L12
    L9:
        File r2 = sWorkingDirectory;     // Catch: Throwable -> L12
        monitor-exit(DiskEnvironmentHelper.class);
        return r2;
    }

    public static synchronized File getPersistentDirectory() {
        monitor-enter(DiskEnvironmentHelper.class);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (sPersistentDirectory == null) goto L7;
    L16:
        File r0 = sPersistentDirectory;     // Catch: Throwable -> L19
        monitor-exit(DiskEnvironmentHelper.class);
        return r0;
    L7:
        if (ApmContext.isMainProcess() == false) goto L9;
        File r2 = new File(getWorkingDirectory(), PERSISTENT_DIR_NAME);     // Catch: Throwable -> L19
    L11:
        if (r2.exists() == true) goto L13;
        r2.mkdirs();     // Catch: Throwable -> L19
    L13:
        sPersistentDirectory = r2;     // Catch: Throwable -> L19
        if (ApmContext.isDebugMode() == false) goto L16;
        Logger.d(Constants.TAG, "prepare PersistentDirectory success. name=" + sPersistentDirectory);     // Catch: Throwable -> L19
        goto L16
    L9:
        r2 = new File(getWorkingDirectory(), CHILD_PROCESS_PERSISTENT_DIR_NAME);     // Catch: Throwable -> L19
        goto L11
    }

    public static synchronized File getPersistentFile() {
        monitor-enter(DiskEnvironmentHelper.class);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (sPersistentFile == null) goto L24;
    L18:
        File r0 = sPersistentFile;     // Catch: Throwable -> L21
        monitor-exit(DiskEnvironmentHelper.class);
        return r0;
    L24:
        String r2 = ApmContext.getCurrentProcessName().replace(LibrarianImpl.Constants.DOT, "_").replace(SimContactsConstants.ANR_SEP, "-") + ".bin";     // Catch: Exception -> L16 Throwable -> L21
        if (ApmContext.isMainProcess() == true) goto L9;
        r2 = ApmContext.getInitTimeStamp() + "_" + r2;     // Catch: Exception -> L16 Throwable -> L21
    L9:
        File r3 = new File(getPersistentDirectory(), r2);     // Catch: Exception -> L16 Throwable -> L21
        if (r3.exists() == true) goto L12;
        r3.createNewFile();     // Catch: Exception -> L16 Throwable -> L21
    L12:
        sPersistentFile = r3;     // Catch: Exception -> L16 Throwable -> L21
        if (ApmContext.isDebugMode() == false) goto L18;
        Logger.d(Constants.TAG, "prepare PersistentFile success. fileName=" + sPersistentFile);     // Catch: Exception -> L16 Throwable -> L21
    L16:
        e = move-exception;
        Logger.e(Constants.TAG, "prepare PersistentFile fail.", e);     // Catch: Throwable -> L21
        goto L18
    }

    public static synchronized File getFlushDirectory() {
        monitor-enter(DiskEnvironmentHelper.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (sFlushDirectory != null) goto L12;
        File r2 = new File(getWorkingDirectory(), "flush");     // Catch: Throwable -> L15
        if (r2.exists() == true) goto L9;
        r2.mkdirs();     // Catch: Throwable -> L15
    L9:
        sFlushDirectory = r2;     // Catch: Throwable -> L15
        if (ApmContext.isDebugMode() == false) goto L12;
        Logger.d(Constants.TAG, "prepare FlushDirectory success. name=" + sFlushDirectory);     // Catch: Throwable -> L15
    L12:
        File r0 = sFlushDirectory;     // Catch: Throwable -> L15
        monitor-exit(DiskEnvironmentHelper.class);
        return r0;
    }

    public static File getSubProcessPersistentDirectory() {
        return new File(getWorkingDirectory(), CHILD_PROCESS_PERSISTENT_DIR_NAME);
    }

    public static String generateFlushFileName() {
        return System.currentTimeMillis() + "_" + UUID.randomUUID().toString() + ".log";
    }
}
