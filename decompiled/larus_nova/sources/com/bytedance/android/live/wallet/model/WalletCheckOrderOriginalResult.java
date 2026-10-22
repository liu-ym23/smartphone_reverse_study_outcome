package com.bytedance.android.live.wallet.model;

import com.bytedance.android.ec.common.api.inflow.AnchorBenefitToast;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.BaseResponse;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class WalletCheckOrderOriginalResult extends BaseResponse<a, b> {
    public static final int FAIL = 0;
    public static final int SUCCESS = 1;
    private Exception exception;
    private String orderId;
    private String payChannel;
    private int retry;

    public static class a {

        @SerializedName("extra")
        public String extra;

        @SerializedName("status")
        public int status;

        public a() {
        }

        public final String toString() {
            return "CheckOrderData{status=" + this.status + '}';
        }
    }

    public static class b extends Extra {

        @SerializedName(AnchorBenefitToast.TYPE_COUPON)
        public String coupon;

        @SerializedName("coupon_description")
        public String couponDescription;

        @SerializedName("coupon_detail")
        private List<n> couponDetail;

        @SerializedName("deduct_amount")
        public long deductAmount;

        @SerializedName("rebate_amount")
        public long rebateAmount;

        @SerializedName("rebate_message")
        public String rebateMessage;

        @SerializedName("status")
        public int status;

        @SerializedName("success_toast")
        public String successToastMsg;

        public final String toString() {
            return "CheckOrderExtra{coupon='" + this.coupon + "', couponDescription='" + this.couponDescription + "'}";
        }

        public b() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a getData() {
        return (a) this.data;
    }

    public b getExtra() {
        return (b) this.extra;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int getStatus() {
        T r100 = this.data;
        if (r100 != 0) goto L6;
        return 0;
    L6:
        return ((a) r100).status;
    }

    public String toString() {
        return "WalletCheckOrderOriginalResult{data=" + this.data + ", extra=" + this.extra + ", retry=" + this.retry + ", orderId='" + this.orderId + "', exception=" + this.exception + '}';
    }

    public WalletCheckOrderOriginalResult() {
    }

    public Exception getException() {
        return this.exception;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getPayChannel() {
        return this.payChannel;
    }

    public int getRetry() {
        return this.retry;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setData(a r100) {
        this.data = r100;
    }

    public WalletCheckOrderOriginalResult setException(Exception r100) {
        this.exception = r100;
        return this;
    }

    public void setExtra(b r100) {
        this.extra = r100;
    }

    public WalletCheckOrderOriginalResult setOrderId(String r100) {
        this.orderId = r100;
        return this;
    }

    public void setPayChannel(String r100) {
        this.payChannel = r100;
    }

    public WalletCheckOrderOriginalResult setRetry(int r100) {
        this.retry = r100;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, com.bytedance.android.live.wallet.model.WalletCheckOrderOriginalResult$a] */
    public WalletCheckOrderOriginalResult setStatus(int r100) {
        if (this.data != 0) goto L5;
        this.data = new a();
    L5:
        ((a) this.data).status = r100;
        return this;
    }
}
