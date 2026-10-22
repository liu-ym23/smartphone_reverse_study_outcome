package com.stepos.common.scrollbarview;

import H1.e;
import H1.m;
import N1.i;
import N1.n;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Insets;
import android.graphics.Interpolator;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.common.scrollbarview.StepOSScrollBarView;
import com.stepos.common.scrollview.StepOSNestedScrollView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import stepos.support.v7.widget.StepOSRecyclerView;

/* loaded from: classes.dex */
public class StepOSScrollBarView extends View {

    /* renamed from: D, reason: collision with root package name */
    private static final Interpolator f13689D = androidx.core.view.animation.a.a(0.4f, 0.0f, 0.2f, 1.0f);

    /* renamed from: E, reason: collision with root package name */
    private static Method f13690E;

    /* renamed from: F, reason: collision with root package name */
    private static Method f13691F;

    /* renamed from: G, reason: collision with root package name */
    private static Method f13692G;

    /* renamed from: H, reason: collision with root package name */
    private static Method f13693H;

    /* renamed from: I, reason: collision with root package name */
    private static Method f13694I;

    /* renamed from: J, reason: collision with root package name */
    private static Method f13695J;

    /* renamed from: K, reason: collision with root package name */
    private static boolean f13696K;

    /* renamed from: A, reason: collision with root package name */
    private int f13697A;

    /* renamed from: B, reason: collision with root package name */
    private e5.c f13698B;

    /* renamed from: C, reason: collision with root package name */
    boolean f13699C;

    /* renamed from: a, reason: collision with root package name */
    private View f13700a;

    /* renamed from: b, reason: collision with root package name */
    private com.stepos.common.scrollbarview.b f13701b;

    /* renamed from: c, reason: collision with root package name */
    private Drawable f13702c;

    /* renamed from: d, reason: collision with root package name */
    private Drawable f13703d;

    /* renamed from: e, reason: collision with root package name */
    private int f13704e;

    /* renamed from: f, reason: collision with root package name */
    private int f13705f;

    /* renamed from: g, reason: collision with root package name */
    private com.stepos.common.scrollbarview.a f13706g;

    /* renamed from: h, reason: collision with root package name */
    private int f13707h;

    /* renamed from: i, reason: collision with root package name */
    private int f13708i;

    /* renamed from: j, reason: collision with root package name */
    private int f13709j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f13710k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f13711l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f13712m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f13713n;

    /* renamed from: o, reason: collision with root package name */
    private final d f13714o;

    /* renamed from: p, reason: collision with root package name */
    private final c f13715p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f13716q;

    /* renamed from: r, reason: collision with root package name */
    private Handler f13717r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f13718s;

    /* renamed from: t, reason: collision with root package name */
    private float f13719t;

    /* renamed from: u, reason: collision with root package name */
    private float f13720u;

    /* renamed from: v, reason: collision with root package name */
    private int f13721v;

    /* renamed from: w, reason: collision with root package name */
    private final int f13722w;

    /* renamed from: x, reason: collision with root package name */
    private final int f13723x;

    /* renamed from: y, reason: collision with root package name */
    private VelocityTracker f13724y;

    /* renamed from: z, reason: collision with root package name */
    private List<b> f13725z;

    public static abstract class a {
    }

    public interface b {
        void a(StepOSScrollBarView stepOSScrollBarView, int i5, int i6);

        void b(StepOSScrollBarView stepOSScrollBarView, int i5);
    }

    static class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public int f13726a = 0;

        /* renamed from: b, reason: collision with root package name */
        public long f13727b;

        /* renamed from: c, reason: collision with root package name */
        public ValueAnimator f13728c;

        /* renamed from: d, reason: collision with root package name */
        private final View f13729d;

        /* renamed from: e, reason: collision with root package name */
        private final int f13730e;

        /* renamed from: f, reason: collision with root package name */
        private final int f13731f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f13732g;

        /* renamed from: h, reason: collision with root package name */
        private final com.stepos.common.scrollbarview.b f13733h;

