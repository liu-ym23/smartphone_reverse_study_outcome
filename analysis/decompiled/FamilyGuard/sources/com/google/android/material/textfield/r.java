package com.google.android.material.textfield;

import a1.C0411d;
import a1.C0413f;
import a1.C0415h;
import a1.C0416i;
import a1.C0418k;
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
import androidx.appcompat.widget.D;
import androidx.appcompat.widget.a0;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import h.C0744a;
import java.util.Iterator;
import java.util.LinkedHashSet;
import q1.C0981c;

/* loaded from: classes.dex */
class r extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    final TextInputLayout f13343a;

    /* renamed from: b, reason: collision with root package name */
    private final FrameLayout f13344b;

    /* renamed from: c, reason: collision with root package name */
    private final CheckableImageButton f13345c;

    /* renamed from: d, reason: collision with root package name */
    private ColorStateList f13346d;

    /* renamed from: e, reason: collision with root package name */
    private PorterDuff.Mode f13347e;

    /* renamed from: f, reason: collision with root package name */
    private View.OnLongClickListener f13348f;

    /* renamed from: g, reason: collision with root package name */
    private final CheckableImageButton f13349g;

    /* renamed from: h, reason: collision with root package name */
    private final d f13350h;

    /* renamed from: i, reason: collision with root package name */
    private int f13351i;

    /* renamed from: j, reason: collision with root package name */
    private final LinkedHashSet<TextInputLayout.h> f13352j;

    /* renamed from: k, reason: collision with root package name */
    private ColorStateList f13353k;

    /* renamed from: l, reason: collision with root package name */
    private PorterDuff.Mode f13354l;

    /* renamed from: m, reason: collision with root package name */
    private int f13355m;

    /* renamed from: n, reason: collision with root package name */
    private ImageView.ScaleType f13356n;

    /* renamed from: o, reason: collision with root package name */
    private View.OnLongClickListener f13357o;

    /* renamed from: p, reason: collision with root package name */
    private CharSequence f13358p;

    /* renamed from: q, reason: collision with root package name */
    private final TextView f13359q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f13360r;

    /* renamed from: s, reason: collision with root package name */
    private EditText f13361s;

    /* renamed from: t, reason: collision with root package name */
    private final AccessibilityManager f13362t;

    /* renamed from: u, reason: collision with root package name */
    private AccessibilityManager.TouchExplorationStateChangeListener f13363u;

    /* renamed from: v, reason: collision with root package name */
    private final TextWatcher f13364v;

    /* renamed from: w, reason: collision with root package name */
    private final TextInputLayout.g f13365w;

    class a extends com.google.android.material.internal.n {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            r.this.m().a(editable);
        }

        @Override // com.google.android.material.internal.n, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
            r.this.m().b(charSequence, i5, i6, i7);
        }
    }

    class b implements TextInputLayout.g {
        b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout) {
            if (r.this.f13361s == textInputLayout.getEditText()) {
                return;
            }
            if (r.this.f13361s != null) {
                r.this.f13361s.removeTextChangedListener(r.this.f13364v);
                if (r.this.f13361s.getOnFocusChangeListener() == r.this.m().e()) {
                    r.this.f13361s.setOnFocusChangeListener(null);
                }
            }
            r.this.f13361s = textInputLayout.getEditText();
            if (r.this.f13361s != null) {
                r.this.f13361s.addTextChangedListener(r.this.f13364v);
            }
            r.this.m().n(r.this.f13361s);
            r rVar = r.this;
            rVar.h0(rVar.m());
        }
    }

    class c implements View.OnAttachStateChangeListener {
        c() {
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

    private static class d {

        /* renamed from: a, reason: collision with root package name */
        private final SparseArray<s> f13369a = new SparseArray<>();

        /* renamed from: b, reason: collision with root package name */
        private final r f13370b;

        /* renamed from: c, reason: collision with root package name */
        private final int f13371c;

        /* renamed from: d, reason: collision with root package name */
        private final int f13372d;

        d(r rVar, a0 a0Var) {
            this.f13370b = rVar;
            this.f13371c = a0Var.n(C0418k.m5, 0);
            this.f13372d = a0Var.n(C0418k.L5, 0);
        }

        private s b(int i5) {
            if (i5 == -1) {
                return new g(this.f13370b);
            }
            if (i5 == 0) {
                return new w(this.f13370b);
            }
            if (i5 == 1) {
                return new y(this.f13370b, this.f13372d);
            }
            if (i5 == 2) {
                return new f(this.f13370b);
            }
            if (i5 == 3) {
                return new p(this.f13370b);
            }
            throw new IllegalArgumentException("Invalid end icon mode: " + i5);
        }

        s c(int i5) {
            s sVar = this.f13369a.get(i5);
            if (sVar != null) {
                return sVar;
            }
            s sVarB = b(i5);
            this.f13369a.append(i5, sVarB);
            return sVarB;
        }
    }

    r(TextInputLayout textInputLayout, a0 a0Var) {
        super(textInputLayout.getContext());
        this.f13351i = 0;
        this.f13352j = new LinkedHashSet<>();
        this.f13364v = new a();
        b bVar = new b();
        this.f13365w = bVar;
        this.f13362t = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f13343a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f13344b = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        CheckableImageButton checkableImageButtonI = i(this, layoutInflaterFrom, C0413f.f6829L);
        this.f13345c = checkableImageButtonI;
        CheckableImageButton checkableImageButtonI2 = i(frameLayout, layoutInflaterFrom, C0413f.f6828K);
        this.f13349g = checkableImageButtonI2;
        this.f13350h = new d(this, a0Var);
        D d6 = new D(getContext());
        this.f13359q = d6;
        C(a0Var);
        B(a0Var);
        D(a0Var);
        frameLayout.addView(checkableImageButtonI2);
        addView(d6);
        addView(frameLayout);
        addView(checkableImageButtonI);
        textInputLayout.j(bVar);
        addOnAttachStateChangeListener(new c());
    }

    private void B(a0 a0Var) {
        int i5 = C0418k.M5;
        if (!a0Var.s(i5)) {
            int i6 = C0418k.q5;
            if (a0Var.s(i6)) {
                this.f13353k = C0981c.b(getContext(), a0Var, i6);
            }
            int i7 = C0418k.r5;
            if (a0Var.s(i7)) {
                this.f13354l = com.google.android.material.internal.r.h(a0Var.k(i7, -1), null);
            }
        }
        int i8 = C0418k.o5;
        if (a0Var.s(i8)) {
            U(a0Var.k(i8, 0));
            int i9 = C0418k.l5;
            if (a0Var.s(i9)) {
                Q(a0Var.p(i9));
            }
            O(a0Var.a(C0418k.k5, true));
        } else if (a0Var.s(i5)) {
            int i10 = C0418k.N5;
            if (a0Var.s(i10)) {
                this.f13353k = C0981c.b(getContext(), a0Var, i10);
            }
            int i11 = C0418k.O5;
            if (a0Var.s(i11)) {
                this.f13354l = com.google.android.material.internal.r.h(a0Var.k(i11, -1), null);
            }
            U(a0Var.a(i5, false) ? 1 : 0);
            Q(a0Var.p(C0418k.K5));
        }
        T(a0Var.f(C0418k.n5, getResources().getDimensionPixelSize(C0411d.f6777c0)));
        int i12 = C0418k.p5;
        if (a0Var.s(i12)) {
            X(t.b(a0Var.k(i12, -1)));
        }
    }

    private void C(a0 a0Var) {
        int i5 = C0418k.w5;
        if (a0Var.s(i5)) {
            this.f13346d = C0981c.b(getContext(), a0Var, i5);
        }
        int i6 = C0418k.x5;
        if (a0Var.s(i6)) {
            this.f13347e = com.google.android.material.internal.r.h(a0Var.k(i6, -1), null);
        }
        int i7 = C0418k.v5;
        if (a0Var.s(i7)) {
            c0(a0Var.g(i7));
        }
        this.f13345c.setContentDescription(getResources().getText(C0416i.f6890f));
        this.f13345c.setImportantForAccessibility(2);
        this.f13345c.setClickable(false);
        this.f13345c.setPressable(false);
        this.f13345c.setCheckable(false);
        this.f13345c.setFocusable(false);
    }

    private void D(a0 a0Var) {
        this.f13359q.setVisibility(8);
        this.f13359q.setId(C0413f.f6835R);
        this.f13359q.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        this.f13359q.setAccessibilityLiveRegion(1);
        q0(a0Var.n(C0418k.d6, 0));
        int i5 = C0418k.e6;
        if (a0Var.s(i5)) {
            r0(a0Var.c(i5));
        }
        p0(a0Var.p(C0418k.c6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        AccessibilityManager accessibilityManager;
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = this.f13363u;
        if (touchExplorationStateChangeListener == null || (accessibilityManager = this.f13362t) == null) {
            return;
        }
        accessibilityManager.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f13363u == null || this.f13362t == null || !isAttachedToWindow()) {
            return;
        }
        this.f13362t.addTouchExplorationStateChangeListener(this.f13363u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(s sVar) {
        if (this.f13361s == null) {
            return;
        }
        if (sVar.e() != null) {
            this.f13361s.setOnFocusChangeListener(sVar.e());
        }
        if (sVar.g() != null) {
            this.f13349g.setOnFocusChangeListener(sVar.g());
        }
    }

    private CheckableImageButton i(ViewGroup viewGroup, LayoutInflater layoutInflater, int i5) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(C0415h.f6868b, viewGroup, false);
        checkableImageButton.setId(i5);
        t.e(checkableImageButton);
        if (C0981c.g(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginStart(0);
        }
        return checkableImageButton;
    }

    private void j(int i5) {
        Iterator<TextInputLayout.h> it = this.f13352j.iterator();
        while (it.hasNext()) {
            it.next().a(this.f13343a, i5);
        }
    }

    private void s0(s sVar) {
        sVar.s();
        this.f13363u = sVar.h();
        g();
    }

    private int t(s sVar) {
        int i5 = this.f13350h.f13371c;
        return i5 == 0 ? sVar.d() : i5;
    }

    private void t0(s sVar) {
        M();
        this.f13363u = null;
        sVar.u();
    }

    private void u0(boolean z5) {
        if (!z5 || n() == null) {
            t.a(this.f13343a, this.f13349g, this.f13353k, this.f13354l);
            return;
        }
        Drawable drawableMutate = androidx.core.graphics.drawable.a.r(n()).mutate();
        drawableMutate.setTint(this.f13343a.getErrorCurrentTextColors());
        this.f13349g.setImageDrawable(drawableMutate);
    }

    private void v0() {
        this.f13344b.setVisibility((this.f13349g.getVisibility() != 0 || G()) ? 8 : 0);
        setVisibility((F() || G() || !((this.f13358p == null || this.f13360r) ? 8 : false)) ? 0 : 8);
    }

    private void w0() {
        this.f13345c.setVisibility(s() != null && this.f13343a.O() && this.f13343a.d0() ? 0 : 8);
        v0();
        x0();
        if (A()) {
            return;
        }
        this.f13343a.p0();
    }

    private void y0() {
        int visibility = this.f13359q.getVisibility();
        int i5 = (this.f13358p == null || this.f13360r) ? 8 : 0;
        if (visibility != i5) {
            m().q(i5 == 0);
        }
        v0();
        this.f13359q.setVisibility(i5);
        this.f13343a.p0();
    }

    boolean A() {
        return this.f13351i != 0;
    }

    boolean E() {
        return A() && this.f13349g.isChecked();
    }

    boolean F() {
        return this.f13344b.getVisibility() == 0 && this.f13349g.getVisibility() == 0;
    }

    boolean G() {
        return this.f13345c.getVisibility() == 0;
    }

    void H(boolean z5) {
        this.f13360r = z5;
        y0();
    }

    void I() {
        w0();
        K();
        J();
        if (m().t()) {
            u0(this.f13343a.d0());
        }
    }

    void J() {
        t.d(this.f13343a, this.f13349g, this.f13353k);
    }

    void K() {
        t.d(this.f13343a, this.f13345c, this.f13346d);
    }

    void L(boolean z5) {
        boolean z6;
        boolean zIsActivated;
        boolean zIsChecked;
        s sVarM = m();
        boolean z7 = true;
        if (!sVarM.l() || (zIsChecked = this.f13349g.isChecked()) == sVarM.m()) {
            z6 = false;
        } else {
            this.f13349g.setChecked(!zIsChecked);
            z6 = true;
        }
        if (!sVarM.j() || (zIsActivated = this.f13349g.isActivated()) == sVarM.k()) {
            z7 = z6;
        } else {
            N(!zIsActivated);
        }
        if (z5 || z7) {
            J();
        }
    }

    void N(boolean z5) {
        this.f13349g.setActivated(z5);
    }

    void O(boolean z5) {
        this.f13349g.setCheckable(z5);
    }

    void P(int i5) {
        Q(i5 != 0 ? getResources().getText(i5) : null);
    }

    void Q(CharSequence charSequence) {
        if (l() != charSequence) {
            this.f13349g.setContentDescription(charSequence);
        }
    }

    void R(int i5) {
        S(i5 != 0 ? C0744a.b(getContext(), i5) : null);
    }

    void S(Drawable drawable) {
        this.f13349g.setImageDrawable(drawable);
        if (drawable != null) {
            t.a(this.f13343a, this.f13349g, this.f13353k, this.f13354l);
            J();
        }
    }

    void T(int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (i5 != this.f13355m) {
            this.f13355m = i5;
            t.g(this.f13349g, i5);
            t.g(this.f13345c, i5);
        }
    }

    void U(int i5) {
        if (this.f13351i == i5) {
            return;
        }
        t0(m());
        int i6 = this.f13351i;
        this.f13351i = i5;
        j(i6);
        a0(i5 != 0);
        s sVarM = m();
        R(t(sVarM));
        P(sVarM.c());
        O(sVarM.l());
        if (!sVarM.i(this.f13343a.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + this.f13343a.getBoxBackgroundMode() + " is not supported by the end icon mode " + i5);
        }
        s0(sVarM);
        V(sVarM.f());
        EditText editText = this.f13361s;
        if (editText != null) {
            sVarM.n(editText);
            h0(sVarM);
        }
        t.a(this.f13343a, this.f13349g, this.f13353k, this.f13354l);
        L(true);
    }

    void V(View.OnClickListener onClickListener) {
        t.h(this.f13349g, onClickListener, this.f13357o);
    }

    void W(View.OnLongClickListener onLongClickListener) {
        this.f13357o = onLongClickListener;
        t.i(this.f13349g, onLongClickListener);
    }

    void X(ImageView.ScaleType scaleType) {
        this.f13356n = scaleType;
        t.j(this.f13349g, scaleType);
        t.j(this.f13345c, scaleType);
    }

    void Y(ColorStateList colorStateList) {
        if (this.f13353k != colorStateList) {
            this.f13353k = colorStateList;
            t.a(this.f13343a, this.f13349g, colorStateList, this.f13354l);
        }
    }

    void Z(PorterDuff.Mode mode) {
        if (this.f13354l != mode) {
            this.f13354l = mode;
            t.a(this.f13343a, this.f13349g, this.f13353k, mode);
        }
    }

    void a0(boolean z5) {
        if (F() != z5) {
            this.f13349g.setVisibility(z5 ? 0 : 8);
            v0();
            x0();
            this.f13343a.p0();
        }
    }

    void b0(int i5) {
        c0(i5 != 0 ? C0744a.b(getContext(), i5) : null);
        K();
    }

    void c0(Drawable drawable) {
        this.f13345c.setImageDrawable(drawable);
        w0();
        t.a(this.f13343a, this.f13345c, this.f13346d, this.f13347e);
    }

    void d0(View.OnClickListener onClickListener) {
        t.h(this.f13345c, onClickListener, this.f13348f);
    }

    void e0(View.OnLongClickListener onLongClickListener) {
        this.f13348f = onLongClickListener;
        t.i(this.f13345c, onLongClickListener);
    }

    void f0(ColorStateList colorStateList) {
        if (this.f13346d != colorStateList) {
            this.f13346d = colorStateList;
            t.a(this.f13343a, this.f13345c, colorStateList, this.f13347e);
        }
    }

    void g0(PorterDuff.Mode mode) {
        if (this.f13347e != mode) {
            this.f13347e = mode;
            t.a(this.f13343a, this.f13345c, this.f13346d, mode);
        }
    }

    void h() {
        this.f13349g.performClick();
        this.f13349g.jumpDrawablesToCurrentState();
    }

    void i0(int i5) {
        j0(i5 != 0 ? getResources().getText(i5) : null);
    }

    void j0(CharSequence charSequence) {
        this.f13349g.setContentDescription(charSequence);
    }

    CheckableImageButton k() {
        if (G()) {
            return this.f13345c;
        }
        if (A() && F()) {
            return this.f13349g;
        }
        return null;
    }

    void k0(int i5) {
        l0(i5 != 0 ? C0744a.b(getContext(), i5) : null);
    }

    CharSequence l() {
        return this.f13349g.getContentDescription();
    }

    void l0(Drawable drawable) {
        this.f13349g.setImageDrawable(drawable);
    }

    s m() {
        return this.f13350h.c(this.f13351i);
    }

    void m0(boolean z5) {
        if (z5 && this.f13351i != 1) {
            U(1);
        } else {
            if (z5) {
                return;
            }
            U(0);
        }
    }

    Drawable n() {
        return this.f13349g.getDrawable();
    }

    void n0(ColorStateList colorStateList) {
        this.f13353k = colorStateList;
        t.a(this.f13343a, this.f13349g, colorStateList, this.f13354l);
    }

    int o() {
        return this.f13355m;
    }

    void o0(PorterDuff.Mode mode) {
        this.f13354l = mode;
        t.a(this.f13343a, this.f13349g, this.f13353k, mode);
    }

    int p() {
        return this.f13351i;
    }

    void p0(CharSequence charSequence) {
        this.f13358p = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f13359q.setText(charSequence);
        y0();
    }

    ImageView.ScaleType q() {
        return this.f13356n;
    }

    void q0(int i5) {
        androidx.core.widget.i.m(this.f13359q, i5);
    }

    CheckableImageButton r() {
        return this.f13349g;
    }

    void r0(ColorStateList colorStateList) {
        this.f13359q.setTextColor(colorStateList);
    }

    Drawable s() {
        return this.f13345c.getDrawable();
    }

    CharSequence u() {
        return this.f13349g.getContentDescription();
    }

    Drawable v() {
        return this.f13349g.getDrawable();
    }

    CharSequence w() {
        return this.f13358p;
    }

    ColorStateList x() {
        return this.f13359q.getTextColors();
    }

    void x0() {
        if (this.f13343a.f13250e == null) {
            return;
        }
        this.f13359q.setPaddingRelative(getContext().getResources().getDimensionPixelSize(C0411d.f6757L), this.f13343a.f13250e.getPaddingTop(), (F() || G()) ? 0 : this.f13343a.f13250e.getPaddingEnd(), this.f13343a.f13250e.getPaddingBottom());
    }

    int y() {
        return getPaddingEnd() + this.f13359q.getPaddingEnd() + ((F() || G()) ? this.f13349g.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) this.f13349g.getLayoutParams()).getMarginStart() : 0);
    }

    TextView z() {
        return this.f13359q;
    }
}
