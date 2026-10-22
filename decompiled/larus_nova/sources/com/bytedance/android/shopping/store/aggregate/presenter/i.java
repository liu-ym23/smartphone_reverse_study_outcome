package com.bytedance.android.shopping.store.aggregate.presenter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.ec.store.status.LazyStatusView;
import com.bytedance.android.shopping.store.status.ECShopAggregatePageLoadingStatusView;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes14.dex */
public final class i<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShopAggregatePageProductGroupPresenter f183469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f183470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LazyStatusView f183471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f183472d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f183473e;

    public i(ShopAggregatePageProductGroupPresenter r100, ViewGroup r101, LazyStatusView r102, Context r103, Ref.ObjectRef r104) {
        this.f183469a = r100;
        this.f183470b = r101;
        this.f183471c = r102;
        this.f183472d = r103;
        this.f183473e = r104;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        LoadStatus r101 = (LoadStatus) r100;
        this.f183470b.setVisibility(0);
        if (this.f183469a.f183437g == false) goto L6;
        this.f183471c.a(new ECShopAggregatePageLoadingStatusView(this.f183472d).a());
    L6:
        if (r101 == null) goto L15;
        int r102 = e.f183466a[r101.ordinal()];
        if (r102 != 1) goto L11;
        ((View) this.f183473e.element).setVisibility(4);
        ((TextView) this.f183469a.Z().b(R.id.undertake_product_publicity).f()).setVisibility(8);
        this.f183471c.b(com.bytedance.android.ec.store.status.b.c.f48653a);
    L20:
        this.f183469a.f183437g = true;
        return;
    L11:
        if (r102 != 2) goto L13;
        this.f183470b.setVisibility(8);
        ((View) this.f183473e.element).setVisibility(0);
        Ref.ObjectRef r103 = this.f183473e;
        r103.element = (T) this.f183469a.Z().b(R.id.undertake_rv_product_list).f();
        ((TextView) this.f183469a.Z().b(R.id.undertake_product_publicity).f()).setVisibility(8);
        goto L20
    L13:
        if (r102 == 3) goto L17;
        if (r102 != 4) goto L15;
        ((TextView) this.f183469a.Z().b(R.id.undertake_product_publicity).f()).setVisibility(8);
        ((View) this.f183473e.element).setVisibility(0);
        Ref.ObjectRef r104 = this.f183473e;
        r104.element = (T) this.f183469a.Z().b(R.id.undertake_rv_product_list).f();
        ((View) this.f183473e.element).setVisibility(4);
        this.f183471c.b(com.bytedance.android.ec.store.status.b.a.f48651a);
        goto L20
    L17:
        ((TextView) this.f183469a.Z().b(R.id.undertake_product_publicity).f()).setVisibility(8);
        ((View) this.f183473e.element).setVisibility(4);
        this.f183471c.b(com.bytedance.android.ec.store.status.b.C0841b.f48652a);
    L15:
        this.f183470b.setVisibility(8);
        goto L20
    }
}
