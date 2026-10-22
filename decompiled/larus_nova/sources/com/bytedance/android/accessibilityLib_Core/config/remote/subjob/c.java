package com.bytedance.android.accessibilityLib_Core.config.remote.subjob;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import java.io.File;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class c {
    public static void a(PolarisFileWrapper r100, PolarisFileWrapper r110) {
        PolarisZipFileWrapper r101 = new PolarisZipFileWrapper(r100);     // Catch: Exception -> L25
        Enumeration<? extends ZipEntry> r102 = r101.entries();     // Catch: Exception -> L25
    L4:
        if (r102.hasMoreElements() == false) goto L41;
        ZipEntry r103 = r102.nextElement();     // Catch: Exception -> L25
        String r104 = r103.getName();     // Catch: Exception -> L25
        if (StringsKt.contains$default(r104, "../", false, 2, null) == true) goto L24;
        if (StringsKt.startsWith$default(new PolarisFileWrapper(r110, r104).getCanonicalPath(), r110.getCanonicalPath(), false, 2, null) == false) goto L22;
        PolarisFileWrapper r105 = new PolarisFileWrapper(r110, r104);     // Catch: Exception -> L25
        if (r103.isDirectory() == true) goto L12;
        File r106 = r105.getParentFile();     // Catch: Exception -> L25
        if (r106 == null) goto L16;
        r106.mkdirs();     // Catch: Exception -> L25
    L16:
        r105.createNewFile();     // Catch: Exception -> L25
        InputStream r107 = r101.getInputStream(r103);     // Catch: Exception -> L25
        PolarisFileOutputStreamWrapper r108 = new PolarisFileOutputStreamWrapper(r105);     // Catch: Exception -> L25
        byte[] r109 = new byte[1024];     // Catch: Exception -> L25
        int r111 = r107.read(r109);     // Catch: Exception -> L25
    L18:
        if (r111 == (-1)) goto L20;
        r108.write(r109, 0, r111);     // Catch: Exception -> L25
        r111 = r107.read(r109);     // Catch: Exception -> L25
        goto L18
    L20:
        r108.close();     // Catch: Exception -> L25
        r107.close();     // Catch: Exception -> L25
        goto L4
    L12:
        r105.mkdirs();     // Catch: Exception -> L25
        goto L4
    L22:
        throw new SecurityException("unzip slip");     // Catch: Exception -> L25
    L24:
        throw new SecurityException("unzip slip");     // Catch: Exception -> L25
    L41:
        return;
    L25:
        e = move-exception;
        if (("unzip error>>> " + e.getMessage()) == null) goto L40;
        Context r112 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
        return;
    }
}
