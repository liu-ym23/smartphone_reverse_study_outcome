package com.obric.oui.material;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.VectorDrawable;
import android.provider.Settings;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.obric.oui.blur.BlurConfig;
import com.obric.oui.color.BlendConfig;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.graphic.BlendMode;
import com.obric.oui.shadow.ShadowConfig;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class OMaterialHelper {
    private static final float[] DEFAULT_FLUID_PARAMS = null;
    private static final Map<String, Method> DRAWABLE_METHOD_CACHE = null;
    public static final String IEXT_EFFECT = "android.view.IExtEffect";
    public static final String IEXT_VIEW = "android.view.IExtView";
    private static final String KEY_SET_OBRIC_BLEND_EFFECT_CURVE = "setObricBlendEffect_curve";
    private static final String KEY_SET_OBRIC_BLEND_EFFECT_TO_SHADOW = "setObricBlendEffectToShadow";
    private static final String KEY_SET_OBRIC_BLEND_EFFECT_VECTOR = "setObricBlendEffect_vector";
    private static final Map<String, Method> METHOD_CACHE = null;
    public static final String OBRIC_CURRENT_EFFECT_ID = "obric_current_effect_id";
    private static final String TAG = "OMaterialHelper";
    private static Integer materialVersion;

    @Deprecated
    public static final enum LEGACY_BLEND_MODE extends Enum<LEGACY_BLEND_MODE> {
        private static final /* synthetic */ LEGACY_BLEND_MODE[] $VALUES = null;
        public static final LEGACY_BLEND_MODE COLOR_BURN = null;
        public static final LEGACY_BLEND_MODE COLOR_DODGE = null;
        public static final LEGACY_BLEND_MODE DEFAULT = null;
        public static final LEGACY_BLEND_MODE LUMINOSITY = null;
        public static final LEGACY_BLEND_MODE OVERLAY = null;
        public static final LEGACY_BLEND_MODE PLUS_DARKER = null;
        public static final LEGACY_BLEND_MODE PLUS_LIGHTER = null;
        public static final LEGACY_BLEND_MODE SOFT_LIGHT = null;

        public static LEGACY_BLEND_MODE valueOf(String r1) {
            return (LEGACY_BLEND_MODE) Enum.valueOf(LEGACY_BLEND_MODE.class, r1);
        }

        public static LEGACY_BLEND_MODE[] values() {
            return (LEGACY_BLEND_MODE[]) $VALUES.clone();
        }

        private LEGACY_BLEND_MODE(String r1, int r2) {
            super(r1, r2);
        }

        static {
            LEGACY_BLEND_MODE r0 = new LEGACY_BLEND_MODE("DEFAULT", 0);
            DEFAULT = r0;
            LEGACY_BLEND_MODE r1 = new LEGACY_BLEND_MODE("COLOR_BURN", 1);
            COLOR_BURN = r1;
            LEGACY_BLEND_MODE r3 = new LEGACY_BLEND_MODE("COLOR_DODGE", 2);
            COLOR_DODGE = r3;
            LEGACY_BLEND_MODE r5 = new LEGACY_BLEND_MODE("PLUS_DARKER", 3);
            PLUS_DARKER = r5;
            LEGACY_BLEND_MODE r7 = new LEGACY_BLEND_MODE("PLUS_LIGHTER", 4);
            PLUS_LIGHTER = r7;
            LEGACY_BLEND_MODE r9 = new LEGACY_BLEND_MODE("LUMINOSITY", 5);
            LUMINOSITY = r9;
            LEGACY_BLEND_MODE r11 = new LEGACY_BLEND_MODE("OVERLAY", 6);
            OVERLAY = r11;
            LEGACY_BLEND_MODE r13 = new LEGACY_BLEND_MODE("SOFT_LIGHT", 7);
            SOFT_LIGHT = r13;
            $VALUES = new LEGACY_BLEND_MODE[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }
    }

    private interface PaintApplier {
        void apply(Paint r1);
    }

    public static int getEffectOverlayLevel() {
        return 1;
    }

    static {
        METHOD_CACHE = new HashMap();
        DRAWABLE_METHOD_CACHE = new HashMap();
        DEFAULT_FLUID_PARAMS = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    private OMaterialHelper() {
    }

    public static boolean isSupportObricMaterial() {
        if (getMaterialApiVersion() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static int getMaterialApiVersion() {
        if (materialVersion != null) goto L6;
        materialVersion = Integer.valueOf(getApiLevel());
    L6:
        return materialVersion.intValue();
    }

    public static boolean isMaterialEffectEnabledIgnoreForce(Context r2) {
        if (isSupportObricMaterial() == true) goto L6;
        return false;
    L6:
        if (getMaterialLevel(r2) <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean isMaterialEffectEnabled(Context r2) {
        if (isSupportObricMaterial() == true) goto L6;
        return false;
    L6:
        if (getMaterialLevel(r2) <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean isWidgetMaterialEffectEnabled() {
        if (getMaterialApiVersion() < 3) goto L5;
        return true;
    L5:
        return false;
    }

    public static int getMaterialLevel(Context r2) {
        return Settings.Global.getInt(r2.getContentResolver(), OBRIC_CURRENT_EFFECT_ID, 2);
    }

    public static void applyMaterial(Object r1, boolean r2) {
        if (r2 == false) goto L4;
        setEffectSrcAndDraw(r1, 2, 1);
        return;
    L4:
        setEffectSrcAndDraw(r1, 0, 0);
    }

    public static void applyMaterialFromWindow(Object r1, boolean r2) {
        if (r2 == false) goto L4;
        setEffectSrcAndDraw(r1, 3, 1);
        return;
    L4:
        setEffectSrcAndDraw(r1, 0, 0);
    }

    public static void setMaterials(Object r2, MaterialConfig[] r3) {
        setMaterials(r2, 2, r3, 1);
    }

    public static void setMaterials(Object r1, int r2, MaterialConfig[] r3) {
        setMaterials(r1, r2, r3, 1);
    }

    public static void setMaterials(Object r4, int r5, MaterialConfig[] r6, int r7) {
        if (r6 != null) goto L4;
        return;
    L4:
        int r1 = 0;
        if (r6.length != 1) goto L9;
        setMaterialConfig(r4, r5, r7, r6[0]);
        return;
    L9:
        if (r1 >= r6.length) goto L14;
        if (r1 != 0) goto L12;
        int r0 = 1;
    L13:
        setMaterial(r4, r5, r6[r1], r0, r7);
        r1 = r1 + 1;
        goto L9
    L12:
        r0 = 2;
        goto L13
    }

    public static void setMaterialsFromWindow(Object r1, MaterialConfig[] r2) {
        setMaterials(r1, 3, r2);
    }

    public static void setMaterial(Object r1, MaterialConfig r2) {
        setMaterial(r1, 2, r2);
    }

    public static void setMaterial(Object r1, int r2, MaterialConfig r3) {
        setMaterialConfig(r1, r2, 1, r3);
    }

    public static void setMaterialFromWindow(Object r1, MaterialConfig r2) {
        setMaterial(r1, 3, r2);
    }

    public static void setMaterial(Object r1, int r2, MaterialConfig r3, int r4) {
        setMaterial(r1, r2, r3, r4, 1);
    }

    public static void setMaterial(Object r0, int r1, MaterialConfig r2, int r3, int r4) {
        setMaterialConfigByLevel(r0, r1, r4, r2, r3);
    }

    public static void setTextMaterial(TextView r1, MaterialConfig r2) {
        setTextMaterial(r1, 2, r2);
    }

    public static void setTextMaterial(TextView r1, int r2, MaterialConfig r3) {
        if (r1 == null) goto L11;
        if (r3 != null) goto L6;
        return;
    L6:
        if (isMaterialConfigValid(r3) == true) goto L9;
        setEffectSrcAndDraw(r1, 0, 0);
        return;
    L9:
        setEffectSrcAndDraw(r1, r2, 2);
        setMaterialForPaint(r1.getPaint(), r3);
        return;
    }

    public static void setTextMaterials(TextView r1, MaterialConfig[] r2) {
        setTextMaterials(r1, 2, r2);
    }

    public static void setTextMaterials(TextView r3, int r4, MaterialConfig[] r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        int r0 = 0;
    L6:
        if (r0 >= r5.length) goto L11;
        if (r0 != 0) goto L9;
        int r1 = 1;
    L10:
        setTextMaterial(r3, r4, r5[r0], r1);
        r0 = r0 + 1;
        goto L6
    L9:
        r1 = 2;
        goto L10
    }

    public static void setTextMaterial(TextView r5, int r6, MaterialConfig r7, int r8) {
        if (r5 == null) goto L18;
        if (r7 != null) goto L6;
        return;
    L6:
        if (isMaterialConfigValid(r7) == true) goto L9;
        setEffectSrcAndDraw(r5, 0, 0);
        return;
    L9:
        setEffectSrcAndDraw(r5, r6, 2);
        ShadowConfig[] r9 = r7.getShadow();
        if (r9 != null) goto L12;
    L16:
        setMaterialForPaint(r5.getPaint(), r7, r8);
        return;
    L12:
        if (r9.length <= 0) goto L16;
        if ((r5.getPaint() instanceof TextPaint) == false) goto L16;
        float r0 = r5.getResources().getDisplayMetrics().density;
        ShadowConfig r10 = r9[0];
        r5.getPaint().setShadowLayer(OUnitExtensionKt.dp2pxFloat(r10.getBlurRadius(), r0), OUnitExtensionKt.dp2pxFloat(r10.getX(), r0), OUnitExtensionKt.dp2pxFloat(r10.getY(), r0), r10.getColor());
        setBlendEffectToShadow(r5.getPaint(), ShadowConfig.getShadowBlendIntArray(r10));
        goto L16
    }

    public static void setContentMaterials(Object r1, MaterialConfig[] r2) {
        setContentMaterials(r1, 2, r2);
    }

    public static void setContentMaterials(Object r3, int r4, MaterialConfig[] r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        int r0 = 0;
    L6:
        if (r0 >= r5.length) goto L11;
        if (r0 != 0) goto L9;
        int r1 = 1;
    L10:
        setContentMaterial(r3, r4, r5[r0], r1);
        r0 = r0 + 1;
        goto L6
    L9:
        r1 = 2;
        goto L10
    }

    public static void setContentMaterial(Object r1, MaterialConfig r2) {
        setContentMaterial(r1, 2, r2);
    }

    public static void setContentMaterial(Object r1, int r2, MaterialConfig r3) {
        setMaterialConfig(r1, r2, 4, r3);
    }

    public static void setContentMaterial(Object r1, int r2, MaterialConfig r3, int r4) {
        setMaterialConfigByLevel(r1, r2, 4, r3, r4);
    }

    public static void setImageMaterials(ImageView r2, MaterialConfig[] r3) {
        setImageMaterials(r2, 2, 2, 0, r3);
    }

    public static void setImageMaterials(ImageView r2, int r3, MaterialConfig[] r4) {
        setImageMaterials(r2, r3, 2, 0, r4);
    }

    public static void setImageMaterials(ImageView r1, int r2, int r3, MaterialConfig[] r4) {
        setImageMaterials(r1, r2, r3, 0, r4);
    }

    public static void setImageMaterials(ImageView r8, int r9, int r10, int r11, MaterialConfig[] r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        int r0 = 0;
    L6:
        if (r0 >= r12.length) goto L11;
        if (r0 != 0) goto L9;
        int r1 = 1;
    L10:
        MaterialConfig r6 = r12[r0];
        setImageMaterial(r8, r9, r10, r11, r6, r1);
        r0 = r0 + 1;
        goto L6
    L9:
        r1 = 2;
        goto L10
    }

    public static void setImageMaterial(ImageView r2, MaterialConfig r3) {
        setImageMaterial(r2, 2, 2, 0, r3);
    }

    public static void setImageMaterial(ImageView r2, int r3, MaterialConfig r4) {
        setImageMaterial(r2, r3, 2, 0, r4);
    }

    public static void setImageMaterial(ImageView r1, int r2, int r3, MaterialConfig r4) {
        setImageMaterial(r1, r2, r3, 0, r4);
    }

    public static void setImageMaterial(ImageView r0, int r1, int r2, int r3, MaterialConfig r4) {
        setImageMaterialConfig(r0, r1, r2, r3, r4);
    }

    public static void setImageMaterial(ImageView r0, int r1, int r2, int r3, MaterialConfig r4, int r5) {
        setImageMaterialConfigByLevel(r0, r1, r2, r3, r4, r5);
    }

    public static void setMaterial(View r2, BlendConfig[] r3, Integer r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r3 != null) goto L8;
        if (r4 != null) goto L8;
        setEffectSrcAndDraw(r2, 0);
        return;
    L8:
        setEffectSrcAndDraw(r2, 2, 1);
        if (r3 == null) goto L11;
        setBlendEffect(r2, transformToBlendIntArray(r3));
    L11:
        if (r4 == null) goto L14;
        setNormalBlurEffect(r2, r4.floatValue());
        return;
    }

    public static void setMaterial(View r2, BlendConfig[] r3, BlurShadowConfig r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r3 != null) goto L8;
        if (r4 != null) goto L8;
        setEffectSrcAndDraw(r2, 0);
        return;
    L8:
        setEffectSrcAndDraw(r2, 2, 1);
        if (r3 == null) goto L11;
        setBlendEffect(r2, transformToBlendIntArray(r3));
    L11:
        if (r4 == null) goto L14;
        setNormalBlurEffect(r2, r4.getBlurRadius());
        return;
    }

    public static void setMaterialFromWindow(View r2, BlendConfig[] r3, Integer r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r3 != null) goto L8;
        if (r4 != null) goto L8;
        setEffectSrcAndDraw(r2, 0);
        return;
    L8:
        setEffectSrcAndDraw(r2, 3, 1);
        if (r3 == null) goto L11;
        setBlendEffect(r2, transformToBlendIntArray(r3));
    L11:
        if (r4 == null) goto L14;
        setNormalBlurEffect(r2, r4.floatValue());
        return;
    }

    public static void setMaterialFromWindow(View r2, BlendConfig[] r3, BlurShadowConfig r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r3 != null) goto L8;
        if (r4 != null) goto L8;
        setEffectSrcAndDraw(r2, 0);
        return;
    L8:
        setEffectSrcAndDraw(r2, 3, 1);
        if (r4 == null) goto L11;
        setNormalBlurEffect(r2, r4.getBlurRadius());
    L11:
        if (r3 == null) goto L14;
        setBlendEffect(r2, transformToBlendIntArray(r3));
        return;
    }

    public static boolean isMaterialConfigValid(MaterialConfig r1) {
        if (r1 != null) goto L4;
    L12:
        return false;
    L4:
        if (r1.getBlendConfig() == null) goto L6;
    L11:
        return true;
    L6:
        if (r1.getBlurConfig() != null) goto L11;
        if (r1.getBlurRadius() != null) goto L11;
        if (r1.getFluid() == null) goto L12;
        goto L11
    }

    public static void applyMaterialEffects(Object r2, MaterialConfig r3) {
        if (r3.getBlendConfigStateList() == null) goto L6;
        setBlendEffect(r2, transformToBlendIntArray(r3.getBlendConfigStateList().getDefaultBlendConfig()));
    L10:
        if (r3.getBlurConfig() == null) goto L13;
        setBlurEffect(r2, r3.getBlurConfig());
    L17:
        if (r3.getStroke() == null) goto L19;
        setStrokeEffect(r2, OUnitExtensionKt.dp2px(r3.getStroke().getWidth()), r3.getStroke().getColor());
    L21:
        if (r3.getFluid() == null) goto L23;
        setFluidEffect(r2, true, r3.getFluid().getGlassParams());
        return;
    L23:
        clearFluidEffect(r2);
        return;
    L19:
        setStrokeEffect(r2, 0.0f, 0);
        goto L21
    L13:
        if (r3.getBlurRadius() == null) goto L15;
        setNormalBlurEffect(r2, r3.getBlurRadius().floatValue());
        goto L17
    L15:
        clearBlurEffect(r2);
        goto L17
    L6:
        if (r3.getBlendConfig() == null) goto L8;
        setBlendEffect(r2, transformToBlendIntArray(r3.getBlendConfig()));
        goto L10
    L8:
        clearBlendEffect(r2);
        goto L10
    }

    public static void setMaterialForPaint(Paint r0, MaterialConfig r1) {
        if (r0 == null) goto L6;
        if (r1 == null) goto L7;
        applyMaterialEffects(r0, r1);
        return;
    L7:
        return;
    }

    public static void setMaterialForPaint(Paint r0, MaterialConfig r1, int r2) {
        MaterialParams r3 = getMaterialParams(r0, r2);
        if (r3 == null) goto L7;
        if (r1 == null) goto L8;
        applyMaterialEffects(r3.getProxy(), r1);
        return;
    L8:
        return;
    }

    public static void setMaterialConfig(Object r1, int r2, int r3, MaterialConfig r4) {
        if (r1 == null) goto L11;
        if (r4 != null) goto L6;
        return;
    L6:
        if (isMaterialConfigValid(r4) == true) goto L9;
        setEffectSrcAndDraw(r1, 0);
        return;
    L9:
        setEffectSrcAndDraw(r1, r2, r3);
        applyMaterialEffects(r1, r4);
        return;
    }

    public static void setMaterialConfigByLevel(Object r0, int r1, int r2, MaterialConfig r3, int r4) {
        MaterialParams r5 = getMaterialParams(r0, r4);
        if (r5 == null) goto L12;
        if (r3 == null) goto L13;
        Object r6 = r5.getProxy();
        if (isMaterialConfigValid(r3) == true) goto L10;
        setEffectSrcAndDraw(r6, 0);
        return;
    L10:
        setEffectSrcAndDraw(r6, r1, r2);
        applyMaterialEffects(r6, r3);
        return;
    L13:
        return;
    }

    public static void updateBlendConfigForMaterials(Object r5, BlendConfig[][] r6) {
        if (r6 != null) goto L5;
    L18:
        clearBlendEffectByLevel(r5, 1);
        clearBlendEffectByLevel(r5, 2);
        return;
    L5:
        if (r6.length == 0) goto L18;
        int r3 = 0;
        if (r6.length != 1) goto L12;
        setBlendEffect(r5, transformToBlendIntArray(r6[0]));
        return;
    L12:
        if (r3 >= r6.length) goto L17;
        if (r3 != 0) goto L15;
        int r2 = 1;
    L16:
        setBlendEffectByLevel(r5, r2, transformToBlendIntArray(r6[r3]));
        r3 = r3 + 1;
        goto L12
    L15:
        r2 = 2;
        goto L16
    }

    private static Drawable getImageMaterialDrawable(ImageView r1, int r2) {
        if (r2 != 0) goto L6;
        return r1.getDrawable();
    L6:
        if (r2 != 1) goto L10;
        return r1.getBackground();
    L10:
        if (r2 == 2) goto L12;
        return null;
    L12:
        return r1.getForeground();
    }

    private static void applyImageMaterialToDrawablePaint(ImageView r0, int r1, int r2, int r3, MaterialConfig r4, PaintApplier r5) {
        if (isMaterialConfigValid(r4) == true) goto L6;
        setEffectSrcAndDraw(r0, 0);
        return;
    L6:
        setEffectSrcAndDraw(r0, r1, r2);
        Paint r6 = getPaint(getImageMaterialDrawable(r0, r3));
        if (r6 == null) goto L10;
        r5.apply(r6);
        return;
    }

    public static void setImageMaterialConfig(ImageView r1, int r2, int r3, MaterialConfig r4) {
        setImageMaterialConfig(r1, r2, r3, 0, r4);
    }

    public static void setImageMaterialConfig(ImageView r7, int r8, int r9, int r10, final MaterialConfig r11) {
        if (r7 != null) goto L5;
        return;
    L5:
        if (r9 == 2) goto L8;
        setMaterialConfig(r7, r8, r9, r11);
        return;
    L8:
        applyImageMaterialToDrawablePaint(r7, r8, r9, r10, r11, new OMaterialHelper$$ExternalSyntheticLambda1(r11));
    }

    static /* synthetic */ void lambda$setImageMaterialConfig$0(MaterialConfig r0, Paint r1) {
        setMaterialForPaint(r1, r0);
    }

    public static void setImageMaterialConfigByLevel(ImageView r6, int r7, int r8, MaterialConfig r9, int r10) {
        setImageMaterialConfigByLevel(r6, r7, r8, 0, r9, r10);
    }

    public static void setImageMaterialConfigByLevel(ImageView r7, int r8, int r9, int r10, final MaterialConfig r11, final int r12) {
        if (r7 != null) goto L5;
        return;
    L5:
        if (r9 == 2) goto L8;
        setMaterialConfigByLevel(r7, r8, r9, r11, r12);
        return;
    L8:
        applyImageMaterialToDrawablePaint(r7, r8, r9, r10, r11, new OMaterialHelper$$ExternalSyntheticLambda0(r11, r12));
    }

    static /* synthetic */ void lambda$setImageMaterialConfigByLevel$1(MaterialConfig r0, int r1, Paint r2) {
        setMaterialForPaint(r2, r0, r1);
    }

    public static int getApiLevel() {
        Map<String, Method> r0 = METHOD_CACHE;
        Method r2 = r0.get("getEffectApi");
        if (r2 == null) goto L12;
    L5:
        Object r1 = r2.invoke(null, new Object[0]);     // Catch: Exception -> L9
        if ((r1 instanceof Integer) == false) goto L14;
        return ((Integer) r1).intValue();
    L9:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("OUIMaterial", "getEffectApi failed: " + e);
        return 0;
    L14:
        return 0;
    L12:
        r2 = NativeReflect.getDeclaredMethod(Class.forName(IEXT_EFFECT), "getEffectApi", new Class[0]);     // Catch: Exception -> L9
        r2.setAccessible(true);     // Catch: Exception -> L9
        r0.put("getEffectApi", r2);     // Catch: Exception -> L9
        goto L5
    }

    public static Object getExt(Object r1) {
        if ((r1 instanceof View) == false) goto L7;
        return getExtEffect((View) r1);
    L7:
        if ((r1 instanceof Paint) == false) goto L11;
        return getExtEffect((Paint) r1);
    L11:
        if ((r1 instanceof VectorDrawable) == true) goto L13;
        return r1;
    L13:
        return getExtEffect((VectorDrawable) r1);
    }

    private static Object invokeNoArgMethod(Object r3, String r4, Class<?> r5, String r6) {
        Map<String, Method> r0 = METHOD_CACHE;
        Method r1 = r0.get(r4);
        if (r1 == null) goto L10;
    L5:
        return r1.invoke(r3, new Object[0]);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    L10:
        r1 = NativeReflect.getDeclaredMethod(r5, r6, new Class[0]);     // Catch: Exception -> L7
        r1.setAccessible(true);     // Catch: Exception -> L7
        r0.put(r4, r1);     // Catch: Exception -> L7
        goto L5
    }

    public static Object getExtEffect(View r3) {
        return invokeNoArgMethod(r3, "view_getExtEffect", View.class, "getExtEffect");
    }

    public static Object getExtEffect(Paint r3) {
        return invokeNoArgMethod(r3, "paint_getExtEffect", Paint.class, "getExtEffect");
    }

    public static Object getExtEffect(VectorDrawable r3) {
        return invokeNoArgMethod(r3, "vectorDrawable_getExtEffect", VectorDrawable.class, "getExtEffect");
    }

    public static Object getExtView(View r6) {
        Map<String, Method> r0 = METHOD_CACHE;
        Method r2 = r0.get("view_getExtView");
        if (r2 == null) goto L10;
    L5:
        return r2.invoke(r6, new Object[0]);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    L10:
        r2 = NativeReflect.getDeclaredMethod(View.class, "getExt", new Class[0]);     // Catch: Exception -> L7
        r2.setAccessible(true);     // Catch: Exception -> L7
        r0.put("view_getExtView", r2);     // Catch: Exception -> L7
        goto L5
    }

    public static Paint getPaint(Drawable r7) {
        if (r7 != null) goto L6;
        return null;
    L6:
        if ((r7 instanceof BitmapDrawable) == false) goto L10;
        return ((BitmapDrawable) r7).getPaint();
    L10:
        if ((r7 instanceof ShapeDrawable) == true) goto L12;
        String r1 = "drawable_getPaint_" + r7.getClass().getName();
        Method r2 = DRAWABLE_METHOD_CACHE.get(r1);
        if (r2 != null) goto L22;
        Class<?> r4 = r7.getClass();
    L16:
        if (r4 == null) goto L22;
        if (r4 == Object.class) goto L22;
        r2 = r4.getDeclaredMethod("getPaint", new Class[0]);     // Catch: NoSuchMethodException -> L21 SecurityException -> L30
        r2.setAccessible(true);     // Catch: NoSuchMethodException -> L21 SecurityException -> L30
        DRAWABLE_METHOD_CACHE.put(r1, r2);     // Catch: NoSuchMethodException -> L21 SecurityException -> L30
    L21:
        r4 = r4.getSuperclass();
    L22:
        if (r2 != null) goto L32;
        Object r8 = null;
    L26:
        if ((r8 instanceof Paint) == false) goto L39;
        return (Paint) r8;
    L40:
        return null;
    L39:
        return null;
    L32:
        r8 = r2.invoke(r7, new Object[0]);     // Catch: Exception -> L31
        goto L26
    L12:
        return ((ShapeDrawable) r7).getPaint();
    }

    public static MaterialParams getMaterialParams(Object r8, int r9) {
        Object r10 = getExt(r8);
        Map<String, Method> r0 = METHOD_CACHE;
        Method r2 = r0.get("getEffectParas");
        if (r2 == null) goto L14;
    L5:
        Object r11 = r2.invoke(r10, new Object[]{Integer.valueOf(r9)});     // Catch: Exception -> L11
        if (r11 == null) goto L16;
        return new MaterialParams(r11);
    L11:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "getMaterialParams error: " + e);
        return null;
    L16:
        return null;
    L14:
        r2 = NativeReflect.getDeclaredMethod(Class.forName(IEXT_EFFECT), "getEffectParas", new Class[]{Integer.TYPE});     // Catch: Exception -> L11
        r2.setAccessible(true);     // Catch: Exception -> L11
        r0.put("getEffectParas", r2);     // Catch: Exception -> L11
        goto L5
    }

    public static void setCurrentMaterialParams(Object r7, int r8) {
        Object r9 = getExt(r7);
        Map<String, Method> r0 = METHOD_CACHE;
        Method r2 = r0.get("setCurrentEffectParas");
        if (r2 == null) goto L10;
    L5:
        r2.invoke(r9, new Object[]{Integer.valueOf(r8)});     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "setCurrentMaterialParams error: ", e);
        return;
    L10:
        r2 = NativeReflect.getDeclaredMethod(Class.forName(IEXT_EFFECT), "setCurrentEffectParas", new Class[]{Integer.TYPE});     // Catch: Exception -> L7
        r2.setAccessible(true);     // Catch: Exception -> L7
        r0.put("setCurrentEffectParas", r2);     // Catch: Exception -> L7
        goto L5
    }

    public static void setWindowBackgroundBlurUvOffset(View r8, int r9, int r10) {
        Object r11 = getExtView(r8);
        Map<String, Method> r0 = METHOD_CACHE;
        Method r2 = r0.get("setWindowBackgroundBlurUvOffset");
        if (r2 == null) goto L10;
    L5:
        r2.invoke(r11, new Object[]{Integer.valueOf(r9), Integer.valueOf(r10)});     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "setWindowBackgroundBlurUvOffset error: ", e);
        return;
    L10:
        r2 = NativeReflect.getDeclaredMethod(Class.forName(IEXT_VIEW), "setWindowBackgroundBlurUvOffset", new Class[]{Integer.TYPE, Integer.TYPE});     // Catch: Exception -> L7
        r2.setAccessible(true);     // Catch: Exception -> L7
        r0.put("setWindowBackgroundBlurUvOffset", r2);     // Catch: Exception -> L7
        goto L5
    }

    public static BlendConfig[] getBlendConfigArray(Resources r4, int r5, int r6) {
        if (r5 == 0) goto L10;
        if (r6 == 0) goto L13;
        int[] r7 = r4.getIntArray(r5);
        int[] r8 = r4.getIntArray(r6);
        BlendConfig[] r9 = new BlendConfig[r7.length];
        int r0 = 0;
    L7:
        if (r0 >= r7.length) goto L9;
        r9[r0] = new BlendConfig(r7[r0], BlendMode.mapToLegacyObricBlend(r8[r0]));
        r0 = r0 + 1;
        goto L7
    L9:
        return r9;
    L13:
        return null;
    L10:
        return null;
    }

    public static BlendConfig[] getBlendConfigArray(int[] r0) {
        return BlendConfig.fromIntArray(r0);
    }

    public static BlendConfig[] getBlendConfigArray(Resources r0, int r1) {
        return BlendConfig.fromArrayRes(r0, r1);
    }

    public static void setEffectSrc(Object r8, int r9) {
        if (isSupportObricMaterial() == true) goto L5;
        return;
    L5:
        Object r10 = getExt(r8);
        Map<String, Method> r0 = METHOD_CACHE;
        Method r2 = r0.get("setObricEffectSource_1");
        if (r2 == null) goto L13;
    L8:
        r2.invoke(r10, new Object[]{Integer.valueOf(r9)});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "setEffectSrc error: " + e);
        return;
    L13:
        r2 = NativeReflect.getDeclaredMethod(Class.forName(IEXT_EFFECT), "setObricEffectSource", new Class[]{Integer.TYPE});     // Catch: Exception -> L10
        r2.setAccessible(true);     // Catch: Exception -> L10
        r0.put("setObricEffectSource_1", r2);     // Catch: Exception -> L10
        goto L8
    }

    public static void setEffectSrcTarget(Object r7, View r8) {
        if (isSupportObricMaterial() == true) goto L5;
        return;
    L5:
        Object r9 = getExt(r7);
        Map<String, Method> r0 = METHOD_CACHE;
        Method r2 = r0.get("setObricEffectSourceTarget");
        if (r2 == null) goto L13;
    L8:
        r2.invoke(r9, new Object[]{r8});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        r2 = NativeReflect.getDeclaredMethod(Class.forName(IEXT_EFFECT), "setObricEffectSourceTarget", new Class[]{View.class});     // Catch: Exception -> L10
        r2.setAccessible(true);     // Catch: Exception -> L10
        r0.put("setObricEffectSourceTarget", r2);     // Catch: Exception -> L10
        goto L8
    }

    public static void setEffectSrcAndDraw(Object r1, int r2) {
        setEffectSrcAndDraw(r1, r2, 1);
    }

    public static void setEffectSrcAndDraw(Object r9, int r10, int r11) {
        if (isSupportObricMaterial() == true) goto L5;
        return;
    L5:
        Object r12 = getExt(r9);
        Map<String, Method> r0 = METHOD_CACHE;
        Method r2 = r0.get("setObricEffectSource_2");
        if (r2 == null) goto L13;
    L8:
        r2.invoke(r12, new Object[]{Integer.valueOf(r10), Integer.valueOf(r11)});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        r2 = NativeReflect.getDeclaredMethod(Class.forName(IEXT_EFFECT), "setObricEffectSource", new Class[]{Integer.TYPE, Integer.TYPE});     // Catch: Exception -> L10
        r2.setAccessible(true);     // Catch: Exception -> L10
        r0.put("setObricEffectSource_2", r2);     // Catch: Exception -> L10
        goto L8
    }

    public static void setEffectSrcAndDraw(Object r10, int r11, int r12, View r13) {
        if (isSupportObricMaterial() == true) goto L5;
        return;
    L5:
        Object r14 = getExt(r10);
        Map<String, Method> r0 = METHOD_CACHE;
        Method r2 = r0.get("setObricEffectSource_3");
        if (r2 == null) goto L13;
    L8:
        r2.invoke(r14, new Object[]{Integer.valueOf(r11), Integer.valueOf(r12), r13});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        r2 = NativeReflect.getDeclaredMethod(Class.forName(IEXT_EFFECT), "setObricEffectSource", new Class[]{Integer.TYPE, Integer.TYPE, View.class});     // Catch: Exception -> L10
        r2.setAccessible(true);     // Catch: Exception -> L10
        r0.put("setObricEffectSource_3", r2);     // Catch: Exception -> L10
        goto L8
    }

    public static void setEffectQuality(Object r7, int r8) {
        if (isSupportObricMaterial() == true) goto L5;
        return;
    L5:
        Object r9 = getExt(r7);
        Map<String, Method> r0 = METHOD_CACHE;
        Method r2 = r0.get("setObricEffectQuality");
        if (r2 == null) goto L13;
    L8:
        r2.invoke(r9, new Object[]{Integer.valueOf(r8)});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "setEffectQuality error: " + e);
        return;
    L13:
        r2 = NativeReflect.getDeclaredMethod(Class.forName(IEXT_EFFECT), "setObricEffectQuality", new Class[]{Integer.TYPE});     // Catch: Exception -> L10
        r2.setAccessible(true);     // Catch: Exception -> L10
        r0.put("setObricEffectQuality", r2);     // Catch: Exception -> L10
        goto L8
    }

    public static void setMaterialCaptureParams(Object r8, int r9, float r10) {
        if (isSupportObricMaterial() == true) goto L6;
        return;
    L6:
        if (getApiLevel() >= 4) goto L8;
        return;
    L8:
        Object r11 = getExt(r8);
        Map<String, Method> r0 = METHOD_CACHE;
        Method r2 = r0.get("setObricBlurCaptureParams");
        if (r2 == null) goto L16;
    L11:
        r2.invoke(r11, new Object[]{Integer.valueOf(r9), Float.valueOf(r10)});     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "setMaterialCaptureParams error: " + e);
        return;
    L16:
        r2 = NativeReflect.getDeclaredMethod(Class.forName(IEXT_EFFECT), "setObricBlurCaptureParams", new Class[]{Integer.TYPE, Float.TYPE});     // Catch: Exception -> L13
        r2.setAccessible(true);     // Catch: Exception -> L13
        r0.put("setObricBlurCaptureParams", r2);     // Catch: Exception -> L13
        goto L11
    }

    public static void setNormalBlurEffect(Object r6, float r7) {
        setBlurEffect(r6, r7, 1.0f, 0, 0, 1.0f);
    }

    public static void setBlurEffect(Object r8, float r9) {
        if (isSupportObricMaterial() == true) goto L5;
        return;
    L5:
        Object r10 = getExt(r8);
        Map<String, Method> r0 = METHOD_CACHE;
        Method r2 = r0.get("setObricBlurEffect_1");
        if (r2 == null) goto L13;
    L8:
        r2.invoke(r10, new Object[]{Float.valueOf(r9)});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "setBlurEffect 1 param error: " + e);
        return;
    L13:
        r2 = NativeReflect.getDeclaredMethod(Class.forName(IEXT_EFFECT), "setObricBlurEffect", new Class[]{Float.TYPE});     // Catch: Exception -> L10
        r2.setAccessible(true);     // Catch: Exception -> L10
        r0.put("setObricBlurEffect_1", r2);     // Catch: Exception -> L10
        goto L8
    }

    public static void setBlurEffect(Object r10, float r11, float r12, float r13) {
        if (isSupportObricMaterial() == true) goto L6;
        return;
    L6:
        if (getApiLevel() >= 4) goto L8;
        return;
    L8:
        Object r14 = getExt(r10);
        Map<String, Method> r0 = METHOD_CACHE;
        Method r2 = r0.get("setObricBlurEffect_3");
        if (r2 == null) goto L16;
    L11:
        r2.invoke(r14, new Object[]{Float.valueOf(r11), Float.valueOf(r12), Float.valueOf(r13)});     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "setBlurEffect 3 params error: " + e);
        return;
    L16:
        r2 = NativeReflect.getDeclaredMethod(Class.forName(IEXT_EFFECT), "setObricBlurEffect", new Class[]{Float.TYPE, Float.TYPE, Float.TYPE});     // Catch: Exception -> L13
        r2.setAccessible(true);     // Catch: Exception -> L13
        r0.put("setObricBlurEffect_3", r2);     // Catch: Exception -> L13
        goto L11
    }

    public static void setBlurEffect(Object r11, float r12, float r13, int r14, float r15) {
        if (isSupportObricMaterial() == true) goto L6;
        return;
    L6:
        if (getApiLevel() >= 4) goto L8;
        return;
    L8:
        Object r16 = getExt(r11);
        Map<String, Method> r0 = METHOD_CACHE;
        Method r3 = r0.get("setObricBlurEffect_4");
        if (r3 == null) goto L16;
    L11:
        r3.invoke(r16, new Object[]{Float.valueOf(r12), Float.valueOf(r13), Integer.valueOf(r14), Float.valueOf(r15)});     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "setBlurEffect 4 params error: " + e);
        return;
    L16:
        r3 = NativeReflect.getDeclaredMethod(Class.forName(IEXT_EFFECT), "setObricBlurEffect", new Class[]{Float.TYPE, Float.TYPE, Integer.TYPE, Float.TYPE});     // Catch: Exception -> L13
        r3.setAccessible(true);     // Catch: Exception -> L13
        r0.put("setObricBlurEffect_4", r3);     // Catch: Exception -> L13
        goto L11
    }

    public static void setBlurEffect(Object r6, BlurConfig r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        setBlurEffect(r6, r7.getBlurRadius(), r7.getAlpha(), r7.getDirection(), r7.getCurveType(), r7.getEndPoint());
    }

    public static void setBlurEffectByLevel(Object r0, int r1, float r2) {
        MaterialParams r3 = getMaterialParams(r0, r1);
        if (r3 == null) goto L6;
        setBlurEffect(r3.getProxy(), r2);
        return;
    }

    public static void updateBlurEffectForMaterials(Object r5, Float[] r6) {
        if (r6 != null) goto L5;
    L18:
        clearBlurEffectByLevel(r5, 1);
        clearBlurEffectByLevel(r5, 2);
        return;
    L5:
        if (r6.length == 0) goto L18;
        int r3 = 0;
        if (r6.length != 1) goto L12;
        setBlurEffect(r5, r6[0].floatValue());
        return;
    L12:
        if (r3 >= r6.length) goto L17;
        if (r3 != 0) goto L15;
        int r2 = 1;
    L16:
        setBlurEffectByLevel(r5, r2, r6[r3].floatValue());
        r3 = r3 + 1;
        goto L12
    L15:
        r2 = 2;
        goto L16
    }

    public static void setBlurEffect(Object r13, float r14, float r15, int r16, int r17, float r18) {
        if (isSupportObricMaterial() == true) goto L5;
        return;
    L5:
        Object r0 = getExt(r13);
        Map<String, Method> r1 = METHOD_CACHE;
        Method r3 = r1.get("setObricBlurEffect_5");
        if (r3 == null) goto L13;
    L8:
        r3.invoke(r0, new Object[]{Float.valueOf(r14), Float.valueOf(r15), Integer.valueOf(r16), Integer.valueOf(r17), Float.valueOf(r18)});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        r3 = NativeReflect.getDeclaredMethod(Class.forName(IEXT_EFFECT), "setObricBlurEffect", new Class[]{Float.TYPE, Float.TYPE, Integer.TYPE, Integer.TYPE, Float.TYPE});     // Catch: Exception -> L10
        r3.setAccessible(true);     // Catch: Exception -> L10
        r1.put("setObricBlurEffect_5", r3);     // Catch: Exception -> L10
        goto L8
    }

    public static void clearBlurEffect(Object r6) {
        setBlurEffect(r6, 0.0f, 1.0f, 0, 0, 1.0f);
    }

    public static void clearBlurEffectByLevel(Object r0, int r1) {
        MaterialParams r2 = getMaterialParams(r0, r1);
        if (r2 == null) goto L6;
        clearBlurEffect(r2.getProxy());
        return;
    }

    public static void setCommonGradientBlur(View r1, MaterialConfig r2) {
        setCommonGradientBlur(r1, r2, 2);
    }

    public static void setCommonGradientBlur(View r3, MaterialConfig r4, int r5) {
        if (r3 == null) goto L34;
        if (r4 != null) goto L6;
        return;
    L6:
        if (isSupportObricMaterial() == false) goto L8;
        setEffectSrcAndDraw(r3, r5, 1);
        if (r4.getBlendConfig() == null) goto L26;
        setBlendEffect(r3, transformToBlendIntArray(r4.getBlendConfig()));
    L26:
        if (r4.getBlurConfig() == null) goto L35;
        setBlurEffect(r3, r4.getBlurConfig());
        return;
    L35:
        return;
    L8:
        if (r4.getBlurConfig() != null) goto L10;
        return;
    L10:
        if (r4.getBlendConfig() == null) goto L33;
        int[] r6 = transformToBlendIntArray(r4.getBlendConfig());
        if (OMaterial.ENABLE_BLEND_MODE_COMPAT == true) goto L20;
        int r0 = 0;
    L15:
        if (r0 >= r6.length) goto L20;
        if ((r0 % 2) == 0) goto L19;
        r6[r0] = BlendMode.mapToLegacyObricBlend(r6[r0], true);
    L19:
        r0 = r0 + 1;
    L20:
        setBackdropBlurEffectExt(r3, r4.getBlurConfig().getDirection(), r4.getBlurConfig().getBlurRadius(), r6);
        return;
    L33:
        return;
    }

    public static void setBlendEffect(Object r2, int... r3) {
        setBlendEffect(r2, 4, 1.0f, r3);
    }

    public static void setBlendEffect(Object r10, int r11, float r12, int... r13) {
        if (isSupportObricMaterial() == true) goto L5;
        return;
    L5:
        Object r14 = getExt(r10);
        Map<String, Method> r0 = METHOD_CACHE;
        Method r2 = r0.get(KEY_SET_OBRIC_BLEND_EFFECT_CURVE);
        if (r2 == null) goto L13;
    L8:
        r2.invoke(r14, new Object[]{Integer.valueOf(r11), Float.valueOf(r12), r13});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "setBlendEffect error: " + e);
        return;
    L13:
        r2 = NativeReflect.getDeclaredMethod(Class.forName(IEXT_EFFECT), "setObricBlendEffect", new Class[]{Integer.TYPE, Float.TYPE, int[].class});     // Catch: Exception -> L10
        r2.setAccessible(true);     // Catch: Exception -> L10
        r0.put(KEY_SET_OBRIC_BLEND_EFFECT_CURVE, r2);     // Catch: Exception -> L10
        goto L8
    }

    public static void setBlendEffectByLevel(Object r2, int r3, int... r4) {
        if (isSupportObricMaterial() == true) goto L5;
        return;
    L5:
        setBlendEffectByLevel(r2, r3, 4, 1.0f, r4);
    }

    public static void setBlendEffectByLevel(Object r1, int r2, int r3, float r4, int... r5) {
        MaterialParams r6 = getMaterialParams(r1, r2);
        if (r6 != null) goto L5;
        return;
    L5:
        Object r7 = r6.getProxy();
        if (r5 != null) goto L8;
    L12:
        clearBlendEffect(r7);
        return;
    L8:
        if (r5.length < 2) goto L12;
        setBlendEffect(r7, r3, r4, r5);
    }

    public static void clearBlendEffect(Object r10) {
        if (isSupportObricMaterial() == true) goto L5;
        return;
    L5:
        Object r11 = getExt(r10);
        Map<String, Method> r0 = METHOD_CACHE;
        Method r2 = r0.get(KEY_SET_OBRIC_BLEND_EFFECT_CURVE);
        if (r2 == null) goto L13;
    L8:
        r2.invoke(r11, new Object[]{0, Float.valueOf(1.0f), new int[]{0, 0}});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "clearBlendEffect error: " + e);
        return;
    L13:
        r2 = NativeReflect.getDeclaredMethod(Class.forName(IEXT_EFFECT), "setObricBlendEffect", new Class[]{Integer.TYPE, Float.TYPE, int[].class});     // Catch: Exception -> L10
        r2.setAccessible(true);     // Catch: Exception -> L10
        r0.put(KEY_SET_OBRIC_BLEND_EFFECT_CURVE, r2);     // Catch: Exception -> L10
        goto L8
    }

    public static void clearBlendEffectByLevel(Object r0, int r1) {
        MaterialParams r2 = getMaterialParams(r0, r1);
        if (r2 == null) goto L6;
        clearBlendEffect(r2.getProxy());
        return;
    }

    public static void setBlendEffectToShadow(Object r7, int... r8) {
        if (isSupportObricMaterial() == true) goto L5;
        return;
    L5:
        Object r9 = getExt(r7);
        Map<String, Method> r0 = METHOD_CACHE;
        Method r2 = r0.get(KEY_SET_OBRIC_BLEND_EFFECT_TO_SHADOW);
        if (r2 == null) goto L15;
    L10:
        if (r9 == null) goto L17;
        r2.invoke(r9, new Object[]{r8});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "setBlendEffectToShadow error: " + e);
        return;
    L17:
        return;
    L15:
        r2 = NativeReflect.getDeclaredMethod(Class.forName(IEXT_EFFECT), KEY_SET_OBRIC_BLEND_EFFECT_TO_SHADOW, new Class[]{int[].class});     // Catch: Exception -> L8
        r2.setAccessible(true);     // Catch: Exception -> L8
        r0.put(KEY_SET_OBRIC_BLEND_EFFECT_TO_SHADOW, r2);     // Catch: Exception -> L8
        goto L10
    }

    public static void setOverlayBlendEffect(Object r7, int... r8) {
        if (isSupportObricMaterial() == true) goto L5;
        return;
    L5:
        Object r9 = getExt(r7);
        Map<String, Method> r0 = METHOD_CACHE;
        Method r2 = r0.get("setObricOverlayBlendEffect");
        if (r2 == null) goto L13;
    L8:
        r2.invoke(r9, new Object[]{r8});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "setOverlayBlendEffect error: " + e);
        return;
    L13:
        r2 = NativeReflect.getDeclaredMethod(Class.forName(IEXT_EFFECT), "setObricOverlayBlendEffect", new Class[]{int[].class});     // Catch: Exception -> L10
        r2.setAccessible(true);     // Catch: Exception -> L10
        r0.put("setObricOverlayBlendEffect", r2);     // Catch: Exception -> L10
        goto L8
    }

    public static void setOverlayBlendEffect(Object r10, int r11, float r12, int r13) {
        if (isSupportObricMaterial() == true) goto L5;
        return;
    L5:
        Object r14 = getExt(r10);
        Map<String, Method> r0 = METHOD_CACHE;
        Method r2 = r0.get("setObricOverlayBlendEffect_3");
        if (r2 == null) goto L13;
    L8:
        r2.invoke(r14, new Object[]{Integer.valueOf(r11), Float.valueOf(r12), Integer.valueOf(r13)});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "setOverlayBlendEffect error: " + e);
        return;
    L13:
        r2 = NativeReflect.getDeclaredMethod(Class.forName(IEXT_EFFECT), "setObricOverlayBlendEffect", new Class[]{Integer.TYPE, Float.TYPE, Integer.TYPE});     // Catch: Exception -> L10
        r2.setAccessible(true);     // Catch: Exception -> L10
        r0.put("setObricOverlayBlendEffect_3", r2);     // Catch: Exception -> L10
        goto L8
    }

    public static void clearOverlayBlendEffect(Object r2) {
        setOverlayBlendEffect(r2, 0, 1.0f, 0);
    }

    public static void setOverlayEffectAlpha(Object r7, float... r8) {
        if (isSupportObricMaterial() == true) goto L5;
        return;
    L5:
        Object r9 = getExt(r7);
        Map<String, Method> r0 = METHOD_CACHE;
        Method r2 = r0.get("setObricOverlayEffectAlpha");
        if (r2 == null) goto L13;
    L8:
        r2.invoke(r9, new Object[]{r8});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "setOverlayEffectAlpha error: " + e);
        return;
    L13:
        r2 = NativeReflect.getDeclaredMethod(Class.forName(IEXT_EFFECT), "setObricOverlayEffectAlpha", new Class[]{Float.TYPE});     // Catch: Exception -> L10
        r2.setAccessible(true);     // Catch: Exception -> L10
        r0.put("setObricOverlayEffectAlpha", r2);     // Catch: Exception -> L10
        goto L8
    }

    public static void setRenderShader(Object r8, Shader r9, int r10) {
        if (isSupportObricMaterial() == true) goto L5;
        return;
    L5:
        Object r11 = getExt(r8);
        Map<String, Method> r0 = METHOD_CACHE;
        Method r2 = r0.get("setObricRenderShader");
        if (r2 == null) goto L13;
    L8:
        r2.invoke(r11, new Object[]{r9, Integer.valueOf(r10)});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "setRenderShader error: " + e);
        return;
    L13:
        r2 = NativeReflect.getDeclaredMethod(Class.forName(IEXT_EFFECT), "setObricRenderShader", new Class[]{Shader.class, Integer.TYPE});     // Catch: Exception -> L10
        r2.setAccessible(true);     // Catch: Exception -> L10
        r0.put("setObricRenderShader", r2);     // Catch: Exception -> L10
        goto L8
    }

    public static void setBlendEffect(VectorDrawable r8, int... r9) {
        if (isSupportObricMaterial() == true) goto L5;
        return;
    L5:
        Object r10 = getExtEffect(r8);
        Map<String, Method> r0 = METHOD_CACHE;
        Method r2 = r0.get(KEY_SET_OBRIC_BLEND_EFFECT_VECTOR);
        if (r2 == null) goto L15;
    L10:
        if (r10 == null) goto L17;
        r2.invoke(r10, new Object[]{r9});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "setBlendEffect error: " + e);
        return;
    L17:
        return;
    L15:
        r2 = NativeReflect.getDeclaredMethod(Class.forName(IEXT_EFFECT), "setObricBlendEffect", new Class[]{int[].class});     // Catch: Exception -> L8
        r2.setAccessible(true);     // Catch: Exception -> L8
        r0.put(KEY_SET_OBRIC_BLEND_EFFECT_VECTOR, r2);     // Catch: Exception -> L8
        goto L10
    }

    public static int[] transformToBlendIntArray(BlendConfig[] r5) {
        int r0 = 0;
        if (r5 == null) goto L5;
        int r1 = r5.length * 2;
        int[] r2 = new int[r1];
    L7:
        if (r0 >= r1) goto L13;
        BlendConfig r3 = r5[r0 / 2];
        if ((r0 % 2) != 0) goto L11;
        int r4 = r3.getColor();
    L12:
        r2[r0] = r4;
        r0 = r0 + 1;
        goto L7
    L11:
        r4 = r3.getBlendMode();
        goto L12
    L13:
        return r2;
    L5:
        return new int[0];
    }

    public static int[] transformToBlendIntArray(BlendConfig r3) {
        if (r3 != null) goto L7;
        return new int[0];
    L7:
        return new int[]{r3.getColor(), r3.getBlendMode()};
    }

    public static void setStrokeEffect(Object r1, float r2, int r3) {
        setStrokeEffect(r1, r2, r3, BlendMode.SRC_OVER.getPorterDuffMode());
    }

    public static void setStrokeEffect(Object r9, float r10, int r11, int r12) {
        if (isSupportObricMaterial() == true) goto L5;
        return;
    L5:
        Object r13 = getExt(r9);
        Map<String, Method> r0 = METHOD_CACHE;
        Method r2 = r0.get("setObricBlurStroke");
        if (r2 == null) goto L13;
    L8:
        r2.invoke(r13, new Object[]{Float.valueOf(r10), Integer.valueOf(r11), Integer.valueOf(r12)});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "setStrokeEffect error: ", e);
        return;
    L13:
        r2 = NativeReflect.getDeclaredMethod(Class.forName(IEXT_EFFECT), "setObricBlurStroke", new Class[]{Float.TYPE, Integer.TYPE, Integer.TYPE});     // Catch: Exception -> L10
        r2.setAccessible(true);     // Catch: Exception -> L10
        r0.put("setObricBlurStroke", r2);     // Catch: Exception -> L10
        goto L8
    }

    public static void setFluidEffect(Object r2) {
        setFluidEffect(r2, true, DEFAULT_FLUID_PARAMS);
    }

    public static void setFluidEffect(Object r1, boolean r2) {
        setFluidEffect(r1, r2, DEFAULT_FLUID_PARAMS);
    }

    public static void setFluidEffect(Object r7, boolean r8, float[] r9) {
        if (isSupportObricMaterial() == true) goto L5;
        return;
    L5:
        Object r10 = getExt(r7);
        Map<String, Method> r0 = METHOD_CACHE;
        Method r2 = r0.get("setObricLiquidGlassEffectRR");
        if (r2 == null) goto L17;
    L8:
        Object[] r1 = new Object[1];     // Catch: Exception -> L14
        if (r8 == true) goto L12;
        r9 = new float[0];     // Catch: Exception -> L14
    L12:
        r1[0] = r9;     // Catch: Exception -> L14
        r2.invoke(r10, r1);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "setFluidEffect error: " + e);
        return;
    L17:
        r2 = NativeReflect.getDeclaredMethod(Class.forName(IEXT_EFFECT), "setObricLiquidGlassEffectRR", new Class[]{float[].class});     // Catch: Exception -> L14
        r2.setAccessible(true);     // Catch: Exception -> L14
        r0.put("setObricLiquidGlassEffectRR", r2);     // Catch: Exception -> L14
        goto L8
    }

    public static void setFluidEffectQuality(Object r7, int r8) {
        if (isSupportObricMaterial() == true) goto L5;
        return;
    L5:
        Object r9 = getExt(r7);
        Map<String, Method> r0 = METHOD_CACHE;
        Method r2 = r0.get("setObricLiquidGlassEffectQuality");
        if (r2 == null) goto L13;
    L8:
        r2.invoke(r9, new Object[]{Integer.valueOf(r8)});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "setFluidEffectQuality error: " + e);
        return;
    L13:
        r2 = NativeReflect.getDeclaredMethod(Class.forName(IEXT_EFFECT), "setObricLiquidGlassEffectQuality", new Class[]{Integer.TYPE});     // Catch: Exception -> L10
        r2.setAccessible(true);     // Catch: Exception -> L10
        r0.put("setObricLiquidGlassEffectQuality", r2);     // Catch: Exception -> L10
        goto L8
    }

    public static void clearFluidEffect(Object r1) {
        setFluidEffect(r1, false);
    }

    @Deprecated
    public static void setBackdropBlurEffectExt(View r10, int r11, float r12, int... r13) {
        Object r14 = getExtView(r10);
        Map<String, Method> r0 = METHOD_CACHE;
        Method r2 = r0.get("legacy_setBackdropBlurEffectExt");
        if (r2 == null) goto L10;
    L5:
        r2.invoke(r14, new Object[]{Integer.valueOf(r11), Float.valueOf(r12), r13});     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "setBackdropBlurEffectExt error: " + e);
        return;
    L10:
        r2 = NativeReflect.getDeclaredMethod(Class.forName(IEXT_VIEW), "setBackdropBlurEffectExt", new Class[]{Integer.TYPE, Float.TYPE, int[].class});     // Catch: Exception -> L7
        r2.setAccessible(true);     // Catch: Exception -> L7
        r0.put("legacy_setBackdropBlurEffectExt", r2);     // Catch: Exception -> L7
        goto L5
    }
}
