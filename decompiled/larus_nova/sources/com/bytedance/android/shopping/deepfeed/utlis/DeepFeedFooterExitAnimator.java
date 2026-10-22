package com.bytedance.android.shopping.deepfeed.utlis;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.shopping.deepfeed.ui.DeepFeedProductRecyclerview;
import com.bytedance.android.ui.ec.widget.loading.ECDuxLoadingAnimationView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/utlis/DeepFeedFooterExitAnimator;", "Landroidx/recyclerview/widget/DefaultItemAnimator;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedFooterExitAnimator extends DefaultItemAnimator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f173960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f173961b;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.ViewHolder f173962a;

        public a(RecyclerView.ViewHolder r100) {
            this.f173962a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Object r101 = r100.getAnimatedValue();
            if (r101 == null) goto L7;
            float r102 = ((Float) r101).floatValue();
            this.f173962a.itemView.setAlpha(r102);
            this.f173962a.itemView.postInvalidate();
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DeepFeedFooterExitAnimator f173963a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.ViewHolder f173964b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f173964b.itemView.setLayerType(0, null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f173964b.itemView.setLayerType(0, null);
            this.f173963a.dispatchRemoveFinished(this.f173964b);
        }

        public b(DeepFeedFooterExitAnimator r100, RecyclerView.ViewHolder r101) {
            this.f173963a = r100;
            this.f173964b = r101;
        }
    }

    public static final class c implements RecyclerView.ItemAnimator.ItemAnimatorFinishedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DeepFeedFooterExitAnimator f173965a;

        public c(DeepFeedFooterExitAnimator r100) {
            this.f173965a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemAnimatorFinishedListener
        public final void onAnimationsFinished() {
            RecyclerView r100 = this.f173965a.f173961b;
            if (r100 == null) goto L6;
            r100.setItemAnimator(new DefaultItemAnimator());
            return;
        }
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void runPendingAnimations() {
        super.runPendingAnimations();
        isRunning(new c(this));
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean animateRemove(RecyclerView.ViewHolder r100) {
        if (r100 == null) goto L5;
        View r101 = r100.itemView;
    L6:
        if (r101 == null) goto L16;
        View r102 = r100.itemView;
        View r103 = this.f173960a;
        if (r103 == null) goto L10;
        ViewParent r104 = r103.getParent();
    L12:
        if (Intrinsics.areEqual(r102, r104) == false) goto L16;
        r100.itemView.setVisibility(0);
        r100.itemView.setAlpha(1.0f);
        r100.itemView.requestLayout();
        r100.itemView.invalidate();
        dispatchRemoveStarting(r100);
        ValueAnimator r105 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r105.setDuration(getRemoveDuration());
        r100.itemView.setLayerType(2, null);
        r105.addUpdateListener(new a(r100));
        r105.addListener(new b(this, r100));
        r105.start();
        return true;
    L10:
        r104 = null;
    L16:
        return super.animateRemove(r100);
    L5:
        r101 = null;
        goto L6
    }

    public DeepFeedFooterExitAnimator(ECDuxLoadingAnimationView r100, DeepFeedProductRecyclerview r101) {
        this.f173960a = r100;
        this.f173961b = r101;
    }
}
