package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: androidx.core.graphics.drawable.a$a, reason: collision with other inner class name */
    static class C0118a {
        static void a(Drawable drawable, Resources.Theme theme) {
            drawable.applyTheme(theme);
        }

        static boolean b(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        static ColorFilter c(Drawable drawable) {
            return drawable.getColorFilter();
        }

        static void d(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        static void e(Drawable drawable, float f5, float f6) {
            drawable.setHotspot(f5, f6);
        }

        static void f(Drawable drawable, int i5, int i6, int i7, int i8) {
            drawable.setHotspotBounds(i5, i6, i7, i8);
        }

        static void g(Drawable drawable, int i5) {
            drawable.setTint(i5);
        }

        static void h(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        static void i(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }
    }

    static class b {
        static int a(Drawable drawable) {
            return drawable.getLayoutDirection();
        }

        static boolean b(Drawable drawable, int i5) {
            return drawable.setLayoutDirection(i5);
        }
    }

    public static void a(Drawable drawable, Resources.Theme theme) {
        C0118a.a(drawable, theme);
    }

    public static boolean b(Drawable drawable) {
        return C0118a.b(drawable);
    }

    public static void c(Drawable drawable) {
        drawable.clearColorFilter();
    }

    public static int d(Drawable drawable) {
        return drawable.getAlpha();
    }

    public static ColorFilter e(Drawable drawable) {
        return C0118a.c(drawable);
    }

    public static int f(Drawable drawable) {
        return b.a(drawable);
    }

    public static void g(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        C0118a.d(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static boolean h(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    @Deprecated
    public static void i(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void j(Drawable drawable, boolean z5) {
        drawable.setAutoMirrored(z5);
    }

    public static void k(Drawable drawable, float f5, float f6) {
        C0118a.e(drawable, f5, f6);
    }

    public static void l(Drawable drawable, int i5, int i6, int i7, int i8) {
        C0118a.f(drawable, i5, i6, i7, i8);
    }

    public static boolean m(Drawable drawable, int i5) {
        return b.b(drawable, i5);
    }

    public static void n(Drawable drawable, int i5) {
        C0118a.g(drawable, i5);
    }

    public static void o(Drawable drawable, ColorStateList colorStateList) {
        C0118a.h(drawable, colorStateList);
    }

    public static void p(Drawable drawable, PorterDuff.Mode mode) {
        C0118a.i(drawable, mode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T q(Drawable drawable) {
        return drawable instanceof androidx.core.graphics.drawable.b ? (T) ((androidx.core.graphics.drawable.b) drawable).b() : drawable;
    }

    public static Drawable r(Drawable drawable) {
        return drawable;
    }
}
