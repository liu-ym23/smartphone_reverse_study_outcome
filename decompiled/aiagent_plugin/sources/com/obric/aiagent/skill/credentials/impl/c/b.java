package com.obric.aiagent.skill.credentials.impl.c;

import android.app.Application;
import android.content.Context;
import com.bytedance.safetyguard.lxc.api.SafetyGuard;
import com.bytedance.safetyguard.lxc.api.SafetyGuardKt;
import com.bytedance.safetyguard.lxc.api.SafetyGuardLogger;
import com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.skill.credentials.api.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.n;
import d.o;

/* JADX INFO: compiled from: SafetyGuardSidecarProvider.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f19023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f19024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile SafetyGuardSidecar f19025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f19026d;

    public b() {
        this.f19023a = new Object();
        this.f19024b = new Object();
    }

    public final SafetyGuardSidecar a() {
        SafetyGuardSidecar r0 = this.f19025c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Object r1 = this.f19023a;
        monitor-enter(r1);
        SafetyGuardSidecar r2 = this.f19025c;     // Catch: Throwable -> L12
        if (r2 != null) goto L10;
        r2 = b();     // Catch: Throwable -> L12
        this.f19025c = r2;     // Catch: Throwable -> L12
    L10:
        monitor-exit(r1);
        return r2;
    L12:
        th = move-exception;
        throw th;
    }

    private final SafetyGuardSidecar b() {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        Object r3 = n.f(((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin")).a((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSidecar());     // Catch: Throwable -> L5
    L7:
        Throwable r2 = n.c(r3);
        if (r2 == null) goto L10;
        c.a("createSidecar failed", "createSidecar failed", r2);
        throw new e(c.a(r2, "createSidecar"));
    L10:
        return (SafetyGuardSidecar) ZeusTransformUtils.preCheckCast(r3, SafetyGuardSidecar.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        n.a r4 = n.f38560a;
        r3 = n.f(o.a(th));
        goto L7
    }

    private final SafetyGuard a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (this.f19026d == false) goto L6;
        d.h.b.o.a(r4);
        return SafetyGuardKt.getSafetyGuard(r4);
    L6:
        Object r0 = this.f19024b;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (this.f19026d == false) goto L11;
        d.h.b.o.a(r4);     // Catch: Throwable -> L14
        SafetyGuard r2 = SafetyGuardKt.getSafetyGuard(r4);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r0);
        return r2;
    L11:
        d.h.b.o.a(r4);     // Catch: Throwable -> L14
        r2 = b(r4);     // Catch: Throwable -> L14
        goto L12
    }

    private final SafetyGuard b(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        n.a r0 = n.f38560a;     // Catch: Throwable -> L5
        b r1 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r2 = n.f(SafetyGuardKt.initializeSafetyGuard(r8, (SafetyGuardLogger) ZeusTransformUtils.preCheckCast(a.f19021a, SafetyGuardLogger.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L5
    L8:
        if (n.a(r2) == false) goto L10;
        SafetyGuard r3 = (SafetyGuard) ZeusTransformUtils.preCheckCast(r2, SafetyGuard.class, "com.obric.aiagent.plugin");
        this.f19026d = true;
        ILogDepend.Companion.i("SkillCred/SafetyGuard", "initializeSafetyGuard completed");
    L10:
        Throwable r4 = n.c(r2);
        if (r4 == null) goto L17;
        if (a(r4) == false) goto L19;
        this.f19026d = true;
        ILogDepend.Companion.w("SkillCred/SafetyGuard", "initializeSafetyGuard skipped because SafetyGuard already exists");
        r2 = SafetyGuardKt.getSafetyGuard(r8);
        goto L17
    L19:
        if (IAppContext.Companion.isDebug() == false) goto L21;
        ILogDepend.Companion.e("SkillCred/SafetyGuard", "initializeSafetyGuard failed", r4);
        throw r4;
    L21:
        ILogDepend.Companion.e("SkillCred/SafetyGuard", "initializeSafetyGuard failed");
        throw r4;
    L17:
        return (SafetyGuard) ZeusTransformUtils.preCheckCast(r2, SafetyGuard.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        n.a r5 = n.f38560a;
        r2 = n.f(o.a(th));
        goto L8
    }

    private final boolean a(Throwable r4) {
        if (ZeusTransformUtils.instanceOf(r4, IllegalStateException.class) == false) goto L10;
        String r3 = r4.getMessage();
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("already initialized", CharSequence.class, "com.obric.aiagent.plugin"), true) == false) goto L10;
        return true;
    L10:
        return false;
    }
}
