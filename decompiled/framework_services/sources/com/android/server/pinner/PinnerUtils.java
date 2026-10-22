package com.android.server.pinner;

import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Slog;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
final class PinnerUtils {
    private static final String TAG = "PinnerUtils";

    PinnerUtils() {
    }

    public static long clamp(long min, long value, long max) {
        return Math.max(min, Math.min(value, max));
    }

    public static void safeMunmap(long address, long mapSize) {
        Os.munmap(address, mapSize);     // Catch: ErrnoException -> L4
        return;
    L4:
        ex = move-exception;
        Slog.w(TAG, "ignoring error in unmap", ex);
    }

    public static void safeClose(FileDescriptor fd) {
        if (fd != null) goto L4;
        return;
    L4:
        if (fd.valid() == false) goto L16;
        Os.close(fd);     // Catch: ErrnoException -> L7
        return;
    L7:
        ex = move-exception;
        if (ex.errno == OsConstants.EBADF) goto L12;
        return;
    L12:
        throw new AssertionError(ex);
    }

    public static void safeClose(Closeable thing) {
        if (thing == null) goto L10;
        thing.close();     // Catch: IOException -> L5
        return;
    L5:
        ex = move-exception;
        Slog.w(TAG, "ignoring error closing resource: " + thing, ex);
        return;
    }
}
