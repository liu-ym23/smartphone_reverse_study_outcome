package com.google.android.material.snackbar;

import T2.h;
import a3.InterfaceC1226a;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;

/* loaded from: classes2.dex */
public class SnackbarContentLayout extends LinearLayout implements InterfaceC1226a {

    /* renamed from: a, reason: collision with root package name */
    public TextView f21362a;

    /* renamed from: b, reason: collision with root package name */
    public Button f21363b;

    /* renamed from: c, reason: collision with root package name */
    public final TimeInterpolator f21364c;

    /* renamed from: d, reason: collision with root package name */
    public int f21365d;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21364c = h.g(context, R$attr.motionEasingEmphasizedInterpolator, E2.a.f2340b);
    }

    public static void c(View view, int i10, int i11) {
        if (view.isPaddingRelative()) {
            view.setPaddingRelative(view.getPaddingStart(), i10, view.getPaddingEnd(), i11);
        } else {
            view.setPadding(view.getPaddingLeft(), i10, view.getPaddingRight(), i11);
        }
    }

    @Override // a3.InterfaceC1226a
    public void a(int i10, int i11) {
        this.f21362a.setAlpha(0.0f);
        long j10 = i11;
        long j11 = i10;
        this.f21362a.animate().alpha(1.0f).setDuration(j10).setInterpolator(this.f21364c).setStartDelay(j11).start();
        if (this.f21363b.getVisibility() == 0) {
            this.f21363b.setAlpha(0.0f);
            this.f21363b.animate().alpha(1.0f).setDuration(j10).setInterpolator(this.f21364c).setStartDelay(j11).start();
        }
    }

    @Override // a3.InterfaceC1226a
    public void b(int i10, int i11) {
        this.f21362a.setAlpha(1.0f);
        long j10 = i11;
        long j11 = i10;
        this.f21362a.animate().alpha(0.0f).setDuration(j10).setInterpolator(this.f21364c).setStartDelay(j11).start();
        if (this.f21363b.getVisibility() == 0) {
            this.f21363b.setAlpha(1.0f);
            this.f21363b.animate().alpha(0.0f).setDuration(j10).setInterpolator(this.f21364c).setStartDelay(j11).start();
        }
    }

    public final boolean d(int i10, int i11, int i12) {
        boolean z10;
        if (i10 != getOrientation()) {
            setOrientation(i10);
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f21362a.getPaddingTop() == i11 && this.f21362a.getPaddingBottom() == i12) {
            return z10;
        }
        c(this.f21362a, i11, i12);
        return true;
    }

    public Button getActionView() {
        return this.f21363b;
    }

    public TextView getMessageView() {
        return this.f21362a;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f21362a = (TextView) findViewById(R$id.snackbar_text);
        this.f21363b = (Button) findViewById(R$id.snackbar_action);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) throws Resources.NotFoundException {
        super.onMeasure(i10, i11);
        if (getOrientation() == 1) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R$dimen.design_snackbar_padding_vertical);
        Layout layout = this.f21362a.getLayout();
        boolean z10 = layout != null && layout.getLineCount() > 1;
        if (!z10 || this.f21365d <= 0 || this.f21363b.getMeasuredWidth() <= this.f21365d) {
            if (!z10) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!d(0, dimensionPixelSize, dimensionPixelSize)) {
                return;
            }
        } else if (!d(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            return;
        }
        super.onMeasure(i10, i11);
    }

    public void setMaxInlineActionWidth(int i10) {
        this.f21365d = i10;
    }
}
