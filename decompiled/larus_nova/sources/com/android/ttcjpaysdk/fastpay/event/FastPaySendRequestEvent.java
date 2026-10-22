package com.android.ttcjpaysdk.fastpay.event;

import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/fastpay/event/FastPaySendRequestEvent;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "params", "", "", "(Ljava/util/Map;)V", "getParams", "()Ljava/util/Map;", "fastpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FastPaySendRequestEvent extends BaseEvent {
    private final Map<String, String> params;

    public final Map<String, String> getParams() {
        return this.params;
    }

    public FastPaySendRequestEvent(Map<String, String> r100) {
        this.params = r100;
    }
}
