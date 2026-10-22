package com.bytedance.android.shopping.store.home;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ec.store.widget.ECOverScrollExpandBehavior;
import com.bytedance.android.ec.store.widget.ECOverScrollExpandCoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bB\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/store/home/ECShopAppBarSnapBehavior;", "Lcom/bytedance/android/ec/store/widget/ECOverScrollExpandBehavior;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopAppBarSnapBehavior extends ECOverScrollExpandBehavior {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f183503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CoordinatorLayout f183504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f183505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f183506d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f183507e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f183508f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f183509g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f183510h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f183511i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f183512j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f183513k;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.store.widget.ECOverScrollExpandBehavior
    public final void recover() {
        super.recover();
    }

    @Override // com.bytedance.android.ec.store.widget.ECOverScrollExpandBehavior
    public final int applyAdjust(int r100) {
        return super.applyAdjust(r100);
    }

    @Override // com.bytedance.android.ec.store.widget.ECOverScrollExpandBehavior
    public final void initOnce(View r100) {
        Intrinsics.checkNotNullParameter(r100, "coordinator");
        super.initOnce(r100);
        if (this.f183504b != null) goto L14;
        View r101 = null;
        if ((r100 instanceof CoordinatorLayout) == true) goto L7;
        View r102 = null;
    L8:
        this.f183504b = (CoordinatorLayout) r102;
        View r103 = qc3.a.a(r100, AnonymousClass1.INSTANCE);
        if ((r103 instanceof AppBarLayout) == false) goto L12;
        r101 = r103;
    L12:
        AppBarLayout r104 = (AppBarLayout) r101;
        return;
    L7:
        r102 = r100;
        goto L8
    }

    public ECShopAppBarSnapBehavior(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f183503a = 16;
        com.bytedance.android.shopping.extensions.b.b(120);
        com.bytedance.android.shopping.extensions.b.b(150);
        com.bytedance.android.shopping.extensions.b.b(40);
        this.f183507e = true;
        this.f183511i = -1;
        this.f183513k = true;
    }

    @Override // com.bytedance.android.ec.store.widget.ECOverScrollExpandBehavior
    public final void adjustTarget(int r100, int r101) {
        super.adjustTarget(r100, r101);
    }

    @Override // com.bytedance.android.ec.store.widget.ControllableAppBarSnapBehavior
    public final boolean snapToBoundaryIfNeed(CoordinatorLayout r100, AppBarLayout r101) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, "abl");
        currentOffset();
        if (this.f183505c == false) goto L7;
        return true;
    L7:
        return super.snapToBoundaryIfNeed(r100, r101);
    }

    @Override // com.bytedance.android.ec.store.widget.ControllableAppBarSnapBehavior
    public final boolean onTouchEvent(CoordinatorLayout r100, AppBarLayout r101, MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r110, "ev");
        int r102 = r110.getActionMasked();
        boolean r103 = false;
        if (r102 != 1) goto L5;
    L32:
        this.f183511i = -1;
        this.f183512j = 0;
        currentOffset();
    L34:
        return super.onTouchEvent(r100, r101, r110);
    L5:
        if (r102 != 2) goto L7;
        int r104 = this.f183511i;
        if (r104 >= 0) goto L12;
        int r105 = 0;
    L13:
        this.f183511i = (int) r110.getRawY();
        this.f183512j += r105;
        int r106 = currentOffset();
        if (this.f183512j >= getTouchSlop()) goto L16;
    L22:
        if (r103 == false) goto L34;
        if ((r100 instanceof ECOverScrollExpandCoordinatorLayout) == true) goto L26;
        CoordinatorLayout r111 = null;
    L27:
        ECOverScrollExpandCoordinatorLayout r112 = (ECOverScrollExpandCoordinatorLayout) r111;
        if (r112 == null) goto L30;
        r112.setTouchStoreInfoAreaSnapToheadEnable(true);
    L30:
        snapTo(getSnapToHeadHeight(), r100, r101);
        return true;
    L26:
        r111 = r100;
        goto L27
    L16:
        if (Math.abs(r106) >= Math.abs(0)) goto L22;
        if (Math.abs(r106) < (Math.abs(0) * 0.9f)) goto L20;
    L21:
        r103 = true;
        goto L22
    L20:
        if ((Math.abs(r106) + r105) < Math.abs(0)) goto L22;
    L12:
        r105 = r104 - ((int) r110.getRawY());
        goto L13
    L7:
        if (r102 == 3) goto L32;
        goto L32
    }

    @Override // com.bytedance.android.ec.store.widget.ECOverScrollExpandBehavior, com.bytedance.android.ec.store.widget.ControllableAppBarSnapBehavior, com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
    public final void onStopNestedScroll(CoordinatorLayout r110, AppBarLayout r111, View r112, int r113) {
        Intrinsics.checkNotNullParameter(r110, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r111, "abl");
        Intrinsics.checkNotNullParameter(r112, PickerReporterConstants.KEY.TARGET);
        this.f183508f = false;
        this.f183509g = false;
        int r100 = currentOffset();
        if (this.f183506d == false) goto L15;
        if (Math.abs(r100) < (((double) Math.abs(0)) * 0.5d)) goto L7;
    L9:
        boolean r101 = false;
    L11:
        if (this.f183505c == true) goto L15;
        if (r101 == false) goto L15;
        this.f183505c = true;
        ValueAnimator r102 = ValueAnimator.ofInt(new int[]{r100, 0}).setDuration(200);
        r102.setInterpolator(new DecelerateInterpolator());
        r102.addUpdateListener(new b(this, r110, r111, r112));
        r102.addListener(new c(this, r110, r111, r112, r113));
        r102.start();
        goto L15
    L7:
        if (Math.abs(r100) <= 0) goto L9;
        r101 = true;
    L15:
        if (this.f183506d == false) goto L17;
    L18:
        Math.abs(r100);
        Math.abs(0);
    L19:
        if (r113 != 0) goto L21;
        this.f183506d = false;
        this.f183513k = false;
        this.f183510h = false;
    L21:
        super.onStopNestedScroll(r110, r111, r112, r113);
        return;
    L17:
        if (this.f183513k == false) goto L19;
        goto L18
    }

    @Override // com.bytedance.android.ec.store.widget.ECOverScrollExpandBehavior, com.bytedance.android.ec.store.widget.ControllableAppBarSnapBehavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r100, View r101, View r102, int r103) {
        onStopNestedScroll(r100, (AppBarLayout) r101, r102, r103);
    }

    @Override // com.bytedance.android.ec.store.widget.ECOverScrollExpandBehavior
    public final boolean onNestedPreFling(CoordinatorLayout r100, AppBarLayout r101, View r102, float r103, float r104) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        return super.onNestedPreFling(r100, r101, r102, r103, r104);
    }

    @Override // com.bytedance.android.ec.store.widget.ECOverScrollExpandBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final /* bridge */ /* synthetic */ boolean onNestedPreFling(CoordinatorLayout r100, View r101, View r102, float r103, float r104) {
        return onNestedPreFling(r100, (AppBarLayout) r101, r102, r103, r104);
    }

    @Override // com.bytedance.android.ec.store.widget.ECOverScrollExpandBehavior, com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
    public final void onNestedPreScroll(CoordinatorLayout r100, AppBarLayout r101, View r102, int r110, int r111, int[] r112, int r113) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r112, "consumed");
        if (r113 == 0) goto L5;
    L7:
        int r103 = currentOffset();
        boolean r104 = false;
        if (r111 > 0) goto L10;
    L13:
        Math.abs(r103);
    L14:
        if (r111 < 0) goto L16;
    L19:
        if (r111 >= 0) goto L27;
        if (r103 != 0) goto L27;
        if (r113 != 0) goto L27;
        if (this.f183509g == false) goto L27;
        if (isExpand() == true) goto L27;
        boolean r105 = true;
    L28:
        if (r111 < 0) goto L30;
    L33:
        boolean r106 = false;
    L35:
        if (this.f183505c == true) goto L39;
        if (r105 == true) goto L38;
        if (r106 == false) goto L39;
    L38:
        r112[1] = r111;
        ViewCompat.stopNestedScroll(r102, r113);
        boolean r107 = true;
    L40:
        if (r107 == false) goto L42;
        return;
    L42:
        if (r111 > 0) goto L44;
    L48:
        if (r104 == false) goto L50;
        return;
    L50:
        this.f183508f = true;
        this.f183509g = true;
        super.onNestedPreScroll(r100, r101, r102, r110, r111, r112, r113);
        return;
    L44:
        if (this.f183507e == true) goto L48;
        if ((getTopAndBottomOffset() - r111) > getSnapToHeadHeight()) goto L48;
        int r108 = r103 - getSnapToHeadHeight();
        int r109 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r111, 0), r108);
        snapTo(r103 - r109, r100, r101);
        r112[1] = r109;
        r104 = true;
    L39:
        r107 = false;
        goto L40
    L30:
        if ((r103 - r111) < 0) goto L33;
        if (r113 != 1) goto L33;
        r106 = true;
    L27:
        r105 = false;
        goto L28
    L16:
        if (Math.abs(r111) <= this.f183503a) goto L19;
        if (r113 != 0) goto L19;
        this.f183506d = true;
        goto L19
    L10:
        if (Math.abs(r103) != Math.abs(0)) goto L13;
        if (this.f183508f == true) goto L14;
    L5:
        if (this.f183510h == true) goto L7;
        this.f183510h = true;
        goto L7
    }

    @Override // com.bytedance.android.ec.store.widget.ECOverScrollExpandBehavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r100, View r101, View r102, int r103, int r104, int[] r105, int r106) {
        onNestedPreScroll(r100, (AppBarLayout) r101, r102, r103, r104, r105, r106);
    }

    @Override // com.bytedance.android.ec.store.widget.ControllableAppBarSnapBehavior, com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
    public final void onNestedScroll(CoordinatorLayout r100, AppBarLayout r101, View r102, int r103, int r104, int r105, int r106, int r110) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        if (r106 < 0) goto L5;
    L12:
        super.onNestedScroll(r100, r101, r102, r103, r104, r105, r106, r110);
        return;
    L5:
        if (canScrollVertically(r102) == true) goto L12;
        if (r110 != 1) goto L12;
        if (Math.abs(currentOffset()) > Math.abs(0)) goto L12;
        ViewCompat.stopNestedScroll(r102, r110);
    }
}
