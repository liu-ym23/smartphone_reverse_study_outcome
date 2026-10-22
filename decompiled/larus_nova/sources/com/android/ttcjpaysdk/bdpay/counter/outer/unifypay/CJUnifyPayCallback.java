package com.android.ttcjpaysdk.bdpay.counter.outer.unifypay;

import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/unifypay/CJUnifyPayCallback;", "", "onFinishPayment", "", "code", "", "callbackInfo", "", "", "(Ljava/lang/Integer;Ljava/util/Map;)V", "onPageRenderEnd", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CJUnifyPayCallback {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void onFinishPayment$default(CJUnifyPayCallback r100, Integer r101, Map r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.onFinishPayment(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFinishPayment");
        }
    }

    void onFinishPayment(Integer r100, Map<String, String> r101);

    void onPageRenderEnd();
}
