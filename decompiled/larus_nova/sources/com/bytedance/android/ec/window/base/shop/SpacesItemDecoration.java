package com.bytedance.android.ec.window.base.shop;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ec/window/base/shop/SpacesItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SpacesItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f49587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f49588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f49589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f49590d;

    public SpacesItemDecoration(int r100, int r101, int r102) {
        this.f49587a = r100;
        this.f49588b = 0;
        this.f49589c = r101;
        this.f49590d = r102;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        r100.top = this.f49588b;
        r100.left = this.f49587a;
        r100.right = this.f49589c;
        r100.bottom = this.f49590d;
    }
}
