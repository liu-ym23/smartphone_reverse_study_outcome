package com.obric.autogui.agents.scripted;

import com.obric.autogui.agents.scripted.a.d;
import com.obric.autogui.agents.scripted.a.k;
import com.obric.autogui.common.AutoOperateTask;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.operator.e;
import com.obric.autogui.operator.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: ScriptedAgent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.obric.autogui.agents.a {

    /* JADX INFO: renamed from: com.obric.autogui.agents.scripted.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ScriptedAgent.kt */
    public static final class C0675a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f26849a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private d f26850b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f26851c;

        public C0675a() {
            this.f26849a = "";
        }

        public final void a(String r2) {
            o.e(r2, "<set-?>");
            this.f26849a = r2;
        }

        public final d a() {
            return this.f26850b;
        }

        public final void a(d r3) {
            this.f26850b = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        }

        public final void a(int r1) {
            this.f26851c = r1;
        }

        public final int b() {
            return this.f26851c;
        }
    }

    @Override // com.obric.autogui.agents.a
    public Object a(com.obric.autogui.session.a r1, e r2, g r3, d.c.d<? super g> r4) {
        g r0 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.aiagent.plugin");
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return r0;
    }

    public a() {
        super(com.obric.autogui.agents.a.EnumC0655a.f26119a);
    }

    private final C0675a c(com.obric.autogui.session.a r3) {
        Object r2 = r3.a((com.obric.autogui.agents.a) ZeusTransformUtils.preCheckCast(this, com.obric.autogui.agents.a.class, "com.obric.aiagent.plugin"));
        o.a(r2, "null cannot be cast to non-null type com.obric.autogui.agents.scripted.ScriptedAgent.MySession");
        return (C0675a) ZeusTransformUtils.preCheckCast(r2, C0675a.class, "com.obric.aiagent.plugin");
    }

    private final boolean a(AutoOperateTask r2) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r2.getScriptedTask(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        return !r3;
    L5:
        if (d.o.o.d(r1) == true) goto L8;
        r3 = false;
        goto L10
    }

    @Override // com.obric.autogui.agents.a
    public Object a(com.obric.autogui.session.a r4, d.c.d<? super com.obric.autogui.common.e> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        String r7 = LogUtil.INSTANCE.getCLAZZ_TAG(this);
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L6;
        Loog.INSTANCE.d(r7, "script-agent initialized with session");
    L6:
        if (a(r4.l()) == false) goto L8;
        C0675a r8 = new C0675a();
        String r0 = r4.l().getScriptedTask();
        if (r0 != null) goto L12;
        r0 = "";
    L12:
        r8.a(r0);
        r8.a((d) ZeusTransformUtils.preCheckCast(new k(), d.class, "com.obric.aiagent.plugin"));
        r4.a((com.obric.autogui.agents.a) ZeusTransformUtils.preCheckCast(this, com.obric.autogui.agents.a.class, "com.obric.aiagent.plugin"), r8);
        return com.obric.autogui.common.e.f29014b.a();
    L8:
        return com.obric.autogui.common.e.f29014b.b("task is not operated by script.");
    }

    @Override // com.obric.autogui.agents.a
    public Object b(com.obric.autogui.session.a r2, com.obric.autogui.agents.a.d r3, d.c.d<? super com.obric.autogui.common.d<e>> r4) {
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        C0675a r1 = c(r2);
        d r6 = r1.a();
        if (r6 == null) goto L5;
        int r7 = r1.b();
        r1.a(r7 + 1);
        e r8 = r6.a(r7);
        if (r8 != null) goto L11;
        return com.obric.autogui.common.d.f29012a.a("the step $(i=" + r7 + ") cannot be loaded.");
    L11:
        return com.obric.autogui.common.d.f29012a.a(r8);
    L5:
        return com.obric.autogui.common.d.f29012a.a("script is not loaded.");
    }

    @Override // com.obric.autogui.agents.a
    public Object a(com.obric.autogui.session.a r1, e r2, d.c.d<? super x> r3) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        return x.f38692a;
    }
}
