package androidx.drawerlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.Openable;
import androidx.customview.widget.ViewDragHelper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
public class DrawerLayout extends ViewGroup implements Openable {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.drawerlayout.widget.DrawerLayout";
    private static final boolean ALLOW_EDGE_LOCK = false;
    static final boolean CAN_HIDE_DESCENDANTS = false;
    private static final boolean CHILDREN_DISALLOW_INTERCEPT = true;
    private static final int DEFAULT_SCRIM_COLOR = -1728053248;
    static final int[] LAYOUT_ATTRS = null;
    public static final int LOCK_MODE_LOCKED_CLOSED = 1;
    public static final int LOCK_MODE_LOCKED_OPEN = 2;
    public static final int LOCK_MODE_UNDEFINED = 3;
    public static final int LOCK_MODE_UNLOCKED = 0;
    private static final int MIN_DRAWER_MARGIN = 64;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final int PEEK_DELAY = 160;
    private static final boolean SET_DRAWER_SHADOW_FROM_ELEVATION = false;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "DrawerLayout";
    private static final int[] THEME_ATTRS = null;
    private static final float TOUCH_SLOP_SENSITIVITY = 1.0f;
    private static boolean sEdgeSizeUsingSystemGestureInsets;
    private final AccessibilityViewCommand mActionDismiss;
    private final ChildAccessibilityDelegate mChildAccessibilityDelegate;
    private Rect mChildHitRect;
    private Matrix mChildInvertedMatrix;
    private boolean mChildrenCanceledTouch;
    private boolean mDrawStatusBarBackground;
    private float mDrawerElevation;
    private int mDrawerState;
    private boolean mFirstLayout;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private Object mLastInsets;
    private final ViewDragCallback mLeftCallback;
    private final ViewDragHelper mLeftDragger;
    private DrawerListener mListener;
    private List<DrawerListener> mListeners;
    private int mLockModeEnd;
    private int mLockModeLeft;
    private int mLockModeRight;
    private int mLockModeStart;
    private int mMinDrawerMargin;
    private final ArrayList<View> mNonDrawerViews;
    private final ViewDragCallback mRightCallback;
    private final ViewDragHelper mRightDragger;
    private int mScrimColor;
    private float mScrimOpacity;
    private Paint mScrimPaint;
    private Drawable mShadowEnd;
    private Drawable mShadowLeft;
    private Drawable mShadowLeftResolved;
    private Drawable mShadowRight;
    private Drawable mShadowRightResolved;
    private Drawable mShadowStart;
    private Drawable mStatusBarBackground;
    private CharSequence mTitleLeft;
    private CharSequence mTitleRight;

    public class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final Rect mTmpRect;
        final /* synthetic */ DrawerLayout this$0;

        public AccessibilityDelegate(DrawerLayout r100) {
            this.this$0 = r100;
            this.mTmpRect = new Rect();
        }

        private void addChildrenForAccessibility(AccessibilityNodeInfoCompat r100, ViewGroup r101) {
            int r102 = r101.getChildCount();
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            View r104 = r101.getChildAt(r103);
            if (DrawerLayout.includeChildForAccessibility(r104) == false) goto L7;
            r100.addChild(r104);
        L7:
            r103 = r103 + 1;
            goto L3
        }

