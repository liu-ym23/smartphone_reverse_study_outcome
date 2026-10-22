package com.obric.oui.orecyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import com.bytedance.librarian.LibrarianImpl;
import com.google.common.primitives.Ints;
import com.obric.capabilitykit.common.UiType;
import com.obric.oui.orecyclerview.R$attr;
import com.obric.oui.orecyclerview.R$dimen;
import com.obric.oui.orecyclerview.R$styleable;
import com.obric.oui.orecyclerview.base.OverScrollerAdapter;
import com.obric.oui.orecyclerview.base.VelocityTracker;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes4.dex */
public class RecyclerView extends ViewGroup implements ScrollingView, NestedScrollingChild2, NestedScrollingChild3 {
    public static boolean E0 = false;
    public static boolean F0 = false;
    public static final int[] G0 = null;
    public static final float H0 = 0.0f;
    public static final boolean I0 = false;
    public static final boolean J0 = false;
    public static final boolean K0 = false;
    public static final boolean L0 = false;
    public static final boolean M0 = false;
    public static final boolean N0 = false;
    public static final Class[] O0 = null;
    public static final Interpolator P0 = null;
    public boolean A;
    public int A0;
    public int B;
    public int B0;
    public boolean C;
    public final com.obric.oui.orecyclerview.widget.h C0;
    public final AccessibilityManager D;
    public final ViewInfoStore.ProcessCallback D0;
    public List E;
    public boolean F;
    public boolean G;
    public int H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public com.obric.oui.orecyclerview.base.a f15429J;
    public com.obric.oui.orecyclerview.base.a K;
    public OnBounceTranslationListener L;
    public float M;
    public ItemAnimator N;
    public int O;
    public int P;
    public VelocityTracker Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public int W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f15430a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final int f15431a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f15432b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public float f15433b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f15434c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public float f15435c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SavedState f15436d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f15437d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AdapterHelper f15438e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final s f15439e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ChildHelper f15440f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public com.obric.oui.orecyclerview.widget.c f15441f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewInfoStore f15442g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public com.obric.oui.orecyclerview.widget.c.b f15443g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f15444h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final q f15445h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Runnable f15446i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public m f15447i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Rect f15448j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public List f15449j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Rect f15450k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f15451k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final RectF f15452l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public boolean f15453l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Adapter f15454m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public ItemAnimator.ItemAnimatorListener f15455m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LayoutManager f15456n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public boolean f15457n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public RecyclerListener f15458o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public com.obric.oui.orecyclerview.widget.g f15459o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List f15460p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public ChildDrawingOrderCallback f15461p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ArrayList f15462q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public final int[] f15463q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ArrayList f15464r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public NestedScrollingChildHelper f15465r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public OnItemTouchListener f15466s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public final int[] f15467s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f15468t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public final int[] f15469t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f15470u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public final int[] f15471u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f15472v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public final List f15473v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f15474w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public boolean f15475w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f15476x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public boolean f15477x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f15478y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public Runnable f15479y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f15480z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public boolean f15481z0;

    public static abstract class Adapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h f15482a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f15483b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public StateRestorationPolicy f15484c;

        public static final enum StateRestorationPolicy extends Enum<StateRestorationPolicy> {
            private static final /* synthetic */ StateRestorationPolicy[] $VALUES = null;
            public static final StateRestorationPolicy ALLOW = null;
            public static final StateRestorationPolicy PREVENT = null;
            public static final StateRestorationPolicy PREVENT_WHEN_EMPTY = null;

            static {
                StateRestorationPolicy r10 = new StateRestorationPolicy("ALLOW", 0);
                ALLOW = r10;
                StateRestorationPolicy r11 = new StateRestorationPolicy("PREVENT_WHEN_EMPTY", 1);
                PREVENT_WHEN_EMPTY = r11;
                StateRestorationPolicy r12 = new StateRestorationPolicy("PREVENT", 2);
                PREVENT = r12;
                $VALUES = new StateRestorationPolicy[]{r10, r11, r12};
            }

            private StateRestorationPolicy(String r10, int r11) {
                super(r10, r11);
            }

            public static StateRestorationPolicy valueOf(String r10) {
                return (StateRestorationPolicy) Enum.valueOf(StateRestorationPolicy.class, r10);
            }

            public static StateRestorationPolicy[] values() {
                return (StateRestorationPolicy[]) $VALUES.clone();
            }
        }

        public Adapter() {
            this.f15482a = new h();
            this.f15483b = false;
            this.f15484c = StateRestorationPolicy.ALLOW;
        }

        public final void a(t r10, int r11) {
            if (r10.f15584s != null) goto L5;
            boolean r12 = true;
        L6:
            if (r12 == false) goto L11;
            r10.f15568c = r11;
            if (h() == false) goto L10;
            r10.f15570e = f(r11);
        L10:
            r10.H(1, 519);
            androidx.core.os.g.a("RV OnBindView");
        L11:
            r10.f15584s = this;
            if (RecyclerView.E0 == true) goto L14;
        L27:
            l(r10, r11, r10.q());
            if (r12 == false) goto L34;
            r10.d();
            ViewGroup.LayoutParams r13 = r10.f15566a.getLayoutParams();
            if ((r13 instanceof LayoutParams) == false) goto L32;
            ((LayoutParams) r13).f15516c = true;
        L32:
            androidx.core.os.g.b();
            return;
        L34:
            return;
        L14:
            if (r10.f15566a.getParent() != null) goto L21;
            if (ViewCompat.S(r10.f15566a) == r10.z()) goto L21;
            throw new IllegalStateException("Temp-detached state out of sync with reality. holder.isTmpDetached(): " + r10.z() + ", attached to window: " + ViewCompat.S(r10.f15566a) + ", holder: " + r10);
        L21:
            if (r10.f15566a.getParent() != null) goto L27;
            if (ViewCompat.S(r10.f15566a) == false) goto L27;
            throw new IllegalStateException("Attempting to bind attached holder with no parent (AKA temp detached): " + r10);
        L5:
            r12 = false;
            goto L6
        }

        public boolean b() {
            int r10 = g.f15523a[this.f15484c.ordinal()];
            if (r10 != 1) goto L5;
            return false;
        L5:
            if (r10 == 2) goto L8;
            return true;
        L8:
            if (e() > 0) goto L10;
            return false;
        L10:
            return true;
        }

        public final t c(ViewGroup r10, int r11) {
            androidx.core.os.g.a("RV CreateView");     // Catch: Throwable -> L7
            t r12 = m(r10, r11);     // Catch: Throwable -> L7
            if (r12.f15566a.getParent() != null) goto L10;
            r12.f15571f = r11;     // Catch: Throwable -> L7
            androidx.core.os.g.b();
            return r12;
        L10:
            throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            androidx.core.os.g.b();
            throw th;
        }

        public int d(Adapter r10, t r11, int r12) {
            if (r10 != this) goto L4;
            return r12;
        L4:
            return -1;
        }

        public abstract int e();

        public long f(int r10) {
            return -1;
        }

        public int g(int r10) {
            return 0;
        }

        public final boolean h() {
            return this.f15483b;
        }

        public final void i() {
            this.f15482a.a();
        }

        public void j(RecyclerView r10) {
        }

        public abstract void k(t r10, int r11);

        public void l(t r10, int r11, List r12) {
            k(r10, r11);
        }

        public abstract t m(ViewGroup r10, int r11);

        public void n(RecyclerView r10) {
        }

        public boolean o(t r10) {
            return false;
        }

        public void p(t r10) {
        }

        public void q(t r10) {
        }

        public void r(t r10) {
        }

        public void s(i r10) {
            this.f15482a.registerObserver(r10);
        }

