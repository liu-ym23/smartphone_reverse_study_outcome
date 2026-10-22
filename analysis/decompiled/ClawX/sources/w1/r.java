package w1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import com.stepos.stepclaw.R;
import com.stepos.stepclaw.SecurePrefs;
import g.g0;
import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class r {
    public ColorStateList A;
    public Typeface B;

    /* renamed from: a, reason: collision with root package name */
    public final int f6143a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6144b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6145c;
    public final TimeInterpolator d;

    /* renamed from: e, reason: collision with root package name */
    public final TimeInterpolator f6146e;

    /* renamed from: f, reason: collision with root package name */
    public final TimeInterpolator f6147f;

    /* renamed from: g, reason: collision with root package name */
    public final Context f6148g;

    /* renamed from: h, reason: collision with root package name */
    public final TextInputLayout f6149h;

    /* renamed from: i, reason: collision with root package name */
    public LinearLayout f6150i;

    /* renamed from: j, reason: collision with root package name */
    public int f6151j;

    /* renamed from: k, reason: collision with root package name */
    public FrameLayout f6152k;

    /* renamed from: l, reason: collision with root package name */
    public AnimatorSet f6153l;

    /* renamed from: m, reason: collision with root package name */
    public final float f6154m;

    /* renamed from: n, reason: collision with root package name */
    public int f6155n;

    /* renamed from: o, reason: collision with root package name */
    public int f6156o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f6157p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f6158q;

    /* renamed from: r, reason: collision with root package name */
    public g0 f6159r;

    /* renamed from: s, reason: collision with root package name */
    public CharSequence f6160s;

    /* renamed from: t, reason: collision with root package name */
    public int f6161t;

    /* renamed from: u, reason: collision with root package name */
    public int f6162u;

    /* renamed from: v, reason: collision with root package name */
    public ColorStateList f6163v;

    /* renamed from: w, reason: collision with root package name */
    public CharSequence f6164w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f6165x;
    public g0 y;
    public int z;

    public r(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f6148g = context;
        this.f6149h = textInputLayout;
        this.f6154m = context.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
        this.f6143a = k4.v.g0(context, R.attr.motionDurationShort4, 217);
        this.f6144b = k4.v.g0(context, R.attr.motionDurationMedium4, 167);
        this.f6145c = k4.v.g0(context, R.attr.motionDurationShort4, 167);
        this.d = k4.v.h0(context, R.attr.motionEasingEmphasizedDecelerateInterpolator, e1.a.d);
        LinearInterpolator linearInterpolator = e1.a.f2339a;
        this.f6146e = k4.v.h0(context, R.attr.motionEasingEmphasizedDecelerateInterpolator, linearInterpolator);
        this.f6147f = k4.v.h0(context, R.attr.motionEasingLinearInterpolator, linearInterpolator);
    }

    public final void a(g0 g0Var, int i8) {
        if (this.f6150i == null && this.f6152k == null) {
            Context context = this.f6148g;
            LinearLayout linearLayout = new LinearLayout(context);
            this.f6150i = linearLayout;
            linearLayout.setOrientation(0);
            LinearLayout linearLayout2 = this.f6150i;
            TextInputLayout textInputLayout = this.f6149h;
            textInputLayout.addView(linearLayout2, -1, -2);
            this.f6152k = new FrameLayout(context);
            this.f6150i.addView(this.f6152k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (textInputLayout.getEditText() != null) {
                b();
            }
        }
        if (i8 == 0 || i8 == 1) {
            this.f6152k.setVisibility(0);
            this.f6152k.addView(g0Var);
        } else {
            this.f6150i.addView(g0Var, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f6150i.setVisibility(0);
        this.f6151j++;
    }

    public final void b() {
        if (this.f6150i != null) {
            TextInputLayout textInputLayout = this.f6149h;
            if (textInputLayout.getEditText() != null) {
                EditText editText = textInputLayout.getEditText();
                Context context = this.f6148g;
                boolean zW = k4.v.W(context);
                LinearLayout linearLayout = this.f6150i;
                int paddingStart = editText.getPaddingStart();
                if (zW) {
                    paddingStart = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
                }
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top);
                if (zW) {
                    dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_top);
                }
                int paddingEnd = editText.getPaddingEnd();
                if (zW) {
                    paddingEnd = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
                }
                linearLayout.setPaddingRelative(paddingStart, dimensionPixelSize, paddingEnd, 0);
            }
        }
    }

    public final void c() {
        AnimatorSet animatorSet = this.f6153l;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public final void d(ArrayList arrayList, boolean z, g0 g0Var, int i8, int i9, int i10) {
        if (g0Var == null || !z) {
            return;
        }
        if (i8 == i10 || i8 == i9) {
            boolean z2 = i10 == i8;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(g0Var, (Property<g0, Float>) View.ALPHA, z2 ? 1.0f : 0.0f);
            int i11 = this.f6145c;
            objectAnimatorOfFloat.setDuration(z2 ? this.f6144b : i11);
            objectAnimatorOfFloat.setInterpolator(z2 ? this.f6146e : this.f6147f);
            if (i8 == i10 && i9 != 0) {
                objectAnimatorOfFloat.setStartDelay(i11);
            }
            arrayList.add(objectAnimatorOfFloat);
            if (i10 != i8 || i9 == 0) {
                return;
            }
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(g0Var, (Property<g0, Float>) View.TRANSLATION_Y, -this.f6154m, 0.0f);
            objectAnimatorOfFloat2.setDuration(this.f6143a);
            objectAnimatorOfFloat2.setInterpolator(this.d);
            objectAnimatorOfFloat2.setStartDelay(i11);
            arrayList.add(objectAnimatorOfFloat2);
        }
    }

    public final TextView e(int i8) {
        if (i8 == 1) {
            return this.f6159r;
        }
        if (i8 != 2) {
            return null;
        }
        return this.y;
    }

    public final void f() {
        this.f6157p = null;
        c();
        if (this.f6155n == 1) {
            if (!this.f6165x || TextUtils.isEmpty(this.f6164w)) {
                this.f6156o = 0;
            } else {
                this.f6156o = 2;
            }
        }
        i(this.f6155n, this.f6156o, h(this.f6159r, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID));
    }

    public final void g(g0 g0Var, int i8) {
        FrameLayout frameLayout;
        LinearLayout linearLayout = this.f6150i;
        if (linearLayout == null) {
            return;
        }
        if ((i8 == 0 || i8 == 1) && (frameLayout = this.f6152k) != null) {
            frameLayout.removeView(g0Var);
        } else {
            linearLayout.removeView(g0Var);
        }
        int i9 = this.f6151j - 1;
        this.f6151j = i9;
        LinearLayout linearLayout2 = this.f6150i;
        if (i9 == 0) {
            linearLayout2.setVisibility(8);
        }
    }

    public final boolean h(g0 g0Var, CharSequence charSequence) {
        TextInputLayout textInputLayout = this.f6149h;
        if (textInputLayout.isLaidOut() && textInputLayout.isEnabled()) {
            return (this.f6156o == this.f6155n && g0Var != null && TextUtils.equals(g0Var.getText(), charSequence)) ? false : true;
        }
        return false;
    }

    public final void i(int i8, int i9, boolean z) {
        TextView textViewE;
        TextView textViewE2;
        r rVar = this;
        if (i8 == i9) {
            return;
        }
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            rVar.f6153l = animatorSet;
            ArrayList arrayList = new ArrayList();
            rVar.d(arrayList, rVar.f6165x, rVar.y, 2, i8, i9);
            rVar.d(arrayList, rVar.f6158q, rVar.f6159r, 1, i8, i9);
            int size = arrayList.size();
            long jMax = 0;
            for (int i10 = 0; i10 < size; i10++) {
                Animator animator = (Animator) arrayList.get(i10);
                jMax = Math.max(jMax, animator.getDuration() + animator.getStartDelay());
            }
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 0);
            valueAnimatorOfInt.setDuration(jMax);
            arrayList.add(0, valueAnimatorOfInt);
            animatorSet.playTogether(arrayList);
            v0.d dVar = new v0.d(this, i9, e(i8), i8, rVar.e(i9));
            rVar = this;
            animatorSet.addListener(dVar);
            animatorSet.start();
        } else if (i8 != i9) {
            if (i9 != 0 && (textViewE2 = rVar.e(i9)) != null) {
                textViewE2.setVisibility(0);
                textViewE2.setAlpha(1.0f);
            }
            if (i8 != 0 && (textViewE = e(i8)) != null) {
                textViewE.setVisibility(4);
                if (i8 == 1) {
                    textViewE.setText((CharSequence) null);
                }
            }
            rVar.f6155n = i9;
        }
        TextInputLayout textInputLayout = rVar.f6149h;
        textInputLayout.t();
        textInputLayout.w(z, false);
        textInputLayout.z();
    }
}
