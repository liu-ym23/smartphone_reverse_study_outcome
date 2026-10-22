package com.bytedance.android.livesdk.feedback.view.feedback;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import com.alibaba.gaiax.template.GXTemplateKey;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GlobalQuestionFeedback f124976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f124977b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationEnd(r100);
        this.f124976a.g(true);
    }

    public b(GlobalQuestionFeedback r100, ArrayList r101) {
        this.f124976a = r100;
        this.f124977b = r101;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationStart(r100, r101);
        GlobalQuestionFeedback r102 = this.f124976a;
        if (r102.f124882l == null) goto L8;
        ViewGroup r103 = r102.f124872b;
        if (r103 == null) goto L9;
        r103.setVisibility(0);
        return;
    L9:
        return;
    }
}
