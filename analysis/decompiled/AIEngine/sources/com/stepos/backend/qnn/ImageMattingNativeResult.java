package com.stepos.backend.qnn;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import com.stepos.base.data.ContourHierarchy;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ImageMattingNativeResult {
    private final ArrayList<ArrayList<Point>> contours;
    private final ArrayList<ContourHierarchy> hierarchies;
    private final Rect padding;
    private final float proportion;
    private final Bitmap resultBitmap;
    private final int sampleSize;

    public ImageMattingNativeResult(int i10, ArrayList<ArrayList<Point>> contours, ArrayList<ContourHierarchy> hierarchies, float f8, Bitmap bitmap, Rect padding) {
        kotlin.jvm.internal.g.f(contours, "contours");
        kotlin.jvm.internal.g.f(hierarchies, "hierarchies");
        kotlin.jvm.internal.g.f(padding, "padding");
        this.sampleSize = i10;
        this.contours = contours;
        this.hierarchies = hierarchies;
        this.proportion = f8;
        this.resultBitmap = bitmap;
        this.padding = padding;
    }

    public final ArrayList<ArrayList<Point>> getContours() {
        return this.contours;
    }

    public final ArrayList<ContourHierarchy> getHierarchies() {
        return this.hierarchies;
    }

    public final Rect getPadding() {
        return this.padding;
    }

    public final float getProportion() {
        return this.proportion;
    }

    public final Bitmap getResultBitmap() {
        return this.resultBitmap;
    }

    public final int getSampleSize() {
        return this.sampleSize;
    }
}
