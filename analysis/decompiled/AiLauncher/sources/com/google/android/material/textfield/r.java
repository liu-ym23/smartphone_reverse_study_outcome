package com.google.android.material.textfield;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.U;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import f.C4027a;
import java.util.Iterator;
import java.util.LinkedHashSet;
import u0.C5566a;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class r extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f21610a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f21611b;

    /* renamed from: c, reason: collision with root package name */
    public final CheckableImageButton f21612c;

    /* renamed from: d, reason: collision with root package name */
    public ColorStateList f21613d;

    /* renamed from: e, reason: collision with root package name */
    public PorterDuff.Mode f21614e;

    /* renamed from: f, reason: collision with root package name */
    public View.OnLongClickListener f21615f;

    /* renamed from: g, reason: collision with root package name */
    public final CheckableImageButton f21616g;

    /* renamed from: h, reason: collision with root package name */
    public final d f21617h;

    /* renamed from: i, reason: collision with root package name */
    public int f21618i;

    /* renamed from: j, reason: collision with root package name */
    public final LinkedHashSet<TextInputLayout.h> f21619j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f21620k;

    /* renamed from: l, reason: collision with root package name */
    public PorterDuff.Mode f21621l;

    /* renamed from: m, reason: collision with root package name */
    public int f21622m;

    /* renamed from: n, reason: collision with root package name */
    public ImageView.ScaleType f21623n;

    /* renamed from: o, reason: collision with root package name */
    public View.OnLongClickListener f21624o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f21625p;

    /* renamed from: q, reason: collision with root package name */
    public final TextView f21626q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f21627r;

    /* renamed from: s, reason: collision with root package name */
    public EditText f21628s;

    /* renamed from: t, reason: collision with root package name */
    public final AccessibilityManager f21629t;

    /* renamed from: u, reason: collision with root package name */
    public AccessibilityManager.TouchExplorationStateChangeListener f21630u;

    /* renamed from: v, reason: collision with root package name */
    public final TextWatcher f21631v;

    /* renamed from: w, reason: collision with root package name */
    public final TextInputLayout.g f21632w;

    public class a extends com.google.android.material.internal.q {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            r.this.m().a(editable);
        }

        @Override // com.google.android.material.internal.q, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            r.this.m().b(charSequence, i10, i11, i12);
        }
    }

    public class b implements TextInputLayout.g {
        public b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout) {
            if (r.this.f21628s == textInputLayout.getEditText()) {
                return;
            }
            if (r.this.f21628s != null) {
                r.this.f21628s.removeTextChangedListener(r.this.f21631v);
                if (r.this.f21628s.getOnFocusChangeListener() == r.this.m().e()) {
                    r.this.f21628s.setOnFocusChangeListener(null);
                }
            }
            r.this.f21628s = textInputLayout.getEditText();
            if (r.this.f21628s != null) {
                r.this.f21628s.addTextChangedListener(r.this.f21631v);
            }
            r.this.m().n(r.this.f21628s);
            r rVar = r.this;
            rVar.h0(rVar.m());
        }
    }

    public class c implements View.OnAttachStateChangeListener {
        public c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            r.this.g();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            r.this.M();
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final SparseArray<s> f21636a = new SparseArray<>();

        /* renamed from: b, reason: collision with root package name */
        public final r f21637b;

        /* renamed from: c, reason: collision with root package name */
        public final int f21638c;

        /* renamed from: d, reason: collision with root package name */
        public final int f21639d;

        public d(r rVar, U u10) {
            this.f21637b = rVar;
            this.f21638c = u10.n(R$styleable.TextInputLayout_endIconDrawable, 0);
            this.f21639d = u10.n(R$styleable.TextInputLayout_passwordToggleDrawable, 0);
        }

        public final s b(int i10) {
            if (i10 == -1) {
                return new g(this.f21637b);
            }
            if (i10 == 0) {
                return new w(this.f21637b);
            }
            if (i10 == 1) {
                return new y(this.f21637b, this.f21639d);
            }
            if (i10 == 2) {
                return new f(this.f21637b);
            }
            if (i10 == 3) {
                return new p(this.f21637b);
            }
            throw new IllegalArgumentException("Invalid end icon mode: " + i10);
        }

        public s c(int i10) {
            s sVar = this.f21636a.get(i10);
            if (sVar != null) {
                return sVar;
            }
            s sVarB = b(i10);
            this.f21636a.append(i10, sVarB);
            return sVarB;
        }
    }

    public r(TextInputLayout textInputLayout, U u10) {
        super(textInputLayout.getContext());
        this.f21618i = 0;
        this.f21619j = new LinkedHashSet<>();
        this.f21631v = new a();
        b bVar = new b();
        this.f21632w = bVar;
        this.f21629t = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f21610a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f21611b = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        CheckableImageButton checkableImageButtonI = i(this, layoutInflaterFrom, R$id.text_input_error_icon);
        this.f21612c = checkableImageButtonI;
        CheckableImageButton checkableImageButtonI2 = i(frameLayout, layoutInflaterFrom, R$id.text_input_end_icon);
        this.f21616g = checkableImageButtonI2;
        this.f21617h = new d(this, u10);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f21626q = appCompatTextView;
        C(u10);
        B(u10);
        D(u10);
        frameLayout.addView(checkableImageButtonI2);
        addView(appCompatTextView);
        addView(frameLayout);
        addView(checkableImageButtonI);
        textInputLayout.j(bVar);
        addOnAttachStateChangeListener(new c());
    }

    public boolean A() {
        return this.f21618i != 0;
    }

    public final void B(U u10) {
        int i10 = R$styleable.TextInputLayout_passwordToggleEnabled;
        if (!u10.s(i10)) {
            int i11 = R$styleable.TextInputLayout_endIconTint;
            if (u10.s(i11)) {
                this.f21620k = W2.c.b(getContext(), u10, i11);
            }
            int i12 = R$styleable.TextInputLayout_endIconTintMode;
            if (u10.s(i12)) {
                this.f21621l = com.google.android.material.internal.u.i(u10.k(i12, -1), null);
            }
        }
        int i13 = R$styleable.TextInputLayout_endIconMode;
        if (u10.s(i13)) {
            U(u10.k(i13, 0));
            int i14 = R$styleable.TextInputLayout_endIconContentDescription;
            if (u10.s(i14)) {
                Q(u10.p(i14));
            }
            O(u10.a(R$styleable.TextInputLayout_endIconCheckable, true));
        } else if (u10.s(i10)) {
            int i15 = R$styleable.TextInputLayout_passwordToggleTint;
            if (u10.s(i15)) {
                this.f21620k = W2.c.b(getContext(), u10, i15);
            }
            int i16 = R$styleable.TextInputLayout_passwordToggleTintMode;
            if (u10.s(i16)) {
                this.f21621l = com.google.android.material.internal.u.i(u10.k(i16, -1), null);
            }
            U(u10.a(i10, false) ? 1 : 0);
            Q(u10.p(R$styleable.TextInputLayout_passwordToggleContentDescription));
        }
        T(u10.f(R$styleable.TextInputLayout_endIconMinSize, getResources().getDimensionPixelSize(R$dimen.mtrl_min_touch_target_size)));
        int i17 = R$styleable.TextInputLayout_endIconScaleType;
        if (u10.s(i17)) {
            X(t.b(u10.k(i17, -1)));
        }
    }

    public final void C(U u10) {
        int i10 = R$styleable.TextInputLayout_errorIconTint;
        if (u10.s(i10)) {
            this.f21613d = W2.c.b(getContext(), u10, i10);
        }
        int i11 = R$styleable.TextInputLayout_errorIconTintMode;
        if (u10.s(i11)) {
            this.f21614e = com.google.android.material.internal.u.i(u10.k(i11, -1), null);
        }
        int i12 = R$styleable.TextInputLayout_errorIconDrawable;
        if (u10.s(i12)) {
            c0(u10.g(i12));
        }
        this.f21612c.setContentDescription(getResources().getText(R$string.error_icon_content_description));
        this.f21612c.setImportantForAccessibility(2);
        this.f21612c.setClickable(false);
        this.f21612c.setPressable(false);
        this.f21612c.setCheckable(false);
        this.f21612c.setFocusable(false);
    }

    public final void D(U u10) {
        this.f21626q.setVisibility(8);
        this.f21626q.setId(R$id.textinput_suffix_text);
        this.f21626q.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        this.f21626q.setAccessibilityLiveRegion(1);
        q0(u10.n(R$styleable.TextInputLayout_suffixTextAppearance, 0));
        int i10 = R$styleable.TextInputLayout_suffixTextColor;
        if (u10.s(i10)) {
            r0(u10.c(i10));
        }
        p0(u10.p(R$styleable.TextInputLayout_suffixText));
    }

    public boolean E() {
        return A() && this.f21616g.isChecked();
    }

    public boolean F() {
        return this.f21611b.getVisibility() == 0 && this.f21616g.getVisibility() == 0;
    }

    public boolean G() {
        return this.f21612c.getVisibility() == 0;
    }

    public void H(boolean z10) {
        this.f21627r = z10;
        y0();
    }

    public void I() {
        w0();
        K();
        J();
        if (m().t()) {
            u0(this.f21610a.d0());
        }
    }

    public void J() {
        t.d(this.f21610a, this.f21616g, this.f21620k);
    }

    public void K() {
        t.d(this.f21610a, this.f21612c, this.f21613d);
    }

    public void L(boolean z10) {
        boolean z11;
        boolean zIsActivated;
        boolean zIsChecked;
        s sVarM = m();
        boolean z12 = true;
        if (!sVarM.l() || (zIsChecked = this.f21616g.isChecked()) == sVarM.m()) {
            z11 = false;
        } else {
            this.f21616g.setChecked(!zIsChecked);
            z11 = true;
        }
        if (!sVarM.j() || (zIsActivated = this.f21616g.isActivated()) == sVarM.k()) {
            z12 = z11;
        } else {
            N(!zIsActivated);
        }
        if (z10 || z12) {
            J();
        }
    }

    public final void M() {
        AccessibilityManager accessibilityManager;
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = this.f21630u;
        if (touchExplorationStateChangeListener == null || (accessibilityManager = this.f21629t) == null) {
            return;
        }
        accessibilityManager.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
    }

    public void N(boolean z10) {
        this.f21616g.setActivated(z10);
    }

    public void O(boolean z10) {
        this.f21616g.setCheckable(z10);
    }

    public void P(int i10) {
        Q(i10 != 0 ? getResources().getText(i10) : null);
    }

    public void Q(CharSequence charSequence) {
        if (l() != charSequence) {
            this.f21616g.setContentDescription(charSequence);
        }
    }

    public void R(int i10) {
        S(i10 != 0 ? C4027a.b(getContext(), i10) : null);
    }

    public void S(Drawable drawable) {
        this.f21616g.setImageDrawable(drawable);
        if (drawable != null) {
            t.a(this.f21610a, this.f21616g, this.f21620k, this.f21621l);
            J();
        }
    }

    public void T(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (i10 != this.f21622m) {
            this.f21622m = i10;
            t.g(this.f21616g, i10);
            t.g(this.f21612c, i10);
        }
    }

    public void U(int i10) {
        if (this.f21618i == i10) {
            return;
        }
        t0(m());
        int i11 = this.f21618i;
        this.f21618i = i10;
        j(i11);
        a0(i10 != 0);
        s sVarM = m();
        R(t(sVarM));
        P(sVarM.c());
        O(sVarM.l());
        if (!sVarM.i(this.f21610a.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + this.f21610a.getBoxBackgroundMode() + " is not supported by the end icon mode " + i10);
        }
        s0(sVarM);
        V(sVarM.f());
        EditText editText = this.f21628s;
        if (editText != null) {
            sVarM.n(editText);
            h0(sVarM);
        }
        t.a(this.f21610a, this.f21616g, this.f21620k, this.f21621l);
        L(true);
    }

    public void V(View.OnClickListener onClickListener) {
        t.h(this.f21616g, onClickListener, this.f21624o);
    }

    public void W(View.OnLongClickListener onLongClickListener) {
        this.f21624o = onLongClickListener;
        t.i(this.f21616g, onLongClickListener);
    }

    public void X(ImageView.ScaleType scaleType) {
        this.f21623n = scaleType;
        t.j(this.f21616g, scaleType);
        t.j(this.f21612c, scaleType);
    }

    public void Y(ColorStateList colorStateList) {
        if (this.f21620k != colorStateList) {
            this.f21620k = colorStateList;
            t.a(this.f21610a, this.f21616g, colorStateList, this.f21621l);
        }
    }

    public void Z(PorterDuff.Mode mode) {
        if (this.f21621l != mode) {
            this.f21621l = mode;
            t.a(this.f21610a, this.f21616g, this.f21620k, mode);
        }
    }

    public void a0(boolean z10) {
        if (F() != z10) {
            this.f21616g.setVisibility(z10 ? 0 : 8);
            v0();
            x0();
            this.f21610a.p0();
        }
    }

    public void b0(int i10) {
        c0(i10 != 0 ? C4027a.b(getContext(), i10) : null);
        K();
    }

    public void c0(Drawable drawable) {
        this.f21612c.setImageDrawable(drawable);
        w0();
        t.a(this.f21610a, this.f21612c, this.f21613d, this.f21614e);
    }

    public void d0(View.OnClickListener onClickListener) {
        t.h(this.f21612c, onClickListener, this.f21615f);
    }

    public void e0(View.OnLongClickListener onLongClickListener) {
        this.f21615f = onLongClickListener;
        t.i(this.f21612c, onLongClickListener);
    }

    public void f0(ColorStateList colorStateList) {
        if (this.f21613d != colorStateList) {
            this.f21613d = colorStateList;
            t.a(this.f21610a, this.f21612c, colorStateList, this.f21614e);
        }
    }

    public final void g() {
        if (this.f21630u == null || this.f21629t == null || !isAttachedToWindow()) {
            return;
        }
        this.f21629t.addTouchExplorationStateChangeListener(this.f21630u);
    }

    public void g0(PorterDuff.Mode mode) {
        if (this.f21614e != mode) {
            this.f21614e = mode;
            t.a(this.f21610a, this.f21612c, this.f21613d, mode);
        }
    }

    public void h() {
        this.f21616g.performClick();
        this.f21616g.jumpDrawablesToCurrentState();
    }

    public final void h0(s sVar) {
        if (this.f21628s == null) {
            return;
        }
        if (sVar.e() != null) {
            this.f21628s.setOnFocusChangeListener(sVar.e());
        }
        if (sVar.g() != null) {
            this.f21616g.setOnFocusChangeListener(sVar.g());
        }
    }

    public final CheckableImageButton i(ViewGroup viewGroup, LayoutInflater layoutInflater, int i10) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(R$layout.design_text_input_end_icon, viewGroup, false);
        checkableImageButton.setId(i10);
        t.e(checkableImageButton);
        if (W2.c.h(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginStart(0);
        }
        return checkableImageButton;
    }

    public void i0(int i10) {
        j0(i10 != 0 ? getResources().getText(i10) : null);
    }

    public final void j(int i10) {
        Iterator<TextInputLayout.h> it = this.f21619j.iterator();
        while (it.hasNext()) {
            it.next().a(this.f21610a, i10);
        }
    }

    public void j0(CharSequence charSequence) {
        this.f21616g.setContentDescription(charSequence);
    }

    public CheckableImageButton k() {
        if (G()) {
            return this.f21612c;
        }
        if (A() && F()) {
            return this.f21616g;
        }
        return null;
    }

    public void k0(int i10) {
        l0(i10 != 0 ? C4027a.b(getContext(), i10) : null);
    }

    public CharSequence l() {
        return this.f21616g.getContentDescription();
    }

    public void l0(Drawable drawable) {
        this.f21616g.setImageDrawable(drawable);
    }

    public s m() {
        return this.f21617h.c(this.f21618i);
    }

    public void m0(boolean z10) {
        if (z10 && this.f21618i != 1) {
            U(1);
        } else {
            if (z10) {
                return;
            }
            U(0);
        }
    }

    public Drawable n() {
        return this.f21616g.getDrawable();
    }

    public void n0(ColorStateList colorStateList) {
        this.f21620k = colorStateList;
        t.a(this.f21610a, this.f21616g, colorStateList, this.f21621l);
    }

    public int o() {
        return this.f21622m;
    }

    public void o0(PorterDuff.Mode mode) {
        this.f21621l = mode;
        t.a(this.f21610a, this.f21616g, this.f21620k, mode);
    }

    public int p() {
        return this.f21618i;
    }

    public void p0(CharSequence charSequence) {
        this.f21625p = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f21626q.setText(charSequence);
        y0();
    }

    public ImageView.ScaleType q() {
        return this.f21623n;
    }

    public void q0(int i10) {
        androidx.core.widget.i.m(this.f21626q, i10);
    }

    public CheckableImageButton r() {
        return this.f21616g;
    }

    public void r0(ColorStateList colorStateList) {
        this.f21626q.setTextColor(colorStateList);
    }

    public Drawable s() {
        return this.f21612c.getDrawable();
    }

    public final void s0(s sVar) {
        sVar.s();
        this.f21630u = sVar.h();
        g();
    }

    public final int t(s sVar) {
        int i10 = this.f21617h.f21638c;
        return i10 == 0 ? sVar.d() : i10;
    }

    public final void t0(s sVar) {
        M();
        this.f21630u = null;
        sVar.u();
    }

    public CharSequence u() {
        return this.f21616g.getContentDescription();
    }

    public final void u0(boolean z10) {
        if (!z10 || n() == null) {
            t.a(this.f21610a, this.f21616g, this.f21620k, this.f21621l);
            return;
        }
        Drawable drawableMutate = C5566a.r(n()).mutate();
        drawableMutate.setTint(this.f21610a.getErrorCurrentTextColors());
        this.f21616g.setImageDrawable(drawableMutate);
    }

    public Drawable v() {
        return this.f21616g.getDrawable();
    }

    public final void v0() {
        this.f21611b.setVisibility((this.f21616g.getVisibility() != 0 || G()) ? 8 : 0);
        setVisibility((F() || G() || !((this.f21625p == null || this.f21627r) ? 8 : false)) ? 0 : 8);
    }

    public CharSequence w() {
        return this.f21625p;
    }

    public final void w0() {
        this.f21612c.setVisibility(s() != null && this.f21610a.O() && this.f21610a.d0() ? 0 : 8);
        v0();
        x0();
        if (A()) {
            return;
        }
        this.f21610a.p0();
    }

    public ColorStateList x() {
        return this.f21626q.getTextColors();
    }

    public void x0() {
        if (this.f21610a.f21527e == null) {
            return;
        }
        this.f21626q.setPaddingRelative(getContext().getResources().getDimensionPixelSize(R$dimen.material_input_text_to_prefix_suffix_padding), this.f21610a.f21527e.getPaddingTop(), (F() || G()) ? 0 : this.f21610a.f21527e.getPaddingEnd(), this.f21610a.f21527e.getPaddingBottom());
    }

    public int y() {
        return getPaddingEnd() + this.f21626q.getPaddingEnd() + ((F() || G()) ? this.f21616g.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) this.f21616g.getLayoutParams()).getMarginStart() : 0);
    }

    public final void y0() {
        int visibility = this.f21626q.getVisibility();
        int i10 = (this.f21625p == null || this.f21627r) ? 8 : 0;
        if (visibility != i10) {
            m().q(i10 == 0);
        }
        v0();
        this.f21626q.setVisibility(i10);
        this.f21610a.p0();
    }

    public TextView z() {
        return this.f21626q;
    }
}
