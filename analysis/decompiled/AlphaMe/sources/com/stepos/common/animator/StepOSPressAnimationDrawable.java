package com.stepos.common.animator;

import android.R;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.Interpolator;
import androidx.appcompat.widget.C0195d;
import androidx.room.AbstractC0351g;
import com.stepos.alphame.utils.Property;
import i2.AbstractC0620a;
import java.lang.reflect.InvocationTargetException;
import org.xmlpull.v1.XmlPullParser;
import y1.C0987a;

/* loaded from: classes.dex */
public class StepOSPressAnimationDrawable extends StateListDrawable {

    /* renamed from: C, reason: collision with root package name */
    public static final Interpolator f11238C = M.a.b(0.4f, Property.DEFAULT_FLOAT_VALUE, 0.58f, 1.0f);

    /* renamed from: A, reason: collision with root package name */
    public int f11239A;

    /* renamed from: B, reason: collision with root package name */
    public int f11240B;

    /* renamed from: a, reason: collision with root package name */
    public y1.j f11241a;

    /* renamed from: c, reason: collision with root package name */
    public int f11243c;

    /* renamed from: d, reason: collision with root package name */
    public int f11244d;

    /* renamed from: e, reason: collision with root package name */
    public float f11245e;

    /* renamed from: f, reason: collision with root package name */
    public int f11246f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f11247g;

    /* renamed from: h, reason: collision with root package name */
    public ValueAnimator f11248h;

    /* renamed from: i, reason: collision with root package name */
    public ValueAnimator f11249i;

    /* renamed from: j, reason: collision with root package name */
    public W.m f11250j;

    /* renamed from: r, reason: collision with root package name */
    public int f11258r;

    /* renamed from: s, reason: collision with root package name */
    public int f11259s;

    /* renamed from: v, reason: collision with root package name */
    public boolean f11262v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f11263w;

    /* renamed from: y, reason: collision with root package name */
    public int f11265y;

    /* renamed from: z, reason: collision with root package name */
    public int f11266z;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f11242b = new Rect();

    /* renamed from: o, reason: collision with root package name */
    public int f11255o = 0;

    /* renamed from: k, reason: collision with root package name */
    public float f11251k = 1.0f;

    /* renamed from: l, reason: collision with root package name */
    public float f11252l = 1.0f;

    /* renamed from: p, reason: collision with root package name */
    public int f11256p = -16777216;

    /* renamed from: n, reason: collision with root package name */
    public float f11254n = Property.DEFAULT_FLOAT_VALUE;

    /* renamed from: m, reason: collision with root package name */
    public float f11253m = 0.03f;

    /* renamed from: q, reason: collision with root package name */
    public boolean f11257q = true;

    /* renamed from: x, reason: collision with root package name */
    public boolean f11264x = false;

    /* renamed from: t, reason: collision with root package name */
    public int f11260t = 0;

    /* renamed from: u, reason: collision with root package name */
    public int f11261u = 0;

    static {
        M.a.b(0.33f, Property.DEFAULT_FLOAT_VALUE, 0.67f, 1.0f);
    }

