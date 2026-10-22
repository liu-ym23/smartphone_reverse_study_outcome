package com.android.ttcjpaysdk.thirdparty.front.counter.dypay.process;

import com.android.ttcjpaysdk.thirdparty.front.counter.dypay.bean.DyPayData;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/dypay/process/DyPayBaseProcess;", "", "data", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/dypay/bean/DyPayData;", "(Lcom/android/ttcjpaysdk/thirdparty/front/counter/dypay/bean/DyPayData;)V", "getData", "()Lcom/android/ttcjpaysdk/thirdparty/front/counter/dypay/bean/DyPayData;", "setData", WidgetCostModule.TYPE_ON_CREATE, "", LiveCommonConstants.REASON_ON_DEDTROY, "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class DyPayBaseProcess {
    private DyPayData data;

    public abstract void onCreate();

    public abstract void onDestroy();

    public final DyPayData getData() {
        return this.data;
    }

    public DyPayBaseProcess(DyPayData r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.data = r100;
    }

    public final void setData(DyPayData r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.data = r100;
    }
}
