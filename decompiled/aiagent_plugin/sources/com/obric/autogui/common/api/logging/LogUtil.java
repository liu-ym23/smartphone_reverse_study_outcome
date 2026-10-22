package com.obric.autogui.common.api.logging;

import d.h.b.o;

/* JADX INFO: compiled from: LogUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LogUtil {
    public static final LogUtil INSTANCE = null;

    static {
        INSTANCE = new LogUtil();
    }

    private LogUtil() {
    }

    public final String getCLAZZ_TAG(Object r2) {
        o.e(r2, "<this>");
        String r1 = r2.getClass().getSimpleName();
        int r3 = r1.length();
        o.a(r1);
        if (r3 <= 23) goto L7;
        String r4 = r1.substring(0, 23);
        o.c(r4, "substring(...)");
        return r4;
    L7:
        return r1;
    }
}
