package com.baidu.xclient.gdid.j;

import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes39.dex */
public class f {
    public static void a(Throwable r100) {
        r100.printStackTrace();
    }

    public static String b(Throwable r100) {
        StringWriter r101 = new StringWriter(1024);     // Catch: Throwable -> L4
        PrintWriter r102 = new PrintWriter(r101);     // Catch: Throwable -> L4
        r100.printStackTrace(r102);     // Catch: Throwable -> L4
        r102.close();     // Catch: Throwable -> L4
        return r101.toString();
    L4:
        th = move-exception;
        a(th);
        return "";
    }
}
