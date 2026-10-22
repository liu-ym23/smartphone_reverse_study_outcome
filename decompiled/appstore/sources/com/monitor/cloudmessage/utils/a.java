package com.monitor.cloudmessage.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static String a(Throwable r10) {
        StringWriter r11 = new StringWriter();
        r10.printStackTrace(new PrintWriter(r11));
        return r11.toString();
    }
}
