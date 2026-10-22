package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.topViewModel;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.revenue.common.i;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.AnimMoveType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<View, AnimatorSet> f129005a;

    public static final class a {
    }

    public static final class b extends o12.b {
        @Override // o12.b, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public b() {
        }
    }

    static {
    }

    public final void a() {
        Iterator r100 = ((LinkedHashMap) this.f129005a).entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((AnimatorSet) ((Map.Entry) r100.next()).getValue()).cancel();
        goto L4
    L6:
        ((LinkedHashMap) this.f129005a).clear();
    }

    public e() {
        this.f129005a = new LinkedHashMap();
    }

    public final void b(View r100) {
        AnimatorSet r101 = (AnimatorSet) ((LinkedHashMap) this.f129005a).get(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isRunning() != true) goto L11;
        AnimatorSet r102 = (AnimatorSet) ((LinkedHashMap) this.f129005a).get(r100);
        if (r102 == null) goto L12;
        r102.cancel();
        return;
    L12:
        return;
    }

    public final void e(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        b(r100);
        r100.setAlpha(1.0f);
        AnimatorSet r101 = new AnimatorSet();
        this.f129005a.put(r100, r101);
        r101.playTogether(new Animator[]{ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 1.1f, 1.0f}), ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 1.1f, 1.0f})});
        r101.setDuration(100);
        r101.setInterpolator(new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f));
        r101.addListener(new b());
        r101.start();
    }

    public final void c(View r100, AnimMoveType r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "animMoveType");
        b(r100);
        AnimatorSet r102 = new AnimatorSet();
        this.f129005a.put(r100, r102);
        int r103 = f.f129007b[r101.ordinal()];
        if (r103 == 1) goto L7;
        if (r103 != 2) goto L8;
        r100.setAlpha(1.0f);
        r102.playSequentially(new Animator[]{ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{i.a(5.0f), 0.0f})});
    L8:
        r102.setDuration(150);
        r102.setInterpolator(new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f));
        r102.start();
        return;
    L7:
        r100.setAlpha(1.0f);
        r102.playSequentially(new Animator[]{ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{i.a(-5.0f), 0.0f})});
        goto L8
    }

    public final void d(View r100, AnimMoveType r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r110, "animMoveType");
        b(r100);
        AnimatorSet r101 = new AnimatorSet();
        this.f129005a.put(r100, r101);
        int r111 = f.f129006a[r110.ordinal()];
        if (r111 == 1) goto L7;
        if (r111 != 2) goto L8;
        r100.setAlpha(0.4f);
        r101.playSequentially(new Animator[]{ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f, i.a(10.0f)}), ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{i.a(10.0f), i.a(5.0f)})});
    L8:
        r101.setDuration(150);
        r101.setInterpolator(new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f));
        r101.start();
        return;
    L7:
        r100.setAlpha(0.4f);
        r101.playSequentially(new Animator[]{ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f, i.a(-10.0f)}), ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{i.a(-10.0f), i.a(-5.0f)})});
        goto L8
    }
}
