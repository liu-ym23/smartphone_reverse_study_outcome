package com.stepos.common.animator;

import android.R;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.PathInterpolator;
import androidx.appcompat.widget.z0;
import com.google.android.material.appbar.h;
import org.xmlpull.v1.XmlPullParser;
import y4.i;
import y4.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class StepOSPressAnimationDrawable extends StateListDrawable {
    public static final PathInterpolator F = new PathInterpolator(0.4f, 0.0f, 0.58f, 1.0f);
    public int B;
    public int C;
    public int D;
    public int E;

    /* renamed from: a, reason: collision with root package name */
    public y4.g f6424a;

    /* renamed from: c, reason: collision with root package name */
    public int f6426c;

    /* renamed from: d, reason: collision with root package name */
    public int f6427d;

    /* renamed from: e, reason: collision with root package name */
    public float f6428e;
    public int h;

    /* renamed from: j, reason: collision with root package name */
    public boolean f6429j;

    /* renamed from: k, reason: collision with root package name */
    public ValueAnimator f6430k;

    /* renamed from: l, reason: collision with root package name */
    public ValueAnimator f6431l;

    /* renamed from: m, reason: collision with root package name */
    public h1.f f6432m;

    /* renamed from: u, reason: collision with root package name */
    public int f6439u;

    /* renamed from: v, reason: collision with root package name */
    public int f6440v;

    /* renamed from: y, reason: collision with root package name */
    public boolean f6443y;
    public final boolean z;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f6425b = new Rect();
    public int r = 0;

    /* renamed from: n, reason: collision with root package name */
    public float f6433n = 1.0f;

    /* renamed from: o, reason: collision with root package name */
    public float f6434o = 1.0f;

    /* renamed from: s, reason: collision with root package name */
    public int f6437s = -16777216;

    /* renamed from: q, reason: collision with root package name */
    public float f6436q = 0.0f;

    /* renamed from: p, reason: collision with root package name */
    public float f6435p = 0.03f;

    /* renamed from: t, reason: collision with root package name */
    public boolean f6438t = true;
    public boolean A = false;

    /* renamed from: w, reason: collision with root package name */
    public int f6441w = 0;

    /* renamed from: x, reason: collision with root package name */
    public int f6442x = 0;

    static {
        x0.a.a(0.33f, 0.0f, 0.67f, 1.0f);
    }

    public StepOSPressAnimationDrawable() {
        this.z = true;
        addState(new int[]{R.attr.state_pressed}, new a());
        addState(new int[0], new a());
        try {
            Canvas canvas = new Canvas();
            l8.e.a(canvas).a("setNightModeUseOf", Integer.TYPE).a(canvas, 2);
        } catch (Exception e10) {
            Log.e("StepOSSPressDrawable", "setNightModeUseOf error " + e10);
            this.z = false;
        }
    }

    public static void b(h1.f fVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            fVar.h();
            return;
        }
        Log.w("StepOSSPressDrawable", "Your looper is not on MainLooper, force run on MainLooper now, and trace:" + Log.getStackTraceString(new Throwable()));
        new Handler(Looper.getMainLooper()).post(new z0(fVar, 11));
    }

    public final void a() {
        j.a aVar = new j.a();
        i iVar = new i();
        aVar.f14073a = iVar;
        aVar.f14074b = iVar;
        aVar.f14075c = iVar;
        aVar.f14076d = iVar;
        aVar.b(0.0f);
        y4.g gVar = new y4.g(aVar.a());
        this.f6424a = gVar;
        gVar.setTint(this.f6437s);
        y4.g gVar2 = this.f6424a;
        float f8 = this.r;
        j.a aVarF = gVar2.f14023b.f14044a.f();
        aVarF.b(f8);
        gVar2.setShapeAppearanceModel(aVarF.a());
        this.f6424a.setAlpha((int) (this.f6436q * 255.0f));
        h1.g gVar3 = new h1.g();
        gVar3.a(0.9f);
        gVar3.b(250.0f);
        h1.f fVar = new h1.f(new h1.e());
        fVar.f9241t = gVar3;
        this.f6432m = fVar;
        float f9 = this.f6434o;
        fVar.f9228b = f9 * 100.0f;
        fVar.f9229c = true;
        this.f6428e = f9;
        gVar3.f9251i = this.f6433n * 100.0f;
        fVar.b(new c(this));
        float f10 = Float.compare(this.f6433n, 1.0f) == 0 ? 200.0f : 100.0f;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f6436q, this.f6435p);
        this.f6430k = valueAnimatorOfFloat;
        PathInterpolator pathInterpolator = F;
        valueAnimatorOfFloat.setInterpolator(pathInterpolator);
        this.f6430k.setDuration((long) f10);
        this.f6430k.addUpdateListener(new d(this));
        this.f6430k.addListener(new h(this, 3));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(this.f6435p, this.f6436q);
        this.f6431l = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.setInterpolator(pathInterpolator);
        this.f6431l.setDuration(Float.compare(this.f6433n, 1.0f) != 0 ? 300L : 200L);
        this.f6431l.addUpdateListener(new e(this));
        this.f6429j = true;
    }

    public final void c() {
        this.f6431l.setFloatValues(this.h / 255.0f, this.f6436q);
        if (this.f6430k.isRunning()) {
            this.f6443y = true;
        } else {
            this.f6431l.start();
        }
        h1.f fVar = this.f6432m;
        fVar.f9228b = this.f6428e * 100.0f;
        fVar.f9229c = true;
        fVar.f9241t.f9251i = this.f6434o * 100.0f;
        b(fVar);
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.z) {
            try {
                l8.e.a(canvas).a("setNightModeUseOf", Integer.TYPE).a(canvas, 2);
            } catch (Exception unused) {
            }
        }
        boolean z = this instanceof ImmersiveListItemDrawable;
        Rect rect = this.f6425b;
        if (z) {
            rect.set(getBounds().centerX() - (this.f6426c / 2), getBounds().centerY() - (this.f6427d / 2), (this.f6426c / 2) + getBounds().centerX(), this.f6427d);
        } else {
            rect.set((int) (getBounds().centerX() - ((this.f6426c / 2) * this.f6428e)), (int) (getBounds().centerY() - ((this.f6427d / 2) * this.f6428e)), (int) (((this.f6426c / 2) * this.f6428e) + getBounds().centerX()), (int) (((this.f6427d / 2) * this.f6428e) + getBounds().centerY()));
        }
        this.f6424a.setAlpha(this.h);
        this.f6424a.setBounds(rect);
        this.f6424a.draw(canvas);
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.Drawable
    @SuppressLint({"LongLogTag"})
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, g8.a.f9089p);
        if (typedArrayObtainAttributes.hasValue(9)) {
            this.r = typedArrayObtainAttributes.getDimensionPixelSize(9, 0);
        }
        if (typedArrayObtainAttributes.hasValue(8)) {
            this.f6433n = typedArrayObtainAttributes.getFloat(8, 1.0f);
        }
        if (typedArrayObtainAttributes.hasValue(7)) {
            this.f6434o = typedArrayObtainAttributes.getFloat(7, 1.0f);
        }
        if (typedArrayObtainAttributes.hasValue(1)) {
            this.f6441w = typedArrayObtainAttributes.getDimensionPixelSize(1, 0);
        }
        if (typedArrayObtainAttributes.hasValue(2)) {
            this.f6442x = typedArrayObtainAttributes.getDimensionPixelSize(2, 0);
        }
        if (typedArrayObtainAttributes.hasValue(11)) {
            this.f6437s = typedArrayObtainAttributes.getColor(11, -16777216);
        }
        if (typedArrayObtainAttributes.hasValue(5)) {
            this.f6436q = typedArrayObtainAttributes.getFloat(5, 0.0f);
        }
        if (typedArrayObtainAttributes.hasValue(6)) {
            this.f6435p = typedArrayObtainAttributes.getFloat(6, 0.03f);
        }
        if (typedArrayObtainAttributes.hasValue(13)) {
            this.f6438t = typedArrayObtainAttributes.getBoolean(13, true);
        }
        if (typedArrayObtainAttributes.hasValue(4)) {
            this.A = typedArrayObtainAttributes.getBoolean(4, false);
        }
        if (typedArrayObtainAttributes.hasValue(10)) {
            this.B = typedArrayObtainAttributes.getDimensionPixelSize(10, 0);
        }
        if (typedArrayObtainAttributes.hasValue(3)) {
            this.C = typedArrayObtainAttributes.getDimensionPixelSize(3, 0);
        }
        if (typedArrayObtainAttributes.hasValue(12)) {
            this.D = typedArrayObtainAttributes.getDimensionPixelSize(12, 0);
        }
        if (typedArrayObtainAttributes.hasValue(0)) {
            this.E = typedArrayObtainAttributes.getDimensionPixelSize(0, 0);
        }
        typedArrayObtainAttributes.recycle();
        if (this.f6429j) {
            return;
        }
        a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        return !(this instanceof ImmersiveListItemDrawable);
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        int i10;
        super.onBoundsChange(rect);
        getBounds().offset(this.f6441w, this.f6442x);
        if (this.f6438t) {
            this.f6426c = (getBounds().width() - this.B) - this.C;
            this.f6427d = (getBounds().height() - this.D) - this.E;
            return;
        }
        if (!this.A) {
            int i11 = this.r;
            this.f6426c = i11 * 2;
            this.f6427d = i11 * 2;
            return;
        }
        int iMin = Math.min(getBounds().width(), getBounds().height());
        this.f6426c = iMin;
        this.f6427d = iMin;
        int i12 = this.f6439u;
        if (i12 <= 0 || (i10 = this.f6440v) <= 0) {
            return;
        }
        this.f6426c = i12;
        this.f6427d = i10;
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        if (iArr == null || iArr.length == 0) {
            return false;
        }
        if (!this.f6429j) {
            a();
        }
        boolean z = false;
        boolean z3 = false;
        for (int i10 : iArr) {
            if (i10 == 16842910) {
                z = true;
            } else if (i10 == 16842919) {
                z3 = true;
            }
        }
        if (!z || !z3) {
            c();
            return zOnStateChange;
        }
        this.f6430k.setFloatValues(this.h / 255.0f, this.f6435p);
        this.f6430k.start();
        if (this.f6431l.isRunning()) {
            this.f6431l.cancel();
        }
        h1.f fVar = this.f6432m;
        fVar.f9228b = this.f6428e * 100.0f;
        fVar.f9229c = true;
        fVar.f9241t.f9251i = this.f6433n * 100.0f;
        b(fVar);
        return zOnStateChange;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final void setAlpha(int i10) {
        this.f6424a.setAlpha(i10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f6424a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i10) {
        this.f6437s = i10;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a extends Drawable {
        @Override // android.graphics.drawable.Drawable
        public final int getOpacity() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public final void draw(Canvas canvas) {
        }

        @Override // android.graphics.drawable.Drawable
        public final void setAlpha(int i10) {
        }

        @Override // android.graphics.drawable.Drawable
        public final void setColorFilter(ColorFilter colorFilter) {
        }
    }
}
