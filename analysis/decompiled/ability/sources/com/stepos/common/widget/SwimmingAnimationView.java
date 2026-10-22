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
import com.stepos.ability.R;

/* loaded from: classes3.dex */
public class SwimmingAnimationView extends View {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f3773a;
    public final int b;
    public final int c;
    public final int d;
    public float e;
    public float f;
    public float g;
    public final ValueAnimator h;
    public volatile boolean i;

    /* renamed from: j, reason: collision with root package name */
    public final A6.m f3774j;

    public SwimmingAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.i = false;
        X4.a aVar = new X4.a(0.66f, 0.0f, 0.67f);
        X4.a aVar2 = new X4.a(0.33f, 0.0f, 0.27f);
        Q.a aVar3 = new Q.a(this, 6);
        this.f3774j = new A6.m(this, 9);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, V4.s.f1377v);
        int color = typedArrayObtainStyledAttributes.getColor(0, context.getResources().getColor(R.color.stepos_theme_color_blue));
        this.b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, getResources().getDimensionPixelOffset(R.dimen.stepos_swimming_circle_radius));
        this.c = typedArrayObtainStyledAttributes.getDimensionPixelOffset(2, getResources().getDimensionPixelOffset(R.dimen.stepos_swimming_circle_gap));
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, getResources().getDimensionPixelOffset(R.dimen.stepos_swimming_circle_distance));
        this.d = dimensionPixelOffset;
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.f3773a = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);
        P p = new P();
        p.f3732r = aVar3;
        float f = dimensionPixelOffset;
        p.f3729a = f;
        p.b = 450L;
        p.c = aVar;
        p.d = 520L;
        p.e = aVar2;
        p.f = f;
        p.g = 450L;
        p.h = aVar;
        p.i = 520L;
        p.f3730j = aVar2;
        p.k = 83L;
        p.l = f;
        p.m = 450L;
        p.n = aVar;
        p.o = 520L;
        p.p = aVar2;
        p.f3731q = 166L;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 970);
        valueAnimatorOfFloat.setDuration(970L);
        valueAnimatorOfFloat.addUpdateListener(p);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.h = valueAnimatorOfFloat;
    }

    public final void a() {
        if (this.i) {
            this.i = false;
            this.h.removeAllListeners();
            this.h.cancel();
            this.e = 0.0f;
            this.f = 0.0f;
            this.g = 0.0f;
            Log.d("SwimmingAnimationView", "stopAnimator");
        }
    }

    public final void b(int i) {
        if (i != 0 || !isShown()) {
            a();
        } else {
            if (this.i) {
                return;
            }
            this.i = true;
            this.h.addListener(this.f3774j);
            this.h.start();
            Log.d("SwimmingAnimationView", "startAnimator");
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int i = this.b;
        Paint paint = this.f3773a;
        canvas.drawCircle(i, i + this.e, i, paint);
        int i6 = this.c;
        canvas.drawCircle((i * 3) + i6, i + this.f, i, paint);
        canvas.drawCircle((i6 * 2) + (i * 5), i + this.g, i, paint);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i6) {
        int i10 = this.b;
        int i11 = (this.c * 2) + (i10 * 6);
        int i12 = (i10 * 2) + this.d;
        setMeasuredDimension(View.resolveSizeAndState(getPaddingRight() + getPaddingLeft() + i11, i, 0), View.resolveSizeAndState(getPaddingBottom() + getPaddingTop() + i12, i6, 0));
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        StringBuilder sbU = B7.a.u(i, "onVisibilityChanged=", ", isShown=");
        sbU.append(isShown());
        sbU.append(", getVisibility=");
        sbU.append(getVisibility());
        Log.d("SwimmingAnimationView", sbU.toString());
        b(i);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        StringBuilder sbU = B7.a.u(i, "onWindowVisibilityChanged:", ", isShown=");
        sbU.append(isShown());
        Log.d("SwimmingAnimationView", sbU.toString());
        b(i);
    }
}
