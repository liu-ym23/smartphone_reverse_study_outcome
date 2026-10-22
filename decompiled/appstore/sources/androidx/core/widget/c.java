package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import androidx.annotation.DoNotInline;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    public static class a {
        @DoNotInline
        public static ColorStateList a(CompoundButton r10) {
            return r10.getButtonTintList();
        }

        @DoNotInline
        public static PorterDuff.Mode b(CompoundButton r10) {
            return r10.getButtonTintMode();
        }

        @DoNotInline
        public static void c(CompoundButton r10, ColorStateList r11) {
            r10.setButtonTintList(r11);
        }

        @DoNotInline
        public static void d(CompoundButton r10, PorterDuff.Mode r11) {
            r10.setButtonTintMode(r11);
        }
    }

    public static class b {
        @DoNotInline
        public static Drawable a(CompoundButton r10) {
            return r10.getButtonDrawable();
        }
    }

    public static Drawable a(CompoundButton r10) {
        return b.a(r10);
    }

    public static ColorStateList b(CompoundButton r10) {
        return a.a(r10);
    }

    public static void c(CompoundButton r10, ColorStateList r11) {
        a.c(r10, r11);
    }

    public static void d(CompoundButton r10, PorterDuff.Mode r11) {
        a.d(r10, r11);
    }
}
