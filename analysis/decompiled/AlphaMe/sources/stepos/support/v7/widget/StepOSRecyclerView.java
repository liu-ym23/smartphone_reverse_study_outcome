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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.room.AbstractC0351g;
import com.stepos.alphame.R;
import com.stepos.common.animator.StepOSPressAnimationDrawable;
import java.lang.Thread;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import o2.C0808a;

/* loaded from: classes2.dex */
public class StepOSRecyclerView extends RecyclerView {

    /* renamed from: C0, reason: collision with root package name */
    public static boolean f14911C0 = false;

    /* renamed from: A, reason: collision with root package name */
    public int f14912A;

    /* renamed from: A0, reason: collision with root package name */
    public final boolean f14913A0;

    /* renamed from: B, reason: collision with root package name */
    public int f14914B;

    /* renamed from: B0, reason: collision with root package name */
    public boolean f14915B0;

    /* renamed from: C, reason: collision with root package name */
    public k0 f14916C;

    /* renamed from: D, reason: collision with root package name */
    public boolean f14917D;

    /* renamed from: E, reason: collision with root package name */
    public final int f14918E;

    /* renamed from: F, reason: collision with root package name */
    public android.support.v4.os.a f14919F;

    /* renamed from: G, reason: collision with root package name */
    public boolean f14920G;

    /* renamed from: H, reason: collision with root package name */
    public boolean f14921H;

    /* renamed from: I, reason: collision with root package name */
    public Drawable f14922I;

    /* renamed from: J, reason: collision with root package name */
    public final Rect f14923J;

    /* renamed from: K, reason: collision with root package name */
    public int f14924K;

    /* renamed from: L, reason: collision with root package name */
    public int f14925L;

    /* renamed from: M, reason: collision with root package name */
    public int f14926M;

    /* renamed from: N, reason: collision with root package name */
    public int f14927N;

    /* renamed from: O, reason: collision with root package name */
    public int f14928O;

    /* renamed from: P, reason: collision with root package name */
    public C0808a f14929P;

    /* renamed from: Q, reason: collision with root package name */
    public boolean f14930Q;

    /* renamed from: R, reason: collision with root package name */
    public boolean f14931R;

    /* renamed from: S, reason: collision with root package name */
    public boolean f14932S;
    public float T;

    /* renamed from: U, reason: collision with root package name */
    public float f14933U;

    /* renamed from: V, reason: collision with root package name */
    public j0 f14934V;

    /* renamed from: W, reason: collision with root package name */
    public float f14935W;

    /* renamed from: a, reason: collision with root package name */
    public int f14936a;

    /* renamed from: b, reason: collision with root package name */
    public int f14937b;

    /* renamed from: c, reason: collision with root package name */
    public ActionMode f14938c;

    /* renamed from: d, reason: collision with root package name */
    public MultiChoiceModeWrapper f14939d;

    /* renamed from: e, reason: collision with root package name */
    public int f14940e;

    /* renamed from: f, reason: collision with root package name */
    public SparseBooleanArray f14941f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f14942g;

    /* renamed from: h, reason: collision with root package name */
    public q.i f14943h;

    /* renamed from: i, reason: collision with root package name */
    public final a0 f14944i;

    /* renamed from: j, reason: collision with root package name */
    public Runnable f14945j;

    /* renamed from: k, reason: collision with root package name */
    public Rect f14946k;

    /* renamed from: k0, reason: collision with root package name */
    public HashSet f14947k0;

    /* renamed from: l, reason: collision with root package name */
    public final int f14948l;

    /* renamed from: l0, reason: collision with root package name */
    public final boolean f14949l0;

    /* renamed from: m, reason: collision with root package name */
    public int f14950m;

    /* renamed from: m0, reason: collision with root package name */
    public int f14951m0;

    /* renamed from: n, reason: collision with root package name */
    public boolean f14952n;

    /* renamed from: n0, reason: collision with root package name */
    public int[][] f14953n0;

    /* renamed from: o, reason: collision with root package name */
    public boolean f14954o;

    /* renamed from: o0, reason: collision with root package name */
    public int f14955o0;

    /* renamed from: p, reason: collision with root package name */
    public boolean f14956p;

    /* renamed from: p0, reason: collision with root package name */
    public boolean f14957p0;

    /* renamed from: q, reason: collision with root package name */
    public int f14958q;

    /* renamed from: q0, reason: collision with root package name */
    public boolean f14959q0;

    /* renamed from: r, reason: collision with root package name */
    public int f14960r;

    /* renamed from: r0, reason: collision with root package name */
    public final ArrayList f14961r0;

    /* renamed from: s, reason: collision with root package name */
    public int f14962s;

    /* renamed from: s0, reason: collision with root package name */
    public final ArrayList f14963s0;

    /* renamed from: t, reason: collision with root package name */
    public int f14964t;

    /* renamed from: t0, reason: collision with root package name */
    public final N3.d f14965t0;

    /* renamed from: u, reason: collision with root package name */
    public int f14966u;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f14967u0;

    /* renamed from: v, reason: collision with root package name */
    public int f14968v;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f14969v0;

    /* renamed from: w, reason: collision with root package name */
    public boolean f14970w;

    /* renamed from: w0, reason: collision with root package name */
    public boolean f14971w0;

    /* renamed from: x, reason: collision with root package name */
    public int f14972x;

    /* renamed from: x0, reason: collision with root package name */
    public final E f14973x0;

    /* renamed from: y, reason: collision with root package name */
    public int f14974y;

    /* renamed from: y0, reason: collision with root package name */
    public boolean f14975y0;

