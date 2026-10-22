package com.obric.autoaction.app.launcherpage.detail.shortcut.data;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ShortInstructInputUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private static final boolean a(char r3) {
        if ('a' <= r3) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L10;
        return true;
    L10:
        if ('A' <= r3) goto L12;
    L14:
        boolean r4 = false;
    L15:
        if (r4 == false) goto L17;
        return true;
    L17:
        if ('0' <= r3) goto L19;
    L21:
        boolean r5 = false;
    L22:
        if (r5 == false) goto L24;
        return true;
    L24:
        if (19968 <= r3) goto L26;
    L28:
        boolean r6 = false;
    L29:
        if (r6 == false) goto L32;
        return true;
    L32:
        return false;
    L26:
        if (r3 >= 40870) goto L28;
        r6 = true;
        goto L29
    L19:
        if (r3 >= ':') goto L21;
        r5 = true;
        goto L22
    L12:
        if (r3 >= '[') goto L14;
        r4 = true;
        goto L15
    L5:
        if (r3 >= '{') goto L7;
        r2 = true;
        goto L8
    }

    public static final d a(String r8) {
        o.e(r8, "input");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin");
        Appendable r2 = (Appendable) ZeusTransformUtils.preCheckCast(new StringBuilder(), Appendable.class, "com.obric.aiagent.plugin");
        int r3 = r0.length();
        boolean r4 = false;
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L8;
        char r6 = r0.charAt(r5);
        if (a(r6) == false) goto L7;
        r2.append(r6);
    L7:
        r5 = r5 + 1;
        goto L3
    L8:
        String r1 = ((StringBuilder) ZeusTransformUtils.preCheckCast(r2, StringBuilder.class, "com.obric.aiagent.plugin")).toString();
        o.c(r1, "toString(...)");
        String r7 = d.o.o.e(r1, 5);
        if (r1.length() == r8.length()) goto L11;
        boolean r9 = true;
    L13:
        if (r1.length() <= 5) goto L16;
        r4 = true;
    L16:
        return new d(r7, r9, r4);
    L11:
        r9 = false;
        goto L13
    }
}
