package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.homepage;

import androidx.exifinterface.media.ExifInterface;
import com.android.ttcjpaysdk.base.network.ICJPayNetWorkCallback;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&¢\u0006\u0002\u0010\tJ0\u0010\n\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/CJUnifyPayHomepageCallback;", "", "onFinishPayment", "", "code", "", "callbackInfo", "", "", "(Ljava/lang/Integer;Ljava/util/Map;)V", "onUnifyPayRefreshPageAction", ExifInterface.GPS_DIRECTION_TRUE, "param", "callback", "Lcom/android/ttcjpaysdk/base/network/ICJPayNetWorkCallback;", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CJUnifyPayHomepageCallback {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void onFinishPayment$default(CJUnifyPayHomepageCallback r100, Integer r101, Map r102, int r103, Object r104) {
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

    <T> void onUnifyPayRefreshPageAction(Map<String, String> r100, ICJPayNetWorkCallback<T> r101);
}
