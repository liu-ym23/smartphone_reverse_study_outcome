package com.bytedance.amap.utils;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes43.dex */
public class FileUtil {
    public FileUtil() {
    }

    public static byte[] readAllBytes(InputStream r100) throws IOException {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        copyAllBytes(r100, r101);
        return r101.toByteArray();
    }

    public static int copyAllBytes(InputStream r100, OutputStream r101) throws IOException {
        byte[] r102 = new byte[4096];
        int r103 = 0;
    L3:
        int r104 = r100.read(r102);
        if (r104 == (-1)) goto L5;
        r101.write(r102, 0, r104);
        r103 = r103 + r104;
        goto L3
    L5:
        return r103;
    }

    public static byte[] readFileFromAssets(Context r100, String r101) throws IOException {
        if (r100 == null) goto L12;
        if (r101 == null) goto L16;
        InputStream r102 = r100.getResources().getAssets().open(r101);
        byte[] r103 = readAllBytes(r102);     // Catch: Throwable -> L9
        r102.close();
        return r103;
    L9:
        th = move-exception;
        r102.close();
        throw th;
    L16:
        return null;
    L12:
        return null;
    }
}
