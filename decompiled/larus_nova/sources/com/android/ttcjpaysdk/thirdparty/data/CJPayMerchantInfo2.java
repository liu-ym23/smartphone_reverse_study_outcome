package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\"\u001a\u00020#R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001a\u0010\u001f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\t¨\u0006$"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/CJPayMerchantInfo2;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "app_id", "", "getApp_id", "()Ljava/lang/String;", "setApp_id", "(Ljava/lang/String;)V", "ext_uid_type", "", "getExt_uid_type", "()I", "setExt_uid_type", "(I)V", "jh_app_id", "getJh_app_id", "setJh_app_id", "jh_merchant_id", "getJh_merchant_id", "setJh_merchant_id", "merchant_id", "getMerchant_id", "setMerchant_id", "merchant_name", "getMerchant_name", "setMerchant_name", "merchant_short_name", "getMerchant_short_name", "setMerchant_short_name", "merchant_short_to_customer", "getMerchant_short_to_customer", "setMerchant_short_to_customer", "toOriMerchantInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayMerchantInfo;", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayMerchantInfo2 implements CJPayObject, Serializable {
    private String app_id;
    private int ext_uid_type;
    private String jh_app_id;
    private String jh_merchant_id;
    private String merchant_id;
    private String merchant_name;
    private String merchant_short_name;
    private String merchant_short_to_customer;

    public final CJPayMerchantInfo toOriMerchantInfo() {
        CJPayMerchantInfo r100 = new CJPayMerchantInfo();
        r100.ext_uid_type = this.ext_uid_type;
        r100.merchant_id = this.merchant_id;
        r100.merchant_name = this.merchant_name;
        r100.merchant_short_to_customer = this.merchant_short_to_customer;
        r100.app_id = this.app_id;
        r100.jh_merchant_id = this.jh_merchant_id;
        r100.jh_app_id = this.jh_app_id;
        r100.merchant_short_name = this.merchant_short_name;
        return r100;
    }

    public CJPayMerchantInfo2() {
        this.merchant_id = "";
        this.merchant_name = "";
        this.merchant_short_to_customer = "";
        this.app_id = "";
        this.jh_merchant_id = "";
        this.jh_app_id = "";
        this.merchant_short_name = "";
    }

    public final String getApp_id() {
        return this.app_id;
    }

    public final int getExt_uid_type() {
        return this.ext_uid_type;
    }

    public final String getJh_app_id() {
        return this.jh_app_id;
    }

    public final String getJh_merchant_id() {
        return this.jh_merchant_id;
    }

    public final String getMerchant_id() {
        return this.merchant_id;
    }

    public final String getMerchant_name() {
        return this.merchant_name;
    }

    public final String getMerchant_short_name() {
        return this.merchant_short_name;
    }

    public final String getMerchant_short_to_customer() {
        return this.merchant_short_to_customer;
    }

    public final void setApp_id(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.app_id = r100;
    }

    public final void setExt_uid_type(int r100) {
        this.ext_uid_type = r100;
    }

    public final void setJh_app_id(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.jh_app_id = r100;
    }

    public final void setJh_merchant_id(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.jh_merchant_id = r100;
    }

    public final void setMerchant_id(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.merchant_id = r100;
    }

    public final void setMerchant_name(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.merchant_name = r100;
    }

    public final void setMerchant_short_name(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.merchant_short_name = r100;
    }

    public final void setMerchant_short_to_customer(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.merchant_short_to_customer = r100;
    }
}
