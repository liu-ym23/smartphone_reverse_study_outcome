package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f99974a;

    public h(g r100) {
        this.f99974a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f99974a.v(((Long) r100).longValue());
    }
}
