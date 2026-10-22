package androidx.coordinatorlayout.widget;

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
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.core.util.f;
import androidx.core.view.ViewCompat;
import androidx.core.view.al;
import androidx.core.view.q;
import androidx.core.view.r;
import androidx.core.view.s;
import androidx.core.view.t;
import androidx.customview.view.AbsSavedState;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements q, r {
    static final Class<?>[] CONSTRUCTOR_PARAMS = null;
    static final int EVENT_NESTED_SCROLL = 1;
    static final int EVENT_PRE_DRAW = 0;
    static final int EVENT_VIEW_REMOVED = 2;
    static final String TAG = "CoordinatorLayout";
    static final Comparator<View> TOP_SORTED_CHILDREN_COMPARATOR = null;
    private static final int TYPE_ON_INTERCEPT = 0;
    private static final int TYPE_ON_TOUCH = 1;
    static final String WIDGET_PACKAGE_NAME = null;
    static final ThreadLocal<Map<String, Constructor<b>>> sConstructors = null;
    private static final f.a<Rect> sRectPool = null;
    private t mApplyWindowInsetsListener;
    private final int[] mBehaviorConsumed;
    private View mBehaviorTouchView;
    private final androidx.coordinatorlayout.widget.a<View> mChildDag;
    private final List<View> mDependencySortedChildren;
    private boolean mDisallowInterceptReset;
    private boolean mDrawStatusBarBackground;
    private boolean mIsAttachedToWindow;
    private int[] mKeylines;
    private al mLastInsets;
    private boolean mNeedsPreDrawListener;
    private final s mNestedScrollingParentHelper;
    private View mNestedScrollingTarget;
    private final int[] mNestedScrollingV2ConsumedCompat;
    ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
    private OnPreDrawListener mOnPreDrawListener;
    private Paint mScrimPaint;
    private Drawable mStatusBarBackground;
    private final List<View> mTempDependenciesList;
    private final List<View> mTempList1;

    private class HierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        final /* synthetic */ CoordinatorLayout this$0;

        HierarchyChangeListener(CoordinatorLayout r1) {
            this.this$0 = r1;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View r2, View r3) {
            if (this.this$0.mOnHierarchyChangeListener == null) goto L6;
            this.this$0.mOnHierarchyChangeListener.onChildViewAdded(r2, r3);
            return;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View r3, View r4) {
            this.this$0.onChildViewsChanged(2);
            if (this.this$0.mOnHierarchyChangeListener == null) goto L6;
            this.this$0.mOnHierarchyChangeListener.onChildViewRemoved(r3, r4);
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
        b mBehavior;
        boolean mBehaviorResolved;
        Object mBehaviorTag;
        private boolean mDidAcceptNestedScrollNonTouch;
        private boolean mDidAcceptNestedScrollTouch;
        private boolean mDidBlockInteraction;
        private boolean mDidChangeAfterNestedScroll;
        int mInsetOffsetX;
        int mInsetOffsetY;
        final Rect mLastChildRect;

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        LayoutParams(Context r7, AttributeSet r8) {
            Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
            AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.aiagent.plugin");
            super(r9, r10);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
            TypedArray r2 = r9.obtainStyledAttributes(r10, R.styleable.CoordinatorLayout_Layout);
            this.gravity = r2.getInteger(ZeusTransformUtils.mapRes(R.styleable.CoordinatorLayout_Layout_android_layout_gravity, "styleable", "CoordinatorLayout_Layout_android_layout_gravity"), 0);
            this.mAnchorId = r2.getResourceId(ZeusTransformUtils.mapRes(R.styleable.CoordinatorLayout_Layout_layout_anchor, "styleable", "CoordinatorLayout_Layout_layout_anchor"), -1);
            this.anchorGravity = r2.getInteger(ZeusTransformUtils.mapRes(R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, "styleable", "CoordinatorLayout_Layout_layout_anchorGravity"), 0);
            this.keyline = r2.getInteger(ZeusTransformUtils.mapRes(R.styleable.CoordinatorLayout_Layout_layout_keyline, "styleable", "CoordinatorLayout_Layout_layout_keyline"), -1);
            this.insetEdge = r2.getInt(ZeusTransformUtils.mapRes(R.styleable.CoordinatorLayout_Layout_layout_insetEdge, "styleable", "CoordinatorLayout_Layout_layout_insetEdge"), 0);
            this.dodgeInsetEdges = r2.getInt(ZeusTransformUtils.mapRes(R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, "styleable", "CoordinatorLayout_Layout_layout_dodgeInsetEdges"), 0);
            boolean r0 = r2.hasValue(ZeusTransformUtils.mapRes(R.styleable.CoordinatorLayout_Layout_layout_behavior, "styleable", "CoordinatorLayout_Layout_layout_behavior"));
            this.mBehaviorResolved = r0;
            if (r0 == false) goto L5;
            this.mBehavior = CoordinatorLayout.parseBehavior(r9, r10, r2.getString(ZeusTransformUtils.mapRes(R.styleable.CoordinatorLayout_Layout_layout_behavior, "styleable", "CoordinatorLayout_Layout_layout_behavior")));
        L5:
            r2.recycle();
            b r11 = this.mBehavior;
            if (r11 == null) goto L9;
            r11.a(this);
            return;
        }

        public LayoutParams(LayoutParams r2) {
            super(r2);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r2) {
            super(r2);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        public LayoutParams(ViewGroup.LayoutParams r2) {
            super(r2);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        public int getAnchorId() {
            return this.mAnchorId;
        }

        public void setAnchorId(int r1) {
            invalidateAnchor();
            this.mAnchorId = r1;
        }

        public b getBehavior() {
            return this.mBehavior;
        }

        public void setBehavior(b r2) {
            b r0 = this.mBehavior;
            if (r0 == r2) goto L10;
            if (r0 == null) goto L6;
            r0.a();
        L6:
            this.mBehavior = r2;
            this.mBehaviorTag = null;
            this.mBehaviorResolved = true;
            if (r2 == null) goto L11;
            r2.a(this);
            return;
        L11:
            return;
        }

        void setLastChildRect(Rect r1) {
            this.mLastChildRect.set(r1);
        }

        Rect getLastChildRect() {
            return this.mLastChildRect;
        }

        boolean checkAnchorChanged() {
            if (this.mAnchorView == null) goto L5;
        L7:
            return false;
        L5:
            if (this.mAnchorId == (-1)) goto L7;
            return true;
        }

        boolean didBlockInteraction() {
            if (this.mBehavior != null) goto L6;
            this.mDidBlockInteraction = false;
        L6:
            return this.mDidBlockInteraction;
        }

        boolean isBlockingInteractionBelow(CoordinatorLayout r3, View r4) {
            boolean r0 = this.mDidBlockInteraction;
            if (r0 == false) goto L6;
            return true;
        L6:
            b r1 = this.mBehavior;
            if (r1 == null) goto L9;
            boolean r5 = r1.c(r3, r4);
        L10:
            boolean r6 = r5 | r0;
            this.mDidBlockInteraction = r6;
            return r6;
        L9:
            r5 = false;
            goto L10
        }

        void resetTouchBehaviorTracking() {
            this.mDidBlockInteraction = false;
        }

        void resetNestedScroll(int r2) {
            setNestedScrollAccepted(r2, false);
        }

        void setNestedScrollAccepted(int r2, boolean r3) {
            if (r2 != 0) goto L4;
            this.mDidAcceptNestedScrollTouch = r3;
            return;
        L4:
            if (r2 != 1) goto L10;
            this.mDidAcceptNestedScrollNonTouch = r3;
            return;
        }

        boolean isNestedScrollAccepted(int r2) {
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L8;
            return false;
        L8:
            return this.mDidAcceptNestedScrollNonTouch;
        L10:
            return this.mDidAcceptNestedScrollTouch;
        }

        boolean getChangedAfterNestedScroll() {
            return this.mDidChangeAfterNestedScroll;
        }

        void setChangedAfterNestedScroll(boolean r1) {
            this.mDidChangeAfterNestedScroll = r1;
        }

        void resetChangedAfterNestedScroll() {
            this.mDidChangeAfterNestedScroll = false;
        }

        boolean dependsOn(CoordinatorLayout r2, View r3, View r4) {
            if (r4 != this.mAnchorDirectChild) goto L5;
        L12:
            return true;
        L5:
            if (shouldDodge(r4, ViewCompat.i(r2)) == true) goto L12;
            b r1 = this.mBehavior;
            if (r1 != null) goto L9;
        L11:
            return false;
        L9:
            if (r1.a(r2, r3, r4) == false) goto L11;
            goto L11
        }

        void invalidateAnchor() {
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
        }

        View findAnchorView(CoordinatorLayout r3, View r4) {
            if (this.mAnchorId != (-1)) goto L7;
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return null;
        L7:
            if (this.mAnchorView != null) goto L9;
        L10:
            resolveAnchorView(r4, r3);
        L12:
            return this.mAnchorView;
        L9:
            if (verifyAnchorView(r4, r3) == true) goto L12;
            goto L10
        }

        private void resolveAnchorView(View r6, CoordinatorLayout r7) {
            View r0 = r7.findViewById(this.mAnchorId);
            this.mAnchorView = r0;
            if (r0 == null) goto L28;
            if (r0 == r7) goto L6;
            ViewParent r3 = r0.getParent();
        L12:
            if (r3 == r7) goto L25;
            if (r3 == null) goto L25;
            if (r3 == r6) goto L16;
            if (ZeusTransformUtils.instanceOf(r3, View.class) == false) goto L24;
            r0 = (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");
        L24:
            r3 = r3.getParent();
            goto L12
        L16:
            if (r7.isInEditMode() == false) goto L20;
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return;
        L20:
            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
        L25:
            this.mAnchorDirectChild = r0;
            return;
        L6:
            if (r7.isInEditMode() == false) goto L10;
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return;
        L10:
            throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
        L28:
            if (r7.isInEditMode() == false) goto L32;
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return;
        L32:
            throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + ZeusTransformUtils.getResources(r7, "com.obric.aiagent.plugin").getResourceName(this.mAnchorId) + " to anchor view " + r6);
        }

        private boolean verifyAnchorView(View r5, CoordinatorLayout r6) {
            if (this.mAnchorView.getId() == this.mAnchorId) goto L5;
            return false;
        L5:
            View r0 = this.mAnchorView;
            ViewParent r1 = r0.getParent();
        L6:
            if (r1 == r6) goto L16;
            if (r1 == null) goto L14;
            if (r1 == r5) goto L14;
            if (ZeusTransformUtils.instanceOf(r1, View.class) == false) goto L13;
            r0 = (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin");
        L13:
            r1 = r1.getParent();
        L14:
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return false;
        L16:
            this.mAnchorDirectChild = r0;
            return true;
        }

        private boolean shouldDodge(View r3, int r4) {
            int r5 = androidx.core.view.d.a(((LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).insetEdge, r4);
            if (r5 != 0) goto L5;
        L7:
            return false;
        L5:
            if ((androidx.core.view.d.a(this.dodgeInsetEdges, r4) & r5) != r5) goto L7;
            return true;
        }
    }

    class OnPreDrawListener implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ CoordinatorLayout this$0;

        OnPreDrawListener(CoordinatorLayout r1) {
            this.this$0 = r1;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.this$0.onChildViewsChanged(0);
            return true;
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        SparseArray<Parcelable> behaviorStates;

        public SavedState(Parcel r6, ClassLoader r7) {
            super(r6, r7);
            int r0 = r6.readInt();
            int[] r1 = new int[r0];
            r6.readIntArray(r1);
            Parcelable[] r8 = r6.readParcelableArray(r7);
            this.behaviorStates = new SparseArray(r0);
            int r9 = 0;
        L3:
            if (r9 >= r0) goto L5;
            this.behaviorStates.append(r1[r9], r8[r9]);
            r9 = r9 + 1;
            goto L3
        }

        public SavedState(Parcelable r3) {
            super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin"));
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r8, int r9) {
            super.writeToParcel(r8, r9);
            SparseArray<Parcelable> r0 = this.behaviorStates;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.size();
        L6:
            r8.writeInt(r2);
            int[] r3 = new int[r2];
            Parcelable[] r4 = new Parcelable[r2];
        L7:
            if (r1 >= r2) goto L9;
            r3[r1] = this.behaviorStates.keyAt(r1);
            r4[r1] = (Parcelable) ZeusTransformUtils.preCheckCast(this.behaviorStates.valueAt(r1), Parcelable.class, "com.obric.aiagent.plugin");
            r1 = r1 + 1;
            goto L7
        L9:
            r8.writeIntArray(r3);
            r8.writeParcelableArray(r4, r9);
            return;
        L5:
            r2 = 0;
            goto L6
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    public interface a {
        b getBehavior();
    }

    public static abstract class b<V extends View> {
        public int a(CoordinatorLayout r1, V r2) {
            return -16777216;
        }

        public al a(CoordinatorLayout r1, V r2, al r3) {
            return r3;
        }

        public void a() {
        }

        public void a(LayoutParams r1) {
        }

        public void a(CoordinatorLayout r1, V r2, Parcelable r3) {
            Parcelable r0 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        }

        @Deprecated
        public void a(CoordinatorLayout r1, V r2, View r3, int r4, int r5, int r6, int r7) {
        }

        @Deprecated
        public void a(CoordinatorLayout r1, V r2, View r3, int r4, int r5, int[] r6) {
        }

        public boolean a(CoordinatorLayout r1, V r2, int r3) {
            return false;
        }

        public boolean a(CoordinatorLayout r1, V r2, int r3, int r4, int r5, int r6) {
            return false;
        }

        public boolean a(CoordinatorLayout r1, V r2, Rect r3) {
            return false;
        }

        public boolean a(CoordinatorLayout r1, V r2, Rect r3, boolean r4) {
            return false;
        }

        public boolean a(CoordinatorLayout r1, V r2, MotionEvent r3) {
            return false;
        }

        public boolean a(CoordinatorLayout r1, V r2, View r3) {
            return false;
        }

        public boolean a(CoordinatorLayout r1, V r2, View r3, float r4, float r5) {
            return false;
        }

        public boolean a(CoordinatorLayout r1, V r2, View r3, float r4, float r5, boolean r6) {
            return false;
        }

        @Deprecated
        public boolean a(CoordinatorLayout r1, V r2, View r3, View r4, int r5) {
            return false;
        }

        public float b(CoordinatorLayout r1, V r2) {
            return 0.0f;
        }

        @Deprecated
        public void b(CoordinatorLayout r1, V r2, View r3, View r4, int r5) {
        }

        public boolean b(CoordinatorLayout r1, V r2, MotionEvent r3) {
            return false;
        }

        public boolean b(CoordinatorLayout r1, V r2, View r3) {
            return false;
        }

        public void c(CoordinatorLayout r1, V r2, View r3) {
        }

        @Deprecated
        public void d(CoordinatorLayout r1, V r2, View r3) {
        }

        public b() {
        }

        public b(Context r3, AttributeSet r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        }

        public boolean c(CoordinatorLayout r1, V r2) {
            if (b(r1, r2) <= 0.0f) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean a(CoordinatorLayout r1, V r2, View r3, View r4, int r5, int r6) {
            if (r6 == 0) goto L4;
            return false;
        L4:
            return a(r1, r2, r3, r4, r5);
        }

        public void b(CoordinatorLayout r1, V r2, View r3, View r4, int r5, int r6) {
            if (r6 != 0) goto L5;
            b(r1, r2, r3, r4, r5);
            return;
        }

        public void a(CoordinatorLayout r1, V r2, View r3, int r4) {
            if (r4 != 0) goto L5;
            d(r1, r2, r3);
            return;
        }

        @Deprecated
        public void a(CoordinatorLayout r1, V r2, View r3, int r4, int r5, int r6, int r7, int r8) {
            if (r8 != 0) goto L5;
            a(r1, r2, r3, r4, r5, r6, r7);
            return;
        }

        public void a(CoordinatorLayout r3, V r4, View r5, int r6, int r7, int r8, int r9, int r10, int[] r11) {
            r11[0] = r11[0] + r8;
            r11[1] = r11[1] + r9;
            a(r3, r4, r5, r6, r7, r8, r9, r10);
        }

        public void a(CoordinatorLayout r1, V r2, View r3, int r4, int r5, int[] r6, int r7) {
            if (r7 != 0) goto L5;
            a(r1, r2, r3, r4, r5, r6);
            return;
        }

        public Parcelable d(CoordinatorLayout r1, V r2) {
            return View.BaseSavedState.EMPTY_STATE;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    public @interface c {
        Class<? extends b> a();
    }

    static class d implements Comparator<View> {
        d() {
        }

        @Override // java.util.Comparator
        public /* synthetic */ int compare(View r3, View r4) {
            return a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"), (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"));
        }

        public int a(View r1, View r2) {
            float r0 = ViewCompat.G(r1);
            float r3 = ViewCompat.G(r2);
            if (r0 <= r3) goto L7;
            return -1;
        L7:
            if (r0 >= r3) goto L10;
            return 1;
        L10:
            return 0;
        }
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }

    private static int clamp(int r0, int r1, int r2) {
        if (r0 >= r1) goto L4;
        return r1;
    L4:
        if (r0 <= r2) goto L6;
        return r2;
    L6:
        return r0;
    }

    private static int resolveAnchoredChildGravity(int r0) {
        if (r0 != 0) goto L5;
        return 17;
    L5:
        return r0;
    }

    private static int resolveGravity(int r1) {
        if ((r1 & 7) != 0) goto L6;
        r1 = r1 | 8388611;
    L6:
        if ((r1 & 112) == 0) goto L8;
        return r1;
    L8:
        return r1 | 48;
    }

    private static int resolveKeylineGravity(int r0) {
        if (r0 != 0) goto L5;
        return 8388661;
    L5:
        return r0;
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return generateLayoutParams((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateLayoutParams(r1);
    }

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        if (r0 == null) goto L5;
        String r1 = r0.getName();
    L6:
        WIDGET_PACKAGE_NAME = r1;
        if (Build.VERSION.SDK_INT < 21) goto L9;
        TOP_SORTED_CHILDREN_COMPARATOR = new d();
    L10:
        CONSTRUCTOR_PARAMS = new Class[]{Context.class, AttributeSet.class};
        sConstructors = new ThreadLocal();
        sRectPool = new f.c(12);
        return;
    L9:
        TOP_SORTED_CHILDREN_COMPARATOR = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    private static Rect acquireTempRect() {
        Rect r0 = (Rect) ZeusTransformUtils.preCheckCast(sRectPool.a(), Rect.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new Rect();
    }

    private static void releaseTempRect(Rect r1) {
        r1.setEmpty();
        sRectPool.a(r1);
    }

    public CoordinatorLayout(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public CoordinatorLayout(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.attr.coordinatorLayoutStyle, "attr", "coordinatorLayoutStyle"));
    }

    public CoordinatorLayout(Context r12, AttributeSet r13, int r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r13, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r15, r5, r14);
        this.mDependencySortedChildren = new ArrayList();
        this.mChildDag = new androidx.coordinatorlayout.widget.a();
        this.mTempList1 = new ArrayList();
        this.mTempDependenciesList = new ArrayList();
        this.mBehaviorConsumed = new int[2];
        this.mNestedScrollingV2ConsumedCompat = new int[2];
        this.mNestedScrollingParentHelper = new s(this);
        int r9 = 0;
        if (r14 != 0) goto L5;
        TypedArray r2 = r15.obtainStyledAttributes(r5, R.styleable.CoordinatorLayout, 0, ZeusTransformUtils.mapRes(R.style.Widget_Support_CoordinatorLayout, "style", "Widget_Support_CoordinatorLayout"));
    L6:
        TypedArray r10 = r2;
        if (Build.VERSION.SDK_INT < 29) goto L11;
        if (r14 != 0) goto L10;
        saveAttributeDataForStyleable(r15, R.styleable.CoordinatorLayout, r5, r10, 0, ZeusTransformUtils.mapRes(R.style.Widget_Support_CoordinatorLayout, "style", "Widget_Support_CoordinatorLayout"));
        goto L11
    L10:
        saveAttributeDataForStyleable(r15, R.styleable.CoordinatorLayout, r5, r10, r14, 0);
    L11:
        int r16 = r10.getResourceId(ZeusTransformUtils.mapRes(R.styleable.CoordinatorLayout_keylines, "styleable", "CoordinatorLayout_keylines"), 0);
        if (r16 == 0) goto L16;
        Resources r17 = ZeusTransformUtils.getResources(r15, "com.obric.aiagent.plugin");
        this.mKeylines = r17.getIntArray(r16);
        float r18 = r17.getDisplayMetrics().density;
        int r19 = this.mKeylines.length;
    L14:
        if (r9 >= r19) goto L16;
        int[] r0 = this.mKeylines;
        r0[r9] = (int) (r0[r9] * r18);
        r9 = r9 + 1;
    L16:
        this.mStatusBarBackground = r10.getDrawable(ZeusTransformUtils.mapRes(R.styleable.CoordinatorLayout_statusBarBackground, "styleable", "CoordinatorLayout_statusBarBackground"));
        r10.recycle();
        setupForInsets();
        super.setOnHierarchyChangeListener(new HierarchyChangeListener(this));
        if (ViewCompat.g(this) != 0) goto L21;
        ViewCompat.c(this, 1);
        return;
    L21:
        return;
    L5:
        r2 = r15.obtainStyledAttributes(r5, R.styleable.CoordinatorLayout, r14, 0);
        goto L6
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener r3) {
        this.mOnHierarchyChangeListener = (ViewGroup.OnHierarchyChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, ViewGroup.OnHierarchyChangeListener.class, "com.obric.aiagent.plugin");
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
        if (ViewCompat.v(this) == false) goto L13;
        ViewCompat.u(this);
        goto L13
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener == true) goto L5;
    L7:
        View r1 = this.mNestedScrollingTarget;
        if (r1 == null) goto L10;
        onStopNestedScroll(r1);
    L10:
        this.mIsAttachedToWindow = false;
        return;
    L5:
        if (this.mOnPreDrawListener == null) goto L7;
        getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        goto L7
    }

    public void setStatusBarBackground(Drawable r3) {
        Drawable r0 = this.mStatusBarBackground;
        if (r0 == r3) goto L21;
        Drawable r1 = null;
        if (r0 == null) goto L7;
        r0.setCallback(null);
    L7:
        if (r3 == null) goto L9;
        r1 = r3.mutate();
    L9:
        this.mStatusBarBackground = r1;
        if (r1 != null) goto L12;
    L19:
        ViewCompat.f(this);
        return;
    L12:
        if (r1.isStateful() == false) goto L14;
        this.mStatusBarBackground.setState(getDrawableState());
    L14:
        androidx.core.graphics.drawable.a.b(this.mStatusBarBackground, ViewCompat.i(this));
        Drawable r4 = this.mStatusBarBackground;
        if (getVisibility() != 0) goto L17;
        boolean r2 = true;
    L18:
        r4.setVisible(r2, false);
        this.mStatusBarBackground.setCallback(this);
        goto L19
    L17:
        r2 = false;
        goto L18
    }

    public Drawable getStatusBarBackground() {
        return this.mStatusBarBackground;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r0 = getDrawableState();
        Drawable r1 = this.mStatusBarBackground;
        boolean r2 = false;
        if (r1 != null) goto L5;
    L7:
        if (r2 == false) goto L10;
        invalidate();
        return;
    L10:
        return;
    L5:
        if (r1.isStateful() == false) goto L7;
        r2 = false | r1.setState(r0);
        goto L7
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable r2) {
        if (super.verifyDrawable(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (r2 == this.mStatusBarBackground) goto L8;
        return false;
    }

    @Override // android.view.View
    public void setVisibility(int r3) {
        super.setVisibility(r3);
        if (r3 != 0) goto L5;
        boolean r4 = true;
    L6:
        Drawable r1 = this.mStatusBarBackground;
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.isVisible() == r4) goto L13;
        this.mStatusBarBackground.setVisible(r4, false);
        return;
    L13:
        return;
    L5:
        r4 = false;
        goto L6
    }

    public void setStatusBarBackgroundResource(int r4) {
        if (r4 == 0) goto L4;
        Drawable r5 = androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4);
    L5:
        setStatusBarBackground(r5);
        return;
    L4:
        r5 = null;
        goto L5
    }

    public void setStatusBarBackgroundColor(int r2) {
        setStatusBarBackground(new ColorDrawable(r2));
    }

    final al setWindowInsets(al r4) {
        if (androidx.core.util.d.a(this.mLastInsets, r4) == true) goto L18;
        this.mLastInsets = r4;
        boolean r0 = true;
        if (r4 != null) goto L7;
    L9:
        boolean r2 = false;
    L10:
        this.mDrawStatusBarBackground = r2;
        if (r2 == false) goto L13;
    L15:
        r0 = false;
    L16:
        setWillNotDraw(r0);
        al r5 = dispatchApplyWindowInsetsToBehaviors(r4);
        requestLayout();
        return r5;
    L13:
        if (getBackground() != null) goto L15;
    L7:
        if (r4.b() <= 0) goto L9;
        r2 = true;
        goto L10
    L18:
        return r4;
    }

    public final al getLastWindowInsets() {
        return this.mLastInsets;
    }

    private void resetTouchBehaviors(boolean r14) {
        int r0 = getChildCount();
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L13;
        View r4 = getChildAt(r2);
        b r3 = ((LayoutParams) ZeusTransformUtils.preCheckCast(r4.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).getBehavior();
        if (r3 == null) goto L12;
        long r7 = SystemClock.uptimeMillis();
        MotionEvent r5 = MotionEvent.obtain(r7, r7, 3, 0.0f, 0.0f, 0);
        if (r14 == false) goto L10;
        r3.a(this, r4, r5);
    L11:
        r5.recycle();
        goto L12
    L10:
        r3.b(this, r4, r5);
    L12:
        r2 = r2 + 1;
        goto L4
    L13:
        int r15 = 0;
    L14:
        if (r15 >= r0) goto L16;
        ((LayoutParams) ZeusTransformUtils.preCheckCast(getChildAt(r15).getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).resetTouchBehaviorTracking();
        r15 = r15 + 1;
        goto L14
    L16:
        this.mBehaviorTouchView = null;
        this.mDisallowInterceptReset = false;
    }

    private void getTopSortedChildren(List<View> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        r6.clear();
        boolean r0 = isChildrenDrawingOrderEnabled();
        int r1 = getChildCount();
        int r2 = r1 - 1;
    L3:
        if (r2 < 0) goto L8;
        if (r0 == false) goto L6;
        int r3 = getChildDrawingOrder(r1, r2);
    L7:
        r6.add(getChildAt(r3));
        r2 = r2 - 1;
        goto L3
    L6:
        r3 = r2;
        goto L7
    L8:
        Comparator<View> r4 = TOP_SORTED_CHILDREN_COMPARATOR;
        if (r4 == null) goto L15;
        Collections.sort(r6, r4);
        return;
    }

    private boolean performIntercept(MotionEvent r24, int r25) {
        int r3 = r24.getActionMasked();
        List<View> r4 = this.mTempList1;
        getTopSortedChildren(r4);
        int r5 = r4.size();
        MotionEvent r7 = null;
        int r8 = 0;
        boolean r9 = false;
        boolean r10 = false;
    L3:
        if (r8 >= r5) goto L34;
        View r11 = (View) ZeusTransformUtils.preCheckCast(r4.get(r8), View.class, "com.obric.aiagent.plugin");
        LayoutParams r12 = (LayoutParams) ZeusTransformUtils.preCheckCast(r11.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        b r13 = r12.getBehavior();
        if (r9 == true) goto L7;
        if (r10 == true) goto L7;
    L16:
        if (r9 == true) goto L25;
        if (r13 == null) goto L25;
        if (r25 == 0) goto L22;
        if (r25 != 1) goto L23;
        r9 = r13.b(this, r11, r24);
    L23:
        if (r9 == false) goto L25;
        this.mBehaviorTouchView = r11;
        goto L25
    L22:
        r9 = r13.a(this, r11, r24);
    L25:
        boolean r14 = r12.didBlockInteraction();
        boolean r15 = r12.isBlockingInteractionBelow(this, r11);
        if (r15 == false) goto L29;
        if (r14 == true) goto L29;
        r10 = true;
    L30:
        if (r15 == false) goto L33;
        if (r10 == false) goto L34;
    L33:
        r8 = r8 + 1;
    L29:
        r10 = false;
    L7:
        if (r3 == 0) goto L16;
        if (r13 == null) goto L33;
        if (r7 != null) goto L11;
        long r17 = SystemClock.uptimeMillis();
        r7 = MotionEvent.obtain(r17, r17, 3, 0.0f, 0.0f, 0);
    L11:
        if (r25 == 0) goto L15;
        if (r25 != 1) goto L33;
        r13.b(this, r11, r7);
        goto L33
    L15:
        r13.a(this, r11, r7);
    L34:
        r4.clear();
        return r9;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r4) {
        int r0 = r4.getActionMasked();
        if (r0 != 0) goto L5;
        resetTouchBehaviors(true);
    L5:
        boolean r5 = performIntercept(r4, 0);
        if (r0 != 1) goto L8;
    L9:
        resetTouchBehaviors(true);
    L10:
        return r5;
    L8:
        if (r0 != 3) goto L10;
        goto L9
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r18) {
        int r2 = r18.getActionMasked();
        if (this.mBehaviorTouchView != null) goto L7;
        boolean r3 = performIntercept(r18, 1);
        if (r3 == true) goto L8;
    L11:
        boolean r6 = false;
    L12:
        MotionEvent r8 = null;
        if (this.mBehaviorTouchView != null) goto L15;
        r6 = r6 | super.onTouchEvent(r18);
    L17:
        if (r8 == null) goto L19;
        r8.recycle();
    L19:
        if (r2 != 1) goto L21;
    L22:
        resetTouchBehaviors(false);
    L23:
        return r6;
    L21:
        if (r2 != 3) goto L23;
    L15:
        if (r3 == false) goto L17;
        long r11 = SystemClock.uptimeMillis();
        r8 = MotionEvent.obtain(r11, r11, 3, 0.0f, 0.0f, 0);
        super.onTouchEvent(r8);
    L8:
        b r7 = ((LayoutParams) ZeusTransformUtils.preCheckCast(this.mBehaviorTouchView.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).getBehavior();
        if (r7 == null) goto L11;
        r6 = r7.b(this, this.mBehaviorTouchView, r18);
        goto L12
    L7:
        r3 = false;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r1) {
        super.requestDisallowInterceptTouchEvent(r1);
        if (r1 == true) goto L5;
        return;
    L5:
        if (this.mDisallowInterceptReset == true) goto L9;
        resetTouchBehaviors(false);
        this.mDisallowInterceptReset = true;
        return;
    }

    private int getKeyline(int r5) {
        int[] r0 = this.mKeylines;
        if (r0 != null) goto L6;
        INVOKESTATIC_androidx_coordinatorlayout_widget_CoordinatorLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "No keylines defined for " + this + " - attempted index lookup " + r5);
        return 0;
    L6:
        if (r5 >= 0) goto L8;
    L12:
        INVOKESTATIC_androidx_coordinatorlayout_widget_CoordinatorLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "Keyline index " + r5 + " out of range for " + this);
        return 0;
    L8:
        if (r5 >= r0.length) goto L12;
        return r0[r5];
    }

    /* JADX WARN: Multi-variable type inference failed */
    static b parseBehavior(Context r6, AttributeSet r7, String r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r8) == false) goto L7;
        return null;
    L7:
        if (r8.startsWith(".") == false) goto L10;
        r8 = r9.getPackageName() + r8;
    L26:
        ThreadLocal<Map<String, Constructor<b>>> r0 = sConstructors;     // Catch: Exception -> L23
        Map<String, Constructor<b>> r2 = (Map) ZeusTransformUtils.preCheckCast(r0.get(), Map.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L23
        if (r2 != null) goto L18;
        r2 = new HashMap();     // Catch: Exception -> L23
        r0.set(r2);     // Catch: Exception -> L23
    L18:
        Constructor<b> r1 = (Constructor) ZeusTransformUtils.preCheckCast(r2.get(r8), Constructor.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L23
        if (r1 != null) goto L21;
        r1 = Class.forName(r8, false, r9.getClassLoader()).getConstructor(CONSTRUCTOR_PARAMS);     // Catch: Exception -> L23
        r1.setAccessible(true);     // Catch: Exception -> L23
        r2.put(r8, r1);     // Catch: Exception -> L23
    L21:
        return (b) ZeusTransformUtils.preCheckCast(r1.newInstance(new Object[]{r9, r10}), b.class, "com.obric.aiagent.plugin");
    L23:
        e = move-exception;
        throw new RuntimeException("Could not inflate Behavior subclass " + r8, e);
    L10:
        if (r8.indexOf(46) >= 0) goto L26;
        String r3 = WIDGET_PACKAGE_NAME;
        if (TextUtils.isEmpty(r3) == true) goto L26;
        r8 = r3 + '.' + r8;
        goto L26
    }

    LayoutParams getResolvedLayoutParams(View r7) {
        LayoutParams r6 = (LayoutParams) ZeusTransformUtils.preCheckCast(r7.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (r6.mBehaviorResolved == false) goto L5;
    L21:
        return r6;
    L5:
        if (ZeusTransformUtils.instanceOf(r7, a.class) == false) goto L10;
        b r8 = ((a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.aiagent.plugin")).getBehavior();
        if (r8 != null) goto L9;
        INVOKESTATIC_androidx_coordinatorlayout_widget_CoordinatorLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "Attached behavior class is null");
    L9:
        r6.setBehavior(r8);
        r6.mBehaviorResolved = true;
        goto L21
    L10:
        Class<?> r9 = r7.getClass();
        c r0 = null;
    L11:
        if (r9 == null) goto L15;
        r0 = (c) ZeusTransformUtils.preCheckCast(r9.getAnnotation(c.class), c.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L15;
        r9 = r9.getSuperclass();
    L15:
        if (r0 != null) goto L22;
    L20:
        r6.mBehaviorResolved = true;
        goto L21
    L22:
        r6.setBehavior((b) ZeusTransformUtils.preCheckCast(r0.a().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), b.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L18
    L18:
        e = move-exception;
        INVOKESTATIC_androidx_coordinatorlayout_widget_CoordinatorLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "Default behavior class " + r0.a().getName() + " could not be instantiated. Did you forget a default constructor?", e);
        goto L20
    }

    private void prepareChildren() {
        this.mDependencySortedChildren.clear();
        this.mChildDag.a();
        int r0 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L16;
        View r3 = getChildAt(r2);
        LayoutParams r4 = getResolvedLayoutParams(r3);
        r4.findAnchorView(this, r3);
        this.mChildDag.a(r3);
        int r5 = 0;
    L5:
        if (r5 >= r0) goto L15;
        if (r5 == r2) goto L14;
        View r6 = getChildAt(r5);
        if (r4.dependsOn(this, r3, r6) == false) goto L14;
        if (this.mChildDag.b(r6) == true) goto L13;
        this.mChildDag.a(r6);
    L13:
        this.mChildDag.a(r6, r3);
    L14:
        r5 = r5 + 1;
        goto L5
    L15:
        r2 = r2 + 1;
        goto L3
    L16:
        this.mDependencySortedChildren.addAll(this.mChildDag.b());
        Collections.reverse(this.mDependencySortedChildren);
    }

    void getDescendantRect(View r1, Rect r2) {
        androidx.coordinatorlayout.widget.b.b(this, r1, r2);
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    public void onMeasureChild(View r1, int r2, int r3, int r4, int r5) {
        measureChildWithMargins(r1, r2, r3, r4, r5);
    }

    @Override // android.view.View
    public void onMeasure(int r32, int r33) {
        prepareChildren();
        ensurePreDrawListener();
        int r8 = getPaddingLeft();
        int r0 = getPaddingTop();
        int r9 = getPaddingRight();
        int r1 = getPaddingBottom();
        int r10 = ViewCompat.i(this);
        if (r10 != 1) goto L5;
        boolean r12 = true;
    L6:
        int r13 = View.MeasureSpec.getMode(r32);
        int r14 = View.MeasureSpec.getSize(r32);
        int r15 = View.MeasureSpec.getMode(r33);
        int r16 = View.MeasureSpec.getSize(r33);
        int r17 = r8 + r9;
        int r18 = r0 + r1;
        int r2 = getSuggestedMinimumWidth();
        int r3 = getSuggestedMinimumHeight();
        if (this.mLastInsets != null) goto L9;
    L11:
        boolean r19 = false;
    L12:
        int r6 = this.mDependencySortedChildren.size();
        int r5 = r2;
        int r4 = r3;
        int r7 = 0;
        int r11 = 0;
    L13:
        if (r11 >= r6) goto L49;
        View r21 = (View) ZeusTransformUtils.preCheckCast(this.mDependencySortedChildren.get(r11), View.class, "com.obric.aiagent.plugin");
        if (r21.getVisibility() != 8) goto L17;
        int r23 = r11;
        int r30 = r6;
        int r29 = r8;
    L48:
        r11 = r23 + 1;
        r8 = r29;
        r6 = r30;
        goto L13
    L17:
        LayoutParams r110 = (LayoutParams) ZeusTransformUtils.preCheckCast(r21.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (r110.keyline < 0) goto L33;
        if (r13 == 0) goto L33;
        int r20 = getKeyline(r110.keyline);
        int r22 = androidx.core.view.d.a(resolveKeylineGravity(r110.gravity), r10) & 7;
        int r24 = r7;
        if (r22 != 3) goto L24;
        if (r12 == true) goto L24;
    L26:
        int r25 = Math.max(0, (r14 - r9) - r20);
    L35:
        if (r19 == true) goto L37;
    L39:
        int r26 = r32;
        int r27 = r33;
    L40:
        b r28 = r110.getBehavior();
        if (r28 == null) goto L45;
        int r210 = r24;
        r23 = r11;
        int r211 = r4;
        r29 = r8;
        int r31 = r5;
        r30 = r6;
        if (r28.a(this, r21, r26, r25, r27, 0) == false) goto L46;
    L47:
        int r34 = Math.max(r31, ((r17 + r21.getMeasuredWidth()) + r110.leftMargin) + r110.rightMargin);
        int r35 = Math.max(r211, ((r18 + r21.getMeasuredHeight()) + r110.topMargin) + r110.bottomMargin);
        r7 = View.combineMeasuredStates(r210, r21.getMeasuredState());
        r5 = r34;
        r4 = r35;
    L46:
        onMeasureChild(r21, r26, r25, r27, 0);
        goto L47
    L45:
        r23 = r11;
        r211 = r4;
        r30 = r6;
        r29 = r8;
        r210 = r24;
        r31 = r5;
        goto L46
    L37:
        if (ViewCompat.v(r21) == true) goto L39;
        int r36 = this.mLastInsets.a() + this.mLastInsets.c();
        int r37 = this.mLastInsets.b() + this.mLastInsets.d();
        r26 = View.MeasureSpec.makeMeasureSpec(r14 - r36, r13);
        r27 = View.MeasureSpec.makeMeasureSpec(r16 - r37, r15);
    L24:
        if (r22 != 5) goto L27;
        if (r12 == true) goto L26;
    L27:
        if (r22 != 5) goto L30;
        if (r12 == true) goto L30;
    L32:
        r25 = Math.max(0, r20 - r8);
    L30:
        if (r22 != 3) goto L34;
        if (r12 == true) goto L32;
    L34:
        r25 = 0;
    L33:
        r24 = r7;
        goto L34
    L49:
        int r111 = r7;
        setMeasuredDimension(View.resolveSizeAndState(r5, r32, (-16777216) & r111), View.resolveSizeAndState(r4, r33, r111 << 16));
        return;
    L9:
        if (ViewCompat.v(this) == false) goto L11;
        r19 = true;
        goto L12
    L5:
        r12 = false;
        goto L6
    }

    private al dispatchApplyWindowInsetsToBehaviors(al r7) {
        if (r7.f() == false) goto L5;
        return r7;
    L5:
        int r0 = 0;
        int r1 = getChildCount();
    L6:
        if (r0 >= r1) goto L15;
        View r2 = getChildAt(r0);
        if (ViewCompat.v(r2) == false) goto L14;
        b r3 = ((LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).getBehavior();
        if (r3 == null) goto L14;
        r7 = r3.a(this, r2, r7);
        if (r7.f() == true) goto L15;
    L14:
        r0 = r0 + 1;
    L15:
        return r7;
    }

    public void onLayoutChild(View r4, int r5) {
        LayoutParams r0 = (LayoutParams) ZeusTransformUtils.preCheckCast(r4.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (r0.checkAnchorChanged() == true) goto L13;
        if (r0.mAnchorView == null) goto L8;
        layoutChildWithAnchor(r4, r0.mAnchorView, r5);
        return;
    L8:
        if (r0.keyline < 0) goto L10;
        layoutChildWithKeyline(r4, r0.keyline, r5);
        return;
    L10:
        layoutChild(r4, r5);
        return;
    L13:
        throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        int r8 = ViewCompat.i(this);
        int r9 = this.mDependencySortedChildren.size();
        int r10 = 0;
    L3:
        if (r10 >= r9) goto L13;
        View r11 = (View) ZeusTransformUtils.preCheckCast(this.mDependencySortedChildren.get(r10), View.class, "com.obric.aiagent.plugin");
        if (r11.getVisibility() == 8) goto L12;
        b r12 = ((LayoutParams) ZeusTransformUtils.preCheckCast(r11.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).getBehavior();
        if (r12 != null) goto L10;
    L11:
        onLayoutChild(r11, r8);
        goto L12
    L10:
        if (r12.a(this, r11, r8) == false) goto L11;
    L12:
        r10 = r10 + 1;
        goto L3
    }

    @Override // android.view.View
    public void onDraw(Canvas r5) {
        super.onDraw(r5);
        if (this.mDrawStatusBarBackground == true) goto L5;
        return;
    L5:
        if (this.mStatusBarBackground == null) goto L14;
        al r0 = this.mLastInsets;
        if (r0 == null) goto L9;
        int r1 = r0.b();
    L10:
        if (r1 <= 0) goto L15;
        this.mStatusBarBackground.setBounds(0, 0, getWidth(), r1);
        this.mStatusBarBackground.draw(r5);
        return;
    L15:
        return;
    L9:
        r1 = 0;
        goto L10
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean r1) {
        super.setFitsSystemWindows(r1);
        setupForInsets();
    }

    void recordLastChildRect(View r2, Rect r3) {
        ((LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).setLastChildRect(r3);
    }

    void getLastChildRect(View r2, Rect r3) {
        r3.set(((LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).getLastChildRect());
    }

    void getChildRect(View r3, boolean r4, Rect r5) {
        if (r3.isLayoutRequested() == false) goto L5;
    L11:
        r5.setEmpty();
        return;
    L5:
        if (r3.getVisibility() == 8) goto L11;
        if (r4 == false) goto L9;
        getDescendantRect(r3, r5);
        return;
    L9:
        r5.set(r3.getLeft(), r3.getTop(), r3.getRight(), r3.getBottom());
    }

    private void getDesiredAnchoredChildRectWithoutConstraints(View r5, int r6, Rect r7, Rect r8, LayoutParams r9, int r10, int r11) {
        int r4 = androidx.core.view.d.a(resolveAnchoredChildGravity(r9.gravity), r6);
        int r12 = androidx.core.view.d.a(resolveGravity(r9.anchorGravity), r6);
        int r13 = r4 & 7;
        int r14 = r4 & 112;
        int r15 = r12 & 7;
        int r16 = r12 & 112;
        if (r15 == 1) goto L7;
        if (r15 == 5) goto L6;
        int r17 = r7.left;
    L9:
        if (r16 == 16) goto L13;
        if (r16 == 80) goto L12;
        int r18 = r7.top;
    L14:
        if (r13 == 1) goto L17;
        if (r13 == 5) goto L18;
        r17 = r17 - r10;
    L18:
        if (r14 == 16) goto L21;
        if (r14 == 80) goto L22;
        r18 = r18 - r11;
    L22:
        r8.set(r17, r18, r10 + r17, r11 + r18);
        return;
    L21:
        r18 = r18 - (r11 / 2);
        goto L22
    L17:
        r17 = r17 - (r10 / 2);
        goto L18
    L12:
        r18 = r7.bottom;
        goto L14
    L13:
        r18 = r7.top + (r7.height() / 2);
        goto L14
    L6:
        r17 = r7.right;
        goto L9
    L7:
        r17 = r7.left + (r7.width() / 2);
        goto L9
    }

    private void constrainChildRect(LayoutParams r6, Rect r7, int r8, int r9) {
        int r0 = getWidth();
        int r1 = getHeight();
        int r2 = Math.max(getPaddingLeft() + r6.leftMargin, Math.min(r7.left, ((r0 - getPaddingRight()) - r8) - r6.rightMargin));
        int r5 = Math.max(getPaddingTop() + r6.topMargin, Math.min(r7.top, ((r1 - getPaddingBottom()) - r9) - r6.bottomMargin));
        r7.set(r2, r5, r8 + r2, r9 + r5);
    }

    void getDesiredAnchoredChildRect(View r12, int r13, Rect r14, Rect r15) {
        LayoutParams r0 = (LayoutParams) ZeusTransformUtils.preCheckCast(r12.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        int r9 = r12.getMeasuredWidth();
        int r10 = r12.getMeasuredHeight();
        getDesiredAnchoredChildRectWithoutConstraints(r12, r13, r14, r15, r0, r9, r10);
        constrainChildRect(r0, r15, r9, r10);
    }

    private void layoutChildWithAnchor(View r4, View r5, int r6) {
        Rect r0 = acquireTempRect();
        Rect r1 = acquireTempRect();
        getDescendantRect(r5, r0);     // Catch: Throwable -> L6
        getDesiredAnchoredChildRect(r4, r6, r0, r1);     // Catch: Throwable -> L6
        r4.layout(r1.left, r1.top, r1.right, r1.bottom);     // Catch: Throwable -> L6
        releaseTempRect(r0);
        releaseTempRect(r1);
        return;
    L6:
        th = move-exception;
        releaseTempRect(r0);
        releaseTempRect(r1);
        throw th;
    }

    private void layoutChildWithKeyline(View r9, int r10, int r11) {
        LayoutParams r0 = (LayoutParams) ZeusTransformUtils.preCheckCast(r9.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        int r1 = androidx.core.view.d.a(resolveKeylineGravity(r0.gravity), r11);
        int r2 = r1 & 7;
        int r3 = r1 & 112;
        int r4 = getWidth();
        int r5 = getHeight();
        int r6 = r9.getMeasuredWidth();
        int r7 = r9.getMeasuredHeight();
        if (r11 != 1) goto L5;
        r10 = r4 - r10;
    L5:
        int r12 = getKeyline(r10) - r6;
        int r13 = 0;
        if (r2 != 1) goto L8;
        r12 = r12 + (r6 / 2);
    L13:
        if (r3 != 16) goto L15;
        r13 = 0 + (r7 / 2);
    L19:
        int r14 = Math.max(getPaddingLeft() + r0.leftMargin, Math.min(r12, ((r4 - getPaddingRight()) - r6) - r0.rightMargin));
        int r8 = Math.max(getPaddingTop() + r0.topMargin, Math.min(r13, ((r5 - getPaddingBottom()) - r7) - r0.bottomMargin));
        r9.layout(r14, r8, r6 + r14, r7 + r8);
        return;
    L15:
        if (r3 != 80) goto L19;
        r13 = r7 + 0;
        goto L19
    L8:
        if (r2 != 5) goto L13;
        r12 = r12 + r6;
        goto L13
    }

    private void layoutChild(View r9, int r10) {
        LayoutParams r0 = (LayoutParams) ZeusTransformUtils.preCheckCast(r9.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        Rect r7 = acquireTempRect();
        r7.set(getPaddingLeft() + r0.leftMargin, getPaddingTop() + r0.topMargin, (getWidth() - getPaddingRight()) - r0.rightMargin, (getHeight() - getPaddingBottom()) - r0.bottomMargin);
        if (this.mLastInsets != null) goto L5;
    L9:
        Rect r8 = acquireTempRect();
        androidx.core.view.d.a(resolveGravity(r0.gravity), r9.getMeasuredWidth(), r9.getMeasuredHeight(), r7, r8, r10);
        r9.layout(r8.left, r8.top, r8.right, r8.bottom);
        releaseTempRect(r7);
        releaseTempRect(r8);
        return;
    L5:
        if (ViewCompat.v(this) == false) goto L9;
        if (ViewCompat.v(r9) == true) goto L9;
        r7.left += this.mLastInsets.a();
        r7.top += this.mLastInsets.b();
        r7.right -= this.mLastInsets.c();
        r7.bottom -= this.mLastInsets.d();
        goto L9
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r9, View r10, long r11) {
        LayoutParams r0 = (LayoutParams) ZeusTransformUtils.preCheckCast(r10.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (r0.mBehavior == null) goto L14;
        float r1 = r0.mBehavior.b(this, r10);
        if (r1 <= 0.0f) goto L14;
        if (this.mScrimPaint != null) goto L9;
        this.mScrimPaint = new Paint();
    L9:
        this.mScrimPaint.setColor(r0.mBehavior.a(this, r10));
        this.mScrimPaint.setAlpha(clamp(Math.round(r1 * 255.0f), 0, 255));
        int r2 = r9.save();
        if (r10.isOpaque() == false) goto L12;
        r9.clipRect(r10.getLeft(), r10.getTop(), r10.getRight(), r10.getBottom(), Region.Op.DIFFERENCE);
    L12:
        r9.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.mScrimPaint);
        r9.restoreToCount(r2);
    L14:
        return super.drawChild(r9, r10, r11);
    }

    final void onChildViewsChanged(int r18) {
        int r2 = ViewCompat.i(this);
        int r3 = this.mDependencySortedChildren.size();
        Rect r4 = acquireTempRect();
        Rect r5 = acquireTempRect();
        Rect r6 = acquireTempRect();
        int r8 = 0;
    L3:
        if (r8 >= r3) goto L61;
        View r9 = (View) ZeusTransformUtils.preCheckCast(this.mDependencySortedChildren.get(r8), View.class, "com.obric.aiagent.plugin");
        LayoutParams r10 = (LayoutParams) ZeusTransformUtils.preCheckCast(r9.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (r18 == 0) goto L7;
    L9:
        int r12 = 0;
    L10:
        if (r12 >= r8) goto L15;
        if (r10.mAnchorDirectChild != ((View) ZeusTransformUtils.preCheckCast(this.mDependencySortedChildren.get(r12), View.class, "com.obric.aiagent.plugin"))) goto L14;
        offsetChildToAnchor(r9, r2);
    L14:
        r12 = r12 + 1;
        goto L10
    L15:
        getChildRect(r9, true, r5);
        if (r10.insetEdge == 0) goto L34;
        if (r5.isEmpty() == true) goto L34;
        int r13 = androidx.core.view.d.a(r10.insetEdge, r2);
        int r14 = r13 & 112;
        if (r14 != 48) goto L22;
        r4.top = Math.max(r4.top, r5.bottom);
    L26:
        int r7 = r13 & 7;
        if (r7 != 3) goto L29;
        r4.left = Math.max(r4.left, r5.right);
        goto L34
    L29:
        if (r7 != 5) goto L34;
        r4.right = Math.max(r4.right, getWidth() - r5.left);
        goto L34
    L22:
        if (r14 != 80) goto L26;
        r4.bottom = Math.max(r4.bottom, getHeight() - r5.top);
    L34:
        if (r10.dodgeInsetEdges == 0) goto L39;
        if (r9.getVisibility() != 0) goto L39;
        offsetChildByInset(r9, r4, r2);
    L39:
        if (r18 == 2) goto L44;
        getLastChildRect(r9, r6);
        if (r6.equals(r5) == true) goto L60;
        recordLastChildRect(r9, r5);
    L60:
        r8 = r8 + 1;
    L44:
        int r11 = r8 + 1;
    L45:
        if (r11 >= r3) goto L60;
        View r15 = (View) ZeusTransformUtils.preCheckCast(this.mDependencySortedChildren.get(r11), View.class, "com.obric.aiagent.plugin");
        LayoutParams r16 = (LayoutParams) ZeusTransformUtils.preCheckCast(r15.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        b r17 = r16.getBehavior();
        if (r17 == null) goto L59;
        if (r17.a(this, r15, r9) == false) goto L59;
        if (r18 == 0) goto L52;
    L54:
        if (r18 == 2) goto L56;
        boolean r19 = r17.b(this, r15, r9);
    L57:
        if (r18 != 1) goto L59;
        r16.setChangedAfterNestedScroll(r19);
        goto L59
    L56:
        r17.c(this, r15, r9);
        r19 = true;
        goto L57
    L52:
        if (r16.getChangedAfterNestedScroll() == false) goto L54;
        r16.resetChangedAfterNestedScroll();
    L59:
        r11 = r11 + 1;
        goto L45
    L7:
        if (r9.getVisibility() != 8) goto L9;
    L61:
        releaseTempRect(r4);
        releaseTempRect(r5);
        releaseTempRect(r6);
    }

    private void offsetChildByInset(View r9, Rect r10, int r11) {
        if (ViewCompat.F(r9) == true) goto L6;
        return;
    L6:
        if (r9.getWidth() > 0) goto L8;
        return;
    L8:
        if (r9.getHeight() <= 0) goto L54;
        LayoutParams r0 = (LayoutParams) ZeusTransformUtils.preCheckCast(r9.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        b r1 = r0.getBehavior();
        Rect r2 = acquireTempRect();
        Rect r3 = acquireTempRect();
        r3.set(r9.getLeft(), r9.getTop(), r9.getRight(), r9.getBottom());
        if (r1 != null) goto L13;
    L19:
        r2.set(r3);
    L20:
        releaseTempRect(r3);
        if (r2.isEmpty() == false) goto L24;
        releaseTempRect(r2);
        return;
    L24:
        int r12 = androidx.core.view.d.a(r0.dodgeInsetEdges, r11);
        boolean r4 = true;
        if ((r12 & 48) != 48) goto L29;
        int r5 = (r2.top - r0.topMargin) - r0.mInsetOffsetY;
        if (r5 >= r10.top) goto L29;
        setInsetOffsetY(r9, r10.top - r5);
        boolean r6 = true;
    L31:
        if ((r12 & 80) != 80) goto L35;
        int r7 = ((getHeight() - r2.bottom) - r0.bottomMargin) + r0.mInsetOffsetY;
        if (r7 >= r10.bottom) goto L35;
        setInsetOffsetY(r9, r7 - r10.bottom);
        r6 = true;
    L35:
        if (r6 == true) goto L38;
        setInsetOffsetY(r9, 0);
    L38:
        if ((r12 & 3) != 3) goto L42;
        int r8 = (r2.left - r0.leftMargin) - r0.mInsetOffsetX;
        if (r8 >= r10.left) goto L42;
        setInsetOffsetX(r9, r10.left - r8);
        boolean r13 = true;
    L44:
        if ((r12 & 5) != 5) goto L48;
        int r14 = ((getWidth() - r2.right) - r0.rightMargin) + r0.mInsetOffsetX;
        if (r14 >= r10.right) goto L48;
        setInsetOffsetX(r9, r14 - r10.right);
    L49:
        if (r4 == true) goto L51;
        setInsetOffsetX(r9, 0);
    L51:
        releaseTempRect(r2);
        return;
    L48:
        r4 = r13;
    L42:
        r13 = false;
    L29:
        r6 = false;
        goto L31
    L13:
        if (r1.a(this, r9, r2) == false) goto L19;
        if (r3.contains(r2) == true) goto L20;
        throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + r2.toShortString() + " | Bounds:" + r3.toShortString());
    }

    private void setInsetOffsetX(View r3, int r4) {
        LayoutParams r2 = (LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (r2.mInsetOffsetX == r4) goto L6;
        ViewCompat.g(r3, r4 - r2.mInsetOffsetX);
        r2.mInsetOffsetX = r4;
        return;
    }

    private void setInsetOffsetY(View r3, int r4) {
        LayoutParams r2 = (LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (r2.mInsetOffsetY == r4) goto L6;
        ViewCompat.f(r3, r4 - r2.mInsetOffsetY);
        r2.mInsetOffsetY = r4;
        return;
    }

    public void dispatchDependentViewsChanged(View r7) {
        List r0 = this.mChildDag.c(r7);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEmpty() == true) goto L17;
        int r1 = 0;
    L8:
        if (r1 >= r0.size()) goto L18;
        View r2 = (View) ZeusTransformUtils.preCheckCast(r0.get(r1), View.class, "com.obric.aiagent.plugin");
        b r3 = ((LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).getBehavior();
        if (r3 == null) goto L12;
        r3.b(this, r2, r7);
    L12:
        r1 = r1 + 1;
        goto L8
    L18:
        return;
    }

    public List<View> getDependencies(View r2) {
        List<View> r3 = this.mChildDag.d(r2);
        this.mTempDependenciesList.clear();
        if (r3 == null) goto L6;
        this.mTempDependenciesList.addAll(r3);
    L6:
        return this.mTempDependenciesList;
    }

    public List<View> getDependents(View r2) {
        List r3 = this.mChildDag.c(r2);
        this.mTempDependenciesList.clear();
        if (r3 == null) goto L6;
        this.mTempDependenciesList.addAll(r3);
    L6:
        return this.mTempDependenciesList;
    }

    final List<View> getDependencySortedChildren() {
        prepareChildren();
        return Collections.unmodifiableList(this.mDependencySortedChildren);
    }

    void ensurePreDrawListener() {
        int r0 = getChildCount();
        boolean r1 = false;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (hasDependencies(getChildAt(r2)) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        r1 = true;
    L9:
        if (r1 == this.mNeedsPreDrawListener) goto L16;
        if (r1 == false) goto L12;
        addPreDrawListener();
        return;
    L12:
        removePreDrawListener();
        return;
    }

    private boolean hasDependencies(View r1) {
        return this.mChildDag.e(r1);
    }

    void addPreDrawListener() {
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

    void removePreDrawListener() {
        if (this.mIsAttachedToWindow == true) goto L5;
    L7:
        this.mNeedsPreDrawListener = false;
        return;
    L5:
        if (this.mOnPreDrawListener == null) goto L7;
        getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        goto L7
    }

    void offsetChildToAnchor(View r17, int r18) {
        LayoutParams r10 = (LayoutParams) ZeusTransformUtils.preCheckCast(r17.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (r10.mAnchorView == null) goto L20;
        Rect r11 = acquireTempRect();
        Rect r12 = acquireTempRect();
        Rect r13 = acquireTempRect();
        getDescendantRect(r10.mAnchorView, r11);
        boolean r14 = false;
        getChildRect(r17, false, r12);
        int r15 = r17.getMeasuredWidth();
        int r7 = r17.getMeasuredHeight();
        getDesiredAnchoredChildRectWithoutConstraints(r17, r18, r11, r13, r10, r15, r7);
        if (r13.left == r12.left) goto L7;
    L8:
        r14 = true;
    L9:
        constrainChildRect(r10, r13, r15, r7);
        int r0 = r13.left - r12.left;
        int r1 = r13.top - r12.top;
        if (r0 == 0) goto L12;
        ViewCompat.g(r17, r0);
    L12:
        if (r1 == 0) goto L14;
        ViewCompat.f(r17, r1);
    L14:
        if (r14 == false) goto L18;
        b r2 = r10.getBehavior();
        if (r2 == null) goto L18;
        r2.b(this, r17, r10.mAnchorView);
    L18:
        releaseTempRect(r11);
        releaseTempRect(r12);
        releaseTempRect(r13);
        return;
    L7:
        if (r13.top == r12.top) goto L9;
    }

    public boolean isPointInChildBounds(View r2, int r3, int r4) {
        Rect r0 = acquireTempRect();
        getDescendantRect(r2, r0);
        boolean r1 = r0.contains(r3, r4);     // Catch: Throwable -> L6
        releaseTempRect(r0);
        return r1;
    L6:
        th = move-exception;
        releaseTempRect(r0);
        throw th;
    }

    public boolean doViewsOverlap(View r5, View r6) {
        boolean r1 = false;
        if (r5.getVisibility() == 0) goto L5;
    L29:
        return false;
    L5:
        if (r6.getVisibility() != 0) goto L29;
        Rect r0 = acquireTempRect();
        if (r5.getParent() == this) goto L9;
        boolean r2 = true;
    L10:
        getChildRect(r5, r2, r0);
        Rect r7 = acquireTempRect();
        if (r6.getParent() == this) goto L13;
        boolean r3 = true;
    L14:
        getChildRect(r6, r3, r7);
    L26:
        th = move-exception;
        releaseTempRect(r0);
        releaseTempRect(r7);
        throw th;
    L16:
        if (r0.left <= r7.right) goto L18;
    L24:
        releaseTempRect(r0);
        releaseTempRect(r7);
        return r1;
    L18:
        if (r0.top > r7.bottom) goto L24;
        if (r0.right < r7.left) goto L24;
        if (r0.bottom < r7.top) goto L24;
        r1 = true;
        goto L24
    L13:
        r3 = false;
        goto L14
    L9:
        r2 = false;
        goto L10
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r4) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        return new LayoutParams((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams r3) {
        if (ZeusTransformUtils.instanceOf(r3, LayoutParams.class) == false) goto L7;
        return new LayoutParams((LayoutParams) ZeusTransformUtils.preCheckCast(r3, LayoutParams.class, "com.obric.aiagent.plugin"));
    L7:
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == false) goto L11;
        return new LayoutParams((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin"));
    L11:
        return new LayoutParams(r3);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
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

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public boolean onStartNestedScroll(View r2, View r3, int r4) {
        return onStartNestedScroll(r2, r3, r4, 0);
    }

    @Override // androidx.core.view.q
    public boolean onStartNestedScroll(View r15, View r16, int r17, int r18) {
        int r8 = getChildCount();
        int r10 = 0;
        boolean r11 = false;
    L3:
        if (r10 >= r8) goto L12;
        View r2 = getChildAt(r10);
        if (r2.getVisibility() == 8) goto L11;
        LayoutParams r13 = (LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        b r0 = r13.getBehavior();
        if (r0 == null) goto L10;
        boolean r1 = r0.a(this, r2, r15, r16, r17, r18);
        r11 = r11 | r1;
        r13.setNestedScrollAccepted(r18, r1);
        goto L11
    L10:
        r13.setNestedScrollAccepted(r18, false);
    L11:
        r10 = r10 + 1;
        goto L3
    L12:
        return r11;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public void onNestedScrollAccepted(View r2, View r3, int r4) {
        onNestedScrollAccepted(r2, r3, r4, 0);
    }

    @Override // androidx.core.view.q
    public void onNestedScrollAccepted(View r10, View r11, int r12, int r13) {
        this.mNestedScrollingParentHelper.a(r10, r11, r12, r13);
        this.mNestedScrollingTarget = r11;
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        View r4 = getChildAt(r1);
        LayoutParams r2 = (LayoutParams) ZeusTransformUtils.preCheckCast(r4.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (r2.isNestedScrollAccepted(r13) == false) goto L10;
        b r3 = r2.getBehavior();
        if (r3 == null) goto L10;
        r3.b(this, r4, r10, r11, r12, r13);
    L10:
        r1 = r1 + 1;
        goto L3
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public void onStopNestedScroll(View r2) {
        onStopNestedScroll(r2, 0);
    }

    @Override // androidx.core.view.q
    public void onStopNestedScroll(View r7, int r8) {
        this.mNestedScrollingParentHelper.a(r7, r8);
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L12;
        View r2 = getChildAt(r1);
        LayoutParams r3 = (LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (r3.isNestedScrollAccepted(r8) == false) goto L11;
        b r4 = r3.getBehavior();
        if (r4 == null) goto L10;
        r4.a(this, r2, r7, r8);
    L10:
        r3.resetNestedScroll(r8);
        r3.resetChangedAfterNestedScroll();
    L11:
        r1 = r1 + 1;
        goto L3
    L12:
        this.mNestedScrollingTarget = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public void onNestedScroll(View r8, int r9, int r10, int r11, int r12) {
        onNestedScroll(r8, r9, r10, r11, r12, 0);
    }

    @Override // androidx.core.view.q
    public void onNestedScroll(View r9, int r10, int r11, int r12, int r13, int r14) {
        onNestedScroll(r9, r10, r11, r12, r13, 0, this.mNestedScrollingV2ConsumedCompat);
    }

    @Override // androidx.core.view.r
    public void onNestedScroll(View r18, int r19, int r20, int r21, int r22, int r23, int[] r24) {
        int r11 = getChildCount();
        boolean r0 = false;
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
    L4:
        if (r13 >= r11) goto L23;
        View r2 = getChildAt(r13);
        if (r2.getVisibility() == 8) goto L22;
        LayoutParams r1 = (LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (r1.isNestedScrollAccepted(r23) == false) goto L22;
        b r3 = r1.getBehavior();
        if (r3 == null) goto L22;
        int[] r7 = this.mBehaviorConsumed;
        r7[0] = 0;
        r7[1] = 0;
        r3.a(this, r2, r18, r19, r20, r21, r22, r23, r7);
        int[] r4 = this.mBehaviorConsumed;
        if (r21 <= 0) goto L16;
        int r5 = Math.max(r14, r4[0]);
    L17:
        r14 = r5;
        if (r22 <= 0) goto L20;
        boolean r6 = true;
        int r8 = Math.max(r15, this.mBehaviorConsumed[1]);
    L21:
        r15 = r8;
        r0 = r6;
        goto L22
    L20:
        r6 = true;
        r8 = Math.min(r15, this.mBehaviorConsumed[1]);
        goto L21
    L16:
        r5 = Math.min(r14, r4[0]);
    L22:
        r13 = r13 + 1;
        goto L4
    L23:
        r24[0] = r24[0] + r14;
        r24[1] = r24[1] + r15;
        if (r0 == false) goto L32;
        onChildViewsChanged(1);
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public void onNestedPreScroll(View r7, int r8, int r9, int[] r10) {
        onNestedPreScroll(r7, r8, r9, r10, 0);
    }

    @Override // androidx.core.view.q
    public void onNestedPreScroll(View r17, int r18, int r19, int[] r20, int r21) {
        int r9 = getChildCount();
        boolean r0 = false;
        int r11 = 0;
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r11 >= r9) goto L23;
        View r2 = getChildAt(r11);
        if (r2.getVisibility() == 8) goto L22;
        LayoutParams r1 = (LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (r1.isNestedScrollAccepted(r21) == false) goto L22;
        b r3 = r1.getBehavior();
        if (r3 == null) goto L22;
        int[] r6 = this.mBehaviorConsumed;
        r6[0] = 0;
        r6[1] = 0;
        r3.a(this, r2, r17, r18, r19, r6, r21);
        int[] r4 = this.mBehaviorConsumed;
        if (r18 <= 0) goto L16;
        int r5 = Math.max(r12, r4[0]);
    L17:
        r12 = r5;
        int[] r7 = this.mBehaviorConsumed;
        if (r19 <= 0) goto L20;
        int r8 = Math.max(r13, r7[1]);
    L21:
        r13 = r8;
        r0 = true;
        goto L22
    L20:
        r8 = Math.min(r13, r7[1]);
        goto L21
    L16:
        r5 = Math.min(r12, r4[0]);
    L22:
        r11 = r11 + 1;
        goto L4
    L23:
        r20[0] = r12;
        r20[1] = r13;
        if (r0 == false) goto L32;
        onChildViewsChanged(1);
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public boolean onNestedFling(View r12, float r13, float r14, boolean r15) {
        int r0 = getChildCount();
        int r2 = 0;
        boolean r3 = false;
    L3:
        if (r2 >= r0) goto L14;
        View r6 = getChildAt(r2);
        if (r6.getVisibility() == 8) goto L13;
        LayoutParams r4 = (LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (r4.isNestedScrollAccepted(0) == false) goto L13;
        b r5 = r4.getBehavior();
        if (r5 == null) goto L13;
        r3 = r3 | r5.a(this, r6, r12, r13, r14, r15);
    L13:
        r2 = r2 + 1;
        goto L3
    L14:
        if (r3 == false) goto L16;
        onChildViewsChanged(1);
    L16:
        return r3;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public boolean onNestedPreFling(View r11, float r12, float r13) {
        int r0 = getChildCount();
        int r2 = 0;
        boolean r3 = false;
    L3:
        if (r2 >= r0) goto L14;
        View r6 = getChildAt(r2);
        if (r6.getVisibility() == 8) goto L13;
        LayoutParams r4 = (LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (r4.isNestedScrollAccepted(0) == false) goto L13;
        b r5 = r4.getBehavior();
        if (r5 == null) goto L13;
        r3 = r3 | r5.a(this, r6, r11, r12, r13);
    L13:
        r2 = r2 + 1;
        goto L3
    L14:
        return r3;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.a();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r8) {
        Parcelable r9 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r8, Parcelable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, SavedState.class) == true) goto L6;
        super.onRestoreInstanceState(r9);
        return;
    L6:
        SavedState r10 = (SavedState) ZeusTransformUtils.preCheckCast(r9, SavedState.class, "com.obric.aiagent.plugin");
        super.onRestoreInstanceState(r10.getSuperState());
        SparseArray<Parcelable> r11 = r10.behaviorStates;
        int r0 = 0;
        int r2 = getChildCount();
    L7:
        if (r0 >= r2) goto L15;
        View r3 = getChildAt(r0);
        int r4 = r3.getId();
        b r5 = getResolvedLayoutParams(r3).getBehavior();
        if (r4 == (-1)) goto L14;
        if (r5 == null) goto L14;
        Parcelable r6 = (Parcelable) ZeusTransformUtils.preCheckCast(r11.get(r4), Parcelable.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L14;
        r5.a(this, r3, r6);
    L14:
        r0 = r0 + 1;
        goto L7
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r0 = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> r1 = new SparseArray();
        int r2 = getChildCount();
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L11;
        View r4 = getChildAt(r3);
        int r5 = r4.getId();
        b r6 = ((LayoutParams) ZeusTransformUtils.preCheckCast(r4.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).getBehavior();
        if (r5 == (-1)) goto L10;
        if (r6 == null) goto L10;
        Parcelable r7 = r6.d(this, r4);
        if (r7 == null) goto L10;
        r1.append(r5, r7);
    L10:
        r3 = r3 + 1;
        goto L3
    L11:
        r0.behaviorStates = r1;
        return r0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View r4, Rect r5, boolean r6) {
        b r0 = ((LayoutParams) ZeusTransformUtils.preCheckCast(r4.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).getBehavior();
        if (r0 == null) goto L9;
        if (r0.a(this, r4, r5, r6) == false) goto L9;
        return true;
    L9:
        return super.requestChildRectangleOnScreen(r4, r5, r6);
    }

    private void setupForInsets() {
        if (Build.VERSION.SDK_INT >= 21) goto L6;
        return;
    L6:
        if (ViewCompat.v(this) == true) goto L8;
        ViewCompat.a(this, null);
        return;
    L8:
        if (this.mApplyWindowInsetsListener != null) goto L10;
        this.mApplyWindowInsetsListener = new AnonymousClass1(this);
    L10:
        ViewCompat.a(this, this.mApplyWindowInsetsListener);
        setSystemUiVisibility(1280);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_androidx_coordinatorlayout_widget_CoordinatorLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_androidx_coordinatorlayout_widget_CoordinatorLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
