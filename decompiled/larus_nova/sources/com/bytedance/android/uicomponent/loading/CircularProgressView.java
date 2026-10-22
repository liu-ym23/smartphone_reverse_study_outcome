package com.bytedance.android.uicomponent.loading;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.larus.nova.R;
import km3.b;
import km3.c;
import km3.d;

/* JADX INFO: loaded from: classes14.dex */
public class CircularProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f187693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f187694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RectF f187695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f187696d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f187697e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f187698f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f187699g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f187700h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f187701i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f187702j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f187703k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f187704l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f187705m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f187706n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f187707o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f187708p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public AnimatorSet f187709q;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f187710a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CircularProgressView f187711b;

        public a(CircularProgressView r100) {
            this.f187711b = r100;
            this.f187710a = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            this.f187710a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            if (this.f187710a == true) goto L6;
            this.f187711b.b();
            return;
        }
    }

    public final void c() {
        this.f187698f = false;
        AnimatorSet r100 = this.f187709q;
        if (r100 == null) goto L6;
        r100.cancel();
        this.f187709q = null;
        return;
    }

    public final void b() {
        if (this.f187699g == true) goto L6;
        this.f187698f = true;
        return;
    L6:
        this.f187698f = false;
        AnimatorSet r100 = this.f187709q;
        if (r100 == null) goto L12;
        if (r100.isRunning() == false) goto L12;
        this.f187709q.cancel();
    L12:
        if (this.f187696d == false) goto L25;
        float r101 = 15.0f;
        this.f187702j = 15.0f;
        this.f187709q = new AnimatorSet();
        AnimatorSet r102 = null;
        int r103 = 0;
    L14:
        int r104 = this.f187707o;
        if (r103 >= r104) goto L20;
        float r105 = r103;
        float r106 = (((r104 - 1) * 360.0f) / r104) + r101;
        float r107 = ((r106 - r101) * r105) - 90.0f;
        ValueAnimator r110 = ValueAnimator.ofFloat(new float[]{r101, r106});
        r110.setDuration((this.f187706n / this.f187707o) / 2);
        r110.setInterpolator(new DecelerateInterpolator(1.0f));
        r110.addUpdateListener(new km3.a(this));
        float r111 = this.f187707o;
        float r112 = (0.5f + r105) * 720.0f;
        ValueAnimator r113 = ValueAnimator.ofFloat(new float[]{(r105 * 720.0f) / r111, r112 / r111});
        r113.setDuration((this.f187706n / this.f187707o) / 2);
        r113.setInterpolator(new LinearInterpolator());
        r113.addUpdateListener(new b(this));
        ValueAnimator r114 = ValueAnimator.ofFloat(new float[]{r107, (r107 + r106) - r101});
        AnimatorSet r115 = r102;
        r114.setDuration((this.f187706n / this.f187707o) / 2);
        r114.setInterpolator(new DecelerateInterpolator(1.0f));
        r114.addUpdateListener(new c(this, r106, r107));
        float r108 = this.f187707o;
        ValueAnimator r109 = ValueAnimator.ofFloat(new float[]{r112 / r108, ((r105 + 1.0f) * 720.0f) / r108});
        r109.setDuration((this.f187706n / this.f187707o) / 2);
        r109.setInterpolator(new LinearInterpolator());
        r109.addUpdateListener(new d(this));
        r102 = new AnimatorSet();
        r102.play(r110).with(r113);
        r102.play(r114).with(r109).after(r113);
        AnimatorSet.Builder r116 = this.f187709q.play(r102);
        if (r115 == null) goto L19;
        r116.after(r115);
    L19:
        r103 = r103 + 1;
        r101 = 15.0f;
        goto L14
    L20:
        this.f187709q.addListener(new a(this));
        this.f187709q.start();
        return;
    }

    public final void e() {
        this.f187693a.setColor(this.f187705m);
        this.f187693a.setStyle(Paint.Style.STROKE);
        this.f187693a.setStrokeWidth(this.f187704l);
        this.f187693a.setStrokeCap(Paint.Cap.ROUND);
    }

    public final void d() {
        int r100 = getPaddingLeft();
        int r101 = getPaddingTop();
        RectF r102 = this.f187695c;
        int r103 = this.f187704l;
        int r104 = this.f187694b;
        r102.set(r100 + r103, r101 + r103, (r104 - r100) - r103, (r104 - r101) - r103);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f187699g = true;
        if (this.f187697e == false) goto L5;
    L6:
        b();
        return;
    L5:
        if (this.f187698f == true) goto L6;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f187699g = false;
        c();
    }

    public int getColor() {
        return this.f187705m;
    }

    public float getMaxProgress() {
        return this.f187701i;
    }

    public float getProgress() {
        return this.f187700h;
    }

    public int getThickness() {
        return this.f187704l;
    }

    public CircularProgressView(Context r100) {
        super(r100);
        this.f187694b = 0;
        a(null, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        isInEditMode();
        float r100 = (this.f187700h / this.f187701i) * 360.0f;
        if (this.f187696d == true) goto L5;
        r110.drawArc(this.f187695c, this.f187708p, r100, false, this.f187693a);
        return;
    L5:
        r110.drawArc(this.f187695c, this.f187708p + this.f187703k, this.f187702j, false, this.f187693a);
    }

    public void setColor(int r100) {
        this.f187705m = r100;
        e();
        invalidate();
    }

    public void setIndeterminate(boolean r100) {
        if (this.f187696d == r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        this.f187696d = r100;
        b();
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public void setMaxProgress(float r100) {
        this.f187701i = r100;
        invalidate();
    }

    public void setProgress(float r100) {
        this.f187700h = r100;
        if (this.f187696d == false) goto L5;
    L5:
        invalidate();
    }

    public void setThickness(int r100) {
        this.f187704l = r100;
        e();
        d();
        invalidate();
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        int r101 = getVisibility();
        super.setVisibility(r100);
        if (r100 == r101) goto L12;
        if (r100 != 0) goto L7;
        b();
        return;
    L7:
        if (r100 != 8) goto L9;
    L10:
        c();
        return;
    L9:
        if (r100 == 4) goto L10;
        return;
    }

    public CircularProgressView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f187694b = 0;
        a(r101, 0);
    }

    public final void a(AttributeSet r100, int r101) {
        TypedArray r102 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.cpv_animAutostart, R.attr.cpv_animDuration, R.attr.cpv_animSteps, R.attr.cpv_animSwoopDuration, R.attr.cpv_animSyncDuration, R.attr.cpv_color, R.attr.cpv_indeterminate, R.attr.cpv_maxProgress, R.attr.cpv_progress, R.attr.cpv_startAngle, R.attr.cpv_thickness}, r101, 0);
        Resources r103 = getResources();
        this.f187700h = r102.getFloat(8, r103.getInteger(R.integer.cpv_default_progress));
        this.f187701i = r102.getFloat(7, r103.getInteger(R.integer.cpv_default_max_progress));
        this.f187704l = r102.getDimensionPixelSize(10, r103.getDimensionPixelSize(R.dimen.cpv_default_thickness));
        this.f187696d = r102.getBoolean(6, r103.getBoolean(R.bool.cpv_default_is_indeterminate));
        this.f187697e = r102.getBoolean(0, r103.getBoolean(R.bool.cpv_default_anim_autostart));
        this.f187708p = r102.getFloat(9, r103.getInteger(R.integer.cpv_default_start_angle));
        int r104 = getContext().getResources().getIdentifier("colorAccent", SlcElement.KEY_ATTR, getContext().getPackageName());
        if (r102.hasValue(5) == false) goto L5;
        this.f187705m = r102.getColor(5, r103.getColor(R.color.uicomponent_cus_cpv_default_color));
    L8:
        this.f187706n = r102.getInteger(1, r103.getInteger(R.integer.cpv_default_anim_duration));
        r102.getInteger(3, r103.getInteger(R.integer.cpv_default_anim_swoop_duration));
        r102.getInteger(4, r103.getInteger(R.integer.cpv_default_anim_sync_duration));
        this.f187707o = r102.getInteger(2, r103.getInteger(R.integer.cpv_default_anim_steps));
        r102.recycle();
        this.f187693a = new Paint(1);
        e();
        this.f187695c = new RectF();
        return;
    L5:
        if (r104 == 0) goto L7;
        TypedValue r105 = new TypedValue();
        getContext().getTheme().resolveAttribute(r104, r105, true);
        this.f187705m = r105.data;
        goto L8
    L7:
        TypedArray r106 = getContext().obtainStyledAttributes(new int[]{android.R.attr.colorAccent});
        this.f187705m = r106.getColor(0, r103.getColor(R.color.uicomponent_cus_cpv_default_color));
        r106.recycle();
        goto L8
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = getPaddingLeft() + getPaddingRight();
        int r103 = getPaddingTop() + getPaddingBottom();
        int r104 = getMeasuredWidth() - r102;
        int r105 = getMeasuredHeight() - r103;
        if (r104 < r105) goto L6;
        r104 = r105;
    L6:
        this.f187694b = r104;
        setMeasuredDimension(r102 + r104, r104 + r103);
    }

    public CircularProgressView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f187694b = 0;
        a(r101, r102);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 < r101) goto L6;
        r100 = r101;
    L6:
        this.f187694b = r100;
        d();
    }
}
