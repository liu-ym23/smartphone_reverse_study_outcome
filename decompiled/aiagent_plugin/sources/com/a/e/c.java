package com.a.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: StringUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static boolean a(CharSequence r2) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
    L8:
        return true;
    L5:
        if (r3.length() == 0) goto L8;
        return false;
    }

    public static boolean a(CharSequence r11, char... r12) {
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.aiagent.plugin");
        if (a(r13) == true) goto L24;
        if (r12 == null) goto L24;
        if (r12.length == 0) goto L24;
        int r0 = r13.length();
        int r2 = r12.length;
        int r3 = r0 - 1;
        int r4 = r2 - 1;
        int r5 = 0;
    L9:
        if (r5 >= r0) goto L24;
        char r6 = r13.charAt(r5);
        int r7 = 0;
    L11:
        if (r7 >= r2) goto L23;
        if (r12[r7] != r6) goto L22;
        if (Character.isHighSurrogate(r6) == false) goto L21;
        if (r7 == r4) goto L17;
        if (r5 >= r3) goto L22;
        if (r12[r7 + 1] != r13.charAt(r5 + 1)) goto L22;
    L17:
        return true;
    L21:
        return true;
    L22:
        r7 = r7 + 1;
        goto L11
    L23:
        r5 = r5 + 1;
    L24:
        return false;
    }
}
