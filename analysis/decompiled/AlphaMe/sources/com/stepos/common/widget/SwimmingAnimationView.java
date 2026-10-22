package com.stepos.common.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.C0195d;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import i2.AbstractC0620a;
import j2.InterpolatorC0636a;

/* loaded from: classes.dex */
public class SwimmingAnimationView extends View {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f11821a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11822b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11823c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11824d;

    /* renamed from: e, reason: collision with root package name */
    public float f11825e;

    /* renamed from: f, reason: collision with root package name */
    public float f11826f;

    /* renamed from: g, reason: collision with root package name */
    public float f11827g;

    /* renamed from: h, reason: collision with root package name */
    public final ValueAnimator f11828h;

    /* renamed from: i, reason: collision with root package name */
    public volatile boolean f11829i;

    /* renamed from: j, reason: collision with root package name */
    public final C0195d f11830j;

    public SwimmingAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f11829i = false;
        InterpolatorC0636a interpolatorC0636a = new InterpolatorC0636a(0.66f, Property.DEFAULT_FLOAT_VALUE, 0.67f);
        InterpolatorC0636a interpolatorC0636a2 = new InterpolatorC0636a(0.33f, Property.DEFAULT_FLOAT_VALUE, 0.27f);
        com.google.android.gms.common.api.internal.p pVar = new com.google.android.gms.common.api.internal.p(19, this);
        this.f11830j = new C0195d(12, this);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0620a.f13040v);
        int color = typedArrayObtainStyledAttributes.getColor(0, context.getResources().getColor(R.color.stepos_theme_color_blue));
        this.f11822b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, getResources().getDimensionPixelOffset(R.dimen.stepos_swimming_circle_radius));
        this.f11823c = typedArrayObtainStyledAttributes.getDimensionPixelOffset(2, getResources().getDimensionPixelOffset(R.dimen.stepos_swimming_circle_gap));
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, getResources().getDimensionPixelOffset(R.dimen.stepos_swimming_circle_distance));
        this.f11824d = dimensionPixelOffset;
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.f11821a = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);
        L l4 = new L();
        l4.f11687s = pVar;
        float f4 = dimensionPixelOffset;
        l4.f11669a = f4;
        l4.f11670b = 450L;
        l4.f11671c = interpolatorC0636a;
        l4.f11672d = 520L;
        l4.f11673e = interpolatorC0636a2;
        l4.f11674f = 0L;
        l4.f11675g = f4;
        l4.f11676h = 450L;
        l4.f11677i = interpolatorC0636a;
        l4.f11678j = 520L;
        l4.f11679k = interpolatorC0636a2;
        l4.f11680l = 83L;
        l4.f11681m = f4;
        l4.f11682n = 450L;
        l4.f11683o = interpolatorC0636a;
        l4.f11684p = 520L;
        l4.f11685q = interpolatorC0636a2;
        l4.f11686r = 166L;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(Property.DEFAULT_FLOAT_VALUE, 970);
        valueAnimatorOfFloat.setDuration(970L);
        valueAnimatorOfFloat.addUpdateListener(l4);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.f11828h = valueAnimatorOfFloat;
    }

    public final void a() {
        if (this.f11829i) {
            this.f11829i = false;
            this.f11828h.removeAllListeners();
            this.f11828h.cancel();
            this.f11825e = Property.DEFAULT_FLOAT_VALUE;
            this.f11826f = Property.DEFAULT_FLOAT_VALUE;
            this.f11827g = Property.DEFAULT_FLOAT_VALUE;
            Log.d("SwimmingAnimationView", "stopAnimator");
        }
    }

    public final void b(int i4) {
        if (i4 != 0 || !isShown()) {
            a();
        } else {
            if (this.f11829i) {
                return;
            }
            this.f11829i = true;
            this.f11828h.addListener(this.f11830j);
            this.f11828h.start();
            Log.d("SwimmingAnimationView", "startAnimator");
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int i4 = this.f11822b;
        Paint paint = this.f11821a;
        canvas.drawCircle(i4, i4 + this.f11825e, i4, paint);
        int i5 = this.f11823c;
        canvas.drawCircle((i4 * 3) + i5, i4 + this.f11826f, i4, paint);
        canvas.drawCircle((i5 * 2) + (i4 * 5), i4 + this.f11827g, i4, paint);
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        int i6 = this.f11822b;
        int i7 = (this.f11823c * 2) + (i6 * 6);
        int i8 = (i6 * 2) + this.f11824d;
        setMeasuredDimension(View.resolveSizeAndState(getPaddingRight() + getPaddingLeft() + i7, i4, 0), View.resolveSizeAndState(getPaddingBottom() + getPaddingTop() + i8, i5, 0));
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i4) {
        super.onVisibilityChanged(view, i4);
        StringBuilder sbT = B0.g.t("onVisibilityChanged=", i4, ", isShown=");
        sbT.append(isShown());
        sbT.append(", getVisibility=");
        sbT.append(getVisibility());
        Log.d("SwimmingAnimationView", sbT.toString());
        b(i4);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i4) {
        super.onWindowVisibilityChanged(i4);
        StringBuilder sbT = B0.g.t("onWindowVisibilityChanged:", i4, ", isShown=");
        sbT.append(isShown());
        Log.d("SwimmingAnimationView", sbT.toString());
        b(i4);
    }
}
