package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import v0.InterfaceMenuItemC5651b;

/* renamed from: androidx.core.view.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1329q {

    /* renamed from: androidx.core.view.q$a */
    public static class a {
        public static MenuItem a(MenuItem menuItem, char c10, int i10) {
            return menuItem.setAlphabeticShortcut(c10, i10);
        }

        public static MenuItem b(MenuItem menuItem, CharSequence charSequence) {
            return menuItem.setContentDescription(charSequence);
        }

        public static MenuItem c(MenuItem menuItem, ColorStateList colorStateList) {
            return menuItem.setIconTintList(colorStateList);
        }

        public static MenuItem d(MenuItem menuItem, PorterDuff.Mode mode) {
            return menuItem.setIconTintMode(mode);
        }

        public static MenuItem e(MenuItem menuItem, char c10, int i10) {
            return menuItem.setNumericShortcut(c10, i10);
        }

        public static MenuItem f(MenuItem menuItem, CharSequence charSequence) {
            return menuItem.setTooltipText(charSequence);
        }
    }

    @Deprecated
    public static boolean a(MenuItem menuItem) {
        return menuItem.expandActionView();
    }

    @Deprecated
    public static View b(MenuItem menuItem) {
        return menuItem.getActionView();
    }

    @Deprecated
    public static boolean c(MenuItem menuItem) {
        return menuItem.isActionViewExpanded();
    }

    public static MenuItem d(MenuItem menuItem, AbstractC1314b abstractC1314b) {
        if (menuItem instanceof InterfaceMenuItemC5651b) {
            return ((InterfaceMenuItemC5651b) menuItem).b(abstractC1314b);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    @Deprecated
    public static MenuItem e(MenuItem menuItem, int i10) {
        return menuItem.setActionView(i10);
    }

    @Deprecated
    public static MenuItem f(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    public static void g(MenuItem menuItem, char c10, int i10) {
        if (menuItem instanceof InterfaceMenuItemC5651b) {
            ((InterfaceMenuItemC5651b) menuItem).setAlphabeticShortcut(c10, i10);
        } else {
            a.a(menuItem, c10, i10);
        }
    }

    public static void h(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof InterfaceMenuItemC5651b) {
            ((InterfaceMenuItemC5651b) menuItem).setContentDescription(charSequence);
        } else {
            a.b(menuItem, charSequence);
        }
    }

    public static void i(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof InterfaceMenuItemC5651b) {
            ((InterfaceMenuItemC5651b) menuItem).setIconTintList(colorStateList);
        } else {
            a.c(menuItem, colorStateList);
        }
    }

    public static void j(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof InterfaceMenuItemC5651b) {
            ((InterfaceMenuItemC5651b) menuItem).setIconTintMode(mode);
        } else {
            a.d(menuItem, mode);
        }
    }

    public static void k(MenuItem menuItem, char c10, int i10) {
        if (menuItem instanceof InterfaceMenuItemC5651b) {
            ((InterfaceMenuItemC5651b) menuItem).setNumericShortcut(c10, i10);
        } else {
            a.e(menuItem, c10, i10);
        }
    }

    @Deprecated
    public static void l(MenuItem menuItem, int i10) {
        menuItem.setShowAsAction(i10);
    }

    public static void m(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof InterfaceMenuItemC5651b) {
            ((InterfaceMenuItemC5651b) menuItem).setTooltipText(charSequence);
        } else {
            a.f(menuItem, charSequence);
        }
    }
}
