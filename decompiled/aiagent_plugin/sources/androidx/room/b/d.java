package androidx.room.b;

import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

/* JADX INFO: compiled from: FileUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public static void a(ReadableByteChannel r7, FileChannel r8) {
        ReadableByteChannel r9 = (ReadableByteChannel) ZeusTransformUtils.wrapperContextForParams(r7, ReadableByteChannel.class, "com.obric.aiagent.plugin");
    L13:
        th = move-exception;
        r9.close();
        r8.close();
        throw th;
    L4:
        if (Build.VERSION.SDK_INT <= 23) goto L6;
        r8.transferFrom(r9, 0, Long.MAX_VALUE);     // Catch: Throwable -> L13
    L10:
        r8.force(false);     // Catch: Throwable -> L13
        r9.close();
        r8.close();
        return;
    L6:
        InputStream r0 = Channels.newInputStream(r9);     // Catch: Throwable -> L13
        OutputStream r1 = Channels.newOutputStream(r8);     // Catch: Throwable -> L13
        byte[] r2 = new byte[4096];     // Catch: Throwable -> L13
    L7:
        int r3 = r0.read(r2);     // Catch: Throwable -> L13
        if (r3 <= 0) goto L10;
        r1.write(r2, 0, r3);     // Catch: Throwable -> L13
        goto L7
    }
}