    /* renamed from: z, reason: collision with root package name */
    public int f14976z;

    /* renamed from: z0, reason: collision with root package name */
    public int f14977z0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ImmersiveType {
        public static final int IMMERSIVE_ALONE = 3;
        public static final int IMMERSIVE_FOOT = 2;
        public static final int IMMERSIVE_FOOT_RELATED_SETTING = 7;
        public static final int IMMERSIVE_HEAD = 0;
        public static final int IMMERSIVE_HEAD_RELATED_SETTING = 5;
        public static final int IMMERSIVE_NORMAL = 1;
        public static final int IMMERSIVE_NORMAL_RELATED_SETTING = 6;
        public static final int IMMERSIVE_TITLE = 4;
    }

    public class MultiChoiceModeWrapper implements e0 {

        /* renamed from: a, reason: collision with root package name */
        public e0 f14978a;

        public MultiChoiceModeWrapper() {
        }

        public final void a(ActionMode actionMode, int i4, long j4, boolean z4) {
            ((MultiChoiceModeWrapper) this.f14978a).a(actionMode, i4, j4, z4);
            StepOSRecyclerView stepOSRecyclerView = StepOSRecyclerView.this;
            if (stepOSRecyclerView.getCheckedItemCount() == 0) {
                int i5 = stepOSRecyclerView.f14937b;
            }
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f14978a.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            if (!this.f14978a.onCreateActionMode(actionMode, menu)) {
                return false;
            }
            StepOSRecyclerView stepOSRecyclerView = StepOSRecyclerView.this;
            int i4 = stepOSRecyclerView.f14937b;
            if (i4 == 4 || i4 == 5) {
                stepOSRecyclerView.setLongClickable(true);
            } else {
                stepOSRecyclerView.setLongClickable(false);
            }
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode actionMode) throws NoSuchFieldException, SecurityException {
            StepOSRecyclerView stepOSRecyclerView = StepOSRecyclerView.this;
            if (stepOSRecyclerView.f14969v0) {
                stepOSRecyclerView.f14965t0.f1506j = true;
            }
            this.f14978a.onDestroyActionMode(actionMode);
            stepOSRecyclerView.f14938c = null;
            stepOSRecyclerView.f14971w0 = true;
            stepOSRecyclerView.g();
            stepOSRecyclerView.x();
            stepOSRecyclerView.setLongClickable(true);
            try {
                Field declaredField = RecyclerView.class.getDeclaredField("mRecycler");
                declaredField.setAccessible(true);
                ((RecyclerView.Recycler) declaredField.get(stepOSRecyclerView)).clear();
            } catch (Exception e4) {
                Log.e("StepOSRecyclerViewHelper", "invokeRvRecyclerVClear ex" + e4.toString());
            }
            stepOSRecyclerView.getRecycledViewPool().clear();
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.f14978a.onPrepareActionMode(actionMode, menu);
        }
    }

    public static class StepOSSavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<StepOSSavedState> CREATOR = new m0();

        /* renamed from: a, reason: collision with root package name */
        public boolean f14980a;

        /* renamed from: b, reason: collision with root package name */
        public int f14981b;

        /* renamed from: c, reason: collision with root package name */
        public SparseBooleanArray f14982c;

        /* renamed from: d, reason: collision with root package name */
        public q.i f14983d;

