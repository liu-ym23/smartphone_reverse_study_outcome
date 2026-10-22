package androidx.recyclerview.widget;

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
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
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

    /* JADX INFO: renamed from: androidx.recyclerview.widget.ItemTouchHelper$5, reason: invalid class name */
    public class AnonymousClass5 implements RecyclerView.ChildDrawingOrderCallback {
        final /* synthetic */ ItemTouchHelper this$0;

        public AnonymousClass5(ItemTouchHelper r100) {
            this.this$0 = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ChildDrawingOrderCallback
        public int onGetChildDrawingOrder(int r100, int r101) {
            ItemTouchHelper r102 = this.this$0;
            View r103 = r102.mOverdrawChild;
            if (r103 != null) goto L5;
            return r101;
        L5:
            int r104 = r102.mOverdrawChildPosition;
            if (r104 != (-1)) goto L9;
            r104 = r102.mRecyclerView.indexOfChild(r103);
            this.this$0.mOverdrawChildPosition = r104;
        L9:
            if (r101 != (r100 - 1)) goto L11;
            return r104;
        L11:
            if (r101 >= r104) goto L14;
            return r101;
        L14:
            return r101 + 1;
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static abstract class Callback {
        private static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
        private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000;
        static final int RELATIVE_DIR_FLAGS = 3158064;
        private static final Interpolator sDragScrollInterpolator = null;
        private static final Interpolator sDragViewScrollCapInterpolator = null;
        private int mCachedMaxScrollSpeed;

        public static int convertToRelativeDirection(int r100, int r101) {
            int r102 = r100 & ABS_HORIZONTAL_DIR_FLAGS;
            if (r102 != 0) goto L5;
            return r100;
        L5:
            int r103 = r100 & (~r102);
            if (r101 != 0) goto L10;
            int r104 = r102 << 2;
        L9:
            return r103 | r104;
        L10:
            int r105 = r102 << 1;
            r103 = r103 | ((-789517) & r105);
            r104 = (r105 & ABS_HORIZONTAL_DIR_FLAGS) << 2;
            goto L9
        }

        public static int makeFlag(int r100, int r101) {
            return r101 << (r100 * 8);
        }

        public boolean canDropOver(RecyclerView r100, RecyclerView.ViewHolder r101, RecyclerView.ViewHolder r102) {
            return true;
        }

        public int convertToAbsoluteDirection(int r100, int r101) {
            int r102 = r100 & RELATIVE_DIR_FLAGS;
            if (r102 != 0) goto L5;
            return r100;
        L5:
            int r103 = r100 & (~r102);
            if (r101 != 0) goto L10;
            int r104 = r102 >> 2;
        L9:
            return r103 | r104;
        L10:
            int r105 = r102 >> 1;
            r103 = r103 | ((-3158065) & r105);
            r104 = (r105 & RELATIVE_DIR_FLAGS) >> 2;
            goto L9
        }

        public int getBoundingBoxMargin() {
            return 0;
        }

        public float getMoveThreshold(RecyclerView.ViewHolder r100) {
            return 0.5f;
        }

        public abstract int getMovementFlags(RecyclerView r100, RecyclerView.ViewHolder r101);

        public float getSwipeEscapeVelocity(float r100) {
            return r100;
        }

        public float getSwipeThreshold(RecyclerView.ViewHolder r100) {
            return 0.5f;
        }

        public float getSwipeVelocityThreshold(float r100) {
            return r100;
        }

        public boolean isItemViewSwipeEnabled() {
            return true;
        }

        public boolean isLongPressDragEnabled() {
            return true;
        }

        public abstract boolean onMove(RecyclerView r100, RecyclerView.ViewHolder r101, RecyclerView.ViewHolder r102);

        public abstract void onSwiped(RecyclerView.ViewHolder r100, int r101);

        static {
            sDragScrollInterpolator = new AnonymousClass1();
            sDragViewScrollCapInterpolator = new AnonymousClass2();
        }

        public Callback() {
            this.mCachedMaxScrollSpeed = -1;
        }

        public static ItemTouchUIUtil getDefaultUIUtil() {
            return ItemTouchUIUtilImpl.INSTANCE;
        }

        private int getMaxDragScroll(RecyclerView r100) {
            if (this.mCachedMaxScrollSpeed != (-1)) goto L6;
            this.mCachedMaxScrollSpeed = r100.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
        L6:
            return this.mCachedMaxScrollSpeed;
        }

        public static int makeMovementFlags(int r100, int r101) {
            int r102 = makeFlag(0, r101 | r100);
            int r103 = makeFlag(1, r101) | r102;
            return makeFlag(2, r100) | r103;
        }

        public void clearView(RecyclerView r100, RecyclerView.ViewHolder r101) {
            ItemTouchUIUtilImpl.INSTANCE.clearView(r101.itemView);
        }

        public final int getAbsoluteMovementFlags(RecyclerView r100, RecyclerView.ViewHolder r101) {
            return convertToAbsoluteDirection(getMovementFlags(r100, r101), ViewCompat.getLayoutDirection(r100));
        }

        public boolean hasDragFlag(RecyclerView r100, RecyclerView.ViewHolder r101) {
            if ((getAbsoluteMovementFlags(r100, r101) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasSwipeFlag(RecyclerView r100, RecyclerView.ViewHolder r101) {
            if ((getAbsoluteMovementFlags(r100, r101) & 65280) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void onSelectedChanged(RecyclerView.ViewHolder r100, int r101) {
            if (r100 == null) goto L5;
            ItemTouchUIUtilImpl.INSTANCE.onSelected(r100.itemView);
            return;
        }

        public RecyclerView.ViewHolder chooseDropTarget(RecyclerView.ViewHolder r110, List<RecyclerView.ViewHolder> r111, int r112, int r113) {
            int r100 = r112 + r110.itemView.getWidth();
            int r101 = r113 + r110.itemView.getHeight();
            int r102 = r112 - r110.itemView.getLeft();
            int r103 = r113 - r110.itemView.getTop();
            int r104 = r111.size();
            RecyclerView.ViewHolder r105 = null;
            int r106 = -1;
            int r107 = 0;
        L3:
            if (r107 >= r104) goto L38;
            RecyclerView.ViewHolder r114 = (RecyclerView.ViewHolder) ListProtector.get(r111, r107);
            if (r102 <= 0) goto L13;
            int r115 = r114.itemView.getRight() - r100;
            if (r115 >= 0) goto L13;
            if (r114.itemView.getRight() <= r110.itemView.getRight()) goto L13;
            int r116 = Math.abs(r115);
            if (r116 <= r106) goto L13;
            r105 = r114;
            r106 = r116;
        L13:
            if (r102 >= 0) goto L21;
            int r117 = r114.itemView.getLeft() - r112;
            if (r117 <= 0) goto L21;
            if (r114.itemView.getLeft() >= r110.itemView.getLeft()) goto L21;
            int r118 = Math.abs(r117);
            if (r118 <= r106) goto L21;
            r105 = r114;
            r106 = r118;
        L21:
            if (r103 >= 0) goto L29;
            int r119 = r114.itemView.getTop() - r113;
            if (r119 <= 0) goto L29;
            if (r114.itemView.getTop() >= r110.itemView.getTop()) goto L29;
            int r120 = Math.abs(r119);
            if (r120 <= r106) goto L29;
            r105 = r114;
            r106 = r120;
        L29:
            if (r103 <= 0) goto L37;
            int r121 = r114.itemView.getBottom() - r101;
            if (r121 >= 0) goto L37;
            if (r114.itemView.getBottom() <= r110.itemView.getBottom()) goto L37;
            int r122 = Math.abs(r121);
            if (r122 <= r106) goto L37;
            r105 = r114;
            r106 = r122;
        L37:
            r107 = r107 + 1;
            goto L3
        L38:
            return r105;
        }

        public long getAnimationDuration(RecyclerView r100, int r101, float r102, float r103) {
            RecyclerView.ItemAnimator r104 = r100.getItemAnimator();
            if (r104 != null) goto L8;
            if (r101 != 8) goto L6;
            return 200;
        L6:
            return 250;
        L8:
            if (r101 != 8) goto L11;
            return r104.getMoveDuration();
        L11:
            return r104.getRemoveDuration();
        }

        public int interpolateOutOfBoundsScroll(RecyclerView r100, int r101, int r102, int r103, long r104) {
            int r105 = getMaxDragScroll(r100);
            int r106 = Math.abs(r102);
            float r107 = 1.0f;
            int r108 = (int) ((((int) Math.signum(r102)) * r105) * sDragViewScrollCapInterpolator.getInterpolation(Math.min(1.0f, (r106 * 1.0f) / r101)));
            if (r104 > 2000) goto L6;
            r107 = r104 / 2000.0f;
        L6:
            int r109 = (int) (r108 * sDragScrollInterpolator.getInterpolation(r107));
            if (r109 != 0) goto L12;
            if (r102 <= 0) goto L10;
            return 1;
        L10:
            return -1;
        L12:
            return r109;
        }

        public void onChildDraw(Canvas r100, RecyclerView r110, RecyclerView.ViewHolder r111, float r112, float r113, int r114, boolean r115) {
            ItemTouchUIUtilImpl.INSTANCE.onDraw(r100, r110, r111.itemView, r112, r113, r114, r115);
        }

        public void onChildDrawOver(Canvas r100, RecyclerView r110, RecyclerView.ViewHolder r111, float r112, float r113, int r114, boolean r115) {
            ItemTouchUIUtilImpl.INSTANCE.onDrawOver(r100, r110, r111.itemView, r112, r113, r114, r115);
        }

        public void onDraw(Canvas r110, RecyclerView r111, RecyclerView.ViewHolder r112, List<RecoverAnimation> r113, int r114, float r115, float r210) {
            int r100 = r113.size();
            int r116 = 0;
        L3:
            if (r116 >= r100) goto L5;
            RecoverAnimation r101 = (RecoverAnimation) ListProtector.get(r113, r116);
            r101.update();
            int r117 = r110.save();
            onChildDraw(r110, r111, r101.mViewHolder, r101.mX, r101.mY, r101.mActionState, false);
            r110.restoreToCount(r117);
            r116 = r116 + 1;
            goto L3
        L5:
            if (r112 == null) goto L9;
            int r102 = r110.save();
            onChildDraw(r110, r111, r112, r115, r210, r114, true);
            r110.restoreToCount(r102);
            return;
        }

        public void onDrawOver(Canvas r110, RecyclerView r111, RecyclerView.ViewHolder r112, List<RecoverAnimation> r113, int r114, float r210, float r211) {
            int r115 = r113.size();
            boolean r116 = false;
            int r117 = 0;
        L3:
            if (r117 >= r115) goto L5;
            RecoverAnimation r100 = (RecoverAnimation) ListProtector.get(r113, r117);
            int r118 = r110.save();
            onChildDrawOver(r110, r111, r100.mViewHolder, r100.mX, r100.mY, r100.mActionState, false);
            r110.restoreToCount(r118);
            r117 = r117 + 1;
            goto L3
        L5:
            if (r112 == null) goto L7;
            int r119 = r110.save();
            onChildDrawOver(r110, r111, r112, r210, r211, r114, true);
            r110.restoreToCount(r119);
        L7:
            int r120 = r115 - 1;
        L8:
            if (r120 < 0) goto L17;
            RecoverAnimation r101 = (RecoverAnimation) ListProtector.get(r113, r120);
            boolean r102 = r101.mEnded;
            if (r102 == true) goto L12;
        L14:
            if (r102 == true) goto L16;
            r116 = true;
        L16:
            r120 = r120 - 1;
            goto L8
        L12:
            if (r101.mIsPendingCleanup == true) goto L14;
            ListProtector.remove(r113, r120);
            goto L16
        L17:
            if (r116 == false) goto L25;
            r111.invalidate();
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onMoved(RecyclerView r100, RecyclerView.ViewHolder r101, int r102, RecyclerView.ViewHolder r103, int r104, int r105, int r106) {
            RecyclerView.LayoutManager r107 = r100.getLayoutManager();
            if ((r107 instanceof ViewDropHandler) == false) goto L7;
            ((ViewDropHandler) r107).prepareForDrop(r101.itemView, r103.itemView, r105, r106);
            return;
        L7:
            if (r107.canScrollHorizontally() == false) goto L15;
            if (r107.getDecoratedLeft(r103.itemView) > r100.getPaddingLeft()) goto L12;
            r100.scrollToPosition(r104);
        L12:
            if (r107.getDecoratedRight(r103.itemView) < (r100.getWidth() - r100.getPaddingRight())) goto L15;
            r100.scrollToPosition(r104);
        L15:
            if (r107.canScrollVertically() == true) goto L17;
            return;
        L17:
            if (r107.getDecoratedTop(r103.itemView) > r100.getPaddingTop()) goto L20;
            r100.scrollToPosition(r104);
        L20:
            if (r107.getDecoratedBottom(r103.itemView) < (r100.getHeight() - r100.getPaddingBottom())) goto L24;
            r100.scrollToPosition(r104);
            return;
        }
    }

    public class ItemTouchHelperGestureListener extends GestureDetector.SimpleOnGestureListener {
        private boolean mShouldReactToLongPress;
        final /* synthetic */ ItemTouchHelper this$0;

        public void doNotReactToLongPress() {
            this.mShouldReactToLongPress = false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent r100) {
            return true;
        }

        public ItemTouchHelperGestureListener(ItemTouchHelper r100) {
            this.this$0 = r100;
            this.mShouldReactToLongPress = true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent r100) {
            if (this.mShouldReactToLongPress == true) goto L5;
            return;
        L5:
            View r101 = this.this$0.findChildView(r100);
            if (r101 == null) goto L18;
            RecyclerView.ViewHolder r102 = this.this$0.mRecyclerView.getChildViewHolder(r101);
            if (r102 == null) goto L19;
            ItemTouchHelper r103 = this.this$0;
            if (r103.mCallback.hasDragFlag(r103.mRecyclerView, r102) == true) goto L12;
            return;
        L12:
            int r104 = r100.getPointerId(0);
            int r105 = this.this$0.mActivePointerId;
            if (r104 != r105) goto L20;
            int r106 = r100.findPointerIndex(r105);
            float r107 = r100.getX(r106);
            float r108 = r100.getY(r106);
            ItemTouchHelper r109 = this.this$0;
            r109.mInitialTouchX = r107;
            r109.mInitialTouchY = r108;
            r109.mDy = 0.0f;
            r109.mDx = 0.0f;
            if (r109.mCallback.isLongPressDragEnabled() == false) goto L21;
            this.this$0.select(r102, 2);
            return;
        L21:
            return;
        L20:
            return;
        L19:
            return;
        }
    }

    public static class RecoverAnimation implements Animator.AnimatorListener {
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
        public void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r100) {
        }

        public void cancel() {
            this.mValueAnimator.cancel();
        }

        public void start() {
            this.mViewHolder.setIsRecyclable(false);
            this.mValueAnimator.start();
        }

        public void update() {
            float r100 = this.mStartDx;
            float r101 = this.mTargetX;
            if (r100 != r101) goto L5;
            this.mX = this.mViewHolder.itemView.getTranslationX();
        L6:
            float r102 = this.mStartDy;
            float r103 = this.mTargetY;
            if (r102 != r103) goto L9;
            this.mY = this.mViewHolder.itemView.getTranslationY();
            return;
        L9:
            this.mY = r102 + (this.mFraction * (r103 - r102));
            return;
        L5:
            this.mX = r100 + (this.mFraction * (r101 - r100));
            goto L6
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r100) {
            setFraction(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r100) {
            if (this.mEnded == true) goto L5;
            this.mViewHolder.setIsRecyclable(true);
        L5:
            this.mEnded = true;
        }

        public void setDuration(long r100) {
            this.mValueAnimator.setDuration(r100);
        }

        public void setFraction(float r100) {
            this.mFraction = r100;
        }

        public RecoverAnimation(RecyclerView.ViewHolder r100, int r101, int r102, float r103, float r104, float r105, float r106) {
            this.mOverridden = false;
            this.mEnded = false;
            this.mActionState = r102;
            this.mAnimationType = r101;
            this.mViewHolder = r100;
            this.mStartDx = r103;
            this.mStartDy = r104;
            this.mTargetX = r105;
            this.mTargetY = r106;
            ValueAnimator r107 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.mValueAnimator = r107;
            r107.addUpdateListener(new AnonymousClass1(this));
            r107.setTarget(r100.itemView);
            r107.addListener(this);
            setFraction(0.0f);
        }
    }

    public static abstract class SimpleCallback extends Callback {
        private int mDefaultDragDirs;
        private int mDefaultSwipeDirs;

        public void setDefaultDragDirs(int r100) {
            this.mDefaultDragDirs = r100;
        }

        public void setDefaultSwipeDirs(int r100) {
            this.mDefaultSwipeDirs = r100;
        }

        public SimpleCallback(int r100, int r101) {
            this.mDefaultSwipeDirs = r101;
            this.mDefaultDragDirs = r100;
        }

        public int getDragDirs(RecyclerView r100, RecyclerView.ViewHolder r101) {
            return this.mDefaultDragDirs;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(RecyclerView r100, RecyclerView.ViewHolder r101) {
            return Callback.makeMovementFlags(getDragDirs(r100, r101), getSwipeDirs(r100, r101));
        }

        public int getSwipeDirs(RecyclerView r100, RecyclerView.ViewHolder r101) {
            return this.mDefaultSwipeDirs;
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface ViewDropHandler {
        void prepareForDrop(View r100, View r101, int r102, int r103);
    }

    private void addChildDrawingOrderCallback() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewAttachedToWindow(View r100) {
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeItemDecoration(this);
        this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.removeOnChildAttachStateChangeListener(this);
        int r100 = this.mRecoverAnimations.size() - 1;
    L3:
        if (r100 < 0) goto L5;
        RecoverAnimation r101 = (RecoverAnimation) ListProtector.get(this.mRecoverAnimations, 0);
        r101.cancel();
        this.mCallback.clearView(this.mRecyclerView, r101.mViewHolder);
        r100 = r100 - 1;
        goto L3
    L5:
        this.mRecoverAnimations.clear();
        this.mOverdrawChild = null;
        this.mOverdrawChildPosition = -1;
        releaseVelocityTracker();
        stopGestureDetection();
    }

    private void releaseVelocityTracker() {
        VelocityTracker r100 = this.mVelocityTracker;
        if (r100 == null) goto L6;
        r100.recycle();
        this.mVelocityTracker = null;
        return;
    }

    private void setupCallbacks() {
        this.mSlop = ViewConfiguration.get(this.mRecyclerView.getContext()).getScaledTouchSlop();
        this.mRecyclerView.addItemDecoration(this);
        this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.addOnChildAttachStateChangeListener(this);
        startGestureDetection();
    }

    private void startGestureDetection() {
        this.mItemTouchHelperGestureListener = new ItemTouchHelperGestureListener(this);
        this.mGestureDetector = new GestureDetectorCompat(this.mRecyclerView.getContext(), this.mItemTouchHelperGestureListener);
    }

    private void stopGestureDetection() {
        ItemTouchHelperGestureListener r100 = this.mItemTouchHelperGestureListener;
        if (r100 == null) goto L6;
        r100.doNotReactToLongPress();
        this.mItemTouchHelperGestureListener = null;
    L6:
        if (this.mGestureDetector == null) goto L9;
        this.mGestureDetector = null;
        return;
    }

    public boolean hasRunningRecoverAnim() {
        int r100 = this.mRecoverAnimations.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L9;
        if (((RecoverAnimation) ListProtector.get(this.mRecoverAnimations, r101)).mEnded == false) goto L6;
        r101 = r101 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public void obtainVelocityTracker() {
        VelocityTracker r100 = this.mVelocityTracker;
        if (r100 == null) goto L5;
        r100.recycle();
    L5:
        this.mVelocityTracker = VelocityTracker.obtain();
    }

    public boolean scrollIfNecessary() {
        if (this.mSelected != null) goto L6;
        this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
        return false;
    L6:
        long r100 = System.currentTimeMillis();
        long r101 = this.mDragScrollStartTimeInMs;
        if (r101 != Long.MIN_VALUE) goto L9;
        long r102 = 0;
    L10:
        RecyclerView.LayoutManager r103 = this.mRecyclerView.getLayoutManager();
        if (this.mTmpRect != null) goto L13;
        this.mTmpRect = new Rect();
    L13:
        r103.calculateItemDecorationsForChild(this.mSelected.itemView, this.mTmpRect);
        if (r103.canScrollHorizontally() == false) goto L24;
        int r104 = (int) (this.mSelectedStartX + this.mDx);
        int r110 = (r104 - this.mTmpRect.left) - this.mRecyclerView.getPaddingLeft();
        float r111 = this.mDx;
        if (r111 >= 0.0f) goto L20;
        if (r110 >= 0) goto L20;
        int r112 = r110;
    L26:
        if (r103.canScrollVertically() == false) goto L36;
        int r105 = (int) (this.mSelectedStartY + this.mDy);
        int r106 = (r105 - this.mTmpRect.top) - this.mRecyclerView.getPaddingTop();
        float r113 = this.mDy;
        if (r113 >= 0.0f) goto L32;
        if (r106 >= 0) goto L32;
        int r107 = r106;
    L37:
        if (r112 == 0) goto L39;
        r112 = this.mCallback.interpolateOutOfBoundsScroll(this.mRecyclerView, this.mSelected.itemView.getWidth(), r112, this.mRecyclerView.getWidth(), r102);
    L39:
        int r114 = r112;
        if (r107 == 0) goto L42;
        Callback r108 = this.mCallback;
        RecyclerView r115 = this.mRecyclerView;
        int r116 = this.mSelected.itemView.getHeight();
        int r117 = this.mRecyclerView.getHeight();
        int r109 = r108.interpolateOutOfBoundsScroll(r115, r116, r107, r117, r102);
        int r118 = r114;
        r107 = r109;
    L43:
        if (r118 != 0) goto L49;
        if (r107 != 0) goto L49;
        this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
        return false;
    L49:
        if (this.mDragScrollStartTimeInMs != Long.MIN_VALUE) goto L51;
        this.mDragScrollStartTimeInMs = r100;
    L51:
        this.mRecyclerView.scrollBy(r118, r107);
        return true;
    L42:
        r118 = r114;
    L32:
        if (r113 <= 0.0f) goto L36;
        r107 = ((r105 + this.mSelected.itemView.getHeight()) + this.mTmpRect.bottom) - (this.mRecyclerView.getHeight() - this.mRecyclerView.getPaddingBottom());
        if (r107 > 0) goto L37;
    L36:
        r107 = 0;
    L20:
        if (r111 <= 0.0f) goto L24;
        int r119 = ((r104 + this.mSelected.itemView.getWidth()) + this.mTmpRect.right) - (this.mRecyclerView.getWidth() - this.mRecyclerView.getPaddingRight());
        if (r119 <= 0) goto L24;
        r112 = r119;
    L24:
        r112 = 0;
        goto L26
    L9:
        r102 = r100 - r101;
        goto L10
    }

    public ItemTouchHelper(Callback r100) {
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
        this.mCallback = r100;
    }

    private List<RecyclerView.ViewHolder> findSwapTargets(RecyclerView.ViewHolder r110) {
        RecyclerView.ViewHolder r100 = r110;
        List<RecyclerView.ViewHolder> r101 = this.mSwapTargets;
        if (r101 != null) goto L5;
        this.mSwapTargets = new ArrayList();
        this.mDistances = new ArrayList();
    L6:
        int r102 = this.mCallback.getBoundingBoxMargin();
        int r103 = Math.round(this.mSelectedStartX + this.mDx) - r102;
        int r104 = Math.round(this.mSelectedStartY + this.mDy) - r102;
        int r105 = r102 * 2;
        int r106 = (r100.itemView.getWidth() + r103) + r105;
        int r107 = (r100.itemView.getHeight() + r104) + r105;
        int r108 = (r103 + r106) / 2;
        int r109 = (r104 + r107) / 2;
        RecyclerView.LayoutManager r111 = this.mRecyclerView.getLayoutManager();
        int r112 = r111.getChildCount();
        int r113 = 0;
    L7:
        if (r113 >= r112) goto L30;
        View r114 = r111.getChildAt(r113);
        if (r114 == r100.itemView) goto L28;
        if (r114.getBottom() < r104) goto L28;
        if (r114.getTop() > r107) goto L28;
        if (r114.getRight() < r103) goto L28;
        if (r114.getLeft() > r106) goto L28;
        RecyclerView.ViewHolder r115 = this.mRecyclerView.getChildViewHolder(r114);
        if (this.mCallback.canDropOver(this.mRecyclerView, this.mSelected, r115) == false) goto L28;
        int r116 = Math.abs(r108 - ((r114.getLeft() + r114.getRight()) / 2));
        int r117 = Math.abs(r109 - ((r114.getTop() + r114.getBottom()) / 2));
        int r118 = (r116 * r116) + (r117 * r117);
        int r119 = this.mSwapTargets.size();
        int r120 = 0;
        int r121 = 0;
    L23:
        if (r120 >= r119) goto L27;
        if (r118 <= ((Integer) ListProtector.get(this.mDistances, r120)).intValue()) goto L27;
        r121 = r121 + 1;
        r120 = r120 + 1;
    L27:
        ListProtector.add(this.mSwapTargets, r121, r115);
        ListProtector.add(this.mDistances, r121, Integer.valueOf(r118));
    L28:
        r113 = r113 + 1;
        r100 = r110;
        goto L7
    L30:
        return this.mSwapTargets;
    L5:
        r101.clear();
        this.mDistances.clear();
        goto L6
    }

    private RecyclerView.ViewHolder findSwipedView(MotionEvent r100) {
        RecyclerView.LayoutManager r101 = this.mRecyclerView.getLayoutManager();
        int r102 = this.mActivePointerId;
        if (r102 != (-1)) goto L5;
        return null;
    L5:
        int r103 = r100.findPointerIndex(r102);
        float r104 = r100.getX(r103) - this.mInitialTouchX;
        float r105 = r100.getY(r103) - this.mInitialTouchY;
        float r106 = Math.abs(r104);
        float r107 = Math.abs(r105);
        int r108 = this.mSlop;
        if (r106 >= r108) goto L11;
        if (r107 >= r108) goto L11;
        return null;
    L11:
        if (r106 <= r107) goto L16;
        if (r101.canScrollHorizontally() == false) goto L16;
        return null;
    L16:
        if (r107 > r106) goto L18;
    L20:
        View r109 = findChildView(r100);
        if (r109 != null) goto L24;
        return null;
    L24:
        return this.mRecyclerView.getChildViewHolder(r109);
    L18:
        if (r101.canScrollVertically() == false) goto L20;
        return null;
    }

    private void getSelectedDxDy(float[] r100) {
        if ((this.mSelectedFlags & 12) == 0) goto L5;
        r100[0] = (this.mSelectedStartX + this.mDx) - this.mSelected.itemView.getLeft();
    L7:
        if ((this.mSelectedFlags & 3) == 0) goto L9;
        r100[1] = (this.mSelectedStartY + this.mDy) - this.mSelected.itemView.getTop();
        return;
    L9:
        r100[1] = this.mSelected.itemView.getTranslationY();
        return;
    L5:
        r100[0] = this.mSelected.itemView.getTranslationX();
        goto L7
    }

    private int swipeIfNecessary(RecyclerView.ViewHolder r100) {
        if (this.mActionState != 2) goto L5;
        return 0;
    L5:
        int r101 = this.mCallback.getMovementFlags(this.mRecyclerView, r100);
        int r102 = (this.mCallback.convertToAbsoluteDirection(r101, ViewCompat.getLayoutDirection(this.mRecyclerView)) & 65280) >> 8;
        if (r102 != 0) goto L8;
        return 0;
    L8:
        int r103 = (r101 & 65280) >> 8;
        if (Math.abs(this.mDx) <= Math.abs(this.mDy)) goto L20;
        int r104 = checkHorizontalSwipe(r100, r102);
        if (r104 > 0) goto L13;
        int r105 = checkVerticalSwipe(r100, r102);
        if (r105 <= 0) goto L29;
        return r105;
    L29:
        return 0;
    L13:
        if ((r103 & r104) == 0) goto L15;
        return r104;
    L15:
        return Callback.convertToRelativeDirection(r104, ViewCompat.getLayoutDirection(this.mRecyclerView));
    L20:
        int r106 = checkVerticalSwipe(r100, r102);
        if (r106 <= 0) goto L23;
        return r106;
    L23:
        int r107 = checkHorizontalSwipe(r100, r102);
        if (r107 <= 0) goto L29;
        if ((r103 & r107) == 0) goto L28;
        return r107;
    L28:
        return Callback.convertToRelativeDirection(r107, ViewCompat.getLayoutDirection(this.mRecyclerView));
    }

    public void attachToRecyclerView(RecyclerView r100) {
        RecyclerView r101 = this.mRecyclerView;
        if (r101 != r100) goto L5;
        return;
    L5:
        if (r101 == null) goto L7;
        destroyCallbacks();
    L7:
        this.mRecyclerView = r100;
        if (r100 == null) goto L11;
        Resources r102 = r100.getResources();
        this.mSwipeEscapeVelocity = r102.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
        this.mMaxSwipeVelocity = r102.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
        setupCallbacks();
        return;
    }

    public RecoverAnimation findAnimation(MotionEvent r100) {
        if (this.mRecoverAnimations.isEmpty() == false) goto L5;
        return null;
    L5:
        View r101 = findChildView(r100);
        int r102 = this.mRecoverAnimations.size() - 1;
    L6:
        if (r102 < 0) goto L11;
        RecoverAnimation r103 = (RecoverAnimation) ListProtector.get(this.mRecoverAnimations, r102);
        if (r103.mViewHolder.itemView == r101) goto L9;
        r102 = r102 - 1;
        goto L6
    L9:
        return r103;
    L11:
        return null;
    }

    public View findChildView(MotionEvent r100) {
        float r101 = r100.getX();
        float r102 = r100.getY();
        RecyclerView.ViewHolder r103 = this.mSelected;
        if (r103 == null) goto L7;
        View r104 = r103.itemView;
        if (hitTest(r104, r101, r102, this.mSelectedStartX + this.mDx, this.mSelectedStartY + this.mDy) == false) goto L7;
        return r104;
    L7:
        int r105 = this.mRecoverAnimations.size() - 1;
    L8:
        if (r105 < 0) goto L14;
        RecoverAnimation r106 = (RecoverAnimation) ListProtector.get(this.mRecoverAnimations, r105);
        View r107 = r106.mViewHolder.itemView;
        if (hitTest(r107, r101, r102, r106.mX, r106.mY) == true) goto L11;
        r105 = r105 - 1;
        goto L8
    L11:
        return r107;
    L14:
        return this.mRecyclerView.findChildViewUnder(r101, r102);
    }

    public void moveIfNecessary(RecyclerView.ViewHolder r110) {
        if (this.mRecyclerView.isLayoutRequested() == false) goto L6;
        return;
    L6:
        if (this.mActionState == 2) goto L8;
        return;
    L8:
        float r100 = this.mCallback.getMoveThreshold(r110);
        int r101 = (int) (this.mSelectedStartX + this.mDx);
        int r102 = (int) (this.mSelectedStartY + this.mDy);
        if (Math.abs(r102 - r110.itemView.getTop()) < (r110.itemView.getHeight() * r100)) goto L11;
    L13:
        List<RecyclerView.ViewHolder> r103 = findSwapTargets(r110);
        if (r103.size() != 0) goto L16;
        return;
    L16:
        RecyclerView.ViewHolder r104 = this.mCallback.chooseDropTarget(r110, r103, r101, r102);
        if (r104 != null) goto L20;
        this.mSwapTargets.clear();
        this.mDistances.clear();
        return;
    L20:
        int r105 = r104.getAbsoluteAdapterPosition();
        int r106 = r110.getAbsoluteAdapterPosition();
        if (this.mCallback.onMove(this.mRecyclerView, r110, r104) == false) goto L24;
        this.mCallback.onMoved(this.mRecyclerView, r110, r106, r104, r105, r101, r102);
        return;
    L24:
        return;
    L11:
        if (Math.abs(r101 - r110.itemView.getLeft()) >= (r110.itemView.getWidth() * r100)) goto L13;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewDetachedFromWindow(View r100) {
        removeChildDrawingOrderCallbackIfNecessary(r100);
        RecyclerView.ViewHolder r101 = this.mRecyclerView.getChildViewHolder(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        RecyclerView.ViewHolder r102 = this.mSelected;
        if (r102 == null) goto L9;
        if (r101 != r102) goto L9;
        select(null, 0);
        return;
    L9:
        endRecoverAnimation(r101, false);
        if (this.mPendingCleanup.remove(r101.itemView) == false) goto L14;
        this.mCallback.clearView(this.mRecyclerView, r101);
        return;
    }

    public void removeChildDrawingOrderCallbackIfNecessary(View r100) {
        if (r100 != this.mOverdrawChild) goto L8;
        this.mOverdrawChild = null;
        if (this.mChildDrawingOrderCallback == null) goto L9;
        this.mRecyclerView.setChildDrawingOrderCallback(null);
        return;
    L9:
        return;
    }

    public void startDrag(RecyclerView.ViewHolder r100) {
        if (this.mCallback.hasDragFlag(this.mRecyclerView, r100) == true) goto L6;
        return;
    L6:
        if (r100.itemView.getParent() == this.mRecyclerView) goto L8;
        return;
    L8:
        obtainVelocityTracker();
        this.mDy = 0.0f;
        this.mDx = 0.0f;
        select(r100, 2);
    }

    public void startSwipe(RecyclerView.ViewHolder r100) {
        if (this.mCallback.hasSwipeFlag(this.mRecyclerView, r100) == true) goto L6;
        return;
    L6:
        if (r100.itemView.getParent() == this.mRecyclerView) goto L8;
        return;
    L8:
        obtainVelocityTracker();
        this.mDy = 0.0f;
        this.mDx = 0.0f;
        select(r100, 1);
    }

    private int checkHorizontalSwipe(RecyclerView.ViewHolder r100, int r101) {
        if ((r101 & 12) == 0) goto L29;
        int r102 = 8;
        if (this.mDx <= 0.0f) goto L7;
        int r103 = 8;
    L8:
        VelocityTracker r104 = this.mVelocityTracker;
        if (r104 != null) goto L11;
    L24:
        float r105 = this.mRecyclerView.getWidth() * this.mCallback.getSwipeThreshold(r100);
        if ((r101 & r103) != 0) goto L27;
        return 0;
    L27:
        if (Math.abs(this.mDx) <= r105) goto L32;
        return r103;
    L32:
        return 0;
    L11:
        if (this.mActivePointerId <= (-1)) goto L24;
        r104.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
        float r106 = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
        float r107 = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
        if (r106 > 0.0f) goto L16;
        r102 = 4;
    L16:
        float r108 = Math.abs(r106);
        if ((r102 & r101) == 0) goto L24;
        if (r103 != r102) goto L24;
        if (r108 < this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity)) goto L24;
        if (r108 <= Math.abs(r107)) goto L24;
        return r102;
    L7:
        r103 = 4;
        goto L8
    L29:
        return 0;
    }

    private int checkVerticalSwipe(RecyclerView.ViewHolder r100, int r101) {
        if ((r101 & 3) == 0) goto L29;
        int r102 = 2;
        if (this.mDy <= 0.0f) goto L7;
        int r103 = 2;
    L8:
        VelocityTracker r104 = this.mVelocityTracker;
        if (r104 != null) goto L11;
    L24:
        float r105 = this.mRecyclerView.getHeight() * this.mCallback.getSwipeThreshold(r100);
        if ((r101 & r103) != 0) goto L27;
        return 0;
    L27:
        if (Math.abs(this.mDy) <= r105) goto L32;
        return r103;
    L32:
        return 0;
    L11:
        if (this.mActivePointerId <= (-1)) goto L24;
        r104.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
        float r106 = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
        float r107 = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
        if (r107 > 0.0f) goto L16;
        r102 = 1;
    L16:
        float r108 = Math.abs(r107);
        if ((r102 & r101) == 0) goto L24;
        if (r102 != r103) goto L24;
        if (r108 < this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity)) goto L24;
        if (r108 <= Math.abs(r106)) goto L24;
        return r102;
    L7:
        r103 = 1;
        goto L8
    L29:
        return 0;
    }

    public void endRecoverAnimation(RecyclerView.ViewHolder r100, boolean r101) {
        int r102 = this.mRecoverAnimations.size() - 1;
    L3:
        if (r102 < 0) goto L12;
        RecoverAnimation r103 = (RecoverAnimation) ListProtector.get(this.mRecoverAnimations, r102);
        if (r103.mViewHolder == r100) goto L6;
        r102 = r102 - 1;
        goto L3
    L6:
        r103.mOverridden |= r101;
        if (r103.mEnded == true) goto L9;
        r103.cancel();
    L9:
        ListProtector.remove(this.mRecoverAnimations, r102);
        return;
    }

    public void postDispatchSwipe(final RecoverAnimation r100, final int r101) {
        this.mRecyclerView.post(new AnonymousClass4(this, r100, r101));
    }

    public void select(RecyclerView.ViewHolder r210, int r211) {
        if (r210 == this.mSelected) goto L5;
    L7:
        this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
        final int r100 = this.mActionState;
        endRecoverAnimation(r210, true);
        this.mActionState = r211;
        if (r211 != 2) goto L13;
        if (r210 == null) goto L12;
        this.mOverdrawChild = r210.itemView;
        addChildDrawingOrderCallback();
        goto L13
    L12:
        throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
    L13:
        int r110 = (1 << ((r211 * 8) + 8)) - 1;
        final RecyclerView.ViewHolder r101 = this.mSelected;
        if (r101 != null) goto L16;
        boolean r102 = false;
    L42:
        if (r210 == null) goto L47;
        this.mSelectedFlags = (this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, r210) & r110) >> (this.mActionState * 8);
        this.mSelectedStartX = r210.itemView.getLeft();
        this.mSelectedStartY = r210.itemView.getTop();
        this.mSelected = r210;
        if (r211 != 2) goto L47;
        r210.itemView.performHapticFeedback(0);
    L47:
        ViewParent r103 = this.mRecyclerView.getParent();
        if (r103 != null) goto L50;
    L54:
        if (r102 == true) goto L56;
        this.mRecyclerView.getLayoutManager().requestSimpleAnimationsInNextLayout();
    L56:
        this.mCallback.onSelectedChanged(this.mSelected, this.mActionState);
        this.mRecyclerView.invalidate();
        return;
    L50:
        if (this.mSelected == null) goto L52;
        boolean r111 = true;
    L53:
        r103.requestDisallowInterceptTouchEvent(r111);
        goto L54
    L52:
        r111 = false;
        goto L53
    L16:
        if (r101.itemView.getParent() == null) goto L39;
        if (r100 != 2) goto L19;
        int r104 = 0;
    L20:
        releaseVelocityTracker();
        if (r104 == 1) goto L32;
        if (r104 == 2) goto L32;
        if (r104 == 4) goto L30;
        if (r104 == 8) goto L30;
        if (r104 == 16) goto L30;
        if (r104 == 32) goto L30;
        float r112 = 0.0f;
    L31:
        float r113 = 0.0f;
    L33:
        if (r100 != 2) goto L35;
        int r105 = 8;
    L38:
        getSelectedDxDy(this.mTmpPosition);
        float[] r106 = this.mTmpPosition;
        final float r114 = r106[0];
        final float r212 = r106[1];
        final int r107 = r105;
        final int r213 = r104;
        final float r108 = r112;
        final float r109 = r113;
        RecoverAnimation r115 = new AnonymousClass3(this, r101, r107, r100, r114, r212, r108, r109, r213, r101);
        r115.setDuration(this.mCallback.getAnimationDuration(this.mRecyclerView, r105, r112 - r114, r113 - r212));
        this.mRecoverAnimations.add(r115);
        r115.start();
        r102 = true;
    L40:
        this.mSelected = null;
        goto L42
    L35:
        if (r104 <= 0) goto L37;
        r105 = 2;
        goto L38
    L37:
        r105 = 4;
    L30:
        r112 = Math.signum(this.mDx) * this.mRecyclerView.getWidth();
    L32:
        r113 = Math.signum(this.mDy) * this.mRecyclerView.getHeight();
        r112 = 0.0f;
        goto L33
    L19:
        r104 = swipeIfNecessary(r101);
        goto L20
    L39:
        removeChildDrawingOrderCallbackIfNecessary(r101.itemView);
        this.mCallback.clearView(this.mRecyclerView, r101);
        r102 = false;
        goto L40
    L5:
        if (r211 != this.mActionState) goto L7;
    }

    public void checkSelectForSwipe(int r100, MotionEvent r110, int r111) {
        if (this.mSelected == null) goto L5;
        return;
    L5:
        if (r100 == 2) goto L7;
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
        RecyclerView.ViewHolder r101 = findSwipedView(r110);
        if (r101 != null) goto L17;
        return;
    L17:
        int r102 = (this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, r101) & 65280) >> 8;
        if (r102 != 0) goto L20;
        return;
    L20:
        float r103 = r110.getX(r111);
        float r112 = r110.getY(r111);
        float r104 = r103 - this.mInitialTouchX;
        float r113 = r112 - this.mInitialTouchY;
        float r105 = Math.abs(r104);
        float r106 = Math.abs(r113);
        int r107 = this.mSlop;
        if (r105 >= r107) goto L26;
        if (r106 >= r107) goto L26;
        return;
    L26:
        if (r105 <= r106) goto L38;
        if (r104 >= 0.0f) goto L33;
        if ((r102 & 4) != 0) goto L33;
        return;
    L33:
        if (r104 > 0.0f) goto L35;
    L47:
        this.mDy = 0.0f;
        this.mDx = 0.0f;
        this.mActivePointerId = r110.getPointerId(0);
        select(r101, 1);
        return;
    L35:
        if ((r102 & 8) != 0) goto L47;
        return;
    L38:
        if (r113 >= 0.0f) goto L43;
        if ((r102 & 1) != 0) goto L43;
        return;
    L43:
        if (r113 <= 0.0f) goto L47;
        if ((r102 & 2) != 0) goto L47;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas r110, RecyclerView r111, RecyclerView.State r112) {
        this.mOverdrawChildPosition = -1;
        if (this.mSelected == null) goto L5;
        getSelectedDxDy(this.mTmpPosition);
        float[] r113 = this.mTmpPosition;
        float r100 = r113[0];
        float r101 = r113[1];
        float r102 = r100;
    L6:
        this.mCallback.onDraw(r110, r111, this.mSelected, this.mRecoverAnimations, this.mActionState, r102, r101);
        return;
    L5:
        r102 = 0.0f;
        r101 = 0.0f;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas r110, RecyclerView r111, RecyclerView.State r112) {
        if (this.mSelected == null) goto L5;
        getSelectedDxDy(this.mTmpPosition);
        float[] r113 = this.mTmpPosition;
        float r100 = r113[0];
        float r101 = r113[1];
        float r102 = r100;
    L6:
        this.mCallback.onDrawOver(r110, r111, this.mSelected, this.mRecoverAnimations, this.mActionState, r102, r101);
        return;
    L5:
        r102 = 0.0f;
        r101 = 0.0f;
        goto L6
    }

    public void updateDxDy(MotionEvent r100, int r101, int r102) {
        float r103 = r100.getX(r102);
        float r104 = r100.getY(r102);
        float r105 = r103 - this.mInitialTouchX;
        this.mDx = r105;
        this.mDy = r104 - this.mInitialTouchY;
        if ((r101 & 4) != 0) goto L6;
        this.mDx = Math.max(0.0f, r105);
    L6:
        if ((r101 & 8) != 0) goto L9;
        this.mDx = Math.min(0.0f, this.mDx);
    L9:
        if ((r101 & 1) != 0) goto L12;
        this.mDy = Math.max(0.0f, this.mDy);
    L12:
        if ((r101 & 2) != 0) goto L15;
        this.mDy = Math.min(0.0f, this.mDy);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        r100.setEmpty();
    }

    private static boolean hitTest(View r100, float r101, float r102, float r103, float r104) {
        if (r101 >= r103) goto L5;
    L11:
        return false;
    L5:
        if (r101 > (r103 + r100.getWidth())) goto L11;
        if (r102 < r104) goto L11;
        if (r102 > (r104 + r100.getHeight())) goto L11;
        return true;
    }
}
