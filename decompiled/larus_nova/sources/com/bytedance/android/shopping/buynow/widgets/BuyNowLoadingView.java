package com.bytedance.android.shopping.buynow.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.shopping.buynow.components.SkeletonMode;
import com.bytedance.android.ui.base.widget.round.RoundConstraintLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/buynow/widgets/BuyNowLoadingView;", "Lcom/bytedance/android/ui/base/widget/round/RoundConstraintLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BuyNowLoadingView extends RoundConstraintLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f171244g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BuyNowDoubleColorBallAnimationView f171245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f171246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f171247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SimpleDraweeView f171248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SimpleDraweeView f171249e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f171250f;

    public BuyNowLoadingView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BuyNowLoadingView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void S5() {
        this.f171245a.d();
        setVisibility(8);
        this.f171246b.setVisibility(8);
        this.f171247c.setVisibility(8);
        this.f171250f.setVisibility(8);
        this.f171248d.setVisibility(8);
        this.f171249e.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public BuyNowLoadingView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.buynow_view_loading, this, true);
        this.f171245a = (BuyNowDoubleColorBallAnimationView) findViewById(R.id.loading_view_ball);
        this.f171246b = (SimpleDraweeView) findViewById(R.id.skeleton_view);
        this.f171247c = (SimpleDraweeView) findViewById(R.id.ultimate_skeleton_view);
        this.f171248d = (SimpleDraweeView) findViewById(R.id.recharge_image_view);
        this.f171249e = (SimpleDraweeView) findViewById(R.id.continue_pay_image_view);
        this.f171250f = findViewById(R.id.sku_skeleton_loading_moving_anime);
    }

    public final void R5(boolean r100, boolean r101, SkeletonMode r102) {
        setVisibility(0);
        if (r101 == false) goto L5;
        this.f171245a.c();
    L5:
        if (r100 == false) goto L17;
        if (r102 != SkeletonMode.ONLY_PAY) goto L10;
        this.f171248d.setVisibility(0);
        h0 r103 = h0.f44678a;
        h0.a(this.f171248d, R.drawable.buynow_loading_recharge);
        return;
    L10:
        if (r102 != SkeletonMode.CONTINUE_PAY) goto L13;
        this.f171249e.setVisibility(0);
        h0 r104 = h0.f44678a;
        h0.a(this.f171249e, R.drawable.continue_pay_loading);
        return;
    L13:
        if (r102 != SkeletonMode.ULTIMATE) goto L15;
        this.f171247c.setVisibility(0);
        return;
    L15:
        this.f171246b.setVisibility(0);
        h0 r105 = h0.f44678a;
        h0.a(this.f171246b, R.drawable.buynow_loading_holder);
        return;
    L17:
        if (r102 != SkeletonMode.ONLY_PAY) goto L20;
        this.f171248d.setVisibility(8);
        return;
    L20:
        if (r102 != SkeletonMode.CONTINUE_PAY) goto L23;
        this.f171249e.setVisibility(8);
        return;
    L23:
        if (r102 != SkeletonMode.ULTIMATE) goto L25;
        this.f171247c.setVisibility(8);
        this.f171250f.setVisibility(8);
        return;
    L25:
        this.f171246b.setVisibility(8);
    }

    public /* synthetic */ BuyNowLoadingView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
