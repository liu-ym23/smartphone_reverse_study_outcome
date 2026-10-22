package com.bytedance.android.livesdk.chatroom.viewmodule.welfare.right;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WelfareAudienceWelfareServiceWidget f117651a;

    public c(WelfareAudienceWelfareServiceWidget r100) {
        this.f117651a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Response r101 = (Response) r100;
        DataCenter r102 = this.f117651a.dataCenter;
        if (r102 == null) goto L6;
        r102.put("data_live_welfare_donation_click_count", 0L);
        return;
    }
}
