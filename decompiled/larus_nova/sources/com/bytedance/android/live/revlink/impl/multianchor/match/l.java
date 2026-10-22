package com.bytedance.android.live.revlink.impl.multianchor.match;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f94425a;

    public l(int r100) {
        this.f94425a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        jy0.b.c("ttlive_anchor_link_match", "cancelMatch " + this.f94425a + " failed " + ((Throwable) r100), null, 4);
    }
}
