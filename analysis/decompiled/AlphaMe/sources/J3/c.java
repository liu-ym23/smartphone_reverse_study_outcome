package J3;

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
import android.view.animation.PathInterpolator;
import com.airbnb.lottie.q;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public abstract class c extends Drawable {

    /* renamed from: s, reason: collision with root package name */
    public static final PathInterpolator f901s = new PathInterpolator(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, 0.1f, 1.0f);

    /* renamed from: t, reason: collision with root package name */
    public static final PathInterpolator f902t = new PathInterpolator(0.66f, Property.DEFAULT_FLOAT_VALUE, 0.67f, 1.0f);

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f903a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f904b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f905c;

    /* renamed from: d, reason: collision with root package name */
    public int f906d;

    /* renamed from: e, reason: collision with root package name */
    public int f907e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f908f;

    /* renamed from: g, reason: collision with root package name */
    public int f909g;

    /* renamed from: h, reason: collision with root package name */
    public int f910h;

    /* renamed from: i, reason: collision with root package name */
    public int f911i;

    /* renamed from: j, reason: collision with root package name */
    public final int f912j;

    /* renamed from: k, reason: collision with root package name */
    public final int f913k;

    /* renamed from: l, reason: collision with root package name */
    public int f914l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f915m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f916n = false;

    /* renamed from: o, reason: collision with root package name */
    public ValueAnimator f917o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f918p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f919q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f920r;

    public c(View view) {
        int i4 = 0;
        this.f909g = 0;
        this.f912j = 0;
        this.f913k = 0;
        if (view == null) {
            throw new IllegalArgumentException("you must use a view to create a RippleDrawableComp");
        }
        TypedArray typedArrayObtainStyledAttributes = view.getContext().obtainStyledAttributes(null, I3.a.f846f, R.attr.steposActionButtonRippleSplitStyle, 0);
        int color = typedArrayObtainStyledAttributes.getColor(4, -16777216);
        this.f914l = Color.alpha(color);
        this.f907e = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, -1);
        this.f909g = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.f915m = typedArrayObtainStyledAttributes.getBoolean(8, false);
        this.f918p = typedArrayObtainStyledAttributes.getBoolean(0, true);
        this.f919q = typedArrayObtainStyledAttributes.getBoolean(5, true);
        this.f912j = typedArrayObtainStyledAttributes.getInt(1, 160);
        this.f913k = typedArrayObtainStyledAttributes.getInt(3, 320);
        this.f920r = typedArrayObtainStyledAttributes.getBoolean(6, true);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.f904b = paint;
        paint.setColor(color);
        paint.setAlpha(this.f914l);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f905c = paint2;
        paint2.setColor(color);
        paint2.setAlpha(this.f914l / 2);
        paint2.setAntiAlias(true);
        WeakReference weakReference = new WeakReference(view);
        this.f903a = weakReference;
        this.f906d = this.f907e;
        ((View) weakReference.get()).setClickable(true);
        ((View) weakReference.get()).addOnLayoutChangeListener(new com.google.android.material.bottomappbar.a(1, this));
        ((View) weakReference.get()).post(new a(i4, this));
    }

    public static void a(c cVar) {
        View view = (View) cVar.f903a.get();
        if (view == null) {
            return;
        }
        cVar.f910h = view.getWidth();
        cVar.f911i = view.getHeight();
        new Rect(0, 0, cVar.f910h, cVar.f911i);
        if (cVar.f909g <= 0) {
            cVar.f909g = ((int) Math.hypot(cVar.f910h, cVar.f911i)) / 2;
        }
        if (cVar.f907e < 0) {
            cVar.f907e = (int) (cVar.f909g * 0.825f);
        }
    }

    public final void b() {
        ValueAnimator valueAnimator = this.f917o;
        if (valueAnimator != null && (valueAnimator.isStarted() || this.f917o.isRunning())) {
            this.f917o.cancel();
        }
        this.f904b.setAlpha(this.f914l);
        this.f908f = true;
        int i4 = this.f909g;
        this.f906d = i4;
        int i5 = this.f907e;
        float f4 = i5 / i4;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i4, i5);
        this.f917o = valueAnimatorOfInt;
        valueAnimatorOfInt.addUpdateListener(new b(this, f4));
        this.f917o.setDuration(this.f913k);
        this.f917o.setInterpolator(f902t);
        this.f917o.start();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (Build.MODEL.equals("vivo X3t")) {
            int i4 = this.f909g;
            int i5 = (this.f910h / 2) + i4;
            int i6 = (this.f911i / 2) + i4;
            setBounds(-i5, -i6, i5, i6);
        }
        if (this.f908f || this.f916n) {
            if (this.f918p) {
                canvas.drawCircle(this.f910h / 2, this.f911i / 2, this.f909g, this.f905c);
            }
            canvas.drawCircle(this.f910h / 2, this.f911i / 2, this.f906d, this.f904b);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return this.f914l;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        boolean z4 = false;
        boolean z5 = false;
        for (int i4 : iArr) {
            if (i4 == 16842910) {
                z4 = true;
            }
            if (i4 == 16842919) {
                z5 = true;
            }
        }
        if (z4 && z5) {
            this.f916n = true;
            ValueAnimator valueAnimator = this.f917o;
            if (valueAnimator != null && (valueAnimator.isStarted() || this.f917o.isRunning())) {
                this.f917o.cancel();
            }
            this.f904b.setAlpha(this.f914l);
            this.f905c.setAlpha(this.f914l / 2);
            this.f908f = true;
            int i5 = this.f907e;
            this.f906d = i5;
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i5, this.f909g);
            this.f917o = valueAnimatorOfInt;
            valueAnimatorOfInt.addUpdateListener(new q(5, this));
            this.f917o.setDuration(this.f912j);
            this.f917o.setInterpolator(f901s);
            this.f917o.start();
        } else if (this.f916n) {
            this.f916n = false;
            invalidateSelf();
            if (!this.f908f && this.f919q) {
                b();
            }
        }
        return zOnStateChange;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i4) {
        this.f914l = i4;
        this.f904b.setAlpha(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(Rect rect) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f904b.setColorFilter(colorFilter);
    }
}
