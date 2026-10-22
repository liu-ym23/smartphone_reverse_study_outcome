package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.operation.utils;

import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.utils.CJUnifyPayEventUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/operation/utils/OperationEventUtils;", "", "()V", "signDetailsImp", "", "map", "", "", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OperationEventUtils {
    public static final OperationEventUtils INSTANCE = null;

    static {
        INSTANCE = new OperationEventUtils();
    }

    private OperationEventUtils() {
    }

    public final void signDetailsImp(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        CJUnifyPayEventUtils.INSTANCE.uploadEvent("wallet_cashier_sign_details_imp", r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void signDetailsImp$default(OperationEventUtils r100, Map r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = new LinkedHashMap();
    L5:
        r100.signDetailsImp(r101);
    }
}
