package E6;

import A6.m;
import N9.j;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.animation.DecelerateInterpolator;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class g extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public final int f486a;
    public final int b;
    public final int c;
    public final float d;
    public final float e;
    public final float f;
    public final Paint g;
    public final int h;
    public float i;

    /* renamed from: j, reason: collision with root package name */
    public float f487j;
    public boolean k;
    public float l;
    public boolean m;
    public ValueAnimator n;
    public RadialGradient o;
    public Rect p;

    public g(float f, int i, float f7, int i6, float f9, int i10) {
        this.f486a = i;
        this.b = i6;
        this.c = i10;
        this.d = f;
        this.e = f7;
        this.f = f9;
        Paint paint = new Paint(1);
        this.g = paint;
        this.h = Color.alpha(i);
        paint.setColor(i);
        paint.setAlpha(0);
    }

    public final float a() {
        return this.k ? this.i : getBounds().exactCenterX();
    }

    public final float b() {
        return this.k ? this.f487j : getBounds().exactCenterY();
    }

    public final float c() {
        float fA = a();
        float fB = b();
        float f = getBounds().left;
        float f7 = getBounds().top;
        double d = fA - f;
        double d6 = fB - f7;
        double d10 = fA - getBounds().right;
        double d11 = fB - getBounds().bottom;
        return j.K((float) Math.hypot(d, d6), (float) Math.hypot(d10, d6), (float) Math.hypot(d, d11), (float) Math.hypot(d10, d11));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r15v0 android.graphics.RadialGradient, still in use, count: 2, list:
          (r15v0 android.graphics.RadialGradient) from 0x00fd: MOVE (r18v0 android.graphics.RadialGradient) = (r15v0 android.graphics.RadialGradient)
          (r15v0 android.graphics.RadialGradient) from 0x00c9: MOVE (r18v3 android.graphics.RadialGradient) = (r15v0 android.graphics.RadialGradient)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:91)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:57)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
        */
    @Override // android.graphics.drawable.Drawable
    public final void draw(android.graphics.Canvas r23) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: E6.g.draw(android.graphics.Canvas):void");
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void jumpToCurrentState() {
        super.jumpToCurrentState();
        ValueAnimator valueAnimator = this.n;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.n = null;
        boolean z10 = this.m;
        Paint paint = this.g;
        if (z10) {
            this.l = c();
            paint.setAlpha(this.h);
        } else {
            this.l = 0.0f;
            paint.setAlpha(0);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect bounds) {
        k.f(bounds, "bounds");
        super.onBoundsChange(bounds);
        this.o = null;
        this.p = null;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] state) {
        k.f(state, "state");
        boolean z10 = false;
        boolean z11 = false;
        for (int i : state) {
            if (i == 16842910) {
                z11 = true;
            }
            if (i == 16842919) {
                z10 = true;
            }
        }
        boolean z12 = z10 && z11;
        if (z12 == this.m) {
            return super.onStateChange(state);
        }
        this.m = z12;
        Paint paint = this.g;
        if (z12) {
            ValueAnimator valueAnimator = this.n;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.n = null;
            float f = this.l;
            paint.setAlpha(this.h);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, c());
            valueAnimatorOfFloat.setDuration(this.b);
            valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
            valueAnimatorOfFloat.addUpdateListener(new A6.j(this, 1));
            valueAnimatorOfFloat.start();
            this.n = valueAnimatorOfFloat;
            return true;
        }
        ValueAnimator valueAnimator2 = this.n;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        this.n = null;
        final float f7 = this.l;
        final float fC = c();
        final int alpha = paint.getAlpha();
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat2.setDuration(this.c);
        valueAnimatorOfFloat2.setInterpolator(new DecelerateInterpolator());
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: E6.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator animation) {
                k.f(animation, "animation");
                Object animatedValue = animation.getAnimatedValue();
                k.d(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                float fFloatValue = ((Float) animatedValue).floatValue();
                float f9 = fC;
                float f10 = f7;
                float fB = B7.a.b(f9, f10, fFloatValue, f10);
                g gVar = this.f485a;
                gVar.l = fB;
                gVar.g.setAlpha((int) ((1.0f - fFloatValue) * alpha));
                gVar.invalidateSelf();
            }
        });
        valueAnimatorOfFloat2.addListener(new m(this, 1));
        valueAnimatorOfFloat2.start();
        this.n = valueAnimatorOfFloat2;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.g.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.g.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspot(float f, float f7) {
        this.i = f;
        this.f487j = f7;
        this.k = true;
        this.o = null;
        this.p = null;
    }
}
