package com.android.ttcjpaysdk.base.framework.event;

import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJPayCounterSwitchAccountEvent;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "disableOutPayListener", "", "(Z)V", "getDisableOutPayListener", "()Z", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayCounterSwitchAccountEvent extends BaseEvent {
    private final boolean disableOutPayListener;

    public final boolean getDisableOutPayListener() {
        return this.disableOutPayListener;
    }

    public CJPayCounterSwitchAccountEvent(boolean r100) {
        this.disableOutPayListener = r100;
    }
}
