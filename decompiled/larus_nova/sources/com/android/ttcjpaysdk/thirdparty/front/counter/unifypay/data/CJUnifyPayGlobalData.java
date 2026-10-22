package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data;

import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.thirdparty.data.unifypay.UnifyCashierRenderInfo;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.adapter.CJUnifyPayAdapterProxy;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/CJUnifyPayGlobalData;", "", "()V", "businessParams", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/CJUnifyPayBusinessParams;", "hostInfo", "Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "unifyPayAdapter", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/adapter/CJUnifyPayAdapterProxy;", "unifyRenderInfoData", "Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo;", "Companion", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyPayGlobalData {
    public static final Companion Companion = null;
    public static final String TAG = "UnifyPay";
    private static final LinkedHashMap<Long, CJUnifyPayGlobalData> unifyPayData = null;
    public CJUnifyPayBusinessParams businessParams;
    public CJPayHostInfo hostInfo;
    public CJUnifyPayAdapterProxy unifyPayAdapter;
    public UnifyCashierRenderInfo unifyRenderInfoData;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R1\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/CJUnifyPayGlobalData$Companion;", "", "()V", "TAG", "", "unifyPayData", "Ljava/util/LinkedHashMap;", "", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/CJUnifyPayGlobalData;", "Lkotlin/collections/LinkedHashMap;", "getUnifyPayData", "()Ljava/util/LinkedHashMap;", "getData", "configId", "(Ljava/lang/Long;)Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/CJUnifyPayGlobalData;", "getDataBean", "Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo;", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final LinkedHashMap<Long, CJUnifyPayGlobalData> getUnifyPayData() {
            return CJUnifyPayGlobalData.access$getUnifyPayData$cp();
        }

        public final CJUnifyPayGlobalData getData(Long r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return getUnifyPayData().get(r100);
        }

        public final UnifyCashierRenderInfo getDataBean(long r100) {
            CJUnifyPayGlobalData r101 = getData(Long.valueOf(r100));
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.unifyRenderInfoData;
        }
    }

    static {
        Companion = new Companion(null);
        unifyPayData = new LinkedHashMap();
    }

    public CJUnifyPayGlobalData() {
        this.businessParams = new CJUnifyPayBusinessParams();
    }

    public static final /* synthetic */ LinkedHashMap access$getUnifyPayData$cp() {
        return unifyPayData;
    }
}
