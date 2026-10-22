package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;
import androidx.annotation.ReplaceWith;

/* JADX INFO: loaded from: classes17.dex */
public final class CheckedTextViewCompat {

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static ColorStateList getCheckMarkTintList(CheckedTextView r100) {
            return r100.getCheckMarkTintList();
        }

        public static PorterDuff.Mode getCheckMarkTintMode(CheckedTextView r100) {
            return r100.getCheckMarkTintMode();
        }

        public static void setCheckMarkTintList(CheckedTextView r100, ColorStateList r101) {
            r100.setCheckMarkTintList(r101);
        }

        public static void setCheckMarkTintMode(CheckedTextView r100, PorterDuff.Mode r101) {
            r100.setCheckMarkTintMode(r101);
        }
    }

    private CheckedTextViewCompat() {
    }

    @ReplaceWith(expression = "textView.getCheckMarkDrawable()")
    public static Drawable getCheckMarkDrawable(CheckedTextView r100) {
        return r100.getCheckMarkDrawable();
    }

    public static ColorStateList getCheckMarkTintList(CheckedTextView r100) {
        return Api21Impl.getCheckMarkTintList(r100);
    }

    public static PorterDuff.Mode getCheckMarkTintMode(CheckedTextView r100) {
        return Api21Impl.getCheckMarkTintMode(r100);
    }

    public static void setCheckMarkTintList(CheckedTextView r100, ColorStateList r101) {
        Api21Impl.setCheckMarkTintList(r100, r101);
    }

    public static void setCheckMarkTintMode(CheckedTextView r100, PorterDuff.Mode r101) {
        Api21Impl.setCheckMarkTintMode(r100, r101);
    }
}
