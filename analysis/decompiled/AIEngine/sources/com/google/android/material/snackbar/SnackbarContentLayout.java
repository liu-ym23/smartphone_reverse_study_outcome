package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.aiengine.R;
import l4.a;
import u4.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public TextView f5179a;

    /* renamed from: b, reason: collision with root package name */
    public Button f5180b;

    /* renamed from: c, reason: collision with root package name */
    public int f5181c;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j.d(context, R.attr.motionEasingEmphasizedInterpolator, a.f10221b);
    }

    public final boolean a(int i10, int i11, int i12) {
        boolean z;
        if (i10 != getOrientation()) {
            setOrientation(i10);
            z = true;
        } else {
            z = false;
        }
        if (this.f5179a.getPaddingTop() == i11 && this.f5179a.getPaddingBottom() == i12) {
            return z;
        }
        TextView textView = this.f5179a;
        if (textView.isPaddingRelative()) {
            textView.setPaddingRelative(textView.getPaddingStart(), i11, textView.getPaddingEnd(), i12);
            return true;
        }
        textView.setPadding(textView.getPaddingLeft(), i11, textView.getPaddingRight(), i12);
        return true;
    }

    public Button getActionView() {
        return this.f5180b;
    }

    public TextView getMessageView() {
        return this.f5179a;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f5179a = (TextView) findViewById(R.id.snackbar_text);
        this.f5180b = (Button) findViewById(R.id.snackbar_action);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i10, int i11) throws Resources.NotFoundException {
        super.onMeasure(i10, i11);
        if (getOrientation() == 1) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
        Layout layout = this.f5179a.getLayout();
        boolean z = layout != null && layout.getLineCount() > 1;
        if (!z || this.f5181c <= 0 || this.f5180b.getMeasuredWidth() <= this.f5181c) {
            if (!z) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!a(0, dimensionPixelSize, dimensionPixelSize)) {
                return;
            }
        } else if (!a(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            return;
        }
        super.onMeasure(i10, i11);
    }

    public void setMaxInlineActionWidth(int i10) {
        this.f5181c = i10;
    }
}
