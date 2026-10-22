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
import androidx.core.view.ViewParentCompat;
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

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u00012B\u001b\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u0012\b\u0010/\u001a\u0004\u0018\u00010.¢\u0006\u0004\b0\u00101J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ7\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016JG\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010!\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J!\u0010#\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0004\b#\u0010$J?\u0010'\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010%\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH\u0016¢\u0006\u0004\b'\u0010(J/\u0010)\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\fH\u0016¢\u0006\u0004\b)\u0010*J'\u0010+\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b+\u0010\u000b¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdk/pannel/BottomSheetBehavior;", "Landroid/view/View;", "V", "Lcom/bytedance/android/livesdk/pannel/SheetBaseBehavior;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "parent", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Landroid/view/MotionEvent;", "event", "", "onInterceptTouchEvent", "(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/MotionEvent;)Z", "", "layoutDirection", "onLayoutChild", "(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;I)Z", "coordinatorLayout", PickerReporterConstants.KEY.TARGET, "", "velocityX", "velocityY", "onNestedPreFling", "(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;FF)Z", "dx", "dy", "", "consumed", "type", "", "onNestedPreScroll", "(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;II[II)V", "Landroid/os/Parcelable;", "state", "onRestoreInstanceState", "(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/os/Parcelable;)V", "onSaveInstanceState", "(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;)Landroid/os/Parcelable;", "directTargetChild", "axes", "onStartNestedScroll", "(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;Landroid/view/View;II)Z", "onStopNestedScroll", "(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;I)V", "onTouchEvent", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "panel_release"}, k = 1, mv = {1, 4, 0})
public final class BottomSheetBehavior<V extends View> extends SheetBaseBehavior<V> {
    public static final /* synthetic */ int F = 0;
    public int A;
    public boolean B;
    public boolean C;
    public Map<View, Integer> D;
    public final BottomSheetBehavior$dragCallback$1 E;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f154274g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f154275h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f154276i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f154277j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f154278k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f154279l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f154280m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f154281n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f154282o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f154283p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ViewDragHelper f154284q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f154285r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f154286s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f154287t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f154288u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public WeakReference<V> f154289v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public WeakReference<View> f154290w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public WeakReference<ViewParent> f154291x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public VelocityTracker f154292y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f154293z;

    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f154294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f154295b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior f154296c;

        @Override // java.lang.Runnable
        public final void run() {
            ViewDragHelper r100 = this.f154296c.f154284q;     // Catch: Throwable -> L9
            if (r100 != null) goto L5;
        L7:
            this.f154296c.setStateInternal(this.f154295b);     // Catch: Throwable -> L9
        L14:
            return;
        L5:
            if (r100.continueSettling(true) != true) goto L7;
            ViewCompat.postOnAnimation(this.f154294a, this);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }

