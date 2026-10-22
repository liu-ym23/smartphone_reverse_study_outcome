package com.bytedance.android.shopping.store.viewmodel;

import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.shopping.store.hybrid.StoreTabConfig;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;

/* JADX INFO: loaded from: classes14.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f187016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f187017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f187018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public StoreTabConfig f187019d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f187020e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LayoutTypes f187021f;

    public c() {
        this.f187016a = true;
        this.f187017b = true;
        this.f187018c = -1;
        ECShopABSettings.f186148k.getClass();
        this.f187020e = 1 ^ (ECShopABSettings.c() ? 1 : 0);
        this.f187021f = LayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE;
    }
}
