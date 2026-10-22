package stepos.view.effects;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewRootImpl;
import com.android.internal.graphics.backdrop.BackdropLayerDrawable;

/* loaded from: classes.dex */
public final class StepOSBackdropLayer {
    private static final String TAG = "StepOSBackdropLayer";

    private StepOSBackdropLayer() {
    }

    public static Drawable createBackdropLayerDrawable(View view) {
        try {
            ViewRootImpl viewRoot = view.getViewRootImpl();
            if (viewRoot == null) {
                Log.w(TAG, "ViewRootImpl is null (view not attached); skipping");
                return null;
            }
            return viewRoot.createBackdropLayerDrawable();
        } catch (LinkageError e) {
            Log.w(TAG, "createBackdropLayerDrawable unavailable on this build; skipping", e);
            return null;
        }
    }

    private static BackdropLayerDrawable cast(Drawable drawable) {
        return (BackdropLayerDrawable) drawable;
    }

    public static void setBlurRadius(Drawable drawable, int radius) {
        cast(drawable).setBlurRadius(radius);
    }

    public static void setDodge(Drawable drawable, float dodge) {
        cast(drawable).setDodge(dodge);
    }

    public static void setOverlay(Drawable drawable, float overlay) {
        cast(drawable).setOverlay(overlay);
    }

    public static void setColor(Drawable drawable, int color) {
        cast(drawable).setColor(color);
    }

    public static void setBlendArray(Drawable drawable, int[] types, int[] colors) {
        cast(drawable).setBlendArray(types, colors);
    }

    public static void setGlassStroke(Drawable drawable, boolean enabled, float width, float softness, float intensity, int color) {
        cast(drawable).setGlassStroke(enabled, width, softness, intensity, color);
    }

    public static void setLightDirs(Drawable drawable, float l0x, float l0y, float l1x, float l1y) {
        cast(drawable).setLightDirs(l0x, l0y, l1x, l1y);
    }

    public static void setStrokeSpread(Drawable drawable, float spread) {
        cast(drawable).setStrokeSpread(spread);
    }

    public static void setRefraction(Drawable drawable, boolean enabled, float strength, float width) {
        cast(drawable).setRefraction(enabled, strength, width);
    }

    public static void setRefractionDepth(Drawable drawable, float depth) {
        cast(drawable).setRefractionDepth(depth);
    }

    public static void setFrost(Drawable drawable, float frost) {
        cast(drawable).setFrost(frost);
    }

    public static void setDispersion(Drawable drawable, float dispersion) {
        cast(drawable).setDispersion(dispersion);
    }

    public static void setBlurGradient(Drawable drawable, int mode, int scale) {
        cast(drawable).setBlurGradient(mode, scale);
    }

    public static void setAmbient(Drawable drawable, float ambient) {
        cast(drawable).setAmbient(ambient);
    }

    public static void setAnisoRim(Drawable drawable, boolean on) {
        cast(drawable).setAnisoRim(on);
    }

    public static void setEdgeColors(Drawable drawable, int edgeColor, int darkColor) {
        cast(drawable).setEdgeColors(edgeColor, darkColor);
    }

    public static void setEdgeWidth(Drawable drawable, float px) {
        cast(drawable).setEdgeWidth(px);
    }

    public static void setDarkWidth(Drawable drawable, float px) {
        cast(drawable).setDarkWidth(px);
    }

    public static void setColorGradient(Drawable drawable, int startArgb, int middleArgb, int endArgb, float midpoint, int direction) {
        cast(drawable).setColorGradient(startArgb, middleArgb, endArgb, midpoint, direction);
    }

    public static void setInnerShadow(Drawable drawable, boolean enabled, int color, float radius, float offsetX, float offsetY, float intensity) {
        cast(drawable).setInnerShadow(enabled, color, radius, offsetX, offsetY, intensity);
    }

    public static void setCornerRadius(Drawable drawable, float cornerRadius) {
        cast(drawable).setCornerRadius(cornerRadius);
    }

    public static void setCornerRadius(Drawable drawable, float cornerRadiusTL, float cornerRadiusTR, float cornerRadiusBL, float cornerRadiusBR) {
        cast(drawable).setCornerRadius(cornerRadiusTL, cornerRadiusTR, cornerRadiusBL, cornerRadiusBR);
    }

    public static void setCornerSmoothness(Drawable drawable, float smoothness) {
        cast(drawable).setCornerSmoothness(smoothness);
    }

    public static void setGlassText(Drawable drawable, boolean enabled, float sdfScale, float erode) {
        cast(drawable).setGlassText(enabled, sdfScale, erode);
    }
}
