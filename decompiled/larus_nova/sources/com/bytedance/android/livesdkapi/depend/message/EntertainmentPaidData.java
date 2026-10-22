package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.EntertainmentPaidData")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/EntertainmentPaidData;", "", "()V", "businessType", "", "currentItemInfo", "Lcom/bytedance/android/livesdkapi/depend/message/ItemContentInfo;", "itemInfoList", "", "orderId", "", "paidExtraData", "paymentOrderType", "productInfoList", "Lcom/bytedance/android/livesdkapi/depend/message/ProductSimpleInfo;", "purchaseFromSourceType", "rightType", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EntertainmentPaidData implements h {

    @SerializedName("business_type")
    public int businessType;

    @SerializedName("current_item_info")
    public ItemContentInfo currentItemInfo;

    @SerializedName("item_info_list")
    public List<ItemContentInfo> itemInfoList;

    @SerializedName("order_id")
    public String orderId;

    @SerializedName("paid_extra_data")
    public String paidExtraData;

    @SerializedName("payment_order_type")
    public int paymentOrderType;

    @SerializedName("product_info_list")
    public List<ProductSimpleInfo> productInfoList;

    @SerializedName("purchase_from_source_type")
    public int purchaseFromSourceType;

    @SerializedName("right_type")
    public int rightType;

    public EntertainmentPaidData() {
        this.orderId = "";
        this.paidExtraData = "";
    }

    public EntertainmentPaidData(g r100) {
        this.productInfoList = new ArrayList();
        this.itemInfoList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L17;
        switch(r102) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L6;
        };
    L7:
        this.paidExtraData = am3.h.c(r100);
        goto L3
    L8:
        this.orderId = am3.h.c(r100);
        goto L3
    L9:
        this.purchaseFromSourceType = r100.i();
        goto L3
    L10:
        this.paymentOrderType = r100.i();
        goto L3
    L11:
        this.currentItemInfo = new ItemContentInfo(r100);
        goto L3
    L12:
        List r103 = this.itemInfoList;
        h r104 = new ItemContentInfo(r100);
    L14:
        r103.add(r104);
        goto L3
    L13:
        r103 = this.productInfoList;
        r104 = new ProductSimpleInfo(r100);
        goto L14
    L15:
        this.businessType = r100.i();
        goto L3
    L16:
        this.rightType = r100.i();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
        if (this.orderId != null) goto L21;
        this.orderId = "";
    L21:
        if (this.paidExtraData != null) goto L45;
        this.paidExtraData = "";
        return;
    }
}
