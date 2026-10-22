package com.bytedance.android.live.revlink.impl.pk.dialog.presenter;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPKSearchContract$View;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f96008a;

    public h(j r100) {
        this.f96008a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        InteractDialogPKSearchContract$View r102 = (InteractDialogPKSearchContract$View) this.f96008a.f92392c;
        if (r102 == null) goto L7;
        r102.ca0((IRivalRankRecommendResponse) r101.data);
        return;
    }
}
