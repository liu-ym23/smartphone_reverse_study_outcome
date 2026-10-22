package com.bytedance.android.live.revlink.impl.pk.feedview.machine;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.link.model.c3;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f96569a;

    public f(a r100) {
        this.f96569a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        c3 r102 = ((com.bytedance.android.livesdk.link.model.r) r101.data).getBattleStatsMeta();
        if (r102 == null) goto L7;
        this.f96569a.a(r102, ((com.bytedance.android.livesdk.link.model.r) r101.data).getBizExtra());
        return;
    }
}
