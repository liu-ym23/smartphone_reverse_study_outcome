package com.bytedance.android.ui.base.widget.scroll;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/ui/base/widget/scroll/MaxHeightScrollView;", "Landroidx/core/widget/NestedScrollView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "maxHeight", "", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "ui-base-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MaxHeightScrollView extends NestedScrollView {
    private float maxHeight;

    public MaxHeightScrollView(Context r100) {
        this(r100, null, 0, 6, null);
    }

    public MaxHeightScrollView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 4, null);
    }

    @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        float r102 = this.maxHeight;
        if (r102 <= 0.0f) goto L5;
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec((int) r102, Integer.MIN_VALUE));
        return;
    L5:
        super.onMeasure(r100, r101);
    }

    public MaxHeightScrollView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.maxHeight = -1.0f;
        if (r101 == null) goto L6;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.maxHeight, R.attr.scroll_view_max_height});
        this.maxHeight = r103.getDimension(1, this.maxHeight);
        r103.recycle();
        return;
    }

    public /* synthetic */ MaxHeightScrollView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
