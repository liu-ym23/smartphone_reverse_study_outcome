package com.bytedance.frameworks.baselib.network.http.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class CookieParser {
    public CookieParser() {
    }

    public static String getSpecialCookie(String r3, String r4) {
        Matcher r5 = Pattern.compile(".*(((" + r4 + "=[^;]*)|(" + r4 + "=\"[\";]*))|(" + r4 + "=.*$)).*").matcher(r3);     // Catch: IllegalArgumentException -> L7
        if (r5.matches() == false) goto L10;
        return r5.group(1);
    L10:
        return null;
    L11:
        return null;
    }
}
