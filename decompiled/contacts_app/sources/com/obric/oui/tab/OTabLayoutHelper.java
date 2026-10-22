package com.obric.oui.tab;

import android.R;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.obric.oui.common.style.IOUILayout;
import com.obric.oui.common.style.Shadow;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: OTabLayoutHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0007JH\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/tab/OTabLayoutHelper;", "", "()V", "MAX_SHOW_TAB_COUNT", "", "MAX_TAB_COUNT_MIX_MODE", "", "configScrollableTabWidth", "", "tabLayout", "Lcom/obric/oui/tab/OTabLayout;", "resolveEdgeFadeOverlayColor", "view", "Landroid/view/View;", "updateEdgeFadeBounds", "tabContainer", "Landroid/view/ViewGroup;", "scrollX", MaterialConfigFormatNames.WIDTH, MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "showLeftFade", "", "showRightFade", "outLayerBounds", "Landroid/graphics/RectF;", "outOverlayBounds", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OTabLayoutHelper {
    public static final OTabLayoutHelper INSTANCE = null;
    private static final float MAX_SHOW_TAB_COUNT = 5.5f;
    private static final int MAX_TAB_COUNT_MIX_MODE = 5;

    static {
        INSTANCE = new OTabLayoutHelper();
    }

    private OTabLayoutHelper() {
    }

    @JvmStatic
    public static final void configScrollableTabWidth(OTabLayout r8) {
        Intrinsics.checkNotNullParameter(r8, "tabLayout");
        if (r8.getTabMode() == 0) goto L5;
        return;
    L5:
        if (r8.getTabCount() <= 5) goto L37;
        int r0 = Math.min(r8.getTabCount(), 5);
        int r3 = 0;
        int r4 = 0;
    L8:
        if (r3 >= r0) goto L13;
        int r6 = r3 + 1;
        OTabLayoutBase.Tab r5 = r8.getTabAt(r3);
        Intrinsics.checkNotNull(r5);
        OTabLayoutBase.TabView r7 = r5.getView();
        Intrinsics.checkNotNullExpressionValue(r7, "tabLayout.getTabAt(i)!!.view");
        OTabLayoutBase.TabView r9 = r7;
        if (r9.getVisibility() != 0) goto L12;
        r4 = r4 + r9.getMeasuredWidth();
    L12:
        r3 = r6;
        goto L8
    L13:
        OTabLayoutBase.Tab r1 = r8.getTabAt(5);
        Intrinsics.checkNotNull(r1);
        if ((r4 + MathKt.roundToInt(((double) r1.getView().getMeasuredWidth()) * 0.5d)) > 0) goto L16;
        return;
    L16:
        float r2 = (r8.getMeasuredWidth() - r8.getTabStripLeftPadding()) / MAX_SHOW_TAB_COUNT;
        int r10 = r8.getTabCount();
        int r11 = 0;
    L17:
        if (r11 >= r10) goto L38;
        int r12 = r11 + 1;
        OTabLayoutBase.Tab r13 = r8.getTabAt(r11);
        Intrinsics.checkNotNull(r13);
        OTabLayoutBase.TabView r14 = r13.getView();
        Intrinsics.checkNotNullExpressionValue(r14, "tabLayout.getTabAt(i)!!.view");
        OTabLayoutBase.TabView r15 = r14;
        if (r15.getVisibility() != 0) goto L28;
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        if (r16 == null) goto L27;
        LinearLayout.LayoutParams r17 = (LinearLayout.LayoutParams) r16;
        r17.width = (int) r2;
        r17.weight = 0.0f;
        if (r8.isAutoFillWhenScrollable == false) goto L25;
        r17.leftMargin = 0;
        r17.rightMargin = 0;
    L25:
        r15.setLayoutParams(r17);
        ViewCompat.setPaddingRelative(r15, 0, r15.getPaddingTop(), 0, r15.getPaddingBottom());
        goto L28
    L27:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L28:
        r11 = r12;
        goto L17
    L38:
        return;
    }

    @JvmStatic
    public static final int resolveEdgeFadeOverlayColor(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        View r0 = r3;
    L3:
        if (r0 == null) goto L14;
        Drawable r1 = r0.getBackground();
        if ((r1 instanceof ColorDrawable) == false) goto L10;
        ColorDrawable r2 = (ColorDrawable) r1;
        if (r2.getAlpha() <= 0) goto L10;
        return r2.getColor();
    L10:
        Object r4 = r0.getParent();
        if ((r4 instanceof View) == true) goto L12;
        r0 = null;
        goto L3
    L12:
        r0 = (View) r4;
        goto L3
    L14:
        TypedValue r5 = new TypedValue();
        if (r3.getContext().getTheme().resolveAttribute(R.attr.colorBackground, r5, true) == true) goto L17;
        return -1;
    L17:
        return r5.data;
    }

    @JvmStatic
    public static final void updateEdgeFadeBounds(ViewGroup r12, float r13, int r14, int r15, boolean r16, boolean r17, RectF r18, RectF r19) {
        Intrinsics.checkNotNullParameter(r12, "tabContainer");
        Intrinsics.checkNotNullParameter(r18, "outLayerBounds");
        Intrinsics.checkNotNullParameter(r19, "outOverlayBounds");
        int r3 = r12.getChildCount();
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
        int r7 = 0;
    L3:
        if (r5 >= r3) goto L19;
        int r8 = r5 + 1;
        KeyEvent.Callback r9 = r12.getChildAt(r5);
        if ((r9 instanceof IOUILayout) == false) goto L9;
        List<Shadow> r10 = ((IOUILayout) r9).getCurrentShadows();
        if (r10 == null) goto L9;
        Iterator<Shadow> r11 = r10.iterator();
    L12:
        if (r11.hasNext() == false) goto L9;
        Shadow r20 = r11.next();
        if (r20 == null) goto L12;
        if (r20.valid() == false) goto L12;
        r6 = Math.max(r6, (int) Math.ceil((Math.abs(r20.getOffsetX()) + r20.getRadius()) + r20.getSpread()));
        r7 = Math.max(r7, (int) Math.ceil((Math.abs(r20.getOffsetY()) + r20.getRadius()) + r20.getSpread()));
    L9:
        r5 = r8;
        goto L3
    L19:
        if (r16 == false) goto L21;
        int r0 = 0;
    L22:
        float r1 = r13 - r0;
        float r21 = r14 + r13;
        if (r17 == true) goto L26;
        r4 = r6;
    L26:
        float r22 = r7;
        r18.set(r1, -r22, r4 + r21, r15 + r22);
        if (r16 == false) goto L29;
        float r2 = r18.left;
    L30:
        if (r17 == false) goto L32;
        r21 = r18.right;
    L32:
        r19.set(r2, r18.top, r21, r18.bottom);
        return;
    L29:
        r2 = r13;
        goto L30
    L21:
        r0 = r6;
        goto L22
    }
}
