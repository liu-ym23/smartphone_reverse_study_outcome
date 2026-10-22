package com.bytedance.android.livesdk.gift.platform.business.dialog.topview;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f126601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f126602b;

    public h(i r100, c02.a r101) {
        this.f126601a = r100;
        this.f126602b = r101;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        S r101 = (S) r100;
        this.f126601a.f126604b.invoke(r101, this.f126602b);
    }
}
