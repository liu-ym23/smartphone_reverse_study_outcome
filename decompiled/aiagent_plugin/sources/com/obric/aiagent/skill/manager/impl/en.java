package com.obric.aiagent.skill.manager.impl;

import com.obric.aiagent.assistant.idl.bean.SkillSecurityDecisionAction;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: SkillSecurity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class en {

    /* JADX INFO: compiled from: SkillSecurity.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19828a = null;

        static {
            int[] r0 = new int[gi.values().length];
            r0[gi.f19988a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[gi.f19990c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[gi.f19989b.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f19828a = r0;
        }
    }

    /* JADX INFO: renamed from: lambda$ReL_HFUuq8rsx_5_8261-X2g9IE, reason: not valid java name */
    public static /* synthetic */ CharSequence m283lambda$ReL_HFUuq8rsx_5_8261X2g9IE(byte r0) {
        return a(r0);
    }

    public static final com.obric.aiagent.skill.manager.api.aj a(com.obric.aiagent.skill.manager.api.e r13, gj r14, eg r15) {
        d.h.b.o.e(r13, "skill");
        if (az.b(r13) == false) goto L5;
        if (r14 == null) goto L65;
        if (r14.b() != r13.j()) goto L65;
        gp r16 = go.a(r14);
        if (r16 == null) goto L13;
        String r0 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r16.a(), CharSequence.class, "com.obric.aiagent.plugin")).toString();
        boolean r3 = true;
        String r4 = null;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L17;
        String r6 = r0;
    L18:
        int r1 = a.f19828a[a(r16).ordinal()];
        if (r1 == 1) goto L63;
        if (r1 != 2) goto L23;
        String r17 = r16.d();
        if (r17 != null) goto L53;
    L55:
        r17 = null;
    L56:
        String r18 = r16.e();
        if (r18 == null) goto L67;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L67;
        r4 = r18;
    L67:
        return (com.obric.aiagent.skill.manager.api.aj) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.aj.b(r6, r17, r4), com.obric.aiagent.skill.manager.api.aj.class, "com.obric.aiagent.plugin");
    L53:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L55;
    L23:
        if (r1 != 3) goto L49;
        if (r6 == null) goto L26;
        if (r15 == null) goto L47;
        if (d.h.b.o.a(r15.a(), r13.a()) == true) goto L31;
    L35:
        r3 = false;
    L36:
        if (r3 == true) goto L39;
        r15 = null;
    L39:
        if (r15 == null) goto L47;
        com.obric.aiagent.skill.manager.api.ak r19 = r15.g();
        if (r19 != null) goto L66;
        return (com.obric.aiagent.skill.manager.api.aj) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.aj.b(r6, "SECURITY_RESULT_UNAVAILABLE", null, 4, null), com.obric.aiagent.skill.manager.api.aj.class, "com.obric.aiagent.plugin");
    L66:
        return (com.obric.aiagent.skill.manager.api.aj) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.aj.a(r6, r19), com.obric.aiagent.skill.manager.api.aj.class, "com.obric.aiagent.plugin");
    L31:
        if (r15.b() != r13.j()) goto L35;
        if (d.h.b.o.a(r15.c(), r6) == false) goto L35;
    L47:
        return (com.obric.aiagent.skill.manager.api.aj) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.aj.b(r6, "SECURITY_RESULT_UNAVAILABLE", null, 4, null), com.obric.aiagent.skill.manager.api.aj.class, "com.obric.aiagent.plugin");
    L26:
        return (com.obric.aiagent.skill.manager.api.aj) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.aj.b(null, "SECURITY_RESULT_UNAVAILABLE", null, 4, null), com.obric.aiagent.skill.manager.api.aj.class, "com.obric.aiagent.plugin");
    L49:
        throw new d.k();
    L63:
        return (com.obric.aiagent.skill.manager.api.aj) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.aj.e(r6), com.obric.aiagent.skill.manager.api.aj.class, "com.obric.aiagent.plugin");
    L17:
        r6 = null;
        goto L18
    L13:
        return (com.obric.aiagent.skill.manager.api.aj) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.api.aj.d.f19189a, com.obric.aiagent.skill.manager.api.aj.class, "com.obric.aiagent.plugin");
    L65:
        return (com.obric.aiagent.skill.manager.api.aj) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.api.aj.d.f19189a, com.obric.aiagent.skill.manager.api.aj.class, "com.obric.aiagent.plugin");
    L5:
        return (com.obric.aiagent.skill.manager.api.aj) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.api.aj.c.f19187a, com.obric.aiagent.skill.manager.api.aj.class, "com.obric.aiagent.plugin");
    }

    public static final gi a(gp r5) {
        d.h.b.o.e(r5, "<this>");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r5.d(), CharSequence.class, "com.obric.aiagent.plugin");
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L44;
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r5.e(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L13;
    L14:
        r1 = true;
    L15:
        if (r1 == false) goto L44;
        String r6 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r5.b(), CharSequence.class, "com.obric.aiagent.plugin")).toString();
        Locale r4 = Locale.ROOT;
        d.h.b.o.c(r4, "ROOT");
        String r7 = r6.toLowerCase(r4);
        d.h.b.o.c(r7, "toLowerCase(...)");
        switch(r7.hashCode()) {
            case -1402931637: goto L38;
            case -1281977283: goto L34;
            case -682587753: goto L30;
            case 108386723: goto L27;
            case 422194963: goto L24;
            case 2088273157: goto L21;
            default: goto L42;
        };
    L21:
        if (r7.equals("signing") == false) goto L42;
    L45:
        return gi.f19988a;
    L24:
        if (r7.equals("processing") == true) goto L45;
    L27:
        if (r7.equals("ready") == true) goto L45;
    L30:
        if (r7.equals("pending") == true) goto L45;
    L34:
        if (r7.equals("failed") == false) goto L42;
        return gi.f19990c;
    L38:
        if (r7.equals("completed") == false) goto L42;
        return gi.f19989b;
    L42:
        return gi.f19990c;
    L13:
        if (d.o.o.d(r3) == false) goto L15;
    L44:
        return gi.f19990c;
    L5:
        if (d.o.o.d(r0) == true) goto L8;
        r2 = false;
        goto L9
    }

    public static final boolean a(gj r14) {
        d.h.b.o.e(r14, "<this>");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r14.e(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
        return false;
    L5:
        String r0 = b(r14.e());
        if (d.h.b.o.a(r14.g(), "verified:" + r0) == false) goto L8;
        return true;
    L8:
        String r7 = null;
        if (d.o.o.b(r14.g(), "invalid:", false, 2, null) == false) goto L12;
        r7 = d.o.o.a(r14.g(), (CharSequence) ZeusTransformUtils.preCheckCast("invalid:", CharSequence.class, "com.obric.aiagent.plugin"));
    L14:
        if (r7 != null) goto L16;
        return false;
    L16:
        int r15 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), ':', 0, false, 6, null);
        if (r15 > 0) goto L19;
        return false;
    L19:
        String r3 = r7.substring(0, r15);
        d.h.b.o.c(r3, "substring(...)");
        String r16 = r7.substring(r15 + 1);
        d.h.b.o.c(r16, "substring(...)");
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(ah.a(), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L22;
    L24:
        Iterator r6 = r5.iterator();
    L26:
        if (r6.hasNext() == false) goto L23;
        String r8 = ((ah) ZeusTransformUtils.preCheckCast(r6.next(), ah.class, "com.obric.aiagent.plugin")).name();
        Locale r9 = Locale.ROOT;
        d.h.b.o.c(r9, "ROOT");
        String r10 = r8.toLowerCase(r9);
        d.h.b.o.c(r10, "toLowerCase(...)");
        if (d.h.b.o.a(r10, r3) == false) goto L26;
        boolean r2 = true;
    L30:
        if (r2 == true) goto L32;
        return false;
    L32:
        if (d.h.b.o.a(r16, r0) == true) goto L34;
        return false;
    L34:
        return true;
    L23:
        r2 = false;
        goto L30
    L22:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L24;
    L12:
        if (d.o.o.b(r14.g(), "accepted_unverified:", false, 2, null) == false) goto L14;
        r7 = d.o.o.a(r14.g(), (CharSequence) ZeusTransformUtils.preCheckCast("accepted_unverified:", CharSequence.class, "com.obric.aiagent.plugin"));
        goto L14
    }

    public static final String a(String r2) {
        d.h.b.o.e(r2, "rawManifestJson");
        return "verified:" + b(r2);
    }

    public static final String a(String r3, ah r4) {
        d.h.b.o.e(r3, "rawManifestJson");
        d.h.b.o.e(r4, "reason");
        StringBuilder r0 = new StringBuilder().append("invalid:");
        String r5 = r4.name();
        Locale r1 = Locale.ROOT;
        d.h.b.o.c(r1, "ROOT");
        String r6 = r5.toLowerCase(r1);
        d.h.b.o.c(r6, "toLowerCase(...)");
        return r0.append(r6).append(':').append(b(r3)).toString();
    }

    public static final boolean a(com.obric.aiagent.skill.manager.api.aj r2) {
        com.obric.aiagent.skill.manager.api.aj r3 = (com.obric.aiagent.skill.manager.api.aj) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.aiagent.skill.manager.api.aj.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        return ZeusTransformUtils.instanceOf(r3, com.obric.aiagent.skill.manager.api.aj.a.class);
    }

    public static final boolean b(com.obric.aiagent.skill.manager.api.aj r2) {
        com.obric.aiagent.skill.manager.api.aj r3 = (com.obric.aiagent.skill.manager.api.aj) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.aiagent.skill.manager.api.aj.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        if (ZeusTransformUtils.instanceOf(r3, com.obric.aiagent.skill.manager.api.aj.a.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((com.obric.aiagent.skill.manager.api.aj.a) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.aj.a.class, "com.obric.aiagent.plugin")).b().a().getAllowsSkillUse() == false) goto L7;
        return true;
    }

    public static final boolean c(com.obric.aiagent.skill.manager.api.aj r2) {
        com.obric.aiagent.skill.manager.api.aj r3 = (com.obric.aiagent.skill.manager.api.aj) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.aiagent.skill.manager.api.aj.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        if (r3 != com.obric.aiagent.skill.manager.api.aj.d.f19189a) goto L5;
    L10:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.aiagent.skill.manager.api.aj.e.class) == true) goto L10;
        if (ZeusTransformUtils.instanceOf(r3, com.obric.aiagent.skill.manager.api.aj.b.class) == true) goto L10;
        return false;
    }

    public static final boolean d(com.obric.aiagent.skill.manager.api.aj r2) {
        com.obric.aiagent.skill.manager.api.aj r3 = (com.obric.aiagent.skill.manager.api.aj) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.aiagent.skill.manager.api.aj.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        if (ZeusTransformUtils.instanceOf(r3, com.obric.aiagent.skill.manager.api.aj.a.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(((com.obric.aiagent.skill.manager.api.aj.a) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.aj.a.class, "com.obric.aiagent.plugin")).b().a(), SkillSecurityDecisionAction.Block.class) == false) goto L7;
        return true;
    }

    private static final String b(String r11) {
        MessageDigest r0 = MessageDigest.getInstance("SHA-256");
        Charset r1 = StandardCharsets.UTF_8;
        d.h.b.o.c(r1, "UTF_8");
        byte[] r12 = r11.getBytes(r1);
        d.h.b.o.c(r12, "getBytes(...)");
        byte[] r2 = r0.digest(r12);
        d.h.b.o.a(r2);
        return d.a.i.a(r2, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$en$ReL_HFUuq8rsx_5_8261X2g9IE.INSTANCE, 30, null);
    }

    private static final CharSequence a(byte r3) {
        String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(r3 & 255)}, 1));
        d.h.b.o.c(r4, "format(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
    }
}
