package com.android.server.backup.utils;

import android.os.ParcelFileDescriptor;
import android.util.Slog;
import com.android.server.backup.BackupManagerService;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class FullBackupUtils {
    public FullBackupUtils() {
    }

    public static void routeSocketDataToOutput(ParcelFileDescriptor inPipe, OutputStream out) throws IOException {
        FileInputStream raw = new FileInputStream(inPipe.getFileDescriptor());
        DataInputStream in = new DataInputStream(raw);
        byte[] buffer = new byte[65536];
    L3:
        int r4 = in.readInt();
        int chunkTotal = r4;
        if (r4 > 0) goto L5;
        return;
    L5:
        if (chunkTotal <= 0) goto L3;
        if (chunkTotal <= buffer.length) goto L9;
        int toRead = buffer.length;
    L10:
        int nRead = in.read(buffer, 0, toRead);
        if (nRead < 0) goto L13;
        out.write(buffer, 0, nRead);
        chunkTotal = chunkTotal - nRead;
        goto L5
    L13:
        Slog.e(BackupManagerService.TAG, "Unexpectedly reached end of file while reading data");
        throw new EOFException();
    L9:
        toRead = chunkTotal;
        goto L10
    }
}
