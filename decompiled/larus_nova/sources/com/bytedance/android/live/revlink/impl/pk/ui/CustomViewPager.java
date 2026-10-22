package com.bytedance.android.live.revlink.impl.pk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.viewpager.widget.ViewPager;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fB\u001b\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000e\u0010\u0012J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002R$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/ui/CustomViewPager;", "Landroidx/viewpager/widget/ViewPager;", "Landroidx/core/view/NestedScrollingParent2;", "Landroidx/core/view/NestedScrollingParentHelper;", "getScrollingChildHelper", "Lcom/bytedance/android/live/revlink/impl/pk/ui/i;", "scrollListener", "Lcom/bytedance/android/live/revlink/impl/pk/ui/i;", "getScrollListener", "()Lcom/bytedance/android/live/revlink/impl/pk/ui/i;", "setScrollListener", "(Lcom/bytedance/android/live/revlink/impl/pk/ui/i;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CustomViewPager extends ViewPager implements NestedScrollingParent2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NestedScrollingParentHelper f96883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f96884b;

    public final i getScrollListener() {
        return null;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r103, "consumed");
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r100, int r101, int r102, int r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        if ((r102 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void setScrollListener(i r100) {
    }

    private final NestedScrollingParentHelper getScrollingChildHelper() {
        if (this.f96883a != null) goto L6;
        this.f96883a = new NestedScrollingParentHelper(this);
    L6:
        return this.f96883a;
    }

    public CustomViewPager(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f96884b = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f96884b == true) goto L5;
        return false;
    L5:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f96884b == true) goto L5;
        return false;
    L5:
        return super.onTouchEvent(r100);
    }

    public CustomViewPager(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f96884b = true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        NestedScrollingParentHelper r102 = getScrollingChildHelper();
        if (r102 == null) goto L6;
        r102.onStopNestedScroll(r100, r101);
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        NestedScrollingParentHelper r104 = getScrollingChildHelper();
        if (r104 == null) goto L6;
        r104.onNestedScrollAccepted(r100, r101, r102, r103);
        return;
    }
}
