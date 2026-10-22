package com.bytedance.android.live.liveinteract.videotalk;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class j0 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k0 f79457a;

    public j0(k0 r100) {
        this.f79457a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationEnd(r100);
        this.f79457a.b();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationStart(r100);
        k0 r101 = this.f79457a;
        View r102 = r101.f70875g;
        float[] r103 = new float[2];
        if (r101.B == false) goto L5;
        float r104 = 1.0f;
    L6:
        r103[0] = r104;
        r103[1] = 0.0f;
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r102, "alpha", r103);
        r105.setDuration(300);
        ((ArrayList) this.f79457a.f70877i).add(r105);
        Unit r106 = Unit.INSTANCE;
        r101.R = r105;
        ObjectAnimator r107 = this.f79457a.R;
        if (r107 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("buttonBgAlphaGone");
    L9:
        r107.start();
        k0 r108 = this.f79457a;
        if (r108.B == false) goto L13;
        r108.f70885q.start();
        return;
    L13:
        return;
    L5:
        r104 = 0.15f;
        goto L6
    }
}
