package com.bytedance.android.live.revlink.impl.multianchor.feed.bridge;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f94161a;

    public d(c r100) {
        this.f94161a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        Long r102 = this.f94161a.f94141j.getValue();
        if (r102 == null) goto L5;
        long r103 = r102.longValue();
    L6:
        this.f94161a.f94147p.setValue(String.valueOf(r103 + 1));
        return;
    L5:
        r103 = 0;
        goto L6
    }
}
