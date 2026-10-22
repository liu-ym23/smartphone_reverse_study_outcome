package com.google.android.material.textfield;

import a1.C0409b;
import a1.C0412e;
import a1.C0416i;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
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
import b1.C0553a;

/* loaded from: classes.dex */
class p extends s {

    /* renamed from: e, reason: collision with root package name */
    private final int f13328e;

    /* renamed from: f, reason: collision with root package name */
    private final int f13329f;

    /* renamed from: g, reason: collision with root package name */
    private final TimeInterpolator f13330g;

    /* renamed from: h, reason: collision with root package name */
    private AutoCompleteTextView f13331h;

    /* renamed from: i, reason: collision with root package name */
    private final View.OnClickListener f13332i;

    /* renamed from: j, reason: collision with root package name */
    private final View.OnFocusChangeListener f13333j;

    /* renamed from: k, reason: collision with root package name */
    private final AccessibilityManager.TouchExplorationStateChangeListener f13334k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f13335l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f13336m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f13337n;

    /* renamed from: o, reason: collision with root package name */
    private long f13338o;

    /* renamed from: p, reason: collision with root package name */
    private AccessibilityManager f13339p;

    /* renamed from: q, reason: collision with root package name */
    private ValueAnimator f13340q;

    /* renamed from: r, reason: collision with root package name */
    private ValueAnimator f13341r;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            p.this.r();
            p.this.f13341r.start();
        }
    }

    p(r rVar) {
        super(rVar);
        this.f13332i = new View.OnClickListener() { // from class: com.google.android.material.textfield.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13324a.J();
            }
        };
        this.f13333j = new View.OnFocusChangeListener() { // from class: com.google.android.material.textfield.m
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z5) {
                p.y(this.f13325a, view, z5);
            }
        };
        this.f13334k = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: com.google.android.material.textfield.n
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z5) {
                p.w(this.f13326a, z5);
            }
        };
        this.f13338o = Long.MAX_VALUE;
        Context context = rVar.getContext();
        int i5 = C0409b.f6692B;
        this.f13329f = o1.e.f(context, i5, 67);
        this.f13328e = o1.e.f(rVar.getContext(), i5, 50);
        this.f13330g = o1.e.g(rVar.getContext(), C0409b.f6697G, C0553a.f11783a);
    }

    public static /* synthetic */ void A(p pVar) {
        pVar.K();
        pVar.H(false);
    }

    private static AutoCompleteTextView D(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private ValueAnimator E(int i5, float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(this.f13330g);
        valueAnimatorOfFloat.setDuration(i5);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.i
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                p.x(this.f13321a, valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    private void F() {
        this.f13341r = E(this.f13329f, 0.0f, 1.0f);
        ValueAnimator valueAnimatorE = E(this.f13328e, 1.0f, 0.0f);
        this.f13340q = valueAnimatorE;
        valueAnimatorE.addListener(new a());
    }

    private boolean G() {
        long jUptimeMillis = SystemClock.uptimeMillis() - this.f13338o;
        return jUptimeMillis < 0 || jUptimeMillis > 300;
    }

    private void H(boolean z5) {
        if (this.f13337n != z5) {
            this.f13337n = z5;
            this.f13341r.cancel();
            this.f13340q.start();
        }
    }

    private void I() {
        this.f13331h.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.textfield.j
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return p.z(this.f13322a, view, motionEvent);
            }
        });
        this.f13331h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: com.google.android.material.textfield.k
            @Override // android.widget.AutoCompleteTextView.OnDismissListener
            public final void onDismiss() {
                p.A(this.f13323a);
            }
        });
        this.f13331h.setThreshold(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        if (this.f13331h == null) {
            return;
        }
        if (G()) {
            this.f13336m = false;
        }
        if (this.f13336m) {
            this.f13336m = false;
            return;
        }
        H(!this.f13337n);
        if (!this.f13337n) {
            this.f13331h.dismissDropDown();
        } else {
            this.f13331h.requestFocus();
            this.f13331h.showDropDown();
        }
    }

    private void K() {
        this.f13336m = true;
        this.f13338o = SystemClock.uptimeMillis();
    }

    public static /* synthetic */ void v(p pVar) {
        boolean zIsPopupShowing = pVar.f13331h.isPopupShowing();
        pVar.H(zIsPopupShowing);
        pVar.f13336m = zIsPopupShowing;
    }

    public static /* synthetic */ void w(p pVar, boolean z5) {
        AutoCompleteTextView autoCompleteTextView = pVar.f13331h;
        if (autoCompleteTextView == null || q.a(autoCompleteTextView)) {
            return;
        }
        pVar.f13376d.setImportantForAccessibility(z5 ? 2 : 1);
    }

    public static /* synthetic */ void x(p pVar, ValueAnimator valueAnimator) {
        pVar.getClass();
        pVar.f13376d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public static /* synthetic */ void y(p pVar, View view, boolean z5) {
        pVar.f13335l = z5;
        pVar.r();
        if (z5) {
            return;
        }
        pVar.H(false);
        pVar.f13336m = false;
    }

    public static /* synthetic */ boolean z(p pVar, View view, MotionEvent motionEvent) {
        pVar.getClass();
        if (motionEvent.getAction() == 1) {
            if (pVar.G()) {
                pVar.f13336m = false;
            }
            pVar.J();
            pVar.K();
        }
        return false;
    }

    @Override // com.google.android.material.textfield.s
    public void a(Editable editable) {
        if (this.f13339p.isTouchExplorationEnabled() && q.a(this.f13331h) && !this.f13376d.hasFocus()) {
            this.f13331h.dismissDropDown();
        }
        this.f13331h.post(new Runnable() { // from class: com.google.android.material.textfield.o
            @Override // java.lang.Runnable
            public final void run() {
                p.v(this.f13327a);
            }
        });
    }

    @Override // com.google.android.material.textfield.s
    int c() {
        return C0416i.f6891g;
    }

    @Override // com.google.android.material.textfield.s
    int d() {
        return C0412e.f6815i;
    }

    @Override // com.google.android.material.textfield.s
    View.OnFocusChangeListener e() {
        return this.f13333j;
    }

    @Override // com.google.android.material.textfield.s
    View.OnClickListener f() {
        return this.f13332i;
    }

    @Override // com.google.android.material.textfield.s
    public AccessibilityManager.TouchExplorationStateChangeListener h() {
        return this.f13334k;
    }

    @Override // com.google.android.material.textfield.s
    boolean i(int i5) {
        return i5 != 0;
    }

    @Override // com.google.android.material.textfield.s
    boolean j() {
        return true;
    }

    @Override // com.google.android.material.textfield.s
    boolean k() {
        return this.f13335l;
    }

    @Override // com.google.android.material.textfield.s
    boolean l() {
        return true;
    }

    @Override // com.google.android.material.textfield.s
    boolean m() {
        return this.f13337n;
    }

    @Override // com.google.android.material.textfield.s
    public void n(EditText editText) {
        this.f13331h = D(editText);
        I();
        this.f13373a.setErrorIconDrawable((Drawable) null);
        if (!q.a(editText) && this.f13339p.isTouchExplorationEnabled()) {
            this.f13376d.setImportantForAccessibility(2);
        }
        this.f13373a.setEndIconVisible(true);
    }

    @Override // com.google.android.material.textfield.s
    public void o(View view, E.c cVar) {
        if (!q.a(this.f13331h)) {
            cVar.d0(Spinner.class.getName());
        }
        if (cVar.P()) {
            cVar.o0(null);
        }
    }

    @Override // com.google.android.material.textfield.s
    public void p(View view, AccessibilityEvent accessibilityEvent) {
        if (!this.f13339p.isEnabled() || q.a(this.f13331h)) {
            return;
        }
        boolean z5 = (accessibilityEvent.getEventType() == 32768 || accessibilityEvent.getEventType() == 8) && this.f13337n && !this.f13331h.isPopupShowing();
        if (accessibilityEvent.getEventType() == 1 || z5) {
            J();
            K();
        }
    }

    @Override // com.google.android.material.textfield.s
    void s() {
        F();
        this.f13339p = (AccessibilityManager) this.f13375c.getSystemService("accessibility");
    }

    @Override // com.google.android.material.textfield.s
    boolean t() {
        return true;
    }

    @Override // com.google.android.material.textfield.s
    void u() {
        AutoCompleteTextView autoCompleteTextView = this.f13331h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            this.f13331h.setOnDismissListener(null);
        }
    }
}
