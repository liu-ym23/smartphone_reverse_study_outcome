package com.android.contacts.widget;

import android.view.View;
import com.obric.oui.segmentedtab.OTabSegmentedLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\n\u0010\u0002\u001a\u00020\u0003\"\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0016\u0010\b\u001a\u00020\u0006*\u00020\u00012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0001\u001a\u0014\u0010\n\u001a\u00020\u0006*\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r¨\u0006\u000e"}, d2 = {"findView", "Landroid/view/View;", "ids", "", "", "followVisible", "", "view", "forceLayoutRecursive", "root", "setOnTabSelectListenerWithNotify", "Lcom/obric/oui/segmentedtab/OTabSegmentedLayout;", "listener", "Lcom/obric/oui/segmentedtab/OTabSegmentedLayout$TabSelectListener;", "app_QssiCnRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ViewUtilsKt {
    /* JADX INFO: renamed from: $r8$lambda$PlheWBb1chXTJLkhZ313p-UGztY, reason: not valid java name */
    public static /* synthetic */ void m232$r8$lambda$PlheWBb1chXTJLkhZ313pUGztY(View r0, View r1) {
        followVisible$lambda$0(r0, r1);
    }

    public static /* synthetic */ void forceLayoutRecursive$default(View r0, View r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        forceLayoutRecursive(r0, r1);
    }

    public static final void forceLayoutRecursive(View r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
    L3:
        if (r1 == null) goto L10;
        if (Intrinsics.areEqual(r1, r2) == true) goto L18;
        r1.requestLayout();
        Object r3 = r1.getParent();
        if ((r3 instanceof View) == true) goto L8;
        r1 = null;
        goto L3
    L8:
        r1 = (View) r3;
        goto L3
    L18:
        return;
    }

    public static final void followVisible(final View r2, final View r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "view");
        r2.setVisibility(r3.getVisibility());
        r2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewUtilsKt$$ExternalSyntheticLambda0(r2, r3));
    }

    private static final void followVisible$lambda$0(View r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "$this_followVisible");
        Intrinsics.checkNotNullParameter(r2, "$view");
        r1.setVisibility(r2.getVisibility());
    }

    public static final View findView(View r4, int... r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "ids");
        int r1 = 0;
        if (r5.length != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        return null;
    L9:
        int r2 = r5.length;
    L10:
        if (r1 >= r2) goto L16;
        int r3 = r5[r1];
        if (r4 == null) goto L14;
        r4 = r4.findViewById(r3);
    L15:
        r1 = r1 + 1;
        goto L10
    L14:
        r4 = null;
        goto L15
    L16:
        return r4;
    L5:
        r0 = false;
        goto L7
    }

    public static final void setOnTabSelectListenerWithNotify(OTabSegmentedLayout r1, OTabSegmentedLayout.TabSelectListener r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.setOnTabSelectListener(r2);
        if (r2 == null) goto L6;
        r2.onSelect(r1.getCurrentTab());
        return;
    }
}
