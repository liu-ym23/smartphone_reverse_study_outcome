package com.obric.autogui.agents.vlm.models.omni;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: ActionEffectEvaluationBatch.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f28234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f28235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Integer, e> f28236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<Integer, Integer> f28237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<Integer, String> f28238e;
    private Integer f;
    private d.h.a.b<? super e, d.x> g;

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((e) ZeusTransformUtils.preCheckCast(r2, e.class, "com.obric.aiagent.plugin")).a()), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin")).a()), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((e) ZeusTransformUtils.preCheckCast(r2, e.class, "com.obric.aiagent.plugin")).a()), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin")).a()), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    public c(int r3) {
        this.f28234a = d.l.n.c(r3, 0);
        this.f28235b = new Object();
        this.f28236c = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        this.f28237d = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        this.f28238e = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    public final boolean a(int r5) {
        Object r0 = this.f28235b;
        monitor-enter(r0);
        this.f = Integer.valueOf(r5);     // Catch: Throwable -> L13
        boolean r2 = false;
        if (b(r5) == true) goto L8;
    L11:
        monitor-exit(r0);
        return r2;
    L8:
        if (this.f28236c.remove(Integer.valueOf(r5)) == null) goto L10;
        r2 = true;
    L10:
        this.f28237d.remove(Integer.valueOf(r5));     // Catch: Throwable -> L13
        this.f28238e.remove(Integer.valueOf(r5));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final boolean a(int r6, int r7, String r8) {
        Object r0 = this.f28235b;
        monitor-enter(r0);
        boolean r2 = true;
        boolean r3 = false;
        if (b(r6) == true) goto L7;
        r2 = false;
    L19:
        monitor-exit(r0);
        return r2;
    L7:
        this.f28237d.put(Integer.valueOf(r6), Integer.valueOf(r7));     // Catch: Throwable -> L21
        String r9 = null;
        if (r8 == null) goto L16;
        String r10 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).toString();     // Catch: Throwable -> L21
        if (r10 == null) goto L16;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L14;
        r3 = true;
    L14:
        if (r3 == false) goto L16;
        r9 = r10;
    L16:
        if (r9 != null) goto L18;
        this.f28238e.remove(Integer.valueOf(r6));     // Catch: Throwable -> L21
        goto L19
    L18:
        this.f28238e.put(Integer.valueOf(r6), r9);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public final boolean a(int r26, String r27, String r28, String r29, com.obric.autogui.agents.a.f.f r30) {
        d.h.b.o.e(r27, "stepId");
        d.h.b.o.e(r28, "attemptId");
        d.h.b.o.e(r29, "actionType");
        d.h.b.o.e(r30, "mode");
        Object r1 = this.f28235b;
        monitor-enter(r1);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (b(r26) == true) goto L7;
    L11:
        boolean r0 = false;
    L12:
        monitor-exit(r1);
        return r0;
    L7:
        if (this.f28236c.containsKey(Integer.valueOf(r26)) == true) goto L11;
        Integer r15 = Integer.valueOf(r26);     // Catch: Throwable -> L14
        this.f28236c.put(r15, new e(r26, this.f28234a, r27, false, new com.obric.autogui.agents.a.f.g(r28, r29, com.obric.autogui.agents.a.f.k.f26444c, com.obric.autogui.agents.a.f.k.f26444c, r30, null, null, null, null, null, null, 2016, null)));     // Catch: Throwable -> L14
        r0 = true;
        goto L12
    }

    public final e a(int r10, String r11, com.obric.autogui.agents.a.f.g r12) {
        d.h.b.o.e(r11, "stepId");
        d.h.b.o.e(r12, "evaluation");
        Object r0 = this.f28235b;
        monitor-enter(r0);
        e r2 = null;
        if (b(r10) == true) goto L7;
    L11:
        d.h.a.b<? super e, d.x> r13 = null;
    L12:
        monitor-exit(r0);
        a(r13, r2);
        return r2;
    L7:
        if (this.f28236c.containsKey(Integer.valueOf(r10)) == true) goto L11;
        r2 = new e(r10, this.f28234a, r11, true, r12);     // Catch: Throwable -> L15
        this.f28236c.put(Integer.valueOf(r10), r2);     // Catch: Throwable -> L15
        r13 = this.g;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public final e b(int r11, String r12, com.obric.autogui.agents.a.f.g r13) {
        d.h.b.o.e(r12, "attemptId");
        d.h.b.o.e(r13, "evaluation");
        Object r0 = this.f28235b;
        monitor-enter(r0);
        e r2 = (e) ZeusTransformUtils.preCheckCast(this.f28236c.get(Integer.valueOf(r11)), e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        e r1 = null;
        if (r2 != null) goto L8;
    L6:
        d.h.a.b<? super e, d.x> r14 = null;
    L17:
        monitor-exit(r0);
        a(r14, r1);
        return r1;
    L8:
        if (r2.d() == true) goto L6;
        if (d.h.b.o.a(r2.e().a(), r12) == false) goto L6;
        if (d.h.b.o.a(r13.a(), r12) == false) goto L6;
        if (r13.e() != r2.e().e()) goto L6;
        r1 = e.a(r2, 0, 0, null, true, r13, 7, null);     // Catch: Throwable -> L20
        this.f28236c.put(Integer.valueOf(r11), r1);     // Catch: Throwable -> L20
        r14 = this.g;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public final boolean a(int r5, String r6) {
        d.h.b.o.e(r6, "attemptId");
        Object r0 = this.f28235b;
        monitor-enter(r0);
        e r1 = (e) ZeusTransformUtils.preCheckCast(this.f28236c.get(Integer.valueOf(r5)), e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        boolean r2 = false;
        if (r1 != null) goto L8;
    L14:
        monitor-exit(r0);
        return r2;
    L8:
        if (r1.d() == true) goto L14;
        if (d.h.b.o.a(r1.e().a(), r6) == false) goto L14;
        this.f28236c.remove(Integer.valueOf(r5));     // Catch: Throwable -> L16
        r2 = true;
    L16:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ f a(c r0, Integer r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return r0.a(r1);
    }

    public final f a(Integer r11) {
        Object r0 = this.f28235b;
        monitor-enter(r0);
        List r5 = d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(this.f28236c.values(), Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new a(), Comparator.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L16
        int r4 = this.f28234a;     // Catch: Throwable -> L16
        Map r6 = ao.d(this.f28237d);     // Catch: Throwable -> L16
        Map r7 = ao.d(this.f28238e);     // Catch: Throwable -> L16
        Integer r8 = this.f;     // Catch: Throwable -> L16
        if (r11 == null) goto L12;
        ((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.aiagent.plugin")).intValue();     // Catch: Throwable -> L16
        if (r5.isEmpty() == true) goto L10;
        r11 = null;
    L10:
        if (r11 == null) goto L12;
        h r9 = new h(((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.aiagent.plugin")).intValue());     // Catch: Throwable -> L16
    L13:
        f r10 = new f(r4, r5, r6, r7, r8, r9);     // Catch: Throwable -> L16
        monitor-exit(r0);
        return r10;
    L12:
        r9 = null;
    L16:
        th = move-exception;
        throw th;
    }

    public final List<e> a(Set<String> r5, d.h.a.b<? super e, d.x> r6) {
        Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super e, d.x> r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "knownCompletedAttemptIds");
        d.h.b.o.e(r8, "listener");
        Object r0 = this.f28235b;
        monitor-enter(r0);
        this.g = r8;     // Catch: Throwable -> L18
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(this.f28236c.values(), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        Iterator r10 = r4.iterator();     // Catch: Throwable -> L18
    L6:
        if (r10.hasNext() == false) goto L15;
        Object r1 = r10.next();     // Catch: Throwable -> L18
        e r2 = (e) ZeusTransformUtils.preCheckCast(r1, e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        if (r2.d() == true) goto L10;
    L12:
        boolean r3 = false;
    L13:
        if (r3 == false) goto L6;
        r9.add(r1);     // Catch: Throwable -> L18
        goto L6
    L10:
        if (r7.contains(r2.e().a()) == true) goto L12;
        r3 = true;
        goto L13
    L15:
        List<e> r11 = d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L18
        monitor-exit(r0);
        return r11;
    L18:
        th = move-exception;
        throw th;
    }

    private final boolean b(int r2) {
        if (r2 >= 0) goto L5;
        return false;
    L5:
        if (r2 >= this.f28234a) goto L9;
        return true;
    L9:
        return false;
    }

    private final void a(d.h.a.b<? super e, d.x> r3, e r4) {
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L13;
        if (r4 == null) goto L14;
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L8
        c r2 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        r5.invoke(r4);     // Catch: Throwable -> L8
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        d.n.a r6 = d.n.f38560a;
        d.n.f(d.o.a(th));
        return;
    L14:
        return;
    }
}
