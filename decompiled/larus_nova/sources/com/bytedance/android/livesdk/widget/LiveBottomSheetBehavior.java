package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPagerUtils;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public class LiveBottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public LiveBottomSheetDialog.l A;
    public boolean B;
    public final a C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f160912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f160913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f160914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f160915d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f160916e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f160917f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f160918g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f160919h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f160920i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f160921j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f160922k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f160923l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewDragHelper f160924m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f160925n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f160926o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f160927p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f160928q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public WeakReference<V> f160929r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public WeakReference<View> f160930s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public c f160931t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public VelocityTracker f160932u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f160933v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f160934w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f160935x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Map<View, Integer> f160936y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public LiveBottomSheetDialog.m f160937z;

    public static class LiveBottomSheetException extends RuntimeException {
        public LiveBottomSheetException(String r100) {
            super(r100);
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f160938a;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel r100) {
                return new SavedState(r100, null);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int r100) {
                return new SavedState[r100];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel r100, ClassLoader r101) {
                return new SavedState(r100, r101);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r100, ClassLoader r101) {
            super(r100, r101);
            this.f160938a = r100.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeInt(this.f160938a);
        }

        public SavedState(Parcelable r100, int r101) {
            super(r100);
            this.f160938a = r101;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public class a extends ViewDragHelper.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveBottomSheetBehavior f160939a;

        public a(LiveBottomSheetBehavior r100) {
            this.f160939a = r100;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int getViewVerticalDragRange(View r100) {
            LiveBottomSheetBehavior r101 = this.f160939a;
            if (r101.f160921j == false) goto L6;
            return r101.f160928q;
        L6:
            return r101.f160920i;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewDragStateChanged(int r100) {
            if (r100 != 1) goto L6;
            this.f160939a.setStateInternal(1);
            return;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final boolean tryCaptureView(View r100, int r101) {
            LiveBottomSheetBehavior r102 = this.f160939a;
            int r103 = r102.f160923l;
            if (r103 != 1) goto L6;
            return false;
        L6:
            if (r102.f160935x == false) goto L9;
            return false;
        L9:
            if (r103 == 3) goto L11;
        L17:
            WeakReference<V> r104 = this.f160939a.f160929r;
            if (r104 != null) goto L20;
            return false;
        L20:
            if (r104.get() != r100) goto L24;
            return true;
        L24:
            return false;
        L11:
            if (r102.f160933v != r101) goto L17;
            View r105 = r102.f160930s.get();
            if (r105 == null) goto L17;
            if (r105.canScrollVertically(-1) == false) goto L17;
            return false;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int clampViewPositionHorizontal(View r100, int r101, int r102) {
            return r100.getLeft();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int clampViewPositionVertical(View r100, int r101, int r102) {
            int r103 = this.f160939a.getExpandedOffset();
            LiveBottomSheetBehavior r104 = this.f160939a;
            if (r104.f160921j == false) goto L5;
            int r105 = r104.f160928q;
        L7:
            return MathUtils.clamp(r101, r103, r105);
        L5:
            r105 = r104.f160920i;
            goto L7
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewReleased(View r100, float r101, float r110) {
            LiveBottomSheetBehavior r102 = this.f160939a;
            int r103 = 0;
            int r104 = 3;
            if (r102.f160922k == false) goto L12;
            if (r102.shouldHide(r100, r110) == false) goto L8;
            r103 = this.f160939a.f160928q;
        L7:
            r104 = 5;
        L52:
            if (r104 != 5) goto L56;
            this.f160939a.setStateInternal(r104);
            return;
        L56:
            if (this.f160939a.f160924m.settleCapturedViewAt(r100.getLeft(), r103) == false) goto L58;
            this.f160939a.setStateInternal(2);
            ViewCompat.postOnAnimation(r100, new d(this.f160939a, r100, r104));
            return;
        L58:
            this.f160939a.setStateInternal(r104);
            return;
        L8:
            LiveBottomSheetBehavior r105 = this.f160939a;
            if (r105.f160912a == false) goto L52;
            r103 = r105.f160918g;
            goto L52
        L12:
            if (r110 >= 0.0f) goto L21;
            if (r102.f160912a == false) goto L16;
            r103 = r102.f160918g;
            goto L52
        L16:
            int r106 = r100.getTop();
            int r111 = this.f160939a.f160919h;
            if (r106 <= r111) goto L52;
            r103 = r111;
        L19:
            r104 = 6;
            goto L52
        L21:
            if (r102.f160921j == false) goto L31;
            if (r102.shouldHide(r100, r110) == false) goto L31;
            if (r100.getTop() <= this.f160939a.f160920i) goto L27;
        L29:
            r103 = this.f160939a.f160928q;
            goto L7
        L27:
            if (Math.abs(r101) < Math.abs(r110)) goto L29;
        L31:
            if (r110 != 0.0f) goto L33;
        L36:
            int r107 = r100.getTop();
            LiveBottomSheetBehavior r112 = this.f160939a;
            if (r112.f160912a == true) goto L39;
            int r108 = r112.f160919h;
            if (r107 >= r108) goto L49;
            if (r107 < Math.abs(r107 - r112.f160920i)) goto L52;
            r103 = this.f160939a.f160919h;
            goto L19
        L49:
            if (Math.abs(r107 - r108) >= Math.abs(r107 - this.f160939a.f160920i)) goto L51;
            r103 = this.f160939a.f160919h;
            goto L19
        L51:
            r103 = this.f160939a.f160920i;
        L35:
            r104 = 4;
            goto L52
        L39:
            if (Math.abs(r107 - r112.f160918g) >= Math.abs(r107 - this.f160939a.f160920i)) goto L41;
            r103 = this.f160939a.f160918g;
            goto L52
        L41:
            r103 = this.f160939a.f160920i;
            goto L35
        L33:
            if (Math.abs(r101) > Math.abs(r110)) goto L36;
            r103 = this.f160939a.f160920i;
            goto L35
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewPositionChanged(View r100, int r101, int r102, int r103, int r104) {
            this.f160939a.dispatchOnSlide(r102);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f160940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f160941b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LiveBottomSheetBehavior f160942c;

        @Override // java.lang.Runnable
        public final void run() {
            this.f160942c.startSettlingAnimation(this.f160940a, this.f160941b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(LiveBottomSheetBehavior r100, View r101, int r102) {
            this.f160942c = r100;
            this.f160940a = r101;
            this.f160941b = r102;
        }
    }

    public static abstract class c {
        public abstract void a(View r100, float r101);

        public abstract void b(View r100, int r101);

        public c() {
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f160943a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f160944b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LiveBottomSheetBehavior f160945c;

        @Override // java.lang.Runnable
        public final void run() {
            ViewDragHelper r100 = this.f160945c.f160924m;     // Catch: Throwable -> L9
            if (r100 != null) goto L5;
        L7:
            this.f160945c.setStateInternal(this.f160944b);     // Catch: Throwable -> L9
        L14:
            return;
        L5:
            if (r100.continueSettling(true) == false) goto L7;
            ViewCompat.postOnAnimation(this.f160943a, this);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }

        public d(LiveBottomSheetBehavior r100, View r101, int r102) {
            this.f160945c = r100;
            this.f160943a = r101;
            this.f160944b = r102;
        }
    }

    public final int getExpandedOffset() {
        if (this.f160912a == true) goto L7;
        return 0;
    L7:
        return this.f160918g;
    }

    public LiveBottomSheetBehavior() {
        this.f160912a = true;
        this.f160923l = 4;
        this.f160937z = new k0();
        this.A = new l0();
        this.B = false;
        this.C = new a(this);
        new SparseBooleanArray();
    }

    public final String a(ViewGroup r100) {
        Resources r101 = r100.getResources();
        if (r100.getId() == (-1)) goto L9;
        if (r101 == null) goto L9;
        if (R.id.ttlive_design_bottom_sheet == r100.getId()) goto L9;
        return r101.getResourceEntryName(r100.getId());
    L9:
        int r102 = 0;
    L11:
        if (r102 >= r100.getChildCount()) goto L21;
        View r103 = r100.getChildAt(r102);
        if ((r103 instanceof ViewGroup) == true) goto L15;
        if (r103.getId() != (-1)) goto L19;
        r102 = r102 + 1;
        goto L11
    L19:
        return r101.getResourceEntryName(r103.getId());
    L15:
        return a((ViewGroup) r103);
    L21:
        return "";
    }

    public final void dispatchOnSlide(int r100) {
        V r101 = this.f160929r.get();
        if (r101 == null) goto L11;
        c r102 = this.f160931t;
        if (r102 == null) goto L12;
        int r103 = this.f160920i;
        if (r100 <= r103) goto L9;
        r102.a(r101, (r103 - r100) / (this.f160928q - r103));
        return;
    L9:
        r102.a(r101, (r103 - r100) / (r103 - getExpandedOffset()));
        return;
    L12:
        return;
    }

    public final View findScrollingChild(View r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (ViewCompat.isNestedScrollingEnabled(r100) == false) goto L9;
        return r100;
    L9:
        if ((r100 instanceof ViewPager) == false) goto L20;
        View r101 = ViewPagerUtils.getCurrentView((ViewPager) r100);
        if (r101 != null) goto L13;
        return null;
    L13:
        View r102 = findScrollingChild(r101);
        if (r102 != null) goto L16;
    L18:
        return null;
    L16:
        if (r102.getVisibility() != 0) goto L18;
        return r102;
    L20:
        if ((r100 instanceof ViewGroup) == false) goto L27;
        ViewGroup r103 = (ViewGroup) r100;
        int r104 = r103.getChildCount();
        int r105 = 0;
    L22:
        if (r105 >= r104) goto L27;
        View r106 = findScrollingChild(r103.getChildAt(r105));
        if (r106 != null) goto L25;
        r105 = r105 + 1;
        goto L22
    L25:
        return r106;
    L27:
        return null;
    }

    public final void setPeekHeight(int r100) {
        boolean r101 = true;
        if (r100 != (-1)) goto L8;
        if (this.f160915d == true) goto L12;
        this.f160915d = true;
    L14:
        if (r101 == true) goto L16;
        return;
    L16:
        if (this.f160923l != 4) goto L24;
        WeakReference<V> r102 = this.f160929r;
        if (r102 == null) goto L25;
        V r103 = r102.get();
        if (r103 == null) goto L26;
        r103.requestLayout();
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L12:
        r101 = false;
        goto L14
    L8:
        if (this.f160915d == false) goto L10;
    L13:
        this.f160915d = false;
        this.f160914c = Math.max(0, r100);
        this.f160920i = this.f160928q - r100;
        goto L14
    L10:
        if (this.f160914c == r100) goto L12;
        goto L12
    }

    public final void setState(int r100) {
        if (r100 == this.f160923l) goto L28;
        WeakReference<V> r101 = this.f160929r;
        if (r101 == null) goto L7;
        V r102 = r101.get();
        if (r102 == null) goto L32;
        ViewParent r103 = r102.getParent();
        if (r103 != null) goto L22;
    L26:
        startSettlingAnimation(r102, r100);
        return;
    L22:
        if (r103.isLayoutRequested() == false) goto L26;
        if (ViewCompat.isAttachedToWindow(r102) == false) goto L26;
        r102.post(new b(this, r102, r100));
        return;
    L32:
        return;
    L7:
        if (r100 != 4) goto L9;
    L16:
        this.f160923l = r100;
        return;
    L9:
        if (r100 == 3) goto L16;
        if (r100 == 6) goto L16;
        if (this.f160921j == true) goto L15;
        return;
    L15:
        if (r100 == 5) goto L16;
        return;
    }

    public final void setStateInternal(int r100) {
        if (this.f160923l == r100) goto L20;
        this.f160923l = r100;
        if (r100 != 6) goto L7;
    L13:
        updateImportantForAccessibility(true);
    L14:
        V r101 = this.f160929r.get();
        if (r101 == null) goto L21;
        c r102 = this.f160931t;
        if (r102 == null) goto L22;
        r102.b(r101, r100);
        return;
    L22:
        return;
    L21:
        return;
    L7:
        if (r100 == 3) goto L13;
        if (r100 != 5) goto L11;
    L12:
        updateImportantForAccessibility(false);
        goto L14
    L11:
        if (r100 != 4) goto L14;
    }

    public final void updateImportantForAccessibility(boolean r100) {
        WeakReference<V> r101 = this.f160929r;
        if (r101 == null) goto L33;
        ViewParent r102 = r101.get().getParent();
        if ((r102 instanceof CoordinatorLayout) == false) goto L34;
        CoordinatorLayout r103 = (CoordinatorLayout) r102;
        int r104 = r103.getChildCount();
        if (r100 == true) goto L9;
    L12:
        int r105 = 0;
    L13:
        if (r105 >= r104) goto L24;
        View r106 = r103.getChildAt(r105);
        if (r106 == this.f160929r.get()) goto L23;
        if (r100 == true) goto L22;
        Map<View, Integer> r107 = this.f160936y;
        if (r107 == null) goto L23;
        if (r107.containsKey(r106) == false) goto L23;
        ViewCompat.setImportantForAccessibility(r106, this.f160936y.get(r106).intValue());
        goto L23
    L22:
        this.f160936y.put(r106, Integer.valueOf(r106.getImportantForAccessibility()));
        ViewCompat.setImportantForAccessibility(r106, 4);
    L23:
        r105 = r105 + 1;
        goto L13
    L24:
        if (r100 == true) goto L35;
        this.f160936y = null;
        return;
    L35:
        return;
    L9:
        if (this.f160936y == null) goto L11;
        return;
    L11:
        this.f160936y = new HashMap(r104);
        goto L12
    L34:
        return;
    }

    public LiveBottomSheetBehavior(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f160912a = true;
        this.f160923l = 4;
        this.f160937z = new k0();
        this.A = new l0();
        this.B = false;
        this.C = new a(this);
        new SparseBooleanArray();
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.behavior_fitToContents, R.attr.behavior_hideable, R.attr.behavior_peekHeight, R.attr.behavior_skipCollapsed});
        TypedValue r103 = r102.peekValue(2);
        if (r103 == null) goto L7;
        int r104 = r103.data;
        if (r104 != (-1)) goto L7;
        setPeekHeight(r104);
    L8:
        this.f160921j = r102.getBoolean(1, false);
        if (this.f160912a == true) goto L20;
        this.f160912a = true;
        if (this.f160929r == null) goto L14;
        this.f160920i = Math.max(this.f160928q - this.f160917f, this.f160918g);
    L14:
        if (this.f160912a == true) goto L16;
    L18:
        int r105 = this.f160923l;
    L19:
        setStateInternal(r105);
        goto L20
    L16:
        if (this.f160923l != 6) goto L18;
        r105 = 3;
    L20:
        this.f160922k = r102.getBoolean(3, false);
        r102.recycle();
        this.f160913b = ViewConfiguration.get(r100).getScaledMaximumFlingVelocity();
        return;
    L7:
        setPeekHeight(r102.getDimensionPixelSize(2, -1));
        goto L8
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final Parcelable onSaveInstanceState(CoordinatorLayout r100, V r101) {
        return new SavedState(super.onSaveInstanceState(r100, r101), this.f160923l);
    }

    public final boolean shouldHide(View r100, float r101) {
        if (this.f160922k == false) goto L16;
        float r102 = r101 * 0.1f;
        if (r102 <= 500.0f) goto L8;
        return true;
    L8:
        if (r102 >= (-30.0f)) goto L11;
        return false;
    L11:
        if (((this.f160928q - (r100.getTop() + r102)) / r100.getHeight()) < 0.5f) goto L23;
        return false;
    L23:
        return true;
    L16:
        if (r100.getTop() >= this.f160920i) goto L19;
        return false;
    L19:
        if ((Math.abs((r100.getTop() + (r101 * 0.1f)) - this.f160920i) / this.f160914c) > 0.5f) goto L24;
        return false;
    L24:
        return true;
    }

    public final void startSettlingAnimation(View r100, int r101) {
        if (r101 != 4) goto L6;
        int r102 = this.f160920i;
    L20:
        if (this.f160924m.smoothSlideViewTo(r100, r100.getLeft(), r102) == false) goto L22;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r100, new d(this, r100, r101));
        return;
    L22:
        setStateInternal(r101);
        return;
    L6:
        if (r101 != 6) goto L12;
        r102 = this.f160919h;
        if (this.f160912a == false) goto L20;
        int r103 = this.f160918g;
        if (r102 > r103) goto L20;
        r102 = r103;
        r101 = 3;
        goto L20
    L12:
        if (r101 != 3) goto L15;
        r102 = getExpandedOffset();
        goto L20
    L15:
        if (this.f160921j == false) goto L25;
        if (r101 != 5) goto L25;
        r102 = this.f160928q;
    L25:
        throw new IllegalArgumentException("Illegal state argument: " + r101);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout r110, V r111, MotionEvent r112) {
        if (r111.isShown() == true) goto L5;
    L121:
        this.f160925n = true;
        return false;
    L5:
        if (this.f160937z.disableDragDown() == false) goto L7;
    L10:
        boolean r100 = true;
    L12:
        if (r100 == true) goto L14;
    L31:
        int r101 = r112.getActionMasked();
        View r102 = null;
        if (r101 != 0) goto L37;
        this.f160933v = -1;
        VelocityTracker r103 = this.f160932u;
        if (r103 == null) goto L37;
        r103.recycle();
        this.f160932u = null;
    L37:
        if (this.f160932u != null) goto L39;
        this.f160932u = VelocityTracker.obtain();
    L39:
        this.f160932u.addMovement(r112);
        if (r101 == 0) goto L54;
        if (r101 == 1) goto L45;
        if (r101 == 2) goto L50;
        if (r101 == 3) goto L45;
    L70:
        if (this.f160925n == true) goto L77;
        ViewDragHelper r113 = this.f160924m;
        if (r113 == null) goto L77;
        if (r113.shouldInterceptTouchEvent(r112) == false) goto L77;
        return true;
    L77:
        if (this.B == true) goto L96;
        WeakReference<View> r114 = this.f160930s;
        if (r114 == null) goto L81;
        r102 = r114.get();
    L81:
        if (r101 != 2) goto L123;
        if (r102 != null) goto L84;
        return false;
    L84:
        if (this.f160925n == false) goto L86;
        return false;
    L86:
        if (this.f160923l != 1) goto L88;
        return false;
    L88:
        if (r110.isPointInChildBounds(r102, (int) r112.getX(), (int) r112.getY()) == false) goto L90;
        return false;
    L90:
        if (this.f160924m != null) goto L92;
        return false;
    L92:
        if (Math.abs(this.f160934w - r112.getY()) <= this.f160924m.getTouchSlop()) goto L129;
        return true;
    L129:
        return false;
    L123:
        return false;
    L96:
        if ((this.f160934w - r112.getY()) < 0.0f) goto L98;
        boolean r115 = true;
    L99:
        if (r115 == false) goto L102;
    L104:
        boolean r116 = false;
    L105:
        WeakReference<View> r104 = this.f160930s;
        if (r104 == null) goto L108;
        r102 = r104.get();
    L108:
        if (r101 != 2) goto L130;
        if (r102 != null) goto L111;
        return false;
    L111:
        if (this.f160925n == false) goto L113;
        return false;
    L113:
        if (this.f160923l != 1) goto L115;
        return false;
    L115:
        if (r110.isPointInChildBounds(r102, (int) r112.getX(), (int) r112.getY()) == false) goto L117;
        return false;
    L117:
        if (this.f160924m == null) goto L135;
        if (r116 == false) goto L136;
        return true;
    L136:
        return false;
    L135:
        return false;
    L130:
        return false;
    L102:
        if (Math.abs(this.f160934w - r112.getY()) <= this.f160924m.getTouchSlop()) goto L104;
        r116 = true;
        goto L105
    L98:
        r115 = false;
    L50:
        if (this.A.e() == false) goto L70;
        if (this.A.a() == false) goto L70;
        this.f160925n = false;
    L45:
        this.f160935x = false;
        this.f160933v = -1;
        if (this.f160925n == false) goto L50;
        this.f160925n = false;
        return false;
    L54:
        int r105 = (int) r112.getX();
        this.f160934w = (int) r112.getY();
        WeakReference<View> r106 = this.f160930s;
        if (r106 == null) goto L57;
        View r107 = r106.get();
    L58:
        if (r107 == null) goto L63;
        if (r110.isPointInChildBounds(r107, r105, this.f160934w) == false) goto L63;
        this.f160933v = r112.getPointerId(r112.getActionIndex());
        this.f160935x = true;
    L63:
        if (this.f160933v == (-1)) goto L65;
    L67:
        boolean r117 = false;
    L68:
        this.f160925n = r117;
        goto L70
    L65:
        if (r110.isPointInChildBounds(r111, r105, this.f160934w) == true) goto L67;
        r117 = true;
        goto L68
    L57:
        r107 = null;
        goto L58
    L14:
        if (this.A.e() == true) goto L16;
    L28:
        boolean r108 = true;
    L29:
        if (r108 == false) goto L31;
    L16:
        if (this.A.a() == false) goto L28;
        if (this.f160923l != 4) goto L24;
        if (this.A.c() == false) goto L24;
    L27:
        r108 = false;
    L24:
        if (this.f160923l != 3) goto L28;
        if (this.A.d() == false) goto L28;
    L7:
        if (this.f160937z.shouldInterceptSlide((int) r112.getY()) == false) goto L10;
        r100 = false;
        goto L12
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout r100, V r101, int r102) {
        if (ViewCompat.getFitsSystemWindows(r100) == true) goto L5;
    L7:
        int r103 = r101.getTop();
        r100.onLayoutChild(r101, r102);     // Catch: Exception -> L10
    L19:
        this.f160928q = r100.getHeight();
        if (this.f160915d == true) goto L22;
        this.f160917f = this.f160914c;
    L26:
        int r104 = Math.max(0, this.f160928q - r101.getHeight());
        this.f160918g = r104;
        int r105 = this.f160928q;
        this.f160919h = r105 / 2;
        if (this.f160912a == false) goto L29;
        this.f160920i = Math.max(r105 - this.f160917f, r104);
    L30:
        int r106 = this.f160923l;
        if (r106 != 3) goto L34;
        ViewCompat.offsetTopAndBottom(r101, getExpandedOffset());
    L49:
        if (this.f160924m != null) goto L51;
        this.f160924m = ViewDragHelper.create(r100, this.C);
    L51:
        this.f160929r = new WeakReference(r101);
        this.f160930s = new WeakReference(findScrollingChild(r101));
        return true;
    L34:
        if (r106 != 6) goto L37;
        ViewCompat.offsetTopAndBottom(r101, this.f160919h);
        goto L49
    L37:
        if (this.f160921j == false) goto L42;
        if (r106 != 5) goto L42;
        ViewCompat.offsetTopAndBottom(r101, this.f160928q);
    L42:
        if (r106 != 4) goto L44;
        ViewCompat.offsetTopAndBottom(r101, this.f160920i);
        goto L49
    L44:
        if (r106 != 1) goto L46;
    L47:
        ViewCompat.offsetTopAndBottom(r101, r103 - r101.getTop());
        goto L49
    L46:
        if (r106 != 2) goto L49;
    L29:
        this.f160920i = r105 - this.f160917f;
        goto L30
    L22:
        if (this.f160916e != 0) goto L24;
        this.f160916e = r100.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
    L24:
        this.f160917f = Math.max(this.f160916e, this.f160928q - ((r100.getWidth() * 9) / 16));
    L10:
        e = move-exception;
        ViewGroup r107 = (ViewGroup) r100.findViewById(R.id.ttlive_design_bottom_sheet);     // Catch: Exception -> L54
        if (r107 == null) goto L16;
        String r108 = a(r107);     // Catch: Exception -> L54
    L17:
        LiveBottomSheetException r109 = new LiveBottomSheetException("invalid state in BottomSheetBehavior: " + r108 + "\n Real exception: " + e.toString());
        SafetyGuard.a(null, r109, "LiveBottomSheetBehavior onLayoutChild error");
        if (j40.u1.f497306a.getValue().booleanValue() == false) goto L19;
        throw r109;
    L16:
        r108 = "";
        goto L17
    L5:
        if (ViewCompat.getFitsSystemWindows(r101) == true) goto L7;
        r101.setFitsSystemWindows(true);
        goto L7
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onRestoreInstanceState(CoordinatorLayout r100, V r101, Parcelable r102) {
        if ((r102 instanceof SavedState) == true) goto L6;
        SafetyGuard.b(new SecurityException("LiveBottomSheetBehavior$onRestoreInstanceState state cannot be cast to com.bytedance.android.livesdk.widget.LiveBottomSheetBehavior$SavedState. \n current state class name is ".concat(r102.getClass().getName())));
        return;
    L6:
        SavedState r103 = (SavedState) r102;
        super.onRestoreInstanceState(r100, r101, r103.getSuperState());
        int r104 = r103.f160938a;
        if (r104 != 1) goto L9;
    L11:
        this.f160923l = 4;
        return;
    L9:
        if (r104 == 2) goto L11;
        this.f160923l = r104;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout r100, V r101, MotionEvent r102) {
        if (r101.isShown() == true) goto L6;
        return false;
    L6:
        int r103 = r102.getActionMasked();
        if (this.f160923l != 1) goto L10;
        if (r103 != 0) goto L10;
        return true;
    L10:
        ViewDragHelper r104 = this.f160924m;
        if (r104 == null) goto L13;
        r104.processTouchEvent(r102);
    L13:
        if (r103 != 0) goto L18;
        this.f160933v = -1;
        VelocityTracker r105 = this.f160932u;
        if (r105 == null) goto L18;
        r105.recycle();
        this.f160932u = null;
    L18:
        if (this.f160932u != null) goto L20;
        this.f160932u = VelocityTracker.obtain();
    L20:
        this.f160932u.addMovement(r102);
        if (r103 != 2) goto L28;
        if (this.f160925n == true) goto L28;
        if (Math.abs(this.f160934w - r102.getY()) <= this.f160924m.getTouchSlop()) goto L28;
        this.f160924m.captureChildView(r101, r102.getPointerId(r102.getActionIndex()));
    L28:
        return !this.f160925n;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onStopNestedScroll(CoordinatorLayout r100, V r101, View r102, int r103) {
        int r104 = 3;
        if (r101.getTop() != getExpandedOffset()) goto L6;
        setStateInternal(3);
        return;
    L6:
        if (r102 == this.f160930s.get()) goto L8;
        return;
    L8:
        if (this.f160927p == true) goto L10;
        return;
    L10:
        if (this.f160926o <= 30) goto L13;
        int r105 = getExpandedOffset();
    L45:
        if (r104 != 5) goto L49;
        setStateInternal(r104);
        return;
    L49:
        if (this.f160924m.smoothSlideViewTo(r101, r101.getLeft(), r105) == false) goto L51;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r101, new d(this, r101, r104));
    L52:
        this.f160927p = false;
        return;
    L51:
        setStateInternal(r104);
        goto L52
    L13:
        if (this.f160921j == false) goto L22;
        VelocityTracker r106 = this.f160932u;
        if (r106 != null) goto L17;
        float r107 = 0.0f;
    L19:
        if (shouldHide(r101, r107) == false) goto L22;
        r105 = this.f160928q;
        r104 = 5;
        goto L45
    L17:
        r106.computeCurrentVelocity(1000, this.f160913b);
        r107 = this.f160932u.getYVelocity(this.f160933v);
    L22:
        if (this.f160922k == false) goto L25;
        r105 = getExpandedOffset();
        goto L45
    L25:
        if (this.f160926o != 0) goto L43;
        int r108 = r101.getTop();
        if (this.f160912a == true) goto L29;
        int r109 = this.f160919h;
        if (r108 >= r109) goto L39;
        if (r108 >= Math.abs(r108 - this.f160920i)) goto L37;
        r105 = 0;
        goto L45
    L37:
        r105 = this.f160919h;
    L41:
        r104 = 6;
        goto L45
    L39:
        if (Math.abs(r108 - r109) >= Math.abs(r108 - this.f160920i)) goto L42;
        r105 = this.f160919h;
        goto L41
    L42:
        r105 = this.f160920i;
    L44:
        r104 = 4;
        goto L45
    L29:
        if (Math.abs(r108 - this.f160918g) >= Math.abs(r108 - this.f160920i)) goto L31;
        r105 = this.f160918g;
        goto L45
    L31:
        r105 = this.f160920i;
        goto L44
    L43:
        r105 = this.f160920i;
        goto L44
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onNestedPreFling(CoordinatorLayout r100, V r101, View r102, float r103, float r104) {
        if (r102 == this.f160930s.get()) goto L5;
    L9:
        return false;
    L5:
        if (this.f160923l == 3) goto L7;
    L8:
        return true;
    L7:
        if (super.onNestedPreFling(r100, r101, r102, r103, r104) == false) goto L9;
        goto L8
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onStartNestedScroll(CoordinatorLayout r100, V r101, View r102, View r103, int r104, int r105) {
        this.f160926o = 0;
        this.f160927p = false;
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
        if (r102 != this.f160930s.get()) goto L26;
        int r107 = r101.getTop();
        int r108 = r107 - r104;
        if (r104 > 0) goto L9;
        if (r104 < 0) goto L14;
    L23:
        dispatchOnSlide(r101.getTop());
        this.f160926o = r104;
        this.f160927p = true;
        return;
    L14:
        if (r102.canScrollVertically(-1) == true) goto L23;
        if (this.f160937z.disableDragDown() == true) goto L23;
        int r109 = this.f160920i;
        if (r108 > r109) goto L20;
    L22:
        r105[1] = r104;
        ViewCompat.offsetTopAndBottom(r101, -r104);
        setStateInternal(1);
        goto L23
    L20:
        if (this.f160921j == true) goto L22;
        int r110 = r107 - r109;
        r105[1] = r110;
        ViewCompat.offsetTopAndBottom(r101, -r110);
        setStateInternal(4);
        goto L23
    L9:
        if (r108 >= getExpandedOffset()) goto L11;
        int r111 = r107 - getExpandedOffset();
        r105[1] = r111;
        ViewCompat.offsetTopAndBottom(r101, -r111);
        setStateInternal(3);
        goto L23
    L11:
        r105[1] = r104;
        ViewCompat.offsetTopAndBottom(r101, -r104);
        setStateInternal(1);
        goto L23
    }
}
