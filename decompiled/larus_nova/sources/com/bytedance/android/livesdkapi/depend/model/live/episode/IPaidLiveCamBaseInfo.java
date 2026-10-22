package com.bytedance.android.livesdkapi.depend.model.live.episode;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u0018\u0010\u000b\u001a\u00020\fX¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u00020\fX¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u0018\u0010\u0014\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0005\"\u0004\b\u0016\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IPaidLiveCamBaseInfo;", "", "delivery", "", "getDelivery", "()I", "setDelivery", "(I)V", "paidLiveType", "getPaidLiveType", "setPaidLiveType", "ticketPrice", "", "getTicketPrice", "()J", "setTicketPrice", "(J)V", "ticketSessionId", "getTicketSessionId", "setTicketSessionId", "viewRight", "getViewRight", "setViewRight", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IPaidLiveCamBaseInfo {
    int getDelivery();

    int getPaidLiveType();

    long getTicketPrice();

    long getTicketSessionId();

    int getViewRight();

    void setDelivery(int r100);

    void setPaidLiveType(int r100);

    void setTicketPrice(long r100);

    void setTicketSessionId(long r100);

    void setViewRight(int r100);
}
