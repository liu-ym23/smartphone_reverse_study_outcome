package com.android.ttcjpaysdk.base.h5.event;

import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/event/CJPayWebViewNotificationEvent;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "data", "", "type", "(Ljava/lang/String;Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "getType", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayWebViewNotificationEvent extends BaseEvent {
    private final String data;
    private final String type;

    public final String getData() {
        return this.data;
    }

    public final String getType() {
        return this.type;
    }

    public CJPayWebViewNotificationEvent(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.data = r100;
        this.type = r101;
    }
}
