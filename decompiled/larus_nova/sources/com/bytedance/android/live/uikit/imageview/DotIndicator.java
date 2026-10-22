package com.bytedance.android.live.uikit.imageview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes7.dex */
public class DotIndicator extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f102191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f102192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f102193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f102194d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f102195e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint f102196f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f102197g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f102198h;

    public final void a() {
        int r100 = this.f102192b;
        int r101 = r100 * 2;
        this.f102194d = r101;
        this.f102193c = (r100 * 0) + (0 * this.f102191a);
        setMaxHeight(r101);
        setMinimumHeight(this.f102194d);
        setMinimumWidth(this.f102193c);
        Paint r102 = new Paint();
        this.f102195e = r102;
        r102.setAntiAlias(true);
        this.f102195e.setColor(this.f102198h);
        Paint r103 = new Paint();
        this.f102196f = r103;
        r103.setAntiAlias(true);
        this.f102196f.setColor(this.f102197g);
        invalidate();
    }

    public DotIndicator(Context r100) {
        super(r100);
        a();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
    }

    public void setCurrentPosition(int r100) {
        if (r100 < 0) goto L4;
        return;
    L4:
        invalidate();
    }

    public void setDotRadius(int r100) {
        this.f102192b = r100;
    }

    public void setSelectedColor(int r100) {
        this.f102197g = r100;
        this.f102196f.setColor(r100);
    }

    public void setSpace(int r100) {
        this.f102191a = r100;
    }

    public void setUnSelectedColor(int r100) {
        this.f102198h = r100;
        this.f102195e.setColor(r100);
    }

    public DotIndicator(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public DotIndicator(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        Resources r103 = r100.getResources();
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.diameter, R.attr.dot_radius, R.attr.selected_color, R.attr.space, R.attr.unselected_color}, r102, 0);
        this.f102197g = r104.getColor(2, r103.getColor(R.color.dot_select_color));
        this.f102198h = r104.getColor(4, r103.getColor(R.color.dot_unselect_color));
        this.f102191a = r104.getDimensionPixelSize(3, (int) UIUtils.dip2Px(r100, 4.0f));
        this.f102192b = r104.getDimensionPixelSize(1, (int) UIUtils.dip2Px(r100, 4.0f));
        r104.recycle();
        a();
    }
}
