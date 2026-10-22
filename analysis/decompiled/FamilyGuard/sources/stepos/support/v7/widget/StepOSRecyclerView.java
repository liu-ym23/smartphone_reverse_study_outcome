package stepos.support.v7.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.StateSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.Checkable;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.view.C0473s;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.stepos.common.animator.StepOSPressAnimationDrawable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import stepos.support.v7.widget.s;

/* loaded from: classes.dex */
public class StepOSRecyclerView extends RecyclerView {

    /* renamed from: C0, reason: collision with root package name */
    private static boolean f21682C0 = false;

    /* renamed from: D0, reason: collision with root package name */
    private static float f21683D0 = Float.MAX_VALUE;

    /* renamed from: E0, reason: collision with root package name */
    private static int f21684E0 = -1;

    /* renamed from: A, reason: collision with root package name */
    private int f21685A;

    /* renamed from: A0, reason: collision with root package name */
    private boolean f21686A0;

    /* renamed from: B, reason: collision with root package name */
    protected int f21687B;

    /* renamed from: B0, reason: collision with root package name */
    private boolean f21688B0;

    /* renamed from: C, reason: collision with root package name */
    protected int f21689C;

    /* renamed from: D, reason: collision with root package name */
    private int f21690D;

    /* renamed from: E, reason: collision with root package name */
    private int f21691E;

    /* renamed from: F, reason: collision with root package name */
    private int f21692F;

    /* renamed from: G, reason: collision with root package name */
    private s f21693G;

    /* renamed from: H, reason: collision with root package name */
    private boolean f21694H;

    /* renamed from: I, reason: collision with root package name */
    protected int f21695I;

    /* renamed from: J, reason: collision with root package name */
    private e f21696J;

    /* renamed from: K, reason: collision with root package name */
    private boolean f21697K;

    /* renamed from: L, reason: collision with root package name */
    boolean f21698L;

    /* renamed from: M, reason: collision with root package name */
    Drawable f21699M;

    /* renamed from: Q, reason: collision with root package name */
    Rect f21700Q;

    /* renamed from: R, reason: collision with root package name */
    int f21701R;

    /* renamed from: S, reason: collision with root package name */
    int f21702S;

    /* renamed from: T, reason: collision with root package name */
    int f21703T;

    /* renamed from: U, reason: collision with root package name */
    int f21704U;

    /* renamed from: V, reason: collision with root package name */
    int f21705V;

    /* renamed from: W, reason: collision with root package name */
    private Method f21706W;

    /* renamed from: a, reason: collision with root package name */
    private final double f21707a;

    /* renamed from: a0, reason: collision with root package name */
    private f f21708a0;

    /* renamed from: b, reason: collision with root package name */
    private int f21709b;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f21710b0;

    /* renamed from: c, reason: collision with root package name */
    private int f21711c;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f21712c0;

    /* renamed from: d, reason: collision with root package name */
    private ActionMode f21713d;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f21714d0;

    /* renamed from: e, reason: collision with root package name */
    private MultiChoiceModeWrapper f21715e;

    /* renamed from: e0, reason: collision with root package name */
    private float f21716e0;

    /* renamed from: f, reason: collision with root package name */
    private int f21717f;

    /* renamed from: f0, reason: collision with root package name */
    private float f21718f0;

    /* renamed from: g, reason: collision with root package name */
    private SparseBooleanArray f21719g;

    /* renamed from: g0, reason: collision with root package name */
    private r f21720g0;

    /* renamed from: h, reason: collision with root package name */
    private boolean f21721h;

    /* renamed from: h0, reason: collision with root package name */
    private float f21722h0;

    /* renamed from: i, reason: collision with root package name */
    private q.f<Integer> f21723i;

    /* renamed from: i0, reason: collision with root package name */
    private HashSet<RecyclerView.ViewHolder> f21724i0;

    /* renamed from: j, reason: collision with root package name */
    private stepos.support.v7.widget.s f21725j;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f21726j0;

    /* renamed from: k, reason: collision with root package name */
    private Runnable f21727k;

    /* renamed from: k0, reason: collision with root package name */
    private int f21728k0;

    /* renamed from: l, reason: collision with root package name */
    protected Rect f21729l;

    /* renamed from: l0, reason: collision with root package name */
    private int[][] f21730l0;

    /* renamed from: m, reason: collision with root package name */
    protected int f21731m;

    /* renamed from: m0, reason: collision with root package name */
    private int f21732m0;

    /* renamed from: n, reason: collision with root package name */
    protected int f21733n;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f21734n0;

    /* renamed from: o, reason: collision with root package name */
    private boolean f21735o;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f21736o0;

    /* renamed from: p, reason: collision with root package name */
    private boolean f21737p;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f21738p0;

    /* renamed from: q, reason: collision with root package name */
    private boolean f21739q;

    /* renamed from: q0, reason: collision with root package name */
    private ArrayList<d> f21740q0;

    /* renamed from: r, reason: collision with root package name */
    private int f21741r;

    /* renamed from: r0, reason: collision with root package name */
    private ArrayList<d> f21742r0;

    /* renamed from: s, reason: collision with root package name */
    private int f21743s;

    /* renamed from: s0, reason: collision with root package name */
    private final e5.c f21744s0;

    /* renamed from: t, reason: collision with root package name */
    private int f21745t;

    /* renamed from: t0, reason: collision with root package name */
    private final OverScroller f21746t0;

    /* renamed from: u, reason: collision with root package name */
    private int f21747u;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f21748u0;

    /* renamed from: v, reason: collision with root package name */
    private int f21749v;

    /* renamed from: v0, reason: collision with root package name */
    private boolean f21750v0;

    /* renamed from: w, reason: collision with root package name */
    private int f21751w;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f21752w0;

    /* renamed from: x, reason: collision with root package name */
    private int f21753x;

    /* renamed from: x0, reason: collision with root package name */
    private stepos.support.v7.widget.n f21754x0;

    /* renamed from: y, reason: collision with root package name */
    private int f21755y;

    /* renamed from: y0, reason: collision with root package name */
    private boolean f21756y0;

    /* renamed from: z, reason: collision with root package name */
    private boolean f21757z;

    /* renamed from: z0, reason: collision with root package name */
    private int f21758z0;

    class MultiChoiceModeWrapper implements l {

        /* renamed from: a, reason: collision with root package name */
        private l f21759a;

        MultiChoiceModeWrapper() {
        }

        public boolean a() {
            return this.f21759a != null;
        }

        public void b(l lVar) {
            this.f21759a = lVar;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f21759a.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            if (!this.f21759a.onCreateActionMode(actionMode, menu)) {
                return false;
            }
            if (StepOSRecyclerView.this.f21711c == 4 || StepOSRecyclerView.this.f21711c == 5) {
                StepOSRecyclerView.this.setLongClickable(true);
            } else {
                StepOSRecyclerView.this.setLongClickable(false);
            }
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) throws NoSuchFieldException, SecurityException {
            if (StepOSRecyclerView.this.f21750v0) {
                StepOSRecyclerView.this.f21744s0.g0(true);
            }
            this.f21759a.onDestroyActionMode(actionMode);
            StepOSRecyclerView.this.f21713d = null;
            StepOSRecyclerView.this.f21752w0 = true;
            StepOSRecyclerView.this.n0();
            StepOSRecyclerView.this.j1();
            StepOSRecyclerView.this.setLongClickable(true);
            x.e(RecyclerView.class, StepOSRecyclerView.this);
            StepOSRecyclerView.this.getRecycledViewPool().clear();
        }

        @Override // stepos.support.v7.widget.StepOSRecyclerView.l
        public void onItemCheckedStateChanged(ActionMode actionMode, int i5, long j5, boolean z5) {
            this.f21759a.onItemCheckedStateChanged(actionMode, i5, j5, z5);
            if (StepOSRecyclerView.this.getCheckedItemCount() == 0) {
                int unused = StepOSRecyclerView.this.f21711c;
            }
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.f21759a.onPrepareActionMode(actionMode, menu);
        }
    }

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f21761a;

        /* renamed from: stepos.support.v7.widget.StepOSRecyclerView$a$a, reason: collision with other inner class name */
        class RunnableC0246a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ RecyclerView.ItemAnimator f21763a;

