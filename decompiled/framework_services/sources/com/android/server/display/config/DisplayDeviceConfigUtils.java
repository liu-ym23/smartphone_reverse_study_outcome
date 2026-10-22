package com.android.server.display.config;

import android.util.Slog;
import android.util.Spline;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayDeviceConfigUtils {
    private static final String TAG = "DisplayDeviceConfigUtils";

    public DisplayDeviceConfigUtils() {
    }

    public static <T> Spline createSpline(List<T> points, Function<T, BigDecimal> xExtractor, Function<T, BigDecimal> yExtractor) {
        int size = points.size();
        if (size != 0) goto L5;
        return null;
    L5:
        float[] x = new float[size];
        float[] y = new float[size];
        int i = 0;
        Iterator<T> r5 = points.iterator();
    L7:
        if (r5.hasNext() == false) goto L16;
        T point = r5.next();
        x[i] = xExtractor.apply(point).floatValue();
        if (i <= 0) goto L14;
        if (x[i] > x[i - 1]) goto L14;
        Slog.e(TAG, "spline control points must be strictly increasing, ignoring configuration. x: " + x[i] + " <= " + x[i - 1]);
        return null;
    L14:
        y[i] = yExtractor.apply(point).floatValue();
        i = i + 1;
        goto L7
    L16:
        return Spline.createSpline(x, y);
    }

    public static <T> float getHighestHdrSdrRatio(List<T> points, Function<T, BigDecimal> extractor) {
        float highestRatio = 1.0f;
        Iterator<T> r1 = points.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        T point = r1.next();
        float ratio = extractor.apply(point).floatValue();
        if (ratio <= highestRatio) goto L4;
        highestRatio = ratio;
        goto L4
    L9:
        return highestRatio;
    }
}
