package com.obric.oui.orecyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ItemTouchHelper extends RecyclerView.g implements RecyclerView.j {
    private static final String TAG = "ItemTouchHelper";
    private ItemTouchHelperGestureListener A;
    private final RecyclerView.l B;
    private Rect C;
    private long D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final List<View> f35560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    RecyclerView.v f35561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    float f35562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    float f35563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    float f35564e;
    float f;
    int g;
    a h;
    int i;
    List<RecoverAnimation> j;
    RecyclerView k;
    final Runnable l;
    VelocityTracker m;
    View n;
    int o;
    GestureDetectorCompat p;
    private final float[] q;
    private float r;
    private float s;
    private float t;
    private float u;
    private int v;
    private int w;
    private List<RecyclerView.v> x;
    private List<Integer> y;
    private RecyclerView.c z;

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
            View r0 = this.this$0.a(r4);
            if (r0 == null) goto L18;
            RecyclerView.v r1 = this.this$0.k.getChildViewHolder(r0);
            if (r1 != null) goto L10;
            return;
        L10:
            if (this.this$0.h.hasDragFlag(this.this$0.k, r1) == true) goto L13;
            return;
        L13:
            if (r4.getPointerId(0) != this.this$0.g) goto L20;
            int r2 = r4.findPointerIndex(this.this$0.g);
            float r3 = r4.getX(r2);
            float r5 = r4.getY(r2);
            this.this$0.f35562c = r3;
            this.this$0.f35563d = r5;
            ItemTouchHelper r6 = this.this$0;
            r6.f = 0.0f;
            r6.f35564e = 0.0f;
            if (this.this$0.h.isLongPressDragEnabled() == false) goto L21;
            this.this$0.a(r1, 2);
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
        final RecyclerView.v mViewHolder;
        float mX;
        float mY;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r1) {
        }

        RecoverAnimation(RecyclerView.v r2, int r3, int r4, float r5, float r6, float r7, float r8) {
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
            r9.setTarget(r2.f35660b);
            r9.addListener(this);
            setFraction(0.0f);
        }

        public void setDuration(long r1) {
            this.mValueAnimator.setDuration(r1);
        }

        public void start() {
            this.mViewHolder.a(false);
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
            this.mX = this.mViewHolder.f35660b.getTranslationX();
        L6:
            float r2 = this.mStartDy;
            float r3 = this.mTargetY;
            if (r2 != r3) goto L9;
            this.mY = this.mViewHolder.f35660b.getTranslationY();
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
            this.mViewHolder.a(true);
        L5:
            this.mEnded = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r1) {
            setFraction(1.0f);
        }
    }

    public static abstract class a {
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

        public boolean canDropOver(RecyclerView r1, RecyclerView.v r2, RecyclerView.v r3) {
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

        public float getMoveThreshold(RecyclerView.v r1) {
            return 0.5f;
        }

        public abstract int getMovementFlags(RecyclerView r1, RecyclerView.v r2);

        public float getSwipeEscapeVelocity(float r1) {
            return r1;
        }

        public float getSwipeThreshold(RecyclerView.v r1) {
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

        public abstract boolean onMove(RecyclerView r1, RecyclerView.v r2, RecyclerView.v r3);

        public abstract void onSwiped(RecyclerView.v r1, int r2);

        public a() {
            this.mCachedMaxScrollSpeed = -1;
        }

        static {
            sDragScrollInterpolator = new ItemTouchHelper$Callback$1();
            sDragViewScrollCapInterpolator = new ItemTouchHelper$Callback$2();
        }

        public static l getDefaultUIUtil() {
            return m.f35812a;
        }

        public static int makeMovementFlags(int r2, int r3) {
            int r0 = makeFlag(0, r3 | r2);
            int r4 = makeFlag(1, r3) | r0;
            return makeFlag(2, r2) | r4;
        }

        final int getAbsoluteMovementFlags(RecyclerView r1, RecyclerView.v r2) {
            return convertToAbsoluteDirection(getMovementFlags(r1, r2), ViewCompat.i(r1));
        }

        boolean hasDragFlag(RecyclerView r1, RecyclerView.v r2) {
            if ((getAbsoluteMovementFlags(r1, r2) & 16711680) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean hasSwipeFlag(RecyclerView r1, RecyclerView.v r2) {
            if ((getAbsoluteMovementFlags(r1, r2) & 65280) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public RecyclerView.v chooseDropTarget(RecyclerView.v r16, List<RecyclerView.v> r17, int r18, int r19) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin");
            int r3 = r18 + r16.f35660b.getWidth();
            int r4 = r19 + r16.f35660b.getHeight();
            int r5 = r18 - r16.f35660b.getLeft();
            int r6 = r19 - r16.f35660b.getTop();
            int r7 = r1.size();
            RecyclerView.v r8 = null;
            int r9 = -1;
            int r10 = 0;
        L3:
            if (r10 >= r7) goto L38;
            RecyclerView.v r11 = (RecyclerView.v) ZeusTransformUtils.preCheckCast(r1.get(r10), RecyclerView.v.class, "com.obric.aiagent.plugin");
            if (r5 <= 0) goto L13;
            int r12 = r11.f35660b.getRight() - r3;
            if (r12 >= 0) goto L13;
            if (r11.f35660b.getRight() <= r16.f35660b.getRight()) goto L13;
            int r13 = Math.abs(r12);
            if (r13 <= r9) goto L13;
            r8 = r11;
            r9 = r13;
        L13:
            if (r5 >= 0) goto L21;
            int r14 = r11.f35660b.getLeft() - r18;
            if (r14 <= 0) goto L21;
            if (r11.f35660b.getLeft() >= r16.f35660b.getLeft()) goto L21;
            int r15 = Math.abs(r14);
            if (r15 <= r9) goto L21;
            r8 = r11;
            r9 = r15;
        L21:
            if (r6 >= 0) goto L29;
            int r110 = r11.f35660b.getTop() - r19;
            if (r110 <= 0) goto L29;
            if (r11.f35660b.getTop() >= r16.f35660b.getTop()) goto L29;
            int r111 = Math.abs(r110);
            if (r111 <= r9) goto L29;
            r8 = r11;
            r9 = r111;
        L29:
            if (r6 <= 0) goto L37;
            int r112 = r11.f35660b.getBottom() - r4;
            if (r112 >= 0) goto L37;
            if (r11.f35660b.getBottom() <= r16.f35660b.getBottom()) goto L37;
            int r113 = Math.abs(r112);
            if (r113 <= r9) goto L37;
            r8 = r11;
            r9 = r113;
        L37:
            r10 = r10 + 1;
            goto L3
        L38:
            return r8;
        }

        public void onSelectedChanged(RecyclerView.v r1, int r2) {
            if (r1 == null) goto L5;
            m.f35812a.b(r1.f35660b);
            return;
        }

        private int getMaxDragScroll(RecyclerView r4) {
            if (this.mCachedMaxScrollSpeed != (-1)) goto L6;
            this.mCachedMaxScrollSpeed = ZeusTransformUtils.getResources(r4, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.item_touch_helper_max_drag_scroll_per_frame, "dimen", "item_touch_helper_max_drag_scroll_per_frame"));
        L6:
            return this.mCachedMaxScrollSpeed;
        }

        public void onMoved(RecyclerView r1, RecyclerView.v r2, int r3, RecyclerView.v r4, int r5, int r6, int r7) {
            RecyclerView.h r0 = r1.getLayoutManager();
            if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L7;
            ((b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.aiagent.plugin")).a(r2.f35660b, r4.f35660b, r6, r7);
            return;
        L7:
            if (r0.f() == false) goto L15;
            if (r0.h(r4.f35660b) > r1.getPaddingLeft()) goto L12;
            r1.scrollToPosition(r5);
        L12:
            if (r0.j(r4.f35660b) < (r1.getWidth() - r1.getPaddingRight())) goto L15;
            r1.scrollToPosition(r5);
        L15:
            if (r0.g() == true) goto L17;
            return;
        L17:
            if (r0.i(r4.f35660b) > r1.getPaddingTop()) goto L20;
            r1.scrollToPosition(r5);
        L20:
            if (r0.k(r4.f35660b) < (r1.getHeight() - r1.getPaddingBottom())) goto L24;
            r1.scrollToPosition(r5);
            return;
        }

        void onDraw(Canvas r15, RecyclerView r16, RecyclerView.v r17, List<RecoverAnimation> r18, int r19, float r20, float r21) {
            List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
            int r11 = r10.size();
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L5;
            RecoverAnimation r0 = (RecoverAnimation) ZeusTransformUtils.preCheckCast(r10.get(r12), RecoverAnimation.class, "com.obric.aiagent.plugin");
            r0.update();
            int r13 = r15.save();
            onChildDraw(r15, r16, r0.mViewHolder, r0.mX, r0.mY, r0.mActionState, false);
            r15.restoreToCount(r13);
            r12 = r12 + 1;
            goto L3
        L5:
            if (r17 == null) goto L9;
            int r9 = r15.save();
            onChildDraw(r15, r16, r17, r20, r21, r19, true);
            r15.restoreToCount(r9);
            return;
        }

        void onDrawOver(Canvas r16, RecyclerView r17, RecyclerView.v r18, List<RecoverAnimation> r19, int r20, float r21, float r22) {
            List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
            int r11 = r10.size();
            boolean r12 = false;
            int r13 = 0;
        L3:
            if (r13 >= r11) goto L5;
            RecoverAnimation r0 = (RecoverAnimation) ZeusTransformUtils.preCheckCast(r10.get(r13), RecoverAnimation.class, "com.obric.aiagent.plugin");
            int r14 = r16.save();
            onChildDrawOver(r16, r17, r0.mViewHolder, r0.mX, r0.mY, r0.mActionState, false);
            r16.restoreToCount(r14);
            r13 = r13 + 1;
            goto L3
        L5:
            if (r18 == null) goto L7;
            int r15 = r16.save();
            onChildDrawOver(r16, r17, r18, r21, r22, r20, true);
            r16.restoreToCount(r15);
        L7:
            int r110 = r11 - 1;
        L8:
            if (r110 < 0) goto L18;
            RecoverAnimation r1 = (RecoverAnimation) ZeusTransformUtils.preCheckCast(r10.get(r110), RecoverAnimation.class, "com.obric.aiagent.plugin");
            if (r1.mEnded == false) goto L15;
            if (r1.mIsPendingCleanup == true) goto L15;
            r10.remove(r110);
        L17:
            r110 = r110 - 1;
        L15:
            if (r1.mEnded == true) goto L17;
            r12 = true;
            goto L17
        L18:
            if (r12 == false) goto L26;
            r17.invalidate();
            return;
        }

        public void clearView(RecyclerView r1, RecyclerView.v r2) {
            m.f35812a.a(r2.f35660b);
        }

        public void onChildDraw(Canvas r9, RecyclerView r10, RecyclerView.v r11, float r12, float r13, int r14, boolean r15) {
            m.f35812a.a(r9, r10, r11.f35660b, r12, r13, r14, r15);
        }

        public void onChildDrawOver(Canvas r9, RecyclerView r10, RecyclerView.v r11, float r12, float r13, int r14, boolean r15) {
            m.f35812a.b(r9, r10, r11.f35660b, r12, r13, r14, r15);
        }

        public long getAnimationDuration(RecyclerView r1, int r2, float r3, float r4) {
            RecyclerView.e r0 = r1.getItemAnimator();
            if (r0 != null) goto L8;
            if (r2 != 8) goto L6;
            return 200;
        L6:
            return 250;
        L8:
            if (r2 != 8) goto L11;
            return r0.f();
        L11:
            return r0.h();
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

    public interface b {
        void a(View r1, View r2, int r3, int r4);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.j
    public void a(View r1) {
    }

    public ItemTouchHelper(a r4) {
        this.f35560a = new ArrayList();
        this.q = new float[2];
        this.f35561b = null;
        this.g = -1;
        this.v = 0;
        this.j = new ArrayList();
        this.l = new AnonymousClass1(this);
        this.z = null;
        this.n = null;
        this.o = -1;
        this.B = new AnonymousClass2(this);
        this.h = r4;
    }

    private static boolean a(View r1, float r2, float r3, float r4, float r5) {
        if (r2 >= r4) goto L5;
    L11:
        return false;
    L5:
        if (r2 > (r4 + r1.getWidth())) goto L11;
        if (r3 < r5) goto L11;
        if (r3 > (r5 + r1.getHeight())) goto L11;
        return true;
    }

    public void a(RecyclerView r4) {
        RecyclerView r0 = this.k;
        if (r0 != r4) goto L5;
        return;
    L5:
        if (r0 == null) goto L7;
        e();
    L7:
        this.k = r4;
        if (r4 == null) goto L11;
        Resources r5 = ZeusTransformUtils.getResources(r4, "com.obric.aiagent.plugin");
        this.r = r5.getDimension(ZeusTransformUtils.mapRes(R.dimen.item_touch_helper_swipe_escape_velocity, "dimen", "item_touch_helper_swipe_escape_velocity"));
        this.s = r5.getDimension(ZeusTransformUtils.mapRes(R.dimen.item_touch_helper_swipe_escape_max_velocity, "dimen", "item_touch_helper_swipe_escape_max_velocity"));
        d();
        return;
    }

    private void d() {
        this.w = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.k.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getScaledTouchSlop();
        this.k.addItemDecoration(this);
        this.k.addOnItemTouchListener(this.B);
        this.k.addOnChildAttachStateChangeListener(this);
        f();
    }

    private void e() {
        this.k.removeItemDecoration(this);
        this.k.removeOnItemTouchListener(this.B);
        this.k.removeOnChildAttachStateChangeListener(this);
        int r0 = this.j.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        RecoverAnimation r1 = (RecoverAnimation) ZeusTransformUtils.preCheckCast(this.j.get(0), RecoverAnimation.class, "com.obric.aiagent.plugin");
        r1.cancel();
        this.h.clearView(this.k, r1.mViewHolder);
        r0 = r0 - 1;
        goto L3
    L5:
        this.j.clear();
        this.n = null;
        this.o = -1;
        h();
        g();
    }

    private void f() {
        this.A = new ItemTouchHelperGestureListener(this);
        this.p = new GestureDetectorCompat((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.k.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.A);
    }

    private void g() {
        ItemTouchHelperGestureListener r0 = this.A;
        if (r0 == null) goto L6;
        r0.doNotReactToLongPress();
        this.A = null;
    L6:
        if (this.p == null) goto L9;
        this.p = null;
        return;
    }

    private void a(float[] r4) {
        if ((this.i & 12) == 0) goto L5;
        r4[0] = (this.t + this.f35564e) - this.f35561b.f35660b.getLeft();
    L7:
        if ((this.i & 3) == 0) goto L9;
        r4[1] = (this.u + this.f) - this.f35561b.f35660b.getTop();
        return;
    L9:
        r4[1] = this.f35561b.f35660b.getTranslationY();
        return;
    L5:
        r4[0] = this.f35561b.f35660b.getTranslationX();
        goto L7
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.g
    public void a(Canvas r10, RecyclerView r11, RecyclerView.s r12) {
        if (this.f35561b == null) goto L5;
        a(this.q);
        float[] r13 = this.q;
        float r0 = r13[0];
        float r8 = r13[1];
        float r7 = r0;
    L6:
        this.h.onDrawOver(r10, r11, this.f35561b, this.j, this.v, r7, r8);
        return;
    L5:
        r7 = 0.0f;
        r8 = 0.0f;
        goto L6
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.g
    public void b(Canvas r10, RecyclerView r11, RecyclerView.s r12) {
        this.o = -1;
        if (this.f35561b == null) goto L5;
        a(this.q);
        float[] r13 = this.q;
        float r0 = r13[0];
        float r8 = r13[1];
        float r7 = r0;
    L6:
        this.h.onDraw(r10, r11, this.f35561b, this.j, this.v, r7, r8);
        return;
    L5:
        r7 = 0.0f;
        r8 = 0.0f;
        goto L6
    }

    void a(RecyclerView.v r24, int r25) {
        if (r24 == this.f35561b) goto L5;
    L7:
        this.D = Long.MIN_VALUE;
        final int r4 = this.v;
        a(r24, true);
        this.v = r25;
        if (r25 != 2) goto L13;
        if (r24 == null) goto L12;
        this.n = r24.f35660b;
        i();
        goto L13
    L12:
        throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
    L13:
        int r16 = (1 << ((r25 * 8) + 8)) - 1;
        final RecyclerView.v r9 = this.f35561b;
        if (r9 != null) goto L16;
        boolean r8 = false;
    L41:
        if (r24 == null) goto L45;
        this.i = (this.h.getAbsoluteMovementFlags(this.k, r24) & r16) >> (this.v * 8);
        this.t = r24.f35660b.getLeft();
        this.u = r24.f35660b.getTop();
        this.f35561b = r24;
        if (r25 != 2) goto L45;
        boolean r1 = false;
        r24.f35660b.performHapticFeedback(0);
    L46:
        ViewParent r0 = this.k.getParent();
        if (r0 != null) goto L49;
    L53:
        if (r8 == true) goto L55;
        this.k.getLayoutManager().M();
    L55:
        this.h.onSelectedChanged(this.f35561b, this.v);
        this.k.invalidate();
        return;
    L49:
        if (this.f35561b == null) goto L51;
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
        if (r9.f35660b.getParent() == null) goto L38;
        if (r4 != 2) goto L19;
        int r7 = 0;
    L20:
        h();
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
        a(this.q);
        float[] r2 = this.q;
        final float r19 = r2[0];
        final float r20 = r2[1];
        final int r3 = r6;
        final int r21 = r7;
        final float r10 = r17;
        final float r11 = r18;
        RecoverAnimation r5 = new AnonymousClass3(this, r9, r3, r4, r19, r20, r10, r11, r21, r9);
        r5.setDuration(this.h.getAnimationDuration(this.k, r6, r17 - r19, r18 - r20));
        this.j.add(r5);
        r5.start();
        r8 = true;
    L39:
        this.f35561b = null;
        goto L41
    L34:
        if (r7 <= 0) goto L36;
        r6 = 2;
        goto L37
    L36:
        r6 = 4;
    L30:
        r18 = 0.0f;
        r17 = Math.signum(this.f35564e) * this.k.getWidth();
    L31:
        r17 = 0.0f;
        r18 = Math.signum(this.f) * this.k.getHeight();
        goto L32
    L19:
        r7 = c(r9);
        goto L20
    L38:
        c(r9.f35660b);
        this.h.clearView(this.k, r9);
        r8 = false;
        goto L39
    L5:
        if (r25 != this.v) goto L7;
    }

    void a(final RecoverAnimation r3, final int r4) {
        this.k.post(new AnonymousClass4(this, r3, r4));
    }

    boolean a() {
        int r0 = this.j.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (((RecoverAnimation) ZeusTransformUtils.preCheckCast(this.j.get(r2), RecoverAnimation.class, "com.obric.aiagent.plugin")).mEnded == false) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    boolean b() {
        if (this.f35561b != null) goto L6;
        this.D = Long.MIN_VALUE;
        return false;
    L6:
        long r5 = System.currentTimeMillis();
        long r7 = this.D;
        if (r7 != Long.MIN_VALUE) goto L9;
        long r8 = 0;
    L10:
        RecyclerView.h r1 = this.k.getLayoutManager();
        if (this.C != null) goto L13;
        this.C = new Rect();
    L13:
        r1.b(this.f35561b.f35660b, this.C);
        if (r1.f() == false) goto L24;
        int r9 = (int) (this.t + this.f35564e);
        int r11 = (r9 - this.C.left) - this.k.getPaddingLeft();
        float r12 = this.f35564e;
        if (r12 >= 0.0f) goto L20;
        if (r11 >= 0) goto L20;
        int r13 = r11;
    L26:
        if (r1.g() == false) goto L36;
        int r2 = (int) (this.u + this.f);
        int r10 = (r2 - this.C.top) - this.k.getPaddingTop();
        float r14 = this.f;
        if (r14 >= 0.0f) goto L32;
        if (r10 >= 0) goto L32;
        int r3 = r10;
    L37:
        if (r13 == 0) goto L39;
        r13 = this.h.interpolateOutOfBoundsScroll(this.k, this.f35561b.f35660b.getWidth(), r13, this.k.getWidth(), r8);
    L39:
        int r15 = r13;
        if (r3 == 0) goto L42;
        int r16 = r15;
        r3 = this.h.interpolateOutOfBoundsScroll(this.k, this.f35561b.f35660b.getHeight(), r3, this.k.getHeight(), r8);
    L43:
        if (r16 != 0) goto L49;
        if (r3 != 0) goto L49;
        this.D = Long.MIN_VALUE;
        return false;
    L49:
        if (this.D != Long.MIN_VALUE) goto L51;
        this.D = r5;
    L51:
        this.k.scrollBy(r16, r3);
        return true;
    L42:
        r16 = r15;
    L32:
        if (r14 <= 0.0f) goto L36;
        r3 = ((r2 + this.f35561b.f35660b.getHeight()) + this.C.bottom) - (this.k.getHeight() - this.k.getPaddingBottom());
        if (r3 > 0) goto L37;
    L36:
        r3 = 0;
    L20:
        if (r12 <= 0.0f) goto L24;
        int r17 = ((r9 + this.f35561b.f35660b.getWidth()) + this.C.right) - (this.k.getWidth() - this.k.getPaddingRight());
        if (r17 <= 0) goto L24;
        r13 = r17;
    L24:
        r13 = 0;
        goto L26
    L9:
        r8 = r5 - r7;
        goto L10
    }

    private List<RecyclerView.v> b(RecyclerView.v r19) {
        RecyclerView.v r1 = r19;
        List<RecyclerView.v> r2 = this.x;
        if (r2 != null) goto L5;
        this.x = new ArrayList();
        this.y = new ArrayList();
    L6:
        int r3 = this.h.getBoundingBoxMargin();
        int r4 = Math.round(this.t + this.f35564e) - r3;
        int r5 = Math.round(this.u + this.f) - r3;
        int r6 = r3 * 2;
        int r7 = (r1.f35660b.getWidth() + r4) + r6;
        int r8 = (r1.f35660b.getHeight() + r5) + r6;
        int r9 = (r4 + r7) / 2;
        int r10 = (r5 + r8) / 2;
        RecyclerView.h r11 = this.k.getLayoutManager();
        int r12 = r11.y();
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L32;
        View r14 = r11.i(r13);
        if (r14 != r1.f35660b) goto L12;
    L29:
        int r16 = r9;
        int r17 = r4;
    L30:
        r13 = r13 + 1;
        r1 = r19;
        r9 = r16;
        r4 = r17;
        goto L7
    L12:
        if (r14.getBottom() < r5) goto L29;
        if (r14.getTop() > r8) goto L29;
        if (r14.getRight() < r4) goto L29;
        if (r14.getLeft() > r7) goto L29;
        RecyclerView.v r15 = this.k.getChildViewHolder(r14);
        if (this.h.canDropOver(this.k, this.f35561b, r15) == false) goto L29;
        int r18 = Math.abs(r9 - ((r14.getLeft() + r14.getRight()) / 2));
        int r110 = Math.abs(r10 - ((r14.getTop() + r14.getBottom()) / 2));
        int r111 = (r18 * r18) + (r110 * r110);
        int r112 = this.x.size();
        int r113 = 0;
        int r114 = 0;
    L23:
        if (r113 >= r112) goto L27;
        r16 = r9;
        r17 = r4;
        if (r111 <= ((Integer) ZeusTransformUtils.preCheckCast(this.y.get(r113), Integer.class, "com.obric.aiagent.plugin")).intValue()) goto L28;
        r114 = r114 + 1;
        r113 = r113 + 1;
        r9 = r16;
        r4 = r17;
    L28:
        this.x.add(r114, r15);
        this.y.add(r114, Integer.valueOf(r111));
        goto L30
    L27:
        r16 = r9;
        r17 = r4;
        goto L28
    L32:
        return this.x;
    L5:
        r2.clear();
        this.y.clear();
        goto L6
    }

    void a(RecyclerView.v r11) {
        if (this.k.isLayoutRequested() == false) goto L6;
        return;
    L6:
        if (this.v == 2) goto L8;
        return;
    L8:
        float r0 = this.h.getMoveThreshold(r11);
        int r8 = (int) (this.t + this.f35564e);
        int r9 = (int) (this.u + this.f);
        if (Math.abs(r9 - r11.f35660b.getTop()) < (r11.f35660b.getHeight() * r0)) goto L11;
    L13:
        List<RecyclerView.v> r1 = b(r11);
        if (r1.size() != 0) goto L16;
        return;
    L16:
        RecyclerView.v r6 = this.h.chooseDropTarget(r11, r1, r8, r9);
        if (r6 != null) goto L20;
        this.x.clear();
        this.y.clear();
        return;
    L20:
        int r7 = r6.k();
        int r5 = r11.k();
        if (this.h.onMove(this.k, r11, r6) == false) goto L24;
        this.h.onMoved(this.k, r11, r5, r6, r7, r8, r9);
        return;
    L24:
        return;
    L11:
        if (Math.abs(r8 - r11.f35660b.getLeft()) >= (r11.f35660b.getWidth() * r0)) goto L13;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.j
    public void b(View r3) {
        c(r3);
        RecyclerView.v r4 = this.k.getChildViewHolder(r3);
        if (r4 != null) goto L5;
        return;
    L5:
        RecyclerView.v r0 = this.f35561b;
        if (r0 == null) goto L9;
        if (r4 != r0) goto L9;
        a(null, 0);
        return;
    L9:
        a(r4, false);
        if (this.f35560a.remove(r4.f35660b) == false) goto L14;
        this.h.clearView(this.k, r4);
        return;
    }

    void a(RecyclerView.v r5, boolean r6) {
        int r0 = this.j.size() - 1;
    L3:
        if (r0 < 0) goto L12;
        RecoverAnimation r1 = (RecoverAnimation) ZeusTransformUtils.preCheckCast(this.j.get(r0), RecoverAnimation.class, "com.obric.aiagent.plugin");
        if (r1.mViewHolder == r5) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        r1.mOverridden |= r6;
        if (r1.mEnded == true) goto L9;
        r1.cancel();
    L9:
        this.j.remove(r0);
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.g
    public void a(Rect r1, View r2, RecyclerView r3, RecyclerView.s r4) {
        r1.setEmpty();
    }

    void c() {
        VelocityTracker r0 = this.m;
        if (r0 == null) goto L5;
        r0.recycle();
    L5:
        this.m = VelocityTracker.obtain();
    }

    private void h() {
        VelocityTracker r0 = this.m;
        if (r0 == null) goto L6;
        r0.recycle();
        this.m = null;
        return;
    }

    private RecyclerView.v c(MotionEvent r7) {
        RecyclerView.h r0 = this.k.getLayoutManager();
        int r1 = this.g;
        if (r1 != (-1)) goto L5;
        return null;
    L5:
        int r2 = r7.findPointerIndex(r1);
        float r3 = r7.getX(r2) - this.f35562c;
        float r4 = r7.getY(r2) - this.f35563d;
        float r5 = Math.abs(r3);
        float r6 = Math.abs(r4);
        int r8 = this.w;
        if (r5 >= r8) goto L11;
        if (r6 >= r8) goto L11;
        return null;
    L11:
        if (r5 <= r6) goto L16;
        if (r0.f() == false) goto L16;
        return null;
    L16:
        if (r6 > r5) goto L18;
    L20:
        View r9 = a(r7);
        if (r9 != null) goto L24;
        return null;
    L24:
        return this.k.getChildViewHolder(r9);
    L18:
        if (r0.g() == false) goto L20;
        return null;
    }

    void a(int r9, MotionEvent r10, int r11) {
        if (this.f35561b == null) goto L5;
        return;
    L5:
        if (r9 == 2) goto L7;
        return;
    L7:
        if (this.v != 2) goto L9;
        return;
    L9:
        if (this.h.isItemViewSwipeEnabled() == true) goto L12;
        return;
    L12:
        if (this.k.getScrollState() != 1) goto L14;
        return;
    L14:
        RecyclerView.v r12 = c(r10);
        if (r12 != null) goto L17;
        return;
    L17:
        int r2 = (this.h.getAbsoluteMovementFlags(this.k, r12) & 65280) >> 8;
        if (r2 != 0) goto L20;
        return;
    L20:
        float r3 = r10.getX(r11);
        float r13 = r10.getY(r11);
        float r4 = r3 - this.f35562c;
        float r14 = r13 - this.f35563d;
        float r5 = Math.abs(r4);
        float r6 = Math.abs(r14);
        int r7 = this.w;
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
        this.f = 0.0f;
        this.f35564e = 0.0f;
        this.g = r10.getPointerId(0);
        a(r12, 1);
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

    View a(MotionEvent r6) {
        float r0 = r6.getX();
        float r7 = r6.getY();
        RecyclerView.v r1 = this.f35561b;
        if (r1 == null) goto L7;
        View r2 = r1.f35660b;
        if (a(r2, r0, r7, this.t + this.f35564e, this.u + this.f) == false) goto L7;
        return r2;
    L7:
        int r3 = this.j.size() - 1;
    L8:
        if (r3 < 0) goto L14;
        RecoverAnimation r4 = (RecoverAnimation) ZeusTransformUtils.preCheckCast(this.j.get(r3), RecoverAnimation.class, "com.obric.aiagent.plugin");
        View r5 = r4.mViewHolder.f35660b;
        if (a(r5, r0, r7, r4.mX, r4.mY) == true) goto L11;
        r3 = r3 - 1;
        goto L8
    L11:
        return r5;
    L14:
        return this.k.findChildViewUnder(r0, r7);
    }

    RecoverAnimation b(MotionEvent r6) {
        if (this.j.isEmpty() == false) goto L5;
        return null;
    L5:
        View r7 = a(r6);
        int r0 = this.j.size() - 1;
    L6:
        if (r0 < 0) goto L11;
        RecoverAnimation r2 = (RecoverAnimation) ZeusTransformUtils.preCheckCast(this.j.get(r0), RecoverAnimation.class, "com.obric.aiagent.plugin");
        if (r2.mViewHolder.f35660b == r7) goto L9;
        r0 = r0 - 1;
        goto L6
    L9:
        return r2;
    L11:
        return null;
    }

    void a(MotionEvent r2, int r3, int r4) {
        float r0 = r2.getX(r4);
        float r5 = r2.getY(r4);
        float r1 = r0 - this.f35562c;
        this.f35564e = r1;
        this.f = r5 - this.f35563d;
        if ((r3 & 4) != 0) goto L6;
        this.f35564e = Math.max(0.0f, r1);
    L6:
        if ((r3 & 8) != 0) goto L9;
        this.f35564e = Math.min(0.0f, this.f35564e);
    L9:
        if ((r3 & 1) != 0) goto L12;
        this.f = Math.max(0.0f, this.f);
    L12:
        if ((r3 & 2) != 0) goto L15;
        this.f = Math.min(0.0f, this.f);
        return;
    }

    private int c(RecyclerView.v r6) {
        if (this.v != 2) goto L5;
        return 0;
    L5:
        int r0 = this.h.getMovementFlags(this.k, r6);
        int r2 = (this.h.convertToAbsoluteDirection(r0, ViewCompat.i(this.k)) & 65280) >> 8;
        if (r2 != 0) goto L8;
        return 0;
    L8:
        int r1 = (r0 & 65280) >> 8;
        if (Math.abs(this.f35564e) <= Math.abs(this.f)) goto L20;
        int r3 = b(r6, r2);
        if (r3 > 0) goto L13;
        int r5 = c(r6, r2);
        if (r5 <= 0) goto L30;
        return r5;
    L30:
        return 0;
    L13:
        if ((r1 & r3) == 0) goto L15;
        return r3;
    L15:
        return a.convertToRelativeDirection(r3, ViewCompat.i(this.k));
    L20:
        int r4 = c(r6, r2);
        if (r4 <= 0) goto L23;
        return r4;
    L23:
        int r7 = b(r6, r2);
        if (r7 <= 0) goto L30;
        if ((r1 & r7) == 0) goto L28;
        return r7;
    L28:
        return a.convertToRelativeDirection(r7, ViewCompat.i(this.k));
    }

    private int b(RecyclerView.v r9, int r10) {
        if ((r10 & 12) == 0) goto L29;
        int r2 = 8;
        if (this.f35564e <= 0.0f) goto L7;
        int r0 = 8;
    L8:
        VelocityTracker r4 = this.m;
        if (r4 != null) goto L11;
    L24:
        float r1 = this.k.getWidth() * this.h.getSwipeThreshold(r9);
        if ((r10 & r0) != 0) goto L27;
        return 0;
    L27:
        if (Math.abs(this.f35564e) <= r1) goto L32;
        return r0;
    L32:
        return 0;
    L11:
        if (this.g <= (-1)) goto L24;
        r4.computeCurrentVelocity(1000, this.h.getSwipeVelocityThreshold(this.s));
        float r5 = this.m.getXVelocity(this.g);
        float r6 = this.m.getYVelocity(this.g);
        if (r5 > 0.0f) goto L16;
        r2 = 4;
    L16:
        float r3 = Math.abs(r5);
        if ((r2 & r10) == 0) goto L24;
        if (r0 != r2) goto L24;
        if (r3 < this.h.getSwipeEscapeVelocity(this.r)) goto L24;
        if (r3 <= Math.abs(r6)) goto L24;
        return r2;
    L7:
        r0 = 4;
        goto L8
    L29:
        return 0;
    }

    private int c(RecyclerView.v r9, int r10) {
        if ((r10 & 3) == 0) goto L29;
        int r2 = 2;
        if (this.f <= 0.0f) goto L7;
        int r0 = 2;
    L8:
        VelocityTracker r4 = this.m;
        if (r4 != null) goto L11;
    L24:
        float r1 = this.k.getHeight() * this.h.getSwipeThreshold(r9);
        if ((r10 & r0) != 0) goto L27;
        return 0;
    L27:
        if (Math.abs(this.f) <= r1) goto L32;
        return r0;
    L32:
        return 0;
    L11:
        if (this.g <= (-1)) goto L24;
        r4.computeCurrentVelocity(1000, this.h.getSwipeVelocityThreshold(this.s));
        float r5 = this.m.getXVelocity(this.g);
        float r6 = this.m.getYVelocity(this.g);
        if (r6 > 0.0f) goto L16;
        r2 = 1;
    L16:
        float r3 = Math.abs(r6);
        if ((r2 & r10) == 0) goto L24;
        if (r2 != r0) goto L24;
        if (r3 < this.h.getSwipeEscapeVelocity(this.r)) goto L24;
        if (r3 <= Math.abs(r5)) goto L24;
        return r2;
    L7:
        r0 = 1;
        goto L8
    L29:
        return 0;
    }

    private void i() {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        return;
    L6:
        if (this.z != null) goto L8;
        this.z = new AnonymousClass5(this);
    L8:
        this.k.setChildDrawingOrderCallback(this.z);
    }

    void c(View r2) {
        if (r2 != this.n) goto L8;
        this.n = null;
        if (this.z == null) goto L9;
        this.k.setChildDrawingOrderCallback(null);
        return;
    L9:
        return;
    }
}
