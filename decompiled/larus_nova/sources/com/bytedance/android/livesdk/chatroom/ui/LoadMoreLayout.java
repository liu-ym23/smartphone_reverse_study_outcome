package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0017B\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010B\u001b\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u000f\u0010\u0013B#\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u000f\u0010\u0016J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/LoadMoreLayout;", "Landroid/widget/LinearLayout;", "Landroidx/core/view/NestedScrollingParent2;", "Landroid/view/View;", "footView", "", "setFootView", "Lcom/bytedance/android/livesdk/chatroom/ui/LoadMoreLayout$a;", "loadMoreCallback", "setLoadMoreCallback", "", "enableLoadMore", "setEnableLoadMore", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LoadMoreLayout extends LinearLayout implements NestedScrollingParent2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NestedScrollingParentHelper f112400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f112401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f112402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f112403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f112404e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f112405f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f112406g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f112407h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f112408i;

    public interface a {
        void a();

        void b();

        void c();

        void onLoading();
    }

    public LoadMoreLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setEnableLoadMore(boolean r100) {
        this.f112406g = r100;
    }

    public final void setFootView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "footView");
        this.f112402c = r100;
    }

    public final void setLoadMoreCallback(a r100) {
        Intrinsics.checkNotNullParameter(r100, "loadMoreCallback");
        this.f112401b = r100;
    }

    public LoadMoreLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public final void a(int r100, int r101) {
        if (this.f112408i == true) goto L8;
        a r102 = this.f112401b;
        if (r102 == null) goto L7;
        r102.b();
    L7:
        this.f112408i = true;
    L8:
        View r103 = this.f112402c;
        if (r103 != null) goto L11;
        return;
    L11:
        if (this.f112404e == false) goto L20;
        if ((getScrollY() + r101) < r103.getMeasuredHeight()) goto L16;
        return;
    L16:
        if ((getScrollY() + r101) > 0) goto L18;
        r101 = -getScrollY();
    L18:
        this.f112405f = false;
        scrollBy(0, r101);
        invalidate();
        return;
    L20:
        if ((getScrollY() + r101) < r103.getMeasuredHeight()) goto L28;
        r101 = r103.getMeasuredHeight() - getScrollY();
        if (this.f112405f == true) goto L26;
        a r104 = this.f112401b;
        if (r104 == null) goto L26;
        r104.c();
    L26:
        this.f112405f = true;
    L30:
        scrollBy(0, r101);
        invalidate();
        return;
    L28:
        if ((getScrollY() + r101) >= 0) goto L30;
        r101 = -getScrollY();
        goto L30
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        boolean r102 = this.f112405f;
        this.f112404e = r102;
        if (r102 == true) goto L5;
    L13:
        this.f112404e = false;
        if (getScrollY() > 0) goto L16;
    L18:
        a r103 = this.f112401b;
        if (r103 == null) goto L21;
        r103.a();
    L21:
        this.f112408i = false;
        NestedScrollingParentHelper r104 = this.f112400a;
        if (r104 == null) goto L24;
        r104.onStopNestedScroll(r100);
    L24:
        stopNestedScroll();
        return;
    L16:
        if (this.f112404e == true) goto L18;
        a(0, -getScrollY());
        goto L18
    L5:
        if (this.f112407h == true) goto L13;
        int r105 = getScrollY();
        View r106 = this.f112402c;
        if (r106 == null) goto L13;
        if (r105 != r106.getMeasuredHeight()) goto L13;
        this.f112407h = true;
        a r107 = this.f112401b;
        if (r107 == null) goto L21;
        r107.onLoading();
        goto L21
    }

    public LoadMoreLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f112403d = new int[2];
        this.f112406g = true;
        this.f112400a = new NestedScrollingParentHelper(this);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        NestedScrollingParentHelper r104 = this.f112400a;
        if (r104 == null) goto L6;
        r104.onNestedScrollAccepted(r100, r101, r102, r103);
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        if (this.f112406g == false) goto L6;
        if (r103 != 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r103, "consumed");
        if (r102 < 0) goto L5;
    L7:
        dispatchNestedPreScroll(r101, r102, r103, this.f112403d);
        return;
    L5:
        if (getScrollY() <= 0) goto L7;
        a(r101, r102);
        r103[1] = r102;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r100, int r101, int r102, int r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        if (r102 != 0) goto L6;
        if (r111 <= 0) goto L6;
        a(r110, r111);
        return;
    L6:
        dispatchNestedScroll(r101, r102, r110, r111, this.f112403d);
    }
}
