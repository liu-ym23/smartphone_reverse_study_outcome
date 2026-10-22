package com.obric.oui.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.e;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$styleable;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes4.dex */
public class FlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12777d;

    public FlowLayout(@NonNull Context r10) {
        this(r10, null);
    }

    public static int a(int r10, int r11, int r12) {
        if (r11 == Integer.MIN_VALUE) goto L9;
        if (r11 == 1073741824) goto L7;
        return r12;
    L7:
        return r10;
    L9:
        return Math.min(r12, r10);
    }

    public boolean b() {
        return this.f12776c;
    }

    public final void c(Context r10, AttributeSet r11) {
        TypedArray r12 = r10.getTheme().obtainStyledAttributes(r11, R$styleable.OChipGroup, 0, 0);
        this.f12774a = r12.getDimensionPixelSize(R$styleable.OChipGroup_oui_line_space, 0);
        this.f12775b = r12.getDimensionPixelSize(R$styleable.OChipGroup_oui_item_space, 0);
        r12.recycle();
    }

    public int getItemSpacing() {
        return this.f12775b;
    }

    public int getLineSpacing() {
        return this.f12774a;
    }

    public int getRowCount() {
        return this.f12777d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        if (getChildCount() != 0) goto L6;
        this.f12777d = 0;
        return;
    L6:
        this.f12777d = 1;
        if (ViewCompat.A(this) != 1) goto L9;
        boolean r15 = true;
    L10:
        if (r15 == false) goto L12;
        int r16 = getPaddingRight();
    L13:
        if (r15 == false) goto L15;
        int r17 = getPaddingLeft();
    L16:
        int r18 = getPaddingTop();
        int r19 = (r13 - r11) - r17;
        int r20 = 0;
        int r21 = r16;
        int r110 = r18;
    L18:
        if (r20 >= getChildCount()) goto L36;
        View r22 = getChildAt(r20);
        if (r22.getVisibility() != 8) goto L22;
        r22.setTag(R$id.row_index_key, -1);
    L35:
        r20 = r20 + 1;
        goto L18
    L22:
        ViewGroup.LayoutParams r23 = r22.getLayoutParams();
        if ((r23 instanceof ViewGroup.MarginLayoutParams) == false) goto L25;
        ViewGroup.MarginLayoutParams r24 = (ViewGroup.MarginLayoutParams) r23;
        int r25 = e.b(r24);
        int r26 = e.a(r24);
    L26:
        int r27 = (r21 + r25) + r22.getMeasuredWidth();
        if (this.f12776c == true) goto L30;
        if (r27 <= r19) goto L30;
        r110 = this.f12774a + r18;
        this.f12777d++;
        r21 = r16;
    L30:
        r22.setTag(R$id.row_index_key, Integer.valueOf(this.f12777d - 1));
        int r28 = r21 + r25;
        int r29 = r22.getMeasuredWidth() + r28;
        int r30 = r22.getMeasuredHeight() + r110;
        if (r15 == false) goto L33;
        r22.layout(r19 - r29, r110, (r19 - r21) - r25, r30);
    L34:
        r21 = r21 + (((r25 + r26) + r22.getMeasuredWidth()) + this.f12775b);
        r18 = r30;
        goto L35
    L33:
        r22.layout(r28, r110, r29, r30);
        goto L34
    L25:
        r26 = 0;
        r25 = 0;
        goto L26
    L36:
        return;
    L15:
        r17 = getPaddingRight();
        goto L16
    L12:
        r16 = getPaddingLeft();
        goto L13
    L9:
        r15 = false;
        goto L10
    }

    @Override // android.view.View
    public void onMeasure(int r20, int r21) {
        int r10 = View.MeasureSpec.getSize(r20);
        int r11 = View.MeasureSpec.getMode(r20);
        int r12 = View.MeasureSpec.getSize(r21);
        int r13 = View.MeasureSpec.getMode(r21);
        if (r11 != Integer.MIN_VALUE) goto L5;
    L8:
        int r14 = r10;
    L9:
        int r15 = getPaddingLeft();
        int r16 = getPaddingTop();
        int r17 = r14 - getPaddingRight();
        int r18 = r16;
        int r19 = 0;
        int r110 = 0;
    L11:
        if (r19 >= getChildCount()) goto L33;
        View r111 = getChildAt(r19);
        if (r111.getVisibility() == 8) goto L32;
        measureChild(r111, r20, r21);
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
        if ((r112 instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r112;
        int r22 = r113.leftMargin;
        int r114 = r113.rightMargin;
    L19:
        int r115 = r15;
        if (((r15 + r22) + r111.getMeasuredWidth()) > r17) goto L22;
    L24:
        int r23 = r115;
    L25:
        int r24 = (r23 + r22) + r111.getMeasuredWidth();
        int r116 = r18 + r111.getMeasuredHeight();
        if (r24 <= r110) goto L28;
        r110 = r24;
    L28:
        r15 = r23 + (((r22 + r114) + r111.getMeasuredWidth()) + this.f12775b);
        if (r19 != (getChildCount() - 1)) goto L31;
        r110 = r110 + r114;
    L31:
        r16 = r116;
        goto L32
    L22:
        if (b() == true) goto L24;
        r23 = getPaddingLeft();
        r18 = this.f12774a + r16;
        goto L25
    L18:
        r22 = 0;
        r114 = 0;
    L32:
        r19 = r19 + 1;
        goto L11
    L33:
        setMeasuredDimension(a(r10, r11, r110 + getPaddingRight()), a(r12, r13, r16 + getPaddingBottom()));
        return;
    L5:
        if (r11 == 1073741824) goto L8;
        r14 = Channel.UNLIMITED;
        goto L9
    }

    public void setItemSpacing(int r10) {
        this.f12775b = r10;
    }

    public void setLineSpacing(int r10) {
        this.f12774a = r10;
    }

    public void setSingleLine(boolean r10) {
        this.f12776c = r10;
    }

    public FlowLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public FlowLayout(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f12776c = false;
        c(r10, r11);
    }
}
