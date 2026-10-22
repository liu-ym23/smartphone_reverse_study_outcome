package com.obric.autogui.agents.a.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;

/* JADX INFO: compiled from: ActionEffectActionHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.autogui.operator.b.EnumC0777b f26173a;

    public Object a(d r3, com.obric.autogui.operator.e.C0780e r4, com.obric.autogui.operator.b r5, d.c.d<? super x> r6) {
        return a(this, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin"), r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public void a(d r2, com.obric.autogui.operator.e.C0780e r3, com.obric.autogui.operator.c r4) {
        d r1 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.c r5 = (com.obric.autogui.operator.c) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autogui.operator.c.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "scope");
        d.h.b.o.e(r3, "operation");
        d.h.b.o.e(r5, "result");
    }

    public abstract a b();

    public void b(d r2, com.obric.autogui.operator.e.C0780e r3, com.obric.autogui.operator.c r4) {
        d r1 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.c r5 = (com.obric.autogui.operator.c) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autogui.operator.c.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "scope");
        d.h.b.o.e(r3, "operation");
        d.h.b.o.e(r5, "result");
    }

    public boolean b(d r2) {
        d.h.b.o.e((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin"), "scope");
        return true;
    }

    public b(com.obric.autogui.operator.b.EnumC0777b r2) {
        d.h.b.o.e(r2, "primaryOperationType");
        this.f26173a = r2;
    }

    public final com.obric.autogui.operator.b.EnumC0777b a() {
        return this.f26173a;
    }

    static /* synthetic */ Object a(b r0, d r1, com.obric.autogui.operator.e.C0780e r2, com.obric.autogui.operator.b r3, d.c.d<? super x> r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r1, d.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return x.f38692a;
    }

    public e a(d r8) {
        d.h.b.o.e((d) ZeusTransformUtils.wrapperContextForParams(r8, d.class, "com.obric.aiagent.plugin"), "scope");
        return new e(null, null, 0, 7, null);
    }
}
