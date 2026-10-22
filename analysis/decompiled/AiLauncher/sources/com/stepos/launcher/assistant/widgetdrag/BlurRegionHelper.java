package com.stepos.launcher.assistant.widgetdrag;

import android.graphics.Rect;
import android.util.Log;
import android.view.SurfaceControl;

/* loaded from: classes.dex */
public class BlurRegionHelper {
    private static final String TAG = "GlobalWidgetDrag";

    public static void blurSurface(SurfaceControl surfaceControl, GlobalDragItemInfo globalDragItemInfo, int i10) {
        blurSurface(surfaceControl, globalDragItemInfo == null ? null : createBlurRegion(globalDragItemInfo, i10));
    }

    public static BlurRegion[] createBlurRegion(GlobalDragItemInfo globalDragItemInfo, int i10) {
        return createBlurRegion(GlobalDragItemInfoExt.getSurfaceVisualBound(globalDragItemInfo), 1.0f, globalDragItemInfo.getCornerRadius(), i10);
    }

    public static void blurSurface(SurfaceControl surfaceControl, BlurRegion[] blurRegionArr) {
        if (blurRegionArr == null || blurRegionArr.length == 0 || surfaceControl == null || !surfaceControl.isValid()) {
            return;
        }
        int length = blurRegionArr.length;
        float[][] fArr = new float[length][];
        for (int i10 = 0; i10 < length; i10++) {
            fArr[i10] = blurRegionArr[i10].toFloatArray();
            Log.d(TAG, "blurRegion:" + blurRegionArr[i10].toString());
        }
        SurfaceControl.Transaction transaction = new SurfaceControl.Transaction();
        transaction.setBlurRegions(surfaceControl, fArr);
        transaction.apply();
        transaction.close();
    }

    public static BlurRegion[] createBlurRegion(Rect rect, float f10, float f11, int i10) {
        if (f10 != 1.0f) {
            rect.scale(f10);
        }
        return new BlurRegion[]{new BlurRegion(i10, f11, f11, f11, f11, 1.0f, rect, 0)};
    }
}
