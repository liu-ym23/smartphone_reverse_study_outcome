package com.obric.common.oea.style.scene.qsanim.morph;

import android.animation.ValueAnimator;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.util.Objects;

/* JADX INFO: compiled from: ViewMorphAnimHelperEx.kt */
/* JADX INFO: loaded from: classes4.dex */
final class ViewMorphAnimHelperEx$Companion$getFloatAnimator$$inlined$apply$lambda$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ d.h.a.b $updateAction$inlined;

    ViewMorphAnimHelperEx$Companion$getFloatAnimator$$inlined$apply$lambda$1(d.h.a.b r3) {
        this.$updateAction$inlined = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        o.e(r3, "animation");
        Object r4 = r3.getAnimatedValue();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type kotlin.Float");
        float r5 = ((Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.aiagent.plugin")).floatValue();
        d.h.a.b r2 = this.$updateAction$inlined;
        if (r2 == null) goto L6;
        x r6 = (x) ZeusTransformUtils.preCheckCast(r2.invoke(Float.valueOf(r5)), x.class, "com.obric.aiagent.plugin");
        return;
    }
}
