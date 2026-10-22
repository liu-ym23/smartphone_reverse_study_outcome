package com.bytedance.android.live.uikit.progressview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes7.dex */
public class ArcProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f102310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f102311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f102312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f102313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f102314e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint f102315f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RectF f102316g;

    public final void a() {
        Paint r100 = new Paint();
        this.f102314e = r100;
        r100.setColor(this.f102310a);
        this.f102314e.setAntiAlias(true);
        Paint r101 = new Paint();
        this.f102315f = r101;
        r101.setColor(this.f102311b);
        this.f102314e.setAntiAlias(true);
        this.f102316g = new RectF();
    }

    public ArcProgressView(Context r100) {
        super(r100);
        this.f102312c = 50;
        this.f102313d = 0;
        Resources r101 = r100.getResources();
        this.f102310a = r101.getColor(R.color.arc_progress_background);
        this.f102311b = r101.getColor(R.color.arc_progress_sweeping_color);
        int r102 = r101.getDimensionPixelSize(R.dimen.arc_progress_radius);
        this.f102312c = r102;
        if (r102 >= 50) goto L5;
        this.f102312c = 50;
    L5:
        a();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        r100.drawCircle(getWidth() / 2, getHeight() / 2, this.f102312c, this.f102314e);
        int r101 = (int) ((((double) this.f102313d) / 100.0d) * 360.0d);
        int r102 = getWidth() - (this.f102312c * 2);
        int r103 = getHeight();
        int r104 = this.f102312c;
        int r105 = r102 / 2;
        int r106 = (r103 - (r104 * 2)) / 2;
        this.f102316g.set(r105, r106, r105 + (r104 * 2), r106 + (r104 * 2));
        int r107 = r101 + 0;
        if (r107 <= 360) goto L5;
        r107 = r107 - 360;
    L5:
        r100.drawArc(this.f102316g, 0, r107, true, this.f102315f);
    }

    public void setProgress(int r100) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        if (r100 > 100) goto L9;
        this.f102313d = r100;
        invalidate();
        return;
    }

    public ArcProgressView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getSize(r100);
        if (r102 == 1073741824) goto L9;
        int r104 = ((this.f102312c * 2) + getPaddingTop()) + getPaddingBottom();
        if (r102 != Integer.MIN_VALUE) goto L8;
        r103 = Math.min(r104, r103);
        goto L9
    L8:
        r103 = r104;
    L9:
        int r105 = View.MeasureSpec.getMode(r101);
        int r106 = View.MeasureSpec.getSize(r101);
        if (r105 == 1073741824) goto L16;
        int r107 = ((this.f102312c * 2) + getPaddingTop()) + getPaddingBottom();
        if (r105 != Integer.MIN_VALUE) goto L15;
        r106 = Math.min(r107, r106);
        goto L16
    L15:
        r106 = r107;
    L16:
        setMeasuredDimension(r103, r106);
    }

    public ArcProgressView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f102312c = 50;
        this.f102313d = 0;
        Resources r103 = r100.getResources();
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.background_color, R.attr.radius, R.attr.sweeping_color}, r102, 0);
        this.f102310a = r104.getColor(0, r103.getColor(R.color.arc_progress_background));
        this.f102311b = r104.getColor(2, r103.getColor(R.color.arc_progress_sweeping_color));
        int r105 = r104.getDimensionPixelSize(1, r103.getDimensionPixelSize(R.dimen.arc_progress_radius));
        this.f102312c = r105;
        if (r105 >= 50) goto L5;
        this.f102312c = 50;
    L5:
        r104.recycle();
        a();
    }
}
