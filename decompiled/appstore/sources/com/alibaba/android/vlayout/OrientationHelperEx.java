package com.alibaba.android.vlayout;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class OrientationHelperEx {
    public static final int HORIZONTAL = 0;
    private static final int INVALID_SIZE = Integer.MIN_VALUE;
    public static final int VERTICAL = 1;
    private int mLastTotalSpace;
    protected final ExposeLinearLayoutManagerEx mLayoutManager;

    public /* synthetic */ OrientationHelperEx(ExposeLinearLayoutManagerEx r10, AnonymousClass1 r11) {
        this(r10);
    }

    public static OrientationHelperEx createHorizontalHelper(final ExposeLinearLayoutManagerEx r10) {
        return new AnonymousClass1(r10);
    }

    public static OrientationHelperEx createOrientationHelper(ExposeLinearLayoutManagerEx r10, int r11) {
        if (r11 == 0) goto L10;
        if (r11 != 1) goto L8;
        return createVerticalHelper(r10);
    L8:
        throw new IllegalArgumentException("invalid orientation");
    L10:
        return createHorizontalHelper(r10);
    }

    public static OrientationHelperEx createVerticalHelper(final ExposeLinearLayoutManagerEx r10) {
        return new AnonymousClass2(r10);
    }

    public abstract int getDecoratedEnd(View r10);

    public abstract int getDecoratedMeasurement(View r10);

    public abstract int getDecoratedMeasurementInOther(View r10);

    public abstract int getDecoratedStart(View r10);

    public abstract int getEnd();

    public abstract int getEndAfterPadding();

    public abstract int getEndPadding();

    public abstract int getStartAfterPadding();

    public abstract int getTotalSpace();

    public int getTotalSpaceChange() {
        if (Integer.MIN_VALUE != this.mLastTotalSpace) goto L6;
        return 0;
    L6:
        return getTotalSpace() - this.mLastTotalSpace;
    }

    public abstract void offsetChild(View r10, int r11);

    public abstract void offsetChildren(int r10);

    public void onLayoutComplete() {
        this.mLastTotalSpace = getTotalSpace();
    }

    private OrientationHelperEx(ExposeLinearLayoutManagerEx r10) {
        this.mLastTotalSpace = Integer.MIN_VALUE;
        this.mLayoutManager = r10;
    }
}
