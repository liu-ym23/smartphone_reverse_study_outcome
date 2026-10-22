package com.google.android.material.textfield;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.widget.z0;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j extends l {

    /* renamed from: e, reason: collision with root package name */
    public final int f5247e;

    /* renamed from: f, reason: collision with root package name */
    public final int f5248f;

    /* renamed from: g, reason: collision with root package name */
    public final TimeInterpolator f5249g;
    public AutoCompleteTextView h;

    /* renamed from: i, reason: collision with root package name */
    public final com.google.android.material.datepicker.k f5250i;

    /* renamed from: j, reason: collision with root package name */
    public final a f5251j;

    /* renamed from: k, reason: collision with root package name */
    public final i f5252k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f5253l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f5254m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f5255n;

    /* renamed from: o, reason: collision with root package name */
    public long f5256o;

    /* renamed from: p, reason: collision with root package name */
    public AccessibilityManager f5257p;

    /* renamed from: q, reason: collision with root package name */
    public ValueAnimator f5258q;
    public ValueAnimator r;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.material.textfield.i] */
    public j(k kVar) {
        super(kVar);
        this.f5250i = new com.google.android.material.datepicker.k(this, 2);
        this.f5251j = new a(this, 1);
        this.f5252k = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: com.google.android.material.textfield.i
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z) {
                j jVar = this.f5246a;
                AutoCompleteTextView autoCompleteTextView = jVar.h;
                if (autoCompleteTextView == null || autoCompleteTextView.getInputType() != 0) {
                    return;
                }
                jVar.f5289d.setImportantForAccessibility(z ? 2 : 1);
            }
        };
        this.f5256o = Long.MAX_VALUE;
        this.f5248f = u4.j.c(kVar.getContext(), R.attr.motionDurationShort3, 67);
        this.f5247e = u4.j.c(kVar.getContext(), R.attr.motionDurationShort3, 50);
        this.f5249g = u4.j.d(kVar.getContext(), R.attr.motionEasingLinearInterpolator, l4.a.f10220a);
    }

    @Override // com.google.android.material.textfield.l
    public final void a() {
        if (this.f5257p.isTouchExplorationEnabled() && this.h.getInputType() != 0 && !this.f5289d.hasFocus()) {
            this.h.dismissDropDown();
        }
        this.h.post(new z0(this, 9));
    }

    @Override // com.google.android.material.textfield.l
    public final int c() {
        return R.string.exposed_dropdown_menu_content_description;
    }

    @Override // com.google.android.material.textfield.l
    public final int d() {
        return R.drawable.mtrl_dropdown_arrow;
    }

    @Override // com.google.android.material.textfield.l
    public final View.OnFocusChangeListener e() {
        return this.f5251j;
    }

    @Override // com.google.android.material.textfield.l
    public final View.OnClickListener f() {
        return this.f5250i;
    }

    @Override // com.google.android.material.textfield.l
    public final AccessibilityManager.TouchExplorationStateChangeListener h() {
        return this.f5252k;
    }

    @Override // com.google.android.material.textfield.l
    public final boolean i(int i10) {
        return i10 != 0;
    }

    @Override // com.google.android.material.textfield.l
    public final boolean k() {
        return this.f5255n;
    }

    @Override // com.google.android.material.textfield.l
    public final void l(EditText editText) {
        if (!(editText instanceof AutoCompleteTextView)) {
            throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
        this.h = autoCompleteTextView;
        autoCompleteTextView.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.textfield.g
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    j jVar = this.f5244a;
                    long j10 = jUptimeMillis - jVar.f5256o;
                    if (j10 < 0 || j10 > 300) {
                        jVar.f5254m = false;
                    }
                    jVar.t();
                    jVar.f5254m = true;
                    jVar.f5256o = SystemClock.uptimeMillis();
                }
                return false;
            }
        });
        this.h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: com.google.android.material.textfield.h
            @Override // android.widget.AutoCompleteTextView.OnDismissListener
            public final void onDismiss() {
                j jVar = this.f5245a;
                jVar.f5254m = true;
                jVar.f5256o = SystemClock.uptimeMillis();
                jVar.s(false);
            }
        });
        this.h.setThreshold(0);
        TextInputLayout textInputLayout = this.f5286a;
        textInputLayout.setErrorIconDrawable((Drawable) null);
        if (editText.getInputType() == 0 && this.f5257p.isTouchExplorationEnabled()) {
            this.f5289d.setImportantForAccessibility(2);
        }
        textInputLayout.setEndIconVisible(true);
    }

    @Override // com.google.android.material.textfield.l
    public final void m(w0.b bVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = bVar.f13532a;
        if (this.h.getInputType() == 0) {
            bVar.h(Spinner.class.getName());
        }
        if (accessibilityNodeInfo.isShowingHintText()) {
            accessibilityNodeInfo.setHintText(null);
        }
    }

    @Override // com.google.android.material.textfield.l
    @SuppressLint({"WrongConstant"})
    public final void n(AccessibilityEvent accessibilityEvent) {
        if (this.f5257p.isEnabled() && this.h.getInputType() == 0) {
            boolean z = (accessibilityEvent.getEventType() == 32768 || accessibilityEvent.getEventType() == 8) && this.f5255n && !this.h.isPopupShowing();
            if (accessibilityEvent.getEventType() == 1 || z) {
                t();
                this.f5254m = true;
                this.f5256o = SystemClock.uptimeMillis();
            }
        }
    }

    @Override // com.google.android.material.textfield.l
    public final void q() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.f5249g;
        valueAnimatorOfFloat.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat.setDuration(this.f5248f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                j jVar = this.f5243a;
                jVar.getClass();
                jVar.f5289d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.r = valueAnimatorOfFloat;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat2.setDuration(this.f5247e);
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                j jVar = this.f5243a;
                jVar.getClass();
                jVar.f5289d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.f5258q = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.addListener(new com.google.android.material.appbar.h(this, 2));
        this.f5257p = (AccessibilityManager) this.f5288c.getSystemService("accessibility");
    }

    @Override // com.google.android.material.textfield.l
    @SuppressLint({"ClickableViewAccessibility"})
    public final void r() {
        AutoCompleteTextView autoCompleteTextView = this.h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            this.h.setOnDismissListener(null);
        }
    }

    public final void s(boolean z) {
        if (this.f5255n != z) {
            this.f5255n = z;
            this.r.cancel();
            this.f5258q.start();
        }
    }

    public final void t() {
        if (this.h == null) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis() - this.f5256o;
        if (jUptimeMillis < 0 || jUptimeMillis > 300) {
            this.f5254m = false;
        }
        if (this.f5254m) {
            this.f5254m = false;
            return;
        }
        s(!this.f5255n);
        if (!this.f5255n) {
            this.h.dismissDropDown();
        } else {
            this.h.requestFocus();
            this.h.showDropDown();
        }
    }
}
