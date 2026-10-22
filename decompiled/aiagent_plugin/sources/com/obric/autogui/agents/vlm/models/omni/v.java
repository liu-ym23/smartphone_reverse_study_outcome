package com.obric.autogui.agents.vlm.models.omni;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OmniTerminationPolicy.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class v {
    public static final u a(int r7) {
        boolean r0 = true;
        if (r7 != 107002) goto L5;
        boolean r2 = true;
    L6:
        boolean r3 = w.f28887a.a(r7);
        if (r2 == true) goto L15;
        if (r3 == true) goto L15;
        if (com.obric.autogui.common.b.d.f29009a.b().contains(Integer.valueOf(r7)) == true) goto L15;
        if (com.obric.autogui.common.b.d.f29009a.a().contains(Integer.valueOf(r7)) == true) goto L15;
        boolean r5 = false;
    L16:
        if (r2 == true) goto L24;
        if (r3 == true) goto L24;
        if (r7 == 2) goto L24;
        if (r7 == 0) goto L24;
        r0 = false;
    L24:
        return new u(r5, r0);
    L15:
        r5 = true;
        goto L16
    L5:
        r2 = false;
        goto L6
    }

    public static final String a(Long r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        if (((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).longValue() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r5 = null;
    L11:
        if (r5 != null) goto L13;
        return null;
    L13:
        return r5.toString();
    L7:
        r1 = false;
        goto L8
    }

    public static final Long a(String r5) {
        d.h.b.o.e(r5, "rawMessageId");
        Long r6 = d.o.o.e(r5);
        if (r6 == null) goto L11;
        if (((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).longValue() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L11;
        return r6;
    L7:
        r1 = false;
    L11:
        return null;
    }
}
