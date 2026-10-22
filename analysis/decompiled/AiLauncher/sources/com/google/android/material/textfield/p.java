package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.android.material.R$attr;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;

/* loaded from: classes2.dex */
public class p extends s {

    /* renamed from: e, reason: collision with root package name */
    public final int f21595e;

    /* renamed from: f, reason: collision with root package name */
    public final int f21596f;

    /* renamed from: g, reason: collision with root package name */
    public final TimeInterpolator f21597g;

    /* renamed from: h, reason: collision with root package name */
    public AutoCompleteTextView f21598h;

    /* renamed from: i, reason: collision with root package name */
    public final View.OnClickListener f21599i;

    /* renamed from: j, reason: collision with root package name */
    public final View.OnFocusChangeListener f21600j;

    /* renamed from: k, reason: collision with root package name */
    public final AccessibilityManager.TouchExplorationStateChangeListener f21601k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f21602l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f21603m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f21604n;

    /* renamed from: o, reason: collision with root package name */
    public long f21605o;

    /* renamed from: p, reason: collision with root package name */
    public AccessibilityManager f21606p;

    /* renamed from: q, reason: collision with root package name */
    public ValueAnimator f21607q;

    /* renamed from: r, reason: collision with root package name */
    public ValueAnimator f21608r;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            p.this.r();
            p.this.f21608r.start();
        }
    }

    public p(r rVar) {
        super(rVar);
        this.f21599i = new View.OnClickListener() { // from class: com.google.android.material.textfield.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f21591a.J();
            }
        };
        this.f21600j = new View.OnFocusChangeListener() { // from class: com.google.android.material.textfield.m
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                p.y(this.f21592a, view, z10);
            }
        };
        this.f21601k = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: com.google.android.material.textfield.n
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z10) {
                p.w(this.f21593a, z10);
            }
        };
        this.f21605o = Long.MAX_VALUE;
        Context context = rVar.getContext();
        int i10 = R$attr.motionDurationShort3;
        this.f21596f = T2.h.f(context, i10, 67);
        this.f21595e = T2.h.f(rVar.getContext(), i10, 50);
        this.f21597g = T2.h.g(rVar.getContext(), R$attr.motionEasingLinearInterpolator, E2.a.f2339a);
    }

    public static /* synthetic */ void A(p pVar) {
        pVar.K();
        pVar.H(false);
    }

    public static AutoCompleteTextView D(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private void F() {
        this.f21608r = E(this.f21596f, 0.0f, 1.0f);
        ValueAnimator valueAnimatorE = E(this.f21595e, 1.0f, 0.0f);
        this.f21607q = valueAnimatorE;
        valueAnimatorE.addListener(new a());
    }

    public static /* synthetic */ void v(p pVar) {
        boolean zIsPopupShowing = pVar.f21598h.isPopupShowing();
        pVar.H(zIsPopupShowing);
        pVar.f21603m = zIsPopupShowing;
    }

    public static /* synthetic */ void w(p pVar, boolean z10) {
        AutoCompleteTextView autoCompleteTextView = pVar.f21598h;
        if (autoCompleteTextView == null || q.a(autoCompleteTextView)) {
            return;
        }
        pVar.f21643d.setImportantForAccessibility(z10 ? 2 : 1);
    }

    public static /* synthetic */ void x(p pVar, ValueAnimator valueAnimator) {
        pVar.getClass();
        pVar.f21643d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public static /* synthetic */ void y(p pVar, View view, boolean z10) {
        pVar.f21602l = z10;
        pVar.r();
        if (z10) {
            return;
        }
        pVar.H(false);
        pVar.f21603m = false;
    }

    public static /* synthetic */ boolean z(p pVar, View view, MotionEvent motionEvent) {
        pVar.getClass();
        if (motionEvent.getAction() == 1) {
            if (pVar.G()) {
                pVar.f21603m = false;
            }
            pVar.J();
            pVar.K();
        }
        return false;
    }

    public final ValueAnimator E(int i10, float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(this.f21597g);
        valueAnimatorOfFloat.setDuration(i10);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.i
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                p.x(this.f21588a, valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    public final boolean G() {
        long jUptimeMillis = SystemClock.uptimeMillis() - this.f21605o;
        return jUptimeMillis < 0 || jUptimeMillis > 300;
    }

    public final void H(boolean z10) {
        if (this.f21604n != z10) {
            this.f21604n = z10;
            this.f21608r.cancel();
            this.f21607q.start();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void I() {
        this.f21598h.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.textfield.j
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return p.z(this.f21589a, view, motionEvent);
            }
        });
        this.f21598h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: com.google.android.material.textfield.k
            @Override // android.widget.AutoCompleteTextView.OnDismissListener
            public final void onDismiss() {
                p.A(this.f21590a);
            }
        });
        this.f21598h.setThreshold(0);
    }

    public final void J() {
        if (this.f21598h == null) {
            return;
        }
        if (G()) {
            this.f21603m = false;
        }
        if (this.f21603m) {
            this.f21603m = false;
            return;
        }
        H(!this.f21604n);
        if (!this.f21604n) {
            this.f21598h.dismissDropDown();
        } else {
            this.f21598h.requestFocus();
            this.f21598h.showDropDown();
        }
    }

    public final void K() {
        this.f21603m = true;
        this.f21605o = SystemClock.uptimeMillis();
    }

    @Override // com.google.android.material.textfield.s
    public void a(Editable editable) {
        if (this.f21606p.isTouchExplorationEnabled() && q.a(this.f21598h) && !this.f21643d.hasFocus()) {
            this.f21598h.dismissDropDown();
        }
        this.f21598h.post(new Runnable() { // from class: com.google.android.material.textfield.o
            @Override // java.lang.Runnable
            public final void run() {
                p.v(this.f21594a);
            }
        });
    }

    @Override // com.google.android.material.textfield.s
    public int c() {
        return R$string.exposed_dropdown_menu_content_description;
    }

    @Override // com.google.android.material.textfield.s
    public int d() {
        return R$drawable.mtrl_dropdown_arrow;
    }

    @Override // com.google.android.material.textfield.s
    public View.OnFocusChangeListener e() {
        return this.f21600j;
    }

    @Override // com.google.android.material.textfield.s
    public View.OnClickListener f() {
        return this.f21599i;
    }

    @Override // com.google.android.material.textfield.s
    public AccessibilityManager.TouchExplorationStateChangeListener h() {
        return this.f21601k;
    }

    @Override // com.google.android.material.textfield.s
    public boolean i(int i10) {
        return i10 != 0;
    }

    @Override // com.google.android.material.textfield.s
    public boolean j() {
        return true;
    }

    @Override // com.google.android.material.textfield.s
    public boolean k() {
        return this.f21602l;
    }

    @Override // com.google.android.material.textfield.s
    public boolean l() {
        return true;
    }

    @Override // com.google.android.material.textfield.s
    public boolean m() {
        return this.f21604n;
    }

    @Override // com.google.android.material.textfield.s
    public void n(EditText editText) {
        this.f21598h = D(editText);
        I();
        this.f21640a.setErrorIconDrawable((Drawable) null);
        if (!q.a(editText) && this.f21606p.isTouchExplorationEnabled()) {
            this.f21643d.setImportantForAccessibility(2);
        }
        this.f21640a.setEndIconVisible(true);
    }

    @Override // com.google.android.material.textfield.s
    public void o(View view, C0.c cVar) {
        if (!q.a(this.f21598h)) {
            cVar.m0(Spinner.class.getName());
        }
        if (cVar.X()) {
            cVar.z0(null);
        }
    }

    @Override // com.google.android.material.textfield.s
    @SuppressLint({"WrongConstant"})
    public void p(View view, AccessibilityEvent accessibilityEvent) {
        if (!this.f21606p.isEnabled() || q.a(this.f21598h)) {
            return;
        }
        boolean z10 = (accessibilityEvent.getEventType() == 32768 || accessibilityEvent.getEventType() == 8) && this.f21604n && !this.f21598h.isPopupShowing();
        if (accessibilityEvent.getEventType() == 1 || z10) {
            J();
            K();
        }
    }

    @Override // com.google.android.material.textfield.s
    public void s() {
        F();
        this.f21606p = (AccessibilityManager) this.f21642c.getSystemService("accessibility");
    }

    @Override // com.google.android.material.textfield.s
    public boolean t() {
        return true;
    }

    @Override // com.google.android.material.textfield.s
    @SuppressLint({"ClickableViewAccessibility"})
    public void u() {
        AutoCompleteTextView autoCompleteTextView = this.f21598h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            this.f21598h.setOnDismissListener(null);
        }
    }
}
