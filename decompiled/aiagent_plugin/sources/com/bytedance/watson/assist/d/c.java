package com.bytedance.watson.assist.d;

import android.util.Log;
import com.bytedance.keva.KevaImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: compiled from: FileUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: compiled from: FileUtils.java */
    public interface a {
        boolean a(String r1);
    }

    public static BufferedReader a(File r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.exists() == true) goto L10;
        b.c("file:" + r3.getName() + " not exist");
        return null;
    L10:
        if (r3.canRead() == true) goto L18;
        b.c("file:" + r3.getName() + " can not read");
        return null;
    L18:
        return new BufferedReader(new FileReader(r3), KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);
    L15:
        e = move-exception;
        b.d(Log.getStackTraceString(e));
        return null;
    }

    public static void a(BufferedReader r0) {
        if (r0 == null) goto L10;
        r0.close();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        b.d(Log.getStackTraceString(e));
        return;
    }

    public static void a(File r2, a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L24;
        if (r4 == null) goto L25;
        BufferedReader r5 = a(r2);
        if (r5 != null) goto L9;
        return;
    L9:
        boolean r0 = true;
    L10:
        if (r0 == false) goto L17;
        String r1 = r5.readLine();     // Catch: IOException -> L15
        if (r1 == null) goto L17;
        r0 = r4.a(r1);     // Catch: IOException -> L15
    L15:
        e = move-exception;
        b.d(Log.getStackTraceString(e));
    L17:
        a(r5);
        return;
    L25:
        return;
    }

    public static void a(String r2, a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L8;
        if (r4 == null) goto L9;
        a(new File(r2), r4);
        return;
    L9:
        return;
    }
}
