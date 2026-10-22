package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.shopping.store.tabkit.view.RedDotView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\u000f\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/store/home/view/ECBubbleLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getIconView", "()Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "iconView", "b", "getBubbleView", "bubbleView", "Lcom/bytedance/android/shopping/store/tabkit/view/RedDotView;", "c", "getRedDotView", "()Lcom/bytedance/android/shopping/store/tabkit/view/RedDotView;", "redDotView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECBubbleLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f184514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f184515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f184516c;

    public ECBubbleLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECBubbleLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final ECDraweeView getBubbleView() {
        return (ECDraweeView) this.f184515b.getValue();
    }

    private final ECDraweeView getIconView() {
        return (ECDraweeView) this.f184514a.getValue();
    }

    private final RedDotView getRedDotView() {
        return (RedDotView) this.f184516c.getValue();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        setMeasuredDimension(getIconView().getMeasuredWidth(), getIconView().getMeasuredHeight());
    }

    public ECBubbleLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f184514a = LazyKt.lazy(new ECBubbleLayout$iconView$2(this));
        this.f184515b = LazyKt.lazy(new ECBubbleLayout$bubbleView$2(this));
        this.f184516c = LazyKt.lazy(new ECBubbleLayout$redDotView$2(this));
        setClipChildren(false);
    }

    public static void a(int r100, int r101, View r102) {
        r102.layout(r101 - (r102.getMeasuredWidth() / 2), r100 - (r102.getMeasuredHeight() / 2), (r101 - (r102.getMeasuredWidth() / 2)) + r102.getMeasuredWidth(), (r100 - (r102.getMeasuredHeight() / 2)) + r102.getMeasuredHeight());
    }

    public /* synthetic */ ECBubbleLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        int r105 = getIconView().getRight();
        int r106 = getIconView().getTop();
        a(r106, r105, getRedDotView());
        a(r106, r105, getBubbleView());
    }
}
