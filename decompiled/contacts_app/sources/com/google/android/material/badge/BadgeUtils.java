package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ParcelableSparseArray;
import com.google.android.material.internal.ToolbarUtils;

/* JADX INFO: loaded from: classes2.dex */
public class BadgeUtils {
    private static final String LOG_TAG = "BadgeUtils";
    public static final boolean USE_COMPAT_PARENT = false;

    static /* synthetic */ void access$000(BadgeDrawable r0, View r1) {
        attachBadgeContentDescription(r0, r1);
    }

    static {
        USE_COMPAT_PARENT = false;
    }

    private BadgeUtils() {
    }

    public static void updateBadgeBounds(Rect r2, float r3, float r4, float r5, float r6) {
        r2.set((int) (r3 - r5), (int) (r4 - r6), (int) (r3 + r5), (int) (r4 + r6));
    }

    public static void attachBadgeDrawable(BadgeDrawable r1, View r2) {
        attachBadgeDrawable(r1, r2, null);
    }

    public static void attachBadgeDrawable(BadgeDrawable r0, View r1, FrameLayout r2) {
        setBadgeDrawableBounds(r0, r1, r2);
        if (r0.getCustomBadgeParent() == null) goto L6;
        r0.getCustomBadgeParent().setForeground(r0);
        return;
    L6:
        if (USE_COMPAT_PARENT == true) goto L10;
        r1.getOverlay().add(r0);
        return;
    L10:
        throw new IllegalArgumentException("Trying to reference null customBadgeParent");
    }

    public static void attachBadgeDrawable(BadgeDrawable r1, Toolbar r2, int r3) {
        attachBadgeDrawable(r1, r2, r3, null);
    }

    public static void attachBadgeDrawable(final BadgeDrawable r1, final Toolbar r2, final int r3, final FrameLayout r4) {
        r2.post(new AnonymousClass1(r2, r3, r1, r4));
    }

    private static void attachBadgeContentDescription(final BadgeDrawable r2, View r3) {
        if (ViewCompat.hasAccessibilityDelegate(r3) == false) goto L5;
        final View.AccessibilityDelegate r1 = r3.getAccessibilityDelegate();
        ViewCompat.setAccessibilityDelegate(r3, new AnonymousClass2(r1, r2));
        return;
    L5:
        ViewCompat.setAccessibilityDelegate(r3, new AnonymousClass3(r2));
    }

    public static void detachBadgeDrawable(BadgeDrawable r1, View r2) {
        if (r1 != null) goto L5;
        return;
    L5:
        if (USE_COMPAT_PARENT == false) goto L7;
    L10:
        r1.getCustomBadgeParent().setForeground(null);
        return;
    L7:
        if (r1.getCustomBadgeParent() != null) goto L10;
        r2.getOverlay().remove(r1);
    }

    public static void detachBadgeDrawable(BadgeDrawable r0, Toolbar r1, int r2) {
        if (r0 != null) goto L4;
        return;
    L4:
        ActionMenuItemView r3 = ToolbarUtils.getActionMenuItemView(r1, r2);
        if (r3 == null) goto L7;
        removeToolbarOffset(r0);
        detachBadgeDrawable(r0, r3);
        detachBadgeContentDescription(r3);
        return;
    L7:
        Log.w(LOG_TAG, "Trying to remove badge from a null menuItemView: " + r2);
    }

    private static void detachBadgeContentDescription(View r2) {
        if (ViewCompat.hasAccessibilityDelegate(r2) == false) goto L5;
        final View.AccessibilityDelegate r1 = r2.getAccessibilityDelegate();
        ViewCompat.setAccessibilityDelegate(r2, new AnonymousClass4(r1));
        return;
    L5:
        ViewCompat.setAccessibilityDelegate(r2, null);
    }

    static void setToolbarOffset(BadgeDrawable r1, Resources r2) {
        r1.setAdditionalHorizontalOffset(r2.getDimensionPixelOffset(R.dimen.mtrl_badge_toolbar_action_menu_item_horizontal_offset));
        r1.setAdditionalVerticalOffset(r2.getDimensionPixelOffset(R.dimen.mtrl_badge_toolbar_action_menu_item_vertical_offset));
    }

    static void removeToolbarOffset(BadgeDrawable r1) {
        r1.setAdditionalHorizontalOffset(0);
        r1.setAdditionalVerticalOffset(0);
    }

    public static void setBadgeDrawableBounds(BadgeDrawable r1, View r2, FrameLayout r3) {
        Rect r0 = new Rect();
        r2.getDrawingRect(r0);
        r1.setBounds(r0);
        r1.updateBadgeCoordinates(r2, r3);
    }

    public static ParcelableSparseArray createParcelableBadgeStates(SparseArray<BadgeDrawable> r4) {
        ParcelableSparseArray r0 = new ParcelableSparseArray();
        int r1 = 0;
    L4:
        if (r1 >= r4.size()) goto L10;
        int r2 = r4.keyAt(r1);
        BadgeDrawable r3 = r4.valueAt(r1);
        if (r3 == null) goto L9;
        r0.put(r2, r3.getSavedState());
        r1 = r1 + 1;
        goto L4
    L9:
        throw new IllegalArgumentException("badgeDrawable cannot be null");
    L10:
        return r0;
    }

    public static SparseArray<BadgeDrawable> createBadgeDrawablesFromSavedStates(Context r4, ParcelableSparseArray r5) {
        SparseArray<BadgeDrawable> r0 = new SparseArray(r5.size());
        int r1 = 0;
    L4:
        if (r1 >= r5.size()) goto L10;
        int r2 = r5.keyAt(r1);
        BadgeState.State r3 = (BadgeState.State) r5.valueAt(r1);
        if (r3 == null) goto L9;
        r0.put(r2, BadgeDrawable.createFromSavedState(r4, r3));
        r1 = r1 + 1;
        goto L4
    L9:
        throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
    L10:
        return r0;
    }
}
