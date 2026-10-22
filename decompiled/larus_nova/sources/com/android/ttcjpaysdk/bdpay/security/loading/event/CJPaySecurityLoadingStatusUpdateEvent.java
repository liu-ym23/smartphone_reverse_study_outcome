package com.android.ttcjpaysdk.bdpay.security.loading.event;

import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import com.android.ttcjpaysdk.bdpay.security.loading.data.CJPaySecurityLoadingBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/security/loading/event/CJPaySecurityLoadingStatusUpdateEvent;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "loadingBean", "Lcom/android/ttcjpaysdk/bdpay/security/loading/data/CJPaySecurityLoadingBean;", "(Lcom/android/ttcjpaysdk/bdpay/security/loading/data/CJPaySecurityLoadingBean;)V", "getLoadingBean", "()Lcom/android/ttcjpaysdk/bdpay/security/loading/data/CJPaySecurityLoadingBean;", "bdpay-security-loading_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPaySecurityLoadingStatusUpdateEvent extends BaseEvent {
    private final CJPaySecurityLoadingBean loadingBean;

    public final CJPaySecurityLoadingBean getLoadingBean() {
        return this.loadingBean;
    }

    public CJPaySecurityLoadingStatusUpdateEvent(CJPaySecurityLoadingBean r100) {
        Intrinsics.checkNotNullParameter(r100, "loadingBean");
        this.loadingBean = r100;
    }
}
