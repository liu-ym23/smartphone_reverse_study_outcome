package Gc;

import android.animation.ValueAnimator;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.stepos.ailauncher.chat.wake.circle.F;
import java.lang.ref.WeakReference;
import stepos.support.v7.appcompat.R$styleable;

/* loaded from: classes5.dex */
public class b extends Drawable {

    /* renamed from: w, reason: collision with root package name */
    public static final Interpolator f2874w = o();

    /* renamed from: x, reason: collision with root package name */
    public static final Interpolator f2875x = p();

    /* renamed from: a, reason: collision with root package name */
    public WeakReference<View> f2876a;

    /* renamed from: b, reason: collision with root package name */
    public Drawable f2877b;

    /* renamed from: c, reason: collision with root package name */
    public Paint f2878c;

    /* renamed from: d, reason: collision with root package name */
    public Paint f2879d;

    /* renamed from: g, reason: collision with root package name */
    public int f2882g;

    /* renamed from: h, reason: collision with root package name */
    public int f2883h;

    /* renamed from: i, reason: collision with root package name */
    public int f2884i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2885j;

    /* renamed from: k, reason: collision with root package name */
    public int f2886k;

    /* renamed from: l, reason: collision with root package name */
    public int f2887l;

    /* renamed from: m, reason: collision with root package name */
    public int f2888m;

    /* renamed from: n, reason: collision with root package name */
    public int f2889n;

    /* renamed from: o, reason: collision with root package name */
    public int f2890o;

    /* renamed from: p, reason: collision with root package name */
    public int f2891p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f2892q;

    /* renamed from: s, reason: collision with root package name */
    public ValueAnimator f2894s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f2895t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f2896u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f2897v;

    /* renamed from: e, reason: collision with root package name */
    public int f2880e = -16777216;

    /* renamed from: f, reason: collision with root package name */
    public int f2881f = 75;

    /* renamed from: r, reason: collision with root package name */
    public boolean f2893r = false;

