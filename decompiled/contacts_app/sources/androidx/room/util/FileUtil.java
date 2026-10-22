package androidx.room.util;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

/* JADX INFO: loaded from: classes.dex */
public class FileUtil {
    public static void copy(ReadableByteChannel input, FileChannel output) throws IOException {
        output.transferFrom(input, 0, Long.MAX_VALUE);     // Catch: Throwable -> L6
        output.force(false);     // Catch: Throwable -> L6
        input.close();
        output.close();
        return;
    L6:
        th = move-exception;
        input.close();
        output.close();
        throw th;
    }

    private FileUtil() {
    }
}
