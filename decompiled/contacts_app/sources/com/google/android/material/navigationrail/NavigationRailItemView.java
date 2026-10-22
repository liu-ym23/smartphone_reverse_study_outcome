package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import com.google.android.material.R;
import com.google.android.material.navigation.NavigationBarItemView;

/* JADX INFO: loaded from: classes2.dex */
final class NavigationRailItemView extends NavigationBarItemView {
    public NavigationRailItemView(Context r1) {
        super(r1);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        if (View.MeasureSpec.getMode(r2) != 0) goto L6;
        int r3 = View.MeasureSpec.getSize(r2);
        int r4 = Math.max(getMeasuredHeight(), r3);
        setMeasuredDimension(getMeasuredWidthAndState(), r4);
        return;
    }

    @Override // com.google.android.material.navigation.NavigationBarItemView
    protected int getItemLayoutResId() {
        return R.layout.mtrl_navigation_rail_item;
    }

    @Override // com.google.android.material.navigation.NavigationBarItemView
    protected int getItemDefaultMarginResId() {
        return R.dimen.mtrl_navigation_rail_icon_margin;
    }
}
