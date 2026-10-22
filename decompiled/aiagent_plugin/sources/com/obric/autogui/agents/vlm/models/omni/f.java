package com.obric.autogui.agents.vlm.models.omni;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.ax;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: ActionEffectEvaluationBatch.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f28340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<e> f28341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Integer, Integer> f28342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<Integer, String> f28343d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Integer f28344e;
    private final h f;

    /* JADX INFO: renamed from: lambda$5s6rP3-hLb0UDQ67MIxlACmDp7o, reason: not valid java name */
    public static /* synthetic */ boolean m773lambda$5s6rP3hLb0UDQ67MIxlACmDp7o(f r0, int r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$7s-gieIcwsIJPxOeGNPf7BWQ3IQ, reason: not valid java name */
    public static /* synthetic */ CharSequence m774lambda$7sgieIcwsIJPxOeGNPf7BWQ3IQ(f r0, int r1) {
        return c(r0, r1);
    }

    public static /* synthetic */ boolean lambda$BzPnGrYWWRIt3_As0hbcwYjoFX4(f r0, int r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ com.obric.autogui.agents.a.f.k lambda$ZPOKMgDMexuoCqC5_5J2RWQXYU4(e r0) {
        return a(r0);
    }

    public static /* synthetic */ CharSequence lambda$cBdxU4KLbPpqA3W7N7kkqMCZ4UU(Map r0, f r1, d.h.a.b r2, int r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ CharSequence lambda$myUmUwF2cmL7pKWEClW60pAORI4(String r0, int r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$qrj0RUWOQMR0Ptkr-4OsrQe8xbM, reason: not valid java name */
    public static /* synthetic */ CharSequence m775lambda$qrj0RUWOQMR0Ptkr4OsrQe8xbM(f r0, int r1) {
        return d(r0, r1);
    }

    public static /* synthetic */ com.obric.autogui.agents.a.f.k lambda$v2Y_8jkFIaMxTbUv118w7SjXjSo(e r0) {
        return b(r0);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
        if (this.f28340a == r6.f28340a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f28341b, r6.f28341b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f28342c, r6.f28342c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f28343d, r6.f28343d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f28344e, r6.f28344e) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((Integer.hashCode(this.f28340a) * 31) + this.f28341b.hashCode()) * 31) + this.f28342c.hashCode()) * 31) + this.f28343d.hashCode()) * 31;
        Integer r1 = this.f28344e;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        h r5 = this.f;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "ActionEffectEvaluationSnapshot(expectedActionCount=" + this.f28340a + ", entries=" + this.f28341b + ", actionResultCodes=" + this.f28342c + ", actionResultReasons=" + this.f28343d + ", lastStartedActionIndex=" + this.f28344e + ", requestError=" + this.f + ')';
    }

    public f(int r3, List<e> r4, Map<Integer, Integer> r5, Map<Integer, String> r6, Integer r7, h r8) {
        List<e> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        Map<Integer, Integer> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        Map<Integer, String> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "entries");
        d.h.b.o.e(r10, "actionResultCodes");
        d.h.b.o.e(r11, "actionResultReasons");
        this.f28340a = r3;
        this.f28341b = r9;
        this.f28342c = r10;
        this.f28343d = r11;
        this.f28344e = r7;
        this.f = r8;
    }

    public final int a() {
        return this.f28340a;
    }

    public final List<e> b() {
        return this.f28341b;
    }

    public final Integer c() {
        return this.f28344e;
    }

    public final h d() {
        return this.f;
    }

    public final boolean e() {
        if (this.f28340a > 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean f() {
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.f28341b, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L5;
        return true;
    L5:
        if (this.f != null) goto L10;
        return false;
    L10:
        return true;
    }

    public final int g() {
        return this.f28341b.size();
    }

    public final int h() {
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(this.f28341b, Iterable.class, "com.obric.aiagent.plugin");
        int r2 = 0;
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L5;
    L7:
        Iterator r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L15;
        if (((e) ZeusTransformUtils.preCheckCast(r5.next(), e.class, "com.obric.aiagent.plugin")).d() == false) goto L9;
        r2 = r2 + 1;
        if (r2 >= 0) goto L9;
        d.a.p.d();
    L15:
        return r2;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    public final int i() {
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(this.f28341b, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L5;
    L7:
        Iterator r6 = r5.iterator();
        int r0 = 0;
    L9:
        if (r6.hasNext() == false) goto L21;
        e r3 = (e) ZeusTransformUtils.preCheckCast(r6.next(), e.class, "com.obric.aiagent.plugin");
        if (r3.d() == true) goto L13;
    L15:
        boolean r4 = false;
    L16:
        if (r4 == false) goto L9;
        r0 = r0 + 1;
        if (r0 >= 0) goto L9;
        d.a.p.d();
        goto L9
    L13:
        if (r3.e().d() != com.obric.autogui.agents.a.f.k.f26445d) goto L15;
        r4 = true;
        goto L16
    L21:
        return r0;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        return 0;
    }

    public final Boolean j() {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.f28341b, Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (((e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin")).d() == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        List r4 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");
        boolean r6 = true;
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L11;
    L13:
        Iterator r7 = r5.iterator();
    L15:
        if (r7.hasNext() == false) goto L12;
        if (d.h.b.o.a(((e) ZeusTransformUtils.preCheckCast(r7.next(), e.class, "com.obric.aiagent.plugin")).e().k(), true) == false) goto L15;
        boolean r8 = true;
    L19:
        if (r8 == true) goto L21;
        int r9 = d.n.m.k(d.n.m.j(d.n.m.a(d.n.m.d(d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(a.f28345a, d.h.a.b.class, "com.obric.aiagent.plugin")), new $$Lambda$f$BzPnGrYWWRIt3_As0hbcwYjoFX4(this))));
        int r10 = this.f28340a;
        if (r10 <= 0) goto L41;
        if (r9 != r10) goto L41;
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, Collection.class) == true) goto L28;
    L30:
        Iterator r12 = r11.iterator();
    L32:
        if (r12.hasNext() == false) goto L29;
        if (((e) ZeusTransformUtils.preCheckCast(r12.next(), e.class, "com.obric.aiagent.plugin")).e().k() == null) goto L36;
        boolean r13 = true;
    L37:
        if (r13 == true) goto L32;
        boolean r14 = false;
    L39:
        if (r14 == false) goto L41;
    L42:
        Boolean r15 = false;
        r15.booleanValue();
        if (r6 == true) goto L60;
        return null;
    L60:
        return r15;
    L36:
        r13 = false;
    L29:
        r14 = true;
        goto L39
    L28:
        if (((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L30;
    L41:
        r6 = false;
        goto L42
    L21:
        return true;
    L12:
        r8 = false;
        goto L19
    L11:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L13;
        goto L12
    }

    private static final boolean a(f r1, int r2) {
        if (r2 >= 0) goto L5;
        return false;
    L5:
        if (r2 >= r1.f28340a) goto L9;
        return true;
    L9:
        return false;
    }

    public final int k() {
        return d.l.n.c(this.f28340a - d.n.m.k(d.n.m.j(d.n.m.a(d.n.m.d(d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(this.f28341b, Iterable.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(b.f28346a, d.h.a.b.class, "com.obric.aiagent.plugin")), new $$Lambda$f$5s6rP3hLb0UDQ67MIxlACmDp7o(this)))), 0);
    }

    private static final boolean b(f r1, int r2) {
        if (r2 >= 0) goto L5;
        return false;
    L5:
        if (r2 >= r1.f28340a) goto L9;
        return true;
    L9:
        return false;
    }

    public final g l() {
        h r0 = this.f;
        if (r0 == null) goto L10;
        final String r1 = "ERROR_" + r0.a();
        if (e() == false) goto L8;
        r1 = d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(d.l.n.b(0, this.f28340a), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, new $$Lambda$f$myUmUwF2cmL7pKWEClW60pAORI4(r1), 30, null);
    L8:
        return new g(r1, r1);
    L10:
        if (e() == true) goto L36;
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f28341b, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L13:
        if (r2.hasNext() == false) goto L22;
        Object r3 = r2.next();
        e r4 = (e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin");
        if (r4.a() == 0) goto L17;
    L19:
        boolean r5 = false;
    L20:
        if (r5 == false) goto L13;
    L23:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin");
        String r7 = "UNKNOWN";
        if (r6 == null) goto L28;
        String r8 = a(r6, r6.e().c());
        if (r8 == null) goto L28;
    L29:
        if (r6 == null) goto L34;
        String r12 = a(r6, r6.e().d());
        if (r12 == null) goto L34;
        r7 = r12;
    L34:
        return new g(r8, r7);
    L28:
        r8 = "UNKNOWN";
        goto L29
    L17:
        if (r4.d() == false) goto L19;
        r5 = true;
        goto L20
    L22:
        r3 = null;
        goto L23
    L36:
        return new g(a($$Lambda$f$ZPOKMgDMexuoCqC5_5J2RWQXYU4.INSTANCE), a($$Lambda$f$v2Y_8jkFIaMxTbUv118w7SjXjSo.INSTANCE));
    }

    private static final CharSequence a(String r1, int r2) {
        return (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.autogui.agents.a.f.k a(e r1) {
        d.h.b.o.e(r1, "it");
        return r1.e().c();
    }

    private static final com.obric.autogui.agents.a.f.k b(e r1) {
        d.h.b.o.e(r1, "it");
        return r1.e().d();
    }

    public final String m() {
        if (e() == true) goto L11;
        Integer r12 = (Integer) ZeusTransformUtils.preCheckCast(this.f28342c.get(0), Integer.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L8;
        String r13 = r12.toString();
        if (r13 == null) goto L8;
        return r13;
    L8:
        return "UNKNOWN";
    L11:
        return d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(d.l.n.b(0, this.f28340a), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, new $$Lambda$f$7sgieIcwsIJPxOeGNPf7BWQ3IQ(this), 30, null);
    }

    private static final CharSequence c(f r1, int r2) {
        Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(r1.f28342c.get(Integer.valueOf(r2)), Integer.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L7;
        String r4 = r3.toString();
        if (r4 == null) goto L7;
        Object r5 = ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
    L9:
        return (CharSequence) r5;
    L7:
        r5 = ZeusTransformUtils.preCheckCast("UNKNOWN", CharSequence.class, "com.obric.aiagent.plugin");
        goto L9
    }

    public final String n() {
        if (this.f28343d.isEmpty() == false) goto L7;
        return null;
    L7:
        if (e() == true) goto L11;
        return (String) ZeusTransformUtils.preCheckCast(this.f28343d.get(0), String.class, "com.obric.aiagent.plugin");
    L11:
        return d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(d.l.n.b(0, this.f28340a), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, new $$Lambda$f$qrj0RUWOQMR0Ptkr4OsrQe8xbM(this), 30, null);
    }

    private static final CharSequence d(f r1, int r2) {
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.f28343d.get(Integer.valueOf(r2)), String.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L5;
        Object r4 = ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
    L7:
        return (CharSequence) r4;
    L5:
        r4 = ZeusTransformUtils.preCheckCast("UNKNOWN", CharSequence.class, "com.obric.aiagent.plugin");
        goto L7
    }

    public final com.obric.autogui.agents.vlm.models.omni.b o() {
        Integer r2 = null;
        if (this.f != null) goto L5;
        Integer r0 = this.f28344e;
        if (r0 == null) goto L12;
        ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (e() == false) goto L12;
        r2 = r0;
    L12:
        if (r2 == null) goto L14;
        Set r4 = ax.a(r2);
    L15:
        if (r2 == null) goto L29;
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(this.f28341b, Iterable.class, "com.obric.aiagent.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r10 = r9.iterator();
    L18:
        if (r10.hasNext() == false) goto L28;
        Object r6 = r10.next();
        int r7 = ((e) ZeusTransformUtils.preCheckCast(r6, e.class, "com.obric.aiagent.plugin")).a();
        if (r2 != null) goto L23;
    L25:
        boolean r8 = false;
    L26:
        if (r8 == false) goto L18;
        r5.add(r6);
        goto L18
    L23:
        if (r7 != r2.intValue()) goto L25;
        r8 = true;
        goto L26
    L28:
        List<e> r11 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin");
    L31:
        return d.a(r4, r11);
    L29:
        r11 = this.f28341b;
        goto L31
    L14:
        r4 = d.a.p.q((Iterable) ZeusTransformUtils.preCheckCast(d.l.n.b(0, this.f28340a), Iterable.class, "com.obric.aiagent.plugin"));
        goto L15
    L5:
        return new com.obric.autogui.agents.vlm.models.omni.b(com.obric.autogui.agents.a.f.k.f26446e, com.obric.autogui.agents.a.f.k.f26446e, true, null);
    }

    private final String a(d.h.a.b<? super e, ? extends com.obric.autogui.agents.a.f.k> r13) {
        final d.h.a.b r14 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.b.class, "com.obric.aiagent.plugin");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.f28341b, Iterable.class, "com.obric.aiagent.plugin");
        final Map r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(d.l.n.c(ao.a(d.a.p.a(r0, 10)), 16)), Map.class, "com.obric.aiagent.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        Object r3 = r1.next();
        r2.put(Integer.valueOf(((e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin")).a()), r3);
        goto L4
    L7:
        return d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(d.l.n.b(0, this.f28340a), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, new $$Lambda$f$cBdxU4KLbPpqA3W7N7kkqMCZ4UU(r2, this, r14), 30, null);
    }

    private static final CharSequence a(Map r2, f r3, d.h.a.b r4, int r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        e r8 = (e) ZeusTransformUtils.preCheckCast(r6.get(Integer.valueOf(r5)), e.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L13;
        if (r8.d() == true) goto L8;
        r8 = null;
    L8:
        if (r8 == null) goto L13;
        String r9 = r3.a(r8, (com.obric.autogui.agents.a.f.k) ZeusTransformUtils.preCheckCast(r7.invoke(r8), com.obric.autogui.agents.a.f.k.class, "com.obric.aiagent.plugin"));
        if (r9 == null) goto L13;
        return (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin");
    L13:
        return (CharSequence) ZeusTransformUtils.preCheckCast("UNKNOWN", CharSequence.class, "com.obric.aiagent.plugin");
    }

    private final String a(e r2, com.obric.autogui.agents.a.f.k r3) {
        if (r3 != com.obric.autogui.agents.a.f.k.f26446e) goto L14;
        if (r2.e().e() != com.obric.autogui.agents.a.f.f.f26420d) goto L14;
        Integer r1 = r2.e().f();
        if (r1 == null) goto L12;
        return "ERROR_" + r1.intValue();
    L12:
        return r3.name();
    L14:
        return r3.name();
    }
}
