package com.google.android.material.color;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import androidx.core.os.BuildCompat;
import com.bytedance.common.utility.DeviceUtils;
import com.google.android.material.R;
import com.google.android.material.color.utilities.Hct;
import com.google.android.material.color.utilities.SchemeContent;
import com.google.android.material.resources.MaterialAttributes;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicColors {
    private static final DeviceSupportCondition DEFAULT_DEVICE_SUPPORT_CONDITION = null;
    private static final Map<String, DeviceSupportCondition> DYNAMIC_COLOR_SUPPORTED_BRANDS = null;
    private static final Map<String, DeviceSupportCondition> DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS = null;
    private static final int[] DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE = null;
    private static final DeviceSupportCondition SAMSUNG_DEVICE_SUPPORT_CONDITION = null;
    private static final int USE_DEFAULT_THEME_OVERLAY = 0;

    private interface DeviceSupportCondition {
        boolean isSupported();
    }

    private static class DynamicColorsActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        private final DynamicColorsOptions dynamicColorsOptions;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r1, Bundle r2) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r1) {
        }

        DynamicColorsActivityLifecycleCallbacks(DynamicColorsOptions r1) {
            this.dynamicColorsOptions = r1;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity r1, Bundle r2) {
            DynamicColors.applyToActivityIfAvailable(r1, this.dynamicColorsOptions);
        }
    }

    public interface OnAppliedCallback {
        void onApplied(Activity r1);
    }

    public interface Precondition {
        boolean shouldApplyDynamicColors(Activity r1, int r2);
    }

    static {
        DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE = new int[]{R.attr.dynamicColorThemeOverlay};
        DeviceSupportCondition r0 = new AnonymousClass1();
        DEFAULT_DEVICE_SUPPORT_CONDITION = r0;
        DeviceSupportCondition r1 = new AnonymousClass2();
        SAMSUNG_DEVICE_SUPPORT_CONDITION = r1;
        HashMap r2 = new HashMap();
        r2.put("fcnt", r0);
        r2.put("google", r0);
        r2.put("hmd global", r0);
        r2.put("infinix", r0);
        r2.put("infinix mobility limited", r0);
        r2.put("itel", r0);
        r2.put("kyocera", r0);
        r2.put("lenovo", r0);
        r2.put("lge", r0);
        r2.put("motorola", r0);
        r2.put("nothing", r0);
        r2.put("oneplus", r0);
        r2.put("oppo", r0);
        r2.put("realme", r0);
        r2.put("robolectric", r0);
        r2.put(DeviceUtils.ROM_SAMSUNG, r1);
        r2.put("sharp", r0);
        r2.put("sony", r0);
        r2.put("tcl", r0);
        r2.put("tecno", r0);
        r2.put("tecno mobile limited", r0);
        r2.put("vivo", r0);
        r2.put("wingtech", r0);
        r2.put("xiaomi", r0);
        DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS = Collections.unmodifiableMap(r2);
        HashMap r3 = new HashMap();
        r3.put("asus", r0);
        r3.put("jio", r0);
        DYNAMIC_COLOR_SUPPORTED_BRANDS = Collections.unmodifiableMap(r3);
    }

    private DynamicColors() {
    }

    public static void applyToActivitiesIfAvailable(Application r1) {
        applyToActivitiesIfAvailable(r1, new DynamicColorsOptions.Builder().build());
    }

    @Deprecated
    public static void applyToActivitiesIfAvailable(Application r1, int r2) {
        applyToActivitiesIfAvailable(r1, new DynamicColorsOptions.Builder().setThemeOverlay(r2).build());
    }

    @Deprecated
    public static void applyToActivitiesIfAvailable(Application r1, Precondition r2) {
        applyToActivitiesIfAvailable(r1, new DynamicColorsOptions.Builder().setPrecondition(r2).build());
    }

    @Deprecated
    public static void applyToActivitiesIfAvailable(Application r1, int r2, Precondition r3) {
        applyToActivitiesIfAvailable(r1, new DynamicColorsOptions.Builder().setThemeOverlay(r2).setPrecondition(r3).build());
    }

    public static void applyToActivitiesIfAvailable(Application r1, DynamicColorsOptions r2) {
        r1.registerActivityLifecycleCallbacks(new DynamicColorsActivityLifecycleCallbacks(r2));
    }

    @Deprecated
    public static void applyIfAvailable(Activity r0) {
        applyToActivityIfAvailable(r0);
    }

    @Deprecated
    public static void applyIfAvailable(Activity r1, int r2) {
        applyToActivityIfAvailable(r1, new DynamicColorsOptions.Builder().setThemeOverlay(r2).build());
    }

    @Deprecated
    public static void applyIfAvailable(Activity r1, Precondition r2) {
        applyToActivityIfAvailable(r1, new DynamicColorsOptions.Builder().setPrecondition(r2).build());
    }

    public static void applyToActivityIfAvailable(Activity r1) {
        applyToActivityIfAvailable(r1, new DynamicColorsOptions.Builder().build());
    }

    public static void applyToActivityIfAvailable(Activity r5, DynamicColorsOptions r6) {
        if (isDynamicColorAvailable() == true) goto L6;
        return;
    L6:
        if (r6.getContentBasedSeedColor() == null) goto L8;
        int r0 = 0;
    L13:
        if (r6.getPrecondition().shouldApplyDynamicColors(r5, r0) == true) goto L15;
        return;
    L15:
        if (r6.getContentBasedSeedColor() == null) goto L22;
        SchemeContent r1 = new SchemeContent(Hct.fromInt(r6.getContentBasedSeedColor().intValue()), !MaterialAttributes.resolveBoolean(r5, R.attr.isLightTheme, true), 0.0d);
        ColorResourcesOverride r2 = ColorResourcesOverride.getInstance();
        if (r2 != null) goto L20;
        return;
    L20:
        if (r2.applyIfPossible(r5, MaterialColorUtilitiesHelper.createColorResourcesIdsToColorValues(r1)) == true) goto L23;
        return;
    L23:
        r6.getOnAppliedCallback().onApplied(r5);
        return;
    L22:
        ThemeUtils.applyThemeOverlay(r5, r0);
        goto L23
    L8:
        if (r6.getThemeOverlay() != 0) goto L10;
        r0 = getDefaultThemeOverlay(r5);
        goto L13
    L10:
        r0 = r6.getThemeOverlay();
        goto L13
    }

    public static Context wrapContextIfAvailable(Context r1) {
        return wrapContextIfAvailable(r1, 0);
    }

    public static Context wrapContextIfAvailable(Context r1, int r2) {
        if (isDynamicColorAvailable() == true) goto L5;
        return r1;
    L5:
        if (r2 != 0) goto L7;
        r2 = getDefaultThemeOverlay(r1);
    L7:
        if (r2 != 0) goto L10;
        return r1;
    L10:
        return new ContextThemeWrapper(r1, r2);
    }

    public static boolean isDynamicColorAvailable() {
        if (BuildCompat.isAtLeastT() == false) goto L5;
        return true;
    L5:
        DeviceSupportCondition r0 = DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS.get(Build.MANUFACTURER.toLowerCase());
        if (r0 != null) goto L8;
        r0 = DYNAMIC_COLOR_SUPPORTED_BRANDS.get(Build.BRAND.toLowerCase());
    L8:
        if (r0 != null) goto L10;
    L12:
        return false;
    L10:
        if (r0.isSupported() == false) goto L12;
        return true;
    }

    private static int getDefaultThemeOverlay(Context r1) {
        TypedArray r2 = r1.obtainStyledAttributes(DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE);
        int r0 = r2.getResourceId(0, 0);
        r2.recycle();
        return r0;
    }
}
