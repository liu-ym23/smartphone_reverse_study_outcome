package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SkillServerTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ez {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f19855a = null;

    public static final /* synthetic */ String a(String r0) {
        return c(r0);
    }

    public static final /* synthetic */ String a(boolean r0) {
        return b(r0);
    }

    public static final /* synthetic */ Map a(Map r2) {
        return c((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ String b(String r0) {
        return d(r0);
    }

    private static final String b(boolean r0) {
        if (r0 == false) goto L4;
        return "1";
    L4:
        return "0";
    }

    public static final /* synthetic */ boolean b(Map r2) {
        return d((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin"));
    }

    private static final String c(String r12) {
        if (r12 == null) goto L26;
        String r13 = d.o.o.e(r12, 64);
        if (r13 == null) goto L27;
        CharSequence r14 = (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r14.length()), Collection.class, "com.obric.aiagent.plugin");
        int r3 = 0;
    L8:
        if (r3 >= r14.length()) goto L16;
        char r4 = r14.charAt(r3);
        if (Character.isLetterOrDigit(r4) == true) goto L15;
        if (d.a.i.a(f19855a, r4) == true) goto L15;
        r4 = '_';
    L15:
        r1.add(Character.valueOf(r4));
        r3 = r3 + 1;
        goto L8
    L16:
        String r15 = d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
        if (r15 != null) goto L19;
        return null;
    L19:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L21;
        return null;
    L21:
        return r15;
    L27:
        return null;
    L26:
        return null;
    }

    private static final String d(String r4) {
        if (r4 == null) goto L18;
        String r5 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r5 == null) goto L19;
        boolean r2 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L12;
    L14:
        r2 = false;
    L15:
        if (r2 == true) goto L17;
        return null;
    L17:
        return r5;
    L12:
        if (d.h.b.o.a(r5, "0") == true) goto L14;
    L9:
        r1 = false;
        goto L10
    L19:
        return null;
    L18:
        return null;
    }

    private static final boolean d(Map<String, String> r6) {
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin")).entrySet(), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L5;
    L7:
        Iterator r8 = r7.iterator();
    L9:
        if (r8.hasNext() == false) goto L25;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.getValue(), String.class, "com.obric.aiagent.plugin");
        if (d.o.o.a(r4, "X-Tt-Token", true) == true) goto L13;
    L15:
        boolean r2 = false;
    L16:
        if (r2 == false) goto L9;
        return true;
    L13:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L15;
        r2 = true;
        goto L16
    L25:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        return false;
    }

    static {
        f19855a = new char[]{'_', '-', '.', ':'};
    }

    private static final Map<String, String> c(Map<String, String> r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        Map<String, String> r0 = null;
        if (r9 == null) goto L23;
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r10 = r9.entrySet().iterator();
    L6:
        if (r10.hasNext() == false) goto L22;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.aiagent.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r3.getValue(), String.class, "com.obric.aiagent.plugin");
        String r6 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        String r7 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        boolean r11 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L10;
        boolean r12 = true;
    L11:
        if (r12 == false) goto L13;
    L19:
        d.m r13 = null;
    L20:
        if (r13 == null) goto L6;
        r2.add(r13);
        goto L6
    L13:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).length() == 0) goto L16;
        r11 = false;
    L16:
        if (r11 == true) goto L19;
        r13 = d.s.a(r6, r7);
        goto L20
    L10:
        r12 = false;
        goto L11
    L22:
        r0 = d.a.ao.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
    L23:
        if (r0 == null) goto L25;
        return r0;
    L25:
        return d.a.ao.b();
    }
}
