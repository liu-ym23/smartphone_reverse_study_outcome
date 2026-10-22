package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.core.internal.view.SupportMenuItem;

/* JADX INFO: loaded from: classes.dex */
public final class MenuItemCompat {

    @Deprecated
    public static final int SHOW_AS_ACTION_ALWAYS = 2;

    @Deprecated
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;

    @Deprecated
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;

    @Deprecated
    public static final int SHOW_AS_ACTION_NEVER = 0;

    @Deprecated
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
    private static final String TAG = "MenuItemCompat";

    static class Api26Impl {
        private Api26Impl() {
        }

        static MenuItem setContentDescription(MenuItem r0, CharSequence r1) {
            return r0.setContentDescription(r1);
        }

        static CharSequence getContentDescription(MenuItem r0) {
            return r0.getContentDescription();
        }

        static MenuItem setTooltipText(MenuItem r0, CharSequence r1) {
            return r0.setTooltipText(r1);
        }

        static CharSequence getTooltipText(MenuItem r0) {
            return r0.getTooltipText();
        }

        static MenuItem setShortcut(MenuItem r0, char r1, char r2, int r3, int r4) {
            return r0.setShortcut(r1, r2, r3, r4);
        }

        static MenuItem setNumericShortcut(MenuItem r0, char r1, int r2) {
            return r0.setNumericShortcut(r1, r2);
        }

        static int getNumericModifiers(MenuItem r0) {
            return r0.getNumericModifiers();
        }

        static MenuItem setAlphabeticShortcut(MenuItem r0, char r1, int r2) {
            return r0.setAlphabeticShortcut(r1, r2);
        }

        static int getAlphabeticModifiers(MenuItem r0) {
            return r0.getAlphabeticModifiers();
        }

        static MenuItem setIconTintList(MenuItem r0, ColorStateList r1) {
            return r0.setIconTintList(r1);
        }

        static ColorStateList getIconTintList(MenuItem r0) {
            return r0.getIconTintList();
        }

        static MenuItem setIconTintMode(MenuItem r0, PorterDuff.Mode r1) {
            return r0.setIconTintMode(r1);
        }

        static PorterDuff.Mode getIconTintMode(MenuItem r0) {
            return r0.getIconTintMode();
        }
    }

    @Deprecated
    public interface OnActionExpandListener {
        boolean onMenuItemActionCollapse(MenuItem r1);

        boolean onMenuItemActionExpand(MenuItem r1);
    }

    @Deprecated
    public static void setShowAsAction(MenuItem r0, int r1) {
        r0.setShowAsAction(r1);
    }

    @Deprecated
    public static MenuItem setActionView(MenuItem r0, View r1) {
        return r0.setActionView(r1);
    }

    @Deprecated
    public static MenuItem setActionView(MenuItem r0, int r1) {
        return r0.setActionView(r1);
    }

    @Deprecated
    public static View getActionView(MenuItem r0) {
        return r0.getActionView();
    }

