package com.google.android.material.color;

import com.google.android.material.R;
import com.google.android.material.color.utilities.DynamicColor;
import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class MaterialColorUtilitiesHelper {
    private static final Map<Integer, DynamicColor> colorResourceIdToColorValue = null;

    private MaterialColorUtilitiesHelper() {
    }

    static {
        HashMap r0 = new HashMap();
        r0.put(Integer.valueOf(R.color.material_personalized_color_primary), MaterialDynamicColors.primary);
        r0.put(Integer.valueOf(R.color.material_personalized_color_on_primary), MaterialDynamicColors.onPrimary);
        r0.put(Integer.valueOf(R.color.material_personalized_color_primary_inverse), MaterialDynamicColors.primaryInverse);
        r0.put(Integer.valueOf(R.color.material_personalized_color_primary_container), MaterialDynamicColors.primaryContainer);
        r0.put(Integer.valueOf(R.color.material_personalized_color_on_primary_container), MaterialDynamicColors.onPrimaryContainer);
        r0.put(Integer.valueOf(R.color.material_personalized_color_secondary), MaterialDynamicColors.secondary);
        r0.put(Integer.valueOf(R.color.material_personalized_color_on_secondary), MaterialDynamicColors.onSecondary);
        r0.put(Integer.valueOf(R.color.material_personalized_color_secondary_container), MaterialDynamicColors.secondaryContainer);
        r0.put(Integer.valueOf(R.color.material_personalized_color_on_secondary_container), MaterialDynamicColors.onSecondaryContainer);
        r0.put(Integer.valueOf(R.color.material_personalized_color_tertiary), MaterialDynamicColors.tertiary);
        r0.put(Integer.valueOf(R.color.material_personalized_color_on_tertiary), MaterialDynamicColors.onTertiary);
        r0.put(Integer.valueOf(R.color.material_personalized_color_tertiary_container), MaterialDynamicColors.tertiaryContainer);
        r0.put(Integer.valueOf(R.color.material_personalized_color_on_tertiary_container), MaterialDynamicColors.onTertiaryContainer);
        r0.put(Integer.valueOf(R.color.material_personalized_color_background), MaterialDynamicColors.background);
        r0.put(Integer.valueOf(R.color.material_personalized_color_on_background), MaterialDynamicColors.onBackground);
        r0.put(Integer.valueOf(R.color.material_personalized_color_surface), MaterialDynamicColors.surface);
        r0.put(Integer.valueOf(R.color.material_personalized_color_on_surface), MaterialDynamicColors.onSurface);
        r0.put(Integer.valueOf(R.color.material_personalized_color_surface_variant), MaterialDynamicColors.surfaceVariant);
        r0.put(Integer.valueOf(R.color.material_personalized_color_on_surface_variant), MaterialDynamicColors.onSurfaceVariant);
        r0.put(Integer.valueOf(R.color.material_personalized_color_surface_inverse), MaterialDynamicColors.surfaceInverse);
        r0.put(Integer.valueOf(R.color.material_personalized_color_on_surface_inverse), MaterialDynamicColors.onSurfaceInverse);
        r0.put(Integer.valueOf(R.color.material_personalized_color_surface_bright), MaterialDynamicColors.surfaceBright);
        r0.put(Integer.valueOf(R.color.material_personalized_color_surface_dim), MaterialDynamicColors.surfaceDim);
        r0.put(Integer.valueOf(R.color.material_personalized_color_surface_container), MaterialDynamicColors.surfaceContainer);
        r0.put(Integer.valueOf(R.color.material_personalized_color_surface_container_low), MaterialDynamicColors.surfaceSub1);
        r0.put(Integer.valueOf(R.color.material_personalized_color_surface_container_high), MaterialDynamicColors.surfaceAdd1);
        r0.put(Integer.valueOf(R.color.material_personalized_color_surface_container_lowest), MaterialDynamicColors.surfaceSub2);
        r0.put(Integer.valueOf(R.color.material_personalized_color_surface_container_highest), MaterialDynamicColors.surfaceAdd2);
        r0.put(Integer.valueOf(R.color.material_personalized_color_outline), MaterialDynamicColors.outline);
        r0.put(Integer.valueOf(R.color.material_personalized_color_outline_variant), MaterialDynamicColors.outlineVariant);
        r0.put(Integer.valueOf(R.color.material_personalized_color_error), MaterialDynamicColors.error);
        r0.put(Integer.valueOf(R.color.material_personalized_color_on_error), MaterialDynamicColors.onError);
        r0.put(Integer.valueOf(R.color.material_personalized_color_error_container), MaterialDynamicColors.errorContainer);
        r0.put(Integer.valueOf(R.color.material_personalized_color_on_error_container), MaterialDynamicColors.onErrorContainer);
        r0.put(Integer.valueOf(R.color.material_personalized_color_control_activated), MaterialDynamicColors.controlActivated);
        r0.put(Integer.valueOf(R.color.material_personalized_color_control_normal), MaterialDynamicColors.controlNormal);
        r0.put(Integer.valueOf(R.color.material_personalized_color_control_highlight), MaterialDynamicColors.controlHighlight);
        r0.put(Integer.valueOf(R.color.material_personalized_color_text_primary_inverse), MaterialDynamicColors.textPrimaryInverse);
        r0.put(Integer.valueOf(R.color.material_personalized_color_text_secondary_and_tertiary_inverse), MaterialDynamicColors.textSecondaryAndTertiaryInverse);
        r0.put(Integer.valueOf(R.color.material_personalized_color_text_secondary_and_tertiary_inverse_disabled), MaterialDynamicColors.textSecondaryAndTertiaryInverseDisabled);
        r0.put(Integer.valueOf(R.color.material_personalized_color_text_primary_inverse_disable_only), MaterialDynamicColors.textPrimaryInverseDisableOnly);
        r0.put(Integer.valueOf(R.color.material_personalized_color_text_hint_foreground_inverse), MaterialDynamicColors.textHintInverse);
        colorResourceIdToColorValue = Collections.unmodifiableMap(r0);
    }

    public static Map<Integer, Integer> createColorResourcesIdsToColorValues(DynamicScheme r4) {
        HashMap r0 = new HashMap();
        Iterator<Map.Entry<Integer, DynamicColor>> r1 = colorResourceIdToColorValue.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        Map.Entry<Integer, DynamicColor> r2 = r1.next();
        r0.put(r2.getKey(), Integer.valueOf(r2.getValue().getArgb(r4)));
        goto L4
    L7:
        return Collections.unmodifiableMap(r0);
    }
}
