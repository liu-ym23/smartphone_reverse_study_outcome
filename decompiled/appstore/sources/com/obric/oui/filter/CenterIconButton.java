package com.obric.oui.filter;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import com.obric.common.oui.R$styleable;
import java.util.ArrayList;
import java.util.StringTokenizer;
import o.a;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
public class CenterIconButton extends AppCompatButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Rect f14520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14523d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14524e;

    public CenterIconButton(Context r10) {
        super(r10);
        this.f14521b = 0;
        c(r10, null);
    }

    private void c(Context r10, AttributeSet r11) {
        if (r11 == null) goto L4;
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.OCenterIconButton);
        this.f14521b = r12.getColor(R$styleable.OCenterIconButton_oui_drawableTint, 0);
        this.f14524e = r12.getDimensionPixelSize(R$styleable.OCenterIconButton_oui_drawableSize, f.i(12));
        setCompoundDrawablePadding((int) r12.getDimension(R$styleable.OCenterIconButton_android_drawablePadding, f.i(4)));
        e();
        r12.recycle();
    L4:
        this.f14522c = getPaddingLeft();
        this.f14523d = getPaddingRight();
    }

    private int getTextWidth() {
        if (this.f14520a != null) goto L5;
        this.f14520a = new Rect();
    L5:
        TextPaint r10 = getPaint();
        String r11 = a();
        Log.d("CenterIconButton", "text:" + r11);
        r10.getTextBounds(r11, 0, r11.length(), this.f14520a);
        Log.d("CenterIconButton", "textHeight" + this.f14520a.height());
        return this.f14520a.width();
    }

    public final String a() {
        String r10 = getText().toString();
        if (r10.isEmpty() == false) goto L6;
        return "";
    L6:
        ArrayList r11 = new ArrayList();
        int r12 = 0;
        StringTokenizer r13 = new StringTokenizer(r10, "\n", false);
    L8:
        if (r13.hasMoreTokens() == false) goto L11;
        r11.add(r13.nextToken());
        goto L8
    L11:
        if (r11.size() == 1) goto L13;
        String r14 = (String) r11.get(0);
    L19:
        if (r12 >= (r11.size() - 1)) goto L25;
        int r15 = r12 + 1;
        if (((String) r11.get(r15)).length() <= ((String) r11.get(r12)).length()) goto L23;
        r14 = (String) r11.get(r15);
    L23:
        r12 = r15;
        goto L19
    L25:
        if (isAllCaps() == true) goto L27;
        return r14;
    L27:
        return r14.toUpperCase();
    L13:
        if (isAllCaps() == false) goto L16;
        return ((String) r11.get(0)).toUpperCase();
    L16:
        return (String) r11.get(0);
    }

    public final Drawable b(Drawable r10) {
        Drawable r11 = a.l(r10).mutate();
        a.h(r11, this.f14521b);
        return r11;
    }

    public final Drawable d(Drawable r10) {
        Rect r11 = r10.getBounds();
        int r12 = this.f14524e;
        r11.set(0, 0, r12, r12);
        return r10;
    }

    public void e() {
        if (this.f14521b == 0) goto L5;
    L6:
        Drawable[] r10 = getCompoundDrawables();
        if (r10.length == 4) goto L9;
        return;
    L9:
        Drawable[] r11 = new Drawable[4];
        int r12 = 0;
    L10:
        if (r12 >= 4) goto L22;
        Drawable r13 = r10[r12];
        if (r13 == null) goto L20;
        if (this.f14521b == 0) goto L17;
        r13 = b(r13);
    L17:
        if (this.f14524e <= 0) goto L19;
        r13 = d(r13);
    L19:
        r11[r12] = r13;
    L20:
        r12 = r12 + 1;
        goto L10
    L22:
        if (this.f14524e <= 0) goto L24;
        setCompoundDrawables(r11[0], r11[1], r11[2], r11[3]);
        return;
    L24:
        setCompoundDrawablesWithIntrinsicBounds(r11[0], r11[1], r11[2], r11[3]);
        return;
    L5:
        if (this.f14524e != (-1)) goto L6;
    }

    public final void f() {
        g(getMeasuredWidth());
    }

    public final void g(int r10) {
        if (r10 != 0) goto L4;
        return;
    L4:
        Drawable[] r11 = getCompoundDrawables();
        if (r11.length == 4) goto L7;
        return;
    L7:
        Drawable r12 = r11[0];
        Drawable r13 = r11[2];
        if (r12 != null) goto L11;
        if (r13 != null) goto L11;
        return;
    L11:
        int r14 = getTextWidth();
        int r15 = Math.max(getCompoundDrawablePadding(), 1);
        if (r12 != null) goto L14;
        int r16 = 0;
    L15:
        if (r13 != null) goto L17;
        int r17 = 0;
    L18:
        if (r12 == null) goto L21;
        if (r13 == null) goto L21;
        int r18 = ((((r10 - r16) - r17) - r14) - (r15 * 4)) / 2;
    L24:
        Log.d("CenterIconButton", "paddingSize:" + r18);
        Log.d("CenterIconButton", "leftPadding:" + this.f14522c);
        Log.d("CenterIconButton", "rightPadding:" + this.f14523d);
        setIncludeFontPadding(false);
        Log.d("CenterIconButton", "paddingLeft:" + Math.max(this.f14522c, r18));
        Log.d("CenterIconButton", "paddingTop:" + getPaddingTop());
        Log.d("CenterIconButton", "paddingRight:" + Math.max(r18, this.f14523d));
        Log.d("CenterIconButton", "paddingBottom:" + getPaddingBottom());
        super.setPadding(Math.max(this.f14522c, r18), getPaddingTop(), Math.max(r18, this.f14523d), getPaddingBottom());
        return;
    L21:
        if (r12 == null) goto L23;
        r18 = (((r10 - r16) - r15) - r14) / 2;
        goto L24
    L23:
        r18 = (((r10 - r17) - r15) - r14) / 2;
        goto L24
    L17:
        r17 = r13.getBounds().width();
        goto L18
    L14:
        r16 = r12.getBounds().width();
        goto L15
    }

    @Override // android.widget.TextView
    public boolean isAllCaps() {
        TransformationMethod r10 = getTransformationMethod();
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.getClass().getSimpleName().equals("AllCapsTransformationMethod");
    }

    @Override // android.view.View
    public void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        g(r10);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable r10, Drawable r11, Drawable r12, Drawable r13) {
        super.setCompoundDrawables(r10, r11, r12, r13);
        f();
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable r10, Drawable r11, Drawable r12, Drawable r13) {
        super.setCompoundDrawablesWithIntrinsicBounds(r10, r11, r12, r13);
        f();
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int r10, int r11, int r12, int r13) {
        super.setPadding(r10, r11, r12, r13);
        this.f14522c = r10;
        this.f14523d = r12;
        f();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence r10, TextView.BufferType r11) {
        super.setText(r10, r11);
        f();
    }

    public CenterIconButton(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f14521b = 0;
        c(r10, r11);
    }

    public CenterIconButton(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f14521b = 0;
        c(r10, r11);
    }
}
