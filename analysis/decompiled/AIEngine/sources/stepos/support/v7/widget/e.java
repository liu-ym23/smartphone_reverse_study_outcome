package stepos.support.v7.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.stepos.aiengine.R;
import java.util.ArrayList;
import java.util.Objects;
import java.util.WeakHashMap;
import v0.e0;
import v0.h0;
import v0.m0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class e extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public boolean f12733a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12734b;

    /* renamed from: c, reason: collision with root package name */
    public Toolbar f12735c;

    /* renamed from: d, reason: collision with root package name */
    public View f12736d;

    /* renamed from: e, reason: collision with root package name */
    public View f12737e;
    public int h;

    /* renamed from: j, reason: collision with root package name */
    public int f12738j;

    /* renamed from: k, reason: collision with root package name */
    public int f12739k;

    /* renamed from: l, reason: collision with root package name */
    public int f12740l;

    /* renamed from: m, reason: collision with root package name */
    public final Rect f12741m;

    /* renamed from: n, reason: collision with root package name */
    public final d f12742n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f12743o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f12744p;

    /* renamed from: q, reason: collision with root package name */
    public Drawable f12745q;
    public Drawable r;

    /* renamed from: s, reason: collision with root package name */
    public int f12746s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f12747t;

    /* renamed from: u, reason: collision with root package name */
    public ValueAnimator f12748u;

    /* renamed from: v, reason: collision with root package name */
    public long f12749v;

    /* renamed from: w, reason: collision with root package name */
    public int f12750w;

    /* renamed from: x, reason: collision with root package name */
    public c f12751x;

    /* renamed from: y, reason: collision with root package name */
    public int f12752y;
    public m0 z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements v0.r {
        public a() {
        }

        @Override // v0.r
        public final m0 g(View view, m0 m0Var) {
            return e.this.e(m0Var);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b extends FrameLayout.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f12754a;

        /* renamed from: b, reason: collision with root package name */
        public float f12755b;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c implements AppBarLayout.g {
        public c() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.a
        public final void a(int i10) {
            int iRound;
            e eVar = e.this;
            eVar.f12752y = i10;
            int iA = eVar.a();
            int childCount = eVar.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = eVar.getChildAt(i11);
                b bVar = (b) childAt.getLayoutParams();
                f0 f0VarD = e.d(childAt);
                int i12 = bVar.f12754a;
                if (i12 == 1) {
                    int iP = mb.y.p(-i10, 0, eVar.c(childAt));
                    if (f0VarD.f12792d != iP) {
                        f0VarD.f12792d = iP;
                        f0VarD.a();
                    }
                } else if (i12 == 2 && f0VarD.f12792d != (iRound = Math.round((-i10) * bVar.f12755b))) {
                    f0VarD.f12792d = iRound;
                    f0VarD.a();
                }
            }
            eVar.g();
            if (eVar.r != null && iA > 0) {
                WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
                eVar.postInvalidateOnAnimation();
            }
            int height = eVar.getHeight();
            WeakHashMap<View, h0> weakHashMap2 = v0.e0.f13274a;
            int minimumHeight = (height - eVar.getMinimumHeight()) - iA;
            d dVar = eVar.f12742n;
            float fO = mb.y.o(Math.abs(i10) / minimumHeight, 0.0f, 1.0f);
            if (fO != dVar.f12713c) {
                dVar.f12713c = fO;
                TextPaint textPaint = dVar.G;
                RectF rectF = dVar.h;
                float f8 = dVar.f12714d.left;
                Rect rect = dVar.f12715e;
                rectF.left = d.g(f8, rect.left, fO, null);
                rectF.top = d.g(dVar.f12722p, dVar.f12723q, fO, null);
                rectF.right = d.g(r3.right, rect.right, fO, null);
                rectF.bottom = d.g(r3.bottom, rect.bottom, fO, null);
                dVar.f12725t = d.g(dVar.r, dVar.f12724s, fO, null);
                dVar.f12726u = d.g(dVar.f12722p, dVar.f12723q, fO, null);
                dVar.m(d.g(dVar.f12718l, dVar.f12719m, fO, dVar.H));
                ColorStateList colorStateList = dVar.f12721o;
                ColorStateList colorStateList2 = dVar.f12720n;
                if (colorStateList != colorStateList2) {
                    int[] iArr = dVar.E;
                    int colorForState = iArr != null ? colorStateList2.getColorForState(iArr, 0) : colorStateList2.getDefaultColor();
                    int[] iArr2 = dVar.E;
                    textPaint.setColor(d.c(fO, colorForState, iArr2 != null ? dVar.f12721o.getColorForState(iArr2, 0) : dVar.f12721o.getDefaultColor()));
                } else {
                    int[] iArr3 = dVar.E;
                    textPaint.setColor(iArr3 != null ? colorStateList.getColorForState(iArr3, 0) : colorStateList.getDefaultColor());
                }
                textPaint.setShadowLayer(d.g(dVar.M, dVar.I, fO, null), d.g(dVar.N, dVar.J, fO, null), d.g(dVar.O, dVar.K, fO, null), d.c(fO, dVar.P, dVar.L));
                dVar.f12711a.postInvalidateOnAnimation();
            }
        }
    }

    public e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static f0 d(View view) {
        f0 f0Var = (f0) view.getTag(R.id.view_offset_helper);
        if (f0Var != null) {
            return f0Var;
        }
        f0 f0Var2 = new f0(view);
        view.setTag(R.id.view_offset_helper, f0Var2);
        return f0Var2;
    }

    public int a() {
        m0 m0Var = this.z;
        if (m0Var != null) {
            return m0Var.d();
        }
        return 0;
    }

    public final void b() {
        if (this.f12733a) {
            Toolbar toolbar = null;
            this.f12735c = null;
            this.f12736d = null;
            int i10 = this.f12734b;
            if (i10 != -1) {
                Toolbar toolbar2 = (Toolbar) findViewById(i10);
                this.f12735c = toolbar2;
                if (toolbar2 != null) {
                    ViewParent parent = toolbar2.getParent();
                    View view = toolbar2;
                    while (parent != this && parent != null) {
                        if (parent instanceof View) {
                            view = (View) parent;
                        }
                        parent = parent.getParent();
                        view = view;
                    }
                    this.f12736d = view;
                }
            }
            if (this.f12735c == null) {
                int childCount = getChildCount();
                int i11 = 0;
                while (true) {
                    if (i11 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i11);
                    if (childAt instanceof Toolbar) {
                        toolbar = (Toolbar) childAt;
                        break;
                    }
                    i11++;
                }
                this.f12735c = toolbar;
            }
            f();
            this.f12733a = false;
        }
    }

    public final int c(View view) {
        f0 f0VarD = d(view);
        b bVar = (b) view.getLayoutParams();
        int i10 = f0VarD.f12790b;
        return ((getHeight() - Math.max(i10, this.z != null ? a() : i10)) - view.getHeight()) - ((FrameLayout.LayoutParams) bVar).bottomMargin;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        Canvas canvas2;
        int iA;
        Drawable drawable;
        super.draw(canvas);
        b();
        if (this.f12735c == null && (drawable = this.f12745q) != null && this.f12746s > 0) {
            drawable.mutate().setAlpha(this.f12746s);
            this.f12745q.draw(canvas);
        }
        if (this.f12743o && this.f12744p) {
            d dVar = this.f12742n;
            TextPaint textPaint = dVar.G;
            int iSave = canvas.save();
            if (dVar.z == null || !dVar.f12712b) {
                canvas2 = canvas;
            } else {
                float f8 = dVar.f12725t;
                float f9 = dVar.f12726u + 0.0f;
                if (d.f(dVar.f12713c, 0.0f)) {
                    f9 += 0.0f;
                }
                float f10 = f9;
                textPaint.ascent();
                textPaint.descent();
                float f11 = dVar.C;
                if (f11 != 1.0f) {
                    canvas.scale(f11, f11, f8, f10);
                }
                CharSequence charSequence = dVar.z;
                canvas2 = canvas;
                canvas2.drawText(charSequence, 0, charSequence.length(), f8, f10, textPaint);
            }
            canvas2.restoreToCount(iSave);
        } else {
            canvas2 = canvas;
        }
        if (this.r == null || this.f12746s <= 0 || (iA = a()) <= 0) {
            return;
        }
        this.r.setBounds(0, -this.f12752y, getWidth(), iA - this.f12752y);
        this.r.mutate().setAlpha(this.f12746s);
        this.r.draw(canvas2);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j10) {
        boolean z;
        View view2;
        Drawable drawable = this.f12745q;
        if (drawable == null || this.f12746s <= 0 || ((view2 = this.f12736d) == null || view2 == this ? view != this.f12735c : view != view2)) {
            z = false;
        } else {
            drawable.mutate().setAlpha(this.f12746s);
            this.f12745q.draw(canvas);
            z = true;
        }
        return super.drawChild(canvas, view, j10) || z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        ColorStateList colorStateList;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.r;
        boolean z = false;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.f12745q;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        d dVar = this.f12742n;
        if (dVar != null) {
            dVar.E = drawableState;
            ColorStateList colorStateList2 = dVar.f12721o;
            if ((colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = dVar.f12720n) != null && colorStateList.isStateful())) {
                dVar.j();
                z = true;
            }
            state |= z;
        }
        if (state) {
            invalidate();
        }
    }

    public m0 e(m0 m0Var) {
        WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
        m0 m0Var2 = getFitsSystemWindows() ? m0Var : null;
        if (!Objects.equals(this.z, m0Var2)) {
            this.z = m0Var2;
            requestLayout();
        }
        return m0Var.f13309a.c();
    }

    public final void f() {
        View view;
        if (!this.f12743o && (view = this.f12737e) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f12737e);
            }
        }
        if (!this.f12743o || this.f12735c == null) {
            return;
        }
        if (this.f12737e == null) {
            this.f12737e = new View(getContext());
        }
        if (this.f12737e.getParent() == null) {
            this.f12735c.addView(this.f12737e, -1, -1);
        }
    }

    public final void g() {
        if (this.f12745q == null && this.r == null) {
            return;
        }
        setScrimsShown(getHeight() + this.f12752y < getScrimVisibleHeightTrigger());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        b bVar = new b(-1, -1);
        bVar.f12754a = 0;
        bVar.f12755b = 0.5f;
        return bVar;
    }

    public int getCollapsedTitleGravity() {
        return this.f12742n.f12717k;
    }

    public Typeface getCollapsedTitleTypeface() {
        Typeface typeface = this.f12742n.f12727v;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public Drawable getContentScrim() {
        return this.f12745q;
    }

    public int getExpandedTitleGravity() {
        return this.f12742n.f12716j;
    }

    public int getExpandedTitleMarginBottom() {
        return this.f12740l;
    }

    public int getExpandedTitleMarginEnd() {
        return this.f12739k;
    }

    public int getExpandedTitleMarginStart() {
        return this.h;
    }

    public int getExpandedTitleMarginTop() {
        return this.f12738j;
    }

    public Typeface getExpandedTitleTypeface() {
        Typeface typeface = this.f12742n.f12728w;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public int getScrimAlpha() {
        return this.f12746s;
    }

    public long getScrimAnimationDuration() {
        return this.f12749v;
    }

    public int getScrimVisibleHeightTrigger() {
        int i10 = this.f12750w;
        if (i10 >= 0) {
            return i10;
        }
        int iA = a();
        WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
        int minimumHeight = getMinimumHeight();
        return minimumHeight > 0 ? Math.min((minimumHeight * 2) + iA, getHeight()) : getHeight() / 3;
    }

    public Drawable getStatusBarScrim() {
        return this.r;
    }

    public CharSequence getTitle() {
        if (this.f12743o) {
            return this.f12735c.getTitle();
        }
        return null;
    }

    public o getTitleScaleControl() {
        return this.f12742n;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Object parent = getParent();
        if (parent instanceof AppBarLayout) {
            WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
            setFitsSystemWindows(((View) parent).getFitsSystemWindows());
            if (this.f12751x == null) {
                this.f12751x = new c();
            }
            ((AppBarLayout) parent).c(this.f12751x);
            e0.c.b(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        ArrayList arrayList;
        ViewParent parent = getParent();
        c cVar = this.f12751x;
        if (cVar != null && (parent instanceof AppBarLayout) && (arrayList = ((AppBarLayout) parent).f4545k) != null) {
            arrayList.remove(cVar);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i10, int i11, int i12, int i13) {
        View view;
        super.onLayout(z, i10, i11, i12, i13);
        if (this.z != null) {
            int iA = a();
            int childCount = getChildCount();
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt = getChildAt(i14);
                WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
                if (!childAt.getFitsSystemWindows() && childAt.getTop() < iA) {
                    childAt.offsetTopAndBottom(iA);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i15 = 0; i15 < childCount2; i15++) {
            f0 f0VarD = d(getChildAt(i15));
            View view2 = f0VarD.f12789a;
            f0VarD.f12790b = view2.getTop();
            f0VarD.f12791c = view2.getLeft();
        }
        if (this.f12743o && (view = this.f12737e) != null) {
            WeakHashMap<View, h0> weakHashMap2 = v0.e0.f13274a;
            boolean z3 = view.isAttachedToWindow() && this.f12737e.getVisibility() == 0;
            this.f12744p = z3;
            if (z3) {
                boolean z10 = getLayoutDirection() == 1;
                View view3 = this.f12736d;
                if (view3 == null) {
                    view3 = this.f12735c;
                }
                int iC = c(view3);
                View view4 = this.f12737e;
                Rect rect = this.f12741m;
                androidx.coordinatorlayout.widget.b.a(this, view4, rect);
                int titleMarginEnd = rect.left + (z10 ? this.f12735c.getTitleMarginEnd() : this.f12735c.getTitleMarginStart());
                int titleMarginTop = this.f12735c.getTitleMarginTop() + rect.top + iC;
                int titleMarginStart = rect.right + (z10 ? this.f12735c.getTitleMarginStart() : this.f12735c.getTitleMarginEnd());
                int titleMarginBottom = (rect.bottom + iC) - this.f12735c.getTitleMarginBottom();
                d dVar = this.f12742n;
                Rect rect2 = dVar.f12715e;
                if (rect2.left != titleMarginEnd || rect2.top != titleMarginTop || rect2.right != titleMarginStart || rect2.bottom != titleMarginBottom) {
                    rect2.set(titleMarginEnd, titleMarginTop, titleMarginStart, titleMarginBottom);
                    dVar.F = true;
                    dVar.h();
                }
                int i16 = z10 ? this.f12739k : this.h;
                int i17 = rect.top + this.f12738j;
                int i18 = (i12 - i10) - (z10 ? this.h : this.f12739k);
                int i19 = (i13 - i11) - this.f12740l;
                Rect rect3 = dVar.f12714d;
                if (rect3.left != i16 || rect3.top != i17 || rect3.right != i18 || rect3.bottom != i19) {
                    rect3.set(i16, i17, i18, i19);
                    dVar.F = true;
                    dVar.h();
                }
                dVar.j();
            }
        }
        g();
        int childCount3 = getChildCount();
        for (int i20 = 0; i20 < childCount3; i20++) {
            d(getChildAt(i20)).a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int height;
        int height2;
        b();
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i11);
        int iA = a();
        if (mode == 0 && iA > 0) {
            super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + iA, 1073741824));
        }
        if (this.f12735c != null) {
            if (this.f12743o) {
                d dVar = this.f12742n;
                if (TextUtils.isEmpty(dVar.f12730y)) {
                    dVar.n(this.f12735c.getTitle());
                }
            }
            View view = this.f12736d;
            if (view != null && view != this) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    height2 = view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                } else {
                    height2 = view.getHeight();
                }
                setMinimumHeight(height2);
                return;
            }
            Toolbar toolbar = this.f12735c;
            ViewGroup.LayoutParams layoutParams2 = toolbar.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                height = toolbar.getMeasuredHeight() + marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
            } else {
                height = toolbar.getHeight();
            }
            setMinimumHeight(height);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        Drawable drawable = this.f12745q;
        if (drawable != null) {
            drawable.setBounds(0, 0, i10, i11);
        }
    }

    public void setCollapsedTitleGravity(int i10) {
        d dVar = this.f12742n;
        if (dVar.f12717k != i10) {
            dVar.f12717k = i10;
            dVar.j();
        }
    }

    public void setCollapsedTitleTextAppearance(int i10) throws Resources.NotFoundException {
        this.f12742n.k(i10);
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        d dVar = this.f12742n;
        if (dVar.f12721o != colorStateList) {
            dVar.f12721o = colorStateList;
            dVar.j();
        }
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        d dVar = this.f12742n;
        if (d.a(dVar.f12727v, typeface)) {
            dVar.f12727v = typeface;
            dVar.j();
        }
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.f12745q;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f12745q = drawableMutate;
            if (drawableMutate != null) {
                drawableMutate.setBounds(0, 0, getWidth(), getHeight());
                this.f12745q.setCallback(this);
                this.f12745q.setAlpha(this.f12746s);
            }
            WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
            postInvalidateOnAnimation();
        }
    }

    public void setContentScrimColor(int i10) {
        setContentScrim(new ColorDrawable(i10));
    }

    public void setContentScrimResource(int i10) {
        setContentScrim(getContext().getDrawable(i10));
    }

    public void setExpandedTitleColor(int i10) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i10));
    }

    public void setExpandedTitleGravity(int i10) {
        d dVar = this.f12742n;
        if (dVar.f12716j != i10) {
            dVar.f12716j = i10;
            dVar.j();
        }
    }

    public void setExpandedTitleMarginBottom(int i10) {
        this.f12740l = i10;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i10) {
        this.f12739k = i10;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i10) {
        this.h = i10;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i10) {
        this.f12738j = i10;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int i10) throws Resources.NotFoundException {
        this.f12742n.l(i10);
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        d dVar = this.f12742n;
        if (dVar.f12720n != colorStateList) {
            dVar.f12720n = colorStateList;
            dVar.j();
        }
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        d dVar = this.f12742n;
        if (d.a(dVar.f12728w, typeface)) {
            dVar.f12728w = typeface;
            dVar.j();
        }
    }

    public void setScrimAlpha(int i10) {
        Toolbar toolbar;
        if (i10 != this.f12746s) {
            if (this.f12745q != null && (toolbar = this.f12735c) != null) {
                WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
                toolbar.postInvalidateOnAnimation();
            }
            this.f12746s = i10;
            WeakHashMap<View, h0> weakHashMap2 = v0.e0.f13274a;
            postInvalidateOnAnimation();
        }
    }

    public void setScrimAnimationDuration(long j10) {
        this.f12749v = j10;
    }

    public void setScrimVisibleHeightTrigger(int i10) {
        if (this.f12750w != i10) {
            this.f12750w = i10;
            g();
        }
    }

    public void setScrimsShown(boolean z) {
        WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
        boolean z3 = isLaidOut() && !isInEditMode();
        if (this.f12747t != z) {
            if (z3) {
                int i10 = z ? 255 : 0;
                b();
                ValueAnimator valueAnimator = this.f12748u;
                if (valueAnimator == null) {
                    ValueAnimator valueAnimator2 = new ValueAnimator();
                    this.f12748u = valueAnimator2;
                    valueAnimator2.setDuration(this.f12749v);
                    this.f12748u.setInterpolator(i10 > this.f12746s ? stepos.support.v7.widget.c.f12706a : stepos.support.v7.widget.c.f12707b);
                    this.f12748u.addUpdateListener(new f(this));
                } else if (valueAnimator.isRunning()) {
                    this.f12748u.cancel();
                }
                this.f12748u.setIntValues(this.f12746s, i10);
                this.f12748u.start();
            } else {
                setScrimAlpha(z ? 255 : 0);
            }
            this.f12747t = z;
        }
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = this.r;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.r = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.r.setState(getDrawableState());
                }
                Drawable drawable3 = this.r;
                WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
                drawable3.setLayoutDirection(getLayoutDirection());
                this.r.setVisible(getVisibility() == 0, false);
                this.r.setCallback(this);
                this.r.setAlpha(this.f12746s);
            }
            WeakHashMap<View, h0> weakHashMap2 = v0.e0.f13274a;
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarScrimColor(int i10) {
        setStatusBarScrim(new ColorDrawable(i10));
    }

    public void setStatusBarScrimResource(int i10) {
        setStatusBarScrim(getContext().getDrawable(i10));
    }

    public void setTitle(CharSequence charSequence) {
        this.f12742n.n(charSequence);
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.f12743o) {
            this.f12743o = z;
            f();
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z = i10 == 0;
        Drawable drawable = this.r;
        if (drawable != null && drawable.isVisible() != z) {
            this.r.setVisible(z, false);
        }
        Drawable drawable2 = this.f12745q;
        if (drawable2 == null || drawable2.isVisible() == z) {
            return;
        }
        this.f12745q.setVisible(z, false);
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f12745q || drawable == this.r;
    }

    public e(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        super(context, attributeSet, i10);
        this.f12733a = true;
        this.f12741m = new Rect();
        this.f12750w = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(b0.f12705a);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(0);
        typedArrayObtainStyledAttributes.recycle();
        if (!zHasValue) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
        d dVar = new d(this);
        this.f12742n = dVar;
        dVar.H = stepos.support.v7.widget.c.f12709d;
        dVar.j();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, k4.a.h, i10, R.style.Widget_Design_CollapsingToolbar);
        int i11 = typedArrayObtainStyledAttributes2.getInt(9, 8388691);
        if (dVar.f12716j != i11) {
            dVar.f12716j = i11;
            dVar.j();
        }
        int i12 = typedArrayObtainStyledAttributes2.getInt(2, 8388627);
        if (dVar.f12717k != i12) {
            dVar.f12717k = i12;
            dVar.j();
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes2.getDimensionPixelSize(10, 0);
        this.f12740l = dimensionPixelSize;
        this.f12739k = dimensionPixelSize;
        this.f12738j = dimensionPixelSize;
        this.h = dimensionPixelSize;
        if (typedArrayObtainStyledAttributes2.hasValue(13)) {
            this.h = typedArrayObtainStyledAttributes2.getDimensionPixelSize(13, 0);
        }
        if (typedArrayObtainStyledAttributes2.hasValue(12)) {
            this.f12739k = typedArrayObtainStyledAttributes2.getDimensionPixelSize(12, 0);
        }
        if (typedArrayObtainStyledAttributes2.hasValue(14)) {
            this.f12738j = typedArrayObtainStyledAttributes2.getDimensionPixelSize(14, 0);
        }
        if (typedArrayObtainStyledAttributes2.hasValue(11)) {
            this.f12740l = typedArrayObtainStyledAttributes2.getDimensionPixelSize(11, 0);
        }
        this.f12743o = typedArrayObtainStyledAttributes2.getBoolean(28, true);
        setTitle(typedArrayObtainStyledAttributes2.getText(26));
        dVar.l(R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
        dVar.k(R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (typedArrayObtainStyledAttributes2.hasValue(16)) {
            dVar.l(typedArrayObtainStyledAttributes2.getResourceId(16, 0));
        }
        if (typedArrayObtainStyledAttributes2.hasValue(4)) {
            dVar.k(typedArrayObtainStyledAttributes2.getResourceId(4, 0));
        }
        this.f12750w = typedArrayObtainStyledAttributes2.getDimensionPixelSize(22, -1);
        this.f12749v = typedArrayObtainStyledAttributes2.getInt(21, 600);
        setContentScrim(typedArrayObtainStyledAttributes2.getDrawable(6));
        setStatusBarScrim(typedArrayObtainStyledAttributes2.getDrawable(23));
        this.f12734b = typedArrayObtainStyledAttributes2.getResourceId(32, -1);
        typedArrayObtainStyledAttributes2.recycle();
        setWillNotDraw(false);
        a aVar = new a();
        WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
        e0.d.k(this, aVar);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        b bVar = new b(context, attributeSet);
        bVar.f12754a = 0;
        bVar.f12755b = 0.5f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k4.a.f9904i);
        bVar.f12754a = typedArrayObtainStyledAttributes.getInt(0, 0);
        bVar.f12755b = typedArrayObtainStyledAttributes.getFloat(1, 0.5f);
        typedArrayObtainStyledAttributes.recycle();
        return bVar;
    }

    public void setCollapsedTitleTextColor(int i10) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i10));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateDefaultLayoutParams() {
        b bVar = new b(-1, -1);
        bVar.f12754a = 0;
        bVar.f12755b = 0.5f;
        return bVar;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        b bVar = new b(layoutParams);
        bVar.f12754a = 0;
        bVar.f12755b = 0.5f;
        return bVar;
    }
}
