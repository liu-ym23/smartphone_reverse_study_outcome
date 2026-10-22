package com.bytedance.android.shopping.inflow.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes13.dex */
public class TopRoundRelativeLayout extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f176365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f176366b;

    public TopRoundRelativeLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        int r101 = this.f176365a;
        super.dispatchDraw(r100);
    }

    public void setBorderRadius(int r100) {
        a(getWidth(), getHeight());
        this.f176365a = r100;
        invalidate();
    }

    public TopRoundRelativeLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final void a(int r100, int r101) {
        if (this.f176365a > 0) goto L5;
        return;
    L5:
        if (this.f176366b != null) goto L7;
        this.f176366b = new g();
    L7:
        setClipToOutline(true);
        this.f176366b.update(this.f176365a, r100, r101);
        setOutlineProvider(this.f176366b);
    }

    public TopRoundRelativeLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f176365a = 0;
        this.f176366b = null;
        TypedArray r103 = r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.left_rounded_radius, R.attr.rounded_radius}, r102, 0);
        if (r103.hasValue(1) == false) goto L5;
        this.f176365a = r103.getDimensionPixelOffset(1, 0);
    L5:
        r103.recycle();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        int r104 = this.f176365a;
        a(r100, r101);
    }
}
