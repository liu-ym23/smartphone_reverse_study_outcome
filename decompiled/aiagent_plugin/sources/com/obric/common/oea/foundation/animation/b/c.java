package com.obric.common.oea.foundation.animation.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: IntAnimationValueCalculator.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c implements a<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f32322a = null;

    static {
        f32322a = new c();
    }

    private c() {
    }

    @Override // com.obric.common.oea.foundation.animation.b.a
    public /* synthetic */ Integer a(long r10, Integer r12, Integer r13, float r14, com.obric.common.oea.foundation.animation.g.a<Integer> r15) {
        com.obric.common.oea.foundation.animation.g.a<Integer> r8 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r15, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
        return a(r10, ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.aiagent.plugin")).intValue(), r14, r8);
    }

    @Override // com.obric.common.oea.foundation.animation.b.a
    public /* synthetic */ float b(long r10, Integer r12, Integer r13, float r14, com.obric.common.oea.foundation.animation.g.a<Integer> r15) {
        com.obric.common.oea.foundation.animation.g.a<Integer> r8 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r15, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
        return b(r10, ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.aiagent.plugin")).intValue(), r14, r8);
    }

    public Integer a(long r8, int r10, int r11, float r12, com.obric.common.oea.foundation.animation.g.a<Integer> r13) {
        com.obric.common.oea.foundation.animation.g.a r1 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r13, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
        o.e(r1, "spec");
        return (Integer) ZeusTransformUtils.preCheckCast(r1.a(r8, Integer.valueOf(r10), Integer.valueOf(r11), r12), Integer.class, "com.obric.aiagent.plugin");
    }

    public float b(long r7, int r9, int r10, float r11, com.obric.common.oea.foundation.animation.g.a<Integer> r12) {
        com.obric.common.oea.foundation.animation.g.a r0 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r12, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
        o.e(r0, "spec");
        return r0.b(r7, Integer.valueOf(r9), Integer.valueOf(r10), r11);
    }

    @Override // com.obric.common.oea.foundation.animation.b.a
    public boolean a(long r2, long r4, com.obric.common.oea.foundation.animation.g.a<Integer> r6) {
        com.obric.common.oea.foundation.animation.g.a r1 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
        o.e(r1, "spec");
        return r1.a(r2, r4);
    }
}
