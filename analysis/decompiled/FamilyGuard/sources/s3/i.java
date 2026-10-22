package s3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.animation.DecelerateInterpolator;

/* loaded from: classes.dex */
public final class i extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private final int f20273a;

    /* renamed from: b, reason: collision with root package name */
    private final int f20274b;

    /* renamed from: c, reason: collision with root package name */
    private final int f20275c;

    /* renamed from: d, reason: collision with root package name */
    private final float f20276d;

    /* renamed from: e, reason: collision with root package name */
    private final float f20277e;

    /* renamed from: f, reason: collision with root package name */
    private final float f20278f;

    /* renamed from: g, reason: collision with root package name */
    private final Paint f20279g;

    /* renamed from: h, reason: collision with root package name */
    private final int f20280h;

    /* renamed from: i, reason: collision with root package name */
    private float f20281i;

    /* renamed from: j, reason: collision with root package name */
    private float f20282j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f20283k;

    /* renamed from: l, reason: collision with root package name */
    private float f20284l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f20285m;

    /* renamed from: n, reason: collision with root package name */
    private ValueAnimator f20286n;

    /* renamed from: o, reason: collision with root package name */
    private RadialGradient f20287o;

    /* renamed from: p, reason: collision with root package name */
    private Rect f20288p;

    public static final class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            j4.k.g(animator, "animation");
            i.this.f20284l = 0.0f;
            i.this.f20279g.setAlpha(0);
            i.this.invalidateSelf();
        }
    }

    public i(int i5, int i6, int i7, float f5, float f6, float f7) {
        this.f20273a = i5;
        this.f20274b = i6;
        this.f20275c = i7;
        this.f20276d = f5;
        this.f20277e = f6;
        this.f20278f = f7;
        Paint paint = new Paint(1);
        this.f20279g = paint;
        this.f20280h = Color.alpha(i5);
        paint.setColor(i5);
        paint.setAlpha(0);
    }

    private final void e() {
        ValueAnimator valueAnimator = this.f20286n;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.f20286n = null;
    }

    private final float f() {
        return this.f20283k ? this.f20281i : getBounds().exactCenterX();
    }

    private final float g() {
        return this.f20283k ? this.f20282j : getBounds().exactCenterY();
    }

    private final RadialGradient h() {
        if (this.f20276d <= 0.0f || this.f20278f >= 1.0f) {
            return null;
        }
        Rect bounds = getBounds();
        j4.k.f(bounds, "getBounds(...)");
        RadialGradient radialGradient = this.f20287o;
        if (radialGradient != null && j4.k.b(this.f20288p, bounds)) {
            return radialGradient;
        }
        int i5 = this.f20273a;
        int i6 = (-16777216) | i5;
        int i7 = i5 & 16777215;
        float f5 = this.f20278f;
        RadialGradient radialGradient2 = new RadialGradient(f(), g(), i(), f5 <= 0.0f ? new int[]{i6, i7} : new int[]{i6, i6, i7}, f5 <= 0.0f ? new float[]{0.0f, 1.0f} : new float[]{0.0f, f5, 1.0f}, Shader.TileMode.CLAMP);
        this.f20287o = radialGradient2;
        this.f20288p = new Rect(bounds);
        return radialGradient2;
    }

    private final float i() {
        int iWidth = getBounds().width();
        int iHeight = getBounds().height();
        float fMin = Math.min(iWidth, iHeight) / 2.0f;
        if (this.f20277e >= fMin - 0.5f && iWidth == iHeight) {
            return fMin + ((float) Math.hypot(f() - getBounds().exactCenterX(), g() - getBounds().exactCenterY()));
        }
        float f5 = iWidth;
        float f6 = iHeight;
        return X3.a.b((float) Math.hypot(f(), g()), (float) Math.hypot(f5 - f(), g()), (float) Math.hypot(f(), f6 - g()), (float) Math.hypot(f5 - f(), f6 - g()));
    }

    private final void j() {
        e();
        float f5 = this.f20284l;
        this.f20279g.setAlpha(this.f20280h);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f5, n());
        valueAnimatorOfFloat.setDuration(this.f20274b);
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: s3.g
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                i.k(this.f20268a, valueAnimator);
            }
        });
        valueAnimatorOfFloat.start();
        this.f20286n = valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(i iVar, ValueAnimator valueAnimator) {
        j4.k.g(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        j4.k.e(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        iVar.f20284l = ((Float) animatedValue).floatValue();
        iVar.invalidateSelf();
    }

    private final void l() {
        e();
        final float f5 = this.f20284l;
        final float fN = n();
        final int alpha = this.f20279g.getAlpha();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(this.f20275c);
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: s3.h
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                i.m(this.f20269a, f5, fN, alpha, valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new a());
        valueAnimatorOfFloat.start();
        this.f20286n = valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(i iVar, float f5, float f6, int i5, ValueAnimator valueAnimator) {
        j4.k.g(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        j4.k.e(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        iVar.f20284l = f5 + ((f6 - f5) * fFloatValue);
        iVar.f20279g.setAlpha((int) (i5 * (1.0f - fFloatValue)));
        iVar.invalidateSelf();
    }

    private final float n() {
        float f5 = f();
        float fG = g();
        float f6 = getBounds().left;
        float f7 = getBounds().top;
        double d6 = f5 - f6;
        double d7 = fG - f7;
        double d8 = f5 - getBounds().right;
        double d9 = fG - getBounds().bottom;
        return X3.a.b((float) Math.hypot(d6, d7), (float) Math.hypot(d8, d7), (float) Math.hypot(d6, d9), (float) Math.hypot(d8, d9));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        j4.k.g(canvas, "canvas");
        if (this.f20279g.getAlpha() == 0 || this.f20284l <= 0.0f) {
            return;
        }
        this.f20279g.setShader(h());
        canvas.drawCircle(f(), g(), this.f20284l, this.f20279g);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        e();
        if (this.f20285m) {
            this.f20284l = n();
            this.f20279g.setAlpha(this.f20280h);
        } else {
            this.f20284l = 0.0f;
            this.f20279g.setAlpha(0);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        j4.k.g(rect, "bounds");
        super.onBoundsChange(rect);
        this.f20287o = null;
        this.f20288p = null;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        j4.k.g(iArr, "state");
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        for (int i5 : iArr) {
            if (i5 == 16842910) {
                z7 = true;
            }
            if (i5 == 16842919) {
                z6 = true;
            }
        }
        if (z6 && z7) {
            z5 = true;
        }
        if (z5 == this.f20285m) {
            return super.onStateChange(iArr);
        }
        this.f20285m = z5;
        if (z5) {
            j();
        } else {
            l();
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i5) {
        this.f20279g.setAlpha(i5);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f20279g.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f5, float f6) {
        this.f20281i = f5;
        this.f20282j = f6;
        this.f20283k = true;
        this.f20287o = null;
        this.f20288p = null;
    }
}
