package com.stepos.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class SwimmingAnimationView extends View {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f7074a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7075b;

    /* renamed from: c, reason: collision with root package name */
    public final int f7076c;

    /* renamed from: d, reason: collision with root package name */
    public final int f7077d;

    /* renamed from: e, reason: collision with root package name */
    public float f7078e;
    public float h;

    /* renamed from: j, reason: collision with root package name */
    public float f7079j;

    /* renamed from: k, reason: collision with root package name */
    public final ValueAnimator f7080k;

    /* renamed from: l, reason: collision with root package name */
    public volatile boolean f7081l;

    /* renamed from: m, reason: collision with root package name */
    public final b f7082m;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a {
        public a() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b extends AnimatorListenerAdapter {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            @TargetApi(17)
            public final void run() {
                SwimmingAnimationView.this.f7080k.start();
            }
        }

        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            SwimmingAnimationView swimmingAnimationView = SwimmingAnimationView.this;
            if (Settings.Global.getFloat(swimmingAnimationView.getContext().getContentResolver(), "animator_duration_scale", 1.0f) != 0.0f) {
                swimmingAnimationView.post(new a());
            } else {
                Log.d("SwimmingAnimationView", "onAnimationEnd, animatorDurationScale == 0, stopAnimator");
                swimmingAnimationView.a();
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public float f7086a;

        /* renamed from: b, reason: collision with root package name */
        public long f7087b;

        /* renamed from: c, reason: collision with root package name */
        public i8.a f7088c;

        /* renamed from: d, reason: collision with root package name */
        public long f7089d;

        /* renamed from: e, reason: collision with root package name */
        public i8.a f7090e;

        /* renamed from: f, reason: collision with root package name */
        public float f7091f;

        /* renamed from: g, reason: collision with root package name */
        public long f7092g;
        public i8.a h;

        /* renamed from: i, reason: collision with root package name */
        public long f7093i;

        /* renamed from: j, reason: collision with root package name */
        public i8.a f7094j;

        /* renamed from: k, reason: collision with root package name */
        public long f7095k;

        /* renamed from: l, reason: collision with root package name */
        public float f7096l;

        /* renamed from: m, reason: collision with root package name */
        public long f7097m;

        /* renamed from: n, reason: collision with root package name */
        public i8.a f7098n;

        /* renamed from: o, reason: collision with root package name */
        public long f7099o;

        /* renamed from: p, reason: collision with root package name */
        public i8.a f7100p;

        /* renamed from: q, reason: collision with root package name */
        public long f7101q;
        public a r;

        public static float a(float f8, long j10, long j11, long j12, float f9, i8.a aVar, i8.a aVar2) {
            float f10 = f8 - j10;
            if (f10 < 0.0f) {
                f10 += j11 + j12;
            }
            float f11 = j11;
            if (f10 < f11) {
                return (aVar.getInterpolation(f10 / f11) * (f9 - 0.0f)) + 0.0f;
            }
            return (aVar2.getInterpolation((f10 - f11) / j12) * (0.0f - f9)) + f9;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float fA = a(fFloatValue, 0L, this.f7087b, this.f7089d, this.f7086a, this.f7088c, this.f7090e);
            float fA2 = a(fFloatValue, this.f7095k, this.f7092g, this.f7093i, this.f7091f, this.h, this.f7094j);
            float fA3 = a(fFloatValue, this.f7101q, this.f7097m, this.f7099o, this.f7096l, this.f7098n, this.f7100p);
            SwimmingAnimationView swimmingAnimationView = SwimmingAnimationView.this;
            swimmingAnimationView.f7078e = fA;
            swimmingAnimationView.h = fA2;
            swimmingAnimationView.f7079j = fA3;
            swimmingAnimationView.invalidate();
        }
    }

    public SwimmingAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f7081l = false;
        i8.a aVar = new i8.a(0.66f, 0.0f, 0.67f);
        i8.a aVar2 = new i8.a(0.33f, 0.0f, 0.27f);
        a aVar3 = new a();
        this.f7082m = new b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g8.a.f9094v);
        int color = typedArrayObtainStyledAttributes.getColor(0, context.getResources().getColor(R.color.stepos_theme_color_blue));
        this.f7075b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, getResources().getDimensionPixelOffset(R.dimen.stepos_swimming_circle_radius));
        this.f7076c = typedArrayObtainStyledAttributes.getDimensionPixelOffset(2, getResources().getDimensionPixelOffset(R.dimen.stepos_swimming_circle_gap));
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, getResources().getDimensionPixelOffset(R.dimen.stepos_swimming_circle_distance));
        this.f7077d = dimensionPixelOffset;
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.f7074a = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);
        c cVar = new c();
        cVar.r = aVar3;
        float f8 = dimensionPixelOffset;
        cVar.f7086a = f8;
        cVar.f7087b = 450L;
        cVar.f7088c = aVar;
        cVar.f7089d = 520L;
        cVar.f7090e = aVar2;
        cVar.f7091f = f8;
        cVar.f7092g = 450L;
        cVar.h = aVar;
        cVar.f7093i = 520L;
        cVar.f7094j = aVar2;
        cVar.f7095k = 83L;
        cVar.f7096l = f8;
        cVar.f7097m = 450L;
        cVar.f7098n = aVar;
        cVar.f7099o = 520L;
        cVar.f7100p = aVar2;
        cVar.f7101q = 166L;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 970);
        valueAnimatorOfFloat.setDuration(970L);
        valueAnimatorOfFloat.addUpdateListener(cVar);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.f7080k = valueAnimatorOfFloat;
    }

    public final void a() {
        if (this.f7081l) {
            this.f7081l = false;
            this.f7080k.removeAllListeners();
            this.f7080k.cancel();
            this.f7078e = 0.0f;
            this.h = 0.0f;
            this.f7079j = 0.0f;
            Log.d("SwimmingAnimationView", "stopAnimator");
        }
    }

    public final void b(int i10) {
        if (i10 != 0 || !isShown()) {
            a();
        } else {
            if (this.f7081l) {
                return;
            }
            this.f7081l = true;
            this.f7080k.addListener(this.f7082m);
            this.f7080k.start();
            Log.d("SwimmingAnimationView", "startAnimator");
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int i10 = this.f7075b;
        Paint paint = this.f7074a;
        canvas.drawCircle(i10, i10 + this.f7078e, i10, paint);
        int i11 = this.f7076c;
        canvas.drawCircle((i10 * 3) + i11, i10 + this.h, i10, paint);
        canvas.drawCircle((i11 * 2) + (i10 * 5), i10 + this.f7079j, i10, paint);
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        int i12 = this.f7075b;
        int i13 = (this.f7076c * 2) + (i12 * 6);
        int i14 = (i12 * 2) + this.f7077d;
        setMeasuredDimension(View.resolveSizeAndState(getPaddingRight() + getPaddingLeft() + i13, i10, 0), View.resolveSizeAndState(getPaddingBottom() + getPaddingTop() + i14, i11, 0));
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        StringBuilder sbK = com.stepos.core.ota.d.k(i10, "onVisibilityChanged=", ", isShown=");
        sbK.append(isShown());
        sbK.append(", getVisibility=");
        sbK.append(getVisibility());
        Log.d("SwimmingAnimationView", sbK.toString());
        b(i10);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        StringBuilder sbK = com.stepos.core.ota.d.k(i10, "onWindowVisibilityChanged:", ", isShown=");
        sbK.append(isShown());
        Log.d("SwimmingAnimationView", sbK.toString());
        b(i10);
    }
}
