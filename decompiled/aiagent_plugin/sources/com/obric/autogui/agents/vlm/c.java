package com.obric.autogui.agents.vlm;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.c.b.a.f;
import d.h.a.m;
import d.l.n;
import d.o;
import d.x;

/* JADX INFO: compiled from: VlmAgent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: compiled from: VlmAgent.kt */
    @f(b = "VlmAgent.kt", c = {135}, d = "runAfterRecordSetPackagePublished", e = "com.obric.autogui.agents.vlm.VlmAgentKt")
    static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f27228b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f27229c;

        a(d.c.d<? super a> r3) {
            super((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            this.f27228b = r2;
            this.f27229c |= Integer.MIN_VALUE;
            return c.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final com.obric.autogui.agents.vlm.a a(int r2, int r3) {
        int r4 = n.c(r3, 1);
        if (r4 != 1) goto L6;
        r2 = 0;
    L6:
        return new com.obric.autogui.agents.vlm.a(r2, r4);
    }

    public static final Object a(String r6, m<? super String, ? super d.c.d<? super Boolean>, ? extends Object> r7, d.h.a.a<x> r8, d.c.d<? super Boolean> r9) {
        m r10 = (m) ZeusTransformUtils.wrapperContextForParams(r7, m.class, "com.obric.aiagent.plugin");
        d.h.a.a r11 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r12, a.class, "com.obric.aiagent.plugin");
        if ((r0.f27229c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f27229c -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.f27228b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f27229c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r11 = (d.h.a.a) ZeusTransformUtils.preCheckCast(r0.f27227a, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.a(r13);
    L29:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L34;
        r11.invoke();
        return d.c.b.a.b.a(true);
    L34:
        return d.c.b.a.b.a(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r13);
        if (r6 == null) goto L17;
        String r14 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L18:
        if (r14 != null) goto L21;
        r14 = "";
    L21:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L23;
        boolean r15 = true;
    L24:
        if (r15 == true) goto L34;
        r0.f27227a = r11;
        r0.f27229c = 1;
        r13 = r10.invoke(r14, r0);
        if (r13 != r2) goto L29;
        return r2;
    L23:
        r15 = false;
        goto L24
    L17:
        r14 = null;
    L7:
        r0 = new a(r12);
        goto L8
    }
}
