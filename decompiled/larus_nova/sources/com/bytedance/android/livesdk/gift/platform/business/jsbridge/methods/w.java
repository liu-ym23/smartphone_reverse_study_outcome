package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class w<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f129743a;

    public w(y r100) {
        this.f129743a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        JSONObject r102 = new JSONObject();
        r102.put("code", 1);
        this.f129743a.finishWithResult(r102);
    }
}
