package com.ttnet.org.chromium.net;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public class TTPatternUtil {
    public TTPatternUtil() {
    }

    public static boolean isPatternStringValid(String r0) {
        Pattern.compile(r0);     // Catch: Throwable -> L5
        return true;
    L5:
        return false;
    }
}
