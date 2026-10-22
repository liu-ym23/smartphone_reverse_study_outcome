package com.obric.autogui.agents.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ActionEffectLog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final String a(Throwable r4) {
        o.e(r4, "<this>");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r4.getClass().getSimpleName(), CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r0) == false) goto L6;
        String r5 = r4.getClass().getName();
        o.c(r5, "getName(...)");
        r0 = d.o.o.c(r5, '.', null, 2, null);
    L6:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ String a(String r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = 120;
    L6:
        return a(r0, r1);
    }

    public static final String a(String r13, int r14) {
        o.e(r13, "<this>");
        return d.o.o.e(d.o.o.a(d.o.o.a(r13, '\r', ' ', false, 4, null), '\n', ' ', false, 4, null), r14);
    }
}
