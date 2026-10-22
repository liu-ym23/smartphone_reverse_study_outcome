package com.obric.autoaction.app.launcherpage.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: StringExt.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l {
    public static final String a(String r2, int r3, int r4) {
        d.h.b.o.e(r2, "<this>");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L12;
        if (r3 < 0) goto L13;
        if (r4 < 0) goto L14;
        String r5 = r2.substring(Math.min(r3, r2.length() - 1), Math.min(r4, r2.length()));
        d.h.b.o.c(r5, "substring(...)");
        return r5;
    L14:
        return r2;
    L13:
        return r2;
    L12:
        return r2;
    L5:
        r0 = false;
        goto L6
    }
}
