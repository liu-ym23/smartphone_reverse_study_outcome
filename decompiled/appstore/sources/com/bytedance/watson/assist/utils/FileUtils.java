package com.bytedance.watson.assist.utils;

import android.util.Log;
import com.bytedance.keva.KevaImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class FileUtils {

    public interface ReadLineCallback {
        boolean onReadLine(String r10);
    }

    public static void a(BufferedReader r10) {
        if (r10 == null) goto L10;
        r10.close();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        a7.a.c(Log.getStackTraceString(e));
        return;
    }

    public static BufferedReader b(File r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r10.exists() == true) goto L10;
        a7.a.h("file:" + r10.getName() + " not exist");
        return null;
    L10:
        if (r10.canRead() == true) goto L18;
        a7.a.h("file:" + r10.getName() + " can not read");
        return null;
    L18:
        return new BufferedReader(new FileReader(r10), KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);
    L15:
        e = move-exception;
        a7.a.c(Log.getStackTraceString(e));
        return null;
    }

    public static void c(File r10, ReadLineCallback r11) {
        if (r10 == null) goto L23;
        if (r11 == null) goto L24;
        BufferedReader r12 = b(r10);
        if (r12 != null) goto L8;
        return;
    L8:
        boolean r13 = true;
    L9:
        if (r13 == false) goto L16;
        String r14 = r12.readLine();     // Catch: IOException -> L14
        if (r14 == null) goto L16;
        r13 = r11.onReadLine(r14);     // Catch: IOException -> L14
    L14:
        e = move-exception;
        a7.a.c(Log.getStackTraceString(e));
    L16:
        a(r12);
        return;
    L24:
        return;
    }

    public static void d(String r10, ReadLineCallback r11) {
        if (r10 == null) goto L7;
        if (r11 == null) goto L8;
        c(new File(r10), r11);
        return;
    L8:
        return;
    }
}
