package com.obric.oui.orecyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import com.GlobalProxyLancet;
import com.obric.oui.orecyclerview.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ItemTouchHelper extends RecyclerView.ItemDecoration implements RecyclerView.OnChildAttachStateChangeListener {
    static final int ACTION_MODE_DRAG_MASK = 16711680;
    private static final int ACTION_MODE_IDLE_MASK = 255;
    static final int ACTION_MODE_SWIPE_MASK = 65280;
    public static final int ACTION_STATE_DRAG = 2;
    public static final int ACTION_STATE_IDLE = 0;
    public static final int ACTION_STATE_SWIPE = 1;
    private static final int ACTIVE_POINTER_ID_NONE = -1;
    public static final int ANIMATION_TYPE_DRAG = 8;
    public static final int ANIMATION_TYPE_SWIPE_CANCEL = 4;
    public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 2;
    private static final boolean DEBUG = false;
    static final int DIRECTION_FLAG_COUNT = 8;
    public static final int DOWN = 2;
    public static final int END = 32;
    public static final int LEFT = 4;
    private static final int PIXELS_PER_SECOND = 1000;
    public static final int RIGHT = 8;
    public static final int START = 16;
    private static final String TAG = "ItemTouchHelper";
    public static final int UP = 1;
    private int mActionState;
    int mActivePointerId;
    Callback mCallback;
    private RecyclerView.ChildDrawingOrderCallback mChildDrawingOrderCallback;
    private List<Integer> mDistances;
    private long mDragScrollStartTimeInMs;
    float mDx;
    float mDy;
    GestureDetectorCompat mGestureDetector;
    float mInitialTouchX;
    float mInitialTouchY;
    private ItemTouchHelperGestureListener mItemTouchHelperGestureListener;
    private float mMaxSwipeVelocity;
    private final RecyclerView.OnItemTouchListener mOnItemTouchListener;
    View mOverdrawChild;
    int mOverdrawChildPosition;
    final List<View> mPendingCleanup;
    List<RecoverAnimation> mRecoverAnimations;
    RecyclerView mRecyclerView;
    final Runnable mScrollRunnable;
    RecyclerView.ViewHolder mSelected;
    int mSelectedFlags;
    private float mSelectedStartX;
    private float mSelectedStartY;
    private int mSlop;
    private List<RecyclerView.ViewHolder> mSwapTargets;
    private float mSwipeEscapeVelocity;
    private final float[] mTmpPosition;
    private Rect mTmpRect;
    VelocityTracker mVelocityTracker;

    /* JADX INFO: renamed from: com.obric.oui.orecyclerview.widget.ItemTouchHelper$5, reason: invalid class name */
    class AnonymousClass5 implements RecyclerView.ChildDrawingOrderCallback {
        final /* synthetic */ ItemTouchHelper this$0;

        AnonymousClass5(ItemTouchHelper r1) {
            this.this$0 = r1;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.ChildDrawingOrderCallback
        public int onGetChildDrawingOrder(int r3, int r4) {
            if (this.this$0.mOverdrawChild != null) goto L5;
            return r4;
        L5:
            int r0 = this.this$0.mOverdrawChildPosition;
            if (r0 != (-1)) goto L9;
            r0 = this.this$0.mRecyclerView.indexOfChild(this.this$0.mOverdrawChild);
            this.this$0.mOverdrawChildPosition = r0;
        L9:
            if (r4 != (r3 - 1)) goto L11;
            return r0;
        L11:
            if (r4 >= r0) goto L14;
            return r4;
        L14:
            return r4 + 1;
        }
    }

    public static abstract class Callback {
        private static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
        private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000;
        static final int RELATIVE_DIR_FLAGS = 3158064;
        private static final Interpolator sDragScrollInterpolator = null;
        private static final Interpolator sDragViewScrollCapInterpolator = null;
        private int mCachedMaxScrollSpeed;

        public static int convertToRelativeDirection(int r3, int r4) {
            int r1 = r3 & ABS_HORIZONTAL_DIR_FLAGS;
            if (r1 != 0) goto L5;
            return r3;
        L5:
            int r5 = r3 & (~r1);
            if (r4 != 0) goto L10;
            int r6 = r1 << 2;
        L9:
            return r5 | r6;
        L10:
            int r7 = r1 << 1;
            r5 = r5 | ((-789517) & r7);
            r6 = (r7 & ABS_HORIZONTAL_DIR_FLAGS) << 2;
            goto L9
        }

        public static int makeFlag(int r0, int r1) {
            return r1 << (r0 * 8);
        }

        public boolean canDropOver(RecyclerView r1, RecyclerView.ViewHolder r2, RecyclerView.ViewHolder r3) {
            return true;
        }

        public int convertToAbsoluteDirection(int r3, int r4) {
            int r0 = r3 & RELATIVE_DIR_FLAGS;
            if (r0 != 0) goto L5;
            return r3;
        L5:
            int r5 = r3 & (~r0);
            if (r4 != 0) goto L10;
            int r2 = r0 >> 2;
        L9:
            return r2 | r5;
        L10:
            int r6 = r0 >> 1;
            r5 = r5 | ((-3158065) & r6);
            r2 = (RELATIVE_DIR_FLAGS & r6) >> 2;
            goto L9
        }

        public int getBoundingBoxMargin() {
            return 0;
        }

        public float getMoveThreshold(RecyclerView.ViewHolder r1) {
            return 0.5f;
        }

        public abstract int getMovementFlags(RecyclerView r1, RecyclerView.ViewHolder r2);

        public float getSwipeEscapeVelocity(float r1) {
            return r1;
        }

        public float getSwipeThreshold(RecyclerView.ViewHolder r1) {
            return 0.5f;
        }

        public float getSwipeVelocityThreshold(float r1) {
            return r1;
        }

        public boolean isItemViewSwipeEnabled() {
            return true;
        }

        public boolean isLongPressDragEnabled() {
            return true;
        }

        public abstract boolean onMove(RecyclerView r1, RecyclerView.ViewHolder r2, RecyclerView.ViewHolder r3);

        public abstract void onSwiped(RecyclerView.ViewHolder r1, int r2);

        public Callback() {
            this.mCachedMaxScrollSpeed = -1;
        }

        static {
            sDragScrollInterpolator = new AnonymousClass1();
            sDragViewScrollCapInterpolator = new AnonymousClass2();
        }

        public static ItemTouchUIUtil getDefaultUIUtil() {
            return ItemTouchUIUtilImpl.INSTANCE;
        }

        public static int makeMovementFlags(int r2, int r3) {
            int r0 = makeFlag(0, r3 | r2);
            int r4 = makeFlag(1, r3) | r0;
            return makeFlag(2, r2) | r4;
        }

        final int getAbsoluteMovementFlags(RecyclerView r1, RecyclerView.ViewHolder r2) {
            return convertToAbsoluteDirection(getMovementFlags(r1, r2), ViewCompat.getLayoutDirection(r1));
        }

        boolean hasDragFlag(RecyclerView r1, RecyclerView.ViewHolder r2) {
            if ((getAbsoluteMovementFlags(r1, r2) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean hasSwipeFlag(RecyclerView r1, RecyclerView.ViewHolder r2) {
            if ((getAbsoluteMovementFlags(r1, r2) & 65280) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public RecyclerView.ViewHolder chooseDropTarget(RecyclerView.ViewHolder r12, List<RecyclerView.ViewHolder> r13, int r14, int r15) {
            int r11 = r12.itemView.getWidth() + r14;
            int r0 = r12.itemView.getHeight() + r15;
            int r1 = r14 - r12.itemView.getLeft();
            int r2 = r15 - r12.itemView.getTop();
            int r3 = r13.size();
            RecyclerView.ViewHolder r4 = null;
            int r5 = -1;
            int r6 = 0;
        L3:
            if (r6 >= r3) goto L38;
            RecyclerView.ViewHolder r7 = r13.get(r6);
            if (r1 <= 0) goto L13;
            int r8 = r7.itemView.getRight() - r11;
            if (r8 >= 0) goto L13;
            if (r7.itemView.getRight() <= r12.itemView.getRight()) goto L13;
            int r9 = Math.abs(r8);
            if (r9 <= r5) goto L13;
            r4 = r7;
            r5 = r9;
        L13:
            if (r1 >= 0) goto L21;
            int r10 = r7.itemView.getLeft() - r14;
            if (r10 <= 0) goto L21;
            if (r7.itemView.getLeft() >= r12.itemView.getLeft()) goto L21;
            int r16 = Math.abs(r10);
            if (r16 <= r5) goto L21;
            r4 = r7;
            r5 = r16;
        L21:
            if (r2 >= 0) goto L29;
            int r17 = r7.itemView.getTop() - r15;
            if (r17 <= 0) goto L29;
            if (r7.itemView.getTop() >= r12.itemView.getTop()) goto L29;
            int r18 = Math.abs(r17);
            if (r18 <= r5) goto L29;
            r4 = r7;
            r5 = r18;
        L29:
            if (r2 <= 0) goto L37;
            int r19 = r7.itemView.getBottom() - r0;
            if (r19 >= 0) goto L37;
            if (r7.itemView.getBottom() <= r12.itemView.getBottom()) goto L37;
            int r20 = Math.abs(r19);
            if (r20 <= r5) goto L37;
            r4 = r7;
            r5 = r20;
        L37:
            r6 = r6 + 1;
            goto L3
        L38:
            return r4;
        }

        public void onSelectedChanged(RecyclerView.ViewHolder r1, int r2) {
            if (r1 == null) goto L5;
            ItemTouchUIUtilImpl.INSTANCE.onSelected(r1.itemView);
            return;
        }

        private int getMaxDragScroll(RecyclerView r3) {
            if (this.mCachedMaxScrollSpeed != (-1)) goto L6;
            this.mCachedMaxScrollSpeed = r3.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
        L6:
            return this.mCachedMaxScrollSpeed;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onMoved(RecyclerView r1, RecyclerView.ViewHolder r2, int r3, RecyclerView.ViewHolder r4, int r5, int r6, int r7) {
            RecyclerView.LayoutManager r0 = r1.getLayoutManager();
            if ((r0 instanceof ViewDropHandler) == false) goto L7;
            ((ViewDropHandler) r0).prepareForDrop(r2.itemView, r4.itemView, r6, r7);
            return;
        L7:
            if (r0.canScrollHorizontally() == false) goto L15;
            if (r0.getDecoratedLeft(r4.itemView) > r1.getPaddingLeft()) goto L12;
            r1.scrollToPosition(r5);
        L12:
            if (r0.getDecoratedRight(r4.itemView) < (r1.getWidth() - r1.getPaddingRight())) goto L15;
            r1.scrollToPosition(r5);
        L15:
            if (r0.canScrollVertically() == true) goto L17;
            return;
        L17:
            if (r0.getDecoratedTop(r4.itemView) > r1.getPaddingTop()) goto L20;
            r1.scrollToPosition(r5);
        L20:
            if (r0.getDecoratedBottom(r4.itemView) < (r1.getHeight() - r1.getPaddingBottom())) goto L24;
            r1.scrollToPosition(r5);
            return;
        }

        void onDraw(Canvas r14, RecyclerView r15, RecyclerView.ViewHolder r16, List<RecoverAnimation> r17, int r18, float r19, float r20) {
            int r9 = r17.size();
            int r10 = 0;
        L3:
            if (r10 >= r9) goto L5;
            RecoverAnimation r0 = r17.get(r10);
            r0.update();
            int r12 = r14.save();
            onChildDraw(r14, r15, r0.mViewHolder, r0.mX, r0.mY, r0.mActionState, false);
            r14.restoreToCount(r12);
            r10 = r10 + 1;
            goto L3
        L5:
            if (r16 == null) goto L9;
            int r11 = r14.save();
            onChildDraw(r14, r15, r16, r19, r20, r18, true);
            r14.restoreToCount(r11);
            return;
        }

        void onDrawOver(Canvas r15, RecyclerView r16, RecyclerView.ViewHolder r17, List<RecoverAnimation> r18, int r19, float r20, float r21) {
            int r10 = r18.size();
            boolean r11 = false;
            int r12 = 0;
        L3:
            if (r12 >= r10) goto L5;
            RecoverAnimation r0 = r18.get(r12);
            int r13 = r15.save();
            onChildDrawOver(r15, r16, r0.mViewHolder, r0.mX, r0.mY, r0.mActionState, false);
            r15.restoreToCount(r13);
            r12 = r12 + 1;
            goto L3
        L5:
            if (r17 == null) goto L7;
            int r14 = r15.save();
            onChildDrawOver(r15, r16, r17, r20, r21, r19, true);
            r15.restoreToCount(r14);
        L7:
            int r110 = r10 - 1;
        L8:
            if (r110 < 0) goto L18;
            RecoverAnimation r1 = r18.get(r110);
            if (r1.mEnded == false) goto L15;
            if (r1.mIsPendingCleanup == true) goto L15;
            r18.remove(r110);
        L17:
            r110 = r110 - 1;
        L15:
            if (r1.mEnded == true) goto L17;
            r11 = true;
            goto L17
        L18:
            if (r11 == false) goto L26;
            r16.invalidate();
            return;
        }

        public void clearView(RecyclerView r1, RecyclerView.ViewHolder r2) {
            ItemTouchUIUtilImpl.INSTANCE.clearView(r2.itemView);
        }

        public void onChildDraw(Canvas r9, RecyclerView r10, RecyclerView.ViewHolder r11, float r12, float r13, int r14, boolean r15) {
            ItemTouchUIUtilImpl.INSTANCE.onDraw(r9, r10, r11.itemView, r12, r13, r14, r15);
        }

        public void onChildDrawOver(Canvas r9, RecyclerView r10, RecyclerView.ViewHolder r11, float r12, float r13, int r14, boolean r15) {
            ItemTouchUIUtilImpl.INSTANCE.onDrawOver(r9, r10, r11.itemView, r12, r13, r14, r15);
        }

        public long getAnimationDuration(RecyclerView r1, int r2, float r3, float r4) {
            RecyclerView.ItemAnimator r0 = r1.getItemAnimator();
            if (r0 != null) goto L8;
            if (r2 != 8) goto L6;
            return 200;
        L6:
            return 250;
        L8:
            if (r2 != 8) goto L11;
            return r0.getMoveDuration();
        L11:
            return r0.getRemoveDuration();
        }

        public int interpolateOutOfBoundsScroll(RecyclerView r2, int r3, int r4, int r5, long r6) {
            int r1 = getMaxDragScroll(r2);
            int r7 = Math.abs(r4);
            float r0 = 1.0f;
            int r8 = (int) ((((int) Math.signum(r4)) * r1) * sDragViewScrollCapInterpolator.getInterpolation(Math.min(1.0f, (r7 * 1.0f) / r3)));
            if (r6 > DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS) goto L6;
            r0 = r6 / 2000.0f;
        L6:
            int r9 = (int) (r8 * sDragScrollInterpolator.getInterpolation(r0));
            if (r9 != 0) goto L12;
            if (r4 <= 0) goto L10;
            return 1;
        L10:
            return -1;
        L12:
            return r9;
        }
    }

    private class ItemTouchHelperGestureListener extends GestureDetector.SimpleOnGestureListener {
        private boolean mShouldReactToLongPress;
        final /* synthetic */ ItemTouchHelper this$0;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent r1) {
            return true;
        }

        ItemTouchHelperGestureListener(ItemTouchHelper r1) {
            this.this$0 = r1;
            this.mShouldReactToLongPress = true;
        }

        void doNotReactToLongPress() {
            this.mShouldReactToLongPress = false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent r4) {
            if (this.mShouldReactToLongPress == true) goto L5;
            return;
        L5:
            View r0 = this.this$0.findChildView(r4);
            if (r0 == null) goto L18;
            RecyclerView.ViewHolder r1 = this.this$0.mRecyclerView.getChildViewHolder(r0);
            if (r1 != null) goto L10;
            return;
        L10:
            if (this.this$0.mCallback.hasDragFlag(this.this$0.mRecyclerView, r1) == true) goto L13;
            return;
        L13:
            if (r4.getPointerId(0) != this.this$0.mActivePointerId) goto L20;
            int r2 = r4.findPointerIndex(this.this$0.mActivePointerId);
            float r3 = r4.getX(r2);
            float r5 = r4.getY(r2);
            this.this$0.mInitialTouchX = r3;
            this.this$0.mInitialTouchY = r5;
            ItemTouchHelper r6 = this.this$0;
            r6.mDy = 0.0f;
            r6.mDx = 0.0f;
            if (this.this$0.mCallback.isLongPressDragEnabled() == false) goto L21;
            this.this$0.select(r1, 2);
            return;
        L21:
            return;
        L20:
            return;
        }
    }

    static class RecoverAnimation implements Animator.AnimatorListener {
        final int mActionState;
        final int mAnimationType;
        boolean mEnded;
        private float mFraction;
        boolean mIsPendingCleanup;
        boolean mOverridden;
        final float mStartDx;
        final float mStartDy;
        final float mTargetX;
        final float mTargetY;
        final ValueAnimator mValueAnimator;
        final RecyclerView.ViewHolder mViewHolder;
        float mX;
        float mY;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r1) {
        }

        RecoverAnimation(RecyclerView.ViewHolder r2, int r3, int r4, float r5, float r6, float r7, float r8) {
            this.mOverridden = false;
            this.mEnded = false;
            this.mActionState = r4;
            this.mAnimationType = r3;
            this.mViewHolder = r2;
            this.mStartDx = r5;
            this.mStartDy = r6;
            this.mTargetX = r7;
            this.mTargetY = r8;
            ValueAnimator r9 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.mValueAnimator = r9;
            r9.addUpdateListener(new AnonymousClass1(this));
            r9.setTarget(r2.itemView);
            r9.addListener(this);
            setFraction(0.0f);
        }

        public void setDuration(long r1) {
            this.mValueAnimator.setDuration(r1);
        }

        public void start() {
            this.mViewHolder.setIsRecyclable(false);
            this.mValueAnimator.start();
        }

        public void cancel() {
            this.mValueAnimator.cancel();
        }

        public void setFraction(float r1) {
            this.mFraction = r1;
        }

        public void update() {
            float r0 = this.mStartDx;
            float r1 = this.mTargetX;
            if (r0 != r1) goto L5;
            this.mX = this.mViewHolder.itemView.getTranslationX();
        L6:
            float r2 = this.mStartDy;
            float r3 = this.mTargetY;
            if (r2 != r3) goto L9;
            this.mY = this.mViewHolder.itemView.getTranslationY();
            return;
        L9:
            this.mY = r2 + (this.mFraction * (r3 - r2));
            return;
        L5:
            this.mX = r0 + (this.mFraction * (r1 - r0));
            goto L6
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r2) {
            if (this.mEnded == true) goto L5;
            this.mViewHolder.setIsRecyclable(true);
        L5:
            this.mEnded = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r1) {
            setFraction(1.0f);
        }
    }

    public static abstract class SimpleCallback extends Callback {
        private int mDefaultDragDirs;
        private int mDefaultSwipeDirs;

        public SimpleCallback(int r1, int r2) {
            this.mDefaultSwipeDirs = r2;
            this.mDefaultDragDirs = r1;
        }

        public void setDefaultSwipeDirs(int r1) {
            this.mDefaultSwipeDirs = r1;
        }

        public void setDefaultDragDirs(int r1) {
            this.mDefaultDragDirs = r1;
        }

        public int getSwipeDirs(RecyclerView r1, RecyclerView.ViewHolder r2) {
            return this.mDefaultSwipeDirs;
        }

        public int getDragDirs(RecyclerView r1, RecyclerView.ViewHolder r2) {
            return this.mDefaultDragDirs;
        }

        @Override // com.obric.oui.orecyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(RecyclerView r2, RecyclerView.ViewHolder r3) {
            return makeMovementFlags(getDragDirs(r2, r3), getSwipeDirs(r2, r3));
        }
    }

    public interface ViewDropHandler {
        void prepareForDrop(View r1, View r2, int r3, int r4);
    }

    private void addChildDrawingOrderCallback() {
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewAttachedToWindow(View r1) {
    }

    public ItemTouchHelper(Callback r4) {
        this.mPendingCleanup = new ArrayList();
        this.mTmpPosition = new float[2];
        this.mSelected = null;
        this.mActivePointerId = -1;
        this.mActionState = 0;
        this.mRecoverAnimations = new ArrayList();
        this.mScrollRunnable = new AnonymousClass1(this);
        this.mChildDrawingOrderCallback = null;
        this.mOverdrawChild = null;
        this.mOverdrawChildPosition = -1;
        this.mOnItemTouchListener = new AnonymousClass2(this);
        this.mCallback = r4;
    }

    private static boolean hitTest(View r1, float r2, float r3, float r4, float r5) {
        if (r2 >= r4) goto L5;
    L11:
        return false;
    L5:
        if (r2 > (r4 + r1.getWidth())) goto L11;
        if (r3 < r5) goto L11;
        if (r3 > (r5 + r1.getHeight())) goto L11;
        return true;
    }

    public void attachToRecyclerView(RecyclerView r2) {
        RecyclerView r0 = this.mRecyclerView;
        if (r0 != r2) goto L5;
        return;
    L5:
        if (r0 == null) goto L7;
        destroyCallbacks();
    L7:
        this.mRecyclerView = r2;
        if (r2 == null) goto L11;
        Resources r3 = r2.getResources();
        this.mSwipeEscapeVelocity = r3.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
        this.mMaxSwipeVelocity = r3.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
        setupCallbacks();
        return;
    }

    private void setupCallbacks() {
        this.mSlop = ViewConfiguration.get(this.mRecyclerView.getContext()).getScaledTouchSlop();
        this.mRecyclerView.addItemDecoration(this);
        this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.addOnChildAttachStateChangeListener(this);
        startGestureDetection();
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeItemDecoration(this);
        this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.removeOnChildAttachStateChangeListener(this);
        int r0 = this.mRecoverAnimations.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        RecoverAnimation r1 = this.mRecoverAnimations.get(0);
        r1.cancel();
        this.mCallback.clearView(this.mRecyclerView, r1.mViewHolder);
        r0 = r0 - 1;
        goto L3
    L5:
        this.mRecoverAnimations.clear();
        this.mOverdrawChild = null;
        this.mOverdrawChildPosition = -1;
        releaseVelocityTracker();
        stopGestureDetection();
    }

    private void startGestureDetection() {
        this.mItemTouchHelperGestureListener = new ItemTouchHelperGestureListener(this);
        this.mGestureDetector = new GestureDetectorCompat(this.mRecyclerView.getContext(), this.mItemTouchHelperGestureListener);
    }

    private void stopGestureDetection() {
        ItemTouchHelperGestureListener r0 = this.mItemTouchHelperGestureListener;
        if (r0 == null) goto L6;
        r0.doNotReactToLongPress();
        this.mItemTouchHelperGestureListener = null;
    L6:
        if (this.mGestureDetector == null) goto L9;
        this.mGestureDetector = null;
        return;
    }

    private void getSelectedDxDy(float[] r4) {
        if ((this.mSelectedFlags & 12) == 0) goto L5;
        r4[0] = (this.mSelectedStartX + this.mDx) - this.mSelected.itemView.getLeft();
    L7:
        if ((this.mSelectedFlags & 3) == 0) goto L9;
        r4[1] = (this.mSelectedStartY + this.mDy) - this.mSelected.itemView.getTop();
        return;
    L9:
        r4[1] = this.mSelected.itemView.getTranslationY();
        return;
    L5:
        r4[0] = this.mSelected.itemView.getTranslationX();
        goto L7
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas r10, RecyclerView r11, RecyclerView.State r12) {
        if (this.mSelected == null) goto L5;
        getSelectedDxDy(this.mTmpPosition);
        float[] r13 = this.mTmpPosition;
        float r0 = r13[0];
        float r8 = r13[1];
        float r7 = r0;
    L6:
        this.mCallback.onDrawOver(r10, r11, this.mSelected, this.mRecoverAnimations, this.mActionState, r7, r8);
        return;
    L5:
        r7 = 0.0f;
        r8 = 0.0f;
        goto L6
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas r10, RecyclerView r11, RecyclerView.State r12) {
        this.mOverdrawChildPosition = -1;
        if (this.mSelected == null) goto L5;
        getSelectedDxDy(this.mTmpPosition);
        float[] r13 = this.mTmpPosition;
        float r0 = r13[0];
        float r8 = r13[1];
        float r7 = r0;
    L6:
        this.mCallback.onDraw(r10, r11, this.mSelected, this.mRecoverAnimations, this.mActionState, r7, r8);
        return;
    L5:
        r7 = 0.0f;
        r8 = 0.0f;
        goto L6
    }

    void select(RecyclerView.ViewHolder r24, int r25) {
        if (r24 == this.mSelected) goto L5;
    L7:
        this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
        final int r4 = this.mActionState;
        endRecoverAnimation(r24, true);
        this.mActionState = r25;
        if (r25 != 2) goto L13;
        if (r24 == null) goto L12;
        this.mOverdrawChild = r24.itemView;
        addChildDrawingOrderCallback();
        goto L13
    L12:
        throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
    L13:
        int r16 = (1 << ((r25 * 8) + 8)) - 1;
        final RecyclerView.ViewHolder r9 = this.mSelected;
        if (r9 != null) goto L16;
        boolean r8 = false;
    L41:
        if (r24 == null) goto L45;
        this.mSelectedFlags = (this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, r24) & r16) >> (this.mActionState * 8);
        this.mSelectedStartX = r24.itemView.getLeft();
        this.mSelectedStartY = r24.itemView.getTop();
        this.mSelected = r24;
        if (r25 != 2) goto L45;
        boolean r1 = false;
        r24.itemView.performHapticFeedback(0);
    L46:
        ViewParent r0 = this.mRecyclerView.getParent();
        if (r0 != null) goto L49;
    L53:
        if (r8 == true) goto L55;
        this.mRecyclerView.getLayoutManager().requestSimpleAnimationsInNextLayout();
    L55:
        this.mCallback.onSelectedChanged(this.mSelected, this.mActionState);
        this.mRecyclerView.invalidate();
        return;
    L49:
        if (this.mSelected == null) goto L51;
        boolean r14 = true;
    L52:
        r0.requestDisallowInterceptTouchEvent(r14);
        goto L53
    L51:
        r14 = r1;
    L45:
        r1 = false;
        goto L46
    L16:
        if (r9.itemView.getParent() == null) goto L38;
        if (r4 != 2) goto L19;
        int r7 = 0;
    L20:
        releaseVelocityTracker();
        if (r7 == 1) goto L31;
        if (r7 == 2) goto L31;
        if (r7 == 4) goto L30;
        if (r7 == 8) goto L30;
        if (r7 == 16) goto L30;
        if (r7 == 32) goto L30;
        float r17 = 0.0f;
        float r18 = 0.0f;
    L32:
        if (r4 != 2) goto L34;
        int r6 = 8;
    L37:
        getSelectedDxDy(this.mTmpPosition);
        float[] r2 = this.mTmpPosition;
        final float r19 = r2[0];
        final float r20 = r2[1];
        final int r3 = r6;
        final int r21 = r7;
        final float r10 = r17;
        final float r11 = r18;
        RecoverAnimation r5 = new AnonymousClass3(this, r9, r3, r4, r19, r20, r10, r11, r21, r9);
        r5.setDuration(this.mCallback.getAnimationDuration(this.mRecyclerView, r6, r17 - r19, r18 - r20));
        this.mRecoverAnimations.add(r5);
        r5.start();
        r8 = true;
    L39:
        this.mSelected = null;
        goto L41
    L34:
        if (r7 <= 0) goto L36;
        r6 = 2;
        goto L37
    L36:
        r6 = 4;
    L30:
        r18 = 0.0f;
        r17 = Math.signum(this.mDx) * this.mRecyclerView.getWidth();
    L31:
        r17 = 0.0f;
        r18 = Math.signum(this.mDy) * this.mRecyclerView.getHeight();
        goto L32
    L19:
        r7 = swipeIfNecessary(r9);
        goto L20
    L38:
        removeChildDrawingOrderCallbackIfNecessary(r9.itemView);
        this.mCallback.clearView(this.mRecyclerView, r9);
        r8 = false;
        goto L39
    L5:
        if (r25 != this.mActionState) goto L7;
    }

    void postDispatchSwipe(final RecoverAnimation r3, final int r4) {
        this.mRecyclerView.post(new AnonymousClass4(this, r3, r4));
    }

    boolean hasRunningRecoverAnim() {
        int r0 = this.mRecoverAnimations.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (this.mRecoverAnimations.get(r2).mEnded == false) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    boolean scrollIfNecessary() {
        if (this.mSelected != null) goto L6;
        this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
        return false;
    L6:
        long r5 = System.currentTimeMillis();
        long r7 = this.mDragScrollStartTimeInMs;
        if (r7 != Long.MIN_VALUE) goto L9;
        long r8 = 0;
    L10:
        RecyclerView.LayoutManager r1 = this.mRecyclerView.getLayoutManager();
        if (this.mTmpRect != null) goto L13;
        this.mTmpRect = new Rect();
    L13:
        r1.calculateItemDecorationsForChild(this.mSelected.itemView, this.mTmpRect);
        if (r1.canScrollHorizontally() == false) goto L24;
        int r9 = (int) (this.mSelectedStartX + this.mDx);
        int r11 = (r9 - this.mTmpRect.left) - this.mRecyclerView.getPaddingLeft();
        float r12 = this.mDx;
        if (r12 >= 0.0f) goto L20;
        if (r11 >= 0) goto L20;
        int r13 = r11;
    L26:
        if (r1.canScrollVertically() == false) goto L36;
        int r2 = (int) (this.mSelectedStartY + this.mDy);
        int r10 = (r2 - this.mTmpRect.top) - this.mRecyclerView.getPaddingTop();
        float r14 = this.mDy;
        if (r14 >= 0.0f) goto L32;
        if (r10 >= 0) goto L32;
        int r3 = r10;
    L37:
        if (r13 == 0) goto L39;
        r13 = this.mCallback.interpolateOutOfBoundsScroll(this.mRecyclerView, this.mSelected.itemView.getWidth(), r13, this.mRecyclerView.getWidth(), r8);
    L39:
        int r15 = r13;
        if (r3 == 0) goto L42;
        int r16 = r15;
        r3 = this.mCallback.interpolateOutOfBoundsScroll(this.mRecyclerView, this.mSelected.itemView.getHeight(), r3, this.mRecyclerView.getHeight(), r8);
    L43:
        if (r16 != 0) goto L49;
        if (r3 != 0) goto L49;
        this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
        return false;
    L49:
        if (this.mDragScrollStartTimeInMs != Long.MIN_VALUE) goto L51;
        this.mDragScrollStartTimeInMs = r5;
    L51:
        this.mRecyclerView.scrollBy(r16, r3);
        return true;
    L42:
        r16 = r15;
    L32:
        if (r14 <= 0.0f) goto L36;
        r3 = ((r2 + this.mSelected.itemView.getHeight()) + this.mTmpRect.bottom) - (this.mRecyclerView.getHeight() - this.mRecyclerView.getPaddingBottom());
        if (r3 > 0) goto L37;
    L36:
        r3 = 0;
    L20:
        if (r12 <= 0.0f) goto L24;
        int r17 = ((r9 + this.mSelected.itemView.getWidth()) + this.mTmpRect.right) - (this.mRecyclerView.getWidth() - this.mRecyclerView.getPaddingRight());
        if (r17 <= 0) goto L24;
        r13 = r17;
    L24:
        r13 = 0;
        goto L26
    L9:
        r8 = r5 - r7;
        goto L10
    }

    private List<RecyclerView.ViewHolder> findSwapTargets(RecyclerView.ViewHolder r17) {
        RecyclerView.ViewHolder r1 = r17;
        List<RecyclerView.ViewHolder> r2 = this.mSwapTargets;
        if (r2 != null) goto L5;
        this.mSwapTargets = new ArrayList();
        this.mDistances = new ArrayList();
    L6:
        int r3 = this.mCallback.getBoundingBoxMargin();
        int r4 = Math.round(this.mSelectedStartX + this.mDx) - r3;
        int r5 = Math.round(this.mSelectedStartY + this.mDy) - r3;
        int r6 = r3 * 2;
        int r7 = (r1.itemView.getWidth() + r4) + r6;
        int r8 = (r1.itemView.getHeight() + r5) + r6;
        int r9 = (r4 + r7) / 2;
        int r10 = (r5 + r8) / 2;
        RecyclerView.LayoutManager r11 = this.mRecyclerView.getLayoutManager();
        int r12 = r11.getChildCount();
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L30;
        View r14 = r11.getChildAt(r13);
        if (r14 == r1.itemView) goto L28;
        if (r14.getBottom() < r5) goto L28;
        if (r14.getTop() > r8) goto L28;
        if (r14.getRight() < r4) goto L28;
        if (r14.getLeft() > r7) goto L28;
        RecyclerView.ViewHolder r15 = this.mRecyclerView.getChildViewHolder(r14);
        if (this.mCallback.canDropOver(this.mRecyclerView, this.mSelected, r15) == false) goto L28;
        int r16 = Math.abs(r9 - ((r14.getLeft() + r14.getRight()) / 2));
        int r18 = Math.abs(r10 - ((r14.getTop() + r14.getBottom()) / 2));
        int r19 = (r16 * r16) + (r18 * r18);
        int r110 = this.mSwapTargets.size();
        int r111 = 0;
        int r112 = 0;
    L23:
        if (r111 >= r110) goto L27;
        if (r19 <= this.mDistances.get(r111).intValue()) goto L27;
        r112 = r112 + 1;
        r111 = r111 + 1;
    L27:
        this.mSwapTargets.add(r112, r15);
        this.mDistances.add(r112, Integer.valueOf(r19));
    L28:
        r13 = r13 + 1;
        r1 = r17;
        goto L7
    L30:
        return this.mSwapTargets;
    L5:
        r2.clear();
        this.mDistances.clear();
        goto L6
    }

    void moveIfNecessary(RecyclerView.ViewHolder r11) {
        if (this.mRecyclerView.isLayoutRequested() == false) goto L6;
        return;
    L6:
        if (this.mActionState == 2) goto L8;
        return;
    L8:
        float r0 = this.mCallback.getMoveThreshold(r11);
        int r8 = (int) (this.mSelectedStartX + this.mDx);
        int r9 = (int) (this.mSelectedStartY + this.mDy);
        if (Math.abs(r9 - r11.itemView.getTop()) < (r11.itemView.getHeight() * r0)) goto L11;
    L13:
        List<RecyclerView.ViewHolder> r1 = findSwapTargets(r11);
        if (r1.size() != 0) goto L16;
        return;
    L16:
        RecyclerView.ViewHolder r6 = this.mCallback.chooseDropTarget(r11, r1, r8, r9);
        if (r6 != null) goto L20;
        this.mSwapTargets.clear();
        this.mDistances.clear();
        return;
    L20:
        int r7 = r6.getAbsoluteAdapterPosition();
        int r5 = r11.getAbsoluteAdapterPosition();
        if (this.mCallback.onMove(this.mRecyclerView, r11, r6) == false) goto L24;
        this.mCallback.onMoved(this.mRecyclerView, r11, r5, r6, r7, r8, r9);
        return;
    L24:
        return;
    L11:
        if (Math.abs(r8 - r11.itemView.getLeft()) >= (r11.itemView.getWidth() * r0)) goto L13;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewDetachedFromWindow(View r3) {
        removeChildDrawingOrderCallbackIfNecessary(r3);
        RecyclerView.ViewHolder r4 = this.mRecyclerView.getChildViewHolder(r3);
        if (r4 != null) goto L5;
        return;
    L5:
        RecyclerView.ViewHolder r0 = this.mSelected;
        if (r0 == null) goto L9;
        if (r4 != r0) goto L9;
        select(null, 0);
        return;
    L9:
        endRecoverAnimation(r4, false);
        if (this.mPendingCleanup.remove(r4.itemView) == false) goto L14;
        this.mCallback.clearView(this.mRecyclerView, r4);
        return;
    }

    void endRecoverAnimation(RecyclerView.ViewHolder r4, boolean r5) {
        int r0 = this.mRecoverAnimations.size() - 1;
    L3:
        if (r0 < 0) goto L12;
        RecoverAnimation r1 = this.mRecoverAnimations.get(r0);
        if (r1.mViewHolder == r4) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        r1.mOverridden |= r5;
        if (r1.mEnded == true) goto L9;
        r1.cancel();
    L9:
        this.mRecoverAnimations.remove(r0);
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect r1, View r2, RecyclerView r3, RecyclerView.State r4) {
        r1.setEmpty();
    }

    void obtainVelocityTracker() {
        VelocityTracker r0 = this.mVelocityTracker;
        if (r0 == null) goto L5;
        r0.recycle();
    L5:
        this.mVelocityTracker = VelocityTracker.obtain();
    }

    private void releaseVelocityTracker() {
        VelocityTracker r0 = this.mVelocityTracker;
        if (r0 == null) goto L6;
        r0.recycle();
        this.mVelocityTracker = null;
        return;
    }

    private RecyclerView.ViewHolder findSwipedView(MotionEvent r7) {
        RecyclerView.LayoutManager r0 = this.mRecyclerView.getLayoutManager();
        int r1 = this.mActivePointerId;
        if (r1 != (-1)) goto L5;
        return null;
    L5:
        int r2 = r7.findPointerIndex(r1);
        float r3 = r7.getX(r2) - this.mInitialTouchX;
        float r4 = r7.getY(r2) - this.mInitialTouchY;
        float r5 = Math.abs(r3);
        float r6 = Math.abs(r4);
        int r8 = this.mSlop;
        if (r5 >= r8) goto L11;
        if (r6 >= r8) goto L11;
        return null;
    L11:
        if (r5 <= r6) goto L16;
        if (r0.canScrollHorizontally() == false) goto L16;
        return null;
    L16:
        if (r6 > r5) goto L18;
    L20:
        View r9 = findChildView(r7);
        if (r9 != null) goto L24;
        return null;
    L24:
        return this.mRecyclerView.getChildViewHolder(r9);
    L18:
        if (r0.canScrollVertically() == false) goto L20;
        return null;
    }

    void checkSelectForSwipe(int r9, MotionEvent r10, int r11) {
        if (this.mSelected == null) goto L5;
        return;
    L5:
        if (r9 == 2) goto L7;
        return;
    L7:
        if (this.mActionState != 2) goto L9;
        return;
    L9:
        if (this.mCallback.isItemViewSwipeEnabled() == true) goto L12;
        return;
    L12:
        if (this.mRecyclerView.getScrollState() != 1) goto L14;
        return;
    L14:
        RecyclerView.ViewHolder r12 = findSwipedView(r10);
        if (r12 != null) goto L17;
        return;
    L17:
        int r2 = (this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, r12) & 65280) >> 8;
        if (r2 != 0) goto L20;
        return;
    L20:
        float r3 = r10.getX(r11);
        float r13 = r10.getY(r11);
        float r4 = r3 - this.mInitialTouchX;
        float r14 = r13 - this.mInitialTouchY;
        float r5 = Math.abs(r4);
        float r6 = Math.abs(r14);
        int r7 = this.mSlop;
        if (r5 >= r7) goto L26;
        if (r6 >= r7) goto L26;
        return;
    L26:
        if (r5 <= r6) goto L38;
        if (r4 >= 0.0f) goto L33;
        if ((r2 & 4) != 0) goto L33;
        return;
    L33:
        if (r4 > 0.0f) goto L35;
    L47:
        this.mDy = 0.0f;
        this.mDx = 0.0f;
        this.mActivePointerId = r10.getPointerId(0);
        select(r12, 1);
        return;
    L35:
        if ((r2 & 8) != 0) goto L47;
        return;
    L38:
        if (r14 >= 0.0f) goto L43;
        if ((r2 & 1) != 0) goto L43;
        return;
    L43:
        if (r14 <= 0.0f) goto L47;
        if ((r2 & 2) != 0) goto L47;
    }

    View findChildView(MotionEvent r6) {
        float r0 = r6.getX();
        float r7 = r6.getY();
        RecyclerView.ViewHolder r1 = this.mSelected;
        if (r1 == null) goto L7;
        View r2 = r1.itemView;
        if (hitTest(r2, r0, r7, this.mSelectedStartX + this.mDx, this.mSelectedStartY + this.mDy) == false) goto L7;
        return r2;
    L7:
        int r3 = this.mRecoverAnimations.size() - 1;
    L8:
        if (r3 < 0) goto L14;
        RecoverAnimation r4 = this.mRecoverAnimations.get(r3);
        View r5 = r4.mViewHolder.itemView;
        if (hitTest(r5, r0, r7, r4.mX, r4.mY) == true) goto L11;
        r3 = r3 - 1;
        goto L8
    L11:
        return r5;
    L14:
        return this.mRecyclerView.findChildViewUnder(r0, r7);
    }

    public void startDrag(RecyclerView.ViewHolder r4) {
        if (this.mCallback.hasDragFlag(this.mRecyclerView, r4) == true) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Start drag has been called but dragging is not enabled");
        return;
    L7:
        if (r4.itemView.getParent() == this.mRecyclerView) goto L10;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
        return;
    L10:
        obtainVelocityTracker();
        this.mDy = 0.0f;
        this.mDx = 0.0f;
        select(r4, 2);
    }

    public void startSwipe(RecyclerView.ViewHolder r4) {
        if (this.mCallback.hasSwipeFlag(this.mRecyclerView, r4) == true) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Start swipe has been called but swiping is not enabled");
        return;
    L7:
        if (r4.itemView.getParent() == this.mRecyclerView) goto L10;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Start swipe has been called with a view holder which is not a child of the RecyclerView controlled by this ItemTouchHelper.");
        return;
    L10:
        obtainVelocityTracker();
        this.mDy = 0.0f;
        this.mDx = 0.0f;
        select(r4, 1);
    }

    RecoverAnimation findAnimation(MotionEvent r5) {
        if (this.mRecoverAnimations.isEmpty() == false) goto L5;
        return null;
    L5:
        View r6 = findChildView(r5);
        int r0 = this.mRecoverAnimations.size() - 1;
    L6:
        if (r0 < 0) goto L11;
        RecoverAnimation r2 = this.mRecoverAnimations.get(r0);
        if (r2.mViewHolder.itemView == r6) goto L9;
        r0 = r0 - 1;
        goto L6
    L9:
        return r2;
    L11:
        return null;
    }

    void updateDxDy(MotionEvent r2, int r3, int r4) {
        float r0 = r2.getX(r4);
        float r5 = r2.getY(r4);
        float r1 = r0 - this.mInitialTouchX;
        this.mDx = r1;
        this.mDy = r5 - this.mInitialTouchY;
        if ((r3 & 4) != 0) goto L6;
        this.mDx = Math.max(0.0f, r1);
    L6:
        if ((r3 & 8) != 0) goto L9;
        this.mDx = Math.min(0.0f, this.mDx);
    L9:
        if ((r3 & 1) != 0) goto L12;
        this.mDy = Math.max(0.0f, this.mDy);
    L12:
        if ((r3 & 2) != 0) goto L15;
        this.mDy = Math.min(0.0f, this.mDy);
        return;
    }

    private int swipeIfNecessary(RecyclerView.ViewHolder r6) {
        if (this.mActionState != 2) goto L5;
        return 0;
    L5:
        int r0 = this.mCallback.getMovementFlags(this.mRecyclerView, r6);
        int r1 = (this.mCallback.convertToAbsoluteDirection(r0, ViewCompat.getLayoutDirection(this.mRecyclerView)) & 65280) >> 8;
        if (r1 != 0) goto L8;
        return 0;
    L8:
        int r2 = (r0 & 65280) >> 8;
        if (Math.abs(this.mDx) <= Math.abs(this.mDy)) goto L20;
        int r3 = checkHorizontalSwipe(r6, r1);
        if (r3 > 0) goto L13;
        int r5 = checkVerticalSwipe(r6, r1);
        if (r5 <= 0) goto L30;
        return r5;
    L30:
        return 0;
    L13:
        if ((r2 & r3) == 0) goto L15;
        return r3;
    L15:
        return Callback.convertToRelativeDirection(r3, ViewCompat.getLayoutDirection(this.mRecyclerView));
    L20:
        int r4 = checkVerticalSwipe(r6, r1);
        if (r4 <= 0) goto L23;
        return r4;
    L23:
        int r7 = checkHorizontalSwipe(r6, r1);
        if (r7 <= 0) goto L30;
        if ((r2 & r7) == 0) goto L28;
        return r7;
    L28:
        return Callback.convertToRelativeDirection(r7, ViewCompat.getLayoutDirection(this.mRecyclerView));
    }

    private int checkHorizontalSwipe(RecyclerView.ViewHolder r8, int r9) {
        if ((r9 & 12) == 0) goto L29;
        int r2 = 8;
        if (this.mDx <= 0.0f) goto L7;
        int r0 = 8;
    L8:
        VelocityTracker r4 = this.mVelocityTracker;
        if (r4 != null) goto L11;
    L24:
        float r1 = this.mRecyclerView.getWidth() * this.mCallback.getSwipeThreshold(r8);
        if ((r9 & r0) != 0) goto L27;
        return 0;
    L27:
        if (Math.abs(this.mDx) <= r1) goto L32;
        return r0;
    L32:
        return 0;
    L11:
        if (this.mActivePointerId <= (-1)) goto L24;
        r4.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
        float r5 = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
        float r6 = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
        if (r5 > 0.0f) goto L16;
        r2 = 4;
    L16:
        float r3 = Math.abs(r5);
        if ((r2 & r9) == 0) goto L24;
        if (r0 != r2) goto L24;
        if (r3 < this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity)) goto L24;
        if (r3 <= Math.abs(r6)) goto L24;
        return r2;
    L7:
        r0 = 4;
        goto L8
    L29:
        return 0;
    }

    private int checkVerticalSwipe(RecyclerView.ViewHolder r8, int r9) {
        if ((r9 & 3) == 0) goto L29;
        int r2 = 2;
        if (this.mDy <= 0.0f) goto L7;
        int r0 = 2;
    L8:
        VelocityTracker r4 = this.mVelocityTracker;
        if (r4 != null) goto L11;
    L24:
        float r1 = this.mRecyclerView.getHeight() * this.mCallback.getSwipeThreshold(r8);
        if ((r9 & r0) != 0) goto L27;
        return 0;
    L27:
        if (Math.abs(this.mDy) <= r1) goto L32;
        return r0;
    L32:
        return 0;
    L11:
        if (this.mActivePointerId <= (-1)) goto L24;
        r4.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
        float r5 = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
        float r6 = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
        if (r6 > 0.0f) goto L16;
        r2 = 1;
    L16:
        float r3 = Math.abs(r6);
        if ((r2 & r9) == 0) goto L24;
        if (r2 != r0) goto L24;
        if (r3 < this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity)) goto L24;
        if (r3 <= Math.abs(r5)) goto L24;
        return r2;
    L7:
        r0 = 1;
        goto L8
    L29:
        return 0;
    }

    void removeChildDrawingOrderCallbackIfNecessary(View r2) {
        if (r2 != this.mOverdrawChild) goto L8;
        this.mOverdrawChild = null;
        if (this.mChildDrawingOrderCallback == null) goto L9;
        this.mRecyclerView.setChildDrawingOrderCallback(null);
        return;
    L9:
        return;
    }
}
