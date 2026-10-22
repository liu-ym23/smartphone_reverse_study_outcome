package com.bytedance.ai.view.popup.anim;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import com.bytedance.ai.utils.g;
import com.bytedance.ai.view.popup.AppletPopup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public int A;
    public int B;
    public boolean C;
    public int D;
    public com.bytedance.ai.view.popup.anim.a E;
    public boolean F;
    public int G;
    public boolean H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f37833J;
    public WeakReference<V> K;
    public WeakReference<View> L;
    public final ArrayList<b> M;
    public VelocityTracker N;
    public int O;
    public int P;
    public int Q;
    public boolean R;
    public boolean S;
    public Map<View, Integer> T;
    public final a U;
    public AnimController V;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f37834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f37835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f37836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f37837d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f37838e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f37839f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f37840g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BottomSheetBehavior<V>.c f37841h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ValueAnimator f37842i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f37843j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f37844k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f37845l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f37846m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f37847n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f37848o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f37849p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f37850q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f37851r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f37852s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public WeakReference<View> f37853t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public WeakReference<View> f37854u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f37855v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f37856w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f37857x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f37858y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f37859z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SaveFlags {
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f37860a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f37861b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f37862c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f37863d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f37864e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f37865f;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel r100) {
                return new SavedState(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int r100) {
                return new SavedState[r100];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel r100, ClassLoader r101) {
                return new SavedState(r100);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r100) {
            super(r100);
            this.f37860a = r100.readInt();
            this.f37861b = r100.readInt();
            this.f37862c = r100.readInt();
            boolean r101 = false;
            if (r100.readInt() != 1) goto L5;
            boolean r102 = true;
        L6:
            this.f37863d = r102;
            if (r100.readInt() != 1) goto L9;
            boolean r103 = true;
        L10:
            this.f37864e = r103;
            if (r100.readInt() != 1) goto L13;
            r101 = true;
        L13:
            this.f37865f = r101;
            return;
        L9:
            r103 = false;
            goto L10
        L5:
            r102 = false;
            goto L6
        }

        public SavedState(Parcelable r100, BottomSheetBehavior<?> r101) {
            super(r100);
            this.f37860a = r101.D;
            this.f37861b = r101.f37837d;
            this.f37862c = r101.f37856w;
            this.f37863d = r101.f37835b;
            this.f37864e = r101.f37850q;
            this.f37865f = r101.f37851r;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeInt(this.f37860a);
            r100.writeInt(this.f37861b);
            r100.writeInt(this.f37862c);
            r100.writeInt(this.f37863d ? 1 : 0);
            r100.writeInt(this.f37864e ? 1 : 0);
            r100.writeInt(this.f37865f ? 1 : 0);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public class a extends com.bytedance.ai.view.popup.anim.a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior f37866a;

        public a(BottomSheetBehavior r100) {
            this.f37866a = r100;
        }
    }

    public static abstract class b {
        public b() {
        }

        public abstract void a(View r100, float r101);

        public abstract void b(View r100, int r101);
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f37867a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f37868b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f37869c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior f37870d;

        public final void a() {
            com.bytedance.ai.view.popup.anim.a r100 = this.f37870d.E;
            if (r100 != null) goto L5;
        L28:
            this.f37870d.setStateInternal(this.f37869c);
        L29:
            this.f37868b = false;
            return;
        L5:
            if (r100.f37872a != 2) goto L23;
            boolean r101 = r100.f37887p.computeScrollOffset();
            int r102 = r100.f37887p.getCurrX();
            int r103 = r100.f37887p.getCurrY();
            int r104 = r102 - r100.f37889r.getLeft();
            int r105 = r103 - r100.f37889r.getTop();
            if (r104 == 0) goto L9;
            ViewCompat.offsetLeftAndRight(r100.f37889r, r104);
        L9:
            if (r105 == 0) goto L11;
            ViewCompat.offsetTopAndBottom(r100.f37889r, r105);
        L11:
            if (r104 != 0) goto L13;
            if (r105 != 0) goto L13;
        L14:
            if (r101 == true) goto L16;
        L20:
            if (r101 == true) goto L23;
            r100.f37891t.post(r100.f37892u);
            goto L23
        L16:
            if (r102 != r100.f37887p.getFinalX()) goto L20;
            if (r103 != r100.f37887p.getFinalY()) goto L20;
            r100.f37887p.abortAnimation();
            r101 = false;
        L13:
            ((a) r100.f37888q).f37866a.dispatchOnSlide(r103);
        L23:
            if (r100.f37872a != 2) goto L25;
            boolean r106 = true;
        L26:
            if (r106 == false) goto L28;
            ViewCompat.postOnAnimation(this.f37867a, this);
            goto L29
        L25:
            r106 = false;
            goto L26
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(BottomSheetBehavior r100, View r101, int r102) {
            this.f37870d = r100;
            this.f37867a = r101;
            this.f37869c = r102;
        }
    }

    public final int a() {
        int r100 = this.f37856w;
        if (r100 == (-1)) goto L5;
        return r100;
    L5:
        return this.f37837d;
    }

    public final void calculateCollapsedOffset() {
        if (this.f37838e == false) goto L5;
        int r100 = Math.max(this.f37839f, this.f37833J - ((this.I * 9) / 16));
    L7:
        if (this.f37835b == false) goto L9;
        this.f37849p = Math.max(this.f37833J - r100, this.f37846m);
        return;
    L9:
        this.f37849p = this.f37833J - r100;
        return;
    L5:
        r100 = this.f37837d + 0;
        goto L7
    }

    public final int getExpandedOffset() {
        if (this.f37835b == false) goto L6;
        return this.f37846m;
    L6:
        return this.f37843j;
    }

    public BottomSheetBehavior() {
        this.f37834a = 0;
        this.f37835b = true;
        this.f37841h = null;
        this.f37848o = 0.5f;
        this.f37852s = true;
        this.f37853t = null;
        this.f37854u = null;
        this.B = 5;
        this.C = false;
        this.D = 4;
        this.M = new ArrayList();
        this.U = new a(this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.K = null;
        this.E = null;
    }

    public final void dispatchOnSlide(int r110) {
        V r100 = this.K.get();
        int r101 = 0;
        WeakReference<View> r102 = this.f37853t;     // Catch: Exception -> L46
        View r103 = null;
        if (r102 != null) goto L6;
        View r104 = null;
    L7:
        WeakReference<View> r105 = this.f37854u;     // Catch: Exception -> L46
        if (r105 != null) goto L10;
        View r106 = null;
    L11:
        AnimController r107 = this.V;     // Catch: Exception -> L46
        if (r107 == null) goto L48;
        boolean r108 = true;
        if (r107.f37826a == AnimController.AnimProcessType.NONE) goto L16;
        boolean r109 = true;
    L17:
        if (r109 == false) goto L48;
        String r111 = r107.f37828c;     // Catch: Exception -> L46
        if (Intrinsics.areEqual(r111, AnimationStyle.SLIDE.getValue()) == false) goto L21;
    L24:
        boolean r112 = true;
    L25:
        if (r112 == true) goto L48;
        if (r110 > this.f37849p) goto L48;
        r100.getLayoutParams().height = this.f37833J - r110;     // Catch: Exception -> L46
        if (r104 == null) goto L44;
        ViewGroup.LayoutParams r113 = r104.getLayoutParams();     // Catch: Exception -> L46
        int r114 = this.f37833J - r110;     // Catch: Exception -> L46
        int r115 = AppletPopup.R;     // Catch: Exception -> L46
        if (r106 != null) goto L33;
    L42:
        int r116 = 0;
    L43:
        r113.height = r114 - r116;     // Catch: Exception -> L46
        goto L44
    L33:
        if (r106.getVisibility() == 0) goto L36;
        r108 = false;
    L36:
        if (r108 == false) goto L38;
        r103 = r106;
    L38:
        if (r103 == null) goto L42;
        ViewGroup.LayoutParams r117 = r103.getLayoutParams();     // Catch: Exception -> L46
        if (r117 == null) goto L42;
        r116 = r117.height;     // Catch: Exception -> L46
    L44:
        r100.requestLayout();     // Catch: Exception -> L46
        goto L48
    L21:
        if (Intrinsics.areEqual(r111, AnimationStyle.ZOOM.getValue()) == true) goto L24;
        r112 = false;
        goto L25
    L16:
        r109 = false;
    L48:
        if (r100 != null) goto L50;
        return;
    L50:
        if (this.M.isEmpty() == true) goto L66;
        int r118 = this.f37849p;
        if (r110 <= r118) goto L54;
    L57:
        int r119 = this.f37849p;
        float r120 = r119 - r110;
        float r121 = this.f37833J - r119;
    L58:
        float r122 = r120 / r121;
    L60:
        if (r101 >= this.M.size()) goto L67;
        ((b) ListProtector.get(this.M, r101)).a(r100, r122);
        r101 = r101 + 1;
        goto L60
    L67:
        return;
    L54:
        if (r118 == getExpandedOffset()) goto L57;
        int r123 = this.f37849p;
        r120 = r123 - r110;
        r121 = r123 - getExpandedOffset();
        goto L58
    L66:
        return;
    L10:
        r106 = r105.get();     // Catch: Exception -> L46
        goto L11
    L6:
        r104 = r102.get();     // Catch: Exception -> L46
    L46:
        e = move-exception;
        e.toString();
        goto L48
    }

    public final View findScrollingChild(View r100) {
        if (ViewCompat.isNestedScrollingEnabled(r100) == false) goto L6;
        return r100;
    L6:
        if ((r100 instanceof ViewGroup) == false) goto L13;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L17;
        View r104 = findScrollingChild(r101.getChildAt(r103));
        if (r104 != null) goto L11;
        r103 = r103 + 1;
        goto L8
    L11:
        return r104;
    L17:
        return null;
    L13:
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams r100) {
        super.onAttachedToLayoutParams(r100);
        this.K = null;
        this.E = null;
    }

    public final void setFitToContents(boolean r100) {
        if (this.f37835b != r100) goto L5;
        return;
    L5:
        this.f37835b = r100;
        if (this.K == null) goto L9;
        calculateCollapsedOffset();
    L9:
        if (this.f37835b == true) goto L11;
    L13:
        int r101 = this.D;
    L14:
        setStateInternal(r101);
        return;
    L11:
        if (this.D != 6) goto L13;
        r101 = 3;
        goto L14
    }

    public final void setHideable(boolean r100) {
        if (this.f37850q == r100) goto L10;
        this.f37850q = r100;
        if (r100 == false) goto L7;
        return;
    L7:
        if (this.D != 5) goto L12;
        b(4, true);
        return;
    L12:
        return;
    }

    public final void setPeekHeight(int r100) {
        boolean r101 = false;
        if (r100 != (-1)) goto L8;
        if (this.f37838e == true) goto L13;
        this.f37838e = true;
    L12:
        r101 = true;
    L13:
        if (r101 == true) goto L15;
        return;
    L15:
        if (this.K == null) goto L23;
        calculateCollapsedOffset();
        if (this.D != 4) goto L24;
        V r102 = this.K.get();
        if (r102 == null) goto L25;
        r102.requestLayout();
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L8:
        if (this.f37838e == false) goto L10;
    L11:
        this.f37838e = false;
        this.f37837d = Math.max(0, r100);
        goto L12
    L10:
        if (this.f37837d == r100) goto L13;
        goto L11
    }

    public final void setStateInternal(int r100) {
        int r101 = this.D;
        if (r101 != r100) goto L5;
        return;
    L5:
        this.B = r101;
        this.D = r100;
        WeakReference<V> r102 = this.K;
        if (r102 != null) goto L8;
        return;
    L8:
        V r103 = r102.get();
        if (r103 != null) goto L11;
        return;
    L11:
        int r104 = 0;
        boolean r105 = true;
        if (r100 != 3) goto L15;
        updateImportantForAccessibility(true);
    L22:
        if (r100 == 2) goto L31;
        if (r100 == 3) goto L28;
        r105 = false;
    L28:
        if (this.f37840g == r105) goto L31;
        this.f37840g = r105;
    L31:
        if (r104 >= this.M.size()) goto L33;
        ((b) ListProtector.get(this.M, r104)).b(r103, r100);
        r104 = r104 + 1;
        goto L31
    L33:
        return;
    L15:
        if (r100 != 6) goto L17;
    L20:
        updateImportantForAccessibility(false);
        goto L22
    L17:
        if (r100 == 5) goto L20;
        if (r100 != 4) goto L22;
        goto L20
    }

    public final void updateImportantForAccessibility(boolean r100) {
        WeakReference<V> r101 = this.K;
        if (r101 != null) goto L5;
        return;
    L5:
        ViewParent r102 = r101.get().getParent();
        if ((r102 instanceof CoordinatorLayout) == true) goto L8;
        return;
    L8:
        CoordinatorLayout r103 = (CoordinatorLayout) r102;
        int r104 = r103.getChildCount();
        if (r100 == true) goto L11;
    L14:
        int r105 = 0;
    L15:
        if (r105 >= r104) goto L22;
        View r106 = r103.getChildAt(r105);
        if (r106 == this.K.get()) goto L21;
        if (r100 == false) goto L21;
        Map<View, Integer> r107 = this.T;
        HashMap r108 = (HashMap) r107;
        r108.put(r106, Integer.valueOf(r106.getImportantForAccessibility()));
    L21:
        r105 = r105 + 1;
        goto L15
    L22:
        if (r100 == true) goto L29;
        this.T = null;
        return;
    L29:
        return;
    L11:
        if (this.T != null) goto L13;
        this.T = new HashMap(r104);
        goto L14
    }

    public BottomSheetBehavior(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f37834a = 0;
        this.f37835b = true;
        this.f37841h = null;
        this.f37848o = 0.5f;
        this.f37852s = true;
        this.f37853t = null;
        this.f37854u = null;
        this.B = 5;
        this.C = false;
        this.D = 4;
        this.M = new ArrayList();
        this.U = new a(this);
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.behavior_fitToContents, R.attr.behavior_hideable, R.attr.behavior_peekHeight, R.attr.behavior_skipCollapsed});
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f37842i = r103;
        r103.setDuration(500);
        this.f37842i.addUpdateListener(new w5.b(this));
        TypedValue r104 = r102.peekValue(2);
        if (r104 == null) goto L7;
        int r105 = r104.data;
        if (r105 != (-1)) goto L7;
        setPeekHeight(r105);
    L8:
        setHideable(r102.getBoolean(1, false));
        setFitToContents(true);
        this.f37851r = false;
        this.f37852s = true;
        this.f37834a = 0;
        this.f37848o = 0.5f;
        if (this.K == null) goto L11;
        this.f37847n = (int) (this.f37833J * (1.0f - 0.5f));
    L11:
        this.f37843j = 0;
        r102.recycle();
        this.f37836c = ViewConfiguration.get(r100).getScaledMaximumFlingVelocity();
        return;
    L7:
        setPeekHeight(r102.getDimensionPixelSize(2, -1));
        goto L8
    }

    public final void b(int r100, boolean r101) {
        if (r100 != this.D) goto L5;
        return;
    L5:
        WeakReference<V> r102 = this.K;
        if (r102 == null) goto L8;
        V r103 = r102.get();
        if (r103 == null) goto L34;
        ViewParent r104 = r103.getParent();
        if (r104 != null) goto L25;
    L29:
        c(r103, r100, r101);
        return;
    L25:
        if (r104.isLayoutRequested() == false) goto L29;
        if (ViewCompat.isAttachedToWindow(r103) == false) goto L29;
        r103.post(new w5.a(this, r103, r100, r101));
        return;
    L34:
        return;
    L8:
        if (r100 != 4) goto L10;
    L17:
        this.D = r100;
        return;
    L10:
        if (r100 == 3) goto L17;
        if (r100 == 6) goto L17;
        if (this.f37850q == true) goto L16;
        return;
    L16:
        if (r100 == 5) goto L17;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final Parcelable onSaveInstanceState(CoordinatorLayout r100, V r101) {
        return new SavedState(super.onSaveInstanceState(r100, r101), this);
    }

    public final boolean shouldHide(View r100, float r101) {
        if (this.f37851r == false) goto L8;
        if ((r100.getTop() - this.f37843j) < this.A) goto L8;
        return true;
    L8:
        if (this.B != 3) goto L14;
        if (this.A == 0) goto L14;
        if ((r100.getTop() - this.f37843j) < this.A) goto L14;
    L19:
        return true;
    L14:
        if (this.B != 4) goto L21;
        if (this.f37859z == 0) goto L21;
        if ((r100.getTop() - this.f37849p) >= this.f37859z) goto L19;
    L21:
        if (r100.getTop() >= this.f37849p) goto L24;
        return false;
    L24:
        if (this.f37838e == false) goto L26;
        int r102 = Math.max(this.f37839f, this.f37833J - ((this.I * 9) / 16));
    L28:
        if ((Math.abs((r100.getTop() + (r101 * 0.1f)) - this.f37849p) / r102) > 0.5f) goto L32;
        return false;
    L32:
        return true;
    L26:
        r102 = this.f37837d + 0;
        goto L28
    }

    public final void c(View r100, int r101, boolean r102) {
        if (r101 != 4) goto L6;
        int r103 = this.f37849p;
    L19:
        startSettlingAnimation(r100, r101, r103, !r102);
        return;
    L6:
        if (r101 != 6) goto L12;
        r103 = this.f37847n;
        if (this.f37835b == false) goto L19;
        int r104 = this.f37846m;
        if (r103 > r104) goto L19;
        r103 = r104;
        r101 = 3;
        goto L19
    L12:
        if (r101 != 3) goto L15;
        r103 = getExpandedOffset();
        goto L19
    L15:
        if (this.f37850q == false) goto L22;
        if (r101 != 5) goto L22;
        r103 = this.f37833J;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout r110, V r210, MotionEvent r211) {
        boolean r100 = false;
        int r101 = 0;
        r100 = false;
        r100 = false;
        r100 = false;
        r100 = false;
        r100 = false;
        int r102 = 1;
        if (r210.isShown() == true) goto L5;
    L238:
        this.F = true;
        return false;
    L5:
        if (this.f37852s == false) goto L7;
    L9:
        int r103 = r211.getActionMasked();
        if (r103 != 0) goto L15;
        this.O = -1;
        VelocityTracker r104 = this.N;
        if (r104 == null) goto L15;
        r104.recycle();
        this.N = null;
    L15:
        if (this.N != null) goto L17;
        this.N = VelocityTracker.obtain();
    L17:
        this.N.addMovement(r211);
        if (r103 == 0) goto L104;
        if (r103 == 1) goto L100;
        if (r103 == 2) goto L24;
        if (r103 == 3) goto L100;
    L122:
        if (this.F == true) goto L218;
        com.bytedance.ai.view.popup.anim.a r105 = this.E;
        if (r105 == null) goto L218;
        int r106 = r211.getActionMasked();
        int r107 = r211.getActionIndex();
        if (r106 != 0) goto L129;
        r105.b();
    L129:
        if (r105.f37883l != null) goto L131;
        r105.f37883l = VelocityTracker.obtain();
    L131:
        r105.f37883l.addMovement(r211);
        if (r106 == 0) goto L204;
        if (r106 != 1) goto L135;
    L203:
        int r111 = r103;
        r105.b();
    L213:
        if (r105.f37872a != 1) goto L215;
        boolean r112 = true;
    L216:
        if (r112 == false) goto L219;
        return true;
    L219:
        WeakReference<View> r108 = this.L;
        if (r108 == null) goto L222;
        View r109 = r108.get();
        int r113 = 2;
    L223:
        if (r111 != r113) goto L236;
        if (r109 == null) goto L236;
        if (this.F == true) goto L236;
        if (this.D == 1) goto L236;
        if (r110.isPointInChildBounds(r109, (int) r211.getX(), (int) r211.getY()) == true) goto L236;
        if (this.E == null) goto L236;
        if (Math.abs(this.P - r211.getY()) <= this.E.f37873b) goto L236;
        return true;
    L236:
        return false;
    L222:
        r113 = 2;
        r109 = null;
        goto L223
    L215:
        r112 = false;
        goto L216
    L135:
        if (r106 == 2) goto L154;
        if (r106 == 3) goto L203;
        if (r106 != 5) goto L140;
        int r114 = r211.getPointerId(r107);
        float r115 = r211.getX(r107);
        float r116 = r211.getY(r107);
        r105.n(r115, r116, r114);
        int r117 = r105.f37872a;
        if (r117 != 0) goto L149;
        if ((r105.f37879h[r114] & 0) == 0) goto L202;
        r105.f37888q.getClass();
    L202:
        r111 = r103;
        goto L213
    L149:
        if (r117 != 2) goto L202;
        View r118 = r105.j((int) r115, (int) r116);
        if (r118 != r105.f37889r) goto L202;
        r105.q(r118, r114);
        goto L202
    L140:
        if (r106 != 6) goto L202;
        r105.f(r211.getPointerId(r107));
        goto L202
    L154:
        if (r105.f37875d == null) goto L202;
        if (r105.f37876e == null) goto L202;
        int r119 = r211.getPointerCount();
        int r120 = 0;
    L159:
        if (r120 >= r119) goto L200;
        int r121 = r211.getPointerId(r120);
        if ((r105.f37882k & (r102 << r121)) == 0) goto L163;
        boolean r122 = true;
    L164:
        if (r122 == true) goto L166;
        boolean r123 = false;
    L167:
        if (r123 == true) goto L169;
        r111 = r103;
        int r212 = r119;
    L199:
        r120 = r120 + 1;
        r119 = r212;
        r103 = r111;
        r102 = 1;
        goto L159
    L169:
        float r124 = r211.getX(r120);
        float r125 = r211.getY(r120);
        float r126 = r124 - r105.f37875d[r121];
        float r127 = r125 - r105.f37876e[r121];
        View r128 = r105.j((int) r124, (int) r125);
        if (r128 != null) goto L172;
    L174:
        boolean r129 = false;
    L175:
        if (r129 == false) goto L191;
        r128.getLeft();
        ((a) r105.f37888q).getClass();
        r128.getLeft();
        int r130 = r128.getTop();
        int r131 = ((int) r127) + r130;
        a r132 = (a) r105.f37888q;
        int r133 = r132.f37866a.getExpandedOffset();
        BottomSheetBehavior r134 = r132.f37866a;
        r212 = r119;
        if (r134.f37850q == false) goto L179;
        int r135 = r134.f37833J;
    L180:
        int r136 = MathUtils.clamp(r131, r133, r135);
        r105.f37888q.getClass();
        com.bytedance.ai.view.popup.anim.a.c r137 = r105.f37888q;
        BottomSheetBehavior r138 = ((a) r137).f37866a;
        if (r138.f37850q == false) goto L183;
        int r139 = r138.f37833J;
    L184:
        a r140 = (a) r137;
        com.bytedance.ai.view.popup.anim.a r141 = r140.f37866a.E;
        int r142 = (int) r211.getX();
        r111 = r103;
        int r143 = (int) r211.getY();
        BottomSheetBehavior r144 = r140.f37866a;
        int r145 = r143 - (r144.f37833J - r144.f37855v);
        r141.getClass();
        if ((!com.bytedance.ai.view.popup.anim.a.a(r128, 1, r142, r145)) == false) goto L201;
        if (r139 == 0) goto L201;
        if (r139 <= 0) goto L192;
        if (r136 == r130) goto L201;
    L192:
        r105.m(r126, r127, r121);
        if (r105.f37872a == 1) goto L201;
        if (r129 == false) goto L199;
        if (r105.q(r128, r121) == false) goto L199;
    L201:
        r105.o(r211);
        goto L213
    L183:
        r139 = r138.f37849p;
        goto L184
    L179:
        r135 = r134.f37849p;
        goto L180
    L191:
        r111 = r103;
        r212 = r119;
        goto L192
    L172:
        if (r105.e(r128, r127) == false) goto L174;
        r129 = true;
        goto L175
    L166:
        r123 = true;
        goto L167
    L163:
        r122 = false;
        goto L164
    L200:
        r111 = r103;
        goto L201
    L204:
        r111 = r103;
        float r146 = r211.getX();
        float r147 = r211.getY();
        int r148 = r211.getPointerId(0);
        r105.n(r146, r147, r148);
        View r149 = r105.j((int) r146, (int) r147);
        if (r149 != r105.f37889r) goto L210;
        if (r105.f37872a != 2) goto L210;
        r105.q(r149, r148);
    L210:
        if ((r105.f37879h[r148] & 0) == 0) goto L213;
        r105.f37888q.getClass();
    L218:
        r111 = r103;
        goto L219
    L24:
        if (this.f37852s == false) goto L26;
    L27:
        int r150 = ((int) r211.getY()) - this.P;
        if (r150 >= 0) goto L30;
        boolean r151 = true;
    L31:
        if (r150 != 0) goto L33;
        return false;
    L33:
        if (r151 == false) goto L35;
        int r152 = -1;
    L36:
        g r153 = g.f37637a;
        r153.d("BottomSheetBehavior", "####pull up: " + r151 + " detected. position: " + r152 + " offset: " + r150);
        WeakReference<View> r154 = this.L;
        if (r154 == null) goto L39;
        View r155 = r154.get();
    L41:
        if (this.S == false) goto L47;
        if (r155 == null) goto L47;
        if (r155.canScrollVertically(r152) == false) goto L47;
        r153.d("BottomSheetBehavior", "####ignoreEvents");
        this.F = true;
        return false;
    L47:
        this.F = false;
        if (this.f37850q == false) goto L58;
        if (r151 == true) goto L58;
        if (this.f37851r == false) goto L58;
        if (this.D != 3) goto L58;
        if (r155 == null) goto L58;
        if (r155.canScrollVertically(1) == false) goto L58;
        return true;
    L58:
        int r156 = this.E.f37873b;
        if (r150 < (-r156)) goto L61;
        if (r150 <= r156) goto L81;
        int r157 = ((int) r211.getX()) - this.Q;
        if (Math.abs(r157) <= this.E.f37873b) goto L70;
        if (r157 <= 0) goto L69;
        r101 = 1;
        goto L70
    L69:
        r101 = -1;
    L70:
        if (r151 == false) goto L72;
        int r158 = (int) r211.getY();
        int r159 = this.f37833J - this.f37855v;
    L73:
        int r160 = r158 - r159;
        com.bytedance.ai.view.popup.anim.a r161 = this.E;
        int r162 = (int) r211.getX();
        r161.getClass();
        boolean r163 = com.bytedance.ai.view.popup.anim.a.a(r210, r101, r162, r160);
        r153.d("BottomSheetBehavior", "#####process scroll. canScroll:  " + r163);
        if (this.f37855v < this.f37837d) goto L80;
        if ((a() - this.f37837d) <= 1) goto L80;
        if (r163 == true) goto L80;
        return true;
    L80:
        return !r163;
    L72:
        r158 = this.f37833J - this.f37855v;
        r159 = (int) r211.getY();
        goto L73
    L81:
        WeakReference<View> r164 = this.L;
        if (r164 == null) goto L84;
        View r165 = r164.get();
    L85:
        if (r165 == null) goto L122;
        if (r110.isPointInChildBounds(r165, (int) r211.getX(), (int) r211.getY()) == false) goto L122;
        boolean r166 = r165.canScrollVertically(-1);
        boolean r167 = r165.canScrollVertically(1);
        if (r151 == false) goto L94;
        if (r150 >= 0) goto L98;
        if (r166 == true) goto L98;
        if (r167 == false) goto L98;
    L97:
        r100 = true;
    L98:
        r153.d("BottomSheetBehavior", "####check state 2. result: " + r100 + " canScrollUp: " + r166 + " canScrollDown: " + r167);
        return r100;
    L94:
        if (r150 <= 0) goto L98;
        if (r166 == false) goto L98;
        if (r167 == true) goto L98;
    L84:
        r165 = null;
        goto L85
    L61:
        if (this.D == 3) goto L249;
        return true;
    L249:
        return false;
    L39:
        r155 = null;
        goto L41
    L35:
        r152 = 1;
        goto L36
    L30:
        r151 = false;
        goto L31
    L26:
        if (this.f37850q == false) goto L122;
    L100:
        this.R = false;
        this.O = -1;
        if (this.F == false) goto L122;
        this.F = false;
        return false;
    L104:
        this.Q = (int) r211.getX();
        this.P = (int) r211.getY();
        this.f37855v = r210.getHeight();
        if (this.D == 2) goto L115;
        WeakReference<View> r168 = this.L;
        if (r168 == null) goto L109;
        View r169 = r168.get();
    L110:
        if (r169 == null) goto L115;
        if (r110.isPointInChildBounds(r169, this.Q, this.P) == false) goto L115;
        this.O = r211.getPointerId(r211.getActionIndex());
        this.R = true;
        goto L115
    L109:
        r169 = null;
    L115:
        if (this.O == (-1)) goto L117;
    L119:
        boolean r170 = false;
    L120:
        this.F = r170;
        goto L122
    L117:
        if (r110.isPointInChildBounds(r210, this.Q, this.P) == true) goto L119;
        r170 = true;
        goto L120
    L7:
        if (this.f37850q == true) goto L9;
        goto L9
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout r100, V r101, int r102) {
        if (ViewCompat.getFitsSystemWindows(r100) == false) goto L8;
        if (ViewCompat.getFitsSystemWindows(r101) == true) goto L8;
        r101.setFitsSystemWindows(true);
    L8:
        if (this.K != null) goto L13;
        this.f37839f = r100.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
        this.K = new WeakReference(r101);
        if (ViewCompat.getImportantForAccessibility(r101) != 0) goto L13;
        ViewCompat.setImportantForAccessibility(r101, 1);
    L13:
        if (this.E != null) goto L15;
        this.E = new com.bytedance.ai.view.popup.anim.a(r100.getContext(), r100, this.U);
    L15:
        int r103 = r101.getTop();
        r100.onLayoutChild(r101, r102);
        this.I = r100.getWidth();
        this.f37833J = r100.getHeight();
        if (a() <= 0) goto L22;
        int r104 = this.f37833J - a();
        this.f37843j = r104;
        int r105 = this.f37845l;
        if (r105 != 0) goto L21;
        r105 = this.f37844k;
    L21:
        this.f37843j = Math.max(r105, r104);
    L23:
        this.f37846m = Math.max(0, this.f37833J - r101.getHeight());
        this.f37847n = (int) (this.f37833J * (1.0f - this.f37848o));
        calculateCollapsedOffset();
        if (this.C == true) goto L43;
        int r106 = this.D;
        if (r106 != 3) goto L29;
        ViewCompat.offsetTopAndBottom(r101, getExpandedOffset() - r101.getTop());
        goto L43
    L29:
        if (r106 != 6) goto L32;
        ViewCompat.offsetTopAndBottom(r101, this.f37847n);
        goto L43
    L32:
        if (this.f37850q == false) goto L37;
        if (r106 != 5) goto L37;
        ViewCompat.offsetTopAndBottom(r101, this.f37833J);
    L37:
        if (r106 != 4) goto L39;
        ViewCompat.offsetTopAndBottom(r101, this.f37849p - r101.getTop());
        goto L43
    L39:
        if (r106 != 1) goto L41;
    L42:
        ViewCompat.offsetTopAndBottom(r101, r103 - r101.getTop());
        goto L43
    L41:
        if (r106 == 2) goto L42;
    L43:
        this.C = false;
        this.L = new WeakReference(findScrollingChild(r101));
        return true;
    L22:
        this.f37843j = this.f37833J;
        goto L23
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onRestoreInstanceState(CoordinatorLayout r100, V r101, Parcelable r102) {
        SavedState r103 = (SavedState) r102;
        super.onRestoreInstanceState(r100, r101, r103.getSuperState());
        int r104 = this.f37834a;
        if (r104 != 0) goto L6;
    L22:
        int r105 = r103.f37860a;
        if (r105 == 1) goto L27;
        if (r105 == 2) goto L27;
        this.D = r105;
        return;
    L27:
        this.D = 4;
        return;
    L6:
        if (r104 != (-1)) goto L8;
    L9:
        this.f37837d = r103.f37861b;
    L10:
        if (r104 != (-1)) goto L12;
    L13:
        this.f37835b = r103.f37863d;
    L14:
        if (r104 != (-1)) goto L16;
    L17:
        this.f37850q = r103.f37864e;
    L18:
        if (r104 != (-1)) goto L20;
    L21:
        this.f37851r = r103.f37865f;
        goto L22
    L20:
        if ((r104 & 8) != 8) goto L22;
    L16:
        if ((r104 & 4) != 4) goto L18;
    L12:
        if ((r104 & 2) != 2) goto L14;
    L8:
        if ((r104 & 1) != 1) goto L10;
        goto L9
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout r110, V r111, MotionEvent r112) {
        int r100 = 0;
        if (r111.isShown() == true) goto L5;
        return false;
    L5:
        int r113 = r112.getActionMasked();
        if (this.D != 1) goto L9;
        if (r113 != 0) goto L9;
        return true;
    L9:
        com.bytedance.ai.view.popup.anim.a r101 = this.E;
        if (r101 != null) goto L137;
    L121:
        if (r113 != 0) goto L126;
        this.O = -1;
        VelocityTracker r102 = this.N;
        if (r102 == null) goto L126;
        r102.recycle();
        this.N = null;
    L126:
        if (this.N != null) goto L128;
        this.N = VelocityTracker.obtain();
    L128:
        this.N.addMovement(r112);
        if (r113 != 2) goto L136;
        if (this.F == true) goto L136;
        float r114 = Math.abs(this.P - r112.getY());
        com.bytedance.ai.view.popup.anim.a r103 = this.E;
        if (r114 <= r103.f37873b) goto L136;
        r103.c(r111, r112.getPointerId(r112.getActionIndex()));
    L136:
        return !this.F;
    L137:
        int r104 = r112.getActionMasked();     // Catch: IllegalArgumentException -> L119
        int r105 = r112.getActionIndex();     // Catch: IllegalArgumentException -> L119
        if (r104 != 0) goto L15;
        r101.b();     // Catch: IllegalArgumentException -> L119
    L15:
        if (r101.f37883l != null) goto L17;
        r101.f37883l = VelocityTracker.obtain();     // Catch: IllegalArgumentException -> L119
    L17:
        r101.f37883l.addMovement(r112);     // Catch: IllegalArgumentException -> L119
        if (r104 == 0) goto L115;
        if (r104 == 1) goto L112;
        if (r104 == 2) goto L71;
        if (r104 == 3) goto L67;
        if (r104 != 5) goto L26;
        int r106 = r112.getPointerId(r105);     // Catch: IllegalArgumentException -> L119
        float r107 = r112.getX(r105);     // Catch: IllegalArgumentException -> L119
        float r108 = r112.getY(r105);     // Catch: IllegalArgumentException -> L119
        r101.n(r107, r108, r106);     // Catch: IllegalArgumentException -> L119
        if (r101.f37872a != 0) goto L52;
        r101.q(r101.j((int) r107, (int) r108), r106);     // Catch: IllegalArgumentException -> L119
        if ((0 & r101.f37879h[r106]) == 0) goto L121;
        r101.f37888q.getClass();     // Catch: IllegalArgumentException -> L119
        goto L121
    L52:
        int r109 = (int) r107;     // Catch: IllegalArgumentException -> L119
        int r115 = (int) r108;     // Catch: IllegalArgumentException -> L119
        View r116 = r101.f37889r;     // Catch: IllegalArgumentException -> L119
        if (r116 != null) goto L56;
    L64:
        if (r100 == 0) goto L121;
        r101.q(r101.f37889r, r106);     // Catch: IllegalArgumentException -> L119
        goto L121
    L56:
        if (r109 < r116.getLeft()) goto L64;
        if (r109 >= r116.getRight()) goto L64;
        if (r115 < r116.getTop()) goto L64;
        if (r115 >= r116.getBottom()) goto L64;
        r100 = 1;
        goto L64
    L26:
        if (r104 != 6) goto L121;
        int r117 = r112.getPointerId(r105);     // Catch: IllegalArgumentException -> L119
        if (r101.f37872a == 1) goto L31;
    L46:
        r101.f(r117);     // Catch: IllegalArgumentException -> L119
        goto L121
    L31:
        if (r117 != r101.f37874c) goto L46;
        int r118 = r112.getPointerCount();     // Catch: IllegalArgumentException -> L119
    L33:
        if (r100 >= r118) goto L43;
        int r119 = r112.getPointerId(r100);     // Catch: IllegalArgumentException -> L119
        if (r119 == r101.f37874c) goto L42;
        View r120 = r101.j((int) r112.getX(r100), (int) r112.getY(r100));     // Catch: IllegalArgumentException -> L119
        View r121 = r101.f37889r;     // Catch: IllegalArgumentException -> L119
        if (r120 != r121) goto L42;
        if (r101.q(r121, r119) == false) goto L42;
        int r122 = r101.f37874c;     // Catch: IllegalArgumentException -> L119
    L44:
        if (r122 != (-1)) goto L46;
        r101.l();     // Catch: IllegalArgumentException -> L119
    L42:
        r100 = r100 + 1;     // Catch: IllegalArgumentException -> L119
        goto L33
    L43:
        r122 = -1;
        goto L44
    L67:
        if (r101.f37872a != 1) goto L69;
        r101.h(0.0f, 0.0f);     // Catch: IllegalArgumentException -> L119
    L69:
        r101.b();     // Catch: IllegalArgumentException -> L119
        goto L121
    L71:
        if (r101.f37872a != 1) goto L86;
        int r123 = r101.f37874c;     // Catch: IllegalArgumentException -> L119
        if ((r101.f37882k & (1 << r123)) == 0) goto L75;
        boolean r124 = true;
    L76:
        if (r124 == false) goto L79;
        r100 = 1;
    L79:
        if (r100 == 0) goto L121;
        int r125 = r112.findPointerIndex(r123);     // Catch: IllegalArgumentException -> L119
        float r126 = r112.getX(r125);     // Catch: IllegalArgumentException -> L119
        float r127 = r112.getY(r125);     // Catch: IllegalArgumentException -> L119
        float[] r128 = r101.f37877f;     // Catch: IllegalArgumentException -> L119
        if (r128 == null) goto L121;
        float[] r129 = r101.f37878g;     // Catch: IllegalArgumentException -> L119
        if (r129 == null) goto L121;
        int r130 = r101.f37874c;     // Catch: IllegalArgumentException -> L119
        int r131 = (int) (r126 - r128[r130]);     // Catch: IllegalArgumentException -> L119
        int r132 = (int) (r127 - r129[r130]);     // Catch: IllegalArgumentException -> L119
        r101.i(r101.f37889r.getLeft() + r131, r101.f37889r.getTop() + r132, r131, r132);     // Catch: IllegalArgumentException -> L119
        r101.o(r112);     // Catch: IllegalArgumentException -> L119
        goto L121
    L75:
        r124 = false;
        goto L76
    L86:
        int r133 = r112.getPointerCount();     // Catch: IllegalArgumentException -> L119
        int r134 = 0;
    L87:
        if (r134 >= r133) goto L110;
        int r135 = r112.getPointerId(r134);     // Catch: IllegalArgumentException -> L119
        if ((r101.f37882k & (1 << r135)) == 0) goto L91;
        boolean r136 = true;
    L92:
        if (r136 == true) goto L94;
        boolean r137 = false;
    L95:
        if (r137 == false) goto L109;
        float r138 = r112.getX(r134);     // Catch: IllegalArgumentException -> L119
        float r139 = r112.getY(r134);     // Catch: IllegalArgumentException -> L119
        float[] r140 = r101.f37875d;     // Catch: IllegalArgumentException -> L119
        if (r140 == null) goto L109;
        float[] r141 = r101.f37876e;     // Catch: IllegalArgumentException -> L119
        if (r141 == null) goto L109;
        float r142 = r138 - r140[r135];     // Catch: IllegalArgumentException -> L119
        float r143 = r139 - r141[r135];     // Catch: IllegalArgumentException -> L119
        r101.m(r142, r143, r135);     // Catch: IllegalArgumentException -> L119
        if (r101.f37872a == 1) goto L110;
        View r144 = r101.j((int) r138, (int) r139);     // Catch: IllegalArgumentException -> L119
        if (r101.e(r144, r143) == false) goto L109;
        if (r101.q(r144, r135) == true) goto L110;
    L109:
        r134 = r134 + 1;     // Catch: IllegalArgumentException -> L119
        goto L87
    L94:
        r137 = true;
        goto L95
    L91:
        r136 = false;
    L110:
        r101.o(r112);     // Catch: IllegalArgumentException -> L119
        goto L121
    L112:
        if (r101.f37872a != 1) goto L114;
        r101.l();     // Catch: IllegalArgumentException -> L119
    L114:
        r101.b();     // Catch: IllegalArgumentException -> L119
        goto L121
    L115:
        float r145 = r112.getX();     // Catch: IllegalArgumentException -> L119
        float r146 = r112.getY();     // Catch: IllegalArgumentException -> L119
        int r147 = r112.getPointerId(0);     // Catch: IllegalArgumentException -> L119
        View r148 = r101.j((int) r145, (int) r146);     // Catch: IllegalArgumentException -> L119
        r101.n(r145, r146, r147);     // Catch: IllegalArgumentException -> L119
        r101.q(r148, r147);     // Catch: IllegalArgumentException -> L119
        if ((0 & r101.f37879h[r147]) == 0) goto L121;
        r101.f37888q.getClass();     // Catch: IllegalArgumentException -> L119
    L119:
        e = move-exception;
        e.printStackTrace();
        goto L121
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onStopNestedScroll(CoordinatorLayout r100, V r101, View r102, int r103) {
        int r104 = 3;
        if (r101.getTop() != getExpandedOffset()) goto L6;
        setStateInternal(3);
        return;
    L6:
        WeakReference<View> r105 = this.L;
        if (r105 != null) goto L9;
        return;
    L9:
        if (r102 == r105.get()) goto L11;
        return;
    L11:
        if (this.H == true) goto L14;
        return;
    L14:
        if (this.D != 1) goto L21;
        if (this.f37852s == false) goto L21;
        if (this.B != 4) goto L21;
        return;
    L21:
        if (this.G <= 0) goto L27;
        if (this.f37835b == false) goto L25;
        int r106 = this.f37846m;
    L52:
        startSettlingAnimation(r101, r104, r106, false);
        this.H = false;
        return;
    L25:
        r106 = this.f37843j;
        goto L52
    L27:
        if (this.f37850q == false) goto L36;
        VelocityTracker r107 = this.N;
        if (r107 != null) goto L31;
        float r108 = 0.0f;
    L33:
        if (shouldHide(r101, r108) == false) goto L36;
        r106 = this.f37833J;
        r104 = 5;
        goto L52
    L31:
        r107.computeCurrentVelocity(1000, this.f37836c);
        r108 = this.N.getYVelocity(this.O);
    L36:
        if (this.G != 0) goto L48;
        int r109 = r101.getTop();
        if (this.f37835b == false) goto L44;
        if (Math.abs(r109 - this.f37846m) >= Math.abs(r109 - this.f37849p)) goto L42;
        r106 = this.f37846m;
        goto L52
    L42:
        r106 = this.f37849p;
    L51:
        r104 = 4;
        goto L52
    L44:
        if (Math.abs(r109 - this.f37843j) >= Math.abs(r109 - this.f37849p)) goto L46;
        r106 = this.f37843j;
        goto L52
    L46:
        r106 = this.f37849p;
        goto L51
    L48:
        if (this.f37835b == false) goto L50;
        r106 = this.f37849p;
        goto L51
    L50:
        r106 = this.f37849p;
        goto L51
    }

    public final void startSettlingAnimation(View r100, int r101, int r102, boolean r103) {
        boolean r104 = false;
        if (r103 == false) goto L9;
        com.bytedance.ai.view.popup.anim.a r105 = this.E;
        int r106 = r100.getLeft();
        if (r105.f37890s == false) goto L8;
        boolean r107 = r105.k(r106, r102, (int) r105.f37883l.getXVelocity(r105.f37874c), (int) r105.f37883l.getYVelocity(r105.f37874c));
    L16:
        if (r107 == false) goto L33;
        setStateInternal(2);
        if (r101 == 2) goto L27;
        if (r101 != 3) goto L24;
        r104 = true;
    L24:
        if (this.f37840g == r104) goto L27;
        this.f37840g = r104;
    L27:
        if (this.f37841h != null) goto L29;
        this.f37841h = new c(this, r100, r101);
    L29:
        BottomSheetBehavior<V>.c r108 = this.f37841h;
        if (r108.f37868b == true) goto L32;
        r108.f37869c = r101;
        ViewCompat.postOnAnimation(r100, r108);
        this.f37841h.f37868b = true;
        return;
    L32:
        r108.f37869c = r101;
        return;
    L33:
        setStateInternal(r101);
        return;
    L8:
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    L9:
        com.bytedance.ai.view.popup.anim.a r109 = this.E;
        int r110 = r100.getLeft();
        r109.f37889r = r100;
        r109.f37874c = -1;
        r107 = r109.k(r110, r102, 0, 0);
        if (r107 == true) goto L16;
        if (r109.f37872a != 0) goto L16;
        if (r109.f37889r == null) goto L16;
        r109.f37889r = null;
        goto L16
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onNestedPreFling(CoordinatorLayout r100, V r101, View r102, float r103, float r104) {
        WeakReference<View> r105 = this.L;
        if (r105 != null) goto L5;
        return false;
    L5:
        if (r102 == r105.get()) goto L7;
        return false;
    L7:
        if (this.D == 3) goto L9;
    L10:
        return true;
    L9:
        if (super.onNestedPreFling(r100, r101, r102, r103, r104) == true) goto L10;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout r100, V r101, View r102, View r103, int r104, int r105) {
        this.G = 0;
        this.H = false;
        if ((r104 & 2) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedPreScroll(CoordinatorLayout r100, V r101, View r102, int r103, int r104, int[] r105, int r106) {
        if (r106 != 1) goto L5;
        return;
    L5:
        WeakReference<View> r107 = this.L;
        if (r107 == null) goto L8;
        View r108 = r107.get();
    L9:
        if (r102 == r108) goto L11;
        return;
    L11:
        int r109 = r101.getTop();
        int r110 = r109 - r104;
        if (r104 > 0) goto L14;
        if (r104 < 0) goto L22;
    L33:
        dispatchOnSlide(r101.getTop());
        this.G = r104;
        this.H = true;
        return;
    L22:
        if (r102.canScrollVertically(-1) == true) goto L33;
        int r111 = this.f37849p;
        if (r110 <= r111) goto L30;
        if (this.f37850q == true) goto L30;
        int r112 = r109 - r111;
        r105[1] = r112;
        ViewCompat.offsetTopAndBottom(r101, -r112);
        setStateInternal(4);
    L30:
        if (this.f37852s == true) goto L32;
        return;
    L32:
        r105[1] = r104;
        ViewCompat.offsetTopAndBottom(r101, -r104);
        setStateInternal(1);
        goto L33
    L14:
        if (r110 >= getExpandedOffset()) goto L17;
        int r113 = r109 - getExpandedOffset();
        r105[1] = r113;
        ViewCompat.offsetTopAndBottom(r101, -r113);
        setStateInternal(3);
        goto L33
    L17:
        if (this.f37852s == true) goto L19;
        return;
    L19:
        r105[1] = r104;
        ViewCompat.offsetTopAndBottom(r101, -r104);
        setStateInternal(1);
        goto L33
    L8:
        r108 = null;
        goto L9
    }
}
