package com.android.ttcjpaysdk.base.h5;

import com.bytedance.caijing.sdk.infra.base.api.container.old_container.CJExternalEventService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/CJPayLynxEventApi;", "", "()V", "lynxEventService", "Lcom/bytedance/caijing/sdk/infra/base/api/container/old_container/CJExternalEventService;", "getLynxEventService", "()Lcom/bytedance/caijing/sdk/infra/base/api/container/old_container/CJExternalEventService;", "lynxEventService$delegate", "Lkotlin/Lazy;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayLynxEventApi {
    public static final CJPayLynxEventApi INSTANCE = null;
    private static final Lazy lynxEventService$delegate = null;

    private CJPayLynxEventApi() {
    }

    static {
        INSTANCE = new CJPayLynxEventApi();
        lynxEventService$delegate = LazyKt.lazy(CJPayLynxEventApi$lynxEventService$2.INSTANCE);
    }

    public final CJExternalEventService getLynxEventService() {
        return (CJExternalEventService) lynxEventService$delegate.getValue();
    }
}
