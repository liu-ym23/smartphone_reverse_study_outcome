package com.bytedance.android.shopping.store.product.presenter.aggregate;

import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.shopping.store.aggregate.viewmodel.ShopAggregatePageProductViewModel;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class e extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f185760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<LayoutTypes> f185761c;

    @Override // sm.h
    public final LayoutTypes c() {
        return this.f185761c.invoke();
    }

    @Override // sm.h
    public final r j(Integer r100) {
        int r101 = r.f44937h;
        return r.a.c(this.f185760b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(ShopAggregatePageProductViewModel r100, String r101, Function0<? extends LayoutTypes> r102) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r101, "imageScene");
        Intrinsics.checkNotNullParameter(r102, "layoutTypeProvider");
        super(r100);
        this.f185760b = r101;
        this.f185761c = r102;
    }
}
