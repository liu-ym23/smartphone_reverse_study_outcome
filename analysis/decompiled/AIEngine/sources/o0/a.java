package o0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: o0.a$a, reason: collision with other inner class name */
    public static class C0115a {
        public static ColorFilter a(Drawable drawable) {
            return drawable.getColorFilter();
        }
    }

    public static void a(Drawable drawable, Resources.Theme theme) {
        drawable.applyTheme(theme);
    }

    public static boolean b(Drawable drawable) {
        return drawable.canApplyTheme();
    }

    @Deprecated
    public static int c(Drawable drawable) {
        return drawable.getAlpha();
    }

    @Deprecated
    public static boolean d(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    @Deprecated
    public static void e(Drawable drawable, boolean z) {
        drawable.setAutoMirrored(z);
    }

    public static void f(Drawable drawable, float f8, float f9) {
        drawable.setHotspot(f8, f9);
    }

    public static void g(Drawable drawable, int i10, int i11, int i12, int i13) {
        drawable.setHotspotBounds(i10, i11, i12, i13);
    }

    public static void h(Drawable drawable, int i10) {
        drawable.setTint(i10);
    }

    public static void i(Drawable drawable, ColorStateList colorStateList) {
        drawable.setTintList(colorStateList);
    }

    public static void j(Drawable drawable, PorterDuff.Mode mode) {
        drawable.setTintMode(mode);
    }
}
