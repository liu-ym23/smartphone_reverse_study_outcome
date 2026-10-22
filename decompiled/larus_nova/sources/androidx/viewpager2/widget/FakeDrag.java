package androidx.viewpager2.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes17.dex */
final class FakeDrag {
    private int mActualDraggedDistance;
    private long mFakeDragBeginTime;
    private int mMaximumVelocity;
    private final RecyclerView mRecyclerView;
    private float mRequestedDragDistance;
    private final ScrollEventAdapter mScrollEventAdapter;
    private VelocityTracker mVelocityTracker;
    private final ViewPager2 mViewPager;

    private void beginFakeVelocityTracker() {
        VelocityTracker r100 = this.mVelocityTracker;
        if (r100 != null) goto L5;
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mMaximumVelocity = ViewConfiguration.get(this.mViewPager.getContext()).getScaledMaximumFlingVelocity();
        return;
    L5:
        r100.clear();
    }

    public boolean beginFakeDrag() {
        if (this.mScrollEventAdapter.isDragging() == false) goto L5;
        return false;
    L5:
        this.mActualDraggedDistance = 0;
        this.mRequestedDragDistance = 0;
        this.mFakeDragBeginTime = SystemClock.uptimeMillis();
        beginFakeVelocityTracker();
        this.mScrollEventAdapter.notifyBeginFakeDrag();
        if (this.mScrollEventAdapter.isIdle() == true) goto L8;
        this.mRecyclerView.stopScroll();
    L8:
        addFakeMotionEvent(this.mFakeDragBeginTime, 0, 0.0f, 0.0f);
        return true;
    }

    public boolean endFakeDrag() {
        if (this.mScrollEventAdapter.isFakeDragging() == true) goto L6;
        return false;
    L6:
        this.mScrollEventAdapter.notifyEndFakeDrag();
        VelocityTracker r100 = this.mVelocityTracker;
        r100.computeCurrentVelocity(1000, this.mMaximumVelocity);
        if (this.mRecyclerView.fling((int) r100.getXVelocity(), (int) r100.getYVelocity()) == true) goto L11;
        this.mViewPager.snapToPage();
        return true;
    L11:
        return true;
    }

    public boolean isFakeDragging() {
        return this.mScrollEventAdapter.isFakeDragging();
    }

    public boolean fakeDragBy(float r110) {
        int r100 = 0;
        if (this.mScrollEventAdapter.isFakeDragging() == true) goto L5;
        return false;
    L5:
        float r101 = this.mRequestedDragDistance - r110;
        this.mRequestedDragDistance = r101;
        int r111 = Math.round(r101 - this.mActualDraggedDistance);
        this.mActualDraggedDistance += r111;
        long r102 = SystemClock.uptimeMillis();
        if (this.mViewPager.getOrientation() != 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        int r104 = r111;
    L12:
        if (r103 == true) goto L16;
        r100 = r111;
    L16:
        if (r103 == false) goto L18;
        float r105 = this.mRequestedDragDistance;
    L19:
        if (r103 == false) goto L21;
        float r106 = 0.0f;
    L22:
        this.mRecyclerView.scrollBy(r104, r100);
        addFakeMotionEvent(r102, 2, r105, r106);
        return true;
    L21:
        r106 = this.mRequestedDragDistance;
        goto L22
    L18:
        r105 = 0.0f;
        goto L19
    L11:
        r104 = 0;
        goto L12
    L8:
        r103 = false;
        goto L9
    }

    public FakeDrag(ViewPager2 r100, ScrollEventAdapter r101, RecyclerView r102) {
        this.mViewPager = r100;
        this.mScrollEventAdapter = r101;
        this.mRecyclerView = r102;
    }

    private void addFakeMotionEvent(long r100, int r110, float r111, float r112) {
        MotionEvent r101 = MotionEvent.obtain(this.mFakeDragBeginTime, r100, r110, r111, r112, 0);
        this.mVelocityTracker.addMovement(r101);
        r101.recycle();
    }
}