        public void t(i r10) {
            this.f15482a.unregisterObserver(r10);
        }
    }

    public interface ChildDrawingOrderCallback {
        int onGetChildDrawingOrder(int r10, int r11);
    }

    public static class EdgeEffectFactory {

        @Retention(RetentionPolicy.SOURCE)
        public @interface EdgeDirection {
        }
    }

    public static abstract class ItemAnimator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ItemAnimatorListener f15485a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList f15486b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f15487c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f15488d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f15489e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f15490f;

        @Retention(RetentionPolicy.SOURCE)
        public @interface AdapterChanges {
        }

        public interface ItemAnimatorFinishedListener {
            void onAnimationsFinished();
        }

        public interface ItemAnimatorListener {
            void onAnimationFinished(@NonNull t r10);
        }

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f15491a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f15492b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f15493c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f15494d;

            public a() {
            }

            public a a(t r10) {
                return b(r10, 0);
            }

            public a b(t r10, int r11) {
                View r12 = r10.f15566a;
                this.f15491a = r12.getLeft();
                this.f15492b = r12.getTop();
                this.f15493c = r12.getRight();
                this.f15494d = r12.getBottom();
                return this;
            }
        }

        public ItemAnimator() {
            this.f15485a = null;
            this.f15486b = new ArrayList();
            this.f15487c = 100;
            this.f15488d = 100;
            this.f15489e = 500;
            this.f15490f = 250;
        }

        public static int e(t r10) {
            int r11 = r10.f15575j;
            int r12 = r11 & 14;
            if (r10.v() == false) goto L6;
            return 4;
        L6:
            if ((r11 & 4) != 0) goto L13;
            int r13 = r10.p();
            int r14 = r10.j();
            if (r13 == (-1)) goto L14;
            if (r14 == (-1)) goto L15;
            if (r13 != r14) goto L12;
            return r12;
        L12:
            return r12 | 2048;
        L15:
            return r12;
        L14:
            return r12;
        L13:
            return r12;
        }

        public abstract boolean a(t r10, a r11, a r12);

        public abstract boolean b(t r10, t r11, a r12, a r13);

        public abstract boolean c(t r10, a r11, a r12);

        public abstract boolean d(t r10, a r11, a r12);

        public abstract boolean f(t r10);

        public boolean g(t r10, List r11) {
            return f(r10);
        }

        public final void h(t r10) {
            r(r10);
            ItemAnimatorListener r11 = this.f15485a;
            if (r11 == null) goto L6;
            r11.onAnimationFinished(r10);
            return;
        }

        public final void i() {
            int r10 = this.f15486b.size();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L5;
            ((ItemAnimatorFinishedListener) this.f15486b.get(r11)).onAnimationsFinished();
            r11 = r11 + 1;
            goto L3
        L5:
            this.f15486b.clear();
        }

        public abstract void j(t r10);

        public abstract void k();

        public long l() {
            return this.f15487c;
        }

        public long m() {
            return this.f15490f;
        }

        public long n() {
            return this.f15489e;
        }

        public long o() {
            return this.f15488d;
        }

        public abstract boolean p();

        public a q() {
            return new a();
        }

        public void r(t r10) {
        }

        public a s(q r10, t r11) {
            return q().a(r11);
        }

        public a t(q r10, t r11, int r12, List r13) {
            return q().a(r11);
        }

        public abstract void u();

        public void v(ItemAnimatorListener r10) {
            this.f15485a = r10;
        }
    }

    public static abstract class LayoutManager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChildHelper f15495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView f15496b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ViewBoundsCheck.Callback f15497c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ViewBoundsCheck.Callback f15498d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ViewBoundsCheck f15499e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ViewBoundsCheck f15500f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f15501g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f15502h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f15503i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f15504j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f15505k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f15506l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f15507m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f15508n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f15509o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f15510p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f15511q;

        public interface LayoutPrefetchRegistry {
            void addPosition(int r10, int r11);
        }

        public class a implements ViewBoundsCheck.Callback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ LayoutManager f15512a;

            public a(LayoutManager r10) {
                this.f15512a = r10;
            }

            @Override // com.obric.oui.orecyclerview.widget.ViewBoundsCheck.Callback
            public View getChildAt(int r10) {
                return this.f15512a.G(r10);
            }

            @Override // com.obric.oui.orecyclerview.widget.ViewBoundsCheck.Callback
            public int getChildEnd(View r10) {
                LayoutParams r11 = (LayoutParams) r10.getLayoutParams();
                return this.f15512a.Q(r10) + ((ViewGroup.MarginLayoutParams) r11).rightMargin;
            }

            @Override // com.obric.oui.orecyclerview.widget.ViewBoundsCheck.Callback
            public int getChildStart(View r10) {
                LayoutParams r11 = (LayoutParams) r10.getLayoutParams();
                return this.f15512a.N(r10) - ((ViewGroup.MarginLayoutParams) r11).leftMargin;
            }

            @Override // com.obric.oui.orecyclerview.widget.ViewBoundsCheck.Callback
            public int getParentEnd() {
                return this.f15512a.k0() - this.f15512a.c0();
            }

            @Override // com.obric.oui.orecyclerview.widget.ViewBoundsCheck.Callback
            public int getParentStart() {
                return this.f15512a.b0();
            }
        }

        public class b implements ViewBoundsCheck.Callback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ LayoutManager f15513a;

            public b(LayoutManager r10) {
                this.f15513a = r10;
            }

            @Override // com.obric.oui.orecyclerview.widget.ViewBoundsCheck.Callback
            public View getChildAt(int r10) {
                return this.f15513a.G(r10);
            }

            @Override // com.obric.oui.orecyclerview.widget.ViewBoundsCheck.Callback
            public int getChildEnd(View r10) {
                LayoutParams r11 = (LayoutParams) r10.getLayoutParams();
                return this.f15513a.L(r10) + ((ViewGroup.MarginLayoutParams) r11).bottomMargin;
            }

            @Override // com.obric.oui.orecyclerview.widget.ViewBoundsCheck.Callback
            public int getChildStart(View r10) {
                LayoutParams r11 = (LayoutParams) r10.getLayoutParams();
                return this.f15513a.R(r10) - ((ViewGroup.MarginLayoutParams) r11).topMargin;
            }

            @Override // com.obric.oui.orecyclerview.widget.ViewBoundsCheck.Callback
            public int getParentEnd() {
                return this.f15513a.T() - this.f15513a.a0();
            }

            @Override // com.obric.oui.orecyclerview.widget.ViewBoundsCheck.Callback
            public int getParentStart() {
                return this.f15513a.d0();
            }
        }

        public LayoutManager() {
            a r10 = new a(this);
            this.f15497c = r10;
            b r11 = new b(this);
            this.f15498d = r11;
            this.f15499e = new ViewBoundsCheck(r10);
            this.f15500f = new ViewBoundsCheck(r11);
            this.f15501g = false;
            this.f15502h = false;
            this.f15503i = false;
            this.f15504j = true;
            this.f15505k = true;
        }

        public static int I(int r10, int r11, int r12, int r13, boolean r14) {
            int r15 = Math.max(0, r10 - r12);
            if (r14 == false) goto L11;
            if (r13 < 0) goto L6;
        L5:
            r11 = 1073741824;
        L22:
            return View.MeasureSpec.makeMeasureSpec(r13, r11);
        L6:
            if (r13 != (-1)) goto L10;
            if (r11 == Integer.MIN_VALUE) goto L14;
            if (r11 == 0) goto L10;
            if (r11 != 1073741824) goto L10;
        L14:
            r13 = r15;
        L10:
            r11 = 0;
            r13 = 0;
            goto L22
        L11:
            if (r13 >= 0) goto L5;
            if (r13 == (-1)) goto L14;
            if (r13 != (-2)) goto L10;
            if (r11 == Integer.MIN_VALUE) goto L20;
            if (r11 == 1073741824) goto L20;
            r13 = r15;
            r11 = 0;
        L20:
            r13 = r15;
            r11 = Integer.MIN_VALUE;
            goto L22
        }

        public static int l(int r10, int r11, int r12) {
            int r13 = View.MeasureSpec.getMode(r10);
            int r14 = View.MeasureSpec.getSize(r10);
            if (r13 == Integer.MIN_VALUE) goto L9;
            if (r13 != 1073741824) goto L7;
            return r14;
        L7:
            return Math.max(r11, r12);
        L9:
            return Math.min(r14, Math.max(r11, r12));
        }

        public static boolean r0(int r10, int r11, int r12) {
            int r13 = View.MeasureSpec.getMode(r11);
            int r14 = View.MeasureSpec.getSize(r11);
            if (r12 <= 0) goto L7;
            if (r10 == r12) goto L7;
            return false;
        L7:
            if (r13 == Integer.MIN_VALUE) goto L16;
            if (r13 != 0) goto L10;
            return true;
        L10:
            if (r13 == 1073741824) goto L12;
            return false;
        L12:
            if (r14 == r10) goto L14;
            return false;
        L14:
            return true;
        L16:
            if (r14 >= r10) goto L18;
            return false;
        L18:
            return true;
        }

        public View A(int r10) {
            int r11 = H();
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L17;
            View r13 = G(r12);
            t r14 = RecyclerView.d0(r13);
            if (r14 == null) goto L16;
            if (r14.o() != r10) goto L16;
            if (r14.L() == true) goto L16;
            if (this.f15496b.f15445h0.d() == true) goto L15;
            if (r14.x() == true) goto L16;
        L15:
            return r13;
        L16:
            r12 = r12 + 1;
            goto L3
        L17:
            return null;
        }

        public boolean A0(RecyclerView r10, ArrayList r11, int r12, int r13) {
            return false;
        }

        public abstract LayoutParams B();

        public void B0(RecyclerView r10) {
        }

        public LayoutParams C(Context r10, AttributeSet r11) {
            return new LayoutParams(r10, r11);
        }

        public void C0(RecyclerView r10) {
        }

        public LayoutParams D(ViewGroup.LayoutParams r10) {
            if ((r10 instanceof LayoutParams) == false) goto L7;
            return new LayoutParams((LayoutParams) r10);
        L7:
            if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
            return new LayoutParams((ViewGroup.MarginLayoutParams) r10);
        L11:
            return new LayoutParams(r10);
        }

        public void D0(RecyclerView r10, o r11) {
            C0(r10);
        }

        public int E() {
            return -1;
        }

        public View E0(View r10, int r11, o r12, q r13) {
            return null;
        }

        public int F(View r10) {
            return ((LayoutParams) r10.getLayoutParams()).f15515b.bottom;
        }

        public void F0(o r10, q r11, AccessibilityEvent r12) {
            RecyclerView r13 = this.f15496b;
            if (r13 == null) goto L20;
            if (r12 == null) goto L22;
            boolean r14 = true;
            if (r13.canScrollVertically(1) == false) goto L9;
        L16:
            r12.setScrollable(r14);
            Adapter r15 = this.f15496b.f15454m;
            if (r15 == null) goto L21;
            r12.setItemCount(r15.e());
            return;
        L21:
            return;
        L9:
            if (this.f15496b.canScrollVertically(-1) == true) goto L16;
            if (this.f15496b.canScrollHorizontally(-1) == true) goto L16;
            if (this.f15496b.canScrollHorizontally(1) == true) goto L16;
            r14 = false;
            goto L16
        L22:
            return;
        }

        public View G(int r10) {
            ChildHelper r11 = this.f15495a;
            if (r11 != null) goto L7;
            return null;
        L7:
            return r11.f(r10);
        }

        public void G0(AccessibilityNodeInfoCompat r10) {
            RecyclerView r11 = this.f15496b;
            H0(r11.f15434c, r11.f15445h0, r10);
        }

        public int H() {
            ChildHelper r10 = this.f15495a;
            if (r10 != null) goto L7;
            return 0;
        L7:
            return r10.g();
        }

        public void H0(o r10, q r11, AccessibilityNodeInfoCompat r12) {
            if (this.f15496b.canScrollVertically(-1) == false) goto L5;
        L6:
            r12.a(8192);
            r12.r0(true);
        L8:
            if (this.f15496b.canScrollVertically(1) == false) goto L10;
        L11:
            r12.a(4096);
            r12.r0(true);
        L12:
            r12.X(AccessibilityNodeInfoCompat.b.b(g0(r10, r11), K(r10, r11), q0(r10, r11), h0(r10, r11)));
            return;
        L10:
            if (this.f15496b.canScrollHorizontally(1) == false) goto L12;
        L5:
            if (this.f15496b.canScrollHorizontally(-1) == false) goto L8;
            goto L6
        }

        public void I0(View r10, AccessibilityNodeInfoCompat r11) {
            t r12 = RecyclerView.d0(r10);
            if (r12 != null) goto L5;
            return;
        L5:
            if (r12.x() == false) goto L7;
            return;
        L7:
            if (this.f15495a.n(r12.f15566a) == true) goto L12;
            RecyclerView r13 = this.f15496b;
            J0(r13.f15434c, r13.f15445h0, r10, r11);
            return;
        }

        public final int[] J(View r10, Rect r11) {
            int r12 = b0();
            int r13 = d0();
            int r14 = k0() - c0();
            int r15 = T() - a0();
            int r16 = (r10.getLeft() + r11.left) - r10.getScrollX();
            int r17 = (r10.getTop() + r11.top) - r10.getScrollY();
            int r18 = r11.width() + r16;
            int r19 = r11.height() + r17;
            int r20 = r16 - r12;
            int r21 = Math.min(0, r20);
            int r22 = r17 - r13;
            int r23 = Math.min(0, r22);
            int r24 = r18 - r14;
            int r25 = Math.max(0, r24);
            int r26 = Math.max(0, r19 - r15);
            if (W() != 1) goto L7;
            if (r25 != 0) goto L11;
            r25 = Math.max(r21, r24);
        L11:
            if (r23 != 0) goto L15;
            r23 = Math.min(r22, r26);
        L15:
            return new int[]{r25, r23};
        L7:
            if (r21 != 0) goto L10;
            r21 = Math.min(r20, r25);
        L10:
            r25 = r21;
            goto L11
        }

        public void J0(o r10, q r11, View r12, AccessibilityNodeInfoCompat r13) {
        }

        public int K(o r10, q r11) {
            return -1;
        }

        public View K0(View r10, int r11) {
            return null;
        }

        public int L(View r10) {
            return r10.getBottom() + F(r10);
        }

        public void L0(RecyclerView r10, int r11, int r12) {
        }

        public void M(View r10, Rect r11) {
            RecyclerView.e0(r10, r11);
        }

        public void M0(RecyclerView r10) {
        }

        public int N(View r10) {
            return r10.getLeft() - X(r10);
        }

        public void N0(RecyclerView r10, int r11, int r12, int r13) {
        }

        public int O(View r10) {
            Rect r11 = ((LayoutParams) r10.getLayoutParams()).f15515b;
            return (r10.getMeasuredHeight() + r11.top) + r11.bottom;
        }

        public void O0(RecyclerView r10, int r11, int r12) {
        }

        public int P(View r10) {
            Rect r11 = ((LayoutParams) r10.getLayoutParams()).f15515b;
            return (r10.getMeasuredWidth() + r11.left) + r11.right;
        }

        public void P0(RecyclerView r10, int r11, int r12) {
        }

        public int Q(View r10) {
            return r10.getRight() + f0(r10);
        }

        public void Q0(RecyclerView r10, int r11, int r12, Object r13) {
            P0(r10, r11, r12);
        }

        public int R(View r10) {
            return r10.getTop() - i0(r10);
        }

        public abstract void R0(o r10, q r11);

        public View S() {
            RecyclerView r10 = this.f15496b;
            if (r10 != null) goto L5;
            return null;
        L5:
            View r11 = r10.getFocusedChild();
            if (r11 != null) goto L8;
        L11:
            return null;
        L8:
            if (this.f15495a.n(r11) == true) goto L11;
            return r11;
        }

        public void S0(q r10) {
        }

        public int T() {
            return this.f15511q;
        }

        public void T0(o r10, q r11, int r12, int r13) {
            this.f15496b.x(r12, r13);
        }

        public int U() {
            return this.f15509o;
        }

        public boolean U0(RecyclerView r10, View r11, View r12) {
            if (s0() == false) goto L5;
        L8:
            return true;
        L5:
            if (r10.r0() == true) goto L8;
            return false;
        }

        public int V() {
            RecyclerView r10 = this.f15496b;
            if (r10 == null) goto L5;
            Adapter r11 = r10.getAdapter();
        L6:
            if (r11 != null) goto L10;
            return 0;
        L10:
            return r11.e();
        L5:
            r11 = null;
            goto L6
        }

        public boolean V0(RecyclerView r10, q r11, View r12, View r13) {
            return U0(r10, r12, r13);
        }

        public int W() {
            return ViewCompat.A(this.f15496b);
        }

        public void W0(Parcelable r10) {
        }

        public int X(View r10) {
            return ((LayoutParams) r10.getLayoutParams()).f15515b.left;
        }

        public Parcelable X0() {
            return null;
        }

        public int Y() {
            return ViewCompat.B(this.f15496b);
        }

        public void Y0(int r10) {
        }

        public int Z() {
            return ViewCompat.C(this.f15496b);
        }

        public boolean Z0(int r10, Bundle r11) {
            RecyclerView r12 = this.f15496b;
            return a1(r12.f15434c, r12.f15445h0, r10, r11);
        }

        public void a(View r10) {
            b(r10, -1);
        }

        public int a0() {
            RecyclerView r10 = this.f15496b;
            if (r10 != null) goto L7;
            return 0;
        L7:
            return r10.getPaddingBottom();
        }

        public boolean a1(o r10, q r11, int r12, Bundle r13) {
            if (this.f15496b != null) goto L5;
            return false;
        L5:
            int r14 = T();
            int r15 = k0();
            Rect r16 = new Rect();
            if (this.f15496b.getMatrix().isIdentity() == false) goto L11;
            if (this.f15496b.getGlobalVisibleRect(r16) == false) goto L11;
            r14 = r16.height();
            r15 = r16.width();
        L11:
            if (r12 == 4096) goto L25;
            if (r12 == 8192) goto L16;
            int r17 = 0;
            int r18 = 0;
        L31:
            if (r18 != 0) goto L34;
            if (r17 != 0) goto L34;
            return false;
        L34:
            this.f15496b.l1(r17, r18, null, Integer.MIN_VALUE, true);
            return true;
        L16:
            if (this.f15496b.canScrollVertically(-1) == false) goto L18;
            int r19 = -((r14 - d0()) - a0());
        L20:
            if (this.f15496b.canScrollHorizontally(-1) == false) goto L23;
            int r110 = -((r15 - b0()) - c0());
        L22:
            r18 = r19;
            r17 = r110;
        L23:
            r18 = r19;
            r17 = 0;
            goto L31
        L18:
            r19 = 0;
            goto L20
        L25:
            if (this.f15496b.canScrollVertically(1) == false) goto L27;
            r19 = (r14 - d0()) - a0();
        L29:
            if (this.f15496b.canScrollHorizontally(1) == false) goto L23;
            r110 = (r15 - b0()) - c0();
            goto L22
        L27:
            r19 = 0;
            goto L29
        }

        public void b(View r10, int r11) {
            e(r10, r11, true);
        }

        public int b0() {
            RecyclerView r10 = this.f15496b;
            if (r10 != null) goto L7;
            return 0;
        L7:
            return r10.getPaddingLeft();
        }

        public boolean b1(View r10, int r11, Bundle r12) {
            RecyclerView r13 = this.f15496b;
            return c1(r13.f15434c, r13.f15445h0, r10, r11, r12);
        }

        public void c(View r10) {
            d(r10, -1);
        }

        public int c0() {
            RecyclerView r10 = this.f15496b;
            if (r10 != null) goto L7;
            return 0;
        L7:
            return r10.getPaddingRight();
        }

        public boolean c1(o r10, q r11, View r12, int r13, Bundle r14) {
            return false;
        }

        public void d(View r10, int r11) {
            e(r10, r11, false);
        }

        public int d0() {
            RecyclerView r10 = this.f15496b;
            if (r10 != null) goto L7;
            return 0;
        L7:
            return r10.getPaddingTop();
        }

        public void d1(o r10) {
            int r11 = H() - 1;
        L3:
            if (r11 < 0) goto L8;
            if (RecyclerView.d0(G(r11)).L() == true) goto L7;
            g1(r11, r10);
        L7:
            r11 = r11 - 1;
            goto L3
        }

        public final void e(View r10, int r11, boolean r12) {
            t r13 = RecyclerView.d0(r10);
            if (r12 == false) goto L5;
        L8:
            this.f15496b.f15442g.b(r13);
        L9:
            LayoutParams r14 = (LayoutParams) r10.getLayoutParams();
            if (r13.N() == true) goto L26;
            if (r13.y() == true) goto L26;
            if (r10.getParent() != this.f15496b) goto L24;
            int r15 = this.f15495a.m(r10);
            if (r11 != (-1)) goto L19;
            r11 = this.f15495a.g();
        L19:
            if (r15 == (-1)) goto L23;
            if (r15 == r11) goto L31;
            this.f15496b.f15456n.w0(r15, r11);
        L31:
            if (r14.f15517d == true) goto L33;
            return;
        L33:
            if (RecyclerView.F0 == false) goto L35;
            Log.d("RecyclerView", "consuming pending invalidate on child " + r14.f15514a);
        L35:
            r13.f15566a.invalidate();
            r14.f15517d = false;
            return;
        L23:
            throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f15496b.indexOfChild(r10) + this.f15496b.N());
        L24:
            this.f15495a.a(r10, r11, false);
            r14.f15516c = true;
        L26:
            if (r13.y() == false) goto L28;
            r13.M();
        L29:
            this.f15495a.c(r10, r11, r10.getLayoutParams(), false);
            goto L31
        L28:
            r13.e();
            goto L29
        L5:
            if (r13.x() == true) goto L8;
            this.f15496b.f15442g.p(r13);
            goto L9
        }

        public int e0(View r10) {
            return ((LayoutParams) r10.getLayoutParams()).a();
        }

        public void e1(o r10) {
            int r11 = r10.i();
            int r12 = r11 - 1;
        L3:
            if (r12 < 0) goto L15;
            View r13 = r10.m(r12);
            t r14 = RecyclerView.d0(r13);
            if (r14.L() == true) goto L14;
            r14.I(false);
            if (r14.z() == false) goto L10;
            this.f15496b.removeDetachedView(r13, false);
        L10:
            ItemAnimator r15 = this.f15496b.N;
            if (r15 == null) goto L13;
            r15.j(r14);
        L13:
            r14.I(true);
            r10.C(r13);
        L14:
            r12 = r12 - 1;
            goto L3
        L15:
            r10.e();
            if (r11 <= 0) goto L22;
            this.f15496b.invalidate();
            return;
        }

        public void f(String r10) {
            RecyclerView r11 = this.f15496b;
            if (r11 == null) goto L6;
            r11.n(r10);
            return;
        }

        public int f0(View r10) {
            return ((LayoutParams) r10.getLayoutParams()).f15515b.right;
        }

        public void f1(View r10, o r11) {
            h1(r10);
            r11.F(r10);
        }

        public void g(View r10, int r11) {
            h(r10, r11, (LayoutParams) r10.getLayoutParams());
        }

        public int g0(o r10, q r11) {
            return -1;
        }

        public void g1(int r10, o r11) {
            View r12 = G(r10);
            i1(r10);
            r11.F(r12);
        }

        public void h(View r10, int r11, LayoutParams r12) {
            t r13 = RecyclerView.d0(r10);
            if (r13.x() == false) goto L5;
            this.f15496b.f15442g.b(r13);
        L6:
            this.f15495a.c(r10, r11, r12, r13.x());
            return;
        L5:
            this.f15496b.f15442g.p(r13);
            goto L6
        }

        public int h0(o r10, q r11) {
            return 0;
        }

        public void h1(View r10) {
            this.f15495a.p(r10);
        }

        public boolean i() {
            return false;
        }

        public int i0(View r10) {
            return ((LayoutParams) r10.getLayoutParams()).f15515b.top;
        }

        public void i1(int r10) {
            if (G(r10) == null) goto L6;
            this.f15495a.q(r10);
            return;
        }

        public abstract boolean j();

        public void j0(View r10, boolean r11, Rect r12) {
            if (r11 == false) goto L4;
            Rect r13 = ((LayoutParams) r10.getLayoutParams()).f15515b;
            r12.set(-r13.left, -r13.top, r10.getWidth() + r13.right, r10.getHeight() + r13.bottom);
        L6:
            if (this.f15496b == null) goto L12;
            Matrix r14 = r10.getMatrix();
            if (r14 == null) goto L12;
            if (r14.isIdentity() == true) goto L12;
            RectF r15 = this.f15496b.f15452l;
            r15.set(r12);
            r14.mapRect(r15);
            r12.set((int) Math.floor(r15.left), (int) Math.floor(r15.top), (int) Math.ceil(r15.right), (int) Math.ceil(r15.bottom));
        L12:
            r12.offset(r10.getLeft(), r10.getTop());
            return;
        L4:
            r12.set(0, 0, r10.getWidth(), r10.getHeight());
            goto L6
        }

        public boolean j1(RecyclerView r10, View r11, Rect r12, boolean r13) {
            return k1(r10, r11, r12, r13, false);
        }

        public boolean k(LayoutParams r10) {
            if (r10 == null) goto L4;
            return true;
        L4:
            return false;
        }

        public int k0() {
            return this.f15510p;
        }

        public boolean k1(RecyclerView r10, View r11, Rect r12, boolean r13, boolean r14) {
            int[] r15 = J(r11, r12);
            int r16 = r15[0];
            int r17 = r15[1];
            if (r14 == true) goto L5;
        L6:
            if (r16 != 0) goto L10;
            if (r17 != 0) goto L10;
        L9:
            return false;
        L10:
            if (r13 == false) goto L12;
            r10.scrollBy(r16, r17);
        L13:
            return true;
        L12:
            r10.i1(r16, r17);
            goto L13
        L5:
            if (o0(r10, r16, r17) == false) goto L9;
            goto L6
        }

        public int l0() {
            return this.f15508n;
        }

        public void l1() {
            RecyclerView r10 = this.f15496b;
            if (r10 == null) goto L6;
            r10.requestLayout();
            return;
        }

        public void m(int r10, int r11, q r12, LayoutPrefetchRegistry r13) {
        }

        public boolean m0() {
            int r10 = H();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L11;
            ViewGroup.LayoutParams r12 = G(r11).getLayoutParams();
            if (r12.width >= 0) goto L10;
            if (r12.height >= 0) goto L10;
            return true;
        L10:
            r11 = r11 + 1;
            goto L3
        L11:
            return false;
        }

        public final void m1(o r10, int r11, View r12) {
            t r13 = RecyclerView.d0(r12);
            if (r13.L() == false) goto L9;
            if (RecyclerView.F0 == false) goto L17;
            Log.d("RecyclerView", "ignoring view " + r13);
            return;
        L17:
            return;
        L9:
            if (r13.v() == true) goto L11;
        L15:
            w(r11);
            r10.H(r12);
            this.f15496b.f15442g.k(r13);
            return;
        L11:
            if (r13.x() == true) goto L15;
            if (this.f15496b.f15454m.h() == true) goto L15;
            i1(r11);
            r10.G(r13);
        }

        public void n(int r10, LayoutPrefetchRegistry r11) {
        }

        public boolean n0() {
            return this.f15503i;
        }

        public int n1(int r10, o r11, q r12) {
            return 0;
        }

        public int o(q r10) {
            return 0;
        }

        public final boolean o0(RecyclerView r10, int r11, int r12) {
            View r13 = r10.getFocusedChild();
            if (r13 != null) goto L5;
            return false;
        L5:
            int r14 = b0();
            int r15 = d0();
            int r16 = k0() - c0();
            int r17 = T() - a0();
            Rect r18 = this.f15496b.f15448j;
            M(r13, r18);
            if ((r18.left - r11) < r16) goto L8;
        L16:
            return false;
        L8:
            if ((r18.right - r11) <= r14) goto L16;
            if ((r18.top - r12) >= r17) goto L16;
            if ((r18.bottom - r12) <= r15) goto L16;
            return true;
        }

        public abstract void o1(int r10);

        public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent r10) {
            RecyclerView r11 = this.f15496b;
            F0(r11.f15434c, r11.f15445h0, r10);
        }

        public int p(q r10) {
            return 0;
        }

        public final boolean p0() {
            return this.f15505k;
        }

        public abstract int p1(int r10, o r11, q r12);

        public int q(q r10) {
            return 0;
        }

        public boolean q0(o r10, q r11) {
            return false;
        }

        public void q1(RecyclerView r10) {
            r1(View.MeasureSpec.makeMeasureSpec(r10.getWidth(), Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(r10.getHeight(), Ints.MAX_POWER_OF_TWO));
        }

        public int r(q r10) {
            return 0;
        }

        public void r1(int r10, int r11) {
            this.f15510p = View.MeasureSpec.getSize(r10);
            int r12 = View.MeasureSpec.getMode(r10);
            this.f15508n = r12;
            if (r12 == 0) goto L5;
        L7:
            this.f15511q = View.MeasureSpec.getSize(r11);
            int r13 = View.MeasureSpec.getMode(r11);
            this.f15509o = r13;
            if (r13 == 0) goto L10;
            return;
        L10:
            if (RecyclerView.J0 == true) goto L14;
            this.f15511q = 0;
            return;
        L14:
            return;
        L5:
            if (RecyclerView.J0 == true) goto L7;
            this.f15510p = 0;
            goto L7
        }

        public int s(q r10) {
            return 0;
        }

        public boolean s0() {
            return false;
        }

        public void s1(int r10, int r11) {
            RecyclerView.g(this.f15496b, r10, r11);
        }

        public int t(q r10) {
            return 0;
        }

        public void t0(View r10, int r11, int r12, int r13, int r14) {
            Rect r15 = ((LayoutParams) r10.getLayoutParams()).f15515b;
            r10.layout(r11 + r15.left, r12 + r15.top, r13 - r15.right, r14 - r15.bottom);
        }

        public void t1(Rect r10, int r11, int r12) {
            int r13 = (r10.width() + b0()) + c0();
            int r14 = (r10.height() + d0()) + a0();
            s1(l(r11, r13, Z()), l(r12, r14, Y()));
        }

        public void u(o r10) {
            int r11 = H() - 1;
        L3:
            if (r11 < 0) goto L5;
            m1(r10, r11, G(r11));
            r11 = r11 - 1;
            goto L3
        }

        public void u0(View r10, int r11, int r12, int r13, int r14) {
            LayoutParams r15 = (LayoutParams) r10.getLayoutParams();
            Rect r16 = r15.f15515b;
            r10.layout((r11 + r16.left) + ((ViewGroup.MarginLayoutParams) r15).leftMargin, (r12 + r16.top) + ((ViewGroup.MarginLayoutParams) r15).topMargin, (r13 - r16.right) - ((ViewGroup.MarginLayoutParams) r15).rightMargin, (r14 - r16.bottom) - ((ViewGroup.MarginLayoutParams) r15).bottomMargin);
        }

        public void u1(int r10, int r11) {
            int r12 = H();
            if (r12 != 0) goto L6;
            this.f15496b.x(r10, r11);
            return;
        L6:
            int r13 = Integer.MIN_VALUE;
            int r14 = Integer.MAX_VALUE;
            int r15 = 0;
            int r16 = Integer.MIN_VALUE;
            int r17 = Integer.MAX_VALUE;
        L7:
            if (r15 >= r12) goto L21;
            View r18 = G(r15);
            Rect r19 = this.f15496b.f15448j;
            M(r18, r19);
            int r20 = r19.left;
            if (r20 >= r17) goto L11;
            r17 = r20;
        L11:
            int r21 = r19.right;
            if (r21 <= r13) goto L14;
            r13 = r21;
        L14:
            int r22 = r19.top;
            if (r22 >= r14) goto L17;
            r14 = r22;
        L17:
            int r23 = r19.bottom;
            if (r23 <= r16) goto L20;
            r16 = r23;
        L20:
            r15 = r15 + 1;
            goto L7
        L21:
            this.f15496b.f15448j.set(r17, r14, r13, r16);
            t1(this.f15496b.f15448j, r10, r11);
        }

        public void v(View r10, o r11) {
            m1(r11, this.f15495a.m(r10), r10);
        }

        public void v0(View r10, int r11, int r12) {
            LayoutParams r13 = (LayoutParams) r10.getLayoutParams();
            Rect r14 = this.f15496b.h0(r10);
            int r15 = r11 + (r14.left + r14.right);
            int r16 = r12 + (r14.top + r14.bottom);
            int r17 = I(k0(), l0(), (((b0() + c0()) + ((ViewGroup.MarginLayoutParams) r13).leftMargin) + ((ViewGroup.MarginLayoutParams) r13).rightMargin) + r15, ((ViewGroup.MarginLayoutParams) r13).width, i());
            int r18 = I(T(), U(), (((d0() + a0()) + ((ViewGroup.MarginLayoutParams) r13).topMargin) + ((ViewGroup.MarginLayoutParams) r13).bottomMargin) + r16, ((ViewGroup.MarginLayoutParams) r13).height, j());
            if (w1(r10, r17, r18, r13) == false) goto L6;
            r10.measure(r17, r18);
            return;
        }

        public void v1(RecyclerView r10) {
            if (r10 != null) goto L4;
            this.f15496b = null;
            this.f15495a = null;
            this.f15510p = 0;
            this.f15511q = 0;
        L5:
            this.f15508n = Ints.MAX_POWER_OF_TWO;
            this.f15509o = Ints.MAX_POWER_OF_TWO;
            return;
        L4:
            this.f15496b = r10;
            this.f15495a = r10.f15440f;
            this.f15510p = r10.getWidth();
            this.f15511q = r10.getHeight();
            goto L5
        }

        public void w(int r10) {
            x(r10, G(r10));
        }

        public void w0(int r10, int r11) {
            View r12 = G(r10);
            if (r12 == null) goto L7;
            w(r10);
            g(r12, r11);
            return;
        L7:
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + r10 + this.f15496b.toString());
        }

        public boolean w1(View r10, int r11, int r12, LayoutParams r13) {
            if (r10.isLayoutRequested() == false) goto L5;
        L12:
            return true;
        L5:
            if (this.f15504j == false) goto L12;
            if (r0(r10.getWidth(), r11, ((ViewGroup.MarginLayoutParams) r13).width) == false) goto L12;
            if (r0(r10.getHeight(), r12, ((ViewGroup.MarginLayoutParams) r13).height) == false) goto L12;
            return false;
        }

        public final void x(int r10, View r11) {
            this.f15495a.d(r10);
        }

        public void x0(int r10) {
            RecyclerView r11 = this.f15496b;
            if (r11 == null) goto L6;
            r11.w0(r10);
            return;
        }

        public boolean x1() {
            return false;
        }

        public void y(RecyclerView r10) {
            this.f15502h = true;
            B0(r10);
        }

        public void y0(int r10) {
            RecyclerView r11 = this.f15496b;
            if (r11 == null) goto L6;
            r11.x0(r10);
            return;
        }

        public void y1() {
        }

        public void z(RecyclerView r10, o r11) {
            this.f15502h = false;
            D0(r10, r11);
        }

        public void z0(Adapter r10, Adapter r11) {
        }

        public boolean z1() {
            return false;
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public t f15514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f15515b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f15516c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f15517d;

        public LayoutParams(Context r10, AttributeSet r11) {
            super(r10, r11);
            this.f15515b = new Rect();
            this.f15516c = true;
            this.f15517d = false;
        }

        public int a() {
            return this.f15514a.o();
        }

        public boolean b() {
            return this.f15514a.A();
        }

        public boolean c() {
            return this.f15514a.x();
        }

        public boolean d() {
            return this.f15514a.v();
        }

        public LayoutParams(int r10, int r11) {
            super(r10, r11);
            this.f15515b = new Rect();
            this.f15516c = true;
            this.f15517d = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r10) {
            super(r10);
            this.f15515b = new Rect();
            this.f15516c = true;
            this.f15517d = false;
        }

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
            this.f15515b = new Rect();
            this.f15516c = true;
            this.f15517d = false;
        }

        public LayoutParams(LayoutParams r10) {
            super(r10);
            this.f15515b = new Rect();
            this.f15516c = true;
            this.f15517d = false;
        }
    }

    public interface OnBounceTranslationListener {
        void onTranslationChanged(float r10);
    }

    public interface OnChildAttachStateChangeListener {
        void onChildViewAttachedToWindow(@NonNull View r10);

        void onChildViewDetachedFromWindow(@NonNull View r10);
    }

    public interface OnItemTouchListener {
        boolean onInterceptTouchEvent(@NonNull RecyclerView r10, @NonNull MotionEvent r11);

        void onRequestDisallowInterceptTouchEvent(boolean r10);

        void onTouchEvent(@NonNull RecyclerView r10, @NonNull MotionEvent r11);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Orientation {
    }

    public interface RecyclerListener {
        void onViewRecycled(@NonNull t r10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        Parcelable mLayoutState;

        public class a implements Parcelable.ClassLoaderCreator {
            public a() {
            }

            public SavedState a(Parcel r10) {
                return new SavedState(r10, null);
            }

            public SavedState b(Parcel r10, ClassLoader r11) {
                return new SavedState(r10, r11);
            }

            public SavedState[] c(int r10) {
                return new SavedState[r10];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
                return c(r10);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10, ClassLoader r11) {
                return b(r10, r11);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r10, ClassLoader r11) {
            super(r10, r11);
            if (r11 != null) goto L6;
            r11 = LayoutManager.class.getClassLoader();
        L6:
            this.mLayoutState = r10.readParcelable(r11);
        }

        public void copyFrom(SavedState r10) {
            this.mLayoutState = r10.mLayoutState;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeParcelable(this.mLayoutState, 0);
        }

        public SavedState(Parcelable r10) {
            super(r10);
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f15518a;

        public a(RecyclerView r10) {
            this.f15518a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView r10 = this.f15518a;
            if (r10.f15474w == true) goto L5;
            return;
        L5:
            if (r10.isLayoutRequested() == true) goto L18;
            RecyclerView r11 = this.f15518a;
            if (r11.f15468t == true) goto L12;
            r11.requestLayout();
            return;
        L12:
            if (r11.f15480z == false) goto L15;
            r11.f15478y = true;
            return;
        L15:
            r11.v();
            return;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f15519a;

        public b(RecyclerView r10) {
            this.f15519a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            ItemAnimator r10 = this.f15519a.N;
            if (r10 == null) goto L5;
            r10.u();
        L5:
            this.f15519a.f15457n0 = false;
        }
    }

    public class c implements Interpolator {
        public c() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float r10) {
            float r11 = r10 - 1.0f;
            return ((((r11 * r11) * r11) * r11) * r11) + 1.0f;
        }
    }

    public class d implements ViewInfoStore.ProcessCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f15520a;

        public d(RecyclerView r10) {
            this.f15520a = r10;
        }

        @Override // com.obric.oui.orecyclerview.widget.ViewInfoStore.ProcessCallback
        public void processAppeared(t r10, ItemAnimator.a r11, ItemAnimator.a r12) {
            this.f15520a.k(r10, r11, r12);
        }

        @Override // com.obric.oui.orecyclerview.widget.ViewInfoStore.ProcessCallback
        public void processDisappeared(t r10, ItemAnimator.a r11, ItemAnimator.a r12) {
            this.f15520a.f15434c.N(r10);
            this.f15520a.m(r10, r11, r12);
        }

        @Override // com.obric.oui.orecyclerview.widget.ViewInfoStore.ProcessCallback
        public void processPersistent(t r10, ItemAnimator.a r11, ItemAnimator.a r12) {
            r10.I(false);
            RecyclerView r13 = this.f15520a;
            if (r13.F == false) goto L8;
            if (r13.N.b(r10, r10, r11, r12) == false) goto L11;
            this.f15520a.I0();
            return;
        L11:
            return;
        L8:
            if (r13.N.d(r10, r11, r12) == false) goto L13;
            this.f15520a.I0();
            return;
        }

        @Override // com.obric.oui.orecyclerview.widget.ViewInfoStore.ProcessCallback
        public void unused(t r10) {
            RecyclerView r11 = this.f15520a;
            r11.f15456n.f1(r10.f15566a, r11.f15434c);
        }
    }

    public class e implements ChildHelper.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f15521a;

        public e(RecyclerView r10) {
            this.f15521a = r10;
        }

        @Override // com.obric.oui.orecyclerview.widget.ChildHelper.Callback
        public void addView(View r10, int r11) {
            this.f15521a.addView(r10, r11);
            this.f15521a.A(r10);
        }

        @Override // com.obric.oui.orecyclerview.widget.ChildHelper.Callback
        public void attachViewToParent(View r10, int r11, ViewGroup.LayoutParams r12) {
            t r13 = RecyclerView.d0(r10);
            if (r13 == null) goto L16;
            if (r13.z() == true) goto L12;
            if (r13.L() == true) goto L12;
            throw new IllegalArgumentException("Called attach on a child which is not detached: " + r13 + this.f15521a.N());
        L12:
            if (RecyclerView.F0 == false) goto L14;
            Log.d("RecyclerView", "reAttach " + r13);
        L14:
            r13.f();
        L17:
            RecyclerView.b(this.f15521a, r10, r11, r12);
            return;
        L16:
            if (RecyclerView.E0 == false) goto L17;
            throw new IllegalArgumentException("No ViewHolder found for child: " + r10 + ", index: " + r11 + this.f15521a.N());
        }

        @Override // com.obric.oui.orecyclerview.widget.ChildHelper.Callback
        public void detachViewFromParent(int r10) {
            View r11 = getChildAt(r10);
            if (r11 == null) goto L18;
            t r12 = RecyclerView.d0(r11);
            if (r12 != null) goto L7;
        L19:
            RecyclerView.c(this.f15521a, r10);
            return;
        L7:
            if (r12.z() == false) goto L14;
            if (r12.L() == true) goto L14;
            throw new IllegalArgumentException("called detach on an already detached child " + r12 + this.f15521a.N());
        L14:
            if (RecyclerView.F0 == false) goto L16;
            Log.d("RecyclerView", "tmpDetach " + r12);
        L16:
            r12.b(256);
            goto L19
        L18:
            if (RecyclerView.E0 == false) goto L19;
            throw new IllegalArgumentException("No view at offset " + r10 + this.f15521a.N());
        }

        @Override // com.obric.oui.orecyclerview.widget.ChildHelper.Callback
        public View getChildAt(int r10) {
            return this.f15521a.getChildAt(r10);
        }

        @Override // com.obric.oui.orecyclerview.widget.ChildHelper.Callback
        public int getChildCount() {
            return this.f15521a.getChildCount();
        }

        @Override // com.obric.oui.orecyclerview.widget.ChildHelper.Callback
        public t getChildViewHolder(View r10) {
            return RecyclerView.d0(r10);
        }

        @Override // com.obric.oui.orecyclerview.widget.ChildHelper.Callback
        public int indexOfChild(View r10) {
            return this.f15521a.indexOfChild(r10);
        }

        @Override // com.obric.oui.orecyclerview.widget.ChildHelper.Callback
        public void onEnteredHiddenState(View r10) {
            t r11 = RecyclerView.d0(r10);
            if (r11 == null) goto L6;
            r11.D(this.f15521a);
            return;
        }

        @Override // com.obric.oui.orecyclerview.widget.ChildHelper.Callback
        public void onLeftHiddenState(View r10) {
            t r11 = RecyclerView.d0(r10);
            if (r11 == null) goto L6;
            r11.E(this.f15521a);
            return;
        }

        @Override // com.obric.oui.orecyclerview.widget.ChildHelper.Callback
        public void removeAllViews() {
            int r10 = getChildCount();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L5;
            View r12 = getChildAt(r11);
            this.f15521a.B(r12);
            r12.clearAnimation();
            r11 = r11 + 1;
            goto L3
        L5:
            this.f15521a.removeAllViews();
        }

        @Override // com.obric.oui.orecyclerview.widget.ChildHelper.Callback
        public void removeViewAt(int r10) {
            View r11 = this.f15521a.getChildAt(r10);
            if (r11 == null) goto L5;
            this.f15521a.B(r11);
            r11.clearAnimation();
        L5:
            this.f15521a.removeViewAt(r10);
        }
    }

    public class f implements AdapterHelper.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f15522a;

        public f(RecyclerView r10) {
            this.f15522a = r10;
        }

        public void a(AdapterHelper.a r10) {
            int r11 = r10.f15385a;
            if (r11 != 1) goto L5;
            RecyclerView r12 = this.f15522a;
            r12.f15456n.L0(r12, r10.f15386b, r10.f15388d);
            return;
        L5:
            if (r11 != 2) goto L7;
            RecyclerView r13 = this.f15522a;
            r13.f15456n.O0(r13, r10.f15386b, r10.f15388d);
            return;
        L7:
            if (r11 != 4) goto L9;
            RecyclerView r14 = this.f15522a;
            r14.f15456n.Q0(r14, r10.f15386b, r10.f15388d, r10.f15387c);
            return;
        L9:
            if (r11 != 8) goto L19;
            RecyclerView r15 = this.f15522a;
            r15.f15456n.N0(r15, r10.f15386b, r10.f15388d, 1);
            return;
        }

        @Override // com.obric.oui.orecyclerview.widget.AdapterHelper.Callback
        public t findViewHolder(int r10) {
            t r11 = this.f15522a.X(r10, true);
            if (r11 != null) goto L6;
            return null;
        L6:
            if (this.f15522a.f15440f.n(r11.f15566a) == true) goto L8;
            return r11;
        L8:
            if (RecyclerView.F0 == false) goto L10;
            Log.d("RecyclerView", "assuming view holder cannot be find because it is hidden");
        L10:
            return null;
        }

        @Override // com.obric.oui.orecyclerview.widget.AdapterHelper.Callback
        public void markViewHoldersUpdated(int r10, int r11, Object r12) {
            this.f15522a.r1(r10, r11, r12);
            this.f15522a.f15453l0 = true;
        }

        @Override // com.obric.oui.orecyclerview.widget.AdapterHelper.Callback
        public void offsetPositionsForAdd(int r10, int r11) {
            this.f15522a.y0(r10, r11);
            this.f15522a.f15451k0 = true;
        }

        @Override // com.obric.oui.orecyclerview.widget.AdapterHelper.Callback
        public void offsetPositionsForMove(int r10, int r11) {
            this.f15522a.z0(r10, r11);
            this.f15522a.f15451k0 = true;
        }

        @Override // com.obric.oui.orecyclerview.widget.AdapterHelper.Callback
        public void offsetPositionsForRemovingInvisible(int r10, int r11) {
            this.f15522a.A0(r10, r11, true);
            RecyclerView r12 = this.f15522a;
            r12.f15451k0 = true;
            r12.f15445h0.f15544d += r11;
        }

        @Override // com.obric.oui.orecyclerview.widget.AdapterHelper.Callback
        public void offsetPositionsForRemovingLaidOutOrNewView(int r10, int r11) {
            this.f15522a.A0(r10, r11, false);
            this.f15522a.f15451k0 = true;
        }

        @Override // com.obric.oui.orecyclerview.widget.AdapterHelper.Callback
        public void onDispatchFirstPass(AdapterHelper.a r10) {
            a(r10);
        }

        @Override // com.obric.oui.orecyclerview.widget.AdapterHelper.Callback
        public void onDispatchSecondPass(AdapterHelper.a r10) {
            a(r10);
        }
    }

    public static /* synthetic */ class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15523a = null;

        static {
            int[] r10 = new int[Adapter.StateRestorationPolicy.values().length];
            f15523a = r10;
            r10[Adapter.StateRestorationPolicy.PREVENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f15523a[Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static class h extends Observable {
        public h() {
        }

        public void a() {
            int r10 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r10 < 0) goto L5;
            ((i) ((Observable) this).mObservers.get(r10)).a();
            r10 = r10 - 1;
            goto L3
        }
    }

    public static abstract class i {
        public i() {
        }

        public abstract void a();
    }

    public class j implements ItemAnimator.ItemAnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f15524a;

        public j(RecyclerView r10) {
            this.f15524a = r10;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.ItemAnimator.ItemAnimatorListener
        public void onAnimationFinished(t r10) {
            r10.I(true);
            if (r10.f15573h != null) goto L5;
        L7:
            r10.f15574i = null;
            if (r10.K() == false) goto L10;
            return;
        L10:
            if (this.f15524a.T0(r10.f15566a) == false) goto L12;
            return;
        L12:
            if (r10.z() == false) goto L17;
            this.f15524a.removeDetachedView(r10.f15566a, false);
            return;
        L17:
            return;
        L5:
            if (r10.f15574i != null) goto L7;
            r10.f15573h = null;
            goto L7
        }
    }

    public static abstract class k {
        public k() {
        }

        public void a(Rect r10, int r11, RecyclerView r12) {
            r10.set(0, 0, 0, 0);
        }

        public void b(Rect r10, View r11, RecyclerView r12, q r13) {
            a(r10, ((LayoutParams) r11.getLayoutParams()).a(), r12);
        }

        public void c(Canvas r10, RecyclerView r11) {
        }

        public void d(Canvas r10, RecyclerView r11, q r12) {
            c(r10, r11);
        }

        public void e(Canvas r10, RecyclerView r11) {
        }

        public void f(Canvas r10, RecyclerView r11, q r12) {
            e(r10, r11);
        }
    }

    public static abstract class l {
    }

    public static abstract class m {
        public m() {
        }

        public void a(RecyclerView r10, int r11) {
        }

        public abstract void b(RecyclerView r10, int r11, int r12);
    }

    public static class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SparseArray f15525a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15526b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Set f15527c;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ArrayList f15528a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f15529b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public long f15530c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public long f15531d;

            public a() {
                this.f15528a = new ArrayList();
                this.f15529b = 5;
                this.f15530c = 0;
                this.f15531d = 0;
            }
        }

        public n() {
            this.f15525a = new SparseArray();
            this.f15526b = 0;
            this.f15527c = Collections.newSetFromMap(new IdentityHashMap());
        }

        public void a() {
            this.f15526b++;
        }

        public void b(Adapter r10) {
            this.f15527c.add(r10);
        }

        public void c() {
            int r10 = 0;
        L4:
            if (r10 >= this.f15525a.size()) goto L10;
            a r11 = (a) this.f15525a.valueAt(r10);
            Iterator r12 = r11.f15528a.iterator();
        L7:
            if (r12.hasNext() == false) goto L9;
            t.a.a(((t) r12.next()).f15566a);
            goto L7
        L9:
            r11.f15528a.clear();
            r10 = r10 + 1;
            goto L4
        }

        public void d() {
            this.f15526b--;
        }

        public void e(Adapter r10, boolean r11) {
            this.f15527c.remove(r10);
            if (this.f15527c.size() != 0) goto L13;
            if (r11 == true) goto L16;
            int r12 = 0;
        L7:
            if (r12 >= this.f15525a.size()) goto L17;
            SparseArray r13 = this.f15525a;
            ArrayList r14 = ((a) r13.get(r13.keyAt(r12))).f15528a;
            int r15 = 0;
        L10:
            if (r15 >= r14.size()) goto L12;
            t.a.a(((t) r14.get(r15)).f15566a);
            r15 = r15 + 1;
            goto L10
        L12:
            r12 = r12 + 1;
            goto L7
        L17:
            return;
        L16:
            return;
        }

        public void f(int r10, long r11) {
            a r12 = i(r10);
            r12.f15531d = l(r12.f15531d, r11);
        }

        public void g(int r10, long r11) {
            a r12 = i(r10);
            r12.f15530c = l(r12.f15530c, r11);
        }

        public t h(int r10) {
            a r11 = (a) this.f15525a.get(r10);
            if (r11 != null) goto L5;
            return null;
        L5:
            if (r11.f15528a.isEmpty() == true) goto L17;
            ArrayList r12 = r11.f15528a;
            int r13 = r12.size() - 1;
        L7:
            if (r13 < 0) goto L18;
            if (((t) r12.get(r13)).t() == false) goto L11;
            r13 = r13 - 1;
            goto L7
        L11:
            return (t) r12.remove(r13);
        L18:
            return null;
        L17:
            return null;
        }

        public final a i(int r10) {
            a r11 = (a) this.f15525a.get(r10);
            if (r11 != null) goto L6;
            a r12 = new a();
            this.f15525a.put(r10, r12);
            return r12;
        L6:
            return r11;
        }

        public void j(Adapter r10, Adapter r11, boolean r12) {
            if (r10 == null) goto L4;
            d();
        L4:
            if (r12 == false) goto L6;
        L8:
            if (r11 == null) goto L11;
            a();
            return;
        L11:
            return;
        L6:
            if (this.f15526b != 0) goto L8;
            c();
            goto L8
        }

        public void k(t r10) {
            int r11 = r10.n();
            ArrayList r12 = i(r11).f15528a;
            if (((a) this.f15525a.get(r11)).f15529b > r12.size()) goto L7;
            t.a.a(r10.f15566a);
            return;
        L7:
            if (RecyclerView.E0 == true) goto L9;
        L13:
            r10.F();
            r12.add(r10);
            return;
        L9:
            if (r12.contains(r10) == false) goto L13;
            throw new IllegalArgumentException("this scrap item already exists");
        }

        public long l(long r10, long r11) {
            if (r10 != 0) goto L6;
            return r11;
        L6:
            return ((r10 / 4) * 3) + (r11 / 4);
        }

        public boolean m(int r10, long r11, long r12) {
            long r13 = i(r10).f15531d;
            if (r13 != 0) goto L5;
        L8:
            return true;
        L5:
            if ((r11 + r13) < r12) goto L8;
            return false;
        }

        public boolean n(int r10, long r11, long r12) {
            long r13 = i(r10).f15530c;
            if (r13 != 0) goto L5;
        L8:
            return true;
        L5:
            if ((r11 + r13) < r12) goto L8;
            return false;
        }
    }

    public final class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList f15532a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList f15533b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList f15534c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f15535d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f15536e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f15537f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public n f15538g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f15539h;

        public o(RecyclerView r10) {
            this.f15539h = r10;
            ArrayList r11 = new ArrayList();
            this.f15532a = r11;
            this.f15533b = null;
            this.f15534c = new ArrayList();
            this.f15535d = Collections.unmodifiableList(r11);
            this.f15536e = 2;
            this.f15537f = 2;
        }

        public final void A(Adapter r10) {
            B(r10, false);
        }

        public final void B(Adapter r10, boolean r11) {
            n r12 = this.f15538g;
            if (r12 == null) goto L6;
            r12.e(r10, r11);
            return;
        }

        public void C(View r10) {
            t r11 = RecyclerView.d0(r10);
            r11.f15579n = null;
            r11.f15580o = false;
            r11.e();
            G(r11);
        }

        public void D() {
            int r10 = this.f15534c.size() - 1;
        L3:
            if (r10 < 0) goto L5;
            E(r10);
            r10 = r10 - 1;
            goto L3
        L5:
            this.f15534c.clear();
            if (RecyclerView.L0 == false) goto L10;
            this.f15539h.f15443g0.a();
            return;
        }

        public void E(int r10) {
            if (RecyclerView.F0 == false) goto L5;
            Log.d("RecyclerView", "Recycling cached view at index " + r10);
        L5:
            t r11 = (t) this.f15534c.get(r10);
            if (RecyclerView.F0 == false) goto L8;
            Log.d("RecyclerView", "CachedViewHolder to be recycled: " + r11);
        L8:
            a(r11, true);
            this.f15534c.remove(r10);
        }

        public void F(View r10) {
            t r11 = RecyclerView.d0(r10);
            if (r11.z() == false) goto L6;
            this.f15539h.removeDetachedView(r10, false);
        L6:
            if (r11.y() == false) goto L9;
            r11.M();
        L11:
            G(r11);
            if (this.f15539h.N != null) goto L14;
            return;
        L14:
            if (r11.w() == true) goto L18;
            this.f15539h.N.j(r11);
            return;
        L18:
            return;
        L9:
            if (r11.N() == false) goto L11;
            r11.e();
            goto L11
        }

        public void G(t r10) {
            boolean r11 = false;
            boolean r12 = true;
            if (r10.y() == false) goto L5;
        L69:
            StringBuilder r13 = new StringBuilder();
            r13.append("Scrapped or attached views may not be recycled. isScrap:");
            r13.append(r10.y());
            r13.append(" isAttached:");
            if (r10.f15566a.getParent() == null) goto L72;
            r11 = true;
        L72:
            r13.append(r11);
            r13.append(this.f15539h.N());
            throw new IllegalArgumentException(r13.toString());
        L5:
            if (r10.f15566a.getParent() != null) goto L69;
            if (r10.z() == true) goto L68;
            if (r10.L() == true) goto L66;
            boolean r14 = r10.h();
            Adapter r15 = this.f15539h.f15454m;
            if (r15 == null) goto L17;
            if (r14 == false) goto L17;
            if (r15.o(r10) == false) goto L17;
            boolean r16 = true;
        L19:
            if (RecyclerView.E0 == true) goto L21;
        L25:
            if (r16 == true) goto L34;
            if (r10.w() == true) goto L34;
            if (RecyclerView.F0 == false) goto L32;
            Log.d("RecyclerView", "trying to recycle a non-recycleable holder. Hopefully, it will re-visit here. We are still removing it from animation lists" + this.f15539h.N());
        L32:
            r12 = false;
        L59:
            this.f15539h.f15442g.q(r10);
            if (r11 == true) goto L76;
            if (r12 == true) goto L77;
            if (r14 == false) goto L78;
            t.a.a(r10.f15566a);
            r10.f15584s = null;
            r10.f15583r = null;
            return;
        L78:
            return;
        L77:
            return;
        L76:
            return;
        L34:
            if (this.f15537f > 0) goto L36;
        L54:
            boolean r17 = false;
        L55:
            if (r17 == true) goto L58;
            a(r10, true);
        L57:
            r11 = r17;
            goto L59
        L58:
            r12 = false;
            goto L57
        L36:
            if (r10.r(526) == true) goto L54;
            int r18 = this.f15534c.size();
            if (r18 < this.f15537f) goto L42;
            if (r18 <= 0) goto L42;
            E(0);
            r18 = r18 - 1;
        L42:
            if (RecyclerView.L0 == false) goto L53;
            if (r18 <= 0) goto L53;
            if (this.f15539h.f15443g0.c(r10.f15568c) == true) goto L53;
            int r19 = r18 - 1;
        L47:
            if (r19 < 0) goto L52;
            if (this.f15539h.f15443g0.c(((t) this.f15534c.get(r19)).f15568c) == false) goto L52;
            r19 = r19 - 1;
        L52:
            r18 = r19 + 1;
        L53:
            this.f15534c.add(r18, r10);
            r17 = true;
            goto L55
        L21:
            if (this.f15534c.contains(r10) == false) goto L25;
            throw new IllegalArgumentException("cached view received recycle internal? " + r10 + this.f15539h.N());
        L17:
            r16 = false;
            goto L19
        L66:
            throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + this.f15539h.N());
        L68:
            throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + r10 + this.f15539h.N());
        }

        public void H(View r10) {
            t r11 = RecyclerView.d0(r10);
            if (r11.r(12) == true) goto L14;
            if (r11.A() == false) goto L14;
            if (this.f15539h.o(r11) == true) goto L14;
            if (this.f15533b != null) goto L12;
            this.f15533b = new ArrayList();
        L12:
            r11.J(this, true);
            this.f15533b.add(r11);
            return;
        L14:
            if (r11.v() == true) goto L16;
        L22:
            r11.J(this, false);
            this.f15532a.add(r11);
            return;
        L16:
            if (r11.x() == true) goto L22;
            if (this.f15539h.f15454m.h() == true) goto L22;
            throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + this.f15539h.N());
        }

        public void I(n r10) {
            A(this.f15539h.f15454m);
            n r11 = this.f15538g;
            if (r11 == null) goto L5;
            r11.d();
        L5:
            this.f15538g = r10;
            if (r10 != null) goto L8;
        L10:
            t();
            return;
        L8:
            if (this.f15539h.getAdapter() == null) goto L10;
            this.f15538g.a();
            goto L10
        }

        public void J(r r10) {
        }

        public void K(int r10) {
            this.f15536e = r10;
            O();
        }

        public final boolean L(t r11, int r12, int r13, long r14) {
            r11.f15584s = null;
            r11.f15583r = this.f15539h;
            int r10 = r11.n();
            long r15 = this.f15539h.getNanoTime();
            boolean r16 = false;
            if (r14 == Long.MAX_VALUE) goto L8;
            if (this.f15538g.m(r10, r15, r14) == true) goto L8;
            return false;
        L8:
            if (r11.z() == false) goto L10;
            RecyclerView r17 = this.f15539h;
            RecyclerView.e(r17, r11.f15566a, r17.getChildCount(), r11.f15566a.getLayoutParams());
            r16 = true;
        L10:
            this.f15539h.f15454m.a(r11, r12);
            if (r16 == false) goto L13;
            RecyclerView.f(this.f15539h, r11.f15566a);
        L13:
            this.f15538g.f(r11.n(), this.f15539h.getNanoTime() - r15);
            b(r11);
            if (this.f15539h.f15445h0.d() == false) goto L16;
            r11.f15572g = r13;
        L16:
            return true;
        }

        public t M(int r19, boolean r20, long r21) {
            if (r19 < 0) goto L109;
            if (r19 >= this.f15539h.f15445h0.b()) goto L109;
            boolean r10 = true;
            if (this.f15539h.f15445h0.d() == false) goto L11;
            t r11 = g(r19);
            if (r11 == null) goto L12;
            boolean r12 = true;
        L13:
            if (r11 != null) goto L28;
            r11 = l(r19, r20);
            if (r11 == null) goto L28;
            if (P(r11) == true) goto L27;
            if (r20 == true) goto L26;
            r11.b(4);
            if (r11.y() == false) goto L23;
            this.f15539h.removeDetachedView(r11.f15566a, false);
            r11.M();
        L25:
            G(r11);
            goto L26
        L23:
            if (r11.N() == false) goto L25;
            r11.e();
        L26:
            r11 = null;
            goto L28
        L27:
            r12 = true;
        L28:
            if (r11 != null) goto L62;
            int r13 = this.f15539h.f15438e.k(r19);
            if (r13 < 0) goto L64;
            if (r13 >= this.f15539h.f15454m.e()) goto L64;
            int r14 = this.f15539h.f15454m.g(r13);
            if (this.f15539h.f15454m.h() == false) goto L39;
            r11 = k(this.f15539h.f15454m.f(r13), r14, r20);
            if (r11 == null) goto L39;
            r11.f15568c = r13;
            r12 = true;
        L39:
            if (r11 == null) goto L41;
        L48:
            if (r11 != null) goto L62;
            long r16 = this.f15539h.getNanoTime();
            if (r21 != Long.MAX_VALUE) goto L52;
        L54:
            RecyclerView r15 = this.f15539h;
            r11 = r15.f15454m.c(r15, r14);
            if (RecyclerView.L0 == false) goto L59;
            RecyclerView r17 = RecyclerView.T(r11.f15566a);
            if (r17 == null) goto L59;
            r11.f15567b = new WeakReference(r17);
        L59:
            this.f15538g.g(r14, this.f15539h.getNanoTime() - r16);
            if (RecyclerView.F0 == false) goto L62;
            Log.d("RecyclerView", "tryGetViewHolderForPositionByDeadline created new ViewHolder");
            goto L62
        L52:
            if (this.f15538g.n(r14, r16, r21) == true) goto L54;
            return null;
        L41:
            if (RecyclerView.F0 == false) goto L43;
            Log.d("RecyclerView", "tryGetViewHolderForPositionByDeadline(" + r19 + ") fetching from shared pool");
        L43:
            r11 = h().h(r14);
            if (r11 == null) goto L48;
            r11.F();
            if (RecyclerView.I0 == false) goto L48;
            q(r11);
        L64:
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + r19 + "(offset:" + r13 + ").state:" + this.f15539h.f15445h0.b() + this.f15539h.N());
        L62:
            t r18 = r11;
            boolean r110 = r12;
            if (r110 == false) goto L74;
            if (this.f15539h.f15445h0.d() == true) goto L74;
            if (r18.r(8192) == false) goto L74;
            r18.H(0, 8192);
            if (this.f15539h.f15445h0.f15551k == false) goto L74;
            int r22 = ItemAnimator.e(r18) | 4096;
            RecyclerView r23 = this.f15539h;
            this.f15539h.N0(r18, r23.N.t(r23.f15445h0, r18, r22, r18.q()));
        L74:
            if (this.f15539h.f15445h0.d() == false) goto L79;
            if (r18.u() == false) goto L79;
            r18.f15572g = r19;
        L85:
            boolean r24 = false;
        L94:
            ViewGroup.LayoutParams r25 = r18.f15566a.getLayoutParams();
            if (r25 != null) goto L98;
            LayoutParams r26 = (LayoutParams) this.f15539h.generateDefaultLayoutParams();
            r18.f15566a.setLayoutParams(r26);
        L101:
            r26.f15514a = r18;
            if (r110 == false) goto L105;
            if (r24 == false) goto L105;
        L106:
            r26.f15517d = r10;
            return r18;
        L105:
            r10 = false;
            goto L106
        L98:
            if (this.f15539h.checkLayoutParams(r25) == true) goto L100;
            r26 = (LayoutParams) this.f15539h.generateLayoutParams(r25);
            r18.f15566a.setLayoutParams(r26);
            goto L101
        L100:
            r26 = (LayoutParams) r25;
        L79:
            if (r18.u() == false) goto L87;
            if (r18.B() == true) goto L87;
            if (r18.v() == false) goto L85;
        L87:
            if (RecyclerView.E0 == true) goto L89;
        L93:
            r24 = L(r18, this.f15539h.f15438e.k(r19), r19, r21);
            goto L94
        L89:
            if (r18.x() == false) goto L93;
            throw new IllegalStateException("Removed holder should be bound and it should come here only in pre-layout. Holder: " + r18 + this.f15539h.N());
        L12:
            r12 = false;
            goto L13
        L11:
            r11 = null;
        L109:
            throw new IndexOutOfBoundsException("Invalid item position " + r19 + "(" + r19 + "). Item count:" + this.f15539h.f15445h0.b() + this.f15539h.N());
        }

        public void N(t r10) {
            if (r10.f15580o == false) goto L5;
            this.f15533b.remove(r10);
        L6:
            r10.f15579n = null;
            r10.f15580o = false;
            r10.e();
            return;
        L5:
            this.f15532a.remove(r10);
            goto L6
        }

        public void O() {
            LayoutManager r10 = this.f15539h.f15456n;
            if (r10 == null) goto L5;
            int r11 = r10.f15506l;
        L6:
            this.f15537f = this.f15536e + r11;
            int r12 = this.f15534c.size() - 1;
        L7:
            if (r12 < 0) goto L11;
            if (this.f15534c.size() <= this.f15537f) goto L14;
            E(r12);
            r12 = r12 - 1;
            goto L7
        L14:
            return;
        L11:
            return;
        L5:
            r11 = 0;
            goto L6
        }

        public boolean P(t r10) {
            if (r10.x() == true) goto L5;
            int r11 = r10.f15568c;
            if (r11 < 0) goto L30;
            if (r11 >= this.f15539h.f15454m.e()) goto L30;
            if (this.f15539h.f15445h0.d() == true) goto L23;
            if (this.f15539h.f15454m.g(r10.f15568c) == r10.n()) goto L23;
            return false;
        L23:
            if (this.f15539h.f15454m.h() == true) goto L25;
            return true;
        L25:
            if (r10.m() == this.f15539h.f15454m.f(r10.f15568c)) goto L27;
            return false;
        L27:
            return true;
        L30:
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + r10 + this.f15539h.N());
        L5:
            if (RecyclerView.E0 == false) goto L12;
            if (this.f15539h.f15445h0.d() == true) goto L12;
            throw new IllegalStateException("should not receive a removed view unless it is pre layout" + this.f15539h.N());
        L12:
            return this.f15539h.f15445h0.d();
        }

        public void Q(int r10, int r11) {
            int r12 = r11 + r10;
            int r13 = this.f15534c.size() - 1;
        L3:
            if (r13 < 0) goto L12;
            t r14 = (t) this.f15534c.get(r13);
            if (r14 == null) goto L11;
            int r15 = r14.f15568c;
            if (r15 < r10) goto L11;
            if (r15 >= r12) goto L11;
            r14.b(2);
            E(r13);
        L11:
            r13 = r13 - 1;
            goto L3
        }

        public void a(t r10, boolean r11) {
            RecyclerView.q(r10);
            View r12 = r10.f15566a;
            com.obric.oui.orecyclerview.widget.g r13 = this.f15539h.f15459o0;
            if (r13 == null) goto L9;
            androidx.core.view.a r14 = r13.getItemDelegate();
            if ((r14 instanceof com.obric.oui.orecyclerview.widget.g.a) == false) goto L7;
            androidx.core.view.a r15 = ((com.obric.oui.orecyclerview.widget.g.a) r14).c(r12);
        L8:
            ViewCompat.p0(r12, r15);
            goto L9
        L7:
            r15 = null;
        L9:
            if (r11 == false) goto L11;
            f(r10);
        L11:
            r10.f15584s = null;
            r10.f15583r = null;
            h().k(r10);
        }

        public final void b(t r10) {
            if (this.f15539h.q0() == false) goto L15;
            View r11 = r10.f15566a;
            if (ViewCompat.y(r11) != 0) goto L7;
            ViewCompat.A0(r11, 1);
        L7:
            com.obric.oui.orecyclerview.widget.g r12 = this.f15539h.f15459o0;
            if (r12 != null) goto L10;
            return;
        L10:
            androidx.core.view.a r13 = r12.getItemDelegate();
            if ((r13 instanceof com.obric.oui.orecyclerview.widget.g.a) == false) goto L13;
            ((com.obric.oui.orecyclerview.widget.g.a) r13).d(r11);
        L13:
            ViewCompat.p0(r11, r13);
            return;
        }

        public void c() {
            this.f15532a.clear();
            D();
        }

        public void d() {
            int r10 = this.f15534c.size();
            int r11 = 0;
            int r12 = 0;
        L3:
            if (r12 >= r10) goto L5;
            ((t) this.f15534c.get(r12)).c();
            r12 = r12 + 1;
            goto L3
        L5:
            int r13 = this.f15532a.size();
            int r14 = 0;
        L6:
            if (r14 >= r13) goto L8;
            ((t) this.f15532a.get(r14)).c();
            r14 = r14 + 1;
            goto L6
        L8:
            ArrayList r15 = this.f15533b;
            if (r15 == null) goto L13;
            int r16 = r15.size();
        L11:
            if (r11 >= r16) goto L17;
            ((t) this.f15533b.get(r11)).c();
            r11 = r11 + 1;
            goto L11
        L17:
            return;
        }

        public void e() {
            this.f15532a.clear();
            ArrayList r10 = this.f15533b;
            if (r10 == null) goto L6;
            r10.clear();
            return;
        }

        public void f(t r10) {
            RecyclerListener r11 = this.f15539h.f15458o;
            if (r11 == null) goto L5;
            r11.onViewRecycled(r10);
        L5:
            int r12 = this.f15539h.f15460p.size();
            int r13 = 0;
        L6:
            if (r13 >= r12) goto L8;
            ((RecyclerListener) this.f15539h.f15460p.get(r13)).onViewRecycled(r10);
            r13 = r13 + 1;
            goto L6
        L8:
            Adapter r14 = this.f15539h.f15454m;
            if (r14 == null) goto L11;
            r14.r(r10);
        L11:
            RecyclerView r15 = this.f15539h;
            if (r15.f15445h0 == null) goto L15;
            r15.f15442g.q(r10);
        L15:
            if (RecyclerView.F0 == false) goto L19;
            Log.d("RecyclerView", "dispatchViewRecycled: " + r10);
            return;
        }

        public t g(int r10) {
            ArrayList r11 = this.f15533b;
            if (r11 == null) goto L32;
            int r12 = r11.size();
            if (r12 == 0) goto L32;
            int r13 = 0;
            int r14 = 0;
        L9:
            if (r14 >= r12) goto L18;
            t r15 = (t) this.f15533b.get(r14);
            if (r15.N() == true) goto L16;
            if (r15.o() != r10) goto L16;
            r15.b(32);
            return r15;
        L16:
            r14 = r14 + 1;
            goto L9
        L18:
            if (this.f15539h.f15454m.h() == false) goto L32;
            int r16 = this.f15539h.f15438e.k(r10);
            if (r16 <= 0) goto L32;
            if (r16 >= this.f15539h.f15454m.e()) goto L32;
            long r17 = this.f15539h.f15454m.f(r16);
        L24:
            if (r13 >= r12) goto L32;
            t r18 = (t) this.f15533b.get(r13);
            if (r18.N() == true) goto L31;
            if (r18.m() != r17) goto L31;
            r18.b(32);
            return r18;
        L31:
            r13 = r13 + 1;
        L32:
            return null;
        }

        public n h() {
            if (this.f15538g != null) goto L6;
            this.f15538g = new n();
            t();
        L6:
            return this.f15538g;
        }

        public int i() {
            return this.f15532a.size();
        }

        public List j() {
            return this.f15535d;
        }

        public t k(long r10, int r11, boolean r12) {
            int r13 = this.f15532a.size() - 1;
        L3:
            if (r13 < 0) goto L19;
            t r14 = (t) this.f15532a.get(r13);
            if (r14.m() != r10) goto L18;
            if (r14.N() == true) goto L18;
            if (r11 == r14.n()) goto L10;
            if (r12 == true) goto L18;
            this.f15532a.remove(r13);
            this.f15539h.removeDetachedView(r14.f15566a, false);
            C(r14.f15566a);
            goto L18
        L10:
            r14.b(32);
            if (r14.x() == true) goto L13;
        L15:
            return r14;
        L13:
            if (this.f15539h.f15445h0.d() == true) goto L15;
            r14.H(2, 14);
        L18:
            r13 = r13 - 1;
            goto L3
        L19:
            int r15 = this.f15534c.size();
        L20:
            r15 = r15 - 1;
            if (r15 < 0) goto L35;
            t r16 = (t) this.f15534c.get(r15);
            if (r16.m() != r10) goto L20;
            if (r16.t() == true) goto L20;
            if (r11 == r16.n()) goto L28;
            if (r12 == true) goto L20;
            E(r15);
            return null;
        L28:
            if (r12 == true) goto L30;
            this.f15534c.remove(r15);
        L30:
            return r16;
        L35:
            return null;
        }

        public t l(int r10, boolean r11) {
            int r12 = this.f15532a.size();
            int r13 = 0;
            int r14 = 0;
        L3:
            if (r14 >= r12) goto L17;
            t r15 = (t) this.f15532a.get(r14);
            if (r15.N() == true) goto L16;
            if (r15.o() != r10) goto L16;
            if (r15.v() == true) goto L16;
            if (this.f15539h.f15445h0.f15548h == true) goto L14;
            if (r15.x() == true) goto L16;
        L14:
            r15.b(32);
            return r15;
        L16:
            r14 = r14 + 1;
            goto L3
        L17:
            if (r11 == true) goto L26;
            View r16 = this.f15539h.f15440f.e(r10);
            if (r16 == null) goto L26;
            t r17 = RecyclerView.d0(r16);
            this.f15539h.f15440f.s(r16);
            int r18 = this.f15539h.f15440f.m(r16);
            if (r18 == (-1)) goto L25;
            this.f15539h.f15440f.d(r18);
            H(r16);
            r17.b(8224);
            return r17;
        L25:
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + r17 + this.f15539h.N());
        L26:
            int r19 = this.f15534c.size();
        L27:
            if (r13 >= r19) goto L41;
            t r20 = (t) this.f15534c.get(r13);
            if (r20.v() == true) goto L40;
            if (r20.o() != r10) goto L40;
            if (r20.t() == true) goto L40;
            if (r11 == true) goto L37;
            this.f15534c.remove(r13);
        L37:
            if (RecyclerView.F0 == false) goto L39;
            Log.d("RecyclerView", "getScrapOrHiddenOrCachedHolderForPosition(" + r10 + ") found match in cache: " + r20);
        L39:
            return r20;
        L40:
            r13 = r13 + 1;
            goto L27
        L41:
            return null;
        }

        public View m(int r10) {
            return ((t) this.f15532a.get(r10)).f15566a;
        }

        public View n(int r10) {
            return o(r10, false);
        }

        public View o(int r10, boolean r11) {
            return M(r10, r11, Long.MAX_VALUE).f15566a;
        }

        public final void p(ViewGroup r10, boolean r11) {
            int r12 = r10.getChildCount() - 1;
        L3:
            if (r12 < 0) goto L8;
            View r13 = r10.getChildAt(r12);
            if ((r13 instanceof ViewGroup) == false) goto L7;
            p((ViewGroup) r13, true);
        L7:
            r12 = r12 - 1;
            goto L3
        L8:
            if (r11 == true) goto L11;
            return;
        L11:
            if (r10.getVisibility() != 4) goto L13;
            r10.setVisibility(0);
            r10.setVisibility(4);
            return;
        L13:
            int r14 = r10.getVisibility();
            r10.setVisibility(4);
            r10.setVisibility(r14);
        }

        public final void q(t r10) {
            View r11 = r10.f15566a;
            if ((r11 instanceof ViewGroup) == false) goto L6;
            p((ViewGroup) r11, false);
            return;
        }

        public void r() {
            int r10 = this.f15534c.size();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L8;
            LayoutParams r12 = (LayoutParams) ((t) this.f15534c.get(r11)).f15566a.getLayoutParams();
            if (r12 == null) goto L7;
            r12.f15516c = true;
        L7:
            r11 = r11 + 1;
            goto L3
        }

        public void s() {
            int r10 = this.f15534c.size();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L8;
            t r12 = (t) this.f15534c.get(r11);
            if (r12 == null) goto L7;
            r12.b(6);
            r12.a(null);
        L7:
            r11 = r11 + 1;
            goto L3
        L8:
            Adapter r13 = this.f15539h.f15454m;
            if (r13 != null) goto L11;
        L12:
            D();
            return;
        L11:
            if (r13.h() == false) goto L12;
        }

        public final void t() {
            if (this.f15538g == null) goto L10;
            RecyclerView r10 = this.f15539h;
            if (r10.f15454m != null) goto L7;
            return;
        L7:
            if (r10.isAttachedToWindow() == false) goto L12;
            this.f15538g.b(this.f15539h.f15454m);
            return;
        L12:
            return;
        }

        public void u(int r10, int r11) {
            int r12 = this.f15534c.size();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L13;
            t r14 = (t) this.f15534c.get(r13);
            if (r14 == null) goto L12;
            if (r14.f15568c < r10) goto L12;
            if (RecyclerView.F0 == false) goto L11;
            Log.d("RecyclerView", "offsetPositionRecordsForInsert cached " + r13 + " holder " + r14 + " now at position " + (r14.f15568c + r11));
        L11:
            r14.C(r11, false);
        L12:
            r13 = r13 + 1;
            goto L3
        }

        public void v(int r10, int r11) {
            if (r10 >= r11) goto L4;
            int r12 = -1;
            int r13 = r10;
            int r14 = r11;
        L5:
            int r15 = this.f15534c.size();
            int r16 = 0;
        L6:
            if (r16 >= r15) goto L20;
            t r17 = (t) this.f15534c.get(r16);
            if (r17 == null) goto L19;
            int r18 = r17.f15568c;
            if (r18 < r13) goto L19;
            if (r18 > r14) goto L19;
            if (r18 != r10) goto L15;
            r17.C(r11 - r10, false);
        L17:
            if (RecyclerView.F0 == false) goto L19;
            Log.d("RecyclerView", "offsetPositionRecordsForMove cached child " + r16 + " holder " + r17);
            goto L19
        L15:
            r17.C(r12, false);
        L19:
            r16 = r16 + 1;
            goto L6
        L20:
            return;
        L4:
            r12 = 1;
            r14 = r10;
            r13 = r11;
            goto L5
        }

        public void w(int r10, int r11, boolean r12) {
            int r13 = r10 + r11;
            int r14 = this.f15534c.size() - 1;
        L3:
            if (r14 < 0) goto L15;
            t r15 = (t) this.f15534c.get(r14);
            if (r15 == null) goto L14;
            int r16 = r15.f15568c;
            if (r16 >= r13) goto L9;
            if (r16 < r10) goto L14;
            r15.b(8);
            E(r14);
            goto L14
        L9:
            if (RecyclerView.F0 == false) goto L11;
            Log.d("RecyclerView", "offsetPositionRecordsForRemove cached " + r14 + " holder " + r15 + " now at position " + (r15.f15568c - r11));
        L11:
            r15.C(-r11, r12);
        L14:
            r14 = r14 - 1;
            goto L3
        }

        public void x(Adapter r10, Adapter r11, boolean r12) {
            c();
            B(r10, true);
            h().j(r10, r11, r12);
            t();
        }

        public void y() {
            t();
        }

        public void z() {
            int r10 = 0;
        L4:
            if (r10 >= this.f15534c.size()) goto L6;
            t.a.a(((t) this.f15534c.get(r10)).f15566a);
            r10 = r10 + 1;
            goto L4
        L6:
            A(this.f15539h.f15454m);
        }
    }

    public class p extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f15540a;

        public p(RecyclerView r10) {
            this.f15540a = r10;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.i
        public void a() {
            this.f15540a.n(null);
            RecyclerView r10 = this.f15540a;
            r10.f15445h0.f15547g = true;
            r10.L0(true);
            if (this.f15540a.f15438e.n() == true) goto L6;
            this.f15540a.requestLayout();
            return;
        }
    }

    public static class q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15541a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SparseArray f15542b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f15543c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f15544d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f15545e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f15546f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f15547g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f15548h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f15549i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f15550j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f15551k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f15552l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f15553m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public long f15554n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f15555o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f15556p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f15557q;

        public q() {
            this.f15541a = -1;
            this.f15543c = 0;
            this.f15544d = 0;
            this.f15545e = 1;
            this.f15546f = 0;
            this.f15547g = false;
            this.f15548h = false;
            this.f15549i = false;
            this.f15550j = false;
            this.f15551k = false;
            this.f15552l = false;
        }

        public void a(int r10) {
            if ((this.f15545e & r10) == 0) goto L6;
            return;
        L6:
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(r10) + " but it is " + Integer.toBinaryString(this.f15545e));
        }

        public int b() {
            if (this.f15548h == false) goto L6;
            return this.f15543c - this.f15544d;
        L6:
            return this.f15546f;
        }

        public boolean c() {
            if (this.f15541a == (-1)) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean d() {
            return this.f15548h;
        }

        public void e(Adapter r10) {
            this.f15545e = 1;
            this.f15546f = r10.e();
            this.f15548h = false;
            this.f15549i = false;
            this.f15550j = false;
        }

        public boolean f() {
            return this.f15552l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f15541a + ", mData=" + this.f15542b + ", mItemCount=" + this.f15546f + ", mIsMeasuring=" + this.f15550j + ", mPreviousLayoutItemCount=" + this.f15543c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f15544d + ", mStructureChanged=" + this.f15547g + ", mInPreLayout=" + this.f15548h + ", mRunSimpleAnimations=" + this.f15551k + ", mRunPredictiveAnimations=" + this.f15552l + '}';
        }
    }

    public static abstract class r {
    }

    public class s implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15559b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public OverScrollerAdapter f15560c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Interpolator f15561d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f15562e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f15563f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f15564g;

        public s(RecyclerView r10) {
            this.f15564g = r10;
            Interpolator r11 = RecyclerView.P0;
            this.f15561d = r11;
            this.f15562e = false;
            this.f15563f = false;
            this.f15560c = new OverScrollerAdapter(r10.getContext(), r11);
        }

        public final int a(int r10, int r11) {
            int r12 = Math.abs(r10);
            int r13 = Math.abs(r11);
            if (r12 <= r13) goto L5;
            boolean r14 = true;
        L6:
            RecyclerView r15 = this.f15564g;
            if (r14 == false) goto L9;
            int r16 = r15.getWidth();
        L10:
            if (r14 == true) goto L14;
            r12 = r13;
        L14:
            return Math.min((int) (((r12 / r16) + 1.0f) * 300.0f), 2000);
        L9:
            r16 = r15.getHeight();
            goto L10
        L5:
            r14 = false;
            goto L6
        }

        public void b(int r13, int r14) {
            this.f15564g.setScrollState(2);
            this.f15559b = 0;
            this.f15558a = 0;
            Interpolator r10 = this.f15561d;
            Interpolator r11 = RecyclerView.P0;
            if (r10 == r11) goto L5;
            this.f15561d = r11;
            this.f15560c = new OverScrollerAdapter(this.f15564g.getContext(), r11);
        L5:
            this.f15560c.e(0, 0, r13, r14, Integer.MIN_VALUE, Channel.UNLIMITED, Integer.MIN_VALUE, Channel.UNLIMITED);
            d();
        }

        public final void c() {
            this.f15564g.removeCallbacks(this);
            ViewCompat.h0(this.f15564g, this);
        }

        public void d() {
            if (this.f15562e == false) goto L5;
            this.f15563f = true;
            return;
        L5:
            c();
        }

        public void e(int r10, int r11, int r12, Interpolator r13) {
            if (r12 != Integer.MIN_VALUE) goto L5;
            r12 = a(r10, r11);
        L5:
            int r14 = r12;
            if (r13 != null) goto L9;
            r13 = RecyclerView.P0;
        L9:
            if (this.f15561d == r13) goto L11;
            this.f15561d = r13;
            this.f15560c = new OverScrollerAdapter(this.f15564g.getContext(), r13);
        L11:
            this.f15559b = 0;
            this.f15558a = 0;
            this.f15564g.setScrollState(2);
            this.f15560c.o(0, 0, r10, r11, r14);
            d();
        }

        public void f() {
            this.f15564g.removeCallbacks(this);
            this.f15560c.a();
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView r10 = this.f15564g;
            if (r10.f15456n != null) goto L6;
            f();
            return;
        L6:
            this.f15563f = false;
            this.f15562e = true;
            r10.v();
            OverScrollerAdapter r11 = this.f15560c;
            if (r11.d() == false) goto L64;
            int r12 = r11.g();
            int r13 = r11.h();
            int r14 = r12 - this.f15558a;
            int r15 = r13 - this.f15559b;
            this.f15558a = r12;
            this.f15559b = r13;
            int r16 = this.f15564g.s(r14);
            int r17 = this.f15564g.u(r15);
            RecyclerView r18 = this.f15564g;
            int[] r19 = r18.f15471u0;
            r19[0] = 0;
            r19[1] = 0;
            if (r18.dispatchNestedPreScroll(r16, r17, r19, null, 1) == false) goto L11;
            int[] r20 = this.f15564g.f15471u0;
            r16 = r16 - r20[0];
            r17 = r17 - r20[1];
        L11:
            RecyclerView r21 = this.f15564g;
            if (r21.f15454m == null) goto L14;
            int[] r22 = r21.f15471u0;
            r22[0] = 0;
            r22[1] = 0;
            r21.c1(r16, r17, r22);
            RecyclerView r23 = this.f15564g;
            int[] r24 = r23.f15471u0;
            int r25 = r24[0];
            int r26 = r24[1];
            r16 = r16 - r25;
            r17 = r17 - r26;
            r23.f15456n.getClass();
        L16:
            if (this.f15564g.f15462q.isEmpty() == true) goto L18;
            this.f15564g.invalidate();
        L18:
            RecyclerView r27 = this.f15564g;
            int[] r28 = r27.f15471u0;
            r28[0] = 0;
            r28[1] = 0;
            r27.dispatchNestedScroll(r25, r26, r16, r17, null, 1, r28);
            RecyclerView r29 = this.f15564g;
            int[] r30 = r29.f15471u0;
            int r31 = r16 - r30[0];
            int r32 = r17 - r30[1];
            if (r25 != 0) goto L21;
            if (r26 != 0) goto L21;
        L23:
            if (RecyclerView.d(this.f15564g) == true) goto L26;
            this.f15564g.invalidate();
        L26:
            if (r11.g() != r11.i()) goto L28;
            boolean r33 = true;
        L30:
            if (r11.h() != r11.j()) goto L32;
            boolean r34 = true;
        L34:
            if (r11.n() == true) goto L41;
            if (r33 == true) goto L37;
            if (r31 != 0) goto L37;
        L40:
            boolean r35 = false;
        L42:
            this.f15564g.f15456n.getClass();
            if (r35 == true) goto L45;
            d();
            RecyclerView r36 = this.f15564g;
            com.obric.oui.orecyclerview.widget.c r37 = r36.f15441f0;
            if (r37 == null) goto L64;
            r37.f(r36, r25, r26);
            goto L64
        L45:
            if (this.f15564g.getOverScrollMode() == 2) goto L59;
            int r38 = (int) r11.f();
            if (r31 >= 0) goto L49;
            int r39 = r38;
        L52:
            if (r32 < 0) goto L57;
            if (r32 <= 0) goto L56;
            r38 = -r38;
            goto L57
        L56:
            r38 = 0;
        L57:
            this.f15564g.a(r39, r38);
            goto L59
        L49:
            if (r31 <= 0) goto L51;
            r39 = -r38;
            goto L52
        L51:
            r39 = 0;
        L59:
            if (RecyclerView.L0 == false) goto L64;
            this.f15564g.f15443g0.a();
        L37:
            if (r34 == true) goto L41;
            if (r32 == 0) goto L40;
        L41:
            r35 = true;
            goto L42
        L32:
            r34 = false;
            goto L34
        L28:
            r33 = false;
        L21:
            r29.I(r25, r26);
            goto L23
        L14:
            r26 = 0;
            r25 = 0;
        L64:
            this.f15564g.f15456n.getClass();
            this.f15562e = false;
            if (this.f15563f == false) goto L67;
            c();
            return;
        L67:
            this.f15564g.setScrollState(0);
            this.f15564g.stopNestedScroll(1);
        }
    }

    public static abstract class t {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final List f15565t = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f15566a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public WeakReference f15567b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f15568c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f15569d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f15570e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f15571f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f15572g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public t f15573h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public t f15574i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f15575j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public List f15576k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public List f15577l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f15578m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public o f15579n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f15580o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f15581p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f15582q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public RecyclerView f15583r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public Adapter f15584s;

        static {
            f15565t = Collections.emptyList();
        }

        public t(View r10) {
            this.f15568c = -1;
            this.f15569d = -1;
            this.f15570e = -1;
            this.f15571f = -1;
            this.f15572g = -1;
            this.f15573h = null;
            this.f15574i = null;
            this.f15576k = null;
            this.f15577l = null;
            this.f15578m = 0;
            this.f15579n = null;
            this.f15580o = false;
            this.f15581p = 0;
            this.f15582q = -1;
            if (r10 == null) goto L7;
            this.f15566a = r10;
            return;
        L7:
            throw new IllegalArgumentException("itemView may not be null");
        }

        public boolean A() {
            if ((this.f15575j & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean B() {
            if ((this.f15575j & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void C(int r10, boolean r11) {
            if (this.f15569d != (-1)) goto L6;
            this.f15569d = this.f15568c;
        L6:
            if (this.f15572g != (-1)) goto L8;
            this.f15572g = this.f15568c;
        L8:
            if (r11 == false) goto L10;
            this.f15572g += r10;
        L10:
            this.f15568c += r10;
            if (this.f15566a.getLayoutParams() == null) goto L14;
            ((LayoutParams) this.f15566a.getLayoutParams()).f15516c = true;
            return;
        }

        public void D(RecyclerView r10) {
            int r11 = this.f15582q;
            if (r11 == (-1)) goto L5;
            this.f15581p = r11;
        L6:
            r10.f1(this, 4);
            return;
        L5:
            this.f15581p = ViewCompat.y(this.f15566a);
            goto L6
        }

        public void E(RecyclerView r10) {
            r10.f1(this, this.f15581p);
            this.f15581p = 0;
        }

        public void F() {
            if (RecyclerView.E0 == true) goto L5;
        L9:
            this.f15575j = 0;
            this.f15568c = -1;
            this.f15569d = -1;
            this.f15570e = -1;
            this.f15572g = -1;
            this.f15578m = 0;
            this.f15573h = null;
            this.f15574i = null;
            d();
            this.f15581p = 0;
            this.f15582q = -1;
            RecyclerView.q(this);
            return;
        L5:
            if (z() == false) goto L9;
            throw new IllegalStateException("Attempting to reset temp-detached ViewHolder: " + this + ". ViewHolders should be fully detached before resetting.");
        }

        public void G() {
            if (this.f15569d != (-1)) goto L6;
            this.f15569d = this.f15568c;
            return;
        }

        public void H(int r10, int r11) {
            int r12 = r10 & r11;
            this.f15575j = r12 | (this.f15575j & (~r11));
        }

        public final void I(boolean r10) {
            int r11 = this.f15578m;
            if (r10 == false) goto L5;
            int r12 = r11 - 1;
        L6:
            this.f15578m = r12;
            if (r12 >= 0) goto L13;
            this.f15578m = 0;
            if (RecyclerView.E0 == true) goto L12;
            Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
        L20:
            if (RecyclerView.F0 == false) goto L23;
            Log.d("RecyclerView", "setIsRecyclable val:" + r10 + ":" + this);
            return;
        L23:
            return;
        L12:
            throw new RuntimeException("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
        L13:
            if (r10 == true) goto L16;
            if (r12 != 1) goto L16;
            this.f15575j |= 16;
        L16:
            if (r10 == false) goto L20;
            if (r12 != 0) goto L20;
            this.f15575j &= -17;
            goto L20
        L5:
            r12 = r11 + 1;
            goto L6
        }

        public void J(o r10, boolean r11) {
            this.f15579n = r10;
            this.f15580o = r11;
        }

        public boolean K() {
            if ((this.f15575j & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean L() {
            if ((this.f15575j & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void M() {
            this.f15579n.N(this);
        }

        public boolean N() {
            if ((this.f15575j & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void a(Object r10) {
            if (r10 != null) goto L6;
            b(1024);
            return;
        L6:
            if ((1024 & this.f15575j) != 0) goto L10;
            g();
            this.f15576k.add(r10);
            return;
        }

        public void b(int r10) {
            this.f15575j = r10 | this.f15575j;
        }

        public void c() {
            this.f15569d = -1;
            this.f15572g = -1;
        }

        public void d() {
            List r10 = this.f15576k;
            if (r10 == null) goto L5;
            r10.clear();
        L5:
            this.f15575j &= -1025;
        }

        public void e() {
            this.f15575j &= -33;
        }

        public void f() {
            this.f15575j &= -257;
        }

        public final void g() {
            if (this.f15576k != null) goto L6;
            ArrayList r10 = new ArrayList();
            this.f15576k = r10;
            this.f15577l = Collections.unmodifiableList(r10);
            return;
        }

        public boolean h() {
            if ((this.f15575j & 16) == 0) goto L5;
        L7:
            return false;
        L5:
            if (ViewCompat.Q(this.f15566a) == false) goto L7;
            return true;
        }

        public void i(int r10, int r11, boolean r12) {
            b(8);
            C(r11, r12);
            this.f15568c = r10;
        }

        public final int j() {
            RecyclerView r10 = this.f15583r;
            if (r10 != null) goto L7;
            return -1;
        L7:
            return r10.Z(this);
        }

        public final int k() {
            return l();
        }

        public final int l() {
            if (this.f15584s != null) goto L5;
            return -1;
        L5:
            RecyclerView r10 = this.f15583r;
            if (r10 != null) goto L8;
            return -1;
        L8:
            Adapter r11 = r10.getAdapter();
            if (r11 != null) goto L11;
            return -1;
        L11:
            int r12 = this.f15583r.Z(this);
            if (r12 != (-1)) goto L15;
            return -1;
        L15:
            return r11.d(this.f15584s, this, r12);
        }

        public final long m() {
            return this.f15570e;
        }

        public final int n() {
            return this.f15571f;
        }

        public final int o() {
            int r10 = this.f15572g;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            return this.f15568c;
        }

        public final int p() {
            return this.f15569d;
        }

        public List q() {
            if ((this.f15575j & 1024) != 0) goto L14;
            List r10 = this.f15576k;
            if (r10 == null) goto L12;
            if (r10.size() == 0) goto L12;
            return this.f15577l;
        L12:
            return f15565t;
        L14:
            return f15565t;
        }

        public boolean r(int r10) {
            if ((this.f15575j & r10) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean s() {
            if ((this.f15575j & 512) == 0) goto L5;
        L8:
            return true;
        L5:
            if (v() == true) goto L8;
            return false;
        }

        public boolean t() {
            if (this.f15566a.getParent() != null) goto L5;
        L7:
            return false;
        L5:
            if (this.f15566a.getParent() == this.f15583r) goto L7;
            return true;
        }

        public String toString() {
            if (getClass().isAnonymousClass() == false) goto L5;
            String r10 = "ViewHolder";
        L6:
            StringBuilder r11 = new StringBuilder(r10 + "{" + Integer.toHexString(hashCode()) + " position=" + this.f15568c + " id=" + this.f15570e + ", oldPos=" + this.f15569d + ", pLpos:" + this.f15572g);
            if (y() == false) goto L14;
            r11.append(" scrap ");
            if (this.f15580o == false) goto L11;
            String r12 = "[changeScrap]";
        L12:
            r11.append(r12);
            goto L14
        L11:
            r12 = "[attachedScrap]";
        L14:
            if (v() == false) goto L17;
            r11.append(" invalid");
        L17:
            if (u() == true) goto L20;
            r11.append(" unbound");
        L20:
            if (B() == false) goto L23;
            r11.append(" update");
        L23:
            if (x() == false) goto L26;
            r11.append(" removed");
        L26:
            if (L() == false) goto L29;
            r11.append(" ignored");
        L29:
            if (z() == false) goto L32;
            r11.append(" tmpDetached");
        L32:
            if (w() == true) goto L35;
            r11.append(" not recyclable(" + this.f15578m + ")");
        L35:
            if (s() == false) goto L38;
            r11.append(" undefined adapter position");
        L38:
            if (this.f15566a.getParent() != null) goto L40;
            r11.append(" no parent");
        L40:
            r11.append("}");
            return r11.toString();
        L5:
            r10 = getClass().getSimpleName();
            goto L6
        }

        public boolean u() {
            if ((this.f15575j & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean v() {
            if ((this.f15575j & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean w() {
            if ((this.f15575j & 16) == 0) goto L5;
        L7:
            return false;
        L5:
            if (ViewCompat.Q(this.f15566a) == true) goto L7;
            return true;
        }

        public boolean x() {
            if ((this.f15575j & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean y() {
            if (this.f15579n == null) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean z() {
            if ((this.f15575j & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        G0 = new int[]{R.attr.nestedScrollingEnabled};
        H0 = (float) (Math.log(0.78d) / Math.log(0.9d));
        I0 = false;
        J0 = true;
        K0 = true;
        L0 = true;
        M0 = false;
        N0 = false;
        Class r10 = Integer.TYPE;
        O0 = new Class[]{Context.class, AttributeSet.class, r10, r10};
        P0 = new c();
    }

    public RecyclerView(@NonNull Context r10) {
        this(r10, null);
    }

    private void C() {
        int r10 = this.B;
        this.B = 0;
        if (r10 != 0) goto L5;
        return;
    L5:
        if (q0() == false) goto L9;
        AccessibilityEvent r11 = AccessibilityEvent.obtain();
        r11.setEventType(2048);
        AccessibilityEventCompat.b(r11, r10);
        sendAccessibilityEventUnchecked(r11);
        return;
    }

    private void E() {
        boolean r10 = true;
        this.f15445h0.a(1);
        O(this.f15445h0);
        this.f15445h0.f15550j = false;
        m1();
        this.f15442g.f();
        D0();
        K0();
        Z0();
        q r11 = this.f15445h0;
        if (r11.f15551k == true) goto L5;
    L7:
        r10 = false;
    L8:
        r11.f15549i = r10;
        this.f15453l0 = false;
        this.f15451k0 = false;
        r11.f15548h = r11.f15552l;
        r11.f15546f = this.f15454m.e();
        S(this.f15463q0);
        if (this.f15445h0.f15551k == false) goto L32;
        int r12 = this.f15440f.g();
        int r13 = 0;
    L11:
        if (r13 >= r12) goto L32;
        t r14 = d0(this.f15440f.f(r13));
        if (r14.L() == true) goto L30;
        if (r14.v() == true) goto L17;
    L19:
        this.f15442g.e(r14, this.N.t(this.f15445h0, r14, ItemAnimator.e(r14), r14.q()));
        if (this.f15445h0.f15549i == false) goto L30;
        if (r14.A() == false) goto L30;
        if (r14.x() == true) goto L30;
        if (r14.L() == true) goto L30;
        if (r14.v() == true) goto L30;
        this.f15442g.c(a0(r14), r14);
        goto L30
    L17:
        if (this.f15454m.h() == true) goto L19;
    L30:
        r13 = r13 + 1;
    L32:
        if (this.f15445h0.f15552l == false) goto L50;
        a1();
        q r15 = this.f15445h0;
        boolean r16 = r15.f15547g;
        r15.f15547g = false;
        this.f15456n.R0(this.f15434c, r15);
        this.f15445h0.f15547g = r16;
        int r17 = 0;
    L35:
        if (r17 >= this.f15440f.g()) goto L49;
        t r18 = d0(this.f15440f.f(r17));
        if (r18.L() == true) goto L48;
        if (this.f15442g.i(r18) == true) goto L48;
        int r19 = ItemAnimator.e(r18);
        boolean r20 = r18.r(8192);
        if (r20 == true) goto L44;
        r19 = r19 | 4096;
    L44:
        ItemAnimator.a r21 = this.N.t(this.f15445h0, r18, r19, r18.q());
        if (r20 == false) goto L47;
        N0(r18, r21);
        goto L48
    L47:
        this.f15442g.a(r18, r21);
    L48:
        r17 = r17 + 1;
        goto L35
    L49:
        r();
    L51:
        E0();
        o1(false);
        this.f15445h0.f15545e = 2;
        return;
    L50:
        r();
        goto L51
    L5:
        if (this.f15453l0 == false) goto L7;
        goto L7
    }

    private void F() {
        m1();
        D0();
        this.f15445h0.a(6);
        this.f15438e.h();
        this.f15445h0.f15546f = this.f15454m.e();
        this.f15445h0.f15544d = 0;
        if (this.f15436d != null) goto L5;
    L10:
        q r10 = this.f15445h0;
        r10.f15548h = false;
        this.f15456n.R0(this.f15434c, r10);
        q r11 = this.f15445h0;
        r11.f15547g = false;
        if (r11.f15551k == true) goto L13;
    L15:
        boolean r12 = false;
    L16:
        r11.f15551k = r12;
        r11.f15545e = 4;
        E0();
        o1(false);
        return;
    L13:
        if (this.N == null) goto L15;
        r12 = true;
        goto L16
    L5:
        if (this.f15454m.b() == false) goto L10;
        Parcelable r13 = this.f15436d.mLayoutState;
        if (r13 == null) goto L9;
        this.f15456n.W0(r13);
    L9:
        this.f15436d = null;
        goto L10
    }

    private void G() {
        this.f15445h0.a(4);
        m1();
        D0();
        q r10 = this.f15445h0;
        r10.f15545e = 1;
        if (r10.f15551k == false) goto L24;
        int r11 = this.f15440f.g() - 1;
    L5:
        if (r11 < 0) goto L23;
        t r12 = d0(this.f15440f.f(r11));
        if (r12.L() == true) goto L22;
        long r13 = a0(r12);
        ItemAnimator.a r14 = this.N.s(this.f15445h0, r12);
        t r15 = this.f15442g.g(r13);
        if (r15 != null) goto L12;
    L21:
        this.f15442g.d(r12, r14);
        goto L22
    L12:
        if (r15.L() == true) goto L21;
        boolean r16 = this.f15442g.h(r15);
        boolean r17 = this.f15442g.h(r12);
        if (r16 == false) goto L17;
        if (r15 != r12) goto L17;
        this.f15442g.d(r12, r14);
    L17:
        ItemAnimator.a r18 = this.f15442g.n(r15);
        this.f15442g.d(r12, r14);
        ItemAnimator.a r19 = this.f15442g.m(r12);
        if (r18 != null) goto L20;
        i0(r13, r12, r15);
        goto L22
    L20:
        l(r15, r12, r18, r19, r16, r17);
    L22:
        r11 = r11 - 1;
        goto L5
    L23:
        this.f15442g.o(this.D0);
    L24:
        this.f15456n.e1(this.f15434c);
        q r20 = this.f15445h0;
        r20.f15543c = r20.f15546f;
        this.F = false;
        this.G = false;
        r20.f15551k = false;
        r20.f15552l = false;
        this.f15456n.f15501g = false;
        ArrayList r21 = this.f15434c.f15533b;
        if (r21 == null) goto L27;
        r21.clear();
    L27:
        LayoutManager r22 = this.f15456n;
        if (r22.f15507m == false) goto L30;
        r22.f15506l = 0;
        r22.f15507m = false;
        this.f15434c.O();
    L30:
        this.f15456n.S0(this.f15445h0);
        E0();
        o1(false);
        this.f15442g.f();
        int[] r23 = this.f15463q0;
        if (y(r23[0], r23[1]) == false) goto L33;
        I(0, 0);
    L33:
        O0();
        X0();
    }

    private boolean J0() {
        if (this.N != null) goto L5;
    L7:
        return false;
    L5:
        if (this.f15456n.z1() == false) goto L7;
        return true;
    }

    private boolean K(MotionEvent r10) {
        OnItemTouchListener r11 = this.f15466s;
        if (r11 == null) goto L5;
        r11.onTouchEvent(this, r10);
        int r12 = r10.getAction();
        if (r12 == 3) goto L13;
        if (r12 == 1) goto L13;
    L14:
        return true;
    L13:
        this.f15466s = null;
        goto L14
    L5:
        if (r10.getAction() != 0) goto L9;
        return false;
    L9:
        return R(r10);
    }

    private void K0() {
        if (this.F == false) goto L8;
        this.f15438e.s();
        if (this.G == false) goto L8;
        this.f15456n.M0(this);
    L8:
        if (J0() == false) goto L10;
        this.f15438e.q();
    L11:
        boolean r10 = true;
        if (this.f15451k0 == false) goto L14;
    L17:
        boolean r11 = true;
    L18:
        q r12 = this.f15445h0;
        if (this.f15474w == true) goto L21;
    L31:
        boolean r13 = false;
    L32:
        r12.f15551k = r13;
        q r14 = this.f15445h0;
        if (r14.f15551k == false) goto L40;
        if (r11 == false) goto L40;
        if (this.F == true) goto L40;
        if (J0() == false) goto L40;
    L41:
        r14.f15552l = r10;
        return;
    L40:
        r10 = false;
        goto L41
    L21:
        if (this.N == null) goto L31;
        boolean r15 = this.F;
        if (r15 == true) goto L27;
        if (r11 == true) goto L27;
        if (this.f15456n.f15501g == false) goto L31;
    L27:
        if (r15 == true) goto L29;
    L30:
        r13 = true;
        goto L32
    L29:
        if (this.f15454m.h() == false) goto L31;
    L14:
        if (this.f15453l0 == true) goto L17;
        r11 = false;
        goto L18
    L10:
        this.f15438e.h();
        goto L11
    }

    private void M0(float r10, float r11, float r12, float r13) {
        boolean r14 = true;
        if (r11 == 0.0f) goto L5;
        L();
        this.f15429J.f(r11, false, false);
        boolean r15 = true;
    L7:
        if (r13 == 0.0f) goto L9;
        M();
        this.K.f(r13, false, false);
    L10:
        if (r14 == true) goto L13;
        if (r11 != 0.0f) goto L13;
        if (r13 != 0.0f) goto L13;
        return;
    L13:
        ViewCompat.g0(this);
        return;
    L9:
        r14 = r15;
        goto L10
    L5:
        r15 = false;
        goto L7
    }

    private void O0() {
        if (this.f15437d0 == true) goto L5;
        return;
    L5:
        if (this.f15454m != null) goto L7;
        return;
    L7:
        if (hasFocus() == true) goto L9;
        return;
    L9:
        if (getDescendantFocusability() != 393216) goto L11;
        return;
    L11:
        if (getDescendantFocusability() != 131072) goto L16;
        if (isFocused() == false) goto L16;
        return;
    L16:
        if (isFocused() == true) goto L30;
        View r10 = getFocusedChild();
        if (N0 == false) goto L28;
        if (r10.getParent() == null) goto L24;
        if (r10.hasFocus() == true) goto L28;
    L24:
        if (this.f15440f.g() != 0) goto L30;
        requestFocus();
        return;
    L28:
        if (this.f15440f.n(r10) == true) goto L30;
        return;
    L30:
        View r11 = null;
        if (this.f15445h0.f15554n != (-1)) goto L33;
    L35:
        t r12 = null;
    L36:
        if (r12 == null) goto L44;
        if (this.f15440f.n(r12.f15566a) == true) goto L44;
        if (r12.f15566a.hasFocusable() == false) goto L44;
        r11 = r12.f15566a;
    L46:
        if (r11 == null) goto L60;
        int r13 = this.f15445h0.f15555o;
        if (r13 == (-1)) goto L54;
        View r14 = r11.findViewById(r13);
        if (r14 == null) goto L54;
        if (r14.isFocusable() == false) goto L54;
        r11 = r14;
    L54:
        r11.requestFocus();
        return;
    L60:
        return;
    L44:
        if (this.f15440f.g() <= 0) goto L46;
        r11 = U();
        goto L46
    L33:
        if (this.f15454m.h() == false) goto L35;
        r12 = W(this.f15445h0.f15554n);
        goto L36
    }

    private void P0() {
        com.obric.oui.orecyclerview.base.a r10 = this.f15429J;
        if (r10 == null) goto L5;
        r10.g();
        boolean r11 = this.f15429J.d();
    L6:
        com.obric.oui.orecyclerview.base.a r12 = this.K;
        if (r12 == null) goto L9;
        r12.g();
        r11 = r11 | this.K.d();
    L9:
        if (r11 == false) goto L12;
        ViewCompat.g0(this);
        return;
    L12:
        return;
    L5:
        r11 = false;
        goto L6
    }

    private int Q0(int r10, float r11) {
        com.obric.oui.orecyclerview.base.a r12 = this.f15429J;
        if (r12 != null) goto L5;
    L8:
        return 0;
    L5:
        if (r12.c() == 0.0f) goto L8;
        int r13 = (int) this.f15429J.f(r10, true, false);
        invalidate();
        return r13;
    }

    private boolean R(MotionEvent r10) {
        int r11 = r10.getAction();
        int r12 = this.f15464r.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L11;
        OnItemTouchListener r14 = (OnItemTouchListener) this.f15464r.get(r13);
        if (r14.onInterceptTouchEvent(this, r10) == false) goto L10;
        if (r11 == 3) goto L10;
        this.f15466s = r14;
        return true;
    L10:
        r13 = r13 + 1;
        goto L3
    L11:
        return false;
    }

    private int R0(int r10, float r11) {
        com.obric.oui.orecyclerview.base.a r12 = this.K;
        if (r12 != null) goto L5;
    L8:
        return 0;
    L5:
        if (r12.c() == 0.0f) goto L8;
        int r13 = (int) this.K.f(r10, true, false);
        invalidate();
        return r13;
    }

    private void S(int[] r10) {
        int r11 = this.f15440f.g();
        if (r11 != 0) goto L6;
        r10[0] = -1;
        r10[1] = -1;
        return;
    L6:
        int r12 = Channel.UNLIMITED;
        int r13 = Integer.MIN_VALUE;
        int r14 = 0;
    L7:
        if (r14 >= r11) goto L17;
        t r15 = d0(this.f15440f.f(r14));
        if (r15.L() == true) goto L16;
        int r16 = r15.o();
        if (r16 >= r12) goto L14;
        r12 = r16;
    L14:
        if (r16 <= r13) goto L16;
        r13 = r16;
    L16:
        r14 = r14 + 1;
        goto L7
    L17:
        r10[0] = r12;
        r10[1] = r13;
    }

    public static RecyclerView T(View r10) {
        if ((r10 instanceof ViewGroup) == true) goto L6;
        return null;
    L6:
        if ((r10 instanceof RecyclerView) == true) goto L8;
        ViewGroup r11 = (ViewGroup) r10;
        int r12 = r11.getChildCount();
        int r13 = 0;
    L10:
        if (r13 >= r12) goto L15;
        RecyclerView r14 = T(r11.getChildAt(r13));
        if (r14 != null) goto L13;
        r13 = r13 + 1;
        goto L10
    L13:
        return r14;
    L15:
        return null;
    L8:
        return (RecyclerView) r10;
    }

    private View U() {
        q r10 = this.f15445h0;
        int r11 = r10.f15553m;
        if (r11 != (-1)) goto L6;
        r11 = 0;
    L6:
        int r12 = r10.b();
        int r13 = r11;
    L7:
        if (r13 >= r12) goto L16;
        t r14 = V(r13);
        if (r14 == null) goto L16;
        if (r14.f15566a.hasFocusable() == true) goto L14;
        r13 = r13 + 1;
        goto L7
    L14:
        return r14.f15566a;
    L16:
        int r15 = Math.min(r12, r11);
    L17:
        r15 = r15 - 1;
        if (r15 < 0) goto L27;
        t r16 = V(r15);
        if (r16 == null) goto L21;
        if (r16.f15566a.hasFocusable() == false) goto L17;
        return r16.f15566a;
    L21:
        return null;
    L27:
        return null;
    }

    private void W0(View r12, View r13) {
        if (r13 == null) goto L4;
        View r10 = r13;
    L5:
        this.f15448j.set(0, 0, r10.getWidth(), r10.getHeight());
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if ((r11 instanceof LayoutParams) == false) goto L10;
        LayoutParams r14 = (LayoutParams) r11;
        if (r14.f15516c == true) goto L10;
        Rect r15 = r14.f15515b;
        Rect r16 = this.f15448j;
        r16.left -= r15.left;
        r16.right += r15.right;
        r16.top -= r15.top;
        r16.bottom += r15.bottom;
    L10:
        if (r13 == null) goto L12;
        offsetDescendantRectToMyCoords(r13, this.f15448j);
        offsetRectIntoDescendantCoords(r12, this.f15448j);
    L12:
        LayoutManager r17 = this.f15456n;
        Rect r18 = this.f15448j;
        boolean r19 = !this.f15474w;
        if (r13 != null) goto L15;
        boolean r110 = true;
    L16:
        r17.k1(this, r12, r18, r19, r110);
        return;
    L15:
        r110 = false;
        goto L16
    L4:
        r10 = r12;
        goto L5
    }

    private void X0() {
        q r10 = this.f15445h0;
        r10.f15554n = -1;
        r10.f15553m = -1;
        r10.f15555o = -1;
    }

    private void Y0() {
        VelocityTracker r10 = this.Q;
        if (r10 == null) goto L5;
        r10.clear();
    L5:
        stopNestedScroll(0);
        P0();
    }

    private void Z0() {
        t r10 = null;
        if (this.f15437d0 == true) goto L5;
    L9:
        View r11 = null;
    L10:
        if (r11 == null) goto L13;
        r10 = Q(r11);
    L13:
        if (r10 != null) goto L15;
        X0();
        return;
    L15:
        q r12 = this.f15445h0;
        if (this.f15454m.h() == false) goto L18;
        long r13 = r10.m();
    L19:
        r12.f15554n = r13;
        q r14 = this.f15445h0;
        if (this.F == false) goto L23;
        int r15 = -1;
    L26:
        r14.f15553m = r15;
        this.f15445h0.f15555o = f0(r10.f15566a);
        return;
    L23:
        if (r10.x() == false) goto L25;
        r15 = r10.f15569d;
        goto L26
    L25:
        r15 = r10.j();
        goto L26
    L18:
        r13 = -1;
        goto L19
    L5:
        if (hasFocus() == false) goto L9;
        if (this.f15454m == null) goto L9;
        r11 = getFocusedChild();
        goto L10
    }

    public static /* synthetic */ void b(RecyclerView r10, View r11, int r12, ViewGroup.LayoutParams r13) {
        r10.attachViewToParent(r11, r12, r13);
    }

    public static /* synthetic */ void c(RecyclerView r10, int r11) {
        r10.detachViewFromParent(r11);
    }

    public static /* synthetic */ boolean d(RecyclerView r10) {
        return r10.awakenScrollBars();
    }

    public static t d0(View r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return ((LayoutParams) r10.getLayoutParams()).f15514a;
    }

    public static /* synthetic */ void e(RecyclerView r10, View r11, int r12, ViewGroup.LayoutParams r13) {
        r10.attachViewToParent(r11, r12, r13);
    }

    public static void e0(View r10, Rect r11) {
        LayoutParams r12 = (LayoutParams) r10.getLayoutParams();
        Rect r13 = r12.f15515b;
        r11.set((r10.getLeft() - r13.left) - ((ViewGroup.MarginLayoutParams) r12).leftMargin, (r10.getTop() - r13.top) - ((ViewGroup.MarginLayoutParams) r12).topMargin, (r10.getRight() + r13.right) + ((ViewGroup.MarginLayoutParams) r12).rightMargin, (r10.getBottom() + r13.bottom) + ((ViewGroup.MarginLayoutParams) r12).bottomMargin);
    }

    public static /* synthetic */ void f(RecyclerView r10, View r11) {
        r10.detachViewFromParent(r11);
    }

    private int f0(View r10) {
        int r11 = r10.getId();
    L4:
        if (r10.isFocused() == true) goto L12;
        if ((r10 instanceof ViewGroup) == false) goto L12;
        if (r10.hasFocus() == false) goto L12;
        r10 = ((ViewGroup) r10).getFocusedChild();
        if (r10.getId() == (-1)) goto L4;
        r11 = r10.getId();
    L12:
        return r11;
    }

    public static /* synthetic */ void g(RecyclerView r10, int r11, int r12) {
        r10.setMeasuredDimension(r11, r12);
    }

    private String g0(Context r10, String r11) {
        if (r11.charAt(0) != '.') goto L7;
        return r10.getPackageName() + r11;
    L7:
        if (r11.contains(LibrarianImpl.Constants.DOT) == false) goto L10;
        return r11;
    L10:
        return RecyclerView.class.getPackage().getName() + '.' + r11;
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.f15465r0 != null) goto L6;
        this.f15465r0 = new NestedScrollingChildHelper(this);
    L6:
        return this.f15465r0;
    }

    private boolean k0() {
        int r10 = this.f15440f.g();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L14;
        t r12 = d0(this.f15440f.f(r11));
        if (r12 == null) goto L13;
        if (r12.L() == true) goto L13;
        if (r12.A() == false) goto L13;
        return true;
    L13:
        r11 = r11 + 1;
        goto L3
    L14:
        return false;
    }

    private void m0() {
        if (ViewCompat.z(this) != 0) goto L6;
        ViewCompat.B0(this, 8);
        return;
    }

    private void n0() {
        this.f15440f = new ChildHelper(new e(this));
    }

    private boolean n1(MotionEvent r10) {
        com.obric.oui.orecyclerview.base.a r11 = this.f15429J;
        if (r11 != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        com.obric.oui.orecyclerview.base.a r13 = this.K;
        if (r13 == null) goto L14;
        if (r13.c() == 0.0f) goto L14;
        this.K.f(0.0f, false, false);
        return true;
    L14:
        return r12;
    L5:
        if (r11.c() == 0.0f) goto L7;
        r12 = true;
        goto L8
    }

    private void onPointerUp(MotionEvent r10) {
        int r11 = r10.getActionIndex();
        if (r10.getPointerId(r11) != this.P) goto L9;
        if (r11 != 0) goto L6;
        int r12 = 1;
    L7:
        this.P = r10.getPointerId(r12);
        int r13 = (int) (r10.getX(r12) + 0.5f);
        this.T = r13;
        this.R = r13;
        int r14 = (int) (r10.getY(r12) + 0.5f);
        this.U = r14;
        this.S = r14;
        return;
    L6:
        r12 = 0;
        goto L7
    }

    private void p() {
        Y0();
        setScrollState(0);
    }

    public static void q(t r10) {
        WeakReference r11 = r10.f15567b;
        if (r11 == null) goto L23;
        View r12 = (View) r11.get();
    L6:
        if (r12 == null) goto L14;
        if (r12 == r10.f15566a) goto L9;
        Object r13 = r12.getParent();
        if ((r13 instanceof View) == true) goto L12;
        r12 = null;
        goto L6
    L12:
        r12 = (View) r13;
        goto L6
    L9:
        return;
    L14:
        r10.f15567b = null;
        return;
    }

    private void q1() {
        this.f15439e0.f();
        LayoutManager r10 = this.f15456n;
        if (r10 == null) goto L6;
        r10.y1();
        return;
    }

    private boolean s0(View r10, View r11, int r12) {
        if (r11 == null) goto L89;
        if (r11 == this) goto L90;
        if (r11 != r10) goto L8;
        return false;
    L8:
        if (P(r11) != null) goto L11;
        return false;
    L11:
        if (r10 != null) goto L14;
        return true;
    L14:
        if (P(r10) != null) goto L16;
        return true;
    L16:
        this.f15448j.set(0, 0, r10.getWidth(), r10.getHeight());
        this.f15450k.set(0, 0, r11.getWidth(), r11.getHeight());
        offsetDescendantRectToMyCoords(r10, this.f15448j);
        offsetDescendantRectToMyCoords(r11, this.f15450k);
        byte r13 = -1;
        if (this.f15456n.W() != 1) goto L19;
        int r14 = -1;
    L20:
        Rect r15 = this.f15448j;
        int r16 = r15.left;
        Rect r17 = this.f15450k;
        int r18 = r17.left;
        if (r16 < r18) goto L25;
        if (r15.right <= r18) goto L25;
    L27:
        int r19 = r15.right;
        int r20 = r17.right;
        if (r19 > r20) goto L30;
        if (r16 >= r20) goto L30;
    L32:
        int r21 = 0;
    L33:
        int r22 = r15.top;
        int r23 = r17.top;
        if (r22 < r23) goto L38;
        if (r15.bottom <= r23) goto L38;
    L40:
        int r24 = r15.bottom;
        int r25 = r17.bottom;
        if (r24 > r25) goto L43;
        if (r22 >= r25) goto L43;
    L45:
        r13 = 0;
    L46:
        if (r12 != 1) goto L48;
        if (r13 < 0) goto L82;
        if (r13 == 0) goto L80;
        return false;
    L80:
        if ((r21 * r14) < 0) goto L82;
        return false;
    L82:
        return true;
    L48:
        if (r12 != 2) goto L50;
        if (r13 > 0) goto L76;
        if (r13 == 0) goto L74;
        return false;
    L74:
        if ((r21 * r14) > 0) goto L76;
        return false;
    L76:
        return true;
    L50:
        if (r12 != 17) goto L52;
        if (r21 < 0) goto L70;
        return false;
    L70:
        return true;
    L52:
        if (r12 != 33) goto L54;
        if (r13 < 0) goto L67;
        return false;
    L67:
        return true;
    L54:
        if (r12 != 66) goto L56;
        if (r21 > 0) goto L64;
        return false;
    L64:
        return true;
    L56:
        if (r12 != 130) goto L61;
        if (r13 > 0) goto L59;
        return false;
    L59:
        return true;
    L61:
        throw new IllegalArgumentException("Invalid direction: " + r12 + N());
    L43:
        if (r22 <= r23) goto L45;
    L38:
        if (r15.bottom >= r17.bottom) goto L40;
        r13 = 1;
    L30:
        if (r16 <= r18) goto L32;
        r21 = -1;
    L25:
        if (r15.right >= r17.right) goto L27;
        r21 = 1;
        goto L33
    L19:
        r14 = 1;
        goto L20
    L90:
        return false;
    L89:
        return false;
    }

    public static void setDebugAssertionsEnabled(boolean r10) {
        E0 = r10;
    }

    public static void setVerboseLoggingEnabled(boolean r10) {
        F0 = r10;
    }

    private void v0(int r12, int r13, MotionEvent r14, int r15) {
        LayoutManager r10 = this.f15456n;
        if (r10 != null) goto L7;
        Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L7:
        if (this.f15480z == false) goto L9;
        return;
    L9:
        int[] r11 = this.f15471u0;
        int r16 = 0;
        r11[0] = 0;
        r11[1] = 0;
        boolean r17 = r10.i();
        boolean r18 = this.f15456n.j();
        if (r18 == false) goto L12;
        int r19 = (r17 ? 1 : 0) | 2;
    L14:
        if (r14 != null) goto L16;
        float r20 = getHeight() / 2.0f;
    L17:
        if (r14 != null) goto L19;
        float r21 = getWidth() / 2.0f;
    L20:
        int r110 = r12 - Q0(r12, r20);
        int r111 = r13 - R0(r13, r21);
        startNestedScroll(r19, r15);
        if (r17 == false) goto L23;
        int r22 = r110;
    L24:
        if (r18 == false) goto L26;
        int r23 = r111;
    L28:
        if (dispatchNestedPreScroll(r22, r23, this.f15471u0, this.f15467s0, r15) == false) goto L30;
        int[] r24 = this.f15471u0;
        r110 = r110 - r24[0];
        r111 = r111 - r24[1];
    L30:
        if (r17 == false) goto L32;
        int r25 = r110;
    L33:
        if (r18 == false) goto L35;
        r16 = r111;
    L35:
        b1(r25, r16, r14, r15);
        com.obric.oui.orecyclerview.widget.c r112 = this.f15441f0;
        if (r112 == null) goto L40;
        if (r110 != 0) goto L39;
        if (r111 == 0) goto L40;
    L39:
        r112.f(this, r110, r111);
    L40:
        stopNestedScroll(r15);
        return;
    L32:
        r25 = 0;
        goto L33
    L26:
        r23 = 0;
        goto L28
    L23:
        r22 = 0;
        goto L24
    L19:
        r21 = r14.getX();
        goto L20
    L16:
        r20 = r14.getY();
        goto L17
    L12:
        r19 = r17 ? 1 : 0;
        goto L14
    }

    private void w(Context r10, String r11, AttributeSet r12, int r13, int r14) {
        if (r11 == null) goto L42;
        String r15 = r11.trim();
        if (r15.isEmpty() == true) goto L48;
        String r16 = g0(r10, r15);
    L10:
        e = move-exception;
        throw new IllegalStateException(r12.getPositionDescription() + ": Class is not a LayoutManager " + r16, e);
    L18:
        e = move-exception;
        throw new IllegalStateException(r12.getPositionDescription() + ": Unable to find LayoutManager " + r16, e);
    L12:
        e = move-exception;
        throw new IllegalStateException(r12.getPositionDescription() + ": Cannot access non-public constructor " + r16, e);
    L14:
        e = move-exception;
        throw new IllegalStateException(r12.getPositionDescription() + ": Could not instantiate the LayoutManager: " + r16, e);
    L16:
        e = move-exception;
        throw new IllegalStateException(r12.getPositionDescription() + ": Could not instantiate the LayoutManager: " + r16, e);
    L8:
        if (isInEditMode() == false) goto L20;
        ClassLoader r17 = getClass().getClassLoader();     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18
    L21:
        Class<? extends U> r18 = Class.forName(r16, false, r17).asSubclass(LayoutManager.class);     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18
        Constructor r19 = r18.getConstructor(O0);     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18 NoSuchMethodException -> L25
        Object[] r20 = {r10, r12, Integer.valueOf(r13), Integer.valueOf(r14)};     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18 NoSuchMethodException -> L25
    L28:
        r19.setAccessible(true);     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18
        setLayoutManager((LayoutManager) r19.newInstance(r20));     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18
        return;
    L25:
        e = move-exception;
        r20 = null;
        r19 = r18.getConstructor(null);     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18 NoSuchMethodException -> L29
    L29:
        e = move-exception;
        e.initCause(e);     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18
        throw new IllegalStateException(r12.getPositionDescription() + ": Error creating LayoutManager " + r16, e);     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18
    L20:
        r17 = r10.getClassLoader();     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18
        goto L21
    L48:
        return;
    }

    private boolean y(int r10, int r11) {
        S(this.f15463q0);
        int[] r12 = this.f15463q0;
        if (r12[0] != r10) goto L7;
        if (r12[1] != r11) goto L7;
        return false;
    L7:
        return true;
    }

    public void A(View r10) {
        t r11 = d0(r10);
        B0(r10);
        Adapter r12 = this.f15454m;
        if (r12 == null) goto L6;
        if (r11 == null) goto L6;
        r12.p(r11);
    L6:
        List r13 = this.E;
        if (r13 == null) goto L11;
        int r14 = r13.size() - 1;
    L9:
        if (r14 < 0) goto L13;
        ((OnChildAttachStateChangeListener) this.E.get(r14)).onChildViewAttachedToWindow(r10);
        r14 = r14 - 1;
        goto L9
    L13:
        return;
    }

    public void A0(int r10, int r11, boolean r12) {
        int r13 = r10 + r11;
        int r14 = this.f15440f.j();
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L20;
        t r16 = d0(this.f15440f.i(r15));
        if (r16 == null) goto L19;
        if (r16.L() == true) goto L19;
        int r17 = r16.f15568c;
        if (r17 >= r13) goto L11;
        if (r17 < r10) goto L19;
        if (F0 == false) goto L18;
        Log.d("RecyclerView", "offsetPositionRecordsForRemove attached child " + r15 + " holder " + r16 + " now REMOVED");
    L18:
        r16.i(r10 - 1, -r11, r12);
        this.f15445h0.f15547g = true;
        goto L19
    L11:
        if (F0 == false) goto L13;
        Log.d("RecyclerView", "offsetPositionRecordsForRemove attached child " + r15 + " holder " + r16 + " now at position " + (r16.f15568c - r11));
    L13:
        r16.C(-r11, r12);
        this.f15445h0.f15547g = true;
    L19:
        r15 = r15 + 1;
        goto L3
    L20:
        this.f15434c.w(r10, r11, r12);
        requestLayout();
    }

    public void B(View r10) {
        t r11 = d0(r10);
        C0(r10);
        Adapter r12 = this.f15454m;
        if (r12 == null) goto L6;
        if (r11 == null) goto L6;
        r12.q(r11);
    L6:
        List r13 = this.E;
        if (r13 == null) goto L11;
        int r14 = r13.size() - 1;
    L9:
        if (r14 < 0) goto L13;
        ((OnChildAttachStateChangeListener) this.E.get(r14)).onChildViewDetachedFromWindow(r10);
        r14 = r14 - 1;
        goto L9
    L13:
        return;
    }

    public void B0(View r10) {
    }

    public void C0(View r10) {
    }

    public void D() {
        if (this.f15454m != null) goto L7;
        Log.w("RecyclerView", "No adapter attached; skipping layout");
        return;
    L7:
        if (this.f15456n != null) goto L10;
        Log.e("RecyclerView", "No layout manager attached; skipping layout");
        return;
    L10:
        this.f15445h0.f15550j = false;
        if (this.f15481z0 == true) goto L13;
    L17:
        boolean r10 = false;
    L18:
        this.A0 = 0;
        this.B0 = 0;
        this.f15481z0 = false;
        if (this.f15445h0.f15545e != 1) goto L22;
        E();
        this.f15456n.q1(this);
        F();
    L31:
        G();
        return;
    L22:
        if (this.f15438e.o() == true) goto L30;
        if (r10 == true) goto L30;
        if (this.f15456n.k0() != getWidth()) goto L30;
        if (this.f15456n.T() != getHeight()) goto L30;
        this.f15456n.q1(this);
    L30:
        this.f15456n.q1(this);
        F();
        goto L31
    L13:
        if (this.A0 == getWidth()) goto L15;
    L16:
        r10 = true;
        goto L18
    L15:
        if (this.B0 == getHeight()) goto L17;
        goto L16
    }

    public void D0() {
        this.H++;
    }

    public void E0() {
        F0(true);
    }

    public void F0(boolean r10) {
        int r11 = this.H - 1;
        this.H = r11;
        if (r11 < 1) goto L5;
        return;
    L5:
        if (E0 == false) goto L10;
        if (r11 >= 0) goto L10;
        throw new IllegalStateException("layout or scroll counter cannot go below zero.Some calls are not matching" + N());
    L10:
        this.H = 0;
        if (r10 == false) goto L15;
        C();
        J();
        return;
    }

    public void G0(int r10) {
    }

    public void H(int r10) {
        LayoutManager r11 = this.f15456n;
        if (r11 == null) goto L5;
        r11.Y0(r10);
    L5:
        G0(r10);
        m r12 = this.f15447i0;
        if (r12 == null) goto L8;
        r12.a(this, r10);
    L8:
        List r13 = this.f15449j0;
        if (r13 == null) goto L13;
        int r14 = r13.size() - 1;
    L11:
        if (r14 < 0) goto L15;
        ((m) this.f15449j0.get(r14)).a(this, r10);
        r14 = r14 - 1;
        goto L11
    L15:
        return;
    }

    public void H0(int r10, int r11) {
    }

    public void I(int r10, int r11) {
        this.I++;
        int r12 = getScrollX();
        int r13 = getScrollY();
        onScrollChanged(r12, r13, r12 - r10, r13 - r11);
        H0(r10, r11);
        m r14 = this.f15447i0;
        if (r14 == null) goto L5;
        r14.b(this, r10, r11);
    L5:
        List r15 = this.f15449j0;
        if (r15 == null) goto L10;
        int r16 = r15.size() - 1;
    L8:
        if (r16 < 0) goto L10;
        ((m) this.f15449j0.get(r16)).b(this, r10, r11);
        r16 = r16 - 1;
    L10:
        this.I--;
    }

    public void I0() {
        if (this.f15457n0 == false) goto L5;
        return;
    L5:
        if (this.f15468t == false) goto L9;
        ViewCompat.h0(this, this.f15479y0);
        this.f15457n0 = true;
        return;
    }

    public void J() {
        int r10 = this.f15473v0.size() - 1;
    L3:
        if (r10 < 0) goto L13;
        t r11 = (t) this.f15473v0.get(r10);
        if (r11.f15566a.getParent() != this) goto L12;
        if (r11.L() == true) goto L12;
        int r12 = r11.f15582q;
        if (r12 == (-1)) goto L12;
        ViewCompat.A0(r11.f15566a, r12);
        r11.f15582q = -1;
    L12:
        r10 = r10 - 1;
        goto L3
    L13:
        this.f15473v0.clear();
    }

    public void L() {
        if (this.f15429J == null) goto L5;
        return;
    L5:
        com.obric.oui.orecyclerview.base.a r10 = new com.obric.oui.orecyclerview.base.a(getContext());
        this.f15429J = r10;
        r10.i(getWidth());
    }

    public void L0(boolean r10) {
        this.G = r10 | this.G;
        this.F = true;
        u0();
    }

    public void M() {
        if (this.K == null) goto L5;
        return;
    L5:
        com.obric.oui.orecyclerview.base.a r10 = new com.obric.oui.orecyclerview.base.a(getContext());
        this.K = r10;
        r10.i(getHeight());
    }

    public String N() {
        return " " + super.toString() + ", adapter:" + this.f15454m + ", layout:" + this.f15456n + ", context:" + getContext();
    }

    public void N0(t r10, ItemAnimator.a r11) {
        r10.H(0, 8192);
        if (this.f15445h0.f15549i == true) goto L5;
    L11:
        this.f15442g.e(r10, r11);
        return;
    L5:
        if (r10.A() == false) goto L11;
        if (r10.x() == true) goto L11;
        if (r10.L() == true) goto L11;
        long r12 = a0(r10);
        this.f15442g.c(r12, r10);
        goto L11
    }

    public final void O(q r10) {
        if (getScrollState() != 2) goto L5;
        OverScrollerAdapter r11 = this.f15439e0.f15560c;
        r10.f15556p = r11.i() - r11.g();
        r10.f15557q = r11.j() - r11.h();
        return;
    L5:
        r10.f15556p = 0;
        r10.f15557q = 0;
    }

    public View P(View r10) {
        ViewParent r11 = r10.getParent();
    L3:
        if (r11 == null) goto L8;
        if (r11 == this) goto L8;
        if ((r11 instanceof View) == false) goto L8;
        r10 = r11;
        r11 = r10.getParent();
    L8:
        if (r11 == this) goto L15;
        return null;
    L15:
        return r10;
    }

    public t Q(View r10) {
        View r11 = P(r10);
        if (r11 != null) goto L6;
        return null;
    L6:
        return c0(r11);
    }

    public void S0() {
        ItemAnimator r10 = this.N;
        if (r10 == null) goto L5;
        r10.k();
    L5:
        LayoutManager r11 = this.f15456n;
        if (r11 == null) goto L8;
        r11.d1(this.f15434c);
        this.f15456n.e1(this.f15434c);
    L8:
        this.f15434c.c();
    }

    public boolean T0(View r10) {
        m1();
        boolean r11 = this.f15440f.r(r10);
        if (r11 == false) goto L7;
        t r12 = d0(r10);
        this.f15434c.N(r12);
        this.f15434c.G(r12);
        if (F0 == false) goto L7;
        Log.d("RecyclerView", "after removing animated view: " + r10 + ", " + this);
    L7:
        o1(!r11);
        return r11;
    }

    public void U0(k r10) {
        LayoutManager r11 = this.f15456n;
        if (r11 == null) goto L5;
        r11.f("Cannot remove item decoration during a scroll  or layout");
    L5:
        this.f15462q.remove(r10);
        if (this.f15462q.isEmpty() == true) goto L8;
    L12:
        t0();
        requestLayout();
        return;
    L8:
        if (getOverScrollMode() != 2) goto L10;
        boolean r12 = true;
    L11:
        setWillNotDraw(r12);
        goto L12
    L10:
        r12 = false;
        goto L11
    }

    public t V(int r10) {
        t r11 = null;
        if (this.F == false) goto L5;
        return null;
    L5:
        int r12 = this.f15440f.j();
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L18;
        t r14 = d0(this.f15440f.i(r13));
        if (r14 == null) goto L17;
        if (r14.x() == true) goto L17;
        if (Z(r14) != r10) goto L17;
        if (this.f15440f.n(r14.f15566a) == false) goto L16;
        r11 = r14;
        goto L17
    L16:
        return r14;
    L17:
        r13 = r13 + 1;
        goto L6
    L18:
        return r11;
    }

    public void V0() {
        int r10 = this.f15440f.g();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L14;
        View r12 = this.f15440f.f(r11);
        t r13 = c0(r12);
        if (r13 == null) goto L13;
        t r14 = r13.f15574i;
        if (r14 == null) goto L13;
        View r15 = r14.f15566a;
        int r16 = r12.getLeft();
        int r17 = r12.getTop();
        if (r16 == r15.getLeft()) goto L11;
    L12:
        r15.layout(r16, r17, r15.getWidth() + r16, r15.getHeight() + r17);
        goto L13
    L11:
        if (r17 != r15.getTop()) goto L12;
    L13:
        r11 = r11 + 1;
        goto L3
    }

    public t W(long r10) {
        Adapter r11 = this.f15454m;
        t r12 = null;
        if (r11 != null) goto L5;
    L20:
        return r12;
    L5:
        if (r11.h() == false) goto L20;
        int r13 = this.f15440f.j();
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L20;
        t r15 = d0(this.f15440f.i(r14));
        if (r15 == null) goto L19;
        if (r15.x() == true) goto L19;
        if (r15.m() != r10) goto L19;
        if (this.f15440f.n(r15.f15566a) == false) goto L18;
        r12 = r15;
        goto L19
    L18:
        return r15;
    L19:
        r14 = r14 + 1;
        goto L8
    }

    public t X(int r10, boolean r11) {
        int r12 = this.f15440f.j();
        t r13 = null;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L20;
        t r15 = d0(this.f15440f.i(r14));
        if (r15 == null) goto L19;
        if (r15.x() == true) goto L19;
        if (r11 == false) goto L13;
        if (r15.f15568c != r10) goto L19;
    L16:
        if (this.f15440f.n(r15.f15566a) == false) goto L18;
        r13 = r15;
        goto L19
    L18:
        return r15;
    L13:
        if (r15.o() == r10) goto L16;
    L19:
        r14 = r14 + 1;
        goto L3
    L20:
        return r13;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean Y(int r10, int r11) {
        LayoutManager r12 = this.f15456n;
        if (r12 != null) goto L7;
        Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return false;
    L7:
        if (this.f15480z == false) goto L9;
        return false;
    L9:
        boolean r13 = r12.i();
        boolean r14 = this.f15456n.j();
        if (r13 == true) goto L12;
    L13:
        r10 = 0;
    L14:
        if (r14 == true) goto L16;
    L17:
        r11 = 0;
    L18:
        if (r10 != 0) goto L22;
        if (r11 != 0) goto L22;
        return false;
    L22:
        if (r10 == 0) goto L38;
        com.obric.oui.orecyclerview.base.a r15 = this.f15429J;
        if (r15 == null) goto L38;
        if (r15.c() == 0.0f) goto L38;
        if (g1(this.f15429J, r10) == false) goto L30;
        this.f15429J.e(r10);
        int r16 = 0;
    L32:
        if (this.f15475w0 == false) goto L37;
        com.obric.oui.orecyclerview.base.a r17 = this.f15429J;
        if (r17 != null) goto L36;
    L39:
        if (r11 == 0) goto L55;
        com.obric.oui.orecyclerview.base.a r18 = this.K;
        if (r18 == null) goto L55;
        if (r18.c() == 0.0f) goto L55;
        if (g1(this.K, r11) == false) goto L47;
        this.K.e(-r11);
        int r19 = 0;
    L49:
        if (this.f15475w0 == false) goto L54;
        com.obric.oui.orecyclerview.base.a r20 = this.K;
        if (r20 != null) goto L53;
    L56:
        if (r16 != 0) goto L58;
        if (r19 != 0) goto L58;
    L60:
        if (r10 != 0) goto L66;
        if (r11 != 0) goto L66;
        if (r16 != 0) goto L65;
        if (r19 != 0) goto L65;
        return false;
    L65:
        return true;
    L66:
        float r21 = r10;
        float r22 = r11;
        if (dispatchNestedPreFling(r21, r22) == true) goto L79;
        if (r13 == true) goto L72;
        if (r14 == true) goto L72;
        boolean r23 = false;
    L73:
        dispatchNestedFling(r21, r22, r23);
        int r24 = r13;
        if (r23 == false) goto L79;
        if (r14 == false) goto L77;
        r24 = (r13 ? 1 : 0) | 2;
    L77:
        startNestedScroll(r24, 1);
        int r25 = this.f15431a0;
        int r26 = Math.max(-r25, Math.min(r10, r25));
        int r27 = this.f15431a0;
        this.f15439e0.b(r26, Math.max(-r27, Math.min(r11, r27)));
        return true;
    L72:
        r23 = true;
    L79:
        return false;
    L58:
        int r28 = this.f15431a0;
        r16 = Math.max(-r28, Math.min(r16, r28));
        int r29 = this.f15431a0;
        r19 = Math.max(-r29, Math.min(r19, r29));
        this.f15439e0.b(r16, r19);
        goto L60
    L53:
        if ((r20.c() * r11) >= 0.0f) goto L56;
    L54:
        r11 = 0;
        goto L56
    L47:
        r19 = r11;
    L55:
        r19 = 0;
        goto L56
    L36:
        if ((r17.c() * r10) >= 0.0f) goto L39;
    L37:
        r10 = 0;
        goto L39
    L30:
        r16 = r10;
    L38:
        r16 = 0;
        goto L39
    L16:
        if (Math.abs(r11) >= this.W) goto L18;
    L12:
        if (Math.abs(r10) >= this.W) goto L14;
        goto L13
    }

    public int Z(t r10) {
        if (r10.r(524) == false) goto L5;
        return -1;
    L5:
        if (r10.u() == true) goto L8;
        return -1;
    L8:
        return this.f15438e.c(r10.f15568c);
    }

    public void a(int r10, int r11) {
        if (r10 == 0) goto L8;
        L();
        if (this.f15429J.d() == false) goto L6;
    L7:
        this.f15429J.e(r10);
        goto L8
    L6:
        if (this.f15475w0 == true) goto L7;
    L8:
        if (r11 == 0) goto L14;
        M();
        if (this.K.d() == false) goto L12;
    L13:
        this.K.e(r11);
        goto L14
    L12:
        if (this.f15475w0 == true) goto L13;
    L14:
        if (r10 != 0) goto L16;
        if (r11 != 0) goto L16;
        return;
    L16:
        ViewCompat.g0(this);
    }

    public long a0(t r10) {
        if (this.f15454m.h() == false) goto L6;
        return r10.m();
    L6:
        return r10.f15568c;
    }

    public void a1() {
        int r10 = this.f15440f.j();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L17;
        t r12 = d0(this.f15440f.i(r11));
        if (E0 == false) goto L14;
        if (r12.f15568c != (-1)) goto L14;
        if (r12.x() == true) goto L14;
        throw new IllegalStateException("view holder cannot have position -1 unless it is removed" + N());
    L14:
        if (r12.L() == true) goto L16;
        r12.G();
    L16:
        r11 = r11 + 1;
        goto L3
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList r10, int r11, int r12) {
        LayoutManager r13 = this.f15456n;
        if (r13 != null) goto L5;
    L6:
        super.addFocusables(r10, r11, r12);
        return;
    L5:
        if (r13.A0(this, r10, r11, r12) == false) goto L6;
    }

    public void addOnChildAttachStateChangeListener(@NonNull OnChildAttachStateChangeListener r10) {
        if (this.E != null) goto L5;
        this.E = new ArrayList();
    L5:
        this.E.add(r10);
    }

    public void addOnItemTouchListener(@NonNull OnItemTouchListener r10) {
        this.f15464r.add(r10);
    }

    public void addOnScrollListener(@NonNull m r10) {
        if (this.f15449j0 != null) goto L5;
        this.f15449j0 = new ArrayList();
    L5:
        this.f15449j0.add(r10);
    }

    public int b0(View r10) {
        t r11 = d0(r10);
        if (r11 != null) goto L7;
        return -1;
    L7:
        return r11.j();
    }

    public boolean b1(int r17, int r18, MotionEvent r19, int r20) {
        v();
        if (this.f15454m == null) goto L5;
        int[] r10 = this.f15471u0;
        r10[0] = 0;
        r10[1] = 0;
        c1(r17, r18, r10);
        int[] r11 = this.f15471u0;
        int r12 = r11[0];
        int r13 = r11[1];
        int r14 = r17 - r12;
        int r15 = r18 - r13;
        int r16 = r13;
        int r110 = r12;
    L7:
        if (this.f15462q.isEmpty() == true) goto L9;
        invalidate();
    L9:
        int[] r21 = this.f15471u0;
        r21[0] = 0;
        r21[1] = 0;
        dispatchNestedScroll(r110, r16, r14, r15, this.f15467s0, r20, r21);
        int[] r22 = this.f15471u0;
        int r23 = r22[0];
        int r111 = r14 - r23;
        int r24 = r22[1];
        int r112 = r15 - r24;
        if (r23 != 0) goto L14;
        if (r24 != 0) goto L14;
        boolean r25 = false;
    L15:
        int r26 = this.T;
        int[] r27 = this.f15467s0;
        int r28 = r27[0];
        this.T = r26 - r28;
        int r29 = this.U;
        int r30 = r27[1];
        this.U = r29 - r30;
        int[] r31 = this.f15469t0;
        r31[0] = r31[0] + r28;
        r31[1] = r31[1] + r30;
        if (getOverScrollMode() == 2) goto L21;
        if (r19 == null) goto L21;
        if (androidx.core.view.h.a(r19, 8194) == true) goto L21;
        M0(r19.getX(), r111, r19.getY(), r112);
    L21:
        if (r110 != 0) goto L23;
        if (r16 != 0) goto L23;
    L25:
        if (awakenScrollBars() == true) goto L27;
        invalidate();
    L27:
        if (r25 == true) goto L33;
        if (r110 != 0) goto L34;
        if (r16 == 0) goto L32;
        return true;
    L32:
        return false;
    L34:
        return true;
    L33:
        return true;
    L23:
        I(r110, r16);
    L14:
        r25 = true;
        goto L15
    L5:
        r14 = 0;
        r15 = 0;
        r16 = 0;
        r110 = 0;
        goto L7
    }

    public t c0(View r10) {
        ViewParent r11 = r10.getParent();
        if (r11 == null) goto L9;
        if (r11 == this) goto L9;
        throw new IllegalArgumentException("View " + r10 + " is not a direct child of " + this);
    L9:
        return d0(r10);
    }

    public void c1(int r10, int r11, int[] r12) {
        m1();
        D0();
        androidx.core.os.g.a("RV Scroll");
        O(this.f15445h0);
        if (r10 == 0) goto L5;
        int r13 = this.f15456n.n1(r10, this.f15434c, this.f15445h0);
    L6:
        if (r11 == 0) goto L8;
        int r14 = this.f15456n.p1(r11, this.f15434c, this.f15445h0);
    L9:
        androidx.core.os.g.b();
        V0();
        E0();
        o1(false);
        if (r12 == null) goto L13;
        r12[0] = r13;
        r12[1] = r14;
        return;
    L13:
        return;
    L8:
        r14 = 0;
        goto L9
    L5:
        r13 = 0;
        goto L6
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r10) {
        if ((r10 instanceof LayoutParams) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f15456n.k((LayoutParams) r10) == false) goto L7;
        return true;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        LayoutManager r10 = this.f15456n;
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.i() == true) goto L8;
        return 0;
    L8:
        return this.f15456n.o(this.f15445h0);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        LayoutManager r10 = this.f15456n;
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.i() == true) goto L8;
        return 0;
    L8:
        return this.f15456n.p(this.f15445h0);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollRange() {
        LayoutManager r10 = this.f15456n;
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.i() == true) goto L8;
        return 0;
    L8:
        return this.f15456n.q(this.f15445h0);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollExtent() {
        LayoutManager r10 = this.f15456n;
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.j() == true) goto L8;
        return 0;
    L8:
        return this.f15456n.r(this.f15445h0);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollOffset() {
        LayoutManager r10 = this.f15456n;
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.j() == true) goto L8;
        return 0;
    L8:
        return this.f15456n.s(this.f15445h0);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollRange() {
        LayoutManager r10 = this.f15456n;
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.j() == true) goto L8;
        return 0;
    L8:
        return this.f15456n.t(this.f15445h0);
    }

    public void d1(int r10) {
        if (this.f15480z == false) goto L5;
        return;
    L5:
        p1();
        LayoutManager r11 = this.f15456n;
        if (r11 != null) goto L9;
        Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L9:
        r11.o1(r10);
        awakenScrollBars();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r10) {
        r10.save();
        com.obric.oui.orecyclerview.base.a r11 = this.f15429J;
        boolean r12 = true;
        if (r11 != null) goto L5;
    L7:
        boolean r13 = false;
    L8:
        com.obric.oui.orecyclerview.base.a r14 = this.K;
        if (r14 != null) goto L11;
    L13:
        r12 = r13;
    L14:
        z();
        super.dispatchDraw(r10);
        r10.restore();
        if (r12 == false) goto L18;
        ViewCompat.g0(this);
        return;
    L18:
        return;
    L11:
        if (r14.d() == true) goto L13;
        this.K.a();
        r10.translate(0.0f, this.K.c());
        goto L14
    L5:
        if (r11.d() == true) goto L7;
        this.f15429J.a();
        r10.translate(this.f15429J.c(), 0.0f);
        r13 = true;
        goto L8
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float r10, float r11, boolean r12) {
        return getScrollingChildHelper().a(r10, r11, r12);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float r10, float r11) {
        return getScrollingChildHelper().b(r10, r11);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int r10, int r11, int[] r12, int[] r13) {
        return getScrollingChildHelper().c(r10, r11, r12, r13);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, int[] r14) {
        return getScrollingChildHelper().f(r10, r11, r12, r13, r14);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r10) {
        onPopulateAccessibilityEvent(r10);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray r10) {
        dispatchThawSelfOnly(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray r10) {
        dispatchFreezeSelfOnly(r10);
    }

    @Override // android.view.View
    public void draw(Canvas r10) {
        super.draw(r10);
        int r11 = this.f15462q.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L6;
        ((k) this.f15462q.get(r12)).f(r10, this, this.f15445h0);
        r12 = r12 + 1;
        goto L3
    L6:
        if (this.N != null) goto L8;
        return;
    L8:
        if (this.f15462q.size() > 0) goto L10;
        return;
    L10:
        if (this.N.p() == false) goto L16;
        ViewCompat.g0(this);
        return;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r10, View r11, long r12) {
        return super.drawChild(r10, r11, r12);
    }

    public final void e1(Adapter r10, boolean r11, boolean r12) {
        Adapter r13 = this.f15454m;
        if (r13 == null) goto L5;
        r13.t(this.f15432b);
        this.f15454m.n(this);
    L5:
        if (r11 == false) goto L7;
        if (r12 == true) goto L7;
    L8:
        this.f15438e.s();
        Adapter r14 = this.f15454m;
        this.f15454m = r10;
        if (r10 == null) goto L11;
        r10.s(this.f15432b);
        r10.j(this);
    L11:
        LayoutManager r15 = this.f15456n;
        if (r15 == null) goto L14;
        r15.z0(r14, this.f15454m);
    L14:
        this.f15434c.x(r14, this.f15454m, r11);
        this.f15445h0.f15547g = true;
        return;
    L7:
        S0();
        goto L8
    }

    public boolean f1(t r10, int r11) {
        if (r0() == false) goto L6;
        r10.f15582q = r11;
        this.f15473v0.add(r10);
        return false;
    L6:
        ViewCompat.A0(r10.f15566a, r11);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View r10, int r11) {
        View r12 = this.f15456n.K0(r10, r11);
        if (r12 == null) goto L5;
        return r12;
    L5:
        boolean r13 = true;
        if (this.f15454m != null) goto L8;
    L14:
        boolean r14 = false;
    L15:
        FocusFinder r15 = FocusFinder.getInstance();
        if (r14 == true) goto L18;
    L61:
        View r16 = r15.findNextFocus(this, r10, r11);
        if (r16 != null) goto L68;
        if (r14 == false) goto L68;
        v();
        if (P(r10) != null) goto L67;
        return null;
    L67:
        m1();
        View r17 = this.f15456n.E0(r10, r11, this.f15434c, this.f15445h0);
        o1(false);
    L69:
        if (r17 == null) goto L79;
        if (r17.hasFocusable() == true) goto L79;
        if (getFocusedChild() == null) goto L75;
        W0(r17, null);
        return r10;
    L75:
        return super.focusSearch(r10, r11);
    L79:
        if (s0(r10, r17, r11) == false) goto L82;
        return r17;
    L82:
        return super.focusSearch(r10, r11);
    L68:
        r17 = r16;
        goto L69
    L18:
        if (r11 == 2) goto L21;
        if (r11 != 1) goto L61;
    L21:
        if (this.f15456n.j() == false) goto L32;
        if (r11 != 2) goto L24;
        int r18 = 130;
    L26:
        if (r15.findNextFocus(this, r10, r18) != null) goto L28;
        boolean r19 = true;
    L30:
        if (M0 == false) goto L33;
        r11 = r18;
    L33:
        if (r19 == false) goto L35;
    L55:
        if (r19 == false) goto L60;
        v();
        if (P(r10) != null) goto L59;
        return null;
    L59:
        m1();
        this.f15456n.E0(r10, r11, this.f15434c, this.f15445h0);
        o1(false);
    L60:
        r17 = r15.findNextFocus(this, r10, r11);
        goto L69
    L35:
        if (this.f15456n.i() == false) goto L55;
        if (this.f15456n.W() != 1) goto L39;
        boolean r20 = true;
    L40:
        if (r11 != 2) goto L42;
        boolean r21 = true;
    L44:
        if ((r20 ^ r21) == false) goto L46;
        int r22 = 66;
    L48:
        if (r15.findNextFocus(this, r10, r22) == null) goto L52;
        r13 = false;
    L52:
        if (M0 == false) goto L54;
        r11 = r22;
    L54:
        r19 = r13;
        goto L55
    L46:
        r22 = 17;
        goto L48
    L42:
        r21 = false;
        goto L44
    L39:
        r20 = false;
        goto L40
    L28:
        r19 = false;
        goto L30
    L24:
        r18 = 33;
        goto L26
    L32:
        r19 = false;
        goto L33
    L8:
        if (this.f15456n == null) goto L14;
        if (r0() == true) goto L14;
        if (this.f15480z == true) goto L14;
        r14 = true;
        goto L15
    }

    public final boolean g1(com.obric.oui.orecyclerview.base.a r10, int r11) {
        return true;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutManager r10 = this.f15456n;
        if (r10 == null) goto L7;
        return r10.B();
    L7:
        throw new IllegalStateException("RecyclerView has no LayoutManager" + N());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        LayoutManager r11 = this.f15456n;
        if (r11 == null) goto L7;
        return r11.C(getContext(), r10);
    L7:
        throw new IllegalStateException("RecyclerView has no LayoutManager" + N());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.fluidrecyclerview.widget.RecyclerView";
    }

    @Nullable
    public Adapter getAdapter() {
        return this.f15454m;
    }

    @Override // android.view.View
    public int getBaseline() {
        LayoutManager r10 = this.f15456n;
        if (r10 == null) goto L7;
        return r10.E();
    L7:
        return super.getBaseline();
    }

    public float getBounceTranslation() {
        com.obric.oui.orecyclerview.base.a r10 = this.K;
        if (r10 != null) goto L6;
        return 0.0f;
    L6:
        return r10.c();
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int r10, int r11) {
        ChildDrawingOrderCallback r12 = this.f15461p0;
        if (r12 != null) goto L7;
        return super.getChildDrawingOrder(r10, r11);
    L7:
        return r12.onGetChildDrawingOrder(r10, r11);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f15444h;
    }

    @Nullable
    public com.obric.oui.orecyclerview.widget.g getCompatAccessibilityDelegate() {
        return this.f15459o0;
    }

    @NonNull
    public EdgeEffectFactory getEdgeEffectFactory() {
        return null;
    }

    @Nullable
    public ItemAnimator getItemAnimator() {
        return this.N;
    }

    public int getItemDecorationCount() {
        return this.f15462q.size();
    }

    @Nullable
    public LayoutManager getLayoutManager() {
        return this.f15456n;
    }

    public int getMaxFlingVelocity() {
        return this.f15431a0;
    }

    public int getMinFlingVelocity() {
        return this.W;
    }

    public long getNanoTime() {
        if (L0 == true) goto L5;
        return 0;
    L5:
        return System.nanoTime();
    }

    @Nullable
    public l getOnFlingListener() {
        return null;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f15437d0;
    }

    @NonNull
    public n getRecycledViewPool() {
        return this.f15434c.h();
    }

    public int getScrollState() {
        return this.O;
    }

    public final void h(t r10) {
        View r11 = r10.f15566a;
        if (r11.getParent() != this) goto L5;
        boolean r12 = true;
    L6:
        this.f15434c.N(c0(r11));
        if (r10.z() == false) goto L9;
        this.f15440f.c(r11, -1, r11.getLayoutParams(), true);
        return;
    L9:
        if (r12 == true) goto L11;
        this.f15440f.b(r11, true);
        return;
    L11:
        this.f15440f.k(r11);
        return;
    L5:
        r12 = false;
        goto L6
    }

    public Rect h0(View r10) {
        LayoutParams r11 = (LayoutParams) r10.getLayoutParams();
        if (r11.f15516c == true) goto L7;
        return r11.f15515b;
    L7:
        if (this.f15445h0.d() == true) goto L9;
    L14:
        Rect r12 = r11.f15515b;
        r12.set(0, 0, 0, 0);
        int r13 = this.f15462q.size();
        int r14 = 0;
    L15:
        if (r14 >= r13) goto L17;
        this.f15448j.set(0, 0, 0, 0);
        ((k) this.f15462q.get(r14)).b(this.f15448j, r10, this, this.f15445h0);
        int r15 = r12.left;
        Rect r16 = this.f15448j;
        r12.left = r15 + r16.left;
        r12.top += r16.top;
        r12.right += r16.right;
        r12.bottom += r16.bottom;
        r14 = r14 + 1;
        goto L15
    L17:
        r11.f15516c = false;
        return r12;
    L9:
        if (r11.b() == true) goto L13;
        if (r11.d() == false) goto L14;
    L13:
        return r11.f15515b;
    }

    public boolean h1(AccessibilityEvent r10) {
        int r11 = 0;
        if (r0() == false) goto L12;
        if (r10 == null) goto L6;
        int r12 = AccessibilityEventCompat.a(r10);
    L7:
        if (r12 == 0) goto L10;
        r11 = r12;
    L10:
        this.B |= r11;
        return true;
    L6:
        r12 = 0;
        goto L7
    L12:
        return false;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().k();
    }

    public void i(k r10) {
        j(r10, -1);
    }

    public final void i0(long r10, t r11, t r12) {
        int r13 = this.f15440f.g();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L18;
        t r15 = d0(this.f15440f.f(r14));
        if (r15 == r11) goto L17;
        if (a0(r15) != r10) goto L17;
        Adapter r16 = this.f15454m;
        if (r16 == null) goto L16;
        if (r16.h() == false) goto L16;
        throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + r15 + " \n View Holder 2:" + r11 + N());
    L16:
        throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + r15 + " \n View Holder 2:" + r11 + N());
    L17:
        r14 = r14 + 1;
        goto L3
    L18:
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + r12 + " cannot be found but it is necessary for " + r11 + N());
    }

    public void i1(int r10, int r11) {
        j1(r10, r11, null);
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.f15468t;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.f15480z;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().m();
    }

    public void j(k r10, int r11) {
        LayoutManager r12 = this.f15456n;
        if (r12 == null) goto L6;
        r12.f("Cannot add item decoration during a scroll  or layout");
    L6:
        if (this.f15462q.isEmpty() == false) goto L8;
        setWillNotDraw(false);
    L8:
        if (r11 >= 0) goto L10;
        this.f15462q.add(r10);
    L11:
        t0();
        requestLayout();
        return;
    L10:
        this.f15462q.add(r11, r10);
        goto L11
    }

    public boolean j0() {
        if (this.f15474w == true) goto L5;
    L10:
        return true;
    L5:
        if (this.F == true) goto L10;
        if (this.f15438e.n() == true) goto L10;
        return false;
    }

    public void j1(int r10, int r11, Interpolator r12) {
        k1(r10, r11, r12, Integer.MIN_VALUE);
    }

    public void k(t r10, ItemAnimator.a r11, ItemAnimator.a r12) {
        r10.I(false);
        if (this.N.a(r10, r11, r12) == false) goto L6;
        I0();
        return;
    }

    public void k1(int r10, int r11, Interpolator r12, int r13) {
        l1(r10, r11, r12, r13, false);
    }

    public final void l(t r10, t r11, ItemAnimator.a r12, ItemAnimator.a r13, boolean r14, boolean r15) {
        r10.I(false);
        if (r14 == false) goto L5;
        h(r10);
    L5:
        if (r10 == r11) goto L10;
        if (r15 == false) goto L8;
        h(r11);
    L8:
        r10.f15573h = r11;
        h(r10);
        this.f15434c.N(r10);
        r11.I(false);
        r11.f15574i = r10;
    L10:
        if (this.N.b(r10, r11, r12, r13) == false) goto L13;
        I0();
        return;
    }

    public void l0() {
        this.f15438e = new AdapterHelper(new f(this));
    }

    public void l1(int r10, int r11, Interpolator r12, int r13, boolean r14) {
        LayoutManager r15 = this.f15456n;
        if (r15 != null) goto L7;
        Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L7:
        if (this.f15480z == false) goto L9;
        return;
    L9:
        int r16 = 0;
        if (r15.i() == true) goto L13;
        r10 = 0;
    L13:
        if (this.f15456n.j() == true) goto L15;
        r11 = 0;
    L15:
        if (r10 != 0) goto L18;
        if (r11 != 0) goto L18;
        return;
    L18:
        if (r13 == Integer.MIN_VALUE) goto L22;
        if (r13 > 0) goto L22;
        scrollBy(r10, r11);
        return;
    L22:
        if (r14 == true) goto L24;
    L29:
        this.f15439e0.e(r10, r11, r13, r12);
        return;
    L24:
        if (r10 == 0) goto L26;
        r16 = 1;
    L26:
        if (r11 == 0) goto L28;
        r16 = r16 | 2;
    L28:
        startNestedScroll(r16, 1);
        goto L29
    }

    public void m(t r10, ItemAnimator.a r11, ItemAnimator.a r12) {
        h(r10);
        r10.I(false);
        if (this.N.c(r10, r11, r12) == false) goto L6;
        I0();
        return;
    }

    public void m1() {
        int r10 = this.f15476x + 1;
        this.f15476x = r10;
        if (r10 == 1) goto L5;
        return;
    L5:
        if (this.f15480z == true) goto L9;
        this.f15478y = false;
        return;
    }

    public void n(String r10) {
        if (r0() == false) goto L10;
        if (r10 != null) goto L8;
        throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + N());
    L8:
        throw new IllegalStateException(r10);
    L10:
        if (this.I <= 0) goto L13;
        Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + N()));
        return;
    }

    public boolean o(t r10) {
        ItemAnimator r11 = this.N;
        if (r11 != null) goto L5;
    L8:
        return true;
    L5:
        if (r11.g(r10, r10.q()) == true) goto L8;
        return false;
    }

    public void o0(StateListDrawable r11, Drawable r12, StateListDrawable r13, Drawable r14) {
        if (r11 == null) goto L9;
        if (r12 == null) goto L9;
        if (r13 == null) goto L9;
        if (r14 == null) goto L9;
        Resources r10 = getContext().getResources();
        new com.obric.oui.orecyclerview.widget.b(this, r11, r12, r13, r14, r10.getDimensionPixelSize(R$dimen.fastscroll_default_thickness), r10.getDimensionPixelSize(R$dimen.fastscroll_minimum_range), r10.getDimensionPixelOffset(R$dimen.fastscroll_margin));
        return;
    L9:
        throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + N());
    }

    public void o1(boolean r10) {
        if (this.f15476x >= 1) goto L10;
        if (E0 == true) goto L8;
        this.f15476x = 1;
        goto L10
    L8:
        throw new IllegalStateException("stopInterceptRequestLayout was called more times than startInterceptRequestLayout." + N());
    L10:
        if (r10 == true) goto L15;
        if (this.f15480z == true) goto L15;
        this.f15478y = false;
    L15:
        if (this.f15476x != 1) goto L29;
        if (r10 == false) goto L27;
        if (this.f15478y == false) goto L27;
        if (this.f15480z == true) goto L27;
        if (this.f15456n == null) goto L27;
        if (this.f15454m == null) goto L27;
        D();
    L27:
        if (this.f15480z == true) goto L29;
        this.f15478y = false;
    L29:
        this.f15476x--;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.H = 0;
        boolean r10 = true;
        this.f15468t = true;
        if (this.f15474w == true) goto L5;
    L7:
        r10 = false;
    L8:
        this.f15474w = r10;
        this.f15434c.y();
        LayoutManager r11 = this.f15456n;
        if (r11 == null) goto L11;
        r11.y(this);
    L11:
        this.f15457n0 = false;
        if (L0 == false) goto L25;
        ThreadLocal r12 = com.obric.oui.orecyclerview.widget.c.f15681e;
        com.obric.oui.orecyclerview.widget.c r13 = (com.obric.oui.orecyclerview.widget.c) r12.get();
        this.f15441f0 = r13;
        if (r13 != null) goto L23;
        this.f15441f0 = new com.obric.oui.orecyclerview.widget.c();
        Display r14 = ViewCompat.u(this);
        if (isInEditMode() == true) goto L21;
        if (r14 == null) goto L21;
        float r15 = r14.getRefreshRate();
        if (r15 < 30.0f) goto L21;
    L22:
        com.obric.oui.orecyclerview.widget.c r16 = this.f15441f0;
        r16.f15685c = (long) (1.0E9f / r15);
        r12.set(r16);
    L21:
        r15 = 60.0f;
    L23:
        this.f15441f0.a(this);
        return;
    L25:
        return;
    L5:
        if (isLayoutRequested() == true) goto L7;
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ItemAnimator r10 = this.N;
        if (r10 == null) goto L5;
        r10.k();
    L5:
        p1();
        this.f15468t = false;
        LayoutManager r11 = this.f15456n;
        if (r11 == null) goto L8;
        r11.z(this, this.f15434c);
    L8:
        this.f15473v0.clear();
        removeCallbacks(this.f15479y0);
        this.f15442g.j();
        this.f15434c.z();
        t.a.b(this);
        if (L0 == false) goto L14;
        com.obric.oui.orecyclerview.widget.c r12 = this.f15441f0;
        if (r12 == null) goto L15;
        r12.j(this);
        this.f15441f0 = null;
        return;
    L15:
        return;
    }

    @Override // android.view.View
    public void onDraw(Canvas r10) {
        super.onDraw(r10);
        int r11 = this.f15462q.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        ((k) this.f15462q.get(r12)).d(r10, this, this.f15445h0);
        r12 = r12 + 1;
        goto L3
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent r10) {
        if (this.f15456n != null) goto L6;
        return false;
    L6:
        if (this.f15480z == false) goto L9;
        return false;
    L9:
        if (r10.getAction() == 8) goto L11;
    L34:
        return false;
    L11:
        if ((r10.getSource() & 2) == 0) goto L21;
        if (this.f15456n.j() == false) goto L15;
        float r11 = -r10.getAxisValue(9);
    L17:
        if (this.f15456n.i() == false) goto L19;
        float r12 = r10.getAxisValue(10);
    L30:
        if (r11 == 0.0f) goto L32;
    L33:
        v0((int) (r12 * this.f15433b0), (int) (r11 * this.f15435c0), r10, 1);
        goto L34
    L32:
        if (r12 == 0.0f) goto L34;
    L19:
        r12 = 0.0f;
        goto L30
    L15:
        r11 = 0.0f;
        goto L17
    L21:
        if ((r10.getSource() & UiType.FLAG_NO_FEEDBACK) == 0) goto L28;
        float r13 = r10.getAxisValue(26);
        if (this.f15456n.j() == false) goto L26;
        r11 = -r13;
        goto L19
    L26:
        if (this.f15456n.i() == false) goto L28;
        r12 = r13;
        r11 = 0.0f;
    L28:
        r11 = 0.0f;
        r12 = 0.0f;
        goto L30
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        if (this.f15480z == false) goto L5;
        return false;
    L5:
        this.f15466s = null;
        if (R(r10) == false) goto L9;
        p();
        return true;
    L9:
        LayoutManager r11 = this.f15456n;
        if (r11 != null) goto L12;
        return false;
    L12:
        boolean r12 = r11.i();
        boolean r13 = this.f15456n.j();
        if (this.Q != null) goto L15;
        this.Q = com.obric.oui.orecyclerview.base.h.a(getContext());
    L15:
        this.Q.addMovement(r10);
        int r14 = r10.getActionMasked();
        int r15 = r10.getActionIndex();
        if (r14 == 0) goto L50;
        if (r14 == 1) goto L47;
        if (r14 != 2) goto L20;
        int r16 = r10.findPointerIndex(this.P);
        if (r16 >= 0) goto L33;
        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.P + " not found. Did any MotionEvents get skipped?");
        return false;
    L33:
        int r17 = (int) (r10.getX(r16) + 0.5f);
        int r18 = (int) (r10.getY(r16) + 0.5f);
        if (this.O == 1) goto L48;
        int r19 = r17 - this.R;
        int r20 = r18 - this.S;
        if (r12 == true) goto L38;
    L40:
        boolean r21 = false;
    L41:
        if (r13 == true) goto L43;
    L45:
        if (r21 == false) goto L48;
        setScrollState(1);
        goto L48
    L43:
        if (Math.abs(r20) <= this.V) goto L45;
        this.U = r18;
        r21 = true;
        goto L45
    L38:
        if (Math.abs(r19) <= this.V) goto L40;
        this.T = r17;
        r21 = true;
    L48:
        boolean r22 = false;
    L63:
        if (r22 == false) goto L65;
        return false;
    L65:
        if (this.O == 1) goto L67;
        return false;
    L67:
        return true;
    L20:
        if (r14 != 3) goto L22;
        p();
        goto L48
    L22:
        if (r14 != 5) goto L24;
        this.P = r10.getPointerId(r15);
        int r23 = (int) (r10.getX(r15) + 0.5f);
        this.T = r23;
        this.R = r23;
        int r24 = (int) (r10.getY(r15) + 0.5f);
        this.U = r24;
        this.S = r24;
        goto L48
    L24:
        if (r14 != 6) goto L48;
        onPointerUp(r10);
        goto L48
    L47:
        this.Q.clear();
        stopNestedScroll(0);
        goto L48
    L50:
        if (this.A == false) goto L52;
        this.A = false;
    L52:
        this.P = r10.getPointerId(0);
        int r25 = (int) (r10.getX() + 0.5f);
        this.T = r25;
        this.R = r25;
        int r26 = (int) (r10.getY() + 0.5f);
        this.U = r26;
        this.S = r26;
        r22 = this.C0.a(r10, false);
        if (r22 == false) goto L55;
    L59:
        int[] r27 = this.f15469t0;
        r27[1] = 0;
        r27[0] = 0;
        int r28 = r12;
        if (r13 == false) goto L62;
        r28 = (r12 ? 1 : 0) | 2;
    L62:
        startNestedScroll(r28, 0);
        goto L63
    L55:
        if (n1(r10) == false) goto L57;
    L58:
        getParent().requestDisallowInterceptTouchEvent(true);
        setScrollState(1);
        stopNestedScroll(1);
        goto L59
    L57:
        if (this.O != 2) goto L59;
        goto L58
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        androidx.core.os.g.a("RV OnLayout");
        D();
        androidx.core.os.g.b();
        this.f15474w = true;
    }

    @Override // android.view.View
    public void onMeasure(int r10, int r11) {
        LayoutManager r12 = this.f15456n;
        if (r12 != null) goto L6;
        x(r10, r11);
        return;
    L6:
        boolean r13 = false;
        if (r12.n0() == false) goto L26;
        int r14 = View.MeasureSpec.getMode(r10);
        int r15 = View.MeasureSpec.getMode(r11);
        this.f15456n.T0(this.f15434c, this.f15445h0, r10, r11);
        if (r14 != 1073741824) goto L12;
        if (r15 != 1073741824) goto L12;
        r13 = true;
    L12:
        this.f15481z0 = r13;
        if (r13 == false) goto L15;
        return;
    L15:
        if (this.f15454m != null) goto L18;
        return;
    L18:
        if (this.f15445h0.f15545e != 1) goto L20;
        E();
    L20:
        this.f15456n.r1(r10, r11);
        this.f15445h0.f15550j = true;
        F();
        this.f15456n.u1(r10, r11);
        if (this.f15456n.x1() == false) goto L23;
        this.f15456n.r1(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), Ints.MAX_POWER_OF_TWO));
        this.f15445h0.f15550j = true;
        F();
        this.f15456n.u1(r10, r11);
    L23:
        this.A0 = getMeasuredWidth();
        this.B0 = getMeasuredHeight();
        return;
    L26:
        if (this.f15470u == false) goto L30;
        this.f15456n.T0(this.f15434c, this.f15445h0, r10, r11);
        return;
    L30:
        if (this.C == false) goto L37;
        m1();
        D0();
        K0();
        E0();
        q r16 = this.f15445h0;
        if (r16.f15552l == false) goto L34;
        r16.f15548h = true;
    L35:
        this.C = false;
        o1(false);
    L40:
        Adapter r17 = this.f15454m;
        if (r17 == null) goto L43;
        this.f15445h0.f15546f = r17.e();
    L44:
        m1();
        this.f15456n.T0(this.f15434c, this.f15445h0, r10, r11);
        o1(false);
        this.f15445h0.f15548h = false;
        return;
    L43:
        this.f15445h0.f15546f = 0;
        goto L44
    L34:
        this.f15438e.h();
        this.f15445h0.f15548h = false;
        goto L35
    L37:
        if (this.f15445h0.f15552l == false) goto L40;
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int r10, Rect r11) {
        if (r0() == false) goto L7;
        return false;
    L7:
        return super.onRequestFocusInDescendants(r10, r11);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        SavedState r11 = (SavedState) r10;
        this.f15436d = r11;
        super.onRestoreInstanceState(r11.getSuperState());
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        SavedState r11 = this.f15436d;
        if (r11 == null) goto L5;
        r10.copyFrom(r11);
    L9:
        return r10;
    L5:
        LayoutManager r12 = this.f15456n;
        if (r12 == null) goto L8;
        r10.mLayoutState = r12.X0();
        goto L9
    L8:
        r10.mLayoutState = null;
        goto L9
    }

    @Override // android.view.View
    public void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        if (r10 != r12) goto L5;
        if (r11 != r13) goto L5;
        return;
    L5:
        p0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r18) {
        if (this.f15480z == false) goto L5;
    L106:
        return false;
    L5:
        if (this.A == true) goto L106;
        if (K(r18) == false) goto L11;
        p();
        return true;
    L11:
        LayoutManager r10 = this.f15456n;
        if (r10 != null) goto L14;
        return false;
    L14:
        boolean r11 = r10.i();
        boolean r12 = this.f15456n.j();
        if (this.Q != null) goto L17;
        this.Q = com.obric.oui.orecyclerview.base.h.a(getContext());
    L17:
        int r13 = r18.getActionMasked();
        int r14 = r18.getActionIndex();
        if (r13 != 0) goto L20;
        int[] r15 = this.f15469t0;
        r15[1] = 0;
        r15[0] = 0;
    L20:
        MotionEvent r16 = MotionEvent.obtain(r18);
        int[] r17 = this.f15469t0;
        r16.offsetLocation(r17[0], r17[1]);
        if (r13 != 0) goto L23;
        this.P = r18.getPointerId(0);
        int r19 = (int) (r18.getX() + 0.5f);
        this.T = r19;
        this.R = r19;
        int r20 = (int) (r18.getY() + 0.5f);
        this.U = r20;
        this.S = r20;
        int r110 = r11;
        if (r12 == false) goto L102;
        r110 = (r11 ? 1 : 0) | 2;
    L102:
        startNestedScroll(r110, 0);
    L103:
        this.Q.addMovement(r16);
    L104:
        r16.recycle();
        return true;
    L23:
        if (r13 != 1) goto L25;
        this.Q.addMovement(r16);
        this.Q.computeCurrentVelocity(1000, this.f15431a0);
        if (r11 == false) goto L87;
        float r21 = -this.Q.getXVelocity(this.P);
    L88:
        if (r12 == false) goto L90;
        float r22 = -this.Q.getYVelocity(this.P);
    L91:
        Log.d("RecyclerView", "TouchUp, Velocity: x: " + r21 + ", y: " + r22);
        if (r21 != 0.0f) goto L96;
        if (r22 != 0.0f) goto L96;
    L97:
        Log.d("RecyclerView", "No fling, setting scroll state to idle");
        setScrollState(0);
    L98:
        Y0();
    L96:
        if (Y((int) r21, (int) r22) == true) goto L98;
    L90:
        r22 = 0.0f;
        goto L91
    L87:
        r21 = 0.0f;
        goto L88
    L25:
        if (r13 != 2) goto L27;
        int r23 = r18.findPointerIndex(this.P);
        if (r23 >= 0) goto L40;
        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.P + " not found. Did any MotionEvents get skipped?");
        return false;
    L40:
        int r111 = (int) (r18.getX(r23) + 0.5f);
        int r112 = (int) (r18.getY(r23) + 0.5f);
        int r24 = this.T - r111;
        int r25 = this.U - r112;
        if (this.O == 1) goto L58;
        if (r11 == false) goto L48;
        if (r24 <= 0) goto L45;
        r24 = Math.max(0, r24 - this.V);
    L46:
        if (r24 == 0) goto L48;
        boolean r26 = true;
    L49:
        if (r12 == false) goto L55;
        if (r25 <= 0) goto L52;
        r25 = Math.max(0, r25 - this.V);
    L53:
        if (r25 == 0) goto L55;
        r26 = true;
        goto L55
    L52:
        r25 = Math.min(0, r25 + this.V);
    L55:
        if (r26 == false) goto L58;
        setScrollState(1);
        goto L58
    L45:
        r24 = Math.min(0, r24 + this.V);
    L48:
        r26 = false;
    L58:
        if (this.O != 1) goto L103;
        int[] r27 = this.f15471u0;
        r27[0] = 0;
        r27[1] = 0;
        int r113 = r24 - Q0(r24, r18.getY());
        int r114 = r25 - R0(r25, r18.getX());
        if (r11 == false) goto L62;
        int r28 = r113;
    L63:
        if (r12 == false) goto L65;
        int r29 = r114;
    L67:
        if (dispatchNestedPreScroll(r28, r29, this.f15471u0, this.f15467s0, 0) == false) goto L69;
        int[] r30 = this.f15471u0;
        r113 = r113 - r30[0];
        r114 = r114 - r30[1];
        int[] r31 = this.f15469t0;
        int r32 = r31[0];
        int[] r33 = this.f15467s0;
        r31[0] = r32 + r33[0];
        r31[1] = r31[1] + r33[1];
        getParent().requestDisallowInterceptTouchEvent(true);
    L69:
        int r34 = r114;
        int[] r35 = this.f15467s0;
        this.T = r111 - r35[0];
        this.U = r112 - r35[1];
        if (r11 == false) goto L72;
        int r36 = r113;
    L73:
        if (r12 == false) goto L75;
        int r37 = r34;
    L77:
        if (b1(r36, r37, r18, 0) == false) goto L79;
        getParent().requestDisallowInterceptTouchEvent(true);
    L79:
        com.obric.oui.orecyclerview.widget.c r38 = this.f15441f0;
        if (r38 == null) goto L103;
        if (r113 != 0) goto L83;
        if (r34 == 0) goto L103;
    L83:
        r38.f(this, r113, r34);
        goto L103
    L75:
        r37 = 0;
        goto L77
    L72:
        r36 = 0;
        goto L73
    L65:
        r29 = 0;
        goto L67
    L62:
        r28 = 0;
        goto L63
    L27:
        if (r13 != 3) goto L29;
        p();
        goto L103
    L29:
        if (r13 != 5) goto L31;
        this.P = r18.getPointerId(r14);
        int r39 = (int) (r18.getX(r14) + 0.5f);
        this.T = r39;
        this.R = r39;
        int r40 = (int) (r18.getY(r14) + 0.5f);
        this.U = r40;
        this.S = r40;
        goto L103
    L31:
        if (r13 != 6) goto L103;
        onPointerUp(r18);
        goto L103
    }

    public void p0() {
        this.K = null;
        this.f15429J = null;
    }

    public void p1() {
        setScrollState(0);
        q1();
    }

    public boolean q0() {
        AccessibilityManager r10 = this.D;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isEnabled() == false) goto L7;
        return true;
    }

    public void r() {
        int r10 = this.f15440f.j();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        t r12 = d0(this.f15440f.i(r11));
        if (r12.L() == true) goto L7;
        r12.c();
    L7:
        r11 = r11 + 1;
        goto L3
    L8:
        this.f15434c.d();
    }

    public boolean r0() {
        if (this.H <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void r1(int r10, int r11, Object r12) {
        int r13 = this.f15440f.j();
        int r14 = r10 + r11;
        int r15 = 0;
    L3:
        if (r15 >= r13) goto L14;
        View r16 = this.f15440f.i(r15);
        t r17 = d0(r16);
        if (r17 == null) goto L13;
        if (r17.L() == true) goto L13;
        int r18 = r17.f15568c;
        if (r18 < r10) goto L13;
        if (r18 >= r14) goto L13;
        r17.b(2);
        r17.a(r12);
        ((LayoutParams) r16.getLayoutParams()).f15516c = true;
    L13:
        r15 = r15 + 1;
        goto L3
    L14:
        this.f15434c.Q(r10, r11);
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View r10, boolean r11) {
        t r12 = d0(r10);
        if (r12 == null) goto L13;
        if (r12.z() == false) goto L8;
        r12.f();
    L14:
        r10.clearAnimation();
        B(r10);
        super.removeDetachedView(r10, r11);
        return;
    L8:
        if (r12.L() == true) goto L14;
        throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + r12 + N());
    L13:
        if (E0 == false) goto L14;
        throw new IllegalArgumentException("No ViewHolder found for child: " + r10 + N());
    }

    public void removeOnChildAttachStateChangeListener(@NonNull OnChildAttachStateChangeListener r10) {
        List r11 = this.E;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.remove(r10);
    }

    public void removeOnItemTouchListener(@NonNull OnItemTouchListener r10) {
        this.f15464r.remove(r10);
        if (this.f15466s != r10) goto L6;
        this.f15466s = null;
        return;
    }

    public void removeOnScrollListener(@NonNull m r10) {
        List r11 = this.f15449j0;
        if (r11 == null) goto L6;
        r11.remove(r10);
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View r10, View r11) {
        if (this.f15456n.V0(this, this.f15445h0, r10, r11) == true) goto L6;
        if (r11 == null) goto L6;
        W0(r10, r11);
    L6:
        super.requestChildFocus(r10, r11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View r10, Rect r11, boolean r12) {
        return this.f15456n.j1(this, r10, r11, r12);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r10) {
        int r11 = this.f15464r.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        ((OnItemTouchListener) this.f15464r.get(r12)).onRequestDisallowInterceptTouchEvent(r10);
        r12 = r12 + 1;
        goto L3
    L5:
        super.requestDisallowInterceptTouchEvent(r10);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f15476x == 0) goto L5;
    L7:
        this.f15478y = true;
        return;
    L5:
        if (this.f15480z == true) goto L7;
        super.requestLayout();
    }

    public int s(int r10) {
        return t(r10, this.f15429J);
    }

    @Override // android.view.View
    public void scrollBy(int r10, int r11) {
        LayoutManager r12 = this.f15456n;
        if (r12 != null) goto L7;
        Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L7:
        if (this.f15480z == false) goto L9;
        return;
    L9:
        boolean r13 = r12.i();
        boolean r14 = this.f15456n.j();
        if (r13 == true) goto L13;
        if (r14 == true) goto L13;
        return;
    L13:
        if (r13 == true) goto L16;
        r10 = 0;
    L16:
        if (r14 == true) goto L19;
        r11 = 0;
    L19:
        b1(r10, r11, null, 0);
    }

    @Override // android.view.View
    public void scrollTo(int r10, int r11) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent r10) {
        if (h1(r10) == false) goto L5;
        return;
    L5:
        super.sendAccessibilityEventUnchecked(r10);
    }

    public void setAccessibilityDelegateCompat(@Nullable com.obric.oui.orecyclerview.widget.g r10) {
        this.f15459o0 = r10;
        ViewCompat.p0(this, r10);
    }

    public void setAdapter(@Nullable Adapter r10) {
        setLayoutFrozen(false);
        e1(r10, false, true);
        L0(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(@Nullable ChildDrawingOrderCallback r10) {
        if (r10 != this.f15461p0) goto L5;
        return;
    L5:
        this.f15461p0 = r10;
        if (r10 == null) goto L8;
        boolean r11 = true;
    L9:
        setChildrenDrawingOrderEnabled(r11);
        return;
    L8:
        r11 = false;
        goto L9
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean r10) {
        if (r10 == this.f15444h) goto L5;
        p0();
    L5:
        this.f15444h = r10;
        super.setClipToPadding(r10);
        if (this.f15474w == false) goto L9;
        requestLayout();
        return;
    }

    public void setEdgeEffectFactory(@NonNull EdgeEffectFactory r10) {
    }

    public void setEnableOverFling(boolean r10) {
        this.f15475w0 = r10;
    }

    public void setHasFixedSize(boolean r10) {
        this.f15470u = r10;
    }

    public void setItemAnimator(@Nullable ItemAnimator r10) {
        ItemAnimator r11 = this.N;
        if (r11 == null) goto L5;
        r11.k();
        this.N.v(null);
    L5:
        this.N = r10;
        if (r10 == null) goto L9;
        r10.v(this.f15455m0);
        return;
    }

    public void setItemViewCacheSize(int r10) {
        this.f15434c.K(r10);
    }

    @Deprecated
    public void setLayoutFrozen(boolean r10) {
        suppressLayout(r10);
    }

    public void setLayoutManager(@Nullable LayoutManager r10) {
        if (r10 != this.f15456n) goto L5;
        return;
    L5:
        p1();
        if (this.f15456n == null) goto L14;
        ItemAnimator r11 = this.N;
        if (r11 == null) goto L10;
        r11.k();
    L10:
        this.f15456n.d1(this.f15434c);
        this.f15456n.e1(this.f15434c);
        this.f15434c.c();
        if (this.f15468t == false) goto L13;
        this.f15456n.z(this, this.f15434c);
    L13:
        this.f15456n.v1(null);
        this.f15456n = null;
    L15:
        this.f15440f.o();
        this.f15456n = r10;
        if (r10 != null) goto L18;
    L24:
        this.f15434c.O();
        requestLayout();
        return;
    L18:
        if (r10.f15496b != null) goto L23;
        r10.v1(this);
        if (this.f15468t == false) goto L24;
        this.f15456n.y(this);
        goto L24
    L23:
        throw new IllegalArgumentException("LayoutManager " + r10 + " is already attached to a RecyclerView:" + r10.f15496b.N());
    L14:
        this.f15434c.c();
        goto L15
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition r10) {
        if (r10 != null) goto L6;
        super.setLayoutTransition(null);
        return;
    L6:
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    public void setMinFlingVelocity(int r10) {
        this.W = r10;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r10) {
        getScrollingChildHelper().n(r10);
    }

    public void setOnBounceTranslationListener(@Nullable OnBounceTranslationListener r10) {
        this.L = r10;
        z();
    }

    public void setOnFlingListener(@Nullable l r10) {
    }

    @Deprecated
    public void setOnScrollListener(@Nullable m r10) {
        this.f15447i0 = r10;
    }

    public void setPreserveFocusAfterLayout(boolean r10) {
        this.f15437d0 = r10;
    }

    public void setRecycledViewPool(@Nullable n r10) {
        this.f15434c.I(r10);
    }

    @Deprecated
    public void setRecyclerListener(@Nullable RecyclerListener r10) {
        this.f15458o = r10;
    }

    public void setScrollState(int r10) {
        if (r10 != this.O) goto L6;
        return;
    L6:
        if (F0 == false) goto L8;
        Log.d("RecyclerView", "setting scroll state to " + r10 + " from " + this.O, new Exception());
    L8:
        this.O = r10;
        if (r10 == 2) goto L11;
        q1();
    L11:
        H(r10);
    }

    public void setScrollingTouchSlop(int r10) {
        ViewConfiguration r11 = ViewConfiguration.get(getContext());
        if (r10 != 0) goto L5;
    L8:
        this.V = r11.getScaledTouchSlop();
        return;
    L5:
        if (r10 == 1) goto L7;
        Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + r10 + "; using default value");
        goto L8
    L7:
        this.V = r11.getScaledPagingTouchSlop();
    }

    public void setViewCacheExtension(@Nullable r r10) {
        this.f15434c.J(r10);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int r10) {
        return getScrollingChildHelper().p(r10);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        getScrollingChildHelper().r();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean r10) {
        if (r10 == this.f15480z) goto L16;
        n("Do not suppressLayout in layout or scroll");
        if (r10 == true) goto L14;
        this.f15480z = false;
        if (this.f15478y == true) goto L9;
    L13:
        this.f15478y = false;
        return;
    L9:
        if (this.f15456n == null) goto L13;
        if (this.f15454m == null) goto L13;
        requestLayout();
        goto L13
    L14:
        long r11 = SystemClock.uptimeMillis();
        onTouchEvent(MotionEvent.obtain(r11, r11, 3, 0.0f, 0.0f, 0));
        this.f15480z = true;
        this.A = true;
        p1();
        return;
    }

    public final int t(int r10, com.obric.oui.orecyclerview.base.a r11) {
        if (r10 == 0) goto L11;
        if (r11 != null) goto L5;
        return r10;
    L5:
        if (r11.c() == 0.0f) goto L13;
        int r12 = (int) r11.f(r10, true, this.f15477x0);
        if (r10 <= 0) goto L10;
        return r10 - r12;
    L10:
        return r10 + r12;
    L13:
        return r10;
    L11:
        return r10;
    }

    public void t0() {
        int r10 = this.f15440f.j();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        ((LayoutParams) this.f15440f.i(r11).getLayoutParams()).f15516c = true;
        r11 = r11 + 1;
        goto L3
    L5:
        this.f15434c.r();
    }

    public int u(int r10) {
        return t(r10, this.K);
    }

    public void u0() {
        int r10 = this.f15440f.j();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L10;
        t r12 = d0(this.f15440f.i(r11));
        if (r12 == null) goto L9;
        if (r12.L() == true) goto L9;
        r12.b(6);
    L9:
        r11 = r11 + 1;
        goto L3
    L10:
        t0();
        this.f15434c.s();
    }

    public void v() {
        if (this.f15474w == true) goto L5;
    L25:
        androidx.core.os.g.a("RV FullInvalidate");
        D();
        androidx.core.os.g.b();
        return;
    L5:
        if (this.F == true) goto L25;
        if (this.f15438e.n() == true) goto L11;
        return;
    L11:
        if (this.f15438e.m(4) == false) goto L22;
        if (this.f15438e.m(11) == true) goto L22;
        androidx.core.os.g.a("RV PartialInvalidate");
        m1();
        D0();
        this.f15438e.q();
        if (this.f15478y == false) goto L17;
    L20:
        o1(true);
        E0();
        androidx.core.os.g.b();
        return;
    L17:
        if (k0() == false) goto L19;
        D();
        goto L20
    L19:
        this.f15438e.g();
    L22:
        if (this.f15438e.n() == false) goto L28;
        androidx.core.os.g.a("RV FullInvalidate");
        D();
        androidx.core.os.g.b();
        return;
    }

    public void w0(int r10) {
        int r11 = this.f15440f.g();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.f15440f.f(r12).offsetLeftAndRight(r10);
        r12 = r12 + 1;
        goto L3
    }

    public void x(int r10, int r11) {
        setMeasuredDimension(LayoutManager.l(r10, getPaddingLeft() + getPaddingRight(), ViewCompat.C(this)), LayoutManager.l(r11, getPaddingTop() + getPaddingBottom(), ViewCompat.B(this)));
    }

    public void x0(int r10) {
        int r11 = this.f15440f.g();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.f15440f.f(r12).offsetTopAndBottom(r10);
        r12 = r12 + 1;
        goto L3
    }

    public void y0(int r10, int r11) {
        int r12 = this.f15440f.j();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L15;
        t r14 = d0(this.f15440f.i(r13));
        if (r14 == null) goto L14;
        if (r14.L() == true) goto L14;
        if (r14.f15568c < r10) goto L14;
        if (F0 == false) goto L13;
        Log.d("RecyclerView", "offsetPositionRecordsForInsert attached child " + r13 + " holder " + r14 + " now at position " + (r14.f15568c + r11));
    L13:
        r14.C(r11, false);
        this.f15445h0.f15547g = true;
    L14:
        r13 = r13 + 1;
        goto L3
    L15:
        this.f15434c.u(r10, r11);
        requestLayout();
    }

    public final void z() {
        float r10 = getBounceTranslation();
        OnBounceTranslationListener r11 = this.L;
        if (r11 != null) goto L5;
    L7:
        this.M = r10;
        return;
    L5:
        if (r10 == this.M) goto L7;
        r11.onTranslationChanged(r10);
        goto L7
    }

    public void z0(int r11, int r12) {
        int r10 = this.f15440f.j();
        if (r11 >= r12) goto L5;
        int r13 = -1;
        int r14 = r11;
        int r15 = r12;
    L6:
        int r16 = 0;
    L7:
        if (r16 >= r10) goto L23;
        t r17 = d0(this.f15440f.i(r16));
        if (r17 == null) goto L22;
        int r18 = r17.f15568c;
        if (r18 < r14) goto L22;
        if (r18 > r15) goto L22;
        if (F0 == false) goto L18;
        Log.d("RecyclerView", "offsetPositionRecordsForMove attached child " + r16 + " holder " + r17);
    L18:
        if (r17.f15568c != r11) goto L20;
        r17.C(r12 - r11, false);
    L21:
        this.f15445h0.f15547g = true;
        goto L22
    L20:
        r17.C(r13, false);
    L22:
        r16 = r16 + 1;
        goto L7
    L23:
        this.f15434c.v(r11, r12);
        requestLayout();
        return;
    L5:
        r15 = r11;
        r14 = r12;
        r13 = 1;
        goto L6
    }

    public RecyclerView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R$attr.recyclerViewStyle);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int r10, int r11, int[] r12, int[] r13, int r14) {
        return getScrollingChildHelper().d(r10, r11, r12, r13, r14);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, int[] r14, int r15) {
        return getScrollingChildHelper().g(r10, r11, r12, r13, r14, r15);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int r10) {
        return getScrollingChildHelper().l(r10);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int r10, int r11) {
        return getScrollingChildHelper().q(r10, r11);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int r10) {
        getScrollingChildHelper().s(r10);
    }

    public RecyclerView(@NonNull Context r16, @Nullable AttributeSet r17, int r18) {
        super(r16, r17, r18);
        this.f15432b = new p(this);
        this.f15434c = new o(this);
        this.f15442g = new ViewInfoStore();
        this.f15446i = new a(this);
        this.f15448j = new Rect();
        this.f15450k = new Rect();
        this.f15452l = new RectF();
        this.f15460p = new ArrayList();
        this.f15462q = new ArrayList();
        this.f15464r = new ArrayList();
        this.f15476x = 0;
        this.F = false;
        this.G = false;
        this.H = 0;
        this.I = 0;
        this.M = 0.0f;
        this.N = new com.obric.oui.orecyclerview.widget.a();
        this.O = 0;
        this.P = -1;
        this.f15433b0 = Float.MIN_VALUE;
        this.f15435c0 = Float.MIN_VALUE;
        this.f15437d0 = true;
        this.f15439e0 = new s(this);
        if (L0 == false) goto L5;
        com.obric.oui.orecyclerview.widget.c.b r10 = new com.obric.oui.orecyclerview.widget.c.b();
    L6:
        this.f15443g0 = r10;
        this.f15445h0 = new q();
        this.f15451k0 = false;
        this.f15453l0 = false;
        this.f15455m0 = new j(this);
        this.f15457n0 = false;
        this.f15463q0 = new int[2];
        this.f15467s0 = new int[2];
        this.f15469t0 = new int[2];
        this.f15471u0 = new int[2];
        this.f15473v0 = new ArrayList();
        this.f15475w0 = true;
        this.f15477x0 = true;
        this.f15479y0 = new b(this);
        this.A0 = 0;
        this.B0 = 0;
        this.D0 = new d(this);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration r11 = ViewConfiguration.get(r16);
        this.V = r11.getScaledTouchSlop();
        this.f15433b0 = androidx.core.view.n.a(r11, r16);
        this.f15435c0 = androidx.core.view.n.b(r11, r16);
        this.W = r11.getScaledMinimumFlingVelocity();
        this.f15431a0 = r11.getScaledMaximumFlingVelocity();
        this.f15430a = ((r16.getResources().getDisplayMetrics().density * 160.0f) * 386.0878f) * 0.84f;
        if (getOverScrollMode() != 2) goto L9;
        boolean r12 = true;
    L10:
        setWillNotDraw(r12);
        this.N.v(this.f15455m0);
        l0();
        n0();
        m0();
        if (ViewCompat.y(this) != 0) goto L13;
        ViewCompat.A0(this, 1);
    L13:
        this.D = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new com.obric.oui.orecyclerview.widget.g(this));
        int[] r13 = R$styleable.RecyclerView;
        TypedArray r14 = r16.obtainStyledAttributes(r17, r13, r18, 0);
        ViewCompat.n0(this, r16, r13, r17, r14, r18, 0);
        String r15 = r14.getString(R$styleable.RecyclerView_layoutManager);
        if (r14.getInt(R$styleable.RecyclerView_android_descendantFocusability, -1) != (-1)) goto L16;
        setDescendantFocusability(UiType.FLAG_TIMER_CARD);
    L16:
        this.f15444h = r14.getBoolean(R$styleable.RecyclerView_android_clipToPadding, true);
        boolean r19 = r14.getBoolean(R$styleable.RecyclerView_fastScrollEnabled, false);
        this.f15472v = r19;
        if (r19 == false) goto L19;
        o0((StateListDrawable) r14.getDrawable(R$styleable.RecyclerView_fastScrollVerticalThumbDrawable), r14.getDrawable(R$styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) r14.getDrawable(R$styleable.RecyclerView_fastScrollHorizontalThumbDrawable), r14.getDrawable(R$styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
    L19:
        r14.recycle();
        w(r16, r15, r17, r18, 0);
        int[] r20 = G0;
        TypedArray r110 = r16.obtainStyledAttributes(r17, r20, r18, 0);
        ViewCompat.n0(this, r16, r20, r17, r110, r18, 0);
        boolean r21 = r110.getBoolean(0, true);
        r110.recycle();
        setNestedScrollingEnabled(r21);
        t.a.d(this, true);
        this.C0 = new com.obric.oui.orecyclerview.widget.h(this);
        return;
    L9:
        r12 = false;
        goto L10
    L5:
        r10 = null;
        goto L6
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public final void dispatchNestedScroll(int r10, int r11, int r12, int r13, int[] r14, int r15, int[] r16) {
        getScrollingChildHelper().e(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        LayoutManager r11 = this.f15456n;
        if (r11 == null) goto L7;
        return r11.D(r10);
    L7:
        throw new IllegalStateException("RecyclerView has no LayoutManager" + N());
    }
}
