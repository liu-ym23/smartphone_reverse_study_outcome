package com.google.android.material.progressindicator;

import U2.b;
import U2.i;
import U2.j;
import U2.k;
import U2.m;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.r;
import d3.C3953a;
import java.util.Arrays;

/* loaded from: classes2.dex */
public abstract class a<S extends U2.b> extends ProgressBar {

    /* renamed from: p, reason: collision with root package name */
    public static final int f21189p = R$style.Widget_MaterialComponents_ProgressIndicator;

    /* renamed from: a, reason: collision with root package name */
    public S f21190a;

    /* renamed from: b, reason: collision with root package name */
    public int f21191b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f21192c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f21193d;

    /* renamed from: e, reason: collision with root package name */
    public final int f21194e;

    /* renamed from: f, reason: collision with root package name */
    public final int f21195f;

    /* renamed from: g, reason: collision with root package name */
    public long f21196g;

    /* renamed from: h, reason: collision with root package name */
    public U2.a f21197h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f21198i;

    /* renamed from: j, reason: collision with root package name */
    public int f21199j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f21200k;

    /* renamed from: l, reason: collision with root package name */
    public final Runnable f21201l;

    /* renamed from: m, reason: collision with root package name */
    public final Runnable f21202m;

    /* renamed from: n, reason: collision with root package name */
    public final q1.b f21203n;

    /* renamed from: o, reason: collision with root package name */
    public final q1.b f21204o;

