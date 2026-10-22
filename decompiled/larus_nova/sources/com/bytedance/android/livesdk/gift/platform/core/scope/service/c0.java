package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class c0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f131483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f131484b;

    public c0(d0 r100, String r101) {
        this.f131483a = r100;
        this.f131484b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        String r102 = this.f131484b;
        if (r102 == null) goto L5;
        ((zz0.g) com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class)).S2(com.bytedance.android.live.core.utils.s1.getContext(), r102);
    L5:
        this.f131483a.c();
    }
}
