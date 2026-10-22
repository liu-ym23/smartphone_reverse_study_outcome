package com.obric.oui.indicator;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IndicatorExternals.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a(\u0010\u0005\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0006*\u0012\u0012\u0004\u0012\u0002H\u00060\u0007j\b\u0012\u0004\u0012\u0002H\u0006`\b2\u0006\u0010\t\u001a\u00020\n\u001a\u0012\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\n\u001a\u0012\u0010\u000f\u001a\u00020\f*\u00020\r2\u0006\u0010\u0010\u001a\u00020\n\u001a\u0012\u0010\u0011\u001a\u00020\f*\u00020\r2\u0006\u0010\u0012\u001a\u00020\n\"\u0017\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0003¨\u0006\u0013"}, d2 = {"isEmpty", "", "Landroidx/viewpager/widget/ViewPager;", "(Landroidx/viewpager/widget/ViewPager;)Z", "isNotEmpty", "isInBounds", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "index", "", "setHorizontalMargin", "", "Landroid/view/View;", "margin", "setMarginBottom", "marginBottom", "setWidth", MaterialConfigFormatNames.WIDTH, "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class IndicatorExternalsKt {
    public static final void setWidth(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.getLayoutParams().width = r2;
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

    public static final void setHorizontalMargin(View r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        ViewGroup.MarginLayoutParams r2 = null;
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L6:
        if (r1 == null) goto L9;
        r1.setMarginStart(r4);
        r1.setMarginEnd(r4);
        r3.requestLayout();
        r2 = r1;
    L9:
        r3.setLayoutParams(r2);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static final boolean isNotEmpty(ViewPager r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        PagerAdapter r2 = r1.getAdapter();
        if (r2 != null) goto L5;
        int r3 = 0;
    L6:
        if (r3 <= 0) goto L9;
        return true;
    L9:
        return false;
    L5:
        r3 = r2.getCount();
        goto L6
    }

    public static final boolean isEmpty(ViewPager r1) {
        if (r1 != null) goto L4;
    L8:
        return false;
    L4:
        if (r1.getAdapter() == null) goto L8;
        PagerAdapter r2 = r1.getAdapter();
        Intrinsics.checkNotNull(r2);
        if (r2.getCount() != 0) goto L8;
        return true;
    }

    public static final <T> boolean isInBounds(ArrayList<T> r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 >= 0) goto L5;
        return false;
    L5:
        if (r2 >= r1.size()) goto L9;
        return true;
    L9:
        return false;
    }
}
