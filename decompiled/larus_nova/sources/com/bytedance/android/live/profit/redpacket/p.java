package com.bytedance.android.live.profit.redpacket;

import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class p<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n0 f88692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zy0.c f88693b;

    public p(n0 r100, zy0.b r101) {
        this.f88692a = r100;
        this.f88693b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        RedPacketState r101 = (RedPacketState) r100;
        String r102 = null;
        if ((r101 instanceof RedPacketState.Empty) == false) goto L12;
        JSONObject r103 = new JSONObject();
        r103.put("eventName", "RedEnvelopeEndUpdate");
        n0 r104 = this.f88692a;
        if (r104 == null) goto L7;
        String r105 = r104.f88668d;
    L8:
        r103.put("boxId", String.valueOf(r105));
        xy0.a<?> r106 = this.f88693b.g();
        if (r106 == null) goto L12;
        r106.sendJsEvent("H5_webcastNotification", r103);
        goto L12
    L7:
        r105 = null;
    L12:
        if ((r101 instanceof RedPacketState.Expired) == false) goto L20;
        JSONObject r107 = new JSONObject();
        r107.put("eventName", "RedEnvelopeTimeOutUpdate");
        n0 r108 = this.f88692a;
        if (r108 == null) goto L16;
        r102 = r108.f88668d;
    L16:
        r107.put("box_id", String.valueOf(r102));
        xy0.a<?> r109 = this.f88693b.g();
        if (r109 == null) goto L21;
        r109.sendJsEvent("H5_webcastNotification", r107);
        return;
    L21:
        return;
    }
}
