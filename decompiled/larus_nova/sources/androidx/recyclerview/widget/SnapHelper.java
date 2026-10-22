package androidx.recyclerview.widget;

import android.content.Context;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

/* JADX INFO: loaded from: classes17.dex */
public abstract class SnapHelper extends RecyclerView.OnFlingListener {
    static final float MILLISECONDS_PER_INCH = 100.0f;
    private Scroller mGravityScroller;
    RecyclerView mRecyclerView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public abstract int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager r100, View r101);

    public abstract View findSnapView(RecyclerView.LayoutManager r100);

    public abstract int findTargetSnapPosition(RecyclerView.LayoutManager r100, int r101, int r102);

    private void destroyCallbacks() {
        this.mRecyclerView.removeOnScrollListener(this.mScrollListener);
        this.mRecyclerView.setOnFlingListener(null);
    }

    private void setupCallbacks() throws IllegalStateException {
        if (this.mRecyclerView.getOnFlingListener() != null) goto L7;
        this.mRecyclerView.addOnScrollListener(this.mScrollListener);
        this.mRecyclerView.setOnFlingListener(this);
        return;
    L7:
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    public void snapToTargetExistingView() {
        RecyclerView r100 = this.mRecyclerView;
        if (r100 != null) goto L5;
        return;
    L5:
        RecyclerView.LayoutManager r101 = r100.getLayoutManager();
        if (r101 != null) goto L8;
        return;
    L8:
        View r102 = findSnapView(r101);
        if (r102 != null) goto L11;
        return;
    L11:
        int[] r103 = calculateDistanceToFinalSnap(r101, r102);
        int r104 = r103[0];
        if (r104 == 0) goto L14;
    L15:
        this.mRecyclerView.smoothScrollBy(r104, r103[1]);
        return;
    L14:
        if (r103[1] != 0) goto L15;
    }

    public SnapHelper() {
        this.mScrollListener = new AnonymousClass1(this);
    }

    public void attachToRecyclerView(RecyclerView r100) throws IllegalStateException {
        RecyclerView r101 = this.mRecyclerView;
        if (r101 != r100) goto L5;
        return;
    L5:
        if (r101 == null) goto L7;
        destroyCallbacks();
    L7:
        this.mRecyclerView = r100;
        if (r100 == null) goto L11;
        setupCallbacks();
        this.mGravityScroller = new Scroller(this.mRecyclerView.getContext(), new DecelerateInterpolator());
        snapToTargetExistingView();
        return;
    }

    public RecyclerView.SmoothScroller createScroller(RecyclerView.LayoutManager r100) {
        return createSnapScroller(r100);
    }

    public LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager r100) {
        if ((r100 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == true) goto L6;
        return null;
    L6:
        final Context r101 = this.mRecyclerView.getContext();
        return new AnonymousClass2(this, r101);
    }

    public int[] calculateScrollDistance(int r110, int r111) {
        this.mGravityScroller.fling(0, 0, r110, r111, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.mGravityScroller.getFinalX(), this.mGravityScroller.getFinalY()};
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnFlingListener
    public boolean onFling(int r100, int r101) {
        RecyclerView.LayoutManager r102 = this.mRecyclerView.getLayoutManager();
        if (r102 != null) goto L6;
        return false;
    L6:
        if (this.mRecyclerView.getAdapter() != null) goto L8;
        return false;
    L8:
        int r103 = this.mRecyclerView.getMinFlingVelocity();
        if (Math.abs(r101) > r103) goto L13;
        if (Math.abs(r100) > r103) goto L13;
        return false;
    L13:
        if (snapFromFling(r102, r100, r101) == false) goto L17;
        return true;
    L17:
        return false;
    }

    private boolean snapFromFling(RecyclerView.LayoutManager r100, int r101, int r102) {
        if ((r100 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == true) goto L5;
        return false;
    L5:
        RecyclerView.SmoothScroller r103 = createScroller(r100);
        if (r103 != null) goto L8;
        return false;
    L8:
        int r104 = findTargetSnapPosition(r100, r101, r102);
        if (r104 != (-1)) goto L11;
        return false;
    L11:
        r103.setTargetPosition(r104);
        r100.startSmoothScroll(r103);
        return true;
    }
}
