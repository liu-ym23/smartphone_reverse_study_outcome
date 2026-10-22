package com.obric.oui.panel;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.f;
import com.obric.oui.common.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.b<V> {
    private static final String TAG = "BottomSheetBehavior";
    private boolean A;
    private final ArrayList<a> B;
    private VelocityTracker C;
    private int D;
    private Map<View, Integer> E;
    private b F;
    private boolean G;
    private boolean H;
    private int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final com.obric.oui.panel.c.a f35858J;
    private final com.obric.oui.panel.c.a K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f35859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f35860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f35861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f35862d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f35863e;
    boolean f;
    int g;
    int h;
    com.obric.oui.panel.c i;
    com.obric.oui.panel.a j;
    protected int k;
    WeakReference<V> l;
    WeakReference<View> m;
    int n;
    boolean o;
    boolean p;
    private boolean q;
    private int r;
    private float s;
    private int t;
    private boolean u;
    private int v;
    private boolean w;
    private boolean x;
    private boolean y;
    private int z;

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        final int state;

        public SavedState(Parcel r2) {
            this(r2, null);
        }

        public SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            this.state = r1.readInt();
        }

        public SavedState(Parcelable r3, int r4) {
            super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin"));
            this.state = r4;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.state);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    public static abstract class a {
        public void a(float r1) {
        }

        public abstract void a(View r1, float r2);

        public abstract void a(View r1, int r2);

        public void b(float r1) {
        }

        public a() {
        }
    }

    public interface b {
        boolean a(MotionEvent r1, int r2, int r3);
    }

    private class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f35869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f35870b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f35871c;

        c(BottomSheetBehavior r1, View r2, int r3) {
            this.f35869a = r1;
            this.f35870b = r2;
            this.f35871c = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f35869a.j != null) goto L5;
        L7:
            this.f35869a.c(this.f35871c);
            return;
        L5:
            if (this.f35869a.j.a(this.f35870b, true) == false) goto L7;
            ViewCompat.a(this.f35870b, this);
        }
    }

    private class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f35872a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f35873b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f35874c;

        d(BottomSheetBehavior r1, View r2, int r3) {
            this.f35872a = r1;
            this.f35873b = r2;
            this.f35874c = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f35872a.i != null) goto L5;
        L7:
            this.f35872a.c(this.f35874c);
            return;
        L5:
            if (this.f35872a.i.a(true) == false) goto L7;
            ViewCompat.a(this.f35873b, this);
        }
    }

    static /* synthetic */ boolean a(BottomSheetBehavior r0) {
        return r0.w;
    }

    static /* synthetic */ int[] a(BottomSheetBehavior r0, View r1, float r2, float r3) {
        return r0.a(r1, r2, r3);
    }

    static /* synthetic */ int b(BottomSheetBehavior r0) {
        return r0.g();
    }

    static /* synthetic */ com.obric.oui.panel.c.a c(BottomSheetBehavior r0) {
        return r0.f35858J;
    }

    public BottomSheetBehavior() {
        this.f35859a = true;
        this.q = false;
        this.r = -1;
        this.w = true;
        this.x = false;
        this.g = 4;
        this.h = 4;
        this.B = new ArrayList();
        this.p = true;
        this.G = false;
        this.H = true;
        this.I = 600;
        this.f35858J = new AnonymousClass2(this);
        this.K = new AnonymousClass3(this);
    }

    public BottomSheetBehavior(Context r8, AttributeSet r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r10, r11);
        this.f35859a = true;
        this.q = false;
        this.r = -1;
        this.w = true;
        this.x = false;
        this.g = 4;
        this.h = 4;
        this.B = new ArrayList();
        this.p = true;
        this.G = false;
        this.H = true;
        this.I = 600;
        this.f35858J = new AnonymousClass2(this);
        this.K = new AnonymousClass3(this);
        TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.BottomSheetBehavior_Layout);
        TypedValue r3 = r12.peekValue(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, "styleable", "BottomSheetBehavior_Layout_behavior_peekHeight"));
        if (r3 != null) goto L5;
    L7:
        a(r12.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, "styleable", "BottomSheetBehavior_Layout_behavior_peekHeight"), -1));
    L8:
        b(r12.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, "styleable", "BottomSheetBehavior_Layout_behavior_hideable"), false));
        a(r12.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, "styleable", "BottomSheetBehavior_Layout_behavior_fitToContents"), true));
        c(r12.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, "styleable", "BottomSheetBehavior_Layout_behavior_skipCollapsed"), false));
        r12.recycle();
        this.s = ViewConfiguration.get(r10).getScaledMaximumFlingVelocity();
        return;
    L5:
        if (r3.data != (-1)) goto L7;
        a(r3.data);
        goto L8
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public Parcelable d(CoordinatorLayout r2, V r3) {
        return new SavedState(super.d(r2, r3), this.g);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void a(CoordinatorLayout r3, V r4, Parcelable r5) {
        SavedState r6 = (SavedState) ZeusTransformUtils.preCheckCast((Parcelable) ZeusTransformUtils.wrapperContextForParams(r5, Parcelable.class, "com.obric.aiagent.plugin"), SavedState.class, "com.obric.aiagent.plugin");
        super.a(r3, r4, r6.getSuperState());
        if (r6.state != 1) goto L5;
    L8:
        this.g = 4;
        return;
    L5:
        if (r6.state == 2) goto L8;
        this.g = r6.state;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout r10, V r11, int r12) {
        if (this.p == true) goto L5;
    L9:
        int r0 = r11.getTop();
        r10.onLayoutChild(r11, r12);
        this.k = r10.getHeight();
        if (this.u == true) goto L12;
        this.f35860b = this.t;
    L25:
        if (this.r <= 0) goto L29;
        int r13 = r11.getHeight();
        int r4 = this.r;
        if (r13 <= r4) goto L29;
        this.f35861c = Math.max(0, this.k - r4);
    L30:
        this.f35862d = this.k / 2;
        d();
        int r14 = this.g;
        if (r14 != 3) goto L34;
        ViewCompat.f(r11, g());
    L48:
        if (this.i != null) goto L51;
        com.obric.oui.panel.c r15 = com.obric.oui.panel.c.a(r10, this.f35858J);
        this.i = r15;
        r15.c(this.I);
    L51:
        if (this.G == true) goto L53;
    L55:
        this.l = new WeakReference(r11);
        this.m = new WeakReference(a(r11));
        return true;
    L53:
        if (this.j != null) goto L55;
        this.j = new com.obric.oui.panel.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r10, this.K);
        goto L55
    L34:
        if (r14 != 6) goto L37;
        ViewCompat.f(r11, this.f35862d);
        goto L48
    L37:
        if (this.f == false) goto L42;
        if (r14 != 5) goto L42;
        ViewCompat.f(r11, this.k);
    L42:
        if (r14 != 4) goto L44;
        ViewCompat.f(r11, this.f35863e);
        goto L48
    L44:
        if (r14 == 1) goto L46;
        if (r14 != 2) goto L48;
    L46:
        ViewCompat.f(r11, r0 - r11.getTop());
    L29:
        this.f35861c = Math.max(0, this.k - r11.getHeight());
        goto L30
    L12:
        if (this.v != 0) goto L14;
        this.v = ZeusTransformUtils.getResources(r10, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.design_bottom_sheet_peek_height_min, "dimen", "design_bottom_sheet_peek_height_min"));
    L14:
        float r16 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getConfiguration().fontScale;
        f.a("check fontScale:" + r16);
        if (this.H == false) goto L17;
        double r3 = 0.6d;
    L18:
        double r5 = this.v;
        int r7 = this.r;
        if (r7 <= 0) goto L21;
        double r6 = r7;
    L22:
        this.f35860b = (int) Math.max(r5, r6);
        goto L25
    L21:
        r6 = ((double) r16) * (((double) this.k) * r3);
        goto L22
    L17:
        r3 = 1.0d;
        goto L18
    L5:
        if (ViewCompat.v(r10) == false) goto L9;
        if (ViewCompat.v(r11) == true) goto L9;
        r11.setFitsSystemWindows(true);
        goto L9
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout r10, V r11, MotionEvent r12) {
        if (r11.isShown() == true) goto L5;
    L76:
        this.y = true;
        return false;
    L5:
        if (this.w == false) goto L76;
        int r0 = r12.getActionMasked();
        if (r0 != 0) goto L11;
        e();
    L11:
        if (this.C != null) goto L13;
        this.C = VelocityTracker.obtain();
    L13:
        this.C.addMovement(r12);
        View r4 = null;
        if (r0 == 0) goto L23;
        if (r0 != 1) goto L17;
    L19:
        this.o = false;
        this.n = -1;
        if (this.y == false) goto L39;
        this.y = false;
        return false;
    L39:
        if (this.G == false) goto L48;
        if (this.y == true) goto L48;
        com.obric.oui.panel.a r5 = this.j;
        if (r5 == null) goto L48;
        if (r5.a(r11, r12) == false) goto L48;
        return true;
    L48:
        if (this.y == true) goto L54;
        com.obric.oui.panel.c r13 = this.i;
        if (r13 == null) goto L54;
        if (r13.a(r12) == false) goto L54;
        return true;
    L54:
        WeakReference<View> r14 = this.m;
        if (r14 == null) goto L58;
        r4 = (View) ZeusTransformUtils.preCheckCast(r14.get(), View.class, "com.obric.aiagent.plugin");
    L58:
        if (r0 != 2) goto L70;
        if (r4 == null) goto L70;
        if (this.y == true) goto L70;
        if (this.g == 1) goto L70;
        if (r10.isPointInChildBounds(r4, (int) r12.getX(), (int) r12.getY()) == true) goto L70;
        if (this.i == null) goto L70;
        if (Math.abs(this.D - r12.getY()) <= this.i.a()) goto L70;
    L75:
        return true;
    L70:
        b r15 = this.F;
        if (r15 != null) goto L73;
        return false;
    L73:
        if (r15.a(r12, this.g, this.h) == true) goto L75;
        return false;
    L17:
        if (r0 == 3) goto L19;
    L23:
        int r6 = (int) r12.getX();
        this.D = (int) r12.getY();
        WeakReference<View> r7 = this.m;
        if (r7 == null) goto L26;
        View r8 = (View) ZeusTransformUtils.preCheckCast(r7.get(), View.class, "com.obric.aiagent.plugin");
    L27:
        if (r8 == null) goto L32;
        if (r10.isPointInChildBounds(r8, r6, this.D) == false) goto L32;
        this.n = r12.getPointerId(r12.getActionIndex());
        this.o = true;
    L32:
        if (this.n == (-1)) goto L34;
    L36:
        boolean r9 = false;
    L37:
        this.y = r9;
        goto L39
    L34:
        if (r10.isPointInChildBounds(r11, r6, this.D) == true) goto L36;
        r9 = true;
        goto L37
    L26:
        r8 = null;
        goto L27
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean b(CoordinatorLayout r5, V r6, MotionEvent r7) {
        if (r6.isShown() == true) goto L6;
        return false;
    L6:
        int r8 = r7.getActionMasked();
        if (this.g != 1) goto L10;
        if (r8 != 0) goto L10;
        return true;
    L10:
        if (r8 != 0) goto L13;
        e();
    L13:
        if (this.C != null) goto L15;
        this.C = VelocityTracker.obtain();
    L15:
        this.C.addMovement(r7);
        if (this.G == false) goto L22;
        com.obric.oui.panel.a r0 = this.j;
        if (r0 == null) goto L22;
        if (r0.a() == false) goto L22;
        this.j.a(r7, r6, this.g, this.C);
    L26:
        if (this.G == false) goto L34;
        com.obric.oui.panel.a r1 = this.j;
        if (r1 == null) goto L34;
        if (r1.a() == false) goto L34;
        return !this.y;
    L34:
        if (r8 != 2) goto L41;
        if (this.y == true) goto L41;
        if (Math.abs(this.D - r7.getY()) <= this.i.a()) goto L41;
        this.i.a(r6, r7.getPointerId(r7.getActionIndex()));
    L41:
        return !this.y;
    L22:
        com.obric.oui.panel.c r2 = this.i;
        if (r2 == null) goto L26;
        r2.b(r7);
        goto L26
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout r1, V r2, View r3, View r4, int r5, int r6) {
        this.z = 0;
        this.A = false;
        if ((r5 & 2) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void a(CoordinatorLayout r2, V r3, View r4, int r5, int r6, int[] r7, int r8) {
        if (r8 != 1) goto L6;
        return;
    L6:
        if (r4 == ((View) ZeusTransformUtils.preCheckCast(this.m.get(), View.class, "com.obric.aiagent.plugin"))) goto L8;
        return;
    L8:
        int r9 = r3.getTop();
        int r10 = r9 - r6;
        if (r6 > 0) goto L11;
        if (r6 < 0) goto L19;
    L30:
        d(r3.getTop());
        this.z = r6;
        this.A = true;
        return;
    L19:
        if (r4.canScrollVertically(-1) == true) goto L30;
        int r11 = this.f35863e;
        if (r10 <= r11) goto L27;
        if (this.f == true) goto L27;
        r7[1] = r9 - r11;
        ViewCompat.f(r3, -r7[1]);
        c(4);
    L27:
        if (this.w == true) goto L29;
        return;
    L29:
        r7[1] = r6;
        ViewCompat.f(r3, -r6);
        c(1);
        goto L30
    L11:
        if (r10 >= g()) goto L14;
        r7[1] = r9 - g();
        ViewCompat.f(r3, -r7[1]);
        c(3);
        goto L30
    L14:
        if (this.w == true) goto L16;
        return;
    L16:
        r7[1] = r6;
        ViewCompat.f(r3, -r6);
        c(1);
        goto L30
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void a(CoordinatorLayout r4, V r5, View r6, int r7) {
        int r0 = 3;
        if (r5.getTop() != g()) goto L7;
        c(3);
        return;
    L7:
        if (r6 == this.m.get()) goto L9;
        return;
    L9:
        if (this.A == true) goto L12;
        return;
    L12:
        if (this.z <= 0) goto L15;
        int r8 = g();
    L40:
        this.h = r0;
        if (this.i.a(r5, r5.getLeft(), r8) == false) goto L43;
        c(2);
        ViewCompat.a(r5, new d(this, r5, r0));
    L44:
        this.A = false;
        return;
    L43:
        c(r0);
        goto L44
    L15:
        if (this.f == false) goto L20;
        if (a(r5, f()) == false) goto L20;
        r8 = this.k;
        r0 = 5;
    L20:
        if (this.z != 0) goto L38;
        int r9 = r5.getTop();
        if (this.f35859a == true) goto L24;
        int r1 = this.f35862d;
        if (r9 >= r1) goto L34;
        if (r9 >= Math.abs(r9 - this.f35863e)) goto L32;
        r8 = 0;
        goto L40
    L32:
        r8 = this.f35862d;
    L36:
        r0 = 6;
        goto L40
    L34:
        if (Math.abs(r9 - r1) >= Math.abs(r9 - this.f35863e)) goto L37;
        r8 = this.f35862d;
        goto L36
    L37:
        r8 = this.f35863e;
    L39:
        r0 = 4;
        goto L40
    L24:
        if (Math.abs(r9 - this.f35861c) >= Math.abs(r9 - this.f35863e)) goto L26;
        r8 = this.f35861c;
        goto L40
    L26:
        r8 = this.f35863e;
        goto L39
    L38:
        r8 = this.f35863e;
        goto L39
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout r3, V r4, View r5, float r6, float r7) {
        if (r5 == this.m.get()) goto L5;
    L9:
        return false;
    L5:
        if (this.g == 3) goto L7;
    L8:
        return true;
    L7:
        if (super.a(r3, r4, r5, r6, r7) == false) goto L9;
        goto L8
    }

    public void a(boolean r2) {
        if (this.f35859a != r2) goto L5;
        return;
    L5:
        this.f35859a = r2;
        if (this.l == null) goto L9;
        d();
    L9:
        if (this.f35859a == true) goto L11;
    L13:
        int r3 = this.g;
    L14:
        c(r3);
        return;
    L11:
        if (this.g != 6) goto L13;
        r3 = 3;
        goto L14
    }

    public final void a(int r4) {
        boolean r0 = true;
        if (r4 != (-1)) goto L8;
        if (this.u == true) goto L12;
        this.u = true;
    L14:
        if (r0 == true) goto L16;
        return;
    L16:
        if (this.g != 4) goto L24;
        WeakReference<V> r3 = this.l;
        if (r3 == null) goto L25;
        View r5 = (View) ZeusTransformUtils.preCheckCast(r3.get(), View.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L26;
        r5.requestLayout();
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L12:
        r0 = false;
        goto L14
    L8:
        if (this.u == false) goto L10;
    L13:
        this.u = false;
        this.t = Math.max(0, r4);
        this.f35863e = this.k - r4;
        goto L14
    L10:
        if (this.t == r4) goto L12;
        goto L12
    }

    public void b(boolean r1) {
        this.f = r1;
    }

    public boolean b() {
        return this.f;
    }

    public void c(boolean r1) {
        this.x = r1;
    }

    @Deprecated
    public void a(a r3) {
        a(TAG, "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.B.clear();
        if (r3 == null) goto L6;
        this.B.add(r3);
        return;
    }

    public void b(a r2) {
        if (this.B.contains(r2) == true) goto L6;
        this.B.add(r2);
        return;
    }

    public void c(a r1) {
        this.B.remove(r1);
    }

    public final void b(final int r4) {
        if (r4 != this.g) goto L5;
        return;
    L5:
        WeakReference<V> r0 = this.l;
        if (r0 == null) goto L8;
        final View r1 = (View) ZeusTransformUtils.preCheckCast(r0.get(), View.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L22;
        return;
    L22:
        ViewParent r2 = r1.getParent();
        if (r2 != null) goto L25;
    L29:
        a(r1, r4);
        return;
    L25:
        if (r2.isLayoutRequested() == false) goto L29;
        if (ViewCompat.I(r1) == false) goto L29;
        r1.post(new AnonymousClass1(this, r1, r4));
        return;
    L8:
        if (r4 != 4) goto L10;
    L17:
        this.g = r4;
        return;
    L10:
        if (r4 == 3) goto L17;
        if (r4 == 6) goto L17;
        if (this.f == true) goto L16;
        return;
    L16:
        if (r4 == 5) goto L17;
    }

    public final int c() {
        return this.g;
    }

    void c(int r6) {
        if (this.g != r6) goto L5;
        return;
    L5:
        this.g = r6;
        int r1 = 0;
        if (r6 != 6) goto L8;
    L15:
        h(true);
    L16:
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.l.get(), View.class, "com.obric.aiagent.plugin");
    L18:
        if (r1 >= this.B.size()) goto L20;
        ((a) ZeusTransformUtils.preCheckCast(this.B.get(r1), a.class, "com.obric.aiagent.plugin")).a(r0, r6);
        r1 = r1 + 1;
        goto L18
    L20:
        return;
    L8:
        if (r6 == 3) goto L15;
        if (r6 != 5) goto L13;
    L14:
        h(false);
        goto L16
    L13:
        if (r6 != 4) goto L16;
        goto L14
    }

    public void d() {
        if (this.f35859a == false) goto L5;
        this.f35863e = Math.max(this.k - this.f35860b, this.f35861c);
        return;
    L5:
        this.f35863e = this.k - this.f35860b;
    }

    private void e() {
        this.n = -1;
        VelocityTracker r0 = this.C;
        if (r0 == null) goto L6;
        r0.recycle();
        this.C = null;
        return;
    }

    boolean a(View r7, float r8) {
        if (this.x == false) goto L6;
        return true;
    L6:
        if (r8 != 0.0f) goto L18;
        if (this.q == false) goto L14;
        if (r7.getTop() <= (this.f35863e + (this.f35860b / 2))) goto L12;
        return true;
    L12:
        return false;
    L14:
        if (r7.getTop() <= (((this.k - g()) / 2) + g())) goto L16;
        return true;
    L16:
        return false;
    L18:
        if (this.h != 4) goto L27;
        if (this.t <= (g.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) / 2)) goto L27;
        if (r8 <= (this.s * 0.08f)) goto L25;
        return true;
    L25:
        return false;
    L27:
        if ((Math.abs((r7.getTop() + (r8 * 0.1f)) - this.f35863e) / this.t) <= 0.5f) goto L30;
        return true;
    L30:
        return false;
    }

    View a(View r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (ViewCompat.D(r5) == false) goto L9;
        return r5;
    L9:
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.class) == false) goto L16;
        ViewGroup r6 = (ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.aiagent.plugin");
        int r1 = 0;
        int r2 = r6.getChildCount();
    L11:
        if (r1 >= r2) goto L16;
        View r3 = a(r6.getChildAt(r1));
        if (r3 != null) goto L14;
        r1 = r1 + 1;
        goto L11
    L14:
        return r3;
    L16:
        return null;
    }

    private float f() {
        VelocityTracker r0 = this.C;
        if (r0 != null) goto L6;
        return 0.0f;
    L6:
        r0.computeCurrentVelocity(1000, this.s);
        return this.C.getYVelocity(this.n);
    }

    private int g() {
        if (this.f35859a == true) goto L7;
        return 0;
    L7:
        return this.f35861c;
    }

    void a(View r4, int r5) {
        if (r5 != 4) goto L6;
        int r0 = this.f35863e;
    L21:
        if (this.i.a(r4, r4.getLeft(), r0) == false) goto L23;
        c(2);
        ViewCompat.a(r4, new d(this, r4, r5));
        return;
    L23:
        c(r5);
        return;
    L6:
        if (r5 != 6) goto L13;
        int r1 = this.f35862d;
        if (this.f35859a == false) goto L12;
        int r2 = this.f35861c;
        if (r1 > r2) goto L12;
        r5 = 3;
        r0 = r2;
    L12:
        r0 = r1;
        goto L21
    L13:
        if (r5 != 3) goto L16;
        r0 = g();
        goto L21
    L16:
        if (this.f == false) goto L26;
        if (r5 != 5) goto L26;
        r0 = this.k;
    L26:
        throw new IllegalArgumentException("Illegal state argument: " + r5);
    }

    private int[] a(View r8, float r9, float r10) {
        int r2 = 6;
        int r4 = 4;
        if (r10 >= 0.0f) goto L16;
        if (Math.abs(r10) <= 1500.0f) goto L16;
        if (this.f35859a == false) goto L9;
        int r7 = this.f35861c;
        r4 = 3;
    L48:
        return new int[]{r7, r4};
    L9:
        int r11 = r8.getTop();
        r7 = this.f35862d;
        if (r11 > r7) goto L14;
        r7 = 0;
    L13:
        r2 = 3;
    L14:
        r4 = r2;
    L16:
        if (this.f == false) goto L25;
        if (a(r8, r10) == false) goto L25;
        if (r8.getTop() <= this.f35863e) goto L22;
    L23:
        r7 = this.k;
        r4 = 5;
        goto L48
    L22:
        if (Math.abs(r9) < Math.abs(r10)) goto L23;
    L25:
        if (r10 != 0.0f) goto L27;
    L30:
        int r12 = r8.getTop();
        if (this.f35859a == true) goto L33;
        int r13 = this.f35862d;
        if (r12 >= r13) goto L44;
        if (r12 >= Math.abs(r12 - this.f35863e)) goto L42;
        r7 = 0;
        goto L13
    L42:
        r7 = this.f35862d;
        goto L14
    L44:
        if (Math.abs(r12 - r13) >= Math.abs(r12 - this.f35863e)) goto L46;
        r7 = this.f35862d;
        goto L14
    L46:
        r7 = this.f35863e;
    L36:
        r2 = 4;
        goto L14
    L33:
        if (Math.abs(r12 - this.f35861c) >= Math.abs(r12 - this.f35863e)) goto L35;
        r7 = this.f35861c;
        goto L13
    L35:
        r7 = this.f35863e;
        goto L36
    L27:
        if (Math.abs(r9) > Math.abs(r10)) goto L30;
        r7 = this.f35863e;
        goto L48
    }

    void d(int r8) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.l.get(), View.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.B.isEmpty() == true) goto L17;
        int r3 = 0;
        if (r8 <= this.f35863e) goto L12;
    L9:
        if (r3 >= this.B.size()) goto L18;
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.B.get(r3), a.class, "com.obric.aiagent.plugin");
        int r4 = this.f35863e;
        r1.a(r0, (r4 - r8) / (this.k - r4));
        r3 = r3 + 1;
        goto L9
    L18:
        return;
    L12:
        if (r3 >= this.B.size()) goto L19;
        a r2 = (a) ZeusTransformUtils.preCheckCast(this.B.get(r3), a.class, "com.obric.aiagent.plugin");
        int r5 = this.f35863e;
        r2.a(r0, (r5 - r8) / (r5 - g()));
        r3 = r3 + 1;
        goto L12
    L19:
        return;
    }

    public static <V extends View> BottomSheetBehavior<V> b(V r3) {
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r4, CoordinatorLayout.LayoutParams.class) == false) goto L11;
        CoordinatorLayout.b r5 = ((CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r4, CoordinatorLayout.LayoutParams.class, "com.obric.aiagent.plugin")).getBehavior();
        if (ZeusTransformUtils.instanceOf(r5, BottomSheetBehavior.class) == false) goto L9;
        return (BottomSheetBehavior) ZeusTransformUtils.preCheckCast(r5, BottomSheetBehavior.class, "com.obric.aiagent.plugin");
    L9:
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    L11:
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private void h(boolean r9) {
        WeakReference<V> r0 = this.l;
        if (r0 != null) goto L5;
        return;
    L5:
        ViewParent r1 = ((View) ZeusTransformUtils.preCheckCast(r0.get(), View.class, "com.obric.aiagent.plugin")).getParent();
        if (ZeusTransformUtils.instanceOf(r1, CoordinatorLayout.class) == true) goto L8;
        return;
    L8:
        CoordinatorLayout r2 = (CoordinatorLayout) ZeusTransformUtils.preCheckCast(r1, CoordinatorLayout.class, "com.obric.aiagent.plugin");
        int r3 = r2.getChildCount();
        if (Build.VERSION.SDK_INT < 16) goto L15;
        if (r9 == false) goto L15;
        if (this.E != null) goto L14;
        this.E = new HashMap(r3);
        goto L15
    L14:
        return;
    L15:
        int r4 = 0;
    L16:
        if (r4 >= r3) goto L31;
        View r5 = r2.getChildAt(r4);
        if (r5 == this.l.get()) goto L30;
        if (r9 == true) goto L27;
        Map<View, Integer> r6 = this.E;
        if (r6 == null) goto L30;
        if (r6.containsKey(r5) == false) goto L30;
        ViewCompat.c(r5, ((Integer) ZeusTransformUtils.preCheckCast(this.E.get(r5), Integer.class, "com.obric.aiagent.plugin")).intValue());
        goto L30
    L27:
        if (Build.VERSION.SDK_INT < 16) goto L29;
        this.E.put(r5, Integer.valueOf(r5.getImportantForAccessibility()));
    L29:
        ViewCompat.c(r5, 4);
    L30:
        r4 = r4 + 1;
        goto L16
    L31:
        if (r9 == true) goto L40;
        this.E = null;
        return;
    }

    public void d(boolean r1) {
        this.q = r1;
    }

    public void e(boolean r1) {
        this.w = r1;
    }

    public void e(int r1) {
        this.r = r1;
    }

    public void f(boolean r1) {
        this.G = r1;
    }

    public void g(boolean r1) {
        this.H = r1;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
