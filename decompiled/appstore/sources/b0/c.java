package b0;

import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static final void a(ReadableByteChannel r10, FileChannel r11) {
        q.g(r10, "input");
        q.g(r11, "output");
        r11.transferFrom(r10, 0, Long.MAX_VALUE);     // Catch: Throwable -> L6
        r11.force(false);     // Catch: Throwable -> L6
        r10.close();
        r11.close();
        return;
    L6:
        th = move-exception;
        r10.close();
        r11.close();
        throw th;
    }
}
