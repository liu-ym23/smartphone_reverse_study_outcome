package com.bytedance.android.live.liveinteract.plantform.utils;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class k0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m0 f77493a;

    public k0(m0 r100) {
        this.f77493a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        if (this.f77493a.a() == false) goto L8;
        m0 r102 = this.f77493a;
        r102.f77499b = 100;
        hg6.g r103 = r102.f77505h;
        if (r103 == null) goto L9;
        r103.d(100);
        return;
    L9:
        return;
    }
}
