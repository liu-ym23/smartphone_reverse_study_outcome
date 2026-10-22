package com.bytedance.android.shopping.yata.biz.popup.behavior;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\nB\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/yata/biz/popup/behavior/BottomSheetBehavior;", "Landroid/view/View;", "V", "Lcom/bytedance/android/shopping/yata/biz/popup/behavior/SheetBaseBehavior;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BottomSheetBehavior<V extends View> extends SheetBaseBehavior<V> {
    public static final /* synthetic */ int E = 0;
    public int A;
    public boolean B;
    public Map<View, Integer> C;
    public final BottomSheetBehavior$dragCallback$1 D;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f187519h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f187520i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f187521j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f187522k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f187523l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f187524m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f187525n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f187526o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f187527p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f187528q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ViewDragHelper f187529r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f187530s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f187531t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f187532u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f187533v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public WeakReference<V> f187534w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public WeakReference<View> f187535x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public VelocityTracker f187536y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f187537z;

    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f187538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f187539b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior f187540c;

        @Override // java.lang.Runnable
        public final void run() {
            ViewDragHelper r100 = this.f187540c.f187529r;     // Catch: Throwable -> L9
            if (r100 != null) goto L5;
        L7:
            this.f187540c.setStateInternal(this.f187539b);     // Catch: Throwable -> L9
        L14:
            return;
        L5:
            if (r100.continueSettling(true) != true) goto L7;
            ViewCompat.postOnAnimation(this.f187538a, this);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }

        public a(BottomSheetBehavior r100, View r101, int r102) {
            Intrinsics.checkNotNullParameter(r101, "view");
            this.f187540c = r100;
            this.f187538a = r101;
            this.f187539b = r102;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior f187541a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f187542b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f187543c;

        public b(BottomSheetBehavior r100, View r101, int r102) {
            this.f187541a = r100;
            this.f187542b = r101;
            this.f187543c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f187541a.startSettlingAnimation(this.f187542b, this.f187543c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final boolean b() {
        this.f187552f.getClass();
        return false;
    }

    public final int getExpandedOffset() {
        if (this.f187519h == true) goto L7;
        return 0;
    L7:
        return this.f187525n;
    }

    public final void dispatchOnSlide(int r100) {
        WeakReference<V> r101 = this.f187534w;
        V r102 = null;
        if (r101 == null) goto L5;
        V r103 = r101.get();
    L7:
        if ((r103 instanceof View) == false) goto L10;
        r102 = r103;
    L10:
        if (r102 != null) goto L13;
        return;
    L13:
        if (r100 <= this.f187527p) goto L17;
        SheetBaseBehavior.b r104 = this.f187548b;
        if (r104 == null) goto L21;
        r104.b(r102);
        return;
    L21:
        return;
    L17:
        SheetBaseBehavior.b r105 = this.f187548b;
        if (r105 == null) goto L23;
        r105.b(r102);
        return;
    L23:
        return;
    L5:
        r103 = null;
        goto L7
    }

    @Override // com.bytedance.android.shopping.yata.biz.popup.behavior.SheetBaseBehavior
    public final void setPeekHeight(int r100) {
        boolean r101 = true;
        if (r100 != (-1)) goto L8;
        if (this.f187522k == true) goto L12;
        this.f187522k = true;
    L14:
        if (r101 == true) goto L16;
        return;
    L16:
        if (this.f187528q != 4) goto L25;
        WeakReference<V> r102 = this.f187534w;
        if (r102 == null) goto L20;
        V r103 = r102.get();
    L21:
        if (r103 == null) goto L26;
        r103.requestLayout();
        return;
    L26:
        return;
    L20:
        r103 = null;
        goto L21
    L25:
        return;
    L12:
        r101 = false;
        goto L14
    L8:
        if (this.f187522k == false) goto L10;
    L13:
        this.f187522k = false;
        this.f187521j = Math.max(0, r100);
        this.f187527p = this.f187533v - r100;
        goto L14
    L10:
        if (this.f187521j == r100) goto L12;
        goto L12
    }

    @Override // com.bytedance.android.shopping.yata.biz.popup.behavior.SheetBaseBehavior
    public final void setState(int r100) {
        if (r100 == this.f187528q) goto L30;
        WeakReference<V> r101 = this.f187534w;
        if (r101 == null) goto L7;
        if (r101 == null) goto L19;
        V r102 = r101.get();
    L20:
        if (r102 == null) goto L34;
        ViewParent r103 = r102.getParent();
        if (r103 != null) goto L24;
    L28:
        startSettlingAnimation(r102, r100);
        return;
    L24:
        if (r103.isLayoutRequested() == false) goto L28;
        if (ViewCompat.isAttachedToWindow(r102) == false) goto L28;
        r102.post(new b(this, r102, r100));
        return;
    L34:
        return;
    L19:
        r102 = null;
        goto L20
    L7:
        if (r100 != 4) goto L9;
    L16:
        this.f187528q = r100;
        return;
    L9:
        if (r100 == 3) goto L16;
        if (r100 == 6) goto L16;
        if (this.f187547a == true) goto L15;
        return;
    L15:
        if (r100 == 5) goto L16;
        return;
    }

    public final void setStateInternal(int r100) {
        if (this.f187528q == r100) goto L20;
        this.f187528q = r100;
        if (r100 != 6) goto L7;
    L13:
        updateImportantForAccessibility(true);
    L14:
        WeakReference<V> r101 = this.f187534w;
        Intrinsics.checkNotNull(r101);
        V r102 = r101.get();
        if (r102 == null) goto L21;
        SheetBaseBehavior.b r103 = this.f187548b;
        if (r103 == null) goto L22;
        Intrinsics.checkNotNull(r103);
        r103.a(r102, r100);
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
        WeakReference<V> r101 = this.f187534w;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101 == null) goto L7;
        V r102 = r101.get();
    L8:
        if (r102 == null) goto L43;
        ViewParent r103 = r102.getParent();
        if ((r103 instanceof CoordinatorLayout) == false) goto L54;
        CoordinatorLayout r104 = (CoordinatorLayout) r103;
        int r105 = r104.getChildCount();
        if (r100 == true) goto L14;
    L17:
        int r106 = 0;
    L18:
        if (r106 >= r105) goto L40;
        View r107 = r104.getChildAt(r106);
        WeakReference<V> r108 = this.f187534w;
        if (r108 == null) goto L22;
        V r109 = r108.get();
    L23:
        if (r107 == r109) goto L39;
        if (r100 == true) goto L35;
        Map<View, Integer> r110 = this.C;
        if (r110 == null) goto L39;
        if (r110 == null) goto L39;
        if (r110.containsKey(r107) != true) goto L39;
        Map<View, Integer> r111 = this.C;
        if (r111 == null) goto L39;
        Integer r112 = r111.get(r107);
        if (r112 == null) goto L39;
        ViewCompat.setImportantForAccessibility(r107, r112.intValue());
        goto L39
    L35:
        Map<View, Integer> r113 = this.C;
        if (r113 == null) goto L38;
        Integer r114 = r113.put(r107, Integer.valueOf(r107.getImportantForAccessibility()));
    L38:
        ViewCompat.setImportantForAccessibility(r107, 4);
    L39:
        r106 = r106 + 1;
        goto L18
    L22:
        r109 = null;
        goto L23
    L40:
        if (r100 == true) goto L55;
        this.C = null;
        return;
    L55:
        return;
    L14:
        if (this.C == null) goto L16;
        return;
    L16:
        this.C = new HashMap(r105);
        goto L17
    L54:
        return;
    L43:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L7:
        r102 = null;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.bytedance.android.shopping.yata.biz.popup.behavior.BottomSheetBehavior$dragCallback$1] */
    public BottomSheetBehavior(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f187519h = true;
        this.f187528q = 4;
        this.D = new BottomSheetBehavior$dragCallback$1(this);
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.behavior_fitToContents, R.attr.behavior_hideable, R.attr.behavior_peekHeight, R.attr.behavior_skipCollapsed});
        TypedValue r103 = r102.peekValue(2);
        if (r103 == null) goto L7;
        int r104 = r103.data;
        if (r104 != (-1)) goto L7;
        setPeekHeight(r104);
    L8:
        this.f187547a = r102.getBoolean(1, false);
        if (this.f187519h == true) goto L20;
        this.f187519h = true;
        if (this.f187534w == null) goto L14;
        this.f187527p = Math.max(this.f187533v - this.f187524m, this.f187525n);
    L14:
        if (this.f187519h == true) goto L16;
    L18:
        int r105 = this.f187528q;
    L19:
        setStateInternal(r105);
        goto L20
    L16:
        if (this.f187528q != 6) goto L18;
        r105 = 3;
    L20:
        this.f187549c = r102.getBoolean(3, false);
        r102.recycle();
        this.f187520i = ViewConfiguration.get(r100).getScaledMaximumFlingVelocity();
        return;
    L7:
        setPeekHeight(r102.getDimensionPixelSize(2, -1));
        goto L8
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final Parcelable onSaveInstanceState(CoordinatorLayout r100, V r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        return new SavedState(super.onSaveInstanceState(r100, r101), this.f187528q);
    }

    public final boolean shouldHide(View r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if (this.f187549c == false) goto L14;
        float r102 = r101 * 0.1f;
        if (r102 <= 500) goto L8;
        return true;
    L8:
        if (r102 >= (-30)) goto L11;
        return false;
    L11:
        if (((this.f187533v - (r100.getTop() + r102)) / r100.getHeight()) < 0.5f) goto L20;
    L15:
        return false;
    L20:
        return true;
    L14:
        if (r100.getTop() < this.f187527p) goto L15;
        if ((Math.abs((r100.getTop() + (r101 * 0.1f)) - this.f187527p) / this.f187521j) <= 0.5f) goto L15;
        return true;
    }

    public final void startSettlingAnimation(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if (r101 != 4) goto L6;
        int r102 = this.f187527p;
    L22:
        ViewDragHelper r103 = this.f187529r;
        if (r103 != null) goto L25;
    L27:
        setStateInternal(r101);
        return;
    L25:
        if (r103.smoothSlideViewTo(r100, r100.getLeft(), r102) != true) goto L27;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r100, new a(this, r100, r101));
        return;
    L6:
        if (r101 != 6) goto L12;
        r102 = this.f187526o;
        if (this.f187519h == false) goto L22;
        int r104 = this.f187525n;
        if (r102 > r104) goto L22;
        r102 = r104;
        r101 = 3;
        goto L22
    L12:
        if (r101 != 3) goto L15;
        r102 = getExpandedOffset();
        goto L22
    L15:
        if (this.f187547a == true) goto L17;
    L19:
        boolean r105 = false;
    L20:
        if (r105 == false) goto L30;
        r102 = this.f187533v;
        goto L22
    L30:
        throw new IllegalArgumentException(("Illegal state argument: " + r101).toString());
    L17:
        if (r101 != 5) goto L19;
        r105 = true;
        goto L20
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout r110, V r111, MotionEvent r112) {
        Intrinsics.checkNotNullParameter(r110, "parent");
        Intrinsics.checkNotNullParameter(r111, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r112, "event");
        if (r111.isShown() == true) goto L5;
    L70:
        this.f187530s = true;
        return false;
    L5:
        if (this.f187551e.f187553a.f187550d == true) goto L7;
        r112.getY();
        boolean r100 = false;
    L8:
        if (r100 == false) goto L10;
        this.f187552f.getClass();
        goto L70
    L10:
        this.f187552f.getClass();
        Intrinsics.checkNotNullParameter(r112, "event");
        Intrinsics.checkNotNullParameter(r112, "event");
        int r101 = r112.getActionMasked();
        View r102 = null;
        if (r101 != 0) goto L16;
        this.f187537z = -1;
        VelocityTracker r103 = this.f187536y;
        if (r103 == null) goto L16;
        Intrinsics.checkNotNull(r103);
        r103.recycle();
        this.f187536y = null;
    L16:
        if (this.f187536y != null) goto L18;
        this.f187536y = VelocityTracker.obtain();
    L18:
        VelocityTracker r104 = this.f187536y;
        Intrinsics.checkNotNull(r104);
        r104.addMovement(r112);
        if (r101 == 0) goto L31;
        if (r101 == 1) goto L26;
        if (r101 != 2) goto L23;
        this.f187552f.getClass();
    L47:
        if (this.f187530s == true) goto L53;
        ViewDragHelper r113 = this.f187529r;
        if (r113 == null) goto L53;
        if (r113.shouldInterceptTouchEvent(r112) != true) goto L53;
        return true;
    L53:
        b();
        WeakReference<View> r114 = this.f187535x;
        if (r114 == null) goto L56;
        Intrinsics.checkNotNull(r114);
        r102 = r114.get();
    L56:
        if (r101 == 2) goto L58;
        return false;
    L58:
        if (this.f187530s == false) goto L60;
        return false;
    L60:
        if (this.f187529r == null) goto L74;
        float r115 = Math.abs(this.A - r112.getY());
        ViewDragHelper r105 = this.f187529r;
        Intrinsics.checkNotNull(r105);
        if (r115 > r105.getTouchSlop()) goto L64;
        return false;
    L64:
        if (this.f187528q == 1) goto L76;
        if (r102 != null) goto L67;
        return false;
    L67:
        if (r110.isPointInChildBounds(r102, (int) r112.getX(), (int) r112.getY()) == true) goto L78;
        return true;
    L78:
        return false;
    L76:
        return false;
    L74:
        return false;
    L23:
        if (r101 != 3) goto L47;
    L26:
        this.B = false;
        this.f187537z = -1;
        if (this.f187530s == false) goto L30;
        this.f187530s = false;
        return false;
    L30:
        this.f187552f.getClass();
        goto L47
    L31:
        int r106 = (int) r112.getX();
        this.A = (int) r112.getY();
        WeakReference<View> r107 = this.f187535x;
        if (r107 == null) goto L34;
        Intrinsics.checkNotNull(r107);
        View r108 = r107.get();
    L35:
        if (r108 == null) goto L40;
        if (r110.isPointInChildBounds(r108, r106, this.A) == false) goto L40;
        this.f187537z = r112.getPointerId(r112.getActionIndex());
        this.B = true;
    L40:
        if (this.f187537z == (-1)) goto L42;
    L44:
        boolean r116 = false;
    L45:
        this.f187530s = r116;
        goto L47
    L42:
        if (r110.isPointInChildBounds(r111, r106, this.A) == true) goto L44;
        r116 = true;
        goto L45
    L34:
        r108 = null;
        goto L35
    L7:
        r100 = true;
        goto L8
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout r100, V r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if (ViewCompat.getFitsSystemWindows(r100) == true) goto L5;
    L7:
        int r103 = r101.getTop();
        r100.onLayoutChild(r101, r102);     // Catch: Exception -> L43
        this.f187533v = r100.getHeight();
        if (this.f187522k == true) goto L12;
        this.f187524m = this.f187521j;
    L16:
        int r104 = Math.max(0, this.f187533v - r101.getHeight());
        this.f187525n = r104;
        int r105 = this.f187533v;
        this.f187526o = r105 / 2;
        if (this.f187519h == false) goto L19;
        this.f187527p = Math.max(r105 - this.f187524m, r104);
    L20:
        int r106 = this.f187528q;
        if (r106 != 3) goto L24;
        ViewCompat.offsetTopAndBottom(r101, getExpandedOffset());
    L39:
        if (this.f187529r != null) goto L41;
        this.f187529r = ViewDragHelper.create(r100, this.D);
    L41:
        this.f187534w = new WeakReference(r101);
        this.f187535x = new WeakReference(findScrollingChild(r101));
        b();
        return true;
    L24:
        if (r106 != 6) goto L27;
        ViewCompat.offsetTopAndBottom(r101, this.f187526o);
        goto L39
    L27:
        if (this.f187547a == false) goto L32;
        if (r106 != 5) goto L32;
        ViewCompat.offsetTopAndBottom(r101, this.f187533v);
    L32:
        if (r106 != 4) goto L34;
        ViewCompat.offsetTopAndBottom(r101, this.f187527p);
        goto L39
    L34:
        if (r106 != 1) goto L36;
    L37:
        ViewCompat.offsetTopAndBottom(r101, r103 - r101.getTop());
        goto L39
    L36:
        if (r106 != 2) goto L39;
    L19:
        this.f187527p = r105 - this.f187524m;
        goto L20
    L12:
        if (this.f187523l != 0) goto L14;
        this.f187523l = r100.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
    L14:
        this.f187524m = Math.max(this.f187523l, this.f187533v - ((r100.getWidth() * 9) / 16));
    L43:
        e = move-exception;
        String r107 = a((ViewGroup) r100.findViewById(R.id.commerce_design_sheet));     // Catch: Exception -> L47
    L49:
        throw new RuntimeException("invalid state in BottomSheetBehavior: " + r107 + " Real exception: " + e);
    L47:
        r107 = "";
        goto L49
    L5:
        if (ViewCompat.getFitsSystemWindows(r101) == true) goto L7;
        r101.setFitsSystemWindows(true);
        goto L7
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onRestoreInstanceState(CoordinatorLayout r100, V r101, Parcelable r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "state");
        SavedState r103 = (SavedState) r102;
        if (r103.getSuperState() == null) goto L5;
        Parcelable r104 = r103.getSuperState();
        Intrinsics.checkNotNull(r104);
        super.onRestoreInstanceState(r100, r101, r104);
    L5:
        int r105 = r103.f187545a;
        if (r105 != 1) goto L8;
    L10:
        this.f187528q = 4;
        return;
    L8:
        if (r105 == 2) goto L10;
        this.f187528q = r105;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout r100, V r101, MotionEvent r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "event");
        if (r101.isShown() == false) goto L40;
        int r103 = r102.getActionMasked();
        if (this.f187528q != 1) goto L42;
        if (r103 != 0) goto L42;
        return true;
    L42:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L16
        ViewDragHelper r105 = this.f187529r;     // Catch: Throwable -> L16
        if (r105 == null) goto L13;
        r105.processTouchEvent(r102);     // Catch: Throwable -> L16
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L14:
        Result.m9449constructorimpl(r106);     // Catch: Throwable -> L16
    L18:
        if (r103 != 0) goto L23;
        this.f187537z = -1;
        VelocityTracker r107 = this.f187536y;
        if (r107 == null) goto L23;
        Intrinsics.checkNotNull(r107);
        r107.recycle();
        this.f187536y = null;
    L23:
        if (this.f187536y != null) goto L25;
        this.f187536y = VelocityTracker.obtain();
    L25:
        VelocityTracker r108 = this.f187536y;
        if (r108 == null) goto L28;
        r108.addMovement(r102);
    L28:
        ViewDragHelper r109 = this.f187529r;
        if (r109 == null) goto L38;
        if (r103 != 2) goto L38;
        if (this.f187530s == true) goto L38;
        if (Math.abs(this.A - r102.getY()) <= r109.getTouchSlop()) goto L38;
        r109.captureChildView(r101, r102.getPointerId(r102.getActionIndex()));
    L38:
        if (this.f187530s == true) goto L40;
        return true;
    L13:
        r106 = null;
    L16:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L40:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onStopNestedScroll(CoordinatorLayout r100, V r101, View r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        if (r101.getTop() != getExpandedOffset()) goto L5;
        b();
        setStateInternal(3);
        return;
    L5:
        WeakReference<View> r104 = this.f187535x;
        Intrinsics.checkNotNull(r104);
        if (r102 == r104.get()) goto L8;
        return;
    L8:
        if (this.f187532u == true) goto L10;
        return;
    L10:
        if (this.f187531t <= 30) goto L14;
        int r105 = getExpandedOffset();
    L12:
        byte r106 = (byte) 3;
    L49:
        if (r106 != 5) goto L52;
        setStateInternal(r106);
        return;
    L52:
        ViewDragHelper r107 = this.f187529r;
        if (r107 != null) goto L55;
    L57:
        setStateInternal(r106);
    L58:
        this.f187532u = false;
        return;
    L55:
        if (r107.smoothSlideViewTo(r101, r101.getLeft(), r105) != true) goto L57;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r101, new a(this, r101, r106));
        goto L58
    L14:
        if (this.f187547a == false) goto L26;
        VelocityTracker r108 = this.f187536y;
        if (r108 == null) goto L21;
        r108.computeCurrentVelocity(1000, this.f187520i);
        VelocityTracker r109 = this.f187536y;
        if (r109 == null) goto L21;
        float r110 = r109.getYVelocity(this.f187537z);
    L23:
        if (shouldHide(r101, r110) == false) goto L26;
        r105 = this.f187533v;
        r106 = (byte) 5;
    L21:
        r110 = 0.0f;
    L26:
        if (this.f187549c == false) goto L29;
        r105 = getExpandedOffset();
        goto L12
    L29:
        if (this.f187531t != 0) goto L47;
        int r111 = r101.getTop();
        if (this.f187519h == true) goto L33;
        int r112 = this.f187526o;
        if (r111 >= r112) goto L43;
        if (r111 >= Math.abs(r111 - this.f187527p)) goto L41;
        r106 = (byte) 3;
        r105 = 0;
        goto L49
    L41:
        r105 = this.f187526o;
    L45:
        r106 = (byte) 6;
        goto L49
    L43:
        if (Math.abs(r111 - r112) >= Math.abs(r111 - this.f187527p)) goto L46;
        r105 = this.f187526o;
        goto L45
    L46:
        r105 = this.f187527p;
    L48:
        r106 = (byte) 4;
        goto L49
    L33:
        if (Math.abs(r111 - this.f187525n) >= Math.abs(r111 - this.f187527p)) goto L35;
        r105 = this.f187525n;
        goto L12
    L35:
        r105 = this.f187527p;
        goto L48
    L47:
        r105 = this.f187527p;
        goto L48
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onNestedPreFling(CoordinatorLayout r100, V r101, View r102, float r103, float r104) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        WeakReference<View> r105 = this.f187535x;
        Intrinsics.checkNotNull(r105);
        if (r102 == r105.get()) goto L5;
    L9:
        return false;
    L5:
        if (this.f187528q == 3) goto L7;
    L8:
        return true;
    L7:
        if (super.onNestedPreFling(r100, r101, r102, r103, r104) == false) goto L9;
        goto L8
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onStartNestedScroll(CoordinatorLayout r100, V r101, View r102, View r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "directTargetChild");
        Intrinsics.checkNotNullParameter(r103, PickerReporterConstants.KEY.TARGET);
        this.f187531t = 0;
        this.f187532u = false;
        if ((r104 & 2) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedPreScroll(CoordinatorLayout r100, V r101, View r102, int r103, int r104, int[] r105, int r106) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r105, "consumed");
        if (r106 == 1) goto L25;
        WeakReference<View> r107 = this.f187535x;
        Intrinsics.checkNotNull(r107);
        if (r102 != r107.get()) goto L26;
        int r108 = r101.getTop();
        int r109 = r108 - r104;
        if (r104 > 0) goto L9;
        if (r104 < 0) goto L14;
    L23:
        dispatchOnSlide(r101.getTop());
        this.f187531t = r104;
        this.f187532u = true;
        b();
        return;
    L14:
        if (r102.canScrollVertically(-1) == true) goto L23;
        if (this.f187551e.f187553a.f187550d == true) goto L23;
        int r110 = this.f187527p;
        if (r109 > r110) goto L20;
    L22:
        r105[1] = r104;
        ViewCompat.offsetTopAndBottom(r101, -r104);
        setStateInternal(1);
        goto L23
    L20:
        if (this.f187547a == true) goto L22;
        int r111 = r108 - r110;
        r105[1] = r111;
        ViewCompat.offsetTopAndBottom(r101, -r111);
        setStateInternal(4);
        goto L23
    L9:
        if (r109 >= getExpandedOffset()) goto L11;
        int r112 = r108 - getExpandedOffset();
        r105[1] = r112;
        ViewCompat.offsetTopAndBottom(r101, -r112);
        setStateInternal(3);
        goto L23
    L11:
        r105[1] = r104;
        ViewCompat.offsetTopAndBottom(r101, -r104);
        setStateInternal(1);
        goto L23
    L26:
        return;
    }
}
