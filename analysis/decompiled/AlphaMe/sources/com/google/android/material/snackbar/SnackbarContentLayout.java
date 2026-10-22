package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.stepos.alphame.R;
import com.stepos.statsrpk.c;
import e.EnumC0546d;
import n1.AbstractC0775a;

@RestrictTo({EnumC0546d.f12493b})
/* loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public TextView f10910a;

    /* renamed from: b, reason: collision with root package name */
    public Button f10911b;

    /* renamed from: c, reason: collision with root package name */
    public int f10912c;

    public SnackbarContentLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        c.M(context, R.attr.motionEasingEmphasizedInterpolator, AbstractC0775a.f13651b);
    }

    public final boolean a(int i4, int i5, int i6) {
        boolean z4;
        if (i4 != getOrientation()) {
            setOrientation(i4);
            z4 = true;
        } else {
            z4 = false;
        }
        if (this.f10910a.getPaddingTop() == i5 && this.f10910a.getPaddingBottom() == i6) {
            return z4;
        }
        TextView textView = this.f10910a;
        if (textView.isPaddingRelative()) {
            textView.setPaddingRelative(textView.getPaddingStart(), i5, textView.getPaddingEnd(), i6);
            return true;
        }
        textView.setPadding(textView.getPaddingLeft(), i5, textView.getPaddingRight(), i6);
        return true;
    }

    public Button getActionView() {
        return this.f10911b;
    }

    public TextView getMessageView() {
        return this.f10910a;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f10910a = (TextView) findViewById(R.id.snackbar_text);
        this.f10911b = (Button) findViewById(R.id.snackbar_action);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i4, int i5) throws Resources.NotFoundException {
        super.onMeasure(i4, i5);
        if (getOrientation() == 1) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
        Layout layout = this.f10910a.getLayout();
        boolean z4 = layout != null && layout.getLineCount() > 1;
        if (!z4 || this.f10912c <= 0 || this.f10911b.getMeasuredWidth() <= this.f10912c) {
            if (!z4) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!a(0, dimensionPixelSize, dimensionPixelSize)) {
                return;
            }
        } else if (!a(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            return;
        }
        super.onMeasure(i4, i5);
    }

    public void setMaxInlineActionWidth(int i4) {
        this.f10912c = i4;
    }
}
