package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f93477a;

    public c(boolean r100) {
        this.f93477a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        jy0.b.d("ttlive_anchor_link", "updateSetting showScore=" + this.f93477a + " success");
        com.bytedance.android.live.revlink.impl.multianchor.profit.a r102 = com.bytedance.android.live.revlink.impl.global.b.Y();
        if (r102 == null) goto L6;
        boolean r103 = this.f93477a;
        int r104 = com.bytedance.android.live.revlink.impl.multianchor.profit.a.f94618e;
        r102.n(r103, null);
        return;
    }
}
