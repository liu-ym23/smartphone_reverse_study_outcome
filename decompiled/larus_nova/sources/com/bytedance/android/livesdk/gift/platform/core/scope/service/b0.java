package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class b0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f131466a;

    public b0(d0 r100) {
        this.f131466a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        String r102 = this.f131466a.f131494a;
        if (r102 == null) goto L5;
        ((zz0.g) com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class)).S2(com.bytedance.android.live.core.utils.s1.getContext(), r102);
    L5:
        this.f131466a.a();
    }
}
