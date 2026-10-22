package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.ReplaceWith;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes17.dex */
public final class DrawableCompat {
    private static final String TAG = "DrawableCompat";
    private static Method sGetLayoutDirectionMethod;
    private static boolean sGetLayoutDirectionMethodFetched;
    private static Method sSetLayoutDirectionMethod;
    private static boolean sSetLayoutDirectionMethodFetched;

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static boolean canApplyTheme(Drawable r100) {
            return r100.canApplyTheme();
        }

        public static ColorFilter getColorFilter(Drawable r100) {
            return r100.getColorFilter();
        }

        public static void applyTheme(Drawable r100, Resources.Theme r101) {
            r100.applyTheme(r101);
        }

        public static void setTint(Drawable r100, int r101) {
            r100.setTint(r101);
        }

        public static void setTintList(Drawable r100, ColorStateList r101) {
            r100.setTintList(r101);
        }

        public static void setTintMode(Drawable r100, PorterDuff.Mode r101) {
            r100.setTintMode(r101);
        }

        public static void setHotspot(Drawable r100, float r101, float r102) {
            r100.setHotspot(r101, r102);
        }

        public static void inflate(Drawable r100, Resources r101, XmlPullParser r102, AttributeSet r103, Resources.Theme r104) throws XmlPullParserException, IOException {
            r100.inflate(r101, r102, r103, r104);
        }

        public static void setHotspotBounds(Drawable r100, int r101, int r102, int r103, int r104) {
            r100.setHotspotBounds(r101, r102, r103, r104);
        }
    }

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static int getLayoutDirection(Drawable r100) {
            return r100.getLayoutDirection();
        }

        public static boolean setLayoutDirection(Drawable r100, int r101) {
            return r100.setLayoutDirection(r101);
        }
    }

    private DrawableCompat() {
    }

    public static boolean canApplyTheme(Drawable r100) {
        return Api21Impl.canApplyTheme(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void clearColorFilter(Drawable r100) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        r100.clearColorFilter();
        return;
    L5:
        r100.clearColorFilter();
        if ((r100 instanceof InsetDrawable) == false) goto L9;
        clearColorFilter(((InsetDrawable) r100).getDrawable());
        return;
    L9:
        if ((r100 instanceof WrappedDrawable) == false) goto L12;
        clearColorFilter(((WrappedDrawable) r100).getWrappedDrawable());
        return;
    L12:
        if ((r100 instanceof DrawableContainer) == false) goto L27;
        DrawableContainer.DrawableContainerState r101 = (DrawableContainer.DrawableContainerState) ((DrawableContainer) r100).getConstantState();
        if (r101 == null) goto L28;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L16:
        if (r103 >= r102) goto L29;
        Drawable r104 = r101.getChild(r103);
        if (r104 == null) goto L20;
        clearColorFilter(r104);
    L20:
        r103 = r103 + 1;
        goto L16
    L29:
        return;
    L28:
        return;
    }

    @ReplaceWith(expression = "drawable.getAlpha()")
    public static int getAlpha(Drawable r100) {
        return r100.getAlpha();
    }

    public static ColorFilter getColorFilter(Drawable r100) {
        return Api21Impl.getColorFilter(r100);
    }

    public static int getLayoutDirection(Drawable r100) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.getLayoutDirection(r100);
    L7:
        if (sGetLayoutDirectionMethodFetched == false) goto L18;
    L11:
        Method r101 = sGetLayoutDirectionMethod;
        if (r101 != null) goto L20;
    L16:
        return 0;
    L20:
        return ((Integer) r101.invoke(r100, new Object[0])).intValue();
    L15:
        sGetLayoutDirectionMethod = null;
        goto L16
    L18:
        Method r102 = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);     // Catch: NoSuchMethodException -> L17
        sGetLayoutDirectionMethod = r102;     // Catch: NoSuchMethodException -> L17
        r102.setAccessible(true);     // Catch: NoSuchMethodException -> L17
    L10:
        sGetLayoutDirectionMethodFetched = true;
        goto L11
    }

    @ReplaceWith(expression = "drawable.isAutoMirrored()")
    public static boolean isAutoMirrored(Drawable r100) {
        return r100.isAutoMirrored();
    }

    @ReplaceWith(expression = "drawable.jumpToCurrentState()")
    public static void jumpToCurrentState(Drawable r100) {
        r100.jumpToCurrentState();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T unwrap(Drawable r100) {
        if ((r100 instanceof WrappedDrawable) == true) goto L5;
        return r100;
    L5:
        return (T) ((WrappedDrawable) r100).getWrappedDrawable();
    }

    public static Drawable wrap(Drawable r100) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        return r100;
    L6:
        if ((r100 instanceof TintAwareDrawable) == false) goto L8;
        return r100;
    L8:
        return new WrappedDrawableApi21(r100);
    }

    public static void applyTheme(Drawable r100, Resources.Theme r101) {
        Api21Impl.applyTheme(r100, r101);
    }

    @ReplaceWith(expression = "drawable.setAutoMirrored(mirrored)")
    public static void setAutoMirrored(Drawable r100, boolean r101) {
        r100.setAutoMirrored(r101);
    }

    public static boolean setLayoutDirection(Drawable r100, int r101) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.setLayoutDirection(r100, r101);
    L7:
        if (sSetLayoutDirectionMethodFetched == false) goto L19;
    L10:
        Method r102 = sSetLayoutDirectionMethod;
        if (r102 != null) goto L17;
    L15:
        return false;
    L17:
        r102.invoke(r100, new Object[]{Integer.valueOf(r101)});     // Catch: Exception -> L14
        return true;
    L14:
        sSetLayoutDirectionMethod = null;
        goto L15
    L19:
        Method r103 = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});     // Catch: NoSuchMethodException -> L16
        sSetLayoutDirectionMethod = r103;     // Catch: NoSuchMethodException -> L16
        r103.setAccessible(true);     // Catch: NoSuchMethodException -> L16
    L9:
        sSetLayoutDirectionMethodFetched = true;
        goto L10
    }

    public static void setTint(Drawable r100, int r101) {
        Api21Impl.setTint(r100, r101);
    }

    public static void setTintList(Drawable r100, ColorStateList r101) {
        Api21Impl.setTintList(r100, r101);
    }

    public static void setTintMode(Drawable r100, PorterDuff.Mode r101) {
        Api21Impl.setTintMode(r100, r101);
    }

    public static void setHotspot(Drawable r100, float r101, float r102) {
        Api21Impl.setHotspot(r100, r101, r102);
    }

    public static void inflate(Drawable r100, Resources r101, XmlPullParser r102, AttributeSet r103, Resources.Theme r104) throws XmlPullParserException, IOException {
        Api21Impl.inflate(r100, r101, r102, r103, r104);
    }

    public static void setHotspotBounds(Drawable r100, int r101, int r102, int r103, int r104) {
        Api21Impl.setHotspotBounds(r100, r101, r102, r103, r104);
    }
}
