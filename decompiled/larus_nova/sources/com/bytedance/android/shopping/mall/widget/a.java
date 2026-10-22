package com.bytedance.android.shopping.mall.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.ss.android.lark.utils.statistics.PerfLog;
import cqa.e;
import cqa.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends FrameLayout implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f178630a;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.widget.a$a, reason: collision with other inner class name */
    public static final class C2653a {
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

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f178630a = (TextView) LayoutInflater.from(r100).inflate(R.layout.shopping_homepage_default_refresh, this, true).findViewById(R.id.double_loading_text);
    }

    public final void setNightMode(boolean r100) {
        if (r100 == false) goto L6;
        TextView r101 = this.f178630a;
        if (r101 == null) goto L10;
        r101.setTextColor(getResources().getColor(R.color.shopping_home_color_EEEEEE));
        return;
    L10:
        return;
    L6:
        TextView r102 = this.f178630a;
        if (r102 == null) goto L12;
        r102.setTextColor(getResources().getColor(R.color.shopping_home_color_161823));
        return;
    }

    @Override // cqa.f
    public final int j(SmartRefreshLayout r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "refreshLayout");
        TextView r102 = this.f178630a;
        if (r102 == null) goto L10;
        if (r101 == false) goto L6;
        String r103 = "刷新完成";
    L7:
        r102.setText(r103);
        return 10;
    L6:
        r103 = "刷新失败";
        goto L7
    L10:
        return 10;
    }

    @Override // cqa.f
    public final void f(h r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "refreshLayout");
        TextView r103 = this.f178630a;
        if (r103 == null) goto L6;
        r103.setText("加载中..");
        return;
    }

    @Override // cqa.f
    public final void b(boolean r100, float r101, int r102, int r103, int r104) {
        if (r100 == false) goto L11;
        TextView r105 = this.f178630a;
        if (r105 != null) goto L6;
        return;
    L6:
        if (r101 <= 1) goto L8;
        String r106 = "释放立即刷新";
    L9:
        r105.setText(r106);
        return;
    L8:
        r106 = "下拉可以刷新";
        goto L9
    }
}
