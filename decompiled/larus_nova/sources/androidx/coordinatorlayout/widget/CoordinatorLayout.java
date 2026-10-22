package androidx.coordinatorlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import el9.a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent2, NestedScrollingParent3 {
    static final Class<?>[] CONSTRUCTOR_PARAMS = null;
    static final int EVENT_NESTED_SCROLL = 1;
    static final int EVENT_PRE_DRAW = 0;
    static final int EVENT_VIEW_REMOVED = 2;
    static final String TAG = "CoordinatorLayout";
    static final Comparator<View> TOP_SORTED_CHILDREN_COMPARATOR = null;
    private static final int TYPE_ON_INTERCEPT = 0;
    private static final int TYPE_ON_TOUCH = 1;
    static final String WIDGET_PACKAGE_NAME = null;
    static final ThreadLocal<Map<String, Constructor<Behavior>>> sConstructors = null;
    private static final Pools.Pool<Rect> sRectPool = null;
    private OnApplyWindowInsetsListener mApplyWindowInsetsListener;
    private final int[] mBehaviorConsumed;
    private View mBehaviorTouchView;
    private final DirectedAcyclicGraph<View> mChildDag;
    private final List<View> mDependencySortedChildren;
    private boolean mDisallowInterceptReset;
    private boolean mDrawStatusBarBackground;
    private boolean mIsAttachedToWindow;
    private int[] mKeylines;
    private WindowInsetsCompat mLastInsets;
    private boolean mNeedsPreDrawListener;
    private final NestedScrollingParentHelper mNestedScrollingParentHelper;
    private View mNestedScrollingTarget;
    private final int[] mNestedScrollingV2ConsumedCompat;
    ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
    private OnPreDrawListener mOnPreDrawListener;
    private Paint mScrimPaint;
    private Drawable mStatusBarBackground;
    private final List<View> mTempDependenciesList;
    private final List<View> mTempList1;

    public interface AttachedBehavior {
        Behavior getBehavior();
    }

    public static abstract class Behavior<V extends View> {
        public boolean getInsetDodgeRect(CoordinatorLayout r100, V r101, Rect r102) {
            return false;
        }

        public int getScrimColor(CoordinatorLayout r100, V r101) {
            return -16777216;
        }

        public float getScrimOpacity(CoordinatorLayout r100, V r101) {
            return 0.0f;
        }

        public boolean layoutDependsOn(CoordinatorLayout r100, V r101, View r102) {
            return false;
        }

        public WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout r100, V r101, WindowInsetsCompat r102) {
            return r102;
        }

        public void onAttachedToLayoutParams(LayoutParams r100) {
        }

        public boolean onDependentViewChanged(CoordinatorLayout r100, V r101, View r102) {
            return false;
        }

        public void onDependentViewRemoved(CoordinatorLayout r100, V r101, View r102) {
        }

        public void onDetachedFromLayoutParams() {
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout r100, V r101, MotionEvent r102) {
            return false;
        }

        public boolean onLayoutChild(CoordinatorLayout r100, V r101, int r102) {
            return false;
        }

        public boolean onMeasureChild(CoordinatorLayout r100, V r101, int r102, int r103, int r104, int r105) {
            return false;
        }

        public boolean onNestedFling(CoordinatorLayout r100, V r101, View r102, float r103, float r104, boolean r105) {
            return false;
        }

        public boolean onNestedPreFling(CoordinatorLayout r100, V r101, View r102, float r103, float r104) {
            return false;
        }

        public void onNestedPreScroll(CoordinatorLayout r100, V r101, View r102, int r103, int r104, int[] r105) {
        }

        public void onNestedScroll(CoordinatorLayout r100, V r101, View r102, int r103, int r104, int r105, int r106) {
        }

        public void onNestedScrollAccepted(CoordinatorLayout r100, V r101, View r102, View r103, int r104) {
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout r100, V r101, Rect r102, boolean r103) {
            return false;
        }

        public void onRestoreInstanceState(CoordinatorLayout r100, V r101, Parcelable r102) {
        }

        public boolean onStartNestedScroll(CoordinatorLayout r100, V r101, View r102, View r103, int r104) {
            return false;
        }

        public void onStopNestedScroll(CoordinatorLayout r100, V r101, View r102) {
        }

        public boolean onTouchEvent(CoordinatorLayout r100, V r101, MotionEvent r102) {
            return false;
        }

        public Behavior() {
        }

        public static Object getTag(View r100) {
            return ((LayoutParams) r100.getLayoutParams()).mBehaviorTag;
        }

        public Behavior(Context r100, AttributeSet r101) {
        }

        public static void setTag(View r100, Object r101) {
            ((LayoutParams) r100.getLayoutParams()).mBehaviorTag = r101;
        }

        public boolean blocksInteractionBelow(CoordinatorLayout r100, V r101) {
            if (getScrimOpacity(r100, r101) <= 0.0f) goto L5;
            return true;
        L5:
            return false;
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout r100, V r101) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        public void onStopNestedScroll(CoordinatorLayout r100, V r101, View r102, int r103) {
            if (r103 != 0) goto L5;
            onStopNestedScroll(r100, r101, r102);
            return;
        }

        public void onNestedScrollAccepted(CoordinatorLayout r100, V r101, View r102, View r103, int r104, int r105) {
            if (r105 != 0) goto L5;
            onNestedScrollAccepted(r100, r101, r102, r103, r104);
            return;
        }

        public boolean onStartNestedScroll(CoordinatorLayout r100, V r101, View r102, View r103, int r104, int r105) {
            if (r105 == 0) goto L4;
            return false;
        L4:
            return onStartNestedScroll(r100, r101, r102, r103, r104);
        }

        public void onNestedPreScroll(CoordinatorLayout r100, V r101, View r102, int r103, int r104, int[] r105, int r106) {
            if (r106 != 0) goto L5;
            onNestedPreScroll(r100, r101, r102, r103, r104, r105);
            return;
        }

        public void onNestedScroll(CoordinatorLayout r100, V r101, View r102, int r103, int r104, int r105, int r106, int r107) {
            if (r107 != 0) goto L5;
            onNestedScroll(r100, r101, r102, r103, r104, r105, r106);
            return;
        }

        public void onNestedScroll(CoordinatorLayout r100, V r101, View r102, int r103, int r104, int r105, int r106, int r110, int[] r111) {
            r111[0] = r111[0] + r105;
            r111[1] = r111[1] + r106;
            onNestedScroll(r100, r101, r102, r103, r104, r105, r106, r110);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface DefaultBehavior {
        Class<? extends Behavior> value();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DispatchChangeEvent {
    }

    public class HierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        final /* synthetic */ CoordinatorLayout this$0;

        public HierarchyChangeListener(CoordinatorLayout r100) {
            this.this$0 = r100;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View r100, View r101) {
            ViewGroup.OnHierarchyChangeListener r102 = this.this$0.mOnHierarchyChangeListener;
            if (r102 == null) goto L6;
            r102.onChildViewAdded(r100, r101);
            return;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View r100, View r101) {
            this.this$0.onChildViewsChanged(2);
            ViewGroup.OnHierarchyChangeListener r102 = this.this$0.mOnHierarchyChangeListener;
            if (r102 == null) goto L6;
            r102.onChildViewRemoved(r100, r101);
            return;
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int anchorGravity;
        public int dodgeInsetEdges;
        public int gravity;
        public int insetEdge;
        public int keyline;
        View mAnchorDirectChild;
        int mAnchorId;
        View mAnchorView;
        Behavior mBehavior;
        boolean mBehaviorResolved;
        Object mBehaviorTag;
        private boolean mDidAcceptNestedScrollNonTouch;
        private boolean mDidAcceptNestedScrollTouch;
        private boolean mDidBlockInteraction;
        private boolean mDidChangeAfterNestedScroll;
        int mInsetOffsetX;
        int mInsetOffsetY;
        final Rect mLastChildRect;

        public void invalidateAnchor() {
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
        }

        public void resetChangedAfterNestedScroll() {
            this.mDidChangeAfterNestedScroll = false;
        }

        public void resetTouchBehaviorTracking() {
            this.mDidBlockInteraction = false;
        }

        public boolean checkAnchorChanged() {
            if (this.mAnchorView == null) goto L5;
        L7:
            return false;
        L5:
            if (this.mAnchorId == (-1)) goto L7;
            return true;
        }

        public boolean didBlockInteraction() {
            if (this.mBehavior != null) goto L6;
            this.mDidBlockInteraction = false;
        L6:
            return this.mDidBlockInteraction;
        }

        public int getAnchorId() {
            return this.mAnchorId;
        }

        public Behavior getBehavior() {
            return this.mBehavior;
        }

        public boolean getChangedAfterNestedScroll() {
            return this.mDidChangeAfterNestedScroll;
        }

        public Rect getLastChildRect() {
            return this.mLastChildRect;
        }

        public LayoutParams(ViewGroup.LayoutParams r100) {
            super(r100);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        public boolean isNestedScrollAccepted(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return false;
        L8:
            return this.mDidAcceptNestedScrollNonTouch;
        L10:
            return this.mDidAcceptNestedScrollTouch;
        }

        public void resetNestedScroll(int r100) {
            setNestedScrollAccepted(r100, false);
        }

        public void setAnchorId(int r100) {
            invalidateAnchor();
            this.mAnchorId = r100;
        }

        public void setBehavior(Behavior r100) {
            Behavior r101 = this.mBehavior;
            if (r101 == r100) goto L10;
            if (r101 == null) goto L6;
            r101.onDetachedFromLayoutParams();
        L6:
            this.mBehavior = r100;
            this.mBehaviorTag = null;
            this.mBehaviorResolved = true;
            if (r100 == null) goto L11;
            r100.onAttachedToLayoutParams(this);
            return;
        L11:
            return;
        }

        public void setChangedAfterNestedScroll(boolean r100) {
            this.mDidChangeAfterNestedScroll = r100;
        }

        public void setLastChildRect(Rect r100) {
            this.mLastChildRect.set(r100);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r100) {
            super(r100);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        public LayoutParams(LayoutParams r100) {
            super(r100);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
            TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.layout_gravity, com.larus.nova.R.attr.layout_anchor, com.larus.nova.R.attr.layout_anchorGravity, com.larus.nova.R.attr.layout_behavior, com.larus.nova.R.attr.layout_dodgeInsetEdges, com.larus.nova.R.attr.layout_insetEdge, com.larus.nova.R.attr.layout_keyline});
            this.gravity = r102.getInteger(0, 0);
            this.mAnchorId = r102.getResourceId(1, -1);
            this.anchorGravity = r102.getInteger(2, 0);
            this.keyline = r102.getInteger(6, -1);
            this.insetEdge = r102.getInt(5, 0);
            this.dodgeInsetEdges = r102.getInt(4, 0);
            boolean r103 = r102.hasValue(3);
            this.mBehaviorResolved = r103;
            if (r103 == false) goto L5;
            this.mBehavior = CoordinatorLayout.parseBehavior(r100, r101, r102.getString(3));
        L5:
            r102.recycle();
            Behavior r104 = this.mBehavior;
            if (r104 == null) goto L9;
            r104.onAttachedToLayoutParams(this);
            return;
        }

        private void resolveAnchorView(View r100, CoordinatorLayout r101) {
            View r102 = r101.findViewById(this.mAnchorId);
            this.mAnchorView = r102;
            if (r102 == null) goto L28;
            if (r102 == r101) goto L6;
            ViewParent r103 = r102.getParent();
        L12:
            if (r103 == r101) goto L25;
            if (r103 == null) goto L25;
            if (r103 == r100) goto L16;
            if ((r103 instanceof View) == false) goto L24;
            r102 = r103;
        L24:
            r103 = r103.getParent();
            goto L12
        L16:
            if (r101.isInEditMode() == false) goto L20;
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return;
        L20:
            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
        L25:
            this.mAnchorDirectChild = r102;
            return;
        L6:
            if (r101.isInEditMode() == false) goto L10;
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return;
        L10:
            throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
        L28:
            if (r101.isInEditMode() == false) goto L32;
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return;
        L32:
            throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + r101.getResources().getResourceName(this.mAnchorId) + " to anchor view " + r100);
        }

        private boolean shouldDodge(View r100, int r101) {
            int r102 = GravityCompat.getAbsoluteGravity(((LayoutParams) r100.getLayoutParams()).insetEdge, r101);
            if (r102 != 0) goto L5;
        L7:
            return false;
        L5:
            if ((GravityCompat.getAbsoluteGravity(this.dodgeInsetEdges, r101) & r102) != r102) goto L7;
            return true;
        }

        private boolean verifyAnchorView(View r100, CoordinatorLayout r101) {
            if (this.mAnchorView.getId() == this.mAnchorId) goto L5;
            return false;
        L5:
            View r102 = this.mAnchorView;
            ViewParent r103 = r102.getParent();
        L6:
            if (r103 == r101) goto L16;
            if (r103 == null) goto L14;
            if (r103 == r100) goto L14;
            if ((r103 instanceof View) == false) goto L13;
            r102 = r103;
        L13:
            r103 = r103.getParent();
        L14:
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return false;
        L16:
            this.mAnchorDirectChild = r102;
            return true;
        }

        public View findAnchorView(CoordinatorLayout r100, View r101) {
            if (this.mAnchorId != (-1)) goto L7;
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return null;
        L7:
            if (this.mAnchorView != null) goto L9;
        L10:
            resolveAnchorView(r101, r100);
        L12:
            return this.mAnchorView;
        L9:
            if (verifyAnchorView(r101, r100) == true) goto L12;
            goto L10
        }

        public boolean isBlockingInteractionBelow(CoordinatorLayout r100, View r101) {
            boolean r102 = this.mDidBlockInteraction;
            if (r102 == false) goto L6;
            return true;
        L6:
            Behavior r103 = this.mBehavior;
            if (r103 == null) goto L9;
            boolean r104 = r103.blocksInteractionBelow(r100, r101);
        L10:
            boolean r105 = r104 | r102;
            this.mDidBlockInteraction = r105;
            return r105;
        L9:
            r104 = false;
            goto L10
        }

        public void setNestedScrollAccepted(int r100, boolean r101) {
            if (r100 != 0) goto L4;
            this.mDidAcceptNestedScrollTouch = r101;
            return;
        L4:
            if (r100 != 1) goto L10;
            this.mDidAcceptNestedScrollNonTouch = r101;
            return;
        }

        public LayoutParams(int r100, int r101) {
            super(r100, r101);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        public boolean dependsOn(CoordinatorLayout r100, View r101, View r102) {
            if (r102 != this.mAnchorDirectChild) goto L5;
        L12:
            return true;
        L5:
            if (shouldDodge(r102, ViewCompat.getLayoutDirection(r100)) == true) goto L12;
            Behavior r103 = this.mBehavior;
            if (r103 != null) goto L9;
        L11:
            return false;
        L9:
            if (r103.layoutDependsOn(r100, r101, r102) == false) goto L11;
            goto L11
        }
    }

    public class OnPreDrawListener implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ CoordinatorLayout this$0;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.this$0.onChildViewsChanged(0);
            return true;
        }

        public OnPreDrawListener(CoordinatorLayout r100) {
            this.this$0 = r100;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        SparseArray<Parcelable> behaviorStates;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        public SavedState(Parcel r100, ClassLoader r101) {
            super(r100, r101);
            int r102 = r100.readInt();
            int[] r103 = new int[r102];
            r100.readIntArray(r103);
            Parcelable[] r104 = r100.readParcelableArray(r101);
            this.behaviorStates = new SparseArray(r102);
            int r105 = 0;
        L3:
            if (r105 >= r102) goto L5;
            this.behaviorStates.append(r103[r105], r104[r105]);
            r105 = r105 + 1;
            goto L3
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            SparseArray<Parcelable> r102 = this.behaviorStates;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = r102.size();
        L6:
            r100.writeInt(r104);
            int[] r105 = new int[r104];
            Parcelable[] r106 = new Parcelable[r104];
        L7:
            if (r103 >= r104) goto L9;
            r105[r103] = this.behaviorStates.keyAt(r103);
            r106[r103] = this.behaviorStates.valueAt(r103);
            r103 = r103 + 1;
            goto L7
        L9:
            r100.writeIntArray(r105);
            r100.writeParcelableArray(r106, r101);
            return;
        L5:
            r104 = 0;
            goto L6
        }
    }

    public static class ViewElevationComparator implements Comparator<View> {
        public ViewElevationComparator() {
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(View r100, View r101) {
            float r102 = ViewCompat.getZ(r100);
            float r103 = ViewCompat.getZ(r101);
            if (r102 <= r103) goto L7;
            return -1;
        L7:
            if (r102 >= r103) goto L10;
            return 1;
        L10:
            return 0;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(View r100, View r101) {
            return compare2(r100, r101);
        }
    }

    public static /* synthetic */ Class access$000(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        return Class.forName(r100, r101, r102);
    }

    private static int clamp(int r100, int r101, int r102) {
        if (r100 >= r101) goto L4;
        return r101;
    L4:
        if (r100 <= r102) goto L6;
        return r102;
    L6:
        return r100;
    }

    private static int resolveAnchoredChildGravity(int r100) {
        if (r100 != 0) goto L5;
        return 17;
    L5:
        return r100;
    }

    private static int resolveGravity(int r100) {
        if ((r100 & 7) != 0) goto L6;
        r100 = r100 | GravityCompat.START;
    L6:
        if ((r100 & 112) == 0) goto L8;
        return r100;
    L8:
        return r100 | 48;
    }

    private static int resolveKeylineGravity(int r100) {
        if (r100 != 0) goto L5;
        return 8388661;
    L5:
        return r100;
    }

    static {
        Package r100 = CoordinatorLayout.class.getPackage();
        if (r100 == null) goto L5;
        String r101 = r100.getName();
    L6:
        WIDGET_PACKAGE_NAME = r101;
        TOP_SORTED_CHILDREN_COMPARATOR = new ViewElevationComparator();
        CONSTRUCTOR_PARAMS = new Class[]{Context.class, AttributeSet.class};
        sConstructors = new ThreadLocal();
        sRectPool = new Pools.SynchronizedPool(12);
        return;
    L5:
        r101 = null;
        goto L6
    }

    private static Rect acquireTempRect() {
        Rect r100 = sRectPool.acquire();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new Rect();
    }

    private void prepareChildren() {
        this.mDependencySortedChildren.clear();
        this.mChildDag.clear();
        int r100 = getChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L16;
        View r102 = getChildAt(r101);
        LayoutParams r103 = getResolvedLayoutParams(r102);
        r103.findAnchorView(this, r102);
        this.mChildDag.addNode(r102);
        int r104 = 0;
    L5:
        if (r104 >= r100) goto L15;
        if (r104 == r101) goto L14;
        View r105 = getChildAt(r104);
        if (r103.dependsOn(this, r102, r105) == false) goto L14;
        if (this.mChildDag.contains(r105) == true) goto L13;
        this.mChildDag.addNode(r105);
    L13:
        this.mChildDag.addEdge(r105, r102);
    L14:
        r104 = r104 + 1;
        goto L5
    L15:
        r101 = r101 + 1;
        goto L3
    L16:
        this.mDependencySortedChildren.addAll(this.mChildDag.getSortedList());
        Collections.reverse(this.mDependencySortedChildren);
    }

    public void addPreDrawListener() {
        if (this.mIsAttachedToWindow == true) goto L5;
    L8:
        this.mNeedsPreDrawListener = true;
        return;
    L5:
        if (this.mOnPreDrawListener != null) goto L7;
        this.mOnPreDrawListener = new OnPreDrawListener(this);
    L7:
        getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        goto L8
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> r101 = new SparseArray();
        int r102 = getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        View r104 = getChildAt(r103);
        int r105 = r104.getId();
        Behavior r106 = ((LayoutParams) r104.getLayoutParams()).getBehavior();
        if (r105 == (-1)) goto L10;
        if (r106 == null) goto L10;
        Parcelable r107 = r106.onSaveInstanceState(this, r104);
        if (r107 == null) goto L10;
        r101.append(r105, r107);
    L10:
        r103 = r103 + 1;
        goto L3
    L11:
        r100.behaviorStates = r101;
        return r100;
    }

    public void removePreDrawListener() {
        if (this.mIsAttachedToWindow == true) goto L5;
    L7:
        this.mNeedsPreDrawListener = false;
        return;
    L5:
        if (this.mOnPreDrawListener == null) goto L7;
        getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        goto L7
    }

    private void setupForInsets() {
        if (ViewCompat.getFitsSystemWindows(this) == true) goto L5;
        ViewCompat.setOnApplyWindowInsetsListener(this, null);
        return;
    L5:
        if (this.mApplyWindowInsetsListener != null) goto L7;
        this.mApplyWindowInsetsListener = new AnonymousClass1(this);
    L7:
        ViewCompat.setOnApplyWindowInsetsListener(this, this.mApplyWindowInsetsListener);
        setSystemUiVisibility(1280);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r100 = getDrawableState();
        Drawable r101 = this.mStatusBarBackground;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        if (r102 == false) goto L10;
        invalidate();
        return;
    L10:
        return;
    L5:
        if (r101.isStateful() == false) goto L7;
        r102 = false | r101.setState(r100);
        goto L7
    }

    public void ensurePreDrawListener() {
        int r100 = getChildCount();
        boolean r101 = false;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L9;
        if (hasDependencies(getChildAt(r102)) == true) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        r101 = true;
    L9:
        if (r101 == this.mNeedsPreDrawListener) goto L16;
        if (r101 == false) goto L12;
        addPreDrawListener();
        return;
    L12:
        removePreDrawListener();
        return;
    }

    public final List<View> getDependencySortedChildren() {
        prepareChildren();
        return Collections.unmodifiableList(this.mDependencySortedChildren);
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener == false) goto L9;
        if (this.mOnPreDrawListener != null) goto L7;
        this.mOnPreDrawListener = new OnPreDrawListener(this);
    L7:
        getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
    L9:
        if (this.mLastInsets == null) goto L11;
    L13:
        this.mIsAttachedToWindow = true;
        return;
    L11:
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L13;
        ViewCompat.requestApplyInsets(this);
        goto L13
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener == true) goto L5;
    L7:
        View r100 = this.mNestedScrollingTarget;
        if (r100 == null) goto L10;
        onStopNestedScroll(r100);
    L10:
        this.mIsAttachedToWindow = false;
        return;
    L5:
        if (this.mOnPreDrawListener == null) goto L7;
        getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        goto L7
    }

    public final WindowInsetsCompat getLastWindowInsets() {
        return this.mLastInsets;
    }

    public Drawable getStatusBarBackground() {
        return this.mStatusBarBackground;
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    public CoordinatorLayout(Context r100) {
        this(r100, null);
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_coordinatorlayout_widget_CoordinatorLayout_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private WindowInsetsCompat dispatchApplyWindowInsetsToBehaviors(WindowInsetsCompat r100) {
        if (r100.isConsumed() == false) goto L5;
        return r100;
    L5:
        int r101 = getChildCount();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L15;
        View r103 = getChildAt(r102);
        if (ViewCompat.getFitsSystemWindows(r103) == false) goto L14;
        Behavior r104 = ((LayoutParams) r103.getLayoutParams()).getBehavior();
        if (r104 == null) goto L14;
        r100 = r104.onApplyWindowInsets(this, r103, r100);
        if (r100.isConsumed() == true) goto L15;
    L14:
        r102 = r102 + 1;
    L15:
        return r100;
    }

    private int getKeyline(int r100) {
        int[] r101 = this.mKeylines;
        if (r101 != null) goto L6;
        toString();
        return 0;
    L6:
        if (r100 >= 0) goto L8;
    L12:
        toString();
        return 0;
    L8:
        if (r100 >= r101.length) goto L12;
        return r101[r100];
    }

    private void getTopSortedChildren(List<View> r100) {
        r100.clear();
        boolean r101 = isChildrenDrawingOrderEnabled();
        int r102 = getChildCount();
        int r103 = r102 - 1;
    L3:
        if (r103 < 0) goto L8;
        if (r101 == false) goto L6;
        int r104 = getChildDrawingOrder(r102, r103);
    L7:
        r100.add(getChildAt(r104));
        r103 = r103 - 1;
        goto L3
    L6:
        r104 = r103;
        goto L7
    L8:
        Comparator<View> r105 = TOP_SORTED_CHILDREN_COMPARATOR;
        if (r105 == null) goto L15;
        Collections.sort(r100, r105);
        return;
    }

    private boolean hasDependencies(View r100) {
        return this.mChildDag.hasOutgoingEdges(r100);
    }

    private static void releaseTempRect(Rect r100) {
        r100.setEmpty();
        sRectPool.release(r100);
    }

    private void resetTouchBehaviors(boolean r110) {
        int r100 = getChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L12;
        View r102 = getChildAt(r101);
        Behavior r103 = ((LayoutParams) r102.getLayoutParams()).getBehavior();
        if (r103 == null) goto L11;
        long r104 = SystemClock.uptimeMillis();
        MotionEvent r105 = MotionEvent.obtain(r104, r104, 3, 0.0f, 0.0f, 0);
        if (r110 == false) goto L9;
        r103.onInterceptTouchEvent(this, r102, r105);
    L10:
        r105.recycle();
        goto L11
    L9:
        r103.onTouchEvent(this, r102, r105);
    L11:
        r101 = r101 + 1;
        goto L3
    L12:
        int r111 = 0;
    L13:
        if (r111 >= r100) goto L15;
        ((LayoutParams) getChildAt(r111).getLayoutParams()).resetTouchBehaviorTracking();
        r111 = r111 + 1;
        goto L13
    L15:
        this.mBehaviorTouchView = null;
        this.mDisallowInterceptReset = false;
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

    public void dispatchDependentViewsChanged(View r100) {
        List r101 = this.mChildDag.getIncomingEdges(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isEmpty() == true) goto L17;
        int r102 = 0;
    L8:
        if (r102 >= r101.size()) goto L18;
        View r103 = (View) ListProtector.get(r101, r102);
        Behavior r104 = ((LayoutParams) r103.getLayoutParams()).getBehavior();
        if (r104 == null) goto L12;
        r104.onDependentViewChanged(this, r103, r100);
    L12:
        r102 = r102 + 1;
        goto L8
    L18:
        return;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        if ((r100 instanceof LayoutParams) == false) goto L7;
        return new LayoutParams((LayoutParams) r100);
    L7:
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r100);
    L11:
        return new LayoutParams(r100);
    }

    public List<View> getDependencies(View r100) {
        List<View> r101 = this.mChildDag.getOutgoingEdges(r100);
        this.mTempDependenciesList.clear();
        if (r101 == null) goto L6;
        this.mTempDependenciesList.addAll(r101);
    L6:
        return this.mTempDependenciesList;
    }

    public List<View> getDependents(View r100) {
        List r101 = this.mChildDag.getIncomingEdges(r100);
        this.mTempDependenciesList.clear();
        if (r101 == null) goto L6;
        this.mTempDependenciesList.addAll(r101);
    L6:
        return this.mTempDependenciesList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LayoutParams getResolvedLayoutParams(View r100) {
        LayoutParams r101 = (LayoutParams) r100.getLayoutParams();
        if (r101.mBehaviorResolved == false) goto L5;
    L17:
        return r101;
    L5:
        if ((r100 instanceof AttachedBehavior) == false) goto L7;
        r101.setBehavior(((AttachedBehavior) r100).getBehavior());
        r101.mBehaviorResolved = true;
        goto L17
    L7:
        Class<?> r102 = r100.getClass();
        DefaultBehavior r103 = null;
    L8:
        if (r102 == null) goto L12;
        r103 = (DefaultBehavior) r102.getAnnotation(DefaultBehavior.class);
        if (r103 != null) goto L12;
        r102 = r102.getSuperclass();
    L12:
        if (r103 != null) goto L18;
    L16:
        r101.mBehaviorResolved = true;
        goto L17
    L18:
        r101.setBehavior(r103.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));     // Catch: Exception -> L15
    L15:
        r103.value().getName();
        goto L16
    }

    public final void onChildViewsChanged(int r110) {
        int r100 = ViewCompat.getLayoutDirection(this);
        int r101 = this.mDependencySortedChildren.size();
        Rect r102 = acquireTempRect();
        Rect r103 = acquireTempRect();
        Rect r104 = acquireTempRect();
        int r105 = 0;
    L3:
        if (r105 >= r101) goto L61;
        View r106 = (View) ListProtector.get(this.mDependencySortedChildren, r105);
        LayoutParams r111 = (LayoutParams) r106.getLayoutParams();
        if (r110 == 0) goto L7;
    L9:
        int r112 = 0;
    L10:
        if (r112 >= r105) goto L15;
        View r113 = (View) ListProtector.get(this.mDependencySortedChildren, r112);
        if (r111.mAnchorDirectChild != r113) goto L14;
        offsetChildToAnchor(r106, r100);
    L14:
        r112 = r112 + 1;
        goto L10
    L15:
        getChildRect(r106, true, r103);
        if (r111.insetEdge == 0) goto L34;
        if (r103.isEmpty() == true) goto L34;
        int r114 = GravityCompat.getAbsoluteGravity(r111.insetEdge, r100);
        int r115 = r114 & 112;
        if (r115 != 48) goto L22;
        r102.top = Math.max(r102.top, r103.bottom);
    L26:
        int r116 = r114 & 7;
        if (r116 != 3) goto L29;
        r102.left = Math.max(r102.left, r103.right);
        goto L34
    L29:
        if (r116 != 5) goto L34;
        r102.right = Math.max(r102.right, getWidth() - r103.left);
        goto L34
    L22:
        if (r115 != 80) goto L26;
        r102.bottom = Math.max(r102.bottom, getHeight() - r103.top);
    L34:
        if (r111.dodgeInsetEdges == 0) goto L39;
        if (r106.getVisibility() != 0) goto L39;
        offsetChildByInset(r106, r102, r100);
    L39:
        if (r110 == 2) goto L44;
        getLastChildRect(r106, r104);
        if (r104.equals(r103) == true) goto L60;
        recordLastChildRect(r106, r103);
    L60:
        r105 = r105 + 1;
    L44:
        int r117 = r105 + 1;
    L45:
        if (r117 >= r101) goto L60;
        View r118 = (View) ListProtector.get(this.mDependencySortedChildren, r117);
        LayoutParams r119 = (LayoutParams) r118.getLayoutParams();
        Behavior r120 = r119.getBehavior();
        if (r120 == null) goto L59;
        if (r120.layoutDependsOn(this, r118, r106) == false) goto L59;
        if (r110 == 0) goto L52;
    L54:
        if (r110 == 2) goto L56;
        boolean r121 = r120.onDependentViewChanged(this, r118, r106);
    L57:
        if (r110 != 1) goto L59;
        r119.setChangedAfterNestedScroll(r121);
        goto L59
    L56:
        r120.onDependentViewRemoved(this, r118, r106);
        r121 = true;
        goto L57
    L52:
        if (r119.getChangedAfterNestedScroll() == false) goto L54;
        r119.resetChangedAfterNestedScroll();
    L59:
        r117 = r117 + 1;
        goto L45
    L7:
        if (r106.getVisibility() != 8) goto L9;
    L61:
        releaseTempRect(r102);
        releaseTempRect(r103);
        releaseTempRect(r104);
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
        super.onDraw(r100);
        if (this.mDrawStatusBarBackground == true) goto L5;
        return;
    L5:
        if (this.mStatusBarBackground == null) goto L14;
        WindowInsetsCompat r101 = this.mLastInsets;
        if (r101 == null) goto L9;
        int r102 = r101.getSystemWindowInsetTop();
    L10:
        if (r102 <= 0) goto L15;
        this.mStatusBarBackground.setBounds(0, 0, getWidth(), r102);
        this.mStatusBarBackground.draw(r100);
        return;
    L15:
        return;
    L9:
        r102 = 0;
        goto L10
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r100) {
        int r101 = r100.getActionMasked();
        if (r101 != 0) goto L5;
        resetTouchBehaviors(true);
    L5:
        boolean r102 = performIntercept(r100, 0);
        if (r101 != 1) goto L8;
    L9:
        resetTouchBehaviors(true);
    L10:
        return r102;
    L8:
        if (r101 != 3) goto L10;
        goto L9
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r100);
        return;
    L6:
        SavedState r101 = (SavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        SparseArray<Parcelable> r102 = r101.behaviorStates;
        int r103 = getChildCount();
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L15;
        View r105 = getChildAt(r104);
        int r106 = r105.getId();
        Behavior r107 = getResolvedLayoutParams(r105).getBehavior();
        if (r106 == (-1)) goto L14;
        if (r107 == null) goto L14;
        Parcelable r108 = r102.get(r106);
        if (r108 == null) goto L14;
        r107.onRestoreInstanceState(this, r105, r108);
    L14:
        r104 = r104 + 1;
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View r100) {
        onStopNestedScroll(r100, 0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r110) {
        int r100 = r110.getActionMasked();
        if (this.mBehaviorTouchView != null) goto L7;
        boolean r101 = performIntercept(r110, 1);
        if (r101 == true) goto L8;
    L11:
        boolean r102 = false;
    L12:
        MotionEvent r103 = null;
        if (this.mBehaviorTouchView != null) goto L15;
        r102 = r102 | super.onTouchEvent(r110);
    L17:
        if (r103 == null) goto L19;
        r103.recycle();
    L19:
        if (r100 != 1) goto L21;
    L22:
        resetTouchBehaviors(false);
    L23:
        return r102;
    L21:
        if (r100 != 3) goto L23;
    L15:
        if (r101 == false) goto L17;
        long r111 = SystemClock.uptimeMillis();
        r103 = MotionEvent.obtain(r111, r111, 3, 0.0f, 0.0f, 0);
        super.onTouchEvent(r103);
    L8:
        Behavior r104 = ((LayoutParams) this.mBehaviorTouchView.getLayoutParams()).getBehavior();
        if (r104 == null) goto L11;
        r102 = r104.onTouchEvent(this, this.mBehaviorTouchView, r110);
        goto L12
    L7:
        r101 = false;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r100) {
        super.requestDisallowInterceptTouchEvent(r100);
        if (r100 == true) goto L5;
        return;
    L5:
        if (this.mDisallowInterceptReset == true) goto L9;
        resetTouchBehaviors(false);
        this.mDisallowInterceptReset = true;
        return;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean r100) {
        super.setFitsSystemWindows(r100);
        setupForInsets();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener r100) {
        this.mOnHierarchyChangeListener = r100;
    }

    public void setStatusBarBackground(Drawable r100) {
        Drawable r101 = this.mStatusBarBackground;
        if (r101 == r100) goto L21;
        Drawable r102 = null;
        if (r101 == null) goto L7;
        r101.setCallback(null);
    L7:
        if (r100 == null) goto L9;
        r102 = r100.mutate();
    L9:
        this.mStatusBarBackground = r102;
        if (r102 != null) goto L12;
    L19:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L12:
        if (r102.isStateful() == false) goto L14;
        this.mStatusBarBackground.setState(getDrawableState());
    L14:
        DrawableCompat.setLayoutDirection(this.mStatusBarBackground, ViewCompat.getLayoutDirection(this));
        Drawable r103 = this.mStatusBarBackground;
        if (getVisibility() != 0) goto L17;
        boolean r104 = true;
    L18:
        r103.setVisible(r104, false);
        this.mStatusBarBackground.setCallback(this);
        goto L19
    L17:
        r104 = false;
        goto L18
    }

    public void setStatusBarBackgroundColor(int r100) {
        setStatusBarBackground(new ColorDrawable(r100));
    }

    public void setStatusBarBackgroundResource(int r100) {
        if (r100 == 0) goto L4;
        Drawable r101 = ContextCompat.getDrawable(getContext(), r100);
    L5:
        setStatusBarBackground(r101);
        return;
    L4:
        r101 = null;
        goto L5
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (r100 != 0) goto L5;
        boolean r101 = true;
    L6:
        Drawable r102 = this.mStatusBarBackground;
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.isVisible() == r101) goto L13;
        this.mStatusBarBackground.setVisible(r101, false);
        return;
    L13:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final WindowInsetsCompat setWindowInsets(WindowInsetsCompat r100) {
        if (ObjectsCompat.equals(this.mLastInsets, r100) == true) goto L18;
        this.mLastInsets = r100;
        boolean r101 = true;
        if (r100 != null) goto L7;
    L9:
        boolean r102 = false;
    L10:
        this.mDrawStatusBarBackground = r102;
        if (r102 == false) goto L13;
    L15:
        r101 = false;
    L16:
        setWillNotDraw(r101);
        WindowInsetsCompat r103 = dispatchApplyWindowInsetsToBehaviors(r100);
        requestLayout();
        return r103;
    L13:
        if (getBackground() != null) goto L15;
    L7:
        if (r100.getSystemWindowInsetTop() <= 0) goto L9;
        r102 = true;
        goto L10
    L18:
        return r100;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable r100) {
        if (super.verifyDrawable(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (r100 == this.mStatusBarBackground) goto L8;
        return false;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return generateLayoutParams(r100);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return generateLayoutParams(r100);
    }

    public CoordinatorLayout(Context r100, AttributeSet r101) {
        this(r100, r101, com.larus.nova.R.attr.coordinatorLayoutStyle);
    }

    private void layoutChild(View r110, int r111) {
        LayoutParams r100 = (LayoutParams) r110.getLayoutParams();
        Rect r101 = acquireTempRect();
        r101.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r100).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) r100).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) r100).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) r100).bottomMargin);
        if (this.mLastInsets != null) goto L5;
    L9:
        Rect r102 = acquireTempRect();
        GravityCompat.apply(resolveGravity(r100.gravity), r110.getMeasuredWidth(), r110.getMeasuredHeight(), r101, r102, r111);
        r110.layout(r102.left, r102.top, r102.right, r102.bottom);
        releaseTempRect(r101);
        releaseTempRect(r102);
        return;
    L5:
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L9;
        if (ViewCompat.getFitsSystemWindows(r110) == true) goto L9;
        r101.left += this.mLastInsets.getSystemWindowInsetLeft();
        r101.top += this.mLastInsets.getSystemWindowInsetTop();
        r101.right -= this.mLastInsets.getSystemWindowInsetRight();
        r101.bottom -= this.mLastInsets.getSystemWindowInsetBottom();
        goto L9
    }

    private boolean performIntercept(MotionEvent r210, int r211) {
        int r100 = r210.getActionMasked();
        List<View> r101 = this.mTempList1;
        getTopSortedChildren(r101);
        int r102 = r101.size();
        MotionEvent r103 = null;
        int r104 = 0;
        boolean r105 = false;
        boolean r110 = false;
    L3:
        if (r104 >= r102) goto L34;
        View r111 = (View) ListProtector.get(r101, r104);
        LayoutParams r112 = (LayoutParams) r111.getLayoutParams();
        Behavior r113 = r112.getBehavior();
        if (r105 == true) goto L7;
        if (r110 == true) goto L7;
    L16:
        if (r105 == true) goto L25;
        if (r113 == null) goto L25;
        if (r211 == 0) goto L22;
        if (r211 != 1) goto L23;
        r105 = r113.onTouchEvent(this, r111, r210);
    L23:
        if (r105 == false) goto L25;
        this.mBehaviorTouchView = r111;
        goto L25
    L22:
        r105 = r113.onInterceptTouchEvent(this, r111, r210);
    L25:
        boolean r114 = r112.didBlockInteraction();
        boolean r115 = r112.isBlockingInteractionBelow(this, r111);
        if (r115 == false) goto L29;
        if (r114 == true) goto L29;
        r110 = true;
    L30:
        if (r115 == false) goto L33;
        if (r110 == false) goto L34;
    L33:
        r104 = r104 + 1;
    L29:
        r110 = false;
    L7:
        if (r100 == 0) goto L16;
        if (r113 == null) goto L33;
        if (r103 != null) goto L11;
        long r116 = SystemClock.uptimeMillis();
        r103 = MotionEvent.obtain(r116, r116, 3, 0.0f, 0.0f, 0);
    L11:
        if (r211 == 0) goto L15;
        if (r211 != 1) goto L33;
        r113.onTouchEvent(this, r111, r103);
        goto L33
    L15:
        r113.onInterceptTouchEvent(this, r111, r103);
    L34:
        r101.clear();
        return r105;
    }

    private void setInsetOffsetX(View r100, int r101) {
        LayoutParams r102 = (LayoutParams) r100.getLayoutParams();
        int r103 = r102.mInsetOffsetX;
        if (r103 == r101) goto L6;
        ViewCompat.offsetLeftAndRight(r100, r101 - r103);
        r102.mInsetOffsetX = r101;
        return;
    }

    private void setInsetOffsetY(View r100, int r101) {
        LayoutParams r102 = (LayoutParams) r100.getLayoutParams();
        int r103 = r102.mInsetOffsetY;
        if (r103 == r101) goto L6;
        ViewCompat.offsetTopAndBottom(r100, r101 - r103);
        r102.mInsetOffsetY = r101;
        return;
    }

    public boolean doViewsOverlap(View r100, View r101) {
        boolean r102 = false;
        if (r100.getVisibility() == 0) goto L5;
    L29:
        return false;
    L5:
        if (r101.getVisibility() != 0) goto L29;
        Rect r103 = acquireTempRect();
        if (r100.getParent() == this) goto L9;
        boolean r104 = true;
    L10:
        getChildRect(r100, r104, r103);
        Rect r105 = acquireTempRect();
        if (r101.getParent() == this) goto L13;
        boolean r106 = true;
    L14:
        getChildRect(r101, r106, r105);
    L26:
        th = move-exception;
        releaseTempRect(r103);
        releaseTempRect(r105);
        throw th;
    L16:
        if (r103.left <= r105.right) goto L18;
    L24:
        releaseTempRect(r103);
        releaseTempRect(r105);
        return r102;
    L18:
        if (r103.top > r105.bottom) goto L24;
        if (r103.right < r105.left) goto L24;
        if (r103.bottom < r105.top) goto L24;
        r102 = true;
        goto L24
    L13:
        r106 = false;
        goto L14
    L9:
        r104 = false;
        goto L10
    }

    public void getDescendantRect(View r100, Rect r101) {
        ViewGroupUtils.getDescendantRect(this, r100, r101);
    }

    public void getLastChildRect(View r100, Rect r101) {
        r101.set(((LayoutParams) r100.getLayoutParams()).getLastChildRect());
    }

    public void offsetChildToAnchor(View r110, int r111) {
        LayoutParams r112 = (LayoutParams) r110.getLayoutParams();
        if (r112.mAnchorView == null) goto L20;
        Rect r113 = acquireTempRect();
        Rect r114 = acquireTempRect();
        Rect r115 = acquireTempRect();
        getDescendantRect(r112.mAnchorView, r113);
        boolean r116 = false;
        getChildRect(r110, false, r114);
        int r117 = r110.getMeasuredWidth();
        int r100 = r110.getMeasuredHeight();
        getDesiredAnchoredChildRectWithoutConstraints(r110, r111, r113, r115, r112, r117, r100);
        if (r115.left == r114.left) goto L7;
    L8:
        r116 = true;
    L9:
        constrainChildRect(r112, r115, r117, r100);
        int r101 = r115.left - r114.left;
        int r102 = r115.top - r114.top;
        if (r101 == 0) goto L12;
        ViewCompat.offsetLeftAndRight(r110, r101);
    L12:
        if (r102 == 0) goto L14;
        ViewCompat.offsetTopAndBottom(r110, r102);
    L14:
        if (r116 == false) goto L18;
        Behavior r103 = r112.getBehavior();
        if (r103 == null) goto L18;
        r103.onDependentViewChanged(this, r110, r112.mAnchorView);
    L18:
        releaseTempRect(r113);
        releaseTempRect(r114);
        releaseTempRect(r115);
        return;
    L7:
        if (r115.top == r114.top) goto L9;
    }

    public void onLayoutChild(View r100, int r101) {
        LayoutParams r102 = (LayoutParams) r100.getLayoutParams();
        if (r102.checkAnchorChanged() == true) goto L13;
        View r103 = r102.mAnchorView;
        if (r103 == null) goto L7;
        layoutChildWithAnchor(r100, r103, r101);
        return;
    L7:
        int r104 = r102.keyline;
        if (r104 < 0) goto L10;
        layoutChildWithKeyline(r100, r104, r101);
        return;
    L10:
        layoutChild(r100, r101);
        return;
    L13:
        throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
    }

    @Override // android.view.View
    public void onMeasure(int r310, int r311) {
        prepareChildren();
        ensurePreDrawListener();
        int r100 = getPaddingLeft();
        int r101 = getPaddingTop();
        int r102 = getPaddingRight();
        int r103 = getPaddingBottom();
        int r110 = ViewCompat.getLayoutDirection(this);
        if (r110 != 1) goto L5;
        boolean r111 = true;
    L6:
        int r112 = View.MeasureSpec.getMode(r310);
        int r113 = View.MeasureSpec.getSize(r310);
        int r114 = View.MeasureSpec.getMode(r311);
        int r115 = View.MeasureSpec.getSize(r311);
        int r116 = r100 + r102;
        int r117 = r101 + r103;
        int r104 = getSuggestedMinimumWidth();
        int r105 = getSuggestedMinimumHeight();
        if (this.mLastInsets != null) goto L9;
    L11:
        boolean r118 = false;
    L12:
        int r106 = this.mDependencySortedChildren.size();
        int r107 = r104;
        int r108 = r105;
        int r109 = 0;
        int r119 = 0;
    L13:
        if (r119 >= r106) goto L49;
        View r210 = (View) ListProtector.get(this.mDependencySortedChildren, r119);
        if (r210.getVisibility() != 8) goto L17;
        int r211 = r119;
        int r212 = r106;
        int r213 = r100;
    L48:
        r119 = r211 + 1;
        r100 = r213;
        r106 = r212;
        goto L13
    L17:
        LayoutParams r120 = (LayoutParams) r210.getLayoutParams();
        int r121 = r120.keyline;
        if (r121 < 0) goto L33;
        if (r112 == 0) goto L33;
        int r122 = getKeyline(r121);
        int r123 = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(r120.gravity), r110) & 7;
        int r214 = r109;
        if (r123 != 3) goto L24;
        if (r111 == true) goto L24;
    L26:
        int r215 = Math.max(0, (r113 - r102) - r122);
    L35:
        if (r118 == true) goto L37;
    L39:
        int r124 = r310;
        int r216 = r311;
    L40:
        Behavior r125 = r120.getBehavior();
        if (r125 == null) goto L45;
        LayoutParams r217 = r120;
        int r218 = r214;
        r211 = r119;
        int r219 = r108;
        r213 = r100;
        int r126 = r107;
        r212 = r106;
        if (r125.onMeasureChild(this, r210, r124, r215, r216, 0) == false) goto L46;
    L47:
        LayoutParams r127 = r217;
        int r128 = Math.max(r126, ((r116 + r210.getMeasuredWidth()) + ((ViewGroup.MarginLayoutParams) r127).leftMargin) + ((ViewGroup.MarginLayoutParams) r127).rightMargin);
        int r129 = ((r117 + r210.getMeasuredHeight()) + ((ViewGroup.MarginLayoutParams) r127).topMargin) + ((ViewGroup.MarginLayoutParams) r127).bottomMargin;
        int r130 = Math.max(r219, r129);
        int r131 = r218;
        r109 = View.combineMeasuredStates(r131, r210.getMeasuredState());
        r107 = r128;
        r108 = r130;
    L46:
        onMeasureChild(r210, r124, r215, r216, 0);
        goto L47
    L45:
        r217 = r120;
        r219 = r108;
        r212 = r106;
        r213 = r100;
        r218 = r214;
        r211 = r119;
        r126 = r107;
        goto L46
    L37:
        if (ViewCompat.getFitsSystemWindows(r210) == true) goto L39;
        int r132 = this.mLastInsets.getSystemWindowInsetLeft() + this.mLastInsets.getSystemWindowInsetRight();
        int r133 = this.mLastInsets.getSystemWindowInsetTop() + this.mLastInsets.getSystemWindowInsetBottom();
        int r134 = View.MeasureSpec.makeMeasureSpec(r113 - r132, r112);
        r124 = r134;
        r216 = View.MeasureSpec.makeMeasureSpec(r115 - r133, r114);
    L24:
        if (r123 != 5) goto L27;
        if (r111 == true) goto L26;
    L27:
        if (r123 != 5) goto L30;
        if (r111 == true) goto L30;
    L32:
        r215 = Math.max(0, r122 - r100);
    L30:
        if (r123 != 3) goto L34;
        if (r111 == true) goto L32;
    L34:
        r215 = 0;
    L33:
        r214 = r109;
        goto L34
    L49:
        int r135 = r109;
        setMeasuredDimension(View.resolveSizeAndState(r107, r310, (-16777216) & r135), View.resolveSizeAndState(r108, r311, r135 << 16));
        return;
    L9:
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L11;
        r118 = true;
        goto L12
    L5:
        r111 = false;
        goto L6
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View r100, int r101) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(r100, r101);
        int r102 = getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L12;
        View r104 = getChildAt(r103);
        LayoutParams r105 = (LayoutParams) r104.getLayoutParams();
        if (r105.isNestedScrollAccepted(r101) == false) goto L11;
        Behavior r106 = r105.getBehavior();
        if (r106 == null) goto L10;
        r106.onStopNestedScroll(this, r104, r100, r101);
    L10:
        r105.resetNestedScroll(r101);
        r105.resetChangedAfterNestedScroll();
    L11:
        r103 = r103 + 1;
        goto L3
    L12:
        this.mNestedScrollingTarget = null;
    }

    public void recordLastChildRect(View r100, Rect r101) {
        ((LayoutParams) r100.getLayoutParams()).setLastChildRect(r101);
    }

    public CoordinatorLayout(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        this.mDependencySortedChildren = new ArrayList();
        this.mChildDag = new DirectedAcyclicGraph();
        this.mTempList1 = new ArrayList();
        this.mTempDependenciesList = new ArrayList();
        this.mBehaviorConsumed = new int[2];
        this.mNestedScrollingV2ConsumedCompat = new int[2];
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        int r100 = 0;
        if (r112 != 0) goto L5;
        TypedArray r101 = r110.obtainStyledAttributes(r111, new int[]{com.larus.nova.R.attr.keylines, com.larus.nova.R.attr.statusBarBackground}, 0, com.larus.nova.R.style.Widget_Support_CoordinatorLayout);
    L7:
        if (Build.VERSION.SDK_INT < 29) goto L11;
        if (r112 != 0) goto L10;
        saveAttributeDataForStyleable(r110, new int[]{com.larus.nova.R.attr.keylines, com.larus.nova.R.attr.statusBarBackground}, r111, r101, 0, com.larus.nova.R.style.Widget_Support_CoordinatorLayout);
        goto L11
    L10:
        saveAttributeDataForStyleable(r110, new int[]{com.larus.nova.R.attr.keylines, com.larus.nova.R.attr.statusBarBackground}, r111, r101, r112, 0);
    L11:
        int r113 = r101.getResourceId(0, 0);
        if (r113 == 0) goto L16;
        Resources r114 = r110.getResources();
        this.mKeylines = r114.getIntArray(r113);
        float r115 = INVOKEVIRTUAL_androidx_coordinatorlayout_widget_CoordinatorLayout_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r114).density;
        int r116 = this.mKeylines.length;
    L14:
        if (r100 >= r116) goto L16;
        int[] r117 = this.mKeylines;
        r117[r100] = (int) (r117[r100] * r115);
        r100 = r100 + 1;
    L16:
        this.mStatusBarBackground = r101.getDrawable(1);
        r101.recycle();
        setupForInsets();
        super.setOnHierarchyChangeListener(new HierarchyChangeListener(this));
        if (ViewCompat.getImportantForAccessibility(this) != 0) goto L21;
        ViewCompat.setImportantForAccessibility(this, 1);
        return;
    L21:
        return;
    L5:
        r101 = r110.obtainStyledAttributes(r111, new int[]{com.larus.nova.R.attr.keylines, com.larus.nova.R.attr.statusBarBackground}, r112, 0);
        goto L7
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_coordinatorlayout_widget_CoordinatorLayout_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r105 = access$000(r100, r101, r102);     // Catch: Throwable -> L8
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r105;
    L8:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r106 = access$000(r100, r101, r102);     // Catch: Throwable -> L17
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r106;
    L17:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private void layoutChildWithAnchor(View r100, View r101, int r102) {
        Rect r103 = acquireTempRect();
        Rect r104 = acquireTempRect();
        getDescendantRect(r101, r103);     // Catch: Throwable -> L6
        getDesiredAnchoredChildRect(r100, r102, r103, r104);     // Catch: Throwable -> L6
        r100.layout(r104.left, r104.top, r104.right, r104.bottom);     // Catch: Throwable -> L6
        releaseTempRect(r103);
        releaseTempRect(r104);
        return;
    L6:
        th = move-exception;
        releaseTempRect(r103);
        releaseTempRect(r104);
        throw th;
    }

    private void layoutChildWithKeyline(View r100, int r110, int r111) {
        LayoutParams r101 = (LayoutParams) r100.getLayoutParams();
        int r102 = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(r101.gravity), r111);
        int r103 = r102 & 7;
        int r104 = r102 & 112;
        int r105 = getWidth();
        int r106 = getHeight();
        int r107 = r100.getMeasuredWidth();
        int r108 = r100.getMeasuredHeight();
        if (r111 != 1) goto L5;
        r110 = r105 - r110;
    L5:
        int r112 = getKeyline(r110) - r107;
        if (r103 != 1) goto L8;
        r112 = r112 + (r107 / 2);
    L12:
        int r109 = 0;
        if (r104 != 16) goto L15;
        r109 = 0 + (r108 / 2);
    L19:
        int r113 = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r101).leftMargin, Math.min(r112, ((r105 - getPaddingRight()) - r107) - ((ViewGroup.MarginLayoutParams) r101).rightMargin));
        int r114 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) r101).topMargin, Math.min(r109, ((r106 - getPaddingBottom()) - r108) - ((ViewGroup.MarginLayoutParams) r101).bottomMargin));
        r100.layout(r113, r114, r107 + r113, r108 + r114);
        return;
    L15:
        if (r104 != 80) goto L19;
        r109 = r108 + 0;
        goto L19
    L8:
        if (r103 != 5) goto L12;
        r112 = r112 + r107;
        goto L12
    }

    private void offsetChildByInset(View r100, Rect r110, int r111) {
        if (ViewCompat.isLaidOut(r100) == true) goto L6;
        return;
    L6:
        if (r100.getWidth() > 0) goto L8;
        return;
    L8:
        if (r100.getHeight() <= 0) goto L54;
        LayoutParams r101 = (LayoutParams) r100.getLayoutParams();
        Behavior r102 = r101.getBehavior();
        Rect r103 = acquireTempRect();
        Rect r104 = acquireTempRect();
        r104.set(r100.getLeft(), r100.getTop(), r100.getRight(), r100.getBottom());
        if (r102 != null) goto L13;
    L19:
        r103.set(r104);
    L20:
        releaseTempRect(r104);
        if (r103.isEmpty() == false) goto L24;
        releaseTempRect(r103);
        return;
    L24:
        int r112 = GravityCompat.getAbsoluteGravity(r101.dodgeInsetEdges, r111);
        boolean r105 = true;
        if ((r112 & 48) != 48) goto L29;
        int r106 = (r103.top - ((ViewGroup.MarginLayoutParams) r101).topMargin) - r101.mInsetOffsetY;
        int r107 = r110.top;
        if (r106 >= r107) goto L29;
        setInsetOffsetY(r100, r107 - r106);
        boolean r108 = true;
    L31:
        if ((r112 & 80) != 80) goto L35;
        int r109 = ((getHeight() - r103.bottom) - ((ViewGroup.MarginLayoutParams) r101).bottomMargin) + r101.mInsetOffsetY;
        int r113 = r110.bottom;
        if (r109 >= r113) goto L35;
        setInsetOffsetY(r100, r109 - r113);
        r108 = true;
    L35:
        if (r108 == true) goto L38;
        setInsetOffsetY(r100, 0);
    L38:
        if ((r112 & 3) != 3) goto L42;
        int r114 = (r103.left - ((ViewGroup.MarginLayoutParams) r101).leftMargin) - r101.mInsetOffsetX;
        int r115 = r110.left;
        if (r114 >= r115) goto L42;
        setInsetOffsetX(r100, r115 - r114);
        boolean r116 = true;
    L44:
        if ((r112 & 5) != 5) goto L48;
        int r117 = ((getWidth() - r103.right) - ((ViewGroup.MarginLayoutParams) r101).rightMargin) + r101.mInsetOffsetX;
        int r118 = r110.right;
        if (r117 >= r118) goto L48;
        setInsetOffsetX(r100, r117 - r118);
    L49:
        if (r105 == true) goto L51;
        setInsetOffsetX(r100, 0);
    L51:
        releaseTempRect(r103);
        return;
    L48:
        r105 = r116;
    L42:
        r116 = false;
    L29:
        r108 = false;
        goto L31
    L13:
        if (r102.getInsetDodgeRect(this, r100, r103) == false) goto L19;
        if (r104.contains(r103) == true) goto L20;
        throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + r103.toShortString() + " | Bounds:" + r104.toShortString());
    }

    public static Behavior parseBehavior(Context r100, AttributeSet r101, String r102) {
        if (TextUtils.isEmpty(r102) == false) goto L7;
        return null;
    L7:
        if (r102.startsWith(".") == false) goto L10;
        r102 = r100.getPackageName() + r102;
    L26:
        ThreadLocal<Map<String, Constructor<Behavior>>> r103 = sConstructors;     // Catch: Exception -> L23
        Map<String, Constructor<Behavior>> r104 = r103.get();     // Catch: Exception -> L23
        if (r104 != null) goto L18;
        r104 = new HashMap();     // Catch: Exception -> L23
        r103.set(r104);     // Catch: Exception -> L23
    L18:
        Constructor<Behavior> r105 = r104.get(r102);     // Catch: Exception -> L23
        if (r105 != null) goto L21;
        r105 = INVOKESTATIC_androidx_coordinatorlayout_widget_CoordinatorLayout_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r102, false, r100.getClassLoader()).getConstructor(CONSTRUCTOR_PARAMS);     // Catch: Exception -> L23
        r105.setAccessible(true);     // Catch: Exception -> L23
        r104.put(r102, r105);     // Catch: Exception -> L23
    L21:
        return r105.newInstance(new Object[]{r100, r101});
    L23:
        e = move-exception;
        throw new RuntimeException("Could not inflate Behavior subclass " + r102, e);
    L10:
        if (r102.indexOf(46) >= 0) goto L26;
        String r106 = WIDGET_PACKAGE_NAME;
        if (TextUtils.isEmpty(r106) == true) goto L26;
        r102 = r106 + '.' + r102;
        goto L26
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r100, View r110, long r111) {
        LayoutParams r101 = (LayoutParams) r110.getLayoutParams();
        Behavior r102 = r101.mBehavior;
        if (r102 == null) goto L14;
        float r103 = r102.getScrimOpacity(this, r110);
        if (r103 <= 0.0f) goto L14;
        if (this.mScrimPaint != null) goto L9;
        this.mScrimPaint = new Paint();
    L9:
        this.mScrimPaint.setColor(r101.mBehavior.getScrimColor(this, r110));
        this.mScrimPaint.setAlpha(clamp(Math.round(r103 * 255.0f), 0, 255));
        int r104 = r100.save();
        if (r110.isOpaque() == false) goto L12;
        r100.clipRect(r110.getLeft(), r110.getTop(), r110.getRight(), r110.getBottom(), Region.Op.DIFFERENCE);
    L12:
        r100.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.mScrimPaint);
        r100.restoreToCount(r104);
    L14:
        return super.drawChild(r100, r110, r111);
    }

    public void getChildRect(View r100, boolean r101, Rect r102) {
        if (r100.isLayoutRequested() == false) goto L5;
    L11:
        r102.setEmpty();
        return;
    L5:
        if (r100.getVisibility() == 8) goto L11;
        if (r101 == false) goto L9;
        getDescendantRect(r100, r102);
        return;
    L9:
        r102.set(r100.getLeft(), r100.getTop(), r100.getRight(), r100.getBottom());
    }

    public boolean isPointInChildBounds(View r100, int r101, int r102) {
        Rect r103 = acquireTempRect();
        getDescendantRect(r100, r103);
        boolean r104 = r103.contains(r101, r102);     // Catch: Throwable -> L6
        releaseTempRect(r103);
        return r104;
    L6:
        th = move-exception;
        releaseTempRect(r103);
        throw th;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View r110, float r111, float r112) {
        int r100 = getChildCount();
        int r101 = 0;
        boolean r102 = false;
    L3:
        if (r101 >= r100) goto L14;
        View r103 = getChildAt(r101);
        if (r103.getVisibility() == 8) goto L13;
        LayoutParams r104 = (LayoutParams) r103.getLayoutParams();
        if (r104.isNestedScrollAccepted(0) == false) goto L13;
        Behavior r105 = r104.getBehavior();
        if (r105 == null) goto L13;
        r102 = r102 | r105.onNestedPreFling(this, r103, r110, r111, r112);
    L13:
        r101 = r101 + 1;
        goto L3
    L14:
        return r102;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View r100, View r101, int r102) {
        onNestedScrollAccepted(r100, r101, r102, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View r100, View r101, int r102) {
        return onStartNestedScroll(r100, r101, r102, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View r100, Rect r101, boolean r102) {
        Behavior r103 = ((LayoutParams) r100.getLayoutParams()).getBehavior();
        if (r103 == null) goto L9;
        if (r103.onRequestChildRectangleOnScreen(this, r100, r101, r102) == false) goto L9;
        return true;
    L9:
        return super.requestChildRectangleOnScreen(r100, r101, r102);
    }

    private void constrainChildRect(LayoutParams r100, Rect r101, int r102, int r103) {
        int r104 = getWidth();
        int r105 = getHeight();
        int r106 = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r100).leftMargin, Math.min(r101.left, ((r104 - getPaddingRight()) - r102) - ((ViewGroup.MarginLayoutParams) r100).rightMargin));
        int r107 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) r100).topMargin, Math.min(r101.top, ((r105 - getPaddingBottom()) - r103) - ((ViewGroup.MarginLayoutParams) r100).bottomMargin));
        r101.set(r106, r107, r102 + r106, r103 + r107);
    }

    public void getDesiredAnchoredChildRect(View r110, int r111, Rect r112, Rect r113) {
        LayoutParams r100 = (LayoutParams) r110.getLayoutParams();
        int r101 = r110.getMeasuredWidth();
        int r114 = r110.getMeasuredHeight();
        getDesiredAnchoredChildRectWithoutConstraints(r110, r111, r112, r113, r100, r101, r114);
        constrainChildRect(r100, r113, r101, r114);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View r110, float r111, float r112, boolean r113) {
        int r100 = getChildCount();
        int r101 = 0;
        boolean r102 = false;
    L3:
        if (r101 >= r100) goto L14;
        View r103 = getChildAt(r101);
        if (r103.getVisibility() == 8) goto L13;
        LayoutParams r104 = (LayoutParams) r103.getLayoutParams();
        if (r104.isNestedScrollAccepted(0) == false) goto L13;
        Behavior r105 = r104.getBehavior();
        if (r105 == null) goto L13;
        r102 = r102 | r105.onNestedFling(this, r103, r110, r111, r112, r113);
    L13:
        r101 = r101 + 1;
        goto L3
    L14:
        if (r102 == false) goto L16;
        onChildViewsChanged(1);
    L16:
        return r102;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View r100, int r101, int r102, int[] r110) {
        onNestedPreScroll(r100, r101, r102, r110, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View r110, View r111, int r112, int r113) {
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(r110, r111, r112, r113);
        this.mNestedScrollingTarget = r111;
        int r100 = getChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L11;
        View r102 = getChildAt(r101);
        LayoutParams r103 = (LayoutParams) r102.getLayoutParams();
        if (r103.isNestedScrollAccepted(r113) == false) goto L10;
        Behavior r104 = r103.getBehavior();
        if (r104 == null) goto L10;
        r104.onNestedScrollAccepted(this, r102, r110, r111, r112, r113);
    L10:
        r101 = r101 + 1;
        goto L3
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View r110, View r111, int r112, int r113) {
        int r100 = getChildCount();
        int r114 = 0;
        boolean r115 = false;
    L3:
        if (r114 >= r100) goto L13;
        View r101 = getChildAt(r114);
        if (r101.getVisibility() == 8) goto L11;
        LayoutParams r116 = (LayoutParams) r101.getLayoutParams();
        Behavior r102 = r116.getBehavior();
        if (r102 == null) goto L10;
        boolean r103 = r102.onStartNestedScroll(this, r101, r110, r111, r112, r113);
        r115 = r115 | r103;
        r116.setNestedScrollAccepted(r113, r103);
        goto L11
    L10:
        r116.setNestedScrollAccepted(r113, false);
    L11:
        r114 = r114 + 1;
        goto L3
    L13:
        return r115;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = ViewCompat.getLayoutDirection(this);
        int r106 = this.mDependencySortedChildren.size();
        int r107 = 0;
    L3:
        if (r107 >= r106) goto L13;
        View r108 = (View) ListProtector.get(this.mDependencySortedChildren, r107);
        if (r108.getVisibility() == 8) goto L12;
        Behavior r109 = ((LayoutParams) r108.getLayoutParams()).getBehavior();
        if (r109 != null) goto L10;
    L11:
        onLayoutChild(r108, r105);
        goto L12
    L10:
        if (r109.onLayoutChild(this, r108, r105) == false) goto L11;
    L12:
        r107 = r107 + 1;
        goto L3
    }

    public void onMeasureChild(View r100, int r101, int r102, int r103, int r104) {
        measureChildWithMargins(r100, r101, r102, r103, r104);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View r110, int r111, int r112, int[] r210, int r211) {
        int r100 = getChildCount();
        boolean r101 = false;
        int r113 = 0;
        int r114 = 0;
        int r115 = 0;
    L4:
        if (r113 >= r100) goto L23;
        View r102 = getChildAt(r113);
        if (r102.getVisibility() == 8) goto L22;
        LayoutParams r103 = (LayoutParams) r102.getLayoutParams();
        if (r103.isNestedScrollAccepted(r211) == false) goto L22;
        Behavior r104 = r103.getBehavior();
        if (r104 == null) goto L22;
        int[] r105 = this.mBehaviorConsumed;
        r105[0] = 0;
        r105[1] = 0;
        r104.onNestedPreScroll(this, r102, r110, r111, r112, r105, r211);
        int[] r106 = this.mBehaviorConsumed;
        if (r111 <= 0) goto L16;
        int r107 = Math.max(r114, r106[0]);
    L17:
        r114 = r107;
        int[] r108 = this.mBehaviorConsumed;
        if (r112 <= 0) goto L20;
        int r109 = Math.max(r115, r108[1]);
    L21:
        r115 = r109;
        r101 = true;
        goto L22
    L20:
        r109 = Math.min(r115, r108[1]);
        goto L21
    L16:
        r107 = Math.min(r114, r106[0]);
    L22:
        r113 = r113 + 1;
        goto L4
    L23:
        r210[0] = r114;
        r210[1] = r115;
        if (r101 == false) goto L32;
        onChildViewsChanged(1);
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View r100, int r101, int r110, int r111, int r112) {
        onNestedScroll(r100, r101, r110, r111, r112, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View r100, int r110, int r111, int r112, int r113, int r114) {
        onNestedScroll(r100, r110, r111, r112, r113, 0, this.mNestedScrollingV2ConsumedCompat);
    }

    private void getDesiredAnchoredChildRectWithoutConstraints(View r100, int r101, Rect r102, Rect r103, LayoutParams r110, int r111, int r112) {
        int r104 = GravityCompat.getAbsoluteGravity(resolveAnchoredChildGravity(r110.gravity), r101);
        int r105 = GravityCompat.getAbsoluteGravity(resolveGravity(r110.anchorGravity), r101);
        int r113 = r104 & 7;
        int r106 = r104 & 112;
        int r107 = r105 & 7;
        int r108 = r105 & 112;
        if (r107 == 1) goto L7;
        if (r107 == 5) goto L6;
        int r109 = r102.left;
    L9:
        if (r108 == 16) goto L13;
        if (r108 == 80) goto L12;
        int r114 = r102.top;
    L14:
        if (r113 == 1) goto L17;
        if (r113 == 5) goto L18;
        r109 = r109 - r111;
    L18:
        if (r106 == 16) goto L21;
        if (r106 == 80) goto L22;
        r114 = r114 - r112;
    L22:
        r103.set(r109, r114, r111 + r109, r112 + r114);
        return;
    L21:
        r114 = r114 - (r112 / 2);
        goto L22
    L17:
        r109 = r109 - (r111 / 2);
        goto L18
    L12:
        r114 = r102.bottom;
        goto L14
    L13:
        r114 = r102.top + (r102.height() / 2);
        goto L14
    L6:
        r109 = r102.right;
        goto L9
    L7:
        r109 = r102.left + (r102.width() / 2);
        goto L9
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View r110, int r111, int r210, int r211, int r212, int r213, int[] r214) {
        int r112 = getChildCount();
        boolean r100 = false;
        int r113 = 0;
        int r114 = 0;
        int r115 = 0;
    L4:
        if (r113 >= r112) goto L23;
        View r101 = getChildAt(r113);
        if (r101.getVisibility() == 8) goto L22;
        LayoutParams r102 = (LayoutParams) r101.getLayoutParams();
        if (r102.isNestedScrollAccepted(r213) == false) goto L22;
        Behavior r103 = r102.getBehavior();
        if (r103 == null) goto L22;
        int[] r104 = this.mBehaviorConsumed;
        r104[0] = 0;
        r104[1] = 0;
        r103.onNestedScroll(this, r101, r110, r111, r210, r211, r212, r213, r104);
        int[] r105 = this.mBehaviorConsumed;
        if (r211 <= 0) goto L16;
        int r106 = Math.max(r114, r105[0]);
    L17:
        r114 = r106;
        if (r212 <= 0) goto L20;
        int r107 = Math.max(r115, this.mBehaviorConsumed[1]);
    L21:
        r115 = r107;
        r100 = true;
        goto L22
    L20:
        r107 = Math.min(r115, this.mBehaviorConsumed[1]);
        goto L21
    L16:
        r106 = Math.min(r114, r105[0]);
    L22:
        r113 = r113 + 1;
        goto L4
    L23:
        r214[0] = r214[0] + r114;
        r214[1] = r214[1] + r115;
        if (r100 == false) goto L32;
        onChildViewsChanged(1);
        return;
    }
}
