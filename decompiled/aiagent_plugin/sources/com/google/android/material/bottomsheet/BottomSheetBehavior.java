package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
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
import androidx.core.view.accessibility.d;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.c;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.android.material.internal.r;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.m;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.common.UiType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes2.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.b<V> {
    private static final int R = 0;
    private static final String TAG = "BottomSheetBehavior";
    private int A;
    private int B;
    private int C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private boolean f13240J;
    private boolean K;
    private int L;
    private int M;
    private m N;
    private boolean O;
    private final BottomSheetBehavior<V>.b P;
    private ValueAnimator Q;
    private boolean S;
    private boolean T;
    private boolean U;
    private int V;
    private boolean W;
    private int X;
    private final ArrayList<a> Y;
    private VelocityTracker Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f13241a;
    private int aa;
    private Map<View, Integer> ab;
    private int ac;
    private final c.a ad;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f13242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f13243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    float f13244d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f13245e;
    float f;
    boolean g;
    int h;
    int i;
    c j;
    int k;
    int l;
    WeakReference<V> m;
    WeakReference<View> n;
    int o;
    boolean p;
    private int q;
    private boolean r;
    private boolean s;
    private float t;
    private int u;
    private boolean v;
    private int w;
    private int x;
    private MaterialShapeDrawable y;
    private ColorStateList z;

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean fitToContents;
        boolean hideable;
        int peekHeight;
        boolean skipCollapsed;
        final int state;

        public SavedState(Parcel r2) {
            this(r2, null);
        }

        public SavedState(Parcel r3, ClassLoader r4) {
            super(r3, r4);
            this.state = r3.readInt();
            this.peekHeight = r3.readInt();
            boolean r0 = false;
            if (r3.readInt() != 1) goto L5;
            boolean r5 = true;
        L6:
            this.fitToContents = r5;
            if (r3.readInt() != 1) goto L9;
            boolean r6 = true;
        L10:
            this.hideable = r6;
            if (r3.readInt() != 1) goto L13;
            r0 = true;
        L13:
            this.skipCollapsed = r0;
            return;
        L9:
            r6 = false;
            goto L10
        L5:
            r5 = false;
            goto L6
        }

        public SavedState(Parcelable r3, BottomSheetBehavior<?> r4) {
            super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin"));
            this.state = r4.h;
            this.peekHeight = BottomSheetBehavior.k(r4);
            this.fitToContents = BottomSheetBehavior.j(r4);
            this.hideable = r4.g;
            this.skipCollapsed = BottomSheetBehavior.l(r4);
        }

        @Deprecated
        public SavedState(Parcelable r3, int r4) {
            super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin"));
            this.state = r4;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.state);
            r1.writeInt(this.peekHeight);
            r1.writeInt(this.fitToContents ? 1 : 0);
            r1.writeInt(this.hideable ? 1 : 0);
            r1.writeInt(this.skipCollapsed ? 1 : 0);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    public static abstract class a {
        void a(View r1) {
        }

        public abstract void a(View r1, float r2);

        public abstract void a(View r1, int r2);

        public a() {
        }
    }

    private class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f13255a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f13256b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f13257c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Runnable f13258d;

        private b(BottomSheetBehavior r1) {
            this.f13255a = r1;
            this.f13258d = new AnonymousClass1(this);
        }

        /* synthetic */ b(BottomSheetBehavior r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ int a(b r0) {
            return r0.f13256b;
        }

        static /* synthetic */ boolean a(b r0, boolean r1) {
            r0.f13257c = r1;
            return r1;
        }

        void a(int r3) {
            if (this.f13255a.m != null) goto L5;
            return;
        L5:
            if (this.f13255a.m.get() == null) goto L13;
            this.f13256b = r3;
            if (this.f13257c == true) goto L12;
            ViewCompat.a((View) ZeusTransformUtils.preCheckCast(this.f13255a.m.get(), View.class, "com.obric.aiagent.plugin"), this.f13258d);
            this.f13257c = true;
            return;
        L12:
            return;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void a(CoordinatorLayout r1, V r2, View r3, int r4, int r5, int r6, int r7, int r8, int[] r9) {
    }

    public boolean a(long r1, float r3) {
        return false;
    }

    public boolean g() {
        return true;
    }

    public boolean h() {
        return false;
    }

    public boolean i() {
        return true;
    }

    static /* synthetic */ int a(BottomSheetBehavior r0, int r1) {
        r0.M = r1;
        return r1;
    }

    static /* synthetic */ MaterialShapeDrawable a(BottomSheetBehavior r0) {
        return r0.y;
    }

    static /* synthetic */ void a(BottomSheetBehavior r0, View r1, int r2, boolean r3) {
        r0.a(r1, r2, r3);
    }

    static /* synthetic */ void a(BottomSheetBehavior r0, boolean r1) {
        r0.f(r1);
    }

    static /* synthetic */ int b(BottomSheetBehavior r0, int r1) {
        r0.L = r1;
        return r1;
    }

    static /* synthetic */ boolean b(BottomSheetBehavior r0) {
        return r0.E;
    }

    static /* synthetic */ int c(BottomSheetBehavior r0) {
        return r0.L;
    }

    static /* synthetic */ int c(BottomSheetBehavior r0, int r1) {
        r0.C = r1;
        return r1;
    }

    static /* synthetic */ boolean d(BottomSheetBehavior r0) {
        return r0.F;
    }

    static /* synthetic */ boolean e(BottomSheetBehavior r0) {
        return r0.G;
    }

    static /* synthetic */ boolean f(BottomSheetBehavior r0) {
        return r0.I;
    }

    static /* synthetic */ boolean g(BottomSheetBehavior r0) {
        return r0.f13240J;
    }

    static /* synthetic */ boolean h(BottomSheetBehavior r0) {
        return r0.K;
    }

    static /* synthetic */ boolean i(BottomSheetBehavior r0) {
        return r0.T;
    }

    static /* synthetic */ boolean j(BottomSheetBehavior r0) {
        return r0.r;
    }

    static /* synthetic */ int k(BottomSheetBehavior r0) {
        return r0.u;
    }

    static /* synthetic */ boolean l(BottomSheetBehavior r0) {
        return r0.S;
    }

    static {
        R = ZeusTransformUtils.mapRes(R.style.Widget_Design_BottomSheet_Modal, "style", "Widget_Design_BottomSheet_Modal");
    }

    public BottomSheetBehavior() {
        this.q = 0;
        this.r = true;
        this.s = false;
        this.A = -1;
        this.B = -1;
        this.P = new b(this, null);
        this.f13244d = 0.5f;
        this.f = -1.0f;
        this.T = true;
        this.h = 4;
        this.i = 4;
        this.Y = new ArrayList();
        this.ac = -1;
        this.ad = new AnonymousClass4(this);
    }

    public BottomSheetBehavior(Context r11, AttributeSet r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r14 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r13, r14);
        this.q = 0;
        this.r = true;
        this.s = false;
        this.A = -1;
        this.B = -1;
        this.P = new b(this, null);
        this.f13244d = 0.5f;
        this.f = -1.0f;
        this.T = true;
        this.h = 4;
        this.i = 4;
        this.Y = new ArrayList();
        this.ac = -1;
        this.ad = new AnonymousClass4(this);
        this.x = ZeusTransformUtils.getResources(r13, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_min_touch_target_size, "dimen", "mtrl_min_touch_target_size"));
        TypedArray r1 = r13.obtainStyledAttributes(r14, R.styleable.BottomSheetBehavior_Layout);
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_backgroundTint, "styleable", "BottomSheetBehavior_Layout_backgroundTint")) == false) goto L6;
        this.z = com.google.android.material.g.c.a(r13, r1, ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_backgroundTint, "styleable", "BottomSheetBehavior_Layout_backgroundTint"));
    L6:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_shapeAppearance, "styleable", "BottomSheetBehavior_Layout_shapeAppearance")) == false) goto L8;
        this.N = m.a(r13, r14, ZeusTransformUtils.mapRes(R.attr.bottomSheetStyle, "attr", "bottomSheetStyle"), R).a();
    L8:
        a(r13);
        o();
        if (Build.VERSION.SDK_INT < 21) goto L12;
        this.f = r1.getDimension(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_android_elevation, "styleable", "BottomSheetBehavior_Layout_android_elevation"), -1.0f);
    L12:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_android_maxWidth, "styleable", "BottomSheetBehavior_Layout_android_maxWidth")) == false) goto L15;
        a(r1.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_android_maxWidth, "styleable", "BottomSheetBehavior_Layout_android_maxWidth"), -1));
    L15:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_android_maxHeight, "styleable", "BottomSheetBehavior_Layout_android_maxHeight")) == false) goto L17;
        b(r1.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_android_maxHeight, "styleable", "BottomSheetBehavior_Layout_android_maxHeight"), -1));
    L17:
        TypedValue r15 = r1.peekValue(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, "styleable", "BottomSheetBehavior_Layout_behavior_peekHeight"));
        if (r15 != null) goto L20;
    L22:
        c(r1.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, "styleable", "BottomSheetBehavior_Layout_behavior_peekHeight"), -1));
    L23:
        b(r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, "styleable", "BottomSheetBehavior_Layout_behavior_hideable"), false));
        e(r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, "styleable", "BottomSheetBehavior_Layout_gestureInsetBottomIgnored"), false));
        a(r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, "styleable", "BottomSheetBehavior_Layout_behavior_fitToContents"), true));
        c(r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, "styleable", "BottomSheetBehavior_Layout_behavior_skipCollapsed"), false));
        d(r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_behavior_draggable, "styleable", "BottomSheetBehavior_Layout_behavior_draggable"), true));
        e(r1.getInt(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, "styleable", "BottomSheetBehavior_Layout_behavior_saveFlags"), 0));
        a(r1.getFloat(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, "styleable", "BottomSheetBehavior_Layout_behavior_halfExpandedRatio"), 0.5f));
        TypedValue r16 = r1.peekValue(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset, "styleable", "BottomSheetBehavior_Layout_behavior_expandedOffset"));
        if (r16 != null) goto L26;
    L28:
        d(r1.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset, "styleable", "BottomSheetBehavior_Layout_behavior_expandedOffset"), 0));
    L29:
        this.E = r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, "styleable", "BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets"), false);
        this.F = r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, "styleable", "BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets"), false);
        this.G = r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, "styleable", "BottomSheetBehavior_Layout_paddingRightSystemWindowInsets"), false);
        this.H = r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, "styleable", "BottomSheetBehavior_Layout_paddingTopSystemWindowInsets"), true);
        this.I = r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_marginLeftSystemWindowInsets, "styleable", "BottomSheetBehavior_Layout_marginLeftSystemWindowInsets"), false);
        this.f13240J = r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_marginRightSystemWindowInsets, "styleable", "BottomSheetBehavior_Layout_marginRightSystemWindowInsets"), false);
        this.K = r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_marginTopSystemWindowInsets, "styleable", "BottomSheetBehavior_Layout_marginTopSystemWindowInsets"), false);
        r1.recycle();
        this.t = ViewConfiguration.get(r13).getScaledMaximumFlingVelocity();
        return;
    L26:
        if (r16.type != 16) goto L28;
        d(r16.data);
        goto L29
    L20:
        if (r15.data != (-1)) goto L22;
        c(r15.data);
        goto L23
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public Parcelable d(CoordinatorLayout r2, V r3) {
        return new SavedState(super.d(r2, r3), this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void a(CoordinatorLayout r3, V r4, Parcelable r5) {
        SavedState r6 = (SavedState) ZeusTransformUtils.preCheckCast((Parcelable) ZeusTransformUtils.wrapperContextForParams(r5, Parcelable.class, "com.obric.aiagent.plugin"), SavedState.class, "com.obric.aiagent.plugin");
        super.a(r3, r4, r6.getSuperState());
        a(r6);
        if (r6.state != 1) goto L5;
    L8:
        this.h = 4;
        this.i = 4;
        return;
    L5:
        if (r6.state == 2) goto L8;
        int r7 = r6.state;
        this.h = r7;
        this.i = r7;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void a(CoordinatorLayout.LayoutParams r1) {
        super.a(r1);
        this.m = null;
        this.j = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void a() {
        super.a();
        this.m = null;
        this.j = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout r4, V r5, int r6, int r7, int r8, int r9) {
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r5.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        r5.measure(a(r6, (((r4.getPaddingLeft() + r4.getPaddingRight()) + r0.leftMargin) + r0.rightMargin) + r7, this.A, r0.width), a(r8, (((r4.getPaddingTop() + r4.getPaddingBottom()) + r0.topMargin) + r0.bottomMargin) + r9, this.B, r0.height));
        return true;
    }

    private int a(int r1, int r2, int r3, int r4) {
        int r0 = ViewGroup.getChildMeasureSpec(r1, r2, r4);
        if (r3 != (-1)) goto L5;
        return r0;
    L5:
        int r5 = View.MeasureSpec.getMode(r0);
        int r6 = View.MeasureSpec.getSize(r0);
        if (r5 == 1073741824) goto L13;
        if (r6 == 0) goto L11;
        r3 = Math.min(r6, r3);
    L11:
        return View.MeasureSpec.makeMeasureSpec(r3, Integer.MIN_VALUE);
    L13:
        return View.MeasureSpec.makeMeasureSpec(Math.min(r6, r3), 1073741824);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout r9, V r10, int r11) {
        if (ViewCompat.v(r9) == true) goto L5;
    L7:
        int r4 = 0;
        if (this.m != null) goto L30;
        this.w = ZeusTransformUtils.getResources(r9, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.design_bottom_sheet_peek_height_min, "dimen", "design_bottom_sheet_peek_height_min"));
        d(r10);
        this.m = new WeakReference(r10);
        MaterialShapeDrawable r0 = this.y;
        if (r0 == null) goto L23;
        ViewCompat.a(r10, r0);
        MaterialShapeDrawable r1 = this.y;
        float r5 = this.f;
        if (r5 != (-1.0f)) goto L14;
        r5 = ViewCompat.q(r10);
    L14:
        r1.setElevation(r5);
        if (this.h != 3) goto L17;
        boolean r2 = true;
    L18:
        this.O = r2;
        MaterialShapeDrawable r6 = this.y;
        if (r2 == false) goto L21;
        float r3 = 0.0f;
    L22:
        r6.setInterpolation(r3);
    L26:
        q();
        if (ViewCompat.g(r10) != 0) goto L30;
        ViewCompat.c(r10, 1);
        goto L30
    L21:
        r3 = 1.0f;
        goto L22
    L17:
        r2 = false;
        goto L18
    L23:
        ColorStateList r7 = this.z;
        if (r7 == null) goto L26;
        ViewCompat.a(r10, r7);
    L30:
        if (this.j != null) goto L32;
        this.j = c.a(r9, this.ad);
    L32:
        int r8 = r10.getTop();
        r9.onLayoutChild(r10, r11);
        this.k = r9.getWidth();
        this.l = r9.getHeight();
        int r12 = r10.getHeight();
        this.X = r12;
        int r13 = this.l;
        int r14 = r13 - r12;
        int r15 = this.M;
        if (r14 < r15) goto L35;
    L38:
        this.f13242b = Math.max(0, r13 - this.X);
        l();
        k();
        int r16 = this.h;
        if (r16 != 3) goto L42;
        ViewCompat.f(r10, b());
    L56:
        this.n = new WeakReference(a(r10));
    L58:
        if (r4 >= this.Y.size()) goto L60;
        ((a) ZeusTransformUtils.preCheckCast(this.Y.get(r4), a.class, "com.obric.aiagent.plugin")).a(r10);
        r4 = r4 + 1;
        goto L58
    L60:
        return true;
    L42:
        if (r16 != 6) goto L45;
        ViewCompat.f(r10, this.f13243c);
        goto L56
    L45:
        if (this.g == false) goto L50;
        if (r16 != 5) goto L50;
        ViewCompat.f(r10, this.l);
    L50:
        if (r16 != 4) goto L52;
        ViewCompat.f(r10, this.f13245e);
        goto L56
    L52:
        if (r16 != 1) goto L54;
    L55:
        ViewCompat.f(r10, r8 - r10.getTop());
        goto L56
    L54:
        if (r16 != 2) goto L56;
    L35:
        if (this.H == false) goto L37;
        this.X = r13;
        goto L38
    L37:
        this.X = r13 - r15;
        goto L38
    L5:
        if (ViewCompat.v(r10) == true) goto L7;
        r10.setFitsSystemWindows(true);
        goto L7
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout r11, V r12, MotionEvent r13) {
        if (r12.isShown() == true) goto L5;
    L64:
        this.U = true;
        return false;
    L5:
        if (this.T == false) goto L64;
        int r0 = r13.getActionMasked();
        if (r0 != 0) goto L11;
        m();
    L11:
        if (this.Z != null) goto L13;
        this.Z = VelocityTracker.obtain();
    L13:
        this.Z.addMovement(r13);
        View r4 = null;
        if (r0 == 0) goto L23;
        if (r0 != 1) goto L17;
    L19:
        this.p = false;
        this.o = -1;
        if (this.U == false) goto L41;
        this.U = false;
        return false;
    L41:
        if (this.U == true) goto L47;
        c r14 = this.j;
        if (r14 == null) goto L47;
        if (r14.a(r13) == false) goto L47;
        return true;
    L47:
        WeakReference<View> r15 = this.n;
        if (r15 == null) goto L50;
        r4 = (View) ZeusTransformUtils.preCheckCast(r15.get(), View.class, "com.obric.aiagent.plugin");
    L50:
        if (r0 != 2) goto L66;
        if (r4 != null) goto L53;
        return false;
    L53:
        if (this.U == false) goto L55;
        return false;
    L55:
        if (this.h != 1) goto L57;
        return false;
    L57:
        if (r11.isPointInChildBounds(r4, (int) r13.getX(), (int) r13.getY()) == false) goto L59;
        return false;
    L59:
        if (this.j != null) goto L61;
        return false;
    L61:
        if (Math.abs(this.aa - r13.getY()) > this.j.f()) goto L63;
        return false;
    L63:
        return true;
    L66:
        return false;
    L17:
        if (r0 == 3) goto L19;
    L23:
        int r7 = (int) r13.getX();
        this.aa = (int) r13.getY();
        if (this.h == 2) goto L34;
        WeakReference<View> r8 = this.n;
        if (r8 == null) goto L28;
        View r9 = (View) ZeusTransformUtils.preCheckCast(r8.get(), View.class, "com.obric.aiagent.plugin");
    L29:
        if (r9 == null) goto L34;
        if (r11.isPointInChildBounds(r9, r7, this.aa) == false) goto L34;
        this.o = r13.getPointerId(r13.getActionIndex());
        this.p = true;
        goto L34
    L28:
        r9 = null;
    L34:
        if (this.o == (-1)) goto L36;
    L38:
        boolean r16 = false;
    L39:
        this.U = r16;
        goto L41
    L36:
        if (r11.isPointInChildBounds(r12, r7, this.aa) == true) goto L38;
        r16 = true;
        goto L39
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean b(CoordinatorLayout r3, V r4, MotionEvent r5) {
        if (r4.isShown() == true) goto L6;
        return false;
    L6:
        int r6 = r5.getActionMasked();
        if (this.h != 1) goto L11;
        if (r6 != 0) goto L11;
        return true;
    L11:
        if (n() == false) goto L13;
        this.j.b(r5);
    L13:
        if (r6 != 0) goto L16;
        m();
    L16:
        if (this.Z != null) goto L18;
        this.Z = VelocityTracker.obtain();
    L18:
        this.Z.addMovement(r5);
        if (n() == false) goto L28;
        if (r6 != 2) goto L28;
        if (this.U == true) goto L28;
        if (Math.abs(this.aa - r5.getY()) <= this.j.f()) goto L28;
        this.j.a(r4, r5.getPointerId(r5.getActionIndex()));
    L28:
        return !this.U;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout r1, V r2, View r3, View r4, int r5, int r6) {
        this.V = 0;
        this.W = false;
        if ((r5 & 2) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void a(CoordinatorLayout r2, V r3, View r4, int r5, int r6, int[] r7, int r8) {
        if (r8 != 1) goto L5;
        return;
    L5:
        WeakReference<View> r9 = this.n;
        if (r9 == null) goto L8;
        View r10 = (View) ZeusTransformUtils.preCheckCast(r9.get(), View.class, "com.obric.aiagent.plugin");
    L10:
        if (g() == false) goto L13;
        if (r4 == r10) goto L13;
        return;
    L13:
        int r11 = r3.getTop();
        int r12 = r11 - r6;
        if (r6 > 0) goto L16;
        if (r6 < 0) goto L24;
    L35:
        h(r3.getTop());
        this.V = r6;
        this.W = true;
        return;
    L24:
        if (r4.canScrollVertically(-1) == true) goto L35;
        int r13 = this.f13245e;
        if (r12 <= r13) goto L32;
        if (this.g == true) goto L32;
        r7[1] = r11 - r13;
        ViewCompat.f(r3, -r7[1]);
        g(4);
    L32:
        if (this.T == true) goto L34;
        return;
    L34:
        r7[1] = r6;
        ViewCompat.f(r3, -r6);
        g(1);
        goto L35
    L16:
        if (r12 >= b()) goto L19;
        r7[1] = r11 - b();
        ViewCompat.f(r3, -r7[1]);
        g(3);
        goto L35
    L19:
        if (this.T == true) goto L21;
        return;
    L21:
        r7[1] = r6;
        ViewCompat.f(r3, -r6);
        g(1);
        goto L35
    L8:
        r10 = null;
        goto L10
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void a(CoordinatorLayout r3, V r4, View r5, int r6) {
        int r0 = 3;
        if (r4.getTop() != b()) goto L7;
        g(3);
        return;
    L7:
        if (g() == false) goto L16;
        WeakReference<View> r7 = this.n;
        if (r7 != null) goto L11;
        return;
    L11:
        if (r5 == r7.get()) goto L13;
        return;
    L13:
        if (this.W == true) goto L16;
        return;
    L16:
        if (this.V <= 0) goto L24;
        if (this.r == false) goto L21;
    L52:
        a(r4, r0, false);
        this.W = false;
        return;
    L21:
        if (r4.getTop() <= this.f13243c) goto L52;
    L51:
        r0 = 6;
        goto L52
    L24:
        if (this.g == false) goto L29;
        if (a(r4, p()) == false) goto L29;
        r0 = 5;
    L29:
        if (this.V != 0) goto L47;
        int r8 = r4.getTop();
        if (this.r == true) goto L33;
        int r1 = this.f13243c;
        if (r8 >= r1) goto L44;
        if (r8 < Math.abs(r8 - this.f13245e)) goto L52;
        if (h() == false) goto L51;
    L48:
        r0 = 4;
        goto L52
    L44:
        if (Math.abs(r8 - r1) >= Math.abs(r8 - this.f13245e)) goto L48;
    L33:
        if (Math.abs(r8 - this.f13242b) >= Math.abs(r8 - this.f13245e)) goto L48;
    L47:
        if (this.r == true) goto L48;
        int r9 = r4.getTop();
        if (Math.abs(r9 - this.f13243c) >= Math.abs(r9 - this.f13245e)) goto L48;
        goto L48
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout r4, V r5, View r6, float r7, float r8) {
        if (g() == false) goto L14;
        WeakReference<View> r0 = this.n;
        if (r0 != null) goto L7;
        return false;
    L7:
        if (r6 == r0.get()) goto L9;
        return false;
    L9:
        if (this.h == 3) goto L11;
    L12:
        return true;
    L11:
        if (super.a(r4, r5, r6, r7, r8) == true) goto L12;
        return false;
    L14:
        return false;
    }

    public void a(boolean r2) {
        if (this.r != r2) goto L5;
        return;
    L5:
        this.r = r2;
        if (this.m == null) goto L9;
        k();
    L9:
        if (this.r == true) goto L11;
    L13:
        int r3 = this.h;
    L14:
        g(r3);
        q();
        return;
    L11:
        if (this.h != 6) goto L13;
        r3 = 3;
        goto L14
    }

    public void a(int r1) {
        this.A = r1;
    }

    public void b(int r1) {
        this.B = r1;
    }

    public void c(int r2) {
        a(r2, false);
    }

    public final void a(int r4, boolean r5) {
        boolean r0 = true;
        if (r4 != (-1)) goto L8;
        if (this.v == true) goto L12;
        this.v = true;
    L14:
        if (r0 == false) goto L17;
        f(r5);
        return;
    L17:
        return;
    L12:
        r0 = false;
        goto L14
    L8:
        if (this.v == false) goto L10;
    L13:
        this.v = false;
        this.u = Math.max(0, r4);
        goto L14
    L10:
        if (this.u == r4) goto L12;
        goto L12
    }

    private void f(boolean r5) {
        if (this.m == null) goto L12;
        k();
        if (this.h != 4) goto L13;
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.m.get(), View.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L14;
        if (r5 == false) goto L10;
        f(4);
        return;
    L10:
        r0.requestLayout();
        return;
    L14:
        return;
    L13:
        return;
    }

    public void a(float r2) {
        if (r2 <= 0.0f) goto L11;
        if (r2 >= 1.0f) goto L11;
        this.f13244d = r2;
        if (this.m == null) goto L12;
        l();
        return;
    L12:
        return;
    L11:
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }

    public void d(int r1) {
        if (r1 < 0) goto L6;
        this.f13241a = r1;
        return;
    L6:
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public int b() {
        if (this.r == true) goto L11;
        int r0 = this.f13241a;
        if (this.H == false) goto L8;
        int r2 = 0;
    L10:
        return Math.max(r0, r2);
    L8:
        r2 = this.M;
        goto L10
    L11:
        return this.f13242b;
    }

    public void b(boolean r2) {
        if (this.g == r2) goto L11;
        this.g = r2;
        if (r2 == false) goto L7;
    L9:
        q();
        return;
    L7:
        if (this.h != 5) goto L9;
        f(4);
        goto L9
    }

    public boolean c() {
        return this.g;
    }

    public void c(boolean r1) {
        this.S = r1;
    }

    public void d(boolean r1) {
        this.T = r1;
    }

    public void e(int r1) {
        this.q = r1;
    }

    @Deprecated
    public void a(a r3) {
        a(TAG, "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.Y.clear();
        if (r3 == null) goto L6;
        this.Y.add(r3);
        return;
    }

    public void b(a r2) {
        if (this.Y.contains(r2) == true) goto L6;
        this.Y.add(r2);
        return;
    }

    public void c(a r1) {
        this.Y.remove(r1);
    }

    public void f(int r4) {
        if (r4 != 1) goto L5;
    L29:
        StringBuilder r1 = new StringBuilder().append("STATE_");
        if (r4 != 1) goto L32;
        String r5 = "DRAGGING";
    L34:
        throw new IllegalArgumentException(r1.append(r5).append(" should not be set externally.").toString());
    L32:
        r5 = "SETTLING";
        goto L34
    L5:
        if (r4 == 2) goto L29;
        if (this.g == true) goto L14;
        if (r4 != 5) goto L14;
        a(TAG, "Cannot set state: " + r4);
        return;
    L14:
        if (r4 == 6) goto L16;
    L20:
        final int r0 = r4;
    L21:
        WeakReference<V> r2 = this.m;
        if (r2 != null) goto L24;
    L27:
        g(r4);
        return;
    L24:
        if (r2.get() == null) goto L27;
        final View r6 = (View) ZeusTransformUtils.preCheckCast(this.m.get(), View.class, "com.obric.aiagent.plugin");
        a(r6, new AnonymousClass1(this, r6, r0));
        return;
    L16:
        if (this.r == false) goto L20;
        if (j(r4) > this.f13242b) goto L20;
        r0 = 3;
        goto L21
    }

    private void a(V r3, Runnable r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
        if (c(r3) == false) goto L5;
        r3.post(r5);
        return;
    L5:
        r5.run();
    }

    private boolean c(V r1) {
        ViewParent r0 = r1.getParent();
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.isLayoutRequested() == false) goto L9;
        if (ViewCompat.I(r1) == false) goto L9;
        return true;
    }

    public void e(boolean r1) {
        this.D = r1;
    }

    public boolean d() {
        return this.D;
    }

    public int e() {
        return this.h;
    }

    void g(int r8) {
        if (this.h != r8) goto L5;
        return;
    L5:
        this.h = r8;
        if (r8 == 4) goto L12;
        if (r8 == 3) goto L12;
        if (r8 == 6) goto L12;
        if (this.g == false) goto L13;
        if (r8 == 5) goto L12;
    L13:
        WeakReference<V> r4 = this.m;
        if (r4 != null) goto L16;
        return;
    L16:
        View r5 = (View) ZeusTransformUtils.preCheckCast(r4.get(), View.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L19;
        return;
    L19:
        int r6 = 0;
        if (r8 != 3) goto L22;
        g(true);
    L26:
        i(r8);
    L28:
        if (r6 >= this.Y.size()) goto L30;
        ((a) ZeusTransformUtils.preCheckCast(this.Y.get(r6), a.class, "com.obric.aiagent.plugin")).a(r5, r8);
        r6 = r6 + 1;
        goto L28
    L30:
        q();
        return;
    L22:
        if (r8 == 6) goto L25;
        if (r8 == 5) goto L25;
        if (r8 != 4) goto L26;
    L25:
        g(false);
    L12:
        this.i = r8;
        goto L13
    }

    private void i(int r6) {
        if (r6 != 2) goto L6;
        return;
    L6:
        if (r6 != 3) goto L8;
        boolean r7 = true;
    L10:
        if (this.O == r7) goto L24;
        this.O = r7;
        if (this.y == null) goto L25;
        ValueAnimator r1 = this.Q;
        if (r1 != null) goto L16;
        return;
    L16:
        if (r1.isRunning() == false) goto L19;
        this.Q.reverse();
        return;
    L19:
        if (r7 == false) goto L21;
        float r8 = 0.0f;
    L22:
        this.Q.setFloatValues(new float[]{1.0f - r8, r8});
        this.Q.start();
        return;
    L21:
        r8 = 1.0f;
        goto L22
    L25:
        return;
    L24:
        return;
    L8:
        r7 = false;
        goto L10
    }

    private int j() {
        if (this.v == false) goto L8;
        int r0 = Math.min(Math.max(this.w, this.l - ((this.k * 9) / 16)), this.X);
        int r3 = this.L;
    L6:
        return r0 + r3;
    L8:
        if (this.D == false) goto L10;
    L15:
        r0 = this.u;
        r3 = this.L;
        goto L6
    L10:
        if (this.E == true) goto L15;
        int r1 = this.C;
        if (r1 <= 0) goto L15;
        return Math.max(this.u, r1 + this.x);
    }

    private void k() {
        int r0 = j();
        if (this.r == false) goto L5;
        this.f13245e = Math.max(this.l - r0, this.f13242b);
        return;
    L5:
        this.f13245e = this.l - r0;
    }

    private void l() {
        this.f13243c = (int) (this.l * (1.0f - this.f13244d));
    }

    private void m() {
        this.o = -1;
        VelocityTracker r0 = this.Z;
        if (r0 == null) goto L6;
        r0.recycle();
        this.Z = null;
        return;
    }

    private void a(SavedState r4) {
        int r0 = this.q;
        if (r0 != 0) goto L6;
        return;
    L6:
        if (r0 != (-1)) goto L8;
    L9:
        this.u = r4.peekHeight;
    L10:
        int r1 = this.q;
        if (r1 != (-1)) goto L13;
    L14:
        this.r = r4.fitToContents;
    L15:
        int r2 = this.q;
        if (r2 != (-1)) goto L18;
    L19:
        this.g = r4.hideable;
    L20:
        int r3 = this.q;
        if (r3 != (-1)) goto L23;
    L24:
        this.S = r4.skipCollapsed;
        return;
    L23:
        if ((r3 & 8) == 8) goto L24;
        return;
    L18:
        if ((r2 & 4) != 4) goto L20;
    L13:
        if ((r1 & 2) != 2) goto L15;
    L8:
        if ((r0 & 1) != 1) goto L10;
        goto L9
    }

    boolean a(View r5, float r6) {
        if (this.S == false) goto L6;
        return true;
    L6:
        if (r5.getTop() >= this.f13245e) goto L9;
        return false;
    L9:
        if ((Math.abs((r5.getTop() + (r6 * 0.1f)) - this.f13245e) / j()) <= 0.5f) goto L12;
        return true;
    L12:
        return false;
    }

    View a(View r4) {
        if (ViewCompat.D(r4) == false) goto L6;
        return r4;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, ViewGroup.class) == false) goto L13;
        ViewGroup r5 = (ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.aiagent.plugin");
        int r0 = 0;
        int r1 = r5.getChildCount();
    L8:
        if (r0 >= r1) goto L17;
        View r2 = a(r5.getChildAt(r0));
        if (r2 != null) goto L11;
        r0 = r0 + 1;
        goto L8
    L11:
        return r2;
    L17:
        return null;
    L13:
        return null;
    }

    private boolean n() {
        if (this.j != null) goto L5;
    L9:
        return false;
    L5:
        if (this.T == false) goto L7;
        return true;
    L7:
        if (this.h != 1) goto L9;
        return true;
    }

    private void a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (this.N != null) goto L5;
        return;
    L5:
        MaterialShapeDrawable r0 = new MaterialShapeDrawable(this.N);
        this.y = r0;
        r0.initializeElevationOverlay(r5);
        ColorStateList r1 = this.z;
        if (r1 == null) goto L8;
        this.y.setFillColor(r1);
        return;
    L8:
        TypedValue r2 = new TypedValue();
        r5.getTheme().resolveAttribute(android.R.attr.colorBackground, r2, true);
        this.y.setTint(r2.data);
    }

    MaterialShapeDrawable f() {
        return this.y;
    }

    private void o() {
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.Q = r0;
        r0.setDuration(500);
        this.Q.addUpdateListener(new AnonymousClass2(this));
    }

    private void d(View r3) {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
    L9:
        final boolean r0 = false;
    L11:
        if (this.E == false) goto L13;
    L24:
        r.a(r3, new AnonymousClass3(this, r0));
        return;
    L13:
        if (this.F == true) goto L24;
        if (this.G == true) goto L24;
        if (this.I == true) goto L24;
        if (this.f13240J == true) goto L24;
        if (this.K == true) goto L24;
        if (r0 == true) goto L24;
        return;
    L5:
        if (d() == true) goto L9;
        if (this.v == true) goto L9;
        r0 = true;
        goto L11
    }

    private float p() {
        VelocityTracker r0 = this.Z;
        if (r0 != null) goto L6;
        return 0.0f;
    L6:
        r0.computeCurrentVelocity(1000, this.t);
        return this.Z.getYVelocity(this.o);
    }

    private void a(View r3, int r4, boolean r5) {
        int r0 = j(r4);
        c r1 = this.j;
        if (r1 == null) goto L11;
        if (r5 == false) goto L9;
        if (r1.a(r3.getLeft(), r0) == false) goto L11;
    L10:
        boolean r6 = true;
    L12:
        if (r6 == false) goto L14;
        g(2);
        i(r4);
        this.P.a(r4);
        return;
    L14:
        g(r4);
        return;
    L9:
        if (r1.a(r3, r3.getLeft(), r0) == true) goto L10;
    L11:
        r6 = false;
        goto L12
    }

    private int j(int r3) {
        if (r3 == 3) goto L19;
        if (r3 == 4) goto L17;
        if (r3 == 5) goto L15;
        if (r3 != 6) goto L13;
        return this.f13243c;
    L13:
        throw new IllegalArgumentException("Invalid state to get top offset: " + r3);
    L15:
        return this.l;
    L17:
        return this.f13245e;
    L19:
        return b();
    }

    void h(int r6) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.m.get(), View.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.Y.isEmpty() == true) goto L19;
        int r1 = this.f13245e;
        if (r6 <= r1) goto L9;
    L12:
        int r2 = this.f13245e;
        float r7 = r2 - r6;
        float r3 = this.l - r2;
    L13:
        float r8 = r7 / r3;
        int r4 = 0;
    L15:
        if (r4 >= this.Y.size()) goto L20;
        ((a) ZeusTransformUtils.preCheckCast(this.Y.get(r4), a.class, "com.obric.aiagent.plugin")).a(r0, r8);
        r4 = r4 + 1;
        goto L15
    L20:
        return;
    L9:
        if (r1 == b()) goto L12;
        int r5 = this.f13245e;
        r7 = r5 - r6;
        r3 = r5 - b();
        goto L13
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

    private void g(boolean r9) {
        WeakReference<V> r0 = this.m;
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
        if (this.ab != null) goto L14;
        this.ab = new HashMap(r3);
        goto L15
    L14:
        return;
    L15:
        int r4 = 0;
    L16:
        if (r4 >= r3) goto L35;
        View r5 = r2.getChildAt(r4);
        if (r5 == this.m.get()) goto L34;
        if (r9 == false) goto L28;
        if (Build.VERSION.SDK_INT < 16) goto L25;
        this.ab.put(r5, Integer.valueOf(r5.getImportantForAccessibility()));
    L25:
        if (this.s == false) goto L34;
        ViewCompat.c(r5, 4);
        goto L34
    L28:
        if (this.s == false) goto L34;
        Map<View, Integer> r6 = this.ab;
        if (r6 == null) goto L34;
        if (r6.containsKey(r5) == false) goto L34;
        ViewCompat.c(r5, ((Integer) ZeusTransformUtils.preCheckCast(this.ab.get(r5), Integer.class, "com.obric.aiagent.plugin")).intValue());
    L34:
        r4 = r4 + 1;
        goto L16
    L35:
        if (r9 == true) goto L38;
        this.ab = null;
        return;
    L38:
        if (this.s == false) goto L50;
        ((View) ZeusTransformUtils.preCheckCast(this.m.get(), View.class, "com.obric.aiagent.plugin")).sendAccessibilityEvent(8);
        return;
    }

    private void q() {
        WeakReference<V> r0 = this.m;
        if (r0 != null) goto L5;
        return;
    L5:
        View r1 = (View) ZeusTransformUtils.preCheckCast(r0.get(), View.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L8;
        return;
    L8:
        ViewCompat.d(r1, UiType.FLAG_WIFI_QRCODE_CARD);
        ViewCompat.d(r1, 262144);
        ViewCompat.d(r1, 1048576);
        int r2 = this.ac;
        if (r2 == (-1)) goto L11;
        ViewCompat.d(r1, r2);
    L11:
        int r3 = 6;
        if (this.r == true) goto L17;
        if (this.h == 6) goto L17;
        this.ac = a(r1, ZeusTransformUtils.mapRes(R.string.bottomsheet_action_expand_halfway, WsChannelMultiProcessSharedProvider.STRING_TYPE, "bottomsheet_action_expand_halfway"), 6);
    L17:
        if (this.g == true) goto L19;
    L21:
        int r4 = this.h;
        if (r4 == 3) goto L32;
        if (r4 == 4) goto L28;
        if (r4 != 6) goto L38;
        a(r1, androidx.core.view.accessibility.b.a.t, 4);
        a(r1, androidx.core.view.accessibility.b.a.s, 3);
        return;
    L38:
        return;
    L28:
        if (this.r == false) goto L30;
        r3 = 3;
    L30:
        a(r1, androidx.core.view.accessibility.b.a.s, r3);
        return;
    L32:
        if (this.r == false) goto L34;
        r3 = 4;
    L34:
        a(r1, androidx.core.view.accessibility.b.a.t, r3);
        return;
    L19:
        if (this.h == 5) goto L21;
        a(r1, androidx.core.view.accessibility.b.a.u, 5);
        goto L21
    }

    private void a(V r1, androidx.core.view.accessibility.b.a r2, int r3) {
        ViewCompat.a(r1, r2, null, k(r3));
    }

    private int a(V r2, int r3, int r4) {
        return ViewCompat.a(r2, ZeusTransformUtils.getResources(r2, "com.obric.aiagent.plugin").getString(r3), k(r4));
    }

    private d k(final int r2) {
        return new AnonymousClass5(this, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
