package bz2;

import android.content.Context;
import android.os.Environment;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes12.dex */
public final class d {
    public static void b(PolarisFileWrapper r100) {
        File r101 = r100.getParentFile();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L19;
    L14:
        c.a();
        return;
    L11:
        if (r100.exists() == true) goto L18;
        r100.createNewFile();     // Catch: IOException -> L14
        return;
    L18:
        return;
    L19:
        return;
    L5:
        if (r101.exists() == true) goto L8;
        r102 = r101.mkdirs();
        goto L9
    }

    public static void delete(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == false) goto L6;
        r101.delete();
        return;
    }

    public static void delete(File r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.exists() == false) goto L8;
        r100.delete();
        return;
    }

    public static File a(Context r100, String r101) {
        if (r100 == null) goto L22;
        String r102 = Environment.getExternalStorageState();
        boolean r103 = false;
        if ("mounted".equals(r102) == false) goto L6;
    L9:
        boolean r104 = true;
    L10:
        if (r104 == false) goto L26;
        r103 = "mounted".equals(Environment.getExternalStorageState());     // Catch: Exception -> L13
    L14:
        if (r103 == false) goto L27;
        File r105 = r100.getExternalFilesDir(r101);
        if (r105 != null) goto L19;
    L21:
        return r105;
    L19:
        if (r105.exists() == true) goto L21;
        r105.mkdirs();
        goto L21
    L27:
        return null;
    L26:
        return null;
    L6:
        if ("mounted_ro".equals(r102) == true) goto L9;
        r104 = false;
        goto L10
    L22:
        return null;
    }

    public static synchronized void c(String r100, String r101) {
        monitor-enter(d.class);
        if (r100 != null) goto L7;
        monitor-exit(d.class);
        return;
    L7:
        if (r101 != null) goto L47;
        monitor-exit(d.class);
        return;
    L47:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);     // Catch: Throwable -> L39
        PolarisFileWriterWrapper r103 = null;
    L22:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L39
    L37:
        monitor-exit(d.class);
        return;
    L15:
        th = th;
    L27:
        if (r103 != null) goto L45;
    L32:
        throw th;     // Catch: Throwable -> L39
    L45:
        r103.close();     // Catch: IOException -> L30 Throwable -> L39
    L30:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L39
        goto L32
    L13:
        if (r102.exists() == true) goto L18;
        b(r102);     // Catch: Throwable -> L15 IOException -> L17
    L18:
        PolarisFileWriterWrapper r104 = new PolarisFileWriterWrapper(r102, true);     // Catch: Throwable -> L15 IOException -> L17
        r104.write(r101);     // Catch: Throwable -> L24 IOException -> L26
        r104.flush();     // Catch: Throwable -> L24 IOException -> L26
        r104.close();     // Catch: IOException -> L22 Throwable -> L39
    L42:
    L26:
        r103 = r104;
    L24:
        th = move-exception;
        th = th;
        r103 = r104;
        goto L27
    L33:
        if (r103 == null) goto L37;
        r103.close();     // Catch: IOException -> L22 Throwable -> L39
    L39:
        th = move-exception;
        throw th;
    }
}
