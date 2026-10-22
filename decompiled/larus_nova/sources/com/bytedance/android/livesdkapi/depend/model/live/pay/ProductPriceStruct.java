package com.bytedance.android.livesdkapi.depend.model.live.pay;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/ProductPriceStruct;", "Ljava/io/Serializable;", "()V", "amount", "", "countdownTimestamp", "", "currency", "fullPrice", "payType", "", "", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductPriceStruct implements Serializable, h {

    @SerializedName("amount")
    public String amount;

    @SerializedName("countdown_timestamp")
    public long countdownTimestamp;

    @SerializedName("currency")
    public String currency;

    @SerializedName("full_price")
    public String fullPrice;

    @SerializedName("pay_type")
    public List<Integer> payType;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION)
    public long pos;

    public ProductPriceStruct() {
    }

    public ProductPriceStruct(g r100) {
        this.payType = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        switch(r102) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.countdownTimestamp = r100.j();
        goto L3
    L8:
        this.fullPrice = am3.h.c(r100);
        goto L3
    L9:
        this.payType.add(Integer.valueOf(r100.i()));
        goto L3
    L10:
        this.pos = r100.j();
        goto L3
    L11:
        this.currency = am3.h.c(r100);
        goto L3
    L12:
        this.amount = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
    }
}
