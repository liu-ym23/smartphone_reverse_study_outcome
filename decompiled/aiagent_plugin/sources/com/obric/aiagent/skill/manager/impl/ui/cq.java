package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: SkillUsageExampleAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class cq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final cq f20769a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d.o.k f20770b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Set<Character> f20771c = null;

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((d.l.j) ZeusTransformUtils.preCheckCast(r2, d.l.j.class, "com.obric.aiagent.plugin")).a()), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((d.l.j) ZeusTransformUtils.preCheckCast(r3, d.l.j.class, "com.obric.aiagent.plugin")).a()), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    private cq() {
    }

    static {
        f20769a = new cq();
        f20770b = new d.o.k("@[A-Za-z0-9_-]+");
        f20771c = d.a.ax.a(new Character[]{'@', '_', '+', '-', '.', ',', (char) 65292, (char) 12290, (char) 12289, ':', (char) 65306, ';', (char) 65307, '!', '?', (char) 65281, (char) 65311, '(', ')', (char) 65288, (char) 65289, '[', ']', (char) 12304, (char) 12305});
    }

    public final e a(String r25) {
        d.h.b.o.e(r25, "example");
        StringBuilder r7 = new StringBuilder(r25.length());
        List<d.l.j> r9 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        List<d.l.j> r10 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        List r11 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        int r13 = 0;
        boolean r14 = false;
    L4:
        if (r13 >= r25.length()) goto L22;
        int r12 = 2;
        int r4 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r25, CharSequence.class, "com.obric.aiagent.plugin"), "{{", r13, false, 4, null);
        if (r4 < 0) goto L8;
        String r0 = r25.substring(r13, r4);
        d.h.b.o.c(r0, "substring(...)");
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("}}", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L14;
        r14 = true;
    L14:
        r7.append((CharSequence) ZeusTransformUtils.preCheckCast(r25, CharSequence.class, "com.obric.aiagent.plugin"), r13, r4);
        int r1 = r4 + 2;
        int r15 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r25, CharSequence.class, "com.obric.aiagent.plugin"), "}}", r1, false, 4, null);
        if (r15 < 0) goto L16;
        String r2 = r25.substring(r1, r15);
        d.h.b.o.c(r2, "substring(...)");
        String r3 = b(r2);
        if (r3 == null) goto L20;
        int r5 = r7.length();
        r7.append('@' + r3);
        ((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin")).add(d.l.n.b(r5, r7.length()));
        ((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.aiagent.plugin")).add(r3);
    L21:
        r13 = r15 + 2;
        goto L4
    L20:
        a(r7, r10, r25, r4, r15 + 2);
        r14 = true;
        goto L21
    L16:
        a(r7, r10, r25, r4, r25.length());
        r14 = true;
    L23:
        String r6 = r7.toString();
        d.h.b.o.c(r6, "toString(...)");
        Iterator r8 = d.o.k.b(f20770b, (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), 0, r12, null).a();
    L25:
        if (r8.hasNext() == false) goto L32;
        d.l.j r16 = ((d.o.i) ZeusTransformUtils.preCheckCast(r8.next(), d.o.i.class, "com.obric.aiagent.plugin")).a();
        cq r17 = f20769a;
        if (r17.a(r16, r9) == true) goto L25;
        if (r17.a(r16, r10) == true) goto L25;
        ((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin")).add(r16);
        goto L25
    L32:
        return new e(r6, d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new a(), Comparator.class, "com.obric.aiagent.plugin")), r11, r14);
    L8:
        if (d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r25, CharSequence.class, "com.obric.aiagent.plugin"), "}}", r13, false, 4, null) < 0) goto L10;
        r14 = true;
    L10:
        r7.append((CharSequence) ZeusTransformUtils.preCheckCast(r25, CharSequence.class, "com.obric.aiagent.plugin"), r13, r25.length());
        goto L23
    L22:
        r12 = 2;
        goto L23
    }

    private final void a(StringBuilder r3, List<d.l.j> r4, String r5, int r6, int r7) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        int r8 = r3.length();
        r3.append((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"), r6, r7);
        if (r8 >= r3.length()) goto L6;
        ((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin")).add(d.l.n.b(r8, r3.length()));
        return;
    }

    private final String b(String r10) {
        String r11 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        boolean r3 = false;
        if (d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"), '@', false, 2, null) == false) goto L24;
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin");
        int r6 = 0;
    L6:
        if (r6 >= r0.length()) goto L11;
        if (a(r0.charAt(r6)) == false) goto L9;
        r6 = r6 + 1;
        goto L6
    L9:
        boolean r9 = false;
    L12:
        if (r9 == false) goto L26;
        String r12 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a(r11, (CharSequence) ZeusTransformUtils.preCheckCast("@", CharSequence.class, "com.obric.aiagent.plugin")), CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L17;
    L19:
        if (r3 == true) goto L21;
        return null;
    L21:
        return r12;
    L17:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"), '@', false, 2, null) == true) goto L19;
        r3 = true;
        goto L19
    L26:
        return null;
    L11:
        r9 = true;
        goto L12
    L24:
        return null;
    }

    private final boolean a(char r3) {
        if (19968 <= r3) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        return true;
    L10:
        if ('a' <= r3) goto L12;
    L14:
        boolean r2 = false;
    L15:
        if (r2 == false) goto L17;
        return true;
    L17:
        if ('A' <= r3) goto L19;
    L21:
        boolean r4 = false;
    L22:
        if (r4 == false) goto L24;
        return true;
    L24:
        if ('0' <= r3) goto L26;
    L28:
        boolean r5 = false;
    L29:
        if (r5 == false) goto L31;
        return true;
    L31:
        if (d.o.a.a(r3) == false) goto L33;
        return true;
    L33:
        if (f20771c.contains(Character.valueOf(r3)) == false) goto L36;
        return true;
    L36:
        return false;
    L26:
        if (r3 >= ':') goto L28;
        r5 = true;
        goto L29
    L19:
        if (r3 >= '[') goto L21;
        r4 = true;
        goto L22
    L12:
        if (r3 >= '{') goto L14;
        r2 = true;
        goto L15
    L5:
        if (r3 >= 40960) goto L7;
        r1 = true;
        goto L8
    }

    private final boolean a(d.l.j r6, List<d.l.j> r7) {
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L5;
    L7:
        Iterator r8 = r5.iterator();
    L9:
        if (r8.hasNext() == false) goto L17;
        d.l.j r9 = (d.l.j) ZeusTransformUtils.preCheckCast(r8.next(), d.l.j.class, "com.obric.aiagent.plugin");
        if (r6.a() <= r9.b()) goto L13;
    L15:
        boolean r10 = false;
    L16:
        if (r10 == false) goto L9;
        return true;
    L13:
        if (r9.a() > r6.b()) goto L15;
        r10 = true;
    L17:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        goto L7
    }
}
