package com.bytedance.android.live.revlink.link.biz.component;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f98062a;

    public o(p r100) {
        this.f98062a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f98062a.getContext().m6().setValue(com.bytedance.android.live.revlink.link.core.layoutstatus.l.f98305c);
    }
}
