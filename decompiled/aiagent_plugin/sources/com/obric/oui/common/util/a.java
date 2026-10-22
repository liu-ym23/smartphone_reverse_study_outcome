package com.obric.oui.common.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OAnimationAccuracy.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static final com.obric.common.oea.foundation.animation.g.a<Float> a(com.obric.common.oea.foundation.animation.g.a<Float> r2, float r3) {
        com.obric.common.oea.foundation.animation.g.a<Float> r4 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "<this>");
        if (ZeusTransformUtils.instanceOf(r4, com.obric.common.oea.foundation.animation.g.a.b.class) == false) goto L5;
        ((com.obric.common.oea.foundation.animation.g.a.b) ZeusTransformUtils.preCheckCast(r4, com.obric.common.oea.foundation.animation.g.a.b.class, "com.obric.aiagent.plugin")).a(r3);
    L5:
        return r4;
    }
}
