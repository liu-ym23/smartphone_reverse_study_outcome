package com.bytedance.safetyguard.lxc.internal.e.a.a;

import com.bytedance.safetyguard.lxc.internal.e.a.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OAuthPollingModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class j {
    public static final <S> e a(String r13, String r14, S r15, f r16, String r17, com.bytedance.safetyguard.lxc.internal.e.c.g r18) {
        o.e(r16, "messages");
        if (r13 != null) goto L5;
        String r3 = "";
    L6:
        if (r18 == null) goto L8;
        String r4 = r18.d();
    L9:
        int r5 = r3.hashCode();
        if (r5 == (-1916631087)) goto L46;
        if (r5 == (-847806252)) goto L39;
        if (r5 == (-444618026)) goto L32;
        if (r5 == 0) goto L29;
        if (r5 == 772475936) goto L25;
        if (r5 == 1612125279) goto L22;
    L47:
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r2 = "oauth_error";
        if (d.o.o.d(r0) == false) goto L50;
        r0 = "oauth_error";
    L50:
        String r6 = (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L57;
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r1) == true) goto L56;
        r2 = r1;
    L56:
        String r7 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
    L64:
        return (e) ZeusTransformUtils.preCheckCast(new e.c(new m(r6, r7, r17, r18, null, 16, null)), e.class, "com.obric.aiagent.plugin");
    L57:
        r7 = r4;
        goto L64
    L22:
        if (r3.equals("expired_token") == false) goto L47;
    L42:
        if (r4 != null) goto L63;
        r4 = r16.b();
    L63:
        return (e) ZeusTransformUtils.preCheckCast(new e.c(new m(r3, r4, r17, r18, null, 16, null)), e.class, "com.obric.aiagent.plugin");
    L25:
        if (r3.equals("slow_down") == false) goto L47;
        return (e) ZeusTransformUtils.preCheckCast(new e.b(r15, b.f10303c), e.class, "com.obric.aiagent.plugin");
    L29:
        if (r3.equals("") == false) goto L47;
    L60:
        return (e) ZeusTransformUtils.preCheckCast(new e.b(r15, b.f10301a), e.class, "com.obric.aiagent.plugin");
    L32:
        if (r3.equals("access_denied") == false) goto L47;
        if (r4 != null) goto L62;
        r4 = r16.a();
    L62:
        return (e) ZeusTransformUtils.preCheckCast(new e.c(new m(r3, r4, r17, r18, null, 16, null)), e.class, "com.obric.aiagent.plugin");
    L39:
        if (r3.equals("invalid_grant") == true) goto L42;
    L46:
        if (r3.equals("authorization_pending") == true) goto L60;
    L8:
        r4 = r14;
        goto L9
    L5:
        r3 = r13;
        goto L6
    }
}
