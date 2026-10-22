package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.ttnet.org.chromium.net.PrivateKeyType;

/* JADX INFO: loaded from: classes4.dex */
public class Placeholder extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f14151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14152c;

    public Placeholder(Context r10) {
        super(r10);
        this.f14150a = -1;
        this.f14151b = null;
        this.f14152c = 4;
        a(null);
    }

    public final void a(AttributeSet r10) {
        super.setVisibility(this.f14152c);
        this.f14150a = -1;
        if (r10 == null) goto L19;
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R$styleable.ConstraintLayout_placeholder);
        int r12 = r11.getIndexCount();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L13;
        int r14 = r11.getIndex(r13);
        if (r14 != R$styleable.ConstraintLayout_placeholder_content) goto L10;
        this.f14150a = r11.getResourceId(r14, this.f14150a);
    L12:
        r13 = r13 + 1;
        goto L5
    L10:
        if (r14 != R$styleable.ConstraintLayout_placeholder_placeholder_emptyVisibility) goto L12;
        this.f14152c = r11.getInt(r14, this.f14152c);
        goto L12
    L13:
        r11.recycle();
        return;
    }

    public void b(ConstraintLayout r10) {
        if (this.f14151b != null) goto L5;
        return;
    L5:
        ConstraintLayout.LayoutParams r11 = (ConstraintLayout.LayoutParams) getLayoutParams();
        ConstraintLayout.LayoutParams r12 = (ConstraintLayout.LayoutParams) this.f14151b.getLayoutParams();
        r12.f14129v0.l1(0);
        ConstraintWidget.DimensionBehaviour r13 = r11.f14129v0.z();
        ConstraintWidget.DimensionBehaviour r14 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r13 == r14) goto L9;
        r11.f14129v0.m1(r12.f14129v0.V());
    L9:
        if (r11.f14129v0.S() == r14) goto L11;
        r11.f14129v0.N0(r12.f14129v0.w());
    L11:
        r12.f14129v0.l1(8);
    }

    public void c(ConstraintLayout r10) {
        if (this.f14150a == (-1)) goto L5;
    L7:
        View r11 = r10.findViewById(this.f14150a);
        this.f14151b = r11;
        if (r11 == null) goto L11;
        ((ConstraintLayout.LayoutParams) r11.getLayoutParams()).f14105j0 = true;
        this.f14151b.setVisibility(0);
        setVisibility(0);
        return;
    L11:
        return;
    L5:
        if (isInEditMode() == true) goto L7;
        setVisibility(this.f14152c);
        goto L7
    }

    public View getContent() {
        return this.f14151b;
    }

    public int getEmptyVisibility() {
        return this.f14152c;
    }

    @Override // android.view.View
    public void onDraw(Canvas r10) {
        if (isInEditMode() == false) goto L6;
        r10.drawRGB(223, 223, 223);
        Paint r11 = new Paint();
        r11.setARGB(PrivateKeyType.INVALID, 210, 210, 210);
        r11.setTextAlign(Paint.Align.CENTER);
        r11.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        Rect r12 = new Rect();
        r10.getClipBounds(r12);
        r11.setTextSize(r12.height());
        int r13 = r12.height();
        int r14 = r12.width();
        r11.setTextAlign(Paint.Align.LEFT);
        r11.getTextBounds("?", 0, 1, r12);
        r10.drawText("?", ((r14 / 2.0f) - (r12.width() / 2.0f)) - r12.left, ((r13 / 2.0f) + (r12.height() / 2.0f)) - r12.bottom, r11);
        return;
    }

    public void setContentId(int r10) {
        if (this.f14150a != r10) goto L5;
        return;
    L5:
        View r11 = this.f14151b;
        if (r11 == null) goto L8;
        r11.setVisibility(0);
        ((ConstraintLayout.LayoutParams) this.f14151b.getLayoutParams()).f14105j0 = false;
        this.f14151b = null;
    L8:
        this.f14150a = r10;
        if (r10 == (-1)) goto L14;
        View r12 = ((View) getParent()).findViewById(r10);
        if (r12 == null) goto L15;
        r12.setVisibility(8);
        return;
    L15:
        return;
    }

    public void setEmptyVisibility(int r10) {
        this.f14152c = r10;
    }

    public Placeholder(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f14150a = -1;
        this.f14151b = null;
        this.f14152c = 4;
        a(r11);
    }

    public Placeholder(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f14150a = -1;
        this.f14151b = null;
        this.f14152c = 4;
        a(r11);
    }
}