        public final String toString() {
            return "StepOSRecyclerView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " checkState=" + this.f14982c + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeByte(this.f14980a ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f14981b);
            parcel.writeSparseBooleanArray(this.f14982c);
            q.i iVar = this.f14983d;
            int iG = iVar != null ? iVar.g() : 0;
            parcel.writeInt(iG);
            for (int i5 = 0; i5 < iG; i5++) {
                parcel.writeLong(iVar.e(i5));
                parcel.writeInt(((Integer) iVar.h(i5)).intValue());
            }
        }
    }

    public StepOSRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x013a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(stepos.support.v7.widget.StepOSRecyclerView r13, android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 453
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.StepOSRecyclerView.a(stepos.support.v7.widget.StepOSRecyclerView, android.view.MotionEvent):boolean");
    }

    public static void b(StepOSRecyclerView stepOSRecyclerView) {
        stepOSRecyclerView.f14968v = -1;
        stepOSRecyclerView.f14972x = -1;
        stepOSRecyclerView.f14956p = false;
        stepOSRecyclerView.f14970w = false;
        stepOSRecyclerView.f14914B = -1;
        stepOSRecyclerView.f14976z = -1;
        stepOSRecyclerView.f14974y = -1;
        stepOSRecyclerView.f14966u = -1;
        stepOSRecyclerView.f14917D = false;
        k0 k0Var = stepOSRecyclerView.f14916C;
        if (k0Var != null) {
            k0Var.f15098b = false;
            k0Var.f15099c.removeCallbacks(k0Var);
        }
    }

    public static void d(StepOSRecyclerView stepOSRecyclerView, int i4, boolean z4) {
        if (stepOSRecyclerView.getChildCountExt() == 0) {
            return;
        }
        if (z4) {
            stepOSRecyclerView.offsetChildrenVertical(i4);
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

    public static void setAvoidNotifyItemRangeChanged(boolean z4) {
        f14911C0 = z4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        if (!(itemDecoration instanceof Y)) {
            Log.i("StepOSRecyclerView", "you should use StepOSRecyclerView.ItemDecoration!! Otherwise, it may cause problems");
        }
        super.addItemDecoration(itemDecoration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        if (!this.f14921H && !this.f14915B0) {
            Rect rect = this.f14923J;
            if (!rect.isEmpty()) {
                Drawable drawable = this.f14922I;
                drawable.setBounds(rect);
                drawable.draw(canvas);
            }
        }
        super.dispatchDraw(canvas);
        int itemDecorationCount = getItemDecorationCount();
        for (int i4 = 0; i4 < itemDecorationCount; i4++) {
            getItemDecorationAt(i4);
        }
        for (int i5 = 0; i5 < itemDecorationCount; i5++) {
            getItemDecorationAt(i5);
        }
        int itemDecorationCount2 = getItemDecorationCount();
        for (int i6 = 0; i6 < itemDecorationCount2; i6++) {
            getItemDecorationAt(i6);
        }
        int itemDecorationCount3 = getItemDecorationCount();
        for (int i7 = 0; i7 < itemDecorationCount3; i7++) {
            getItemDecorationAt(i7);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSetPressed(boolean z4) {
    }

    public boolean dispatchStatusBarTap() {
        View childAt;
        if (getItemCount() == 0 || this.f14965t0.j()) {
            return false;
        }
        int firstPosition = getFirstPosition();
        if ((firstPosition == 0 && (childAt = getChildAt(0)) != null && childAt.getTop() >= getPaddingTop()) || getItemCount() == Integer.MAX_VALUE) {
            return false;
        }
        android.support.v4.os.a aVar = this.f14919F;
        if (aVar != null) {
            StepOSRecyclerView stepOSRecyclerView = (StepOSRecyclerView) aVar.f2371d;
            stepOSRecyclerView.f14936a = -1;
            stepOSRecyclerView.removeCallbacks(aVar);
            n0.b(stepOSRecyclerView);
            ((OverScroller) aVar.f2370c).abortAnimation();
            this.f14919F = null;
        }
        if (firstPosition > getChildCount() * 2) {
            scrollToPosition(getChildCount() * 2);
        }
        smoothScrollToPosition(0);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0174  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchTouchEvent(android.view.MotionEvent r10) {
        /*
            Method dump skipped, instructions count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.StepOSRecyclerView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        y();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final boolean fling(int i4, int i5) {
        this.f14965t0.f(i4, i5);
        return super.fling(i4, i5);
    }

    public final void g() {
        SparseBooleanArray sparseBooleanArray = this.f14941f;
        if (sparseBooleanArray != null) {
            sparseBooleanArray.clear();
        }
        q.i iVar = this.f14943h;
        if (iVar != null) {
            iVar.a();
        }
        this.f14940e = 0;
    }

    public int getCheckedItemCount() {
        return this.f14940e;
    }

    public long[] getCheckedItemIds() {
        if (this.f14937b == 0 || this.f14943h == null || getAdapter() == null) {
            return new long[0];
        }
        q.i iVar = this.f14943h;
        int iG = iVar.g();
        long[] jArr = new long[iG];
        for (int i4 = 0; i4 < iG; i4++) {
            jArr[i4] = iVar.e(i4);
        }
        return jArr;
    }

    public SparseBooleanArray getCheckedItemPositions() {
        if (this.f14937b != 0) {
            return this.f14941f;
        }
        return null;
    }

    public int getChoiceMode() {
        return this.f14937b;
    }

    public int getCount() {
        return getAdapter().getItemCount();
    }

    public int getFirstPosition() {
        View viewM = m(0);
        if (viewM == null) {
            return -1;
        }
        return n(viewM);
    }

    public int getFooterViewsCount() {
        if (getAdapter() == null || !(getAdapter() instanceof I)) {
            return 0;
        }
        return ((I) getAdapter()).f14828b.f13973c;
    }

    public int getHeaderViewsCount() {
        if (getAdapter() == null || !(getAdapter() instanceof I)) {
            return 0;
        }
        return ((I) getAdapter()).f14827a.f13973c;
    }

    public int getLastPosition() {
        View viewM = m(getChildCountExt() - 1);
        if (viewM == null) {
            return -1;
        }
        return n(viewM);
    }

    public final g0 getOnItemClickListener() {
        return null;
    }

    public final h0 getOnItemLongClickListener() {
        return null;
    }

    public N3.d getSpringAnimationHelper() {
        return this.f14965t0;
    }

    public HashSet getViewHoldSet() {
        return this.f14947k0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x00bc, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v9 */
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
            Method dump skipped, instructions count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.StepOSRecyclerView.h(int, int):void");
    }

    public final void i(boolean z4) {
        if (this.f14946k == null) {
            Rect rect = new Rect();
            this.f14946k = rect;
            rect.setEmpty();
        }
        int i4 = this.f14937b;
        if (i4 != 4 && i4 != 5) {
            this.f14946k.setEmpty();
            return;
        }
        if (this.f14946k.isEmpty() || z4) {
            if (getLayoutDirection() == 1) {
                this.f14946k.left = getPaddingLeft();
                Rect rect2 = this.f14946k;
                rect2.right = rect2.left + this.f14950m;
                rect2.top = getPaddingTop();
                this.f14946k.bottom = getHeight() - getPaddingBottom();
                return;
            }
            this.f14946k.right = getWidth() - getPaddingRight();
            Rect rect3 = this.f14946k;
            rect3.left = rect3.right - this.f14950m;
            rect3.top = getPaddingTop();
            this.f14946k.bottom = getHeight() - getPaddingBottom();
        }
    }

    public final int j(boolean z4) {
        int childCountExt = getChildCountExt();
        int firstPosition = getFirstPosition();
        if (z4) {
            for (int i4 = 0; i4 < childCountExt; i4++) {
                View viewM = m(i4);
                int iO = o(viewM);
                RecyclerView.LayoutManager layoutManager = getLayoutManager();
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewM.getLayoutParams();
                if (iO - (((layoutManager.getDecoratedMeasuredHeight(viewM) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) / 2) > getPaddingTop()) {
                    return firstPosition + i4;
                }
            }
            return -1;
        }
        for (int i5 = childCountExt - 1; i5 >= 0; i5--) {
            View viewM2 = m(i5);
            int iP = p(viewM2);
            RecyclerView.LayoutManager layoutManager2 = getLayoutManager();
            RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) viewM2.getLayoutParams();
            if ((((layoutManager2.getDecoratedMeasuredHeight(viewM2) + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin) / 2) + iP < getHeight() - getPaddingBottom()) {
                return firstPosition + i5;
            }
        }
        return -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f14922I;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public final View k(int i4, int i5) {
        for (int childCount = getLayoutManager().getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getLayoutManager().getChildAt(childCount);
            float translationY = childAt.getTranslationY();
            if (this.f14959q0) {
                float translationX = childAt.getTranslationX();
                float f4 = i4;
                if (f4 >= (getLayoutManager().getDecoratedLeft(childAt) - ((RecyclerView.LayoutParams) childAt.getLayoutParams()).getMarginStart()) + translationX) {
                    RecyclerView.LayoutManager layoutManager = getLayoutManager();
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                    if (f4 <= layoutParams.getMarginEnd() + layoutManager.getDecoratedRight(childAt) + translationX) {
                        float f5 = i5;
                        if (f5 >= p(childAt) + translationY && f5 <= o(childAt) + translationY) {
                            return childAt;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            } else {
                float f6 = i5;
                if (f6 >= p(childAt) + translationY && f6 <= o(childAt) + translationY) {
                    return childAt;
                }
            }
        }
        return null;
    }

    public final View m(int i4) {
        return getLayoutManager().getChildAt(i4);
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

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
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
            N3.d r1 = r4.f14965t0
            if (r5 == 0) goto L3f
            boolean r2 = r1.f1506j
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
            r1.f1502f = r3
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
            boolean r2 = r4.f14975y0
            if (r2 == 0) goto L60
            r1.requestDisallowInterceptTouchEvent(r0)
        L60:
            boolean r4 = super.onInterceptTouchEvent(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.StepOSRecyclerView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) throws NoSuchFieldException, SecurityException {
        RecyclerView.State state;
        C0808a c0808a;
        int i8;
        ActionMode actionMode;
        int i9;
        MultiChoiceModeWrapper multiChoiceModeWrapper;
        super.onLayout(z4, i4, i5, i6, i7);
        if (this.f14937b == 5 && !this.f14971w0 && this.f14945j == null) {
            J3.a aVar = new J3.a(3, this);
            this.f14945j = aVar;
            post(aVar);
        }
        int i10 = 1;
        try {
            Field declaredField = RecyclerView.class.getDeclaredField("mState");
            declaredField.setAccessible(true);
            state = (RecyclerView.State) declaredField.get(this);
        } catch (Exception e4) {
            Log.e("StepOSRecyclerViewHelper", "getStateField ex" + e4.toString());
            state = null;
        }
        try {
            Field declaredField2 = RecyclerView.State.class.getDeclaredField("mLayoutStep");
            declaredField2.setAccessible(true);
            if (((Integer) declaredField2.get(state)).intValue() == 1 && state.didStructureChange()) {
                RecyclerView.Adapter adapter = getAdapter();
                if (this.f14937b != 0 && adapter != null && adapter.hasStableIds()) {
                    int itemCount = getItemCount();
                    this.f14941f.clear();
                    int i11 = 0;
                    boolean z5 = false;
                    while (i11 < this.f14943h.g()) {
                        long jE = this.f14943h.e(i11);
                        int iIntValue = ((Integer) this.f14943h.h(i11)).intValue();
                        if (jE != adapter.getItemId(iIntValue)) {
                            int iMax = Math.max(0, iIntValue - 20);
                            int iMin = Math.min(iIntValue + 20, itemCount);
                            boolean z6 = i10;
                            while (true) {
                                if (iMax >= iMin) {
                                    this.f14943h.c(jE);
                                    i11--;
                                    this.f14940e--;
                                    ActionMode actionMode2 = this.f14938c;
                                    if (actionMode2 != null && (multiChoiceModeWrapper = this.f14939d) != null) {
                                        multiChoiceModeWrapper.a(actionMode2, iIntValue, jE, false);
                                    }
                                    z5 = true;
                                } else {
                                    if (jE == adapter.getItemId(iMax)) {
                                        this.f14941f.put(iMax, z6);
                                        q.i iVar = this.f14943h;
                                        Integer numValueOf = Integer.valueOf(iMax);
                                        if (i11 >= 0) {
                                            int i12 = iVar.f13960d;
                                            if (i11 < i12) {
                                                if (iVar.f13957a) {
                                                    long[] jArr = iVar.f13958b;
                                                    Object[] objArr = iVar.f13959c;
                                                    int i13 = 0;
                                                    for (int i14 = 0; i14 < i12; i14++) {
                                                        Object obj = objArr[i14];
                                                        if (obj != q.j.f13961a) {
                                                            if (i14 != i13) {
                                                                jArr[i13] = jArr[i14];
                                                                objArr[i13] = obj;
                                                                objArr[i14] = null;
                                                            }
                                                            i13++;
                                                        }
                                                    }
                                                    iVar.f13957a = false;
                                                    iVar.f13960d = i13;
                                                }
                                                iVar.f13959c[i11] = numValueOf;
                                            }
                                        } else {
                                            iVar.getClass();
                                        }
                                        throw new IllegalArgumentException(AbstractC0351g.m("Expected index to be within 0..size()-1, but was ", i11).toString());
                                    }
                                    iMax++;
                                    z6 = 1;
                                }
                            }
                            i9 = 1;
                        } else {
                            i9 = 1;
                            this.f14941f.put(iIntValue, true);
                        }
                        i11 += i9;
                        i10 = i9;
                    }
                    if (z5 && (actionMode = this.f14938c) != null) {
                        actionMode.invalidate();
                    }
                }
                RecyclerView.Adapter adapter2 = getAdapter();
                if (adapter2.hasStableIds() && (c0808a = this.f14929P) != null && (i8 = c0808a.f13788a) != -1) {
                    long j4 = c0808a.f13789b;
                    if (j4 != adapter2.getItemId(i8)) {
                        View view = (View) this.f14929P.f13790c;
                        if (view != null) {
                            view.setHovered(false);
                            Drawable background = ((View) this.f14929P.f13790c).getBackground();
                            if (background != null) {
                                background.jumpToCurrentState();
                            }
                        }
                        C0808a c0808a2 = this.f14929P;
                        c0808a2.f13790c = null;
                        c0808a2.f13788a = -1;
                        int iMax2 = Math.max(0, i8 - 20);
                        int iMin2 = Math.min(i8 + 20, adapter2.getItemCount());
                        while (true) {
                            if (iMax2 >= iMin2) {
                                break;
                            }
                            if (j4 == adapter2.getItemId(iMax2)) {
                                RecyclerView.ViewHolder viewHolderFindViewHolderForItemId = findViewHolderForItemId(j4);
                                if (viewHolderFindViewHolderForItemId != null) {
                                    C0808a c0808a3 = this.f14929P;
                                    c0808a3.f13788a = iMax2;
                                    c0808a3.f13790c = viewHolderFindViewHolderForItemId.itemView;
                                }
                            } else {
                                iMax2++;
                            }
                        }
                    }
                }
                setPressed(false);
                Drawable drawable = this.f14922I;
                if (drawable != null) {
                    drawable.jumpToCurrentState();
                }
            }
        } catch (Exception e5) {
            Log.e("StepOSRecyclerViewHelper", "getRvStateStepField ex" + e5.toString());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onMeasure(int i4, int i5) throws IllegalAccessException, Resources.NotFoundException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Drawable drawable;
        if (this.f14922I == null) {
            Log.i("StepOSRecyclerView", "useDefaultSelector,  try to get f10 res");
            try {
                drawable = getResources().getDrawable(getResources().getIdentifier("stepos_recyclerview_selector_f10", "drawable", getContext().getPackageName()));
            } catch (Exception e4) {
                Log.i("StepOSRecyclerView", "useDefaultSelector,  get f10 res fail , may be app code compression: " + e4);
                drawable = null;
            }
            if (drawable == null) {
                Log.i("StepOSRecyclerView", "useDefaultSelector, get f10 res fail, and try to reflect StepOSPressAnimationDrawable");
                try {
                    Interpolator interpolator = StepOSPressAnimationDrawable.f11238C;
                    Object objNewInstance = StepOSPressAnimationDrawable.class.getConstructor(new Class[0]).newInstance(new Object[0]);
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
                } catch (Exception e5) {
                    Log.i("StepOSRecyclerView", "useDefaultSelector,  try to reflect StepOSPressAnimationDrawable fail " + e5);
                }
            }
            if (drawable == null) {
                Log.i("StepOSRecyclerView", "useDefaultSelector,  try to reflect StepOSPressAnimationDrawable fail , and to get old res");
                drawable = getResources().getDrawable(R.drawable.stepos_recyclerview_selector);
            }
            setSelector(drawable);
        }
        super.onMeasure(i4, i5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void onScrolled(int i4, int i5) {
        if (this.f14932S) {
            boolean z4 = this.f14934V.f15094g;
        }
        super.onScrolled(i4, i5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        i(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:287:0x051b  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0540  */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r27) {
        /*
            Method dump skipped, instructions count: 1350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.StepOSRecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z4) {
        C0808a c0808a;
        super.onWindowFocusChanged(z4);
        if (z4 && this.f14930Q && (c0808a = this.f14929P) != null) {
            Object obj = c0808a.f13790c;
            if (((View) obj) != null) {
                if (this.f14931R) {
                    ((View) obj).setHovered(true);
                    this.f14931R = false;
                }
                ((View) this.f14929P.f13790c).setHovered(false);
                C0808a c0808a2 = this.f14929P;
                c0808a2.f13790c = null;
                c0808a2.f13789b = -1L;
                c0808a2.f13788a = -1;
            }
        }
    }

    public final int p(View view) {
        return getLayoutManager().getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
    }

    public final Drawable q(String str) {
        return getResources().getDrawable(getResources().getIdentifier(str, "drawable", getContext().getPackageName()));
    }

    public final boolean r(int i4, int i5) {
        View viewK = k(i4, i5);
        if (viewK == null) {
            return false;
        }
        this.f14966u = n(viewK);
        this.f14962s = p(viewK);
        this.f14964t = o(viewK);
        this.f14958q = getLayoutManager().getDecoratedLeft(viewK) - ((RecyclerView.LayoutParams) viewK.getLayoutParams()).getMarginStart();
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewK.getLayoutParams();
        this.f14960r = layoutParams.getMarginEnd() + layoutManager.getDecoratedRight(viewK);
        return true;
    }

    public final void s(int i4, View view) {
        boolean z4 = i4 != this.f14924K;
        if (i4 != -1) {
            this.f14924K = i4;
        }
        int left = view.getLeft();
        int top = view.getTop();
        int right = view.getRight();
        int bottom = view.getBottom();
        Rect rect = this.f14923J;
        rect.set(left, top, right, bottom);
        rect.left -= this.f14925L;
        rect.top -= this.f14926M;
        rect.right += this.f14927N;
        rect.bottom += this.f14928O;
        Drawable drawable = this.f14922I;
        if (drawable != null) {
            drawable.setBounds(rect);
            if (z4) {
                if (getVisibility() == 0) {
                    drawable.setVisible(true, false);
                }
                y();
            }
        }
        refreshDrawableState();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        if (!(adapter instanceof l0)) {
            Log.i("StepOSRecyclerView", "you should use StepOSRecyclerView.Adapter！！！ Otherwise, it may cause problems");
        }
        if (adapter != null) {
            ArrayList arrayList = this.f14961r0;
            int size = arrayList.size();
            ArrayList arrayList2 = this.f14963s0;
            if (size > 0 || arrayList2.size() > 0) {
                if (!(adapter instanceof I)) {
                    adapter = new I(adapter);
                }
                I i4 = (I) adapter;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    B0.g.y(it.next());
                    int i5 = I.f14825e;
                    I.f14825e = i5 + 1;
                    i4.f14827a.d(i5, null);
                }
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    B0.g.y(it2.next());
                    int i6 = I.f14826f;
                    I.f14826f = i6 + 1;
                    i4.f14828b.d(i6, null);
                }
            }
        }
        super.setAdapter(adapter);
        if (adapter != null) {
            boolean zHasStableIds = getAdapter().hasStableIds();
            if (this.f14937b != 0 && zHasStableIds && this.f14943h == null) {
                this.f14943h = new q.i();
            }
        }
        g();
    }

    public void setBaseDuration(int i4) {
        j0 j0Var = this.f14934V;
        if (j0Var != null) {
            j0Var.f15090c = i4;
        }
    }

    public void setBottomOverScrollEnable(boolean z4) {
        this.f14965t0.f1508l = z4;
    }

    public void setCheckBoxIsAnimation(boolean z4) {
        if (this.f14920G != z4) {
            this.f14920G = z4;
        }
    }

    public void setChoiceMode(int i4) {
        this.f14937b = i4;
        ActionMode actionMode = this.f14938c;
        if (actionMode != null) {
            actionMode.finish();
            this.f14938c = null;
        } else if (this.f14949l0) {
            throw null;
        }
        if (this.f14937b != 0) {
            if (this.f14941f == null) {
                this.f14941f = new SparseBooleanArray(0);
            }
            RecyclerView.Adapter adapter = getAdapter();
            if (this.f14943h == null && adapter != null && adapter.hasStableIds()) {
                this.f14943h = new q.i(0);
            }
            if (this.f14937b == 4) {
                g();
                setLongClickable(true);
            }
        }
    }

    public void setDrawSelectorOnTop(boolean z4) {
        this.f14921H = z4;
    }

    public void setEnableDragSelection(boolean z4) {
        this.f14954o = z4;
    }

    public void setEnableHoldPress(boolean z4) {
        this.f14930Q = z4;
    }

    public void setEnableParallax(boolean z4) {
        if (z4) {
            if (this.f14934V == null) {
                this.f14934V = new j0(this);
            }
            if (this.f14947k0 == null) {
                this.f14947k0 = new HashSet();
            }
        }
        this.f14932S = z4;
    }

    public void setEndOverScrollEnable(boolean z4) {
        this.f14965t0.f1510n = z4;
    }

    public void setItenFilter(Z z4) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(@Nullable RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        N3.d dVar = this.f14965t0;
        if (dVar != null && layoutManager != null) {
            dVar.f1516t = layoutManager.canScrollVertically() ? 1 : 0;
        }
        this.f14959q0 = (layoutManager instanceof GridLayoutManager) || (layoutManager instanceof StaggeredGridLayoutManager);
    }

    public void setMultiChoiceListener(d0 d0Var) {
    }

    public void setMultiChoiceModeListener(e0 e0Var) {
        if (this.f14939d == null) {
            this.f14939d = new MultiChoiceModeWrapper();
        }
        this.f14939d.f14978a = e0Var;
    }

    public void setOnItemClickListener(g0 g0Var) {
    }

    public void setOnItemLongClickListener(h0 h0Var) {
        if (isLongClickable()) {
            return;
        }
        setLongClickable(true);
    }

    public void setOverScrollEnable(boolean z4) {
        this.f14969v0 = z4;
        this.f14965t0.f1506j = z4;
    }

    public void setParallaxAnimationListener(i0 i0Var) {
    }

    public void setPinnedHeaderDecoration(M3.a aVar) {
    }

    public void setPressStateDuration(int i4) {
        this.f14977z0 = i4;
    }

    @Deprecated
    public void setRequestLayoutWhenSwitchActionMode(boolean z4) {
        this.f14942g = z4;
    }

    public void setScrollSensitivity(int i4) {
    }

    public void setScrollUpByItemCoveredInMultiChoiceEnable(boolean z4) {
        this.f14967u0 = z4;
    }

    public void setSelector(int i4) {
        setSelector(getResources().getDrawable(i4));
    }

    public void setShouldRequestDisallowInterceptTouchEventWhenOverScroll(boolean z4) {
        this.f14975y0 = z4;
    }

    public void setSmoothBackInterpolator(TimeInterpolator timeInterpolator) {
        j0 j0Var;
        if (timeInterpolator == null || (j0Var = this.f14934V) == null) {
            return;
        }
        j0Var.f15089b = timeInterpolator;
    }

    public void setStartOverScrollEnable(boolean z4) {
        this.f14965t0.f1509m = z4;
    }

    public void setTopOverScrollEnable(boolean z4) {
        this.f14965t0.f1507k = z4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void swapAdapter(RecyclerView.Adapter adapter, boolean z4) {
        ArrayList arrayList = this.f14961r0;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f14963s0;
        if (size > 0 || arrayList2.size() > 0) {
            if (!(adapter instanceof I)) {
                adapter = new I(adapter);
            }
            I i4 = (I) adapter;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                B0.g.y(it.next());
                i4.getClass();
                int i5 = I.f14825e;
                I.f14825e = i5 + 1;
                i4.f14827a.d(i5, null);
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                B0.g.y(it2.next());
                i4.getClass();
                int i6 = I.f14826f;
                I.f14826f = i6 + 1;
                i4.f14828b.d(i6, null);
            }
        }
        super.swapAdapter(adapter, z4);
        if (adapter != null) {
            boolean zHasStableIds = getAdapter().hasStableIds();
            if (this.f14937b != 0 && zHasStableIds && this.f14943h == null) {
                this.f14943h = new q.i();
            }
        }
        g();
    }

    public final void t(int i4, View view) {
        if (this.f14915B0) {
            if (i4 == 0) {
                view.setBackground(q("immersive_item_bkg_head"));
                return;
            }
            if (i4 == 1) {
                view.setBackground(q("immersive_item_bkg_middle"));
                return;
            }
            if (i4 == 2) {
                view.setBackground(q("immersive_item_bkg_foot"));
                return;
            }
            if (i4 == 3) {
                view.setBackground(q("immersive_item_bkg_alone"));
                return;
            }
            if (i4 == 5) {
                view.setBackground(q("immersive_item_bkg_head_related_setting"));
                return;
            }
            if (i4 == 6) {
                view.setBackground(q("immersive_item_bkg_middle_related_setting"));
            } else if (i4 == 7) {
                view.setBackground(q("immersive_item_bkg_foot_related_setting"));
            } else {
                view.setBackground(getContext().getDrawable(R.drawable.immmersive_item_bkg_title));
            }
        }
    }

    public final void u(int i4, boolean z4) {
        SparseBooleanArray sparseBooleanArray;
        if (this.f14937b == 0) {
            return;
        }
        RecyclerView.Adapter adapter = getAdapter();
        if (z4 && this.f14937b == 4 && this.f14938c == null) {
            MultiChoiceModeWrapper multiChoiceModeWrapper = this.f14939d;
            if (multiChoiceModeWrapper == null || multiChoiceModeWrapper.f14978a == null) {
                throw new IllegalStateException("RecyclerView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
            }
            this.f14938c = startActionMode(multiChoiceModeWrapper);
        }
        int i5 = this.f14937b;
        if (i5 == 4 || i5 == 5) {
            boolean z5 = this.f14941f.get(i4);
            this.f14941f.put(i4, z4);
            if (this.f14943h != null && adapter.hasStableIds()) {
                if (z4) {
                    this.f14943h.f(adapter.getItemId(i4), Integer.valueOf(i4));
                } else {
                    this.f14943h.c(adapter.getItemId(i4));
                }
            }
            if (z5 != z4) {
                if (z4) {
                    this.f14940e++;
                } else {
                    this.f14940e--;
                }
            }
            if (this.f14938c != null) {
                this.f14939d.a(this.f14938c, i4, adapter.getItemId(i4), z4);
            }
        } else {
            boolean z6 = this.f14943h != null && adapter.hasStableIds();
            if (z4 || (this.f14937b != 0 && (sparseBooleanArray = this.f14941f) != null && sparseBooleanArray.get(i4))) {
                this.f14941f.clear();
                if (z6) {
                    this.f14943h.a();
                }
            }
            if (z4) {
                this.f14941f.put(i4, true);
                if (z6) {
                    this.f14943h.f(adapter.getItemId(i4), Integer.valueOf(i4));
                }
                this.f14940e = 1;
            } else if (this.f14941f.size() == 0 || !this.f14941f.valueAt(0)) {
                this.f14940e = 0;
            }
        }
        x();
    }

    public final boolean v(int i4) {
        return i4 >= 0 && (i4 < getHeaderViewsCount() || i4 >= getItemCount() - getFooterViewsCount());
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return this.f14922I == drawable || super.verifyDrawable(drawable);
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
    public final void w(int i4, int i5) {
        boolean zIsEnabled;
        boolean zIsSelectable;
        boolean z4;
        SparseBooleanArray sparseBooleanArray;
        RecyclerView.Adapter adapter = getAdapter();
        int firstPosition = getFirstPosition();
        for (int i6 = i4 == -1 ? i5 : i4 - 1; i6 >= i5; i6--) {
            boolean z5 = true;
            if (getAdapter() instanceof l0) {
                zIsEnabled = ((l0) getAdapter()).isEnabled(i6);
                zIsSelectable = ((l0) getAdapter()).isSelectable(i6);
            } else {
                zIsEnabled = true;
                zIsSelectable = true;
            }
            if (!zIsSelectable) {
                this.f14912A = -1;
            } else {
                if (i6 == this.f14912A) {
                    return;
                }
                if (getAdapter() == null || zIsEnabled) {
                    m(i6 - firstPosition);
                    adapter.getItemId(i6);
                    ?? r32 = (this.f14937b == 0 || (sparseBooleanArray = this.f14941f) == null) ? 0 : sparseBooleanArray.get(i6);
                    ?? r6 = this.f14953n0[i6];
                    ?? r7 = r6[0];
                    if (r7 == 0) {
                        r6[1] = r32;
                    }
                    int i7 = r7 + 1;
                    r6[0] = i7;
                    int i8 = this.f14951m0;
                    if (i8 == -1) {
                        boolean z6 = this.f14957p0 ? r32 : r32 ^ 1;
                        this.f14951m0 = z6 ? 1 : 0;
                        r6[1] = z6 ? 1 : 0;
                        z4 = z6;
                    } else if (i7 % 2 == 0) {
                        z5 = false;
                        z4 = z5;
                    } else {
                        z5 = false;
                        z4 = z5;
                    }
                    if (z4 != r32) {
                        u(i6, z4);
                        this.f14973x0.a(this);
                    }
                    this.f14974y = i6;
                    this.f14976z = -1;
                    this.f14912A = -1;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x() {
        SparseBooleanArray sparseBooleanArray;
        KeyEvent.Callback callbackFindViewById;
        int childCountExt = getChildCountExt();
        for (int i4 = 0; i4 < childCountExt; i4++) {
            View viewM = m(i4);
            int iN = n(viewM);
            if (viewM != 0 && this.f14937b != 0 && (sparseBooleanArray = this.f14941f) != null) {
                boolean z4 = sparseBooleanArray.get(iN);
                if (viewM instanceof Checkable) {
                    ((Checkable) viewM).setChecked(z4);
                } else if (getContext().getApplicationInfo().targetSdkVersion >= 11) {
                    int i5 = this.f14937b;
                    if ((i5 == 4 || i5 == 5) && (callbackFindViewById = viewM.findViewById(android.R.id.checkbox)) != null && (callbackFindViewById instanceof Checkable)) {
                        ((Checkable) callbackFindViewById).setChecked(this.f14938c != null || this.f14949l0);
                    }
                    viewM.setActivated(z4);
                }
            }
        }
    }

    public final void y() {
        if (this.f14922I != null) {
            if ((!isFocused() || isInTouchMode()) && !isPressed()) {
                this.f14922I.setState(StateSet.NOTHING);
            } else {
                this.f14922I.setState(getDrawableState());
            }
        }
    }

    public StepOSRecyclerView(Context context, AttributeSet attributeSet, int i4) throws NoSuchFieldException, Resources.NotFoundException, SecurityException {
        super(context, attributeSet, 0);
        Math.tan(1.0471975824055166d);
        this.f14936a = -1;
        this.f14937b = 0;
        this.f14942g = false;
        Interpolator interpolator = null;
        this.f14945j = null;
        this.f14920G = true;
        this.f14921H = false;
        this.f14923J = new Rect();
        this.f14924K = -1;
        this.f14925L = 0;
        this.f14926M = 0;
        this.f14927N = 0;
        this.f14928O = 0;
        this.f14930Q = false;
        this.f14931R = false;
        this.f14932S = false;
        this.f14935W = Float.MAX_VALUE;
        this.f14949l0 = false;
        this.f14951m0 = -1;
        this.f14955o0 = -1;
        this.f14959q0 = false;
        this.f14961r0 = new ArrayList();
        this.f14963s0 = new ArrayList();
        this.f14967u0 = true;
        this.f14969v0 = true;
        this.f14971w0 = false;
        this.f14975y0 = false;
        this.f14977z0 = ViewConfiguration.getPressedStateDuration();
        this.f14913A0 = false;
        this.f14915B0 = false;
        Resources resources = getResources();
        this.f14952n = false;
        this.f14948l = resources.getDimensionPixelSize(R.dimen.stepos_list_check_width);
        this.f14918E = resources.getDimensionPixelSize(R.dimen.stepos_list_item_height);
        this.f14956p = false;
        this.f14958q = 0;
        this.f14960r = 0;
        this.f14962s = 0;
        this.f14964t = 0;
        this.f14966u = -1;
        this.f14968v = -1;
        this.f14972x = 0;
        this.f14916C = null;
        this.f14917D = false;
        this.f14912A = -1;
        this.f14974y = -1;
        this.f14976z = -1;
        getResources().getDimensionPixelSize(R.dimen.stepos_recyclerview_scrollbar_padding);
        this.f14944i = new a0(this, context, new c0(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, H3.a.f806a, 0, 0);
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
        } catch (Exception e4) {
            Log.e("StepOSRecyclerViewHelper", "getsQuinticInterpolator ex" + e4.toString());
        }
        N3.d dVar = new N3.d(context, this, new OverScroller(context, interpolator), -1);
        this.f14965t0 = dVar;
        dVar.f1511o = 0.99f;
        dVar.f1512p = 228.0f;
        dVar.f1500d = 0.5f;
        if (E.f14816b == null) {
            synchronized (E.class) {
                try {
                    if (E.f14816b == null) {
                        E.f14816b = new E("FeedbackHandlerThread");
                    }
                } finally {
                }
            }
        }
        E e5 = E.f14816b;
        e5.getClass();
        if (Thread.State.NEW == e5.getState()) {
            e5.start();
        }
        this.f14973x0 = E.f14816b;
        if (TextUtils.equals(Build.BRAND, "Sony")) {
            this.f14913A0 = true;
        }
    }

    public void setEnableDragSelection(f0 f0Var) {
        setEnableDragSelection(true);
    }

    public void setSelector(Drawable drawable) {
        Drawable drawable2 = this.f14922I;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f14922I);
        }
        this.f14922I = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        this.f14925L = rect.left;
        this.f14926M = rect.top;
        this.f14927N = rect.right;
        this.f14928O = rect.bottom;
        drawable.setCallback(this);
        y();
    }
}
