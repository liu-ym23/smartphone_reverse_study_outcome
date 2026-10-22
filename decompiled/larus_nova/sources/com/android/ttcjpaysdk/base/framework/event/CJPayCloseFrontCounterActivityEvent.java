package com.android.ttcjpaysdk.base.framework.event;

import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJPayCloseFrontCounterActivityEvent;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "token", "", "(Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayCloseFrontCounterActivityEvent extends BaseEvent {
    private final String token;

    public final String getToken() {
        return this.token;
    }

    public CJPayCloseFrontCounterActivityEvent(String r100) {
        this.token = r100;
    }
}
