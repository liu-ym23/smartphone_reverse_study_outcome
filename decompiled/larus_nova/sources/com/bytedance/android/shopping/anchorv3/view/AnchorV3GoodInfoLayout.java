package com.bytedance.android.shopping.anchorv3.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/view/AnchorV3GoodInfoLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV3GoodInfoLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f165390a;

    public AnchorV3GoodInfoLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV3GoodInfoLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (getChildCount() <= 1) goto L11;
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(0, 0));
        int r102 = getChildAt(0).getMeasuredHeight();
        getChildAt(1).getMeasuredHeight();
        if (r102 == this.f165390a) goto L8;
        this.f165390a = r102;
        getLayoutParams().height = -2;
    L8:
        if (getLayoutParams().height <= 0) goto L10;
        setMeasuredDimension(getMeasuredWidth(), getLayoutParams().height);
        return;
    L10:
        setMeasuredDimension(getMeasuredWidth(), r102);
        return;
    L11:
        super.onMeasure(r100, r101);
    }

    public AnchorV3GoodInfoLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ AnchorV3GoodInfoLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
