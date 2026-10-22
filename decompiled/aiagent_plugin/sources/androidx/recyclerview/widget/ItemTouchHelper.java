package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ItemTouchHelper extends RecyclerView.g implements RecyclerView.i {
    private static final String TAG = "ItemTouchHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final List<View> f2294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    RecyclerView.u f2295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    float f2296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    float f2297d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    float f2298e;
    float f;
    int g;
    a h;
    int i;
    List<RecoverAnimation> j;
    RecyclerView k;
    VelocityTracker l;
    View m;
    int n;
    private final float[] o;
    private float p;
    private float q;
    private float r;
    private float s;
    private int t;
    private RecyclerView.c u;
    private long v;

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
            RecyclerView.u r1 = this.this$0.k.getChildViewHolder(r0);
            if (r1 != null) goto L10;
            return;
        L10:
            if (this.this$0.h.c(this.this$0.k, r1) == true) goto L13;
            return;
        L13:
            if (r4.getPointerId(0) != this.this$0.g) goto L20;
            int r2 = r4.findPointerIndex(this.this$0.g);
            float r3 = r4.getX(r2);
            float r5 = r4.getY(r2);
            this.this$0.f2296c = r3;
            this.this$0.f2297d = r5;
            ItemTouchHelper r6 = this.this$0;
            r6.f = 0.0f;
            r6.f2298e = 0.0f;
            if (this.this$0.h.a() == false) goto L21;
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
        final RecyclerView.u mViewHolder;
        float mX;
        float mY;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r1) {
        }

        RecoverAnimation(RecyclerView.u r2, int r3, int r4, float r5, float r6, float r7, float r8) {
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
            r9.setTarget(r2.f2390a);
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
            this.mX = this.mViewHolder.f2390a.getTranslationX();
        L6:
            float r2 = this.mStartDy;
            float r3 = this.mTargetY;
            if (r2 != r3) goto L9;
            this.mY = this.mViewHolder.f2390a.getTranslationY();
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Interpolator f2303a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Interpolator f2304b = null;

        public static int a(int r3, int r4) {
            int r1 = r3 & 789516;
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
            r6 = (r7 & 789516) << 2;
            goto L9
        }

        public float a(float r1) {
            return r1;
        }

        public float a(RecyclerView.u r1) {
            return 0.5f;
        }

        public abstract int a(RecyclerView r1, RecyclerView.u r2);

        public abstract void a(RecyclerView.u r1, int r2);

        public boolean a() {
            return true;
        }

        public float b(float r1) {
            return r1;
        }

        public int b(int r3, int r4) {
            int r0 = r3 & 3158064;
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
            r2 = (3158064 & r6) >> 2;
            goto L9
        }

        static {
            f2303a = new ItemTouchHelper$Callback$1();
            f2304b = new ItemTouchHelper$Callback$2();
        }

        final int b(RecyclerView r1, RecyclerView.u r2) {
            return b(a(r1, r2), ViewCompat.i(r1));
        }

        boolean c(RecyclerView r1, RecyclerView.u r2) {
            if ((b(r1, r2) & 16711680) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void b(RecyclerView.u r1, int r2) {
            if (r1 == null) goto L5;
            n.f2562a.b(r1.f2390a);
            return;
        }

        void a(Canvas r15, RecyclerView r16, RecyclerView.u r17, List<RecoverAnimation> r18, int r19, float r20, float r21) {
            List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
            int r11 = r10.size();
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L5;
            RecoverAnimation r0 = (RecoverAnimation) ZeusTransformUtils.preCheckCast(r10.get(r12), RecoverAnimation.class, "com.obric.aiagent.plugin");
            r0.update();
            int r13 = r15.save();
            a(r15, r16, r0.mViewHolder, r0.mX, r0.mY, r0.mActionState, false);
            r15.restoreToCount(r13);
            r12 = r12 + 1;
            goto L3
        L5:
            if (r17 == null) goto L9;
            int r9 = r15.save();
            a(r15, r16, r17, r20, r21, r19, true);
            r15.restoreToCount(r9);
            return;
        }

        void b(Canvas r16, RecyclerView r17, RecyclerView.u r18, List<RecoverAnimation> r19, int r20, float r21, float r22) {
            List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
            int r11 = r10.size();
            boolean r12 = false;
            int r13 = 0;
        L3:
            if (r13 >= r11) goto L5;
            RecoverAnimation r0 = (RecoverAnimation) ZeusTransformUtils.preCheckCast(r10.get(r13), RecoverAnimation.class, "com.obric.aiagent.plugin");
            int r14 = r16.save();
            b(r16, r17, r0.mViewHolder, r0.mX, r0.mY, r0.mActionState, false);
            r16.restoreToCount(r14);
            r13 = r13 + 1;
            goto L3
        L5:
            if (r18 == null) goto L7;
            int r15 = r16.save();
            b(r16, r17, r18, r21, r22, r20, true);
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

        public void d(RecyclerView r1, RecyclerView.u r2) {
            n.f2562a.a(r2.f2390a);
        }

        public void a(Canvas r9, RecyclerView r10, RecyclerView.u r11, float r12, float r13, int r14, boolean r15) {
            n.f2562a.a(r9, r10, r11.f2390a, r12, r13, r14, r15);
        }

        public void b(Canvas r9, RecyclerView r10, RecyclerView.u r11, float r12, float r13, int r14, boolean r15) {
            n.f2562a.b(r9, r10, r11.f2390a, r12, r13, r14, r15);
        }

        public long a(RecyclerView r1, int r2, float r3, float r4) {
            RecyclerView.e r0 = r1.getItemAnimator();
            if (r0 != null) goto L8;
            if (r2 != 8) goto L6;
            return 200;
        L6:
            return 250;
        L8:
            if (r2 != 8) goto L11;
            return r0.e();
        L11:
            return r0.g();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(View r1) {
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

    private void a(float[] r4) {
        if ((this.i & 12) == 0) goto L5;
        r4[0] = (this.r + this.f2298e) - this.f2295b.f2390a.getLeft();
    L7:
        if ((this.i & 3) == 0) goto L9;
        r4[1] = (this.s + this.f) - this.f2295b.f2390a.getTop();
        return;
    L9:
        r4[1] = this.f2295b.f2390a.getTranslationY();
        return;
    L5:
        r4[0] = this.f2295b.f2390a.getTranslationX();
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void b(Canvas r10, RecyclerView r11, RecyclerView.r r12) {
        if (this.f2295b == null) goto L5;
        a(this.o);
        float[] r13 = this.o;
        float r0 = r13[0];
        float r8 = r13[1];
        float r7 = r0;
    L6:
        this.h.b(r10, r11, this.f2295b, this.j, this.t, r7, r8);
        return;
    L5:
        r7 = 0.0f;
        r8 = 0.0f;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void a(Canvas r10, RecyclerView r11, RecyclerView.r r12) {
        this.n = -1;
        if (this.f2295b == null) goto L5;
        a(this.o);
        float[] r13 = this.o;
        float r0 = r13[0];
        float r8 = r13[1];
        float r7 = r0;
    L6:
        this.h.a(r10, r11, this.f2295b, this.j, this.t, r7, r8);
        return;
    L5:
        r7 = 0.0f;
        r8 = 0.0f;
        goto L6
    }

    void a(RecyclerView.u r24, int r25) {
        if (r24 == this.f2295b) goto L5;
    L7:
        this.v = Long.MIN_VALUE;
        final int r4 = this.t;
        a(r24, true);
        this.t = r25;
        if (r25 != 2) goto L13;
        if (r24 == null) goto L12;
        this.m = r24.f2390a;
        c();
        goto L13
    L12:
        throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
    L13:
        int r16 = (1 << ((r25 * 8) + 8)) - 1;
        final RecyclerView.u r9 = this.f2295b;
        if (r9 != null) goto L16;
        boolean r8 = false;
    L41:
        if (r24 == null) goto L45;
        this.i = (this.h.b(this.k, r24) & r16) >> (this.t * 8);
        this.r = r24.f2390a.getLeft();
        this.s = r24.f2390a.getTop();
        this.f2295b = r24;
        if (r25 != 2) goto L45;
        boolean r1 = false;
        r24.f2390a.performHapticFeedback(0);
    L46:
        ViewParent r0 = this.k.getParent();
        if (r0 != null) goto L49;
    L53:
        if (r8 == true) goto L55;
        this.k.getLayoutManager().L();
    L55:
        this.h.b(this.f2295b, this.t);
        this.k.invalidate();
        return;
    L49:
        if (this.f2295b == null) goto L51;
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
        if (r9.f2390a.getParent() == null) goto L38;
        if (r4 != 2) goto L19;
        int r7 = 0;
    L20:
        b();
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
        a(this.o);
        float[] r2 = this.o;
        final float r19 = r2[0];
        final float r20 = r2[1];
        final int r3 = r6;
        final int r21 = r7;
        final float r10 = r17;
        final float r11 = r18;
        RecoverAnimation r5 = new AnonymousClass3(this, r9, r3, r4, r19, r20, r10, r11, r21, r9);
        r5.setDuration(this.h.a(this.k, r6, r17 - r19, r18 - r20));
        this.j.add(r5);
        r5.start();
        r8 = true;
    L39:
        this.f2295b = null;
        goto L41
    L34:
        if (r7 <= 0) goto L36;
        r6 = 2;
        goto L37
    L36:
        r6 = 4;
    L30:
        r18 = 0.0f;
        r17 = Math.signum(this.f2298e) * this.k.getWidth();
    L31:
        r17 = 0.0f;
        r18 = Math.signum(this.f) * this.k.getHeight();
        goto L32
    L19:
        r7 = a(r9);
        goto L20
    L38:
        c(r9.f2390a);
        this.h.d(this.k, r9);
        r8 = false;
        goto L39
    L5:
        if (r25 != this.t) goto L7;
    }

    void a(final RecoverAnimation r3, final int r4) {
        this.k.post(new AnonymousClass1(this, r3, r4));
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

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void b(View r3) {
        c(r3);
        RecyclerView.u r4 = this.k.getChildViewHolder(r3);
        if (r4 != null) goto L5;
        return;
    L5:
        RecyclerView.u r0 = this.f2295b;
        if (r0 == null) goto L9;
        if (r4 != r0) goto L9;
        a(null, 0);
        return;
    L9:
        a(r4, false);
        if (this.f2294a.remove(r4.f2390a) == false) goto L14;
        this.h.d(this.k, r4);
        return;
    }

    void a(RecyclerView.u r5, boolean r6) {
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

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void a(Rect r1, View r2, RecyclerView r3, RecyclerView.r r4) {
        r1.setEmpty();
    }

    private void b() {
        VelocityTracker r0 = this.l;
        if (r0 == null) goto L6;
        r0.recycle();
        this.l = null;
        return;
    }

    View a(MotionEvent r6) {
        float r0 = r6.getX();
        float r7 = r6.getY();
        RecyclerView.u r1 = this.f2295b;
        if (r1 == null) goto L7;
        View r2 = r1.f2390a;
        if (a(r2, r0, r7, this.r + this.f2298e, this.s + this.f) == false) goto L7;
        return r2;
    L7:
        int r3 = this.j.size() - 1;
    L8:
        if (r3 < 0) goto L14;
        RecoverAnimation r4 = (RecoverAnimation) ZeusTransformUtils.preCheckCast(this.j.get(r3), RecoverAnimation.class, "com.obric.aiagent.plugin");
        View r5 = r4.mViewHolder.f2390a;
        if (a(r5, r0, r7, r4.mX, r4.mY) == true) goto L11;
        r3 = r3 - 1;
        goto L8
    L11:
        return r5;
    L14:
        return this.k.findChildViewUnder(r0, r7);
    }

    private int a(RecyclerView.u r6) {
        if (this.t != 2) goto L5;
        return 0;
    L5:
        int r0 = this.h.a(this.k, r6);
        int r2 = (this.h.b(r0, ViewCompat.i(this.k)) & 65280) >> 8;
        if (r2 != 0) goto L8;
        return 0;
    L8:
        int r1 = (r0 & 65280) >> 8;
        if (Math.abs(this.f2298e) <= Math.abs(this.f)) goto L20;
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
        return a.a(r3, ViewCompat.i(this.k));
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
        return a.a(r7, ViewCompat.i(this.k));
    }

    private int b(RecyclerView.u r9, int r10) {
        if ((r10 & 12) == 0) goto L29;
        int r2 = 8;
        if (this.f2298e <= 0.0f) goto L7;
        int r0 = 8;
    L8:
        VelocityTracker r4 = this.l;
        if (r4 != null) goto L11;
    L24:
        float r1 = this.k.getWidth() * this.h.a(r9);
        if ((r10 & r0) != 0) goto L27;
        return 0;
    L27:
        if (Math.abs(this.f2298e) <= r1) goto L32;
        return r0;
    L32:
        return 0;
    L11:
        if (this.g <= (-1)) goto L24;
        r4.computeCurrentVelocity(1000, this.h.b(this.q));
        float r5 = this.l.getXVelocity(this.g);
        float r6 = this.l.getYVelocity(this.g);
        if (r5 > 0.0f) goto L16;
        r2 = 4;
    L16:
        float r3 = Math.abs(r5);
        if ((r2 & r10) == 0) goto L24;
        if (r0 != r2) goto L24;
        if (r3 < this.h.a(this.p)) goto L24;
        if (r3 <= Math.abs(r6)) goto L24;
        return r2;
    L7:
        r0 = 4;
        goto L8
    L29:
        return 0;
    }

    private int c(RecyclerView.u r9, int r10) {
        if ((r10 & 3) == 0) goto L29;
        int r2 = 2;
        if (this.f <= 0.0f) goto L7;
        int r0 = 2;
    L8:
        VelocityTracker r4 = this.l;
        if (r4 != null) goto L11;
    L24:
        float r1 = this.k.getHeight() * this.h.a(r9);
        if ((r10 & r0) != 0) goto L27;
        return 0;
    L27:
        if (Math.abs(this.f) <= r1) goto L32;
        return r0;
    L32:
        return 0;
    L11:
        if (this.g <= (-1)) goto L24;
        r4.computeCurrentVelocity(1000, this.h.b(this.q));
        float r5 = this.l.getXVelocity(this.g);
        float r6 = this.l.getYVelocity(this.g);
        if (r6 > 0.0f) goto L16;
        r2 = 1;
    L16:
        float r3 = Math.abs(r6);
        if ((r2 & r10) == 0) goto L24;
        if (r2 != r0) goto L24;
        if (r3 < this.h.a(this.p)) goto L24;
        if (r3 <= Math.abs(r5)) goto L24;
        return r2;
    L7:
        r0 = 1;
        goto L8
    L29:
        return 0;
    }

    private void c() {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        return;
    L6:
        if (this.u != null) goto L8;
        this.u = new AnonymousClass2(this);
    L8:
        this.k.setChildDrawingOrderCallback(this.u);
    }

    void c(View r2) {
        if (r2 != this.m) goto L8;
        this.m = null;
        if (this.u == null) goto L9;
        this.k.setChildDrawingOrderCallback(null);
        return;
    L9:
        return;
    }
}
