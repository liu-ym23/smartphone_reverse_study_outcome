package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.MenuItem;
import androidx.annotation.DoNotInline;
import androidx.core.internal.view.SupportMenuItem;

/* JADX INFO: loaded from: classes.dex */
public abstract class MenuItemCompat {

    @Deprecated
    public interface OnActionExpandListener {
        boolean onMenuItemActionCollapse(MenuItem r10);

        boolean onMenuItemActionExpand(MenuItem r10);
    }

    public static class a {
        @DoNotInline
        public static int a(MenuItem r10) {
            return r10.getAlphabeticModifiers();
        }

        @DoNotInline
        public static CharSequence b(MenuItem r10) {
            return r10.getContentDescription();
        }

        @DoNotInline
        public static ColorStateList c(MenuItem r10) {
            return r10.getIconTintList();
        }

        @DoNotInline
        public static PorterDuff.Mode d(MenuItem r10) {
            return r10.getIconTintMode();
        }

        @DoNotInline
        public static int e(MenuItem r10) {
            return r10.getNumericModifiers();
        }

        @DoNotInline
        public static CharSequence f(MenuItem r10) {
            return r10.getTooltipText();
        }

        @DoNotInline
        public static MenuItem g(MenuItem r10, char r11, int r12) {
            return r10.setAlphabeticShortcut(r11, r12);
        }

        @DoNotInline
        public static MenuItem h(MenuItem r10, CharSequence r11) {
            return r10.setContentDescription(r11);
        }

        @DoNotInline
        public static MenuItem i(MenuItem r10, ColorStateList r11) {
            return r10.setIconTintList(r11);
        }

        @DoNotInline
        public static MenuItem j(MenuItem r10, PorterDuff.Mode r11) {
            return r10.setIconTintMode(r11);
        }

        @DoNotInline
        public static MenuItem k(MenuItem r10, char r11, int r12) {
            return r10.setNumericShortcut(r11, r12);
        }

        @DoNotInline
        public static MenuItem l(MenuItem r10, char r11, char r12, int r13, int r14) {
            return r10.setShortcut(r11, r12, r13, r14);
        }

        @DoNotInline
        public static MenuItem m(MenuItem r10, CharSequence r11) {
            return r10.setTooltipText(r11);
        }
    }

    public static MenuItem a(MenuItem r10, ActionProvider r11) {
        if ((r10 instanceof SupportMenuItem) == true) goto L5;
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return r10;
    L5:
        return ((SupportMenuItem) r10).setSupportActionProvider(r11);
    }

    public static void b(MenuItem r10, char r11, int r12) {
        if ((r10 instanceof SupportMenuItem) == false) goto L5;
        ((SupportMenuItem) r10).setAlphabeticShortcut(r11, r12);
        return;
    L5:
        a.g(r10, r11, r12);
    }

    public static void c(MenuItem r10, CharSequence r11) {
        if ((r10 instanceof SupportMenuItem) == false) goto L5;
        ((SupportMenuItem) r10).setContentDescription(r11);
        return;
    L5:
        a.h(r10, r11);
    }

    public static void d(MenuItem r10, ColorStateList r11) {
        if ((r10 instanceof SupportMenuItem) == false) goto L5;
        ((SupportMenuItem) r10).setIconTintList(r11);
        return;
    L5:
        a.i(r10, r11);
    }

    public static void e(MenuItem r10, PorterDuff.Mode r11) {
        if ((r10 instanceof SupportMenuItem) == false) goto L5;
        ((SupportMenuItem) r10).setIconTintMode(r11);
        return;
    L5:
        a.j(r10, r11);
    }

    public static void f(MenuItem r10, char r11, int r12) {
        if ((r10 instanceof SupportMenuItem) == false) goto L5;
        ((SupportMenuItem) r10).setNumericShortcut(r11, r12);
        return;
    L5:
        a.k(r10, r11, r12);
    }

    public static void g(MenuItem r10, CharSequence r11) {
        if ((r10 instanceof SupportMenuItem) == false) goto L5;
        ((SupportMenuItem) r10).setTooltipText(r11);
        return;
    L5:
        a.m(r10, r11);
    }
}
