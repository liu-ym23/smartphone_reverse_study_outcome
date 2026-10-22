package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SkillShopRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ft {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f19922a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final fe f19923b;

    /* JADX INFO: compiled from: SkillShopRepository.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: SkillShopRepository.kt */
    /* synthetic */ class b extends d.h.b.l implements d.h.a.b<String, Boolean> {
        b(Object r8) {
            super(1, r8, bl.class, "isAllowed", "isAllowed(Ljava/lang/String;)Z", 0);
        }

        public final Boolean a(String r3) {
            d.h.b.o.e(r3, "p0");
            return Boolean.valueOf(((bl) ZeusTransformUtils.preCheckCast(this.receiver, bl.class, "com.obric.aiagent.plugin")).a(r3));
        }

        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(String r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class c<T> implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((ak) ZeusTransformUtils.preCheckCast(r2, ak.class, "com.obric.aiagent.plugin")).d()), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((ak) ZeusTransformUtils.preCheckCast(r3, ak.class, "com.obric.aiagent.plugin")).d()), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class d<T> implements Comparator {
        public d() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((ak) ZeusTransformUtils.preCheckCast(r2, ak.class, "com.obric.aiagent.plugin")).d()), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((ak) ZeusTransformUtils.preCheckCast(r3, ak.class, "com.obric.aiagent.plugin")).d()), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f19922a = new a(null);
    }

    public static /* synthetic */ boolean lambda$GtF8LbgV9QbaDk27wwDAqVsyB4w(fs r0) {
        return b(r0);
    }

    public static /* synthetic */ String lambda$IcafhtAfU1FOHFWI1UkGRCk4yYg(ft r0, fs r1) {
        return c(r0, r1);
    }

    public static /* synthetic */ fr lambda$Y_yUGa17jHu8QBZZ_R61XMVAsjE(ft r0, String r1, String r2, int r3, int r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ com.obric.aiagent.skill.manager.api.e lambda$ZmtlQydf2J9WXJVssKZQY_Ahh4U(ft r0, fs r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ am lambda$g1aEdD0duLqbF8rtEoMJn72MQZ4(ft r0, fs r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ fr lambda$lCmShiSuUMgTIibNco0K5M4qHh8(ft r0, String r1, int r2, boolean r3, int r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ com.obric.aiagent.skill.manager.api.e lambda$qxQqPA1gVawPeSAxgqSYfdwiaqY(ft r0, fs r1) {
        return d(r0, r1);
    }

    private ft(fe r1) {
        this.f19923b = r1;
    }

    public ft() {
        this(new fe());
    }

    public final List<ak> a() {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.f19923b.b(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r0, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        r1.add(a((fi) ZeusTransformUtils.preCheckCast(r2.next(), fi.class, "com.obric.aiagent.plugin")));
        goto L4
    L7:
        return d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new c(), Comparator.class, "com.obric.aiagent.plugin"));
    }

    public final aj b() {
        fh r0 = (fh) ZeusTransformUtils.preCheckCast(d.a.p.l(this.f19923b.c()), fh.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L7;
        return null;
    L7:
        return a(r0);
    }

    public final an<com.obric.aiagent.skill.manager.api.e> a(final String r2, final String r3, int r4, final int r5) {
        return a(r4, r5, new $$Lambda$ft$Y_yUGa17jHu8QBZZ_R61XMVAsjE(this, r2, r3, r5), new $$Lambda$ft$ZmtlQydf2J9WXJVssKZQY_Ahh4U(this));
    }

    private static final fr a(ft r9, String r10, String r11, int r12, int r13) {
        return fe.a(r9.f19923b, r10, r11, null, false, r13, r12, 4, null);
    }

    private static final com.obric.aiagent.skill.manager.api.e a(ft r1, fs r2) {
        d.h.b.o.e(r2, "item");
        return r1.a(r2);
    }

    public final an<am> a(final String r2, final boolean r3, int r4, final int r5) {
        return a(r4, r5, new $$Lambda$ft$lCmShiSuUMgTIibNco0K5M4qHh8(this, r2, r5, r3), new $$Lambda$ft$g1aEdD0duLqbF8rtEoMJn72MQZ4(this));
    }

    private static final fr a(ft r9, String r10, int r11, boolean r12, int r13) {
        fe r0 = r9.f19923b;
        if (r12 == true) goto L5;
        String r1 = r10;
    L6:
        Boolean r14 = true;
        r14.booleanValue();
        if (r12 == false) goto L9;
        Boolean r3 = r14;
    L11:
        return fe.a(r0, r1, null, r3, false, r13, r11, 2, null);
    L9:
        r3 = null;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    private static final am b(ft r1, fs r2) {
        d.h.b.o.e(r2, "item");
        com.obric.aiagent.skill.manager.api.e r3 = r1.a(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return fu.a(r3);
    }

    public final List<com.obric.aiagent.skill.manager.api.e> c() {
        LinkedHashMap r0 = new LinkedHashMap();
        int r2 = 0;
        int r12 = 1;
    L3:
        fr r3 = fe.a(this.f19923b, null, null, null, true, r12, 100, 6, null);
        List<fs> r4 = r3.a();
        if (r4 != null) goto L6;
        r4 = d.a.p.b();
    L6:
        r2 = r2 + r4.size();
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L12;
        com.obric.aiagent.skill.manager.api.e r8 = a((fs) ZeusTransformUtils.preCheckCast(r6.next(), fs.class, "com.obric.aiagent.plugin"));
        if (r8 == null) goto L8;
        r7.add(r8);
        goto L8
    L12:
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L14:
        if (r9.hasNext() == false) goto L17;
        com.obric.aiagent.skill.manager.api.e r10 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
        r0.putIfAbsent(r10.a(), r10);
        goto L14
    L17:
        if (r4.isEmpty() == true) goto L22;
        if (r2 >= r3.b()) goto L22;
        r12 = r12 + 1;
    L22:
        Collection r13 = r0.values();
        d.h.b.o.c(r13, "<get-values>(...)");
        return d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin"));
    }

    public final ao a(String r3) {
        d.h.b.o.e(r3, "slug");
        if (bl.f19568a.a(r3) == true) goto L5;
        return null;
    L5:
        fm r4 = this.f19923b.a(r3);
        if (r4 != null) goto L8;
        return null;
    L8:
        ao r2 = a(r4);
        if (r2 == null) goto L12;
        return r2;
    L12:
        throw new fp(fq.f19910c, null, 2, null);
    }

    public final al b(String r14) {
        d.h.b.o.e(r14, "slug");
        fk r0 = this.f19923b.b(r14);
        if (r0 != null) goto L6;
        return null;
    L6:
        al r1 = a(r0);
        List<fs> r2 = r0.f();
        if (r2 != null) goto L9;
        r2 = d.a.p.b();
    L9:
        Set<String> r3 = d.n.m.i(d.n.m.a(d.n.m.e(d.n.m.a(d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")), $$Lambda$ft$GtF8LbgV9QbaDk27wwDAqVsyB4w.INSTANCE), new $$Lambda$ft$IcafhtAfU1FOHFWI1UkGRCk4yYg(this)), (d.h.a.b) ZeusTransformUtils.preCheckCast(new b(bl.f19568a), d.h.a.b.class, "com.obric.aiagent.plugin")));
        if (r3.isEmpty() == false) goto L30;
        return r1;
    L30:
        Map<String, com.obric.aiagent.skill.manager.api.e> r13 = a(r3);     // Catch: Exception -> L14
    L17:
        if (r13.isEmpty() == false) goto L19;
        return r1;
    L19:
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r1.c(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r4, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r5 = r4.iterator();
    L21:
        if (r5.hasNext() == false) goto L29;
        com.obric.aiagent.skill.manager.api.e r10 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r5.next(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.manager.api.e r11 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r13.get(r10.a()), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L27;
        com.obric.aiagent.skill.manager.api.e r12 = gu.a(r10, r11);
        if (r12 == null) goto L27;
        r10 = r12;
    L27:
        r9.add(r10);
        goto L21
    L29:
        return al.a(r1, null, null, null, null, 0, 0, (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin"), null, false, 447, null);
    L14:
        e = move-exception;
        ee.f19808a.a("SkillManager", "Store collection presentation fallback request failed", "Store collection presentation fallback request failed: slug=" + r14, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        r13 = d.a.ao.b();
        goto L17
    }

    private static final boolean b(fs r1) {
        d.h.b.o.e(r1, "item");
        if (r1.c() != null) goto L5;
        return true;
    L5:
        return false;
    }

    private static final String c(ft r1, fs r2) {
        d.h.b.o.e(r2, "item");
        return r1.d(r2.b());
    }

    public final com.obric.aiagent.skill.manager.api.e c(String r12) {
        d.h.b.o.e(r12, "slug");
        Object r1 = null;
        if (bl.f19568a.a(r12) == true) goto L5;
        return null;
    L5:
        List<fs> r0 = fe.a(this.f19923b, null, r12, null, null, 1, 20, 12, null).a();
        if (r0 != null) goto L8;
        r0 = d.a.p.b();
    L8:
        Iterator r11 = d.n.m.e(d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")), new $$Lambda$ft$qxQqPA1gVawPeSAxgqSYfdwiaqY(this)).a();
    L10:
        if (r11.hasNext() == false) goto L15;
        Object r2 = r11.next();
        if (d.h.b.o.a(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).a(), r12) == false) goto L10;
        r1 = r2;
    L15:
        return (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r1, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.aiagent.skill.manager.api.e d(ft r1, fs r2) {
        d.h.b.o.e(r2, "item");
        return r1.a(r2);
    }

    private final Map<String, com.obric.aiagent.skill.manager.api.e> a(Set<String> r14) {
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.wrapperContextForParams(r14, Set.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin");
        bl r2 = bl.f19568a;
        Iterator r16 = r15.iterator();
    L4:
        if (r16.hasNext() == false) goto L8;
        Object r3 = r16.next();
        if (r2.a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin")) == false) goto L4;
        r0.add(r3);
        goto L4
    L8:
        Set r17 = (Set) ZeusTransformUtils.preCheckCast(r0, Set.class, "com.obric.aiagent.plugin");
        LinkedHashMap r1 = new LinkedHashMap();
        int r12 = 1;
    L10:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L36;
        fr r4 = fe.a(this.f19923b, null, null, null, null, r12, 100, 14, null);
        List<fs> r5 = r4.a();
        if (r5 != null) goto L14;
        r5 = d.a.p.b();
    L14:
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r8 = r6.iterator();
    L16:
        if (r8.hasNext() == false) goto L20;
        com.obric.aiagent.skill.manager.api.e r9 = a((fs) ZeusTransformUtils.preCheckCast(r8.next(), fs.class, "com.obric.aiagent.plugin"));
        if (r9 == null) goto L16;
        r7.add(r9);
        goto L16
    L20:
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L22:
        if (r10.hasNext() == false) goto L27;
        com.obric.aiagent.skill.manager.api.e r11 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r10.next(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
        if (r17.remove(r11.a()) == false) goto L22;
        ((Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.aiagent.plugin")).put(r11.a(), r11);
        goto L22
    L27:
        if (r5.size() >= 100) goto L29;
    L31:
        boolean r13 = false;
    L32:
        if (r13 == false) goto L36;
        r12 = r12 + 1;
        goto L10
    L29:
        if ((r12 * 100) >= r4.b()) goto L31;
        r13 = true;
    L36:
        return (Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.aiagent.plugin");
    }

    public final ap a(String r2, int r3, File r4) {
        d.h.b.o.e(r2, "slug");
        d.h.b.o.e(r4, "destination");
        bl.f19568a.b(r2);
        return this.f19923b.a(r2, r3, r4);
    }

    private final com.obric.aiagent.skill.manager.api.e a(fs r23) {
        String r3 = d(r23.b());
        String r1 = null;
        if (r3 != null) goto L6;
        return null;
    L6:
        if (bl.f19568a.a(r3) == true) goto L8;
        return null;
    L8:
        fl r2 = r23.g();
        if (r2 == null) goto L11;
        Integer r4 = r2.a();
    L12:
        int r12 = a(r4);
        String r5 = e(r23.a());
        if (r5 != null) goto L15;
        r5 = r3;
    L15:
        if (r2 == null) goto L18;
        r1 = r2.b();
    L18:
        if (r1 != null) goto L20;
        String r13 = "";
    L21:
        String r6 = g(r13);
        String r7 = d(r23.c());
        if (r7 != null) goto L24;
        r7 = "";
    L24:
        String r8 = d(r23.d());
        if (r8 != null) goto L27;
        r8 = "";
    L27:
        String r0 = f(r23.e());
        if (r0 != null) goto L30;
        String r9 = "";
    L32:
        return new com.obric.aiagent.skill.manager.api.e(r3, r5, r6, r7, r8, r9, (com.obric.aiagent.skill.manager.api.aq) ZeusTransformUtils.preCheckCast(fu.a(r23.f()), com.obric.aiagent.skill.manager.api.aq.class, "com.obric.aiagent.plugin"), null, null, r12, r13, false, false, null, null, null, null, 123264, null);
    L30:
        r9 = r0;
        goto L32
    L20:
        r13 = r1;
        goto L21
    L11:
        r4 = null;
        goto L12
    }

    private final ao a(fm r28) {
        String r3 = d(r28.b());
        if (r3 != null) goto L6;
        return null;
    L6:
        if (bl.f19568a.a(r3) == true) goto L8;
        return null;
    L8:
        fl r22 = r28.f();
        if (r22 == null) goto L11;
        Integer r2 = r22.a();
    L12:
        int r12 = a(r2);
        String r4 = e(r28.a());
        if (r4 != null) goto L15;
        String r5 = r3;
    L16:
        if (r22 == null) goto L18;
        String r6 = r22.b();
    L20:
        if (r6 != null) goto L22;
        String r13 = "";
    L23:
        String r7 = d(r28.c());
        if (r7 != null) goto L26;
        String r8 = "";
    L27:
        String r9 = g(r13);
        String r10 = f(r28.d());
        if (r10 != null) goto L30;
        String r24 = "";
    L31:
        String r26 = r8;
        com.obric.aiagent.skill.manager.api.e r11 = new com.obric.aiagent.skill.manager.api.e(r3, r5, r9, null, r8, r24, (com.obric.aiagent.skill.manager.api.aq) ZeusTransformUtils.preCheckCast(fu.a(r28.e()), com.obric.aiagent.skill.manager.api.aq.class, "com.obric.aiagent.plugin"), null, null, r12, r13, false, false, null, null, null, null, 123272, null);
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(a(r28.g()), Collection.class, "com.obric.aiagent.plugin");
        if (r14.isEmpty() == false) goto L38;
        if (r22 == null) goto L35;
        List<String> r15 = r22.c();
    L36:
        r14 = a(r15);
        goto L38
    L35:
        r15 = null;
    L38:
        return new ao(r11, r26, (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin"));
    L30:
        r24 = r10;
        goto L31
    L26:
        r8 = r7;
        goto L27
    L22:
        r13 = r6;
        goto L23
    L18:
        r6 = null;
        goto L20
    L15:
        r5 = r4;
        goto L16
    L11:
        r2 = null;
        goto L12
    }

    private final ak a(fi r9) {
        String r0 = d(r9.a());
        if (r0 != null) goto L5;
        String r3 = "";
    L6:
        String r1 = d(r9.b());
        if (r1 != null) goto L9;
        String r4 = "";
    L10:
        String r2 = d(r9.c());
        if (r2 != null) goto L13;
        String r5 = "";
    L14:
        int r6 = r9.d();
        List<fi> r10 = r9.e();
        if (r10 != null) goto L17;
        r10 = d.a.p.b();
    L17:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r11, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r12 = r11.iterator();
    L19:
        if (r12.hasNext() == false) goto L22;
        r7.add(a((fi) ZeusTransformUtils.preCheckCast(r12.next(), fi.class, "com.obric.aiagent.plugin")));
        goto L19
    L22:
        return new ak(r3, r4, r5, r6, d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new d(), Comparator.class, "com.obric.aiagent.plugin")));
    L13:
        r5 = r2;
        goto L14
    L9:
        r4 = r1;
        goto L10
    L5:
        r3 = r0;
        goto L6
    }

    private final int a(Integer r4) {
        return hj.f20114a.a(r4);
    L4:
        e = move-exception;
        throw new fp(fq.f19910c, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    private final aj a(fh r11) {
        String r0 = d(r11.a());
        if (r0 != null) goto L5;
        String r2 = "";
    L6:
        String r1 = d(r11.b());
        if (r1 != null) goto L9;
        String r3 = "";
    L10:
        String r4 = d(r11.c());
        if (r4 != null) goto L13;
        String r5 = "";
    L14:
        String r6 = d(r11.d());
        String r7 = null;
        if (r6 != null) goto L23;
        ff r8 = r11.f();
        if (r8 == null) goto L19;
        String r9 = r8.a();
    L20:
        r6 = d(r9);
        if (r6 != null) goto L23;
        String r10 = "";
    L24:
        String r12 = f(r11.e());
        if (r12 != null) goto L27;
        String r13 = "";
    L28:
        ff r14 = r11.f();
        if (r14 == null) goto L31;
        String r15 = r14.b();
    L32:
        String r16 = d(r15);
        if (r16 != null) goto L35;
        String r17 = "";
    L36:
        ff r18 = r11.f();
        if (r18 == null) goto L39;
        r7 = r18.c();
    L39:
        String r19 = d(r7);
        if (r19 != null) goto L43;
        r19 = "";
    L43:
        return new aj(r2, r3, r5, r10, r13, r17, r19);
    L35:
        r17 = r16;
        goto L36
    L31:
        r15 = null;
        goto L32
    L27:
        r13 = r12;
        goto L28
    L19:
        r9 = null;
    L23:
        r10 = r6;
        goto L24
    L13:
        r5 = r4;
        goto L14
    L9:
        r3 = r1;
        goto L10
    L5:
        r2 = r0;
        goto L6
    }

    private final al a(fk r13) {
        List<fs> r0 = r13.f();
        if (r0 != null) goto L5;
        r0 = d.a.p.b();
    L5:
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        com.obric.aiagent.skill.manager.api.e r4 = a((fs) ZeusTransformUtils.preCheckCast(r3.next(), fs.class, "com.obric.aiagent.plugin"));
        if (r4 == null) goto L7;
        r2.add(r4);
        goto L7
    L11:
        List r9 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        String r5 = d(r13.a());
        if (r5 != null) goto L14;
        String r6 = "";
    L15:
        String r7 = d(r13.b());
        if (r7 != null) goto L18;
        String r8 = "";
    L19:
        String r10 = d(r13.c());
        if (r10 != null) goto L22;
        String r11 = "";
    L23:
        String r12 = d(r13.d());
        if (r12 != null) goto L26;
        String r14 = "";
    L27:
        String r15 = r6;
        String r16 = r8;
        String r17 = r11;
        String r18 = r14;
        return new al(r15, r16, r17, r18, r9.size(), r13.e(), r9, a(r13.g()), r13.h());
    L26:
        r14 = r12;
        goto L27
    L22:
        r11 = r10;
        goto L23
    L18:
        r8 = r7;
        goto L19
    L14:
        r6 = r5;
        goto L15
    }

    private final String d(String r3) {
        if (r3 == null) goto L8;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L8;
        return r3;
    L8:
        return null;
    }

    private final String e(String r3) {
        if (r3 == null) goto L13;
        String r4 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r4 != null) goto L7;
        return null;
    L7:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L12;
        return null;
    L12:
        return r4;
    L9:
        r0 = false;
        goto L10
    L13:
        return null;
    }

    private final String f(String r3) {
        if (r3 == null) goto L13;
        String r4 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r4 != null) goto L7;
        return null;
    L7:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L12;
        return null;
    L12:
        return r4;
    L9:
        r0 = false;
        goto L10
    L13:
        return null;
    }

    private final String g(String r6) {
        Object r1 = "";
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L15;
        return "";
    L15:
        d.n.a r5 = d.n.f38560a;     // Catch: Throwable -> L7
        Object r7 = d.n.f(db.a(db.f19721a, r6, 0, 2, null).b());     // Catch: Throwable -> L7
    L10:
        if (d.n.b(r7) == true) goto L14;
        r1 = r7;
    L14:
        return (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin");
    L7:
        th = move-exception;
        d.n.a r8 = d.n.f38560a;
        r7 = d.n.f(d.o.a(th));
        goto L10
    }

    private final List<String> a(List<String> r4) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        r3 = d.a.p.b();
    L5:
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r7 = r5.iterator();
    L7:
        if (r7.hasNext() == false) goto L18;
        String r1 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == true) goto L15;
        r1 = null;
    L15:
        if (r1 == null) goto L7;
        r6.add(r1);
        goto L7
    L11:
        r2 = false;
        goto L12
    L18:
        return (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin");
    }

    private final <T> an<T> a(fr r6, int r7, int r8, d.h.a.b<? super fs, ? extends T> r9) {
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.b.class, "com.obric.aiagent.plugin");
        Integer r10 = Integer.valueOf(r6.c());
        boolean r2 = false;
        if (((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L5;
        boolean r1 = true;
    L6:
        Integer r4 = null;
        if (r1 == true) goto L10;
        r10 = null;
    L10:
        if (r10 == null) goto L12;
        int r11 = r10.intValue();
    L13:
        int r12 = d.l.n.c(r11, r7);
        Integer r13 = Integer.valueOf(r6.d());
        if (((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L16;
        r2 = true;
    L16:
        if (r2 == false) goto L18;
        r4 = r13;
    L18:
        if (r4 == null) goto L20;
        r8 = r4.intValue();
    L20:
        List<fs> r14 = r6.a();
        if (r14 != null) goto L23;
        r14 = d.a.p.b();
    L23:
        int r3 = ((r12 - 1) * r8) + r14.size();
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator<T> r17 = r15.iterator();
    L25:
        if (r17.hasNext() == false) goto L30;
        Object r18 = r5.invoke(r17.next());
        if (r18 == null) goto L25;
        r16.add(r18);
        goto L25
    L30:
        return new an((List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.aiagent.plugin"), r12, r8, Math.max(r6.b(), r3));
    L12:
        r11 = r7;
        goto L13
    L5:
        r1 = false;
        goto L6
    }

    private final <T> an<T> a(int r5, int r6, d.h.a.b<? super Integer, fr> r7, d.h.a.b<? super fs, ? extends T> r8) {
        d.h.a.b r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super fs, ? extends T> r10 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.b.class, "com.obric.aiagent.plugin");
    L3:
        an<T> r0 = a((fr) ZeusTransformUtils.preCheckCast(r9.invoke(Integer.valueOf(r5)), fr.class, "com.obric.aiagent.plugin"), r5, r6, r10);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r0.a(), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L9;
        if (r0.c() == false) goto L9;
        r5 = Math.max(r5 + 1, r0.b() + 1);
    L9:
        return r0;
    }
}
