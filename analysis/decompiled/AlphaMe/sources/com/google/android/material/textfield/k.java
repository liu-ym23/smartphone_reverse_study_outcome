package com.google.android.material.textfield;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.widget.C0195d;
import com.google.android.material.datepicker.ViewOnFocusChangeListenerC0430i;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import kotlin.jvm.internal.LongCompanionObject;
import n1.AbstractC0775a;

/* loaded from: classes.dex */
public final class k extends o {

    /* renamed from: e, reason: collision with root package name */
    public final int f11018e;

    /* renamed from: f, reason: collision with root package name */
    public final int f11019f;

    /* renamed from: g, reason: collision with root package name */
    public final TimeInterpolator f11020g;

    /* renamed from: h, reason: collision with root package name */
    public AutoCompleteTextView f11021h;

    /* renamed from: i, reason: collision with root package name */
    public final ViewOnClickListenerC0435a f11022i;

    /* renamed from: j, reason: collision with root package name */
    public final ViewOnFocusChangeListenerC0430i f11023j;

    /* renamed from: k, reason: collision with root package name */
    public final j f11024k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f11025l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f11026m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f11027n;

    /* renamed from: o, reason: collision with root package name */
    public long f11028o;

    /* renamed from: p, reason: collision with root package name */
    public AccessibilityManager f11029p;

    /* renamed from: q, reason: collision with root package name */
    public ValueAnimator f11030q;

