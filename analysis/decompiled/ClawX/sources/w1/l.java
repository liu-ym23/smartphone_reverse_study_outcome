package w1;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
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
import com.google.android.material.textfield.TextInputLayout;
import com.stepos.stepclaw.R;
import org.tukaani.xz.common.Util;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l extends p {

    /* renamed from: e, reason: collision with root package name */
    public final int f6102e;

    /* renamed from: f, reason: collision with root package name */
    public final int f6103f;

    /* renamed from: g, reason: collision with root package name */
    public final TimeInterpolator f6104g;

    /* renamed from: h, reason: collision with root package name */
    public AutoCompleteTextView f6105h;

    /* renamed from: i, reason: collision with root package name */
    public final a f6106i;

    /* renamed from: j, reason: collision with root package name */
    public final b f6107j;

    /* renamed from: k, reason: collision with root package name */
    public final k f6108k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f6109l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f6110m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f6111n;

    /* renamed from: o, reason: collision with root package name */
    public long f6112o;

    /* renamed from: p, reason: collision with root package name */
    public AccessibilityManager f6113p;

    /* renamed from: q, reason: collision with root package name */
    public ValueAnimator f6114q;

    /* renamed from: r, reason: collision with root package name */
    public ValueAnimator f6115r;

    /* JADX WARN: Type inference failed for: r0v2, types: [w1.k] */
    public l(o oVar) {
        super(oVar);
        this.f6106i = new a(this, 1);
        this.f6107j = new b(this, 1);
        this.f6108k = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: w1.k
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z) {
                l lVar = this.f6101a;
                AutoCompleteTextView autoCompleteTextView = lVar.f6105h;
                if (autoCompleteTextView == null || autoCompleteTextView.getInputType() != 0) {
                    return;
                }
                lVar.d.setImportantForAccessibility(z ? 2 : 1);
            }
        };
        this.f6112o = Util.VLI_MAX;
        this.f6103f = k4.v.g0(oVar.getContext(), R.attr.motionDurationShort3, 67);
        this.f6102e = k4.v.g0(oVar.getContext(), R.attr.motionDurationShort3, 50);
        this.f6104g = k4.v.h0(oVar.getContext(), R.attr.motionEasingLinearInterpolator, e1.a.f2339a);
    }

    @Override // w1.p
    public final void a() {
        if (this.f6113p.isTouchExplorationEnabled() && this.f6105h.getInputType() != 0 && !this.d.hasFocus()) {
            this.f6105h.dismissDropDown();
        }
        this.f6105h.post(new androidx.emoji2.text.t(9, this));
    }

    @Override // w1.p
    public final int c() {
        return R.string.exposed_dropdown_menu_content_description;
    }

    @Override // w1.p
    public final int d() {
        return R.drawable.mtrl_dropdown_arrow;
    }

    @Override // w1.p
    public final View.OnFocusChangeListener e() {
        return this.f6107j;
    }

    @Override // w1.p
    public final View.OnClickListener f() {
        return this.f6106i;
    }

    @Override // w1.p
    public final AccessibilityManager.TouchExplorationStateChangeListener h() {
        return this.f6108k;
    }

    @Override // w1.p
    public final boolean i(int i8) {
        return i8 != 0;
    }

    @Override // w1.p
    public final boolean k() {
        return this.f6111n;
    }

    @Override // w1.p
    public final void l(EditText editText) {
        if (!(editText instanceof AutoCompleteTextView)) {
            throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
        this.f6105h = autoCompleteTextView;
        autoCompleteTextView.setOnTouchListener(new View.OnTouchListener() { // from class: w1.i
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    l lVar = this.f6099a;
                    long j4 = jUptimeMillis - lVar.f6112o;
                    if (j4 < 0 || j4 > 300) {
                        lVar.f6110m = false;
                    }
                    lVar.t();
                    lVar.f6110m = true;
                    lVar.f6112o = SystemClock.uptimeMillis();
                }
                return false;
            }
        });
        this.f6105h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: w1.j
            @Override // android.widget.AutoCompleteTextView.OnDismissListener
            public final void onDismiss() {
                l lVar = this.f6100a;
                lVar.f6110m = true;
                lVar.f6112o = SystemClock.uptimeMillis();
                lVar.s(false);
            }
        });
        this.f6105h.setThreshold(0);
        TextInputLayout textInputLayout = this.f6139a;
        textInputLayout.setErrorIconDrawable((Drawable) null);
        if (editText.getInputType() == 0 && this.f6113p.isTouchExplorationEnabled()) {
            this.d.setImportantForAccessibility(2);
        }
        textInputLayout.setEndIconVisible(true);
    }

    @Override // w1.p
    public final void m(f0.g gVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = gVar.f2542a;
        if (this.f6105h.getInputType() == 0) {
            gVar.h(Spinner.class.getName());
        }
        if (accessibilityNodeInfo.isShowingHintText()) {
            accessibilityNodeInfo.setHintText(null);
        }
    }

    @Override // w1.p
    public final void n(AccessibilityEvent accessibilityEvent) {
        if (this.f6113p.isEnabled() && this.f6105h.getInputType() == 0) {
            boolean z = (accessibilityEvent.getEventType() == 32768 || accessibilityEvent.getEventType() == 8) && this.f6111n && !this.f6105h.isPopupShowing();
            if (accessibilityEvent.getEventType() == 1 || z) {
                t();
                this.f6110m = true;
                this.f6112o = SystemClock.uptimeMillis();
            }
        }
    }

    @Override // w1.p
    public final void q() {
        int i8 = 2;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.f6104g;
        valueAnimatorOfFloat.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat.setDuration(this.f6103f);
        valueAnimatorOfFloat.addUpdateListener(new c(this, i8));
        this.f6115r = valueAnimatorOfFloat;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat2.setDuration(this.f6102e);
        valueAnimatorOfFloat2.addUpdateListener(new c(this, i8));
        this.f6114q = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.addListener(new a1.k(4, this));
        this.f6113p = (AccessibilityManager) this.f6141c.getSystemService("accessibility");
    }

    @Override // w1.p
    public final void r() {
        AutoCompleteTextView autoCompleteTextView = this.f6105h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            this.f6105h.setOnDismissListener(null);
        }
    }

    public final void s(boolean z) {
        if (this.f6111n != z) {
            this.f6111n = z;
            this.f6115r.cancel();
            this.f6114q.start();
        }
    }

    public final void t() {
        if (this.f6105h == null) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis() - this.f6112o;
        if (jUptimeMillis < 0 || jUptimeMillis > 300) {
            this.f6110m = false;
        }
        if (this.f6110m) {
            this.f6110m = false;
            return;
        }
        s(!this.f6111n);
        if (!this.f6111n) {
            this.f6105h.dismissDropDown();
        } else {
            this.f6105h.requestFocus();
            this.f6105h.showDropDown();
        }
    }
}
