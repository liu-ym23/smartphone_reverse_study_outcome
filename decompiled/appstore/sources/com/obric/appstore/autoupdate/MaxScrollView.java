package com.obric.appstore.autoupdate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

/* JADX INFO: loaded from: classes3.dex */
public class MaxScrollView extends ScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10532a;

    public MaxScrollView(Context r10) {
        super(r10);
        this.f10532a = 0;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        int r12 = this.f10532a;
        if (r12 <= 0) goto L5;
        r11 = View.MeasureSpec.makeMeasureSpec(r12, Integer.MIN_VALUE);
    L5:
        super.onMeasure(r10, r11);
    }

    public void setMaxHeight(int r10) {
        this.f10532a = r10;
        requestLayout();
    }

    public MaxScrollView(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f10532a = 0;
    }

    public MaxScrollView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f10532a = 0;
    }
}
