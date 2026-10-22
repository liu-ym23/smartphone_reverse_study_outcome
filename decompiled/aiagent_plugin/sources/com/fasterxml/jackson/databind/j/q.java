package com.fasterxml.jackson.databind.j;

import com.fasterxml.jackson.databind.ac;
import com.fasterxml.jackson.databind.l.aa;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SerializerCache.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<aa, com.fasterxml.jackson.databind.p<Object>> f12954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicReference<com.fasterxml.jackson.databind.j.a.l> f12955b;

    public q() {
        this.f12954a = new HashMap(64);
        this.f12955b = new AtomicReference();
    }

    public com.fasterxml.jackson.databind.j.a.l a() {
        com.fasterxml.jackson.databind.j.a.l r0 = (com.fasterxml.jackson.databind.j.a.l) ZeusTransformUtils.preCheckCast(this.f12955b.get(), com.fasterxml.jackson.databind.j.a.l.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        return b();
    }

    private final synchronized com.fasterxml.jackson.databind.j.a.l b() {
        monitor-enter(this);
        com.fasterxml.jackson.databind.j.a.l r0 = (com.fasterxml.jackson.databind.j.a.l) ZeusTransformUtils.preCheckCast(this.f12955b.get(), com.fasterxml.jackson.databind.j.a.l.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        if (r0 != null) goto L6;
        r0 = com.fasterxml.jackson.databind.j.a.l.a(this.f12954a);     // Catch: Throwable -> L8
        this.f12955b.set(r0);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r0;
    L8:
        th = move-exception;
        throw th;
    }

    public com.fasterxml.jackson.databind.p<Object> a(Class<?> r4) {
        monitor-enter(this);
        com.fasterxml.jackson.databind.p<Object> r5 = (com.fasterxml.jackson.databind.p) ZeusTransformUtils.preCheckCast(this.f12954a.get(new aa(r4, false)), com.fasterxml.jackson.databind.p.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public com.fasterxml.jackson.databind.p<Object> a(com.fasterxml.jackson.databind.k r4) {
        monitor-enter(this);
        com.fasterxml.jackson.databind.p<Object> r5 = (com.fasterxml.jackson.databind.p) ZeusTransformUtils.preCheckCast(this.f12954a.get(new aa(r4, false)), com.fasterxml.jackson.databind.p.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public com.fasterxml.jackson.databind.p<Object> b(com.fasterxml.jackson.databind.k r4) {
        monitor-enter(this);
        com.fasterxml.jackson.databind.p<Object> r5 = (com.fasterxml.jackson.databind.p) ZeusTransformUtils.preCheckCast(this.f12954a.get(new aa(r4, true)), com.fasterxml.jackson.databind.p.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public com.fasterxml.jackson.databind.p<Object> b(Class<?> r4) {
        monitor-enter(this);
        com.fasterxml.jackson.databind.p<Object> r5 = (com.fasterxml.jackson.databind.p) ZeusTransformUtils.preCheckCast(this.f12954a.get(new aa(r4, true)), com.fasterxml.jackson.databind.p.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public void a(com.fasterxml.jackson.databind.k r4, com.fasterxml.jackson.databind.p<Object> r5) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f12954a.put(new aa(r4, true), r5) != null) goto L6;
        this.f12955b.set(null);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
    }

    public void a(Class<?> r4, com.fasterxml.jackson.databind.p<Object> r5) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f12954a.put(new aa(r4, true), r5) != null) goto L6;
        this.f12955b.set(null);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
    }

    public void a(com.fasterxml.jackson.databind.k r4, com.fasterxml.jackson.databind.p<Object> r5, ac r6) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f12954a.put(new aa(r4, false), r5) != null) goto L7;
        this.f12955b.set(null);     // Catch: Throwable -> L11
    L7:
        if (ZeusTransformUtils.instanceOf(r5, p.class) == false) goto L9;
        ((p) ZeusTransformUtils.preCheckCast(r5, p.class, "com.obric.aiagent.plugin")).a(r6);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
    }

    public void a(Class<?> r4, com.fasterxml.jackson.databind.k r5, com.fasterxml.jackson.databind.p<Object> r6, ac r7) {
        monitor-enter(this);
        com.fasterxml.jackson.databind.p<Object> r8 = this.f12954a.put(new aa(r4, false), r6);     // Catch: Throwable -> L12
        com.fasterxml.jackson.databind.p<Object> r9 = this.f12954a.put(new aa(r5, false), r6);     // Catch: Throwable -> L12
        if (r8 == null) goto L6;
        if (r9 == null) goto L6;
    L8:
        if (ZeusTransformUtils.instanceOf(r6, p.class) == false) goto L10;
        ((p) ZeusTransformUtils.preCheckCast(r6, p.class, "com.obric.aiagent.plugin")).a(r7);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L6:
        this.f12955b.set(null);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }
}
