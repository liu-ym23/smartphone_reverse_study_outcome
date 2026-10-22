package com.android.server.wm.utils;

import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public class RegionUtils {
    private RegionUtils() {
    }

    public static void rectListToRegion(List<Rect> rects, Region outRegion) {
        outRegion.setEmpty();
        int n = rects.size();
        int i = 0;
    L3:
        if (i >= n) goto L6;
        outRegion.union(rects.get(i));
        i = i + 1;
        goto L3
    }

    public static void forEachRect(Region region, Consumer<Rect> rectConsumer) {
        RegionIterator it = new RegionIterator(region);
        Rect rect = new Rect();
    L4:
        if (it.next(rect) == false) goto L6;
        rectConsumer.accept(rect);
        goto L4
    }

    public static void forEachRectReverse(Region region, Consumer<Rect> rectConsumer) {
        RegionIterator it = new RegionIterator(region);
        ArrayList<Rect> rects = new ArrayList();
        Rect rect = new Rect();
    L4:
        if (it.next(rect) == false) goto L6;
        rects.add(new Rect(rect));
        goto L4
    L6:
        Collections.reverse(rects);
        rects.forEach(rectConsumer);
    }

    public static int getAreaSize(Region region) {
        RegionIterator regionIterator = new RegionIterator(region);
        int area = 0;
        Rect rect = new Rect();
    L4:
        if (regionIterator.next(rect) == false) goto L6;
        area = area + (rect.width() * rect.height());
        goto L4
    L6:
        return area;
    }

    public static boolean sizeEquals(Rect a, Rect b) {
        if (a.width() == b.width()) goto L5;
    L7:
        return false;
    L5:
        if (a.height() != b.height()) goto L7;
        return true;
    }
}
