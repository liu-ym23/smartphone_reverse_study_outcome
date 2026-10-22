package com.bytedance.android.livesdkapi.depend.model.live.pay;

import am3.g;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PurchaseSimpleData;", "", "()V", "closingSellTime", "", "name", "", "priceInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/ProductPriceStruct;", "purchaseStatus", "", "sellStatus", "startSellTime", PromotionProductPrivilegesStruct.TAGS, "", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/ProductTag;", "type", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PurchaseSimpleData implements h {

    @SerializedName("closing_sell_time")
    public long closingSellTime;

    @SerializedName("name")
    public String name;

    @SerializedName(a.KEY_PRICE_INFO)
    public ProductPriceStruct priceInfo;

    @SerializedName("purchase_status")
    public int purchaseStatus;

    @SerializedName("sell_status")
    public int sellStatus;

    @SerializedName("start_sell_time")
    public long startSellTime;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    public List<ProductTag> tags;

    @SerializedName("type")
    public int type;

    public PurchaseSimpleData() {
    }

    public PurchaseSimpleData(g r100) {
        this.tags = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        switch(r102) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        this.priceInfo = new ProductPriceStruct(r100);
        goto L3
    L8:
        this.purchaseStatus = r100.i();
        goto L3
    L9:
        this.sellStatus = r100.i();
        goto L3
    L10:
        this.closingSellTime = r100.j();
        goto L3
    L11:
        this.startSellTime = r100.j();
        goto L3
    L12:
        this.tags.add(new ProductTag(r100));
        goto L3
    L13:
        this.name = am3.h.c(r100);
        goto L3
    L14:
        this.type = r100.i();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }
}
