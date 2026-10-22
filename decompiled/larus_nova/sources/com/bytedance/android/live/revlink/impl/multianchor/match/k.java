package com.bytedance.android.live.revlink.impl.multianchor.match;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f94424a;

    public k(int r100) {
        this.f94424a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        jy0.b.c("ttlive_anchor_link_match", "cancelMatch " + this.f94424a + " success", null, 4);
    }
}
