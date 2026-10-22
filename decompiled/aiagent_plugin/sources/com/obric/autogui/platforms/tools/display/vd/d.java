package com.obric.autogui.platforms.tools.display.vd;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.o.o;

/* JADX INFO: compiled from: TaskFrontLiveTopGate.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final c a(b r7, b r8) {
        if (r7 == null) goto L64;
        if (r8 == null) goto L64;
        if (r7.a() <= 0) goto L62;
        if (r8.a() <= 0) goto L62;
        String r0 = r7.b();
        if (r0 == null) goto L60;
        String r3 = null;
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L16;
        r0 = null;
    L16:
        if (r0 == null) goto L60;
        String r1 = r7.c();
        if (r1 == null) goto L58;
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L24;
        r1 = null;
    L24:
        if (r1 == null) goto L58;
        String r4 = r8.b();
        if (r4 == null) goto L56;
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L32;
        r4 = null;
    L32:
        if (r4 == null) goto L56;
        String r5 = r8.c();
        if (r5 == null) goto L54;
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L39;
        r3 = r5;
    L39:
        if (r3 == null) goto L54;
        if (d.h.b.o.a(r0, r4) == false) goto L52;
        if (d.h.b.o.a(r1, r3) == false) goto L52;
        if (r7.a() != r8.a()) goto L50;
        return c.f30194a;
    L50:
        return c.f30195b;
    L52:
        return c.f30196c;
    L54:
        return c.f30197d;
    L56:
        return c.f30197d;
    L58:
        return c.f30197d;
    L60:
        return c.f30197d;
    L62:
        return c.f30197d;
    L64:
        return c.f30197d;
    }

    public static final e b(b r10, b r11) {
        c r12 = a(r10, r11);
        if (r12.a() == false) goto L19;
        if (r11 == null) goto L19;
        String r0 = r11.b();
        if (r0 == null) goto L17;
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L12;
        r0 = null;
    L12:
        String r8 = r0;
        if (r8 == null) goto L17;
        int r7 = r11.a();
        return (e) ZeusTransformUtils.preCheckCast(new e.a(r12, r11, new f(r7, r7, r7, r7, r7, r8)), e.class, "com.obric.aiagent.plugin");
    L17:
        return (e) ZeusTransformUtils.preCheckCast(new e.b(c.f30197d), e.class, "com.obric.aiagent.plugin");
    L19:
        return (e) ZeusTransformUtils.preCheckCast(new e.b(r12), e.class, "com.obric.aiagent.plugin");
    }

    public static final boolean a(String r0, String r1, boolean r2) {
        if (r2 == true) goto L4;
    L6:
        return false;
    L4:
        if (d.h.b.o.a(r0, r1) == false) goto L6;
        return true;
    }
}
