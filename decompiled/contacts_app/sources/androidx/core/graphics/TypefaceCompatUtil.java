package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import androidx.core.provider.FontsContractCompat;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TypefaceCompatUtil {
    private static final String CACHE_FILE_PREFIX = ".font";
    private static final String TAG = "TypefaceCompatUtil";

    static class Api19Impl {
        private Api19Impl() {
        }

        static ParcelFileDescriptor openFileDescriptor(ContentResolver r0, Uri r1, String r2, CancellationSignal r3) throws FileNotFoundException {
            return r0.openFileDescriptor(r1, r2, r3);
        }
    }

    private TypefaceCompatUtil() {
    }

    public static File getTempFile(Context r5) {
        File r6 = r5.getCacheDir();
        if (r6 != null) goto L5;
        return null;
    L5:
        String r1 = CACHE_FILE_PREFIX + Process.myPid() + "-" + Process.myTid() + "-";
        int r2 = 0;
    L7:
        if (r2 >= 100) goto L13;
        File r3 = new File(r6, r1 + r2);
        if (r3.createNewFile() == false) goto L12;
        return r3;
    L12:
        r2 = r2 + 1;
        goto L7
    L13:
        return null;
    }

    private static ByteBuffer mmap(File r7) {
        FileInputStream r0 = new FileInputStream(r7);     // Catch: IOException -> L12
        FileChannel r1 = r0.getChannel();     // Catch: Throwable -> L6
        long r5 = r1.size();     // Catch: Throwable -> L6
        MappedByteBuffer r8 = r1.map(FileChannel.MapMode.READ_ONLY, 0, r5);     // Catch: Throwable -> L6
        r0.close();     // Catch: IOException -> L12
        return r8;
    L6:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L9
    L11:
        throw th;     // Catch: IOException -> L12
    L9:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L12
    L12:
        return null;
    }

    public static ByteBuffer mmap(Context r7, CancellationSignal r8, Uri r9) {
        ParcelFileDescriptor r10 = Api19Impl.openFileDescriptor(r7.getContentResolver(), r9, "r", r8);     // Catch: IOException -> L27
        if (r10 != null) goto L28;
        if (r10 == null) goto L7;
        r10.close();     // Catch: IOException -> L27
    L7:
        return null;
    L28:
        FileInputStream r11 = new FileInputStream(r10.getFileDescriptor());     // Catch: Throwable -> L20
        FileChannel r1 = r11.getChannel();     // Catch: Throwable -> L14
        long r5 = r1.size();     // Catch: Throwable -> L14
        MappedByteBuffer r12 = r1.map(FileChannel.MapMode.READ_ONLY, 0, r5);     // Catch: Throwable -> L14
        r11.close();     // Catch: Throwable -> L20
        if (r10 == null) goto L13;
        r10.close();     // Catch: IOException -> L27
    L13:
        return r12;
    L14:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L17
    L19:
        throw th;     // Catch: Throwable -> L20
    L17:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        if (r10 != null) goto L31;
    L26:
        throw th;     // Catch: IOException -> L27
    L31:
        r10.close();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L27
    L27:
        return null;
    }

    public static ByteBuffer copyToDirectBuffer(Context r1, Resources r2, int r3) {
        File r4 = getTempFile(r1);
        if (r4 != null) goto L15;
        return null;
    L15:
    L12:
        th = move-exception;
        r4.delete();
        throw th;
    L6:
        if (copyToFile(r4, r2, r3) == true) goto L9;
        r4.delete();
        return null;
    L9:
        ByteBuffer r5 = mmap(r4);     // Catch: Throwable -> L12
        r4.delete();
        return r5;
    }

    public static boolean copyToFile(File r5, InputStream r6) {
        StrictMode.ThreadPolicy r0 = StrictMode.allowThreadDiskWrites();
        FileOutputStream r2 = null;
        FileOutputStream r3 = new FileOutputStream(r5, false);     // Catch: Throwable -> L16 IOException -> L18
        byte[] r7 = new byte[1024];     // Catch: Throwable -> L12 IOException -> L14
    L6:
        int r4 = r6.read(r7);     // Catch: Throwable -> L12 IOException -> L14
        if (r4 == (-1)) goto L10;
        r3.write(r7, 0, r4);     // Catch: Throwable -> L12 IOException -> L14
    L10:
        closeQuietly(r3);
        StrictMode.setThreadPolicy(r0);
        return true;
    L14:
        e = e;
        r2 = r3;
    L19:
        Log.e(TAG, "Error copying resource contents to temp file: " + e.getMessage());     // Catch: Throwable -> L16
        closeQuietly(r2);
        StrictMode.setThreadPolicy(r0);
        return false;
    L12:
        th = th;
        r2 = r3;
    L22:
        closeQuietly(r2);
        StrictMode.setThreadPolicy(r0);
        throw th;
    L18:
        e = e;
    L16:
        th = th;
        goto L22
    }

    public static boolean copyToFile(File r0, Resources r1, int r2) {
        InputStream r3 = r1.openRawResource(r2);     // Catch: Throwable -> L8
        boolean r4 = copyToFile(r0, r3);     // Catch: Throwable -> L6
        closeQuietly(r3);
        return r4;
    L6:
        th = th;
    L10:
        closeQuietly(r3);
        throw th;
    L8:
        th = th;
        r3 = null;
        goto L10
    }

    public static void closeQuietly(Closeable r0) {
        if (r0 == null) goto L8;
        r0.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public static Map<Uri, ByteBuffer> readFontInfoIntoByteBuffer(Context r5, FontsContractCompat.FontInfo[] r6, CancellationSignal r7) {
        HashMap r0 = new HashMap();
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L13;
        FontsContractCompat.FontInfo r3 = r6[r2];
        if (r3.getResultCode() != 0) goto L11;
        Uri r4 = r3.getUri();
        if (r0.containsKey(r4) == true) goto L11;
        r0.put(r4, mmap(r5, r7, r4));
    L11:
        r2 = r2 + 1;
        goto L3
    L13:
        return Collections.unmodifiableMap(r0);
    }
}
