package com.bytedance.android.livesdk.pannel;

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
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u00012B\u001b\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u0012\b\u0010/\u001a\u0004\u0018\u00010.¢\u0006\u0004\b0\u00101J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\fH\u0017¢\u0006\u0004\b\u000e\u0010\u000fJ7\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016JG\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010!\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J!\u0010#\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0004\b#\u0010$J?\u0010'\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010%\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH\u0016¢\u0006\u0004\b'\u0010(J/\u0010)\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\fH\u0016¢\u0006\u0004\b)\u0010*J'\u0010+\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b+\u0010\u000b¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdk/pannel/RightSheetBehavior;", "Landroid/view/View;", "V", "Lcom/bytedance/android/livesdk/pannel/SheetBaseBehavior;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "parent", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Landroid/view/MotionEvent;", "event", "", "onInterceptTouchEvent", "(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/MotionEvent;)Z", "", "layoutDirection", "onLayoutChild", "(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;I)Z", "coordinatorLayout", PickerReporterConstants.KEY.TARGET, "", "velocityX", "velocityY", "onNestedPreFling", "(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;FF)Z", "dx", "dy1", "", "consumed", "type", "", "onNestedPreScroll", "(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;II[II)V", "Landroid/os/Parcelable;", "state", "onRestoreInstanceState", "(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/os/Parcelable;)V", "onSaveInstanceState", "(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;)Landroid/os/Parcelable;", "directTargetChild", "axes", "onStartNestedScroll", "(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;Landroid/view/View;II)Z", "onStopNestedScroll", "(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;I)V", "onTouchEvent", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "panel_release"}, k = 1, mv = {1, 4, 0})
public final class RightSheetBehavior<V extends View> extends SheetBaseBehavior<V> {
    public Map<View, Integer> A;
    public final RightSheetBehavior$dragCallback$1 B;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f154302g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f154303h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f154304i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f154305j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f154306k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f154307l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f154308m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f154309n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f154310o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewDragHelper f154311p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f154312q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f154313r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f154314s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f154315t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public WeakReference<V> f154316u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public WeakReference<View> f154317v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public VelocityTracker f154318w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f154319x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f154320y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f154321z;

    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f154322a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f154323b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RightSheetBehavior f154324c;

        @Override // java.lang.Runnable
        public final void run() {
            ViewDragHelper r100 = this.f154324c.f154311p;     // Catch: Throwable -> L9
            if (r100 != null) goto L5;
        L7:
            this.f154324c.setStateInternal(this.f154323b);     // Catch: Throwable -> L9
        L14:
            return;
        L5:
            if (r100.continueSettling(true) != true) goto L7;
            ViewCompat.postOnAnimation(this.f154322a, this);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }

