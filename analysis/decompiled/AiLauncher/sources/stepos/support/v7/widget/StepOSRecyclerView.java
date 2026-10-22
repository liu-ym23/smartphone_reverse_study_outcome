package stepos.support.v7.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
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
import androidx.core.view.C1330s;
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
import stepos.support.v7.R$dimen;
import stepos.support.v7.R$drawable;
import stepos.support.v7.R$styleable;
import stepos.support.v7.widget.p;

/* loaded from: classes5.dex */
public class StepOSRecyclerView extends RecyclerView {

    /* renamed from: H0, reason: collision with root package name */
    public static boolean f41302H0 = false;

    /* renamed from: I0, reason: collision with root package name */
    public static float f41303I0 = Float.MAX_VALUE;

    /* renamed from: J0, reason: collision with root package name */
    public static int f41304J0 = -1;

    /* renamed from: A, reason: collision with root package name */
    public int f41305A;

    /* renamed from: A0, reason: collision with root package name */
    public boolean f41306A0;

    /* renamed from: B, reason: collision with root package name */
    public int f41307B;

    /* renamed from: B0, reason: collision with root package name */
    public boolean f41308B0;

    /* renamed from: C, reason: collision with root package name */
    public int f41309C;

    /* renamed from: C0, reason: collision with root package name */
    public stepos.support.v7.widget.l f41310C0;

    /* renamed from: D, reason: collision with root package name */
    public int f41311D;

    /* renamed from: D0, reason: collision with root package name */
    public boolean f41312D0;

    /* renamed from: E, reason: collision with root package name */
    public int f41313E;

    /* renamed from: E0, reason: collision with root package name */
    public int f41314E0;

    /* renamed from: F, reason: collision with root package name */
    public int f41315F;

    /* renamed from: F0, reason: collision with root package name */
    public boolean f41316F0;

    /* renamed from: G, reason: collision with root package name */
    public s f41317G;

    /* renamed from: G0, reason: collision with root package name */
    public boolean f41318G0;

    /* renamed from: H, reason: collision with root package name */
    public boolean f41319H;

    /* renamed from: I, reason: collision with root package name */
    public int f41320I;

    /* renamed from: J, reason: collision with root package name */
    public e f41321J;

    /* renamed from: K, reason: collision with root package name */
    public boolean f41322K;

    /* renamed from: L, reason: collision with root package name */
    public boolean f41323L;

    /* renamed from: M, reason: collision with root package name */
    public Drawable f41324M;

    /* renamed from: N, reason: collision with root package name */
    public Rect f41325N;

    /* renamed from: O, reason: collision with root package name */
    public int f41326O;

    /* renamed from: P, reason: collision with root package name */
    public int f41327P;

    /* renamed from: Q, reason: collision with root package name */
    public int f41328Q;

    /* renamed from: R, reason: collision with root package name */
    public int f41329R;

    /* renamed from: S, reason: collision with root package name */
    public int f41330S;

    /* renamed from: T, reason: collision with root package name */
    public Method f41331T;

    /* renamed from: U, reason: collision with root package name */
    public f f41332U;

    /* renamed from: V, reason: collision with root package name */
    public boolean f41333V;

    /* renamed from: W, reason: collision with root package name */
    public boolean f41334W;

    /* renamed from: a, reason: collision with root package name */
    public final double f41335a;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f41336a0;

    /* renamed from: b, reason: collision with root package name */
    public int f41337b;

    /* renamed from: b0, reason: collision with root package name */
    public float f41338b0;

    /* renamed from: c, reason: collision with root package name */
    public int f41339c;

    /* renamed from: c0, reason: collision with root package name */
    public float f41340c0;

    /* renamed from: d, reason: collision with root package name */
    public ActionMode f41341d;

    /* renamed from: d0, reason: collision with root package name */
    public r f41342d0;

    /* renamed from: e, reason: collision with root package name */
    public MultiChoiceModeWrapper f41343e;

    /* renamed from: e0, reason: collision with root package name */
    public float f41344e0;

    /* renamed from: f, reason: collision with root package name */
    public int f41345f;

    /* renamed from: f0, reason: collision with root package name */
    public HashSet<RecyclerView.ViewHolder> f41346f0;

    /* renamed from: g, reason: collision with root package name */
    public SparseBooleanArray f41347g;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f41348g0;

    /* renamed from: h, reason: collision with root package name */
    public boolean f41349h;

    /* renamed from: h0, reason: collision with root package name */
    public int f41350h0;

    /* renamed from: i, reason: collision with root package name */
    public androidx.collection.j<Integer> f41351i;

    /* renamed from: i0, reason: collision with root package name */
    public int[][] f41352i0;

    /* renamed from: j, reason: collision with root package name */
    public stepos.support.v7.widget.p f41353j;

    /* renamed from: j0, reason: collision with root package name */
    public int f41354j0;

    /* renamed from: k, reason: collision with root package name */
    public Runnable f41355k;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f41356k0;

    /* renamed from: l, reason: collision with root package name */
    public Rect f41357l;

    /* renamed from: m, reason: collision with root package name */
    public int f41358m;

    /* renamed from: n, reason: collision with root package name */
    public int f41359n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f41360o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f41361p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f41362q;

    /* renamed from: r, reason: collision with root package name */
    public int f41363r;

    /* renamed from: s, reason: collision with root package name */
    public int f41364s;

    /* renamed from: t, reason: collision with root package name */
    public int f41365t;

    /* renamed from: t0, reason: collision with root package name */
    public boolean f41366t0;

    /* renamed from: u, reason: collision with root package name */
    public int f41367u;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f41368u0;

    /* renamed from: v, reason: collision with root package name */
    public int f41369v;

    /* renamed from: v0, reason: collision with root package name */
    public ArrayList<d> f41370v0;

    /* renamed from: w, reason: collision with root package name */
    public int f41371w;

    /* renamed from: w0, reason: collision with root package name */
    public ArrayList<d> f41372w0;

    /* renamed from: x, reason: collision with root package name */
    public int f41373x;

    /* renamed from: x0, reason: collision with root package name */
    public final Lc.c f41374x0;

    /* renamed from: y, reason: collision with root package name */
    public int f41375y;

    /* renamed from: y0, reason: collision with root package name */
    public final OverScroller f41376y0;

    /* renamed from: z, reason: collision with root package name */
    public boolean f41377z;

    /* renamed from: z0, reason: collision with root package name */
    public boolean f41378z0;

    public class MultiChoiceModeWrapper implements l {

        /* renamed from: a, reason: collision with root package name */
        public l f41379a;

        public MultiChoiceModeWrapper() {
        }

        public boolean a() {
            return this.f41379a != null;
        }

        public void b(l lVar) {
            this.f41379a = lVar;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f41379a.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            if (!this.f41379a.onCreateActionMode(actionMode, menu)) {
                return false;
            }
            if (StepOSRecyclerView.this.f41339c == 4 || StepOSRecyclerView.this.f41339c == 5) {
                StepOSRecyclerView.this.setLongClickable(true);
            } else {
                StepOSRecyclerView.this.setLongClickable(false);
            }
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) throws NoSuchFieldException, SecurityException {
            if (StepOSRecyclerView.this.f41306A0) {
                StepOSRecyclerView.this.f41374x0.g0(true);
            }
            this.f41379a.onDestroyActionMode(actionMode);
            StepOSRecyclerView.this.f41341d = null;
            StepOSRecyclerView.this.f41308B0 = true;
            StepOSRecyclerView.this.k0();
            StepOSRecyclerView.this.e1();
            StepOSRecyclerView.this.setLongClickable(true);
            stepos.support.v7.widget.t.d(RecyclerView.class, StepOSRecyclerView.this);
            StepOSRecyclerView.this.getRecycledViewPool().clear();
        }

        @Override // stepos.support.v7.widget.StepOSRecyclerView.l
        public void onItemCheckedStateChanged(ActionMode actionMode, int i10, long j10, boolean z10) {
            this.f41379a.onItemCheckedStateChanged(actionMode, i10, j10, z10);
            if (StepOSRecyclerView.this.getCheckedItemCount() == 0) {
                int unused = StepOSRecyclerView.this.f41339c;
            }
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.f41379a.onPrepareActionMode(actionMode, menu);
        }
    }

    public static class StepOSSavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<StepOSSavedState> CREATOR = new a();
        androidx.collection.j<Integer> checkIdState;
        SparseBooleanArray checkState;
        int checkedItemCount;
        boolean inActionMode;

        public class a implements Parcelable.Creator<StepOSSavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public StepOSSavedState createFromParcel(Parcel parcel) {
                return new StepOSSavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public StepOSSavedState[] newArray(int i10) {
                return new StepOSSavedState[i10];
            }
        }

        public /* synthetic */ StepOSSavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        public String toString() {
            return "StepOSRecyclerView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " checkState=" + this.checkState + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeByte(this.inActionMode ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.checkedItemCount);
            parcel.writeSparseBooleanArray(this.checkState);
            androidx.collection.j<Integer> jVar = this.checkIdState;
            int iR = jVar != null ? jVar.r() : 0;
            parcel.writeInt(iR);
            for (int i11 = 0; i11 < iR; i11++) {
                parcel.writeLong(this.checkIdState.k(i11));
                parcel.writeInt(this.checkIdState.s(i11).intValue());
            }
        }

