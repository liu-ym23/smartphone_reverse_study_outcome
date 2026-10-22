package bea;

import android.content.Context;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import com.ss.bytertc.engine.utils.LogUtil;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes33.dex */
public final class a {
    public static String b(String r100, Set<String> r101) {
        if (r100 != null) goto L4;
    L5:
        r100 = LogUtil.DIR_TAIL;
    L6:
        String r102 = r100.concat(".zip");
        HashSet r103 = (HashSet) r101;
        if (r103.add(r102) == false) goto L9;
        return r102;
    L9:
        int r104 = 2;
    L10:
        String r105 = r100 + "_" + r104 + ".zip";
        if (r103.add(r105) == true) goto L12;
        r104 = r104 + 1;
        goto L10
    L12:
        return r105;
    L4:
        if (r100.isEmpty() == false) goto L6;
        goto L5
    }

    public static String e(Context r110, String[] r111) throws IOException {
        String[] r100 = r111;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r110.getFilesDir(), "O_App_alogs.zip");
        if (r101.exists() == false) goto L92;
        r101.delete();
    L92:
        PolarisFileOutputStreamWrapper r102 = new PolarisFileOutputStreamWrapper(r101);     // Catch: IOException -> L85
        ZipOutputStream r103 = new ZipOutputStream(r102);     // Catch: Throwable -> L77
        HashSet r104 = new HashSet();     // Catch: Throwable -> L69
        int r105 = r100.length;     // Catch: Throwable -> L69
        int r112 = 0;
    L8:
        if (r112 >= r105) goto L65;
        String r106 = r100[r112];     // Catch: Throwable -> L69
        PolarisFileWrapper r113 = new PolarisFileWrapper(r106);     // Catch: Throwable -> L69
        if (r113.exists() == true) goto L13;
        FLogger.f375446a.w("LogFC-O-Auto", "Source directory {0} does not exist: " + r106);     // Catch: Throwable -> L69
    L28:
        HashSet r114 = r104;
    L51:
        r112 = r112 + 1;
        r100 = r111;
        r104 = r114;
        goto L8
    L13:
        File r115 = null;
        String r107 = b(r113.getName(), r104);     // Catch: Throwable -> L35 IOException -> L37
        r115 = c(r110, r113, r101);     // Catch: IOException -> L33 Throwable -> L35
        r103.putNextEntry(new ZipEntry(r107));     // Catch: IOException -> L33 Throwable -> L35
        boolean r116 = true;
        f(r115, r103);     // Catch: Throwable -> L29 IOException -> L31
        r103.closeEntry();     // Catch: IOException -> L21 Throwable -> L69
    L24:
        if (r115 == null) goto L28;
        if (r115.exists() == false) goto L28;
        r115.delete();     // Catch: Throwable -> L69
        goto L28
    L21:
        e = move-exception;
        FLogger.f375446a.e("LogFC-O-Auto", "Error closing zip entry for directory " + r113.getAbsolutePath() + " : " + e.getMessage());     // Catch: Throwable -> L69
        goto L24
    L31:
        e = e;
    L108:
        FLogger r117 = FLogger.f375446a;     // Catch: Throwable -> L52
        StringBuilder r108 = new StringBuilder();     // Catch: Throwable -> L52
        r114 = r104;
        r108.append("Error compressing directory ");     // Catch: Throwable -> L52
        r108.append(r113.getAbsolutePath());     // Catch: Throwable -> L52
        r108.append(" : ");     // Catch: Throwable -> L52
        r108.append(e.getMessage());     // Catch: Throwable -> L52
        r117.e("LogFC-O-Auto", r108.toString());     // Catch: Throwable -> L52
        if (r116 == true) goto L104;
    L47:
        if (r115 == null) goto L51;
        if (r115.exists() == false) goto L51;
        r115.delete();     // Catch: Throwable -> L69
        goto L51
    L104:
        r103.closeEntry();     // Catch: IOException -> L44 Throwable -> L69
    L44:
        e = move-exception;
        FLogger.f375446a.e("LogFC-O-Auto", "Error closing zip entry for directory " + r113.getAbsolutePath() + " : " + e.getMessage());     // Catch: Throwable -> L69
    L52:
        th = move-exception;
        Throwable r109 = th;
        boolean r118 = r116;
    L54:
        if (r118 == true) goto L106;
    L60:
        if (r115 != null) goto L62;
        throw r109;     // Catch: Throwable -> L69
    L62:
        if (r115.exists() == false) goto L120;
        r115.delete();     // Catch: Throwable -> L69
        throw r109;     // Catch: Throwable -> L69
    L120:
        throw r109;     // Catch: Throwable -> L69
    L106:
        r103.closeEntry();     // Catch: IOException -> L57 Throwable -> L69
    L57:
        e = move-exception;
        FLogger.f375446a.e("LogFC-O-Auto", "Error closing zip entry for directory " + r113.getAbsolutePath() + " : " + e.getMessage());     // Catch: Throwable -> L69
    L29:
        th = move-exception;
        r109 = th;
        r118 = true;
        goto L54
    L33:
        e = e;
    L39:
        r116 = false;
    L37:
        e = e;
    L35:
        th = move-exception;
        r109 = th;
        r118 = false;
        goto L54
    L65:
        r103.close();     // Catch: Throwable -> L77
        r102.close();     // Catch: IOException -> L85
        return r101.getAbsolutePath();
    L69:
        th = move-exception;
        r103.close();     // Catch: Throwable -> L73
    L121:
        throw th;     // Catch: Throwable -> L77
    L73:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L77
        throw th;     // Catch: Throwable -> L77
    L77:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L81
    L122:
        throw th;     // Catch: IOException -> L85
    L81:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L85
        throw th;     // Catch: IOException -> L85
    L85:
        e = move-exception;
        FLogger r119 = FLogger.f375446a;
        r119.e("LogFC-O-Auto", "Error compressing files to " + r101.getAbsolutePath() + " : " + e.getMessage());
        if (r101.exists() == true) goto L89;
    L91:
        throw e;
    L89:
        if (r101.delete() == true) goto L91;
        r119.w("LogFC-O-Auto", "Failed to delete invalid zip file: " + r101.getAbsolutePath());
        goto L91
    }

    public static void f(File r100, ZipOutputStream r101) throws IOException {
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);
        byte[] r103 = new byte[8192];     // Catch: Throwable -> L10
    L4:
        int r104 = r102.read(r103);     // Catch: Throwable -> L10
        if (r104 < 0) goto L8;
        r101.write(r103, 0, r104);     // Catch: Throwable -> L10
        goto L4
    L8:
        r102.close();
        return;
    L10:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L13
    L15:
        throw th;
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    public static void a(File r100, String r101, ZipOutputStream r102) {
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L29 IOException -> L31
        r102.putNextEntry(new ZipEntry(r101));     // Catch: Throwable -> L22
        byte[] r104 = new byte[8192];     // Catch: Throwable -> L20
    L7:
        int r105 = r103.read(r104);     // Catch: Throwable -> L20
        if (r105 < 0) goto L11;
        r102.write(r104, 0, r105);     // Catch: Throwable -> L20
        goto L7
    L11:
        r103.close();     // Catch: Throwable -> L16 IOException -> L18
        r102.closeEntry();     // Catch: IOException -> L14
        return;
    L14:
        e = e;
        FLogger r106 = FLogger.f375446a;
        StringBuilder r107 = new StringBuilder("Error closing zip entry for ");
    L39:
        r107.append(r100.getAbsolutePath());
        r107.append(" : ");
        r107.append(e.getMessage());
        r106.e("LogFC-O-Auto", r107.toString());
        return;
    L20:
        Throwable th10 = th;
    L47:
        r103.close();     // Catch: Throwable -> L26
    L28:
        throw th10;     // Catch: Throwable -> L16 IOException -> L18
    L26:
        th = move-exception;
        th10.addSuppressed(th);     // Catch: Throwable -> L16 IOException -> L18
    L22:
        th = move-exception;
        th10 = th;
        goto L47
    L16:
        Throwable th11 = th;
    L41:
        if (r101 != null) goto L56;
    L46:
        throw th11;
    L56:
        r102.closeEntry();     // Catch: IOException -> L44
    L44:
        e = move-exception;
        FLogger.f375446a.e("LogFC-O-Auto", "Error closing zip entry for " + r100.getAbsolutePath() + " : " + e.getMessage());
    L18:
        IOException e100 = e;
    L33:
        FLogger.f375446a.e("LogFC-O-Auto", "Error compressing file " + r100.getAbsolutePath() + " : " + e100.getMessage());     // Catch: Throwable -> L16
        if (r101 == null) goto L63;
        r102.closeEntry();     // Catch: IOException -> L37
        return;
    L37:
        e = e;
        r106 = FLogger.f375446a;
        r107 = new StringBuilder("Error closing zip entry for ");
        goto L39
    L63:
        return;
    L31:
        e = move-exception;
        e100 = e;
        r101 = null;
    L29:
        th = move-exception;
        th11 = th;
        r101 = null;
        goto L41
    }

    public static File c(Context r100, PolarisFileWrapper r101, PolarisFileWrapper r102) throws IOException {
        File r103 = r100.getCacheDir();
        if (r103.exists() == true) goto L5;
        r103.mkdirs();
    L5:
        File r104 = File.createTempFile("oapp_logs_", ".zip", r103);
        PolarisFileOutputStreamWrapper r105 = new PolarisFileOutputStreamWrapper(r104);
        ZipOutputStream r106 = new ZipOutputStream(r105);     // Catch: Throwable -> L17
        d(r101, r101.getName(), r106, r102);     // Catch: Throwable -> L11
        r106.close();     // Catch: Throwable -> L17
        r105.close();
        return r104;
    L11:
        th = move-exception;
        r106.close();     // Catch: Throwable -> L14
    L16:
        throw th;     // Catch: Throwable -> L17
    L14:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r105.close();     // Catch: Throwable -> L20
    L22:
        throw th;
    L20:
        th = move-exception;
        th.addSuppressed(th);
        goto L22
    }

    public static void d(File r100, String r101, ZipOutputStream r102, PolarisFileWrapper r103) {
        if (r100.isDirectory() == false) goto L17;
        File[] r104 = r100.listFiles();
        if (r104 == null) goto L25;
        int r105 = r104.length;
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L26;
        File r107 = r104[r106];
        if (r107.equals(r103) == true) goto L15;
        if (r107.isDirectory() == false) goto L14;
        d(r107, r101 + HTTP.URL_DEFAULT + r107.getName(), r102, r103);
        goto L15
    L14:
        a(r107, r101 + HTTP.URL_DEFAULT + r107.getName(), r102);
    L15:
        r106 = r106 + 1;
        goto L7
    L26:
        return;
    L25:
        return;
    L17:
        if (r100.equals(r103) == false) goto L19;
        return;
    L19:
        a(r100, r101, r102);
    }
}
