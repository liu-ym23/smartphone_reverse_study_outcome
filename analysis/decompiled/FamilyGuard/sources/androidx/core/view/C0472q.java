package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

/* renamed from: androidx.core.view.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0472q {

    /* renamed from: androidx.core.view.q$a */
    static class a {
        static int a(MenuItem menuItem) {
            return menuItem.getAlphabeticModifiers();
        }

        static CharSequence b(MenuItem menuItem) {
            return menuItem.getContentDescription();
        }

        static ColorStateList c(MenuItem menuItem) {
            return menuItem.getIconTintList();
        }

        static PorterDuff.Mode d(MenuItem menuItem) {
            return menuItem.getIconTintMode();
        }

        static int e(MenuItem menuItem) {
            return menuItem.getNumericModifiers();
        }

        static CharSequence f(MenuItem menuItem) {
            return menuItem.getTooltipText();
        }

        static MenuItem g(MenuItem menuItem, char c6, int i5) {
            return menuItem.setAlphabeticShortcut(c6, i5);
        }

        static MenuItem h(MenuItem menuItem, CharSequence charSequence) {
            return menuItem.setContentDescription(charSequence);
        }

        static MenuItem i(MenuItem menuItem, ColorStateList colorStateList) {
            return menuItem.setIconTintList(colorStateList);
        }

        static MenuItem j(MenuItem menuItem, PorterDuff.Mode mode) {
            return menuItem.setIconTintMode(mode);
        }

        static MenuItem k(MenuItem menuItem, char c6, int i5) {
            return menuItem.setNumericShortcut(c6, i5);
        }

        static MenuItem l(MenuItem menuItem, char c6, char c7, int i5, int i6) {
            return menuItem.setShortcut(c6, c7, i5, i6);
        }

        static MenuItem m(MenuItem menuItem, CharSequence charSequence) {
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

    public static MenuItem d(MenuItem menuItem, AbstractC0457b abstractC0457b) {
        if (menuItem instanceof A.b) {
            return ((A.b) menuItem).a(abstractC0457b);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    @Deprecated
    public static MenuItem e(MenuItem menuItem, int i5) {
        return menuItem.setActionView(i5);
    }

    @Deprecated
    public static MenuItem f(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    public static void g(MenuItem menuItem, char c6, int i5) {
        if (menuItem instanceof A.b) {
            ((A.b) menuItem).setAlphabeticShortcut(c6, i5);
        } else {
            a.g(menuItem, c6, i5);
        }
    }

    public static void h(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof A.b) {
            ((A.b) menuItem).setContentDescription(charSequence);
        } else {
            a.h(menuItem, charSequence);
        }
    }

    public static void i(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof A.b) {
            ((A.b) menuItem).setIconTintList(colorStateList);
        } else {
            a.i(menuItem, colorStateList);
        }
    }

    public static void j(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof A.b) {
            ((A.b) menuItem).setIconTintMode(mode);
        } else {
            a.j(menuItem, mode);
        }
    }

    public static void k(MenuItem menuItem, char c6, int i5) {
        if (menuItem instanceof A.b) {
            ((A.b) menuItem).setNumericShortcut(c6, i5);
        } else {
            a.k(menuItem, c6, i5);
        }
    }

    @Deprecated
    public static void l(MenuItem menuItem, int i5) {
        menuItem.setShowAsAction(i5);
    }

    public static void m(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof A.b) {
            ((A.b) menuItem).setTooltipText(charSequence);
        } else {
            a.m(menuItem, charSequence);
        }
    }
}
