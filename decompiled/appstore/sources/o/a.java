package o;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import androidx.annotation.DoNotInline;
import androidx.core.graphics.drawable.WrappedDrawable;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: o.a$a, reason: collision with other inner class name */
    public static class C0323a {
        @DoNotInline
        public static int a(Drawable r10) {
            return r10.getAlpha();
        }

        @DoNotInline
        public static Drawable b(DrawableContainer.DrawableContainerState r10, int r11) {
            return r10.getChild(r11);
        }

        @DoNotInline
        public static Drawable c(InsetDrawable r10) {
            return r10.getDrawable();
        }

        @DoNotInline
        public static boolean d(Drawable r10) {
            return r10.isAutoMirrored();
        }

        @DoNotInline
        public static void e(Drawable r10, boolean r11) {
            r10.setAutoMirrored(r11);
        }
    }

    public static class b {
        @DoNotInline
        public static void a(Drawable r10, Resources.Theme r11) {
            r10.applyTheme(r11);
        }

        @DoNotInline
        public static boolean b(Drawable r10) {
            return r10.canApplyTheme();
        }

        @DoNotInline
        public static ColorFilter c(Drawable r10) {
            return r10.getColorFilter();
        }

        @DoNotInline
        public static void d(Drawable r10, Resources r11, XmlPullParser r12, AttributeSet r13, Resources.Theme r14) throws XmlPullParserException, IOException {
            r10.inflate(r11, r12, r13, r14);
        }

        @DoNotInline
        public static void e(Drawable r10, float r11, float r12) {
            r10.setHotspot(r11, r12);
        }

        @DoNotInline
        public static void f(Drawable r10, int r11, int r12, int r13, int r14) {
            r10.setHotspotBounds(r11, r12, r13, r14);
        }

        @DoNotInline
        public static void g(Drawable r10, int r11) {
            r10.setTint(r11);
        }

        @DoNotInline
        public static void h(Drawable r10, ColorStateList r11) {
            r10.setTintList(r11);
        }

        @DoNotInline
        public static void i(Drawable r10, PorterDuff.Mode r11) {
            r10.setTintMode(r11);
        }
    }

    public static class c {
        @DoNotInline
        public static int a(Drawable r10) {
            return r10.getLayoutDirection();
        }

        @DoNotInline
        public static boolean b(Drawable r10, int r11) {
            return r10.setLayoutDirection(r11);
        }
    }

    public static void a(Drawable r10) {
        r10.clearColorFilter();
    }

    public static int b(Drawable r10) {
        return c.a(r10);
    }

    public static boolean c(Drawable r10) {
        return C0323a.d(r10);
    }

    public static void d(Drawable r10, boolean r11) {
        C0323a.e(r10, r11);
    }

    public static void e(Drawable r10, float r11, float r12) {
        b.e(r10, r11, r12);
    }

    public static void f(Drawable r10, int r11, int r12, int r13, int r14) {
        b.f(r10, r11, r12, r13, r14);
    }

    public static boolean g(Drawable r10, int r11) {
        return c.b(r10, r11);
    }

    public static void h(Drawable r10, int r11) {
        b.g(r10, r11);
    }

    public static void i(Drawable r10, ColorStateList r11) {
        b.h(r10, r11);
    }

    public static void j(Drawable r10, PorterDuff.Mode r11) {
        b.i(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Drawable k(Drawable r10) {
        if ((r10 instanceof WrappedDrawable) == true) goto L5;
        return r10;
    L5:
        return ((WrappedDrawable) r10).getWrappedDrawable();
    }

    public static Drawable l(Drawable r10) {
        return r10;
    }
}