    public StepOSPressAnimationDrawable() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f11263w = true;
        addState(new int[]{R.attr.state_pressed}, new h());
        addState(new int[0], new h());
        try {
            Canvas canvas = new Canvas();
            m2.i.a(canvas).b("setNightModeUseOf", Integer.TYPE).f13573a.invoke(canvas, 2);
        } catch (Exception e4) {
            AbstractC0351g.B("setNightModeUseOf error ", e4, "StepOSSPressDrawable");
            this.f11263w = false;
        }
    }

    public static void b(W.m mVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            mVar.i();
            return;
        }
        Log.w("StepOSSPressDrawable", "Your looper is not on MainLooper, force run on MainLooper now, and trace:" + Log.getStackTraceString(new Throwable()));
        new Handler(Looper.getMainLooper()).post(new e(mVar, 0));
    }

    public final void a() {
        y1.f fVarN = B0.f.n();
        y1.f fVarN2 = B0.f.n();
        y1.f fVarN3 = B0.f.n();
        y1.f fVarN4 = B0.f.n();
        y1.l lVar = new y1.l();
        y1.m.b(lVar);
        y1.m.b(lVar);
        y1.m.b(lVar);
        y1.m.b(lVar);
        C0987a c0987a = new C0987a(Property.DEFAULT_FLOAT_VALUE);
        C0987a c0987a2 = new C0987a(Property.DEFAULT_FLOAT_VALUE);
        C0987a c0987a3 = new C0987a(Property.DEFAULT_FLOAT_VALUE);
        C0987a c0987a4 = new C0987a(Property.DEFAULT_FLOAT_VALUE);
        y1.n nVar = new y1.n();
        nVar.f16272a = lVar;
        nVar.f16273b = lVar;
        nVar.f16274c = lVar;
        nVar.f16275d = lVar;
        nVar.f16276e = c0987a;
        nVar.f16277f = c0987a2;
        nVar.f16278g = c0987a3;
        nVar.f16279h = c0987a4;
        nVar.f16280i = fVarN;
        nVar.f16281j = fVarN2;
        nVar.f16282k = fVarN3;
        nVar.f16283l = fVarN4;
        y1.j jVar = new y1.j(nVar);
        this.f11241a = jVar;
        jVar.setTint(this.f11256p);
        y1.j jVar2 = this.f11241a;
        float f4 = this.f11255o;
        y1.m mVarF = jVar2.f16234b.f16203a.f();
        mVarF.c(f4);
        jVar2.setShapeAppearanceModel(mVarF.a());
        this.f11241a.setAlpha((int) (this.f11254n * 255.0f));
        W.n nVar2 = new W.n();
        nVar2.a(0.9f);
        nVar2.b(250.0f);
        W.m mVar = new W.m(new W.l());
        mVar.f1974m = nVar2;
        this.f11250j = mVar;
        mVar.g(this.f11252l * 100.0f);
        this.f11245e = this.f11252l;
        W.m mVar2 = this.f11250j;
        mVar2.f1974m.f1985i = this.f11251k * 100.0f;
        mVar2.b(new f(0, this));
        float f5 = Float.compare(this.f11251k, 1.0f) == 0 ? 200.0f : 100.0f;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f11254n, this.f11253m);
        this.f11248h = valueAnimatorOfFloat;
        Interpolator interpolator = f11238C;
        valueAnimatorOfFloat.setInterpolator(interpolator);
        this.f11248h.setDuration((long) f5);
        this.f11248h.addUpdateListener(new g(this, 0));
        this.f11248h.addListener(new C0195d(11, this));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(this.f11253m, this.f11254n);
        this.f11249i = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.setInterpolator(interpolator);
        this.f11249i.setDuration(Float.compare(this.f11251k, 1.0f) != 0 ? 300L : 200L);
        this.f11249i.addUpdateListener(new g(this, 1));
        this.f11247g = true;
    }

    public final void c() {
        this.f11249i.setFloatValues(this.f11246f / 255.0f, this.f11254n);
        if (this.f11248h.isRunning()) {
            this.f11262v = true;
        } else {
            this.f11249i.start();
        }
        this.f11250j.g(this.f11245e * 100.0f);
        W.m mVar = this.f11250j;
        mVar.f1974m.f1985i = this.f11252l * 100.0f;
        b(mVar);
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.f11263w) {
            try {
                m2.i.a(canvas).b("setNightModeUseOf", Integer.TYPE).f13573a.invoke(canvas, 2);
            } catch (Exception unused) {
            }
        }
        boolean z4 = this instanceof ImmersiveListItemDrawable;
        Rect rect = this.f11242b;
        if (z4) {
            rect.set(getBounds().centerX() - (this.f11243c / 2), getBounds().centerY() - (this.f11244d / 2), (this.f11243c / 2) + getBounds().centerX(), this.f11244d);
        } else {
            rect.set((int) (getBounds().centerX() - ((this.f11243c / 2) * this.f11245e)), (int) (getBounds().centerY() - ((this.f11244d / 2) * this.f11245e)), (int) (((this.f11243c / 2) * this.f11245e) + getBounds().centerX()), (int) (((this.f11244d / 2) * this.f11245e) + getBounds().centerY()));
        }
        this.f11241a.setAlpha(this.f11246f);
        this.f11241a.setBounds(rect);
        this.f11241a.draw(canvas);
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, AbstractC0620a.f13034p);
        if (typedArrayObtainAttributes.hasValue(9)) {
            this.f11255o = typedArrayObtainAttributes.getDimensionPixelSize(9, 0);
        }
        if (typedArrayObtainAttributes.hasValue(8)) {
            this.f11251k = typedArrayObtainAttributes.getFloat(8, 1.0f);
        }
        if (typedArrayObtainAttributes.hasValue(7)) {
            this.f11252l = typedArrayObtainAttributes.getFloat(7, 1.0f);
        }
        if (typedArrayObtainAttributes.hasValue(1)) {
            this.f11260t = typedArrayObtainAttributes.getDimensionPixelSize(1, 0);
        }
        if (typedArrayObtainAttributes.hasValue(2)) {
            this.f11261u = typedArrayObtainAttributes.getDimensionPixelSize(2, 0);
        }
        if (typedArrayObtainAttributes.hasValue(11)) {
            this.f11256p = typedArrayObtainAttributes.getColor(11, -16777216);
        }
        if (typedArrayObtainAttributes.hasValue(5)) {
            this.f11254n = typedArrayObtainAttributes.getFloat(5, Property.DEFAULT_FLOAT_VALUE);
        }
        if (typedArrayObtainAttributes.hasValue(6)) {
            this.f11253m = typedArrayObtainAttributes.getFloat(6, 0.03f);
        }
        if (typedArrayObtainAttributes.hasValue(13)) {
            this.f11257q = typedArrayObtainAttributes.getBoolean(13, true);
        }
        if (typedArrayObtainAttributes.hasValue(4)) {
            this.f11264x = typedArrayObtainAttributes.getBoolean(4, false);
        }
        if (typedArrayObtainAttributes.hasValue(10)) {
            this.f11265y = typedArrayObtainAttributes.getDimensionPixelSize(10, 0);
        }
        if (typedArrayObtainAttributes.hasValue(3)) {
            this.f11266z = typedArrayObtainAttributes.getDimensionPixelSize(3, 0);
        }
        if (typedArrayObtainAttributes.hasValue(12)) {
            this.f11239A = typedArrayObtainAttributes.getDimensionPixelSize(12, 0);
        }
        if (typedArrayObtainAttributes.hasValue(0)) {
            this.f11240B = typedArrayObtainAttributes.getDimensionPixelSize(0, 0);
        }
        typedArrayObtainAttributes.recycle();
        if (this.f11247g) {
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
        int i4;
        super.onBoundsChange(rect);
        getBounds().offset(this.f11260t, this.f11261u);
        if (this.f11257q) {
            this.f11243c = (getBounds().width() - this.f11265y) - this.f11266z;
            this.f11244d = (getBounds().height() - this.f11239A) - this.f11240B;
            return;
        }
        if (!this.f11264x) {
            int i5 = this.f11255o;
            this.f11243c = i5 * 2;
            this.f11244d = i5 * 2;
            return;
        }
        int iMin = Math.min(getBounds().width(), getBounds().height());
        this.f11243c = iMin;
        this.f11244d = iMin;
        int i6 = this.f11258r;
        if (i6 <= 0 || (i4 = this.f11259s) <= 0) {
            return;
        }
        this.f11243c = i6;
        this.f11244d = i4;
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        if (iArr == null || iArr.length == 0) {
            return false;
        }
        if (!this.f11247g) {
            a();
        }
        boolean z4 = false;
        boolean z5 = false;
        for (int i4 : iArr) {
            if (i4 == 16842910) {
                z4 = true;
            } else if (i4 == 16842919) {
                z5 = true;
            }
        }
        if (z4 && z5) {
            this.f11248h.setFloatValues(this.f11246f / 255.0f, this.f11253m);
            this.f11248h.start();
            if (this.f11249i.isRunning()) {
                this.f11249i.cancel();
            }
            this.f11250j.g(this.f11245e * 100.0f);
            W.m mVar = this.f11250j;
            mVar.f1974m.f1985i = this.f11251k * 100.0f;
            b(mVar);
        } else {
            c();
        }
        return zOnStateChange;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final void setAlpha(int i4) {
        this.f11241a.setAlpha(i4);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f11241a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i4) {
        this.f11256p = i4;
    }
}
