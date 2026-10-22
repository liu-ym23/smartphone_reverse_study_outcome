package com.bytedance.android.livesdk.chatroom.viewmodule.welfare;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.network.response.Response;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WelfareAnchorServiceWidget f117632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ gm3.a f117633b;

    public o(WelfareAnchorServiceWidget r100, gm3.a r101) {
        this.f117632a = r100;
        this.f117633b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((Response) r100).statusCode != 0) goto L5;
        WelfareAnchorServiceWidget r101 = this.f117632a;
        r101.f117583d = this.f117633b.f481659a;
        WelfareAnchorServiceWidget.xq(r101);
        return;
    L5:
        f2.b(R.string.ttlive_network_error, 0);
    }
}
