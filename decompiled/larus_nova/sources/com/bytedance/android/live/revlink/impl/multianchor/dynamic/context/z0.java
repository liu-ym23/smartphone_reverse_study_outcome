package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import java.util.List;

/* JADX INFO: loaded from: classes47.dex */
public final class z0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f94074a;

    public z0(MediatorLiveData r100) {
        this.f94074a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r110) {
        List r100 = (List) r110;
        this.f94074a.setValue(new f31.i(r100, null, null, null, null, null, null, 124));
    }
}
