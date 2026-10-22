package com.bytedance.android.ec.window.base.product.presenter.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.WindowManager;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/Animator;", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/ec/window/base/product/presenter/utils/ECWindowProductCardFunctionUtils$doScaleAnimation$animatorSet$1$1"}, k = 3, mv = {1, 4, 3})
final class ECWindowProductCardFunctionUtils$doScaleAnimation$$inlined$apply$lambda$1 extends Lambda implements Function1<Animator, Unit> {
    final /* synthetic */ Animator $appearAnimator$inlined;
    final /* synthetic */ ECDraweeView $productImage$inlined;
    final /* synthetic */ AnimatorSet $throwAndCartAndDisapearAnimator$inlined;
    final /* synthetic */ WindowManager $windowManager$inlined;

    public ECWindowProductCardFunctionUtils$doScaleAnimation$$inlined$apply$lambda$1(Animator r100, AnimatorSet r101, ECDraweeView r102, WindowManager r103) {
        this.$appearAnimator$inlined = r100;
        this.$throwAndCartAndDisapearAnimator$inlined = r101;
        this.$productImage$inlined = r102;
        this.$windowManager$inlined = r103;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        this.$productImage$inlined.setVisibility(4);     // Catch: Throwable -> L7
        WindowManager r101 = this.$windowManager$inlined;     // Catch: Throwable -> L7
        if (r101 == null) goto L11;
        r101.removeView(this.$productImage$inlined);     // Catch: Throwable -> L7
        return;
    L11:
        return;
    L7:
        this.$productImage$inlined.setVisibility(4);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Animator r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