    /* renamed from: r, reason: collision with root package name */
    public ValueAnimator f11031r;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.material.textfield.j] */
    public k(n nVar) {
        super(nVar);
        this.f11022i = new ViewOnClickListenerC0435a(1, this);
        this.f11023j = new ViewOnFocusChangeListenerC0430i(2, this);
        this.f11024k = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: com.google.android.material.textfield.j
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z4) {
                k kVar = this.f11017a;
                AutoCompleteTextView autoCompleteTextView = kVar.f11021h;
                if (autoCompleteTextView == null || com.airbnb.lottie.h.u(autoCompleteTextView)) {
                    return;
                }
                kVar.f11060d.setImportantForAccessibility(z4 ? 2 : 1);
            }
        };
        this.f11028o = LongCompanionObject.MAX_VALUE;
        this.f11019f = com.stepos.statsrpk.c.L(nVar.getContext(), R.attr.motionDurationShort3, 67);
        this.f11018e = com.stepos.statsrpk.c.L(nVar.getContext(), R.attr.motionDurationShort3, 50);
        this.f11020g = com.stepos.statsrpk.c.M(nVar.getContext(), R.attr.motionEasingLinearInterpolator, AbstractC0775a.f13650a);
    }

    @Override // com.google.android.material.textfield.o
    public final void a() {
        if (this.f11029p.isTouchExplorationEnabled() && com.airbnb.lottie.h.u(this.f11021h) && !this.f11060d.hasFocus()) {
            this.f11021h.dismissDropDown();
        }
        this.f11021h.post(new androidx.activity.d(15, this));
    }

    @Override // com.google.android.material.textfield.o
    public final int c() {
        return R.string.exposed_dropdown_menu_content_description;
    }

    @Override // com.google.android.material.textfield.o
    public final int d() {
        return R.drawable.mtrl_dropdown_arrow;
    }

    @Override // com.google.android.material.textfield.o
    public final View.OnFocusChangeListener e() {
        return this.f11023j;
    }

    @Override // com.google.android.material.textfield.o
    public final View.OnClickListener f() {
        return this.f11022i;
    }

    @Override // com.google.android.material.textfield.o
    public final AccessibilityManager.TouchExplorationStateChangeListener h() {
        return this.f11024k;
    }

    @Override // com.google.android.material.textfield.o
    public final boolean i(int i4) {
        return i4 != 0;
    }

    @Override // com.google.android.material.textfield.o
    public final boolean j() {
        return this.f11025l;
    }

    @Override // com.google.android.material.textfield.o
    public final boolean l() {
        return this.f11027n;
    }

    @Override // com.google.android.material.textfield.o
    public final void m(EditText editText) {
        if (!(editText instanceof AutoCompleteTextView)) {
            throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
        this.f11021h = autoCompleteTextView;
        autoCompleteTextView.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.textfield.h
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                k kVar = this.f11015a;
                kVar.getClass();
                if (motionEvent.getAction() == 1) {
                    long jUptimeMillis = SystemClock.uptimeMillis() - kVar.f11028o;
                    if (jUptimeMillis < 0 || jUptimeMillis > 300) {
                        kVar.f11026m = false;
                    }
                    kVar.u();
                    kVar.f11026m = true;
                    kVar.f11028o = SystemClock.uptimeMillis();
                }
                return false;
            }
        });
        this.f11021h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: com.google.android.material.textfield.i
            @Override // android.widget.AutoCompleteTextView.OnDismissListener
            public final void onDismiss() {
                k kVar = this.f11016a;
                kVar.f11026m = true;
                kVar.f11028o = SystemClock.uptimeMillis();
                kVar.t(false);
            }
        });
        this.f11021h.setThreshold(0);
        TextInputLayout textInputLayout = this.f11057a;
        textInputLayout.setErrorIconDrawable((Drawable) null);
        if (!com.airbnb.lottie.h.u(editText) && this.f11029p.isTouchExplorationEnabled()) {
            this.f11060d.setImportantForAccessibility(2);
        }
        textInputLayout.setEndIconVisible(true);
    }

    @Override // com.google.android.material.textfield.o
    public final void n(L.g gVar) {
        if (!com.airbnb.lottie.h.u(this.f11021h)) {
            gVar.g(Spinner.class.getName());
        }
        if (gVar.f1142a.isShowingHintText()) {
            gVar.f1142a.setHintText(null);
        }
    }

    @Override // com.google.android.material.textfield.o
    public final void o(AccessibilityEvent accessibilityEvent) {
        if (!this.f11029p.isEnabled() || com.airbnb.lottie.h.u(this.f11021h)) {
            return;
        }
        boolean z4 = (accessibilityEvent.getEventType() == 32768 || accessibilityEvent.getEventType() == 8) && this.f11027n && !this.f11021h.isPopupShowing();
        if (accessibilityEvent.getEventType() == 1 || z4) {
            u();
            this.f11026m = true;
            this.f11028o = SystemClock.uptimeMillis();
        }
    }

    @Override // com.google.android.material.textfield.o
    public final void r() {
        int i4 = 2;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(Property.DEFAULT_FLOAT_VALUE, 1.0f);
        TimeInterpolator timeInterpolator = this.f11020g;
        valueAnimatorOfFloat.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat.setDuration(this.f11019f);
        valueAnimatorOfFloat.addUpdateListener(new b(this, i4));
        this.f11031r = valueAnimatorOfFloat;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, Property.DEFAULT_FLOAT_VALUE);
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat2.setDuration(this.f11018e);
        valueAnimatorOfFloat2.addUpdateListener(new b(this, i4));
        this.f11030q = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.addListener(new C0195d(8, this));
        this.f11029p = (AccessibilityManager) this.f11059c.getSystemService("accessibility");
    }

    @Override // com.google.android.material.textfield.o
    public final void s() {
        AutoCompleteTextView autoCompleteTextView = this.f11021h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            this.f11021h.setOnDismissListener(null);
        }
    }

    public final void t(boolean z4) {
        if (this.f11027n != z4) {
            this.f11027n = z4;
            this.f11031r.cancel();
            this.f11030q.start();
        }
    }

    public final void u() {
        if (this.f11021h == null) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis() - this.f11028o;
        if (jUptimeMillis < 0 || jUptimeMillis > 300) {
            this.f11026m = false;
        }
        if (this.f11026m) {
            this.f11026m = false;
            return;
        }
        t(!this.f11027n);
        if (!this.f11027n) {
            this.f11021h.dismissDropDown();
        } else {
            this.f11021h.requestFocus();
            this.f11021h.showDropDown();
        }
    }
}
