package com.bytedance.vmsdk.a.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: HandlerRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<i> f11676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<c> f11677b;

    public b() {
        this.f11676a = new ArrayList();
        this.f11677b = new ArrayList();
    }

    public synchronized void a(i r3, c r4) {
        monitor-enter(this);
        i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        this.f11676a.add(r5);     // Catch: Throwable -> L6
        this.f11677b.add(r6);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean b(i r3, c r4) {
        monitor-enter(this);
        i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        int r7 = this.f11676a.indexOf(r5);     // Catch: Throwable -> L14
        if (r7 < 0) goto L12;
        if (r6 != this.f11677b.get(r7)) goto L12;
        this.f11676a.remove(r7);     // Catch: Throwable -> L14
        this.f11677b.remove(r7);     // Catch: Throwable -> L14
        monitor-exit(this);
        return true;
    L12:
        monitor-exit(this);
        return false;
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized c a(String r6) {
        monitor-enter(this);
        int r0 = 0;
        int r1 = this.f11676a.size();     // Catch: Throwable -> L15
    L5:
        if (r0 >= r1) goto L13;
        if (((i) ZeusTransformUtils.preCheckCast(this.f11676a.get(r0), i.class, "com.obric.aiagent.plugin")).a(r6) == true) goto L8;
        r0 = r0 + 1;
        goto L5
    L8:
        c r7 = (c) ZeusTransformUtils.preCheckCast(this.f11677b.get(r0), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        monitor-exit(this);
        return r7;
    L13:
        monitor-exit(this);
        return null;
    L15:
        th = move-exception;
        throw th;
    }
}
