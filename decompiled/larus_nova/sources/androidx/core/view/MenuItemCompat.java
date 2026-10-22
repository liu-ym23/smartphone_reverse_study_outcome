package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.ReplaceWith;
import androidx.core.internal.view.SupportMenuItem;

/* JADX INFO: loaded from: classes17.dex */
public final class MenuItemCompat {
    public static final int SHOW_AS_ACTION_ALWAYS = 2;
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    public static final int SHOW_AS_ACTION_NEVER = 0;
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
    private static final String TAG = "MenuItemCompat";

    public static class Api26Impl {
        private Api26Impl() {
        }

        public static int getAlphabeticModifiers(MenuItem r100) {
            return r100.getAlphabeticModifiers();
        }

        public static CharSequence getContentDescription(MenuItem r100) {
            return r100.getContentDescription();
        }

        public static ColorStateList getIconTintList(MenuItem r100) {
            return r100.getIconTintList();
        }

        public static PorterDuff.Mode getIconTintMode(MenuItem r100) {
            return r100.getIconTintMode();
        }

        public static int getNumericModifiers(MenuItem r100) {
            return r100.getNumericModifiers();
        }

        public static CharSequence getTooltipText(MenuItem r100) {
            return r100.getTooltipText();
        }

        public static MenuItem setContentDescription(MenuItem r100, CharSequence r101) {
            return r100.setContentDescription(r101);
        }

        public static MenuItem setIconTintList(MenuItem r100, ColorStateList r101) {
            return r100.setIconTintList(r101);
        }

        public static MenuItem setIconTintMode(MenuItem r100, PorterDuff.Mode r101) {
            return r100.setIconTintMode(r101);
        }

        public static MenuItem setTooltipText(MenuItem r100, CharSequence r101) {
            return r100.setTooltipText(r101);
        }

        public static MenuItem setAlphabeticShortcut(MenuItem r100, char r101, int r102) {
            return r100.setAlphabeticShortcut(r101, r102);
        }

        public static MenuItem setNumericShortcut(MenuItem r100, char r101, int r102) {
            return r100.setNumericShortcut(r101, r102);
        }

        public static MenuItem setShortcut(MenuItem r100, char r101, char r102, int r103, int r104) {
            return r100.setShortcut(r101, r102, r103, r104);
        }
    }

    public interface OnActionExpandListener {
        boolean onMenuItemActionCollapse(MenuItem r100);

        boolean onMenuItemActionExpand(MenuItem r100);
    }

    private MenuItemCompat() {
    }

    @ReplaceWith(expression = "item.collapseActionView()")
    public static boolean collapseActionView(MenuItem r100) {
        return r100.collapseActionView();
    }

    @ReplaceWith(expression = "item.expandActionView()")
    public static boolean expandActionView(MenuItem r100) {
        return r100.expandActionView();
    }

    public static ActionProvider getActionProvider(MenuItem r100) {
        if ((r100 instanceof SupportMenuItem) == true) goto L5;
        return null;
    L5:
        return ((SupportMenuItem) r100).getSupportActionProvider();
    }

    @ReplaceWith(expression = "item.getActionView()")
    public static View getActionView(MenuItem r100) {
        return r100.getActionView();
    }

    public static int getAlphabeticModifiers(MenuItem r100) {
        if ((r100 instanceof SupportMenuItem) == false) goto L7;
        return ((SupportMenuItem) r100).getAlphabeticModifiers();
    L7:
        if (Build.VERSION.SDK_INT >= 26) goto L9;
        return 0;
    L9:
        return Api26Impl.getAlphabeticModifiers(r100);
    }

    public static CharSequence getContentDescription(MenuItem r100) {
        if ((r100 instanceof SupportMenuItem) == false) goto L7;
        return ((SupportMenuItem) r100).getContentDescription();
    L7:
        if (Build.VERSION.SDK_INT >= 26) goto L9;
        return null;
    L9:
        return Api26Impl.getContentDescription(r100);
    }

    public static ColorStateList getIconTintList(MenuItem r100) {
        if ((r100 instanceof SupportMenuItem) == false) goto L7;
        return ((SupportMenuItem) r100).getIconTintList();
    L7:
        if (Build.VERSION.SDK_INT >= 26) goto L9;
        return null;
    L9:
        return Api26Impl.getIconTintList(r100);
    }

