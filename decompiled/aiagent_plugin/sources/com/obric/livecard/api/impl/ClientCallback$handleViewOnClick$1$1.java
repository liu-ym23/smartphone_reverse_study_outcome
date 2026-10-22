package com.obric.livecard.api.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.a;
import d.h.b.p;
import d.x;

/* JADX INFO: compiled from: ClientCallback.kt */
/* JADX INFO: loaded from: classes4.dex */
final class ClientCallback$handleViewOnClick$1$1 extends p implements a<x> {
    final /* synthetic */ a<x> $clickListener;

    ClientCallback$handleViewOnClick$1$1(a<x> r3) {
        this.$clickListener = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.h.a.a
    public final x invoke() {
        a<x> r0 = this.$clickListener;
        if (r0 == null) goto L5;
        r0.invoke();
        return x.f38692a;
    L5:
        return null;
    }

    @Override // d.h.a.a
    public /* bridge */ /* synthetic */ x invoke() {
        return invoke();
    }
}
