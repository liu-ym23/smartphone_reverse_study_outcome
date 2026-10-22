package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.ImageView;
import androidx.annotation.DoNotInline;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    public static class a {
        @DoNotInline
        public static ColorStateList a(ImageView r10) {
            return r10.getImageTintList();
        }

        @DoNotInline
        public static PorterDuff.Mode b(ImageView r10) {
            return r10.getImageTintMode();
        }

        @DoNotInline
        public static void c(ImageView r10, ColorStateList r11) {
            r10.setImageTintList(r11);
        }

        @DoNotInline
        public static void d(ImageView r10, PorterDuff.Mode r11) {
            r10.setImageTintMode(r11);
        }
    }

    public static ColorStateList a(ImageView r10) {
        return a.a(r10);
    }

    public static PorterDuff.Mode b(ImageView r10) {
        return a.b(r10);
    }

    public static void c(ImageView r10, ColorStateList r11) {
        a.c(r10, r11);
    }

    public static void d(ImageView r10, PorterDuff.Mode r11) {
        a.d(r10, r11);
    }
}
