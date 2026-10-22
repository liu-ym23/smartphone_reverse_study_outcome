package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.req;

import com.alipay.sdk.m.k.b;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/req/CJUnifyPayTradeQueryBizContentParams;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "byte_pay_param", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/req/CJUnifyPayTradeQueryBizContentParams$BytePayParams;", "getByte_pay_param", "()Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/req/CJUnifyPayTradeQueryBizContentParams$BytePayParams;", "setByte_pay_param", "(Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/req/CJUnifyPayTradeQueryBizContentParams$BytePayParams;)V", b.B0, "", "getTrade_no", "()Ljava/lang/String;", "setTrade_no", "(Ljava/lang/String;)V", "toJsonString", "BytePayParams", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyPayTradeQueryBizContentParams implements CJPayObject {
    private BytePayParams byte_pay_param;
    private String trade_no;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/req/CJUnifyPayTradeQueryBizContentParams$BytePayParams;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "exts", "Lorg/json/JSONObject;", "getExts", "()Lorg/json/JSONObject;", "setExts", "(Lorg/json/JSONObject;)V", "process_info", "getProcess_info", "setProcess_info", "toString", "", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BytePayParams implements CJPayObject {
        private JSONObject exts;
        private JSONObject process_info;

        public BytePayParams() {
        }

        public String toString() {
            JSONObject r100 = new JSONObject();
            JSONObject r101 = this.process_info;
            if (r101 == null) goto L5;
            KtSafeMethodExtensionKt.safePut(r100, "process_info", r101);
        L5:
            JSONObject r102 = this.exts;
            if (r102 == null) goto L9;
            KtSafeMethodExtensionKt.safePut(r100, "exts", r102);
        L9:
            return r100.toString();
        }

        public final JSONObject getExts() {
            return this.exts;
        }

        public final JSONObject getProcess_info() {
            return this.process_info;
        }

        public final void setExts(JSONObject r100) {
            this.exts = r100;
        }

        public final void setProcess_info(JSONObject r100) {
            this.process_info = r100;
        }
    }

    public CJUnifyPayTradeQueryBizContentParams() {
    }

    public final String toJsonString() {
        JSONObject r100 = new JSONObject();
        BytePayParams r101 = this.byte_pay_param;
        if (r101 == null) goto L5;
        KtSafeMethodExtensionKt.safePut(r100, "byte_pay_param", r101.toString());
    L5:
        String r102 = this.trade_no;
        if (r102 == null) goto L9;
        KtSafeMethodExtensionKt.safePut(r100, b.B0, r102);
    L9:
        return r100.toString();
    }

    public final BytePayParams getByte_pay_param() {
        return this.byte_pay_param;
    }

    public final String getTrade_no() {
        return this.trade_no;
    }

    public final void setByte_pay_param(BytePayParams r100) {
        this.byte_pay_param = r100;
    }

    public final void setTrade_no(String r100) {
        this.trade_no = r100;
    }
}
