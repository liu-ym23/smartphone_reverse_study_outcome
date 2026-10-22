package com.android.server.backup.utils;

import android.util.Slog;
import com.android.server.backup.BackupManagerService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes.dex */
public final class RandomAccessFileUtils {
    public RandomAccessFileUtils() {
    }

    private static RandomAccessFile getRandomAccessFile(File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }

    public static void writeBoolean(File file, boolean b) {
        RandomAccessFile af = getRandomAccessFile(file);     // Catch: IOException -> L6
        af.writeBoolean(b);     // Catch: Throwable -> L8
        af.close();     // Catch: IOException -> L6
        return;
    L8:
        th = move-exception;
        if (af != null) goto L18;
    L15:
        throw th;     // Catch: IOException -> L6
    L18:
        af.close();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L6
    L6:
        e = move-exception;
        Slog.w(BackupManagerService.TAG, "Error writing file:" + file.getAbsolutePath(), e);
    }

    public static boolean readBoolean(File file, boolean def) {
        RandomAccessFile af = getRandomAccessFile(file);     // Catch: IOException -> L6
        boolean r1 = af.readBoolean();     // Catch: Throwable -> L8
        af.close();     // Catch: IOException -> L6
        return r1;
    L8:
        th = move-exception;
        if (af != null) goto L18;
    L15:
        throw th;     // Catch: IOException -> L6
    L18:
        af.close();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L6
    L6:
        e = move-exception;
        Slog.w(BackupManagerService.TAG, "Error reading file:" + file.getAbsolutePath(), e);
        return def;
    }
}
