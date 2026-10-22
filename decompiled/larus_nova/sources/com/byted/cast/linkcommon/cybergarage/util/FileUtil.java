package com.byted.cast.linkcommon.cybergarage.util;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes28.dex */
public final class FileUtil {
    public FileUtil() {
    }

    public static final boolean isXMLFileName(String r100) {
        if (StringUtil.hasData(r100) == true) goto L7;
        return false;
    L7:
        return r100.toLowerCase().endsWith("xml");
    }

    public static final byte[] load(File r100) {
        PolarisFileInputStreamWrapper r101 = null;
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L11 Exception -> L13
        byte[] r103 = load(r102);     // Catch: Throwable -> L7 Exception -> L9
        r102.close();     // Catch: IOException -> L21
    L6:
        return r103;
    L9:
        e = e;
        r101 = r102;
    L14:
        Debug.warning(e);     // Catch: Throwable -> L11
        byte[] r104 = new byte[0];     // Catch: Throwable -> L11
        if (r101 != null) goto L28;
    L17:
        return r104;
    L28:
        r101.close();     // Catch: IOException -> L23
    L7:
        th = th;
        r101 = r102;
    L18:
        if (r101 != null) goto L24;
    L20:
        throw th;
    L24:
        r101.close();     // Catch: IOException -> L22
    L11:
        th = th;
    L13:
        e = e;
        goto L14
    }

    public static final byte[] load(String r100) {
        PolarisFileInputStreamWrapper r101 = null;
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L11 Exception -> L13
        byte[] r103 = load(r102);     // Catch: Throwable -> L7 Exception -> L9
        r102.close();     // Catch: IOException -> L21
    L6:
        return r103;
    L9:
        e = e;
        r101 = r102;
    L14:
        Debug.warning(e);     // Catch: Throwable -> L11
        byte[] r104 = new byte[0];     // Catch: Throwable -> L11
        if (r101 != null) goto L28;
    L17:
        return r104;
    L28:
        r101.close();     // Catch: IOException -> L23
    L7:
        th = th;
        r101 = r102;
    L18:
        if (r101 != null) goto L24;
    L20:
        throw th;
    L24:
        r101.close();     // Catch: IOException -> L22
    L11:
        th = th;
    L13:
        e = e;
        goto L14
    }

    public static final byte[] load(FileInputStream r100) {
        byte[] r101 = new byte[524288];
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();     // Catch: Exception -> L8
        int r103 = r100.read(r101);     // Catch: Exception -> L8
    L4:
        if (r103 <= 0) goto L6;
        r102.write(r101, 0, r103);     // Catch: Exception -> L8
        r103 = r100.read(r101);     // Catch: Exception -> L8
        goto L4
    L6:
        r100.close();     // Catch: Exception -> L8
        return r102.toByteArray();
    L8:
        e = move-exception;
        Debug.warning(e);
        return new byte[0];
    }
}
