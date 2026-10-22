package Sa;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.animation.PathInterpolator;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public abstract class c extends Drawable {

    /* renamed from: s, reason: collision with root package name */
    public static final PathInterpolator f1186s = new PathInterpolator(0.0f, 0.0f, 0.1f, 1.0f);

    /* renamed from: t, reason: collision with root package name */
    public static final PathInterpolator f1187t = new PathInterpolator(0.66f, 0.0f, 0.67f, 1.0f);

    /* renamed from: a, reason: collision with root package name */
    public WeakReference f1188a;
    public Paint b;
    public Paint c;
    public int d;
    public int e;
    public boolean f;
    public int g;
    public int h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f1189j;
    public int k;
    public int l;
    public boolean m;
    public boolean n;
    public ValueAnimator o;
    public boolean p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f1190q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f1191r;

    public static void a(c cVar) {
        View view = (View) cVar.f1188a.get();
        if (view == null) {
            return;
        }
        cVar.h = view.getWidth();
        cVar.i = view.getHeight();
        new Rect(0, 0, cVar.h, cVar.i);
        if (cVar.g <= 0) {
            cVar.g = ((int) Math.hypot(cVar.h, cVar.i)) / 2;
        }
        if (cVar.e < 0) {
            cVar.e = (int) (cVar.g * 0.825f);
        }
    }

    public final void b() {
        ValueAnimator valueAnimator = this.o;
        if (valueAnimator != null && (valueAnimator.isStarted() || this.o.isRunning())) {
            this.o.cancel();
        }
        this.b.setAlpha(this.l);
        this.f = true;
        int i = this.g;
        this.d = i;
        int i6 = this.e;
        float f = i6 / i;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i, i6);
        this.o = valueAnimatorOfInt;
        valueAnimatorOfInt.addUpdateListener(new b(this, f));
        this.o.setDuration(this.k);
        this.o.setInterpolator(f1187t);
        this.o.start();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (Build.MODEL.equals("vivo X3t")) {
            int i = this.g;
            int i6 = (this.h / 2) + i;
            int i10 = (this.i / 2) + i;
            setBounds(-i6, -i10, i6, i10);
        }
        if (this.f || this.n) {
            if (this.p) {
                canvas.drawCircle(this.h / 2, this.i / 2, this.g, this.c);
            }
            canvas.drawCircle(this.h / 2, this.i / 2, this.d, this.b);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return this.l;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        boolean z10 = false;
        boolean z11 = false;
        for (int i : iArr) {
            if (i == 16842910) {
                z10 = true;
            }
            if (i == 16842919) {
                z11 = true;
            }
        }
        if (!z10 || !z11) {
            if (this.n) {
                this.n = false;
                invalidateSelf();
                if (!this.f && this.f1190q) {
                    b();
                }
            }
            return zOnStateChange;
        }
        this.n = true;
        ValueAnimator valueAnimator = this.o;
        if (valueAnimator != null && (valueAnimator.isStarted() || this.o.isRunning())) {
            this.o.cancel();
        }
        this.b.setAlpha(this.l);
        this.c.setAlpha(this.l / 2);
        this.f = true;
        int i6 = this.e;
        this.d = i6;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i6, this.g);
        this.o = valueAnimatorOfInt;
        valueAnimatorOfInt.addUpdateListener(new J4.c(this, 1));
        this.o.setDuration(this.f1189j);
        this.o.setInterpolator(f1186s);
        this.o.start();
        return zOnStateChange;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.l = i;
        this.b.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(Rect rect) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
    }
}
