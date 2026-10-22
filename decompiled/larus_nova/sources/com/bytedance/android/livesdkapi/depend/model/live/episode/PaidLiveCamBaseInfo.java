package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdkapi.paid.PaidReplayConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR+\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR+\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R+\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R+\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR+\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\t¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/PaidLiveCamBaseInfo;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IPaidLiveCamBaseInfo;", "", "<set-?>", "paidLiveType$delegate", "Ljava/lang/Object;", "getPaidLiveType", "()I", "setPaidLiveType", "(I)V", "paidLiveType", "", "ticketSessionId$delegate", "getTicketSessionId", "()J", "setTicketSessionId", "(J)V", "ticketSessionId", "ticketPrice$delegate", "getTicketPrice", "setTicketPrice", "ticketPrice", "viewRight$delegate", "getViewRight", "setViewRight", "viewRight", "delivery$delegate", "getDelivery", "setDelivery", "delivery", "<init>", "()V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PaidLiveCamBaseInfo implements IPaidLiveCamBaseInfo, h {

    @SerializedName("delivery")
    protected int _$$delivery;

    @SerializedName(PaidReplayConstants.KEY_PRIVILEGE_TYPE)
    protected int _$$paidLiveType;

    @SerializedName("ticket_price")
    protected long _$$ticketPrice;

    @SerializedName("ticket_session_id")
    protected long _$$ticketSessionId;

    @SerializedName("view_right")
    protected int _$$viewRight;

    public PaidLiveCamBaseInfo() {
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IPaidLiveCamBaseInfo
    public final int getDelivery() {
        return this._$$delivery;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IPaidLiveCamBaseInfo
    public final int getPaidLiveType() {
        return this._$$paidLiveType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IPaidLiveCamBaseInfo
    public final long getTicketPrice() {
        return this._$$ticketPrice;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IPaidLiveCamBaseInfo
    public final long getTicketSessionId() {
        return this._$$ticketSessionId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IPaidLiveCamBaseInfo
    public final int getViewRight() {
        return this._$$viewRight;
    }

    public PaidLiveCamBaseInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this._$$paidLiveType = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$ticketSessionId = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$ticketPrice = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this._$$viewRight = r100.i();
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this._$$delivery = r100.i();
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IPaidLiveCamBaseInfo
    public final void setDelivery(int r100) {
        this._$$delivery = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IPaidLiveCamBaseInfo
    public final void setPaidLiveType(int r100) {
        this._$$paidLiveType = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IPaidLiveCamBaseInfo
    public final void setTicketPrice(long r100) {
        this._$$ticketPrice = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IPaidLiveCamBaseInfo
    public final void setTicketSessionId(long r100) {
        this._$$ticketSessionId = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IPaidLiveCamBaseInfo
    public final void setViewRight(int r100) {
        this._$$viewRight = r100;
    }
}
