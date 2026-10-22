package com.obric.autogui.agents.vlm.models.impl;

import com.obric.autogui.agents.vlm.models.omni.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;

/* JADX INFO: compiled from: StandardModelAdjustCallUserStep.kt */
/* JADX INFO: loaded from: classes3.dex */
public class f extends h {
    /* JADX INFO: renamed from: lambda$Ugos-pUO4eaYFn5TyQUtNowsJQ4, reason: not valid java name */
    public static /* synthetic */ x m757lambda$UgospUO4eaYFn5TyQUtNowsJQ4(f r0, r r1) {
        return a(r0, r1);
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.h, com.obric.autogui.agents.vlm.models.impl.e, com.obric.autogui.agents.vlm.models.impl.g
    public Object a(com.obric.autogui.session.a r3, d.c.d<? super com.obric.autogui.operator.g> r4) {
        return a(this, r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public f() {
    }

    static /* synthetic */ Object a(final f r2, com.obric.autogui.session.a r3, d.c.d<? super com.obric.autogui.operator.g> r4) {
        d.c.d<? super com.obric.autogui.operator.g> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        r3.a(new $$Lambda$f$UgospUO4eaYFn5TyQUtNowsJQ4(r2));
        return super.a(r3, r5);
    }

    private static final x a(f r2, r r3) {
        d.h.b.o.e(r3, "it");
        String r0 = r2.E();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r4 = r2.F();
        if (r4 == null) goto L9;
        r1 = r4;
    L9:
        r3.b(r0, d.a.p.a(r1));
        return x.f38692a;
    }
}
