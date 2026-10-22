package com.bytedance.android.ecom.live.adapter.impl.views;

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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes44.dex */
public class CircularProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f51187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f51188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RectF f51189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f51190d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f51191e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f51192f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f51193g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f51194h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f51195i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f51196j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f51197k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f51198l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f51199m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f51200n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f51201o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public List<jr.e> f51202p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f51203q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f51204r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ValueAnimator f51205s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ValueAnimator f51206t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public AnimatorSet f51207u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f51208v;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CircularProgressView f51209a;

        public a(CircularProgressView r100) {
            this.f51209a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            CircularProgressView r101 = this.f51209a;
            r101.f51204r = ((Float) r100.getAnimatedValue()).floatValue();
            this.f51209a.invalidate();
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CircularProgressView f51210a;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Iterator r101 = ((ArrayList) this.f51210a.f51202p).iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((jr.e) r101.next()).c();
            goto L4
        }

        public b(CircularProgressView r100, float r101) {
            this.f51210a = r100;
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CircularProgressView f51211a;

        public c(CircularProgressView r100) {
            this.f51211a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            CircularProgressView r101 = this.f51211a;
            r101.f51203q = ((Float) r100.getAnimatedValue()).floatValue();
            this.f51211a.invalidate();
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CircularProgressView f51212a;

        public d(CircularProgressView r100) {
            this.f51212a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            CircularProgressView r101 = this.f51212a;
            r101.f51204r = ((Float) r100.getAnimatedValue()).floatValue();
            this.f51212a.invalidate();
        }
    }

    public class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f51213a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CircularProgressView f51214b;

        public e(CircularProgressView r100) {
            this.f51214b = r100;
            this.f51213a = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            this.f51213a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            if (this.f51213a == true) goto L6;
            this.f51214b.b();
            return;
        }
    }

    public final void b() {
        ValueAnimator r100 = this.f51205s;
        if (r100 != null) goto L5;
    L7:
        ValueAnimator r101 = this.f51206t;
        if (r101 != null) goto L10;
    L12:
        AnimatorSet r102 = this.f51207u;
        if (r102 != null) goto L15;
    L17:
        float r103 = 360.0f;
        if (this.f51190d == true) goto L20;
        float r104 = this.f51208v;
        this.f51203q = r104;
        ValueAnimator r105 = ValueAnimator.ofFloat(new float[]{r104, r104 + 360.0f});
        this.f51205s = r105;
        r105.setDuration(this.f51199m);
        this.f51205s.setInterpolator(new DecelerateInterpolator(2.0f));
        this.f51205s.addUpdateListener(new c(this));
        this.f51205s.start();
        this.f51204r = 0.0f;
        ValueAnimator r106 = ValueAnimator.ofFloat(new float[]{0.0f, this.f51192f});
        this.f51206t = r106;
        r106.setDuration(this.f51200n);
        this.f51206t.setInterpolator(new LinearInterpolator());
        this.f51206t.addUpdateListener(new d(this));
        this.f51206t.start();
        return;
    L20:
        this.f51194h = 15.0f;
        this.f51207u = new AnimatorSet();
        AnimatorSet r107 = null;
        int r108 = 0;
    L21:
        int r109 = this.f51201o;
        if (r108 >= r109) goto L27;
        float r110 = r108;
        float r111 = (((r109 - 1) * r103) / r109) + 15.0f;
        float r112 = ((r111 - 15.0f) * r110) - 90.0f;
        ValueAnimator r113 = ValueAnimator.ofFloat(new float[]{15.0f, r111});
        r113.setDuration((this.f51198l / this.f51201o) / 2);
        r113.setInterpolator(new DecelerateInterpolator(1.0f));
        r113.addUpdateListener(new jr.a(this));
        float r114 = this.f51201o;
        float r115 = (0.5f + r110) * 720.0f;
        ValueAnimator r116 = ValueAnimator.ofFloat(new float[]{(r110 * 720.0f) / r114, r115 / r114});
        r116.setDuration((this.f51198l / this.f51201o) / 2);
        r116.setInterpolator(new LinearInterpolator());
        r116.addUpdateListener(new jr.b(this));
        ValueAnimator r117 = ValueAnimator.ofFloat(new float[]{r112, (r112 + r111) - 15.0f});
        r117.setDuration((this.f51198l / this.f51201o) / 2);
        r117.setInterpolator(new DecelerateInterpolator(1.0f));
        r117.addUpdateListener(new jr.c(this, r111, r112));
        float r118 = this.f51201o;
        ValueAnimator r119 = ValueAnimator.ofFloat(new float[]{r115 / r118, ((r110 + 1.0f) * 720.0f) / r118});
        r119.setDuration((this.f51198l / this.f51201o) / 2);
        r119.setInterpolator(new LinearInterpolator());
        r119.addUpdateListener(new jr.d(this));
        AnimatorSet r120 = new AnimatorSet();
        r120.play(r113).with(r116);
        r120.play(r117).with(r119).after(r116);
        AnimatorSet.Builder r121 = this.f51207u.play(r120);
        if (r107 == null) goto L26;
        r121.after(r107);
    L26:
        r108 = r108 + 1;
        r107 = r120;
        r103 = 360.0f;
        goto L21
    L27:
        this.f51207u.addListener(new e(this));
        this.f51207u.start();
        Iterator r122 = ((ArrayList) this.f51202p).iterator();
    L29:
        if (r122.hasNext() == false) goto L36;
        ((jr.e) r122.next()).d();
        goto L29
    L36:
        return;
    L15:
        if (r102.isRunning() == false) goto L17;
        this.f51207u.cancel();
        goto L17
    L10:
        if (r101.isRunning() == false) goto L12;
        this.f51206t.cancel();
        goto L12
    L5:
        if (r100.isRunning() == false) goto L7;
        this.f51205s.cancel();
        goto L7
    }

    public final void d() {
        this.f51187a.setColor(this.f51197k);
        this.f51187a.setStyle(Paint.Style.STROKE);
        this.f51187a.setStrokeWidth(this.f51196j);
        this.f51187a.setStrokeCap(Paint.Cap.BUTT);
    }

    public final void c() {
        int r100 = getPaddingLeft();
        int r101 = getPaddingTop();
        RectF r102 = this.f51189c;
        int r103 = this.f51196j;
        int r104 = this.f51188b;
        r102.set(r100 + r103, r101 + r103, (r104 - r100) - r103, (r104 - r101) - r103);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f51191e == false) goto L6;
        b();
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator r100 = this.f51205s;
        if (r100 == null) goto L5;
        r100.cancel();
        this.f51205s = null;
    L5:
        ValueAnimator r101 = this.f51206t;
        if (r101 == null) goto L8;
        r101.cancel();
        this.f51206t = null;
    L8:
        AnimatorSet r102 = this.f51207u;
        if (r102 == null) goto L12;
        r102.cancel();
        this.f51207u = null;
        return;
    }

    public int getColor() {
        return this.f51197k;
    }

    public float getMaxProgress() {
        return this.f51193g;
    }

    public float getProgress() {
        return this.f51192f;
    }

    public int getThickness() {
        return this.f51196j;
    }

    public CircularProgressView(Context r100) {
        super(r100);
        this.f51188b = 0;
        a(null, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        if (isInEditMode() == false) goto L5;
        float r100 = this.f51192f;
    L6:
        float r101 = (r100 / this.f51193g) * 360.0f;
        if (this.f51190d == true) goto L9;
        r110.drawArc(this.f51189c, this.f51203q, r101, false, this.f51187a);
        return;
    L9:
        r110.drawArc(this.f51189c, this.f51203q + this.f51195i, this.f51194h, false, this.f51187a);
        return;
    L5:
        r100 = this.f51204r;
        goto L6
    }

    public void setColor(int r100) {
        this.f51197k = r100;
        d();
        invalidate();
    }

    public void setIndeterminate(boolean r100) {
        boolean r101 = this.f51190d;
        if (r101 != r100) goto L5;
        boolean r102 = true;
    L6:
        this.f51190d = r100;
        if (r102 == false) goto L9;
        b();
    L9:
        if (r101 == r100) goto L14;
        Iterator r103 = ((ArrayList) this.f51202p).iterator();
    L12:
        if (r103.hasNext() == false) goto L16;
        ((jr.e) r103.next()).b();
        goto L12
    L16:
        return;
    L14:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public void setMaxProgress(float r100) {
        this.f51193g = r100;
        invalidate();
    }

    public void setProgress(float r100) {
        this.f51192f = r100;
        if (this.f51190d == true) goto L10;
        ValueAnimator r101 = this.f51206t;
        if (r101 != null) goto L7;
    L9:
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{this.f51204r, r100});
        this.f51206t = r102;
        r102.setDuration(this.f51200n);
        this.f51206t.setInterpolator(new LinearInterpolator());
        this.f51206t.addUpdateListener(new a(this));
        this.f51206t.addListener(new b(this, r100));
        this.f51206t.start();
        goto L10
    L7:
        if (r101.isRunning() == false) goto L9;
        this.f51206t.cancel();
    L10:
        invalidate();
        Iterator r103 = ((ArrayList) this.f51202p).iterator();
    L12:
        if (r103.hasNext() == false) goto L14;
        ((jr.e) r103.next()).a();
        goto L12
    }

    public void setThickness(int r100) {
        this.f51196j = r100;
        d();
        c();
        invalidate();
    }

    public CircularProgressView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f51188b = 0;
        a(r101, 0);
    }

    public final void a(AttributeSet r100, int r101) {
        this.f51202p = new ArrayList();
        TypedArray r102 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.cpv_animAutostart, R.attr.cpv_animDuration, R.attr.cpv_animSteps, R.attr.cpv_animSwoopDuration, R.attr.cpv_animSyncDuration, R.attr.cpv_color, R.attr.cpv_indeterminate, R.attr.cpv_maxProgress, R.attr.cpv_progress, R.attr.cpv_startAngle, R.attr.cpv_thickness}, r101, 0);
        Resources r103 = getResources();
        this.f51192f = r102.getFloat(8, r103.getInteger(R.integer.cpv_default_progress));
        this.f51193g = r102.getFloat(7, r103.getInteger(R.integer.cpv_default_max_progress));
        this.f51196j = r102.getDimensionPixelSize(10, r103.getDimensionPixelSize(R.dimen.cpv_default_thickness));
        this.f51190d = r102.getBoolean(6, r103.getBoolean(R.bool.cpv_default_is_indeterminate));
        this.f51191e = r102.getBoolean(0, r103.getBoolean(R.bool.cpv_default_anim_autostart));
        float r104 = r102.getFloat(9, r103.getInteger(R.integer.cpv_default_start_angle));
        this.f51208v = r104;
        this.f51203q = r104;
        int r105 = getContext().getResources().getIdentifier("colorAccent", SlcElement.KEY_ATTR, getContext().getPackageName());
        if (r102.hasValue(5) == false) goto L5;
        this.f51197k = r102.getColor(5, r103.getColor(R.color.cpv_default_color));
    L8:
        this.f51198l = r102.getInteger(1, r103.getInteger(R.integer.cpv_default_anim_duration));
        this.f51199m = r102.getInteger(3, r103.getInteger(R.integer.cpv_default_anim_swoop_duration));
        this.f51200n = r102.getInteger(4, r103.getInteger(R.integer.cpv_default_anim_sync_duration));
        this.f51201o = r102.getInteger(2, r103.getInteger(R.integer.cpv_default_anim_steps));
        r102.recycle();
        this.f51187a = new Paint(1);
        d();
        this.f51189c = new RectF();
        return;
    L5:
        if (r105 == 0) goto L7;
        TypedValue r106 = new TypedValue();
        getContext().getTheme().resolveAttribute(r105, r106, true);
        this.f51197k = r106.data;
        goto L8
    L7:
        TypedArray r107 = getContext().obtainStyledAttributes(new int[]{android.R.attr.colorAccent});
        this.f51197k = r107.getColor(0, r103.getColor(R.color.cpv_default_color));
        r107.recycle();
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
        this.f51188b = r104;
        setMeasuredDimension(r102 + r104, r104 + r103);
    }

    public CircularProgressView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f51188b = 0;
        a(r101, r102);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 < r101) goto L6;
        r100 = r101;
    L6:
        this.f51188b = r100;
        c();
    }
}
