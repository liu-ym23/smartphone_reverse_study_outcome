package com.bytedance.android.livesdk.interactivity.common.enterAnim;

import android.animation.ValueAnimator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.utils.a1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class j implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindScreenRebirthAnimTrayView f136563a;

    public j(WindScreenRebirthAnimTrayView r100) {
        this.f136563a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L7;
        float r102 = ((Float) r101).floatValue();
        a1.p(this.f136563a.f136539c, (int) r102);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
