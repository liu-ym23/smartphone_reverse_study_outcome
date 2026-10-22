package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public abstract class OrientationHelper {
    public static final int HORIZONTAL = 0;
    private static final int INVALID_SIZE = Integer.MIN_VALUE;
    public static final int VERTICAL = 1;
    private int mLastTotalSpace;
    protected final RecyclerView.LayoutManager mLayoutManager;
    final Rect mTmpRect;

    public abstract int getDecoratedEnd(View r100);

    public abstract int getDecoratedMeasurement(View r100);

    public abstract int getDecoratedMeasurementInOther(View r100);

    public abstract int getDecoratedStart(View r100);

    public abstract int getEnd();

    public abstract int getEndAfterPadding();

    public abstract int getEndPadding();

    public abstract int getMode();

    public abstract int getModeInOther();

    public abstract int getStartAfterPadding();

    public abstract int getTotalSpace();

    public abstract int getTransformedEndWithDecoration(View r100);

    public abstract int getTransformedStartWithDecoration(View r100);

    public abstract void offsetChild(View r100, int r101);

    public abstract void offsetChildren(int r100);

    public int getTotalSpaceChange() {
        if (Integer.MIN_VALUE != this.mLastTotalSpace) goto L6;
        return 0;
    L6:
        return getTotalSpace() - this.mLastTotalSpace;
    }

    public void onLayoutComplete() {
        this.mLastTotalSpace = getTotalSpace();
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return this.mLayoutManager;
    }

    private OrientationHelper(RecyclerView.LayoutManager r100) {
        this.mLastTotalSpace = Integer.MIN_VALUE;
        this.mTmpRect = new Rect();
        this.mLayoutManager = r100;
    }

    public static OrientationHelper createHorizontalHelper(final RecyclerView.LayoutManager r100) {
        return new AnonymousClass1(r100);
    }

    public static OrientationHelper createVerticalHelper(final RecyclerView.LayoutManager r100) {
        return new AnonymousClass2(r100);
    }

    public /* synthetic */ OrientationHelper(RecyclerView.LayoutManager r100, AnonymousClass1 r101) {
        this(r100);
    }

    public static OrientationHelper createOrientationHelper(RecyclerView.LayoutManager r100, int r101) {
        if (r101 == 0) goto L10;
        if (r101 != 1) goto L8;
        return createVerticalHelper(r100);
    L8:
        throw new IllegalArgumentException("invalid orientation");
    L10:
        return createHorizontalHelper(r100);
    }
}
