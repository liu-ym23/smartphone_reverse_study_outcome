package com.obric.oui.common.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import com.obric.common.oui.R;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewExtensions.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a<\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007H\u0002\u001a\u0012\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u000e\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010\u001a$\u0010\u000e\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u001a\u001a\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010\u001a7\u0010\u0015\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0017\"\u00020\u0002¢\u0006\u0002\u0010\u0018\u001a\n\u0010\u0019\u001a\u00020\u0007*\u00020\u0002\u001a\n\u0010\u001a\u001a\u00020\u0007*\u00020\u0002\u001a\n\u0010\u001b\u001a\u00020\u0007*\u00020\u0002\u001a\n\u0010\u001c\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u001d\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u001e\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u001f\u001a\u00020\u0001*\u00020\u0002\u001a\u0014\u0010 \u001a\u00020\u0001*\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0002\u001a\u0012\u0010#\u001a\u00020\u0001*\u00020\u00022\u0006\u0010$\u001a\u00020%\u001a\u0014\u0010&\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010'\u001a\u00020%\u001a\u0012\u0010(\u001a\u00020\u0001*\u00020!2\u0006\u0010)\u001a\u00020\u0007\u001a\u0012\u0010*\u001a\u00020\u0001*\u00020\u00022\u0006\u0010+\u001a\u00020\u0007¨\u0006,"}, d2 = {"clipBottomCorner", "", "Landroid/view/View;", "cornerRadius", "", "clipCorner", "topLeft", "", "topRight", "bottomLeft", "bottomRight", "clipLeftCorner", "clipRightCorner", "clipTopCorner", "expandTouchArea", "expectedSize", "", "expectedWidth", "expectedHeight", "forceSet", "expandTouchAreaForTopRightCorner", "increaseHitAreaForViews", "views", "", "(Landroid/view/View;II[Landroid/view/View;)V", "isGone", "isInvisible", "isVisibile", "makeGone", "makeInvisible", "makeVisible", "removeFromParent", "removeFromParentAndAdd", "Landroid/view/ViewGroup;", "view", "setA11yRole", "roleDesc", "", "setButtonAccessibilityDelegate", "contentDescription", "setEnable", "isEnable", "setVisibility", "visible", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ViewExtensionsKt {
    public static /* synthetic */ void $r8$lambda$0RPIG_HPYGczScM_05idjbp44Sg(View r0, int r1, int r2, boolean r3, ViewGroup r4) {
        m438expandTouchArea$lambda2(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$L-AjddsKhHpgR0juCC2JVHWsTuc, reason: not valid java name */
    public static /* synthetic */ void m437$r8$lambda$LAjddsKhHpgR0juCC2JVHWsTuc(View[] r0, View r1, TouchDelegateComposite r2, int r3, int r4) {
        m440increaseHitAreaForViews$lambda1(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$eBCCIa0tOyX9Kh_tNFmbHBwnYsg(View r0, int r1, int r2, ViewGroup r3) {
        m439expandTouchAreaForTopRightCorner$lambda3(r0, r1, r2, r3);
    }

    public static /* synthetic */ void increaseHitAreaForViews$default(View r0, int r1, int r2, View[] r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = (int) r0.getResources().getDimension(R.dimen.oui_touch_target_default_size);
    L6:
        if ((r4 & 2) == 0) goto L8;
        r2 = (int) r0.getResources().getDimension(R.dimen.oui_touch_target_default_size);
    L8:
        increaseHitAreaForViews(r0, r1, r2, r3);
    }

    public static final void increaseHitAreaForViews(final View r7, final int r8, final int r9, final View... r10) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r10, "views");
        final TouchDelegateComposite r4 = new TouchDelegateComposite(r7, null, 2, null);
        r7.post(new ViewExtensionsKt$$ExternalSyntheticLambda1(r10, r7, r4, r8, r9));
    }

    public static final void makeVisible(View r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.setVisibility(0);
    }

    public static final void makeGone(View r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.setVisibility(8);
    }

    public static final void makeInvisible(View r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.setVisibility(4);
    }

    public static final void setVisibility(View r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 == false) goto L5;
        makeVisible(r1);
        return;
    L5:
        makeGone(r1);
    }

    public static final boolean isVisibile(View r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isGone(View r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.getVisibility() != 8) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isInvisible(View r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.getVisibility() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ void expandTouchArea$default(View r0, int r1, int r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        expandTouchArea(r0, r1, r2, r3);
    }

    public static final void expandTouchArea(final View r8, final int r9, final int r10, final boolean r11) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        if (r8.getParent() == null) goto L9;
        ViewParent r0 = r8.getParent();
        if (r0 == null) goto L8;
        ViewGroup r1 = (ViewGroup) r0;
    L10:
        if (r1 != null) goto L12;
        return;
    L12:
        final ViewGroup r6 = r1;
        r1.post(new ViewExtensionsKt$$ExternalSyntheticLambda0(r8, r9, r10, r11, r6));
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L9:
        r1 = null;
        goto L10
    }

    /* JADX INFO: renamed from: expandTouchArea$lambda-2, reason: not valid java name */
    private static final void m438expandTouchArea$lambda2(View r2, int r3, int r4, boolean r5, ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r2, "$this_expandTouchArea");
        Intrinsics.checkNotNullParameter(r6, "$parentView");
        Rect r0 = new Rect();
        r2.getHitRect(r0);
        int r7 = (r3 - r0.width()) / 2;
        int r8 = (r4 - r0.height()) / 2;
        if (r7 >= 0) goto L6;
        if (r5 == true) goto L6;
        r7 = 0;
    L6:
        if (r8 >= 0) goto L9;
        if (r5 == true) goto L9;
        r8 = 0;
    L9:
        r0.left -= r7;
        r0.top -= r8;
        r0.right += r7;
        r0.bottom += r8;
        r6.setTouchDelegate(new TouchDelegate(r0, r2));
    }

    public static final void expandTouchArea(View r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        expandTouchArea$default(r7, r8, r8, false, 4, null);
    }

    public static final void expandTouchAreaForTopRightCorner(final View r2, final int r3, final int r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.getParent() == null) goto L9;
        ViewParent r0 = r2.getParent();
        if (r0 == null) goto L8;
        final ViewGroup r1 = (ViewGroup) r0;
    L10:
        if (r1 != null) goto L12;
        return;
    L12:
        r1.post(new ViewExtensionsKt$$ExternalSyntheticLambda2(r2, r3, r4, r1));
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L9:
        r1 = null;
        goto L10
    }

    /* JADX INFO: renamed from: expandTouchAreaForTopRightCorner$lambda-3, reason: not valid java name */
    private static final void m439expandTouchAreaForTopRightCorner$lambda3(View r5, int r6, int r7, ViewGroup r8) {
        Intrinsics.checkNotNullParameter(r5, "$this_expandTouchAreaForTopRightCorner");
        Intrinsics.checkNotNullParameter(r8, "$parentView");
        Rect r0 = new Rect();
        r5.getHitRect(r0);
        int r9 = (r6 - r0.width()) / 2;
        int r10 = (r7 - r0.height()) / 2;
        int r1 = 0;
        if (r9 >= 0) goto L5;
        r9 = 0;
    L5:
        if (r10 >= 0) goto L7;
        r10 = 0;
    L7:
        int r2 = r0.right + r9;
        int r3 = r0.left - r9;
        int r11 = r0.top - r10;
        int r4 = r0.bottom + r10;
        if (r2 <= r8.getWidth()) goto L10;
        r3 = r3 - (r2 - r8.getWidth());
        r2 = r8.getWidth();
    L10:
        if (r11 >= 0) goto L12;
        r4 = r4 + (0 - r11);
    L13:
        r0.left = r3;
        r0.top = r1;
        r0.right = r2;
        r0.bottom = r4;
        r8.setTouchDelegate(new TouchDelegate(r0, r5));
        return;
    L12:
        r1 = r11;
        goto L13
    }

    public static final void removeFromParent(View r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.getParent() != null) goto L5;
        return;
    L5:
        if ((r1.getParent() instanceof ViewGroup) == false) goto L12;
        ViewParent r0 = r1.getParent();
        if (r0 == null) goto L10;
        ((ViewGroup) r0).removeView(r1);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public static final void setA11yRole(View r1, final String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "roleDesc");
        ViewCompat.setAccessibilityDelegate(r1, new C03421(r2));
    }

    public static final void setEnable(ViewGroup r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.setEnabled(r2);
        Iterator<View> r3 = ViewGroupKt.getChildren(r1).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.next().setEnabled(r2);
        goto L4
    }

    static /* synthetic */ void clipCorner$default(View r7, float r8, boolean r9, boolean r10, boolean r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        boolean r3 = true;
    L7:
        if ((r13 & 4) == 0) goto L9;
        boolean r4 = true;
    L11:
        if ((r13 & 8) == 0) goto L13;
        boolean r5 = true;
    L15:
        if ((r13 & 16) == 0) goto L17;
        boolean r6 = true;
    L18:
        clipCorner(r7, r8, r3, r4, r5, r6);
        return;
    L17:
        r6 = r12;
        goto L18
    L13:
        r5 = r11;
        goto L15
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    private static final void clipCorner(final View r8, final float r9, final boolean r10, final boolean r11, final boolean r12, final boolean r13) {
        r8.setOutlineProvider(new AnonymousClass1(r8, r10, r11, r12, r13, r9));
        r8.setClipToOutline(true);
    }

    public static final void clipCorner(View r7, float r8) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        clipCorner(r7, r8, true, true, true, true);
    }

    public static final void clipTopCorner(View r9, float r10) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        clipCorner$default(r9, r10, false, false, false, false, 6, null);
    }

    public static final void clipBottomCorner(View r9, float r10) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        clipCorner$default(r9, r10, false, false, false, false, 24, null);
    }

    public static final void clipLeftCorner(View r9, float r10) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        clipCorner$default(r9, r10, false, false, false, false, 10, null);
    }

    public static final void clipRightCorner(View r9, float r10) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        clipCorner$default(r9, r10, false, false, false, false, 20, null);
    }

    public static final void removeFromParentAndAdd(ViewGroup r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 != null) goto L5;
        ViewParent r0 = null;
    L6:
        if (r0 != null) goto L8;
    L10:
        r1.addView(r2);
        return;
    L8:
        if ((r2.getParent() instanceof ViewGroup) == false) goto L10;
        removeFromParent(r2);
        goto L10
    L5:
        r0 = r2.getParent();
        goto L6
    }

    public static /* synthetic */ void setButtonAccessibilityDelegate$default(View r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = "";
    L5:
        setButtonAccessibilityDelegate(r0, r1);
    }

    public static final void setButtonAccessibilityDelegate(View r1, final String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "contentDescription");
        ViewCompat.setAccessibilityDelegate(r1, new C03431(r2));
    }

    /* JADX INFO: renamed from: increaseHitAreaForViews$lambda-1, reason: not valid java name */
    private static final void m440increaseHitAreaForViews$lambda1(View[] r8, View r9, TouchDelegateComposite r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r8, "$views");
        Intrinsics.checkNotNullParameter(r9, "$this_increaseHitAreaForViews");
        Intrinsics.checkNotNullParameter(r10, "$touchDelegateComposite");
        int r0 = r8.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L10;
        View r3 = r8[r2];
        Rect r4 = new Rect();
        r3.getHitRect(r4);
        int r5 = (r11 - r4.width()) / 2;
        int r6 = (r12 - r4.height()) / 2;
        if (r5 >= 0) goto L7;
        r5 = 0;
    L7:
        if (r6 >= 0) goto L9;
        r6 = 0;
    L9:
        r4.left -= r5;
        r4.top -= r6;
        r4.right += r5;
        r4.bottom += r6;
        r10.addDelegate(new TouchDelegate(r4, r3));
        r2 = r2 + 1;
        goto L3
    L10:
        r9.setTouchDelegate(r10);
    }
}
