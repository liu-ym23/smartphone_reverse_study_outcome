package com.android.ttcjpaysdk.bdpay.counter.outer.unifypay.utils;

import com.android.ttcjpaysdk.integrated.counter.data.unifypay.ICJUnifyPayTradeCreateResp;
import com.android.ttcjpaysdk.thirdparty.data.CJPayCheckoutCounterResponseBean;
import com.android.ttcjpaysdk.thirdparty.data.unifypay.UnifyCashierRenderInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/unifypay/utils/CJUnifyBdTradeCreateBean;", "Lcom/android/ttcjpaysdk/integrated/counter/data/unifypay/ICJUnifyPayTradeCreateResp;", "counterResponse", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCheckoutCounterResponseBean;", "(Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCheckoutCounterResponseBean;)V", "getCode", "", "getErrorMsg", "getFeMetrics", "Lorg/json/JSONObject;", "getProcess", "getUnifyCashierRenderInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo;", "isSuccess", "", "Companion", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyBdTradeCreateBean implements ICJUnifyPayTradeCreateResp {
    public static final Companion Companion = null;
    private final CJPayCheckoutCounterResponseBean counterResponse;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/unifypay/utils/CJUnifyBdTradeCreateBean$Companion;", "", "()V", "buildUnifyPayResponse", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/unifypay/utils/CJUnifyBdTradeCreateBean;", "response", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCheckoutCounterResponseBean;", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final CJUnifyBdTradeCreateBean buildUnifyPayResponse(CJPayCheckoutCounterResponseBean r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return new CJUnifyBdTradeCreateBean(r100);
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.data.unifypay.ICJUnifyPayTradeCreateResp
    public JSONObject getFeMetrics() {
        return null;
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.data.unifypay.ICJUnifyPayTradeCreateResp
    public String getCode() {
        return this.counterResponse.code;
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.data.unifypay.ICJUnifyPayTradeCreateResp
    public String getErrorMsg() {
        return this.counterResponse.msg;
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.data.unifypay.ICJUnifyPayTradeCreateResp
    public String getProcess() {
        return this.counterResponse.process_info.toString();
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.data.unifypay.ICJUnifyPayTradeCreateResp
    public UnifyCashierRenderInfo getUnifyCashierRenderInfo() {
        return this.counterResponse.unify_page_info;
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.data.unifypay.ICJUnifyPayTradeCreateResp
    public boolean isSuccess() {
        return this.counterResponse.isResponseOk();
    }

    public CJUnifyBdTradeCreateBean(CJPayCheckoutCounterResponseBean r100) {
        Intrinsics.checkNotNullParameter(r100, "counterResponse");
        this.counterResponse = r100;
    }
}
