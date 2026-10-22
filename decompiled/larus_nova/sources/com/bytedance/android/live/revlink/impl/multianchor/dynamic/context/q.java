package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class q<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e0 f94054a;

    public q(e0 r100) {
        this.f94054a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        MutableLiveData<Boolean> r101 = this.f94054a.f93985r;
        r101.setValue((Boolean) r100);
    }
}
