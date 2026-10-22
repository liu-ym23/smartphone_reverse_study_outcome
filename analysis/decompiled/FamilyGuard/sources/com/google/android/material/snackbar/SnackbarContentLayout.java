package com.google.android.material.snackbar;

import a1.C0409b;
import a1.C0411d;
import a1.C0413f;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import b1.C0553a;
import o1.e;

/* loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout implements a {

    /* renamed from: a, reason: collision with root package name */
    private TextView f13197a;

    /* renamed from: b, reason: collision with root package name */
    private Button f13198b;

    /* renamed from: c, reason: collision with root package name */
    private final TimeInterpolator f13199c;

    /* renamed from: d, reason: collision with root package name */
    private int f13200d;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13199c = e.g(context, C0409b.f6696F, C0553a.f11784b);
    }

    private static void c(View view, int i5, int i6) {
        if (view.isPaddingRelative()) {
            view.setPaddingRelative(view.getPaddingStart(), i5, view.getPaddingEnd(), i6);
        } else {
            view.setPadding(view.getPaddingLeft(), i5, view.getPaddingRight(), i6);
        }
    }

    private boolean d(int i5, int i6, int i7) {
        boolean z5;
        if (i5 != getOrientation()) {
            setOrientation(i5);
            z5 = true;
        } else {
            z5 = false;
        }
        if (this.f13197a.getPaddingTop() == i6 && this.f13197a.getPaddingBottom() == i7) {
            return z5;
        }
        c(this.f13197a, i6, i7);
        return true;
    }

    @Override // com.google.android.material.snackbar.a
    public void a(int i5, int i6) {
        this.f13197a.setAlpha(0.0f);
        long j5 = i6;
        long j6 = i5;
        this.f13197a.animate().alpha(1.0f).setDuration(j5).setInterpolator(this.f13199c).setStartDelay(j6).start();
        if (this.f13198b.getVisibility() == 0) {
            this.f13198b.setAlpha(0.0f);
            this.f13198b.animate().alpha(1.0f).setDuration(j5).setInterpolator(this.f13199c).setStartDelay(j6).start();
        }
    }

    @Override // com.google.android.material.snackbar.a
    public void b(int i5, int i6) {
        this.f13197a.setAlpha(1.0f);
        long j5 = i6;
        long j6 = i5;
        this.f13197a.animate().alpha(0.0f).setDuration(j5).setInterpolator(this.f13199c).setStartDelay(j6).start();
        if (this.f13198b.getVisibility() == 0) {
            this.f13198b.setAlpha(1.0f);
            this.f13198b.animate().alpha(0.0f).setDuration(j5).setInterpolator(this.f13199c).setStartDelay(j6).start();
        }
    }

    public Button getActionView() {
        return this.f13198b;
    }

    public TextView getMessageView() {
        return this.f13197a;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f13197a = (TextView) findViewById(C0413f.f6827J);
        this.f13198b = (Button) findViewById(C0413f.f6826I);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i5, int i6) throws Resources.NotFoundException {
        super.onMeasure(i5, i6);
        if (getOrientation() == 1) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(C0411d.f6784g);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(C0411d.f6782f);
        Layout layout = this.f13197a.getLayout();
        boolean z5 = layout != null && layout.getLineCount() > 1;
        if (!z5 || this.f13200d <= 0 || this.f13198b.getMeasuredWidth() <= this.f13200d) {
            if (!z5) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!d(0, dimensionPixelSize, dimensionPixelSize)) {
                return;
            }
        } else if (!d(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            return;
        }
        super.onMeasure(i5, i6);
    }

    public void setMaxInlineActionWidth(int i5) {
        this.f13200d = i5;
    }
}
