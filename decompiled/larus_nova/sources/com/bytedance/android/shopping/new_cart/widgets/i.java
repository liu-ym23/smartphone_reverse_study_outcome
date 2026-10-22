package com.bytedance.android.shopping.new_cart.widgets;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class i extends com.bytedance.android.shopping.card_list.components.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleOwner f179490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<Boolean> f179491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<Integer> f179492d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.shopping.card_list.widgets.nest.d f179493e;

    @Override // com.bytedance.android.shopping.card_list.components.c
    public final LifecycleOwner a() {
        return this.f179490b;
    }

    public i(LifecycleOwner r100) {
        MutableLiveData<Boolean> r101 = new MutableLiveData();
        MutableLiveData<Integer> r102 = new MutableLiveData();
        com.bytedance.android.shopping.card_list.widgets.nest.d r103 = new com.bytedance.android.shopping.card_list.widgets.nest.d(r100);
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, "show");
        Intrinsics.checkNotNullParameter(r102, "bodyLinkedScrollHeight");
        Intrinsics.checkNotNullParameter(r103, "cardListTwoRevState");
        super(r100);
        this.f179490b = r100;
        this.f179491c = r101;
        this.f179492d = r102;
        this.f179493e = r103;
    }
}
