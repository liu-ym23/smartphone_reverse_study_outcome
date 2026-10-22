package com.bytedance.android.ui.ec.widget.photodraweeview;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a%\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u000b\u001a\n\u0010\f\u001a\u00020\r*\u00020\u0006\u001a\u0012\u0010\u000e\u001a\u00020\r*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010\u001a\n\u0010\u000f\u001a\u00020\r*\u00020\u0006\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0011"}, d2 = {"dp", "", "", "getDp", "(Ljava/lang/Number;)I", "findCenterView", "Landroid/view/View;", "Landroidx/recyclerview/widget/RecyclerView;", "helper", "Landroidx/recyclerview/widget/OrientationHelper;", "ignorePos", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/OrientationHelper;Ljava/lang/Integer;)Landroid/view/View;", "gone", "", "showIf", "visible", "", "ui-ec-widget_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class ExtensionsKt {
    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_photodraweeview_ExtensionsKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static final int getDp(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$dp");
        return (int) TypedValue.applyDimension(1, r100.floatValue(), INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_photodraweeview_ExtensionsKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()));
    }

    public static final void gone(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$gone");
        r100.setVisibility(8);
    }

    public static final void visible(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$visible");
        r100.setVisibility(0);
    }

    public static final void showIf(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$showIf");
        if (r101 == false) goto L5;
        int r102 = 0;
    L6:
        r100.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public static final View findCenterView(RecyclerView r100, OrientationHelper r101, Integer r110) {
        Intrinsics.checkNotNullParameter(r100, "$this$findCenterView");
        Intrinsics.checkNotNullParameter(r101, "helper");
        RecyclerView.LayoutManager r102 = r100.getLayoutManager();
        View r103 = null;
        if (r102 == null) goto L25;
        int r104 = r102.getChildCount();
        if (r104 == 0) goto L25;
        if (r102.getClipToPadding() == false) goto L10;
        int r105 = r101.getStartAfterPadding() + (r101.getTotalSpace() / 2);
    L11:
        int r106 = Integer.MAX_VALUE;
        int r107 = 0;
    L12:
        if (r107 >= r104) goto L25;
        View r108 = r102.getChildAt(r107);
        if (r108 == null) goto L16;
        int r109 = r102.getPosition(r108);
    L17:
        if (r110 != null) goto L20;
    L21:
        int r111 = Math.abs((r101.getDecoratedStart(r108) + (r101.getDecoratedMeasurement(r108) / 2)) - r105);
        if (r111 >= r106) goto L24;
        r103 = r108;
        r106 = r111;
    L24:
        r107 = r107 + 1;
        goto L12
    L20:
        if (r109 == r110.intValue()) goto L24;
    L16:
        r109 = -1;
        goto L17
    L10:
        r105 = r101.getEnd() / 2;
    L25:
        return r103;
    }

    public static /* synthetic */ View findCenterView$default(RecyclerView r100, OrientationHelper r101, Integer r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return findCenterView(r100, r101, r102);
    }
}
