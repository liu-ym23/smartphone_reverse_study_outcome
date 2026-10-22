package com.google.android.material.shape;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.internal.ViewUtils;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialShapeUtils {
    private MaterialShapeUtils() {
    }

    @NonNull
    public static CornerTreatment createCornerTreatment(int r10) {
        if (r10 == 0) goto L10;
        if (r10 == 1) goto L8;
        return createDefaultCornerTreatment();
    L8:
        return new CutCornerTreatment();
    L10:
        return new RoundedCornerTreatment();
    }

    @NonNull
    public static CornerTreatment createDefaultCornerTreatment() {
        return new RoundedCornerTreatment();
    }

    @NonNull
    public static EdgeTreatment createDefaultEdgeTreatment() {
        return new EdgeTreatment();
    }

    public static void setElevation(@NonNull View r10, float r11) {
        Drawable r12 = r10.getBackground();
        if ((r12 instanceof MaterialShapeDrawable) == false) goto L6;
        ((MaterialShapeDrawable) r12).setElevation(r11);
        return;
    }

    public static void setParentAbsoluteElevation(@NonNull View r10) {
        Drawable r11 = r10.getBackground();
        if ((r11 instanceof MaterialShapeDrawable) == false) goto L6;
        setParentAbsoluteElevation(r10, (MaterialShapeDrawable) r11);
        return;
    }

    public static void setParentAbsoluteElevation(@NonNull View r10, @NonNull MaterialShapeDrawable r11) {
        if (r11.isElevationOverlayEnabled() == false) goto L6;
        r11.setParentAbsoluteElevation(ViewUtils.getParentAbsoluteElevation(r10));
        return;
    }
}
