package com.android.ttcjpaysdk.base.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes28.dex */
public class CJMaxHeightScrollView extends ScrollView {
    private int maxHeight;

    public CJMaxHeightScrollView(Context r100) {
        this(r100, null);
    }

    public CJMaxHeightScrollView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    private void init(Context r100, AttributeSet r101) {
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.maxHeight});
        this.maxHeight = r102.getLayoutDimension(0, this.maxHeight);
        r102.recycle();
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(this.maxHeight, Integer.MIN_VALUE));
    }

    public CJMaxHeightScrollView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.maxHeight = CJPayBasicUtils.dipToPX(r100, 256.0f);
        init(r100, r101);
    }
}
