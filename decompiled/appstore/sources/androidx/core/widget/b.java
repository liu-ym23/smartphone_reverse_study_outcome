package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    public static class a {
        public static Drawable a(CheckedTextView r10) {
            return r10.getCheckMarkDrawable();
        }
    }

    /* JADX INFO: renamed from: androidx.core.widget.b$b, reason: collision with other inner class name */
    public static class C0022b {
        public static void a(CheckedTextView r10, ColorStateList r11) {
            r10.setCheckMarkTintList(r11);
        }

        public static void b(CheckedTextView r10, PorterDuff.Mode r11) {
            r10.setCheckMarkTintMode(r11);
        }
    }

    public static Drawable a(CheckedTextView r10) {
        return a.a(r10);
    }

    public static void b(CheckedTextView r10, ColorStateList r11) {
        C0022b.a(r10, r11);
    }

    public static void c(CheckedTextView r10, PorterDuff.Mode r11) {
        C0022b.b(r10, r11);
    }
}
