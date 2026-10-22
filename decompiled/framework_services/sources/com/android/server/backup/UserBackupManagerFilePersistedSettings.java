package com.android.server.backup;

import android.util.Slog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class UserBackupManagerFilePersistedSettings {
    private static final String BACKUP_ENABLE_FILE = "backup_enabled";

    UserBackupManagerFilePersistedSettings() {
    }

    static boolean readBackupEnableState(int userId) {
        boolean enabled = readBackupEnableState(UserBackupManagerFiles.getBaseStateDir(userId));
        Slog.d(BackupManagerService.TAG, "user:" + userId + " readBackupEnableState enabled:" + enabled);
        return enabled;
    }

    static void writeBackupEnableState(int userId, boolean enable) {
        Slog.d(BackupManagerService.TAG, "user:" + userId + " writeBackupEnableState enable:" + enable);
        writeBackupEnableState(UserBackupManagerFiles.getBaseStateDir(userId), enable);
    }

    private static boolean readBackupEnableState(File baseDir) {
        File enableFile = new File(baseDir, BACKUP_ENABLE_FILE);
        if (enableFile.exists() == true) goto L31;
        Slog.i(BackupManagerService.TAG, "isBackupEnabled() => false due to absent settings file");
    L26:
        return false;
    L31:
        FileInputStream fin = new FileInputStream(enableFile);     // Catch: IOException -> L17
        int state = fin.read();     // Catch: Throwable -> L10
        boolean r5 = true;
        if (state == 0) goto L12;
        if (state == 1) goto L12;
        Slog.e(BackupManagerService.TAG, "Unexpected enabled state:" + state);     // Catch: Throwable -> L10
    L12:
        if (state != 0) goto L15;
        r5 = false;
    L15:
        fin.close();     // Catch: IOException -> L17
        return r5;
    L10:
        th = move-exception;
        fin.close();     // Catch: Throwable -> L21
    L23:
        throw th;     // Catch: IOException -> L17
    L21:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L17
    L24:
        Slog.e(BackupManagerService.TAG, "Cannot read enable state; assuming disabled");
        goto L26
    }

    private static void writeBackupEnableState(File baseDir, boolean enable) {
        File enableFile = new File(baseDir, BACKUP_ENABLE_FILE);
        File stage = new File(baseDir, "backup_enabled-stage");
        FileOutputStream fout = new FileOutputStream(stage);     // Catch: Throwable -> L15
        if (enable == false) goto L6;
        int r4 = 1;
    L27:
        fout.write(r4);     // Catch: Throwable -> L11
        fout.close();     // Catch: Throwable -> L11
        boolean renamed = stage.renameTo(enableFile);     // Catch: Throwable -> L11
        if (renamed == true) goto L13;
        Slog.e(BackupManagerService.TAG, "Write enable failed as could not rename staging file to actual");     // Catch: Throwable -> L11
    L13:
        fout.close();     // Catch: Throwable -> L15 Throwable -> L15
        return;
    L11:
        th = move-exception;
        fout.close();     // Catch: Throwable -> L19
    L21:
        throw th;     // Catch: Throwable -> L15 Throwable -> L15
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L15 Throwable -> L15
        goto L21
    L6:
        r4 = 0;
    L15:
        e = move-exception;
        Slog.e(BackupManagerService.TAG, "Unable to record backup enable state; reverting to disabled: " + e.getMessage());
        enableFile.delete();
        stage.delete();
    }
}
