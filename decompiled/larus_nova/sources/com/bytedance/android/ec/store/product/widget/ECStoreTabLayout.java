package com.bytedance.android.ec.store.product.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/store/product/widget/ECStoreTabLayout;", "Lcom/bytedance/android/ui/base/widget/tablayout/ECTabLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreTabLayout extends ECTabLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f48374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f48375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f48376c;

    public ECStoreTabLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECStoreTabLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View, android.view.ViewParent
    public final void requestLayout() {
        super.requestLayout();
        this.f48376c = true;
    }

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout, android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (this.f48374a != r100) goto L10;
        if (this.f48375b != r101) goto L10;
        if (this.f48376c == true) goto L10;
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    L15:
        this.f48374a = r100;
        this.f48375b = r101;
        this.f48376c = false;
        return;
    L10:
        if (getTabMode() == 1) goto L12;
    L14:
        super.onMeasure(r100, r101);
        goto L15
    L12:
        if (getChildCount() != 1) goto L14;
        View r102 = getChildAt(0);
        int r103 = HorizontalScrollView.getChildMeasureSpec(r101, getPaddingTop() + getPaddingBottom(), r102.getLayoutParams().height);
        r102.measure(View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(r100) - getPaddingStart()) - getPaddingEnd(), 1073741824), r103);
        setMeasuredDimension((r102.getMeasuredWidth() + getPaddingEnd()) + getPaddingStart(), (r102.getMeasuredHeight() + getPaddingTop()) + getPaddingBottom());
        goto L15
    }

    public ECStoreTabLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setDefaultUnSelected(true);
    }

    public /* synthetic */ ECStoreTabLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