    public class a implements View.OnLayoutChangeListener {
        public a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            b.this.r();
        }
    }

    /* renamed from: Gc.b$b, reason: collision with other inner class name */
    public class RunnableC0040b implements Runnable {
        public RunnableC0040b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.r();
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            b.this.f2883h = iIntValue;
            if (b.this.f2886k <= iIntValue) {
                b.this.f2885j = false;
                if (!b.this.f2893r && b.this.f2896u) {
                    b.this.t();
                }
            }
            b.this.invalidateSelf();
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f2901a;

        public d(float f10) {
            this.f2901a = f10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (b.this.f2897v) {
                b.this.f2883h = iIntValue;
            }
            if (b.this.f2884i >= iIntValue) {
                b.this.f2885j = false;
            }
            if (b.this.f2892q) {
                float f10 = this.f2901a;
                int i10 = (int) (b.this.f2891p * (((iIntValue / b.this.f2886k) - f10) / (1.0f - f10)));
                b.this.f2878c.setAlpha(i10);
                b.this.f2879d.setAlpha(i10 / 2);
            }
            b.this.invalidateSelf();
        }
    }

    public b(View view, int i10) {
        this.f2882g = -16777216;
        this.f2886k = 0;
        this.f2889n = 0;
        this.f2890o = 0;
        if (view == null) {
            throw new IllegalArgumentException("you must use a view to create a RippleDrawableComp");
        }
        TypedArray typedArrayObtainStyledAttributes = view.getContext().obtainStyledAttributes(null, R$styleable.StepOSRippleDrawableComp, i10, 0);
        int color = typedArrayObtainStyledAttributes.getColor(R$styleable.StepOSRippleDrawableComp_steposRippleColor, -16777216);
        this.f2882g = color;
        this.f2891p = Color.alpha(color);
        this.f2884i = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.StepOSRippleDrawableComp_steposStartRadius, -1);
        this.f2886k = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.StepOSRippleDrawableComp_steposMaxRadius, 0);
        this.f2892q = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StepOSRippleDrawableComp_steposUseFadeOut, false);
        this.f2895t = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StepOSRippleDrawableComp_steposAutoLightBackground, true);
        this.f2896u = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StepOSRippleDrawableComp_steposRippleFade, true);
        this.f2889n = typedArrayObtainStyledAttributes.getInt(R$styleable.StepOSRippleDrawableComp_steposInDuration, F.LOOP_END_FRAME);
        this.f2890o = typedArrayObtainStyledAttributes.getInt(R$styleable.StepOSRippleDrawableComp_steposOutDuration, 320);
        this.f2897v = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StepOSRippleDrawableComp_steposShrink, true);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.f2878c = paint;
        paint.setColor(this.f2882g);
        this.f2878c.setAlpha(this.f2891p);
        this.f2878c.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f2879d = paint2;
        paint2.setColor(this.f2882g);
        this.f2879d.setAlpha(this.f2891p / 2);
        this.f2879d.setAntiAlias(true);
        this.f2876a = new WeakReference<>(view);
        this.f2883h = this.f2884i;
        q();
    }

    public static Interpolator o() {
        return new PathInterpolator(0.0f, 0.0f, 0.1f, 1.0f);
    }

    public static Interpolator p() {
        return new PathInterpolator(0.66f, 0.0f, 0.67f, 1.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        n();
        Drawable drawable = this.f2877b;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        if (this.f2885j || this.f2893r) {
            if (this.f2895t) {
                canvas.drawCircle(this.f2887l / 2, this.f2888m / 2, this.f2886k, this.f2879d);
            }
            canvas.drawCircle(this.f2887l / 2, this.f2888m / 2, this.f2883h, this.f2878c);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f2891p;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    public final void m() {
        ValueAnimator valueAnimator = this.f2894s;
        if (valueAnimator != null) {
            if (valueAnimator.isStarted() || this.f2894s.isRunning()) {
                this.f2894s.cancel();
            }
        }
    }

    public final void n() {
        if (Build.MODEL.equals("vivo X3t")) {
            int i10 = this.f2886k;
            int i11 = this.f2887l;
            int i12 = this.f2888m;
            setBounds(-((i11 / 2) + i10), -((i12 / 2) + i10), (i11 / 2) + i10, i10 + (i12 / 2));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        boolean z10 = false;
        boolean z11 = false;
        for (int i10 : iArr) {
            if (i10 == 16842910) {
                z10 = true;
            }
            if (i10 == 16842919) {
                z11 = true;
            }
        }
        if (z10 && z11) {
            this.f2893r = true;
            s();
            return zOnStateChange;
        }
        if (this.f2893r) {
            this.f2893r = false;
            invalidateSelf();
            if (!this.f2885j && this.f2896u) {
                t();
            }
        }
        return zOnStateChange;
    }

    public void q() {
        WeakReference<View> weakReference = this.f2876a;
        if (weakReference == null) {
            return;
        }
        weakReference.get().setClickable(true);
        this.f2876a.get().addOnLayoutChangeListener(new a());
        this.f2876a.get().post(new RunnableC0040b());
    }

    public final void r() {
        View view = this.f2876a.get();
        if (view == null) {
            return;
        }
        this.f2887l = view.getWidth();
        this.f2888m = view.getHeight();
        setBounds(new Rect(0, 0, this.f2887l, this.f2888m));
        if (this.f2886k <= 0) {
            this.f2886k = ((int) Math.hypot(this.f2887l, this.f2888m)) / 2;
        }
        if (this.f2884i < 0) {
            this.f2884i = (int) (this.f2886k * 0.825f);
        }
    }

    public void s() {
        m();
        this.f2878c.setAlpha(this.f2891p);
        this.f2879d.setAlpha(this.f2891p / 2);
        this.f2885j = true;
        int i10 = this.f2884i;
        this.f2883h = i10;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i10, this.f2886k);
        this.f2894s = valueAnimatorOfInt;
        valueAnimatorOfInt.addUpdateListener(new c());
        this.f2894s.setDuration(this.f2889n);
        this.f2894s.setInterpolator(f2874w);
        this.f2894s.start();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f2891p = i10;
        this.f2878c.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        Drawable drawable = this.f2877b;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2878c.setColorFilter(colorFilter);
    }

    public void t() {
        m();
        this.f2878c.setAlpha(this.f2891p);
        this.f2885j = true;
        int i10 = this.f2886k;
        this.f2883h = i10;
        int i11 = this.f2884i;
        float f10 = i11 / i10;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i10, i11);
        this.f2894s = valueAnimatorOfInt;
        valueAnimatorOfInt.addUpdateListener(new d(f10));
        this.f2894s.setDuration(this.f2890o);
        this.f2894s.setInterpolator(f2875x);
        this.f2894s.start();
    }
}