        public StepOSSavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private StepOSSavedState(Parcel parcel) {
            super(parcel);
            this.inActionMode = parcel.readByte() != 0;
            this.checkedItemCount = parcel.readInt();
            this.checkState = parcel.readSparseBooleanArray();
            int i10 = parcel.readInt();
            if (i10 > 0) {
                this.checkIdState = new androidx.collection.j<>();
                for (int i11 = 0; i11 < i10; i11++) {
                    this.checkIdState.n(parcel.readLong(), Integer.valueOf(parcel.readInt()));
                }
            }
        }
    }

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f41381a;

        /* renamed from: stepos.support.v7.widget.StepOSRecyclerView$a$a, reason: collision with other inner class name */
        public class RunnableC0526a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RecyclerView.ItemAnimator f41383a;

            public RunnableC0526a(RecyclerView.ItemAnimator itemAnimator) {
                this.f41383a = itemAnimator;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f41383a.endAnimations();
            }
        }

        public a(boolean z10) {
            this.f41381a = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView.Adapter adapter = StepOSRecyclerView.this.getAdapter();
            if (adapter != null) {
                adapter.notifyItemRangeChanged(0, StepOSRecyclerView.this.getItemCount());
                RecyclerView.ItemAnimator itemAnimator = StepOSRecyclerView.this.getItemAnimator();
                if (itemAnimator != null) {
                    StepOSRecyclerView.this.post(new RunnableC0526a(itemAnimator));
                }
                if (this.f41381a) {
                    StepOSRecyclerView.this.requestLayout();
                }
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StepOSRecyclerView.this.Y0();
            StepOSRecyclerView.this.f41355k = null;
        }
    }

    public static abstract class c<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements u {
        private int mHeadCount;
        private RecyclerView rv;

        public boolean areAllItemsEnabled() {
            return true;
        }

        public int immersiveItemType(int i10) {
            return 3;
        }

        public boolean isEnabled(int i10) {
            return true;
        }

        @Override // stepos.support.v7.widget.StepOSRecyclerView.u
        public boolean isSelectable(int i10) {
            return true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
            this.rv = recyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(VH vh, int i10) {
            StepOSRecyclerView stepOSRecyclerView = (StepOSRecyclerView) this.rv;
            stepOSRecyclerView.U0(vh.itemView, this.mHeadCount + i10);
            if (stepOSRecyclerView.f41318G0) {
                stepOSRecyclerView.S0(vh.itemView, immersiveItemType(i10));
            }
        }

        public void setHeadCount(int i10) {
            this.mHeadCount = i10;
        }
    }

    public class d {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.ViewHolder f41386a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f41387b;
    }

    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public OverScroller f41388a;

        /* renamed from: b, reason: collision with root package name */
        public int f41389b = 0;

        public e() {
            this.f41388a = new OverScroller(StepOSRecyclerView.this.getContext());
        }

        public void a() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            StepOSRecyclerView.this.f41337b = -1;
            StepOSRecyclerView.this.removeCallbacks(this);
            stepos.support.v7.widget.t.f(0, RecyclerView.class, StepOSRecyclerView.this);
            this.f41388a.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            OverScroller overScroller = this.f41388a;
            if (overScroller.isFinished()) {
                a();
                return;
            }
            overScroller.computeScrollOffset();
            int currY = overScroller.getCurrY();
            int currY2 = overScroller.getCurrY() - this.f41389b;
            this.f41389b = currY;
            if (currY2 != 0) {
                StepOSRecyclerView.this.b1(-currY2, true);
            }
            StepOSRecyclerView.this.invalidate();
            StepOSRecyclerView.this.postOnAnimation(this);
        }
    }

    public class f {

        /* renamed from: a, reason: collision with root package name */
        public View f41391a;

        /* renamed from: b, reason: collision with root package name */
        public int f41392b;

        /* renamed from: c, reason: collision with root package name */
        public long f41393c;

        public f(View view, int i10, long j10) {
            this.f41391a = view;
            this.f41392b = i10;
            this.f41393c = j10;
        }
    }

    public static abstract class g extends RecyclerView.ItemDecoration {

        /* renamed from: a, reason: collision with root package name */
        public HashSet<Integer> f41395a = new HashSet<>();

        /* renamed from: b, reason: collision with root package name */
        public HashSet<Integer> f41396b = new HashSet<>();

        public void a() {
            this.f41396b.clear();
        }

        public HashSet<Integer> b() {
            return this.f41395a;
        }

        public void c(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        }

        public void d(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        }

        public void e(HashSet<Integer> hashSet) {
            this.f41396b.addAll(hashSet);
        }
    }

    public interface h {
    }

    public class i extends stepos.support.v7.widget.p {

        /* renamed from: q, reason: collision with root package name */
        public j f41397q;

        /* renamed from: r, reason: collision with root package name */
        public int f41398r;

        /* renamed from: s, reason: collision with root package name */
        public int f41399s;

        /* renamed from: t, reason: collision with root package name */
        public int f41400t;

        /* renamed from: u, reason: collision with root package name */
        public int f41401u;

        /* renamed from: v, reason: collision with root package name */
        public VelocityTracker f41402v;

        public i(Context context, j jVar) {
            super(context, jVar);
            this.f41401u = -1;
            this.f41397q = jVar;
            this.f41400t = ViewConfiguration.get(context).getScaledTouchSlop();
        }

        @Override // stepos.support.v7.widget.p
        public boolean h(MotionEvent motionEvent) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (this.f41402v == null) {
                this.f41402v = VelocityTracker.obtain();
            }
            this.f41402v.addMovement(motionEvent);
            boolean zH = super.h(motionEvent);
            RecyclerView.LayoutManager layoutManager = StepOSRecyclerView.this.getLayoutManager();
            boolean z10 = false;
            if (layoutManager == null) {
                return false;
            }
            boolean zCanScrollHorizontally = layoutManager.canScrollHorizontally();
            boolean zCanScrollVertically = layoutManager.canScrollVertically();
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f41398r = (int) (motionEvent.getX() + 0.5f);
                this.f41399s = (int) (motionEvent.getY() + 0.5f);
                this.f41401u = C1330s.b(motionEvent, 0);
                return zH;
            }
            if (action == 1) {
                this.f41402v.computeCurrentVelocity(1000, StepOSRecyclerView.this.getMaxFlingVelocity());
                float f10 = zCanScrollHorizontally ? -this.f41402v.getXVelocity(this.f41401u) : 0.0f;
                if ((Math.abs(zCanScrollVertically ? -this.f41402v.getYVelocity(this.f41401u) : 0.0f) >= StepOSRecyclerView.this.getMinFlingVelocity() || Math.abs(f10) >= StepOSRecyclerView.this.getMinFlingVelocity()) && StepOSRecyclerView.this.f41337b == 3) {
                    StepOSRecyclerView.this.f41337b = 4;
                }
                this.f41397q.g();
                VelocityTracker velocityTracker = this.f41402v;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                }
                StepOSRecyclerView stepOSRecyclerView = StepOSRecyclerView.this;
                stepOSRecyclerView.f41359n = stepOSRecyclerView.f41358m;
                stepOSRecyclerView.q0(true);
                return zH;
            }
            if (action == 2) {
                int x10 = (int) (motionEvent.getX() + 0.5f);
                int y10 = (int) (motionEvent.getY() + 0.5f);
                int i10 = this.f41398r - x10;
                int i11 = this.f41399s - y10;
                if (zCanScrollHorizontally && Math.abs(i10) > this.f41400t) {
                    z10 = true;
                }
                boolean z11 = (!zCanScrollVertically || Math.abs(i11) <= this.f41400t) ? z10 : true;
                if (StepOSRecyclerView.this.f41337b == 2 && z11) {
                    this.f41397q.j();
                }
                if (z11) {
                    this.f41398r = x10;
                    this.f41399s = y10;
                }
            } else if (action == 3) {
                this.f41397q.f();
                VelocityTracker velocityTracker2 = this.f41402v;
                if (velocityTracker2 != null) {
                    velocityTracker2.clear();
                }
                StepOSRecyclerView stepOSRecyclerView2 = StepOSRecyclerView.this;
                stepOSRecyclerView2.f41359n = stepOSRecyclerView2.f41358m;
                stepOSRecyclerView2.q0(true);
                return zH;
            }
            return zH;
        }
    }

    public interface k {
    }

    public interface l extends ActionMode.Callback {
        void onItemCheckedStateChanged(ActionMode actionMode, int i10, long j10, boolean z10);
    }

    public interface m {
    }

    public interface n {
    }

    public interface o {
    }

    public interface p {
    }

    public class q {

        /* renamed from: a, reason: collision with root package name */
        public View f41408a;

        /* renamed from: b, reason: collision with root package name */
        public float f41409b;

        /* renamed from: c, reason: collision with root package name */
        public float f41410c;

        /* renamed from: d, reason: collision with root package name */
        public float f41411d;

        /* renamed from: e, reason: collision with root package name */
        public float f41412e;

        /* renamed from: f, reason: collision with root package name */
        public float f41413f;

        /* renamed from: g, reason: collision with root package name */
        public float f41414g;

        /* renamed from: h, reason: collision with root package name */
        public float f41415h;

        /* renamed from: i, reason: collision with root package name */
        public float f41416i;

        public float a() {
            return this.f41415h;
        }

        public float b() {
            return this.f41410c;
        }

        public float c() {
            return this.f41411d;
        }

        public float d() {
            return this.f41414g;
        }

        public float e() {
            return this.f41413f;
        }

        public float f() {
            return this.f41409b;
        }

        public float g() {
            return this.f41412e;
        }

        public void h(float f10) {
            this.f41414g = f10;
        }

        public void i(float f10) {
            this.f41413f = f10;
        }

        public void j(float f10) {
            this.f41416i = f10;
        }

        public void k(float f10) {
            if (this.f41408a == null) {
                return;
            }
            if (this.f41416i == StepOSRecyclerView.f41303I0) {
                this.f41416i = this.f41408a.getTranslationY();
            }
            this.f41415h = f10;
            View view = this.f41408a;
            if (view instanceof ScrollView) {
                view.scrollBy(0, (int) f10);
            } else {
                view.setTranslationY(this.f41416i + f10);
            }
        }
    }

    public class r {

        /* renamed from: e, reason: collision with root package name */
        public ValueAnimator f41421e;

        /* renamed from: i, reason: collision with root package name */
        public int f41425i;

        /* renamed from: a, reason: collision with root package name */
        public HashMap<View, q> f41417a = new HashMap<>();

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<q> f41418b = new ArrayList<>();

        /* renamed from: c, reason: collision with root package name */
        public TimeInterpolator f41419c = new LinearInterpolator();

        /* renamed from: d, reason: collision with root package name */
        public int f41420d = 500;

        /* renamed from: f, reason: collision with root package name */
        public int f41422f = 3;

        /* renamed from: g, reason: collision with root package name */
        public float f41423g = 0.0f;

        /* renamed from: h, reason: collision with root package name */
        public int f41424h = 5;

        /* renamed from: j, reason: collision with root package name */
        public boolean f41426j = true;

        public class a implements ValueAnimator.AnimatorUpdateListener {
            public a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                for (q qVar : r.this.f41417a.values()) {
                    qVar.k(((Float) valueAnimator.getAnimatedValue()).floatValue() * qVar.e());
                }
            }
        }

        public class b extends AnimatorListenerAdapter {
            public b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                r.this.f41426j = true;
                for (q qVar : r.this.f41417a.values()) {
                    qVar.h(qVar.a());
                    if (qVar.a() != 0.0f) {
                        r.this.f41426j = false;
                    } else {
                        qVar.j(StepOSRecyclerView.f41303I0);
                    }
                }
                if (r.this.f41426j) {
                    r.this.f41422f = 3;
                }
                if (r.this.f41426j) {
                    StepOSRecyclerView.Z(StepOSRecyclerView.this);
                }
            }
        }

        public r() {
        }

        public final float e(q qVar, float f10) {
            float f11;
            float fA = qVar.a();
            if (fA == 0.0f) {
                if (f10 > 0.0f) {
                    if (qVar.c() == 0.0f) {
                        return 0.0f;
                    }
                    float fD = qVar.d();
                    if (fD < 0.0f) {
                        fD *= Math.abs(qVar.c() / qVar.g());
                    }
                    float fB = fD + (qVar.b() * (f10 / this.f41424h));
                    return fB > qVar.c() ? qVar.c() : fB;
                }
                if (qVar.g() == 0.0f) {
                    return 0.0f;
                }
                float fD2 = qVar.d();
                if (fD2 > 0.0f) {
                    fD2 *= Math.abs(qVar.g() / qVar.c());
                }
                float f12 = fD2 + (qVar.f() * (f10 / this.f41424h));
                return f12 < qVar.g() ? qVar.g() : f12;
            }
            if (fA > 0.0f) {
                if (qVar.c() == 0.0f) {
                    return 0.0f;
                }
                float fD3 = qVar.d();
                if (fD3 < 0.0f) {
                    fD3 *= Math.abs(qVar.c() / qVar.g());
                }
                float fB2 = fD3 + (qVar.b() * (f10 / this.f41424h));
                f11 = fB2 >= 0.0f ? fB2 : 0.0f;
                return f11 > qVar.c() ? qVar.c() : f11;
            }
            if (qVar.g() == 0.0f) {
                return 0.0f;
            }
            float fD4 = qVar.d();
            if (fD4 > 0.0f) {
                fD4 *= Math.abs(qVar.g() / qVar.c());
            }
            float f13 = fD4 + (qVar.f() * (f10 / this.f41424h));
            f11 = f13 <= 0.0f ? f13 : 0.0f;
            return f11 < qVar.g() ? qVar.g() : f11;
        }

        public void f() {
            ValueAnimator valueAnimator = this.f41421e;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                return;
            }
            this.f41421e.cancel();
        }

        public boolean g() {
            return this.f41426j;
        }

        public void h() {
            Iterator<q> it = this.f41417a.values().iterator();
            while (it.hasNext()) {
                it.next().j(StepOSRecyclerView.f41303I0);
            }
        }

        public void i(int i10) {
            this.f41420d = i10;
        }

        public void j(boolean z10) {
            this.f41426j = z10;
        }

        public void k(int i10) {
            this.f41424h = i10;
        }

        public void l(TimeInterpolator timeInterpolator) {
            this.f41419c = timeInterpolator;
        }

        public void m() {
            if (this.f41422f == 3) {
                h();
                this.f41426j = true;
                StepOSRecyclerView.Z(StepOSRecyclerView.this);
                return;
            }
            this.f41425i = (int) (this.f41420d * this.f41423g);
            for (q qVar : this.f41417a.values()) {
                qVar.i(qVar.a());
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.f41421e = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new a());
            this.f41421e.addListener(new b());
            this.f41421e.setDuration(this.f41425i);
            this.f41421e.setInterpolator(this.f41419c);
            this.f41421e.start();
        }

        public void n(float f10) {
            if (f10 == 0.0f && this.f41422f == 3) {
                return;
            }
            this.f41422f = 3;
            this.f41423g = 0.0f;
            for (q qVar : this.f41417a.values()) {
                float fE = e(qVar, f10);
                if (fE > 0.0f) {
                    this.f41422f = 1;
                    this.f41423g = Math.abs(fE / qVar.c());
                } else if (fE < 0.0f) {
                    this.f41422f = 2;
                    this.f41423g = Math.abs(fE / qVar.g());
                }
                qVar.k(fE);
            }
        }
    }

    public final class s implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public boolean f41430a = true;

        /* renamed from: b, reason: collision with root package name */
        public boolean f41431b = false;

        public s() {
        }

        public void a() {
            this.f41431b = false;
            StepOSRecyclerView.this.removeCallbacks(this);
        }

        public boolean b() {
            return this.f41431b;
        }

        public void c(boolean z10) {
            this.f41430a = z10;
            this.f41431b = true;
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
                boolean r0 = r10.f41430a
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
                boolean r0 = stepos.support.v7.widget.t.e(r4, r5, r6, r7, r8, r9)
                stepos.support.v7.widget.StepOSRecyclerView r4 = stepos.support.v7.widget.StepOSRecyclerView.this
                stepos.support.v7.widget.StepOSRecyclerView.W(r4, r5, r3)
                stepos.support.v7.widget.StepOSRecyclerView r4 = stepos.support.v7.widget.StepOSRecyclerView.this
                int r4 = r4.r0(r2)
                if (r4 != r1) goto L22
                r1 = r2
                goto L23
            L22:
                r1 = r3
            L23:
                stepos.support.v7.widget.StepOSRecyclerView r5 = stepos.support.v7.widget.StepOSRecyclerView.this
                int r6 = r5.f41307B
                if (r6 == r4) goto L2c
                r5.c1(r6, r4)
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
                boolean r0 = stepos.support.v7.widget.t.e(r4, r5, r6, r7, r8, r9)
                stepos.support.v7.widget.StepOSRecyclerView r4 = stepos.support.v7.widget.StepOSRecyclerView.this
                stepos.support.v7.widget.StepOSRecyclerView.W(r4, r5, r3)
                stepos.support.v7.widget.StepOSRecyclerView r4 = stepos.support.v7.widget.StepOSRecyclerView.this
                int r4 = r4.r0(r3)
                if (r4 != r1) goto L53
                r1 = r2
                goto L54
            L53:
                r1 = r3
            L54:
                stepos.support.v7.widget.StepOSRecyclerView r5 = stepos.support.v7.widget.StepOSRecyclerView.this
                int r6 = r5.f41309C
                if (r6 == r4) goto L5d
                r5.n0(r6, r4)
            L5d:
                if (r0 != 0) goto L75
                stepos.support.v7.widget.StepOSRecyclerView r0 = stepos.support.v7.widget.StepOSRecyclerView.this
                int r0 = r0.getFirstPosition()
                stepos.support.v7.widget.StepOSRecyclerView r4 = stepos.support.v7.widget.StepOSRecyclerView.this
                int r4 = stepos.support.v7.widget.StepOSRecyclerView.Y(r4)
                int r0 = r0 + r4
                stepos.support.v7.widget.StepOSRecyclerView r4 = stepos.support.v7.widget.StepOSRecyclerView.this
                int r4 = stepos.support.v7.widget.StepOSRecyclerView.P(r4)
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
                Hc.c.a(r10, r0, r1, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.StepOSRecyclerView.s.run():void");
        }
    }

    public interface t {
        void adjustListItemSelectionBounds(Rect rect);
    }

    public interface u {
        boolean isEnabled(int i10);

        boolean isSelectable(int i10);
    }

    public StepOSRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static /* synthetic */ int C(StepOSRecyclerView stepOSRecyclerView) {
        int i10 = stepOSRecyclerView.f41345f;
        stepOSRecyclerView.f41345f = i10 + 1;
        return i10;
    }

    public static /* synthetic */ int D(StepOSRecyclerView stepOSRecyclerView) {
        int i10 = stepOSRecyclerView.f41345f;
        stepOSRecyclerView.f41345f = i10 - 1;
        return i10;
    }

    public static /* synthetic */ k F(StepOSRecyclerView stepOSRecyclerView) {
        stepOSRecyclerView.getClass();
        return null;
    }

    public static /* synthetic */ o N(StepOSRecyclerView stepOSRecyclerView) {
        stepOSRecyclerView.getClass();
        return null;
    }

    public static /* synthetic */ p Z(StepOSRecyclerView stepOSRecyclerView) {
        stepOSRecyclerView.getClass();
        return null;
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

    public static int m0(Context context, float f10) {
        return (int) TypedValue.applyDimension(1, f10, context.getResources().getDisplayMetrics());
    }

    public static /* synthetic */ h o(StepOSRecyclerView stepOSRecyclerView) {
        stepOSRecyclerView.getClass();
        return null;
    }

    public static void setAvoidNotifyItemRangeChanged(boolean z10) {
        f41302H0 = z10;
    }

    public static /* synthetic */ n u(StepOSRecyclerView stepOSRecyclerView) {
        stepOSRecyclerView.getClass();
        return null;
    }

    public int A0(View view) {
        return getLayoutManager().getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
    }

    public final Drawable B0(String str) {
        return getResources().getDrawable(getResources().getIdentifier(str, "drawable", getContext().getPackageName()));
    }

    public final boolean C0() {
        if (!this.f41348g0 && this.f41341d == null) {
            return false;
        }
        if (((getLayoutManager() instanceof LinearLayoutManager) || (getLayoutManager() instanceof StaggeredGridLayoutManager)) && !this.f41374x0.P()) {
            return this.f41360o || this.f41362q;
        }
        return false;
    }

    public final void D0() {
        Resources resources = getResources();
        this.f41360o = false;
        this.f41358m = resources.getDimensionPixelSize(R$dimen.stepos_list_check_width);
        this.f41320I = resources.getDimensionPixelSize(R$dimen.stepos_list_item_height);
        this.f41362q = false;
        this.f41363r = 0;
        this.f41364s = 0;
        this.f41365t = 0;
        this.f41367u = 0;
        this.f41369v = -1;
        this.f41371w = -1;
        this.f41305A = 0;
        this.f41317G = null;
        this.f41319H = false;
        this.f41311D = -1;
        this.f41307B = -1;
        this.f41309C = -1;
        this.f41315F = getResources().getDimensionPixelSize(R$dimen.stepos_recyclerview_scrollbar_padding);
    }

    public final void E0() {
        this.f41374x0.c0(0.99f);
        this.f41374x0.i0(228.0f);
        this.f41374x0.d0(0.5f);
    }

    public boolean F0(int i10) {
        SparseBooleanArray sparseBooleanArray;
        if (this.f41339c == 0 || (sparseBooleanArray = this.f41347g) == null) {
            return false;
        }
        return sparseBooleanArray.get(i10);
    }

    public boolean G0() {
        return this.f41374x0.Q();
    }

    public final boolean H0(Configuration configuration) {
        return (configuration.uiMode & 48) == 32;
    }

    public final boolean I0(View view) {
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
            if (point.y - (iArr[1] + view.getMeasuredHeight()) < m0(getContext(), 64.0f)) {
                return true;
            }
        }
        return false;
    }

    public final void J0() {
        K0(this.f41349h);
    }

    public final void K0(boolean z10) {
        if (f41302H0) {
            return;
        }
        post(new a(z10));
    }

    public final boolean L0(int i10, int i11) {
        View viewS0 = s0(i10, i11);
        if (viewS0 == null) {
            return false;
        }
        this.f41369v = v0(viewS0);
        this.f41365t = A0(viewS0);
        this.f41367u = w0(viewS0);
        this.f41363r = z0(viewS0);
        this.f41364s = x0(viewS0);
        return true;
    }

    public final void M0(Canvas canvas) {
        int itemDecorationCount = getItemDecorationCount();
        for (int i10 = 0; i10 < itemDecorationCount; i10++) {
            if (getItemDecorationAt(i10) instanceof g) {
                ((g) getItemDecorationAt(i10)).d(canvas, this, stepos.support.v7.widget.t.b(RecyclerView.class, this));
            }
        }
    }

    public final void N0() {
        if (this.f41339c == 5 && !this.f41308B0 && this.f41355k == null) {
            b bVar = new b();
            this.f41355k = bVar;
            post(bVar);
        }
    }

    public boolean O0() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        View childAt;
        if (getItemCount() == 0 || this.f41374x0.P()) {
            return false;
        }
        int firstPosition = getFirstPosition();
        if ((firstPosition == 0 && (childAt = getChildAt(0)) != null && childAt.getTop() >= getPaddingTop()) || getItemCount() == Integer.MAX_VALUE) {
            return false;
        }
        e eVar = this.f41321J;
        if (eVar != null) {
            eVar.a();
            this.f41321J = null;
        }
        if (firstPosition > getChildCount() * 2) {
            scrollToPosition(getChildCount() * 2);
        }
        smoothScrollToPosition(0);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void P0(int i10, View view) {
        boolean z10 = i10 != this.f41326O;
        if (i10 != -1) {
            this.f41326O = i10;
        }
        Rect rect = this.f41325N;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (view instanceof t) {
            ((t) view).adjustListItemSelectionBounds(rect);
        }
        rect.left -= this.f41327P;
        rect.top -= this.f41328Q;
        rect.right += this.f41329R;
        rect.bottom += this.f41330S;
        Drawable drawable = this.f41324M;
        if (drawable != null) {
            drawable.setBounds(rect);
            if (z10) {
                if (getVisibility() == 0) {
                    drawable.setVisible(true, false);
                }
                f1();
            }
        }
        refreshDrawableState();
    }

    public final void Q0() {
        int i10 = 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, getAdapter().getItemCount(), 2);
        int[][] iArr2 = this.f41352i0;
        if (iArr2 == null || iArr2.length >= iArr.length) {
            return;
        }
        while (true) {
            int[][] iArr3 = this.f41352i0;
            if (i10 >= iArr3.length) {
                this.f41352i0 = iArr;
                return;
            } else {
                iArr[i10] = iArr3[i10];
                i10++;
            }
        }
    }

    public final void R0(View view) {
        if (this.f41378z0 && I0(view)) {
            smoothScrollBy(0, m0(getContext(), 84.0f));
        }
    }

    @SuppressLint({"NewApi"})
    public void S0(View view, int i10) {
        if (this.f41318G0) {
            if (i10 == 0) {
                view.setBackground(B0("immersive_item_bkg_head"));
                return;
            }
            if (i10 == 1) {
                view.setBackground(B0("immersive_item_bkg_middle"));
                return;
            }
            if (i10 == 2) {
                view.setBackground(B0("immersive_item_bkg_foot"));
                return;
            }
            if (i10 == 3) {
                view.setBackground(B0("immersive_item_bkg_alone"));
                return;
            }
            if (i10 == 5) {
                view.setBackground(B0("immersive_item_bkg_head_related_setting"));
                return;
            }
            if (i10 == 6) {
                view.setBackground(B0("immersive_item_bkg_middle_related_setting"));
            } else if (i10 == 7) {
                view.setBackground(B0("immersive_item_bkg_foot_related_setting"));
            } else {
                view.setBackground(getContext().getDrawable(R$drawable.immmersive_item_bkg_title));
            }
        }
    }

    public void T0(int i10, boolean z10) {
        if (this.f41339c == 0) {
            return;
        }
        RecyclerView.Adapter adapter = getAdapter();
        if (z10 && this.f41339c == 4 && this.f41341d == null) {
            MultiChoiceModeWrapper multiChoiceModeWrapper = this.f41343e;
            if (multiChoiceModeWrapper == null || !multiChoiceModeWrapper.a()) {
                throw new IllegalStateException("RecyclerView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
            }
            this.f41341d = startActionMode(this.f41343e);
        }
        int i11 = this.f41339c;
        if (i11 == 4 || i11 == 5) {
            boolean z11 = this.f41347g.get(i10);
            this.f41347g.put(i10, z10);
            if (this.f41351i != null && adapter.hasStableIds()) {
                if (z10) {
                    this.f41351i.n(adapter.getItemId(i10), Integer.valueOf(i10));
                } else {
                    this.f41351i.g(adapter.getItemId(i10));
                }
            }
            if (z11 != z10) {
                if (z10) {
                    this.f41345f++;
                } else {
                    this.f41345f--;
                }
            }
            if (this.f41341d != null) {
                this.f41343e.onItemCheckedStateChanged(this.f41341d, i10, adapter.getItemId(i10), z10);
            }
        } else {
            boolean z12 = this.f41351i != null && adapter.hasStableIds();
            if (z10 || F0(i10)) {
                this.f41347g.clear();
                if (z12) {
                    this.f41351i.a();
                }
            }
            if (z10) {
                this.f41347g.put(i10, true);
                if (z12) {
                    this.f41351i.n(adapter.getItemId(i10), Integer.valueOf(i10));
                }
                this.f41345f = 1;
            } else if (this.f41347g.size() == 0 || !this.f41347g.valueAt(0)) {
                this.f41345f = 0;
            }
        }
        e1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void U0(View view, int i10) {
        SparseBooleanArray sparseBooleanArray;
        KeyEvent.Callback callbackFindViewById;
        if (view == 0 || this.f41339c == 0 || (sparseBooleanArray = this.f41347g) == null) {
            return;
        }
        boolean z10 = sparseBooleanArray.get(i10);
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(z10);
            return;
        }
        if (getContext().getApplicationInfo().targetSdkVersion >= 11) {
            int i11 = this.f41339c;
            if ((i11 == 4 || i11 == 5) && (callbackFindViewById = view.findViewById(R.id.checkbox)) != null && (callbackFindViewById instanceof Checkable)) {
                ((Checkable) callbackFindViewById).setChecked(this.f41341d != null || this.f41348g0);
            }
            view.setActivated(z10);
        }
    }

    public boolean V0(MotionEvent motionEvent) {
        float fAbs = Math.abs(motionEvent.getY() - this.f41375y);
        float fAbs2 = Math.abs(this.f41373x - motionEvent.getX());
        return fAbs2 != 0.0f && (fAbs > 60.0f || fAbs2 > 60.0f) && ((double) (fAbs / fAbs2)) < this.f41335a;
    }

    public boolean W0() {
        return (isFocused() && !isInTouchMode()) || isPressed();
    }

    public final boolean X0(MotionEvent motionEvent) {
        boolean z10;
        int x10 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        Rect rect = this.f41357l;
        if (this.f41341d == null && !this.f41348g0) {
            return false;
        }
        boolean z11 = this.f41361p;
        Class cls = Integer.TYPE;
        if (z11 && !this.f41362q && this.f41366t0 && this.f41368u0) {
            if (V0(motionEvent)) {
                this.f41313E = this.f41369v;
                this.f41371w = y10;
                this.f41305A = y10;
                this.f41362q = true;
                this.f41352i0 = (int[][]) Array.newInstance((Class<?>) cls, getAdapter().getItemCount(), 2);
                this.f41359n = getWidth();
                q0(true);
                super.onTouchEvent(MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0));
                this.f41337b = 3;
            }
        } else {
            if (z11 && !this.f41362q && this.f41371w >= 0) {
                this.f41313E = this.f41369v;
                this.f41371w = y10;
                this.f41305A = y10;
                this.f41362q = true;
                this.f41352i0 = (int[][]) Array.newInstance((Class<?>) cls, getAdapter().getItemCount(), 2);
                this.f41359n = getWidth();
                q0(true);
                super.onTouchEvent(MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0));
                this.f41337b = 3;
                return true;
            }
            if (this.f41377z) {
                return true;
            }
            boolean z12 = this.f41362q;
            if (z12 && (x10 < rect.left || x10 > rect.right)) {
                this.f41377z = true;
                s sVar = this.f41317G;
                if (sVar != null) {
                    sVar.a();
                }
                return true;
            }
            if (z12) {
                this.f41305A = this.f41371w;
                this.f41371w = y10;
            }
        }
        if (!this.f41362q) {
            return false;
        }
        if (this.f41319H) {
            if (L0(x10, y10)) {
                if (this.f41305A < 0) {
                    n0(-1, this.f41369v);
                } else {
                    c1(-1, this.f41369v);
                }
                this.f41319H = false;
            }
            return true;
        }
        if (g0(y10)) {
            if (this.f41317G == null) {
                this.f41317G = new s();
            }
            if (!this.f41317G.b()) {
                this.f41317G.c(y10 < getPaddingTop() + this.f41320I);
            }
            return true;
        }
        s sVar2 = this.f41317G;
        if (sVar2 != null && sVar2.b()) {
            this.f41317G.a();
        }
        if (y10 < this.f41365t || ((z10 = this.f41366t0) && x10 < this.f41363r)) {
            int i10 = this.f41313E;
            if (i10 != -1) {
                c1(-1, i10);
                this.f41313E = -1;
            }
            int i11 = this.f41309C;
            if (i11 != -1) {
                c1(-1, i11);
            }
            if (!L0(x10, y10) && !this.f41368u0) {
                int firstPosition = getFirstPosition();
                int i12 = this.f41307B;
                if (i12 != firstPosition) {
                    c1(i12, firstPosition);
                }
                this.f41309C = -1;
                this.f41307B = -1;
                this.f41319H = true;
                return true;
            }
            c1(this.f41307B, this.f41369v);
        } else if (y10 > this.f41367u || (z10 && x10 > this.f41364s)) {
            int i13 = this.f41313E;
            if (i13 != -1) {
                n0(-1, i13);
                this.f41313E = -1;
            }
            int i14 = this.f41307B;
            if (i14 != -1) {
                n0(-1, i14);
            }
            if (!L0(x10, y10) && !this.f41368u0) {
                int lastPosition = getLastPosition();
                int i15 = this.f41309C;
                if (i15 != lastPosition) {
                    n0(i15, lastPosition);
                }
                this.f41309C = -1;
                this.f41307B = -1;
                this.f41319H = true;
                return true;
            }
            n0(this.f41309C, this.f41369v);
        }
        return true;
    }

    public boolean Y0() {
        int i10 = this.f41339c;
        if ((i10 != 5 && i10 != 4) || this.f41341d != null) {
            return false;
        }
        ActionMode actionModeStartActionMode = startActionMode(this.f41343e);
        this.f41341d = actionModeStartActionMode;
        this.f41359n = this.f41358m;
        if (actionModeStartActionMode == null) {
            return false;
        }
        J0();
        return true;
    }

    public boolean Z0(int i10) {
        if (i10 >= 0) {
            return i10 < getHeaderViewsCount() || i10 >= getItemCount() - getFooterViewsCount();
        }
        return false;
    }

    public final void a1() {
        int itemDecorationCount = getItemDecorationCount();
        for (int i10 = 0; i10 < itemDecorationCount; i10++) {
            if (getItemDecorationAt(i10) instanceof g) {
                ((g) getItemDecorationAt(i10)).a();
            }
        }
        for (int i11 = 0; i11 < itemDecorationCount; i11++) {
            if (getItemDecorationAt(i11) instanceof g) {
                HashSet<Integer> hashSetB = ((g) getItemDecorationAt(i11)).b();
                for (int i12 = 0; i12 < itemDecorationCount; i12++) {
                    if (i11 != i12 && (getItemDecorationAt(i12) instanceof g)) {
                        ((g) getItemDecorationAt(i12)).e(hashSetB);
                    }
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        if (!(itemDecoration instanceof g)) {
            Log.i("StepOSRecyclerView", "you should use StepOSRecyclerView.ItemDecoration!! Otherwise, it may cause problems");
        }
        super.addItemDecoration(itemDecoration);
    }

    public final void b1(int i10, boolean z10) {
        if (getChildCountExt() == 0) {
            return;
        }
        if (z10) {
            offsetChildrenVertical(i10);
        }
        if (awakenScrollBars()) {
            return;
        }
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c1(int i10, int i11) {
        boolean zIsEnabled;
        boolean zIsSelectable;
        boolean z10;
        RecyclerView.Adapter adapter = getAdapter();
        int firstPosition = getFirstPosition();
        for (int i12 = i10 == -1 ? i11 : i10 - 1; i12 >= i11; i12--) {
            boolean z11 = true;
            if (getAdapter() instanceof u) {
                zIsEnabled = ((u) getAdapter()).isEnabled(i12);
                zIsSelectable = ((u) getAdapter()).isSelectable(i12);
            } else {
                zIsEnabled = true;
                zIsSelectable = true;
            }
            if (!zIsSelectable) {
                this.f41311D = -1;
            } else {
                if (i12 == this.f41311D) {
                    return;
                }
                if (getAdapter() == null || zIsEnabled) {
                    u0(i12 - firstPosition);
                    adapter.getItemId(i12);
                    boolean zF0 = F0(i12);
                    int[] iArr = this.f41352i0[i12];
                    int i13 = iArr[0];
                    if (i13 == 0) {
                        iArr[1] = zF0 ? 1 : 0;
                    }
                    int i14 = i13 + 1;
                    iArr[0] = i14;
                    int i15 = this.f41350h0;
                    if (i15 == -1) {
                        z10 = this.f41356k0 ? zF0 ? 1 : 0 : !zF0;
                        this.f41350h0 = z10 ? 1 : 0;
                        iArr[1] = z10 ? 1 : 0;
                    } else if (i14 % 2 == 0) {
                        z11 = false;
                        z10 = z11;
                    } else {
                        z11 = false;
                        z10 = z11;
                    }
                    if (z10 != zF0) {
                        T0(i12, z10);
                        this.f41310C0.c(this, 0);
                    }
                    this.f41307B = i12;
                    this.f41309C = -1;
                    this.f41311D = -1;
                }
            }
        }
    }

    public final void d1() {
        f fVar;
        int i10;
        RecyclerView.Adapter adapter = getAdapter();
        if (!adapter.hasStableIds() || (fVar = this.f41332U) == null || (i10 = fVar.f41392b) == -1) {
            return;
        }
        long j10 = fVar.f41393c;
        if (j10 != adapter.getItemId(i10)) {
            View view = this.f41332U.f41391a;
            if (view != null) {
                view.setHovered(false);
                h0(this.f41332U.f41391a);
            }
            f fVar2 = this.f41332U;
            fVar2.f41391a = null;
            fVar2.f41392b = -1;
            int iMin = Math.min(i10 + 20, adapter.getItemCount());
            for (int iMax = Math.max(0, i10 - 20); iMax < iMin; iMax++) {
                if (j10 == adapter.getItemId(iMax)) {
                    RecyclerView.ViewHolder viewHolderFindViewHolderForItemId = findViewHolderForItemId(j10);
                    if (viewHolderFindViewHolderForItemId != null) {
                        f fVar3 = this.f41332U;
                        fVar3.f41392b = iMax;
                        fVar3.f41391a = viewHolderFindViewHolderForItemId.itemView;
                        return;
                    }
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (!this.f41323L && !this.f41318G0) {
            o0(canvas);
        }
        super.dispatchDraw(canvas);
        a1();
        int itemDecorationCount = getItemDecorationCount();
        for (int i10 = 0; i10 < itemDecorationCount; i10++) {
            if (getItemDecorationAt(i10) instanceof g) {
                ((g) getItemDecorationAt(i10)).c(canvas, this, stepos.support.v7.widget.t.b(RecyclerView.class, this));
            }
        }
        M0(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSetPressed(boolean z10) {
    }

    public boolean dispatchStatusBarTap() {
        return O0();
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
    public void drawableStateChanged() {
        super.drawableStateChanged();
        f1();
    }

    public final void e1() {
        int childCountExt = getChildCountExt();
        for (int i10 = 0; i10 < childCountExt; i10++) {
            View viewU0 = u0(i10);
            U0(viewU0, v0(viewU0));
        }
    }

    public void f1() {
        if (this.f41324M != null) {
            if (W0()) {
                this.f41324M.setState(getDrawableState());
            } else {
                this.f41324M.setState(StateSet.NOTHING);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int i10, int i11) {
        this.f41374x0.C(i10, i11);
        return super.fling(i10, i11);
    }

    public boolean g0(int i10) {
        int childCountExt = getChildCountExt();
        if (childCountExt <= 0) {
            return false;
        }
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        View viewU0 = u0(0);
        int iV0 = v0(viewU0);
        boolean z10 = iV0 == 0 && viewU0.getTop() >= getPaddingTop();
        boolean z11 = i10 < paddingTop + this.f41320I;
        if (z10 && z11) {
            return false;
        }
        boolean z12 = iV0 + childCountExt == getItemCount() && u0(childCountExt - 1).getBottom() <= getHeight() - getPaddingBottom();
        boolean z13 = i10 > height - this.f41320I;
        if (z12 && z13) {
            return false;
        }
        return z11 || z13;
    }

    public final void g1() throws IllegalAccessException, Resources.NotFoundException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Drawable drawable;
        Log.i("StepOSRecyclerView", "useDefaultSelector,  try to get f10 res");
        try {
            drawable = getResources().getDrawable(getResources().getIdentifier("stepos_recyclerview_selector_f10", "drawable", getContext().getPackageName()));
        } catch (Exception e10) {
            Log.i("StepOSRecyclerView", "useDefaultSelector,  get f10 res fail , may be app code compression: " + e10);
            drawable = null;
        }
        if (drawable == null) {
            Log.i("StepOSRecyclerView", "useDefaultSelector, get f10 res fail, and try to reflect StepOSPressAnimationDrawable");
            try {
                int i10 = StepOSPressAnimationDrawable.f29502a;
                Object objNewInstance = StepOSPressAnimationDrawable.class.getConstructor(null).newInstance(null);
                if (objNewInstance instanceof Drawable) {
                    if (H0(getResources().getConfiguration())) {
                        Method declaredMethod = StepOSPressAnimationDrawable.class.getDeclaredMethod("setTint", Integer.TYPE);
                        declaredMethod.setAccessible(true);
                        declaredMethod.invoke(objNewInstance, -1);
                        Method declaredMethod2 = StepOSPressAnimationDrawable.class.getDeclaredMethod("setAlphaTo", Float.TYPE);
                        declaredMethod2.setAccessible(true);
                        declaredMethod2.invoke(objNewInstance, Float.valueOf(0.03f));
                    }
                    drawable = (Drawable) objNewInstance;
                }
            } catch (Exception e11) {
                Log.i("StepOSRecyclerView", "useDefaultSelector,  try to reflect StepOSPressAnimationDrawable fail " + e11);
            }
        }
        if (drawable == null) {
            Log.i("StepOSRecyclerView", "useDefaultSelector,  try to reflect StepOSPressAnimationDrawable fail , and to get old res");
            drawable = getResources().getDrawable(R$drawable.stepos_recyclerview_selector);
        }
        setSelector(drawable);
    }

    public int getCheckedItemCount() {
        return this.f41345f;
    }

    public long[] getCheckedItemIds() {
        if (this.f41339c == 0 || this.f41351i == null || getAdapter() == null) {
            return new long[0];
        }
        androidx.collection.j<Integer> jVar = this.f41351i;
        int iR = jVar.r();
        long[] jArr = new long[iR];
        for (int i10 = 0; i10 < iR; i10++) {
            jArr[i10] = jVar.k(i10);
        }
        return jArr;
    }

    public SparseBooleanArray getCheckedItemPositions() {
        if (this.f41339c != 0) {
            return this.f41347g;
        }
        return null;
    }

    public int getChoiceMode() {
        return this.f41339c;
    }

    public int getCount() {
        return getAdapter().getItemCount();
    }

    public int getFirstPosition() {
        View viewU0 = u0(0);
        if (viewU0 == null) {
            return -1;
        }
        return v0(viewU0);
    }

    public int getFooterViewsCount() {
        if (getAdapter() == null || !(getAdapter() instanceof stepos.support.v7.widget.m)) {
            return 0;
        }
        return ((stepos.support.v7.widget.m) getAdapter()).h();
    }

    public int getHeaderViewsCount() {
        if (getAdapter() == null || !(getAdapter() instanceof stepos.support.v7.widget.m)) {
            return 0;
        }
        return ((stepos.support.v7.widget.m) getAdapter()).i();
    }

    public int getLastPosition() {
        View viewU0 = u0(getChildCountExt() - 1);
        if (viewU0 == null) {
            return -1;
        }
        return v0(viewU0);
    }

    public final n getOnItemClickListener() {
        return null;
    }

    public final o getOnItemLongClickListener() {
        return null;
    }

    public Lc.c getSpringAnimationHelper() {
        return this.f41374x0;
    }

    public HashSet getViewHoldSet() {
        return this.f41346f0;
    }

    public final void h0(View view) {
        Drawable background = view.getBackground();
        if (background != null) {
            background.jumpToCurrentState();
        }
    }

    public final void i0(MotionEvent motionEvent) {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager) && !(layoutManager instanceof StaggeredGridLayoutManager)) {
            this.f41360o = false;
            this.f41361p = false;
            return;
        }
        if (getScrollY() != 0) {
            q0(true);
        } else {
            q0(false);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 || actionMasked == 2) {
            j0((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (actionMasked == 3) {
            this.f41360o = false;
        }
    }

    public final void j0(int i10, int i11) {
        Rect rect = this.f41357l;
        this.f41360o = rect != null && rect.contains(i10, i11);
        if (this.f41366t0 && this.f41368u0) {
            this.f41360o = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f41324M;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public void k0() {
        SparseBooleanArray sparseBooleanArray = this.f41347g;
        if (sparseBooleanArray != null) {
            sparseBooleanArray.clear();
        }
        androidx.collection.j<Integer> jVar = this.f41351i;
        if (jVar != null) {
            jVar.a();
        }
        this.f41345f = 0;
    }

    public void l0() {
        ActionMode actionMode;
        MultiChoiceModeWrapper multiChoiceModeWrapper;
        RecyclerView.Adapter adapter = getAdapter();
        if (this.f41339c == 0 || adapter == null || !adapter.hasStableIds()) {
            return;
        }
        int itemCount = getItemCount();
        this.f41347g.clear();
        int i10 = 0;
        boolean z10 = false;
        while (i10 < this.f41351i.r()) {
            long jK = this.f41351i.k(i10);
            int iIntValue = this.f41351i.s(i10).intValue();
            if (jK != adapter.getItemId(iIntValue)) {
                int iMax = Math.max(0, iIntValue - 20);
                int iMin = Math.min(iIntValue + 20, itemCount);
                while (true) {
                    if (iMax >= iMin) {
                        this.f41351i.g(jK);
                        i10--;
                        this.f41345f--;
                        ActionMode actionMode2 = this.f41341d;
                        if (actionMode2 != null && (multiChoiceModeWrapper = this.f41343e) != null) {
                            multiChoiceModeWrapper.onItemCheckedStateChanged(actionMode2, iIntValue, jK, false);
                        }
                        z10 = true;
                    } else {
                        if (jK == adapter.getItemId(iMax)) {
                            this.f41347g.put(iMax, true);
                            this.f41351i.q(i10, Integer.valueOf(iMax));
                            break;
                        }
                        iMax++;
                    }
                }
            } else {
                this.f41347g.put(iIntValue, true);
            }
            i10++;
        }
        if (!z10 || (actionMode = this.f41341d) == null) {
            return;
        }
        actionMode.invalidate();
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0089, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void n0(int r10, int r11) {
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
            int[][] r2 = r9.f41352i0
            if (r2 == 0) goto L11
            int r3 = r2.length
            if (r11 >= r3) goto L11
            int r2 = r2.length
            if (r10 < r2) goto L14
        L11:
            r9.Q0()
        L14:
            int[][] r2 = r9.f41352i0
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
            int r5 = r9.f41311D
            if (r10 != r5) goto L50
            goto La3
        L50:
            if (r2 == 0) goto L55
            if (r4 != 0) goto L55
            goto La0
        L55:
            int r4 = r10 - r3
            r9.u0(r4)
            r2.getItemId(r10)
            boolean r4 = r9.F0(r10)
            int[][] r5 = r9.f41352i0
            r5 = r5[r10]
            r6 = 0
            r7 = r5[r6]
            if (r7 != 0) goto L6c
            r5[r0] = r4
        L6c:
            int r7 = r7 + 1
            r5[r6] = r7
            int r8 = r9.f41350h0
            if (r8 != r1) goto L81
            boolean r7 = r9.f41356k0
            if (r7 == 0) goto L7a
            r7 = r4
            goto L7c
        L7a:
            r7 = r4 ^ 1
        L7c:
            r9.f41350h0 = r7
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
            r9.T0(r10, r7)
            stepos.support.v7.widget.l r4 = r9.f41310C0
            r4.c(r9, r6)
        L9a:
            r9.f41309C = r10
            r9.f41307B = r1
        L9e:
            r9.f41311D = r1
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
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.StepOSRecyclerView.n0(int, int):void");
    }

    public void o0(Canvas canvas) {
        if (this.f41325N.isEmpty()) {
            return;
        }
        Drawable drawable = this.f41324M;
        drawable.setBounds(this.f41325N);
        drawable.draw(canvas);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        if (t0((ViewGroup) getParent())) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        this.f41374x0.V(motionEvent);
        if ((getTranslationX() != 0.0f || getTranslationY() != 0.0f) && (parent = getParent()) != null && this.f41312D0) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) throws NoSuchFieldException, SecurityException {
        super.onLayout(z10, i10, i11, i12, i13);
        N0();
        RecyclerView.State stateB = stepos.support.v7.widget.t.b(RecyclerView.class, this);
        if (stepos.support.v7.widget.t.a(RecyclerView.State.class, stateB) == 1 && stateB.didStructureChange()) {
            l0();
            d1();
            setPressed(false);
            Drawable drawable = this.f41324M;
            if (drawable != null) {
                drawable.jumpToCurrentState();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i10, int i11) throws IllegalAccessException, Resources.NotFoundException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.f41324M == null) {
            g1();
        }
        super.onMeasure(i10, i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrolled(int i10, int i11) {
        if (this.f41336a0) {
            this.f41342d0.g();
        }
        super.onScrolled(i10, i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        q0(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        i0(motionEvent);
        if (isPressed() && this.f41374x0.P()) {
            setPressed(false);
        }
        if (!C0() && this.f41374x0.Y(motionEvent)) {
            ViewParent parent = getParent();
            if (parent != null && this.f41312D0) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            return true;
        }
        boolean zH = this.f41353j.h(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 1) {
            this.f41356k0 = false;
        }
        if (!zH && !this.f41362q) {
            return super.onTouchEvent(motionEvent);
        }
        if (zH && action == 0) {
            boolean zCanScrollHorizontally = getLayoutManager().canScrollHorizontally();
            int i10 = zCanScrollHorizontally;
            if (getLayoutManager().canScrollVertically()) {
                i10 = (zCanScrollHorizontally ? 1 : 0) | 2;
            }
            startNestedScroll(i10);
        }
        return true;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        f fVar;
        View view;
        super.onWindowFocusChanged(z10);
        if (!z10 || !this.f41333V || (fVar = this.f41332U) == null || (view = fVar.f41391a) == null) {
            return;
        }
        if (this.f41334W) {
            view.setHovered(true);
            this.f41334W = false;
        }
        this.f41332U.f41391a.setHovered(false);
        f fVar2 = this.f41332U;
        fVar2.f41391a = null;
        fVar2.f41393c = -1L;
        fVar2.f41392b = -1;
    }

    public final void p0() {
        this.f41371w = -1;
        this.f41373x = -1;
        this.f41375y = -1;
        this.f41305A = -1;
        this.f41362q = false;
        this.f41377z = false;
        this.f41313E = -1;
        this.f41309C = -1;
        this.f41307B = -1;
        this.f41369v = -1;
        this.f41319H = false;
        s sVar = this.f41317G;
        if (sVar != null) {
            sVar.a();
        }
    }

    public void q0(boolean z10) {
        if (this.f41357l == null) {
            Rect rect = new Rect();
            this.f41357l = rect;
            rect.setEmpty();
        }
        int i10 = this.f41339c;
        if (i10 != 4 && i10 != 5) {
            this.f41357l.setEmpty();
            return;
        }
        if (this.f41357l.isEmpty() || z10) {
            if (getLayoutDirection() == 1) {
                this.f41357l.left = getPaddingLeft();
                Rect rect2 = this.f41357l;
                rect2.right = rect2.left + this.f41359n;
                rect2.top = getPaddingTop();
                this.f41357l.bottom = getHeight() - getPaddingBottom();
                return;
            }
            this.f41357l.right = getWidth() - getPaddingRight();
            Rect rect3 = this.f41357l;
            rect3.left = rect3.right - this.f41359n;
            rect3.top = getPaddingTop();
            this.f41357l.bottom = getHeight() - getPaddingBottom();
        }
    }

    public int r0(boolean z10) {
        int childCountExt = getChildCountExt();
        int firstPosition = getFirstPosition();
        if (z10) {
            for (int i10 = 0; i10 < childCountExt; i10++) {
                View viewU0 = u0(i10);
                if (w0(viewU0) - (y0(viewU0) / 2) > getPaddingTop()) {
                    return firstPosition + i10;
                }
            }
            return -1;
        }
        for (int i11 = childCountExt - 1; i11 >= 0; i11--) {
            View viewU02 = u0(i11);
            if (A0(viewU02) + (y0(viewU02) / 2) < getHeight() - getPaddingBottom()) {
                return firstPosition + i11;
            }
        }
        return -1;
    }

    public final View s0(int i10, int i11) {
        for (int childCount = getLayoutManager().getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getLayoutManager().getChildAt(childCount);
            float translationY = childAt.getTranslationY();
            if (this.f41366t0) {
                float translationX = childAt.getTranslationX();
                float f10 = i10;
                if (f10 >= z0(childAt) + translationX && f10 <= x0(childAt) + translationX) {
                    float f11 = i11;
                    if (f11 >= A0(childAt) + translationY && f11 <= w0(childAt) + translationY) {
                        return childAt;
                    }
                }
            } else {
                float f12 = i11;
                if (f12 >= A0(childAt) + translationY && f12 <= w0(childAt) + translationY) {
                    return childAt;
                }
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        if (!(adapter instanceof u)) {
            Log.i("StepOSRecyclerView", "you should use StepOSRecyclerView.Adapter！！！ Otherwise, it may cause problems");
        }
        if (adapter != null && (this.f41370v0.size() > 0 || this.f41372w0.size() > 0)) {
            if (!(adapter instanceof stepos.support.v7.widget.m)) {
                adapter = new stepos.support.v7.widget.m(adapter);
            }
            stepos.support.v7.widget.m mVar = (stepos.support.v7.widget.m) adapter;
            Iterator<d> it = this.f41370v0.iterator();
            while (it.hasNext()) {
                mVar.g(it.next());
            }
            Iterator<d> it2 = this.f41372w0.iterator();
            while (it2.hasNext()) {
                mVar.f(it2.next());
            }
        }
        super.setAdapter(adapter);
        if (adapter != null) {
            boolean zHasStableIds = getAdapter().hasStableIds();
            if (this.f41339c != 0 && zHasStableIds && this.f41351i == null) {
                this.f41351i = new androidx.collection.j<>();
            }
        }
        k0();
    }

    public void setBaseDuration(int i10) {
        r rVar = this.f41342d0;
        if (rVar != null) {
            rVar.i(i10);
        }
    }

    public void setBottomOverScrollEnable(boolean z10) {
        this.f41374x0.b0(z10);
    }

    public void setCheckBoxIsAnimation(boolean z10) {
        if (this.f41322K != z10) {
            this.f41322K = z10;
        }
    }

    public void setChoiceMode(int i10) {
        this.f41339c = i10;
        ActionMode actionMode = this.f41341d;
        if (actionMode != null) {
            actionMode.finish();
            this.f41341d = null;
        } else if (this.f41348g0) {
            throw null;
        }
        if (this.f41339c != 0) {
            if (this.f41347g == null) {
                this.f41347g = new SparseBooleanArray(0);
            }
            RecyclerView.Adapter adapter = getAdapter();
            if (this.f41351i == null && adapter != null && adapter.hasStableIds()) {
                this.f41351i = new androidx.collection.j<>(0);
            }
            if (this.f41339c == 4) {
                k0();
                setLongClickable(true);
            }
        }
    }

    public void setDrawSelectorOnTop(boolean z10) {
        this.f41323L = z10;
    }

    public void setEnableDragSelection(boolean z10) {
        this.f41361p = z10;
    }

    public void setEnableHoldPress(boolean z10) {
        this.f41333V = z10;
    }

    public void setEnableParallax(boolean z10) {
        if (z10) {
            if (this.f41342d0 == null) {
                this.f41342d0 = new r();
            }
            if (this.f41346f0 == null) {
                this.f41346f0 = new HashSet<>();
            }
        }
        this.f41336a0 = z10;
    }

    public void setEndOverScrollEnable(boolean z10) {
        this.f41374x0.e0(z10);
    }

    public void setItenFilter(h hVar) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        Lc.c cVar = this.f41374x0;
        if (cVar != null && layoutManager != null) {
            cVar.f0(layoutManager.canScrollVertically() ? 1 : 0);
        }
        this.f41366t0 = (layoutManager instanceof GridLayoutManager) || (layoutManager instanceof StaggeredGridLayoutManager) || this.f41368u0;
    }

    public void setMultiChoiceListener(k kVar) {
    }

    public void setMultiChoiceModeListener(l lVar) {
        if (this.f41343e == null) {
            this.f41343e = new MultiChoiceModeWrapper();
        }
        this.f41343e.b(lVar);
    }

    public void setOnItemClickListener(n nVar) {
    }

    public void setOnItemLongClickListener(o oVar) {
        if (isLongClickable()) {
            return;
        }
        setLongClickable(true);
    }

    public void setOverScrollEnable(boolean z10) {
        this.f41306A0 = z10;
        this.f41374x0.g0(z10);
    }

    public void setParallaxAnimationListener(p pVar) {
    }

    public void setPinnedHeaderDecoration(Kc.a aVar) {
    }

    public void setPressStateDuration(int i10) {
        this.f41314E0 = i10;
    }

    @Deprecated
    public void setRequestLayoutWhenSwitchActionMode(boolean z10) {
        this.f41349h = z10;
    }

    public void setScrollSensitivity(int i10) {
        r rVar = this.f41342d0;
        if (rVar != null) {
            rVar.k(i10);
        }
    }

    public void setScrollUpByItemCoveredInMultiChoiceEnable(boolean z10) {
        this.f41378z0 = z10;
    }

    public void setSelector(int i10) {
        setSelector(getResources().getDrawable(i10));
    }

    public void setShouldRequestDisallowInterceptTouchEventWhenOverScroll(boolean z10) {
        this.f41312D0 = z10;
    }

    public void setSmoothBackInterpolator(TimeInterpolator timeInterpolator) {
        r rVar;
        if (timeInterpolator == null || (rVar = this.f41342d0) == null) {
            return;
        }
        rVar.l(timeInterpolator);
    }

    public void setStartOverScrollEnable(boolean z10) {
        this.f41374x0.h0(z10);
    }

    public void setTopOverScrollEnable(boolean z10) {
        this.f41374x0.j0(z10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void swapAdapter(RecyclerView.Adapter adapter, boolean z10) {
        if (this.f41370v0.size() > 0 || this.f41372w0.size() > 0) {
            if (!(adapter instanceof stepos.support.v7.widget.m)) {
                adapter = new stepos.support.v7.widget.m(adapter);
            }
            stepos.support.v7.widget.m mVar = (stepos.support.v7.widget.m) adapter;
            Iterator<d> it = this.f41370v0.iterator();
            while (it.hasNext()) {
                mVar.g(it.next());
            }
            Iterator<d> it2 = this.f41372w0.iterator();
            while (it2.hasNext()) {
                mVar.f(it2.next());
            }
        }
        super.swapAdapter(adapter, z10);
        if (adapter != null) {
            boolean zHasStableIds = getAdapter().hasStableIds();
            if (this.f41339c != 0 && zHasStableIds && this.f41351i == null) {
                this.f41351i = new androidx.collection.j<>();
            }
        }
        k0();
    }

    public final boolean t0(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (viewGroup instanceof RecyclerView) {
            return true;
        }
        ViewParent parent = viewGroup.getParent();
        if (parent instanceof ViewGroup) {
            return t0((ViewGroup) parent);
        }
        return false;
    }

    public View u0(int i10) {
        return getLayoutManager().getChildAt(i10);
    }

    public final int v0(View view) {
        if (view == null) {
            return -1;
        }
        return getChildLayoutPosition(view);
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return this.f41324M == drawable || super.verifyDrawable(drawable);
    }

    public int w0(View view) {
        return getLayoutManager().getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    public int x0(View view) {
        return getLayoutManager().getDecoratedRight(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).getMarginEnd();
    }

    public int y0(View view) {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return layoutManager.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
    }

    public int z0(View view) {
        return getLayoutManager().getDecoratedLeft(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).getMarginStart();
    }

    public class j implements p.b {

        /* renamed from: a, reason: collision with root package name */
        public View f41404a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f41405b;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (j.this.f41404a != null) {
                    StepOSRecyclerView.this.setPressed(false);
                    j.this.f41404a.setPressed(false);
                    j jVar = j.this;
                    int iV0 = StepOSRecyclerView.this.v0(jVar.f41404a);
                    if (iV0 >= 0 && !stepos.support.v7.widget.t.g(RecyclerView.class, StepOSRecyclerView.this) && StepOSRecyclerView.this.isAttachedToWindow()) {
                        long itemId = StepOSRecyclerView.this.getAdapter().getItemId(iV0);
                        j jVar2 = j.this;
                        jVar2.h(StepOSRecyclerView.this, jVar2.f41404a, iV0, itemId);
                    }
                    j.this.f41404a = null;
                    j.this.f41405b = false;
                }
            }
        }

        public j() {
            this.f41405b = false;
        }

        public final boolean e(int i10, int i11, Rect rect, MotionEvent motionEvent) {
            int i12;
            boolean z10 = i10 >= rect.left && i10 <= rect.right;
            if (StepOSRecyclerView.this.f41366t0 && StepOSRecyclerView.this.f41368u0) {
                return true;
            }
            if (StepOSRecyclerView.this.f41366t0) {
                int rawY = (int) motionEvent.getRawY();
                int rawX = (int) motionEvent.getRawX();
                View viewS0 = StepOSRecyclerView.this.s0(i10, i11);
                View viewFindViewById = viewS0 == null ? null : viewS0.findViewById(R.id.checkbox);
                if (viewFindViewById != null && (viewFindViewById instanceof Checkable)) {
                    int[] iArr = new int[2];
                    viewFindViewById.getLocationOnScreen(iArr);
                    int i13 = iArr[0];
                    return rawX >= i13 && rawX <= i13 + viewFindViewById.getWidth() && rawY >= (i12 = iArr[1]) && rawY <= i12 + viewFindViewById.getHeight();
                }
            }
            return z10;
        }

        public void f() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            StepOSRecyclerView.this.p0();
            StepOSRecyclerView.this.f41337b = -1;
            stepos.support.v7.widget.t.f(0, RecyclerView.class, StepOSRecyclerView.this);
            View view = this.f41404a;
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
                android.view.View r0 = r10.f41404a
                r1 = 0
                if (r0 == 0) goto L13
                boolean r0 = r10.f41405b
                if (r0 != 0) goto L13
                stepos.support.v7.widget.StepOSRecyclerView r0 = stepos.support.v7.widget.StepOSRecyclerView.this
                r0.setPressed(r1)
                android.view.View r0 = r10.f41404a
                r0.setPressed(r1)
            L13:
                stepos.support.v7.widget.StepOSRecyclerView r0 = stepos.support.v7.widget.StepOSRecyclerView.this
                int r0 = stepos.support.v7.widget.StepOSRecyclerView.b(r0)
                r2 = 2
                if (r0 != r2) goto L81
                stepos.support.v7.widget.StepOSRecyclerView r0 = stepos.support.v7.widget.StepOSRecyclerView.this
                android.view.View r3 = r10.f41404a
                int r7 = stepos.support.v7.widget.StepOSRecyclerView.n(r0, r3)
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
                android.view.View r4 = r10.f41404a
                int r3 = r3.getChildLayoutPosition(r4)
                boolean r0 = r0.isEnabled(r3)
                goto L4c
            L4b:
                r0 = 1
            L4c:
                if (r7 < 0) goto L81
                java.lang.Class<androidx.recyclerview.widget.RecyclerView> r3 = androidx.recyclerview.widget.RecyclerView.class
                stepos.support.v7.widget.StepOSRecyclerView r4 = stepos.support.v7.widget.StepOSRecyclerView.this
                boolean r3 = stepos.support.v7.widget.t.g(r3, r4)
                if (r3 != 0) goto L81
                stepos.support.v7.widget.StepOSRecyclerView r3 = stepos.support.v7.widget.StepOSRecyclerView.this
                boolean r3 = r3.isAttachedToWindow()
                if (r3 == 0) goto L81
                if (r0 == 0) goto L81
                stepos.support.v7.widget.StepOSRecyclerView r0 = stepos.support.v7.widget.StepOSRecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r0 = r0.getAdapter()
                long r8 = r0.getItemId(r7)
                stepos.support.v7.widget.StepOSRecyclerView r0 = stepos.support.v7.widget.StepOSRecyclerView.this
                Lc.c r0 = stepos.support.v7.widget.StepOSRecyclerView.l(r0)
                boolean r0 = r0.P()
                if (r0 != 0) goto L81
                stepos.support.v7.widget.StepOSRecyclerView r5 = stepos.support.v7.widget.StepOSRecyclerView.this
                android.view.View r6 = r10.f41404a
                r4 = r10
                r4.h(r5, r6, r7, r8)
                goto L82
            L81:
                r4 = r10
            L82:
                stepos.support.v7.widget.StepOSRecyclerView r10 = stepos.support.v7.widget.StepOSRecyclerView.this
                boolean r10 = stepos.support.v7.widget.StepOSRecyclerView.e0(r10)
                r0 = -1
                if (r10 == 0) goto L9c
                stepos.support.v7.widget.StepOSRecyclerView r10 = stepos.support.v7.widget.StepOSRecyclerView.this
                int r10 = stepos.support.v7.widget.StepOSRecyclerView.v(r10)
                if (r10 == r0) goto L9c
                stepos.support.v7.widget.StepOSRecyclerView r10 = stepos.support.v7.widget.StepOSRecyclerView.this
                int r3 = stepos.support.v7.widget.StepOSRecyclerView.v(r10)
                r10.n0(r0, r3)
            L9c:
                stepos.support.v7.widget.StepOSRecyclerView r10 = stepos.support.v7.widget.StepOSRecyclerView.this
                stepos.support.v7.widget.StepOSRecyclerView.w(r10)
                stepos.support.v7.widget.StepOSRecyclerView r10 = stepos.support.v7.widget.StepOSRecyclerView.this
                stepos.support.v7.widget.StepOSRecyclerView$e r10 = stepos.support.v7.widget.StepOSRecyclerView.y(r10)
                if (r10 != 0) goto Lb3
                stepos.support.v7.widget.StepOSRecyclerView r10 = stepos.support.v7.widget.StepOSRecyclerView.this
                stepos.support.v7.widget.StepOSRecyclerView$e r3 = new stepos.support.v7.widget.StepOSRecyclerView$e
                r3.<init>()
                stepos.support.v7.widget.StepOSRecyclerView.z(r10, r3)
            Lb3:
                stepos.support.v7.widget.StepOSRecyclerView r10 = stepos.support.v7.widget.StepOSRecyclerView.this
                int r10 = stepos.support.v7.widget.StepOSRecyclerView.b(r10)
                r3 = 3
                if (r10 == r3) goto Lce
                stepos.support.v7.widget.StepOSRecyclerView r10 = stepos.support.v7.widget.StepOSRecyclerView.this
                int r10 = stepos.support.v7.widget.StepOSRecyclerView.b(r10)
                if (r10 == 0) goto Lce
                stepos.support.v7.widget.StepOSRecyclerView r10 = stepos.support.v7.widget.StepOSRecyclerView.this
                int r10 = stepos.support.v7.widget.StepOSRecyclerView.b(r10)
                if (r10 != r2) goto Lcd
                goto Lce
            Lcd:
                return r1
            Lce:
                stepos.support.v7.widget.StepOSRecyclerView r10 = stepos.support.v7.widget.StepOSRecyclerView.this
                stepos.support.v7.widget.StepOSRecyclerView.e(r10, r0)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.StepOSRecyclerView.j.g():boolean");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final boolean h(RecyclerView recyclerView, View view, int i10, long j10) {
            boolean z10;
            if (StepOSRecyclerView.this.Z0(i10)) {
                return true;
            }
            boolean z11 = false;
            if (StepOSRecyclerView.this.f41339c != 0) {
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                boolean zIsSelectable = adapter instanceof u ? ((u) adapter).isSelectable(i10) : true;
                if ((StepOSRecyclerView.this.f41339c == 4 || StepOSRecyclerView.this.f41339c == 5) && ((StepOSRecyclerView.this.f41341d != null || StepOSRecyclerView.this.f41348g0) && zIsSelectable)) {
                    boolean z12 = StepOSRecyclerView.this.f41347g.get(i10, false);
                    boolean z13 = !z12;
                    StepOSRecyclerView.this.f41347g.put(i10, z13);
                    if (StepOSRecyclerView.this.f41351i != null && adapter.hasStableIds()) {
                        if (z12) {
                            StepOSRecyclerView.this.f41351i.g(adapter.getItemId(i10));
                        } else {
                            StepOSRecyclerView.this.f41351i.n(adapter.getItemId(i10), Integer.valueOf(i10));
                        }
                    }
                    if (z12) {
                        StepOSRecyclerView.D(StepOSRecyclerView.this);
                    } else {
                        StepOSRecyclerView.C(StepOSRecyclerView.this);
                    }
                    if (StepOSRecyclerView.this.f41341d != null) {
                        StepOSRecyclerView.this.f41343e.onItemCheckedStateChanged(StepOSRecyclerView.this.f41341d, i10, j10, z13);
                    } else {
                        if (StepOSRecyclerView.this.f41348g0) {
                            StepOSRecyclerView.F(StepOSRecyclerView.this);
                        }
                        z11 = true;
                    }
                    z10 = z11;
                    z11 = true;
                } else {
                    z10 = true;
                }
                if (z11) {
                    StepOSRecyclerView.this.e1();
                }
                z11 = true;
            } else {
                z10 = true;
            }
            if (z10) {
                StepOSRecyclerView.u(StepOSRecyclerView.this);
            }
            if (z10 && StepOSRecyclerView.this.f41333V) {
                if (!StepOSRecyclerView.this.f41334W) {
                    view.setHovered(true);
                }
                if (StepOSRecyclerView.this.f41332U == null) {
                    StepOSRecyclerView stepOSRecyclerView = StepOSRecyclerView.this;
                    stepOSRecyclerView.f41332U = stepOSRecyclerView.new f(view, i10, j10);
                    return z11;
                }
                StepOSRecyclerView.this.f41332U.f41391a = view;
                StepOSRecyclerView.this.f41332U.f41392b = i10;
                StepOSRecyclerView.this.f41332U.f41393c = j10;
            }
            return z11;
        }

        public final boolean i(RecyclerView recyclerView, int i10, long j10) {
            if (StepOSRecyclerView.this.Z0(i10)) {
                return true;
            }
            if (StepOSRecyclerView.this.f41339c == 4 || StepOSRecyclerView.this.f41339c == 5) {
                if (StepOSRecyclerView.this.getAdapter() instanceof u ? ((u) StepOSRecyclerView.this.getAdapter()).isSelectable(i10) : true) {
                    if (StepOSRecyclerView.this.f41343e == null) {
                        StepOSRecyclerView.F(StepOSRecyclerView.this);
                    } else if (StepOSRecyclerView.this.f41341d == null) {
                        StepOSRecyclerView stepOSRecyclerView = StepOSRecyclerView.this;
                        if (stepOSRecyclerView.f41341d = recyclerView.startActionMode(stepOSRecyclerView.f41343e) != null) {
                            StepOSRecyclerView.this.T0(i10, true);
                            recyclerView.performHapticFeedback(0);
                            StepOSRecyclerView.this.R0(this.f41404a);
                            StepOSRecyclerView.this.K0(false);
                        }
                    }
                    return true;
                }
            }
            StepOSRecyclerView.N(StepOSRecyclerView.this);
            if (StepOSRecyclerView.this.f41361p) {
                StepOSRecyclerView.this.f41311D = i10;
            }
            return false;
        }

        public void j() {
            StepOSRecyclerView.this.setPressed(false);
            View view = this.f41404a;
            if (view != null) {
                view.setPressed(false);
            }
            Drawable drawable = StepOSRecyclerView.this.f41324M;
            if (drawable != null) {
                drawable.jumpToCurrentState();
            }
            StepOSRecyclerView.this.f41325N.setEmpty();
            StepOSRecyclerView.this.f41337b = 3;
        }

        @Override // stepos.support.v7.widget.p.b
        public boolean onDown(MotionEvent motionEvent) {
            if (StepOSRecyclerView.this.f41337b == 4 && StepOSRecyclerView.this.getScrollState() == 1) {
                StepOSRecyclerView.this.f41337b = 3;
            } else {
                StepOSRecyclerView.this.f41337b = 0;
                int y10 = (int) motionEvent.getY();
                int x10 = (int) motionEvent.getX();
                StepOSRecyclerView stepOSRecyclerView = StepOSRecyclerView.this;
                Rect rect = stepOSRecyclerView.f41357l;
                if ((stepOSRecyclerView.f41341d != null || StepOSRecyclerView.this.f41348g0) && StepOSRecyclerView.this.f41361p && !StepOSRecyclerView.this.f41362q && StepOSRecyclerView.this.getScrollState() == 0 && e(x10, y10, rect, motionEvent) && StepOSRecyclerView.this.L0(x10, y10)) {
                    StepOSRecyclerView.this.f41371w = y10;
                }
                this.f41405b = true;
                StepOSRecyclerView.this.f41373x = x10;
                StepOSRecyclerView.this.f41375y = y10;
                this.f41404a = StepOSRecyclerView.this.findChildViewUnder(x10, y10);
            }
            StepOSRecyclerView.this.f41334W = false;
            StepOSRecyclerView.this.f41350h0 = -1;
            StepOSRecyclerView stepOSRecyclerView2 = StepOSRecyclerView.this;
            stepOSRecyclerView2.f41359n = stepOSRecyclerView2.f41358m;
            stepOSRecyclerView2.q0(true);
            StepOSRecyclerView.this.f41356k0 = false;
            return this.f41404a != null;
        }

        @Override // stepos.support.v7.widget.p.b
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            this.f41405b = false;
            if (StepOSRecyclerView.this.f41337b == 3) {
                StepOSRecyclerView.this.f41337b = 4;
            }
            StepOSRecyclerView.this.f41325N.setEmpty();
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0098  */
        @Override // stepos.support.v7.widget.p.b
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

        @Override // stepos.support.v7.widget.p.b
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            this.f41405b = false;
            j();
            return StepOSRecyclerView.this.X0(motionEvent2);
        }

        @Override // stepos.support.v7.widget.p.b
        public void onShowPress(MotionEvent motionEvent) {
            if (StepOSRecyclerView.this.f41337b == 3 || StepOSRecyclerView.this.f41374x0.P()) {
                return;
            }
            if (this.f41404a != null && !StepOSRecyclerView.this.f41360o) {
                int iV0 = StepOSRecyclerView.this.v0(this.f41404a);
                boolean zIsEnabled = StepOSRecyclerView.this.getAdapter() instanceof u ? ((u) StepOSRecyclerView.this.getAdapter()).isEnabled(iV0) : true;
                if (iV0 >= 0 && zIsEnabled) {
                    StepOSRecyclerView.this.setPressed(true);
                    this.f41404a.setPressed(true);
                    StepOSRecyclerView stepOSRecyclerView = StepOSRecyclerView.this;
                    stepOSRecyclerView.P0(stepOSRecyclerView.getChildLayoutPosition(this.f41404a), this.f41404a);
                    Drawable drawable = StepOSRecyclerView.this.f41324M;
                    if (drawable != null) {
                        drawable.setHotspot(motionEvent.getX(), motionEvent.getY());
                    }
                }
            }
            this.f41405b = false;
            StepOSRecyclerView.this.f41337b = 0;
            StepOSRecyclerView.this.f41334W = true;
        }

        @Override // stepos.support.v7.widget.p.b
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            boolean zIsEnabled;
            View view;
            if (StepOSRecyclerView.this.getAdapter() == null || !(StepOSRecyclerView.this.getAdapter() instanceof u) || (view = this.f41404a) == null) {
                zIsEnabled = true;
            } else {
                int childLayoutPosition = StepOSRecyclerView.this.getChildLayoutPosition(view);
                zIsEnabled = childLayoutPosition == -1 ? false : ((u) StepOSRecyclerView.this.getAdapter()).isEnabled(childLayoutPosition);
            }
            if (this.f41404a == null || stepos.support.v7.widget.t.g(RecyclerView.class, StepOSRecyclerView.this) || StepOSRecyclerView.this.f41337b != 0 || !zIsEnabled || (!StepOSRecyclerView.this.f41316F0 && StepOSRecyclerView.this.f41374x0.P())) {
                return false;
            }
            int i10 = this.f41405b ? StepOSRecyclerView.this.f41314E0 : 0;
            Log.d("StepOSRecyclerView", "mPressStateDuration " + StepOSRecyclerView.this.f41314E0 + " time " + i10);
            if (this.f41405b) {
                StepOSRecyclerView.this.setPressed(true);
                this.f41404a.setPressed(true);
                StepOSRecyclerView stepOSRecyclerView = StepOSRecyclerView.this;
                stepOSRecyclerView.P0(stepOSRecyclerView.getChildLayoutPosition(this.f41404a), this.f41404a);
                Drawable drawable = StepOSRecyclerView.this.f41324M;
                if (drawable != null) {
                    drawable.setHotspot(motionEvent.getX(), motionEvent.getY());
                }
            }
            StepOSRecyclerView.u(StepOSRecyclerView.this);
            StepOSRecyclerView.this.postDelayed(new a(), i10);
            StepOSRecyclerView.this.f41337b = -1;
            return false;
        }

        public /* synthetic */ j(StepOSRecyclerView stepOSRecyclerView, a aVar) {
            this();
        }
    }

    public StepOSRecyclerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f41335a = Math.tan(1.0471975824055166d);
        this.f41337b = -1;
        this.f41339c = 0;
        this.f41349h = false;
        this.f41355k = null;
        this.f41322K = true;
        this.f41323L = false;
        this.f41325N = new Rect();
        this.f41326O = -1;
        this.f41327P = 0;
        this.f41328Q = 0;
        this.f41329R = 0;
        this.f41330S = 0;
        this.f41331T = null;
        this.f41333V = false;
        this.f41334W = false;
        this.f41336a0 = false;
        this.f41344e0 = f41303I0;
        this.f41348g0 = false;
        this.f41350h0 = -1;
        this.f41354j0 = f41304J0;
        this.f41366t0 = false;
        this.f41368u0 = false;
        this.f41370v0 = new ArrayList<>();
        this.f41372w0 = new ArrayList<>();
        this.f41378z0 = true;
        this.f41306A0 = true;
        this.f41308B0 = false;
        this.f41312D0 = false;
        this.f41314E0 = ViewConfiguration.getPressedStateDuration();
        this.f41316F0 = false;
        this.f41318G0 = false;
        D0();
        this.f41353j = new i(context, new j(this, null));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.StepOSRecyclerView, i10, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R$styleable.StepOSRecyclerView_listSelectors);
        if (drawable != null) {
            setSelector(drawable);
        }
        typedArrayObtainStyledAttributes.recycle();
        setOverScrollMode(2);
        OverScroller overScroller = new OverScroller(context, stepos.support.v7.widget.t.c(RecyclerView.class, this));
        this.f41376y0 = overScroller;
        this.f41374x0 = new Lc.c(context, this, overScroller);
        E0();
        this.f41310C0 = stepos.support.v7.widget.l.b();
        if (TextUtils.equals(Build.BRAND, "Sony")) {
            this.f41316F0 = true;
        }
    }

    public void setEnableDragSelection(m mVar) {
        setEnableDragSelection(true);
    }

    public void setSelector(Drawable drawable) {
        Drawable drawable2 = this.f41324M;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f41324M);
        }
        this.f41324M = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        this.f41327P = rect.left;
        this.f41328Q = rect.top;
        this.f41329R = rect.right;
        this.f41330S = rect.bottom;
        drawable.setCallback(this);
        f1();
    }
}
