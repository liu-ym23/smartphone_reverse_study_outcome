package com.bytedance.android.ec.window.base.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes44.dex */
public class ECWindowLiveCircleView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f49802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f49803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f49804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f49805d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f49806e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f49807f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f49808g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Paint f49809h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ValueAnimator f49810i;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowLiveCircleView f49811a;

        public a(ECWindowLiveCircleView r100) {
            this.f49811a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            int r101 = ((Integer) r100.getAnimatedValue()).intValue();
            if (r101 >= 0) goto L5;
            return;
        L5:
            if (r101 > 640) goto L9;
            this.f49811a.setFraction((r101 * 1.0f) / 640.0f);
            return;
        }
    }

    public final void a() {
        ValueAnimator r100 = this.f49810i;
        if (r100 != null) goto L5;
    L7:
        ValueAnimator r101 = ValueAnimator.ofInt(new int[]{0, 800});
        this.f49810i = r101;
        r101.setRepeatCount(-1);
        this.f49810i.setRepeatMode(1);
        this.f49810i.setDuration(800);
        this.f49810i.addUpdateListener(new a(this));
        this.f49810i.start();
        return;
    L5:
        if (r100.isRunning() == false) goto L7;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator r100 = this.f49810i;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isRunning() == false) goto L9;
        this.f49810i.cancel();
        return;
    }

    public ECWindowLiveCircleView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        r100.drawCircle(this.f49804c, this.f49805d, this.f49806e, this.f49802a);
        r100.drawCircle(this.f49804c, this.f49805d, this.f49807f, this.f49809h);
    }

    public void setFraction(float r100) {
        float r101 = this.f49806e + (this.f49808g * r100);
        float r102 = this.f49803b * (1.0f - r100);
        this.f49807f = r101;
        this.f49809h.setStrokeWidth(r102);
        postInvalidate();
    }

    public void setStrokeWidth(int r100) {
        this.f49803b = r100;
    }

    public ECWindowLiveCircleView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        this.f49804c = getMeasuredWidth() / 2.0f;
        this.f49805d = getMeasuredHeight() / 2.0f;
        float r102 = (getMeasuredHeight() / 2.0f) - getPaddingBottom();
        this.f49806e = r102;
        this.f49807f = r102;
        this.f49808g = getPaddingBottom();
    }

    public ECWindowLiveCircleView(Context r100, AttributeSet r110, int r111) {
        super(r100, r110, r111);
        TypedArray r112 = r100.obtainStyledAttributes(r110, new int[]{R.attr.live_strokeWidth});
        this.f49803b = (int) r112.getDimension(0, UIUtils.dip2Px(r100, 1.5f));
        r112.recycle();
        this.f49802a = new Paint();
        this.f49802a.setShader(new LinearGradient(0.0f, 0.0f, 100.0f, 100.0f, ColorProtector.parseColor("#FF3B52"), ColorProtector.parseColor("#FF3B52"), Shader.TileMode.MIRROR));
        this.f49802a.setAntiAlias(true);
        this.f49802a.setDither(true);
        this.f49802a.setStyle(Paint.Style.STROKE);
        this.f49802a.setStrokeWidth(UIUtils.dip2Px(r100, 1.0f));
        this.f49809h = new Paint(this.f49802a);
    }
}
