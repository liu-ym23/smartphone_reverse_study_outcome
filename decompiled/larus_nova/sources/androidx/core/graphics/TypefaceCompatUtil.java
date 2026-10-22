package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import androidx.core.provider.FontsContractCompat;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.b;
import f06.d;
import g06.a;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes17.dex */
public class TypefaceCompatUtil {
    private static final String CACHE_FILE_PREFIX = ".font";
    private static final String TAG = "TypefaceCompatUtil";

    private TypefaceCompatUtil() {
    }

    public static void closeQuietly(Closeable r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public static File getTempFile(Context r100) {
        File r101 = r100.getCacheDir();
        if (r101 != null) goto L5;
        return null;
    L5:
        String r102 = CACHE_FILE_PREFIX + Process.myPid() + "-" + Process.myTid() + "-";
        int r103 = 0;
    L7:
        if (r103 >= 100) goto L13;
        File r104 = new File(r101, r102 + r103);
        if (r104.createNewFile() == false) goto L12;
        return r104;
    L12:
        r103 = r103 + 1;
        goto L7
    L13:
        return null;
    }

    private static ByteBuffer mmap(File r100) {
        FileInputStream r101 = new FileInputStream(r100);     // Catch: IOException -> L12
        FileChannel r102 = r101.getChannel();     // Catch: Throwable -> L6
        long r103 = r102.size();     // Catch: Throwable -> L6
        MappedByteBuffer r104 = r102.map(FileChannel.MapMode.READ_ONLY, 0, r103);     // Catch: Throwable -> L6
        r101.close();     // Catch: IOException -> L12
        return r104;
    L6:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L9
    L11:
        throw th;     // Catch: IOException -> L12
    L9:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L12
    L12:
        return null;
    }

    public static boolean copyToFile(File r100, InputStream r101) {
        StrictMode.ThreadPolicy r102 = StrictMode.allowThreadDiskWrites();
        FileOutputStream r103 = null;
        FileOutputStream r104 = new FileOutputStream(r100, false);     // Catch: Throwable -> L16 IOException -> L18
        byte[] r105 = new byte[1024];     // Catch: Throwable -> L12 IOException -> L14
    L6:
        int r106 = r101.read(r105);     // Catch: Throwable -> L12 IOException -> L14
        if (r106 == (-1)) goto L10;
        r104.write(r105, 0, r106);     // Catch: Throwable -> L12 IOException -> L14
    L10:
        closeQuietly(r104);
        StrictMode.setThreadPolicy(r102);
        return true;
    L14:
        e = e;
        r103 = r104;
    L19:
        e.getMessage();     // Catch: Throwable -> L16
        closeQuietly(r103);
        StrictMode.setThreadPolicy(r102);
        return false;
    L12:
        th = th;
        r103 = r104;
    L22:
        closeQuietly(r103);
        StrictMode.setThreadPolicy(r102);
        throw th;
    L18:
        e = e;
    L16:
        th = th;
        goto L22
    }

    public static ByteBuffer copyToDirectBuffer(Context r100, Resources r101, int r102) {
        File r103 = getTempFile(r100);
        if (r103 != null) goto L15;
        return null;
    L15:
    L12:
        th = move-exception;
        r103.delete();
        throw th;
    L6:
        if (copyToFile(r103, r101, r102) == true) goto L9;
        r103.delete();
        return null;
    L9:
        ByteBuffer r104 = mmap(r103);     // Catch: Throwable -> L12
        r103.delete();
        return r104;
    }

    public static boolean copyToFile(File r100, Resources r101, int r102) {
        InputStream r103 = r101.openRawResource(r102);     // Catch: Throwable -> L8
        boolean r104 = copyToFile(r100, r103);     // Catch: Throwable -> L6
        closeQuietly(r103);
        return r104;
    L6:
        th = th;
    L10:
        closeQuietly(r103);
        throw th;
    L8:
        th = th;
        r103 = null;
        goto L10
    }

    public static ByteBuffer mmap(Context r100, CancellationSignal r101, Uri r102) {
        ParcelFileDescriptor r103 = androidx_core_graphics_TypefaceCompatUtil_android_content_ContentResolver_openFileDescriptor(r100.getContentResolver(), r102, "r", r101);     // Catch: IOException -> L25
        if (r103 != null) goto L33;
        if (r103 == null) goto L7;
        r103.close();     // Catch: IOException -> L25
    L7:
        return null;
    L33:
        FileInputStream r104 = new FileInputStream(r103.getFileDescriptor());     // Catch: Throwable -> L19
        FileChannel r105 = r104.getChannel();     // Catch: Throwable -> L13
        long r106 = r105.size();     // Catch: Throwable -> L13
        MappedByteBuffer r107 = r105.map(FileChannel.MapMode.READ_ONLY, 0, r106);     // Catch: Throwable -> L13
        r104.close();     // Catch: Throwable -> L19
        r103.close();     // Catch: IOException -> L25
        return r107;
    L13:
        th = move-exception;
        r104.close();     // Catch: Throwable -> L16
    L18:
        throw th;     // Catch: Throwable -> L19
    L16:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r103.close();     // Catch: Throwable -> L22
    L24:
        throw th;     // Catch: IOException -> L25
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L25
    L25:
        return null;
    }

    public static Map<Uri, ByteBuffer> readFontInfoIntoByteBuffer(Context r100, FontsContractCompat.FontInfo[] r101, CancellationSignal r102) {
        HashMap r103 = new HashMap();
        int r104 = r101.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L13;
        FontsContractCompat.FontInfo r106 = r101[r105];
        if (r106.getResultCode() != 0) goto L11;
        Uri r107 = r106.getUri();
        if (r103.containsKey(r107) == true) goto L11;
        r103.put(r107, mmap(r100, r102, r107));
    L11:
        r105 = r105 + 1;
        goto L3
    L13:
        return Collections.unmodifiableMap(r103);
    }

    private static ParcelFileDescriptor androidx_core_graphics_TypefaceCompatUtil_android_content_ContentResolver_openFileDescriptor(ContentResolver r110, Uri r111, String r210, CancellationSignal r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210, r211};
        b r112 = new b();
        a r102 = ApiHookConfig.f245611b.get(240020);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r110, r101, "android.os.ParcelFileDescriptor", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ParcelFileDescriptor) r107.f474983b;
    L21:
        return r110.openFileDescriptor(r111, r210, r211);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
