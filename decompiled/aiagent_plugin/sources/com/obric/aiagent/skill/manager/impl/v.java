package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: InstalledSkillRegistry.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final df f20924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final eh f20925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final bl f20926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.h.a.a<Integer> f20927d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f20928e;
    private final ConcurrentHashMap<String, com.obric.aiagent.skill.manager.api.e> f;
    private final kotlinx.coroutines.b.x<List<com.obric.aiagent.skill.manager.api.e>> g;
    private final kotlinx.coroutines.b.ak<List<com.obric.aiagent.skill.manager.api.e>> h;

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(az.d((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(az.d((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: lambda$bRdzZBhYCgKdEm2Kg9-WqslUY2s, reason: not valid java name */
    public static /* synthetic */ int m358lambda$bRdzZBhYCgKdEm2Kg9WqslUY2s() {
        return d();
    }

    public v(df r3, eh r4, bl r5, d.h.a.a<Integer> r6) {
        df r7 = (df) ZeusTransformUtils.wrapperContextForParams(r3, df.class, "com.obric.aiagent.plugin");
        eh r8 = (eh) ZeusTransformUtils.wrapperContextForParams(r4, eh.class, "com.obric.aiagent.plugin");
        d.h.a.a<Integer> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "metadataStore");
        d.h.b.o.e(r8, "decisionStore");
        d.h.b.o.e(r5, "existencePolicy");
        d.h.b.o.e(r9, "maxEnabledSkillCountProvider");
        this.f20924a = r7;
        this.f20925b = r8;
        this.f20926c = r5;
        this.f20927d = r9;
        this.f20928e = new Object();
        this.f = new ConcurrentHashMap();
        kotlinx.coroutines.b.x<List<com.obric.aiagent.skill.manager.api.e>> r10 = kotlinx.coroutines.b.am.a(d.a.p.b());
        this.g = r10;
        this.h = (kotlinx.coroutines.b.ak) ZeusTransformUtils.preCheckCast(r10, kotlinx.coroutines.b.ak.class, "com.obric.aiagent.plugin");
    }

    public /* synthetic */ v(df r2, eh r3, bl r4, d.h.a.a r5, int r6, d.h.b.h r7) {
        df r8 = (df) ZeusTransformUtils.wrapperContextForParams(r2, df.class, "com.obric.aiagent.plugin");
        eh r9 = (eh) ZeusTransformUtils.wrapperContextForParams(r3, eh.class, "com.obric.aiagent.plugin");
        d.h.a.a r10 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r6 & 4) == 0) goto L6;
        r4 = bl.f19568a;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r10 = $$Lambda$v$bRdzZBhYCgKdEm2Kg9WqslUY2s.INSTANCE;
    L8:
        this(r8, r9, r4, r10);
    }

    private static final int d() {
        return com.obric.aiagent.skill.manager.api.al.f19195a.a().b();
    }

    public final kotlinx.coroutines.b.ak<List<com.obric.aiagent.skill.manager.api.e>> a() {
        return this.h;
    }

    public final com.obric.aiagent.skill.manager.api.e a(com.obric.aiagent.skill.manager.api.e r5) {
        d.h.b.o.e(r5, "skill");
        Object r0 = this.f20928e;
        monitor-enter(r0);
        this.f20926c.b(r5.a());     // Catch: Throwable -> L7
        com.obric.aiagent.skill.manager.api.e r6 = b(c(r5));     // Catch: Throwable -> L7
        ((Map) ZeusTransformUtils.preCheckCast(this.f, Map.class, "com.obric.aiagent.plugin")).put(r6.a(), r6);     // Catch: Throwable -> L7
        this.f20924a.a(r6);     // Catch: Throwable -> L7
        c();     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r6;
    L7:
        th = move-exception;
        throw th;
    }

    public final com.obric.aiagent.skill.manager.api.e a(com.obric.aiagent.skill.manager.api.e r4, d.h.a.b<? super com.obric.aiagent.skill.manager.api.e, com.obric.aiagent.skill.manager.api.e> r5) {
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "skill");
        d.h.b.o.e(r6, "persist");
        Object r0 = this.f20928e;
        monitor-enter(r0);
        this.f20926c.b(r4.a());     // Catch: Throwable -> L7
        com.obric.aiagent.skill.manager.api.e r7 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r6.invoke(b(c(r4))), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        this.f20926c.b(r7.a());     // Catch: Throwable -> L7
        ((Map) ZeusTransformUtils.preCheckCast(this.f, Map.class, "com.obric.aiagent.plugin")).put(r7.a(), r7);     // Catch: Throwable -> L7
        c();     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public final com.obric.aiagent.skill.manager.api.e b(com.obric.aiagent.skill.manager.api.e r25, d.h.a.b<? super com.obric.aiagent.skill.manager.api.e, com.obric.aiagent.skill.manager.api.e> r26) {
        d.h.a.b r1 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r26, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r25, "skill");
        d.h.b.o.e(r1, "persist");
        Object r2 = this.f20928e;
        monitor-enter(r2);
        com.obric.aiagent.skill.manager.api.e r4 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(this.f.get(r25.a()), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        if (r4 == null) goto L10;
        com.obric.aiagent.skill.manager.api.e r3 = c((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r1.invoke(c(com.obric.aiagent.skill.manager.api.e.a(r25, null, null, null, null, null, null, null, null, null, 0, null, r4.l(), false, null, null, null, null, 129023, null))), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L11
        ((Map) ZeusTransformUtils.preCheckCast(this.f, Map.class, "com.obric.aiagent.plugin")).put(r3.a(), r3);     // Catch: Throwable -> L11
        c();     // Catch: Throwable -> L11
        monitor-exit(r2);
        return r3;
    L10:
        throw new dl();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public final List<com.obric.aiagent.skill.manager.api.e> a(List<com.obric.aiagent.skill.manager.api.e> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "nextSkills");
        Object r0 = this.f20928e;
        monitor-enter(r0);
        this.f.clear();     // Catch: Throwable -> L17
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        Iterator r9 = r8.iterator();     // Catch: Throwable -> L17
    L6:
        if (r9.hasNext() == false) goto L10;
        Object r2 = r9.next();     // Catch: Throwable -> L17
        com.obric.aiagent.skill.manager.api.e r3 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        if (this.f20926c.a(r3.a()) == false) goto L6;
        r1.add(r2);     // Catch: Throwable -> L17
        goto L6
    L10:
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L17
    L12:
        if (r10.hasNext() == false) goto L14;
        com.obric.aiagent.skill.manager.api.e r4 = b(c((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r10.next(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L17
        ((Map) ZeusTransformUtils.preCheckCast(this.f, Map.class, "com.obric.aiagent.plugin")).put(r4.a(), r4);     // Catch: Throwable -> L17
        goto L12
    L14:
        c();     // Catch: Throwable -> L17
        Collection<com.obric.aiagent.skill.manager.api.e> r5 = this.f.values();     // Catch: Throwable -> L17
        d.h.b.o.c(r5, "<get-values>(...)");     // Catch: Throwable -> L17
        List<com.obric.aiagent.skill.manager.api.e> r11 = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L17
        monitor-exit(r0);
        return r11;
    L17:
        th = move-exception;
        throw th;
    }

    public final boolean a(String r4) {
        d.h.b.o.e(r4, "slug");
        Object r0 = this.f20928e;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f.remove(r4) == null) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L10;
        this.f20924a.b(r4);     // Catch: Throwable -> L12
        this.f20925b.a(r4);     // Catch: Throwable -> L12
        c();     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public final com.obric.aiagent.skill.manager.api.e a(String r24, boolean r25) {
        d.h.b.o.e(r24, "slug");
        Object r15 = this.f20928e;
        monitor-enter(r15);
        com.obric.aiagent.skill.manager.api.e r3 = null;
        if (this.f20926c.a(r24) == true) goto L7;
    L6:
        Object r22 = r15;
    L17:
        monitor-exit(r22);
        return r3;
    L7:
        com.obric.aiagent.skill.manager.api.e r21 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(this.f.get(r24), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        if (r21 == null) goto L6;
        if (r21.l() != r25) goto L13;
        r22 = r15;
        r3 = r21;
        goto L17
    L13:
        if (r25 == false) goto L15;
        b();     // Catch: Throwable -> L21
    L15:
        r22 = r15;
        r3 = com.obric.aiagent.skill.manager.api.e.a(r21, null, null, null, null, null, null, null, null, null, 0, null, r25, false, null, null, null, null, 129023, null);     // Catch: Throwable -> L19
        ((Map) ZeusTransformUtils.preCheckCast(this.f, Map.class, "com.obric.aiagent.plugin")).put(r21.a(), r3);     // Catch: Throwable -> L19
        this.f20924a.a(r3);     // Catch: Throwable -> L19
        c();     // Catch: Throwable -> L19
    L19:
        th = th;
    L23:
        monitor-exit(r22);
        throw th;
    L21:
        th = th;
        r22 = r15;
        goto L23
    }

    public final boolean b(String r26, boolean r27) {
        d.h.b.o.e(r26, "slug");
        Object r2 = this.f20928e;
        monitor-enter(r2);
        boolean r4 = false;
        if (this.f20926c.a(r26) == false) goto L17;
        com.obric.aiagent.skill.manager.api.e r1 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(this.f.get(r26), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        if (r1 == null) goto L17;
        if (ZeusTransformUtils.instanceOf(r1.g(), com.obric.aiagent.skill.manager.api.aq.e.class) == false) goto L17;
        if (r1.m() == r27) goto L17;
        com.obric.aiagent.skill.manager.api.e r3 = com.obric.aiagent.skill.manager.api.e.a(r1, null, null, null, null, null, null, null, null, null, 0, null, false, r27, null, null, null, null, 126975, null);     // Catch: Throwable -> L19
        this.f20924a.a(r3);     // Catch: Throwable -> L19
        ((Map) ZeusTransformUtils.preCheckCast(this.f, Map.class, "com.obric.aiagent.plugin")).put(r1.a(), r3);     // Catch: Throwable -> L19
        c();     // Catch: Throwable -> L19
        r4 = true;
    L17:
        monitor-exit(r2);
        return r4;
    L19:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final com.obric.aiagent.skill.manager.api.e a(String r27, int r28) {
        d.h.b.o.e(r27, "slug");
        Object r3 = this.f20928e;
        monitor-enter(r3);
        String r5 = null;
        com.obric.aiagent.skill.manager.api.e r6 = null;
        r6 = null;
        r6 = null;
        r5 = null;
        if (this.f20926c.a(r27) == false) goto L35;
        com.obric.aiagent.skill.manager.api.e r4 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(this.f.get(r27), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        if (r4 == null) goto L35;
        if (r4.j() != r28) goto L35;
        gj r7 = this.f20924a.c(r27);     // Catch: Throwable -> L37
        if (r7 == null) goto L18;
        gp r8 = go.a(r7);     // Catch: Throwable -> L37
        if (r8 == null) goto L18;
        r5 = r8.a();     // Catch: Throwable -> L37
    L18:
        if (r5 != null) goto L20;
        r5 = "";
    L20:
        com.obric.aiagent.skill.manager.api.aj r15 = en.a(r4, r7, this.f20925b.a(r27, r28, r5));     // Catch: Throwable -> L37
        if (r4.l() == true) goto L23;
    L25:
        boolean r1 = false;
    L26:
        r6 = com.obric.aiagent.skill.manager.api.e.a(r4, null, null, null, null, null, null, null, null, r15, 0, null, r1, false, null, null, null, null, 128767, null);     // Catch: Throwable -> L37
        if (r6.l() == r4.l()) goto L30;
        ((Map) ZeusTransformUtils.preCheckCast(this.f, Map.class, "com.obric.aiagent.plugin")).put(r4.a(), r6);     // Catch: Throwable -> L37
        this.f20924a.a(r6);     // Catch: Throwable -> L37
    L33:
        if (d.h.b.o.a(r6, r4) == true) goto L35;
        c();     // Catch: Throwable -> L37
        goto L35
    L30:
        if (d.h.b.o.a(r6, r4) == true) goto L33;
        ((Map) ZeusTransformUtils.preCheckCast(this.f, Map.class, "com.obric.aiagent.plugin")).put(r4.a(), r6);     // Catch: Throwable -> L37
        goto L33
    L23:
        if (en.d(r15) == true) goto L25;
        r1 = true;
    L35:
        monitor-exit(r3);
        return r6;
    L37:
        th = move-exception;
        throw th;
    }

    public final Long a(String r28, long r29) {
        d.h.b.o.e(r28, "slug");
        Object r2 = this.f20928e;
        monitor-enter(r2);
        Long r4 = null;
        if (this.f20926c.a(r28) == false) goto L23;
        com.obric.aiagent.skill.manager.api.e r5 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(this.f.get(r28), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        if (r5 == null) goto L23;
        Long r3 = r5.o();     // Catch: Throwable -> L27
        if (r3 == null) goto L13;
        long r6 = r3.longValue();     // Catch: Throwable -> L27
    L14:
        long r7 = Math.max(r6, r29);     // Catch: Throwable -> L27
        Long r8 = r5.o();     // Catch: Throwable -> L27
        if (r8 != null) goto L18;
    L21:
        if (this.f20924a.a(r28, r7) == false) goto L26;
        ((Map) ZeusTransformUtils.preCheckCast(this.f, Map.class, "com.obric.aiagent.plugin")).put(r28, com.obric.aiagent.skill.manager.api.e.a(r5, null, null, null, null, null, null, null, null, null, 0, null, false, false, null, Long.valueOf(r7), null, null, 114687, null));     // Catch: Throwable -> L27
        c();     // Catch: Throwable -> L27
        r4 = Long.valueOf(r7);     // Catch: Throwable -> L27
        goto L23
    L26:
        throw new IllegalStateException(("Installed Skill metadata not found: " + r28).toString());     // Catch: Throwable -> L27
    L18:
        if (r8.longValue() != r7) goto L21;
        r4 = Long.valueOf(r7);     // Catch: Throwable -> L27
        goto L23
    L13:
        r6 = Long.MIN_VALUE;
    L23:
        monitor-exit(r2);
        return r4;
    L27:
        th = move-exception;
        throw th;
    }

    public final com.obric.aiagent.skill.manager.api.e b(String r5) {
        d.h.b.o.e(r5, "slug");
        Object r0 = this.f20928e;
        monitor-enter(r0);
        com.obric.aiagent.skill.manager.api.e r1 = this.f.get(r5);     // Catch: Throwable -> L11
        com.obric.aiagent.skill.manager.api.e r2 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r1, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        if (this.f20926c.a(r5) == true) goto L8;
        r1 = null;
    L8:
        com.obric.aiagent.skill.manager.api.e r4 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r1, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);
        return r4;
    L11:
        th = move-exception;
        throw th;
    }

    public final com.obric.aiagent.skill.manager.api.e c(String r3) {
        d.h.b.o.e(r3, "slug");
        Object r0 = this.f20928e;
        monitor-enter(r0);
        com.obric.aiagent.skill.manager.api.e r2 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(this.f.get(r3), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public final boolean d(String r8) {
        d.h.b.o.e(r8, "slug");
        Object r0 = this.f20928e;
        monitor-enter(r0);
        boolean r2 = true;
        if (this.f20926c.a(r8) == true) goto L7;
    L6:
        r2 = false;
    L29:
        monitor-exit(r0);
        return r2;
    L7:
        com.obric.aiagent.skill.manager.api.e r9 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(this.f.get(r8), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        if (r9 != null) goto L10;
    L12:
        boolean r10 = false;
    L13:
        if (r10 == true) goto L29;
        Collection<com.obric.aiagent.skill.manager.api.e> r11 = this.f.values();     // Catch: Throwable -> L31
        d.h.b.o.c(r11, "<get-values>(...)");     // Catch: Throwable -> L31
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        if (ZeusTransformUtils.instanceOf(r12, Collection.class) == true) goto L17;
    L19:
        Iterator r13 = r12.iterator();     // Catch: Throwable -> L31
        int r1 = 0;
    L21:
        if (r13.hasNext() == false) goto L27;
        if (((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r13.next(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).l() == false) goto L21;
        r1 = r1 + 1;     // Catch: Throwable -> L31
        if (r1 >= 0) goto L21;
        d.a.p.d();     // Catch: Throwable -> L31
    L27:
        if (r1 >= ((Number) ZeusTransformUtils.preCheckCast(this.f20927d.invoke(), Number.class, "com.obric.aiagent.plugin")).intValue()) goto L6;
    L17:
        if (((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L19;
        r1 = 0;
        goto L27
    L10:
        if (r9.l() != true) goto L12;
        r10 = true;
    L31:
        th = move-exception;
        throw th;
    }

    private final void b() {
        Collection<com.obric.aiagent.skill.manager.api.e> r0 = this.f.values();
        d.h.b.o.c(r0, "<get-values>(...)");
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        int r3 = 0;
        if (((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == true) goto L14;
        Iterator r2 = r1.iterator();
    L7:
        if (r2.hasNext() == false) goto L14;
        if (((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).l() == false) goto L7;
        r3 = r3 + 1;
        if (r3 >= 0) goto L7;
        d.a.p.d();
    L14:
        if (r3 >= ((Number) ZeusTransformUtils.preCheckCast(this.f20927d.invoke(), Number.class, "com.obric.aiagent.plugin")).intValue()) goto L17;
        return;
    L17:
        throw new bi();
    }

    private final com.obric.aiagent.skill.manager.api.e b(com.obric.aiagent.skill.manager.api.e r21) {
        if (az.a(r21) == false) goto L7;
        return com.obric.aiagent.skill.manager.api.e.a(r21, null, null, null, null, null, null, null, null, null, 0, null, false, false, null, null, null, null, 129023, null);
    L7:
        if (r21.l() == true) goto L9;
        return r21;
    L9:
        com.obric.aiagent.skill.manager.api.e r1 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(this.f.get(r21.a()), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
        boolean r2 = true;
        int r4 = 0;
        if (r1 != null) goto L12;
    L14:
        r2 = false;
    L15:
        if (r2 == false) goto L17;
        return r21;
    L17:
        Collection<com.obric.aiagent.skill.manager.api.e> r3 = this.f.values();
        d.h.b.o.c(r3, "<get-values>(...)");
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin");
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == true) goto L29;
        Iterator r6 = r5.iterator();
    L22:
        if (r6.hasNext() == false) goto L29;
        if (((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r6.next(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).l() == false) goto L22;
        r4 = r4 + 1;
        if (r4 >= 0) goto L22;
        d.a.p.d();
    L29:
        if (r4 < ((Number) ZeusTransformUtils.preCheckCast(this.f20927d.invoke(), Number.class, "com.obric.aiagent.plugin")).intValue()) goto L32;
        return com.obric.aiagent.skill.manager.api.e.a(r21, null, null, null, null, null, null, null, null, null, 0, null, false, false, null, null, null, null, 129023, null);
    L32:
        return r21;
    L12:
        if (r1.l() != true) goto L14;
        goto L14
    }

    private final void c() {
        kotlinx.coroutines.b.x<List<com.obric.aiagent.skill.manager.api.e>> r0 = this.g;
        Collection<com.obric.aiagent.skill.manager.api.e> r1 = this.f.values();
        d.h.b.o.c(r1, "<get-values>(...)");
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r5 = r4.next();
        com.obric.aiagent.skill.manager.api.e r6 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
        if (this.f20926c.a(r6.a()) == false) goto L4;
        r3.add(r5);
        goto L4
    L8:
        r0.b(d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new a(), Comparator.class, "com.obric.aiagent.plugin")));
    }

    private final com.obric.aiagent.skill.manager.api.e c(com.obric.aiagent.skill.manager.api.e r23) {
        gj r1 = this.f20924a.c(r23.a());
        if (r1 == null) goto L7;
        gp r2 = go.a(r1);
        if (r2 == null) goto L7;
        String r3 = r2.a();
    L8:
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        return com.obric.aiagent.skill.manager.api.e.a(r23, null, null, null, null, null, null, null, null, en.a(r23, r1, this.f20925b.a(r23.a(), r23.j(), r3)), 0, null, false, false, null, null, null, null, 130815, null);
    L7:
        r3 = null;
        goto L8
    }
}
