package w1;

import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.EditText;
import com.stepos.stepclaw.R;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e extends p {

    /* renamed from: e, reason: collision with root package name */
    public final int f6088e;

    /* renamed from: f, reason: collision with root package name */
    public final int f6089f;

    /* renamed from: g, reason: collision with root package name */
    public final TimeInterpolator f6090g;

    /* renamed from: h, reason: collision with root package name */
    public final TimeInterpolator f6091h;

    /* renamed from: i, reason: collision with root package name */
    public EditText f6092i;

    /* renamed from: j, reason: collision with root package name */
    public final a f6093j;

    /* renamed from: k, reason: collision with root package name */
    public final b f6094k;

    /* renamed from: l, reason: collision with root package name */
    public AnimatorSet f6095l;

    /* renamed from: m, reason: collision with root package name */
    public ValueAnimator f6096m;

    public e(o oVar) {
        super(oVar);
        this.f6093j = new a(this, 0);
        this.f6094k = new b(this, 0);
        this.f6088e = k4.v.g0(oVar.getContext(), R.attr.motionDurationShort3, 100);
        this.f6089f = k4.v.g0(oVar.getContext(), R.attr.motionDurationShort3, 150);
        this.f6090g = k4.v.h0(oVar.getContext(), R.attr.motionEasingLinearInterpolator, e1.a.f2339a);
        this.f6091h = k4.v.h0(oVar.getContext(), R.attr.motionEasingEmphasizedInterpolator, e1.a.d);
    }

    @Override // w1.p
    public final void a() {
        if (this.f6140b.f6132q != null) {
            return;
        }
        s(t());
    }

    @Override // w1.p
    public final int c() {
        return R.string.clear_text_end_icon_content_description;
    }

    @Override // w1.p
    public final int d() {
        return R.drawable.mtrl_ic_cancel;
    }

    @Override // w1.p
    public final View.OnFocusChangeListener e() {
        return this.f6094k;
    }

    @Override // w1.p
    public final View.OnClickListener f() {
        return this.f6093j;
    }

    @Override // w1.p
    public final View.OnFocusChangeListener g() {
        return this.f6094k;
    }

    @Override // w1.p
    public final void l(EditText editText) {
        this.f6092i = editText;
        this.f6139a.setEndIconVisible(t());
    }

    @Override // w1.p
    public final void o(boolean z) {
        if (this.f6140b.f6132q == null) {
            return;
        }
        s(z);
    }

    @Override // w1.p
    public final void q() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(this.f6091h);
        valueAnimatorOfFloat.setDuration(this.f6089f);
        valueAnimatorOfFloat.addUpdateListener(new c(this, 1));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.f6090g;
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        int i8 = this.f6088e;
        valueAnimatorOfFloat2.setDuration(i8);
        valueAnimatorOfFloat2.addUpdateListener(new c(this, 0));
        AnimatorSet animatorSet = new AnimatorSet();
        this.f6095l = animatorSet;
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        this.f6095l.addListener(new d(this, 0));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat3.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat3.setDuration(i8);
        valueAnimatorOfFloat3.addUpdateListener(new c(this, 0));
        this.f6096m = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.addListener(new d(this, 1));
    }

    @Override // w1.p
    public final void r() {
        EditText editText = this.f6092i;
        if (editText != null) {
            editText.post(new androidx.emoji2.text.t(8, this));
        }
    }

    public final void s(boolean z) {
        boolean z2 = this.f6140b.d() == z;
        if (z && !this.f6095l.isRunning()) {
            this.f6096m.cancel();
            this.f6095l.start();
            if (z2) {
                this.f6095l.end();
                return;
            }
            return;
        }
        if (z) {
            return;
        }
        this.f6095l.cancel();
        this.f6096m.start();
        if (z2) {
            this.f6096m.end();
        }
    }

    public final boolean t() {
        EditText editText = this.f6092i;
        if (editText != null) {
            return (editText.hasFocus() || this.d.hasFocus()) && this.f6092i.getText().length() > 0;
        }
        return false;
    }
}