    /* renamed from: com.google.android.material.progressindicator.a$a, reason: collision with other inner class name */
    public class RunnableC0236a implements Runnable {
        public RunnableC0236a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.k();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.j();
            a.this.f21196g = -1L;
        }
    }

    public class c extends q1.b {
        public c() {
        }

        @Override // q1.b
        public void b(Drawable drawable) {
            a.this.setIndeterminate(false);
            a aVar = a.this;
            aVar.p(aVar.f21191b, a.this.f21192c);
        }
    }

    public class d extends q1.b {
        public d() {
        }

        @Override // q1.b
        public void b(Drawable drawable) {
            super.b(drawable);
            if (a.this.f21198i) {
                return;
            }
            a aVar = a.this;
            aVar.setVisibility(aVar.f21199j);
        }
    }

    public a(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(C3953a.d(context, attributeSet, i10, f21189p), attributeSet, i10);
        this.f21196g = -1L;
        this.f21198i = false;
        this.f21199j = 4;
        this.f21201l = new RunnableC0236a();
        this.f21202m = new b();
        this.f21203n = new c();
        this.f21204o = new d();
        Context context2 = getContext();
        this.f21190a = (S) i(context2, attributeSet);
        TypedArray typedArrayI = r.i(context2, attributeSet, R$styleable.BaseProgressIndicator, i10, i11, new int[0]);
        this.f21194e = typedArrayI.getInt(R$styleable.BaseProgressIndicator_showDelay, -1);
        this.f21195f = Math.min(typedArrayI.getInt(R$styleable.BaseProgressIndicator_minHideDelay, -1), 1000);
        typedArrayI.recycle();
        this.f21197h = new U2.a();
        this.f21193d = true;
    }

    private k<S> getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().x();
        }
        if (getProgressDrawable() == null) {
            return null;
        }
        return getProgressDrawable().C();
    }

    @Override // android.widget.ProgressBar
    public Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.f21190a.f6177h;
    }

    public int[] getIndicatorColor() {
        return this.f21190a.f6174e;
    }

    public int getIndicatorTrackGapSize() {
        return this.f21190a.f6178i;
    }

    public int getShowAnimationBehavior() {
        return this.f21190a.f6176g;
    }

    public int getTrackColor() {
        return this.f21190a.f6175f;
    }

    public int getTrackCornerRadius() {
        return this.f21190a.f6171b;
    }

    public float getTrackCornerRadiusFraction() {
        return this.f21190a.f6172c;
    }

    public int getTrackThickness() {
        return this.f21190a.f6170a;
    }

    public int getWaveAmplitude() {
        return this.f21190a.f6181l;
    }

    public int getWaveSpeed() {
        return this.f21190a.f6182m;
    }

    public int getWavelengthDeterminate() {
        return this.f21190a.f6179j;
    }

    public int getWavelengthIndeterminate() {
        return this.f21190a.f6180k;
    }

    public void h(boolean z10) {
        if (this.f21193d) {
            ((j) getCurrentDrawable()).s(r(), false, z10);
        }
    }

    public abstract S i(Context context, AttributeSet attributeSet);

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    public final void j() {
        ((j) getCurrentDrawable()).s(false, false, true);
        if (m()) {
            setVisibility(4);
        }
    }

    public final void k() {
        if (this.f21195f > 0) {
            this.f21196g = SystemClock.uptimeMillis();
        }
        setVisibility(0);
    }

    public boolean l() {
        View view = this;
        while (view.getVisibility() == 0) {
            Object parent = view.getParent();
            if (parent == null) {
                return getWindowVisibility() == 0;
            }
            if (!(parent instanceof View)) {
                return true;
            }
            view = (View) parent;
        }
        return false;
    }

    public final boolean m() {
        if (getProgressDrawable() == null || !getProgressDrawable().isVisible()) {
            return getIndeterminateDrawable() == null || !getIndeterminateDrawable().isVisible();
        }
        return false;
    }

    public final void n() {
        o();
        if (getProgressDrawable() != null) {
            getProgressDrawable().o(this.f21204o);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().o(this.f21204o);
        }
    }

    public void o() {
        if (getProgressDrawable() == null || getIndeterminateDrawable() == null) {
            return;
        }
        getIndeterminateDrawable().w().d(this.f21203n);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        n();
        if (r()) {
            k();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f21202m);
        removeCallbacks(this.f21201l);
        ((j) getCurrentDrawable()).j();
        q();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        try {
            int iSave = canvas.save();
            if (getPaddingLeft() != 0 || getPaddingTop() != 0) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            if (getPaddingRight() != 0 || getPaddingBottom() != 0) {
                canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
            }
            getCurrentDrawable().draw(canvas);
            canvas.restoreToCount(iSave);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        getCurrentDrawingDelegate().g();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i10, int i11) {
        try {
            k<S> currentDrawingDelegate = getCurrentDrawingDelegate();
            if (currentDrawingDelegate == null) {
                return;
            }
            setMeasuredDimension(currentDrawingDelegate.f() < 0 ? View.getDefaultSize(getSuggestedMinimumWidth(), i10) : currentDrawingDelegate.f() + getPaddingLeft() + getPaddingRight(), currentDrawingDelegate.e() < 0 ? View.getDefaultSize(getSuggestedMinimumHeight(), i11) : currentDrawingDelegate.e() + getPaddingTop() + getPaddingBottom());
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        h(i10 == 0);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        h(false);
    }

    public void p(int i10, boolean z10) {
        if (!isIndeterminate()) {
            super.setProgress(i10);
            if (getProgressDrawable() == null || z10) {
                return;
            }
            getProgressDrawable().jumpToCurrentState();
            return;
        }
        if (getProgressDrawable() != null) {
            this.f21191b = i10;
            this.f21192c = z10;
            this.f21198i = true;
            if (!getIndeterminateDrawable().isVisible() || this.f21197h.a(getContext().getContentResolver()) == 0.0f) {
                this.f21203n.b(getIndeterminateDrawable());
            } else {
                getIndeterminateDrawable().w().f();
            }
        }
    }

    public final void q() {
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().u(this.f21204o);
            getIndeterminateDrawable().w().h();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().u(this.f21204o);
        }
    }

    public boolean r() {
        return isAttachedToWindow() && getWindowVisibility() == 0 && l();
    }

    public void setAnimatorDurationScaleProvider(U2.a aVar) {
        this.f21197h = aVar;
        if (getProgressDrawable() != null) {
            getProgressDrawable().f6249c = aVar;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().f6249c = aVar;
        }
    }

    public void setHideAnimationBehavior(int i10) {
        this.f21190a.f6177h = i10;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z10) {
        try {
            if (z10 == isIndeterminate()) {
                return;
            }
            j jVar = (j) getCurrentDrawable();
            if (jVar != null) {
                jVar.j();
            }
            super.setIndeterminate(z10);
            j jVar2 = (j) getCurrentDrawable();
            if (jVar2 != null) {
                jVar2.s(r(), false, false);
            }
            if ((jVar2 instanceof m) && r()) {
                ((m) jVar2).w().g();
            }
            this.f21198i = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setIndeterminateAnimatorDurationScale(float f10) {
        S s10 = this.f21190a;
        if (s10.f6183n != f10) {
            s10.f6183n = f10;
            getIndeterminateDrawable().w().c();
        }
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(Drawable drawable) {
        if (drawable instanceof m) {
            ((j) drawable).j();
            super.setIndeterminateDrawable(drawable);
        } else {
            if (this.f21200k) {
                throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
            }
            super.setIndeterminateDrawable(drawable);
        }
    }

    public void setIndicatorColor(int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{M2.a.b(getContext(), R$attr.colorPrimary, -1)};
        }
        if (Arrays.equals(getIndicatorColor(), iArr)) {
            return;
        }
        this.f21190a.f6174e = iArr;
        getIndeterminateDrawable().w().c();
        invalidate();
    }

    public void setIndicatorTrackGapSize(int i10) {
        S s10 = this.f21190a;
        if (s10.f6178i != i10) {
            s10.f6178i = i10;
            s10.h();
            invalidate();
        }
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i10) {
        if (isIndeterminate()) {
            return;
        }
        p(i10, false);
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(Drawable drawable) {
        if (!(drawable instanceof i)) {
            if (this.f21200k) {
                throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
            }
            super.setProgressDrawable(drawable);
        } else {
            i iVar = (i) drawable;
            iVar.j();
            super.setProgressDrawable(iVar);
            iVar.K(getProgress() / getMax());
        }
    }

    public void setShowAnimationBehavior(int i10) {
        this.f21190a.f6176g = i10;
        invalidate();
    }

    public void setTrackColor(int i10) {
        S s10 = this.f21190a;
        if (s10.f6175f != i10) {
            s10.f6175f = i10;
            invalidate();
        }
    }

    public void setTrackCornerRadius(int i10) {
        S s10 = this.f21190a;
        if (s10.f6171b != i10) {
            s10.f6171b = Math.min(i10, s10.f6170a / 2);
            this.f21190a.f6173d = false;
            invalidate();
        }
    }

    public void setTrackCornerRadiusFraction(float f10) {
        S s10 = this.f21190a;
        if (s10.f6172c != f10) {
            s10.f6172c = Math.min(f10, 0.5f);
            this.f21190a.f6173d = true;
            invalidate();
        }
    }

    public void setTrackThickness(int i10) {
        S s10 = this.f21190a;
        if (s10.f6170a != i10) {
            s10.f6170a = i10;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i10) {
        if (i10 != 0 && i10 != 4 && i10 != 8) {
            throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
        }
        this.f21199j = i10;
    }

    public void setWaveAmplitude(int i10) {
        S s10 = this.f21190a;
        if (s10.f6181l != i10) {
            s10.f6181l = Math.abs(i10);
            requestLayout();
        }
    }

    public void setWaveSpeed(int i10) {
        this.f21190a.f6182m = i10;
        getProgressDrawable().I(this.f21190a.f6182m != 0);
    }

    public void setWavelength(int i10) {
        setWavelengthDeterminate(i10);
        setWavelengthIndeterminate(i10);
    }

    public void setWavelengthDeterminate(int i10) {
        S s10 = this.f21190a;
        if (s10.f6179j != i10) {
            s10.f6179j = Math.abs(i10);
            if (isIndeterminate()) {
                return;
            }
            requestLayout();
        }
    }

    public void setWavelengthIndeterminate(int i10) {
        S s10 = this.f21190a;
        if (s10.f6180k != i10) {
            s10.f6180k = Math.abs(i10);
            if (isIndeterminate()) {
                requestLayout();
            }
        }
    }

    @Override // android.widget.ProgressBar
    public m<S> getIndeterminateDrawable() {
        return (m) super.getIndeterminateDrawable();
    }

    @Override // android.widget.ProgressBar
    public i<S> getProgressDrawable() {
        return (i) super.getProgressDrawable();
    }
}
