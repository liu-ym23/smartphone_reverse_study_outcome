package com.bytedance.android.livesdk.feed.ui;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.CycleInterpolator;
import com.bytedance.common.utility.UIUtils;
import zw1.b;
import zw1.c;
import zw1.d;
import zw1.e;

/* JADX INFO: loaded from: classes8.dex */
public class XiguaLivingTagView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f124535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f124536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f124537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f124538d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f124539e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AnimatorSet f124540f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Paint f124541g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RectF f124542h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RectF f124543i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RectF f124544j;

    public XiguaLivingTagView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        int r101 = ((getRight() - getLeft()) - ((this.f124537c * 3) + (this.f124538d * 2))) >> 1;
        if (r101 >= 0) goto L5;
        r101 = 0;
    L5:
        r100.save();
        r100.translate(r101, 0.0f);
        a(r100, this.f124542h, this.f124541g);
        r100.restore();
        r100.save();
        r100.translate((this.f124537c + this.f124538d) + r101, 0.0f);
        a(r100, this.f124543i, this.f124541g);
        r100.restore();
        r100.save();
        r100.translate(r101 + ((this.f124537c + this.f124538d) * 2), 0.0f);
        a(r100, this.f124544j, this.f124541g);
        r100.restore();
    }

    public XiguaLivingTagView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r100);
        int r103 = (this.f124537c * 3) + (this.f124538d * 2);
        int r104 = View.MeasureSpec.getSize(r101);
        int r105 = this.f124535a;
        if (View.MeasureSpec.getMode(r100) == Integer.MIN_VALUE) goto L10;
        if (r102 > r103) goto L8;
        r102 = r103;
    L8:
        r103 = r102;
    L10:
        if (View.MeasureSpec.getMode(r101) == Integer.MIN_VALUE) goto L16;
        if (r104 > r105) goto L15;
        r104 = r105;
    L15:
        r105 = r104;
    L16:
        setMeasuredDimension(r103, r105);
    }

    public XiguaLivingTagView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f124535a = (int) UIUtils.dip2Px(r100, 10.0f);
        this.f124536b = (int) UIUtils.dip2Px(r100, 3.0f);
        this.f124537c = (int) UIUtils.dip2Px(r100, 2.0f);
        this.f124538d = (int) UIUtils.dip2Px(r100, 2.0f);
        this.f124539e = 2;
        this.f124542h = new RectF();
        this.f124543i = new RectF();
        this.f124544j = new RectF();
        Paint r103 = new Paint();
        this.f124541g = r103;
        r103.setColor(-1);
        this.f124541g.setAntiAlias(true);
        ValueAnimator r104 = ValueAnimator.ofInt(new int[]{this.f124536b, this.f124535a});
        r104.setInterpolator(new CycleInterpolator(0.5f));
        r104.setDuration(400);
        r104.addUpdateListener(new b(this));
        ValueAnimator r105 = ValueAnimator.ofInt(new int[]{this.f124536b, this.f124535a});
        r105.setInterpolator(new CycleInterpolator(0.5f));
        r105.setDuration(400);
        r105.addUpdateListener(new c(this));
        ValueAnimator r106 = ValueAnimator.ofInt(new int[]{this.f124536b, this.f124535a});
        r106.setInterpolator(new CycleInterpolator(0.5f));
        r106.setDuration(400);
        r106.addUpdateListener(new d(this));
        AnimatorSet r107 = new AnimatorSet();
        this.f124540f = r107;
        r107.play(r104).after(220);
        this.f124540f.play(r105).after(150);
        this.f124540f.play(r106).after(0);
        this.f124540f.addListener(new e());
    }

    public final void a(Canvas r100, RectF r101, Paint r102) {
        int r103 = (getBottom() - getTop()) >> 1;
        int r104 = ((int) (r101.bottom - r101.top)) >> 1;
        r101.set(r101.left, r103 - r104, r101.right, r103 + r104);
        int r105 = this.f124539e;
        r100.drawRoundRect(r101, r105, r105, r102);
    }
}
