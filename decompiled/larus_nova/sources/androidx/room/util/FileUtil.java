package androidx.room.util;

import android.os.Build;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

/* JADX INFO: loaded from: classes17.dex */
public class FileUtil {
    private FileUtil() {
    }

    public static void copy(ReadableByteChannel r100, FileChannel r110) throws IOException {
    L12:
        th = move-exception;
        r100.close();
        r110.close();
        throw th;
    L3:
        if (Build.VERSION.SDK_INT <= 23) goto L5;
        r110.transferFrom(r100, 0, Long.MAX_VALUE);     // Catch: Throwable -> L12
    L9:
        r110.force(false);     // Catch: Throwable -> L12
        r100.close();
        r110.close();
        return;
    L5:
        InputStream r101 = Channels.newInputStream(r100);     // Catch: Throwable -> L12
        OutputStream r102 = Channels.newOutputStream(r110);     // Catch: Throwable -> L12
        byte[] r103 = new byte[4096];     // Catch: Throwable -> L12
    L6:
        int r104 = r101.read(r103);     // Catch: Throwable -> L12
        if (r104 <= 0) goto L9;
        r102.write(r103, 0, r104);     // Catch: Throwable -> L12
        goto L6
    }
}
