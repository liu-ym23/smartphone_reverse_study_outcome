package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.R;
import com.google.android.material.internal.ParcelableSparseArray;
import com.google.android.material.internal.ToolbarUtils;

/* JADX INFO: loaded from: classes3.dex */
@ExperimentalBadgeUtils
public class BadgeUtils {
    private static final String LOG_TAG = "BadgeUtils";
    public static final boolean USE_COMPAT_PARENT = false;

    static {
        USE_COMPAT_PARENT = false;
    }

    private BadgeUtils() {
    }

    public static void attachBadgeDrawable(@NonNull BadgeDrawable r10, @NonNull View r11) {
        attachBadgeDrawable(r10, r11, null);
    }

    @NonNull
    public static SparseArray<BadgeDrawable> createBadgeDrawablesFromSavedStates(Context r10, @NonNull ParcelableSparseArray r11) {
        SparseArray<BadgeDrawable> r12 = new SparseArray(r11.size());
        int r13 = 0;
    L4:
        if (r13 >= r11.size()) goto L10;
        int r14 = r11.keyAt(r13);
        BadgeDrawable.SavedState r15 = (BadgeDrawable.SavedState) r11.valueAt(r13);
        if (r15 == null) goto L9;
        r12.put(r14, BadgeDrawable.createFromSavedState(r10, r15));
        r13 = r13 + 1;
        goto L4
    L9:
        throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
    L10:
        return r12;
    }

    @NonNull
    public static ParcelableSparseArray createParcelableBadgeStates(@NonNull SparseArray<BadgeDrawable> r10) {
        ParcelableSparseArray r11 = new ParcelableSparseArray();
        int r12 = 0;
    L4:
        if (r12 >= r10.size()) goto L10;
        int r13 = r10.keyAt(r12);
        BadgeDrawable r14 = r10.valueAt(r12);
        if (r14 == null) goto L9;
        r11.put(r13, r14.getSavedState());
        r12 = r12 + 1;
        goto L4
    L9:
        throw new IllegalArgumentException("badgeDrawable cannot be null");
    L10:
        return r11;
    }

    public static void detachBadgeDrawable(@Nullable BadgeDrawable r10, @NonNull View r11) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (USE_COMPAT_PARENT == false) goto L7;
    L10:
        r10.getCustomBadgeParent().setForeground(null);
        return;
    L7:
        if (r10.getCustomBadgeParent() != null) goto L10;
        r11.getOverlay().remove(r10);
    }

    @VisibleForTesting
    public static void removeToolbarOffset(BadgeDrawable r10) {
        r10.setAdditionalHorizontalOffset(0);
        r10.setAdditionalVerticalOffset(0);
    }

    public static void setBadgeDrawableBounds(@NonNull BadgeDrawable r10, @NonNull View r11, @Nullable FrameLayout r12) {
        Rect r13 = new Rect();
        r11.getDrawingRect(r13);
        r10.setBounds(r13);
        r10.updateBadgeCoordinates(r11, r12);
    }

    @VisibleForTesting
    public static void setToolbarOffset(BadgeDrawable r10, Resources r11) {
        r10.setAdditionalHorizontalOffset(r11.getDimensionPixelOffset(R.dimen.mtrl_badge_toolbar_action_menu_item_horizontal_offset));
        r10.setAdditionalVerticalOffset(r11.getDimensionPixelOffset(R.dimen.mtrl_badge_toolbar_action_menu_item_vertical_offset));
    }

    public static void updateBadgeBounds(@NonNull Rect r10, float r11, float r12, float r13, float r14) {
        r10.set((int) (r11 - r13), (int) (r12 - r14), (int) (r11 + r13), (int) (r12 + r14));
    }

    public static void attachBadgeDrawable(@NonNull BadgeDrawable r10, @NonNull View r11, @Nullable FrameLayout r12) {
        setBadgeDrawableBounds(r10, r11, r12);
        if (r10.getCustomBadgeParent() == null) goto L6;
        r10.getCustomBadgeParent().setForeground(r10);
        return;
    L6:
        if (USE_COMPAT_PARENT == true) goto L10;
        r11.getOverlay().add(r10);
        return;
    L10:
        throw new IllegalArgumentException("Trying to reference null customBadgeParent");
    }

    public static void detachBadgeDrawable(@Nullable BadgeDrawable r10, @NonNull Toolbar r11, @IdRes int r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        ActionMenuItemView r13 = ToolbarUtils.getActionMenuItemView(r11, r12);
        if (r13 == null) goto L7;
        removeToolbarOffset(r10);
        detachBadgeDrawable(r10, r13);
        return;
    L7:
        Log.w(LOG_TAG, "Trying to remove badge from a null menuItemView: " + r12);
    }

    public static void attachBadgeDrawable(@NonNull BadgeDrawable r10, @NonNull Toolbar r11, @IdRes int r12) {
        attachBadgeDrawable(r10, r11, r12, null);
    }

    public static void attachBadgeDrawable(@NonNull final BadgeDrawable r10, @NonNull final Toolbar r11, @IdRes final int r12, @Nullable final FrameLayout r13) {
        r11.post(new AnonymousClass1(r11, r12, r10, r13));
    }
}
