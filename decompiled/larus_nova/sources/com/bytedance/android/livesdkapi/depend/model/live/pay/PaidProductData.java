package com.bytedance.android.livesdkapi.depend.model.live.pay;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\f\rB\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PaidProductData;", "", "()V", "bringProductFlag", "", "Ljava/lang/Integer;", "bringProductStatus", "explainCard", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PaidProductData$ExplainCard;", "productList", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PaidProductData$ToolBar;", "toolBar", "ExplainCard", "ToolBar", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PaidProductData implements h {

    @SerializedName("paid_live_bringing_product_flag")
    public Integer bringProductFlag;

    @SerializedName("bring_product_switch_status")
    public Integer bringProductStatus;

    @SerializedName("explain_card")
    public ExplainCard explainCard;

    @SerializedName("product_list_tool_bar")
    public ToolBar productList;

    @SerializedName("tool_bar")
    public ToolBar toolBar;

    @ForMain
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PaidProductData$ExplainCard;", "", "()V", "cardJumpUrl", "", "product", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/Product;", "status", "", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ExplainCard implements h {

        @SerializedName("card_jump_url")
        public String cardJumpUrl;

        @SerializedName("product")
        public Product product;

        @SerializedName("status")
        public int status;

        public ExplainCard() {
        }

        public ExplainCard(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L15;
            if (r102 != 1) goto L8;
            this.status = r100.i();
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.cardJumpUrl = am3.h.c(r100);
            goto L3
        L10:
            if (r102 != 4) goto L11;
            this.product = new Product(r100);
            goto L3
        L11:
            am3.h.e(r100);
            goto L3
        L15:
            r100.d(r101);
        }
    }

    @ForMain
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PaidProductData$ToolBar;", "", "()V", "nineJumpUrl", "", "panelJumpUrl", "sixJumpUrl", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ToolBar implements h {

        @SerializedName("nine_jump_url")
        public String nineJumpUrl;

        @SerializedName("panel_jump_url")
        public String panelJumpUrl;

        @SerializedName("six_jump_url")
        public String sixJumpUrl;

        public ToolBar() {
        }

        public ToolBar(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L15;
            if (r102 != 1) goto L8;
            this.panelJumpUrl = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.sixJumpUrl = am3.h.c(r100);
            goto L3
        L10:
            if (r102 != 3) goto L11;
            this.nineJumpUrl = am3.h.c(r100);
            goto L3
        L11:
            am3.h.e(r100);
            goto L3
        L15:
            r100.d(r101);
        }
    }

    public PaidProductData() {
    }

    public PaidProductData(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.toolBar = new ToolBar(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.explainCard = new ExplainCard(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.productList = new ToolBar(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.bringProductStatus = Integer.valueOf(r100.i());
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.bringProductFlag = Integer.valueOf(r100.i());
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }
}
