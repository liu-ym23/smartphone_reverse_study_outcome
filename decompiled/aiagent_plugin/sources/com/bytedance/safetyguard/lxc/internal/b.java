package com.bytedance.safetyguard.lxc.internal;

import android.content.Context;
import com.bytedance.safetyguard.lxc.api.SafetyGuard;
import com.bytedance.safetyguard.lxc.api.SafetyGuardLogger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.a.q;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: SafetyGuardInstanceProvider.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q<Context, SafetyGuard, SafetyGuardLogger, x> f9724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m<Context, SafetyGuardLogger, SafetyGuard> f9725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile SafetyGuard f9726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f9727d;

    public b(q<? super Context, ? super SafetyGuard, ? super SafetyGuardLogger, x> r3, m<? super Context, ? super SafetyGuardLogger, ? extends SafetyGuard> r4) {
        q<Context, SafetyGuard, SafetyGuardLogger, x> r5 = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin");
        m<Context, SafetyGuardLogger, SafetyGuard> r6 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin");
        o.e(r5, "onCreated");
        o.e(r6, "factory");
        this.f9724a = r5;
        this.f9725b = r6;
        this.f9727d = new Object();
    }

    public final SafetyGuard a(Context r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        o.e(r9, "appContext");
        SafetyGuard r0 = this.f9726c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        boolean r1 = false;
        Object r2 = this.f9727d;
        monitor-enter(r2);
        SafetyGuard r3 = this.f9726c;     // Catch: Throwable -> L15
        if (r3 != null) goto L11;
        m<Context, SafetyGuardLogger, SafetyGuard> r4 = this.f9725b;     // Catch: Throwable -> L15
        o.a(r10);     // Catch: Throwable -> L15
        SafetyGuard r5 = r4.invoke(r10, null);     // Catch: Throwable -> L15
        this.f9726c = (SafetyGuard) ZeusTransformUtils.preCheckCast(r5, SafetyGuard.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        r3 = (SafetyGuard) ZeusTransformUtils.preCheckCast(r5, SafetyGuard.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        r1 = true;
    L11:
        monitor-exit(r2);
        if (r1 == false) goto L14;
        q<Context, SafetyGuard, SafetyGuardLogger, x> r7 = this.f9724a;
        o.a(r10);
        r7.invoke(r10, r3, null);
    L14:
        return r3;
    L15:
        th = move-exception;
        throw th;
    }

    public final SafetyGuard a(Context r5, SafetyGuardLogger r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        SafetyGuardLogger r8 = (SafetyGuardLogger) ZeusTransformUtils.wrapperContextForParams(r6, SafetyGuardLogger.class, "com.obric.aiagent.plugin");
        o.e(r7, "appContext");
        o.e(r8, "logger");
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        Object r0 = this.f9727d;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.f9726c != null) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L14;
        m<Context, SafetyGuardLogger, SafetyGuard> r2 = this.f9725b;     // Catch: Throwable -> L15
        o.a(r9);     // Catch: Throwable -> L15
        SafetyGuard r3 = r2.invoke(r9, r8);     // Catch: Throwable -> L15
        this.f9726c = (SafetyGuard) ZeusTransformUtils.preCheckCast(r3, SafetyGuard.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        SafetyGuard r4 = (SafetyGuard) ZeusTransformUtils.preCheckCast(r3, SafetyGuard.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        monitor-exit(r0);
        this.f9724a.invoke(r9, r4, r8);
        return r4;
    L14:
        throw new IllegalStateException("SafetyGuard is already initialized; initializeSafetyGuard must be called before getSafetyGuard".toString());     // Catch: Throwable -> L15
    L7:
        r1 = false;
        goto L8
    }
}
