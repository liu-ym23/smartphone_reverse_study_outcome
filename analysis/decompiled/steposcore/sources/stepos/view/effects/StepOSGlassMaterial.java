package stepos.view.effects;

import android.graphics.BackdropMaterialParams;
import android.graphics.Bitmap;
import android.graphics.RenderEffect;

/* loaded from: classes.dex */
public final class StepOSGlassMaterial {
    private StepOSGlassMaterial() {
    }

    public static RenderEffect createStepOSBlurEffect(float radius, int mode, float scale) {
        return RenderEffect.createStepOSBlurEffect(radius, mode, scale);
    }

    public static Object newGlassMaterialBuilder() {
        return new BackdropMaterialParams.Builder();
    }

    private static BackdropMaterialParams.Builder builder(Object builder) {
        return (BackdropMaterialParams.Builder) builder;
    }

    public static RenderEffect buildGlassMaterialEffect(Object builder, int tintColor, RenderEffect input) {
        BackdropMaterialParams material = builder(builder).build();
        if (input != null) {
            return RenderEffect.createGlassMaterialEffect(material, tintColor, input);
        }
        return RenderEffect.createGlassMaterialEffect(material, tintColor);
    }

    public static RenderEffect buildGlassTextEffect(Object builder, int tintColor, RenderEffect input, Bitmap glyphAlpha, float sdfScale, float erode) {
        BackdropMaterialParams material = builder(builder).build();
        return RenderEffect.createGlassTextEffect(material, tintColor, input, glyphAlpha, sdfScale, erode);
    }

    public static void gmSetGeometry(Object builder, float width, float height, float rTL, float rTR, float rBR, float rBL) {
        builder(builder).setGeometry(width, height, rTL, rTR, rBR, rBL);
    }

    public static void gmSetCornerSmoothness(Object builder, float smoothness) {
        builder(builder).setCornerSmoothness(smoothness);
    }

    public static void gmSetGlassText(Object builder, float sdfScale, float erode) {
        builder(builder).setGlassText(sdfScale, erode);
    }

    public static void gmSetBlend(Object builder, int blendMode, float blendColor, float blendAlpha) {
        builder(builder).setBlend(blendMode, blendColor, blendAlpha);
    }

    public static void gmSetBlendArray(Object builder, int[] types, int[] colorsArgb) {
        builder(builder).setBlendArray(types, colorsArgb);
    }

    public static void gmSetFrost(Object builder, float frost) {
        builder(builder).setFrost(frost);
    }

    public static void gmSetDispersion(Object builder, float dispersion) {
        builder(builder).setDispersion(dispersion);
    }

    public static void gmSetAmbient(Object builder, float ambient) {
        builder(builder).setAmbient(ambient);
    }

    public static void gmSetAnisoRim(Object builder, boolean on) {
        builder(builder).setAnisoRim(on);
    }

    public static void gmSetEdgeColor(Object builder, int colorArgb) {
        builder(builder).setEdgeColor(colorArgb);
    }

    public static void gmSetDarkColor(Object builder, int colorArgb) {
        builder(builder).setDarkColor(colorArgb);
    }

    public static void gmSetEdgeWidth(Object builder, float px) {
        builder(builder).setEdgeWidth(px);
    }

    public static void gmSetDarkWidth(Object builder, float px) {
        builder(builder).setDarkWidth(px);
    }

    public static void gmSetColorGradient(Object builder, int startArgb, int middleArgb, int endArgb, float midpoint, int direction) {
        builder(builder).setColorGradient(startArgb, middleArgb, endArgb, midpoint, direction);
    }

    public static void gmSetBlurGradient(Object builder, int mode, int scale) {
        builder(builder).setBlurGradient(mode, scale);
    }

    public static void gmSetStroke(Object builder, boolean enabled, float width, float softness, float intensity, float r, float g, float b, float a) {
        builder(builder).setStroke(enabled, width, softness, intensity, r, g, b, a);
    }

    public static void gmSetLightDirs(Object builder, float l0x, float l0y, float l1x, float l1y) {
        builder(builder).setLightDirs(l0x, l0y, l1x, l1y);
    }

    public static void gmSetStrokeSpread(Object builder, float spread) {
        builder(builder).setStrokeSpread(spread);
    }

    public static void gmSetRefraction(Object builder, boolean enabled, float strength, float width) {
        builder(builder).setRefraction(enabled, strength, width);
    }

    public static void gmSetDepthEffect(Object builder, float depthEffect) {
        builder(builder).setDepthEffect(depthEffect);
    }

    public static void gmSetInnerShadow(Object builder, boolean enabled, float r, float g, float b, float a, float radius, float offsetX, float offsetY, float intensity) {
        builder(builder).setInnerShadow(enabled, r, g, b, a, radius, offsetX, offsetY, intensity);
    }

    public static void gmSetUseShapeAlpha(Object builder, boolean use) {
        builder(builder).setUseShapeAlpha(use);
    }
}
