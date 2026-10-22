package com.bytedance.android.goldboxentrance.saas.firstguide;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.PointF;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.j;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.common.utility.UIUtils;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class e extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewBoxGuider f58158a;

    public e(NewBoxGuider r100) {
        this.f58158a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        NewBoxGuider r101 = this.f58158a;
        if (r101.f58147j == false) goto L18;
        UIUtils.setViewVisibility(r101.f58139b, 8);
        NewBoxGuider r102 = this.f58158a;
        LottieAnimationView r103 = r102.f58141d;
        if (r103 == null) goto L19;
        PointF r104 = r102.f58144g;
        float r105 = 0.0f;
        if (r104 == null) goto L9;
        float r106 = r104.x - s1.f(75.0f);
    L10:
        r103.setX(r106);
        PointF r107 = r102.f58144g;
        if (r107 == null) goto L13;
        r105 = r107.y - s1.f(90.0f);
    L13:
        r103.setY(r105);
        r103.setRotation(180.0f);
        UIUtils.setViewVisibility(r102.f58141d, 0);
        r103.setAnimation("goldcoin/ttlive_single_tap.json");
        r103.setImageAssetsFolder("goldcoin/images/");
        r103.loop(true);
        r103.playAnimation();
        Disposable r108 = r102.f58146i;
        if (r108 == null) goto L16;
        r108.dispose();
    L16:
        j.a r109 = j.f66356a;
        r102.f58146i = j.c(2200, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(r102));
        return;
    L9:
        r106 = 0.0f;
        goto L10
    L19:
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationStart(r100, r101);
        UIUtils.setViewVisibility(this.f58158a.f58139b, 0);
    }
}
