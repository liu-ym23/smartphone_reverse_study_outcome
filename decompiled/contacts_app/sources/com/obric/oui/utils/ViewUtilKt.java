package com.obric.oui.utils;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.MarginLayoutParamsCompat;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: ViewUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u0002¢\u0006\u0002\u0010\u0005\u001a\u0012\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004\u001a\u0012\u0010\t\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004\u001a\u0012\u0010\u000b\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004\u001a\u001a\u0010\r\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004\u001a\u0012\u0010\u000f\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004¨\u0006\u0010"}, d2 = {"isDarkMode", "", "Landroid/view/View;", "parseBgColor", "", "(Landroid/view/View;)Ljava/lang/Integer;", "setHeight", "", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "setHorizontalMargin", "margin", "setMarginBottom", "marginBottom", "setSize", MaterialConfigFormatNames.WIDTH, "setWidth", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ViewUtilKt {
    public static final void setWidth(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.getLayoutParams().width = r2;
        r1.requestLayout();
    }

    public static final void setHeight(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.getLayoutParams().height = r2;
        r1.requestLayout();
    }

    public static final void setSize(View r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        r0.width = r2;
        r0.height = r3;
        r1.requestLayout();
    }

    public static final void setMarginBottom(View r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        ViewGroup.LayoutParams r0 = r6.getLayoutParams();
        ViewGroup.LayoutParams r2 = null;
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L6:
        if (r1 == null) goto L25;
        ViewGroup.LayoutParams r3 = r6.getLayoutParams();
        int r4 = 0;
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        int r5 = MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) r3);
    L12:
        ViewGroup.LayoutParams r8 = r6.getLayoutParams();
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == false) goto L16;
        r2 = r8;
    L16:
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r2;
        if (r9 == null) goto L19;
        int r10 = r9.topMargin;
    L20:
        ViewGroup.LayoutParams r11 = r6.getLayoutParams();
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == false) goto L23;
        r4 = MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) r11);
    L23:
        r1.setMargins(r5, r10, r4, r7);
        r6.requestLayout();
        return;
    L19:
        r10 = 0;
        goto L20
    L11:
        r5 = 0;
        goto L12
    L25:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static final void setHorizontalMargin(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if ((r0 instanceof FrameLayout.LayoutParams) == false) goto L5;
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
    L6:
        if (r1 == null) goto L10;
        r1.setMarginStart(r3);
        r1.setMarginEnd(r3);
        r2.requestLayout();
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static final boolean isDarkMode(View r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1.getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    public static final Integer parseBgColor(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if ((r2.getBackground() instanceof ColorDrawable) == false) goto L11;
        Drawable r3 = r2.getBackground();
        if (r3 == null) goto L9;
        return Integer.valueOf(((ColorDrawable) r3).getColor());
    L9:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
    L11:
        if ((r2.getBackground() instanceof GradientDrawable) == false) goto L21;
        Drawable r4 = r2.getBackground();
        if (r4 == null) goto L20;
        ColorStateList r5 = ((GradientDrawable) r4).getColor();
        if (r5 != null) goto L18;
        return null;
    L18:
        return Integer.valueOf(r5.getDefaultColor());
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L21:
        return null;
    }
}
