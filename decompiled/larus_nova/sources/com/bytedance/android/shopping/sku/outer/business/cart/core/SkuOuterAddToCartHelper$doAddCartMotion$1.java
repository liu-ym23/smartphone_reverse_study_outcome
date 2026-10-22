package com.bytedance.android.shopping.sku.outer.business.cart.core;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class SkuOuterAddToCartHelper$doAddCartMotion$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ View $destinationView;
    final /* synthetic */ View $sourceView;

    public SkuOuterAddToCartHelper$doAddCartMotion$1(View r100, View r101) {
        this.$sourceView = r100;
        this.$destinationView = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        View r100 = this.$sourceView;
        View r101 = this.$destinationView;
        Boolean r102 = Boolean.TRUE;
        Intrinsics.checkNotNullParameter(r100, "sourceView");
        Intrinsics.checkNotNullParameter(r101, "destinationView");
        Object r103 = r101.getContext().getSystemService(LiveEndPageData.TAG_WINDOW);
        if ((r103 instanceof WindowManager) == true) goto L5;
        r103 = null;
    L5:
        WindowManager r104 = (WindowManager) r103;
        int[] r105 = new int[2];
        r100.getLocationOnScreen(r105);
        float r106 = r105[0] + (r100.getWidth() / 2);
        float r107 = r105[1] + (r100.getHeight() / 2);
        int[] r108 = new int[2];
        r101.getLocationOnScreen(r108);
        float r109 = r108[0] + (r101.getWidth() / 2);
        float r110 = r108[1] + (r101.getHeight() / 2);
        int r111 = vf4.a.a(r100.getContext(), 5.0f);
        Context r112 = r100.getContext();
        WindowManager.LayoutParams r113 = new WindowManager.LayoutParams();
        r113.width = vf4.a.a(r112, 10.0f);
        r113.height = vf4.a.a(r112, 10.0f);
        r113.x = ((int) r106) - r111;
        r113.y = (((int) r107) - eh.b.b(r112)) - r111;
        r113.flags = 664;
        r113.format = -3;
        r113.gravity = 8388659;
        r113.type = 99;
        View r114 = th.a.d(r101.getContext(), R.layout.sku_view_add_cart_motion, null, 4);
        if (r104 == null) goto L9;
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r114, r113);
        r104.addView(r114, r113);
    L9:
        if (r110 >= r107) goto L11;
        TypeEvaluator r115 = new sh3.e(new PointF((r106 + r109) / 2, (float) (((double) r110) - (((double) (r107 - r110)) * 0.3d))));
    L12:
        ValueAnimator r116 = ValueAnimator.ofObject(r115, new Object[]{new PointF(r106, r107), new PointF(r109, r110)});
        r116.addUpdateListener(new sh3.a(r104, r114, r113, r111, r102, r100));
        ObjectAnimator r117 = ObjectAnimator.ofFloat(r114, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 0.3f});
        ObjectAnimator r118 = ObjectAnimator.ofFloat(r114, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 0.3f});
        AnimatorSet r119 = new AnimatorSet();
        r119.setDuration(600);
        r119.setInterpolator(new DecelerateInterpolator());
        r119.setStartDelay(500);
        r119.addListener(new sh3.b(r114, null, r104));
        r119.playTogether(new Animator[]{r116, r117, r118});
        r119.start();
        return;
    L11:
        r115 = new sh3.d();
        goto L12
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
