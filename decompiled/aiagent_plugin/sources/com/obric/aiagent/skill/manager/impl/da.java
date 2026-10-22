package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SkillMarkdownParser.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class da {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f19719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<String> f19720e;

    public static /* synthetic */ da a(da r6, String r7, String r8, String r9, String r10, List r11, int r12, Object r13) {
        List<String> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.f19716a;
    L5:
        String r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = r6.f19717b;
    L8:
        String r2 = r8;
        if ((r12 & 4) == 0) goto L11;
        r9 = r6.f19718c;
    L11:
        String r3 = r9;
        if ((r12 & 8) == 0) goto L14;
        r10 = r6.f19719d;
    L14:
        String r4 = r10;
        if ((r12 & 16) == 0) goto L18;
        r14 = r6.f19720e;
    L18:
        return r6.a(r1, r2, r3, r4, r14);
    }

    public final da a(String r7, String r8, String r9, String r10, List<String> r11) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "name");
        d.h.b.o.e(r8, "description");
        d.h.b.o.e(r9, "body");
        d.h.b.o.e(r5, "triggerExamples");
        return new da(r7, r8, r9, r10, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, da.class) == true) goto L8;
        return false;
    L8:
        da r6 = (da) ZeusTransformUtils.preCheckCast(r5, da.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19716a, r6.f19716a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19717b, r6.f19717b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19718c, r6.f19718c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f19719d, r6.f19719d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f19720e, r6.f19720e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.f19716a.hashCode() * 31) + this.f19717b.hashCode()) * 31) + this.f19718c.hashCode()) * 31;
        String r1 = this.f19719d;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.f19720e.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "SkillMarkdownDocument(name=" + this.f19716a + ", description=" + this.f19717b + ", body=" + this.f19718c + ", displayName=" + this.f19719d + ", triggerExamples=" + this.f19720e + ')';
    }

    public da(String r3, String r4, String r5, String r6, List<String> r7) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "name");
        d.h.b.o.e(r4, "description");
        d.h.b.o.e(r5, "body");
        d.h.b.o.e(r8, "triggerExamples");
        this.f19716a = r3;
        this.f19717b = r4;
        this.f19718c = r5;
        this.f19719d = r6;
        this.f19720e = r8;
    }

    public final String a() {
        return this.f19716a;
    }

    public final String b() {
        return this.f19717b;
    }

    public final String c() {
        return this.f19718c;
    }

    public /* synthetic */ da(String r7, String r8, String r9, String r10, List r11, int r12, d.h.b.h r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        if ((r12 & 8) == 0) goto L5;
        r10 = null;
    L5:
        String r4 = r10;
        if ((r12 & 16) == 0) goto L8;
        r14 = d.a.p.b();
    L8:
        this(r7, r8, r9, r4, r14);
    }

    public final List<String> d() {
        return this.f19720e;
    }

    public final String e() {
        String r0 = this.f19719d;
        if (r0 == null) goto L12;
        String r1 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r1 == null) goto L12;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L12;
        return r1;
    L12:
        return this.f19716a;
    }

    public final String f() {
        StringBuilder r1 = new StringBuilder();
        StringBuilder r3 = r1.append("---");
        d.h.b.o.c(r3, "append(...)");
        d.h.b.o.c(r3.append('\n'), "append(...)");
        a(r1, "name", this.f19716a);
        String r4 = this.f19719d;
        if (r4 == null) goto L5;
        a(r1, "display_name", r4);
    L5:
        a(r1, "description", this.f19717b);
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(this.f19720e, Iterable.class, "com.obric.aiagent.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r7 = r5.iterator();
    L6:
        boolean r9 = true;
        String r11 = null;
        if (r7.hasNext() == false) goto L16;
        String r8 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).length() > 0) goto L12;
        r9 = false;
    L12:
        if (r9 == false) goto L14;
        r11 = r8;
    L14:
        if (r11 == null) goto L6;
        r6.add(r11);
        goto L6
    L16:
        List r10 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L20;
        r10 = null;
    L20:
        if (r10 == null) goto L22;
        a(r1, "trigger_examples", d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(";", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null));
    L22:
        StringBuilder r2 = r1.append("---");
        d.h.b.o.c(r2, "append(...)");
        d.h.b.o.c(r2.append('\n'), "append(...)");
        d.h.b.o.c(r1.append('\n'), "append(...)");
        r1.append(this.f19718c);
        if (d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), '\n', false, 2, null) == true) goto L25;
        d.h.b.o.c(r1.append('\n'), "append(...)");
    L25:
        String r0 = r1.toString();
        d.h.b.o.c(r0, "toString(...)");
        return r0;
    }

    private final void a(StringBuilder r7, String r8, String r9) {
        r7.append(r8);
        r7.append(": '");
        r7.append(d.o.o.a(r9, "'", "''", false, 4, null));
        StringBuilder r6 = r7.append("'");
        d.h.b.o.c(r6, "append(...)");
        d.h.b.o.c(r6.append('\n'), "append(...)");
    }
}
