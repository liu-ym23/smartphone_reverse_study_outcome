package com.android.server.display.utils;

import android.R;
import android.content.res.Resources;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes2.dex */
public class AmbientFilterFactory {
    public static AmbientFilter createAmbientFilter(String tag, int horizon, float intercept) {
        if (Float.isNaN(intercept) == true) goto L7;
        return new AmbientFilter.WeightedMovingAverageAmbientFilter(tag, horizon, intercept);
    L7:
        throw new IllegalArgumentException("missing configurations: expected config_displayWhiteBalanceBrightnessFilterIntercept");
    }

    public static AmbientFilter createBrightnessFilter(String tag, Resources resources) {
        int horizon = resources.getInteger(R.integer.config_displayWhiteBalanceTransitionTimeDecrease);
        float intercept = getFloat(resources, R.dimen.default_app_widget_padding_bottom);
        return createAmbientFilter(tag, horizon, intercept);
    }

    public static AmbientFilter createColorTemperatureFilter(String tag, Resources resources) {
        int horizon = resources.getInteger(R.integer.config_doublePressOnPowerBehavior);
        float intercept = getFloat(resources, R.dimen.default_app_widget_padding_left);
        return createAmbientFilter(tag, horizon, intercept);
    }

    private AmbientFilterFactory() {
    }

    private static float getFloat(Resources resources, int id) {
        TypedValue value = new TypedValue();
        resources.getValue(id, value, true);
        if (value.type == 4) goto L7;
        return Float.NaN;
    L7:
        return value.getFloat();
    }
}
