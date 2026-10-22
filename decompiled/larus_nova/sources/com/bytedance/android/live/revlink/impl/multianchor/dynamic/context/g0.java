package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class g0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k0 f93997a;

    public g0(k0 r100) {
        this.f93997a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        this.f93997a.f94011e.setValue(r101);
        this.f93997a.f94027u.setValue(k0.l(r101.booleanValue()));
    }
}
