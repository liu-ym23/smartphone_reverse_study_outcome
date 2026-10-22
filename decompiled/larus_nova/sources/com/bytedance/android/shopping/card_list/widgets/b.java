package com.bytedance.android.shopping.card_list.widgets;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.shopping.card_list.components.c;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleOwner f171945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<Unit> f171946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<Boolean> f171947d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<Unit> f171948e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<Unit> f171949f;

    @Override // com.bytedance.android.shopping.card_list.components.c
    public final LifecycleOwner a() {
        return this.f171945b;
    }

    public b(LifecycleOwner r100) {
        MutableLiveData<Unit> r101 = new MutableLiveData();
        MutableLiveData<Boolean> r102 = new MutableLiveData(Boolean.TRUE);
        MutableLiveData<Unit> r103 = new MutableLiveData();
        MutableLiveData<Unit> r104 = new MutableLiveData();
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, "initOrReload");
        Intrinsics.checkNotNullParameter(r102, "liveVisibility");
        Intrinsics.checkNotNullParameter(r103, "liveReleaseEvent");
        Intrinsics.checkNotNullParameter(r104, "onHasMore");
        super(r100);
        this.f171945b = r100;
        this.f171946c = r101;
        this.f171947d = r102;
        this.f171948e = r103;
        this.f171949f = r104;
    }
}