        private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat r100, AccessibilityNodeInfoCompat r101) {
            Rect r102 = this.mTmpRect;
            r101.getBoundsInScreen(r102);
            r100.setBoundsInScreen(r102);
            r100.setVisibleToUser(r101.isVisibleToUser());
            r100.setPackageName(r101.getPackageName());
            r100.setClassName(r101.getClassName());
            r100.setContentDescription(r101.getContentDescription());
            r100.setEnabled(r101.isEnabled());
            r100.setFocused(r101.isFocused());
            r100.setAccessibilityFocused(r101.isAccessibilityFocused());
            r100.setSelected(r101.isSelected());
            r100.addAction(r101.getActions());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean dispatchPopulateAccessibilityEvent(View r100, AccessibilityEvent r101) {
            if (r101.getEventType() != 32) goto L12;
            List<CharSequence> r102 = r101.getText();
            View r103 = this.this$0.findVisibleDrawer();
            if (r103 == null) goto L13;
            int r104 = this.this$0.getDrawerViewAbsoluteGravity(r103);
            CharSequence r105 = this.this$0.getDrawerTitle(r104);
            if (r105 == null) goto L14;
            r102.add(r105);
            return true;
        L14:
            return true;
        L13:
            return true;
        L12:
            return super.dispatchPopulateAccessibilityEvent(r100, r101);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View r100, AccessibilityEvent r101) {
            super.onInitializeAccessibilityEvent(r100, r101);
            r101.setClassName(DrawerLayout.ACCESSIBILITY_CLASS_NAME);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
            if (DrawerLayout.CAN_HIDE_DESCENDANTS == false) goto L5;
            super.onInitializeAccessibilityNodeInfo(r100, r101);
        L9:
            r101.setClassName(DrawerLayout.ACCESSIBILITY_CLASS_NAME);
            r101.setFocusable(false);
            r101.setFocused(false);
            r101.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_FOCUS);
            r101.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_FOCUS);
            return;
        L5:
            AccessibilityNodeInfoCompat r102 = AccessibilityNodeInfoCompat.obtain(r101);
            super.onInitializeAccessibilityNodeInfo(r100, r102);
            r101.setSource(r100);
            Object r103 = ViewCompat.getParentForAccessibility(r100);
            if ((r103 instanceof View) == false) goto L8;
            r101.setParent((View) r103);
        L8:
            copyNodeInfoNoChildren(r101, r102);
            r102.recycle();
            addChildrenForAccessibility(r101, (ViewGroup) r100);
            goto L9
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup r100, View r101, AccessibilityEvent r102) {
            if (DrawerLayout.CAN_HIDE_DESCENDANTS == true) goto L10;
            if (DrawerLayout.includeChildForAccessibility(r101) == true) goto L10;
            return false;
        L10:
            return super.onRequestSendAccessibilityEvent(r100, r101, r102);
        }
    }

    public static final class ChildAccessibilityDelegate extends AccessibilityDelegateCompat {
        public ChildAccessibilityDelegate() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
            super.onInitializeAccessibilityNodeInfo(r100, r101);
            if (DrawerLayout.includeChildForAccessibility(r100) == true) goto L6;
            r101.setParent(null);
            return;
        }
    }

    public interface DrawerListener {
        void onDrawerClosed(View r100);

        void onDrawerOpened(View r100);

        void onDrawerSlide(View r100, float r101);

        void onDrawerStateChanged(int r100);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int FLAG_IS_CLOSING = 4;
        private static final int FLAG_IS_OPENED = 1;
        private static final int FLAG_IS_OPENING = 2;
        public int gravity;
        boolean isPeeking;
        float onScreen;
        int openState;

        public LayoutParams(LayoutParams r100) {
            super(r100);
            this.gravity = 0;
            this.gravity = r100.gravity;
        }

        public LayoutParams(ViewGroup.LayoutParams r100) {
            super(r100);
            this.gravity = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r100) {
            super(r100);
            this.gravity = 0;
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.gravity = 0;
            TypedArray r102 = r100.obtainStyledAttributes(r101, DrawerLayout.LAYOUT_ATTRS);
            this.gravity = r102.getInt(0, 0);
            r102.recycle();
        }

        public LayoutParams(int r100, int r101) {
            super(r100, r101);
            this.gravity = 0;
        }

        public LayoutParams(int r100, int r101, int r102) {
            this(r100, r101);
            this.gravity = r102;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int lockModeEnd;
        int lockModeLeft;
        int lockModeRight;
        int lockModeStart;
        int openDrawerGravity;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcelable r100) {
            super(r100);
            this.openDrawerGravity = 0;
        }

        public SavedState(Parcel r100, ClassLoader r101) {
            super(r100, r101);
            this.openDrawerGravity = 0;
            this.openDrawerGravity = r100.readInt();
            this.lockModeLeft = r100.readInt();
            this.lockModeRight = r100.readInt();
            this.lockModeStart = r100.readInt();
            this.lockModeEnd = r100.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeInt(this.openDrawerGravity);
            r100.writeInt(this.lockModeLeft);
            r100.writeInt(this.lockModeRight);
            r100.writeInt(this.lockModeStart);
            r100.writeInt(this.lockModeEnd);
        }
    }

    public static abstract class SimpleDrawerListener implements DrawerListener {
        public SimpleDrawerListener() {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerClosed(View r100) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerOpened(View r100) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerSlide(View r100, float r101) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerStateChanged(int r100) {
        }
    }

    public class ViewDragCallback extends ViewDragHelper.Callback {
        private final int mAbsGravity;
        private ViewDragHelper mDragger;
        private final Runnable mPeekRunnable;
        final /* synthetic */ DrawerLayout this$0;

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean onEdgeLock(int r100) {
            return false;
        }

        private void closeOtherDrawer() {
            int r100 = 3;
            if (this.mAbsGravity != 3) goto L5;
            r100 = 5;
        L5:
            View r101 = this.this$0.findDrawerWithGravity(r100);
            if (r101 == null) goto L9;
            this.this$0.closeDrawer(r101);
            return;
        }

        public void peekDrawer() {
            int r100 = this.mDragger.getEdgeSize();
            int r101 = 0;
            if (this.mAbsGravity != 3) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == false) goto L11;
            View r103 = this.this$0.findDrawerWithGravity(3);
            if (r103 == null) goto L10;
            r101 = -r103.getWidth();
        L10:
            int r104 = r101 + r100;
        L12:
            if (r103 == null) goto L23;
            if (r102 == true) goto L15;
        L16:
            if (r102 == false) goto L18;
            return;
        L18:
            if (r103.getLeft() > r104) goto L20;
            return;
        L20:
            if (this.this$0.getDrawerLockMode(r103) != 0) goto L26;
            LayoutParams r105 = (LayoutParams) r103.getLayoutParams();
            this.mDragger.smoothSlideViewTo(r103, r104, r103.getTop());
            r105.isPeeking = true;
            this.this$0.invalidate();
            closeOtherDrawer();
            this.this$0.cancelChildViewTouch();
            return;
        L26:
            return;
        L15:
            if (r103.getLeft() < r104) goto L20;
        L23:
            return;
        L11:
            r103 = this.this$0.findDrawerWithGravity(5);
            r104 = this.this$0.getWidth() - r100;
            goto L12
        L5:
            r102 = false;
            goto L6
        }

        public void removeCallbacks() {
            this.this$0.removeCallbacks(this.mPeekRunnable);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View r100) {
            if (this.this$0.isDrawerView(r100) == true) goto L7;
            return 0;
        L7:
            return r100.getWidth();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int r100) {
            this.this$0.updateDrawerState(r100, this.mDragger.getCapturedView());
        }

        public void setDragger(ViewDragHelper r100) {
            this.mDragger = r100;
        }

        public ViewDragCallback(DrawerLayout r100, int r101) {
            this.this$0 = r100;
            this.mPeekRunnable = new AnonymousClass1(this);
            this.mAbsGravity = r101;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeDragStarted(int r100, int r101) {
            if ((r100 & 1) != 1) goto L5;
            View r102 = this.this$0.findDrawerWithGravity(3);
        L6:
            if (r102 != null) goto L8;
            return;
        L8:
            if (this.this$0.getDrawerLockMode(r102) != 0) goto L12;
            this.mDragger.captureChildView(r102, r101);
            return;
        L12:
            return;
        L5:
            r102 = this.this$0.findDrawerWithGravity(5);
            goto L6
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeTouched(int r100, int r101) {
            this.this$0.postDelayed(this.mPeekRunnable, 160);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(View r100, int r101) {
            ((LayoutParams) r100.getLayoutParams()).isPeeking = false;
            closeOtherDrawer();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View r100, int r101) {
            if (this.this$0.isDrawerView(r100) == true) goto L5;
        L9:
            return false;
        L5:
            if (this.this$0.checkDrawerViewAbsoluteGravity(r100, this.mAbsGravity) == false) goto L9;
            if (this.this$0.getDrawerLockMode(r100) != 0) goto L9;
            return true;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View r100, int r101, int r102) {
            if (this.this$0.checkDrawerViewAbsoluteGravity(r100, 3) == true) goto L5;
            int r103 = this.this$0.getWidth();
            return Math.max(r103 - r100.getWidth(), Math.min(r101, r103));
        L5:
            return Math.max(-r100.getWidth(), Math.min(r101, 0));
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View r100, int r101, int r102) {
            return r100.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View r100, float r101, float r102) {
            float r103 = this.this$0.getDrawerViewOffset(r100);
            int r104 = r100.getWidth();
            if (this.this$0.checkDrawerViewAbsoluteGravity(r100, 3) == true) goto L5;
            int r105 = this.this$0.getWidth();
            if (r101 >= 0.0f) goto L15;
        L18:
            r105 = r105 - r104;
        L19:
            int r106 = r105;
        L20:
            this.mDragger.settleCapturedViewAt(r106, r100.getTop());
            this.this$0.invalidate();
            return;
        L15:
            if (r101 != 0.0f) goto L19;
            if (r103 <= 0.5f) goto L19;
        L5:
            if (r101 > 0.0f) goto L11;
            if (r101 == 0.0f) goto L8;
        L10:
            r106 = -r104;
            goto L20
        L8:
            if (r103 <= 0.5f) goto L10;
        L11:
            r106 = 0;
            goto L20
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View r100, int r101, int r102, int r103, int r104) {
            int r105 = r100.getWidth();
            if (this.this$0.checkDrawerViewAbsoluteGravity(r100, 3) == false) goto L5;
            float r106 = r101 + r105;
        L6:
            float r107 = r106 / r105;
            this.this$0.setDrawerViewOffset(r100, r107);
            if (r107 != 0.0f) goto L9;
            int r108 = 4;
        L10:
            r100.setVisibility(r108);
            this.this$0.invalidate();
            return;
        L9:
            r108 = 0;
            goto L10
        L5:
            r106 = this.this$0.getWidth() - r101;
            goto L6
        }
    }

    static {
        boolean r100 = true;
        THEME_ATTRS = new int[]{R.attr.colorPrimaryDark};
        LAYOUT_ATTRS = new int[]{R.attr.layout_gravity};
        int r101 = Build.VERSION.SDK_INT;
        CAN_HIDE_DESCENDANTS = true;
        SET_DRAWER_SHADOW_FROM_ELEVATION = true;
        if (r101 >= 29) goto L6;
        r100 = false;
    L6:
        sEdgeSizeUsingSystemGestureInsets = r100;
    }

    public void closeDrawers() {
        closeDrawers(false);
    }

    private void resolveShadowDrawables() {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION == false) goto L5;
        return;
    L5:
        this.mShadowLeftResolved = resolveLeftShadow();
        this.mShadowRightResolved = resolveRightShadow();
    }

    public void cancelChildViewTouch() {
        if (this.mChildrenCanceledTouch == true) goto L10;
        long r100 = SystemClock.uptimeMillis();
        MotionEvent r101 = MotionEvent.obtain(r100, r100, 3, 0.0f, 0.0f, 0);
        int r102 = getChildCount();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L7;
        getChildAt(r103).dispatchTouchEvent(r101);
        r103 = r103 + 1;
        goto L5
    L7:
        r101.recycle();
        this.mChildrenCanceledTouch = true;
        return;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public float getDrawerElevation() {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION == true) goto L5;
        return 0.0f;
    L5:
        return this.mDrawerElevation;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInLayout == true) goto L6;
        super.requestLayout();
        return;
    }

    private boolean hasPeekingDrawer() {
        int r100 = getChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L9;
        if (((LayoutParams) getChildAt(r101).getLayoutParams()).isPeeking == true) goto L6;
        r101 = r101 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private boolean hasVisibleDrawer() {
        if (findVisibleDrawer() == null) goto L5;
        return true;
    L5:
        return false;
    }

    private Drawable resolveLeftShadow() {
        int r100 = ViewCompat.getLayoutDirection(this);
        if (r100 != 0) goto L8;
        Drawable r101 = this.mShadowStart;
        if (r101 == null) goto L13;
        mirror(r101, r100);
        return this.mShadowStart;
    L13:
        return this.mShadowLeft;
    L8:
        Drawable r102 = this.mShadowEnd;
        if (r102 == null) goto L13;
        mirror(r102, r100);
        return this.mShadowEnd;
    }

    private Drawable resolveRightShadow() {
        int r100 = ViewCompat.getLayoutDirection(this);
        if (r100 != 0) goto L8;
        Drawable r101 = this.mShadowEnd;
        if (r101 == null) goto L13;
        mirror(r101, r100);
        return this.mShadowEnd;
    L13:
        return this.mShadowRight;
    L8:
        Drawable r102 = this.mShadowStart;
        if (r102 == null) goto L13;
        mirror(r102, r100);
        return this.mShadowStart;
    }

    @Override // androidx.customview.widget.Openable
    public void close() {
        closeDrawer(GravityCompat.START);
    }

    @Override // android.view.View
    public void computeScroll() {
        int r100 = getChildCount();
        float r101 = 0.0f;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        r101 = Math.max(r101, ((LayoutParams) getChildAt(r102).getLayoutParams()).onScreen);
        r102 = r102 + 1;
        goto L3
    L5:
        this.mScrimOpacity = r101;
        boolean r103 = this.mLeftDragger.continueSettling(true);
        boolean r104 = this.mRightDragger.continueSettling(true);
        if (r103 == true) goto L8;
        if (r104 == true) goto L8;
        return;
    L8:
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public View findOpenDrawer() {
        int r100 = getChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L8;
        View r102 = getChildAt(r101);
        if ((((LayoutParams) r102.getLayoutParams()).openState & 1) == 1) goto L6;
        r101 = r101 + 1;
        goto L3
    L6:
        return r102;
    L8:
        return null;
    }

    public View findVisibleDrawer() {
        int r100 = getChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L10;
        View r102 = getChildAt(r101);
        if (isDrawerView(r102) == false) goto L9;
        if (isDrawerVisible(r102) == false) goto L9;
        return r102;
    L9:
        r101 = r101 + 1;
        goto L3
    L10:
        return null;
    }

    @Override // androidx.customview.widget.Openable
    public boolean isOpen() {
        return isDrawerOpen(GravityCompat.START);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        int r101 = getChildCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L17;
        LayoutParams r103 = (LayoutParams) getChildAt(r102).getLayoutParams();
        int r104 = r103.openState;
        boolean r105 = true;
        if (r104 != 1) goto L7;
        boolean r106 = true;
    L9:
        if (r104 == 2) goto L12;
        r105 = false;
    L12:
        if (r106 == true) goto L16;
        if (r105 == true) goto L16;
        r102 = r102 + 1;
    L16:
        r100.openDrawerGravity = r103.gravity;
        goto L17
    L7:
        r106 = false;
    L17:
        r100.lockModeLeft = this.mLockModeLeft;
        r100.lockModeRight = this.mLockModeRight;
        r100.lockModeStart = this.mLockModeStart;
        r100.lockModeEnd = this.mLockModeEnd;
        return r100;
    }

    @Override // androidx.customview.widget.Openable
    public void open() {
        openDrawer(GravityCompat.START);
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.mStatusBarBackground;
    }

    public DrawerLayout(Context r100) {
        this(r100, null);
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_drawerlayout_widget_DrawerLayout_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static String gravityToString(int r100) {
        if ((r100 & 3) != 3) goto L7;
        return "LEFT";
    L7:
        if ((r100 & 5) != 5) goto L11;
        return "RIGHT";
    L11:
        return Integer.toHexString(r100);
    }

    private static boolean hasOpaqueBackground(View r100) {
        Drawable r101 = r100.getBackground();
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.getOpacity() != (-1)) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean includeChildForAccessibility(View r100) {
        if (ViewCompat.getImportantForAccessibility(r100) != 4) goto L5;
    L7:
        return false;
    L5:
        if (ViewCompat.getImportantForAccessibility(r100) == 2) goto L7;
        return true;
    }

    private void updateChildAccessibilityAction(View r100) {
        AccessibilityNodeInfoCompat.AccessibilityActionCompat r101 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS;
        ViewCompat.removeAccessibilityAction(r100, r101.getId());
        if (isDrawerOpen(r100) == true) goto L5;
        return;
    L5:
        if (getDrawerLockMode(r100) == 2) goto L9;
        ViewCompat.replaceAccessibilityAction(r100, r101, null, this.mActionDismiss);
        return;
    }

    public void addDrawerListener(DrawerListener r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mListeners != null) goto L7;
        this.mListeners = new ArrayList();
    L7:
        this.mListeners.add(r100);
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

    public void closeDrawer(int r100) {
        closeDrawer(r100, true);
    }

    public void closeDrawers(boolean r110) {
        int r100 = getChildCount();
        int r101 = 0;
        boolean r102 = false;
    L3:
        if (r101 >= r100) goto L16;
        View r103 = getChildAt(r101);
        LayoutParams r104 = (LayoutParams) r103.getLayoutParams();
        if (isDrawerView(r103) == false) goto L15;
        if (r110 == true) goto L8;
    L10:
        int r105 = r103.getWidth();
        if (checkDrawerViewAbsoluteGravity(r103, 3) == false) goto L13;
        boolean r106 = this.mLeftDragger.smoothSlideViewTo(r103, -r105, r103.getTop());
    L14:
        r102 = r102 | r106;
        r104.isPeeking = false;
        goto L15
    L13:
        r106 = this.mRightDragger.smoothSlideViewTo(r103, getWidth(), r103.getTop());
        goto L14
    L8:
        if (r104.isPeeking == true) goto L10;
    L15:
        r101 = r101 + 1;
        goto L3
    L16:
        this.mLeftCallback.removeCallbacks();
        this.mRightCallback.removeCallbacks();
        if (r102 == false) goto L24;
        invalidate();
        return;
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent r100) {
        if ((r100.getSource() & 2) == 0) goto L25;
        if (r100.getAction() == 10) goto L25;
        if (this.mScrimOpacity <= 0.0f) goto L25;
        int r101 = getChildCount();
        if (r101 == 0) goto L22;
        float r102 = r100.getX();
        float r103 = r100.getY();
        int r104 = r101 - 1;
    L12:
        if (r104 < 0) goto L31;
        View r105 = getChildAt(r104);
        if (isInBoundsOfChild(r102, r103, r105) == false) goto L21;
        if (isContentView(r105) == true) goto L21;
        if (dispatchTransformedGenericPointerEvent(r100, r105) == false) goto L21;
        return true;
    L21:
        r104 = r104 - 1;
        goto L12
    L31:
        return false;
    L22:
        return false;
    L25:
        return super.dispatchGenericMotionEvent(r100);
    }

    public void dispatchOnDrawerClosed(View r100) {
        LayoutParams r101 = (LayoutParams) r100.getLayoutParams();
        if ((r101.openState & 1) != 1) goto L16;
        r101.openState = 0;
        List<DrawerListener> r102 = this.mListeners;
        if (r102 == null) goto L9;
        int r103 = r102.size() - 1;
    L7:
        if (r103 < 0) goto L9;
        ((DrawerListener) ListProtector.get(this.mListeners, r103)).onDrawerClosed(r100);
        r103 = r103 - 1;
    L9:
        updateChildrenImportantForAccessibility(r100, false);
        updateChildAccessibilityAction(r100);
        if (hasWindowFocus() == false) goto L17;
        View r104 = getRootView();
        if (r104 == null) goto L18;
        r104.sendAccessibilityEvent(32);
        return;
    L18:
        return;
    L17:
        return;
    }

    public void dispatchOnDrawerOpened(View r100) {
        LayoutParams r101 = (LayoutParams) r100.getLayoutParams();
        if ((r101.openState & 1) != 0) goto L14;
        r101.openState = 1;
        List<DrawerListener> r102 = this.mListeners;
        if (r102 == null) goto L9;
        int r103 = r102.size() - 1;
    L7:
        if (r103 < 0) goto L9;
        ((DrawerListener) ListProtector.get(this.mListeners, r103)).onDrawerOpened(r100);
        r103 = r103 - 1;
    L9:
        updateChildrenImportantForAccessibility(r100, true);
        updateChildAccessibilityAction(r100);
        if (hasWindowFocus() == false) goto L15;
        sendAccessibilityEvent(32);
        return;
    L15:
        return;
    }

    public View findDrawerWithGravity(int r100) {
        int r101 = GravityCompat.getAbsoluteGravity(r100, ViewCompat.getLayoutDirection(this)) & 7;
        int r102 = getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        View r104 = getChildAt(r103);
        if ((getDrawerViewAbsoluteGravity(r104) & 7) == r101) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        if ((r100 instanceof LayoutParams) == false) goto L6;
        return new LayoutParams((LayoutParams) r100);
    L6:
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r100);
    L9:
        return new LayoutParams(r100);
    }

    public int getDrawerLockMode(int r100) {
        int r101 = ViewCompat.getLayoutDirection(this);
        if (r100 != 3) goto L5;
        int r102 = this.mLockModeLeft;
        if (r102 == 3) goto L38;
        return r102;
    L38:
        if (r101 != 0) goto L40;
        int r103 = this.mLockModeStart;
    L41:
        if (r103 == 3) goto L47;
        return r103;
    L47:
        return 0;
    L40:
        r103 = this.mLockModeEnd;
        goto L41
    L5:
        if (r100 != 5) goto L7;
        int r104 = this.mLockModeRight;
        if (r104 == 3) goto L30;
        return r104;
    L30:
        if (r101 != 0) goto L32;
        int r105 = this.mLockModeEnd;
    L33:
        if (r105 == 3) goto L46;
        return r105;
    L46:
        return 0;
    L32:
        r105 = this.mLockModeStart;
        goto L33
    L7:
        if (r100 != 8388611) goto L9;
        int r106 = this.mLockModeStart;
        if (r106 == 3) goto L22;
        return r106;
    L22:
        if (r101 != 0) goto L24;
        int r107 = this.mLockModeLeft;
    L25:
        if (r107 == 3) goto L45;
        return r107;
    L45:
        return 0;
    L24:
        r107 = this.mLockModeRight;
        goto L25
    L9:
        if (r100 != 8388613) goto L48;
        int r108 = this.mLockModeEnd;
        if (r108 == 3) goto L14;
        return r108;
    L14:
        if (r101 != 0) goto L16;
        int r109 = this.mLockModeRight;
    L17:
        if (r109 == 3) goto L43;
        return r109;
    L43:
        return 0;
    L16:
        r109 = this.mLockModeLeft;
        goto L17
    L48:
        return 0;
    }

    public CharSequence getDrawerTitle(int r100) {
        int r101 = GravityCompat.getAbsoluteGravity(r100, ViewCompat.getLayoutDirection(this));
        if (r101 != 3) goto L7;
        return this.mTitleLeft;
    L7:
        if (r101 == 5) goto L9;
        return null;
    L9:
        return this.mTitleRight;
    }

    public int getDrawerViewAbsoluteGravity(View r100) {
        return GravityCompat.getAbsoluteGravity(((LayoutParams) r100.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(this));
    }

    public float getDrawerViewOffset(View r100) {
        return ((LayoutParams) r100.getLayoutParams()).onScreen;
    }

    public boolean isContentView(View r100) {
        if (((LayoutParams) r100.getLayoutParams()).gravity != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isDrawerOpen(View r100) {
        if (isDrawerView(r100) == false) goto L10;
        if ((((LayoutParams) r100.getLayoutParams()).openState & 1) == 1) goto L11;
        return false;
    L11:
        return true;
    L10:
        throw new IllegalArgumentException("View " + r100 + " is not a drawer");
    }

    public boolean isDrawerView(View r100) {
        int r101 = GravityCompat.getAbsoluteGravity(((LayoutParams) r100.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(r100));
        if ((r101 & 3) == 0) goto L6;
        return true;
    L6:
        if ((r101 & 5) == 0) goto L8;
        return true;
    L8:
        return false;
    }

    public boolean isDrawerVisible(View r100) {
        if (isDrawerView(r100) == false) goto L10;
        if (((LayoutParams) r100.getLayoutParams()).onScreen <= 0.0f) goto L7;
        return true;
    L7:
        return false;
    L10:
        throw new IllegalArgumentException("View " + r100 + " is not a drawer");
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
        super.onDraw(r100);
        if (this.mDrawStatusBarBackground == true) goto L5;
        return;
    L5:
        if (this.mStatusBarBackground == null) goto L14;
        Object r101 = this.mLastInsets;
        if (r101 == null) goto L9;
        int r102 = ((WindowInsets) r101).getSystemWindowInsetTop();
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
        boolean r102 = this.mLeftDragger.shouldInterceptTouchEvent(r100) | this.mRightDragger.shouldInterceptTouchEvent(r100);
        if (r101 == 0) goto L14;
        if (r101 != 1) goto L6;
    L12:
        closeDrawers(true);
        this.mChildrenCanceledTouch = false;
    L13:
        boolean r103 = false;
    L23:
        if (r102 == true) goto L32;
        if (r103 == false) goto L26;
        return true;
    L26:
        if (hasPeekingDrawer() == false) goto L28;
        return true;
    L28:
        if (this.mChildrenCanceledTouch == true) goto L35;
        return false;
    L35:
        return true;
    L32:
        return true;
    L6:
        if (r101 == 2) goto L10;
        if (r101 == 3) goto L12;
    L10:
        if (this.mLeftDragger.checkTouchSlop(3) == false) goto L13;
        this.mLeftCallback.removeCallbacks();
        this.mRightCallback.removeCallbacks();
        goto L13
    L14:
        float r104 = r100.getX();
        float r105 = r100.getY();
        this.mInitialMotionX = r104;
        this.mInitialMotionY = r105;
        if (this.mScrimOpacity <= 0.0f) goto L21;
        View r106 = this.mLeftDragger.findTopChildUnder((int) r104, (int) r105);
        if (r106 == null) goto L21;
        if (isContentView(r106) == false) goto L21;
        r103 = true;
    L22:
        this.mChildrenCanceledTouch = false;
    L21:
        r103 = false;
        goto L22
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r100);
        return;
    L6:
        SavedState r101 = (SavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        int r102 = r101.openDrawerGravity;
        if (r102 == 0) goto L11;
        View r103 = findDrawerWithGravity(r102);
        if (r103 == null) goto L11;
        openDrawer(r103);
    L11:
        int r104 = r101.lockModeLeft;
        if (r104 == 3) goto L14;
        setDrawerLockMode(r104, 3);
    L14:
        int r105 = r101.lockModeRight;
        if (r105 == 3) goto L17;
        setDrawerLockMode(r105, 5);
    L17:
        int r106 = r101.lockModeStart;
        if (r106 == 3) goto L20;
        setDrawerLockMode(r106, GravityCompat.START);
    L20:
        int r107 = r101.lockModeEnd;
        if (r107 == 3) goto L24;
        setDrawerLockMode(r107, GravityCompat.END);
        return;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int r100) {
        resolveShadowDrawables();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        this.mLeftDragger.processTouchEvent(r100);
        this.mRightDragger.processTouchEvent(r100);
        int r101 = r100.getAction() & 255;
        boolean r102 = false;
        if (r101 == 0) goto L21;
        if (r101 != 1) goto L6;
        float r103 = r100.getX();
        float r104 = r100.getY();
        View r105 = this.mLeftDragger.findTopChildUnder((int) r103, (int) r104);
        if (r105 != null) goto L12;
    L19:
        r102 = true;
    L20:
        closeDrawers(r102);
    L22:
        return true;
    L12:
        if (isContentView(r105) == false) goto L19;
        float r106 = r103 - this.mInitialMotionX;
        float r107 = r104 - this.mInitialMotionY;
        int r108 = this.mLeftDragger.getTouchSlop();
        if (((r106 * r106) + (r107 * r107)) >= (r108 * r108)) goto L19;
        View r109 = findOpenDrawer();
        if (r109 == null) goto L19;
        if (getDrawerLockMode(r109) != 2) goto L20;
    L6:
        if (r101 != 3) goto L22;
        closeDrawers(true);
        this.mChildrenCanceledTouch = false;
        goto L22
    L21:
        float r110 = r100.getX();
        float r111 = r100.getY();
        this.mInitialMotionX = r110;
        this.mInitialMotionY = r111;
        this.mChildrenCanceledTouch = false;
        goto L22
    }

    public void openDrawer(int r100) {
        openDrawer(r100, true);
    }

    public void removeDrawerListener(DrawerListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        List<DrawerListener> r101 = this.mListeners;
        if (r101 != null) goto L7;
        return;
    L7:
        r101.remove(r100);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r100) {
        super.requestDisallowInterceptTouchEvent(r100);
        if (r100 == false) goto L6;
        closeDrawers(true);
        return;
    }

    public void setDrawerElevation(float r100) {
        this.mDrawerElevation = r100;
        int r101 = 0;
    L4:
        if (r101 >= getChildCount()) goto L9;
        View r102 = getChildAt(r101);
        if (isDrawerView(r102) == false) goto L8;
        ViewCompat.setElevation(r102, this.mDrawerElevation);
    L8:
        r101 = r101 + 1;
        goto L4
    }

    public void setDrawerListener(DrawerListener r100) {
        DrawerListener r101 = this.mListener;
        if (r101 == null) goto L5;
        removeDrawerListener(r101);
    L5:
        if (r100 == null) goto L7;
        addDrawerListener(r100);
    L7:
        this.mListener = r100;
    }

    public void setDrawerLockMode(int r100) {
        setDrawerLockMode(r100, 3);
        setDrawerLockMode(r100, 5);
    }

    public void setScrimColor(int r100) {
        this.mScrimColor = r100;
        invalidate();
    }

    public void setStatusBarBackground(int r100) {
        if (r100 == 0) goto L4;
        Drawable r101 = ContextCompat.getDrawable(getContext(), r100);
    L5:
        this.mStatusBarBackground = r101;
        invalidate();
        return;
    L4:
        r101 = null;
        goto L5
    }

    public void setStatusBarBackgroundColor(int r100) {
        this.mStatusBarBackground = new ColorDrawable(r100);
        invalidate();
    }

    public void closeDrawer(View r100) {
        closeDrawer(r100, true);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    public int getDrawerLockMode(View r100) {
        if (isDrawerView(r100) == false) goto L7;
        return getDrawerLockMode(((LayoutParams) r100.getLayoutParams()).gravity);
    L7:
        throw new IllegalArgumentException("View " + r100 + " is not a drawer");
    }

    public boolean isDrawerOpen(int r100) {
        View r101 = findDrawerWithGravity(r100);
        if (r101 != null) goto L5;
        return false;
    L5:
        return isDrawerOpen(r101);
    }

    public boolean isDrawerVisible(int r100) {
        View r101 = findDrawerWithGravity(r100);
        if (r101 != null) goto L5;
        return false;
    L5:
        return isDrawerVisible(r101);
    }

    public void openDrawer(View r100) {
        openDrawer(r100, true);
    }

    public void setStatusBarBackground(Drawable r100) {
        this.mStatusBarBackground = r100;
        invalidate();
    }

    public DrawerLayout(Context r100, AttributeSet r101) {
        this(r100, r101, com.larus.nova.R.attr.drawerLayoutStyle);
    }

    private boolean dispatchTransformedGenericPointerEvent(MotionEvent r100, View r101) {
        if (r101.getMatrix().isIdentity() == true) goto L5;
        MotionEvent r102 = getTransformedMotionEvent(r100, r101);
        boolean r103 = r101.dispatchGenericMotionEvent(r102);
        r102.recycle();
        return r103;
    L5:
        float r104 = getScrollX() - r101.getLeft();
        float r105 = getScrollY() - r101.getTop();
        r100.offsetLocation(r104, r105);
        boolean r106 = r101.dispatchGenericMotionEvent(r100);
        r100.offsetLocation(-r104, -r105);
        return r106;
    }

    private MotionEvent getTransformedMotionEvent(MotionEvent r100, View r101) {
        float r102 = getScrollX() - r101.getLeft();
        float r103 = getScrollY() - r101.getTop();
        MotionEvent r104 = MotionEvent.obtain(r100);
        r104.offsetLocation(r102, r103);
        Matrix r105 = r101.getMatrix();
        if (r105.isIdentity() == false) goto L5;
    L8:
        return r104;
    L5:
        if (this.mChildInvertedMatrix != null) goto L7;
        this.mChildInvertedMatrix = new Matrix();
    L7:
        r105.invert(this.mChildInvertedMatrix);
        r104.transform(this.mChildInvertedMatrix);
        goto L8
    }

    private void mirror(Drawable r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (DrawableCompat.isAutoMirrored(r100) == false) goto L8;
        DrawableCompat.setLayoutDirection(r100, r101);
        return;
    }

    private void updateChildrenImportantForAccessibility(View r100, boolean r101) {
        int r102 = getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L13;
        View r104 = getChildAt(r103);
        if (r101 == false) goto L7;
    L8:
        if (r101 == false) goto L11;
        if (r104 != r100) goto L11;
    L10:
        ViewCompat.setImportantForAccessibility(r104, 1);
    L12:
        r103 = r103 + 1;
    L11:
        ViewCompat.setImportantForAccessibility(r104, 4);
        goto L12
    L7:
        if (isDrawerView(r104) == false) goto L10;
    }

    public boolean checkDrawerViewAbsoluteGravity(View r100, int r101) {
        if ((getDrawerViewAbsoluteGravity(r100) & r101) != r101) goto L5;
        return true;
    L5:
        return false;
    }

    public void closeDrawer(View r100, boolean r101) {
        if (isDrawerView(r100) == false) goto L17;
        LayoutParams r102 = (LayoutParams) r100.getLayoutParams();
        if (this.mFirstLayout == false) goto L8;
        r102.onScreen = 0.0f;
        r102.openState = 0;
    L14:
        invalidate();
        return;
    L8:
        if (r101 == false) goto L13;
        r102.openState |= 4;
        if (checkDrawerViewAbsoluteGravity(r100, 3) == false) goto L12;
        this.mLeftDragger.smoothSlideViewTo(r100, -r100.getWidth(), r100.getTop());
        goto L14
    L12:
        this.mRightDragger.smoothSlideViewTo(r100, getWidth(), r100.getTop());
        goto L14
    L13:
        moveDrawerToOffset(r100, 0.0f);
        updateDrawerState(0, r100);
        r100.setVisibility(4);
        goto L14
    L17:
        throw new IllegalArgumentException("View " + r100 + " is not a sliding drawer");
    }

    public void dispatchOnDrawerSlide(View r100, float r101) {
        List<DrawerListener> r102 = this.mListeners;
        if (r102 == null) goto L7;
        int r103 = r102.size() - 1;
    L5:
        if (r103 < 0) goto L9;
        ((DrawerListener) ListProtector.get(this.mListeners, r103)).onDrawerSlide(r100, r101);
        r103 = r103 - 1;
        goto L5
    L9:
        return;
    }

    public void moveDrawerToOffset(View r100, float r101) {
        float r102 = getDrawerViewOffset(r100);
        float r103 = r100.getWidth();
        int r104 = ((int) (r103 * r101)) - ((int) (r102 * r103));
        if (checkDrawerViewAbsoluteGravity(r100, 3) == true) goto L6;
        r104 = -r104;
    L6:
        r100.offsetLeftAndRight(r104);
        setDrawerViewOffset(r100, r101);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r100, KeyEvent r101) {
        if (r100 != 4) goto L9;
        if (hasVisibleDrawer() == false) goto L9;
        r101.startTracking();
        return true;
    L9:
        return super.onKeyDown(r100, r101);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int r100, KeyEvent r101) {
        if (r100 != 4) goto L14;
        View r102 = findVisibleDrawer();
        if (r102 != null) goto L7;
    L9:
        if (r102 == null) goto L11;
        return true;
    L11:
        return false;
    L7:
        if (getDrawerLockMode(r102) != 0) goto L9;
        closeDrawers();
        goto L9
    L14:
        return super.onKeyUp(r100, r101);
    }

    @Override // android.view.View
    public void onMeasure(int r110, int r111) {
        int r100 = View.MeasureSpec.getMode(r110);
        int r101 = View.MeasureSpec.getMode(r111);
        int r102 = View.MeasureSpec.getSize(r110);
        int r103 = View.MeasureSpec.getSize(r111);
        if (r100 != 1073741824) goto L6;
        if (r101 != 1073741824) goto L6;
    L12:
        setMeasuredDimension(r102, r103);
        if (this.mLastInsets != null) goto L15;
    L17:
        boolean r104 = false;
    L18:
        int r105 = ViewCompat.getLayoutDirection(this);
        int r106 = getChildCount();
        int r107 = 0;
        boolean r112 = false;
        boolean r113 = false;
    L19:
        if (r107 >= r106) goto L68;
        View r114 = getChildAt(r107);
        if (r114.getVisibility() == 8) goto L65;
        LayoutParams r115 = (LayoutParams) r114.getLayoutParams();
        if (r104 == false) goto L40;
        int r116 = GravityCompat.getAbsoluteGravity(r115.gravity, r105);
        if (ViewCompat.getFitsSystemWindows(r114) == false) goto L33;
        WindowInsets r108 = (WindowInsets) this.mLastInsets;
        if (r116 != 3) goto L30;
        r108 = r108.replaceSystemWindowInsets(r108.getSystemWindowInsetLeft(), r108.getSystemWindowInsetTop(), 0, r108.getSystemWindowInsetBottom());
    L32:
        r114.dispatchApplyWindowInsets(r108);
        goto L40
    L30:
        if (r116 != 5) goto L32;
        r108 = r108.replaceSystemWindowInsets(0, r108.getSystemWindowInsetTop(), r108.getSystemWindowInsetRight(), r108.getSystemWindowInsetBottom());
        goto L32
    L33:
        WindowInsets r109 = (WindowInsets) this.mLastInsets;
        if (r116 != 3) goto L36;
        r109 = r109.replaceSystemWindowInsets(r109.getSystemWindowInsetLeft(), r109.getSystemWindowInsetTop(), 0, r109.getSystemWindowInsetBottom());
    L38:
        ((ViewGroup.MarginLayoutParams) r115).leftMargin = r109.getSystemWindowInsetLeft();
        ((ViewGroup.MarginLayoutParams) r115).topMargin = r109.getSystemWindowInsetTop();
        ((ViewGroup.MarginLayoutParams) r115).rightMargin = r109.getSystemWindowInsetRight();
        ((ViewGroup.MarginLayoutParams) r115).bottomMargin = r109.getSystemWindowInsetBottom();
        goto L40
    L36:
        if (r116 != 5) goto L38;
        r109 = r109.replaceSystemWindowInsets(0, r109.getSystemWindowInsetTop(), r109.getSystemWindowInsetRight(), r109.getSystemWindowInsetBottom());
    L40:
        if (isContentView(r114) == false) goto L44;
        r114.measure(View.MeasureSpec.makeMeasureSpec((r102 - ((ViewGroup.MarginLayoutParams) r115).leftMargin) - ((ViewGroup.MarginLayoutParams) r115).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((r103 - ((ViewGroup.MarginLayoutParams) r115).topMargin) - ((ViewGroup.MarginLayoutParams) r115).bottomMargin, 1073741824));
        goto L65
    L44:
        if (isDrawerView(r114) == false) goto L67;
        if (SET_DRAWER_SHADOW_FROM_ELEVATION == false) goto L50;
        float r117 = ViewCompat.getElevation(r114);
        float r118 = this.mDrawerElevation;
        if (r117 == r118) goto L50;
        ViewCompat.setElevation(r114, r118);
    L50:
        int r119 = getDrawerViewAbsoluteGravity(r114) & 7;
        if (r119 != 3) goto L53;
        boolean r120 = true;
    L54:
        if (r120 == false) goto L56;
        if (r112 == false) goto L56;
    L60:
        throw new IllegalStateException("Child drawer has absolute gravity " + gravityToString(r119) + " but this DrawerLayout already has a drawer view along that edge");
    L56:
        if (r120 == true) goto L61;
        if (r113 == true) goto L60;
    L61:
        if (r120 == false) goto L63;
        r112 = true;
    L64:
        r114.measure(ViewGroup.getChildMeasureSpec(r110, (this.mMinDrawerMargin + ((ViewGroup.MarginLayoutParams) r115).leftMargin) + ((ViewGroup.MarginLayoutParams) r115).rightMargin, ((ViewGroup.MarginLayoutParams) r115).width), ViewGroup.getChildMeasureSpec(r111, ((ViewGroup.MarginLayoutParams) r115).topMargin + ((ViewGroup.MarginLayoutParams) r115).bottomMargin, ((ViewGroup.MarginLayoutParams) r115).height));
        goto L65
    L63:
        r113 = true;
        goto L64
    L53:
        r120 = false;
        goto L54
    L67:
        throw new IllegalStateException("Child " + r114 + " at index " + r107 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
    L65:
        r107 = r107 + 1;
        goto L19
    L68:
        return;
    L15:
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L17;
        r104 = true;
    L6:
        if (isInEditMode() == false) goto L70;
        if (r100 != 0) goto L10;
        r102 = 300;
    L10:
        if (r101 != 0) goto L12;
        r103 = 300;
        goto L12
    L70:
        throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
    }

    public void openDrawer(View r100, boolean r101) {
        if (isDrawerView(r100) == false) goto L17;
        LayoutParams r102 = (LayoutParams) r100.getLayoutParams();
        if (this.mFirstLayout == false) goto L8;
        r102.onScreen = 1.0f;
        r102.openState = 1;
        updateChildrenImportantForAccessibility(r100, true);
        updateChildAccessibilityAction(r100);
    L14:
        invalidate();
        return;
    L8:
        if (r101 == false) goto L13;
        r102.openState |= 2;
        if (checkDrawerViewAbsoluteGravity(r100, 3) == false) goto L12;
        this.mLeftDragger.smoothSlideViewTo(r100, 0, r100.getTop());
        goto L14
    L12:
        this.mRightDragger.smoothSlideViewTo(r100, getWidth() - r100.getWidth(), r100.getTop());
        goto L14
    L13:
        moveDrawerToOffset(r100, 1.0f);
        updateDrawerState(0, r100);
        r100.setVisibility(0);
        goto L14
    L17:
        throw new IllegalArgumentException("View " + r100 + " is not a sliding drawer");
    }

    public void setChildInsets(Object r100, boolean r101) {
        this.mLastInsets = r100;
        this.mDrawStatusBarBackground = r101;
        if (r101 == false) goto L5;
    L7:
        boolean r102 = false;
    L8:
        setWillNotDraw(r102);
        requestLayout();
        return;
    L5:
        if (getBackground() != null) goto L7;
        r102 = true;
        goto L8
    }

    public void setDrawerLockMode(int r100, int r101) {
        int r102 = GravityCompat.getAbsoluteGravity(r101, ViewCompat.getLayoutDirection(this));
        if (r101 != 3) goto L5;
        this.mLockModeLeft = r100;
    L15:
        if (r100 == 0) goto L21;
        if (r102 != 3) goto L18;
        ViewDragHelper r103 = this.mLeftDragger;
    L19:
        r103.cancel();
        goto L21
    L18:
        r103 = this.mRightDragger;
    L21:
        if (r100 != 1) goto L23;
        View r104 = findDrawerWithGravity(r102);
        if (r104 == null) goto L34;
        closeDrawer(r104);
        return;
    L34:
        return;
    L23:
        if (r100 != 2) goto L35;
        View r105 = findDrawerWithGravity(r102);
        if (r105 == null) goto L32;
        openDrawer(r105);
        return;
    L32:
        return;
    L35:
        return;
    L5:
        if (r101 != 5) goto L7;
        this.mLockModeRight = r100;
        goto L15
    L7:
        if (r101 != 8388611) goto L9;
        this.mLockModeStart = r100;
        goto L15
    L9:
        if (r101 != 8388613) goto L15;
        this.mLockModeEnd = r100;
        goto L15
    }

    public void setDrawerShadow(Drawable r100, int r101) {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION == false) goto L6;
        return;
    L6:
        if ((r101 & GravityCompat.START) != 8388611) goto L9;
        this.mShadowStart = r100;
    L17:
        resolveShadowDrawables();
        invalidate();
        return;
    L9:
        if ((r101 & GravityCompat.END) != 8388613) goto L12;
        this.mShadowEnd = r100;
        goto L17
    L12:
        if ((r101 & 3) != 3) goto L15;
        this.mShadowLeft = r100;
        goto L17
    L15:
        if ((r101 & 5) != 5) goto L19;
        this.mShadowRight = r100;
        goto L17
    }

    public void setDrawerTitle(int r100, CharSequence r101) {
        int r102 = GravityCompat.getAbsoluteGravity(r100, ViewCompat.getLayoutDirection(this));
        if (r102 != 3) goto L6;
        this.mTitleLeft = r101;
        return;
    L6:
        if (r102 != 5) goto L10;
        this.mTitleRight = r101;
        return;
    }

    public void setDrawerViewOffset(View r100, float r101) {
        LayoutParams r102 = (LayoutParams) r100.getLayoutParams();
        if (r101 != r102.onScreen) goto L5;
        return;
    L5:
        r102.onScreen = r101;
        dispatchOnDrawerSlide(r100, r101);
    }

    public void updateDrawerState(int r100, View r101) {
        int r102 = this.mLeftDragger.getViewDragState();
        int r103 = this.mRightDragger.getViewDragState();
        if (r102 == 1) goto L11;
        if (r103 == 1) goto L11;
        int r104 = 2;
        if (r102 == 2) goto L12;
        if (r103 == 2) goto L12;
        r104 = 0;
    L12:
        if (r101 == null) goto L21;
        if (r100 != 0) goto L21;
        float r105 = ((LayoutParams) r101.getLayoutParams()).onScreen;
        if (r105 != 0.0f) goto L18;
        dispatchOnDrawerClosed(r101);
        goto L21
    L18:
        if (r105 != 1.0f) goto L21;
        dispatchOnDrawerOpened(r101);
    L21:
        if (r104 == this.mDrawerState) goto L27;
        this.mDrawerState = r104;
        List<DrawerListener> r106 = this.mListeners;
        if (r106 == null) goto L29;
        int r107 = r106.size() - 1;
    L25:
        if (r107 < 0) goto L30;
        ((DrawerListener) ListProtector.get(this.mListeners, r107)).onDrawerStateChanged(r104);
        r107 = r107 - 1;
        goto L25
    L30:
        return;
    L29:
        return;
    L27:
        return;
    L11:
        r104 = 1;
        goto L12
    }

    public void closeDrawer(int r100, boolean r101) {
        View r102 = findDrawerWithGravity(r100);
        if (r102 == null) goto L7;
        closeDrawer(r102, r101);
        return;
    L7:
        throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(r100));
    }

    public void openDrawer(int r100, boolean r101) {
        View r102 = findDrawerWithGravity(r100);
        if (r102 == null) goto L7;
        openDrawer(r102, r101);
        return;
    L7:
        throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(r100));
    }

    public void setDrawerLockMode(int r100, View r101) {
        if (isDrawerView(r101) == false) goto L7;
        setDrawerLockMode(r100, ((LayoutParams) r101.getLayoutParams()).gravity);
        return;
    L7:
        throw new IllegalArgumentException("View " + r101 + " is not a drawer with appropriate layout_gravity");
    }

    public void setDrawerShadow(int r100, int r101) {
        setDrawerShadow(ContextCompat.getDrawable(getContext(), r100), r101);
    }

    public DrawerLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mChildAccessibilityDelegate = new ChildAccessibilityDelegate();
        this.mScrimColor = DEFAULT_SCRIM_COLOR;
        this.mScrimPaint = new Paint();
        this.mFirstLayout = true;
        this.mLockModeLeft = 3;
        this.mLockModeRight = 3;
        this.mLockModeStart = 3;
        this.mLockModeEnd = 3;
        this.mShadowStart = null;
        this.mShadowEnd = null;
        this.mShadowLeft = null;
        this.mShadowRight = null;
        this.mActionDismiss = new AnonymousClass1(this);
        setDescendantFocusability(262144);
        float r103 = INVOKEVIRTUAL_androidx_drawerlayout_widget_DrawerLayout_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(getResources()).density;
        this.mMinDrawerMargin = (int) ((64.0f * r103) + 0.5f);
        float r104 = r103 * 400.0f;
        ViewDragCallback r105 = new ViewDragCallback(this, 3);
        this.mLeftCallback = r105;
        ViewDragCallback r106 = new ViewDragCallback(this, 5);
        this.mRightCallback = r106;
        ViewDragHelper r107 = ViewDragHelper.create(this, 1.0f, r105);
        this.mLeftDragger = r107;
        r107.setEdgeTrackingEnabled(1);
        r107.setMinVelocity(r104);
        r105.setDragger(r107);
        ViewDragHelper r108 = ViewDragHelper.create(this, 1.0f, r106);
        this.mRightDragger = r108;
        r108.setEdgeTrackingEnabled(2);
        r108.setMinVelocity(r104);
        r106.setDragger(r108);
        setFocusableInTouchMode(true);
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate(this));
        setMotionEventSplittingEnabled(false);
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L10;
        setOnApplyWindowInsetsListener(new AnonymousClass2(this));
        setSystemUiVisibility(1280);
        TypedArray r109 = r100.obtainStyledAttributes(THEME_ATTRS);
        this.mStatusBarBackground = r109.getDrawable(0);     // Catch: Throwable -> L7
        r109.recycle();
    L7:
        th = move-exception;
        r109.recycle();
        throw th;
    L10:
        TypedArray r110 = r100.obtainStyledAttributes(r101, new int[]{com.larus.nova.R.attr.elevation}, r102, 0);
    L17:
        th = move-exception;
        r110.recycle();
        throw th;
    L12:
        if (r110.hasValue(0) == false) goto L14;
        this.mDrawerElevation = r110.getDimension(0, 0.0f);     // Catch: Throwable -> L17
    L15:
        r110.recycle();
        this.mNonDrawerViews = new ArrayList();
        return;
    L14:
        this.mDrawerElevation = getResources().getDimension(com.larus.nova.R.dimen.def_drawer_elevation);     // Catch: Throwable -> L17
        goto L15
    }

    private boolean isInBoundsOfChild(float r100, float r101, View r102) {
        if (this.mChildHitRect != null) goto L5;
        this.mChildHitRect = new Rect();
    L5:
        r102.getHitRect(this.mChildHitRect);
        return this.mChildHitRect.contains((int) r100, (int) r101);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> r100, int r101, int r102) {
        if (getDescendantFocusability() != 393216) goto L5;
        return;
    L5:
        int r103 = getChildCount();
        int r104 = 0;
        int r105 = 0;
        boolean r106 = false;
    L6:
        if (r105 >= r103) goto L14;
        View r107 = getChildAt(r105);
        if (isDrawerView(r107) == true) goto L10;
        this.mNonDrawerViews.add(r107);
    L13:
        r105 = r105 + 1;
        goto L6
    L10:
        if (isDrawerOpen(r107) == false) goto L13;
        r107.addFocusables(r100, r101, r102);
        r106 = true;
        goto L13
    L14:
        if (r106 == true) goto L21;
        int r108 = this.mNonDrawerViews.size();
    L16:
        if (r104 >= r108) goto L21;
        View r109 = (View) ListProtector.get(this.mNonDrawerViews, r104);
        if (r109.getVisibility() != 0) goto L20;
        r109.addFocusables(r100, r101, r102);
    L20:
        r104 = r104 + 1;
    L21:
        this.mNonDrawerViews.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        super.addView(r100, r101, r102);
        if (findOpenDrawer() == null) goto L5;
    L8:
        ViewCompat.setImportantForAccessibility(r100, 4);
    L10:
        if (CAN_HIDE_DESCENDANTS == true) goto L13;
        ViewCompat.setAccessibilityDelegate(r100, this.mChildAccessibilityDelegate);
        return;
    L13:
        return;
    L5:
        if (isDrawerView(r100) == true) goto L8;
        ViewCompat.setImportantForAccessibility(r100, 1);
        goto L10
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r110, View r111, long r112) {
        int r100 = getHeight();
        boolean r101 = isContentView(r111);
        int r102 = getWidth();
        int r103 = r110.save();
        int r104 = 0;
        if (r101 == false) goto L27;
        int r105 = getChildCount();
        int r113 = 0;
        int r114 = 0;
    L5:
        if (r113 >= r105) goto L26;
        View r115 = getChildAt(r113);
        if (r115 == r111) goto L25;
        if (r115.getVisibility() != 0) goto L25;
        if (hasOpaqueBackground(r115) == false) goto L25;
        if (isDrawerView(r115) == false) goto L25;
        if (r115.getHeight() < r100) goto L25;
        if (checkDrawerViewAbsoluteGravity(r115, 3) == false) goto L22;
        int r116 = r115.getRight();
        if (r116 <= r114) goto L25;
        r114 = r116;
        goto L25
    L22:
        int r117 = r115.getLeft();
        if (r117 >= r102) goto L25;
        r102 = r117;
    L25:
        r113 = r113 + 1;
        goto L5
    L26:
        r110.clipRect(r114, 0, r102, getHeight());
        r104 = r114;
    L27:
        boolean r106 = super.drawChild(r110, r111, r112);
        r110.restoreToCount(r103);
        float r107 = this.mScrimOpacity;
        if (r107 <= 0.0f) goto L32;
        if (r101 == false) goto L32;
        int r108 = this.mScrimColor;
        this.mScrimPaint.setColor((r108 & 16777215) | (((int) ((((-16777216) & r108) >>> 24) * r107)) << 24));
        r110.drawRect(r104, 0.0f, r102, getHeight(), this.mScrimPaint);
    L41:
        return r106;
    L32:
        if (this.mShadowLeftResolved == null) goto L37;
        if (checkDrawerViewAbsoluteGravity(r111, 3) == false) goto L37;
        int r109 = this.mShadowLeftResolved.getIntrinsicWidth();
        int r118 = r111.getRight();
        float r119 = Math.max(0.0f, Math.min(r118 / this.mLeftDragger.getEdgeSize(), 1.0f));
        this.mShadowLeftResolved.setBounds(r118, r111.getTop(), r109 + r118, r111.getBottom());
        this.mShadowLeftResolved.setAlpha((int) (r119 * 255.0f));
        this.mShadowLeftResolved.draw(r110);
    L37:
        if (this.mShadowRightResolved == null) goto L41;
        if (checkDrawerViewAbsoluteGravity(r111, 5) == false) goto L41;
        int r120 = this.mShadowRightResolved.getIntrinsicWidth();
        int r121 = r111.getLeft();
        float r122 = Math.max(0.0f, Math.min((getWidth() - r121) / this.mRightDragger.getEdgeSize(), 1.0f));
        this.mShadowRightResolved.setBounds(r121 - r120, r111.getTop(), r121, r111.getBottom());
        this.mShadowRightResolved.setAlpha((int) (r122 * 255.0f));
        this.mShadowRightResolved.draw(r110);
        goto L41
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r110, int r111, int r112, int r210, int r211) {
        this.mInLayout = true;
        int r100 = r210 - r111;
        int r101 = getChildCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L42;
        View r103 = getChildAt(r102);
        if (r103.getVisibility() == 8) goto L40;
        LayoutParams r104 = (LayoutParams) r103.getLayoutParams();
        if (isContentView(r103) == false) goto L10;
        int r105 = ((ViewGroup.MarginLayoutParams) r104).leftMargin;
        r103.layout(r105, ((ViewGroup.MarginLayoutParams) r104).topMargin, r103.getMeasuredWidth() + r105, ((ViewGroup.MarginLayoutParams) r104).topMargin + r103.getMeasuredHeight());
        goto L40
    L10:
        int r106 = r103.getMeasuredWidth();
        int r107 = r103.getMeasuredHeight();
        if (checkDrawerViewAbsoluteGravity(r103, 3) == false) goto L13;
        float r113 = r106;
        int r114 = (-r106) + ((int) (r104.onScreen * r113));
        float r115 = (r106 + r114) / r113;
    L15:
        if (r115 == r104.onScreen) goto L17;
        boolean r116 = true;
    L18:
        int r117 = r104.gravity & 112;
        if (r117 != 16) goto L21;
        int r118 = r211 - r112;
        int r119 = (r118 - r107) / 2;
        int r120 = ((ViewGroup.MarginLayoutParams) r104).topMargin;
        if (r119 >= r120) goto L27;
        r119 = r120;
    L30:
        r103.layout(r114, r119, r106 + r114, r107 + r119);
    L31:
        if (r116 == false) goto L34;
        setDrawerViewOffset(r103, r115);
    L34:
        if (r104.onScreen <= 0.0f) goto L36;
        int r108 = 0;
    L38:
        if (r103.getVisibility() == r108) goto L40;
        r103.setVisibility(r108);
        goto L40
    L36:
        r108 = 4;
        goto L38
    L27:
        int r121 = r119 + r107;
        int r109 = ((ViewGroup.MarginLayoutParams) r104).bottomMargin;
        if (r121 <= (r118 - r109)) goto L30;
        r119 = (r118 - r109) - r107;
        goto L30
    L21:
        if (r117 == 80) goto L23;
        int r122 = ((ViewGroup.MarginLayoutParams) r104).topMargin;
        r103.layout(r114, r122, r106 + r114, r107 + r122);
        goto L31
    L23:
        int r123 = r211 - r112;
        r103.layout(r114, (r123 - ((ViewGroup.MarginLayoutParams) r104).bottomMargin) - r103.getMeasuredHeight(), r106 + r114, r123 - ((ViewGroup.MarginLayoutParams) r104).bottomMargin);
        goto L31
    L17:
        r116 = false;
        goto L18
    L13:
        float r124 = r106;
        int r125 = r100 - ((int) (r104.onScreen * r124));
        r115 = (r100 - r125) / r124;
        r114 = r125;
    L40:
        r102 = r102 + 1;
        goto L3
    L42:
        if (sEdgeSizeUsingSystemGestureInsets == false) goto L46;
        WindowInsets r126 = getRootWindowInsets();
        if (r126 == null) goto L46;
        Insets r127 = WindowInsetsCompat.toWindowInsetsCompat(r126).getSystemGestureInsets();
        ViewDragHelper r128 = this.mLeftDragger;
        r128.setEdgeSize(Math.max(r128.getDefaultEdgeSize(), r127.left));
        ViewDragHelper r129 = this.mRightDragger;
        r129.setEdgeSize(Math.max(r129.getDefaultEdgeSize(), r127.right));
    L46:
        this.mInLayout = false;
        this.mFirstLayout = false;
    }
}