            RunnableC0246a(RecyclerView.ItemAnimator itemAnimator) {
                this.f21763a = itemAnimator;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f21763a.endAnimations();
            }
        }

        a(boolean z5) {
            this.f21761a = z5;
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView.Adapter adapter = StepOSRecyclerView.this.getAdapter();
            if (adapter != null) {
                adapter.notifyItemRangeChanged(0, StepOSRecyclerView.this.getItemCount());
                RecyclerView.ItemAnimator itemAnimator = StepOSRecyclerView.this.getItemAnimator();
                if (itemAnimator != null) {
                    StepOSRecyclerView.this.post(new RunnableC0246a(itemAnimator));
                }
                if (this.f21761a) {
                    StepOSRecyclerView.this.requestLayout();
                }
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StepOSRecyclerView.this.d1();
            StepOSRecyclerView.this.f21727k = null;
        }
    }

    public static abstract class c<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements u {
        private int mHeadCount;
        private RecyclerView rv;

        public boolean areAllItemsEnabled() {
            return true;
        }

        public int immersiveItemType(int i5) {
            return 3;
        }

        public boolean isEnabled(int i5) {
            return true;
        }

        @Override // stepos.support.v7.widget.StepOSRecyclerView.u
        public boolean isSelectable(int i5) {
            return true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
            this.rv = recyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(VH vh, int i5) throws Resources.NotFoundException {
            StepOSRecyclerView stepOSRecyclerView = (StepOSRecyclerView) this.rv;
            stepOSRecyclerView.Z0(vh.itemView, this.mHeadCount + i5);
            if (stepOSRecyclerView.f21688B0) {
                stepOSRecyclerView.W0(vh.itemView, immersiveItemType(i5));
            }
        }

        void setHeadCount(int i5) {
            this.mHeadCount = i5;
        }
    }

    public class d {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.ViewHolder f21766a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f21767b;

        public d() {
        }
    }

    private class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private OverScroller f21769a;

        /* renamed from: b, reason: collision with root package name */
        private int f21770b = 0;

        e() {
            this.f21769a = new OverScroller(StepOSRecyclerView.this.getContext());
        }

        void a() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            StepOSRecyclerView.this.f21709b = -1;
            StepOSRecyclerView.this.removeCallbacks(this);
            x.g(0, RecyclerView.class, StepOSRecyclerView.this);
            this.f21769a.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            OverScroller overScroller = this.f21769a;
            if (overScroller.isFinished()) {
                a();
                return;
            }
            overScroller.computeScrollOffset();
            int currY = overScroller.getCurrY();
            int currY2 = overScroller.getCurrY() - this.f21770b;
            this.f21770b = currY;
            if (currY2 != 0) {
                StepOSRecyclerView.this.g1(-currY2, true);
            }
            StepOSRecyclerView.this.invalidate();
            StepOSRecyclerView.this.postOnAnimation(this);
        }
    }

    class f {

        /* renamed from: a, reason: collision with root package name */
        View f21772a;

        /* renamed from: b, reason: collision with root package name */
        int f21773b;

        /* renamed from: c, reason: collision with root package name */
        long f21774c;

        public f(View view, int i5, long j5) {
            this.f21772a = view;
            this.f21773b = i5;
            this.f21774c = j5;
        }
    }

    public static abstract class g extends RecyclerView.ItemDecoration {

        /* renamed from: a, reason: collision with root package name */
        private HashSet<Integer> f21776a = new HashSet<>();

        /* renamed from: b, reason: collision with root package name */
        private HashSet<Integer> f21777b = new HashSet<>();

        public void a() {
            this.f21777b.clear();
        }

        public HashSet<Integer> b() {
            return this.f21776a;
        }

        public void c(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        }

        public void d(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        }

        public void e(HashSet<Integer> hashSet) {
            this.f21777b.addAll(hashSet);
        }
    }

    public interface h {
    }

    private class i extends stepos.support.v7.widget.s {

        /* renamed from: q, reason: collision with root package name */
        private j f21778q;

        /* renamed from: r, reason: collision with root package name */
        private int f21779r;

        /* renamed from: s, reason: collision with root package name */
        private int f21780s;

        /* renamed from: t, reason: collision with root package name */
        private int f21781t;

        /* renamed from: u, reason: collision with root package name */
        private int f21782u;

        /* renamed from: v, reason: collision with root package name */
        private VelocityTracker f21783v;

        public i(Context context, j jVar) {
            super(context, jVar);
            this.f21782u = -1;
            this.f21778q = jVar;
            this.f21781t = ViewConfiguration.get(context).getScaledTouchSlop();
        }

        @Override // stepos.support.v7.widget.s
        public boolean h(MotionEvent motionEvent) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (this.f21783v == null) {
                this.f21783v = VelocityTracker.obtain();
            }
            this.f21783v.addMovement(motionEvent);
            boolean zH = super.h(motionEvent);
            RecyclerView.LayoutManager layoutManager = StepOSRecyclerView.this.getLayoutManager();
            boolean z5 = false;
            if (layoutManager == null) {
                return false;
            }
            boolean zCanScrollHorizontally = layoutManager.canScrollHorizontally();
            boolean zCanScrollVertically = layoutManager.canScrollVertically();
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f21779r = (int) (motionEvent.getX() + 0.5f);
                this.f21780s = (int) (motionEvent.getY() + 0.5f);
                this.f21782u = C0473s.e(motionEvent, 0);
                return zH;
            }
            if (action == 1) {
                this.f21783v.computeCurrentVelocity(1000, StepOSRecyclerView.this.getMaxFlingVelocity());
                float f5 = zCanScrollHorizontally ? -this.f21783v.getXVelocity(this.f21782u) : 0.0f;
                if ((Math.abs(zCanScrollVertically ? -this.f21783v.getYVelocity(this.f21782u) : 0.0f) >= StepOSRecyclerView.this.getMinFlingVelocity() || Math.abs(f5) >= StepOSRecyclerView.this.getMinFlingVelocity()) && StepOSRecyclerView.this.f21709b == 3) {
                    StepOSRecyclerView.this.f21709b = 4;
                }
                this.f21778q.g();
                VelocityTracker velocityTracker = this.f21783v;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                }
                StepOSRecyclerView stepOSRecyclerView = StepOSRecyclerView.this;
                stepOSRecyclerView.f21733n = stepOSRecyclerView.f21731m;
                stepOSRecyclerView.t0(true);
                return zH;
            }
            if (action == 2) {
                int x5 = (int) (motionEvent.getX() + 0.5f);
                int y5 = (int) (motionEvent.getY() + 0.5f);
                int i5 = this.f21779r - x5;
                int i6 = this.f21780s - y5;
                if (zCanScrollHorizontally && Math.abs(i5) > this.f21781t) {
                    z5 = true;
                }
                boolean z6 = (!zCanScrollVertically || Math.abs(i6) <= this.f21781t) ? z5 : true;
                if (StepOSRecyclerView.this.f21709b == 2 && z6) {
                    this.f21778q.j();
                }
                if (z6) {
                    this.f21779r = x5;
                    this.f21780s = y5;
                }
            } else if (action == 3) {
                this.f21778q.f();
                VelocityTracker velocityTracker2 = this.f21783v;
                if (velocityTracker2 != null) {
                    velocityTracker2.clear();
                }
                StepOSRecyclerView stepOSRecyclerView2 = StepOSRecyclerView.this;
                stepOSRecyclerView2.f21733n = stepOSRecyclerView2.f21731m;
                stepOSRecyclerView2.t0(true);
                return zH;
            }
            return zH;
        }
    }

    public interface k {
    }

    public interface l extends ActionMode.Callback {
        void onItemCheckedStateChanged(ActionMode actionMode, int i5, long j5, boolean z5);
    }

    public interface m {
    }

    public interface n {
    }

    public interface o {
    }

    public interface p {
    }

    class q {

        /* renamed from: a, reason: collision with root package name */
        private View f21789a;

        /* renamed from: b, reason: collision with root package name */
        private float f21790b;

        /* renamed from: c, reason: collision with root package name */
        private float f21791c;

        /* renamed from: d, reason: collision with root package name */
        private float f21792d;

        /* renamed from: e, reason: collision with root package name */
        private float f21793e;

        /* renamed from: f, reason: collision with root package name */
        private float f21794f;

        /* renamed from: g, reason: collision with root package name */
        private float f21795g;

        /* renamed from: h, reason: collision with root package name */
        private float f21796h;

        /* renamed from: i, reason: collision with root package name */
        private float f21797i;

        public float a() {
            return this.f21796h;
        }

        public float b() {
            return this.f21791c;
        }

        public float c() {
            return this.f21792d;
        }

        public float d() {
            return this.f21795g;
        }

        public float e() {
            return this.f21794f;
        }

        public float f() {
            return this.f21790b;
        }

        public float g() {
            return this.f21793e;
        }

        public void h(float f5) {
            this.f21795g = f5;
        }

        public void i(float f5) {
            this.f21794f = f5;
        }

        public void j(float f5) {
            this.f21797i = f5;
        }

        public void k(float f5) {
            if (this.f21789a == null) {
                return;
            }
            if (this.f21797i == StepOSRecyclerView.f21683D0) {
                this.f21797i = this.f21789a.getTranslationY();
            }
            this.f21796h = f5;
            View view = this.f21789a;
            if (view instanceof ScrollView) {
                view.scrollBy(0, (int) f5);
            } else {
                view.setTranslationY(this.f21797i + f5);
            }
        }
    }

    class r {

        /* renamed from: e, reason: collision with root package name */
        private ValueAnimator f21802e;

        /* renamed from: i, reason: collision with root package name */
        private int f21806i;

        /* renamed from: a, reason: collision with root package name */
        private HashMap<View, q> f21798a = new HashMap<>();

        /* renamed from: b, reason: collision with root package name */
        private ArrayList<q> f21799b = new ArrayList<>();

        /* renamed from: c, reason: collision with root package name */
        private TimeInterpolator f21800c = new LinearInterpolator();

        /* renamed from: d, reason: collision with root package name */
        private int f21801d = 500;

        /* renamed from: f, reason: collision with root package name */
        private int f21803f = 3;

        /* renamed from: g, reason: collision with root package name */
        private float f21804g = 0.0f;

        /* renamed from: h, reason: collision with root package name */
        private int f21805h = 5;

        /* renamed from: j, reason: collision with root package name */
        private boolean f21807j = true;

        class a implements ValueAnimator.AnimatorUpdateListener {
            a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                for (q qVar : r.this.f21798a.values()) {
                    qVar.k(((Float) valueAnimator.getAnimatedValue()).floatValue() * qVar.e());
                }
            }
        }

        class b extends AnimatorListenerAdapter {
            b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                r.this.f21807j = true;
                for (q qVar : r.this.f21798a.values()) {
                    qVar.h(qVar.a());
                    if (qVar.a() != 0.0f) {
                        r.this.f21807j = false;
                    } else {
                        qVar.j(StepOSRecyclerView.f21683D0);
                    }
                }
                if (r.this.f21807j) {
                    r.this.f21803f = 3;
                }
                if (r.this.f21807j) {
                    StepOSRecyclerView.Y(StepOSRecyclerView.this);
                }
            }
        }

        r() {
        }

        private float e(q qVar, float f5) {
            float f6;
            float fA = qVar.a();
            if (fA == 0.0f) {
                if (f5 > 0.0f) {
                    if (qVar.c() == 0.0f) {
                        return 0.0f;
                    }
                    float fD = qVar.d();
                    if (fD < 0.0f) {
                        fD *= Math.abs(qVar.c() / qVar.g());
                    }
                    float fB = fD + (qVar.b() * (f5 / this.f21805h));
                    return fB > qVar.c() ? qVar.c() : fB;
                }
                if (qVar.g() == 0.0f) {
                    return 0.0f;
                }
                float fD2 = qVar.d();
                if (fD2 > 0.0f) {
                    fD2 *= Math.abs(qVar.g() / qVar.c());
                }
                float f7 = fD2 + (qVar.f() * (f5 / this.f21805h));
                return f7 < qVar.g() ? qVar.g() : f7;
            }
            if (fA > 0.0f) {
                if (qVar.c() == 0.0f) {
                    return 0.0f;
                }
                float fD3 = qVar.d();
                if (fD3 < 0.0f) {
                    fD3 *= Math.abs(qVar.c() / qVar.g());
                }
                float fB2 = fD3 + (qVar.b() * (f5 / this.f21805h));
                f6 = fB2 >= 0.0f ? fB2 : 0.0f;
                return f6 > qVar.c() ? qVar.c() : f6;
            }
            if (qVar.g() == 0.0f) {
                return 0.0f;
            }
            float fD4 = qVar.d();
            if (fD4 > 0.0f) {
                fD4 *= Math.abs(qVar.g() / qVar.c());
            }
            float f8 = fD4 + (qVar.f() * (f5 / this.f21805h));
            f6 = f8 <= 0.0f ? f8 : 0.0f;
            return f6 < qVar.g() ? qVar.g() : f6;
        }

        public void f() {
            ValueAnimator valueAnimator = this.f21802e;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                return;
            }
            this.f21802e.cancel();
        }

        public boolean g() {
            return this.f21807j;
        }

        public void h() {
            Iterator<q> it = this.f21798a.values().iterator();
            while (it.hasNext()) {
                it.next().j(StepOSRecyclerView.f21683D0);
            }
        }

        public void i(int i5) {
            this.f21801d = i5;
        }

        public void j(boolean z5) {
            this.f21807j = z5;
        }

        public void k(int i5) {
            this.f21805h = i5;
        }

        public void l(TimeInterpolator timeInterpolator) {
            this.f21800c = timeInterpolator;
        }

        public void m() {
            if (this.f21803f == 3) {
                h();
                this.f21807j = true;
                StepOSRecyclerView.Y(StepOSRecyclerView.this);
                return;
            }
            this.f21806i = (int) (this.f21801d * this.f21804g);
            for (q qVar : this.f21798a.values()) {
                qVar.i(qVar.a());
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.f21802e = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new a());
            this.f21802e.addListener(new b());
            this.f21802e.setDuration(this.f21806i);
            this.f21802e.setInterpolator(this.f21800c);
            this.f21802e.start();
        }

        public void n(float f5) {
            if (f5 == 0.0f && this.f21803f == 3) {
                return;
            }
            this.f21803f = 3;
            this.f21804g = 0.0f;
            for (q qVar : this.f21798a.values()) {
                float fE = e(qVar, f5);
                if (fE > 0.0f) {
                    this.f21803f = 1;
                    this.f21804g = Math.abs(fE / qVar.c());
                } else if (fE < 0.0f) {
                    this.f21803f = 2;
                    this.f21804g = Math.abs(fE / qVar.g());
                }
                qVar.k(fE);
            }
        }
    }

    final class s implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private boolean f21811a = true;

        /* renamed from: b, reason: collision with root package name */
        private boolean f21812b = false;

        s() {
        }

        public void a() {
            this.f21812b = false;
            StepOSRecyclerView.this.removeCallbacks(this);
        }

        public boolean b() {
            return this.f21812b;
        }

        public void c(boolean z5) {
            this.f21811a = z5;
            this.f21812b = true;
            StepOSRecyclerView.this.post(this);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0075 A[PHI: r1
          0x0075: PHI (r1v4 boolean) = (r1v2 boolean), (r1v2 boolean), (r1v7 boolean), (r1v7 boolean) binds: [B:22:0x005d, B:24:0x0072, B:11:0x002c, B:13:0x0034] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() throws java.lang.NoSuchMethodException, java.lang.SecurityException {
            /*
                r10 = this;
                boolean r0 = r10.f21811a
                r1 = -1
                r2 = 1
                r3 = 0
                if (r0 == 0) goto L37
                java.lang.Class<androidx.recyclerview.widget.RecyclerView> r8 = androidx.recyclerview.widget.RecyclerView.class
                stepos.support.v7.widget.StepOSRecyclerView r9 = stepos.support.v7.widget.StepOSRecyclerView.this
                r4 = 0
                r5 = -8
                r6 = 0
                r7 = 0
                boolean r0 = stepos.support.v7.widget.x.f(r4, r5, r6, r7, r8, r9)
                stepos.support.v7.widget.StepOSRecyclerView r4 = stepos.support.v7.widget.StepOSRecyclerView.this
                stepos.support.v7.widget.StepOSRecyclerView.V(r4, r5, r3)
                stepos.support.v7.widget.StepOSRecyclerView r4 = stepos.support.v7.widget.StepOSRecyclerView.this
                int r4 = r4.u0(r2)
                if (r4 != r1) goto L22
                r1 = r2
                goto L23
            L22:
                r1 = r3
            L23:
                stepos.support.v7.widget.StepOSRecyclerView r5 = stepos.support.v7.widget.StepOSRecyclerView.this
                int r6 = r5.f21687B
                if (r6 == r4) goto L2c
                r5.h1(r6, r4)
            L2c:
                if (r0 != 0) goto L75
                stepos.support.v7.widget.StepOSRecyclerView r0 = stepos.support.v7.widget.StepOSRecyclerView.this
                int r0 = r0.getFirstPosition()
                if (r0 != 0) goto L75
                goto L76
            L37:
                java.lang.Class<androidx.recyclerview.widget.RecyclerView> r8 = androidx.recyclerview.widget.RecyclerView.class
                stepos.support.v7.widget.StepOSRecyclerView r9 = stepos.support.v7.widget.StepOSRecyclerView.this
                r4 = 0
                r5 = 8
                r6 = 0
                r7 = 0
                boolean r0 = stepos.support.v7.widget.x.f(r4, r5, r6, r7, r8, r9)
                stepos.support.v7.widget.StepOSRecyclerView r4 = stepos.support.v7.widget.StepOSRecyclerView.this
                stepos.support.v7.widget.StepOSRecyclerView.V(r4, r5, r3)
                stepos.support.v7.widget.StepOSRecyclerView r4 = stepos.support.v7.widget.StepOSRecyclerView.this
                int r4 = r4.u0(r3)
                if (r4 != r1) goto L53
                r1 = r2
                goto L54
            L53:
                r1 = r3
            L54:
                stepos.support.v7.widget.StepOSRecyclerView r5 = stepos.support.v7.widget.StepOSRecyclerView.this
                int r6 = r5.f21689C
                if (r6 == r4) goto L5d
                r5.q0(r6, r4)
            L5d:
                if (r0 != 0) goto L75
                stepos.support.v7.widget.StepOSRecyclerView r0 = stepos.support.v7.widget.StepOSRecyclerView.this
                int r0 = r0.getFirstPosition()
                stepos.support.v7.widget.StepOSRecyclerView r4 = stepos.support.v7.widget.StepOSRecyclerView.this
                int r4 = stepos.support.v7.widget.StepOSRecyclerView.X(r4)
                int r0 = r0 + r4
                stepos.support.v7.widget.StepOSRecyclerView r4 = stepos.support.v7.widget.StepOSRecyclerView.this
                int r4 = stepos.support.v7.widget.StepOSRecyclerView.O(r4)
                if (r0 != r4) goto L75
                goto L76
            L75:
                r2 = r1
            L76:
                if (r2 != 0) goto L7d
                stepos.support.v7.widget.StepOSRecyclerView r0 = stepos.support.v7.widget.StepOSRecyclerView.this
                r0.postOnAnimation(r10)
            L7d:
                stepos.support.v7.widget.StepOSRecyclerView r10 = stepos.support.v7.widget.StepOSRecyclerView.this
                android.content.Context r10 = r10.getContext()
                r0 = 2
                r1 = 300(0x12c, float:4.2E-43)
                a5.c.a(r10, r0, r1, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.StepOSRecyclerView.s.run():void");
        }
    }

    public interface t {
        void adjustListItemSelectionBounds(Rect rect);
    }

    public interface u {
        boolean isEnabled(int i5);

        boolean isSelectable(int i5);
    }

    public StepOSRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    static /* synthetic */ int B(StepOSRecyclerView stepOSRecyclerView) {
        int i5 = stepOSRecyclerView.f21717f;
        stepOSRecyclerView.f21717f = i5 + 1;
        return i5;
    }

    static /* synthetic */ int C(StepOSRecyclerView stepOSRecyclerView) {
        int i5 = stepOSRecyclerView.f21717f;
        stepOSRecyclerView.f21717f = i5 - 1;
        return i5;
    }

    static /* synthetic */ k E(StepOSRecyclerView stepOSRecyclerView) {
        stepOSRecyclerView.getClass();
        return null;
    }

    private Drawable E0(String str) throws Resources.NotFoundException {
        return getResources().getDrawable(getResources().getIdentifier(str, "drawable", getContext().getPackageName()));
    }

    private boolean F0() {
        if (!this.f21726j0 && this.f21713d == null) {
            return false;
        }
        if (((getLayoutManager() instanceof LinearLayoutManager) || (getLayoutManager() instanceof StaggeredGridLayoutManager)) && !this.f21744s0.P()) {
            return this.f21735o || this.f21739q;
        }
        return false;
    }

    private void G0() {
        Resources resources = getResources();
        this.f21735o = false;
        this.f21731m = resources.getDimensionPixelSize(V4.a.f5545a);
        this.f21695I = resources.getDimensionPixelSize(V4.a.f5546b);
        this.f21739q = false;
        this.f21741r = 0;
        this.f21743s = 0;
        this.f21745t = 0;
        this.f21747u = 0;
        this.f21749v = -1;
        this.f21751w = -1;
        this.f21685A = 0;
        this.f21693G = null;
        this.f21694H = false;
        this.f21690D = -1;
        this.f21687B = -1;
        this.f21689C = -1;
        this.f21692F = getResources().getDimensionPixelSize(V4.a.f5547c);
    }

    private void H0() {
        this.f21744s0.c0(0.99f);
        this.f21744s0.i0(228.0f);
        this.f21744s0.d0(0.5f);
    }

    private boolean L0(Configuration configuration) {
        return (configuration.uiMode & 48) == 32;
    }

    static /* synthetic */ o M(StepOSRecyclerView stepOSRecyclerView) {
        stepOSRecyclerView.getClass();
        return null;
    }

    private boolean M0(View view) {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null && layoutManager != null && layoutManager.canScrollVertically()) {
            if (layoutManager.getChildCount() >= adapter.getItemCount()) {
                Log.i("StepOSRecyclerView", "item view do not fill screen.");
                return false;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
            Point point = new Point();
            windowManager.getDefaultDisplay().getRealSize(point);
            if (point.y - (iArr[1] + view.getMeasuredHeight()) < p0(getContext(), 64.0f)) {
                return true;
            }
        }
        return false;
    }

    private void N0() {
        O0(this.f21721h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(boolean z5) {
        if (f21682C0) {
            return;
        }
        post(new a(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean P0(int i5, int i6) {
        View viewV0 = v0(i5, i6);
        if (viewV0 == null) {
            return false;
        }
        this.f21749v = y0(viewV0);
        this.f21745t = D0(viewV0);
        this.f21747u = z0(viewV0);
        this.f21741r = C0(viewV0);
        this.f21743s = A0(viewV0);
        return true;
    }

    private void Q0(Canvas canvas) {
        int itemDecorationCount = getItemDecorationCount();
        for (int i5 = 0; i5 < itemDecorationCount; i5++) {
            if (getItemDecorationAt(i5) instanceof g) {
                ((g) getItemDecorationAt(i5)).d(canvas, this, x.c(RecyclerView.class, this));
            }
        }
    }

    private void R0() {
        if (this.f21711c == 5 && !this.f21752w0 && this.f21727k == null) {
            b bVar = new b();
            this.f21727k = bVar;
            post(bVar);
        }
    }

    private void U0() {
        int i5 = 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, getAdapter().getItemCount(), 2);
        int[][] iArr2 = this.f21730l0;
        if (iArr2 == null || iArr2.length >= iArr.length) {
            return;
        }
        while (true) {
            int[][] iArr3 = this.f21730l0;
            if (i5 >= iArr3.length) {
                this.f21730l0 = iArr;
                return;
            } else {
                iArr[i5] = iArr3[i5];
                i5++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0(View view) {
        if (this.f21748u0 && M0(view)) {
            smoothScrollBy(0, p0(getContext(), 84.0f));
        }
    }

    static /* synthetic */ p Y(StepOSRecyclerView stepOSRecyclerView) {
        stepOSRecyclerView.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c1(MotionEvent motionEvent) {
        boolean z5;
        int x5 = (int) motionEvent.getX();
        int y5 = (int) motionEvent.getY();
        Rect rect = this.f21729l;
        if (this.f21713d == null && !this.f21726j0) {
            return false;
        }
        boolean z6 = this.f21737p;
        Class cls = Integer.TYPE;
        if (z6 && !this.f21739q && this.f21736o0 && this.f21738p0) {
            if (a1(motionEvent)) {
                this.f21691E = this.f21749v;
                this.f21751w = y5;
                this.f21685A = y5;
                this.f21739q = true;
                this.f21730l0 = (int[][]) Array.newInstance((Class<?>) cls, getAdapter().getItemCount(), 2);
                this.f21733n = getWidth();
                t0(true);
                super.onTouchEvent(MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0));
                this.f21709b = 3;
            }
        } else {
            if (z6 && !this.f21739q && this.f21751w >= 0) {
                this.f21691E = this.f21749v;
                this.f21751w = y5;
                this.f21685A = y5;
                this.f21739q = true;
                this.f21730l0 = (int[][]) Array.newInstance((Class<?>) cls, getAdapter().getItemCount(), 2);
                this.f21733n = getWidth();
                t0(true);
                super.onTouchEvent(MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0));
                this.f21709b = 3;
                return true;
            }
            if (this.f21757z) {
                return true;
            }
            boolean z7 = this.f21739q;
            if (z7 && (x5 < rect.left || x5 > rect.right)) {
                this.f21757z = true;
                s sVar = this.f21693G;
                if (sVar != null) {
                    sVar.a();
                }
                return true;
            }
            if (z7) {
                this.f21685A = this.f21751w;
                this.f21751w = y5;
            }
        }
        if (!this.f21739q) {
            return false;
        }
        if (this.f21694H) {
            if (P0(x5, y5)) {
                if (this.f21685A < 0) {
                    q0(-1, this.f21749v);
                } else {
                    h1(-1, this.f21749v);
                }
                this.f21694H = false;
            }
            return true;
        }
        if (j0(y5)) {
            if (this.f21693G == null) {
                this.f21693G = new s();
            }
            if (!this.f21693G.b()) {
                this.f21693G.c(y5 < getPaddingTop() + this.f21695I);
            }
            return true;
        }
        s sVar2 = this.f21693G;
        if (sVar2 != null && sVar2.b()) {
            this.f21693G.a();
        }
        if (y5 < this.f21745t || ((z5 = this.f21736o0) && x5 < this.f21741r)) {
            int i5 = this.f21691E;
            if (i5 != -1) {
                h1(-1, i5);
                this.f21691E = -1;
            }
            int i6 = this.f21689C;
            if (i6 != -1) {
                h1(-1, i6);
            }
            if (!P0(x5, y5) && !this.f21738p0) {
                int firstPosition = getFirstPosition();
                int i7 = this.f21687B;
                if (i7 != firstPosition) {
                    h1(i7, firstPosition);
                }
                this.f21689C = -1;
                this.f21687B = -1;
                this.f21694H = true;
                return true;
            }
            h1(this.f21687B, this.f21749v);
        } else if (y5 > this.f21747u || (z5 && x5 > this.f21743s)) {
            int i8 = this.f21691E;
            if (i8 != -1) {
                q0(-1, i8);
                this.f21691E = -1;
            }
            int i9 = this.f21687B;
            if (i9 != -1) {
                q0(-1, i9);
            }
            if (!P0(x5, y5) && !this.f21738p0) {
                int lastPosition = getLastPosition();
                int i10 = this.f21689C;
                if (i10 != lastPosition) {
                    q0(i10, lastPosition);
                }
                this.f21689C = -1;
                this.f21687B = -1;
                this.f21694H = true;
                return true;
            }
            q0(this.f21689C, this.f21749v);
        }
        return true;
    }

    private void f1() {
        int itemDecorationCount = getItemDecorationCount();
        for (int i5 = 0; i5 < itemDecorationCount; i5++) {
            if (getItemDecorationAt(i5) instanceof g) {
                ((g) getItemDecorationAt(i5)).a();
            }
        }
        for (int i6 = 0; i6 < itemDecorationCount; i6++) {
            if (getItemDecorationAt(i6) instanceof g) {
                HashSet<Integer> hashSetB = ((g) getItemDecorationAt(i6)).b();
                for (int i7 = 0; i7 < itemDecorationCount; i7++) {
                    if (i6 != i7 && (getItemDecorationAt(i7) instanceof g)) {
                        ((g) getItemDecorationAt(i7)).e(hashSetB);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g1(int i5, boolean z5) {
        if (getChildCountExt() == 0) {
            return;
        }
        if (z5) {
            offsetChildrenVertical(i5);
        }
        if (awakenScrollBars()) {
            return;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getChildCountExt() {
        return getLayoutManager().getChildCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getItemCount() {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            return adapter.getItemCount();
        }
        return 0;
    }

    private void i1() {
        f fVar;
        int i5;
        RecyclerView.Adapter adapter = getAdapter();
        if (!adapter.hasStableIds() || (fVar = this.f21708a0) == null || (i5 = fVar.f21773b) == -1) {
            return;
        }
        long j5 = fVar.f21774c;
        if (j5 != adapter.getItemId(i5)) {
            View view = this.f21708a0.f21772a;
            if (view != null) {
                view.setHovered(false);
                k0(this.f21708a0.f21772a);
            }
            f fVar2 = this.f21708a0;
            fVar2.f21772a = null;
            fVar2.f21773b = -1;
            int iMin = Math.min(i5 + 20, adapter.getItemCount());
            for (int iMax = Math.max(0, i5 - 20); iMax < iMin; iMax++) {
                if (j5 == adapter.getItemId(iMax)) {
                    RecyclerView.ViewHolder viewHolderFindViewHolderForItemId = findViewHolderForItemId(j5);
                    if (viewHolderFindViewHolderForItemId != null) {
                        f fVar3 = this.f21708a0;
                        fVar3.f21773b = iMax;
                        fVar3.f21772a = viewHolderFindViewHolderForItemId.itemView;
                        return;
                    }
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1() {
        int childCountExt = getChildCountExt();
        for (int i5 = 0; i5 < childCountExt; i5++) {
            View viewX0 = x0(i5);
            Z0(viewX0, y0(viewX0));
        }
    }

    private void k0(View view) {
        Drawable background = view.getBackground();
        if (background != null) {
            background.jumpToCurrentState();
        }
    }

    private void l0(MotionEvent motionEvent) {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager) && !(layoutManager instanceof StaggeredGridLayoutManager)) {
            this.f21735o = false;
            this.f21737p = false;
            return;
        }
        if (getScrollY() != 0) {
            t0(true);
        } else {
            t0(false);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 || actionMasked == 2) {
            m0((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (actionMasked == 3) {
            this.f21735o = false;
        }
    }

    private void l1() throws IllegalAccessException, Resources.NotFoundException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Drawable drawable;
        Log.i("StepOSRecyclerView", "useDefaultSelector,  try to get f10 res");
        try {
            drawable = getResources().getDrawable(getResources().getIdentifier("stepos_recyclerview_selector_f10", "drawable", getContext().getPackageName()));
        } catch (Exception e6) {
            Log.i("StepOSRecyclerView", "useDefaultSelector,  get f10 res fail , may be app code compression: " + e6);
            drawable = null;
        }
        if (drawable == null) {
            Log.i("StepOSRecyclerView", "useDefaultSelector, get f10 res fail, and try to reflect StepOSPressAnimationDrawable");
            try {
                int i5 = StepOSPressAnimationDrawable.f13563E;
                Object objNewInstance = StepOSPressAnimationDrawable.class.getConstructor(null).newInstance(null);
                if (objNewInstance instanceof Drawable) {
                    if (L0(getResources().getConfiguration())) {
                        Method declaredMethod = StepOSPressAnimationDrawable.class.getDeclaredMethod("setTint", Integer.TYPE);
                        declaredMethod.setAccessible(true);
                        declaredMethod.invoke(objNewInstance, -1);
                        Method declaredMethod2 = StepOSPressAnimationDrawable.class.getDeclaredMethod("setAlphaTo", Float.TYPE);
                        declaredMethod2.setAccessible(true);
                        declaredMethod2.invoke(objNewInstance, Float.valueOf(0.03f));
                    }
                    drawable = (Drawable) objNewInstance;
                }
            } catch (Exception e7) {
                Log.i("StepOSRecyclerView", "useDefaultSelector,  try to reflect StepOSPressAnimationDrawable fail " + e7);
            }
        }
        if (drawable == null) {
            Log.i("StepOSRecyclerView", "useDefaultSelector,  try to reflect StepOSPressAnimationDrawable fail , and to get old res");
            drawable = getResources().getDrawable(V4.b.f5549b);
        }
        setSelector(drawable);
    }

    private void m0(int i5, int i6) {
        Rect rect = this.f21729l;
        this.f21735o = rect != null && rect.contains(i5, i6);
        if (this.f21736o0 && this.f21738p0) {
            this.f21735o = true;
        }
    }

    static /* synthetic */ h n(StepOSRecyclerView stepOSRecyclerView) {
        stepOSRecyclerView.getClass();
        return null;
    }

    private static int p0(Context context, float f5) {
        return (int) TypedValue.applyDimension(1, f5, context.getResources().getDisplayMetrics());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        this.f21751w = -1;
        this.f21753x = -1;
        this.f21755y = -1;
        this.f21685A = -1;
        this.f21739q = false;
        this.f21757z = false;
        this.f21691E = -1;
        this.f21689C = -1;
        this.f21687B = -1;
        this.f21749v = -1;
        this.f21694H = false;
        s sVar = this.f21693G;
        if (sVar != null) {
            sVar.a();
        }
    }

    public static void setAvoidNotifyItemRangeChanged(boolean z5) {
        f21682C0 = z5;
    }

    static /* synthetic */ n t(StepOSRecyclerView stepOSRecyclerView) {
        stepOSRecyclerView.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View v0(int i5, int i6) {
        for (int childCount = getLayoutManager().getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getLayoutManager().getChildAt(childCount);
            float translationY = childAt.getTranslationY();
            if (this.f21736o0) {
                float translationX = childAt.getTranslationX();
                float f5 = i5;
                if (f5 >= C0(childAt) + translationX && f5 <= A0(childAt) + translationX) {
                    float f6 = i6;
                    if (f6 >= D0(childAt) + translationY && f6 <= z0(childAt) + translationY) {
                        return childAt;
                    }
                }
            } else {
                float f7 = i6;
                if (f7 >= D0(childAt) + translationY && f7 <= z0(childAt) + translationY) {
                    return childAt;
                }
            }
        }
        return null;
    }

    private boolean w0(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (viewGroup instanceof RecyclerView) {
            return true;
        }
        ViewParent parent = viewGroup.getParent();
        if (parent instanceof ViewGroup) {
            return w0((ViewGroup) parent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int y0(View view) {
        if (view == null) {
            return -1;
        }
        return getChildLayoutPosition(view);
    }

    public int A0(View view) {
        return getLayoutManager().getDecoratedRight(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).getMarginEnd();
    }

    public int B0(View view) {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return layoutManager.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
    }

    public int C0(View view) {
        return getLayoutManager().getDecoratedLeft(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).getMarginStart();
    }

    public int D0(View view) {
        return getLayoutManager().getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
    }

    public Boolean I0() {
        return Boolean.valueOf(this.f21713d != null || this.f21726j0);
    }

    public boolean J0(int i5) {
        SparseBooleanArray sparseBooleanArray;
        if (this.f21711c == 0 || (sparseBooleanArray = this.f21719g) == null) {
            return false;
        }
        return sparseBooleanArray.get(i5);
    }

    public boolean K0() {
        return this.f21744s0.Q();
    }

    protected boolean S0() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        View childAt;
        if (getItemCount() == 0 || this.f21744s0.P()) {
            return false;
        }
        int firstPosition = getFirstPosition();
        if ((firstPosition == 0 && (childAt = getChildAt(0)) != null && childAt.getTop() >= getPaddingTop()) || getItemCount() == Integer.MAX_VALUE) {
            return false;
        }
        e eVar = this.f21696J;
        if (eVar != null) {
            eVar.a();
            this.f21696J = null;
        }
        if (firstPosition > getChildCount() * 2) {
            scrollToPosition(getChildCount() * 2);
        }
        smoothScrollToPosition(0);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void T0(int i5, View view) {
        boolean z5 = i5 != this.f21701R;
        if (i5 != -1) {
            this.f21701R = i5;
        }
        Rect rect = this.f21700Q;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (view instanceof t) {
            ((t) view).adjustListItemSelectionBounds(rect);
        }
        rect.left -= this.f21702S;
        rect.top -= this.f21703T;
        rect.right += this.f21704U;
        rect.bottom += this.f21705V;
        Drawable drawable = this.f21699M;
        if (drawable != null) {
            drawable.setBounds(rect);
            if (z5) {
                if (getVisibility() == 0) {
                    drawable.setVisible(true, false);
                }
                k1();
            }
        }
        refreshDrawableState();
    }

    public void W0(View view, int i5) throws Resources.NotFoundException {
        if (this.f21688B0) {
            if (i5 == 0) {
                view.setBackground(E0("immersive_item_bkg_head"));
                return;
            }
            if (i5 == 1) {
                view.setBackground(E0("immersive_item_bkg_middle"));
                return;
            }
            if (i5 == 2) {
                view.setBackground(E0("immersive_item_bkg_foot"));
                return;
            }
            if (i5 == 3) {
                view.setBackground(E0("immersive_item_bkg_alone"));
                return;
            }
            if (i5 == 5) {
                view.setBackground(E0("immersive_item_bkg_head_related_setting"));
                return;
            }
            if (i5 == 6) {
                view.setBackground(E0("immersive_item_bkg_middle_related_setting"));
            } else if (i5 == 7) {
                view.setBackground(E0("immersive_item_bkg_foot_related_setting"));
            } else {
                view.setBackground(getContext().getDrawable(V4.b.f5548a));
            }
        }
    }

    public void X0() {
        this.f21688B0 = true;
    }

    public void Y0(int i5, boolean z5) {
        if (this.f21711c == 0) {
            return;
        }
        RecyclerView.Adapter adapter = getAdapter();
        if (z5 && this.f21711c == 4 && this.f21713d == null) {
            MultiChoiceModeWrapper multiChoiceModeWrapper = this.f21715e;
            if (multiChoiceModeWrapper == null || !multiChoiceModeWrapper.a()) {
                throw new IllegalStateException("RecyclerView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
            }
            this.f21713d = startActionMode(this.f21715e);
        }
        int i6 = this.f21711c;
        if (i6 == 4 || i6 == 5) {
            boolean z6 = this.f21719g.get(i5);
            this.f21719g.put(i5, z5);
            if (this.f21723i != null && adapter.hasStableIds()) {
                if (z5) {
                    this.f21723i.j(adapter.getItemId(i5), Integer.valueOf(i5));
                } else {
                    this.f21723i.e(adapter.getItemId(i5));
                }
            }
            if (z6 != z5) {
                if (z5) {
                    this.f21717f++;
                } else {
                    this.f21717f--;
                }
            }
            if (this.f21713d != null) {
                this.f21715e.onItemCheckedStateChanged(this.f21713d, i5, adapter.getItemId(i5), z5);
            }
        } else {
            boolean z7 = this.f21723i != null && adapter.hasStableIds();
            if (z5 || J0(i5)) {
                this.f21719g.clear();
                if (z7) {
                    this.f21723i.b();
                }
            }
            if (z5) {
                this.f21719g.put(i5, true);
                if (z7) {
                    this.f21723i.j(adapter.getItemId(i5), Integer.valueOf(i5));
                }
                this.f21717f = 1;
            } else if (this.f21719g.size() == 0 || !this.f21719g.valueAt(0)) {
                this.f21717f = 0;
            }
        }
        j1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void Z0(View view, int i5) {
        SparseBooleanArray sparseBooleanArray;
        KeyEvent.Callback callbackFindViewById;
        if (view == 0 || this.f21711c == 0 || (sparseBooleanArray = this.f21719g) == null) {
            return;
        }
        boolean z5 = sparseBooleanArray.get(i5);
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(z5);
            return;
        }
        if (getContext().getApplicationInfo().targetSdkVersion >= 11) {
            int i6 = this.f21711c;
            if ((i6 == 4 || i6 == 5) && (callbackFindViewById = view.findViewById(R.id.checkbox)) != null && (callbackFindViewById instanceof Checkable)) {
                ((Checkable) callbackFindViewById).setChecked(this.f21713d != null || this.f21726j0);
            }
            view.setActivated(z5);
        }
    }

    protected boolean a1(MotionEvent motionEvent) {
        float fAbs = Math.abs(motionEvent.getY() - this.f21755y);
        float fAbs2 = Math.abs(this.f21753x - motionEvent.getX());
        return fAbs2 != 0.0f && (fAbs > 60.0f || fAbs2 > 60.0f) && ((double) (fAbs / fAbs2)) < this.f21707a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        if (!(itemDecoration instanceof g)) {
            Log.i("StepOSRecyclerView", "you should use StepOSRecyclerView.ItemDecoration!! Otherwise, it may cause problems");
        }
        super.addItemDecoration(itemDecoration);
    }

    boolean b1() {
        return (isFocused() && !isInTouchMode()) || isPressed();
    }

    public boolean d1() {
        int i5 = this.f21711c;
        if ((i5 != 5 && i5 != 4) || this.f21713d != null) {
            return false;
        }
        ActionMode actionModeStartActionMode = startActionMode(this.f21715e);
        this.f21713d = actionModeStartActionMode;
        this.f21733n = this.f21731m;
        if (actionModeStartActionMode == null) {
            return false;
        }
        N0();
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!this.f21698L && !this.f21688B0) {
            r0(canvas);
        }
        super.dispatchDraw(canvas);
        f1();
        int itemDecorationCount = getItemDecorationCount();
        for (int i5 = 0; i5 < itemDecorationCount; i5++) {
            if (getItemDecorationAt(i5) instanceof g) {
                ((g) getItemDecorationAt(i5)).c(canvas, this, x.c(RecyclerView.class, this));
            }
        }
        Q0(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z5) {
    }

    public boolean dispatchStatusBarTap() {
        return S0();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00dd  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.StepOSRecyclerView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        k1();
    }

    protected boolean e1(int i5) {
        if (i5 >= 0) {
            return i5 < getHeaderViewsCount() || i5 >= getItemCount() - getFooterViewsCount();
        }
        return false;
    }

    @Deprecated
    public void f0(RecyclerView.ViewHolder viewHolder) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        g0(viewHolder, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int i5, int i6) {
        this.f21744s0.C(i5, i6);
        return super.fling(i5, i6);
    }

    @Deprecated
    public void g0(RecyclerView.ViewHolder viewHolder, boolean z5) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (viewHolder == null) {
            throw new IllegalArgumentException("the viewHolder to add must not be null!");
        }
        d dVar = new d();
        dVar.f21766a = viewHolder;
        dVar.f21767b = z5;
        this.f21742r0.add(dVar);
        if (getAdapter() != null) {
            if (!(getAdapter() instanceof stepos.support.v7.widget.o)) {
                RecyclerView.AdapterDataObserver adapterDataObserverA = x.a(RecyclerView.class, this);
                getAdapter().unregisterAdapterDataObserver(adapterDataObserverA);
                x.i(RecyclerView.class, this, new stepos.support.v7.widget.o(getAdapter()));
                getAdapter().registerAdapterDataObserver(adapterDataObserverA);
                ((stepos.support.v7.widget.o) getAdapter()).y(this);
            }
            ((stepos.support.v7.widget.o) getAdapter()).n(dVar);
            ((stepos.support.v7.widget.o) getAdapter()).v().notifyDataSetChanged();
        }
    }

    public int getCheckedItemCount() {
        return this.f21717f;
    }

    public long[] getCheckedItemIds() {
        if (this.f21711c == 0 || this.f21723i == null || getAdapter() == null) {
            return new long[0];
        }
        q.f<Integer> fVar = this.f21723i;
        int iP = fVar.p();
        long[] jArr = new long[iP];
        for (int i5 = 0; i5 < iP; i5++) {
            jArr[i5] = fVar.i(i5);
        }
        return jArr;
    }

    public SparseBooleanArray getCheckedItemPositions() {
        if (this.f21711c != 0) {
            return this.f21719g;
        }
        return null;
    }

    public int getChoiceMode() {
        return this.f21711c;
    }

    public int getCount() {
        return getAdapter().getItemCount();
    }

    public int getFirstPosition() {
        View viewX0 = x0(0);
        if (viewX0 == null) {
            return -1;
        }
        return y0(viewX0);
    }

    public int getFooterViewsCount() {
        if (getAdapter() == null || !(getAdapter() instanceof stepos.support.v7.widget.o)) {
            return 0;
        }
        return ((stepos.support.v7.widget.o) getAdapter()).q();
    }

    public int getHeaderViewsCount() {
        if (getAdapter() == null || !(getAdapter() instanceof stepos.support.v7.widget.o)) {
            return 0;
        }
        return ((stepos.support.v7.widget.o) getAdapter()).s();
    }

    public int getLastPosition() {
        View viewX0 = x0(getChildCountExt() - 1);
        if (viewX0 == null) {
            return -1;
        }
        return y0(viewX0);
    }

    public final n getOnItemClickListener() {
        return null;
    }

    public final o getOnItemLongClickListener() {
        return null;
    }

    public e5.c getSpringAnimationHelper() {
        return this.f21744s0;
    }

    public HashSet getViewHoldSet() {
        return this.f21724i0;
    }

    @Deprecated
    public void h0(RecyclerView.ViewHolder viewHolder) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        i0(viewHolder, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void h1(int i5, int i6) {
        boolean zIsEnabled;
        boolean zIsSelectable;
        boolean z5;
        RecyclerView.Adapter adapter = getAdapter();
        int firstPosition = getFirstPosition();
        for (int i7 = i5 == -1 ? i6 : i5 - 1; i7 >= i6; i7--) {
            boolean z6 = true;
            if (getAdapter() instanceof u) {
                zIsEnabled = ((u) getAdapter()).isEnabled(i7);
                zIsSelectable = ((u) getAdapter()).isSelectable(i7);
            } else {
                zIsEnabled = true;
                zIsSelectable = true;
            }
            if (!zIsSelectable) {
                this.f21690D = -1;
            } else {
                if (i7 == this.f21690D) {
                    return;
                }
                if (getAdapter() == null || zIsEnabled) {
                    x0(i7 - firstPosition);
                    adapter.getItemId(i7);
                    boolean zJ0 = J0(i7);
                    int[] iArr = this.f21730l0[i7];
                    int i8 = iArr[0];
                    if (i8 == 0) {
                        iArr[1] = zJ0 ? 1 : 0;
                    }
                    int i9 = i8 + 1;
                    iArr[0] = i9;
                    int i10 = this.f21728k0;
                    if (i10 == -1) {
                        z5 = this.f21734n0 ? zJ0 ? 1 : 0 : !zJ0;
                        this.f21728k0 = z5 ? 1 : 0;
                        iArr[1] = z5 ? 1 : 0;
                    } else if (i9 % 2 == 0) {
                        z6 = false;
                        z5 = z6;
                    } else {
                        z6 = false;
                        z5 = z6;
                    }
                    if (z5 != zJ0) {
                        Y0(i7, z5);
                        this.f21754x0.c(this, 0);
                    }
                    this.f21687B = i7;
                    this.f21689C = -1;
                    this.f21690D = -1;
                }
            }
        }
    }

    @Deprecated
    public void i0(RecyclerView.ViewHolder viewHolder, boolean z5) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (viewHolder == null) {
            throw new IllegalArgumentException("the viewHolder to add must not be null!");
        }
        d dVar = new d();
        dVar.f21766a = viewHolder;
        dVar.f21767b = z5;
        this.f21740q0.add(dVar);
        if (getAdapter() != null) {
            if (!(getAdapter() instanceof stepos.support.v7.widget.o)) {
                RecyclerView.AdapterDataObserver adapterDataObserverA = x.a(RecyclerView.class, this);
                getAdapter().unregisterAdapterDataObserver(adapterDataObserverA);
                x.i(RecyclerView.class, this, new stepos.support.v7.widget.o(getAdapter()));
                getAdapter().registerAdapterDataObserver(adapterDataObserverA);
                ((stepos.support.v7.widget.o) getAdapter()).y(this);
            }
            ((stepos.support.v7.widget.o) getAdapter()).p(dVar);
            ((stepos.support.v7.widget.o) getAdapter()).v().notifyDataSetChanged();
        }
    }

    protected boolean j0(int i5) {
        int childCountExt = getChildCountExt();
        if (childCountExt <= 0) {
            return false;
        }
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        View viewX0 = x0(0);
        int iY0 = y0(viewX0);
        boolean z5 = iY0 == 0 && viewX0.getTop() >= getPaddingTop();
        boolean z6 = i5 < paddingTop + this.f21695I;
        if (z5 && z6) {
            return false;
        }
        boolean z7 = iY0 + childCountExt == getItemCount() && x0(childCountExt - 1).getBottom() <= getHeight() - getPaddingBottom();
        boolean z8 = i5 > height - this.f21695I;
        if (z7 && z8) {
            return false;
        }
        return z6 || z8;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f21699M;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    void k1() {
        if (this.f21699M != null) {
            if (b1()) {
                this.f21699M.setState(getDrawableState());
            } else {
                this.f21699M.setState(StateSet.NOTHING);
            }
        }
    }

    public void n0() {
        SparseBooleanArray sparseBooleanArray = this.f21719g;
        if (sparseBooleanArray != null) {
            sparseBooleanArray.clear();
        }
        q.f<Integer> fVar = this.f21723i;
        if (fVar != null) {
            fVar.b();
        }
        this.f21717f = 0;
    }

    void o0() {
        ActionMode actionMode;
        MultiChoiceModeWrapper multiChoiceModeWrapper;
        RecyclerView.Adapter adapter = getAdapter();
        if (this.f21711c == 0 || adapter == null || !adapter.hasStableIds()) {
            return;
        }
        int itemCount = getItemCount();
        this.f21719g.clear();
        int i5 = 0;
        boolean z5 = false;
        while (i5 < this.f21723i.p()) {
            long jI = this.f21723i.i(i5);
            int iIntValue = this.f21723i.q(i5).intValue();
            if (jI != adapter.getItemId(iIntValue)) {
                int iMax = Math.max(0, iIntValue - 20);
                int iMin = Math.min(iIntValue + 20, itemCount);
                while (true) {
                    if (iMax >= iMin) {
                        this.f21723i.e(jI);
                        i5--;
                        this.f21717f--;
                        ActionMode actionMode2 = this.f21713d;
                        if (actionMode2 != null && (multiChoiceModeWrapper = this.f21715e) != null) {
                            multiChoiceModeWrapper.onItemCheckedStateChanged(actionMode2, iIntValue, jI, false);
                        }
                        z5 = true;
                    } else {
                        if (jI == adapter.getItemId(iMax)) {
                            this.f21719g.put(iMax, true);
                            this.f21723i.n(i5, Integer.valueOf(iMax));
                            break;
                        }
                        iMax++;
                    }
                }
            } else {
                this.f21719g.put(iIntValue, true);
            }
            i5++;
        }
        if (!z5 || (actionMode = this.f21713d) == null) {
            return;
        }
        actionMode.invalidate();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        if (w0((ViewGroup) getParent())) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        this.f21744s0.V(motionEvent);
        if ((getTranslationX() != 0.0f || getTranslationY() != 0.0f) && (parent = getParent()) != null && this.f21756y0) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) throws NoSuchFieldException, SecurityException {
        super.onLayout(z5, i5, i6, i7, i8);
        R0();
        RecyclerView.State stateC = x.c(RecyclerView.class, this);
        if (x.b(RecyclerView.State.class, stateC) == 1 && stateC.didStructureChange()) {
            o0();
            i1();
            setPressed(false);
            Drawable drawable = this.f21699M;
            if (drawable != null) {
                drawable.jumpToCurrentState();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    protected void onMeasure(int i5, int i6) throws IllegalAccessException, Resources.NotFoundException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.f21699M == null) {
            l1();
        }
        super.onMeasure(i5, i6);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrolled(int i5, int i6) {
        if (this.f21714d0) {
            this.f21720g0.g();
        }
        super.onScrolled(i5, i6);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    protected void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        t0(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        l0(motionEvent);
        if (isPressed() && this.f21744s0.P()) {
            setPressed(false);
        }
        if (!F0() && this.f21744s0.Y(motionEvent)) {
            ViewParent parent = getParent();
            if (parent != null && this.f21756y0) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            return true;
        }
        boolean zH = this.f21725j.h(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 1) {
            this.f21734n0 = false;
        }
        if (!zH && !this.f21739q) {
            return super.onTouchEvent(motionEvent);
        }
        if (zH && action == 0) {
            boolean zCanScrollHorizontally = getLayoutManager().canScrollHorizontally();
            int i5 = zCanScrollHorizontally;
            if (getLayoutManager().canScrollVertically()) {
                i5 = (zCanScrollHorizontally ? 1 : 0) | 2;
            }
            startNestedScroll(i5);
        }
        return true;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        f fVar;
        View view;
        super.onWindowFocusChanged(z5);
        if (!z5 || !this.f21710b0 || (fVar = this.f21708a0) == null || (view = fVar.f21772a) == null) {
            return;
        }
        if (this.f21712c0) {
            view.setHovered(true);
            this.f21712c0 = false;
        }
        this.f21708a0.f21772a.setHovered(false);
        f fVar2 = this.f21708a0;
        fVar2.f21772a = null;
        fVar2.f21774c = -1L;
        fVar2.f21773b = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0089, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void q0(int r10, int r11) {
        /*
            r9 = this;
            r0 = 1
            r1 = -1
            if (r10 != r1) goto L6
            r10 = r11
            goto L7
        L6:
            int r10 = r10 + r0
        L7:
            int[][] r2 = r9.f21730l0
            if (r2 == 0) goto L11
            int r3 = r2.length
            if (r11 >= r3) goto L11
            int r2 = r2.length
            if (r10 < r2) goto L14
        L11:
            r9.U0()
        L14:
            int[][] r2 = r9.f21730l0
            if (r2 == 0) goto La4
            int r3 = r2.length
            if (r11 >= r3) goto La4
            int r2 = r2.length
            if (r10 < r2) goto L20
            goto La4
        L20:
            androidx.recyclerview.widget.RecyclerView$Adapter r2 = r9.getAdapter()
            int r3 = r9.getFirstPosition()
        L28:
            if (r10 > r11) goto La3
            androidx.recyclerview.widget.RecyclerView$Adapter r4 = r9.getAdapter()
            boolean r4 = r4 instanceof stepos.support.v7.widget.StepOSRecyclerView.u
            if (r4 == 0) goto L47
            androidx.recyclerview.widget.RecyclerView$Adapter r4 = r9.getAdapter()
            stepos.support.v7.widget.StepOSRecyclerView$u r4 = (stepos.support.v7.widget.StepOSRecyclerView.u) r4
            boolean r4 = r4.isEnabled(r10)
            androidx.recyclerview.widget.RecyclerView$Adapter r5 = r9.getAdapter()
            stepos.support.v7.widget.StepOSRecyclerView$u r5 = (stepos.support.v7.widget.StepOSRecyclerView.u) r5
            boolean r5 = r5.isSelectable(r10)
            goto L49
        L47:
            r4 = r0
            r5 = r4
        L49:
            if (r5 == 0) goto L9e
            int r5 = r9.f21690D
            if (r10 != r5) goto L50
            goto La3
        L50:
            if (r2 == 0) goto L55
            if (r4 != 0) goto L55
            goto La0
        L55:
            int r4 = r10 - r3
            r9.x0(r4)
            r2.getItemId(r10)
            boolean r4 = r9.J0(r10)
            int[][] r5 = r9.f21730l0
            r5 = r5[r10]
            r6 = 0
            r7 = r5[r6]
            if (r7 != 0) goto L6c
            r5[r0] = r4
        L6c:
            int r7 = r7 + 1
            r5[r6] = r7
            int r8 = r9.f21728k0
            if (r8 != r1) goto L81
            boolean r7 = r9.f21734n0
            if (r7 == 0) goto L7a
            r7 = r4
            goto L7c
        L7a:
            r7 = r4 ^ 1
        L7c:
            r9.f21728k0 = r7
            r5[r0] = r7
            goto L90
        L81:
            int r7 = r7 % 2
            if (r7 != 0) goto L8d
            r5 = r5[r0]
            if (r5 != r0) goto L8b
        L89:
            r7 = r0
            goto L90
        L8b:
            r7 = r6
            goto L90
        L8d:
            if (r8 != r0) goto L8b
            goto L89
        L90:
            if (r7 == r4) goto L9a
            r9.Y0(r10, r7)
            stepos.support.v7.widget.n r4 = r9.f21754x0
            r4.c(r9, r6)
        L9a:
            r9.f21689C = r10
            r9.f21687B = r1
        L9e:
            r9.f21690D = r1
        La0:
            int r10 = r10 + 1
            goto L28
        La3:
            return
        La4:
            java.lang.String r9 = "StepOSRecyclerView"
            java.lang.String r10 = "downSelect error mItemDragSelectStatus len < start or end"
            android.util.Log.e(r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.StepOSRecyclerView.q0(int, int):void");
    }

    protected void r0(Canvas canvas) {
        if (this.f21700Q.isEmpty()) {
            return;
        }
        Drawable drawable = this.f21699M;
        drawable.setBounds(this.f21700Q);
        drawable.draw(canvas);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        if (!(adapter instanceof u)) {
            Log.i("StepOSRecyclerView", "you should use StepOSRecyclerView.Adapter！！！ Otherwise, it may cause problems");
        }
        if (adapter != null && (this.f21740q0.size() > 0 || this.f21742r0.size() > 0)) {
            if (!(adapter instanceof stepos.support.v7.widget.o)) {
                adapter = new stepos.support.v7.widget.o(adapter);
            }
            stepos.support.v7.widget.o oVar = (stepos.support.v7.widget.o) adapter;
            ArrayList<d> arrayList = this.f21740q0;
            int size = arrayList.size();
            int i5 = 0;
            int i6 = 0;
            while (i6 < size) {
                d dVar = arrayList.get(i6);
                i6++;
                oVar.p(dVar);
            }
            ArrayList<d> arrayList2 = this.f21742r0;
            int size2 = arrayList2.size();
            while (i5 < size2) {
                d dVar2 = arrayList2.get(i5);
                i5++;
                oVar.n(dVar2);
            }
        }
        super.setAdapter(adapter);
        if (adapter != null) {
            boolean zHasStableIds = getAdapter().hasStableIds();
            if (this.f21711c != 0 && zHasStableIds && this.f21723i == null) {
                this.f21723i = new q.f<>();
            }
        }
        n0();
    }

    public void setBaseDuration(int i5) {
        r rVar = this.f21720g0;
        if (rVar != null) {
            rVar.i(i5);
        }
    }

    public void setBottomOverScrollEnable(boolean z5) {
        this.f21744s0.b0(z5);
    }

    public void setCheckBoxIsAnimation(boolean z5) {
        if (this.f21697K != z5) {
            this.f21697K = z5;
        }
    }

    public void setChoiceMode(int i5) {
        this.f21711c = i5;
        ActionMode actionMode = this.f21713d;
        if (actionMode != null) {
            actionMode.finish();
            this.f21713d = null;
        } else if (this.f21726j0) {
            throw null;
        }
        if (this.f21711c != 0) {
            if (this.f21719g == null) {
                this.f21719g = new SparseBooleanArray(0);
            }
            RecyclerView.Adapter adapter = getAdapter();
            if (this.f21723i == null && adapter != null && adapter.hasStableIds()) {
                this.f21723i = new q.f<>(0);
            }
            if (this.f21711c == 4) {
                n0();
                setLongClickable(true);
            }
        }
    }

    public void setDrawSelectorOnTop(boolean z5) {
        this.f21698L = z5;
    }

    public void setEnableDragSelection(boolean z5) {
        this.f21737p = z5;
    }

    public void setEnableHoldPress(boolean z5) {
        this.f21710b0 = z5;
    }

    public void setEnableParallax(boolean z5) {
        if (z5) {
            if (this.f21720g0 == null) {
                this.f21720g0 = new r();
            }
            if (this.f21724i0 == null) {
                this.f21724i0 = new HashSet<>();
            }
        }
        this.f21714d0 = z5;
    }

    public void setEndOverScrollEnable(boolean z5) {
        this.f21744s0.e0(z5);
    }

    public void setItenFilter(h hVar) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        e5.c cVar = this.f21744s0;
        if (cVar != null && layoutManager != null) {
            cVar.f0(layoutManager.canScrollVertically() ? 1 : 0);
        }
        this.f21736o0 = (layoutManager instanceof GridLayoutManager) || (layoutManager instanceof StaggeredGridLayoutManager) || this.f21738p0;
    }

    public void setMultiChoiceListener(k kVar) {
    }

    public void setMultiChoiceModeListener(l lVar) {
        if (this.f21715e == null) {
            this.f21715e = new MultiChoiceModeWrapper();
        }
        this.f21715e.b(lVar);
    }

    public void setOnItemClickListener(n nVar) {
    }

    public void setOnItemLongClickListener(o oVar) {
        if (isLongClickable()) {
            return;
        }
        setLongClickable(true);
    }

    public void setOverScrollEnable(boolean z5) {
        this.f21750v0 = z5;
        this.f21744s0.g0(z5);
    }

    public void setParallaxAnimationListener(p pVar) {
    }

    public void setPinnedHeaderDecoration(d5.a aVar) {
    }

    public void setPressStateDuration(int i5) {
        this.f21758z0 = i5;
    }

    @Deprecated
    public void setRequestLayoutWhenSwitchActionMode(boolean z5) {
        this.f21721h = z5;
    }

    public void setScrollSensitivity(int i5) {
        r rVar = this.f21720g0;
        if (rVar != null) {
            rVar.k(i5);
        }
    }

    public void setScrollUpByItemCoveredInMultiChoiceEnable(boolean z5) {
        this.f21748u0 = z5;
    }

    public void setSelector(int i5) {
        setSelector(getResources().getDrawable(i5));
    }

    public void setShouldRequestDisallowInterceptTouchEventWhenOverScroll(boolean z5) {
        this.f21756y0 = z5;
    }

    public void setSmoothBackInterpolator(TimeInterpolator timeInterpolator) {
        r rVar;
        if (timeInterpolator == null || (rVar = this.f21720g0) == null) {
            return;
        }
        rVar.l(timeInterpolator);
    }

    public void setStartOverScrollEnable(boolean z5) {
        this.f21744s0.h0(z5);
    }

    public void setTopOverScrollEnable(boolean z5) {
        this.f21744s0.j0(z5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void swapAdapter(RecyclerView.Adapter adapter, boolean z5) {
        if (this.f21740q0.size() > 0 || this.f21742r0.size() > 0) {
            if (!(adapter instanceof stepos.support.v7.widget.o)) {
                adapter = new stepos.support.v7.widget.o(adapter);
            }
            stepos.support.v7.widget.o oVar = (stepos.support.v7.widget.o) adapter;
            ArrayList<d> arrayList = this.f21740q0;
            int size = arrayList.size();
            int i5 = 0;
            int i6 = 0;
            while (i6 < size) {
                d dVar = arrayList.get(i6);
                i6++;
                oVar.p(dVar);
            }
            ArrayList<d> arrayList2 = this.f21742r0;
            int size2 = arrayList2.size();
            while (i5 < size2) {
                d dVar2 = arrayList2.get(i5);
                i5++;
                oVar.n(dVar2);
            }
        }
        super.swapAdapter(adapter, z5);
        if (adapter != null) {
            boolean zHasStableIds = getAdapter().hasStableIds();
            if (this.f21711c != 0 && zHasStableIds && this.f21723i == null) {
                this.f21723i = new q.f<>();
            }
        }
        n0();
    }

    void t0(boolean z5) {
        if (this.f21729l == null) {
            Rect rect = new Rect();
            this.f21729l = rect;
            rect.setEmpty();
        }
        int i5 = this.f21711c;
        if (i5 != 4 && i5 != 5) {
            this.f21729l.setEmpty();
            return;
        }
        if (this.f21729l.isEmpty() || z5) {
            if (getLayoutDirection() == 1) {
                this.f21729l.left = getPaddingLeft();
                Rect rect2 = this.f21729l;
                rect2.right = rect2.left + this.f21733n;
                rect2.top = getPaddingTop();
                this.f21729l.bottom = getHeight() - getPaddingBottom();
                return;
            }
            this.f21729l.right = getWidth() - getPaddingRight();
            Rect rect3 = this.f21729l;
            rect3.left = rect3.right - this.f21733n;
            rect3.top = getPaddingTop();
            this.f21729l.bottom = getHeight() - getPaddingBottom();
        }
    }

    protected int u0(boolean z5) {
        int childCountExt = getChildCountExt();
        int firstPosition = getFirstPosition();
        if (z5) {
            for (int i5 = 0; i5 < childCountExt; i5++) {
                View viewX0 = x0(i5);
                if (z0(viewX0) - (B0(viewX0) / 2) > getPaddingTop()) {
                    return firstPosition + i5;
                }
            }
            return -1;
        }
        for (int i6 = childCountExt - 1; i6 >= 0; i6--) {
            View viewX02 = x0(i6);
            if (D0(viewX02) + (B0(viewX02) / 2) < getHeight() - getPaddingBottom()) {
                return firstPosition + i6;
            }
        }
        return -1;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return this.f21699M == drawable || super.verifyDrawable(drawable);
    }

    public View x0(int i5) {
        return getLayoutManager().getChildAt(i5);
    }

    public int z0(View view) {
        return getLayoutManager().getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    private class j implements s.b {

        /* renamed from: a, reason: collision with root package name */
        private View f21785a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f21786b;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (j.this.f21785a != null) {
                    StepOSRecyclerView.this.setPressed(false);
                    j.this.f21785a.setPressed(false);
                    j jVar = j.this;
                    int iY0 = StepOSRecyclerView.this.y0(jVar.f21785a);
                    if (iY0 >= 0 && !x.h(RecyclerView.class, StepOSRecyclerView.this) && StepOSRecyclerView.this.isAttachedToWindow()) {
                        long itemId = StepOSRecyclerView.this.getAdapter().getItemId(iY0);
                        j jVar2 = j.this;
                        jVar2.h(StepOSRecyclerView.this, jVar2.f21785a, iY0, itemId);
                    }
                    j.this.f21785a = null;
                    j.this.f21786b = false;
                }
            }
        }

        private j() {
            this.f21786b = false;
        }

        private boolean e(int i5, int i6, Rect rect, MotionEvent motionEvent) {
            int i7;
            boolean z5 = i5 >= rect.left && i5 <= rect.right;
            if (StepOSRecyclerView.this.f21736o0 && StepOSRecyclerView.this.f21738p0) {
                return true;
            }
            if (StepOSRecyclerView.this.f21736o0) {
                int rawY = (int) motionEvent.getRawY();
                int rawX = (int) motionEvent.getRawX();
                View viewV0 = StepOSRecyclerView.this.v0(i5, i6);
                View viewFindViewById = viewV0 == null ? null : viewV0.findViewById(R.id.checkbox);
                if (viewFindViewById != null && (viewFindViewById instanceof Checkable)) {
                    int[] iArr = new int[2];
                    viewFindViewById.getLocationOnScreen(iArr);
                    int i8 = iArr[0];
                    return rawX >= i8 && rawX <= i8 + viewFindViewById.getWidth() && rawY >= (i7 = iArr[1]) && rawY <= i7 + viewFindViewById.getHeight();
                }
            }
            return z5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean h(RecyclerView recyclerView, View view, int i5, long j5) {
            boolean z5;
            if (StepOSRecyclerView.this.e1(i5)) {
                return true;
            }
            boolean z6 = false;
            if (StepOSRecyclerView.this.f21711c != 0) {
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                boolean zIsSelectable = adapter instanceof u ? ((u) adapter).isSelectable(i5) : true;
                if ((StepOSRecyclerView.this.f21711c == 4 || StepOSRecyclerView.this.f21711c == 5) && ((StepOSRecyclerView.this.f21713d != null || StepOSRecyclerView.this.f21726j0) && zIsSelectable)) {
                    boolean z7 = StepOSRecyclerView.this.f21719g.get(i5, false);
                    boolean z8 = !z7;
                    StepOSRecyclerView.this.f21719g.put(i5, z8);
                    if (StepOSRecyclerView.this.f21723i != null && adapter.hasStableIds()) {
                        if (z7) {
                            StepOSRecyclerView.this.f21723i.e(adapter.getItemId(i5));
                        } else {
                            StepOSRecyclerView.this.f21723i.j(adapter.getItemId(i5), Integer.valueOf(i5));
                        }
                    }
                    if (z7) {
                        StepOSRecyclerView.C(StepOSRecyclerView.this);
                    } else {
                        StepOSRecyclerView.B(StepOSRecyclerView.this);
                    }
                    if (StepOSRecyclerView.this.f21713d != null) {
                        StepOSRecyclerView.this.f21715e.onItemCheckedStateChanged(StepOSRecyclerView.this.f21713d, i5, j5, z8);
                    } else {
                        if (StepOSRecyclerView.this.f21726j0) {
                            StepOSRecyclerView.E(StepOSRecyclerView.this);
                        }
                        z6 = true;
                    }
                    z5 = z6;
                    z6 = true;
                } else {
                    z5 = true;
                }
                if (z6) {
                    StepOSRecyclerView.this.j1();
                }
                z6 = true;
            } else {
                z5 = true;
            }
            if (z5) {
                StepOSRecyclerView.t(StepOSRecyclerView.this);
            }
            if (z5 && StepOSRecyclerView.this.f21710b0) {
                if (!StepOSRecyclerView.this.f21712c0) {
                    view.setHovered(true);
                }
                if (StepOSRecyclerView.this.f21708a0 == null) {
                    StepOSRecyclerView stepOSRecyclerView = StepOSRecyclerView.this;
                    stepOSRecyclerView.f21708a0 = stepOSRecyclerView.new f(view, i5, j5);
                    return z6;
                }
                StepOSRecyclerView.this.f21708a0.f21772a = view;
                StepOSRecyclerView.this.f21708a0.f21773b = i5;
                StepOSRecyclerView.this.f21708a0.f21774c = j5;
            }
            return z6;
        }

        private boolean i(RecyclerView recyclerView, int i5, long j5) {
            if (StepOSRecyclerView.this.e1(i5)) {
                return true;
            }
            if (StepOSRecyclerView.this.f21711c == 4 || StepOSRecyclerView.this.f21711c == 5) {
                if (StepOSRecyclerView.this.getAdapter() instanceof u ? ((u) StepOSRecyclerView.this.getAdapter()).isSelectable(i5) : true) {
                    if (StepOSRecyclerView.this.f21715e == null) {
                        StepOSRecyclerView.E(StepOSRecyclerView.this);
                    } else if (StepOSRecyclerView.this.f21713d == null) {
                        StepOSRecyclerView stepOSRecyclerView = StepOSRecyclerView.this;
                        if (stepOSRecyclerView.f21713d = recyclerView.startActionMode(stepOSRecyclerView.f21715e) != null) {
                            StepOSRecyclerView.this.Y0(i5, true);
                            recyclerView.performHapticFeedback(0);
                            StepOSRecyclerView.this.V0(this.f21785a);
                            StepOSRecyclerView.this.O0(false);
                        }
                    }
                    return true;
                }
            }
            StepOSRecyclerView.M(StepOSRecyclerView.this);
            if (StepOSRecyclerView.this.f21737p) {
                StepOSRecyclerView.this.f21690D = i5;
            }
            return false;
        }

        public void f() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            StepOSRecyclerView.this.s0();
            StepOSRecyclerView.this.f21709b = -1;
            x.g(0, RecyclerView.class, StepOSRecyclerView.this);
            View view = this.f21785a;
            if (view != null) {
                view.setPressed(false);
            }
            StepOSRecyclerView.this.setPressed(false);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0081  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean g() {
            /*
                r10 = this;
                android.view.View r0 = r10.f21785a
                r1 = 0
                if (r0 == 0) goto L13
                boolean r0 = r10.f21786b
                if (r0 != 0) goto L13
                stepos.support.v7.widget.StepOSRecyclerView r0 = stepos.support.v7.widget.StepOSRecyclerView.this
                r0.setPressed(r1)
                android.view.View r0 = r10.f21785a
                r0.setPressed(r1)
            L13:
                stepos.support.v7.widget.StepOSRecyclerView r0 = stepos.support.v7.widget.StepOSRecyclerView.this
                int r0 = stepos.support.v7.widget.StepOSRecyclerView.a(r0)
                r2 = 2
                if (r0 != r2) goto L81
                stepos.support.v7.widget.StepOSRecyclerView r0 = stepos.support.v7.widget.StepOSRecyclerView.this
                android.view.View r3 = r10.f21785a
                int r7 = stepos.support.v7.widget.StepOSRecyclerView.m(r0, r3)
                stepos.support.v7.widget.StepOSRecyclerView r0 = stepos.support.v7.widget.StepOSRecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r0 = r0.getAdapter()
                if (r0 == 0) goto L4b
                stepos.support.v7.widget.StepOSRecyclerView r0 = stepos.support.v7.widget.StepOSRecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r0 = r0.getAdapter()
                boolean r0 = r0 instanceof stepos.support.v7.widget.StepOSRecyclerView.u
                if (r0 == 0) goto L4b
                stepos.support.v7.widget.StepOSRecyclerView r0 = stepos.support.v7.widget.StepOSRecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r0 = r0.getAdapter()
                stepos.support.v7.widget.StepOSRecyclerView$u r0 = (stepos.support.v7.widget.StepOSRecyclerView.u) r0
                stepos.support.v7.widget.StepOSRecyclerView r3 = stepos.support.v7.widget.StepOSRecyclerView.this
                android.view.View r4 = r10.f21785a
                int r3 = r3.getChildLayoutPosition(r4)
                boolean r0 = r0.isEnabled(r3)
                goto L4c
            L4b:
                r0 = 1
            L4c:
                if (r7 < 0) goto L81
                java.lang.Class<androidx.recyclerview.widget.RecyclerView> r3 = androidx.recyclerview.widget.RecyclerView.class
                stepos.support.v7.widget.StepOSRecyclerView r4 = stepos.support.v7.widget.StepOSRecyclerView.this
                boolean r3 = stepos.support.v7.widget.x.h(r3, r4)
                if (r3 != 0) goto L81
                stepos.support.v7.widget.StepOSRecyclerView r3 = stepos.support.v7.widget.StepOSRecyclerView.this
                boolean r3 = r3.isAttachedToWindow()
                if (r3 == 0) goto L81
                if (r0 == 0) goto L81
                stepos.support.v7.widget.StepOSRecyclerView r0 = stepos.support.v7.widget.StepOSRecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r0 = r0.getAdapter()
                long r8 = r0.getItemId(r7)
                stepos.support.v7.widget.StepOSRecyclerView r0 = stepos.support.v7.widget.StepOSRecyclerView.this
                e5.c r0 = stepos.support.v7.widget.StepOSRecyclerView.k(r0)
                boolean r0 = r0.P()
                if (r0 != 0) goto L81
                stepos.support.v7.widget.StepOSRecyclerView r5 = stepos.support.v7.widget.StepOSRecyclerView.this
                android.view.View r6 = r10.f21785a
                r4 = r10
                r4.h(r5, r6, r7, r8)
                goto L82
            L81:
                r4 = r10
            L82:
                stepos.support.v7.widget.StepOSRecyclerView r10 = stepos.support.v7.widget.StepOSRecyclerView.this
                boolean r10 = stepos.support.v7.widget.StepOSRecyclerView.d0(r10)
                r0 = -1
                if (r10 == 0) goto L9c
                stepos.support.v7.widget.StepOSRecyclerView r10 = stepos.support.v7.widget.StepOSRecyclerView.this
                int r10 = stepos.support.v7.widget.StepOSRecyclerView.u(r10)
                if (r10 == r0) goto L9c
                stepos.support.v7.widget.StepOSRecyclerView r10 = stepos.support.v7.widget.StepOSRecyclerView.this
                int r3 = stepos.support.v7.widget.StepOSRecyclerView.u(r10)
                r10.q0(r0, r3)
            L9c:
                stepos.support.v7.widget.StepOSRecyclerView r10 = stepos.support.v7.widget.StepOSRecyclerView.this
                stepos.support.v7.widget.StepOSRecyclerView.v(r10)
                stepos.support.v7.widget.StepOSRecyclerView r10 = stepos.support.v7.widget.StepOSRecyclerView.this
                stepos.support.v7.widget.StepOSRecyclerView$e r10 = stepos.support.v7.widget.StepOSRecyclerView.x(r10)
                if (r10 != 0) goto Lb3
                stepos.support.v7.widget.StepOSRecyclerView r10 = stepos.support.v7.widget.StepOSRecyclerView.this
                stepos.support.v7.widget.StepOSRecyclerView$e r3 = new stepos.support.v7.widget.StepOSRecyclerView$e
                r3.<init>()
                stepos.support.v7.widget.StepOSRecyclerView.y(r10, r3)
            Lb3:
                stepos.support.v7.widget.StepOSRecyclerView r10 = stepos.support.v7.widget.StepOSRecyclerView.this
                int r10 = stepos.support.v7.widget.StepOSRecyclerView.a(r10)
                r3 = 3
                if (r10 == r3) goto Lce
                stepos.support.v7.widget.StepOSRecyclerView r10 = stepos.support.v7.widget.StepOSRecyclerView.this
                int r10 = stepos.support.v7.widget.StepOSRecyclerView.a(r10)
                if (r10 == 0) goto Lce
                stepos.support.v7.widget.StepOSRecyclerView r10 = stepos.support.v7.widget.StepOSRecyclerView.this
                int r10 = stepos.support.v7.widget.StepOSRecyclerView.a(r10)
                if (r10 != r2) goto Lcd
                goto Lce
            Lcd:
                return r1
            Lce:
                stepos.support.v7.widget.StepOSRecyclerView r10 = stepos.support.v7.widget.StepOSRecyclerView.this
                stepos.support.v7.widget.StepOSRecyclerView.c(r10, r0)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.StepOSRecyclerView.j.g():boolean");
        }

        public void j() {
            StepOSRecyclerView.this.setPressed(false);
            View view = this.f21785a;
            if (view != null) {
                view.setPressed(false);
            }
            Drawable drawable = StepOSRecyclerView.this.f21699M;
            if (drawable != null) {
                drawable.jumpToCurrentState();
            }
            StepOSRecyclerView.this.f21700Q.setEmpty();
            StepOSRecyclerView.this.f21709b = 3;
        }

        @Override // stepos.support.v7.widget.s.b
        public boolean onDown(MotionEvent motionEvent) {
            if (StepOSRecyclerView.this.f21709b == 4 && StepOSRecyclerView.this.getScrollState() == 1) {
                StepOSRecyclerView.this.f21709b = 3;
            } else {
                StepOSRecyclerView.this.f21709b = 0;
                int y5 = (int) motionEvent.getY();
                int x5 = (int) motionEvent.getX();
                StepOSRecyclerView stepOSRecyclerView = StepOSRecyclerView.this;
                Rect rect = stepOSRecyclerView.f21729l;
                if ((stepOSRecyclerView.f21713d != null || StepOSRecyclerView.this.f21726j0) && StepOSRecyclerView.this.f21737p && !StepOSRecyclerView.this.f21739q && StepOSRecyclerView.this.getScrollState() == 0 && e(x5, y5, rect, motionEvent) && StepOSRecyclerView.this.P0(x5, y5)) {
                    StepOSRecyclerView.this.f21751w = y5;
                }
                this.f21786b = true;
                StepOSRecyclerView.this.f21753x = x5;
                StepOSRecyclerView.this.f21755y = y5;
                this.f21785a = StepOSRecyclerView.this.findChildViewUnder(x5, y5);
            }
            StepOSRecyclerView.this.f21712c0 = false;
            StepOSRecyclerView.this.f21728k0 = -1;
            StepOSRecyclerView stepOSRecyclerView2 = StepOSRecyclerView.this;
            stepOSRecyclerView2.f21733n = stepOSRecyclerView2.f21731m;
            stepOSRecyclerView2.t0(true);
            StepOSRecyclerView.this.f21734n0 = false;
            return this.f21785a != null;
        }

        @Override // stepos.support.v7.widget.s.b
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f5, float f6) {
            this.f21786b = false;
            if (StepOSRecyclerView.this.f21709b == 3) {
                StepOSRecyclerView.this.f21709b = 4;
            }
            StepOSRecyclerView.this.f21700Q.setEmpty();
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0098  */
        @Override // stepos.support.v7.widget.s.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onLongPress(android.view.MotionEvent r9) {
            /*
                Method dump skipped, instructions count: 288
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.StepOSRecyclerView.j.onLongPress(android.view.MotionEvent):void");
        }

        @Override // stepos.support.v7.widget.s.b
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f5, float f6) {
            this.f21786b = false;
            j();
            return StepOSRecyclerView.this.c1(motionEvent2);
        }

        @Override // stepos.support.v7.widget.s.b
        public void onShowPress(MotionEvent motionEvent) {
            if (StepOSRecyclerView.this.f21709b == 3 || StepOSRecyclerView.this.f21744s0.P()) {
                return;
            }
            if (this.f21785a != null && !StepOSRecyclerView.this.f21735o) {
                int iY0 = StepOSRecyclerView.this.y0(this.f21785a);
                boolean zIsEnabled = StepOSRecyclerView.this.getAdapter() instanceof u ? ((u) StepOSRecyclerView.this.getAdapter()).isEnabled(iY0) : true;
                if (iY0 >= 0 && zIsEnabled) {
                    StepOSRecyclerView.this.setPressed(true);
                    this.f21785a.setPressed(true);
                    StepOSRecyclerView stepOSRecyclerView = StepOSRecyclerView.this;
                    stepOSRecyclerView.T0(stepOSRecyclerView.getChildLayoutPosition(this.f21785a), this.f21785a);
                    Drawable drawable = StepOSRecyclerView.this.f21699M;
                    if (drawable != null) {
                        drawable.setHotspot(motionEvent.getX(), motionEvent.getY());
                    }
                }
            }
            this.f21786b = false;
            StepOSRecyclerView.this.f21709b = 0;
            StepOSRecyclerView.this.f21712c0 = true;
        }

        @Override // stepos.support.v7.widget.s.b
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            boolean zIsEnabled;
            View view;
            if (StepOSRecyclerView.this.getAdapter() == null || !(StepOSRecyclerView.this.getAdapter() instanceof u) || (view = this.f21785a) == null) {
                zIsEnabled = true;
            } else {
                int childLayoutPosition = StepOSRecyclerView.this.getChildLayoutPosition(view);
                zIsEnabled = childLayoutPosition == -1 ? false : ((u) StepOSRecyclerView.this.getAdapter()).isEnabled(childLayoutPosition);
            }
            if (this.f21785a == null || x.h(RecyclerView.class, StepOSRecyclerView.this) || StepOSRecyclerView.this.f21709b != 0 || !zIsEnabled || (!StepOSRecyclerView.this.f21686A0 && StepOSRecyclerView.this.f21744s0.P())) {
                return false;
            }
            int i5 = this.f21786b ? StepOSRecyclerView.this.f21758z0 : 0;
            Log.d("StepOSRecyclerView", "mPressStateDuration " + StepOSRecyclerView.this.f21758z0 + " time " + i5);
            if (this.f21786b) {
                StepOSRecyclerView.this.setPressed(true);
                this.f21785a.setPressed(true);
                StepOSRecyclerView stepOSRecyclerView = StepOSRecyclerView.this;
                stepOSRecyclerView.T0(stepOSRecyclerView.getChildLayoutPosition(this.f21785a), this.f21785a);
                Drawable drawable = StepOSRecyclerView.this.f21699M;
                if (drawable != null) {
                    drawable.setHotspot(motionEvent.getX(), motionEvent.getY());
                }
            }
            StepOSRecyclerView.t(StepOSRecyclerView.this);
            StepOSRecyclerView.this.postDelayed(new a(), i5);
            StepOSRecyclerView.this.f21709b = -1;
            return false;
        }

        /* synthetic */ j(StepOSRecyclerView stepOSRecyclerView, a aVar) {
            this();
        }
    }

    public StepOSRecyclerView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f21707a = Math.tan(1.0471975824055166d);
        this.f21709b = -1;
        this.f21711c = 0;
        this.f21721h = false;
        this.f21727k = null;
        this.f21697K = true;
        this.f21698L = false;
        this.f21700Q = new Rect();
        this.f21701R = -1;
        this.f21702S = 0;
        this.f21703T = 0;
        this.f21704U = 0;
        this.f21705V = 0;
        this.f21706W = null;
        this.f21710b0 = false;
        this.f21712c0 = false;
        this.f21714d0 = false;
        this.f21722h0 = f21683D0;
        this.f21726j0 = false;
        this.f21728k0 = -1;
        this.f21732m0 = f21684E0;
        this.f21736o0 = false;
        this.f21738p0 = false;
        this.f21740q0 = new ArrayList<>();
        this.f21742r0 = new ArrayList<>();
        this.f21748u0 = true;
        this.f21750v0 = true;
        this.f21752w0 = false;
        this.f21756y0 = false;
        this.f21758z0 = ViewConfiguration.getPressedStateDuration();
        this.f21686A0 = false;
        this.f21688B0 = false;
        G0();
        this.f21725j = new i(context, new j(this, null));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, V4.c.f5582K1, i5, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(V4.c.f5585L1);
        if (drawable != null) {
            setSelector(drawable);
        }
        typedArrayObtainStyledAttributes.recycle();
        setOverScrollMode(2);
        OverScroller overScroller = new OverScroller(context, x.d(RecyclerView.class, this));
        this.f21746t0 = overScroller;
        this.f21744s0 = new e5.c(context, this, overScroller);
        H0();
        this.f21754x0 = stepos.support.v7.widget.n.b();
        if (TextUtils.equals(Build.BRAND, "Sony")) {
            this.f21686A0 = true;
        }
    }

    public void setEnableDragSelection(m mVar) {
        setEnableDragSelection(true);
    }

    public void setSelector(Drawable drawable) {
        Drawable drawable2 = this.f21699M;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f21699M);
        }
        this.f21699M = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        this.f21702S = rect.left;
        this.f21703T = rect.top;
        this.f21704U = rect.right;
        this.f21705V = rect.bottom;
        drawable.setCallback(this);
        k1();
    }
}
