package com.bytedance.android.window.shop.home.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u000eB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/window/shop/home/view/NestedScrollFrameLayout;", "Landroid/widget/FrameLayout;", "Landroidx/core/view/NestedScrollingChild;", "Landroidx/core/view/NestedScrollingParent;", "", "enabled", "", "setNestedScrollingEnabled", "", "getNestedScrollAxes", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NestedScrollFrameLayout extends FrameLayout implements NestedScrollingChild, NestedScrollingParent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NestedScrollingChildHelper f188999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NestedScrollingParentHelper f189000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f189001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f189002d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f189003e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f189004f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f189005g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f189006h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f189007i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public VelocityTracker f189008j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f189009k;

    public static final class a {
    }

    static {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onStartNestedScroll(View r100, View r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        if ((r102 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f189000b.getNestedScrollAxes();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean hasNestedScrollingParent() {
        return this.f188999a.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean isNestedScrollingEnabled() {
        return this.f188999a.isNestedScrollingEnabled();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final void stopNestedScroll() {
        this.f188999a.stopNestedScroll();
    }

    public NestedScrollFrameLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f188999a = new NestedScrollingChildHelper(this);
        this.f189000b = new NestedScrollingParentHelper(this);
        ViewConfiguration r101 = ViewConfiguration.get(r100);
        this.f189001c = r101.getScaledTouchSlop();
        this.f189002d = r101.getScaledMaximumFlingVelocity();
        this.f189003e = r101.getScaledMinimumFlingVelocity();
        this.f189004f = new int[2];
        this.f189005g = new int[2];
        setWillNotDraw(false);
        setNestedScrollingEnabled(true);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onStopNestedScroll(View r100) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        this.f189000b.onStopNestedScroll(r100);
        stopNestedScroll();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "ev");
        MotionEvent r100 = MotionEvent.obtain(r110);
        if (this.f189008j != null) goto L5;
        this.f189008j = VelocityTracker.obtain();
    L5:
        int r101 = r100.getActionMasked();
        int r102 = 0;
        if (r101 != 0) goto L8;
        VelocityTracker r103 = this.f189008j;
        if (r103 == null) goto L69;
        r103.addMovement(r110);
    L69:
        this.f189006h = (int) r100.getY();
        this.f189007i = r100.getPointerId(0);
        startNestedScroll(2);
    L70:
        r100.recycle();
        return true;
    L8:
        if (r101 == 1) goto L51;
        if (r101 != 2) goto L11;
        int r104 = r100.findPointerIndex(this.f189007i);
        if (r104 == (-1)) goto L70;
        int r105 = (int) r100.getY(r104);
        int r106 = this.f189006h - r105;
        if (dispatchNestedPreScroll(0, r106, this.f189004f, this.f189005g) == false) goto L33;
        r106 = r106 - this.f189004f[1];
        r100.offsetLocation(0.0f, this.f189005g[1]);
    L33:
        if (this.f189009k == false) goto L35;
    L43:
        int r111 = r106;
        if (this.f189009k == false) goto L70;
        VelocityTracker r107 = this.f189008j;
        if (r107 == null) goto L48;
        r107.addMovement(r110);
    L48:
        int[] r112 = this.f189005g;
        this.f189006h = r105 - r112[1];
        if (dispatchNestedScroll(0, 0, 0, r111, r112) == false) goto L70;
        int r113 = this.f189006h;
        int r108 = this.f189005g[1];
        this.f189006h = r113 - r108;
        r100.offsetLocation(0.0f, r108);
        goto L70
    L35:
        if (Math.abs(this.f189006h - r105) <= this.f189001c) goto L43;
        ViewParent r109 = getParent();
        if (r109 == null) goto L39;
        r109.requestDisallowInterceptTouchEvent(true);
    L39:
        this.f189009k = true;
        if (r106 <= 0) goto L42;
        r106 = r106 - ((int) this.f189001c);
        goto L43
    L42:
        r106 = r106 + ((int) this.f189001c);
        goto L43
    L11:
        if (r101 == 3) goto L51;
        if (r101 != 5) goto L15;
        int r114 = r100.getActionIndex();
        this.f189006h = (int) r100.getY(r114);
        this.f189007i = r100.getPointerId(r114);
        goto L70
    L15:
        if (r101 != 6) goto L70;
        int r115 = (r100.getAction() & 65280) >> 8;
        if (r100.getPointerId(r115) != this.f189007i) goto L24;
        if (r115 != 0) goto L21;
        r102 = 1;
    L21:
        this.f189006h = (int) r100.getY(r102);
        this.f189007i = r100.getPointerId(r102);
        VelocityTracker r116 = this.f189008j;
        if (r116 == null) goto L24;
        r116.clear();
    L24:
        this.f189006h = (int) r100.getY(r100.findPointerIndex(this.f189007i));
    L51:
        VelocityTracker r117 = this.f189008j;
        if (r117 != null) goto L55;
    L62:
        this.f189009k = false;
        VelocityTracker r118 = this.f189008j;
        if (r118 == null) goto L65;
        r118.recycle();
    L65:
        this.f189008j = null;
        stopNestedScroll();
        goto L70
    L55:
        if (this.f189009k == false) goto L61;
        r117.computeCurrentVelocity(1000, this.f189002d);
        int r119 = (int) r117.getYVelocity(this.f189007i);
        if (Math.abs(r119) <= this.f189003e) goto L61;
        float r120 = -r119;
        if (dispatchNestedPreFling(0.0f, r120) == true) goto L61;
        dispatchNestedFling(0.0f, r120, true);
    L61:
        this.f189007i = -1;
        goto L62
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r100) {
        if (r100 == false) goto L7;
        VelocityTracker r101 = this.f189008j;
        if (r101 == null) goto L6;
        r101.recycle();
    L6:
        this.f189008j = null;
    L7:
        super.requestDisallowInterceptTouchEvent(r100);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r100) {
        this.f188999a.setNestedScrollingEnabled(r100);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean startNestedScroll(int r100) {
        return this.f188999a.startNestedScroll(r100);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreFling(float r100, float r101) {
        return this.f188999a.dispatchNestedPreFling(r100, r101);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedFling(float r100, float r101, boolean r102) {
        return this.f188999a.dispatchNestedFling(r100, r101, r102);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r100, float r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        return dispatchNestedPreFling(r101, r102);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScrollAccepted(View r100, View r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        this.f189000b.onNestedScrollAccepted(r100, r101, r102);
        startNestedScroll(2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r103) {
        return this.f188999a.dispatchNestedPreScroll(r100, r101, r102, r103);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        return dispatchNestedFling(r101, r102, r103);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r103) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r103, "consumed");
        dispatchNestedPreScroll(r101, r102, r103, null);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedScroll(int r100, int r101, int r102, int r110, int[] r111) {
        return this.f188999a.dispatchNestedScroll(r100, r101, r102, r110, r111);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScroll(View r100, int r101, int r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        dispatchNestedScroll(r101, r110, r111, r112, null);
    }
}
