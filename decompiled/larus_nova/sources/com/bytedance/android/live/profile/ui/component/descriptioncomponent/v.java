package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import android.animation.ValueAnimator;
import android.view.View;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class v implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f86694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f86695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f86696c;

    public v(View r100, List r101, View r102) {
        this.f86694a = r100;
        this.f86695b = r101;
        this.f86696c = r102;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Object r101 = r100.getAnimatedValue();
        if ((r101 instanceof Float) == true) goto L5;
        r101 = null;
    L5:
        Float r102 = (Float) r101;
        if (r102 == null) goto L9;
        float r103 = r102.floatValue();
        this.f86694a.setAlpha(r103);
        return;
    }
}
