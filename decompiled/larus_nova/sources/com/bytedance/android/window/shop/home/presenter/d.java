package com.bytedance.android.window.shop.home.presenter;

import android.animation.Animator;
import android.animation.ValueAnimator;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsWindowFloatPresenter f188509a;

    public d(AbsWindowFloatPresenter r100) {
        this.f188509a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        if ((!Intrinsics.areEqual(this.f188509a.f188263h, Boolean.TRUE)) == false) goto L5;
        return;
    L5:
        if (this.f188509a.y().getVisibility() != 0) goto L20;
        Animator r102 = this.f188509a.f188264i;
        if (r102 == null) goto L10;
        r102.cancel();
    L10:
        AbsWindowFloatPresenter r103 = this.f188509a;
        float[] r104 = new float[2];
        r104[0] = r103.y().getAlpha();
        if (r101 != null) goto L14;
    L16:
        float r105 = 0.5f;
    L17:
        r104[1] = r105;
        ValueAnimator r106 = ValueAnimator.ofFloat(r104);
        r106.setDuration(300);
        r106.addUpdateListener(new c(this));
        r106.start();
        Unit r107 = Unit.INSTANCE;
        r103.f188264i = r106;
        return;
    L14:
        if (r101.intValue() != 0) goto L16;
        r105 = 1.0f;
        goto L17
    }
}
