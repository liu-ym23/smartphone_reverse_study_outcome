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
import androidx.annotation.CallSuper;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import com.google.common.primitives.Ints;
import com.obric.capabilitykit.common.UiType;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f5141a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5142b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f5143c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f5144d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f5145e;

        public ItemInfo() {
        }
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f5146a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5147b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f5148c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f5149d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f5150e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f5151f;

        public LayoutParams() {
            super(-1, -1);
            this.f5148c = 0.0f;
        }

        public LayoutParams(Context r10, AttributeSet r11) {
            super(r10, r11);
            this.f5148c = 0.0f;
            TypedArray r12 = r10.obtainStyledAttributes(r11, ViewPager.LAYOUT_ATTRS);
            this.f5147b = r12.getInteger(0, 48);
            r12.recycle();
        }
    }

    public interface OnAdapterChangeListener {
        void onAdapterChanged(@NonNull ViewPager r10, @Nullable PagerAdapter r11, @Nullable PagerAdapter r12);
    }

    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int r10);

        void onPageScrolled(int r10, float r11, @Px int r12);

        void onPageSelected(int r10);
    }

    public interface PageTransformer {
        void transformPage(@NonNull View r10, float r11);
    }

    public class PagerObserver extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewPager f5152a;

        public PagerObserver(ViewPager r10) {
            this.f5152a = r10;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            this.f5152a.dataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            this.f5152a.dataSetChanged();
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        Parcelable adapterState;
        ClassLoader loader;
        int position;

        public static class a implements Parcelable.ClassLoaderCreator {
            public a() {
            }

            public SavedState a(Parcel r10) {
                return new SavedState(r10, null);
            }

            public SavedState b(Parcel r10, ClassLoader r11) {
                return new SavedState(r10, r11);
            }

            public SavedState[] c(int r10) {
                return new SavedState[r10];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
                return c(r10);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10, ClassLoader r11) {
                return b(r10, r11);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(@NonNull Parcelable r10) {
            super(r10);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeInt(this.position);
            r10.writeParcelable(this.adapterState, r11);
        }

        public SavedState(Parcel r10, ClassLoader r11) {
            super(r10, r11);
            if (r11 != null) goto L5;
            r11 = getClass().getClassLoader();
        L5:
            this.position = r10.readInt();
            this.adapterState = r10.readParcelable(r11);
            this.loader = r11;
        }
    }

    public static class ViewPositionComparator implements Comparator {
        public ViewPositionComparator() {
        }

        public int a(View r10, View r11) {
            LayoutParams r12 = (LayoutParams) r10.getLayoutParams();
            LayoutParams r13 = (LayoutParams) r11.getLayoutParams();
            boolean r14 = r12.f5146a;
            if (r14 == r13.f5146a) goto L9;
            if (r14 == false) goto L6;
            return 1;
        L6:
            return -1;
        L9:
            return r12.f5150e - r13.f5150e;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((View) r10, (View) r11);
        }
    }

    public static class a implements Comparator {
        public a() {
        }

        public int a(ItemInfo r10, ItemInfo r11) {
            return r10.f5142b - r11.f5142b;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((ItemInfo) r10, (ItemInfo) r11);
        }
    }

    public static class b implements Interpolator {
        public b() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float r10) {
            float r11 = r10 - 1.0f;
            return ((((r11 * r11) * r11) * r11) * r11) + 1.0f;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewPager f5153a;

        public c(ViewPager r10) {
            this.f5153a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5153a.setScrollState(0);
            this.f5153a.populate();
        }
    }

    public class d implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f5154a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPager f5155b;

        public d(ViewPager r10) {
            this.f5155b = r10;
            this.f5154a = new Rect();
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View r10, WindowInsetsCompat r11) {
            WindowInsetsCompat r12 = ViewCompat.b0(r10, r11);
            if (r12.r() == false) goto L5;
            return r12;
        L5:
            Rect r13 = this.f5154a;
            r13.left = r12.k();
            r13.top = r12.m();
            r13.right = r12.l();
            r13.bottom = r12.j();
            int r14 = this.f5155b.getChildCount();
            int r15 = 0;
        L6:
            if (r15 >= r14) goto L9;
            WindowInsetsCompat r16 = ViewCompat.h(this.f5155b.getChildAt(r15), r12);
            r13.left = Math.min(r16.k(), r13.left);
            r13.top = Math.min(r16.m(), r13.top);
            r13.right = Math.min(r16.l(), r13.right);
            r13.bottom = Math.min(r16.j(), r13.bottom);
            r15 = r15 + 1;
            goto L6
        L9:
            return r12.t(r13.left, r13.top, r13.right, r13.bottom);
        }
    }

    public class e extends androidx.core.view.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewPager f5156a;

        public e(ViewPager r10) {
            this.f5156a = r10;
        }

        public final boolean c() {
            PagerAdapter r10 = this.f5156a.mAdapter;
            if (r10 != null) goto L5;
        L7:
            return false;
        L5:
            if (r10.getCount() <= 1) goto L7;
            return true;
        }

        @Override // androidx.core.view.a
        public void onInitializeAccessibilityEvent(View r10, AccessibilityEvent r11) {
            super.onInitializeAccessibilityEvent(r10, r11);
            r11.setClassName(ViewPager.class.getName());
            r11.setScrollable(c());
            if (r11.getEventType() != 4096) goto L8;
            PagerAdapter r12 = this.f5156a.mAdapter;
            if (r12 == null) goto L9;
            r11.setItemCount(r12.getCount());
            r11.setFromIndex(this.f5156a.mCurItem);
            r11.setToIndex(this.f5156a.mCurItem);
            return;
        L9:
            return;
        }

        @Override // androidx.core.view.a
        public void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfoCompat r11) {
            super.onInitializeAccessibilityNodeInfo(r10, r11);
            r11.V(ViewPager.class.getName());
            r11.r0(c());
            if (this.f5156a.canScrollHorizontally(1) == false) goto L6;
            r11.a(4096);
        L6:
            if (this.f5156a.canScrollHorizontally(-1) == false) goto L9;
            r11.a(8192);
            return;
        }

        @Override // androidx.core.view.a
        public boolean performAccessibilityAction(View r10, int r11, Bundle r12) {
            if (super.performAccessibilityAction(r10, r11, r12) == false) goto L6;
            return true;
        L6:
            if (r11 == 4096) goto L16;
            if (r11 == 8192) goto L11;
            return false;
        L11:
            if (this.f5156a.canScrollHorizontally(-1) == false) goto L14;
            ViewPager r13 = this.f5156a;
            r13.setCurrentItem(r13.mCurItem - 1);
            return true;
        L14:
            return false;
        L16:
            if (this.f5156a.canScrollHorizontally(1) == false) goto L19;
            ViewPager r14 = this.f5156a;
            r14.setCurrentItem(r14.mCurItem + 1);
            return true;
        L19:
            return false;
        }
    }

    public static class f implements OnPageChangeListener {
        public f() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int r10) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int r10, float r11, int r12) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r10) {
        }
    }

    static {
        LAYOUT_ATTRS = new int[]{R.attr.layout_gravity};
        COMPARATOR = new a();
        sInterpolator = new b();
        sPositionComparator = new ViewPositionComparator();
    }

    public ViewPager(@NonNull Context r10) {
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
        this.mEndScrollRunnable = new c(this);
        this.mScrollState = 0;
        initViewPager();
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public static boolean k(View r10) {
        if (r10.getClass().getAnnotation(DecorView.class) == null) goto L5;
        return true;
    L5:
        return false;
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

    private void setScrollingCacheEnabled(boolean r10) {
        if (this.mScrollingCacheEnabled == r10) goto L6;
        this.mScrollingCacheEnabled = r10;
        return;
    }

    public final void a(ItemInfo r11, int r12, ItemInfo r13) {
        int r10 = this.mAdapter.getCount();
        int r14 = getClientWidth();
        if (r14 <= 0) goto L5;
        float r15 = this.mPageMargin / r14;
    L7:
        if (r13 == null) goto L39;
        int r16 = r13.f5142b;
        int r17 = r11.f5142b;
        if (r16 >= r17) goto L25;
        float r18 = (r13.f5145e + r13.f5144d) + r15;
        int r19 = r16 + 1;
        int r110 = 0;
    L12:
        if (r19 > r11.f5142b) goto L39;
        if (r110 >= this.mItems.size()) goto L39;
        ItemInfo r20 = this.mItems.get(r110);
    L16:
        ItemInfo r21 = r20;
        if (r19 <= r21.f5142b) goto L22;
        if (r110 >= (this.mItems.size() - 1)) goto L22;
        r110 = r110 + 1;
        r20 = this.mItems.get(r110);
    L22:
        if (r19 >= r21.f5142b) goto L24;
        r18 = r18 + (this.mAdapter.getPageWidth(r19) + r15);
        r19 = r19 + 1;
        goto L22
    L24:
        r21.f5145e = r18;
        r18 = r18 + (r21.f5144d + r15);
        r19 = r19 + 1;
        goto L12
    L25:
        if (r16 <= r17) goto L39;
        int r22 = this.mItems.size() - 1;
        float r111 = r13.f5145e;
    L27:
        r16 = r16 - 1;
        if (r16 < r11.f5142b) goto L39;
        if (r22 < 0) goto L39;
        ItemInfo r23 = this.mItems.get(r22);
    L31:
        ItemInfo r24 = r23;
        if (r16 >= r24.f5142b) goto L36;
        if (r22 <= 0) goto L36;
        r22 = r22 - 1;
        r23 = this.mItems.get(r22);
    L36:
        if (r16 <= r24.f5142b) goto L38;
        r111 = r111 - (this.mAdapter.getPageWidth(r16) + r15);
        r16 = r16 - 1;
        goto L36
    L38:
        r111 = r111 - (r24.f5144d + r15);
        r24.f5145e = r111;
    L39:
        int r112 = this.mItems.size();
        float r25 = r11.f5145e;
        int r26 = r11.f5142b;
        int r27 = r26 - 1;
        if (r26 != 0) goto L42;
        float r28 = r25;
    L43:
        this.mFirstOffset = r28;
        int r29 = r10 - 1;
        if (r26 != r29) goto L46;
        float r30 = (r11.f5144d + r25) - 1.0f;
    L47:
        this.mLastOffset = r30;
        int r31 = r12 - 1;
    L48:
        if (r31 < 0) goto L57;
        ItemInfo r32 = this.mItems.get(r31);
    L50:
        int r33 = r32.f5142b;
        if (r27 <= r33) goto L53;
        r25 = r25 - (this.mAdapter.getPageWidth(r27) + r15);
        r27 = r27 - 1;
        goto L50
    L53:
        r25 = r25 - (r32.f5144d + r15);
        r32.f5145e = r25;
        if (r33 != 0) goto L56;
        this.mFirstOffset = r25;
    L56:
        r31 = r31 - 1;
        r27 = r27 - 1;
        goto L48
    L57:
        float r34 = (r11.f5145e + r11.f5144d) + r15;
        int r113 = r11.f5142b + 1;
        int r114 = r12 + 1;
    L58:
        if (r114 >= r112) goto L66;
        ItemInfo r35 = this.mItems.get(r114);
    L60:
        int r36 = r35.f5142b;
        if (r113 >= r36) goto L63;
        r34 = r34 + (this.mAdapter.getPageWidth(r113) + r15);
        r113 = r113 + 1;
        goto L60
    L63:
        if (r36 != r29) goto L65;
        this.mLastOffset = (r35.f5144d + r34) - 1.0f;
    L65:
        r35.f5145e = r34;
        r34 = r34 + (r35.f5144d + r15);
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
        if (r17.f5142b != this.mCurItem) goto L14;
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
        r12.f5142b = r10;
        r12.f5141a = this.mAdapter.instantiateItem(this, r10);
        r12.f5144d = this.mAdapter.getPageWidth(r10);
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

    public void addOnAdapterChangeListener(@NonNull OnAdapterChangeListener r10) {
        if (this.mAdapterChangeListeners != null) goto L5;
        this.mAdapterChangeListeners = new ArrayList();
    L5:
        this.mAdapterChangeListeners.add(r10);
    }

    public void addOnPageChangeListener(@NonNull OnPageChangeListener r10) {
        if (this.mOnPageChangeListeners != null) goto L5;
        this.mOnPageChangeListeners = new ArrayList();
    L5:
        this.mOnPageChangeListeners.add(r10);
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
        if (r13.f5142b != this.mCurItem) goto L12;
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
        boolean r14 = r13.f5146a | k(r10);
        r13.f5146a = r14;
        if (this.mInLayout == false) goto L11;
        if (r14 == true) goto L10;
        r13.f5149d = true;
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
        int r13 = i(this.mTempRect, r12).left;
        int r14 = i(this.mTempRect, r11).left;
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
        int r16 = i(this.mTempRect, r12).left;
        int r17 = i(this.mTempRect, r11).left;
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
        Log.e(TAG, "arrowScroll tried to find focus based on non-child current focused view " + r19.toString());
        goto L4
    }

    public final void b(boolean r10) {
        if (this.mScrollState != 2) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L15;
        setScrollingCacheEnabled(false);
        if (this.mScroller.isFinished() == true) goto L15;
        this.mScroller.abortAnimation();
        int r12 = getScrollX();
        int r13 = getScrollY();
        int r14 = this.mScroller.getCurrX();
        int r15 = this.mScroller.getCurrY();
        if (r12 != r14) goto L12;
        if (r13 == r15) goto L15;
    L12:
        scrollTo(r14, r15);
        if (r14 == r12) goto L15;
        m(r14);
    L15:
        this.mPopulatePending = false;
        int r16 = 0;
    L17:
        if (r16 >= this.mItems.size()) goto L22;
        ItemInfo r17 = this.mItems.get(r16);
        if (r17.f5143c == false) goto L21;
        r17.f5143c = false;
        r11 = true;
    L21:
        r16 = r16 + 1;
        goto L17
    L22:
        if (r11 == false) goto L30;
        if (r10 == false) goto L25;
        ViewCompat.h0(this, this.mEndScrollRunnable);
        return;
    L25:
        this.mEndScrollRunnable.run();
        return;
    L30:
        return;
    L5:
        r11 = false;
        goto L6
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

    public final int c(int r10, float r11, int r12, int r13) {
        if (Math.abs(r13) <= this.mFlingDistance) goto L10;
        if (Math.abs(r12) <= this.mMinimumVelocity) goto L10;
        if (r12 > 0) goto L15;
        r10 = r10 + 1;
    L15:
        if (this.mItems.size() <= 0) goto L18;
        ItemInfo r14 = this.mItems.get(0);
        ArrayList<ItemInfo> r15 = this.mItems;
        return Math.max(r14.f5142b, Math.min(r10, r15.get(r15.size() - 1).f5142b));
    L18:
        return r10;
    L10:
        if (r10 < this.mCurItem) goto L12;
        float r16 = 0.4f;
    L13:
        r10 = r10 + ((int) (r11 + r16));
        goto L15
    L12:
        r16 = 0.6f;
        goto L13
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

    public void clearOnPageChangeListeners() {
        List<OnPageChangeListener> r10 = this.mOnPageChangeListeners;
        if (r10 == null) goto L6;
        r10.clear();
        return;
    }

    @Override // android.view.View
    public void computeScroll() {
        this.mIsScrollStarted = true;
        if (this.mScroller.isFinished() == false) goto L5;
    L14:
        b(true);
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
        ViewCompat.g0(this);
        return;
    L9:
        scrollTo(r12, r13);
        if (m(r12) == true) goto L12;
        this.mScroller.abortAnimation();
        scrollTo(0, r13);
        goto L12
    }

    public final void d(int r10, float r11, int r12) {
        OnPageChangeListener r13 = this.mOnPageChangeListener;
        if (r13 == null) goto L5;
        r13.onPageScrolled(r10, r11, r12);
    L5:
        List<OnPageChangeListener> r14 = this.mOnPageChangeListeners;
        if (r14 == null) goto L13;
        int r15 = r14.size();
        int r16 = 0;
    L8:
        if (r16 >= r15) goto L13;
        OnPageChangeListener r17 = this.mOnPageChangeListeners.get(r16);
        if (r17 == null) goto L12;
        r17.onPageScrolled(r10, r11, r12);
    L12:
        r16 = r16 + 1;
    L13:
        OnPageChangeListener r18 = this.mInternalPageChangeListener;
        if (r18 == null) goto L20;
        r18.onPageScrolled(r10, r11, r12);
        return;
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
        int r16 = this.mAdapter.getItemPosition(r15.f5141a);
        if (r16 == (-1)) goto L29;
        if (r16 != (-2)) goto L23;
        this.mItems.remove(r13);
        r13 = r13 - 1;
        if (r14 == true) goto L19;
        this.mAdapter.startUpdate(this);
        r14 = true;
    L19:
        this.mAdapter.destroyItem(this, r15.f5142b, r15.f5141a);
        int r17 = this.mCurItem;
        if (r17 != r15.f5142b) goto L22;
        r12 = Math.max(0, Math.min(r17, r10 - 1));
    L22:
        r11 = true;
        goto L29
    L23:
        int r18 = r15.f5142b;
        if (r18 == r16) goto L29;
        if (r18 != this.mCurItem) goto L28;
        r12 = r16;
    L28:
        r15.f5142b = r16;
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
        if (r21.f5146a == true) goto L39;
        r21.f5148c = 0.0f;
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
        if (r14.f5142b != this.mCurItem) goto L18;
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
        return (float) Math.sin((r10 - 0.5f) * 0.47123894f);
    }

    @Override // android.view.View
    public void draw(Canvas r10) {
        super.draw(r10);
        int r11 = getOverScrollMode();
        boolean r12 = false;
        if (r11 == 0) goto L13;
        if (r11 != 1) goto L11;
        PagerAdapter r13 = this.mAdapter;
        if (r13 == null) goto L11;
        if (r13.getCount() > 1) goto L13;
    L11:
        this.mLeftEdge.finish();
        this.mRightEdge.finish();
    L18:
        if (r12 == false) goto L21;
        ViewCompat.g0(this);
        return;
    L21:
        return;
    L13:
        if (this.mLeftEdge.isFinished() == true) goto L16;
        int r14 = r10.save();
        int r15 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r16 = getWidth();
        r10.rotate(270.0f);
        r10.translate((-r15) + getPaddingTop(), this.mFirstOffset * r16);
        this.mLeftEdge.setSize(r15, r16);
        r12 = this.mLeftEdge.draw(r10);
        r10.restoreToCount(r14);
    L16:
        if (this.mRightEdge.isFinished() == true) goto L18;
        int r17 = r10.save();
        int r18 = getWidth();
        int r19 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        r10.rotate(90.0f);
        r10.translate(-getPaddingTop(), (-(this.mLastOffset + 1.0f)) * r18);
        this.mRightEdge.setSize(r19, r18);
        r12 = r12 | this.mRightEdge.draw(r10);
        r10.restoreToCount(r17);
        goto L18
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

    public final void e(int r10) {
        OnPageChangeListener r11 = this.mOnPageChangeListener;
        if (r11 == null) goto L5;
        r11.onPageSelected(r10);
    L5:
        List<OnPageChangeListener> r12 = this.mOnPageChangeListeners;
        if (r12 == null) goto L13;
        int r13 = r12.size();
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L13;
        OnPageChangeListener r15 = this.mOnPageChangeListeners.get(r14);
        if (r15 == null) goto L12;
        r15.onPageSelected(r10);
    L12:
        r14 = r14 + 1;
    L13:
        OnPageChangeListener r16 = this.mInternalPageChangeListener;
        if (r16 == null) goto L20;
        r16.onPageSelected(r10);
        return;
    }

    public void endFakeDrag() {
        if (this.mFakeDragging == false) goto L10;
        if (this.mAdapter == null) goto L7;
        VelocityTracker r10 = this.mVelocityTracker;
        r10.computeCurrentVelocity(1000, this.mMaximumVelocity);
        int r11 = (int) r10.getXVelocity(this.mActivePointerId);
        this.mPopulatePending = true;
        int r12 = getClientWidth();
        int r13 = getScrollX();
        ItemInfo r14 = j();
        setCurrentItemInternal(c(r14.f5142b, ((r13 / r12) - r14.f5145e) / r14.f5144d, r11, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, r11);
    L7:
        h();
        this.mFakeDragging = false;
        return;
    L10:
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public boolean executeKeyEvent(@NonNull KeyEvent r10) {
        if (r10.getAction() != 0) goto L25;
        int r11 = r10.getKeyCode();
        if (r11 == 21) goto L22;
        if (r11 == 22) goto L18;
        if (r11 != 61) goto L25;
        if (r10.hasNoModifiers() == false) goto L15;
        return arrowScroll(2);
    L15:
        if (r10.hasModifiers(1) == false) goto L25;
        return arrowScroll(1);
    L18:
        if (r10.hasModifiers(2) == false) goto L30;
        return pageRight();
    L30:
        return arrowScroll(66);
    L22:
        if (r10.hasModifiers(2) == false) goto L32;
        return pageLeft();
    L32:
        return arrowScroll(17);
    L25:
        return false;
    }

    public final void f(int r10) {
        OnPageChangeListener r11 = this.mOnPageChangeListener;
        if (r11 == null) goto L5;
        r11.onPageScrollStateChanged(r10);
    L5:
        List<OnPageChangeListener> r12 = this.mOnPageChangeListeners;
        if (r12 == null) goto L13;
        int r13 = r12.size();
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L13;
        OnPageChangeListener r15 = this.mOnPageChangeListeners.get(r14);
        if (r15 == null) goto L12;
        r15.onPageScrollStateChanged(r10);
    L12:
        r14 = r14 + 1;
    L13:
        OnPageChangeListener r16 = this.mInternalPageChangeListener;
        if (r16 == null) goto L20;
        r16.onPageScrollStateChanged(r10);
        return;
    }

    public void fakeDragBy(float r11) {
        if (this.mFakeDragging == false) goto L22;
        if (this.mAdapter != null) goto L7;
        return;
    L7:
        this.mLastMotionX += r11;
        float r10 = getScrollX() - r11;
        float r12 = getClientWidth();
        float r13 = this.mFirstOffset * r12;
        float r14 = this.mLastOffset * r12;
        ItemInfo r15 = this.mItems.get(0);
        ArrayList<ItemInfo> r16 = this.mItems;
        ItemInfo r17 = r16.get(r16.size() - 1);
        if (r15.f5142b == 0) goto L11;
        r13 = r15.f5145e * r12;
    L11:
        if (r17.f5142b == (this.mAdapter.getCount() - 1)) goto L14;
        r14 = r17.f5145e * r12;
    L14:
        if (r10 >= r13) goto L17;
        r10 = r13;
    L19:
        int r18 = (int) r10;
        this.mLastMotionX += r10 - r18;
        scrollTo(r18, getScrollY());
        m(r18);
        MotionEvent r19 = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0.0f, 0);
        this.mVelocityTracker.addMovement(r19);
        r19.recycle();
        return;
    L17:
        if (r10 <= r14) goto L19;
        r10 = r14;
        goto L19
    L22:
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public final void g(boolean r10) {
        int r11 = getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        if (r10 == false) goto L6;
        int r13 = this.mPageTransformerLayerType;
    L7:
        getChildAt(r12).setLayerType(r13, null);
        r12 = r12 + 1;
        goto L3
    L6:
        r13 = 0;
        goto L7
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return generateDefaultLayoutParams();
    }

    @Nullable
    public PagerAdapter getAdapter() {
        return this.mAdapter;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int r10, int r11) {
        if (this.mDrawingOrder != 2) goto L6;
        r11 = (r10 - 1) - r11;
    L6:
        return ((LayoutParams) this.mDrawingOrderedChildren.get(r11).getLayoutParams()).f5151f;
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

    public final void h() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker r10 = this.mVelocityTracker;
        if (r10 == null) goto L6;
        r10.recycle();
        this.mVelocityTracker = null;
        return;
    }

    public final Rect i(Rect r10, View r11) {
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
        if (this.mAdapter.isViewFromObject(r10, r12.f5141a) == true) goto L7;
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
        if (r12.f5142b == r10) goto L7;
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
        this.mScroller = new Scroller(r10, sInterpolator);
        ViewConfiguration r11 = ViewConfiguration.get(r10);
        float r12 = r10.getResources().getDisplayMetrics().density;
        this.mTouchSlop = r11.getScaledPagingTouchSlop();
        this.mMinimumVelocity = (int) (400.0f * r12);
        this.mMaximumVelocity = r11.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffect(r10);
        this.mRightEdge = new EdgeEffect(r10);
        this.mFlingDistance = (int) (25.0f * r12);
        this.mCloseEnough = (int) (2.0f * r12);
        this.mDefaultGutterSize = (int) (r12 * 16.0f);
        ViewCompat.p0(this, new e(this));
        if (ViewCompat.y(this) != 0) goto L5;
        ViewCompat.A0(this, 1);
    L5:
        ViewCompat.C0(this, new d(this));
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    public final ItemInfo j() {
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
        if (r19.f5142b == r20) goto L17;
        r19 = this.mTempItem;
        r19.f5145e = (r11 + r18) + r13;
        r19.f5142b = r20;
        r19.f5144d = this.mAdapter.getPageWidth(r20);
        r14 = r14 - 1;
    L17:
        ItemInfo r21 = r19;
        r11 = r21.f5145e;
        float r22 = (r21.f5144d + r11) + r13;
        if (r15 == true) goto L24;
        if (r12 >= r11) goto L24;
        return r16;
    L24:
        if (r12 < r22) goto L29;
        if (r14 == (this.mItems.size() - 1)) goto L29;
        int r23 = r21.f5142b;
        float r24 = r21.f5144d;
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

    public final boolean l(float r10, float r11) {
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

    public final boolean m(int r10) {
        if (this.mItems.size() == 0) goto L5;
        ItemInfo r11 = j();
        int r12 = getClientWidth();
        int r13 = this.mPageMargin;
        int r14 = r12 + r13;
        float r15 = r12;
        int r16 = r11.f5142b;
        float r17 = ((r10 / r15) - r11.f5145e) / (r11.f5144d + (r13 / r15));
        this.mCalledSuper = false;
        onPageScrolled(r16, r17, (int) (r14 * r17));
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

    public final boolean n(float r10) {
        float r11 = this.mLastMotionX - r10;
        this.mLastMotionX = r10;
        float r12 = getScrollX() + r11;
        float r13 = getClientWidth();
        float r14 = this.mFirstOffset * r13;
        float r15 = this.mLastOffset * r13;
        boolean r16 = false;
        ItemInfo r17 = this.mItems.get(0);
        ArrayList<ItemInfo> r18 = this.mItems;
        ItemInfo r19 = r18.get(r18.size() - 1);
        if (r17.f5142b == 0) goto L5;
        r14 = r17.f5145e * r13;
        boolean r20 = false;
    L7:
        if (r19.f5142b == (this.mAdapter.getCount() - 1)) goto L9;
        r15 = r19.f5145e * r13;
        boolean r21 = false;
    L11:
        if (r12 >= r14) goto L16;
        if (r20 == false) goto L14;
        this.mLeftEdge.onPull(Math.abs(r14 - r12) / r13);
        r16 = true;
    L14:
        r12 = r14;
    L20:
        int r22 = (int) r12;
        this.mLastMotionX += r12 - r22;
        scrollTo(r22, getScrollY());
        m(r22);
        return r16;
    L16:
        if (r12 <= r15) goto L20;
        if (r21 == false) goto L19;
        this.mRightEdge.onPull(Math.abs(r12 - r15) / r13);
        r16 = true;
    L19:
        r12 = r15;
        goto L20
    L9:
        r21 = true;
        goto L11
    L5:
        r20 = true;
        goto L7
    }

    public final void o(int r10, int r11, int r12, int r13) {
        if (r11 > 0) goto L4;
    L9:
        ItemInfo r14 = infoForPosition(this.mCurItem);
        if (r14 == null) goto L12;
        float r15 = Math.min(r14.f5145e, this.mLastOffset);
    L13:
        int r16 = (int) (r15 * ((r10 - getPaddingLeft()) - getPaddingRight()));
        if (r16 == getScrollX()) goto L19;
        b(false);
        scrollTo(r16, getScrollY());
        return;
    L19:
        return;
    L12:
        r15 = 0.0f;
        goto L13
    L4:
        if (this.mItems.isEmpty() == true) goto L9;
        if (this.mScroller.isFinished() == true) goto L8;
        this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
        return;
    L8:
        scrollTo((int) ((getScrollX() / (((r11 - getPaddingLeft()) - getPaddingRight()) + r13)) * (((r10 - getPaddingLeft()) - getPaddingRight()) + r12)), getScrollY());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        Scroller r10 = this.mScroller;
        if (r10 != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        return;
    L5:
        if (r10.isFinished() == true) goto L7;
        this.mScroller.abortAnimation();
        goto L7
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
        float r16 = r15.f5145e;
        int r17 = this.mItems.size();
        int r19 = r15.f5142b;
        int r110 = this.mItems.get(r17 - 1).f5142b;
    L11:
        if (r19 >= r110) goto L35;
    L12:
        int r111 = r15.f5142b;
        if (r19 <= r111) goto L16;
        if (r14 >= r17) goto L16;
        r14 = r14 + 1;
        r15 = this.mItems.get(r14);
    L16:
        if (r19 != r111) goto L18;
        float r20 = r15.f5145e;
        float r112 = r15.f5144d;
        float r113 = (r20 + r112) * r12;
        r16 = (r20 + r112) + r13;
    L20:
        if ((this.mPageMargin + r113) <= r10) goto L24;
        this.mMarginDrawable.setBounds(Math.round(r113), this.mTopPageBounds, Math.round(this.mPageMargin + r113), this.mBottomPageBounds);
        this.mMarginDrawable.draw(r18);
    L24:
        if (r113 > (r10 + r11)) goto L36;
        r19 = r19 + 1;
        r13 = r13;
        goto L11
    L36:
        return;
    L18:
        float r114 = this.mAdapter.getPageWidth(r19);
        r113 = (r16 + r114) * r12;
        r16 = r16 + (r114 + r13);
        goto L20
    L35:
        return;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r16) {
        int r10 = r16.getAction() & PrivateKeyType.INVALID;
        if (r10 != 3) goto L5;
    L60:
        r();
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
        int r11 = this.mActivePointerId;
        if (r11 == (-1)) goto L56;
        int r12 = r16.findPointerIndex(r11);
        float r13 = r16.getX(r12);
        float r14 = r13 - this.mLastMotionX;
        float r15 = Math.abs(r14);
        float r17 = r16.getY(r12);
        float r18 = Math.abs(r17 - this.mInitialMotionY);
        if (r14 != 0.0f) goto L27;
    L32:
        int r19 = this.mTouchSlop;
        if (r15 <= r19) goto L42;
        if ((r15 * 0.5f) <= r18) goto L42;
        this.mIsBeingDragged = true;
        q(true);
        setScrollState(1);
        float r20 = this.mInitialMotionX;
        float r21 = this.mTouchSlop;
        if (r14 <= 0.0f) goto L39;
        float r22 = r20 + r21;
    L40:
        this.mLastMotionX = r22;
        this.mLastMotionY = r17;
        setScrollingCacheEnabled(true);
    L45:
        if (this.mIsBeingDragged == false) goto L56;
        if (n(r13) == false) goto L56;
        ViewCompat.g0(this);
        goto L56
    L39:
        r22 = r20 - r21;
    L42:
        if (r18 <= r19) goto L45;
        this.mIsUnableToDrag = true;
        goto L45
    L27:
        if (l(this.mLastMotionX, r14) == true) goto L32;
        if (canScroll(this, false, (int) r14, (int) r13, (int) r17) == false) goto L32;
        this.mLastMotionX = r13;
        this.mLastMotionY = r17;
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
        float r23 = r16.getX();
        this.mInitialMotionX = r23;
        this.mLastMotionX = r23;
        float r24 = r16.getY();
        this.mInitialMotionY = r24;
        this.mLastMotionY = r24;
        this.mActivePointerId = r16.getPointerId(0);
        this.mIsUnableToDrag = false;
        this.mIsScrollStarted = true;
        this.mScroller.computeScrollOffset();
        if (this.mScrollState == 2) goto L52;
    L54:
        b(false);
        this.mIsBeingDragged = false;
        goto L56
    L52:
        if (Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) <= this.mCloseEnough) goto L54;
        this.mScroller.abortAnimation();
        this.mPopulatePending = false;
        populate();
        this.mIsBeingDragged = true;
        q(true);
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
        if (r112.f5146a == false) goto L32;
        int r113 = r112.f5147b;
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
        LayoutParams r28 = (LayoutParams) r27.getLayoutParams();
        if (r28.f5146a == true) goto L45;
        ItemInfo r122 = infoForChild(r27);
        if (r122 == null) goto L45;
        float r123 = r25;
        int r124 = ((int) (r122.f5145e * r123)) + r13;
        if (r28.f5149d == false) goto L44;
        r28.f5149d = false;
        r27.measure(View.MeasureSpec.makeMeasureSpec((int) (r123 * r28.f5148c), Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec((r12 - r14) - r16, Ints.MAX_POWER_OF_TWO));
    L44:
        r27.layout(r124, r14, r27.getMeasuredWidth() + r124, r27.getMeasuredHeight() + r14);
    L45:
        r26 = r26 + 1;
        goto L34
    L46:
        this.mTopPageBounds = r14;
        this.mBottomPageBounds = r12 - r16;
        this.mDecorChildCount = r110;
        if (this.mFirstLayout == false) goto L49;
        boolean r29 = false;
        s(this.mCurItem, false, 0, false);
    L50:
        this.mFirstLayout = r29;
        return;
    L49:
        r29 = false;
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
        if (r21.f5146a == false) goto L47;
        int r22 = r21.f5147b;
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
        r29.measure(View.MeasureSpec.makeMeasureSpec((int) (r17 * r30.f5148c), Ints.MAX_POWER_OF_TWO), this.mChildHeightMeasureSpec);
        goto L57
    L55:
        if (r30.f5146a == false) goto L56;
    L57:
        r10 = r10 + 1;
        goto L49
    }

    @CallSuper
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
        if (r21.f5146a == false) goto L24;
        int r22 = r21.f5147b & 7;
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
        d(r13, r14, r15);
        if (this.mPageTransformer == null) goto L34;
        int r111 = getScrollX();
        int r112 = getChildCount();
    L28:
        if (r10 >= r112) goto L34;
        View r113 = getChildAt(r10);
        if (((LayoutParams) r113.getLayoutParams()).f5146a == true) goto L33;
        this.mPageTransformer.transformPage(r113, (r113.getLeft() - r111) / getClientWidth());
    L33:
        r10 = r10 + 1;
    L34:
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
        if (r17.f5142b != this.mCurItem) goto L16;
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
        o(r10, r12, r14, r14);
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
    L61:
        return false;
    L13:
        if (r12.getCount() == 0) goto L61;
        if (this.mVelocityTracker != null) goto L18;
        this.mVelocityTracker = VelocityTracker.obtain();
    L18:
        this.mVelocityTracker.addMovement(r10);
        int r13 = r10.getAction() & PrivateKeyType.INVALID;
        if (r13 == 0) goto L57;
        if (r13 == 1) goto L55;
        if (r13 == 2) goto L36;
        if (r13 == 3) goto L33;
        if (r13 != 5) goto L28;
        int r14 = r10.getActionIndex();
        this.mLastMotionX = r10.getX(r14);
        this.mActivePointerId = r10.getPointerId(r14);
    L58:
        if (r11 == false) goto L60;
        ViewCompat.g0(this);
    L60:
        return true;
    L28:
        if (r13 != 6) goto L58;
        onSecondaryPointerUp(r10);
        this.mLastMotionX = r10.getX(r10.findPointerIndex(this.mActivePointerId));
        goto L58
    L33:
        if (this.mIsBeingDragged == false) goto L58;
        s(this.mCurItem, true, 0, false);
        r11 = r();
        goto L58
    L36:
        if (this.mIsBeingDragged == true) goto L52;
        int r15 = r10.findPointerIndex(this.mActivePointerId);
        if (r15 != (-1)) goto L40;
        r11 = r();
        goto L58
    L40:
        float r16 = r10.getX(r15);
        float r17 = Math.abs(r16 - this.mLastMotionX);
        float r18 = r10.getY(r15);
        float r19 = Math.abs(r18 - this.mLastMotionY);
        if (r17 <= this.mTouchSlop) goto L52;
        if (r17 <= r19) goto L52;
        this.mIsBeingDragged = true;
        q(true);
        float r20 = this.mInitialMotionX;
        if ((r16 - r20) <= 0.0f) goto L47;
        float r21 = r20 + this.mTouchSlop;
    L48:
        this.mLastMotionX = r21;
        this.mLastMotionY = r18;
        setScrollState(1);
        setScrollingCacheEnabled(true);
        ViewParent r22 = getParent();
        if (r22 == null) goto L52;
        r22.requestDisallowInterceptTouchEvent(true);
        goto L52
    L47:
        r21 = r20 - this.mTouchSlop;
    L52:
        if (this.mIsBeingDragged == false) goto L58;
        r11 = n(r10.getX(r10.findPointerIndex(this.mActivePointerId)));
        goto L58
    L55:
        if (this.mIsBeingDragged == false) goto L58;
        VelocityTracker r23 = this.mVelocityTracker;
        r23.computeCurrentVelocity(1000, this.mMaximumVelocity);
        int r24 = (int) r23.getXVelocity(this.mActivePointerId);
        this.mPopulatePending = true;
        int r25 = getClientWidth();
        int r26 = getScrollX();
        ItemInfo r27 = j();
        float r28 = r25;
        setCurrentItemInternal(c(r27.f5142b, ((r26 / r28) - r27.f5145e) / (r27.f5144d + (this.mPageMargin / r28)), r24, (int) (r10.getX(r10.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX)), true, true, r24);
        r11 = r();
        goto L58
    L57:
        this.mScroller.abortAnimation();
        this.mPopulatePending = false;
        populate();
        float r29 = r10.getX();
        this.mInitialMotionX = r29;
        this.mLastMotionX = r29;
        float r30 = r10.getY();
        this.mInitialMotionY = r30;
        this.mLastMotionY = r30;
        this.mActivePointerId = r10.getPointerId(0);
        goto L58
    L8:
        if (r10.getEdgeFlags() == 0) goto L10;
        return false;
    }

    public final void p() {
        int r10 = 0;
    L4:
        if (r10 >= getChildCount()) goto L9;
        if (((LayoutParams) getChildAt(r10).getLayoutParams()).f5146a == true) goto L8;
        removeViewAt(r10);
        r10 = r10 - 1;
    L8:
        r10 = r10 + 1;
        goto L4
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

    public final void q(boolean r10) {
        ViewParent r11 = getParent();
        if (r11 == null) goto L6;
        r11.requestDisallowInterceptTouchEvent(r10);
        return;
    }

    public final boolean r() {
        this.mActivePointerId = -1;
        h();
        this.mLeftEdge.onRelease();
        this.mRightEdge.onRelease();
        if (this.mLeftEdge.isFinished() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mRightEdge.isFinished() == true) goto L8;
        return false;
    }

    public void removeOnAdapterChangeListener(@NonNull OnAdapterChangeListener r10) {
        List<OnAdapterChangeListener> r11 = this.mAdapterChangeListeners;
        if (r11 == null) goto L6;
        r11.remove(r10);
        return;
    }

    public void removeOnPageChangeListener(@NonNull OnPageChangeListener r10) {
        List<OnPageChangeListener> r11 = this.mOnPageChangeListeners;
        if (r11 == null) goto L6;
        r11.remove(r10);
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View r10) {
        if (this.mInLayout == false) goto L5;
        removeViewInLayout(r10);
        return;
    L5:
        super.removeView(r10);
    }

    public final void s(int r10, boolean r11, int r12, boolean r13) {
        ItemInfo r14 = infoForPosition(r10);
        if (r14 == null) goto L5;
        int r15 = (int) (getClientWidth() * Math.max(this.mFirstOffset, Math.min(r14.f5145e, this.mLastOffset)));
    L6:
        if (r11 == false) goto L10;
        smoothScrollTo(r15, 0, r12);
        if (r13 == false) goto L14;
        e(r10);
        return;
    L14:
        return;
    L10:
        if (r13 == false) goto L12;
        e(r10);
    L12:
        b(false);
        scrollTo(r15, 0);
        m(r15);
        return;
    L5:
        r15 = 0;
        goto L6
    }

    public void setAdapter(@Nullable PagerAdapter r10) {
        PagerAdapter r11 = this.mAdapter;
        int r12 = 0;
        if (r11 == null) goto L9;
        r11.setViewPagerObserver(null);
        this.mAdapter.startUpdate(this);
        int r13 = 0;
    L6:
        if (r13 >= this.mItems.size()) goto L8;
        ItemInfo r14 = this.mItems.get(r13);
        this.mAdapter.destroyItem(this, r14.f5142b, r14.f5141a);
        r13 = r13 + 1;
        goto L6
    L8:
        this.mAdapter.finishUpdate(this);
        this.mItems.clear();
        p();
        this.mCurItem = 0;
        scrollTo(0, 0);
    L9:
        PagerAdapter r15 = this.mAdapter;
        this.mAdapter = r10;
        this.mExpectedAdapterCount = 0;
        if (r10 != null) goto L12;
    L20:
        List<OnAdapterChangeListener> r16 = this.mAdapterChangeListeners;
        if (r16 != null) goto L23;
        return;
    L23:
        if (r16.isEmpty() == true) goto L30;
        int r17 = this.mAdapterChangeListeners.size();
    L25:
        if (r12 >= r17) goto L31;
        this.mAdapterChangeListeners.get(r12).onAdapterChanged(this, r15, r10);
        r12 = r12 + 1;
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
        boolean r18 = this.mFirstLayout;
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
        if (r18 == true) goto L19;
        populate();
        goto L20
    L19:
        requestLayout();
        goto L20
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
        Log.w(TAG, "Requested offscreen page limit " + r10 + " too small; defaulting to 1");
        r10 = 1;
    L6:
        if (r10 == this.mOffscreenPageLimit) goto L9;
        this.mOffscreenPageLimit = r10;
        populate();
        return;
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener r10) {
        this.mOnPageChangeListener = r10;
    }

    public void setPageMargin(int r10) {
        int r11 = this.mPageMargin;
        this.mPageMargin = r10;
        int r12 = getWidth();
        o(r12, r12, r10, r11);
        requestLayout();
    }

    public void setPageMarginDrawable(@Nullable Drawable r10) {
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

    public void setPageTransformer(boolean r10, @Nullable PageTransformer r11) {
        setPageTransformer(r10, r11, 2);
    }

    public void setScrollState(int r10) {
        if (this.mScrollState != r10) goto L5;
        return;
    L5:
        this.mScrollState = r10;
        if (this.mPageTransformer == null) goto L11;
        if (r10 == 0) goto L9;
        boolean r11 = true;
    L10:
        g(r11);
        goto L11
    L9:
        r11 = false;
    L11:
        f(r10);
    }

    public void smoothScrollTo(int r10, int r11) {
        smoothScrollTo(r10, r11, 0);
    }

    public final void t() {
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
        if (r10 == r18) goto L5;
        ItemInfo r11 = infoForPosition(r10);
        this.mCurItem = r18;
    L7:
        if (this.mAdapter != null) goto L11;
        t();
        return;
    L11:
        if (this.mPopulatePending == false) goto L15;
        t();
        return;
    L15:
        if (getWindowToken() != null) goto L17;
        return;
    L17:
        this.mAdapter.startUpdate(this);
        int r12 = this.mOffscreenPageLimit;
        int r13 = Math.max(0, this.mCurItem - r12);
        int r14 = this.mAdapter.getCount();
        int r15 = Math.min(r14 - 1, this.mCurItem + r12);
        if (r14 != this.mExpectedAdapterCount) goto L139;
        int r16 = 0;
    L21:
        if (r16 >= this.mItems.size()) goto L27;
        ItemInfo r17 = this.mItems.get(r16);
        int r19 = r17.f5142b;
        int r110 = this.mCurItem;
        if (r19 >= r110) goto L24;
        r16 = r16 + 1;
        goto L21
    L24:
        if (r19 != r110) goto L27;
    L28:
        if (r17 != null) goto L32;
        if (r14 <= 0) goto L32;
        r17 = addNewItem(this.mCurItem, r16);
    L32:
        if (r17 == null) goto L103;
        int r111 = r16 - 1;
        if (r111 < 0) goto L36;
        ItemInfo r112 = this.mItems.get(r111);
    L37:
        int r113 = getClientWidth();
        if (r113 > 0) goto L40;
        float r114 = 0.0f;
    L41:
        int r20 = this.mCurItem - 1;
        float r115 = 0.0f;
    L42:
        if (r20 < 0) goto L67;
        if (r115 < r114) goto L57;
        if (r20 >= r13) goto L57;
        if (r112 == null) goto L67;
        if (r20 != r112.f5142b) goto L66;
        if (r112.f5143c == true) goto L66;
        this.mItems.remove(r111);
        this.mAdapter.destroyItem(this, r20, r112.f5141a);
        r111 = r111 - 1;
        r16 = r16 - 1;
        if (r111 < 0) goto L55;
        ItemInfo r21 = this.mItems.get(r111);
    L56:
        r112 = r21;
    L55:
        r21 = null;
    L66:
        r20 = r20 - 1;
    L57:
        if (r112 != null) goto L59;
    L63:
        r115 = r115 + addNewItem(r20, r111 + 1).f5144d;
        r16 = r16 + 1;
        if (r111 < 0) goto L55;
        r21 = this.mItems.get(r111);
        goto L56
    L59:
        if (r20 != r112.f5142b) goto L63;
        r115 = r115 + r112.f5144d;
        r111 = r111 - 1;
        if (r111 < 0) goto L55;
        r21 = this.mItems.get(r111);
    L67:
        float r22 = r17.f5144d;
        int r23 = r16 + 1;
        if (r22 < 2.0f) goto L70;
    L102:
        a(r17, r16, r11);
        this.mAdapter.setPrimaryItem(this, this.mCurItem, r17.f5141a);
        goto L103
    L70:
        if (r23 >= this.mItems.size()) goto L72;
        ItemInfo r24 = this.mItems.get(r23);
    L73:
        if (r113 > 0) goto L75;
        float r116 = 0.0f;
    L76:
        int r117 = this.mCurItem;
    L77:
        r117 = r117 + 1;
        if (r117 >= r14) goto L102;
        if (r22 < r116) goto L92;
        if (r117 <= r15) goto L92;
        if (r24 == null) goto L102;
        if (r117 != r24.f5142b) goto L77;
        if (r24.f5143c == true) goto L77;
        this.mItems.remove(r23);
        this.mAdapter.destroyItem(this, r117, r24.f5141a);
        if (r23 < this.mItems.size()) goto L90;
    L91:
        r24 = null;
        goto L77
    L90:
        r24 = this.mItems.get(r23);
    L92:
        if (r24 == null) goto L98;
        if (r117 != r24.f5142b) goto L98;
        r22 = r22 + r24.f5144d;
        r23 = r23 + 1;
        if (r23 >= this.mItems.size()) goto L91;
        r24 = this.mItems.get(r23);
    L98:
        ItemInfo r25 = addNewItem(r117, r23);
        r23 = r23 + 1;
        r22 = r22 + r25.f5144d;
        if (r23 >= this.mItems.size()) goto L91;
        r24 = this.mItems.get(r23);
        goto L77
    L75:
        r116 = (getPaddingRight() / r113) + 2.0f;
        goto L76
    L72:
        r24 = null;
        goto L73
    L40:
        r114 = (2.0f - r17.f5144d) + (getPaddingLeft() / r113);
        goto L41
    L36:
        r112 = null;
    L103:
        this.mAdapter.finishUpdate(this);
        int r26 = getChildCount();
        int r27 = 0;
    L104:
        if (r27 >= r26) goto L113;
        View r28 = getChildAt(r27);
        LayoutParams r29 = (LayoutParams) r28.getLayoutParams();
        r29.f5151f = r27;
        if (r29.f5146a == true) goto L112;
        if (r29.f5148c != 0.0f) goto L112;
        ItemInfo r30 = infoForChild(r28);
        if (r30 == null) goto L112;
        r29.f5148c = r30.f5144d;
        r29.f5150e = r30.f5142b;
    L112:
        r27 = r27 + 1;
        goto L104
    L113:
        t();
        if (hasFocus() == false) goto L133;
        View r31 = findFocus();
        if (r31 == null) goto L118;
        ItemInfo r32 = infoForAnyChild(r31);
    L119:
        if (r32 != null) goto L121;
    L122:
        int r33 = 0;
    L124:
        if (r33 >= getChildCount()) goto L183;
        View r34 = getChildAt(r33);
        ItemInfo r35 = infoForChild(r34);
        if (r35 == null) goto L132;
        if (r35.f5142b != this.mCurItem) goto L132;
        if (r34.requestFocus(2) == false) goto L132;
        return;
    L132:
        r33 = r33 + 1;
        goto L124
    L183:
        return;
    L121:
        if (r32.f5142b != this.mCurItem) goto L122;
        return;
    L118:
        r32 = null;
        goto L119
    L133:
        return;
    L27:
        r17 = null;
        goto L28
    L139:
        String r36 = getResources().getResourceName(getId());     // Catch: Resources.NotFoundException -> L136
    L138:
        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mExpectedAdapterCount + ", found: " + r14 + " Pager id: " + r36 + " Pager class: " + getClass() + " Problematic adapter: " + this.mAdapter.getClass());
    L136:
        r36 = Integer.toHexString(getId());
        goto L138
    L5:
        r11 = null;
        goto L7
    }

    public void setCurrentItemInternal(int r10, boolean r11, boolean r12, int r13) {
        PagerAdapter r14 = this.mAdapter;
        boolean r15 = false;
        if (r14 != null) goto L5;
    L39:
        setScrollingCacheEnabled(false);
        return;
    L5:
        if (r14.getCount() <= 0) goto L39;
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
        this.mItems.get(r18).f5143c = true;
        r18 = r18 + 1;
    L29:
        if (this.mCurItem == r10) goto L32;
        r15 = true;
    L32:
        if (this.mFirstLayout == false) goto L37;
        this.mCurItem = r10;
        if (r15 == false) goto L36;
        e(r10);
    L36:
        requestLayout();
        return;
    L37:
        populate(r10);
        s(r10, r11, r13, r15);
        return;
    L23:
        if (r10 >= (r17 - r16)) goto L29;
    L18:
        if (r10 < this.mAdapter.getCount()) goto L20;
        r10 = this.mAdapter.getCount() - 1;
        goto L20
    }

    public void setPageTransformer(boolean r10, @Nullable PageTransformer r11, int r12) {
        int r13 = 1;
        if (r11 == null) goto L5;
        boolean r14 = true;
    L7:
        if (this.mPageTransformer == null) goto L9;
        boolean r15 = true;
    L10:
        if (r14 == r15) goto L12;
        boolean r16 = true;
    L13:
        this.mPageTransformer = r11;
        setChildrenDrawingOrderEnabled(r14);
        if (r14 == false) goto L18;
        if (r10 == false) goto L17;
        r13 = 2;
    L17:
        this.mDrawingOrder = r13;
        this.mPageTransformerLayerType = r12;
    L19:
        if (r16 == false) goto L22;
        populate();
        return;
    L22:
        return;
    L18:
        this.mDrawingOrder = 0;
        goto L19
    L12:
        r16 = false;
        goto L13
    L9:
        r15 = false;
        goto L10
    L5:
        r14 = false;
        goto L7
    }

    public void smoothScrollTo(int r10, int r11, int r12) {
        if (getChildCount() != 0) goto L6;
        setScrollingCacheEnabled(false);
        return;
    L6:
        Scroller r13 = this.mScroller;
        if (r13 != null) goto L9;
    L16:
        int r14 = getScrollX();
    L15:
        int r15 = r14;
        int r16 = getScrollY();
        int r17 = r10 - r15;
        int r18 = r11 - r16;
        if (r17 != 0) goto L22;
        if (r18 != 0) goto L22;
        b(false);
        populate();
        setScrollState(0);
        return;
    L22:
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int r19 = getClientWidth();
        int r110 = r19 / 2;
        float r20 = r19;
        float r111 = r110;
        float r112 = r111 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (Math.abs(r17) * 1.0f) / r20)) * r111);
        int r113 = Math.abs(r12);
        if (r113 <= 0) goto L25;
        int r21 = Math.round(Math.abs(r112 / r113) * 1000.0f) * 4;
    L26:
        int r22 = Math.min(r21, 600);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(r15, r16, r17, r18, r22);
        ViewCompat.g0(this);
        return;
    L25:
        r21 = (int) (((Math.abs(r17) / ((r20 * this.mAdapter.getPageWidth(this.mCurItem)) + this.mPageMargin)) + 1.0f) * 100.0f);
        goto L26
    L9:
        if (r13.isFinished() == true) goto L16;
        if (this.mIsScrollStarted == false) goto L13;
        r14 = this.mScroller.getCurrX();
    L14:
        this.mScroller.abortAnimation();
        setScrollingCacheEnabled(false);
        goto L15
    L13:
        r14 = this.mScroller.getStartX();
        goto L14
    }

    public void setCurrentItem(int r10, boolean r11) {
        this.mPopulatePending = false;
        setCurrentItemInternal(r10, r11, false);
    }

    public void setPageMarginDrawable(@DrawableRes int r10) {
        setPageMarginDrawable(ContextCompat.d(getContext(), r10));
    }

    public ViewPager(@NonNull Context r10, @Nullable AttributeSet r11) {
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
        this.mEndScrollRunnable = new c(this);
        this.mScrollState = 0;
        initViewPager();
    }
}
