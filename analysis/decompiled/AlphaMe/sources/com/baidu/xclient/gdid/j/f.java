package com.baidu.xclient.gdid.j;

import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: classes.dex */
public class f {
    public static void a(Throwable th) {
        th.printStackTrace();
    }

    public static String b(Throwable th) {
        try {
            StringWriter stringWriter = new StringWriter(1024);
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            printWriter.close();
            return stringWriter.toString();
        } catch (Throwable th2) {
            a(th2);
            return "";
        }
    }
}
