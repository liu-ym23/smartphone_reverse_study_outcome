package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.view.ActionMode;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class TextViewCompat {

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface AutoSizeTextType {
    }

    public static class a {
        @DoNotInline
        public static boolean a(TextView r10) {
            return r10.getIncludeFontPadding();
        }

        @DoNotInline
        public static int b(TextView r10) {
            return r10.getMaxLines();
        }

        @DoNotInline
        public static int c(TextView r10) {
            return r10.getMinLines();
        }
    }

    public static class b {
        @DoNotInline
        public static Drawable[] a(TextView r10) {
            return r10.getCompoundDrawablesRelative();
        }

        @DoNotInline
        public static int b(View r10) {
            return r10.getLayoutDirection();
        }

        @DoNotInline
        public static int c(View r10) {
            return r10.getTextDirection();
        }

        @DoNotInline
        public static Locale d(TextView r10) {
            return r10.getTextLocale();
        }

        @DoNotInline
        public static void e(TextView r10, Drawable r11, Drawable r12, Drawable r13, Drawable r14) {
            r10.setCompoundDrawablesRelative(r11, r12, r13, r14);
        }

        @DoNotInline
        public static void f(TextView r10, int r11, int r12, int r13, int r14) {
            r10.setCompoundDrawablesRelativeWithIntrinsicBounds(r11, r12, r13, r14);
        }

        @DoNotInline
        public static void g(TextView r10, Drawable r11, Drawable r12, Drawable r13, Drawable r14) {
            r10.setCompoundDrawablesRelativeWithIntrinsicBounds(r11, r12, r13, r14);
        }

        @DoNotInline
        public static void h(View r10, int r11) {
            r10.setTextDirection(r11);
        }
    }

    public static class c {
        @DoNotInline
        public static int a(TextView r10) {
            return r10.getBreakStrategy();
        }

        @DoNotInline
        public static ColorStateList b(TextView r10) {
            return r10.getCompoundDrawableTintList();
        }

        @DoNotInline
        public static PorterDuff.Mode c(TextView r10) {
            return r10.getCompoundDrawableTintMode();
        }

        @DoNotInline
        public static int d(TextView r10) {
            return r10.getHyphenationFrequency();
        }

        @DoNotInline
        public static void e(TextView r10, int r11) {
            r10.setBreakStrategy(r11);
        }

        @DoNotInline
        public static void f(TextView r10, ColorStateList r11) {
            r10.setCompoundDrawableTintList(r11);
        }

        @DoNotInline
        public static void g(TextView r10, PorterDuff.Mode r11) {
            r10.setCompoundDrawableTintMode(r11);
        }

        @DoNotInline
        public static void h(TextView r10, int r11) {
            r10.setHyphenationFrequency(r11);
        }
    }

    public static class d {
        @DoNotInline
        public static String[] a(DecimalFormatSymbols r10) {
            return r10.getDigitStrings();
        }

        @DoNotInline
        public static PrecomputedText.Params b(TextView r10) {
            return r10.getTextMetricsParams();
        }

        @DoNotInline
        public static void c(TextView r10, int r11) {
            r10.setFirstBaselineToTopHeight(r11);
        }
    }

    public static class e implements ActionMode.Callback {
        public abstract ActionMode.Callback a();
    }

    public static Drawable[] a(TextView r10) {
        return b.a(r10);
    }

    public static int b(TextView r10) {
        return r10.getPaddingTop() - r10.getPaint().getFontMetricsInt().top;
    }

    public static int c(TextView r10) {
        return r10.getPaddingBottom() + r10.getPaint().getFontMetricsInt().bottom;
    }

    public static int d(TextView r10) {
        return a.b(r10);
    }

    public static int e(TextDirectionHeuristic r10) {
        TextDirectionHeuristic r11 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        if (r10 != r11) goto L5;
        return 1;
    L5:
        TextDirectionHeuristic r12 = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        if (r10 != r12) goto L9;
        return 1;
    L9:
        if (r10 != TextDirectionHeuristics.ANYRTL_LTR) goto L13;
        return 2;
    L13:
        if (r10 != TextDirectionHeuristics.LTR) goto L17;
        return 3;
    L17:
        if (r10 != TextDirectionHeuristics.RTL) goto L21;
        return 4;
    L21:
        if (r10 != TextDirectionHeuristics.LOCALE) goto L24;
        return 5;
    L24:
        if (r10 != r12) goto L27;
        return 6;
    L27:
        if (r10 != r11) goto L30;
        return 7;
    L30:
        return 1;
    }

    public static androidx.core.text.c.a f(TextView r10) {
        return new androidx.core.text.c.a(d.b(r10));
    }

    public static void g(TextView r10, ColorStateList r11) {
        androidx.core.util.e.g(r10);
        c.f(r10, r11);
    }

    public static void h(TextView r10, PorterDuff.Mode r11) {
        androidx.core.util.e.g(r10);
        c.g(r10, r11);
    }

    public static void i(TextView r10, Drawable r11, Drawable r12, Drawable r13, Drawable r14) {
        b.e(r10, r11, r12, r13, r14);
    }

    public static void j(TextView r10, int r11) {
        androidx.core.util.e.d(r11);
        d.c(r10, r11);
    }

    public static void k(TextView r10, int r11) {
        androidx.core.util.e.d(r11);
        Paint.FontMetricsInt r12 = r10.getPaint().getFontMetricsInt();
        if (a.a(r10) == false) goto L5;
        int r13 = r12.bottom;
    L7:
        if (r11 <= Math.abs(r13)) goto L10;
        int r14 = r11 - r13;
        r10.setPadding(r10.getPaddingLeft(), r10.getPaddingTop(), r10.getPaddingRight(), r14);
        return;
    L10:
        return;
    L5:
        r13 = r12.descent;
        goto L7
    }

    public static void l(TextView r10, int r11) {
        androidx.core.util.e.d(r11);
        int r12 = r10.getPaint().getFontMetricsInt(null);
        if (r11 == r12) goto L6;
        r10.setLineSpacing(r11 - r12, 1.0f);
        return;
    }

    public static void m(TextView r10, androidx.core.text.c r11) {
        throw null;
    }

    public static void n(TextView r10, int r11) {
        r10.setTextAppearance(r11);
    }

    public static void o(TextView r10, androidx.core.text.c.a r11) {
        b.h(r10, e(r11.d()));
        r10.getPaint().set(r11.e());
        c.e(r10, r11.b());
        c.h(r10, r11.c());
    }

    public static ActionMode.Callback p(ActionMode.Callback r10) {
        if ((r10 instanceof e) == true) goto L5;
        return r10;
    L5:
        return ((e) r10).a();
    }

    public static ActionMode.Callback q(TextView r10, ActionMode.Callback r11) {
        return r11;
    }
}
