package com.bytedance.android.shopping.card_list.widgets.nest;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends com.bytedance.android.shopping.card_list.components.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleOwner f172006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<Boolean> f172007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f172008d;

    public a() {
        throw null;
    }

    @Override // com.bytedance.android.shopping.card_list.components.c
    public final LifecycleOwner a() {
        return this.f172006b;
    }

    public a(LifecycleOwner r100) {
        MutableLiveData<Boolean> r101 = new MutableLiveData(Boolean.FALSE);
        d r102 = new d(r100);
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, "cancelRefresh");
        Intrinsics.checkNotNullParameter(r102, "cardListTwoRevState");
        super(r100);
        this.f172006b = r100;
        this.f172007c = r101;
        this.f172008d = r102;
    }
}