        public c(View view, int i5, int i6, com.stepos.common.scrollbarview.b bVar) {
            this.f13729d = view;
            this.f13730e = i5;
            this.f13731f = i6;
            this.f13733h = bVar;
        }

        public static /* synthetic */ void a(c cVar, int i5, ValueAnimator valueAnimator) {
            cVar.getClass();
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue() + i5;
            com.stepos.common.scrollbarview.b bVar = cVar.f13733h;
            bVar.setBounds(i5, bVar.getBounds().top, iIntValue, cVar.f13733h.getBounds().bottom);
        }

        private void b() {
            if (this.f13728c == null) {
                this.f13728c = new ValueAnimator();
            }
        }

        public void c() {
            ValueAnimator valueAnimator = this.f13728c;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                return;
            }
            this.f13728c.cancel();
        }

        public void d(int i5, int i6) {
            c();
            b();
            this.f13728c.setIntValues(i5, i6);
            this.f13728c.setDuration(250L);
            this.f13728c.setInterpolator(StepOSScrollBarView.f13689D);
            this.f13728c.start();
            this.f13726a = 1;
            this.f13732g = true;
            this.f13729d.postInvalidate();
        }

        @Override // java.lang.Runnable
        public void run() {
            com.stepos.common.scrollbarview.b bVar;
            if (AnimationUtils.currentAnimationTimeMillis() < this.f13727b || this.f13726a != 0) {
                return;
            }
            b();
            this.f13726a = 1;
            this.f13732g = false;
            this.f13728c.setDuration(250L);
            this.f13728c.setInterpolator(StepOSScrollBarView.f13689D);
            this.f13728c.setIntValues(this.f13730e, this.f13731f);
            if (StepOSScrollBarView.f13696K && (bVar = this.f13733h) != null) {
                final int i5 = bVar.getBounds().left;
                this.f13728c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.common.scrollbarview.c
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        StepOSScrollBarView.c.a(this.f13761a, i5, valueAnimator);
                    }
                });
            }
            this.f13728c.start();
            this.f13729d.postInvalidate();
        }
    }

    static class d implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        private static final float[] f13734f = {255.0f};

        /* renamed from: g, reason: collision with root package name */
        private static final float[] f13735g = {0.0f};

        /* renamed from: b, reason: collision with root package name */
        public float[] f13737b;

        /* renamed from: d, reason: collision with root package name */
        public long f13739d;

        /* renamed from: e, reason: collision with root package name */
        public View f13740e;

        /* renamed from: a, reason: collision with root package name */
        public final android.graphics.Interpolator f13736a = new android.graphics.Interpolator(1, 2);

        /* renamed from: c, reason: collision with root package name */
        public int f13738c = 0;

        public d(View view) {
            this.f13740e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (jCurrentAnimationTimeMillis < this.f13739d || this.f13738c != 1) {
                return;
            }
            View view = this.f13740e;
            if (!(view instanceof StepOSScrollBarView) || ((StepOSScrollBarView) view).f13699C) {
                return;
            }
            int i5 = (int) jCurrentAnimationTimeMillis;
            android.graphics.Interpolator interpolator = this.f13736a;
            interpolator.setKeyFrame(0, i5, f13734f);
            interpolator.setKeyFrame(1, i5 + 500, f13735g);
            this.f13738c = 2;
            this.f13740e.invalidate();
        }
    }

    static {
        try {
            f13690E = View.class.getDeclaredMethod("computeVerticalScrollExtent", null);
            f13692G = View.class.getDeclaredMethod("computeVerticalScrollRange", null);
            f13691F = View.class.getDeclaredMethod("computeVerticalScrollOffset", null);
            f13695J = View.class.getDeclaredMethod("computeHorizontalScrollRange", null);
            f13693H = View.class.getDeclaredMethod("computeHorizontalScrollExtent", null);
            f13694I = View.class.getDeclaredMethod("computeHorizontalScrollOffset", null);
            Method method = f13690E;
            if (method != null) {
                method.setAccessible(true);
            }
            Method method2 = f13692G;
            if (method2 != null) {
                method2.setAccessible(true);
            }
            Method method3 = f13691F;
            if (method3 != null) {
                method3.setAccessible(true);
            }
            Method method4 = f13693H;
            if (method4 != null) {
                method4.setAccessible(true);
            }
            Method method5 = f13695J;
            if (method5 != null) {
                method5.setAccessible(true);
            }
            Method method6 = f13694I;
            if (method6 != null) {
                method6.setAccessible(true);
            }
        } catch (NoSuchMethodException unused) {
            Log.e("StepOSSScrollBarView", "get reflect method has an error!");
        }
        f13696K = false;
    }

    public StepOSScrollBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, H1.c.f2070q);
    }

    private void e(float f5, float f6) {
        e5.c cVar = this.f13698B;
        if (cVar != null) {
            cVar.A(f5, f6);
        }
    }

    private void g(Context context, AttributeSet attributeSet, int i5) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.R5, i5, 0);
        this.f13708i = typedArrayObtainStyledAttributes.getDimensionPixelSize(m.Z5, (int) i.a(2.0f, context));
        this.f13709j = typedArrayObtainStyledAttributes.getDimensionPixelSize(m.Y5, (int) i.a(6.0f, context));
        this.f13707h = typedArrayObtainStyledAttributes.getDimensionPixelSize(m.V5, (int) i.a(30.0f, context));
        this.f13710k = typedArrayObtainStyledAttributes.getBoolean(m.U5, true);
        this.f13711l = typedArrayObtainStyledAttributes.getBoolean(m.W5, true);
        this.f13712m = typedArrayObtainStyledAttributes.getBoolean(m.T5, false);
        this.f13713n = typedArrayObtainStyledAttributes.getBoolean(m.S5, false);
        this.f13718s = typedArrayObtainStyledAttributes.getInt(m.X5, 1) == 1;
        this.f13703d = typedArrayObtainStyledAttributes.getDrawable(m.a6);
        this.f13702c = typedArrayObtainStyledAttributes.getDrawable(m.c6);
        this.f13705f = typedArrayObtainStyledAttributes.getColor(m.b6, context.getResources().getColor(e.f2103y));
        this.f13704e = typedArrayObtainStyledAttributes.getColor(m.d6, context.getResources().getColor(e.f2104z));
        h();
        typedArrayObtainStyledAttributes.recycle();
    }

    private int getScrollableViewScrollExtent() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = this.f13718s ? f13690E : f13693H;
        View view = this.f13700a;
        if (view == null || method == null) {
            return 0;
        }
        try {
            Object objInvoke = method.invoke(view, null);
            if (objInvoke instanceof Integer) {
                return ((Integer) objInvoke).intValue();
            }
            return 0;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            Log.e("StepOSSScrollBarView", "invoke computeVerticalScrollExtent has an error!");
            return 0;
        }
    }

    private int getScrollableViewScrollOffset() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = this.f13718s ? f13691F : f13694I;
        View view = this.f13700a;
        if (view == null || method == null) {
            return 0;
        }
        try {
            Object objInvoke = method.invoke(view, null);
            if (objInvoke instanceof Integer) {
                return ((Integer) objInvoke).intValue();
            }
            return 0;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            Log.e("StepOSSScrollBarView", "invoke computeVerticalScrollOffset has an error!");
            return 0;
        }
    }

    private int getScrollableViewScrollRange() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = this.f13718s ? f13692G : f13695J;
        View view = this.f13700a;
        if (view == null || method == null) {
            return 0;
        }
        try {
            Object objInvoke = method.invoke(view, null);
            if (objInvoke instanceof Integer) {
                return ((Integer) objInvoke).intValue();
            }
            return 0;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            Log.e("StepOSSScrollBarView", "invoke computeVerticalScrollRange has an error!");
            return 0;
        }
    }

    private void h() {
        if (this.f13701b == null) {
            this.f13701b = new com.stepos.common.scrollbarview.b(this.f13718s, this.f13706g);
        }
        this.f13701b.k(this.f13703d);
        this.f13701b.l(this.f13702c);
        this.f13701b.g(false);
        this.f13703d.mutate().setTint(this.f13705f);
        this.f13702c.mutate().setTint(this.f13704e);
    }

    private boolean i(float f5, float f6) {
        Drawable drawableC = this.f13701b.c();
        if (drawableC == null) {
            return false;
        }
        Rect rect = new Rect(drawableC.getBounds());
        if (this.f13718s) {
            rect.left = 0;
            rect.right = getMeasuredWidth();
        } else {
            rect.top = 0;
            rect.bottom = getMeasuredHeight();
        }
        return rect.contains((int) f5, (int) f6);
    }

    private void j(MotionEvent motionEvent, int i5) {
        if (this.f13717r == null) {
            this.f13717r = new Handler();
        }
        d(false);
        m();
        boolean zS = this.f13718s ? s(motionEvent, i5) : r(motionEvent, i5);
        if (zS && this.f13697A != 1) {
            setScrollState(1);
        }
        View view = this.f13700a;
        boolean zK0 = view instanceof StepOSRecyclerView ? ((StepOSRecyclerView) view).K0() : true;
        View view2 = this.f13700a;
        if (view2 instanceof M1.a) {
            zK0 = ((M1.a) view2).a();
        }
        View view3 = this.f13700a;
        if (view3 instanceof StepOSNestedScrollView) {
            zK0 = ((StepOSNestedScrollView) view3).b0();
        }
        if (!zS && this.f13698B != null && zK0) {
            if (this.f13718s) {
                p(motionEvent, i5);
            } else {
                o(motionEvent, i5);
            }
        }
        this.f13719t = motionEvent.getX(i5);
        this.f13720u = motionEvent.getY(i5);
    }

    private void k() {
        this.f13716q = false;
        this.f13720u = 0.0f;
        this.f13719t = 0.0f;
        Handler handler = this.f13717r;
        if (handler != null) {
            handler.removeCallbacks(this.f13715p);
        }
        this.f13715p.c();
        if (this.f13718s) {
            this.f13715p.d(this.f13701b.getBounds().width(), this.f13708i);
        } else {
            this.f13715p.d(this.f13701b.getBounds().height(), this.f13708i);
        }
        if (this.f13700a.getTranslationY() != 0.0f || this.f13700a.getTranslationX() != 0.0f) {
            q();
            return;
        }
        VelocityTracker velocityTracker = this.f13724y;
        velocityTracker.computeCurrentVelocity(1000, this.f13723x);
        n((int) (this.f13718s ? velocityTracker.getYVelocity(this.f13721v) : velocityTracker.getXVelocity(this.f13721v)));
    }

    private void l(Canvas canvas) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        d dVar;
        int i5;
        boolean z5;
        if (getVisibility() == 0 && (i5 = (dVar = this.f13714o).f13738c) != 0) {
            if (i5 == 2) {
                if (dVar.f13737b == null) {
                    dVar.f13737b = new float[1];
                }
                float[] fArr = dVar.f13737b;
                if (dVar.f13736a.timeToValues(fArr) == Interpolator.Result.FREEZE_END) {
                    this.f13714o.f13738c = 0;
                } else {
                    this.f13701b.mutate().setAlpha(Math.round(fArr[0]));
                }
                z5 = true;
            } else {
                this.f13701b.mutate().setAlpha(255);
                z5 = false;
            }
            if (this.f13715p.f13726a == 1) {
                this.f13716q = false;
                d(false);
                Object animatedValue = this.f13715p.f13728c.getAnimatedValue();
                if (animatedValue instanceof Integer) {
                    this.f13701b.j(((Integer) animatedValue).intValue());
                    if (!this.f13715p.f13728c.isRunning()) {
                        c cVar = this.f13715p;
                        boolean z6 = cVar.f13732g;
                        cVar.f13726a = z6 ? 0 : 2;
                        if (!z6) {
                            n.c(this.f13700a, n.a());
                        }
                    }
                    z5 = true;
                }
            }
            int scrollableViewScrollExtent = getScrollableViewScrollExtent();
            this.f13701b.h(getScrollableViewScrollRange(), getScrollableViewScrollOffset(), scrollableViewScrollExtent, this.f13718s ? Math.abs((int) this.f13700a.getTranslationY()) : (int) Math.abs(this.f13700a.getTranslationX()));
            this.f13701b.draw(canvas);
            if (this.f13714o.f13738c == 1) {
                f();
            }
            if (z5) {
                invalidate();
            }
        }
    }

    private void m() {
        if (this.f13715p.f13726a != 0 || this.f13716q) {
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        c cVar = this.f13715p;
        cVar.f13727b = jCurrentAnimationTimeMillis;
        cVar.f13726a = 0;
        this.f13717r.postAtTime(cVar, jCurrentAnimationTimeMillis);
        this.f13716q = true;
    }

    private void n(int i5) {
        boolean z5 = this.f13718s;
        int i6 = z5 ? 0 : i5 * 2;
        int i7 = z5 ? i5 * 2 : 0;
        int iMin = Math.min(this.f13723x, i6);
        int iMin2 = Math.min(this.f13723x, i7);
        if (this.f13718s) {
            if (Math.abs(iMin2) <= this.f13722w) {
                return;
            }
        } else if (Math.abs(iMin) <= this.f13722w) {
            return;
        }
        View view = this.f13700a;
        if (view instanceof RecyclerView) {
            ((RecyclerView) view).fling(iMin, iMin2);
        }
        View view2 = this.f13700a;
        if (view2 instanceof ScrollView) {
            ((ScrollView) view2).fling(iMin2);
        }
        View view3 = this.f13700a;
        if (view3 instanceof NestedScrollView) {
            ((NestedScrollView) view3).v(iMin2);
        }
        View view4 = this.f13700a;
        if (view4 instanceof AbsListView) {
            ((AbsListView) view4).fling(iMin2);
        }
        if (this.f13697A != 2) {
            setScrollState(2);
        }
    }

    private void o(MotionEvent motionEvent, int i5) {
        float x5 = motionEvent.getX(i5) - this.f13719t;
        boolean zCanScrollHorizontally = this.f13700a.canScrollHorizontally(-1);
        boolean zCanScrollHorizontally2 = this.f13700a.canScrollHorizontally(1);
        float translationX = this.f13700a.getTranslationX();
        if ((!zCanScrollHorizontally2 && x5 > 0.0f) || (!zCanScrollHorizontally && x5 < 0.0f)) {
            this.f13700a.setTranslationX(translationX - x5);
        }
        if (!zCanScrollHorizontally2 && x5 <= 0.0f) {
            this.f13700a.setTranslationX(Math.min(0.0f, translationX - x5));
        } else if (!zCanScrollHorizontally && x5 >= 0.0f) {
            this.f13700a.setTranslationX(Math.max(0.0f, translationX - x5));
        }
        d(true);
    }

    private void p(MotionEvent motionEvent, int i5) {
        float y5 = motionEvent.getY(i5) - this.f13720u;
        boolean zCanScrollVertically = this.f13700a.canScrollVertically(-1);
        boolean zCanScrollVertically2 = this.f13700a.canScrollVertically(1);
        float translationY = this.f13700a.getTranslationY();
        if ((!zCanScrollVertically2 && y5 > 0.0f) || (!zCanScrollVertically && y5 < 0.0f)) {
            float f5 = translationY - y5;
            this.f13700a.setTranslationY(f5);
            e(0.0f, f5);
        }
        if (!zCanScrollVertically2 && y5 <= 0.0f) {
            float fMin = Math.min(0.0f, translationY - y5);
            this.f13700a.setTranslationY(fMin);
            e(0.0f, fMin);
        } else if (!zCanScrollVertically && y5 >= 0.0f) {
            float fMax = Math.max(0.0f, translationY - y5);
            this.f13700a.setTranslationY(fMax);
            e(0.0f, fMax);
        }
        d(true);
    }

    private void q() {
        e5.c cVar = this.f13698B;
        if (cVar != null) {
            cVar.r();
        }
    }

    private boolean r(MotionEvent motionEvent, int i5) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        float x5 = motionEvent.getX(i5) - this.f13719t;
        if (Math.abs(this.f13700a.getTranslationX() - 0.0f) >= 1.0E-4f) {
            return false;
        }
        boolean zCanScrollHorizontally = this.f13700a.canScrollHorizontally(-1);
        boolean zCanScrollHorizontally2 = this.f13700a.canScrollHorizontally(1);
        if ((!zCanScrollHorizontally && x5 < 0.0f) || (!zCanScrollHorizontally2 && x5 > 0.0f)) {
            return false;
        }
        this.f13700a.scrollBy(this.f13706g.b((int) (this.f13701b.d() + x5), this.f13701b.getBounds().width(), this.f13701b.c().getBounds().width(), getScrollableViewScrollExtent(), getScrollableViewScrollRange()) - getScrollableViewScrollOffset(), 0);
        return true;
    }

    private boolean s(MotionEvent motionEvent, int i5) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        float y5 = motionEvent.getY(i5) - this.f13720u;
        if (Math.abs(this.f13700a.getTranslationY() - 0.0f) >= 1.0E-4f) {
            return false;
        }
        boolean zCanScrollVertically = this.f13700a.canScrollVertically(-1);
        boolean zCanScrollVertically2 = this.f13700a.canScrollVertically(1);
        if ((!zCanScrollVertically && y5 < 0.0f) || (!zCanScrollVertically2 && y5 > 0.0f)) {
            return false;
        }
        int iB = this.f13706g.b((int) (this.f13701b.d() + y5), this.f13701b.getBounds().height(), this.f13701b.c().getBounds().height(), getScrollableViewScrollExtent(), getScrollableViewScrollRange()) - getScrollableViewScrollOffset();
        View view = this.f13700a;
        if (view instanceof AbsListView) {
            ((ListView) view).scrollListBy(iB);
        } else {
            view.scrollBy(0, iB);
        }
        return true;
    }

    private void t(MotionEvent motionEvent, int i5) {
        if (motionEvent.getPointerId(i5) == this.f13721v) {
            int i6 = i5 == 0 ? 1 : 0;
            this.f13721v = motionEvent.getPointerId(i6);
            this.f13719t = motionEvent.getX(i6);
            this.f13720u = motionEvent.getY(i6);
        }
    }

    public void c() {
        d(true);
    }

    public void d(boolean z5) {
        if (this.f13717r == null) {
            this.f13717r = new Handler();
        }
        if (this.f13710k) {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() + 2000;
            d dVar = this.f13714o;
            dVar.f13739d = jCurrentAnimationTimeMillis;
            dVar.f13738c = 1;
            this.f13717r.removeCallbacks(dVar);
            this.f13717r.postAtTime(this.f13714o, jCurrentAnimationTimeMillis);
        } else {
            this.f13714o.f13738c = 1;
        }
        if (z5) {
            invalidate();
        }
    }

    void f() {
        int iD = this.f13701b.d();
        boolean z5 = this.f13718s;
        int i5 = z5 ? 0 : iD;
        if (!z5) {
            iD = 0;
        }
        List<b> list = this.f13725z;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f13725z.get(size).a(this, i5, iD);
            }
        }
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        Insets insets = windowInsets.getInsets(WindowInsets.Type.systemBars());
        if (this.f13712m && insets.top != getPaddingTop()) {
            setPadding(getPaddingLeft(), insets.top, getPaddingRight(), getPaddingBottom());
        }
        if (this.f13713n && insets.bottom != getPaddingBottom()) {
            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), insets.bottom);
        }
        return super.onApplyWindowInsets(windowInsets);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Handler handler = this.f13717r;
        if (handler != null) {
            handler.removeCallbacks(this.f13714o);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onDraw(canvas);
        l(canvas);
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        super.onLayout(z5, i5, i6, i7, i8);
        int paddingBottom = getPaddingBottom();
        int paddingTop = getPaddingTop();
        int paddingStart = getPaddingStart();
        int paddingEnd = getPaddingEnd();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int i9 = this.f13697A == 1 ? this.f13709j : this.f13708i;
        com.stepos.common.scrollbarview.b bVar = this.f13701b;
        if (bVar != null) {
            if (!this.f13718s) {
                int i10 = (measuredHeight - paddingBottom) - i9;
                bVar.setBounds(paddingStart, i10, measuredWidth - paddingEnd, i9 + i10);
            } else {
                if (!f13696K) {
                    paddingEnd = (measuredWidth - paddingEnd) - i9;
                }
                bVar.setBounds(paddingEnd, paddingTop, i9 + paddingEnd, measuredHeight - paddingBottom);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) {
        int size;
        int size2;
        int measuredHeight;
        super.onMeasure(i5, i6);
        boolean z5 = this.f13718s;
        if (!z5) {
            if (z5) {
                size2 = View.MeasureSpec.getSize(i6);
                size = this.f13707h;
            } else {
                size = View.MeasureSpec.getSize(i5);
                size2 = this.f13707h;
            }
            setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
            return;
        }
        int i7 = this.f13707h;
        int size3 = View.MeasureSpec.getSize(i6);
        if (View.MeasureSpec.getMode(i6) == Integer.MIN_VALUE) {
            size3 = 0;
            if (getParent() != null && (getParent() instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) getParent();
                int i8 = 0;
                while (size3 < viewGroup.getChildCount()) {
                    View childAt = viewGroup.getChildAt(size3);
                    if (childAt != this && (measuredHeight = childAt.getMeasuredHeight()) > i8) {
                        i8 = measuredHeight;
                    }
                    size3++;
                }
                size3 = i8;
            }
        }
        setMeasuredDimension(i7, size3);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00ba  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.scrollbarview.StepOSScrollBarView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAdapter(com.stepos.common.scrollbarview.a aVar) {
        this.f13706g = aVar;
        this.f13701b.i(aVar);
    }

    public void setFadeEnable(boolean z5) {
        this.f13710k = z5;
        c();
    }

    public void setFitSystemBottomPadding(boolean z5) {
        this.f13713n = z5;
        if (z5) {
            requestApplyInsets();
        }
    }

    public void setFitSystemTopPadding(boolean z5) {
        this.f13712m = z5;
        if (z5) {
            requestApplyInsets();
        }
    }

    public void setOperable(boolean z5) {
        this.f13711l = z5;
    }

    void setScrollState(int i5) {
        this.f13697A = i5;
        List<b> list = this.f13725z;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f13725z.get(size).b(this, i5);
            }
        }
    }

    void setScrollableView(View view) {
        this.f13700a = view;
        if (view instanceof StepOSRecyclerView) {
            this.f13698B = ((StepOSRecyclerView) view).getSpringAnimationHelper();
        }
        c();
    }

    public StepOSScrollBarView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f13710k = true;
        this.f13711l = true;
        this.f13718s = true;
        this.f13697A = 0;
        N1.a.e(this, 2);
        this.f13706g = new com.stepos.common.scrollbarview.a();
        g(context, attributeSet, i5);
        f13696K = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        this.f13714o = new d(this);
        this.f13715p = new c(this, this.f13708i, this.f13709j, this.f13701b);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f13722w = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f13723x = viewConfiguration.getScaledMaximumFlingVelocity();
    }
}
