package com.obric.common.oea.foundation.animation.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: FloatAnimationValueCalculator.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements a<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f32321a = null;

    static {
        f32321a = new b();
    }

    private b() {
    }

    @Override // com.obric.common.oea.foundation.animation.b.a
    public /* synthetic */ Float a(long r10, Float r12, Float r13, float r14, com.obric.common.oea.foundation.animation.g.a<Float> r15) {
        com.obric.common.oea.foundation.animation.g.a<Float> r8 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r15, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
        return a(r10, ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.aiagent.plugin")).floatValue(), r14, r8);
    }

    @Override // com.obric.common.oea.foundation.animation.b.a
    public /* synthetic */ float b(long r10, Float r12, Float r13, float r14, com.obric.common.oea.foundation.animation.g.a<Float> r15) {
        com.obric.common.oea.foundation.animation.g.a<Float> r8 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r15, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
        return b(r10, ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.aiagent.plugin")).floatValue(), r14, r8);
    }

    public Float a(long r8, float r10, float r11, float r12, com.obric.common.oea.foundation.animation.g.a<Float> r13) {
        com.obric.common.oea.foundation.animation.g.a r1 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r13, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
        o.e(r1, "spec");
        return (Float) ZeusTransformUtils.preCheckCast(r1.a(r8, Float.valueOf(r10), Float.valueOf(r11), r12), Float.class, "com.obric.aiagent.plugin");
    }

    public float b(long r7, float r9, float r10, float r11, com.obric.common.oea.foundation.animation.g.a<Float> r12) {
        com.obric.common.oea.foundation.animation.g.a r0 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r12, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
        o.e(r0, "spec");
        return r0.b(r7, Float.valueOf(r9), Float.valueOf(r10), r11);
    }

    @Override // com.obric.common.oea.foundation.animation.b.a
    public boolean a(long r2, long r4, com.obric.common.oea.foundation.animation.g.a<Float> r6) {
        com.obric.common.oea.foundation.animation.g.a r1 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
        o.e(r1, "spec");
        return r1.a(r2, r4);
    }
}
