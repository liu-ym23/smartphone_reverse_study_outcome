package com.android.ttcjpaysdk.base.framework.event;

import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJPayCloseDyPayBaseActivityEvent;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "token", "", "(Ljava/lang/String;)V", "isForceClose", "", "getToken", "()Ljava/lang/String;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayCloseDyPayBaseActivityEvent extends BaseEvent {
    public boolean isForceClose;
    private final String token;

    public final String getToken() {
        return this.token;
    }

    public CJPayCloseDyPayBaseActivityEvent(String r100) {
        this.token = r100;
    }
}
