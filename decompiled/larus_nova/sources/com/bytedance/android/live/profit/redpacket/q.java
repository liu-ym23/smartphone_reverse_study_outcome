package com.bytedance.android.live.profit.redpacket;

import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class q<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zy0.c f88700a;

    public q(zy0.b r100) {
        this.f88700a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        JSONObject r101 = new JSONObject();
        r101.put("eventName", "RedEnvelopeEndUpdate");
        r101.put("boxId", ((String) r100).toString());
        xy0.a<?> r102 = this.f88700a.g();
        if (r102 == null) goto L6;
        r102.sendJsEvent("H5_webcastNotification", r101);
        return;
    }
}
