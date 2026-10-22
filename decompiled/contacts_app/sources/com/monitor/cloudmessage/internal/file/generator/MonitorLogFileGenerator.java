package com.monitor.cloudmessage.internal.file.generator;

import android.content.Context;
import android.text.TextUtils;
import com.monitor.cloudmessage.utils.FileUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class MonitorLogFileGenerator {
    public MonitorLogFileGenerator() {
    }

    public static File generateFile(Context r4, String r5, String r6) {
        BufferedWriter r1 = null;
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        String r7 = FileUtils.getCloudMsgDir(r4).getAbsolutePath();
        String r8 = r7 + File.separator + r6 + ".txt";
        File r0 = new File(r7);     // Catch: Throwable -> L27 IOException -> L29
        if (r0.exists() == true) goto L9;
        r0.mkdirs();     // Catch: Throwable -> L27 IOException -> L29
    L9:
        FileWriter r9 = new FileWriter(r8);     // Catch: Throwable -> L27 IOException -> L29
        BufferedWriter r2 = new BufferedWriter(r9);     // Catch: Throwable -> L22 IOException -> L24
    L62:
        r2.write(r5);     // Catch: Throwable -> L18 IOException -> L20
        r2.close();     // Catch: IOException -> L14
        r9.close();     // Catch: IOException -> L14
    L17:
        return new File(r8);
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L20:
        e = e;
    L26:
        IOException r3 = e;
        FileWriter r10 = r9;
        e = r3;
    L54:
        e.printStackTrace();     // Catch: Throwable -> L41
        if (r2 != null) goto L52;
    L36:
        if (r10 == null) goto L40;
        r10.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
    L40:
        return null;
    L52:
        r2.close();     // Catch: IOException -> L34
    L41:
        th = th;
        r1 = r2;
    L43:
        if (r1 != null) goto L58;
    L47:
        if (r10 == null) goto L51;
        r10.close();     // Catch: IOException -> L45
    L45:
        e = move-exception;
        e.printStackTrace();
    L51:
        throw th;
    L58:
        r1.close();     // Catch: IOException -> L45
    L18:
        th = th;
        r1 = r2;
    L23:
        Throwable r11 = th;
        r10 = r9;
        th = r11;
    L24:
        e = e;
        r2 = null;
    L22:
        th = th;
        goto L23
    L29:
        e = e;
        r10 = null;
        r2 = null;
    L27:
        th = th;
        r10 = null;
        goto L43
    }
}
