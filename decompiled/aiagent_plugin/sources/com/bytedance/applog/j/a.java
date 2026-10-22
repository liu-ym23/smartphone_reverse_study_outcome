package com.bytedance.applog.j;

import com.bytedance.applog.monitor.v3.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: AppLogCache.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f5649a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedList<com.bytedance.applog.store.a> f5650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LinkedList<String> f5651c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile int f5652d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bytedance.applog.c f5653e;

    static {
        f5649a = Collections.singletonList("AppLogCache");
    }

    public a(com.bytedance.applog.c r2) {
        this.f5650b = new LinkedList();
        this.f5651c = new LinkedList();
        this.f5652d = 1000;
        this.f5653e = r2;
    }

    public void a(com.bytedance.applog.store.a r9) {
        LinkedList<com.bytedance.applog.store.a> r0 = this.f5650b;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.f5650b.size() <= this.f5652d) goto L12;
        com.bytedance.applog.store.a r1 = (com.bytedance.applog.store.a) ZeusTransformUtils.preCheckCast(this.f5650b.poll(), com.bytedance.applog.store.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        if (r1 == null) goto L12;
        if (r1.s <= 0) goto L11;
        com.bytedance.applog.monitor.c.a(this.f5653e.N(), com.bytedance.applog.monitor.v3.a.g, r9);     // Catch: Throwable -> L15
    L11:
        this.f5653e.N().increaseStats(j.m);     // Catch: Throwable -> L15
        String r2 = r1.toString();     // Catch: Throwable -> L15
        this.f5653e.N().sendError("cache drop event", new Throwable(r2), false);     // Catch: Throwable -> L15
        this.f5653e.Z().c(f5649a, "AppLogCache overflow remove data: {}", new Object[]{r1});     // Catch: Throwable -> L15
        com.bytedance.applog.monitor.a.b.a().a(r2);     // Catch: Throwable -> L15
    L12:
        this.f5650b.add(r9);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
    }

    public void a(String[] r8) {
        LinkedList<String> r0 = this.f5651c;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f5651c.size() <= this.f5652d) goto L7;
        String r1 = (String) ZeusTransformUtils.preCheckCast(this.f5651c.poll(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        this.f5653e.Z().c(f5649a, "AppLogCache overflow2 remove data: {}", new Object[]{r1});     // Catch: Throwable -> L10
        this.f5653e.N().increaseStats(j.m);     // Catch: Throwable -> L10
        com.bytedance.applog.monitor.a.b.a().a(r1);     // Catch: Throwable -> L10
    L7:
        this.f5651c.addAll(Arrays.asList(r8));     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    public int a(ArrayList<com.bytedance.applog.store.a> r6) {
        LinkedList<com.bytedance.applog.store.a> r0 = this.f5650b;
        monitor-enter(r0);
        int r1 = this.f5650b.size();     // Catch: Throwable -> L13
        r6.addAll(this.f5650b);     // Catch: Throwable -> L13
        Iterator<com.bytedance.applog.store.a> r7 = this.f5650b.iterator();     // Catch: Throwable -> L13
    L6:
        if (r7.hasNext() == false) goto L10;
        com.bytedance.applog.store.a r2 = (com.bytedance.applog.store.a) ZeusTransformUtils.preCheckCast(r7.next(), com.bytedance.applog.store.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        if (r2.s <= 0) goto L6;
        com.bytedance.applog.monitor.c.a(this.f5653e.N(), com.bytedance.applog.monitor.v3.a.h, r2);     // Catch: Throwable -> L13
        goto L6
    L10:
        this.f5650b.clear();     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r1;
    L13:
        th = move-exception;
        throw th;
    }

    public String[] a() {
        int r0 = this.f5651c.size();
        if (r0 <= 0) goto L5;
        String[] r1 = new String[r0];
        this.f5651c.toArray(r1);
        this.f5651c.clear();
        return r1;
    L5:
        return null;
    }
}
