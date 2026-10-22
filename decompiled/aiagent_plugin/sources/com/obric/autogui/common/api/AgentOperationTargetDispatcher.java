package com.obric.autogui.common.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.a.a;
import d.h.a.m;
import d.h.a.q;
import d.h.b.h;
import d.h.b.o;
import d.n;
import d.x;
import java.util.List;

/* JADX INFO: compiled from: AgentOperationTargetDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AgentOperationTargetDispatcher {
    private static final Companion Companion = null;
    private static final List<Long> DEFAULT_RETRY_DELAYS_MILLIS = null;
    private long desiredRevision;
    private String desiredTarget;
    private boolean identityReady;
    private String lastSubmittedTarget;
    private final q<String, AgentOperationStatus, Throwable, x> onSinkFailure;
    private final List<Long> retryDelaysMillis;
    private final m<Long, a<x>, x> scheduleRetry;
    private final m<String, AgentOperationStatus, x> sink;

    /* JADX INFO: compiled from: AgentOperationTargetDispatcher.kt */
    private static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }

        public final List<Long> getDEFAULT_RETRY_DELAYS_MILLIS() {
            return AgentOperationTargetDispatcher.access$getDEFAULT_RETRY_DELAYS_MILLIS$cp();
        }
    }

    public static /* synthetic */ x lambda$4FhDiAd5FQca7WZlrwhQoYDVgCQ(AgentOperationTargetDispatcher r0, String r1, long r2, int r4) {
        return scheduleRetryIfStillDesired$lambda$5$lambda$4(r0, r1, r2, r4);
    }

    public AgentOperationTargetDispatcher(m<? super String, ? super AgentOperationStatus, x> r3, q<? super String, ? super AgentOperationStatus, ? super Throwable, x> r4, m<? super Long, ? super a<x>, x> r5, List<Long> r6) {
        m<String, AgentOperationStatus, x> r7 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
        q<String, AgentOperationStatus, Throwable, x> r8 = (q) ZeusTransformUtils.wrapperContextForParams(r4, q.class, "com.obric.aiagent.plugin");
        m<Long, a<x>, x> r9 = (m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.aiagent.plugin");
        List<Long> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        o.e(r7, "sink");
        o.e(r8, "onSinkFailure");
        o.e(r9, "scheduleRetry");
        o.e(r10, "retryDelaysMillis");
        this.sink = r7;
        this.onSinkFailure = r8;
        this.scheduleRetry = r9;
        this.retryDelaysMillis = r10;
    }

    public static final /* synthetic */ List access$getDEFAULT_RETRY_DELAYS_MILLIS$cp() {
        return DEFAULT_RETRY_DELAYS_MILLIS;
    }

    public /* synthetic */ AgentOperationTargetDispatcher(m r2, q r3, m r4, List r5, int r6, h r7) {
        m r8 = (m) ZeusTransformUtils.wrapperContextForParams(r2, m.class, "com.obric.aiagent.plugin");
        q r9 = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin");
        m r10 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin");
        List<Long> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L5;
        r11 = DEFAULT_RETRY_DELAYS_MILLIS;
    L5:
        this(r8, r9, r10, r11);
    }

    public final void onIdentityReady() {
        if (this.identityReady == false) goto L5;
        return;
    L5:
        this.identityReady = true;
        submitTarget(this.desiredTarget, this.desiredRevision, 0);
    }

    public final void updateTarget(String r5) {
        this.desiredTarget = r5;
        long r0 = this.desiredRevision + 1;
        this.desiredRevision = r0;
        if (this.identityReady == true) goto L5;
        return;
    L5:
        submitTarget(r5, r0, 0);
    }

    private final void submitTarget(String r7, long r8, int r10) {
        if (r8 == this.desiredRevision) goto L5;
        return;
    L5:
        if (o.a(r7, this.desiredTarget) == true) goto L8;
        return;
    L8:
        if (o.a(r7, this.lastSubmittedTarget) == false) goto L10;
        return;
    L10:
        if (r7 != null) goto L14;
        String r2 = this.lastSubmittedTarget;
        if (r2 != null) goto L15;
        return;
    L15:
        if (r7 != null) goto L17;
        AgentOperationStatus r3 = AgentOperationStatus.STOP;
    L35:
        n.a r4 = n.f38560a;     // Catch: Throwable -> L20
        ((AgentOperationTargetDispatcher) ZeusTransformUtils.preCheckCast(this, AgentOperationTargetDispatcher.class, "com.obric.aiagent.plugin")).sink.invoke(r2, r3);     // Catch: Throwable -> L20
        Object r5 = n.f(x.f38692a);     // Catch: Throwable -> L20
    L23:
        if (n.a(r5) == false) goto L25;
        x r6 = (x) ZeusTransformUtils.preCheckCast(r5, x.class, "com.obric.aiagent.plugin");
        this.lastSubmittedTarget = r7;
    L25:
        Throwable r9 = n.c(r5);
        if (r9 == null) goto L38;
        n.a r11 = n.f38560a;     // Catch: Throwable -> L29
        ((AgentOperationTargetDispatcher) ZeusTransformUtils.preCheckCast(this, AgentOperationTargetDispatcher.class, "com.obric.aiagent.plugin")).onSinkFailure.invoke(r2, r3, r9);     // Catch: Throwable -> L29
        n.f(x.f38692a);     // Catch: Throwable -> L29
    L31:
        scheduleRetryIfStillDesired(r7, r8, r10);
        return;
    L29:
        th = move-exception;
        n.a r1 = n.f38560a;
        n.f(d.o.a(th));
        goto L31
    L38:
        return;
    L20:
        th = move-exception;
        n.a r12 = n.f38560a;
        r5 = n.f(d.o.a(th));
        goto L23
    L17:
        r3 = AgentOperationStatus.START;
        goto L35
    L14:
        r2 = r7;
        goto L15
    }

    private final void scheduleRetryIfStillDesired(final String r12, final long r13, final int r15) {
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(p.d(this.retryDelaysMillis, r15), Long.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L28;
        long r2 = r1.longValue();
        n.a r4 = n.f38560a;     // Catch: Throwable -> L7
        final AgentOperationTargetDispatcher r6 = (AgentOperationTargetDispatcher) ZeusTransformUtils.preCheckCast(this, AgentOperationTargetDispatcher.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        r6.scheduleRetry.invoke(Long.valueOf(r2), new $$Lambda$AgentOperationTargetDispatcher$4FhDiAd5FQca7WZlrwhQoYDVgCQ(r6, r12, r13, r15));     // Catch: Throwable -> L7
        Object r14 = n.f(x.f38692a);     // Catch: Throwable -> L7
    L9:
        Throwable r16 = n.c(r14);
        if (r16 == null) goto L29;
        if (r12 != null) goto L15;
        String r17 = this.lastSubmittedTarget;
        if (r17 == null) goto L30;
    L16:
        if (r12 != null) goto L18;
        AgentOperationStatus r18 = AgentOperationStatus.STOP;
    L26:
        n.a r19 = n.f38560a;     // Catch: Throwable -> L21
        ((AgentOperationTargetDispatcher) ZeusTransformUtils.preCheckCast(this, AgentOperationTargetDispatcher.class, "com.obric.aiagent.plugin")).onSinkFailure.invoke(r17, r18, r16);     // Catch: Throwable -> L21
        n.f(x.f38692a);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        n.a r110 = n.f38560a;
        n.f(d.o.a(th));
        return;
    L18:
        r18 = AgentOperationStatus.START;
        goto L26
    L30:
        return;
    L15:
        r17 = r12;
        goto L16
    L29:
        return;
    L7:
        th = move-exception;
        n.a r111 = n.f38560a;
        r14 = n.f(d.o.a(th));
        goto L9
    }

    private static final x scheduleRetryIfStillDesired$lambda$5$lambda$4(AgentOperationTargetDispatcher r0, String r1, long r2, int r4) {
        r0.submitTarget(r1, r2, r4 + 1);
        return x.f38692a;
    }

    static {
        Companion = new Companion(null);
        DEFAULT_RETRY_DELAYS_MILLIS = p.b(new Long[]{200L, 1000L});
    }
}
