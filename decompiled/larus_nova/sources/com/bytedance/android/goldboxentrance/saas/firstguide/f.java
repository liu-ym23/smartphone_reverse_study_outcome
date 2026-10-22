package com.bytedance.android.goldboxentrance.saas.firstguide;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.animation.AccelerateInterpolator;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewBoxGuider f58159a;

    public f(NewBoxGuider r100) {
        this.f58159a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Integer r101 = (Integer) r100;
        Disposable r102 = this.f58159a.f58149l;
        if (r102 == null) goto L5;
        r102.dispose();
    L5:
        NewBoxGuider r103 = this.f58159a;
        PointF r104 = r103.f58144g;
        float r105 = 0.0f;
        if (r104 == null) goto L8;
        float r106 = r104.x - 0.0f;
    L9:
        if (r104 == null) goto L11;
        r105 = r104.y - 0.0f;
    L11:
        float r107 = 50;
        ValueAnimator r108 = ValueAnimator.ofObject(new NewBoxGuider.a(new PointF((r106 * 0.33f) + r107, 0.33f * r105), new PointF((r106 * 0.66f) + r107, r105 * 0.66f)), new Object[]{r103.f58145h, r103.f58144g});
        r108.setDuration(1000);
        r108.setInterpolator(new AccelerateInterpolator(1.5f));
        r108.addUpdateListener(new d(r103));
        r108.addListener(new e(r103));
        r103.f58148k = r108;
        Animator r109 = this.f58159a.f58148k;
        if (r109 == null) goto L14;
        r109.start();
    L14:
        a.f58155b.setValue(null, a.f58154a[0], Boolean.TRUE);
        this.f58159a.f58147j = true;
        return;
    L8:
        r106 = 0.0f;
        goto L9
    }
}
