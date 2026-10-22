package com.bytedance.common.utility.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: IOUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static void a(String r7) {
        File r0 = new File(r7);
        if (r0.exists() == true) goto L6;
        return;
    L6:
        if (r0.isFile() == false) goto L9;
        r0.delete();
        return;
    L9:
        String[] r1 = r0.list();
        if (r1 != null) goto L12;
        return;
    L12:
        int r2 = r1.length;
        int r3 = 0;
    L13:
        if (r3 >= r2) goto L28;
        String r4 = r1[r3];
        if (r4 == null) goto L27;
        if (r7.endsWith(File.separator) == false) goto L20;
        String r5 = r7 + r4;
    L21:
        File r6 = new File(r5);
        if (r6.isFile() == false) goto L25;
        r6.delete();
    L25:
        if (r6.isDirectory() == false) goto L27;
        a(r5);
        goto L27
    L20:
        r5 = r7 + File.separator + r4;
    L27:
        r3 = r3 + 1;
        goto L13
    L28:
        r0.delete();
    }

    public static boolean a(String r1, String r2) {
        File r0 = new File(r1);
        File r3 = new File(r2);
        if (r0.exists() == true) goto L7;
        return false;
    L7:
        return r0.renameTo(r3);
    }

    public static void a(Closeable r2) {
        Closeable r3 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L8;
        return;
    L8:
        r3.close();     // Catch: IOException -> L7
        return;
    }
}
