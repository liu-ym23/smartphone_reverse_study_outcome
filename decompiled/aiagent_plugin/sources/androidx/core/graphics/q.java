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
import com.obric.aiagent.apm.impl.BuildConfig;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: TypefaceCompatUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class q {
    private static final String TAG = "TypefaceCompatUtil";

    /* JADX INFO: compiled from: TypefaceCompatUtil.java */
    static class a {
        static ParcelFileDescriptor a(ContentResolver r0, Uri r1, String r2, CancellationSignal r3) {
            return r0.openFileDescriptor(r1, r2, r3);
        }
    }

    public static File a(Context r5) {
        File r6 = ((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin")).getCacheDir();
        if (r6 != null) goto L5;
        return null;
    L5:
        String r1 = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
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

    private static ByteBuffer a(File r7) {
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

    public static ByteBuffer a(Context r7, CancellationSignal r8, Uri r9) {
        ParcelFileDescriptor r10 = a.a(((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin")).getContentResolver(), r9, DownloadFileUtils.MODE_READ, r8);     // Catch: IOException -> L27
        if (r10 != null) goto L33;
        if (r10 == null) goto L7;
        r10.close();     // Catch: IOException -> L27
    L7:
        return null;
    L33:
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
        if (r10 != null) goto L28;
    L26:
        throw th;     // Catch: IOException -> L27
    L28:
        r10.close();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L27
    L27:
        return null;
    }

    public static ByteBuffer a(Context r2, Resources r3, int r4) {
        File r5 = a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
        if (r5 != null) goto L15;
        return null;
    L15:
    L12:
        th = move-exception;
        r5.delete();
        throw th;
    L6:
        if (a(r5, r3, r4) == true) goto L9;
        r5.delete();
        return null;
    L9:
        ByteBuffer r6 = a(r5);     // Catch: Throwable -> L12
        r5.delete();
        return r6;
    }

    public static boolean a(File r5, InputStream r6) {
        StrictMode.ThreadPolicy r0 = StrictMode.allowThreadDiskWrites();
        FileOutputStream r2 = null;
        FileOutputStream r3 = new FileOutputStream(r5, false);     // Catch: Throwable -> L16 IOException -> L18
        byte[] r7 = new byte[1024];     // Catch: Throwable -> L12 IOException -> L14
    L6:
        int r4 = r6.read(r7);     // Catch: Throwable -> L12 IOException -> L14
        if (r4 == (-1)) goto L10;
        r3.write(r7, 0, r4);     // Catch: Throwable -> L12 IOException -> L14
    L10:
        a(r3);
        StrictMode.setThreadPolicy(r0);
        return true;
    L14:
        e = e;
        r2 = r3;
    L19:
        a(TAG, "Error copying resource contents to temp file: " + e.getMessage());     // Catch: Throwable -> L16
        a(r2);
        StrictMode.setThreadPolicy(r0);
        return false;
    L12:
        th = th;
        r2 = r3;
    L22:
        a(r2);
        StrictMode.setThreadPolicy(r0);
        throw th;
    L18:
        e = e;
    L16:
        th = th;
        goto L22
    }

    public static boolean a(File r0, Resources r1, int r2) {
        InputStream r3 = r1.openRawResource(r2);     // Catch: Throwable -> L8
        boolean r4 = a(r0, r3);     // Catch: Throwable -> L6
        a(r3);
        return r4;
    L6:
        th = th;
    L10:
        a(r3);
        throw th;
    L8:
        th = th;
        r3 = null;
        goto L10
    }

    public static void a(Closeable r2) {
        Closeable r3 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L9;
        r3.close();     // Catch: IOException -> L6
        return;
    L10:
        return;
    }

    public static Map<Uri, ByteBuffer> a(Context r5, FontsContractCompat.b[] r6, CancellationSignal r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        HashMap r0 = new HashMap();
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L13;
        FontsContractCompat.b r3 = r6[r2];
        if (r3.e() != 0) goto L11;
        Uri r4 = r3.a();
        if (r0.containsKey(r4) == true) goto L11;
        r0.put(r4, a(r8, r7, r4));
    L11:
        r2 = r2 + 1;
        goto L3
    L13:
        return Collections.unmodifiableMap(r0);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
