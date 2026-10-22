package stepos.support.v7.widget;

import android.animation.TimeInterpolator;
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
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.Checkable;
import android.widget.OverScroller;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.stepos.ability.R;
import com.stepos.common.animator.StepOSPressAnimationDrawable;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class StepOSRecyclerView extends RecyclerView {

    /* renamed from: u0, reason: collision with root package name */
    public static boolean f6512u0 = false;

    /* renamed from: A, reason: collision with root package name */
    public int f6513A;

    /* renamed from: B, reason: collision with root package name */
    public int f6514B;

    /* renamed from: C, reason: collision with root package name */
    public s0 f6515C;

    /* renamed from: D, reason: collision with root package name */
    public boolean f6516D;
    public final int E;

    /* renamed from: F, reason: collision with root package name */
    public com.google.android.material.bottomsheet.a f6517F;

    /* renamed from: G, reason: collision with root package name */
    public boolean f6518G;

    /* renamed from: L, reason: collision with root package name */
    public boolean f6519L;

    /* renamed from: M, reason: collision with root package name */
    public Drawable f6520M;

    /* renamed from: N, reason: collision with root package name */
    public final Rect f6521N;

    /* renamed from: O, reason: collision with root package name */
    public int f6522O;

    /* renamed from: P, reason: collision with root package name */
    public int f6523P;

    /* renamed from: Q, reason: collision with root package name */
    public int f6524Q;

    /* renamed from: R, reason: collision with root package name */
    public int f6525R;

    /* renamed from: S, reason: collision with root package name */
    public int f6526S;

    /* renamed from: T, reason: collision with root package name */
    public C5.d f6527T;

    /* renamed from: U, reason: collision with root package name */
    public boolean f6528U;

    /* renamed from: V, reason: collision with root package name */
    public boolean f6529V;

    /* renamed from: W, reason: collision with root package name */
    public boolean f6530W;

    /* renamed from: a, reason: collision with root package name */
    public int f6531a;

    /* renamed from: a0, reason: collision with root package name */
    public float f6532a0;
    public int b;
    public float b0;
    public ActionMode c;

    /* renamed from: c0, reason: collision with root package name */
    public r0 f6533c0;
    public MultiChoiceModeWrapper d;

    /* renamed from: d0, reason: collision with root package name */
    public float f6534d0;
    public int e;

    /* renamed from: e0, reason: collision with root package name */
    public HashSet f6535e0;
    public SparseBooleanArray f;

    /* renamed from: f0, reason: collision with root package name */
    public int f6536f0;
    public boolean g;

    /* renamed from: g0, reason: collision with root package name */
    public int[][] f6537g0;
    public LongSparseArray h;

    /* renamed from: h0, reason: collision with root package name */
    public int f6538h0;
    public final C1994i0 i;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f6539i0;

    /* renamed from: j, reason: collision with root package name */
    public RunnableC1986e0 f6540j;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f6541j0;
    public Rect k;

    /* renamed from: k0, reason: collision with root package name */
    public final ArrayList f6542k0;
    public final int l;

    /* renamed from: l0, reason: collision with root package name */
    public final ArrayList f6543l0;
    public int m;

    /* renamed from: m0, reason: collision with root package name */
    public final Xa.e f6544m0;
    public boolean n;

    /* renamed from: n0, reason: collision with root package name */
    public boolean f6545n0;
    public boolean o;

    /* renamed from: o0, reason: collision with root package name */
    public boolean f6546o0;
    public boolean p;

    /* renamed from: p0, reason: collision with root package name */
    public boolean f6547p0;

    /* renamed from: q, reason: collision with root package name */
    public int f6548q;

    /* renamed from: q0, reason: collision with root package name */
    public final J f6549q0;

    /* renamed from: r, reason: collision with root package name */
    public int f6550r;

    /* renamed from: r0, reason: collision with root package name */
    public boolean f6551r0;

    /* renamed from: s, reason: collision with root package name */
    public int f6552s;
    public int s0;

    /* renamed from: t, reason: collision with root package name */
    public int f6553t;
    public final boolean t0;
    public int u;

    /* renamed from: v, reason: collision with root package name */
    public int f6554v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f6555w;

    /* renamed from: x, reason: collision with root package name */
    public int f6556x;
    public int y;

    /* renamed from: z, reason: collision with root package name */
    public int f6557z;

    public class MultiChoiceModeWrapper implements m0 {

        /* renamed from: a, reason: collision with root package name */
        public m0 f6558a;

        public MultiChoiceModeWrapper() {
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f6558a.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            if (!this.f6558a.onCreateActionMode(actionMode, menu)) {
                return false;
            }
            StepOSRecyclerView stepOSRecyclerView = StepOSRecyclerView.this;
            int i = stepOSRecyclerView.b;
            if (i == 4 || i == 5) {
                stepOSRecyclerView.setLongClickable(true);
            } else {
                stepOSRecyclerView.setLongClickable(false);
            }
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode actionMode) throws NoSuchFieldException, SecurityException {
            StepOSRecyclerView stepOSRecyclerView = StepOSRecyclerView.this;
            if (stepOSRecyclerView.f6546o0) {
                stepOSRecyclerView.f6544m0.f1547j = true;
            }
            this.f6558a.onDestroyActionMode(actionMode);
            stepOSRecyclerView.c = null;
            stepOSRecyclerView.f6547p0 = true;
            stepOSRecyclerView.f();
            stepOSRecyclerView.u();
            stepOSRecyclerView.setLongClickable(true);
            try {
                Field declaredField = RecyclerView.class.getDeclaredField("mRecycler");
                declaredField.setAccessible(true);
                ((RecyclerView.Recycler) declaredField.get(stepOSRecyclerView)).clear();
            } catch (Exception e) {
                Log.e("StepOSRecyclerViewHelper", "invokeRvRecyclerVClear ex" + e.toString());
            }
            stepOSRecyclerView.getRecycledViewPool().clear();
        }

        public final void onItemCheckedStateChanged(ActionMode actionMode, int i, long j5, boolean z10) {
            ((MultiChoiceModeWrapper) this.f6558a).onItemCheckedStateChanged(actionMode, i, j5, z10);
            StepOSRecyclerView stepOSRecyclerView = StepOSRecyclerView.this;
            if (stepOSRecyclerView.getCheckedItemCount() == 0) {
                int i6 = stepOSRecyclerView.b;
            }
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.f6558a.onPrepareActionMode(actionMode, menu);
        }
    }

    public static class StepOSSavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<StepOSSavedState> CREATOR = new u0();
        LongSparseArray<Integer> checkIdState;
        SparseBooleanArray checkState;
        int checkedItemCount;
        boolean inActionMode;

        public /* synthetic */ StepOSSavedState(Parcel parcel, RunnableC1984d0 runnableC1984d0) {
            this(parcel);
        }

        public String toString() {
            return "StepOSRecyclerView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " checkState=" + this.checkState + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.inActionMode ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.checkedItemCount);
            parcel.writeSparseBooleanArray(this.checkState);
            LongSparseArray<Integer> longSparseArray = this.checkIdState;
            int size = longSparseArray != null ? longSparseArray.size() : 0;
            parcel.writeInt(size);
            for (int i6 = 0; i6 < size; i6++) {
                parcel.writeLong(this.checkIdState.keyAt(i6));
                parcel.writeInt(this.checkIdState.valueAt(i6).intValue());
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
            int i = parcel.readInt();
            if (i > 0) {
                this.checkIdState = new LongSparseArray<>();
                for (int i6 = 0; i6 < i; i6++) {
                    this.checkIdState.put(parcel.readLong(), Integer.valueOf(parcel.readInt()));
                }
            }
        }
    }

    public StepOSRecyclerView(Context context, AttributeSet attributeSet) throws NoSuchFieldException, Resources.NotFoundException, SecurityException {
        super(context, attributeSet, 0);
        Math.tan(1.0471975824055166d);
        this.f6531a = -1;
        this.b = 0;
        this.g = false;
        Interpolator interpolator = null;
        this.f6540j = null;
        this.f6518G = true;
        this.f6519L = false;
        this.f6521N = new Rect();
        this.f6522O = -1;
        this.f6523P = 0;
        this.f6524Q = 0;
        this.f6525R = 0;
        this.f6526S = 0;
        this.f6528U = false;
        this.f6529V = false;
        this.f6530W = false;
        this.f6534d0 = Float.MAX_VALUE;
        this.f6536f0 = -1;
        this.f6538h0 = -1;
        this.f6541j0 = false;
        this.f6542k0 = new ArrayList();
        this.f6543l0 = new ArrayList();
        this.f6545n0 = true;
        this.f6546o0 = true;
        this.f6547p0 = false;
        this.f6551r0 = false;
        this.s0 = ViewConfiguration.getPressedStateDuration();
        this.t0 = false;
        Resources resources = getResources();
        this.n = false;
        this.l = resources.getDimensionPixelSize(R.dimen.stepos_list_check_width);
        this.E = resources.getDimensionPixelSize(R.dimen.stepos_list_item_height);
        this.p = false;
        this.f6548q = 0;
        this.f6550r = 0;
        this.f6552s = 0;
        this.f6553t = 0;
        this.u = -1;
        this.f6554v = -1;
        this.f6556x = 0;
        this.f6515C = null;
        this.f6516D = false;
        this.f6513A = -1;
        this.y = -1;
        this.f6557z = -1;
        getResources().getDimensionPixelSize(R.dimen.stepos_recyclerview_scrollbar_padding);
        this.i = new C1994i0(this, context, new k0(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Pa.a.f1093a, 0, 0);
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
        } catch (Exception e) {
            Log.e("StepOSRecyclerViewHelper", "getsQuinticInterpolator ex" + e.toString());
        }
        Xa.e eVar = new Xa.e(context, this, new OverScroller(context, interpolator), -1);
        this.f6544m0 = eVar;
        eVar.o = 0.99f;
        eVar.p = 228.0f;
        eVar.d = 0.5f;
        if (J.c == null) {
            synchronized (J.class) {
                try {
                    if (J.c == null) {
                        J.c = new J("FeedbackHandlerThread");
                    }
                } finally {
                }
            }
        }
        J j5 = J.c;
        j5.getClass();
        if (Thread.State.NEW == j5.getState()) {
            j5.start();
        }
        this.f6549q0 = J.c;
        if (TextUtils.equals(Build.BRAND, "Sony")) {
            this.t0 = true;
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
        stepOSRecyclerView.f6554v = -1;
        stepOSRecyclerView.f6556x = -1;
        stepOSRecyclerView.p = false;
        stepOSRecyclerView.f6555w = false;
        stepOSRecyclerView.f6514B = -1;
        stepOSRecyclerView.f6557z = -1;
        stepOSRecyclerView.y = -1;
        stepOSRecyclerView.u = -1;
        stepOSRecyclerView.f6516D = false;
        s0 s0Var = stepOSRecyclerView.f6515C;
        if (s0Var != null) {
            s0Var.b = false;
            s0Var.c.removeCallbacks(s0Var);
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
        f6512u0 = z10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        if (!(itemDecoration instanceof AbstractC1990g0)) {
            Log.i("StepOSRecyclerView", "you should use StepOSRecyclerView.ItemDecoration!! Otherwise, it may cause problems");
        }
        super.addItemDecoration(itemDecoration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        if (!this.f6519L) {
            Rect rect = this.f6521N;
            if (!rect.isEmpty()) {
                Drawable drawable = this.f6520M;
                drawable.setBounds(rect);
                drawable.draw(canvas);
            }
        }
        super.dispatchDraw(canvas);
        int itemDecorationCount = getItemDecorationCount();
        for (int i = 0; i < itemDecorationCount; i++) {
            getItemDecorationAt(i);
        }
        for (int i6 = 0; i6 < itemDecorationCount; i6++) {
            getItemDecorationAt(i6);
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

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSetPressed(boolean z10) {
    }

    public boolean dispatchStatusBarTap() {
        int firstPosition;
        View childAt;
        if (getItemCount() == 0 || this.f6544m0.j() || (((firstPosition = getFirstPosition()) == 0 && (childAt = getChildAt(0)) != null && childAt.getTop() >= getPaddingTop()) || getItemCount() == Integer.MAX_VALUE)) {
            return false;
        }
        com.google.android.material.bottomsheet.a aVar = this.f6517F;
        if (aVar != null) {
            StepOSRecyclerView stepOSRecyclerView = (StepOSRecyclerView) aVar.d;
            stepOSRecyclerView.f6531a = -1;
            stepOSRecyclerView.removeCallbacks(aVar);
            v0.b(stepOSRecyclerView);
            ((OverScroller) aVar.c).abortAnimation();
            this.f6517F = null;
        }
        if (firstPosition > getChildCount() * 2) {
            scrollToPosition(getChildCount() * 2);
        }
        smoothScrollToPosition(0);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0160  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchTouchEvent(android.view.MotionEvent r9) {
        /*
            Method dump skipped, instructions count: 374
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
        SparseBooleanArray sparseBooleanArray = this.f;
        if (sparseBooleanArray != null) {
            sparseBooleanArray.clear();
        }
        LongSparseArray longSparseArray = this.h;
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
        this.e = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final boolean fling(int i, int i6) {
        this.f6544m0.f(i, i6);
        return super.fling(i, i6);
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
        return this.e;
    }

    public long[] getCheckedItemIds() {
        if (this.b == 0 || this.h == null || getAdapter() == null) {
            return new long[0];
        }
        LongSparseArray longSparseArray = this.h;
        int size = longSparseArray.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            jArr[i] = longSparseArray.keyAt(i);
        }
        return jArr;
    }

    public SparseBooleanArray getCheckedItemPositions() {
        if (this.b != 0) {
            return this.f;
        }
        return null;
    }

    public int getChoiceMode() {
        return this.b;
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
        if (getAdapter() == null || !(getAdapter() instanceof N)) {
            return 0;
        }
        return ((N) getAdapter()).b.size();
    }

    public int getHeaderViewsCount() {
        if (getAdapter() == null || !(getAdapter() instanceof N)) {
            return 0;
        }
        return ((N) getAdapter()).f6474a.size();
    }

    public int getLastPosition() {
        View viewL = l(getChildCountExt() - 1);
        if (viewL == null) {
            return -1;
        }
        return getChildLayoutPosition(viewL);
    }

    public final o0 getOnItemClickListener() {
        return null;
    }

    public final p0 getOnItemLongClickListener() {
        return null;
    }

    public Xa.e getSpringAnimationHelper() {
        return this.f6544m0;
    }

    public HashSet getViewHoldSet() {
        return this.f6535e0;
    }

    public final void h(boolean z10) {
        if (this.k == null) {
            Rect rect = new Rect();
            this.k = rect;
            rect.setEmpty();
        }
        int i = this.b;
        if (i != 4 && i != 5) {
            this.k.setEmpty();
            return;
        }
        if (this.k.isEmpty() || z10) {
            if (getLayoutDirection() == 1) {
                this.k.left = getPaddingLeft();
                Rect rect2 = this.k;
                rect2.right = rect2.left + this.m;
                rect2.top = getPaddingTop();
                this.k.bottom = getHeight() - getPaddingBottom();
                return;
            }
            this.k.right = getWidth() - getPaddingRight();
            Rect rect3 = this.k;
            rect3.left = rect3.right - this.m;
            rect3.top = getPaddingTop();
            this.k.bottom = getHeight() - getPaddingBottom();
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
        for (int i6 = childCountExt - 1; i6 >= 0; i6--) {
            View viewL2 = l(i6);
            int iO = o(viewL2);
            RecyclerView.LayoutManager layoutManager2 = getLayoutManager();
            RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) viewL2.getLayoutParams();
            if ((((layoutManager2.getDecoratedMeasuredHeight(viewL2) + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin) / 2) + iO < getHeight() - getPaddingBottom()) {
                return firstPosition + i6;
            }
        }
        return -1;
    }

    public final View j(int i, int i6) {
        for (int childCount = getLayoutManager().getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getLayoutManager().getChildAt(childCount);
            float translationY = childAt.getTranslationY();
            if (this.f6541j0) {
                float translationX = childAt.getTranslationX();
                float f = i;
                if (f >= (getLayoutManager().getDecoratedLeft(childAt) - ((RecyclerView.LayoutParams) childAt.getLayoutParams()).getMarginStart()) + translationX) {
                    RecyclerView.LayoutManager layoutManager = getLayoutManager();
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                    if (f <= layoutParams.getMarginEnd() + layoutManager.getDecoratedRight(childAt) + translationX) {
                        float f7 = i6;
                        if (f7 >= o(childAt) + translationY && f7 <= n(childAt) + translationY) {
                            return childAt;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            } else {
                float f9 = i6;
                if (f9 >= o(childAt) + translationY && f9 <= n(childAt) + translationY) {
                    return childAt;
                }
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f6520M;
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
            Xa.e r1 = r4.f6544m0
            if (r5 == 0) goto L3f
            boolean r2 = r1.f1547j
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
            r1.f = r3
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
            boolean r2 = r4.f6551r0
            if (r2 == 0) goto L60
            r1.requestDisallowInterceptTouchEvent(r0)
        L60:
            boolean r4 = super.onInterceptTouchEvent(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.StepOSRecyclerView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i6, int i10, int i11) throws NoSuchFieldException, SecurityException {
        RecyclerView.State state;
        int iIntValue;
        C5.d dVar;
        int i12;
        ActionMode actionMode;
        MultiChoiceModeWrapper multiChoiceModeWrapper;
        super.onLayout(z10, i, i6, i10, i11);
        if (this.b == 5 && !this.f6547p0 && this.f6540j == null) {
            RunnableC1986e0 runnableC1986e0 = new RunnableC1986e0(this, 0);
            this.f6540j = runnableC1986e0;
            post(runnableC1986e0);
        }
        try {
            Field declaredField = RecyclerView.class.getDeclaredField("mState");
            declaredField.setAccessible(true);
            state = (RecyclerView.State) declaredField.get(this);
        } catch (Exception e) {
            Log.e("StepOSRecyclerViewHelper", "getStateField ex" + e.toString());
            state = null;
        }
        try {
            Field declaredField2 = RecyclerView.State.class.getDeclaredField("mLayoutStep");
            declaredField2.setAccessible(true);
            iIntValue = ((Integer) declaredField2.get(state)).intValue();
        } catch (Exception e6) {
            Log.e("StepOSRecyclerViewHelper", "getRvStateStepField ex" + e6.toString());
            iIntValue = 0;
        }
        if (iIntValue == 1 && state.didStructureChange()) {
            RecyclerView.Adapter adapter = getAdapter();
            if (this.b != 0 && adapter != null && adapter.hasStableIds()) {
                int itemCount = getItemCount();
                this.f.clear();
                int i13 = 0;
                boolean z11 = false;
                while (i13 < this.h.size()) {
                    long jKeyAt = this.h.keyAt(i13);
                    int iIntValue2 = ((Integer) this.h.valueAt(i13)).intValue();
                    if (jKeyAt != adapter.getItemId(iIntValue2)) {
                        int iMax = Math.max(0, iIntValue2 - 20);
                        int iMin = Math.min(iIntValue2 + 20, itemCount);
                        while (true) {
                            if (iMax >= iMin) {
                                this.h.delete(jKeyAt);
                                i13--;
                                this.e--;
                                ActionMode actionMode2 = this.c;
                                if (actionMode2 != null && (multiChoiceModeWrapper = this.d) != null) {
                                    multiChoiceModeWrapper.onItemCheckedStateChanged(actionMode2, iIntValue2, jKeyAt, false);
                                }
                                z11 = true;
                            } else {
                                if (jKeyAt == adapter.getItemId(iMax)) {
                                    this.f.put(iMax, true);
                                    this.h.setValueAt(i13, Integer.valueOf(iMax));
                                    break;
                                }
                                iMax++;
                            }
                        }
                    } else {
                        this.f.put(iIntValue2, true);
                    }
                    i13++;
                }
                if (z11 && (actionMode = this.c) != null) {
                    actionMode.invalidate();
                }
            }
            RecyclerView.Adapter adapter2 = getAdapter();
            if (adapter2.hasStableIds() && (dVar = this.f6527T) != null && (i12 = dVar.b) != -1) {
                long j5 = dVar.c;
                if (j5 != adapter2.getItemId(i12)) {
                    View view = (View) this.f6527T.d;
                    if (view != null) {
                        view.setHovered(false);
                        Drawable background = ((View) this.f6527T.d).getBackground();
                        if (background != null) {
                            background.jumpToCurrentState();
                        }
                    }
                    C5.d dVar2 = this.f6527T;
                    dVar2.d = null;
                    dVar2.b = -1;
                    int iMax2 = Math.max(0, i12 - 20);
                    int iMin2 = Math.min(i12 + 20, adapter2.getItemCount());
                    while (true) {
                        if (iMax2 >= iMin2) {
                            break;
                        }
                        if (j5 == adapter2.getItemId(iMax2)) {
                            RecyclerView.ViewHolder viewHolderFindViewHolderForItemId = findViewHolderForItemId(j5);
                            if (viewHolderFindViewHolderForItemId != null) {
                                C5.d dVar3 = this.f6527T;
                                dVar3.b = iMax2;
                                dVar3.d = viewHolderFindViewHolderForItemId.itemView;
                            }
                        } else {
                            iMax2++;
                        }
                    }
                }
            }
            setPressed(false);
            Drawable drawable = this.f6520M;
            if (drawable != null) {
                drawable.jumpToCurrentState();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onMeasure(int i, int i6) throws IllegalAccessException, Resources.NotFoundException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Drawable drawable;
        if (this.f6520M == null) {
            Log.i("StepOSRecyclerView", "useDefaultSelector,  try to get f10 res");
            try {
                drawable = getResources().getDrawable(getResources().getIdentifier("stepos_recyclerview_selector_f10", "drawable", getContext().getPackageName()));
            } catch (Exception e) {
                Log.i("StepOSRecyclerView", "useDefaultSelector,  get f10 res fail , may be app code compression: " + e);
                drawable = null;
            }
            if (drawable == null) {
                Log.i("StepOSRecyclerView", "useDefaultSelector, get f10 res fail, and try to reflect StepOSPressAnimationDrawable");
                try {
                    Interpolator interpolator = StepOSPressAnimationDrawable.f3546C;
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
                } catch (Exception e6) {
                    Log.i("StepOSRecyclerView", "useDefaultSelector,  try to reflect StepOSPressAnimationDrawable fail " + e6);
                }
            }
            if (drawable == null) {
                Log.i("StepOSRecyclerView", "useDefaultSelector,  try to reflect StepOSPressAnimationDrawable fail , and to get old res");
                drawable = getResources().getDrawable(R.drawable.stepos_recyclerview_selector);
            }
            setSelector(drawable);
        }
        super.onMeasure(i, i6);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void onScrolled(int i, int i6) {
        if (this.f6530W) {
            boolean z10 = this.f6533c0.g;
        }
        super.onScrolled(i, i6);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onSizeChanged(int i, int i6, int i10, int i11) {
        super.onSizeChanged(i, i6, i10, i11);
        h(true);
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
    public final void onWindowFocusChanged(boolean z10) {
        C5.d dVar;
        View view;
        super.onWindowFocusChanged(z10);
        if (!z10 || !this.f6528U || (dVar = this.f6527T) == null || (view = (View) dVar.d) == null) {
            return;
        }
        if (this.f6529V) {
            view.setHovered(true);
            this.f6529V = false;
        }
        ((View) this.f6527T.d).setHovered(false);
        C5.d dVar2 = this.f6527T;
        dVar2.d = null;
        dVar2.c = -1L;
        dVar2.b = -1;
    }

    public final boolean p(int i, int i6) {
        View viewJ = j(i, i6);
        if (viewJ == null) {
            return false;
        }
        this.u = getChildLayoutPosition(viewJ);
        this.f6552s = o(viewJ);
        this.f6553t = n(viewJ);
        this.f6548q = getLayoutManager().getDecoratedLeft(viewJ) - ((RecyclerView.LayoutParams) viewJ.getLayoutParams()).getMarginStart();
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewJ.getLayoutParams();
        this.f6550r = layoutParams.getMarginEnd() + layoutManager.getDecoratedRight(viewJ);
        return true;
    }

    public final void q(int i, View view) {
        boolean z10 = i != this.f6522O;
        if (i != -1) {
            this.f6522O = i;
        }
        int left = view.getLeft();
        int top = view.getTop();
        int right = view.getRight();
        int bottom = view.getBottom();
        Rect rect = this.f6521N;
        rect.set(left, top, right, bottom);
        rect.left -= this.f6523P;
        rect.top -= this.f6524Q;
        rect.right += this.f6525R;
        rect.bottom += this.f6526S;
        Drawable drawable = this.f6520M;
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

    /* JADX WARN: Removed duplicated region for block: B:37:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(int r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
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
        if (!(adapter instanceof t0)) {
            Log.i("StepOSRecyclerView", "you should use StepOSRecyclerView.Adapter！！！ Otherwise, it may cause problems");
        }
        if (adapter != null) {
            ArrayList arrayList = this.f6542k0;
            int size = arrayList.size();
            ArrayList arrayList2 = this.f6543l0;
            if (size > 0 || arrayList2.size() > 0) {
                if (!(adapter instanceof N)) {
                    adapter = new N(adapter);
                }
                N n = (N) adapter;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    SparseArrayCompat sparseArrayCompat = n.f6474a;
                    int i = N.e;
                    N.e = i + 1;
                    sparseArrayCompat.put(i, null);
                }
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    if (it2.next() != null) {
                        throw new ClassCastException();
                    }
                    SparseArrayCompat sparseArrayCompat2 = n.b;
                    int i6 = N.f;
                    N.f = i6 + 1;
                    sparseArrayCompat2.put(i6, null);
                }
            }
        }
        super.setAdapter(adapter);
        if (adapter != null) {
            boolean zHasStableIds = getAdapter().hasStableIds();
            if (this.b != 0 && zHasStableIds && this.h == null) {
                this.h = new LongSparseArray();
            }
        }
        f();
    }

    public void setBaseDuration(int i) {
        r0 r0Var = this.f6533c0;
        if (r0Var != null) {
            r0Var.c = i;
        }
    }

    public void setBottomOverScrollEnable(boolean z10) {
        this.f6544m0.l = z10;
    }

    public void setCheckBoxIsAnimation(boolean z10) {
        if (this.f6518G != z10) {
            this.f6518G = z10;
        }
    }

    public void setChoiceMode(int i) {
        this.b = i;
        ActionMode actionMode = this.c;
        if (actionMode != null) {
            actionMode.finish();
            this.c = null;
        }
        if (this.b != 0) {
            if (this.f == null) {
                this.f = new SparseBooleanArray(0);
            }
            RecyclerView.Adapter adapter = getAdapter();
            if (this.h == null && adapter != null && adapter.hasStableIds()) {
                this.h = new LongSparseArray(0);
            }
            if (this.b == 4) {
                f();
                setLongClickable(true);
            }
        }
    }

    public void setDrawSelectorOnTop(boolean z10) {
        this.f6519L = z10;
    }

    public void setEnableDragSelection(boolean z10) {
        this.o = z10;
    }

    public void setEnableHoldPress(boolean z10) {
        this.f6528U = z10;
    }

    public void setEnableParallax(boolean z10) {
        if (z10) {
            if (this.f6533c0 == null) {
                this.f6533c0 = new r0(this);
            }
            if (this.f6535e0 == null) {
                this.f6535e0 = new HashSet();
            }
        }
        this.f6530W = z10;
    }

    public void setEndOverScrollEnable(boolean z10) {
        this.f6544m0.n = z10;
    }

    public void setItenFilter(InterfaceC1992h0 interfaceC1992h0) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(@Nullable RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        Xa.e eVar = this.f6544m0;
        if (eVar != null && layoutManager != null) {
            eVar.f1551t = layoutManager.canScrollVertically() ? 1 : 0;
        }
        this.f6541j0 = (layoutManager instanceof GridLayoutManager) || (layoutManager instanceof StaggeredGridLayoutManager);
    }

    public void setMultiChoiceListener(l0 l0Var) {
    }

    public void setMultiChoiceModeListener(m0 m0Var) {
        if (this.d == null) {
            this.d = new MultiChoiceModeWrapper();
        }
        this.d.f6558a = m0Var;
    }

    public void setOnItemClickListener(o0 o0Var) {
    }

    public void setOnItemLongClickListener(p0 p0Var) {
        if (isLongClickable()) {
            return;
        }
        setLongClickable(true);
    }

    public void setOverScrollEnable(boolean z10) {
        this.f6546o0 = z10;
        this.f6544m0.f1547j = z10;
    }

    public void setParallaxAnimationListener(q0 q0Var) {
    }

    public void setPinnedHeaderDecoration(Wa.a aVar) {
    }

    public void setPressStateDuration(int i) {
        this.s0 = i;
    }

    @Deprecated
    public void setRequestLayoutWhenSwitchActionMode(boolean z10) {
        this.g = z10;
    }

    public void setScrollSensitivity(int i) {
    }

    public void setScrollUpByItemCoveredInMultiChoiceEnable(boolean z10) {
        this.f6545n0 = z10;
    }

    public void setSelector(int i) {
        setSelector(getResources().getDrawable(i));
    }

    public void setShouldRequestDisallowInterceptTouchEventWhenOverScroll(boolean z10) {
        this.f6551r0 = z10;
    }

    public void setSmoothBackInterpolator(TimeInterpolator timeInterpolator) {
        r0 r0Var;
        if (timeInterpolator == null || (r0Var = this.f6533c0) == null) {
            return;
        }
        r0Var.b = timeInterpolator;
    }

    public void setStartOverScrollEnable(boolean z10) {
        this.f6544m0.m = z10;
    }

    public void setTopOverScrollEnable(boolean z10) {
        this.f6544m0.k = z10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void swapAdapter(RecyclerView.Adapter adapter, boolean z10) {
        ArrayList arrayList = this.f6542k0;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f6543l0;
        if (size > 0 || arrayList2.size() > 0) {
            if (!(adapter instanceof N)) {
                adapter = new N(adapter);
            }
            N n = (N) adapter;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next() != null) {
                    throw new ClassCastException();
                }
                SparseArrayCompat sparseArrayCompat = n.f6474a;
                int i = N.e;
                N.e = i + 1;
                sparseArrayCompat.put(i, null);
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                if (it2.next() != null) {
                    throw new ClassCastException();
                }
                SparseArrayCompat sparseArrayCompat2 = n.b;
                int i6 = N.f;
                N.f = i6 + 1;
                sparseArrayCompat2.put(i6, null);
            }
        }
        super.swapAdapter(adapter, z10);
        if (adapter != null) {
            boolean zHasStableIds = getAdapter().hasStableIds();
            if (this.b != 0 && zHasStableIds && this.h == null) {
                this.h = new LongSparseArray();
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
    public final void t(int i, int i6) {
        boolean zIsEnabled;
        boolean zIsSelectable;
        boolean z10;
        SparseBooleanArray sparseBooleanArray;
        RecyclerView.Adapter adapter = getAdapter();
        int firstPosition = getFirstPosition();
        for (int i10 = i == -1 ? i6 : i - 1; i10 >= i6; i10--) {
            boolean z11 = true;
            if (getAdapter() instanceof t0) {
                zIsEnabled = ((t0) getAdapter()).isEnabled(i10);
                zIsSelectable = ((t0) getAdapter()).isSelectable(i10);
            } else {
                zIsEnabled = true;
                zIsSelectable = true;
            }
            if (!zIsSelectable) {
                this.f6513A = -1;
            } else {
                if (i10 == this.f6513A) {
                    return;
                }
                if (getAdapter() == null || zIsEnabled) {
                    l(i10 - firstPosition);
                    adapter.getItemId(i10);
                    ?? r32 = (this.b == 0 || (sparseBooleanArray = this.f) == null) ? 0 : sparseBooleanArray.get(i10);
                    ?? r6 = this.f6537g0[i10];
                    ?? r72 = r6[0];
                    if (r72 == 0) {
                        r6[1] = r32;
                    }
                    int i11 = r72 + 1;
                    r6[0] = i11;
                    int i12 = this.f6536f0;
                    if (i12 == -1) {
                        boolean z12 = this.f6539i0 ? r32 : r32 ^ 1;
                        this.f6536f0 = z12 ? 1 : 0;
                        r6[1] = z12 ? 1 : 0;
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
                        this.f6549q0.a(this);
                    }
                    this.y = i10;
                    this.f6557z = -1;
                    this.f6513A = -1;
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
            if (viewL != 0 && this.b != 0 && (sparseBooleanArray = this.f) != null) {
                boolean z10 = sparseBooleanArray.get(iM);
                if (viewL instanceof Checkable) {
                    ((Checkable) viewL).setChecked(z10);
                } else if (getContext().getApplicationInfo().targetSdkVersion >= 11) {
                    int i6 = this.b;
                    if ((i6 == 4 || i6 == 5) && (callbackFindViewById = viewL.findViewById(android.R.id.checkbox)) != null && (callbackFindViewById instanceof Checkable)) {
                        ((Checkable) callbackFindViewById).setChecked(this.c != null);
                    }
                    viewL.setActivated(z10);
                }
            }
        }
    }

    public final void v() {
        if (this.f6520M != null) {
            if ((!isFocused() || isInTouchMode()) && !isPressed()) {
                this.f6520M.setState(StateSet.NOTHING);
            } else {
                this.f6520M.setState(getDrawableState());
            }
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return this.f6520M == drawable || super.verifyDrawable(drawable);
    }

    public void setEnableDragSelection(n0 n0Var) {
        setEnableDragSelection(true);
    }

    public void setSelector(Drawable drawable) {
        Drawable drawable2 = this.f6520M;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f6520M);
        }
        this.f6520M = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        this.f6523P = rect.left;
        this.f6524Q = rect.top;
        this.f6525R = rect.right;
        this.f6526S = rect.bottom;
        drawable.setCallback(this);
        v();
    }
}
