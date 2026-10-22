package stepos.support.v7.widget;

import K.z0;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
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
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import com.baidu.platform.comapi.UIMsg;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;
import java.util.WeakHashMap;
import m1.AbstractC0769a;
import stepos.support.v7.app.C0872q;

/* renamed from: stepos.support.v7.widget.y, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0904y extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public boolean f15228a;

    /* renamed from: b, reason: collision with root package name */
    public final int f15229b;

    /* renamed from: c, reason: collision with root package name */
    public Toolbar f15230c;

    /* renamed from: d, reason: collision with root package name */
    public View f15231d;

    /* renamed from: e, reason: collision with root package name */
    public View f15232e;

    /* renamed from: f, reason: collision with root package name */
    public int f15233f;

    /* renamed from: g, reason: collision with root package name */
    public int f15234g;

    /* renamed from: h, reason: collision with root package name */
    public int f15235h;

    /* renamed from: i, reason: collision with root package name */
    public int f15236i;

    /* renamed from: j, reason: collision with root package name */
    public final Rect f15237j;

    /* renamed from: k, reason: collision with root package name */
    public final C0902w f15238k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f15239l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f15240m;

    /* renamed from: n, reason: collision with root package name */
    public Drawable f15241n;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f15242o;

    /* renamed from: p, reason: collision with root package name */
    public int f15243p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f15244q;

    /* renamed from: r, reason: collision with root package name */
    public ValueAnimator f15245r;

    /* renamed from: s, reason: collision with root package name */
    public long f15246s;

    /* renamed from: t, reason: collision with root package name */
    public int f15247t;

    /* renamed from: u, reason: collision with root package name */
    public C0884d f15248u;

    /* renamed from: v, reason: collision with root package name */
    public int f15249v;

    /* renamed from: w, reason: collision with root package name */
    public z0 f15250w;

    public AbstractC0904y(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.steposCollapsingToolbarLayoutStyle);
        this.f15228a = true;
        this.f15237j = new Rect();
        this.f15247t = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(q0.f15142a);
        boolean z4 = !typedArrayObtainStyledAttributes.hasValue(0);
        typedArrayObtainStyledAttributes.recycle();
        if (z4) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
        C0902w c0902w = new C0902w((StepOSCollapsingToolbarLayout) this);
        this.f15238k = c0902w;
        c0902w.f15165E = AbstractC0901v.f15157d;
        c0902w.j();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, AbstractC0769a.f13542h, R.attr.steposCollapsingToolbarLayoutStyle, R.style.Widget_Design_CollapsingToolbar);
        int i4 = 9;
        int i5 = typedArrayObtainStyledAttributes2.getInt(9, 8388691);
        if (c0902w.f15181g != i5) {
            c0902w.f15181g = i5;
            c0902w.j();
        }
        int i6 = typedArrayObtainStyledAttributes2.getInt(2, 8388627);
        if (c0902w.f15182h != i6) {
            c0902w.f15182h = i6;
            c0902w.j();
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes2.getDimensionPixelSize(10, 0);
        this.f15236i = dimensionPixelSize;
        this.f15235h = dimensionPixelSize;
        this.f15234g = dimensionPixelSize;
        this.f15233f = dimensionPixelSize;
        if (typedArrayObtainStyledAttributes2.hasValue(13)) {
            this.f15233f = typedArrayObtainStyledAttributes2.getDimensionPixelSize(13, 0);
        }
        if (typedArrayObtainStyledAttributes2.hasValue(12)) {
            this.f15235h = typedArrayObtainStyledAttributes2.getDimensionPixelSize(12, 0);
        }
        if (typedArrayObtainStyledAttributes2.hasValue(14)) {
            this.f15234g = typedArrayObtainStyledAttributes2.getDimensionPixelSize(14, 0);
        }
        if (typedArrayObtainStyledAttributes2.hasValue(11)) {
            this.f15236i = typedArrayObtainStyledAttributes2.getDimensionPixelSize(11, 0);
        }
        this.f15239l = typedArrayObtainStyledAttributes2.getBoolean(28, true);
        setTitle(typedArrayObtainStyledAttributes2.getText(26));
        c0902w.l(R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
        c0902w.k(R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (typedArrayObtainStyledAttributes2.hasValue(16)) {
            c0902w.l(typedArrayObtainStyledAttributes2.getResourceId(16, 0));
        }
        if (typedArrayObtainStyledAttributes2.hasValue(4)) {
            c0902w.k(typedArrayObtainStyledAttributes2.getResourceId(4, 0));
        }
        this.f15247t = typedArrayObtainStyledAttributes2.getDimensionPixelSize(22, -1);
        this.f15246s = typedArrayObtainStyledAttributes2.getInt(21, UIMsg.MSG_MAP_PANO_DATA);
        setContentScrim(typedArrayObtainStyledAttributes2.getDrawable(6));
        setStatusBarScrim(typedArrayObtainStyledAttributes2.getDrawable(23));
        this.f15229b = typedArrayObtainStyledAttributes2.getResourceId(32, -1);
        typedArrayObtainStyledAttributes2.recycle();
        setWillNotDraw(false);
        C0872q c0872q = new C0872q(i4, this);
        WeakHashMap weakHashMap = K.S.f939a;
        K.J.u(this, c0872q);
    }

    public static x0 d(View view) {
        x0 x0Var = (x0) view.getTag(R.id.view_offset_helper);
        if (x0Var != null) {
            return x0Var;
        }
        x0 x0Var2 = new x0(view);
        view.setTag(R.id.view_offset_helper, x0Var2);
        return x0Var2;
    }

    public abstract int a();

    public final void b() {
        if (this.f15228a) {
            Toolbar toolbar = null;
            this.f15230c = null;
            this.f15231d = null;
            int i4 = this.f15229b;
            if (i4 != -1) {
                Toolbar toolbar2 = (Toolbar) findViewById(i4);
                this.f15230c = toolbar2;
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
                    this.f15231d = view;
                }
            }
            if (this.f15230c == null) {
                int childCount = getChildCount();
                int i5 = 0;
                while (true) {
                    if (i5 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i5);
                    if (childAt instanceof Toolbar) {
                        toolbar = (Toolbar) childAt;
                        break;
                    }
                    i5++;
                }
                this.f15230c = toolbar;
            }
            e();
            this.f15228a = false;
        }
    }

    public final int c(View view) {
        x0 x0VarD = d(view);
        C0903x c0903x = (C0903x) view.getLayoutParams();
        int i4 = x0VarD.f15225b;
        return ((getHeight() - Math.max(i4, this.f15250w != null ? a() : i4)) - view.getHeight()) - ((FrameLayout.LayoutParams) c0903x).bottomMargin;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0903x;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int iA;
        Drawable drawable;
        super.draw(canvas);
        b();
        if (this.f15230c == null && (drawable = this.f15241n) != null && this.f15243p > 0) {
            drawable.mutate().setAlpha(this.f15243p);
            this.f15241n.draw(canvas);
        }
        if (this.f15239l && this.f15240m) {
            C0902w c0902w = this.f15238k;
            c0902w.getClass();
            int iSave = canvas.save();
            if (c0902w.f15197w != null && c0902w.f15176b) {
                float f4 = c0902w.f15191q;
                float f5 = c0902w.f15192r + Property.DEFAULT_FLOAT_VALUE;
                if (C0902w.f(c0902w.f15177c, Property.DEFAULT_FLOAT_VALUE)) {
                    f5 += c0902w.f15174N;
                }
                float f6 = f5;
                TextPaint textPaint = c0902w.f15164D;
                textPaint.ascent();
                textPaint.descent();
                float f7 = c0902w.f15200z;
                if (f7 != 1.0f) {
                    canvas.scale(f7, f7, f4, f6);
                }
                CharSequence charSequence = c0902w.f15197w;
                canvas.drawText(charSequence, 0, charSequence.length(), f4, f6, textPaint);
            }
            canvas.restoreToCount(iSave);
        }
        if (this.f15242o == null || this.f15243p <= 0 || (iA = a()) <= 0) {
            return;
        }
        this.f15242o.setBounds(0, -this.f15249v, getWidth(), iA - this.f15249v);
        this.f15242o.mutate().setAlpha(this.f15243p);
        this.f15242o.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j4) {
        boolean z4;
        View view2;
        Drawable drawable = this.f15241n;
        if (drawable == null || this.f15243p <= 0 || ((view2 = this.f15231d) == null || view2 == this ? view != this.f15230c : view != view2)) {
            z4 = false;
        } else {
            drawable.mutate().setAlpha(this.f15243p);
            this.f15241n.draw(canvas);
            z4 = true;
        }
        return super.drawChild(canvas, view, j4) || z4;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        ColorStateList colorStateList;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f15242o;
        boolean z4 = false;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.f15241n;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        C0902w c0902w = this.f15238k;
        if (c0902w != null) {
            c0902w.f15162B = drawableState;
            ColorStateList colorStateList2 = c0902w.f15186l;
            if ((colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = c0902w.f15185k) != null && colorStateList.isStateful())) {
                c0902w.j();
                z4 = true;
            }
            state |= z4;
        }
        if (state) {
            invalidate();
        }
    }

    public final void e() {
        View view;
        if (!this.f15239l && (view = this.f15232e) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f15232e);
            }
        }
        if (!this.f15239l || this.f15230c == null) {
            return;
        }
        if (this.f15232e == null) {
            this.f15232e = new View(getContext());
        }
        if (this.f15232e.getParent() == null) {
            this.f15230c.addView(this.f15232e, -1, -1);
        }
    }

    public final void f() {
        if (this.f15241n == null && this.f15242o == null) {
            return;
        }
        setScrimsShown(getHeight() + this.f15249v < getScrimVisibleHeightTrigger());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        C0903x c0903x = new C0903x(-1, -1);
        c0903x.f15222a = 0;
        c0903x.f15223b = 0.5f;
        return c0903x;
    }

    public int getCollapsedTitleGravity() {
        return this.f15238k.f15182h;
    }

    @NonNull
    public Typeface getCollapsedTitleTypeface() {
        Typeface typeface = this.f15238k.f15193s;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    @Nullable
    public Drawable getContentScrim() {
        return this.f15241n;
    }

    public int getExpandedTitleGravity() {
        return this.f15238k.f15181g;
    }

    public int getExpandedTitleMarginBottom() {
        return this.f15236i;
    }

    public int getExpandedTitleMarginEnd() {
        return this.f15235h;
    }

    public int getExpandedTitleMarginStart() {
        return this.f15233f;
    }

    public int getExpandedTitleMarginTop() {
        return this.f15234g;
    }

    @NonNull
    public Typeface getExpandedTitleTypeface() {
        Typeface typeface = this.f15238k.f15194t;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public int getScrimAlpha() {
        return this.f15243p;
    }

    public long getScrimAnimationDuration() {
        return this.f15246s;
    }

    public int getScrimVisibleHeightTrigger() {
        int i4 = this.f15247t;
        if (i4 >= 0) {
            return i4;
        }
        int iA = a();
        WeakHashMap weakHashMap = K.S.f939a;
        int minimumHeight = getMinimumHeight();
        return minimumHeight > 0 ? Math.min((minimumHeight * 2) + iA, getHeight()) : getHeight() / 3;
    }

    @Nullable
    public Drawable getStatusBarScrim() {
        return this.f15242o;
    }

    @Nullable
    public CharSequence getTitle() {
        if (this.f15239l) {
            return this.f15230c.getTitle();
        }
        return null;
    }

    public J getTitleScaleControl() {
        return this.f15238k;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Object parent = getParent();
        if (parent instanceof com.google.android.material.appbar.h) {
            WeakHashMap weakHashMap = K.S.f939a;
            setFitsSystemWindows(((View) parent).getFitsSystemWindows());
            if (this.f15248u == null) {
                this.f15248u = new C0884d(this, 1);
            }
            ((com.google.android.material.appbar.h) parent).c(this.f15248u);
            K.H.c(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        ArrayList arrayList;
        ViewParent parent = getParent();
        C0884d c0884d = this.f15248u;
        if (c0884d != null && (parent instanceof com.google.android.material.appbar.h) && (arrayList = ((com.google.android.material.appbar.h) parent).f10302h) != null) {
            arrayList.remove(c0884d);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        View view;
        super.onLayout(z4, i4, i5, i6, i7);
        if (this.f15250w != null) {
            int iA = a();
            int childCount = getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                WeakHashMap weakHashMap = K.S.f939a;
                if (!childAt.getFitsSystemWindows() && childAt.getTop() < iA) {
                    childAt.offsetTopAndBottom(iA);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i9 = 0; i9 < childCount2; i9++) {
            x0 x0VarD = d(getChildAt(i9));
            View view2 = x0VarD.f15224a;
            x0VarD.f15225b = view2.getTop();
            x0VarD.f15226c = view2.getLeft();
        }
        if (this.f15239l && (view = this.f15232e) != null) {
            WeakHashMap weakHashMap2 = K.S.f939a;
            boolean z5 = view.isAttachedToWindow() && this.f15232e.getVisibility() == 0;
            this.f15240m = z5;
            if (z5) {
                boolean z6 = getLayoutDirection() == 1;
                View view3 = this.f15231d;
                if (view3 == null) {
                    view3 = this.f15230c;
                }
                int iC = c(view3);
                View view4 = this.f15232e;
                Rect rect = this.f15237j;
                A.g.a(this, view4, rect);
                int titleMarginEnd = rect.left + (z6 ? this.f15230c.getTitleMarginEnd() : this.f15230c.getTitleMarginStart());
                int titleMarginTop = this.f15230c.getTitleMarginTop() + rect.top + iC;
                int titleMarginStart = rect.right + (z6 ? this.f15230c.getTitleMarginStart() : this.f15230c.getTitleMarginEnd());
                int titleMarginBottom = (rect.bottom + iC) - this.f15230c.getTitleMarginBottom();
                C0902w c0902w = this.f15238k;
                Rect rect2 = c0902w.f15179e;
                if (rect2.left != titleMarginEnd || rect2.top != titleMarginTop || rect2.right != titleMarginStart || rect2.bottom != titleMarginBottom) {
                    rect2.set(titleMarginEnd, titleMarginTop, titleMarginStart, titleMarginBottom);
                    c0902w.f15163C = true;
                    c0902w.h();
                }
                int i10 = z6 ? this.f15235h : this.f15233f;
                int i11 = rect.top + this.f15234g;
                int i12 = (i6 - i4) - (z6 ? this.f15233f : this.f15235h);
                int i13 = (i7 - i5) - this.f15236i;
                Rect rect3 = c0902w.f15178d;
                if (rect3.left != i10 || rect3.top != i11 || rect3.right != i12 || rect3.bottom != i13) {
                    rect3.set(i10, i11, i12, i13);
                    c0902w.f15163C = true;
                    c0902w.h();
                }
                c0902w.j();
            }
        }
        f();
        int childCount3 = getChildCount();
        for (int i14 = 0; i14 < childCount3; i14++) {
            d(getChildAt(i14)).a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i4, int i5) {
        int height;
        int height2;
        b();
        super.onMeasure(i4, i5);
        int mode = View.MeasureSpec.getMode(i5);
        int iA = a();
        if (mode == 0 && iA > 0) {
            super.onMeasure(i4, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + iA, 1073741824));
        }
        if (this.f15230c != null) {
            if (this.f15239l) {
                C0902w c0902w = this.f15238k;
                if (TextUtils.isEmpty(c0902w.f15196v)) {
                    c0902w.n(this.f15230c.getTitle());
                }
            }
            View view = this.f15231d;
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
            Toolbar toolbar = this.f15230c;
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
    public final void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        Drawable drawable = this.f15241n;
        if (drawable != null) {
            drawable.setBounds(0, 0, i4, i5);
        }
    }

    public void setCollapsedTitleGravity(int i4) {
        C0902w c0902w = this.f15238k;
        if (c0902w.f15182h != i4) {
            c0902w.f15182h = i4;
            c0902w.j();
        }
    }

    public void setCollapsedTitleTextAppearance(@StyleRes int i4) {
        this.f15238k.k(i4);
    }

    public void setCollapsedTitleTextColor(@NonNull ColorStateList colorStateList) {
        C0902w c0902w = this.f15238k;
        if (c0902w.f15186l != colorStateList) {
            c0902w.f15186l = colorStateList;
            c0902w.j();
        }
    }

    public void setCollapsedTitleTypeface(@Nullable Typeface typeface) {
        C0902w c0902w = this.f15238k;
        if (C0902w.c(c0902w.f15193s, typeface)) {
            c0902w.f15193s = typeface;
            c0902w.j();
        }
    }

    public void setContentScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f15241n;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f15241n = drawableMutate;
            if (drawableMutate != null) {
                drawableMutate.setBounds(0, 0, getWidth(), getHeight());
                this.f15241n.setCallback(this);
                this.f15241n.setAlpha(this.f15243p);
            }
            WeakHashMap weakHashMap = K.S.f939a;
            postInvalidateOnAnimation();
        }
    }

    public void setContentScrimColor(@ColorInt int i4) {
        setContentScrim(new ColorDrawable(i4));
    }

    public void setContentScrimResource(@DrawableRes int i4) {
        setContentScrim(androidx.core.content.a.b(getContext(), i4));
    }

    public void setExpandedTitleColor(@ColorInt int i4) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i4));
    }

    public void setExpandedTitleGravity(int i4) {
        C0902w c0902w = this.f15238k;
        if (c0902w.f15181g != i4) {
            c0902w.f15181g = i4;
            c0902w.j();
        }
    }

    public void setExpandedTitleMarginBottom(int i4) {
        this.f15236i = i4;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i4) {
        this.f15235h = i4;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i4) {
        this.f15233f = i4;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i4) {
        this.f15234g = i4;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(@StyleRes int i4) {
        this.f15238k.l(i4);
    }

    public void setExpandedTitleTextColor(@NonNull ColorStateList colorStateList) {
        C0902w c0902w = this.f15238k;
        if (c0902w.f15185k != colorStateList) {
            c0902w.f15185k = colorStateList;
            c0902w.j();
        }
    }

    public void setExpandedTitleTypeface(@Nullable Typeface typeface) {
        C0902w c0902w = this.f15238k;
        if (C0902w.c(c0902w.f15194t, typeface)) {
            c0902w.f15194t = typeface;
            c0902w.j();
        }
    }

    public void setScrimAlpha(int i4) {
        Toolbar toolbar;
        if (i4 != this.f15243p) {
            if (this.f15241n != null && (toolbar = this.f15230c) != null) {
                WeakHashMap weakHashMap = K.S.f939a;
                toolbar.postInvalidateOnAnimation();
            }
            this.f15243p = i4;
            WeakHashMap weakHashMap2 = K.S.f939a;
            postInvalidateOnAnimation();
        }
    }

    public void setScrimAnimationDuration(@IntRange(from = 0) long j4) {
        this.f15246s = j4;
    }

    public void setScrimVisibleHeightTrigger(@IntRange(from = 0) int i4) {
        if (this.f15247t != i4) {
            this.f15247t = i4;
            f();
        }
    }

    public void setScrimsShown(boolean z4) {
        WeakHashMap weakHashMap = K.S.f939a;
        boolean z5 = isLaidOut() && !isInEditMode();
        if (this.f15244q != z4) {
            if (z5) {
                int i4 = z4 ? 255 : 0;
                b();
                ValueAnimator valueAnimator = this.f15245r;
                if (valueAnimator == null) {
                    ValueAnimator valueAnimator2 = new ValueAnimator();
                    this.f15245r = valueAnimator2;
                    valueAnimator2.setDuration(this.f15246s);
                    this.f15245r.setInterpolator(i4 > this.f15243p ? AbstractC0901v.f15154a : AbstractC0901v.f15155b);
                    this.f15245r.addUpdateListener(new com.airbnb.lottie.q(6, this));
                } else if (valueAnimator.isRunning()) {
                    this.f15245r.cancel();
                }
                this.f15245r.setIntValues(this.f15243p, i4);
                this.f15245r.start();
            } else {
                setScrimAlpha(z4 ? 255 : 0);
            }
            this.f15244q = z4;
        }
    }

    public void setStatusBarScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f15242o;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f15242o = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f15242o.setState(getDrawableState());
                }
                Drawable drawable3 = this.f15242o;
                WeakHashMap weakHashMap = K.S.f939a;
                E.b.b(drawable3, getLayoutDirection());
                this.f15242o.setVisible(getVisibility() == 0, false);
                this.f15242o.setCallback(this);
                this.f15242o.setAlpha(this.f15243p);
            }
            WeakHashMap weakHashMap2 = K.S.f939a;
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarScrimColor(@ColorInt int i4) {
        setStatusBarScrim(new ColorDrawable(i4));
    }

    public void setStatusBarScrimResource(@DrawableRes int i4) {
        setStatusBarScrim(androidx.core.content.a.b(getContext(), i4));
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.f15238k.n(charSequence);
    }

    public void setTitleEnabled(boolean z4) {
        if (z4 != this.f15239l) {
            this.f15239l = z4;
            e();
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        super.setVisibility(i4);
        boolean z4 = i4 == 0;
        Drawable drawable = this.f15242o;
        if (drawable != null && drawable.isVisible() != z4) {
            this.f15242o.setVisible(z4, false);
        }
        Drawable drawable2 = this.f15241n;
        if (drawable2 == null || drawable2.isVisible() == z4) {
            return;
        }
        this.f15241n.setVisible(z4, false);
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f15241n || drawable == this.f15242o;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        C0903x c0903x = new C0903x(context, attributeSet);
        c0903x.f15222a = 0;
        c0903x.f15223b = 0.5f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0769a.f13543i);
        c0903x.f15222a = typedArrayObtainStyledAttributes.getInt(0, 0);
        c0903x.f15223b = typedArrayObtainStyledAttributes.getFloat(1, 0.5f);
        typedArrayObtainStyledAttributes.recycle();
        return c0903x;
    }

    public void setCollapsedTitleTextColor(@ColorInt int i4) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i4));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateDefaultLayoutParams() {
        C0903x c0903x = new C0903x(-1, -1);
        c0903x.f15222a = 0;
        c0903x.f15223b = 0.5f;
        return c0903x;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        C0903x c0903x = new C0903x(layoutParams);
        c0903x.f15222a = 0;
        c0903x.f15223b = 0.5f;
        return c0903x;
    }
}
