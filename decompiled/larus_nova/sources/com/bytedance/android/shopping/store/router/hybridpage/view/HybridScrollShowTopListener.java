package com.bytedance.android.shopping.store.router.hybridpage.view;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/router/hybridpage/view/HybridScrollShowTopListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class HybridScrollShowTopListener extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f185963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Integer, Unit> f185964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Boolean, Unit> f185965c;

    public final void j(int r100) {
        int r101 = this.f185963a;
        if (r101 > 0) goto L5;
        return;
    L5:
        if (r100 < r101) goto L7;
        boolean r102 = true;
    L8:
        this.f185965c.invoke(Boolean.valueOf(r102));
        return;
    L7:
        r102 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HybridScrollShowTopListener(Function1<? super Integer, Unit> r100, Function1<? super Boolean, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "onStateChanged");
        Intrinsics.checkNotNullParameter(r101, "onUpdated");
        this.f185964b = r100;
        this.f185965c = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onScrollStateChanged(r100, r101);
        this.f185964b.invoke(Integer.valueOf(r101));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        RecyclerView.LayoutManager r103 = r100.getLayoutManager();
        RecyclerView.LayoutManager r104 = null;
        if ((r103 instanceof LinearLayoutManager) == true) goto L5;
        r103 = null;
    L5:
        LinearLayoutManager r105 = (LinearLayoutManager) r103;
        int r106 = 0;
        if (r105 == null) goto L8;
        int r107 = r105.findLastVisibleItemPosition();
    L9:
        RecyclerView.LayoutManager r108 = r100.getLayoutManager();
        if ((r108 instanceof LinearLayoutManager) == false) goto L13;
        r104 = r108;
    L13:
        LinearLayoutManager r109 = (LinearLayoutManager) r104;
        if (r109 == null) goto L17;
        r106 = r109.findFirstCompletelyVisibleItemPosition();
    L17:
        if (this.f185963a > 0) goto L22;
        int r110 = (r107 - r106) + 1;
        if (r110 <= 1) goto L22;
        this.f185963a = r110;
    L22:
        j(r106);
        return;
    L8:
        r107 = 0;
        goto L9
    }
}
