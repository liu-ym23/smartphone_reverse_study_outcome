package com.obric.aiagent.executionengine.scheduler.impl.execution.a;

import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.capabilitykit.common.execution.IntentCalling;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.h.b.o;
import d.x;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: DozeRestrictionInterceptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f18392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f18393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<String> f18394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f18395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f18396e;
    private final HashMap<String, Long> f;
    private final String g;

    public a() {
        this.f18392a = "DozeRestr-Intercept";
        this.f18393b = true;
        this.f18394c = ax.a(new String[]{"com.obric.weather", "com.obric.appletapp"});
        this.f18395d = new Object();
        this.f18396e = OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS;
        this.f = new HashMap();
        this.g = "obric-app-intent-exec";
    }

    public void a(String r9, IntentCalling r10) {
        o.e(r9, "targetPackage");
        o.e(r10, "intentCalling");
        if (this.f18394c.contains(r9) == true) goto L6;
        ILogDepend.Companion.d(this.f18392a, "no-need: doze restriction waiving for `" + r9 + '`');
        return;
    L6:
        boolean r11 = false;
        Object r0 = this.f18395d;
        monitor-enter(r0);
        long r1 = System.currentTimeMillis();     // Catch: Throwable -> L20
        Long r3 = this.f.getOrDefault(r9, -1L);     // Catch: Throwable -> L20
        o.c(r3, "getOrDefault(...)");     // Catch: Throwable -> L20
        long r6 = ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).longValue();     // Catch: Throwable -> L20
        if (r6 != (-1)) goto L11;
    L12:
        r11 = true;
        ((Map) ZeusTransformUtils.preCheckCast(this.f, Map.class, "com.obric.aiagent.plugin")).put(r9, Long.valueOf(r1));     // Catch: Throwable -> L20
    L13:
        x r2 = x.f38692a;     // Catch: Throwable -> L20
        monitor-exit(r0);
        ILogDepend.Companion.i(this.f18392a, "doze restriction waiving for `" + r9 + "`: " + r11);
        if (r11 == true) goto L18;
        return;
    L18:
        a(r9, this.f18396e);
        return;
    L11:
        if ((r1 - r6) < this.f18396e) goto L13;
    L20:
        th = move-exception;
        throw th;
    }

    public void b(String r7, IntentCalling r8) {
        o.e(r7, "targetPackage");
        o.e(r8, "intentCalling");
        if (this.f18394c.contains(r7) == true) goto L6;
        ILogDepend.Companion.d(this.f18392a, "no-need: doze restriction waiving for `" + r7 + '`');
        return;
    L6:
        boolean r9 = false;
        Object r0 = this.f18395d;
        monitor-enter(r0);
        Long r1 = this.f.getOrDefault(r7, -1L);     // Catch: Throwable -> L18
        o.c(r1, "getOrDefault(...)");     // Catch: Throwable -> L18
        if (((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).longValue() == (-1)) goto L11;
        r9 = true;
        this.f.remove(r7);     // Catch: Throwable -> L18
    L11:
        x r2 = x.f38692a;     // Catch: Throwable -> L18
        monitor-exit(r0);
        ILogDepend.Companion.i(this.f18392a, "doze restriction waiving (restore) for `" + r7 + "`: " + r9);
        if (r9 == true) goto L16;
        return;
    L16:
        a(r7);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    private final boolean a(String r4, long r5) {
        return ObricProductSdk.INSTANCE.platformService().deviceIdleController().addToTemporaryAllowList(new String[]{r4}, r5, this.g);
    }

    private final boolean a(String r5) {
        ObricProductSdk.INSTANCE.platformService().deviceIdleController().removeFromTemporaryAllowList(new String[]{r5}, this.g);
        return true;
    }
}
