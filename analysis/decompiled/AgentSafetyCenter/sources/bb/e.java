package bb;

import android.animation.ValueAnimator;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.animation.DecelerateInterpolator;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public int f2056a;

    /* renamed from: b, reason: collision with root package name */
    public int f2057b;

    /* renamed from: c, reason: collision with root package name */
    public int f2058c;

    /* renamed from: d, reason: collision with root package name */
    public float f2059d;

    /* renamed from: e, reason: collision with root package name */
    public float f2060e;

    /* renamed from: f, reason: collision with root package name */
    public float f2061f;

    /* renamed from: g, reason: collision with root package name */
    public Paint f2062g;

    /* renamed from: h, reason: collision with root package name */
    public int f2063h;
    public float i;

    /* renamed from: j, reason: collision with root package name */
    public float f2064j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f2065k;

    /* renamed from: l, reason: collision with root package name */
    public float f2066l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f2067m;

    /* renamed from: n, reason: collision with root package name */
    public ValueAnimator f2068n;

    /* renamed from: o, reason: collision with root package name */
    public RadialGradient f2069o;

    /* renamed from: p, reason: collision with root package name */
    public Rect f2070p;

    public final float a() {
        return this.f2065k ? this.i : getBounds().exactCenterX();
    }

    public final float b() {
        return this.f2065k ? this.f2064j : getBounds().exactCenterY();
    }

    public final float c() {
        float fA = a();
        float fB = b();
        float f5 = getBounds().left;
        float f10 = getBounds().top;
        float f11 = getBounds().right;
        float f12 = getBounds().bottom;
        double d7 = fA - f5;
        double d10 = fB - f10;
        float fHypot = (float) Math.hypot(d7, d10);
        double d11 = fA - f11;
        double d12 = fB - f12;
        float[] fArr = {(float) Math.hypot(d11, d10), (float) Math.hypot(d7, d12), (float) Math.hypot(d11, d12)};
        for (int i = 0; i < 3; i++) {
            fHypot = Math.max(fHypot, fArr[i]);
        }
        return fHypot;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r14v0 android.graphics.RadialGradient, still in use, count: 2, list:
          (r14v0 android.graphics.RadialGradient) from 0x00f7: MOVE (r17v0 android.graphics.RadialGradient) = (r14v0 android.graphics.RadialGradient) (LINE:248)
          (r14v0 android.graphics.RadialGradient) from 0x00c3: MOVE (r17v3 android.graphics.RadialGradient) = (r14v0 android.graphics.RadialGradient) (LINE:196)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:91)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:57)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
        */
    @Override // android.graphics.drawable.Drawable
    public final void draw(android.graphics.Canvas r22) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bb.e.draw(android.graphics.Canvas):void");
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
        Paint paint = this.f2062g;
        super.jumpToCurrentState();
        ValueAnimator valueAnimator = this.f2068n;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.f2068n = null;
        if (this.f2067m) {
            this.f2066l = c();
            paint.setAlpha(this.f2063h);
        } else {
            this.f2066l = 0.0f;
            paint.setAlpha(0);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        rect.getClass();
        super.onBoundsChange(rect);
        this.f2069o = null;
        this.f2070p = null;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        Paint paint = this.f2062g;
        iArr.getClass();
        boolean z10 = false;
        boolean z11 = false;
        for (int i : iArr) {
            if (i == 16842910) {
                z11 = true;
            }
            if (i == 16842919) {
                z10 = true;
            }
        }
        boolean z12 = z10 && z11;
        if (z12 == this.f2067m) {
            return super.onStateChange(iArr);
        }
        this.f2067m = z12;
        ValueAnimator valueAnimator = this.f2068n;
        if (z12) {
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.f2068n = null;
            float f5 = this.f2066l;
            paint.setAlpha(this.f2063h);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f5, c());
            valueAnimatorOfFloat.setDuration(this.f2057b);
            valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
            b bVar = new b(0);
            bVar.f2049b = this;
            VarHandle.storeStoreFence();
            valueAnimatorOfFloat.addUpdateListener(bVar);
            valueAnimatorOfFloat.start();
            this.f2068n = valueAnimatorOfFloat;
            return true;
        }
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.f2068n = null;
        float f10 = this.f2066l;
        float fC = c();
        int alpha = paint.getAlpha();
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat2.setDuration(this.f2058c);
        valueAnimatorOfFloat2.setInterpolator(new DecelerateInterpolator());
        c cVar = new c();
        cVar.f2050a = this;
        cVar.f2051b = f10;
        cVar.f2052c = fC;
        cVar.f2053d = alpha;
        VarHandle.storeStoreFence();
        valueAnimatorOfFloat2.addUpdateListener(cVar);
        valueAnimatorOfFloat2.addListener(new d(this, 0));
        valueAnimatorOfFloat2.start();
        this.f2068n = valueAnimatorOfFloat2;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.f2062g.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f2062g.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspot(float f5, float f10) {
        this.i = f5;
        this.f2064j = f10;
        this.f2065k = true;
        this.f2069o = null;
        this.f2070p = null;
    }
}
