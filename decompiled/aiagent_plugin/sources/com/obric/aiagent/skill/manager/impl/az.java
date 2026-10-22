package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: SkillDerivedProperties.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class az {

    /* JADX INFO: compiled from: SkillDerivedProperties.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19537a = null;

        static {
            int[] r0 = new int[com.obric.aiagent.skill.manager.api.r.values().length];
            r0[com.obric.aiagent.skill.manager.api.r.k.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[com.obric.aiagent.skill.manager.api.r.j.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f19537a = r0;
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            Long r3 = ((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).n();
            if (r3 == null) goto L5;
            Object r6 = ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.aiagent.plugin");
        L6:
            Comparable r7 = (Comparable) r6;
            Long r8 = ((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r4, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).n();
            if (r8 == null) goto L9;
            Object r9 = ZeusTransformUtils.preCheckCast(r8, Comparable.class, "com.obric.aiagent.plugin");
        L11:
            return d.b.a.a(r7, (Comparable) r9);
        L9:
            r9 = ZeusTransformUtils.preCheckCast(Long.MIN_VALUE, Comparable.class, "com.obric.aiagent.plugin");
            goto L11
        L5:
            r6 = ZeusTransformUtils.preCheckCast(Long.MIN_VALUE, Comparable.class, "com.obric.aiagent.plugin");
            goto L6
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class c<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f19538a;

        public c(Comparator r3) {
            this.f19538a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.aiagent.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r1 = this.f19538a.compare(r2, r3);
            if (r1 == 0) goto L6;
            return r1;
        L6:
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).a(), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).a(), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final boolean a(com.obric.aiagent.skill.manager.api.e r1) {
        d.h.b.o.e(r1, "<this>");
        return en.d(r1.i());
    }

    public static final boolean b(com.obric.aiagent.skill.manager.api.e r3) {
        d.h.b.o.e(r3, "<this>");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3.a(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L6;
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r3.g(), com.obric.aiagent.skill.manager.api.aq.d.class) == false) goto L8;
    L9:
        return true;
    L8:
        if (d.h.b.o.a(r3.g(), com.obric.aiagent.skill.manager.api.aq.a.f19212a) == true) goto L9;
        return false;
    }

    public static final boolean c(com.obric.aiagent.skill.manager.api.e r1) {
        d.h.b.o.e(r1, "<this>");
        return ZeusTransformUtils.instanceOf(r1.g(), com.obric.aiagent.skill.manager.api.aq.b.class);
    }

    public static final boolean a(com.obric.aiagent.skill.manager.api.e r1, boolean r2) {
        d.h.b.o.e(r1, "<this>");
        if (r2 == true) goto L5;
    L7:
        return false;
    L5:
        if (c(r1) == false) goto L7;
        return true;
    }

    public static final boolean b(com.obric.aiagent.skill.manager.api.e r1, boolean r2) {
        d.h.b.o.e(r1, "<this>");
        if (r2 == true) goto L5;
    L7:
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(r1.g(), com.obric.aiagent.skill.manager.api.aq.d.class) == false) goto L7;
        return true;
    }

    public static final bc c(com.obric.aiagent.skill.manager.api.e r5, boolean r6) {
        d.h.b.o.e(r5, "<this>");
        boolean r0 = b(r5, r6);
        boolean r2 = true;
        if (r0 == true) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r6 == true) goto L10;
    L14:
        r2 = false;
    L16:
        return new bc(r0, r4, r2);
    L10:
        if (r5.m() == false) goto L14;
        if (d.h.b.o.a(r5.g(), com.obric.aiagent.skill.manager.api.aq.a.f19212a) == true) goto L14;
    L5:
        if (bg.a(r5.i()) != null) goto L7;
        r4 = true;
        goto L8
    }

    public static final ba d(com.obric.aiagent.skill.manager.api.e r1, boolean r2) {
        d.h.b.o.e(r1, "<this>");
        if (r2 == true) goto L6;
        return ba.f19541a;
    L6:
        if (a(r1) == false) goto L9;
        return ba.f19544d;
    L9:
        if (r1.l() == false) goto L12;
        return ba.f19543c;
    L12:
        return ba.f19542b;
    }

    public static final bh a(Throwable r2) {
        d.h.b.o.e(r2, "throwable");
    L4:
        if (r2 == null) goto L20;
        if (ZeusTransformUtils.instanceOf(r2, bi.class) == true) goto L8;
        if (ZeusTransformUtils.instanceOf(r2, em.class) == true) goto L12;
        Throwable r1 = r2.getCause();
        if (r1 != r2) goto L16;
        boolean r3 = true;
    L17:
        if (r3 == false) goto L18;
        r2 = null;
        goto L4
    L18:
        r2 = r1;
        goto L4
    L16:
        r3 = false;
        goto L17
    L12:
        return bh.f19562b;
    L8:
        return bh.f19561a;
    L20:
        return null;
    }

    public static final bh a(com.obric.aiagent.skill.manager.api.u.a r1) {
        d.h.b.o.e(r1, "failure");
        com.obric.aiagent.skill.manager.api.r r2 = r1.a();
        int r3 = a.f19537a[r2.ordinal()];
        if (r3 == 1) goto L9;
        if (r3 == 2) goto L11;
        return null;
    L11:
        return bh.f19562b;
    L9:
        return bh.f19561a;
    }

    public static final String d(com.obric.aiagent.skill.manager.api.e r3) {
        d.h.b.o.e(r3, "skill");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r3.b(), CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r0) == false) goto L6;
        r0 = r3.a();
    L6:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
    }

    public static final String e(com.obric.aiagent.skill.manager.api.e r2) {
        d.h.b.o.e(r2, "<this>");
        if (ZeusTransformUtils.instanceOf(r2.g(), com.obric.aiagent.skill.manager.api.aq.e.class) == false) goto L5;
        String r3 = r2.d();
    L6:
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r4) == false) goto L10;
        r4 = "-";
    L10:
        return (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin");
    L5:
        r3 = r2.c();
        goto L6
    }

    public static final List<com.obric.aiagent.skill.manager.api.e> a(Iterable<com.obric.aiagent.skill.manager.api.e> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        return d.a.p.a(r4, (Comparator) ZeusTransformUtils.preCheckCast(new c((Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.aiagent.plugin")), Comparator.class, "com.obric.aiagent.plugin"));
    }

    public static final boolean a(com.obric.aiagent.skill.manager.api.e r9, String r10) {
        d.h.b.o.e(r9, "<this>");
        d.h.b.o.e(r10, "keyword");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
        return true;
    L5:
        Locale r0 = Locale.ROOT;
        d.h.b.o.c(r0, "ROOT");
        String r11 = r10.toLowerCase(r0);
        d.h.b.o.c(r11, "toLowerCase(...)");
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.b(new String[]{r9.b(), r9.d(), r9.e()}), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, Collection.class) == true) goto L8;
    L10:
        Iterator r13 = r12.iterator();
    L12:
        if (r13.hasNext() == false) goto L20;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.aiagent.plugin");
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L18;
        Locale r7 = Locale.ROOT;
        d.h.b.o.c(r7, "ROOT");
        String r5 = r4.toLowerCase(r7);
        d.h.b.o.c(r5, "toLowerCase(...)");
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L18;
        boolean r6 = true;
    L19:
        if (r6 == false) goto L12;
        return true;
    L18:
        r6 = false;
    L20:
        return false;
    L8:
        if (((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L10;
        goto L10
    }

    public static final String b(com.obric.aiagent.skill.manager.api.e r3, String r4) {
        d.h.b.o.e(r3, "<this>");
        com.obric.aiagent.skill.manager.api.aq r5 = r3.g();
        CharSequence r1 = null;
        if (ZeusTransformUtils.instanceOf(r5, com.obric.aiagent.skill.manager.api.aq.e.class) == false) goto L10;
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.aq.e) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.skill.manager.api.aq.e.class, "com.obric.aiagent.plugin")).d(), CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r6) == true) goto L21;
        r1 = r6;
    L21:
        return (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin");
    L10:
        if (d.h.b.o.a(r5, com.obric.aiagent.skill.manager.api.aq.a.f19212a) == false) goto L13;
        return null;
    L13:
        if (ZeusTransformUtils.instanceOf(r5, com.obric.aiagent.skill.manager.api.aq.d.class) == false) goto L20;
        if (r4 == null) goto L24;
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r7) == true) goto L25;
        r1 = r7;
    L25:
        return (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin");
    L24:
        return null;
    L20:
        if (r5 != null) goto L23;
        return null;
    L23:
        throw new d.k();
    }

    public static final String f(com.obric.aiagent.skill.manager.api.e r3) {
        d.h.b.o.e(r3, "<this>");
        com.obric.aiagent.skill.manager.api.aq r4 = r3.g();
        CharSequence r2 = null;
        if (ZeusTransformUtils.instanceOf(r4, com.obric.aiagent.skill.manager.api.aq.e.class) == false) goto L5;
        com.obric.aiagent.skill.manager.api.aq.e r5 = (com.obric.aiagent.skill.manager.api.aq.e) ZeusTransformUtils.preCheckCast(r4, com.obric.aiagent.skill.manager.api.aq.e.class, "com.obric.aiagent.plugin");
    L6:
        if (r5 == null) goto L15;
        String r6 = r5.d();
        if (r6 == null) goto L16;
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r7) == true) goto L14;
        r2 = r7;
    L14:
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
    L16:
        return null;
    L15:
        return null;
    L5:
        r5 = null;
        goto L6
    }

    public static final String g(com.obric.aiagent.skill.manager.api.e r4) {
        d.h.b.o.e(r4, "skill");
        com.obric.aiagent.skill.manager.api.aq r0 = r4.g();
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiagent.skill.manager.api.aq.e.class) == false) goto L6;
        return ((com.obric.aiagent.skill.manager.api.aq.e) ZeusTransformUtils.preCheckCast(r0, com.obric.aiagent.skill.manager.api.aq.e.class, "com.obric.aiagent.plugin")).c();
    L6:
        if (d.h.b.o.a(r0, com.obric.aiagent.skill.manager.api.aq.a.f19212a) == false) goto L15;
        com.obric.aiagent.skill.manager.api.a r5 = r4.h();
        if (r5 == null) goto L10;
        String r6 = r5.a();
    L11:
        if (r6 != null) goto L21;
        return "";
    L21:
        return r6;
    L10:
        r6 = null;
        goto L11
    L15:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiagent.skill.manager.api.aq.d.class) == true) goto L22;
        if (r0 != null) goto L20;
        return "";
    L20:
        throw new d.k();
    L22:
        return ((com.obric.aiagent.skill.manager.api.aq.d) ZeusTransformUtils.preCheckCast(r0, com.obric.aiagent.skill.manager.api.aq.d.class, "com.obric.aiagent.plugin")).c();
    }

    public static /* synthetic */ bd a(com.obric.aiagent.skill.manager.api.e r0, long r1, TimeZone r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = System.currentTimeMillis();
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = TimeZone.getDefault();
    L9:
        return a(r0, r1, r3);
    }

    public static final bd a(com.obric.aiagent.skill.manager.api.e r11, long r12, TimeZone r14) {
        d.h.b.o.e(r11, "<this>");
        d.h.b.o.e(r14, "timeZone");
        com.obric.aiagent.skill.manager.api.aq r0 = r11.g();
        String r2 = "";
        String r3 = null;
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiagent.skill.manager.api.aq.b.class) == false) goto L12;
        String r1 = ((com.obric.aiagent.skill.manager.api.aq.b) ZeusTransformUtils.preCheckCast(r0, com.obric.aiagent.skill.manager.api.aq.b.class, "com.obric.aiagent.plugin")).c();
        Long r13 = r11.n();
        if (r13 == null) goto L7;
        r3 = a(((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.aiagent.plugin")).longValue(), r12, r14);
    L7:
        if (r3 == null) goto L43;
        r2 = r3;
    L43:
        return new bd(r1, r2, bb.f19546a);
    L12:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiagent.skill.manager.api.aq.c.class) == false) goto L21;
        String r4 = ((com.obric.aiagent.skill.manager.api.aq.c) ZeusTransformUtils.preCheckCast(r0, com.obric.aiagent.skill.manager.api.aq.c.class, "com.obric.aiagent.plugin")).c();
        Long r15 = r11.n();
        if (r15 == null) goto L16;
        r3 = a(((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.aiagent.plugin")).longValue(), r12, r14);
    L16:
        if (r3 == null) goto L44;
        r2 = r3;
    L44:
        return new bd(r4, r2, bb.f19547b);
    L21:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiagent.skill.manager.api.aq.e.class) == false) goto L24;
        return new bd(((com.obric.aiagent.skill.manager.api.aq.e) ZeusTransformUtils.preCheckCast(r0, com.obric.aiagent.skill.manager.api.aq.e.class, "com.obric.aiagent.plugin")).c(), null, null, 6, null);
    L24:
        if (d.h.b.o.a(r0, com.obric.aiagent.skill.manager.api.aq.a.f19212a) == false) goto L38;
        com.obric.aiagent.skill.manager.api.a r5 = r11.h();
        if (r5 == null) goto L28;
        String r6 = r5.a();
    L29:
        if (r6 != null) goto L31;
        r6 = "";
    L31:
        Long r16 = r11.n();
        if (r16 == null) goto L34;
        r3 = a(((Number) ZeusTransformUtils.preCheckCast(r16, Number.class, "com.obric.aiagent.plugin")).longValue(), r12, r14);
    L34:
        if (r3 == null) goto L46;
        r2 = r3;
    L46:
        return new bd(r6, r2, bb.f19547b);
    L28:
        r6 = null;
        goto L29
    L38:
        if (r0 != null) goto L42;
        return new bd(null, null, null, 7, null);
    L42:
        throw new d.k();
    }

    private static final String a(long r3, long r5, TimeZone r7) {
        Calendar r0 = Calendar.getInstance(r7);
        r0.setTimeInMillis(r3);
        int r1 = r0.get(1);
        Calendar r2 = Calendar.getInstance(r7);
        r2.setTimeInMillis(r5);
        if (r1 != r2.get(1)) goto L5;
        String r6 = "MM/dd";
    L6:
        SimpleDateFormat r8 = new SimpleDateFormat(r6, Locale.getDefault());
        r8.setTimeZone(r7);
        String r4 = r8.format(new Date(r3));
        d.h.b.o.c(r4, "format(...)");
        return r4;
    L5:
        r6 = "yyyy/MM/dd";
        goto L6
    }
}
