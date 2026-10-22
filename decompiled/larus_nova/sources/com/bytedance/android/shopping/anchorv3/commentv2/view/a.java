package com.bytedance.android.shopping.anchorv3.commentv2.view;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes12.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentExpandableTextView f164756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f164757b;

    public a(CommentExpandableTextView r100, Function0 r101) {
        this.f164756a = r100;
        this.f164757b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Object r101 = r100.getAnimatedValue();
        if ((r101 instanceof Integer) == true) goto L5;
        r101 = null;
    L5:
        Integer r102 = (Integer) r101;
        if (r102 == null) goto L9;
        ViewGroup.LayoutParams r103 = this.f164756a.getLayoutParams();
        r103.height = r102.intValue();
        this.f164756a.setLayoutParams(r103);
        return;
    }
}
