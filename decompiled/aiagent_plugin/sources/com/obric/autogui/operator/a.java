package com.obric.autogui.operator;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AOEndStep.kt */
/* JADX INFO: loaded from: classes3.dex */
public class a extends e implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29251a;

    @Override // com.obric.autogui.operator.e
    public Object a(b r3, d.c.d<? super c> r4) {
        return a(this, r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.operator.e
    public Object c(com.obric.autogui.session.a r3, d.c.d<? super g> r4) {
        return a(this, r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public a() {
        this.f29251a = "End";
    }

    @Override // com.obric.autogui.operator.e
    public void a_(String r2) {
        d.h.b.o.e(r2, "<set-?>");
        this.f29251a = r2;
    }

    @Override // com.obric.autogui.operator.e
    public String k_() {
        return this.f29251a;
    }

    static /* synthetic */ Object a(a r0, com.obric.autogui.session.a r1, d.c.d<? super g> r2) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
        return new g.d("");
    }

    static /* synthetic */ Object a(a r0, b r1, d.c.d<? super c> r2) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
        return c.f29874a.a();
    }
}