        public a(RightSheetBehavior r100, View r101, int r102) {
            this.f154324c = r100;
            this.f154322a = r101;
            this.f154323b = r102;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RightSheetBehavior f154325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f154326b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f154327c;

        public b(RightSheetBehavior r100, View r101, int r102) {
            this.f154325a = r100;
            this.f154326b = r101;
            this.f154327c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f154325a.startSettlingAnimation(this.f154326b, this.f154327c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final int getExpandedOffset() {
        if (this.f154302g == true) goto L7;
        return 0;
    L7:
        return this.f154307l;
    }

    public final void dispatchOnSlide(int r100) {
        WeakReference<V> r101 = this.f154316u;
        if (r101 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        V r102 = r101.get();
        if (r102 == null) goto L18;
        SheetBaseBehavior.b r103 = this.f154332b;
        if (r103 != null) goto L10;
        return;
    L10:
        if (r100 <= this.f154309n) goto L14;
        if (r103 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        int r104 = this.f154309n;
        r103.b(r102, (r104 - r100) / (this.f154315t - r104));
        return;
    L14:
        if (r103 != null) goto L16;
        Intrinsics.throwNpe();
    L16:
        int r105 = this.f154309n;
        r103.b(r102, (r105 - r100) / (r105 - getExpandedOffset()));
        return;
    }

    @Override // com.bytedance.android.livesdk.pannel.SheetBaseBehavior
    public final void setPeekHeight(int r100) {
        boolean r101 = true;
        if (r100 != (-1)) goto L8;
        if (this.f154305j == true) goto L12;
        this.f154305j = true;
    L14:
        if (r101 == true) goto L16;
        return;
    L16:
        if (this.f154310o != 4) goto L25;
        WeakReference<V> r102 = this.f154316u;
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
        if (this.f154305j == false) goto L10;
    L13:
        this.f154305j = false;
        this.f154304i = Math.max(0, r100);
        this.f154309n = this.f154315t - r100;
        goto L14
    L10:
        if (this.f154304i == r100) goto L12;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.pannel.SheetBaseBehavior
    public final void setState(int r100) {
        if (r100 == this.f154310o) goto L28;
        WeakReference<V> r101 = this.f154316u;
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
        this.f154310o = r100;
        return;
    L9:
        if (r100 == 3) goto L16;
        if (r100 == 6) goto L16;
        if (this.f154331a == true) goto L15;
        return;
    L15:
        if (r100 == 5) goto L16;
        return;
    }

    public final void setStateInternal(int r100) {
        if (this.f154310o == r100) goto L25;
        this.f154310o = r100;
        if (r100 != 6) goto L7;
    L13:
        updateImportantForAccessibility(true);
    L14:
        WeakReference<V> r101 = this.f154316u;
        if (r101 != null) goto L17;
        Intrinsics.throwNpe();
    L17:
        V r102 = r101.get();
        if (r102 == null) goto L26;
        SheetBaseBehavior.b r103 = this.f154332b;
        if (r103 == null) goto L27;
        if (r103 != null) goto L23;
        Intrinsics.throwNpe();
    L23:
        r103.a(r102, r100);
        return;
    L27:
        return;
    L26:
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
        WeakReference<V> r101 = this.f154316u;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101 == null) goto L7;
        V r102 = r101.get();
    L8:
        if (r102 == null) goto L46;
        ViewParent r103 = r102.getParent();
        if ((r103 instanceof CoordinatorLayout) == false) goto L54;
        CoordinatorLayout r104 = (CoordinatorLayout) r103;
        int r105 = r104.getChildCount();
        if (r100 == true) goto L14;
    L17:
        int r106 = 0;
    L18:
        if (r106 >= r105) goto L43;
        View r107 = r104.getChildAt(r106);
        WeakReference<V> r108 = this.f154316u;
        if (r108 == null) goto L22;
        V r109 = r108.get();
    L23:
        if (r107 == r109) goto L42;
        if (r100 == true) goto L38;
        Map<View, Integer> r110 = this.A;
        if (r110 == null) goto L42;
        if (r110 != null) goto L30;
        Intrinsics.throwNpe();
    L30:
        if (r110.containsKey(r107) == false) goto L42;
        Map<View, Integer> r111 = this.A;
        if (r111 != null) goto L34;
        Intrinsics.throwNpe();
    L34:
        Integer r112 = r111.get(r107);
        if (r112 != null) goto L37;
        Intrinsics.throwNpe();
    L37:
        ViewCompat.setImportantForAccessibility(r107, r112.intValue());
        goto L42
    L38:
        Map<View, Integer> r113 = this.A;
        if (r113 != null) goto L41;
        Intrinsics.throwNpe();
    L41:
        r113.put(r107, Integer.valueOf(r107.getImportantForAccessibility()));
        ViewCompat.setImportantForAccessibility(r107, 4);
    L42:
        r106 = r106 + 1;
        goto L18
    L22:
        r109 = null;
        goto L23
    L43:
        if (r100 == true) goto L55;
        this.A = null;
        return;
    L55:
        return;
    L14:
        if (this.A == null) goto L16;
        return;
    L16:
        this.A = new HashMap(r105);
        goto L17
    L54:
        return;
    L46:
        throw new TypeCastException("null cannot be cast to non-null type android.view.View");
    L7:
        r102 = null;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.bytedance.android.livesdk.pannel.RightSheetBehavior$dragCallback$1] */
    public RightSheetBehavior(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f154302g = true;
        this.f154310o = 4;
        this.B = new RightSheetBehavior$dragCallback$1(this);
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.behavior_fitToContents, R.attr.behavior_hideable, R.attr.behavior_peekHeight, R.attr.behavior_skipCollapsed});
        TypedValue r103 = r102.peekValue(2);
        if (r103 == null) goto L7;
        int r104 = r103.data;
        if (r104 != (-1)) goto L7;
        setPeekHeight(r104);
    L8:
        this.f154331a = r102.getBoolean(1, false);
        if (this.f154302g == true) goto L20;
        this.f154302g = true;
        if (this.f154316u == null) goto L14;
        this.f154309n = Math.max(this.f154315t - this.f154306k, this.f154307l);
    L14:
        if (this.f154302g == true) goto L16;
    L18:
        int r105 = this.f154310o;
    L19:
        setStateInternal(r105);
        goto L20
    L16:
        if (this.f154310o != 6) goto L18;
        r105 = 3;
    L20:
        this.f154333c = r102.getBoolean(3, false);
        r102.recycle();
        this.f154303h = ViewConfiguration.get(r100).getScaledMaximumFlingVelocity();
        return;
    L7:
        setPeekHeight(r102.getDimensionPixelSize(2, -1));
        goto L8
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final Parcelable onSaveInstanceState(CoordinatorLayout r100, V r101) {
        return new SavedState(super.onSaveInstanceState(r100, r101), this.f154310o);
    }

    public final boolean shouldHide(View r100, float r101) {
        if (this.f154333c == false) goto L14;
        float r102 = r101 * 0.1f;
        if (r102 <= 500) goto L8;
        return true;
    L8:
        if (r102 >= (-30)) goto L11;
        return false;
    L11:
        if (((this.f154315t - (r100.getLeft() + r102)) / r100.getWidth()) < 0.5f) goto L20;
    L15:
        return false;
    L20:
        return true;
    L14:
        if (r100.getLeft() < this.f154309n) goto L15;
        if ((Math.abs((r100.getLeft() + (r101 * 0.1f)) - this.f154309n) / this.f154304i) <= 0.5f) goto L15;
        return true;
    }

    public final void startSettlingAnimation(View r100, int r101) {
        if (r101 != 4) goto L6;
        int r102 = this.f154309n;
    L22:
        ViewDragHelper r103 = this.f154311p;
        if (r103 != null) goto L25;
    L27:
        setStateInternal(r101);
        return;
    L25:
        if (r103.smoothSlideViewTo(r100, r102, r100.getTop()) != true) goto L27;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r100, new a(this, r100, r101));
        return;
    L6:
        if (r101 != 6) goto L12;
        r102 = this.f154308m;
        if (this.f154302g == false) goto L22;
        int r104 = this.f154307l;
        if (r102 > r104) goto L22;
        r102 = r104;
        r101 = 3;
        goto L22
    L12:
        if (r101 != 3) goto L15;
        r102 = getExpandedOffset();
        goto L22
    L15:
        if (this.f154331a == true) goto L17;
    L19:
        boolean r105 = false;
    L20:
        if (r105 == false) goto L30;
        r102 = this.f154315t;
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
        if (r111 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        if (r111.isShown() == true) goto L7;
    L106:
        this.f154312q = true;
        return false;
    L7:
        if (this.f154334d.disableDragDown() == false) goto L9;
    L12:
        boolean r100 = true;
    L14:
        if (r100 == true) goto L16;
    L34:
        int r101 = r112.getActionMasked();
        View r102 = null;
        if (r101 != 0) goto L40;
        this.f154319x = -1;
        VelocityTracker r103 = this.f154318w;
        if (r103 == null) goto L40;
        r103.recycle();
        this.f154318w = null;
    L40:
        if (this.f154318w != null) goto L42;
        this.f154318w = VelocityTracker.obtain();
    L42:
        VelocityTracker r104 = this.f154318w;
        if (r104 != null) goto L45;
        Intrinsics.throwNpe();
    L45:
        r104.addMovement(r112);
        if (r101 == 0) goto L65;
        if (r101 == 1) goto L56;
        if (r101 == 2) goto L52;
        if (r101 == 3) goto L56;
    L81:
        if (this.f154312q == true) goto L87;
        ViewDragHelper r113 = this.f154311p;
        if (r113 == null) goto L87;
        if (r113.shouldInterceptTouchEvent(r112) != true) goto L87;
    L105:
        return true;
    L87:
        WeakReference<View> r114 = this.f154317v;
        if (r114 == null) goto L90;
        r102 = r114.get();
    L90:
        if (r101 != 2) goto L108;
        if (r102 != null) goto L93;
        return false;
    L93:
        if (this.f154312q == false) goto L95;
        return false;
    L95:
        if (this.f154310o != 1) goto L97;
        return false;
    L97:
        if (r110.isPointInChildBounds(r102, (int) r112.getX(), (int) r112.getY()) == false) goto L99;
        return false;
    L99:
        if (this.f154311p == null) goto L113;
        float r115 = Math.abs(this.f154320y - r112.getX());
        ViewDragHelper r116 = this.f154311p;
        if (r116 != null) goto L104;
        Intrinsics.throwNpe();
    L104:
        if (r115 > r116.getTouchSlop()) goto L105;
        return false;
    L113:
        return false;
    L108:
        return false;
    L52:
        if (this.f154335e.e() == false) goto L81;
        if (this.f154335e.a() == false) goto L81;
        this.f154312q = false;
    L56:
        this.f154321z = false;
        this.f154319x = -1;
        if (this.f154312q == false) goto L61;
        this.f154312q = false;
        return false;
    L61:
        if (this.f154335e.e() == false) goto L81;
        if (this.f154335e.a() == false) goto L81;
        this.f154312q = false;
        goto L81
    L65:
        this.f154320y = (int) r112.getX();
        int r105 = (int) r112.getY();
        WeakReference<View> r106 = this.f154317v;
        if (r106 == null) goto L68;
        View r107 = r106.get();
    L69:
        if (r107 == null) goto L74;
        if (r110.isPointInChildBounds(r107, this.f154320y, r105) == false) goto L74;
        this.f154319x = r112.getPointerId(r112.getActionIndex());
        this.f154321z = true;
    L74:
        if (this.f154319x == (-1)) goto L76;
    L78:
        boolean r117 = false;
    L79:
        this.f154312q = r117;
        goto L81
    L76:
        if (r110.isPointInChildBounds(r111, this.f154320y, r105) == true) goto L78;
        r117 = true;
        goto L79
    L68:
        r107 = null;
        goto L69
    L16:
        if (this.f154335e.e() == true) goto L18;
    L31:
        boolean r108 = true;
    L32:
        if (r108 == false) goto L34;
    L18:
        if (this.f154335e.a() == false) goto L31;
        if (this.f154310o != 4) goto L26;
        if (this.f154335e.c() == false) goto L26;
    L30:
        r108 = false;
    L26:
        if (this.f154310o != 3) goto L31;
        if (this.f154335e.d() == true) goto L30;
    L9:
        if (this.f154334d.shouldInterceptSlide((int) r112.getY()) == false) goto L12;
        r100 = false;
        goto L14
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout r100, V r101, int r102) {
        if (r101 != null) goto L6;
        return false;
    L6:
        if (ViewCompat.getFitsSystemWindows(r100) == true) goto L8;
    L10:
        r101.getLeft();
        r100.onLayoutChild(r101, r102);     // Catch: Exception -> L13
    L19:
        int r103 = r100.getWidth();
        this.f154315t = r103;
        if (this.f154305j == false) goto L22;
        this.f154306k = (r103 * 9) / 16;
    L23:
        int r104 = RangesKt.coerceAtLeast(0, r103 - r101.getWidth());
        this.f154307l = r104;
        int r105 = this.f154315t;
        this.f154308m = r105 / 2;
        if (this.f154302g == false) goto L26;
        this.f154309n = Math.max(r105 - this.f154306k, r104);
    L28:
        if (this.f154311p != null) goto L30;
        this.f154311p = ViewDragHelper.create(r100, this.B);
    L30:
        this.f154316u = new WeakReference(r101);
        this.f154317v = new WeakReference(findScrollingChild(r101));
        return true;
    L26:
        this.f154309n = r105 - this.f154306k;
        goto L28
    L22:
        this.f154306k = this.f154304i;
    L34:
        ViewGroup r106 = (ViewGroup) r100.findViewById(R.id.ttlive_design_bottom_sheet);     // Catch: Exception -> L18
        if (r106 == null) goto L19;
        a(r106);     // Catch: Exception -> L18
        goto L19
    L8:
        if (ViewCompat.getFitsSystemWindows(r101) == true) goto L10;
        r101.setFitsSystemWindows(true);
        goto L10
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onRestoreInstanceState(CoordinatorLayout r100, V r101, Parcelable r102) {
        SavedState r103 = (SavedState) r102;
        if (r103.getSuperState() == null) goto L8;
        Parcelable r104 = r103.getSuperState();
        if (r104 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        super.onRestoreInstanceState(r100, r101, r104);
    L8:
        int r105 = r103.f154329a;
        if (r105 != 1) goto L11;
    L13:
        this.f154310o = 4;
        return;
    L11:
        if (r105 == 2) goto L13;
        this.f154310o = r105;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout r100, V r101, MotionEvent r102) {
        if (r101 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        if (r101.isShown() == false) goto L36;
        int r103 = r102.getActionMasked();
        if (this.f154310o != 1) goto L11;
        if (r103 != 0) goto L11;
        return true;
    L11:
        ViewDragHelper r104 = this.f154311p;
        if (r104 == null) goto L14;
        r104.processTouchEvent(r102);
    L14:
        if (r103 != 0) goto L19;
        this.f154319x = -1;
        VelocityTracker r105 = this.f154318w;
        if (r105 == null) goto L19;
        r105.recycle();
        this.f154318w = null;
    L19:
        if (this.f154318w != null) goto L21;
        this.f154318w = VelocityTracker.obtain();
    L21:
        VelocityTracker r106 = this.f154318w;
        if (r106 != null) goto L24;
        Intrinsics.throwNpe();
    L24:
        r106.addMovement(r102);
        ViewDragHelper r107 = this.f154311p;
        if (r107 == null) goto L34;
        if (r103 != 2) goto L34;
        if (this.f154312q == true) goto L34;
        if (Math.abs(this.f154320y - r102.getX()) <= r107.getTouchSlop()) goto L34;
        r107.captureChildView(r101, r102.getPointerId(r102.getActionIndex()));
    L34:
        if (this.f154312q == true) goto L36;
        return true;
    L36:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onStopNestedScroll(CoordinatorLayout r100, V r101, View r102, int r103) {
        if (r101 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        if (r101.getLeft() != getExpandedOffset()) goto L7;
        setStateInternal(3);
        return;
    L7:
        WeakReference<View> r104 = this.f154317v;
        if (r104 != null) goto L11;
        Intrinsics.throwNpe();
    L11:
        if (r102 == r104.get()) goto L13;
        return;
    L13:
        if (this.f154314s == true) goto L15;
        return;
    L15:
        if (this.f154313r <= 30) goto L19;
        int r105 = getExpandedOffset();
    L17:
        byte r106 = (byte) 3;
    L54:
        if (r106 != 5) goto L57;
        setStateInternal(r106);
        return;
    L57:
        ViewDragHelper r107 = this.f154311p;
        if (r107 != null) goto L60;
    L62:
        setStateInternal(r106);
    L63:
        this.f154314s = false;
        return;
    L60:
        if (r107.smoothSlideViewTo(r101, r105, r101.getTop()) != true) goto L62;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r101, new a(this, r101, r106));
        goto L63
    L19:
        if (this.f154331a == false) goto L31;
        VelocityTracker r108 = this.f154318w;
        if (r108 != null) goto L23;
        float r109 = 0.0f;
    L28:
        if (shouldHide(r101, r109) == false) goto L31;
        r105 = this.f154315t;
        r106 = (byte) 5;
        goto L54
    L23:
        r108.computeCurrentVelocity(1000, this.f154303h);
        VelocityTracker r110 = this.f154318w;
        if (r110 != null) goto L26;
        Intrinsics.throwNpe();
    L26:
        r109 = r110.getYVelocity(this.f154319x);
    L31:
        if (this.f154333c == false) goto L34;
        r105 = getExpandedOffset();
        goto L17
    L34:
        if (this.f154313r != 0) goto L52;
        int r111 = r101.getTop();
        if (this.f154302g == true) goto L38;
        int r112 = this.f154308m;
        if (r111 >= r112) goto L48;
        if (r111 >= Math.abs(r111 - this.f154309n)) goto L46;
        r106 = (byte) 3;
        r105 = 0;
        goto L54
    L46:
        r105 = this.f154308m;
    L50:
        r106 = (byte) 6;
        goto L54
    L48:
        if (Math.abs(r111 - r112) >= Math.abs(r111 - this.f154309n)) goto L51;
        r105 = this.f154308m;
        goto L50
    L51:
        r105 = this.f154309n;
    L53:
        r106 = (byte) 4;
        goto L54
    L38:
        if (Math.abs(r111 - this.f154307l) >= Math.abs(r111 - this.f154309n)) goto L40;
        r105 = this.f154307l;
        goto L17
    L40:
        r105 = this.f154309n;
        goto L53
    L52:
        r105 = this.f154309n;
        goto L53
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onNestedPreFling(CoordinatorLayout r100, V r101, View r102, float r103, float r104) {
        WeakReference<View> r105 = this.f154317v;
        if (r105 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        if (r102 == r105.get()) goto L8;
    L12:
        return false;
    L8:
        if (this.f154310o == 3) goto L10;
    L11:
        return true;
    L10:
        if (super.onNestedPreFling(r100, r101, r102, r103, r104) == false) goto L12;
        goto L11
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onStartNestedScroll(CoordinatorLayout r100, V r101, View r102, View r103, int r104, int r105) {
        this.f154313r = 0;
        this.f154314s = false;
        if ((r104 & 1) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedPreScroll(CoordinatorLayout r100, V r101, View r102, int r103, int r104, int[] r105, int r106) {
        if (r106 == 1) goto L30;
        WeakReference<View> r107 = this.f154317v;
        if (r107 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        if (r102 != r107.get()) goto L31;
        if (r101 != null) goto L11;
        Intrinsics.throwNpe();
    L11:
        int r108 = r101.getLeft();
        int r109 = r108 - r103;
        if (r103 > 0) goto L14;
        if (r103 < 0) goto L19;
    L28:
        dispatchOnSlide(r101.getLeft());
        this.f154313r = r103;
        this.f154314s = true;
        return;
    L19:
        if (r102.canScrollHorizontally(-1) == true) goto L28;
        if (this.f154334d.disableDragDown() == true) goto L28;
        int r110 = this.f154309n;
        if (r109 > r110) goto L25;
    L27:
        r105[0] = r103;
        ViewCompat.offsetLeftAndRight(r101, -r103);
        setStateInternal(1);
        goto L28
    L25:
        if (this.f154331a == true) goto L27;
        int r111 = r108 - r110;
        r105[0] = r111;
        ViewCompat.offsetLeftAndRight(r101, -r111);
        setStateInternal(4);
        goto L28
    L14:
        if (r109 >= getExpandedOffset()) goto L16;
        int r112 = r108 - getExpandedOffset();
        r105[0] = r112;
        ViewCompat.offsetLeftAndRight(r101, -r112);
        setStateInternal(3);
        goto L28
    L16:
        r105[0] = r103;
        ViewCompat.offsetLeftAndRight(r101, -r103);
        setStateInternal(1);
        goto L28
    L31:
        return;
    }
}
