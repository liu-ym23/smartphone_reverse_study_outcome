package com.bytedanceos.appstore.buss.network.demo;

import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.k0;
import androidx.lifecycle.l0;
import kotlinx.coroutines.h;

/* JADX INFO: loaded from: classes2.dex */
public final class DemoViewModel extends k0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DemoRepository f8802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LiveData f8803e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData f8804f;

    public DemoViewModel() {
        this.f8802d = new DemoRepository();
        this.f8803e = CoroutineLiveDataKt.c(null, 0, new DemoViewModel$data1LiveData$1(this, null), 3, null);
        this.f8804f = new MutableLiveData();
    }

    public static final /* synthetic */ DemoRepository f(DemoViewModel r10) {
        return r10.f8802d;
    }

    public static final /* synthetic */ MutableLiveData g(DemoViewModel r10) {
        return r10.f8804f;
    }

    public final void h() {
        h.d(l0.a(this), null, null, new DemoViewModel$fetchData2$1(this, null), 3, null);
    }

    public final LiveData i() {
        return this.f8804f;
    }
}
