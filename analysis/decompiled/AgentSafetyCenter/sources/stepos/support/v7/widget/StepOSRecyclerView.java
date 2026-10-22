package stepos.support.v7.widget;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.StateSet;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
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
import com.stepos.agentsafetycenter.R;
import com.stepos.common.animator.StepOSPressAnimationDrawable;
import java.lang.Thread;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class StepOSRecyclerView extends RecyclerView {

    /* renamed from: u0, reason: collision with root package name */
    public static boolean f12637u0 = false;
    public boolean A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public l1 G;
    public boolean H;
    public final int I;
    public androidx.activity.h J;
    public boolean K;
    public boolean L;
    public Drawable M;
    public final Rect N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public y0 T;
    public boolean U;
    public boolean V;
    public boolean W;

    /* renamed from: a0, reason: collision with root package name */
    public float f12638a0;

    /* renamed from: b0, reason: collision with root package name */
    public float f12639b0;

    /* renamed from: c, reason: collision with root package name */
    public int f12640c;

    /* renamed from: c0, reason: collision with root package name */
    public k1 f12641c0;

    /* renamed from: d0, reason: collision with root package name */
    public float f12642d0;
    public HashSet e0;

    /* renamed from: f, reason: collision with root package name */
    public int f12643f;
    public int f0;

    /* renamed from: g, reason: collision with root package name */
    public ActionMode f12644g;

    /* renamed from: g0, reason: collision with root package name */
    public int[][] f12645g0;

    /* renamed from: h, reason: collision with root package name */
    public MultiChoiceModeWrapper f12646h;

    /* renamed from: h0, reason: collision with root package name */
    public int f12647h0;
    public int i;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f12648i0;

    /* renamed from: j, reason: collision with root package name */
    public SparseBooleanArray f12649j;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f12650j0;

    /* renamed from: k, reason: collision with root package name */
    public boolean f12651k;

    /* renamed from: k0, reason: collision with root package name */
    public final ArrayList f12652k0;

    /* renamed from: l, reason: collision with root package name */
    public p.n f12653l;

    /* renamed from: l0, reason: collision with root package name */
    public final ArrayList f12654l0;

    /* renamed from: m, reason: collision with root package name */
    public final b1 f12655m;

    /* renamed from: m0, reason: collision with root package name */
    public final ve.d f12656m0;

    /* renamed from: n, reason: collision with root package name */
    public w0 f12657n;

    /* renamed from: n0, reason: collision with root package name */
    public boolean f12658n0;

    /* renamed from: o, reason: collision with root package name */
    public Rect f12659o;

    /* renamed from: o0, reason: collision with root package name */
    public boolean f12660o0;

    /* renamed from: p, reason: collision with root package name */
    public final int f12661p;

    /* renamed from: p0, reason: collision with root package name */
    public boolean f12662p0;

    /* renamed from: q, reason: collision with root package name */
    public int f12663q;

    /* renamed from: q0, reason: collision with root package name */
    public final d0 f12664q0;

    /* renamed from: r, reason: collision with root package name */
    public boolean f12665r;

    /* renamed from: r0, reason: collision with root package name */
    public boolean f12666r0;

    /* renamed from: s, reason: collision with root package name */
    public boolean f12667s;

    /* renamed from: s0, reason: collision with root package name */
    public int f12668s0;

    /* renamed from: t, reason: collision with root package name */
    public boolean f12669t;

    /* renamed from: t0, reason: collision with root package name */
    public final boolean f12670t0;

    /* renamed from: u, reason: collision with root package name */
    public int f12671u;

    /* renamed from: v, reason: collision with root package name */
    public int f12672v;

    /* renamed from: w, reason: collision with root package name */
    public int f12673w;

    /* renamed from: x, reason: collision with root package name */
    public int f12674x;

    /* renamed from: y, reason: collision with root package name */
    public int f12675y;

    /* renamed from: z, reason: collision with root package name */
    public int f12676z;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public class MultiChoiceModeWrapper implements f1 {

        /* renamed from: a, reason: collision with root package name */
        public f1 f12677a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ StepOSRecyclerView f12678b;

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f12677a.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            if (!this.f12677a.onCreateActionMode(actionMode, menu)) {
                return false;
            }
            StepOSRecyclerView stepOSRecyclerView = this.f12678b;
            int i = stepOSRecyclerView.f12643f;
            if (i == 4 || i == 5) {
                stepOSRecyclerView.setLongClickable(true);
            } else {
                stepOSRecyclerView.setLongClickable(false);
            }
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode actionMode) throws NoSuchFieldException, SecurityException {
            StepOSRecyclerView stepOSRecyclerView = this.f12678b;
            if (stepOSRecyclerView.f12660o0) {
                stepOSRecyclerView.f12656m0.f14931j = true;
            }
            this.f12677a.onDestroyActionMode(actionMode);
            stepOSRecyclerView.f12644g = null;
            stepOSRecyclerView.f12662p0 = true;
            stepOSRecyclerView.f();
            stepOSRecyclerView.u();
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

        public final void onItemCheckedStateChanged(ActionMode actionMode, int i, long j10, boolean z10) {
            ((MultiChoiceModeWrapper) this.f12677a).onItemCheckedStateChanged(actionMode, i, j10, z10);
            StepOSRecyclerView stepOSRecyclerView = this.f12678b;
            if (stepOSRecyclerView.getCheckedItemCount() == 0) {
                int i3 = stepOSRecyclerView.f12643f;
            }
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.f12677a.onPrepareActionMode(actionMode, menu);
        }
    }

    public StepOSRecyclerView(Context context, AttributeSet attributeSet, int i) throws NoSuchFieldException, Resources.NotFoundException, SecurityException {
        int touchSlop;
        super(context, attributeSet, i);
        Math.tan(1.0471975824055166d);
        this.f12640c = -1;
        this.f12643f = 0;
        this.f12651k = false;
        Interpolator interpolator = null;
        this.f12657n = null;
        this.K = true;
        this.L = false;
        this.N = new Rect();
        this.O = -1;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.U = false;
        this.V = false;
        this.W = false;
        this.f12642d0 = Float.MAX_VALUE;
        this.f0 = -1;
        this.f12647h0 = -1;
        this.f12650j0 = false;
        this.f12652k0 = new ArrayList();
        this.f12654l0 = new ArrayList();
        this.f12658n0 = true;
        this.f12660o0 = true;
        this.f12662p0 = false;
        this.f12666r0 = false;
        this.f12668s0 = ViewConfiguration.getPressedStateDuration();
        this.f12670t0 = false;
        Resources resources = getResources();
        this.f12665r = false;
        this.f12661p = resources.getDimensionPixelSize(R.dimen.stepos_list_check_width);
        this.I = resources.getDimensionPixelSize(R.dimen.stepos_list_item_height);
        this.f12669t = false;
        this.f12671u = 0;
        this.f12672v = 0;
        this.f12673w = 0;
        this.f12674x = 0;
        this.f12675y = -1;
        this.f12676z = -1;
        this.B = 0;
        this.G = null;
        this.H = false;
        this.E = -1;
        this.C = -1;
        this.D = -1;
        getResources().getDimensionPixelSize(R.dimen.stepos_recyclerview_scrollbar_padding);
        d1 d1Var = new d1();
        d1Var.f12743c = this;
        d1Var.f12742b = false;
        VarHandle.storeStoreFence();
        b1 b1Var = new b1();
        b1Var.f12733w = this;
        b1Var.f12789d = new o0(b1Var);
        b1Var.f12790e = d1Var;
        b1Var.f12798n = true;
        if (context == null) {
            touchSlop = ViewConfiguration.getTouchSlop();
            b1Var.f12787b = ViewConfiguration.getMinimumFlingVelocity();
            b1Var.f12788c = ViewConfiguration.getMaximumFlingVelocity();
        } else {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            b1Var.f12787b = viewConfiguration.getScaledMinimumFlingVelocity();
            b1Var.f12788c = viewConfiguration.getScaledMaximumFlingVelocity();
            touchSlop = scaledTouchSlop;
        }
        b1Var.f12786a = touchSlop * touchSlop;
        b1Var.f12731u = -1;
        b1Var.f12727q = d1Var;
        b1Var.f12730t = ViewConfiguration.get(context).getScaledTouchSlop();
        VarHandle.storeStoreFence();
        this.f12655m = b1Var;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, le.a.f7862a, i, 0);
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
        ve.d dVar = new ve.d(context, this, new OverScroller(context, interpolator), -1);
        this.f12656m0 = dVar;
        dVar.f14936o = 0.99f;
        dVar.f14937p = 228.0f;
        dVar.f14926d = 0.5f;
        if (d0.f12739f == null) {
            synchronized (d0.class) {
                try {
                    if (d0.f12739f == null) {
                        d0.f12739f = new d0("FeedbackHandlerThread");
                    }
                } finally {
                }
            }
        }
        d0 d0Var = d0.f12739f;
        d0Var.getClass();
        if (Thread.State.NEW == d0Var.getState()) {
            d0Var.start();
        }
        this.f12664q0 = d0.f12739f;
        if (TextUtils.equals(Build.BRAND, "Sony")) {
            this.f12670t0 = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x0139  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(stepos.support.v7.widget.StepOSRecyclerView r13, android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.StepOSRecyclerView.a(stepos.support.v7.widget.StepOSRecyclerView, android.view.MotionEvent):boolean");
    }

    public static void b(StepOSRecyclerView stepOSRecyclerView) {
        stepOSRecyclerView.f12676z = -1;
        stepOSRecyclerView.B = -1;
        stepOSRecyclerView.f12669t = false;
        stepOSRecyclerView.A = false;
        stepOSRecyclerView.F = -1;
        stepOSRecyclerView.D = -1;
        stepOSRecyclerView.C = -1;
        stepOSRecyclerView.f12675y = -1;
        stepOSRecyclerView.H = false;
        l1 l1Var = stepOSRecyclerView.G;
        if (l1Var != null) {
            l1Var.f12775f = false;
            l1Var.f12776g.removeCallbacks(l1Var);
        }
    }

    public static void d(StepOSRecyclerView stepOSRecyclerView, int i, boolean z10) {
        if (stepOSRecyclerView.getChildCountExt() == 0) {
            return;
        }
        if (z10) {
            stepOSRecyclerView.offsetChildrenVertical(i);
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

    public static boolean k(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (viewGroup instanceof RecyclerView) {
            return true;
        }
        ViewParent parent = viewGroup.getParent();
        if (parent instanceof ViewGroup) {
            return k((ViewGroup) parent);
        }
        return false;
    }

    public static void setAvoidNotifyItemRangeChanged(boolean z10) {
        f12637u0 = z10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        if (!(itemDecoration instanceof z0)) {
            Log.i("StepOSRecyclerView", "you should use StepOSRecyclerView.ItemDecoration!! Otherwise, it may cause problems");
        }
        super.addItemDecoration(itemDecoration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        if (!this.L) {
            Rect rect = this.N;
            if (!rect.isEmpty()) {
                Drawable drawable = this.M;
                drawable.setBounds(rect);
                drawable.draw(canvas);
            }
        }
        super.dispatchDraw(canvas);
        int itemDecorationCount = getItemDecorationCount();
        for (int i = 0; i < itemDecorationCount; i++) {
            getItemDecorationAt(i);
        }
        for (int i3 = 0; i3 < itemDecorationCount; i3++) {
            getItemDecorationAt(i3);
        }
        int itemDecorationCount2 = getItemDecorationCount();
        for (int i10 = 0; i10 < itemDecorationCount2; i10++) {
            getItemDecorationAt(i10);
        }
        int itemDecorationCount3 = getItemDecorationCount();
        for (int i11 = 0; i11 < itemDecorationCount3; i11++) {
            getItemDecorationAt(i11);
        }
    }

    public boolean dispatchStatusBarTap() {
        int firstPosition;
        View childAt;
        if (getItemCount() == 0 || this.f12656m0.j() || (((firstPosition = getFirstPosition()) == 0 && (childAt = getChildAt(0)) != null && childAt.getTop() >= getPaddingTop()) || getItemCount() == Integer.MAX_VALUE)) {
            return false;
        }
        androidx.activity.h hVar = this.J;
        if (hVar != null) {
            StepOSRecyclerView stepOSRecyclerView = (StepOSRecyclerView) hVar.f678g;
            stepOSRecyclerView.f12640c = -1;
            stepOSRecyclerView.removeCallbacks(hVar);
            n1.b(stepOSRecyclerView);
            ((OverScroller) hVar.f679h).abortAnimation();
            this.J = null;
        }
        if (firstPosition > getChildCount() * 2) {
            scrollToPosition(getChildCount() * 2);
        }
        smoothScrollToPosition(0);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0166  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchTouchEvent(android.view.MotionEvent r9) {
        /*
            Method dump skipped, instructions count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.StepOSRecyclerView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        v();
    }

    public final void f() {
        SparseBooleanArray sparseBooleanArray = this.f12649j;
        if (sparseBooleanArray != null) {
            sparseBooleanArray.clear();
        }
        p.n nVar = this.f12653l;
        if (nVar != null) {
            nVar.a();
        }
        this.i = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final boolean fling(int i, int i3) {
        this.f12656m0.f(i, i3);
        return super.fling(i, i3);
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
    public final void g(int r10, int r11) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.StepOSRecyclerView.g(int, int):void");
    }

    public int getCheckedItemCount() {
        return this.i;
    }

    public long[] getCheckedItemIds() {
        if (this.f12643f == 0 || this.f12653l == null || getAdapter() == null) {
            return new long[0];
        }
        p.n nVar = this.f12653l;
        int iH = nVar.h();
        long[] jArr = new long[iH];
        for (int i = 0; i < iH; i++) {
            jArr[i] = nVar.d(i);
        }
        return jArr;
    }

    public SparseBooleanArray getCheckedItemPositions() {
        if (this.f12643f != 0) {
            return this.f12649j;
        }
        return null;
    }

    public int getChoiceMode() {
        return this.f12643f;
    }

    public int getCount() {
        return getAdapter().getItemCount();
    }

    public int getFirstPosition() {
        View viewL = l(0);
        if (viewL == null) {
            return -1;
        }
        return getChildLayoutPosition(viewL);
    }

    public int getFooterViewsCount() {
        if (getAdapter() == null || !(getAdapter() instanceof h0)) {
            return 0;
        }
        return ((h0) getAdapter()).f12760b.f9616g;
    }

    public int getHeaderViewsCount() {
        if (getAdapter() == null || !(getAdapter() instanceof h0)) {
            return 0;
        }
        return ((h0) getAdapter()).f12759a.f9616g;
    }

    public int getLastPosition() {
        View viewL = l(getChildCountExt() - 1);
        if (viewL == null) {
            return -1;
        }
        return getChildLayoutPosition(viewL);
    }

    public final h1 getOnItemClickListener() {
        return null;
    }

    public final i1 getOnItemLongClickListener() {
        return null;
    }

    public ve.d getSpringAnimationHelper() {
        return this.f12656m0;
    }

    public HashSet getViewHoldSet() {
        return this.e0;
    }

    public final void h(boolean z10) {
        if (this.f12659o == null) {
            Rect rect = new Rect();
            this.f12659o = rect;
            rect.setEmpty();
        }
        int i = this.f12643f;
        if (i != 4 && i != 5) {
            this.f12659o.setEmpty();
            return;
        }
        if (this.f12659o.isEmpty() || z10) {
            int layoutDirection = getLayoutDirection();
            Rect rect2 = this.f12659o;
            if (layoutDirection == 1) {
                rect2.left = getPaddingLeft();
                Rect rect3 = this.f12659o;
                rect3.right = rect3.left + this.f12663q;
                rect3.top = getPaddingTop();
                this.f12659o.bottom = getHeight() - getPaddingBottom();
                return;
            }
            rect2.right = getWidth() - getPaddingRight();
            Rect rect4 = this.f12659o;
            rect4.left = rect4.right - this.f12663q;
            rect4.top = getPaddingTop();
            this.f12659o.bottom = getHeight() - getPaddingBottom();
        }
    }

    public final int i(boolean z10) {
        int childCountExt = getChildCountExt();
        int firstPosition = getFirstPosition();
        if (z10) {
            for (int i = 0; i < childCountExt; i++) {
                View viewL = l(i);
                int iN = n(viewL);
                RecyclerView.LayoutManager layoutManager = getLayoutManager();
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewL.getLayoutParams();
                if (iN - (((layoutManager.getDecoratedMeasuredHeight(viewL) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) / 2) > getPaddingTop()) {
                    return firstPosition + i;
                }
            }
            return -1;
        }
        for (int i3 = childCountExt - 1; i3 >= 0; i3--) {
            View viewL2 = l(i3);
            int iO = o(viewL2);
            RecyclerView.LayoutManager layoutManager2 = getLayoutManager();
            RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) viewL2.getLayoutParams();
            if ((((layoutManager2.getDecoratedMeasuredHeight(viewL2) + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin) / 2) + iO < getHeight() - getPaddingBottom()) {
                return firstPosition + i3;
            }
        }
        return -1;
    }

    public final View j(int i, int i3) {
        for (int childCount = getLayoutManager().getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getLayoutManager().getChildAt(childCount);
            float translationY = childAt.getTranslationY();
            if (this.f12650j0) {
                float translationX = childAt.getTranslationX();
                float f5 = i;
                if (f5 >= (getLayoutManager().getDecoratedLeft(childAt) - ((RecyclerView.LayoutParams) childAt.getLayoutParams()).getMarginStart()) + translationX) {
                    RecyclerView.LayoutManager layoutManager = getLayoutManager();
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                    if (f5 <= layoutParams.getMarginEnd() + layoutManager.getDecoratedRight(childAt) + translationX) {
                        float f10 = i3;
                        if (f10 >= o(childAt) + translationY && f10 <= n(childAt) + translationY) {
                            return childAt;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            } else {
                float f11 = i3;
                if (f11 >= o(childAt) + translationY && f11 <= n(childAt) + translationY) {
                    return childAt;
                }
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.M;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public final View l(int i) {
        return getLayoutManager().getChildAt(i);
    }

    public final int m(View view) {
        if (view == null) {
            return -1;
        }
        return getChildLayoutPosition(view);
    }

    public final int n(View view) {
        return getLayoutManager().getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    public final int o(View view) {
        return getLayoutManager().getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
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
            boolean r0 = k(r0)
            if (r0 == 0) goto L11
            boolean r4 = super.onInterceptTouchEvent(r5)
            return r4
        L11:
            r0 = 1
            ve.d r1 = r4.f12656m0
            if (r5 == 0) goto L3f
            boolean r2 = r1.f14931j
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
            r1.f14928f = r3
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
            boolean r2 = r4.f12666r0
            if (r2 == 0) goto L60
            r1.requestDisallowInterceptTouchEvent(r0)
        L60:
            boolean r4 = super.onInterceptTouchEvent(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.StepOSRecyclerView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i3, int i10, int i11) throws NoSuchFieldException, SecurityException {
        RecyclerView.State state;
        int iIntValue;
        View view;
        y0 y0Var;
        int i12;
        ActionMode actionMode;
        MultiChoiceModeWrapper multiChoiceModeWrapper;
        int i13;
        super.onLayout(z10, i, i3, i10, i11);
        int i14 = 0;
        if (this.f12643f == 5 && !this.f12662p0 && this.f12657n == null) {
            w0 w0Var = new w0(i14);
            w0Var.f12894f = this;
            VarHandle.storeStoreFence();
            this.f12657n = w0Var;
            post(w0Var);
        }
        try {
            Field declaredField = RecyclerView.class.getDeclaredField("mState");
            declaredField.setAccessible(true);
            state = (RecyclerView.State) declaredField.get(this);
        } catch (Exception e10) {
            Log.e("StepOSRecyclerViewHelper", "getStateField ex" + e10.toString());
            state = null;
        }
        try {
            Field declaredField2 = RecyclerView.State.class.getDeclaredField("mLayoutStep");
            declaredField2.setAccessible(true);
            iIntValue = ((Integer) declaredField2.get(state)).intValue();
        } catch (Exception e11) {
            Log.e("StepOSRecyclerViewHelper", "getRvStateStepField ex" + e11.toString());
            iIntValue = 0;
        }
        if (iIntValue == 1 && state.didStructureChange()) {
            RecyclerView.Adapter adapter = getAdapter();
            if (this.f12643f == 0 || adapter == null || !adapter.hasStableIds()) {
                view = null;
            } else {
                int itemCount = getItemCount();
                this.f12649j.clear();
                int i15 = 0;
                boolean z11 = false;
                while (i15 < this.f12653l.h()) {
                    long jD = this.f12653l.d(i15);
                    int iIntValue2 = ((Integer) this.f12653l.j(i15)).intValue();
                    if (jD != adapter.getItemId(iIntValue2)) {
                        int iMax = Math.max(0, iIntValue2 - 20);
                        int iMin = Math.min(iIntValue2 + 20, itemCount);
                        while (true) {
                            if (iMax >= iMin) {
                                this.f12653l.b(jD);
                                i15--;
                                this.i--;
                                ActionMode actionMode2 = this.f12644g;
                                if (actionMode2 != null && (multiChoiceModeWrapper = this.f12646h) != null) {
                                    multiChoiceModeWrapper.onItemCheckedStateChanged(actionMode2, iIntValue2, jD, false);
                                }
                                z11 = true;
                            } else if (jD == adapter.getItemId(iMax)) {
                                this.f12649j.put(iMax, true);
                                p.n nVar = this.f12653l;
                                Integer numValueOf = Integer.valueOf(iMax);
                                if (i15 < 0 || i15 >= (i13 = nVar.f9596h)) {
                                    nVar.getClass();
                                    ad.o.j(i15, "Expected index to be within 0..size()-1, but was ");
                                    return;
                                }
                                if (nVar.f9593c) {
                                    long[] jArr = nVar.f9594f;
                                    Object[] objArr = nVar.f9595g;
                                    int i16 = 0;
                                    for (int i17 = 0; i17 < i13; i17++) {
                                        Object obj = objArr[i17];
                                        if (obj != p.o.f9598a) {
                                            if (i17 != i16) {
                                                jArr[i16] = jArr[i17];
                                                objArr[i16] = obj;
                                                objArr[i17] = null;
                                            }
                                            i16++;
                                        }
                                    }
                                    nVar.f9593c = false;
                                    nVar.f9596h = i16;
                                }
                                nVar.f9595g[i15] = numValueOf;
                            } else {
                                iMax++;
                            }
                        }
                    } else {
                        this.f12649j.put(iIntValue2, true);
                    }
                    i15++;
                }
                view = null;
                if (z11 && (actionMode = this.f12644g) != null) {
                    actionMode.invalidate();
                }
            }
            RecyclerView.Adapter adapter2 = getAdapter();
            if (adapter2.hasStableIds() && (y0Var = this.T) != null && (i12 = y0Var.f12926b) != -1) {
                long j10 = y0Var.f12927c;
                if (j10 != adapter2.getItemId(i12)) {
                    View view2 = this.T.f12925a;
                    if (view2 != null) {
                        view2.setHovered(false);
                        Drawable background = this.T.f12925a.getBackground();
                        if (background != null) {
                            background.jumpToCurrentState();
                        }
                    }
                    y0 y0Var2 = this.T;
                    y0Var2.f12925a = view;
                    y0Var2.f12926b = -1;
                    int iMax2 = Math.max(0, i12 - 20);
                    int iMin2 = Math.min(i12 + 20, adapter2.getItemCount());
                    while (true) {
                        if (iMax2 >= iMin2) {
                            break;
                        }
                        if (j10 == adapter2.getItemId(iMax2)) {
                            RecyclerView.ViewHolder viewHolderFindViewHolderForItemId = findViewHolderForItemId(j10);
                            if (viewHolderFindViewHolderForItemId != null) {
                                y0 y0Var3 = this.T;
                                y0Var3.f12926b = iMax2;
                                y0Var3.f12925a = viewHolderFindViewHolderForItemId.itemView;
                            }
                        } else {
                            iMax2++;
                        }
                    }
                }
            }
            setPressed(false);
            Drawable drawable = this.M;
            if (drawable != null) {
                drawable.jumpToCurrentState();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onMeasure(int i, int i3) throws IllegalAccessException, Resources.NotFoundException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Drawable drawable;
        if (this.M == null) {
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
                    PathInterpolator pathInterpolator = StepOSPressAnimationDrawable.G;
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
                drawable = getResources().getDrawable(R.drawable.stepos_recyclerview_selector);
            }
            setSelector(drawable);
        }
        super.onMeasure(i, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void onScrolled(int i, int i3) {
        if (this.W) {
            this.f12641c0.getClass();
        }
        super.onScrolled(i, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onSizeChanged(int i, int i3, int i10, int i11) {
        super.onSizeChanged(i, i3, i10, i11);
        h(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:193:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x052c  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0530  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x053c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0551  */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r26) {
        /*
            Method dump skipped, instructions count: 1367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.StepOSRecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z10) {
        y0 y0Var;
        View view;
        super.onWindowFocusChanged(z10);
        if (!z10 || !this.U || (y0Var = this.T) == null || (view = y0Var.f12925a) == null) {
            return;
        }
        if (this.V) {
            view.setHovered(true);
            this.V = false;
        }
        this.T.f12925a.setHovered(false);
        y0 y0Var2 = this.T;
        y0Var2.f12925a = null;
        y0Var2.f12927c = -1L;
        y0Var2.f12926b = -1;
    }

    public final boolean p(int i, int i3) {
        View viewJ = j(i, i3);
        if (viewJ == null) {
            return false;
        }
        this.f12675y = getChildLayoutPosition(viewJ);
        this.f12673w = o(viewJ);
        this.f12674x = n(viewJ);
        this.f12671u = getLayoutManager().getDecoratedLeft(viewJ) - ((RecyclerView.LayoutParams) viewJ.getLayoutParams()).getMarginStart();
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewJ.getLayoutParams();
        this.f12672v = layoutParams.getMarginEnd() + layoutManager.getDecoratedRight(viewJ);
        return true;
    }

    public final void q(int i, View view) {
        boolean z10 = i != this.O;
        if (i != -1) {
            this.O = i;
        }
        int left = view.getLeft();
        int top = view.getTop();
        int right = view.getRight();
        int bottom = view.getBottom();
        Rect rect = this.N;
        rect.set(left, top, right, bottom);
        rect.left -= this.P;
        rect.top -= this.Q;
        rect.right += this.R;
        rect.bottom += this.S;
        Drawable drawable = this.M;
        if (drawable != null) {
            drawable.setBounds(rect);
            if (z10) {
                if (getVisibility() == 0) {
                    drawable.setVisible(true, false);
                }
                v();
            }
        }
        refreshDrawableState();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(int r9, boolean r10) {
        /*
            r8 = this;
            int r0 = r8.f12643f
            if (r0 != 0) goto L5
            return
        L5:
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = r8.getAdapter()
            r1 = 4
            if (r10 == 0) goto L29
            int r2 = r8.f12643f
            if (r2 != r1) goto L29
            android.view.ActionMode r2 = r8.f12644g
            if (r2 != 0) goto L29
            stepos.support.v7.widget.StepOSRecyclerView$MultiChoiceModeWrapper r2 = r8.f12646h
            if (r2 == 0) goto L23
            stepos.support.v7.widget.f1 r3 = r2.f12677a
            if (r3 == 0) goto L23
            android.view.ActionMode r2 = r8.startActionMode(r2)
            r8.f12644g = r2
            goto L29
        L23:
            java.lang.String r8 = "RecyclerView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback."
            od.f.e(r8)
            return
        L29:
            int r2 = r8.f12643f
            r3 = 1
            if (r2 == r1) goto L88
            r1 = 5
            if (r2 != r1) goto L32
            goto L88
        L32:
            p.n r1 = r8.f12653l
            r2 = 0
            if (r1 == 0) goto L3f
            boolean r1 = r0.hasStableIds()
            if (r1 == 0) goto L3f
            r1 = r3
            goto L40
        L3f:
            r1 = r2
        L40:
            if (r10 != 0) goto L52
            int r4 = r8.f12643f
            if (r4 == 0) goto L4f
            android.util.SparseBooleanArray r4 = r8.f12649j
            if (r4 == 0) goto L4f
            boolean r4 = r4.get(r9)
            goto L50
        L4f:
            r4 = r2
        L50:
            if (r4 == 0) goto L5e
        L52:
            android.util.SparseBooleanArray r4 = r8.f12649j
            r4.clear()
            if (r1 == 0) goto L5e
            p.n r4 = r8.f12653l
            r4.a()
        L5e:
            android.util.SparseBooleanArray r4 = r8.f12649j
            if (r10 == 0) goto L77
            r4.put(r9, r3)
            if (r1 == 0) goto L74
            p.n r10 = r8.f12653l
            long r0 = r0.getItemId(r9)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r10.e(r9, r0)
        L74:
            r8.i = r3
            goto Ld2
        L77:
            int r9 = r4.size()
            if (r9 == 0) goto L85
            android.util.SparseBooleanArray r9 = r8.f12649j
            boolean r9 = r9.valueAt(r2)
            if (r9 != 0) goto Ld2
        L85:
            r8.i = r2
            goto Ld2
        L88:
            android.util.SparseBooleanArray r1 = r8.f12649j
            boolean r1 = r1.get(r9)
            android.util.SparseBooleanArray r2 = r8.f12649j
            r2.put(r9, r10)
            p.n r2 = r8.f12653l
            if (r2 == 0) goto Lb4
            boolean r2 = r0.hasStableIds()
            if (r2 == 0) goto Lb4
            p.n r2 = r8.f12653l
            if (r10 == 0) goto Lad
            long r4 = r0.getItemId(r9)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r9)
            r2.e(r6, r4)
            goto Lb4
        Lad:
            long r4 = r0.getItemId(r9)
            r2.b(r4)
        Lb4:
            if (r1 == r10) goto Lc1
            int r1 = r8.i
            if (r10 == 0) goto Lbe
            int r1 = r1 + r3
            r8.i = r1
            goto Lc1
        Lbe:
            int r1 = r1 - r3
            r8.i = r1
        Lc1:
            android.view.ActionMode r1 = r8.f12644g
            if (r1 == 0) goto Ld2
            long r5 = r0.getItemId(r9)
            stepos.support.v7.widget.StepOSRecyclerView$MultiChoiceModeWrapper r2 = r8.f12646h
            android.view.ActionMode r3 = r8.f12644g
            r4 = r9
            r7 = r10
            r2.onItemCheckedStateChanged(r3, r4, r5, r7)
        Ld2:
            r8.u()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.StepOSRecyclerView.r(int, boolean):void");
    }

    public final boolean s(int i) {
        if (i >= 0) {
            return i < getHeaderViewsCount() || i >= getItemCount() - getFooterViewsCount();
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        if (!(adapter instanceof m1)) {
            Log.i("StepOSRecyclerView", "you should use StepOSRecyclerView.Adapter！！！ Otherwise, it may cause problems");
        }
        if (adapter != null) {
            ArrayList arrayList = this.f12652k0;
            int size = arrayList.size();
            ArrayList arrayList2 = this.f12654l0;
            if (size > 0 || arrayList2.size() > 0) {
                if (!(adapter instanceof h0)) {
                    adapter = new h0(adapter);
                }
                h0 h0Var = (h0) adapter;
                int size2 = arrayList.size();
                int i = 0;
                int i3 = 0;
                while (i3 < size2) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    if (obj != null) {
                        od.f.j();
                        return;
                    }
                    p.q0 q0Var = h0Var.f12759a;
                    int i10 = h0.f12757e;
                    h0.f12757e = i10 + 1;
                    q0Var.c(i10, null);
                }
                int size3 = arrayList2.size();
                while (i < size3) {
                    Object obj2 = arrayList2.get(i);
                    i++;
                    if (obj2 != null) {
                        od.f.j();
                        return;
                    }
                    p.q0 q0Var2 = h0Var.f12760b;
                    int i11 = h0.f12758f;
                    h0.f12758f = i11 + 1;
                    q0Var2.c(i11, null);
                }
            }
        }
        super.setAdapter(adapter);
        if (adapter != null) {
            boolean zHasStableIds = getAdapter().hasStableIds();
            if (this.f12643f != 0 && zHasStableIds && this.f12653l == null) {
                this.f12653l = new p.n((Object) null);
            }
        }
        f();
    }

    public void setBaseDuration(int i) {
        k1 k1Var = this.f12641c0;
        if (k1Var != null) {
            k1Var.f12766c = i;
        }
    }

    public void setBottomOverScrollEnable(boolean z10) {
        this.f12656m0.f14933l = z10;
    }

    public void setCheckBoxIsAnimation(boolean z10) {
        if (this.K != z10) {
            this.K = z10;
        }
    }

    public void setChoiceMode(int i) {
        this.f12643f = i;
        ActionMode actionMode = this.f12644g;
        if (actionMode != null) {
            actionMode.finish();
            this.f12644g = null;
        }
        if (this.f12643f != 0) {
            if (this.f12649j == null) {
                this.f12649j = new SparseBooleanArray(0);
            }
            RecyclerView.Adapter adapter = getAdapter();
            if (this.f12653l == null && adapter != null && adapter.hasStableIds()) {
                this.f12653l = new p.n(0);
            }
            if (this.f12643f == 4) {
                f();
                setLongClickable(true);
            }
        }
    }

    public void setDrawSelectorOnTop(boolean z10) {
        this.L = z10;
    }

    public void setEnableDragSelection(g1 g1Var) {
        setEnableDragSelection(true);
    }

    public void setEnableHoldPress(boolean z10) {
        this.U = z10;
    }

    public void setEnableParallax(boolean z10) {
        if (z10) {
            if (this.f12641c0 == null) {
                k1 k1Var = new k1();
                k1Var.f12764a = new HashMap();
                new ArrayList();
                k1Var.f12765b = new LinearInterpolator();
                k1Var.f12766c = 500;
                k1Var.f12768e = 3;
                k1Var.f12770g = true;
                VarHandle.storeStoreFence();
                this.f12641c0 = k1Var;
            }
            if (this.e0 == null) {
                this.e0 = new HashSet();
            }
        }
        this.W = z10;
    }

    public void setEndOverScrollEnable(boolean z10) {
        this.f12656m0.f14935n = z10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        ve.d dVar = this.f12656m0;
        if (dVar != null && layoutManager != null) {
            dVar.f14941t = layoutManager.canScrollVertically() ? 1 : 0;
        }
        this.f12650j0 = (layoutManager instanceof GridLayoutManager) || (layoutManager instanceof StaggeredGridLayoutManager);
    }

    public void setMultiChoiceModeListener(f1 f1Var) {
        if (this.f12646h == null) {
            MultiChoiceModeWrapper multiChoiceModeWrapper = new MultiChoiceModeWrapper();
            multiChoiceModeWrapper.f12678b = this;
            VarHandle.storeStoreFence();
            this.f12646h = multiChoiceModeWrapper;
        }
        this.f12646h.f12677a = f1Var;
    }

    public void setOnItemLongClickListener(i1 i1Var) {
        if (isLongClickable()) {
            return;
        }
        setLongClickable(true);
    }

    public void setOverScrollEnable(boolean z10) {
        this.f12660o0 = z10;
        this.f12656m0.f14931j = z10;
    }

    public void setPressStateDuration(int i) {
        this.f12668s0 = i;
    }

    @Deprecated
    public void setRequestLayoutWhenSwitchActionMode(boolean z10) {
        this.f12651k = z10;
    }

    public void setScrollUpByItemCoveredInMultiChoiceEnable(boolean z10) {
        this.f12658n0 = z10;
    }

    public void setSelector(Drawable drawable) {
        Drawable drawable2 = this.M;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.M);
        }
        this.M = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        this.P = rect.left;
        this.Q = rect.top;
        this.R = rect.right;
        this.S = rect.bottom;
        drawable.setCallback(this);
        v();
    }

    public void setShouldRequestDisallowInterceptTouchEventWhenOverScroll(boolean z10) {
        this.f12666r0 = z10;
    }

    public void setSmoothBackInterpolator(TimeInterpolator timeInterpolator) {
        k1 k1Var;
        if (timeInterpolator == null || (k1Var = this.f12641c0) == null) {
            return;
        }
        k1Var.f12765b = timeInterpolator;
    }

    public void setStartOverScrollEnable(boolean z10) {
        this.f12656m0.f14934m = z10;
    }

    public void setTopOverScrollEnable(boolean z10) {
        this.f12656m0.f14932k = z10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void swapAdapter(RecyclerView.Adapter adapter, boolean z10) {
        ArrayList arrayList = this.f12652k0;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f12654l0;
        if (size > 0 || arrayList2.size() > 0) {
            if (!(adapter instanceof h0)) {
                adapter = new h0(adapter);
            }
            h0 h0Var = (h0) adapter;
            int size2 = arrayList.size();
            int i = 0;
            int i3 = 0;
            while (i3 < size2) {
                Object obj = arrayList.get(i3);
                i3++;
                if (obj != null) {
                    od.f.j();
                    return;
                }
                p.q0 q0Var = h0Var.f12759a;
                int i10 = h0.f12757e;
                h0.f12757e = i10 + 1;
                q0Var.c(i10, null);
            }
            int size3 = arrayList2.size();
            while (i < size3) {
                Object obj2 = arrayList2.get(i);
                i++;
                if (obj2 != null) {
                    od.f.j();
                    return;
                }
                p.q0 q0Var2 = h0Var.f12760b;
                int i11 = h0.f12758f;
                h0.f12758f = i11 + 1;
                q0Var2.c(i11, null);
            }
        }
        super.swapAdapter(adapter, z10);
        if (adapter != null) {
            boolean zHasStableIds = getAdapter().hasStableIds();
            if (this.f12643f != 0 && zHasStableIds && this.f12653l == null) {
                this.f12653l = new p.n((Object) null);
            }
        }
        f();
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
    public final void t(int i, int i3) {
        boolean zIsEnabled;
        boolean zIsSelectable;
        boolean z10;
        SparseBooleanArray sparseBooleanArray;
        RecyclerView.Adapter adapter = getAdapter();
        int firstPosition = getFirstPosition();
        for (int i10 = i == -1 ? i3 : i - 1; i10 >= i3; i10--) {
            boolean z11 = true;
            if (getAdapter() instanceof m1) {
                zIsEnabled = ((m1) getAdapter()).isEnabled(i10);
                zIsSelectable = ((m1) getAdapter()).isSelectable(i10);
            } else {
                zIsEnabled = true;
                zIsSelectable = true;
            }
            if (!zIsSelectable) {
                this.E = -1;
            } else {
                if (i10 == this.E) {
                    return;
                }
                if (getAdapter() == null || zIsEnabled) {
                    l(i10 - firstPosition);
                    adapter.getItemId(i10);
                    ?? r32 = (this.f12643f == 0 || (sparseBooleanArray = this.f12649j) == null) ? 0 : sparseBooleanArray.get(i10);
                    ?? r62 = this.f12645g0[i10];
                    ?? r72 = r62[0];
                    if (r72 == 0) {
                        r62[1] = r32;
                    }
                    int i11 = r72 + 1;
                    r62[0] = i11;
                    int i12 = this.f0;
                    if (i12 == -1) {
                        boolean z12 = this.f12648i0 ? r32 : r32 ^ 1;
                        this.f0 = z12 ? 1 : 0;
                        r62[1] = z12 ? 1 : 0;
                        z10 = z12;
                    } else if (i11 % 2 == 0) {
                        z11 = false;
                        z10 = z11;
                    } else {
                        z11 = false;
                        z10 = z11;
                    }
                    if (z10 != r32) {
                        r(i10, z10);
                        this.f12664q0.a(this);
                    }
                    this.C = i10;
                    this.D = -1;
                    this.E = -1;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void u() {
        SparseBooleanArray sparseBooleanArray;
        KeyEvent.Callback callbackFindViewById;
        int childCountExt = getChildCountExt();
        for (int i = 0; i < childCountExt; i++) {
            View viewL = l(i);
            int iM = m(viewL);
            if (viewL != 0 && this.f12643f != 0 && (sparseBooleanArray = this.f12649j) != null) {
                boolean z10 = sparseBooleanArray.get(iM);
                if (viewL instanceof Checkable) {
                    ((Checkable) viewL).setChecked(z10);
                } else if (getContext().getApplicationInfo().targetSdkVersion >= 11) {
                    int i3 = this.f12643f;
                    if ((i3 == 4 || i3 == 5) && (callbackFindViewById = viewL.findViewById(android.R.id.checkbox)) != null && (callbackFindViewById instanceof Checkable)) {
                        ((Checkable) callbackFindViewById).setChecked(this.f12644g != null);
                    }
                    viewL.setActivated(z10);
                }
            }
        }
    }

    public final void v() {
        if (this.M != null) {
            if ((!isFocused() || isInTouchMode()) && !isPressed()) {
                this.M.setState(StateSet.NOTHING);
            } else {
                this.M.setState(getDrawableState());
            }
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return this.M == drawable || super.verifyDrawable(drawable);
    }

    public void setEnableDragSelection(boolean z10) {
        this.f12667s = z10;
    }

    public void setSelector(int i) {
        setSelector(getResources().getDrawable(i));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSetPressed(boolean z10) {
    }

    public void setItenFilter(a1 a1Var) {
    }

    public void setMultiChoiceListener(e1 e1Var) {
    }

    public void setOnItemClickListener(h1 h1Var) {
    }

    public void setParallaxAnimationListener(j1 j1Var) {
    }

    public void setPinnedHeaderDecoration(ue.a aVar) {
    }

    public void setScrollSensitivity(int i) {
    }

    public StepOSRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StepOSRecyclerView(Context context) {
        this(context, null);
    }
}
