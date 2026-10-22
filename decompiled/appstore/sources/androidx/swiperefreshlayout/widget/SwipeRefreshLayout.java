package androidx.swiperefreshlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ListView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.ViewCompat;
import androidx.core.view.i;
import com.google.common.primitives.Ints;
import com.ttnet.org.chromium.net.PrivateKeyType;

/* JADX INFO: loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
    public static final String O = "SwipeRefreshLayout";
    public static final int[] P = null;
    public int A;
    public CircularProgressDrawable B;
    public Animation C;
    public Animation D;
    public Animation E;
    public Animation F;
    public Animation G;
    public boolean H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f4855J;
    public OnChildScrollUpCallback K;
    public Animation.AnimationListener L;
    public final Animation M;
    public final Animation N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f4856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OnRefreshListener f4857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4859d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f4860e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f4861f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i f4862g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final NestedScrollingChildHelper f4863h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f4864i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f4865j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f4866k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f4867l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f4868m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f4869n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f4870o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f4871p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f4872q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f4873r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f4874s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final DecelerateInterpolator f4875t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public f0.a f4876u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f4877v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f4878w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f4879x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f4880y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f4881z;

    public interface OnChildScrollUpCallback {
        boolean canChildScrollUp(@NonNull SwipeRefreshLayout r10, @Nullable View r11);
    }

    public interface OnRefreshListener {
        void onRefresh();
    }

    public class a implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SwipeRefreshLayout f4882a;

        public a(SwipeRefreshLayout r10) {
            this.f4882a = r10;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation r10) {
            SwipeRefreshLayout r11 = this.f4882a;
            if (r11.f4858c == false) goto L10;
            r11.B.setAlpha(PrivateKeyType.INVALID);
            this.f4882a.B.start();
            SwipeRefreshLayout r12 = this.f4882a;
            if (r12.H == false) goto L9;
            OnRefreshListener r13 = r12.f4857b;
            if (r13 == null) goto L9;
            r13.onRefresh();
        L9:
            SwipeRefreshLayout r14 = this.f4882a;
            r14.f4868m = r14.f4876u.getTop();
            return;
        L10:
            r11.j();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation r10) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation r10) {
        }
    }

    public class b extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SwipeRefreshLayout f4883a;

        public b(SwipeRefreshLayout r10) {
            this.f4883a = r10;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float r10, Transformation r11) {
            this.f4883a.setAnimationProgress(r10);
        }
    }

    public class c extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SwipeRefreshLayout f4884a;

        public c(SwipeRefreshLayout r10) {
            this.f4884a = r10;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float r10, Transformation r11) {
            this.f4884a.setAnimationProgress(1.0f - r10);
        }
    }

    public class d extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f4885a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f4886b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SwipeRefreshLayout f4887c;

        public d(SwipeRefreshLayout r10, int r11, int r12) {
            this.f4887c = r10;
            this.f4885a = r11;
            this.f4886b = r12;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float r10, Transformation r11) {
            CircularProgressDrawable r12 = this.f4887c.B;
            int r13 = this.f4885a;
            r12.setAlpha((int) (r13 + ((this.f4886b - r13) * r10)));
        }
    }

    public class e implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SwipeRefreshLayout f4888a;

        public e(SwipeRefreshLayout r10) {
            this.f4888a = r10;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation r10) {
            SwipeRefreshLayout r11 = this.f4888a;
            if (r11.f4873r == true) goto L6;
            r11.p(null);
            return;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation r10) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation r10) {
        }
    }

    public class f extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SwipeRefreshLayout f4889a;

        public f(SwipeRefreshLayout r10) {
            this.f4889a = r10;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float r10, Transformation r11) {
            SwipeRefreshLayout r12 = this.f4889a;
            if (r12.f4855J == true) goto L5;
            int r13 = r12.f4881z - Math.abs(r12.f4880y);
        L6:
            SwipeRefreshLayout r14 = this.f4889a;
            int r15 = r14.f4878w;
            this.f4889a.setTargetOffsetTopAndBottom((r15 + ((int) ((r13 - r15) * r10))) - r14.f4876u.getTop());
            this.f4889a.B.e(1.0f - r10);
            return;
        L5:
            r13 = r12.f4881z;
            goto L6
        }
    }

    public class g extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SwipeRefreshLayout f4890a;

        public g(SwipeRefreshLayout r10) {
            this.f4890a = r10;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float r10, Transformation r11) {
            this.f4890a.i(r10);
        }
    }

    public class h extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SwipeRefreshLayout f4891a;

        public h(SwipeRefreshLayout r10) {
            this.f4891a = r10;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float r10, Transformation r11) {
            SwipeRefreshLayout r12 = this.f4891a;
            float r13 = r12.f4879x;
            r12.setAnimationProgress(r13 + ((-r13) * r10));
            this.f4891a.i(r10);
        }
    }

    static {
        P = new int[]{R.attr.enabled};
    }

    public SwipeRefreshLayout(@NonNull Context r10) {
        this(r10, null);
    }

    private void onSecondaryPointerUp(MotionEvent r10) {
        int r11 = r10.getActionIndex();
        if (r10.getPointerId(r11) != this.f4872q) goto L9;
        if (r11 != 0) goto L6;
        int r12 = 1;
    L7:
        this.f4872q = r10.getPointerId(r12);
        return;
    L6:
        r12 = 0;
        goto L7
    }

    private void setColorViewAlpha(int r10) {
        this.f4876u.getBackground().setAlpha(r10);
        this.B.setAlpha(r10);
    }

    public final void a(int r10, Animation.AnimationListener r11) {
        this.f4878w = r10;
        this.M.reset();
        this.M.setDuration(200);
        this.M.setInterpolator(this.f4875t);
        if (r11 == null) goto L5;
        this.f4876u.b(r11);
    L5:
        this.f4876u.clearAnimation();
        this.f4876u.startAnimation(this.M);
    }

    public final void b(int r10, Animation.AnimationListener r11) {
        if (this.f4873r == false) goto L5;
        q(r10, r11);
        return;
    L5:
        this.f4878w = r10;
        this.N.reset();
        this.N.setDuration(200);
        this.N.setInterpolator(this.f4875t);
        if (r11 == null) goto L8;
        this.f4876u.b(r11);
    L8:
        this.f4876u.clearAnimation();
        this.f4876u.startAnimation(this.N);
    }

    public boolean c() {
        OnChildScrollUpCallback r10 = this.K;
        if (r10 != null) goto L5;
        View r11 = this.f4856a;
        if ((r11 instanceof ListView) == false) goto L11;
        return androidx.core.widget.i.a((ListView) r11, -1);
    L11:
        return r11.canScrollVertically(-1);
    L5:
        return r10.canChildScrollUp(this, this.f4856a);
    }

    public final void d() {
        this.f4876u = new f0.a(getContext(), -328966);
        CircularProgressDrawable r10 = new CircularProgressDrawable(getContext());
        this.B = r10;
        r10.l(1);
        this.f4876u.setImageDrawable(this.B);
        this.f4876u.setVisibility(8);
        addView(this.f4876u);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float r10, float r11, boolean r12) {
        return this.f4863h.a(r10, r11, r12);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float r10, float r11) {
        return this.f4863h.b(r10, r11);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int r10, int r11, int[] r12, int[] r13) {
        return this.f4863h.c(r10, r11, r12, r13);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, int[] r14) {
        return this.f4863h.f(r10, r11, r12, r13, r14);
    }

    public final void e() {
        if (this.f4856a != null) goto L11;
        int r10 = 0;
    L6:
        if (r10 >= getChildCount()) goto L15;
        View r11 = getChildAt(r10);
        if (r11.equals(this.f4876u) == false) goto L9;
        r10 = r10 + 1;
        goto L6
    L9:
        this.f4856a = r11;
        return;
    L15:
        return;
    }

    public final void f(float r10) {
        if (r10 <= this.f4860e) goto L5;
        k(true, true);
        return;
    L5:
        this.f4858c = false;
        this.B.j(0.0f, 0.0f);
        if (this.f4873r == true) goto L8;
        e r11 = new e(this);
    L9:
        b(this.f4868m, r11);
        this.B.d(false);
        return;
    L8:
        r11 = null;
        goto L9
    }

    public final boolean g(Animation r10) {
        if (r10 != null) goto L4;
    L8:
        return false;
    L4:
        if (r10.hasStarted() == false) goto L8;
        if (r10.hasEnded() == true) goto L8;
        return true;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int r10, int r11) {
        int r12 = this.f4877v;
        if (r12 >= 0) goto L6;
        return r11;
    L6:
        if (r11 != (r10 - 1)) goto L8;
        return r12;
    L8:
        if (r11 >= r12) goto L10;
        return r11;
    L10:
        return r11 + 1;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f4862g.a();
    }

    public int getProgressCircleDiameter() {
        return this.I;
    }

    public int getProgressViewEndOffset() {
        return this.f4881z;
    }

    public int getProgressViewStartOffset() {
        return this.f4880y;
    }

    public final void h(float r12) {
        this.B.d(true);
        float r10 = Math.min(1.0f, Math.abs(r12 / this.f4860e));
        float r11 = (((float) Math.max(((double) r10) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float r13 = Math.abs(r12) - this.f4860e;
        int r14 = this.A;
        if (r14 <= 0) goto L6;
    L4:
        float r15 = r14;
        double r16 = Math.max(0.0f, Math.min(r13, r15 * 2.0f) / r15) / 4.0f;
        float r17 = ((float) (r16 - Math.pow(r16, 2.0d))) * 2.0f;
        int r18 = this.f4880y + ((int) ((r15 * r10) + ((r15 * r17) * 2.0f)));
        if (this.f4876u.getVisibility() == 0) goto L13;
        this.f4876u.setVisibility(0);
    L13:
        if (this.f4873r == true) goto L16;
        this.f4876u.setScaleX(1.0f);
        this.f4876u.setScaleY(1.0f);
    L16:
        if (this.f4873r == false) goto L19;
        setAnimationProgress(Math.min(1.0f, r12 / this.f4860e));
    L19:
        if (r12 >= this.f4860e) goto L26;
        if (this.B.getAlpha() > 76) goto L23;
    L30:
        this.B.j(0.0f, Math.min(0.8f, r11 * 0.8f));
        this.B.e(Math.min(1.0f, r11));
        this.B.g((((r11 * 0.4f) - 0.25f) + (r17 * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(r18 - this.f4868m);
        return;
    L23:
        if (g(this.E) == true) goto L30;
        o();
        goto L30
    L26:
        if (this.B.getAlpha() >= 255) goto L30;
        if (g(this.F) == true) goto L30;
        n();
        goto L30
    L6:
        if (this.f4855J == false) goto L8;
        r14 = this.f4881z - this.f4880y;
        goto L4
    L8:
        r14 = this.f4881z;
        goto L4
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.f4863h.k();
    }

    public void i(float r10) {
        int r11 = this.f4878w;
        setTargetOffsetTopAndBottom((r11 + ((int) ((this.f4880y - r11) * r10))) - this.f4876u.getTop());
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.f4863h.m();
    }

    public void j() {
        this.f4876u.clearAnimation();
        this.B.stop();
        this.f4876u.setVisibility(8);
        setColorViewAlpha(PrivateKeyType.INVALID);
        if (this.f4873r == false) goto L5;
        setAnimationProgress(0.0f);
    L6:
        this.f4868m = this.f4876u.getTop();
        return;
    L5:
        setTargetOffsetTopAndBottom(this.f4880y - this.f4868m);
        goto L6
    }

    public final void k(boolean r10, boolean r11) {
        if (this.f4858c == r10) goto L9;
        this.H = r11;
        e();
        this.f4858c = r10;
        if (r10 == false) goto L7;
        a(this.f4868m, this.L);
        return;
    L7:
        p(this.L);
        return;
    }

    public final Animation l(int r10, int r11) {
        d r12 = new d(this, r10, r11);
        r12.setDuration(300);
        this.f4876u.b(null);
        this.f4876u.clearAnimation();
        this.f4876u.startAnimation(r12);
        return r12;
    }

    public final void m(float r10) {
        float r11 = this.f4870o;
        float r12 = r10 - r11;
        int r13 = this.f4859d;
        if (r12 > r13) goto L5;
        return;
    L5:
        if (this.f4871p == true) goto L9;
        this.f4869n = r11 + r13;
        this.f4871p = true;
        this.B.setAlpha(76);
        return;
    }

    public final void n() {
        this.F = l(this.B.getAlpha(), PrivateKeyType.INVALID);
    }

    public final void o() {
        this.E = l(this.B.getAlpha(), 76);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        e();
        int r11 = r10.getActionMasked();
        if (this.f4874s == false) goto L7;
        if (r11 != 0) goto L7;
        this.f4874s = false;
    L7:
        if (isEnabled() == true) goto L9;
    L43:
        return false;
    L9:
        if (this.f4874s == true) goto L43;
        if (c() == true) goto L43;
        if (this.f4858c == true) goto L43;
        if (this.f4866k == true) goto L43;
        if (r11 != 0) goto L19;
        setTargetOffsetTopAndBottom(this.f4880y - this.f4876u.getTop());
        int r12 = r10.getPointerId(0);
        this.f4872q = r12;
        this.f4871p = false;
        int r13 = r10.findPointerIndex(r12);
        if (r13 >= 0) goto L40;
        return false;
    L40:
        this.f4870o = r10.getY(r13);
    L42:
        return this.f4871p;
    L19:
        if (r11 != 1) goto L21;
    L36:
        this.f4871p = false;
        this.f4872q = -1;
        goto L42
    L21:
        if (r11 != 2) goto L23;
        int r14 = this.f4872q;
        if (r14 != (-1)) goto L32;
        Log.e(O, "Got ACTION_MOVE event but don't have an active pointer id.");
        return false;
    L32:
        int r15 = r10.findPointerIndex(r14);
        if (r15 >= 0) goto L35;
        return false;
    L35:
        m(r10.getY(r15));
        goto L42
    L23:
        if (r11 == 3) goto L36;
        if (r11 != 6) goto L42;
        onSecondaryPointerUp(r10);
        goto L42
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        int r15 = getMeasuredWidth();
        int r16 = getMeasuredHeight();
        if (getChildCount() != 0) goto L6;
        return;
    L6:
        if (this.f4856a != null) goto L8;
        e();
    L8:
        View r17 = this.f4856a;
        if (r17 != null) goto L11;
        return;
    L11:
        int r18 = getPaddingLeft();
        int r19 = getPaddingTop();
        int r20 = (r15 - getPaddingLeft()) - getPaddingRight();
        r17.layout(r18, r19, r20 + r18, ((r16 - getPaddingTop()) - getPaddingBottom()) + r19);
        int r21 = this.f4876u.getMeasuredWidth();
        int r22 = this.f4876u.getMeasuredHeight();
        int r23 = r15 / 2;
        int r24 = r21 / 2;
        int r25 = this.f4868m;
        this.f4876u.layout(r23 - r24, r25, r23 + r24, r22 + r25);
    }

    @Override // android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        if (this.f4856a != null) goto L5;
        e();
    L5:
        View r12 = this.f4856a;
        if (r12 != null) goto L8;
        return;
    L8:
        r12.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), Ints.MAX_POWER_OF_TWO));
        this.f4876u.measure(View.MeasureSpec.makeMeasureSpec(this.I, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(this.I, Ints.MAX_POWER_OF_TWO));
        this.f4877v = -1;
        int r13 = 0;
    L10:
        if (r13 >= getChildCount()) goto L18;
        if (getChildAt(r13) == this.f4876u) goto L13;
        r13 = r13 + 1;
        goto L10
    L13:
        this.f4877v = r13;
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View r10, float r11, float r12, boolean r13) {
        return dispatchNestedFling(r11, r12, r13);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View r10, float r11, float r12) {
        return dispatchNestedPreFling(r11, r12);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View r10, int r11, int r12, int[] r13) {
        if (r12 <= 0) goto L12;
        float r14 = this.f4861f;
        if (r14 <= 0.0f) goto L12;
        float r15 = r12;
        if (r15 <= r14) goto L9;
        r13[1] = r12 - ((int) r14);
        this.f4861f = 0.0f;
    L10:
        h(this.f4861f);
        goto L12
    L9:
        this.f4861f = r14 - r15;
        r13[1] = r12;
    L12:
        if (this.f4855J == false) goto L19;
        if (r12 <= 0) goto L19;
        if (this.f4861f != 0.0f) goto L19;
        if (Math.abs(r12 - r13[1]) <= 0) goto L19;
        this.f4876u.setVisibility(8);
    L19:
        int[] r16 = this.f4864i;
        if (dispatchNestedPreScroll(r11 - r13[0], r12 - r13[1], r16, null) == false) goto L23;
        r13[0] = r13[0] + r16[0];
        r13[1] = r13[1] + r16[1];
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View r10, int r11, int r12, int r13, int r14) {
        dispatchNestedScroll(r11, r12, r13, r14, this.f4865j);
        int r15 = r14 + this.f4865j[1];
        if (r15 < 0) goto L5;
        return;
    L5:
        if (c() == true) goto L9;
        float r16 = this.f4861f + Math.abs(r15);
        this.f4861f = r16;
        h(r16);
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View r10, View r11, int r12) {
        this.f4862g.b(r10, r11, r12);
        startNestedScroll(r12 & 2);
        this.f4861f = 0.0f;
        this.f4866k = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View r10, View r11, int r12) {
        if (isEnabled() == true) goto L5;
    L11:
        return false;
    L5:
        if (this.f4874s == true) goto L11;
        if (this.f4858c == true) goto L11;
        if ((r12 & 2) == 0) goto L11;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View r10) {
        this.f4862g.d(r10);
        this.f4866k = false;
        float r11 = this.f4861f;
        if (r11 <= 0.0f) goto L5;
        f(r11);
        this.f4861f = 0.0f;
    L5:
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        int r11 = r10.getActionMasked();
        if (this.f4874s == false) goto L7;
        if (r11 != 0) goto L7;
        this.f4874s = false;
    L7:
        if (isEnabled() == true) goto L9;
    L58:
        return false;
    L9:
        if (this.f4874s == true) goto L58;
        if (c() == true) goto L58;
        if (this.f4858c == true) goto L58;
        if (this.f4866k == true) goto L58;
        if (r11 != 0) goto L20;
        this.f4872q = r10.getPointerId(0);
        this.f4871p = false;
    L57:
        return true;
    L20:
        if (r11 != 1) goto L22;
        int r12 = r10.findPointerIndex(this.f4872q);
        if (r12 >= 0) goto L52;
        Log.e(O, "Got ACTION_UP event but don't have an active pointer id.");
        return false;
    L52:
        if (this.f4871p == false) goto L54;
        float r13 = (r10.getY(r12) - this.f4869n) * 0.5f;
        this.f4871p = false;
        f(r13);
    L54:
        this.f4872q = -1;
        return false;
    L22:
        if (r11 != 2) goto L24;
        int r14 = r10.findPointerIndex(this.f4872q);
        if (r14 >= 0) goto L41;
        Log.e(O, "Got ACTION_MOVE event but have an invalid active pointer id.");
        return false;
    L41:
        float r15 = r10.getY(r14);
        m(r15);
        if (this.f4871p == false) goto L57;
        float r16 = (r15 - this.f4869n) * 0.5f;
        if (r16 <= 0.0f) goto L46;
        h(r16);
        goto L57
    L46:
        return false;
    L24:
        if (r11 != 3) goto L26;
        return false;
    L26:
        if (r11 != 5) goto L28;
        int r17 = r10.getActionIndex();
        if (r17 >= 0) goto L35;
        Log.e(O, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
        return false;
    L35:
        this.f4872q = r10.getPointerId(r17);
        goto L57
    L28:
        if (r11 != 6) goto L57;
        onSecondaryPointerUp(r10);
        goto L57
    }

    public void p(Animation.AnimationListener r10) {
        c r11 = new c(this);
        this.D = r11;
        r11.setDuration(150);
        this.f4876u.b(r10);
        this.f4876u.clearAnimation();
        this.f4876u.startAnimation(this.D);
    }

    public final void q(int r10, Animation.AnimationListener r11) {
        this.f4878w = r10;
        this.f4879x = this.f4876u.getScaleX();
        h r12 = new h(this);
        this.G = r12;
        r12.setDuration(150);
        if (r11 == null) goto L5;
        this.f4876u.b(r11);
    L5:
        this.f4876u.clearAnimation();
        this.f4876u.startAnimation(this.G);
    }

    public final void r(Animation.AnimationListener r10) {
        this.f4876u.setVisibility(0);
        this.B.setAlpha(PrivateKeyType.INVALID);
        b r11 = new b(this);
        this.C = r11;
        r11.setDuration(this.f4867l);
        if (r10 == null) goto L5;
        this.f4876u.b(r10);
    L5:
        this.f4876u.clearAnimation();
        this.f4876u.startAnimation(this.C);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r10) {
        View r11 = this.f4856a;
        if (r11 != null) goto L5;
    L7:
        super.requestDisallowInterceptTouchEvent(r10);
        return;
    L5:
        if (ViewCompat.U(r11) == true) goto L7;
    }

    public void setAnimationProgress(float r10) {
        this.f4876u.setScaleX(r10);
        this.f4876u.setScaleY(r10);
    }

    @Deprecated
    public void setColorScheme(@ColorRes int... r10) {
        setColorSchemeResources(r10);
    }

    public void setColorSchemeColors(@ColorInt int... r10) {
        e();
        this.B.f(r10);
    }

    public void setColorSchemeResources(@ColorRes int... r10) {
        Context r11 = getContext();
        int[] r12 = new int[r10.length];
        int r13 = 0;
    L4:
        if (r13 >= r10.length) goto L6;
        r12[r13] = ContextCompat.b(r11, r10[r13]);
        r13 = r13 + 1;
        goto L4
    L6:
        setColorSchemeColors(r12);
    }

    public void setDistanceToTriggerSync(int r10) {
        this.f4860e = r10;
    }

    @Override // android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        if (r10 == true) goto L6;
        j();
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r10) {
        this.f4863h.n(r10);
    }

    public void setOnChildScrollUpCallback(@Nullable OnChildScrollUpCallback r10) {
        this.K = r10;
    }

    public void setOnRefreshListener(@Nullable OnRefreshListener r10) {
        this.f4857b = r10;
    }

    @Deprecated
    public void setProgressBackgroundColor(int r10) {
        setProgressBackgroundColorSchemeResource(r10);
    }

    public void setProgressBackgroundColorSchemeColor(@ColorInt int r10) {
        this.f4876u.setBackgroundColor(r10);
    }

    public void setProgressBackgroundColorSchemeResource(@ColorRes int r10) {
        setProgressBackgroundColorSchemeColor(ContextCompat.b(getContext(), r10));
    }

    public void setRefreshing(boolean r10) {
        if (r10 == true) goto L5;
    L11:
        k(r10, false);
        return;
    L5:
        if (this.f4858c == r10) goto L11;
        this.f4858c = r10;
        if (this.f4855J == true) goto L9;
        int r11 = this.f4881z + this.f4880y;
    L10:
        setTargetOffsetTopAndBottom(r11 - this.f4868m);
        this.H = false;
        r(this.L);
        return;
    L9:
        r11 = this.f4881z;
        goto L10
    }

    public void setSize(int r10) {
        if (r10 != 0) goto L4;
    L6:
        DisplayMetrics r11 = getResources().getDisplayMetrics();
        if (r10 != 0) goto L9;
        this.I = (int) (r11.density * 56.0f);
    L10:
        this.f4876u.setImageDrawable(null);
        this.B.l(r10);
        this.f4876u.setImageDrawable(this.B);
        return;
    L9:
        this.I = (int) (r11.density * 40.0f);
        goto L10
    L4:
        if (r10 == 1) goto L6;
    }

    public void setSlingshotDistance(@Px int r10) {
        this.A = r10;
    }

    public void setTargetOffsetTopAndBottom(int r10) {
        this.f4876u.bringToFront();
        ViewCompat.a0(this.f4876u, r10);
        this.f4868m = this.f4876u.getTop();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int r10) {
        return this.f4863h.p(r10);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.f4863h.r();
    }

    public SwipeRefreshLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
        this.f4858c = false;
        this.f4860e = -1.0f;
        this.f4864i = new int[2];
        this.f4865j = new int[2];
        this.f4872q = -1;
        this.f4877v = -1;
        this.L = new a(this);
        this.M = new f(this);
        this.N = new g(this);
        this.f4859d = ViewConfiguration.get(r10).getScaledTouchSlop();
        this.f4867l = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.f4875t = new DecelerateInterpolator(2.0f);
        DisplayMetrics r12 = getResources().getDisplayMetrics();
        this.I = (int) (r12.density * 40.0f);
        d();
        setChildrenDrawingOrderEnabled(true);
        int r13 = (int) (r12.density * 64.0f);
        this.f4881z = r13;
        this.f4860e = r13;
        this.f4862g = new i(this);
        this.f4863h = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int r14 = -this.I;
        this.f4868m = r14;
        this.f4880y = r14;
        i(1.0f);
        TypedArray r15 = r10.obtainStyledAttributes(r11, P);
        setEnabled(r15.getBoolean(0, true));
        r15.recycle();
    }
}
