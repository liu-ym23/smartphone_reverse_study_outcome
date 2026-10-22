package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.homepage.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import com.android.ttcjpaysdk.base.ktextension.CJPayKotlinExtensionsKt;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0018\u001a\u00020\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0014J(\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J0\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\bH\u0016J0\u0010 \u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\bH\u0016J8\u0010 \u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bH\u0016J@\u0010 \u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\bH\u0016J(\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bH\u0016J \u0010(\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\bH\u0016J(\u0010(\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bH\u0016J\u0010\u0010*\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010*\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\bH\u0016J\u000e\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\rR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/view/CJUnifyPayNestedScrollContainer;", "Landroid/widget/FrameLayout;", "Landroidx/core/view/NestedScrollingParent3;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "consumed", "", "enableCollapse", "", "maxTopRecHeight", "minTopRecHeight", "parentHelper", "Landroidx/core/view/NestedScrollingParentHelper;", "preScrollDirection", "topPayXRecView", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/view/CJUnifyPayXRecTopView;", "attachTopPayXRecView", "", "collapseTopRecToMin", "expandTopRecToMax", "onDetachedFromWindow", "onNestedPreScroll", PickerReporterConstants.KEY.TARGET, "Landroid/view/View;", "dx", "dy", "type", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScrollAccepted", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "axes", "onStartNestedScroll", "nestedScrollAxes", "onStopNestedScroll", "setEnableCollapse", "enable", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyPayNestedScrollContainer extends FrameLayout implements NestedScrollingParent3 {
    private final int[] consumed;
    private boolean enableCollapse;
    private final int maxTopRecHeight;
    private final int minTopRecHeight;
    private final NestedScrollingParentHelper parentHelper;
    private int preScrollDirection;
    private CJUnifyPayXRecTopView topPayXRecView;

    public CJUnifyPayNestedScrollContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public CJUnifyPayNestedScrollContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    public final void collapseTopRecToMin() {
        if (this.enableCollapse == true) goto L5;
        return;
    L5:
        CJUnifyPayXRecTopView r100 = this.topPayXRecView;
        if (r100 != null) goto L8;
        return;
    L8:
        int r101 = this.minTopRecHeight;
        int r102 = r100.getHeight();
        if (r102 <= 0) goto L13;
        if (r102 <= r101) goto L14;
        r100.setMaxHeight(r101);
        return;
    L14:
        return;
    }

    public final void expandTopRecToMax() {
        if (this.enableCollapse == true) goto L5;
        return;
    L5:
        CJUnifyPayXRecTopView r100 = this.topPayXRecView;
        if (r100 != null) goto L9;
        return;
    L9:
        if (CJPayKotlinExtensionsKt.isVisible(r100) == true) goto L11;
        return;
    L11:
        r100.setMaxHeight(this.maxTopRecHeight);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.topPayXRecView = null;
    }

    public final void attachTopPayXRecView(CJUnifyPayXRecTopView r100) {
        Intrinsics.checkNotNullParameter(r100, "topPayXRecView");
        this.topPayXRecView = r100;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View r100) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        onStopNestedScroll(r100, 0);
    }

    public final void setEnableCollapse(boolean r100) {
        this.enableCollapse = r100;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        this.parentHelper.onStopNestedScroll(r100, r101);
        this.preScrollDirection = 0;
    }

    public CJUnifyPayNestedScrollContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.parentHelper = new NestedScrollingParentHelper(this);
        CJUnifyPayXRecTopView.Companion r103 = CJUnifyPayXRecTopView.Companion;
        this.minTopRecHeight = r103.getTopRecMinHeightExpand();
        this.maxTopRecHeight = r103.getTopRecMaxHeightExpand();
        this.consumed = new int[2];
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View r100, View r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        onNestedScrollAccepted(r100, r101, r102, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View r100, View r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        return onStartNestedScroll(r100, r101, r102, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View r100, int r101, int r110, int[] r111) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r111, "consumed");
        onNestedPreScroll(r100, r101, r110, r111, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        this.parentHelper.onNestedScrollAccepted(r100, r101, r102, r103);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        if (this.enableCollapse == true) goto L5;
        return false;
    L5:
        if ((r102 & 2) == 0) goto L16;
        CJUnifyPayXRecTopView r104 = this.topPayXRecView;
        if (r104 != null) goto L9;
    L11:
        boolean r105 = false;
    L12:
        if (r105 == false) goto L17;
        return true;
    L17:
        return false;
    L9:
        if (r104.getVisibility() != 0) goto L11;
        r105 = true;
        goto L12
    L16:
        return false;
    }

    public /* synthetic */ CJUnifyPayNestedScrollContainer(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View r100, int r101, int r102, int[] r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r103, "consumed");
        CJUnifyPayXRecTopView r105 = this.topPayXRecView;
        if (r105 != null) goto L6;
        return;
    L6:
        if (this.enableCollapse == true) goto L8;
        return;
    L8:
        if (CJPayKotlinExtensionsKt.isVisible(r105) == true) goto L11;
        return;
    L11:
        if (r102 <= 0) goto L13;
        int r106 = 1;
    L14:
        int r107 = this.preScrollDirection;
        if (r107 != 0) goto L17;
        this.preScrollDirection = r106;
    L20:
        if (r102 > 0) goto L22;
        return;
    L22:
        int r108 = r105.getHeight();
        int r109 = this.minTopRecHeight;
        if (r108 <= 0) goto L28;
        if (r108 <= r109) goto L29;
        int r110 = Math.min(r102, r108 - r109);
        r105.setMaxHeight(r108 - r110);
        r103[1] = r110;
        return;
    L29:
        return;
    L28:
        return;
    L17:
        if (r107 == r106) goto L20;
        this.preScrollDirection = r106;
        r103[1] = r102;
        return;
    L13:
        r106 = -1;
        goto L14
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View r100, int r110, int r111, int r112, int r113) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        ArraysKt.fill$default(this.consumed, 0, 0, 0, 6, null);
        onNestedScroll(r100, r110, r111, r112, r113, 0, this.consumed);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View r100, int r110, int r111, int r112, int r113, int r114) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        ArraysKt.fill$default(this.consumed, 0, 0, 0, 6, null);
        onNestedScroll(r100, r110, r111, r112, r113, r114, this.consumed);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View r100, int r101, int r102, int r103, int r104, int r105, int[] r106) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r106, "consumed");
        CJUnifyPayXRecTopView r107 = this.topPayXRecView;
        if (r107 != null) goto L6;
        return;
    L6:
        if (this.enableCollapse == false) goto L20;
        if (r104 < 0) goto L9;
        return;
    L9:
        if (CJPayKotlinExtensionsKt.isVisible(r107) == false) goto L24;
        int r108 = r107.getHeight();
        Integer r109 = r107.getContentHeight();
        if (r109 == null) goto L14;
        int r110 = r109.intValue();
    L15:
        int r111 = Math.min(r110, this.maxTopRecHeight);
        if (r108 <= 0) goto L22;
        if (r108 >= r111) goto L23;
        int r112 = -r104;
        int r113 = Math.min(r112, r111 - r108);
        r107.setMaxHeight(r108 + r113);
        r106[1] = -r113;
        return;
    L23:
        return;
    L22:
        return;
    L14:
        r110 = this.maxTopRecHeight;
        goto L15
    L24:
        return;
    }
}
