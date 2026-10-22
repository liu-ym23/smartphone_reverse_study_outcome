package com.android.server.backup.utils;

import android.util.Slog;
import com.android.server.backup.BackupManagerService;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class FileUtils {
    public FileUtils() {
    }

    public static File createNewFile(File file) {
        file.createNewFile();     // Catch: IOException -> L4
    L6:
        return file;
    L4:
        e = move-exception;
        Slog.w(BackupManagerService.TAG, "Failed to create file:" + file.getAbsolutePath(), e);
        goto L6
    }
}
