package com.obric.autogui.agents.vlm.models.omni.upload;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OmniUploadAtomicFilePublisher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o {
    public static final String a(String r7) {
        d.h.b.o.e(r7, "randomId");
        StringBuilder r0 = new StringBuilder().append(".omni_upload_pending_");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");
        Appendable r1 = (Appendable) ZeusTransformUtils.preCheckCast(new StringBuilder(), Appendable.class, "com.obric.aiagent.plugin");
        int r3 = r8.length();
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L8;
        char r5 = r8.charAt(r4);
        if (Character.isLetterOrDigit(r5) == false) goto L7;
        r1.append(r5);
    L7:
        r4 = r4 + 1;
        goto L3
    L8:
        String r9 = ((StringBuilder) ZeusTransformUtils.preCheckCast(r1, StringBuilder.class, "com.obric.aiagent.plugin")).toString();
        d.h.b.o.c(r9, "toString(...)");
        return r0.append(r9).toString();
    }
}
