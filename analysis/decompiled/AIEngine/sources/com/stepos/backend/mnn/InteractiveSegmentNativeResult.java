package com.stepos.backend.mnn;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.stepos.base.data.ContourHierarchy;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class InteractiveSegmentNativeResult {
    public final ArrayList<ArrayList<Point>> contours;
    public final ArrayList<ContourHierarchy> hierarchies;
    public final Bitmap mask;

    public InteractiveSegmentNativeResult(ArrayList<ArrayList<Point>> contours, ArrayList<ContourHierarchy> hierarchies, Bitmap mask) {
        kotlin.jvm.internal.g.f(contours, "contours");
        kotlin.jvm.internal.g.f(hierarchies, "hierarchies");
        kotlin.jvm.internal.g.f(mask, "mask");
        this.contours = contours;
        this.hierarchies = hierarchies;
        this.mask = mask;
    }
}
