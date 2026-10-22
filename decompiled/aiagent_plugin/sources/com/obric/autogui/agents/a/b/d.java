package com.obric.autogui.agents.a.b;

import d.h.b.o;

/* JADX INFO: compiled from: ActionEffectDetector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static /* synthetic */ com.obric.autogui.agents.a.f.b a(b r0, com.obric.autogui.agents.a.f.k r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 8) == 0) goto L9;
        r4 = "";
    L9:
        return a(r0, r1, r2, r3, r4);
    }

    public static final com.obric.autogui.agents.a.f.b a(b r8, com.obric.autogui.agents.a.f.k r9, String r10, String r11, String r12) {
        o.e(r8, "<this>");
        o.e(r9, "status");
        o.e(r10, "evidence");
        o.e(r12, "logDetails");
        return new com.obric.autogui.agents.a.f.b(r8.c(), r9, r10, null, r12, 8, null);
    }
}
