package com.bytedance.android.ec.window.base.shop;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/ec/window/base/shop/WindowLottieAnimationViewWithPlayCount;", "Lcom/airbnb/lottie/LottieAnimationView;", "", "assetName", "", "setAnimation", "", "<set-?>", "b", "I", "getPlayCount", "()I", "playCount", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowLottieAnimationViewWithPlayCount extends LottieAnimationView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f49592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f49593b;

    public static final class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WindowLottieAnimationViewWithPlayCount f49594a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public a(WindowLottieAnimationViewWithPlayCount r100) {
            this.f49594a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            WindowLottieAnimationViewWithPlayCount r101 = this.f49594a;
            r101.f49593b = r101.getPlayCount() + 1;
        }
    }

    public WindowLottieAnimationViewWithPlayCount(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public WindowLottieAnimationViewWithPlayCount(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final int getPlayCount() {
        return this.f49593b;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void setAnimation(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if ((!Intrinsics.areEqual(r100, this.f49592a)) == false) goto L8;
        super.setAnimation(r100);
        this.f49593b = 0;
        this.f49592a = r100;
        return;
    }

    public WindowLottieAnimationViewWithPlayCount(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        addAnimatorListener(new a(this));
    }

    public /* synthetic */ WindowLottieAnimationViewWithPlayCount(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
