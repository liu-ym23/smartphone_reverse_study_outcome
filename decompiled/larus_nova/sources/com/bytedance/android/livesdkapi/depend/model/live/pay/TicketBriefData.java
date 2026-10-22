package com.bytedance.android.livesdkapi.depend.model.live.pay;

import am3.g;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.api.room.TicketBriefInfoResponse.TicketBriefData")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/TicketBriefData;", "", "()V", "jumpType", "", "getJumpType", "()I", "setJumpType", "(I)V", "price", "", "getPrice", "()Ljava/lang/String;", "setPrice", "(Ljava/lang/String;)V", "ticketPriceInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/TicketPriceInfo;", "getTicketPriceInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/pay/TicketPriceInfo;", "setTicketPriceInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/pay/TicketPriceInfo;)V", "title", "getTitle", d.f25925o, "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TicketBriefData implements h {

    @SerializedName("pay_ab_type")
    protected int jumpType;

    @SerializedName("price")
    protected String price;

    @SerializedName(a.KEY_PRICE_INFO)
    protected TicketPriceInfo ticketPriceInfo;

    @SerializedName("title")
    protected String title;

    public TicketBriefData() {
    }

    public final int getJumpType() {
        return this.jumpType;
    }

    public final String getPrice() {
        return this.price;
    }

    public final TicketPriceInfo getTicketPriceInfo() {
        return this.ticketPriceInfo;
    }

    public final String getTitle() {
        return this.title;
    }

    public TicketBriefData(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.title = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 4) goto L10;
        this.price = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 10) goto L12;
        this.ticketPriceInfo = new TicketPriceInfo(r100);
        goto L3
    L12:
        if (r102 != 13) goto L13;
        this.jumpType = r100.i();
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }

    public final void setJumpType(int r100) {
        this.jumpType = r100;
    }

    public final void setPrice(String r100) {
        this.price = r100;
    }

    public final void setTicketPriceInfo(TicketPriceInfo r100) {
        this.ticketPriceInfo = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
