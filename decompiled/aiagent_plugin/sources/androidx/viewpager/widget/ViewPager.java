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
import android.util.Log;
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
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class ViewPager extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final Comparator<b> COMPARATOR = null;
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
    private static final g sPositionComparator = null;
    private int mActivePointerId;
    androidx.viewpager.widget.a mAdapter;
    private List<d> mAdapterChangeListeners;
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
    private e mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList<b> mItems;
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
    private e mOnPageChangeListener;
    private List<e> mOnPageChangeListeners;
    private int mPageMargin;
    private f mPageTransformer;
    private int mPageTransformerLayerType;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private EdgeEffect mRightEdge;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private final b mTempItem;
    private final Rect mTempRect;
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

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

        public LayoutParams(Context r3, AttributeSet r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
            super(r5, r6);
            this.widthFactor = 0.0f;
            TypedArray r7 = r5.obtainStyledAttributes(r6, ViewPager.LAYOUT_ATTRS);
            this.gravity = r7.getInteger(0, 48);
            r7.recycle();
        }
    }

    private class PagerObserver extends DataSetObserver {
        final /* synthetic */ ViewPager this$0;

        PagerObserver(ViewPager r1) {
            this.this$0 = r1;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            this.this$0.dataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            this.this$0.dataSetChanged();
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        Parcelable adapterState;
        ClassLoader loader;
        int position;

        public SavedState(Parcelable r3) {
            super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin"));
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r2, int r3) {
            super.writeToParcel(r2, r3);
            r2.writeInt(this.position);
            r2.writeParcelable(this.adapterState, r3);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        SavedState(Parcel r2, ClassLoader r3) {
            super(r2, r3);
            if (r3 != null) goto L5;
            r3 = getClass().getClassLoader();
        L5:
            this.position = r2.readInt();
            this.adapterState = r2.readParcelable(r3);
            this.loader = r3;
        }
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface a {
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f2906a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2907b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f2908c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f2909d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f2910e;

        b() {
        }
    }

    class c extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewPager f2911a;

        c(ViewPager r1) {
            this.f2911a = r1;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void d(View r2, AccessibilityEvent r3) {
            super.d(r2, r3);
            r3.setClassName(ViewPager.class.getName());
            r3.setScrollable(b());
            if (r3.getEventType() == 4096) goto L5;
            return;
        L5:
            if (this.f2911a.mAdapter == null) goto L9;
            r3.setItemCount(this.f2911a.mAdapter.a());
            r3.setFromIndex(this.f2911a.mCurItem);
            r3.setToIndex(this.f2911a.mCurItem);
            return;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void a(View r2, androidx.core.view.accessibility.b r3) {
            super.a(r2, r3);
            r3.b(ViewPager.class.getName());
            r3.k(b());
            if (this.f2911a.canScrollHorizontally(1) == false) goto L6;
            r3.a(4096);
        L6:
            if (this.f2911a.canScrollHorizontally(-1) == false) goto L9;
            r3.a(8192);
            return;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean a(View r2, int r3, Bundle r4) {
            if (super.a(r2, r3, r4) == false) goto L6;
            return true;
        L6:
            if (r3 == 4096) goto L16;
            if (r3 == 8192) goto L11;
            return false;
        L11:
            if (this.f2911a.canScrollHorizontally(-1) == false) goto L14;
            ViewPager r1 = this.f2911a;
            r1.setCurrentItem(r1.mCurItem - 1);
            return true;
        L14:
            return false;
        L16:
            if (this.f2911a.canScrollHorizontally(1) == false) goto L19;
            ViewPager r5 = this.f2911a;
            r5.setCurrentItem(r5.mCurItem + 1);
            return true;
        L19:
            return false;
        }

        private boolean b() {
            if (this.f2911a.mAdapter != null) goto L5;
        L7:
            return false;
        L5:
            if (this.f2911a.mAdapter.a() <= 1) goto L7;
            return true;
        }
    }

    public interface d {
        void onAdapterChanged(ViewPager r1, androidx.viewpager.widget.a r2, androidx.viewpager.widget.a r3);
    }

    public interface e {
        void onPageScrollStateChanged(int r1);

        void onPageScrolled(int r1, float r2, int r3);

        void onPageSelected(int r1);
    }

    public interface f {
        void a(View r1, float r2);
    }

    static class g implements Comparator<View> {
        g() {
        }

        @Override // java.util.Comparator
        public /* synthetic */ int compare(View r3, View r4) {
            return a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"), (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"));
        }

        public int a(View r2, View r3) {
            LayoutParams r1 = (LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
            LayoutParams r4 = (LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
            if (r1.isDecor == r4.isDecor) goto L10;
            if (r1.isDecor == false) goto L7;
            return 1;
        L7:
            return -1;
        L10:
            return r1.position - r4.position;
        }
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.w(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.e(r0, r1);
    }

    static {
        LAYOUT_ATTRS = new int[]{R.attr.layout_gravity};
        COMPARATOR = new AnonymousClass1();
        sInterpolator = new AnonymousClass2();
        sPositionComparator = new g();
    }

    public ViewPager(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
        this.mItems = new ArrayList();
        this.mTempItem = new b();
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

    public ViewPager(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
        this.mItems = new ArrayList();
        this.mTempItem = new b();
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

    void initViewPager() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        this.mScroller = new Scroller(r1, sInterpolator);
        ViewConfiguration r3 = ViewConfiguration.get(r1);
        float r2 = ZeusTransformUtils.getResources(r1, "com.obric.aiagent.plugin").getDisplayMetrics().density;
        this.mTouchSlop = r3.getScaledPagingTouchSlop();
        this.mMinimumVelocity = (int) (400.0f * r2);
        this.mMaximumVelocity = r3.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffect(r1);
        this.mRightEdge = new EdgeEffect(r1);
        this.mFlingDistance = (int) (25.0f * r2);
        this.mCloseEnough = (int) (2.0f * r2);
        this.mDefaultGutterSize = (int) (r2 * 16.0f);
        ViewCompat.a(this, new c(this));
        if (ViewCompat.g(this) != 0) goto L5;
        ViewCompat.c(this, 1);
    L5:
        ViewCompat.a(this, new AnonymousClass4(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        Scroller r0 = this.mScroller;
        if (r0 != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        return;
    L5:
        if (r0.isFinished() == true) goto L7;
        this.mScroller.abortAnimation();
        goto L7
    }

    void setScrollState(int r2) {
        if (this.mScrollState != r2) goto L5;
        return;
    L5:
        this.mScrollState = r2;
        if (this.mPageTransformer == null) goto L11;
        if (r2 == 0) goto L9;
        boolean r0 = true;
    L10:
        enableLayers(r0);
        goto L11
    L9:
        r0 = false;
    L11:
        dispatchOnScrollStateChanged(r2);
    }

    public void setAdapter(androidx.viewpager.widget.a r9) {
        androidx.viewpager.widget.a r0 = this.mAdapter;
        int r3 = 0;
        if (r0 == null) goto L9;
        r0.c(null);
        this.mAdapter.a(this);
        int r1 = 0;
    L6:
        if (r1 >= this.mItems.size()) goto L8;
        b r4 = (b) ZeusTransformUtils.preCheckCast(this.mItems.get(r1), b.class, "com.obric.aiagent.plugin");
        this.mAdapter.a(this, r4.f2907b, r4.f2906a);
        r1 = r1 + 1;
        goto L6
    L8:
        this.mAdapter.b(this);
        this.mItems.clear();
        removeNonDecorViews();
        this.mCurItem = 0;
        scrollTo(0, 0);
    L9:
        androidx.viewpager.widget.a r2 = this.mAdapter;
        this.mAdapter = r9;
        this.mExpectedAdapterCount = 0;
        if (r9 != null) goto L12;
    L20:
        List<d> r5 = this.mAdapterChangeListeners;
        if (r5 != null) goto L23;
        return;
    L23:
        if (r5.isEmpty() == true) goto L30;
        int r6 = this.mAdapterChangeListeners.size();
    L25:
        if (r3 >= r6) goto L31;
        ((d) ZeusTransformUtils.preCheckCast(this.mAdapterChangeListeners.get(r3), d.class, "com.obric.aiagent.plugin")).onAdapterChanged(this, r2, r9);
        r3 = r3 + 1;
        goto L25
    L31:
        return;
    L30:
        return;
    L12:
        if (this.mObserver != null) goto L14;
        this.mObserver = new PagerObserver(this);
    L14:
        this.mAdapter.c(this.mObserver);
        this.mPopulatePending = false;
        boolean r7 = this.mFirstLayout;
        this.mFirstLayout = true;
        this.mExpectedAdapterCount = this.mAdapter.a();
        if (this.mRestoredCurItem < 0) goto L17;
        this.mAdapter.a(this.mRestoredAdapterState, this.mRestoredClassLoader);
        setCurrentItemInternal(this.mRestoredCurItem, false, true);
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        goto L20
    L17:
        if (r7 == true) goto L19;
        populate();
        goto L20
    L19:
        requestLayout();
        goto L20
    }

    private void removeNonDecorViews() {
        int r0 = 0;
    L4:
        if (r0 >= getChildCount()) goto L9;
        if (((LayoutParams) ZeusTransformUtils.preCheckCast(getChildAt(r0).getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).isDecor == true) goto L8;
        removeViewAt(r0);
        r0 = r0 - 1;
    L8:
        r0 = r0 + 1;
        goto L4
    }

    public androidx.viewpager.widget.a getAdapter() {
        return this.mAdapter;
    }

    public void addOnAdapterChangeListener(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        if (this.mAdapterChangeListeners != null) goto L5;
        this.mAdapterChangeListeners = new ArrayList();
    L5:
        this.mAdapterChangeListeners.add(r4);
    }

    public void removeOnAdapterChangeListener(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        List<d> r2 = this.mAdapterChangeListeners;
        if (r2 == null) goto L6;
        r2.remove(r4);
        return;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int r3) {
        this.mPopulatePending = false;
        setCurrentItemInternal(r3, !this.mFirstLayout, false);
    }

    public void setCurrentItem(int r2, boolean r3) {
        this.mPopulatePending = false;
        setCurrentItemInternal(r2, r3, false);
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    void setCurrentItemInternal(int r2, boolean r3, boolean r4) {
        setCurrentItemInternal(r2, r3, r4, 0);
    }

    void setCurrentItemInternal(int r6, boolean r7, boolean r8, int r9) {
        androidx.viewpager.widget.a r0 = this.mAdapter;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L39:
        setScrollingCacheEnabled(false);
        return;
    L5:
        if (r0.a() <= 0) goto L39;
        if (r8 == true) goto L15;
        if (this.mCurItem != r6) goto L15;
        if (this.mItems.size() == 0) goto L15;
        setScrollingCacheEnabled(false);
        return;
    L15:
        if (r6 >= 0) goto L18;
        r6 = 0;
    L20:
        int r2 = this.mOffscreenPageLimit;
        int r3 = this.mCurItem;
        if (r6 <= (r3 + r2)) goto L23;
    L24:
        int r4 = 0;
    L26:
        if (r4 >= this.mItems.size()) goto L29;
        ((b) ZeusTransformUtils.preCheckCast(this.mItems.get(r4), b.class, "com.obric.aiagent.plugin")).f2908c = true;
        r4 = r4 + 1;
    L29:
        if (this.mCurItem == r6) goto L32;
        r1 = true;
    L32:
        if (this.mFirstLayout == false) goto L37;
        this.mCurItem = r6;
        if (r1 == false) goto L36;
        dispatchOnPageSelected(r6);
    L36:
        requestLayout();
        return;
    L37:
        populate(r6);
        scrollToItem(r6, r7, r9, r1);
        return;
    L23:
        if (r6 >= (r3 - r2)) goto L29;
    L18:
        if (r6 < this.mAdapter.a()) goto L20;
        r6 = this.mAdapter.a() - 1;
        goto L20
    }

    private void scrollToItem(int r6, boolean r7, int r8, boolean r9) {
        b r0 = infoForPosition(r6);
        if (r0 == null) goto L5;
        int r1 = (int) (getClientWidth() * Math.max(this.mFirstOffset, Math.min(r0.f2910e, this.mLastOffset)));
    L6:
        if (r7 == false) goto L10;
        smoothScrollTo(r1, 0, r8);
        if (r9 == false) goto L14;
        dispatchOnPageSelected(r6);
        return;
    L14:
        return;
    L10:
        if (r9 == false) goto L12;
        dispatchOnPageSelected(r6);
    L12:
        completeScroll(false);
        scrollTo(r1, 0);
        pageScrolled(r1);
        return;
    L5:
        r1 = 0;
        goto L6
    }

    @Deprecated
    public void setOnPageChangeListener(e r3) {
        this.mOnPageChangeListener = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
    }

    public void addOnPageChangeListener(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
        if (this.mOnPageChangeListeners != null) goto L5;
        this.mOnPageChangeListeners = new ArrayList();
    L5:
        this.mOnPageChangeListeners.add(r4);
    }

    public void removeOnPageChangeListener(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
        List<e> r2 = this.mOnPageChangeListeners;
        if (r2 == null) goto L6;
        r2.remove(r4);
        return;
    }

    public void clearOnPageChangeListeners() {
        List<e> r0 = this.mOnPageChangeListeners;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public void setPageTransformer(boolean r3, f r4) {
        setPageTransformer(r3, (f) ZeusTransformUtils.wrapperContextForParams(r4, f.class, "com.obric.aiagent.plugin"), 2);
    }

    public void setPageTransformer(boolean r5, f r6, int r7) {
        f r8 = (f) ZeusTransformUtils.wrapperContextForParams(r6, f.class, "com.obric.aiagent.plugin");
        int r0 = 1;
        if (r8 == null) goto L5;
        boolean r2 = true;
    L7:
        if (this.mPageTransformer == null) goto L9;
        boolean r3 = true;
    L10:
        if (r2 == r3) goto L12;
        boolean r4 = true;
    L13:
        this.mPageTransformer = r8;
        setChildrenDrawingOrderEnabled(r2);
        if (r2 == false) goto L18;
        if (r5 == false) goto L17;
        r0 = 2;
    L17:
        this.mDrawingOrder = r0;
        this.mPageTransformerLayerType = r7;
    L19:
        if (r4 == false) goto L22;
        populate();
        return;
    L22:
        return;
    L18:
        this.mDrawingOrder = 0;
        goto L19
    L12:
        r4 = false;
        goto L13
    L9:
        r3 = false;
        goto L10
    L5:
        r2 = false;
        goto L7
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int r3, int r4) {
        if (this.mDrawingOrder != 2) goto L6;
        r4 = (r3 - 1) - r4;
    L6:
        return ((LayoutParams) ZeusTransformUtils.preCheckCast(((View) ZeusTransformUtils.preCheckCast(this.mDrawingOrderedChildren.get(r4), View.class, "com.obric.aiagent.plugin")).getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).childIndex;
    }

    e setInternalPageChangeListener(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
        e r0 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = r4;
        return r0;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public void setOffscreenPageLimit(int r4) {
        if (r4 >= 1) goto L6;
        INVOKESTATIC_androidx_viewpager_widget_ViewPager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Requested offscreen page limit " + r4 + " too small; defaulting to 1");
        r4 = 1;
    L6:
        if (r4 == this.mOffscreenPageLimit) goto L9;
        this.mOffscreenPageLimit = r4;
        populate();
        return;
    }

    public void setPageMargin(int r3) {
        int r0 = this.mPageMargin;
        this.mPageMargin = r3;
        int r1 = getWidth();
        recomputeScrollPosition(r1, r1, r3, r0);
        requestLayout();
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    public void setPageMarginDrawable(Drawable r1) {
        this.mMarginDrawable = r1;
        if (r1 == null) goto L5;
        refreshDrawableState();
    L5:
        if (r1 != null) goto L7;
        boolean r2 = true;
    L8:
        setWillNotDraw(r2);
        invalidate();
        return;
    L7:
        r2 = false;
        goto L8
    }

    public void setPageMarginDrawable(int r4) {
        setPageMarginDrawable(androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4));
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable r2) {
        if (super.verifyDrawable(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (r2 == this.mMarginDrawable) goto L8;
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable r0 = this.mMarginDrawable;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isStateful() == false) goto L9;
        r0.setState(getDrawableState());
        return;
    }

    float distanceInfluenceForSnapDuration(float r1) {
        return (float) Math.sin((r1 - 0.5f) * 0.47123894f);
    }

    void smoothScrollTo(int r2, int r3) {
        smoothScrollTo(r2, r3, 0);
    }

    void smoothScrollTo(int r10, int r11, int r12) {
        if (getChildCount() != 0) goto L6;
        setScrollingCacheEnabled(false);
        return;
    L6:
        Scroller r0 = this.mScroller;
        if (r0 != null) goto L9;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == true) goto L14;
        int r2 = getScrollX();
    L19:
        int r4 = r2;
        int r5 = getScrollY();
        int r6 = r10 - r4;
        int r7 = r11 - r5;
        if (r6 != 0) goto L24;
        if (r7 != 0) goto L24;
        completeScroll(false);
        populate();
        setScrollState(0);
        return;
    L24:
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int r13 = getClientWidth();
        int r14 = r13 / 2;
        float r15 = r13;
        float r16 = r14;
        float r17 = r16 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (Math.abs(r6) * 1.0f) / r15)) * r16);
        int r18 = Math.abs(r12);
        if (r18 <= 0) goto L27;
        int r19 = Math.round(Math.abs(r17 / r18) * 1000.0f) * 4;
    L28:
        int r8 = Math.min(r19, MAX_SETTLE_DURATION);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(r4, r5, r6, r7, r8);
        ViewCompat.f(this);
        return;
    L27:
        r19 = (int) (((Math.abs(r6) / ((r15 * this.mAdapter.b(this.mCurItem)) + this.mPageMargin)) + 1.0f) * 100.0f);
        goto L28
    L14:
        if (this.mIsScrollStarted == false) goto L16;
        r2 = this.mScroller.getCurrX();
    L17:
        this.mScroller.abortAnimation();
        setScrollingCacheEnabled(false);
        goto L19
    L16:
        r2 = this.mScroller.getStartX();
        goto L17
    L9:
        if (r0.isFinished() == true) goto L11;
        r1 = true;
        goto L12
    }

    b addNewItem(int r3, int r4) {
        b r0 = new b();
        r0.f2907b = r3;
        r0.f2906a = this.mAdapter.a(this, r3);
        r0.f2909d = this.mAdapter.b(r3);
        if (r4 >= 0) goto L5;
    L8:
        this.mItems.add(r0);
    L9:
        return r0;
    L5:
        if (r4 >= this.mItems.size()) goto L8;
        this.mItems.add(r4, r0);
        goto L9
    }

    void dataSetChanged() {
        int r0 = this.mAdapter.a();
        this.mExpectedAdapterCount = r0;
        if (this.mItems.size() < ((this.mOffscreenPageLimit * 2) + 1)) goto L5;
    L7:
        boolean r1 = false;
    L8:
        int r2 = this.mCurItem;
        int r5 = 0;
        boolean r6 = false;
    L10:
        if (r5 >= this.mItems.size()) goto L30;
        b r7 = (b) ZeusTransformUtils.preCheckCast(this.mItems.get(r5), b.class, "com.obric.aiagent.plugin");
        int r8 = this.mAdapter.a(r7.f2906a);
        if (r8 == (-1)) goto L29;
        if (r8 != (-2)) goto L24;
        this.mItems.remove(r5);
        r5 = r5 - 1;
        if (r6 == true) goto L19;
        this.mAdapter.a(this);
        r6 = true;
    L19:
        this.mAdapter.a(this, r7.f2907b, r7.f2906a);
        if (this.mCurItem != r7.f2907b) goto L22;
        r2 = Math.max(0, Math.min(this.mCurItem, r0 - 1));
    L22:
        r1 = true;
        goto L29
    L24:
        if (r7.f2907b == r8) goto L29;
        if (r7.f2907b != this.mCurItem) goto L28;
        r2 = r8;
    L28:
        r7.f2907b = r8;
    L29:
        r5 = r5 + 1;
        goto L10
    L30:
        if (r6 == false) goto L32;
        this.mAdapter.b(this);
    L32:
        Collections.sort(this.mItems, COMPARATOR);
        if (r1 == false) goto L49;
        int r3 = getChildCount();
        int r4 = 0;
    L35:
        if (r4 >= r3) goto L40;
        LayoutParams r9 = (LayoutParams) ZeusTransformUtils.preCheckCast(getChildAt(r4).getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (r9.isDecor == true) goto L39;
        r9.widthFactor = 0.0f;
    L39:
        r4 = r4 + 1;
        goto L35
    L40:
        setCurrentItemInternal(r2, false, true);
        requestLayout();
        return;
    L49:
        return;
    L5:
        if (this.mItems.size() >= r0) goto L7;
        r1 = true;
        goto L8
    }

    void populate() {
        populate(this.mCurItem);
    }

    void populate(int r18) {
        int r2 = this.mCurItem;
        if (r2 == r18) goto L5;
        b r3 = infoForPosition(r2);
        this.mCurItem = r18;
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
        this.mAdapter.a(this);
        int r1 = this.mOffscreenPageLimit;
        int r4 = Math.max(0, this.mCurItem - r1);
        int r6 = this.mAdapter.a();
        int r5 = Math.min(r6 - 1, this.mCurItem + r1);
        if (r6 != this.mExpectedAdapterCount) goto L140;
        int r7 = 0;
    L21:
        if (r7 >= this.mItems.size()) goto L28;
        b r9 = (b) ZeusTransformUtils.preCheckCast(this.mItems.get(r7), b.class, "com.obric.aiagent.plugin");
        if (r9.f2907b >= this.mCurItem) goto L25;
        r7 = r7 + 1;
        goto L21
    L25:
        if (r9.f2907b != this.mCurItem) goto L28;
    L29:
        if (r9 != null) goto L32;
        if (r6 <= 0) goto L32;
        r9 = addNewItem(this.mCurItem, r7);
    L32:
        if (r9 == null) goto L103;
        int r11 = r7 - 1;
        if (r11 < 0) goto L36;
        b r12 = (b) ZeusTransformUtils.preCheckCast(this.mItems.get(r11), b.class, "com.obric.aiagent.plugin");
    L37:
        int r13 = getClientWidth();
        if (r13 > 0) goto L40;
        float r15 = 0.0f;
    L41:
        int r8 = this.mCurItem - 1;
        float r10 = 0.0f;
    L42:
        if (r8 < 0) goto L67;
        if (r10 < r15) goto L55;
        if (r8 >= r4) goto L55;
        if (r12 == null) goto L67;
        if (r8 != r12.f2907b) goto L66;
        if (r12.f2908c == true) goto L66;
        this.mItems.remove(r11);
        this.mAdapter.a(this, r8, r12.f2906a);
        r11 = r11 - 1;
        r7 = r7 - 1;
        if (r11 < 0) goto L64;
        b r14 = (b) ZeusTransformUtils.preCheckCast(this.mItems.get(r11), b.class, "com.obric.aiagent.plugin");
    L65:
        r12 = r14;
    L64:
        r14 = null;
    L66:
        r8 = r8 - 1;
    L55:
        if (r12 != null) goto L57;
    L61:
        r10 = r10 + addNewItem(r8, r11 + 1).f2909d;
        r7 = r7 + 1;
        if (r11 < 0) goto L64;
        r14 = (b) ZeusTransformUtils.preCheckCast(this.mItems.get(r11), b.class, "com.obric.aiagent.plugin");
        goto L65
    L57:
        if (r8 != r12.f2907b) goto L61;
        r10 = r10 + r12.f2909d;
        r11 = r11 - 1;
        if (r11 < 0) goto L64;
        r14 = (b) ZeusTransformUtils.preCheckCast(this.mItems.get(r11), b.class, "com.obric.aiagent.plugin");
    L67:
        float r16 = r9.f2909d;
        int r17 = r7 + 1;
        if (r16 < 2.0f) goto L70;
    L102:
        calculatePageOffsets(r9, r7, r3);
        this.mAdapter.b(this, this.mCurItem, r9.f2906a);
        goto L103
    L70:
        if (r17 >= this.mItems.size()) goto L72;
        b r19 = (b) ZeusTransformUtils.preCheckCast(this.mItems.get(r17), b.class, "com.obric.aiagent.plugin");
    L73:
        if (r13 > 0) goto L75;
        float r110 = 0.0f;
    L76:
        int r111 = this.mCurItem;
    L77:
        r111 = r111 + 1;
        if (r111 >= r6) goto L102;
        if (r16 < r110) goto L92;
        if (r111 <= r5) goto L92;
        if (r19 == null) goto L102;
        if (r111 != r19.f2907b) goto L77;
        if (r19.f2908c == true) goto L77;
        this.mItems.remove(r17);
        this.mAdapter.a(this, r111, r19.f2906a);
        if (r17 < this.mItems.size()) goto L90;
    L91:
        r19 = null;
        goto L77
    L90:
        r19 = (b) ZeusTransformUtils.preCheckCast(this.mItems.get(r17), b.class, "com.obric.aiagent.plugin");
    L92:
        if (r19 == null) goto L98;
        if (r111 != r19.f2907b) goto L98;
        r16 = r16 + r19.f2909d;
        r17 = r17 + 1;
        if (r17 >= this.mItems.size()) goto L91;
        r19 = (b) ZeusTransformUtils.preCheckCast(this.mItems.get(r17), b.class, "com.obric.aiagent.plugin");
    L98:
        b r20 = addNewItem(r111, r17);
        r17 = r17 + 1;
        r16 = r16 + r20.f2909d;
        if (r17 >= this.mItems.size()) goto L91;
        r19 = (b) ZeusTransformUtils.preCheckCast(this.mItems.get(r17), b.class, "com.obric.aiagent.plugin");
        goto L77
    L75:
        r110 = (getPaddingRight() / r13) + 2.0f;
        goto L76
    L72:
        r19 = null;
        goto L73
    L40:
        r15 = (2.0f - r9.f2909d) + (getPaddingLeft() / r13);
        goto L41
    L36:
        r12 = null;
    L103:
        this.mAdapter.b(this);
        int r21 = getChildCount();
        int r22 = 0;
    L104:
        if (r22 >= r21) goto L114;
        View r23 = getChildAt(r22);
        LayoutParams r24 = (LayoutParams) ZeusTransformUtils.preCheckCast(r23.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        r24.childIndex = r22;
        if (r24.isDecor == true) goto L113;
        if (r24.widthFactor != 0.0f) goto L113;
        b r25 = infoForChild(r23);
        if (r25 == null) goto L113;
        r24.widthFactor = r25.f2909d;
        r24.position = r25.f2907b;
    L113:
        r22 = r22 + 1;
        goto L104
    L114:
        sortChildDrawingOrder();
        if (hasFocus() == false) goto L134;
        View r26 = findFocus();
        if (r26 == null) goto L119;
        b r27 = infoForAnyChild(r26);
    L120:
        if (r27 != null) goto L122;
    L123:
        int r28 = 0;
    L125:
        if (r28 >= getChildCount()) goto L184;
        View r29 = getChildAt(r28);
        b r30 = infoForChild(r29);
        if (r30 == null) goto L133;
        if (r30.f2907b != this.mCurItem) goto L133;
        if (r29.requestFocus(2) == false) goto L133;
        return;
    L133:
        r28 = r28 + 1;
        goto L125
    L184:
        return;
    L122:
        if (r27.f2907b != this.mCurItem) goto L123;
        return;
    L119:
        r27 = null;
        goto L120
    L134:
        return;
    L28:
        r9 = null;
        goto L29
    L140:
        String r31 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getResourceName(getId());     // Catch: Resources.NotFoundException -> L137
    L139:
        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mExpectedAdapterCount + ", found: " + r6 + " Pager id: " + r31 + " Pager class: " + getClass() + " Problematic adapter: " + this.mAdapter.getClass());
    L137:
        r31 = Integer.toHexString(getId());
        goto L139
    L5:
        r3 = null;
        goto L7
    }

    private void sortChildDrawingOrder() {
        if (this.mDrawingOrder == 0) goto L14;
        ArrayList<View> r0 = this.mDrawingOrderedChildren;
        if (r0 != null) goto L7;
        this.mDrawingOrderedChildren = new ArrayList();
    L8:
        int r1 = getChildCount();
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L11;
        View r3 = getChildAt(r2);
        this.mDrawingOrderedChildren.add(r3);
        r2 = r2 + 1;
        goto L9
    L11:
        Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        return;
    L7:
        r0.clear();
        goto L8
    }

    private void calculatePageOffsets(b r12, int r13, b r14) {
        int r0 = this.mAdapter.a();
        int r1 = getClientWidth();
        if (r1 <= 0) goto L5;
        float r2 = this.mPageMargin / r1;
    L7:
        if (r14 == null) goto L40;
        int r4 = r14.f2907b;
        if (r4 >= r12.f2907b) goto L26;
        float r5 = (r14.f2910e + r14.f2909d) + r2;
        int r6 = r4 + 1;
        int r15 = 0;
    L12:
        if (r6 > r12.f2907b) goto L40;
        if (r15 >= this.mItems.size()) goto L40;
        Object r7 = ZeusTransformUtils.preCheckCast(this.mItems.get(r15), b.class, "com.obric.aiagent.plugin");
    L16:
        b r8 = (b) r7;
        if (r6 <= r8.f2907b) goto L22;
        if (r15 >= (this.mItems.size() - 1)) goto L22;
        r15 = r15 + 1;
        r7 = ZeusTransformUtils.preCheckCast(this.mItems.get(r15), b.class, "com.obric.aiagent.plugin");
    L22:
        if (r6 >= r8.f2907b) goto L24;
        r5 = r5 + (this.mAdapter.b(r6) + r2);
        r6 = r6 + 1;
        goto L22
    L24:
        r8.f2910e = r5;
        r5 = r5 + (r8.f2909d + r2);
        r6 = r6 + 1;
        goto L12
    L26:
        if (r4 <= r12.f2907b) goto L40;
        int r9 = this.mItems.size() - 1;
        float r16 = r14.f2910e;
    L28:
        r4 = r4 - 1;
        if (r4 < r12.f2907b) goto L40;
        if (r9 < 0) goto L40;
        Object r10 = ZeusTransformUtils.preCheckCast(this.mItems.get(r9), b.class, "com.obric.aiagent.plugin");
    L32:
        b r11 = (b) r10;
        if (r4 >= r11.f2907b) goto L37;
        if (r9 <= 0) goto L37;
        r9 = r9 - 1;
        r10 = ZeusTransformUtils.preCheckCast(this.mItems.get(r9), b.class, "com.obric.aiagent.plugin");
    L37:
        if (r4 <= r11.f2907b) goto L39;
        r16 = r16 - (this.mAdapter.b(r4) + r2);
        r4 = r4 - 1;
        goto L37
    L39:
        r16 = r16 - (r11.f2909d + r2);
        r11.f2910e = r16;
    L40:
        int r17 = this.mItems.size();
        float r18 = r12.f2910e;
        int r19 = r12.f2907b - 1;
        if (r12.f2907b != 0) goto L43;
        float r20 = r12.f2910e;
    L44:
        this.mFirstOffset = r20;
        int r3 = r0 - 1;
        if (r12.f2907b != r3) goto L47;
        float r21 = (r12.f2910e + r12.f2909d) - 1.0f;
    L48:
        this.mLastOffset = r21;
        int r22 = r13 - 1;
    L49:
        if (r22 < 0) goto L58;
        b r23 = (b) ZeusTransformUtils.preCheckCast(this.mItems.get(r22), b.class, "com.obric.aiagent.plugin");
    L52:
        if (r19 <= r23.f2907b) goto L54;
        r18 = r18 - (this.mAdapter.b(r19) + r2);
        r19 = r19 - 1;
        goto L52
    L54:
        r18 = r18 - (r23.f2909d + r2);
        r23.f2910e = r18;
        if (r23.f2907b != 0) goto L57;
        this.mFirstOffset = r18;
    L57:
        r22 = r22 - 1;
        r19 = r19 - 1;
        goto L49
    L58:
        float r24 = (r12.f2910e + r12.f2909d) + r2;
        int r110 = r12.f2907b + 1;
        int r111 = r13 + 1;
    L59:
        if (r111 >= r17) goto L68;
        b r25 = (b) ZeusTransformUtils.preCheckCast(this.mItems.get(r111), b.class, "com.obric.aiagent.plugin");
    L62:
        if (r110 >= r25.f2907b) goto L65;
        r24 = r24 + (this.mAdapter.b(r110) + r2);
        r110 = r110 + 1;
        goto L62
    L65:
        if (r25.f2907b != r3) goto L67;
        this.mLastOffset = (r25.f2909d + r24) - 1.0f;
    L67:
        r25.f2910e = r24;
        r24 = r24 + (r25.f2909d + r2);
        r111 = r111 + 1;
        r110 = r110 + 1;
        goto L59
    L68:
        this.mNeedCalculatePageOffsets = false;
        return;
    L47:
        r21 = Float.MAX_VALUE;
        goto L48
    L43:
        r20 = -3.4028235E38f;
        goto L44
    L5:
        r2 = 0.0f;
        goto L7
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.position = this.mCurItem;
        androidx.viewpager.widget.a r2 = this.mAdapter;
        if (r2 == null) goto L5;
        r1.adapterState = r2.b();
    L5:
        return r1;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r4) {
        Parcelable r5 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r4, Parcelable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, SavedState.class) == true) goto L6;
        super.onRestoreInstanceState(r5);
        return;
    L6:
        SavedState r6 = (SavedState) ZeusTransformUtils.preCheckCast(r5, SavedState.class, "com.obric.aiagent.plugin");
        super.onRestoreInstanceState(r6.getSuperState());
        androidx.viewpager.widget.a r0 = this.mAdapter;
        if (r0 == null) goto L9;
        r0.a(r6.adapterState, r6.loader);
        setCurrentItemInternal(r6.position, false, true);
        return;
    L9:
        this.mRestoredCurItem = r6.position;
        this.mRestoredAdapterState = r6.adapterState;
        this.mRestoredClassLoader = r6.loader;
    }

    @Override // android.view.ViewGroup
    public void addView(View r4, int r5, ViewGroup.LayoutParams r6) {
        if (checkLayoutParams(r6) == true) goto L5;
        r6 = generateLayoutParams(r6);
    L5:
        LayoutParams r0 = (LayoutParams) ZeusTransformUtils.preCheckCast(r6, LayoutParams.class, "com.obric.aiagent.plugin");
        r0.isDecor |= isDecorView(r4);
        if (this.mInLayout == false) goto L14;
        if (r0 != null) goto L9;
    L13:
        r0.needsMeasure = true;
        addViewInLayout(r4, r5, r6);
        return;
    L9:
        if (r0.isDecor == false) goto L13;
        throw new IllegalStateException("Cannot add pager decor view during layout");
    L14:
        super.addView(r4, r5, r6);
    }

    private static boolean isDecorView(View r1) {
        if (r1.getClass().getAnnotation(a.class) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View r2) {
        if (this.mInLayout == false) goto L5;
        removeViewInLayout(r2);
        return;
    L5:
        super.removeView(r2);
    }

    b infoForChild(View r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.mItems.size()) goto L9;
        b r1 = (b) ZeusTransformUtils.preCheckCast(this.mItems.get(r0), b.class, "com.obric.aiagent.plugin");
        if (this.mAdapter.a(r5, r1.f2906a) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r1;
    L9:
        return null;
    }

    b infoForAnyChild(View r3) {
    L2:
        ViewParent r0 = r3.getParent();
        if (r0 == this) goto L12;
        if (r0 == null) goto L9;
        if (ZeusTransformUtils.instanceOf(r0, View.class) == false) goto L16;
        r3 = (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin");
        goto L2
    L16:
        return null;
    L9:
        return null;
    L12:
        return infoForChild(r3);
    }

    b infoForPosition(int r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.mItems.size()) goto L9;
        b r1 = (b) ZeusTransformUtils.preCheckCast(this.mItems.get(r0), b.class, "com.obric.aiagent.plugin");
        if (r1.f2907b == r5) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r1;
    L9:
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.View
    public void onMeasure(int r17, int r18) {
        boolean r1 = false;
        setMeasuredDimension(getDefaultSize(0, r17), getDefaultSize(0, r18));
        int r2 = getMeasuredWidth();
        this.mGutterSize = Math.min(r2 / 10, this.mDefaultGutterSize);
        int r3 = (r2 - getPaddingLeft()) - getPaddingRight();
        int r4 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int r5 = getChildCount();
        int r6 = 0;
    L3:
        boolean r8 = true;
        int r9 = 1073741824;
        if (r6 >= r5) goto L51;
        View r10 = getChildAt(r6);
        if (r10.getVisibility() == 8) goto L50;
        LayoutParams r7 = (LayoutParams) ZeusTransformUtils.preCheckCast(r10.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L50;
        if (r7.isDecor == false) goto L50;
        int r11 = r7.gravity & 7;
        int r12 = r7.gravity & 112;
        if (r12 != 48) goto L14;
    L17:
        boolean r13 = true;
    L19:
        if (r11 != 3) goto L21;
    L24:
        int r14 = Integer.MIN_VALUE;
        if (r13 == false) goto L27;
        int r15 = Integer.MIN_VALUE;
        r14 = 1073741824;
    L31:
        if (r7.width != (-2)) goto L33;
        int r16 = r14;
        int r19 = r3;
    L39:
        if (r7.height != (-2)) goto L41;
        int r20 = r4;
        r9 = r15;
    L45:
        r10.measure(View.MeasureSpec.makeMeasureSpec(r19, r16), View.MeasureSpec.makeMeasureSpec(r20, r9));
        if (r13 == false) goto L48;
        r4 = r4 - r10.getMeasuredHeight();
        goto L50
    L48:
        if (r8 == false) goto L50;
        r3 = r3 - r10.getMeasuredWidth();
        goto L50
    L41:
        if (r7.height == (-1)) goto L43;
        r20 = r7.height;
        goto L45
    L43:
        r20 = r4;
        goto L45
    L33:
        if (r7.width == (-1)) goto L35;
        r19 = r7.width;
    L36:
        r16 = 1073741824;
        goto L39
    L35:
        r19 = r3;
        goto L36
    L27:
        if (r8 == false) goto L29;
        r15 = 1073741824;
        goto L31
    L29:
        r15 = Integer.MIN_VALUE;
        goto L31
    L21:
        if (r11 == 5) goto L24;
        r8 = r1;
        goto L24
    L14:
        if (r12 == 80) goto L17;
        r13 = r1;
    L50:
        r6 = r6 + 1;
        r1 = false;
        goto L3
    L51:
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(r3, 1073741824);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(r4, 1073741824);
        this.mInLayout = true;
        populate();
        int r21 = 0;
        this.mInLayout = false;
        int r22 = getChildCount();
    L52:
        if (r21 >= r22) goto L61;
        View r23 = getChildAt(r21);
        if (r23.getVisibility() == 8) goto L60;
        LayoutParams r24 = (LayoutParams) ZeusTransformUtils.preCheckCast(r23.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (r24 != null) goto L58;
    L59:
        r23.measure(View.MeasureSpec.makeMeasureSpec((int) (r3 * r24.widthFactor), 1073741824), this.mChildHeightMeasureSpec);
        goto L60
    L58:
        if (r24.isDecor == false) goto L59;
    L60:
        r21 = r21 + 1;
        goto L52
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (r1 == r3) goto L6;
        int r5 = this.mPageMargin;
        recomputeScrollPosition(r1, r3, r5, r5);
        return;
    }

    private void recomputeScrollPosition(int r2, int r3, int r4, int r5) {
        if (r3 > 0) goto L4;
    L9:
        b r6 = infoForPosition(this.mCurItem);
        if (r6 == null) goto L12;
        float r7 = Math.min(r6.f2910e, this.mLastOffset);
    L13:
        int r8 = (int) (r7 * ((r2 - getPaddingLeft()) - getPaddingRight()));
        if (r8 == getScrollX()) goto L19;
        completeScroll(false);
        scrollTo(r8, getScrollY());
        return;
    L19:
        return;
    L12:
        r7 = 0.0f;
        goto L13
    L4:
        if (this.mItems.isEmpty() == true) goto L9;
        if (this.mScroller.isFinished() == true) goto L8;
        this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
        return;
    L8:
        scrollTo((int) ((getScrollX() / (((r3 - getPaddingLeft()) - getPaddingRight()) + r5)) * (((r2 - getPaddingLeft()) - getPaddingRight()) + r4)), getScrollY());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        int r1 = getChildCount();
        int r2 = r22 - r20;
        int r3 = r23 - r21;
        int r4 = getPaddingLeft();
        int r5 = getPaddingTop();
        int r6 = getPaddingRight();
        int r7 = getPaddingBottom();
        int r8 = getScrollX();
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r10 >= r1) goto L33;
        View r14 = getChildAt(r10);
        if (r14.getVisibility() == 8) goto L32;
        LayoutParams r12 = (LayoutParams) ZeusTransformUtils.preCheckCast(r14.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (r12.isDecor == false) goto L32;
        int r13 = r12.gravity & 7;
        int r15 = r12.gravity & 112;
        if (r13 != 1) goto L12;
        int r16 = Math.max((r2 - r14.getMeasuredWidth()) / 2, r4);
    L19:
        int r17 = r16;
        int r18 = r4;
        r4 = r17;
    L21:
        if (r15 != 16) goto L23;
        int r110 = Math.max((r3 - r14.getMeasuredHeight()) / 2, r5);
    L30:
        int r111 = r110;
        int r112 = r5;
        r5 = r111;
    L31:
        int r9 = r4 + r8;
        r14.layout(r9, r5, r14.getMeasuredWidth() + r9, r5 + r14.getMeasuredHeight());
        r11 = r11 + 1;
        r5 = r112;
        r4 = r18;
        goto L32
    L23:
        if (r15 != 48) goto L25;
        r112 = r14.getMeasuredHeight() + r5;
        goto L31
    L25:
        if (r15 == 80) goto L27;
        r112 = r5;
        goto L31
    L27:
        r110 = (r3 - r7) - r14.getMeasuredHeight();
        r7 = r7 + r14.getMeasuredHeight();
        goto L30
    L12:
        if (r13 != 3) goto L14;
        r18 = r14.getMeasuredWidth() + r4;
        goto L21
    L14:
        if (r13 == 5) goto L16;
        r18 = r4;
        goto L21
    L16:
        r16 = (r2 - r6) - r14.getMeasuredWidth();
        r6 = r6 + r14.getMeasuredWidth();
    L32:
        r10 = r10 + 1;
        goto L4
    L33:
        int r24 = (r2 - r4) - r6;
        int r25 = 0;
    L34:
        if (r25 >= r1) goto L46;
        View r26 = getChildAt(r25);
        if (r26.getVisibility() == 8) goto L45;
        LayoutParams r27 = (LayoutParams) ZeusTransformUtils.preCheckCast(r26.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (r27.isDecor == true) goto L45;
        b r113 = infoForChild(r26);
        if (r113 == null) goto L45;
        float r114 = r24;
        int r115 = ((int) (r113.f2910e * r114)) + r4;
        if (r27.needsMeasure == false) goto L44;
        r27.needsMeasure = false;
        r26.measure(View.MeasureSpec.makeMeasureSpec((int) (r114 * r27.widthFactor), 1073741824), View.MeasureSpec.makeMeasureSpec((r3 - r5) - r7, 1073741824));
    L44:
        r26.layout(r115, r5, r26.getMeasuredWidth() + r115, r26.getMeasuredHeight() + r5);
    L45:
        r25 = r25 + 1;
        goto L34
    L46:
        this.mTopPageBounds = r5;
        this.mBottomPageBounds = r3 - r7;
        this.mDecorChildCount = r11;
        if (this.mFirstLayout == false) goto L49;
        boolean r28 = false;
        scrollToItem(this.mCurItem, false, 0, false);
    L50:
        this.mFirstLayout = r28;
        return;
    L49:
        r28 = false;
        goto L50
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
        int r0 = getScrollX();
        int r1 = getScrollY();
        int r2 = this.mScroller.getCurrX();
        int r3 = this.mScroller.getCurrY();
        if (r0 != r2) goto L9;
        if (r1 != r3) goto L9;
    L12:
        ViewCompat.f(this);
        return;
    L9:
        scrollTo(r2, r3);
        if (pageScrolled(r2) == true) goto L12;
        this.mScroller.abortAnimation();
        scrollTo(0, r3);
        goto L12
    }

    private boolean pageScrolled(int r8) {
        if (this.mItems.size() == 0) goto L5;
        b r0 = infoForCurrentScrollPosition();
        int r3 = getClientWidth();
        int r4 = this.mPageMargin;
        int r5 = r3 + r4;
        float r6 = r3;
        int r7 = r0.f2907b;
        float r9 = ((r8 / r6) - r0.f2910e) / (r0.f2909d + (r4 / r6));
        this.mCalledSuper = false;
        onPageScrolled(r7, r9, (int) (r5 * r9));
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

    public void onPageScrolled(int r15, float r16, int r17) {
        int r3 = 0;
        if (this.mDecorChildCount <= 0) goto L25;
        int r1 = getScrollX();
        int r5 = getPaddingLeft();
        int r6 = getPaddingRight();
        int r7 = getWidth();
        int r8 = getChildCount();
        int r9 = 0;
    L5:
        if (r9 >= r8) goto L25;
        View r10 = getChildAt(r9);
        LayoutParams r11 = (LayoutParams) ZeusTransformUtils.preCheckCast(r10.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (r11.isDecor == false) goto L24;
        int r12 = r11.gravity & 7;
        if (r12 != 1) goto L12;
        int r13 = Math.max((r7 - r10.getMeasuredWidth()) / 2, r5);
    L19:
        int r14 = r13;
        int r18 = r5;
        r5 = r14;
    L20:
        int r19 = (r5 + r1) - r10.getLeft();
        if (r19 == 0) goto L23;
        r10.offsetLeftAndRight(r19);
    L23:
        r5 = r18;
        goto L24
    L12:
        if (r12 != 3) goto L14;
        r18 = r10.getWidth() + r5;
        goto L20
    L14:
        if (r12 == 5) goto L16;
        r18 = r5;
        goto L20
    L16:
        r13 = (r7 - r6) - r10.getMeasuredWidth();
        r6 = r6 + r10.getMeasuredWidth();
    L24:
        r9 = r9 + 1;
    L25:
        dispatchOnPageScrolled(r15, r16, r17);
        if (this.mPageTransformer == null) goto L34;
        int r2 = getScrollX();
        int r20 = getChildCount();
    L28:
        if (r3 >= r20) goto L34;
        View r21 = getChildAt(r3);
        if (((LayoutParams) ZeusTransformUtils.preCheckCast(r21.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).isDecor == true) goto L33;
        this.mPageTransformer.a(r21, (r21.getLeft() - r2) / getClientWidth());
    L33:
        r3 = r3 + 1;
    L34:
        this.mCalledSuper = true;
    }

    private void dispatchOnPageScrolled(int r6, float r7, int r8) {
        e r0 = this.mOnPageChangeListener;
        if (r0 == null) goto L5;
        r0.onPageScrolled(r6, r7, r8);
    L5:
        List<e> r1 = this.mOnPageChangeListeners;
        if (r1 == null) goto L13;
        int r2 = 0;
        int r3 = r1.size();
    L8:
        if (r2 >= r3) goto L13;
        e r4 = (e) ZeusTransformUtils.preCheckCast(this.mOnPageChangeListeners.get(r2), e.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L12;
        r4.onPageScrolled(r6, r7, r8);
    L12:
        r2 = r2 + 1;
    L13:
        e r5 = this.mInternalPageChangeListener;
        if (r5 == null) goto L20;
        r5.onPageScrolled(r6, r7, r8);
        return;
    }

    private void dispatchOnPageSelected(int r6) {
        e r0 = this.mOnPageChangeListener;
        if (r0 == null) goto L5;
        r0.onPageSelected(r6);
    L5:
        List<e> r1 = this.mOnPageChangeListeners;
        if (r1 == null) goto L13;
        int r2 = 0;
        int r3 = r1.size();
    L8:
        if (r2 >= r3) goto L13;
        e r4 = (e) ZeusTransformUtils.preCheckCast(this.mOnPageChangeListeners.get(r2), e.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L12;
        r4.onPageSelected(r6);
    L12:
        r2 = r2 + 1;
    L13:
        e r5 = this.mInternalPageChangeListener;
        if (r5 == null) goto L20;
        r5.onPageSelected(r6);
        return;
    }

    private void dispatchOnScrollStateChanged(int r6) {
        e r0 = this.mOnPageChangeListener;
        if (r0 == null) goto L5;
        r0.onPageScrollStateChanged(r6);
    L5:
        List<e> r1 = this.mOnPageChangeListeners;
        if (r1 == null) goto L13;
        int r2 = 0;
        int r3 = r1.size();
    L8:
        if (r2 >= r3) goto L13;
        e r4 = (e) ZeusTransformUtils.preCheckCast(this.mOnPageChangeListeners.get(r2), e.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L12;
        r4.onPageScrollStateChanged(r6);
    L12:
        r2 = r2 + 1;
    L13:
        e r5 = this.mInternalPageChangeListener;
        if (r5 == null) goto L20;
        r5.onPageScrollStateChanged(r6);
        return;
    }

    private void completeScroll(boolean r8) {
        if (this.mScrollState != 2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L15;
        setScrollingCacheEnabled(false);
        if ((!this.mScroller.isFinished()) == false) goto L15;
        this.mScroller.abortAnimation();
        int r3 = getScrollX();
        int r4 = getScrollY();
        int r5 = this.mScroller.getCurrX();
        int r6 = this.mScroller.getCurrY();
        if (r3 != r5) goto L12;
        if (r4 == r6) goto L15;
    L12:
        scrollTo(r5, r6);
        if (r5 == r3) goto L15;
        pageScrolled(r5);
    L15:
        this.mPopulatePending = false;
        int r7 = 0;
    L17:
        if (r7 >= this.mItems.size()) goto L22;
        b r9 = (b) ZeusTransformUtils.preCheckCast(this.mItems.get(r7), b.class, "com.obric.aiagent.plugin");
        if (r9.f2908c == false) goto L21;
        r9.f2908c = false;
        r0 = true;
    L21:
        r7 = r7 + 1;
        goto L17
    L22:
        if (r0 == false) goto L30;
        if (r8 == false) goto L25;
        ViewCompat.a(this, this.mEndScrollRunnable);
        return;
    L25:
        this.mEndScrollRunnable.run();
        return;
    L30:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private boolean isGutterDrag(float r3, float r4) {
        if (r3 >= this.mGutterSize) goto L7;
        if (r4 <= 0.0f) goto L7;
    L10:
        return true;
    L7:
        if (r3 > (getWidth() - this.mGutterSize)) goto L9;
    L11:
        return false;
    L9:
        if (r4 >= 0.0f) goto L11;
        goto L10
    }

    private void enableLayers(boolean r7) {
        int r0 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (r7 == false) goto L6;
        int r3 = this.mPageTransformerLayerType;
    L7:
        getChildAt(r2).setLayerType(r3, null);
        r2 = r2 + 1;
        goto L3
    L6:
        r3 = 0;
        goto L7
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r16) {
        int r0 = r16.getAction() & 255;
        if (r0 != 3) goto L5;
    L60:
        resetTouch();
        return false;
    L5:
        if (r0 == 1) goto L60;
        if (r0 == 0) goto L15;
        if (this.mIsBeingDragged == false) goto L12;
        return true;
    L12:
        if (this.mIsUnableToDrag == false) goto L15;
        return false;
    L15:
        if (r0 == 0) goto L49;
        if (r0 != 2) goto L18;
        int r1 = this.mActivePointerId;
        if (r1 == (-1)) goto L56;
        int r2 = r16.findPointerIndex(r1);
        float r10 = r16.getX(r2);
        float r3 = r10 - this.mLastMotionX;
        float r11 = Math.abs(r3);
        float r12 = r16.getY(r2);
        float r13 = Math.abs(r12 - this.mInitialMotionY);
        if (r3 != 0.0f) goto L27;
    L32:
        int r4 = this.mTouchSlop;
        if (r11 <= r4) goto L42;
        if ((r11 * 0.5f) <= r13) goto L42;
        this.mIsBeingDragged = true;
        requestParentDisallowInterceptTouchEvent(true);
        setScrollState(1);
        float r5 = this.mInitialMotionX;
        float r6 = this.mTouchSlop;
        if (r3 <= 0.0f) goto L39;
        float r7 = r5 + r6;
    L40:
        this.mLastMotionX = r7;
        this.mLastMotionY = r12;
        setScrollingCacheEnabled(true);
    L45:
        if (this.mIsBeingDragged == false) goto L56;
        if (performDrag(r10) == false) goto L56;
        ViewCompat.f(this);
        goto L56
    L39:
        r7 = r5 - r6;
    L42:
        if (r13 <= r4) goto L45;
        this.mIsUnableToDrag = true;
        goto L45
    L27:
        if (isGutterDrag(this.mLastMotionX, r3) == true) goto L32;
        if (canScroll(this, false, (int) r3, (int) r10, (int) r12) == false) goto L32;
        this.mLastMotionX = r10;
        this.mLastMotionY = r12;
        this.mIsUnableToDrag = true;
        return false;
    L56:
        if (this.mVelocityTracker != null) goto L58;
        this.mVelocityTracker = VelocityTracker.obtain();
    L58:
        this.mVelocityTracker.addMovement(r16);
        return this.mIsBeingDragged;
    L18:
        if (r0 != 6) goto L56;
        onSecondaryPointerUp(r16);
        goto L56
    L49:
        float r8 = r16.getX();
        this.mInitialMotionX = r8;
        this.mLastMotionX = r8;
        float r9 = r16.getY();
        this.mInitialMotionY = r9;
        this.mLastMotionY = r9;
        this.mActivePointerId = r16.getPointerId(0);
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
    public boolean onTouchEvent(MotionEvent r8) {
        if (this.mFakeDragging == false) goto L5;
        return true;
    L5:
        boolean r2 = false;
        if (r8.getAction() == 0) goto L8;
    L10:
        androidx.viewpager.widget.a r0 = this.mAdapter;
        if (r0 != null) goto L13;
    L61:
        return false;
    L13:
        if (r0.a() == 0) goto L61;
        if (this.mVelocityTracker != null) goto L18;
        this.mVelocityTracker = VelocityTracker.obtain();
    L18:
        this.mVelocityTracker.addMovement(r8);
        int r1 = r8.getAction() & 255;
        if (r1 == 0) goto L57;
        if (r1 == 1) goto L55;
        if (r1 == 2) goto L36;
        if (r1 == 3) goto L33;
        if (r1 != 5) goto L28;
        int r3 = r8.getActionIndex();
        this.mLastMotionX = r8.getX(r3);
        this.mActivePointerId = r8.getPointerId(r3);
    L58:
        if (r2 == false) goto L60;
        ViewCompat.f(this);
    L60:
        return true;
    L28:
        if (r1 != 6) goto L58;
        onSecondaryPointerUp(r8);
        this.mLastMotionX = r8.getX(r8.findPointerIndex(this.mActivePointerId));
        goto L58
    L33:
        if (this.mIsBeingDragged == false) goto L58;
        scrollToItem(this.mCurItem, true, 0, false);
        r2 = resetTouch();
        goto L58
    L36:
        if (this.mIsBeingDragged == true) goto L52;
        int r4 = r8.findPointerIndex(this.mActivePointerId);
        if (r4 != (-1)) goto L40;
        r2 = resetTouch();
        goto L58
    L40:
        float r5 = r8.getX(r4);
        float r6 = Math.abs(r5 - this.mLastMotionX);
        float r7 = r8.getY(r4);
        float r9 = Math.abs(r7 - this.mLastMotionY);
        if (r6 <= this.mTouchSlop) goto L52;
        if (r6 <= r9) goto L52;
        this.mIsBeingDragged = true;
        requestParentDisallowInterceptTouchEvent(true);
        float r10 = this.mInitialMotionX;
        if ((r5 - r10) <= 0.0f) goto L47;
        float r11 = r10 + this.mTouchSlop;
    L48:
        this.mLastMotionX = r11;
        this.mLastMotionY = r7;
        setScrollState(1);
        setScrollingCacheEnabled(true);
        ViewParent r12 = getParent();
        if (r12 == null) goto L52;
        r12.requestDisallowInterceptTouchEvent(true);
        goto L52
    L47:
        r11 = r10 - this.mTouchSlop;
    L52:
        if (this.mIsBeingDragged == false) goto L58;
        r2 = false | performDrag(r8.getX(r8.findPointerIndex(this.mActivePointerId)));
        goto L58
    L55:
        if (this.mIsBeingDragged == false) goto L58;
        VelocityTracker r13 = this.mVelocityTracker;
        r13.computeCurrentVelocity(1000, this.mMaximumVelocity);
        int r14 = (int) r13.getXVelocity(this.mActivePointerId);
        this.mPopulatePending = true;
        int r15 = getClientWidth();
        int r16 = getScrollX();
        b r17 = infoForCurrentScrollPosition();
        float r18 = r15;
        setCurrentItemInternal(determineTargetPage(r17.f2907b, ((r16 / r18) - r17.f2910e) / (r17.f2909d + (this.mPageMargin / r18)), r14, (int) (r8.getX(r8.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX)), true, true, r14);
        r2 = resetTouch();
        goto L58
    L57:
        this.mScroller.abortAnimation();
        this.mPopulatePending = false;
        populate();
        float r19 = r8.getX();
        this.mInitialMotionX = r19;
        this.mLastMotionX = r19;
        float r20 = r8.getY();
        this.mInitialMotionY = r20;
        this.mLastMotionY = r20;
        this.mActivePointerId = r8.getPointerId(0);
        goto L58
    L8:
        if (r8.getEdgeFlags() == 0) goto L10;
        return false;
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

    private void requestParentDisallowInterceptTouchEvent(boolean r1) {
        ViewParent r0 = getParent();
        if (r0 == null) goto L6;
        r0.requestDisallowInterceptTouchEvent(r1);
        return;
    }

    private boolean performDrag(float r10) {
        float r0 = this.mLastMotionX - r10;
        this.mLastMotionX = r10;
        float r11 = getScrollX() + r0;
        float r1 = getClientWidth();
        float r2 = this.mFirstOffset * r1;
        float r3 = this.mLastOffset * r1;
        boolean r4 = false;
        b r5 = (b) ZeusTransformUtils.preCheckCast(this.mItems.get(0), b.class, "com.obric.aiagent.plugin");
        ArrayList<b> r6 = this.mItems;
        b r7 = (b) ZeusTransformUtils.preCheckCast(r6.get(r6.size() - 1), b.class, "com.obric.aiagent.plugin");
        if (r5.f2907b == 0) goto L5;
        r2 = r5.f2910e * r1;
        boolean r8 = false;
    L7:
        if (r7.f2907b == (this.mAdapter.a() - 1)) goto L9;
        r3 = r7.f2910e * r1;
        boolean r9 = false;
    L11:
        if (r11 >= r2) goto L16;
        if (r8 == false) goto L14;
        this.mLeftEdge.onPull(Math.abs(r2 - r11) / r1);
        r4 = true;
    L14:
        r11 = r2;
    L20:
        int r12 = (int) r11;
        this.mLastMotionX += r11 - r12;
        scrollTo(r12, getScrollY());
        pageScrolled(r12);
        return r4;
    L16:
        if (r11 <= r3) goto L20;
        if (r9 == false) goto L19;
        this.mRightEdge.onPull(Math.abs(r11 - r3) / r1);
        r4 = true;
    L19:
        r11 = r3;
        goto L20
    L9:
        r9 = true;
        goto L11
    L5:
        r8 = true;
        goto L7
    }

    private b infoForCurrentScrollPosition() {
        int r0 = getClientWidth();
        float r1 = 0.0f;
        if (r0 <= 0) goto L5;
        float r2 = getScrollX() / r0;
    L6:
        if (r0 <= 0) goto L8;
        float r3 = this.mPageMargin / r0;
    L9:
        b r4 = null;
        int r8 = 0;
        int r7 = -1;
        boolean r9 = true;
        float r5 = 0.0f;
    L11:
        if (r8 >= this.mItems.size()) goto L30;
        b r10 = (b) ZeusTransformUtils.preCheckCast(this.mItems.get(r8), b.class, "com.obric.aiagent.plugin");
        if (r9 == true) goto L17;
        int r11 = r7 + 1;
        if (r10.f2907b == r11) goto L17;
        r10 = this.mTempItem;
        r10.f2910e = (r1 + r5) + r3;
        r10.f2907b = r11;
        r10.f2909d = this.mAdapter.b(r10.f2907b);
        r8 = r8 - 1;
    L17:
        r1 = r10.f2910e;
        float r6 = (r10.f2909d + r1) + r3;
        if (r9 == true) goto L24;
        if (r2 >= r1) goto L24;
        return r4;
    L24:
        if (r2 < r6) goto L29;
        if (r8 == (this.mItems.size() - 1)) goto L29;
        r7 = r10.f2907b;
        r5 = r10.f2909d;
        r8 = r8 + 1;
        r9 = false;
        r4 = r10;
    L29:
        return r10;
    L30:
        return r4;
    L8:
        r3 = 0.0f;
        goto L9
    L5:
        r2 = 0.0f;
        goto L6
    }

    private int determineTargetPage(int r2, float r3, int r4, int r5) {
        if (Math.abs(r5) <= this.mFlingDistance) goto L10;
        if (Math.abs(r4) <= this.mMinimumVelocity) goto L10;
        if (r4 > 0) goto L15;
        r2 = r2 + 1;
    L15:
        if (this.mItems.size() <= 0) goto L18;
        b r6 = (b) ZeusTransformUtils.preCheckCast(this.mItems.get(0), b.class, "com.obric.aiagent.plugin");
        ArrayList<b> r1 = this.mItems;
        return Math.max(r6.f2907b, Math.min(r2, ((b) ZeusTransformUtils.preCheckCast(r1.get(r1.size() - 1), b.class, "com.obric.aiagent.plugin")).f2907b));
    L18:
        return r2;
    L10:
        if (r2 < this.mCurItem) goto L12;
        float r7 = 0.4f;
    L13:
        r2 = r2 + ((int) (r3 + r7));
        goto L15
    L12:
        r7 = 0.6f;
        goto L13
    }

    @Override // android.view.View
    public void draw(Canvas r8) {
        super.draw(r8);
        int r0 = getOverScrollMode();
        boolean r1 = false;
        if (r0 == 0) goto L13;
        if (r0 != 1) goto L11;
        androidx.viewpager.widget.a r2 = this.mAdapter;
        if (r2 == null) goto L11;
        if (r2.a() > 1) goto L13;
    L11:
        this.mLeftEdge.finish();
        this.mRightEdge.finish();
    L18:
        if (r1 == false) goto L21;
        ViewCompat.f(this);
        return;
    L21:
        return;
    L13:
        if (this.mLeftEdge.isFinished() == true) goto L16;
        int r3 = r8.save();
        int r4 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r5 = getWidth();
        r8.rotate(270.0f);
        r8.translate((-r4) + getPaddingTop(), this.mFirstOffset * r5);
        this.mLeftEdge.setSize(r4, r5);
        r1 = false | this.mLeftEdge.draw(r8);
        r8.restoreToCount(r3);
    L16:
        if (this.mRightEdge.isFinished() == true) goto L18;
        int r6 = r8.save();
        int r7 = getWidth();
        int r9 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        r8.rotate(90.0f);
        r8.translate(-getPaddingTop(), (-(this.mLastOffset + 1.0f)) * r7);
        this.mRightEdge.setSize(r9, r7);
        r1 = r1 | this.mRightEdge.draw(r8);
        r8.restoreToCount(r6);
        goto L18
    }

    @Override // android.view.View
    public void onDraw(Canvas r19) {
        super.onDraw(r19);
        if (this.mPageMargin > 0) goto L5;
        return;
    L5:
        if (this.mMarginDrawable != null) goto L7;
        return;
    L7:
        if (this.mItems.size() > 0) goto L9;
        return;
    L9:
        if (this.mAdapter == null) goto L35;
        int r1 = getScrollX();
        int r2 = getWidth();
        float r4 = r2;
        float r3 = this.mPageMargin / r4;
        int r6 = 0;
        b r5 = (b) ZeusTransformUtils.preCheckCast(this.mItems.get(0), b.class, "com.obric.aiagent.plugin");
        float r7 = r5.f2910e;
        int r9 = this.mItems.size();
        int r10 = r5.f2907b;
        int r11 = ((b) ZeusTransformUtils.preCheckCast(this.mItems.get(r9 - 1), b.class, "com.obric.aiagent.plugin")).f2907b;
    L11:
        if (r10 >= r11) goto L36;
    L13:
        if (r10 <= r5.f2907b) goto L17;
        if (r6 >= r9) goto L17;
        r6 = r6 + 1;
        r5 = (b) ZeusTransformUtils.preCheckCast(this.mItems.get(r6), b.class, "com.obric.aiagent.plugin");
    L17:
        if (r10 != r5.f2907b) goto L19;
        float r8 = (r5.f2910e + r5.f2909d) * r4;
        float r12 = (r5.f2910e + r5.f2909d) + r3;
    L21:
        if ((this.mPageMargin + r8) <= r1) goto L25;
        this.mMarginDrawable.setBounds(Math.round(r8), this.mTopPageBounds, Math.round(this.mPageMargin + r8), this.mBottomPageBounds);
        this.mMarginDrawable.draw(r19);
    L25:
        if (r8 > (r1 + r2)) goto L37;
        r10 = r10 + 1;
        r7 = r12;
        r3 = r3;
        r4 = r4;
        goto L11
    L37:
        return;
    L19:
        float r13 = this.mAdapter.b(r10);
        float r14 = (r7 + r13) * r4;
        r12 = r7 + (r13 + r3);
        r8 = r14;
        goto L21
    L36:
        return;
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged == false) goto L6;
        return false;
    L6:
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        VelocityTracker r1 = this.mVelocityTracker;
        if (r1 != null) goto L9;
        this.mVelocityTracker = VelocityTracker.obtain();
    L10:
        long r10 = SystemClock.uptimeMillis();
        MotionEvent r2 = MotionEvent.obtain(r10, r10, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(r2);
        r2.recycle();
        this.mFakeDragBeginTime = r10;
        return true;
    L9:
        r1.clear();
        goto L10
    }

    public void endFakeDrag() {
        if (this.mFakeDragging == false) goto L10;
        if (this.mAdapter == null) goto L7;
        VelocityTracker r0 = this.mVelocityTracker;
        r0.computeCurrentVelocity(1000, this.mMaximumVelocity);
        int r1 = (int) r0.getXVelocity(this.mActivePointerId);
        this.mPopulatePending = true;
        int r2 = getClientWidth();
        int r3 = getScrollX();
        b r4 = infoForCurrentScrollPosition();
        setCurrentItemInternal(determineTargetPage(r4.f2907b, ((r3 / r2) - r4.f2910e) / r4.f2909d, r1, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, r1);
    L7:
        endDrag();
        this.mFakeDragging = false;
        return;
    L10:
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public void fakeDragBy(float r11) {
        if (this.mFakeDragging == false) goto L22;
        if (this.mAdapter != null) goto L7;
        return;
    L7:
        this.mLastMotionX += r11;
        float r0 = getScrollX() - r11;
        float r12 = getClientWidth();
        float r1 = this.mFirstOffset * r12;
        float r2 = this.mLastOffset * r12;
        b r3 = (b) ZeusTransformUtils.preCheckCast(this.mItems.get(0), b.class, "com.obric.aiagent.plugin");
        ArrayList<b> r4 = this.mItems;
        b r5 = (b) ZeusTransformUtils.preCheckCast(r4.get(r4.size() - 1), b.class, "com.obric.aiagent.plugin");
        if (r3.f2907b == 0) goto L11;
        r1 = r3.f2910e * r12;
    L11:
        if (r5.f2907b == (this.mAdapter.a() - 1)) goto L14;
        r2 = r5.f2910e * r12;
    L14:
        if (r0 >= r1) goto L17;
        r0 = r1;
    L19:
        int r6 = (int) r0;
        this.mLastMotionX += r0 - r6;
        scrollTo(r6, getScrollY());
        pageScrolled(r6);
        MotionEvent r13 = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0.0f, 0);
        this.mVelocityTracker.addMovement(r13);
        r13.recycle();
        return;
    L17:
        if (r0 <= r2) goto L19;
        r0 = r2;
        goto L19
    L22:
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    private void onSecondaryPointerUp(MotionEvent r4) {
        int r0 = r4.getActionIndex();
        if (r4.getPointerId(r0) != this.mActivePointerId) goto L11;
        if (r0 != 0) goto L6;
        int r1 = 1;
    L7:
        this.mLastMotionX = r4.getX(r1);
        this.mActivePointerId = r4.getPointerId(r1);
        VelocityTracker r3 = this.mVelocityTracker;
        if (r3 == null) goto L12;
        r3.clear();
        return;
    L12:
        return;
    L6:
        r1 = 0;
        goto L7
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker r0 = this.mVelocityTracker;
        if (r0 == null) goto L6;
        r0.recycle();
        this.mVelocityTracker = null;
        return;
    }

    private void setScrollingCacheEnabled(boolean r2) {
        if (this.mScrollingCacheEnabled == r2) goto L6;
        this.mScrollingCacheEnabled = r2;
        return;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int r5) {
        if (this.mAdapter != null) goto L5;
        return false;
    L5:
        int r0 = getClientWidth();
        int r2 = getScrollX();
        if (r5 < 0) goto L8;
        if (r5 > 0) goto L13;
        return false;
    L13:
        if (r2 < ((int) (r0 * this.mLastOffset))) goto L15;
        return false;
    L15:
        return true;
    L8:
        if (r2 > ((int) (r0 * this.mFirstOffset))) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean canScroll(View r13, boolean r14, int r15, int r16, int r17) {
        if (ZeusTransformUtils.instanceOf(r13, ViewGroup.class) == false) goto L18;
        ViewGroup r1 = (ViewGroup) ZeusTransformUtils.preCheckCast(r13, ViewGroup.class, "com.obric.aiagent.plugin");
        int r3 = r13.getScrollX();
        int r4 = r13.getScrollY();
        int r5 = r1.getChildCount() - 1;
    L5:
        if (r5 < 0) goto L18;
        View r7 = r1.getChildAt(r5);
        int r6 = r16 + r3;
        if (r6 < r7.getLeft()) goto L17;
        if (r6 >= r7.getRight()) goto L17;
        int r8 = r17 + r4;
        if (r8 < r7.getTop()) goto L17;
        if (r8 >= r7.getBottom()) goto L17;
        if (canScroll(r7, true, r15, r6 - r7.getLeft(), r8 - r7.getTop()) == false) goto L17;
        return true;
    L17:
        r5 = r5 - 1;
    L18:
        if (r14 == true) goto L20;
    L22:
        return false;
    L20:
        if (r13.canScrollHorizontally(-r15) == false) goto L22;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent r2) {
        if (super.dispatchKeyEvent(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (executeKeyEvent(r2) == true) goto L8;
        return false;
    }

    public boolean executeKeyEvent(KeyEvent r4) {
        if (r4.getAction() != 0) goto L25;
        int r0 = r4.getKeyCode();
        if (r0 == 21) goto L22;
        if (r0 == 22) goto L18;
        if (r0 != 61) goto L25;
        if (r4.hasNoModifiers() == false) goto L15;
        return arrowScroll(2);
    L15:
        if (r4.hasModifiers(1) == false) goto L25;
        return arrowScroll(1);
    L18:
        if (r4.hasModifiers(2) == false) goto L30;
        return pageRight();
    L30:
        return arrowScroll(66);
    L22:
        if (r4.hasModifiers(2) == false) goto L32;
        return pageLeft();
    L32:
        return arrowScroll(17);
    L25:
        return false;
    }

    public boolean arrowScroll(int r8) {
        View r0 = findFocus();
        boolean r2 = false;
        if (r0 != this) goto L5;
    L4:
        r0 = null;
    L19:
        View r3 = FocusFinder.getInstance().findNextFocus(this, r0, r8);
        if (r3 == null) goto L35;
        if (r3 == r0) goto L35;
        if (r8 != 17) goto L29;
        int r1 = getChildRectInPagerCoordinates(this.mTempRect, r3).left;
        int r4 = getChildRectInPagerCoordinates(this.mTempRect, r0).left;
        if (r0 == null) goto L27;
        if (r1 < r4) goto L27;
        boolean r5 = pageLeft();
    L28:
        r2 = r5;
    L43:
        if (r2 == false) goto L45;
        playSoundEffect(SoundEffectConstants.getContantForFocusDirection(r8));
    L45:
        return r2;
    L27:
        r5 = r3.requestFocus();
        goto L28
    L29:
        if (r8 != 66) goto L43;
        int r6 = getChildRectInPagerCoordinates(this.mTempRect, r3).left;
        int r7 = getChildRectInPagerCoordinates(this.mTempRect, r0).left;
        if (r0 == null) goto L34;
        if (r6 > r7) goto L34;
        r5 = pageRight();
    L34:
        r5 = r3.requestFocus();
    L35:
        if (r8 == 17) goto L42;
        if (r8 == 1) goto L42;
        if (r8 != 66) goto L40;
    L41:
        r2 = pageRight();
        goto L43
    L40:
        if (r8 != 2) goto L43;
    L42:
        r2 = pageLeft();
        goto L43
    L5:
        if (r0 == null) goto L19;
        ViewParent r9 = r0.getParent();
    L8:
        if (ZeusTransformUtils.instanceOf(r9, ViewGroup.class) == false) goto L12;
        if (r9 == this) goto L10;
        r9 = r9.getParent();
        goto L8
    L10:
        boolean r10 = true;
    L13:
        if (r10 == true) goto L19;
        StringBuilder r11 = new StringBuilder();
        r11.append(r0.getClass().getSimpleName());
        ViewParent r12 = r0.getParent();
    L16:
        if (ZeusTransformUtils.instanceOf(r12, ViewGroup.class) == false) goto L18;
        r11.append(" => ").append(r12.getClass().getSimpleName());
        r12 = r12.getParent();
        goto L16
    L18:
        INVOKESTATIC_androidx_viewpager_widget_ViewPager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "arrowScroll tried to find focus based on non-child current focused view " + r11.toString());
        goto L4
    L12:
        r10 = false;
        goto L13
    }

    private Rect getChildRectInPagerCoordinates(Rect r3, View r4) {
        if (r3 != null) goto L4;
        r3 = new Rect();
    L4:
        if (r4 != null) goto L7;
        r3.set(0, 0, 0, 0);
        return r3;
    L7:
        r3.left = r4.getLeft();
        r3.right = r4.getRight();
        r3.top = r4.getTop();
        r3.bottom = r4.getBottom();
        ViewParent r5 = r4.getParent();
    L9:
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.class) == false) goto L12;
        if (r5 == this) goto L12;
        ViewGroup r6 = (ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.aiagent.plugin");
        r3.left += r6.getLeft();
        r3.right += r6.getRight();
        r3.top += r6.getTop();
        r3.bottom += r6.getBottom();
        r5 = r6.getParent();
    L12:
        return r3;
    }

    boolean pageLeft() {
        int r0 = this.mCurItem;
        if (r0 <= 0) goto L6;
        setCurrentItem(r0 - 1, true);
        return true;
    L6:
        return false;
    }

    boolean pageRight() {
        androidx.viewpager.widget.a r0 = this.mAdapter;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (this.mCurItem >= (r0.a() - 1)) goto L10;
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    L10:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> r7, int r8, int r9) {
        int r0 = r7.size();
        int r1 = getDescendantFocusability();
        if (r1 == 393216) goto L16;
        int r2 = 0;
    L6:
        if (r2 >= getChildCount()) goto L16;
        View r3 = getChildAt(r2);
        if (r3.getVisibility() != 0) goto L14;
        b r4 = infoForChild(r3);
        if (r4 == null) goto L14;
        if (r4.f2907b != this.mCurItem) goto L14;
        r3.addFocusables(r7, r8, r9);
    L14:
        r2 = r2 + 1;
    L16:
        if (r1 != 262144) goto L20;
        if (r0 == r7.size()) goto L20;
        return;
    L20:
        if (isFocusable() == true) goto L23;
        return;
    L23:
        if ((r9 & 1) == 1) goto L25;
    L29:
        if (r7 == null) goto L38;
        r7.add(this);
        return;
    L38:
        return;
    L25:
        if (isInTouchMode() == false) goto L29;
        if (isFocusableInTouchMode() == true) goto L29;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> r5) {
        int r0 = 0;
    L4:
        if (r0 >= getChildCount()) goto L13;
        View r1 = getChildAt(r0);
        if (r1.getVisibility() != 0) goto L12;
        b r2 = infoForChild(r1);
        if (r2 == null) goto L12;
        if (r2.f2907b != this.mCurItem) goto L12;
        r1.addTouchables(r5);
    L12:
        r0 = r0 + 1;
        goto L4
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int r9, Rect r10) {
        int r0 = getChildCount();
        int r3 = -1;
        if ((r9 & 2) == 0) goto L5;
        r3 = r0;
        int r1 = 0;
        int r2 = 1;
    L6:
        if (r1 == r3) goto L17;
        View r5 = getChildAt(r1);
        if (r5.getVisibility() != 0) goto L16;
        b r6 = infoForChild(r5);
        if (r6 == null) goto L16;
        if (r6.f2907b != this.mCurItem) goto L16;
        if (r5.requestFocus(r9, r10) == false) goto L16;
        return true;
    L16:
        r1 = r1 + r2;
        goto L6
    L17:
        return false;
    L5:
        r1 = r0 - 1;
        r2 = -1;
        goto L6
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r7) {
        if (r7.getEventType() == 4096) goto L5;
        int r0 = getChildCount();
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L19;
        View r3 = getChildAt(r2);
        if (r3.getVisibility() != 0) goto L18;
        b r4 = infoForChild(r3);
        if (r4 == null) goto L18;
        if (r4.f2907b != this.mCurItem) goto L18;
        if (r3.dispatchPopulateAccessibilityEvent(r7) == false) goto L18;
        return true;
    L18:
        r2 = r2 + 1;
        goto L7
    L19:
        return false;
    L5:
        return super.dispatchPopulateAccessibilityEvent(r7);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r2) {
        if (ZeusTransformUtils.instanceOf(r2, LayoutParams.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (super.checkLayoutParams(r2) == false) goto L7;
        return true;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r4) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        return new LayoutParams((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_androidx_viewpager_widget_ViewPager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_androidx_viewpager_widget_ViewPager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
