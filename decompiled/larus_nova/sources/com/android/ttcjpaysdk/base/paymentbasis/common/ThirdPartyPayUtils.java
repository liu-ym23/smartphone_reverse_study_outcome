package com.android.ttcjpaysdk.base.paymentbasis.common;

import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/base/paymentbasis/common/ThirdPartyPayUtils;", "", "()V", "Companion", "base-pay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ThirdPartyPayUtils {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/base/paymentbasis/common/ThirdPartyPayUtils$Companion;", "", "()V", "getMerchantId", "", "base-pay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final String getMerchantId() {
            JSONObject r100 = CJPayCallBackCenter.getInstance().getTrackInfo();
            if (r100 == null) goto L5;
            String r101 = r100.optString("merchant_id");
        L6:
            if (r101 != null) goto L9;
            return "";
        L9:
            return r101;
        L5:
            r101 = null;
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ThirdPartyPayUtils() {
    }
}
