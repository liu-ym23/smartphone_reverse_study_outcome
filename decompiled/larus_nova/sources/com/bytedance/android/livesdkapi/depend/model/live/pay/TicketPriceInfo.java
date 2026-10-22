package com.bytedance.android.livesdkapi.depend.model.live.pay;

import am3.g;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.api.room.PriceInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR&\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/TicketPriceInfo;", "", "()V", "amount", "", "getAmount", "()Ljava/lang/String;", "setAmount", "(Ljava/lang/String;)V", "currency", "getCurrency", "setCurrency", "fullPrice", "getFullPrice", "setFullPrice", "payTypeList", "", "", "getPayTypeList", "()Ljava/util/List;", "setPayTypeList", "(Ljava/util/List;)V", "unitPosition", "", "getUnitPosition", "()J", "setUnitPosition", "(J)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TicketPriceInfo implements h {

    @SerializedName("amount")
    protected String amount;

    @SerializedName("currency")
    protected String currency;

    @SerializedName("full_price")
    protected String fullPrice;

    @SerializedName("pay_type")
    protected List<Integer> payTypeList;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION)
    protected long unitPosition;

    public TicketPriceInfo() {
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getFullPrice() {
        return this.fullPrice;
    }

    public final List<Integer> getPayTypeList() {
        return this.payTypeList;
    }

    public final long getUnitPosition() {
        return this.unitPosition;
    }

    public TicketPriceInfo(g r100) {
        this.payTypeList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.amount = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.currency = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.unitPosition = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.payTypeList.add(Integer.valueOf(r100.i()));
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.fullPrice = am3.h.c(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }

    public final void setAmount(String r100) {
        this.amount = r100;
    }

    public final void setCurrency(String r100) {
        this.currency = r100;
    }

    public final void setFullPrice(String r100) {
        this.fullPrice = r100;
    }

    public final void setPayTypeList(List<Integer> r100) {
        this.payTypeList = r100;
    }

    public final void setUnitPosition(long r100) {
        this.unitPosition = r100;
    }
}
