package com.bytedance.android.livesdk.chatroom.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.common.utility.UIUtils;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class y extends BaseAnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z f119260a;

    public y(z r100) {
        this.f119260a = r100;
    }

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationStart(AnimatedDrawable2 r110) {
        FansRankListAnimationWidget r111 = this.f119260a.f119265a;
        TextView r100 = r111.f118493d;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAwardTextView");
    L5:
        UIUtils.setViewVisibility(r100, 0);
        r111.f118500k = new ArrayList();
        TextView r101 = r111.f118493d;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mAwardTextView");
    L8:
        r101.setText(r111.f118501l);
        TextView r102 = r111.f118493d;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mAwardTextView");
    L11:
        r102.setAlpha(0.0f);
        TextView r103 = r111.f118493d;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mAwardTextView");
    L14:
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r103, "alpha", new float[]{0.0f, 1.0f});
        if (r104 != null) goto L17;
    L21:
        TextView r105 = r111.f118493d;
        if (r105 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mAwardTextView");
    L24:
        ObjectAnimator r106 = ObjectAnimator.ofFloat(r105, "alpha", new float[]{1.0f, 0.0f});
        if (r106 == null) goto L27;
        r106.setStartDelay(3300);
        r106.setDuration(700);
    L27:
        RelativeLayout r107 = r111.f118492c;
        if (r107 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mRankListAwardAnimationContainer");
    L30:
        ObjectAnimator r108 = ObjectAnimator.ofFloat(r107, "alpha", new float[]{1.0f, 0.0f});
        if (r108 == null) goto L33;
        r108.setStartDelay(3300);
        r108.setDuration(700);
    L33:
        AnimatorSet r109 = new AnimatorSet();
        r109.playTogether(new Animator[]{r104, r106, r108});
        r109.start();
        ArrayList<Animator> r112 = r111.f118500k;
        if (r112 == null) goto L36;
        r112.add(r109);
    L36:
        com.bytedance.android.livesdk.log.u.l().b("livesdk_fansranklist_endanimation_show");
        return;
    L17:
        if (tb1.c.f545229a == false) goto L19;
        long r113 = 1300;
    L20:
        r104.setStartDelay(r113);
        r104.setDuration(200);
        goto L21
    L19:
        r113 = 1000;
        goto L20
    }
}
