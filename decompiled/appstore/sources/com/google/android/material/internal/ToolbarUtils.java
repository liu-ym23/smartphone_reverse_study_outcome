package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ToolbarUtils {
    private ToolbarUtils() {
    }

    @Nullable
    public static ActionMenuItemView getActionMenuItemView(@NonNull Toolbar r10, @IdRes int r11) {
        ActionMenuView r12 = getActionMenuView(r10);
        if (r12 == null) goto L13;
        int r13 = 0;
    L6:
        if (r13 >= r12.getChildCount()) goto L19;
        View r14 = r12.getChildAt(r13);
        if ((r14 instanceof ActionMenuItemView) == false) goto L12;
        ActionMenuItemView r15 = (ActionMenuItemView) r14;
        if (r15.getItemData().getItemId() != r11) goto L12;
        return r15;
    L12:
        r13 = r13 + 1;
        goto L6
    L19:
        return null;
    L13:
        return null;
    }

    @Nullable
    public static ActionMenuView getActionMenuView(@NonNull Toolbar r10) {
        int r11 = 0;
    L4:
        if (r11 >= r10.getChildCount()) goto L10;
        View r12 = r10.getChildAt(r11);
        if ((r12 instanceof ActionMenuView) == true) goto L8;
        r11 = r11 + 1;
        goto L4
    L8:
        return (ActionMenuView) r12;
    L10:
        return null;
    }

    @Nullable
    public static ImageButton getNavigationIconButton(@NonNull Toolbar r10) {
        Drawable r11 = r10.getNavigationIcon();
        if (r11 != null) goto L5;
        return null;
    L5:
        int r12 = 0;
    L7:
        if (r12 >= r10.getChildCount()) goto L14;
        View r13 = r10.getChildAt(r12);
        if ((r13 instanceof ImageButton) == false) goto L13;
        ImageButton r14 = (ImageButton) r13;
        if (r14.getDrawable() != r11) goto L13;
        return r14;
    L13:
        r12 = r12 + 1;
        goto L7
    L14:
        return null;
    }

    @Nullable
    public static View getSecondaryActionMenuItemView(@NonNull Toolbar r10) {
        ActionMenuView r11 = getActionMenuView(r10);
        if (r11 != null) goto L5;
        return null;
    L5:
        if (r11.getChildCount() > 1) goto L7;
        return null;
    L7:
        return r11.getChildAt(0);
    }

    @Nullable
    public static TextView getSubtitleTextView(@NonNull Toolbar r10) {
        return getTextView(r10, r10.getSubtitle());
    }

    @Nullable
    private static TextView getTextView(@NonNull Toolbar r10, CharSequence r11) {
        int r12 = 0;
    L4:
        if (r12 >= r10.getChildCount()) goto L11;
        View r13 = r10.getChildAt(r12);
        if ((r13 instanceof TextView) == false) goto L10;
        TextView r14 = (TextView) r13;
        if (TextUtils.equals(r14.getText(), r11) == false) goto L10;
        return r14;
    L10:
        r12 = r12 + 1;
        goto L4
    L11:
        return null;
    }

    @Nullable
    public static TextView getTitleTextView(@NonNull Toolbar r10) {
        return getTextView(r10, r10.getTitle());
    }
}
