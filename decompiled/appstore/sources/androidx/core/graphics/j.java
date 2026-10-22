package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.annotation.DoNotInline;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    public static class a {
        @DoNotInline
        public static ParcelFileDescriptor a(ContentResolver r10, Uri r11, String r12, CancellationSignal r13) throws FileNotFoundException {
            return r10.openFileDescriptor(r11, r12, r13);
        }
    }

    public static ByteBuffer a(Context r10, CancellationSignal r11, Uri r12) {
        ParcelFileDescriptor r13 = a.a(r10.getContentResolver(), r12, "r", r11);     // Catch: IOException -> L26
        if (r13 != null) goto L29;
        if (r13 == null) goto L7;
        r13.close();     // Catch: IOException -> L26
    L7:
        return null;
    L29:
        FileInputStream r14 = new FileInputStream(r13.getFileDescriptor());     // Catch: Throwable -> L13
        FileChannel r15 = r14.getChannel();     // Catch: Throwable -> L15
        long r16 = r15.size();     // Catch: Throwable -> L15
        MappedByteBuffer r17 = r15.map(FileChannel.MapMode.READ_ONLY, 0, r16);     // Catch: Throwable -> L15
        r14.close();     // Catch: Throwable -> L13
        r13.close();     // Catch: IOException -> L26
        return r17;
    L15:
        th = move-exception;
        r14.close();     // Catch: Throwable -> L18
    L20:
        throw th;     // Catch: Throwable -> L13
    L18:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        r13.close();     // Catch: Throwable -> L23
    L25:
        throw th;     // Catch: IOException -> L26
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L26
    L26:
        return null;
    }
}
