package com.stepos.familyguard.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.familyguard.R;
import f2.C0711p;

/* loaded from: classes.dex */
public class TimeDisplayView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private TextView f15220a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f15221b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f15222c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f15223d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f15224e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f15225f;

    public TimeDisplayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private TextView a() {
        TextView textView = this.f15221b;
        if (textView != null && textView.getVisibility() == 0) {
            return this.f15221b;
        }
        TextView textView2 = this.f15220a;
        if (textView2 != null && textView2.getVisibility() == 0) {
            return this.f15220a;
        }
        TextView textView3 = this.f15222c;
        if (textView3 == null || textView3.getVisibility() != 0) {
            return null;
        }
        return this.f15222c;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        int baseline;
        TextView textViewA = a();
        if (textViewA != null && (baseline = textViewA.getBaseline()) >= 0) {
            return getPaddingTop() + textViewA.getTop() + baseline;
        }
        return -1;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f15220a = (TextView) findViewById(R.id.digit_1);
        this.f15221b = (TextView) findViewById(R.id.digit_2);
        this.f15222c = (TextView) findViewById(R.id.digit_3);
        this.f15223d = (TextView) findViewById(R.id.digit_1_label);
        this.f15224e = (TextView) findViewById(R.id.digit_2_label);
        this.f15225f = (TextView) findViewById(R.id.digit_3_label);
    }

    public void setTime(long j5) throws Resources.NotFoundException {
        Context context = getContext();
        long jL = C0711p.l(j5);
        int iQ = C0711p.q(jL);
        int iR = C0711p.r(jL);
        int iW = C0711p.w(jL);
        String quantityString = context.getResources().getQuantityString(R.plurals.us_widget_hour, iQ);
        String quantityString2 = context.getResources().getQuantityString(R.plurals.us_widget_minute, iR);
        String quantityString3 = context.getResources().getQuantityString(R.plurals.us_widget_second, iW);
        if (iQ == 0) {
            this.f15220a.setVisibility(8);
            this.f15223d.setVisibility(8);
        } else {
            this.f15220a.setVisibility(0);
            this.f15223d.setVisibility(0);
            this.f15220a.setText(String.valueOf(iQ));
            this.f15223d.setText(quantityString);
        }
        if (iR == 0) {
            this.f15221b.setVisibility(8);
            this.f15224e.setVisibility(8);
        } else {
            this.f15221b.setVisibility(0);
            this.f15224e.setVisibility(0);
            this.f15221b.setText(String.valueOf(iR));
            this.f15224e.setText(quantityString2);
        }
        if (iQ > 0 || iR > 0) {
            this.f15222c.setVisibility(8);
            this.f15225f.setVisibility(8);
        } else {
            this.f15222c.setVisibility(0);
            this.f15225f.setVisibility(0);
            this.f15222c.setText(String.valueOf(iW));
            this.f15225f.setText(quantityString3);
        }
    }

    public TimeDisplayView(Context context, AttributeSet attributeSet, int i5) {
        this(context, attributeSet, i5, 0);
    }

    public TimeDisplayView(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
    }
}
