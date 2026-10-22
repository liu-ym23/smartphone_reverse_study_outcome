package com.bytedance.retrofit2.e;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: MimeUtil.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f9512a = null;

    static {
        f9512a = Pattern.compile("\\Wcharset=([^\\s;]+)", 2);
    }

    public static String a(String r2, String r3) {
        Matcher r4 = f9512a.matcher(r2);     // Catch: IllegalArgumentException -> L7
        if (r4.find() == false) goto L6;
        return r4.group(1).replaceAll("[\"\\\\]", "");
    L6:
        return r3;
    }
}
