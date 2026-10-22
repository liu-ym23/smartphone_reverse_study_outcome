package com.bytedance.android.live.profit.livepet.utils;

import android.animation.Animator;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.revenue.common.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f87920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DebugModeKt$enableLivePetDebugView$8.c f87921b;

    @Override // com.bytedance.android.live.revenue.common.f, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f87921b.f87914a.$petContainer.removeView(this.f87920a);
    }

    public b(View r100, DebugModeKt$enableLivePetDebugView$8.c r101) {
        this.f87920a = r100;
        this.f87921b = r101;
    }
}
