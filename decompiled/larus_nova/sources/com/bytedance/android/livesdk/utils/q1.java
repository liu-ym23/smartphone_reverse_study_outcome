package com.bytedance.android.livesdk.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes11.dex */
public final class q1 {
    public static void a(File r100) {
        if (r100.isDirectory() == false) goto L20;
        File[] r101 = r100.listFiles();
        if (r101 != null) goto L7;
    L18:
        r100.delete();
        return;
    L7:
        if (r101.length == 0) goto L18;
        int r102 = r101.length;
        int r103 = 0;
    L10:
        if (r103 >= r102) goto L16;
        File r104 = r101[r103];
        if (r104.isDirectory() == false) goto L14;
        a(r104);
    L15:
        r103 = r103 + 1;
        goto L10
    L14:
        r104.delete();
        goto L15
    L16:
        r100.delete();
        return;
    L20:
        r100.delete();
    }

    public static void b(String r110, String r111) throws Exception {
        ZipInputStream r100 = new ZipInputStream(new BufferedInputStream(new PolarisFileInputStreamWrapper(r110)));
    L3:
        ZipEntry r101 = r100.getNextEntry();
        if (r101 == null) goto L23;
        String r102 = r101.getName();
        if (r102.contains("../") == true) goto L7;
        if (new PolarisFileWrapper(r111, r102).getCanonicalPath().startsWith(new PolarisFileWrapper(r111).getCanonicalPath()) == false) goto L10;
        if (r101.isDirectory() == true) goto L13;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r111 + File.separator + r102);
        if (r103.exists() == false) goto L17;
        r103.delete();
    L18:
        r103.createNewFile();
        BufferedOutputStream r104 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r103));
        byte[] r105 = new byte[2048];
    L19:
        int r106 = r100.read(r105);
        if (r106 == (-1)) goto L22;
        r104.write(r105, 0, r106);
        goto L19
    L22:
        r104.flush();
        r104.close();
        goto L3
    L17:
        r103.getParentFile().mkdirs();
        goto L18
    L13:
        new PolarisFileWrapper(r111 + File.separator + r102).mkdirs();
        goto L3
    L10:
        ALogger.e("FileUtil", "unZipFolder slip exception; name=" + r102 + ", outPath=" + r111 + ", zipFilePath=" + r110);
        SafetyGuard.b(new SecurityException("live unzip slip exception;"));
        goto L3
    L7:
        ALogger.e("FileUtil", "unZipFolder slip exception; name=" + r102 + ", outPath=" + r111 + ", zipFilePath=" + r110);
        SafetyGuard.b(new SecurityException("live unzip slip exception;"));
        goto L3
    L23:
        r100.close();
        ALogger.i("FileUtil", "UNZIP FINISH; zipFilePath=" + r110 + ", outPath=" + r111);
    }
}
