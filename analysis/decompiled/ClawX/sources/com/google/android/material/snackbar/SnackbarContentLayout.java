package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.stepclaw.R;
import e1.a;
import k4.v;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public TextView f1347a;

    /* renamed from: b, reason: collision with root package name */
    public Button f1348b;

    /* renamed from: c, reason: collision with root package name */
    public int f1349c;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        v.h0(context, R.attr.motionEasingEmphasizedInterpolator, a.f2340b);
    }

    public final boolean a(int i8, int i9, int i10) {
        boolean z;
        if (i8 != getOrientation()) {
            setOrientation(i8);
            z = true;
        } else {
            z = false;
        }
        if (this.f1347a.getPaddingTop() == i9 && this.f1347a.getPaddingBottom() == i10) {
            return z;
        }
        TextView textView = this.f1347a;
        if (textView.isPaddingRelative()) {
            textView.setPaddingRelative(textView.getPaddingStart(), i9, textView.getPaddingEnd(), i10);
            return true;
        }
        textView.setPadding(textView.getPaddingLeft(), i9, textView.getPaddingRight(), i10);
        return true;
    }

    public Button getActionView() {
        return this.f1348b;
    }

    public TextView getMessageView() {
        return this.f1347a;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f1347a = (TextView) findViewById(R.id.snackbar_text);
        this.f1348b = (Button) findViewById(R.id.snackbar_action);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i8, int i9) throws Resources.NotFoundException {
        super.onMeasure(i8, i9);
        if (getOrientation() == 1) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
        Layout layout = this.f1347a.getLayout();
        boolean z = layout != null && layout.getLineCount() > 1;
        if (!z || this.f1349c <= 0 || this.f1348b.getMeasuredWidth() <= this.f1349c) {
            if (!z) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!a(0, dimensionPixelSize, dimensionPixelSize)) {
                return;
            }
        } else if (!a(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            return;
        }
        super.onMeasure(i8, i9);
    }

    public void setMaxInlineActionWidth(int i8) {
        this.f1349c = i8;
    }
}
