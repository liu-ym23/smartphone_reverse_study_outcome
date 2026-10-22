package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import android.animation.ValueAnimator;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class u implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f86690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f86691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f86692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f86693d;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Object r101 = r100.getAnimatedValue();
        if ((r101 instanceof Float) == true) goto L5;
        r101 = null;
    L5:
        Float r102 = (Float) r101;
        if (r102 == null) goto L9;
        float r103 = r102.floatValue();
        View r104 = this.f86693d;
        r104.setTranslationX(r104.getTranslationX() - (r103 - this.f86690a));
        this.f86690a = r103;
        return;
    }

    public u(View r100, List r101, View r102) {
        this.f86691b = r100;
        this.f86692c = r101;
        this.f86693d = r102;
    }
}
