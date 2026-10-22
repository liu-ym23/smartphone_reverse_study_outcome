package com.google.android.material.color;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class HarmonizedColors {
    private static final String TAG = "HarmonizedColors";

    static {
    }

    public static boolean isHarmonizedColorAvailable() {
        return true;
    }

    private HarmonizedColors() {
    }

    public static void applyToContextIfAvailable(Context r2, HarmonizedColorsOptions r3) {
        if (isHarmonizedColorAvailable() == true) goto L5;
        return;
    L5:
        Map<Integer, Integer> r0 = createHarmonizedColorReplacementMap(r2, r3);
        int r4 = r3.getThemeOverlayResourceId(0);
        if (ResourcesLoaderUtils.addResourcesLoaderToContext(r2, r0) == false) goto L10;
        if (r4 == 0) goto L11;
        ThemeUtils.applyThemeOverlay(r2, r4);
        return;
    L11:
        return;
    }

    public static Context wrapContextIfAvailable(Context r2, HarmonizedColorsOptions r3) {
        if (isHarmonizedColorAvailable() == true) goto L5;
        return r2;
    L5:
        Map<Integer, Integer> r0 = createHarmonizedColorReplacementMap(r2, r3);
        ContextThemeWrapper r1 = new ContextThemeWrapper(r2, r3.getThemeOverlayResourceId(R.style.ThemeOverlay_Material3_HarmonizedColors_Empty));
        r1.applyOverrideConfiguration(new Configuration());
        if (ResourcesLoaderUtils.addResourcesLoaderToContext(r1, r0) == true) goto L8;
        return r2;
    L8:
        return r1;
    }

    private static Map<Integer, Integer> createHarmonizedColorReplacementMap(Context r7, HarmonizedColorsOptions r8) {
        HashMap r0 = new HashMap();
        int r1 = MaterialColors.getColor(r7, r8.getColorAttributeToHarmonizeWith(), TAG);
        int[] r2 = r8.getColorResourceIds();
        int r3 = r2.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L5;
        int r5 = r2[r4];
        int r6 = MaterialColors.harmonize(ContextCompat.getColor(r7, r5), r1);
        r0.put(Integer.valueOf(r5), Integer.valueOf(r6));
        r4 = r4 + 1;
        goto L3
    L5:
        HarmonizedColorAttributes r9 = r8.getColorAttributes();
        if (r9 == null) goto L16;
        int[] r10 = r9.getAttributes();
        if (r10.length <= 0) goto L16;
        int r11 = r9.getThemeOverlay();
        TypedArray r12 = r7.obtainStyledAttributes(r10);
        if (r11 == 0) goto L12;
        TypedArray r13 = new ContextThemeWrapper(r7, r11).obtainStyledAttributes(r10);
    L13:
        addHarmonizedColorAttributesToReplacementMap(r0, r12, r13, r1);
        r12.recycle();
        if (r13 == null) goto L16;
        r13.recycle();
        goto L16
    L12:
        r13 = null;
    L16:
        return r0;
    }

    private static void addHarmonizedColorAttributesToReplacementMap(Map<Integer, Integer> r4, TypedArray r5, TypedArray r6, int r7) {
        if (r6 != null) goto L5;
        r6 = r5;
    L5:
        int r1 = 0;
    L7:
        if (r1 >= r5.getIndexCount()) goto L16;
        int r2 = r6.getResourceId(r1, 0);
        if (r2 == 0) goto L15;
        if (r5.hasValue(r1) == false) goto L15;
        if (ResourcesLoaderUtils.isColorResource(r5.getType(r1)) == false) goto L15;
        r4.put(Integer.valueOf(r2), Integer.valueOf(MaterialColors.harmonize(r5.getColor(r1, 0), r7)));
    L15:
        r1 = r1 + 1;
        goto L7
    }
}
