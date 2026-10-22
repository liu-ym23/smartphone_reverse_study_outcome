package com.bytedance.reparo.core.a.b;

import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: compiled from: ThrowableUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    public static String a(Throwable r2) {
        if (r2 != null) goto L5;
        return "";
    L5:
        StringWriter r0 = new StringWriter();
        r2.printStackTrace(new PrintWriter(r0));
        return r0.toString();
    }
}