    public static PorterDuff.Mode getIconTintMode(MenuItem r100) {
        if ((r100 instanceof SupportMenuItem) == false) goto L7;
        return ((SupportMenuItem) r100).getIconTintMode();
    L7:
        if (Build.VERSION.SDK_INT >= 26) goto L9;
        return null;
    L9:
        return Api26Impl.getIconTintMode(r100);
    }

    public static int getNumericModifiers(MenuItem r100) {
        if ((r100 instanceof SupportMenuItem) == false) goto L7;
        return ((SupportMenuItem) r100).getNumericModifiers();
    L7:
        if (Build.VERSION.SDK_INT >= 26) goto L9;
        return 0;
    L9:
        return Api26Impl.getNumericModifiers(r100);
    }

    public static CharSequence getTooltipText(MenuItem r100) {
        if ((r100 instanceof SupportMenuItem) == false) goto L7;
        return ((SupportMenuItem) r100).getTooltipText();
    L7:
        if (Build.VERSION.SDK_INT >= 26) goto L9;
        return null;
    L9:
        return Api26Impl.getTooltipText(r100);
    }

    @ReplaceWith(expression = "item.isActionViewExpanded()")
    public static boolean isActionViewExpanded(MenuItem r100) {
        return r100.isActionViewExpanded();
    }

    public static MenuItem setActionProvider(MenuItem r100, ActionProvider r101) {
        if ((r100 instanceof SupportMenuItem) == true) goto L5;
        return r100;
    L5:
        return ((SupportMenuItem) r100).setSupportActionProvider(r101);
    }

    @ReplaceWith(expression = "item.setActionView(resId)")
    public static MenuItem setActionView(MenuItem r100, int r101) {
        return r100.setActionView(r101);
    }

    public static void setContentDescription(MenuItem r100, CharSequence r101) {
        if ((r100 instanceof SupportMenuItem) == false) goto L6;
        ((SupportMenuItem) r100).setContentDescription(r101);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        Api26Impl.setContentDescription(r100, r101);
        return;
    }

    public static void setIconTintList(MenuItem r100, ColorStateList r101) {
        if ((r100 instanceof SupportMenuItem) == false) goto L6;
        ((SupportMenuItem) r100).setIconTintList(r101);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        Api26Impl.setIconTintList(r100, r101);
        return;
    }

    public static void setIconTintMode(MenuItem r100, PorterDuff.Mode r101) {
        if ((r100 instanceof SupportMenuItem) == false) goto L6;
        ((SupportMenuItem) r100).setIconTintMode(r101);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        Api26Impl.setIconTintMode(r100, r101);
        return;
    }

    public static MenuItem setOnActionExpandListener(MenuItem r100, final OnActionExpandListener r101) {
        return r100.setOnActionExpandListener(new AnonymousClass1(r101));
    }

    @ReplaceWith(expression = "item.setShowAsAction(actionEnum)")
    public static void setShowAsAction(MenuItem r100, int r101) {
        r100.setShowAsAction(r101);
    }

    public static void setTooltipText(MenuItem r100, CharSequence r101) {
        if ((r100 instanceof SupportMenuItem) == false) goto L6;
        ((SupportMenuItem) r100).setTooltipText(r101);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        Api26Impl.setTooltipText(r100, r101);
        return;
    }

    @ReplaceWith(expression = "item.setActionView(view)")
    public static MenuItem setActionView(MenuItem r100, View r101) {
        return r100.setActionView(r101);
    }

    public static void setAlphabeticShortcut(MenuItem r100, char r101, int r102) {
        if ((r100 instanceof SupportMenuItem) == false) goto L6;
        ((SupportMenuItem) r100).setAlphabeticShortcut(r101, r102);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        Api26Impl.setAlphabeticShortcut(r100, r101, r102);
        return;
    }

    public static void setNumericShortcut(MenuItem r100, char r101, int r102) {
        if ((r100 instanceof SupportMenuItem) == false) goto L6;
        ((SupportMenuItem) r100).setNumericShortcut(r101, r102);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        Api26Impl.setNumericShortcut(r100, r101, r102);
        return;
    }

    public static void setShortcut(MenuItem r100, char r101, char r102, int r103, int r104) {
        if ((r100 instanceof SupportMenuItem) == false) goto L6;
        ((SupportMenuItem) r100).setShortcut(r101, r102, r103, r104);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        Api26Impl.setShortcut(r100, r101, r102, r103, r104);
        return;
    }
}
