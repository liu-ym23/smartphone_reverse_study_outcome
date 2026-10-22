package com.bytedance.android.livesdk.livecommerce.promotionlist.viewholder;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.widget.LoadMoreStatusView;
import com.bytedance.android.livesdk.livecommerce.base.paging.PageListLoadStatus;
import com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes10.dex */
public final class LivePromotionListHeaderLoadMoreItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f151268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f151269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LoadMoreStatusView f151270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f151271d;

    public LivePromotionListHeaderLoadMoreItem(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r101 = th.a.c(r100.getContext(), R.layout.shopping_layout_promotion_list_header_item, r100, false);
        this.f151268a = r101;
        this.f151270c = (LoadMoreStatusView) r101.findViewById(R.id.sv_header_loading);
        this.f151271d = r101.findViewById(R.id.tv_header_load_error);
    }

    public final void b(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.m r100) {
        PageListLoadStatus r101 = r100.f151323a;
        int r102 = e.f151280a[r101.ordinal()];
        if (r102 != 1) goto L5;
        this.f151268a.setVisibility(0);
        this.f151270c.a();
        this.f151271d.setVisibility(8);
        return;
    L5:
        if (r102 != 2) goto L11;
        this.f151268a.setVisibility(0);
        this.f151270c.b();
        this.f151271d.setVisibility(0);
        return;
    }

    public final void a(LifecycleOwner r100, PageListLoadStatus r101, LivePromotionListViewModel r102) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "vm");
        if (this.f151269b == true) goto L5;
        this.f151269b = true;
        com.bytedance.android.ec.core.arch.event.c.c(r102, r100, Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.m.class), new LivePromotionListHeaderLoadMoreItem$bindData$1(this));
    L5:
        if (r101 == null) goto L8;
        b(new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.m(r101));
        return;
    }
}
