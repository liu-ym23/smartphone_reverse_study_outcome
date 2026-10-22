package stepos.support.v7.widget;

import android.R;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
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
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.Checkable;
import android.widget.OverScroller;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.stepos.common.animator.StepOSPressAnimationDrawable;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class StepOSRecyclerView extends RecyclerView {

    /* renamed from: t0, reason: collision with root package name */
    public static boolean f12573t0 = false;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public q F;
    public boolean G;
    public final int H;
    public c I;
    public boolean J;
    public boolean K;
    public Drawable L;
    public final Rect M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public d S;
    public boolean T;
    public boolean U;
    public boolean V;
    public float W;

    /* renamed from: a, reason: collision with root package name */
    public int f12574a;

    /* renamed from: a0, reason: collision with root package name */
    public float f12575a0;

    /* renamed from: b, reason: collision with root package name */
    public int f12576b;
    public p b0;

    /* renamed from: c, reason: collision with root package name */
    public ActionMode f12577c;
    public float c0;

    /* renamed from: d, reason: collision with root package name */
    public MultiChoiceModeWrapper f12578d;

    /* renamed from: d0, reason: collision with root package name */
    public HashSet<RecyclerView.ViewHolder> f12579d0;

    /* renamed from: e, reason: collision with root package name */
    public int f12580e;

    /* renamed from: e0, reason: collision with root package name */
    public int f12581e0;

    /* renamed from: f0, reason: collision with root package name */
    public int[][] f12582f0;

    /* renamed from: g0, reason: collision with root package name */
    public int f12583g0;
    public SparseBooleanArray h;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f12584h0;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f12585i0;

    /* renamed from: j, reason: collision with root package name */
    public boolean f12586j;

    /* renamed from: j0, reason: collision with root package name */
    public final ArrayList<b> f12587j0;

    /* renamed from: k, reason: collision with root package name */
    public p.e<Integer> f12588k;

    /* renamed from: k0, reason: collision with root package name */
    public final ArrayList<b> f12589k0;

    /* renamed from: l, reason: collision with root package name */
    public final g f12590l;

    /* renamed from: l0, reason: collision with root package name */
    public final ie.d f12591l0;

    /* renamed from: m, reason: collision with root package name */
    public v f12592m;

    /* renamed from: m0, reason: collision with root package name */
    public boolean f12593m0;

    /* renamed from: n, reason: collision with root package name */
    public Rect f12594n;

    /* renamed from: n0, reason: collision with root package name */
    public boolean f12595n0;

    /* renamed from: o, reason: collision with root package name */
    public final int f12596o;

    /* renamed from: o0, reason: collision with root package name */
    public boolean f12597o0;

    /* renamed from: p, reason: collision with root package name */
    public int f12598p;

    /* renamed from: p0, reason: collision with root package name */
    public final stepos.support.v7.widget.l f12599p0;

    /* renamed from: q, reason: collision with root package name */
    public boolean f12600q;
    public boolean q0;
    public boolean r;

    /* renamed from: r0, reason: collision with root package name */
    public int f12601r0;

    /* renamed from: s, reason: collision with root package name */
    public boolean f12602s;

    /* renamed from: s0, reason: collision with root package name */
    public final boolean f12603s0;

    /* renamed from: t, reason: collision with root package name */
    public int f12604t;

    /* renamed from: u, reason: collision with root package name */
    public int f12605u;

    /* renamed from: v, reason: collision with root package name */
    public int f12606v;

    /* renamed from: w, reason: collision with root package name */
    public int f12607w;

    /* renamed from: x, reason: collision with root package name */
    public int f12608x;

    /* renamed from: y, reason: collision with root package name */
    public int f12609y;
    public boolean z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class MultiChoiceModeWrapper implements j {

        /* renamed from: a, reason: collision with root package name */
        public j f12610a;

        public MultiChoiceModeWrapper() {
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f12610a.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            if (!this.f12610a.onCreateActionMode(actionMode, menu)) {
                return false;
            }
            StepOSRecyclerView stepOSRecyclerView = StepOSRecyclerView.this;
            int i10 = stepOSRecyclerView.f12576b;
            if (i10 == 4 || i10 == 5) {
                stepOSRecyclerView.setLongClickable(true);
            } else {
                stepOSRecyclerView.setLongClickable(false);
            }
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode actionMode) throws NoSuchFieldException, SecurityException {
            StepOSRecyclerView stepOSRecyclerView = StepOSRecyclerView.this;
            if (stepOSRecyclerView.f12595n0) {
                stepOSRecyclerView.f12591l0.f9605j = true;
            }
            this.f12610a.onDestroyActionMode(actionMode);
            stepOSRecyclerView.f12577c = null;
            stepOSRecyclerView.f12597o0 = true;
            stepOSRecyclerView.g();
            stepOSRecyclerView.w();
            stepOSRecyclerView.setLongClickable(true);
            try {
                Field declaredField = RecyclerView.class.getDeclaredField("mRecycler");
                declaredField.setAccessible(true);
                ((RecyclerView.Recycler) declaredField.get(stepOSRecyclerView)).clear();
            } catch (Exception e10) {
                Log.e("StepOSRecyclerViewHelper", "invokeRvRecyclerVClear ex" + e10.toString());
            }
            stepOSRecyclerView.getRecycledViewPool().clear();
        }

        public final void onItemCheckedStateChanged(ActionMode actionMode, int i10, long j10, boolean z) {
            ((MultiChoiceModeWrapper) this.f12610a).onItemCheckedStateChanged(actionMode, i10, j10, z);
            StepOSRecyclerView stepOSRecyclerView = StepOSRecyclerView.this;
            if (stepOSRecyclerView.getCheckedItemCount() == 0) {
                int i11 = stepOSRecyclerView.f12576b;
            }
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.f12610a.onPrepareActionMode(actionMode, menu);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class StepOSSavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<StepOSSavedState> CREATOR = new a();
        p.e<Integer> checkIdState;
        SparseBooleanArray checkState;
        int checkedItemCount;
        boolean inActionMode;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements Parcelable.Creator<StepOSSavedState> {
            @Override // android.os.Parcelable.Creator
            public final StepOSSavedState createFromParcel(Parcel parcel) {
                return new StepOSSavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public final StepOSSavedState[] newArray(int i10) {
                return new StepOSSavedState[i10];
            }
        }

        public /* synthetic */ StepOSSavedState(Parcel parcel, u uVar) {
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
            p.e<Integer> eVar = this.checkIdState;
            int iG = eVar != null ? eVar.g() : 0;
            parcel.writeInt(iG);
            for (int i11 = 0; i11 < iG; i11++) {
                parcel.writeLong(this.checkIdState.e(i11));
                parcel.writeInt(this.checkIdState.h(i11).intValue());
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
                this.checkIdState = new p.e<>();
                for (int i11 = 0; i11 < i10; i11++) {
                    this.checkIdState.f(parcel.readLong(), Integer.valueOf(parcel.readInt()));
                }
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class a<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements s {
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

        @Override // stepos.support.v7.widget.StepOSRecyclerView.s
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
            ((StepOSRecyclerView) this.rv).t(i10 + this.mHeadCount, vh.itemView);
            boolean z = StepOSRecyclerView.f12573t0;
        }

        public void setHeadCount(int i10) {
            this.mHeadCount = i10;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final OverScroller f12612a;

        /* renamed from: b, reason: collision with root package name */
        public int f12613b = 0;

        public c() {
            this.f12612a = new OverScroller(StepOSRecyclerView.this.getContext());
        }

        @Override // java.lang.Runnable
        public final void run() {
            OverScroller overScroller = this.f12612a;
            boolean zIsFinished = overScroller.isFinished();
            StepOSRecyclerView stepOSRecyclerView = StepOSRecyclerView.this;
            if (zIsFinished) {
                stepOSRecyclerView.f12574a = -1;
                stepOSRecyclerView.removeCallbacks(this);
                z.c(stepOSRecyclerView);
                overScroller.abortAnimation();
                return;
            }
            overScroller.computeScrollOffset();
            int currY = overScroller.getCurrY();
            int currY2 = overScroller.getCurrY() - this.f12613b;
            this.f12613b = currY;
            if (currY2 != 0) {
                StepOSRecyclerView.e(stepOSRecyclerView, -currY2, true);
            }
            stepOSRecyclerView.invalidate();
            stepOSRecyclerView.postOnAnimation(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        public View f12615a;

        /* renamed from: b, reason: collision with root package name */
        public int f12616b;

        /* renamed from: c, reason: collision with root package name */
        public long f12617c;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class e extends RecyclerView.ItemDecoration {

        /* renamed from: a, reason: collision with root package name */
        public final HashSet<Integer> f12618a = new HashSet<>();

        /* renamed from: b, reason: collision with root package name */
        public final HashSet<Integer> f12619b = new HashSet<>();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface f {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class g extends stepos.support.v7.widget.r {

        /* renamed from: q, reason: collision with root package name */
        public final h f12620q;
        public int r;

        /* renamed from: s, reason: collision with root package name */
        public int f12621s;

        /* renamed from: t, reason: collision with root package name */
        public final int f12622t;

        /* renamed from: u, reason: collision with root package name */
        public int f12623u;

        /* renamed from: v, reason: collision with root package name */
        public VelocityTracker f12624v;

        public g(Context context, h hVar) {
            super(context, hVar);
            this.f12623u = -1;
            this.f12620q = hVar;
            this.f12622t = ViewConfiguration.get(context).getScaledTouchSlop();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class h {

        /* renamed from: a, reason: collision with root package name */
        public View f12626a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f12627b = false;

        public h() {
        }

        public final boolean a(int i10, int i11, Rect rect, MotionEvent motionEvent) {
            int i12;
            boolean z = i10 >= rect.left && i10 <= rect.right;
            StepOSRecyclerView stepOSRecyclerView = StepOSRecyclerView.this;
            if (stepOSRecyclerView.f12585i0) {
                stepOSRecyclerView.getClass();
            }
            if (stepOSRecyclerView.f12585i0) {
                int rawY = (int) motionEvent.getRawY();
                int rawX = (int) motionEvent.getRawX();
                View viewK = stepOSRecyclerView.k(i10, i11);
                View viewFindViewById = viewK == null ? null : viewK.findViewById(R.id.checkbox);
                if (viewFindViewById != null && (viewFindViewById instanceof Checkable)) {
                    int[] iArr = new int[2];
                    viewFindViewById.getLocationOnScreen(iArr);
                    int i13 = iArr[0];
                    return rawX >= i13 && rawX <= viewFindViewById.getWidth() + i13 && rawY >= (i12 = iArr[1]) && rawY <= viewFindViewById.getHeight() + i12;
                }
            }
            return z;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final boolean b(RecyclerView recyclerView, View view, int i10, long j10) {
            int i11;
            long j11;
            boolean z;
            StepOSRecyclerView stepOSRecyclerView = StepOSRecyclerView.this;
            if (stepOSRecyclerView.u(i10)) {
                return true;
            }
            boolean z3 = false;
            if (stepOSRecyclerView.f12576b != 0) {
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                boolean zIsSelectable = adapter instanceof s ? ((s) adapter).isSelectable(i10) : true;
                int i12 = stepOSRecyclerView.f12576b;
                if ((i12 == 4 || i12 == 5) && stepOSRecyclerView.f12577c != null && zIsSelectable) {
                    boolean z10 = stepOSRecyclerView.h.get(i10, false);
                    boolean z11 = !z10;
                    stepOSRecyclerView.h.put(i10, z11);
                    if (stepOSRecyclerView.f12588k != null && adapter.hasStableIds()) {
                        if (z10) {
                            stepOSRecyclerView.f12588k.c(adapter.getItemId(i10));
                        } else {
                            stepOSRecyclerView.f12588k.f(adapter.getItemId(i10), Integer.valueOf(i10));
                        }
                    }
                    if (z10) {
                        stepOSRecyclerView.f12580e--;
                    } else {
                        stepOSRecyclerView.f12580e++;
                    }
                    ActionMode actionMode = stepOSRecyclerView.f12577c;
                    if (actionMode != null) {
                        i11 = i10;
                        j11 = j10;
                        stepOSRecyclerView.f12578d.onItemCheckedStateChanged(actionMode, i11, j11, z11);
                    } else {
                        i11 = i10;
                        j11 = j10;
                        z3 = true;
                    }
                    z = z3;
                    z3 = true;
                } else {
                    i11 = i10;
                    j11 = j10;
                    z = true;
                }
                if (z3) {
                    stepOSRecyclerView.w();
                }
                z3 = true;
            } else {
                i11 = i10;
                j11 = j10;
                z = true;
            }
            if (z && stepOSRecyclerView.T) {
                if (!stepOSRecyclerView.U) {
                    view.setHovered(true);
                }
                d dVar = stepOSRecyclerView.S;
                if (dVar == null) {
                    d dVar2 = new d();
                    dVar2.f12615a = view;
                    dVar2.f12616b = i11;
                    dVar2.f12617c = j11;
                    stepOSRecyclerView.S = dVar2;
                    return z3;
                }
                dVar.f12615a = view;
                dVar.f12616b = i11;
                dVar.f12617c = j11;
            }
            return z3;
        }

        public final void c() {
            StepOSRecyclerView stepOSRecyclerView = StepOSRecyclerView.this;
            stepOSRecyclerView.setPressed(false);
            View view = this.f12626a;
            if (view != null) {
                view.setPressed(false);
            }
            Drawable drawable = stepOSRecyclerView.L;
            if (drawable != null) {
                drawable.jumpToCurrentState();
            }
            stepOSRecyclerView.M.setEmpty();
            stepOSRecyclerView.f12574a = 3;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface i {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface j extends ActionMode.Callback {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface k {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface l {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface m {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface n {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class o {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class p {

        /* renamed from: a, reason: collision with root package name */
        public final HashMap<View, o> f12629a = new HashMap<>();

        /* renamed from: b, reason: collision with root package name */
        public TimeInterpolator f12630b;

        /* renamed from: c, reason: collision with root package name */
        public int f12631c;

        /* renamed from: d, reason: collision with root package name */
        public ValueAnimator f12632d;

        /* renamed from: e, reason: collision with root package name */
        public int f12633e;

        /* renamed from: f, reason: collision with root package name */
        public int f12634f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f12635g;

        public p(StepOSRecyclerView stepOSRecyclerView) {
            new ArrayList();
            this.f12630b = new LinearInterpolator();
            this.f12631c = 500;
            this.f12633e = 3;
            this.f12635g = true;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class q implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public boolean f12636a = true;

        /* renamed from: b, reason: collision with root package name */
        public boolean f12637b = false;

        public q() {
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0051 A[PHI: r4
          0x0051: PHI (r4v3 boolean) = (r4v1 boolean), (r4v1 boolean), (r4v4 boolean), (r4v4 boolean) binds: [B:20:0x003f, B:22:0x004e, B:10:0x001f, B:12:0x0025] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void run() {
            /*
                r6 = this;
                boolean r0 = r6.f12636a
                r1 = -1
                r2 = 1
                stepos.support.v7.widget.StepOSRecyclerView r3 = stepos.support.v7.widget.StepOSRecyclerView.this
                r4 = 0
                if (r0 == 0) goto L28
                r0 = -8
                boolean r5 = stepos.support.v7.widget.z.b(r0, r3)
                stepos.support.v7.widget.StepOSRecyclerView.e(r3, r0, r4)
                int r0 = r3.j(r2)
                if (r0 != r1) goto L18
                r4 = r2
            L18:
                int r1 = r3.B
                if (r1 == r0) goto L1f
                r3.v(r1, r0)
            L1f:
                if (r5 != 0) goto L51
                int r0 = r3.getFirstPosition()
                if (r0 != 0) goto L51
                goto L52
            L28:
                r0 = 8
                boolean r5 = stepos.support.v7.widget.z.b(r0, r3)
                stepos.support.v7.widget.StepOSRecyclerView.e(r3, r0, r4)
                int r0 = r3.j(r4)
                if (r0 != r1) goto L38
                r4 = r2
            L38:
                int r1 = r3.C
                if (r1 == r0) goto L3f
                r3.h(r1, r0)
            L3f:
                if (r5 != 0) goto L51
                int r0 = r3.getFirstPosition()
                int r1 = stepos.support.v7.widget.StepOSRecyclerView.f(r3)
                int r1 = r1 + r0
                int r0 = stepos.support.v7.widget.StepOSRecyclerView.d(r3)
                if (r1 != r0) goto L51
                goto L52
            L51:
                r2 = r4
            L52:
                if (r2 != 0) goto L57
                r3.postOnAnimation(r6)
            L57:
                r3.getContext()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.StepOSRecyclerView.q.run():void");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface r {
        void a();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface s {
        boolean isEnabled(int i10);

        boolean isSelectable(int i10);
    }

    public StepOSRecyclerView(Context context, AttributeSet attributeSet) throws NoSuchFieldException, Resources.NotFoundException, SecurityException {
        super(context, attributeSet, 0);
        Math.tan(1.0471975824055166d);
        this.f12574a = -1;
        this.f12576b = 0;
        this.f12586j = false;
        Interpolator interpolator = null;
        this.f12592m = null;
        this.J = true;
        this.K = false;
        this.M = new Rect();
        this.N = -1;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.T = false;
        this.U = false;
        this.V = false;
        this.c0 = Float.MAX_VALUE;
        this.f12581e0 = -1;
        this.f12583g0 = -1;
        this.f12585i0 = false;
        this.f12587j0 = new ArrayList<>();
        this.f12589k0 = new ArrayList<>();
        this.f12593m0 = true;
        this.f12595n0 = true;
        this.f12597o0 = false;
        this.q0 = false;
        this.f12601r0 = ViewConfiguration.getPressedStateDuration();
        this.f12603s0 = false;
        Resources resources = getResources();
        this.f12600q = false;
        this.f12596o = resources.getDimensionPixelSize(com.stepos.aiengine.R.dimen.stepos_list_check_width);
        this.H = resources.getDimensionPixelSize(com.stepos.aiengine.R.dimen.stepos_list_item_height);
        this.f12602s = false;
        this.f12604t = 0;
        this.f12605u = 0;
        this.f12606v = 0;
        this.f12607w = 0;
        this.f12608x = -1;
        this.f12609y = -1;
        this.A = 0;
        this.F = null;
        this.G = false;
        this.D = -1;
        this.B = -1;
        this.C = -1;
        getResources().getDimensionPixelSize(com.stepos.aiengine.R.dimen.stepos_recyclerview_scrollbar_padding);
        this.f12590l = new g(context, new h());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ae.a.f179a, 0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        if (drawable != null) {
            setSelector(drawable);
        }
        typedArrayObtainStyledAttributes.recycle();
        setOverScrollMode(2);
        try {
            Field declaredField = RecyclerView.class.getDeclaredField("sQuinticInterpolator");
            declaredField.setAccessible(true);
            interpolator = (Interpolator) declaredField.get(this);
        } catch (Exception e10) {
            Log.e("StepOSRecyclerViewHelper", "getsQuinticInterpolator ex" + e10.toString());
        }
        ie.d dVar = new ie.d(context, this, new OverScroller(context, interpolator), -1);
        this.f12591l0 = dVar;
        dVar.f9610o = 0.99f;
        dVar.f9611p = 228.0f;
        dVar.f9600d = 0.5f;
        if (stepos.support.v7.widget.l.f12813b == null) {
            synchronized (stepos.support.v7.widget.l.class) {
                try {
                    if (stepos.support.v7.widget.l.f12813b == null) {
                        stepos.support.v7.widget.l.f12813b = new stepos.support.v7.widget.l();
                    }
                } finally {
                }
            }
        }
        stepos.support.v7.widget.l lVar = stepos.support.v7.widget.l.f12813b;
        lVar.getClass();
        if (Thread.State.NEW == lVar.getState()) {
            lVar.start();
        }
        this.f12599p0 = stepos.support.v7.widget.l.f12813b;
        if (TextUtils.equals(Build.BRAND, "Sony")) {
            this.f12603s0 = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x0132  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(stepos.support.v7.widget.StepOSRecyclerView r13, android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 443
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.StepOSRecyclerView.a(stepos.support.v7.widget.StepOSRecyclerView, android.view.MotionEvent):boolean");
    }

    public static void b(StepOSRecyclerView stepOSRecyclerView) {
        stepOSRecyclerView.f12609y = -1;
        stepOSRecyclerView.A = -1;
        stepOSRecyclerView.f12602s = false;
        stepOSRecyclerView.z = false;
        stepOSRecyclerView.E = -1;
        stepOSRecyclerView.C = -1;
        stepOSRecyclerView.B = -1;
        stepOSRecyclerView.f12608x = -1;
        stepOSRecyclerView.G = false;
        q qVar = stepOSRecyclerView.F;
        if (qVar != null) {
            qVar.f12637b = false;
            StepOSRecyclerView.this.removeCallbacks(qVar);
        }
    }

    public static void e(StepOSRecyclerView stepOSRecyclerView, int i10, boolean z) {
        if (stepOSRecyclerView.getChildCountExt() == 0) {
            return;
        }
        if (z) {
            stepOSRecyclerView.offsetChildrenVertical(i10);
        }
        if (stepOSRecyclerView.awakenScrollBars()) {
            return;
        }
        stepOSRecyclerView.invalidate();
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

    public static boolean l(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (viewGroup instanceof RecyclerView) {
            return true;
        }
        ViewParent parent = viewGroup.getParent();
        if (parent instanceof ViewGroup) {
            return l((ViewGroup) parent);
        }
        return false;
    }

    public static void setAvoidNotifyItemRangeChanged(boolean z) {
        f12573t0 = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        if (!(itemDecoration instanceof e)) {
            Log.i("StepOSRecyclerView", "you should use StepOSRecyclerView.ItemDecoration!! Otherwise, it may cause problems");
        }
        super.addItemDecoration(itemDecoration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        if (!this.K) {
            Rect rect = this.M;
            if (!rect.isEmpty()) {
                Drawable drawable = this.L;
                drawable.setBounds(rect);
                drawable.draw(canvas);
            }
        }
        super.dispatchDraw(canvas);
        int itemDecorationCount = getItemDecorationCount();
        for (int i10 = 0; i10 < itemDecorationCount; i10++) {
            if (getItemDecorationAt(i10) instanceof e) {
                ((e) getItemDecorationAt(i10)).f12619b.clear();
            }
        }
        for (int i11 = 0; i11 < itemDecorationCount; i11++) {
            if (getItemDecorationAt(i11) instanceof e) {
                HashSet<Integer> hashSet = ((e) getItemDecorationAt(i11)).f12618a;
                for (int i12 = 0; i12 < itemDecorationCount; i12++) {
                    if (i11 != i12 && (getItemDecorationAt(i12) instanceof e)) {
                        ((e) getItemDecorationAt(i12)).f12619b.addAll(hashSet);
                    }
                }
            }
        }
        int itemDecorationCount2 = getItemDecorationCount();
        for (int i13 = 0; i13 < itemDecorationCount2; i13++) {
            if (getItemDecorationAt(i13) instanceof e) {
                e eVar = (e) getItemDecorationAt(i13);
                z.a(this);
                eVar.getClass();
            }
        }
        int itemDecorationCount3 = getItemDecorationCount();
        for (int i14 = 0; i14 < itemDecorationCount3; i14++) {
            if (getItemDecorationAt(i14) instanceof e) {
                e eVar2 = (e) getItemDecorationAt(i14);
                z.a(this);
                eVar2.getClass();
            }
        }
    }

    public boolean dispatchStatusBarTap() {
        int firstPosition;
        View childAt;
        if (getItemCount() == 0 || this.f12591l0.j() || (((firstPosition = getFirstPosition()) == 0 && (childAt = getChildAt(0)) != null && childAt.getTop() >= getPaddingTop()) || getItemCount() == Integer.MAX_VALUE)) {
            return false;
        }
        c cVar = this.I;
        if (cVar != null) {
            StepOSRecyclerView stepOSRecyclerView = StepOSRecyclerView.this;
            stepOSRecyclerView.f12574a = -1;
            stepOSRecyclerView.removeCallbacks(cVar);
            z.c(stepOSRecyclerView);
            cVar.f12612a.abortAnimation();
            this.I = null;
        }
        if (firstPosition > getChildCount() * 2) {
            scrollToPosition(getChildCount() * 2);
        }
        smoothScrollToPosition(0);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x016b  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchTouchEvent(android.view.MotionEvent r9) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.StepOSRecyclerView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        x();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final boolean fling(int i10, int i11) {
        this.f12591l0.f(i10, i11);
        return super.fling(i10, i11);
    }

    public final void g() {
        SparseBooleanArray sparseBooleanArray = this.h;
        if (sparseBooleanArray != null) {
            sparseBooleanArray.clear();
        }
        p.e<Integer> eVar = this.f12588k;
        if (eVar != null) {
            eVar.b();
        }
        this.f12580e = 0;
    }

    public int getCheckedItemCount() {
        return this.f12580e;
    }

    public long[] getCheckedItemIds() {
        if (this.f12576b == 0 || this.f12588k == null || getAdapter() == null) {
            return new long[0];
        }
        p.e<Integer> eVar = this.f12588k;
        int iG = eVar.g();
        long[] jArr = new long[iG];
        for (int i10 = 0; i10 < iG; i10++) {
            jArr[i10] = eVar.e(i10);
        }
        return jArr;
    }

    public SparseBooleanArray getCheckedItemPositions() {
        if (this.f12576b != 0) {
            return this.h;
        }
        return null;
    }

    public int getChoiceMode() {
        return this.f12576b;
    }

    public int getCount() {
        return getAdapter().getItemCount();
    }

    public int getFirstPosition() {
        View viewM = m(0);
        if (viewM == null) {
            return -1;
        }
        return getChildLayoutPosition(viewM);
    }

    public int getFooterViewsCount() {
        if (getAdapter() == null || !(getAdapter() instanceof stepos.support.v7.widget.n)) {
            return 0;
        }
        return ((stepos.support.v7.widget.n) getAdapter()).f12821b.f11388c;
    }

    public int getHeaderViewsCount() {
        if (getAdapter() == null || !(getAdapter() instanceof stepos.support.v7.widget.n)) {
            return 0;
        }
        return ((stepos.support.v7.widget.n) getAdapter()).f12820a.f11388c;
    }

    public int getLastPosition() {
        View viewM = m(getChildCountExt() - 1);
        if (viewM == null) {
            return -1;
        }
        return getChildLayoutPosition(viewM);
    }

    public final l getOnItemClickListener() {
        return null;
    }

    public final m getOnItemLongClickListener() {
        return null;
    }

    public ie.d getSpringAnimationHelper() {
        return this.f12591l0;
    }

    public HashSet getViewHoldSet() {
        return this.f12579d0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x00bf, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r6v4, types: [int[][]] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r7v0, types: [int] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(int r10, int r11) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.StepOSRecyclerView.h(int, int):void");
    }

    public final void i(boolean z) {
        if (this.f12594n == null) {
            Rect rect = new Rect();
            this.f12594n = rect;
            rect.setEmpty();
        }
        int i10 = this.f12576b;
        if (i10 != 4 && i10 != 5) {
            this.f12594n.setEmpty();
            return;
        }
        if (this.f12594n.isEmpty() || z) {
            if (getLayoutDirection() == 1) {
                this.f12594n.left = getPaddingLeft();
                Rect rect2 = this.f12594n;
                rect2.right = rect2.left + this.f12598p;
                rect2.top = getPaddingTop();
                this.f12594n.bottom = getHeight() - getPaddingBottom();
                return;
            }
            this.f12594n.right = getWidth() - getPaddingRight();
            Rect rect3 = this.f12594n;
            rect3.left = rect3.right - this.f12598p;
            rect3.top = getPaddingTop();
            this.f12594n.bottom = getHeight() - getPaddingBottom();
        }
    }

    public final void invalidateParentIfNeeded() {
        if (isHardwareAccelerated() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    public final int j(boolean z) {
        int childCountExt = getChildCountExt();
        int firstPosition = getFirstPosition();
        if (z) {
            for (int i10 = 0; i10 < childCountExt; i10++) {
                View viewM = m(i10);
                int iO = o(viewM);
                RecyclerView.LayoutManager layoutManager = getLayoutManager();
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewM.getLayoutParams();
                if (iO - (((layoutManager.getDecoratedMeasuredHeight(viewM) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) / 2) > getPaddingTop()) {
                    return firstPosition + i10;
                }
            }
            return -1;
        }
        for (int i11 = childCountExt - 1; i11 >= 0; i11--) {
            View viewM2 = m(i11);
            int iP = p(viewM2);
            RecyclerView.LayoutManager layoutManager2 = getLayoutManager();
            RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) viewM2.getLayoutParams();
            if ((((layoutManager2.getDecoratedMeasuredHeight(viewM2) + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin) / 2) + iP < getHeight() - getPaddingBottom()) {
                return firstPosition + i11;
            }
        }
        return -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.L;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public final View k(int i10, int i11) {
        for (int childCount = getLayoutManager().getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getLayoutManager().getChildAt(childCount);
            float translationY = childAt.getTranslationY();
            if (this.f12585i0) {
                float translationX = childAt.getTranslationX();
                float f8 = i10;
                if (f8 >= (getLayoutManager().getDecoratedLeft(childAt) - ((RecyclerView.LayoutParams) childAt.getLayoutParams()).getMarginStart()) + translationX) {
                    RecyclerView.LayoutManager layoutManager = getLayoutManager();
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                    if (f8 <= layoutParams.getMarginEnd() + layoutManager.getDecoratedRight(childAt) + translationX) {
                        float f9 = i11;
                        if (f9 >= p(childAt) + translationY && f9 <= o(childAt) + translationY) {
                            return childAt;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            } else {
                float f10 = i11;
                if (f10 >= p(childAt) + translationY && f10 <= o(childAt) + translationY) {
                    return childAt;
                }
            }
        }
        return null;
    }

    public final View m(int i10) {
        return getLayoutManager().getChildAt(i10);
    }

    public final int n(View view) {
        if (view == null) {
            return -1;
        }
        return getChildLayoutPosition(view);
    }

    public final int o(View view) {
        return getLayoutManager().getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0031  */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            android.view.ViewParent r0 = r4.getParent()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            boolean r0 = l(r0)
            if (r0 == 0) goto L11
            boolean r4 = super.onInterceptTouchEvent(r5)
            return r4
        L11:
            r0 = 1
            ie.d r1 = r4.f12591l0
            if (r5 == 0) goto L3f
            boolean r2 = r1.f9605j
            if (r2 != 0) goto L1b
            goto L42
        L1b:
            int r2 = r5.getActionMasked()
            r5.getActionIndex()
            if (r2 == 0) goto L31
            if (r2 == r0) goto L2d
            r3 = 2
            if (r2 == r3) goto L31
            r3 = 3
            if (r2 == r3) goto L2d
            goto L42
        L2d:
            r1.l()
            goto L42
        L31:
            r2 = 0
            int r3 = r5.getPointerId(r2)
            r1.f9602f = r3
            r1.k()
            r1.o(r5, r2)
            goto L42
        L3f:
            r1.getClass()
        L42:
            float r1 = r4.getTranslationX()
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L53
            float r1 = r4.getTranslationY()
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 == 0) goto L60
        L53:
            android.view.ViewParent r1 = r4.getParent()
            if (r1 == 0) goto L60
            boolean r2 = r4.q0
            if (r2 == 0) goto L60
            r1.requestDisallowInterceptTouchEvent(r0)
        L60:
            boolean r4 = super.onInterceptTouchEvent(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.StepOSRecyclerView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i10, int i11, int i12, int i13) throws NoSuchFieldException, SecurityException {
        int iIntValue;
        View view;
        d dVar;
        int i14;
        ActionMode actionMode;
        MultiChoiceModeWrapper multiChoiceModeWrapper;
        int i15;
        super.onLayout(z, i10, i11, i12, i13);
        if (this.f12576b == 5 && !this.f12597o0 && this.f12592m == null) {
            v vVar = new v(this, 0);
            this.f12592m = vVar;
            post(vVar);
        }
        RecyclerView.State stateA = z.a(this);
        try {
            Field declaredField = RecyclerView.State.class.getDeclaredField("mLayoutStep");
            declaredField.setAccessible(true);
            iIntValue = ((Integer) declaredField.get(stateA)).intValue();
        } catch (Exception e10) {
            Log.e("StepOSRecyclerViewHelper", "getRvStateStepField ex" + e10.toString());
            iIntValue = 0;
        }
        if (iIntValue == 1 && stateA.didStructureChange()) {
            RecyclerView.Adapter adapter = getAdapter();
            if (this.f12576b == 0 || adapter == null || !adapter.hasStableIds()) {
                view = null;
            } else {
                int itemCount = getItemCount();
                this.h.clear();
                int i16 = 0;
                boolean z3 = false;
                while (i16 < this.f12588k.g()) {
                    long jE = this.f12588k.e(i16);
                    int iIntValue2 = this.f12588k.h(i16).intValue();
                    if (jE != adapter.getItemId(iIntValue2)) {
                        int iMax = Math.max(0, iIntValue2 - 20);
                        int iMin = Math.min(iIntValue2 + 20, itemCount);
                        while (true) {
                            if (iMax >= iMin) {
                                this.f12588k.c(jE);
                                i16--;
                                this.f12580e--;
                                ActionMode actionMode2 = this.f12577c;
                                if (actionMode2 != null && (multiChoiceModeWrapper = this.f12578d) != null) {
                                    multiChoiceModeWrapper.onItemCheckedStateChanged(actionMode2, iIntValue2, jE, false);
                                }
                                z3 = true;
                            } else if (jE == adapter.getItemId(iMax)) {
                                this.h.put(iMax, true);
                                p.e<Integer> eVar = this.f12588k;
                                Integer numValueOf = Integer.valueOf(iMax);
                                if (i16 < 0 || i16 >= (i15 = eVar.f11363d)) {
                                    eVar.getClass();
                                    q.a.c("Expected index to be within 0..size()-1, but was " + i16);
                                    throw null;
                                }
                                if (eVar.f11360a) {
                                    long[] jArr = eVar.f11361b;
                                    Object[] objArr = eVar.f11362c;
                                    int i17 = 0;
                                    for (int i18 = 0; i18 < i15; i18++) {
                                        Object obj = objArr[i18];
                                        if (obj != p.f.f11364a) {
                                            if (i18 != i17) {
                                                jArr[i17] = jArr[i18];
                                                objArr[i17] = obj;
                                                objArr[i18] = null;
                                            }
                                            i17++;
                                        }
                                    }
                                    eVar.f11360a = false;
                                    eVar.f11363d = i17;
                                }
                                eVar.f11362c[i16] = numValueOf;
                            } else {
                                iMax++;
                            }
                        }
                    } else {
                        this.h.put(iIntValue2, true);
                    }
                    i16++;
                }
                view = null;
                if (z3 && (actionMode = this.f12577c) != null) {
                    actionMode.invalidate();
                }
            }
            RecyclerView.Adapter adapter2 = getAdapter();
            if (adapter2.hasStableIds() && (dVar = this.S) != null && (i14 = dVar.f12616b) != -1) {
                long j10 = dVar.f12617c;
                if (j10 != adapter2.getItemId(i14)) {
                    View view2 = this.S.f12615a;
                    if (view2 != null) {
                        view2.setHovered(false);
                        Drawable background = this.S.f12615a.getBackground();
                        if (background != null) {
                            background.jumpToCurrentState();
                        }
                    }
                    d dVar2 = this.S;
                    dVar2.f12615a = view;
                    dVar2.f12616b = -1;
                    int iMax2 = Math.max(0, i14 - 20);
                    int iMin2 = Math.min(i14 + 20, adapter2.getItemCount());
                    while (true) {
                        if (iMax2 >= iMin2) {
                            break;
                        }
                        if (j10 == adapter2.getItemId(iMax2)) {
                            RecyclerView.ViewHolder viewHolderFindViewHolderForItemId = findViewHolderForItemId(j10);
                            if (viewHolderFindViewHolderForItemId != null) {
                                d dVar3 = this.S;
                                dVar3.f12616b = iMax2;
                                dVar3.f12615a = viewHolderFindViewHolderForItemId.itemView;
                            }
                        } else {
                            iMax2++;
                        }
                    }
                }
            }
            setPressed(false);
            Drawable drawable = this.L;
            if (drawable != null) {
                drawable.jumpToCurrentState();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onMeasure(int i10, int i11) throws IllegalAccessException, Resources.NotFoundException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Drawable drawable;
        if (this.L == null) {
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
                    PathInterpolator pathInterpolator = StepOSPressAnimationDrawable.F;
                    Object objNewInstance = StepOSPressAnimationDrawable.class.getConstructor(null).newInstance(null);
                    if (objNewInstance instanceof Drawable) {
                        if ((getResources().getConfiguration().uiMode & 48) == 32) {
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
                drawable = getResources().getDrawable(com.stepos.aiengine.R.drawable.stepos_recyclerview_selector);
            }
            setSelector(drawable);
        }
        super.onMeasure(i10, i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void onScrolled(int i10, int i11) {
        if (this.V) {
            boolean z = this.b0.f12635g;
        }
        super.onScrolled(i10, i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        i(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:193:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0517  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0523 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0538  */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r26) {
        /*
            Method dump skipped, instructions count: 1342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.StepOSRecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        d dVar;
        View view;
        super.onWindowFocusChanged(z);
        if (!z || !this.T || (dVar = this.S) == null || (view = dVar.f12615a) == null) {
            return;
        }
        if (this.U) {
            view.setHovered(true);
            this.U = false;
        }
        this.S.f12615a.setHovered(false);
        d dVar2 = this.S;
        dVar2.f12615a = null;
        dVar2.f12617c = -1L;
        dVar2.f12616b = -1;
    }

    public final int p(View view) {
        return getLayoutManager().getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
    }

    public final boolean q(int i10, int i11) {
        View viewK = k(i10, i11);
        if (viewK == null) {
            return false;
        }
        this.f12608x = getChildLayoutPosition(viewK);
        this.f12606v = p(viewK);
        this.f12607w = o(viewK);
        this.f12604t = getLayoutManager().getDecoratedLeft(viewK) - ((RecyclerView.LayoutParams) viewK.getLayoutParams()).getMarginStart();
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewK.getLayoutParams();
        this.f12605u = layoutParams.getMarginEnd() + layoutManager.getDecoratedRight(viewK);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void r(int i10, View view) {
        boolean z = i10 != this.N;
        if (i10 != -1) {
            this.N = i10;
        }
        int left = view.getLeft();
        int top = view.getTop();
        int right = view.getRight();
        int bottom = view.getBottom();
        Rect rect = this.M;
        rect.set(left, top, right, bottom);
        if (view instanceof r) {
            ((r) view).a();
        }
        rect.left -= this.O;
        rect.top -= this.P;
        rect.right += this.Q;
        rect.bottom += this.R;
        Drawable drawable = this.L;
        if (drawable != null) {
            drawable.setBounds(rect);
            if (z) {
                if (getVisibility() == 0) {
                    drawable.setVisible(true, false);
                }
                x();
            }
        }
        refreshDrawableState();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s(int r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.StepOSRecyclerView.s(int, boolean):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        if (!(adapter instanceof s)) {
            Log.i("StepOSRecyclerView", "you should use StepOSRecyclerView.Adapter！！！ Otherwise, it may cause problems");
        }
        if (adapter != null) {
            ArrayList<b> arrayList = this.f12587j0;
            int size = arrayList.size();
            ArrayList<b> arrayList2 = this.f12589k0;
            if (size > 0 || arrayList2.size() > 0) {
                if (!(adapter instanceof stepos.support.v7.widget.n)) {
                    adapter = new stepos.support.v7.widget.n(adapter);
                }
                stepos.support.v7.widget.n nVar = (stepos.support.v7.widget.n) adapter;
                int size2 = arrayList.size();
                int i10 = 0;
                int i11 = 0;
                while (i11 < size2) {
                    b bVar = arrayList.get(i11);
                    i11++;
                    p.p<b> pVar = nVar.f12820a;
                    int i12 = stepos.support.v7.widget.n.f12818e;
                    stepos.support.v7.widget.n.f12818e = i12 + 1;
                    pVar.d(i12, bVar);
                }
                int size3 = arrayList2.size();
                while (i10 < size3) {
                    b bVar2 = arrayList2.get(i10);
                    i10++;
                    p.p<b> pVar2 = nVar.f12821b;
                    int i13 = stepos.support.v7.widget.n.f12819f;
                    stepos.support.v7.widget.n.f12819f = i13 + 1;
                    pVar2.d(i13, bVar2);
                }
            }
        }
        super.setAdapter(adapter);
        if (adapter != null) {
            boolean zHasStableIds = getAdapter().hasStableIds();
            if (this.f12576b != 0 && zHasStableIds && this.f12588k == null) {
                this.f12588k = new p.e<>();
            }
        }
        g();
    }

    public void setBaseDuration(int i10) {
        p pVar = this.b0;
        if (pVar != null) {
            pVar.f12631c = i10;
        }
    }

    public void setBottomOverScrollEnable(boolean z) {
        this.f12591l0.f9607l = z;
    }

    public void setCheckBoxIsAnimation(boolean z) {
        if (this.J != z) {
            this.J = z;
        }
    }

    public void setChoiceMode(int i10) {
        this.f12576b = i10;
        ActionMode actionMode = this.f12577c;
        if (actionMode != null) {
            actionMode.finish();
            this.f12577c = null;
        }
        if (this.f12576b != 0) {
            if (this.h == null) {
                this.h = new SparseBooleanArray(0);
            }
            RecyclerView.Adapter adapter = getAdapter();
            if (this.f12588k == null && adapter != null && adapter.hasStableIds()) {
                this.f12588k = new p.e<>(0);
            }
            if (this.f12576b == 4) {
                g();
                setLongClickable(true);
            }
        }
    }

    public void setDrawSelectorOnTop(boolean z) {
        this.K = z;
    }

    public void setEnableDragSelection(boolean z) {
        this.r = z;
    }

    public void setEnableHoldPress(boolean z) {
        this.T = z;
    }

    public void setEnableParallax(boolean z) {
        if (z) {
            if (this.b0 == null) {
                this.b0 = new p(this);
            }
            if (this.f12579d0 == null) {
                this.f12579d0 = new HashSet<>();
            }
        }
        this.V = z;
    }

    public void setEndOverScrollEnable(boolean z) {
        this.f12591l0.f9609n = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        ie.d dVar = this.f12591l0;
        if (dVar != null && layoutManager != null) {
            dVar.f9614t = layoutManager.canScrollVertically() ? 1 : 0;
        }
        this.f12585i0 = (layoutManager instanceof GridLayoutManager) || (layoutManager instanceof StaggeredGridLayoutManager);
    }

    public void setMultiChoiceModeListener(j jVar) {
        if (this.f12578d == null) {
            this.f12578d = new MultiChoiceModeWrapper();
        }
        this.f12578d.f12610a = jVar;
    }

    public void setOnItemLongClickListener(m mVar) {
        if (isLongClickable()) {
            return;
        }
        setLongClickable(true);
    }

    public void setOverScrollEnable(boolean z) {
        this.f12595n0 = z;
        this.f12591l0.f9605j = z;
    }

    public void setPressStateDuration(int i10) {
        this.f12601r0 = i10;
    }

    @Deprecated
    public void setRequestLayoutWhenSwitchActionMode(boolean z) {
        this.f12586j = z;
    }

    public void setScrollUpByItemCoveredInMultiChoiceEnable(boolean z) {
        this.f12593m0 = z;
    }

    public void setSelector(int i10) {
        setSelector(getResources().getDrawable(i10));
    }

    public void setShouldRequestDisallowInterceptTouchEventWhenOverScroll(boolean z) {
        this.q0 = z;
    }

    public void setSmoothBackInterpolator(TimeInterpolator timeInterpolator) {
        p pVar;
        if (timeInterpolator == null || (pVar = this.b0) == null) {
            return;
        }
        pVar.f12630b = timeInterpolator;
    }

    public void setStartOverScrollEnable(boolean z) {
        this.f12591l0.f9608m = z;
    }

    public void setTopOverScrollEnable(boolean z) {
        this.f12591l0.f9606k = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void swapAdapter(RecyclerView.Adapter adapter, boolean z) {
        ArrayList<b> arrayList = this.f12587j0;
        int size = arrayList.size();
        ArrayList<b> arrayList2 = this.f12589k0;
        if (size > 0 || arrayList2.size() > 0) {
            if (!(adapter instanceof stepos.support.v7.widget.n)) {
                adapter = new stepos.support.v7.widget.n(adapter);
            }
            stepos.support.v7.widget.n nVar = (stepos.support.v7.widget.n) adapter;
            int size2 = arrayList.size();
            int i10 = 0;
            int i11 = 0;
            while (i11 < size2) {
                b bVar = arrayList.get(i11);
                i11++;
                p.p<b> pVar = nVar.f12820a;
                int i12 = stepos.support.v7.widget.n.f12818e;
                stepos.support.v7.widget.n.f12818e = i12 + 1;
                pVar.d(i12, bVar);
            }
            int size3 = arrayList2.size();
            while (i10 < size3) {
                b bVar2 = arrayList2.get(i10);
                i10++;
                p.p<b> pVar2 = nVar.f12821b;
                int i13 = stepos.support.v7.widget.n.f12819f;
                stepos.support.v7.widget.n.f12819f = i13 + 1;
                pVar2.d(i13, bVar2);
            }
        }
        super.swapAdapter(adapter, z);
        if (adapter != null) {
            boolean zHasStableIds = getAdapter().hasStableIds();
            if (this.f12576b != 0 && zHasStableIds && this.f12588k == null) {
                this.f12588k = new p.e<>();
            }
        }
        g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void t(int i10, View view) {
        SparseBooleanArray sparseBooleanArray;
        KeyEvent.Callback callbackFindViewById;
        if (view == 0 || this.f12576b == 0 || (sparseBooleanArray = this.h) == null) {
            return;
        }
        boolean z = sparseBooleanArray.get(i10);
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(z);
            return;
        }
        if (getContext().getApplicationInfo().targetSdkVersion >= 11) {
            int i11 = this.f12576b;
            if ((i11 == 4 || i11 == 5) && (callbackFindViewById = view.findViewById(R.id.checkbox)) != null && (callbackFindViewById instanceof Checkable)) {
                ((Checkable) callbackFindViewById).setChecked(this.f12577c != null);
            }
            view.setActivated(z);
        }
    }

    public final boolean u(int i10) {
        if (i10 >= 0) {
            return i10 < getHeaderViewsCount() || i10 >= getItemCount() - getFooterViewsCount();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r6v0, types: [int[][]] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r7v0, types: [int] */
    public final void v(int i10, int i11) {
        boolean zIsEnabled;
        boolean zIsSelectable;
        boolean z;
        SparseBooleanArray sparseBooleanArray;
        RecyclerView.Adapter adapter = getAdapter();
        int firstPosition = getFirstPosition();
        for (int i12 = i10 == -1 ? i11 : i10 - 1; i12 >= i11; i12--) {
            boolean z3 = true;
            if (getAdapter() instanceof s) {
                zIsEnabled = ((s) getAdapter()).isEnabled(i12);
                zIsSelectable = ((s) getAdapter()).isSelectable(i12);
            } else {
                zIsEnabled = true;
                zIsSelectable = true;
            }
            if (!zIsSelectable) {
                this.D = -1;
            } else {
                if (i12 == this.D) {
                    return;
                }
                if (getAdapter() == null || zIsEnabled) {
                    m(i12 - firstPosition);
                    adapter.getItemId(i12);
                    ?? r32 = (this.f12576b == 0 || (sparseBooleanArray = this.h) == null) ? 0 : sparseBooleanArray.get(i12);
                    ?? r62 = this.f12582f0[i12];
                    ?? r72 = r62[0];
                    if (r72 == 0) {
                        r62[1] = r32;
                    }
                    int i13 = r72 + 1;
                    r62[0] = i13;
                    int i14 = this.f12581e0;
                    if (i14 == -1) {
                        boolean z10 = this.f12584h0 ? r32 : r32 ^ 1;
                        this.f12581e0 = z10 ? 1 : 0;
                        r62[1] = z10 ? 1 : 0;
                        z = z10;
                    } else if (i13 % 2 == 0) {
                        z3 = false;
                        z = z3;
                    } else {
                        z3 = false;
                        z = z3;
                    }
                    if (z != r32) {
                        s(i12, z);
                        this.f12599p0.a(this);
                    }
                    this.B = i12;
                    this.C = -1;
                    this.D = -1;
                }
            }
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return this.L == drawable || super.verifyDrawable(drawable);
    }

    public final void w() {
        int childCountExt = getChildCountExt();
        for (int i10 = 0; i10 < childCountExt; i10++) {
            View viewM = m(i10);
            t(n(viewM), viewM);
        }
    }

    public final void x() {
        if (this.L != null) {
            if ((!isFocused() || isInTouchMode()) && !isPressed()) {
                this.L.setState(StateSet.NOTHING);
            } else {
                this.L.setState(getDrawableState());
            }
        }
    }

    public void setEnableDragSelection(k kVar) {
        setEnableDragSelection(true);
    }

    public void setSelector(Drawable drawable) {
        Drawable drawable2 = this.L;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.L);
        }
        this.L = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        this.O = rect.left;
        this.P = rect.top;
        this.Q = rect.right;
        this.R = rect.bottom;
        drawable.setCallback(this);
        x();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSetPressed(boolean z) {
    }

    public void setItenFilter(f fVar) {
    }

    public void setMultiChoiceListener(i iVar) {
    }

    public void setOnItemClickListener(l lVar) {
    }

    public void setParallaxAnimationListener(n nVar) {
    }

    public void setPinnedHeaderDecoration(he.a aVar) {
    }

    public void setScrollSensitivity(int i10) {
    }
}
