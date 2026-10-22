package com.stepos.common.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.libpag.PAGView;

/* loaded from: classes.dex */
public class StepOSPAGEmptyLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private PAGView f14241a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f14242b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f14243c;

    /* renamed from: d, reason: collision with root package name */
    private ValueAnimator f14244d;

    /* renamed from: e, reason: collision with root package name */
    private String f14245e;

    /* renamed from: f, reason: collision with root package name */
    private int f14246f;

    /* renamed from: g, reason: collision with root package name */
    private int f14247g;

    /* renamed from: h, reason: collision with root package name */
    private int f14248h;

    /* renamed from: i, reason: collision with root package name */
    private int f14249i;

    /* renamed from: j, reason: collision with root package name */
    private int f14250j;

    /* renamed from: k, reason: collision with root package name */
    private String f14251k;

    /* renamed from: l, reason: collision with root package name */
    private String f14252l;

    /* renamed from: m, reason: collision with root package name */
    private String f14253m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f14254n;

    /* renamed from: o, reason: collision with root package name */
    private TextView f14255o;

    /* renamed from: p, reason: collision with root package name */
    private final List<View> f14256p;

    /* renamed from: q, reason: collision with root package name */
    private final Runnable f14257q;

    public StepOSPAGEmptyLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static /* synthetic */ void a(StepOSPAGEmptyLayout stepOSPAGEmptyLayout, ValueAnimator valueAnimator) {
        stepOSPAGEmptyLayout.getClass();
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        TextView textView = stepOSPAGEmptyLayout.f14242b;
        if (textView != null) {
            textView.setAlpha(fFloatValue);
        }
        TextView textView2 = stepOSPAGEmptyLayout.f14255o;
        if (textView2 != null) {
            textView2.setAlpha(fFloatValue);
        }
        TextView textView3 = stepOSPAGEmptyLayout.f14243c;
        if (textView3 != null) {
            textView3.setAlpha(fFloatValue);
        }
        Iterator<View> it = stepOSPAGEmptyLayout.f14256p.iterator();
        while (it.hasNext()) {
            it.next().setAlpha(fFloatValue);
        }
    }

    private void c() {
        PAGView pAGView = this.f14241a;
        if (pAGView != null) {
            pAGView.setVisibility(4);
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f14244d = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.f14244d.setInterpolator(new K1.a(0.33f, 0.0f, 0.67f, 1.0f));
        this.f14244d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.common.widget.k
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                StepOSPAGEmptyLayout.a(this.f14432a, valueAnimator);
            }
        });
    }

    private void d(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, H1.m.p5);
        this.f14245e = typedArrayObtainStyledAttributes.getString(H1.m.y5);
        this.f14246f = typedArrayObtainStyledAttributes.getInt(H1.m.q5, 1);
        this.f14248h = typedArrayObtainStyledAttributes.getResourceId(H1.m.v5, -1);
        this.f14249i = typedArrayObtainStyledAttributes.getResourceId(H1.m.r5, -1);
        this.f14250j = typedArrayObtainStyledAttributes.getResourceId(H1.m.s5, 0);
        this.f14251k = typedArrayObtainStyledAttributes.getString(H1.m.w5);
        this.f14252l = typedArrayObtainStyledAttributes.getString(H1.m.x5);
        this.f14253m = typedArrayObtainStyledAttributes.getString(H1.m.t5);
        this.f14254n = typedArrayObtainStyledAttributes.getBoolean(H1.m.z5, false);
        this.f14247g = typedArrayObtainStyledAttributes.getResourceId(H1.m.u5, H1.i.f2304R);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void e(Context context) {
        LayoutInflater.from(context).inflate(this.f14247g, (ViewGroup) this, true);
        try {
            this.f14241a = (PAGView) findViewById(H1.h.f2244d0);
        } catch (Exception unused) {
        }
        this.f14242b = (TextView) findViewById(H1.h.f2240b0);
        this.f14243c = (TextView) findViewById(H1.h.f2238a0);
        TextView textView = (TextView) findViewById(H1.h.f2242c0);
        this.f14255o = textView;
        if (textView != null) {
            if (TextUtils.isEmpty(this.f14252l)) {
                this.f14255o.setVisibility(8);
            } else {
                this.f14255o.setVisibility(0);
                this.f14255o.setText(this.f14252l);
            }
        }
        if (this.f14241a != null) {
            h();
        }
        if (this.f14242b != null) {
            j();
        }
        if (this.f14243c != null) {
            g();
        }
    }

    private void f() {
        TextView textView = this.f14243c;
        if (textView == null || this.f14250j == 0) {
            return;
        }
        textView.setBackground(androidx.core.content.a.e(getContext(), this.f14250j));
    }

    private void g() {
        i(this.f14243c, this.f14249i);
        this.f14243c.setText(this.f14253m);
        this.f14243c.setVisibility(this.f14254n ? 0 : 8);
    }

    private void h() {
        this.f14241a.setPath(this.f14245e);
        this.f14241a.setRepeatCount(this.f14246f);
    }

    private void i(TextView textView, int i5) {
        if (i5 == -1) {
            return;
        }
        androidx.core.widget.i.m(textView, i5);
    }

    private void j() {
        i(this.f14242b, this.f14248h);
        this.f14242b.setText(this.f14251k);
    }

    public ValueAnimator getAnimator() {
        return this.f14244d;
    }

    public TextView getButtonView() {
        return this.f14243c;
    }

    public TextView getHintView() {
        return this.f14242b;
    }

    public TextView getMessageTextView() {
        return this.f14255o;
    }

    public PAGView getPAGView() {
        return this.f14241a;
    }

    public void k() {
        PAGView pAGView = this.f14241a;
        if (pAGView != null) {
            if (pAGView.isPlaying()) {
                this.f14241a.stop();
            }
            this.f14241a.setProgress(0.0d);
            this.f14241a.setVisibility(0);
            this.f14241a.play();
        }
        ValueAnimator valueAnimator = this.f14244d;
        if (valueAnimator != null) {
            if (valueAnimator.isRunning()) {
                this.f14244d.cancel();
            }
            this.f14244d.start();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        f();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        f();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f14257q);
        this.f14256p.clear();
        ValueAnimator valueAnimator = this.f14244d;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.f14244d.cancel();
        }
        PAGView pAGView = this.f14241a;
        if (pAGView != null) {
            pAGView.stop();
        }
    }

    public void setAnimatorDuration(int i5) {
        ValueAnimator valueAnimator = this.f14244d;
        if (valueAnimator != null) {
            valueAnimator.setDuration(i5);
        }
    }

    public void setButtonViewClickListener(View.OnClickListener onClickListener) {
        TextView textView = this.f14243c;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public StepOSPAGEmptyLayout(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f14246f = 1;
        this.f14256p = new ArrayList();
        this.f14257q = new Runnable() { // from class: com.stepos.common.widget.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f14431a.k();
            }
        };
        N1.g.c(context.getApplicationContext());
        d(context, attributeSet);
        e(context);
        c();
        if (isInEditMode()) {
            TextView textView = this.f14242b;
            if (textView != null) {
                textView.setAlpha(1.0f);
            }
            TextView textView2 = this.f14255o;
            if (textView2 != null) {
                textView2.setAlpha(1.0f);
            }
            TextView textView3 = this.f14243c;
            if (textView3 != null) {
                textView3.setAlpha(1.0f);
            }
        }
    }
}
