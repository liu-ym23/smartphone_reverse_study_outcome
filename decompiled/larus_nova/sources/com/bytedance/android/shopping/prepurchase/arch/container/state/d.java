package com.bytedance.android.shopping.prepurchase.arch.container.state;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/* JADX INFO: loaded from: classes13.dex */
public final class d<T> extends ObservableData<T> {
    public d() {
        super(new MutableLiveData());
    }

    public d(T r100) {
        super(new MutableLiveData(r100));
    }

    public final void g(T r100) {
        LiveData<T> r101 = this.f180828c;
        if (r101 == null) goto L7;
        ((MutableLiveData) r101).setValue(r100);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<T>");
    }
}
