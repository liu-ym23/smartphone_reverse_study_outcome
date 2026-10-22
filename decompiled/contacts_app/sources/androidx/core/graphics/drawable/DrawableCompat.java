package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class DrawableCompat {
    private static final String TAG = "DrawableCompat";
    private static Method sGetLayoutDirectionMethod;
    private static boolean sGetLayoutDirectionMethodFetched;
    private static Method sSetLayoutDirectionMethod;
    private static boolean sSetLayoutDirectionMethodFetched;

    static class Api19Impl {
        private Api19Impl() {
        }

        static void setAutoMirrored(Drawable r0, boolean r1) {
            r0.setAutoMirrored(r1);
        }

        static boolean isAutoMirrored(Drawable r0) {
            return r0.isAutoMirrored();
        }

        static int getAlpha(Drawable r0) {
            return r0.getAlpha();
        }

        static Drawable getChild(DrawableContainer.DrawableContainerState r0, int r1) {
            return r0.getChild(r1);
        }

        static Drawable getDrawable(InsetDrawable r0) {
            return r0.getDrawable();
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static void setHotspot(Drawable r0, float r1, float r2) {
            r0.setHotspot(r1, r2);
        }

        static void setTint(Drawable r0, int r1) {
            r0.setTint(r1);
        }

        static void setTintList(Drawable r0, ColorStateList r1) {
            r0.setTintList(r1);
        }

        static void setTintMode(Drawable r0, PorterDuff.Mode r1) {
            r0.setTintMode(r1);
        }

        static void applyTheme(Drawable r0, Resources.Theme r1) {
            r0.applyTheme(r1);
        }

        static boolean canApplyTheme(Drawable r0) {
            return r0.canApplyTheme();
        }

        static ColorFilter getColorFilter(Drawable r0) {
            return r0.getColorFilter();
        }

        static void inflate(Drawable r0, Resources r1, XmlPullParser r2, AttributeSet r3, Resources.Theme r4) throws XmlPullParserException, IOException {
            r0.inflate(r1, r2, r3, r4);
        }

        static void setHotspotBounds(Drawable r0, int r1, int r2, int r3, int r4) {
            r0.setHotspotBounds(r1, r2, r3, r4);
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static boolean setLayoutDirection(Drawable r0, int r1) {
            return r0.setLayoutDirection(r1);
        }

        static int getLayoutDirection(Drawable r0) {
            return r0.getLayoutDirection();
        }
    }

    public static Drawable wrap(Drawable r0) {
        return r0;
    }

    @Deprecated
    public static void jumpToCurrentState(Drawable r0) {
        r0.jumpToCurrentState();
    }

    public static void setAutoMirrored(Drawable r0, boolean r1) {
        Api19Impl.setAutoMirrored(r0, r1);
    }

    public static boolean isAutoMirrored(Drawable r0) {
        return Api19Impl.isAutoMirrored(r0);
    }

    public static void setHotspot(Drawable r0, float r1, float r2) {
        Api21Impl.setHotspot(r0, r1, r2);
    }

    public static void setHotspotBounds(Drawable r0, int r1, int r2, int r3, int r4) {
        Api21Impl.setHotspotBounds(r0, r1, r2, r3, r4);
    }

    public static void setTint(Drawable r0, int r1) {
        Api21Impl.setTint(r0, r1);
    }

    public static void setTintList(Drawable r0, ColorStateList r1) {
        Api21Impl.setTintList(r0, r1);
    }

    public static void setTintMode(Drawable r0, PorterDuff.Mode r1) {
        Api21Impl.setTintMode(r0, r1);
    }

    public static int getAlpha(Drawable r0) {
        return Api19Impl.getAlpha(r0);
    }

    public static void applyTheme(Drawable r0, Resources.Theme r1) {
        Api21Impl.applyTheme(r0, r1);
    }

    public static boolean canApplyTheme(Drawable r0) {
        return Api21Impl.canApplyTheme(r0);
    }

    public static ColorFilter getColorFilter(Drawable r0) {
        return Api21Impl.getColorFilter(r0);
    }

    public static void clearColorFilter(Drawable r0) {
        r0.clearColorFilter();
    }

    public static void inflate(Drawable r0, Resources r1, XmlPullParser r2, AttributeSet r3, Resources.Theme r4) throws XmlPullParserException, IOException {
        Api21Impl.inflate(r0, r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T unwrap(Drawable r1) {
        if ((r1 instanceof WrappedDrawable) == true) goto L5;
        return r1;
    L5:
        return (T) ((WrappedDrawable) r1).getWrappedDrawable();
    }

    public static boolean setLayoutDirection(Drawable r0, int r1) {
        return Api23Impl.setLayoutDirection(r0, r1);
    }

    public static int getLayoutDirection(Drawable r0) {
        return Api23Impl.getLayoutDirection(r0);
    }

    private DrawableCompat() {
    }
}
