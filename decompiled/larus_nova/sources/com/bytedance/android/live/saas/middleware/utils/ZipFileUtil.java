package com.bytedance.android.live.saas.middleware.utils;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes47.dex */
public class ZipFileUtil {
    private static final int NUM_2048 = 2048;

    private ZipFileUtil() {
    }

    public static boolean removeDir(File r100) {
        if (r100.isDirectory() == false) goto L21;
        File[] r101 = r100.listFiles();
        if (r101 == null) goto L19;
        if (r101.length == 0) goto L19;
        int r102 = r101.length;
        int r103 = 0;
    L10:
        if (r103 >= r102) goto L17;
        File r104 = r101[r103];
        if (r104.isDirectory() == false) goto L14;
        removeDir(r104);
    L15:
        r103 = r103 + 1;
        goto L10
    L14:
        r104.delete();
        goto L15
    L17:
        return r100.delete();
    L19:
        return r100.delete();
    L21:
        return r100.delete();
    }

    public static void unZipFolder(String r100, String r101) throws Exception {
        ZipInputStream r102 = new ZipInputStream(new BufferedInputStream(new PolarisFileInputStreamWrapper(r100)));
    L3:
        ZipEntry r103 = r102.getNextEntry();
        if (r103 == null) goto L20;
        String r104 = r103.getName();
        if (r104.contains(DownloadConstants.VULNERABILITY_PATH) == true) goto L3;
        if (r103.isDirectory() == true) goto L10;
        PolarisFileWrapper r105 = new PolarisFileWrapper(r101 + File.separator + r104);
        if (r105.exists() == false) goto L14;
        r105.delete();
    L15:
        r105.createNewFile();
        BufferedOutputStream r106 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r105));
        byte[] r107 = new byte[2048];
    L16:
        int r108 = r102.read(r107);
        if (r108 == (-1)) goto L19;
        r106.write(r107, 0, r108);
        goto L16
    L19:
        r106.flush();
        r106.close();
        goto L3
    L14:
        r105.getParentFile().mkdirs();
        goto L15
    L10:
        new PolarisFileWrapper(r101 + File.separator + r104).mkdirs();
        goto L3
    L20:
        r102.close();
    }
}
