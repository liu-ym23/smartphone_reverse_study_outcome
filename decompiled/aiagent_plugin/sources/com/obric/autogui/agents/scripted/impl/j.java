package com.obric.autogui.agents.scripted.impl;

import com.obric.autogui.resourcemanage.x;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: compiled from: ResourceUpdateRoundGate.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f27005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f27006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean[] f27007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<d.h.a.b<x, d.x>> f27008d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f27009e;
    private boolean f;
    private ScheduledFuture<?> g;

    public j(long r1, int r3) {
        this.f27005a = r1;
        this.f27006b = new Object();
        this.f27007c = new boolean[r3];
        this.f27008d = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    }

    public final long a() {
        return this.f27005a;
    }

    public final boolean a(List<? extends d.h.a.b<? super x, d.x>> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "actions");
        Object r0 = this.f27006b;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f27009e == false) goto L7;
    L11:
        boolean r3 = false;
    L12:
        monitor-exit(r0);
        return r3;
    L7:
        if (this.f == true) goto L11;
        d.a.p.a((Collection) ZeusTransformUtils.preCheckCast(this.f27008d, Collection.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L14
        r3 = true;
        goto L12
    }

    public final boolean a(d.h.a.a<d.x> r3) {
        d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "block");
        Object r0 = this.f27006b;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f27009e == false) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);
        return r2;
    L7:
        if (this.f == true) goto L11;
        r4.invoke();     // Catch: Throwable -> L14
        r2 = true;
        goto L12
    }

    public final List<d.h.a.b<x, d.x>> b() {
        Object r0 = this.f27006b;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f27009e == false) goto L7;
    L11:
        List<d.h.a.b<x, d.x>> r3 = null;
    L12:
        monitor-exit(r0);
        return r3;
    L7:
        if (this.f == true) goto L11;
        this.f27009e = true;     // Catch: Throwable -> L14
        r3 = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(this.f27008d, Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L14
        goto L12
    }

    public final i a(int r8) {
        Object r0 = this.f27006b;
        monitor-enter(r0);
        ScheduledFuture<?> r2 = null;
        if (this.f == true) goto L21;
        boolean[] r1 = this.f27007c;     // Catch: Throwable -> L26
        if (r1[r8] == true) goto L21;
        r1[r8] = true;     // Catch: Throwable -> L26
        int r9 = r1.length;     // Catch: Throwable -> L26
        int r5 = 0;
    L10:
        if (r5 >= r9) goto L15;
        if (r1[r5] == false) goto L13;
        r5 = r5 + 1;     // Catch: Throwable -> L26
        goto L10
    L13:
        boolean r10 = false;
    L16:
        if (r10 == false) goto L18;
        this.f = true;     // Catch: Throwable -> L26
        ScheduledFuture<?> r3 = this.g;     // Catch: Throwable -> L26
        this.g = null;     // Catch: Throwable -> L26
        r2 = r3;
    L18:
        if (r10 == false) goto L20;
        i r7 = i.f27002c;     // Catch: Throwable -> L26
    L22:
        monitor-exit(r0);
        if (r2 == null) goto L25;
        r2.cancel(false);
    L25:
        return r7;
    L20:
        r7 = i.f27001b;     // Catch: Throwable -> L26
        goto L22
    L15:
        r10 = true;
    L21:
        r7 = i.f27000a;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    public final boolean a(ScheduledFuture<?> r5) {
        ScheduledFuture<?> r6 = (ScheduledFuture) ZeusTransformUtils.wrapperContextForParams(r5, ScheduledFuture.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "future");
        Object r0 = this.f27006b;
        monitor-enter(r0);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (this.f27009e == false) goto L7;
    L14:
        boolean r4 = true;
    L15:
        monitor-exit(r0);
        if (r4 == false) goto L19;
        r6.cancel(false);
    L19:
        return !r4;
    L7:
        if (this.f == true) goto L14;
        ScheduledFuture<?> r1 = this.g;     // Catch: Throwable -> L20
        if (r1 == null) goto L12;
        r1.cancel(false);     // Catch: Throwable -> L20
    L12:
        this.g = r6;     // Catch: Throwable -> L20
        r4 = false;
        goto L15
    }
}
