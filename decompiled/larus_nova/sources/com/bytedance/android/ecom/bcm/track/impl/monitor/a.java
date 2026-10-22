package com.bytedance.android.ecom.bcm.track.impl.monitor;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.bytedance.android.btm.api.model.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<String> f51108a;

    public a() {
        this.f51108a = CollectionsKt.arrayListOf(new String[]{"show_product_params_detail", "confirm_product_params", "click_add_to_cart", "confirm_add_to_cart", "show_add_to_cart"});
    }

    @Override // com.bytedance.android.btm.api.model.i
    public final com.bytedance.android.btm.api.model.g a(com.bytedance.android.btm.api.model.h r100) {
        return e.a(r100);
    }

    @Override // com.bytedance.android.btm.api.model.i
    public final boolean b(com.bytedance.android.btm.api.model.h r100) {
        return this.f51108a.contains(r100.f42055a);
    }
}
