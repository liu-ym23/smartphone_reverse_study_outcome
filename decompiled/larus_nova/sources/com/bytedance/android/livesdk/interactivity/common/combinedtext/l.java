package com.bytedance.android.livesdk.interactivity.common.combinedtext;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class l implements qb2.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DisplayTextView f136510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f136511b;

    @Override // qb2.e
    public final void a(ak6.g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        Intrinsics.checkNotNullParameter(r100, "rendResult");
    }

    @Override // qb2.e
    public final void b(ak6.g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        DisplayTextView.x(this.f136510a, r100.f4074a);
        DisplayTextView r101 = this.f136510a;
        k r102 = new k(this);
        int r103 = a.f136496a;
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 1.25f, 1.0f});
        r104.setDuration(150);
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 1.25f, 1.0f});
        r105.setDuration(150);
        AnimatorSet r106 = new AnimatorSet();
        r106.playTogether(new Animator[]{a.b(r101, null), r104, r105});
        r106.setDuration(300);
        r106.addListener(new d(r102));
        r106.start();
    }

    public l(DisplayTextView r100, n r101) {
        this.f136510a = r100;
        this.f136511b = r101;
    }
}
