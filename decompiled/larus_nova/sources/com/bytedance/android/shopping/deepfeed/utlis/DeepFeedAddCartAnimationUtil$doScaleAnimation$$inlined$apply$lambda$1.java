package com.bytedance.android.shopping.deepfeed.utlis;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.WindowManager;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/shopping/deepfeed/utlis/DeepFeedAddCartAnimationUtil$doScaleAnimation$animatorSet$1$safeRemove$1"}, k = 3, mv = {1, 4, 3})
final class DeepFeedAddCartAnimationUtil$doScaleAnimation$$inlined$apply$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Animator $appearAnimator$inlined;
    final /* synthetic */ ECDraweeView $productImage$inlined;
    final /* synthetic */ AnimatorSet $this_apply;
    final /* synthetic */ AnimatorSet $throwAndCartAndDisapearAnimator$inlined;
    final /* synthetic */ WindowManager $windowManager$inlined;

    public DeepFeedAddCartAnimationUtil$doScaleAnimation$$inlined$apply$lambda$1(AnimatorSet r100, Animator r101, AnimatorSet r102, ECDraweeView r103, WindowManager r104) {
        this.$this_apply = r100;
        this.$appearAnimator$inlined = r101;
        this.$throwAndCartAndDisapearAnimator$inlined = r102;
        this.$productImage$inlined = r103;
        this.$windowManager$inlined = r104;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L9
        this.$productImage$inlined.setVisibility(4);     // Catch: Throwable -> L9
        WindowManager r101 = this.$windowManager$inlined;     // Catch: Throwable -> L9
        if (r101 == null) goto L6;
        r101.removeViewImmediate(this.$productImage$inlined);     // Catch: Throwable -> L9
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r103 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L9
    L12:
        if (Result.m9452exceptionOrNullimpl(r103) == null) goto L17;
        this.$productImage$inlined.setVisibility(4);
        return;
    L17:
        return;
    L6:
        r102 = null;
    L9:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
