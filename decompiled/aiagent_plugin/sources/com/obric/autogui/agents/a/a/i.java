package com.obric.autogui.agents.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.l.n;
import d.x;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: ActionEffectOperationTrace.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f26265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<com.obric.autogui.operator.b.EnumC0777b, ArrayDeque<Long>> f26266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<com.obric.autogui.operator.b.EnumC0777b> f26267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f26268d;

    public i() {
        this.f26265a = new Object();
        this.f26266b = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        this.f26267c = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
    }

    public final void a(com.obric.autogui.operator.b.EnumC0777b r3, long r4) {
        o.e(r3, "type");
        Object r0 = this.f26265a;
        monitor-enter(r0);
        Map<com.obric.autogui.operator.b.EnumC0777b, ArrayDeque<Long>> r2 = this.f26266b;     // Catch: Throwable -> L10
        ArrayDeque<Long> r1 = r2.get(r3);     // Catch: Throwable -> L10
        if (r1 != null) goto L7;
        r1 = new ArrayDeque();     // Catch: Throwable -> L10
        r2.put(r3, r1);     // Catch: Throwable -> L10
    L7:
        ((ArrayDeque) ZeusTransformUtils.preCheckCast(r1, ArrayDeque.class, "com.obric.aiagent.plugin")).addLast(Long.valueOf(r4));     // Catch: Throwable -> L10
        x r5 = x.f38692a;     // Catch: Throwable -> L10
        monitor-exit(r0);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final long b(com.obric.autogui.operator.b.EnumC0777b r7, long r8) {
        o.e(r7, "type");
        Object r0 = this.f26265a;
        monitor-enter(r0);
        ArrayDeque r1 = (ArrayDeque) ZeusTransformUtils.preCheckCast(this.f26266b.get(r7), ArrayDeque.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        if (r1 == null) goto L9;
        Long r2 = (Long) ZeusTransformUtils.preCheckCast(r1.pollFirst(), Long.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        if (r2 == null) goto L9;
        long r3 = r2.longValue();     // Catch: Throwable -> L13
    L10:
        ((Collection) ZeusTransformUtils.preCheckCast(this.f26267c, Collection.class, "com.obric.aiagent.plugin")).add(r7);     // Catch: Throwable -> L13
        this.f26268d++;     // Catch: Throwable -> L13
        long r6 = n.a(r8 - r3, 0);     // Catch: Throwable -> L13
        monitor-exit(r0);
        return r6;
    L9:
        r3 = r8;
    L13:
        th = move-exception;
        throw th;
    }

    public final void a(com.obric.autogui.operator.b.EnumC0777b r5) {
        o.e(r5, "type");
        Object r0 = this.f26265a;
        monitor-enter(r0);
        ((Collection) ZeusTransformUtils.preCheckCast(this.f26267c, Collection.class, "com.obric.aiagent.plugin")).add(r5);     // Catch: Throwable -> L7
        this.f26268d++;     // Catch: Throwable -> L7
        x r4 = x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final boolean a() {
        Object r0 = this.f26265a;
        monitor-enter(r0);
        if (this.f26268d != 0) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);
        return r1;
    L7:
        r1 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public final boolean b(com.obric.autogui.operator.b.EnumC0777b r2) {
        o.e(r2, "type");
        Object r0 = this.f26265a;
        monitor-enter(r0);
        boolean r1 = this.f26267c.contains(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
