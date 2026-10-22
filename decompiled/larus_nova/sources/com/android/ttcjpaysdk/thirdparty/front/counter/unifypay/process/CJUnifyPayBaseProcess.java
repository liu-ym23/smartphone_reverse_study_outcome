package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.process;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0004H&¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/process/CJUnifyPayBaseProcess;", "", "()V", WidgetCostModule.TYPE_ON_CREATE, "", LiveCommonConstants.REASON_ON_DEDTROY, "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CJUnifyPayBaseProcess {
    public CJUnifyPayBaseProcess() {
    }

    public abstract void onCreate();

    public abstract void onDestroy();
}
