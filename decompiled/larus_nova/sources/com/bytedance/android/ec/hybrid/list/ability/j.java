package com.bytedance.android.ec.hybrid.list.ability;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class j extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECMallOnceAnimator f46976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f46977b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
        this.f46977b.itemView.setTranslationY(0.0f);
        this.f46977b.itemView.setAlpha(1.0f);
        this.f46977b.itemView.setTranslationZ(1.0f);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
        this.f46977b.itemView.setTranslationZ(1.0f);
        this.f46976a.dispatchAddFinished(this.f46977b);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
        this.f46976a.dispatchAddStarting(this.f46977b);
    }

    public j(ECMallOnceAnimator r100, RecyclerView.ViewHolder r101) {
        this.f46976a = r100;
        this.f46977b = r101;
    }
}
