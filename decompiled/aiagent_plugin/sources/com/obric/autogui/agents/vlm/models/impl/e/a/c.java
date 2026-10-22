package com.obric.autogui.agents.vlm.models.impl.e.a;

import com.obric.autogui.agents.vlm.models.impl.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.o;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: OperationExecutor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements b {

    /* JADX INFO: compiled from: OperationExecutor.kt */
    @d.c.b.a.f(b = "OperationExecutor.kt", c = {74}, d = "run", e = "com.obric.autogui.agents.vlm.models.impl.script.execution.OperationExecutorImpl")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27805b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27806c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f27807d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f27808e;
        /* synthetic */ Object f;
        final /* synthetic */ c g;
        int h;

        a(c r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return this.g.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public c() {
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x010e -> B:25:0x0113). Please report as a decompilation issue!!! */
    @Override // com.obric.autogui.agents.vlm.models.impl.e.a.b
    public Object a(List<com.obric.autogui.operator.e.C0780e> r18, m<? super com.obric.autogui.operator.b, ? super d.c.d<? super com.obric.autogui.operator.c>, ? extends Object> r19, d.h.a.a<l> r20, d.c.d<? super com.obric.autogui.agents.vlm.models.impl.e.a.a> r21) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
        m r2 = (m) ZeusTransformUtils.wrapperContextForParams(r19, m.class, "com.obric.aiagent.plugin");
        d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r20, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, a.class) == false) goto L7;
        a r5 = (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin");
        if ((r5.h & Integer.MIN_VALUE) == 0) goto L7;
        r5.h -= Integer.MIN_VALUE;
    L8:
        Object r6 = r5.f;
        Object r7 = d.c.a.b.a();
        int r8 = r5.h;
        if (r8 == 0) goto L14;
        if (r8 != 1) goto L13;
        int r1 = r5.f27808e;
        com.obric.autogui.operator.e.C0780e r9 = (com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r5.f27807d, com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin");
        Iterator r10 = (Iterator) ZeusTransformUtils.preCheckCast(r5.f27806c, Iterator.class, "com.obric.aiagent.plugin");
        d.h.a.a r11 = (d.h.a.a) ZeusTransformUtils.preCheckCast(r5.f27805b, d.h.a.a.class, "com.obric.aiagent.plugin");
        m r12 = (m) ZeusTransformUtils.preCheckCast(r5.f27804a, m.class, "com.obric.aiagent.plugin");
        o.a(r6);
    L26:
        if (((com.obric.autogui.operator.c) ZeusTransformUtils.preCheckCast(r6, com.obric.autogui.operator.c.class, "com.obric.aiagent.plugin")).a() == true) goto L28;
        int r13 = r1 + 1;
        d.h.a.a r14 = r11;
        r2 = r12;
    L16:
        if (r10.hasNext() == false) goto L31;
        com.obric.autogui.operator.e.C0780e r15 = (com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r10.next(), com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.b r16 = r15.a().a().a(r15.b());
        if (r16 == null) goto L20;
        r16.a((com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r14.invoke(), com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin"));
        r5.f27804a = r2;
        r5.f27805b = r14;
        r5.f27806c = r10;
        r5.f27807d = r15;
        r5.f27808e = r13;
        r5.h = 1;
        Object r17 = r2.invoke(r16, r5);
        if (r17 != r7) goto L24;
        return r7;
    L24:
        r12 = r2;
        r9 = r15;
        r6 = r17;
        r11 = r14;
        r1 = r13;
        goto L26
    L20:
        return new com.obric.autogui.agents.vlm.models.impl.e.a.a(false, r13, new f("create_operator_failed", r15.a(), "create operator failed, " + r15.a()));
    L31:
        return new com.obric.autogui.agents.vlm.models.impl.e.a.a(true, r13, null, 4, null);
    L28:
        return new com.obric.autogui.agents.vlm.models.impl.e.a.a(false, r1, new f("operation_execution_failed", r9.a(), "operation execution failed," + r9.a()));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r6);
        r13 = 0;
        r10 = r0.iterator();
        r14 = r3;
    L7:
        r5 = new a(this, r4);
        goto L8
    }
}
