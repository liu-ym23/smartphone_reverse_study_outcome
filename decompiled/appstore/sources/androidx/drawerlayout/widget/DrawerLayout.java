package androidx.drawerlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.Openable;
import androidx.drawerlayout.R$attr;
import androidx.drawerlayout.R$dimen;
import androidx.drawerlayout.R$styleable;
import com.google.common.primitives.Ints;
import com.obric.capabilitykit.common.UiType;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DrawerLayout extends ViewGroup implements Openable {
    public static final int[] L = null;
    public static final int[] M = null;
    public static final boolean N = false;
    public static final boolean O = false;
    public static boolean P;
    public CharSequence A;
    public Object B;
    public boolean C;
    public Drawable D;
    public Drawable E;
    public Drawable F;
    public Drawable G;
    public final ArrayList H;
    public Rect I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public Matrix f2919J;
    public final AccessibilityViewCommand K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f2920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f2921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2923d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f2924e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint f2925f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final androidx.customview.widget.b f2926g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final androidx.customview.widget.b f2927h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e f2928i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e f2929j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2930k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f2931l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f2932m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2933n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f2934o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f2935p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f2936q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f2937r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public DrawerListener f2938s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public List f2939t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f2940u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f2941v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Drawable f2942w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Drawable f2943x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Drawable f2944y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public CharSequence f2945z;

    public interface DrawerListener {
        void onDrawerClosed(@NonNull View r10);

        void onDrawerOpened(@NonNull View r10);

        void onDrawerSlide(@NonNull View r10, float r11);

        void onDrawerStateChanged(int r10);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2946a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f2947b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f2948c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2949d;

        public LayoutParams(@NonNull Context r10, @Nullable AttributeSet r11) {
            super(r10, r11);
            this.f2946a = 0;
            TypedArray r12 = r10.obtainStyledAttributes(r11, DrawerLayout.M);
            this.f2946a = r12.getInt(0, 0);
            r12.recycle();
        }

        public LayoutParams(int r10, int r11) {
            super(r10, r11);
            this.f2946a = 0;
        }

        public LayoutParams(LayoutParams r10) {
            super(r10);
            this.f2946a = 0;
            this.f2946a = r10.f2946a;
        }

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
            this.f2946a = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r10) {
            super(r10);
            this.f2946a = 0;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int lockModeEnd;
        int lockModeLeft;
        int lockModeRight;
        int lockModeStart;
        int openDrawerGravity;

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

        public SavedState(@NonNull Parcel r10, @Nullable ClassLoader r11) {
            super(r10, r11);
            this.openDrawerGravity = 0;
            this.openDrawerGravity = r10.readInt();
            this.lockModeLeft = r10.readInt();
            this.lockModeRight = r10.readInt();
            this.lockModeStart = r10.readInt();
            this.lockModeEnd = r10.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeInt(this.openDrawerGravity);
            r10.writeInt(this.lockModeLeft);
            r10.writeInt(this.lockModeRight);
            r10.writeInt(this.lockModeStart);
            r10.writeInt(this.lockModeEnd);
        }

        public SavedState(@NonNull Parcelable r10) {
            super(r10);
            this.openDrawerGravity = 0;
        }
    }

    public class a implements AccessibilityViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DrawerLayout f2950a;

        public a(DrawerLayout r10) {
            this.f2950a = r10;
        }

        @Override // androidx.core.view.accessibility.AccessibilityViewCommand
        public boolean perform(View r10, AccessibilityViewCommand.a r11) {
            if (this.f2950a.B(r10) == true) goto L5;
            return false;
        L5:
            if (this.f2950a.q(r10) == 2) goto L10;
            this.f2950a.f(r10);
            return true;
        L10:
            return false;
        }
    }

    public class b implements View.OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DrawerLayout f2951a;

        public b(DrawerLayout r10) {
            this.f2951a = r10;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View r10, WindowInsets r11) {
            DrawerLayout r12 = (DrawerLayout) r10;
            if (r11.getSystemWindowInsetTop() <= 0) goto L5;
            boolean r13 = true;
        L6:
            r12.P(r11, r13);
            return r11.consumeSystemWindowInsets();
        L5:
            r13 = false;
            goto L6
        }
    }

    public class c extends androidx.core.view.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f2952a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DrawerLayout f2953b;

        public c(DrawerLayout r10) {
            this.f2953b = r10;
            this.f2952a = new Rect();
        }

        public final void c(AccessibilityNodeInfoCompat r10, ViewGroup r11) {
            int r12 = r11.getChildCount();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L8;
            View r14 = r11.getChildAt(r13);
            if (DrawerLayout.y(r14) == false) goto L7;
            r10.c(r14);
        L7:
            r13 = r13 + 1;
            goto L3
        }

        public final void d(AccessibilityNodeInfoCompat r10, AccessibilityNodeInfoCompat r11) {
            Rect r12 = this.f2952a;
            r11.k(r12);
            r10.R(r12);
            r10.z0(r11.I());
            r10.k0(r11.r());
            r10.V(r11.m());
            r10.Z(r11.o());
            r10.b0(r11.A());
            r10.e0(r11.C());
            r10.P(r11.w());
            r10.s0(r11.G());
            r10.a(r11.i());
        }

        @Override // androidx.core.view.a
        public boolean dispatchPopulateAccessibilityEvent(View r10, AccessibilityEvent r11) {
            if (r11.getEventType() != 32) goto L12;
            List<CharSequence> r12 = r11.getText();
            View r13 = this.f2953b.o();
            if (r13 == null) goto L13;
            int r14 = this.f2953b.s(r13);
            CharSequence r15 = this.f2953b.r(r14);
            if (r15 == null) goto L14;
            r12.add(r15);
            return true;
        L14:
            return true;
        L13:
            return true;
        L12:
            return super.dispatchPopulateAccessibilityEvent(r10, r11);
        }

        @Override // androidx.core.view.a
        public void onInitializeAccessibilityEvent(View r10, AccessibilityEvent r11) {
            super.onInitializeAccessibilityEvent(r10, r11);
            r11.setClassName("androidx.drawerlayout.widget.DrawerLayout");
        }

        @Override // androidx.core.view.a
        public void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfoCompat r11) {
            if (DrawerLayout.N == false) goto L5;
            super.onInitializeAccessibilityNodeInfo(r10, r11);
        L9:
            r11.V("androidx.drawerlayout.widget.DrawerLayout");
            r11.d0(false);
            r11.e0(false);
            r11.O(AccessibilityNodeInfoCompat.a.f2738e);
            r11.O(AccessibilityNodeInfoCompat.a.f2739f);
            return;
        L5:
            AccessibilityNodeInfoCompat r12 = AccessibilityNodeInfoCompat.L(r11);
            super.onInitializeAccessibilityNodeInfo(r10, r12);
            r11.u0(r10);
            Object r13 = ViewCompat.G(r10);
            if ((r13 instanceof View) == false) goto L8;
            r11.m0((View) r13);
        L8:
            d(r11, r12);
            r12.N();
            c(r11, (ViewGroup) r10);
            goto L9
        }

        @Override // androidx.core.view.a
        public boolean onRequestSendAccessibilityEvent(ViewGroup r10, View r11, AccessibilityEvent r12) {
            if (DrawerLayout.N == true) goto L10;
            if (DrawerLayout.y(r11) == true) goto L10;
            return false;
        L10:
            return super.onRequestSendAccessibilityEvent(r10, r11, r12);
        }
    }

    public static final class d extends androidx.core.view.a {
        public d() {
        }

        @Override // androidx.core.view.a
        public void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfoCompat r11) {
            super.onInitializeAccessibilityNodeInfo(r10, r11);
            if (DrawerLayout.y(r10) == true) goto L6;
            r11.m0(null);
            return;
        }
    }

    public class e extends androidx.customview.widget.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f2954a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public androidx.customview.widget.b f2955b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Runnable f2956c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ DrawerLayout f2957d;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f2958a;

            public a(e r10) {
                this.f2958a = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f2958a.b();
            }
        }

        public e(DrawerLayout r10, int r11) {
            this.f2957d = r10;
            this.f2956c = new a(this);
            this.f2954a = r11;
        }

        public final void a() {
            int r10 = 3;
            if (this.f2954a != 3) goto L5;
            r10 = 5;
        L5:
            View r11 = this.f2957d.m(r10);
            if (r11 == null) goto L9;
            this.f2957d.f(r11);
            return;
        }

        public void b() {
            int r10 = this.f2955b.y();
            int r11 = 0;
            if (this.f2954a != 3) goto L5;
            boolean r12 = true;
        L6:
            if (r12 == false) goto L11;
            View r13 = this.f2957d.m(3);
            if (r13 == null) goto L10;
            r11 = -r13.getWidth();
        L10:
            int r14 = r11 + r10;
        L12:
            if (r13 == null) goto L23;
            if (r12 == true) goto L15;
        L16:
            if (r12 == false) goto L18;
            return;
        L18:
            if (r13.getLeft() > r14) goto L20;
            return;
        L20:
            if (this.f2957d.q(r13) != 0) goto L26;
            LayoutParams r15 = (LayoutParams) r13.getLayoutParams();
            this.f2955b.Q(r13, r14, r13.getTop());
            r15.f2948c = true;
            this.f2957d.invalidate();
            a();
            this.f2957d.b();
            return;
        L26:
            return;
        L15:
            if (r13.getLeft() < r14) goto L20;
        L23:
            return;
        L11:
            r13 = this.f2957d.m(5);
            r14 = this.f2957d.getWidth() - r10;
            goto L12
        L5:
            r12 = false;
            goto L6
        }

        public void c() {
            this.f2957d.removeCallbacks(this.f2956c);
        }

        @Override // androidx.customview.widget.b.c
        public int clampViewPositionHorizontal(View r10, int r11, int r12) {
            if (this.f2957d.c(r10, 3) == true) goto L5;
            int r13 = this.f2957d.getWidth();
            return Math.max(r13 - r10.getWidth(), Math.min(r11, r13));
        L5:
            return Math.max(-r10.getWidth(), Math.min(r11, 0));
        }

        @Override // androidx.customview.widget.b.c
        public int clampViewPositionVertical(View r10, int r11, int r12) {
            return r10.getTop();
        }

        public void d(androidx.customview.widget.b r10) {
            this.f2955b = r10;
        }

        @Override // androidx.customview.widget.b.c
        public int getViewHorizontalDragRange(View r10) {
            if (this.f2957d.C(r10) == true) goto L7;
            return 0;
        L7:
            return r10.getWidth();
        }

        @Override // androidx.customview.widget.b.c
        public void onEdgeDragStarted(int r10, int r11) {
            if ((r10 & 1) != 1) goto L5;
            View r12 = this.f2957d.m(3);
        L6:
            if (r12 != null) goto L8;
            return;
        L8:
            if (this.f2957d.q(r12) != 0) goto L12;
            this.f2955b.c(r12, r11);
            return;
        L12:
            return;
        L5:
            r12 = this.f2957d.m(5);
            goto L6
        }

        @Override // androidx.customview.widget.b.c
        public boolean onEdgeLock(int r10) {
            return false;
        }

        @Override // androidx.customview.widget.b.c
        public void onEdgeTouched(int r10, int r11) {
            this.f2957d.postDelayed(this.f2956c, 160);
        }

        @Override // androidx.customview.widget.b.c
        public void onViewCaptured(View r10, int r11) {
            ((LayoutParams) r10.getLayoutParams()).f2948c = false;
            a();
        }

        @Override // androidx.customview.widget.b.c
        public void onViewDragStateChanged(int r10) {
            this.f2957d.U(r10, this.f2955b.w());
        }

        @Override // androidx.customview.widget.b.c
        public void onViewPositionChanged(View r10, int r11, int r12, int r13, int r14) {
            int r15 = r10.getWidth();
            if (this.f2957d.c(r10, 3) == false) goto L6;
            float r16 = r11 + r15;
        L5:
            float r17 = r16 / r15;
            this.f2957d.R(r10, r17);
            if (r17 != 0.0f) goto L10;
            int r18 = 4;
        L11:
            r10.setVisibility(r18);
            this.f2957d.invalidate();
            return;
        L10:
            r18 = 0;
            goto L11
        L6:
            r16 = this.f2957d.getWidth() - r11;
            goto L5
        }

        @Override // androidx.customview.widget.b.c
        public void onViewReleased(View r10, float r11, float r12) {
            float r13 = this.f2957d.t(r10);
            int r14 = r10.getWidth();
            if (this.f2957d.c(r10, 3) == true) goto L5;
            int r15 = this.f2957d.getWidth();
            if (r11 >= 0.0f) goto L15;
        L20:
            r15 = r15 - r14;
        L19:
            int r16 = r15;
        L21:
            this.f2955b.O(r16, r10.getTop());
            this.f2957d.invalidate();
            return;
        L15:
            if (r11 != 0.0f) goto L19;
            if (r13 <= 0.5f) goto L19;
        L5:
            if (r11 > 0.0f) goto L11;
            if (r11 == 0.0f) goto L8;
        L10:
            r16 = -r14;
            goto L21
        L8:
            if (r13 <= 0.5f) goto L10;
        L11:
            r16 = 0;
            goto L21
        }

        @Override // androidx.customview.widget.b.c
        public boolean tryCaptureView(View r10, int r11) {
            if (this.f2957d.C(r10) == true) goto L5;
        L9:
            return false;
        L5:
            if (this.f2957d.c(r10, this.f2954a) == false) goto L9;
            if (this.f2957d.q(r10) != 0) goto L9;
            return true;
        }
    }

    static {
        L = new int[]{R.attr.colorPrimaryDark};
        M = new int[]{R.attr.layout_gravity};
        N = true;
        O = true;
        P = true;
    }

    public DrawerLayout(@NonNull Context r10) {
        this(r10, null);
    }

    public static String u(int r10) {
        if ((r10 & 3) != 3) goto L7;
        return "LEFT";
    L7:
        if ((r10 & 5) != 5) goto L11;
        return "RIGHT";
    L11:
        return Integer.toHexString(r10);
    }

    public static boolean v(View r10) {
        Drawable r11 = r10.getBackground();
        if (r11 != null) goto L5;
        return false;
    L5:
        if (r11.getOpacity() != (-1)) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean y(View r10) {
        if (ViewCompat.y(r10) != 4) goto L5;
    L7:
        return false;
    L5:
        if (ViewCompat.y(r10) == 2) goto L7;
        return true;
    }

    public boolean A(int r10) {
        View r11 = m(r10);
        if (r11 != null) goto L5;
        return false;
    L5:
        return B(r11);
    }

    public boolean B(View r10) {
        if (C(r10) == false) goto L10;
        if ((((LayoutParams) r10.getLayoutParams()).f2949d & 1) == 1) goto L11;
        return false;
    L11:
        return true;
    L10:
        throw new IllegalArgumentException("View " + r10 + " is not a drawer");
    }

    public boolean C(View r10) {
        int r11 = androidx.core.view.c.b(((LayoutParams) r10.getLayoutParams()).f2946a, ViewCompat.A(r10));
        if ((r11 & 3) == 0) goto L6;
        return true;
    L6:
        if ((r11 & 5) == 0) goto L8;
        return true;
    L8:
        return false;
    }

    public boolean D(View r10) {
        if (C(r10) == false) goto L10;
        if (((LayoutParams) r10.getLayoutParams()).f2947b <= 0.0f) goto L7;
        return true;
    L7:
        return false;
    L10:
        throw new IllegalArgumentException("View " + r10 + " is not a drawer");
    }

    public final boolean E(float r10, float r11, View r12) {
        if (this.I != null) goto L5;
        this.I = new Rect();
    L5:
        r12.getHitRect(this.I);
        return this.I.contains((int) r10, (int) r11);
    }

    public final void F(Drawable r10, int r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (o.a.c(r10) == false) goto L8;
        o.a.g(r10, r11);
        return;
    }

    public void G(View r10, float r11) {
        float r12 = t(r10);
        float r13 = r10.getWidth();
        int r14 = ((int) (r13 * r11)) - ((int) (r12 * r13));
        if (c(r10, 3) == true) goto L6;
        r14 = -r14;
    L6:
        r10.offsetLeftAndRight(r14);
        R(r10, r11);
    }

    public void H(int r10) {
        I(r10, true);
    }

    public void I(int r10, boolean r11) {
        View r12 = m(r10);
        if (r12 == null) goto L7;
        K(r12, r11);
        return;
    L7:
        throw new IllegalArgumentException("No drawer view found with gravity " + u(r10));
    }

    public void J(View r10) {
        K(r10, true);
    }

    public void K(View r10, boolean r11) {
        if (C(r10) == false) goto L17;
        LayoutParams r12 = (LayoutParams) r10.getLayoutParams();
        if (this.f2932m == false) goto L8;
        r12.f2947b = 1.0f;
        r12.f2949d = 1;
        T(r10, true);
        S(r10);
    L14:
        invalidate();
        return;
    L8:
        if (r11 == false) goto L13;
        r12.f2949d |= 2;
        if (c(r10, 3) == false) goto L12;
        this.f2926g.Q(r10, 0, r10.getTop());
        goto L14
    L12:
        this.f2927h.Q(r10, getWidth() - r10.getWidth(), r10.getTop());
        goto L14
    L13:
        G(r10, 1.0f);
        U(0, r10);
        r10.setVisibility(0);
        goto L14
    L17:
        throw new IllegalArgumentException("View " + r10 + " is not a sliding drawer");
    }

    public void L(DrawerListener r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        List r11 = this.f2939t;
        if (r11 != null) goto L7;
        return;
    L7:
        r11.remove(r10);
    }

    public final Drawable M() {
        int r10 = ViewCompat.A(this);
        if (r10 != 0) goto L8;
        Drawable r11 = this.D;
        if (r11 == null) goto L13;
        F(r11, r10);
        return this.D;
    L13:
        return this.F;
    L8:
        Drawable r12 = this.E;
        if (r12 == null) goto L13;
        F(r12, r10);
        return this.E;
    }

    public final Drawable N() {
        int r10 = ViewCompat.A(this);
        if (r10 != 0) goto L8;
        Drawable r11 = this.E;
        if (r11 == null) goto L13;
        F(r11, r10);
        return this.E;
    L13:
        return this.G;
    L8:
        Drawable r12 = this.D;
        if (r12 == null) goto L13;
        F(r12, r10);
        return this.D;
    }

    public final void O() {
        if (O == false) goto L5;
        return;
    L5:
        this.f2943x = M();
        this.f2944y = N();
    }

    public void P(Object r10, boolean r11) {
        this.B = r10;
        this.C = r11;
        if (r11 == false) goto L5;
    L7:
        boolean r12 = false;
    L8:
        setWillNotDraw(r12);
        requestLayout();
        return;
    L5:
        if (getBackground() != null) goto L7;
        r12 = true;
        goto L8
    }

    public void Q(int r10, int r11) {
        int r12 = androidx.core.view.c.b(r11, ViewCompat.A(this));
        if (r11 != 3) goto L5;
        this.f2933n = r10;
    L15:
        if (r10 == 0) goto L21;
        if (r12 != 3) goto L18;
        androidx.customview.widget.b r13 = this.f2926g;
    L19:
        r13.b();
        goto L21
    L18:
        r13 = this.f2927h;
    L21:
        if (r10 != 1) goto L23;
        View r14 = m(r12);
        if (r14 == null) goto L34;
        f(r14);
        return;
    L34:
        return;
    L23:
        if (r10 != 2) goto L35;
        View r15 = m(r12);
        if (r15 == null) goto L32;
        J(r15);
        return;
    L32:
        return;
    L35:
        return;
    L5:
        if (r11 != 5) goto L7;
        this.f2934o = r10;
        goto L15
    L7:
        if (r11 != 8388611) goto L9;
        this.f2935p = r10;
        goto L15
    L9:
        if (r11 != 8388613) goto L15;
        this.f2936q = r10;
        goto L15
    }

    public void R(View r10, float r11) {
        LayoutParams r12 = (LayoutParams) r10.getLayoutParams();
        if (r11 != r12.f2947b) goto L5;
        return;
    L5:
        r12.f2947b = r11;
        l(r10, r11);
    }

    public final void S(View r10) {
        AccessibilityNodeInfoCompat.a r11 = AccessibilityNodeInfoCompat.a.f2758y;
        ViewCompat.j0(r10, r11.b());
        if (B(r10) == true) goto L5;
        return;
    L5:
        if (q(r10) == 2) goto L9;
        ViewCompat.l0(r10, r11, null, this.K);
        return;
    }

    public final void T(View r10, boolean r11) {
        int r12 = getChildCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L13;
        View r14 = getChildAt(r13);
        if (r11 == false) goto L7;
    L8:
        if (r11 == false) goto L11;
        if (r14 != r10) goto L11;
    L10:
        ViewCompat.A0(r14, 1);
    L12:
        r13 = r13 + 1;
    L11:
        ViewCompat.A0(r14, 4);
        goto L12
    L7:
        if (C(r14) == false) goto L10;
    }

    public void U(int r10, View r11) {
        int r12 = this.f2926g.C();
        int r13 = this.f2927h.C();
        if (r12 == 1) goto L11;
        if (r13 == 1) goto L11;
        int r14 = 2;
        if (r12 == 2) goto L12;
        if (r13 == 2) goto L12;
        r14 = 0;
    L12:
        if (r11 == null) goto L21;
        if (r10 != 0) goto L21;
        float r15 = ((LayoutParams) r11.getLayoutParams()).f2947b;
        if (r15 != 0.0f) goto L18;
        j(r11);
        goto L21
    L18:
        if (r15 != 1.0f) goto L21;
        k(r11);
    L21:
        if (r14 == this.f2930k) goto L27;
        this.f2930k = r14;
        List r16 = this.f2939t;
        if (r16 == null) goto L29;
        int r17 = r16.size() - 1;
    L25:
        if (r17 < 0) goto L30;
        ((DrawerListener) this.f2939t.get(r17)).onDrawerStateChanged(r14);
        r17 = r17 - 1;
        goto L25
    L30:
        return;
    L29:
        return;
    L27:
        return;
    L11:
        r14 = 1;
        goto L12
    }

    public void a(DrawerListener r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.f2939t != null) goto L7;
        this.f2939t = new ArrayList();
    L7:
        this.f2939t.add(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList r10, int r11, int r12) {
        if (getDescendantFocusability() != 393216) goto L5;
        return;
    L5:
        int r13 = getChildCount();
        int r14 = 0;
        int r15 = 0;
        boolean r16 = false;
    L6:
        if (r15 >= r13) goto L14;
        View r17 = getChildAt(r15);
        if (C(r17) == true) goto L10;
        this.H.add(r17);
    L13:
        r15 = r15 + 1;
        goto L6
    L10:
        if (B(r17) == false) goto L13;
        r17.addFocusables(r10, r11, r12);
        r16 = true;
        goto L13
    L14:
        if (r16 == true) goto L21;
        int r18 = this.H.size();
    L16:
        if (r14 >= r18) goto L21;
        View r19 = (View) this.H.get(r14);
        if (r19.getVisibility() != 0) goto L20;
        r19.addFocusables(r10, r11, r12);
    L20:
        r14 = r14 + 1;
    L21:
        this.H.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View r10, int r11, ViewGroup.LayoutParams r12) {
        super.addView(r10, r11, r12);
        if (n() == null) goto L5;
    L8:
        ViewCompat.A0(r10, 4);
    L10:
        if (N == true) goto L13;
        ViewCompat.p0(r10, this.f2920a);
        return;
    L13:
        return;
    L5:
        if (C(r10) == true) goto L8;
        ViewCompat.A0(r10, 1);
        goto L10
    }

    public void b() {
        if (this.f2937r == true) goto L10;
        long r10 = SystemClock.uptimeMillis();
        MotionEvent r11 = MotionEvent.obtain(r10, r10, 3, 0.0f, 0.0f, 0);
        int r12 = getChildCount();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L7;
        getChildAt(r13).dispatchTouchEvent(r11);
        r13 = r13 + 1;
        goto L5
    L7:
        r11.recycle();
        this.f2937r = true;
        return;
    }

    public boolean c(View r10, int r11) {
        if ((s(r10) & r11) != r11) goto L5;
        return true;
    L5:
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
        d(8388611);
    }

    @Override // android.view.View
    public void computeScroll() {
        int r10 = getChildCount();
        float r11 = 0.0f;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L5;
        r11 = Math.max(r11, ((LayoutParams) getChildAt(r12).getLayoutParams()).f2947b);
        r12 = r12 + 1;
        goto L3
    L5:
        this.f2924e = r11;
        boolean r13 = this.f2926g.n(true);
        boolean r14 = this.f2927h.n(true);
        if (r13 == true) goto L8;
        if (r14 == true) goto L8;
        return;
    L8:
        ViewCompat.g0(this);
    }

    public void d(int r10) {
        e(r10, true);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent r10) {
        if ((r10.getSource() & 2) == 0) goto L25;
        if (r10.getAction() == 10) goto L25;
        if (this.f2924e <= 0.0f) goto L25;
        int r11 = getChildCount();
        if (r11 == 0) goto L22;
        float r12 = r10.getX();
        float r13 = r10.getY();
        int r14 = r11 - 1;
    L12:
        if (r14 < 0) goto L31;
        View r15 = getChildAt(r14);
        if (E(r12, r13, r15) == false) goto L21;
        if (z(r15) == true) goto L21;
        if (dispatchTransformedGenericPointerEvent(r10, r15) == false) goto L21;
        return true;
    L21:
        r14 = r14 - 1;
        goto L12
    L31:
        return false;
    L22:
        return false;
    L25:
        return super.dispatchGenericMotionEvent(r10);
    }

    public final boolean dispatchTransformedGenericPointerEvent(MotionEvent r10, View r11) {
        if (r11.getMatrix().isIdentity() == true) goto L5;
        MotionEvent r12 = getTransformedMotionEvent(r10, r11);
        boolean r13 = r11.dispatchGenericMotionEvent(r12);
        r12.recycle();
        return r13;
    L5:
        float r14 = getScrollX() - r11.getLeft();
        float r15 = getScrollY() - r11.getTop();
        r10.offsetLocation(r14, r15);
        boolean r16 = r11.dispatchGenericMotionEvent(r10);
        r10.offsetLocation(-r14, -r15);
        return r16;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r15, View r16, long r17) {
        int r10 = getHeight();
        boolean r11 = z(r16);
        int r12 = getWidth();
        int r13 = r15.save();
        int r14 = 0;
        if (r11 == false) goto L27;
        int r18 = getChildCount();
        int r19 = 0;
        int r110 = 0;
    L5:
        if (r19 >= r18) goto L26;
        View r111 = getChildAt(r19);
        if (r111 == r16) goto L25;
        if (r111.getVisibility() != 0) goto L25;
        if (v(r111) == false) goto L25;
        if (C(r111) == false) goto L25;
        if (r111.getHeight() < r10) goto L25;
        if (c(r111, 3) == false) goto L22;
        int r112 = r111.getRight();
        if (r112 <= r110) goto L25;
        r110 = r112;
        goto L25
    L22:
        int r113 = r111.getLeft();
        if (r113 >= r12) goto L25;
        r12 = r113;
    L25:
        r19 = r19 + 1;
        goto L5
    L26:
        r15.clipRect(r110, 0, r12, getHeight());
        r14 = r110;
    L27:
        boolean r20 = super.drawChild(r15, r16, r17);
        r15.restoreToCount(r13);
        float r21 = this.f2924e;
        if (r21 <= 0.0f) goto L32;
        if (r11 == false) goto L32;
        int r22 = this.f2923d;
        this.f2925f.setColor((r22 & 16777215) | (((int) ((((-16777216) & r22) >>> 24) * r21)) << 24));
        r15.drawRect(r14, 0.0f, r12, getHeight(), this.f2925f);
    L41:
        return r20;
    L32:
        if (this.f2943x == null) goto L37;
        if (c(r16, 3) == false) goto L37;
        int r23 = this.f2943x.getIntrinsicWidth();
        int r24 = r16.getRight();
        float r25 = Math.max(0.0f, Math.min(r24 / this.f2926g.y(), 1.0f));
        this.f2943x.setBounds(r24, r16.getTop(), r23 + r24, r16.getBottom());
        this.f2943x.setAlpha((int) (r25 * 255.0f));
        this.f2943x.draw(r15);
    L37:
        if (this.f2944y == null) goto L41;
        if (c(r16, 5) == false) goto L41;
        int r26 = this.f2944y.getIntrinsicWidth();
        int r27 = r16.getLeft();
        float r28 = Math.max(0.0f, Math.min((getWidth() - r27) / this.f2927h.y(), 1.0f));
        this.f2944y.setBounds(r27 - r26, r16.getTop(), r27, r16.getBottom());
        this.f2944y.setAlpha((int) (r28 * 255.0f));
        this.f2944y.draw(r15);
        goto L41
    }

    public void e(int r10, boolean r11) {
        View r12 = m(r10);
        if (r12 == null) goto L7;
        g(r12, r11);
        return;
    L7:
        throw new IllegalArgumentException("No drawer view found with gravity " + u(r10));
    }

    public void f(View r10) {
        g(r10, true);
    }

    public void g(View r10, boolean r11) {
        if (C(r10) == false) goto L17;
        LayoutParams r12 = (LayoutParams) r10.getLayoutParams();
        if (this.f2932m == false) goto L8;
        r12.f2947b = 0.0f;
        r12.f2949d = 0;
    L14:
        invalidate();
        return;
    L8:
        if (r11 == false) goto L13;
        r12.f2949d |= 4;
        if (c(r10, 3) == false) goto L12;
        this.f2926g.Q(r10, -r10.getWidth(), r10.getTop());
        goto L14
    L12:
        this.f2927h.Q(r10, getWidth(), r10.getTop());
        goto L14
    L13:
        G(r10, 0.0f);
        U(0, r10);
        r10.setVisibility(4);
        goto L14
    L17:
        throw new IllegalArgumentException("View " + r10 + " is not a sliding drawer");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        if ((r10 instanceof LayoutParams) == false) goto L6;
        return new LayoutParams((LayoutParams) r10);
    L6:
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r10);
    L9:
        return new LayoutParams(r10);
    }

    public float getDrawerElevation() {
        if (O == true) goto L5;
        return 0.0f;
    L5:
        return this.f2921b;
    }

    @Nullable
    public Drawable getStatusBarBackgroundDrawable() {
        return this.f2942w;
    }

    public final MotionEvent getTransformedMotionEvent(MotionEvent r10, View r11) {
        float r12 = getScrollX() - r11.getLeft();
        float r13 = getScrollY() - r11.getTop();
        MotionEvent r14 = MotionEvent.obtain(r10);
        r14.offsetLocation(r12, r13);
        Matrix r15 = r11.getMatrix();
        if (r15.isIdentity() == false) goto L5;
    L8:
        return r14;
    L5:
        if (this.f2919J != null) goto L7;
        this.f2919J = new Matrix();
    L7:
        r15.invert(this.f2919J);
        r14.transform(this.f2919J);
        goto L8
    }

    public void h() {
        i(false);
    }

    public void i(boolean r10) {
        int r11 = getChildCount();
        int r12 = 0;
        boolean r13 = false;
    L3:
        if (r12 >= r11) goto L17;
        View r14 = getChildAt(r12);
        LayoutParams r15 = (LayoutParams) r14.getLayoutParams();
        if (C(r14) == false) goto L16;
        if (r10 == true) goto L8;
    L10:
        int r16 = r14.getWidth();
        if (c(r14, 3) == false) goto L14;
        boolean r17 = this.f2926g.Q(r14, -r16, r14.getTop());
    L13:
        r13 = r13 | r17;
        r15.f2948c = false;
        goto L16
    L14:
        r17 = this.f2927h.Q(r14, getWidth(), r14.getTop());
        goto L13
    L8:
        if (r15.f2948c == true) goto L10;
    L16:
        r12 = r12 + 1;
        goto L3
    L17:
        this.f2928i.c();
        this.f2929j.c();
        if (r13 == false) goto L25;
        invalidate();
        return;
    }

    @Override // androidx.customview.widget.Openable
    public boolean isOpen() {
        return A(8388611);
    }

    public void j(View r10) {
        LayoutParams r11 = (LayoutParams) r10.getLayoutParams();
        if ((r11.f2949d & 1) != 1) goto L16;
        r11.f2949d = 0;
        List r12 = this.f2939t;
        if (r12 == null) goto L9;
        int r13 = r12.size() - 1;
    L7:
        if (r13 < 0) goto L9;
        ((DrawerListener) this.f2939t.get(r13)).onDrawerClosed(r10);
        r13 = r13 - 1;
    L9:
        T(r10, false);
        S(r10);
        if (hasWindowFocus() == false) goto L17;
        View r14 = getRootView();
        if (r14 == null) goto L18;
        r14.sendAccessibilityEvent(32);
        return;
    L18:
        return;
    L17:
        return;
    }

    public void k(View r10) {
        LayoutParams r11 = (LayoutParams) r10.getLayoutParams();
        if ((r11.f2949d & 1) != 0) goto L14;
        r11.f2949d = 1;
        List r12 = this.f2939t;
        if (r12 == null) goto L9;
        int r13 = r12.size() - 1;
    L7:
        if (r13 < 0) goto L9;
        ((DrawerListener) this.f2939t.get(r13)).onDrawerOpened(r10);
        r13 = r13 - 1;
    L9:
        T(r10, true);
        S(r10);
        if (hasWindowFocus() == false) goto L15;
        sendAccessibilityEvent(32);
        return;
    L15:
        return;
    }

    public void l(View r10, float r11) {
        List r12 = this.f2939t;
        if (r12 == null) goto L7;
        int r13 = r12.size() - 1;
    L5:
        if (r13 < 0) goto L9;
        ((DrawerListener) this.f2939t.get(r13)).onDrawerSlide(r10, r11);
        r13 = r13 - 1;
        goto L5
    L9:
        return;
    }

    public View m(int r10) {
        int r11 = androidx.core.view.c.b(r10, ViewCompat.A(this)) & 7;
        int r12 = getChildCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        View r14 = getChildAt(r13);
        if ((s(r14) & 7) == r11) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return r14;
    L8:
        return null;
    }

    public View n() {
        int r10 = getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        View r12 = getChildAt(r11);
        if ((((LayoutParams) r12.getLayoutParams()).f2949d & 1) == 1) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return r12;
    L8:
        return null;
    }

    public View o() {
        int r10 = getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L10;
        View r12 = getChildAt(r11);
        if (C(r12) == false) goto L9;
        if (D(r12) == false) goto L9;
        return r12;
    L9:
        r11 = r11 + 1;
        goto L3
    L10:
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2932m = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2932m = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas r10) {
        super.onDraw(r10);
        if (this.C == true) goto L5;
        return;
    L5:
        if (this.f2942w == null) goto L14;
        Object r11 = this.B;
        if (r11 == null) goto L9;
        int r12 = ((WindowInsets) r11).getSystemWindowInsetTop();
    L10:
        if (r12 <= 0) goto L15;
        this.f2942w.setBounds(0, 0, getWidth(), r12);
        this.f2942w.draw(r10);
        return;
    L15:
        return;
    L9:
        r12 = 0;
        goto L10
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        int r11 = r10.getActionMasked();
        boolean r12 = this.f2926g.P(r10) | this.f2927h.P(r10);
        if (r11 == 0) goto L14;
        if (r11 != 1) goto L6;
    L12:
        i(true);
        this.f2937r = false;
    L13:
        boolean r13 = false;
    L23:
        if (r12 == true) goto L32;
        if (r13 == false) goto L26;
        return true;
    L26:
        if (w() == false) goto L28;
        return true;
    L28:
        if (this.f2937r == false) goto L31;
        return true;
    L31:
        return false;
    L32:
        return true;
    L6:
        if (r11 == 2) goto L10;
        if (r11 == 3) goto L12;
    L10:
        if (this.f2926g.e(3) == false) goto L13;
        this.f2928i.c();
        this.f2929j.c();
        goto L13
    L14:
        float r14 = r10.getX();
        float r15 = r10.getY();
        this.f2940u = r14;
        this.f2941v = r15;
        if (this.f2924e <= 0.0f) goto L21;
        View r16 = this.f2926g.u((int) r14, (int) r15);
        if (r16 == null) goto L21;
        if (z(r16) == false) goto L21;
        r13 = true;
    L22:
        this.f2937r = false;
    L21:
        r13 = false;
        goto L22
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r10, KeyEvent r11) {
        if (r10 != 4) goto L9;
        if (x() == false) goto L9;
        r11.startTracking();
        return true;
    L9:
        return super.onKeyDown(r10, r11);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int r10, KeyEvent r11) {
        if (r10 != 4) goto L14;
        View r12 = o();
        if (r12 != null) goto L7;
    L9:
        if (r12 == null) goto L11;
        return true;
    L11:
        return false;
    L7:
        if (q(r12) != 0) goto L9;
        h();
        goto L9
    L14:
        return super.onKeyUp(r10, r11);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r17, int r18, int r19, int r20, int r21) {
        boolean r10 = true;
        this.f2931l = true;
        int r11 = r20 - r18;
        int r12 = getChildCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L42;
        View r14 = getChildAt(r13);
        if (r14.getVisibility() == 8) goto L40;
        LayoutParams r15 = (LayoutParams) r14.getLayoutParams();
        if (z(r14) == false) goto L10;
        int r16 = ((ViewGroup.MarginLayoutParams) r15).leftMargin;
        r14.layout(r16, ((ViewGroup.MarginLayoutParams) r15).topMargin, r14.getMeasuredWidth() + r16, ((ViewGroup.MarginLayoutParams) r15).topMargin + r14.getMeasuredHeight());
        goto L40
    L10:
        int r22 = r14.getMeasuredWidth();
        int r23 = r14.getMeasuredHeight();
        if (c(r14, 3) == false) goto L13;
        float r110 = r22;
        int r111 = (-r22) + ((int) (r15.f2947b * r110));
        float r112 = (r22 + r111) / r110;
    L15:
        if (r112 == r15.f2947b) goto L17;
        boolean r113 = r10;
    L18:
        int r114 = r15.f2946a & 112;
        if (r114 != 16) goto L21;
        int r115 = r21 - r19;
        int r116 = (r115 - r23) / 2;
        int r117 = ((ViewGroup.MarginLayoutParams) r15).topMargin;
        if (r116 >= r117) goto L27;
        r116 = r117;
    L30:
        r14.layout(r111, r116, r22 + r111, r23 + r116);
    L31:
        if (r113 == false) goto L34;
        R(r14, r112);
    L34:
        if (r15.f2947b <= 0.0f) goto L36;
        int r24 = 0;
    L38:
        if (r14.getVisibility() == r24) goto L40;
        r14.setVisibility(r24);
        goto L40
    L36:
        r24 = 4;
        goto L38
    L27:
        int r118 = r116 + r23;
        int r25 = ((ViewGroup.MarginLayoutParams) r15).bottomMargin;
        if (r118 <= (r115 - r25)) goto L30;
        r116 = (r115 - r25) - r23;
        goto L30
    L21:
        if (r114 == 80) goto L23;
        int r119 = ((ViewGroup.MarginLayoutParams) r15).topMargin;
        r14.layout(r111, r119, r22 + r111, r23 + r119);
        goto L31
    L23:
        int r26 = r21 - r19;
        r14.layout(r111, (r26 - ((ViewGroup.MarginLayoutParams) r15).bottomMargin) - r14.getMeasuredHeight(), r22 + r111, r26 - ((ViewGroup.MarginLayoutParams) r15).bottomMargin);
        goto L31
    L17:
        r113 = false;
        goto L18
    L13:
        float r120 = r22;
        int r121 = r11 - ((int) (r15.f2947b * r120));
        r112 = (r11 - r121) / r120;
        r111 = r121;
    L40:
        r13 = r13 + 1;
        r10 = true;
        goto L3
    L42:
        if (P == false) goto L46;
        WindowInsets r27 = getRootWindowInsets();
        if (r27 == null) goto L46;
        androidx.core.graphics.e r28 = WindowInsetsCompat.y(r27).i();
        androidx.customview.widget.b r29 = this.f2926g;
        r29.L(Math.max(r29.x(), r28.f2556a));
        androidx.customview.widget.b r30 = this.f2927h;
        r30.L(Math.max(r30.x(), r28.f2558c));
    L46:
        this.f2931l = false;
        this.f2932m = false;
    }

    @Override // android.view.View
    public void onMeasure(int r18, int r19) {
        int r10 = View.MeasureSpec.getMode(r18);
        int r11 = View.MeasureSpec.getMode(r19);
        int r12 = View.MeasureSpec.getSize(r18);
        int r13 = View.MeasureSpec.getSize(r19);
        if (r10 != 1073741824) goto L6;
        if (r11 != 1073741824) goto L6;
    L12:
        setMeasuredDimension(r12, r13);
        if (this.B != null) goto L15;
    L17:
        boolean r14 = false;
    L18:
        int r15 = ViewCompat.A(this);
        int r16 = getChildCount();
        int r17 = 0;
        boolean r110 = false;
        boolean r111 = false;
    L19:
        if (r17 >= r16) goto L68;
        View r112 = getChildAt(r17);
        if (r112.getVisibility() == 8) goto L65;
        LayoutParams r113 = (LayoutParams) r112.getLayoutParams();
        if (r14 == false) goto L40;
        int r114 = androidx.core.view.c.b(r113.f2946a, r15);
        if (ViewCompat.x(r112) == false) goto L33;
        WindowInsets r20 = (WindowInsets) this.B;
        if (r114 != 3) goto L30;
        r20 = r20.replaceSystemWindowInsets(r20.getSystemWindowInsetLeft(), r20.getSystemWindowInsetTop(), 0, r20.getSystemWindowInsetBottom());
    L32:
        r112.dispatchApplyWindowInsets(r20);
        goto L40
    L30:
        if (r114 != 5) goto L32;
        r20 = r20.replaceSystemWindowInsets(0, r20.getSystemWindowInsetTop(), r20.getSystemWindowInsetRight(), r20.getSystemWindowInsetBottom());
        goto L32
    L33:
        WindowInsets r21 = (WindowInsets) this.B;
        if (r114 != 3) goto L36;
        r21 = r21.replaceSystemWindowInsets(r21.getSystemWindowInsetLeft(), r21.getSystemWindowInsetTop(), 0, r21.getSystemWindowInsetBottom());
    L38:
        ((ViewGroup.MarginLayoutParams) r113).leftMargin = r21.getSystemWindowInsetLeft();
        ((ViewGroup.MarginLayoutParams) r113).topMargin = r21.getSystemWindowInsetTop();
        ((ViewGroup.MarginLayoutParams) r113).rightMargin = r21.getSystemWindowInsetRight();
        ((ViewGroup.MarginLayoutParams) r113).bottomMargin = r21.getSystemWindowInsetBottom();
        goto L40
    L36:
        if (r114 != 5) goto L38;
        r21 = r21.replaceSystemWindowInsets(0, r21.getSystemWindowInsetTop(), r21.getSystemWindowInsetRight(), r21.getSystemWindowInsetBottom());
    L40:
        if (z(r112) == false) goto L44;
        r112.measure(View.MeasureSpec.makeMeasureSpec((r12 - ((ViewGroup.MarginLayoutParams) r113).leftMargin) - ((ViewGroup.MarginLayoutParams) r113).rightMargin, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec((r13 - ((ViewGroup.MarginLayoutParams) r113).topMargin) - ((ViewGroup.MarginLayoutParams) r113).bottomMargin, Ints.MAX_POWER_OF_TWO));
        goto L65
    L44:
        if (C(r112) == false) goto L67;
        if (O == false) goto L50;
        float r22 = ViewCompat.v(r112);
        float r115 = this.f2921b;
        if (r22 == r115) goto L50;
        ViewCompat.x0(r112, r115);
    L50:
        int r23 = s(r112) & 7;
        if (r23 != 3) goto L53;
        boolean r116 = true;
    L54:
        if (r116 == false) goto L56;
        if (r110 == false) goto L56;
    L60:
        throw new IllegalStateException("Child drawer has absolute gravity " + u(r23) + " but this DrawerLayout already has a drawer view along that edge");
    L56:
        if (r116 == true) goto L61;
        if (r111 == true) goto L60;
    L61:
        if (r116 == false) goto L63;
        r110 = true;
    L64:
        r112.measure(ViewGroup.getChildMeasureSpec(r18, (this.f2922c + ((ViewGroup.MarginLayoutParams) r113).leftMargin) + ((ViewGroup.MarginLayoutParams) r113).rightMargin, ((ViewGroup.MarginLayoutParams) r113).width), ViewGroup.getChildMeasureSpec(r19, ((ViewGroup.MarginLayoutParams) r113).topMargin + ((ViewGroup.MarginLayoutParams) r113).bottomMargin, ((ViewGroup.MarginLayoutParams) r113).height));
        goto L65
    L63:
        r111 = true;
        goto L64
    L53:
        r116 = false;
        goto L54
    L67:
        throw new IllegalStateException("Child " + r112 + " at index " + r17 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
    L65:
        r17 = r17 + 1;
        goto L19
    L68:
        return;
    L15:
        if (ViewCompat.x(this) == false) goto L17;
        r14 = true;
    L6:
        if (isInEditMode() == false) goto L70;
        if (r10 != 0) goto L10;
        r12 = 300;
    L10:
        if (r11 != 0) goto L12;
        r13 = 300;
        goto L12
    L70:
        throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        int r12 = r11.openDrawerGravity;
        if (r12 == 0) goto L11;
        View r13 = m(r12);
        if (r13 == null) goto L11;
        J(r13);
    L11:
        int r14 = r11.lockModeLeft;
        if (r14 == 3) goto L14;
        Q(r14, 3);
    L14:
        int r15 = r11.lockModeRight;
        if (r15 == 3) goto L17;
        Q(r15, 5);
    L17:
        int r16 = r11.lockModeStart;
        if (r16 == 3) goto L20;
        Q(r16, 8388611);
    L20:
        int r17 = r11.lockModeEnd;
        if (r17 == 3) goto L24;
        Q(r17, 8388613);
        return;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int r10) {
        O();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        int r11 = getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L17;
        LayoutParams r13 = (LayoutParams) getChildAt(r12).getLayoutParams();
        int r14 = r13.f2949d;
        boolean r15 = true;
        if (r14 != 1) goto L7;
        boolean r16 = true;
    L9:
        if (r14 == 2) goto L12;
        r15 = false;
    L12:
        if (r16 == true) goto L16;
        if (r15 == true) goto L16;
        r12 = r12 + 1;
    L16:
        r10.openDrawerGravity = r13.f2946a;
        goto L17
    L7:
        r16 = false;
    L17:
        r10.lockModeLeft = this.f2933n;
        r10.lockModeRight = this.f2934o;
        r10.lockModeStart = this.f2935p;
        r10.lockModeEnd = this.f2936q;
        return r10;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        this.f2926g.processTouchEvent(r10);
        this.f2927h.processTouchEvent(r10);
        int r11 = r10.getAction() & PrivateKeyType.INVALID;
        boolean r12 = false;
        if (r11 == 0) goto L21;
        if (r11 != 1) goto L6;
        float r13 = r10.getX();
        float r14 = r10.getY();
        View r15 = this.f2926g.u((int) r13, (int) r14);
        if (r15 != null) goto L12;
    L19:
        r12 = true;
    L20:
        i(r12);
    L22:
        return true;
    L12:
        if (z(r15) == false) goto L19;
        float r16 = r13 - this.f2940u;
        float r17 = r14 - this.f2941v;
        int r18 = this.f2926g.B();
        if (((r16 * r16) + (r17 * r17)) >= (r18 * r18)) goto L19;
        View r19 = n();
        if (r19 == null) goto L19;
        if (q(r19) != 2) goto L20;
    L6:
        if (r11 != 3) goto L22;
        i(true);
        this.f2937r = false;
        goto L22
    L21:
        float r20 = r10.getX();
        float r21 = r10.getY();
        this.f2940u = r20;
        this.f2941v = r21;
        this.f2937r = false;
        goto L22
    }

    @Override // androidx.customview.widget.Openable
    public void open() {
        H(8388611);
    }

    public int p(int r10) {
        int r11 = ViewCompat.A(this);
        if (r10 != 3) goto L5;
        int r12 = this.f2933n;
        if (r12 == 3) goto L38;
        return r12;
    L38:
        if (r11 != 0) goto L40;
        int r13 = this.f2935p;
    L41:
        if (r13 == 3) goto L47;
        return r13;
    L47:
        return 0;
    L40:
        r13 = this.f2936q;
        goto L41
    L5:
        if (r10 != 5) goto L7;
        int r14 = this.f2934o;
        if (r14 == 3) goto L30;
        return r14;
    L30:
        if (r11 != 0) goto L32;
        int r15 = this.f2936q;
    L33:
        if (r15 == 3) goto L46;
        return r15;
    L46:
        return 0;
    L32:
        r15 = this.f2935p;
        goto L33
    L7:
        if (r10 != 8388611) goto L9;
        int r16 = this.f2935p;
        if (r16 == 3) goto L22;
        return r16;
    L22:
        if (r11 != 0) goto L24;
        int r17 = this.f2933n;
    L25:
        if (r17 == 3) goto L45;
        return r17;
    L45:
        return 0;
    L24:
        r17 = this.f2934o;
        goto L25
    L9:
        if (r10 != 8388613) goto L48;
        int r18 = this.f2936q;
        if (r18 == 3) goto L14;
        return r18;
    L14:
        if (r11 != 0) goto L16;
        int r19 = this.f2934o;
    L17:
        if (r19 == 3) goto L43;
        return r19;
    L43:
        return 0;
    L16:
        r19 = this.f2933n;
        goto L17
    L48:
        return 0;
    }

    public int q(View r10) {
        if (C(r10) == false) goto L7;
        return p(((LayoutParams) r10.getLayoutParams()).f2946a);
    L7:
        throw new IllegalArgumentException("View " + r10 + " is not a drawer");
    }

    public CharSequence r(int r10) {
        int r11 = androidx.core.view.c.b(r10, ViewCompat.A(this));
        if (r11 != 3) goto L7;
        return this.f2945z;
    L7:
        if (r11 == 5) goto L9;
        return null;
    L9:
        return this.A;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r10) {
        super.requestDisallowInterceptTouchEvent(r10);
        if (r10 == false) goto L6;
        i(true);
        return;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f2931l == true) goto L6;
        super.requestLayout();
        return;
    }

    public int s(View r10) {
        return androidx.core.view.c.b(((LayoutParams) r10.getLayoutParams()).f2946a, ViewCompat.A(this));
    }

    public void setDrawerElevation(float r10) {
        this.f2921b = r10;
        int r11 = 0;
    L4:
        if (r11 >= getChildCount()) goto L9;
        View r12 = getChildAt(r11);
        if (C(r12) == false) goto L8;
        ViewCompat.x0(r12, this.f2921b);
    L8:
        r11 = r11 + 1;
        goto L4
    }

    @Deprecated
    public void setDrawerListener(DrawerListener r10) {
        DrawerListener r11 = this.f2938s;
        if (r11 == null) goto L5;
        L(r11);
    L5:
        if (r10 == null) goto L7;
        a(r10);
    L7:
        this.f2938s = r10;
    }

    public void setDrawerLockMode(int r10) {
        Q(r10, 3);
        Q(r10, 5);
    }

    public void setScrimColor(@ColorInt int r10) {
        this.f2923d = r10;
        invalidate();
    }

    public void setStatusBarBackground(@Nullable Drawable r10) {
        this.f2942w = r10;
        invalidate();
    }

    public void setStatusBarBackgroundColor(@ColorInt int r10) {
        this.f2942w = new ColorDrawable(r10);
        invalidate();
    }

    public float t(View r10) {
        return ((LayoutParams) r10.getLayoutParams()).f2947b;
    }

    public final boolean w() {
        int r10 = getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L9;
        if (((LayoutParams) getChildAt(r11).getLayoutParams()).f2948c == true) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public final boolean x() {
        if (o() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean z(View r10) {
        if (((LayoutParams) r10.getLayoutParams()).f2946a != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public DrawerLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R$attr.drawerLayoutStyle);
    }

    public DrawerLayout(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f2920a = new d();
        this.f2923d = -1728053248;
        this.f2925f = new Paint();
        this.f2932m = true;
        this.f2933n = 3;
        this.f2934o = 3;
        this.f2935p = 3;
        this.f2936q = 3;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.K = new a(this);
        setDescendantFocusability(UiType.FLAG_TIMER_CARD);
        float r13 = getResources().getDisplayMetrics().density;
        this.f2922c = (int) ((64.0f * r13) + 0.5f);
        float r14 = r13 * 400.0f;
        e r15 = new e(this, 3);
        this.f2928i = r15;
        e r16 = new e(this, 5);
        this.f2929j = r16;
        androidx.customview.widget.b r17 = androidx.customview.widget.b.o(this, 1.0f, r15);
        this.f2926g = r17;
        r17.M(1);
        r17.N(r14);
        r15.d(r17);
        androidx.customview.widget.b r18 = androidx.customview.widget.b.o(this, 1.0f, r16);
        this.f2927h = r18;
        r18.M(2);
        r18.N(r14);
        r16.d(r18);
        setFocusableInTouchMode(true);
        ViewCompat.A0(this, 1);
        ViewCompat.p0(this, new c(this));
        setMotionEventSplittingEnabled(false);
        if (ViewCompat.x(this) == false) goto L10;
        setOnApplyWindowInsetsListener(new b(this));
        setSystemUiVisibility(1280);
        TypedArray r19 = r10.obtainStyledAttributes(L);
        this.f2942w = r19.getDrawable(0);     // Catch: Throwable -> L7
        r19.recycle();
    L7:
        th = move-exception;
        r19.recycle();
        throw th;
    L10:
        TypedArray r20 = r10.obtainStyledAttributes(r11, R$styleable.DrawerLayout, r12, 0);
        int r21 = R$styleable.DrawerLayout_elevation;     // Catch: Throwable -> L14
        if (r20.hasValue(r21) == false) goto L16;
        this.f2921b = r20.getDimension(r21, 0.0f);     // Catch: Throwable -> L14
    L17:
        r20.recycle();
        this.H = new ArrayList();
        return;
    L16:
        this.f2921b = getResources().getDimension(R$dimen.def_drawer_elevation);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r20.recycle();
        throw th;
    }

    public void setStatusBarBackground(int r10) {
        if (r10 == 0) goto L4;
        Drawable r11 = ContextCompat.d(getContext(), r10);
    L5:
        this.f2942w = r11;
        invalidate();
        return;
    L4:
        r11 = null;
        goto L5
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return new LayoutParams(getContext(), r10);
    }
}
