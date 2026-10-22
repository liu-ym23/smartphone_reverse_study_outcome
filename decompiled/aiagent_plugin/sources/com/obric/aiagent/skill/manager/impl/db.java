package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SkillMarkdownParser.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class db {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final db f19721a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f19722b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Set<String> f19723c = null;

    private db() {
    }

    public static /* synthetic */ da a(db r0, String r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = com.obric.aiagent.skill.manager.api.al.f19195a.a().i();
    L6:
        return r0.a(r1, r2);
    }

    public final da a(String r28, int r29) {
        d.h.b.o.e(r28, "raw");
        if (r28.length() > r29) goto L63;
        List<String> r1 = d.o.o.g((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.b(d.o.o.a(d.o.o.a(r28, "\r\n", "\n", false, 4, null), '\r', '\n', false, 4, null), new char[]{65279, '\n'}), CharSequence.class, "com.obric.aiagent.plugin"));
        String r2 = (String) ZeusTransformUtils.preCheckCast(d.a.p.l(r1), String.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L7;
        String r3 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L9:
        if (d.h.b.o.a(r3, "---") == false) goto L61;
        Iterator r4 = d.a.p.b((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin"), 1).iterator();
        boolean r5 = false;
        int r6 = 0;
    L11:
        int r8 = -1;
        if (r4.hasNext() == false) goto L27;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.aiagent.plugin");
        Character r12 = d.o.o.i((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"));
        if (r12 != null) goto L16;
    L18:
        boolean r13 = false;
    L19:
        if (r13 == false) goto L21;
    L23:
        boolean r9 = false;
    L24:
        if (r9 == true) goto L28;
        r6 = r6 + 1;
    L28:
        if (r6 < 0) goto L31;
        r8 = r6 + 1;
    L31:
        if (r8 < 0) goto L59;
        List<String> r10 = r1.subList(1, r8);
        Map<String, String> r11 = b(r10);
        List r14 = d.a.p.b((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin"), r8 + 1);
        String r15 = (String) ZeusTransformUtils.preCheckCast(d.a.p.l(r14), String.class, "com.obric.aiagent.plugin");
        if (r15 != null) goto L35;
    L37:
        if (r5 == false) goto L39;
        r14 = d.a.p.b((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin"), 1);
    L39:
        String r16 = d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
        String r17 = (String) ZeusTransformUtils.preCheckCast(r11.get("name"), String.class, "com.obric.aiagent.plugin");
        if (r17 != null) goto L42;
        r17 = "";
    L42:
        String r25 = (String) ZeusTransformUtils.preCheckCast(r11.get("display_name"), String.class, "com.obric.aiagent.plugin");
        String r18 = (String) ZeusTransformUtils.preCheckCast(r11.get("description"), String.class, "com.obric.aiagent.plugin");
        if (r18 != null) goto L46;
        r18 = "";
    L46:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L48;
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.q.f19609a, bt.class, "com.obric.aiagent.plugin"), null, 2, null);
        throw new d.d();
    L48:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L50;
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.c.f19595a, bt.class, "com.obric.aiagent.plugin"), null, 2, null);
        throw new d.d();
    L50:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L52;
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.b.f19594a, bt.class, "com.obric.aiagent.plugin"), null, 2, null);
        throw new d.d();
    L52:
        return new da(r17, r18, r16, r25, a(r10));
    L35:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin")) != true) goto L37;
        r5 = true;
        goto L37
    L59:
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.i.f19601a, bt.class, "com.obric.aiagent.plugin"), null, 2, null);
        throw new d.d();
    L21:
        if (d.h.b.o.a(d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).toString(), "---") == false) goto L23;
        r9 = true;
        goto L24
    L16:
        if (d.o.a.a(r12.charValue()) != true) goto L18;
        r13 = true;
        goto L19
    L27:
        r6 = -1;
        goto L28
    L61:
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.h.f19600a, bt.class, "com.obric.aiagent.plugin"), null, 2, null);
        throw new d.d();
    L7:
        r3 = null;
        goto L9
    L63:
        bv.a((bt) ZeusTransformUtils.preCheckCast(new bt.u(r29), bt.class, "com.obric.aiagent.plugin"), null, 2, null);
        throw new d.d();
    }

    private final List<String> a(List<String> r14) {
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        String r2 = null;
    L4:
        if (r15.hasNext() == false) goto L18;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.aiagent.plugin");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L4;
        if (d.o.a.a(d.o.o.h((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L4;
        int r5 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"), ':', 0, false, 6, null);
        if (r5 <= 0) goto L4;
        String r4 = r3.substring(0, r5);
        d.h.b.o.c(r4, "substring(...)");
        String r6 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).toString().toLowerCase(Locale.ROOT);
        d.h.b.o.c(r6, "toLowerCase(...)");
        if (d.h.b.o.a(r6, "trigger_examples") == false) goto L4;
        if (r2 != null) goto L16;
        String r7 = r3.substring(r5 + 1);
        d.h.b.o.c(r7, "substring(...)");
        r2 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        goto L4
    L16:
        return d.a.p.b();
    L18:
        if (r2 == null) goto L62;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L22;
        boolean r16 = true;
    L23:
        if (r16 == true) goto L26;
        r2 = null;
    L26:
        if (r2 == null) goto L62;
        if (f19723c.contains(r2) == true) goto L60;
        if (d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"), '[', false, 2, null) == true) goto L60;
        if (d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"), '{', false, 2, null) == true) goto L60;
        if (d.o.o.h((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")) != '\'') goto L40;
        if (d.o.o.j((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")) == '\'') goto L40;
    L44:
        return d.a.p.b();
    L40:
        if (d.o.o.h((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")) == '\"') goto L42;
    L45:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(a(r2), CharSequence.class, "com.obric.aiagent.plugin"), new char[]{';', 65307}, false, 0, 6, null), Iterable.class, "com.obric.aiagent.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r18 = r13.iterator();
    L47:
        if (r18.hasNext() == false) goto L58;
        String r8 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r18.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L51;
        boolean r9 = true;
    L52:
        if (r9 == true) goto L55;
        r8 = null;
    L55:
        if (r8 == null) goto L47;
        r17.add(r8);
        goto L47
    L51:
        r9 = false;
        goto L52
    L58:
        return (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.aiagent.plugin");
    L42:
        if (d.o.o.j((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")) == '\"') goto L45;
    L60:
        return d.a.p.b();
    L22:
        r16 = false;
    L62:
        return d.a.p.b();
    }

    private final Map<String, String> b(List<String> r18) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
        LinkedHashMap r3 = new LinkedHashMap();
        int r5 = 0;
    L4:
        if (r5 >= r1.size()) goto L50;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r1.get(r5), String.class, "com.obric.aiagent.plugin");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L48;
        if (d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).toString(), CharSequence.class, "com.obric.aiagent.plugin"), '#', false, 2, null) == true) goto L48;
        if (d.o.a.a(d.o.o.h((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L48;
        int r7 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), ':', 0, false, 6, null);
        if (r7 <= 0) goto L48;
        String r8 = r6.substring(0, r7);
        d.h.b.o.c(r8, "substring(...)");
        String r9 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).toString().toLowerCase(Locale.ROOT);
        d.h.b.o.c(r9, "toLowerCase(...)");
        if (f19722b.contains(r9) == false) goto L17;
        if (r3.containsKey(r9) == true) goto L21;
        String r10 = r6.substring(r7 + 1);
        d.h.b.o.c(r10, "substring(...)");
        String r11 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (f19723c.contains(r11) == true) goto L31;
        ((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.aiagent.plugin")).put(r9, a(r11));
    L41:
        r5 = r5 + 1;
        if (r5 >= r1.size()) goto L4;
        String r12 = (String) ZeusTransformUtils.preCheckCast(r1.get(r5), String.class, "com.obric.aiagent.plugin");
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L41;
        if (d.o.a.a(d.o.o.h((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L4;
    L31:
        List<String> r13 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    L32:
        r5 = r5 + 1;
        if (r5 >= r1.size()) goto L39;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r1.get(r5), String.class, "com.obric.aiagent.plugin");
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L38;
        if (d.o.a.a(d.o.o.h((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L39;
    L38:
        ((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.aiagent.plugin")).add(r14);
    L39:
        ((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.aiagent.plugin")).put(r9, a(r11, r13));
        goto L4
    L21:
        if (d.h.b.o.a(r9, "name") == false) goto L23;
        cc r2 = cc.f19640a;
    L27:
        bv.a((bt) ZeusTransformUtils.preCheckCast(new bt.e(r2), bt.class, "com.obric.aiagent.plugin"), null, 2, null);
        throw new d.d();
    L23:
        if (d.h.b.o.a(r9, "display_name") == false) goto L25;
        r2 = cc.f19641b;
        goto L27
    L25:
        r2 = cc.f19642c;
        goto L27
    L17:
        String r15 = r6.substring(r7 + 1);
        d.h.b.o.c(r15, "substring(...)");
        r5 = a(r1, r5, d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin")).toString());
    L48:
        r5 = r5 + 1;
        goto L4
    L50:
        return (Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.aiagent.plugin");
    }

    private final int a(List<String> r2, int r3, String r4) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        int r5 = r3 + 1;
        if (f19723c.contains(r4) == false) goto L13;
    L5:
        if (r5 >= r1.size()) goto L11;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r1.get(r5), String.class, "com.obric.aiagent.plugin");
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L10;
        if (d.o.a.a(d.o.o.h((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L11;
    L10:
        r5 = r5 + 1;
    L11:
        return r5;
    L13:
        if (r5 >= r1.size()) goto L19;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r1.get(r5), String.class, "com.obric.aiagent.plugin");
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L18;
        if (d.o.a.a(d.o.o.h((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L19;
    L18:
        r5 = r5 + 1;
    L19:
        return r5;
    }

    private final String a(String r18, List<String> r19) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r5 = r4.next();
        if ((true ^ d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L4;
        r3.add(r5);
        goto L4
    L8:
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        if (r6.hasNext() == true) goto L11;
        Comparable r7 = null;
    L32:
        Integer r8 = (Integer) ZeusTransformUtils.preCheckCast(r7, Integer.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L35;
        int r9 = d.l.n.c(r8.intValue(), 0);
    L36:
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r1, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r11 = r1.iterator();
    L38:
        if (r11.hasNext() == false) goto L44;
        String r12 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.aiagent.plugin");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L42;
        String r13 = "";
    L43:
        r10.add(r13);
        goto L38
    L42:
        r13 = d.o.o.c(r12, r9);
        goto L43
    L44:
        List<String> r14 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin");
        if (d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin"), '|', false, 2, null) == false) goto L47;
        String r15 = d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
    L49:
        return d.o.o.c(r15, new char[]{'\n'});
    L47:
        r15 = c(r14);
        goto L49
    L35:
        r9 = 0;
        goto L36
    L11:
        CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin");
        int r17 = r16.length();
        int r20 = 0;
    L13:
        if (r20 >= r17) goto L18;
        if ((!d.o.a.a(r16.charAt(r20))) == true) goto L19;
        r20 = r20 + 1;
    L19:
        r7 = (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(r20), Comparable.class, "com.obric.aiagent.plugin");
    L21:
        if (r6.hasNext() == false) goto L32;
        CharSequence r21 = (CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin");
        int r22 = r21.length();
        int r110 = 0;
    L23:
        if (r110 >= r22) goto L28;
        if ((!d.o.a.a(r21.charAt(r110))) == true) goto L29;
        r110 = r110 + 1;
    L29:
        Comparable r23 = (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(r110), Comparable.class, "com.obric.aiagent.plugin");
        if (r7.compareTo(r23) <= 0) goto L21;
        r7 = r23;
        goto L21
    L28:
        r110 = -1;
        goto L29
    L18:
        r20 = -1;
        goto L19
    }

    private final String c(List<String> r8) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        StringBuilder r9 = new StringBuilder();
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L3:
        boolean r2 = false;
    L5:
        if (r10.hasNext() == false) goto L33;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.aiagent.plugin");
        boolean r6 = true;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L18;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L16;
        if (d.o.o.j((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")) == '\n') goto L16;
        r9.append('\n');
    L16:
        r2 = true;
        goto L5
    L11:
        r4 = false;
        goto L12
    L18:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L20;
        boolean r5 = true;
    L21:
        if (r5 == true) goto L23;
    L25:
        if (r2 == false) goto L32;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")).length() > 0) goto L30;
        r6 = false;
    L30:
        if (r6 == false) goto L32;
        d.o.o.j((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"));
    L32:
        r9.append(r3);
        goto L3
    L23:
        if (d.o.o.j((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")) == '\n') goto L25;
        r9.append(' ');
        goto L32
    L20:
        r5 = false;
        goto L21
    L33:
        String r11 = r9.toString();
        d.h.b.o.c(r11, "toString(...)");
        return r11;
    }

    private final String a(String r10) {
        if (r10.length() < 2) goto L11;
        if (d.o.o.h((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")) != '\'') goto L11;
        if (d.o.o.j((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")) != '\'') goto L11;
        String r3 = r10.substring(1, d.o.o.e((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")));
        d.h.b.o.c(r3, "substring(...)");
        return d.o.o.a(r3, "''", "'", false, 4, null);
    L11:
        if (r10.length() < 2) goto L19;
        if (d.o.o.h((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")) != '\"') goto L19;
        if (d.o.o.j((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")) != '\"') goto L19;
        String r11 = r10.substring(1, d.o.o.e((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")));
        d.h.b.o.c(r11, "substring(...)");
        return b(r11);
    L19:
        return d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a(r10, " #", null, 2, null), CharSequence.class, "com.obric.aiagent.plugin")).toString();
    }

    private final String b(String r6) {
        StringBuilder r5 = new StringBuilder();
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        int r1 = 0;
        boolean r2 = false;
    L4:
        if (r1 >= r7.length()) goto L22;
        char r3 = r7.charAt(r1);
        if (r2 == true) goto L8;
        if (r3 != '\\') goto L20;
        r2 = true;
    L21:
        r1 = r1 + 1;
        goto L4
    L20:
        r5.append(r3);
        goto L21
    L8:
        if (r3 != 'n') goto L10;
        r3 = '\n';
    L17:
        r5.append(r3);
        r2 = false;
        goto L21
    L10:
        if (r3 != 'r') goto L12;
        r3 = '\r';
        goto L17
    L12:
        if (r3 != 't') goto L17;
        r3 = '\t';
        goto L17
    L22:
        if (r2 == false) goto L24;
        r5.append('\\');
    L24:
        String r8 = r5.toString();
        d.h.b.o.c(r8, "toString(...)");
        return r8;
    }

    static {
        f19721a = new db();
        f19722b = d.a.ax.a(new String[]{"name", "display_name", "description"});
        f19723c = d.a.ax.a(new String[]{"|", ">", "|-", "|+", ">-", ">+"});
    }
}
