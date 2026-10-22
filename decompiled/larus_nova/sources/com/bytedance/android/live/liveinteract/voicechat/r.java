package com.bytedance.android.live.liveinteract.voicechat;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class r extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f80455a;

    public r(s r100) {
        this.f80455a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationEnd(r100);
        this.f80455a.b();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationStart(r100);
        s r101 = this.f80455a;
        View r102 = r101.f70875g;
        float[] r103 = new float[2];
        if (r101.B == false) goto L5;
        float r104 = 1.0f;
    L6:
        r103[0] = r104;
        r103[1] = 0.0f;
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r102, "alpha", r103);
        r105.setDuration(300);
        ((ArrayList) this.f80455a.f70877i).add(r105);
        Unit r106 = Unit.INSTANCE;
        r101.R = r105;
        s r107 = this.f80455a;
        if (r107.C.getVisibility() != 0) goto L9;
        Object r108 = this.f80455a.C;
    L10:
        ObjectAnimator r109 = ObjectAnimator.ofFloat(r108, "alpha", new float[]{0.0f, 1.0f});
        r109.setDuration(300);
        ((ArrayList) this.f80455a.f70877i).add(r109);
        r107.S = r109;
        ObjectAnimator r110 = this.f80455a.R;
        if (r110 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("buttonBgAlphaGone");
    L13:
        r110.start();
        ObjectAnimator r111 = this.f80455a.S;
        if (r111 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("seatInfoAlphaShow");
    L16:
        r111.start();
        s r112 = this.f80455a;
        if (r112.B == false) goto L20;
        r112.f70885q.start();
        return;
    L20:
        return;
    L9:
        r108 = this.f80455a.D;
        goto L10
    L5:
        r104 = 0.15f;
        goto L6
    }
}