        public a(BottomSheetBehavior r100, View r101, int r102) {
            this.f154296c = r100;
            this.f154294a = r101;
            this.f154295b = r102;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior f154297a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f154298b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f154299c;

        public b(BottomSheetBehavior r100, View r101, int r102) {
            this.f154297a = r100;
            this.f154298b = r101;
            this.f154299c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f154297a.startSettlingAnimation(this.f154298b, this.f154299c);     // Catch: Throwable -> L4
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
        if (this.f154335e.e() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f154335e.b() == false) goto L7;
        return true;
    }

    public final int getExpandedOffset() {
        if (this.f154274g == true) goto L7;
        return 0;
    L7:
        return this.f154280m;
    }

    public final void dispatchOnSlide(int r100) {
        WeakReference<V> r101 = this.f154289v;
        if (r101 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        V r102 = r101.get();
        if (r102 == null) goto L18;
        SheetBaseBehavior.b r103 = this.f154332b;
        if (r103 != null) goto L10;
        return;
    L10:
        if (r100 <= this.f154282o) goto L14;
        if (r103 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        int r104 = this.f154282o;
        r103.b(r102, (r104 - r100) / (this.f154288u - r104));
        return;
    L14:
        if (r103 != null) goto L16;
        Intrinsics.throwNpe();
    L16:
        int r105 = this.f154282o;
        r103.b(r102, (r105 - r100) / (r105 - getExpandedOffset()));
        return;
    }

    @Override // com.bytedance.android.livesdk.pannel.SheetBaseBehavior
    public final void setPeekHeight(int r100) {
        boolean r101 = true;
        if (r100 != (-1)) goto L8;
        if (this.f154277j == true) goto L12;
        this.f154277j = true;
    L14:
        if (r101 == true) goto L16;
        return;
    L16:
        if (this.f154283p != 4) goto L25;
        WeakReference<V> r102 = this.f154289v;
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
        if (this.f154277j == false) goto L10;
    L13:
        this.f154277j = false;
        this.f154276i = Math.max(0, r100);
        this.f154282o = this.f154288u - r100;
        goto L14
    L10:
        if (this.f154276i == r100) goto L12;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.pannel.SheetBaseBehavior
    public final void setState(int r100) {
        if (r100 == this.f154283p) goto L28;
        WeakReference<V> r101 = this.f154289v;
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
        this.f154283p = r100;
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
        if (this.f154283p == r100) goto L25;
        this.f154283p = r100;
        if (r100 != 6) goto L7;
    L13:
        updateImportantForAccessibility(true);
    L14:
        WeakReference<V> r101 = this.f154289v;
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
        WeakReference<V> r101 = this.f154289v;
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
        WeakReference<V> r108 = this.f154289v;
        if (r108 == null) goto L22;
        V r109 = r108.get();
    L23:
        if (r107 == r109) goto L42;
        if (r100 == true) goto L38;
        Map<View, Integer> r110 = this.D;
        if (r110 == null) goto L42;
        if (r110 != null) goto L30;
        Intrinsics.throwNpe();
    L30:
        if (r110.containsKey(r107) == false) goto L42;
        Map<View, Integer> r111 = this.D;
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
        Map<View, Integer> r113 = this.D;
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
        this.D = null;
        return;
    L55:
        return;
    L14:
        if (this.D == null) goto L16;
        return;
    L16:
        this.D = new HashMap(r105);
        goto L17
    L54:
        return;
    L46:
        throw new TypeCastException("null cannot be cast to non-null type android.view.View");
    L7:
        r102 = null;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.bytedance.android.livesdk.pannel.BottomSheetBehavior$dragCallback$1] */
    public BottomSheetBehavior(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f154274g = true;
        this.f154283p = 4;
        this.E = new BottomSheetBehavior$dragCallback$1(this);
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.behavior_fitToContents, R.attr.behavior_hideable, R.attr.behavior_peekHeight, R.attr.behavior_skipCollapsed});
        TypedValue r103 = r102.peekValue(2);
        if (r103 == null) goto L7;
        int r104 = r103.data;
        if (r104 != (-1)) goto L7;
        setPeekHeight(r104);
    L8:
        this.f154331a = r102.getBoolean(1, false);
        if (this.f154274g == true) goto L20;
        this.f154274g = true;
        if (this.f154289v == null) goto L14;
        this.f154282o = Math.max(this.f154288u - this.f154279l, this.f154280m);
    L14:
        if (this.f154274g == true) goto L16;
    L18:
        int r105 = this.f154283p;
    L19:
        setStateInternal(r105);
        goto L20
    L16:
        if (this.f154283p != 6) goto L18;
        r105 = 3;
    L20:
        this.f154333c = r102.getBoolean(3, false);
        r102.recycle();
        this.f154275h = ViewConfiguration.get(r100).getScaledMaximumFlingVelocity();
        return;
    L7:
        setPeekHeight(r102.getDimensionPixelSize(2, -1));
        goto L8
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final Parcelable onSaveInstanceState(CoordinatorLayout r100, V r101) {
        return new SavedState(super.onSaveInstanceState(r100, r101), this.f154283p);
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
        if (((this.f154288u - (r100.getTop() + r102)) / r100.getHeight()) < 0.5f) goto L20;
    L15:
        return false;
    L20:
        return true;
    L14:
        if (r100.getTop() < this.f154282o) goto L15;
        if ((Math.abs((r100.getTop() + (r101 * 0.1f)) - this.f154282o) / this.f154276i) <= 0.5f) goto L15;
        return true;
    }

    public final void startSettlingAnimation(View r100, int r101) {
        if (r101 != 4) goto L6;
        int r102 = this.f154282o;
    L22:
        ViewDragHelper r103 = this.f154284q;
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
        r102 = this.f154281n;
        if (this.f154274g == false) goto L22;
        int r104 = this.f154280m;
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
        r102 = this.f154288u;
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
    L152:
        this.f154285r = true;
        return false;
    L7:
        if (this.f154334d.a(r112) == false) goto L10;
    L14:
        boolean r100 = false;
    L17:
        if (r100 == false) goto L37;
        if (this.f154335e.e() == true) goto L21;
    L34:
        boolean r101 = true;
    L35:
        if (r101 == true) goto L152;
    L21:
        if (this.f154335e.a() == false) goto L34;
        if (this.f154283p != 4) goto L29;
        if (this.f154335e.c() == false) goto L29;
    L33:
        r101 = false;
    L29:
        if (this.f154283p != 3) goto L34;
        if (this.f154335e.d() == true) goto L33;
    L37:
        if (this.f154335e.f(r112) == true) goto L152;
        int r102 = r112.getActionMasked();
        ViewGroup r103 = null;
        View r104 = null;
        ViewParent r105 = null;
        if (r102 != 0) goto L45;
        this.f154293z = -1;
        VelocityTracker r106 = this.f154292y;
        if (r106 == null) goto L45;
        r106.recycle();
        this.f154292y = null;
    L45:
        if (this.f154292y != null) goto L47;
        this.f154292y = VelocityTracker.obtain();
    L47:
        VelocityTracker r107 = this.f154292y;
        if (r107 != null) goto L50;
        Intrinsics.throwNpe();
    L50:
        r107.addMovement(r112);
        if (r102 == 0) goto L70;
        if (r102 == 1) goto L61;
        if (r102 == 2) goto L57;
        if (r102 == 3) goto L61;
    L94:
        if (this.f154285r == true) goto L101;
        ViewDragHelper r113 = this.f154284q;
        if (r113 == null) goto L101;
        if (r113.shouldInterceptTouchEvent(r112) != true) goto L101;
    L120:
        return true;
    L101:
        if (b() == true) goto L121;
        WeakReference<View> r114 = this.f154290w;
        if (r114 == null) goto L105;
        r104 = r114.get();
    L105:
        if (r102 != 2) goto L163;
        if (r104 != null) goto L108;
        return false;
    L108:
        if (this.f154285r == false) goto L110;
        return false;
    L110:
        if (this.f154283p != 1) goto L112;
        return false;
    L112:
        if (r110.isPointInChildBounds(r104, (int) r112.getX(), (int) r112.getY()) == false) goto L114;
        return false;
    L114:
        if (this.f154284q == null) goto L168;
        float r115 = Math.abs(this.A - r112.getY());
        ViewDragHelper r116 = this.f154284q;
        if (r116 != null) goto L119;
        Intrinsics.throwNpe();
    L119:
        if (r115 > r116.getTouchSlop()) goto L120;
        return false;
    L168:
        return false;
    L163:
        return false;
    L121:
        WeakReference<View> r117 = this.f154290w;
        if (r117 == null) goto L124;
        View r118 = r117.get();
    L125:
        WeakReference<ViewParent> r108 = this.f154291x;
        if (r108 == null) goto L132;
        ViewParent r109 = r108.get();
        if ((r109 instanceof ViewGroup) == false) goto L131;
        r105 = r109;
    L131:
        r103 = (ViewGroup) r105;
    L132:
        if (r102 == 2) goto L134;
        return false;
    L134:
        if (this.f154285r == true) goto L155;
        float r119 = Math.abs(this.A - r112.getY());
        ViewDragHelper r120 = this.f154284q;
        if (r120 != null) goto L139;
        Intrinsics.throwNpe();
    L139:
        if (r119 > r120.getTouchSlop()) goto L141;
        return false;
    L141:
        if (this.f154283p != 1) goto L143;
        return false;
    L143:
        if (this.f154284q == null) goto L158;
        if (r118 != null) goto L146;
        return false;
    L146:
        if (r110.isPointInChildBounds(r118, (int) r112.getX(), (int) r112.getY()) == true) goto L160;
        if (r103 != null) goto L149;
        return false;
    L149:
        if (r110.isPointInChildBounds(r103, (int) r112.getX(), (int) r112.getY()) == true) goto L162;
        return true;
    L162:
        return false;
    L160:
        return false;
    L158:
        return false;
    L155:
        return false;
    L124:
        r118 = null;
        goto L125
    L57:
        if (this.f154335e.e() == false) goto L94;
        if (this.f154335e.a() == false) goto L94;
        this.f154285r = false;
    L61:
        this.B = false;
        this.C = false;
        this.f154293z = -1;
        if (this.f154285r == false) goto L66;
        this.f154285r = false;
        return false;
    L66:
        if (this.f154335e.e() == false) goto L94;
        if (this.f154335e.a() == false) goto L94;
        this.f154285r = false;
        goto L94
    L70:
        int r121 = (int) r112.getX();
        this.A = (int) r112.getY();
        WeakReference<View> r122 = this.f154290w;
        if (r122 == null) goto L73;
        View r123 = r122.get();
    L74:
        if (r123 != null) goto L76;
    L78:
        WeakReference<ViewParent> r124 = this.f154291x;
        if (r124 == null) goto L81;
        Object r125 = r124.get();
    L82:
        if (r125 == null) goto L87;
        if (r110.isPointInChildBounds((View) r125, r121, this.A) == false) goto L87;
        this.f154293z = r112.getPointerId(r112.getActionIndex());
        this.C = true;
    L87:
        if (this.f154293z == (-1)) goto L89;
    L91:
        boolean r126 = false;
    L92:
        this.f154285r = r126;
        goto L94
    L89:
        if (r110.isPointInChildBounds(r111, r121, this.A) == true) goto L91;
        r126 = true;
        goto L92
    L81:
        r125 = null;
        goto L82
    L76:
        if (r110.isPointInChildBounds(r123, r121, this.A) == false) goto L78;
        this.f154293z = r112.getPointerId(r112.getActionIndex());
        this.B = true;
        goto L78
    L73:
        r123 = null;
        goto L74
    L10:
        if (this.f154334d.disableDragDown() == false) goto L12;
    L15:
        r100 = true;
        goto L17
    L12:
        if (this.f154334d.shouldInterceptSlide((int) r112.getY()) == true) goto L14;
        goto L14
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout r100, V r101, int r102) {
        if (ViewCompat.getFitsSystemWindows(r100) == false) goto L9;
        if (r101 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        if (ViewCompat.getFitsSystemWindows(r101) == true) goto L9;
        r101.setFitsSystemWindows(true);
    L9:
        if (r101 != null) goto L11;
        Intrinsics.throwNpe();
    L11:
        int r103 = r101.getTop();
        r100.onLayoutChild(r101, r102);     // Catch: Exception -> L14
    L20:
        this.f154288u = r100.getHeight();
        if (this.f154277j == true) goto L23;
        this.f154279l = this.f154276i;
    L27:
        int r104 = Math.max(0, this.f154288u - r101.getHeight());
        this.f154280m = r104;
        int r105 = this.f154288u;
        this.f154281n = r105 / 2;
        if (this.f154274g == false) goto L30;
        this.f154282o = Math.max(r105 - this.f154279l, r104);
    L31:
        int r106 = this.f154283p;
        if (r106 != 3) goto L35;
        ViewCompat.offsetTopAndBottom(r101, getExpandedOffset());
    L49:
        if (this.f154284q != null) goto L51;
        this.f154284q = ViewDragHelper.create(r100, this.E);
    L51:
        this.f154289v = new WeakReference(r101);
        this.f154290w = new WeakReference(findScrollingChild(r101));
        if (b() == false) goto L70;
        WeakReference<View> r107 = this.f154290w;
        if (r107 != null) goto L56;
        Intrinsics.throwNpe();
    L56:
        View r108 = r107.get();
        ViewParent r109 = null;
        if (r108 == null) goto L59;
        ViewParent r110 = r108.getParent();
    L60:
        View r111 = r108;
    L61:
        if (r110 == null) goto L69;
        if (ViewParentCompat.onStartNestedScroll(r110, r111, r108, 2) == true) goto L64;
        if ((r110 instanceof View) == false) goto L68;
        r111 = (View) r110;
    L68:
        r110 = r110.getParent();
        goto L61
    L64:
        r109 = r110;
    L69:
        this.f154291x = new WeakReference(r109);
        goto L70
    L59:
        r110 = null;
    L70:
        return true;
    L35:
        if (r106 != 6) goto L38;
        ViewCompat.offsetTopAndBottom(r101, this.f154281n);
        goto L49
    L38:
        if (this.f154331a == false) goto L43;
        if (r106 != 5) goto L43;
        ViewCompat.offsetTopAndBottom(r101, this.f154288u);
    L43:
        if (r106 != 4) goto L45;
        ViewCompat.offsetTopAndBottom(r101, this.f154282o);
        goto L49
    L45:
        if (r106 == 1) goto L47;
        if (r106 != 2) goto L49;
    L47:
        ViewCompat.offsetTopAndBottom(r101, r103 - r101.getTop());
        goto L49
    L30:
        this.f154282o = r105 - this.f154279l;
        goto L31
    L23:
        if (this.f154278k != 0) goto L25;
        this.f154278k = r100.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
    L25:
        this.f154279l = Math.max(this.f154278k, this.f154288u - ((r100.getWidth() * 9) / 16));
    L73:
        ViewGroup r112 = (ViewGroup) r100.findViewById(R.id.ttlive_design_bottom_sheet);     // Catch: Exception -> L19
        if (r112 == null) goto L20;
        a(r112);     // Catch: Exception -> L19
        goto L20
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
        this.f154283p = 4;
        return;
    L11:
        if (r105 == 2) goto L13;
        this.f154283p = r105;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout r100, V r101, MotionEvent r102) {
        if (r101 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        if (r101.isShown() == false) goto L36;
        int r103 = r102.getActionMasked();
        if (this.f154283p != 1) goto L11;
        if (r103 != 0) goto L11;
        return true;
    L11:
        ViewDragHelper r104 = this.f154284q;
        if (r104 == null) goto L14;
        r104.processTouchEvent(r102);
    L14:
        if (r103 != 0) goto L19;
        this.f154293z = -1;
        VelocityTracker r105 = this.f154292y;
        if (r105 == null) goto L19;
        r105.recycle();
        this.f154292y = null;
    L19:
        if (this.f154292y != null) goto L21;
        this.f154292y = VelocityTracker.obtain();
    L21:
        VelocityTracker r106 = this.f154292y;
        if (r106 != null) goto L24;
        Intrinsics.throwNpe();
    L24:
        r106.addMovement(r102);
        ViewDragHelper r107 = this.f154284q;
        if (r107 == null) goto L34;
        if (r103 != 2) goto L34;
        if (this.f154285r == true) goto L34;
        if (Math.abs(this.A - r102.getY()) <= r107.getTouchSlop()) goto L34;
        r107.captureChildView(r101, r102.getPointerId(r102.getActionIndex()));
    L34:
        if (this.f154285r == true) goto L36;
        return true;
    L36:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onStopNestedScroll(CoordinatorLayout r100, V r101, View r102, int r103) {
        if (r101 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        if (r101.getTop() == getExpandedOffset()) goto L7;
        WeakReference<View> r104 = this.f154290w;
        if (r104 != null) goto L16;
        Intrinsics.throwNpe();
    L16:
        if (r102 == r104.get()) goto L18;
        return;
    L18:
        if (this.f154287t == true) goto L20;
        return;
    L20:
        if (this.f154286s <= 30) goto L24;
        int r105 = getExpandedOffset();
    L22:
        byte r106 = (byte) 3;
    L59:
        if (r106 != 5) goto L62;
        setStateInternal(r106);
        return;
    L62:
        ViewDragHelper r107 = this.f154284q;
        if (r107 != null) goto L65;
    L67:
        setStateInternal(r106);
    L68:
        this.f154287t = false;
        return;
    L65:
        if (r107.smoothSlideViewTo(r101, r101.getLeft(), r105) != true) goto L67;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r101, new a(this, r101, r106));
        goto L68
    L24:
        if (this.f154331a == false) goto L36;
        VelocityTracker r108 = this.f154292y;
        if (r108 != null) goto L28;
        float r109 = 0.0f;
    L33:
        if (shouldHide(r101, r109) == false) goto L36;
        r105 = this.f154288u;
        r106 = (byte) 5;
        goto L59
    L28:
        r108.computeCurrentVelocity(1000, this.f154275h);
        VelocityTracker r110 = this.f154292y;
        if (r110 != null) goto L31;
        Intrinsics.throwNpe();
    L31:
        r109 = r110.getYVelocity(this.f154293z);
    L36:
        if (this.f154333c == false) goto L39;
        r105 = getExpandedOffset();
        goto L22
    L39:
        if (this.f154286s != 0) goto L57;
        int r111 = r101.getTop();
        if (this.f154274g == true) goto L43;
        int r112 = this.f154281n;
        if (r111 >= r112) goto L53;
        if (r111 >= Math.abs(r111 - this.f154282o)) goto L51;
        r106 = (byte) 3;
        r105 = 0;
        goto L59
    L51:
        r105 = this.f154281n;
    L55:
        r106 = (byte) 6;
        goto L59
    L53:
        if (Math.abs(r111 - r112) >= Math.abs(r111 - this.f154282o)) goto L56;
        r105 = this.f154281n;
        goto L55
    L56:
        r105 = this.f154282o;
    L58:
        r106 = (byte) 4;
        goto L59
    L43:
        if (Math.abs(r111 - this.f154280m) >= Math.abs(r111 - this.f154282o)) goto L45;
        r105 = this.f154280m;
        goto L22
    L45:
        r105 = this.f154282o;
        goto L58
    L57:
        r105 = this.f154282o;
        goto L58
    L7:
        if (b() == true) goto L9;
        setStateInternal(3);
        return;
    L9:
        if (this.f154287t == false) goto L70;
        setStateInternal(3);
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onNestedPreFling(CoordinatorLayout r100, V r101, View r102, float r103, float r104) {
        WeakReference<View> r105 = this.f154290w;
        if (r105 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        if (r102 == r105.get()) goto L8;
    L12:
        return false;
    L8:
        if (this.f154283p == 3) goto L10;
    L11:
        return true;
    L10:
        if (super.onNestedPreFling(r100, r101, r102, r103, r104) == false) goto L12;
        goto L11
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onStartNestedScroll(CoordinatorLayout r100, V r101, View r102, View r103, int r104, int r105) {
        this.f154286s = 0;
        this.f154287t = false;
        if ((r104 & 2) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedPreScroll(CoordinatorLayout r100, V r101, View r102, int r103, int r104, int[] r105, int r106) {
        if (r106 == 1) goto L37;
        WeakReference<View> r107 = this.f154290w;
        if (r107 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        if (r102 != r107.get()) goto L38;
        if (r101 != null) goto L11;
        Intrinsics.throwNpe();
    L11:
        int r108 = r101.getTop();
        int r109 = r108 - r104;
        if (r104 > 0) goto L14;
        if (r104 < 0) goto L19;
    L28:
        dispatchOnSlide(r101.getTop());
        this.f154286s = r104;
        this.f154287t = true;
        if (b() == true) goto L31;
        return;
    L31:
        if (this.f154283p != 3) goto L40;
        if (r104 < 0) goto L34;
        return;
    L34:
        if (r105[1] != 0) goto L42;
        this.f154287t = false;
        return;
    L42:
        return;
    L40:
        return;
    L19:
        if (r102.canScrollVertically(-1) == true) goto L28;
        if (this.f154334d.disableDragDown() == true) goto L28;
        int r110 = this.f154282o;
        if (r109 > r110) goto L25;
    L27:
        r105[1] = r104;
        ViewCompat.offsetTopAndBottom(r101, -r104);
        setStateInternal(1);
        goto L28
    L25:
        if (this.f154331a == true) goto L27;
        int r111 = r108 - r110;
        r105[1] = r111;
        ViewCompat.offsetTopAndBottom(r101, -r111);
        setStateInternal(4);
        goto L28
    L14:
        if (r109 >= getExpandedOffset()) goto L16;
        int r112 = r108 - getExpandedOffset();
        r105[1] = r112;
        ViewCompat.offsetTopAndBottom(r101, -r112);
        setStateInternal(3);
        goto L28
    L16:
        r105[1] = r104;
        ViewCompat.offsetTopAndBottom(r101, -r104);
        setStateInternal(1);
        goto L28
    L38:
        return;
    }
}
