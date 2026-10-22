package com.c.a.i;

import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: compiled from: ExceptionUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String a(Throwable r2) {
        StringWriter r0 = new StringWriter();
        r2.printStackTrace(new PrintWriter(r0));
        return r0.toString();
    }
}