    public static MenuItem setActionProvider(MenuItem r1, ActionProvider r2) {
        if ((r1 instanceof SupportMenuItem) == true) goto L5;
        Log.w(TAG, "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return r1;
    L5:
        return ((SupportMenuItem) r1).setSupportActionProvider(r2);
    }

    public static ActionProvider getActionProvider(MenuItem r1) {
        if ((r1 instanceof SupportMenuItem) == true) goto L5;
        Log.w(TAG, "getActionProvider: item does not implement SupportMenuItem; returning null");
        return null;
    L5:
        return ((SupportMenuItem) r1).getSupportActionProvider();
    }

    @Deprecated
    public static boolean expandActionView(MenuItem r0) {
        return r0.expandActionView();
    }

    @Deprecated
    public static boolean collapseActionView(MenuItem r0) {
        return r0.collapseActionView();
    }

    @Deprecated
    public static boolean isActionViewExpanded(MenuItem r0) {
        return r0.isActionViewExpanded();
    }

    @Deprecated
    public static MenuItem setOnActionExpandListener(MenuItem r1, final OnActionExpandListener r2) {
        return r1.setOnActionExpandListener(new AnonymousClass1(r2));
    }

    public static void setContentDescription(MenuItem r1, CharSequence r2) {
        if ((r1 instanceof SupportMenuItem) == false) goto L5;
        ((SupportMenuItem) r1).setContentDescription(r2);
        return;
    L5:
        Api26Impl.setContentDescription(r1, r2);
    }

    public static CharSequence getContentDescription(MenuItem r1) {
        if ((r1 instanceof SupportMenuItem) == false) goto L7;
        return ((SupportMenuItem) r1).getContentDescription();
    L7:
        return Api26Impl.getContentDescription(r1);
    }

    public static void setTooltipText(MenuItem r1, CharSequence r2) {
        if ((r1 instanceof SupportMenuItem) == false) goto L5;
        ((SupportMenuItem) r1).setTooltipText(r2);
        return;
    L5:
        Api26Impl.setTooltipText(r1, r2);
    }

    public static CharSequence getTooltipText(MenuItem r1) {
        if ((r1 instanceof SupportMenuItem) == false) goto L7;
        return ((SupportMenuItem) r1).getTooltipText();
    L7:
        return Api26Impl.getTooltipText(r1);
    }

    public static void setShortcut(MenuItem r1, char r2, char r3, int r4, int r5) {
        if ((r1 instanceof SupportMenuItem) == false) goto L5;
        ((SupportMenuItem) r1).setShortcut(r2, r3, r4, r5);
        return;
    L5:
        Api26Impl.setShortcut(r1, r2, r3, r4, r5);
    }

    public static void setNumericShortcut(MenuItem r1, char r2, int r3) {
        if ((r1 instanceof SupportMenuItem) == false) goto L5;
        ((SupportMenuItem) r1).setNumericShortcut(r2, r3);
        return;
    L5:
        Api26Impl.setNumericShortcut(r1, r2, r3);
    }

    public static int getNumericModifiers(MenuItem r1) {
        if ((r1 instanceof SupportMenuItem) == false) goto L7;
        return ((SupportMenuItem) r1).getNumericModifiers();
    L7:
        return Api26Impl.getNumericModifiers(r1);
    }

    public static void setAlphabeticShortcut(MenuItem r1, char r2, int r3) {
        if ((r1 instanceof SupportMenuItem) == false) goto L5;
        ((SupportMenuItem) r1).setAlphabeticShortcut(r2, r3);
        return;
    L5:
        Api26Impl.setAlphabeticShortcut(r1, r2, r3);
    }

    public static int getAlphabeticModifiers(MenuItem r1) {
        if ((r1 instanceof SupportMenuItem) == false) goto L7;
        return ((SupportMenuItem) r1).getAlphabeticModifiers();
    L7:
        return Api26Impl.getAlphabeticModifiers(r1);
    }

    public static void setIconTintList(MenuItem r1, ColorStateList r2) {
        if ((r1 instanceof SupportMenuItem) == false) goto L5;
        ((SupportMenuItem) r1).setIconTintList(r2);
        return;
    L5:
        Api26Impl.setIconTintList(r1, r2);
    }

    public static ColorStateList getIconTintList(MenuItem r1) {
        if ((r1 instanceof SupportMenuItem) == false) goto L7;
        return ((SupportMenuItem) r1).getIconTintList();
    L7:
        return Api26Impl.getIconTintList(r1);
    }

    public static void setIconTintMode(MenuItem r1, PorterDuff.Mode r2) {
        if ((r1 instanceof SupportMenuItem) == false) goto L5;
        ((SupportMenuItem) r1).setIconTintMode(r2);
        return;
    L5:
        Api26Impl.setIconTintMode(r1, r2);
    }

    public static PorterDuff.Mode getIconTintMode(MenuItem r1) {
        if ((r1 instanceof SupportMenuItem) == false) goto L7;
        return ((SupportMenuItem) r1).getIconTintMode();
    L7:
        return Api26Impl.getIconTintMode(r1);
    }

    private MenuItemCompat() {
    }
}
