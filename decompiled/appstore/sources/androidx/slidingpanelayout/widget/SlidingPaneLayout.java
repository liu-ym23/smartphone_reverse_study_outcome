package androidx.slidingpanelayout.widget;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.e;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.Openable;
import androidx.transition.ChangeBounds;
import androidx.transition.p;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowInfoTracker;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class SlidingPaneLayout extends ViewGroup implements Openable {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static boolean f4746y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f4749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f4750d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f4751e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f4752f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f4753g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f4754h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f4755i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f4756j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f4757k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f4758l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f4759m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List f4760n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public PanelSlideListener f4761o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final androidx.customview.widget.b f4762p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f4763q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f4764r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Rect f4765s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ArrayList f4766t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f4767u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public FoldingFeature f4768v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public FoldingFeatureObserver.OnFoldingFeatureChangeListener f4769w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public FoldingFeatureObserver f4770x;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int[] f4771d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f4772a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f4773b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f4774c;

        static {
            f4771d = new int[]{R.attr.layout_weight};
        }

        public LayoutParams() {
            super(-1, -1);
            this.f4772a = 0.0f;
        }

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
            this.f4772a = 0.0f;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r10) {
            super(r10);
            this.f4772a = 0.0f;
        }

        public LayoutParams(@NonNull Context r10, @Nullable AttributeSet r11) {
            super(r10, r11);
            this.f4772a = 0.0f;
            TypedArray r12 = r10.obtainStyledAttributes(r11, f4771d);
            this.f4772a = r12.getFloat(0, 0.0f);
            r12.recycle();
        }
    }

    public interface PanelSlideListener {
        void onPanelClosed(@NonNull View r10);

        void onPanelOpened(@NonNull View r10);

        void onPanelSlide(@NonNull View r10, float r11);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean isOpen;
        int mLockMode;

        public class a implements Parcelable.ClassLoaderCreator {
            public a() {
            }

            public SavedState a(Parcel r10) {
                return new SavedState(r10, null);
            }

            public SavedState b(Parcel r10, ClassLoader r11) {
                return new SavedState(r10, null);
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

        public SavedState(Parcelable r10) {
            super(r10);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeInt(this.isOpen ? 1 : 0);
            r10.writeInt(this.mLockMode);
        }

        public SavedState(Parcel r10, ClassLoader r11) {
            super(r10, r11);
            if (r10.readInt() == 0) goto L5;
            boolean r12 = true;
        L6:
            this.isOpen = r12;
            this.mLockMode = r10.readInt();
            return;
        L5:
            r12 = false;
            goto L6
        }
    }

    public class a implements FoldingFeatureObserver.OnFoldingFeatureChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SlidingPaneLayout f4775a;

        public a(SlidingPaneLayout r10) {
            this.f4775a = r10;
        }

        @Override // androidx.slidingpanelayout.widget.FoldingFeatureObserver.OnFoldingFeatureChangeListener
        public void onFoldingFeatureChange(FoldingFeature r10) {
            this.f4775a.f4768v = r10;
            ChangeBounds r11 = new ChangeBounds();
            r11.setDuration(300);
            r11.setInterpolator(s.a.a(0.2f, 0.0f, 0.0f, 1.0f));
            p.a(this.f4775a, r11);
            this.f4775a.requestLayout();
        }
    }

    public class b extends androidx.core.view.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f4776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SlidingPaneLayout f4777b;

        public b(SlidingPaneLayout r10) {
            this.f4777b = r10;
            this.f4776a = new Rect();
        }

        private void c(AccessibilityNodeInfoCompat r10, AccessibilityNodeInfoCompat r11) {
            Rect r12 = this.f4776a;
            r11.k(r12);
            r10.R(r12);
            r10.z0(r11.I());
            r10.k0(r11.r());
            r10.V(r11.m());
            r10.Z(r11.o());
            r10.b0(r11.A());
            r10.W(r11.z());
            r10.d0(r11.B());
            r10.e0(r11.C());
            r10.P(r11.w());
            r10.s0(r11.G());
            r10.h0(r11.D());
            r10.a(r11.i());
            r10.j0(r11.q());
        }

        public boolean d(View r10) {
            return this.f4777b.j(r10);
        }

        @Override // androidx.core.view.a
        public void onInitializeAccessibilityEvent(View r10, AccessibilityEvent r11) {
            super.onInitializeAccessibilityEvent(r10, r11);
            r11.setClassName("androidx.slidingpanelayout.widget.SlidingPaneLayout");
        }

        @Override // androidx.core.view.a
        public void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfoCompat r11) {
            AccessibilityNodeInfoCompat r12 = AccessibilityNodeInfoCompat.L(r11);
            super.onInitializeAccessibilityNodeInfo(r10, r12);
            c(r11, r12);
            r12.N();
            r11.V("androidx.slidingpanelayout.widget.SlidingPaneLayout");
            r11.u0(r10);
            Object r13 = ViewCompat.G(r10);
            if ((r13 instanceof View) == false) goto L5;
            r11.m0((View) r13);
        L5:
            int r14 = this.f4777b.getChildCount();
            int r15 = 0;
        L6:
            if (r15 >= r14) goto L13;
            View r16 = this.f4777b.getChildAt(r15);
            if (d(r16) == true) goto L12;
            if (r16.getVisibility() != 0) goto L12;
            ViewCompat.A0(r16, 1);
            r11.c(r16);
        L12:
            r15 = r15 + 1;
            goto L6
        }

        @Override // androidx.core.view.a
        public boolean onRequestSendAccessibilityEvent(ViewGroup r10, View r11, AccessibilityEvent r12) {
            if (d(r11) == false) goto L5;
            return false;
        L5:
            return super.onRequestSendAccessibilityEvent(r10, r11, r12);
        }
    }

    public class c extends androidx.customview.widget.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SlidingPaneLayout f4778a;

        public c(SlidingPaneLayout r10) {
            this.f4778a = r10;
        }

        public final boolean a() {
            SlidingPaneLayout r10 = this.f4778a;
            if (r10.f4756j == false) goto L6;
            return false;
        L6:
            if (r10.getLockMode() != 3) goto L9;
            return false;
        L9:
            if (this.f4778a.isOpen() == false) goto L14;
            if (this.f4778a.getLockMode() != 1) goto L14;
            return false;
        L14:
            if (this.f4778a.isOpen() == false) goto L16;
        L18:
            return true;
        L16:
            if (this.f4778a.getLockMode() != 2) goto L18;
            return false;
        }

        @Override // androidx.customview.widget.b.c
        public int clampViewPositionHorizontal(View r10, int r11, int r12) {
            LayoutParams r13 = (LayoutParams) this.f4778a.f4752f.getLayoutParams();
            if (this.f4778a.k() == false) goto L5;
            int r14 = this.f4778a.getWidth() - ((this.f4778a.getPaddingRight() + ((ViewGroup.MarginLayoutParams) r13).rightMargin) + this.f4778a.f4752f.getWidth());
            int r15 = r14 - this.f4778a.f4755i;
            return Math.max(Math.min(r11, r14), r15);
        L5:
            int r16 = this.f4778a.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r13).leftMargin;
            int r17 = this.f4778a.f4755i + r16;
            return Math.min(Math.max(r11, r16), r17);
        }

        @Override // androidx.customview.widget.b.c
        public int clampViewPositionVertical(View r10, int r11, int r12) {
            return r10.getTop();
        }

        @Override // androidx.customview.widget.b.c
        public int getViewHorizontalDragRange(View r10) {
            return this.f4778a.f4755i;
        }

        @Override // androidx.customview.widget.b.c
        public void onEdgeDragStarted(int r10, int r11) {
            if (a() == true) goto L5;
            return;
        L5:
            SlidingPaneLayout r12 = this.f4778a;
            r12.f4762p.c(r12.f4752f, r11);
        }

        @Override // androidx.customview.widget.b.c
        public void onEdgeTouched(int r10, int r11) {
            if (a() == true) goto L5;
            return;
        L5:
            SlidingPaneLayout r12 = this.f4778a;
            r12.f4762p.c(r12.f4752f, r11);
        }

        @Override // androidx.customview.widget.b.c
        public void onViewCaptured(View r10, int r11) {
            this.f4778a.s();
        }

        @Override // androidx.customview.widget.b.c
        public void onViewDragStateChanged(int r10) {
            if (this.f4778a.f4762p.C() != 0) goto L9;
            SlidingPaneLayout r11 = this.f4778a;
            if (r11.f4753g != 1.0f) goto L7;
            r11.v(r11.f4752f);
            SlidingPaneLayout r12 = this.f4778a;
            r12.d(r12.f4752f);
            this.f4778a.f4763q = false;
            return;
        L7:
            r11.e(r11.f4752f);
            this.f4778a.f4763q = true;
            return;
        }

        @Override // androidx.customview.widget.b.c
        public void onViewPositionChanged(View r10, int r11, int r12, int r13, int r14) {
            this.f4778a.n(r11);
            this.f4778a.invalidate();
        }

        @Override // androidx.customview.widget.b.c
        public void onViewReleased(View r10, float r11, float r12) {
            LayoutParams r13 = (LayoutParams) r10.getLayoutParams();
            if (this.f4778a.k() == false) goto L12;
            int r14 = this.f4778a.getPaddingRight() + ((ViewGroup.MarginLayoutParams) r13).rightMargin;
            if (r11 >= 0.0f) goto L7;
        L10:
            r14 = r14 + this.f4778a.f4755i;
        L11:
            int r15 = this.f4778a.f4752f.getWidth();
            int r16 = (this.f4778a.getWidth() - r14) - r15;
        L18:
            this.f4778a.f4762p.O(r16, r10.getTop());
            this.f4778a.invalidate();
            return;
        L7:
            if (r11 != 0.0f) goto L11;
            if (this.f4778a.f4753g <= 0.5f) goto L11;
        L12:
            int r17 = this.f4778a.getPaddingLeft();
            r16 = ((ViewGroup.MarginLayoutParams) r13).leftMargin + r17;
            if (r11 > 0.0f) goto L17;
            if (r11 != 0.0f) goto L18;
            if (this.f4778a.f4753g <= 0.5f) goto L18;
        L17:
            r16 = r16 + this.f4778a.f4755i;
            goto L18
        }

        @Override // androidx.customview.widget.b.c
        public boolean tryCaptureView(View r10, int r11) {
            if (a() == true) goto L7;
            return false;
        L7:
            return ((LayoutParams) r10.getLayoutParams()).f4773b;
        }
    }

    public static class d extends FrameLayout {
        public d(View r10) {
            super(r10.getContext());
            addView(r10);
        }

        @Override // android.view.View
        public boolean onGenericMotionEvent(MotionEvent r10) {
            return true;
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent r10) {
            return true;
        }
    }

    static {
        f4746y = true;
    }

    public SlidingPaneLayout(@NonNull Context r10) {
        this(r10, null);
    }

    public static Activity g(Context r10) {
    L3:
        if ((r10 instanceof ContextWrapper) == false) goto L9;
        if ((r10 instanceof Activity) == true) goto L7;
        r10 = ((ContextWrapper) r10).getBaseContext();
        goto L3
    L7:
        return (Activity) r10;
    L9:
        return null;
    }

    private e getSystemGestureInsets() {
        if (f4746y == false) goto L7;
        WindowInsetsCompat r10 = ViewCompat.H(this);
        if (r10 == null) goto L7;
        return r10.i();
    L7:
        return null;
    }

    public static Rect h(FoldingFeature r10, View r11) {
        int[] r12 = new int[2];
        r11.getLocationInWindow(r12);
        int r13 = r12[0];
        Rect r14 = new Rect(r13, r12[1], r11.getWidth() + r13, r12[1] + r11.getWidth());
        Rect r15 = new Rect(r10.getBounds());
        boolean r16 = r15.intersect(r14);
        if (r15.width() == 0) goto L5;
    L6:
        if (r16 == false) goto L11;
        r15.offset(-r12[0], -r12[1]);
        return r15;
    L11:
        return null;
    L5:
        if (r15.height() != 0) goto L6;
        return null;
    }

    public static int i(View r10) {
        if ((r10 instanceof d) == false) goto L7;
        return ViewCompat.C(((d) r10).getChildAt(0));
    L7:
        return ViewCompat.C(r10);
    }

    public static int m(View r10, int r11, int r12) {
        LayoutParams r13 = (LayoutParams) r10.getLayoutParams();
        if (((ViewGroup.MarginLayoutParams) r13).width != 0) goto L8;
        if (r13.f4772a <= 0.0f) goto L8;
        return ViewGroup.getChildMeasureSpec(r11, r12, ((ViewGroup.MarginLayoutParams) r13).height);
    L8:
        return View.MeasureSpec.makeMeasureSpec(r10.getMeasuredHeight(), Ints.MAX_POWER_OF_TWO);
    }

    private void setFoldingFeatureObserver(FoldingFeatureObserver r10) {
        this.f4770x = r10;
        r10.setOnFoldingFeatureChangeListener(this.f4769w);
    }

    public static boolean w(View r10) {
        if (r10.isOpaque() == false) goto L6;
        return true;
    L6:
        return false;
    }

    public void a(PanelSlideListener r10) {
        this.f4760n.add(r10);
    }

    @Override // android.view.ViewGroup
    public void addView(View r10, int r11, ViewGroup.LayoutParams r12) {
        if (getChildCount() != 1) goto L6;
        super.addView(new d(r10), r11, r12);
        return;
    L6:
        super.addView(r10, r11, r12);
    }

    public boolean b() {
        return c(0);
    }

    public final boolean c(int r10) {
        if (this.f4751e == true) goto L6;
        this.f4763q = false;
    L6:
        if (this.f4764r == false) goto L8;
    L11:
        this.f4763q = false;
        return true;
    L8:
        if (t(1.0f, r10) == true) goto L11;
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r10) {
        if ((r10 instanceof LayoutParams) == true) goto L5;
    L7:
        return false;
    L5:
        if (super.checkLayoutParams(r10) == false) goto L7;
        return true;
    }

    @Override // androidx.customview.widget.Openable
    public void close() {
        b();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f4762p.n(true) == true) goto L5;
        return;
    L5:
        if (this.f4751e == true) goto L8;
        this.f4762p.a();
        return;
    L8:
        ViewCompat.g0(this);
    }

    public void d(View r10) {
        Iterator r11 = this.f4760n.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((PanelSlideListener) r11.next()).onPanelClosed(r10);
        goto L4
    L6:
        sendAccessibilityEvent(32);
    }

    @Override // android.view.View
    public void draw(Canvas r10) {
        super.draw(r10);
        if (k() == false) goto L5;
        Drawable r11 = this.f4750d;
    L7:
        if (getChildCount() <= 1) goto L9;
        View r12 = getChildAt(1);
    L10:
        if (r12 == null) goto L19;
        if (r11 == null) goto L20;
        int r13 = r12.getTop();
        int r14 = r12.getBottom();
        int r15 = r11.getIntrinsicWidth();
        if (k() == false) goto L16;
        int r16 = r12.getRight();
        int r17 = r15 + r16;
    L17:
        r11.setBounds(r16, r13, r17, r14);
        r11.draw(r10);
        return;
    L16:
        int r18 = r12.getLeft();
        int r19 = r18 - r15;
        r17 = r18;
        r16 = r19;
        goto L17
    L20:
        return;
    L19:
        return;
    L9:
        r12 = null;
        goto L10
    L5:
        r11 = this.f4749c;
        goto L7
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r10, View r11, long r12) {
        if ((k() ^ isOpen()) == false) goto L7;
        this.f4762p.M(1);
        e r13 = getSystemGestureInsets();
        if (r13 == null) goto L10;
        androidx.customview.widget.b r14 = this.f4762p;
        r14.L(Math.max(r14.x(), r13.f2556a));
    L10:
        LayoutParams r15 = (LayoutParams) r11.getLayoutParams();
        int r16 = r10.save();
        if (this.f4751e == true) goto L13;
    L21:
        boolean r17 = super.drawChild(r10, r11, r12);
        r10.restoreToCount(r16);
        return r17;
    L13:
        if (r15.f4773b == true) goto L21;
        if (this.f4752f == null) goto L21;
        r10.getClipBounds(this.f4765s);
        if (k() == false) goto L19;
        Rect r18 = this.f4765s;
        r18.left = Math.max(r18.left, this.f4752f.getRight());
    L20:
        r10.clipRect(this.f4765s);
        goto L21
    L19:
        Rect r19 = this.f4765s;
        r19.right = Math.min(r19.right, this.f4752f.getLeft());
        goto L20
    L7:
        this.f4762p.M(2);
        e r20 = getSystemGestureInsets();
        if (r20 == null) goto L10;
        androidx.customview.widget.b r21 = this.f4762p;
        r21.L(Math.max(r21.x(), r20.f2558c));
        goto L10
    }

    public void e(View r10) {
        Iterator r11 = this.f4760n.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((PanelSlideListener) r11.next()).onPanelOpened(r10);
        goto L4
    L6:
        sendAccessibilityEvent(32);
    }

    public void f(View r10) {
        Iterator r11 = this.f4760n.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((PanelSlideListener) r11.next()).onPanelSlide(r10, this.f4753g);
        goto L4
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r10);
    L6:
        return new LayoutParams(r10);
    }

    @ColorInt
    @Deprecated
    public int getCoveredFadeColor() {
        return this.f4748b;
    }

    public final int getLockMode() {
        return this.f4767u;
    }

    @Px
    public int getParallaxDistance() {
        return this.f4757k;
    }

    @ColorInt
    @Deprecated
    public int getSliderFadeColor() {
        return this.f4747a;
    }

    @Override // androidx.customview.widget.Openable
    public boolean isOpen() {
        if (this.f4751e == true) goto L5;
    L8:
        return true;
    L5:
        if (this.f4753g == 0.0f) goto L8;
        return false;
    }

    public boolean j(View r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        LayoutParams r11 = (LayoutParams) r10.getLayoutParams();
        if (this.f4751e == true) goto L8;
        return false;
    L8:
        if (r11.f4774c == true) goto L10;
        return false;
    L10:
        if (this.f4753g <= 0.0f) goto L15;
        return true;
    L15:
        return false;
    }

    public boolean k() {
        if (ViewCompat.A(this) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean l() {
        return this.f4751e;
    }

    public void n(int r10) {
        if (this.f4752f != null) goto L6;
        this.f4753g = 0.0f;
        return;
    L6:
        boolean r11 = k();
        LayoutParams r12 = (LayoutParams) this.f4752f.getLayoutParams();
        int r13 = this.f4752f.getWidth();
        if (r11 == false) goto L9;
        r10 = (getWidth() - r10) - r13;
    L9:
        if (r11 == false) goto L11;
        int r14 = getPaddingRight();
    L12:
        if (r11 == false) goto L14;
        int r15 = ((ViewGroup.MarginLayoutParams) r12).rightMargin;
    L15:
        float r16 = (r10 - (r14 + r15)) / this.f4755i;
        this.f4753g = r16;
        if (this.f4757k == 0) goto L18;
        q(r16);
    L18:
        f(this.f4752f);
        return;
    L14:
        r15 = ((ViewGroup.MarginLayoutParams) r12).leftMargin;
        goto L15
    L11:
        r14 = getPaddingLeft();
        goto L12
    }

    public boolean o() {
        return p(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f4764r = true;
        if (this.f4770x == null) goto L8;
        Activity r10 = g(getContext());
        if (r10 == null) goto L9;
        this.f4770x.e(r10);
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f4764r = true;
        FoldingFeatureObserver r10 = this.f4770x;
        if (r10 == null) goto L6;
        r10.f();
    L6:
        if (this.f4766t.size() > 0) goto L9;
        this.f4766t.clear();
        return;
    L9:
        androidx.appcompat.widget.p.a(this.f4766t.get(0));
        throw null;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        int r11 = r10.getActionMasked();
        if (this.f4751e == true) goto L11;
        if (r11 != 0) goto L11;
        if (getChildCount() <= 1) goto L11;
        View r12 = getChildAt(1);
        if (r12 == null) goto L11;
        this.f4763q = this.f4762p.G(r12, (int) r10.getX(), (int) r10.getY());
    L11:
        if (this.f4751e == true) goto L13;
    L44:
        this.f4762p.b();
        return super.onInterceptTouchEvent(r10);
    L13:
        if (this.f4756j == false) goto L17;
        if (r11 != 0) goto L44;
    L17:
        if (r11 == 3) goto L42;
        if (r11 == 1) goto L42;
        if (r11 != 0) goto L22;
        this.f4756j = false;
        float r13 = r10.getX();
        float r14 = r10.getY();
        this.f4758l = r13;
        this.f4759m = r14;
        if (this.f4762p.G(this.f4752f, (int) r13, (int) r14) == true) goto L33;
    L35:
        boolean r15 = false;
    L37:
        if (this.f4762p.P(r10) == true) goto L46;
        if (r15 == false) goto L41;
        return true;
    L41:
        return false;
    L46:
        return true;
    L33:
        if (j(this.f4752f) == false) goto L35;
        r15 = true;
        goto L37
    L22:
        if (r11 != 2) goto L35;
        float r16 = r10.getX();
        float r17 = r10.getY();
        float r18 = Math.abs(r16 - this.f4758l);
        float r19 = Math.abs(r17 - this.f4759m);
        if (r18 <= this.f4762p.B()) goto L35;
        if (r19 <= r18) goto L35;
        this.f4762p.b();
        this.f4756j = true;
        return false;
    L42:
        this.f4762p.b();
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        boolean r10 = k();
        int r11 = r22 - r20;
        if (r10 == false) goto L5;
        int r12 = getPaddingRight();
    L6:
        if (r10 == false) goto L8;
        int r13 = getPaddingLeft();
    L9:
        int r14 = getPaddingTop();
        int r15 = getChildCount();
        if (this.f4764r == true) goto L12;
    L18:
        int r16 = r12;
        int r17 = 0;
    L19:
        if (r17 >= r15) goto L54;
        View r18 = getChildAt(r17);
        if (r18.getVisibility() != 8) goto L23;
        int r24 = r16;
    L52:
        r17 = r17 + 1;
        r16 = r24;
        goto L19
    L23:
        LayoutParams r110 = (LayoutParams) r18.getLayoutParams();
        int r111 = r18.getMeasuredWidth();
        if (r110.f4773b == false) goto L35;
        int r112 = r11 - r13;
        int r113 = (Math.min(r12, r112) - r16) - (((ViewGroup.MarginLayoutParams) r110).leftMargin + ((ViewGroup.MarginLayoutParams) r110).rightMargin);
        this.f4755i = r113;
        if (r10 == false) goto L28;
        int r25 = ((ViewGroup.MarginLayoutParams) r110).rightMargin;
    L30:
        if ((((r16 + r25) + r113) + (r111 / 2)) <= r112) goto L32;
        boolean r26 = true;
    L33:
        r110.f4774c = r26;
        int r27 = (int) (r113 * this.f4753g);
        this.f4753g = r27 / r113;
        r24 = r16 + (r25 + r27);
        int r28 = 0;
    L40:
        if (r10 == false) goto L42;
        int r114 = (r11 - r24) + r28;
        int r29 = r114 - r111;
    L43:
        r18.layout(r29, r14, r114, r18.getMeasuredHeight() + r14);
        FoldingFeature r30 = this.f4768v;
        if (r30 != null) goto L46;
    L50:
        int r31 = 0;
    L51:
        r12 = r12 + (r18.getWidth() + Math.abs(r31));
        goto L52
    L46:
        if (r30.getOrientation() != FoldingFeature.b.f5256c) goto L50;
        if (this.f4768v.isSeparating() == false) goto L50;
        r31 = this.f4768v.getBounds().width();
        goto L51
    L42:
        r29 = r24 - r28;
        r114 = r29 + r111;
        goto L43
    L32:
        r26 = false;
        goto L33
    L28:
        r25 = ((ViewGroup.MarginLayoutParams) r110).leftMargin;
        goto L30
    L35:
        if (this.f4751e == false) goto L39;
        int r32 = this.f4757k;
        if (r32 == 0) goto L39;
        r28 = (int) ((1.0f - this.f4753g) * r32);
        r24 = r12;
    L39:
        r24 = r12;
        r28 = 0;
        goto L40
    L54:
        if (this.f4764r == true) goto L56;
    L61:
        this.f4764r = false;
        return;
    L56:
        if (this.f4751e == true) goto L58;
    L60:
        v(this.f4752f);
        goto L61
    L58:
        if (this.f4757k == 0) goto L60;
        q(this.f4753g);
        goto L60
    L12:
        if (this.f4751e == true) goto L14;
    L16:
        float r33 = 1.0f;
    L17:
        this.f4753g = r33;
        goto L18
    L14:
        if (this.f4763q == false) goto L16;
        r33 = 0.0f;
        goto L17
    L8:
        r13 = getPaddingRight();
        goto L9
    L5:
        r12 = getPaddingLeft();
        goto L6
    }

    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v12 */
    @Override // android.view.View
    public void onMeasure(int r21, int r22) {
        int r10 = View.MeasureSpec.getMode(r21);
        int r11 = View.MeasureSpec.getSize(r21);
        int r12 = View.MeasureSpec.getMode(r22);
        int r13 = View.MeasureSpec.getSize(r22);
        ?? r14 = 0;
        if (r12 == Integer.MIN_VALUE) goto L8;
        if (r12 == 1073741824) goto L7;
        int r15 = 0;
    L6:
        int r16 = r15;
    L9:
        int r17 = Math.max((r11 - getPaddingLeft()) - getPaddingRight(), 0);
        int r18 = getChildCount();
        if (r18 <= 2) goto L12;
        Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
    L12:
        this.f4752f = null;
        int r19 = 0;
        boolean r110 = false;
        int r111 = r17;
        float r112 = 0.0f;
    L13:
        int r20 = 8;
        if (r19 >= r18) goto L51;
        View r23 = getChildAt(r19);
        LayoutParams r113 = (LayoutParams) r23.getLayoutParams();
        int r114 = r11;
        if (r23.getVisibility() != 8) goto L18;
        r113.f4774c = r14;
    L50:
        r19 = r19 + 1;
        r11 = r114;
        r14 = 0;
        goto L13
    L18:
        float r24 = r113.f4772a;
        if (r24 <= 0.0f) goto L23;
        r112 = r112 + r24;
        if (((ViewGroup.MarginLayoutParams) r113).width == 0) goto L50;
    L23:
        int r25 = Math.max(r17 - (((ViewGroup.MarginLayoutParams) r113).leftMargin + ((ViewGroup.MarginLayoutParams) r113).rightMargin), r14);
        int r26 = ((ViewGroup.MarginLayoutParams) r113).width;
        if (r26 != (-2)) goto L30;
        if (r10 != 0) goto L27;
        int r27 = r10;
    L28:
        int r28 = View.MeasureSpec.makeMeasureSpec(r25, r27);
    L33:
        r23.measure(r28, ViewGroup.getChildMeasureSpec(r22, getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) r113).height));
        int r29 = r23.getMeasuredWidth();
        int r30 = r23.getMeasuredHeight();
        if (r30 <= r15) goto L41;
        if (r12 != Integer.MIN_VALUE) goto L39;
        r15 = Math.min(r30, r16);
        goto L41
    L39:
        if (r12 != 0) goto L41;
        r15 = r30;
    L41:
        r111 = r111 - r29;
        if (r19 == 0) goto L50;
        if (r111 >= 0) goto L46;
        boolean r31 = true;
    L47:
        r113.f4773b = r31;
        r110 = r110 | r31;
        if (r31 == false) goto L50;
        this.f4752f = r23;
        goto L50
    L46:
        r31 = false;
        goto L47
    L27:
        r27 = Integer.MIN_VALUE;
        goto L28
    L30:
        if (r26 != (-1)) goto L32;
        r28 = View.MeasureSpec.makeMeasureSpec(r25, r10);
        goto L33
    L32:
        r28 = View.MeasureSpec.makeMeasureSpec(r26, Ints.MAX_POWER_OF_TWO);
        goto L33
    L51:
        int r115 = r11;
        int r32 = r111;
        if (r110 == false) goto L54;
    L55:
        int r33 = 0;
    L56:
        if (r33 >= r18) goto L83;
        View r34 = getChildAt(r33);
        if (r34.getVisibility() == r20) goto L82;
        LayoutParams r35 = (LayoutParams) r34.getLayoutParams();
        if (((ViewGroup.MarginLayoutParams) r35).width == 0) goto L63;
    L65:
        int r116 = r34.getMeasuredWidth();
    L66:
        if (r110 == false) goto L69;
        int r36 = r17 - (((ViewGroup.MarginLayoutParams) r35).leftMargin + ((ViewGroup.MarginLayoutParams) r35).rightMargin);
        int r37 = View.MeasureSpec.makeMeasureSpec(r36, Ints.MAX_POWER_OF_TWO);
    L72:
        int r117 = m(r34, r22, getPaddingTop() + getPaddingBottom());
        if (r116 == r36) goto L82;
        r34.measure(r37, r117);
        int r38 = r34.getMeasuredHeight();
        if (r38 <= r15) goto L82;
        if (r12 != Integer.MIN_VALUE) goto L80;
        r38 = Math.min(r38, r16);
    L79:
        r15 = r38;
        goto L82
    L80:
        if (r12 != 0) goto L82;
    L69:
        if (r35.f4772a <= 0.0f) goto L71;
        r36 = r116 + ((int) ((r35.f4772a * Math.max(0, r32)) / r112));
        r37 = View.MeasureSpec.makeMeasureSpec(r36, Ints.MAX_POWER_OF_TWO);
        goto L72
    L71:
        r36 = r116;
        r37 = 0;
        goto L72
    L63:
        if (r35.f4772a <= 0.0f) goto L65;
        r116 = 0;
    L82:
        r33 = r33 + 1;
        r20 = 8;
    L83:
        ArrayList r39 = u();
        if (r39 == null) goto L104;
        if (r110 == true) goto L104;
        int r40 = 0;
    L87:
        if (r40 >= r18) goto L104;
        View r41 = getChildAt(r40);
        if (r41.getVisibility() == 8) goto L103;
        Rect r42 = (Rect) r39.get(r40);
        LayoutParams r43 = (LayoutParams) r41.getLayoutParams();
        int r44 = ((ViewGroup.MarginLayoutParams) r43).leftMargin + ((ViewGroup.MarginLayoutParams) r43).rightMargin;
        int r45 = View.MeasureSpec.makeMeasureSpec(r41.getMeasuredHeight(), Ints.MAX_POWER_OF_TWO);
        r41.measure(View.MeasureSpec.makeMeasureSpec(r42.width(), Integer.MIN_VALUE), r45);
        if ((r41.getMeasuredWidthAndState() & 16777216) == 1) goto L99;
        if (i(r41) != 0) goto L96;
    L98:
        r41.measure(View.MeasureSpec.makeMeasureSpec(r42.width(), Ints.MAX_POWER_OF_TWO), r45);
        goto L103
    L96:
        if (r42.width() >= i(r41)) goto L98;
    L99:
        r41.measure(View.MeasureSpec.makeMeasureSpec(r17 - r44, Ints.MAX_POWER_OF_TWO), r45);
        if (r40 == 0) goto L103;
        r43.f4773b = true;
        this.f4752f = r41;
        r110 = true;
    L103:
        r40 = r40 + 1;
    L104:
        setMeasuredDimension(r115, (r15 + getPaddingTop()) + getPaddingBottom());
        this.f4751e = r110;
        if (this.f4762p.C() == 0) goto L124;
        if (r110 == true) goto L125;
        this.f4762p.a();
        return;
    L125:
        return;
    L124:
        return;
    L54:
        if (r112 <= 0.0f) goto L83;
    L7:
        r15 = (r13 - getPaddingTop()) - getPaddingBottom();
        goto L6
    L8:
        r16 = (r13 - getPaddingTop()) - getPaddingBottom();
        r15 = 0;
        goto L9
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        if (r11.isOpen == false) goto L9;
        o();
    L10:
        this.f4763q = r11.isOpen;
        setLockMode(r11.mLockMode);
        return;
    L9:
        b();
        goto L10
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        if (l() == false) goto L5;
        boolean r11 = isOpen();
    L6:
        r10.isOpen = r11;
        r10.mLockMode = this.f4767u;
        return r10;
    L5:
        r11 = this.f4763q;
        goto L6
    }

    @Override // android.view.View
    public void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        if (r10 == r12) goto L6;
        this.f4764r = true;
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        if (this.f4751e == false) goto L5;
        this.f4762p.processTouchEvent(r10);
        int r11 = r10.getActionMasked();
        if (r11 == 0) goto L17;
        if (r11 == 1) goto L11;
    L18:
        return true;
    L11:
        if (j(this.f4752f) == false) goto L18;
        float r12 = r10.getX();
        float r13 = r10.getY();
        float r14 = r12 - this.f4758l;
        float r15 = r13 - this.f4759m;
        int r16 = this.f4762p.B();
        if (((r14 * r14) + (r15 * r15)) >= (r16 * r16)) goto L18;
        if (this.f4762p.G(this.f4752f, (int) r12, (int) r13) == false) goto L18;
        c(0);
        goto L18
    L17:
        float r17 = r10.getX();
        float r18 = r10.getY();
        this.f4758l = r17;
        this.f4759m = r18;
        goto L18
    L5:
        return super.onTouchEvent(r10);
    }

    @Override // androidx.customview.widget.Openable
    public void open() {
        o();
    }

    public final boolean p(int r10) {
        if (this.f4751e == true) goto L6;
        this.f4763q = true;
    L6:
        if (this.f4764r == false) goto L8;
    L12:
        this.f4763q = true;
        return true;
    L8:
        if (t(0.0f, r10) == true) goto L12;
        return false;
    }

    public final void q(float r10) {
        boolean r11 = k();
        int r12 = getChildCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L12;
        View r14 = getChildAt(r13);
        if (r14 == this.f4752f) goto L11;
        float r15 = 1.0f - this.f4754h;
        int r16 = this.f4757k;
        this.f4754h = r10;
        int r17 = ((int) (r15 * r16)) - ((int) ((1.0f - r10) * r16));
        if (r11 == false) goto L10;
        r17 = -r17;
    L10:
        r14.offsetLeftAndRight(r17);
    L11:
        r13 = r13 + 1;
        goto L3
    }

    public void r(PanelSlideListener r10) {
        this.f4760n.remove(r10);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View r10) {
        if ((r10.getParent() instanceof d) == false) goto L6;
        super.removeView((View) r10.getParent());
        return;
    L6:
        super.removeView(r10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View r10, View r11) {
        super.requestChildFocus(r10, r11);
        if (isInTouchMode() == false) goto L5;
        return;
    L5:
        if (this.f4751e == false) goto L7;
        return;
    L7:
        if (r10 != this.f4752f) goto L9;
        boolean r12 = true;
    L10:
        this.f4763q = r12;
        return;
    L9:
        r12 = false;
        goto L10
    }

    public void s() {
        int r10 = getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        View r12 = getChildAt(r11);
        if (r12.getVisibility() != 4) goto L7;
        r12.setVisibility(0);
    L7:
        r11 = r11 + 1;
        goto L3
    }

    @Deprecated
    public void setCoveredFadeColor(@ColorInt int r10) {
        this.f4748b = r10;
    }

    public final void setLockMode(int r10) {
        this.f4767u = r10;
    }

    @Deprecated
    public void setPanelSlideListener(@Nullable PanelSlideListener r10) {
        PanelSlideListener r11 = this.f4761o;
        if (r11 == null) goto L5;
        r(r11);
    L5:
        if (r10 == null) goto L7;
        a(r10);
    L7:
        this.f4761o = r10;
    }

    public void setParallaxDistance(@Px int r10) {
        this.f4757k = r10;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable r10) {
        setShadowDrawableLeft(r10);
    }

    public void setShadowDrawableLeft(@Nullable Drawable r10) {
        this.f4749c = r10;
    }

    public void setShadowDrawableRight(@Nullable Drawable r10) {
        this.f4750d = r10;
    }

    @Deprecated
    public void setShadowResource(@DrawableRes int r10) {
        setShadowDrawableLeft(getResources().getDrawable(r10));
    }

    public void setShadowResourceLeft(int r10) {
        setShadowDrawableLeft(ContextCompat.d(getContext(), r10));
    }

    public void setShadowResourceRight(int r10) {
        setShadowDrawableRight(ContextCompat.d(getContext(), r10));
    }

    @Deprecated
    public void setSliderFadeColor(@ColorInt int r10) {
        this.f4747a = r10;
    }

    public boolean t(float r10, int r11) {
        if (this.f4751e == true) goto L5;
        return false;
    L5:
        boolean r12 = k();
        LayoutParams r13 = (LayoutParams) this.f4752f.getLayoutParams();
        if (r12 == false) goto L8;
        int r14 = getPaddingRight() + ((ViewGroup.MarginLayoutParams) r13).rightMargin;
        int r15 = (int) (getWidth() - ((r14 + (r10 * this.f4755i)) + this.f4752f.getWidth()));
    L9:
        androidx.customview.widget.b r16 = this.f4762p;
        View r17 = this.f4752f;
        if (r16.Q(r17, r15, r17.getTop()) == false) goto L13;
        s();
        ViewCompat.g0(this);
        return true;
    L13:
        return false;
    L8:
        r15 = (int) ((getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r13).leftMargin) + (r10 * this.f4755i));
        goto L9
    }

    public final ArrayList u() {
        FoldingFeature r10 = this.f4768v;
        if (r10 != null) goto L5;
    L17:
        return null;
    L5:
        if (r10.isSeparating() == false) goto L17;
        if (this.f4768v.getBounds().left != 0) goto L11;
        return null;
    L11:
        if (this.f4768v.getBounds().top != 0) goto L17;
        Rect r11 = h(this.f4768v, this);
        if (r11 != null) goto L15;
        return null;
    L15:
        Rect r12 = new Rect(getPaddingLeft(), getPaddingTop(), Math.max(getPaddingLeft(), r11.left), getHeight() - getPaddingBottom());
        int r13 = getWidth() - getPaddingRight();
        return new ArrayList(Arrays.asList(new Rect[]{r12, new Rect(Math.min(r13, r11.right), getPaddingTop(), r13, getHeight() - getPaddingBottom())}));
    }

    public void v(View r18) {
        View r10 = r18;
        boolean r11 = k();
        if (r11 == false) goto L5;
        int r12 = getWidth() - getPaddingRight();
    L6:
        if (r11 == false) goto L8;
        int r13 = getPaddingLeft();
    L9:
        int r14 = getPaddingTop();
        int r15 = getHeight() - getPaddingBottom();
        if (r10 != null) goto L12;
    L14:
        int r16 = 0;
        int r17 = 0;
        int r19 = 0;
        int r110 = 0;
    L15:
        int r111 = getChildCount();
        int r112 = 0;
    L16:
        if (r112 >= r111) goto L39;
        View r113 = getChildAt(r112);
        if (r113 == r10) goto L44;
        if (r113.getVisibility() == 8) goto L38;
        if (r11 == false) goto L25;
        int r20 = r13;
    L26:
        int r21 = Math.max(r20, r113.getLeft());
        int r114 = Math.max(r14, r113.getTop());
        if (r11 == false) goto L29;
        int r22 = r12;
    L30:
        int r23 = Math.min(r22, r113.getRight());
        int r24 = Math.min(r15, r113.getBottom());
        if (r21 < r16) goto L36;
        if (r114 < r19) goto L36;
        if (r23 > r17) goto L36;
        if (r24 > r110) goto L36;
        int r25 = 4;
    L37:
        r113.setVisibility(r25);
    L36:
        r25 = 0;
        goto L37
    L29:
        r22 = r13;
        goto L30
    L25:
        r20 = r12;
    L38:
        r112 = r112 + 1;
        r10 = r18;
        r11 = r11;
        goto L16
    L44:
        return;
    L39:
        return;
    L12:
        if (w(r18) == false) goto L14;
        r16 = r18.getLeft();
        r17 = r18.getRight();
        r19 = r18.getTop();
        r110 = r18.getBottom();
        goto L15
    L8:
        r13 = getWidth() - getPaddingRight();
        goto L9
    L5:
        r12 = getPaddingLeft();
        goto L6
    }

    public SlidingPaneLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public SlidingPaneLayout(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f4747a = 0;
        this.f4753g = 1.0f;
        this.f4760n = new CopyOnWriteArrayList();
        this.f4764r = true;
        this.f4765s = new Rect();
        this.f4766t = new ArrayList();
        this.f4769w = new a(this);
        float r13 = r10.getResources().getDisplayMetrics().density;
        setWillNotDraw(false);
        ViewCompat.p0(this, new b(this));
        ViewCompat.A0(this, 1);
        androidx.customview.widget.b r14 = androidx.customview.widget.b.o(this, 0.5f, new c(this));
        this.f4762p = r14;
        r14.N(r13 * 400.0f);
        setFoldingFeatureObserver(new FoldingFeatureObserver(WindowInfoTracker.getOrCreate(r10), ContextCompat.g(r10)));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return new LayoutParams(getContext(), r10);
    }
}
