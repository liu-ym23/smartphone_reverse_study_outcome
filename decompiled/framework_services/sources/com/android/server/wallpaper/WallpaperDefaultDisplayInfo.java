package com.android.server.wallpaper;

import android.R;
import android.app.WallpaperManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.WindowManager;
import android.view.WindowMetrics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class WallpaperDefaultDisplayInfo {
    public final SparseArray<Point> defaultDisplaySizes;
    final List<FoldableOrientations> foldableOrientations;
    public final boolean isFoldable;
    public final boolean isLargeScreen;

    static final class FoldableOrientations {
        public final int foldedOrientation;
        public final int unfoldedOrientation;

        FoldableOrientations(int foldedOrientation, int unfoldedOrientation) {
            this.foldedOrientation = foldedOrientation;
            this.unfoldedOrientation = unfoldedOrientation;
        }

        public boolean equals(Object other) {
            if (this != other) goto L6;
            return true;
        L6:
            if ((other instanceof FoldableOrientations) == false) goto L14;
            FoldableOrientations that = (FoldableOrientations) other;
            if (this.foldedOrientation != that.foldedOrientation) goto L13;
            if (this.unfoldedOrientation != that.unfoldedOrientation) goto L13;
            return true;
        L13:
            return false;
        L14:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.foldedOrientation), Integer.valueOf(this.unfoldedOrientation)});
        }
    }

    public WallpaperDefaultDisplayInfo() {
        this.defaultDisplaySizes = new SparseArray();
        this.isLargeScreen = false;
        this.isFoldable = false;
        this.foldableOrientations = Collections.emptyList();
    }

    public WallpaperDefaultDisplayInfo(WindowManager windowManager, Resources resources) {
        boolean isFoldable = false;
        Set<WindowMetrics> metrics = windowManager.getPossibleMaximumWindowMetrics(0);
        if (resources.getIntArray(R.array.config_locationExtraPackageNames).length <= 0) goto L5;
        isFoldable = true;
    L5:
        if (isFoldable == false) goto L7;
        this.foldableOrientations = getFoldableOrientations(metrics);
    L8:
        this.defaultDisplaySizes = getDisplaySizes(metrics);
        this.isLargeScreen = isLargeScreen(metrics);
        this.isFoldable = isFoldable;
        return;
    L7:
        this.foldableOrientations = Collections.emptyList();
        goto L8
    }

    public boolean equals(Object other) {
        if (this != other) goto L6;
        return true;
    L6:
        if ((other instanceof WallpaperDefaultDisplayInfo) == false) goto L18;
        WallpaperDefaultDisplayInfo that = (WallpaperDefaultDisplayInfo) other;
        if (this.isLargeScreen != that.isLargeScreen) goto L17;
        if (this.isFoldable != that.isFoldable) goto L17;
        if (this.defaultDisplaySizes.contentEquals(that.defaultDisplaySizes) == false) goto L17;
        if (Objects.equals(this.foldableOrientations, that.foldableOrientations) == false) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    public int hashCode() {
        return (Objects.hash(new Object[]{Boolean.valueOf(this.isLargeScreen), Boolean.valueOf(this.isFoldable), this.foldableOrientations}) * 31) + this.defaultDisplaySizes.contentHashCode();
    }

    public int getFoldedOrientation(int unfoldedOrientation) {
        Iterator<FoldableOrientations> r0 = this.foldableOrientations.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        FoldableOrientations orientations = r0.next();
        if (orientations.unfoldedOrientation != unfoldedOrientation) goto L4;
        return orientations.foldedOrientation;
    L10:
        return -1;
    }

    public int getUnfoldedOrientation(int foldedOrientation) {
        Iterator<FoldableOrientations> r0 = this.foldableOrientations.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        FoldableOrientations orientations = r0.next();
        if (orientations.foldedOrientation != foldedOrientation) goto L4;
        return orientations.unfoldedOrientation;
    L10:
        return -1;
    }

    private static SparseArray<Point> getDisplaySizes(Set<WindowMetrics> displayMetrics) {
        SparseArray<Point> displaySizes = new SparseArray();
        Iterator<WindowMetrics> r1 = displayMetrics.iterator();
    L4:
        if (r1.hasNext() == false) goto L15;
        WindowMetrics metric = r1.next();
        Rect bounds = metric.getBounds();
        Point displaySize = new Point(bounds.width(), bounds.height());
        Point reversedDisplaySize = new Point(displaySize.y, displaySize.x);
        Iterator r6 = List.of(displaySize, reversedDisplaySize).iterator();
    L7:
        if (r6.hasNext() == false) goto L4;
        Point point = (Point) r6.next();
        int orientation = WallpaperManager.getOrientation(point);
        Point display = displaySizes.get(orientation);
        if (display == null) goto L12;
        if ((display.x * display.y) >= (point.x * point.y)) goto L7;
    L12:
        displaySizes.put(orientation, point);
        goto L7
    L15:
        return displaySizes;
    }

    private static boolean isLargeScreen(Set<WindowMetrics> displayMetrics) {
        float smallestWidth = Float.MAX_VALUE;
        Iterator<WindowMetrics> r1 = displayMetrics.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        WindowMetrics metric = r1.next();
        Rect bounds = metric.getBounds();
        smallestWidth = Math.min(smallestWidth, bounds.width() / metric.getDensity());
        goto L4
    L7:
        if (smallestWidth < 600.0f) goto L9;
        return true;
    L9:
        return false;
    }

    private static List<FoldableOrientations> getFoldableOrientations(Set<WindowMetrics> defaultDisplayMetrics) {
        if (defaultDisplayMetrics.size() != 2) goto L5;
        List<FoldableOrientations> foldableOrientations = new ArrayList();
        float surface = 0.0f;
        int firstOrientation = -1;
        Iterator<WindowMetrics> r3 = defaultDisplayMetrics.iterator();
    L8:
        if (r3.hasNext() == false) goto L19;
        WindowMetrics metric = r3.next();
        Rect bounds = metric.getBounds();
        Point displaySize = new Point(bounds.width(), bounds.height());
        int orientation = WallpaperManager.getOrientation(displaySize);
        float newSurface = (displaySize.x * displaySize.y) / (metric.getDensity() * metric.getDensity());
        if (surface <= 0.0f) goto L11;
        if (newSurface <= surface) goto L15;
        FoldableOrientations orientations = new FoldableOrientations(firstOrientation, orientation);
    L16:
        FoldableOrientations rotatedOrientations = new FoldableOrientations(WallpaperManager.getRotatedOrientation(orientations.foldedOrientation), WallpaperManager.getRotatedOrientation(orientations.unfoldedOrientation));
        foldableOrientations.add(orientations);
        foldableOrientations.add(rotatedOrientations);
        goto L8
    L15:
        orientations = new FoldableOrientations(orientation, firstOrientation);
        goto L16
    L11:
        surface = newSurface;
        firstOrientation = orientation;
        goto L8
    L19:
        return Collections.unmodifiableList(foldableOrientations);
    L5:
        return Collections.emptyList();
    }
}
