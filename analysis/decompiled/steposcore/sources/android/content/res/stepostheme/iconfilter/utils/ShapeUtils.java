package android.content.res.stepostheme.iconfilter.utils;

import android.graphics.Point;

/* loaded from: classes.dex */
public class ShapeUtils {
    public static boolean isCanFormParallelogram(Point point1, Point point2, Point point3, Point point4) {
        return (point1.x == point2.x && point3.x == point4.x) ? point1.y - point2.y == point4.y - point3.y : (point1.x == point4.x && point2.x == point3.x) ? point1.y - point4.y == point2.y - point3.y : (((float) (point1.y - point2.y)) * 1.0f) / ((float) (point1.x - point2.x)) == (((float) (point4.y - point3.y)) * 1.0f) / ((float) (point4.x - point3.x)) && (((float) (point1.y - point4.y)) * 1.0f) / ((float) (point1.x - point4.x)) == (((float) (point3.y - point2.y)) * 1.0f) / ((float) (point3.x - point2.x));
    }
}
