package com.bytedanceos.common.ui.widget;

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
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityRecord;
import android.widget.Scroller;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedanceos.common.toolbox.i;
import com.google.common.primitives.Ints;
import com.obric.capabilitykit.common.UiType;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public class ViewPagerCompat extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final Comparator<ItemInfo> COMPARATOR = null;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final float DEFAULT_OFFSET = 0.5f;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    private static final int[] LAYOUT_ATTRS = null;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final LinearOutSlowInInterpolator SINTERPOLATOR = null;
    private static final String TAG = "ViewPagerCompat";
    private static final boolean USE_CACHE = false;
    private static final float X_Y_DISTANCE_OFFSET = 1.732f;
    private static final ViewPositionComparator sPositionComparator = null;
    private int mActivePointerId;
    private PagerAdapter mAdapter;
    private OnAdapterChangeListener mAdapterChangeListener;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    private int mCurItem;
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
    private boolean mIgnoreGutter;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsUnableToDrag;
    private final ArrayList<ItemInfo> mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets;
    private PagerObserver mObserver;
    private int mOffscreenPageLimit;
    private OnPageChangeListener mOnPageChangeListener;
    private int mOverflingDistance;
    private int mOverscrollDistance;
    private int mPageMargin;
    private PageTransformer mPageTransformer;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private Method mSetChildrenDrawingOrderEnabled;
    private final ItemInfo mTempItem;
    private final Rect mTempRect;
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    public interface Decor {
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

        public LayoutParams(Context r10, AttributeSet r11) {
            super(r10, r11);
            this.widthFactor = 0.0f;
            TypedArray r12 = r10.obtainStyledAttributes(r11, ViewPagerCompat.access$400());
            this.gravity = r12.getInteger(0, 48);
            r12.recycle();
        }
    }

    public class MyAccessibilityDelegate extends View.AccessibilityDelegate {
        final /* synthetic */ ViewPagerCompat this$0;

        public MyAccessibilityDelegate(ViewPagerCompat r10) {
            this.this$0 = r10;
        }

        private boolean canScroll() {
            if (ViewPagerCompat.access$200(this.this$0) != null) goto L5;
        L7:
            return false;
        L5:
            if (ViewPagerCompat.access$200(this.this$0).getCount() <= 1) goto L7;
            return true;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View r10, AccessibilityEvent r11) {
            super.onInitializeAccessibilityEvent(r10, r11);
            r11.setClassName(ViewPagerCompat.class.getName());
            AccessibilityRecord r12 = AccessibilityRecord.obtain();
            r12.setScrollable(canScroll());
            if (r11.getEventType() == 4096) goto L5;
            return;
        L5:
            if (ViewPagerCompat.access$200(this.this$0) == null) goto L9;
            r12.setItemCount(ViewPagerCompat.access$200(this.this$0).getCount());
            r12.setFromIndex(ViewPagerCompat.access$300(this.this$0));
            r12.setToIndex(ViewPagerCompat.access$300(this.this$0));
            return;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfo r11) {
            super.onInitializeAccessibilityNodeInfo(r10, r11);
            r11.setClassName(ViewPagerCompat.class.getName());
            r11.setScrollable(canScroll());
            if (this.this$0.canScrollHorizontally(1) == false) goto L6;
            r11.addAction(4096);
        L6:
            if (this.this$0.canScrollHorizontally(-1) == false) goto L9;
            r11.addAction(8192);
            return;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View r10, int r11, Bundle r12) {
            if (super.performAccessibilityAction(r10, r11, r12) == false) goto L6;
            return true;
        L6:
            if (r11 == 4096) goto L16;
            if (r11 == 8192) goto L11;
            return false;
        L11:
            if (this.this$0.canScrollHorizontally(-1) == false) goto L14;
            ViewPagerCompat r13 = this.this$0;
            r13.setCurrentItem(ViewPagerCompat.access$300(r13) - 1);
            return true;
        L14:
            return false;
        L16:
            if (this.this$0.canScrollHorizontally(1) == false) goto L19;
            ViewPagerCompat r14 = this.this$0;
            r14.setCurrentItem(ViewPagerCompat.access$300(r14) + 1);
            return true;
        L19:
            return false;
        }
    }

    public interface OnAdapterChangeListener {
        void onAdapterChanged(PagerAdapter r10, PagerAdapter r11);
    }

    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int r10);

        void onPageScrolled(int r10, float r11, int r12);

        void onPageSelected(int r10);
    }

    public interface PageTransformer {
        void transformPage(View r10, float r11);
    }

    public class PagerObserver extends DataSetObserver {
        final /* synthetic */ ViewPagerCompat this$0;

        private PagerObserver(ViewPagerCompat r10) {
            this.this$0 = r10;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            this.this$0.dataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            this.this$0.dataSetChanged();
        }

        public /* synthetic */ PagerObserver(ViewPagerCompat r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public static class SavedState extends View.BaseSavedState {
        Parcelable adapterState;
        ClassLoader loader;
        int position;

        public SavedState(Parcelable r10) {
            super(r10);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeInt(this.position);
            r10.writeParcelable(this.adapterState, r11);
        }

        public SavedState(Parcel r10, ClassLoader r11) {
            super(r10);
            if (r11 != null) goto L5;
            r11 = getClass().getClassLoader();
        L5:
            this.position = r10.readInt();
            this.adapterState = r10.readParcelable(r11);
            this.loader = r11;
        }
    }

    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        public SimpleOnPageChangeListener() {
        }

        @Override // com.bytedanceos.common.ui.widget.ViewPagerCompat.OnPageChangeListener
        public void onPageScrollStateChanged(int r10) {
        }

        @Override // com.bytedanceos.common.ui.widget.ViewPagerCompat.OnPageChangeListener
        public void onPageScrolled(int r10, float r11, int r12) {
        }

        @Override // com.bytedanceos.common.ui.widget.ViewPagerCompat.OnPageChangeListener
        public void onPageSelected(int r10) {
        }
    }

    public static class ViewPositionComparator implements Comparator<View> {
        public ViewPositionComparator() {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(View r10, View r11) {
            return compare2(r10, r11);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(View r10, View r11) {
            LayoutParams r12 = (LayoutParams) r10.getLayoutParams();
            LayoutParams r13 = (LayoutParams) r11.getLayoutParams();
            boolean r14 = r12.isDecor;
            if (r14 == r13.isDecor) goto L9;
            if (r14 == false) goto L6;
            return 1;
        L6:
            return -1;
        L9:
            return r12.position - r13.position;
        }
    }

    static {
        LAYOUT_ATTRS = new int[]{R.attr.layout_gravity};
        SINTERPOLATOR = new LinearOutSlowInInterpolator();
        COMPARATOR = new AnonymousClass1();
        sPositionComparator = new ViewPositionComparator();
    }

    public ViewPagerCompat(Context r10) {
        super(r10);
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
        this.mEndScrollRunnable = new AnonymousClass2(this);
        this.mScrollState = 0;
        initViewPager();
    }

    public static /* synthetic */ void access$000(ViewPagerCompat r10, int r11) {
        r10.setScrollState(r11);
    }

    public static /* synthetic */ PagerAdapter access$200(ViewPagerCompat r10) {
        return r10.mAdapter;
    }

    public static /* synthetic */ int access$300(ViewPagerCompat r10) {
        return r10.mCurItem;
    }

    public static /* synthetic */ int[] access$400() {
        return LAYOUT_ATTRS;
    }

    private void calculatePageOffsets(ItemInfo r11, int r12, ItemInfo r13) {
        int r10 = this.mAdapter.getCount();
        int r14 = getClientWidth();
        if (r14 <= 0) goto L5;
        float r15 = this.mPageMargin / r14;
    L7:
        if (r13 == null) goto L39;
        int r16 = r13.position;
        int r17 = r11.position;
        if (r16 >= r17) goto L25;
        float r18 = (r13.offset + r13.widthFactor) + r15;
        int r19 = r16 + 1;
        int r110 = 0;
    L12:
        if (r19 > r11.position) goto L39;
        if (r110 >= this.mItems.size()) goto L39;
        ItemInfo r20 = this.mItems.get(r110);
    L16:
        ItemInfo r21 = r20;
        if (r19 <= r21.position) goto L22;
        if (r110 >= (this.mItems.size() - 1)) goto L22;
        r110 = r110 + 1;
        r20 = this.mItems.get(r110);
    L22:
        if (r19 >= r21.position) goto L24;
        r18 = r18 + (this.mAdapter.getPageWidth(r19) + r15);
        r19 = r19 + 1;
        goto L22
    L24:
        r21.offset = r18;
        r18 = r18 + (r21.widthFactor + r15);
        r19 = r19 + 1;
        goto L12
    L25:
        if (r16 <= r17) goto L39;
        int r22 = this.mItems.size() - 1;
        float r111 = r13.offset;
    L27:
        r16 = r16 - 1;
        if (r16 < r11.position) goto L39;
        if (r22 < 0) goto L39;
        ItemInfo r23 = this.mItems.get(r22);
    L31:
        ItemInfo r24 = r23;
        if (r16 >= r24.position) goto L36;
        if (r22 <= 0) goto L36;
        r22 = r22 - 1;
        r23 = this.mItems.get(r22);
    L36:
        if (r16 <= r24.position) goto L38;
        r111 = r111 - (this.mAdapter.getPageWidth(r16) + r15);
        r16 = r16 - 1;
        goto L36
    L38:
        r111 = r111 - (r24.widthFactor + r15);
        r24.offset = r111;
    L39:
        int r112 = this.mItems.size();
        float r25 = r11.offset;
        int r26 = r11.position;
        int r27 = r26 - 1;
        if (r26 != 0) goto L42;
        float r28 = r25;
    L43:
        this.mFirstOffset = r28;
        int r29 = r10 - 1;
        if (r26 != r29) goto L46;
        float r30 = (r11.widthFactor + r25) - 1.0f;
    L47:
        this.mLastOffset = r30;
        int r31 = r12 - 1;
    L48:
        if (r31 < 0) goto L57;
        ItemInfo r32 = this.mItems.get(r31);
    L50:
        int r33 = r32.position;
        if (r27 <= r33) goto L53;
        r25 = r25 - (this.mAdapter.getPageWidth(r27) + r15);
        r27 = r27 - 1;
        goto L50
    L53:
        r25 = r25 - (r32.widthFactor + r15);
        r32.offset = r25;
        if (r33 != 0) goto L56;
        this.mFirstOffset = r25;
    L56:
        r31 = r31 - 1;
        r27 = r27 - 1;
        goto L48
    L57:
        float r34 = (r11.offset + r11.widthFactor) + r15;
        int r113 = r11.position + 1;
        int r114 = r12 + 1;
    L58:
        if (r114 >= r112) goto L66;
        ItemInfo r35 = this.mItems.get(r114);
    L60:
        int r36 = r35.position;
        if (r113 >= r36) goto L63;
        r34 = r34 + (this.mAdapter.getPageWidth(r113) + r15);
        r113 = r113 + 1;
        goto L60
    L63:
        if (r36 != r29) goto L65;
        this.mLastOffset = (r35.widthFactor + r34) - 1.0f;
    L65:
        r35.offset = r34;
        r34 = r34 + (r35.widthFactor + r15);
        r114 = r114 + 1;
        r113 = r113 + 1;
        goto L58
    L66:
        this.mNeedCalculatePageOffsets = false;
        return;
    L46:
        r30 = Float.MAX_VALUE;
        goto L47
    L42:
        r28 = -3.4028235E38f;
        goto L43
    L5:
        r15 = 0.0f;
        goto L7
    }

    private void completeScroll(boolean r10) {
        if (this.mScrollState != 2) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L11;
        setScrollingCacheEnabled(false);
        this.mScroller.abortAnimation();
        int r12 = getScrollX();
        int r13 = getScrollY();
        int r14 = this.mScroller.getCurrX();
        int r15 = this.mScroller.getCurrY();
        if (r12 != r14) goto L10;
        if (r13 == r15) goto L11;
    L10:
        scrollTo(r14, r15);
    L11:
        this.mPopulatePending = false;
        int r16 = 0;
    L13:
        if (r16 >= this.mItems.size()) goto L18;
        ItemInfo r17 = this.mItems.get(r16);
        if (r17.scrolling == false) goto L17;
        r17.scrolling = false;
        r11 = true;
    L17:
        r16 = r16 + 1;
        goto L13
    L18:
        if (r11 == false) goto L26;
        if (r10 == false) goto L21;
        postOnAnimation(this.mEndScrollRunnable);
        return;
    L21:
        this.mEndScrollRunnable.run();
        return;
    L26:
        return;
    L5:
        r11 = false;
        goto L6
    }

    private int determineTargetPage(int r10, float r11, int r12, int r13) {
        if (Math.abs(r13) <= this.mFlingDistance) goto L10;
        if (Math.abs(r12) <= this.mMinimumVelocity) goto L10;
        if (r12 > 0) goto L15;
        r10 = r10 + 1;
    L15:
        if (this.mItems.size() <= 0) goto L18;
        ItemInfo r14 = this.mItems.get(0);
        ArrayList<ItemInfo> r15 = this.mItems;
        return Math.max(r14.position, Math.min(r10, r15.get(r15.size() - 1).position));
    L18:
        return r10;
    L10:
        if (r10 < this.mCurItem) goto L12;
        float r16 = 0.4f;
    L13:
        r10 = (int) ((r10 + r11) + r16);
        goto L15
    L12:
        r16 = 0.6f;
        goto L13
    }

    private void enableLayers(boolean r10) {
        int r11 = getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        if (r10 == false) goto L6;
        int r13 = 2;
    L7:
        getChildAt(r12).setLayerType(r13, null);
        r12 = r12 + 1;
        goto L3
    L6:
        r13 = 0;
        goto L7
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker r10 = this.mVelocityTracker;
        if (r10 == null) goto L6;
        r10.recycle();
        this.mVelocityTracker = null;
        return;
    }

    private Rect getChildRectInPagerCoordinates(Rect r10, View r11) {
        if (r10 != null) goto L4;
        r10 = new Rect();
    L4:
        if (r11 != null) goto L7;
        r10.set(0, 0, 0, 0);
        return r10;
    L7:
        r10.left = r11.getLeft();
        r10.right = r11.getRight();
        r10.top = r11.getTop();
        r10.bottom = r11.getBottom();
        ViewParent r12 = r11.getParent();
    L9:
        if ((r12 instanceof ViewGroup) == false) goto L12;
        if (r12 == this) goto L12;
        ViewGroup r13 = (ViewGroup) r12;
        r10.left += r13.getLeft();
        r10.right += r13.getRight();
        r10.top += r13.getTop();
        r10.bottom += r13.getBottom();
        r12 = r13.getParent();
    L12:
        return r10;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private ItemInfo infoForCurrentScrollPosition() {
        int r10 = getClientWidth();
        float r11 = 0.0f;
        if (r10 <= 0) goto L5;
        float r12 = getScrollX() / r10;
    L6:
        if (r10 <= 0) goto L8;
        float r13 = this.mPageMargin / r10;
    L9:
        int r14 = 0;
        boolean r15 = true;
        ItemInfo r16 = null;
        int r17 = -1;
        float r18 = 0.0f;
    L11:
        if (r14 >= this.mItems.size()) goto L30;
        ItemInfo r19 = this.mItems.get(r14);
        if (r15 == true) goto L17;
        int r20 = r17 + 1;
        if (r19.position == r20) goto L17;
        r19 = this.mTempItem;
        r19.offset = (r11 + r18) + r13;
        r19.position = r20;
        r19.widthFactor = this.mAdapter.getPageWidth(r20);
        r14 = r14 - 1;
    L17:
        ItemInfo r21 = r19;
        r11 = r21.offset;
        float r22 = (r21.widthFactor + r11) + r13;
        if (r15 == true) goto L24;
        if (r12 >= r11) goto L24;
        return r16;
    L24:
        if (r12 < r22) goto L29;
        if (r14 == (this.mItems.size() - 1)) goto L29;
        int r23 = r21.position;
        float r24 = r21.widthFactor;
        r14 = r14 + 1;
        r15 = false;
        r17 = r23;
        r18 = r24;
        r16 = r21;
    L29:
        return r21;
    L30:
        return r16;
    L8:
        r13 = 0.0f;
        goto L9
    L5:
        r12 = 0.0f;
        goto L6
    }

    private boolean isGutterDrag(float r10, float r11) {
        if (r10 >= this.mGutterSize) goto L7;
        if (r11 <= 0.0f) goto L7;
    L10:
        return true;
    L7:
        if (r10 > (getWidth() - this.mGutterSize)) goto L9;
    L11:
        return false;
    L9:
        if (r11 >= 0.0f) goto L11;
        goto L10
    }

    private void onSecondaryPointerUp(MotionEvent r10) {
        int r11 = r10.getActionIndex();
        if (r10.getPointerId(r11) != this.mActivePointerId) goto L11;
        if (r11 != 0) goto L6;
        int r12 = 1;
    L7:
        this.mLastMotionX = r10.getX(r12);
        this.mActivePointerId = r10.getPointerId(r12);
        VelocityTracker r13 = this.mVelocityTracker;
        if (r13 == null) goto L12;
        r13.clear();
        return;
    L12:
        return;
    L6:
        r12 = 0;
        goto L7
    }

    private boolean pageScrolled(int r10) {
        if (this.mItems.size() != 0) goto L9;
        this.mCalledSuper = false;
        onPageScrolled(0, 0.0f, 0);
        if (this.mCalledSuper == false) goto L8;
        return false;
    L8:
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    L9:
        ItemInfo r11 = infoForCurrentScrollPosition();
        int r12 = getClientWidth();
        int r13 = this.mPageMargin;
        int r14 = r12 + r13;
        float r15 = r12;
        int r16 = r11.position;
        float r17 = ((r10 / r15) - r11.offset) / (r11.widthFactor + (r13 / r15));
        this.mCalledSuper = false;
        onPageScrolled(r16, r17, (int) (r14 * r17));
        if (this.mCalledSuper == false) goto L14;
        return true;
    L14:
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean performDrag(float r13) {
        float r10 = this.mLastMotionX - r13;
        this.mLastMotionX = r13;
        float r11 = getScrollX() + r10;
        float r12 = getClientWidth();
        float r14 = this.mFirstOffset * r12;
        float r15 = this.mLastOffset * r12;
        ItemInfo r16 = this.mItems.get(0);
        ArrayList<ItemInfo> r17 = this.mItems;
        boolean r18 = true;
        ItemInfo r19 = r17.get(r17.size() - 1);
        if (r16.position == 0) goto L5;
        r14 = r16.offset * r12;
        boolean r20 = false;
    L7:
        if (r19.position == (this.mAdapter.getCount() - 1)) goto L10;
        r15 = r19.offset * r12;
        r18 = false;
    L10:
        if (r11 >= r14) goto L14;
        if (r20 == false) goto L17;
        overScrollBy((int) r10, 0, getScrollX(), getScrollY(), (int) r14, 0, this.mOverscrollDistance, 0, true);
    L18:
        return false;
    L17:
        int r21 = (int) r11;
        this.mLastMotionX += r11 - r21;
        scrollTo(r21, getScrollY());
        pageScrolled(r21);
        goto L18
    L14:
        if (r11 <= r15) goto L17;
        if (r18 == false) goto L17;
        overScrollBy((int) r10, 0, getScrollX(), getScrollY(), (int) r15, 0, this.mOverscrollDistance, 0, true);
        goto L18
    L5:
        r20 = true;
        goto L7
    }

    private void recomputeScrollPosition(int r10, int r11, int r12, int r13) {
        if (r11 > 0) goto L4;
    L8:
        ItemInfo r14 = infoForPosition(this.mCurItem);
        if (r14 == null) goto L11;
        float r15 = Math.min(r14.offset, this.mLastOffset);
    L12:
        int r16 = (int) (r15 * ((r10 - getPaddingLeft()) - getPaddingRight()));
        if (r16 == getScrollX()) goto L18;
        completeScroll(false);
        scrollTo(r16, getScrollY());
        return;
    L18:
        return;
    L11:
        r15 = 0.0f;
        goto L12
    L4:
        if (this.mItems.isEmpty() == true) goto L8;
        int r17 = (int) ((getScrollX() / (((r11 - getPaddingLeft()) - getPaddingRight()) + r13)) * (((r10 - getPaddingLeft()) - getPaddingRight()) + r12));
        scrollTo(r17, getScrollY());
        if (this.mScroller.isFinished() == true) goto L16;
        this.mScroller.startScroll(r17, 0, (int) (infoForPosition(this.mCurItem).offset * r10), 0, this.mScroller.getDuration() - this.mScroller.timePassed());
        return;
    }

    private void removeNonDecorViews() {
        int r10 = 0;
    L4:
        if (r10 >= getChildCount()) goto L9;
        if (((LayoutParams) getChildAt(r10).getLayoutParams()).isDecor == true) goto L8;
        removeViewAt(r10);
        r10 = r10 - 1;
    L8:
        r10 = r10 + 1;
        goto L4
    }

    private void requestParentDisallowInterceptTouchEvent(boolean r10) {
        ViewParent r11 = getParent();
        if (r11 == null) goto L6;
        r11.requestDisallowInterceptTouchEvent(r10);
        return;
    }

    private void scrollToItem(int r10, boolean r11, int r12, boolean r13) {
        ItemInfo r14 = infoForPosition(r10);
        if (r14 == null) goto L5;
        int r15 = (int) (getClientWidth() * Math.max(this.mFirstOffset, Math.min(r14.offset, this.mLastOffset)));
    L6:
        if (r11 == false) goto L16;
        smoothScrollTo(r15, 0, r12);
        if (r13 == false) goto L12;
        OnPageChangeListener r16 = this.mOnPageChangeListener;
        if (r16 == null) goto L12;
        r16.onPageSelected(r10);
    L12:
        if (r13 == false) goto L26;
        OnPageChangeListener r17 = this.mInternalPageChangeListener;
        if (r17 == null) goto L27;
        r17.onPageSelected(r10);
        return;
    L27:
        return;
    L26:
        return;
    L16:
        if (r13 == false) goto L20;
        OnPageChangeListener r18 = this.mOnPageChangeListener;
        if (r18 == null) goto L20;
        r18.onPageSelected(r10);
    L20:
        if (r13 == false) goto L24;
        OnPageChangeListener r19 = this.mInternalPageChangeListener;
        if (r19 == null) goto L24;
        r19.onPageSelected(r10);
    L24:
        completeScroll(false);
        scrollTo(r15, 0);
        pageScrolled(r15);
        return;
    L5:
        r15 = 0;
        goto L6
    }

    private void setScrollState(int r10) {
        if (this.mScrollState != r10) goto L5;
        return;
    L5:
        this.mScrollState = r10;
        if (this.mPageTransformer == null) goto L11;
        if (r10 == 0) goto L9;
        boolean r11 = true;
    L10:
        enableLayers(r11);
        goto L11
    L9:
        r11 = false;
    L11:
        OnPageChangeListener r12 = this.mOnPageChangeListener;
        if (r12 == null) goto L15;
        r12.onPageScrollStateChanged(r10);
        return;
    }

    private void setScrollingCacheEnabled(boolean r10) {
        if (this.mScrollingCacheEnabled == r10) goto L6;
        this.mScrollingCacheEnabled = r10;
        return;
    }

    private void sortChildDrawingOrder() {
        if (this.mDrawingOrder == 0) goto L14;
        ArrayList<View> r10 = this.mDrawingOrderedChildren;
        if (r10 != null) goto L7;
        this.mDrawingOrderedChildren = new ArrayList();
    L8:
        int r11 = getChildCount();
        int r12 = 0;
    L9:
        if (r12 >= r11) goto L11;
        View r13 = getChildAt(r12);
        this.mDrawingOrderedChildren.add(r13);
        r12 = r12 + 1;
        goto L9
    L11:
        Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        return;
    L7:
        r10.clear();
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> r10, int r11, int r12) {
        int r13 = r10.size();
        int r14 = getDescendantFocusability();
        if (r14 == 393216) goto L16;
        int r15 = 0;
    L6:
        if (r15 >= getChildCount()) goto L16;
        View r16 = getChildAt(r15);
        if (r16.getVisibility() != 0) goto L14;
        ItemInfo r17 = infoForChild(r16);
        if (r17 == null) goto L14;
        if (r17.position != this.mCurItem) goto L14;
        r16.addFocusables(r10, r11, r12);
    L14:
        r15 = r15 + 1;
    L16:
        if (r14 != 262144) goto L20;
        if (r13 == r10.size()) goto L20;
        return;
    L20:
        if (isFocusable() == true) goto L23;
        return;
    L23:
        if ((r12 & 1) == 1) goto L25;
    L29:
        r10.add(this);
        return;
    L25:
        if (isInTouchMode() == false) goto L29;
        if (isFocusableInTouchMode() == true) goto L29;
    }

    public ItemInfo addNewItem(int r10, int r11) {
        ItemInfo r12 = new ItemInfo();
        r12.position = r10;
        r12.object = this.mAdapter.instantiateItem(this, r10);
        r12.widthFactor = this.mAdapter.getPageWidth(r10);
        if (r11 >= 0) goto L5;
    L8:
        this.mItems.add(r12);
    L9:
        return r12;
    L5:
        if (r11 >= this.mItems.size()) goto L8;
        this.mItems.add(r11, r12);
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> r10) {
        int r11 = 0;
    L4:
        if (r11 >= getChildCount()) goto L13;
        View r12 = getChildAt(r11);
        if (r12.getVisibility() != 0) goto L12;
        ItemInfo r13 = infoForChild(r12);
        if (r13 == null) goto L12;
        if (r13.position != this.mCurItem) goto L12;
        r12.addTouchables(r10);
    L12:
        r11 = r11 + 1;
        goto L4
    }

    @Override // android.view.ViewGroup
    public void addView(View r10, int r11, ViewGroup.LayoutParams r12) {
        if (checkLayoutParams(r12) == true) goto L5;
        r12 = generateLayoutParams(r12);
    L5:
        LayoutParams r13 = (LayoutParams) r12;
        boolean r14 = r13.isDecor | (r10 instanceof Decor);
        r13.isDecor = r14;
        if (this.mInLayout == false) goto L11;
        if (r14 == true) goto L10;
        r13.needsMeasure = true;
        addViewInLayout(r10, r11, r12);
        return;
    L10:
        throw new IllegalStateException("Cannot add pager decor view during layout");
    L11:
        super.addView(r10, r11, r12);
    }

    public boolean arrowScroll(int r10) {
        View r11 = findFocus();
        if (r11 != this) goto L5;
    L4:
        r11 = null;
    L17:
        View r12 = FocusFinder.getInstance().findNextFocus(this, r11, r10);
        if (r12 == null) goto L32;
        if (r12 == r11) goto L32;
        if (r10 != 17) goto L26;
        int r13 = getChildRectInPagerCoordinates(this.mTempRect, r12).left;
        int r14 = getChildRectInPagerCoordinates(this.mTempRect, r11).left;
        if (r11 == null) goto L25;
        if (r13 < r14) goto L25;
        boolean r15 = pageLeft();
    L43:
        if (r15 == false) goto L45;
        playSoundEffect(SoundEffectConstants.getContantForFocusDirection(r10));
    L45:
        return r15;
    L25:
        r15 = r12.requestFocus();
        goto L43
    L26:
        if (r10 != 66) goto L40;
        int r16 = getChildRectInPagerCoordinates(this.mTempRect, r12).left;
        int r17 = getChildRectInPagerCoordinates(this.mTempRect, r11).left;
        if (r11 == null) goto L31;
        if (r16 > r17) goto L31;
        r15 = pageRight();
    L31:
        r15 = r12.requestFocus();
    L40:
        r15 = false;
    L32:
        if (r10 != 17) goto L34;
    L42:
        r15 = pageLeft();
        goto L43
    L34:
        if (r10 == 1) goto L42;
        if (r10 != 66) goto L38;
    L41:
        r15 = pageRight();
        goto L43
    L38:
        if (r10 != 2) goto L40;
    L5:
        if (r11 == null) goto L17;
        ViewParent r18 = r11.getParent();
    L8:
        if ((r18 instanceof ViewGroup) == false) goto L12;
        if (r18 == this) goto L17;
        r18 = r18.getParent();
        goto L8
    L12:
        StringBuilder r19 = new StringBuilder();
        r19.append(r11.getClass().getSimpleName());
        ViewParent r20 = r11.getParent();
    L14:
        if ((r20 instanceof ViewGroup) == false) goto L16;
        r19.append(" => ");
        r19.append(r20.getClass().getSimpleName());
        r20 = r20.getParent();
        goto L14
    L16:
        i.b(TAG, "arrowScroll tried to find focus based on non-child current focused view " + r19.toString());
        goto L4
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged == false) goto L6;
        return false;
    L6:
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        VelocityTracker r10 = this.mVelocityTracker;
        if (r10 != null) goto L9;
        this.mVelocityTracker = VelocityTracker.obtain();
    L10:
        long r11 = SystemClock.uptimeMillis();
        MotionEvent r12 = MotionEvent.obtain(r11, r11, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(r12);
        r12.recycle();
        this.mFakeDragBeginTime = r11;
        return true;
    L9:
        r10.clear();
        goto L10
    }

    public boolean canScroll(View r13, boolean r14, int r15, int r16, int r17) {
        if ((r13 instanceof ViewGroup) == false) goto L18;
        ViewGroup r10 = (ViewGroup) r13;
        int r11 = r13.getScrollX();
        int r12 = r13.getScrollY();
        int r18 = r10.getChildCount() - 1;
    L5:
        if (r18 < 0) goto L18;
        View r19 = r10.getChildAt(r18);
        int r20 = r16 + r11;
        if (r20 < r19.getLeft()) goto L17;
        if (r20 >= r19.getRight()) goto L17;
        int r21 = r17 + r12;
        if (r21 < r19.getTop()) goto L17;
        if (r21 >= r19.getBottom()) goto L17;
        if (canScroll(r19, true, r15, r20 - r19.getLeft(), r21 - r19.getTop()) == false) goto L17;
        return true;
    L17:
        r18 = r18 - 1;
    L18:
        if (r14 == true) goto L20;
    L22:
        return false;
    L20:
        if (r13.canScrollHorizontally(-r15) == false) goto L22;
        return true;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int r10) {
        if (this.mAdapter != null) goto L5;
        return false;
    L5:
        int r11 = getClientWidth();
        int r12 = getScrollX();
        if (r10 < 0) goto L8;
        if (r10 > 0) goto L13;
        return false;
    L13:
        if (r12 < ((int) (r11 * this.mLastOffset))) goto L15;
        return false;
    L15:
        return true;
    L8:
        if (r12 > ((int) (r11 * this.mFirstOffset))) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r10) {
        if ((r10 instanceof LayoutParams) == true) goto L5;
    L7:
        return false;
    L5:
        if (super.checkLayoutParams(r10) == false) goto L7;
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.isFinished() == false) goto L5;
    L14:
        completeScroll(true);
        return;
    L5:
        if (this.mScroller.computeScrollOffset() == false) goto L14;
        int r10 = getScrollX();
        int r11 = getScrollY();
        int r12 = this.mScroller.getCurrX();
        int r13 = this.mScroller.getCurrY();
        if (r10 != r12) goto L9;
        if (r11 != r13) goto L9;
    L12:
        postInvalidateOnAnimation();
        return;
    L9:
        scrollTo(r12, r13);
        if (pageScrolled(r12) == true) goto L12;
        this.mScroller.abortAnimation();
        scrollTo(0, r13);
        goto L12
    }

    public void dataSetChanged() {
        int r10 = this.mAdapter.getCount();
        this.mExpectedAdapterCount = r10;
        if (this.mItems.size() < ((this.mOffscreenPageLimit * 2) + 1)) goto L5;
    L7:
        boolean r11 = false;
    L8:
        int r12 = this.mCurItem;
        int r13 = 0;
        boolean r14 = false;
    L10:
        if (r13 >= this.mItems.size()) goto L30;
        ItemInfo r15 = this.mItems.get(r13);
        int r16 = this.mAdapter.getItemPosition(r15.object);
        if (r16 == (-1)) goto L29;
        if (r16 != (-2)) goto L23;
        this.mItems.remove(r13);
        r13 = r13 - 1;
        if (r14 == true) goto L19;
        this.mAdapter.startUpdate(this);
        r14 = true;
    L19:
        this.mAdapter.destroyItem(this, r15.position, r15.object);
        int r17 = this.mCurItem;
        if (r17 != r15.position) goto L22;
        r12 = Math.max(0, Math.min(r17, r10 - 1));
    L22:
        r11 = true;
        goto L29
    L23:
        int r18 = r15.position;
        if (r18 == r16) goto L29;
        if (r18 != this.mCurItem) goto L28;
        r12 = r16;
    L28:
        r15.position = r16;
    L29:
        r13 = r13 + 1;
        goto L10
    L30:
        if (r14 == false) goto L32;
        this.mAdapter.finishUpdate(this);
    L32:
        Collections.sort(this.mItems, COMPARATOR);
        if (r11 == false) goto L49;
        int r19 = getChildCount();
        int r20 = 0;
    L35:
        if (r20 >= r19) goto L40;
        LayoutParams r21 = (LayoutParams) getChildAt(r20).getLayoutParams();
        if (r21.isDecor == true) goto L39;
        r21.widthFactor = 0.0f;
    L39:
        r20 = r20 + 1;
        goto L35
    L40:
        setCurrentItemInternal(r12, false, true);
        requestLayout();
        return;
    L49:
        return;
    L5:
        if (this.mItems.size() >= r10) goto L7;
        r11 = true;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent r10) {
        if (super.dispatchKeyEvent(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (executeKeyEvent(r10) == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r10) {
        if (r10.getEventType() == 4096) goto L5;
        int r11 = getChildCount();
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L19;
        View r13 = getChildAt(r12);
        if (r13.getVisibility() != 0) goto L18;
        ItemInfo r14 = infoForChild(r13);
        if (r14 == null) goto L18;
        if (r14.position != this.mCurItem) goto L18;
        if (r13.dispatchPopulateAccessibilityEvent(r10) == false) goto L18;
        return true;
    L18:
        r12 = r12 + 1;
        goto L7
    L19:
        return false;
    L5:
        return super.dispatchPopulateAccessibilityEvent(r10);
    }

    public float distanceInfluenceForSnapDuration(float r10) {
        return (float) Math.sin((float) (((double) (r10 - DEFAULT_OFFSET)) * 0.4712389167638204d));
    }

    @Override // android.view.View
    public void draw(Canvas r10) {
        super.draw(r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable r10 = this.mMarginDrawable;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isStateful() == false) goto L9;
        r10.setState(getDrawableState());
        return;
    }

    public void endFakeDrag() {
        if (this.mFakeDragging == false) goto L7;
        VelocityTracker r10 = this.mVelocityTracker;
        r10.computeCurrentVelocity(1000, this.mMaximumVelocity);
        int r11 = (int) r10.getXVelocity(this.mActivePointerId);
        this.mPopulatePending = true;
        int r12 = getClientWidth();
        int r13 = getScrollX();
        ItemInfo r14 = infoForCurrentScrollPosition();
        setCurrentItemInternal(determineTargetPage(r14.position, ((r13 / r12) - r14.offset) / r14.widthFactor, r11, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, r11);
        endDrag();
        this.mFakeDragging = false;
        return;
    L7:
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public boolean executeKeyEvent(KeyEvent r10) {
        if (r10.getAction() != 0) goto L19;
        int r11 = r10.getKeyCode();
        if (r11 == 21) goto L24;
        if (r11 == 22) goto L23;
        if (r11 != 61) goto L19;
        if (r10.hasNoModifiers() == false) goto L15;
        return arrowScroll(2);
    L15:
        if (r10.hasModifiers(1) == false) goto L19;
        return arrowScroll(1);
    L23:
        return arrowScroll(66);
    L24:
        return arrowScroll(17);
    L19:
        return false;
    }

    public void fakeDragBy(float r11) {
        if (this.mFakeDragging == false) goto L19;
        this.mLastMotionX += r11;
        float r10 = getScrollX() - r11;
        float r12 = getClientWidth();
        float r13 = this.mFirstOffset * r12;
        float r14 = this.mLastOffset * r12;
        ItemInfo r15 = this.mItems.get(0);
        ArrayList<ItemInfo> r16 = this.mItems;
        ItemInfo r17 = r16.get(r16.size() - 1);
        if (r15.position == 0) goto L8;
        r13 = r15.offset * r12;
    L8:
        if (r17.position == (this.mAdapter.getCount() - 1)) goto L11;
        r14 = r17.offset * r12;
    L11:
        if (r10 >= r13) goto L14;
        r10 = r13;
    L16:
        int r18 = (int) r10;
        this.mLastMotionX += r10 - r18;
        scrollTo(r18, getScrollY());
        pageScrolled(r18);
        MotionEvent r19 = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0.0f, 0);
        this.mVelocityTracker.addMovement(r19);
        r19.recycle();
        return;
    L14:
        if (r10 <= r14) goto L16;
        r10 = r14;
        goto L16
    L19:
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return generateDefaultLayoutParams();
    }

    public PagerAdapter getAdapter() {
        return this.mAdapter;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int r10, int r11) {
        if (this.mDrawingOrder != 2) goto L6;
        r11 = (r10 - 1) - r11;
    L6:
        return ((LayoutParams) this.mDrawingOrderedChildren.get(r11).getLayoutParams()).childIndex;
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

    public ItemInfo infoForAnyChild(View r10) {
    L2:
        Object r11 = r10.getParent();
        if (r11 == this) goto L12;
        if (r11 == null) goto L9;
        if ((r11 instanceof View) == false) goto L16;
        r10 = (View) r11;
        goto L2
    L16:
        return null;
    L9:
        return null;
    L12:
        return infoForChild(r10);
    }

    public ItemInfo infoForChild(View r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.mItems.size()) goto L9;
        ItemInfo r12 = this.mItems.get(r11);
        if (this.mAdapter.isViewFromObject(r10, r12.object) == true) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return r12;
    L9:
        return null;
    }

    public ItemInfo infoForPosition(int r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.mItems.size()) goto L9;
        ItemInfo r12 = this.mItems.get(r11);
        if (r12.position == r10) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return r12;
    L9:
        return null;
    }

    public void initViewPager() {
        setWillNotDraw(false);
        setDescendantFocusability(UiType.FLAG_TIMER_CARD);
        setFocusable(true);
        Context r10 = getContext();
        this.mScroller = new Scroller(r10, SINTERPOLATOR);
        ViewConfiguration r11 = ViewConfiguration.get(r10);
        float r12 = r10.getResources().getDisplayMetrics().density;
        this.mTouchSlop = r11.getScaledPagingTouchSlop() / 3;
        this.mMinimumVelocity = (int) (400.0f * r12);
        this.mMaximumVelocity = r11.getScaledMaximumFlingVelocity();
        this.mFlingDistance = (int) (25.0f * r12);
        this.mCloseEnough = (int) (2.0f * r12);
        this.mDefaultGutterSize = (int) (r12 * 16.0f);
        setAccessibilityDelegate(new MyAccessibilityDelegate(this));
        if (getImportantForAccessibility() != 0) goto L6;
        setImportantForAccessibility(1);
        return;
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas r18) {
        super.onDraw(r18);
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
        int r10 = getScrollX();
        int r11 = getWidth();
        float r12 = r11;
        float r13 = this.mPageMargin / r12;
        int r14 = 0;
        ItemInfo r15 = this.mItems.get(0);
        float r16 = r15.offset;
        int r17 = this.mItems.size();
        int r19 = r15.position;
        int r110 = this.mItems.get(r17 - 1).position;
    L11:
        if (r19 >= r110) goto L35;
    L12:
        int r111 = r15.position;
        if (r19 <= r111) goto L16;
        if (r14 >= r17) goto L16;
        r14 = r14 + 1;
        r15 = this.mItems.get(r14);
    L16:
        if (r19 != r111) goto L18;
        float r20 = r15.offset;
        float r112 = r15.widthFactor;
        float r113 = (r20 + r112) * r12;
        r16 = (r20 + r112) + r13;
    L19:
        int r114 = this.mPageMargin;
        if ((r114 + r113) <= r10) goto L24;
        this.mMarginDrawable.setBounds((int) r113, this.mTopPageBounds, (int) ((r114 + r113) + DEFAULT_OFFSET), this.mBottomPageBounds);
        this.mMarginDrawable.draw(r18);
    L24:
        if (r113 > (r10 + r11)) goto L36;
        r19 = r19 + 1;
        r13 = r13;
        goto L11
    L36:
        return;
    L18:
        float r115 = this.mAdapter.getPageWidth(r19);
        r113 = (r16 + r115) * r12;
        r16 = r16 + (r115 + r13);
        goto L19
    L35:
        return;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r16) {
        int r10 = r16.getAction() & PrivateKeyType.INVALID;
        if (r10 != 3) goto L5;
    L60:
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        this.mActivePointerId = -1;
        VelocityTracker r11 = this.mVelocityTracker;
        if (r11 == null) goto L63;
        r11.recycle();
        this.mVelocityTracker = null;
    L63:
        return false;
    L5:
        if (r10 == 1) goto L60;
        if (r10 == 0) goto L15;
        if (this.mIsBeingDragged == false) goto L12;
        return true;
    L12:
        if (this.mIsUnableToDrag == false) goto L15;
        return false;
    L15:
        if (r10 == 0) goto L49;
        if (r10 != 2) goto L18;
        int r12 = this.mActivePointerId;
        if (r12 == (-1)) goto L56;
        int r13 = r16.findPointerIndex(r12);
        float r14 = r16.getX(r13);
        float r15 = r14 - this.mLastMotionX;
        float r17 = Math.abs(r15);
        float r18 = r16.getY(r13);
        float r19 = Math.abs(r18 - this.mInitialMotionY);
        if (r15 != 0.0f) goto L27;
    L32:
        int r20 = this.mTouchSlop;
        if (r17 <= r20) goto L42;
        if ((r17 * X_Y_DISTANCE_OFFSET) <= r19) goto L42;
        this.mIsBeingDragged = true;
        requestParentDisallowInterceptTouchEvent(true);
        setScrollState(1);
        if (r15 <= 0.0f) goto L39;
        float r21 = this.mInitialMotionX + this.mTouchSlop;
    L40:
        this.mLastMotionX = r21;
        this.mLastMotionY = r18;
        setScrollingCacheEnabled(true);
    L45:
        if (this.mIsBeingDragged == false) goto L56;
        if (performDrag(r14) == false) goto L56;
        postInvalidateOnAnimation();
        goto L56
    L39:
        r21 = this.mInitialMotionX - this.mTouchSlop;
    L42:
        if (r19 <= r20) goto L45;
        this.mIsUnableToDrag = true;
        goto L45
    L27:
        if (isGutterDrag(this.mLastMotionX, r15) == true) goto L32;
        if (canScroll(this, false, (int) r15, (int) r14, (int) r18) == false) goto L32;
        this.mLastMotionX = r14;
        this.mLastMotionY = r18;
        this.mIsUnableToDrag = true;
        return false;
    L56:
        if (this.mVelocityTracker != null) goto L58;
        this.mVelocityTracker = VelocityTracker.obtain();
    L58:
        this.mVelocityTracker.addMovement(r16);
        return this.mIsBeingDragged;
    L18:
        if (r10 != 6) goto L56;
        onSecondaryPointerUp(r16);
        goto L56
    L49:
        float r22 = r16.getX();
        this.mInitialMotionX = r22;
        this.mLastMotionX = r22;
        float r23 = r16.getY();
        this.mInitialMotionY = r23;
        this.mLastMotionY = r23;
        this.mActivePointerId = r16.getPointerId(0);
        this.mIsUnableToDrag = false;
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

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        int r10 = getChildCount();
        int r11 = r22 - r20;
        int r12 = r23 - r21;
        int r13 = getPaddingLeft();
        int r14 = getPaddingTop();
        int r15 = getPaddingRight();
        int r16 = getPaddingBottom();
        int r17 = getScrollX();
        int r18 = 0;
        int r110 = 0;
    L4:
        if (r18 >= r10) goto L33;
        View r111 = getChildAt(r18);
        if (r111.getVisibility() == 8) goto L32;
        LayoutParams r112 = (LayoutParams) r111.getLayoutParams();
        if (r112.isDecor == false) goto L32;
        int r113 = r112.gravity;
        int r114 = r113 & 7;
        int r115 = r113 & 112;
        if (r114 != 1) goto L12;
        int r116 = Math.max((r11 - r111.getMeasuredWidth()) / 2, r13);
    L17:
        int r117 = r116;
        int r118 = r13;
        r13 = r117;
    L21:
        if (r115 != 16) goto L23;
        int r119 = Math.max((r12 - r111.getMeasuredHeight()) / 2, r14);
    L28:
        int r120 = r119;
        int r121 = r14;
        r14 = r120;
    L31:
        int r24 = r13 + r17;
        r111.layout(r24, r14, r111.getMeasuredWidth() + r24, r14 + r111.getMeasuredHeight());
        r110 = r110 + 1;
        r14 = r121;
        r13 = r118;
        goto L32
    L23:
        if (r115 != 48) goto L25;
        r121 = r111.getMeasuredHeight() + r14;
        goto L31
    L25:
        if (r115 == 80) goto L27;
        r121 = r14;
        goto L31
    L27:
        r119 = (r12 - r16) - r111.getMeasuredHeight();
        r16 = r16 + r111.getMeasuredHeight();
        goto L28
    L12:
        if (r114 != 3) goto L14;
        r118 = r111.getMeasuredWidth() + r13;
        goto L21
    L14:
        if (r114 == 5) goto L16;
        r118 = r13;
        goto L21
    L16:
        r116 = (r11 - r15) - r111.getMeasuredWidth();
        r15 = r15 + r111.getMeasuredWidth();
    L32:
        r18 = r18 + 1;
        goto L4
    L33:
        int r25 = (r11 - r13) - r15;
        int r26 = 0;
    L34:
        if (r26 >= r10) goto L46;
        View r27 = getChildAt(r26);
        if (r27.getVisibility() == 8) goto L45;
        LayoutParams r122 = (LayoutParams) r27.getLayoutParams();
        if (r122.isDecor == true) goto L45;
        ItemInfo r123 = infoForChild(r27);
        if (r123 == null) goto L45;
        float r124 = r25;
        int r125 = ((int) (r123.offset * r124)) + r13;
        if (r122.needsMeasure == false) goto L44;
        r122.needsMeasure = false;
        r27.measure(View.MeasureSpec.makeMeasureSpec((int) (r124 * r122.widthFactor), Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec((r12 - r14) - r16, Ints.MAX_POWER_OF_TWO));
    L44:
        r27.layout(r125, r14, r27.getMeasuredWidth() + r125, r27.getMeasuredHeight() + r14);
    L45:
        r26 = r26 + 1;
        goto L34
    L46:
        this.mTopPageBounds = r14;
        this.mBottomPageBounds = r12 - r16;
        this.mDecorChildCount = r110;
        if (this.mFirstLayout == false) goto L49;
        boolean r28 = false;
        scrollToItem(this.mCurItem, false, 0, false);
    L50:
        this.mFirstLayout = r28;
        this.mOverscrollDistance = r11;
        this.mOverflingDistance = r11 / 2;
        return;
    L49:
        r28 = false;
        goto L50
    }

    @Override // android.view.View
    public void onMeasure(int r14, int r15) {
        int r10 = 0;
        setMeasuredDimension(ViewGroup.getDefaultSize(0, r14), ViewGroup.getDefaultSize(0, r15));
        int r16 = getMeasuredWidth();
        this.mGutterSize = Math.min(r16 / 10, this.mDefaultGutterSize);
        int r17 = (r16 - getPaddingLeft()) - getPaddingRight();
        int r18 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int r11 = getChildCount();
        int r12 = 0;
    L3:
        boolean r13 = true;
        int r19 = Ints.MAX_POWER_OF_TWO;
        if (r12 >= r11) goto L48;
        View r20 = getChildAt(r12);
        if (r20.getVisibility() == 8) goto L47;
        LayoutParams r21 = (LayoutParams) r20.getLayoutParams();
        if (r21 == null) goto L47;
        if (r21.isDecor == false) goto L47;
        int r22 = r21.gravity;
        int r23 = r22 & 7;
        int r24 = r22 & 112;
        if (r24 != 48) goto L14;
    L17:
        boolean r25 = true;
    L19:
        if (r23 != 3) goto L21;
    L24:
        int r26 = Integer.MIN_VALUE;
        if (r25 == false) goto L27;
        int r27 = Integer.MIN_VALUE;
        r26 = 1073741824;
    L30:
        int r110 = ((ViewGroup.LayoutParams) r21).width;
        if (r110 == (-2)) goto L35;
        if (r110 == (-1)) goto L34;
    L33:
        r26 = 1073741824;
    L36:
        int r28 = ((ViewGroup.LayoutParams) r21).height;
        if (r28 == (-2)) goto L41;
        if (r28 != (-1)) goto L42;
        r28 = r18;
    L42:
        r20.measure(View.MeasureSpec.makeMeasureSpec(r110, r26), View.MeasureSpec.makeMeasureSpec(r28, r19));
        if (r25 == false) goto L45;
        r18 = r18 - r20.getMeasuredHeight();
        goto L47
    L45:
        if (r13 == false) goto L47;
        r17 = r17 - r20.getMeasuredWidth();
        goto L47
    L41:
        r28 = r18;
        r19 = r27;
        goto L42
    L34:
        r110 = r17;
        goto L33
    L35:
        r110 = r17;
        goto L36
    L27:
        if (r13 == false) goto L29;
        r27 = 1073741824;
        goto L30
    L29:
        r27 = Integer.MIN_VALUE;
        goto L30
    L21:
        if (r23 == 5) goto L24;
        r13 = false;
        goto L24
    L14:
        if (r24 == 80) goto L17;
        r25 = false;
    L47:
        r12 = r12 + 1;
        goto L3
    L48:
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(r17, Ints.MAX_POWER_OF_TWO);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(r18, Ints.MAX_POWER_OF_TWO);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        int r111 = getChildCount();
    L49:
        if (r10 >= r111) goto L58;
        View r29 = getChildAt(r10);
        if (r29.getVisibility() == 8) goto L57;
        LayoutParams r30 = (LayoutParams) r29.getLayoutParams();
        if (r30 != null) goto L55;
    L56:
        r29.measure(View.MeasureSpec.makeMeasureSpec((int) (r17 * r30.widthFactor), Ints.MAX_POWER_OF_TWO), this.mChildHeightMeasureSpec);
        goto L57
    L55:
        if (r30.isDecor == false) goto L56;
    L57:
        r10 = r10 + 1;
        goto L49
    }

    @Override // android.view.View
    public void onOverScrolled(int r10, int r11, boolean r12, boolean r13) {
        if (getScrollX() == r10) goto L6;
        onScrollChanged(r10, getScrollY(), getScrollX(), getScrollY());
        scrollTo(r10, getScrollY());
        return;
    }

    public void onPageScrolled(int r13, float r14, int r15) {
        int r10 = 0;
        if (this.mDecorChildCount <= 0) goto L25;
        int r11 = getScrollX();
        int r12 = getPaddingLeft();
        int r16 = getPaddingRight();
        int r17 = getWidth();
        int r18 = getChildCount();
        int r19 = 0;
    L5:
        if (r19 >= r18) goto L25;
        View r20 = getChildAt(r19);
        LayoutParams r21 = (LayoutParams) r20.getLayoutParams();
        if (r21.isDecor == false) goto L24;
        int r22 = r21.gravity & 7;
        if (r22 != 1) goto L12;
        int r23 = Math.max((r17 - r20.getMeasuredWidth()) / 2, r12);
    L17:
        int r110 = r23;
        int r24 = r12;
        r12 = r110;
    L20:
        int r25 = (r12 + r11) - r20.getLeft();
        if (r25 == 0) goto L23;
        r20.offsetLeftAndRight(r25);
    L23:
        r12 = r24;
        goto L24
    L12:
        if (r22 != 3) goto L14;
        r24 = r20.getWidth() + r12;
        goto L20
    L14:
        if (r22 == 5) goto L16;
        r24 = r12;
        goto L20
    L16:
        r23 = (r17 - r16) - r20.getMeasuredWidth();
        r16 = r16 + r20.getMeasuredWidth();
    L24:
        r19 = r19 + 1;
    L25:
        OnPageChangeListener r26 = this.mOnPageChangeListener;
        if (r26 == null) goto L28;
        r26.onPageScrolled(r13, r14, r15);
    L28:
        OnPageChangeListener r27 = this.mInternalPageChangeListener;
        if (r27 == null) goto L32;
        r27.onPageScrolled(r13, r14, r15);
    L32:
        if (this.mPageTransformer == null) goto L40;
        int r111 = getScrollX();
        int r112 = getChildCount();
    L34:
        if (r10 >= r112) goto L40;
        View r113 = getChildAt(r10);
        if (((LayoutParams) r113.getLayoutParams()).isDecor == true) goto L39;
        this.mPageTransformer.transformPage(r113, (r113.getLeft() - r111) / getClientWidth());
    L39:
        r10 = r10 + 1;
    L40:
        this.mCalledSuper = true;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int r10, Rect r11) {
        int r12 = getChildCount();
        if ((r10 & 2) == 0) goto L5;
        int r13 = r12;
        int r14 = 0;
        int r15 = 1;
    L6:
        if (r14 == r13) goto L17;
        View r16 = getChildAt(r14);
        if (r16.getVisibility() != 0) goto L16;
        ItemInfo r17 = infoForChild(r16);
        if (r17 == null) goto L16;
        if (r17.position != this.mCurItem) goto L16;
        if (r16.requestFocus(r10, r11) == false) goto L16;
        return true;
    L16:
        r14 = r14 + r15;
        goto L6
    L17:
        return false;
    L5:
        r14 = r12 - 1;
        r13 = -1;
        r15 = -1;
        goto L6
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        PagerAdapter r12 = this.mAdapter;
        if (r12 == null) goto L9;
        r12.restoreState(r11.adapterState, r11.loader);
        setCurrentItemInternal(r11.position, false, true);
        return;
    L9:
        this.mRestoredCurItem = r11.position;
        this.mRestoredAdapterState = r11.adapterState;
        this.mRestoredClassLoader = r11.loader;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        r10.position = this.mCurItem;
        PagerAdapter r11 = this.mAdapter;
        if (r11 == null) goto L5;
        r10.adapterState = r11.saveState();
    L5:
        return r10;
    }

    @Override // android.view.View
    public void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        if (r10 == r12) goto L6;
        int r14 = this.mPageMargin;
        recomputeScrollPosition(r10, r12, r14, r14);
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        if (this.mFakeDragging == false) goto L5;
        return true;
    L5:
        boolean r11 = false;
        if (r10.getAction() == 0) goto L8;
    L10:
        PagerAdapter r12 = this.mAdapter;
        if (r12 != null) goto L13;
    L66:
        return false;
    L13:
        if (r12.getCount() == 0) goto L66;
        if (this.mVelocityTracker != null) goto L18;
        this.mVelocityTracker = VelocityTracker.obtain();
    L18:
        this.mVelocityTracker.addMovement(r10);
        int r13 = r10.getAction() & PrivateKeyType.INVALID;
        if (r13 != 0) goto L21;
        this.mScroller.abortAnimation();     // Catch: IllegalArgumentException -> L32
        this.mPopulatePending = false;     // Catch: IllegalArgumentException -> L32
        populate();     // Catch: IllegalArgumentException -> L32
        float r14 = r10.getX();     // Catch: IllegalArgumentException -> L32
        this.mInitialMotionX = r14;     // Catch: IllegalArgumentException -> L32
        this.mLastMotionX = r14;     // Catch: IllegalArgumentException -> L32
        float r15 = r10.getY();     // Catch: IllegalArgumentException -> L32
        this.mInitialMotionY = r15;     // Catch: IllegalArgumentException -> L32
        this.mLastMotionY = r15;     // Catch: IllegalArgumentException -> L32
        this.mActivePointerId = r10.getPointerId(0);     // Catch: IllegalArgumentException -> L32
    L63:
        if (r11 == false) goto L65;
        postInvalidateOnAnimation();
    L65:
        return true;
    L21:
        if (r13 == 1) goto L58;
        if (r13 == 2) goto L39;
        if (r13 == 3) goto L36;
        if (r13 != 5) goto L29;
        int r16 = r10.getActionIndex();     // Catch: IllegalArgumentException -> L32
        this.mLastMotionX = r10.getX(r16);     // Catch: IllegalArgumentException -> L32
        this.mActivePointerId = r10.getPointerId(r16);     // Catch: IllegalArgumentException -> L32
        goto L63
    L29:
        if (r13 != 6) goto L63;
        onSecondaryPointerUp(r10);     // Catch: IllegalArgumentException -> L32
        this.mLastMotionX = r10.getX(r10.findPointerIndex(this.mActivePointerId));     // Catch: IllegalArgumentException -> L32
        goto L63
    L36:
        if (this.mIsBeingDragged == false) goto L63;
        scrollToItem(this.mCurItem, true, 0, false);     // Catch: IllegalArgumentException -> L32
        this.mActivePointerId = -1;     // Catch: IllegalArgumentException -> L32
        endDrag();     // Catch: IllegalArgumentException -> L32
        goto L63
    L39:
        if (this.mIsBeingDragged == true) goto L55;
        int r17 = r10.findPointerIndex(this.mActivePointerId);     // Catch: IllegalArgumentException -> L32
        if (r17 >= 0) goto L43;
        i.b(TAG, "Invalid pointerId=" + this.mActivePointerId + " in onTouchEvent");     // Catch: IllegalArgumentException -> L32
        goto L63
    L43:
        float r18 = r10.getX(r17);     // Catch: IllegalArgumentException -> L32
        float r19 = Math.abs(r18 - this.mLastMotionX);     // Catch: IllegalArgumentException -> L32
        float r20 = r10.getY(r17);     // Catch: IllegalArgumentException -> L32
        float r21 = Math.abs(r20 - this.mLastMotionY);     // Catch: IllegalArgumentException -> L32
        if (r19 <= this.mTouchSlop) goto L55;
        if ((r19 * X_Y_DISTANCE_OFFSET) <= r21) goto L55;
        this.mIsBeingDragged = true;     // Catch: IllegalArgumentException -> L32
        requestParentDisallowInterceptTouchEvent(true);     // Catch: IllegalArgumentException -> L32
        float r22 = this.mInitialMotionX;     // Catch: IllegalArgumentException -> L32
        if ((r18 - r22) <= 0.0f) goto L50;
        float r23 = r22 + this.mTouchSlop;     // Catch: IllegalArgumentException -> L32
    L51:
        this.mLastMotionX = r23;     // Catch: IllegalArgumentException -> L32
        this.mLastMotionY = r20;     // Catch: IllegalArgumentException -> L32
        setScrollState(1);     // Catch: IllegalArgumentException -> L32
        setScrollingCacheEnabled(true);     // Catch: IllegalArgumentException -> L32
        ViewParent r24 = getParent();     // Catch: IllegalArgumentException -> L32
        if (r24 == null) goto L55;
        r24.requestDisallowInterceptTouchEvent(true);     // Catch: IllegalArgumentException -> L32
        goto L55
    L50:
        r23 = r22 - this.mTouchSlop;     // Catch: IllegalArgumentException -> L32
    L55:
        if (this.mIsBeingDragged == false) goto L63;
        r11 = performDrag(r10.getX(r10.findPointerIndex(this.mActivePointerId)));     // Catch: IllegalArgumentException -> L32
        goto L63
    L58:
        if (this.mIsBeingDragged == false) goto L63;
        VelocityTracker r25 = this.mVelocityTracker;     // Catch: IllegalArgumentException -> L32
        r25.computeCurrentVelocity(1000, this.mMaximumVelocity);     // Catch: IllegalArgumentException -> L32
        int r26 = (int) r25.getXVelocity(this.mActivePointerId);     // Catch: IllegalArgumentException -> L32
        this.mPopulatePending = true;     // Catch: IllegalArgumentException -> L32
        int r27 = getClientWidth();     // Catch: IllegalArgumentException -> L32
        int r28 = getScrollX();     // Catch: IllegalArgumentException -> L32
        ItemInfo r29 = infoForCurrentScrollPosition();     // Catch: IllegalArgumentException -> L32
        setCurrentItemInternal(determineTargetPage(r29.position, ((r28 / r27) - r29.offset) / r29.widthFactor, r26, (int) (r10.getX(r10.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX)), true, true, r26);     // Catch: IllegalArgumentException -> L32
        this.mActivePointerId = -1;     // Catch: IllegalArgumentException -> L32
        endDrag();     // Catch: IllegalArgumentException -> L32
    L32:
        e = move-exception;
        e.printStackTrace();
        goto L63
    L8:
        if (r10.getEdgeFlags() == 0) goto L10;
        return false;
    }

    @Override // android.view.View
    public boolean overScrollBy(int r25, int r26, int r27, int r28, int r29, int r30, int r31, int r32, boolean r33) {
        int r10 = r31;
        int r11 = r32;
        int r12 = getOverScrollMode();
        if (r12 == 0) goto L7;
        if (r12 == 1) goto L7;
        boolean r13 = false;
    L8:
        if (r12 == 0) goto L12;
        if (r12 == 1) goto L12;
        boolean r14 = false;
    L13:
        int r15 = r27 + r25;
        if (r25 <= 0) goto L17;
        if (r15 <= r29) goto L20;
    L16:
        boolean r16 = true;
    L22:
        if (r33 == false) goto L39;
        if (r16 == false) goto L39;
        int r17 = Math.abs(r27 - r29);
        double r18 = r17;
        double r19 = r10;
        if (r18 >= (r19 * 0.5d)) goto L29;
        float r110 = r10;
        int r111 = r17 * 12;
    L27:
        float r112 = (r110 / (r111 + r10)) * r25;
    L37:
        r15 = r27 + ((int) r112);
        goto L39
    L29:
        if (r18 >= (r19 * 0.67d)) goto L32;
        r110 = r10;
        r111 = r17 * 20;
        goto L27
    L32:
        if (Math.abs(r25) <= 20) goto L36;
        if (r25 <= 0) goto L35;
        r112 = 1.0f;
        goto L37
    L35:
        r112 = -1.0f;
        goto L37
    L36:
        r112 = 0.0f;
    L39:
        if (r13 == true) goto L41;
        r10 = 0;
    L41:
        int r20 = r28 + r26;
        if (r26 <= 0) goto L45;
        if (r20 <= r30) goto L48;
    L44:
        boolean r113 = true;
    L49:
        if (r33 == false) goto L64;
        if (r113 == false) goto L64;
        int r21 = Math.abs(r28 - r30);
        double r114 = r21;
        double r115 = r11;
        if (r114 >= (0.5d * r115)) goto L55;
        float r116 = (r11 / ((r21 * 12) + r11)) * r26;
    L63:
        r20 = ((int) r116) + r28;
        goto L64
    L55:
        if (r114 >= (r115 * 0.67d)) goto L58;
        r116 = (r11 / ((r21 * 20) + r11)) * r26;
        goto L63
    L58:
        if (Math.abs(r26) <= 20) goto L62;
        if (r26 <= 0) goto L61;
        r116 = 1.0f;
        goto L63
    L61:
        r116 = -1.0f;
        goto L63
    L62:
        r116 = 0.0f;
    L64:
        if (r14 == true) goto L66;
        r11 = 0;
    L66:
        int r22 = -(Math.abs(r10) + Math.abs(r29));
        int r23 = r10 + r29;
        int r24 = -(Math.abs(r11) + Math.abs(r30));
        int r34 = r11 + r30;
        if (r15 <= r23) goto L71;
        if (r15 <= r27) goto L71;
        r15 = r23;
    L70:
        boolean r35 = true;
    L75:
        if (r20 <= r34) goto L78;
        if (r20 <= r28) goto L78;
        boolean r36 = true;
        r20 = r34;
    L82:
        onOverScrolled(r15, r20, r35, r36);
        if (r35 == true) goto L87;
        if (r36 == true) goto L87;
        return false;
    L87:
        return true;
    L78:
        if (r20 >= r24) goto L81;
        if (r20 >= r28) goto L81;
        r36 = true;
        r20 = r24;
    L81:
        r36 = false;
    L71:
        if (r15 >= r22) goto L74;
        if (r15 >= r27) goto L74;
        r15 = r22;
    L74:
        r35 = false;
    L48:
        r113 = false;
        goto L49
    L45:
        if (r26 >= 0) goto L48;
        if (r20 >= r30) goto L48;
    L20:
        r16 = false;
        goto L22
    L17:
        if (r25 >= 0) goto L20;
        if (r15 >= r29) goto L20;
    L12:
        r14 = true;
    L7:
        r13 = true;
        goto L8
    }

    public boolean pageLeft() {
        int r10 = this.mCurItem;
        if (r10 <= 0) goto L6;
        setCurrentItem(r10 - 1, true);
        return true;
    L6:
        return false;
    }

    public boolean pageRight() {
        PagerAdapter r10 = this.mAdapter;
        if (r10 != null) goto L5;
        return false;
    L5:
        if (this.mCurItem >= (r10.getCount() - 1)) goto L10;
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    L10:
        return false;
    }

    public void populate() {
        populate(this.mCurItem);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View r10) {
        if (this.mInLayout == false) goto L5;
        removeViewInLayout(r10);
        return;
    L5:
        super.removeView(r10);
    }

    public void setAdapter(PagerAdapter r10) {
        PagerAdapter r11 = this.mAdapter;
        if (r11 == null) goto L9;
        r11.unregisterDataSetObserver(this.mObserver);
        this.mAdapter.startUpdate(this);
        int r12 = 0;
    L6:
        if (r12 >= this.mItems.size()) goto L8;
        ItemInfo r13 = this.mItems.get(r12);
        this.mAdapter.destroyItem(this, r13.position, r13.object);
        r12 = r12 + 1;
        goto L6
    L8:
        this.mAdapter.finishUpdate(this);
        this.mItems.clear();
        removeNonDecorViews();
        this.mCurItem = 0;
        scrollTo(0, 0);
    L9:
        PagerAdapter r14 = this.mAdapter;
        this.mAdapter = r10;
        this.mExpectedAdapterCount = 0;
        if (r10 == null) goto L20;
        AnonymousClass1 r15 = null;
        if (this.mObserver != null) goto L14;
        this.mObserver = new PagerObserver(this, r15);
    L14:
        this.mAdapter.registerDataSetObserver(this.mObserver);
        this.mPopulatePending = false;
        boolean r16 = this.mFirstLayout;
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
        if (r16 == true) goto L19;
        populate();
        goto L20
    L19:
        requestLayout();
    L20:
        OnAdapterChangeListener r17 = this.mAdapterChangeListener;
        if (r17 == null) goto L26;
        if (r14 == r10) goto L27;
        r17.onAdapterChanged(r14, r10);
        return;
    L27:
        return;
    }

    public void setChildrenDrawingOrderEnabledCompat(boolean r10) {
        if (this.mSetChildrenDrawingOrderEnabled == null) goto L15;
    L13:
        this.mSetChildrenDrawingOrderEnabled.invoke(this, new Object[]{Boolean.valueOf(r10)});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        i.c(TAG, "Error changing children drawing order", e);
        return;
    L15:
        this.mSetChildrenDrawingOrderEnabled = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});     // Catch: NoSuchMethodException -> L6
    L6:
        e = move-exception;
        i.c(TAG, "Can't find setChildrenDrawingOrderEnabled", e);
        goto L13
    }

    public void setCurrentItem(int r10) {
        this.mPopulatePending = false;
        setCurrentItemInternal(r10, !this.mFirstLayout, false);
    }

    public void setCurrentItemInternal(int r10, boolean r11, boolean r12) {
        setCurrentItemInternal(r10, r11, r12, 0);
    }

    public OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener r10) {
        OnPageChangeListener r11 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = r10;
        return r11;
    }

    public void setOffscreenPageLimit(int r10) {
        if (r10 >= 1) goto L6;
        i.k(TAG, "Requested offscreen page limit " + r10 + " too small; defaulting to 1");
        r10 = 1;
    L6:
        if (r10 == this.mOffscreenPageLimit) goto L9;
        this.mOffscreenPageLimit = r10;
        populate();
        return;
    }

    public void setOnAdapterChangeListener(OnAdapterChangeListener r10) {
        this.mAdapterChangeListener = r10;
    }

    public void setOnPageChangeListener(OnPageChangeListener r10) {
        this.mOnPageChangeListener = r10;
    }

    public void setPageMargin(int r10) {
        int r11 = this.mPageMargin;
        this.mPageMargin = r10;
        int r12 = getWidth();
        recomputeScrollPosition(r12, r12, r10, r11);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable r10) {
        this.mMarginDrawable = r10;
        if (r10 == null) goto L5;
        refreshDrawableState();
    L5:
        if (r10 != null) goto L7;
        boolean r11 = true;
    L8:
        setWillNotDraw(r11);
        invalidate();
        return;
    L7:
        r11 = false;
        goto L8
    }

    public void setPageTransformer(boolean r10, PageTransformer r11) {
        int r12 = 1;
        if (r11 == null) goto L5;
        boolean r13 = true;
    L7:
        if (this.mPageTransformer == null) goto L9;
        boolean r14 = true;
    L10:
        if (r13 == r14) goto L12;
        boolean r15 = true;
    L13:
        this.mPageTransformer = r11;
        setChildrenDrawingOrderEnabledCompat(r13);
        if (r13 == false) goto L18;
        if (r10 == false) goto L17;
        r12 = 2;
    L17:
        this.mDrawingOrder = r12;
    L19:
        if (r15 == false) goto L22;
        populate();
        return;
    L22:
        return;
    L18:
        this.mDrawingOrder = 0;
        goto L19
    L12:
        r15 = false;
        goto L13
    L9:
        r14 = false;
        goto L10
    L5:
        r13 = false;
        goto L7
    }

    public void smoothScrollTo(int r10, int r11) {
        smoothScrollTo(r10, r11, 0);
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable r10) {
        if (super.verifyDrawable(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (r10 == this.mMarginDrawable) goto L8;
        return false;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return new LayoutParams(getContext(), r10);
    }

    public void populate(int r18) {
        int r10 = this.mCurItem;
        if (r10 == r18) goto L8;
        if (r10 >= r18) goto L6;
        int r11 = 66;
    L7:
        ItemInfo r12 = infoForPosition(r10);
        this.mCurItem = r18;
    L10:
        if (this.mAdapter != null) goto L14;
        sortChildDrawingOrder();
        return;
    L14:
        if (this.mPopulatePending == false) goto L18;
        sortChildDrawingOrder();
        return;
    L18:
        if (getWindowToken() != null) goto L20;
        return;
    L20:
        this.mAdapter.startUpdate(this);
        int r13 = this.mOffscreenPageLimit;
        int r14 = Math.max(0, this.mCurItem - r13);
        int r15 = this.mAdapter.getCount();
        int r16 = Math.min(r15 - 1, this.mCurItem + r13);
        if (r15 != this.mExpectedAdapterCount) goto L147;
        int r17 = 0;
    L24:
        if (r17 >= this.mItems.size()) goto L30;
        ItemInfo r19 = this.mItems.get(r17);
        int r110 = r19.position;
        int r111 = this.mCurItem;
        if (r110 >= r111) goto L27;
        r17 = r17 + 1;
        goto L24
    L27:
        if (r110 != r111) goto L30;
    L31:
        if (r19 != null) goto L34;
        if (r15 <= 0) goto L34;
        r19 = addNewItem(this.mCurItem, r17);
    L34:
        if (r19 == null) goto L106;
        int r112 = r17 - 1;
        if (r112 < 0) goto L38;
        ItemInfo r113 = this.mItems.get(r112);
    L39:
        int r114 = getClientWidth();
        if (r114 > 0) goto L42;
        float r20 = 0.0f;
    L43:
        int r21 = this.mCurItem - 1;
        float r115 = 0.0f;
    L44:
        if (r21 < 0) goto L68;
        if (r115 < r20) goto L58;
        if (r21 >= r14) goto L58;
        if (r113 == null) goto L68;
        if (r21 != r113.position) goto L67;
        if (r113.scrolling == true) goto L67;
        this.mItems.remove(r112);
        this.mAdapter.destroyItem(this, r21, r113.object);
        r112 = r112 - 1;
        r17 = r17 - 1;
        if (r112 < 0) goto L57;
        r113 = this.mItems.get(r112);
    L57:
        r113 = null;
    L67:
        r21 = r21 - 1;
    L58:
        if (r113 != null) goto L60;
    L64:
        r115 = r115 + addNewItem(r21, r112 + 1).widthFactor;
        r17 = r17 + 1;
        if (r112 < 0) goto L57;
        r113 = this.mItems.get(r112);
        goto L67
    L60:
        if (r21 != r113.position) goto L64;
        r115 = r115 + r113.widthFactor;
        r112 = r112 - 1;
        if (r112 < 0) goto L57;
        r113 = this.mItems.get(r112);
    L68:
        float r22 = r19.widthFactor;
        int r23 = r17 + 1;
        if (r22 < 2.0f) goto L71;
    L105:
        calculatePageOffsets(r19, r17, r12);
        goto L106
    L71:
        if (r23 >= this.mItems.size()) goto L73;
        ItemInfo r24 = this.mItems.get(r23);
    L74:
        if (r114 > 0) goto L76;
        float r116 = 0.0f;
    L77:
        int r117 = this.mCurItem;
    L78:
        r117 = r117 + 1;
        if (r117 >= r15) goto L105;
        if (r22 < r116) goto L93;
        if (r117 <= r16) goto L93;
        if (r24 == null) goto L105;
        if (r117 != r24.position) goto L78;
        if (r24.scrolling == true) goto L78;
        this.mItems.remove(r23);
        this.mAdapter.destroyItem(this, r117, r24.object);
        if (r23 < this.mItems.size()) goto L91;
    L92:
        r24 = null;
        goto L78
    L91:
        r24 = this.mItems.get(r23);
    L93:
        if (r24 == null) goto L100;
        if (r117 != r24.position) goto L100;
        r22 = r22 + r24.widthFactor;
        r23 = r23 + 1;
        if (r23 >= this.mItems.size()) goto L92;
        r24 = this.mItems.get(r23);
    L100:
        if ((r13 - r117) < 0) goto L78;
        ItemInfo r25 = addNewItem(r117, r23);
        r23 = r23 + 1;
        r22 = r22 + r25.widthFactor;
        if (r23 >= this.mItems.size()) goto L92;
        r24 = this.mItems.get(r23);
        goto L78
    L76:
        r116 = (getPaddingRight() / r114) + 2.0f;
        goto L77
    L73:
        r24 = null;
        goto L74
    L42:
        r20 = (2.0f - r19.widthFactor) + (getPaddingLeft() / r114);
        goto L43
    L38:
        r113 = null;
    L106:
        PagerAdapter r26 = this.mAdapter;
        int r27 = this.mCurItem;
        if (r19 == null) goto L109;
        Object r28 = r19.object;
    L110:
        r26.setPrimaryItem(this, r27, r28);
        this.mAdapter.finishUpdate(this);
        int r29 = getChildCount();
        int r30 = 0;
    L111:
        if (r30 >= r29) goto L121;
        View r31 = getChildAt(r30);
        LayoutParams r32 = (LayoutParams) r31.getLayoutParams();
        r32.childIndex = r30;
        if (r32.isDecor == true) goto L120;
        if (r32.widthFactor != 0.0f) goto L120;
        ItemInfo r33 = infoForChild(r31);
        if (r33 == null) goto L120;
        r32.widthFactor = r33.widthFactor;
        r32.position = r33.position;
    L120:
        r30 = r30 + 1;
        goto L111
    L121:
        sortChildDrawingOrder();
        if (hasFocus() == false) goto L141;
        View r34 = findFocus();
        if (r34 == null) goto L126;
        ItemInfo r35 = infoForAnyChild(r34);
    L127:
        if (r35 != null) goto L129;
    L130:
        int r36 = 0;
    L132:
        if (r36 >= getChildCount()) goto L195;
        View r37 = getChildAt(r36);
        ItemInfo r38 = infoForChild(r37);
        if (r38 == null) goto L140;
        if (r38.position != this.mCurItem) goto L140;
        if (r37.requestFocus(r11) == false) goto L140;
        return;
    L140:
        r36 = r36 + 1;
        goto L132
    L195:
        return;
    L129:
        if (r35.position != this.mCurItem) goto L130;
        return;
    L126:
        r35 = null;
        goto L127
    L141:
        return;
    L109:
        r28 = null;
    L30:
        r19 = null;
        goto L31
    L147:
        String r39 = getResources().getResourceName(getId());     // Catch: Resources.NotFoundException -> L144
    L146:
        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mExpectedAdapterCount + ", found: " + r15 + " Pager id: " + r39 + " Pager class: " + getClass() + " Problematic adapter: " + this.mAdapter.getClass());
    L144:
        r39 = Integer.toHexString(getId());
        goto L146
    L6:
        r11 = 17;
        goto L7
    L8:
        r11 = 2;
        r12 = null;
        goto L10
    }

    public void setCurrentItemInternal(int r10, boolean r11, boolean r12, int r13) {
        PagerAdapter r14 = this.mAdapter;
        boolean r15 = false;
        if (r14 != null) goto L5;
    L45:
        setScrollingCacheEnabled(false);
        return;
    L5:
        if (r14.getCount() <= 0) goto L45;
        if (r12 == true) goto L15;
        if (this.mCurItem != r10) goto L15;
        if (this.mItems.size() == 0) goto L15;
        setScrollingCacheEnabled(false);
        return;
    L15:
        if (r10 >= 0) goto L18;
        r10 = 0;
    L20:
        int r16 = this.mOffscreenPageLimit;
        int r17 = this.mCurItem;
        if (r10 <= (r17 + r16)) goto L23;
    L24:
        int r18 = 0;
    L26:
        if (r18 >= this.mItems.size()) goto L29;
        this.mItems.get(r18).scrolling = true;
        r18 = r18 + 1;
    L29:
        if (this.mCurItem == r10) goto L32;
        r15 = true;
    L32:
        if (this.mFirstLayout == false) goto L43;
        this.mCurItem = r10;
        if (r15 == false) goto L38;
        OnPageChangeListener r19 = this.mOnPageChangeListener;
        if (r19 == null) goto L38;
        r19.onPageSelected(r10);
    L38:
        if (r15 == false) goto L42;
        OnPageChangeListener r20 = this.mInternalPageChangeListener;
        if (r20 == null) goto L42;
        r20.onPageSelected(r10);
    L42:
        requestLayout();
        return;
    L43:
        populate(r10);
        scrollToItem(r10, r11, r13, r15);
        return;
    L23:
        if (r10 >= (r17 - r16)) goto L29;
    L18:
        if (r10 < this.mAdapter.getCount()) goto L20;
        r10 = this.mAdapter.getCount() - 1;
        goto L20
    }

    public void smoothScrollTo(int r10, int r11, int r12) {
        if (getChildCount() != 0) goto L6;
        setScrollingCacheEnabled(false);
        return;
    L6:
        int r13 = getScrollX();
        int r14 = getScrollY();
        int r15 = r10 - r13;
        int r16 = r11 - r14;
        if (r15 != 0) goto L11;
        if (r16 != 0) goto L11;
        completeScroll(false);
        populate();
        setScrollState(0);
        return;
    L11:
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int r17 = getClientWidth();
        int r18 = r17 / 2;
        float r19 = r17;
        float r110 = r18;
        float r111 = r110 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (Math.abs(r15) * 1.0f) / r19)) * r110);
        int r112 = Math.abs(r12);
        if (r112 <= 0) goto L14;
        int r20 = Math.round(Math.abs(r111 / r112) * 1000.0f) * 4;
    L15:
        this.mScroller.startScroll(r13, r14, r15, r16, Math.min(r20, 600));
        postInvalidateOnAnimation();
        return;
    L14:
        r20 = (int) (((Math.abs(r15) / ((r19 * this.mAdapter.getPageWidth(this.mCurItem)) + this.mPageMargin)) + 1.0f) * 100.0f);
        goto L15
    }

    public void setCurrentItem(int r10, boolean r11) {
        this.mPopulatePending = false;
        setCurrentItemInternal(r10, r11, false);
    }

    public void setPageMarginDrawable(int r10) {
        setPageMarginDrawable(getContext().getResources().getDrawable(r10));
    }

    public ViewPagerCompat(Context r10, AttributeSet r11) {
        super(r10, r11);
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
        this.mEndScrollRunnable = new AnonymousClass2(this);
        this.mScrollState = 0;
        initViewPager();
    }
}
