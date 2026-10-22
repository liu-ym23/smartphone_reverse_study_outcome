package com.google.android.material.button;

import P.f;
import P.i;
import P.j;
import a1.C0409b;
import a1.C0417j;
import a1.C0418k;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.appcompat.widget.C0436f;
import h.C0744a;
import java.util.Iterator;
import java.util.LinkedHashSet;
import q1.C0981c;
import t1.C1115h;
import t1.C1116i;
import t1.l;
import t1.o;
import t1.q;
import t1.r;
import x1.C1282a;

/* loaded from: classes.dex */
public class MaterialButton extends C0436f implements Checkable, o {

    /* renamed from: F, reason: collision with root package name */
    private static final int[] f12388F = {R.attr.state_checkable};

    /* renamed from: G, reason: collision with root package name */
    private static final int[] f12389G = {R.attr.state_checked};

    /* renamed from: H, reason: collision with root package name */
    private static final int f12390H = C0417j.f6923n;

    /* renamed from: I, reason: collision with root package name */
    private static final int f12391I = C0409b.f6733t;

    /* renamed from: J, reason: collision with root package name */
    private static final f<MaterialButton> f12392J = new a("widthIncrease");

    /* renamed from: A, reason: collision with root package name */
    r f12393A;

    /* renamed from: B, reason: collision with root package name */
    int f12394B;

    /* renamed from: C, reason: collision with root package name */
    private float f12395C;

    /* renamed from: D, reason: collision with root package name */
    private float f12396D;

    /* renamed from: E, reason: collision with root package name */
    private i f12397E;

    /* renamed from: d, reason: collision with root package name */
    private final e f12398d;

    /* renamed from: e, reason: collision with root package name */
    private final LinkedHashSet<b> f12399e;

    /* renamed from: f, reason: collision with root package name */
    private c f12400f;

    /* renamed from: g, reason: collision with root package name */
    private PorterDuff.Mode f12401g;

    /* renamed from: h, reason: collision with root package name */
    private ColorStateList f12402h;

    /* renamed from: i, reason: collision with root package name */
    private Drawable f12403i;

    /* renamed from: j, reason: collision with root package name */
    private String f12404j;

    /* renamed from: k, reason: collision with root package name */
    private int f12405k;

    /* renamed from: l, reason: collision with root package name */
    private int f12406l;

    /* renamed from: m, reason: collision with root package name */
    private int f12407m;

    /* renamed from: n, reason: collision with root package name */
    private int f12408n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f12409o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f12410p;

    /* renamed from: q, reason: collision with root package name */
    private int f12411q;

    /* renamed from: r, reason: collision with root package name */
    private int f12412r;

    /* renamed from: s, reason: collision with root package name */
    private float f12413s;

    /* renamed from: t, reason: collision with root package name */
    private int f12414t;

    /* renamed from: u, reason: collision with root package name */
    private int f12415u;

    /* renamed from: v, reason: collision with root package name */
    private LinearLayout.LayoutParams f12416v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f12417w;

    /* renamed from: x, reason: collision with root package name */
    private int f12418x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f12419y;

    /* renamed from: z, reason: collision with root package name */
    int f12420z;

    class a extends f<MaterialButton> {
        a(String str) {
            super(str);
        }

        @Override // P.f
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(MaterialButton materialButton) {
            return materialButton.getDisplayedWidthIncrease();
        }

