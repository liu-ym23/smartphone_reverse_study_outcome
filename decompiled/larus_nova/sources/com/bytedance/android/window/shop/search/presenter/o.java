package com.bytedance.android.window.shop.search.presenter;

import android.content.Context;
import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class o implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f189751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WindowSearchResultTopBarPresenter f189752b;

    public o(View r100, WindowSearchResultTopBarPresenter r101) {
        this.f189751a = r100;
        this.f189752b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        int r101 = ep.a.f473412a;
        Context r102 = this.f189752b.u().c();
        String r103 = this.f189752b.F().getSearchParam().getEnterFromSecond();
        String r104 = this.f189752b.F().getSearchParam().getShopId();
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        ep.a.a(r102, r103, r104, "a1.b7881.c59185.d28713");
        this.f189752b.F().doAnyEventActionWithBtm("a1.b7881.c59185.d28713", PageFinder.via(this.f189751a), "photo_search_icon_click", MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, this.f189752b.F().getSearchParam().getEntranceInfo()), TuplesKt.to("current_page", "shop_search_page")}), new Pair[0]);
    }
}
