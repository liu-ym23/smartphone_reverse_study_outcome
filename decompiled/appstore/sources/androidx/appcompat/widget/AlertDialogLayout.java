package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$id;
import androidx.core.view.ViewCompat;
import com.google.common.primitives.Ints;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(@Nullable Context r10) {
        super(r10);
    }

    public static int d(View r10) {
        int r11 = ViewCompat.B(r10);
        if (r11 <= 0) goto L6;
        return r11;
    L6:
        if ((r10 instanceof ViewGroup) == false) goto L11;
        ViewGroup r12 = (ViewGroup) r10;
        if (r12.getChildCount() != 1) goto L11;
        return d(r12.getChildAt(0));
    L11:
        return 0;
    }

    public final void b(int r11, int r12) {
        int r10 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), Ints.MAX_POWER_OF_TWO);
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L10;
        View r14 = getChildAt(r13);
        if (r14.getVisibility() == 8) goto L9;
        LinearLayoutCompat.LayoutParams r15 = (LinearLayoutCompat.LayoutParams) r14.getLayoutParams();
        if (((LinearLayout.LayoutParams) r15).width != (-1)) goto L9;
        int r16 = ((LinearLayout.LayoutParams) r15).height;
        ((LinearLayout.LayoutParams) r15).height = r14.getMeasuredHeight();
        measureChildWithMargins(r14, r10, 0, r12, 0);
        ((LinearLayout.LayoutParams) r15).height = r16;
    L9:
        r13 = r13 + 1;
        goto L3
    }

    public final void c(View r10, int r11, int r12, int r13, int r14) {
        r10.layout(r11, r12, r13 + r11, r14 + r12);
    }

    public final boolean e(int r17, int r18) {
        int r10 = getChildCount();
        View r11 = null;
        View r12 = null;
        View r13 = null;
        int r14 = 0;
    L4:
        if (r14 >= r10) goto L24;
        View r15 = getChildAt(r14);
        if (r15.getVisibility() == 8) goto L23;
        int r16 = r15.getId();
        if (r16 != R$id.topPanel) goto L12;
        r11 = r15;
        goto L23
    L12:
        if (r16 != R$id.buttonPanel) goto L15;
        r12 = r15;
        goto L23
    L15:
        if (r16 != R$id.contentPanel) goto L17;
    L20:
        if (r13 != null) goto L21;
        r13 = r15;
        goto L23
    L21:
        return false;
    L17:
        if (r16 == R$id.customPanel) goto L20;
        return false;
    L23:
        r14 = r14 + 1;
        goto L4
    L24:
        int r19 = View.MeasureSpec.getMode(r18);
        int r110 = View.MeasureSpec.getSize(r18);
        int r111 = View.MeasureSpec.getMode(r17);
        int r112 = getPaddingTop() + getPaddingBottom();
        if (r11 == null) goto L27;
        r11.measure(r17, 0);
        r112 = r112 + r11.getMeasuredHeight();
        int r20 = View.combineMeasuredStates(0, r11.getMeasuredState());
    L28:
        if (r12 == null) goto L30;
        r12.measure(r17, 0);
        int r113 = d(r12);
        int r114 = r12.getMeasuredHeight() - r113;
        r112 = r112 + r113;
        r20 = View.combineMeasuredStates(r20, r12.getMeasuredState());
    L31:
        if (r13 == null) goto L36;
        if (r19 != 0) goto L34;
        int r115 = 0;
    L35:
        r13.measure(r17, r115);
        int r116 = r13.getMeasuredHeight();
        r112 = r112 + r116;
        r20 = View.combineMeasuredStates(r20, r13.getMeasuredState());
    L37:
        int r117 = r110 - r112;
        if (r12 == null) goto L43;
        int r118 = r112 - r113;
        int r119 = Math.min(r117, r114);
        if (r119 <= 0) goto L42;
        r117 = r117 - r119;
        r113 = r113 + r119;
    L42:
        r12.measure(r17, View.MeasureSpec.makeMeasureSpec(r113, Ints.MAX_POWER_OF_TWO));
        r112 = r118 + r12.getMeasuredHeight();
        r20 = View.combineMeasuredStates(r20, r12.getMeasuredState());
    L43:
        if (r13 == null) goto L46;
        if (r117 <= 0) goto L46;
        r13.measure(r17, View.MeasureSpec.makeMeasureSpec(r116 + r117, r19));
        r112 = (r112 - r116) + r13.getMeasuredHeight();
        r20 = View.combineMeasuredStates(r20, r13.getMeasuredState());
    L46:
        int r21 = 0;
        int r22 = 0;
    L47:
        if (r21 >= r10) goto L52;
        View r23 = getChildAt(r21);
        if (r23.getVisibility() == 8) goto L51;
        r22 = Math.max(r22, r23.getMeasuredWidth());
    L51:
        r21 = r21 + 1;
        goto L47
    L52:
        setMeasuredDimension(View.resolveSizeAndState(r22 + (getPaddingLeft() + getPaddingRight()), r17, r20), View.resolveSizeAndState(r112, r18, 0));
        if (r111 == 1073741824) goto L67;
        b(r10, r18);
        return true;
    L67:
        return true;
    L34:
        r115 = View.MeasureSpec.makeMeasureSpec(Math.max(0, r110 - r112), r19);
        goto L35
    L36:
        r116 = 0;
        goto L37
    L30:
        r113 = 0;
        r114 = 0;
        goto L31
    L27:
        r20 = 0;
        goto L28
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        int r10 = getPaddingLeft();
        int r11 = r21 - r19;
        int r12 = r11 - getPaddingRight();
        int r13 = (r11 - r10) - getPaddingRight();
        int r14 = getMeasuredHeight();
        int r15 = getChildCount();
        int r16 = getGravity();
        int r17 = r16 & 112;
        int r110 = r16 & 8388615;
        if (r17 != 16) goto L5;
        int r23 = getPaddingTop() + (((r22 - r20) - r14) / 2);
    L9:
        Drawable r24 = getDividerDrawable();
        if (r24 != null) goto L12;
        int r111 = 0;
    L13:
        int r112 = 0;
    L14:
        if (r112 >= r15) goto L35;
        View r25 = getChildAt(r112);
        if (r25 == null) goto L34;
        if (r25.getVisibility() == 8) goto L34;
        int r26 = r25.getMeasuredWidth();
        int r113 = r25.getMeasuredHeight();
        LinearLayoutCompat.LayoutParams r114 = (LinearLayoutCompat.LayoutParams) r25.getLayoutParams();
        int r27 = ((LinearLayout.LayoutParams) r114).gravity;
        if (r27 >= 0) goto L22;
        r27 = r110;
    L22:
        int r28 = androidx.core.view.c.b(r27, ViewCompat.A(this)) & 7;
        if (r28 != 1) goto L25;
        int r29 = (((r13 - r26) / 2) + r10) + ((LinearLayout.LayoutParams) r114).leftMargin;
        int r30 = ((LinearLayout.LayoutParams) r114).rightMargin;
    L28:
        int r31 = r29 - r30;
    L31:
        if (hasDividerBeforeChildAt(r112) == false) goto L33;
        r23 = r23 + r111;
    L33:
        int r115 = r23 + ((LinearLayout.LayoutParams) r114).topMargin;
        c(r25, r31, r115, r26, r113);
        r23 = r115 + (r113 + ((LinearLayout.LayoutParams) r114).bottomMargin);
        goto L34
    L25:
        if (r28 == 5) goto L27;
        r31 = ((LinearLayout.LayoutParams) r114).leftMargin + r10;
        goto L31
    L27:
        r29 = r12 - r26;
        r30 = ((LinearLayout.LayoutParams) r114).rightMargin;
    L34:
        r112 = r112 + 1;
        goto L14
    L35:
        return;
    L12:
        r111 = r24.getIntrinsicHeight();
        goto L13
    L5:
        if (r17 == 80) goto L7;
        r23 = getPaddingTop();
        goto L9
    L7:
        r23 = ((getPaddingTop() + r22) - r20) - r14;
        goto L9
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int r10, int r11) {
        if (e(r10, r11) == true) goto L6;
        super.onMeasure(r10, r11);
        return;
    }

    public AlertDialogLayout(@Nullable Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
    }
}
