package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R$dimen;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ItemTouchHelper extends RecyclerView.ItemDecoration implements RecyclerView.OnChildAttachStateChangeListener {
    public f A;
    public final RecyclerView.OnItemTouchListener B;
    public Rect C;
    public long D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f4110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f4111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView.ViewHolder f4112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f4113d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f4114e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f4115f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f4116g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f4117h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f4118i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f4119j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f4120k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f4121l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public e f4122m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4123n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f4124o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public List f4125p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f4126q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public RecyclerView f4127r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Runnable f4128s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public VelocityTracker f4129t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public List f4130u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public List f4131v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public RecyclerView.ChildDrawingOrderCallback f4132w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View f4133x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f4134y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public GestureDetectorCompat f4135z;

    public interface ViewDropHandler {
        void prepareForDrop(@NonNull View r10, @NonNull View r11, int r12, int r13);
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ItemTouchHelper f4136a;

        public a(ItemTouchHelper r10) {
            this.f4136a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            ItemTouchHelper r10 = this.f4136a;
            if (r10.f4112c != null) goto L5;
            return;
        L5:
            if (r10.t() == false) goto L12;
            ItemTouchHelper r11 = this.f4136a;
            RecyclerView.ViewHolder r12 = r11.f4112c;
            if (r12 == null) goto L9;
            r11.o(r12);
        L9:
            ItemTouchHelper r13 = this.f4136a;
            r13.f4127r.removeCallbacks(r13.f4128s);
            ViewCompat.h0(this.f4136a.f4127r, this);
            return;
        }
    }

    public class b implements RecyclerView.OnItemTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ItemTouchHelper f4137a;

        public b(ItemTouchHelper r10) {
            this.f4137a = r10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView r10, MotionEvent r11) {
            this.f4137a.f4135z.a(r11);
            int r12 = r11.getActionMasked();
            if (r12 != 0) goto L13;
            this.f4137a.f4121l = r11.getPointerId(0);
            this.f4137a.f4113d = r11.getX();
            this.f4137a.f4114e = r11.getY();
            this.f4137a.p();
            ItemTouchHelper r13 = this.f4137a;
            if (r13.f4112c != null) goto L22;
            g r14 = r13.h(r11);
            if (r14 == null) goto L22;
            ItemTouchHelper r15 = this.f4137a;
            r15.f4113d -= r14.f4155j;
            r15.f4114e -= r14.f4156k;
            r15.g(r14.f4150e, true);
            if (this.f4137a.f4110a.remove(r14.f4150e.itemView) == false) goto L11;
            ItemTouchHelper r16 = this.f4137a;
            r16.f4122m.clearView(r16.f4127r, r14.f4150e);
        L11:
            this.f4137a.u(r14.f4150e, r14.f4151f);
            ItemTouchHelper r17 = this.f4137a;
            r17.A(r11, r17.f4124o, 0);
        L22:
            VelocityTracker r18 = this.f4137a.f4129t;
            if (r18 == null) goto L26;
            r18.addMovement(r11);
        L26:
            if (this.f4137a.f4112c == null) goto L29;
            return true;
        L29:
            return false;
        L13:
            if (r12 == 3) goto L21;
            if (r12 == 1) goto L21;
            int r19 = this.f4137a.f4121l;
            if (r19 == (-1)) goto L22;
            int r20 = r11.findPointerIndex(r19);
            if (r20 < 0) goto L22;
            this.f4137a.d(r12, r11, r20);
        L21:
            ItemTouchHelper r21 = this.f4137a;
            r21.f4121l = -1;
            r21.u(null, 0);
            goto L22
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean r10) {
            if (r10 == true) goto L4;
            return;
        L4:
            this.f4137a.u(null, 0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView r10, MotionEvent r11) {
            this.f4137a.f4135z.a(r11);
            VelocityTracker r12 = this.f4137a.f4129t;
            if (r12 == null) goto L6;
            r12.addMovement(r11);
        L6:
            if (this.f4137a.f4121l != (-1)) goto L8;
            return;
        L8:
            int r13 = r11.getActionMasked();
            int r14 = r11.findPointerIndex(this.f4137a.f4121l);
            if (r14 < 0) goto L11;
            this.f4137a.d(r13, r11, r14);
        L11:
            ItemTouchHelper r15 = this.f4137a;
            RecyclerView.ViewHolder r16 = r15.f4112c;
            if (r16 != null) goto L14;
            return;
        L14:
            int r17 = 0;
            if (r13 != 1) goto L17;
        L33:
            this.f4137a.u(null, 0);
            this.f4137a.f4121l = -1;
            return;
        L17:
            if (r13 != 2) goto L19;
            if (r14 < 0) goto L37;
            r15.A(r11, r15.f4124o, r14);
            this.f4137a.o(r16);
            ItemTouchHelper r18 = this.f4137a;
            r18.f4127r.removeCallbacks(r18.f4128s);
            this.f4137a.f4128s.run();
            this.f4137a.f4127r.invalidate();
            return;
        L37:
            return;
        L19:
            if (r13 != 3) goto L21;
            VelocityTracker r19 = r15.f4129t;
            if (r19 == null) goto L33;
            r19.clear();
            goto L33
        L21:
            if (r13 != 6) goto L39;
            int r20 = r11.getActionIndex();
            int r21 = r11.getPointerId(r20);
            ItemTouchHelper r22 = this.f4137a;
            if (r21 != r22.f4121l) goto L35;
            if (r20 != 0) goto L27;
            r17 = 1;
        L27:
            r22.f4121l = r11.getPointerId(r17);
            ItemTouchHelper r23 = this.f4137a;
            r23.A(r11, r23.f4124o, r20);
            return;
        L35:
            return;
        }
    }

    public class c extends g {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ int f4138o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.ViewHolder f4139p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ ItemTouchHelper f4140q;

        public c(ItemTouchHelper r10, RecyclerView.ViewHolder r11, int r12, int r13, float r14, float r15, float r16, float r17, int r18, RecyclerView.ViewHolder r19) {
            this.f4140q = r10;
            this.f4138o = r18;
            this.f4139p = r19;
            super(r11, r12, r13, r14, r15, r16, r17);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.g, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            super.onAnimationEnd(r10);
            if (this.f4157l == false) goto L6;
            return;
        L6:
            if (this.f4138o > 0) goto L8;
            ItemTouchHelper r11 = this.f4140q;
            r11.f4122m.clearView(r11.f4127r, this.f4139p);
        L11:
            ItemTouchHelper r12 = this.f4140q;
            View r13 = r12.f4133x;
            View r14 = this.f4139p.itemView;
            if (r13 != r14) goto L15;
            r12.s(r14);
            return;
        L15:
            return;
        L8:
            this.f4140q.f4110a.add(this.f4139p.itemView);
            this.f4154i = true;
            int r15 = this.f4138o;
            if (r15 <= 0) goto L11;
            this.f4140q.q(this, r15);
            goto L11
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f4141a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f4142b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ItemTouchHelper f4143c;

        public d(ItemTouchHelper r10, g r11, int r12) {
            this.f4143c = r10;
            this.f4141a = r11;
            this.f4142b = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView r10 = this.f4143c.f4127r;
            if (r10 != null) goto L5;
            return;
        L5:
            if (r10.isAttachedToWindow() == false) goto L20;
            g r11 = this.f4141a;
            if (r11.f4157l == false) goto L9;
            return;
        L9:
            if (r11.f4150e.getAbsoluteAdapterPosition() == (-1)) goto L22;
            RecyclerView.ItemAnimator r12 = this.f4143c.f4127r.getItemAnimator();
            if (r12 == null) goto L15;
            if (r12.q(null) == false) goto L15;
        L17:
            this.f4143c.f4127r.post(this);
            return;
        L15:
            if (this.f4143c.m() == true) goto L17;
            this.f4143c.f4122m.onSwiped(this.f4141a.f4150e, this.f4142b);
            return;
        L22:
            return;
        }
    }

    public static abstract class e {
        private static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
        private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000;
        static final int RELATIVE_DIR_FLAGS = 3158064;
        private static final Interpolator sDragScrollInterpolator = null;
        private static final Interpolator sDragViewScrollCapInterpolator = null;
        private int mCachedMaxScrollSpeed;

        public class a implements Interpolator {
            public a() {
            }

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float r10) {
                return (((r10 * r10) * r10) * r10) * r10;
            }
        }

        public class b implements Interpolator {
            public b() {
            }

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float r10) {
                float r11 = r10 - 1.0f;
                return ((((r11 * r11) * r11) * r11) * r11) + 1.0f;
            }
        }

        static {
            sDragScrollInterpolator = new a();
            sDragViewScrollCapInterpolator = new b();
        }

        public e() {
            this.mCachedMaxScrollSpeed = -1;
        }

        public static int convertToRelativeDirection(int r10, int r11) {
            int r12 = r10 & ABS_HORIZONTAL_DIR_FLAGS;
            if (r12 != 0) goto L5;
            return r10;
        L5:
            int r13 = r10 & (~r12);
            if (r11 != 0) goto L10;
            int r14 = r12 << 2;
        L9:
            return r13 | r14;
        L10:
            int r15 = r12 << 1;
            r13 = r13 | ((-789517) & r15);
            r14 = (r15 & ABS_HORIZONTAL_DIR_FLAGS) << 2;
            goto L9
        }

        @NonNull
        public static ItemTouchUIUtil getDefaultUIUtil() {
            return androidx.recyclerview.widget.f.f4412a;
        }

        public static int makeFlag(int r10, int r11) {
            return r11 << (r10 * 8);
        }

        public static int makeMovementFlags(int r10, int r11) {
            int r12 = makeFlag(0, r11 | r10);
            int r13 = makeFlag(1, r11) | r12;
            return makeFlag(2, r10) | r13;
        }

        public final int a(RecyclerView r10) {
            if (this.mCachedMaxScrollSpeed != (-1)) goto L6;
            this.mCachedMaxScrollSpeed = r10.getResources().getDimensionPixelSize(R$dimen.item_touch_helper_max_drag_scroll_per_frame);
        L6:
            return this.mCachedMaxScrollSpeed;
        }

        public boolean canDropOver(@NonNull RecyclerView r10, @NonNull RecyclerView.ViewHolder r11, @NonNull RecyclerView.ViewHolder r12) {
            return true;
        }

        @SuppressLint({"UnknownNullness"})
        public RecyclerView.ViewHolder chooseDropTarget(@NonNull RecyclerView.ViewHolder r12, @NonNull List<RecyclerView.ViewHolder> r13, int r14, int r15) {
            int r11 = r12.itemView.getWidth() + r14;
            int r10 = r12.itemView.getHeight() + r15;
            int r16 = r14 - r12.itemView.getLeft();
            int r17 = r15 - r12.itemView.getTop();
            int r18 = r13.size();
            RecyclerView.ViewHolder r19 = null;
            int r20 = -1;
            int r21 = 0;
        L3:
            if (r21 >= r18) goto L38;
            RecyclerView.ViewHolder r22 = r13.get(r21);
            if (r16 <= 0) goto L13;
            int r23 = r22.itemView.getRight() - r11;
            if (r23 >= 0) goto L13;
            if (r22.itemView.getRight() <= r12.itemView.getRight()) goto L13;
            int r24 = Math.abs(r23);
            if (r24 <= r20) goto L13;
            r19 = r22;
            r20 = r24;
        L13:
            if (r16 >= 0) goto L21;
            int r25 = r22.itemView.getLeft() - r14;
            if (r25 <= 0) goto L21;
            if (r22.itemView.getLeft() >= r12.itemView.getLeft()) goto L21;
            int r26 = Math.abs(r25);
            if (r26 <= r20) goto L21;
            r19 = r22;
            r20 = r26;
        L21:
            if (r17 >= 0) goto L29;
            int r27 = r22.itemView.getTop() - r15;
            if (r27 <= 0) goto L29;
            if (r22.itemView.getTop() >= r12.itemView.getTop()) goto L29;
            int r28 = Math.abs(r27);
            if (r28 <= r20) goto L29;
            r19 = r22;
            r20 = r28;
        L29:
            if (r17 <= 0) goto L37;
            int r29 = r22.itemView.getBottom() - r10;
            if (r29 >= 0) goto L37;
            if (r22.itemView.getBottom() <= r12.itemView.getBottom()) goto L37;
            int r30 = Math.abs(r29);
            if (r30 <= r20) goto L37;
            r19 = r22;
            r20 = r30;
        L37:
            r21 = r21 + 1;
            goto L3
        L38:
            return r19;
        }

        public void clearView(RecyclerView r10, RecyclerView.ViewHolder r11) {
            androidx.recyclerview.widget.f.f4412a.clearView(r11.itemView);
        }

        public int convertToAbsoluteDirection(int r10, int r11) {
            int r12 = r10 & RELATIVE_DIR_FLAGS;
            if (r12 != 0) goto L5;
            return r10;
        L5:
            int r13 = r10 & (~r12);
            if (r11 != 0) goto L10;
            int r14 = r12 >> 2;
        L9:
            return r14 | r13;
        L10:
            int r15 = r12 >> 1;
            r13 = r13 | ((-3158065) & r15);
            r14 = (RELATIVE_DIR_FLAGS & r15) >> 2;
            goto L9
        }

        public final int getAbsoluteMovementFlags(RecyclerView r10, RecyclerView.ViewHolder r11) {
            return convertToAbsoluteDirection(getMovementFlags(r10, r11), ViewCompat.A(r10));
        }

        public long getAnimationDuration(@NonNull RecyclerView r10, int r11, float r12, float r13) {
            RecyclerView.ItemAnimator r14 = r10.getItemAnimator();
            if (r14 != null) goto L8;
            if (r11 != 8) goto L6;
            return 200;
        L6:
            return 250;
        L8:
            if (r11 != 8) goto L11;
            return r14.n();
        L11:
            return r14.o();
        }

        public int getBoundingBoxMargin() {
            return 0;
        }

        public abstract float getMoveThreshold(RecyclerView.ViewHolder r10);

        public abstract int getMovementFlags(RecyclerView r10, RecyclerView.ViewHolder r11);

        public float getSwipeEscapeVelocity(float r10) {
            return r10;
        }

        public abstract float getSwipeThreshold(RecyclerView.ViewHolder r10);

        public float getSwipeVelocityThreshold(float r10) {
            return r10;
        }

        public boolean hasDragFlag(RecyclerView r10, RecyclerView.ViewHolder r11) {
            if ((getAbsoluteMovementFlags(r10, r11) & 16711680) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasSwipeFlag(RecyclerView r10, RecyclerView.ViewHolder r11) {
            if ((getAbsoluteMovementFlags(r10, r11) & 65280) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public int interpolateOutOfBoundsScroll(@NonNull RecyclerView r10, int r11, int r12, int r13, long r14) {
            int r15 = a(r10);
            int r16 = Math.abs(r12);
            float r17 = 1.0f;
            int r18 = (int) ((((int) Math.signum(r12)) * r15) * sDragViewScrollCapInterpolator.getInterpolation(Math.min(1.0f, (r16 * 1.0f) / r11)));
            if (r14 > 2000) goto L6;
            r17 = r14 / 2000.0f;
        L6:
            int r19 = (int) (r18 * sDragScrollInterpolator.getInterpolation(r17));
            if (r19 != 0) goto L12;
            if (r12 <= 0) goto L10;
            return 1;
        L10:
            return -1;
        L12:
            return r19;
        }

        public abstract boolean isItemViewSwipeEnabled();

        public abstract boolean isLongPressDragEnabled();

        public void onChildDraw(@NonNull Canvas r10, @NonNull RecyclerView r11, @NonNull RecyclerView.ViewHolder r12, float r13, float r14, int r15, boolean r16) {
            androidx.recyclerview.widget.f.f4412a.onDraw(r10, r11, r12.itemView, r13, r14, r15, r16);
        }

        public void onChildDrawOver(Canvas r10, RecyclerView r11, RecyclerView.ViewHolder r12, float r13, float r14, int r15, boolean r16) {
            androidx.recyclerview.widget.f.f4412a.onDrawOver(r10, r11, r12.itemView, r13, r14, r15, r16);
        }

        public void onDraw(Canvas r14, RecyclerView r15, RecyclerView.ViewHolder r16, List<g> r17, int r18, float r19, float r20) {
            int r10 = r17.size();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L5;
            g r12 = r17.get(r11);
            r12.e();
            int r13 = r14.save();
            onChildDraw(r14, r15, r12.f4150e, r12.f4155j, r12.f4156k, r12.f4151f, false);
            r14.restoreToCount(r13);
            r11 = r11 + 1;
            goto L3
        L5:
            if (r16 == null) goto L9;
            int r21 = r14.save();
            onChildDraw(r14, r15, r16, r19, r20, r18, true);
            r14.restoreToCount(r21);
            return;
        }

        public void onDrawOver(Canvas r15, RecyclerView r16, RecyclerView.ViewHolder r17, List<g> r18, int r19, float r20, float r21) {
            int r10 = r18.size();
            boolean r11 = false;
            int r12 = 0;
        L3:
            if (r12 >= r10) goto L5;
            g r13 = r18.get(r12);
            int r14 = r15.save();
            onChildDrawOver(r15, r16, r13.f4150e, r13.f4155j, r13.f4156k, r13.f4151f, false);
            r15.restoreToCount(r14);
            r12 = r12 + 1;
            goto L3
        L5:
            if (r17 == null) goto L7;
            int r110 = r15.save();
            onChildDrawOver(r15, r16, r17, r20, r21, r19, true);
            r15.restoreToCount(r110);
        L7:
            int r111 = r10 - 1;
        L8:
            if (r111 < 0) goto L17;
            g r22 = r18.get(r111);
            boolean r23 = r22.f4158m;
            if (r23 == true) goto L12;
        L14:
            if (r23 == true) goto L16;
            r11 = true;
        L16:
            r111 = r111 - 1;
            goto L8
        L12:
            if (r22.f4154i == true) goto L14;
            r18.remove(r111);
            goto L16
        L17:
            if (r11 == false) goto L25;
            r16.invalidate();
            return;
        }

        public abstract boolean onMove(RecyclerView r10, RecyclerView.ViewHolder r11, RecyclerView.ViewHolder r12);

        /* JADX WARN: Multi-variable type inference failed */
        public void onMoved(RecyclerView r10, RecyclerView.ViewHolder r11, int r12, RecyclerView.ViewHolder r13, int r14, int r15, int r16) {
            RecyclerView.LayoutManager r17 = r10.getLayoutManager();
            if ((r17 instanceof ViewDropHandler) == false) goto L7;
            ((ViewDropHandler) r17).prepareForDrop(r11.itemView, r13.itemView, r15, r16);
            return;
        L7:
            if (r17.canScrollHorizontally() == false) goto L15;
            if (r17.getDecoratedLeft(r13.itemView) > r10.getPaddingLeft()) goto L12;
            r10.scrollToPosition(r14);
        L12:
            if (r17.getDecoratedRight(r13.itemView) < (r10.getWidth() - r10.getPaddingRight())) goto L15;
            r10.scrollToPosition(r14);
        L15:
            if (r17.canScrollVertically() == true) goto L17;
            return;
        L17:
            if (r17.getDecoratedTop(r13.itemView) > r10.getPaddingTop()) goto L20;
            r10.scrollToPosition(r14);
        L20:
            if (r17.getDecoratedBottom(r13.itemView) < (r10.getHeight() - r10.getPaddingBottom())) goto L24;
            r10.scrollToPosition(r14);
            return;
        }

        public void onSelectedChanged(RecyclerView.ViewHolder r10, int r11) {
            if (r10 == null) goto L5;
            androidx.recyclerview.widget.f.f4412a.onSelected(r10.itemView);
            return;
        }

        public abstract void onSwiped(RecyclerView.ViewHolder r10, int r11);
    }

    public class f extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f4144a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ItemTouchHelper f4145b;

        public f(ItemTouchHelper r10) {
            this.f4145b = r10;
            this.f4144a = true;
        }

        public void a() {
            this.f4144a = false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent r10) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent r10) {
            if (this.f4144a == true) goto L5;
            return;
        L5:
            View r11 = this.f4145b.i(r10);
            if (r11 == null) goto L18;
            RecyclerView.ViewHolder r12 = this.f4145b.f4127r.getChildViewHolder(r11);
            if (r12 == null) goto L19;
            ItemTouchHelper r13 = this.f4145b;
            if (r13.f4122m.hasDragFlag(r13.f4127r, r12) == true) goto L12;
            return;
        L12:
            int r14 = r10.getPointerId(0);
            int r15 = this.f4145b.f4121l;
            if (r14 != r15) goto L20;
            int r16 = r10.findPointerIndex(r15);
            float r17 = r10.getX(r16);
            float r18 = r10.getY(r16);
            ItemTouchHelper r19 = this.f4145b;
            r19.f4113d = r17;
            r19.f4114e = r18;
            r19.f4118i = 0.0f;
            r19.f4117h = 0.0f;
            if (r19.f4122m.isLongPressDragEnabled() == false) goto L21;
            this.f4145b.u(r12, 2);
            return;
        L21:
            return;
        L20:
            return;
        L19:
            return;
        }
    }

    public static class g implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f4146a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f4147b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f4148c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f4149d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final RecyclerView.ViewHolder f4150e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f4151f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final ValueAnimator f4152g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f4153h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f4154i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f4155j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f4156k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f4157l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f4158m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f4159n;

        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f4160a;

            public a(g r10) {
                this.f4160a = r10;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator r10) {
                this.f4160a.c(r10.getAnimatedFraction());
            }
        }

        public g(RecyclerView.ViewHolder r10, int r11, int r12, float r13, float r14, float r15, float r16) {
            this.f4157l = false;
            this.f4158m = false;
            this.f4151f = r12;
            this.f4153h = r11;
            this.f4150e = r10;
            this.f4146a = r13;
            this.f4147b = r14;
            this.f4148c = r15;
            this.f4149d = r16;
            ValueAnimator r17 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.f4152g = r17;
            r17.addUpdateListener(new a(this));
            r17.setTarget(r10.itemView);
            r17.addListener(this);
            c(0.0f);
        }

        public void a() {
            this.f4152g.cancel();
        }

        public void b(long r10) {
            this.f4152g.setDuration(r10);
        }

        public void c(float r10) {
            this.f4159n = r10;
        }

        public void d() {
            this.f4150e.setIsRecyclable(false);
            this.f4152g.start();
        }

        public void e() {
            float r10 = this.f4146a;
            float r11 = this.f4148c;
            if (r10 != r11) goto L5;
            this.f4155j = this.f4150e.itemView.getTranslationX();
        L6:
            float r12 = this.f4147b;
            float r13 = this.f4149d;
            if (r12 != r13) goto L9;
            this.f4156k = this.f4150e.itemView.getTranslationY();
            return;
        L9:
            this.f4156k = r12 + (this.f4159n * (r13 - r12));
            return;
        L5:
            this.f4155j = r10 + (this.f4159n * (r11 - r10));
            goto L6
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            c(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            if (this.f4158m == true) goto L5;
            this.f4150e.setIsRecyclable(true);
        L5:
            this.f4158m = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r10) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
        }
    }

    public ItemTouchHelper(e r10) {
        this.f4110a = new ArrayList();
        this.f4111b = new float[2];
        this.f4112c = null;
        this.f4121l = -1;
        this.f4123n = 0;
        this.f4125p = new ArrayList();
        this.f4128s = new a(this);
        this.f4132w = null;
        this.f4133x = null;
        this.f4134y = -1;
        this.B = new b(this);
        this.f4122m = r10;
    }

    private void f() {
        this.f4127r.removeItemDecoration(this);
        this.f4127r.removeOnItemTouchListener(this.B);
        this.f4127r.removeOnChildAttachStateChangeListener(this);
        int r10 = this.f4125p.size() - 1;
    L3:
        if (r10 < 0) goto L5;
        g r11 = (g) this.f4125p.get(0);
        r11.a();
        this.f4122m.clearView(this.f4127r, r11.f4150e);
        r10 = r10 - 1;
        goto L3
    L5:
        this.f4125p.clear();
        this.f4133x = null;
        this.f4134y = -1;
        r();
        y();
    }

    public static boolean n(View r10, float r11, float r12, float r13, float r14) {
        if (r11 >= r13) goto L5;
    L11:
        return false;
    L5:
        if (r11 > (r13 + r10.getWidth())) goto L11;
        if (r12 < r14) goto L11;
        if (r12 > (r14 + r10.getHeight())) goto L11;
        return true;
    }

    private void v() {
        this.f4126q = ViewConfiguration.get(this.f4127r.getContext()).getScaledTouchSlop();
        this.f4127r.addItemDecoration(this);
        this.f4127r.addOnItemTouchListener(this.B);
        this.f4127r.addOnChildAttachStateChangeListener(this);
        x();
    }

    public void A(MotionEvent r10, int r11, int r12) {
        float r13 = r10.getX(r12);
        float r14 = r10.getY(r12);
        float r15 = r13 - this.f4113d;
        this.f4117h = r15;
        this.f4118i = r14 - this.f4114e;
        if ((r11 & 4) != 0) goto L6;
        this.f4117h = Math.max(0.0f, r15);
    L6:
        if ((r11 & 8) != 0) goto L9;
        this.f4117h = Math.min(0.0f, this.f4117h);
    L9:
        if ((r11 & 1) != 0) goto L12;
        this.f4118i = Math.max(0.0f, this.f4118i);
    L12:
        if ((r11 & 2) != 0) goto L15;
        this.f4118i = Math.min(0.0f, this.f4118i);
        return;
    }

    public final void a() {
    }

    public void b(RecyclerView r10) {
        RecyclerView r11 = this.f4127r;
        if (r11 != r10) goto L5;
        return;
    L5:
        if (r11 == null) goto L7;
        f();
    L7:
        this.f4127r = r10;
        if (r10 == null) goto L11;
        Resources r12 = r10.getResources();
        this.f4115f = r12.getDimension(R$dimen.item_touch_helper_swipe_escape_velocity);
        this.f4116g = r12.getDimension(R$dimen.item_touch_helper_swipe_escape_max_velocity);
        v();
        return;
    }

    public final int c(RecyclerView.ViewHolder r10, int r11) {
        if ((r11 & 12) == 0) goto L28;
        int r12 = 4;
        if (this.f4117h <= 0.0f) goto L7;
        int r13 = 8;
    L8:
        VelocityTracker r14 = this.f4129t;
        if (r14 != null) goto L11;
    L23:
        float r15 = this.f4127r.getWidth() * this.f4122m.getSwipeThreshold(r10);
        if ((r11 & r13) != 0) goto L26;
        return 0;
    L26:
        if (Math.abs(this.f4117h) <= r15) goto L31;
        return r13;
    L31:
        return 0;
    L11:
        if (this.f4121l <= (-1)) goto L23;
        r14.computeCurrentVelocity(1000, this.f4122m.getSwipeVelocityThreshold(this.f4116g));
        float r16 = this.f4129t.getXVelocity(this.f4121l);
        float r17 = this.f4129t.getYVelocity(this.f4121l);
        if (r16 <= 0.0f) goto L15;
        r12 = 8;
    L15:
        float r18 = Math.abs(r16);
        if ((r12 & r11) == 0) goto L23;
        if (r13 != r12) goto L23;
        if (r18 < this.f4122m.getSwipeEscapeVelocity(this.f4115f)) goto L23;
        if (r18 <= Math.abs(r17)) goto L23;
        return r12;
    L7:
        r13 = 4;
        goto L8
    L28:
        return 0;
    }

    public void d(int r10, MotionEvent r11, int r12) {
        if (this.f4112c == null) goto L5;
        return;
    L5:
        if (r10 == 2) goto L7;
        return;
    L7:
        if (this.f4123n != 2) goto L9;
        return;
    L9:
        if (this.f4122m.isItemViewSwipeEnabled() == true) goto L12;
        return;
    L12:
        if (this.f4127r.getScrollState() != 1) goto L14;
        return;
    L14:
        RecyclerView.ViewHolder r13 = k(r11);
        if (r13 != null) goto L17;
        return;
    L17:
        int r14 = (this.f4122m.getAbsoluteMovementFlags(this.f4127r, r13) & 65280) >> 8;
        if (r14 != 0) goto L20;
        return;
    L20:
        float r15 = r11.getX(r12);
        float r16 = r11.getY(r12);
        float r17 = r15 - this.f4113d;
        float r18 = r16 - this.f4114e;
        float r19 = Math.abs(r17);
        float r20 = Math.abs(r18);
        int r21 = this.f4126q;
        if (r19 >= r21) goto L26;
        if (r20 >= r21) goto L26;
        return;
    L26:
        if (r19 <= r20) goto L38;
        if (r17 >= 0.0f) goto L33;
        if ((r14 & 4) != 0) goto L33;
        return;
    L33:
        if (r17 > 0.0f) goto L35;
    L47:
        this.f4118i = 0.0f;
        this.f4117h = 0.0f;
        this.f4121l = r11.getPointerId(0);
        u(r13, 1);
        return;
    L35:
        if ((r14 & 8) != 0) goto L47;
        return;
    L38:
        if (r18 >= 0.0f) goto L43;
        if ((r14 & 1) != 0) goto L43;
        return;
    L43:
        if (r18 <= 0.0f) goto L47;
        if ((r14 & 2) != 0) goto L47;
    }

    public final int e(RecyclerView.ViewHolder r10, int r11) {
        if ((r11 & 3) == 0) goto L28;
        int r12 = 1;
        if (this.f4118i <= 0.0f) goto L7;
        int r13 = 2;
    L8:
        VelocityTracker r14 = this.f4129t;
        if (r14 != null) goto L11;
    L23:
        float r15 = this.f4127r.getHeight() * this.f4122m.getSwipeThreshold(r10);
        if ((r11 & r13) != 0) goto L26;
        return 0;
    L26:
        if (Math.abs(this.f4118i) <= r15) goto L31;
        return r13;
    L31:
        return 0;
    L11:
        if (this.f4121l <= (-1)) goto L23;
        r14.computeCurrentVelocity(1000, this.f4122m.getSwipeVelocityThreshold(this.f4116g));
        float r16 = this.f4129t.getXVelocity(this.f4121l);
        float r17 = this.f4129t.getYVelocity(this.f4121l);
        if (r17 <= 0.0f) goto L15;
        r12 = 2;
    L15:
        float r18 = Math.abs(r17);
        if ((r12 & r11) == 0) goto L23;
        if (r12 != r13) goto L23;
        if (r18 < this.f4122m.getSwipeEscapeVelocity(this.f4115f)) goto L23;
        if (r18 <= Math.abs(r16)) goto L23;
        return r12;
    L7:
        r13 = 1;
        goto L8
    L28:
        return 0;
    }

    public void g(RecyclerView.ViewHolder r10, boolean r11) {
        int r12 = this.f4125p.size() - 1;
    L3:
        if (r12 < 0) goto L12;
        g r13 = (g) this.f4125p.get(r12);
        if (r13.f4150e == r10) goto L6;
        r12 = r12 - 1;
        goto L3
    L6:
        r13.f4157l |= r11;
        if (r13.f4158m == true) goto L9;
        r13.a();
    L9:
        this.f4125p.remove(r12);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect r10, View r11, RecyclerView r12, RecyclerView.State r13) {
        r10.setEmpty();
    }

    public g h(MotionEvent r10) {
        if (this.f4125p.isEmpty() == false) goto L5;
        return null;
    L5:
        View r11 = i(r10);
        int r12 = this.f4125p.size() - 1;
    L6:
        if (r12 < 0) goto L11;
        g r13 = (g) this.f4125p.get(r12);
        if (r13.f4150e.itemView == r11) goto L9;
        r12 = r12 - 1;
        goto L6
    L9:
        return r13;
    L11:
        return null;
    }

    public View i(MotionEvent r10) {
        float r11 = r10.getX();
        float r12 = r10.getY();
        RecyclerView.ViewHolder r13 = this.f4112c;
        if (r13 == null) goto L7;
        View r14 = r13.itemView;
        if (n(r14, r11, r12, this.f4119j + this.f4117h, this.f4120k + this.f4118i) == false) goto L7;
        return r14;
    L7:
        int r15 = this.f4125p.size() - 1;
    L8:
        if (r15 < 0) goto L14;
        g r16 = (g) this.f4125p.get(r15);
        View r17 = r16.f4150e.itemView;
        if (n(r17, r11, r12, r16.f4155j, r16.f4156k) == true) goto L11;
        r15 = r15 - 1;
        goto L8
    L11:
        return r17;
    L14:
        return this.f4127r.findChildViewUnder(r11, r12);
    }

    public final List j(RecyclerView.ViewHolder r17) {
        RecyclerView.ViewHolder r10 = r17;
        List r11 = this.f4130u;
        if (r11 != null) goto L5;
        this.f4130u = new ArrayList();
        this.f4131v = new ArrayList();
    L6:
        int r12 = this.f4122m.getBoundingBoxMargin();
        int r13 = Math.round(this.f4119j + this.f4117h) - r12;
        int r14 = Math.round(this.f4120k + this.f4118i) - r12;
        int r15 = r12 * 2;
        int r16 = (r10.itemView.getWidth() + r13) + r15;
        int r18 = (r10.itemView.getHeight() + r14) + r15;
        int r19 = (r13 + r16) / 2;
        int r20 = (r14 + r18) / 2;
        RecyclerView.LayoutManager r21 = this.f4127r.getLayoutManager();
        int r22 = r21.getChildCount();
        int r110 = 0;
    L7:
        if (r110 >= r22) goto L30;
        View r111 = r21.getChildAt(r110);
        if (r111 == r10.itemView) goto L28;
        if (r111.getBottom() < r14) goto L28;
        if (r111.getTop() > r18) goto L28;
        if (r111.getRight() < r13) goto L28;
        if (r111.getLeft() > r16) goto L28;
        RecyclerView.ViewHolder r112 = this.f4127r.getChildViewHolder(r111);
        if (this.f4122m.canDropOver(this.f4127r, this.f4112c, r112) == false) goto L28;
        int r113 = Math.abs(r19 - ((r111.getLeft() + r111.getRight()) / 2));
        int r114 = Math.abs(r20 - ((r111.getTop() + r111.getBottom()) / 2));
        int r115 = (r113 * r113) + (r114 * r114);
        int r116 = this.f4130u.size();
        int r117 = 0;
        int r118 = 0;
    L23:
        if (r117 >= r116) goto L27;
        if (r115 <= ((Integer) this.f4131v.get(r117)).intValue()) goto L27;
        r118 = r118 + 1;
        r117 = r117 + 1;
    L27:
        this.f4130u.add(r118, r112);
        this.f4131v.add(r118, Integer.valueOf(r115));
    L28:
        r110 = r110 + 1;
        r10 = r17;
        goto L7
    L30:
        return this.f4130u;
    L5:
        r11.clear();
        this.f4131v.clear();
        goto L6
    }

    public final RecyclerView.ViewHolder k(MotionEvent r10) {
        RecyclerView.LayoutManager r11 = this.f4127r.getLayoutManager();
        int r12 = this.f4121l;
        if (r12 != (-1)) goto L5;
        return null;
    L5:
        int r13 = r10.findPointerIndex(r12);
        float r14 = r10.getX(r13) - this.f4113d;
        float r15 = r10.getY(r13) - this.f4114e;
        float r16 = Math.abs(r14);
        float r17 = Math.abs(r15);
        int r18 = this.f4126q;
        if (r16 >= r18) goto L11;
        if (r17 >= r18) goto L11;
        return null;
    L11:
        if (r16 <= r17) goto L16;
        if (r11.canScrollHorizontally() == false) goto L16;
        return null;
    L16:
        if (r17 > r16) goto L18;
    L20:
        View r19 = i(r10);
        if (r19 != null) goto L24;
        return null;
    L24:
        return this.f4127r.getChildViewHolder(r19);
    L18:
        if (r11.canScrollVertically() == false) goto L20;
        return null;
    }

    public final void l(float[] r10) {
        if ((this.f4124o & 12) == 0) goto L5;
        r10[0] = (this.f4119j + this.f4117h) - this.f4112c.itemView.getLeft();
    L7:
        if ((this.f4124o & 3) == 0) goto L9;
        r10[1] = (this.f4120k + this.f4118i) - this.f4112c.itemView.getTop();
        return;
    L9:
        r10[1] = this.f4112c.itemView.getTranslationY();
        return;
    L5:
        r10[0] = this.f4112c.itemView.getTranslationX();
        goto L7
    }

    public boolean m() {
        int r10 = this.f4125p.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L9;
        if (((g) this.f4125p.get(r11)).f4158m == false) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public void o(RecyclerView.ViewHolder r11) {
        if (this.f4127r.isLayoutRequested() == false) goto L6;
        return;
    L6:
        if (this.f4123n == 2) goto L8;
        return;
    L8:
        float r10 = this.f4122m.getMoveThreshold(r11);
        int r12 = (int) (this.f4119j + this.f4117h);
        int r13 = (int) (this.f4120k + this.f4118i);
        if (Math.abs(r13 - r11.itemView.getTop()) < (r11.itemView.getHeight() * r10)) goto L11;
    L13:
        List<RecyclerView.ViewHolder> r14 = j(r11);
        if (r14.size() != 0) goto L16;
        return;
    L16:
        RecyclerView.ViewHolder r15 = this.f4122m.chooseDropTarget(r11, r14, r12, r13);
        if (r15 != null) goto L20;
        this.f4130u.clear();
        this.f4131v.clear();
        return;
    L20:
        int r16 = r15.getAbsoluteAdapterPosition();
        int r17 = r11.getAbsoluteAdapterPosition();
        if (this.f4122m.onMove(this.f4127r, r11, r15) == false) goto L24;
        this.f4122m.onMoved(this.f4127r, r11, r17, r15, r16, r12, r13);
        return;
    L24:
        return;
    L11:
        if (Math.abs(r12 - r11.itemView.getLeft()) >= (r11.itemView.getWidth() * r10)) goto L13;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewAttachedToWindow(View r10) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewDetachedFromWindow(View r10) {
        s(r10);
        RecyclerView.ViewHolder r11 = this.f4127r.getChildViewHolder(r10);
        if (r11 != null) goto L5;
        return;
    L5:
        RecyclerView.ViewHolder r12 = this.f4112c;
        if (r12 == null) goto L9;
        if (r11 != r12) goto L9;
        u(null, 0);
        return;
    L9:
        g(r11, false);
        if (this.f4110a.remove(r11.itemView) == false) goto L14;
        this.f4122m.clearView(this.f4127r, r11);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas r10, RecyclerView r11, RecyclerView.State r12) {
        this.f4134y = -1;
        if (this.f4112c == null) goto L5;
        l(this.f4111b);
        float[] r13 = this.f4111b;
        float r14 = r13[0];
        float r15 = r13[1];
        float r16 = r14;
    L6:
        this.f4122m.onDraw(r10, r11, this.f4112c, this.f4125p, this.f4123n, r16, r15);
        return;
    L5:
        r16 = 0.0f;
        r15 = 0.0f;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas r10, RecyclerView r11, RecyclerView.State r12) {
        if (this.f4112c == null) goto L5;
        l(this.f4111b);
        float[] r13 = this.f4111b;
        float r14 = r13[0];
        float r15 = r13[1];
        float r16 = r14;
    L6:
        this.f4122m.onDrawOver(r10, r11, this.f4112c, this.f4125p, this.f4123n, r16, r15);
        return;
    L5:
        r16 = 0.0f;
        r15 = 0.0f;
        goto L6
    }

    public void p() {
        VelocityTracker r10 = this.f4129t;
        if (r10 == null) goto L5;
        r10.recycle();
    L5:
        this.f4129t = VelocityTracker.obtain();
    }

    public void q(g r10, int r11) {
        this.f4127r.post(new d(this, r10, r11));
    }

    public final void r() {
        VelocityTracker r10 = this.f4129t;
        if (r10 == null) goto L6;
        r10.recycle();
        this.f4129t = null;
        return;
    }

    public void s(View r10) {
        if (r10 != this.f4133x) goto L8;
        this.f4133x = null;
        if (this.f4132w == null) goto L9;
        this.f4127r.setChildDrawingOrderCallback(null);
        return;
    L9:
        return;
    }

    public boolean t() {
        if (this.f4112c != null) goto L6;
        this.D = Long.MIN_VALUE;
        return false;
    L6:
        long r10 = System.currentTimeMillis();
        long r11 = this.D;
        if (r11 != Long.MIN_VALUE) goto L9;
        long r12 = 0;
    L10:
        RecyclerView.LayoutManager r13 = this.f4127r.getLayoutManager();
        if (this.C != null) goto L13;
        this.C = new Rect();
    L13:
        r13.calculateItemDecorationsForChild(this.f4112c.itemView, this.C);
        if (r13.canScrollHorizontally() == false) goto L24;
        int r14 = (int) (this.f4119j + this.f4117h);
        int r15 = (r14 - this.C.left) - this.f4127r.getPaddingLeft();
        float r16 = this.f4117h;
        if (r16 >= 0.0f) goto L20;
        if (r15 >= 0) goto L20;
        int r17 = r15;
    L26:
        if (r13.canScrollVertically() == false) goto L36;
        int r18 = (int) (this.f4120k + this.f4118i);
        int r19 = (r18 - this.C.top) - this.f4127r.getPaddingTop();
        float r110 = this.f4118i;
        if (r110 >= 0.0f) goto L32;
        if (r19 >= 0) goto L32;
        int r20 = r19;
    L37:
        if (r17 == 0) goto L39;
        r17 = this.f4122m.interpolateOutOfBoundsScroll(this.f4127r, this.f4112c.itemView.getWidth(), r17, this.f4127r.getWidth(), r12);
    L39:
        int r111 = r17;
        if (r20 == 0) goto L42;
        int r112 = r111;
        r20 = this.f4122m.interpolateOutOfBoundsScroll(this.f4127r, this.f4112c.itemView.getHeight(), r20, this.f4127r.getHeight(), r12);
    L43:
        if (r112 != 0) goto L49;
        if (r20 != 0) goto L49;
        this.D = Long.MIN_VALUE;
        return false;
    L49:
        if (this.D != Long.MIN_VALUE) goto L51;
        this.D = r10;
    L51:
        this.f4127r.scrollBy(r112, r20);
        return true;
    L42:
        r112 = r111;
    L32:
        if (r110 <= 0.0f) goto L36;
        r20 = ((r18 + this.f4112c.itemView.getHeight()) + this.C.bottom) - (this.f4127r.getHeight() - this.f4127r.getPaddingBottom());
        if (r20 > 0) goto L37;
    L36:
        r20 = 0;
    L20:
        if (r16 <= 0.0f) goto L24;
        int r21 = ((r14 + this.f4112c.itemView.getWidth()) + this.C.right) - (this.f4127r.getWidth() - this.f4127r.getPaddingRight());
        if (r21 <= 0) goto L24;
        r17 = r21;
    L24:
        r17 = 0;
        goto L26
    L9:
        r12 = r10 - r11;
        goto L10
    }

    public void u(RecyclerView.ViewHolder r24, int r25) {
        if (r24 == this.f4112c) goto L5;
    L7:
        this.D = Long.MIN_VALUE;
        int r10 = this.f4123n;
        g(r24, true);
        this.f4123n = r25;
        if (r25 != 2) goto L13;
        if (r24 == null) goto L12;
        this.f4133x = r24.itemView;
        a();
        goto L13
    L12:
        throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
    L13:
        int r16 = (1 << ((r25 * 8) + 8)) - 1;
        RecyclerView.ViewHolder r11 = this.f4112c;
        if (r11 != null) goto L16;
        boolean r12 = false;
    L41:
        if (r24 == null) goto L45;
        this.f4124o = (this.f4122m.getAbsoluteMovementFlags(this.f4127r, r24) & r16) >> (this.f4123n * 8);
        this.f4119j = r24.itemView.getLeft();
        this.f4120k = r24.itemView.getTop();
        this.f4112c = r24;
        if (r25 != 2) goto L45;
        boolean r13 = false;
        r24.itemView.performHapticFeedback(0);
    L46:
        ViewParent r14 = this.f4127r.getParent();
        if (r14 != null) goto L49;
    L53:
        if (r12 == true) goto L55;
        this.f4127r.getLayoutManager().requestSimpleAnimationsInNextLayout();
    L55:
        this.f4122m.onSelectedChanged(this.f4112c, this.f4123n);
        this.f4127r.invalidate();
        return;
    L49:
        if (this.f4112c == null) goto L51;
        boolean r15 = true;
    L52:
        r14.requestDisallowInterceptTouchEvent(r15);
        goto L53
    L51:
        r15 = r13;
    L45:
        r13 = false;
        goto L46
    L16:
        if (r11.itemView.getParent() == null) goto L38;
        if (r10 != 2) goto L19;
        int r17 = 0;
    L20:
        r();
        if (r17 == 1) goto L31;
        if (r17 == 2) goto L31;
        if (r17 == 4) goto L30;
        if (r17 == 8) goto L30;
        if (r17 == 16) goto L30;
        if (r17 == 32) goto L30;
        float r18 = 0.0f;
        float r19 = 0.0f;
    L32:
        if (r10 != 2) goto L34;
        int r20 = 8;
    L37:
        l(this.f4111b);
        float[] r21 = this.f4111b;
        float r110 = r21[0];
        float r22 = r21[1];
        c r23 = new c(this, r11, r20, r10, r110, r22, r18, r19, r17, r11);
        r23.b(this.f4122m.getAnimationDuration(this.f4127r, r20, r18 - r110, r19 - r22));
        this.f4125p.add(r23);
        r23.d();
        r12 = true;
    L39:
        this.f4112c = null;
        goto L41
    L34:
        if (r17 <= 0) goto L36;
        r20 = 2;
        goto L37
    L36:
        r20 = 4;
    L30:
        r19 = 0.0f;
        r18 = Math.signum(this.f4117h) * this.f4127r.getWidth();
    L31:
        r18 = 0.0f;
        r19 = Math.signum(this.f4118i) * this.f4127r.getHeight();
        goto L32
    L19:
        r17 = z(r11);
        goto L20
    L38:
        s(r11.itemView);
        this.f4122m.clearView(this.f4127r, r11);
        r12 = false;
        goto L39
    L5:
        if (r25 != this.f4123n) goto L7;
    }

    public void w(RecyclerView.ViewHolder r10) {
        if (this.f4122m.hasDragFlag(this.f4127r, r10) == true) goto L7;
        Log.e("ItemTouchHelper", "Start drag has been called but dragging is not enabled");
        return;
    L7:
        if (r10.itemView.getParent() == this.f4127r) goto L10;
        Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
        return;
    L10:
        p();
        this.f4118i = 0.0f;
        this.f4117h = 0.0f;
        u(r10, 2);
    }

    public final void x() {
        this.A = new f(this);
        this.f4135z = new GestureDetectorCompat(this.f4127r.getContext(), this.A);
    }

    public final void y() {
        f r10 = this.A;
        if (r10 == null) goto L6;
        r10.a();
        this.A = null;
    L6:
        if (this.f4135z == null) goto L9;
        this.f4135z = null;
        return;
    }

    public final int z(RecyclerView.ViewHolder r10) {
        if (this.f4123n != 2) goto L5;
        return 0;
    L5:
        int r11 = this.f4122m.getMovementFlags(this.f4127r, r10);
        int r12 = (this.f4122m.convertToAbsoluteDirection(r11, ViewCompat.A(this.f4127r)) & 65280) >> 8;
        if (r12 != 0) goto L8;
        return 0;
    L8:
        int r13 = (r11 & 65280) >> 8;
        if (Math.abs(this.f4117h) <= Math.abs(this.f4118i)) goto L20;
        int r14 = c(r10, r12);
        if (r14 > 0) goto L13;
        int r15 = e(r10, r12);
        if (r15 <= 0) goto L30;
        return r15;
    L30:
        return 0;
    L13:
        if ((r13 & r14) == 0) goto L15;
        return r14;
    L15:
        return e.convertToRelativeDirection(r14, ViewCompat.A(this.f4127r));
    L20:
        int r16 = e(r10, r12);
        if (r16 <= 0) goto L23;
        return r16;
    L23:
        int r17 = c(r10, r12);
        if (r17 <= 0) goto L30;
        if ((r13 & r17) == 0) goto L28;
        return r17;
    L28:
        return e.convertToRelativeDirection(r17, ViewCompat.A(this.f4127r));
    }
}