        @Override // P.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(MaterialButton materialButton, float f5) {
            materialButton.setDisplayedWidthIncrease(f5);
        }
    }

    public interface b {
        void a(MaterialButton materialButton, boolean z5);
    }

    interface c {
        void a(MaterialButton materialButton, boolean z5);
    }

    static class d extends androidx.customview.view.a {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        boolean f12421a;

        class a implements Parcelable.ClassLoaderCreator<d> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new d(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i5) {
                return new d[i5];
            }
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }

        private void a(Parcel parcel) {
            this.f12421a = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeInt(this.f12421a ? 1 : 0);
        }

        public d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            a(parcel);
        }
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0409b.f6728o);
    }

    public static /* synthetic */ void a(MaterialButton materialButton) {
        materialButton.f12418x = materialButton.getOpticalCenterShift();
        materialButton.s();
        materialButton.invalidate();
    }

    public static /* synthetic */ void b(MaterialButton materialButton, float f5) {
        int i5 = (int) (f5 * 0.11f);
        if (materialButton.f12418x != i5) {
            materialButton.f12418x = i5;
            materialButton.s();
            materialButton.invalidate();
        }
    }

    private j e() {
        return o1.e.h(getContext(), C0409b.f6699I, C0417j.f6910a);
    }

    private void f() {
        i iVar = new i(this, f12392J);
        this.f12397E = iVar;
        iVar.x(e());
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getDisplayedWidthIncrease() {
        return this.f12395C;
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getOpticalCenterShift() {
        C1115h c1115hG;
        if (this.f12417w && this.f12419y && (c1115hG = this.f12398d.g()) != null) {
            return (int) (c1115hG.z() * 0.11f);
        }
        return 0;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(string, 0, string.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        float fMax = 0.0f;
        for (int i5 = 0; i5 < lineCount; i5++) {
            fMax = Math.max(fMax, getLayout().getLineWidth(i5));
        }
        return (int) Math.ceil(fMax);
    }

    private boolean h() {
        int i5 = this.f12411q;
        return i5 == 3 || i5 == 4;
    }

    private boolean i() {
        int i5 = this.f12411q;
        return i5 == 1 || i5 == 2;
    }

    private boolean j() {
        int i5 = this.f12411q;
        return i5 == 16 || i5 == 32;
    }

    private boolean k() {
        return (getParent() instanceof com.google.android.material.button.d) && ((com.google.android.material.button.d) getParent()).getOrientation() == 0;
    }

    private boolean l() {
        return getLayoutDirection() == 1;
    }

    private boolean m() {
        e eVar = this.f12398d;
        return (eVar == null || eVar.q()) ? false : true;
    }

    private void n(boolean z5) {
        if (this.f12393A == null) {
            return;
        }
        if (this.f12397E == null) {
            f();
        }
        if (this.f12419y) {
            this.f12397E.s(Math.min(this.f12394B, this.f12393A.e(getDrawableState()).f22480a.a(getWidth())));
            if (z5) {
                this.f12397E.y();
            }
        }
    }

    private void p() {
        if (i()) {
            setCompoundDrawablesRelative(this.f12403i, null, null, null);
        } else if (h()) {
            setCompoundDrawablesRelative(null, null, this.f12403i, null);
        } else if (j()) {
            setCompoundDrawablesRelative(null, this.f12403i, null, null);
        }
    }

    private void q(boolean z5) {
        Drawable drawable = this.f12403i;
        if (drawable != null) {
            Drawable drawableMutate = androidx.core.graphics.drawable.a.r(drawable).mutate();
            this.f12403i = drawableMutate;
            drawableMutate.setTintList(this.f12402h);
            PorterDuff.Mode mode = this.f12401g;
            if (mode != null) {
                this.f12403i.setTintMode(mode);
            }
            int intrinsicWidth = this.f12405k;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.f12403i.getIntrinsicWidth();
            }
            int intrinsicHeight = this.f12405k;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.f12403i.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f12403i;
            int i5 = this.f12406l;
            int i6 = this.f12407m;
            drawable2.setBounds(i5, i6, intrinsicWidth + i5, intrinsicHeight + i6);
            this.f12403i.setVisible(true, z5);
        }
        if (z5) {
            p();
            return;
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        if ((!i() || drawable3 == this.f12403i) && ((!h() || drawable5 == this.f12403i) && (!j() || drawable4 == this.f12403i))) {
            return;
        }
        p();
    }

    private void r(int i5, int i6) {
        if (this.f12403i == null || getLayout() == null) {
            return;
        }
        if (!i() && !h()) {
            if (j()) {
                this.f12406l = 0;
                if (this.f12411q == 16) {
                    this.f12407m = 0;
                    q(false);
                    return;
                }
                int intrinsicHeight = this.f12405k;
                if (intrinsicHeight == 0) {
                    intrinsicHeight = this.f12403i.getIntrinsicHeight();
                }
                int iMax = Math.max(0, (((((i6 - getTextHeight()) - getPaddingTop()) - intrinsicHeight) - this.f12408n) - getPaddingBottom()) / 2);
                if (this.f12407m != iMax) {
                    this.f12407m = iMax;
                    q(false);
                    return;
                }
                return;
            }
            return;
        }
        this.f12407m = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i7 = this.f12411q;
        if (i7 == 1 || i7 == 3 || ((i7 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i7 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.f12406l = 0;
            q(false);
            return;
        }
        int intrinsicWidth = this.f12405k;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.f12403i.getIntrinsicWidth();
        }
        int textLayoutWidth = ((((i5 - getTextLayoutWidth()) - getPaddingEnd()) - intrinsicWidth) - this.f12408n) - getPaddingStart();
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            textLayoutWidth /= 2;
        }
        if (l() != (this.f12411q == 4)) {
            textLayoutWidth = -textLayoutWidth;
        }
        if (this.f12406l != textLayoutWidth) {
            this.f12406l = textLayoutWidth;
            q(false);
        }
    }

    private void s() {
        int i5 = (int) (this.f12395C - this.f12396D);
        int i6 = (i5 / 2) + this.f12418x;
        getLayoutParams().width = (int) (this.f12413s + i5);
        setPaddingRelative(this.f12414t + i6, getPaddingTop(), (this.f12415u + i5) - i6, getPaddingBottom());
    }

    private void setCheckedInternal(boolean z5) {
        if (!g() || this.f12409o == z5) {
            return;
        }
        this.f12409o = z5;
        refreshDrawableState();
        if (getParent() instanceof MaterialButtonToggleGroup) {
            ((MaterialButtonToggleGroup) getParent()).w(this, this.f12409o);
        }
        if (this.f12410p) {
            return;
        }
        this.f12410p = true;
        Iterator<b> it = this.f12399e.iterator();
        while (it.hasNext()) {
            it.next().a(this, this.f12409o);
        }
        this.f12410p = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayedWidthIncrease(float f5) {
        if (this.f12395C != f5) {
            this.f12395C = f5;
            s();
            invalidate();
            if (getParent() instanceof com.google.android.material.button.d) {
                ((com.google.android.material.button.d) getParent()).k(this, (int) this.f12395C);
            }
        }
    }

    public boolean g() {
        e eVar = this.f12398d;
        return eVar != null && eVar.r();
    }

    String getA11yClassName() {
        if (TextUtils.isEmpty(this.f12404j)) {
            return (g() ? CompoundButton.class : Button.class).getName();
        }
        return this.f12404j;
    }

    int getAllowedWidthDecrease() {
        return this.f12420z;
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (m()) {
            return this.f12398d.b();
        }
        return 0;
    }

    public j getCornerSpringForce() {
        return this.f12398d.c();
    }

    public Drawable getIcon() {
        return this.f12403i;
    }

    public int getIconGravity() {
        return this.f12411q;
    }

    public int getIconPadding() {
        return this.f12408n;
    }

    public int getIconSize() {
        return this.f12405k;
    }

    public ColorStateList getIconTint() {
        return this.f12402h;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f12401g;
    }

    public int getInsetBottom() {
        return this.f12398d.d();
    }

    public int getInsetTop() {
        return this.f12398d.e();
    }

    public ColorStateList getRippleColor() {
        if (m()) {
            return this.f12398d.i();
        }
        return null;
    }

    public l getShapeAppearanceModel() {
        if (m()) {
            return this.f12398d.j();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public q getStateListShapeAppearanceModel() {
        if (m()) {
            return this.f12398d.k();
        }
        throw new IllegalStateException("Attempted to get StateListShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (m()) {
            return this.f12398d.l();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (m()) {
            return this.f12398d.m();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.C0436f
    public ColorStateList getSupportBackgroundTintList() {
        return m() ? this.f12398d.n() : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.C0436f
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return m() ? this.f12398d.o() : super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f12409o;
    }

    void o() {
        LinearLayout.LayoutParams layoutParams = this.f12416v;
        if (layoutParams != null) {
            setLayoutParams(layoutParams);
            this.f12416v = null;
            this.f12413s = -1.0f;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (m()) {
            C1116i.f(this, this.f12398d.g());
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i5) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i5 + 2);
        if (g()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f12388F);
        }
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f12389G);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.C0436f, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.C0436f, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(g());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.C0436f, android.widget.TextView, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        int i9;
        super.onLayout(z5, i5, i6, i7, i8);
        r(getMeasuredWidth(), getMeasuredHeight());
        int i10 = getResources().getConfiguration().orientation;
        if (this.f12412r != i10) {
            this.f12412r = i10;
            this.f12413s = -1.0f;
        }
        if (this.f12413s == -1.0f) {
            this.f12413s = getMeasuredWidth();
            if (this.f12416v == null && (getParent() instanceof com.google.android.material.button.d) && ((com.google.android.material.button.d) getParent()).getButtonSizeChange() != null) {
                this.f12416v = (LinearLayout.LayoutParams) getLayoutParams();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f12416v);
                layoutParams.width = (int) this.f12413s;
                setLayoutParams(layoutParams);
            }
        }
        if (this.f12420z == -1) {
            if (this.f12403i == null) {
                i9 = 0;
            } else {
                int iconPadding = getIconPadding();
                int intrinsicWidth = this.f12405k;
                if (intrinsicWidth == 0) {
                    intrinsicWidth = this.f12403i.getIntrinsicWidth();
                }
                i9 = iconPadding + intrinsicWidth;
            }
            this.f12420z = (getMeasuredWidth() - getTextLayoutWidth()) - i9;
        }
        if (this.f12414t == -1) {
            this.f12414t = getPaddingStart();
        }
        if (this.f12415u == -1) {
            this.f12415u = getPaddingEnd();
        }
        this.f12419y = k();
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        setChecked(dVar.f12421a);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        dVar.f12421a = this.f12409o;
        return dVar;
    }

    @Override // androidx.appcompat.widget.C0436f, android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        super.onTextChanged(charSequence, i5, i6, i7);
        r(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean performClick() {
        if (isEnabled() && this.f12398d.s()) {
            toggle();
        }
        return super.performClick();
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f12403i != null) {
            if (this.f12403i.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public void setA11yClassName(String str) {
        this.f12404j = str;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i5) {
        if (m()) {
            this.f12398d.u(i5);
        } else {
            super.setBackgroundColor(i5);
        }
    }

    @Override // androidx.appcompat.widget.C0436f, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (!m()) {
            super.setBackgroundDrawable(drawable);
        } else {
            if (drawable == getBackground()) {
                getBackground().setState(drawable.getState());
                return;
            }
            Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
            this.f12398d.v();
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.C0436f, android.view.View
    public void setBackgroundResource(int i5) {
        setBackgroundDrawable(i5 != 0 ? C0744a.b(getContext(), i5) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z5) {
        if (m()) {
            this.f12398d.w(z5);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z5) {
        setCheckedInternal(z5);
    }

    public void setCornerRadius(int i5) {
        if (m()) {
            this.f12398d.x(i5);
        }
    }

    public void setCornerRadiusResource(int i5) {
        if (m()) {
            setCornerRadius(getResources().getDimensionPixelSize(i5));
        }
    }

    public void setCornerSpringForce(j jVar) {
        this.f12398d.z(jVar);
    }

    void setDisplayedWidthDecrease(int i5) {
        this.f12396D = Math.min(i5, this.f12420z);
        s();
        invalidate();
    }

    @Override // android.view.View
    public void setElevation(float f5) {
        super.setElevation(f5);
        if (m()) {
            this.f12398d.g().f0(f5);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f12403i != drawable) {
            this.f12403i = drawable;
            q(true);
            r(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i5) {
        if (this.f12411q != i5) {
            this.f12411q = i5;
            r(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i5) {
        if (this.f12408n != i5) {
            this.f12408n = i5;
            setCompoundDrawablePadding(i5);
        }
    }

    public void setIconResource(int i5) {
        setIcon(i5 != 0 ? C0744a.b(getContext(), i5) : null);
    }

    public void setIconSize(int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f12405k != i5) {
            this.f12405k = i5;
            q(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f12402h != colorStateList) {
            this.f12402h = colorStateList;
            q(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f12401g != mode) {
            this.f12401g = mode;
            q(false);
        }
    }

    public void setIconTintResource(int i5) {
        setIconTint(C0744a.a(getContext(), i5));
    }

    public void setInsetBottom(int i5) {
        this.f12398d.A(i5);
    }

    public void setInsetTop(int i5) {
        this.f12398d.B(i5);
    }

    void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    void setOnPressedChangeListenerInternal(c cVar) {
        this.f12400f = cVar;
    }

    public void setOpticalCenterEnabled(boolean z5) {
        if (this.f12417w != z5) {
            this.f12417w = z5;
            if (z5) {
                this.f12398d.y(new C1115h.d() { // from class: com.google.android.material.button.a
                    @Override // t1.C1115h.d
                    public final void a(float f5) {
                        MaterialButton.b(this.f12430a, f5);
                    }
                });
            } else {
                this.f12398d.y(null);
            }
            post(new Runnable() { // from class: com.google.android.material.button.b
                @Override // java.lang.Runnable
                public final void run() {
                    MaterialButton.a(this.f12431a);
                }
            });
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z5) {
        c cVar = this.f12400f;
        if (cVar != null) {
            cVar.a(this, z5);
        }
        super.setPressed(z5);
        n(false);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (m()) {
            this.f12398d.C(colorStateList);
        }
    }

    public void setRippleColorResource(int i5) {
        if (m()) {
            setRippleColor(C0744a.a(getContext(), i5));
        }
    }

    @Override // t1.o
    public void setShapeAppearanceModel(l lVar) {
        if (!m()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.f12398d.D(lVar);
    }

    void setShouldDrawSurfaceColorStroke(boolean z5) {
        if (m()) {
            this.f12398d.E(z5);
        }
    }

    void setSizeChange(r rVar) {
        if (this.f12393A != rVar) {
            this.f12393A = rVar;
            n(true);
        }
    }

    public void setStateListShapeAppearanceModel(q qVar) {
        if (!m()) {
            throw new IllegalStateException("Attempted to set StateListShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        if (this.f12398d.c() == null && qVar.f()) {
            this.f12398d.z(e());
        }
        this.f12398d.F(qVar);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (m()) {
            this.f12398d.G(colorStateList);
        }
    }

    public void setStrokeColorResource(int i5) {
        if (m()) {
            setStrokeColor(C0744a.a(getContext(), i5));
        }
    }

    public void setStrokeWidth(int i5) {
        if (m()) {
            this.f12398d.H(i5);
        }
    }

    public void setStrokeWidthResource(int i5) {
        if (m()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i5));
        }
    }

    @Override // androidx.appcompat.widget.C0436f
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (m()) {
            this.f12398d.I(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.C0436f
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (m()) {
            this.f12398d.J(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.view.View
    public void setTextAlignment(int i5) {
        super.setTextAlignment(i5);
        r(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z5) {
        this.f12398d.K(z5);
    }

    @Override // android.widget.TextView
    public void setWidth(int i5) {
        this.f12413s = -1.0f;
        super.setWidth(i5);
    }

    void setWidthChangeMax(int i5) {
        if (this.f12394B != i5) {
            this.f12394B = i5;
            n(true);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f12409o);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButton(Context context, AttributeSet attributeSet, int i5) {
        int i6 = f12390H;
        super(C1282a.e(context, attributeSet, i5, i6, new int[]{f12391I}), attributeSet, i5);
        this.f12399e = new LinkedHashSet<>();
        this.f12409o = false;
        this.f12410p = false;
        this.f12412r = -1;
        this.f12413s = -1.0f;
        this.f12414t = -1;
        this.f12415u = -1;
        this.f12420z = -1;
        Context context2 = getContext();
        TypedArray typedArrayI = com.google.android.material.internal.o.i(context2, attributeSet, C0418k.f7015N1, i5, i6, new int[0]);
        this.f12408n = typedArrayI.getDimensionPixelSize(C0418k.f7101b2, 0);
        this.f12401g = com.google.android.material.internal.r.h(typedArrayI.getInt(C0418k.f7122e2, -1), PorterDuff.Mode.SRC_IN);
        this.f12402h = C0981c.a(getContext(), typedArrayI, C0418k.f7115d2);
        this.f12403i = C0981c.d(getContext(), typedArrayI, C0418k.f7087Z1);
        this.f12411q = typedArrayI.getInteger(C0418k.f7094a2, 1);
        this.f12405k = typedArrayI.getDimensionPixelSize(C0418k.f7108c2, 0);
        q qVarB = q.b(context2, typedArrayI, C0418k.f7141h2);
        l lVarC = qVarB != null ? qVarB.c(true) : l.e(context2, attributeSet, i5, i6).m();
        boolean z5 = typedArrayI.getBoolean(C0418k.f7129f2, false);
        e eVar = new e(this, lVarC);
        this.f12398d = eVar;
        eVar.t(typedArrayI);
        setCheckedInternal(typedArrayI.getBoolean(C0418k.f7027P1, false));
        if (qVarB != null) {
            eVar.z(e());
            eVar.F(qVarB);
        }
        setOpticalCenterEnabled(z5);
        typedArrayI.recycle();
        setCompoundDrawablePadding(this.f12408n);
        q(this.f12403i != null);
    }
}
