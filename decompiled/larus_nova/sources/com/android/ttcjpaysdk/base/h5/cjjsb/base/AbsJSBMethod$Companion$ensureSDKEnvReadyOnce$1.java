package com.android.ttcjpaysdk.base.h5.cjjsb.base;

import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayIntegratedCounterService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import we4.a;
import we4.b;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod$Companion$ensureSDKEnvReadyOnce$1", "Lwe4/a;", "Ltd4/a;", "Lwe4/b;", "result", "", "onResult", "base-context_release"}, k = 1, mv = {1, 6, 0})
public final class AbsJSBMethod$Companion$ensureSDKEnvReadyOnce$1 implements a<td4.a> {
    public AbsJSBMethod$Companion$ensureSDKEnvReadyOnce$1() {
    }

    @Override // we4.a
    public void onResult(b<td4.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        ICJPayIntegratedCounterService r101 = (ICJPayIntegratedCounterService) CJPayServiceManager.getInstance().getIService(ICJPayIntegratedCounterService.class);
        if (r101 == null) goto L6;
        r101.ttcjPayInvokeInit();
        return;
    }
}
