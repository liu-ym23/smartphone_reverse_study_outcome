package Y4;

import X4.l;
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
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class b extends Drawable {

    /* renamed from: w, reason: collision with root package name */
    private static final Interpolator f6502w = o();

    /* renamed from: x, reason: collision with root package name */
    private static final Interpolator f6503x = p();

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<View> f6504a;

    /* renamed from: b, reason: collision with root package name */
    private Drawable f6505b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f6506c;

    /* renamed from: d, reason: collision with root package name */
    private Paint f6507d;

    /* renamed from: g, reason: collision with root package name */
    private int f6510g;

    /* renamed from: h, reason: collision with root package name */
    private int f6511h;

    /* renamed from: i, reason: collision with root package name */
    private int f6512i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f6513j;

    /* renamed from: k, reason: collision with root package name */
    private int f6514k;

    /* renamed from: l, reason: collision with root package name */
    private int f6515l;

    /* renamed from: m, reason: collision with root package name */
    private int f6516m;

    /* renamed from: n, reason: collision with root package name */
    private int f6517n;

    /* renamed from: o, reason: collision with root package name */
    private int f6518o;

    /* renamed from: p, reason: collision with root package name */
    private int f6519p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f6520q;

    /* renamed from: s, reason: collision with root package name */
    private ValueAnimator f6522s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f6523t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f6524u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f6525v;

    /* renamed from: e, reason: collision with root package name */
    private int f6508e = -16777216;

    /* renamed from: f, reason: collision with root package name */
    private int f6509f = 75;

    /* renamed from: r, reason: collision with root package name */
    private boolean f6521r = false;

    class a implements View.OnLayoutChangeListener {
        a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
            b.this.r();
        }
    }

    /* renamed from: Y4.b$b, reason: collision with other inner class name */
    class RunnableC0093b implements Runnable {
        RunnableC0093b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.r();
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            b.this.f6511h = iIntValue;
            if (b.this.f6514k <= iIntValue) {
                b.this.f6513j = false;
                if (!b.this.f6521r && b.this.f6524u) {
                    b.this.t();
                }
            }
            b.this.invalidateSelf();
        }
    }

    class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f6529a;

        d(float f5) {
            this.f6529a = f5;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (b.this.f6525v) {
                b.this.f6511h = iIntValue;
            }
            if (b.this.f6512i >= iIntValue) {
                b.this.f6513j = false;
            }
            if (b.this.f6520q) {
                float f5 = this.f6529a;
                int i5 = (int) (b.this.f6519p * (((iIntValue / b.this.f6514k) - f5) / (1.0f - f5)));
                b.this.f6506c.setAlpha(i5);
                b.this.f6507d.setAlpha(i5 / 2);
            }
            b.this.invalidateSelf();
        }
    }

    public b(View view, int i5) {
        this.f6510g = -16777216;
        this.f6514k = 0;
        this.f6517n = 0;
        this.f6518o = 0;
        if (view == null) {
            throw new IllegalArgumentException("you must use a view to create a RippleDrawableComp");
        }
        TypedArray typedArrayObtainStyledAttributes = view.getContext().obtainStyledAttributes(null, l.f6279g4, i5, 0);
        int color = typedArrayObtainStyledAttributes.getColor(l.f6309l4, -16777216);
        this.f6510g = color;
        this.f6519p = Color.alpha(color);
        this.f6512i = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.f6327o4, -1);
        this.f6514k = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.f6297j4, 0);
        this.f6520q = typedArrayObtainStyledAttributes.getBoolean(l.f6333p4, false);
        this.f6523t = typedArrayObtainStyledAttributes.getBoolean(l.f6285h4, true);
        this.f6524u = typedArrayObtainStyledAttributes.getBoolean(l.f6315m4, true);
        this.f6517n = typedArrayObtainStyledAttributes.getInt(l.f6291i4, 160);
        this.f6518o = typedArrayObtainStyledAttributes.getInt(l.f6303k4, 320);
        this.f6525v = typedArrayObtainStyledAttributes.getBoolean(l.f6321n4, true);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.f6506c = paint;
        paint.setColor(this.f6510g);
        this.f6506c.setAlpha(this.f6519p);
        this.f6506c.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f6507d = paint2;
        paint2.setColor(this.f6510g);
        this.f6507d.setAlpha(this.f6519p / 2);
        this.f6507d.setAntiAlias(true);
        this.f6504a = new WeakReference<>(view);
        this.f6511h = this.f6512i;
        q();
    }

    private void m() {
        ValueAnimator valueAnimator = this.f6522s;
        if (valueAnimator != null) {
            if (valueAnimator.isStarted() || this.f6522s.isRunning()) {
                this.f6522s.cancel();
            }
        }
    }

    private void n() {
        if (Build.MODEL.equals("vivo X3t")) {
            int i5 = this.f6514k;
            int i6 = this.f6515l;
            int i7 = this.f6516m;
            setBounds(-((i6 / 2) + i5), -((i7 / 2) + i5), (i6 / 2) + i5, i5 + (i7 / 2));
        }
    }

    private static Interpolator o() {
        return new PathInterpolator(0.0f, 0.0f, 0.1f, 1.0f);
    }

    private static Interpolator p() {
        return new PathInterpolator(0.66f, 0.0f, 0.67f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        View view = this.f6504a.get();
        if (view == null) {
            return;
        }
        this.f6515l = view.getWidth();
        this.f6516m = view.getHeight();
        setBounds(new Rect(0, 0, this.f6515l, this.f6516m));
        if (this.f6514k <= 0) {
            this.f6514k = ((int) Math.hypot(this.f6515l, this.f6516m)) / 2;
        }
        if (this.f6512i < 0) {
            this.f6512i = (int) (this.f6514k * 0.825f);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        n();
        Drawable drawable = this.f6505b;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        if (this.f6513j || this.f6521r) {
            if (this.f6523t) {
                canvas.drawCircle(this.f6515l / 2, this.f6516m / 2, this.f6514k, this.f6507d);
            }
            canvas.drawCircle(this.f6515l / 2, this.f6516m / 2, this.f6511h, this.f6506c);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f6519p;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        boolean z5 = false;
        boolean z6 = false;
        for (int i5 : iArr) {
            if (i5 == 16842910) {
                z5 = true;
            }
            if (i5 == 16842919) {
                z6 = true;
            }
        }
        if (z5 && z6) {
            this.f6521r = true;
            s();
            return zOnStateChange;
        }
        if (this.f6521r) {
            this.f6521r = false;
            invalidateSelf();
            if (!this.f6513j && this.f6524u) {
                t();
            }
        }
        return zOnStateChange;
    }

    public void q() {
        WeakReference<View> weakReference = this.f6504a;
        if (weakReference == null) {
            return;
        }
        weakReference.get().setClickable(true);
        this.f6504a.get().addOnLayoutChangeListener(new a());
        this.f6504a.get().post(new RunnableC0093b());
    }

    public void s() {
        m();
        this.f6506c.setAlpha(this.f6519p);
        this.f6507d.setAlpha(this.f6519p / 2);
        this.f6513j = true;
        int i5 = this.f6512i;
        this.f6511h = i5;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i5, this.f6514k);
        this.f6522s = valueAnimatorOfInt;
        valueAnimatorOfInt.addUpdateListener(new c());
        this.f6522s.setDuration(this.f6517n);
        this.f6522s.setInterpolator(f6502w);
        this.f6522s.start();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i5) {
        this.f6519p = i5;
        this.f6506c.setAlpha(i5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        Drawable drawable = this.f6505b;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f6506c.setColorFilter(colorFilter);
    }

    public void t() {
        m();
        this.f6506c.setAlpha(this.f6519p);
        this.f6513j = true;
        int i5 = this.f6514k;
        this.f6511h = i5;
        int i6 = this.f6512i;
        float f5 = i6 / i5;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i5, i6);
        this.f6522s = valueAnimatorOfInt;
        valueAnimatorOfInt.addUpdateListener(new d(f5));
        this.f6522s.setDuration(this.f6518o);
        this.f6522s.setInterpolator(f6503x);
        this.f6522s.start();
    }
}
