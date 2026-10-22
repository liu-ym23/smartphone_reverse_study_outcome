package com.obric.autoaction.presentation.function.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.x;

/* JADX INFO: compiled from: CallUserAutoResumeJob.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.obric.autoaction.presentation.function.a.b {
    public a() {
        super("CallUser", 8000);
    }

    @Override // com.obric.autoaction.presentation.function.a.b
    public Object a(d<? super x> r2) {
        d r1 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.presentation.function.a r3 = com.obric.autoaction.presentation.function.b.f24937a.b("CallUser");
        if (r3 == null) goto L6;
        r3.e();
    L6:
        return x.f38692a;
    }
}
