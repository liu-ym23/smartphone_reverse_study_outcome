package com.bytedance.android.live.liveinteract.plantform.commonwindow;

import android.animation.ValueAnimator;
import android.graphics.PathMeasure;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonDynamicIslandLayoutManager f75626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PathMeasure f75627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f75628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Integer f75629d;

    public b(CommonDynamicIslandLayoutManager r100, PathMeasure r101, View r102, Integer r103) {
        this.f75626a = r100;
        this.f75627b = r101;
        this.f75628c = r102;
        this.f75629d = r103;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L7;
        float[] r102 = new float[2];
        this.f75627b.getPosTan(((Float) r101).floatValue(), r102, null);
        View r103 = this.f75628c;
        Float r104 = this.f75626a.q(Float.valueOf(r102[0]), this.f75628c);
        Intrinsics.checkNotNull(r104);
        r103.setX(r104.floatValue());
        View r105 = this.f75628c;
        Float r106 = CommonDynamicIslandLayoutManager.r(this.f75626a, Float.valueOf(r102[1]), this.f75628c);
        Intrinsics.checkNotNull(r106);
        r105.setY(r106.floatValue());
        ALogger.i(this.f75626a.f75553a, "bezier update to(" + this.f75628c.getX() + ',' + this.f75628c.getY() + "), pos=" + this.f75629d);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
