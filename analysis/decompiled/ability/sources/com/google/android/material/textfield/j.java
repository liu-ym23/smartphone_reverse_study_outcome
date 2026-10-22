package com.google.android.material.textfield;

import D7.N;
import a.AbstractC0291a;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.datepicker.ViewOnFocusChangeListenerC0907j;
import com.stepos.ability.R;

/* loaded from: classes3.dex */
public final class j extends n {
    public final int e;
    public final int f;
    public final TimeInterpolator g;
    public AutoCompleteTextView h;
    public final A6.b i;

    /* renamed from: j, reason: collision with root package name */
    public final ViewOnFocusChangeListenerC0907j f2670j;
    public final i k;
    public boolean l;
    public boolean m;
    public boolean n;
    public long o;
    public AccessibilityManager p;

    /* renamed from: q, reason: collision with root package name */
    public ValueAnimator f2671q;

    /* renamed from: r, reason: collision with root package name */
    public ValueAnimator f2672r;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.material.textfield.i] */
    public j(m mVar) {
        super(mVar);
        this.i = new A6.b(this, 5);
        this.f2670j = new ViewOnFocusChangeListenerC0907j(this, 2);
        this.k = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: com.google.android.material.textfield.i
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z10) {
                j jVar = this.f2669a;
                AutoCompleteTextView autoCompleteTextView = jVar.h;
                if (autoCompleteTextView == null || AbstractC0291a.w(autoCompleteTextView)) {
                    return;
                }
                jVar.d.setImportantForAccessibility(z10 ? 2 : 1);
            }
        };
        this.o = Long.MAX_VALUE;
        this.f = N.N(mVar.getContext(), R.attr.motionDurationShort3, 67);
        this.e = N.N(mVar.getContext(), R.attr.motionDurationShort3, 50);
        this.g = N.O(mVar.getContext(), R.attr.motionEasingLinearInterpolator, Q2.a.f1097a);
    }

    @Override // com.google.android.material.textfield.n
    public final void a() {
        if (this.p.isTouchExplorationEnabled() && AbstractC0291a.w(this.h) && !this.d.hasFocus()) {
            this.h.dismissDropDown();
        }
        this.h.post(new D6.b(this, 20));
    }

    @Override // com.google.android.material.textfield.n
    public final int c() {
        return R.string.exposed_dropdown_menu_content_description;
    }

    @Override // com.google.android.material.textfield.n
    public final int d() {
        return R.drawable.mtrl_dropdown_arrow;
    }

    @Override // com.google.android.material.textfield.n
    public final View.OnFocusChangeListener e() {
        return this.f2670j;
    }

    @Override // com.google.android.material.textfield.n
    public final View.OnClickListener f() {
        return this.i;
    }

    @Override // com.google.android.material.textfield.n
    public final AccessibilityManager.TouchExplorationStateChangeListener h() {
        return this.k;
    }

    @Override // com.google.android.material.textfield.n
    public final boolean i(int i) {
        return i != 0;
    }

    @Override // com.google.android.material.textfield.n
    public final boolean j() {
        return this.l;
    }

    @Override // com.google.android.material.textfield.n
    public final boolean l() {
        return this.n;
    }

    @Override // com.google.android.material.textfield.n
    public final void m(EditText editText) {
        if (!(editText instanceof AutoCompleteTextView)) {
            throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
        this.h = autoCompleteTextView;
        autoCompleteTextView.setOnTouchListener(new g(this, 0));
        this.h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: com.google.android.material.textfield.h
            @Override // android.widget.AutoCompleteTextView.OnDismissListener
            public final void onDismiss() {
                j jVar = this.f2668a;
                jVar.m = true;
                jVar.o = SystemClock.uptimeMillis();
                jVar.t(false);
            }
        });
        this.h.setThreshold(0);
        TextInputLayout textInputLayout = this.f2682a;
        textInputLayout.setErrorIconDrawable((Drawable) null);
        if (!AbstractC0291a.w(editText) && this.p.isTouchExplorationEnabled()) {
            this.d.setImportantForAccessibility(2);
        }
        textInputLayout.setEndIconVisible(true);
    }

    @Override // com.google.android.material.textfield.n
    public final void n(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (!AbstractC0291a.w(this.h)) {
            accessibilityNodeInfoCompat.setClassName(Spinner.class.getName());
        }
        if (accessibilityNodeInfoCompat.isShowingHintText()) {
            accessibilityNodeInfoCompat.setHintText(null);
        }
    }

    @Override // com.google.android.material.textfield.n
    public final void o(AccessibilityEvent accessibilityEvent) {
        if (!this.p.isEnabled() || AbstractC0291a.w(this.h)) {
            return;
        }
        boolean z10 = (accessibilityEvent.getEventType() == 32768 || accessibilityEvent.getEventType() == 8) && this.n && !this.h.isPopupShowing();
        if (accessibilityEvent.getEventType() == 1 || z10) {
            u();
            this.m = true;
            this.o = SystemClock.uptimeMillis();
        }
    }

    @Override // com.google.android.material.textfield.n
    public final void r() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.g;
        valueAnimatorOfFloat.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat.setDuration(this.f);
        int i = 4;
        valueAnimatorOfFloat.addUpdateListener(new A6.j(this, i));
        this.f2672r = valueAnimatorOfFloat;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat2.setDuration(this.e);
        valueAnimatorOfFloat2.addUpdateListener(new A6.j(this, i));
        this.f2671q = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.addListener(new A6.m(this, 6));
        this.p = (AccessibilityManager) this.c.getSystemService("accessibility");
    }

    @Override // com.google.android.material.textfield.n
    public final void s() {
        AutoCompleteTextView autoCompleteTextView = this.h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            this.h.setOnDismissListener(null);
        }
    }

    public final void t(boolean z10) {
        if (this.n != z10) {
            this.n = z10;
            this.f2672r.cancel();
            this.f2671q.start();
        }
    }

    public final void u() {
        if (this.h == null) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis() - this.o;
        if (jUptimeMillis < 0 || jUptimeMillis > 300) {
            this.m = false;
        }
        if (this.m) {
            this.m = false;
            return;
        }
        t(!this.n);
        if (!this.n) {
            this.h.dismissDropDown();
        } else {
            this.h.requestFocus();
            this.h.showDropDown();
        }
    }
}
