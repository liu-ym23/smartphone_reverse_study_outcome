package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import com.alipay.sdk.m.u.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
public class ViewPager extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final Comparator<ItemInfo> COMPARATOR = null;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    static final int[] LAYOUT_ATTRS = null;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private static final Interpolator sInterpolator = null;
    private static final ViewPositionComparator sPositionComparator = null;
    private int mActivePointerId;
    PagerAdapter mAdapter;
    private List<OnAdapterChangeListener> mAdapterChangeListeners;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable;
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout;
    private float mFirstOffset;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList<ItemInfo> mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset;
    private EdgeEffect mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets;
    private PagerObserver mObserver;
    private int mOffscreenPageLimit;
    private OnPageChangeListener mOnPageChangeListener;
    private List<OnPageChangeListener> mOnPageChangeListeners;
    private int mPageMargin;
    private PageTransformer mPageTransformer;
    private int mPageTransformerLayerType;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private EdgeEffect mRightEdge;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private final ItemInfo mTempItem;
    private final Rect mTempRect;
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DecorView {
    }

    public static class ItemInfo {
        Object object;
        float offset;
        int position;
        boolean scrolling;
        float widthFactor;

        public ItemInfo() {
        }
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {
        int childIndex;
        public int gravity;
        public boolean isDecor;
        boolean needsMeasure;
        int position;
        float widthFactor;

        public LayoutParams() {
            super(-1, -1);
            this.widthFactor = 0.0f;
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.widthFactor = 0.0f;
            TypedArray r102 = r100.obtainStyledAttributes(r101, ViewPager.LAYOUT_ATTRS);
            this.gravity = r102.getInteger(0, 48);
            r102.recycle();
        }
    }

    public class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
        final /* synthetic */ ViewPager this$0;

        private boolean canScroll() {
            PagerAdapter r100 = this.this$0.mAdapter;
            if (r100 != null) goto L5;
        L7:
            return false;
        L5:
            if (r100.getCount() <= 1) goto L7;
            return true;
        }

        public MyAccessibilityDelegate(ViewPager r100) {
            this.this$0 = r100;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View r100, AccessibilityEvent r101) {
            super.onInitializeAccessibilityEvent(r100, r101);
            r101.setClassName(ViewPager.class.getName());
            r101.setScrollable(canScroll());
            if (r101.getEventType() != 4096) goto L8;
            PagerAdapter r102 = this.this$0.mAdapter;
            if (r102 == null) goto L9;
            r101.setItemCount(r102.getCount());
            r101.setFromIndex(this.this$0.mCurItem);
            r101.setToIndex(this.this$0.mCurItem);
            return;
        L9:
            return;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
            super.onInitializeAccessibilityNodeInfo(r100, r101);
            r101.setClassName(ViewPager.class.getName());
            r101.setScrollable(canScroll());
            if (this.this$0.canScrollHorizontally(1) == false) goto L6;
            r101.addAction(4096);
        L6:
            if (this.this$0.canScrollHorizontally(-1) == false) goto L9;
            r101.addAction(8192);
            return;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View r100, int r101, Bundle r102) {
            if (super.performAccessibilityAction(r100, r101, r102) == false) goto L6;
            return true;
        L6:
            if (r101 == 4096) goto L16;
            if (r101 == 8192) goto L11;
            return false;
        L11:
            if (this.this$0.canScrollHorizontally(-1) == false) goto L14;
            ViewPager r103 = this.this$0;
            r103.setCurrentItem(r103.mCurItem - 1);
            return true;
        L14:
            return false;
        L16:
            if (this.this$0.canScrollHorizontally(1) == false) goto L19;
            ViewPager r104 = this.this$0;
            r104.setCurrentItem(r104.mCurItem + 1);
            return true;
        L19:
            return false;
        }
    }

    public interface OnAdapterChangeListener {
        void onAdapterChanged(ViewPager r100, PagerAdapter r101, PagerAdapter r102);
    }

    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int r100);

        void onPageScrolled(int r100, float r101, int r102);

        void onPageSelected(int r100);
    }

    public interface PageTransformer {
        void transformPage(View r100, float r101);
    }

    public class PagerObserver extends DataSetObserver {
        final /* synthetic */ ViewPager this$0;

        @Override // android.database.DataSetObserver
        public void onChanged() {
            this.this$0.dataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            this.this$0.dataSetChanged();
        }

        public PagerObserver(ViewPager r100) {
            this.this$0 = r100;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        Parcelable adapterState;
        ClassLoader loader;
        int position;

        static {
            CREATOR = new AnonymousClass1();
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + i.f25855d;
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        public SavedState(Parcel r100, ClassLoader r101) {
            super(r100, r101);
            if (r101 != null) goto L5;
            r101 = getClass().getClassLoader();
        L5:
            this.position = r100.readInt();
            this.adapterState = r100.readParcelable(r101);
            this.loader = r101;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeInt(this.position);
            r100.writeParcelable(this.adapterState, r101);
        }
    }

    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        public SimpleOnPageChangeListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int r100) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int r100, float r101, int r102) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r100) {
        }
    }

    public static class ViewPositionComparator implements Comparator<View> {
        public ViewPositionComparator() {
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(View r100, View r101) {
            LayoutParams r102 = (LayoutParams) r100.getLayoutParams();
            LayoutParams r103 = (LayoutParams) r101.getLayoutParams();
            boolean r104 = r102.isDecor;
            if (r104 == r103.isDecor) goto L9;
            if (r104 == false) goto L6;
            return 1;
        L6:
            return -1;
        L9:
            return r102.position - r103.position;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(View r100, View r101) {
            return compare2(r100, r101);
        }
    }

    static {
        LAYOUT_ATTRS = new int[]{R.attr.layout_gravity};
        COMPARATOR = new AnonymousClass1();
        sInterpolator = new AnonymousClass2();
        sPositionComparator = new ViewPositionComparator();
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker r100 = this.mVelocityTracker;
        if (r100 == null) goto L6;
        r100.recycle();
        this.mVelocityTracker = null;
        return;
    }

    private void removeNonDecorViews() {
        int r100 = 0;
    L4:
        if (r100 >= getChildCount()) goto L9;
        if (((LayoutParams) getChildAt(r100).getLayoutParams()).isDecor == true) goto L8;
        removeViewAt(r100);
        r100 = r100 - 1;
    L8:
        r100 = r100 + 1;
        goto L4
    }

    private boolean resetTouch() {
        this.mActivePointerId = -1;
        endDrag();
        this.mLeftEdge.onRelease();
        this.mRightEdge.onRelease();
        if (this.mLeftEdge.isFinished() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mRightEdge.isFinished() == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public void computeScroll() {
        this.mIsScrollStarted = true;
        if (this.mScroller.isFinished() == false) goto L5;
    L14:
        completeScroll(true);
        return;
    L5:
        if (this.mScroller.computeScrollOffset() == false) goto L14;
        int r100 = getScrollX();
        int r101 = getScrollY();
        int r102 = this.mScroller.getCurrX();
        int r103 = this.mScroller.getCurrY();
        if (r100 != r102) goto L9;
        if (r101 != r103) goto L9;
    L12:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L9:
        scrollTo(r102, r103);
        if (pageScrolled(r102) == true) goto L12;
        this.mScroller.abortAnimation();
        scrollTo(0, r103);
        goto L12
    }

    void initViewPager() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context r100 = getContext();
        this.mScroller = new Scroller(r100, sInterpolator);
        ViewConfiguration r101 = ViewConfiguration.get(r100);
        float r102 = INVOKEVIRTUAL_androidx_viewpager_widget_ViewPager_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density;
        this.mTouchSlop = r101.getScaledPagingTouchSlop();
        this.mMinimumVelocity = (int) (400.0f * r102);
        this.mMaximumVelocity = r101.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffect(r100);
        this.mRightEdge = new EdgeEffect(r100);
        this.mFlingDistance = (int) (25.0f * r102);
        this.mCloseEnough = (int) (2.0f * r102);
        this.mDefaultGutterSize = (int) (r102 * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new MyAccessibilityDelegate(this));
        if (ViewCompat.getImportantForAccessibility(this) != 0) goto L5;
        ViewCompat.setImportantForAccessibility(this, 1);
    L5:
        ViewCompat.setOnApplyWindowInsetsListener(this, new AnonymousClass4(this));
    }

    private void sortChildDrawingOrder() {
        if (this.mDrawingOrder == 0) goto L14;
        ArrayList<View> r100 = this.mDrawingOrderedChildren;
        if (r100 != null) goto L7;
        this.mDrawingOrderedChildren = new ArrayList();
    L8:
        int r101 = getChildCount();
        int r102 = 0;
    L9:
        if (r102 >= r101) goto L11;
        View r103 = getChildAt(r102);
        this.mDrawingOrderedChildren.add(r103);
        r102 = r102 + 1;
        goto L9
    L11:
        Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        return;
    L7:
        r100.clear();
        goto L8
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged == false) goto L6;
        return false;
    L6:
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        VelocityTracker r100 = this.mVelocityTracker;
        if (r100 != null) goto L9;
        this.mVelocityTracker = VelocityTracker.obtain();
    L10:
        long r110 = SystemClock.uptimeMillis();
        MotionEvent r101 = MotionEvent.obtain(r110, r110, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(r101);
        r101.recycle();
        this.mFakeDragBeginTime = r110;
        return true;
    L9:
        r100.clear();
        goto L10
    }

    public void clearOnPageChangeListeners() {
        List<OnPageChangeListener> r100 = this.mOnPageChangeListeners;
        if (r100 == null) goto L6;
        r100.clear();
        return;
    }

    void dataSetChanged() {
        int r100 = this.mAdapter.getCount();
        this.mExpectedAdapterCount = r100;
        if (this.mItems.size() < ((this.mOffscreenPageLimit * 2) + 1)) goto L5;
    L7:
        boolean r101 = false;
    L8:
        int r102 = this.mCurItem;
        int r103 = 0;
        boolean r104 = false;
    L10:
        if (r103 >= this.mItems.size()) goto L30;
        ItemInfo r105 = (ItemInfo) ListProtector.get(this.mItems, r103);
        int r106 = this.mAdapter.getItemPosition(r105.object);
        if (r106 == (-1)) goto L29;
        if (r106 != (-2)) goto L23;
        ListProtector.remove(this.mItems, r103);
        r103 = r103 - 1;
        if (r104 == true) goto L19;
        this.mAdapter.startUpdate(this);
        r104 = true;
    L19:
        this.mAdapter.destroyItem(this, r105.position, r105.object);
        int r107 = this.mCurItem;
        if (r107 != r105.position) goto L22;
        r102 = Math.max(0, Math.min(r107, r100 - 1));
    L22:
        r101 = true;
        goto L29
    L23:
        int r108 = r105.position;
        if (r108 == r106) goto L29;
        if (r108 != this.mCurItem) goto L28;
        r102 = r106;
    L28:
        r105.position = r106;
    L29:
        r103 = r103 + 1;
        goto L10
    L30:
        if (r104 == false) goto L32;
        this.mAdapter.finishUpdate(this);
    L32:
        Collections.sort(this.mItems, COMPARATOR);
        if (r101 == false) goto L49;
        int r109 = getChildCount();
        int r110 = 0;
    L35:
        if (r110 >= r109) goto L40;
        LayoutParams r111 = (LayoutParams) getChildAt(r110).getLayoutParams();
        if (r111.isDecor == true) goto L39;
        r111.widthFactor = 0.0f;
    L39:
        r110 = r110 + 1;
        goto L35
    L40:
        setCurrentItemInternal(r102, false, true);
        requestLayout();
        return;
    L49:
        return;
    L5:
        if (this.mItems.size() >= r100) goto L7;
        r101 = true;
        goto L8
    }

    public void endFakeDrag() {
        if (this.mFakeDragging == false) goto L10;
        if (this.mAdapter == null) goto L7;
        VelocityTracker r100 = this.mVelocityTracker;
        r100.computeCurrentVelocity(1000, this.mMaximumVelocity);
        int r101 = (int) r100.getXVelocity(this.mActivePointerId);
        this.mPopulatePending = true;
        int r102 = getClientWidth();
        int r103 = getScrollX();
        ItemInfo r104 = infoForCurrentScrollPosition();
        setCurrentItemInternal(determineTargetPage(r104.position, ((r103 / r102) - r104.offset) / r104.widthFactor, r101, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, r101);
    L7:
        endDrag();
        this.mFakeDragging = false;
        return;
    L10:
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        Scroller r100 = this.mScroller;
        if (r100 != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        return;
    L5:
        if (r100.isFinished() == true) goto L7;
        this.mScroller.abortAnimation();
        goto L7
    }

    boolean pageLeft() {
        int r100 = this.mCurItem;
        if (r100 <= 0) goto L6;
        setCurrentItem(r100 - 1, true);
        return true;
    L6:
        return false;
    }

    boolean pageRight() {
        PagerAdapter r100 = this.mAdapter;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (this.mCurItem >= (r100.getCount() - 1)) goto L10;
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    L10:
        return false;
    }

    void populate() {
        populate(this.mCurItem);
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private ItemInfo infoForCurrentScrollPosition() {
        int r100 = getClientWidth();
        float r101 = 0.0f;
        if (r100 <= 0) goto L5;
        float r102 = getScrollX() / r100;
    L6:
        if (r100 <= 0) goto L8;
        float r103 = this.mPageMargin / r100;
    L9:
        ItemInfo r104 = null;
        float r105 = 0.0f;
        int r106 = -1;
        int r107 = 0;
        boolean r108 = true;
    L11:
        if (r107 >= this.mItems.size()) goto L30;
        ItemInfo r110 = (ItemInfo) ListProtector.get(this.mItems, r107);
        if (r108 == true) goto L17;
        int r109 = r106 + 1;
        if (r110.position == r109) goto L17;
        r110 = this.mTempItem;
        r110.offset = (r101 + r105) + r103;
        r110.position = r109;
        r110.widthFactor = this.mAdapter.getPageWidth(r109);
        r107 = r107 - 1;
    L17:
        ItemInfo r111 = r110;
        r101 = r111.offset;
        float r112 = (r111.widthFactor + r101) + r103;
        if (r108 == true) goto L24;
        if (r102 >= r101) goto L24;
        return r104;
    L24:
        if (r102 < r112) goto L29;
        if (r107 == (this.mItems.size() - 1)) goto L29;
        int r113 = r111.position;
        float r114 = r111.widthFactor;
        r107 = r107 + 1;
        r108 = false;
        r106 = r113;
        r105 = r114;
        r104 = r111;
    L29:
        return r111;
    L30:
        return r104;
    L8:
        r103 = 0.0f;
        goto L9
    L5:
        r102 = 0.0f;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable r100 = this.mMarginDrawable;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isStateful() == false) goto L9;
        r100.setState(getDrawableState());
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        r100.position = this.mCurItem;
        PagerAdapter r101 = this.mAdapter;
        if (r101 == null) goto L5;
        r100.adapterState = r101.saveState();
    L5:
        return r100;
    }

    public PagerAdapter getAdapter() {
        return this.mAdapter;
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    public ViewPager(Context r100) {
        super(r100);
        this.mItems = new ArrayList();
        this.mTempItem = new ItemInfo();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new AnonymousClass3(this);
        this.mScrollState = 0;
        initViewPager();
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_viewpager_widget_ViewPager_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private void completeScroll(boolean r100) {
        if (this.mScrollState != 2) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L15;
        setScrollingCacheEnabled(false);
        if ((!this.mScroller.isFinished()) == false) goto L15;
        this.mScroller.abortAnimation();
        int r102 = getScrollX();
        int r103 = getScrollY();
        int r104 = this.mScroller.getCurrX();
        int r105 = this.mScroller.getCurrY();
        if (r102 != r104) goto L12;
        if (r103 == r105) goto L15;
    L12:
        scrollTo(r104, r105);
        if (r104 == r102) goto L15;
        pageScrolled(r104);
    L15:
        this.mPopulatePending = false;
        int r106 = 0;
    L17:
        if (r106 >= this.mItems.size()) goto L22;
        ItemInfo r107 = (ItemInfo) ListProtector.get(this.mItems, r106);
        if (r107.scrolling == false) goto L21;
        r107.scrolling = false;
        r101 = true;
    L21:
        r106 = r106 + 1;
        goto L17
    L22:
        if (r101 == false) goto L30;
        if (r100 == false) goto L25;
        ViewCompat.postOnAnimation(this, this.mEndScrollRunnable);
        return;
    L25:
        this.mEndScrollRunnable.run();
        return;
    L30:
        return;
    L5:
        r101 = false;
        goto L6
    }

    private void dispatchOnPageSelected(int r100) {
        OnPageChangeListener r101 = this.mOnPageChangeListener;
        if (r101 == null) goto L5;
        r101.onPageSelected(r100);
    L5:
        List<OnPageChangeListener> r102 = this.mOnPageChangeListeners;
        if (r102 == null) goto L13;
        int r103 = r102.size();
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L13;
        OnPageChangeListener r105 = (OnPageChangeListener) ListProtector.get(this.mOnPageChangeListeners, r104);
        if (r105 == null) goto L12;
        r105.onPageSelected(r100);
    L12:
        r104 = r104 + 1;
    L13:
        OnPageChangeListener r106 = this.mInternalPageChangeListener;
        if (r106 == null) goto L20;
        r106.onPageSelected(r100);
        return;
    }

    private void dispatchOnScrollStateChanged(int r100) {
        OnPageChangeListener r101 = this.mOnPageChangeListener;
        if (r101 == null) goto L5;
        r101.onPageScrollStateChanged(r100);
    L5:
        List<OnPageChangeListener> r102 = this.mOnPageChangeListeners;
        if (r102 == null) goto L13;
        int r103 = r102.size();
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L13;
        OnPageChangeListener r105 = (OnPageChangeListener) ListProtector.get(this.mOnPageChangeListeners, r104);
        if (r105 == null) goto L12;
        r105.onPageScrollStateChanged(r100);
    L12:
        r104 = r104 + 1;
    L13:
        OnPageChangeListener r106 = this.mInternalPageChangeListener;
        if (r106 == null) goto L20;
        r106.onPageScrollStateChanged(r100);
        return;
    }

    private void enableLayers(boolean r100) {
        int r101 = getChildCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        if (r100 == false) goto L6;
        int r103 = this.mPageTransformerLayerType;
    L7:
        getChildAt(r102).setLayerType(r103, null);
        r102 = r102 + 1;
        goto L3
    L6:
        r103 = 0;
        goto L7
    }

    private static boolean isDecorView(View r100) {
        if (r100.getClass().getAnnotation(DecorView.class) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private void onSecondaryPointerUp(MotionEvent r100) {
        int r101 = r100.getActionIndex();
        if (r100.getPointerId(r101) != this.mActivePointerId) goto L11;
        if (r101 != 0) goto L6;
        int r102 = 1;
    L7:
        this.mLastMotionX = r100.getX(r102);
        this.mActivePointerId = r100.getPointerId(r102);
        VelocityTracker r103 = this.mVelocityTracker;
        if (r103 == null) goto L12;
        r103.clear();
        return;
    L12:
        return;
    L6:
        r102 = 0;
        goto L7
    }

    private boolean pageScrolled(int r100) {
        if (this.mItems.size() == 0) goto L5;
        ItemInfo r101 = infoForCurrentScrollPosition();
        int r102 = getClientWidth();
        int r103 = this.mPageMargin;
        int r104 = r102 + r103;
        float r105 = r102;
        int r106 = r101.position;
        float r107 = ((r100 / r105) - r101.offset) / (r101.widthFactor + (r103 / r105));
        this.mCalledSuper = false;
        onPageScrolled(r106, r107, (int) (r104 * r107));
        if (this.mCalledSuper == false) goto L17;
        return true;
    L17:
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    L5:
        if (this.mFirstLayout == false) goto L7;
        return false;
    L7:
        this.mCalledSuper = false;
        onPageScrolled(0, 0.0f, 0);
        if (this.mCalledSuper == false) goto L11;
        return false;
    L11:
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean performDrag(float r110) {
        float r100 = this.mLastMotionX - r110;
        this.mLastMotionX = r110;
        float r111 = getScrollX() + r100;
        float r101 = getClientWidth();
        float r102 = this.mFirstOffset * r101;
        float r103 = this.mLastOffset * r101;
        boolean r104 = false;
        ItemInfo r105 = (ItemInfo) ListProtector.get(this.mItems, 0);
        ArrayList<ItemInfo> r106 = this.mItems;
        ItemInfo r107 = (ItemInfo) ListProtector.get(r106, r106.size() - 1);
        if (r105.position == 0) goto L5;
        r102 = r105.offset * r101;
        boolean r108 = false;
    L7:
        if (r107.position == (this.mAdapter.getCount() - 1)) goto L9;
        r103 = r107.offset * r101;
        boolean r109 = false;
    L11:
        if (r111 >= r102) goto L16;
        if (r108 == false) goto L14;
        this.mLeftEdge.onPull(Math.abs(r102 - r111) / r101);
        r104 = true;
    L14:
        r111 = r102;
    L20:
        int r112 = (int) r111;
        this.mLastMotionX += r111 - r112;
        scrollTo(r112, getScrollY());
        pageScrolled(r112);
        return r104;
    L16:
        if (r111 <= r103) goto L20;
        if (r109 == false) goto L19;
        this.mRightEdge.onPull(Math.abs(r111 - r103) / r101);
        r104 = true;
    L19:
        r111 = r103;
        goto L20
    L9:
        r109 = true;
        goto L11
    L5:
        r108 = true;
        goto L7
    }

    private void requestParentDisallowInterceptTouchEvent(boolean r100) {
        ViewParent r101 = getParent();
        if (r101 == null) goto L6;
        r101.requestDisallowInterceptTouchEvent(r100);
        return;
    }

    private void setScrollingCacheEnabled(boolean r100) {
        if (this.mScrollingCacheEnabled == r100) goto L6;
        this.mScrollingCacheEnabled = r100;
        return;
    }

    public void addOnAdapterChangeListener(OnAdapterChangeListener r100) {
        if (this.mAdapterChangeListeners != null) goto L5;
        this.mAdapterChangeListeners = new ArrayList();
    L5:
        this.mAdapterChangeListeners.add(r100);
    }

    public void addOnPageChangeListener(OnPageChangeListener r100) {
        if (this.mOnPageChangeListeners != null) goto L5;
        this.mOnPageChangeListeners = new ArrayList();
    L5:
        this.mOnPageChangeListeners.add(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> r100) {
        int r101 = 0;
    L4:
        if (r101 >= getChildCount()) goto L13;
        View r102 = getChildAt(r101);
        if (r102.getVisibility() != 0) goto L12;
        ItemInfo r103 = infoForChild(r102);
        if (r103 == null) goto L12;
        if (r103.position != this.mCurItem) goto L12;
        r102.addTouchables(r100);
    L12:
        r101 = r101 + 1;
        goto L4
    }

    public boolean arrowScroll(int r100) {
        View r101 = findFocus();
        boolean r102 = false;
        if (r101 != this) goto L5;
    L4:
        r101 = null;
    L19:
        View r103 = FocusFinder.getInstance().findNextFocus(this, r101, r100);
        if (r103 == null) goto L35;
        if (r103 == r101) goto L35;
        if (r100 != 17) goto L29;
        int r104 = getChildRectInPagerCoordinates(this.mTempRect, r103).left;
        int r105 = getChildRectInPagerCoordinates(this.mTempRect, r101).left;
        if (r101 == null) goto L27;
        if (r104 < r105) goto L27;
        boolean r106 = pageLeft();
    L28:
        r102 = r106;
    L43:
        if (r102 == false) goto L45;
        playSoundEffect(SoundEffectConstants.getContantForFocusDirection(r100));
    L45:
        return r102;
    L27:
        r106 = r103.requestFocus();
        goto L28
    L29:
        if (r100 != 66) goto L43;
        int r107 = getChildRectInPagerCoordinates(this.mTempRect, r103).left;
        int r108 = getChildRectInPagerCoordinates(this.mTempRect, r101).left;
        if (r101 == null) goto L34;
        if (r107 > r108) goto L34;
        r106 = pageRight();
    L34:
        r106 = r103.requestFocus();
    L35:
        if (r100 == 17) goto L42;
        if (r100 == 1) goto L42;
        if (r100 != 66) goto L40;
    L41:
        r102 = pageRight();
        goto L43
    L40:
        if (r100 != 2) goto L43;
    L42:
        r102 = pageLeft();
        goto L43
    L5:
        if (r101 == null) goto L19;
        ViewParent r109 = r101.getParent();
    L8:
        if ((r109 instanceof ViewGroup) == false) goto L12;
        if (r109 == this) goto L10;
        r109 = r109.getParent();
        goto L8
    L10:
        boolean r110 = true;
    L13:
        if (r110 == true) goto L19;
        new StringBuilder().append(r101.getClass().getSimpleName());
        ViewParent r111 = r101.getParent();
    L16:
        if ((r111 instanceof ViewGroup) == false) goto L4;
        r111.getClass();
        r111 = r111.getParent();
        goto L16
    L12:
        r110 = false;
        goto L13
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int r100) {
        if (this.mAdapter != null) goto L5;
        return false;
    L5:
        int r101 = getClientWidth();
        int r102 = getScrollX();
        if (r100 < 0) goto L8;
        if (r100 > 0) goto L13;
        return false;
    L13:
        if (r102 >= ((int) (r101 * this.mLastOffset))) goto L18;
        return true;
    L18:
        return false;
    L8:
        if (r102 <= ((int) (r101 * this.mFirstOffset))) goto L16;
        return true;
    L16:
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        if ((r100 instanceof LayoutParams) == true) goto L5;
    L7:
        return false;
    L5:
        if (super.checkLayoutParams(r100) == false) goto L7;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent r100) {
        if (super.dispatchKeyEvent(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (executeKeyEvent(r100) == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r100) {
        if (r100.getEventType() == 4096) goto L5;
        int r101 = getChildCount();
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L19;
        View r103 = getChildAt(r102);
        if (r103.getVisibility() != 0) goto L18;
        ItemInfo r104 = infoForChild(r103);
        if (r104 == null) goto L18;
        if (r104.position != this.mCurItem) goto L18;
        if (r103.dispatchPopulateAccessibilityEvent(r100) == false) goto L18;
        return true;
    L18:
        r102 = r102 + 1;
        goto L7
    L19:
        return false;
    L5:
        return super.dispatchPopulateAccessibilityEvent(r100);
    }

    float distanceInfluenceForSnapDuration(float r100) {
        return (float) Math.sin((r100 - 0.5f) * 0.47123894f);
    }

    @Override // android.view.View
    public void draw(Canvas r100) {
        super.draw(r100);
        int r101 = getOverScrollMode();
        boolean r102 = false;
        if (r101 == 0) goto L13;
        if (r101 != 1) goto L11;
        PagerAdapter r103 = this.mAdapter;
        if (r103 == null) goto L11;
        if (r103.getCount() > 1) goto L13;
    L11:
        this.mLeftEdge.finish();
        this.mRightEdge.finish();
    L18:
        if (r102 == false) goto L21;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L21:
        return;
    L13:
        if (this.mLeftEdge.isFinished() == true) goto L16;
        int r104 = r100.save();
        int r105 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r106 = getWidth();
        r100.rotate(270.0f);
        r100.translate((-r105) + getPaddingTop(), this.mFirstOffset * r106);
        this.mLeftEdge.setSize(r105, r106);
        r102 = false | this.mLeftEdge.draw(r100);
        r100.restoreToCount(r104);
    L16:
        if (this.mRightEdge.isFinished() == true) goto L18;
        int r107 = r100.save();
        int r108 = getWidth();
        int r109 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        r100.rotate(90.0f);
        r100.translate(-getPaddingTop(), (-(this.mLastOffset + 1.0f)) * r108);
        this.mRightEdge.setSize(r109, r108);
        r102 = r102 | this.mRightEdge.draw(r100);
        r100.restoreToCount(r107);
        goto L18
    }

    public boolean executeKeyEvent(KeyEvent r100) {
        if (r100.getAction() != 0) goto L25;
        int r101 = r100.getKeyCode();
        if (r101 == 21) goto L22;
        if (r101 == 22) goto L18;
        if (r101 != 61) goto L25;
        if (r100.hasNoModifiers() == false) goto L15;
        return arrowScroll(2);
    L15:
        if (r100.hasModifiers(1) == false) goto L25;
        return arrowScroll(1);
    L18:
        if (r100.hasModifiers(2) == false) goto L30;
        return pageRight();
    L30:
        return arrowScroll(66);
    L22:
        if (r100.hasModifiers(2) == false) goto L32;
        return pageLeft();
    L32:
        return arrowScroll(17);
    L25:
        return false;
    }

    public void fakeDragBy(float r110) {
        if (this.mFakeDragging == false) goto L22;
        if (this.mAdapter != null) goto L7;
        return;
    L7:
        this.mLastMotionX += r110;
        float r100 = getScrollX() - r110;
        float r111 = getClientWidth();
        float r101 = this.mFirstOffset * r111;
        float r102 = this.mLastOffset * r111;
        ItemInfo r103 = (ItemInfo) ListProtector.get(this.mItems, 0);
        ArrayList<ItemInfo> r104 = this.mItems;
        ItemInfo r105 = (ItemInfo) ListProtector.get(r104, r104.size() - 1);
        if (r103.position == 0) goto L11;
        r101 = r103.offset * r111;
    L11:
        if (r105.position == (this.mAdapter.getCount() - 1)) goto L14;
        r102 = r105.offset * r111;
    L14:
        if (r100 >= r101) goto L17;
        r100 = r101;
    L19:
        int r106 = (int) r100;
        this.mLastMotionX += r100 - r106;
        scrollTo(r106, getScrollY());
        pageScrolled(r106);
        MotionEvent r112 = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0.0f, 0);
        this.mVelocityTracker.addMovement(r112);
        r112.recycle();
        return;
    L17:
        if (r100 <= r102) goto L19;
        r100 = r102;
        goto L19
    L22:
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    public ItemInfo infoForAnyChild(View r100) {
    L2:
        Object r101 = r100.getParent();
        if (r101 == this) goto L12;
        if (r101 == null) goto L9;
        if ((r101 instanceof View) == false) goto L16;
        r100 = (View) r101;
        goto L2
    L16:
        return null;
    L9:
        return null;
    L12:
        return infoForChild(r100);
    }

    public ItemInfo infoForChild(View r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.mItems.size()) goto L9;
        ItemInfo r102 = (ItemInfo) ListProtector.get(this.mItems, r101);
        if (this.mAdapter.isViewFromObject(r100, r102.object) == true) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return r102;
    L9:
        return null;
    }

    public ItemInfo infoForPosition(int r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.mItems.size()) goto L9;
        ItemInfo r102 = (ItemInfo) ListProtector.get(this.mItems, r101);
        if (r102.position == r100) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return r102;
    L9:
        return null;
    }

    @Override // android.view.View
    public void onDraw(Canvas r110) {
        super.onDraw(r110);
        if (this.mPageMargin > 0) goto L5;
        return;
    L5:
        if (this.mMarginDrawable != null) goto L7;
        return;
    L7:
        if (this.mItems.size() > 0) goto L9;
        return;
    L9:
        if (this.mAdapter == null) goto L34;
        int r100 = getScrollX();
        int r101 = getWidth();
        float r102 = r101;
        float r103 = this.mPageMargin / r102;
        int r104 = 0;
        ItemInfo r105 = (ItemInfo) ListProtector.get(this.mItems, 0);
        float r106 = r105.offset;
        int r107 = this.mItems.size();
        int r108 = r105.position;
        int r111 = ((ItemInfo) ListProtector.get(this.mItems, r107 - 1)).position;
    L11:
        if (r108 >= r111) goto L35;
    L12:
        int r112 = r105.position;
        if (r108 <= r112) goto L16;
        if (r104 >= r107) goto L16;
        r104 = r104 + 1;
        r105 = (ItemInfo) ListProtector.get(this.mItems, r104);
    L16:
        if (r108 != r112) goto L18;
        float r109 = r105.offset;
        float r113 = r105.widthFactor;
        float r114 = (r109 + r113) * r102;
        r106 = (r109 + r113) + r103;
    L20:
        if ((this.mPageMargin + r114) <= r100) goto L24;
        this.mMarginDrawable.setBounds(Math.round(r114), this.mTopPageBounds, Math.round(this.mPageMargin + r114), this.mBottomPageBounds);
        this.mMarginDrawable.draw(r110);
    L24:
        if (r114 > (r100 + r101)) goto L36;
        r108 = r108 + 1;
        r103 = r103;
        goto L11
    L36:
        return;
    L18:
        float r115 = this.mAdapter.getPageWidth(r108);
        r114 = (r106 + r115) * r102;
        r106 = r106 + (r115 + r103);
        goto L20
    L35:
        return;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r110) {
        int r100 = r110.getAction() & 255;
        if (r100 != 3) goto L5;
    L60:
        resetTouch();
        return false;
    L5:
        if (r100 == 1) goto L60;
        if (r100 == 0) goto L15;
        if (this.mIsBeingDragged == false) goto L12;
        return true;
    L12:
        if (this.mIsUnableToDrag == false) goto L15;
        return false;
    L15:
        if (r100 == 0) goto L49;
        if (r100 != 2) goto L18;
        int r101 = this.mActivePointerId;
        if (r101 == (-1)) goto L56;
        int r102 = r110.findPointerIndex(r101);
        float r111 = r110.getX(r102);
        float r103 = r111 - this.mLastMotionX;
        float r112 = Math.abs(r103);
        float r113 = r110.getY(r102);
        float r114 = Math.abs(r113 - this.mInitialMotionY);
        if (r103 != 0.0f) goto L27;
    L32:
        int r104 = this.mTouchSlop;
        if (r112 <= r104) goto L42;
        if ((r112 * 0.5f) <= r114) goto L42;
        this.mIsBeingDragged = true;
        requestParentDisallowInterceptTouchEvent(true);
        setScrollState(1);
        float r105 = this.mInitialMotionX;
        float r106 = this.mTouchSlop;
        if (r103 <= 0.0f) goto L39;
        float r107 = r105 + r106;
    L40:
        this.mLastMotionX = r107;
        this.mLastMotionY = r113;
        setScrollingCacheEnabled(true);
    L45:
        if (this.mIsBeingDragged == false) goto L56;
        if (performDrag(r111) == false) goto L56;
        ViewCompat.postInvalidateOnAnimation(this);
        goto L56
    L39:
        r107 = r105 - r106;
    L42:
        if (r114 <= r104) goto L45;
        this.mIsUnableToDrag = true;
        goto L45
    L27:
        if (isGutterDrag(this.mLastMotionX, r103) == true) goto L32;
        if (canScroll(this, false, (int) r103, (int) r111, (int) r113) == false) goto L32;
        this.mLastMotionX = r111;
        this.mLastMotionY = r113;
        this.mIsUnableToDrag = true;
        return false;
    L56:
        if (this.mVelocityTracker != null) goto L58;
        this.mVelocityTracker = VelocityTracker.obtain();
    L58:
        this.mVelocityTracker.addMovement(r110);
        return this.mIsBeingDragged;
    L18:
        if (r100 != 6) goto L56;
        onSecondaryPointerUp(r110);
        goto L56
    L49:
        float r108 = r110.getX();
        this.mInitialMotionX = r108;
        this.mLastMotionX = r108;
        float r109 = r110.getY();
        this.mInitialMotionY = r109;
        this.mLastMotionY = r109;
        this.mActivePointerId = r110.getPointerId(0);
        this.mIsUnableToDrag = false;
        this.mIsScrollStarted = true;
        this.mScroller.computeScrollOffset();
        if (this.mScrollState == 2) goto L52;
    L54:
        completeScroll(false);
        this.mIsBeingDragged = false;
        goto L56
    L52:
        if (Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) <= this.mCloseEnough) goto L54;
        this.mScroller.abortAnimation();
        this.mPopulatePending = false;
        populate();
        this.mIsBeingDragged = true;
        requestParentDisallowInterceptTouchEvent(true);
        setScrollState(1);
        goto L56
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r100);
        return;
    L6:
        SavedState r101 = (SavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        PagerAdapter r102 = this.mAdapter;
        if (r102 == null) goto L9;
        r102.restoreState(r101.adapterState, r101.loader);
        setCurrentItemInternal(r101.position, false, true);
        return;
    L9:
        this.mRestoredCurItem = r101.position;
        this.mRestoredAdapterState = r101.adapterState;
        this.mRestoredClassLoader = r101.loader;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        if (this.mFakeDragging == false) goto L5;
        return true;
    L5:
        boolean r101 = false;
        if (r100.getAction() == 0) goto L8;
    L10:
        PagerAdapter r102 = this.mAdapter;
        if (r102 != null) goto L13;
    L61:
        return false;
    L13:
        if (r102.getCount() == 0) goto L61;
        if (this.mVelocityTracker != null) goto L18;
        this.mVelocityTracker = VelocityTracker.obtain();
    L18:
        this.mVelocityTracker.addMovement(r100);
        int r103 = r100.getAction() & 255;
        if (r103 == 0) goto L57;
        if (r103 == 1) goto L55;
        if (r103 == 2) goto L36;
        if (r103 == 3) goto L33;
        if (r103 != 5) goto L28;
        int r104 = r100.getActionIndex();
        this.mLastMotionX = r100.getX(r104);
        this.mActivePointerId = r100.getPointerId(r104);
    L58:
        if (r101 == false) goto L60;
        ViewCompat.postInvalidateOnAnimation(this);
    L60:
        return true;
    L28:
        if (r103 != 6) goto L58;
        onSecondaryPointerUp(r100);
        this.mLastMotionX = r100.getX(r100.findPointerIndex(this.mActivePointerId));
        goto L58
    L33:
        if (this.mIsBeingDragged == false) goto L58;
        scrollToItem(this.mCurItem, true, 0, false);
        r101 = resetTouch();
        goto L58
    L36:
        if (this.mIsBeingDragged == true) goto L52;
        int r105 = r100.findPointerIndex(this.mActivePointerId);
        if (r105 != (-1)) goto L40;
        r101 = resetTouch();
        goto L58
    L40:
        float r106 = r100.getX(r105);
        float r107 = Math.abs(r106 - this.mLastMotionX);
        float r108 = r100.getY(r105);
        float r109 = Math.abs(r108 - this.mLastMotionY);
        if (r107 <= this.mTouchSlop) goto L52;
        if (r107 <= r109) goto L52;
        this.mIsBeingDragged = true;
        requestParentDisallowInterceptTouchEvent(true);
        float r110 = this.mInitialMotionX;
        if ((r106 - r110) <= 0.0f) goto L47;
        float r111 = r110 + this.mTouchSlop;
    L48:
        this.mLastMotionX = r111;
        this.mLastMotionY = r108;
        setScrollState(1);
        setScrollingCacheEnabled(true);
        ViewParent r112 = getParent();
        if (r112 == null) goto L52;
        r112.requestDisallowInterceptTouchEvent(true);
        goto L52
    L47:
        r111 = r110 - this.mTouchSlop;
    L52:
        if (this.mIsBeingDragged == false) goto L58;
        r101 = false | performDrag(r100.getX(r100.findPointerIndex(this.mActivePointerId)));
        goto L58
    L55:
        if (this.mIsBeingDragged == false) goto L58;
        VelocityTracker r113 = this.mVelocityTracker;
        r113.computeCurrentVelocity(1000, this.mMaximumVelocity);
        int r114 = (int) r113.getXVelocity(this.mActivePointerId);
        this.mPopulatePending = true;
        int r115 = getClientWidth();
        int r116 = getScrollX();
        ItemInfo r117 = infoForCurrentScrollPosition();
        float r118 = r115;
        setCurrentItemInternal(determineTargetPage(r117.position, ((r116 / r118) - r117.offset) / (r117.widthFactor + (this.mPageMargin / r118)), r114, (int) (r100.getX(r100.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX)), true, true, r114);
        r101 = resetTouch();
        goto L58
    L57:
        this.mScroller.abortAnimation();
        this.mPopulatePending = false;
        populate();
        float r119 = r100.getX();
        this.mInitialMotionX = r119;
        this.mLastMotionX = r119;
        float r120 = r100.getY();
        this.mInitialMotionY = r120;
        this.mLastMotionY = r120;
        this.mActivePointerId = r100.getPointerId(0);
        goto L58
    L8:
        if (r100.getEdgeFlags() == 0) goto L10;
        return false;
    }

    void populate(int r110) {
        int r100 = this.mCurItem;
        if (r100 == r110) goto L5;
        ItemInfo r101 = infoForPosition(r100);
        this.mCurItem = r110;
    L7:
        if (this.mAdapter != null) goto L11;
        sortChildDrawingOrder();
        return;
    L11:
        if (this.mPopulatePending == false) goto L15;
        sortChildDrawingOrder();
        return;
    L15:
        if (getWindowToken() != null) goto L17;
        return;
    L17:
        this.mAdapter.startUpdate(this);
        int r102 = this.mOffscreenPageLimit;
        int r103 = Math.max(0, this.mCurItem - r102);
        int r104 = this.mAdapter.getCount();
        int r105 = Math.min(r104 - 1, this.mCurItem + r102);
        if (r104 != this.mExpectedAdapterCount) goto L139;
        int r106 = 0;
    L21:
        if (r106 >= this.mItems.size()) goto L27;
        ItemInfo r107 = (ItemInfo) ListProtector.get(this.mItems, r106);
        int r108 = r107.position;
        int r111 = this.mCurItem;
        if (r108 >= r111) goto L24;
        r106 = r106 + 1;
        goto L21
    L24:
        if (r108 != r111) goto L27;
    L28:
        if (r107 != null) goto L32;
        if (r104 <= 0) goto L32;
        r107 = addNewItem(this.mCurItem, r106);
    L32:
        if (r107 == null) goto L103;
        int r112 = r106 - 1;
        if (r112 < 0) goto L36;
        ItemInfo r113 = (ItemInfo) ListProtector.get(this.mItems, r112);
    L37:
        int r114 = getClientWidth();
        if (r114 > 0) goto L40;
        float r115 = 0.0f;
    L41:
        int r109 = this.mCurItem - 1;
        float r116 = 0.0f;
    L42:
        if (r109 < 0) goto L67;
        if (r116 < r115) goto L55;
        if (r109 >= r103) goto L55;
        if (r113 == null) goto L67;
        if (r109 != r113.position) goto L66;
        if (r113.scrolling == true) goto L66;
        ListProtector.remove(this.mItems, r112);
        this.mAdapter.destroyItem(this, r109, r113.object);
        r112 = r112 - 1;
        r106 = r106 - 1;
        if (r112 < 0) goto L64;
        ItemInfo r117 = (ItemInfo) ListProtector.get(this.mItems, r112);
    L65:
        r113 = r117;
    L64:
        r117 = null;
    L66:
        r109 = r109 - 1;
    L55:
        if (r113 != null) goto L57;
    L61:
        r116 = r116 + addNewItem(r109, r112 + 1).widthFactor;
        r106 = r106 + 1;
        if (r112 < 0) goto L64;
        r117 = (ItemInfo) ListProtector.get(this.mItems, r112);
        goto L65
    L57:
        if (r109 != r113.position) goto L61;
        r116 = r116 + r113.widthFactor;
        r112 = r112 - 1;
        if (r112 < 0) goto L64;
        r117 = (ItemInfo) ListProtector.get(this.mItems, r112);
    L67:
        float r118 = r107.widthFactor;
        int r119 = r106 + 1;
        if (r118 < 2.0f) goto L70;
    L102:
        calculatePageOffsets(r107, r106, r101);
        this.mAdapter.setPrimaryItem(this, this.mCurItem, r107.object);
        goto L103
    L70:
        if (r119 >= this.mItems.size()) goto L72;
        ItemInfo r120 = (ItemInfo) ListProtector.get(this.mItems, r119);
    L73:
        if (r114 > 0) goto L75;
        float r121 = 0.0f;
    L76:
        int r122 = this.mCurItem;
    L77:
        r122 = r122 + 1;
        if (r122 >= r104) goto L102;
        if (r118 < r121) goto L92;
        if (r122 <= r105) goto L92;
        if (r120 == null) goto L102;
        if (r122 != r120.position) goto L77;
        if (r120.scrolling == true) goto L77;
        ListProtector.remove(this.mItems, r119);
        this.mAdapter.destroyItem(this, r122, r120.object);
        if (r119 < this.mItems.size()) goto L90;
    L91:
        r120 = null;
        goto L77
    L90:
        r120 = (ItemInfo) ListProtector.get(this.mItems, r119);
    L92:
        if (r120 == null) goto L98;
        if (r122 != r120.position) goto L98;
        r118 = r118 + r120.widthFactor;
        r119 = r119 + 1;
        if (r119 >= this.mItems.size()) goto L91;
        r120 = (ItemInfo) ListProtector.get(this.mItems, r119);
    L98:
        ItemInfo r123 = addNewItem(r122, r119);
        r119 = r119 + 1;
        r118 = r118 + r123.widthFactor;
        if (r119 >= this.mItems.size()) goto L91;
        r120 = (ItemInfo) ListProtector.get(this.mItems, r119);
        goto L77
    L75:
        r121 = (getPaddingRight() / r114) + 2.0f;
        goto L76
    L72:
        r120 = null;
        goto L73
    L40:
        r115 = (2.0f - r107.widthFactor) + (getPaddingLeft() / r114);
        goto L41
    L36:
        r113 = null;
    L103:
        this.mAdapter.finishUpdate(this);
        int r124 = getChildCount();
        int r125 = 0;
    L104:
        if (r125 >= r124) goto L113;
        View r126 = getChildAt(r125);
        LayoutParams r127 = (LayoutParams) r126.getLayoutParams();
        r127.childIndex = r125;
        if (r127.isDecor == true) goto L112;
        if (r127.widthFactor != 0.0f) goto L112;
        ItemInfo r128 = infoForChild(r126);
        if (r128 == null) goto L112;
        r127.widthFactor = r128.widthFactor;
        r127.position = r128.position;
    L112:
        r125 = r125 + 1;
        goto L104
    L113:
        sortChildDrawingOrder();
        if (hasFocus() == false) goto L133;
        View r129 = findFocus();
        if (r129 == null) goto L118;
        ItemInfo r130 = infoForAnyChild(r129);
    L119:
        if (r130 != null) goto L121;
    L122:
        int r131 = 0;
    L124:
        if (r131 >= getChildCount()) goto L183;
        View r132 = getChildAt(r131);
        ItemInfo r133 = infoForChild(r132);
        if (r133 == null) goto L132;
        if (r133.position != this.mCurItem) goto L132;
        if (r132.requestFocus(2) == false) goto L132;
        return;
    L132:
        r131 = r131 + 1;
        goto L124
    L183:
        return;
    L121:
        if (r130.position != this.mCurItem) goto L122;
        return;
    L118:
        r130 = null;
        goto L119
    L133:
        return;
    L27:
        r107 = null;
        goto L28
    L139:
        String r134 = getResources().getResourceName(getId());     // Catch: Resources.NotFoundException -> L136
    L138:
        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mExpectedAdapterCount + ", found: " + r104 + " Pager id: " + r134 + " Pager class: " + getClass() + " Problematic adapter: " + this.mAdapter.getClass());
    L136:
        r134 = Integer.toHexString(getId());
        goto L138
    L5:
        r101 = null;
        goto L7
    }

    public void removeOnAdapterChangeListener(OnAdapterChangeListener r100) {
        List<OnAdapterChangeListener> r101 = this.mAdapterChangeListeners;
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }

    public void removeOnPageChangeListener(OnPageChangeListener r100) {
        List<OnPageChangeListener> r101 = this.mOnPageChangeListeners;
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View r100) {
        if (this.mInLayout == false) goto L5;
        removeViewInLayout(r100);
        return;
    L5:
        super.removeView(r100);
    }

    public void setAdapter(PagerAdapter r100) {
        PagerAdapter r101 = this.mAdapter;
        int r102 = 0;
        if (r101 == null) goto L9;
        r101.setViewPagerObserver(null);
        this.mAdapter.startUpdate(this);
        int r103 = 0;
    L6:
        if (r103 >= this.mItems.size()) goto L8;
        ItemInfo r104 = (ItemInfo) ListProtector.get(this.mItems, r103);
        this.mAdapter.destroyItem(this, r104.position, r104.object);
        r103 = r103 + 1;
        goto L6
    L8:
        this.mAdapter.finishUpdate(this);
        this.mItems.clear();
        removeNonDecorViews();
        this.mCurItem = 0;
        scrollTo(0, 0);
    L9:
        PagerAdapter r105 = this.mAdapter;
        this.mAdapter = r100;
        this.mExpectedAdapterCount = 0;
        if (r100 != null) goto L12;
    L20:
        List<OnAdapterChangeListener> r106 = this.mAdapterChangeListeners;
        if (r106 != null) goto L23;
        return;
    L23:
        if (r106.isEmpty() == true) goto L30;
        int r107 = this.mAdapterChangeListeners.size();
    L25:
        if (r102 >= r107) goto L31;
        ((OnAdapterChangeListener) ListProtector.get(this.mAdapterChangeListeners, r102)).onAdapterChanged(this, r105, r100);
        r102 = r102 + 1;
        goto L25
    L31:
        return;
    L30:
        return;
    L12:
        if (this.mObserver != null) goto L14;
        this.mObserver = new PagerObserver(this);
    L14:
        this.mAdapter.setViewPagerObserver(this.mObserver);
        this.mPopulatePending = false;
        boolean r108 = this.mFirstLayout;
        this.mFirstLayout = true;
        this.mExpectedAdapterCount = this.mAdapter.getCount();
        if (this.mRestoredCurItem < 0) goto L17;
        this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
        setCurrentItemInternal(this.mRestoredCurItem, false, true);
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        goto L20
    L17:
        if (r108 == true) goto L19;
        populate();
        goto L20
    L19:
        requestLayout();
        goto L20
    }

    public void setCurrentItem(int r100) {
        this.mPopulatePending = false;
        setCurrentItemInternal(r100, !this.mFirstLayout, false);
    }

    public OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener r100) {
        OnPageChangeListener r101 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = r100;
        return r101;
    }

    public void setOffscreenPageLimit(int r100) {
        if (r100 >= 1) goto L6;
        r100 = 1;
    L6:
        if (r100 == this.mOffscreenPageLimit) goto L9;
        this.mOffscreenPageLimit = r100;
        populate();
        return;
    }

    public void setOnPageChangeListener(OnPageChangeListener r100) {
        this.mOnPageChangeListener = r100;
    }

    public void setPageMargin(int r100) {
        int r101 = this.mPageMargin;
        this.mPageMargin = r100;
        int r102 = getWidth();
        recomputeScrollPosition(r102, r102, r100, r101);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable r100) {
        this.mMarginDrawable = r100;
        if (r100 == null) goto L5;
        refreshDrawableState();
    L5:
        if (r100 != null) goto L7;
        boolean r101 = true;
    L8:
        setWillNotDraw(r101);
        invalidate();
        return;
    L7:
        r101 = false;
        goto L8
    }

    void setScrollState(int r100) {
        if (this.mScrollState != r100) goto L5;
        return;
    L5:
        this.mScrollState = r100;
        if (this.mPageTransformer == null) goto L11;
        if (r100 == 0) goto L9;
        boolean r101 = true;
    L10:
        enableLayers(r101);
        goto L11
    L9:
        r101 = false;
    L11:
        dispatchOnScrollStateChanged(r100);
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable r100) {
        if (super.verifyDrawable(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (r100 == this.mMarginDrawable) goto L8;
        return false;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return generateDefaultLayoutParams();
    }

    public void setPageMarginDrawable(int r100) {
        setPageMarginDrawable(ContextCompat.getDrawable(getContext(), r100));
    }

    public ViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mItems = new ArrayList();
        this.mTempItem = new ItemInfo();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new AnonymousClass3(this);
        this.mScrollState = 0;
        initViewPager();
    }

    private Rect getChildRectInPagerCoordinates(Rect r100, View r101) {
        if (r100 != null) goto L4;
        r100 = new Rect();
    L4:
        if (r101 != null) goto L7;
        r100.set(0, 0, 0, 0);
        return r100;
    L7:
        r100.left = r101.getLeft();
        r100.right = r101.getRight();
        r100.top = r101.getTop();
        r100.bottom = r101.getBottom();
        ViewParent r102 = r101.getParent();
    L9:
        if ((r102 instanceof ViewGroup) == false) goto L12;
        if (r102 == this) goto L12;
        ViewGroup r103 = (ViewGroup) r102;
        r100.left += r103.getLeft();
        r100.right += r103.getRight();
        r100.top += r103.getTop();
        r100.bottom += r103.getBottom();
        r102 = r103.getParent();
    L12:
        return r100;
    }

    private boolean isGutterDrag(float r100, float r101) {
        if (r100 >= this.mGutterSize) goto L7;
        if (r101 <= 0.0f) goto L7;
    L10:
        return true;
    L7:
        if (r100 > (getWidth() - this.mGutterSize)) goto L9;
    L11:
        return false;
    L9:
        if (r101 >= 0.0f) goto L11;
        goto L10
    }

    public ItemInfo addNewItem(int r100, int r101) {
        ItemInfo r102 = new ItemInfo();
        r102.position = r100;
        r102.object = this.mAdapter.instantiateItem(this, r100);
        r102.widthFactor = this.mAdapter.getPageWidth(r100);
        if (r101 >= 0) goto L5;
    L8:
        this.mItems.add(r102);
    L9:
        return r102;
    L5:
        if (r101 >= this.mItems.size()) goto L8;
        ListProtector.add(this.mItems, r101, r102);
        goto L9
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int r100, int r101) {
        if (this.mDrawingOrder != 2) goto L6;
        r101 = (r100 - 1) - r101;
    L6:
        return ((LayoutParams) ((View) ListProtector.get(this.mDrawingOrderedChildren, r101)).getLayoutParams()).childIndex;
    }

    @Override // android.view.View
    public void onMeasure(int r110, int r111) {
        int r100 = 0;
        setMeasuredDimension(ViewGroup.getDefaultSize(0, r110), ViewGroup.getDefaultSize(0, r111));
        int r112 = getMeasuredWidth();
        this.mGutterSize = Math.min(r112 / 10, this.mDefaultGutterSize);
        int r113 = (r112 - getPaddingLeft()) - getPaddingRight();
        int r114 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int r101 = getChildCount();
        int r102 = 0;
    L3:
        boolean r103 = true;
        int r104 = 1073741824;
        if (r102 >= r101) goto L49;
        View r105 = getChildAt(r102);
        if (r105.getVisibility() == 8) goto L48;
        LayoutParams r106 = (LayoutParams) r105.getLayoutParams();
        if (r106 == null) goto L48;
        if (r106.isDecor == false) goto L48;
        int r107 = r106.gravity;
        int r108 = r107 & 7;
        int r109 = r107 & 112;
        if (r109 != 48) goto L14;
    L17:
        boolean r115 = true;
    L19:
        if (r108 != 3) goto L21;
    L24:
        int r116 = Integer.MIN_VALUE;
        if (r115 == false) goto L27;
        r116 = 1073741824;
    L29:
        int r117 = Integer.MIN_VALUE;
    L30:
        int r118 = ((ViewGroup.LayoutParams) r106).width;
        if (r118 == (-2)) goto L36;
        if (r118 != (-1)) goto L35;
        r118 = r113;
    L35:
        r116 = 1073741824;
    L37:
        int r119 = ((ViewGroup.LayoutParams) r106).height;
        if (r119 == (-2)) goto L42;
        if (r119 != (-1)) goto L43;
        r119 = r114;
    L43:
        r105.measure(View.MeasureSpec.makeMeasureSpec(r118, r116), View.MeasureSpec.makeMeasureSpec(r119, r104));
        if (r115 == false) goto L46;
        r114 = r114 - r105.getMeasuredHeight();
        goto L48
    L46:
        if (r103 == false) goto L48;
        r113 = r113 - r105.getMeasuredWidth();
        goto L48
    L42:
        r119 = r114;
        r104 = r117;
        goto L43
    L36:
        r118 = r113;
        goto L37
    L27:
        if (r103 == false) goto L29;
        r117 = 1073741824;
        goto L30
    L21:
        if (r108 == 5) goto L24;
        r103 = false;
        goto L24
    L14:
        if (r109 == 80) goto L17;
        r115 = false;
    L48:
        r102 = r102 + 1;
        goto L3
    L49:
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(r113, 1073741824);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(r114, 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        int r120 = getChildCount();
    L50:
        if (r100 >= r120) goto L59;
        View r121 = getChildAt(r100);
        if (r121.getVisibility() == 8) goto L58;
        LayoutParams r122 = (LayoutParams) r121.getLayoutParams();
        if (r122 != null) goto L56;
    L57:
        r121.measure(View.MeasureSpec.makeMeasureSpec((int) (r113 * r122.widthFactor), 1073741824), this.mChildHeightMeasureSpec);
        goto L58
    L56:
        if (r122.isDecor == false) goto L57;
    L58:
        r100 = r100 + 1;
        goto L50
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int r100, Rect r110) {
        int r101 = getChildCount();
        if ((r100 & 2) == 0) goto L5;
        int r102 = r101;
        int r103 = 0;
        int r104 = 1;
    L6:
        if (r103 == r102) goto L17;
        View r105 = getChildAt(r103);
        if (r105.getVisibility() != 0) goto L16;
        ItemInfo r106 = infoForChild(r105);
        if (r106 == null) goto L16;
        if (r106.position != this.mCurItem) goto L16;
        if (r105.requestFocus(r100, r110) == false) goto L16;
        return true;
    L16:
        r103 = r103 + r104;
        goto L6
    L17:
        return false;
    L5:
        r103 = r101 - 1;
        r102 = -1;
        r104 = -1;
        goto L6
    }

    public void setCurrentItem(int r100, boolean r101) {
        this.mPopulatePending = false;
        setCurrentItemInternal(r100, r101, false);
    }

    public void setPageTransformer(boolean r100, PageTransformer r101) {
        setPageTransformer(r100, r101, 2);
    }

    void smoothScrollTo(int r100, int r101) {
        smoothScrollTo(r100, r101, 0);
    }

    private void calculatePageOffsets(ItemInfo r110, int r111, ItemInfo r112) {
        int r100 = this.mAdapter.getCount();
        int r101 = getClientWidth();
        if (r101 <= 0) goto L5;
        float r102 = this.mPageMargin / r101;
    L7:
        if (r112 == null) goto L39;
        int r103 = r112.position;
        int r104 = r110.position;
        if (r103 >= r104) goto L25;
        float r105 = (r112.offset + r112.widthFactor) + r102;
        int r106 = r103 + 1;
        int r113 = 0;
    L12:
        if (r106 > r110.position) goto L39;
        if (r113 >= this.mItems.size()) goto L39;
        Object r107 = ListProtector.get(this.mItems, r113);
    L16:
        ItemInfo r108 = (ItemInfo) r107;
        if (r106 <= r108.position) goto L22;
        if (r113 >= (this.mItems.size() - 1)) goto L22;
        r113 = r113 + 1;
        r107 = ListProtector.get(this.mItems, r113);
    L22:
        if (r106 >= r108.position) goto L24;
        r105 = r105 + (this.mAdapter.getPageWidth(r106) + r102);
        r106 = r106 + 1;
        goto L22
    L24:
        r108.offset = r105;
        r105 = r105 + (r108.widthFactor + r102);
        r106 = r106 + 1;
        goto L12
    L25:
        if (r103 <= r104) goto L39;
        int r109 = this.mItems.size() - 1;
        float r114 = r112.offset;
    L27:
        r103 = r103 - 1;
        if (r103 < r110.position) goto L39;
        if (r109 < 0) goto L39;
        Object r115 = ListProtector.get(this.mItems, r109);
    L31:
        ItemInfo r116 = (ItemInfo) r115;
        if (r103 >= r116.position) goto L36;
        if (r109 <= 0) goto L36;
        r109 = r109 - 1;
        r115 = ListProtector.get(this.mItems, r109);
    L36:
        if (r103 <= r116.position) goto L38;
        r114 = r114 - (this.mAdapter.getPageWidth(r103) + r102);
        r103 = r103 - 1;
        goto L36
    L38:
        r114 = r114 - (r116.widthFactor + r102);
        r116.offset = r114;
    L39:
        int r117 = this.mItems.size();
        float r118 = r110.offset;
        int r119 = r110.position;
        int r120 = r119 - 1;
        if (r119 != 0) goto L42;
        float r121 = r118;
    L43:
        this.mFirstOffset = r121;
        int r122 = r100 - 1;
        if (r119 != r122) goto L46;
        float r123 = (r110.widthFactor + r118) - 1.0f;
    L47:
        this.mLastOffset = r123;
        int r124 = r111 - 1;
    L48:
        if (r124 < 0) goto L57;
        ItemInfo r125 = (ItemInfo) ListProtector.get(this.mItems, r124);
    L50:
        int r126 = r125.position;
        if (r120 <= r126) goto L53;
        r118 = r118 - (this.mAdapter.getPageWidth(r120) + r102);
        r120 = r120 - 1;
        goto L50
    L53:
        r118 = r118 - (r125.widthFactor + r102);
        r125.offset = r118;
        if (r126 != 0) goto L56;
        this.mFirstOffset = r118;
    L56:
        r124 = r124 - 1;
        r120 = r120 - 1;
        goto L48
    L57:
        float r127 = (r110.offset + r110.widthFactor) + r102;
        int r128 = r110.position + 1;
        int r129 = r111 + 1;
    L58:
        if (r129 >= r117) goto L66;
        ItemInfo r130 = (ItemInfo) ListProtector.get(this.mItems, r129);
    L60:
        int r131 = r130.position;
        if (r128 >= r131) goto L63;
        r127 = r127 + (this.mAdapter.getPageWidth(r128) + r102);
        r128 = r128 + 1;
        goto L60
    L63:
        if (r131 != r122) goto L65;
        this.mLastOffset = (r130.widthFactor + r127) - 1.0f;
    L65:
        r130.offset = r127;
        r127 = r127 + (r130.widthFactor + r102);
        r129 = r129 + 1;
        r128 = r128 + 1;
        goto L58
    L66:
        this.mNeedCalculatePageOffsets = false;
        return;
    L46:
        r123 = Float.MAX_VALUE;
        goto L47
    L42:
        r121 = -3.4028235E38f;
        goto L43
    L5:
        r102 = 0.0f;
        goto L7
    }

    private void dispatchOnPageScrolled(int r100, float r101, int r102) {
        OnPageChangeListener r103 = this.mOnPageChangeListener;
        if (r103 == null) goto L5;
        r103.onPageScrolled(r100, r101, r102);
    L5:
        List<OnPageChangeListener> r104 = this.mOnPageChangeListeners;
        if (r104 == null) goto L13;
        int r105 = r104.size();
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L13;
        OnPageChangeListener r107 = (OnPageChangeListener) ListProtector.get(this.mOnPageChangeListeners, r106);
        if (r107 == null) goto L12;
        r107.onPageScrolled(r100, r101, r102);
    L12:
        r106 = r106 + 1;
    L13:
        OnPageChangeListener r108 = this.mInternalPageChangeListener;
        if (r108 == null) goto L20;
        r108.onPageScrolled(r100, r101, r102);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> r100, int r101, int r102) {
        int r103 = r100.size();
        int r104 = getDescendantFocusability();
        if (r104 == 393216) goto L16;
        int r105 = 0;
    L6:
        if (r105 >= getChildCount()) goto L16;
        View r106 = getChildAt(r105);
        if (r106.getVisibility() != 0) goto L14;
        ItemInfo r107 = infoForChild(r106);
        if (r107 == null) goto L14;
        if (r107.position != this.mCurItem) goto L14;
        r106.addFocusables(r100, r101, r102);
    L14:
        r105 = r105 + 1;
    L16:
        if (r104 != 262144) goto L20;
        if (r103 == r100.size()) goto L20;
        return;
    L20:
        if (isFocusable() == true) goto L23;
        return;
    L23:
        if ((r102 & 1) == 1) goto L25;
    L29:
        r100.add(this);
        return;
    L25:
        if (isInTouchMode() == false) goto L29;
        if (isFocusableInTouchMode() == true) goto L29;
    }

    @Override // android.view.ViewGroup
    public void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        if (checkLayoutParams(r102) == true) goto L5;
        r102 = generateLayoutParams(r102);
    L5:
        LayoutParams r103 = (LayoutParams) r102;
        boolean r104 = r103.isDecor | isDecorView(r100);
        r103.isDecor = r104;
        if (this.mInLayout == false) goto L11;
        if (r104 == true) goto L10;
        r103.needsMeasure = true;
        addViewInLayout(r100, r101, r102);
        return;
    L10:
        throw new IllegalStateException("Cannot add pager decor view during layout");
    L11:
        super.addView(r100, r101, r102);
    }

    public void onPageScrolled(int r110, float r111, int r112) {
        int r100 = 0;
        if (this.mDecorChildCount <= 0) goto L25;
        int r101 = getScrollX();
        int r102 = getPaddingLeft();
        int r103 = getPaddingRight();
        int r104 = getWidth();
        int r105 = getChildCount();
        int r106 = 0;
    L5:
        if (r106 >= r105) goto L25;
        View r107 = getChildAt(r106);
        LayoutParams r108 = (LayoutParams) r107.getLayoutParams();
        if (r108.isDecor == false) goto L24;
        int r109 = r108.gravity & 7;
        if (r109 != 1) goto L12;
        int r113 = Math.max((r104 - r107.getMeasuredWidth()) / 2, r102);
    L19:
        int r114 = r113;
        int r115 = r102;
        r102 = r114;
    L20:
        int r116 = (r102 + r101) - r107.getLeft();
        if (r116 == 0) goto L23;
        r107.offsetLeftAndRight(r116);
    L23:
        r102 = r115;
        goto L24
    L12:
        if (r109 != 3) goto L14;
        r115 = r107.getWidth() + r102;
        goto L20
    L14:
        if (r109 == 5) goto L16;
        r115 = r102;
        goto L20
    L16:
        r113 = (r104 - r103) - r107.getMeasuredWidth();
        r103 = r103 + r107.getMeasuredWidth();
    L24:
        r106 = r106 + 1;
    L25:
        dispatchOnPageScrolled(r110, r111, r112);
        if (this.mPageTransformer == null) goto L34;
        int r117 = getScrollX();
        int r118 = getChildCount();
    L28:
        if (r100 >= r118) goto L34;
        View r119 = getChildAt(r100);
        if (((LayoutParams) r119.getLayoutParams()).isDecor == true) goto L33;
        this.mPageTransformer.transformPage(r119, (r119.getLeft() - r117) / getClientWidth());
    L33:
        r100 = r100 + 1;
    L34:
        this.mCalledSuper = true;
    }

    void setCurrentItemInternal(int r100, boolean r101, boolean r102) {
        setCurrentItemInternal(r100, r101, r102, 0);
    }

    public void setPageTransformer(boolean r100, PageTransformer r101, int r102) {
        int r103 = 1;
        if (r101 == null) goto L5;
        boolean r104 = true;
    L7:
        if (this.mPageTransformer == null) goto L9;
        boolean r105 = true;
    L10:
        if (r104 == r105) goto L12;
        boolean r106 = true;
    L13:
        this.mPageTransformer = r101;
        setChildrenDrawingOrderEnabled(r104);
        if (r104 == false) goto L18;
        if (r100 == false) goto L17;
        r103 = 2;
    L17:
        this.mDrawingOrder = r103;
        this.mPageTransformerLayerType = r102;
    L19:
        if (r106 == false) goto L22;
        populate();
        return;
    L22:
        return;
    L18:
        this.mDrawingOrder = 0;
        goto L19
    L12:
        r106 = false;
        goto L13
    L9:
        r105 = false;
        goto L10
    L5:
        r104 = false;
        goto L7
    }

    void smoothScrollTo(int r110, int r111, int r112) {
        if (getChildCount() != 0) goto L6;
        setScrollingCacheEnabled(false);
        return;
    L6:
        Scroller r100 = this.mScroller;
        if (r100 != null) goto L9;
    L11:
        boolean r101 = false;
    L12:
        if (r101 == true) goto L14;
        int r102 = getScrollX();
    L19:
        int r103 = r102;
        int r104 = getScrollY();
        int r105 = r110 - r103;
        int r106 = r111 - r104;
        if (r105 != 0) goto L24;
        if (r106 != 0) goto L24;
        completeScroll(false);
        populate();
        setScrollState(0);
        return;
    L24:
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int r113 = getClientWidth();
        int r114 = r113 / 2;
        float r115 = r113;
        float r116 = r114;
        float r117 = r116 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (Math.abs(r105) * 1.0f) / r115)) * r116);
        int r118 = Math.abs(r112);
        if (r118 <= 0) goto L27;
        int r119 = Math.round(Math.abs(r117 / r118) * 1000.0f) * 4;
    L28:
        int r107 = Math.min(r119, 600);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(r103, r104, r105, r106, r107);
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L27:
        r119 = (int) (((Math.abs(r105) / ((r115 * this.mAdapter.getPageWidth(this.mCurItem)) + this.mPageMargin)) + 1.0f) * 100.0f);
        goto L28
    L14:
        if (this.mIsScrollStarted == false) goto L16;
        r102 = this.mScroller.getCurrX();
    L17:
        this.mScroller.abortAnimation();
        setScrollingCacheEnabled(false);
        goto L19
    L16:
        r102 = this.mScroller.getStartX();
        goto L17
    L9:
        if (r100.isFinished() == true) goto L11;
        r101 = true;
        goto L12
    }

    private int determineTargetPage(int r100, float r101, int r102, int r103) {
        if (Math.abs(r103) <= this.mFlingDistance) goto L10;
        if (Math.abs(r102) <= this.mMinimumVelocity) goto L10;
        if (r102 > 0) goto L15;
        r100 = r100 + 1;
    L15:
        if (this.mItems.size() <= 0) goto L18;
        ItemInfo r104 = (ItemInfo) ListProtector.get(this.mItems, 0);
        ArrayList<ItemInfo> r105 = this.mItems;
        return Math.max(r104.position, Math.min(r100, ((ItemInfo) ListProtector.get(r105, r105.size() - 1)).position));
    L18:
        return r100;
    L10:
        if (r100 < this.mCurItem) goto L12;
        float r106 = 0.4f;
    L13:
        r100 = r100 + ((int) (r101 + r106));
        goto L15
    L12:
        r106 = 0.6f;
        goto L13
    }

    private void recomputeScrollPosition(int r100, int r101, int r102, int r103) {
        if (r101 > 0) goto L4;
    L9:
        ItemInfo r104 = infoForPosition(this.mCurItem);
        if (r104 == null) goto L12;
        float r105 = Math.min(r104.offset, this.mLastOffset);
    L13:
        int r106 = (int) (r105 * ((r100 - getPaddingLeft()) - getPaddingRight()));
        if (r106 == getScrollX()) goto L19;
        completeScroll(false);
        scrollTo(r106, getScrollY());
        return;
    L19:
        return;
    L12:
        r105 = 0.0f;
        goto L13
    L4:
        if (this.mItems.isEmpty() == true) goto L9;
        if (this.mScroller.isFinished() == true) goto L8;
        this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
        return;
    L8:
        scrollTo((int) ((getScrollX() / (((r101 - getPaddingLeft()) - getPaddingRight()) + r103)) * (((r100 - getPaddingLeft()) - getPaddingRight()) + r102)), getScrollY());
    }

    private void scrollToItem(int r100, boolean r101, int r102, boolean r103) {
        ItemInfo r104 = infoForPosition(r100);
        if (r104 == null) goto L5;
        int r105 = (int) (getClientWidth() * Math.max(this.mFirstOffset, Math.min(r104.offset, this.mLastOffset)));
    L6:
        if (r101 == false) goto L10;
        smoothScrollTo(r105, 0, r102);
        if (r103 == false) goto L14;
        dispatchOnPageSelected(r100);
        return;
    L14:
        return;
    L10:
        if (r103 == false) goto L12;
        dispatchOnPageSelected(r100);
    L12:
        completeScroll(false);
        scrollTo(r105, 0);
        pageScrolled(r105);
        return;
    L5:
        r105 = 0;
        goto L6
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 == r102) goto L6;
        int r104 = this.mPageMargin;
        recomputeScrollPosition(r100, r102, r104, r104);
        return;
    }

    void setCurrentItemInternal(int r100, boolean r101, boolean r102, int r103) {
        PagerAdapter r104 = this.mAdapter;
        boolean r105 = false;
        if (r104 != null) goto L5;
    L39:
        setScrollingCacheEnabled(false);
        return;
    L5:
        if (r104.getCount() <= 0) goto L39;
        if (r102 == true) goto L15;
        if (this.mCurItem != r100) goto L15;
        if (this.mItems.size() == 0) goto L15;
        setScrollingCacheEnabled(false);
        return;
    L15:
        if (r100 >= 0) goto L18;
        r100 = 0;
    L20:
        int r106 = this.mOffscreenPageLimit;
        int r107 = this.mCurItem;
        if (r100 <= (r107 + r106)) goto L23;
    L24:
        int r108 = 0;
    L26:
        if (r108 >= this.mItems.size()) goto L29;
        ((ItemInfo) ListProtector.get(this.mItems, r108)).scrolling = true;
        r108 = r108 + 1;
    L29:
        if (this.mCurItem == r100) goto L32;
        r105 = true;
    L32:
        if (this.mFirstLayout == false) goto L37;
        this.mCurItem = r100;
        if (r105 == false) goto L36;
        dispatchOnPageSelected(r100);
    L36:
        requestLayout();
        return;
    L37:
        populate(r100);
        scrollToItem(r100, r101, r103, r105);
        return;
    L23:
        if (r100 >= (r107 - r106)) goto L29;
    L18:
        if (r100 < this.mAdapter.getCount()) goto L20;
        r100 = this.mAdapter.getCount() - 1;
        goto L20
    }

    public boolean canScroll(View r110, boolean r111, int r112, int r113, int r114) {
        if ((r110 instanceof ViewGroup) == false) goto L18;
        ViewGroup r100 = (ViewGroup) r110;
        int r101 = r110.getScrollX();
        int r102 = r110.getScrollY();
        int r103 = r100.getChildCount() - 1;
    L5:
        if (r103 < 0) goto L18;
        View r104 = r100.getChildAt(r103);
        int r105 = r113 + r101;
        if (r105 < r104.getLeft()) goto L17;
        if (r105 >= r104.getRight()) goto L17;
        int r106 = r114 + r102;
        if (r106 < r104.getTop()) goto L17;
        if (r106 >= r104.getBottom()) goto L17;
        if (canScroll(r104, true, r112, r105 - r104.getLeft(), r106 - r104.getTop()) == false) goto L17;
        return true;
    L17:
        r103 = r103 - 1;
    L18:
        if (r111 == true) goto L20;
    L22:
        return false;
    L20:
        if (r110.canScrollHorizontally(-r112) == false) goto L22;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r110, int r210, int r211, int r212, int r213) {
        int r100 = getChildCount();
        int r101 = r212 - r210;
        int r102 = r213 - r211;
        int r103 = getPaddingLeft();
        int r104 = getPaddingTop();
        int r105 = getPaddingRight();
        int r106 = getPaddingBottom();
        int r107 = getScrollX();
        int r111 = 0;
        int r112 = 0;
    L4:
        if (r111 >= r100) goto L33;
        View r113 = getChildAt(r111);
        if (r113.getVisibility() == 8) goto L32;
        LayoutParams r114 = (LayoutParams) r113.getLayoutParams();
        if (r114.isDecor == false) goto L32;
        int r115 = r114.gravity;
        int r116 = r115 & 7;
        int r117 = r115 & 112;
        if (r116 != 1) goto L12;
        int r118 = Math.max((r101 - r113.getMeasuredWidth()) / 2, r103);
    L19:
        int r119 = r118;
        int r120 = r103;
        r103 = r119;
    L21:
        if (r117 != 16) goto L23;
        int r121 = Math.max((r102 - r113.getMeasuredHeight()) / 2, r104);
    L30:
        int r122 = r121;
        int r123 = r104;
        r104 = r122;
    L31:
        int r108 = r103 + r107;
        r113.layout(r108, r104, r113.getMeasuredWidth() + r108, r104 + r113.getMeasuredHeight());
        r112 = r112 + 1;
        r104 = r123;
        r103 = r120;
        goto L32
    L23:
        if (r117 != 48) goto L25;
        r123 = r113.getMeasuredHeight() + r104;
        goto L31
    L25:
        if (r117 == 80) goto L27;
        r123 = r104;
        goto L31
    L27:
        r121 = (r102 - r106) - r113.getMeasuredHeight();
        r106 = r106 + r113.getMeasuredHeight();
        goto L30
    L12:
        if (r116 != 3) goto L14;
        r120 = r113.getMeasuredWidth() + r103;
        goto L21
    L14:
        if (r116 == 5) goto L16;
        r120 = r103;
        goto L21
    L16:
        r118 = (r101 - r105) - r113.getMeasuredWidth();
        r105 = r105 + r113.getMeasuredWidth();
    L32:
        r111 = r111 + 1;
        goto L4
    L33:
        int r109 = (r101 - r103) - r105;
        int r124 = 0;
    L34:
        if (r124 >= r100) goto L46;
        View r125 = getChildAt(r124);
        if (r125.getVisibility() == 8) goto L45;
        LayoutParams r126 = (LayoutParams) r125.getLayoutParams();
        if (r126.isDecor == true) goto L45;
        ItemInfo r127 = infoForChild(r125);
        if (r127 == null) goto L45;
        float r128 = r109;
        int r129 = ((int) (r127.offset * r128)) + r103;
        if (r126.needsMeasure == false) goto L44;
        r126.needsMeasure = false;
        r125.measure(View.MeasureSpec.makeMeasureSpec((int) (r128 * r126.widthFactor), 1073741824), View.MeasureSpec.makeMeasureSpec((r102 - r104) - r106, 1073741824));
    L44:
        r125.layout(r129, r104, r125.getMeasuredWidth() + r129, r125.getMeasuredHeight() + r104);
    L45:
        r124 = r124 + 1;
        goto L34
    L46:
        this.mTopPageBounds = r104;
        this.mBottomPageBounds = r102 - r106;
        this.mDecorChildCount = r112;
        if (this.mFirstLayout == false) goto L49;
        boolean r130 = false;
        scrollToItem(this.mCurItem, false, 0, false);
    L50:
        this.mFirstLayout = r130;
        return;
    L49:
        r130 = false;
        goto L50
    }
}
