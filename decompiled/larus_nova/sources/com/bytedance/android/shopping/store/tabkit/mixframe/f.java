package com.bytedance.android.shopping.store.tabkit.mixframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.widget.LoadMoreStatusView;
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.ss.android.lark.utils.statistics.PerfLog;
import cqa.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f extends FrameLayout implements cqa.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LoadMoreStatusView f186790a;

    public static final class a {
    }

    static {
    }

    @Override // cqa.f
    public final boolean a() {
        return false;
    }

    @Override // cqa.f
    public final void d(float r100, int r101, int r102) {
    }

    @Override // gqa.e
    public final void e(h r100, RefreshState r101, RefreshState r102) {
        Intrinsics.checkNotNullParameter(r100, "refreshLayout");
        Intrinsics.checkNotNullParameter(r101, "oldState");
        Intrinsics.checkNotNullParameter(r102, "newState");
    }

    @Override // cqa.f
    public final void g(SmartRefreshLayout.j r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "kernel");
    }

    @Override // cqa.f
    public View getView() {
        return this;
    }

    @Override // cqa.f
    public final void i(h r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "refreshLayout");
    }

    @Override // cqa.f
    public void setPrimaryColors(int... r100) {
        Intrinsics.checkNotNullParameter(r100, "colors");
    }

    @Override // cqa.f
    public dqa.b getSpinnerStyle() {
        return dqa.b.f469717d;
    }

    public f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        LoadMoreStatusView r101 = (LoadMoreStatusView) LayoutInflater.from(r100).inflate(R.layout.ec_shop_tabkit_layout_refresh_header, this, true).findViewById(R.id.double_loading_view);
        this.f186790a = r101;
        if (r101 == null) goto L6;
        r101.setVisibility(0);
        return;
    }

    @Override // cqa.f
    public final int j(SmartRefreshLayout r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "refreshLayout");
        LoadMoreStatusView r102 = this.f186790a;
        if (r102 == null) goto L7;
        r102.b();
        return 10;
    L7:
        return 10;
    }

    @Override // cqa.f
    public final void f(h r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "refreshLayout");
        LoadMoreStatusView r103 = this.f186790a;
        if (r103 == null) goto L6;
        r103.a();
        return;
    }

    @Override // cqa.f
    public final void b(boolean r100, float r101, int r102, int r103, int r104) {
        LoadMoreStatusView r105 = this.f186790a;
        if (r105 == null) goto L6;
        r105.a();
        return;
    }
}
