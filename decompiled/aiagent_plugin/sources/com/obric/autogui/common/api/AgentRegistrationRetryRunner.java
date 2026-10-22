package com.obric.autogui.common.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.d;
import d.h.a.m;
import d.h.b.o;
import d.l.n;
import d.x;

/* JADX INFO: compiled from: AgentRegistrationRetryRunner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AgentRegistrationRetryRunner {
    private final m<Long, d<? super x>, Object> delayMillis;
    private final long initialRetryDelayMillis;
    private final int maxAttempts;
    private final long maxRetryDelayMillis;

    /* JADX INFO: renamed from: com.obric.autogui.common.api.AgentRegistrationRetryRunner$run$1, reason: invalid class name */
    /* JADX INFO: compiled from: AgentRegistrationRetryRunner.kt */
    @f(b = "AgentRegistrationRetryRunner.kt", c = {24, 28}, d = "run", e = "com.obric.autogui.common.api.AgentRegistrationRetryRunner")
    static final class AnonymousClass1 extends d.c.b.a.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AgentRegistrationRetryRunner this$0;

        AnonymousClass1(AgentRegistrationRetryRunner r3, d<? super AnonymousClass1> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.run(null, (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin"));
        }
    }

    public AgentRegistrationRetryRunner(int r4, long r5, long r7, m<? super Long, ? super d<? super x>, ? extends Object> r9) {
        m<Long, d<? super x>, Object> r10 = (m) ZeusTransformUtils.wrapperContextForParams(r9, m.class, "com.obric.aiagent.plugin");
        o.e(r10, "delayMillis");
        this.maxAttempts = r4;
        this.initialRetryDelayMillis = r5;
        this.maxRetryDelayMillis = r7;
        this.delayMillis = r10;
        boolean r3 = true;
        if (r4 <= 0) goto L5;
        boolean r6 = true;
    L7:
        if (r6 == false) goto L24;
        if (r5 <= 0) goto L11;
        boolean r8 = true;
    L12:
        if (r8 == false) goto L22;
        if (r7 >= r5) goto L17;
        r3 = false;
    L17:
        if (r3 == false) goto L20;
        return;
    L20:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L22:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L11:
        r8 = false;
        goto L12
    L24:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r6 = false;
        goto L7
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00bb -> B:32:0x00d8). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00d5 -> B:32:0x00d8). Please report as a decompilation issue!!! */
    public final Object run(m<? super Integer, ? super d<? super Boolean>, ? extends Object> r11, d<? super Boolean> r12) {
        m r13 = (m) ZeusTransformUtils.wrapperContextForParams(r11, m.class, "com.obric.aiagent.plugin");
        d r14 = (d) ZeusTransformUtils.wrapperContextForParams(r12, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r1 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r14, AnonymousClass1.class, "com.obric.aiagent.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r15 = r1.result;
        Object r3 = b.a();
        int r4 = r1.label;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        int r10 = r1.I$1;
        int r16 = r1.I$0;
        m r5 = (m) ZeusTransformUtils.preCheckCast(r1.L$1, m.class, "com.obric.aiagent.plugin");
        AgentRegistrationRetryRunner r0 = (AgentRegistrationRetryRunner) ZeusTransformUtils.preCheckCast(r1.L$0, AgentRegistrationRetryRunner.class, "com.obric.aiagent.plugin");
        d.o.a(r15);
    L32:
        int r17 = r10;
        AgentRegistrationRetryRunner this = r0;
        if (r16 == r17) goto L36;
        int r2 = r16 + 1;
        r13 = r5;
    L19:
        Integer r6 = d.c.b.a.b.a(r2);
        r1.L$0 = this;
        r1.L$1 = r13;
        r1.I$0 = r2;
        r1.I$1 = r17;
        r1.label = 1;
        Object r7 = r13.invoke(r6, r1);
        if (r7 != r3) goto L22;
        return r3;
    L22:
        int r9 = r2;
        r0 = this;
        r10 = r17;
        r15 = r7;
        r5 = r13;
        r16 = r9;
    L24:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L28;
        return d.c.b.a.b.a(true);
    L28:
        if (r16 >= r0.maxAttempts) goto L32;
        m<Long, d<? super x>, Object> r18 = r0.delayMillis;
        Long r8 = d.c.b.a.b.a(r0.retryDelayAfter(r16));
        r1.L$0 = r0;
        r1.L$1 = r5;
        r1.I$0 = r16;
        r1.I$1 = r10;
        r1.label = 2;
        if (r18.invoke(r8, r1) != r3) goto L32;
        return r3;
    L36:
        return d.c.b.a.b.a(false);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r10 = r1.I$1;
        r16 = r1.I$0;
        r5 = (m) ZeusTransformUtils.preCheckCast(r1.L$1, m.class, "com.obric.aiagent.plugin");
        r0 = (AgentRegistrationRetryRunner) ZeusTransformUtils.preCheckCast(r1.L$0, AgentRegistrationRetryRunner.class, "com.obric.aiagent.plugin");
        d.o.a(r15);
        goto L24
    L16:
        d.o.a(r15);
        r17 = this.maxAttempts;
        if (1 > r17) goto L36;
        r2 = 1;
    L7:
        r1 = new AnonymousClass1(this, r14);
        goto L8
    }

    private final long retryDelayAfter(int r10) {
        long r0 = this.initialRetryDelayMillis;
        int r11 = r10 - 1;
        int r2 = 0;
    L3:
        if (r2 >= r11) goto L10;
        long r3 = this.maxRetryDelayMillis;
        long r5 = 2;
        if (r0 < (r3 / r5)) goto L7;
        r0 = r3;
    L8:
        r2 = r2 + 1;
        goto L3
    L7:
        r0 = r0 * r5;
        goto L8
    L10:
        return n.b(r0, this.maxRetryDelayMillis);
    }
}
